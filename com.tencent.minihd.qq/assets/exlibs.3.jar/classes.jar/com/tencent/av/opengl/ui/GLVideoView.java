package com.tencent.av.opengl.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView.ScaleType;
import com.tencent.av.opengl.glrender.GLCanvas;
import com.tencent.av.opengl.glrender.GLPaint;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.opengl.texture.StringTexture;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.texture.YUVTexture.GLRenderListener;
import com.tencent.av.opengl.utils.StackBlur;
import com.tencent.av.utils.UITools;
import com.tencent.qav.log.AVLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GLVideoView
  extends GLView
{
  static final int BLUR_RATE = 20;
  private static final long LOADING_ELAPSE = 80L;
  static final int SCALE_RATE = 4;
  private static final String TAG = "GLVideoView";
  private static final int Tag_Index_Uin = 0;
  private static final int Tag_Index_VideoSrcType = 1;
  public static final float mAllowableZoomOvershot = 1.111111F;
  protected Context mContext;
  private int mCurrentAngle = 0;
  private int mCurrentHeight = 0;
  private int mCurrentWidth = 0;
  protected RectF mDrawableRectF;
  protected RectF mDstRectF;
  private boolean mEnableBorder = true;
  protected boolean mFaceDetectBlur = false;
  protected BitmapTexture mForceGround;
  protected GLPaint mGlPaint;
  protected boolean mHasFlur = true;
  protected boolean mIsPC = false;
  boolean mIsSmallScreen = false;
  boolean mKeepAspectRatio = true;
  protected long mLastLoadingTime = 0L;
  long mLastUpDateTime = 0L;
  protected boolean mLoading = false;
  protected int mLoadingAngle = 0;
  Runnable mLoadingRunnable = new Runnable()
  {
    public void run()
    {
      GLRootView localGLRootView = GLVideoView.this.getGLRootView();
      if (localGLRootView != null)
      {
        GLVideoView.this.invalidate();
        localGLRootView.postDelayed(GLVideoView.this.mLoadingRunnable, 80L);
      }
    }
  };
  protected BasicTexture mLoadingTexture;
  LogInfo mLogInfo = null;
  private final float[] mMatrixValues = new float[9];
  protected int mMaxLength = 2147483647;
  private float mMaxZoomScale = 5.0F;
  private float mMinZoomScale = 1.0F;
  protected boolean mMirror = false;
  protected boolean mNeedRenderVideo = true;
  private int mRotationType = 0;
  private ImageView.ScaleType mScaleType;
  protected String mSelfUin = "";
  private boolean mShowText = false;
  int mSmallScreenTextOffset = 0;
  protected RectF mSrcRectF;
  protected BasicTexture mStringBgTexture;
  protected StringTexture mStringTexture;
  protected String mText = null;
  protected boolean mTextChanged = false;
  protected int mTextColor = -1;
  protected boolean mTextInBottom = true;
  protected float mTextSize = 20.0F;
  protected Matrix mTransformMatrix;
  private Matrix mTransformMatrixTmp;
  protected YUVTexture mYuvTexture;
  protected boolean misDoubleScreen = false;
  
  public GLVideoView(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public GLVideoView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mGlPaint = new GLPaint();
    AVLog.d("GLVideoView", String.format("GLVideoView renderEndPtr=%s", new Object[] { Integer.valueOf(paramInt) }));
    this.mYuvTexture = new YUVTexture(this.mContext, paramInt);
    this.mYuvTexture.setGLRenderListener(new YUVTexture.GLRenderListener()
    {
      public void onFaceFeatureUpdate(byte[] paramAnonymousArrayOfByte) {}
      
      public void onRenderFlush()
      {
        GLVideoView.this.invalidate();
      }
      
      public void onRenderFrame()
      {
        GLVideoView.this.invalidate();
      }
      
      public void onRenderInfoNotify(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        GLVideoView.access$002(GLVideoView.this, paramAnonymousInt1);
        GLVideoView.access$102(GLVideoView.this, paramAnonymousInt2);
        GLVideoView.access$202(GLVideoView.this, paramAnonymousInt3);
        paramAnonymousInt1 = GLVideoView.converToRotationType(paramAnonymousInt4);
        if (paramAnonymousInt4 != -1) {
          GLVideoView.access$302(GLVideoView.this, paramAnonymousInt1);
        }
        GLVideoView.this.invalidate();
      }
      
      public void onRenderReset()
      {
        GLVideoView.this.invalidate();
      }
    });
    this.mScaleType = ImageView.ScaleType.CENTER_INSIDE;
    this.mTransformMatrixTmp = new Matrix();
    this.mTransformMatrix = new Matrix();
    this.mDrawableRectF = new RectF();
    this.mSrcRectF = new RectF();
    this.mDstRectF = new RectF();
  }
  
  private Bitmap BlurBitmap(Bitmap paramBitmap)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = null;
    if (paramBitmap != null) {
      localBitmap1 = localBitmap2;
    }
    try
    {
      localBitmap2 = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 4, paramBitmap.getHeight() / 4, true);
      localBitmap1 = localBitmap2;
      Canvas localCanvas = new Canvas();
      localBitmap1 = localBitmap2;
      localCanvas.setBitmap(localBitmap2);
      localBitmap1 = localBitmap2;
      localCanvas.drawColor(Color.parseColor("#10ffffff"), PorterDuff.Mode.LIGHTEN);
      localBitmap1 = localBitmap2;
      StackBlur.fastBlur(localBitmap2, 20);
      localBitmap1 = localBitmap2;
      paramBitmap = Bitmap.createScaledBitmap(localBitmap2, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
      localBitmap1 = paramBitmap;
      return localBitmap1;
    }
    catch (Throwable paramBitmap)
    {
      AVLog.d("GLVideoView", "BlurBitmap fail.", paramBitmap);
    }
    return localBitmap1;
  }
  
  public static int[] I420toARGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramArrayOfByte == null)
    {
      localObject = null;
      return localObject;
    }
    int n = 0;
    int m = paramInt2;
    if (paramInt2 < 0)
    {
      m = -paramInt2;
      n = 1;
    }
    int i2 = 0;
    int i1 = paramInt1;
    if (paramInt1 < 0)
    {
      i1 = -paramInt1;
      i2 = 1;
    }
    int i4 = i1 * m;
    for (;;)
    {
      int i;
      int j;
      int k;
      try
      {
        int[] arrayOfInt = new int[i4];
        paramInt1 = 0;
        localObject = arrayOfInt;
        if (paramInt1 >= i4) {
          break;
        }
        i = paramInt1 / i1 / 2 * (i1 / 2) + paramInt1 % i1 / 2;
        paramInt2 = paramArrayOfByte[paramInt1] & 0xFF;
        j = paramArrayOfByte[(i4 + i)] & 0xFF;
        k = paramArrayOfByte[(i4 / 4 + i4 + i)] & 0xFF;
        i = (int)(paramInt2 + 1.8556D * (j - 128));
        j = (int)(paramInt2 - (0.4681D * (k - 128) + 0.1872D * (j - 128)));
        k = (int)(paramInt2 + 1.5748D * (k - 128));
        if (i > 255)
        {
          paramInt2 = 255;
          if (j <= 255) {
            break label340;
          }
          i = 255;
          if (k <= 255) {
            break label353;
          }
          j = 255;
          int i3 = paramInt1;
          k = i3;
          if (n != 0) {
            k = (m - 1 - i3 / i1) * i1 + i3 % i1;
          }
          i3 = k;
          if (i2 != 0) {
            i3 = k / i1 * i1 + (i1 - 1) - k % i1;
          }
          arrayOfInt[i3] = (0xFF000000 | 0xFF0000 & j << 16 | 0xFF00 & i << 8 | paramInt2 & 0xFF);
          paramInt1 += 1;
          continue;
        }
        paramInt2 = i;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        return null;
      }
      if (i < 0)
      {
        paramInt2 = 0;
        continue;
        label340:
        i = j;
        if (j < 0)
        {
          i = 0;
          continue;
          label353:
          j = k;
          if (k < 0) {
            j = 0;
          }
        }
      }
    }
  }
  
  static int converToRotationType(int paramInt)
  {
    switch (paramInt % 360)
    {
    default: 
      return 0;
    case 270: 
      return 1;
    case 180: 
      return 2;
    }
    return 3;
  }
  
  private void drawMirror(GLCanvas paramGLCanvas, int paramInt)
  {
    if (this.mMirror)
    {
      if (paramInt % 2 == 0) {
        paramGLCanvas.scale(-1.0F, 1.0F, 1.0F);
      }
    }
    else {
      return;
    }
    paramGLCanvas.scale(1.0F, -1.0F, 1.0F);
  }
  
  static Pair<Integer, Integer> fixSizeByRotation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i;
    if (paramInt5 == 1)
    {
      i = paramInt3 - paramInt1;
      paramInt3 = paramInt2;
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(i));
      if (paramInt5 == 2)
      {
        paramInt3 -= paramInt1;
        i = paramInt4 - paramInt2;
      }
      else
      {
        paramInt3 = paramInt1;
        i = paramInt2;
        if (paramInt5 == 3)
        {
          paramInt3 = paramInt4 - paramInt2;
          i = paramInt1;
        }
      }
    }
  }
  
  private Bitmap getFrameBitmap()
  {
    Object localObject6 = this.mYuvTexture.getLastYuvFrameCapture();
    if (localObject6 == null)
    {
      AVLog.e("GLVideoView", "getFrameBitmap  fail.");
      return null;
    }
    int i = this.mYuvTexture.getLastYuvFrameCaptureWidth();
    int j = this.mYuvTexture.getLastYuvFrameCaptureHeight();
    int k = this.mYuvTexture.getLastYuvFormat();
    Object localObject1 = null;
    Bitmap localBitmap = null;
    Object localObject5 = null;
    Object localObject4 = null;
    if (k == 0)
    {
      localObject1 = I420toARGB((byte[])localObject6, i, j);
      if (localObject1 == null)
      {
        AVLog.d("GLVideoView", "getFrameBitmap  I420toARGB failed, type=" + k);
        return null;
      }
      try
      {
        localObject1 = Bitmap.createBitmap((int[])localObject1, i, j, Bitmap.Config.ARGB_8888);
        localObject4 = localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          AVLog.d("GLVideoView", "getFrameBitmap OOM exception e.stack " + localOutOfMemoryError1.getStackTrace());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AVLog.d("GLVideoView", "getFrameBitmap exception e.stack " + localException.getStackTrace());
        }
      }
      localObject1 = localObject4;
      if (localObject4 != null) {
        break label316;
      }
      AVLog.d("GLVideoView", "getFrameBitmap createBitmap failed");
      return null;
    }
    localObject6 = new YuvImage((byte[])localObject6, 17, i, j, null);
    Object localObject2;
    if (localObject6 != null)
    {
      localObject2 = localBitmap;
      localObject4 = localObject5;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject2 = localBitmap;
      localObject4 = localObject5;
      ((YuvImage)localObject6).compressToJpeg(new Rect(0, 0, i, j), 100, localByteArrayOutputStream);
      localObject2 = localBitmap;
      localObject4 = localObject5;
      localBitmap = BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size());
      localObject2 = localBitmap;
      localObject4 = localBitmap;
      localByteArrayOutputStream.close();
      localObject2 = localBitmap;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        AVLog.d("GLVideoView", "getFrameBitmap YuvImage close failed");
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      for (;;)
      {
        label316:
        AVLog.d("GLVideoView", "getFrameBitmap YuvImage close failed OOM");
        Object localObject3 = localIOException;
      }
    }
    AVLog.d("GLVideoView", "getFrameBitmap nWidth=" + i + ", nHeight=" + j);
    return localObject2;
  }
  
  private boolean hasBlackBorder(int paramInt)
  {
    if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE)
    {
      if (this.mIsPC) {}
      while (paramInt % 2 == 0) {
        return true;
      }
    }
    while (this.mScaleType != ImageView.ScaleType.CENTER_CROP) {
      return false;
    }
    return false;
  }
  
  public long GetLastRenderTime()
  {
    return this.mLastUpDateTime;
  }
  
  public void clearFourceGround()
  {
    if (this.mForceGround != null)
    {
      this.mForceGround.recycle();
      this.mForceGround = null;
    }
  }
  
  public boolean doStartRenderFouceGround()
  {
    boolean bool = false;
    try
    {
      if (this.mForceGround != null) {
        return false;
      }
      Bitmap localBitmap = getFrameBitmap();
      if (localBitmap == null) {
        return bool;
      }
      localBitmap = BlurBitmap(localBitmap);
      if (localBitmap == null)
      {
        AVLog.d("GLVideoView", "doStartRenderFouceGround BlurBitmap failed");
        return false;
      }
    }
    catch (Exception localException)
    {
      AVLog.d("GLVideoView", "doStartRenderFouceGround exception e.stack " + localException.getStackTrace());
      return false;
    }
    setFourceGround(localException);
    bool = true;
    return bool;
  }
  
  public void enableLoading(boolean paramBoolean)
  {
    GLRootView localGLRootView;
    if (this.mLoading != paramBoolean)
    {
      AVLog.d("GLVideoView", "enableLoading loading: " + paramBoolean + ", mLoading: " + this.mLoading);
      this.mLoading = paramBoolean;
      if (!paramBoolean) {
        break label81;
      }
      if (this.mLoadingTexture == null) {}
      localGLRootView = getGLRootView();
      if (localGLRootView != null) {
        localGLRootView.post(this.mLoadingRunnable);
      }
    }
    label81:
    do
    {
      return;
      localGLRootView = getGLRootView();
    } while (localGLRootView == null);
    localGLRootView.removeCallbacks(this.mLoadingRunnable);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.mStringBgTexture != null)
      {
        this.mStringBgTexture.recycle();
        this.mStringBgTexture = null;
      }
      if (this.mStringTexture != null)
      {
        this.mStringTexture.recycle();
        this.mStringTexture = null;
      }
      if (this.mLoadingTexture != null)
      {
        this.mLoadingTexture.recycle();
        this.mLoadingTexture = null;
      }
      if (this.mYuvTexture != null)
      {
        this.mYuvTexture.recycle();
        this.mYuvTexture = null;
      }
      if (this.mForceGround != null)
      {
        this.mForceGround.recycle();
        this.mForceGround = null;
      }
      this.mLoadingRunnable = null;
      this.mLoading = false;
      this.mShowText = false;
      this.mText = null;
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public void flush(boolean paramBoolean)
  {
    if (this.mYuvTexture != null) {}
    try
    {
      this.mYuvTexture.flush(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public String getDebugText()
  {
    return "TAG[GLVideoView], uin[" + getUin() + "], VST[" + getVideoSrcType() + "], LRT[" + GetLastRenderTime() + "], Drc[" + (int)this.mDstRectF.width() + ", " + (int)this.mDstRectF.height() + "], Src[" + (int)this.mSrcRectF.width() + ", " + (int)this.mSrcRectF.height() + "]";
  }
  
  public boolean getIsSmallScreen()
  {
    return this.mIsSmallScreen;
  }
  
  public int getMaxLength()
  {
    return this.mMaxLength;
  }
  
  public float getMaxZoomScale()
  {
    return this.mMaxZoomScale;
  }
  
  public float getMinZoomScale()
  {
    return this.mMinZoomScale;
  }
  
  public boolean getNeedRenderVideo()
  {
    return this.mNeedRenderVideo;
  }
  
  public int getRotation()
  {
    return this.mRotationType;
  }
  
  public float getScale()
  {
    this.mTransformMatrix.getValues(this.mMatrixValues);
    return this.mMatrixValues[0];
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.mScaleType;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public int getTextColor()
  {
    return this.mTextColor;
  }
  
  public float getTextSize()
  {
    return this.mTextSize;
  }
  
  public PointF getTranslation()
  {
    PointF localPointF = new PointF();
    this.mTransformMatrix.getValues(this.mMatrixValues);
    localPointF.x = this.mMatrixValues[2];
    localPointF.y = this.mMatrixValues[5];
    return localPointF;
  }
  
  public String getUin()
  {
    return (String)getTag(0);
  }
  
  public int getVideoSrcType()
  {
    Integer localInteger = (Integer)getTag(1);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  public YUVTexture getYuvTexture()
  {
    return this.mYuvTexture;
  }
  
  public boolean hasVideo()
  {
    boolean bool = false;
    try
    {
      if (this.mYuvTexture != null) {
        bool = this.mYuvTexture.canRender();
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean isLoading()
  {
    return this.mLoading;
  }
  
  public boolean isLocalView()
  {
    return this.mSelfUin.equals(getUin());
  }
  
  public boolean isMirror()
  {
    return this.mMirror;
  }
  
  public boolean isPC()
  {
    return this.mIsPC;
  }
  
  public boolean isShowText()
  {
    return this.mShowText;
  }
  
  public boolean isTextInBottom()
  {
    return this.mTextInBottom;
  }
  
  public void keepAspectRatio(boolean paramBoolean)
  {
    this.mKeepAspectRatio = paramBoolean;
  }
  
  protected void onDetachFromRoot()
  {
    GLRootView localGLRootView = getGLRootView();
    if (localGLRootView != null) {
      localGLRootView.removeCallbacks(this.mLoadingRunnable);
    }
    super.onDetachFromRoot();
  }
  
  protected void renderBackground(GLCanvas paramGLCanvas)
  {
    this.mEnableBorder = true;
    if (!this.mNeedRenderVideo) {
      this.mNeedRenderVideo = false;
    }
    int i = super.getWidth();
    int j = super.getHeight();
    Rect localRect = super.getPaddings();
    int k = i - localRect.left - localRect.right;
    int m = j - localRect.top - localRect.bottom;
    paramGLCanvas.translate(-i / 2, -j / 2);
    if (this.mEnableBorder)
    {
      this.mGlPaint.setColor(-9013642);
      if (localRect.left > 0)
      {
        this.mGlPaint.setLineWidth(localRect.left);
        paramGLCanvas.drawLine(localRect.left / 2, 0.0F, localRect.left / 2, j, this.mGlPaint);
      }
      if (localRect.top > 0)
      {
        this.mGlPaint.setLineWidth(localRect.top);
        paramGLCanvas.drawLine(0.0F, localRect.top / 2, i, localRect.top / 2, this.mGlPaint);
      }
      if (localRect.right > 0)
      {
        this.mGlPaint.setLineWidth(localRect.right);
        paramGLCanvas.drawLine(i - localRect.right / 2, 0.0F, i - localRect.right / 2, j, this.mGlPaint);
      }
      if (localRect.bottom > 0)
      {
        this.mGlPaint.setLineWidth(localRect.bottom);
        paramGLCanvas.drawLine(0.0F, j - localRect.bottom / 2, i, j - localRect.bottom / 2, this.mGlPaint);
      }
    }
    paramGLCanvas.translate(i / 2, j / 2);
    if (this.mEnableBorder) {
      if (((!hasVideo()) || (!this.mNeedRenderVideo)) && (this.mBackground != null)) {
        this.mBackground.draw(paramGLCanvas, 0, 0, k, m);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.misDoubleScreen);
      paramGLCanvas.fillRect(0, 0, k, m, this.mBackgroundColor);
      return;
      if (((!hasVideo()) || (!this.mNeedRenderVideo)) && (this.mBackground != null))
      {
        this.mBackground.draw(paramGLCanvas, 0, 0, i, j);
        return;
      }
    } while (this.misDoubleScreen);
    paramGLCanvas.fillRect(0.0F, 0.0F, i, j, this.mBackgroundColor);
  }
  
  protected void renderDoubleScreenOfPC(GLCanvas paramGLCanvas)
  {
    int i = this.mYuvTexture.getImgWidth();
    int j = this.mYuvTexture.getImgHeight();
    Rect localRect = super.getPaddings();
    int k = super.getWidth();
    int m = super.getHeight();
    int n = UITools.computeRealWidth(j) / 2;
    int i1 = (i - n) / 2;
    this.mSrcRectF.set(i1, 0, i1 + n, 0 + j);
    this.mDstRectF.set(0.0F, localRect.top, k - localRect.right, m - localRect.bottom);
    this.mYuvTexture.setSourceBounds((int)this.mSrcRectF.left, (int)this.mSrcRectF.top, (int)this.mSrcRectF.width(), (int)this.mSrcRectF.height());
    this.mYuvTexture.setTextureSize(i, j);
    this.mYuvTexture.setViewWidth((int)this.mDstRectF.width());
    this.mYuvTexture.setViewHeight((int)this.mDstRectF.height());
    paramGLCanvas.save(2);
    if (this.misDoubleScreen) {}
    for (i = 0;; i = this.mRotationType)
    {
      drawMirror(paramGLCanvas, i);
      this.mYuvTexture.draw(paramGLCanvas, (int)this.mDstRectF.left, (int)this.mDstRectF.top, (int)this.mDstRectF.width(), (int)this.mDstRectF.height());
      paramGLCanvas.restore();
      return;
    }
  }
  
  protected void renderLoading(GLCanvas paramGLCanvas)
  {
    if ((this.mLoading) && (this.mLoadingTexture != null))
    {
      this.mLoadingAngle %= 360;
      int j = super.getWidth();
      int k = super.getHeight();
      int n = this.mLoadingTexture.getSourceWidth();
      int m = this.mLoadingTexture.getSourceHeight();
      int i = n;
      if (n > j) {
        i = j;
      }
      j = m;
      if (m > k) {
        j = k;
      }
      paramGLCanvas.save(2);
      this.mLoadingTexture.draw(paramGLCanvas, 0, 0, i, j);
      paramGLCanvas.restore();
      long l = System.currentTimeMillis();
      if (l - this.mLastLoadingTime >= 80L)
      {
        this.mLastLoadingTime = l;
        this.mLoadingAngle += 8;
      }
    }
  }
  
  protected void renderText(GLCanvas paramGLCanvas)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (this.mShowText)
    {
      Rect localRect = super.getPaddings();
      if (this.mStringBgTexture != null)
      {
        i = super.getWidth();
        super.getHeight();
        j = localRect.left;
        k = localRect.right;
        m = localRect.left;
        m = localRect.bottom;
        this.mStringBgTexture.draw(paramGLCanvas, 0, 0, i - j - k, 36);
      }
      if (this.mTextChanged)
      {
        if (this.mStringTexture == null) {
          this.mStringTexture = new StringTexture();
        }
        this.mStringTexture.recycle();
        this.mStringTexture.setText(this.mText);
        this.mStringTexture.setTextSize(this.mTextSize);
        this.mStringTexture.setTextColor(this.mTextColor);
        this.mStringTexture.setMaxLength(this.mMaxLength);
        this.mStringTexture.setMaxWidth(super.getWidth());
        this.mStringTexture.refreshText();
        this.mTextChanged = false;
      }
      if ((this.mStringTexture != null) && (!TextUtils.isEmpty(this.mText)))
      {
        k = super.getWidth();
        m = super.getHeight();
        n = this.mStringTexture.getSourceWidth();
        i1 = this.mStringTexture.getSourceHeight();
        if (!this.mTextInBottom) {
          break label290;
        }
        i = 8;
        j = m - i1 - 8;
      }
    }
    for (;;)
    {
      paramGLCanvas.save(2);
      paramGLCanvas.translate((n - k) / 2, (i1 - m) / 2);
      this.mStringTexture.draw(paramGLCanvas, i, j, n, i1);
      paramGLCanvas.restore();
      return;
      label290:
      if (this.mIsSmallScreen)
      {
        i = this.mSmallScreenTextOffset;
        j = this.mSmallScreenTextOffset;
      }
      else
      {
        i = 30;
        j = 70;
      }
    }
  }
  
  protected void renderTexture(GLCanvas paramGLCanvas)
  {
    if ((this.mYuvTexture != null) && (this.mYuvTexture.updateCurFrame()) && (this.mYuvTexture.canRender()) && (this.mNeedRenderVideo))
    {
      enableLoading(false);
      if ((!this.mIsPC) || (!this.misDoubleScreen)) {
        break label69;
      }
      renderDoubleScreenOfPC(paramGLCanvas);
    }
    for (;;)
    {
      renderLoading(paramGLCanvas);
      renderText(paramGLCanvas);
      return;
      label69:
      renderVideo(paramGLCanvas);
    }
  }
  
  protected void renderVideo(GLCanvas paramGLCanvas)
  {
    Object localObject = super.getPaddings();
    this.mLastUpDateTime = System.currentTimeMillis();
    int j = super.getWidth();
    int i = super.getHeight();
    int n = j - ((Rect)localObject).left - ((Rect)localObject).right;
    j = i - ((Rect)localObject).top - ((Rect)localObject).bottom;
    boolean bool3 = isLocalView();
    int i1 = this.mYuvTexture.getImgAngleEx();
    int i2;
    float f5;
    float f6;
    float f2;
    float f1;
    int k;
    float f4;
    float f3;
    float f10;
    float f11;
    float f12;
    boolean bool1;
    label255:
    boolean bool4;
    if ((this.misDoubleScreen) && (!bool3))
    {
      i = 0;
      i2 = (i1 + i + 4) % 4;
      float f7 = ((Rect)localObject).left;
      float f8 = ((Rect)localObject).top;
      f5 = n;
      f6 = j;
      f2 = f6;
      int m = j;
      f1 = f5;
      k = n;
      f4 = f7;
      f3 = f8;
      if (i2 % 2 != 0)
      {
        f4 = f8;
        f3 = f7;
        f1 = f6;
        f2 = f5;
        f5 = n;
        m = (int)f5;
        k = j;
      }
      this.mDrawableRectF.set(f4, f3, k + f4, m + f3);
      f10 = this.mYuvTexture.getImgWidth();
      f11 = this.mYuvTexture.getImgHeight();
      f12 = f10 / f11;
      f5 = f1 / f2;
      if ((this.misDoubleScreen) || (!hasBlackBorder(i2))) {
        break label754;
      }
      bool1 = true;
      float f9 = f2;
      f8 = f1;
      f7 = f4;
      f6 = f3;
      if (bool1)
      {
        if (i2 % 2 != 0) {
          break label780;
        }
        f5 = f1;
        f6 = f5 / f12;
        if (f6 <= f2) {
          break label760;
        }
        f5 = f2;
        f2 = f5 * f12;
        f4 += (f1 - f2) / 2.0F;
        f1 = f5;
        label320:
        f5 = f2 / f1;
        f6 = f3;
        f7 = f4;
        f8 = f2;
        f9 = f1;
      }
      this.mSrcRectF.set(f7, f6, f7 + f8, f6 + f9);
      this.mTransformMatrix.mapRect(this.mDstRectF, this.mSrcRectF);
      if (f12 <= f5) {
        break label842;
      }
      f1 = f11 * f5;
      f2 = (f10 - f1) / 2.0F;
      this.mYuvTexture.setSourceBounds((int)f2, 0, (int)f1, (int)f11);
      label412:
      if (!this.mKeepAspectRatio) {
        this.mYuvTexture.setSourceBounds(0, 0, (int)f10, (int)f11);
      }
      this.mYuvTexture.setTextureSize((int)f10, (int)f11);
      paramGLCanvas.save(2);
      drawMirror(paramGLCanvas, i);
      paramGLCanvas.rotate(i2 * 90, 0.0F, 0.0F, 1.0F);
      this.mYuvTexture.setViewWidth((int)this.mDstRectF.width());
      this.mYuvTexture.setViewHeight((int)this.mDstRectF.height());
      j = (int)(this.mDstRectF.left - (this.mSrcRectF.width() - this.mDstRectF.width()) / 2.0F - this.mSrcRectF.left);
      k = (int)(this.mDstRectF.top - (this.mSrcRectF.height() - this.mDstRectF.height()) / 2.0F - this.mSrcRectF.top);
      if (this.mForceGround == null) {
        break label873;
      }
      this.mForceGround.draw(paramGLCanvas, j, k, (int)this.mDstRectF.width(), (int)this.mDstRectF.height());
      label613:
      if (this.mLogInfo == null) {
        this.mLogInfo = new LogInfo();
      }
      localObject = this.mLogInfo;
      bool4 = this.mMirror;
      if (this.mForceGround == null) {
        break label904;
      }
    }
    label904:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((LogInfo)localObject).log("GLVideoView", bool3, bool4, bool2, bool1, j, k, (int)this.mDstRectF.width(), (int)this.mDstRectF.width(), (int)this.mSrcRectF.width(), (int)this.mSrcRectF.width(), (int)f10, (int)f11, this.mYuvTexture.getSourceWidth(), this.mYuvTexture.getSourceHeight(), f12, f5, i, i1, this.mRotationType, i2);
      paramGLCanvas.restore();
      return;
      i = this.mRotationType;
      break;
      label754:
      bool1 = false;
      break label255;
      label760:
      f3 += (f2 - f6) / 2.0F;
      f1 = f6;
      f2 = f5;
      break label320;
      label780:
      f5 = f2;
      f6 = f5 * f12;
      if (f6 > f1)
      {
        f5 = f1;
        f1 = f5 / f12;
        f3 += (f2 - f1) / 2.0F;
        f2 = f5;
        break label320;
      }
      f4 += (f1 - f6) / 2.0F;
      f1 = f5;
      f2 = f6;
      break label320;
      label842:
      f1 = f10 / f5;
      f2 = (f11 - f1) / 2.0F;
      this.mYuvTexture.setSourceBounds(0, (int)f2, (int)f10, (int)f1);
      break label412;
      label873:
      this.mYuvTexture.draw(paramGLCanvas, j, k, (int)this.mDstRectF.width(), (int)this.mDstRectF.height());
      break label613;
    }
  }
  
  public void setCameraIsBindData(boolean paramBoolean)
  {
    if (this.mYuvTexture != null)
    {
      AVLog.w("GLVideoView", "setCameraIsBindData, uin[" + getUin() + "], VideoSrcType[" + getVideoSrcType() + "], isBind[" + paramBoolean + "]");
      this.mYuvTexture.setIsBind(paramBoolean);
    }
  }
  
  public void setEnableBorder(Boolean paramBoolean)
  {
    this.mEnableBorder = paramBoolean.booleanValue();
  }
  
  public void setFourceGround(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if (this.mForceGround != null)
    {
      this.mForceGround.recycle();
      this.mForceGround = null;
    }
    this.mForceGround = new BitmapTexture(paramBitmap);
  }
  
  public void setInfo(String paramString, int paramInt)
  {
    setTag(0, paramString);
    setTag(1, Integer.valueOf(paramInt));
  }
  
  public void setIsPC(boolean paramBoolean)
  {
    AVLog.d("GLVideoView", "setIsPC mIsPC: " + this.mIsPC + ", isPC: " + paramBoolean);
    this.mIsPC = paramBoolean;
    this.mTransformMatrix.reset();
    super.invalidate();
  }
  
  public void setIsSmallScreen(boolean paramBoolean)
  {
    this.mIsSmallScreen = paramBoolean;
    if (paramBoolean) {
      this.mSmallScreenTextOffset = ((int)UITools.dp2px(this.mContext, 3.0F));
    }
  }
  
  public void setMaxLength(int paramInt)
  {
    AVLog.d("GLVideoView", "setMaxLength maxLength: " + paramInt);
    if ((paramInt > 0) && (this.mMaxLength != paramInt))
    {
      this.mMaxLength = paramInt;
      this.mTextChanged = true;
      super.invalidate();
    }
  }
  
  public void setMirror(boolean paramBoolean)
  {
    if (this.mMirror != paramBoolean)
    {
      AVLog.w("GLVideoView", "setMirror, mMirror[" + this.mMirror + "->" + paramBoolean + "]");
      this.mMirror = paramBoolean;
      super.invalidate();
    }
  }
  
  public void setNeedRenderVideo(boolean paramBoolean)
  {
    AVLog.d("GLVideoView", "setNeedRenderVideo bRender: " + paramBoolean + ", mNeedRenderVideo: " + this.mNeedRenderVideo);
    this.mNeedRenderVideo = paramBoolean;
    super.invalidate();
  }
  
  public void setRotation(int paramInt)
  {
    paramInt = converToRotationType(paramInt);
    if ((this.mRotationType != paramInt) && (!isLocalView()))
    {
      this.mRotationType = paramInt;
      this.mTransformMatrix.reset();
      if (getVisibility() == 0) {
        invalidate();
      }
    }
  }
  
  public void setScale(float paramFloat, int paramInt1, int paramInt2)
  {
    Pair localPair = fixSizeByRotation(paramInt1, paramInt2, super.getWidth(), super.getHeight(), this.mRotationType);
    this.mTransformMatrixTmp.set(this.mTransformMatrix);
    this.mTransformMatrixTmp.postScale(paramFloat, paramFloat, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
    this.mTransformMatrixTmp.getValues(this.mMatrixValues);
    float f1 = this.mMatrixValues[0];
    float f2 = this.mMinZoomScale * 1.0F / 1.111111F;
    float f3 = this.mMaxZoomScale;
    if ((f1 <= f2) || (f1 >= f3 * 1.111111F)) {
      return;
    }
    this.mMatrixValues[0] = f1;
    this.mMatrixValues[4] = f1;
    this.mTransformMatrix.setValues(this.mMatrixValues);
    AVLog.w("GLVideoView", "setScale, scale[" + paramFloat + "->" + f1 + "], x[" + paramInt1 + "->" + localPair.first + "], y[" + paramInt2 + "->" + localPair.second + "], mRotation[" + this.mRotationType + "]");
    super.invalidate();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AVLog.d("GLVideoView", "setScaleType scaleType: " + paramScaleType);
    ImageView.ScaleType localScaleType = paramScaleType;
    if (paramScaleType == null) {
      localScaleType = ImageView.ScaleType.CENTER_INSIDE;
    }
    if (this.mScaleType != localScaleType)
    {
      this.mScaleType = localScaleType;
      super.invalidate();
    }
  }
  
  public void setScreenLayout(boolean paramBoolean)
  {
    this.misDoubleScreen = paramBoolean;
  }
  
  public void setSelfUin(String paramString)
  {
    this.mSelfUin = paramString;
  }
  
  public void setText(String paramString)
  {
    AVLog.w("GLVideoView", "setText, text[" + this.mText + "->" + paramString + "]");
    if (!TextUtils.equals(paramString, this.mText))
    {
      this.mText = paramString;
      this.mTextChanged = true;
      super.invalidate();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    AVLog.d("GLVideoView", "setTextColor textColor: 0x" + Integer.toHexString(paramInt).toUpperCase());
    if (this.mTextColor != paramInt)
    {
      this.mTextColor = paramInt;
      this.mTextChanged = true;
      super.invalidate();
    }
  }
  
  public void setTextInBottom(boolean paramBoolean)
  {
    AVLog.d("GLVideoView", "setTextInBottom inBottom: " + paramBoolean);
    if (this.mTextInBottom != paramBoolean)
    {
      this.mTextInBottom = paramBoolean;
      super.invalidate();
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    AVLog.d("GLVideoView", "setTextSize textSize: " + paramFloat);
    if (this.mTextSize != paramFloat)
    {
      this.mTextSize = paramFloat;
      this.mTextChanged = true;
      super.invalidate();
    }
  }
  
  public void setTranslation(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = fixSizeByRotation(paramInt1, paramInt2, 0, 0, this.mRotationType);
    AVLog.w("GLVideoView", "setTranslation, isEnd[" + paramBoolean + "], x[" + paramInt1 + "->" + ((Pair)localObject).first + "], y[" + paramInt2 + "->" + ((Pair)localObject).second + "], mRotation[" + this.mRotationType + "]");
    this.mTransformMatrix.getValues(this.mMatrixValues);
    float f2 = this.mMatrixValues[2] + ((Integer)((Pair)localObject).first).intValue();
    float f3 = this.mMatrixValues[5] + ((Integer)((Pair)localObject).second).intValue();
    this.mMatrixValues[2] = f2;
    this.mMatrixValues[5] = f3;
    this.mTransformMatrix.setValues(this.mMatrixValues);
    float f1;
    if (paramBoolean)
    {
      localObject = new RectF();
      this.mTransformMatrix.mapRect((RectF)localObject, this.mSrcRectF);
      if ((((RectF)localObject).left >= this.mDrawableRectF.left) || (((RectF)localObject).right >= this.mDrawableRectF.right)) {
        break label397;
      }
      if (((RectF)localObject).width() <= this.mDrawableRectF.width()) {
        break label376;
      }
      f1 = f2 + (this.mDrawableRectF.right - ((RectF)localObject).right);
      if ((((RectF)localObject).top >= this.mDrawableRectF.top) || (((RectF)localObject).bottom >= this.mDrawableRectF.bottom)) {
        break label569;
      }
      if (((RectF)localObject).height() <= this.mDrawableRectF.height()) {
        break label548;
      }
      f2 = f3 + (this.mDrawableRectF.bottom - ((RectF)localObject).bottom);
    }
    for (;;)
    {
      this.mMatrixValues[2] = f1;
      this.mMatrixValues[5] = f2;
      this.mTransformMatrix.setValues(this.mMatrixValues);
      super.invalidate();
      return;
      label376:
      f1 = f2 + (this.mDrawableRectF.centerX() - ((RectF)localObject).centerX());
      break;
      label397:
      if ((((RectF)localObject).left > this.mDrawableRectF.left) && (((RectF)localObject).right > this.mDrawableRectF.right))
      {
        if (((RectF)localObject).width() > this.mDrawableRectF.width())
        {
          f1 = f2 + (this.mDrawableRectF.left - ((RectF)localObject).left);
          break;
        }
        f1 = f2 + (this.mDrawableRectF.centerX() - ((RectF)localObject).centerX());
        break;
      }
      f1 = f2;
      if (((RectF)localObject).left <= this.mDrawableRectF.left) {
        break;
      }
      f1 = f2;
      if (((RectF)localObject).right >= this.mDrawableRectF.right) {
        break;
      }
      f1 = f2 + (this.mDrawableRectF.centerX() - ((RectF)localObject).centerX());
      break;
      label548:
      f2 = f3 + (this.mDrawableRectF.centerY() - ((RectF)localObject).centerY());
      continue;
      label569:
      if ((((RectF)localObject).top > this.mDrawableRectF.top) && (((RectF)localObject).bottom > this.mDrawableRectF.bottom))
      {
        if (((RectF)localObject).height() > this.mDrawableRectF.height()) {
          f2 = f3 + (this.mDrawableRectF.top - ((RectF)localObject).top);
        } else {
          f2 = f3 + (this.mDrawableRectF.centerY() - ((RectF)localObject).centerY());
        }
      }
      else
      {
        f2 = f3;
        if (((RectF)localObject).top > this.mDrawableRectF.top)
        {
          f2 = f3;
          if (((RectF)localObject).bottom < this.mDrawableRectF.bottom) {
            f2 = f3 + (this.mDrawableRectF.centerY() - ((RectF)localObject).centerY());
          }
        }
      }
    }
  }
  
  public void showText(boolean paramBoolean)
  {
    if (this.mShowText != paramBoolean)
    {
      AVLog.w("GLVideoView", "showText, show[" + this.mShowText + "->" + paramBoolean + "]");
      this.mShowText = paramBoolean;
      super.invalidate();
    }
  }
  
  static class LogInfo
  {
    boolean bForceGround = false;
    int dst_h = 0;
    int dst_w = 0;
    boolean hasBlackBorder = false;
    int img_h = 0;
    int img_w = 0;
    boolean isLocalView = false;
    boolean mirror = false;
    int px = 0;
    int py = 0;
    int rotation = 0;
    int rotationType = 0;
    int selfAngle;
    int src_h = 0;
    int src_w = 0;
    int yuvAngle;
    int yvu_h = 0;
    int yvu_w = 0;
    
    void log(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float paramFloat1, float paramFloat2, int paramInt11, int paramInt12, int paramInt13, int paramInt14)
    {
      if ((this.bForceGround != paramBoolean3) || (this.hasBlackBorder != paramBoolean4) || (this.isLocalView != paramBoolean1) || (this.mirror != paramBoolean2) || (this.px != paramInt1) || (this.py != paramInt2) || (this.dst_w != paramInt3) || (this.dst_h != paramInt4) || (this.src_w != paramInt5) || (this.src_h != paramInt6) || (this.img_w != paramInt7) || (this.img_h != paramInt8) || (this.yvu_w != paramInt9) || (this.yvu_h != paramInt10) || (this.selfAngle != paramInt11) || (this.yuvAngle != paramInt12) || (this.rotationType != paramInt13) || (this.rotation != paramInt14))
      {
        this.isLocalView = paramBoolean1;
        this.mirror = paramBoolean2;
        this.bForceGround = paramBoolean3;
        this.hasBlackBorder = paramBoolean4;
        this.px = paramInt1;
        this.py = paramInt2;
        this.dst_w = paramInt3;
        this.dst_h = paramInt4;
        this.src_w = paramInt5;
        this.src_h = paramInt6;
        this.img_w = paramInt7;
        this.img_h = paramInt8;
        this.yvu_w = paramInt9;
        this.yvu_h = paramInt10;
        this.selfAngle = paramInt11;
        this.yuvAngle = paramInt12;
        this.rotationType = paramInt13;
        this.rotation = paramInt14;
        AVLog.w(paramString, "rendView, self[" + paramBoolean1 + "], mirror[" + paramBoolean2 + "], bForceGround[" + paramBoolean3 + "], pt[" + paramInt1 + ", " + paramInt2 + "], dst[" + paramInt3 + ", " + paramInt4 + "], src[" + paramInt5 + ", " + paramInt6 + "], t1[" + paramInt7 + ", " + paramInt8 + "], t2[" + paramInt9 + ", " + paramInt10 + "], sR[" + paramFloat1 + "], tR[" + paramFloat2 + "], border[" + paramBoolean4 + "], sAngle[" + paramInt11 + "], yuvAngle[" + paramInt12 + "], mRotation[" + paramInt13 + "], rotation[" + paramInt14 + "]");
      }
    }
  }
  
  static abstract interface RotationType
  {
    public static final int _0 = 0;
    public static final int _180 = 2;
    public static final int _270 = 1;
    public static final int _90 = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLVideoView
 * JD-Core Version:    0.7.0.1
 */