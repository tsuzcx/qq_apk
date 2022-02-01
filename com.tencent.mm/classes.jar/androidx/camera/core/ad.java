package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Rational;
import android.util.Size;
import androidx.c.a.b.a;
import androidx.camera.core.a.a.a.d;
import androidx.camera.core.a.i;
import androidx.camera.core.impl.a.b.c;
import androidx.camera.core.impl.a.l;
import androidx.camera.core.impl.aa;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.ac.-CC;
import androidx.camera.core.impl.ac.a;
import androidx.camera.core.impl.ai;
import androidx.camera.core.impl.ak;
import androidx.camera.core.impl.an;
import androidx.camera.core.impl.an.a;
import androidx.camera.core.impl.ao;
import androidx.camera.core.impl.av;
import androidx.camera.core.impl.az;
import androidx.camera.core.impl.bb.b;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.bk.a;
import androidx.camera.core.impl.bl;
import androidx.camera.core.impl.bl.a;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import androidx.camera.core.impl.z.a;
import androidx.camera.core.impl.z.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ad
  extends ax
{
  public static final b Hx;
  private int Ah;
  private androidx.camera.core.impl.ad Dm;
  private final int HA;
  private final AtomicReference<Integer> HB;
  private final int HC;
  Rational HD;
  private ExecutorService HE;
  private z HF;
  private y HG;
  private int HH;
  private aa HI;
  private boolean HJ;
  as HK;
  aq HL;
  private h HM;
  private d HN;
  final Executor HO;
  private Matrix HP;
  private final an.a Hy;
  final Executor Hz;
  bb.b zY;
  
  static
  {
    AppMethodBeat.i(198324);
    Hx = new b();
    AppMethodBeat.o(198324);
  }
  
  ad(ai paramai)
  {
    super(paramai);
    AppMethodBeat.i(198218);
    this.Hy = ad..ExternalSyntheticLambda4.INSTANCE;
    this.HB = new AtomicReference(null);
    this.Ah = -1;
    this.HD = null;
    this.HJ = false;
    this.HP = new Matrix();
    paramai = (ai)this.JI;
    if (paramai.a(ai.Mx)) {}
    for (this.HA = paramai.kj();; this.HA = 1)
    {
      this.HC = ((Integer)paramai.b(ai.MF, Integer.valueOf(0))).intValue();
      Executor localExecutor = androidx.camera.core.impl.a.a.e.kP();
      this.Hz = ((Executor)androidx.core.f.f.checkNotNull((Executor)paramai.b(ai.Qm, localExecutor)));
      this.HO = androidx.camera.core.impl.a.a.a.b(this.Hz);
      AppMethodBeat.o(198218);
      return;
    }
  }
  
  static Rect a(Rect paramRect, Rational paramRational, int paramInt1, Size paramSize, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(198244);
    float f1;
    if (paramRect != null)
    {
      paramRational = new Matrix();
      paramRational.setRotate(paramInt2 - paramInt1);
      float[] arrayOfFloat = new float[8];
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      arrayOfFloat[2] = paramSize.getWidth();
      arrayOfFloat[3] = 0.0F;
      arrayOfFloat[4] = paramSize.getWidth();
      arrayOfFloat[5] = paramSize.getHeight();
      arrayOfFloat[6] = 0.0F;
      arrayOfFloat[7] = paramSize.getHeight();
      paramRational.mapPoints(arrayOfFloat);
      f1 = androidx.camera.core.a.b.a.min(arrayOfFloat[0], arrayOfFloat[2], arrayOfFloat[4], arrayOfFloat[6]);
      float f2 = androidx.camera.core.a.b.a.min(arrayOfFloat[1], arrayOfFloat[3], arrayOfFloat[5], arrayOfFloat[7]);
      paramRational.postTranslate(-f1, -f2);
      paramRational.invert(paramRational);
      paramSize = new RectF();
      paramRational.mapRect(paramSize, new RectF(paramRect));
      paramSize.sort();
      paramRect = new Rect();
      paramSize.round(paramRect);
      AppMethodBeat.o(198244);
      return paramRect;
    }
    if (paramRational != null)
    {
      paramRect = paramRational;
      if (paramInt2 % 180 != 0) {
        paramRect = new Rational(paramRational.getDenominator(), paramRational.getNumerator());
      }
      int k;
      if ((paramRect != null) && (paramRect.floatValue() > 0.0F))
      {
        paramInt1 = paramSize.getWidth();
        paramInt2 = paramSize.getHeight();
        j = paramRect.getNumerator();
        k = paramRect.getDenominator();
        if ((paramInt2 != Math.round(paramInt1 / j * k)) || (paramInt1 != Math.round(paramInt2 / k * j)))
        {
          paramInt1 = 1;
          if ((paramInt1 == 0) || (paramRect.isNaN())) {
            break label373;
          }
          paramInt1 = 1;
          label324:
          if (paramInt1 == 0) {
            break label520;
          }
          if ((paramRect == null) || (paramRect.floatValue() <= 0.0F) || (paramRect.isNaN())) {
            break label378;
          }
        }
      }
      label373:
      label378:
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label383;
        }
        al.R("ImageUtil");
        AppMethodBeat.o(198244);
        return null;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label324;
      }
      label383:
      paramInt1 = paramSize.getWidth();
      int j = paramSize.getHeight();
      f1 = paramInt1 / j;
      paramInt2 = paramRect.getNumerator();
      i = paramRect.getDenominator();
      if (paramRect.floatValue() > f1)
      {
        i = Math.round(paramInt1 / paramInt2 * i);
        paramInt2 = (j - i) / 2;
        k = 0;
        j = i;
        i = k;
      }
      for (;;)
      {
        paramRect = new Rect(i, paramInt2, paramInt1 + i, paramInt2 + j);
        AppMethodBeat.o(198244);
        return paramRect;
        paramInt2 = Math.round(j / i * paramInt2);
        i = (paramInt1 - paramInt2) / 2;
        paramInt1 = paramInt2;
        paramInt2 = 0;
      }
    }
    label520:
    paramRect = new Rect(0, 0, paramSize.getWidth(), paramSize.getHeight());
    AppMethodBeat.o(198244);
    return paramRect;
  }
  
  private bb.b a(String paramString, ai paramai, Size paramSize)
  {
    AppMethodBeat.i(198231);
    l.checkMainThread();
    bb.b localb = bb.b.b(paramai);
    Object localObject1 = null;
    Object localObject2;
    label118:
    Object localObject3;
    int j;
    int i;
    if (paramai.kh() != null)
    {
      localObject2 = paramai.kh();
      paramSize.getWidth();
      paramSize.getHeight();
      iw();
      this.HK = new as(((ah)localObject2).jf());
      this.HM = new h() {};
      if (this.HN != null) {
        this.HN.g(new CancellationException("Request is canceled."));
      }
      localObject2 = new ad..ExternalSyntheticLambda2(this);
      if (localObject1 == null)
      {
        localObject1 = null;
        this.HN = new d((ad.d.a)localObject2, (ad.d.b)localObject1);
        this.HK.a(this.Hy, androidx.camera.core.impl.a.a.f.kR());
        localObject1 = this.HK;
        if (this.Dm != null) {
          this.Dm.close();
        }
        this.Dm = new ao(this.HK.getSurface(), new Size(this.HK.getWidth(), this.HK.getHeight()), this.HK.iw());
        localObject2 = androidx.camera.core.impl.a.b.e.d(this.Dm.Mj);
        Objects.requireNonNull(localObject1);
        ((com.google.b.b.a.f)localObject2).a(new ad..ExternalSyntheticLambda10((as)localObject1), androidx.camera.core.impl.a.a.f.kR());
        localb.c(this.Dm);
        localb.a(new ad..ExternalSyntheticLambda5(this, paramString, paramai, paramSize));
        AppMethodBeat.o(198231);
        return localb;
      }
    }
    else if ((this.HI != null) || (this.HJ))
    {
      localObject2 = null;
      localObject3 = this.HI;
      j = iw();
      i = iw();
      if (!this.HJ) {
        break label614;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        al.Q("ImageCapture");
        if (this.HI != null)
        {
          localObject1 = new i(ja(), this.HH);
          localObject2 = new w(this.HI, this.HH, (aa)localObject1, this.HE);
          localObject3 = localObject2;
          label391:
          i = 256;
        }
      }
    }
    for (;;)
    {
      this.HL = new aq(new aq.a(paramSize.getWidth(), paramSize.getHeight(), j, this.HH, a(v.iL()), (aa)localObject3).a(this.HE).aU(i));
      this.HM = this.HL.jo();
      this.HK = new as(this.HL);
      if (localObject1 != null) {
        this.HL.jn().a(new ad..ExternalSyntheticLambda6((i)localObject1, (w)localObject2), androidx.camera.core.impl.a.a.b.kP());
      }
      break;
      localObject1 = new i(ja(), this.HH);
      localObject3 = localObject1;
      break label391;
      paramString = new IllegalStateException("Software JPEG only supported on API 26+");
      AppMethodBeat.o(198231);
      throw paramString;
      localObject2 = new am(paramSize.getWidth(), paramSize.getHeight(), iw(), 2);
      this.HM = ((am)localObject2).Cc;
      this.HK = new as((an)localObject2);
      break;
      localObject1 = new ad.d.b()
      {
        public final void b(ad.c paramAnonymousc)
        {
          if (Build.VERSION.SDK_INT >= 26) {
            this.HR.Qs = paramAnonymousc.HV;
          }
        }
      };
      break label118;
      label614:
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  private y a(y paramy)
  {
    AppMethodBeat.i(198266);
    List localList = this.HG.iM();
    if ((localList == null) || (localList.isEmpty()))
    {
      AppMethodBeat.o(198266);
      return paramy;
    }
    paramy = v.G(localList);
    AppMethodBeat.o(198266);
    return paramy;
  }
  
  static int f(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof j)) {
      return 3;
    }
    if ((paramThrowable instanceof ae)) {
      return ((ae)paramThrowable).Ij;
    }
    return 0;
  }
  
  private int getFlashMode()
  {
    AppMethodBeat.i(198239);
    synchronized (this.HB)
    {
      if (this.Ah != -1)
      {
        i = this.Ah;
        AppMethodBeat.o(198239);
        return i;
      }
      int i = ((Integer)((ai)this.JI).b(ai.My, Integer.valueOf(2))).intValue();
    }
  }
  
  private void iN()
  {
    AppMethodBeat.i(198235);
    l.checkMainThread();
    if (this.HN != null)
    {
      this.HN.g(new CancellationException("Request is canceled."));
      this.HN = null;
    }
    androidx.camera.core.impl.ad localad = this.Dm;
    this.Dm = null;
    this.HK = null;
    this.HL = null;
    if (localad != null) {
      localad.close();
    }
    AppMethodBeat.o(198235);
  }
  
  private void iX()
  {
    AppMethodBeat.i(198248);
    if (this.HN != null)
    {
      j localj = new j("Camera is closed.");
      this.HN.g(localj);
    }
    AppMethodBeat.o(198248);
  }
  
  private void iZ()
  {
    AppMethodBeat.i(198254);
    synchronized (this.HB)
    {
      if (this.HB.get() != null)
      {
        AppMethodBeat.o(198254);
        return;
      }
      jC().setFlashMode(getFlashMode());
      AppMethodBeat.o(198254);
      return;
    }
  }
  
  private int ja()
  {
    AppMethodBeat.i(198259);
    Object localObject = (ai)this.JI;
    if (((ai)localObject).a(ai.MG))
    {
      int i = ((ai)localObject).kk();
      AppMethodBeat.o(198259);
      return i;
    }
    switch (this.HA)
    {
    default: 
      localObject = new IllegalStateException("CaptureMode " + this.HA + " is invalid");
      AppMethodBeat.o(198259);
      throw ((Throwable)localObject);
    case 0: 
      AppMethodBeat.o(198259);
      return 100;
    }
    AppMethodBeat.o(198259);
    return 95;
  }
  
  protected final bk<?> a(s params, bk.a<?, ?, ?> parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(198427);
    if ((parama.iT().b(ai.MA, null) == null) || (Build.VERSION.SDK_INT < 29)) {
      if (params.hb().g(d.class))
      {
        if (!((Boolean)parama.fU().b(ai.ME, Boolean.TRUE)).booleanValue()) {
          al.R("ImageCapture");
        }
      }
      else
      {
        params = parama.fU();
        if (!((Boolean)params.b(ai.ME, Boolean.FALSE)).booleanValue()) {
          break label369;
        }
        if (Build.VERSION.SDK_INT >= 26) {
          break label464;
        }
        new StringBuilder("Software JPEG only supported on API 26+, but current API level is ").append(Build.VERSION.SDK_INT);
        al.R("ImageCapture");
      }
    }
    label204:
    label464:
    for (int i = 0;; i = 1)
    {
      Object localObject = (Integer)params.b(ai.MC, null);
      if ((localObject != null) && (((Integer)localObject).intValue() != 256))
      {
        al.R("ImageCapture");
        i = 0;
      }
      for (;;)
      {
        if (i == 0)
        {
          al.R("ImageCapture");
          params.c(ai.ME, Boolean.FALSE);
        }
        params = (Integer)parama.fU().b(ai.MC, null);
        if (params != null) {
          if (parama.fU().b(ai.MA, null) == null)
          {
            bool1 = true;
            label248:
            androidx.core.f.f.checkArgument(bool1, "Cannot set buffer format with CaptureProcessor defined.");
            localObject = parama.fU();
            ac.a locala = ak.MH;
            if (i == 0) {
              break label380;
            }
            i = 35;
            ((androidx.camera.core.impl.as)localObject).c(locala, Integer.valueOf(i));
            if (((Integer)parama.fU().b(ai.MD, Integer.valueOf(2))).intValue() <= 0) {
              break label455;
            }
          }
        }
        for (boolean bool1 = bool2;; bool1 = false)
        {
          androidx.core.f.f.checkArgument(bool1, "Maximum outstanding image count must be at least 1");
          params = parama.iT();
          AppMethodBeat.o(198427);
          return params;
          al.Q("ImageCapture");
          parama.fU().c(ai.ME, Boolean.TRUE);
          break;
          label369:
          i = 0;
          break label204;
          bool1 = false;
          break label248;
          label380:
          i = params.intValue();
          break label276;
          if ((parama.fU().b(ai.MA, null) != null) || (i != 0))
          {
            parama.fU().c(ak.MH, Integer.valueOf(35));
            break label289;
          }
          parama.fU().c(ak.MH, Integer.valueOf(256));
          break label289;
        }
      }
    }
  }
  
  public final bk<?> a(boolean paramBoolean, bl parambl)
  {
    AppMethodBeat.i(198409);
    ac localac = parambl.a(bl.a.NM);
    parambl = localac;
    if (paramBoolean) {
      parambl = ac.-CC.a(localac, b.jd());
    }
    if (parambl == null)
    {
      AppMethodBeat.o(198409);
      return null;
    }
    parambl = a.f(parambl).iT();
    AppMethodBeat.o(198409);
    return parambl;
  }
  
  public final void a(Executor arg1, e parame)
  {
    AppMethodBeat.i(198441);
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      androidx.camera.core.impl.a.a.f.kR().execute(new ad..ExternalSyntheticLambda9(this, ???, parame));
      AppMethodBeat.o(198441);
      return;
    }
    int i = ja();
    t localt = jA();
    if (localt == null)
    {
      ???.execute(new ad..ExternalSyntheticLambda8(this, parame));
      AppMethodBeat.o(198441);
      return;
    }
    if (this.HN == null)
    {
      ???.execute(new ad..ExternalSyntheticLambda7(parame));
      AppMethodBeat.o(198441);
      return;
    }
    d locald = this.HN;
    parame = new c(a(localt), i, this.HD, this.HZ, this.HP, ???, parame);
    synchronized (locald.mLock)
    {
      locald.Ia.offer(parame);
      parame = Locale.US;
      if (locald.Ib != null)
      {
        i = 1;
        String.format(parame, "Send image capture request [current, pending] = [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(locald.Ia.size()) });
        al.O("ImageCapture");
        locald.je();
        AppMethodBeat.o(198441);
        return;
      }
      i = 0;
    }
  }
  
  protected final Size d(Size paramSize)
  {
    AppMethodBeat.i(198463);
    this.zY = a(gV(), (ai)this.JI, paramSize);
    d(this.zY.ky());
    jv();
    AppMethodBeat.o(198463);
    return paramSize;
  }
  
  public final bk.a<?, ?, ?> d(ac paramac)
  {
    AppMethodBeat.i(369505);
    paramac = a.f(paramac);
    AppMethodBeat.o(369505);
    return paramac;
  }
  
  public final void iQ()
  {
    AppMethodBeat.i(198454);
    iX();
    iN();
    this.HJ = false;
    this.HE.shutdown();
    AppMethodBeat.o(198454);
  }
  
  public final void iR()
  {
    AppMethodBeat.i(198459);
    Object localObject1 = (ai)this.JI;
    Object localObject2 = ((bk)localObject1).kI();
    if (localObject2 == null)
    {
      localObject1 = new IllegalStateException("Implementation is missing option unpacker for " + ((bk)localObject1).ag(localObject1.toString()));
      AppMethodBeat.o(198459);
      throw ((Throwable)localObject1);
    }
    z.a locala = new z.a();
    ((z.b)localObject2).a((bk)localObject1, locala);
    this.HF = locala.kc();
    this.HI = ((aa)((ai)localObject1).b(ai.MA, null));
    this.HH = ((Integer)((ai)localObject1).b(ai.MD, Integer.valueOf(2))).intValue();
    localObject2 = v.iL();
    this.HG = ((y)((ai)localObject1).b(ai.Mz, localObject2));
    this.HJ = ((Boolean)((ai)localObject1).b(ai.ME, Boolean.FALSE)).booleanValue();
    androidx.core.f.f.checkNotNull(jA(), "Attached camera cannot be null");
    this.HE = Executors.newFixedThreadPool(1, new ad.4(this));
    AppMethodBeat.o(198459);
  }
  
  protected final void iV()
  {
    AppMethodBeat.i(198432);
    iZ();
    AppMethodBeat.o(198432);
  }
  
  public final void iW()
  {
    AppMethodBeat.i(198444);
    iX();
    AppMethodBeat.o(198444);
  }
  
  final void iY()
  {
    AppMethodBeat.i(198449);
    synchronized (this.HB)
    {
      Integer localInteger = (Integer)this.HB.getAndSet(null);
      if (localInteger == null)
      {
        AppMethodBeat.o(198449);
        return;
      }
      if (localInteger.intValue() != getFlashMode()) {
        iZ();
      }
      AppMethodBeat.o(198449);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198451);
    String str = "ImageCapture:" + getName();
    AppMethodBeat.o(198451);
    return str;
  }
  
  public static final class a
    implements bk.a<ad, ai, a>
  {
    public final androidx.camera.core.impl.at He;
    
    public a()
    {
      this(androidx.camera.core.impl.at.ku());
      AppMethodBeat.i(198568);
      AppMethodBeat.o(198568);
    }
    
    private a(androidx.camera.core.impl.at paramat)
    {
      AppMethodBeat.i(198576);
      this.He = paramat;
      paramat = (Class)paramat.b(androidx.camera.core.a.f.Qo, null);
      if ((paramat != null) && (!paramat.equals(ad.class)))
      {
        paramat = new IllegalArgumentException("Invalid target class configuration for " + this + ": " + paramat);
        AppMethodBeat.o(198576);
        throw paramat;
      }
      this.He.c(ai.Qo, ad.class);
      if (this.He.b(ai.Qn, null) == null) {
        M(ad.class.getCanonicalName() + "-" + UUID.randomUUID());
      }
      AppMethodBeat.o(198576);
    }
    
    public static a f(ac paramac)
    {
      AppMethodBeat.i(198583);
      paramac = new a(androidx.camera.core.impl.at.k(paramac));
      AppMethodBeat.o(198583);
      return paramac;
    }
    
    public final a M(String paramString)
    {
      AppMethodBeat.i(198606);
      this.He.c(ai.Qn, paramString);
      AppMethodBeat.o(198606);
      return this;
    }
    
    public final androidx.camera.core.impl.as fU()
    {
      return this.He;
    }
    
    public final ai jb()
    {
      AppMethodBeat.i(198592);
      ai localai = new ai(av.l(this.He));
      AppMethodBeat.o(198592);
      return localai;
    }
    
    public final ad jc()
    {
      boolean bool2 = false;
      AppMethodBeat.i(198603);
      if ((this.He.b(ai.MI, null) != null) && (this.He.b(ai.MK, null) != null))
      {
        localObject = new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        AppMethodBeat.o(198603);
        throw ((Throwable)localObject);
      }
      Object localObject = (Integer)this.He.b(ai.MC, null);
      boolean bool1;
      if (localObject != null) {
        if (this.He.b(ai.MA, null) == null)
        {
          bool1 = true;
          androidx.core.f.f.checkArgument(bool1, "Cannot set buffer format with CaptureProcessor defined.");
          this.He.c(ak.MH, localObject);
        }
      }
      for (;;)
      {
        localObject = new ad(jb());
        Size localSize = (Size)this.He.b(ai.MK, null);
        if (localSize != null) {
          ((ad)localObject).HD = new Rational(localSize.getWidth(), localSize.getHeight());
        }
        bool1 = bool2;
        if (((Integer)this.He.b(ai.MD, Integer.valueOf(2))).intValue() > 0) {
          bool1 = true;
        }
        androidx.core.f.f.checkArgument(bool1, "Maximum outstanding image count must be at least 1");
        androidx.core.f.f.checkNotNull((Executor)this.He.b(ai.Qm, androidx.camera.core.impl.a.a.e.kP()), "The IO executor can't be null");
        if (!this.He.a(ai.My)) {
          break label372;
        }
        int i = ((Integer)this.He.b(ai.My)).intValue();
        if ((i == 0) || (i == 1) || (i == 2)) {
          break label372;
        }
        localObject = new IllegalArgumentException("The flash mode is not allowed to set: ".concat(String.valueOf(i)));
        AppMethodBeat.o(198603);
        throw ((Throwable)localObject);
        bool1 = false;
        break;
        if (this.He.b(ai.MA, null) != null) {
          this.He.c(ak.MH, Integer.valueOf(35));
        } else {
          this.He.c(ak.MH, Integer.valueOf(256));
        }
      }
      label372:
      AppMethodBeat.o(198603);
      return localObject;
    }
  }
  
  public static final class b
  {
    private static final ai HT;
    
    static
    {
      AppMethodBeat.i(198571);
      ad.a locala = new ad.a();
      locala.He.c(ai.NJ, Integer.valueOf(4));
      locala.He.c(ai.MI, Integer.valueOf(0));
      HT = locala.jb();
      AppMethodBeat.o(198571);
    }
    
    public static ai jd()
    {
      return HT;
    }
  }
  
  static final class c
  {
    private final Rational Ei;
    private final Matrix HP;
    final int HU;
    final int HV;
    private final Executor HW;
    private final ad.e HX;
    AtomicBoolean HY;
    private final Rect HZ;
    
    c(int paramInt1, int paramInt2, Rational paramRational, Rect paramRect, Matrix paramMatrix, Executor paramExecutor, ad.e parame)
    {
      AppMethodBeat.i(198574);
      this.HY = new AtomicBoolean(false);
      this.HU = paramInt1;
      this.HV = paramInt2;
      if (paramRational != null)
      {
        if (paramRational.isZero()) {
          break label110;
        }
        bool1 = true;
        androidx.core.f.f.checkArgument(bool1, "Target ratio cannot be zero");
        if (paramRational.floatValue() <= 0.0F) {
          break label116;
        }
      }
      label110:
      label116:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        androidx.core.f.f.checkArgument(bool1, "Target ratio must be positive");
        this.Ei = paramRational;
        this.HZ = paramRect;
        this.HP = paramMatrix;
        this.HW = paramExecutor;
        this.HX = parame;
        AppMethodBeat.o(198574);
        return;
        bool1 = false;
        break;
      }
    }
    
    final void b(ag paramag)
    {
      AppMethodBeat.i(198618);
      if (!this.HY.compareAndSet(false, true))
      {
        paramag.close();
        AppMethodBeat.o(198618);
        return;
      }
      new androidx.camera.core.a.a.b.a();
      int i;
      if ((((androidx.camera.core.a.a.a.b)androidx.camera.core.a.a.a.a.f(androidx.camera.core.a.a.a.b.class) == null) || (androidx.camera.core.a.a.a.b.f(z.LT))) && (paramag.getFormat() == 256))
      {
        i = 1;
        if (i == 0) {
          break label268;
        }
      }
      for (;;)
      {
        try
        {
          Object localObject1 = paramag.is()[0].getBuffer();
          ((ByteBuffer)localObject1).rewind();
          localObject2 = new byte[((ByteBuffer)localObject1).capacity()];
          ((ByteBuffer)localObject1).get((byte[])localObject2);
          localObject2 = androidx.camera.core.impl.a.e.h(new ByteArrayInputStream((byte[])localObject2));
          ((ByteBuffer)localObject1).rewind();
          localObject1 = new Size(((androidx.camera.core.impl.a.e)localObject2).getWidth(), ((androidx.camera.core.impl.a.e)localObject2).getHeight());
          i = ((androidx.camera.core.impl.a.e)localObject2).getRotation();
          localObject2 = new at(paramag, (Size)localObject1, aj.a(paramag.it().go(), paramag.it().getTimestamp(), i, this.HP));
          ((ag)localObject2).setCropRect(ad.a(this.HZ, this.Ei, this.HU, (Size)localObject1, i));
        }
        catch (IOException localIOException)
        {
          Object localObject2;
          c(1, "Unable to parse JPEG exif", localIOException);
          paramag.close();
          AppMethodBeat.o(198618);
          return;
        }
        try
        {
          this.HW.execute(new ad.c..ExternalSyntheticLambda1(this, (ag)localObject2));
          AppMethodBeat.o(198618);
          return;
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          Size localSize;
          al.T("ImageCapture");
          paramag.close();
          AppMethodBeat.o(198618);
        }
        i = 0;
        break;
        label268:
        localSize = new Size(paramag.getWidth(), paramag.getHeight());
        i = this.HU;
      }
    }
    
    final void c(int paramInt, String paramString, Throwable paramThrowable)
    {
      AppMethodBeat.i(198622);
      if (!this.HY.compareAndSet(false, true))
      {
        AppMethodBeat.o(198622);
        return;
      }
      try
      {
        this.HW.execute(new ad.c..ExternalSyntheticLambda0(this, paramInt, paramString, paramThrowable));
        AppMethodBeat.o(198622);
        return;
      }
      catch (RejectedExecutionException paramString)
      {
        al.T("ImageCapture");
        AppMethodBeat.o(198622);
      }
    }
  }
  
  static final class d
    implements aa.a
  {
    private final int Hi;
    final Deque<ad.c> Ia;
    ad.c Ib;
    com.google.b.b.a.f<ag> Ic;
    int Ie;
    private final a If;
    private final b Ig;
    final Object mLock;
    
    d(a parama, b paramb)
    {
      AppMethodBeat.i(198566);
      this.Ia = new ArrayDeque();
      this.Ib = null;
      this.Ic = null;
      this.Ie = 0;
      this.mLock = new Object();
      this.Hi = 2;
      this.If = parama;
      this.Ig = paramb;
      AppMethodBeat.o(198566);
    }
    
    public final void g(Throwable paramThrowable)
    {
      AppMethodBeat.i(198572);
      synchronized (this.mLock)
      {
        ad.c localc = this.Ib;
        this.Ib = null;
        com.google.b.b.a.f localf = this.Ic;
        this.Ic = null;
        ArrayList localArrayList = new ArrayList(this.Ia);
        this.Ia.clear();
        if ((localc != null) && (localf != null))
        {
          localc.c(ad.f(paramThrowable), paramThrowable.getMessage(), paramThrowable);
          localf.cancel(true);
        }
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((ad.c)((Iterator)???).next()).c(ad.f(paramThrowable), paramThrowable.getMessage(), paramThrowable);
        }
      }
    }
    
    final void je()
    {
      AppMethodBeat.i(198589);
      synchronized (this.mLock)
      {
        if (this.Ib != null)
        {
          AppMethodBeat.o(198589);
          return;
        }
        if (this.Ie >= this.Hi)
        {
          al.R("ImageCapture");
          AppMethodBeat.o(198589);
          return;
        }
        final ad.c localc = (ad.c)this.Ia.poll();
        if (localc == null)
        {
          AppMethodBeat.o(198589);
          return;
        }
        this.Ib = localc;
        if (this.Ig != null) {
          this.Ig.b(this.Ib);
        }
        this.Ic = this.If.capture(localc);
        androidx.camera.core.impl.a.b.e.a(this.Ic, new c()
        {
          public final void onFailure(Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(198435);
            synchronized (ad.d.this.mLock)
            {
              if (!(paramAnonymousThrowable instanceof CancellationException))
              {
                ad.c localc = localc;
                int i = ad.f(paramAnonymousThrowable);
                if (paramAnonymousThrowable != null)
                {
                  str = paramAnonymousThrowable.getMessage();
                  localc.c(i, str, paramAnonymousThrowable);
                }
              }
              else
              {
                ad.d.this.Ib = null;
                ad.d.this.Ic = null;
                ad.d.this.je();
                AppMethodBeat.o(198435);
                return;
              }
              String str = "Unknown error";
            }
          }
        }, androidx.camera.core.impl.a.a.b.kP());
        AppMethodBeat.o(198589);
        return;
      }
    }
    
    public final void onImageClose(ag arg1)
    {
      AppMethodBeat.i(198581);
      synchronized (this.mLock)
      {
        this.Ie -= 1;
        je();
        AppMethodBeat.o(198581);
        return;
      }
    }
    
    static abstract interface a
    {
      public abstract com.google.b.b.a.f<ag> capture(ad.c paramc);
    }
    
    static abstract interface b
    {
      public abstract void b(ad.c paramc);
    }
  }
  
  public static abstract class e
  {
    public void a(ae paramae) {}
    
    public void d(ag paramag) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.ad
 * JD-Core Version:    0.7.0.1
 */