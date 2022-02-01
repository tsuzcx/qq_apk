package com.tencent.av.opengl.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.av.opengl.glrender.GLCanvas;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.opengl.texture.ResourceTexture;
import com.tencent.av.opengl.ui.animation.GLAnimation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class GLView
{
  protected static final int FLAG_INVISIBLE = 1;
  protected static final int FLAG_LAYOUT_REQUESTED = 4;
  protected static final int FLAG_SET_MEASURED_SIZE = 2;
  public static final int INVISIBLE = 1;
  private static final String TAG = "GLView";
  public static final int VISIBLE = 0;
  protected List<GLAnimation> lstAnim = new ArrayList();
  protected float mAlpha;
  protected float mAngleX;
  protected float mAngleY;
  protected float mAngleZ;
  protected Animation mAnimation;
  protected BasicTexture mBackground;
  protected int mBackgroundColor = -16777216;
  protected int mBackgroundResource = 0;
  protected final Rect mBounds = new Rect(0, 0, 0, 0);
  protected float mCenterX;
  protected float mCenterY;
  protected float mCenterZ;
  protected WeakReference<Context> mContextWeak;
  protected float mHeight;
  private SparseArray<Object> mKeyedTags;
  protected int mLastHeightSpec = -1;
  protected int mLastWidthSpec = -1;
  protected int mMeasuredHeight = 0;
  protected int mMeasuredWidth = 0;
  protected OnTouchListener mOnTouchListener;
  protected OnZOrderChangedListener mOnZOrderChangedListener;
  protected final Rect mPaddings = new Rect(0, 0, 0, 0);
  protected GLView mParent;
  protected GLRootView mRootView;
  protected float mScaleX = 1.0F;
  protected float mScaleY = 1.0F;
  protected float mScaleZ = 1.0F;
  protected int mScrollX = 0;
  protected int mScrollY = 0;
  protected Object mTag;
  protected BasicTexture mTexture;
  protected Transformation mTransformation;
  protected int mViewFlags = 0;
  protected float mWidth;
  protected int mZOrder = 0;
  
  public GLView(Context paramContext)
  {
    this.mContextWeak = new WeakReference(paramContext);
  }
  
  public void attachToRoot(GLRootView paramGLRootView)
  {
    onAttachToRoot(paramGLRootView);
  }
  
  public void detachFromRoot()
  {
    onDetachFromRoot();
  }
  
  protected boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getVisibility() == 0) && (this.mOnTouchListener != null) && (this.mOnTouchListener.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return onTouchEvent(paramMotionEvent);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.mTexture != null)
      {
        this.mTexture.recycle();
        this.mTexture = null;
      }
      if (this.mBackground != null)
      {
        this.mBackground.recycle();
        this.mBackground = null;
        this.mBackgroundResource = 0;
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getBackgroundColor()
  {
    return this.mBackgroundColor;
  }
  
  public Rect getBounds()
  {
    return this.mBounds;
  }
  
  public GLRootView getGLRootView()
  {
    return this.mRootView;
  }
  
  public int getHeight()
  {
    return this.mBounds.bottom - this.mBounds.top;
  }
  
  public List<GLAnimation> getListAnim()
  {
    return this.lstAnim;
  }
  
  public int getMeasuredHeight()
  {
    return this.mMeasuredHeight;
  }
  
  public int getMeasuredWidth()
  {
    return this.mMeasuredWidth;
  }
  
  public Rect getPaddings()
  {
    return this.mPaddings;
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public Object getTag(int paramInt)
  {
    if (this.mKeyedTags != null) {
      return this.mKeyedTags.get(paramInt);
    }
    return null;
  }
  
  public int getVisibility()
  {
    if ((this.mViewFlags & 0x1) == 0) {
      return 0;
    }
    return 1;
  }
  
  public int getWidth()
  {
    return this.mBounds.right - this.mBounds.left;
  }
  
  public int getZOrder()
  {
    return this.mZOrder;
  }
  
  public void invalidate()
  {
    GLRootView localGLRootView = getGLRootView();
    if (localGLRootView != null) {
      localGLRootView.requestRender();
    }
  }
  
  @SuppressLint({"WrongCall"})
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mViewFlags &= 0xFFFFFFFB;
    onLayout(bool, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @SuppressLint({"WrongCall"})
  public void measure(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.mLastWidthSpec) && (paramInt2 == this.mLastHeightSpec) && ((this.mViewFlags & 0x4) == 0)) {}
    do
    {
      return;
      this.mLastWidthSpec = paramInt1;
      this.mLastHeightSpec = paramInt2;
      this.mViewFlags &= 0xFFFFFFFD;
      onMeasure(paramInt1, paramInt2);
    } while ((this.mViewFlags & 0x2) != 0);
    throw new IllegalStateException(getClass().getName() + " should call setMeasuredSize() in onMeasure()");
  }
  
  protected void onAttachToRoot(GLRootView paramGLRootView)
  {
    this.mRootView = paramGLRootView;
  }
  
  protected void onDetachFromRoot()
  {
    this.mRootView = null;
  }
  
  protected void onFirstDraw() {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onMeasure(int paramInt1, int paramInt2) {}
  
  protected boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onVisibilityChanged(int paramInt) {}
  
  public void post(Runnable paramRunnable)
  {
    GLRootView localGLRootView = getGLRootView();
    if (localGLRootView != null) {
      localGLRootView.post(paramRunnable);
    }
  }
  
  public void postDelayed(Runnable paramRunnable, long paramLong)
  {
    GLRootView localGLRootView = getGLRootView();
    if (localGLRootView != null) {
      localGLRootView.postDelayed(paramRunnable, paramLong);
    }
  }
  
  protected void render(GLCanvas paramGLCanvas)
  {
    runAnimation(System.currentTimeMillis());
    int i = this.mBounds.left;
    int j = this.mBounds.top;
    paramGLCanvas.save();
    GLAnimation localGLAnimation = null;
    if (this.lstAnim.size() > 0) {
      localGLAnimation = (GLAnimation)this.lstAnim.get(0);
    }
    if ((localGLAnimation != null) && (localGLAnimation.isTranslate()))
    {
      paramGLCanvas.translate(localGLAnimation.getCurrentX(), localGLAnimation.getCurrentY(), localGLAnimation.getCurrentZ());
      float f1 = this.mScaleX;
      f1 = this.mScaleY;
      f1 = this.mScaleZ;
      if ((localGLAnimation != null) && (localGLAnimation.isScale()))
      {
        f1 = localGLAnimation.getCurrentScaleX();
        float f2 = localGLAnimation.getCurrentScaleY();
        setBounds(i, j, (int)(i + f1), (int)(j + f2));
      }
      paramGLCanvas.translate(getWidth() / 2, getHeight() / 2, 0.0F);
      if ((localGLAnimation == null) || (!localGLAnimation.isRotate())) {
        break label268;
      }
      paramGLCanvas.rotate(localGLAnimation.getCurrentRotateX(), 1.0F, 0.0F, 0.0F);
      paramGLCanvas.rotate(localGLAnimation.getCurrentRotateY(), 0.0F, 1.0F, 0.0F);
      paramGLCanvas.rotate(localGLAnimation.getCurrentRotateZ(), 0.0F, 0.0F, 1.0F);
    }
    for (;;)
    {
      renderBackground(paramGLCanvas);
      renderTexture(paramGLCanvas);
      paramGLCanvas.restore();
      return;
      paramGLCanvas.translate(i, j, this.mCenterZ);
      break;
      label268:
      if (this.mAngleX != 0.0F) {
        paramGLCanvas.rotate(this.mAngleX, 1.0F, 0.0F, 0.0F);
      }
      if (this.mAngleY != 0.0F) {
        paramGLCanvas.rotate(this.mAngleY, 0.0F, 1.0F, 0.0F);
      }
      if (this.mAngleZ != 0.0F) {
        paramGLCanvas.rotate(this.mAngleZ, 0.0F, 0.0F, 1.0F);
      }
    }
  }
  
  protected void renderBackground(GLCanvas paramGLCanvas)
  {
    if (this.mBackground != null)
    {
      i = getWidth();
      j = getHeight();
      this.mBackground.draw(paramGLCanvas, 0, 0, i, j);
      return;
    }
    int i = getWidth();
    int j = getHeight();
    paramGLCanvas.fillRect(0.0F, 0.0F, i, j, this.mBackgroundColor);
  }
  
  protected void renderTexture(GLCanvas paramGLCanvas)
  {
    if (this.mTexture == null) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    Rect localRect = getPaddings();
    int k = localRect.left;
    int m = localRect.right;
    int n = localRect.top;
    int i1 = localRect.bottom;
    int i2 = localRect.left;
    int i3 = localRect.top;
    paramGLCanvas.save(2);
    this.mTexture.draw(paramGLCanvas, i2, i3, i - k - m, j - n - i1);
    paramGLCanvas.restore();
  }
  
  public void requestLayout()
  {
    this.mViewFlags |= 0x4;
    this.mLastHeightSpec = -1;
    this.mLastWidthSpec = -1;
    if (this.mParent != null) {
      this.mParent.requestLayout();
    }
    GLRootView localGLRootView;
    do
    {
      return;
      localGLRootView = getGLRootView();
    } while (localGLRootView == null);
    localGLRootView.requestLayoutContentPane();
  }
  
  public void runAnimation(long paramLong)
  {
    int i;
    int j;
    synchronized (this.lstAnim)
    {
      if (this.lstAnim.size() > 0)
      {
        invalidate();
        i = 0;
        j = this.lstAnim.size();
        if (i < j)
        {
          try
          {
            boolean bool = ((GLAnimation)this.lstAnim.get(i)).runAnimation(paramLong);
            j = i;
            if (bool) {
              j = i - 1;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              j = i;
            }
          }
          i = j + 1;
        }
      }
    }
  }
  
  public void setBackground(int paramInt)
  {
    ResourceTexture localResourceTexture = null;
    if ((paramInt != 0) && (paramInt == this.mBackgroundResource)) {
      return;
    }
    Object localObject = getGLRootView();
    if (localObject == null) {
      throw new RuntimeException("Cannot set resource background before attach to GLRootView!");
    }
    if (this.mBackground != null)
    {
      this.mBackground.recycle();
      this.mBackground = null;
    }
    localObject = ((GLRootView)localObject).getContext();
    if (paramInt == 0) {}
    for (;;)
    {
      this.mBackground = localResourceTexture;
      this.mBackgroundResource = paramInt;
      return;
      localResourceTexture = new ResourceTexture((Context)localObject, paramInt);
    }
  }
  
  public void setBackground(Bitmap paramBitmap)
  {
    if (this.mBackground != null)
    {
      this.mBackground.recycle();
      this.mBackground = null;
    }
    if (paramBitmap != null)
    {
      this.mBackground = new BitmapTexture(paramBitmap);
      this.mBackgroundResource = 0;
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }
  
  public boolean setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 - paramInt1 != this.mBounds.right - this.mBounds.left) || (paramInt4 - paramInt2 != this.mBounds.bottom - this.mBounds.top)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      return bool;
    }
  }
  
  public void setOnTouchListener(OnTouchListener paramOnTouchListener)
  {
    this.mOnTouchListener = paramOnTouchListener;
  }
  
  protected void setOnZOrderChangedListener(OnZOrderChangedListener paramOnZOrderChangedListener)
  {
    this.mOnZOrderChangedListener = paramOnZOrderChangedListener;
  }
  
  public void setPaddings(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaddings.set(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setRotation(int paramInt) {}
  
  public void setTag(int paramInt, Object paramObject)
  {
    if (this.mKeyedTags == null) {
      this.mKeyedTags = new SparseArray();
    }
    this.mKeyedTags.put(paramInt, paramObject);
  }
  
  public void setTag(Object paramObject)
  {
    this.mTag = paramObject;
  }
  
  public void setTexture(BasicTexture paramBasicTexture)
  {
    this.mTexture = paramBasicTexture;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == getVisibility()) {
      return;
    }
    if (paramInt == 0) {}
    for (this.mViewFlags &= 0xFFFFFFFE;; this.mViewFlags |= 0x1)
    {
      onVisibilityChanged(paramInt);
      invalidate();
      return;
    }
  }
  
  public void setZOrder(int paramInt)
  {
    if (this.mZOrder != paramInt)
    {
      int i = this.mZOrder;
      this.mZOrder = paramInt;
      if (this.mOnZOrderChangedListener != null) {
        this.mOnZOrderChangedListener.OnZOrderChanged(this, paramInt, i);
      }
    }
  }
  
  public void startAnimation(Animation paramAnimation)
  {
    if (getGLRootView() == null) {
      throw new IllegalStateException();
    }
    this.mAnimation = paramAnimation;
    if (this.mAnimation != null) {
      this.mAnimation.start();
    }
    invalidate();
  }
  
  public void startAnimation(GLAnimation paramGLAnimation)
  {
    List localList = this.lstAnim;
    if (paramGLAnimation != null) {}
    try
    {
      paramGLAnimation.setmView(this);
      paramGLAnimation.startAnimation();
      this.lstAnim.add(paramGLAnimation);
      invalidate();
      return;
    }
    finally {}
  }
  
  public static abstract interface OnTouchListener
  {
    public abstract boolean onTouch(GLView paramGLView, MotionEvent paramMotionEvent);
  }
  
  public static abstract interface OnZOrderChangedListener
  {
    public abstract void OnZOrderChanged(GLView paramGLView, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLView
 * JD-Core Version:    0.7.0.1
 */