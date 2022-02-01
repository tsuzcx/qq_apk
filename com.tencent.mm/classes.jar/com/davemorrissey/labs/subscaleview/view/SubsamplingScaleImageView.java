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
import com.davemorrissey.labs.subscaleview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static final List<Integer> aXb;
  private static final List<Integer> aXc;
  private static final List<Integer> aXd;
  private static final List<Integer> aXe;
  private static final List<Integer> aXf;
  public static int aXy;
  private static Bitmap.Config aYI;
  private static com.davemorrissey.labs.subscaleview.c.a aYJ;
  private static com.davemorrissey.labs.subscaleview.c.d aYK;
  private static com.davemorrissey.labs.subscaleview.c.c aYL;
  public final String TAG;
  private final ReadWriteLock aWE;
  private com.davemorrissey.labs.subscaleview.a.d aWL;
  public int aWX;
  public int aWY;
  private Rect aWZ;
  private int aXA;
  private boolean aXB;
  private boolean aXC;
  private boolean aXD;
  private boolean aXE;
  private float aXF;
  private int aXG;
  public int aXH;
  private int aXI;
  private GestureDetector.OnDoubleTapListener aXJ;
  private boolean aXK;
  private boolean aXL;
  private MotionEvent aXM;
  private float aXN;
  public PointF aXO;
  private PointF aXP;
  private PointF aXQ;
  private float[] aXR;
  private float aXS;
  private Float aXT;
  private PointF aXU;
  private PointF aXV;
  private boolean aXW;
  private a aXX;
  private a aXY;
  private int aXZ;
  private boolean aXg;
  private boolean aXh;
  private boolean aXi;
  private boolean aXj;
  private int aXk;
  private boolean aXl;
  private long aXm;
  private long aXn;
  private Bitmap aXo;
  private boolean aXp;
  private boolean aXq;
  private Map<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> aXr;
  private boolean aXs;
  private float aXt;
  private float aXu;
  private int aXv;
  private int aXw;
  private int aXx;
  private int aXz;
  private Paint aYA;
  private Paint aYB;
  private Paint aYC;
  private g aYD;
  private RectF aYE;
  private float[] aYF;
  private float[] aYG;
  private Matrix aYH;
  private LinkedList<com.davemorrissey.labs.subscaleview.c.b> aYM;
  private int aYN;
  private int aYO;
  private float aYP;
  private float aYQ;
  public float aYR;
  private float aYS;
  private float aYT;
  private float aYU;
  private float aYV;
  private boolean aYW;
  private boolean aYX;
  private PointF aYY;
  private View.OnAttachStateChangeListener aYZ;
  private int aYa;
  private Rect aYb;
  private boolean aYc;
  private boolean aYd;
  private boolean aYe;
  private int aYf;
  private GestureDetector aYg;
  private GestureDetector.SimpleOnGestureListener aYh;
  private GestureDetector aYi;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aYj;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aYk;
  private PointF aYl;
  private float aYm;
  private final float aYn;
  private float aYo;
  private boolean aYp;
  private PointF aYq;
  private PointF aYr;
  private PointF aYs;
  private a aYt;
  private boolean aYu;
  private boolean aYv;
  private e aYw;
  private SubsamplingScaleImageView.f aYx;
  private View.OnLongClickListener aYy;
  private Paint aYz;
  public View.OnTouchListener aZa;
  private com.davemorrissey.labs.subscaleview.d.a aZb;
  private c aZc;
  private boolean aZd;
  private boolean aZe;
  private boolean aZf;
  private float aZg;
  private float aZh;
  private Bitmap bitmap;
  private boolean cancelled;
  private float density;
  public Executor executor;
  private Matrix gT;
  private Handler handler;
  private int orientation;
  private int previewHeight;
  private int previewWidth;
  public float scale;
  private Uri uri;
  
  static
  {
    AppMethodBeat.i(157473);
    aXb = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1) });
    aXc = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    aXd = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
    aXe = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    aXf = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4) });
    aXy = 2147483647;
    aYI = Bitmap.Config.ARGB_8888;
    aYJ = new com.davemorrissey.labs.subscaleview.b.a();
    aYK = new com.davemorrissey.labs.subscaleview.b.c();
    aYL = new com.davemorrissey.labs.subscaleview.b.b();
    AppMethodBeat.o(157473);
  }
  
  public SubsamplingScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(157394);
    this.TAG = (SubsamplingScaleImageView.class.getSimpleName() + hashCode());
    this.aXl = true;
    this.aXm = -1L;
    this.aXn = -1L;
    this.aXp = false;
    this.aXq = false;
    this.aXs = false;
    this.orientation = -1;
    this.aXt = 2.0F;
    this.aXu = rZ();
    this.aXv = -1;
    this.aXw = 1;
    this.aXx = 3;
    this.aXz = aXy;
    this.aXA = aXy;
    this.aXB = true;
    this.aXC = true;
    this.aXD = true;
    this.aXE = true;
    this.aXF = 2.0F;
    this.aXG = 1;
    this.aXH = 200;
    this.aXI = 200;
    this.aXJ = null;
    this.aXK = true;
    this.aXL = false;
    this.aXM = null;
    this.aXR = new float[9];
    this.aXS = 0.0F;
    this.aYa = 0;
    this.aWE = new ReentrantReadWriteLock(true);
    this.aYj = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.aYk = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.aYF = new float[8];
    this.aYG = new float[8];
    this.aYM = new LinkedList();
    this.cancelled = false;
    this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
    this.aYU = 1.0F;
    this.aYV = 20.0F;
    this.aYW = true;
    this.aYX = false;
    this.aZb = new com.davemorrissey.labs.subscaleview.d.a();
    this.aZc = new c() {};
    this.aZd = false;
    this.aZe = false;
    this.aZf = false;
    this.density = getResources().getDisplayMetrics().density;
    setDoubleTapZoomScale(2.0F);
    setMinimumTileDpi(320);
    setGestureDetector(paramContext);
    this.aYH = new Matrix();
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
          setImage(a.aP("assets:///".concat(String.valueOf(str))).rM());
        }
      }
      if (paramAttributeSet.hasValue(3))
      {
        int i = paramAttributeSet.getResourceId(3, 0);
        if (i > 0) {
          setImage(new a(i).rM());
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
    this.aYn = TypedValue.applyDimension(1, 20.0F, paramContext.getResources().getDisplayMetrics());
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aYU = f;
    }
    AppMethodBeat.o(157394);
  }
  
  private int V(float paramFloat)
  {
    AppMethodBeat.i(157420);
    float f = paramFloat;
    if (this.aXv > 0)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      f = localDisplayMetrics.xdpi;
      f = (localDisplayMetrics.ydpi + f) / 2.0F;
      f = paramFloat * (this.aXv / f);
    }
    int j = (int)(rX() * f);
    int i = (int)(rY() * f);
    if ((j == 0) || (i == 0))
    {
      AppMethodBeat.o(157420);
      return 32;
    }
    if ((rY() > i) || (rX() > j))
    {
      i = Math.round(rY() / i);
      j = Math.round(rX() / j);
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
    if (this.aXO == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.aXO.x) / this.scale;
  }
  
  private float X(float paramFloat)
  {
    if (this.aXO == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.aXO.y) / this.scale;
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
    if (this.aXO == null)
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
      this.aYD = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      a(true, this.aYD);
      this.aXk = V(this.aYD.scale);
      b(paramPoint);
      paramPoint = ((List)this.aXr.get(Integer.valueOf(this.aXk))).iterator();
      while (paramPoint.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)paramPoint.next();
        Log.i(this.TAG, "alvinluo tile fullSampleSize: %d", new Object[] { Integer.valueOf(this.aXk) });
        a(locale);
      }
      aJ(true);
    }
    finally {}
    AppMethodBeat.o(157417);
  }
  
  private void a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    AppMethodBeat.i(157412);
    paramPointF1 = new b(paramFloat, paramPointF1, paramPointF2, (byte)0);
    paramPointF1.aZu = false;
    paramPointF1.duration = this.aXI;
    paramPointF1.aZw = 2;
    paramPointF1.start();
    AppMethodBeat.o(157412);
  }
  
  private void a(com.davemorrissey.labs.subscaleview.c.e parame)
  {
    AppMethodBeat.i(157393);
    if (this.cancelled)
    {
      Log.i(this.TAG, "alvinluo newLoadTask, has cancelled and ignore");
      AppMethodBeat.o(157393);
      return;
    }
    parame = aYK.a(this, this.aWL, parame);
    parame.rJ();
    this.aYM.add(parame);
    AppMethodBeat.o(157393);
  }
  
  private void a(boolean paramBoolean, g paramg)
  {
    float f2 = 0.5F;
    AppMethodBeat.i(157421);
    boolean bool = paramBoolean;
    if (this.aXw == 2)
    {
      bool = paramBoolean;
      if (this.aYu) {
        bool = false;
      }
    }
    PointF localPointF = paramg.aXO;
    float f4 = aa(paramg.scale);
    float f3 = f4 * rX();
    float f5 = f4 * rY();
    float f1;
    if ((this.aXw == 3) && (this.aYu))
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
      if ((this.aXw != 3) || (!this.aYu)) {
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
  
  private void aJ(boolean paramBoolean)
  {
    AppMethodBeat.i(157418);
    if ((this.aWL == null) || (this.aXr == null))
    {
      AppMethodBeat.o(157418);
      return;
    }
    int j = Math.min(this.aXk, V(this.scale));
    Iterator localIterator1 = this.aXr.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)localIterator2.next();
        if ((locale.sampleSize < j) || ((locale.sampleSize > j) && (locale.sampleSize != this.aXk)))
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
          if ((f1 <= locale.aWO.right) && (locale.aWO.left <= f2) && (f3 <= locale.aWO.bottom) && (locale.aWO.top <= f4)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label328;
            }
            locale.visible = true;
            if ((locale.aWP) || (locale.bitmap != null) || (!paramBoolean)) {
              break;
            }
            a(locale);
            break;
          }
          label328:
          if (locale.sampleSize != this.aXk)
          {
            locale.visible = false;
            if (locale.bitmap != null)
            {
              locale.bitmap.recycle();
              locale.bitmap = null;
            }
          }
        }
        else if (locale.sampleSize == this.aXk)
        {
          locale.visible = true;
        }
      }
    }
    AppMethodBeat.o(157418);
  }
  
  private void aK(boolean paramBoolean)
  {
    AppMethodBeat.i(157422);
    int i;
    if (this.aXO == null)
    {
      i = 1;
      this.aXO = new PointF(0.0F, 0.0F);
    }
    for (;;)
    {
      if (this.aYD == null) {
        this.aYD = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      }
      this.aYD.scale = this.scale;
      this.aYD.aXO.set(this.aXO);
      a(paramBoolean, this.aYD);
      this.scale = this.aYD.scale;
      this.aXO.set(this.aYD.aXO);
      if ((i != 0) && (this.aXx != 4)) {
        this.aXO.set(j(rX() / 2, rY() / 2, this.scale));
      }
      AppMethodBeat.o(157422);
      return;
      i = 0;
    }
  }
  
  private float aa(float paramFloat)
  {
    AppMethodBeat.i(157442);
    paramFloat = Math.max(rZ(), paramFloat);
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
    if (this.aXO == null)
    {
      AppMethodBeat.o(157439);
      return null;
    }
    paramPointF.set(Y(paramFloat1), Z(paramFloat2));
    AppMethodBeat.o(157439);
    return paramPointF;
  }
  
  private void b(float paramFloat, PointF paramPointF)
  {
    AppMethodBeat.i(208727);
    Log.i(this.TAG, "alvinluo sendStateChanged oldScale: %s, %s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.scale) });
    if ((this.aYx != null) && (this.scale != paramFloat)) {
      this.aYx.r(this.scale, paramFloat);
    }
    if ((this.aYx != null) && (!this.aXO.equals(paramPointF))) {
      getCenter();
    }
    AppMethodBeat.o(208727);
  }
  
  private void b(Point paramPoint)
  {
    AppMethodBeat.i(157423);
    h("initialiseTileMap maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
    this.aXr = new LinkedHashMap();
    int i = this.aXk;
    int j = 1;
    int m = 1;
    int k = rX() / j;
    int i2 = rY() / m;
    int n = k / i;
    int i1 = i2 / i;
    while ((n + j + 1 > paramPoint.x) || ((n > getWidth() * 1.25D) && (i < this.aXk)))
    {
      j += 1;
      k = rX() / j;
      n = k / i;
    }
    for (;;)
    {
      if ((i1 + m + 1 > paramPoint.y) || ((i1 > getHeight() * 1.25D) && (i < this.aXk)))
      {
        m += 1;
        n = rY() / m;
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
            if (i == this.aXk)
            {
              bool = true;
              locale.visible = bool;
              if (i1 != j - 1) {
                break label385;
              }
              i3 = rX();
              label286:
              if (i2 != m - 1) {
                break label397;
              }
            }
            label385:
            label397:
            for (int i4 = rY();; i4 = (i2 + 1) * n)
            {
              locale.aWO = new Rect(i1 * k, i2 * n, i3, i4);
              locale.aWQ = new Rect(0, 0, 0, 0);
              locale.aWR = new Rect(locale.aWO);
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
        this.aXr.put(Integer.valueOf(i), localArrayList);
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
    float f1 = this.aYR;
    if (this.aYP * 0.7F > f1) {
      f1 = this.aYP;
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 < 1.0D) {
        f2 = 1.0F;
      }
      f1 = f2;
      if (f2 > this.aXt) {
        f1 = this.aXt;
      }
      return f1;
      if (this.aYQ * 0.7F > f1) {
        f1 = this.aYQ;
      } else {
        f1 = this.aYR * this.aXF;
      }
    }
  }
  
  public static Bitmap.Config getPreferredBitmapConfig()
  {
    return aYI;
  }
  
  private PointF j(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(157440);
    int i = getPaddingLeft();
    int j = (getWidth() - getPaddingRight() - getPaddingLeft()) / 2;
    int k = getPaddingTop();
    int m = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2;
    if (this.aYD == null) {
      this.aYD = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
    }
    this.aYD.scale = paramFloat3;
    this.aYD.aXO.set(i + j - paramFloat1 * paramFloat3, k + m - paramFloat2 * paramFloat3);
    a(true, this.aYD);
    PointF localPointF = this.aYD.aXO;
    AppMethodBeat.o(157440);
    return localPointF;
  }
  
  private int px(int paramInt)
  {
    return (int)(this.density * paramInt);
  }
  
  private void rN()
  {
    AppMethodBeat.i(157398);
    Log.i(this.TAG, "alvinluo initScaleRate: %f", new Object[] { Float.valueOf(this.aYR) });
    rP();
    rQ();
    AppMethodBeat.o(157398);
  }
  
  private void rO()
  {
    AppMethodBeat.i(208723);
    if (this.bitmap == null)
    {
      AppMethodBeat.o(208723);
      return;
    }
    if (!this.aXg)
    {
      AppMethodBeat.o(208723);
      return;
    }
    int i = rX();
    int j = rY();
    boolean bool;
    if (i > j * 2.2F)
    {
      bool = true;
      this.aXq = bool;
      if (j <= i * 2.2F) {
        break label272;
      }
      bool = true;
      label77:
      this.aXp = bool;
      if ((!this.aXq) || (i <= this.aYN)) {
        break label277;
      }
      bool = true;
      label99:
      this.aXq = bool;
      if ((!this.aXp) || (j <= this.aYO)) {
        break label282;
      }
      bool = true;
      label121:
      this.aXp = bool;
      rN();
      if (!this.aXp) {
        break label287;
      }
      this.aYS = (this.aYN * 1.0F / rV());
      this.aYT = (this.aYO * 1.0F / rW());
    }
    for (;;)
    {
      Log.i(this.TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f, previewHeight: %d, previewWidth: %d, verticalLong: %b, horizontalLong: %b, %s", new Object[] { Float.valueOf(this.aYS), Float.valueOf(this.aYT), Integer.valueOf(rW()), Integer.valueOf(rV()), Boolean.valueOf(this.aXp), Boolean.valueOf(this.aXq), this.aXX.getUri().toString() });
      AppMethodBeat.o(208723);
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
      if (this.aXq)
      {
        this.aYS = (this.aYN * 1.0F / rV());
        this.aYT = (this.aYR * rY() / rW());
      }
      else
      {
        this.aYS = (this.aYR * rX() / rV());
        this.aYT = (this.aYR * rY() / rW());
      }
    }
  }
  
  private void rP()
  {
    AppMethodBeat.i(157399);
    this.aXt = (getDoubleTapZoomScale() * 2.0F * this.aYU);
    AppMethodBeat.o(157399);
  }
  
  private void rQ()
  {
    AppMethodBeat.i(157400);
    this.aXu = Math.min(rZ(), this.aYR * 0.75F);
    AppMethodBeat.o(157400);
  }
  
  private boolean rR()
  {
    AppMethodBeat.i(157414);
    if ((this.bitmap != null) && (!this.aXg))
    {
      AppMethodBeat.o(157414);
      return true;
    }
    if (this.aXr != null)
    {
      Iterator localIterator = this.aXr.entrySet().iterator();
      boolean bool2;
      for (boolean bool1 = true; localIterator.hasNext(); bool1 = bool2)
      {
        Object localObject = (Map.Entry)localIterator.next();
        bool2 = bool1;
        if (((Integer)((Map.Entry)localObject).getKey()).intValue() == this.aXk)
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject).next();
            if ((locale.aWP) || (locale.bitmap == null)) {
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
  
  private boolean rS()
  {
    AppMethodBeat.i(157415);
    if ((getWidth() > 0) && (getHeight() > 0) && (this.aWX > 0) && (this.aWY > 0) && ((this.bitmap != null) || (rR()))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.aYu) && (bool))
      {
        rU();
        this.aYu = true;
      }
      AppMethodBeat.o(157415);
      return bool;
    }
  }
  
  private boolean rT()
  {
    AppMethodBeat.i(157416);
    boolean bool = rR();
    if ((!this.aYv) && (bool))
    {
      rU();
      this.aYv = true;
      Log.i(this.TAG, "alvinluo onImageLoaded");
      rN();
      a(this.aYR, new PointF(0.0F, 0.0F));
      if (this.aXm != -1L)
      {
        this.aXn = System.currentTimeMillis();
        dz((int)(this.aXn - this.aXm));
      }
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(157384);
          if ((SubsamplingScaleImageView.v(SubsamplingScaleImageView.this) != null) && (!SubsamplingScaleImageView.v(SubsamplingScaleImageView.this).isRecycled()))
          {
            Log.i(SubsamplingScaleImageView.m(SubsamplingScaleImageView.this), "alvinluo rotateAndScale fullImageBitmap");
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(SubsamplingScaleImageView.v(SubsamplingScaleImageView.this), SubsamplingScaleImageView.u(SubsamplingScaleImageView.this)));
          }
          SubsamplingScaleImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157383);
              if (SubsamplingScaleImageView.w(SubsamplingScaleImageView.this) != null) {
                SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).n(SubsamplingScaleImageView.v(SubsamplingScaleImageView.this));
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
  
  private void rU()
  {
    AppMethodBeat.i(157419);
    if ((getWidth() == 0) || (getHeight() == 0) || (this.aWX <= 0) || (this.aWY <= 0))
    {
      AppMethodBeat.o(157419);
      return;
    }
    if ((this.aXU != null) && (this.aXT != null))
    {
      this.scale = this.aXT.floatValue();
      if (this.aXO == null) {
        this.aXO = new PointF();
      }
      this.aXO.x = (getWidth() / 2 - this.scale * this.aXU.x);
      this.aXO.y = (getHeight() / 2 - this.scale * this.aXU.y);
      this.aXU = null;
      this.aXT = null;
      this.aXW = false;
      aK(true);
      aJ(true);
    }
    aK(false);
    AppMethodBeat.o(157419);
  }
  
  private int rV()
  {
    AppMethodBeat.i(157431);
    if ((this.bitmap == null) || (!this.aXg))
    {
      AppMethodBeat.o(157431);
      return 0;
    }
    int i = this.aYa;
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
  
  private int rW()
  {
    AppMethodBeat.i(157432);
    if ((this.bitmap == null) || (!this.aXg))
    {
      AppMethodBeat.o(157432);
      return 0;
    }
    int i = this.aYa;
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
  
  private int rX()
  {
    AppMethodBeat.i(157433);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.aWY;
      AppMethodBeat.o(157433);
      return i;
    }
    i = this.aWX;
    AppMethodBeat.o(157433);
    return i;
  }
  
  private int rY()
  {
    AppMethodBeat.i(157434);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.aWX;
      AppMethodBeat.o(157434);
      return i;
    }
    i = this.aWY;
    AppMethodBeat.o(157434);
    return i;
  }
  
  private float rZ()
  {
    AppMethodBeat.i(157441);
    int i = getPaddingBottom() + getPaddingTop();
    int j = getPaddingLeft() + getPaddingRight();
    if ((this.aXx == 2) || (this.aXx == 4))
    {
      f = Math.max((getWidth() - j) / rX(), (getHeight() - i) / rY());
      AppMethodBeat.o(157441);
      return f;
    }
    if ((this.aXx == 3) && (this.aXu > 0.0F))
    {
      f = this.aXu;
      AppMethodBeat.o(157441);
      return f;
    }
    float f = Math.min((getWidth() - j) / rX(), (getHeight() - i) / rY());
    AppMethodBeat.o(157441);
    return f;
  }
  
  private void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(157410);
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
    {
      Log.i(this.TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b, allowInterceptTouch: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aXK) });
      if (!this.aXK)
      {
        this.aXL = true;
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
    h("reset newImage=".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.scale = 0.0F;
    this.aXN = 0.0F;
    this.aXO = null;
    this.aXP = null;
    this.aXQ = null;
    this.aXT = Float.valueOf(0.0F);
    this.aXU = null;
    this.aXV = null;
    this.aYc = false;
    this.aYd = false;
    this.aYe = false;
    this.aYf = 0;
    this.aXk = 0;
    this.aYl = null;
    this.aYm = 0.0F;
    this.aYo = 0.0F;
    this.aYp = false;
    this.aYr = null;
    this.aYq = null;
    this.aYs = null;
    this.aYt = null;
    this.aYD = null;
    this.gT = null;
    this.aYE = null;
    Object localObject1;
    if (paramBoolean)
    {
      if (this.aZb != null)
      {
        localObject1 = this.aZb;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aWU = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aWS = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aWU = 0;
      }
      this.uri = null;
      this.aWE.writeLock().lock();
    }
    com.davemorrissey.labs.subscaleview.c.e locale;
    label512:
    try
    {
      if (this.aWL != null)
      {
        this.aWL.recycle();
        this.aWL = null;
      }
      this.aWE.writeLock().unlock();
      if ((this.bitmap != null) && (!this.aXj)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aXj) && (this.aYw != null)) {
        this.aYw.sc();
      }
      this.aWX = 0;
      this.aWY = 0;
      this.aXZ = 0;
      this.aWZ = null;
      this.aYb = null;
      this.aYu = false;
      this.aYv = false;
      this.bitmap = null;
      this.aXg = false;
      this.aXj = false;
      this.aXh = false;
      this.aXi = false;
      this.aXl = true;
      if (this.aXr == null) {
        break label534;
      }
      localObject1 = this.aXr.entrySet().iterator();
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
            if (this.aXY == null) {
              break label489;
            }
            if (this.aXY.bitmap != locale.bitmap) {
              break label512;
            }
            Log.i(this.TAG, "alvinluo reset tile bitmap not need to recycle: %d", new Object[] { Integer.valueOf(locale.bitmap.hashCode()) });
          }
        }
      }
    }
    finally
    {
      label489:
      this.aWE.writeLock().unlock();
      AppMethodBeat.o(157404);
    }
    label529:
    this.aXr = null;
    label534:
    setGestureDetector(getContext());
    AppMethodBeat.o(157404);
  }
  
  public static void setBitmapLoaderImp(com.davemorrissey.labs.subscaleview.c.a parama)
  {
    aYJ = parama;
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
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(paramBitmap, SubsamplingScaleImageView.u(SubsamplingScaleImageView.this)));
          long l2 = System.currentTimeMillis();
          Log.i(SubsamplingScaleImageView.m(SubsamplingScaleImageView.this), "alvinluo rotate and scale fullImageBitmap cost: %d", new Object[] { Long.valueOf(l2 - l1) });
        }
        AppMethodBeat.o(157380);
      }
    }, "rotateAndScaleBitmap");
    AppMethodBeat.o(157425);
  }
  
  private void setGestureDetector(final Context paramContext)
  {
    AppMethodBeat.i(157405);
    this.aYg = new GestureDetector(paramContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(208716);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(208716);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157378);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        if ((SubsamplingScaleImageView.j(SubsamplingScaleImageView.this) != null) && (SubsamplingScaleImageView.j(SubsamplingScaleImageView.this).onDoubleTap(paramAnonymousMotionEvent)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(157378);
          return true;
        }
        if ((SubsamplingScaleImageView.l(SubsamplingScaleImageView.this)) && (SubsamplingScaleImageView.f(SubsamplingScaleImageView.this)) && (SubsamplingScaleImageView.g(SubsamplingScaleImageView.this) != null))
        {
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, paramContext);
          Log.i(SubsamplingScaleImageView.m(SubsamplingScaleImageView.this), "alvinluo onDoubleTap, quickScaledEnabled: %b", new Object[] { Boolean.valueOf(SubsamplingScaleImageView.n(SubsamplingScaleImageView.this)) });
          if (SubsamplingScaleImageView.n(SubsamplingScaleImageView.this))
          {
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()));
            SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, new PointF(SubsamplingScaleImageView.g(SubsamplingScaleImageView.this).x, SubsamplingScaleImageView.g(SubsamplingScaleImageView.this).y));
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.i(SubsamplingScaleImageView.this));
            SubsamplingScaleImageView.o(SubsamplingScaleImageView.this);
            SubsamplingScaleImageView.p(SubsamplingScaleImageView.this);
            SubsamplingScaleImageView.q(SubsamplingScaleImageView.this);
            SubsamplingScaleImageView.c(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(SubsamplingScaleImageView.r(SubsamplingScaleImageView.this)));
            SubsamplingScaleImageView.d(SubsamplingScaleImageView.this, new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()));
            SubsamplingScaleImageView.e(SubsamplingScaleImageView.this, new PointF(SubsamplingScaleImageView.s(SubsamplingScaleImageView.this).x, SubsamplingScaleImageView.s(SubsamplingScaleImageView.this).y));
            SubsamplingScaleImageView.t(SubsamplingScaleImageView.this);
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
          if (!SubsamplingScaleImageView.sa().contains(Integer.valueOf(1)))
          {
            paramAnonymousMotionEvent1 = new IllegalArgumentException("Unknown easing type: 1");
            AppMethodBeat.o(157376);
            throw paramAnonymousMotionEvent1;
          }
          paramAnonymousMotionEvent1.aZv = 1;
          paramAnonymousMotionEvent1.aZB = false;
          paramAnonymousMotionEvent1.aZw = 3;
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
        AppMethodBeat.i(208715);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(208715);
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157377);
        if ((SubsamplingScaleImageView.j(SubsamplingScaleImageView.this) != null) && (SubsamplingScaleImageView.j(SubsamplingScaleImageView.this).onSingleTapConfirmed(paramAnonymousMotionEvent)))
        {
          AppMethodBeat.o(157377);
          return true;
        }
        if (SubsamplingScaleImageView.k(SubsamplingScaleImageView.this) != null)
        {
          boolean bool = SubsamplingScaleImageView.k(SubsamplingScaleImageView.this).onSingleTapConfirmed(paramAnonymousMotionEvent);
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
        AppMethodBeat.i(208714);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(208714);
        return bool;
      }
    });
    this.aYi = new GestureDetector(paramContext, new SubsamplingScaleImageView.4(this));
    AppMethodBeat.o(157405);
  }
  
  public static void setPreferredBitmapConfig(Bitmap.Config paramConfig)
  {
    aYI = paramConfig;
  }
  
  public static void setTileInitLoaderImp(com.davemorrissey.labs.subscaleview.c.c paramc)
  {
    aYL = paramc;
  }
  
  public static void setTileLoaderImp(com.davemorrissey.labs.subscaleview.c.d paramd)
  {
    aYK = paramd;
  }
  
  public final float Y(float paramFloat)
  {
    if (this.aXO == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.aXO.x;
  }
  
  public final float Z(float paramFloat)
  {
    if (this.aXO == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.aXO.y;
  }
  
  public final float a(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(208725);
    float f2;
    int i;
    label121:
    float f1;
    if (!this.aXC)
    {
      if (this.aXV != null)
      {
        paramPointF1.x = this.aXV.x;
        paramPointF1.y = this.aXV.y;
      }
    }
    else
    {
      f2 = getDoubleTapZoomScale();
      Log.i(this.TAG, "alvinluo doubleTapZoom %f, scale: %s, mScaleRate: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.scale), Float.valueOf(this.aYR) });
      if ((this.scale > f2 * 0.9D) && (this.scale != this.aYR)) {
        break label180;
      }
      i = 1;
      if (i == 0) {
        break label186;
      }
      f1 = f2;
      label129:
      if (this.aXG != 3) {
        break label194;
      }
      a(f1, paramPointF1);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(208725);
      return f1;
      paramPointF1.x = (rX() / 2);
      paramPointF1.y = (rY() / 2);
      break;
      label180:
      i = 0;
      break label121;
      label186:
      f1 = this.aYR;
      break label129;
      label194:
      if ((this.aXG == 2) || (i == 0) || (!this.aXC))
      {
        paramPointF1 = new b(f1, paramPointF1, (byte)0);
        paramPointF1.aZu = false;
        paramPointF1.duration = this.aXH;
        paramPointF1.aZw = 4;
        paramPointF1.start();
      }
      else if (this.aXG == 1)
      {
        paramPointF1 = new b(f2, paramPointF1, paramPointF2, (byte)0);
        paramPointF1.aZu = false;
        paramPointF1.duration = this.aXH;
        paramPointF1.aZw = 4;
        paramPointF1.start();
      }
    }
  }
  
  public final Bitmap a(Bitmap paramBitmap, int paramInt)
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
        aYI = Bitmap.Config.RGB_565;
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
    this.aYt = null;
    this.aXW = true;
    this.aXT = Float.valueOf(paramFloat);
    this.aXU = paramPointF;
    this.aXV = paramPointF;
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
        Log.i(this.TAG, "alvinluo onPreviewLoaded");
        if (paramBitmap != null) {
          Log.i(this.TAG, "alvinluo onPreviewLoaded %d, recycle: %b", new Object[] { Integer.valueOf(paramBitmap.hashCode()), Boolean.valueOf(paramBitmap.isRecycled()) });
        }
        long l = System.currentTimeMillis();
        if (this.aYv)
        {
          if (this.bitmap != null) {
            this.bitmap.recycle();
          }
          AppMethodBeat.o(157428);
          return;
        }
        if (this.aYb != null)
        {
          if ((this.aYb.width() > 0) && (this.aYb.height() > 0))
          {
            this.bitmap = Bitmap.createBitmap(paramBitmap, this.aYb.left, this.aYb.top, this.aYb.width(), this.aYb.height());
            this.aYa = 0;
          }
          this.aXg = true;
          this.aXi = false;
          this.previewWidth = this.bitmap.getWidth();
          this.previewHeight = this.bitmap.getHeight();
          rO();
          this.aXi = true;
          if (rS())
          {
            invalidate();
            requestLayout();
          }
          dy((int)(System.currentTimeMillis() - l));
          Log.i(this.TAG, "alvinluo onPreviewLoaded");
          if ((!this.aXh) && (this.aYw != null)) {
            this.aYw.sb();
          }
          AppMethodBeat.o(157428);
          continue;
        }
        if (paramInteger == null) {
          break label283;
        }
      }
      finally {}
      this.aYa = paramInteger.intValue();
      label283:
      this.bitmap = paramBitmap;
    }
  }
  
  public final void a(com.davemorrissey.labs.subscaleview.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(157424);
      h("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.aWX), Integer.valueOf(this.aWY), Integer.valueOf(paramInt3) });
      if ((this.aWX > 0) && (this.aWY > 0) && ((this.aWX != paramInt1) || (this.aWY != paramInt2)))
      {
        reset(false);
        if (this.bitmap != null)
        {
          if (!this.aXj) {
            this.bitmap.recycle();
          }
          this.bitmap = null;
          if ((this.aYw != null) && (this.aXj)) {
            this.aYw.sc();
          }
          this.aXg = false;
          this.aXj = false;
        }
      }
      this.aWL = paramd;
      this.aWX = paramInt1;
      this.aWY = paramInt2;
      this.aXZ = paramInt3;
      rS();
      if ((!rT()) && (this.aXz > 0) && (this.aXz != aXy) && (this.aXA > 0) && (this.aXA != aXy) && (getWidth() > 0) && (getHeight() > 0)) {
        a(new Point(this.aXz, this.aXA));
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
    this.aXX = parama1;
    this.aXY = parama2;
    reset(true);
    if (parama1.getUri() != null) {
      this.aXZ = e(getContext(), parama1.getUri());
    }
    if (parama2 != null)
    {
      if ((parama1.aWX > 0) && (parama1.aWY > 0)) {
        break label157;
      }
      Log.e(this.TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
    }
    while ((parama1.bitmap != null) && (parama1.aWZ != null))
    {
      b(Bitmap.createBitmap(parama1.bitmap, parama1.aWZ.left, parama1.aWZ.top, parama1.aWZ.width(), parama1.aWZ.height()), 0, false);
      AppMethodBeat.o(157403);
      return;
      label157:
      this.aWX = parama1.aWX;
      this.aWY = parama1.aWY;
      this.aYb = parama2.aWZ;
      if (parama2.bitmap != null)
      {
        this.aXj = parama2.aXa;
        a(parama2.bitmap, Integer.valueOf(0));
      }
      else
      {
        Uri localUri2 = parama2.getUri();
        Uri localUri1 = localUri2;
        if (localUri2 == null)
        {
          localUri1 = localUri2;
          if (parama2.aWV != null) {
            localUri1 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama2.aWV);
          }
        }
        aYJ.a(this, getContext(), this.aYj, localUri1, true).rJ();
      }
    }
    if (parama1.bitmap != null)
    {
      b(parama1.bitmap, 0, parama1.aXa);
      AppMethodBeat.o(157403);
      return;
    }
    this.aWZ = parama1.aWZ;
    this.uri = parama1.getUri();
    if ((this.uri == null) && (parama1.aWV != null)) {
      this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama1.aWV);
    }
    if ((parama1.aWW) || (this.aWZ != null))
    {
      aYL.a(this, getContext(), this.aYk, this.uri).rJ();
      AppMethodBeat.o(157403);
      return;
    }
    aYJ.a(this, getContext(), this.aYj, this.uri, false).rJ();
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
      if ((this.aWX > 0) && (this.aWY > 0) && ((this.aWX != paramBitmap.getWidth()) || (this.aWY != paramBitmap.getHeight()))) {
        reset(false);
      }
      if ((this.bitmap != null) && (!this.aXj)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aXj) && (this.aYw != null)) {
        this.aYw.sc();
      }
      this.aXg = false;
      this.aXj = paramBoolean;
      this.bitmap = paramBitmap;
      this.aWX = paramBitmap.getWidth();
      this.aWY = paramBitmap.getHeight();
      this.aXZ = paramInt;
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(157382);
          long l1 = System.currentTimeMillis();
          if (paramInt != 0) {
            SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(paramBitmap, paramInt));
          }
          long l2 = System.currentTimeMillis();
          Log.i(SubsamplingScaleImageView.m(SubsamplingScaleImageView.this), "alvinluo onImageLoaded rotaeAndScaleBitmap %d", new Object[] { Long.valueOf(l2 - l1) });
          SubsamplingScaleImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157381);
              if ((SubsamplingScaleImageView.6.this.aZk) || (SubsamplingScaleImageView.6.this.aZl))
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
    //   4: ldc_w 1384
    //   7: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokestatic 1066	java/lang/System:currentTimeMillis	()J
    //   14: putfield 311	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXm	J
    //   17: aload_0
    //   18: getfield 305	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   21: astore 4
    //   23: aload_1
    //   24: getfield 833	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   27: istore_2
    //   28: aload_1
    //   29: getfield 838	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   32: ifnonnull +166 -> 198
    //   35: aload 4
    //   37: ldc_w 1386
    //   40: iconst_2
    //   41: anewarray 293	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: iload_2
    //   47: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: iload_3
    //   54: invokestatic 1019	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 1256	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_1
    //   62: getfield 833	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   65: aload_0
    //   66: getfield 707	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXk	I
    //   69: if_icmpne +40 -> 109
    //   72: aload_1
    //   73: getfield 838	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   76: ifnull +33 -> 109
    //   79: aload_0
    //   80: getfield 307	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXl	Z
    //   83: ifeq +26 -> 109
    //   86: aload_0
    //   87: getfield 305	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   90: ldc_w 1388
    //   93: invokestatic 771	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 307	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXl	Z
    //   101: aload_0
    //   102: aload_1
    //   103: getfield 838	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   106: putfield 638	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXo	Landroid/graphics/Bitmap;
    //   109: aload_0
    //   110: invokespecial 1300	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:rS	()Z
    //   113: pop
    //   114: aload_0
    //   115: invokespecial 1317	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:rT	()Z
    //   118: pop
    //   119: aload_0
    //   120: invokespecial 1049	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:rR	()Z
    //   123: ifeq +62 -> 185
    //   126: aload_0
    //   127: getfield 869	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   130: ifnull +55 -> 185
    //   133: aload_0
    //   134: getfield 1161	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXj	Z
    //   137: ifne +10 -> 147
    //   140: aload_0
    //   141: getfield 869	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   144: invokevirtual 841	android/graphics/Bitmap:recycle	()V
    //   147: aload_0
    //   148: aconst_null
    //   149: putfield 869	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   152: aload_0
    //   153: getfield 1163	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aYw	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   156: ifnull +19 -> 175
    //   159: aload_0
    //   160: getfield 1161	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXj	Z
    //   163: ifeq +12 -> 175
    //   166: aload_0
    //   167: getfield 1163	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aYw	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   170: invokeinterface 1166 1 0
    //   175: aload_0
    //   176: iconst_0
    //   177: putfield 995	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXg	Z
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 1161	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXj	Z
    //   185: aload_0
    //   186: invokevirtual 1230	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:invalidate	()V
    //   189: ldc_w 1384
    //   192: invokestatic 273	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157408);
    Log.d(this.TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(157408);
    return bool;
  }
  
  public final void dx(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157388);
      if (this.aZb != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aZb;
        locala.aWT += paramInt;
        Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aWT) });
      }
      AppMethodBeat.o(157388);
      return;
    }
    finally {}
  }
  
  public final void dy(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157389);
      if (this.aZb != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aZb;
        locala.aWS += paramInt;
        Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aWS) });
      }
      AppMethodBeat.o(157389);
      return;
    }
    finally {}
  }
  
  public final void dz(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157390);
      if (this.aZb != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aZb;
        locala.aWU += paramInt;
        Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aWU) });
      }
      AppMethodBeat.o(157390);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final int e(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc_w 1417
    //   9: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: ldc_w 1419
    //   15: aload_2
    //   16: invokevirtual 1422	android/net/Uri:getScheme	()Ljava/lang/String;
    //   19: invokevirtual 1423	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +168 -> 190
    //   25: aload_1
    //   26: invokevirtual 1427	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: aload_2
    //   30: iconst_1
    //   31: anewarray 497	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc_w 1428
    //   39: aastore
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 1434	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +86 -> 134
    //   51: aload_1
    //   52: invokeinterface 1439 1 0
    //   57: ifeq +77 -> 134
    //   60: aload_1
    //   61: iconst_0
    //   62: invokeinterface 1442 2 0
    //   67: istore_3
    //   68: getstatic 235	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aXb	Ljava/util/List;
    //   71: iload_3
    //   72: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokeinterface 1445 2 0
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
    //   100: invokeinterface 1448 1 0
    //   105: iload_3
    //   106: istore 4
    //   108: ldc_w 1417
    //   111: invokestatic 273	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: iload 4
    //   116: ireturn
    //   117: aload_0
    //   118: getfield 305	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   121: ldc_w 1450
    //   124: iload_3
    //   125: invokestatic 621	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   128: invokevirtual 516	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   131: invokestatic 1452	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: iconst_0
    //   135: istore_3
    //   136: goto -44 -> 92
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 305	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   146: ldc_w 1454
    //   149: invokestatic 1452	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_1
    //   153: ifnull +253 -> 406
    //   156: aload_1
    //   157: invokeinterface 1448 1 0
    //   162: iconst_0
    //   163: istore 4
    //   165: goto -57 -> 108
    //   168: astore_1
    //   169: aload 7
    //   171: astore_2
    //   172: aload_2
    //   173: ifnull +9 -> 182
    //   176: aload_2
    //   177: invokeinterface 1448 1 0
    //   182: ldc_w 1417
    //   185: invokestatic 273	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    //   190: aload_2
    //   191: aconst_null
    //   192: invokestatic 1459	com/tencent/mm/vfs/s:b	(Landroid/net/Uri;Lcom/tencent/mm/vfs/g$e;)Ljava/io/InputStream;
    //   195: astore 7
    //   197: new 1461	androidx/a/a/a
    //   200: dup
    //   201: aload 7
    //   203: invokespecial 1464	androidx/a/a/a:<init>	(Ljava/io/InputStream;)V
    //   206: ldc_w 1466
    //   209: iconst_1
    //   210: invokevirtual 1470	androidx/a/a/a:getAttributeInt	(Ljava/lang/String;I)I
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
    //   235: invokevirtual 1473	java/io/InputStream:close	()V
    //   238: iload_3
    //   239: istore 4
    //   241: goto -133 -> 108
    //   244: astore_1
    //   245: aload_0
    //   246: getfield 305	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   249: ldc_w 1475
    //   252: invokestatic 1452	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   299: getfield 305	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   302: ldc_w 1477
    //   305: iload_3
    //   306: invokestatic 621	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   309: invokevirtual 516	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   312: invokestatic 1452	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: iconst_0
    //   316: istore_3
    //   317: goto -92 -> 225
    //   320: astore_2
    //   321: ldc_w 1417
    //   324: invokestatic 273	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: aload_2
    //   328: athrow
    //   329: astore_1
    //   330: aload 7
    //   332: ifnull +12 -> 344
    //   335: aload_2
    //   336: ifnull +27 -> 363
    //   339: aload 7
    //   341: invokevirtual 1473	java/io/InputStream:close	()V
    //   344: ldc_w 1417
    //   347: invokestatic 273	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: aload_1
    //   351: athrow
    //   352: astore 6
    //   354: aload_2
    //   355: aload 6
    //   357: invokevirtual 1481	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   360: goto -16 -> 344
    //   363: aload 7
    //   365: invokevirtual 1473	java/io/InputStream:close	()V
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
    return this.aWE;
  }
  
  public Bitmap getFullImageBitmap()
  {
    return this.aXo;
  }
  
  public int getFullImageSampleSize()
  {
    return this.aXk;
  }
  
  public com.davemorrissey.labs.subscaleview.d.a getImageDecodeRecord()
  {
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala = this.aZb;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public PointF getImageViewMatrixScale()
  {
    AppMethodBeat.i(208721);
    if ((Float.isNaN(this.scale)) || (Float.isInfinite(this.scale)))
    {
      localPointF = new PointF(1.0F, 1.0F);
      AppMethodBeat.o(208721);
      return localPointF;
    }
    PointF localPointF = new PointF(this.scale, this.scale);
    AppMethodBeat.o(208721);
    return localPointF;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(208722);
    if (this.aXO != null)
    {
      PointF localPointF = new PointF(this.aXO.x, this.aXO.y);
      AppMethodBeat.o(208722);
      return localPointF;
    }
    AppMethodBeat.o(208722);
    return null;
  }
  
  public float getMaxScale()
  {
    return this.aXt;
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(157453);
    float f = rZ();
    AppMethodBeat.o(157453);
    return f;
  }
  
  public e getOnImageEventListener()
  {
    return this.aYw;
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
    return this.aYa;
  }
  
  public int getPreviewWidth()
  {
    return this.previewWidth;
  }
  
  public int getRequiredRotation()
  {
    if (this.orientation == -1) {
      return this.aXZ;
    }
    return this.orientation;
  }
  
  public final int getSHeight()
  {
    return this.aWY;
  }
  
  public final int getSWidth()
  {
    return this.aWX;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  public final b getState()
  {
    AppMethodBeat.i(157458);
    if ((this.aXO != null) && (this.aWX > 0) && (this.aWY > 0))
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
    return this.aWZ;
  }
  
  public final void h(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(157444);
    Log.d(this.TAG, String.format(paramString, paramVarArgs));
    AppMethodBeat.o(157444);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(157391);
    super.onAttachedToWindow();
    if (this.aYZ != null) {
      this.aYZ.onViewAttachedToWindow(this);
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
      Log.i(this.TAG, "alvinluo cancelAllTileLoadTask, task size: %d", new Object[] { Integer.valueOf(this.aYM.size()) });
      Iterator localIterator = this.aYM.iterator();
      while (localIterator.hasNext()) {
        ((com.davemorrissey.labs.subscaleview.c.b)localIterator.next()).cancel();
      }
      this.aYM.clear();
    }
    if (this.aYZ != null) {
      this.aYZ.onViewDetachedFromWindow(this);
    }
    AppMethodBeat.o(157392);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(157413);
    super.onDraw(paramCanvas);
    System.currentTimeMillis();
    if (this.aYz == null)
    {
      this.aYz = new Paint();
      this.aYz.setAntiAlias(true);
      this.aYz.setFilterBitmap(true);
      this.aYz.setDither(true);
    }
    if (((this.aYA == null) || (this.aYB == null)) && (this.aXs))
    {
      this.aYA = new Paint();
      this.aYA.setTextSize(px(20));
      this.aYA.setColor(-65281);
      this.aYA.setStyle(Paint.Style.FILL);
      this.aYB = new Paint();
      this.aYB.setColor(-65281);
      this.aYB.setStyle(Paint.Style.STROKE);
      this.aYB.setStrokeWidth(px(1));
    }
    if ((this.aWX == 0) || (this.aWY == 0) || (getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(157413);
      return;
    }
    int j;
    int k;
    if ((this.aXr == null) && (this.aWL != null))
    {
      j = Math.min(paramCanvas.getMaximumBitmapWidth(), this.aXz);
      k = Math.min(paramCanvas.getMaximumBitmapHeight(), this.aXA);
      i = j;
      if (j > 10000) {
        i = 10000;
      }
      j = k;
      if (k > 10000) {
        j = 10000;
      }
      Log.i(this.TAG, "alvinluo getMaxBitmapDimensions %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      a(new Point(i, j));
    }
    if (!rS())
    {
      AppMethodBeat.o(157413);
      return;
    }
    rU();
    float f1;
    boolean bool1;
    boolean bool2;
    if ((this.aYt != null) && (this.aYt.aZs != null))
    {
      f1 = this.scale;
      if (this.aXQ == null) {
        this.aXQ = new PointF(0.0F, 0.0F);
      }
      this.aXQ.set(this.aXO);
      long l = System.currentTimeMillis() - this.aYt.time;
      if (l > this.aYt.duration)
      {
        bool1 = true;
        l = Math.min(l, this.aYt.duration);
        this.scale = a(this.aYt.aZv, l, this.aYt.aXN, this.aYt.aZo - this.aYt.aXN, this.aYt.duration);
        f2 = a(this.aYt.aZv, l, this.aYt.aZs.x, this.aYt.aZt.x - this.aYt.aZs.x, this.aYt.duration);
        float f3 = a(this.aYt.aZv, l, this.aYt.aZs.y, this.aYt.aZt.y - this.aYt.aZs.y, this.aYt.duration);
        localObject1 = this.aXO;
        ((PointF)localObject1).x -= Y(this.aYt.aZq.x) - f2;
        localObject1 = this.aXO;
        ((PointF)localObject1).y -= Z(this.aYt.aZq.y) - f3;
        if ((!bool1) && (this.aYt.aXN != this.aYt.aZo)) {
          break label891;
        }
        bool2 = true;
        label676:
        aK(bool2);
        b(f1, this.aXQ);
        aJ(bool1);
        if (bool1) {
          this.aYt = null;
        }
        invalidate();
      }
    }
    else
    {
      if ((this.aXr == null) || (!rR()) || (!this.aYW)) {
        break label1805;
      }
      k = Math.min(this.aXk, V(this.scale));
      localObject1 = this.aXr.entrySet().iterator();
    }
    Object localObject2;
    Object localObject3;
    for (int i = 0;; i = j)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label904;
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
          if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).visible) && ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWP) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null))) {
            i = 1;
          }
        }
        bool1 = false;
        break;
        label891:
        bool2 = false;
        break label676;
      }
    }
    label904:
    Object localObject1 = this.aXr.entrySet().iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((((Integer)((Map.Entry)localObject2).getKey()).intValue() == k) || (i != 0))
        {
          localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
          label1803:
          for (;;)
          {
            label982:
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject2).next();
              Rect localRect = ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWO;
              ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.set((int)Y(localRect.left), (int)Z(localRect.top), (int)Y(localRect.right), (int)Z(localRect.bottom));
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWP) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null)) {
                break label1745;
              }
              if (this.aYC != null) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ, this.aYC);
              }
              if (this.gT == null) {
                this.gT = new Matrix();
              }
              this.gT.reset();
              a(this.aYF, 0.0F, 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight());
              if (getRequiredRotation() != 0) {
                break label1470;
              }
              a(this.aYG, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.bottom);
              label1257:
              this.gT.setPolyToPoly(this.aYF, 0, this.aYG, 0, 4);
              if (!((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.isRecycled()) {
                paramCanvas.drawBitmap(((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap, this.gT, this.aYz);
              }
              if (this.aXs) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ, this.aYB);
              }
            }
            for (;;)
            {
              if ((!((com.davemorrissey.labs.subscaleview.c.e)localObject3).visible) || (!this.aXs)) {
                break label1803;
              }
              paramCanvas.drawText("ISS " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).sampleSize + " RECT " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWO.top + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWO.left + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWO.bottom + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWO.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.top + px(15), this.aYA);
              break label982;
              break;
              label1470:
              if (getRequiredRotation() == 90)
              {
                a(this.aYG, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.top);
                break label1257;
              }
              if (getRequiredRotation() == 180)
              {
                a(this.aYG, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.top);
                break label1257;
              }
              if (getRequiredRotation() != 270) {
                break label1257;
              }
              a(this.aYG, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.bottom);
              break label1257;
              label1745:
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWP) && (this.aXs)) {
                paramCanvas.drawText("LOADING", ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aWQ.top + px(35), this.aYA);
              }
            }
          }
          label1805:
          if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
          {
            Log.d(this.TAG, "alvinluo onDraw bitmap scale: %f", new Object[] { Float.valueOf(this.scale) });
            if ((!this.aXg) || (this.aXi))
            {
              if (this.gT == null) {
                this.gT = new Matrix();
              }
              this.gT.reset();
              i = this.bitmap.getWidth();
              j = this.bitmap.getHeight();
              if ((this.aYa == 90) || (this.aYa == 270))
              {
                i = this.bitmap.getHeight();
                j = this.bitmap.getWidth();
              }
              if (this.aXg)
              {
                f1 = i / 2.0F;
                f2 = j / 2.0F;
                rO();
                this.gT.postScale(this.aYS, this.aYT, f1, f2);
              }
              f1 = (this.aYN - this.bitmap.getWidth()) / 2;
              f2 = (this.aYO - this.bitmap.getHeight()) / 2;
              this.gT.postTranslate(f1, f2);
              Log.d(this.TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
              if (this.aYC != null)
              {
                if (this.aYE == null) {
                  this.aYE = new RectF();
                }
                localObject1 = this.aYE;
                if (!this.aXg) {
                  break label2888;
                }
                f1 = this.bitmap.getWidth();
                if (!this.aXg) {
                  break label2897;
                }
              }
            }
          }
        }
      }
    }
    label2888:
    label2897:
    for (float f2 = this.bitmap.getHeight();; f2 = this.aWY)
    {
      ((RectF)localObject1).set(0.0F, 0.0F, f1, f2);
      this.gT.mapRect(this.aYE);
      paramCanvas.drawRect(this.aYE, this.aYC);
      paramCanvas.drawBitmap(this.bitmap, this.gT, this.aYz);
      if (this.aXs)
      {
        Log.d(this.TAG, "alvinluo onDraw debug vTranslate %f, %f", new Object[] { Float.valueOf(this.aXO.x), Float.valueOf(this.aXO.y) });
        paramCanvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.scale) }) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(rZ()) }) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aXt) }) + ")", px(5), px(15), this.aYA);
        paramCanvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aXO.x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aXO.y) }), px(5), px(30), this.aYA);
        localObject1 = getCenter();
        paramCanvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).y) }), px(5), px(45), this.aYA);
        if (this.aYt != null)
        {
          localObject1 = b(this.aYt.aZp);
          localObject2 = b(this.aYt.aZr);
          localObject3 = b(this.aYt.aZq);
          paramCanvas.drawCircle(((PointF)localObject1).x, ((PointF)localObject1).y, px(10), this.aYB);
          this.aYB.setColor(-65536);
          paramCanvas.drawCircle(((PointF)localObject2).x, ((PointF)localObject2).y, px(20), this.aYB);
          this.aYB.setColor(-16776961);
          paramCanvas.drawCircle(((PointF)localObject3).x, ((PointF)localObject3).y, px(25), this.aYB);
          this.aYB.setColor(-16711936);
          paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.aYB);
        }
        if (this.aYl != null)
        {
          this.aYB.setColor(-65536);
          paramCanvas.drawCircle(this.aYl.x, this.aYl.y, px(20), this.aYB);
        }
        if (this.aYr != null)
        {
          this.aYB.setColor(-16776961);
          paramCanvas.drawCircle(Y(this.aYr.x), Z(this.aYr.y), px(35), this.aYB);
        }
        if ((this.aYs != null) && (this.aYe))
        {
          this.aYB.setColor(-12303292);
          paramCanvas.drawCircle(this.aYs.x, this.aYs.y, px(30), this.aYB);
        }
        this.aYB.setColor(-65281);
      }
      AppMethodBeat.o(157413);
      return;
      f1 = this.aWX;
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
      if ((this.aWX <= 0) || (this.aWY <= 0)) {
        break label214;
      }
      if ((paramInt2 == 0) || (i == 0)) {
        break label164;
      }
      paramInt2 = rX();
      paramInt1 = rY();
    }
    for (;;)
    {
      paramInt2 = Math.max(paramInt2, getSuggestedMinimumWidth());
      paramInt1 = Math.max(paramInt1, getSuggestedMinimumHeight());
      setMeasuredDimension(paramInt2, paramInt1);
      this.aYN = paramInt2;
      this.aYO = paramInt1;
      Log.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", new Object[] { Integer.valueOf(this.aYN), Integer.valueOf(this.aYN) });
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
        paramInt1 = (int)(rY() / rX() * j);
        paramInt2 = j;
      }
      else if (paramInt2 != 0)
      {
        paramInt2 = (int)(rX() / rY() * paramInt1);
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
    h("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(this.scale), this.aXT, Boolean.valueOf(this.aXW) });
    rN();
    PointF localPointF = getCenter();
    if (((this.aYu) || (this.aXW)) && (localPointF != null))
    {
      this.aYt = null;
      if (!this.aXW)
      {
        this.aXT = Float.valueOf(this.scale);
        this.aXU = localPointF;
      }
    }
    AppMethodBeat.o(157406);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157409);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    Log.v(this.TAG, "alvinluo SubSamplingScaleImageView onTouchEvent: %d, lastMotionEvent: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), this.aXM });
    if ((!this.aXK) && (this.aXM != null) && (this.aXM.getAction() == paramMotionEvent.getAction()) && (paramMotionEvent.getAction() == 0))
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(157409);
      return true;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 1) || (i == 6) || (i == 3)) {}
    for (this.aXM = null;; this.aXM = paramMotionEvent)
    {
      if (this.aZa != null) {
        this.aZa.onTouch(this, paramMotionEvent);
      }
      if ((this.aYt == null) || (this.aYt.aZu)) {
        break;
      }
      requestDisallowInterceptTouchEvent(true);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(157409);
      return true;
    }
    this.aYt = null;
    if (this.aXO == null)
    {
      if (this.aYi != null)
      {
        localObject = this.aYi;
        paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMotionEvent.axQ(), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(157409);
      return true;
    }
    if (!this.aYe) {
      if (this.aYg != null)
      {
        localObject = this.aYg;
        com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (!com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.pG(0)), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z")) {}
      }
      else
      {
        this.aYc = false;
        this.aYd = false;
        this.aYf = 0;
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(157409);
        return true;
      }
    }
    if (this.aXP == null) {
      this.aXP = new PointF(0.0F, 0.0F);
    }
    if (this.aXQ == null) {
      this.aXQ = new PointF(0.0F, 0.0F);
    }
    if (this.aYl == null) {
      this.aYl = new PointF(0.0F, 0.0F);
    }
    float f3 = this.scale;
    this.aXQ.set(this.aXO);
    i = paramMotionEvent.getPointerCount();
    boolean bool1;
    label671:
    boolean bool2;
    label748:
    float f1;
    label920:
    label1017:
    float f4;
    float f5;
    float f6;
    double d;
    float f2;
    label1371:
    float f7;
    label1416:
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
        b(f3, this.aXQ);
        bool2 = super.onTouchEvent(paramMotionEvent);
        Log.v(this.TAG, "alvinluo onTouchEvent super: %b, handled: %b, allowInterceptTouch: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(this.aXK) });
        if (!this.aXK) {
          break label3270;
        }
        if ((!bool1) && (!bool2)) {
          break;
        }
        bool1 = true;
        com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(157409);
        return bool1;
        this.aZg = paramMotionEvent.getRawX();
        this.aZh = paramMotionEvent.getRawY();
        this.aYt = null;
        requestDisallowInterceptTouchEvent(true);
        this.aYf = Math.max(this.aYf, i);
        if (i >= 2) {
          if (this.aXD)
          {
            f1 = e(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
            this.aXN = this.scale;
            this.aYm = f1;
            this.aXP.set(this.aXO.x, this.aXO.y);
            this.aYl.set((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F, (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
            this.handler.removeMessages(1);
          }
        }
        for (;;)
        {
          if (!this.aXK) {
            break label1017;
          }
          bool1 = true;
          break;
          this.aYf = 0;
          break label920;
          if (!this.aYe)
          {
            this.aXP.set(this.aXO.x, this.aXO.y);
            this.aYl.set(paramMotionEvent.getX(), paramMotionEvent.getY());
            Log.i(this.TAG, "pennqin, delay time 601 ms.");
            this.handler.sendEmptyMessageDelayed(1, 601L);
          }
        }
        bool1 = false;
      }
    case 2: 
      bool2 = false;
      bool1 = bool2;
      if (this.aYf > 0)
      {
        if (i < 2) {
          break label1752;
        }
        f4 = e(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
        f5 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
        f6 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
        this.aYY = new PointF(f5, f6);
        bool1 = bool2;
        if (this.aXD) {
          if ((e(this.aYl.x, f5, this.aYl.y, f6) <= 5.0F) && (Math.abs(f4 - this.aYm) <= 5.0F))
          {
            bool1 = bool2;
            if (!this.aYd) {}
          }
          else
          {
            this.aYc = true;
            this.aYd = true;
            d = this.scale;
            f2 = f4 / this.aYm * this.aXN;
            f1 = f2;
            if (f2 >= this.aXt * 2.0F)
            {
              f1 = this.aXt;
              f1 = (f2 - this.aXt) * 0.1F + f1 * 2.0F;
            }
            this.scale = f1;
            Log.d(this.TAG, "alvinluo zoom preScale: %f, scale: %f, minScale: %f, maxScale: %f", new Object[] { Double.valueOf(d), Float.valueOf(this.scale), Float.valueOf(rZ()), Float.valueOf(this.aXt) });
            if (this.scale > rZ()) {
              break label1416;
            }
            this.aYm = f4;
            this.aXN = rZ();
            this.aYl.set(f5, f6);
            this.aXP.set(this.aXO);
          }
        }
      }
      for (;;)
      {
        aK(true);
        aJ(this.aXB);
        bool1 = true;
        Log.d(this.TAG, "alvinluo Action_Move consumed: %b", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break;
        }
        this.handler.removeMessages(1);
        invalidate();
        bool1 = true;
        break label671;
        if (this.aXC)
        {
          f1 = this.aYl.x;
          f2 = this.aXP.x;
          f7 = this.aYl.y;
          f8 = this.aXP.y;
          float f9 = this.scale / this.aXN;
          float f10 = this.scale / this.aXN;
          this.aXO.x = (f5 - (f1 - f2) * f9);
          this.aXO.y = (f6 - (f7 - f8) * f10);
          if (((rY() * d < getHeight()) && (this.scale * rY() >= getHeight())) || ((d * rX() < getWidth()) && (this.scale * rX() >= getWidth())))
          {
            aK(true);
            this.aYl.set(f5, f6);
            this.aXP.set(this.aXO);
            this.aXN = this.scale;
            this.aYm = f4;
          }
        }
        else if (this.aXV != null)
        {
          this.aXO.x = (getWidth() / 2 - this.scale * this.aXV.x);
          this.aXO.y = (getHeight() / 2 - this.scale * this.aXV.y);
        }
        else
        {
          this.aXO.x = (getWidth() / 2 - this.scale * (rX() / 2));
          this.aXO.y = (getHeight() / 2 - this.scale * (rY() / 2));
        }
      }
      label1752:
      if (this.aYe)
      {
        f2 = Math.abs(this.aYs.y - paramMotionEvent.getY()) * 2.0F + this.aYn;
        if (this.aYo == -1.0F) {
          this.aYo = f2;
        }
        if (paramMotionEvent.getY() > this.aYq.y)
        {
          i = 1;
          this.aYq.set(0.0F, paramMotionEvent.getY());
          f4 = 0.5F * Math.abs(1.0F - f2 / this.aYo);
          if (f4 <= 0.03F)
          {
            f1 = f2;
            if (!this.aYp) {
              break;
            }
          }
          else
          {
            this.aYp = true;
            if (this.aYo <= 0.0F) {
              break label3310;
            }
            if (i == 0) {
              break label2178;
            }
            f1 = 1.0F + f4;
          }
        }
      }
      label1818:
      break;
    }
    for (;;)
    {
      label1893:
      d = this.scale;
      this.scale = Math.max(rZ(), Math.min(this.aXt, f1 * this.scale));
      if (this.aXC)
      {
        f1 = this.aYl.x;
        f4 = this.aXP.x;
        f5 = this.aYl.y;
        f6 = this.aXP.y;
        f7 = this.scale / this.aXN;
        f8 = this.scale / this.aXN;
        this.aXO.x = (this.aYl.x - (f1 - f4) * f7);
        this.aXO.y = (this.aYl.y - (f5 - f6) * f8);
        if (((rY() * d >= getHeight()) || (this.scale * rY() < getHeight())) && ((rX() * d >= getWidth()) || (this.scale * rX() < getWidth()))) {
          break label3303;
        }
        aK(true);
        this.aYl.set(b(this.aYr));
        this.aXP.set(this.aXO);
        this.aXN = this.scale;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.aYo = f1;
        aK(true);
        aJ(this.aXB);
        bool1 = true;
        break label1371;
        i = 0;
        break label1818;
        label2178:
        f1 = 1.0F - f4;
        break label1893;
        if (this.aXV != null)
        {
          this.aXO.x = (getWidth() / 2 - this.scale * this.aXV.x);
          this.aXO.y = (getHeight() / 2 - this.scale * this.aXV.y);
          f1 = f2;
        }
        else
        {
          this.aXO.x = (getWidth() / 2 - this.scale * (rX() / 2));
          this.aXO.y = (getHeight() / 2 - this.scale * (rY() / 2));
          f1 = f2;
          continue;
          bool1 = bool2;
          if (this.aYc) {
            break label1371;
          }
          f1 = Math.abs(paramMotionEvent.getX() - this.aYl.x);
          f2 = Math.abs(paramMotionEvent.getY() - this.aYl.y);
          f4 = this.density * 5.0F;
          if ((f1 <= f4) && (f2 <= f4))
          {
            bool1 = bool2;
            if (!this.aYd) {
              break label1371;
            }
          }
          this.aXO.x = (this.aXP.x + (paramMotionEvent.getX() - this.aYl.x));
          this.aXO.y = (this.aXP.y + (paramMotionEvent.getY() - this.aYl.y));
          f5 = this.aXO.x;
          f6 = this.aXO.y;
          aK(true);
          label2491:
          label2507:
          boolean bool3;
          label2530:
          boolean bool4;
          label2553:
          boolean bool5;
          if (f5 != this.aXO.x)
          {
            bool1 = true;
            if (f6 == this.aXO.y) {
              break label2792;
            }
            bool2 = true;
            if ((!bool1) || (f1 <= f2) || (this.aYd)) {
              break label2798;
            }
            bool3 = true;
            if ((!bool2) || (f2 <= f1) || (this.aYd)) {
              break label2804;
            }
            bool4 = true;
            if ((f6 != this.aXO.y) || (f2 <= 3.0F * f4)) {
              break label2810;
            }
            bool5 = true;
            label2581:
            Log.v(this.TAG, "alvinluo Action_Move edge atXEdge: %b, atYEdge: %b, edgeXSwipe: %b, edgeYSwipe: %b, yPan: %b, isPanning: %b,dx: %f, dy: %f, offset: %f", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(this.aYd), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f4) });
            if ((bool3) || (bool4) || ((bool1) && (bool2) && (!bool5) && (!this.aYd))) {
              break label2816;
            }
            this.aYd = true;
            bool1 = true;
          }
          for (;;)
          {
            bool2 = bool1;
            if (!this.aXC)
            {
              this.aXO.x = this.aXP.x;
              this.aXO.y = this.aXP.y;
              requestDisallowInterceptTouchEvent(false);
              bool2 = bool1;
              if (!this.aXK) {
                bool2 = false;
              }
            }
            aJ(this.aXB);
            bool1 = bool2;
            break label1371;
            bool1 = false;
            break label2491;
            label2792:
            bool2 = false;
            break label2507;
            label2798:
            bool3 = false;
            break label2530;
            label2804:
            bool4 = false;
            break label2553;
            label2810:
            bool5 = false;
            break label2581;
            label2816:
            if ((f1 > f4) || (f2 > f4))
            {
              this.aYf = 0;
              this.handler.removeMessages(1);
              requestDisallowInterceptTouchEvent(false);
              if (!this.aXK)
              {
                bool1 = false;
                continue;
                this.handler.removeMessages(1);
                if ((paramMotionEvent.getAction() == 3) && (this.aXL)) {
                  this.aXL = false;
                }
                if (this.aYe)
                {
                  this.aYe = false;
                  if (!this.aYp) {
                    a(this.aYr, this.aYl);
                  }
                }
                if ((this.aYf > 0) && ((this.aYc) || (this.aYd)))
                {
                  if ((this.aYc) && (i == 2))
                  {
                    this.aYd = true;
                    this.aXP.set(this.aXO.x, this.aXO.y);
                    if (paramMotionEvent.getActionIndex() != 1) {
                      break label3132;
                    }
                    this.aYl.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
                    label3008:
                    if (this.scale > this.aYR) {
                      break label3152;
                    }
                    Log.i(this.TAG, "alvinluo scale %f less than %f, and need to reset", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.aYR) });
                    localObject = new PointF(this.aYN / 2, this.aYO / 2);
                    a((PointF)localObject, (PointF)localObject, this.aYR);
                    this.aYd = false;
                  }
                  for (;;)
                  {
                    if (i < 3) {
                      this.aYc = false;
                    }
                    if (i < 2)
                    {
                      this.aYd = false;
                      this.aYf = 0;
                    }
                    aJ(true);
                    bool1 = true;
                    break;
                    label3132:
                    this.aYl.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
                    break label3008;
                    label3152:
                    if (this.scale > getDoubleTapZoomScale() * 2.0F)
                    {
                      Log.i(this.TAG, "alvinluo current scale %f larger than maxScale: %f, and reset to scale: %f", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.aXt), Float.valueOf(getDoubleTapZoomScale() * 2.0F) });
                      a(a(this.aYY), this.aYY, getDoubleTapZoomScale() * 2.0F);
                    }
                  }
                }
                if (i == 1)
                {
                  this.aYc = false;
                  this.aYd = false;
                  this.aYf = 0;
                }
                bool1 = false;
                break;
                bool1 = false;
                break label748;
                label3270:
                com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(157409);
                return bool1;
              }
            }
            bool1 = true;
          }
          label3303:
          f1 = f2;
        }
      }
      label3310:
      f1 = 1.0F;
    }
  }
  
  public void setAllowInterceptTouchEvent(boolean paramBoolean)
  {
    this.aXK = paramBoolean;
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
    this.aYj = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
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
    this.aYj = paramb;
    AppMethodBeat.o(157448);
  }
  
  public final void setDebug(boolean paramBoolean)
  {
    this.aXs = paramBoolean;
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
    this.aXH = Math.max(0, paramInt);
    AppMethodBeat.o(157463);
  }
  
  public final void setDoubleTapZoomScale(float paramFloat)
  {
    this.aXF = paramFloat;
  }
  
  public final void setDoubleTapZoomStyle(int paramInt)
  {
    AppMethodBeat.i(157462);
    if (!aXc.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid zoom style: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157462);
      throw localIllegalArgumentException;
    }
    this.aXG = paramInt;
    AppMethodBeat.o(157462);
  }
  
  public void setEagerLoadingEnabled(boolean paramBoolean)
  {
    this.aXB = paramBoolean;
  }
  
  public void setEdgeSwipeListener(c paramc)
  {
    this.aZc = paramc;
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
    this.aYh = paramSimpleOnGestureListener;
  }
  
  public final void setImage(a parama)
  {
    AppMethodBeat.i(157402);
    a(parama, null);
    AppMethodBeat.o(157402);
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(208724);
    if (this.aXO == null) {
      this.aXO = new PointF();
    }
    paramMatrix.getValues(this.aXR);
    this.aXO.set(this.aXR[2], this.aXR[5]);
    float f = this.scale;
    this.scale = this.aXR[0];
    if (this.aYx != null) {
      this.aYx.r(this.scale, f);
    }
    aK(false);
    invalidate();
    AppMethodBeat.o(208724);
  }
  
  public final void setMaxScale(float paramFloat)
  {
    this.aXt = paramFloat;
  }
  
  public void setMaxTileSize(int paramInt)
  {
    this.aXz = paramInt;
    this.aXA = paramInt;
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
    this.aXu = paramFloat;
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
    if (!aXf.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid scale type: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157450);
      throw localIllegalArgumentException;
    }
    this.aXx = paramInt;
    if (this.aYu)
    {
      aK(true);
      invalidate();
    }
    AppMethodBeat.o(157450);
  }
  
  public void setMinimumTileDpi(int paramInt)
  {
    AppMethodBeat.i(157454);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    this.aXv = ((int)Math.min((localDisplayMetrics.ydpi + f) / 2.0F, paramInt));
    if (this.aYu)
    {
      reset(false);
      invalidate();
    }
    AppMethodBeat.o(157454);
  }
  
  public void setOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.aYZ = paramOnAttachStateChangeListener;
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.aXJ = paramOnDoubleTapListener;
  }
  
  public void setOnImageEventListener(e parame)
  {
    this.aYw = parame;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.aYy = paramOnLongClickListener;
  }
  
  public void setOnStateChangedListener(SubsamplingScaleImageView.f paramf)
  {
    this.aYx = paramf;
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(157396);
    if (!aXb.contains(Integer.valueOf(paramInt)))
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
    this.aXC = paramBoolean;
    if ((!paramBoolean) && (this.aXO != null))
    {
      this.aXO.x = (getWidth() / 2 - this.scale * (rX() / 2));
      this.aXO.y = (getHeight() / 2 - this.scale * (rY() / 2));
      if (this.aYu)
      {
        aJ(true);
        invalidate();
      }
    }
    AppMethodBeat.o(157459);
  }
  
  public final void setPanLimit(int paramInt)
  {
    AppMethodBeat.i(157449);
    if (!aXe.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid pan limit: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157449);
      throw localIllegalArgumentException;
    }
    this.aXw = paramInt;
    if (this.aYu)
    {
      aK(true);
      invalidate();
    }
    AppMethodBeat.o(157449);
  }
  
  public void setPreviewDone(boolean paramBoolean)
  {
    AppMethodBeat.i(157395);
    this.aYW = paramBoolean;
    invalidate();
    AppMethodBeat.o(157395);
  }
  
  public final void setQuickScaleEnabled(boolean paramBoolean)
  {
    this.aXE = paramBoolean;
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
    this.aYk = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
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
    this.aYk = paramb;
    AppMethodBeat.o(157446);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(157397);
    this.aYR = paramFloat;
    this.aXt = 2.0F;
    this.aXu = 1.0F;
    rP();
    rQ();
    AppMethodBeat.o(157397);
  }
  
  public final void setTileBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(157460);
    if (Color.alpha(paramInt) == 0) {
      this.aYC = null;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(157460);
      return;
      this.aYC = new Paint();
      this.aYC.setStyle(Paint.Style.FILL);
      this.aYC.setColor(paramInt);
    }
  }
  
  public final void setZoomEnabled(boolean paramBoolean)
  {
    this.aXD = paramBoolean;
  }
  
  public void setsRegion(Rect paramRect)
  {
    this.aWZ = paramRect;
  }
  
  static final class a
  {
    float aXN;
    float aZo;
    PointF aZp;
    PointF aZq;
    PointF aZr;
    PointF aZs;
    PointF aZt;
    boolean aZu;
    int aZv;
    int aZw;
    SubsamplingScaleImageView.d aZx;
    long duration;
    long time;
    
    private a()
    {
      AppMethodBeat.i(157385);
      this.duration = 200L;
      this.aZu = true;
      this.aZv = 2;
      this.aZw = 1;
      this.time = System.currentTimeMillis();
      AppMethodBeat.o(157385);
    }
  }
  
  public final class b
  {
    private final PointF aZA;
    boolean aZB;
    public boolean aZu;
    int aZv;
    public int aZw;
    private SubsamplingScaleImageView.d aZx;
    private final float aZy;
    private final PointF aZz;
    public long duration;
    
    private b(float paramFloat, PointF paramPointF)
    {
      this.duration = 500L;
      this.aZv = 2;
      this.aZw = 1;
      this.aZu = true;
      this.aZB = true;
      this.aZy = paramFloat;
      this.aZz = paramPointF;
      this.aZA = null;
    }
    
    private b(float paramFloat, PointF paramPointF1, PointF paramPointF2)
    {
      this.duration = 500L;
      this.aZv = 2;
      this.aZw = 1;
      this.aZu = true;
      this.aZB = true;
      this.aZy = paramFloat;
      this.aZz = paramPointF1;
      this.aZA = paramPointF2;
    }
    
    private b(PointF paramPointF)
    {
      AppMethodBeat.i(157386);
      this.duration = 500L;
      this.aZv = 2;
      this.aZw = 1;
      this.aZu = true;
      this.aZB = true;
      this.aZy = SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
      this.aZz = paramPointF;
      this.aZA = null;
      AppMethodBeat.o(157386);
    }
    
    public final void start()
    {
      AppMethodBeat.i(157387);
      if ((SubsamplingScaleImageView.x(SubsamplingScaleImageView.this) != null) && (SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZx != null)) {}
      try
      {
        SubsamplingScaleImageView.x(SubsamplingScaleImageView.this);
        int i = SubsamplingScaleImageView.this.getPaddingLeft();
        int j = (SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight() - SubsamplingScaleImageView.this.getPaddingLeft()) / 2;
        int k = SubsamplingScaleImageView.this.getPaddingTop();
        int m = (SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom() - SubsamplingScaleImageView.this.getPaddingTop()) / 2;
        float f3 = SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, this.aZy);
        if (this.aZB)
        {
          Object localObject = SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, this.aZz.x, this.aZz.y, f3, new PointF());
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, new SubsamplingScaleImageView.a((byte)0));
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aXN = SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZo = f3;
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).time = System.currentTimeMillis();
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZr = ((PointF)localObject);
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZp = SubsamplingScaleImageView.this.getCenter();
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZq = ((PointF)localObject);
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZs = SubsamplingScaleImageView.this.b((PointF)localObject);
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZt = new PointF(j + i, m + k);
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).duration = this.duration;
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZu = this.aZu;
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZv = this.aZv;
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZw = this.aZw;
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).time = System.currentTimeMillis();
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZx = this.aZx;
          if (this.aZA != null)
          {
            float f1 = this.aZA.x - SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZp.x * f3;
            float f2 = this.aZA.y - SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aZp.y * f3;
            localObject = new SubsamplingScaleImageView.g(f3, new PointF(f1, f2), (byte)0);
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, (SubsamplingScaleImageView.g)localObject);
            SubsamplingScaleImageView.a locala = SubsamplingScaleImageView.x(SubsamplingScaleImageView.this);
            f3 = this.aZA.x;
            float f4 = ((SubsamplingScaleImageView.g)localObject).aXO.x;
            float f5 = this.aZA.y;
            locala.aZt = new PointF(f4 - f1 + f3, ((SubsamplingScaleImageView.g)localObject).aXO.y - f2 + f5);
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
          Log.w(SubsamplingScaleImageView.m(SubsamplingScaleImageView.this), "Error thrown by animation listener", new Object[] { localException });
          continue;
          PointF localPointF = this.aZz;
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
    
    public abstract void sb();
    
    public abstract void sc();
  }
  
  static final class g
  {
    PointF aXO;
    float scale;
    
    private g(float paramFloat, PointF paramPointF)
    {
      this.scale = paramFloat;
      this.aXO = paramPointF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView
 * JD-Core Version:    0.7.0.1
 */