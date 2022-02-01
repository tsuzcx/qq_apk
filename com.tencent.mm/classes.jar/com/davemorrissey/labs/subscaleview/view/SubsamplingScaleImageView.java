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
  public static int aGS;
  private static final List<Integer> aGv;
  private static final List<Integer> aGw;
  private static final List<Integer> aGx;
  private static final List<Integer> aGy;
  private static final List<Integer> aGz;
  private static Bitmap.Config aIe;
  private static com.davemorrissey.labs.subscaleview.c.a aIf;
  private static com.davemorrissey.labs.subscaleview.c.d aIg;
  private static com.davemorrissey.labs.subscaleview.c.c aIh;
  private int FO;
  public final String TAG;
  private final ReadWriteLock aFV;
  private boolean aGA;
  private boolean aGB;
  private boolean aGC;
  private boolean aGD;
  private int aGE;
  private boolean aGF;
  private long aGG;
  private long aGH;
  private Bitmap aGI;
  private boolean aGJ;
  private boolean aGK;
  private Map<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> aGL;
  private boolean aGM;
  private float aGN;
  private float aGO;
  private int aGP;
  private int aGQ;
  private int aGR;
  private int aGT;
  private int aGU;
  private boolean aGV;
  private boolean aGW;
  private boolean aGX;
  private boolean aGY;
  private float aGZ;
  private com.davemorrissey.labs.subscaleview.a.d aGd;
  public int aGp;
  public int aGq;
  private Rect aGr;
  private int aHA;
  private GestureDetector aHB;
  private GestureDetector.SimpleOnGestureListener aHC;
  private GestureDetector aHD;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aHE;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aHF;
  private PointF aHG;
  private float aHH;
  private final float aHI;
  private float aHJ;
  private boolean aHK;
  private PointF aHL;
  private PointF aHM;
  private PointF aHN;
  private a aHO;
  private boolean aHP;
  private boolean aHQ;
  private e aHR;
  private SubsamplingScaleImageView.f aHS;
  private View.OnLongClickListener aHT;
  private Paint aHU;
  private Paint aHV;
  private Paint aHW;
  private Paint aHX;
  private g aHY;
  private Matrix aHZ;
  private int aHa;
  public int aHb;
  private int aHc;
  private boolean aHd;
  private GestureDetector.OnDoubleTapListener aHe;
  private boolean aHf;
  private boolean aHg;
  private MotionEvent aHh;
  private float aHi;
  public PointF aHj;
  private PointF aHk;
  private PointF aHl;
  private float[] aHm;
  private float aHn;
  private Float aHo;
  private PointF aHp;
  private PointF aHq;
  private boolean aHr;
  private a aHs;
  private a aHt;
  private int aHu;
  private int aHv;
  private Rect aHw;
  private boolean aHx;
  private boolean aHy;
  private boolean aHz;
  private boolean aIA;
  private boolean aIB;
  private float aIC;
  private float aID;
  private RectF aIa;
  private float[] aIb;
  private float[] aIc;
  private Matrix aId;
  private LinkedList<com.davemorrissey.labs.subscaleview.c.b> aIi;
  private int aIj;
  private int aIk;
  private float aIl;
  private float aIm;
  public float aIn;
  private float aIo;
  private float aIp;
  private float aIq;
  private float aIr;
  private boolean aIs;
  private boolean aIt;
  private PointF aIu;
  private View.OnAttachStateChangeListener aIv;
  public View.OnTouchListener aIw;
  private com.davemorrissey.labs.subscaleview.d.a aIx;
  private c aIy;
  private boolean aIz;
  private Bitmap bitmap;
  private boolean cancelled;
  private float density;
  public Executor executor;
  private Handler handler;
  private int previewHeight;
  private int previewWidth;
  public float scale;
  private Uri uri;
  
  static
  {
    AppMethodBeat.i(157473);
    aGv = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1) });
    aGw = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    aGx = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
    aGy = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    aGz = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4) });
    aGS = 2147483647;
    aIe = Bitmap.Config.ARGB_8888;
    aIf = new com.davemorrissey.labs.subscaleview.b.a();
    aIg = new com.davemorrissey.labs.subscaleview.b.c();
    aIh = new com.davemorrissey.labs.subscaleview.b.b();
    AppMethodBeat.o(157473);
  }
  
  public SubsamplingScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(157394);
    this.TAG = (SubsamplingScaleImageView.class.getSimpleName() + hashCode());
    this.aGF = true;
    this.aGG = -1L;
    this.aGH = -1L;
    this.aGJ = false;
    this.aGK = false;
    this.aGM = false;
    this.FO = -1;
    this.aGN = 2.0F;
    this.aGO = pN();
    this.aGP = -1;
    this.aGQ = 1;
    this.aGR = 3;
    this.aGT = aGS;
    this.aGU = aGS;
    this.aGV = true;
    this.aGW = true;
    this.aGX = true;
    this.aGY = true;
    this.aGZ = 2.0F;
    this.aHa = 1;
    this.aHb = 200;
    this.aHc = 200;
    this.aHd = true;
    this.aHe = null;
    this.aHf = true;
    this.aHg = false;
    this.aHh = null;
    this.aHm = new float[9];
    this.aHn = 0.0F;
    this.aHv = 0;
    this.aFV = new ReentrantReadWriteLock(true);
    this.aHE = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.aHF = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.aIb = new float[8];
    this.aIc = new float[8];
    this.aIi = new LinkedList();
    this.cancelled = false;
    this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
    this.aIq = 1.0F;
    this.aIr = 20.0F;
    this.aIs = true;
    this.aIt = false;
    this.aIx = new com.davemorrissey.labs.subscaleview.d.a();
    this.aIy = new c() {};
    this.aIz = false;
    this.aIA = false;
    this.aIB = false;
    this.density = getResources().getDisplayMetrics().density;
    setDoubleTapZoomScale(2.0F);
    setMinimumTileDpi(320);
    setGestureDetector(paramContext);
    this.aId = new Matrix();
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
      if (paramAttributeSet.hasValue(a.a.SubsamplingScaleImageView_assetName))
      {
        String str = paramAttributeSet.getString(a.a.SubsamplingScaleImageView_assetName);
        if ((str != null) && (str.length() > 0)) {
          setImage(a.aY(str).pA());
        }
      }
      if (paramAttributeSet.hasValue(a.a.SubsamplingScaleImageView_src))
      {
        int i = paramAttributeSet.getResourceId(a.a.SubsamplingScaleImageView_src, 0);
        if (i > 0) {
          setImage(a.dK(i).pA());
        }
      }
      if (paramAttributeSet.hasValue(a.a.SubsamplingScaleImageView_panEnabled)) {
        setPanEnabled(paramAttributeSet.getBoolean(a.a.SubsamplingScaleImageView_panEnabled, true));
      }
      if (paramAttributeSet.hasValue(a.a.SubsamplingScaleImageView_zoomEnabled)) {
        setZoomEnabled(paramAttributeSet.getBoolean(a.a.SubsamplingScaleImageView_zoomEnabled, true));
      }
      if (paramAttributeSet.hasValue(a.a.SubsamplingScaleImageView_quickScaleEnabled)) {
        setQuickScaleEnabled(paramAttributeSet.getBoolean(a.a.SubsamplingScaleImageView_quickScaleEnabled, true));
      }
      if (paramAttributeSet.hasValue(a.a.SubsamplingScaleImageView_tileBackgroundColor)) {
        setTileBackgroundColor(paramAttributeSet.getColor(a.a.SubsamplingScaleImageView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
      }
      paramAttributeSet.recycle();
    }
    this.aHI = TypedValue.applyDimension(1, 20.0F, paramContext.getResources().getDisplayMetrics());
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aIq = f;
    }
    AppMethodBeat.o(157394);
  }
  
  private int H(float paramFloat)
  {
    AppMethodBeat.i(157420);
    float f = paramFloat;
    if (this.aGP > 0)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      f = localDisplayMetrics.xdpi;
      f = (localDisplayMetrics.ydpi + f) / 2.0F;
      f = paramFloat * (this.aGP / f);
    }
    int j = (int)(pL() * f);
    int i = (int)(pM() * f);
    if ((j == 0) || (i == 0))
    {
      AppMethodBeat.o(157420);
      return 32;
    }
    if ((pM() > i) || (pL() > j))
    {
      i = Math.round(pM() / i);
      j = Math.round(pL() / j);
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
  
  private float I(float paramFloat)
  {
    if (this.aHj == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.aHj.x) / this.scale;
  }
  
  private float J(float paramFloat)
  {
    if (this.aHj == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.aHj.y) / this.scale;
  }
  
  private float M(float paramFloat)
  {
    AppMethodBeat.i(157442);
    paramFloat = Math.max(pN(), paramFloat);
    AppMethodBeat.o(157442);
    return paramFloat;
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
    if (this.aHj == null)
    {
      AppMethodBeat.o(157437);
      return null;
    }
    paramPointF.set(I(paramFloat1), J(paramFloat2));
    AppMethodBeat.o(157437);
    return paramPointF;
  }
  
  private void a(Point paramPoint)
  {
    try
    {
      AppMethodBeat.i(157417);
      h("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
      this.aHY = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      a(true, this.aHY);
      this.aGE = H(this.aHY.scale);
      b(paramPoint);
      paramPoint = ((List)this.aGL.get(Integer.valueOf(this.aGE))).iterator();
      while (paramPoint.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)paramPoint.next();
        Log.i(this.TAG, "alvinluo tile fullSampleSize: %d", new Object[] { Integer.valueOf(this.aGE) });
        a(locale);
      }
      aH(true);
    }
    finally {}
    AppMethodBeat.o(157417);
  }
  
  private void a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    AppMethodBeat.i(157412);
    paramPointF1 = new b(paramFloat, paramPointF1, paramPointF2, (byte)0);
    paramPointF1.aIQ = false;
    paramPointF1.duration = this.aHc;
    paramPointF1.aIS = 2;
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
    parame = aIg.a(this, this.aGd, parame);
    parame.px();
    this.aIi.add(parame);
    AppMethodBeat.o(157393);
  }
  
  private void a(boolean paramBoolean, g paramg)
  {
    float f2 = 0.5F;
    AppMethodBeat.i(157421);
    boolean bool = paramBoolean;
    if (this.aGQ == 2)
    {
      bool = paramBoolean;
      if (this.aHP) {
        bool = false;
      }
    }
    PointF localPointF = paramg.aHj;
    float f4 = M(paramg.scale);
    float f3 = f4 * pL();
    float f5 = f4 * pM();
    float f1;
    if ((this.aGQ == 3) && (this.aHP))
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
      if ((this.aGQ != 3) || (!this.aHP)) {
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
  
  private void aH(boolean paramBoolean)
  {
    AppMethodBeat.i(157418);
    if ((this.aGd == null) || (this.aGL == null))
    {
      AppMethodBeat.o(157418);
      return;
    }
    int j = Math.min(this.aGE, H(this.scale));
    Iterator localIterator1 = this.aGL.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)localIterator2.next();
        if ((locale.sampleSize < j) || ((locale.sampleSize > j) && (locale.sampleSize != this.aGE)))
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
          float f1 = I(0.0F);
          float f2 = I(getWidth());
          float f3 = J(0.0F);
          float f4 = J(getHeight());
          if ((f1 <= locale.aGg.right) && (locale.aGg.left <= f2) && (f3 <= locale.aGg.bottom) && (locale.aGg.top <= f4)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label328;
            }
            locale.visible = true;
            if ((locale.aGh) || (locale.bitmap != null) || (!paramBoolean)) {
              break;
            }
            a(locale);
            break;
          }
          label328:
          if (locale.sampleSize != this.aGE)
          {
            locale.visible = false;
            if (locale.bitmap != null)
            {
              locale.bitmap.recycle();
              locale.bitmap = null;
            }
          }
        }
        else if (locale.sampleSize == this.aGE)
        {
          locale.visible = true;
        }
      }
    }
    AppMethodBeat.o(157418);
  }
  
  private void aI(boolean paramBoolean)
  {
    AppMethodBeat.i(157422);
    int i;
    if (this.aHj == null)
    {
      i = 1;
      this.aHj = new PointF(0.0F, 0.0F);
    }
    for (;;)
    {
      if (this.aHY == null) {
        this.aHY = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      }
      this.aHY.scale = this.scale;
      this.aHY.aHj.set(this.aHj);
      a(paramBoolean, this.aHY);
      this.scale = this.aHY.scale;
      this.aHj.set(this.aHY.aHj);
      if ((i != 0) && (this.aGR != 4)) {
        this.aHj.set(h(pL() / 2, pM() / 2, this.scale));
      }
      AppMethodBeat.o(157422);
      return;
      i = 0;
    }
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
    if (this.aHj == null)
    {
      AppMethodBeat.o(157439);
      return null;
    }
    paramPointF.set(K(paramFloat1), L(paramFloat2));
    AppMethodBeat.o(157439);
    return paramPointF;
  }
  
  private void b(float paramFloat, PointF paramPointF)
  {
    AppMethodBeat.i(209456);
    Log.i(this.TAG, "alvinluo sendStateChanged oldScale: %s, %s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.scale) });
    if ((this.aHS != null) && (this.scale != paramFloat)) {
      this.aHS.o(this.scale, paramFloat);
    }
    if ((this.aHS != null) && (!this.aHj.equals(paramPointF))) {
      getCenter();
    }
    AppMethodBeat.o(209456);
  }
  
  private void b(Point paramPoint)
  {
    AppMethodBeat.i(157423);
    h("initialiseTileMap maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
    this.aGL = new LinkedHashMap();
    int i = this.aGE;
    int j = 1;
    int m = 1;
    int k = pL() / j;
    int i2 = pM() / m;
    int n = k / i;
    int i1 = i2 / i;
    while ((n + j + 1 > paramPoint.x) || ((n > getWidth() * 1.25D) && (i < this.aGE)))
    {
      j += 1;
      k = pL() / j;
      n = k / i;
    }
    for (;;)
    {
      if ((i1 + m + 1 > paramPoint.y) || ((i1 > getHeight() * 1.25D) && (i < this.aGE)))
      {
        m += 1;
        n = pM() / m;
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
            if (i == this.aGE)
            {
              bool = true;
              locale.visible = bool;
              if (i1 != j - 1) {
                break label385;
              }
              i3 = pL();
              label286:
              if (i2 != m - 1) {
                break label397;
              }
            }
            label385:
            label397:
            for (int i4 = pM();; i4 = (i2 + 1) * n)
            {
              locale.aGg = new Rect(i1 * k, i2 * n, i3, i4);
              locale.aGi = new Rect(0, 0, 0, 0);
              locale.aGj = new Rect(locale.aGg);
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
        this.aGL.put(Integer.valueOf(i), localArrayList);
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
  
  private static float d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
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
    float f1 = this.aIn;
    if (this.aIl * 0.7F > f1) {
      f1 = this.aIl;
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 < 1.0D) {
        f2 = 1.0F;
      }
      f1 = f2;
      if (f2 > this.aGN) {
        f1 = this.aGN;
      }
      return f1;
      if (this.aIm * 0.7F > f1) {
        f1 = this.aIm;
      } else {
        f1 = this.aIn * this.aGZ;
      }
    }
  }
  
  public static Bitmap.Config getPreferredBitmapConfig()
  {
    return aIe;
  }
  
  private PointF h(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(157440);
    int i = getPaddingLeft();
    int j = (getWidth() - getPaddingRight() - getPaddingLeft()) / 2;
    int k = getPaddingTop();
    int m = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2;
    if (this.aHY == null) {
      this.aHY = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
    }
    this.aHY.scale = paramFloat3;
    this.aHY.aHj.set(i + j - paramFloat1 * paramFloat3, k + m - paramFloat2 * paramFloat3);
    a(true, this.aHY);
    PointF localPointF = this.aHY.aHj;
    AppMethodBeat.o(157440);
    return localPointF;
  }
  
  private void pB()
  {
    AppMethodBeat.i(157398);
    Log.i(this.TAG, "alvinluo initScaleRate: %f", new Object[] { Float.valueOf(this.aIn) });
    pD();
    pE();
    AppMethodBeat.o(157398);
  }
  
  private void pC()
  {
    AppMethodBeat.i(209386);
    if (this.bitmap == null)
    {
      AppMethodBeat.o(209386);
      return;
    }
    if (!this.aGA)
    {
      AppMethodBeat.o(209386);
      return;
    }
    int i = pL();
    int j = pM();
    boolean bool;
    if (i > j * 2.2F)
    {
      bool = true;
      this.aGK = bool;
      if (j <= i * 2.2F) {
        break label272;
      }
      bool = true;
      label77:
      this.aGJ = bool;
      if ((!this.aGK) || (i <= this.aIj)) {
        break label277;
      }
      bool = true;
      label99:
      this.aGK = bool;
      if ((!this.aGJ) || (j <= this.aIk)) {
        break label282;
      }
      bool = true;
      label121:
      this.aGJ = bool;
      pB();
      if (!this.aGJ) {
        break label287;
      }
      this.aIo = (this.aIj * 1.0F / pJ());
      this.aIp = (this.aIk * 1.0F / pK());
    }
    for (;;)
    {
      Log.i(this.TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f, previewHeight: %d, previewWidth: %d, verticalLong: %b, horizontalLong: %b, %s", new Object[] { Float.valueOf(this.aIo), Float.valueOf(this.aIp), Integer.valueOf(pK()), Integer.valueOf(pJ()), Boolean.valueOf(this.aGJ), Boolean.valueOf(this.aGK), this.aHs.getUri().toString() });
      AppMethodBeat.o(209386);
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
      if (this.aGK)
      {
        this.aIo = (this.aIj * 1.0F / pJ());
        this.aIp = (this.aIn * pM() / pK());
      }
      else
      {
        this.aIo = (this.aIn * pL() / pJ());
        this.aIp = (this.aIn * pM() / pK());
      }
    }
  }
  
  private void pD()
  {
    AppMethodBeat.i(157399);
    this.aGN = (getDoubleTapZoomScale() * 2.0F * this.aIq);
    AppMethodBeat.o(157399);
  }
  
  private void pE()
  {
    AppMethodBeat.i(157400);
    this.aGO = Math.min(pN(), this.aIn * 0.75F);
    AppMethodBeat.o(157400);
  }
  
  private boolean pF()
  {
    AppMethodBeat.i(157414);
    if ((this.bitmap != null) && (!this.aGA))
    {
      AppMethodBeat.o(157414);
      return true;
    }
    if (this.aGL != null)
    {
      Iterator localIterator = this.aGL.entrySet().iterator();
      boolean bool2;
      for (boolean bool1 = true; localIterator.hasNext(); bool1 = bool2)
      {
        Object localObject = (Map.Entry)localIterator.next();
        bool2 = bool1;
        if (((Integer)((Map.Entry)localObject).getKey()).intValue() == this.aGE)
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject).next();
            if ((locale.aGh) || (locale.bitmap == null)) {
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
  
  private boolean pG()
  {
    AppMethodBeat.i(157415);
    if ((getWidth() > 0) && (getHeight() > 0) && (this.aGp > 0) && (this.aGq > 0) && ((this.bitmap != null) || (pF()))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.aHP) && (bool))
      {
        pI();
        this.aHP = true;
      }
      AppMethodBeat.o(157415);
      return bool;
    }
  }
  
  private boolean pH()
  {
    AppMethodBeat.i(157416);
    boolean bool = pF();
    if ((!this.aHQ) && (bool))
    {
      pI();
      this.aHQ = true;
      Log.i(this.TAG, "alvinluo onImageLoaded");
      pB();
      a(this.aIn, new PointF(0.0F, 0.0F));
      if (this.aGG != -1L)
      {
        this.aGH = System.currentTimeMillis();
        dN((int)(this.aGH - this.aGG));
      }
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(157384);
          if ((SubsamplingScaleImageView.v(SubsamplingScaleImageView.this) != null) && (!SubsamplingScaleImageView.v(SubsamplingScaleImageView.this).isRecycled()))
          {
            Log.i(SubsamplingScaleImageView.m(SubsamplingScaleImageView.this), "alvinluo rotateAndScale fullImageBitmap");
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.b(SubsamplingScaleImageView.v(SubsamplingScaleImageView.this), SubsamplingScaleImageView.u(SubsamplingScaleImageView.this)));
          }
          SubsamplingScaleImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157383);
              if (SubsamplingScaleImageView.w(SubsamplingScaleImageView.this) != null) {
                SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).i(SubsamplingScaleImageView.v(SubsamplingScaleImageView.this));
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
  
  private void pI()
  {
    AppMethodBeat.i(157419);
    if ((getWidth() == 0) || (getHeight() == 0) || (this.aGp <= 0) || (this.aGq <= 0))
    {
      AppMethodBeat.o(157419);
      return;
    }
    if ((this.aHp != null) && (this.aHo != null))
    {
      this.scale = this.aHo.floatValue();
      if (this.aHj == null) {
        this.aHj = new PointF();
      }
      this.aHj.x = (getWidth() / 2 - this.scale * this.aHp.x);
      this.aHj.y = (getHeight() / 2 - this.scale * this.aHp.y);
      this.aHp = null;
      this.aHo = null;
      this.aHr = false;
      aI(true);
      aH(true);
    }
    aI(false);
    AppMethodBeat.o(157419);
  }
  
  private int pJ()
  {
    AppMethodBeat.i(157431);
    if ((this.bitmap == null) || (!this.aGA))
    {
      AppMethodBeat.o(157431);
      return 0;
    }
    int i = this.aHv;
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
  
  private int pK()
  {
    AppMethodBeat.i(157432);
    if ((this.bitmap == null) || (!this.aGA))
    {
      AppMethodBeat.o(157432);
      return 0;
    }
    int i = this.aHv;
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
  
  private int pL()
  {
    AppMethodBeat.i(157433);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.aGq;
      AppMethodBeat.o(157433);
      return i;
    }
    i = this.aGp;
    AppMethodBeat.o(157433);
    return i;
  }
  
  private int pM()
  {
    AppMethodBeat.i(157434);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.aGp;
      AppMethodBeat.o(157434);
      return i;
    }
    i = this.aGq;
    AppMethodBeat.o(157434);
    return i;
  }
  
  private float pN()
  {
    AppMethodBeat.i(157441);
    int i = getPaddingBottom() + getPaddingTop();
    int j = getPaddingLeft() + getPaddingRight();
    if ((this.aGR == 2) || (this.aGR == 4))
    {
      f = Math.max((getWidth() - j) / pL(), (getHeight() - i) / pM());
      AppMethodBeat.o(157441);
      return f;
    }
    if ((this.aGR == 3) && (this.aGO > 0.0F))
    {
      f = this.aGO;
      AppMethodBeat.o(157441);
      return f;
    }
    float f = Math.min((getWidth() - j) / pL(), (getHeight() - i) / pM());
    AppMethodBeat.o(157441);
    return f;
  }
  
  private int px(int paramInt)
  {
    return (int)(this.density * paramInt);
  }
  
  private void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(157410);
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
    {
      Log.i(this.TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b, allowInterceptTouch: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aHf) });
      if (!this.aHf)
      {
        this.aHg = true;
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
    this.aHi = 0.0F;
    this.aHj = null;
    this.aHk = null;
    this.aHl = null;
    this.aHo = Float.valueOf(0.0F);
    this.aHp = null;
    this.aHq = null;
    this.aHx = false;
    this.aHy = false;
    this.aHz = false;
    this.aHA = 0;
    this.aGE = 0;
    this.aHG = null;
    this.aHH = 0.0F;
    this.aHJ = 0.0F;
    this.aHK = false;
    this.aHM = null;
    this.aHL = null;
    this.aHN = null;
    this.aHO = null;
    this.aHY = null;
    this.aHZ = null;
    this.aIa = null;
    Object localObject1;
    if (paramBoolean)
    {
      if (this.aIx != null)
      {
        localObject1 = this.aIx;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aGm = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aGk = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aGm = 0;
      }
      this.uri = null;
      this.aFV.writeLock().lock();
    }
    com.davemorrissey.labs.subscaleview.c.e locale;
    label512:
    try
    {
      if (this.aGd != null)
      {
        this.aGd.recycle();
        this.aGd = null;
      }
      this.aFV.writeLock().unlock();
      if ((this.bitmap != null) && (!this.aGD)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aGD) && (this.aHR != null)) {
        this.aHR.pQ();
      }
      this.aGp = 0;
      this.aGq = 0;
      this.aHu = 0;
      this.aGr = null;
      this.aHw = null;
      this.aHP = false;
      this.aHQ = false;
      this.bitmap = null;
      this.aGA = false;
      this.aGD = false;
      this.aGB = false;
      this.aGC = false;
      this.aGF = true;
      if (this.aGL == null) {
        break label534;
      }
      localObject1 = this.aGL.entrySet().iterator();
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
            if (this.aHt == null) {
              break label489;
            }
            if (this.aHt.bitmap != locale.bitmap) {
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
      this.aFV.writeLock().unlock();
      AppMethodBeat.o(157404);
    }
    label529:
    this.aGL = null;
    label534:
    setGestureDetector(getContext());
    AppMethodBeat.o(157404);
  }
  
  public static void setBitmapLoaderImp(com.davemorrissey.labs.subscaleview.c.a parama)
  {
    aIf = parama;
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
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.b(paramBitmap, SubsamplingScaleImageView.u(SubsamplingScaleImageView.this)));
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
    this.aHB = new GestureDetector(paramContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(209621);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(209621);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157378);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
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
          if (!SubsamplingScaleImageView.pO().contains(Integer.valueOf(1)))
          {
            paramAnonymousMotionEvent1 = new IllegalArgumentException("Unknown easing type: 1");
            AppMethodBeat.o(157376);
            throw paramAnonymousMotionEvent1;
          }
          paramAnonymousMotionEvent1.aIR = 1;
          paramAnonymousMotionEvent1.aIX = false;
          paramAnonymousMotionEvent1.aIS = 3;
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
        AppMethodBeat.i(209618);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(209618);
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
        AppMethodBeat.i(209616);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(209616);
        return bool;
      }
    });
    this.aHD = new GestureDetector(paramContext, new SubsamplingScaleImageView.4(this));
    AppMethodBeat.o(157405);
  }
  
  public static void setPreferredBitmapConfig(Bitmap.Config paramConfig)
  {
    aIe = paramConfig;
  }
  
  public static void setTileInitLoaderImp(com.davemorrissey.labs.subscaleview.c.c paramc)
  {
    aIh = paramc;
  }
  
  public static void setTileLoaderImp(com.davemorrissey.labs.subscaleview.c.d paramd)
  {
    aIg = paramd;
  }
  
  public final float K(float paramFloat)
  {
    if (this.aHj == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.aHj.x;
  }
  
  public final float L(float paramFloat)
  {
    if (this.aHj == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.aHj.y;
  }
  
  public final float a(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(209409);
    float f2;
    int i;
    label121:
    float f1;
    if (!this.aGW)
    {
      if (this.aHq != null)
      {
        paramPointF1.x = this.aHq.x;
        paramPointF1.y = this.aHq.y;
      }
    }
    else
    {
      f2 = getDoubleTapZoomScale();
      Log.i(this.TAG, "alvinluo doubleTapZoom %f, scale: %s, mScaleRate: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.scale), Float.valueOf(this.aIn) });
      if ((this.scale > f2 * 0.9D) && (this.scale != this.aIn)) {
        break label180;
      }
      i = 1;
      if (i == 0) {
        break label186;
      }
      f1 = f2;
      label129:
      if (this.aHa != 3) {
        break label194;
      }
      a(f1, paramPointF1);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(209409);
      return f1;
      paramPointF1.x = (pL() / 2);
      paramPointF1.y = (pM() / 2);
      break;
      label180:
      i = 0;
      break label121;
      label186:
      f1 = this.aIn;
      break label129;
      label194:
      if ((this.aHa == 2) || (i == 0) || (!this.aGW))
      {
        paramPointF1 = new b(f1, paramPointF1, (byte)0);
        paramPointF1.aIQ = false;
        paramPointF1.duration = this.aHb;
        paramPointF1.aIS = 4;
        paramPointF1.start();
      }
      else if (this.aHa == 1)
      {
        paramPointF1 = new b(f2, paramPointF1, paramPointF2, (byte)0);
        paramPointF1.aIQ = false;
        paramPointF1.duration = this.aHb;
        paramPointF1.aIS = 4;
        paramPointF1.start();
      }
    }
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
    this.aHO = null;
    this.aHr = true;
    this.aHo = Float.valueOf(paramFloat);
    this.aHp = paramPointF;
    this.aHq = paramPointF;
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
        if (this.aHQ)
        {
          if (this.bitmap != null) {
            this.bitmap.recycle();
          }
          AppMethodBeat.o(157428);
          return;
        }
        if (this.aHw != null)
        {
          if ((this.aHw.width() > 0) && (this.aHw.height() > 0))
          {
            this.bitmap = Bitmap.createBitmap(paramBitmap, this.aHw.left, this.aHw.top, this.aHw.width(), this.aHw.height());
            this.aHv = 0;
          }
          this.aGA = true;
          this.aGC = false;
          this.previewWidth = this.bitmap.getWidth();
          this.previewHeight = this.bitmap.getHeight();
          pC();
          this.aGC = true;
          if (pG())
          {
            invalidate();
            requestLayout();
          }
          dM((int)(System.currentTimeMillis() - l));
          Log.i(this.TAG, "alvinluo onPreviewLoaded");
          if ((!this.aGB) && (this.aHR != null)) {
            this.aHR.pP();
          }
          AppMethodBeat.o(157428);
          continue;
        }
        if (paramInteger == null) {
          break label283;
        }
      }
      finally {}
      this.aHv = paramInteger.intValue();
      label283:
      this.bitmap = paramBitmap;
    }
  }
  
  public final void a(com.davemorrissey.labs.subscaleview.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(157424);
      h("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.aGp), Integer.valueOf(this.aGq), Integer.valueOf(paramInt3) });
      if ((this.aGp > 0) && (this.aGq > 0) && ((this.aGp != paramInt1) || (this.aGq != paramInt2)))
      {
        reset(false);
        if (this.bitmap != null)
        {
          if (!this.aGD) {
            this.bitmap.recycle();
          }
          this.bitmap = null;
          if ((this.aHR != null) && (this.aGD)) {
            this.aHR.pQ();
          }
          this.aGA = false;
          this.aGD = false;
        }
      }
      this.aGd = paramd;
      this.aGp = paramInt1;
      this.aGq = paramInt2;
      this.aHu = paramInt3;
      pG();
      if ((!pH()) && (this.aGT > 0) && (this.aGT != aGS) && (this.aGU > 0) && (this.aGU != aGS) && (getWidth() > 0) && (getHeight() > 0)) {
        a(new Point(this.aGT, this.aGU));
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
    this.aHs = parama1;
    this.aHt = parama2;
    reset(true);
    if (parama1.getUri() != null) {
      this.aHu = c(getContext(), parama1.getUri());
    }
    if (parama2 != null)
    {
      if ((parama1.aGp > 0) && (parama1.aGq > 0)) {
        break label157;
      }
      Log.e(this.TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
    }
    while ((parama1.bitmap != null) && (parama1.aGr != null))
    {
      b(Bitmap.createBitmap(parama1.bitmap, parama1.aGr.left, parama1.aGr.top, parama1.aGr.width(), parama1.aGr.height()), 0, false);
      AppMethodBeat.o(157403);
      return;
      label157:
      this.aGp = parama1.aGp;
      this.aGq = parama1.aGq;
      this.aHw = parama2.aGr;
      if (parama2.bitmap != null)
      {
        this.aGD = parama2.aGs;
        a(parama2.bitmap, Integer.valueOf(0));
      }
      else
      {
        Uri localUri2 = parama2.getUri();
        Uri localUri1 = localUri2;
        if (localUri2 == null)
        {
          localUri1 = localUri2;
          if (parama2.aGn != null) {
            localUri1 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama2.aGn);
          }
        }
        aIf.a(this, getContext(), this.aHE, localUri1, true).px();
      }
    }
    if (parama1.bitmap != null)
    {
      b(parama1.bitmap, 0, parama1.aGs);
      AppMethodBeat.o(157403);
      return;
    }
    this.aGr = parama1.aGr;
    this.uri = parama1.getUri();
    if ((this.uri == null) && (parama1.aGn != null)) {
      this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama1.aGn);
    }
    if ((parama1.aGo) || (this.aGr != null))
    {
      aIh.a(this, getContext(), this.aHF, this.uri).px();
      AppMethodBeat.o(157403);
      return;
    }
    aIf.a(this, getContext(), this.aHE, this.uri, false).px();
    AppMethodBeat.o(157403);
  }
  
  public final Bitmap b(Bitmap paramBitmap, int paramInt)
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
        aIe = Bitmap.Config.RGB_565;
        AppMethodBeat.o(157427);
        return null;
      }
    }
    AppMethodBeat.o(157427);
    return null;
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
      if ((this.aGp > 0) && (this.aGq > 0) && ((this.aGp != paramBitmap.getWidth()) || (this.aGq != paramBitmap.getHeight()))) {
        reset(false);
      }
      if ((this.bitmap != null) && (!this.aGD)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aGD) && (this.aHR != null)) {
        this.aHR.pQ();
      }
      this.aGA = false;
      this.aGD = paramBoolean;
      this.bitmap = paramBitmap;
      this.aGp = paramBitmap.getWidth();
      this.aGq = paramBitmap.getHeight();
      this.aHu = paramInt;
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(157382);
          long l1 = System.currentTimeMillis();
          if (paramInt != 0) {
            SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.b(paramBitmap, paramInt));
          }
          long l2 = System.currentTimeMillis();
          Log.i(SubsamplingScaleImageView.m(SubsamplingScaleImageView.this), "alvinluo onImageLoaded rotaeAndScaleBitmap %d", new Object[] { Long.valueOf(l2 - l1) });
          SubsamplingScaleImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157381);
              if ((SubsamplingScaleImageView.6.this.aIG) || (SubsamplingScaleImageView.6.this.aIH))
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
    //   4: ldc_w 1399
    //   7: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokestatic 1072	java/lang/System:currentTimeMillis	()J
    //   14: putfield 312	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aGG	J
    //   17: aload_0
    //   18: getfield 306	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   21: astore 4
    //   23: aload_1
    //   24: getfield 844	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   27: istore_2
    //   28: aload_1
    //   29: getfield 849	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   32: ifnonnull +166 -> 198
    //   35: aload 4
    //   37: ldc_w 1401
    //   40: iconst_2
    //   41: anewarray 294	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: iload_2
    //   47: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: iload_3
    //   54: invokestatic 1025	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 1377	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_1
    //   62: getfield 844	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   65: aload_0
    //   66: getfield 723	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aGE	I
    //   69: if_icmpne +40 -> 109
    //   72: aload_1
    //   73: getfield 849	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   76: ifnull +33 -> 109
    //   79: aload_0
    //   80: getfield 308	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aGF	Z
    //   83: ifeq +26 -> 109
    //   86: aload_0
    //   87: getfield 306	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   90: ldc_w 1403
    //   93: invokestatic 787	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 308	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aGF	Z
    //   101: aload_0
    //   102: aload_1
    //   103: getfield 849	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   106: putfield 655	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aGI	Landroid/graphics/Bitmap;
    //   109: aload_0
    //   110: invokespecial 1277	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:pG	()Z
    //   113: pop
    //   114: aload_0
    //   115: invokespecial 1294	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:pH	()Z
    //   118: pop
    //   119: aload_0
    //   120: invokespecial 1055	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:pF	()Z
    //   123: ifeq +62 -> 185
    //   126: aload_0
    //   127: getfield 879	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   130: ifnull +55 -> 185
    //   133: aload_0
    //   134: getfield 1175	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aGD	Z
    //   137: ifne +10 -> 147
    //   140: aload_0
    //   141: getfield 879	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   144: invokevirtual 852	android/graphics/Bitmap:recycle	()V
    //   147: aload_0
    //   148: aconst_null
    //   149: putfield 879	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   152: aload_0
    //   153: getfield 1177	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aHR	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   156: ifnull +19 -> 175
    //   159: aload_0
    //   160: getfield 1175	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aGD	Z
    //   163: ifeq +12 -> 175
    //   166: aload_0
    //   167: getfield 1177	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aHR	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   170: invokeinterface 1180 1 0
    //   175: aload_0
    //   176: iconst_0
    //   177: putfield 1001	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aGA	Z
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 1175	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aGD	Z
    //   185: aload_0
    //   186: invokevirtual 1242	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:invalidate	()V
    //   189: ldc_w 1399
    //   192: invokestatic 274	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public final int c(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc_w 1408
    //   9: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: ldc_w 1410
    //   15: aload_2
    //   16: invokevirtual 1413	android/net/Uri:getScheme	()Ljava/lang/String;
    //   19: invokevirtual 1414	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +168 -> 190
    //   25: aload_1
    //   26: invokevirtual 1418	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: aload_2
    //   30: iconst_1
    //   31: anewarray 503	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc_w 1420
    //   39: aastore
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 1426	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +86 -> 134
    //   51: aload_1
    //   52: invokeinterface 1431 1 0
    //   57: ifeq +77 -> 134
    //   60: aload_1
    //   61: iconst_0
    //   62: invokeinterface 1434 2 0
    //   67: istore_3
    //   68: getstatic 236	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aGv	Ljava/util/List;
    //   71: iload_3
    //   72: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokeinterface 1437 2 0
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
    //   100: invokeinterface 1440 1 0
    //   105: iload_3
    //   106: istore 4
    //   108: ldc_w 1408
    //   111: invokestatic 274	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: iload 4
    //   116: ireturn
    //   117: aload_0
    //   118: getfield 306	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   121: ldc_w 1442
    //   124: iload_3
    //   125: invokestatic 632	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   128: invokevirtual 636	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   131: invokestatic 1444	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: iconst_0
    //   135: istore_3
    //   136: goto -44 -> 92
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 306	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   146: ldc_w 1446
    //   149: invokestatic 1444	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_1
    //   153: ifnull +252 -> 405
    //   156: aload_1
    //   157: invokeinterface 1440 1 0
    //   162: iconst_0
    //   163: istore 4
    //   165: goto -57 -> 108
    //   168: astore_1
    //   169: aload 7
    //   171: astore_2
    //   172: aload_2
    //   173: ifnull +9 -> 182
    //   176: aload_2
    //   177: invokeinterface 1440 1 0
    //   182: ldc_w 1408
    //   185: invokestatic 274	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    //   190: aload_2
    //   191: invokestatic 1451	com/tencent/mm/vfs/u:q	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   194: astore 7
    //   196: new 1453	androidx/e/a/a
    //   199: dup
    //   200: aload 7
    //   202: invokespecial 1456	androidx/e/a/a:<init>	(Ljava/io/InputStream;)V
    //   205: ldc_w 1458
    //   208: iconst_1
    //   209: invokevirtual 1461	androidx/e/a/a:i	(Ljava/lang/String;I)I
    //   212: istore_3
    //   213: iload_3
    //   214: iconst_1
    //   215: if_icmpeq +7 -> 222
    //   218: iload_3
    //   219: ifne +41 -> 260
    //   222: iconst_0
    //   223: istore_3
    //   224: iload_3
    //   225: istore 4
    //   227: aload 7
    //   229: ifnull -121 -> 108
    //   232: aload 7
    //   234: invokevirtual 1464	java/io/InputStream:close	()V
    //   237: iload_3
    //   238: istore 4
    //   240: goto -132 -> 108
    //   243: astore_1
    //   244: aload_0
    //   245: getfield 306	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   248: ldc_w 1466
    //   251: invokestatic 1444	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: iload_3
    //   255: istore 4
    //   257: goto -149 -> 108
    //   260: iload_3
    //   261: bipush 6
    //   263: if_icmpne +9 -> 272
    //   266: bipush 90
    //   268: istore_3
    //   269: goto -45 -> 224
    //   272: iload_3
    //   273: iconst_3
    //   274: if_icmpne +10 -> 284
    //   277: sipush 180
    //   280: istore_3
    //   281: goto -57 -> 224
    //   284: iload_3
    //   285: bipush 8
    //   287: if_icmpne +10 -> 297
    //   290: sipush 270
    //   293: istore_3
    //   294: goto -70 -> 224
    //   297: aload_0
    //   298: getfield 306	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   301: ldc_w 1468
    //   304: iload_3
    //   305: invokestatic 632	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   308: invokevirtual 636	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   311: invokestatic 1444	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: iconst_0
    //   315: istore_3
    //   316: goto -92 -> 224
    //   319: astore_2
    //   320: ldc_w 1408
    //   323: invokestatic 274	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_2
    //   327: athrow
    //   328: astore_1
    //   329: aload 7
    //   331: ifnull +12 -> 343
    //   334: aload_2
    //   335: ifnull +27 -> 362
    //   338: aload 7
    //   340: invokevirtual 1464	java/io/InputStream:close	()V
    //   343: ldc_w 1408
    //   346: invokestatic 274	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: aload_1
    //   350: athrow
    //   351: astore 6
    //   353: aload_2
    //   354: aload 6
    //   356: invokevirtual 1472	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   359: goto -16 -> 343
    //   362: aload 7
    //   364: invokevirtual 1464	java/io/InputStream:close	()V
    //   367: goto -24 -> 343
    //   370: astore_1
    //   371: aload 6
    //   373: astore_2
    //   374: goto -45 -> 329
    //   377: astore_2
    //   378: aload_1
    //   379: astore 6
    //   381: aload_2
    //   382: astore_1
    //   383: aload 6
    //   385: astore_2
    //   386: goto -214 -> 172
    //   389: astore_2
    //   390: aload_1
    //   391: astore 6
    //   393: aload_2
    //   394: astore_1
    //   395: aload 6
    //   397: astore_2
    //   398: goto -226 -> 172
    //   401: astore_2
    //   402: goto -260 -> 142
    //   405: iconst_0
    //   406: istore 4
    //   408: goto -300 -> 108
    //   411: astore_1
    //   412: iconst_0
    //   413: istore_3
    //   414: goto -170 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	SubsamplingScaleImageView
    //   0	417	1	paramContext	Context
    //   0	417	2	paramUri	Uri
    //   67	347	3	i	int
    //   93	314	4	j	int
    //   80	3	5	bool	boolean
    //   1	1	6	localObject	Object
    //   351	21	6	localThrowable	java.lang.Throwable
    //   379	17	6	localContext	Context
    //   4	359	7	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   25	47	139	java/lang/Exception
    //   25	47	168	finally
    //   232	237	243	java/lang/Exception
    //   196	213	319	java/lang/Throwable
    //   297	314	319	java/lang/Throwable
    //   320	328	328	finally
    //   338	343	351	java/lang/Throwable
    //   196	213	370	finally
    //   297	314	370	finally
    //   51	82	377	finally
    //   117	134	377	finally
    //   142	152	389	finally
    //   51	82	401	java/lang/Exception
    //   117	134	401	java/lang/Exception
    //   190	196	411	java/lang/Exception
    //   338	343	411	java/lang/Exception
    //   343	351	411	java/lang/Exception
    //   353	359	411	java/lang/Exception
    //   362	367	411	java/lang/Exception
  }
  
  public final void dL(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157388);
      if (this.aIx != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aIx;
        locala.aGl += paramInt;
        Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aGl) });
      }
      AppMethodBeat.o(157388);
      return;
    }
    finally {}
  }
  
  public final void dM(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157389);
      if (this.aIx != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aIx;
        locala.aGk += paramInt;
        Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aGk) });
      }
      AppMethodBeat.o(157389);
      return;
    }
    finally {}
  }
  
  public final void dN(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157390);
      if (this.aIx != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aIx;
        locala.aGm += paramInt;
        Log.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aGm) });
      }
      AppMethodBeat.o(157390);
      return;
    }
    finally {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157408);
    Log.d(this.TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
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
    return this.aFV;
  }
  
  public Bitmap getFullImageBitmap()
  {
    return this.aGI;
  }
  
  public int getFullImageSampleSize()
  {
    return this.aGE;
  }
  
  public com.davemorrissey.labs.subscaleview.d.a getImageDecodeRecord()
  {
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala = this.aIx;
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
    AppMethodBeat.i(209372);
    if ((Float.isNaN(this.scale)) || (Float.isInfinite(this.scale)))
    {
      localPointF = new PointF(1.0F, 1.0F);
      AppMethodBeat.o(209372);
      return localPointF;
    }
    PointF localPointF = new PointF(this.scale, this.scale);
    AppMethodBeat.o(209372);
    return localPointF;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(209374);
    if (this.aHj != null)
    {
      PointF localPointF = new PointF(this.aHj.x, this.aHj.y);
      AppMethodBeat.o(209374);
      return localPointF;
    }
    AppMethodBeat.o(209374);
    return null;
  }
  
  public float getMaxScale()
  {
    return this.aGN;
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(157453);
    float f = pN();
    AppMethodBeat.o(157453);
    return f;
  }
  
  public e getOnImageEventListener()
  {
    return this.aHR;
  }
  
  public final int getOrientation()
  {
    return this.FO;
  }
  
  public int getPreviewHeight()
  {
    return this.previewHeight;
  }
  
  public int getPreviewOrientation()
  {
    return this.aHv;
  }
  
  public int getPreviewWidth()
  {
    return this.previewWidth;
  }
  
  public int getRequiredRotation()
  {
    if (this.FO == -1) {
      return this.aHu;
    }
    return this.FO;
  }
  
  public final int getSHeight()
  {
    return this.aGq;
  }
  
  public final int getSWidth()
  {
    return this.aGp;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  public final b getState()
  {
    AppMethodBeat.i(157458);
    if ((this.aHj != null) && (this.aGp > 0) && (this.aGq > 0))
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
    return this.aGr;
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
    if (this.aIv != null) {
      this.aIv.onViewAttachedToWindow(this);
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
      Log.i(this.TAG, "alvinluo cancelAllTileLoadTask, task size: %d", new Object[] { Integer.valueOf(this.aIi.size()) });
      Iterator localIterator = this.aIi.iterator();
      while (localIterator.hasNext()) {
        ((com.davemorrissey.labs.subscaleview.c.b)localIterator.next()).cancel();
      }
      this.aIi.clear();
    }
    if (this.aIv != null) {
      this.aIv.onViewDetachedFromWindow(this);
    }
    AppMethodBeat.o(157392);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(157413);
    super.onDraw(paramCanvas);
    System.currentTimeMillis();
    if (this.aHU == null)
    {
      this.aHU = new Paint();
      this.aHU.setAntiAlias(true);
      this.aHU.setFilterBitmap(true);
      this.aHU.setDither(true);
    }
    if (((this.aHV == null) || (this.aHW == null)) && (this.aGM))
    {
      this.aHV = new Paint();
      this.aHV.setTextSize(px(20));
      this.aHV.setColor(-65281);
      this.aHV.setStyle(Paint.Style.FILL);
      this.aHW = new Paint();
      this.aHW.setColor(-65281);
      this.aHW.setStyle(Paint.Style.STROKE);
      this.aHW.setStrokeWidth(px(1));
    }
    if ((this.aGp == 0) || (this.aGq == 0) || (getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(157413);
      return;
    }
    int j;
    int k;
    if ((this.aGL == null) && (this.aGd != null))
    {
      j = Math.min(paramCanvas.getMaximumBitmapWidth(), this.aGT);
      k = Math.min(paramCanvas.getMaximumBitmapHeight(), this.aGU);
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
    if (!pG())
    {
      AppMethodBeat.o(157413);
      return;
    }
    if (this.aHd) {
      pI();
    }
    float f1;
    boolean bool1;
    boolean bool2;
    if ((this.aHO != null) && (this.aHO.aIO != null))
    {
      f1 = this.scale;
      if (this.aHl == null) {
        this.aHl = new PointF(0.0F, 0.0F);
      }
      this.aHl.set(this.aHj);
      long l = System.currentTimeMillis() - this.aHO.time;
      if (l > this.aHO.duration)
      {
        bool1 = true;
        l = Math.min(l, this.aHO.duration);
        this.scale = a(this.aHO.aIR, l, this.aHO.aHi, this.aHO.aIK - this.aHO.aHi, this.aHO.duration);
        f2 = a(this.aHO.aIR, l, this.aHO.aIO.x, this.aHO.aIP.x - this.aHO.aIO.x, this.aHO.duration);
        float f3 = a(this.aHO.aIR, l, this.aHO.aIO.y, this.aHO.aIP.y - this.aHO.aIO.y, this.aHO.duration);
        localObject1 = this.aHj;
        ((PointF)localObject1).x -= K(this.aHO.aIM.x) - f2;
        localObject1 = this.aHj;
        ((PointF)localObject1).y -= L(this.aHO.aIM.y) - f3;
        if ((!bool1) && (this.aHO.aHi != this.aHO.aIK)) {
          break label898;
        }
        bool2 = true;
        label683:
        aI(bool2);
        b(f1, this.aHl);
        aH(bool1);
        if (bool1) {
          this.aHO = null;
        }
        invalidate();
      }
    }
    else
    {
      if ((this.aGL == null) || (!pF()) || (!this.aIs)) {
        break label1812;
      }
      k = Math.min(this.aGE, H(this.scale));
      localObject1 = this.aGL.entrySet().iterator();
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
          localObject3 = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject2).next();
          if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).visible) && ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGh) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null))) {
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
    Object localObject1 = this.aGL.entrySet().iterator();
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
              localObject3 = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject2).next();
              Rect localRect = ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGg;
              ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.set((int)K(localRect.left), (int)L(localRect.top), (int)K(localRect.right), (int)L(localRect.bottom));
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGh) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null)) {
                break label1752;
              }
              if (this.aHX != null) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi, this.aHX);
              }
              if (this.aHZ == null) {
                this.aHZ = new Matrix();
              }
              this.aHZ.reset();
              a(this.aIb, 0.0F, 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight());
              if (getRequiredRotation() != 0) {
                break label1477;
              }
              a(this.aIc, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.bottom);
              label1264:
              this.aHZ.setPolyToPoly(this.aIb, 0, this.aIc, 0, 4);
              if (!((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.isRecycled()) {
                paramCanvas.drawBitmap(((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap, this.aHZ, this.aHU);
              }
              if (this.aGM) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi, this.aHW);
              }
            }
            for (;;)
            {
              if ((!((com.davemorrissey.labs.subscaleview.c.e)localObject3).visible) || (!this.aGM)) {
                break label1810;
              }
              paramCanvas.drawText("ISS " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).sampleSize + " RECT " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGg.top + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGg.left + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGg.bottom + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGg.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.top + px(15), this.aHV);
              break label989;
              break;
              label1477:
              if (getRequiredRotation() == 90)
              {
                a(this.aIc, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.top);
                break label1264;
              }
              if (getRequiredRotation() == 180)
              {
                a(this.aIc, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.top);
                break label1264;
              }
              if (getRequiredRotation() != 270) {
                break label1264;
              }
              a(this.aIc, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.bottom);
              break label1264;
              label1752:
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGh) && (this.aGM)) {
                paramCanvas.drawText("LOADING", ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aGi.top + px(35), this.aHV);
              }
            }
          }
          label1812:
          if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
          {
            Log.d(this.TAG, "alvinluo onDraw bitmap scale: %f", new Object[] { Float.valueOf(this.scale) });
            if ((!this.aGA) || (this.aGC))
            {
              if (this.aHZ == null) {
                this.aHZ = new Matrix();
              }
              this.aHZ.reset();
              i = this.bitmap.getWidth();
              j = this.bitmap.getHeight();
              if ((this.aHv == 90) || (this.aHv == 270))
              {
                i = this.bitmap.getHeight();
                j = this.bitmap.getWidth();
              }
              if (this.aGA)
              {
                f1 = i / 2.0F;
                f2 = j / 2.0F;
                pC();
                this.aHZ.postScale(this.aIo, this.aIp, f1, f2);
              }
              f1 = (this.aIj - this.bitmap.getWidth()) / 2;
              f2 = (this.aIk - this.bitmap.getHeight()) / 2;
              this.aHZ.postTranslate(f1, f2);
              Log.d(this.TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
              if (this.aHX != null)
              {
                if (this.aIa == null) {
                  this.aIa = new RectF();
                }
                localObject1 = this.aIa;
                if (!this.aGA) {
                  break label2895;
                }
                f1 = this.bitmap.getWidth();
                if (!this.aGA) {
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
    for (float f2 = this.bitmap.getHeight();; f2 = this.aGq)
    {
      ((RectF)localObject1).set(0.0F, 0.0F, f1, f2);
      this.aHZ.mapRect(this.aIa);
      paramCanvas.drawRect(this.aIa, this.aHX);
      paramCanvas.drawBitmap(this.bitmap, this.aHZ, this.aHU);
      if (this.aGM)
      {
        Log.d(this.TAG, "alvinluo onDraw debug vTranslate %f, %f", new Object[] { Float.valueOf(this.aHj.x), Float.valueOf(this.aHj.y) });
        paramCanvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.scale) }) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(pN()) }) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aGN) }) + ")", px(5), px(15), this.aHV);
        paramCanvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aHj.x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aHj.y) }), px(5), px(30), this.aHV);
        localObject1 = getCenter();
        paramCanvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).y) }), px(5), px(45), this.aHV);
        if (this.aHO != null)
        {
          localObject1 = b(this.aHO.aIL);
          localObject2 = b(this.aHO.aIN);
          localObject3 = b(this.aHO.aIM);
          paramCanvas.drawCircle(((PointF)localObject1).x, ((PointF)localObject1).y, px(10), this.aHW);
          this.aHW.setColor(-65536);
          paramCanvas.drawCircle(((PointF)localObject2).x, ((PointF)localObject2).y, px(20), this.aHW);
          this.aHW.setColor(-16776961);
          paramCanvas.drawCircle(((PointF)localObject3).x, ((PointF)localObject3).y, px(25), this.aHW);
          this.aHW.setColor(-16711936);
          paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.aHW);
        }
        if (this.aHG != null)
        {
          this.aHW.setColor(-65536);
          paramCanvas.drawCircle(this.aHG.x, this.aHG.y, px(20), this.aHW);
        }
        if (this.aHM != null)
        {
          this.aHW.setColor(-16776961);
          paramCanvas.drawCircle(K(this.aHM.x), L(this.aHM.y), px(35), this.aHW);
        }
        if ((this.aHN != null) && (this.aHz))
        {
          this.aHW.setColor(-12303292);
          paramCanvas.drawCircle(this.aHN.x, this.aHN.y, px(30), this.aHW);
        }
        this.aHW.setColor(-65281);
      }
      AppMethodBeat.o(157413);
      return;
      f1 = this.aGp;
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
        break label212;
      }
      i = 1;
      label47:
      if ((this.aGp <= 0) || (this.aGq <= 0)) {
        break label273;
      }
      if ((paramInt2 == 0) || (i == 0)) {
        break label217;
      }
      paramInt2 = pL();
      paramInt1 = pM();
    }
    for (;;)
    {
      label79:
      paramInt2 = Math.max(paramInt2, getSuggestedMinimumWidth());
      paramInt1 = Math.max(paramInt1, getSuggestedMinimumHeight());
      setMeasuredDimension(paramInt2, paramInt1);
      if ((paramInt2 != this.aIj) || (paramInt1 != this.aIk))
      {
        this.aIj = paramInt2;
        this.aIk = paramInt1;
      }
      for (boolean bool = true;; bool = false)
      {
        if ((bool) && (this.aHd)) {
          invalidate();
        }
        Log.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d, needRefresh: %s, canRefresh: %s", new Object[] { Integer.valueOf(this.aIj), Integer.valueOf(this.aIk), Boolean.valueOf(bool), Boolean.valueOf(this.aHd) });
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
          paramInt1 = (int)(pM() / pL() * j);
          paramInt2 = j;
          break label79;
        }
        if (paramInt2 == 0) {
          break label273;
        }
        paramInt2 = (int)(pL() / pM() * paramInt1);
        break label79;
      }
      label273:
      paramInt2 = j;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(157406);
    h("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(this.scale), this.aHo, Boolean.valueOf(this.aHr) });
    pB();
    PointF localPointF = getCenter();
    if (((this.aHP) || (this.aHr)) && (localPointF != null))
    {
      this.aHO = null;
      if (!this.aHr)
      {
        this.aHo = Float.valueOf(this.scale);
        this.aHp = localPointF;
      }
    }
    AppMethodBeat.o(157406);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157409);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    Log.v(this.TAG, "alvinluo SubSamplingScaleImageView onTouchEvent: %d, lastMotionEvent: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), this.aHh });
    if ((!this.aHf) && (this.aHh != null) && (this.aHh.getAction() == paramMotionEvent.getAction()) && (paramMotionEvent.getAction() == 0))
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(157409);
      return true;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 1) || (i == 6) || (i == 3)) {}
    for (this.aHh = null;; this.aHh = paramMotionEvent)
    {
      if (this.aIw != null) {
        this.aIw.onTouch(this, paramMotionEvent);
      }
      if ((this.aHO == null) || (this.aHO.aIQ)) {
        break;
      }
      requestDisallowInterceptTouchEvent(true);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(157409);
      return true;
    }
    this.aHO = null;
    if (this.aHj == null)
    {
      if (this.aHD != null)
      {
        localObject = this.aHD;
        paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramMotionEvent.aFh(), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(157409);
      return true;
    }
    if (!this.aHz) {
      if (this.aHB != null)
      {
        localObject = this.aHB;
        com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (!com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sf(0)), "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z")) {}
      }
      else
      {
        this.aHx = false;
        this.aHy = false;
        this.aHA = 0;
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(157409);
        return true;
      }
    }
    if (this.aHk == null) {
      this.aHk = new PointF(0.0F, 0.0F);
    }
    if (this.aHl == null) {
      this.aHl = new PointF(0.0F, 0.0F);
    }
    if (this.aHG == null) {
      this.aHG = new PointF(0.0F, 0.0F);
    }
    float f3 = this.scale;
    this.aHl.set(this.aHj);
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
        b(f3, this.aHl);
        bool2 = super.onTouchEvent(paramMotionEvent);
        Log.v(this.TAG, "alvinluo onTouchEvent super: %b, handled: %b, allowInterceptTouch: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(this.aHf) });
        if (!this.aHf) {
          break label3270;
        }
        if ((!bool1) && (!bool2)) {
          break;
        }
        bool1 = true;
        com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(157409);
        return bool1;
        this.aIC = paramMotionEvent.getRawX();
        this.aID = paramMotionEvent.getRawY();
        this.aHO = null;
        requestDisallowInterceptTouchEvent(true);
        this.aHA = Math.max(this.aHA, i);
        if (i >= 2) {
          if (this.aGX)
          {
            f1 = d(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
            this.aHi = this.scale;
            this.aHH = f1;
            this.aHk.set(this.aHj.x, this.aHj.y);
            this.aHG.set((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F, (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
            this.handler.removeMessages(1);
          }
        }
        for (;;)
        {
          if (!this.aHf) {
            break label1017;
          }
          bool1 = true;
          break;
          this.aHA = 0;
          break label920;
          if (!this.aHz)
          {
            this.aHk.set(this.aHj.x, this.aHj.y);
            this.aHG.set(paramMotionEvent.getX(), paramMotionEvent.getY());
            Log.i(this.TAG, "pennqin, delay time 601 ms.");
            this.handler.sendEmptyMessageDelayed(1, 601L);
          }
        }
        bool1 = false;
      }
    case 2: 
      bool2 = false;
      bool1 = bool2;
      if (this.aHA > 0)
      {
        if (i < 2) {
          break label1752;
        }
        f4 = d(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
        f5 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
        f6 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
        this.aIu = new PointF(f5, f6);
        bool1 = bool2;
        if (this.aGX) {
          if ((d(this.aHG.x, f5, this.aHG.y, f6) <= 5.0F) && (Math.abs(f4 - this.aHH) <= 5.0F))
          {
            bool1 = bool2;
            if (!this.aHy) {}
          }
          else
          {
            this.aHx = true;
            this.aHy = true;
            d = this.scale;
            f2 = f4 / this.aHH * this.aHi;
            f1 = f2;
            if (f2 >= this.aGN * 2.0F)
            {
              f1 = this.aGN;
              f1 = (f2 - this.aGN) * 0.1F + f1 * 2.0F;
            }
            this.scale = f1;
            Log.d(this.TAG, "alvinluo zoom preScale: %f, scale: %f, minScale: %f, maxScale: %f", new Object[] { Double.valueOf(d), Float.valueOf(this.scale), Float.valueOf(pN()), Float.valueOf(this.aGN) });
            if (this.scale > pN()) {
              break label1416;
            }
            this.aHH = f4;
            this.aHi = pN();
            this.aHG.set(f5, f6);
            this.aHk.set(this.aHj);
          }
        }
      }
      for (;;)
      {
        aI(true);
        aH(this.aGV);
        bool1 = true;
        Log.d(this.TAG, "alvinluo Action_Move consumed: %b", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break;
        }
        this.handler.removeMessages(1);
        invalidate();
        bool1 = true;
        break label671;
        if (this.aGW)
        {
          f1 = this.aHG.x;
          f2 = this.aHk.x;
          f7 = this.aHG.y;
          f8 = this.aHk.y;
          float f9 = this.scale / this.aHi;
          float f10 = this.scale / this.aHi;
          this.aHj.x = (f5 - (f1 - f2) * f9);
          this.aHj.y = (f6 - (f7 - f8) * f10);
          if (((pM() * d < getHeight()) && (this.scale * pM() >= getHeight())) || ((d * pL() < getWidth()) && (this.scale * pL() >= getWidth())))
          {
            aI(true);
            this.aHG.set(f5, f6);
            this.aHk.set(this.aHj);
            this.aHi = this.scale;
            this.aHH = f4;
          }
        }
        else if (this.aHq != null)
        {
          this.aHj.x = (getWidth() / 2 - this.scale * this.aHq.x);
          this.aHj.y = (getHeight() / 2 - this.scale * this.aHq.y);
        }
        else
        {
          this.aHj.x = (getWidth() / 2 - this.scale * (pL() / 2));
          this.aHj.y = (getHeight() / 2 - this.scale * (pM() / 2));
        }
      }
      label1752:
      if (this.aHz)
      {
        f2 = Math.abs(this.aHN.y - paramMotionEvent.getY()) * 2.0F + this.aHI;
        if (this.aHJ == -1.0F) {
          this.aHJ = f2;
        }
        if (paramMotionEvent.getY() > this.aHL.y)
        {
          i = 1;
          this.aHL.set(0.0F, paramMotionEvent.getY());
          f4 = 0.5F * Math.abs(1.0F - f2 / this.aHJ);
          if (f4 <= 0.03F)
          {
            f1 = f2;
            if (!this.aHK) {
              break;
            }
          }
          else
          {
            this.aHK = true;
            if (this.aHJ <= 0.0F) {
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
      this.scale = Math.max(pN(), Math.min(this.aGN, f1 * this.scale));
      if (this.aGW)
      {
        f1 = this.aHG.x;
        f4 = this.aHk.x;
        f5 = this.aHG.y;
        f6 = this.aHk.y;
        f7 = this.scale / this.aHi;
        f8 = this.scale / this.aHi;
        this.aHj.x = (this.aHG.x - (f1 - f4) * f7);
        this.aHj.y = (this.aHG.y - (f5 - f6) * f8);
        if (((pM() * d >= getHeight()) || (this.scale * pM() < getHeight())) && ((pL() * d >= getWidth()) || (this.scale * pL() < getWidth()))) {
          break label3303;
        }
        aI(true);
        this.aHG.set(b(this.aHM));
        this.aHk.set(this.aHj);
        this.aHi = this.scale;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.aHJ = f1;
        aI(true);
        aH(this.aGV);
        bool1 = true;
        break label1371;
        i = 0;
        break label1818;
        label2178:
        f1 = 1.0F - f4;
        break label1893;
        if (this.aHq != null)
        {
          this.aHj.x = (getWidth() / 2 - this.scale * this.aHq.x);
          this.aHj.y = (getHeight() / 2 - this.scale * this.aHq.y);
          f1 = f2;
        }
        else
        {
          this.aHj.x = (getWidth() / 2 - this.scale * (pL() / 2));
          this.aHj.y = (getHeight() / 2 - this.scale * (pM() / 2));
          f1 = f2;
          continue;
          bool1 = bool2;
          if (this.aHx) {
            break label1371;
          }
          f1 = Math.abs(paramMotionEvent.getX() - this.aHG.x);
          f2 = Math.abs(paramMotionEvent.getY() - this.aHG.y);
          f4 = this.density * 5.0F;
          if ((f1 <= f4) && (f2 <= f4))
          {
            bool1 = bool2;
            if (!this.aHy) {
              break label1371;
            }
          }
          this.aHj.x = (this.aHk.x + (paramMotionEvent.getX() - this.aHG.x));
          this.aHj.y = (this.aHk.y + (paramMotionEvent.getY() - this.aHG.y));
          f5 = this.aHj.x;
          f6 = this.aHj.y;
          aI(true);
          label2491:
          label2507:
          boolean bool3;
          label2530:
          boolean bool4;
          label2553:
          boolean bool5;
          if (f5 != this.aHj.x)
          {
            bool1 = true;
            if (f6 == this.aHj.y) {
              break label2792;
            }
            bool2 = true;
            if ((!bool1) || (f1 <= f2) || (this.aHy)) {
              break label2798;
            }
            bool3 = true;
            if ((!bool2) || (f2 <= f1) || (this.aHy)) {
              break label2804;
            }
            bool4 = true;
            if ((f6 != this.aHj.y) || (f2 <= 3.0F * f4)) {
              break label2810;
            }
            bool5 = true;
            label2581:
            Log.v(this.TAG, "alvinluo Action_Move edge atXEdge: %b, atYEdge: %b, edgeXSwipe: %b, edgeYSwipe: %b, yPan: %b, isPanning: %b,dx: %f, dy: %f, offset: %f", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(this.aHy), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f4) });
            if ((bool3) || (bool4) || ((bool1) && (bool2) && (!bool5) && (!this.aHy))) {
              break label2816;
            }
            this.aHy = true;
            bool1 = true;
          }
          for (;;)
          {
            bool2 = bool1;
            if (!this.aGW)
            {
              this.aHj.x = this.aHk.x;
              this.aHj.y = this.aHk.y;
              requestDisallowInterceptTouchEvent(false);
              bool2 = bool1;
              if (!this.aHf) {
                bool2 = false;
              }
            }
            aH(this.aGV);
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
              this.aHA = 0;
              this.handler.removeMessages(1);
              requestDisallowInterceptTouchEvent(false);
              if (!this.aHf)
              {
                bool1 = false;
                continue;
                this.handler.removeMessages(1);
                if ((paramMotionEvent.getAction() == 3) && (this.aHg)) {
                  this.aHg = false;
                }
                if (this.aHz)
                {
                  this.aHz = false;
                  if (!this.aHK) {
                    a(this.aHM, this.aHG);
                  }
                }
                if ((this.aHA > 0) && ((this.aHx) || (this.aHy)))
                {
                  if ((this.aHx) && (i == 2))
                  {
                    this.aHy = true;
                    this.aHk.set(this.aHj.x, this.aHj.y);
                    if (paramMotionEvent.getActionIndex() != 1) {
                      break label3132;
                    }
                    this.aHG.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
                    label3008:
                    if (this.scale > this.aIn) {
                      break label3152;
                    }
                    Log.i(this.TAG, "alvinluo scale %f less than %f, and need to reset", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.aIn) });
                    localObject = new PointF(this.aIj / 2, this.aIk / 2);
                    a((PointF)localObject, (PointF)localObject, this.aIn);
                    this.aHy = false;
                  }
                  for (;;)
                  {
                    if (i < 3) {
                      this.aHx = false;
                    }
                    if (i < 2)
                    {
                      this.aHy = false;
                      this.aHA = 0;
                    }
                    aH(true);
                    bool1 = true;
                    break;
                    label3132:
                    this.aHG.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
                    break label3008;
                    label3152:
                    if (this.scale > getDoubleTapZoomScale() * 2.0F)
                    {
                      Log.i(this.TAG, "alvinluo current scale %f larger than maxScale: %f, and reset to scale: %f", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.aGN), Float.valueOf(getDoubleTapZoomScale() * 2.0F) });
                      a(a(this.aIu), this.aIu, getDoubleTapZoomScale() * 2.0F);
                    }
                  }
                }
                if (i == 1)
                {
                  this.aHx = false;
                  this.aHy = false;
                  this.aHA = 0;
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
    this.aHf = paramBoolean;
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
    this.aHE = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
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
    this.aHE = paramb;
    AppMethodBeat.o(157448);
  }
  
  public void setCanRefresh(boolean paramBoolean)
  {
    this.aHd = paramBoolean;
  }
  
  public final void setDebug(boolean paramBoolean)
  {
    this.aGM = paramBoolean;
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
    this.aHb = Math.max(0, paramInt);
    AppMethodBeat.o(157463);
  }
  
  public final void setDoubleTapZoomScale(float paramFloat)
  {
    this.aGZ = paramFloat;
  }
  
  public final void setDoubleTapZoomStyle(int paramInt)
  {
    AppMethodBeat.i(157462);
    if (!aGw.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid zoom style: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157462);
      throw localIllegalArgumentException;
    }
    this.aHa = paramInt;
    AppMethodBeat.o(157462);
  }
  
  public void setEagerLoadingEnabled(boolean paramBoolean)
  {
    this.aGV = paramBoolean;
  }
  
  public void setEdgeSwipeListener(c paramc)
  {
    this.aIy = paramc;
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
    this.aHC = paramSimpleOnGestureListener;
  }
  
  public final void setImage(a parama)
  {
    AppMethodBeat.i(157402);
    a(parama, null);
    AppMethodBeat.o(157402);
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(209390);
    if (this.aHj == null) {
      this.aHj = new PointF();
    }
    paramMatrix.getValues(this.aHm);
    this.aHj.set(this.aHm[2], this.aHm[5]);
    float f = this.scale;
    this.scale = this.aHm[0];
    if (this.aHS != null) {
      this.aHS.o(this.scale, f);
    }
    aI(false);
    invalidate();
    AppMethodBeat.o(209390);
  }
  
  public final void setMaxScale(float paramFloat)
  {
    this.aGN = paramFloat;
  }
  
  public void setMaxTileSize(int paramInt)
  {
    this.aGT = paramInt;
    this.aGU = paramInt;
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
    this.aGO = paramFloat;
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
    if (!aGz.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid scale type: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157450);
      throw localIllegalArgumentException;
    }
    this.aGR = paramInt;
    if (this.aHP)
    {
      aI(true);
      invalidate();
    }
    AppMethodBeat.o(157450);
  }
  
  public void setMinimumTileDpi(int paramInt)
  {
    AppMethodBeat.i(157454);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    this.aGP = ((int)Math.min((localDisplayMetrics.ydpi + f) / 2.0F, paramInt));
    if (this.aHP)
    {
      reset(false);
      invalidate();
    }
    AppMethodBeat.o(157454);
  }
  
  public void setOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.aIv = paramOnAttachStateChangeListener;
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.aHe = paramOnDoubleTapListener;
  }
  
  public void setOnImageEventListener(e parame)
  {
    this.aHR = parame;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.aHT = paramOnLongClickListener;
  }
  
  public void setOnStateChangedListener(SubsamplingScaleImageView.f paramf)
  {
    this.aHS = paramf;
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(157396);
    if (!aGv.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid orientation: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157396);
      throw localIllegalArgumentException;
    }
    this.FO = paramInt;
    reset(false);
    invalidate();
    requestLayout();
    AppMethodBeat.o(157396);
  }
  
  public final void setPanEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(157459);
    this.aGW = paramBoolean;
    if ((!paramBoolean) && (this.aHj != null))
    {
      this.aHj.x = (getWidth() / 2 - this.scale * (pL() / 2));
      this.aHj.y = (getHeight() / 2 - this.scale * (pM() / 2));
      if (this.aHP)
      {
        aH(true);
        invalidate();
      }
    }
    AppMethodBeat.o(157459);
  }
  
  public final void setPanLimit(int paramInt)
  {
    AppMethodBeat.i(157449);
    if (!aGy.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid pan limit: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157449);
      throw localIllegalArgumentException;
    }
    this.aGQ = paramInt;
    if (this.aHP)
    {
      aI(true);
      invalidate();
    }
    AppMethodBeat.o(157449);
  }
  
  public void setPreviewDone(boolean paramBoolean)
  {
    AppMethodBeat.i(157395);
    this.aIs = paramBoolean;
    invalidate();
    AppMethodBeat.o(157395);
  }
  
  public final void setQuickScaleEnabled(boolean paramBoolean)
  {
    this.aGY = paramBoolean;
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
    this.aHF = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
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
    this.aHF = paramb;
    AppMethodBeat.o(157446);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(157397);
    this.aIn = paramFloat;
    this.aGN = 2.0F;
    this.aGO = 1.0F;
    pD();
    pE();
    AppMethodBeat.o(157397);
  }
  
  public final void setTileBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(157460);
    if (Color.alpha(paramInt) == 0) {
      this.aHX = null;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(157460);
      return;
      this.aHX = new Paint();
      this.aHX.setStyle(Paint.Style.FILL);
      this.aHX.setColor(paramInt);
    }
  }
  
  public final void setZoomEnabled(boolean paramBoolean)
  {
    this.aGX = paramBoolean;
  }
  
  public void setsRegion(Rect paramRect)
  {
    this.aGr = paramRect;
  }
  
  static final class a
  {
    float aHi;
    float aIK;
    PointF aIL;
    PointF aIM;
    PointF aIN;
    PointF aIO;
    PointF aIP;
    boolean aIQ;
    int aIR;
    int aIS;
    SubsamplingScaleImageView.d aIT;
    long duration;
    long time;
    
    private a()
    {
      AppMethodBeat.i(157385);
      this.duration = 200L;
      this.aIQ = true;
      this.aIR = 2;
      this.aIS = 1;
      this.time = System.currentTimeMillis();
      AppMethodBeat.o(157385);
    }
  }
  
  public final class b
  {
    public boolean aIQ;
    int aIR;
    public int aIS;
    private SubsamplingScaleImageView.d aIT;
    private final float aIU;
    private final PointF aIV;
    private final PointF aIW;
    boolean aIX;
    public long duration;
    
    private b(float paramFloat, PointF paramPointF)
    {
      this.duration = 500L;
      this.aIR = 2;
      this.aIS = 1;
      this.aIQ = true;
      this.aIX = true;
      this.aIU = paramFloat;
      this.aIV = paramPointF;
      this.aIW = null;
    }
    
    private b(float paramFloat, PointF paramPointF1, PointF paramPointF2)
    {
      this.duration = 500L;
      this.aIR = 2;
      this.aIS = 1;
      this.aIQ = true;
      this.aIX = true;
      this.aIU = paramFloat;
      this.aIV = paramPointF1;
      this.aIW = paramPointF2;
    }
    
    private b(PointF paramPointF)
    {
      AppMethodBeat.i(157386);
      this.duration = 500L;
      this.aIR = 2;
      this.aIS = 1;
      this.aIQ = true;
      this.aIX = true;
      this.aIU = SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
      this.aIV = paramPointF;
      this.aIW = null;
      AppMethodBeat.o(157386);
    }
    
    public final void start()
    {
      AppMethodBeat.i(157387);
      if ((SubsamplingScaleImageView.x(SubsamplingScaleImageView.this) != null) && (SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIT != null)) {}
      try
      {
        SubsamplingScaleImageView.x(SubsamplingScaleImageView.this);
        int i = SubsamplingScaleImageView.this.getPaddingLeft();
        int j = (SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight() - SubsamplingScaleImageView.this.getPaddingLeft()) / 2;
        int k = SubsamplingScaleImageView.this.getPaddingTop();
        int m = (SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom() - SubsamplingScaleImageView.this.getPaddingTop()) / 2;
        float f3 = SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, this.aIU);
        if (this.aIX)
        {
          Object localObject = SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, this.aIV.x, this.aIV.y, f3, new PointF());
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, new SubsamplingScaleImageView.a((byte)0));
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aHi = SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIK = f3;
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).time = System.currentTimeMillis();
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIN = ((PointF)localObject);
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIL = SubsamplingScaleImageView.this.getCenter();
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIM = ((PointF)localObject);
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIO = SubsamplingScaleImageView.this.b((PointF)localObject);
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIP = new PointF(j + i, m + k);
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).duration = this.duration;
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIQ = this.aIQ;
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIR = this.aIR;
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIS = this.aIS;
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).time = System.currentTimeMillis();
          SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIT = this.aIT;
          if (this.aIW != null)
          {
            float f1 = this.aIW.x - SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIL.x * f3;
            float f2 = this.aIW.y - SubsamplingScaleImageView.x(SubsamplingScaleImageView.this).aIL.y * f3;
            localObject = new SubsamplingScaleImageView.g(f3, new PointF(f1, f2), (byte)0);
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, (SubsamplingScaleImageView.g)localObject);
            SubsamplingScaleImageView.a locala = SubsamplingScaleImageView.x(SubsamplingScaleImageView.this);
            f3 = this.aIW.x;
            float f4 = ((SubsamplingScaleImageView.g)localObject).aHj.x;
            float f5 = this.aIW.y;
            locala.aIP = new PointF(f4 - f1 + f3, ((SubsamplingScaleImageView.g)localObject).aHj.y - f2 + f5);
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
          PointF localPointF = this.aIV;
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
    
    public abstract void i(Bitmap paramBitmap);
    
    public abstract void pP();
    
    public abstract void pQ();
  }
  
  static final class g
  {
    PointF aHj;
    float scale;
    
    private g(float paramFloat, PointF paramPointF)
    {
      this.scale = paramFloat;
      this.aHj = paramPointF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView
 * JD-Core Version:    0.7.0.1
 */