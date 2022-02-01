package com.davemorrissey.labs.subscaleview.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.davemorrissey.labs.subscaleview.R.styleable;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecodeResult;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.legacy.LegacyBitmapLoaderFactory;
import com.davemorrissey.labs.subscaleview.legacy.LegacyTileInitLoaderFactory;
import com.davemorrissey.labs.subscaleview.legacy.LegacyTileLoaderFactory;
import com.davemorrissey.labs.subscaleview.model.IBitmapLoaderFactory;
import com.davemorrissey.labs.subscaleview.model.ILoadable;
import com.davemorrissey.labs.subscaleview.model.ITileInitLoaderFactory;
import com.davemorrissey.labs.subscaleview.model.ITileLoaderFactory;
import com.davemorrissey.labs.subscaleview.model.Tile;
import com.davemorrissey.labs.subscaleview.performance.ImageDecodeRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SubsamplingScaleImageView
  extends View
{
  public static int TILE_SIZE_AUTO;
  private static final List<Integer> VALID_EASING_STYLES;
  private static final List<Integer> VALID_ORIENTATIONS;
  private static final List<Integer> VALID_PAN_LIMITS;
  private static final List<Integer> VALID_SCALE_TYPES;
  private static final List<Integer> VALID_ZOOM_STYLES;
  private static IBitmapLoaderFactory mBitmapLoader;
  private static ITileInitLoaderFactory mTileInitLoader;
  private static ITileLoaderFactory mTileLoader;
  private static Bitmap.Config preferredBitmapConfig;
  public boolean IsinternalTouchEventConsumed;
  public final String TAG;
  private boolean allowInterceptTouch;
  private Anim anim;
  private Bitmap bitmap;
  private DecoderFactory<? extends ImageRegionDecoder> bitmapDecoderFactory;
  private boolean bitmapIsCached;
  private boolean bitmapIsPreview;
  private Paint bitmapPaint;
  private boolean canDrawPreview;
  private boolean canRefresh;
  private boolean cancelled;
  private boolean debug;
  private Paint debugLinePaint;
  private Paint debugTextPaint;
  private ImageRegionDecoder decoder;
  private final ReadWriteLock decoderLock;
  private float density;
  private GestureDetector detector;
  public int doubleTapZoomDuration;
  private float doubleTapZoomScale;
  private int doubleTapZoomStyle;
  private float[] dstArray;
  private boolean eagerLoadingEnabled;
  public Executor executor;
  private Bitmap fullImageBitmap;
  private int fullImageSampleSize;
  private long fullImageTileLoadedEnd;
  private long fullImageTileLoadedStart;
  private GestureDetector.SimpleOnGestureListener gestureDetectorListener;
  private Handler handler;
  private boolean horizontalLong;
  private boolean ignoreCancelEvent;
  private boolean imageLoadedSent;
  private boolean isFirstLoadFullImage;
  private boolean isPanning;
  private boolean isPreviewLoaded;
  private boolean isQuickScaling;
  private boolean isSwipingXEdge;
  private boolean isSwipingYDown;
  private boolean isSwipingYEdge;
  private boolean isZooming;
  private MotionEvent lastMotionEvent;
  private EdgeSwipeListener mEdgeSwipeListener;
  private float mHeightScale;
  private ImageDecodeRecord mImageDecodeRecord;
  private ImageSource mMainImageSource;
  private float mMaxZoomScale;
  private boolean mNeedPendingScale;
  private boolean mNeedScaleAndCenterWhenImageLoaded;
  private boolean mPreviewDone;
  private float mPreviewHeightScaleRate;
  private ImageSource mPreviewSource;
  private float mPreviewWidthScaleRate;
  public float mScaleRate;
  private float mScreenExtraScale;
  private Matrix mSuppMatrix;
  private LinkedList<ILoadable> mTileLoadTaskList;
  private int mViewHeight;
  private int mViewWidth;
  private float mWidthScale;
  private Matrix matrix;
  private float[] matrixValues;
  private float maxScale;
  private int maxTileHeight;
  private int maxTileWidth;
  private int maxTouchCount;
  private float minScale;
  private int minimumScaleType;
  private int minimumTileDpi;
  private View.OnAttachStateChangeListener onAttachStateChangeListener;
  private GestureDetector.OnDoubleTapListener onDoubleTapListener;
  private OnImageEventListener onImageEventListener;
  private View.OnLongClickListener onLongClickListener;
  private OnStateChangedListener onStateChangedListener;
  public View.OnTouchListener onTouchListener;
  private int orientation;
  private Rect pRegion;
  private boolean panEnabled;
  private int panLimit;
  private Float pendingScale;
  private int previewHeight;
  private int previewOrientation;
  private int previewWidth;
  private boolean quickScaleEnabled;
  private float quickScaleLastDistance;
  private boolean quickScaleMoved;
  private PointF quickScaleSCenter;
  private final float quickScaleThreshold;
  private PointF quickScaleVLastPoint;
  private PointF quickScaleVStart;
  private boolean readySent;
  private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
  public int sHeight;
  private int sOrientation;
  private PointF sPendingCenter;
  private RectF sRect;
  private Rect sRegion;
  private PointF sRequestedCenter;
  public int sWidth;
  private ScaleAndTranslate satTemp;
  public float scale;
  private float scaleStart;
  private GestureDetector singleDetector;
  private float[] srcArray;
  private Paint tileBgPaint;
  private Map<Integer, List<Tile>> tileMap;
  private float tmpScale;
  private Uri uri;
  private PointF vCenterStart;
  private float vDistStart;
  private PointF vResetCenter;
  public PointF vTranslate;
  private PointF vTranslateBefore;
  private PointF vTranslateStart;
  private boolean verticalLong;
  private float x_down;
  private float y_down;
  private boolean zoomEnabled;
  private int zoomScaleDuration;
  
  static
  {
    AppMethodBeat.i(157473);
    VALID_ORIENTATIONS = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1) });
    VALID_ZOOM_STYLES = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    VALID_EASING_STYLES = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
    VALID_PAN_LIMITS = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    VALID_SCALE_TYPES = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4) });
    TILE_SIZE_AUTO = 2147483647;
    preferredBitmapConfig = Bitmap.Config.ARGB_8888;
    mBitmapLoader = new LegacyBitmapLoaderFactory();
    mTileLoader = new LegacyTileLoaderFactory();
    mTileInitLoader = new LegacyTileInitLoaderFactory();
    AppMethodBeat.o(157473);
  }
  
  public SubsamplingScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(157394);
    this.TAG = (SubsamplingScaleImageView.class.getSimpleName() + hashCode());
    this.isFirstLoadFullImage = true;
    this.fullImageTileLoadedStart = -1L;
    this.fullImageTileLoadedEnd = -1L;
    this.verticalLong = false;
    this.horizontalLong = false;
    this.debug = false;
    this.orientation = -1;
    this.maxScale = 2.0F;
    this.minScale = minScale();
    this.minimumTileDpi = -1;
    this.panLimit = 1;
    this.minimumScaleType = 3;
    this.maxTileWidth = TILE_SIZE_AUTO;
    this.maxTileHeight = TILE_SIZE_AUTO;
    this.eagerLoadingEnabled = true;
    this.panEnabled = true;
    this.zoomEnabled = true;
    this.quickScaleEnabled = true;
    this.doubleTapZoomScale = 2.0F;
    this.doubleTapZoomStyle = 1;
    this.doubleTapZoomDuration = 200;
    this.zoomScaleDuration = 200;
    this.canRefresh = true;
    this.onDoubleTapListener = null;
    this.allowInterceptTouch = true;
    this.ignoreCancelEvent = false;
    this.lastMotionEvent = null;
    this.matrixValues = new float[9];
    this.tmpScale = 0.0F;
    this.previewOrientation = 0;
    this.decoderLock = new ReentrantReadWriteLock(true);
    this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
    this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
    this.srcArray = new float[8];
    this.dstArray = new float[8];
    this.mTileLoadTaskList = new LinkedList();
    this.cancelled = false;
    this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
    this.mScreenExtraScale = 1.0F;
    this.mMaxZoomScale = 20.0F;
    this.mPreviewDone = true;
    this.mNeedScaleAndCenterWhenImageLoaded = false;
    this.mImageDecodeRecord = new ImageDecodeRecord();
    this.mEdgeSwipeListener = new EdgeSwipeListener() {};
    this.isSwipingXEdge = false;
    this.isSwipingYEdge = false;
    this.isSwipingYDown = false;
    this.IsinternalTouchEventConsumed = true;
    this.density = getResources().getDisplayMetrics().density;
    setDoubleTapZoomScale(2.0F);
    setMinimumTileDpi(320);
    setGestureDetector(paramContext);
    this.mSuppMatrix = new Matrix();
    this.handler = new Handler(new Handler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(157375);
        if ((paramAnonymousMessage.what == 1) && (SubsamplingScaleImageView.this.onLongClickListener != null))
        {
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this);
          SubsamplingScaleImageView.access$201(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.onLongClickListener);
          SubsamplingScaleImageView.this.performLongClick();
          SubsamplingScaleImageView.b(SubsamplingScaleImageView.this);
        }
        AppMethodBeat.o(157375);
        return true;
      }
    });
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.SubsamplingScaleImageView);
      if (paramAttributeSet.hasValue(R.styleable.SubsamplingScaleImageView_assetName))
      {
        String str = paramAttributeSet.getString(R.styleable.SubsamplingScaleImageView_assetName);
        if ((str != null) && (str.length() > 0)) {
          setImage(ImageSource.asset(str).tilingEnabled());
        }
      }
      if (paramAttributeSet.hasValue(R.styleable.SubsamplingScaleImageView_src))
      {
        int i = paramAttributeSet.getResourceId(R.styleable.SubsamplingScaleImageView_src, 0);
        if (i > 0) {
          setImage(ImageSource.resource(i).tilingEnabled());
        }
      }
      if (paramAttributeSet.hasValue(R.styleable.SubsamplingScaleImageView_panEnabled)) {
        setPanEnabled(paramAttributeSet.getBoolean(R.styleable.SubsamplingScaleImageView_panEnabled, true));
      }
      if (paramAttributeSet.hasValue(R.styleable.SubsamplingScaleImageView_zoomEnabled)) {
        setZoomEnabled(paramAttributeSet.getBoolean(R.styleable.SubsamplingScaleImageView_zoomEnabled, true));
      }
      if (paramAttributeSet.hasValue(R.styleable.SubsamplingScaleImageView_quickScaleEnabled)) {
        setQuickScaleEnabled(paramAttributeSet.getBoolean(R.styleable.SubsamplingScaleImageView_quickScaleEnabled, true));
      }
      if (paramAttributeSet.hasValue(R.styleable.SubsamplingScaleImageView_tileBackgroundColor)) {
        setTileBackgroundColor(paramAttributeSet.getColor(R.styleable.SubsamplingScaleImageView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
      }
      paramAttributeSet.recycle();
    }
    this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0F, paramContext.getResources().getDisplayMetrics());
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.mScreenExtraScale = f;
    }
    AppMethodBeat.o(157394);
  }
  
  private void a(float paramFloat, PointF paramPointF)
  {
    AppMethodBeat.i(369521);
    Log.i(this.TAG, "alvinluo sendStateChanged oldScale: %s, %s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.scale) });
    if ((this.onStateChangedListener != null) && (this.scale != paramFloat)) {
      this.onStateChangedListener.bv(this.scale, paramFloat);
    }
    if ((this.onStateChangedListener != null) && (!this.vTranslate.equals(paramPointF))) {
      getCenter();
    }
    AppMethodBeat.o(369521);
  }
  
  private int calculateInSampleSize(float paramFloat)
  {
    AppMethodBeat.i(157420);
    float f = paramFloat;
    if (this.minimumTileDpi > 0)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      f = localDisplayMetrics.xdpi;
      f = (localDisplayMetrics.ydpi + f) / 2.0F;
      f = paramFloat * (this.minimumTileDpi / f);
    }
    int j = (int)(sWidth() * f);
    int i = (int)(sHeight() * f);
    if ((j == 0) || (i == 0))
    {
      AppMethodBeat.o(157420);
      return 32;
    }
    if ((sHeight() > i) || (sWidth() > j))
    {
      i = Math.round(sHeight() / i);
      j = Math.round(sWidth() / j);
      if (i >= j) {}
    }
    for (;;)
    {
      j = 1;
      for (;;)
      {
        if (j * 2 < i)
        {
          j *= 2;
          continue;
          i = j;
          break;
        }
      }
      AppMethodBeat.o(157420);
      return j;
      i = 1;
    }
  }
  
  private boolean checkImageLoaded()
  {
    AppMethodBeat.i(157416);
    boolean bool = isBaseLayerReady();
    if ((!this.imageLoadedSent) && (bool))
    {
      preDraw();
      this.imageLoadedSent = true;
      Log.i(this.TAG, "alvinluo onImageLoaded");
      initScaleRate();
      setScaleAndCenter(this.mScaleRate, new PointF(0.0F, 0.0F));
      if (this.fullImageTileLoadedStart != -1L)
      {
        this.fullImageTileLoadedEnd = System.currentTimeMillis();
        addTileDecodeTime((int)(this.fullImageTileLoadedEnd - this.fullImageTileLoadedStart));
      }
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(157384);
          if ((SubsamplingScaleImageView.this.fullImageBitmap != null) && (!SubsamplingScaleImageView.this.fullImageBitmap.isRecycled()))
          {
            Log.i(SubsamplingScaleImageView.this.TAG, "alvinluo rotateAndScale fullImageBitmap");
            SubsamplingScaleImageView.access$4602(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.n(SubsamplingScaleImageView.this.fullImageBitmap, SubsamplingScaleImageView.this.sOrientation));
          }
          SubsamplingScaleImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157383);
              if (SubsamplingScaleImageView.this.onImageEventListener != null) {
                SubsamplingScaleImageView.this.onImageEventListener.onImageLoaded(SubsamplingScaleImageView.this.fullImageBitmap);
              }
              AppMethodBeat.o(157383);
            }
          });
          AppMethodBeat.o(157384);
        }
      }, "rotateAndScaleFullImageBitmap");
    }
    AppMethodBeat.o(157416);
    return bool;
  }
  
  private boolean checkReady()
  {
    AppMethodBeat.i(157415);
    if ((getWidth() > 0) && (getHeight() > 0) && (this.sWidth > 0) && (this.sHeight > 0) && ((this.bitmap != null) || (isBaseLayerReady()))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.readySent) && (bool))
      {
        preDraw();
        this.readySent = true;
      }
      AppMethodBeat.o(157415);
      return bool;
    }
  }
  
  private static float distance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(157435);
    paramFloat1 -= paramFloat2;
    paramFloat2 = paramFloat3 - paramFloat4;
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    AppMethodBeat.o(157435);
    return paramFloat1;
  }
  
  private static float ease(int paramInt, long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(157443);
    switch (paramInt)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Unexpected easing type: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157443);
      throw localIllegalStateException;
    case 2: 
      paramFloat1 = easeInOutQuad(paramLong1, paramFloat1, paramFloat2, paramLong2);
      AppMethodBeat.o(157443);
      return paramFloat1;
    }
    paramFloat1 = easeOutQuad(paramLong1, paramFloat1, paramFloat2, paramLong2);
    AppMethodBeat.o(157443);
    return paramFloat1;
  }
  
  private static float easeInOutQuad(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    float f = (float)paramLong1 / ((float)paramLong2 / 2.0F);
    if (f < 1.0F) {
      return f * (paramFloat2 / 2.0F * f) + paramFloat1;
    }
    f -= 1.0F;
    return (f * (f - 2.0F) - 1.0F) * (-paramFloat2 / 2.0F) + paramFloat1;
  }
  
  private static float easeOutQuad(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    float f = (float)paramLong1 / (float)paramLong2;
    return (f - 2.0F) * (-paramFloat2 * f) + paramFloat1;
  }
  
  private void fitToBounds(boolean paramBoolean)
  {
    AppMethodBeat.i(157422);
    int i;
    if (this.vTranslate == null)
    {
      i = 1;
      this.vTranslate = new PointF(0.0F, 0.0F);
    }
    for (;;)
    {
      if (this.satTemp == null) {
        this.satTemp = new ScaleAndTranslate(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      }
      this.satTemp.scale = this.scale;
      this.satTemp.vTranslate.set(this.vTranslate);
      fitToBounds(paramBoolean, this.satTemp);
      this.scale = this.satTemp.scale;
      this.vTranslate.set(this.satTemp.vTranslate);
      if ((i != 0) && (this.minimumScaleType != 4)) {
        this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
      }
      AppMethodBeat.o(157422);
      return;
      i = 0;
    }
  }
  
  private void fitToBounds(boolean paramBoolean, ScaleAndTranslate paramScaleAndTranslate)
  {
    float f2 = 0.5F;
    AppMethodBeat.i(157421);
    boolean bool = paramBoolean;
    if (this.panLimit == 2)
    {
      bool = paramBoolean;
      if (this.readySent) {
        bool = false;
      }
    }
    PointF localPointF = paramScaleAndTranslate.vTranslate;
    float f4 = limitedScale(paramScaleAndTranslate.scale);
    float f3 = f4 * sWidth();
    float f5 = f4 * sHeight();
    float f1;
    if ((this.panLimit == 3) && (this.readySent))
    {
      localPointF.x = Math.max(localPointF.x, getWidth() / 2 - f3);
      localPointF.y = Math.max(localPointF.y, getHeight() / 2 - f5);
      if ((getPaddingLeft() <= 0) && (getPaddingRight() <= 0)) {
        break label362;
      }
      f1 = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
      label163:
      if ((getPaddingTop() > 0) || (getPaddingBottom() > 0)) {
        f2 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
      }
      if ((this.panLimit != 3) || (!this.readySent)) {
        break label369;
      }
      f2 = Math.max(0, getWidth() / 2);
      f1 = Math.max(0, getHeight() / 2);
    }
    for (;;)
    {
      localPointF.x = Math.min(localPointF.x, f2);
      localPointF.y = Math.min(localPointF.y, f1);
      paramScaleAndTranslate.scale = f4;
      AppMethodBeat.o(157421);
      return;
      if (bool)
      {
        localPointF.x = Math.max(localPointF.x, getWidth() - f3);
        localPointF.y = Math.max(localPointF.y, getHeight() - f5);
        break;
      }
      localPointF.x = Math.max(localPointF.x, -f3);
      localPointF.y = Math.max(localPointF.y, -f5);
      break;
      label362:
      f1 = 0.5F;
      break label163;
      label369:
      if (bool)
      {
        f3 = Math.max(0.0F, (getWidth() - f3) * f1);
        f1 = Math.max(0.0F, (getHeight() - f5) * f2);
        f2 = f3;
      }
      else
      {
        f2 = Math.max(0, getWidth());
        f1 = Math.max(0, getHeight());
      }
    }
  }
  
  private float getDoubleTapZoomScale()
  {
    float f1 = this.mScaleRate;
    if (this.mWidthScale * 0.7F > f1) {
      f1 = this.mWidthScale;
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 < 1.0D) {
        f2 = 1.0F;
      }
      f1 = f2;
      if (f2 > this.maxScale) {
        f1 = this.maxScale;
      }
      return f1;
      if (this.mHeightScale * 0.7F > f1) {
        f1 = this.mHeightScale;
      } else {
        f1 = this.mScaleRate * this.doubleTapZoomScale;
      }
    }
  }
  
  public static Bitmap.Config getPreferredBitmapConfig()
  {
    return preferredBitmapConfig;
  }
  
  private void initMaxScale()
  {
    AppMethodBeat.i(157399);
    this.maxScale = (getDoubleTapZoomScale() * 2.0F * this.mScreenExtraScale);
    AppMethodBeat.o(157399);
  }
  
  private void initMinScale()
  {
    AppMethodBeat.i(157400);
    this.minScale = Math.min(minScale(), this.mScaleRate * 0.75F);
    AppMethodBeat.o(157400);
  }
  
  private void initPreviewScale()
  {
    AppMethodBeat.i(208516);
    if (this.bitmap == null)
    {
      AppMethodBeat.o(208516);
      return;
    }
    if (!this.bitmapIsPreview)
    {
      AppMethodBeat.o(208516);
      return;
    }
    int i = sWidth();
    int j = sHeight();
    boolean bool;
    if (i > j * 2.2F)
    {
      bool = true;
      this.horizontalLong = bool;
      if (j <= i * 2.2F) {
        break label272;
      }
      bool = true;
      label77:
      this.verticalLong = bool;
      if ((!this.horizontalLong) || (i <= this.mViewWidth)) {
        break label277;
      }
      bool = true;
      label99:
      this.horizontalLong = bool;
      if ((!this.verticalLong) || (j <= this.mViewHeight)) {
        break label282;
      }
      bool = true;
      label121:
      this.verticalLong = bool;
      initScaleRate();
      if (!this.verticalLong) {
        break label287;
      }
      this.mPreviewWidthScaleRate = (this.mViewWidth * 1.0F / previewWidth());
      this.mPreviewHeightScaleRate = (this.mViewHeight * 1.0F / previewHeight());
    }
    for (;;)
    {
      Log.i(this.TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f, previewHeight: %d, previewWidth: %d, verticalLong: %b, horizontalLong: %b, %s", new Object[] { Float.valueOf(this.mPreviewWidthScaleRate), Float.valueOf(this.mPreviewHeightScaleRate), Integer.valueOf(previewHeight()), Integer.valueOf(previewWidth()), Boolean.valueOf(this.verticalLong), Boolean.valueOf(this.horizontalLong), this.mMainImageSource.getUri().toString() });
      AppMethodBeat.o(208516);
      return;
      bool = false;
      break;
      label272:
      bool = false;
      break label77;
      label277:
      bool = false;
      break label99;
      label282:
      bool = false;
      break label121;
      label287:
      if (this.horizontalLong)
      {
        this.mPreviewWidthScaleRate = (this.mViewWidth * 1.0F / previewWidth());
        this.mPreviewHeightScaleRate = (this.mScaleRate * sHeight() / previewHeight());
      }
      else
      {
        this.mPreviewWidthScaleRate = (this.mScaleRate * sWidth() / previewWidth());
        this.mPreviewHeightScaleRate = (this.mScaleRate * sHeight() / previewHeight());
      }
    }
  }
  
  private void initScaleRate()
  {
    AppMethodBeat.i(157398);
    Log.i(this.TAG, "alvinluo initScaleRate: %f", new Object[] { Float.valueOf(this.mScaleRate) });
    initMaxScale();
    initMinScale();
    AppMethodBeat.o(157398);
  }
  
  private void initialiseBaseLayer(Point paramPoint)
  {
    try
    {
      AppMethodBeat.i(157417);
      debug("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
      this.satTemp = new ScaleAndTranslate(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      fitToBounds(true, this.satTemp);
      this.fullImageSampleSize = calculateInSampleSize(this.satTemp.scale);
      initialiseTileMap(paramPoint);
      paramPoint = ((List)this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))).iterator();
      while (paramPoint.hasNext())
      {
        Tile localTile = (Tile)paramPoint.next();
        Log.i(this.TAG, "alvinluo tile fullSampleSize: %d", new Object[] { Integer.valueOf(this.fullImageSampleSize) });
        newLoadTask(localTile);
      }
      refreshRequiredTiles(true);
    }
    finally {}
    AppMethodBeat.o(157417);
  }
  
  private void initialiseTileMap(Point paramPoint)
  {
    AppMethodBeat.i(157423);
    debug("initialiseTileMap maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
    this.tileMap = new LinkedHashMap();
    int i = this.fullImageSampleSize;
    int j = 1;
    int m = 1;
    int k = sWidth() / j;
    int i2 = sHeight() / m;
    int n = k / i;
    int i1 = i2 / i;
    while ((n + j + 1 > paramPoint.x) || ((n > getWidth() * 1.25D) && (i < this.fullImageSampleSize)))
    {
      j += 1;
      k = sWidth() / j;
      n = k / i;
    }
    for (;;)
    {
      if ((i1 + m + 1 > paramPoint.y) || ((i1 > getHeight() * 1.25D) && (i < this.fullImageSampleSize)))
      {
        m += 1;
        n = sHeight() / m;
        i1 = n / i;
      }
      else
      {
        ArrayList localArrayList = new ArrayList(j * m);
        i1 = 0;
        while (i1 < j)
        {
          i2 = 0;
          if (i2 < m)
          {
            Tile localTile = new Tile();
            localTile.sampleSize = i;
            boolean bool;
            label265:
            int i3;
            if (i == this.fullImageSampleSize)
            {
              bool = true;
              localTile.visible = bool;
              if (i1 != j - 1) {
                break label385;
              }
              i3 = sWidth();
              label286:
              if (i2 != m - 1) {
                break label397;
              }
            }
            label385:
            label397:
            for (int i4 = sHeight();; i4 = (i2 + 1) * n)
            {
              localTile.sRect = new Rect(i1 * k, i2 * n, i3, i4);
              localTile.vRect = new Rect(0, 0, 0, 0);
              localTile.fileSRect = new Rect(localTile.sRect);
              localArrayList.add(localTile);
              i2 += 1;
              break;
              bool = false;
              break label265;
              i3 = (i1 + 1) * k;
              break label286;
            }
          }
          i1 += 1;
        }
        this.tileMap.put(Integer.valueOf(i), localArrayList);
        if (i != 1)
        {
          i /= 2;
          break;
        }
        AppMethodBeat.o(157423);
        return;
        n = i2;
      }
    }
  }
  
  private boolean isBaseLayerReady()
  {
    AppMethodBeat.i(157414);
    if ((this.bitmap != null) && (!this.bitmapIsPreview))
    {
      AppMethodBeat.o(157414);
      return true;
    }
    if (this.tileMap != null)
    {
      Iterator localIterator = this.tileMap.entrySet().iterator();
      boolean bool2;
      for (boolean bool1 = true; localIterator.hasNext(); bool1 = bool2)
      {
        Object localObject = (Map.Entry)localIterator.next();
        bool2 = bool1;
        if (((Integer)((Map.Entry)localObject).getKey()).intValue() == this.fullImageSampleSize)
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            Tile localTile = (Tile)((Iterator)localObject).next();
            if ((localTile.loading) || (localTile.bitmap == null)) {
              bool1 = false;
            }
          }
        }
      }
      AppMethodBeat.o(157414);
      return bool1;
    }
    AppMethodBeat.o(157414);
    return false;
  }
  
  private float limitedScale(float paramFloat)
  {
    AppMethodBeat.i(157442);
    paramFloat = Math.max(minScale(), paramFloat);
    AppMethodBeat.o(157442);
    return paramFloat;
  }
  
  private float minScale()
  {
    AppMethodBeat.i(157441);
    int i = getPaddingBottom() + getPaddingTop();
    int j = getPaddingLeft() + getPaddingRight();
    if ((this.minimumScaleType == 2) || (this.minimumScaleType == 4))
    {
      f = Math.max((getWidth() - j) / sWidth(), (getHeight() - i) / sHeight());
      AppMethodBeat.o(157441);
      return f;
    }
    if ((this.minimumScaleType == 3) && (this.minScale > 0.0F))
    {
      f = this.minScale;
      AppMethodBeat.o(157441);
      return f;
    }
    float f = Math.min((getWidth() - j) / sWidth(), (getHeight() - i) / sHeight());
    AppMethodBeat.o(157441);
    return f;
  }
  
  private void newLoadTask(Tile paramTile)
  {
    AppMethodBeat.i(157393);
    if (this.cancelled)
    {
      Log.i(this.TAG, "alvinluo newLoadTask, has cancelled and ignore");
      AppMethodBeat.o(157393);
      return;
    }
    paramTile = mTileLoader.newInstance(this, this.decoder, paramTile);
    paramTile.startLoad();
    this.mTileLoadTaskList.add(paramTile);
    AppMethodBeat.o(157393);
  }
  
  private void preDraw()
  {
    AppMethodBeat.i(157419);
    if ((getWidth() == 0) || (getHeight() == 0) || (this.sWidth <= 0) || (this.sHeight <= 0))
    {
      AppMethodBeat.o(157419);
      return;
    }
    if ((this.sPendingCenter != null) && (this.pendingScale != null))
    {
      this.scale = this.pendingScale.floatValue();
      if (this.vTranslate == null) {
        this.vTranslate = new PointF();
      }
      this.vTranslate.x = (getWidth() / 2 - this.scale * this.sPendingCenter.x);
      this.vTranslate.y = (getHeight() / 2 - this.scale * this.sPendingCenter.y);
      this.sPendingCenter = null;
      this.pendingScale = null;
      this.mNeedPendingScale = false;
      fitToBounds(true);
      refreshRequiredTiles(true);
    }
    fitToBounds(false);
    AppMethodBeat.o(157419);
  }
  
  private int previewHeight()
  {
    AppMethodBeat.i(157432);
    if ((this.bitmap == null) || (!this.bitmapIsPreview))
    {
      AppMethodBeat.o(157432);
      return 0;
    }
    int i = this.previewOrientation;
    if ((i == 90) || (i == 270))
    {
      i = this.bitmap.getWidth();
      AppMethodBeat.o(157432);
      return i;
    }
    i = this.bitmap.getHeight();
    AppMethodBeat.o(157432);
    return i;
  }
  
  private int previewWidth()
  {
    AppMethodBeat.i(157431);
    if ((this.bitmap == null) || (!this.bitmapIsPreview))
    {
      AppMethodBeat.o(157431);
      return 0;
    }
    int i = this.previewOrientation;
    if ((i == 90) || (i == 270))
    {
      i = this.bitmap.getHeight();
      AppMethodBeat.o(157431);
      return i;
    }
    i = this.bitmap.getWidth();
    AppMethodBeat.o(157431);
    return i;
  }
  
  private int px(int paramInt)
  {
    return (int)(this.density * paramInt);
  }
  
  private void refreshRequiredTiles(boolean paramBoolean)
  {
    AppMethodBeat.i(157418);
    if ((this.decoder == null) || (this.tileMap == null))
    {
      AppMethodBeat.o(157418);
      return;
    }
    int j = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
    Iterator localIterator1 = this.tileMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        Tile localTile = (Tile)localIterator2.next();
        if ((localTile.sampleSize < j) || ((localTile.sampleSize > j) && (localTile.sampleSize != this.fullImageSampleSize)))
        {
          localTile.visible = false;
          if (localTile.bitmap != null)
          {
            localTile.bitmap.recycle();
            localTile.bitmap = null;
          }
        }
        if (localTile.sampleSize == j)
        {
          float f1 = viewToSourceX(0.0F);
          float f2 = viewToSourceX(getWidth());
          float f3 = viewToSourceY(0.0F);
          float f4 = viewToSourceY(getHeight());
          if ((f1 <= localTile.sRect.right) && (localTile.sRect.left <= f2) && (f3 <= localTile.sRect.bottom) && (localTile.sRect.top <= f4)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label328;
            }
            localTile.visible = true;
            if ((localTile.loading) || (localTile.bitmap != null) || (!paramBoolean)) {
              break;
            }
            newLoadTask(localTile);
            break;
          }
          label328:
          if (localTile.sampleSize != this.fullImageSampleSize)
          {
            localTile.visible = false;
            if (localTile.bitmap != null)
            {
              localTile.bitmap.recycle();
              localTile.bitmap = null;
            }
          }
        }
        else if (localTile.sampleSize == this.fullImageSampleSize)
        {
          localTile.visible = true;
        }
      }
    }
    AppMethodBeat.o(157418);
  }
  
  private void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(157410);
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
    {
      Log.i(this.TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b, allowInterceptTouch: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.allowInterceptTouch) });
      if (!this.allowInterceptTouch)
      {
        this.ignoreCancelEvent = true;
        localViewParent.requestDisallowInterceptTouchEvent(false);
        AppMethodBeat.o(157410);
        return;
      }
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(157410);
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(157404);
    debug("reset newImage=".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.scale = 0.0F;
    this.scaleStart = 0.0F;
    this.vTranslate = null;
    this.vTranslateStart = null;
    this.vTranslateBefore = null;
    this.pendingScale = Float.valueOf(0.0F);
    this.sPendingCenter = null;
    this.sRequestedCenter = null;
    this.isZooming = false;
    this.isPanning = false;
    this.isQuickScaling = false;
    this.maxTouchCount = 0;
    this.fullImageSampleSize = 0;
    this.vCenterStart = null;
    this.vDistStart = 0.0F;
    this.quickScaleLastDistance = 0.0F;
    this.quickScaleMoved = false;
    this.quickScaleSCenter = null;
    this.quickScaleVLastPoint = null;
    this.quickScaleVStart = null;
    this.anim = null;
    this.satTemp = null;
    this.matrix = null;
    this.sRect = null;
    Object localObject1;
    if (paramBoolean)
    {
      if (this.mImageDecodeRecord != null)
      {
        localObject1 = this.mImageDecodeRecord;
        ((ImageDecodeRecord)localObject1).mTileDecodeTime = 0;
        ((ImageDecodeRecord)localObject1).mPreviewLoadedTime = 0;
        ((ImageDecodeRecord)localObject1).mTileDecodeTime = 0;
      }
      this.uri = null;
      this.decoderLock.writeLock().lock();
    }
    Tile localTile;
    label512:
    try
    {
      if (this.decoder != null)
      {
        this.decoder.recycle();
        this.decoder = null;
      }
      this.decoderLock.writeLock().unlock();
      if ((this.bitmap != null) && (!this.bitmapIsCached)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.bitmapIsCached) && (this.onImageEventListener != null)) {
        this.onImageEventListener.onPreviewReleased();
      }
      this.sWidth = 0;
      this.sHeight = 0;
      this.sOrientation = 0;
      this.sRegion = null;
      this.pRegion = null;
      this.readySent = false;
      this.imageLoadedSent = false;
      this.bitmap = null;
      this.bitmapIsPreview = false;
      this.bitmapIsCached = false;
      this.isPreviewLoaded = false;
      this.canDrawPreview = false;
      this.isFirstLoadFullImage = true;
      if (this.tileMap == null) {
        break label534;
      }
      localObject1 = this.tileMap.entrySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label529;
        }
        Iterator localIterator = ((List)((Map.Entry)((Iterator)localObject1).next()).getValue()).iterator();
        while (localIterator.hasNext())
        {
          localTile = (Tile)localIterator.next();
          localTile.visible = false;
          if (localTile.bitmap != null)
          {
            if (this.mPreviewSource == null) {
              break label489;
            }
            if (this.mPreviewSource.bitmap != localTile.bitmap) {
              break label512;
            }
            Log.i(this.TAG, "alvinluo reset tile bitmap not need to recycle: %d", new Object[] { Integer.valueOf(localTile.bitmap.hashCode()) });
          }
        }
      }
    }
    finally
    {
      label489:
      this.decoderLock.writeLock().unlock();
      AppMethodBeat.o(157404);
    }
    label529:
    this.tileMap = null;
    label534:
    setGestureDetector(getContext());
    AppMethodBeat.o(157404);
  }
  
  private int sHeight()
  {
    AppMethodBeat.i(157434);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.sWidth;
      AppMethodBeat.o(157434);
      return i;
    }
    i = this.sHeight;
    AppMethodBeat.o(157434);
    return i;
  }
  
  private int sWidth()
  {
    AppMethodBeat.i(157433);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.sHeight;
      AppMethodBeat.o(157433);
      return i;
    }
    i = this.sWidth;
    AppMethodBeat.o(157433);
    return i;
  }
  
  public static void setBitmapLoaderImp(IBitmapLoaderFactory paramIBitmapLoaderFactory)
  {
    mBitmapLoader = paramIBitmapLoaderFactory;
  }
  
  private void setFullImageBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(157425);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(157380);
        if (paramBitmap != null)
        {
          long l1 = System.currentTimeMillis();
          SubsamplingScaleImageView.access$4602(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.n(paramBitmap, SubsamplingScaleImageView.this.sOrientation));
          long l2 = System.currentTimeMillis();
          Log.i(SubsamplingScaleImageView.this.TAG, "alvinluo rotate and scale fullImageBitmap cost: %d", new Object[] { Long.valueOf(l2 - l1) });
        }
        AppMethodBeat.o(157380);
      }
    }, "rotateAndScaleBitmap");
    AppMethodBeat.o(157425);
  }
  
  private void setGestureDetector(final Context paramContext)
  {
    AppMethodBeat.i(157405);
    this.detector = new GestureDetector(paramContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(208500);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(208500);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157378);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        if ((SubsamplingScaleImageView.this.onDoubleTapListener != null) && (SubsamplingScaleImageView.this.onDoubleTapListener.onDoubleTap(paramAnonymousMotionEvent)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(157378);
          return true;
        }
        if ((SubsamplingScaleImageView.this.zoomEnabled) && (SubsamplingScaleImageView.this.readySent) && (SubsamplingScaleImageView.this.vTranslate != null))
        {
          SubsamplingScaleImageView.access$1600(SubsamplingScaleImageView.this, paramContext);
          Log.i(SubsamplingScaleImageView.this.TAG, "alvinluo onDoubleTap, quickScaledEnabled: %b", new Object[] { Boolean.valueOf(SubsamplingScaleImageView.this.quickScaleEnabled) });
          if (SubsamplingScaleImageView.this.quickScaleEnabled)
          {
            SubsamplingScaleImageView.access$1902(SubsamplingScaleImageView.this, new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()));
            SubsamplingScaleImageView.access$2002(SubsamplingScaleImageView.this, new PointF(SubsamplingScaleImageView.this.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y));
            SubsamplingScaleImageView.access$2102(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.scale);
            SubsamplingScaleImageView.c(SubsamplingScaleImageView.this);
            SubsamplingScaleImageView.d(SubsamplingScaleImageView.this);
            SubsamplingScaleImageView.e(SubsamplingScaleImageView.this);
            SubsamplingScaleImageView.access$2402(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.viewToSourceCoord(SubsamplingScaleImageView.this.vCenterStart));
            SubsamplingScaleImageView.access$2502(SubsamplingScaleImageView.this, new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()));
            SubsamplingScaleImageView.access$2602(SubsamplingScaleImageView.this, new PointF(SubsamplingScaleImageView.this.quickScaleSCenter.x, SubsamplingScaleImageView.this.quickScaleSCenter.y));
            SubsamplingScaleImageView.f(SubsamplingScaleImageView.this);
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(157378);
            return false;
          }
          SubsamplingScaleImageView.access$2800(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.viewToSourceCoord(new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY())), new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()));
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(157378);
          return true;
        }
        boolean bool = super.onDoubleTapEvent(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(157378);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(157376);
        if ((SubsamplingScaleImageView.this.panEnabled) && (SubsamplingScaleImageView.this.readySent) && (SubsamplingScaleImageView.this.vTranslate != null) && (paramAnonymousMotionEvent1 != null) && (paramAnonymousMotionEvent2 != null) && ((Math.abs(paramAnonymousMotionEvent1.getX() - paramAnonymousMotionEvent2.getX()) > 50.0F) || (Math.abs(paramAnonymousMotionEvent1.getY() - paramAnonymousMotionEvent2.getY()) > 50.0F)) && ((Math.abs(paramAnonymousFloat1) > 500.0F) || (Math.abs(paramAnonymousFloat2) > 500.0F)) && (!SubsamplingScaleImageView.this.isZooming))
        {
          paramAnonymousMotionEvent1 = new PointF(SubsamplingScaleImageView.this.vTranslate.x + paramAnonymousFloat1 * 0.25F, SubsamplingScaleImageView.this.vTranslate.y + 0.25F * paramAnonymousFloat2);
          paramAnonymousFloat1 = (SubsamplingScaleImageView.this.getWidth() / 2 - paramAnonymousMotionEvent1.x) / SubsamplingScaleImageView.this.scale;
          paramAnonymousFloat2 = (SubsamplingScaleImageView.this.getHeight() / 2 - paramAnonymousMotionEvent1.y) / SubsamplingScaleImageView.this.scale;
          paramAnonymousMotionEvent1 = new SubsamplingScaleImageView.AnimationBuilder(SubsamplingScaleImageView.this, new PointF(paramAnonymousFloat1, paramAnonymousFloat2), (byte)0);
          if (!SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(1)))
          {
            paramAnonymousMotionEvent1 = new IllegalArgumentException("Unknown easing type: 1");
            AppMethodBeat.o(157376);
            throw paramAnonymousMotionEvent1;
          }
          paramAnonymousMotionEvent1.easing = 1;
          paramAnonymousMotionEvent1.panLimited = false;
          paramAnonymousMotionEvent1.origin = 3;
          paramAnonymousMotionEvent1.start();
          AppMethodBeat.o(157376);
          return true;
        }
        boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(157376);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(208499);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(208499);
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157377);
        if ((SubsamplingScaleImageView.this.onDoubleTapListener != null) && (SubsamplingScaleImageView.this.onDoubleTapListener.onSingleTapConfirmed(paramAnonymousMotionEvent)))
        {
          AppMethodBeat.o(157377);
          return true;
        }
        if (SubsamplingScaleImageView.this.gestureDetectorListener != null)
        {
          boolean bool = SubsamplingScaleImageView.this.gestureDetectorListener.onSingleTapConfirmed(paramAnonymousMotionEvent);
          if (bool)
          {
            AppMethodBeat.o(157377);
            return bool;
          }
        }
        SubsamplingScaleImageView.this.performClick();
        AppMethodBeat.o(157377);
        return true;
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(208493);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(208493);
        return bool;
      }
    });
    this.singleDetector = new GestureDetector(paramContext, new SubsamplingScaleImageView.4(this));
    AppMethodBeat.o(157405);
  }
  
  private static void setMatrixArray(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramArrayOfFloat[0] = paramFloat1;
    paramArrayOfFloat[1] = paramFloat2;
    paramArrayOfFloat[2] = paramFloat3;
    paramArrayOfFloat[3] = paramFloat4;
    paramArrayOfFloat[4] = paramFloat5;
    paramArrayOfFloat[5] = paramFloat6;
    paramArrayOfFloat[6] = paramFloat7;
    paramArrayOfFloat[7] = paramFloat8;
  }
  
  public static void setPreferredBitmapConfig(Bitmap.Config paramConfig)
  {
    preferredBitmapConfig = paramConfig;
  }
  
  public static void setTileInitLoaderImp(ITileInitLoaderFactory paramITileInitLoaderFactory)
  {
    mTileInitLoader = paramITileInitLoaderFactory;
  }
  
  public static void setTileLoaderImp(ITileLoaderFactory paramITileLoaderFactory)
  {
    mTileLoader = paramITileLoaderFactory;
  }
  
  private PointF sourceToViewCoord(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    AppMethodBeat.i(157439);
    if (this.vTranslate == null)
    {
      AppMethodBeat.o(157439);
      return null;
    }
    paramPointF.set(sourceToViewX(paramFloat1), sourceToViewY(paramFloat2));
    AppMethodBeat.o(157439);
    return paramPointF;
  }
  
  private PointF vTranslateForSCenter(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(157440);
    int i = getPaddingLeft();
    int j = (getWidth() - getPaddingRight() - getPaddingLeft()) / 2;
    int k = getPaddingTop();
    int m = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2;
    if (this.satTemp == null) {
      this.satTemp = new ScaleAndTranslate(0.0F, new PointF(0.0F, 0.0F), (byte)0);
    }
    this.satTemp.scale = paramFloat3;
    this.satTemp.vTranslate.set(i + j - paramFloat1 * paramFloat3, k + m - paramFloat2 * paramFloat3);
    fitToBounds(true, this.satTemp);
    PointF localPointF = this.satTemp.vTranslate;
    AppMethodBeat.o(157440);
    return localPointF;
  }
  
  private PointF viewToSourceCoord(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    AppMethodBeat.i(157437);
    if (this.vTranslate == null)
    {
      AppMethodBeat.o(157437);
      return null;
    }
    paramPointF.set(viewToSourceX(paramFloat1), viewToSourceY(paramFloat2));
    AppMethodBeat.o(157437);
    return paramPointF;
  }
  
  private float viewToSourceX(float paramFloat)
  {
    if (this.vTranslate == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.vTranslate.x) / this.scale;
  }
  
  private float viewToSourceY(float paramFloat)
  {
    if (this.vTranslate == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.vTranslate.y) / this.scale;
  }
  
  private void zoomScaleAndCenter(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    AppMethodBeat.i(157412);
    paramPointF1 = new AnimationBuilder(paramFloat, paramPointF1, paramPointF2, (byte)0);
    paramPointF1.interruptible = false;
    paramPointF1.duration = this.zoomScaleDuration;
    paramPointF1.origin = 2;
    paramPointF1.start();
    AppMethodBeat.o(157412);
  }
  
  public final void a(ImageSource paramImageSource1, ImageSource paramImageSource2)
  {
    AppMethodBeat.i(208764);
    if (paramImageSource1 == null)
    {
      paramImageSource1 = new NullPointerException("imageSource must not be null");
      AppMethodBeat.o(208764);
      throw paramImageSource1;
    }
    this.mMainImageSource = paramImageSource1;
    this.mPreviewSource = paramImageSource2;
    reset(true);
    if (paramImageSource1.getUri() != null) {
      this.sOrientation = getExifOrientation(getContext(), paramImageSource1.getUri());
    }
    if (paramImageSource2 != null)
    {
      if ((paramImageSource1.sWidth > 0) && (paramImageSource1.sHeight > 0)) {
        break label157;
      }
      Log.e(this.TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
    }
    while ((paramImageSource1.bitmap != null) && (paramImageSource1.sRegion != null))
    {
      onImageLoaded(Bitmap.createBitmap(paramImageSource1.bitmap, paramImageSource1.sRegion.left, paramImageSource1.sRegion.top, paramImageSource1.sRegion.width(), paramImageSource1.sRegion.height()), 0, false);
      AppMethodBeat.o(208764);
      return;
      label157:
      this.sWidth = paramImageSource1.sWidth;
      this.sHeight = paramImageSource1.sHeight;
      this.pRegion = paramImageSource2.sRegion;
      if (paramImageSource2.bitmap != null)
      {
        this.bitmapIsCached = paramImageSource2.cached;
        onPreviewLoaded(paramImageSource2.bitmap, Integer.valueOf(0));
      }
      else
      {
        Uri localUri2 = paramImageSource2.getUri();
        Uri localUri1 = localUri2;
        if (localUri2 == null)
        {
          localUri1 = localUri2;
          if (paramImageSource2.resource != null) {
            localUri1 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + paramImageSource2.resource);
          }
        }
        mBitmapLoader.newInstance(this, getContext(), this.bitmapDecoderFactory, localUri1, true).startLoad();
      }
    }
    if (paramImageSource1.bitmap != null)
    {
      onImageLoaded(paramImageSource1.bitmap, 0, paramImageSource1.cached);
      AppMethodBeat.o(208764);
      return;
    }
    this.sRegion = paramImageSource1.sRegion;
    this.uri = paramImageSource1.getUri();
    if ((this.uri == null) && (paramImageSource1.resource != null)) {
      this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + paramImageSource1.resource);
    }
    if ((paramImageSource1.tile) || (this.sRegion != null))
    {
      mTileInitLoader.newInstance(this, getContext(), this.regionDecoderFactory, this.uri).startLoad();
      AppMethodBeat.o(208764);
      return;
    }
    mBitmapLoader.newInstance(this, getContext(), this.bitmapDecoderFactory, this.uri, false).startLoad();
    AppMethodBeat.o(208764);
  }
  
  public final void addPreviewLoadedTime(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157389);
      if (this.mImageDecodeRecord != null)
      {
        ImageDecodeRecord localImageDecodeRecord = this.mImageDecodeRecord;
        localImageDecodeRecord.mPreviewLoadedTime += paramInt;
        Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localImageDecodeRecord.mPreviewLoadedTime) });
      }
      AppMethodBeat.o(157389);
      return;
    }
    finally {}
  }
  
  public final void addTileDecodeTime(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157390);
      if (this.mImageDecodeRecord != null)
      {
        ImageDecodeRecord localImageDecodeRecord = this.mImageDecodeRecord;
        localImageDecodeRecord.mTileDecodeTime += paramInt;
        Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localImageDecodeRecord.mTileDecodeTime) });
      }
      AppMethodBeat.o(157390);
      return;
    }
    finally {}
  }
  
  public final void addTileInitTime(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157388);
      if (this.mImageDecodeRecord != null)
      {
        ImageDecodeRecord localImageDecodeRecord = this.mImageDecodeRecord;
        localImageDecodeRecord.mTileInitTime += paramInt;
        Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localImageDecodeRecord.mTileInitTime) });
      }
      AppMethodBeat.o(157388);
      return;
    }
    finally {}
  }
  
  public final void debug(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(157444);
    Log.d(this.TAG, String.format(paramString, paramVarArgs));
    AppMethodBeat.o(157444);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157408);
    Log.d(this.TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(157408);
    return bool;
  }
  
  public final float doubleTapZoom(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(208558);
    float f2;
    int i;
    label121:
    float f1;
    if (!this.panEnabled)
    {
      if (this.sRequestedCenter != null)
      {
        paramPointF1.x = this.sRequestedCenter.x;
        paramPointF1.y = this.sRequestedCenter.y;
      }
    }
    else
    {
      f2 = getDoubleTapZoomScale();
      Log.i(this.TAG, "alvinluo doubleTapZoom %f, scale: %s, mScaleRate: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.scale), Float.valueOf(this.mScaleRate) });
      if ((this.scale > f2 * 0.9D) && (this.scale != this.mScaleRate)) {
        break label180;
      }
      i = 1;
      if (i == 0) {
        break label186;
      }
      f1 = f2;
      label129:
      if (this.doubleTapZoomStyle != 3) {
        break label194;
      }
      setScaleAndCenter(f1, paramPointF1);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(208558);
      return f1;
      paramPointF1.x = (sWidth() / 2);
      paramPointF1.y = (sHeight() / 2);
      break;
      label180:
      i = 0;
      break label121;
      label186:
      f1 = this.mScaleRate;
      break label129;
      label194:
      if ((this.doubleTapZoomStyle == 2) || (i == 0) || (!this.panEnabled))
      {
        paramPointF1 = new AnimationBuilder(f1, paramPointF1, (byte)0);
        paramPointF1.interruptible = false;
        paramPointF1.duration = this.doubleTapZoomDuration;
        paramPointF1.origin = 4;
        paramPointF1.start();
      }
      else if (this.doubleTapZoomStyle == 1)
      {
        paramPointF1 = new AnimationBuilder(f2, paramPointF1, paramPointF2, (byte)0);
        paramPointF1.interruptible = false;
        paramPointF1.duration = this.doubleTapZoomDuration;
        paramPointF1.origin = 4;
        paramPointF1.start();
      }
    }
  }
  
  public final int getAppliedOrientation()
  {
    AppMethodBeat.i(157457);
    int i = getRequiredRotation();
    AppMethodBeat.o(157457);
    return i;
  }
  
  public final PointF getCenter()
  {
    AppMethodBeat.i(157455);
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    PointF localPointF = viewToSourceCoord(i, j, new PointF());
    AppMethodBeat.o(157455);
    return localPointF;
  }
  
  public ReadWriteLock getDecoderLock()
  {
    return this.decoderLock;
  }
  
  /* Error */
  public final int getExifOrientation(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc_w 1398
    //   6: invokestatic 224	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc_w 1400
    //   12: aload_2
    //   13: invokevirtual 1403	android/net/Uri:getScheme	()Ljava/lang/String;
    //   16: invokevirtual 1404	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifeq +168 -> 187
    //   22: aload_1
    //   23: invokevirtual 1408	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   26: aload_2
    //   27: iconst_1
    //   28: anewarray 506	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc_w 1409
    //   36: aastore
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 1415	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +86 -> 131
    //   48: aload_1
    //   49: invokeinterface 1420 1 0
    //   54: ifeq +77 -> 131
    //   57: aload_1
    //   58: iconst_0
    //   59: invokeinterface 1423 2 0
    //   64: istore_3
    //   65: getstatic 238	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:VALID_ORIENTATIONS	Ljava/util/List;
    //   68: iload_3
    //   69: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: invokeinterface 1426 2 0
    //   77: istore 5
    //   79: iload 5
    //   81: ifeq +33 -> 114
    //   84: iload_3
    //   85: iconst_m1
    //   86: if_icmpeq +28 -> 114
    //   89: iload_3
    //   90: istore 4
    //   92: aload_1
    //   93: ifnull +12 -> 105
    //   96: aload_1
    //   97: invokeinterface 1429 1 0
    //   102: iload_3
    //   103: istore 4
    //   105: ldc_w 1398
    //   108: invokestatic 276	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: iload 4
    //   113: ireturn
    //   114: aload_0
    //   115: getfield 308	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   118: ldc_w 1431
    //   121: iload_3
    //   122: invokestatic 854	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   125: invokevirtual 858	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   128: invokestatic 1434	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: iconst_0
    //   132: istore_3
    //   133: goto -44 -> 89
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_1
    //   139: aload_0
    //   140: getfield 308	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   143: ldc_w 1436
    //   146: invokestatic 1434	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_1
    //   150: ifnull +217 -> 367
    //   153: aload_1
    //   154: invokeinterface 1429 1 0
    //   159: iconst_0
    //   160: istore 4
    //   162: goto -57 -> 105
    //   165: astore_1
    //   166: aload 6
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +9 -> 179
    //   173: aload_2
    //   174: invokeinterface 1429 1 0
    //   179: ldc_w 1398
    //   182: invokestatic 276	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload_1
    //   186: athrow
    //   187: aload_2
    //   188: aconst_null
    //   189: invokestatic 1441	com/tencent/mm/vfs/y:b	(Landroid/net/Uri;Lcom/tencent/mm/vfs/k$f;)Ljava/io/InputStream;
    //   192: astore_2
    //   193: new 1443	androidx/f/a/a
    //   196: dup
    //   197: aload_2
    //   198: invokespecial 1446	androidx/f/a/a:<init>	(Ljava/io/InputStream;)V
    //   201: ldc_w 1448
    //   204: iconst_1
    //   205: invokevirtual 1452	androidx/f/a/a:k	(Ljava/lang/String;I)I
    //   208: istore_3
    //   209: iload_3
    //   210: iconst_1
    //   211: if_icmpeq +7 -> 218
    //   214: iload_3
    //   215: ifne +39 -> 254
    //   218: iconst_0
    //   219: istore_3
    //   220: iload_3
    //   221: istore 4
    //   223: aload_2
    //   224: ifnull -119 -> 105
    //   227: aload_2
    //   228: invokevirtual 1455	java/io/InputStream:close	()V
    //   231: iload_3
    //   232: istore 4
    //   234: goto -129 -> 105
    //   237: astore_1
    //   238: aload_0
    //   239: getfield 308	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   242: ldc_w 1457
    //   245: invokestatic 1434	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: iload_3
    //   249: istore 4
    //   251: goto -146 -> 105
    //   254: iload_3
    //   255: bipush 6
    //   257: if_icmpne +9 -> 266
    //   260: bipush 90
    //   262: istore_3
    //   263: goto -43 -> 220
    //   266: iload_3
    //   267: iconst_3
    //   268: if_icmpne +10 -> 278
    //   271: sipush 180
    //   274: istore_3
    //   275: goto -55 -> 220
    //   278: iload_3
    //   279: bipush 8
    //   281: if_icmpne +10 -> 291
    //   284: sipush 270
    //   287: istore_3
    //   288: goto -68 -> 220
    //   291: aload_0
    //   292: getfield 308	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   295: ldc_w 1459
    //   298: iload_3
    //   299: invokestatic 854	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   302: invokevirtual 858	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   305: invokestatic 1434	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: iconst_0
    //   309: istore_3
    //   310: goto -90 -> 220
    //   313: astore_1
    //   314: aload_2
    //   315: ifnull +7 -> 322
    //   318: aload_2
    //   319: invokevirtual 1455	java/io/InputStream:close	()V
    //   322: ldc_w 1398
    //   325: invokestatic 276	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: aload_1
    //   329: athrow
    //   330: astore_2
    //   331: aload_1
    //   332: aload_2
    //   333: invokevirtual 1465	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   336: goto -14 -> 322
    //   339: astore_2
    //   340: aload_1
    //   341: astore 6
    //   343: aload_2
    //   344: astore_1
    //   345: aload 6
    //   347: astore_2
    //   348: goto -179 -> 169
    //   351: astore_2
    //   352: aload_1
    //   353: astore 6
    //   355: aload_2
    //   356: astore_1
    //   357: aload 6
    //   359: astore_2
    //   360: goto -191 -> 169
    //   363: astore_2
    //   364: goto -225 -> 139
    //   367: iconst_0
    //   368: istore 4
    //   370: goto -265 -> 105
    //   373: astore_1
    //   374: iconst_0
    //   375: istore_3
    //   376: goto -138 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	SubsamplingScaleImageView
    //   0	379	1	paramContext	Context
    //   0	379	2	paramUri	Uri
    //   64	312	3	i	int
    //   90	279	4	j	int
    //   77	3	5	bool	boolean
    //   1	357	6	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   22	44	136	java/lang/Exception
    //   22	44	165	finally
    //   227	231	237	java/lang/Exception
    //   193	209	313	finally
    //   291	308	313	finally
    //   318	322	330	finally
    //   48	79	339	finally
    //   114	131	339	finally
    //   139	149	351	finally
    //   48	79	363	java/lang/Exception
    //   114	131	363	java/lang/Exception
    //   187	193	373	java/lang/Exception
    //   322	330	373	java/lang/Exception
    //   331	336	373	java/lang/Exception
  }
  
  public Bitmap getFullImageBitmap()
  {
    return this.fullImageBitmap;
  }
  
  public int getFullImageSampleSize()
  {
    return this.fullImageSampleSize;
  }
  
  public ImageDecodeRecord getImageDecodeRecord()
  {
    try
    {
      ImageDecodeRecord localImageDecodeRecord = this.mImageDecodeRecord;
      return localImageDecodeRecord;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public PointF getImageViewMatrixScale()
  {
    AppMethodBeat.i(208753);
    if ((Float.isNaN(this.scale)) || (Float.isInfinite(this.scale)))
    {
      localPointF = new PointF(1.0F, 1.0F);
      AppMethodBeat.o(208753);
      return localPointF;
    }
    PointF localPointF = new PointF(this.scale, this.scale);
    AppMethodBeat.o(208753);
    return localPointF;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(208754);
    if (this.vTranslate != null)
    {
      PointF localPointF = new PointF(this.vTranslate.x, this.vTranslate.y);
      AppMethodBeat.o(208754);
      return localPointF;
    }
    AppMethodBeat.o(208754);
    return null;
  }
  
  public boolean getInternalTouchEventConsumed()
  {
    return this.IsinternalTouchEventConsumed;
  }
  
  public float getMaxScale()
  {
    return this.maxScale;
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(157453);
    float f = minScale();
    AppMethodBeat.o(157453);
    return f;
  }
  
  public OnImageEventListener getOnImageEventListener()
  {
    return this.onImageEventListener;
  }
  
  public final int getOrientation()
  {
    return this.orientation;
  }
  
  public int getPreviewHeight()
  {
    return this.previewHeight;
  }
  
  public int getPreviewOrientation()
  {
    return this.previewOrientation;
  }
  
  public int getPreviewWidth()
  {
    return this.previewWidth;
  }
  
  public int getRequiredRotation()
  {
    if (this.orientation == -1) {
      return this.sOrientation;
    }
    return this.orientation;
  }
  
  public final int getSHeight()
  {
    return this.sHeight;
  }
  
  public final int getSWidth()
  {
    return this.sWidth;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  public final ImageViewState getState()
  {
    AppMethodBeat.i(157458);
    if ((this.vTranslate != null) && (this.sWidth > 0) && (this.sHeight > 0))
    {
      ImageViewState localImageViewState = new ImageViewState(getScale(), getCenter(), getOrientation());
      AppMethodBeat.o(157458);
      return localImageViewState;
    }
    AppMethodBeat.o(157458);
    return null;
  }
  
  public Rect getsRegion()
  {
    return this.sRegion;
  }
  
  public final Bitmap n(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(157427);
    if (paramBitmap == null)
    {
      Log.e(this.TAG, "alvinluo rotateAndScaleBitmap bitmap is null");
      AppMethodBeat.o(157427);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(1.0F, 1.0F);
    if (paramInt != 0) {
      localMatrix.postRotate(paramInt);
    }
    Log.d(this.TAG, "alvinluo rotateAndScaleBitmap matrix.isIdentify: %b", new Object[] { Boolean.valueOf(localMatrix.isIdentity()) });
    if ((paramBitmap.getWidth() > 0) && (paramBitmap.getHeight() > 0))
    {
      if (localMatrix.isIdentity())
      {
        AppMethodBeat.o(157427);
        return paramBitmap;
      }
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
        AppMethodBeat.o(157427);
        return paramBitmap;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        Log.printErrStackTrace(this.TAG, paramBitmap, "alvinluo createBitmap oom", new Object[0]);
        preferredBitmapConfig = Bitmap.Config.RGB_565;
        AppMethodBeat.o(157427);
        return null;
      }
    }
    AppMethodBeat.o(157427);
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(157391);
    super.onAttachedToWindow();
    if (this.onAttachStateChangeListener != null) {
      this.onAttachStateChangeListener.onViewAttachedToWindow(this);
    }
    this.cancelled = false;
    AppMethodBeat.o(157391);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(157392);
    super.onDetachedFromWindow();
    if (!this.cancelled)
    {
      this.cancelled = true;
      Log.i(this.TAG, "alvinluo cancelAllTileLoadTask, task size: %d", new Object[] { Integer.valueOf(this.mTileLoadTaskList.size()) });
      Iterator localIterator = this.mTileLoadTaskList.iterator();
      while (localIterator.hasNext()) {
        ((ILoadable)localIterator.next()).cancel();
      }
      this.mTileLoadTaskList.clear();
    }
    if (this.onAttachStateChangeListener != null) {
      this.onAttachStateChangeListener.onViewDetachedFromWindow(this);
    }
    AppMethodBeat.o(157392);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(208565);
    super.onDraw(paramCanvas);
    System.currentTimeMillis();
    if (this.bitmapPaint == null)
    {
      this.bitmapPaint = new Paint();
      this.bitmapPaint.setAntiAlias(true);
      this.bitmapPaint.setFilterBitmap(true);
      this.bitmapPaint.setDither(true);
    }
    if (((this.debugTextPaint == null) || (this.debugLinePaint == null)) && (this.debug))
    {
      this.debugTextPaint = new Paint();
      this.debugTextPaint.setTextSize(px(20));
      this.debugTextPaint.setColor(-65281);
      this.debugTextPaint.setStyle(Paint.Style.FILL);
      this.debugLinePaint = new Paint();
      this.debugLinePaint.setColor(-65281);
      this.debugLinePaint.setStyle(Paint.Style.STROKE);
      this.debugLinePaint.setStrokeWidth(px(1));
    }
    if ((this.sWidth == 0) || (this.sHeight == 0) || (getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(208565);
      return;
    }
    int j;
    int k;
    if ((this.tileMap == null) && (this.decoder != null))
    {
      j = Math.min(paramCanvas.getMaximumBitmapWidth(), this.maxTileWidth);
      k = Math.min(paramCanvas.getMaximumBitmapHeight(), this.maxTileHeight);
      i = j;
      if (j > 10000) {
        i = 10000;
      }
      j = k;
      if (k > 10000) {
        j = 10000;
      }
      Log.i(this.TAG, "alvinluo getMaxBitmapDimensions %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      initialiseBaseLayer(new Point(i, j));
    }
    if (!checkReady())
    {
      AppMethodBeat.o(208565);
      return;
    }
    if (this.canRefresh) {
      preDraw();
    }
    float f1;
    boolean bool1;
    boolean bool2;
    if ((this.anim != null) && (this.anim.vFocusStart != null))
    {
      f1 = this.scale;
      if (this.vTranslateBefore == null) {
        this.vTranslateBefore = new PointF(0.0F, 0.0F);
      }
      this.vTranslateBefore.set(this.vTranslate);
      long l = System.currentTimeMillis() - this.anim.time;
      if (l > this.anim.duration)
      {
        bool1 = true;
        l = Math.min(l, this.anim.duration);
        this.scale = ease(this.anim.easing, l, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
        f2 = ease(this.anim.easing, l, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
        float f3 = ease(this.anim.easing, l, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
        localObject1 = this.vTranslate;
        ((PointF)localObject1).x -= sourceToViewX(this.anim.sCenterEnd.x) - f2;
        localObject1 = this.vTranslate;
        ((PointF)localObject1).y -= sourceToViewY(this.anim.sCenterEnd.y) - f3;
        if ((!bool1) && (this.anim.scaleStart != this.anim.scaleEnd)) {
          break label898;
        }
        bool2 = true;
        label683:
        fitToBounds(bool2);
        a(f1, this.vTranslateBefore);
        refreshRequiredTiles(bool1);
        if (bool1) {
          this.anim = null;
        }
        invalidate();
      }
    }
    else
    {
      if ((this.tileMap == null) || (!isBaseLayerReady()) || (!this.mPreviewDone)) {
        break label1812;
      }
      k = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
      localObject1 = this.tileMap.entrySet().iterator();
    }
    Object localObject2;
    Object localObject3;
    for (int i = 0;; i = j)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label911;
      }
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      j = i;
      if (((Integer)((Map.Entry)localObject2).getKey()).intValue() == k)
      {
        localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (Tile)((Iterator)localObject2).next();
          if ((((Tile)localObject3).visible) && ((((Tile)localObject3).loading) || (((Tile)localObject3).bitmap == null))) {
            i = 1;
          }
        }
        bool1 = false;
        break;
        label898:
        bool2 = false;
        break label683;
      }
    }
    label911:
    Object localObject1 = this.tileMap.entrySet().iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((((Integer)((Map.Entry)localObject2).getKey()).intValue() == k) || (i != 0))
        {
          localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
          label1810:
          for (;;)
          {
            label989:
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Tile)((Iterator)localObject2).next();
              Rect localRect = ((Tile)localObject3).sRect;
              ((Tile)localObject3).vRect.set((int)sourceToViewX(localRect.left), (int)sourceToViewY(localRect.top), (int)sourceToViewX(localRect.right), (int)sourceToViewY(localRect.bottom));
              if ((((Tile)localObject3).loading) || (((Tile)localObject3).bitmap == null)) {
                break label1752;
              }
              if (this.tileBgPaint != null) {
                paramCanvas.drawRect(((Tile)localObject3).vRect, this.tileBgPaint);
              }
              if (this.matrix == null) {
                this.matrix = new Matrix();
              }
              this.matrix.reset();
              setMatrixArray(this.srcArray, 0.0F, 0.0F, ((Tile)localObject3).bitmap.getWidth(), 0.0F, ((Tile)localObject3).bitmap.getWidth(), ((Tile)localObject3).bitmap.getHeight(), 0.0F, ((Tile)localObject3).bitmap.getHeight());
              if (getRequiredRotation() != 0) {
                break label1477;
              }
              setMatrixArray(this.dstArray, ((Tile)localObject3).vRect.left, ((Tile)localObject3).vRect.top, ((Tile)localObject3).vRect.right, ((Tile)localObject3).vRect.top, ((Tile)localObject3).vRect.right, ((Tile)localObject3).vRect.bottom, ((Tile)localObject3).vRect.left, ((Tile)localObject3).vRect.bottom);
              label1264:
              this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
              if (!((Tile)localObject3).bitmap.isRecycled()) {
                paramCanvas.drawBitmap(((Tile)localObject3).bitmap, this.matrix, this.bitmapPaint);
              }
              if (this.debug) {
                paramCanvas.drawRect(((Tile)localObject3).vRect, this.debugLinePaint);
              }
            }
            for (;;)
            {
              if ((!((Tile)localObject3).visible) || (!this.debug)) {
                break label1810;
              }
              paramCanvas.drawText("ISS " + ((Tile)localObject3).sampleSize + " RECT " + ((Tile)localObject3).sRect.top + "," + ((Tile)localObject3).sRect.left + "," + ((Tile)localObject3).sRect.bottom + "," + ((Tile)localObject3).sRect.right, ((Tile)localObject3).vRect.left + px(5), ((Tile)localObject3).vRect.top + px(15), this.debugTextPaint);
              break label989;
              break;
              label1477:
              if (getRequiredRotation() == 90)
              {
                setMatrixArray(this.dstArray, ((Tile)localObject3).vRect.right, ((Tile)localObject3).vRect.top, ((Tile)localObject3).vRect.right, ((Tile)localObject3).vRect.bottom, ((Tile)localObject3).vRect.left, ((Tile)localObject3).vRect.bottom, ((Tile)localObject3).vRect.left, ((Tile)localObject3).vRect.top);
                break label1264;
              }
              if (getRequiredRotation() == 180)
              {
                setMatrixArray(this.dstArray, ((Tile)localObject3).vRect.right, ((Tile)localObject3).vRect.bottom, ((Tile)localObject3).vRect.left, ((Tile)localObject3).vRect.bottom, ((Tile)localObject3).vRect.left, ((Tile)localObject3).vRect.top, ((Tile)localObject3).vRect.right, ((Tile)localObject3).vRect.top);
                break label1264;
              }
              if (getRequiredRotation() != 270) {
                break label1264;
              }
              setMatrixArray(this.dstArray, ((Tile)localObject3).vRect.left, ((Tile)localObject3).vRect.bottom, ((Tile)localObject3).vRect.left, ((Tile)localObject3).vRect.top, ((Tile)localObject3).vRect.right, ((Tile)localObject3).vRect.top, ((Tile)localObject3).vRect.right, ((Tile)localObject3).vRect.bottom);
              break label1264;
              label1752:
              if ((((Tile)localObject3).loading) && (this.debug)) {
                paramCanvas.drawText("LOADING", ((Tile)localObject3).vRect.left + px(5), ((Tile)localObject3).vRect.top + px(35), this.debugTextPaint);
              }
            }
          }
          label1812:
          if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
          {
            Log.d(this.TAG, "alvinluo onDraw bitmap scale: %f", new Object[] { Float.valueOf(this.scale) });
            if ((!this.bitmapIsPreview) || (this.canDrawPreview))
            {
              if (this.matrix == null) {
                this.matrix = new Matrix();
              }
              this.matrix.reset();
              i = this.bitmap.getWidth();
              j = this.bitmap.getHeight();
              if ((this.previewOrientation == 90) || (this.previewOrientation == 270))
              {
                i = this.bitmap.getHeight();
                j = this.bitmap.getWidth();
              }
              if (this.bitmapIsPreview)
              {
                f1 = i / 2.0F;
                f2 = j / 2.0F;
                initPreviewScale();
                this.matrix.postScale(this.mPreviewWidthScaleRate, this.mPreviewHeightScaleRate, f1, f2);
              }
              f1 = (this.mViewWidth - this.bitmap.getWidth()) / 2;
              f2 = (this.mViewHeight - this.bitmap.getHeight()) / 2;
              this.matrix.postTranslate(f1, f2);
              Log.d(this.TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
              if (this.tileBgPaint != null)
              {
                if (this.sRect == null) {
                  this.sRect = new RectF();
                }
                localObject1 = this.sRect;
                if (!this.bitmapIsPreview) {
                  break label2895;
                }
                f1 = this.bitmap.getWidth();
                if (!this.bitmapIsPreview) {
                  break label2904;
                }
              }
            }
          }
        }
      }
    }
    label2895:
    label2904:
    for (float f2 = this.bitmap.getHeight();; f2 = this.sHeight)
    {
      ((RectF)localObject1).set(0.0F, 0.0F, f1, f2);
      this.matrix.mapRect(this.sRect);
      paramCanvas.drawRect(this.sRect, this.tileBgPaint);
      paramCanvas.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
      if (this.debug)
      {
        Log.d(this.TAG, "alvinluo onDraw debug vTranslate %f, %f", new Object[] { Float.valueOf(this.vTranslate.x), Float.valueOf(this.vTranslate.y) });
        paramCanvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.scale) }) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(minScale()) }) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.maxScale) }) + ")", px(5), px(15), this.debugTextPaint);
        paramCanvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.vTranslate.x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.vTranslate.y) }), px(5), px(30), this.debugTextPaint);
        localObject1 = getCenter();
        paramCanvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).y) }), px(5), px(45), this.debugTextPaint);
        if (this.anim != null)
        {
          localObject1 = sourceToViewCoord(this.anim.sCenterStart);
          localObject2 = sourceToViewCoord(this.anim.sCenterEndRequested);
          localObject3 = sourceToViewCoord(this.anim.sCenterEnd);
          paramCanvas.drawCircle(((PointF)localObject1).x, ((PointF)localObject1).y, px(10), this.debugLinePaint);
          this.debugLinePaint.setColor(-65536);
          paramCanvas.drawCircle(((PointF)localObject2).x, ((PointF)localObject2).y, px(20), this.debugLinePaint);
          this.debugLinePaint.setColor(-16776961);
          paramCanvas.drawCircle(((PointF)localObject3).x, ((PointF)localObject3).y, px(25), this.debugLinePaint);
          this.debugLinePaint.setColor(-16711936);
          paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.debugLinePaint);
        }
        if (this.vCenterStart != null)
        {
          this.debugLinePaint.setColor(-65536);
          paramCanvas.drawCircle(this.vCenterStart.x, this.vCenterStart.y, px(20), this.debugLinePaint);
        }
        if (this.quickScaleSCenter != null)
        {
          this.debugLinePaint.setColor(-16776961);
          paramCanvas.drawCircle(sourceToViewX(this.quickScaleSCenter.x), sourceToViewY(this.quickScaleSCenter.y), px(35), this.debugLinePaint);
        }
        if ((this.quickScaleVStart != null) && (this.isQuickScaling))
        {
          this.debugLinePaint.setColor(-12303292);
          paramCanvas.drawCircle(this.quickScaleVStart.x, this.quickScaleVStart.y, px(30), this.debugLinePaint);
        }
        this.debugLinePaint.setColor(-65281);
      }
      AppMethodBeat.o(208565);
      return;
      f1 = this.sWidth;
      break;
    }
  }
  
  public final void onImageLoaded(final Bitmap paramBitmap, final int paramInt, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(157429);
      debug("onImageLoaded has bitmap", new Object[0]);
      if ((this.sWidth > 0) && (this.sHeight > 0) && ((this.sWidth != paramBitmap.getWidth()) || (this.sHeight != paramBitmap.getHeight()))) {
        reset(false);
      }
      if ((this.bitmap != null) && (!this.bitmapIsCached)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.bitmapIsCached) && (this.onImageEventListener != null)) {
        this.onImageEventListener.onPreviewReleased();
      }
      this.bitmapIsPreview = false;
      this.bitmapIsCached = paramBoolean;
      this.bitmap = paramBitmap;
      this.sWidth = paramBitmap.getWidth();
      this.sHeight = paramBitmap.getHeight();
      this.sOrientation = paramInt;
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(157382);
          long l1 = System.currentTimeMillis();
          if (paramInt != 0) {
            SubsamplingScaleImageView.access$4802(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.n(paramBitmap, paramInt));
          }
          long l2 = System.currentTimeMillis();
          Log.i(SubsamplingScaleImageView.this.TAG, "alvinluo onImageLoaded rotaeAndScaleBitmap %d", new Object[] { Long.valueOf(l2 - l1) });
          SubsamplingScaleImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157381);
              if ((SubsamplingScaleImageView.6.this.val$ready) || (SubsamplingScaleImageView.6.this.val$imageLoaded))
              {
                SubsamplingScaleImageView.this.invalidate();
                SubsamplingScaleImageView.this.requestLayout();
              }
              AppMethodBeat.o(157381);
            }
          });
          AppMethodBeat.o(157382);
        }
      }, "rotateAndScaleBitmap");
      AppMethodBeat.o(157429);
      return;
    }
    finally {}
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157407);
    int k = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (k != 1073741824)
    {
      paramInt2 = 1;
      if (i == 1073741824) {
        break label212;
      }
      i = 1;
      label47:
      if ((this.sWidth <= 0) || (this.sHeight <= 0)) {
        break label273;
      }
      if ((paramInt2 == 0) || (i == 0)) {
        break label217;
      }
      paramInt2 = sWidth();
      paramInt1 = sHeight();
    }
    for (;;)
    {
      label79:
      paramInt2 = Math.max(paramInt2, getSuggestedMinimumWidth());
      paramInt1 = Math.max(paramInt1, getSuggestedMinimumHeight());
      setMeasuredDimension(paramInt2, paramInt1);
      if ((paramInt2 != this.mViewWidth) || (paramInt1 != this.mViewHeight))
      {
        this.mViewWidth = paramInt2;
        this.mViewHeight = paramInt1;
      }
      for (boolean bool = true;; bool = false)
      {
        if ((bool) && (this.canRefresh)) {
          invalidate();
        }
        Log.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d, needRefresh: %s, canRefresh: %s", new Object[] { Integer.valueOf(this.mViewWidth), Integer.valueOf(this.mViewHeight), Boolean.valueOf(bool), Boolean.valueOf(this.canRefresh) });
        AppMethodBeat.o(157407);
        return;
        paramInt2 = 0;
        break;
        label212:
        i = 0;
        break label47;
        label217:
        if (i != 0)
        {
          paramInt1 = (int)(sHeight() / sWidth() * j);
          paramInt2 = j;
          break label79;
        }
        if (paramInt2 == 0) {
          break label273;
        }
        paramInt2 = (int)(sWidth() / sHeight() * paramInt1);
        break label79;
      }
      label273:
      paramInt2 = j;
    }
  }
  
  public final void onPreviewLoaded(Bitmap paramBitmap, Integer paramInteger)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(157428);
        Log.i(this.TAG, "alvinluo onPreviewLoaded");
        if (paramBitmap != null) {
          Log.i(this.TAG, "alvinluo onPreviewLoaded %d, recycle: %b", new Object[] { Integer.valueOf(paramBitmap.hashCode()), Boolean.valueOf(paramBitmap.isRecycled()) });
        }
        long l = System.currentTimeMillis();
        if (this.imageLoadedSent)
        {
          if (this.bitmap != null) {
            this.bitmap.recycle();
          }
          AppMethodBeat.o(157428);
          return;
        }
        if (this.pRegion != null)
        {
          if ((this.pRegion.width() > 0) && (this.pRegion.height() > 0))
          {
            this.bitmap = Bitmap.createBitmap(paramBitmap, this.pRegion.left, this.pRegion.top, this.pRegion.width(), this.pRegion.height());
            this.previewOrientation = 0;
          }
          this.bitmapIsPreview = true;
          this.canDrawPreview = false;
          this.previewWidth = this.bitmap.getWidth();
          this.previewHeight = this.bitmap.getHeight();
          initPreviewScale();
          this.canDrawPreview = true;
          if (checkReady())
          {
            invalidate();
            requestLayout();
          }
          addPreviewLoadedTime((int)(System.currentTimeMillis() - l));
          Log.i(this.TAG, "alvinluo onPreviewLoaded");
          if ((!this.isPreviewLoaded) && (this.onImageEventListener != null)) {
            this.onImageEventListener.onPreviewLoaded();
          }
          AppMethodBeat.o(157428);
          continue;
        }
        if (paramInteger == null) {
          break label283;
        }
      }
      finally {}
      this.previewOrientation = paramInteger.intValue();
      label283:
      this.bitmap = paramBitmap;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(157406);
    debug("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(this.scale), this.pendingScale, Boolean.valueOf(this.mNeedPendingScale) });
    initScaleRate();
    PointF localPointF = getCenter();
    if (((this.readySent) || (this.mNeedPendingScale)) && (localPointF != null))
    {
      this.anim = null;
      if (!this.mNeedPendingScale)
      {
        this.pendingScale = Float.valueOf(this.scale);
        this.sPendingCenter = localPointF;
      }
    }
    AppMethodBeat.o(157406);
  }
  
  /* Error */
  public final void onTileLoaded(Tile paramTile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 1818
    //   7: invokestatic 224	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokestatic 815	java/lang/System:currentTimeMillis	()J
    //   14: putfield 314	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:fullImageTileLoadedStart	J
    //   17: aload_0
    //   18: getfield 308	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   21: astore 4
    //   23: aload_1
    //   24: getfield 1019	com/davemorrissey/labs/subscaleview/model/Tile:sampleSize	I
    //   27: istore_2
    //   28: aload_1
    //   29: getfield 1068	com/davemorrissey/labs/subscaleview/model/Tile:bitmap	Landroid/graphics/Bitmap;
    //   32: ifnonnull +166 -> 198
    //   35: aload 4
    //   37: ldc_w 1820
    //   40: iconst_2
    //   41: anewarray 296	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: iload_2
    //   47: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: iload_3
    //   54: invokestatic 932	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 1353	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_1
    //   62: getfield 1019	com/davemorrissey/labs/subscaleview/model/Tile:sampleSize	I
    //   65: aload_0
    //   66: getfield 966	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:fullImageSampleSize	I
    //   69: if_icmpne +40 -> 109
    //   72: aload_1
    //   73: getfield 1068	com/davemorrissey/labs/subscaleview/model/Tile:bitmap	Landroid/graphics/Bitmap;
    //   76: ifnull +33 -> 109
    //   79: aload_0
    //   80: getfield 310	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:isFirstLoadFullImage	Z
    //   83: ifeq +26 -> 109
    //   86: aload_0
    //   87: getfield 308	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   90: ldc_w 1822
    //   93: invokestatic 799	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 310	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:isFirstLoadFullImage	Z
    //   101: aload_0
    //   102: aload_1
    //   103: getfield 1068	com/davemorrissey/labs/subscaleview/model/Tile:bitmap	Landroid/graphics/Bitmap;
    //   106: putfield 692	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:fullImageBitmap	Landroid/graphics/Bitmap;
    //   109: aload_0
    //   110: invokespecial 1639	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:checkReady	()Z
    //   113: pop
    //   114: aload_0
    //   115: invokespecial 1775	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:checkImageLoaded	()Z
    //   118: pop
    //   119: aload_0
    //   120: invokespecial 789	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:isBaseLayerReady	()Z
    //   123: ifeq +62 -> 185
    //   126: aload_0
    //   127: getfield 700	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   130: ifnull +55 -> 185
    //   133: aload_0
    //   134: getfield 1188	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmapIsCached	Z
    //   137: ifne +10 -> 147
    //   140: aload_0
    //   141: getfield 700	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   144: invokevirtual 1112	android/graphics/Bitmap:recycle	()V
    //   147: aload_0
    //   148: aconst_null
    //   149: putfield 700	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   152: aload_0
    //   153: getfield 704	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:onImageEventListener	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$OnImageEventListener;
    //   156: ifnull +19 -> 175
    //   159: aload_0
    //   160: getfield 1188	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmapIsCached	Z
    //   163: ifeq +12 -> 175
    //   166: aload_0
    //   167: getfield 704	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:onImageEventListener	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$OnImageEventListener;
    //   170: invokeinterface 1191 1 0
    //   175: aload_0
    //   176: iconst_0
    //   177: putfield 912	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmapIsPreview	Z
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 1188	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmapIsCached	Z
    //   185: aload_0
    //   186: invokevirtual 1385	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:invalidate	()V
    //   189: ldc_w 1818
    //   192: invokestatic 276	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload_0
    //   196: monitorexit
    //   197: return
    //   198: iconst_0
    //   199: istore_3
    //   200: goto -165 -> 35
    //   203: astore_1
    //   204: aload_0
    //   205: monitorexit
    //   206: aload_1
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	SubsamplingScaleImageView
    //   0	208	1	paramTile	Tile
    //   27	20	2	i	int
    //   1	199	3	bool	boolean
    //   21	15	4	str	String
    // Exception table:
    //   from	to	target	type
    //   4	35	203	finally
    //   35	109	203	finally
    //   109	147	203	finally
    //   147	175	203	finally
    //   175	185	203	finally
    //   185	195	203	finally
  }
  
  public final void onTilesInited(ImageRegionDecoder paramImageRegionDecoder, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(157424);
      debug("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.sWidth), Integer.valueOf(this.sHeight), Integer.valueOf(paramInt3) });
      if ((this.sWidth > 0) && (this.sHeight > 0) && ((this.sWidth != paramInt1) || (this.sHeight != paramInt2)))
      {
        reset(false);
        if (this.bitmap != null)
        {
          if (!this.bitmapIsCached) {
            this.bitmap.recycle();
          }
          this.bitmap = null;
          if ((this.onImageEventListener != null) && (this.bitmapIsCached)) {
            this.onImageEventListener.onPreviewReleased();
          }
          this.bitmapIsPreview = false;
          this.bitmapIsCached = false;
        }
      }
      this.decoder = paramImageRegionDecoder;
      this.sWidth = paramInt1;
      this.sHeight = paramInt2;
      this.sOrientation = paramInt3;
      checkReady();
      if ((!checkImageLoaded()) && (this.maxTileWidth > 0) && (this.maxTileWidth != TILE_SIZE_AUTO) && (this.maxTileHeight > 0) && (this.maxTileHeight != TILE_SIZE_AUTO) && (getWidth() > 0) && (getHeight() > 0)) {
        initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));
      }
      invalidate();
      requestLayout();
      System.currentTimeMillis();
      AppMethodBeat.o(157424);
      return;
    }
    finally {}
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(208550);
    Object localObject = new b();
    ((b)localObject).cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", this, ((b)localObject).aYj());
    Log.v(this.TAG, "alvinluo SubSamplingScaleImageView onTouchEvent: %d, lastMotionEvent: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), this.lastMotionEvent });
    if ((!this.allowInterceptTouch) && (this.lastMotionEvent != null) && (this.lastMotionEvent.getAction() == paramMotionEvent.getAction()) && (paramMotionEvent.getAction() == 0))
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(208550);
      return true;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 1) || (i == 6) || (i == 3)) {}
    for (this.lastMotionEvent = null;; this.lastMotionEvent = paramMotionEvent)
    {
      if (this.onTouchListener != null) {
        this.onTouchListener.onTouch(this, paramMotionEvent);
      }
      if ((this.anim == null) || (this.anim.interruptible)) {
        break;
      }
      requestDisallowInterceptTouchEvent(true);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(208550);
      return true;
    }
    this.anim = null;
    if (this.vTranslate == null)
    {
      if (this.singleDetector != null)
      {
        localObject = this.singleDetector;
        paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramMotionEvent.aYi(), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(208550);
      return true;
    }
    if (!this.isQuickScaling) {
      if (this.detector != null)
      {
        localObject = this.detector;
        com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (!com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sb(0)), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z")) {}
      }
      else
      {
        this.isZooming = false;
        this.isPanning = false;
        this.maxTouchCount = 0;
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(208550);
        return true;
      }
    }
    if (this.vTranslateStart == null) {
      this.vTranslateStart = new PointF(0.0F, 0.0F);
    }
    if (this.vTranslateBefore == null) {
      this.vTranslateBefore = new PointF(0.0F, 0.0F);
    }
    if (this.vCenterStart == null) {
      this.vCenterStart = new PointF(0.0F, 0.0F);
    }
    float f3 = this.scale;
    this.vTranslateBefore.set(this.vTranslate);
    i = paramMotionEvent.getPointerCount();
    boolean bool1;
    label671:
    boolean bool2;
    label754:
    float f1;
    label926:
    label1023:
    float f4;
    float f5;
    float f6;
    double d;
    float f2;
    label1377:
    float f7;
    label1422:
    float f8;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
    case 0: 
    case 5: 
    case 261: 
      for (;;)
      {
        setInternalTouchEventConsumed(bool1);
        a(f3, this.vTranslateBefore);
        bool2 = super.onTouchEvent(paramMotionEvent);
        Log.v(this.TAG, "alvinluo onTouchEvent super: %b, handled: %b, allowInterceptTouch: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(this.allowInterceptTouch) });
        if (!this.allowInterceptTouch) {
          break label3276;
        }
        if ((!bool1) && (!bool2)) {
          break;
        }
        bool1 = true;
        com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(208550);
        return bool1;
        this.x_down = paramMotionEvent.getRawX();
        this.y_down = paramMotionEvent.getRawY();
        this.anim = null;
        requestDisallowInterceptTouchEvent(true);
        this.maxTouchCount = Math.max(this.maxTouchCount, i);
        if (i >= 2) {
          if (this.zoomEnabled)
          {
            f1 = distance(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
            this.scaleStart = this.scale;
            this.vDistStart = f1;
            this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
            this.vCenterStart.set((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F, (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
            this.handler.removeMessages(1);
          }
        }
        for (;;)
        {
          if (!this.allowInterceptTouch) {
            break label1023;
          }
          bool1 = true;
          break;
          this.maxTouchCount = 0;
          break label926;
          if (!this.isQuickScaling)
          {
            this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
            this.vCenterStart.set(paramMotionEvent.getX(), paramMotionEvent.getY());
            Log.i(this.TAG, "pennqin, delay time 601 ms.");
            this.handler.sendEmptyMessageDelayed(1, 601L);
          }
        }
        bool1 = false;
      }
    case 2: 
      bool2 = false;
      bool1 = bool2;
      if (this.maxTouchCount > 0)
      {
        if (i < 2) {
          break label1758;
        }
        f4 = distance(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
        f5 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
        f6 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
        this.vResetCenter = new PointF(f5, f6);
        bool1 = bool2;
        if (this.zoomEnabled) {
          if ((distance(this.vCenterStart.x, f5, this.vCenterStart.y, f6) <= 5.0F) && (Math.abs(f4 - this.vDistStart) <= 5.0F))
          {
            bool1 = bool2;
            if (!this.isPanning) {}
          }
          else
          {
            this.isZooming = true;
            this.isPanning = true;
            d = this.scale;
            f2 = f4 / this.vDistStart * this.scaleStart;
            f1 = f2;
            if (f2 >= this.maxScale * 2.0F)
            {
              f1 = this.maxScale;
              f1 = (f2 - this.maxScale) * 0.1F + f1 * 2.0F;
            }
            this.scale = f1;
            Log.d(this.TAG, "alvinluo zoom preScale: %f, scale: %f, minScale: %f, maxScale: %f", new Object[] { Double.valueOf(d), Float.valueOf(this.scale), Float.valueOf(minScale()), Float.valueOf(this.maxScale) });
            if (this.scale > minScale()) {
              break label1422;
            }
            this.vDistStart = f4;
            this.scaleStart = minScale();
            this.vCenterStart.set(f5, f6);
            this.vTranslateStart.set(this.vTranslate);
          }
        }
      }
      for (;;)
      {
        fitToBounds(true);
        refreshRequiredTiles(this.eagerLoadingEnabled);
        bool1 = true;
        Log.d(this.TAG, "alvinluo Action_Move consumed: %b", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break;
        }
        this.handler.removeMessages(1);
        invalidate();
        bool1 = true;
        break label671;
        if (this.panEnabled)
        {
          f1 = this.vCenterStart.x;
          f2 = this.vTranslateStart.x;
          f7 = this.vCenterStart.y;
          f8 = this.vTranslateStart.y;
          float f9 = this.scale / this.scaleStart;
          float f10 = this.scale / this.scaleStart;
          this.vTranslate.x = (f5 - (f1 - f2) * f9);
          this.vTranslate.y = (f6 - (f7 - f8) * f10);
          if (((sHeight() * d < getHeight()) && (this.scale * sHeight() >= getHeight())) || ((d * sWidth() < getWidth()) && (this.scale * sWidth() >= getWidth())))
          {
            fitToBounds(true);
            this.vCenterStart.set(f5, f6);
            this.vTranslateStart.set(this.vTranslate);
            this.scaleStart = this.scale;
            this.vDistStart = f4;
          }
        }
        else if (this.sRequestedCenter != null)
        {
          this.vTranslate.x = (getWidth() / 2 - this.scale * this.sRequestedCenter.x);
          this.vTranslate.y = (getHeight() / 2 - this.scale * this.sRequestedCenter.y);
        }
        else
        {
          this.vTranslate.x = (getWidth() / 2 - this.scale * (sWidth() / 2));
          this.vTranslate.y = (getHeight() / 2 - this.scale * (sHeight() / 2));
        }
      }
      label1758:
      if (this.isQuickScaling)
      {
        f2 = Math.abs(this.quickScaleVStart.y - paramMotionEvent.getY()) * 2.0F + this.quickScaleThreshold;
        if (this.quickScaleLastDistance == -1.0F) {
          this.quickScaleLastDistance = f2;
        }
        if (paramMotionEvent.getY() > this.quickScaleVLastPoint.y)
        {
          i = 1;
          this.quickScaleVLastPoint.set(0.0F, paramMotionEvent.getY());
          f4 = 0.5F * Math.abs(1.0F - f2 / this.quickScaleLastDistance);
          if (f4 <= 0.03F)
          {
            f1 = f2;
            if (!this.quickScaleMoved) {
              break;
            }
          }
          else
          {
            this.quickScaleMoved = true;
            if (this.quickScaleLastDistance <= 0.0F) {
              break label3316;
            }
            if (i == 0) {
              break label2184;
            }
            f1 = 1.0F + f4;
          }
        }
      }
      label1824:
      break;
    }
    for (;;)
    {
      label1899:
      d = this.scale;
      this.scale = Math.max(minScale(), Math.min(this.maxScale, f1 * this.scale));
      if (this.panEnabled)
      {
        f1 = this.vCenterStart.x;
        f4 = this.vTranslateStart.x;
        f5 = this.vCenterStart.y;
        f6 = this.vTranslateStart.y;
        f7 = this.scale / this.scaleStart;
        f8 = this.scale / this.scaleStart;
        this.vTranslate.x = (this.vCenterStart.x - (f1 - f4) * f7);
        this.vTranslate.y = (this.vCenterStart.y - (f5 - f6) * f8);
        if (((sHeight() * d >= getHeight()) || (this.scale * sHeight() < getHeight())) && ((sWidth() * d >= getWidth()) || (this.scale * sWidth() < getWidth()))) {
          break label3309;
        }
        fitToBounds(true);
        this.vCenterStart.set(sourceToViewCoord(this.quickScaleSCenter));
        this.vTranslateStart.set(this.vTranslate);
        this.scaleStart = this.scale;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.quickScaleLastDistance = f1;
        fitToBounds(true);
        refreshRequiredTiles(this.eagerLoadingEnabled);
        bool1 = true;
        break label1377;
        i = 0;
        break label1824;
        label2184:
        f1 = 1.0F - f4;
        break label1899;
        if (this.sRequestedCenter != null)
        {
          this.vTranslate.x = (getWidth() / 2 - this.scale * this.sRequestedCenter.x);
          this.vTranslate.y = (getHeight() / 2 - this.scale * this.sRequestedCenter.y);
          f1 = f2;
        }
        else
        {
          this.vTranslate.x = (getWidth() / 2 - this.scale * (sWidth() / 2));
          this.vTranslate.y = (getHeight() / 2 - this.scale * (sHeight() / 2));
          f1 = f2;
          continue;
          bool1 = bool2;
          if (this.isZooming) {
            break label1377;
          }
          f1 = Math.abs(paramMotionEvent.getX() - this.vCenterStart.x);
          f2 = Math.abs(paramMotionEvent.getY() - this.vCenterStart.y);
          f4 = this.density * 5.0F;
          if ((f1 <= f4) && (f2 <= f4))
          {
            bool1 = bool2;
            if (!this.isPanning) {
              break label1377;
            }
          }
          this.vTranslate.x = (this.vTranslateStart.x + (paramMotionEvent.getX() - this.vCenterStart.x));
          this.vTranslate.y = (this.vTranslateStart.y + (paramMotionEvent.getY() - this.vCenterStart.y));
          f5 = this.vTranslate.x;
          f6 = this.vTranslate.y;
          fitToBounds(true);
          label2497:
          label2513:
          boolean bool3;
          label2536:
          boolean bool4;
          label2559:
          boolean bool5;
          if (f5 != this.vTranslate.x)
          {
            bool1 = true;
            if (f6 == this.vTranslate.y) {
              break label2798;
            }
            bool2 = true;
            if ((!bool1) || (f1 <= f2) || (this.isPanning)) {
              break label2804;
            }
            bool3 = true;
            if ((!bool2) || (f2 <= f1) || (this.isPanning)) {
              break label2810;
            }
            bool4 = true;
            if ((f6 != this.vTranslate.y) || (f2 <= 3.0F * f4)) {
              break label2816;
            }
            bool5 = true;
            label2587:
            Log.v(this.TAG, "alvinluo Action_Move edge atXEdge: %b, atYEdge: %b, edgeXSwipe: %b, edgeYSwipe: %b, yPan: %b, isPanning: %b,dx: %f, dy: %f, offset: %f", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(this.isPanning), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f4) });
            if ((bool3) || (bool4) || ((bool1) && (bool2) && (!bool5) && (!this.isPanning))) {
              break label2822;
            }
            this.isPanning = true;
            bool1 = true;
          }
          for (;;)
          {
            bool2 = bool1;
            if (!this.panEnabled)
            {
              this.vTranslate.x = this.vTranslateStart.x;
              this.vTranslate.y = this.vTranslateStart.y;
              requestDisallowInterceptTouchEvent(false);
              bool2 = bool1;
              if (!this.allowInterceptTouch) {
                bool2 = false;
              }
            }
            refreshRequiredTiles(this.eagerLoadingEnabled);
            bool1 = bool2;
            break label1377;
            bool1 = false;
            break label2497;
            label2798:
            bool2 = false;
            break label2513;
            label2804:
            bool3 = false;
            break label2536;
            label2810:
            bool4 = false;
            break label2559;
            label2816:
            bool5 = false;
            break label2587;
            label2822:
            if ((f1 > f4) || (f2 > f4))
            {
              this.maxTouchCount = 0;
              this.handler.removeMessages(1);
              requestDisallowInterceptTouchEvent(false);
              if (!this.allowInterceptTouch)
              {
                bool1 = false;
                continue;
                this.handler.removeMessages(1);
                if ((paramMotionEvent.getAction() == 3) && (this.ignoreCancelEvent)) {
                  this.ignoreCancelEvent = false;
                }
                if (this.isQuickScaling)
                {
                  this.isQuickScaling = false;
                  if (!this.quickScaleMoved) {
                    doubleTapZoom(this.quickScaleSCenter, this.vCenterStart);
                  }
                }
                if ((this.maxTouchCount > 0) && ((this.isZooming) || (this.isPanning)))
                {
                  if ((this.isZooming) && (i == 2))
                  {
                    this.isPanning = true;
                    this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                    if (paramMotionEvent.getActionIndex() != 1) {
                      break label3138;
                    }
                    this.vCenterStart.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
                    label3014:
                    if (this.scale > this.mScaleRate) {
                      break label3158;
                    }
                    Log.i(this.TAG, "alvinluo scale %f less than %f, and need to reset", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.mScaleRate) });
                    localObject = new PointF(this.mViewWidth / 2, this.mViewHeight / 2);
                    zoomScaleAndCenter((PointF)localObject, (PointF)localObject, this.mScaleRate);
                    this.isPanning = false;
                  }
                  for (;;)
                  {
                    if (i < 3) {
                      this.isZooming = false;
                    }
                    if (i < 2)
                    {
                      this.isPanning = false;
                      this.maxTouchCount = 0;
                    }
                    refreshRequiredTiles(true);
                    bool1 = true;
                    break;
                    label3138:
                    this.vCenterStart.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
                    break label3014;
                    label3158:
                    if (this.scale > getDoubleTapZoomScale() * 2.0F)
                    {
                      Log.i(this.TAG, "alvinluo current scale %f larger than maxScale: %f, and reset to scale: %f", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.maxScale), Float.valueOf(getDoubleTapZoomScale() * 2.0F) });
                      zoomScaleAndCenter(viewToSourceCoord(this.vResetCenter), this.vResetCenter, getDoubleTapZoomScale() * 2.0F);
                    }
                  }
                }
                if (i == 1)
                {
                  this.isZooming = false;
                  this.isPanning = false;
                  this.maxTouchCount = 0;
                }
                bool1 = false;
                break;
                bool1 = false;
                break label754;
                label3276:
                com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(208550);
                return bool1;
              }
            }
            bool1 = true;
          }
          label3309:
          f1 = f2;
        }
      }
      label3316:
      f1 = 1.0F;
    }
  }
  
  public void setAllowInterceptTouchEvent(boolean paramBoolean)
  {
    this.allowInterceptTouch = paramBoolean;
  }
  
  public final void setBitmapDecoderClass(Class<? extends ImageRegionDecoder> paramClass)
  {
    AppMethodBeat.i(157447);
    if (paramClass == null)
    {
      paramClass = new IllegalArgumentException("Decoder class cannot be set to null");
      AppMethodBeat.o(157447);
      throw paramClass;
    }
    this.bitmapDecoderFactory = new CompatDecoderFactory(paramClass);
    AppMethodBeat.o(157447);
  }
  
  public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> paramDecoderFactory)
  {
    AppMethodBeat.i(157448);
    if (paramDecoderFactory == null)
    {
      paramDecoderFactory = new IllegalArgumentException("Decoder factory cannot be set to null");
      AppMethodBeat.o(157448);
      throw paramDecoderFactory;
    }
    this.bitmapDecoderFactory = paramDecoderFactory;
    AppMethodBeat.o(157448);
  }
  
  public void setCanRefresh(boolean paramBoolean)
  {
    this.canRefresh = paramBoolean;
  }
  
  public final void setDebug(boolean paramBoolean)
  {
    this.debug = paramBoolean;
  }
  
  public final void setDoubleTapZoomDpi(int paramInt)
  {
    AppMethodBeat.i(157461);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    setDoubleTapZoomScale((localDisplayMetrics.ydpi + f) / 2.0F / paramInt);
    AppMethodBeat.o(157461);
  }
  
  public final void setDoubleTapZoomDuration(int paramInt)
  {
    AppMethodBeat.i(157463);
    this.doubleTapZoomDuration = Math.max(0, paramInt);
    AppMethodBeat.o(157463);
  }
  
  public final void setDoubleTapZoomScale(float paramFloat)
  {
    this.doubleTapZoomScale = paramFloat;
  }
  
  public final void setDoubleTapZoomStyle(int paramInt)
  {
    AppMethodBeat.i(157462);
    if (!VALID_ZOOM_STYLES.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid zoom style: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157462);
      throw localIllegalArgumentException;
    }
    this.doubleTapZoomStyle = paramInt;
    AppMethodBeat.o(157462);
  }
  
  public void setEagerLoadingEnabled(boolean paramBoolean)
  {
    this.eagerLoadingEnabled = paramBoolean;
  }
  
  public void setEdgeSwipeListener(EdgeSwipeListener paramEdgeSwipeListener)
  {
    this.mEdgeSwipeListener = paramEdgeSwipeListener;
  }
  
  public void setExecutor(Executor paramExecutor)
  {
    AppMethodBeat.i(157464);
    if (paramExecutor == null)
    {
      paramExecutor = new NullPointerException("Executor must not be null");
      AppMethodBeat.o(157464);
      throw paramExecutor;
    }
    this.executor = paramExecutor;
    AppMethodBeat.o(157464);
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    this.gestureDetectorListener = paramSimpleOnGestureListener;
  }
  
  public final void setImage(ImageSource paramImageSource)
  {
    AppMethodBeat.i(157402);
    a(paramImageSource, null);
    AppMethodBeat.o(157402);
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(208756);
    if (this.vTranslate == null) {
      this.vTranslate = new PointF();
    }
    paramMatrix.getValues(this.matrixValues);
    this.vTranslate.set(this.matrixValues[2], this.matrixValues[5]);
    float f = this.scale;
    this.scale = this.matrixValues[0];
    if (this.onStateChangedListener != null) {
      this.onStateChangedListener.bv(this.scale, f);
    }
    fitToBounds(false);
    invalidate();
    AppMethodBeat.o(208756);
  }
  
  public void setInternalTouchEventConsumed(boolean paramBoolean)
  {
    this.IsinternalTouchEventConsumed = paramBoolean;
  }
  
  public final void setMaxScale(float paramFloat)
  {
    this.maxScale = paramFloat;
  }
  
  public void setMaxTileSize(int paramInt)
  {
    this.maxTileWidth = paramInt;
    this.maxTileHeight = paramInt;
  }
  
  public final void setMaximumDpi(int paramInt)
  {
    AppMethodBeat.i(157452);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    setMinScale((localDisplayMetrics.ydpi + f) / 2.0F / paramInt);
    AppMethodBeat.o(157452);
  }
  
  public final void setMinScale(float paramFloat)
  {
    this.minScale = paramFloat;
  }
  
  public final void setMinimumDpi(int paramInt)
  {
    AppMethodBeat.i(157451);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    setMaxScale((localDisplayMetrics.ydpi + f) / 2.0F / paramInt);
    AppMethodBeat.o(157451);
  }
  
  public final void setMinimumScaleType(int paramInt)
  {
    AppMethodBeat.i(157450);
    if (!VALID_SCALE_TYPES.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid scale type: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157450);
      throw localIllegalArgumentException;
    }
    this.minimumScaleType = paramInt;
    if (this.readySent)
    {
      fitToBounds(true);
      invalidate();
    }
    AppMethodBeat.o(157450);
  }
  
  public void setMinimumTileDpi(int paramInt)
  {
    AppMethodBeat.i(157454);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    this.minimumTileDpi = ((int)Math.min((localDisplayMetrics.ydpi + f) / 2.0F, paramInt));
    if (this.readySent)
    {
      reset(false);
      invalidate();
    }
    AppMethodBeat.o(157454);
  }
  
  public void setOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.onAttachStateChangeListener = paramOnAttachStateChangeListener;
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.onDoubleTapListener = paramOnDoubleTapListener;
  }
  
  public void setOnImageEventListener(OnImageEventListener paramOnImageEventListener)
  {
    this.onImageEventListener = paramOnImageEventListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.onLongClickListener = paramOnLongClickListener;
  }
  
  public void setOnStateChangedListener(OnStateChangedListener paramOnStateChangedListener)
  {
    this.onStateChangedListener = paramOnStateChangedListener;
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(157396);
    if (!VALID_ORIENTATIONS.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid orientation: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157396);
      throw localIllegalArgumentException;
    }
    this.orientation = paramInt;
    reset(false);
    invalidate();
    requestLayout();
    AppMethodBeat.o(157396);
  }
  
  public final void setPanEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(157459);
    this.panEnabled = paramBoolean;
    if ((!paramBoolean) && (this.vTranslate != null))
    {
      this.vTranslate.x = (getWidth() / 2 - this.scale * (sWidth() / 2));
      this.vTranslate.y = (getHeight() / 2 - this.scale * (sHeight() / 2));
      if (this.readySent)
      {
        refreshRequiredTiles(true);
        invalidate();
      }
    }
    AppMethodBeat.o(157459);
  }
  
  public final void setPanLimit(int paramInt)
  {
    AppMethodBeat.i(157449);
    if (!VALID_PAN_LIMITS.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid pan limit: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157449);
      throw localIllegalArgumentException;
    }
    this.panLimit = paramInt;
    if (this.readySent)
    {
      fitToBounds(true);
      invalidate();
    }
    AppMethodBeat.o(157449);
  }
  
  public void setPreviewDone(boolean paramBoolean)
  {
    AppMethodBeat.i(157395);
    this.mPreviewDone = paramBoolean;
    invalidate();
    AppMethodBeat.o(157395);
  }
  
  public final void setQuickScaleEnabled(boolean paramBoolean)
  {
    this.quickScaleEnabled = paramBoolean;
  }
  
  public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> paramClass)
  {
    AppMethodBeat.i(157445);
    if (paramClass == null)
    {
      paramClass = new IllegalArgumentException("Decoder class cannot be set to null");
      AppMethodBeat.o(157445);
      throw paramClass;
    }
    this.regionDecoderFactory = new CompatDecoderFactory(paramClass);
    AppMethodBeat.o(157445);
  }
  
  public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> paramDecoderFactory)
  {
    AppMethodBeat.i(157446);
    if (paramDecoderFactory == null)
    {
      paramDecoderFactory = new IllegalArgumentException("Decoder factory cannot be set to null");
      AppMethodBeat.o(157446);
      throw paramDecoderFactory;
    }
    this.regionDecoderFactory = paramDecoderFactory;
    AppMethodBeat.o(157446);
  }
  
  public final void setScaleAndCenter(float paramFloat, PointF paramPointF)
  {
    AppMethodBeat.i(157456);
    this.anim = null;
    this.mNeedPendingScale = true;
    this.pendingScale = Float.valueOf(paramFloat);
    this.sPendingCenter = paramPointF;
    this.sRequestedCenter = paramPointF;
    invalidate();
    AppMethodBeat.o(157456);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(157397);
    this.mScaleRate = paramFloat;
    this.maxScale = 2.0F;
    this.minScale = 1.0F;
    initMaxScale();
    initMinScale();
    AppMethodBeat.o(157397);
  }
  
  public final void setTileBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(157460);
    if (Color.alpha(paramInt) == 0) {
      this.tileBgPaint = null;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(157460);
      return;
      this.tileBgPaint = new Paint();
      this.tileBgPaint.setStyle(Paint.Style.FILL);
      this.tileBgPaint.setColor(paramInt);
    }
  }
  
  public final void setZoomEnabled(boolean paramBoolean)
  {
    this.zoomEnabled = paramBoolean;
  }
  
  public void setsRegion(Rect paramRect)
  {
    this.sRegion = paramRect;
  }
  
  public final PointF sourceToViewCoord(PointF paramPointF)
  {
    AppMethodBeat.i(157438);
    paramPointF = sourceToViewCoord(paramPointF.x, paramPointF.y, new PointF());
    AppMethodBeat.o(157438);
    return paramPointF;
  }
  
  public final float sourceToViewX(float paramFloat)
  {
    if (this.vTranslate == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.vTranslate.x;
  }
  
  public final float sourceToViewY(float paramFloat)
  {
    if (this.vTranslate == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.vTranslate.y;
  }
  
  public final PointF viewToSourceCoord(PointF paramPointF)
  {
    AppMethodBeat.i(157436);
    paramPointF = viewToSourceCoord(paramPointF.x, paramPointF.y, new PointF());
    AppMethodBeat.o(157436);
    return paramPointF;
  }
  
  static final class Anim
  {
    long duration;
    int easing;
    boolean interruptible;
    SubsamplingScaleImageView.OnAnimationEventListener listener;
    int origin;
    PointF sCenterEnd;
    PointF sCenterEndRequested;
    PointF sCenterStart;
    float scaleEnd;
    float scaleStart;
    long time;
    PointF vFocusEnd;
    PointF vFocusStart;
    
    private Anim()
    {
      AppMethodBeat.i(157385);
      this.duration = 200L;
      this.interruptible = true;
      this.easing = 2;
      this.origin = 1;
      this.time = System.currentTimeMillis();
      AppMethodBeat.o(157385);
    }
  }
  
  public final class AnimationBuilder
  {
    public long duration;
    int easing;
    public boolean interruptible;
    private SubsamplingScaleImageView.OnAnimationEventListener listener;
    public int origin;
    boolean panLimited;
    private final PointF targetSCenter;
    private final float targetScale;
    private final PointF vFocus;
    
    private AnimationBuilder(float paramFloat, PointF paramPointF)
    {
      this.duration = 500L;
      this.easing = 2;
      this.origin = 1;
      this.interruptible = true;
      this.panLimited = true;
      this.targetScale = paramFloat;
      this.targetSCenter = paramPointF;
      this.vFocus = null;
    }
    
    private AnimationBuilder(float paramFloat, PointF paramPointF1, PointF paramPointF2)
    {
      this.duration = 500L;
      this.easing = 2;
      this.origin = 1;
      this.interruptible = true;
      this.panLimited = true;
      this.targetScale = paramFloat;
      this.targetSCenter = paramPointF1;
      this.vFocus = paramPointF2;
    }
    
    private AnimationBuilder(PointF paramPointF)
    {
      AppMethodBeat.i(157386);
      this.duration = 500L;
      this.easing = 2;
      this.origin = 1;
      this.interruptible = true;
      this.panLimited = true;
      this.targetScale = SubsamplingScaleImageView.this.scale;
      this.targetSCenter = paramPointF;
      this.vFocus = null;
      AppMethodBeat.o(157386);
    }
    
    public final void start()
    {
      AppMethodBeat.i(157387);
      if ((SubsamplingScaleImageView.this.anim != null) && (SubsamplingScaleImageView.this.anim.listener != null)) {}
      try
      {
        int i = SubsamplingScaleImageView.this.getPaddingLeft();
        int j = (SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight() - SubsamplingScaleImageView.this.getPaddingLeft()) / 2;
        int k = SubsamplingScaleImageView.this.getPaddingTop();
        int m = (SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom() - SubsamplingScaleImageView.this.getPaddingTop()) / 2;
        float f3 = SubsamplingScaleImageView.access$5300(SubsamplingScaleImageView.this, this.targetScale);
        if (this.panLimited)
        {
          Object localObject = SubsamplingScaleImageView.access$5400(SubsamplingScaleImageView.this, this.targetSCenter.x, this.targetSCenter.y, f3, new PointF());
          SubsamplingScaleImageView.access$5202(SubsamplingScaleImageView.this, new SubsamplingScaleImageView.Anim((byte)0));
          SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
          SubsamplingScaleImageView.this.anim.scaleEnd = f3;
          SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
          SubsamplingScaleImageView.this.anim.sCenterEndRequested = ((PointF)localObject);
          SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
          SubsamplingScaleImageView.this.anim.sCenterEnd = ((PointF)localObject);
          SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord((PointF)localObject);
          SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(j + i, m + k);
          SubsamplingScaleImageView.this.anim.duration = this.duration;
          SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
          SubsamplingScaleImageView.this.anim.easing = this.easing;
          SubsamplingScaleImageView.this.anim.origin = this.origin;
          SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
          SubsamplingScaleImageView.this.anim.listener = this.listener;
          if (this.vFocus != null)
          {
            float f1 = this.vFocus.x - SubsamplingScaleImageView.this.anim.sCenterStart.x * f3;
            float f2 = this.vFocus.y - SubsamplingScaleImageView.this.anim.sCenterStart.y * f3;
            localObject = new SubsamplingScaleImageView.ScaleAndTranslate(f3, new PointF(f1, f2), (byte)0);
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, (SubsamplingScaleImageView.ScaleAndTranslate)localObject);
            SubsamplingScaleImageView.Anim localAnim = SubsamplingScaleImageView.this.anim;
            f3 = this.vFocus.x;
            float f4 = ((SubsamplingScaleImageView.ScaleAndTranslate)localObject).vTranslate.x;
            float f5 = this.vFocus.y;
            localAnim.vFocusEnd = new PointF(f4 - f1 + f3, ((SubsamplingScaleImageView.ScaleAndTranslate)localObject).vTranslate.y - f2 + f5);
          }
          SubsamplingScaleImageView.this.invalidate();
          AppMethodBeat.o(157387);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w(SubsamplingScaleImageView.this.TAG, "Error thrown by animation listener", new Object[] { localException });
          continue;
          PointF localPointF = this.targetSCenter;
        }
      }
    }
  }
  
  public static abstract interface EdgeSwipeListener {}
  
  public static abstract interface OnAnimationEventListener {}
  
  public static abstract interface OnImageEventListener
  {
    public abstract void onImageLoadError(ImageDecodeResult paramImageDecodeResult);
    
    public abstract void onImageLoaded(Bitmap paramBitmap);
    
    public abstract void onPreviewLoadError(ImageDecodeResult paramImageDecodeResult);
    
    public abstract void onPreviewLoaded();
    
    public abstract void onPreviewReleased();
    
    public abstract void onTileLoadError(ImageDecodeResult paramImageDecodeResult);
  }
  
  public static abstract interface OnStateChangedListener
  {
    public abstract void bv(float paramFloat1, float paramFloat2);
  }
  
  static final class ScaleAndTranslate
  {
    float scale;
    PointF vTranslate;
    
    private ScaleAndTranslate(float paramFloat, PointF paramPointF)
    {
      this.scale = paramFloat;
      this.vTranslate = paramPointF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView
 * JD-Core Version:    0.7.0.1
 */