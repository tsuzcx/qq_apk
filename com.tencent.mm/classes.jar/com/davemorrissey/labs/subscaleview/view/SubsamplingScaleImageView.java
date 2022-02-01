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
import com.tencent.mm.sdk.platformtools.ad;
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
  private static final List<Integer> aMc;
  private static final List<Integer> aMd;
  private static final List<Integer> aMe;
  private static final List<Integer> aMf;
  private static final List<Integer> aMg;
  public static int aMz;
  private static Bitmap.Config aND;
  private static com.davemorrissey.labs.subscaleview.c.a aNE;
  private static com.davemorrissey.labs.subscaleview.c.d aNF;
  private static com.davemorrissey.labs.subscaleview.c.c aNG;
  private final String TAG;
  private final ReadWriteLock aLF;
  private com.davemorrissey.labs.subscaleview.a.d aLM;
  public int aLY;
  public int aLZ;
  private int aMA;
  private int aMB;
  private boolean aMC;
  private boolean aMD;
  private boolean aME;
  private boolean aMF;
  private float aMG;
  private int aMH;
  private int aMI;
  private int aMJ;
  private float aMK;
  private PointF aML;
  private PointF aMM;
  private PointF aMN;
  private Float aMO;
  private PointF aMP;
  private PointF aMQ;
  private boolean aMR;
  private a aMS;
  private a aMT;
  private int aMU;
  private int aMV;
  private Rect aMW;
  private boolean aMX;
  private boolean aMY;
  private boolean aMZ;
  private Rect aMa;
  private boolean aMh;
  private boolean aMi;
  private boolean aMj;
  private int aMk;
  private int aMl;
  private boolean aMm;
  private int aMn;
  private boolean aMo;
  private long aMp;
  private long aMq;
  private Bitmap aMr;
  private Map<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> aMs;
  private boolean aMt;
  private float aMu;
  private float aMv;
  private int aMw;
  private int aMx;
  private int aMy;
  private float[] aNA;
  private float[] aNB;
  private Matrix aNC;
  private LinkedList<com.davemorrissey.labs.subscaleview.c.b> aNH;
  private int aNI;
  private int aNJ;
  private float aNK;
  private float aNL;
  public float aNM;
  private float aNN;
  private float aNO;
  private float aNP;
  private float aNQ;
  private boolean aNR;
  private boolean aNS;
  private PointF aNT;
  private View.OnAttachStateChangeListener aNU;
  private com.davemorrissey.labs.subscaleview.d.a aNV;
  private c aNW;
  private boolean aNX;
  private boolean aNY;
  private boolean aNZ;
  private int aNa;
  private GestureDetector aNb;
  private GestureDetector.SimpleOnGestureListener aNc;
  private GestureDetector aNd;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aNe;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aNf;
  private PointF aNg;
  private float aNh;
  private final float aNi;
  private float aNj;
  private boolean aNk;
  private PointF aNl;
  private PointF aNm;
  private PointF aNn;
  private a aNo;
  private boolean aNp;
  private boolean aNq;
  private e aNr;
  private f aNs;
  private View.OnLongClickListener aNt;
  private Paint aNu;
  private Paint aNv;
  private Paint aNw;
  private Paint aNx;
  private g aNy;
  private RectF aNz;
  private float aOa;
  private float aOb;
  private Bitmap bitmap;
  private boolean cancelled;
  private Matrix dY;
  private float density;
  public Executor executor;
  private Handler handler;
  private int orientation;
  private float scale;
  private Uri uri;
  
  static
  {
    AppMethodBeat.i(157473);
    aMc = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1) });
    aMd = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    aMe = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
    aMf = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    aMg = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4) });
    aMz = 2147483647;
    aND = Bitmap.Config.ARGB_8888;
    aNE = new com.davemorrissey.labs.subscaleview.b.a();
    aNF = new com.davemorrissey.labs.subscaleview.b.c();
    aNG = new com.davemorrissey.labs.subscaleview.b.b();
    AppMethodBeat.o(157473);
  }
  
  public SubsamplingScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(157394);
    this.TAG = (SubsamplingScaleImageView.class.getSimpleName() + hashCode());
    this.aMo = true;
    this.aMp = -1L;
    this.aMq = -1L;
    this.aMt = false;
    this.orientation = -1;
    this.aMu = 2.0F;
    this.aMv = qo();
    this.aMw = -1;
    this.aMx = 1;
    this.aMy = 3;
    this.aMA = aMz;
    this.aMB = aMz;
    this.aMC = true;
    this.aMD = true;
    this.aME = true;
    this.aMF = true;
    this.aMG = 2.0F;
    this.aMH = 1;
    this.aMI = 200;
    this.aMJ = 200;
    this.aMV = 0;
    this.aLF = new ReentrantReadWriteLock(true);
    this.aNe = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.aNf = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.aNA = new float[8];
    this.aNB = new float[8];
    this.aNH = new LinkedList();
    this.cancelled = false;
    this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
    this.aNP = 1.0F;
    this.aNQ = 20.0F;
    this.aNR = true;
    this.aNS = false;
    this.aNV = new com.davemorrissey.labs.subscaleview.d.a();
    this.aNW = new c() {};
    this.aNX = false;
    this.aNY = false;
    this.aNZ = false;
    this.density = getResources().getDisplayMetrics().density;
    setDoubleTapZoomScale(2.0F);
    setMinimumTileDpi(320);
    setGestureDetector(paramContext);
    this.aNC = new Matrix();
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
          setImage(a.U("file:///android_asset/".concat(String.valueOf(str))).qb());
        }
      }
      if (paramAttributeSet.hasValue(3))
      {
        int i = paramAttributeSet.getResourceId(3, 0);
        if (i > 0) {
          setImage(new a(i).qb());
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
    this.aNi = TypedValue.applyDimension(1, 20.0F, paramContext.getResources().getDisplayMetrics());
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aNP = f;
    }
    AppMethodBeat.o(157394);
  }
  
  private int P(float paramFloat)
  {
    AppMethodBeat.i(157420);
    float f = paramFloat;
    if (this.aMw > 0)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      f = localDisplayMetrics.xdpi;
      f = (localDisplayMetrics.ydpi + f) / 2.0F;
      f = paramFloat * (this.aMw / f);
    }
    int j = (int)(qm() * f);
    int i = (int)(qn() * f);
    if ((j == 0) || (i == 0))
    {
      AppMethodBeat.o(157420);
      return 32;
    }
    if ((qn() > i) || (qm() > j))
    {
      i = Math.round(qn() / i);
      j = Math.round(qm() / j);
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
  
  private float Q(float paramFloat)
  {
    if (this.aML == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.aML.x) / this.scale;
  }
  
  private float R(float paramFloat)
  {
    if (this.aML == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.aML.y) / this.scale;
  }
  
  private float S(float paramFloat)
  {
    if (this.aML == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.aML.x;
  }
  
  private float T(float paramFloat)
  {
    if (this.aML == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.aML.y;
  }
  
  private float U(float paramFloat)
  {
    AppMethodBeat.i(157442);
    paramFloat = Math.max(qo(), paramFloat);
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
    if (this.aML == null)
    {
      AppMethodBeat.o(157437);
      return null;
    }
    paramPointF.set(Q(paramFloat1), R(paramFloat2));
    AppMethodBeat.o(157437);
    return paramPointF;
  }
  
  private void a(Point paramPoint)
  {
    try
    {
      AppMethodBeat.i(157417);
      f("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
      this.aNy = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      a(true, this.aNy);
      this.aMn = P(this.aNy.scale);
      b(paramPoint);
      paramPoint = ((List)this.aMs.get(Integer.valueOf(this.aMn))).iterator();
      while (paramPoint.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)paramPoint.next();
        ad.i(this.TAG, "alvinluo tile fullSampleSize: %d", new Object[] { Integer.valueOf(this.aMn) });
        a(locale);
      }
      aJ(true);
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
    if (!this.aMD)
    {
      if (this.aMQ != null)
      {
        paramPointF1.x = this.aMQ.x;
        paramPointF1.y = this.aMQ.y;
      }
    }
    else
    {
      f2 = getDoubleTapZoomScale();
      ad.i(this.TAG, "alvinluo doubleTapZoom %f", new Object[] { Float.valueOf(f2) });
      if ((this.scale > f2 * 0.9D) && (this.scale != this.aNM)) {
        break label159;
      }
      i = 1;
      if (i == 0) {
        break label165;
      }
      f1 = f2;
      label109:
      if (this.aMH != 3) {
        break label173;
      }
      a(f1, paramPointF1);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(157411);
      return;
      paramPointF1.x = (qm() / 2);
      paramPointF1.y = (qn() / 2);
      break;
      label159:
      i = 0;
      break label101;
      label165:
      f1 = this.aNM;
      break label109;
      label173:
      if ((this.aMH == 2) || (i == 0) || (!this.aMD))
      {
        paramPointF1 = new b(f1, paramPointF1, (byte)0);
        paramPointF1.aOo = false;
        paramPointF1.duration = this.aMI;
        paramPointF1.aOq = 4;
        paramPointF1.start();
      }
      else if (this.aMH == 1)
      {
        paramPointF1 = new b(f2, paramPointF1, paramPointF2, (byte)0);
        paramPointF1.aOo = false;
        paramPointF1.duration = this.aMI;
        paramPointF1.aOq = 4;
        paramPointF1.start();
      }
    }
  }
  
  private void a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    AppMethodBeat.i(157412);
    paramPointF1 = new b(paramFloat, paramPointF1, paramPointF2, (byte)0);
    paramPointF1.aOo = false;
    paramPointF1.duration = this.aMJ;
    paramPointF1.aOq = 2;
    paramPointF1.start();
    AppMethodBeat.o(157412);
  }
  
  private void a(com.davemorrissey.labs.subscaleview.c.e parame)
  {
    AppMethodBeat.i(157393);
    if (this.cancelled)
    {
      ad.i(this.TAG, "alvinluo newLoadTask, has cancelled and ignore");
      AppMethodBeat.o(157393);
      return;
    }
    parame = aNF.a(this, this.aLM, parame);
    parame.pY();
    this.aNH.add(parame);
    AppMethodBeat.o(157393);
  }
  
  private void a(boolean paramBoolean, g paramg)
  {
    float f2 = 0.5F;
    AppMethodBeat.i(157421);
    boolean bool = paramBoolean;
    if (this.aMx == 2)
    {
      bool = paramBoolean;
      if (this.aNp) {
        bool = false;
      }
    }
    PointF localPointF = paramg.aML;
    float f4 = U(paramg.scale);
    float f3 = f4 * qm();
    float f5 = f4 * qn();
    float f1;
    if ((this.aMx == 3) && (this.aNp))
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
      if ((this.aMx != 3) || (!this.aNp)) {
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
    if ((this.aLM == null) || (this.aMs == null))
    {
      AppMethodBeat.o(157418);
      return;
    }
    int j = Math.min(this.aMn, P(this.scale));
    Iterator localIterator1 = this.aMs.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)localIterator2.next();
        if ((locale.sampleSize < j) || ((locale.sampleSize > j) && (locale.sampleSize != this.aMn)))
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
          float f1 = Q(0.0F);
          float f2 = Q(getWidth());
          float f3 = R(0.0F);
          float f4 = R(getHeight());
          if ((f1 <= locale.aLP.right) && (locale.aLP.left <= f2) && (f3 <= locale.aLP.bottom) && (locale.aLP.top <= f4)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label328;
            }
            locale.visible = true;
            if ((locale.aLQ) || (locale.bitmap != null) || (!paramBoolean)) {
              break;
            }
            a(locale);
            break;
          }
          label328:
          if (locale.sampleSize != this.aMn)
          {
            locale.visible = false;
            if (locale.bitmap != null)
            {
              locale.bitmap.recycle();
              locale.bitmap = null;
            }
          }
        }
        else if (locale.sampleSize == this.aMn)
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
    if (this.aML == null)
    {
      i = 1;
      this.aML = new PointF(0.0F, 0.0F);
    }
    for (;;)
    {
      if (this.aNy == null) {
        this.aNy = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      }
      this.aNy.scale = this.scale;
      this.aNy.aML.set(this.aML);
      a(paramBoolean, this.aNy);
      this.scale = this.aNy.scale;
      this.aML.set(this.aNy.aML);
      if ((i != 0) && (this.aMy != 4)) {
        this.aML.set(i(qm() / 2, qn() / 2, this.scale));
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
    if (this.aML == null)
    {
      AppMethodBeat.o(157439);
      return null;
    }
    paramPointF.set(S(paramFloat1), T(paramFloat2));
    AppMethodBeat.o(157439);
    return paramPointF;
  }
  
  private void b(Point paramPoint)
  {
    AppMethodBeat.i(157423);
    f("initialiseTileMap maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
    this.aMs = new LinkedHashMap();
    int i = this.aMn;
    int j = 1;
    int m = 1;
    int k = qm() / j;
    int i2 = qn() / m;
    int n = k / i;
    int i1 = i2 / i;
    while ((n + j + 1 > paramPoint.x) || ((n > getWidth() * 1.25D) && (i < this.aMn)))
    {
      j += 1;
      k = qm() / j;
      n = k / i;
    }
    for (;;)
    {
      if ((i1 + m + 1 > paramPoint.y) || ((i1 > getHeight() * 1.25D) && (i < this.aMn)))
      {
        m += 1;
        n = qn() / m;
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
            if (i == this.aMn)
            {
              bool = true;
              locale.visible = bool;
              if (i1 != j - 1) {
                break label385;
              }
              i3 = qm();
              label286:
              if (i2 != m - 1) {
                break label397;
              }
            }
            label385:
            label397:
            for (int i4 = qn();; i4 = (i2 + 1) * n)
            {
              locale.aLP = new Rect(i1 * k, i2 * n, i3, i4);
              locale.aLR = new Rect(0, 0, 0, 0);
              locale.aLS = new Rect(locale.aLP);
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
        this.aMs.put(Integer.valueOf(i), localArrayList);
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
    if ((this.aNs != null) && (!this.aML.equals(paramPointF))) {
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
    float f1 = this.aNM;
    if (this.aNK * 0.7F > f1) {
      f1 = this.aNK;
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 < 1.0D) {
        f2 = 1.0F;
      }
      f1 = f2;
      if (f2 > this.aMu) {
        f1 = this.aMu;
      }
      return f1;
      if (this.aNL * 0.7F > f1) {
        f1 = this.aNL;
      } else {
        f1 = this.aNM * this.aMG;
      }
    }
  }
  
  public static Bitmap.Config getPreferredBitmapConfig()
  {
    return aND;
  }
  
  private PointF i(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(157440);
    int i = getPaddingLeft();
    int j = (getWidth() - getPaddingRight() - getPaddingLeft()) / 2;
    int k = getPaddingTop();
    int m = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2;
    if (this.aNy == null) {
      this.aNy = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
    }
    this.aNy.scale = paramFloat3;
    this.aNy.aML.set(i + j - paramFloat1 * paramFloat3, k + m - paramFloat2 * paramFloat3);
    a(true, this.aNy);
    PointF localPointF = this.aNy.aML;
    AppMethodBeat.o(157440);
    return localPointF;
  }
  
  private int px(int paramInt)
  {
    return (int)(this.density * paramInt);
  }
  
  private void qc()
  {
    AppMethodBeat.i(157398);
    ad.i(this.TAG, "alvinluo initScaleRate: %f", new Object[] { Float.valueOf(this.aNM) });
    qe();
    qf();
    AppMethodBeat.o(157398);
  }
  
  private void qd()
  {
    AppMethodBeat.i(190368);
    if (this.bitmap == null)
    {
      AppMethodBeat.o(190368);
      return;
    }
    if (!this.aMh)
    {
      AppMethodBeat.o(190368);
      return;
    }
    int k = qm();
    int m = qn();
    int i;
    int j;
    label75:
    boolean bool1;
    label90:
    boolean bool2;
    if (k > m * 2.2F)
    {
      i = 1;
      if (m <= k * 2.2F) {
        break label232;
      }
      j = 1;
      if ((i == 0) || (k <= this.aNI)) {
        break label237;
      }
      bool1 = true;
      if ((j == 0) || (m <= this.aNJ)) {
        break label243;
      }
      bool2 = true;
      label106:
      qc();
      if (!bool2) {
        break label249;
      }
      this.aNN = (this.aNI * 1.0F / qk());
      this.aNO = (this.aNJ * 1.0F / ql());
    }
    for (;;)
    {
      ad.i(this.TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f, previewHeight: %d, previewWidth: %d, verticalLong: %b, horizontalLong: %b", new Object[] { Float.valueOf(this.aNN), Float.valueOf(this.aNO), Integer.valueOf(ql()), Integer.valueOf(qk()), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      AppMethodBeat.o(190368);
      return;
      i = 0;
      break;
      label232:
      j = 0;
      break label75;
      label237:
      bool1 = false;
      break label90;
      label243:
      bool2 = false;
      break label106;
      label249:
      if (bool1)
      {
        this.aNN = (this.aNI * 1.0F / qk());
        this.aNO = (this.aNM * qn() / ql());
      }
      else
      {
        this.aNN = (this.aNM * qm() / qk());
        this.aNO = (this.aNM * qn() / ql());
      }
    }
  }
  
  private void qe()
  {
    AppMethodBeat.i(157399);
    this.aMu = (getDoubleTapZoomScale() * 2.0F * this.aNP);
    AppMethodBeat.o(157399);
  }
  
  private void qf()
  {
    AppMethodBeat.i(157400);
    this.aMv = Math.min(qo(), this.aNM * 0.75F);
    AppMethodBeat.o(157400);
  }
  
  private boolean qg()
  {
    AppMethodBeat.i(157414);
    if ((this.bitmap != null) && (!this.aMh))
    {
      AppMethodBeat.o(157414);
      return true;
    }
    if (this.aMs != null)
    {
      Iterator localIterator = this.aMs.entrySet().iterator();
      boolean bool2;
      for (boolean bool1 = true; localIterator.hasNext(); bool1 = bool2)
      {
        Object localObject = (Map.Entry)localIterator.next();
        bool2 = bool1;
        if (((Integer)((Map.Entry)localObject).getKey()).intValue() == this.aMn)
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject).next();
            if ((locale.aLQ) || (locale.bitmap == null)) {
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
  
  private boolean qh()
  {
    AppMethodBeat.i(157415);
    if ((getWidth() > 0) && (getHeight() > 0) && (this.aLY > 0) && (this.aLZ > 0) && ((this.bitmap != null) || (qg()))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.aNp) && (bool))
      {
        qj();
        this.aNp = true;
      }
      AppMethodBeat.o(157415);
      return bool;
    }
  }
  
  private boolean qi()
  {
    AppMethodBeat.i(157416);
    boolean bool = qg();
    if ((!this.aNq) && (bool))
    {
      qj();
      this.aNq = true;
      ad.i(this.TAG, "alvinluo onImageLoaded");
      qc();
      a(this.aNM, new PointF(0.0F, 0.0F));
      if (this.aMp != -1L)
      {
        this.aMq = System.currentTimeMillis();
        dB((int)(this.aMq - this.aMp));
      }
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(157384);
          if ((SubsamplingScaleImageView.u(SubsamplingScaleImageView.this) != null) && (!SubsamplingScaleImageView.u(SubsamplingScaleImageView.this).isRecycled()))
          {
            ad.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo rotateAndScale fullImageBitmap");
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(SubsamplingScaleImageView.u(SubsamplingScaleImageView.this), SubsamplingScaleImageView.t(SubsamplingScaleImageView.this)));
          }
          SubsamplingScaleImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157383);
              if (SubsamplingScaleImageView.v(SubsamplingScaleImageView.this) != null) {
                SubsamplingScaleImageView.v(SubsamplingScaleImageView.this).m(SubsamplingScaleImageView.u(SubsamplingScaleImageView.this));
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
  
  private void qj()
  {
    AppMethodBeat.i(157419);
    if ((getWidth() == 0) || (getHeight() == 0) || (this.aLY <= 0) || (this.aLZ <= 0))
    {
      AppMethodBeat.o(157419);
      return;
    }
    if ((this.aMP != null) && (this.aMO != null))
    {
      this.scale = this.aMO.floatValue();
      if (this.aML == null) {
        this.aML = new PointF();
      }
      this.aML.x = (getWidth() / 2 - this.scale * this.aMP.x);
      this.aML.y = (getHeight() / 2 - this.scale * this.aMP.y);
      this.aMP = null;
      this.aMO = null;
      this.aMR = false;
      aK(true);
      aJ(true);
    }
    aK(false);
    AppMethodBeat.o(157419);
  }
  
  private int qk()
  {
    AppMethodBeat.i(157431);
    if ((this.bitmap == null) || (!this.aMh))
    {
      AppMethodBeat.o(157431);
      return 0;
    }
    int i = this.aMV;
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
  
  private int ql()
  {
    AppMethodBeat.i(157432);
    if ((this.bitmap == null) || (!this.aMh))
    {
      AppMethodBeat.o(157432);
      return 0;
    }
    int i = this.aMV;
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
  
  private int qm()
  {
    AppMethodBeat.i(157433);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.aLZ;
      AppMethodBeat.o(157433);
      return i;
    }
    i = this.aLY;
    AppMethodBeat.o(157433);
    return i;
  }
  
  private int qn()
  {
    AppMethodBeat.i(157434);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.aLY;
      AppMethodBeat.o(157434);
      return i;
    }
    i = this.aLZ;
    AppMethodBeat.o(157434);
    return i;
  }
  
  private float qo()
  {
    AppMethodBeat.i(157441);
    int i = getPaddingBottom() + getPaddingTop();
    int j = getPaddingLeft() + getPaddingRight();
    if ((this.aMy == 2) || (this.aMy == 4))
    {
      f = Math.max((getWidth() - j) / qm(), (getHeight() - i) / qn());
      AppMethodBeat.o(157441);
      return f;
    }
    if ((this.aMy == 3) && (this.aMv > 0.0F))
    {
      f = this.aMv;
      AppMethodBeat.o(157441);
      return f;
    }
    float f = Math.min((getWidth() - j) / qm(), (getHeight() - i) / qn());
    AppMethodBeat.o(157441);
    return f;
  }
  
  private void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(157410);
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
    {
      ad.i(this.TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(157410);
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(157404);
    f("reset newImage=".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.scale = 0.0F;
    this.aMK = 0.0F;
    this.aML = null;
    this.aMM = null;
    this.aMN = null;
    this.aMO = Float.valueOf(0.0F);
    this.aMP = null;
    this.aMQ = null;
    this.aMX = false;
    this.aMY = false;
    this.aMZ = false;
    this.aNa = 0;
    this.aMn = 0;
    this.aNg = null;
    this.aNh = 0.0F;
    this.aNj = 0.0F;
    this.aNk = false;
    this.aNm = null;
    this.aNl = null;
    this.aNn = null;
    this.aNo = null;
    this.aNy = null;
    this.dY = null;
    this.aNz = null;
    Object localObject1;
    if (paramBoolean)
    {
      if (this.aNV != null)
      {
        localObject1 = this.aNV;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aLV = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aLT = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aLV = 0;
      }
      this.uri = null;
      this.aLF.writeLock().lock();
    }
    com.davemorrissey.labs.subscaleview.c.e locale;
    label512:
    try
    {
      if (this.aLM != null)
      {
        this.aLM.recycle();
        this.aLM = null;
      }
      this.aLF.writeLock().unlock();
      if ((this.bitmap != null) && (!this.aMm)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aMm) && (this.aNr != null)) {
        this.aNr.qr();
      }
      this.aLY = 0;
      this.aLZ = 0;
      this.aMU = 0;
      this.aMa = null;
      this.aMW = null;
      this.aNp = false;
      this.aNq = false;
      this.bitmap = null;
      this.aMh = false;
      this.aMm = false;
      this.aMi = false;
      this.aMj = false;
      this.aMo = true;
      if (this.aMs == null) {
        break label534;
      }
      localObject1 = this.aMs.entrySet().iterator();
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
            if (this.aMT == null) {
              break label489;
            }
            if (this.aMT.bitmap != locale.bitmap) {
              break label512;
            }
            ad.i(this.TAG, "alvinluo reset tile bitmap not need to recycle: %d", new Object[] { Integer.valueOf(locale.bitmap.hashCode()) });
          }
        }
      }
    }
    finally
    {
      label489:
      this.aLF.writeLock().unlock();
      AppMethodBeat.o(157404);
    }
    label529:
    this.aMs = null;
    label534:
    setGestureDetector(getContext());
    AppMethodBeat.o(157404);
  }
  
  public static void setBitmapLoaderImp(com.davemorrissey.labs.subscaleview.c.a parama)
  {
    aNE = parama;
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
          ad.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo rotate and scale fullImageBitmap cost: %d", new Object[] { Long.valueOf(l2 - l1) });
        }
        AppMethodBeat.o(157380);
      }
    }, "rotateAndScaleBitmap");
    AppMethodBeat.o(157425);
  }
  
  private void setGestureDetector(final Context paramContext)
  {
    AppMethodBeat.i(157405);
    this.aNb = new GestureDetector(paramContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157378);
        if ((SubsamplingScaleImageView.k(SubsamplingScaleImageView.this)) && (SubsamplingScaleImageView.f(SubsamplingScaleImageView.this)) && (SubsamplingScaleImageView.g(SubsamplingScaleImageView.this) != null))
        {
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, paramContext);
          ad.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo onDoubleTap, quickScaledEnabled: %b", new Object[] { Boolean.valueOf(SubsamplingScaleImageView.m(SubsamplingScaleImageView.this)) });
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
            AppMethodBeat.o(157378);
            return false;
          }
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.a(new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY())), new PointF(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY()));
          AppMethodBeat.o(157378);
          return true;
        }
        boolean bool = super.onDoubleTapEvent(paramAnonymousMotionEvent);
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
          if (!SubsamplingScaleImageView.qp().contains(Integer.valueOf(1)))
          {
            paramAnonymousMotionEvent1 = new IllegalArgumentException("Unknown easing type: 1");
            AppMethodBeat.o(157376);
            throw paramAnonymousMotionEvent1;
          }
          paramAnonymousMotionEvent1.aOp = 1;
          paramAnonymousMotionEvent1.aOv = false;
          paramAnonymousMotionEvent1.aOq = 3;
          paramAnonymousMotionEvent1.start();
          AppMethodBeat.o(157376);
          return true;
        }
        boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(157376);
        return bool;
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
    });
    this.aNd = new GestureDetector(paramContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157379);
        SubsamplingScaleImageView.this.performClick();
        AppMethodBeat.o(157379);
        return true;
      }
    });
    AppMethodBeat.o(157405);
  }
  
  public static void setPreferredBitmapConfig(Bitmap.Config paramConfig)
  {
    aND = paramConfig;
  }
  
  public static void setTileInitLoaderImp(com.davemorrissey.labs.subscaleview.c.c paramc)
  {
    aNG = paramc;
  }
  
  public static void setTileLoaderImp(com.davemorrissey.labs.subscaleview.c.d paramd)
  {
    aNF = paramd;
  }
  
  public final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(157427);
    if (paramBitmap == null)
    {
      ad.e(this.TAG, "alvinluo rotateAndScaleBitmap bitmap is null");
      AppMethodBeat.o(157427);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(1.0F, 1.0F);
    if (paramInt != 0) {
      localMatrix.postRotate(paramInt);
    }
    ad.d(this.TAG, "alvinluo rotateAndScaleBitmap matrix.isIdentify: %b", new Object[] { Boolean.valueOf(localMatrix.isIdentity()) });
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
        ad.printErrStackTrace(this.TAG, paramBitmap, "alvinluo createBitmap oom", new Object[0]);
        aND = Bitmap.Config.RGB_565;
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
    this.aNo = null;
    this.aMR = true;
    this.aMO = Float.valueOf(paramFloat);
    this.aMP = paramPointF;
    this.aMQ = paramPointF;
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
        ad.i(this.TAG, "alvinluo onPreviewLoaded");
        if (paramBitmap != null) {
          ad.i(this.TAG, "alvinluo onPreviewLoaded %d, recycle: %b", new Object[] { Integer.valueOf(paramBitmap.hashCode()), Boolean.valueOf(paramBitmap.isRecycled()) });
        }
        long l = System.currentTimeMillis();
        if (this.aNq)
        {
          if (this.bitmap != null) {
            this.bitmap.recycle();
          }
          AppMethodBeat.o(157428);
          return;
        }
        if (this.aMW != null)
        {
          if ((this.aMW.width() > 0) && (this.aMW.height() > 0))
          {
            this.bitmap = Bitmap.createBitmap(paramBitmap, this.aMW.left, this.aMW.top, this.aMW.width(), this.aMW.height());
            this.aMV = 0;
          }
          this.aMh = true;
          this.aMj = false;
          this.aMk = this.bitmap.getWidth();
          this.aMl = this.bitmap.getHeight();
          qd();
          this.aMj = true;
          if (qh())
          {
            invalidate();
            requestLayout();
          }
          dA((int)(System.currentTimeMillis() - l));
          ad.i(this.TAG, "alvinluo onPreviewLoaded");
          if ((!this.aMi) && (this.aNr != null)) {
            this.aNr.qq();
          }
          AppMethodBeat.o(157428);
          continue;
        }
        if (paramInteger == null) {
          break label283;
        }
      }
      finally {}
      this.aMV = paramInteger.intValue();
      label283:
      this.bitmap = paramBitmap;
    }
  }
  
  public final void a(com.davemorrissey.labs.subscaleview.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(157424);
      f("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.aLY), Integer.valueOf(this.aLZ), Integer.valueOf(paramInt3) });
      if ((this.aLY > 0) && (this.aLZ > 0) && ((this.aLY != paramInt1) || (this.aLZ != paramInt2)))
      {
        reset(false);
        if (this.bitmap != null)
        {
          if (!this.aMm) {
            this.bitmap.recycle();
          }
          this.bitmap = null;
          if ((this.aNr != null) && (this.aMm)) {
            this.aNr.qr();
          }
          this.aMh = false;
          this.aMm = false;
        }
      }
      this.aLM = paramd;
      this.aLY = paramInt1;
      this.aLZ = paramInt2;
      this.aMU = paramInt3;
      qh();
      if ((!qi()) && (this.aMA > 0) && (this.aMA != aMz) && (this.aMB > 0) && (this.aMB != aMz) && (getWidth() > 0) && (getHeight() > 0)) {
        a(new Point(this.aMA, this.aMB));
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
    this.aMS = parama1;
    this.aMT = parama2;
    reset(true);
    if (parama1.uri != null) {
      this.aMU = h(getContext(), parama1.uri.toString());
    }
    if (parama2 != null)
    {
      if ((parama1.aLY > 0) && (parama1.aLZ > 0)) {
        break label160;
      }
      ad.e(this.TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
    }
    while ((parama1.bitmap != null) && (parama1.aMa != null))
    {
      b(Bitmap.createBitmap(parama1.bitmap, parama1.aMa.left, parama1.aMa.top, parama1.aMa.width(), parama1.aMa.height()), 0, false);
      AppMethodBeat.o(157403);
      return;
      label160:
      this.aLY = parama1.aLY;
      this.aLZ = parama1.aLZ;
      this.aMW = parama2.aMa;
      if (parama2.bitmap != null)
      {
        this.aMm = parama2.aMb;
        a(parama2.bitmap, Integer.valueOf(0));
      }
      else
      {
        Uri localUri2 = parama2.uri;
        Uri localUri1 = localUri2;
        if (localUri2 == null)
        {
          localUri1 = localUri2;
          if (parama2.aLW != null) {
            localUri1 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama2.aLW);
          }
        }
        aNE.a(this, getContext(), this.aNe, localUri1, true).pY();
      }
    }
    if (parama1.bitmap != null)
    {
      b(parama1.bitmap, 0, parama1.aMb);
      AppMethodBeat.o(157403);
      return;
    }
    this.aMa = parama1.aMa;
    this.uri = parama1.uri;
    if ((this.uri == null) && (parama1.aLW != null)) {
      this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama1.aLW);
    }
    if ((parama1.aLX) || (this.aMa != null))
    {
      aNG.a(this, getContext(), this.aNf, this.uri).pY();
      AppMethodBeat.o(157403);
      return;
    }
    aNE.a(this, getContext(), this.aNe, this.uri, false).pY();
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
      f("onImageLoaded has bitmap", new Object[0]);
      if ((this.aLY > 0) && (this.aLZ > 0) && ((this.aLY != paramBitmap.getWidth()) || (this.aLZ != paramBitmap.getHeight()))) {
        reset(false);
      }
      if ((this.bitmap != null) && (!this.aMm)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aMm) && (this.aNr != null)) {
        this.aNr.qr();
      }
      this.aMh = false;
      this.aMm = paramBoolean;
      this.bitmap = paramBitmap;
      this.aLY = paramBitmap.getWidth();
      this.aLZ = paramBitmap.getHeight();
      this.aMU = paramInt;
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
          ad.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo onImageLoaded rotaeAndScaleBitmap %d", new Object[] { Long.valueOf(l2 - l1) });
          SubsamplingScaleImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157381);
              if ((SubsamplingScaleImageView.6.this.aOe) || (SubsamplingScaleImageView.6.this.aOf))
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
    //   4: ldc_w 1347
    //   7: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokestatic 1038	java/lang/System:currentTimeMillis	()J
    //   14: putfield 302	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMp	J
    //   17: aload_0
    //   18: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   21: astore 4
    //   23: aload_1
    //   24: getfield 834	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   27: istore_2
    //   28: aload_1
    //   29: getfield 839	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   32: ifnonnull +166 -> 198
    //   35: aload 4
    //   37: ldc_w 1349
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
    //   54: invokestatic 1004	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 1213	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_1
    //   62: getfield 834	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   65: aload_0
    //   66: getfield 682	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMn	I
    //   69: if_icmpne +40 -> 109
    //   72: aload_1
    //   73: getfield 839	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   76: ifnull +33 -> 109
    //   79: aload_0
    //   80: getfield 298	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMo	Z
    //   83: ifeq +26 -> 109
    //   86: aload_0
    //   87: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   90: ldc_w 1351
    //   93: invokestatic 773	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 298	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMo	Z
    //   101: aload_0
    //   102: aload_1
    //   103: getfield 839	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   106: putfield 615	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMr	Landroid/graphics/Bitmap;
    //   109: aload_0
    //   110: invokespecial 1257	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:qh	()Z
    //   113: pop
    //   114: aload_0
    //   115: invokespecial 1274	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:qi	()Z
    //   118: pop
    //   119: aload_0
    //   120: invokespecial 1023	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:qg	()Z
    //   123: ifeq +62 -> 185
    //   126: aload_0
    //   127: getfield 869	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   130: ifnull +55 -> 185
    //   133: aload_0
    //   134: getfield 1133	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMm	Z
    //   137: ifne +10 -> 147
    //   140: aload_0
    //   141: getfield 869	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   144: invokevirtual 842	android/graphics/Bitmap:recycle	()V
    //   147: aload_0
    //   148: aconst_null
    //   149: putfield 869	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   152: aload_0
    //   153: getfield 1135	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aNr	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   156: ifnull +19 -> 175
    //   159: aload_0
    //   160: getfield 1133	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMm	Z
    //   163: ifeq +12 -> 175
    //   166: aload_0
    //   167: getfield 1135	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aNr	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   170: invokeinterface 1138 1 0
    //   175: aload_0
    //   176: iconst_0
    //   177: putfield 980	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMh	Z
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 1133	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMm	Z
    //   185: aload_0
    //   186: invokevirtual 747	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:invalidate	()V
    //   189: ldc_w 1347
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
  
  public final void dA(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157389);
      if (this.aNV != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aNV;
        locala.aLT += paramInt;
        ad.d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aLT) });
      }
      AppMethodBeat.o(157389);
      return;
    }
    finally {}
  }
  
  public final void dB(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157390);
      if (this.aNV != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aNV;
        locala.aLV += paramInt;
        ad.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aLV) });
      }
      AppMethodBeat.o(157390);
      return;
    }
    finally {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157408);
    ad.d(this.TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(157408);
    return bool;
  }
  
  public final void dz(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157388);
      if (this.aNV != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aNV;
        locala.aLU += paramInt;
        ad.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aLU) });
      }
      AppMethodBeat.o(157388);
      return;
    }
    finally {}
  }
  
  public final void f(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(157444);
    ad.d(this.TAG, String.format(paramString, paramVarArgs));
    AppMethodBeat.o(157444);
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
    return this.aLF;
  }
  
  public Bitmap getFullImageBitmap()
  {
    return this.aMr;
  }
  
  public int getFullImageSampleSize()
  {
    return this.aMn;
  }
  
  public com.davemorrissey.labs.subscaleview.d.a getImageDecodeRecord()
  {
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala = this.aNV;
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
    return this.aMu;
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(157453);
    float f = qo();
    AppMethodBeat.o(157453);
    return f;
  }
  
  public e getOnImageEventListener()
  {
    return this.aNr;
  }
  
  public final int getOrientation()
  {
    return this.orientation;
  }
  
  public int getPreviewHeight()
  {
    return this.aMl;
  }
  
  public int getPreviewOrientation()
  {
    return this.aMV;
  }
  
  public int getPreviewWidth()
  {
    return this.aMk;
  }
  
  public int getRequiredRotation()
  {
    if (this.orientation == -1) {
      return this.aMU;
    }
    return this.orientation;
  }
  
  public final int getSHeight()
  {
    return this.aLZ;
  }
  
  public final int getSWidth()
  {
    return this.aLY;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  public final b getState()
  {
    AppMethodBeat.i(157458);
    if ((this.aML != null) && (this.aLY > 0) && (this.aLZ > 0))
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
    return this.aMa;
  }
  
  /* Error */
  public final int h(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc_w 1419
    //   9: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_2
    //   13: ldc_w 1421
    //   16: invokevirtual 1425	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   19: ifeq +176 -> 195
    //   22: aload_1
    //   23: invokevirtual 1429	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   26: aload_2
    //   27: invokestatic 1324	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   30: iconst_1
    //   31: anewarray 472	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc_w 1430
    //   39: aastore
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 1436	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +82 -> 130
    //   51: aload_1
    //   52: invokeinterface 1441 1 0
    //   57: ifeq +73 -> 130
    //   60: aload_1
    //   61: iconst_0
    //   62: invokeinterface 1444 2 0
    //   67: istore_3
    //   68: getstatic 226	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMc	Ljava/util/List;
    //   71: iload_3
    //   72: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokeinterface 1447 2 0
    //   80: istore 6
    //   82: iload 6
    //   84: ifeq +29 -> 113
    //   87: iload_3
    //   88: iconst_m1
    //   89: if_icmpeq +24 -> 113
    //   92: iload_3
    //   93: istore 4
    //   95: aload_1
    //   96: ifnull +93 -> 189
    //   99: aload_1
    //   100: invokeinterface 1450 1 0
    //   105: ldc_w 1419
    //   108: invokestatic 264	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: iload_3
    //   112: ireturn
    //   113: aload_0
    //   114: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   117: ldc_w 1452
    //   120: iload_3
    //   121: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   124: invokevirtual 491	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   127: invokestatic 1454	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: iconst_0
    //   131: istore_3
    //   132: goto -40 -> 92
    //   135: astore_1
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_0
    //   139: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   142: ldc_w 1456
    //   145: invokestatic 1454	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_1
    //   149: ifnull +37 -> 186
    //   152: aload_1
    //   153: invokeinterface 1450 1 0
    //   158: iload 4
    //   160: istore_3
    //   161: goto -56 -> 105
    //   164: astore_1
    //   165: aload 7
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +9 -> 178
    //   172: aload_2
    //   173: invokeinterface 1450 1 0
    //   178: ldc_w 1419
    //   181: invokestatic 264	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_1
    //   185: athrow
    //   186: iconst_0
    //   187: istore 4
    //   189: iload 4
    //   191: istore_3
    //   192: goto -87 -> 105
    //   195: iload 4
    //   197: istore_3
    //   198: aload_2
    //   199: ldc_w 1458
    //   202: invokevirtual 1425	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   205: ifeq -100 -> 105
    //   208: iload 4
    //   210: istore_3
    //   211: aload_2
    //   212: ldc_w 484
    //   215: invokevirtual 1425	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   218: ifne -113 -> 105
    //   221: new 1460	androidx/a/a/a
    //   224: dup
    //   225: aload_2
    //   226: bipush 7
    //   228: invokevirtual 1463	java/lang/String:substring	(I)Ljava/lang/String;
    //   231: invokespecial 1464	androidx/a/a/a:<init>	(Ljava/lang/String;)V
    //   234: ldc_w 1466
    //   237: iconst_1
    //   238: invokevirtual 1470	androidx/a/a/a:getAttributeInt	(Ljava/lang/String;I)I
    //   241: istore 5
    //   243: iload 4
    //   245: istore_3
    //   246: iload 5
    //   248: iconst_1
    //   249: if_icmpeq -144 -> 105
    //   252: iload 4
    //   254: istore_3
    //   255: iload 5
    //   257: ifeq -152 -> 105
    //   260: iload 5
    //   262: bipush 6
    //   264: if_icmpne +78 -> 342
    //   267: bipush 90
    //   269: istore_3
    //   270: goto -165 -> 105
    //   273: aload_0
    //   274: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   277: ldc_w 1472
    //   280: iload 5
    //   282: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   285: invokevirtual 491	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokestatic 1454	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: iload 4
    //   293: istore_3
    //   294: goto -189 -> 105
    //   297: astore_1
    //   298: aload_0
    //   299: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   302: ldc_w 1474
    //   305: invokestatic 1454	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: iload 4
    //   310: istore_3
    //   311: goto -206 -> 105
    //   314: astore_2
    //   315: aload_1
    //   316: astore 7
    //   318: aload_2
    //   319: astore_1
    //   320: aload 7
    //   322: astore_2
    //   323: goto -155 -> 168
    //   326: astore_2
    //   327: aload_1
    //   328: astore 7
    //   330: aload_2
    //   331: astore_1
    //   332: aload 7
    //   334: astore_2
    //   335: goto -167 -> 168
    //   338: astore_2
    //   339: goto -201 -> 138
    //   342: iload 5
    //   344: iconst_3
    //   345: if_icmpne +10 -> 355
    //   348: sipush 180
    //   351: istore_3
    //   352: goto -247 -> 105
    //   355: iload 5
    //   357: bipush 8
    //   359: if_icmpne -86 -> 273
    //   362: sipush 270
    //   365: istore_3
    //   366: goto -261 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	SubsamplingScaleImageView
    //   0	369	1	paramContext	Context
    //   0	369	2	paramString	String
    //   67	299	3	i	int
    //   4	305	4	j	int
    //   241	119	5	k	int
    //   80	3	6	bool	boolean
    //   1	332	7	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   22	47	135	java/lang/Exception
    //   22	47	164	finally
    //   221	243	297	java/lang/Exception
    //   273	291	297	java/lang/Exception
    //   51	82	314	finally
    //   113	130	314	finally
    //   138	148	326	finally
    //   51	82	338	java/lang/Exception
    //   113	130	338	java/lang/Exception
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(157391);
    super.onAttachedToWindow();
    if (this.aNU != null) {
      this.aNU.onViewAttachedToWindow(this);
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
      ad.i(this.TAG, "alvinluo cancelAllTileLoadTask, task size: %d", new Object[] { Integer.valueOf(this.aNH.size()) });
      Iterator localIterator = this.aNH.iterator();
      while (localIterator.hasNext()) {
        ((com.davemorrissey.labs.subscaleview.c.b)localIterator.next()).cancel();
      }
      this.aNH.clear();
    }
    if (this.aNU != null) {
      this.aNU.onViewDetachedFromWindow(this);
    }
    AppMethodBeat.o(157392);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(157413);
    super.onDraw(paramCanvas);
    System.currentTimeMillis();
    if (this.aNu == null)
    {
      this.aNu = new Paint();
      this.aNu.setAntiAlias(true);
      this.aNu.setFilterBitmap(true);
      this.aNu.setDither(true);
    }
    if (((this.aNv == null) || (this.aNw == null)) && (this.aMt))
    {
      this.aNv = new Paint();
      this.aNv.setTextSize(px(20));
      this.aNv.setColor(-65281);
      this.aNv.setStyle(Paint.Style.FILL);
      this.aNw = new Paint();
      this.aNw.setColor(-65281);
      this.aNw.setStyle(Paint.Style.STROKE);
      this.aNw.setStrokeWidth(px(1));
    }
    if ((this.aLY == 0) || (this.aLZ == 0) || (getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(157413);
      return;
    }
    int j;
    int k;
    if ((this.aMs == null) && (this.aLM != null))
    {
      j = Math.min(paramCanvas.getMaximumBitmapWidth(), this.aMA);
      k = Math.min(paramCanvas.getMaximumBitmapHeight(), this.aMB);
      i = j;
      if (j > 10000) {
        i = 10000;
      }
      j = k;
      if (k > 10000) {
        j = 10000;
      }
      ad.i(this.TAG, "alvinluo getMaxBitmapDimensions %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      a(new Point(i, j));
    }
    if (!qh())
    {
      AppMethodBeat.o(157413);
      return;
    }
    qj();
    boolean bool1;
    float f1;
    boolean bool2;
    if ((this.aNo != null) && (this.aNo.aOm != null))
    {
      if (this.aMN == null) {
        this.aMN = new PointF(0.0F, 0.0F);
      }
      this.aMN.set(this.aML);
      long l = System.currentTimeMillis() - this.aNo.time;
      if (l > this.aNo.duration)
      {
        bool1 = true;
        l = Math.min(l, this.aNo.duration);
        this.scale = a(this.aNo.aOp, l, this.aNo.aMK, this.aNo.aOi - this.aNo.aMK, this.aNo.duration);
        f1 = a(this.aNo.aOp, l, this.aNo.aOm.x, this.aNo.aOn.x - this.aNo.aOm.x, this.aNo.duration);
        f2 = a(this.aNo.aOp, l, this.aNo.aOm.y, this.aNo.aOn.y - this.aNo.aOm.y, this.aNo.duration);
        localObject1 = this.aML;
        ((PointF)localObject1).x -= S(this.aNo.aOk.x) - f1;
        localObject1 = this.aML;
        ((PointF)localObject1).y -= T(this.aNo.aOk.y) - f2;
        if ((!bool1) && (this.aNo.aMK != this.aNo.aOi)) {
          break label883;
        }
        bool2 = true;
        label669:
        aK(bool2);
        c(this.aMN);
        aJ(bool1);
        if (bool1) {
          this.aNo = null;
        }
        invalidate();
      }
    }
    else
    {
      if ((this.aMs == null) || (!qg()) || (!this.aNR)) {
        break label1797;
      }
      k = Math.min(this.aMn, P(this.scale));
      localObject1 = this.aMs.entrySet().iterator();
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
          if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).visible) && ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLQ) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null))) {
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
    Object localObject1 = this.aMs.entrySet().iterator();
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
              Rect localRect = ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLP;
              ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.set((int)S(localRect.left), (int)T(localRect.top), (int)S(localRect.right), (int)T(localRect.bottom));
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLQ) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null)) {
                break label1737;
              }
              if (this.aNx != null) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR, this.aNx);
              }
              if (this.dY == null) {
                this.dY = new Matrix();
              }
              this.dY.reset();
              a(this.aNA, 0.0F, 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight());
              if (getRequiredRotation() != 0) {
                break label1462;
              }
              a(this.aNB, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.bottom);
              label1249:
              this.dY.setPolyToPoly(this.aNA, 0, this.aNB, 0, 4);
              if (!((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.isRecycled()) {
                paramCanvas.drawBitmap(((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap, this.dY, this.aNu);
              }
              if (this.aMt) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR, this.aNw);
              }
            }
            for (;;)
            {
              if ((!((com.davemorrissey.labs.subscaleview.c.e)localObject3).visible) || (!this.aMt)) {
                break label1795;
              }
              paramCanvas.drawText("ISS " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).sampleSize + " RECT " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLP.top + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLP.left + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLP.bottom + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLP.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.top + px(15), this.aNv);
              break label974;
              break;
              label1462:
              if (getRequiredRotation() == 90)
              {
                a(this.aNB, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.top);
                break label1249;
              }
              if (getRequiredRotation() == 180)
              {
                a(this.aNB, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.top);
                break label1249;
              }
              if (getRequiredRotation() != 270) {
                break label1249;
              }
              a(this.aNB, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.bottom);
              break label1249;
              label1737:
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLQ) && (this.aMt)) {
                paramCanvas.drawText("LOADING", ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aLR.top + px(35), this.aNv);
              }
            }
          }
          label1797:
          if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
          {
            ad.d(this.TAG, "alvinluo onDraw bitmap scale: %f", new Object[] { Float.valueOf(this.scale) });
            if ((!this.aMh) || (this.aMj))
            {
              if (this.dY == null) {
                this.dY = new Matrix();
              }
              this.dY.reset();
              i = this.bitmap.getWidth();
              j = this.bitmap.getHeight();
              if ((this.aMV == 90) || (this.aMV == 270))
              {
                i = this.bitmap.getHeight();
                j = this.bitmap.getWidth();
              }
              if (this.aMh)
              {
                f1 = i / 2.0F;
                f2 = j / 2.0F;
                qd();
                this.dY.postScale(this.aNN, this.aNO, f1, f2);
              }
              f1 = (this.aNI - this.bitmap.getWidth()) / 2;
              f2 = (this.aNJ - this.bitmap.getHeight()) / 2;
              this.dY.postTranslate(f1, f2);
              ad.d(this.TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
              if (this.aNx != null)
              {
                if (this.aNz == null) {
                  this.aNz = new RectF();
                }
                localObject1 = this.aNz;
                if (!this.aMh) {
                  break label2880;
                }
                f1 = this.bitmap.getWidth();
                if (!this.aMh) {
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
    for (float f2 = this.bitmap.getHeight();; f2 = this.aLZ)
    {
      ((RectF)localObject1).set(0.0F, 0.0F, f1, f2);
      this.dY.mapRect(this.aNz);
      paramCanvas.drawRect(this.aNz, this.aNx);
      paramCanvas.drawBitmap(this.bitmap, this.dY, this.aNu);
      if (this.aMt)
      {
        ad.d(this.TAG, "alvinluo onDraw debug vTranslate %f, %f", new Object[] { Float.valueOf(this.aML.x), Float.valueOf(this.aML.y) });
        paramCanvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.scale) }) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(qo()) }) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aMu) }) + ")", px(5), px(15), this.aNv);
        paramCanvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aML.x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aML.y) }), px(5), px(30), this.aNv);
        localObject1 = getCenter();
        paramCanvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).y) }), px(5), px(45), this.aNv);
        if (this.aNo != null)
        {
          localObject1 = b(this.aNo.aOj);
          localObject2 = b(this.aNo.aOl);
          localObject3 = b(this.aNo.aOk);
          paramCanvas.drawCircle(((PointF)localObject1).x, ((PointF)localObject1).y, px(10), this.aNw);
          this.aNw.setColor(-65536);
          paramCanvas.drawCircle(((PointF)localObject2).x, ((PointF)localObject2).y, px(20), this.aNw);
          this.aNw.setColor(-16776961);
          paramCanvas.drawCircle(((PointF)localObject3).x, ((PointF)localObject3).y, px(25), this.aNw);
          this.aNw.setColor(-16711681);
          paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.aNw);
        }
        if (this.aNg != null)
        {
          this.aNw.setColor(-65536);
          paramCanvas.drawCircle(this.aNg.x, this.aNg.y, px(20), this.aNw);
        }
        if (this.aNm != null)
        {
          this.aNw.setColor(-16776961);
          paramCanvas.drawCircle(S(this.aNm.x), T(this.aNm.y), px(35), this.aNw);
        }
        if ((this.aNn != null) && (this.aMZ))
        {
          this.aNw.setColor(-16711681);
          paramCanvas.drawCircle(this.aNn.x, this.aNn.y, px(30), this.aNw);
        }
        this.aNw.setColor(-65281);
      }
      AppMethodBeat.o(157413);
      return;
      f1 = this.aLY;
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
      if ((this.aLY <= 0) || (this.aLZ <= 0)) {
        break label214;
      }
      if ((paramInt2 == 0) || (i == 0)) {
        break label164;
      }
      paramInt2 = qm();
      paramInt1 = qn();
    }
    for (;;)
    {
      paramInt2 = Math.max(paramInt2, getSuggestedMinimumWidth());
      paramInt1 = Math.max(paramInt1, getSuggestedMinimumHeight());
      setMeasuredDimension(paramInt2, paramInt1);
      this.aNI = paramInt2;
      this.aNJ = paramInt1;
      ad.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", new Object[] { Integer.valueOf(this.aNI), Integer.valueOf(this.aNI) });
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
        paramInt1 = (int)(qn() / qm() * j);
        paramInt2 = j;
      }
      else if (paramInt2 != 0)
      {
        paramInt2 = (int)(qm() / qn() * paramInt1);
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
    f("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(this.scale), this.aMO, Boolean.valueOf(this.aMR) });
    qc();
    PointF localPointF = getCenter();
    if (((this.aNp) || (this.aMR)) && (localPointF != null))
    {
      this.aNo = null;
      if (!this.aMR)
      {
        this.aMO = Float.valueOf(this.scale);
        this.aMP = localPointF;
      }
    }
    AppMethodBeat.o(157406);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157409);
    ad.d(this.TAG, "alvinluo SubSamplingScaleImageView onTouchEvent: %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    if ((this.aNo != null) && (!this.aNo.aOo))
    {
      requestDisallowInterceptTouchEvent(true);
      AppMethodBeat.o(157409);
      return true;
    }
    this.aNo = null;
    if (this.aML == null)
    {
      if (this.aNd != null) {
        this.aNd.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(157409);
      return true;
    }
    if ((!this.aMZ) && ((this.aNb == null) || (this.aNb.onTouchEvent(paramMotionEvent))))
    {
      this.aMX = false;
      this.aMY = false;
      this.aNa = 0;
      AppMethodBeat.o(157409);
      return true;
    }
    if (this.aMM == null) {
      this.aMM = new PointF(0.0F, 0.0F);
    }
    if (this.aMN == null) {
      this.aMN = new PointF(0.0F, 0.0F);
    }
    if (this.aNg == null) {
      this.aNg = new PointF(0.0F, 0.0F);
    }
    this.aMN.set(this.aML);
    int i = paramMotionEvent.getPointerCount();
    boolean bool1;
    label303:
    boolean bool2;
    float f1;
    label511:
    float f3;
    float f4;
    float f5;
    double d;
    float f2;
    label949:
    label994:
    float f6;
    float f7;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
      c(this.aMN);
      bool2 = super.onTouchEvent(paramMotionEvent);
      ad.i(this.TAG, "alvinluo onTouchEvent super: %b, handled: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool1) || (bool2))
      {
        AppMethodBeat.o(157409);
        return true;
      }
      break;
    case 0: 
    case 5: 
    case 261: 
      this.aOa = paramMotionEvent.getRawX();
      this.aOb = paramMotionEvent.getRawY();
      this.aNo = null;
      requestDisallowInterceptTouchEvent(true);
      this.aNa = Math.max(this.aNa, i);
      if (i >= 2) {
        if (this.aME)
        {
          f1 = e(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
          this.aMK = this.scale;
          this.aNh = f1;
          this.aMM.set(this.aML.x, this.aML.y);
          this.aNg.set((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F, (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
          this.handler.removeMessages(1);
        }
      }
      for (;;)
      {
        bool1 = true;
        break;
        this.aNa = 0;
        break label511;
        if (!this.aMZ)
        {
          this.aMM.set(this.aML.x, this.aML.y);
          this.aNg.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          ad.i(this.TAG, "pennqin, delay time 601 ms.");
          this.handler.sendEmptyMessageDelayed(1, 601L);
        }
      }
    case 2: 
      bool2 = false;
      bool1 = bool2;
      if (this.aNa > 0)
      {
        if (i < 2) {
          break label1330;
        }
        f3 = e(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
        f4 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
        f5 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
        this.aNT = new PointF(f4, f5);
        bool1 = bool2;
        if (this.aME) {
          if ((e(this.aNg.x, f4, this.aNg.y, f5) <= 5.0F) && (Math.abs(f3 - this.aNh) <= 5.0F))
          {
            bool1 = bool2;
            if (!this.aMY) {}
          }
          else
          {
            this.aMX = true;
            this.aMY = true;
            d = this.scale;
            f2 = f3 / this.aNh * this.aMK;
            f1 = f2;
            if (f2 >= this.aMu * 2.0F)
            {
              f1 = this.aMu;
              f1 = (f2 - this.aMu) * 0.1F + f1 * 2.0F;
            }
            this.scale = f1;
            ad.i(this.TAG, "alvinluo zoom preScale: %f, scale: %f, minScale: %f, maxScale: %f", new Object[] { Double.valueOf(d), Float.valueOf(this.scale), Float.valueOf(qo()), Float.valueOf(this.aMu) });
            if (this.scale > qo()) {
              break label994;
            }
            this.aNh = f3;
            this.aMK = qo();
            this.aNg.set(f4, f5);
            this.aMM.set(this.aML);
          }
        }
      }
      for (;;)
      {
        aK(true);
        aJ(this.aMC);
        bool1 = true;
        ad.d(this.TAG, "alvinluo Action_Move consumed: %b", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break;
        }
        this.handler.removeMessages(1);
        invalidate();
        bool1 = true;
        break label303;
        if (this.aMD)
        {
          f1 = this.aNg.x;
          f2 = this.aMM.x;
          f6 = this.aNg.y;
          f7 = this.aMM.y;
          float f8 = this.scale / this.aMK;
          float f9 = this.scale / this.aMK;
          this.aML.x = (f4 - (f1 - f2) * f8);
          this.aML.y = (f5 - (f6 - f7) * f9);
          if (((qn() * d < getHeight()) && (this.scale * qn() >= getHeight())) || ((d * qm() < getWidth()) && (this.scale * qm() >= getWidth())))
          {
            aK(true);
            this.aNg.set(f4, f5);
            this.aMM.set(this.aML);
            this.aMK = this.scale;
            this.aNh = f3;
          }
        }
        else if (this.aMQ != null)
        {
          this.aML.x = (getWidth() / 2 - this.scale * this.aMQ.x);
          this.aML.y = (getHeight() / 2 - this.scale * this.aMQ.y);
        }
        else
        {
          this.aML.x = (getWidth() / 2 - this.scale * (qm() / 2));
          this.aML.y = (getHeight() / 2 - this.scale * (qn() / 2));
        }
      }
      label1330:
      if (this.aMZ)
      {
        f2 = Math.abs(this.aNn.y - paramMotionEvent.getY()) * 2.0F + this.aNi;
        if (this.aNj == -1.0F) {
          this.aNj = f2;
        }
        if (paramMotionEvent.getY() > this.aNl.y)
        {
          i = 1;
          label1396:
          this.aNl.set(0.0F, paramMotionEvent.getY());
          f3 = 0.5F * Math.abs(1.0F - f2 / this.aNj);
          if (f3 <= 0.03F)
          {
            f1 = f2;
            if (!this.aNk) {
              break;
            }
          }
          else
          {
            this.aNk = true;
            if (this.aNj <= 0.0F) {
              break label2804;
            }
            if (i == 0) {
              break label1756;
            }
            f1 = 1.0F + f3;
          }
        }
      }
      break;
    }
    for (;;)
    {
      label1471:
      d = this.scale;
      this.scale = Math.max(qo(), Math.min(this.aMu, f1 * this.scale));
      if (this.aMD)
      {
        f1 = this.aNg.x;
        f3 = this.aMM.x;
        f4 = this.aNg.y;
        f5 = this.aMM.y;
        f6 = this.scale / this.aMK;
        f7 = this.scale / this.aMK;
        this.aML.x = (this.aNg.x - (f1 - f3) * f6);
        this.aML.y = (this.aNg.y - (f4 - f5) * f7);
        if (((qn() * d >= getHeight()) || (this.scale * qn() < getHeight())) && ((qm() * d >= getWidth()) || (this.scale * qm() < getWidth()))) {
          break label2797;
        }
        aK(true);
        this.aNg.set(b(this.aNm));
        this.aMM.set(this.aML);
        this.aMK = this.scale;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.aNj = f1;
        aK(true);
        aJ(this.aMC);
        bool1 = true;
        break label949;
        i = 0;
        break label1396;
        label1756:
        f1 = 1.0F - f3;
        break label1471;
        if (this.aMQ != null)
        {
          this.aML.x = (getWidth() / 2 - this.scale * this.aMQ.x);
          this.aML.y = (getHeight() / 2 - this.scale * this.aMQ.y);
          f1 = f2;
        }
        else
        {
          this.aML.x = (getWidth() / 2 - this.scale * (qm() / 2));
          this.aML.y = (getHeight() / 2 - this.scale * (qn() / 2));
          f1 = f2;
          continue;
          bool1 = bool2;
          if (this.aMX) {
            break label949;
          }
          f1 = Math.abs(paramMotionEvent.getX() - this.aNg.x);
          f2 = Math.abs(paramMotionEvent.getY() - this.aNg.y);
          f3 = this.density * 5.0F;
          if ((f1 <= f3) && (f2 <= f3))
          {
            bool1 = bool2;
            if (!this.aMY) {
              break label949;
            }
          }
          this.aML.x = (this.aMM.x + (paramMotionEvent.getX() - this.aNg.x));
          this.aML.y = (this.aMM.y + (paramMotionEvent.getY() - this.aNg.y));
          f4 = this.aML.x;
          f5 = this.aML.y;
          aK(true);
          label2069:
          label2085:
          boolean bool3;
          label2108:
          boolean bool4;
          label2131:
          boolean bool5;
          if (f4 != this.aML.x)
          {
            bool1 = true;
            if (f5 == this.aML.y) {
              break label2348;
            }
            bool2 = true;
            if ((!bool1) || (f1 <= f2) || (this.aMY)) {
              break label2354;
            }
            bool3 = true;
            if ((!bool2) || (f2 <= f1) || (this.aMY)) {
              break label2360;
            }
            bool4 = true;
            if ((f5 != this.aML.y) || (f2 <= 3.0F * f3)) {
              break label2366;
            }
            bool5 = true;
            label2159:
            ad.i(this.TAG, "alvinluo Action_Move edge atXEdge: %b, atYEdge: %b, edgeXSwipe: %b, edgeYSwipe: %b, yPan: %b, isPanning: %b,dx: %f, dy: %f, offset: %f", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(this.aMY), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
            if ((bool3) || (bool4) || ((bool1) && (bool2) && (!bool5) && (!this.aMY))) {
              break label2372;
            }
            this.aMY = true;
          }
          for (;;)
          {
            if (!this.aMD)
            {
              this.aML.x = this.aMM.x;
              this.aML.y = this.aMM.y;
              requestDisallowInterceptTouchEvent(false);
            }
            aJ(this.aMC);
            bool1 = true;
            break;
            bool1 = false;
            break label2069;
            label2348:
            bool2 = false;
            break label2085;
            label2354:
            bool3 = false;
            break label2108;
            label2360:
            bool4 = false;
            break label2131;
            label2366:
            bool5 = false;
            break label2159;
            label2372:
            if ((f1 > f3) || (f2 > f3))
            {
              this.aNa = 0;
              this.handler.removeMessages(1);
              requestDisallowInterceptTouchEvent(false);
            }
          }
          this.handler.removeMessages(1);
          if (this.aMZ)
          {
            this.aMZ = false;
            if (!this.aNk) {
              a(this.aNm, this.aNg);
            }
          }
          if ((this.aNa > 0) && ((this.aMX) || (this.aMY)))
          {
            if ((this.aMX) && (i == 2))
            {
              this.aMY = true;
              this.aMM.set(this.aML.x, this.aML.y);
              if (paramMotionEvent.getActionIndex() != 1) {
                break label2657;
              }
              this.aNg.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
              label2533:
              if (this.scale > this.aNM) {
                break label2677;
              }
              ad.i(this.TAG, "alvinluo scale %f less than %f, and need to reset", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.aNM) });
              PointF localPointF = new PointF(this.aNI / 2, this.aNJ / 2);
              a(localPointF, localPointF, this.aNM);
              this.aMY = false;
            }
            for (;;)
            {
              if (i < 3) {
                this.aMX = false;
              }
              if (i < 2)
              {
                this.aMY = false;
                this.aNa = 0;
              }
              aJ(true);
              bool1 = true;
              break;
              label2657:
              this.aNg.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
              break label2533;
              label2677:
              if (this.scale > getDoubleTapZoomScale() * 2.0F)
              {
                ad.i(this.TAG, "alvinluo current scale %f larger than maxScale: %f, and reset to scale: %f", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.aMu), Float.valueOf(getDoubleTapZoomScale() * 2.0F) });
                a(a(this.aNT), this.aNT, getDoubleTapZoomScale() * 2.0F);
              }
            }
          }
          if (i == 1)
          {
            this.aMX = false;
            this.aMY = false;
            this.aNa = 0;
          }
          bool1 = false;
          break;
          AppMethodBeat.o(157409);
          return false;
          label2797:
          f1 = f2;
        }
      }
      label2804:
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
    this.aNe = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
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
    this.aNe = paramb;
    AppMethodBeat.o(157448);
  }
  
  public final void setDebug(boolean paramBoolean)
  {
    this.aMt = paramBoolean;
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
    this.aMI = Math.max(0, paramInt);
    AppMethodBeat.o(157463);
  }
  
  public final void setDoubleTapZoomScale(float paramFloat)
  {
    this.aMG = paramFloat;
  }
  
  public final void setDoubleTapZoomStyle(int paramInt)
  {
    AppMethodBeat.i(157462);
    if (!aMd.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid zoom style: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157462);
      throw localIllegalArgumentException;
    }
    this.aMH = paramInt;
    AppMethodBeat.o(157462);
  }
  
  public void setEagerLoadingEnabled(boolean paramBoolean)
  {
    this.aMC = paramBoolean;
  }
  
  public void setEdgeSwipeListener(c paramc)
  {
    this.aNW = paramc;
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
    this.aNc = paramSimpleOnGestureListener;
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
    if (((localMatrix == null) && (!this.aNC.isIdentity())) || ((localMatrix != null) && (!this.aNC.equals(localMatrix))))
    {
      this.aNC.set(localMatrix);
      invalidate();
    }
    AppMethodBeat.o(157401);
  }
  
  public final void setMaxScale(float paramFloat)
  {
    this.aMu = paramFloat;
  }
  
  public void setMaxTileSize(int paramInt)
  {
    this.aMA = paramInt;
    this.aMB = paramInt;
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
    this.aMv = paramFloat;
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
    if (!aMg.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid scale type: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157450);
      throw localIllegalArgumentException;
    }
    this.aMy = paramInt;
    if (this.aNp)
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
    this.aMw = ((int)Math.min((localDisplayMetrics.ydpi + f) / 2.0F, paramInt));
    if (this.aNp)
    {
      reset(false);
      invalidate();
    }
    AppMethodBeat.o(157454);
  }
  
  public void setOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.aNU = paramOnAttachStateChangeListener;
  }
  
  public void setOnImageEventListener(e parame)
  {
    this.aNr = parame;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.aNt = paramOnLongClickListener;
  }
  
  public void setOnStateChangedListener(f paramf)
  {
    this.aNs = paramf;
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(157396);
    if (!aMc.contains(Integer.valueOf(paramInt)))
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
    this.aMD = paramBoolean;
    if ((!paramBoolean) && (this.aML != null))
    {
      this.aML.x = (getWidth() / 2 - this.scale * (qm() / 2));
      this.aML.y = (getHeight() / 2 - this.scale * (qn() / 2));
      if (this.aNp)
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
    if (!aMf.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid pan limit: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157449);
      throw localIllegalArgumentException;
    }
    this.aMx = paramInt;
    if (this.aNp)
    {
      aK(true);
      invalidate();
    }
    AppMethodBeat.o(157449);
  }
  
  public void setPreviewDone(boolean paramBoolean)
  {
    AppMethodBeat.i(157395);
    this.aNR = paramBoolean;
    invalidate();
    AppMethodBeat.o(157395);
  }
  
  public final void setQuickScaleEnabled(boolean paramBoolean)
  {
    this.aMF = paramBoolean;
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
    this.aNf = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
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
    this.aNf = paramb;
    AppMethodBeat.o(157446);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(157397);
    this.aNM = paramFloat;
    this.aMu = 2.0F;
    this.aMv = 1.0F;
    qe();
    qf();
    AppMethodBeat.o(157397);
  }
  
  public final void setTileBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(157460);
    if (Color.alpha(paramInt) == 0) {
      this.aNx = null;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(157460);
      return;
      this.aNx = new Paint();
      this.aNx.setStyle(Paint.Style.FILL);
      this.aNx.setColor(paramInt);
    }
  }
  
  public final void setZoomEnabled(boolean paramBoolean)
  {
    this.aME = paramBoolean;
  }
  
  public void setsRegion(Rect paramRect)
  {
    this.aMa = paramRect;
  }
  
  static final class a
  {
    float aMK;
    float aOi;
    PointF aOj;
    PointF aOk;
    PointF aOl;
    PointF aOm;
    PointF aOn;
    boolean aOo;
    int aOp;
    int aOq;
    SubsamplingScaleImageView.d aOr;
    long duration;
    long time;
    
    private a()
    {
      AppMethodBeat.i(157385);
      this.duration = 200L;
      this.aOo = true;
      this.aOp = 2;
      this.aOq = 1;
      this.time = System.currentTimeMillis();
      AppMethodBeat.o(157385);
    }
  }
  
  public final class b
  {
    boolean aOo;
    int aOp;
    int aOq;
    private SubsamplingScaleImageView.d aOr;
    private final float aOs;
    private final PointF aOt;
    private final PointF aOu;
    boolean aOv;
    long duration;
    
    private b(float paramFloat, PointF paramPointF)
    {
      this.duration = 500L;
      this.aOp = 2;
      this.aOq = 1;
      this.aOo = true;
      this.aOv = true;
      this.aOs = paramFloat;
      this.aOt = paramPointF;
      this.aOu = null;
    }
    
    private b(float paramFloat, PointF paramPointF1, PointF paramPointF2)
    {
      this.duration = 500L;
      this.aOp = 2;
      this.aOq = 1;
      this.aOo = true;
      this.aOv = true;
      this.aOs = paramFloat;
      this.aOt = paramPointF1;
      this.aOu = paramPointF2;
    }
    
    private b(PointF paramPointF)
    {
      AppMethodBeat.i(157386);
      this.duration = 500L;
      this.aOp = 2;
      this.aOq = 1;
      this.aOo = true;
      this.aOv = true;
      this.aOs = SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
      this.aOt = paramPointF;
      this.aOu = null;
      AppMethodBeat.o(157386);
    }
    
    public final void start()
    {
      AppMethodBeat.i(157387);
      if ((SubsamplingScaleImageView.w(SubsamplingScaleImageView.this) != null) && (SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOr != null)) {}
      try
      {
        SubsamplingScaleImageView.w(SubsamplingScaleImageView.this);
        int i = SubsamplingScaleImageView.this.getPaddingLeft();
        int j = (SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight() - SubsamplingScaleImageView.this.getPaddingLeft()) / 2;
        int k = SubsamplingScaleImageView.this.getPaddingTop();
        int m = (SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom() - SubsamplingScaleImageView.this.getPaddingTop()) / 2;
        float f3 = SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, this.aOs);
        if (this.aOv)
        {
          Object localObject = SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, this.aOt.x, this.aOt.y, f3, new PointF());
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, new SubsamplingScaleImageView.a((byte)0));
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aMK = SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOi = f3;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).time = System.currentTimeMillis();
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOl = ((PointF)localObject);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOj = SubsamplingScaleImageView.this.getCenter();
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOk = ((PointF)localObject);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOm = SubsamplingScaleImageView.this.b((PointF)localObject);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOn = new PointF(j + i, m + k);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).duration = this.duration;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOo = this.aOo;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOp = this.aOp;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOq = this.aOq;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).time = System.currentTimeMillis();
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOr = this.aOr;
          if (this.aOu != null)
          {
            float f1 = this.aOu.x - SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOj.x * f3;
            float f2 = this.aOu.y - SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOj.y * f3;
            localObject = new SubsamplingScaleImageView.g(f3, new PointF(f1, f2), (byte)0);
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, (SubsamplingScaleImageView.g)localObject);
            SubsamplingScaleImageView.a locala = SubsamplingScaleImageView.w(SubsamplingScaleImageView.this);
            f3 = this.aOu.x;
            float f4 = ((SubsamplingScaleImageView.g)localObject).aML.x;
            float f5 = this.aOu.y;
            locala.aOn = new PointF(f4 - f1 + f3, ((SubsamplingScaleImageView.g)localObject).aML.y - f2 + f5);
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
          ad.w(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "Error thrown by animation listener", new Object[] { localException });
          continue;
          PointF localPointF = this.aOt;
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
    
    public abstract void m(Bitmap paramBitmap);
    
    public abstract void qq();
    
    public abstract void qr();
  }
  
  public static abstract interface f {}
  
  static final class g
  {
    PointF aML;
    float scale;
    
    private g(float paramFloat, PointF paramPointF)
    {
      this.scale = paramFloat;
      this.aML = paramPointF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView
 * JD-Core Version:    0.7.0.1
 */