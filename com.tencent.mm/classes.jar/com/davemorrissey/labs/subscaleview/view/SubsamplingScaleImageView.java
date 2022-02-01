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
import com.tencent.mm.sdk.platformtools.ac;
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
  private static final List<Integer> aMS;
  private static final List<Integer> aMT;
  private static final List<Integer> aMU;
  private static final List<Integer> aMV;
  private static final List<Integer> aMW;
  public static int aNp;
  private static Bitmap.Config aOt;
  private static com.davemorrissey.labs.subscaleview.c.a aOu;
  private static com.davemorrissey.labs.subscaleview.c.d aOv;
  private static com.davemorrissey.labs.subscaleview.c.c aOw;
  private final String TAG;
  private com.davemorrissey.labs.subscaleview.a.d aMC;
  public int aMO;
  public int aMP;
  private Rect aMQ;
  private boolean aMX;
  private boolean aMY;
  private boolean aMZ;
  private final ReadWriteLock aMv;
  private float aNA;
  private PointF aNB;
  private PointF aNC;
  private PointF aND;
  private Float aNE;
  private PointF aNF;
  private PointF aNG;
  private boolean aNH;
  private a aNI;
  private a aNJ;
  private int aNK;
  private int aNL;
  private Rect aNM;
  private boolean aNN;
  private boolean aNO;
  private boolean aNP;
  private int aNQ;
  private GestureDetector aNR;
  private GestureDetector.SimpleOnGestureListener aNS;
  private GestureDetector aNT;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aNU;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aNV;
  private PointF aNW;
  private float aNX;
  private final float aNY;
  private float aNZ;
  private int aNa;
  private int aNb;
  private boolean aNc;
  private int aNd;
  private boolean aNe;
  private long aNf;
  private long aNg;
  private Bitmap aNh;
  private Map<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> aNi;
  private boolean aNj;
  private float aNk;
  private float aNl;
  private int aNm;
  private int aNn;
  private int aNo;
  private int aNq;
  private int aNr;
  private boolean aNs;
  private boolean aNt;
  private boolean aNu;
  private boolean aNv;
  private float aNw;
  private int aNx;
  private int aNy;
  private int aNz;
  private float aOA;
  private float aOB;
  public float aOC;
  private float aOD;
  private float aOE;
  private float aOF;
  private float aOG;
  private boolean aOH;
  private boolean aOI;
  private PointF aOJ;
  private View.OnAttachStateChangeListener aOK;
  private com.davemorrissey.labs.subscaleview.d.a aOL;
  private c aOM;
  private boolean aON;
  private boolean aOO;
  private boolean aOP;
  private float aOQ;
  private float aOR;
  private boolean aOa;
  private PointF aOb;
  private PointF aOc;
  private PointF aOd;
  private a aOe;
  private boolean aOf;
  private boolean aOg;
  private e aOh;
  private f aOi;
  private View.OnLongClickListener aOj;
  private Paint aOk;
  private Paint aOl;
  private Paint aOm;
  private Paint aOn;
  private g aOo;
  private RectF aOp;
  private float[] aOq;
  private float[] aOr;
  private Matrix aOs;
  private LinkedList<com.davemorrissey.labs.subscaleview.c.b> aOx;
  private int aOy;
  private int aOz;
  private Bitmap bitmap;
  private boolean cancelled;
  private float density;
  private Matrix eY;
  public Executor executor;
  private Handler handler;
  private int orientation;
  private float scale;
  private Uri uri;
  
  static
  {
    AppMethodBeat.i(157473);
    aMS = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1) });
    aMT = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    aMU = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
    aMV = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    aMW = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4) });
    aNp = 2147483647;
    aOt = Bitmap.Config.ARGB_8888;
    aOu = new com.davemorrissey.labs.subscaleview.b.a();
    aOv = new com.davemorrissey.labs.subscaleview.b.c();
    aOw = new com.davemorrissey.labs.subscaleview.b.b();
    AppMethodBeat.o(157473);
  }
  
  public SubsamplingScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(157394);
    this.TAG = (SubsamplingScaleImageView.class.getSimpleName() + hashCode());
    this.aNe = true;
    this.aNf = -1L;
    this.aNg = -1L;
    this.aNj = false;
    this.orientation = -1;
    this.aNk = 2.0F;
    this.aNl = qy();
    this.aNm = -1;
    this.aNn = 1;
    this.aNo = 3;
    this.aNq = aNp;
    this.aNr = aNp;
    this.aNs = true;
    this.aNt = true;
    this.aNu = true;
    this.aNv = true;
    this.aNw = 2.0F;
    this.aNx = 1;
    this.aNy = 200;
    this.aNz = 200;
    this.aNL = 0;
    this.aMv = new ReentrantReadWriteLock(true);
    this.aNU = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.aNV = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.aOq = new float[8];
    this.aOr = new float[8];
    this.aOx = new LinkedList();
    this.cancelled = false;
    this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
    this.aOF = 1.0F;
    this.aOG = 20.0F;
    this.aOH = true;
    this.aOI = false;
    this.aOL = new com.davemorrissey.labs.subscaleview.d.a();
    this.aOM = new c() {};
    this.aON = false;
    this.aOO = false;
    this.aOP = false;
    this.density = getResources().getDisplayMetrics().density;
    setDoubleTapZoomScale(2.0F);
    setMinimumTileDpi(320);
    setGestureDetector(paramContext);
    this.aOs = new Matrix();
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
          setImage(a.W("file:///android_asset/".concat(String.valueOf(str))).ql());
        }
      }
      if (paramAttributeSet.hasValue(3))
      {
        int i = paramAttributeSet.getResourceId(3, 0);
        if (i > 0) {
          setImage(new a(i).ql());
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
    this.aNY = TypedValue.applyDimension(1, 20.0F, paramContext.getResources().getDisplayMetrics());
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aOF = f;
    }
    AppMethodBeat.o(157394);
  }
  
  private int T(float paramFloat)
  {
    AppMethodBeat.i(157420);
    float f = paramFloat;
    if (this.aNm > 0)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      f = localDisplayMetrics.xdpi;
      f = (localDisplayMetrics.ydpi + f) / 2.0F;
      f = paramFloat * (this.aNm / f);
    }
    int j = (int)(qw() * f);
    int i = (int)(qx() * f);
    if ((j == 0) || (i == 0))
    {
      AppMethodBeat.o(157420);
      return 32;
    }
    if ((qx() > i) || (qw() > j))
    {
      i = Math.round(qx() / i);
      j = Math.round(qw() / j);
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
  
  private float U(float paramFloat)
  {
    if (this.aNB == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.aNB.x) / this.scale;
  }
  
  private float V(float paramFloat)
  {
    if (this.aNB == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.aNB.y) / this.scale;
  }
  
  private float W(float paramFloat)
  {
    if (this.aNB == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.aNB.x;
  }
  
  private float X(float paramFloat)
  {
    if (this.aNB == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.aNB.y;
  }
  
  private float Y(float paramFloat)
  {
    AppMethodBeat.i(157442);
    paramFloat = Math.max(qy(), paramFloat);
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
    if (this.aNB == null)
    {
      AppMethodBeat.o(157437);
      return null;
    }
    paramPointF.set(U(paramFloat1), V(paramFloat2));
    AppMethodBeat.o(157437);
    return paramPointF;
  }
  
  private void a(Point paramPoint)
  {
    try
    {
      AppMethodBeat.i(157417);
      f("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
      this.aOo = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      a(true, this.aOo);
      this.aNd = T(this.aOo.scale);
      b(paramPoint);
      paramPoint = ((List)this.aNi.get(Integer.valueOf(this.aNd))).iterator();
      while (paramPoint.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)paramPoint.next();
        ac.i(this.TAG, "alvinluo tile fullSampleSize: %d", new Object[] { Integer.valueOf(this.aNd) });
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
    if (!this.aNt)
    {
      if (this.aNG != null)
      {
        paramPointF1.x = this.aNG.x;
        paramPointF1.y = this.aNG.y;
      }
    }
    else
    {
      f2 = getDoubleTapZoomScale();
      ac.i(this.TAG, "alvinluo doubleTapZoom %f", new Object[] { Float.valueOf(f2) });
      if ((this.scale > f2 * 0.9D) && (this.scale != this.aOC)) {
        break label159;
      }
      i = 1;
      if (i == 0) {
        break label165;
      }
      f1 = f2;
      label109:
      if (this.aNx != 3) {
        break label173;
      }
      a(f1, paramPointF1);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(157411);
      return;
      paramPointF1.x = (qw() / 2);
      paramPointF1.y = (qx() / 2);
      break;
      label159:
      i = 0;
      break label101;
      label165:
      f1 = this.aOC;
      break label109;
      label173:
      if ((this.aNx == 2) || (i == 0) || (!this.aNt))
      {
        paramPointF1 = new b(f1, paramPointF1, (byte)0);
        paramPointF1.aPe = false;
        paramPointF1.duration = this.aNy;
        paramPointF1.aPg = 4;
        paramPointF1.start();
      }
      else if (this.aNx == 1)
      {
        paramPointF1 = new b(f2, paramPointF1, paramPointF2, (byte)0);
        paramPointF1.aPe = false;
        paramPointF1.duration = this.aNy;
        paramPointF1.aPg = 4;
        paramPointF1.start();
      }
    }
  }
  
  private void a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    AppMethodBeat.i(157412);
    paramPointF1 = new b(paramFloat, paramPointF1, paramPointF2, (byte)0);
    paramPointF1.aPe = false;
    paramPointF1.duration = this.aNz;
    paramPointF1.aPg = 2;
    paramPointF1.start();
    AppMethodBeat.o(157412);
  }
  
  private void a(com.davemorrissey.labs.subscaleview.c.e parame)
  {
    AppMethodBeat.i(157393);
    if (this.cancelled)
    {
      ac.i(this.TAG, "alvinluo newLoadTask, has cancelled and ignore");
      AppMethodBeat.o(157393);
      return;
    }
    parame = aOv.a(this, this.aMC, parame);
    parame.qi();
    this.aOx.add(parame);
    AppMethodBeat.o(157393);
  }
  
  private void a(boolean paramBoolean, g paramg)
  {
    float f2 = 0.5F;
    AppMethodBeat.i(157421);
    boolean bool = paramBoolean;
    if (this.aNn == 2)
    {
      bool = paramBoolean;
      if (this.aOf) {
        bool = false;
      }
    }
    PointF localPointF = paramg.aNB;
    float f4 = Y(paramg.scale);
    float f3 = f4 * qw();
    float f5 = f4 * qx();
    float f1;
    if ((this.aNn == 3) && (this.aOf))
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
      if ((this.aNn != 3) || (!this.aOf)) {
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
    if ((this.aMC == null) || (this.aNi == null))
    {
      AppMethodBeat.o(157418);
      return;
    }
    int j = Math.min(this.aNd, T(this.scale));
    Iterator localIterator1 = this.aNi.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)localIterator2.next();
        if ((locale.sampleSize < j) || ((locale.sampleSize > j) && (locale.sampleSize != this.aNd)))
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
          float f1 = U(0.0F);
          float f2 = U(getWidth());
          float f3 = V(0.0F);
          float f4 = V(getHeight());
          if ((f1 <= locale.aMF.right) && (locale.aMF.left <= f2) && (f3 <= locale.aMF.bottom) && (locale.aMF.top <= f4)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label328;
            }
            locale.visible = true;
            if ((locale.aMG) || (locale.bitmap != null) || (!paramBoolean)) {
              break;
            }
            a(locale);
            break;
          }
          label328:
          if (locale.sampleSize != this.aNd)
          {
            locale.visible = false;
            if (locale.bitmap != null)
            {
              locale.bitmap.recycle();
              locale.bitmap = null;
            }
          }
        }
        else if (locale.sampleSize == this.aNd)
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
    if (this.aNB == null)
    {
      i = 1;
      this.aNB = new PointF(0.0F, 0.0F);
    }
    for (;;)
    {
      if (this.aOo == null) {
        this.aOo = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      }
      this.aOo.scale = this.scale;
      this.aOo.aNB.set(this.aNB);
      a(paramBoolean, this.aOo);
      this.scale = this.aOo.scale;
      this.aNB.set(this.aOo.aNB);
      if ((i != 0) && (this.aNo != 4)) {
        this.aNB.set(h(qw() / 2, qx() / 2, this.scale));
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
    if (this.aNB == null)
    {
      AppMethodBeat.o(157439);
      return null;
    }
    paramPointF.set(W(paramFloat1), X(paramFloat2));
    AppMethodBeat.o(157439);
    return paramPointF;
  }
  
  private void b(Point paramPoint)
  {
    AppMethodBeat.i(157423);
    f("initialiseTileMap maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
    this.aNi = new LinkedHashMap();
    int i = this.aNd;
    int j = 1;
    int m = 1;
    int k = qw() / j;
    int i2 = qx() / m;
    int n = k / i;
    int i1 = i2 / i;
    while ((n + j + 1 > paramPoint.x) || ((n > getWidth() * 1.25D) && (i < this.aNd)))
    {
      j += 1;
      k = qw() / j;
      n = k / i;
    }
    for (;;)
    {
      if ((i1 + m + 1 > paramPoint.y) || ((i1 > getHeight() * 1.25D) && (i < this.aNd)))
      {
        m += 1;
        n = qx() / m;
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
            if (i == this.aNd)
            {
              bool = true;
              locale.visible = bool;
              if (i1 != j - 1) {
                break label385;
              }
              i3 = qw();
              label286:
              if (i2 != m - 1) {
                break label397;
              }
            }
            label385:
            label397:
            for (int i4 = qx();; i4 = (i2 + 1) * n)
            {
              locale.aMF = new Rect(i1 * k, i2 * n, i3, i4);
              locale.aMH = new Rect(0, 0, 0, 0);
              locale.aMI = new Rect(locale.aMF);
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
        this.aNi.put(Integer.valueOf(i), localArrayList);
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
    if ((this.aOi != null) && (!this.aNB.equals(paramPointF))) {
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
    float f1 = this.aOC;
    if (this.aOA * 0.7F > f1) {
      f1 = this.aOA;
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 < 1.0D) {
        f2 = 1.0F;
      }
      f1 = f2;
      if (f2 > this.aNk) {
        f1 = this.aNk;
      }
      return f1;
      if (this.aOB * 0.7F > f1) {
        f1 = this.aOB;
      } else {
        f1 = this.aOC * this.aNw;
      }
    }
  }
  
  public static Bitmap.Config getPreferredBitmapConfig()
  {
    return aOt;
  }
  
  private PointF h(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(157440);
    int i = getPaddingLeft();
    int j = (getWidth() - getPaddingRight() - getPaddingLeft()) / 2;
    int k = getPaddingTop();
    int m = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2;
    if (this.aOo == null) {
      this.aOo = new g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
    }
    this.aOo.scale = paramFloat3;
    this.aOo.aNB.set(i + j - paramFloat1 * paramFloat3, k + m - paramFloat2 * paramFloat3);
    a(true, this.aOo);
    PointF localPointF = this.aOo.aNB;
    AppMethodBeat.o(157440);
    return localPointF;
  }
  
  private int px(int paramInt)
  {
    return (int)(this.density * paramInt);
  }
  
  private void qm()
  {
    AppMethodBeat.i(157398);
    ac.i(this.TAG, "alvinluo initScaleRate: %f", new Object[] { Float.valueOf(this.aOC) });
    qo();
    qp();
    AppMethodBeat.o(157398);
  }
  
  private void qn()
  {
    AppMethodBeat.i(205113);
    if (this.bitmap == null)
    {
      AppMethodBeat.o(205113);
      return;
    }
    if (!this.aMX)
    {
      AppMethodBeat.o(205113);
      return;
    }
    int k = qw();
    int m = qx();
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
      if ((i == 0) || (k <= this.aOy)) {
        break label237;
      }
      bool1 = true;
      if ((j == 0) || (m <= this.aOz)) {
        break label243;
      }
      bool2 = true;
      label106:
      qm();
      if (!bool2) {
        break label249;
      }
      this.aOD = (this.aOy * 1.0F / qu());
      this.aOE = (this.aOz * 1.0F / qv());
    }
    for (;;)
    {
      ac.i(this.TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f, previewHeight: %d, previewWidth: %d, verticalLong: %b, horizontalLong: %b", new Object[] { Float.valueOf(this.aOD), Float.valueOf(this.aOE), Integer.valueOf(qv()), Integer.valueOf(qu()), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      AppMethodBeat.o(205113);
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
        this.aOD = (this.aOy * 1.0F / qu());
        this.aOE = (this.aOC * qx() / qv());
      }
      else
      {
        this.aOD = (this.aOC * qw() / qu());
        this.aOE = (this.aOC * qx() / qv());
      }
    }
  }
  
  private void qo()
  {
    AppMethodBeat.i(157399);
    this.aNk = (getDoubleTapZoomScale() * 2.0F * this.aOF);
    AppMethodBeat.o(157399);
  }
  
  private void qp()
  {
    AppMethodBeat.i(157400);
    this.aNl = Math.min(qy(), this.aOC * 0.75F);
    AppMethodBeat.o(157400);
  }
  
  private boolean qq()
  {
    AppMethodBeat.i(157414);
    if ((this.bitmap != null) && (!this.aMX))
    {
      AppMethodBeat.o(157414);
      return true;
    }
    if (this.aNi != null)
    {
      Iterator localIterator = this.aNi.entrySet().iterator();
      boolean bool2;
      for (boolean bool1 = true; localIterator.hasNext(); bool1 = bool2)
      {
        Object localObject = (Map.Entry)localIterator.next();
        bool2 = bool1;
        if (((Integer)((Map.Entry)localObject).getKey()).intValue() == this.aNd)
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject).next();
            if ((locale.aMG) || (locale.bitmap == null)) {
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
  
  private boolean qr()
  {
    AppMethodBeat.i(157415);
    if ((getWidth() > 0) && (getHeight() > 0) && (this.aMO > 0) && (this.aMP > 0) && ((this.bitmap != null) || (qq()))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.aOf) && (bool))
      {
        qt();
        this.aOf = true;
      }
      AppMethodBeat.o(157415);
      return bool;
    }
  }
  
  private boolean qs()
  {
    AppMethodBeat.i(157416);
    boolean bool = qq();
    if ((!this.aOg) && (bool))
    {
      qt();
      this.aOg = true;
      ac.i(this.TAG, "alvinluo onImageLoaded");
      qm();
      a(this.aOC, new PointF(0.0F, 0.0F));
      if (this.aNf != -1L)
      {
        this.aNg = System.currentTimeMillis();
        dA((int)(this.aNg - this.aNf));
      }
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(157384);
          if ((SubsamplingScaleImageView.u(SubsamplingScaleImageView.this) != null) && (!SubsamplingScaleImageView.u(SubsamplingScaleImageView.this).isRecycled()))
          {
            ac.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo rotateAndScale fullImageBitmap");
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
  
  private void qt()
  {
    AppMethodBeat.i(157419);
    if ((getWidth() == 0) || (getHeight() == 0) || (this.aMO <= 0) || (this.aMP <= 0))
    {
      AppMethodBeat.o(157419);
      return;
    }
    if ((this.aNF != null) && (this.aNE != null))
    {
      this.scale = this.aNE.floatValue();
      if (this.aNB == null) {
        this.aNB = new PointF();
      }
      this.aNB.x = (getWidth() / 2 - this.scale * this.aNF.x);
      this.aNB.y = (getHeight() / 2 - this.scale * this.aNF.y);
      this.aNF = null;
      this.aNE = null;
      this.aNH = false;
      aK(true);
      aJ(true);
    }
    aK(false);
    AppMethodBeat.o(157419);
  }
  
  private int qu()
  {
    AppMethodBeat.i(157431);
    if ((this.bitmap == null) || (!this.aMX))
    {
      AppMethodBeat.o(157431);
      return 0;
    }
    int i = this.aNL;
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
  
  private int qv()
  {
    AppMethodBeat.i(157432);
    if ((this.bitmap == null) || (!this.aMX))
    {
      AppMethodBeat.o(157432);
      return 0;
    }
    int i = this.aNL;
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
  
  private int qw()
  {
    AppMethodBeat.i(157433);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.aMP;
      AppMethodBeat.o(157433);
      return i;
    }
    i = this.aMO;
    AppMethodBeat.o(157433);
    return i;
  }
  
  private int qx()
  {
    AppMethodBeat.i(157434);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.aMO;
      AppMethodBeat.o(157434);
      return i;
    }
    i = this.aMP;
    AppMethodBeat.o(157434);
    return i;
  }
  
  private float qy()
  {
    AppMethodBeat.i(157441);
    int i = getPaddingBottom() + getPaddingTop();
    int j = getPaddingLeft() + getPaddingRight();
    if ((this.aNo == 2) || (this.aNo == 4))
    {
      f = Math.max((getWidth() - j) / qw(), (getHeight() - i) / qx());
      AppMethodBeat.o(157441);
      return f;
    }
    if ((this.aNo == 3) && (this.aNl > 0.0F))
    {
      f = this.aNl;
      AppMethodBeat.o(157441);
      return f;
    }
    float f = Math.min((getWidth() - j) / qw(), (getHeight() - i) / qx());
    AppMethodBeat.o(157441);
    return f;
  }
  
  private void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(157410);
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
    {
      ac.i(this.TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(157410);
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(157404);
    f("reset newImage=".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.scale = 0.0F;
    this.aNA = 0.0F;
    this.aNB = null;
    this.aNC = null;
    this.aND = null;
    this.aNE = Float.valueOf(0.0F);
    this.aNF = null;
    this.aNG = null;
    this.aNN = false;
    this.aNO = false;
    this.aNP = false;
    this.aNQ = 0;
    this.aNd = 0;
    this.aNW = null;
    this.aNX = 0.0F;
    this.aNZ = 0.0F;
    this.aOa = false;
    this.aOc = null;
    this.aOb = null;
    this.aOd = null;
    this.aOe = null;
    this.aOo = null;
    this.eY = null;
    this.aOp = null;
    Object localObject1;
    if (paramBoolean)
    {
      if (this.aOL != null)
      {
        localObject1 = this.aOL;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aML = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aMJ = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aML = 0;
      }
      this.uri = null;
      this.aMv.writeLock().lock();
    }
    com.davemorrissey.labs.subscaleview.c.e locale;
    label512:
    try
    {
      if (this.aMC != null)
      {
        this.aMC.recycle();
        this.aMC = null;
      }
      this.aMv.writeLock().unlock();
      if ((this.bitmap != null) && (!this.aNc)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aNc) && (this.aOh != null)) {
        this.aOh.qB();
      }
      this.aMO = 0;
      this.aMP = 0;
      this.aNK = 0;
      this.aMQ = null;
      this.aNM = null;
      this.aOf = false;
      this.aOg = false;
      this.bitmap = null;
      this.aMX = false;
      this.aNc = false;
      this.aMY = false;
      this.aMZ = false;
      this.aNe = true;
      if (this.aNi == null) {
        break label534;
      }
      localObject1 = this.aNi.entrySet().iterator();
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
            if (this.aNJ == null) {
              break label489;
            }
            if (this.aNJ.bitmap != locale.bitmap) {
              break label512;
            }
            ac.i(this.TAG, "alvinluo reset tile bitmap not need to recycle: %d", new Object[] { Integer.valueOf(locale.bitmap.hashCode()) });
          }
        }
      }
    }
    finally
    {
      label489:
      this.aMv.writeLock().unlock();
      AppMethodBeat.o(157404);
    }
    label529:
    this.aNi = null;
    label534:
    setGestureDetector(getContext());
    AppMethodBeat.o(157404);
  }
  
  public static void setBitmapLoaderImp(com.davemorrissey.labs.subscaleview.c.a parama)
  {
    aOu = parama;
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
          ac.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo rotate and scale fullImageBitmap cost: %d", new Object[] { Long.valueOf(l2 - l1) });
        }
        AppMethodBeat.o(157380);
      }
    }, "rotateAndScaleBitmap");
    AppMethodBeat.o(157425);
  }
  
  private void setGestureDetector(final Context paramContext)
  {
    AppMethodBeat.i(157405);
    this.aNR = new GestureDetector(paramContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(157378);
        if ((SubsamplingScaleImageView.k(SubsamplingScaleImageView.this)) && (SubsamplingScaleImageView.f(SubsamplingScaleImageView.this)) && (SubsamplingScaleImageView.g(SubsamplingScaleImageView.this) != null))
        {
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, paramContext);
          ac.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo onDoubleTap, quickScaledEnabled: %b", new Object[] { Boolean.valueOf(SubsamplingScaleImageView.m(SubsamplingScaleImageView.this)) });
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
          if (!SubsamplingScaleImageView.qz().contains(Integer.valueOf(1)))
          {
            paramAnonymousMotionEvent1 = new IllegalArgumentException("Unknown easing type: 1");
            AppMethodBeat.o(157376);
            throw paramAnonymousMotionEvent1;
          }
          paramAnonymousMotionEvent1.aPf = 1;
          paramAnonymousMotionEvent1.aPl = false;
          paramAnonymousMotionEvent1.aPg = 3;
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
    this.aNT = new GestureDetector(paramContext, new GestureDetector.SimpleOnGestureListener()
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
    aOt = paramConfig;
  }
  
  public static void setTileInitLoaderImp(com.davemorrissey.labs.subscaleview.c.c paramc)
  {
    aOw = paramc;
  }
  
  public static void setTileLoaderImp(com.davemorrissey.labs.subscaleview.c.d paramd)
  {
    aOv = paramd;
  }
  
  public final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(157427);
    if (paramBitmap == null)
    {
      ac.e(this.TAG, "alvinluo rotateAndScaleBitmap bitmap is null");
      AppMethodBeat.o(157427);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(1.0F, 1.0F);
    if (paramInt != 0) {
      localMatrix.postRotate(paramInt);
    }
    ac.d(this.TAG, "alvinluo rotateAndScaleBitmap matrix.isIdentify: %b", new Object[] { Boolean.valueOf(localMatrix.isIdentity()) });
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
        ac.printErrStackTrace(this.TAG, paramBitmap, "alvinluo createBitmap oom", new Object[0]);
        aOt = Bitmap.Config.RGB_565;
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
    this.aOe = null;
    this.aNH = true;
    this.aNE = Float.valueOf(paramFloat);
    this.aNF = paramPointF;
    this.aNG = paramPointF;
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
        ac.i(this.TAG, "alvinluo onPreviewLoaded");
        if (paramBitmap != null) {
          ac.i(this.TAG, "alvinluo onPreviewLoaded %d, recycle: %b", new Object[] { Integer.valueOf(paramBitmap.hashCode()), Boolean.valueOf(paramBitmap.isRecycled()) });
        }
        long l = System.currentTimeMillis();
        if (this.aOg)
        {
          if (this.bitmap != null) {
            this.bitmap.recycle();
          }
          AppMethodBeat.o(157428);
          return;
        }
        if (this.aNM != null)
        {
          if ((this.aNM.width() > 0) && (this.aNM.height() > 0))
          {
            this.bitmap = Bitmap.createBitmap(paramBitmap, this.aNM.left, this.aNM.top, this.aNM.width(), this.aNM.height());
            this.aNL = 0;
          }
          this.aMX = true;
          this.aMZ = false;
          this.aNa = this.bitmap.getWidth();
          this.aNb = this.bitmap.getHeight();
          qn();
          this.aMZ = true;
          if (qr())
          {
            invalidate();
            requestLayout();
          }
          dz((int)(System.currentTimeMillis() - l));
          ac.i(this.TAG, "alvinluo onPreviewLoaded");
          if ((!this.aMY) && (this.aOh != null)) {
            this.aOh.qA();
          }
          AppMethodBeat.o(157428);
          continue;
        }
        if (paramInteger == null) {
          break label283;
        }
      }
      finally {}
      this.aNL = paramInteger.intValue();
      label283:
      this.bitmap = paramBitmap;
    }
  }
  
  public final void a(com.davemorrissey.labs.subscaleview.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(157424);
      f("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.aMO), Integer.valueOf(this.aMP), Integer.valueOf(paramInt3) });
      if ((this.aMO > 0) && (this.aMP > 0) && ((this.aMO != paramInt1) || (this.aMP != paramInt2)))
      {
        reset(false);
        if (this.bitmap != null)
        {
          if (!this.aNc) {
            this.bitmap.recycle();
          }
          this.bitmap = null;
          if ((this.aOh != null) && (this.aNc)) {
            this.aOh.qB();
          }
          this.aMX = false;
          this.aNc = false;
        }
      }
      this.aMC = paramd;
      this.aMO = paramInt1;
      this.aMP = paramInt2;
      this.aNK = paramInt3;
      qr();
      if ((!qs()) && (this.aNq > 0) && (this.aNq != aNp) && (this.aNr > 0) && (this.aNr != aNp) && (getWidth() > 0) && (getHeight() > 0)) {
        a(new Point(this.aNq, this.aNr));
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
    this.aNI = parama1;
    this.aNJ = parama2;
    reset(true);
    if (parama1.uri != null) {
      this.aNK = h(getContext(), parama1.uri.toString());
    }
    if (parama2 != null)
    {
      if ((parama1.aMO > 0) && (parama1.aMP > 0)) {
        break label160;
      }
      ac.e(this.TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
    }
    while ((parama1.bitmap != null) && (parama1.aMQ != null))
    {
      b(Bitmap.createBitmap(parama1.bitmap, parama1.aMQ.left, parama1.aMQ.top, parama1.aMQ.width(), parama1.aMQ.height()), 0, false);
      AppMethodBeat.o(157403);
      return;
      label160:
      this.aMO = parama1.aMO;
      this.aMP = parama1.aMP;
      this.aNM = parama2.aMQ;
      if (parama2.bitmap != null)
      {
        this.aNc = parama2.aMR;
        a(parama2.bitmap, Integer.valueOf(0));
      }
      else
      {
        Uri localUri2 = parama2.uri;
        Uri localUri1 = localUri2;
        if (localUri2 == null)
        {
          localUri1 = localUri2;
          if (parama2.aMM != null) {
            localUri1 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama2.aMM);
          }
        }
        aOu.a(this, getContext(), this.aNU, localUri1, true).qi();
      }
    }
    if (parama1.bitmap != null)
    {
      b(parama1.bitmap, 0, parama1.aMR);
      AppMethodBeat.o(157403);
      return;
    }
    this.aMQ = parama1.aMQ;
    this.uri = parama1.uri;
    if ((this.uri == null) && (parama1.aMM != null)) {
      this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama1.aMM);
    }
    if ((parama1.aMN) || (this.aMQ != null))
    {
      aOw.a(this, getContext(), this.aNV, this.uri).qi();
      AppMethodBeat.o(157403);
      return;
    }
    aOu.a(this, getContext(), this.aNU, this.uri, false).qi();
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
      if ((this.aMO > 0) && (this.aMP > 0) && ((this.aMO != paramBitmap.getWidth()) || (this.aMP != paramBitmap.getHeight()))) {
        reset(false);
      }
      if ((this.bitmap != null) && (!this.aNc)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aNc) && (this.aOh != null)) {
        this.aOh.qB();
      }
      this.aMX = false;
      this.aNc = paramBoolean;
      this.bitmap = paramBitmap;
      this.aMO = paramBitmap.getWidth();
      this.aMP = paramBitmap.getHeight();
      this.aNK = paramInt;
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
          ac.i(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "alvinluo onImageLoaded rotaeAndScaleBitmap %d", new Object[] { Long.valueOf(l2 - l1) });
          SubsamplingScaleImageView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(157381);
              if ((SubsamplingScaleImageView.6.this.aOU) || (SubsamplingScaleImageView.6.this.aOV))
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
    //   14: putfield 302	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aNf	J
    //   17: aload_0
    //   18: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   21: astore 4
    //   23: aload_1
    //   24: getfield 835	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   27: istore_2
    //   28: aload_1
    //   29: getfield 840	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
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
    //   58: invokestatic 1213	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_1
    //   62: getfield 835	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   65: aload_0
    //   66: getfield 683	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aNd	I
    //   69: if_icmpne +40 -> 109
    //   72: aload_1
    //   73: getfield 840	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   76: ifnull +33 -> 109
    //   79: aload_0
    //   80: getfield 298	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aNe	Z
    //   83: ifeq +26 -> 109
    //   86: aload_0
    //   87: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   90: ldc_w 1351
    //   93: invokestatic 774	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 298	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aNe	Z
    //   101: aload_0
    //   102: aload_1
    //   103: getfield 840	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   106: putfield 615	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aNh	Landroid/graphics/Bitmap;
    //   109: aload_0
    //   110: invokespecial 1257	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:qr	()Z
    //   113: pop
    //   114: aload_0
    //   115: invokespecial 1274	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:qs	()Z
    //   118: pop
    //   119: aload_0
    //   120: invokespecial 1023	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:qq	()Z
    //   123: ifeq +62 -> 185
    //   126: aload_0
    //   127: getfield 870	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   130: ifnull +55 -> 185
    //   133: aload_0
    //   134: getfield 1133	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aNc	Z
    //   137: ifne +10 -> 147
    //   140: aload_0
    //   141: getfield 870	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   144: invokevirtual 843	android/graphics/Bitmap:recycle	()V
    //   147: aload_0
    //   148: aconst_null
    //   149: putfield 870	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   152: aload_0
    //   153: getfield 1135	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aOh	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   156: ifnull +19 -> 175
    //   159: aload_0
    //   160: getfield 1133	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aNc	Z
    //   163: ifeq +12 -> 175
    //   166: aload_0
    //   167: getfield 1135	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aOh	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   170: invokeinterface 1138 1 0
    //   175: aload_0
    //   176: iconst_0
    //   177: putfield 980	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMX	Z
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 1133	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aNc	Z
    //   185: aload_0
    //   186: invokevirtual 748	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:invalidate	()V
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
      AppMethodBeat.i(157390);
      if (this.aOL != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aOL;
        locala.aML += paramInt;
        ac.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aML) });
      }
      AppMethodBeat.o(157390);
      return;
    }
    finally {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157408);
    ac.d(this.TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(157408);
    return bool;
  }
  
  public final void dy(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157388);
      if (this.aOL != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aOL;
        locala.aMK += paramInt;
        ac.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aMK) });
      }
      AppMethodBeat.o(157388);
      return;
    }
    finally {}
  }
  
  public final void dz(int paramInt)
  {
    try
    {
      AppMethodBeat.i(157389);
      if (this.aOL != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aOL;
        locala.aMJ += paramInt;
        ac.d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aMJ) });
      }
      AppMethodBeat.o(157389);
      return;
    }
    finally {}
  }
  
  public final void f(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(157444);
    ac.d(this.TAG, String.format(paramString, paramVarArgs));
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
    return this.aMv;
  }
  
  public Bitmap getFullImageBitmap()
  {
    return this.aNh;
  }
  
  public int getFullImageSampleSize()
  {
    return this.aNd;
  }
  
  public com.davemorrissey.labs.subscaleview.d.a getImageDecodeRecord()
  {
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala = this.aOL;
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
    return this.aNk;
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(157453);
    float f = qy();
    AppMethodBeat.o(157453);
    return f;
  }
  
  public e getOnImageEventListener()
  {
    return this.aOh;
  }
  
  public final int getOrientation()
  {
    return this.orientation;
  }
  
  public int getPreviewHeight()
  {
    return this.aNb;
  }
  
  public int getPreviewOrientation()
  {
    return this.aNL;
  }
  
  public int getPreviewWidth()
  {
    return this.aNa;
  }
  
  public int getRequiredRotation()
  {
    if (this.orientation == -1) {
      return this.aNK;
    }
    return this.orientation;
  }
  
  public final int getSHeight()
  {
    return this.aMP;
  }
  
  public final int getSWidth()
  {
    return this.aMO;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  public final b getState()
  {
    AppMethodBeat.i(157458);
    if ((this.aNB != null) && (this.aMO > 0) && (this.aMP > 0))
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
    return this.aMQ;
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
    //   68: getstatic 226	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aMS	Ljava/util/List;
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
    //   127: invokestatic 1454	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: iconst_0
    //   131: istore_3
    //   132: goto -40 -> 92
    //   135: astore_1
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_0
    //   139: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   142: ldc_w 1456
    //   145: invokestatic 1454	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   288: invokestatic 1454	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: iload 4
    //   293: istore_3
    //   294: goto -189 -> 105
    //   297: astore_1
    //   298: aload_0
    //   299: getfield 296	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   302: ldc_w 1474
    //   305: invokestatic 1454	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    if (this.aOK != null) {
      this.aOK.onViewAttachedToWindow(this);
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
      ac.i(this.TAG, "alvinluo cancelAllTileLoadTask, task size: %d", new Object[] { Integer.valueOf(this.aOx.size()) });
      Iterator localIterator = this.aOx.iterator();
      while (localIterator.hasNext()) {
        ((com.davemorrissey.labs.subscaleview.c.b)localIterator.next()).cancel();
      }
      this.aOx.clear();
    }
    if (this.aOK != null) {
      this.aOK.onViewDetachedFromWindow(this);
    }
    AppMethodBeat.o(157392);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(157413);
    super.onDraw(paramCanvas);
    System.currentTimeMillis();
    if (this.aOk == null)
    {
      this.aOk = new Paint();
      this.aOk.setAntiAlias(true);
      this.aOk.setFilterBitmap(true);
      this.aOk.setDither(true);
    }
    if (((this.aOl == null) || (this.aOm == null)) && (this.aNj))
    {
      this.aOl = new Paint();
      this.aOl.setTextSize(px(20));
      this.aOl.setColor(-65281);
      this.aOl.setStyle(Paint.Style.FILL);
      this.aOm = new Paint();
      this.aOm.setColor(-65281);
      this.aOm.setStyle(Paint.Style.STROKE);
      this.aOm.setStrokeWidth(px(1));
    }
    if ((this.aMO == 0) || (this.aMP == 0) || (getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(157413);
      return;
    }
    int j;
    int k;
    if ((this.aNi == null) && (this.aMC != null))
    {
      j = Math.min(paramCanvas.getMaximumBitmapWidth(), this.aNq);
      k = Math.min(paramCanvas.getMaximumBitmapHeight(), this.aNr);
      i = j;
      if (j > 10000) {
        i = 10000;
      }
      j = k;
      if (k > 10000) {
        j = 10000;
      }
      ac.i(this.TAG, "alvinluo getMaxBitmapDimensions %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      a(new Point(i, j));
    }
    if (!qr())
    {
      AppMethodBeat.o(157413);
      return;
    }
    qt();
    boolean bool1;
    float f1;
    boolean bool2;
    if ((this.aOe != null) && (this.aOe.aPc != null))
    {
      if (this.aND == null) {
        this.aND = new PointF(0.0F, 0.0F);
      }
      this.aND.set(this.aNB);
      long l = System.currentTimeMillis() - this.aOe.time;
      if (l > this.aOe.duration)
      {
        bool1 = true;
        l = Math.min(l, this.aOe.duration);
        this.scale = a(this.aOe.aPf, l, this.aOe.aNA, this.aOe.aOY - this.aOe.aNA, this.aOe.duration);
        f1 = a(this.aOe.aPf, l, this.aOe.aPc.x, this.aOe.aPd.x - this.aOe.aPc.x, this.aOe.duration);
        f2 = a(this.aOe.aPf, l, this.aOe.aPc.y, this.aOe.aPd.y - this.aOe.aPc.y, this.aOe.duration);
        localObject1 = this.aNB;
        ((PointF)localObject1).x -= W(this.aOe.aPa.x) - f1;
        localObject1 = this.aNB;
        ((PointF)localObject1).y -= X(this.aOe.aPa.y) - f2;
        if ((!bool1) && (this.aOe.aNA != this.aOe.aOY)) {
          break label883;
        }
        bool2 = true;
        label669:
        aK(bool2);
        c(this.aND);
        aJ(bool1);
        if (bool1) {
          this.aOe = null;
        }
        invalidate();
      }
    }
    else
    {
      if ((this.aNi == null) || (!qq()) || (!this.aOH)) {
        break label1797;
      }
      k = Math.min(this.aNd, T(this.scale));
      localObject1 = this.aNi.entrySet().iterator();
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
          if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).visible) && ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMG) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null))) {
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
    Object localObject1 = this.aNi.entrySet().iterator();
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
              Rect localRect = ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMF;
              ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.set((int)W(localRect.left), (int)X(localRect.top), (int)W(localRect.right), (int)X(localRect.bottom));
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMG) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null)) {
                break label1737;
              }
              if (this.aOn != null) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH, this.aOn);
              }
              if (this.eY == null) {
                this.eY = new Matrix();
              }
              this.eY.reset();
              a(this.aOq, 0.0F, 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight());
              if (getRequiredRotation() != 0) {
                break label1462;
              }
              a(this.aOr, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.bottom);
              label1249:
              this.eY.setPolyToPoly(this.aOq, 0, this.aOr, 0, 4);
              if (!((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.isRecycled()) {
                paramCanvas.drawBitmap(((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap, this.eY, this.aOk);
              }
              if (this.aNj) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH, this.aOm);
              }
            }
            for (;;)
            {
              if ((!((com.davemorrissey.labs.subscaleview.c.e)localObject3).visible) || (!this.aNj)) {
                break label1795;
              }
              paramCanvas.drawText("ISS " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).sampleSize + " RECT " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMF.top + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMF.left + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMF.bottom + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMF.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.top + px(15), this.aOl);
              break label974;
              break;
              label1462:
              if (getRequiredRotation() == 90)
              {
                a(this.aOr, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.top);
                break label1249;
              }
              if (getRequiredRotation() == 180)
              {
                a(this.aOr, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.top);
                break label1249;
              }
              if (getRequiredRotation() != 270) {
                break label1249;
              }
              a(this.aOr, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.bottom);
              break label1249;
              label1737:
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMG) && (this.aNj)) {
                paramCanvas.drawText("LOADING", ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aMH.top + px(35), this.aOl);
              }
            }
          }
          label1797:
          if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
          {
            ac.d(this.TAG, "alvinluo onDraw bitmap scale: %f", new Object[] { Float.valueOf(this.scale) });
            if ((!this.aMX) || (this.aMZ))
            {
              if (this.eY == null) {
                this.eY = new Matrix();
              }
              this.eY.reset();
              i = this.bitmap.getWidth();
              j = this.bitmap.getHeight();
              if ((this.aNL == 90) || (this.aNL == 270))
              {
                i = this.bitmap.getHeight();
                j = this.bitmap.getWidth();
              }
              if (this.aMX)
              {
                f1 = i / 2.0F;
                f2 = j / 2.0F;
                qn();
                this.eY.postScale(this.aOD, this.aOE, f1, f2);
              }
              f1 = (this.aOy - this.bitmap.getWidth()) / 2;
              f2 = (this.aOz - this.bitmap.getHeight()) / 2;
              this.eY.postTranslate(f1, f2);
              ac.d(this.TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
              if (this.aOn != null)
              {
                if (this.aOp == null) {
                  this.aOp = new RectF();
                }
                localObject1 = this.aOp;
                if (!this.aMX) {
                  break label2880;
                }
                f1 = this.bitmap.getWidth();
                if (!this.aMX) {
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
    for (float f2 = this.bitmap.getHeight();; f2 = this.aMP)
    {
      ((RectF)localObject1).set(0.0F, 0.0F, f1, f2);
      this.eY.mapRect(this.aOp);
      paramCanvas.drawRect(this.aOp, this.aOn);
      paramCanvas.drawBitmap(this.bitmap, this.eY, this.aOk);
      if (this.aNj)
      {
        ac.d(this.TAG, "alvinluo onDraw debug vTranslate %f, %f", new Object[] { Float.valueOf(this.aNB.x), Float.valueOf(this.aNB.y) });
        paramCanvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.scale) }) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(qy()) }) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aNk) }) + ")", px(5), px(15), this.aOl);
        paramCanvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aNB.x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.aNB.y) }), px(5), px(30), this.aOl);
        localObject1 = getCenter();
        paramCanvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).y) }), px(5), px(45), this.aOl);
        if (this.aOe != null)
        {
          localObject1 = b(this.aOe.aOZ);
          localObject2 = b(this.aOe.aPb);
          localObject3 = b(this.aOe.aPa);
          paramCanvas.drawCircle(((PointF)localObject1).x, ((PointF)localObject1).y, px(10), this.aOm);
          this.aOm.setColor(-65536);
          paramCanvas.drawCircle(((PointF)localObject2).x, ((PointF)localObject2).y, px(20), this.aOm);
          this.aOm.setColor(-16776961);
          paramCanvas.drawCircle(((PointF)localObject3).x, ((PointF)localObject3).y, px(25), this.aOm);
          this.aOm.setColor(-16711681);
          paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.aOm);
        }
        if (this.aNW != null)
        {
          this.aOm.setColor(-65536);
          paramCanvas.drawCircle(this.aNW.x, this.aNW.y, px(20), this.aOm);
        }
        if (this.aOc != null)
        {
          this.aOm.setColor(-16776961);
          paramCanvas.drawCircle(W(this.aOc.x), X(this.aOc.y), px(35), this.aOm);
        }
        if ((this.aOd != null) && (this.aNP))
        {
          this.aOm.setColor(-16711681);
          paramCanvas.drawCircle(this.aOd.x, this.aOd.y, px(30), this.aOm);
        }
        this.aOm.setColor(-65281);
      }
      AppMethodBeat.o(157413);
      return;
      f1 = this.aMO;
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
      if ((this.aMO <= 0) || (this.aMP <= 0)) {
        break label214;
      }
      if ((paramInt2 == 0) || (i == 0)) {
        break label164;
      }
      paramInt2 = qw();
      paramInt1 = qx();
    }
    for (;;)
    {
      paramInt2 = Math.max(paramInt2, getSuggestedMinimumWidth());
      paramInt1 = Math.max(paramInt1, getSuggestedMinimumHeight());
      setMeasuredDimension(paramInt2, paramInt1);
      this.aOy = paramInt2;
      this.aOz = paramInt1;
      ac.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", new Object[] { Integer.valueOf(this.aOy), Integer.valueOf(this.aOy) });
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
        paramInt1 = (int)(qx() / qw() * j);
        paramInt2 = j;
      }
      else if (paramInt2 != 0)
      {
        paramInt2 = (int)(qw() / qx() * paramInt1);
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
    f("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(this.scale), this.aNE, Boolean.valueOf(this.aNH) });
    qm();
    PointF localPointF = getCenter();
    if (((this.aOf) || (this.aNH)) && (localPointF != null))
    {
      this.aOe = null;
      if (!this.aNH)
      {
        this.aNE = Float.valueOf(this.scale);
        this.aNF = localPointF;
      }
    }
    AppMethodBeat.o(157406);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157409);
    ac.d(this.TAG, "alvinluo SubSamplingScaleImageView onTouchEvent: %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    if ((this.aOe != null) && (!this.aOe.aPe))
    {
      requestDisallowInterceptTouchEvent(true);
      AppMethodBeat.o(157409);
      return true;
    }
    this.aOe = null;
    if (this.aNB == null)
    {
      if (this.aNT != null) {
        this.aNT.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(157409);
      return true;
    }
    if ((!this.aNP) && ((this.aNR == null) || (this.aNR.onTouchEvent(paramMotionEvent))))
    {
      this.aNN = false;
      this.aNO = false;
      this.aNQ = 0;
      AppMethodBeat.o(157409);
      return true;
    }
    if (this.aNC == null) {
      this.aNC = new PointF(0.0F, 0.0F);
    }
    if (this.aND == null) {
      this.aND = new PointF(0.0F, 0.0F);
    }
    if (this.aNW == null) {
      this.aNW = new PointF(0.0F, 0.0F);
    }
    this.aND.set(this.aNB);
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
      c(this.aND);
      bool2 = super.onTouchEvent(paramMotionEvent);
      ac.i(this.TAG, "alvinluo onTouchEvent super: %b, handled: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool1) || (bool2))
      {
        AppMethodBeat.o(157409);
        return true;
      }
      break;
    case 0: 
    case 5: 
    case 261: 
      this.aOQ = paramMotionEvent.getRawX();
      this.aOR = paramMotionEvent.getRawY();
      this.aOe = null;
      requestDisallowInterceptTouchEvent(true);
      this.aNQ = Math.max(this.aNQ, i);
      if (i >= 2) {
        if (this.aNu)
        {
          f1 = e(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
          this.aNA = this.scale;
          this.aNX = f1;
          this.aNC.set(this.aNB.x, this.aNB.y);
          this.aNW.set((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F, (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
          this.handler.removeMessages(1);
        }
      }
      for (;;)
      {
        bool1 = true;
        break;
        this.aNQ = 0;
        break label511;
        if (!this.aNP)
        {
          this.aNC.set(this.aNB.x, this.aNB.y);
          this.aNW.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          ac.i(this.TAG, "pennqin, delay time 601 ms.");
          this.handler.sendEmptyMessageDelayed(1, 601L);
        }
      }
    case 2: 
      bool2 = false;
      bool1 = bool2;
      if (this.aNQ > 0)
      {
        if (i < 2) {
          break label1330;
        }
        f3 = e(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
        f4 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
        f5 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
        this.aOJ = new PointF(f4, f5);
        bool1 = bool2;
        if (this.aNu) {
          if ((e(this.aNW.x, f4, this.aNW.y, f5) <= 5.0F) && (Math.abs(f3 - this.aNX) <= 5.0F))
          {
            bool1 = bool2;
            if (!this.aNO) {}
          }
          else
          {
            this.aNN = true;
            this.aNO = true;
            d = this.scale;
            f2 = f3 / this.aNX * this.aNA;
            f1 = f2;
            if (f2 >= this.aNk * 2.0F)
            {
              f1 = this.aNk;
              f1 = (f2 - this.aNk) * 0.1F + f1 * 2.0F;
            }
            this.scale = f1;
            ac.i(this.TAG, "alvinluo zoom preScale: %f, scale: %f, minScale: %f, maxScale: %f", new Object[] { Double.valueOf(d), Float.valueOf(this.scale), Float.valueOf(qy()), Float.valueOf(this.aNk) });
            if (this.scale > qy()) {
              break label994;
            }
            this.aNX = f3;
            this.aNA = qy();
            this.aNW.set(f4, f5);
            this.aNC.set(this.aNB);
          }
        }
      }
      for (;;)
      {
        aK(true);
        aJ(this.aNs);
        bool1 = true;
        ac.d(this.TAG, "alvinluo Action_Move consumed: %b", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break;
        }
        this.handler.removeMessages(1);
        invalidate();
        bool1 = true;
        break label303;
        if (this.aNt)
        {
          f1 = this.aNW.x;
          f2 = this.aNC.x;
          f6 = this.aNW.y;
          f7 = this.aNC.y;
          float f8 = this.scale / this.aNA;
          float f9 = this.scale / this.aNA;
          this.aNB.x = (f4 - (f1 - f2) * f8);
          this.aNB.y = (f5 - (f6 - f7) * f9);
          if (((qx() * d < getHeight()) && (this.scale * qx() >= getHeight())) || ((d * qw() < getWidth()) && (this.scale * qw() >= getWidth())))
          {
            aK(true);
            this.aNW.set(f4, f5);
            this.aNC.set(this.aNB);
            this.aNA = this.scale;
            this.aNX = f3;
          }
        }
        else if (this.aNG != null)
        {
          this.aNB.x = (getWidth() / 2 - this.scale * this.aNG.x);
          this.aNB.y = (getHeight() / 2 - this.scale * this.aNG.y);
        }
        else
        {
          this.aNB.x = (getWidth() / 2 - this.scale * (qw() / 2));
          this.aNB.y = (getHeight() / 2 - this.scale * (qx() / 2));
        }
      }
      label1330:
      if (this.aNP)
      {
        f2 = Math.abs(this.aOd.y - paramMotionEvent.getY()) * 2.0F + this.aNY;
        if (this.aNZ == -1.0F) {
          this.aNZ = f2;
        }
        if (paramMotionEvent.getY() > this.aOb.y)
        {
          i = 1;
          label1396:
          this.aOb.set(0.0F, paramMotionEvent.getY());
          f3 = 0.5F * Math.abs(1.0F - f2 / this.aNZ);
          if (f3 <= 0.03F)
          {
            f1 = f2;
            if (!this.aOa) {
              break;
            }
          }
          else
          {
            this.aOa = true;
            if (this.aNZ <= 0.0F) {
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
      this.scale = Math.max(qy(), Math.min(this.aNk, f1 * this.scale));
      if (this.aNt)
      {
        f1 = this.aNW.x;
        f3 = this.aNC.x;
        f4 = this.aNW.y;
        f5 = this.aNC.y;
        f6 = this.scale / this.aNA;
        f7 = this.scale / this.aNA;
        this.aNB.x = (this.aNW.x - (f1 - f3) * f6);
        this.aNB.y = (this.aNW.y - (f4 - f5) * f7);
        if (((qx() * d >= getHeight()) || (this.scale * qx() < getHeight())) && ((qw() * d >= getWidth()) || (this.scale * qw() < getWidth()))) {
          break label2797;
        }
        aK(true);
        this.aNW.set(b(this.aOc));
        this.aNC.set(this.aNB);
        this.aNA = this.scale;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.aNZ = f1;
        aK(true);
        aJ(this.aNs);
        bool1 = true;
        break label949;
        i = 0;
        break label1396;
        label1756:
        f1 = 1.0F - f3;
        break label1471;
        if (this.aNG != null)
        {
          this.aNB.x = (getWidth() / 2 - this.scale * this.aNG.x);
          this.aNB.y = (getHeight() / 2 - this.scale * this.aNG.y);
          f1 = f2;
        }
        else
        {
          this.aNB.x = (getWidth() / 2 - this.scale * (qw() / 2));
          this.aNB.y = (getHeight() / 2 - this.scale * (qx() / 2));
          f1 = f2;
          continue;
          bool1 = bool2;
          if (this.aNN) {
            break label949;
          }
          f1 = Math.abs(paramMotionEvent.getX() - this.aNW.x);
          f2 = Math.abs(paramMotionEvent.getY() - this.aNW.y);
          f3 = this.density * 5.0F;
          if ((f1 <= f3) && (f2 <= f3))
          {
            bool1 = bool2;
            if (!this.aNO) {
              break label949;
            }
          }
          this.aNB.x = (this.aNC.x + (paramMotionEvent.getX() - this.aNW.x));
          this.aNB.y = (this.aNC.y + (paramMotionEvent.getY() - this.aNW.y));
          f4 = this.aNB.x;
          f5 = this.aNB.y;
          aK(true);
          label2069:
          label2085:
          boolean bool3;
          label2108:
          boolean bool4;
          label2131:
          boolean bool5;
          if (f4 != this.aNB.x)
          {
            bool1 = true;
            if (f5 == this.aNB.y) {
              break label2348;
            }
            bool2 = true;
            if ((!bool1) || (f1 <= f2) || (this.aNO)) {
              break label2354;
            }
            bool3 = true;
            if ((!bool2) || (f2 <= f1) || (this.aNO)) {
              break label2360;
            }
            bool4 = true;
            if ((f5 != this.aNB.y) || (f2 <= 3.0F * f3)) {
              break label2366;
            }
            bool5 = true;
            label2159:
            ac.i(this.TAG, "alvinluo Action_Move edge atXEdge: %b, atYEdge: %b, edgeXSwipe: %b, edgeYSwipe: %b, yPan: %b, isPanning: %b,dx: %f, dy: %f, offset: %f", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(this.aNO), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
            if ((bool3) || (bool4) || ((bool1) && (bool2) && (!bool5) && (!this.aNO))) {
              break label2372;
            }
            this.aNO = true;
          }
          for (;;)
          {
            if (!this.aNt)
            {
              this.aNB.x = this.aNC.x;
              this.aNB.y = this.aNC.y;
              requestDisallowInterceptTouchEvent(false);
            }
            aJ(this.aNs);
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
              this.aNQ = 0;
              this.handler.removeMessages(1);
              requestDisallowInterceptTouchEvent(false);
            }
          }
          this.handler.removeMessages(1);
          if (this.aNP)
          {
            this.aNP = false;
            if (!this.aOa) {
              a(this.aOc, this.aNW);
            }
          }
          if ((this.aNQ > 0) && ((this.aNN) || (this.aNO)))
          {
            if ((this.aNN) && (i == 2))
            {
              this.aNO = true;
              this.aNC.set(this.aNB.x, this.aNB.y);
              if (paramMotionEvent.getActionIndex() != 1) {
                break label2657;
              }
              this.aNW.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
              label2533:
              if (this.scale > this.aOC) {
                break label2677;
              }
              ac.i(this.TAG, "alvinluo scale %f less than %f, and need to reset", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.aOC) });
              PointF localPointF = new PointF(this.aOy / 2, this.aOz / 2);
              a(localPointF, localPointF, this.aOC);
              this.aNO = false;
            }
            for (;;)
            {
              if (i < 3) {
                this.aNN = false;
              }
              if (i < 2)
              {
                this.aNO = false;
                this.aNQ = 0;
              }
              aJ(true);
              bool1 = true;
              break;
              label2657:
              this.aNW.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
              break label2533;
              label2677:
              if (this.scale > getDoubleTapZoomScale() * 2.0F)
              {
                ac.i(this.TAG, "alvinluo current scale %f larger than maxScale: %f, and reset to scale: %f", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.aNk), Float.valueOf(getDoubleTapZoomScale() * 2.0F) });
                a(a(this.aOJ), this.aOJ, getDoubleTapZoomScale() * 2.0F);
              }
            }
          }
          if (i == 1)
          {
            this.aNN = false;
            this.aNO = false;
            this.aNQ = 0;
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
    this.aNU = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
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
    this.aNU = paramb;
    AppMethodBeat.o(157448);
  }
  
  public final void setDebug(boolean paramBoolean)
  {
    this.aNj = paramBoolean;
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
    this.aNy = Math.max(0, paramInt);
    AppMethodBeat.o(157463);
  }
  
  public final void setDoubleTapZoomScale(float paramFloat)
  {
    this.aNw = paramFloat;
  }
  
  public final void setDoubleTapZoomStyle(int paramInt)
  {
    AppMethodBeat.i(157462);
    if (!aMT.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid zoom style: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157462);
      throw localIllegalArgumentException;
    }
    this.aNx = paramInt;
    AppMethodBeat.o(157462);
  }
  
  public void setEagerLoadingEnabled(boolean paramBoolean)
  {
    this.aNs = paramBoolean;
  }
  
  public void setEdgeSwipeListener(c paramc)
  {
    this.aOM = paramc;
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
    this.aNS = paramSimpleOnGestureListener;
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
    if (((localMatrix == null) && (!this.aOs.isIdentity())) || ((localMatrix != null) && (!this.aOs.equals(localMatrix))))
    {
      this.aOs.set(localMatrix);
      invalidate();
    }
    AppMethodBeat.o(157401);
  }
  
  public final void setMaxScale(float paramFloat)
  {
    this.aNk = paramFloat;
  }
  
  public void setMaxTileSize(int paramInt)
  {
    this.aNq = paramInt;
    this.aNr = paramInt;
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
    this.aNl = paramFloat;
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
    if (!aMW.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid scale type: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157450);
      throw localIllegalArgumentException;
    }
    this.aNo = paramInt;
    if (this.aOf)
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
    this.aNm = ((int)Math.min((localDisplayMetrics.ydpi + f) / 2.0F, paramInt));
    if (this.aOf)
    {
      reset(false);
      invalidate();
    }
    AppMethodBeat.o(157454);
  }
  
  public void setOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.aOK = paramOnAttachStateChangeListener;
  }
  
  public void setOnImageEventListener(e parame)
  {
    this.aOh = parame;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.aOj = paramOnLongClickListener;
  }
  
  public void setOnStateChangedListener(f paramf)
  {
    this.aOi = paramf;
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(157396);
    if (!aMS.contains(Integer.valueOf(paramInt)))
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
    this.aNt = paramBoolean;
    if ((!paramBoolean) && (this.aNB != null))
    {
      this.aNB.x = (getWidth() / 2 - this.scale * (qw() / 2));
      this.aNB.y = (getHeight() / 2 - this.scale * (qx() / 2));
      if (this.aOf)
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
    if (!aMV.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid pan limit: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(157449);
      throw localIllegalArgumentException;
    }
    this.aNn = paramInt;
    if (this.aOf)
    {
      aK(true);
      invalidate();
    }
    AppMethodBeat.o(157449);
  }
  
  public void setPreviewDone(boolean paramBoolean)
  {
    AppMethodBeat.i(157395);
    this.aOH = paramBoolean;
    invalidate();
    AppMethodBeat.o(157395);
  }
  
  public final void setQuickScaleEnabled(boolean paramBoolean)
  {
    this.aNv = paramBoolean;
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
    this.aNV = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
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
    this.aNV = paramb;
    AppMethodBeat.o(157446);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(157397);
    this.aOC = paramFloat;
    this.aNk = 2.0F;
    this.aNl = 1.0F;
    qo();
    qp();
    AppMethodBeat.o(157397);
  }
  
  public final void setTileBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(157460);
    if (Color.alpha(paramInt) == 0) {
      this.aOn = null;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(157460);
      return;
      this.aOn = new Paint();
      this.aOn.setStyle(Paint.Style.FILL);
      this.aOn.setColor(paramInt);
    }
  }
  
  public final void setZoomEnabled(boolean paramBoolean)
  {
    this.aNu = paramBoolean;
  }
  
  public void setsRegion(Rect paramRect)
  {
    this.aMQ = paramRect;
  }
  
  static final class a
  {
    float aNA;
    float aOY;
    PointF aOZ;
    PointF aPa;
    PointF aPb;
    PointF aPc;
    PointF aPd;
    boolean aPe;
    int aPf;
    int aPg;
    SubsamplingScaleImageView.d aPh;
    long duration;
    long time;
    
    private a()
    {
      AppMethodBeat.i(157385);
      this.duration = 200L;
      this.aPe = true;
      this.aPf = 2;
      this.aPg = 1;
      this.time = System.currentTimeMillis();
      AppMethodBeat.o(157385);
    }
  }
  
  public final class b
  {
    boolean aPe;
    int aPf;
    int aPg;
    private SubsamplingScaleImageView.d aPh;
    private final float aPi;
    private final PointF aPj;
    private final PointF aPk;
    boolean aPl;
    long duration;
    
    private b(float paramFloat, PointF paramPointF)
    {
      this.duration = 500L;
      this.aPf = 2;
      this.aPg = 1;
      this.aPe = true;
      this.aPl = true;
      this.aPi = paramFloat;
      this.aPj = paramPointF;
      this.aPk = null;
    }
    
    private b(float paramFloat, PointF paramPointF1, PointF paramPointF2)
    {
      this.duration = 500L;
      this.aPf = 2;
      this.aPg = 1;
      this.aPe = true;
      this.aPl = true;
      this.aPi = paramFloat;
      this.aPj = paramPointF1;
      this.aPk = paramPointF2;
    }
    
    private b(PointF paramPointF)
    {
      AppMethodBeat.i(157386);
      this.duration = 500L;
      this.aPf = 2;
      this.aPg = 1;
      this.aPe = true;
      this.aPl = true;
      this.aPi = SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
      this.aPj = paramPointF;
      this.aPk = null;
      AppMethodBeat.o(157386);
    }
    
    public final void start()
    {
      AppMethodBeat.i(157387);
      if ((SubsamplingScaleImageView.w(SubsamplingScaleImageView.this) != null) && (SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aPh != null)) {}
      try
      {
        SubsamplingScaleImageView.w(SubsamplingScaleImageView.this);
        int i = SubsamplingScaleImageView.this.getPaddingLeft();
        int j = (SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight() - SubsamplingScaleImageView.this.getPaddingLeft()) / 2;
        int k = SubsamplingScaleImageView.this.getPaddingTop();
        int m = (SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom() - SubsamplingScaleImageView.this.getPaddingTop()) / 2;
        float f3 = SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, this.aPi);
        if (this.aPl)
        {
          Object localObject = SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, this.aPj.x, this.aPj.y, f3, new PointF());
          SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, new SubsamplingScaleImageView.a((byte)0));
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aNA = SubsamplingScaleImageView.i(SubsamplingScaleImageView.this);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOY = f3;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).time = System.currentTimeMillis();
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aPb = ((PointF)localObject);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOZ = SubsamplingScaleImageView.this.getCenter();
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aPa = ((PointF)localObject);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aPc = SubsamplingScaleImageView.this.b((PointF)localObject);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aPd = new PointF(j + i, m + k);
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).duration = this.duration;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aPe = this.aPe;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aPf = this.aPf;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aPg = this.aPg;
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).time = System.currentTimeMillis();
          SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aPh = this.aPh;
          if (this.aPk != null)
          {
            float f1 = this.aPk.x - SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOZ.x * f3;
            float f2 = this.aPk.y - SubsamplingScaleImageView.w(SubsamplingScaleImageView.this).aOZ.y * f3;
            localObject = new SubsamplingScaleImageView.g(f3, new PointF(f1, f2), (byte)0);
            SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, (SubsamplingScaleImageView.g)localObject);
            SubsamplingScaleImageView.a locala = SubsamplingScaleImageView.w(SubsamplingScaleImageView.this);
            f3 = this.aPk.x;
            float f4 = ((SubsamplingScaleImageView.g)localObject).aNB.x;
            float f5 = this.aPk.y;
            locala.aPd = new PointF(f4 - f1 + f3, ((SubsamplingScaleImageView.g)localObject).aNB.y - f2 + f5);
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
          ac.w(SubsamplingScaleImageView.l(SubsamplingScaleImageView.this), "Error thrown by animation listener", new Object[] { localException });
          continue;
          PointF localPointF = this.aPj;
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
    
    public abstract void qA();
    
    public abstract void qB();
  }
  
  public static abstract interface f {}
  
  static final class g
  {
    PointF aNB;
    float scale;
    
    private g(float paramFloat, PointF paramPointF)
    {
      this.scale = paramFloat;
      this.aNB = paramPointF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView
 * JD-Core Version:    0.7.0.1
 */