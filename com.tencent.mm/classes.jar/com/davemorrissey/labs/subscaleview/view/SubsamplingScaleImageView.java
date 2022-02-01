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
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import com.davemorrissey.labs.subscaleview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
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
  public static int aXJ;
  private static final List<Integer> aXk;
  private static final List<Integer> aXl;
  private static final List<Integer> aXm;
  private static final List<Integer> aXn;
  private static final List<Integer> aXo;
  private static Bitmap.Config aYN;
  private static com.davemorrissey.labs.subscaleview.c.a aYO;
  private static com.davemorrissey.labs.subscaleview.c.d aYP;
  private static com.davemorrissey.labs.subscaleview.c.c aYQ;
  private final String TAG;
  private final ReadWriteLock aWM;
  private com.davemorrissey.labs.subscaleview.a.d aWT;
  private boolean aXA;
  private boolean aXB;
  private Map<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> aXC;
  private boolean aXD;
  private float aXE;
  private float aXF;
  private int aXG;
  private int aXH;
  private int aXI;
  private int aXK;
  private int aXL;
  private boolean aXM;
  private boolean aXN;
  private boolean aXO;
  private boolean aXP;
  private float aXQ;
  private int aXR;
  private int aXS;
  private int aXT;
  private float aXU;
  private PointF aXV;
  private PointF aXW;
  private PointF aXX;
  private Float aXY;
  private PointF aXZ;
  public int aXg;
  public int aXh;
  private Rect aXi;
  private boolean aXp;
  private boolean aXq;
  private boolean aXr;
  private int aXs;
  private int aXt;
  private boolean aXu;
  private int aXv;
  private boolean aXw;
  private long aXx;
  private long aXy;
  private Bitmap aXz;
  private boolean aYA;
  private e aYB;
  private f aYC;
  private View.OnLongClickListener aYD;
  private Paint aYE;
  private Paint aYF;
  private Paint aYG;
  private Paint aYH;
  private g aYI;
  private RectF aYJ;
  private float[] aYK;
  private float[] aYL;
  private Matrix aYM;
  private LinkedList<com.davemorrissey.labs.subscaleview.c.b> aYR;
  private int aYS;
  private int aYT;
  private float aYU;
  private float aYV;
  public float aYW;
  private float aYX;
  private float aYY;
  private float aYZ;
  private PointF aYa;
  private boolean aYb;
  private a aYc;
  private a aYd;
  private int aYe;
  private int aYf;
  private Rect aYg;
  private boolean aYh;
  private boolean aYi;
  private boolean aYj;
  private int aYk;
  private GestureDetector aYl;
  private GestureDetector.SimpleOnGestureListener aYm;
  private GestureDetector aYn;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aYo;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aYp;
  private PointF aYq;
  private float aYr;
  private final float aYs;
  private float aYt;
  private boolean aYu;
  private PointF aYv;
  private PointF aYw;
  private PointF aYx;
  private a aYy;
  private boolean aYz;
  private float aZa;
  private boolean aZb;
  private boolean aZc;
  private PointF aZd;
  private View.OnAttachStateChangeListener aZe;
  private com.davemorrissey.labs.subscaleview.d.a aZf;
  private c aZg;
  private boolean aZh;
  private boolean aZi;
  private boolean aZj;
  private float aZk;
  private float aZl;
  private Bitmap bitmap;
  private boolean cancelled;
  private float density;
  public Executor executor;
  private Matrix gR;
  private Handler handler;
  private int orientation;
  private float scale;
  private Uri uri;
  
  static
  {
    AppMethodBeat.i(157473);
    aXk = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1) });
    aXl = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    aXm = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
    aXn = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    aXo = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4) });
    aXJ = 2147483647;
    aYN = Bitmap.Config.ARGB_8888;
    aYO = new com.davemorrissey.labs.subscaleview.b.a();
    aYP = new com.davemorrissey.labs.subscaleview.b.c();
    aYQ = new com.davemorrissey.labs.subscaleview.b.b();
    AppMethodBeat.o(157473);
  }
  
  public SubsamplingScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(157394);
    this.TAG = (SubsamplingScaleImageView.class.getSimpleName() + hashCode());
    this.aXw = true;
    this.aXx = -1L;
    this.aXy = -1L;
    this.aXA = false;
    this.aXB = false;
    this.aXD = false;
    this.orientation = -1;
    this.aXE = 2.0F;
    this.aXF = rW();
    this.aXG = -1;
    this.aXH = 1;
    this.aXI = 3;
    this.aXK = aXJ;
    this.aXL = aXJ;
    this.aXM = true;
    this.aXN = true;
    this.aXO = true;
    this.aXP = true;
    this.aXQ = 2.0F;
    this.aXR = 1;
    this.aXS = 200;
    this.aXT = 200;
    this.aYf = 0;
    this.aWM = new ReentrantReadWriteLock(true);
    this.aYo = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.aYp = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.aYK = new float[8];
    this.aYL = new float[8];
    this.aYR = new LinkedList();
    this.cancelled = false;
    this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
    this.aYZ = 1.0F;
    this.aZa = 20.0F;
    this.aZb = true;
    this.aZc = false;
    this.aZf = new com.davemorrissey.labs.subscaleview.d.a();
    this.aZg = new c() {};
    this.aZh = false;
    this.aZi = false;
    this.aZj = false;
    this.density = getResources().getDisplayMetrics().density;
    setDoubleTapZoomScale(2.0F);
    setMinimumTileDpi(320);
    setGestureDetector(paramContext);
    this.aYM = new Matrix();
    this.handler = new Handler(new Handler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(157375);
        if ((paramAnonymousMessage.what == 1) && (SubsamplingScaleImageView.b(SubsamplingScaleImageView.this) != null))
        {
          SubsamplingScaleImageView.c(SubsamplingScaleImageView.this);
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.b(SubsamplingScaleImageView.this));
          SubsamplingScaleImageView.this.performLongClick();
          SubsamplingScaleImageView.d(SubsamplingScaleImageView.this);
        }
        AppMethodBeat.o(157375);
        return true;
      }
    });
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.SubsamplingScaleImageView);
      if (paramAttributeSet.hasValue(0))
      {
        String str = paramAttributeSet.getString(0);
        if ((str != null) && (str.length() > 0))
        {
          if (str == null)
          {
            paramContext = new NullPointerException("Asset name must not be null");
            AppMethodBeat.o(157394);
            throw paramContext;
          }
          setImage(a.aP("assets:///".concat(String.valueOf(str))).rJ());
        }
      }
      if (paramAttributeSet.hasValue(3))
      {
        int i = paramAttributeSet.getResourceId(3, 0);
        if (i > 0) {
          setImage(new a(i).rJ());
        }
      }
      if (paramAttributeSet.hasValue(1)) {
        setPanEnabled(paramAttributeSet.getBoolean(1, true));
      }
      if (paramAttributeSet.hasValue(5)) {
        setZoomEnabled(paramAttributeSet.getBoolean(5, true));
      }
      if (paramAttributeSet.hasValue(2)) {
        setQuickScaleEnabled(paramAttributeSet.getBoolean(2, true));
      }
      if (paramAttributeSet.hasValue(4)) {
        setTileBackgroundColor(paramAttributeSet.getColor(4, Color.argb(0, 0, 0, 0)));
      }
      paramAttributeSet.recycle();
    }
    this.aYs = TypedValue.applyDimension(1, 20.0F, paramContext.getResources().getDisplayMetrics());
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aYZ = f;
    }
    AppMethodBeat.o(157394);
  }
  
  private int V(float paramFloat)
  {
    AppMethodBeat.i(157420);
    float f = paramFloat;
    if (this.aXG > 0)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      f = localDisplayMetrics.xdpi;
      f = (localDisplayMetrics.ydpi + f) / 2.0F;
      f = paramFloat * (this.aXG / f);
    }
    int j = (int)(rU() * f);
    int i = (int)(rV() * f);
    if ((j == 0) || (i == 0))
    {
      AppMethodBeat.o(157420);
      return 32;
    }
    if ((rV() > i) || (rU() > j))
    {
      i = Math.round(rV() / i);
      j = Math.round(rU() / j);
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
  
  private float W(float paramFloat)
  {
    if (this.aXV == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.aXV.x) / this.scale;
  }
  
  private float X(float paramFloat)
  {
    if (this.aXV == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.aXV.y) / this.scale;
  }
  
  private static float a(int paramInt, long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(157443);
    switch (paramInt)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Unexpected easing type: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157443);
      throw localIllegalStateException;
    case 2: 
      paramFloat1 = b(paramLong1, paramFloat1, paramFloat2, paramLong2);
      AppMethodBeat.o(157443);
      return paramFloat1;
    }
    paramFloat1 = a(paramLong1, paramFloat1, paramFloat2, paramLong2);
    AppMethodBeat.o(157443);
    return paramFloat1;
  }
  
  private static float a(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    float f = (float)paramLong1 / (float)paramLong2;
    return (f - 2.0F) * (-paramFloat2 * f) + paramFloat1;
  }
  
  private PointF a(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    AppMethodBeat.i(157437);
    if (this.aXV == null)
    {
      AppMethodBeat.o(157437);
      return null;
    }
    paramPointF.set(W(paramFloat1), X(paramFloat2));
    AppMethodBeat.o(157437);
    return paramPointF;
  }
  
  private void a(Point paramPoint)
  {
    try
    {
      AppMethodBeat.i(157417);
      h("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
      this.aYI = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      a(true, this.aYI);
      this.aXv = V(this.aYI.scale);
      b(paramPoint);
      paramPoint = ((List)this.aXC.get(Integer.valueOf(this.aXv))).iterator();
      while (paramPoint.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)paramPoint.next();
        ae.i(this.TAG, "alvinluo tile fullSampleSize: %d", new Object[] { Integer.valueOf(this.aXv) });
        a(locale);
      }
      aK(true);
    }
    finally {}
    AppMethodBeat.o(157417);
  }
  
  private void a(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(157411);
    float f2;
    int i;
    label101:
    float f1;
    if (!this.aXN)
    {
      if (this.aYa != null)
      {
        paramPointF1.x = this.aYa.x;
        paramPointF1.y = this.aYa.y;
      }
    }
    else
    {
      f2 = getDoubleTapZoomScale();
      ae.i(this.TAG, "alvinluo doubleTapZoom %f", new Object[] { Float.valueOf(f2) });
      if ((this.scale > f2 * 0.9D) && (this.scale != this.aYW)) {
        break label159;
      }
      i = 1;
      if (i == 0) {
        break label165;
      }
      f1 = f2;
      label109:
      if (this.aXR != 3) {
        break label173;
      }
      a(f1, paramPointF1);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(157411);
      return;
      paramPointF1.x = (rU() / 2);
      paramPointF1.y = (rV() / 2);
      break;
      label159:
      i = 0;
      break label101;
      label165:
      f1 = this.aYW;
      break label109;
      label173:
      if ((this.aXR == 2) || (i == 0) || (!this.aXN))
      {
        paramPointF1 = new b(f1, paramPointF1, (byte)0);
        paramPointF1.aZy = false;
        paramPointF1.duration = this.aXS;
        paramPointF1.aZA = 4;
        paramPointF1.start();
      }
      else if (this.aXR == 1)
      {
        paramPointF1 = new b(f2, paramPointF1, paramPointF2, (byte)0);
        paramPointF1.aZy = false;
        paramPointF1.duration = this.aXS;
        paramPointF1.aZA = 4;
        paramPointF1.start();
      }
    }
  }
  
  private void a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    AppMethodBeat.i(157412);
    paramPointF1 = new b(paramFloat, paramPointF1, paramPointF2, (byte)0);
    paramPointF1.aZy = false;
    paramPointF1.duration = this.aXT;
    paramPointF1.aZA = 2;
    paramPointF1.start();
    AppMethodBeat.o(157412);
  }
  
  private void a(com.davemorrissey.labs.subscaleview.c.e parame)
  {
    AppMethodBeat.i(157393);
    if (this.cancelled)
    {
      ae.i(this.TAG, "alvinluo newLoadTask, has cancelled and ignore");
      AppMethodBeat.o(157393);
      return;
    }
    parame = aYP.a(this, this.aWT, parame);
    parame.rG();
    this.aYR.add(parame);
    AppMethodBeat.o(157393);
  }
  
  private void a(boolean paramBoolean, g paramg)
  {
    float f2 = 0.5F;
    AppMethodBeat.i(157421);
    boolean bool = paramBoolean;
    if (this.aXH == 2)
    {
      bool = paramBoolean;
      if (this.aYz) {
        bool = false;
      }
    }
    PointF localPointF = paramg.aXV;
    float f4 = aa(paramg.scale);
    float f3 = f4 * rU();
    float f5 = f4 * rV();
    float f1;
    if ((this.aXH == 3) && (this.aYz))
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
      if ((this.aXH != 3) || (!this.aYz)) {
        break label369;
      }
      f2 = Math.max(0, getWidth() / 2);
      f1 = Math.max(0, getHeight() / 2);
    }
    for (;;)
    {
      localPointF.x = Math.min(localPointF.x, f2);
      localPointF.y = Math.min(localPointF.y, f1);
      paramg.scale = f4;
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
  
  private static void a(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
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
  
  private void aK(boolean paramBoolean)
  {
    AppMethodBeat.i(157418);
    if ((this.aWT == null) || (this.aXC == null))
    {
      AppMethodBeat.o(157418);
      return;
    }
    int j = Math.min(this.aXv, V(this.scale));
    Iterator localIterator1 = this.aXC.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)localIterator2.next();
        if ((locale.sampleSize < j) || ((locale.sampleSize > j) && (locale.sampleSize != this.aXv)))
        {
          locale.visible = false;
          if (locale.bitmap != null)
          {
            locale.bitmap.recycle();
            locale.bitmap = null;
          }
        }
        if (locale.sampleSize == j)
        {
          float f1 = W(0.0F);
          float f2 = W(getWidth());
          float f3 = X(0.0F);
          float f4 = X(getHeight());
          if ((f1 <= locale.aWW.right) && (locale.aWW.left <= f2) && (f3 <= locale.aWW.bottom) && (locale.aWW.top <= f4)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label328;
            }
            locale.visible = true;
            if ((locale.aWX) || (locale.bitmap != null) || (!paramBoolean)) {
              break;
            }
            a(locale);
            break;
          }
          label328:
          if (locale.sampleSize != this.aXv)
          {
            locale.visible = false;
            if (locale.bitmap != null)
            {
              locale.bitmap.recycle();
              locale.bitmap = null;
            }
          }
        }
        else if (locale.sampleSize == this.aXv)
        {
          locale.visible = true;
        }
      }
    }
    AppMethodBeat.o(157418);
  }
  
  private void aL(boolean paramBoolean)
  {
    AppMethodBeat.i(157422);
    int i;
    if (this.aXV == null)
    {
      i = 1;
      this.aXV = new PointF(0.0F, 0.0F);
    }
    for (;;)
    {
      if (this.aYI == null) {
        this.aYI = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      }
      this.aYI.scale = this.scale;
      this.aYI.aXV.set(this.aXV);
      a(paramBoolean, this.aYI);
      this.scale = this.aYI.scale;
      this.aXV.set(this.aYI.aXV);
      if ((i != 0) && (this.aXI != 4)) {
        this.aXV.set(j(rU() / 2, rV() / 2, this.scale));
      }
      AppMethodBeat.o(157422);
      return;
      i = 0;
    }
  }
  
  private float aa(float paramFloat)
  {
    AppMethodBeat.i(157442);
    paramFloat = Math.max(rW(), paramFloat);
    AppMethodBeat.o(157442);
    return paramFloat;
  }
  
  private static float b(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    float f = (float)paramLong1 / ((float)paramLong2 / 2.0F);
    if (f < 1.0F) {
      return f * (paramFloat2 / 2.0F * f) + paramFloat1;
    }
    f -= 1.0F;
    return (f * (f - 2.0F) - 1.0F) * (-paramFloat2 / 2.0F) + paramFloat1;
  }
  
  private PointF b(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    AppMethodBeat.i(157439);
    if (this.aXV == null)
    {
      AppMethodBeat.o(157439);
      return null;
    }
    paramPointF.set(Y(paramFloat1), Z(paramFloat2));
    AppMethodBeat.o(157439);
    return paramPointF;
  }
  
  private void b(Point paramPoint)
  {
    AppMethodBeat.i(157423);
    h("initialiseTileMap maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
    this.aXC = new LinkedHashMap();
    int i = this.aXv;
    int j = 1;
    int m = 1;
    int k = rU() / j;
    int i2 = rV() / m;
    int n = k / i;
    int i1 = i2 / i;
    while ((n + j + 1 > paramPoint.x) || ((n > getWidth() * 1.25D) && (i < this.aXv)))
    {
      j += 1;
      k = rU() / j;
      n = k / i;
    }
    for (;;)
    {
      if ((i1 + m + 1 > paramPoint.y) || ((i1 > getHeight() * 1.25D) && (i < this.aXv)))
      {
        m += 1;
        n = rV() / m;
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
            com.davemorrissey.labs.subscaleview.c.e locale = new com.davemorrissey.labs.subscaleview.c.e();
            locale.sampleSize = i;
            boolean bool;
            label265:
            int i3;
            if (i == this.aXv)
            {
              bool = true;
              locale.visible = bool;
              if (i1 != j - 1) {
                break label385;
              }
              i3 = rU();
              label286:
              if (i2 != m - 1) {
                break label397;
              }
            }
            label385:
            label397:
            for (int i4 = rV();; i4 = (i2 + 1) * n)
            {
              locale.aWW = new Rect(i1 * k, i2 * n, i3, i4);
              locale.aWY = new Rect(0, 0, 0, 0);
              locale.aWZ = new Rect(locale.aWW);
              localArrayList.add(locale);
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
        this.aXC.put(Integer.valueOf(i), localArrayList);
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
  
  private void c(PointF paramPointF)
  {
    AppMethodBeat.i(157465);
    if ((this.aYC != null) && (!this.aXV.equals(paramPointF))) {
      getCenter();
    }
    AppMethodBeat.o(157465);
  }
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(157435);
    paramFloat1 -= paramFloat2;
    paramFloat2 = paramFloat3 - paramFloat4;
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    AppMethodBeat.o(157435);
    return paramFloat1;
  }
  
  private float getDoubleTapZoomScale()
  {
    float f1 = this.aYW;
    if (this.aYU * 0.7F > f1) {
      f1 = this.aYU;
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 < 1.0D) {
        f2 = 1.0F;
      }
      f1 = f2;
      if (f2 > this.aXE) {
        f1 = this.aXE;
      }
      return f1;
      if (this.aYV * 0.7F > f1) {
        f1 = this.aYV;
      } else {
        f1 = this.aYW * this.aXQ;
      }
    }
  }
  
  public static Bitmap.Config getPreferredBitmapConfig()
  {
    return aYN;
  }
  
  private PointF j(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(157440);
    int i = getPaddingLeft();
    int j = (getWidth() - getPaddingRight() - getPaddingLeft()) / 2;
    int k = getPaddingTop();
    int m = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2;
    if (this.aYI == null) {
      this.aYI = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
    }
    this.aYI.scale = paramFloat3;
    this.aYI.aXV.set(i + j - paramFloat1 * paramFloat3, k + m - paramFloat2 * paramFloat3);
    a(true, this.aYI);
    PointF localPointF = this.aYI.aXV;
    AppMethodBeat.o(157440);
    return localPointF;
  }
  
  private int px(int paramInt)
  {
    return (int)(this.density * paramInt);
  }
  
  private void rK()
  {
    AppMethodBeat.i(157398);
    ae.i(this.TAG, "alvinluo initScaleRate: %f", new Object[] { Float.valueOf(this.aYW) });
    rM();
    rN();
    AppMethodBeat.o(157398);
  }
  
  private void rL()
  {
    AppMethodBeat.i(213544);
    if (this.bitmap == null)
    {
      AppMethodBeat.o(213544);
      return;
    }
    if (!this.aXp)
    {
      AppMethodBeat.o(213544);
      return;
    }
    int i = rU();
    int j = rV();
    boolean bool;
    if (i > j * 2.2F)
    {
      bool = true;
      this.aXB = bool;
      if (j <= i * 2.2F) {
        break label272;
      }
      bool = true;
      label77:
      this.aXA = bool;
      if ((!this.aXB) || (i <= this.aYS)) {
        break label277;
      }
      bool = true;
      label99:
      this.aXB = bool;
      if ((!this.aXA) || (j <= this.aYT)) {
        break label282;
      }
      bool = true;
      label121:
      this.aXA = bool;
      rK();
      if (!this.aXA) {
        break label287;
      }
      this.aYX = (this.aYS * 1.0F / rS());
      this.aYY = (this.aYT * 1.0F / rT());
    }
    for (;;)
    {
      ae.i(this.TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f, previewHeight: %d, previewWidth: %d, verticalLong: %b, horizontalLong: %b, %s", new Object[] { Float.valueOf(this.aYX), Float.valueOf(this.aYY), Integer.valueOf(rT()), Integer.valueOf(rS()), Boolean.valueOf(this.aXA), Boolean.valueOf(this.aXB), this.aYc.getUri().toString() });
      AppMethodBeat.o(213544);
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
      if (this.aXB)
      {
        this.aYX = (this.aYS * 1.0F / rS());
        this.aYY = (this.aYW * rV() / rT());
      }
      else
      {
        this.aYX = (this.aYW * rU() / rS());
        this.aYY = (this.aYW * rV() / rT());
      }
    }
  }
  
  private void rM()
  {
    AppMethodBeat.i(157399);
    this.aXE = (getDoubleTapZoomScale() * 2.0F * this.aYZ);
    AppMethodBeat.o(157399);
  }
  
  private void rN()
  {
    AppMethodBeat.i(157400);
    this.aXF = Math.min(rW(), this.aYW * 0.75F);
    AppMethodBeat.o(157400);
  }
  
  private boolean rO()
  {
    AppMethodBeat.i(157414);
    if ((this.bitmap != null) && (!this.aXp))
    {
      AppMethodBeat.o(157414);
      return true;
    }
    if (this.aXC != null)
    {
      Iterator localIterator = this.aXC.entrySet().iterator();
      boolean bool2;
      for (boolean bool1 = true; localIterator.hasNext(); bool1 = bool2)
      {
        Object localObject = (Map.Entry)localIterator.next();
        bool2 = bool1;
        if (((Integer)((Map.Entry)localObject).getKey()).intValue() == this.aXv)
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject).next();
            if ((locale.aWX) || (locale.bitmap == null)) {
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
  
  private boolean rP()
  {
    AppMethodBeat.i(157415);
    if ((getWidth() > 0) && (getHeight() > 0) && (this.aXg > 0) && (this.aXh > 0) && ((this.bitmap != null) || (rO()))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.aYz) && (bool))
      {
        rR();
        this.aYz = true;
      }
      AppMethodBeat.o(157415);
      return bool;
    }
  }
  
  private boolean rQ()
  {
    AppMethodBeat.i(157416);
    boolean bool = rO();
    if ((!this.aYA) && (bool))
    {
      rR();
      this.aYA = true;
      ae.i(this.TAG, "alvinluo onImageLoaded");
      rK();
      a(this.aYW, new PointF(0.0F, 0.0F));
      if (this.aXx != -1L)
      {
        this.aXy = System.currentTimeMillis();
        dE((int)(this.aXy - this.aXx));
      }
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(157384);
          if ((SubsamplingScaleImageView.u(SubsamplingScaleImageView.this) != null) && (!SubsamplingScaleImageView.u(SubsamplingScaleImageView.this).isRecycled()))
          {
            ae.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo rotateAndScale fullImageBitmap");
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(SubsamplingScaleImageView.u(SubsamplingScaleImageView.this), SubsamplingScaleImageView.t(SubsamplingScaleImageView.this)));
          }
          SubsamplingScaleImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157383);
              if (SubsamplingScaleImageView.v(SubsamplingScaleImageView.this) != null) {
                SubsamplingScaleImageView.v(SubsamplingScaleImageView.this).n(SubsamplingScaleImageView.u(SubsamplingScaleImageView.this));
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
  
  private void rR()
  {
    AppMethodBeat.i(157419);
    if ((getWidth() == 0) || (getHeight() == 0) || (this.aXg <= 0) || (this.aXh <= 0))
    {
      AppMethodBeat.o(157419);
      return;
    }
    if ((this.aXZ != null) && (this.aXY != null))
    {
      this.scale = this.aXY.floatValue();
      if (this.aXV == null) {
        this.aXV = new PointF();
      }
      this.aXV.x = (getWidth() / 2 - this.scale * this.aXZ.x);
      this.aXV.y = (getHeight() / 2 - this.scale * this.aXZ.y);
      this.aXZ = null;
      this.aXY = null;
      this.aYb = false;
      aL(true);
      aK(true);
    }
    aL(false);
    AppMethodBeat.o(157419);
  }
  
  private int rS()
  {
    AppMethodBeat.i(157431);
    if ((this.bitmap == null) || (!this.aXp))
    {
      AppMethodBeat.o(157431);
      return 0;
    }
    int i = this.aYf;
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
  
  private int rT()
  {
    AppMethodBeat.i(157432);
    if ((this.bitmap == null) || (!this.aXp))
    {
      AppMethodBeat.o(157432);
      return 0;
    }
    int i = this.aYf;
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
  
  private int rU()
  {
    AppMethodBeat.i(157433);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.aXh;
      AppMethodBeat.o(157433);
      return i;
    }
    i = this.aXg;
    AppMethodBeat.o(157433);
    return i;
  }
  
  private int rV()
  {
    AppMethodBeat.i(157434);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.aXg;
      AppMethodBeat.o(157434);
      return i;
    }
    i = this.aXh;
    AppMethodBeat.o(157434);
    return i;
  }
  
  private float rW()
  {
    AppMethodBeat.i(157441);
    int i = getPaddingBottom() + getPaddingTop();
    int j = getPaddingLeft() + getPaddingRight();
    if ((this.aXI == 2) || (this.aXI == 4))
    {
      f = Math.max((getWidth() - j) / rU(), (getHeight() - i) / rV());
      AppMethodBeat.o(157441);
      return f;
    }
    if ((this.aXI == 3) && (this.aXF > 0.0F))
    {
      f = this.aXF;
      AppMethodBeat.o(157441);
      return f;
    }
    float f = Math.min((getWidth() - j) / rU(), (getHeight() - i) / rV());
    AppMethodBeat.o(157441);
    return f;
  }
  
  private void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(157410);
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
    {
      ae.i(this.TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(157410);
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(157404);
    h("reset newImage=".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.scale = 0.0F;
    this.aXU = 0.0F;
    this.aXV = null;
    this.aXW = null;
    this.aXX = null;
    this.aXY = Float.valueOf(0.0F);
    this.aXZ = null;
    this.aYa = null;
    this.aYh = false;
    this.aYi = false;
    this.aYj = false;
    this.aYk = 0;
    this.aXv = 0;
    this.aYq = null;
    this.aYr = 0.0F;
    this.aYt = 0.0F;
    this.aYu = false;
    this.aYw = null;
    this.aYv = null;
    this.aYx = null;
    this.aYy = null;
    this.aYI = null;
    this.gR = null;
    this.aYJ = null;
    Object localObject1;
    if (paramBoolean)
    {
      if (this.aZf != null)
      {
        localObject1 = this.aZf;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aXc = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aXa = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aXc = 0;
      }
      this.uri = null;
      this.aWM.writeLock().lock();
    }
    com.davemorrissey.labs.subscaleview.c.e locale;
    label512:
    try
    {
      if (this.aWT != null)
      {
        this.aWT.recycle();
        this.aWT = null;
      }
      this.aWM.writeLock().unlock();
      if ((this.bitmap != null) && (!this.aXu)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aXu) && (this.aYB != null)) {
        this.aYB.rZ();
      }
      this.aXg = 0;
      this.aXh = 0;
      this.aYe = 0;
      this.aXi = null;
      this.aYg = null;
      this.aYz = false;
      this.aYA = false;
      this.bitmap = null;
      this.aXp = false;
      this.aXu = false;
      this.aXq = false;
      this.aXr = false;
      this.aXw = true;
      if (this.aXC == null) {
        break label534;
      }
      localObject1 = this.aXC.entrySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label529;
        }
        Iterator localIterator = ((List)((Map.Entry)((Iterator)localObject1).next()).getValue()).iterator();
        while (localIterator.hasNext())
        {
          locale = (com.davemorrissey.labs.subscaleview.c.e)localIterator.next();
          locale.visible = false;
          if (locale.bitmap != null)
          {
            if (this.aYd == null) {
              break label489;
            }
            if (this.aYd.bitmap != locale.bitmap) {
              break label512;
            }
            ae.i(this.TAG, "alvinluo reset tile bitmap not need to recycle: %d", new Object[] { Integer.valueOf(locale.bitmap.hashCode()) });
          }
        }
      }
    }
    finally
    {
      label489:
      this.aWM.writeLock().unlock();
      AppMethodBeat.o(157404);
    }
    label529:
    this.aXC = null;
    label534:
    setGestureDetector(getContext());
    AppMethodBeat.o(157404);
  }
  
  public static void setBitmapLoaderImp(com.davemorrissey.labs.subscaleview.c.a parama)
  {
    aYO = parama;
  }
  
  private void setFullImageBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(157425);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(157380);
        if (paramBitmap != null)
        {
          long l1 = System.currentTimeMillis();
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(paramBitmap, SubsamplingScaleImageView.t(SubsamplingScaleImageView.this)));
          long l2 = System.currentTimeMillis();
          ae.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo rotate and scale fullImageBitmap cost: %d", new Object[] { Long.valueOf(l2 - l1) });
        }
        AppMethodBeat.o(157380);
      }
    }, "rotateAndScaleBitmap");
    AppMethodBeat.o(157425);
  }
  
  private void setGestureDetector(final Context paramContext)
  {
    AppMethodBeat.i(157405);
    this.aYl = new GestureDetector(paramContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(213539);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(213539);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157378);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if ((SubsamplingScaleImageView.k(SubsamplingScaleImageView.this)) && (SubsamplingScaleImageView.f(SubsamplingScaleImageView.this)) && (SubsamplingScaleImageView.g(SubsamplingScaleImageView.this) != null))
        {
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, paramContext);
          ae.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo onDoubleTap, quickScaledEnabled: %b", new Object[] { Boolean.valueOf(SubsamplingScaleImageView.m(SubsamplingScaleImageView.this)) });
          if (SubsamplingScaleImageView.m(SubsamplingScaleImageView.this))
          {
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()));
            SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, new PointF(SubsamplingScaleImageView.g(SubsamplingScaleImageView.this).x, SubsamplingScaleImageView.g(SubsamplingScaleImageView.this).y));
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.i(SubsamplingScaleImageView.this));
            SubsamplingScaleImageView.n(SubsamplingScaleImageView.this);
            SubsamplingScaleImageView.o(SubsamplingScaleImageView.this);
            SubsamplingScaleImageView.p(SubsamplingScaleImageView.this);
            SubsamplingScaleImageView.c(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(SubsamplingScaleImageView.q(SubsamplingScaleImageView.this)));
            SubsamplingScaleImageView.d(SubsamplingScaleImageView.this, new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()));
            SubsamplingScaleImageView.e(SubsamplingScaleImageView.this, new PointF(SubsamplingScaleImageView.r(SubsamplingScaleImageView.this).x, SubsamplingScaleImageView.r(SubsamplingScaleImageView.this).y));
            SubsamplingScaleImageView.s(SubsamplingScaleImageView.this);
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(157378);
            return false;
          }
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY())), new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()));
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
        if ((SubsamplingScaleImageView.e(SubsamplingScaleImageView.this)) && (SubsamplingScaleImageView.f(SubsamplingScaleImageView.this)) && (SubsamplingScaleImageView.g(SubsamplingScaleImageView.this) != null) && (paramAnonymousMotionEvent1 != null) && (paramAnonymousMotionEvent2 != null) && ((Math.abs(paramAnonymousMotionEvent1.getX() - paramAnonymousMotionEvent2.getX()) > 50.0F) || (Math.abs(paramAnonymousMotionEvent1.getY() - paramAnonymousMotionEvent2.getY()) > 50.0F)) && ((Math.abs(paramAnonymousFloat1) > 500.0F) || (Math.abs(paramAnonymousFloat2) > 500.0F)) && (!SubsamplingScaleImageView.h(SubsamplingScaleImageView.this)))
        {
          paramAnonymousMotionEvent1 = new PointF(SubsamplingScaleImageView.g(SubsamplingScaleImageView.this).x + paramAnonymousFloat1 * 0.25F, SubsamplingScaleImageView.g(SubsamplingScaleImageView.this).y + 0.25F * paramAnonymousFloat2);
          paramAnonymousFloat1 = (SubsamplingScaleImageView.this.getWidth() / 2 - paramAnonymousMotionEvent1.x) / SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
          paramAnonymousFloat2 = (SubsamplingScaleImageView.this.getHeight() / 2 - paramAnonymousMotionEvent1.y) / SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
          paramAnonymousMotionEvent1 = new SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, new PointF(paramAnonymousFloat1, paramAnonymousFloat2), (byte)0);
          if (!SubsamplingScaleImageView.rX().contains(Integer.valueOf(1)))
          {
            paramAnonymousMotionEvent1 = new IllegalArgumentException("Unknown easing type: 1");
            AppMethodBeat.o(157376);
            throw paramAnonymousMotionEvent1;
          }
          paramAnonymousMotionEvent1.aZz = 1;
          paramAnonymousMotionEvent1.aZF = false;
          paramAnonymousMotionEvent1.aZA = 3;
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
        AppMethodBeat.i(213538);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(213538);
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157377);
        if (SubsamplingScaleImageView.j(SubsamplingScaleImageView.this) != null)
        {
          boolean bool = SubsamplingScaleImageView.j(SubsamplingScaleImageView.this).onSingleTapConfirmed(paramAnonymousMotionEvent);
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
        AppMethodBeat.i(213537);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(213537);
        return bool;
      }
    });
    this.aYn = new GestureDetector(paramContext, new SubsamplingScaleImageView.4(this));
    AppMethodBeat.o(157405);
  }
  
  public static void setPreferredBitmapConfig(Bitmap.Config paramConfig)
  {
    aYN = paramConfig;
  }
  
  public static void setTileInitLoaderImp(com.davemorrissey.labs.subscaleview.c.c paramc)
  {
    aYQ = paramc;
  }
  
  public static void setTileLoaderImp(com.davemorrissey.labs.subscaleview.c.d paramd)
  {
    aYP = paramd;
  }
  
  public final float Y(float paramFloat)
  {
    if (this.aXV == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.aXV.x;
  }
  
  public final float Z(float paramFloat)
  {
    if (this.aXV == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.aXV.y;
  }
  
  public final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(157427);
    if (paramBitmap == null)
    {
      ae.e(this.TAG, "alvinluo rotateAndScaleBitmap bitmap is null");
      AppMethodBeat.o(157427);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(1.0F, 1.0F);
    if (paramInt != 0) {
      localMatrix.postRotate(paramInt);
    }
    ae.d(this.TAG, "alvinluo rotateAndScaleBitmap matrix.isIdentify: %b", new Object[] { Boolean.valueOf(localMatrix.isIdentity()) });
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
        ae.printErrStackTrace(this.TAG, paramBitmap, "alvinluo createBitmap oom", new Object[0]);
        aYN = Bitmap.Config.RGB_565;
        AppMethodBeat.o(157427);
        return null;
      }
    }
    AppMethodBeat.o(157427);
    return null;
  }
  
  public final PointF a(PointF paramPointF)
  {
    AppMethodBeat.i(157436);
    paramPointF = a(paramPointF.x, paramPointF.y, new PointF());
    AppMethodBeat.o(157436);
    return paramPointF;
  }
  
  public final void a(float paramFloat, PointF paramPointF)
  {
    AppMethodBeat.i(157456);
    this.aYy = null;
    this.aYb = true;
    this.aXY = Float.valueOf(paramFloat);
    this.aXZ = paramPointF;
    this.aYa = paramPointF;
    invalidate();
    AppMethodBeat.o(157456);
  }
  
  public final void a(Bitmap paramBitmap, Integer paramInteger)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(157428);
        ae.i(this.TAG, "alvinluo onPreviewLoaded");
        if (paramBitmap != null) {
          ae.i(this.TAG, "alvinluo onPreviewLoaded %d, recycle: %b", new Object[] { Integer.valueOf(paramBitmap.hashCode()), Boolean.valueOf(paramBitmap.isRecycled()) });
        }
        long l = System.currentTimeMillis();
        if (this.aYA)
        {
          if (this.bitmap != null) {
            this.bitmap.recycle();
          }
          AppMethodBeat.o(157428);
          return;
        }
        if (this.aYg != null)
        {
          if ((this.aYg.width() > 0) && (this.aYg.height() > 0))
          {
            this.bitmap = Bitmap.createBitmap(paramBitmap, this.aYg.left, this.aYg.top, this.aYg.width(), this.aYg.height());
            this.aYf = 0;
          }
          this.aXp = true;
          this.aXr = false;
          this.aXs = this.bitmap.getWidth();
          this.aXt = this.bitmap.getHeight();
          rL();
          this.aXr = true;
          if (rP())
          {
            invalidate();
            requestLayout();
          }
          dD((int)(System.currentTimeMillis() - l));
          ae.i(this.TAG, "alvinluo onPreviewLoaded");
          if ((!this.aXq) && (this.aYB != null)) {
            this.aYB.rY();
          }
          AppMethodBeat.o(157428);
          continue;
        }
        if (paramInteger == null) {
          break label283;
        }
      }
      finally {}
      this.aYf = paramInteger.intValue();
      label283:
      this.bitmap = paramBitmap;
    }
  }
  
  public final void a(com.davemorrissey.labs.subscaleview.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(157424);
      h("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.aXg), Integer.valueOf(this.aXh), Integer.valueOf(paramInt3) });
      if ((this.aXg > 0) && (this.aXh > 0) && ((this.aXg != paramInt1) || (this.aXh != paramInt2)))
      {
        reset(false);
        if (this.bitmap != null)
        {
          if (!this.aXu) {
            this.bitmap.recycle();
          }
          this.bitmap = null;
          if ((this.aYB != null) && (this.aXu)) {
            this.aYB.rZ();
          }
          this.aXp = false;
          this.aXu = false;
        }
      }
      this.aWT = paramd;
      this.aXg = paramInt1;
      this.aXh = paramInt2;
      this.aYe = paramInt3;
      rP();
      if ((!rQ()) && (this.aXK > 0) && (this.aXK != aXJ) && (this.aXL > 0) && (this.aXL != aXJ) && (getWidth() > 0) && (getHeight() > 0)) {
        a(new Point(this.aXK, this.aXL));
      }
      invalidate();
      requestLayout();
      System.currentTimeMillis();
      AppMethodBeat.o(157424);
      return;
    }
    finally {}
  }
  
  public final void a(a parama1, a parama2)
  {
    AppMethodBeat.i(157403);
    if (parama1 == null)
    {
      parama1 = new NullPointerException("imageSource must not be null");
      AppMethodBeat.o(157403);
      throw parama1;
    }
    this.aYc = parama1;
    this.aYd = parama2;
    reset(true);
    if (parama1.getUri() != null) {
      this.aYe = d(getContext(), parama1.getUri());
    }
    if (parama2 != null)
    {
      if ((parama1.aXg > 0) && (parama1.aXh > 0)) {
        break label157;
      }
      ae.e(this.TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
    }
    while ((parama1.bitmap != null) && (parama1.aXi != null))
    {
      b(Bitmap.createBitmap(parama1.bitmap, parama1.aXi.left, parama1.aXi.top, parama1.aXi.width(), parama1.aXi.height()), 0, false);
      AppMethodBeat.o(157403);
      return;
      label157:
      this.aXg = parama1.aXg;
      this.aXh = parama1.aXh;
      this.aYg = parama2.aXi;
      if (parama2.bitmap != null)
      {
        this.aXu = parama2.aXj;
        a(parama2.bitmap, Integer.valueOf(0));
      }
      else
      {
        Uri localUri2 = parama2.getUri();
        Uri localUri1 = localUri2;
        if (localUri2 == null)
        {
          localUri1 = localUri2;
          if (parama2.aXe != null) {
            localUri1 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama2.aXe);
          }
        }
        aYO.a(this, getContext(), this.aYo, localUri1, true).rG();
      }
    }
    if (parama1.bitmap != null)
    {
      b(parama1.bitmap, 0, parama1.aXj);
      AppMethodBeat.o(157403);
      return;
    }
    this.aXi = parama1.aXi;
    this.uri = parama1.getUri();
    if ((this.uri == null) && (parama1.aXe != null)) {
      this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama1.aXe);
    }
    if ((parama1.aXf) || (this.aXi != null))
    {
      aYQ.a(this, getContext(), this.aYp, this.uri).rG();
      AppMethodBeat.o(157403);
      return;
    }
    aYO.a(this, getContext(), this.aYo, this.uri, false).rG();
    AppMethodBeat.o(157403);
  }
  
  public final PointF b(PointF paramPointF)
  {
    AppMethodBeat.i(157438);
    paramPointF = b(paramPointF.x, paramPointF.y, new PointF());
    AppMethodBeat.o(157438);
    return paramPointF;
  }
  
  public final void b(final Bitmap paramBitmap, final int paramInt, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(157429);
      h("onImageLoaded has bitmap", new Object[0]);
      if ((this.aXg > 0) && (this.aXh > 0) && ((this.aXg != paramBitmap.getWidth()) || (this.aXh != paramBitmap.getHeight()))) {
        reset(false);
      }
      if ((this.bitmap != null) && (!this.aXu)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aXu) && (this.aYB != null)) {
        this.aYB.rZ();
      }
      this.aXp = false;
      this.aXu = paramBoolean;
      this.bitmap = paramBitmap;
      this.aXg = paramBitmap.getWidth();
      this.aXh = paramBitmap.getHeight();
      this.aYe = paramInt;
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(157382);
          long l1 = System.currentTimeMillis();
          if (paramInt != 0) {
            SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(paramBitmap, paramInt));
          }
          long l2 = System.currentTimeMillis();
          ae.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo onImageLoaded rotaeAndScaleBitmap %d", new Object[] { Long.valueOf(l2 - l1) });
          SubsamplingScaleImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157381);
              if ((SubsamplingScaleImageView.6.this.aZo) || (SubsamplingScaleImageView.6.this.aZp))
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
  
  /* Error */
  public final void b(com.davemorrissey.labs.subscaleview.c.e parame)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 1356
    //   7: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokestatic 1052	java/lang/System:currentTimeMillis	()J
    //   14: putfield 302	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXx	J
    //   17: aload_0
    //   18: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   21: astore 4
    //   23: aload_1
    //   24: getfield 838	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   27: istore_2
    //   28: aload_1
    //   29: getfield 843	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   32: ifnonnull +166 -> 198
    //   35: aload 4
    //   37: ldc_w 1358
    //   40: iconst_2
    //   41: anewarray 284	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: iload_2
    //   47: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: iload_3
    //   54: invokestatic 1009	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 1228	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_1
    //   62: getfield 838	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   65: aload_0
    //   66: getfield 681	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXv	I
    //   69: if_icmpne +40 -> 109
    //   72: aload_1
    //   73: getfield 843	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   76: ifnull +33 -> 109
    //   79: aload_0
    //   80: getfield 298	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXw	Z
    //   83: ifeq +26 -> 109
    //   86: aload_0
    //   87: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   90: ldc_w 1360
    //   93: invokestatic 772	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 298	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXw	Z
    //   101: aload_0
    //   102: aload_1
    //   103: getfield 843	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   106: putfield 612	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXz	Landroid/graphics/Bitmap;
    //   109: aload_0
    //   110: invokespecial 1272	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:rP	()Z
    //   113: pop
    //   114: aload_0
    //   115: invokespecial 1289	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:rQ	()Z
    //   118: pop
    //   119: aload_0
    //   120: invokespecial 1037	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:rO	()Z
    //   123: ifeq +62 -> 185
    //   126: aload_0
    //   127: getfield 874	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   130: ifnull +55 -> 185
    //   133: aload_0
    //   134: getfield 1146	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXu	Z
    //   137: ifne +10 -> 147
    //   140: aload_0
    //   141: getfield 874	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   144: invokevirtual 846	android/graphics/Bitmap:recycle	()V
    //   147: aload_0
    //   148: aconst_null
    //   149: putfield 874	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   152: aload_0
    //   153: getfield 1148	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aYB	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   156: ifnull +19 -> 175
    //   159: aload_0
    //   160: getfield 1146	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXu	Z
    //   163: ifeq +12 -> 175
    //   166: aload_0
    //   167: getfield 1148	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aYB	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   170: invokeinterface 1151 1 0
    //   175: aload_0
    //   176: iconst_0
    //   177: putfield 985	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXp	Z
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 1146	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXu	Z
    //   185: aload_0
    //   186: invokevirtual 746	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:invalidate	()V
    //   189: ldc_w 1356
    //   192: invokestatic 264	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	208	1	parame	com.davemorrissey.labs.subscaleview.c.e
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
  
  /* Error */
  public final int d(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc_w 1365
    //   9: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: ldc_w 1367
    //   15: aload_2
    //   16: invokevirtual 1370	android/net/Uri:getScheme	()Ljava/lang/String;
    //   19: invokevirtual 1371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +168 -> 190
    //   25: aload_1
    //   26: invokevirtual 1375	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: aload_2
    //   30: iconst_1
    //   31: anewarray 476	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc_w 1376
    //   39: aastore
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 1382	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +86 -> 134
    //   51: aload_1
    //   52: invokeinterface 1387 1 0
    //   57: ifeq +77 -> 134
    //   60: aload_1
    //   61: iconst_0
    //   62: invokeinterface 1390 2 0
    //   67: istore_3
    //   68: getstatic 226	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXk	Ljava/util/List;
    //   71: iload_3
    //   72: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokeinterface 1393 2 0
    //   80: istore 5
    //   82: iload 5
    //   84: ifeq +33 -> 117
    //   87: iload_3
    //   88: iconst_m1
    //   89: if_icmpeq +28 -> 117
    //   92: iload_3
    //   93: istore 4
    //   95: aload_1
    //   96: ifnull +12 -> 108
    //   99: aload_1
    //   100: invokeinterface 1396 1 0
    //   105: iload_3
    //   106: istore 4
    //   108: ldc_w 1365
    //   111: invokestatic 264	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: iload 4
    //   116: ireturn
    //   117: aload_0
    //   118: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   121: ldc_w 1398
    //   124: iload_3
    //   125: invokestatic 600	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   128: invokevirtual 495	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   131: invokestatic 1400	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: iconst_0
    //   135: istore_3
    //   136: goto -44 -> 92
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   146: ldc_w 1402
    //   149: invokestatic 1400	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_1
    //   153: ifnull +253 -> 406
    //   156: aload_1
    //   157: invokeinterface 1396 1 0
    //   162: iconst_0
    //   163: istore 4
    //   165: goto -57 -> 108
    //   168: astore_1
    //   169: aload 7
    //   171: astore_2
    //   172: aload_2
    //   173: ifnull +9 -> 182
    //   176: aload_2
    //   177: invokeinterface 1396 1 0
    //   182: ldc_w 1365
    //   185: invokestatic 264	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    //   190: aload_2
    //   191: aconst_null
    //   192: invokestatic 1407	com/tencent/mm/vfs/o:b	(Landroid/net/Uri;Lcom/tencent/mm/vfs/e$e;)Ljava/io/InputStream;
    //   195: astore 7
    //   197: new 1409	androidx/a/a/a
    //   200: dup
    //   201: aload 7
    //   203: invokespecial 1412	androidx/a/a/a:<init>	(Ljava/io/InputStream;)V
    //   206: ldc_w 1414
    //   209: iconst_1
    //   210: invokevirtual 1418	androidx/a/a/a:getAttributeInt	(Ljava/lang/String;I)I
    //   213: istore_3
    //   214: iload_3
    //   215: iconst_1
    //   216: if_icmpeq +7 -> 223
    //   219: iload_3
    //   220: ifne +41 -> 261
    //   223: iconst_0
    //   224: istore_3
    //   225: iload_3
    //   226: istore 4
    //   228: aload 7
    //   230: ifnull -122 -> 108
    //   233: aload 7
    //   235: invokevirtual 1421	java/io/InputStream:close	()V
    //   238: iload_3
    //   239: istore 4
    //   241: goto -133 -> 108
    //   244: astore_1
    //   245: aload_0
    //   246: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   249: ldc_w 1423
    //   252: invokestatic 1400	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: iload_3
    //   256: istore 4
    //   258: goto -150 -> 108
    //   261: iload_3
    //   262: bipush 6
    //   264: if_icmpne +9 -> 273
    //   267: bipush 90
    //   269: istore_3
    //   270: goto -45 -> 225
    //   273: iload_3
    //   274: iconst_3
    //   275: if_icmpne +10 -> 285
    //   278: sipush 180
    //   281: istore_3
    //   282: goto -57 -> 225
    //   285: iload_3
    //   286: bipush 8
    //   288: if_icmpne +10 -> 298
    //   291: sipush 270
    //   294: istore_3
    //   295: goto -70 -> 225
    //   298: aload_0
    //   299: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   302: ldc_w 1425
    //   305: iload_3
    //   306: invokestatic 600	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   309: invokevirtual 495	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   312: invokestatic 1400	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: iconst_0
    //   316: istore_3
    //   317: goto -92 -> 225
    //   320: astore_2
    //   321: ldc_w 1365
    //   324: invokestatic 264	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: aload_2
    //   328: athrow
    //   329: astore_1
    //   330: aload 7
    //   332: ifnull +12 -> 344
    //   335: aload_2
    //   336: ifnull +27 -> 363
    //   339: aload 7
    //   341: invokevirtual 1421	java/io/InputStream:close	()V
    //   344: ldc_w 1365
    //   347: invokestatic 264	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: aload_1
    //   351: athrow
    //   352: astore 6
    //   354: aload_2
    //   355: aload 6
    //   357: invokevirtual 1429	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   360: goto -16 -> 344
    //   363: aload 7
    //   365: invokevirtual 1421	java/io/InputStream:close	()V
    //   368: goto -24 -> 344
    //   371: astore_1
    //   372: aload 6
    //   374: astore_2
    //   375: goto -45 -> 330
    //   378: astore_2
    //   379: aload_1
    //   380: astore 6
    //   382: aload_2
    //   383: astore_1
    //   384: aload 6
    //   386: astore_2
    //   387: goto -215 -> 172
    //   390: astore_2
    //   391: aload_1
    //   392: astore 6
    //   394: aload_2
    //   395: astore_1
    //   396: aload 6
    //   398: astore_2
    //   399: goto -227 -> 172
    //   402: astore_2
    //   403: goto -261 -> 142
    //   406: iconst_0
    //   407: istore 4
    //   409: goto -301 -> 108
    //   412: astore_1
    //   413: iconst_0
    //   414: istore_3
    //   415: goto -170 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	SubsamplingScaleImageView
    //   0	418	1	paramContext	Context
    //   0	418	2	paramUri	Uri
    //   67	348	3	i	int
    //   93	315	4	j	int
    //   80	3	5	bool	boolean
    //   1	1	6	localObject	Object
    //   352	21	6	localThrowable	java.lang.Throwable
    //   380	17	6	localContext	Context
    //   4	360	7	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   25	47	139	java/lang/Exception
    //   25	47	168	finally
    //   233	238	244	java/lang/Exception
    //   197	214	320	java/lang/Throwable
    //   298	315	320	java/lang/Throwable
    //   321	329	329	finally
    //   339	344	352	java/lang/Throwable
    //   197	214	371	finally
    //   298	315	371	finally
    //   51	82	378	finally
    //   117	134	378	finally
    //   142	152	390	finally
    //   51	82	402	java/lang/Exception
    //   117	134	402	java/lang/Exception
    //   190	197	412	java/lang/Exception
    //   339	344	412	java/lang/Exception
    //   344	352	412	java/lang/Exception
    //   354	360	412	java/lang/Exception
    //   363	368	412	java/lang/Exception
  }
  
  public final void dC(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157388);
      if (this.aZf != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aZf;
        locala.aXb += paramInt;
        ae.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aXb) });
      }
      AppMethodBeat.o(157388);
      return;
    }
    finally {}
  }
  
  public final void dD(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157389);
      if (this.aZf != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aZf;
        locala.aXa += paramInt;
        ae.d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aXa) });
      }
      AppMethodBeat.o(157389);
      return;
    }
    finally {}
  }
  
  public final void dE(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157390);
      if (this.aZf != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aZf;
        locala.aXc += paramInt;
        ae.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aXc) });
      }
      AppMethodBeat.o(157390);
      return;
    }
    finally {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157408);
    ae.d(this.TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(157408);
    return bool;
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
    PointF localPointF = a(i, j, new PointF());
    AppMethodBeat.o(157455);
    return localPointF;
  }
  
  public ReadWriteLock getDecoderLock()
  {
    return this.aWM;
  }
  
  public Bitmap getFullImageBitmap()
  {
    return this.aXz;
  }
  
  public int getFullImageSampleSize()
  {
    return this.aXv;
  }
  
  public com.davemorrissey.labs.subscaleview.d.a getImageDecodeRecord()
  {
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala = this.aZf;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public float getMaxScale()
  {
    return this.aXE;
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(157453);
    float f = rW();
    AppMethodBeat.o(157453);
    return f;
  }
  
  public e getOnImageEventListener()
  {
    return this.aYB;
  }
  
  public final int getOrientation()
  {
    return this.orientation;
  }
  
  public int getPreviewHeight()
  {
    return this.aXt;
  }
  
  public int getPreviewOrientation()
  {
    return this.aYf;
  }
  
  public int getPreviewWidth()
  {
    return this.aXs;
  }
  
  public int getRequiredRotation()
  {
    if (this.orientation == -1) {
      return this.aYe;
    }
    return this.orientation;
  }
  
  public final int getSHeight()
  {
    return this.aXh;
  }
  
  public final int getSWidth()
  {
    return this.aXg;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  public final b getState()
  {
    AppMethodBeat.i(157458);
    if ((this.aXV != null) && (this.aXg > 0) && (this.aXh > 0))
    {
      b localb = new b(getScale(), getCenter(), getOrientation());
      AppMethodBeat.o(157458);
      return localb;
    }
    AppMethodBeat.o(157458);
    return null;
  }
  
  public Rect getsRegion()
  {
    return this.aXi;
  }
  
  public final void h(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(157444);
    ae.d(this.TAG, String.format(paramString, paramVarArgs));
    AppMethodBeat.o(157444);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(157391);
    super.onAttachedToWindow();
    if (this.aZe != null) {
      this.aZe.onViewAttachedToWindow(this);
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
      ae.i(this.TAG, "alvinluo cancelAllTileLoadTask, task size: %d", new Object[] { Integer.valueOf(this.aYR.size()) });
      Iterator localIterator = this.aYR.iterator();
      while (localIterator.hasNext()) {
        ((com.davemorrissey.labs.subscaleview.c.b)localIterator.next()).cancel();
      }
      this.aYR.clear();
    }
    if (this.aZe != null) {
      this.aZe.onViewDetachedFromWindow(this);
    }
    AppMethodBeat.o(157392);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(157413);
    super.onDraw(paramCanvas);
    System.currentTimeMillis();
    if (this.aYE == null)
    {
      this.aYE = new Paint();
      this.aYE.setAntiAlias(true);
      this.aYE.setFilterBitmap(true);
      this.aYE.setDither(true);
    }
    if (((this.aYF == null) || (this.aYG == null)) && (this.aXD))
    {
      this.aYF = new Paint();
      this.aYF.setTextSize(px(20));
      this.aYF.setColor(-65281);
      this.aYF.setStyle(Paint.Style.FILL);
      this.aYG = new Paint();
      this.aYG.setColor(-65281);
      this.aYG.setStyle(Paint.Style.STROKE);
      this.aYG.setStrokeWidth(px(1));
    }
    if ((this.aXg == 0) || (this.aXh == 0) || (getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(157413);
      return;
    }
    int j;
    int k;
    if ((this.aXC == null) && (this.aWT != null))
    {
      j = Math.min(paramCanvas.getMaximumBitmapWidth(), this.aXK);
      k = Math.min(paramCanvas.getMaximumBitmapHeight(), this.aXL);
      i = j;
      if (j > 10000) {
        i = 10000;
      }
      j = k;
      if (k > 10000) {
        j = 10000;
      }
      ae.i(this.TAG, "alvinluo getMaxBitmapDimensions %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      a(new Point(i, j));
    }
    if (!rP())
    {
      AppMethodBeat.o(157413);
      return;
    }
    rR();
    boolean bool1;
    float f1;
    boolean bool2;
    if ((this.aYy != null) && (this.aYy.aZw != null))
    {
      if (this.aXX == null) {
        this.aXX = new PointF(0.0F, 0.0F);
      }
      this.aXX.set(this.aXV);
      long l = System.currentTimeMillis() - this.aYy.time;
      if (l > this.aYy.duration)
      {
        bool1 = true;
        l = Math.min(l, this.aYy.duration);
        this.scale = a(this.aYy.aZz, l, this.aYy.aXU, this.aYy.aZs - this.aYy.aXU, this.aYy.duration);
        f1 = a(this.aYy.aZz, l, this.aYy.aZw.x, this.aYy.aZx.x - this.aYy.aZw.x, this.aYy.duration);
        f2 = a(this.aYy.aZz, l, this.aYy.aZw.y, this.aYy.aZx.y - this.aYy.aZw.y, this.aYy.duration);
        localObject1 = this.aXV;
        ((PointF)localObject1).x -= Y(this.aYy.aZu.x) - f1;
        localObject1 = this.aXV;
        ((PointF)localObject1).y -= Z(this.aYy.aZu.y) - f2;
        if ((!bool1) && (this.aYy.aXU != this.aYy.aZs)) {
          break label883;
        }
        bool2 = true;
        label669:
        aL(bool2);
        c(this.aXX);
        aK(bool1);
        if (bool1) {
          this.aYy = null;
        }
        invalidate();
      }
    }
    else
    {
      if ((this.aXC == null) || (!rO()) || (!this.aZb)) {
        break label1797;
      }
      k = Math.min(this.aXv, V(this.scale));
      localObject1 = this.aXC.entrySet().iterator();
    }
    Object localObject2;
    Object localObject3;
    for (int i = 0;; i = j)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label896;
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
          localObject3 = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject2).next();
          if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).visible) && ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWX) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null))) {
            i = 1;
          }
        }
        bool1 = false;
        break;
        label883:
        bool2 = false;
        break label669;
      }
    }
    label896:
    Object localObject1 = this.aXC.entrySet().iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((((Integer)((Map.Entry)localObject2).getKey()).intValue() == k) || (i != 0))
        {
          localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
          label1795:
          for (;;)
          {
            label974:
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject2).next();
              Rect localRect = ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWW;
              ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.set((int)Y(localRect.left), (int)Z(localRect.top), (int)Y(localRect.right), (int)Z(localRect.bottom));
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWX) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null)) {
                break label1737;
              }
              if (this.aYH != null) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY, this.aYH);
              }
              if (this.gR == null) {
                this.gR = new Matrix();
              }
              this.gR.reset();
              a(this.aYK, 0.0F, 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight());
              if (getRequiredRotation() != 0) {
                break label1462;
              }
              a(this.aYL, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.bottom);
              label1249:
              this.gR.setPolyToPoly(this.aYK, 0, this.aYL, 0, 4);
              if (!((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.isRecycled()) {
                paramCanvas.drawBitmap(((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap, this.gR, this.aYE);
              }
              if (this.aXD) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY, this.aYG);
              }
            }
            for (;;)
            {
              if ((!((com.davemorrissey.labs.subscaleview.c.e)localObject3).visible) || (!this.aXD)) {
                break label1795;
              }
              paramCanvas.drawText("ISS " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).sampleSize + " RECT " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWW.top + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWW.left + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWW.bottom + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWW.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.top + px(15), this.aYF);
              break label974;
              break;
              label1462:
              if (getRequiredRotation() == 90)
              {
                a(this.aYL, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.top);
                break label1249;
              }
              if (getRequiredRotation() == 180)
              {
                a(this.aYL, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.top);
                break label1249;
              }
              if (getRequiredRotation() != 270) {
                break label1249;
              }
              a(this.aYL, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.bottom);
              break label1249;
              label1737:
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWX) && (this.aXD)) {
                paramCanvas.drawText("LOADING", ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWY.top + px(35), this.aYF);
              }
            }
          }
          label1797:
          if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
          {
            ae.d(this.TAG, "alvinluo onDraw bitmap scale: %f", new Object[] { Float.valueOf(this.scale) });
            if ((!this.aXp) || (this.aXr))
            {
              if (this.gR == null) {
                this.gR = new Matrix();
              }
              this.gR.reset();
              i = this.bitmap.getWidth();
              j = this.bitmap.getHeight();
              if ((this.aYf == 90) || (this.aYf == 270))
              {
                i = this.bitmap.getHeight();
                j = this.bitmap.getWidth();
              }
              if (this.aXp)
              {
                f1 = i / 2.0F;
                f2 = j / 2.0F;
                rL();
                this.gR.postScale(this.aYX, this.aYY, f1, f2);
              }
              f1 = (this.aYS - this.bitmap.getWidth()) / 2;
              f2 = (this.aYT - this.bitmap.getHeight()) / 2;
              this.gR.postTranslate(f1, f2);
              ae.d(this.TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
              if (this.aYH != null)
              {
                if (this.aYJ == null) {
                  this.aYJ = new RectF();
                }
                localObject1 = this.aYJ;
                if (!this.aXp) {
                  break label2880;
                }
                f1 = this.bitmap.getWidth();
                if (!this.aXp) {
                  break label2889;
                }
              }
            }
          }
        }
      }
    }
    label2880:
    label2889:
    for (float f2 = this.bitmap.getHeight();; f2 = this.aXh)
    {
      ((RectF)localObject1).set(0.0F, 0.0F, f1, f2);
      this.gR.mapRect(this.aYJ);
      paramCanvas.drawRect(this.aYJ, this.aYH);
      paramCanvas.drawBitmap(this.bitmap, this.gR, this.aYE);
      if (this.aXD)
      {
        ae.d(this.TAG, "alvinluo onDraw debug vTranslate %f, %f", new Object[] { Float.valueOf(this.aXV.x), Float.valueOf(this.aXV.y) });
        paramCanvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.scale) }) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(rW()) }) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aXE) }) + ")", px(5), px(15), this.aYF);
        paramCanvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aXV.x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aXV.y) }), px(5), px(30), this.aYF);
        localObject1 = getCenter();
        paramCanvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).y) }), px(5), px(45), this.aYF);
        if (this.aYy != null)
        {
          localObject1 = b(this.aYy.aZt);
          localObject2 = b(this.aYy.aZv);
          localObject3 = b(this.aYy.aZu);
          paramCanvas.drawCircle(((PointF)localObject1).x, ((PointF)localObject1).y, px(10), this.aYG);
          this.aYG.setColor(-65536);
          paramCanvas.drawCircle(((PointF)localObject2).x, ((PointF)localObject2).y, px(20), this.aYG);
          this.aYG.setColor(-16776961);
          paramCanvas.drawCircle(((PointF)localObject3).x, ((PointF)localObject3).y, px(25), this.aYG);
          this.aYG.setColor(-16711681);
          paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.aYG);
        }
        if (this.aYq != null)
        {
          this.aYG.setColor(-65536);
          paramCanvas.drawCircle(this.aYq.x, this.aYq.y, px(20), this.aYG);
        }
        if (this.aYw != null)
        {
          this.aYG.setColor(-16776961);
          paramCanvas.drawCircle(Y(this.aYw.x), Z(this.aYw.y), px(35), this.aYG);
        }
        if ((this.aYx != null) && (this.aYj))
        {
          this.aYG.setColor(-16711681);
          paramCanvas.drawCircle(this.aYx.x, this.aYx.y, px(30), this.aYG);
        }
        this.aYG.setColor(-65281);
      }
      AppMethodBeat.o(157413);
      return;
      f1 = this.aXg;
      break;
    }
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
        break label159;
      }
      i = 1;
      label47:
      if ((this.aXg <= 0) || (this.aXh <= 0)) {
        break label214;
      }
      if ((paramInt2 == 0) || (i == 0)) {
        break label164;
      }
      paramInt2 = rU();
      paramInt1 = rV();
    }
    for (;;)
    {
      paramInt2 = Math.max(paramInt2, getSuggestedMinimumWidth());
      paramInt1 = Math.max(paramInt1, getSuggestedMinimumHeight());
      setMeasuredDimension(paramInt2, paramInt1);
      this.aYS = paramInt2;
      this.aYT = paramInt1;
      ae.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", new Object[] { Integer.valueOf(this.aYS), Integer.valueOf(this.aYS) });
      AppMethodBeat.o(157407);
      return;
      paramInt2 = 0;
      break;
      label159:
      i = 0;
      break label47;
      label164:
      if (i != 0)
      {
        paramInt1 = (int)(rV() / rU() * j);
        paramInt2 = j;
      }
      else if (paramInt2 != 0)
      {
        paramInt2 = (int)(rU() / rV() * paramInt1);
      }
      else
      {
        label214:
        paramInt2 = j;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(157406);
    h("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(this.scale), this.aXY, Boolean.valueOf(this.aYb) });
    rK();
    PointF localPointF = getCenter();
    if (((this.aYz) || (this.aYb)) && (localPointF != null))
    {
      this.aYy = null;
      if (!this.aYb)
      {
        this.aXY = Float.valueOf(this.scale);
        this.aXZ = localPointF;
      }
    }
    AppMethodBeat.o(157406);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157409);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    ae.d(this.TAG, "alvinluo SubSamplingScaleImageView onTouchEvent: %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    if ((this.aYy != null) && (!this.aYy.aZy))
    {
      requestDisallowInterceptTouchEvent(true);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(157409);
      return true;
    }
    this.aYy = null;
    if (this.aXV == null)
    {
      if (this.aYn != null)
      {
        localObject = this.aYn;
        paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMotionEvent.ahE(), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.mt(0)), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(157409);
      return true;
    }
    if (!this.aYj) {
      if (this.aYl != null)
      {
        localObject = this.aYl;
        com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (!com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mt(0)), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z")) {}
      }
      else
      {
        this.aYh = false;
        this.aYi = false;
        this.aYk = 0;
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(157409);
        return true;
      }
    }
    if (this.aXW == null) {
      this.aXW = new PointF(0.0F, 0.0F);
    }
    if (this.aXX == null) {
      this.aXX = new PointF(0.0F, 0.0F);
    }
    if (this.aYq == null) {
      this.aYq = new PointF(0.0F, 0.0F);
    }
    this.aXX.set(this.aXV);
    int i = paramMotionEvent.getPointerCount();
    boolean bool1;
    label539:
    boolean bool2;
    label597:
    float f1;
    label769:
    float f3;
    float f4;
    float f5;
    double d;
    float f2;
    label1207:
    label1252:
    float f6;
    float f7;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
      c(this.aXX);
      bool2 = super.onTouchEvent(paramMotionEvent);
      ae.i(this.TAG, "alvinluo onTouchEvent super: %b, handled: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool1) || (bool2))
      {
        bool1 = true;
        com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(157409);
        return bool1;
      }
      break;
    case 0: 
    case 5: 
    case 261: 
      this.aZk = paramMotionEvent.getRawX();
      this.aZl = paramMotionEvent.getRawY();
      this.aYy = null;
      requestDisallowInterceptTouchEvent(true);
      this.aYk = Math.max(this.aYk, i);
      if (i >= 2) {
        if (this.aXO)
        {
          f1 = e(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
          this.aXU = this.scale;
          this.aYr = f1;
          this.aXW.set(this.aXV.x, this.aXV.y);
          this.aYq.set((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F, (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
          this.handler.removeMessages(1);
        }
      }
      for (;;)
      {
        bool1 = true;
        break;
        this.aYk = 0;
        break label769;
        if (!this.aYj)
        {
          this.aXW.set(this.aXV.x, this.aXV.y);
          this.aYq.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          ae.i(this.TAG, "pennqin, delay time 601 ms.");
          this.handler.sendEmptyMessageDelayed(1, 601L);
        }
      }
    case 2: 
      bool2 = false;
      bool1 = bool2;
      if (this.aYk > 0)
      {
        if (i < 2) {
          break label1588;
        }
        f3 = e(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
        f4 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
        f5 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
        this.aZd = new PointF(f4, f5);
        bool1 = bool2;
        if (this.aXO) {
          if ((e(this.aYq.x, f4, this.aYq.y, f5) <= 5.0F) && (Math.abs(f3 - this.aYr) <= 5.0F))
          {
            bool1 = bool2;
            if (!this.aYi) {}
          }
          else
          {
            this.aYh = true;
            this.aYi = true;
            d = this.scale;
            f2 = f3 / this.aYr * this.aXU;
            f1 = f2;
            if (f2 >= this.aXE * 2.0F)
            {
              f1 = this.aXE;
              f1 = (f2 - this.aXE) * 0.1F + f1 * 2.0F;
            }
            this.scale = f1;
            ae.i(this.TAG, "alvinluo zoom preScale: %f, scale: %f, minScale: %f, maxScale: %f", new Object[] { Double.valueOf(d), Float.valueOf(this.scale), Float.valueOf(rW()), Float.valueOf(this.aXE) });
            if (this.scale > rW()) {
              break label1252;
            }
            this.aYr = f3;
            this.aXU = rW();
            this.aYq.set(f4, f5);
            this.aXW.set(this.aXV);
          }
        }
      }
      for (;;)
      {
        aL(true);
        aK(this.aXM);
        bool1 = true;
        ae.d(this.TAG, "alvinluo Action_Move consumed: %b", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break;
        }
        this.handler.removeMessages(1);
        invalidate();
        bool1 = true;
        break label539;
        if (this.aXN)
        {
          f1 = this.aYq.x;
          f2 = this.aXW.x;
          f6 = this.aYq.y;
          f7 = this.aXW.y;
          float f8 = this.scale / this.aXU;
          float f9 = this.scale / this.aXU;
          this.aXV.x = (f4 - (f1 - f2) * f8);
          this.aXV.y = (f5 - (f6 - f7) * f9);
          if (((rV() * d < getHeight()) && (this.scale * rV() >= getHeight())) || ((d * rU() < getWidth()) && (this.scale * rU() >= getWidth())))
          {
            aL(true);
            this.aYq.set(f4, f5);
            this.aXW.set(this.aXV);
            this.aXU = this.scale;
            this.aYr = f3;
          }
        }
        else if (this.aYa != null)
        {
          this.aXV.x = (getWidth() / 2 - this.scale * this.aYa.x);
          this.aXV.y = (getHeight() / 2 - this.scale * this.aYa.y);
        }
        else
        {
          this.aXV.x = (getWidth() / 2 - this.scale * (rU() / 2));
          this.aXV.y = (getHeight() / 2 - this.scale * (rV() / 2));
        }
      }
      label1588:
      if (this.aYj)
      {
        f2 = Math.abs(this.aYx.y - paramMotionEvent.getY()) * 2.0F + this.aYs;
        if (this.aYt == -1.0F) {
          this.aYt = f2;
        }
        if (paramMotionEvent.getY() > this.aYv.y)
        {
          i = 1;
          label1654:
          this.aYv.set(0.0F, paramMotionEvent.getY());
          f3 = 0.5F * Math.abs(1.0F - f2 / this.aYt);
          if (f3 <= 0.03F)
          {
            f1 = f2;
            if (!this.aYu) {
              break;
            }
          }
          else
          {
            this.aYu = true;
            if (this.aYt <= 0.0F) {
              break label3060;
            }
            if (i == 0) {
              break label2014;
            }
            f1 = 1.0F + f3;
          }
        }
      }
      break;
    }
    for (;;)
    {
      label1729:
      d = this.scale;
      this.scale = Math.max(rW(), Math.min(this.aXE, f1 * this.scale));
      if (this.aXN)
      {
        f1 = this.aYq.x;
        f3 = this.aXW.x;
        f4 = this.aYq.y;
        f5 = this.aXW.y;
        f6 = this.scale / this.aXU;
        f7 = this.scale / this.aXU;
        this.aXV.x = (this.aYq.x - (f1 - f3) * f6);
        this.aXV.y = (this.aYq.y - (f4 - f5) * f7);
        if (((rV() * d >= getHeight()) || (this.scale * rV() < getHeight())) && ((rU() * d >= getWidth()) || (this.scale * rU() < getWidth()))) {
          break label3053;
        }
        aL(true);
        this.aYq.set(b(this.aYw));
        this.aXW.set(this.aXV);
        this.aXU = this.scale;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.aYt = f1;
        aL(true);
        aK(this.aXM);
        bool1 = true;
        break label1207;
        i = 0;
        break label1654;
        label2014:
        f1 = 1.0F - f3;
        break label1729;
        if (this.aYa != null)
        {
          this.aXV.x = (getWidth() / 2 - this.scale * this.aYa.x);
          this.aXV.y = (getHeight() / 2 - this.scale * this.aYa.y);
          f1 = f2;
        }
        else
        {
          this.aXV.x = (getWidth() / 2 - this.scale * (rU() / 2));
          this.aXV.y = (getHeight() / 2 - this.scale * (rV() / 2));
          f1 = f2;
          continue;
          bool1 = bool2;
          if (this.aYh) {
            break label1207;
          }
          f1 = Math.abs(paramMotionEvent.getX() - this.aYq.x);
          f2 = Math.abs(paramMotionEvent.getY() - this.aYq.y);
          f3 = this.density * 5.0F;
          if ((f1 <= f3) && (f2 <= f3))
          {
            bool1 = bool2;
            if (!this.aYi) {
              break label1207;
            }
          }
          this.aXV.x = (this.aXW.x + (paramMotionEvent.getX() - this.aYq.x));
          this.aXV.y = (this.aXW.y + (paramMotionEvent.getY() - this.aYq.y));
          f4 = this.aXV.x;
          f5 = this.aXV.y;
          aL(true);
          label2327:
          label2343:
          boolean bool3;
          label2366:
          boolean bool4;
          label2389:
          boolean bool5;
          if (f4 != this.aXV.x)
          {
            bool1 = true;
            if (f5 == this.aXV.y) {
              break label2606;
            }
            bool2 = true;
            if ((!bool1) || (f1 <= f2) || (this.aYi)) {
              break label2612;
            }
            bool3 = true;
            if ((!bool2) || (f2 <= f1) || (this.aYi)) {
              break label2618;
            }
            bool4 = true;
            if ((f5 != this.aXV.y) || (f2 <= 3.0F * f3)) {
              break label2624;
            }
            bool5 = true;
            label2417:
            ae.i(this.TAG, "alvinluo Action_Move edge atXEdge: %b, atYEdge: %b, edgeXSwipe: %b, edgeYSwipe: %b, yPan: %b, isPanning: %b,dx: %f, dy: %f, offset: %f", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(this.aYi), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
            if ((bool3) || (bool4) || ((bool1) && (bool2) && (!bool5) && (!this.aYi))) {
              break label2630;
            }
            this.aYi = true;
          }
          for (;;)
          {
            if (!this.aXN)
            {
              this.aXV.x = this.aXW.x;
              this.aXV.y = this.aXW.y;
              requestDisallowInterceptTouchEvent(false);
            }
            aK(this.aXM);
            bool1 = true;
            break;
            bool1 = false;
            break label2327;
            label2606:
            bool2 = false;
            break label2343;
            label2612:
            bool3 = false;
            break label2366;
            label2618:
            bool4 = false;
            break label2389;
            label2624:
            bool5 = false;
            break label2417;
            label2630:
            if ((f1 > f3) || (f2 > f3))
            {
              this.aYk = 0;
              this.handler.removeMessages(1);
              requestDisallowInterceptTouchEvent(false);
            }
          }
          this.handler.removeMessages(1);
          if (this.aYj)
          {
            this.aYj = false;
            if (!this.aYu) {
              a(this.aYw, this.aYq);
            }
          }
          if ((this.aYk > 0) && ((this.aYh) || (this.aYi)))
          {
            if ((this.aYh) && (i == 2))
            {
              this.aYi = true;
              this.aXW.set(this.aXV.x, this.aXV.y);
              if (paramMotionEvent.getActionIndex() != 1) {
                break label2915;
              }
              this.aYq.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
              label2791:
              if (this.scale > this.aYW) {
                break label2935;
              }
              ae.i(this.TAG, "alvinluo scale %f less than %f, and need to reset", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.aYW) });
              localObject = new PointF(this.aYS / 2, this.aYT / 2);
              a((PointF)localObject, (PointF)localObject, this.aYW);
              this.aYi = false;
            }
            for (;;)
            {
              if (i < 3) {
                this.aYh = false;
              }
              if (i < 2)
              {
                this.aYi = false;
                this.aYk = 0;
              }
              aK(true);
              bool1 = true;
              break;
              label2915:
              this.aYq.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
              break label2791;
              label2935:
              if (this.scale > getDoubleTapZoomScale() * 2.0F)
              {
                ae.i(this.TAG, "alvinluo current scale %f larger than maxScale: %f, and reset to scale: %f", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.aXE), Float.valueOf(getDoubleTapZoomScale() * 2.0F) });
                a(a(this.aZd), this.aZd, getDoubleTapZoomScale() * 2.0F);
              }
            }
          }
          if (i == 1)
          {
            this.aYh = false;
            this.aYi = false;
            this.aYk = 0;
          }
          bool1 = false;
          break;
          bool1 = false;
          break label597;
          label3053:
          f1 = f2;
        }
      }
      label3060:
      f1 = 1.0F;
    }
  }
  
  public final void setBitmapDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> paramClass)
  {
    AppMethodBeat.i(157447);
    if (paramClass == null)
    {
      paramClass = new IllegalArgumentException("Decoder class cannot be set to null");
      AppMethodBeat.o(157447);
      throw paramClass;
    }
    this.aYo = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
    AppMethodBeat.o(157447);
  }
  
  public final void setBitmapDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> paramb)
  {
    AppMethodBeat.i(157448);
    if (paramb == null)
    {
      paramb = new IllegalArgumentException("Decoder factory cannot be set to null");
      AppMethodBeat.o(157448);
      throw paramb;
    }
    this.aYo = paramb;
    AppMethodBeat.o(157448);
  }
  
  public final void setDebug(boolean paramBoolean)
  {
    this.aXD = paramBoolean;
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
    this.aXS = Math.max(0, paramInt);
    AppMethodBeat.o(157463);
  }
  
  public final void setDoubleTapZoomScale(float paramFloat)
  {
    this.aXQ = paramFloat;
  }
  
  public final void setDoubleTapZoomStyle(int paramInt)
  {
    AppMethodBeat.i(157462);
    if (!aXl.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid zoom style: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157462);
      throw localIllegalArgumentException;
    }
    this.aXR = paramInt;
    AppMethodBeat.o(157462);
  }
  
  public void setEagerLoadingEnabled(boolean paramBoolean)
  {
    this.aXM = paramBoolean;
  }
  
  public void setEdgeSwipeListener(c paramc)
  {
    this.aZg = paramc;
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
    this.aYm = paramSimpleOnGestureListener;
  }
  
  public final void setImage(a parama)
  {
    AppMethodBeat.i(157402);
    a(parama, null);
    AppMethodBeat.o(157402);
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(157401);
    Matrix localMatrix = paramMatrix;
    if (paramMatrix != null)
    {
      localMatrix = paramMatrix;
      if (paramMatrix.isIdentity()) {
        localMatrix = null;
      }
    }
    if (((localMatrix == null) && (!this.aYM.isIdentity())) || ((localMatrix != null) && (!this.aYM.equals(localMatrix))))
    {
      this.aYM.set(localMatrix);
      invalidate();
    }
    AppMethodBeat.o(157401);
  }
  
  public final void setMaxScale(float paramFloat)
  {
    this.aXE = paramFloat;
  }
  
  public void setMaxTileSize(int paramInt)
  {
    this.aXK = paramInt;
    this.aXL = paramInt;
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
    this.aXF = paramFloat;
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
    if (!aXo.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid scale type: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157450);
      throw localIllegalArgumentException;
    }
    this.aXI = paramInt;
    if (this.aYz)
    {
      aL(true);
      invalidate();
    }
    AppMethodBeat.o(157450);
  }
  
  public void setMinimumTileDpi(int paramInt)
  {
    AppMethodBeat.i(157454);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    this.aXG = ((int)Math.min((localDisplayMetrics.ydpi + f) / 2.0F, paramInt));
    if (this.aYz)
    {
      reset(false);
      invalidate();
    }
    AppMethodBeat.o(157454);
  }
  
  public void setOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.aZe = paramOnAttachStateChangeListener;
  }
  
  public void setOnImageEventListener(e parame)
  {
    this.aYB = parame;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.aYD = paramOnLongClickListener;
  }
  
  public void setOnStateChangedListener(f paramf)
  {
    this.aYC = paramf;
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(157396);
    if (!aXk.contains(Integer.valueOf(paramInt)))
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
    this.aXN = paramBoolean;
    if ((!paramBoolean) && (this.aXV != null))
    {
      this.aXV.x = (getWidth() / 2 - this.scale * (rU() / 2));
      this.aXV.y = (getHeight() / 2 - this.scale * (rV() / 2));
      if (this.aYz)
      {
        aK(true);
        invalidate();
      }
    }
    AppMethodBeat.o(157459);
  }
  
  public final void setPanLimit(int paramInt)
  {
    AppMethodBeat.i(157449);
    if (!aXn.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid pan limit: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157449);
      throw localIllegalArgumentException;
    }
    this.aXH = paramInt;
    if (this.aYz)
    {
      aL(true);
      invalidate();
    }
    AppMethodBeat.o(157449);
  }
  
  public void setPreviewDone(boolean paramBoolean)
  {
    AppMethodBeat.i(157395);
    this.aZb = paramBoolean;
    invalidate();
    AppMethodBeat.o(157395);
  }
  
  public final void setQuickScaleEnabled(boolean paramBoolean)
  {
    this.aXP = paramBoolean;
  }
  
  public final void setRegionDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> paramClass)
  {
    AppMethodBeat.i(157445);
    if (paramClass == null)
    {
      paramClass = new IllegalArgumentException("Decoder class cannot be set to null");
      AppMethodBeat.o(157445);
      throw paramClass;
    }
    this.aYp = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
    AppMethodBeat.o(157445);
  }
  
  public final void setRegionDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> paramb)
  {
    AppMethodBeat.i(157446);
    if (paramb == null)
    {
      paramb = new IllegalArgumentException("Decoder factory cannot be set to null");
      AppMethodBeat.o(157446);
      throw paramb;
    }
    this.aYp = paramb;
    AppMethodBeat.o(157446);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(157397);
    this.aYW = paramFloat;
    this.aXE = 2.0F;
    this.aXF = 1.0F;
    rM();
    rN();
    AppMethodBeat.o(157397);
  }
  
  public final void setTileBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(157460);
    if (Color.alpha(paramInt) == 0) {
      this.aYH = null;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(157460);
      return;
      this.aYH = new Paint();
      this.aYH.setStyle(Paint.Style.FILL);
      this.aYH.setColor(paramInt);
    }
  }
  
  public final void setZoomEnabled(boolean paramBoolean)
  {
    this.aXO = paramBoolean;
  }
  
  public void setsRegion(Rect paramRect)
  {
    this.aXi = paramRect;
  }
  
  static final class a
  {
    float aXU;
    int aZA;
    SubsamplingScaleImageView.d aZB;
    float aZs;
    PointF aZt;
    PointF aZu;
    PointF aZv;
    PointF aZw;
    PointF aZx;
    boolean aZy;
    int aZz;
    long duration;
    long time;
    
    private a()
    {
      AppMethodBeat.i(157385);
      this.duration = 200L;
      this.aZy = true;
      this.aZz = 2;
      this.aZA = 1;
      this.time = System.currentTimeMillis();
      AppMethodBeat.o(157385);
    }
  }
  
  public final class b
  {
    int aZA;
    private SubsamplingScaleImageView.d aZB;
    private final float aZC;
    private final PointF aZD;
    private final PointF aZE;
    boolean aZF;
    boolean aZy;
    int aZz;
    long duration;
    
    private b(float paramFloat, PointF paramPointF)
    {
      this.duration = 500L;
      this.aZz = 2;
      this.aZA = 1;
      this.aZy = true;
      this.aZF = true;
      this.aZC = paramFloat;
      this.aZD = paramPointF;
      this.aZE = null;
    }
    
    private b(float paramFloat, PointF paramPointF1, PointF paramPointF2)
    {
      this.duration = 500L;
      this.aZz = 2;
      this.aZA = 1;
      this.aZy = true;
      this.aZF = true;
      this.aZC = paramFloat;
      this.aZD = paramPointF1;
      this.aZE = paramPointF2;
    }
    
    private b(PointF paramPointF)
    {
      AppMethodBeat.i(157386);
      this.duration = 500L;
      this.aZz = 2;
      this.aZA = 1;
      this.aZy = true;
      this.aZF = true;
      this.aZC = SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
      this.aZD = paramPointF;
      this.aZE = null;
      AppMethodBeat.o(157386);
    }
    
    public final void start()
    {
      AppMethodBeat.i(157387);
      if ((SubsamplingScaleImageView.w(SubsamplingScaleImageView.this) != null) && (SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZB != null)) {}
      try
      {
        SubsamplingScaleImageView.w(SubsamplingScaleImageView.this);
        int i = SubsamplingScaleImageView.this.getPaddingLeft();
        int j = (SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight() - SubsamplingScaleImageView.this.getPaddingLeft()) / 2;
        int k = SubsamplingScaleImageView.this.getPaddingTop();
        int m = (SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom() - SubsamplingScaleImageView.this.getPaddingTop()) / 2;
        float f3 = SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, this.aZC);
        if (this.aZF)
        {
          Object localObject = SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, this.aZD.x, this.aZD.y, f3, new PointF());
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, new SubsamplingScaleImageView.a((byte)0));
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aXU = SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZs = f3;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).time = System.currentTimeMillis();
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZv = ((PointF)localObject);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZt = SubsamplingScaleImageView.this.getCenter();
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZu = ((PointF)localObject);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZw = SubsamplingScaleImageView.this.b((PointF)localObject);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZx = new PointF(j + i, m + k);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).duration = this.duration;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZy = this.aZy;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZz = this.aZz;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZA = this.aZA;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).time = System.currentTimeMillis();
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZB = this.aZB;
          if (this.aZE != null)
          {
            float f1 = this.aZE.x - SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZt.x * f3;
            float f2 = this.aZE.y - SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aZt.y * f3;
            localObject = new SubsamplingScaleImageView.g(f3, new PointF(f1, f2), (byte)0);
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, (SubsamplingScaleImageView.g)localObject);
            SubsamplingScaleImageView.a locala = SubsamplingScaleImageView.w(SubsamplingScaleImageView.this);
            f3 = this.aZE.x;
            float f4 = ((SubsamplingScaleImageView.g)localObject).aXV.x;
            float f5 = this.aZE.y;
            locala.aZx = new PointF(f4 - f1 + f3, ((SubsamplingScaleImageView.g)localObject).aXV.y - f2 + f5);
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
          ae.w(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "Error thrown by animation listener", new Object[] { localException });
          continue;
          PointF localPointF = this.aZD;
        }
      }
    }
  }
  
  public static abstract interface c {}
  
  public static abstract interface d {}
  
  public static abstract interface e
  {
    public abstract void a(com.davemorrissey.labs.subscaleview.a.c paramc);
    
    public abstract void b(com.davemorrissey.labs.subscaleview.a.c paramc);
    
    public abstract void c(com.davemorrissey.labs.subscaleview.a.c paramc);
    
    public abstract void n(Bitmap paramBitmap);
    
    public abstract void rY();
    
    public abstract void rZ();
  }
  
  public static abstract interface f {}
  
  static final class g
  {
    PointF aXV;
    float scale;
    
    private g(float paramFloat, PointF paramPointF)
    {
      this.scale = paramFloat;
      this.aXV = paramPointF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView
 * JD-Core Version:    0.7.0.1
 */