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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
  public static int arO;
  private static final List<Integer> arr;
  private static final List<Integer> ars;
  private static final List<Integer> art;
  private static final List<Integer> aru;
  private static final List<Integer> arv;
  private static Bitmap.Config asT;
  private static com.davemorrissey.labs.subscaleview.c.a asU;
  private static com.davemorrissey.labs.subscaleview.c.d asV;
  private static com.davemorrissey.labs.subscaleview.c.c asW;
  private final String TAG;
  private final ReadWriteLock aqS;
  private int arA;
  private boolean arB;
  private int arC;
  private boolean arD;
  private long arE;
  private long arF;
  private Bitmap arG;
  private Map<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> arH;
  private boolean arI;
  private float arJ;
  private float arK;
  private int arL;
  private int arM;
  private int arN;
  private int arP;
  private int arQ;
  private boolean arR;
  private boolean arS;
  private boolean arT;
  private boolean arU;
  private float arV;
  private int arW;
  private int arX;
  private int arY;
  private float arZ;
  private com.davemorrissey.labs.subscaleview.a.d ara;
  public int arn;
  public int aro;
  private Rect arp;
  private boolean arw;
  private boolean arx;
  private boolean ary;
  private int arz;
  private PointF asA;
  private PointF asB;
  private PointF asC;
  private SubsamplingScaleImageView.a asD;
  private boolean asE;
  private boolean asF;
  private SubsamplingScaleImageView.e asG;
  private SubsamplingScaleImageView.f asH;
  private View.OnLongClickListener asI;
  private Paint asJ;
  private Paint asK;
  private Paint asL;
  private Paint asM;
  private SubsamplingScaleImageView.g asN;
  private Matrix asO;
  private RectF asP;
  private float[] asQ;
  private float[] asR;
  private Matrix asS;
  private LinkedList<com.davemorrissey.labs.subscaleview.c.b> asX;
  private int asY;
  private int asZ;
  private PointF asa;
  private PointF asb;
  private PointF asc;
  private Float asd;
  private PointF ase;
  private PointF asf;
  private boolean asg;
  private a ash;
  private a asi;
  private int asj;
  private int ask;
  private Rect asl;
  private boolean asm;
  private boolean asn;
  private boolean aso;
  private int asp;
  private GestureDetector asq;
  private GestureDetector.SimpleOnGestureListener asr;
  private GestureDetector ass;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> ast;
  private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> asu;
  private PointF asv;
  private float asw;
  private final float asx;
  private float asy;
  private boolean asz;
  private float ata;
  private float atb;
  public float atc;
  private float atd;
  private float ate;
  private float atf;
  private float atg;
  private boolean ath;
  private boolean ati;
  private PointF atj;
  private View.OnAttachStateChangeListener atk;
  private com.davemorrissey.labs.subscaleview.d.a atl;
  private SubsamplingScaleImageView.c atm;
  private boolean atn;
  private boolean ato;
  private boolean atp;
  private float atq;
  private float atr;
  private Bitmap bitmap;
  private boolean cancelled;
  private float density;
  public Executor executor;
  private Handler handler;
  private int orientation;
  private float scale;
  private Uri uri;
  
  static
  {
    AppMethodBeat.i(115738);
    arr = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1) });
    ars = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    art = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
    aru = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
    arv = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4) });
    arO = 2147483647;
    asT = Bitmap.Config.ARGB_8888;
    asU = new com.davemorrissey.labs.subscaleview.b.a();
    asV = new com.davemorrissey.labs.subscaleview.b.c();
    asW = new com.davemorrissey.labs.subscaleview.b.b();
    AppMethodBeat.o(115738);
  }
  
  public SubsamplingScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115659);
    this.TAG = (SubsamplingScaleImageView.class.getSimpleName() + hashCode());
    this.arD = true;
    this.arE = -1L;
    this.arF = -1L;
    this.arI = false;
    this.orientation = -1;
    this.arJ = 2.0F;
    this.arK = lD();
    this.arL = -1;
    this.arM = 1;
    this.arN = 3;
    this.arP = arO;
    this.arQ = arO;
    this.arR = true;
    this.arS = true;
    this.arT = true;
    this.arU = true;
    this.arV = 2.0F;
    this.arW = 1;
    this.arX = 200;
    this.arY = 200;
    this.ask = 0;
    this.aqS = new ReentrantReadWriteLock(true);
    this.ast = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.asu = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    this.asQ = new float[8];
    this.asR = new float[8];
    this.asX = new LinkedList();
    this.cancelled = false;
    this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
    this.atf = 1.0F;
    this.atg = 20.0F;
    this.ath = true;
    this.ati = false;
    this.atl = new com.davemorrissey.labs.subscaleview.d.a();
    this.atm = new SubsamplingScaleImageView.1(this);
    this.atn = false;
    this.ato = false;
    this.atp = false;
    this.density = getResources().getDisplayMetrics().density;
    setDoubleTapZoomScale(2.0F);
    setMinimumTileDpi(320);
    setGestureDetector(paramContext);
    this.asS = new Matrix();
    this.handler = new Handler(new SubsamplingScaleImageView.2(this));
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.SubsamplingScaleImageView);
      if (paramAttributeSet.hasValue(1))
      {
        String str = paramAttributeSet.getString(1);
        if ((str != null) && (str.length() > 0))
        {
          if (str == null)
          {
            paramContext = new NullPointerException("Asset name must not be null");
            AppMethodBeat.o(115659);
            throw paramContext;
          }
          setImage(a.Y("file:///android_asset/".concat(String.valueOf(str))).lr());
        }
      }
      if (paramAttributeSet.hasValue(0))
      {
        int i = paramAttributeSet.getResourceId(0, 0);
        if (i > 0) {
          setImage(new a(i).lr());
        }
      }
      if (paramAttributeSet.hasValue(2)) {
        setPanEnabled(paramAttributeSet.getBoolean(2, true));
      }
      if (paramAttributeSet.hasValue(3)) {
        setZoomEnabled(paramAttributeSet.getBoolean(3, true));
      }
      if (paramAttributeSet.hasValue(4)) {
        setQuickScaleEnabled(paramAttributeSet.getBoolean(4, true));
      }
      if (paramAttributeSet.hasValue(5)) {
        setTileBackgroundColor(paramAttributeSet.getColor(5, Color.argb(0, 0, 0, 0)));
      }
      paramAttributeSet.recycle();
    }
    this.asx = TypedValue.applyDimension(1, 20.0F, paramContext.getResources().getDisplayMetrics());
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.atf = f;
    }
    AppMethodBeat.o(115659);
  }
  
  private int M(float paramFloat)
  {
    AppMethodBeat.i(115685);
    float f = paramFloat;
    if (this.arL > 0)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      f = localDisplayMetrics.xdpi;
      f = (localDisplayMetrics.ydpi + f) / 2.0F;
      f = paramFloat * (this.arL / f);
    }
    int j = (int)(lB() * f);
    int i = (int)(lC() * f);
    if ((j == 0) || (i == 0))
    {
      AppMethodBeat.o(115685);
      return 32;
    }
    if ((lC() > i) || (lB() > j))
    {
      i = Math.round(lC() / i);
      j = Math.round(lB() / j);
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
      AppMethodBeat.o(115685);
      return j;
      i = 1;
    }
  }
  
  private float N(float paramFloat)
  {
    if (this.asa == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.asa.x) / this.scale;
  }
  
  private float O(float paramFloat)
  {
    if (this.asa == null) {
      return (0.0F / 0.0F);
    }
    return (paramFloat - this.asa.y) / this.scale;
  }
  
  private float P(float paramFloat)
  {
    if (this.asa == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.asa.x;
  }
  
  private float Q(float paramFloat)
  {
    if (this.asa == null) {
      return (0.0F / 0.0F);
    }
    return this.scale * paramFloat + this.asa.y;
  }
  
  private float R(float paramFloat)
  {
    AppMethodBeat.i(115707);
    paramFloat = Math.max(lD(), paramFloat);
    AppMethodBeat.o(115707);
    return paramFloat;
  }
  
  private static float a(int paramInt, long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(115708);
    switch (paramInt)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Unexpected easing type: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(115708);
      throw localIllegalStateException;
    case 2: 
      paramFloat1 = d(paramLong1, paramFloat1, paramFloat2, paramLong2);
      AppMethodBeat.o(115708);
      return paramFloat1;
    }
    paramFloat1 = c(paramLong1, paramFloat1, paramFloat2, paramLong2);
    AppMethodBeat.o(115708);
    return paramFloat1;
  }
  
  private PointF a(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    AppMethodBeat.i(115702);
    if (this.asa == null)
    {
      AppMethodBeat.o(115702);
      return null;
    }
    paramPointF.set(N(paramFloat1), O(paramFloat2));
    AppMethodBeat.o(115702);
    return paramPointF;
  }
  
  private void a(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(115676);
    float f2;
    int i;
    label101:
    float f1;
    if (!this.arS)
    {
      if (this.asf != null)
      {
        paramPointF1.x = this.asf.x;
        paramPointF1.y = this.asf.y;
      }
    }
    else
    {
      f2 = getDoubleTapZoomScale();
      ab.i(this.TAG, "alvinluo doubleTapZoom %f", new Object[] { Float.valueOf(f2) });
      if ((this.scale > f2 * 0.9D) && (this.scale != this.atc)) {
        break label159;
      }
      i = 1;
      if (i == 0) {
        break label165;
      }
      f1 = f2;
      label109:
      if (this.arW != 3) {
        break label173;
      }
      a(f1, paramPointF1);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(115676);
      return;
      paramPointF1.x = (lB() / 2);
      paramPointF1.y = (lC() / 2);
      break;
      label159:
      i = 0;
      break label101;
      label165:
      f1 = this.atc;
      break label109;
      label173:
      if ((this.arW == 2) || (i == 0) || (!this.arS))
      {
        paramPointF1 = new SubsamplingScaleImageView.b(this, f1, paramPointF1, (byte)0);
        paramPointF1.atE = false;
        paramPointF1.duration = this.arX;
        paramPointF1.atG = 4;
        paramPointF1.start();
      }
      else if (this.arW == 1)
      {
        paramPointF1 = new SubsamplingScaleImageView.b(this, f2, paramPointF1, paramPointF2, (byte)0);
        paramPointF1.atE = false;
        paramPointF1.duration = this.arX;
        paramPointF1.atG = 4;
        paramPointF1.start();
      }
    }
  }
  
  private void a(com.davemorrissey.labs.subscaleview.c.e parame)
  {
    AppMethodBeat.i(115658);
    if (this.cancelled)
    {
      ab.i(this.TAG, "alvinluo newLoadTask, has cancelled and ignore");
      AppMethodBeat.o(115658);
      return;
    }
    parame = asV.a(this, this.ara, parame);
    parame.lo();
    this.asX.add(parame);
    AppMethodBeat.o(115658);
  }
  
  private void a(boolean paramBoolean, SubsamplingScaleImageView.g paramg)
  {
    float f2 = 0.5F;
    AppMethodBeat.i(115686);
    boolean bool = paramBoolean;
    if (this.arM == 2)
    {
      bool = paramBoolean;
      if (this.asE) {
        bool = false;
      }
    }
    PointF localPointF = paramg.asa;
    float f4 = R(paramg.scale);
    float f3 = f4 * lB();
    float f5 = f4 * lC();
    float f1;
    if ((this.arM == 3) && (this.asE))
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
      if ((this.arM != 3) || (!this.asE)) {
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
      AppMethodBeat.o(115686);
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
  
  private void ax(boolean paramBoolean)
  {
    AppMethodBeat.i(115683);
    if ((this.ara == null) || (this.arH == null))
    {
      AppMethodBeat.o(115683);
      return;
    }
    int j = Math.min(this.arC, M(this.scale));
    Iterator localIterator1 = this.arH.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)localIterator2.next();
        if ((locale.sampleSize < j) || ((locale.sampleSize > j) && (locale.sampleSize != this.arC)))
        {
          locale.arf = false;
          if (locale.bitmap != null)
          {
            locale.bitmap.recycle();
            locale.bitmap = null;
          }
        }
        if (locale.sampleSize == j)
        {
          float f1 = N(0.0F);
          float f2 = N(getWidth());
          float f3 = O(0.0F);
          float f4 = O(getHeight());
          if ((f1 <= locale.ard.right) && (locale.ard.left <= f2) && (f3 <= locale.ard.bottom) && (locale.ard.top <= f4)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label328;
            }
            locale.arf = true;
            if ((locale.are) || (locale.bitmap != null) || (!paramBoolean)) {
              break;
            }
            a(locale);
            break;
          }
          label328:
          if (locale.sampleSize != this.arC)
          {
            locale.arf = false;
            if (locale.bitmap != null)
            {
              locale.bitmap.recycle();
              locale.bitmap = null;
            }
          }
        }
        else if (locale.sampleSize == this.arC)
        {
          locale.arf = true;
        }
      }
    }
    AppMethodBeat.o(115683);
  }
  
  private void ay(boolean paramBoolean)
  {
    AppMethodBeat.i(115687);
    int i;
    if (this.asa == null)
    {
      i = 1;
      this.asa = new PointF(0.0F, 0.0F);
    }
    for (;;)
    {
      if (this.asN == null) {
        this.asN = new SubsamplingScaleImageView.g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      }
      this.asN.scale = this.scale;
      this.asN.asa.set(this.asa);
      a(paramBoolean, this.asN);
      this.scale = this.asN.scale;
      this.asa.set(this.asN.asa);
      if ((i != 0) && (this.arN != 4)) {
        this.asa.set(g(lB() / 2, lC() / 2, this.scale));
      }
      AppMethodBeat.o(115687);
      return;
      i = 0;
    }
  }
  
  private static float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(115700);
    paramFloat1 -= paramFloat2;
    paramFloat2 = paramFloat3 - paramFloat4;
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    AppMethodBeat.o(115700);
    return paramFloat1;
  }
  
  private PointF b(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    AppMethodBeat.i(115704);
    if (this.asa == null)
    {
      AppMethodBeat.o(115704);
      return null;
    }
    paramPointF.set(P(paramFloat1), Q(paramFloat2));
    AppMethodBeat.o(115704);
    return paramPointF;
  }
  
  private void b(Point paramPoint)
  {
    try
    {
      AppMethodBeat.i(115682);
      f("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
      this.asN = new SubsamplingScaleImageView.g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
      a(true, this.asN);
      this.arC = M(this.asN.scale);
      c(paramPoint);
      paramPoint = ((List)this.arH.get(Integer.valueOf(this.arC))).iterator();
      while (paramPoint.hasNext())
      {
        com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)paramPoint.next();
        ab.i(this.TAG, "alvinluo tile fullSampleSize: %d", new Object[] { Integer.valueOf(this.arC) });
        a(locale);
      }
      ax(true);
    }
    finally {}
    AppMethodBeat.o(115682);
  }
  
  private void b(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    AppMethodBeat.i(115677);
    paramPointF1 = new SubsamplingScaleImageView.b(this, paramFloat, paramPointF1, paramPointF2, (byte)0);
    paramPointF1.atE = false;
    paramPointF1.duration = this.arY;
    paramPointF1.atG = 2;
    paramPointF1.start();
    AppMethodBeat.o(115677);
  }
  
  private static float c(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    float f = (float)paramLong1 / (float)paramLong2;
    return (f - 2.0F) * (-paramFloat2 * f) + paramFloat1;
  }
  
  private void c(Point paramPoint)
  {
    AppMethodBeat.i(115688);
    f("initialiseTileMap maxTileDimensions=%dx%d", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y) });
    this.arH = new LinkedHashMap();
    int i = this.arC;
    int j = 1;
    int m = 1;
    int k = lB() / j;
    int i2 = lC() / m;
    int n = k / i;
    int i1 = i2 / i;
    while ((n + j + 1 > paramPoint.x) || ((n > getWidth() * 1.25D) && (i < this.arC)))
    {
      j += 1;
      k = lB() / j;
      n = k / i;
    }
    for (;;)
    {
      if ((i1 + m + 1 > paramPoint.y) || ((i1 > getHeight() * 1.25D) && (i < this.arC)))
      {
        m += 1;
        n = lC() / m;
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
            if (i == this.arC)
            {
              bool = true;
              locale.arf = bool;
              if (i1 != j - 1) {
                break label385;
              }
              i3 = lB();
              label286:
              if (i2 != m - 1) {
                break label397;
              }
            }
            label385:
            label397:
            for (int i4 = lC();; i4 = (i2 + 1) * n)
            {
              locale.ard = new Rect(i1 * k, i2 * n, i3, i4);
              locale.arg = new Rect(0, 0, 0, 0);
              locale.arh = new Rect(locale.ard);
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
        this.arH.put(Integer.valueOf(i), localArrayList);
        if (i != 1)
        {
          i /= 2;
          break;
        }
        AppMethodBeat.o(115688);
        return;
        n = i2;
      }
    }
  }
  
  private static float d(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    float f = (float)paramLong1 / ((float)paramLong2 / 2.0F);
    if (f < 1.0F) {
      return f * (paramFloat2 / 2.0F * f) + paramFloat1;
    }
    f -= 1.0F;
    return (f * (f - 2.0F) - 1.0F) * (-paramFloat2 / 2.0F) + paramFloat1;
  }
  
  private void d(PointF paramPointF)
  {
    AppMethodBeat.i(115730);
    if ((this.asH != null) && (!this.asa.equals(paramPointF))) {
      getCenter();
    }
    AppMethodBeat.o(115730);
  }
  
  private PointF g(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(115705);
    int i = getPaddingLeft();
    int j = (getWidth() - getPaddingRight() - getPaddingLeft()) / 2;
    int k = getPaddingTop();
    int m = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2;
    if (this.asN == null) {
      this.asN = new SubsamplingScaleImageView.g(0.0F, new PointF(0.0F, 0.0F), (byte)0);
    }
    this.asN.scale = paramFloat3;
    this.asN.asa.set(i + j - paramFloat1 * paramFloat3, k + m - paramFloat2 * paramFloat3);
    a(true, this.asN);
    PointF localPointF = this.asN.asa;
    AppMethodBeat.o(115705);
    return localPointF;
  }
  
  private float getDoubleTapZoomScale()
  {
    float f1 = this.atc;
    if (this.ata * 0.7F > f1) {
      f1 = this.ata;
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 < 1.0D) {
        f2 = 1.0F;
      }
      f1 = f2;
      if (f2 > this.arJ) {
        f1 = this.arJ;
      }
      return f1;
      if (this.atb * 0.7F > f1) {
        f1 = this.atb;
      } else {
        f1 = this.atc * this.arV;
      }
    }
  }
  
  public static Bitmap.Config getPreferredBitmapConfig()
  {
    return asT;
  }
  
  private int lA()
  {
    AppMethodBeat.i(115697);
    if ((this.bitmap == null) || (!this.arw))
    {
      AppMethodBeat.o(115697);
      return 0;
    }
    int i = this.ask;
    if ((i == 90) || (i == 270))
    {
      i = this.bitmap.getWidth();
      AppMethodBeat.o(115697);
      return i;
    }
    i = this.bitmap.getHeight();
    AppMethodBeat.o(115697);
    return i;
  }
  
  private int lB()
  {
    AppMethodBeat.i(115698);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.aro;
      AppMethodBeat.o(115698);
      return i;
    }
    i = this.arn;
    AppMethodBeat.o(115698);
    return i;
  }
  
  private int lC()
  {
    AppMethodBeat.i(115699);
    int i = getRequiredRotation();
    if ((i == 90) || (i == 270))
    {
      i = this.arn;
      AppMethodBeat.o(115699);
      return i;
    }
    i = this.aro;
    AppMethodBeat.o(115699);
    return i;
  }
  
  private float lD()
  {
    AppMethodBeat.i(115706);
    int i = getPaddingBottom() + getPaddingTop();
    int j = getPaddingLeft() + getPaddingRight();
    if ((this.arN == 2) || (this.arN == 4))
    {
      f = Math.max((getWidth() - j) / lB(), (getHeight() - i) / lC());
      AppMethodBeat.o(115706);
      return f;
    }
    if ((this.arN == 3) && (this.arK > 0.0F))
    {
      f = this.arK;
      AppMethodBeat.o(115706);
      return f;
    }
    float f = Math.min((getWidth() - j) / lB(), (getHeight() - i) / lC());
    AppMethodBeat.o(115706);
    return f;
  }
  
  private void ls()
  {
    AppMethodBeat.i(115663);
    ab.i(this.TAG, "alvinluo initScaleRate: %f", new Object[] { Float.valueOf(this.atc) });
    lt();
    lu();
    AppMethodBeat.o(115663);
  }
  
  private void lt()
  {
    AppMethodBeat.i(115664);
    this.arJ = (getDoubleTapZoomScale() * 2.0F * this.atf);
    AppMethodBeat.o(115664);
  }
  
  private void lu()
  {
    AppMethodBeat.i(115665);
    this.arK = Math.min(lD(), this.atc * 0.75F);
    AppMethodBeat.o(115665);
  }
  
  private boolean lv()
  {
    AppMethodBeat.i(115679);
    if ((this.bitmap != null) && (!this.arw))
    {
      AppMethodBeat.o(115679);
      return true;
    }
    if (this.arH != null)
    {
      Iterator localIterator = this.arH.entrySet().iterator();
      boolean bool2;
      for (boolean bool1 = true; localIterator.hasNext(); bool1 = bool2)
      {
        Object localObject = (Map.Entry)localIterator.next();
        bool2 = bool1;
        if (((Integer)((Map.Entry)localObject).getKey()).intValue() == this.arC)
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)((Iterator)localObject).next();
            if ((locale.are) || (locale.bitmap == null)) {
              bool1 = false;
            }
          }
        }
      }
      AppMethodBeat.o(115679);
      return bool1;
    }
    AppMethodBeat.o(115679);
    return false;
  }
  
  private boolean lw()
  {
    AppMethodBeat.i(115680);
    if ((getWidth() > 0) && (getHeight() > 0) && (this.arn > 0) && (this.aro > 0) && ((this.bitmap != null) || (lv()))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.asE) && (bool))
      {
        ly();
        this.asE = true;
      }
      AppMethodBeat.o(115680);
      return bool;
    }
  }
  
  private boolean lx()
  {
    AppMethodBeat.i(115681);
    boolean bool = lv();
    if ((!this.asF) && (bool))
    {
      ly();
      this.asF = true;
      ab.i(this.TAG, "alvinluo onImageLoaded");
      ls();
      a(this.atc, new PointF(0.0F, 0.0F));
      if (this.arE != -1L)
      {
        this.arF = System.currentTimeMillis();
        cQ((int)(this.arF - this.arE));
      }
      com.tencent.mm.sdk.g.d.post(new SubsamplingScaleImageView.7(this), "rotateAndScaleFullImageBitmap");
    }
    AppMethodBeat.o(115681);
    return bool;
  }
  
  private void ly()
  {
    AppMethodBeat.i(115684);
    if ((getWidth() == 0) || (getHeight() == 0) || (this.arn <= 0) || (this.aro <= 0))
    {
      AppMethodBeat.o(115684);
      return;
    }
    if ((this.ase != null) && (this.asd != null))
    {
      this.scale = this.asd.floatValue();
      if (this.asa == null) {
        this.asa = new PointF();
      }
      this.asa.x = (getWidth() / 2 - this.scale * this.ase.x);
      this.asa.y = (getHeight() / 2 - this.scale * this.ase.y);
      this.ase = null;
      this.asd = null;
      this.asg = false;
      ay(true);
      ax(true);
    }
    ay(false);
    AppMethodBeat.o(115684);
  }
  
  private int lz()
  {
    AppMethodBeat.i(115696);
    if ((this.bitmap == null) || (!this.arw))
    {
      AppMethodBeat.o(115696);
      return 0;
    }
    int i = this.ask;
    if ((i == 90) || (i == 270))
    {
      i = this.bitmap.getHeight();
      AppMethodBeat.o(115696);
      return i;
    }
    i = this.bitmap.getWidth();
    AppMethodBeat.o(115696);
    return i;
  }
  
  private int px(int paramInt)
  {
    return (int)(this.density * paramInt);
  }
  
  private void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(115675);
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
    {
      ab.i(this.TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(115675);
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(115669);
    f("reset newImage=".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.scale = 0.0F;
    this.arZ = 0.0F;
    this.asa = null;
    this.asb = null;
    this.asc = null;
    this.asd = Float.valueOf(0.0F);
    this.ase = null;
    this.asf = null;
    this.asm = false;
    this.asn = false;
    this.aso = false;
    this.asp = 0;
    this.arC = 0;
    this.asv = null;
    this.asw = 0.0F;
    this.asy = 0.0F;
    this.asz = false;
    this.asB = null;
    this.asA = null;
    this.asC = null;
    this.asD = null;
    this.asN = null;
    this.asO = null;
    this.asP = null;
    Object localObject1;
    if (paramBoolean)
    {
      if (this.atl != null)
      {
        localObject1 = this.atl;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).ark = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).ari = 0;
        ((com.davemorrissey.labs.subscaleview.d.a)localObject1).ark = 0;
      }
      this.uri = null;
      this.aqS.writeLock().lock();
    }
    try
    {
      if (this.ara != null)
      {
        this.ara.recycle();
        this.ara = null;
      }
      this.aqS.writeLock().unlock();
      if ((this.bitmap != null) && (!this.arB)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.arB) && (this.asG != null)) {
        this.asG.lG();
      }
      this.arn = 0;
      this.aro = 0;
      this.asj = 0;
      this.arp = null;
      this.asl = null;
      this.asE = false;
      this.asF = false;
      this.bitmap = null;
      this.arw = false;
      this.arB = false;
      this.arx = false;
      this.ary = false;
      this.arD = true;
      if (this.arH != null)
      {
        localObject1 = this.arH.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Iterator localIterator = ((List)((Map.Entry)((Iterator)localObject1).next()).getValue()).iterator();
          while (localIterator.hasNext())
          {
            com.davemorrissey.labs.subscaleview.c.e locale = (com.davemorrissey.labs.subscaleview.c.e)localIterator.next();
            locale.arf = false;
            if (locale.bitmap != null)
            {
              locale.bitmap.recycle();
              locale.bitmap = null;
            }
          }
        }
      }
      AppMethodBeat.o(115669);
    }
    finally
    {
      this.aqS.writeLock().unlock();
      AppMethodBeat.o(115669);
    }
  }
  
  public static void setBitmapLoaderImp(com.davemorrissey.labs.subscaleview.c.a parama)
  {
    asU = parama;
  }
  
  private void setFullImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(115690);
    com.tencent.mm.sdk.g.d.post(new SubsamplingScaleImageView.5(this, paramBitmap), "rotateAndScaleBitmap");
    AppMethodBeat.o(115690);
  }
  
  private void setGestureDetector(Context paramContext)
  {
    AppMethodBeat.i(115670);
    this.asq = new GestureDetector(paramContext, new SubsamplingScaleImageView.3(this, paramContext));
    this.ass = new GestureDetector(paramContext, new SubsamplingScaleImageView.4(this));
    AppMethodBeat.o(115670);
  }
  
  public static void setPreferredBitmapConfig(Bitmap.Config paramConfig)
  {
    asT = paramConfig;
  }
  
  public static void setTileInitLoaderImp(com.davemorrissey.labs.subscaleview.c.c paramc)
  {
    asW = paramc;
  }
  
  public static void setTileLoaderImp(com.davemorrissey.labs.subscaleview.c.d paramd)
  {
    asV = paramd;
  }
  
  public final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(115692);
    if (paramBitmap == null)
    {
      ab.e(this.TAG, "alvinluo rotateAndScaleBitmap bitmap is null");
      AppMethodBeat.o(115692);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(1.0F, 1.0F);
    if (paramInt != 0) {
      localMatrix.postRotate(paramInt);
    }
    ab.d(this.TAG, "alvinluo rotateAndScaleBitmap matrix.isIdentify: %b", new Object[] { Boolean.valueOf(localMatrix.isIdentity()) });
    if ((paramBitmap.getWidth() > 0) && (paramBitmap.getHeight() > 0))
    {
      if (localMatrix.isIdentity())
      {
        AppMethodBeat.o(115692);
        return paramBitmap;
      }
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
        AppMethodBeat.o(115692);
        return paramBitmap;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        ab.printErrStackTrace(this.TAG, paramBitmap, "alvinluo createBitmap oom", new Object[0]);
        asT = Bitmap.Config.RGB_565;
        AppMethodBeat.o(115692);
        return null;
      }
    }
    AppMethodBeat.o(115692);
    return null;
  }
  
  public final void a(float paramFloat, PointF paramPointF)
  {
    AppMethodBeat.i(115721);
    this.asD = null;
    this.asg = true;
    this.asd = Float.valueOf(paramFloat);
    this.ase = paramPointF;
    this.asf = paramPointF;
    invalidate();
    AppMethodBeat.o(115721);
  }
  
  public final void a(Bitmap paramBitmap, Integer paramInteger)
  {
    boolean bool2 = true;
    label435:
    label568:
    for (;;)
    {
      int k;
      int m;
      int i;
      boolean bool1;
      int j;
      try
      {
        AppMethodBeat.i(115693);
        ab.i(this.TAG, "alvinluo onPreviewLoaded");
        long l = System.currentTimeMillis();
        if (this.asF)
        {
          if (this.bitmap != null) {
            this.bitmap.recycle();
          }
          AppMethodBeat.o(115693);
          return;
        }
        if (this.asl != null)
        {
          if ((this.asl.width() > 0) && (this.asl.height() > 0))
          {
            this.bitmap = Bitmap.createBitmap(paramBitmap, this.asl.left, this.asl.top, this.asl.width(), this.asl.height());
            this.ask = 0;
          }
          this.arw = true;
          this.ary = false;
          this.arz = this.bitmap.getWidth();
          this.arA = this.bitmap.getHeight();
          if ((this.bitmap != null) && (this.arw))
          {
            k = lB();
            m = lC();
            if (k <= m * 2.2F) {
              break label551;
            }
            i = 1;
            break label531;
            if ((i == 0) || (k <= this.asY)) {
              break label562;
            }
            bool1 = true;
            if ((j == 0) || (m <= this.asZ)) {
              break label568;
            }
            ls();
            if (!bool2) {
              break label443;
            }
            this.atd = (this.asY * 1.0F / lz());
            this.ate = (this.asZ * 1.0F / lA());
            ab.i(this.TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f, previewHeight: %d, previewWidth: %d, verticalLong: %b, horizontalLong: %b", new Object[] { Float.valueOf(this.atd), Float.valueOf(this.ate), Integer.valueOf(lA()), Integer.valueOf(lz()), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          }
          this.ary = true;
          if (lw())
          {
            invalidate();
            requestLayout();
          }
          cP((int)(System.currentTimeMillis() - l));
          ab.i(this.TAG, "alvinluo onPreviewLoaded");
          if ((!this.arx) && (this.asG != null)) {
            this.asG.lF();
          }
          AppMethodBeat.o(115693);
          continue;
        }
        if (paramInteger == null) {
          break label435;
        }
      }
      finally {}
      this.ask = paramInteger.intValue();
      this.bitmap = paramBitmap;
      continue;
      label443:
      if (bool1)
      {
        this.atd = (this.asY * 1.0F / lz());
        this.ate = (this.atc * lC() / lA());
      }
      else
      {
        this.atd = (this.atc * lB() / lz());
        this.ate = (this.atc * lC() / lA());
        continue;
        for (;;)
        {
          if (m <= k * 2.2F) {
            break label556;
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
      AppMethodBeat.i(115689);
      f("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.arn), Integer.valueOf(this.aro), Integer.valueOf(paramInt3) });
      if ((this.arn > 0) && (this.aro > 0) && ((this.arn != paramInt1) || (this.aro != paramInt2)))
      {
        reset(false);
        if (this.bitmap != null)
        {
          if (!this.arB) {
            this.bitmap.recycle();
          }
          this.bitmap = null;
          if ((this.asG != null) && (this.arB)) {
            this.asG.lG();
          }
          this.arw = false;
          this.arB = false;
        }
      }
      this.ara = paramd;
      this.arn = paramInt1;
      this.aro = paramInt2;
      this.asj = paramInt3;
      lw();
      if ((!lx()) && (this.arP > 0) && (this.arP != arO) && (this.arQ > 0) && (this.arQ != arO) && (getWidth() > 0) && (getHeight() > 0)) {
        b(new Point(this.arP, this.arQ));
      }
      invalidate();
      requestLayout();
      System.currentTimeMillis();
      AppMethodBeat.o(115689);
      return;
    }
    finally {}
  }
  
  public final void a(a parama1, a parama2)
  {
    AppMethodBeat.i(115668);
    if (parama1 == null)
    {
      parama1 = new NullPointerException("imageSource must not be null");
      AppMethodBeat.o(115668);
      throw parama1;
    }
    reset(true);
    this.ash = parama1;
    this.asi = parama2;
    if (parama1.uri != null) {
      this.asj = h(getContext(), parama1.uri.toString());
    }
    if (parama2 != null)
    {
      if ((parama1.arn > 0) && (parama1.aro > 0)) {
        break label160;
      }
      ab.e(this.TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
    }
    while ((parama1.bitmap != null) && (parama1.arp != null))
    {
      b(Bitmap.createBitmap(parama1.bitmap, parama1.arp.left, parama1.arp.top, parama1.arp.width(), parama1.arp.height()), 0, false);
      AppMethodBeat.o(115668);
      return;
      label160:
      this.arn = parama1.arn;
      this.aro = parama1.aro;
      this.asl = parama2.arp;
      if (parama2.bitmap != null)
      {
        this.arB = parama2.arq;
        a(parama2.bitmap, Integer.valueOf(0));
      }
      else
      {
        Uri localUri2 = parama2.uri;
        Uri localUri1 = localUri2;
        if (localUri2 == null)
        {
          localUri1 = localUri2;
          if (parama2.arl != null) {
            localUri1 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama2.arl);
          }
        }
        asU.a(this, getContext(), this.ast, localUri1, true).lo();
      }
    }
    if (parama1.bitmap != null)
    {
      b(parama1.bitmap, 0, parama1.arq);
      AppMethodBeat.o(115668);
      return;
    }
    this.arp = parama1.arp;
    this.uri = parama1.uri;
    if ((this.uri == null) && (parama1.arl != null)) {
      this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + parama1.arl);
    }
    if ((parama1.arm) || (this.arp != null))
    {
      asW.a(this, getContext(), this.asu, this.uri).lo();
      AppMethodBeat.o(115668);
      return;
    }
    asU.a(this, getContext(), this.ast, this.uri, false).lo();
    AppMethodBeat.o(115668);
  }
  
  public final PointF b(PointF paramPointF)
  {
    AppMethodBeat.i(115701);
    paramPointF = a(paramPointF.x, paramPointF.y, new PointF());
    AppMethodBeat.o(115701);
    return paramPointF;
  }
  
  public final void b(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(115694);
      f("onImageLoaded has bitmap", new Object[0]);
      if ((this.arn > 0) && (this.aro > 0) && ((this.arn != paramBitmap.getWidth()) || (this.aro != paramBitmap.getHeight()))) {
        reset(false);
      }
      if ((this.bitmap != null) && (!this.arB)) {
        this.bitmap.recycle();
      }
      if ((this.bitmap != null) && (this.arB) && (this.asG != null)) {
        this.asG.lG();
      }
      this.arw = false;
      this.arB = paramBoolean;
      this.bitmap = paramBitmap;
      this.arn = paramBitmap.getWidth();
      this.aro = paramBitmap.getHeight();
      this.asj = paramInt;
      com.tencent.mm.sdk.g.d.post(new SubsamplingScaleImageView.6(this, paramInt, paramBitmap, lw(), lx()), "rotateAndScaleBitmap");
      AppMethodBeat.o(115694);
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
    //   4: ldc_w 1331
    //   7: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokestatic 1002	java/lang/System:currentTimeMillis	()J
    //   14: putfield 278	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:arE	J
    //   17: aload_0
    //   18: getfield 272	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   21: astore 4
    //   23: aload_1
    //   24: getfield 784	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   27: istore_2
    //   28: aload_1
    //   29: getfield 789	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   32: ifnonnull +166 -> 198
    //   35: aload 4
    //   37: ldc_w 1333
    //   40: iconst_2
    //   41: anewarray 260	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: iload_2
    //   47: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: iload_3
    //   54: invokestatic 1056	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 1187	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_1
    //   62: getfield 784	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   65: aload_0
    //   66: getfield 745	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:arC	I
    //   69: if_icmpne +40 -> 109
    //   72: aload_1
    //   73: getfield 789	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   76: ifnull +33 -> 109
    //   79: aload_0
    //   80: getfield 274	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:arD	Z
    //   83: ifeq +26 -> 109
    //   86: aload_0
    //   87: getfield 272	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   90: ldc_w 1335
    //   93: invokestatic 692	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 274	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:arD	Z
    //   101: aload_0
    //   102: aload_1
    //   103: getfield 789	com/davemorrissey/labs/subscaleview/c/e:bitmap	Landroid/graphics/Bitmap;
    //   106: putfield 598	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:arG	Landroid/graphics/Bitmap;
    //   109: aload_0
    //   110: invokespecial 1235	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:lw	()Z
    //   113: pop
    //   114: aload_0
    //   115: invokespecial 1252	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:lx	()Z
    //   118: pop
    //   119: aload_0
    //   120: invokespecial 985	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:lv	()Z
    //   123: ifeq +62 -> 185
    //   126: aload_0
    //   127: getfield 835	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   130: ifnull +55 -> 185
    //   133: aload_0
    //   134: getfield 1106	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:arB	Z
    //   137: ifne +10 -> 147
    //   140: aload_0
    //   141: getfield 835	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   144: invokevirtual 792	android/graphics/Bitmap:recycle	()V
    //   147: aload_0
    //   148: aconst_null
    //   149: putfield 835	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:bitmap	Landroid/graphics/Bitmap;
    //   152: aload_0
    //   153: getfield 1108	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:asG	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   156: ifnull +19 -> 175
    //   159: aload_0
    //   160: getfield 1106	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:arB	Z
    //   163: ifeq +12 -> 175
    //   166: aload_0
    //   167: getfield 1108	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:asG	Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView$e;
    //   170: invokeinterface 1111 1 0
    //   175: aload_0
    //   176: iconst_0
    //   177: putfield 946	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:arw	Z
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 1106	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:arB	Z
    //   185: aload_0
    //   186: invokevirtual 667	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:invalidate	()V
    //   189: ldc_w 1331
    //   192: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final PointF c(PointF paramPointF)
  {
    AppMethodBeat.i(115703);
    paramPointF = b(paramPointF.x, paramPointF.y, new PointF());
    AppMethodBeat.o(115703);
    return paramPointF;
  }
  
  public final void cO(int paramInt)
  {
    try
    {
      AppMethodBeat.i(115653);
      if (this.atl != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.atl;
        locala.arj += paramInt;
        ab.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.arj) });
      }
      AppMethodBeat.o(115653);
      return;
    }
    finally {}
  }
  
  public final void cP(int paramInt)
  {
    try
    {
      AppMethodBeat.i(115654);
      if (this.atl != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.atl;
        locala.ari += paramInt;
        ab.d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.ari) });
      }
      AppMethodBeat.o(115654);
      return;
    }
    finally {}
  }
  
  public final void cQ(int paramInt)
  {
    try
    {
      AppMethodBeat.i(115655);
      if (this.atl != null)
      {
        com.davemorrissey.labs.subscaleview.d.a locala = this.atl;
        locala.ark += paramInt;
        ab.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.ark) });
      }
      AppMethodBeat.o(115655);
      return;
    }
    finally {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(115673);
    ab.d(this.TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(115673);
    return bool;
  }
  
  public final void f(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(115709);
    ab.d(this.TAG, String.format(paramString, paramVarArgs));
    AppMethodBeat.o(115709);
  }
  
  public final int getAppliedOrientation()
  {
    AppMethodBeat.i(115722);
    int i = getRequiredRotation();
    AppMethodBeat.o(115722);
    return i;
  }
  
  public final PointF getCenter()
  {
    AppMethodBeat.i(115720);
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    PointF localPointF = a(i, j, new PointF());
    AppMethodBeat.o(115720);
    return localPointF;
  }
  
  public ReadWriteLock getDecoderLock()
  {
    return this.aqS;
  }
  
  public Bitmap getFullImageBitmap()
  {
    return this.arG;
  }
  
  public int getFullImageSampleSize()
  {
    return this.arC;
  }
  
  public com.davemorrissey.labs.subscaleview.d.a getImageDecodeRecord()
  {
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala = this.atl;
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
    return this.arJ;
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(115718);
    float f = lD();
    AppMethodBeat.o(115718);
    return f;
  }
  
  public SubsamplingScaleImageView.e getOnImageEventListener()
  {
    return this.asG;
  }
  
  public final int getOrientation()
  {
    return this.orientation;
  }
  
  public int getPreviewHeight()
  {
    return this.arA;
  }
  
  public int getPreviewOrientation()
  {
    return this.ask;
  }
  
  public int getPreviewWidth()
  {
    return this.arz;
  }
  
  public int getRequiredRotation()
  {
    if (this.orientation == -1) {
      return this.asj;
    }
    return this.orientation;
  }
  
  public final int getSHeight()
  {
    return this.aro;
  }
  
  public final int getSWidth()
  {
    return this.arn;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  public final b getState()
  {
    AppMethodBeat.i(115723);
    if ((this.asa != null) && (this.arn > 0) && (this.aro > 0))
    {
      b localb = new b(getScale(), getCenter(), getOrientation());
      AppMethodBeat.o(115723);
      return localb;
    }
    AppMethodBeat.o(115723);
    return null;
  }
  
  public Rect getsRegion()
  {
    return this.arp;
  }
  
  /* Error */
  public final int h(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc_w 1406
    //   9: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_2
    //   13: ldc_w 1408
    //   16: invokevirtual 1412	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   19: ifeq +176 -> 195
    //   22: aload_1
    //   23: invokevirtual 1416	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   26: aload_2
    //   27: invokestatic 1305	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   30: iconst_1
    //   31: anewarray 452	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc_w 1417
    //   39: aastore
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 1423	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +82 -> 130
    //   51: aload_1
    //   52: invokeinterface 1428 1 0
    //   57: ifeq +73 -> 130
    //   60: aload_1
    //   61: iconst_0
    //   62: invokeinterface 1431 2 0
    //   67: istore_3
    //   68: getstatic 202	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:arr	Ljava/util/List;
    //   71: iload_3
    //   72: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokeinterface 1434 2 0
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
    //   100: invokeinterface 1437 1 0
    //   105: ldc_w 1406
    //   108: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: iload_3
    //   112: ireturn
    //   113: aload_0
    //   114: getfield 272	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   117: ldc_w 1439
    //   120: iload_3
    //   121: invokestatic 585	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   124: invokevirtual 471	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   127: invokestatic 1441	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: iconst_0
    //   131: istore_3
    //   132: goto -40 -> 92
    //   135: astore_1
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_0
    //   139: getfield 272	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   142: ldc_w 1443
    //   145: invokestatic 1441	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_1
    //   149: ifnull +37 -> 186
    //   152: aload_1
    //   153: invokeinterface 1437 1 0
    //   158: iload 4
    //   160: istore_3
    //   161: goto -56 -> 105
    //   164: astore_1
    //   165: aload 7
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +9 -> 178
    //   172: aload_2
    //   173: invokeinterface 1437 1 0
    //   178: ldc_w 1406
    //   181: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   199: ldc_w 1445
    //   202: invokevirtual 1412	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   205: ifeq -100 -> 105
    //   208: iload 4
    //   210: istore_3
    //   211: aload_2
    //   212: ldc_w 464
    //   215: invokevirtual 1412	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   218: ifne -113 -> 105
    //   221: new 1447	android/support/d/a
    //   224: dup
    //   225: aload_2
    //   226: bipush 7
    //   228: invokevirtual 1450	java/lang/String:substring	(I)Ljava/lang/String;
    //   231: invokespecial 1451	android/support/d/a:<init>	(Ljava/lang/String;)V
    //   234: ldc_w 1453
    //   237: iconst_1
    //   238: invokevirtual 1457	android/support/d/a:getAttributeInt	(Ljava/lang/String;I)I
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
    //   274: getfield 272	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   277: ldc_w 1459
    //   280: iload 5
    //   282: invokestatic 585	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   285: invokevirtual 471	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokestatic 1441	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: iload 4
    //   293: istore_3
    //   294: goto -189 -> 105
    //   297: astore_1
    //   298: aload_0
    //   299: getfield 272	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:TAG	Ljava/lang/String;
    //   302: ldc_w 1461
    //   305: invokestatic 1441	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    AppMethodBeat.i(115656);
    super.onAttachedToWindow();
    if (this.atk != null) {
      this.atk.onViewAttachedToWindow(this);
    }
    this.cancelled = false;
    AppMethodBeat.o(115656);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(115657);
    super.onDetachedFromWindow();
    if (!this.cancelled)
    {
      this.cancelled = true;
      ab.i(this.TAG, "alvinluo cancelAllTileLoadTask, task size: %d", new Object[] { Integer.valueOf(this.asX.size()) });
      Iterator localIterator = this.asX.iterator();
      while (localIterator.hasNext()) {
        ((com.davemorrissey.labs.subscaleview.c.b)localIterator.next()).cancel();
      }
      this.asX.clear();
    }
    if (this.atk != null) {
      this.atk.onViewDetachedFromWindow(this);
    }
    AppMethodBeat.o(115657);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(115678);
    super.onDraw(paramCanvas);
    System.currentTimeMillis();
    if (this.asJ == null)
    {
      this.asJ = new Paint();
      this.asJ.setAntiAlias(true);
      this.asJ.setFilterBitmap(true);
      this.asJ.setDither(true);
    }
    if (((this.asK == null) || (this.asL == null)) && (this.arI))
    {
      this.asK = new Paint();
      this.asK.setTextSize(px(20));
      this.asK.setColor(-65281);
      this.asK.setStyle(Paint.Style.FILL);
      this.asL = new Paint();
      this.asL.setColor(-65281);
      this.asL.setStyle(Paint.Style.STROKE);
      this.asL.setStrokeWidth(px(1));
    }
    if ((this.arn == 0) || (this.aro == 0) || (getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(115678);
      return;
    }
    int j;
    int k;
    if ((this.arH == null) && (this.ara != null))
    {
      j = Math.min(paramCanvas.getMaximumBitmapWidth(), this.arP);
      k = Math.min(paramCanvas.getMaximumBitmapHeight(), this.arQ);
      i = j;
      if (j > 10000) {
        i = 10000;
      }
      j = k;
      if (k > 10000) {
        j = 10000;
      }
      ab.i(this.TAG, "alvinluo getMaxBitmapDimensions %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      b(new Point(i, j));
    }
    if (!lw())
    {
      AppMethodBeat.o(115678);
      return;
    }
    ly();
    boolean bool1;
    float f1;
    boolean bool2;
    if ((this.asD != null) && (this.asD.atC != null))
    {
      if (this.asc == null) {
        this.asc = new PointF(0.0F, 0.0F);
      }
      this.asc.set(this.asa);
      long l = System.currentTimeMillis() - this.asD.time;
      if (l > this.asD.duration)
      {
        bool1 = true;
        l = Math.min(l, this.asD.duration);
        this.scale = a(this.asD.atF, l, this.asD.arZ, this.asD.aty - this.asD.arZ, this.asD.duration);
        f1 = a(this.asD.atF, l, this.asD.atC.x, this.asD.atD.x - this.asD.atC.x, this.asD.duration);
        f2 = a(this.asD.atF, l, this.asD.atC.y, this.asD.atD.y - this.asD.atC.y, this.asD.duration);
        localObject1 = this.asa;
        ((PointF)localObject1).x -= P(this.asD.atA.x) - f1;
        localObject1 = this.asa;
        ((PointF)localObject1).y -= Q(this.asD.atA.y) - f2;
        if ((!bool1) && (this.asD.arZ != this.asD.aty)) {
          break label883;
        }
        bool2 = true;
        label669:
        ay(bool2);
        d(this.asc);
        ax(bool1);
        if (bool1) {
          this.asD = null;
        }
        invalidate();
      }
    }
    else
    {
      if ((this.arH == null) || (!lv()) || (!this.ath)) {
        break label1797;
      }
      k = Math.min(this.arC, M(this.scale));
      localObject1 = this.arH.entrySet().iterator();
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
          if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).arf) && ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).are) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null))) {
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
    Object localObject1 = this.arH.entrySet().iterator();
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
              Rect localRect = ((com.davemorrissey.labs.subscaleview.c.e)localObject3).ard;
              ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.set((int)P(localRect.left), (int)Q(localRect.top), (int)P(localRect.right), (int)Q(localRect.bottom));
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).are) || (((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap == null)) {
                break label1737;
              }
              if (this.asM != null) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg, this.asM);
              }
              if (this.asO == null) {
                this.asO = new Matrix();
              }
              this.asO.reset();
              a(this.asQ, 0.0F, 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getWidth(), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight(), 0.0F, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.getHeight());
              if (getRequiredRotation() != 0) {
                break label1462;
              }
              a(this.asR, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.bottom);
              label1249:
              this.asO.setPolyToPoly(this.asQ, 0, this.asR, 0, 4);
              if (!((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap.isRecycled()) {
                paramCanvas.drawBitmap(((com.davemorrissey.labs.subscaleview.c.e)localObject3).bitmap, this.asO, this.asJ);
              }
              if (this.arI) {
                paramCanvas.drawRect(((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg, this.asL);
              }
            }
            for (;;)
            {
              if ((!((com.davemorrissey.labs.subscaleview.c.e)localObject3).arf) || (!this.arI)) {
                break label1795;
              }
              paramCanvas.drawText("ISS " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).sampleSize + " RECT " + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).ard.top + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).ard.left + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).ard.bottom + "," + ((com.davemorrissey.labs.subscaleview.c.e)localObject3).ard.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.top + px(15), this.asK);
              break label974;
              break;
              label1462:
              if (getRequiredRotation() == 90)
              {
                a(this.asR, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.top);
                break label1249;
              }
              if (getRequiredRotation() == 180)
              {
                a(this.asR, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.top);
                break label1249;
              }
              if (getRequiredRotation() != 270) {
                break label1249;
              }
              a(this.asR, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.bottom, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.left, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.top, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.right, ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.bottom);
              break label1249;
              label1737:
              if ((((com.davemorrissey.labs.subscaleview.c.e)localObject3).are) && (this.arI)) {
                paramCanvas.drawText("LOADING", ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.left + px(5), ((com.davemorrissey.labs.subscaleview.c.e)localObject3).arg.top + px(35), this.asK);
              }
            }
          }
          label1797:
          if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
          {
            ab.d(this.TAG, "alvinluo onDraw bitmap scale: %f", new Object[] { Float.valueOf(this.scale) });
            if ((!this.arw) || (this.ary))
            {
              if (this.asO == null) {
                this.asO = new Matrix();
              }
              this.asO.reset();
              i = this.bitmap.getWidth();
              j = this.bitmap.getHeight();
              if ((this.ask == 90) || (this.ask == 270))
              {
                i = this.bitmap.getHeight();
                j = this.bitmap.getWidth();
              }
              if (this.arw)
              {
                f1 = i / 2.0F;
                f2 = j / 2.0F;
                this.asO.postScale(this.atd, this.ate, f1, f2);
              }
              f1 = (this.asY - this.bitmap.getWidth()) / 2;
              f2 = (this.asZ - this.bitmap.getHeight()) / 2;
              this.asO.postTranslate(f1, f2);
              ab.d(this.TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
              if (this.asM != null)
              {
                if (this.asP == null) {
                  this.asP = new RectF();
                }
                localObject1 = this.asP;
                if (!this.arw) {
                  break label2876;
                }
                f1 = this.bitmap.getWidth();
                if (!this.arw) {
                  break label2885;
                }
              }
            }
          }
        }
      }
    }
    label2876:
    label2885:
    for (float f2 = this.bitmap.getHeight();; f2 = this.aro)
    {
      ((RectF)localObject1).set(0.0F, 0.0F, f1, f2);
      this.asO.mapRect(this.asP);
      paramCanvas.drawRect(this.asP, this.asM);
      paramCanvas.drawBitmap(this.bitmap, this.asO, this.asJ);
      if (this.arI)
      {
        ab.d(this.TAG, "alvinluo onDraw debug vTranslate %f, %f", new Object[] { Float.valueOf(this.asa.x), Float.valueOf(this.asa.y) });
        paramCanvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.scale) }) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(lD()) }) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.arJ) }) + ")", px(5), px(15), this.asK);
        paramCanvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.asa.x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(this.asa.y) }), px(5), px(30), this.asK);
        localObject1 = getCenter();
        paramCanvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).x) }) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[] { Float.valueOf(((PointF)localObject1).y) }), px(5), px(45), this.asK);
        if (this.asD != null)
        {
          localObject1 = c(this.asD.atz);
          localObject2 = c(this.asD.atB);
          localObject3 = c(this.asD.atA);
          paramCanvas.drawCircle(((PointF)localObject1).x, ((PointF)localObject1).y, px(10), this.asL);
          this.asL.setColor(-65536);
          paramCanvas.drawCircle(((PointF)localObject2).x, ((PointF)localObject2).y, px(20), this.asL);
          this.asL.setColor(-16776961);
          paramCanvas.drawCircle(((PointF)localObject3).x, ((PointF)localObject3).y, px(25), this.asL);
          this.asL.setColor(-16711681);
          paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.asL);
        }
        if (this.asv != null)
        {
          this.asL.setColor(-65536);
          paramCanvas.drawCircle(this.asv.x, this.asv.y, px(20), this.asL);
        }
        if (this.asB != null)
        {
          this.asL.setColor(-16776961);
          paramCanvas.drawCircle(P(this.asB.x), Q(this.asB.y), px(35), this.asL);
        }
        if ((this.asC != null) && (this.aso))
        {
          this.asL.setColor(-16711681);
          paramCanvas.drawCircle(this.asC.x, this.asC.y, px(30), this.asL);
        }
        this.asL.setColor(-65281);
      }
      AppMethodBeat.o(115678);
      return;
      f1 = this.arn;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115672);
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
      if ((this.arn <= 0) || (this.aro <= 0)) {
        break label214;
      }
      if ((paramInt2 == 0) || (i == 0)) {
        break label164;
      }
      paramInt2 = lB();
      paramInt1 = lC();
    }
    for (;;)
    {
      paramInt2 = Math.max(paramInt2, getSuggestedMinimumWidth());
      paramInt1 = Math.max(paramInt1, getSuggestedMinimumHeight());
      setMeasuredDimension(paramInt2, paramInt1);
      this.asY = paramInt2;
      this.asZ = paramInt1;
      ab.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", new Object[] { Integer.valueOf(this.asY), Integer.valueOf(this.asY) });
      AppMethodBeat.o(115672);
      return;
      paramInt2 = 0;
      break;
      label159:
      i = 0;
      break label47;
      label164:
      if (i != 0)
      {
        paramInt1 = (int)(lC() / lB() * j);
        paramInt2 = j;
      }
      else if (paramInt2 != 0)
      {
        paramInt2 = (int)(lB() / lC() * paramInt1);
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
    AppMethodBeat.i(115671);
    f("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(this.scale), this.asd, Boolean.valueOf(this.asg) });
    ls();
    PointF localPointF = getCenter();
    if (((this.asE) || (this.asg)) && (localPointF != null))
    {
      this.asD = null;
      if (!this.asg)
      {
        this.asd = Float.valueOf(this.scale);
        this.ase = localPointF;
      }
    }
    AppMethodBeat.o(115671);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(115674);
    ab.d(this.TAG, "alvinluo SubSamplingScaleImageView onTouchEvent: %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    if ((this.asD != null) && (!this.asD.atE))
    {
      requestDisallowInterceptTouchEvent(true);
      AppMethodBeat.o(115674);
      return true;
    }
    this.asD = null;
    if (this.asa == null)
    {
      if (this.ass != null) {
        this.ass.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(115674);
      return true;
    }
    if ((!this.aso) && ((this.asq == null) || (this.asq.onTouchEvent(paramMotionEvent))))
    {
      this.asm = false;
      this.asn = false;
      this.asp = 0;
      AppMethodBeat.o(115674);
      return true;
    }
    if (this.asb == null) {
      this.asb = new PointF(0.0F, 0.0F);
    }
    if (this.asc == null) {
      this.asc = new PointF(0.0F, 0.0F);
    }
    if (this.asv == null) {
      this.asv = new PointF(0.0F, 0.0F);
    }
    this.asc.set(this.asa);
    int i = paramMotionEvent.getPointerCount();
    boolean bool1;
    label295:
    boolean bool2;
    float f1;
    label503:
    float f3;
    float f4;
    float f5;
    double d;
    float f2;
    label931:
    label976:
    float f6;
    float f7;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
      d(this.asc);
      bool2 = super.onTouchEvent(paramMotionEvent);
      ab.i(this.TAG, "alvinluo onTouchEvent super: %b, handled: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool1) || (bool2))
      {
        AppMethodBeat.o(115674);
        return true;
      }
      break;
    case 0: 
    case 5: 
    case 261: 
      this.atq = paramMotionEvent.getRawX();
      this.atr = paramMotionEvent.getRawY();
      this.asD = null;
      requestDisallowInterceptTouchEvent(true);
      this.asp = Math.max(this.asp, i);
      if (i >= 2) {
        if (this.arT)
        {
          f1 = b(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
          this.arZ = this.scale;
          this.asw = f1;
          this.asb.set(this.asa.x, this.asa.y);
          this.asv.set((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F, (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
          this.handler.removeMessages(1);
        }
      }
      for (;;)
      {
        bool1 = true;
        break;
        this.asp = 0;
        break label503;
        if (!this.aso)
        {
          this.asb.set(this.asa.x, this.asa.y);
          this.asv.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          this.handler.sendEmptyMessageDelayed(1, 600L);
        }
      }
    case 2: 
      bool2 = false;
      bool1 = bool2;
      if (this.asp > 0)
      {
        if (i < 2) {
          break label1312;
        }
        f3 = b(paramMotionEvent.getX(0), paramMotionEvent.getX(1), paramMotionEvent.getY(0), paramMotionEvent.getY(1));
        f4 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
        f5 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
        this.atj = new PointF(f4, f5);
        bool1 = bool2;
        if (this.arT) {
          if ((b(this.asv.x, f4, this.asv.y, f5) <= 5.0F) && (Math.abs(f3 - this.asw) <= 5.0F))
          {
            bool1 = bool2;
            if (!this.asn) {}
          }
          else
          {
            this.asm = true;
            this.asn = true;
            d = this.scale;
            f2 = f3 / this.asw * this.arZ;
            f1 = f2;
            if (f2 >= this.arJ * 2.0F)
            {
              f1 = this.arJ;
              f1 = (f2 - this.arJ) * 0.1F + f1 * 2.0F;
            }
            this.scale = f1;
            ab.i(this.TAG, "alvinluo zoom preScale: %f, scale: %f, minScale: %f, maxScale: %f", new Object[] { Double.valueOf(d), Float.valueOf(this.scale), Float.valueOf(lD()), Float.valueOf(this.arJ) });
            if (this.scale > lD()) {
              break label976;
            }
            this.asw = f3;
            this.arZ = lD();
            this.asv.set(f4, f5);
            this.asb.set(this.asa);
          }
        }
      }
      for (;;)
      {
        ay(true);
        ax(this.arR);
        bool1 = true;
        ab.d(this.TAG, "alvinluo Action_Move consumed: %b", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break;
        }
        this.handler.removeMessages(1);
        invalidate();
        bool1 = true;
        break label295;
        if (this.arS)
        {
          f1 = this.asv.x;
          f2 = this.asb.x;
          f6 = this.asv.y;
          f7 = this.asb.y;
          float f8 = this.scale / this.arZ;
          float f9 = this.scale / this.arZ;
          this.asa.x = (f4 - (f1 - f2) * f8);
          this.asa.y = (f5 - (f6 - f7) * f9);
          if (((lC() * d < getHeight()) && (this.scale * lC() >= getHeight())) || ((d * lB() < getWidth()) && (this.scale * lB() >= getWidth())))
          {
            ay(true);
            this.asv.set(f4, f5);
            this.asb.set(this.asa);
            this.arZ = this.scale;
            this.asw = f3;
          }
        }
        else if (this.asf != null)
        {
          this.asa.x = (getWidth() / 2 - this.scale * this.asf.x);
          this.asa.y = (getHeight() / 2 - this.scale * this.asf.y);
        }
        else
        {
          this.asa.x = (getWidth() / 2 - this.scale * (lB() / 2));
          this.asa.y = (getHeight() / 2 - this.scale * (lC() / 2));
        }
      }
      label1312:
      if (this.aso)
      {
        f2 = Math.abs(this.asC.y - paramMotionEvent.getY()) * 2.0F + this.asx;
        if (this.asy == -1.0F) {
          this.asy = f2;
        }
        if (paramMotionEvent.getY() > this.asA.y)
        {
          i = 1;
          label1378:
          this.asA.set(0.0F, paramMotionEvent.getY());
          f3 = 0.5F * Math.abs(1.0F - f2 / this.asy);
          if (f3 <= 0.03F)
          {
            f1 = f2;
            if (!this.asz) {
              break;
            }
          }
          else
          {
            this.asz = true;
            if (this.asy <= 0.0F) {
              break label2786;
            }
            if (i == 0) {
              break label1738;
            }
            f1 = 1.0F + f3;
          }
        }
      }
      break;
    }
    for (;;)
    {
      label1453:
      d = this.scale;
      this.scale = Math.max(lD(), Math.min(this.arJ, f1 * this.scale));
      if (this.arS)
      {
        f1 = this.asv.x;
        f3 = this.asb.x;
        f4 = this.asv.y;
        f5 = this.asb.y;
        f6 = this.scale / this.arZ;
        f7 = this.scale / this.arZ;
        this.asa.x = (this.asv.x - (f1 - f3) * f6);
        this.asa.y = (this.asv.y - (f4 - f5) * f7);
        if (((lC() * d >= getHeight()) || (this.scale * lC() < getHeight())) && ((lB() * d >= getWidth()) || (this.scale * lB() < getWidth()))) {
          break label2779;
        }
        ay(true);
        this.asv.set(c(this.asB));
        this.asb.set(this.asa);
        this.arZ = this.scale;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.asy = f1;
        ay(true);
        ax(this.arR);
        bool1 = true;
        break label931;
        i = 0;
        break label1378;
        label1738:
        f1 = 1.0F - f3;
        break label1453;
        if (this.asf != null)
        {
          this.asa.x = (getWidth() / 2 - this.scale * this.asf.x);
          this.asa.y = (getHeight() / 2 - this.scale * this.asf.y);
          f1 = f2;
        }
        else
        {
          this.asa.x = (getWidth() / 2 - this.scale * (lB() / 2));
          this.asa.y = (getHeight() / 2 - this.scale * (lC() / 2));
          f1 = f2;
          continue;
          bool1 = bool2;
          if (this.asm) {
            break label931;
          }
          f1 = Math.abs(paramMotionEvent.getX() - this.asv.x);
          f2 = Math.abs(paramMotionEvent.getY() - this.asv.y);
          f3 = this.density * 5.0F;
          if ((f1 <= f3) && (f2 <= f3))
          {
            bool1 = bool2;
            if (!this.asn) {
              break label931;
            }
          }
          this.asa.x = (this.asb.x + (paramMotionEvent.getX() - this.asv.x));
          this.asa.y = (this.asb.y + (paramMotionEvent.getY() - this.asv.y));
          f4 = this.asa.x;
          f5 = this.asa.y;
          ay(true);
          label2051:
          label2067:
          boolean bool3;
          label2090:
          boolean bool4;
          label2113:
          boolean bool5;
          if (f4 != this.asa.x)
          {
            bool1 = true;
            if (f5 == this.asa.y) {
              break label2330;
            }
            bool2 = true;
            if ((!bool1) || (f1 <= f2) || (this.asn)) {
              break label2336;
            }
            bool3 = true;
            if ((!bool2) || (f2 <= f1) || (this.asn)) {
              break label2342;
            }
            bool4 = true;
            if ((f5 != this.asa.y) || (f2 <= 3.0F * f3)) {
              break label2348;
            }
            bool5 = true;
            label2141:
            ab.i(this.TAG, "alvinluo Action_Move edge atXEdge: %b, atYEdge: %b, edgeXSwipe: %b, edgeYSwipe: %b, yPan: %b, isPanning: %b,dx: %f, dy: %f, offset: %f", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(this.asn), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
            if ((bool3) || (bool4) || ((bool1) && (bool2) && (!bool5) && (!this.asn))) {
              break label2354;
            }
            this.asn = true;
          }
          for (;;)
          {
            if (!this.arS)
            {
              this.asa.x = this.asb.x;
              this.asa.y = this.asb.y;
              requestDisallowInterceptTouchEvent(false);
            }
            ax(this.arR);
            bool1 = true;
            break;
            bool1 = false;
            break label2051;
            label2330:
            bool2 = false;
            break label2067;
            label2336:
            bool3 = false;
            break label2090;
            label2342:
            bool4 = false;
            break label2113;
            label2348:
            bool5 = false;
            break label2141;
            label2354:
            if ((f1 > f3) || (f2 > f3))
            {
              this.asp = 0;
              this.handler.removeMessages(1);
              requestDisallowInterceptTouchEvent(false);
            }
          }
          this.handler.removeMessages(1);
          if (this.aso)
          {
            this.aso = false;
            if (!this.asz) {
              a(this.asB, this.asv);
            }
          }
          if ((this.asp > 0) && ((this.asm) || (this.asn)))
          {
            if ((this.asm) && (i == 2))
            {
              this.asn = true;
              this.asb.set(this.asa.x, this.asa.y);
              if (paramMotionEvent.getActionIndex() != 1) {
                break label2639;
              }
              this.asv.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
              label2515:
              if (this.scale > this.atc) {
                break label2659;
              }
              ab.i(this.TAG, "alvinluo scale %f less than %f, and need to reset", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.atc) });
              PointF localPointF = new PointF(this.asY / 2, this.asZ / 2);
              b(localPointF, localPointF, this.atc);
              this.asn = false;
            }
            for (;;)
            {
              if (i < 3) {
                this.asm = false;
              }
              if (i < 2)
              {
                this.asn = false;
                this.asp = 0;
              }
              ax(true);
              bool1 = true;
              break;
              label2639:
              this.asv.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
              break label2515;
              label2659:
              if (this.scale > getDoubleTapZoomScale() * 2.0F)
              {
                ab.i(this.TAG, "alvinluo current scale %f larger than maxScale: %f, and reset to scale: %f", new Object[] { Float.valueOf(this.scale), Float.valueOf(this.arJ), Float.valueOf(getDoubleTapZoomScale() * 2.0F) });
                b(b(this.atj), this.atj, getDoubleTapZoomScale() * 2.0F);
              }
            }
          }
          if (i == 1)
          {
            this.asm = false;
            this.asn = false;
            this.asp = 0;
          }
          bool1 = false;
          break;
          AppMethodBeat.o(115674);
          return false;
          label2779:
          f1 = f2;
        }
      }
      label2786:
      f1 = 1.0F;
    }
  }
  
  public final void setBitmapDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> paramClass)
  {
    AppMethodBeat.i(115712);
    if (paramClass == null)
    {
      paramClass = new IllegalArgumentException("Decoder class cannot be set to null");
      AppMethodBeat.o(115712);
      throw paramClass;
    }
    this.ast = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
    AppMethodBeat.o(115712);
  }
  
  public final void setBitmapDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> paramb)
  {
    AppMethodBeat.i(115713);
    if (paramb == null)
    {
      paramb = new IllegalArgumentException("Decoder factory cannot be set to null");
      AppMethodBeat.o(115713);
      throw paramb;
    }
    this.ast = paramb;
    AppMethodBeat.o(115713);
  }
  
  public final void setDebug(boolean paramBoolean)
  {
    this.arI = paramBoolean;
  }
  
  public final void setDoubleTapZoomDpi(int paramInt)
  {
    AppMethodBeat.i(115726);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    setDoubleTapZoomScale((localDisplayMetrics.ydpi + f) / 2.0F / paramInt);
    AppMethodBeat.o(115726);
  }
  
  public final void setDoubleTapZoomDuration(int paramInt)
  {
    AppMethodBeat.i(115728);
    this.arX = Math.max(0, paramInt);
    AppMethodBeat.o(115728);
  }
  
  public final void setDoubleTapZoomScale(float paramFloat)
  {
    this.arV = paramFloat;
  }
  
  public final void setDoubleTapZoomStyle(int paramInt)
  {
    AppMethodBeat.i(115727);
    if (!ars.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid zoom style: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(115727);
      throw localIllegalArgumentException;
    }
    this.arW = paramInt;
    AppMethodBeat.o(115727);
  }
  
  public void setEagerLoadingEnabled(boolean paramBoolean)
  {
    this.arR = paramBoolean;
  }
  
  public void setEdgeSwipeListener(SubsamplingScaleImageView.c paramc)
  {
    this.atm = paramc;
  }
  
  public void setExecutor(Executor paramExecutor)
  {
    AppMethodBeat.i(115729);
    if (paramExecutor == null)
    {
      paramExecutor = new NullPointerException("Executor must not be null");
      AppMethodBeat.o(115729);
      throw paramExecutor;
    }
    this.executor = paramExecutor;
    AppMethodBeat.o(115729);
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    this.asr = paramSimpleOnGestureListener;
  }
  
  public final void setImage(a parama)
  {
    AppMethodBeat.i(115667);
    a(parama, null);
    AppMethodBeat.o(115667);
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(115666);
    Matrix localMatrix = paramMatrix;
    if (paramMatrix != null)
    {
      localMatrix = paramMatrix;
      if (paramMatrix.isIdentity()) {
        localMatrix = null;
      }
    }
    if (((localMatrix == null) && (!this.asS.isIdentity())) || ((localMatrix != null) && (!this.asS.equals(localMatrix))))
    {
      this.asS.set(localMatrix);
      invalidate();
    }
    AppMethodBeat.o(115666);
  }
  
  public final void setMaxScale(float paramFloat)
  {
    this.arJ = paramFloat;
  }
  
  public void setMaxTileSize(int paramInt)
  {
    this.arP = paramInt;
    this.arQ = paramInt;
  }
  
  public final void setMaximumDpi(int paramInt)
  {
    AppMethodBeat.i(115717);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    setMinScale((localDisplayMetrics.ydpi + f) / 2.0F / paramInt);
    AppMethodBeat.o(115717);
  }
  
  public final void setMinScale(float paramFloat)
  {
    this.arK = paramFloat;
  }
  
  public final void setMinimumDpi(int paramInt)
  {
    AppMethodBeat.i(115716);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    setMaxScale((localDisplayMetrics.ydpi + f) / 2.0F / paramInt);
    AppMethodBeat.o(115716);
  }
  
  public final void setMinimumScaleType(int paramInt)
  {
    AppMethodBeat.i(115715);
    if (!arv.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid scale type: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(115715);
      throw localIllegalArgumentException;
    }
    this.arN = paramInt;
    if (this.asE)
    {
      ay(true);
      invalidate();
    }
    AppMethodBeat.o(115715);
  }
  
  public void setMinimumTileDpi(int paramInt)
  {
    AppMethodBeat.i(115719);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.xdpi;
    this.arL = ((int)Math.min((localDisplayMetrics.ydpi + f) / 2.0F, paramInt));
    if (this.asE)
    {
      reset(false);
      invalidate();
    }
    AppMethodBeat.o(115719);
  }
  
  public void setOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.atk = paramOnAttachStateChangeListener;
  }
  
  public void setOnImageEventListener(SubsamplingScaleImageView.e parame)
  {
    this.asG = parame;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.asI = paramOnLongClickListener;
  }
  
  public void setOnStateChangedListener(SubsamplingScaleImageView.f paramf)
  {
    this.asH = paramf;
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(115661);
    if (!arr.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid orientation: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(115661);
      throw localIllegalArgumentException;
    }
    this.orientation = paramInt;
    reset(false);
    invalidate();
    requestLayout();
    AppMethodBeat.o(115661);
  }
  
  public final void setPanEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(115724);
    this.arS = paramBoolean;
    if ((!paramBoolean) && (this.asa != null))
    {
      this.asa.x = (getWidth() / 2 - this.scale * (lB() / 2));
      this.asa.y = (getHeight() / 2 - this.scale * (lC() / 2));
      if (this.asE)
      {
        ax(true);
        invalidate();
      }
    }
    AppMethodBeat.o(115724);
  }
  
  public final void setPanLimit(int paramInt)
  {
    AppMethodBeat.i(115714);
    if (!aru.contains(Integer.valueOf(paramInt)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid pan limit: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(115714);
      throw localIllegalArgumentException;
    }
    this.arM = paramInt;
    if (this.asE)
    {
      ay(true);
      invalidate();
    }
    AppMethodBeat.o(115714);
  }
  
  public void setPreviewDone(boolean paramBoolean)
  {
    AppMethodBeat.i(115660);
    this.ath = paramBoolean;
    invalidate();
    AppMethodBeat.o(115660);
  }
  
  public final void setQuickScaleEnabled(boolean paramBoolean)
  {
    this.arU = paramBoolean;
  }
  
  public final void setRegionDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> paramClass)
  {
    AppMethodBeat.i(115710);
    if (paramClass == null)
    {
      paramClass = new IllegalArgumentException("Decoder class cannot be set to null");
      AppMethodBeat.o(115710);
      throw paramClass;
    }
    this.asu = new com.davemorrissey.labs.subscaleview.a.a(paramClass);
    AppMethodBeat.o(115710);
  }
  
  public final void setRegionDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> paramb)
  {
    AppMethodBeat.i(115711);
    if (paramb == null)
    {
      paramb = new IllegalArgumentException("Decoder factory cannot be set to null");
      AppMethodBeat.o(115711);
      throw paramb;
    }
    this.asu = paramb;
    AppMethodBeat.o(115711);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(115662);
    this.atc = paramFloat;
    this.arJ = 2.0F;
    this.arK = 1.0F;
    lt();
    lu();
    AppMethodBeat.o(115662);
  }
  
  public final void setTileBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(115725);
    if (Color.alpha(paramInt) == 0) {
      this.asM = null;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(115725);
      return;
      this.asM = new Paint();
      this.asM.setStyle(Paint.Style.FILL);
      this.asM.setColor(paramInt);
    }
  }
  
  public final void setZoomEnabled(boolean paramBoolean)
  {
    this.arT = paramBoolean;
  }
  
  public void setsRegion(Rect paramRect)
  {
    this.arp = paramRect;
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView
 * JD-Core Version:    0.7.0.1
 */