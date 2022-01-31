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
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
  private static final List<Integer> aoX = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1) });
  private static final List<Integer> aoY = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
  private static final List<Integer> aoZ = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
  private static final List<Integer> apa = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
  private static final List<Integer> apb = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4) });
  public static int apv = 2147483647;
  private static Bitmap.Config aqA = Bitmap.Config.ARGB_8888;
  private static com.davemorrissey.labs.subscaleview.c.a aqB = new com.davemorrissey.labs.subscaleview.b.a();
  private static com.davemorrissey.labs.subscaleview.c.d aqC = new com.davemorrissey.labs.subscaleview.b.c();
  private static com.davemorrissey.labs.subscaleview.c.c aqD = new com.davemorrissey.labs.subscaleview.b.b();
  private final String TAG = SubsamplingScaleImageView.class.getSimpleName() + hashCode();
  private com.davemorrissey.labs.subscaleview.a.d aoG;
  public int aoT;
  public int aoU;
  private Rect aoV;
  private final ReadWriteLock aoz = new ReentrantReadWriteLock(true);
  private boolean apA = true;
  private boolean apB = true;
  private float apC = 2.0F;
  private int apD = 1;
  private int apE = 200;
  private int apF = 200;
  private float apG;
  private PointF apH;
  private PointF apI;
  private PointF apJ;
  private Float apK;
  private PointF apL;
  private PointF apM;
  private boolean apN;
  private a apO;
  private a apP;
  private int apQ;
  private int apR = 0;
  private Rect apS;
  private boolean apT;
  private boolean apU;
  private boolean apV;
  private int apW;
  private GestureDetector apX;
  private GestureDetector.SimpleOnGestureListener apY;
  private GestureDetector apZ;
  private boolean apc;
  private boolean apd;
  private boolean ape;
  private int apf;
  private int apg;
  private boolean aph;
  private int api;
  private boolean apj = true;
  private long apk = -1L;
  private long apl = -1L;
  private Bitmap apm;
  private Map<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> apn;
  private boolean apo = false;
  private float apq = 2.0F;
  private float apr = jJ();
  private int aps = -1;
  private int apt = 1;
  private int apu = 3;
  private int apw = apv;
  private int apx = apv;
  private boolean apy = true;
  private boolean apz = true;
  public Executor aqE = AsyncTask.THREAD_POOL_EXECUTOR;
  private int aqF;
  private int aqG;
  private float aqH;
  private float aqI;
  public float aqJ;
  private float aqK;
  private float aqL;
  private float aqM = 1.0F;
  private float aqN = 20.0F;
  private boolean aqO = true;
  private boolean aqP = false;
  private PointF aqQ;
  private View.OnAttachStateChangeListener aqR;
  private com.davemorrissey.labs.subscaleview.d.a aqS = new com.davemorrissey.labs.subscaleview.d.a();
  private SubsamplingScaleImageView.c aqT = new SubsamplingScaleImageView.1(this);
  private boolean aqU = false;
  private boolean aqV = false;
  private boolean aqW = false;
  private float aqX;
  private float aqY;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aqa = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aqb = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
  private PointF aqc;
  private float aqd;
  private final float aqe;
  private float aqf;
  private boolean aqg;
  private PointF aqh;
  private PointF aqi;
  private PointF aqj;
  private SubsamplingScaleImageView.a aqk;
  private boolean aql;
  private boolean aqm;
  private SubsamplingScaleImageView.e aqn;
  private SubsamplingScaleImageView.f aqo;
  private View.OnLongClickListener aqp;
  private Paint aqq;
  private Paint aqr;
  private Paint aqs;
  private Paint aqt;
  private SubsamplingScaleImageView.g aqu;
  private Matrix aqv;
  private RectF aqw;
  private float[] aqx = new float[8];
  private float[] aqy = new float[8];
  private Matrix aqz;
  private Bitmap bitmap;
  private float density = getResources().getDisplayMetrics().density;
  private Handler handler;
  private int orientation = -1;
  private float scale;
  private Uri uri;
  
  public SubsamplingScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setDoubleTapZoomScale(2.0F);
    setMinimumTileDpi(320);
    setGestureDetector(paramContext);
    this.aqz = new Matrix();
    this.handler = new Handler(new SubsamplingScaleImageView.2(this));
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.SubsamplingScaleImageView);
      if (paramAttributeSet.hasValue(a.a.SubsamplingScaleImageView_assetName))
      {
        String str = paramAttributeSet.getString(a.a.SubsamplingScaleImageView_assetName);
        if ((str != null) && (str.length() > 0))
        {
          if (str == null) {
            throw new NullPointerException("Asset name must not be null");
          }
          setImage(a.U("file:///android_asset/" + str).jx());
        }
      }
      if (paramAttributeSet.hasValue(a.a.SubsamplingScaleImageView_src))
      {
        int i = paramAttributeSet.getResourceId(a.a.SubsamplingScaleImageView_src, 0);
        if (i > 0) {
          setImage(new a(i).jx());
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
    this.aqe = TypedValue.applyDimension(1, 20.0F, paramContext.getResources().getDisplayMetrics());
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aqM = f;
    }
  }
  
  private int N(float paramFloat)
  {
    float f = paramFloat;
    if (this.aps > 0)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      f = localDisplayMetrics.xdpi;
      f = (localDisplayMetrics.ydpi + f) / 2.0F;
      f = paramFloat * (this.aps / f);
    }
    int j = (int)(jH() * f);
    int i = (int)(jI() * f);
    if ((j == 0) || (i == 0)) {
      return 32;
    }
    if ((jI() > i) || (jH() > j))
    {
      i = Math.round(jI() / i);
      j = Math.round(jH() / j);
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
      return j;
      i = 1;
    }
  }
  
  private float O(float paramFloat)
  {
    if (this.apH == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.apH.x) / this.scale;
  }
  
  private float P(float paramFloat)
  {
    if (this.apH == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.apH.y) / this.scale;
  }
  
  private float Q(float paramFloat)
  {
    if (this.apH == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.apH.x;
  }
  
  private float R(float paramFloat)
  {
    if (this.apH == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.apH.y;
  }
  
  private float S(float paramFloat)
  {
    return Math.max(jJ(), paramFloat);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat2;
    paramFloat2 = paramFloat3 - paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private static float a(int paramInt, long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("Unexpected easing type: " + paramInt);
    case 2: 
      f = (float)paramLong1 / ((float)paramLong2 / 2.0F);
      if (f < 1.0F) {
        return f * (paramFloat2 / 2.0F * f) + paramFloat1;
      }
      f -= 1.0F;
      return (f * (f - 2.0F) - 1.0F) * (-paramFloat2 / 2.0F) + paramFloat1;
    }
    float f = (float)paramLong1 / (float)paramLong2;
    return (f - 2.0F) * (-paramFloat2 * f) + paramFloat1;
  }
  
  private PointF a(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    if (this.apH == null) {
      return null;
    }
    paramPointF.set(O(paramFloat1), P(paramFloat2));
    return paramPointF;
  }
  
  private void a(PointF paramPointF1, PointF paramPointF2)
  {
    float f2;
    int i;
    label95:
    float f1;
    if (!this.apz)
    {
      if (this.apM != null)
      {
        paramPointF1.x = this.apM.x;
        paramPointF1.y = this.apM.y;
      }
    }
    else
    {
      f2 = getDoubleTapZoomScale();
      y.i(this.TAG, "alvinluo doubleTapZoom %f", new Object[] { Float.valueOf(f2) });
      if ((this.scale > f2 * 0.9D) && (this.scale != this.aqJ)) {
        break label147;
      }
      i = 1;
      if (i == 0) {
        break label153;
      }
      f1 = f2;
      label103:
      if (this.apD != 3) {
        break label161;
      }
      a(f1, paramPointF1);
    }
    for (;;)
    {
      invalidate();
      return;
      paramPointF1.x = (jH() / 2);
      paramPointF1.y = (jI() / 2);
      break;
      label147:
      i = 0;
      break label95;
      label153:
      f1 = this.aqJ;
      break label103;
      label161:
      if ((this.apD == 2) || (i == 0) || (!this.apz))
      {
        paramPointF1 = new SubsamplingScaleImageView.b(this, f1, paramPointF1, (byte)0);
        paramPointF1.arm = false;
        paramPointF1.duration = this.apE;
        SubsamplingScaleImageView.b.a(paramPointF1, 4).start();
      }
      else if (this.apD == 1)
      {
        paramPointF1 = new SubsamplingScaleImageView.b(this, f2, paramPointF1, paramPointF2, (byte)0);
        paramPointF1.arm = false;
        paramPointF1.duration = this.apE;
        SubsamplingScaleImageView.b.a(paramPointF1, 4).start();
      }
    }
  }
  
  private void a(boolean paramBoolean, SubsamplingScaleImageView.g paramg)
  {
    float f2 = 0.5F;
    boolean bool = paramBoolean;
    if (this.apt == 2)
    {
      bool = paramBoolean;
      if (this.aql) {
        bool = false;
      }
    }
    PointF localPointF = paramg.apH;
    float f4 = S(paramg.scale);
    float f3 = f4 * jH();
    float f5 = f4 * jI();
    float f1;
    if ((this.apt == 3) && (this.aql))
    {
      localPointF.x = Math.max(localPointF.x, getWidth() / 2 - f3);
      localPointF.y = Math.max(localPointF.y, getHeight() / 2 - f5);
      if ((getPaddingLeft() <= 0) && (getPaddingRight() <= 0)) {
        break label350;
      }
      f1 = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
      label157:
      if ((getPaddingTop() > 0) || (getPaddingBottom() > 0)) {
        f2 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
      }
      if ((this.apt != 3) || (!this.aql)) {
        break label357;
      }
      f2 = Math.max(0, getWidth() / 2);
      f1 = Math.max(0, getHeight() / 2);
    }
    for (;;)
    {
      localPointF.x = Math.min(localPointF.x, f2);
      localPointF.y = Math.min(localPointF.y, f1);
      paramg.scale = f4;
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
      label350:
      f1 = 0.5F;
      break label157;
      label357:
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
  
  private void ao(boolean paramBoolean)
  {
    if ((this.aoG == null) || (this.apn == null)) {
      return;
    }
    int j = Math.min(this.api, N(this.scale));
    Iterator localIterator1 = this.apn.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)localIterator2.next();
        if ((locale.sampleSize < j) || ((locale.sampleSize > j) && (locale.sampleSize != this.api)))
        {
          locale.aoL = false;
          if (locale.bitmap != null)
          {
            locale.bitmap.recycle();
            locale.bitmap = null;
          }
        }
        if (locale.sampleSize == j)
        {
          float f1 = O(0.0F);
          float f2 = O(getWidth());
          float f3 = P(0.0F);
          float f4 = P(getHeight());
          if ((f1 <= locale.aoJ.right) && (locale.aoJ.left <= f2) && (f3 <= locale.aoJ.bottom) && (locale.aoJ.top <= f4)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label330;
            }
            locale.aoL = true;
            if ((locale.aoK) || (locale.bitmap != null) || (!paramBoolean)) {
              break;
            }
            aqC.a(this, this.aoG, locale).ju();
            break;
          }
          label330:
          if (locale.sampleSize != this.api)
          {
            locale.aoL = false;
            if (locale.bitmap != null)
            {
              locale.bitmap.recycle();
              locale.bitmap = null;
            }
          }
        }
        else if (locale.sampleSize == this.api)
        {
          locale.aoL = true;
        }
      }
    }
  }
  
  private void ap(boolean paramBoolean)
  {
    int i;
    if (this.apH == null)
    {
      i = 1;
      this.apH = new PointF(0.0F, 0.0F);
    }
    for (;;)
    {
      if (this.aqu == null) {
        this.aqu = new SubsamplingScaleImageView.g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      }
      this.aqu.scale = this.scale;
      this.aqu.apH.set(this.apH);
      a(paramBoolean, this.aqu);
      this.scale = this.aqu.scale;
      this.apH.set(this.aqu.apH);
      if ((i != 0) && (this.apu != 4)) {
        this.apH.set(g(jH() / 2, jI() / 2, this.scale));
      }
      return;
      i = 0;
    }
  }
  
  private void b(Point paramPoint)
  {
    try
    {
      i("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
      this.aqu = new SubsamplingScaleImageView.g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      a(true, this.aqu);
      this.api = N(this.aqu.scale);
      c(paramPoint);
      paramPoint = ((List)this.apn.get(Integer.valueOf(this.api))).iterator();
      while (paramPoint.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)paramPoint.next();
        y.i(this.TAG, "alvinluo tile fullSampleSize: %d", new Object[] { Integer.valueOf(this.api) });
        aqC.a(this, this.aoG, locale).ju();
      }
      ao(true);
    }
    finally {}
  }
  
  private void b(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    paramPointF1 = new SubsamplingScaleImageView.b(this, paramFloat, paramPointF1, paramPointF2, (byte)0);
    paramPointF1.arm = false;
    paramPointF1.duration = this.apF;
    SubsamplingScaleImageView.b.a(paramPointF1, 2).start();
  }
  
  private void c(Point paramPoint)
  {
    i("initialiseTileMap maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
    this.apn = new LinkedHashMap();
    int i = this.api;
    int j = 1;
    int m = 1;
    int k = jH() / j;
    int i2 = jI() / m;
    int n = k / i;
    int i1 = i2 / i;
    while ((n + j + 1 > paramPoint.x) || ((n > getWidth() * 1.25D) && (i < this.api)))
    {
      j += 1;
      k = jH() / j;
      n = k / i;
    }
    for (;;)
    {
      if ((i1 + m + 1 > paramPoint.y) || ((i1 > getHeight() * 1.25D) && (i < this.api)))
      {
        m += 1;
        n = jI() / m;
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
            label259:
            int i3;
            if (i == this.api)
            {
              bool = true;
              locale.aoL = bool;
              if (i1 != j - 1) {
                break label379;
              }
              i3 = jH();
              label280:
              if (i2 != m - 1) {
                break label391;
              }
            }
            label391:
            for (int i4 = jI();; i4 = (i2 + 1) * n)
            {
              locale.aoJ = new Rect(i1 * k, i2 * n, i3, i4);
              locale.aoM = new Rect(0, 0, 0, 0);
              locale.aoN = new Rect(locale.aoJ);
              localArrayList.add(locale);
              i2 += 1;
              break;
              bool = false;
              break label259;
              label379:
              i3 = (i1 + 1) * k;
              break label280;
            }
          }
          i1 += 1;
        }
        this.apn.put(Integer.valueOf(i), localArrayList);
        if (i != 1)
        {
          i /= 2;
          break;
        }
        return;
        n = i2;
      }
    }
  }
  
  private void d(PointF paramPointF)
  {
    if ((this.aqo != null) && (!this.apH.equals(paramPointF))) {
      getCenter();
    }
  }
  
  private PointF g(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = getPaddingLeft();
    int j = (getWidth() - getPaddingRight() - getPaddingLeft()) / 2;
    int k = getPaddingTop();
    int m = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2;
    if (this.aqu == null) {
      this.aqu = new SubsamplingScaleImageView.g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
    }
    this.aqu.scale = paramFloat3;
    this.aqu.apH.set(i + j - paramFloat1 * paramFloat3, k + m - paramFloat2 * paramFloat3);
    a(true, this.aqu);
    return this.aqu.apH;
  }
  
  private float getDoubleTapZoomScale()
  {
    float f1 = this.aqJ;
    if (this.aqH * 0.7F > f1) {
      f1 = this.aqH;
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 < 1.0D) {
        f2 = 1.0F;
      }
      f1 = f2;
      if (f2 > this.apq) {
        f1 = this.apq;
      }
      return f1;
      if (this.aqI * 0.7F > f1) {
        f1 = this.aqI;
      } else {
        f1 = this.aqJ * this.apC;
      }
    }
  }
  
  public static Bitmap.Config getPreferredBitmapConfig()
  {
    return aqA;
  }
  
  private void jA()
  {
    this.apr = Math.min(jJ(), this.aqJ * 0.75F);
  }
  
  private boolean jB()
  {
    if ((this.bitmap != null) && (!this.apc)) {
      return true;
    }
    if (this.apn != null)
    {
      Iterator localIterator = this.apn.entrySet().iterator();
      boolean bool2;
      for (boolean bool1 = true; localIterator.hasNext(); bool1 = bool2)
      {
        Object localObject = (Map.Entry)localIterator.next();
        bool2 = bool1;
        if (((Integer)((Map.Entry)localObject).getKey()).intValue() == this.api)
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject).next();
            if ((locale.aoK) || (locale.bitmap == null)) {
              bool1 = false;
            }
          }
        }
      }
      return bool1;
    }
    return false;
  }
  
  private boolean jC()
  {
    if ((getWidth() > 0) && (getHeight() > 0) && (this.aoT > 0) && (this.aoU > 0) && ((this.bitmap != null) || (jB()))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.aql) && (bool))
      {
        jE();
        this.aql = true;
      }
      return bool;
    }
  }
  
  private boolean jD()
  {
    boolean bool = jB();
    if ((!this.aqm) && (bool))
    {
      jE();
      this.aqm = true;
      y.i(this.TAG, "alvinluo onImageLoaded");
      jy();
      a(this.aqJ, new PointF(0.0F, 0.0F));
      if (this.apk != -1L)
      {
        this.apl = System.currentTimeMillis();
        cx((int)(this.apl - this.apk));
      }
      com.tencent.mm.sdk.f.e.post(new SubsamplingScaleImageView.7(this), "rotateAndScaleFullImageBitmap");
    }
    return bool;
  }
  
  private void jE()
  {
    if ((getWidth() == 0) || (getHeight() == 0) || (this.aoT <= 0) || (this.aoU <= 0)) {
      return;
    }
    if ((this.apL != null) && (this.apK != null))
    {
      this.scale = this.apK.floatValue();
      if (this.apH == null) {
        this.apH = new PointF();
      }
      this.apH.x = (getWidth() / 2 - this.scale * this.apL.x);
      this.apH.y = (getHeight() / 2 - this.scale * this.apL.y);
      this.apL = null;
      this.apK = null;
      this.apN = false;
      ap(true);
      ao(true);
    }
    ap(false);
  }
  
  private int jF()
  {
    if ((this.bitmap == null) || (!this.apc)) {
      return 0;
    }
    int i = this.apR;
    if ((i == 90) || (i == 270)) {
      return this.bitmap.getHeight();
    }
    return this.bitmap.getWidth();
  }
  
  private int jG()
  {
    if ((this.bitmap == null) || (!this.apc)) {
      return 0;
    }
    int i = this.apR;
    if ((i == 90) || (i == 270)) {
      return this.bitmap.getWidth();
    }
    return this.bitmap.getHeight();
  }
  
  private int jH()
  {
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270)) {
      return this.aoU;
    }
    return this.aoT;
  }
  
  private int jI()
  {
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270)) {
      return this.aoT;
    }
    return this.aoU;
  }
  
  private float jJ()
  {
    int i = getPaddingBottom() + getPaddingTop();
    int j = getPaddingLeft() + getPaddingRight();
    if ((this.apu == 2) || (this.apu == 4)) {
      return Math.max((getWidth() - j) / jH(), (getHeight() - i) / jI());
    }
    if ((this.apu == 3) && (this.apr > 0.0F)) {
      return this.apr;
    }
    return Math.min((getWidth() - j) / jH(), (getHeight() - i) / jI());
  }
  
  private void jy()
  {
    y.i(this.TAG, "alvinluo initScaleRate: %f", new Object[] { Float.valueOf(this.aqJ) });
    jz();
    jA();
  }
  
  private void jz()
  {
    this.apq = (getDoubleTapZoomScale() * 2.0F * this.aqM);
  }
  
  private int px(int paramInt)
  {
    return (int)(this.density * paramInt);
  }
  
  private void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
    {
      y.i(this.TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void reset(boolean paramBoolean)
  {
    i("reset newImage=" + paramBoolean, new Object[0]);
    this.scale = 0.0F;
    this.apG = 0.0F;
    this.apH = null;
    this.apI = null;
    this.apJ = null;
    this.apK = Float.valueOf(0.0F);
    this.apL = null;
    this.apM = null;
    this.apT = false;
    this.apU = false;
    this.apV = false;
    this.apW = 0;
    this.api = 0;
    this.aqc = null;
    this.aqd = 0.0F;
    this.aqf = 0.0F;
    this.aqg = false;
    this.aqi = null;
    this.aqh = null;
    this.aqj = null;
    this.aqk = null;
    this.aqu = null;
    this.aqv = null;
    this.aqw = null;
    Object localObject1;
    if (paramBoolean)
    {
      if (this.aqS != null)
      {
        localObject1 = this.aqS;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aoQ = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aoO = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).aoQ = 0;
      }
      this.uri = null;
      this.aoz.writeLock().lock();
    }
    try
    {
      if (this.aoG != null)
      {
        this.aoG.recycle();
        this.aoG = null;
      }
      this.aoz.writeLock().unlock();
      if ((this.bitmap != null) && (!this.aph)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aph) && (this.aqn != null)) {
        this.aqn.jM();
      }
      this.aoT = 0;
      this.aoU = 0;
      this.apQ = 0;
      this.aoV = null;
      this.apS = null;
      this.aql = false;
      this.aqm = false;
      this.bitmap = null;
      this.apc = false;
      this.aph = false;
      this.apd = false;
      this.ape = false;
      this.apj = true;
      if (this.apn != null)
      {
        localObject1 = this.apn.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Iterator localIterator = ((List)((Map.Entry)((Iterator)localObject1).next()).getValue()).iterator();
          while (localIterator.hasNext())
          {
            com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)localIterator.next();
            locale.aoL = false;
            if (locale.bitmap != null)
            {
              locale.bitmap.recycle();
              locale.bitmap = null;
            }
          }
        }
      }
      setGestureDetector(getContext());
    }
    finally
    {
      this.aoz.writeLock().unlock();
    }
  }
  
  public static void setBitmapLoaderImp(com.davemorrissey.labs.subscaleview.c.a parama)
  {
    aqB = parama;
  }
  
  private void setFullImageBitmap(Bitmap paramBitmap)
  {
    com.tencent.mm.sdk.f.e.post(new SubsamplingScaleImageView.5(this, paramBitmap), "rotateAndScaleBitmap");
  }
  
  private void setGestureDetector(Context paramContext)
  {
    this.apX = new GestureDetector(paramContext, new SubsamplingScaleImageView.3(this, paramContext));
    this.apZ = new GestureDetector(paramContext, new SubsamplingScaleImageView.4(this));
  }
  
  public static void setPreferredBitmapConfig(Bitmap.Config paramConfig)
  {
    aqA = paramConfig;
  }
  
  public static void setTileInitLoaderImp(com.davemorrissey.labs.subscaleview.c.c paramc)
  {
    aqD = paramc;
  }
  
  public static void setTileLoaderImp(com.davemorrissey.labs.subscaleview.c.d paramd)
  {
    aqC = paramd;
  }
  
  public final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Bitmap localBitmap;
    if (paramBitmap == null)
    {
      y.e(this.TAG, "alvinluo rotateAndScaleBitmap bitmap is null");
      localBitmap = null;
    }
    Matrix localMatrix;
    do
    {
      return localBitmap;
      localMatrix = new Matrix();
      localMatrix.postScale(1.0F, 1.0F);
      if (paramInt != 0) {
        localMatrix.postRotate(paramInt);
      }
      y.d(this.TAG, "alvinluo rotateAndScaleBitmap matrix.isIdentify: %b", new Object[] { Boolean.valueOf(localMatrix.isIdentity()) });
      if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0)) {
        break;
      }
      localBitmap = paramBitmap;
    } while (localMatrix.isIdentity());
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      y.printErrStackTrace(this.TAG, paramBitmap, "alvinluo createBitmap oom", new Object[0]);
      aqA = Bitmap.Config.RGB_565;
      return null;
    }
    return null;
  }
  
  public final void a(float paramFloat, PointF paramPointF)
  {
    this.aqk = null;
    this.apN = true;
    this.apK = Float.valueOf(paramFloat);
    this.apL = paramPointF;
    this.apM = paramPointF;
    invalidate();
  }
  
  public final void a(Bitmap paramBitmap, Integer paramInteger)
  {
    boolean bool2 = true;
    label417:
    label550:
    for (;;)
    {
      int k;
      int m;
      int i;
      boolean bool1;
      int j;
      try
      {
        y.i(this.TAG, "alvinluo onPreviewLoaded");
        long l = System.currentTimeMillis();
        if (this.aqm)
        {
          if (this.bitmap != null) {
            this.bitmap.recycle();
          }
          return;
        }
        if (this.apS != null)
        {
          if ((this.apS.width() > 0) && (this.apS.height() > 0))
          {
            this.bitmap = Bitmap.createBitmap(paramBitmap, this.apS.left, this.apS.top, this.apS.width(), this.apS.height());
            this.apR = 0;
          }
          this.apc = true;
          this.ape = false;
          this.apf = this.bitmap.getWidth();
          this.apg = this.bitmap.getHeight();
          if ((this.bitmap != null) && (this.apc))
          {
            k = jH();
            m = jI();
            if (k <= m * 2.2F) {
              break label533;
            }
            i = 1;
            break label513;
            if ((i == 0) || (k <= this.aqF)) {
              break label544;
            }
            bool1 = true;
            if ((j == 0) || (m <= this.aqG)) {
              break label550;
            }
            jy();
            if (!bool2) {
              break label425;
            }
            this.aqK = (this.aqF * 1.0F / jF());
            this.aqL = (this.aqG * 1.0F / jG());
            y.i(this.TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f, previewHeight: %d, previewWidth: %d, verticalLong: %b, horizontalLong: %b", new Object[] { Float.valueOf(this.aqK), Float.valueOf(this.aqL), Integer.valueOf(jG()), Integer.valueOf(jF()), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          }
          this.ape = true;
          if (jC())
          {
            invalidate();
            requestLayout();
          }
          cw((int)(System.currentTimeMillis() - l));
          y.i(this.TAG, "alvinluo onPreviewLoaded");
          if ((this.apd) || (this.aqn == null)) {
            continue;
          }
          this.aqn.jL();
          continue;
        }
        if (paramInteger == null) {
          break label417;
        }
      }
      finally {}
      this.apR = paramInteger.intValue();
      this.bitmap = paramBitmap;
      continue;
      label425:
      if (bool1)
      {
        this.aqK = (this.aqF * 1.0F / jF());
        this.aqL = (this.aqJ * jI() / jG());
      }
      else
      {
        this.aqK = (this.aqJ * jH() / jF());
        this.aqL = (this.aqJ * jI() / jG());
        continue;
        for (;;)
        {
          if (m <= k * 2.2F) {
            break label538;
          }
          j = 1;
          break;
          i = 0;
        }
        j = 0;
        continue;
        bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  public final void a(com.davemorrissey.labs.subscaleview.a.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      i("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.aoT), Integer.valueOf(this.aoU), Integer.valueOf(paramInt3) });
      if ((this.aoT > 0) && (this.aoU > 0) && ((this.aoT != paramInt1) || (this.aoU != paramInt2)))
      {
        reset(false);
        if (this.bitmap != null)
        {
          if (!this.aph) {
            this.bitmap.recycle();
          }
          this.bitmap = null;
          if ((this.aqn != null) && (this.aph)) {
            this.aqn.jM();
          }
          this.apc = false;
          this.aph = false;
        }
      }
      this.aoG = paramd;
      this.aoT = paramInt1;
      this.aoU = paramInt2;
      this.apQ = paramInt3;
      jC();
      if ((!jD()) && (this.apw > 0) && (this.apw != apv) && (this.apx > 0) && (this.apx != apv) && (getWidth() > 0) && (getHeight() > 0)) {
        b(new Point(this.apw, this.apx));
      }
      invalidate();
      requestLayout();
      System.currentTimeMillis();
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void a(com.davemorrissey.labs.subscaleview.c.e parame)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokestatic 926	java/lang/System:currentTimeMillis	()J
    //   8: putfield 262	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:apk	J
    //   11: aload_0
    //   12: getfield 256	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   15: astore 4
    //   17: aload_1
    //   18: getfield 739	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   21: istore_2
    //   22: aload_1
    //   23: getfield 744	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   26: ifnonnull +160 -> 186
    //   29: aload 4
    //   31: ldc_w 1193
    //   34: iconst_2
    //   35: anewarray 244	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: iload_2
    //   41: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: iload_3
    //   48: invokestatic 996	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   51: aastore
    //   52: invokestatic 1123	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_1
    //   56: getfield 739	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   59: aload_0
    //   60: getfield 700	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:api	I
    //   63: if_icmpne +40 -> 103
    //   66: aload_1
    //   67: getfield 744	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   70: ifnull +33 -> 103
    //   73: aload_0
    //   74: getfield 258	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:apj	Z
    //   77: ifeq +26 -> 103
    //   80: aload_0
    //   81: getfield 256	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   84: ldc_w 1195
    //   87: invokestatic 917	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 258	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:apj	Z
    //   95: aload_0
    //   96: aload_1
    //   97: getfield 744	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   100: putfield 582	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:apm	Landroid/graphics/Bitmap;
    //   103: aload_0
    //   104: invokespecial 1169	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:jC	()Z
    //   107: pop
    //   108: aload_0
    //   109: invokespecial 1185	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:jD	()Z
    //   112: pop
    //   113: aload_0
    //   114: invokespecial 906	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:jB	()Z
    //   117: ifeq +62 -> 179
    //   120: aload_0
    //   121: getfield 790	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   124: ifnull +55 -> 179
    //   127: aload_0
    //   128: getfield 1045	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aph	Z
    //   131: ifne +10 -> 141
    //   134: aload_0
    //   135: getfield 790	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   138: invokevirtual 747	android/graphics/Bitmap:recycle	()V
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 790	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   146: aload_0
    //   147: getfield 1047	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aqn	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   150: ifnull +19 -> 169
    //   153: aload_0
    //   154: getfield 1045	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aph	Z
    //   157: ifeq +12 -> 169
    //   160: aload_0
    //   161: getfield 1047	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aqn	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   164: invokeinterface 1050 1 0
    //   169: aload_0
    //   170: iconst_0
    //   171: putfield 893	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:apc	Z
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 1045	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aph	Z
    //   179: aload_0
    //   180: invokevirtual 649	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:invalidate	()V
    //   183: aload_0
    //   184: monitorexit
    //   185: return
    //   186: iconst_0
    //   187: istore_3
    //   188: goto -159 -> 29
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	SubsamplingScaleImageView
    //   0	196	1	parame	com.davemorrissey.labs.subscaleview.c.e
    //   21	20	2	i	int
    //   1	187	3	bool	boolean
    //   15	15	4	str	String
    // Exception table:
    //   from	to	target	type
    //   4	29	191	finally
    //   29	103	191	finally
    //   103	141	191	finally
    //   141	169	191	finally
    //   169	179	191	finally
    //   179	183	191	finally
  }
  
  public final void a(a parama1, a parama2)
  {
    if (parama1 == null) {
      throw new NullPointerException("imageSource must not be null");
    }
    reset(true);
    this.apO = parama1;
    this.apP = parama2;
    if (parama1.uri != null) {
      this.apQ = h(getContext(), parama1.uri.toString());
    }
    if (parama2 != null)
    {
      if ((parama1.aoT > 0) && (parama1.aoU > 0)) {
        break label140;
      }
      y.e(this.TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
    }
    while ((parama1.bitmap != null) && (parama1.aoV != null))
    {
      b(Bitmap.createBitmap(parama1.bitmap, parama1.aoV.left, parama1.aoV.top, parama1.aoV.width(), parama1.aoV.height()), 0, false);
      return;
      label140:
      this.aoT = parama1.aoT;
      this.aoU = parama1.aoU;
      this.apS = parama2.aoV;
      if (parama2.bitmap != null)
      {
        this.aph = parama2.aoW;
        a(parama2.bitmap, Integer.valueOf(0));
      }
      else
      {
        Uri localUri2 = parama2.uri;
        Uri localUri1 = localUri2;
        if (localUri2 == null)
        {
          localUri1 = localUri2;
          if (parama2.aoR != null) {
            localUri1 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama2.aoR);
          }
        }
        aqB.a(this, getContext(), this.aqa, localUri1, true).ju();
      }
    }
    if (parama1.bitmap != null)
    {
      b(parama1.bitmap, 0, parama1.aoW);
      return;
    }
    this.aoV = parama1.aoV;
    this.uri = parama1.uri;
    if ((this.uri == null) && (parama1.aoR != null)) {
      this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama1.aoR);
    }
    if ((parama1.aoS) || (this.aoV != null))
    {
      aqD.a(this, getContext(), this.aqb, this.uri).ju();
      return;
    }
    aqB.a(this, getContext(), this.aqa, this.uri, false).ju();
  }
  
  public final PointF b(PointF paramPointF)
  {
    return a(paramPointF.x, paramPointF.y, new PointF());
  }
  
  public final void b(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    try
    {
      i("onImageLoaded has bitmap", new Object[0]);
      if ((this.aoT > 0) && (this.aoU > 0) && ((this.aoT != paramBitmap.getWidth()) || (this.aoU != paramBitmap.getHeight()))) {
        reset(false);
      }
      if ((this.bitmap != null) && (!this.aph)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.aph) && (this.aqn != null)) {
        this.aqn.jM();
      }
      this.apc = false;
      this.aph = paramBoolean;
      this.bitmap = paramBitmap;
      this.aoT = paramBitmap.getWidth();
      this.aoU = paramBitmap.getHeight();
      this.apQ = paramInt;
      com.tencent.mm.sdk.f.e.post(new SubsamplingScaleImageView.6(this, paramInt, paramBitmap, jC(), jD()), "rotateAndScaleBitmap");
      return;
    }
    finally {}
  }
  
  public final PointF c(PointF paramPointF)
  {
    float f1 = paramPointF.x;
    float f2 = paramPointF.y;
    paramPointF = new PointF();
    if (this.apH == null) {
      return null;
    }
    paramPointF.set(Q(f1), R(f2));
    return paramPointF;
  }
  
  public final void cv(int paramInt)
  {
    try
    {
      if (this.aqS != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aqS;
        locala.aoP += paramInt;
        y.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aoP) });
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cw(int paramInt)
  {
    try
    {
      if (this.aqS != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aqS;
        locala.aoO += paramInt;
        y.d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aoO) });
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cx(int paramInt)
  {
    try
    {
      if (this.aqS != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.aqS;
        locala.aoQ += paramInt;
        y.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.aoQ) });
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    y.d(this.TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final int getAppliedOrientation()
  {
    return getRequiredRotation();
  }
  
  public final PointF getCenter()
  {
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    return a(i, j, new PointF());
  }
  
  public ReadWriteLock getDecoderLock()
  {
    return this.aoz;
  }
  
  public Bitmap getFullImageBitmap()
  {
    return this.apm;
  }
  
  public int getFullImageSampleSize()
  {
    return this.api;
  }
  
  public com.davemorrissey.labs.subscaleview.d.a getImageDecodeRecord()
  {
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala = this.aqS;
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
    return this.apq;
  }
  
  public final float getMinScale()
  {
    return jJ();
  }
  
  public SubsamplingScaleImageView.e getOnImageEventListener()
  {
    return this.aqn;
  }
  
  public final int getOrientation()
  {
    return this.orientation;
  }
  
  public int getPreviewHeight()
  {
    return this.apg;
  }
  
  public int getPreviewOrientation()
  {
    return this.apR;
  }
  
  public int getPreviewWidth()
  {
    return this.apf;
  }
  
  public int getRequiredRotation()
  {
    if (this.orientation == -1) {
      return this.apQ;
    }
    return this.orientation;
  }
  
  public final int getSHeight()
  {
    return this.aoU;
  }
  
  public final int getSWidth()
  {
    return this.aoT;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  public final b getState()
  {
    if ((this.apH != null) && (this.aoT > 0) && (this.aoU > 0)) {
      return new b(getScale(), getCenter(), getOrientation());
    }
    return null;
  }
  
  public Rect getsRegion()
  {
    return this.aoV;
  }
  
  /* Error */
  public final int h(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_2
    //   7: ldc_w 1324
    //   10: invokevirtual 1328	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13: ifeq +164 -> 177
    //   16: aload_1
    //   17: invokevirtual 1332	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: aload_2
    //   21: invokestatic 1241	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   24: iconst_1
    //   25: anewarray 433	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc_w 1333
    //   33: aastore
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokevirtual 1339	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +83 -> 125
    //   45: aload_1
    //   46: invokeinterface 1344 1 0
    //   51: ifeq +74 -> 125
    //   54: aload_1
    //   55: iconst_0
    //   56: invokeinterface 1347 2 0
    //   61: istore_3
    //   62: getstatic 190	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aoX	Ljava/util/List;
    //   65: iload_3
    //   66: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: invokeinterface 1350 2 0
    //   74: istore 6
    //   76: iload 6
    //   78: ifeq +23 -> 101
    //   81: iload_3
    //   82: iconst_m1
    //   83: if_icmpeq +18 -> 101
    //   86: iload_3
    //   87: istore 4
    //   89: aload_1
    //   90: ifnull +84 -> 174
    //   93: aload_1
    //   94: invokeinterface 1353 1 0
    //   99: iload_3
    //   100: ireturn
    //   101: aload_0
    //   102: getfield 256	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   105: new 231	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 1355
    //   112: invokespecial 446	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: iload_3
    //   116: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 1357	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: iconst_0
    //   126: istore_3
    //   127: goto -41 -> 86
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_0
    //   134: getfield 256	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   137: ldc_w 1359
    //   140: invokestatic 1357	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_1
    //   144: ifnull +27 -> 171
    //   147: aload_1
    //   148: invokeinterface 1353 1 0
    //   153: iconst_0
    //   154: ireturn
    //   155: astore_1
    //   156: aload 7
    //   158: astore_2
    //   159: aload_2
    //   160: ifnull +9 -> 169
    //   163: aload_2
    //   164: invokeinterface 1353 1 0
    //   169: aload_1
    //   170: athrow
    //   171: iconst_0
    //   172: istore 4
    //   174: iload 4
    //   176: ireturn
    //   177: iload 4
    //   179: istore_3
    //   180: aload_2
    //   181: ldc_w 1361
    //   184: invokevirtual 1328	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   187: ifeq -88 -> 99
    //   190: iload 4
    //   192: istore_3
    //   193: aload_2
    //   194: ldc_w 445
    //   197: invokevirtual 1328	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   200: ifne -101 -> 99
    //   203: new 1363	android/support/d/a
    //   206: dup
    //   207: aload_2
    //   208: bipush 7
    //   210: invokevirtual 1366	java/lang/String:substring	(I)Ljava/lang/String;
    //   213: invokespecial 1367	android/support/d/a:<init>	(Ljava/lang/String;)V
    //   216: ldc_w 1369
    //   219: iconst_1
    //   220: invokevirtual 1373	android/support/d/a:getAttributeInt	(Ljava/lang/String;I)I
    //   223: istore 5
    //   225: iload 4
    //   227: istore_3
    //   228: iload 5
    //   230: iconst_1
    //   231: if_icmpeq -132 -> 99
    //   234: iload 4
    //   236: istore_3
    //   237: iload 5
    //   239: ifeq -140 -> 99
    //   242: iload 5
    //   244: bipush 6
    //   246: if_icmpne +74 -> 320
    //   249: bipush 90
    //   251: ireturn
    //   252: aload_0
    //   253: getfield 256	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   256: new 231	java/lang/StringBuilder
    //   259: dup
    //   260: ldc_w 1375
    //   263: invokespecial 446	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: iload 5
    //   268: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 1357	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: iconst_0
    //   278: ireturn
    //   279: astore_1
    //   280: aload_0
    //   281: getfield 256	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   284: ldc_w 1377
    //   287: invokestatic 1357	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: iconst_0
    //   291: ireturn
    //   292: astore_2
    //   293: aload_1
    //   294: astore 7
    //   296: aload_2
    //   297: astore_1
    //   298: aload 7
    //   300: astore_2
    //   301: goto -142 -> 159
    //   304: astore_2
    //   305: aload_1
    //   306: astore 7
    //   308: aload_2
    //   309: astore_1
    //   310: aload 7
    //   312: astore_2
    //   313: goto -154 -> 159
    //   316: astore_2
    //   317: goto -184 -> 133
    //   320: iload 5
    //   322: iconst_3
    //   323: if_icmpne +7 -> 330
    //   326: sipush 180
    //   329: ireturn
    //   330: iload 5
    //   332: bipush 8
    //   334: if_icmpne -82 -> 252
    //   337: sipush 270
    //   340: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	SubsamplingScaleImageView
    //   0	341	1	paramContext	Context
    //   0	341	2	paramString	String
    //   61	176	3	i	int
    //   4	231	4	j	int
    //   223	112	5	k	int
    //   74	3	6	bool	boolean
    //   1	310	7	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   16	41	130	java/lang/Exception
    //   16	41	155	finally
    //   203	225	279	java/lang/Exception
    //   252	277	279	java/lang/Exception
    //   45	76	292	finally
    //   101	125	292	finally
    //   133	143	304	finally
    //   45	76	316	java/lang/Exception
    //   101	125	316	java/lang/Exception
  }
  
  public final void i(String paramString, Object... paramVarArgs)
  {
    y.d(this.TAG, String.format(paramString, paramVarArgs));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.aqR != null) {
      this.aqR.onViewAttachedToWindow(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.aqR != null) {
      this.aqR.onViewDetachedFromWindow(this);
    }
    if ((this.apm != null) && (!this.apm.isRecycled())) {
      y.i(this.TAG, "alvinluo cache recycle fullImageBitmap");
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    System.currentTimeMillis();
    if (this.aqq == null)
    {
      this.aqq = new Paint();
      this.aqq.setAntiAlias(true);
      this.aqq.setFilterBitmap(true);
      this.aqq.setDither(true);
    }
    if (((this.aqr == null) || (this.aqs == null)) && (this.apo))
    {
      this.aqr = new Paint();
      this.aqr.setTextSize(px(20));
      this.aqr.setColor(-65281);
      this.aqr.setStyle(Paint.Style.FILL);
      this.aqs = new Paint();
      this.aqs.setColor(-65281);
      this.aqs.setStyle(Paint.Style.STROKE);
      this.aqs.setStrokeWidth(px(1));
    }
    if ((this.aoT == 0) || (this.aoU == 0) || (getWidth() == 0) || (getHeight() == 0)) {}
    do
    {
      return;
      if ((this.apn == null) && (this.aoG != null)) {
        b(new Point(Math.min(paramCanvas.getMaximumBitmapWidth(), this.apw), Math.min(paramCanvas.getMaximumBitmapHeight(), this.apx)));
      }
    } while (!jC());
    jE();
    boolean bool1;
    float f1;
    boolean bool2;
    label578:
    int k;
    if ((this.aqk != null) && (this.aqk.ark != null))
    {
      if (this.apJ == null) {
        this.apJ = new PointF(0.0F, 0.0F);
      }
      this.apJ.set(this.apH);
      long l = System.currentTimeMillis() - this.aqk.time;
      if (l > this.aqk.duration)
      {
        bool1 = true;
        l = Math.min(l, this.aqk.duration);
        this.scale = a(this.aqk.arn, l, this.aqk.apG, this.aqk.arg - this.aqk.apG, this.aqk.duration);
        f1 = a(this.aqk.arn, l, this.aqk.ark.x, this.aqk.arl.x - this.aqk.ark.x, this.aqk.duration);
        f2 = a(this.aqk.arn, l, this.aqk.ark.y, this.aqk.arl.y - this.aqk.ark.y, this.aqk.duration);
        localObject1 = this.apH;
        ((PointF)localObject1).x -= Q(this.aqk.ari.x) - f1;
        localObject1 = this.apH;
        ((PointF)localObject1).y -= R(this.aqk.ari.y) - f2;
        if ((!bool1) && (this.aqk.apG != this.aqk.arg)) {
          break label792;
        }
        bool2 = true;
        ap(bool2);
        d(this.apJ);
        ao(bool1);
        if (bool1) {
          this.aqk = null;
        }
        invalidate();
      }
    }
    else
    {
      if ((this.apn == null) || (!jB()) || (!this.aqO)) {
        break label1706;
      }
      k = Math.min(this.api, N(this.scale));
      localObject1 = this.apn.entrySet().iterator();
    }
    Object localObject2;
    int j;
    Object localObject3;
    for (int i = 0;; i = j)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label805;
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
          if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoL) && ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoK) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null))) {
            i = 1;
          }
        }
        bool1 = false;
        break;
        label792:
        bool2 = false;
        break label578;
      }
    }
    label805:
    Object localObject1 = this.apn.entrySet().iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((((Integer)((Map.Entry)localObject2).getKey()).intValue() == k) || (i != 0))
        {
          localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
          label1158:
          label1704:
          for (;;)
          {
            label883:
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject2).next();
              Rect localRect = ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoJ;
              ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.set((int)Q(localRect.left), (int)R(localRect.top), (int)Q(localRect.right), (int)R(localRect.bottom));
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoK) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null)) {
                break label1646;
              }
              if (this.aqt != null) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM, this.aqt);
              }
              if (this.aqv == null) {
                this.aqv = new Matrix();
              }
              this.aqv.reset();
              a(this.aqx, 0.0F, 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight());
              if (getRequiredRotation() != 0) {
                break label1371;
              }
              a(this.aqy, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.bottom);
              this.aqv.setPolyToPoly(this.aqx, 0, this.aqy, 0, 4);
              if (!((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.isRecycled()) {
                paramCanvas.drawBitmap(((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap, this.aqv, this.aqq);
              }
              if (this.apo) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM, this.aqs);
              }
            }
            for (;;)
            {
              if ((!((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoL) || (!this.apo)) {
                break label1704;
              }
              paramCanvas.drawText("ISS " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).sampleSize + " RECT " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoJ.top + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoJ.left + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoJ.bottom + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoJ.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.top + px(15), this.aqr);
              break label883;
              break;
              label1371:
              if (getRequiredRotation() == 90)
              {
                a(this.aqy, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.top);
                break label1158;
              }
              if (getRequiredRotation() == 180)
              {
                a(this.aqy, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.top);
                break label1158;
              }
              if (getRequiredRotation() != 270) {
                break label1158;
              }
              a(this.aqy, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.bottom);
              break label1158;
              label1646:
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoK) && (this.apo)) {
                paramCanvas.drawText("LOADING", ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).aoM.top + px(35), this.aqr);
              }
            }
          }
          label1706:
          if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
          {
            y.d(this.TAG, "alvinluo onDraw bitmap scale: %f", new Object[] { Float.valueOf(this.scale) });
            if ((!this.apc) || (this.ape))
            {
              if (this.aqv == null) {
                this.aqv = new Matrix();
              }
              this.aqv.reset();
              j = this.bitmap.getWidth();
              i = this.bitmap.getHeight();
              if ((this.apR == 90) || (this.apR == 270))
              {
                j = this.bitmap.getHeight();
                i = this.bitmap.getWidth();
              }
              if (this.apc)
              {
                f1 = j / 2.0F;
                f2 = i / 2.0F;
                this.aqv.postScale(this.aqK, this.aqL, f1, f2);
              }
              f1 = (this.aqF - this.bitmap.getWidth()) / 2;
              f2 = (this.aqG - this.bitmap.getHeight()) / 2;
              this.aqv.postTranslate(f1, f2);
              y.d(this.TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
              if (this.aqt != null)
              {
                if (this.aqw == null) {
                  this.aqw = new RectF();
                }
                localObject1 = this.aqw;
                if (!this.apc) {
                  break label2779;
                }
                f1 = this.bitmap.getWidth();
                label1995:
                if (!this.apc) {
                  break label2788;
                }
              }
            }
          }
        }
      }
    }
    label2779:
    label2788:
    for (float f2 = this.bitmap.getHeight();; f2 = this.aoU)
    {
      ((RectF)localObject1).set(0.0F, 0.0F, f1, f2);
      this.aqv.mapRect(this.aqw);
      paramCanvas.drawRect(this.aqw, this.aqt);
      paramCanvas.drawBitmap(this.bitmap, this.aqv, this.aqq);
      if (!this.apo) {
        break;
      }
      y.d(this.TAG, "alvinluo onDraw debug vTranslate %f, %f", new Object[] { Float.valueOf(this.apH.x), Float.valueOf(this.apH.y) });
      paramCanvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.scale) }) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(jJ()) }) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.apq) }) + ")", px(5), px(15), this.aqr);
      paramCanvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.apH.x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.apH.y) }), px(5), px(30), this.aqr);
      localObject1 = getCenter();
      paramCanvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).y) }), px(5), px(45), this.aqr);
      if (this.aqk != null)
      {
        localObject1 = c(this.aqk.arh);
        localObject2 = c(this.aqk.arj);
        localObject3 = c(this.aqk.ari);
        paramCanvas.drawCircle(((PointF)localObject1).x, ((PointF)localObject1).y, px(10), this.aqs);
        this.aqs.setColor(-65536);
        paramCanvas.drawCircle(((PointF)localObject2).x, ((PointF)localObject2).y, px(20), this.aqs);
        this.aqs.setColor(-16776961);
        paramCanvas.drawCircle(((PointF)localObject3).x, ((PointF)localObject3).y, px(25), this.aqs);
        this.aqs.setColor(-16711681);
        paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.aqs);
      }
      if (this.aqc != null)
      {
        this.aqs.setColor(-65536);
        paramCanvas.drawCircle(this.aqc.x, this.aqc.y, px(20), this.aqs);
      }
      if (this.aqi != null)
      {
        this.aqs.setColor(-16776961);
        paramCanvas.drawCircle(Q(this.aqi.x), R(this.aqi.y), px(35), this.aqs);
      }
      if ((this.aqj != null) && (this.apV))
      {
        this.aqs.setColor(-16711681);
        paramCanvas.drawCircle(this.aqj.x, this.aqj.y, px(30), this.aqs);
      }
      this.aqs.setColor(-65281);
      return;
      f1 = this.aoT;
      break label1995;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (k != 1073741824)
    {
      paramInt2 = 1;
      if (i == 1073741824) {
        break label147;
      }
      i = 1;
      label41:
      if ((this.aoT <= 0) || (this.aoU <= 0)) {
        break label202;
      }
      if ((paramInt2 == 0) || (i == 0)) {
        break label152;
      }
      paramInt2 = jH();
      paramInt1 = jI();
    }
    for (;;)
    {
      paramInt2 = Math.max(paramInt2, getSuggestedMinimumWidth());
      paramInt1 = Math.max(paramInt1, getSuggestedMinimumHeight());
      setMeasuredDimension(paramInt2, paramInt1);
      this.aqF = paramInt2;
      this.aqG = paramInt1;
      y.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", new Object[] { Integer.valueOf(this.aqF), Integer.valueOf(this.aqF) });
      return;
      paramInt2 = 0;
      break;
      label147:
      i = 0;
      break label41;
      label152:
      if (i != 0)
      {
        paramInt1 = (int)(jI() / jH() * j);
        paramInt2 = j;
      }
      else if (paramInt2 != 0)
      {
        paramInt2 = (int)(jH() / jI() * paramInt1);
      }
      else
      {
        label202:
        paramInt2 = j;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    i("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(this.scale), this.apK, Boolean.valueOf(this.apN) });
    jy();
    PointF localPointF = getCenter();
    if (((this.aql) || (this.apN)) && (localPointF != null))
    {
      this.aqk = null;
      if (!this.apN)
      {
        this.apK = Float.valueOf(this.scale);
        this.apL = localPointF;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    y.d(this.TAG, "alvinluo SubSamplingScaleImageView onTouchEvent: %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    if ((this.aqk != null) && (!this.aqk.arm))
    {
      requestDisallowInterceptTouchEvent(true);
      return true;
    }
    this.aqk = null;
    if (this.apH == null)
    {
      if (this.apZ != null) {
        this.apZ.onTouchEvent(paramMotionEvent);
      }
      return true;
    }
    if ((!this.apV) && ((this.apX == null) || (this.apX.onTouchEvent(paramMotionEvent))))
    {
      this.apT = false;
      this.apU = false;
      this.apW = 0;
      return true;
    }
    if (this.apI == null) {
      this.apI = new PointF(0.0F, 0.0F);
    }
    if (this.apJ == null) {
      this.apJ = new PointF(0.0F, 0.0F);
    }
    if (this.aqc == null) {
      this.aqc = new PointF(0.0F, 0.0F);
    }
    this.apJ.set(this.apH);
    int i = paramMotionEvent.getPointerCount();
    boolean bool1;
    label271:
    boolean bool2;
    float f1;
    label473:
    float f3;
    float f4;
    float f5;
    double d;
    float f2;
    label901:
    label946:
    float f6;
    float f7;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
      d(this.apJ);
      bool2 = super.onTouchEvent(paramMotionEvent);
      y.i(this.TAG, "alvinluo onTouchEvent super: %b, handled: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool1) || (bool2)) {
        return true;
      }
      break;
    case 0: 
    case 5: 
    case 261: 
      this.aqX = paramMotionEvent.getRawX();
      this.aqY = paramMotionEvent.getRawY();
      this.aqk = null;
      requestDisallowInterceptTouchEvent(true);
      this.apW = Math.max(this.apW, i);
      if (i >= 2) {
        if (this.apA)
        {
          f1 = a(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
          this.apG = this.scale;
          this.aqd = f1;
          this.apI.set(this.apH.x, this.apH.y);
          this.aqc.set((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F, (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
          this.handler.removeMessages(1);
        }
      }
      for (;;)
      {
        bool1 = true;
        break;
        this.apW = 0;
        break label473;
        if (!this.apV)
        {
          this.apI.set(this.apH.x, this.apH.y);
          this.aqc.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          this.handler.sendEmptyMessageDelayed(1, 600L);
        }
      }
    case 2: 
      bool2 = false;
      bool1 = bool2;
      if (this.apW > 0)
      {
        if (i < 2) {
          break label1282;
        }
        f3 = a(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
        f4 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
        f5 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
        this.aqQ = new PointF(f4, f5);
        bool1 = bool2;
        if (this.apA) {
          if ((a(this.aqc.x, f4, this.aqc.y, f5) <= 5.0F) && (Math.abs(f3 - this.aqd) <= 5.0F))
          {
            bool1 = bool2;
            if (!this.apU) {}
          }
          else
          {
            this.apT = true;
            this.apU = true;
            d = this.scale;
            f2 = f3 / this.aqd * this.apG;
            f1 = f2;
            if (f2 >= this.apq * 2.0F)
            {
              f1 = this.apq;
              f1 = (f2 - this.apq) * 0.1F + f1 * 2.0F;
            }
            this.scale = f1;
            y.i(this.TAG, "alvinluo zoom preScale: %f, scale: %f, minScale: %f, maxScale: %f", new Object[] { Double.valueOf(d), Float.valueOf(this.scale), Float.valueOf(jJ()), Float.valueOf(this.apq) });
            if (this.scale > jJ()) {
              break label946;
            }
            this.aqd = f3;
            this.apG = jJ();
            this.aqc.set(f4, f5);
            this.apI.set(this.apH);
          }
        }
      }
      for (;;)
      {
        ap(true);
        ao(this.apy);
        bool1 = true;
        y.d(this.TAG, "alvinluo Action_Move consumed: %b", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break;
        }
        this.handler.removeMessages(1);
        invalidate();
        bool1 = true;
        break label271;
        if (this.apz)
        {
          f1 = this.aqc.x;
          f2 = this.apI.x;
          f6 = this.aqc.y;
          f7 = this.apI.y;
          float f8 = this.scale / this.apG;
          float f9 = this.scale / this.apG;
          this.apH.x = (f4 - (f1 - f2) * f8);
          this.apH.y = (f5 - (f6 - f7) * f9);
          if (((jI() * d < getHeight()) && (this.scale * jI() >= getHeight())) || ((d * jH() < getWidth()) && (this.scale * jH() >= getWidth())))
          {
            ap(true);
            this.aqc.set(f4, f5);
            this.apI.set(this.apH);
            this.apG = this.scale;
            this.aqd = f3;
          }
        }
        else if (this.apM != null)
        {
          this.apH.x = (getWidth() / 2 - this.scale * this.apM.x);
          this.apH.y = (getHeight() / 2 - this.scale * this.apM.y);
        }
        else
        {
          this.apH.x = (getWidth() / 2 - this.scale * (jH() / 2));
          this.apH.y = (getHeight() / 2 - this.scale * (jI() / 2));
        }
      }
      label1282:
      if (this.apV)
      {
        f2 = Math.abs(this.aqj.y - paramMotionEvent.getY()) * 2.0F + this.aqe;
        if (this.aqf == -1.0F) {
          this.aqf = f2;
        }
        if (paramMotionEvent.getY() > this.aqh.y)
        {
          i = 1;
          label1348:
          this.aqh.set(0.0F, paramMotionEvent.getY());
          f3 = 0.5F * Math.abs(1.0F - f2 / this.aqf);
          if (f3 <= 0.03F)
          {
            f1 = f2;
            if (!this.aqg) {
              break;
            }
          }
          else
          {
            this.aqg = true;
            if (this.aqf <= 0.0F) {
              break label2750;
            }
            if (i == 0) {
              break label1708;
            }
            f1 = 1.0F + f3;
          }
        }
      }
      break;
    }
    for (;;)
    {
      label1423:
      d = this.scale;
      this.scale = Math.max(jJ(), Math.min(this.apq, f1 * this.scale));
      if (this.apz)
      {
        f1 = this.aqc.x;
        f3 = this.apI.x;
        f4 = this.aqc.y;
        f5 = this.apI.y;
        f6 = this.scale / this.apG;
        f7 = this.scale / this.apG;
        this.apH.x = (this.aqc.x - (f1 - f3) * f6);
        this.apH.y = (this.aqc.y - (f4 - f5) * f7);
        if (((jI() * d >= getHeight()) || (this.scale * jI() < getHeight())) && ((jH() * d >= getWidth()) || (this.scale * jH() < getWidth()))) {
          break label2743;
        }
        ap(true);
        this.aqc.set(c(this.aqi));
        this.apI.set(this.apH);
        this.apG = this.scale;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.aqf = f1;
        ap(true);
        ao(this.apy);
        bool1 = true;
        break label901;
        i = 0;
        break label1348;
        label1708:
        f1 = 1.0F - f3;
        break label1423;
        if (this.apM != null)
        {
          this.apH.x = (getWidth() / 2 - this.scale * this.apM.x);
          this.apH.y = (getHeight() / 2 - this.scale * this.apM.y);
          f1 = f2;
        }
        else
        {
          this.apH.x = (getWidth() / 2 - this.scale * (jH() / 2));
          this.apH.y = (getHeight() / 2 - this.scale * (jI() / 2));
          f1 = f2;
          continue;
          bool1 = bool2;
          if (this.apT) {
            break label901;
          }
          f1 = Math.abs(paramMotionEvent.getX() - this.aqc.x);
          f2 = Math.abs(paramMotionEvent.getY() - this.aqc.y);
          f3 = this.density * 5.0F;
          if ((f1 <= f3) && (f2 <= f3))
          {
            bool1 = bool2;
            if (!this.apU) {
              break label901;
            }
          }
          this.apH.x = (this.apI.x + (paramMotionEvent.getX() - this.aqc.x));
          this.apH.y = (this.apI.y + (paramMotionEvent.getY() - this.aqc.y));
          f4 = this.apH.x;
          f5 = this.apH.y;
          ap(true);
          label2021:
          label2037:
          boolean bool3;
          label2060:
          boolean bool4;
          label2083:
          boolean bool5;
          if (f4 != this.apH.x)
          {
            bool1 = true;
            if (f5 == this.apH.y) {
              break label2300;
            }
            bool2 = true;
            if ((!bool1) || (f1 <= f2) || (this.apU)) {
              break label2306;
            }
            bool3 = true;
            if ((!bool2) || (f2 <= f1) || (this.apU)) {
              break label2312;
            }
            bool4 = true;
            if ((f5 != this.apH.y) || (f2 <= 3.0F * f3)) {
              break label2318;
            }
            bool5 = true;
            label2111:
            y.i(this.TAG, "alvinluo Action_Move edge atXEdge: %b, atYEdge: %b, edgeXSwipe: %b, edgeYSwipe: %b, yPan: %b, isPanning: %b,dx: %f, dy: %f, offset: %f", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(this.apU), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
            if ((bool3) || (bool4) || ((bool1) && (bool2) && (!bool5) && (!this.apU))) {
              break label2324;
            }
            this.apU = true;
          }
          for (;;)
          {
            if (!this.apz)
            {
              this.apH.x = this.apI.x;
              this.apH.y = this.apI.y;
              requestDisallowInterceptTouchEvent(false);
            }
            ao(this.apy);
            bool1 = true;
            break;
            bool1 = false;
            break label2021;
            label2300:
            bool2 = false;
            break label2037;
            label2306:
            bool3 = false;
            break label2060;
            label2312:
            bool4 = false;
            break label2083;
            label2318:
            bool5 = false;
            break label2111;
            label2324:
            if ((f1 > f3) || (f2 > f3))
            {
              this.apW = 0;
              this.handler.removeMessages(1);
              requestDisallowInterceptTouchEvent(false);
            }
          }
          this.handler.removeMessages(1);
          if (this.apV)
          {
            this.apV = false;
            if (!this.aqg) {
              a(this.aqi, this.aqc);
            }
          }
          if ((this.apW > 0) && ((this.apT) || (this.apU)))
          {
            if ((this.apT) && (i == 2))
            {
              this.apU = true;
              this.apI.set(this.apH.x, this.apH.y);
              if (paramMotionEvent.getActionIndex() != 1) {
                break label2609;
              }
              this.aqc.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
              label2485:
              if (this.scale > this.aqJ) {
                break label2629;
              }
              y.i(this.TAG, "alvinluo scale %f less than %f, and need to reset", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.aqJ) });
              PointF localPointF = new PointF(this.aqF / 2, this.aqG / 2);
              b(localPointF, localPointF, this.aqJ);
              this.apU = false;
            }
            for (;;)
            {
              if (i < 3) {
                this.apT = false;
              }
              if (i < 2)
              {
                this.apU = false;
                this.apW = 0;
              }
              ao(true);
              bool1 = true;
              break;
              label2609:
              this.aqc.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
              break label2485;
              label2629:
              if (this.scale > getDoubleTapZoomScale() * 2.0F)
              {
                y.i(this.TAG, "alvinluo current scale %f larger than maxScale: %f, and reset to scale: %f", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.apq), Float.valueOf(getDoubleTapZoomScale() * 2.0F) });
                b(b(this.aqQ), this.aqQ, getDoubleTapZoomScale() * 2.0F);
              }
            }
          }
          if (i == 1)
          {
            this.apT = false;
            this.apU = false;
            this.apW = 0;
          }
          bool1 = false;
          break;
          return false;
          label2743:
          f1 = f2;
        }
      }
      label2750:
      f1 = 1.0F;
    }
  }
  
  public final void setBitmapDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("Decoder class cannot be set to null");
    }
    this.aqa = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
  }
  
  public final void setBitmapDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> paramb)
  {
    if (paramb == null) {
      throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }
    this.aqa = paramb;
  }
  
  public final void setDebug(boolean paramBoolean)
  {
    this.apo = paramBoolean;
  }
  
  public final void setDoubleTapZoomDpi(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    setDoubleTapZoomScale((localDisplayMetrics.ydpi + f) / 2.0F / paramInt);
  }
  
  public final void setDoubleTapZoomDuration(int paramInt)
  {
    this.apE = Math.max(0, paramInt);
  }
  
  public final void setDoubleTapZoomScale(float paramFloat)
  {
    this.apC = paramFloat;
  }
  
  public final void setDoubleTapZoomStyle(int paramInt)
  {
    if (!aoY.contains(Integer.valueOf(paramInt))) {
      throw new IllegalArgumentException("Invalid zoom style: " + paramInt);
    }
    this.apD = paramInt;
  }
  
  public void setEagerLoadingEnabled(boolean paramBoolean)
  {
    this.apy = paramBoolean;
  }
  
  public void setEdgeSwipeListener(SubsamplingScaleImageView.c paramc)
  {
    this.aqT = paramc;
  }
  
  public void setExecutor(Executor paramExecutor)
  {
    if (paramExecutor == null) {
      throw new NullPointerException("Executor must not be null");
    }
    this.aqE = paramExecutor;
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    this.apY = paramSimpleOnGestureListener;
  }
  
  public final void setImage(a parama)
  {
    a(parama, null);
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    Matrix localMatrix = paramMatrix;
    if (paramMatrix != null)
    {
      localMatrix = paramMatrix;
      if (paramMatrix.isIdentity()) {
        localMatrix = null;
      }
    }
    if (((localMatrix == null) && (!this.aqz.isIdentity())) || ((localMatrix != null) && (!this.aqz.equals(localMatrix))))
    {
      this.aqz.set(localMatrix);
      invalidate();
    }
  }
  
  public final void setMaxScale(float paramFloat)
  {
    this.apq = paramFloat;
  }
  
  public void setMaxTileSize(int paramInt)
  {
    this.apw = paramInt;
    this.apx = paramInt;
  }
  
  public final void setMaximumDpi(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    setMinScale((localDisplayMetrics.ydpi + f) / 2.0F / paramInt);
  }
  
  public final void setMinScale(float paramFloat)
  {
    this.apr = paramFloat;
  }
  
  public final void setMinimumDpi(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    setMaxScale((localDisplayMetrics.ydpi + f) / 2.0F / paramInt);
  }
  
  public final void setMinimumScaleType(int paramInt)
  {
    if (!apb.contains(Integer.valueOf(paramInt))) {
      throw new IllegalArgumentException("Invalid scale type: " + paramInt);
    }
    this.apu = paramInt;
    if (this.aql)
    {
      ap(true);
      invalidate();
    }
  }
  
  public void setMinimumTileDpi(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    this.aps = ((int)Math.min((localDisplayMetrics.ydpi + f) / 2.0F, paramInt));
    if (this.aql)
    {
      reset(false);
      invalidate();
    }
  }
  
  public void setOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.aqR = paramOnAttachStateChangeListener;
  }
  
  public void setOnImageEventListener(SubsamplingScaleImageView.e parame)
  {
    this.aqn = parame;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.aqp = paramOnLongClickListener;
  }
  
  public void setOnStateChangedListener(SubsamplingScaleImageView.f paramf)
  {
    this.aqo = paramf;
  }
  
  public final void setOrientation(int paramInt)
  {
    if (!aoX.contains(Integer.valueOf(paramInt))) {
      throw new IllegalArgumentException("Invalid orientation: " + paramInt);
    }
    this.orientation = paramInt;
    reset(false);
    invalidate();
    requestLayout();
  }
  
  public final void setPanEnabled(boolean paramBoolean)
  {
    this.apz = paramBoolean;
    if ((!paramBoolean) && (this.apH != null))
    {
      this.apH.x = (getWidth() / 2 - this.scale * (jH() / 2));
      this.apH.y = (getHeight() / 2 - this.scale * (jI() / 2));
      if (this.aql)
      {
        ao(true);
        invalidate();
      }
    }
  }
  
  public final void setPanLimit(int paramInt)
  {
    if (!apa.contains(Integer.valueOf(paramInt))) {
      throw new IllegalArgumentException("Invalid pan limit: " + paramInt);
    }
    this.apt = paramInt;
    if (this.aql)
    {
      ap(true);
      invalidate();
    }
  }
  
  public void setPreviewDone(boolean paramBoolean)
  {
    this.aqO = paramBoolean;
    invalidate();
  }
  
  public final void setQuickScaleEnabled(boolean paramBoolean)
  {
    this.apB = paramBoolean;
  }
  
  public final void setRegionDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("Decoder class cannot be set to null");
    }
    this.aqb = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
  }
  
  public final void setRegionDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> paramb)
  {
    if (paramb == null) {
      throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }
    this.aqb = paramb;
  }
  
  public void setScaleRate(float paramFloat)
  {
    this.aqJ = paramFloat;
    this.apq = 2.0F;
    this.apr = 1.0F;
    jz();
    jA();
  }
  
  public final void setTileBackgroundColor(int paramInt)
  {
    if (Color.alpha(paramInt) == 0) {
      this.aqt = null;
    }
    for (;;)
    {
      invalidate();
      return;
      this.aqt = new Paint();
      this.aqt.setStyle(Paint.Style.FILL);
      this.aqt.setColor(paramInt);
    }
  }
  
  public final void setZoomEnabled(boolean paramBoolean)
  {
    this.apA = paramBoolean;
  }
  
  public void setsRegion(Rect paramRect)
  {
    this.aoV = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView
 * JD-Core Version:    0.7.0.1
 */