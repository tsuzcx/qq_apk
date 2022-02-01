package androidx.camera.core;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.aa;
import androidx.camera.core.impl.ab;
import androidx.camera.core.impl.ab.a;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.ac.-CC;
import androidx.camera.core.impl.ad;
import androidx.camera.core.impl.aj;
import androidx.camera.core.impl.ak;
import androidx.camera.core.impl.as;
import androidx.camera.core.impl.at;
import androidx.camera.core.impl.av;
import androidx.camera.core.impl.bb.b;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.bk.a;
import androidx.camera.core.impl.bl;
import androidx.camera.core.impl.bl.a;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class ap
  extends ax
{
  public static final b Iy;
  private static final Executor Iz;
  private c IA;
  private Executor IB = Iz;
  private ad IC;
  aw IE;
  private boolean IF = false;
  private Size IG;
  
  static
  {
    AppMethodBeat.i(198448);
    Iy = new b();
    Iz = androidx.camera.core.impl.a.a.f.kR();
    AppMethodBeat.o(198448);
  }
  
  ap(androidx.camera.core.impl.ax paramax)
  {
    super(paramax);
  }
  
  private bb.b a(String paramString, androidx.camera.core.impl.ax paramax, Size paramSize)
  {
    AppMethodBeat.i(198378);
    androidx.camera.core.impl.a.l.checkMainThread();
    bb.b localb = bb.b.b(paramax);
    Object localObject2 = (aa)paramax.b(androidx.camera.core.impl.ax.MY, null);
    if (this.IC != null) {
      this.IC.close();
    }
    Object localObject1 = jA();
    boolean bool;
    Object localObject3;
    if (localObject2 != null)
    {
      bool = true;
      localObject3 = new aw(paramSize, (t)localObject1, bool);
      this.IE = ((aw)localObject3);
      if (!jj()) {
        break label277;
      }
      ji();
      label86:
      if (localObject2 == null) {
        break label285;
      }
      localObject1 = new ab.a();
      HandlerThread localHandlerThread = new HandlerThread("CameraX-preview_processing");
      localHandlerThread.start();
      String str = Integer.toString(localObject1.hashCode());
      localObject2 = new ar(paramSize.getWidth(), paramSize.getHeight(), paramax.ki(), new Handler(localHandlerThread.getLooper()), (ab)localObject1, (aa)localObject2, ((aw)localObject3).Js, str);
      localb.b(((ar)localObject2).jo());
      localObject3 = e.d(((ad)localObject2).Mj);
      Objects.requireNonNull(localHandlerThread);
      ((com.google.b.b.a.f)localObject3).a(new ap..ExternalSyntheticLambda1(localHandlerThread), androidx.camera.core.impl.a.a.b.kP());
      this.IC = ((ad)localObject2);
      localb.g(str, Integer.valueOf(((ab)localObject1).getId()));
    }
    for (;;)
    {
      localb.b(this.IC);
      localb.a(new ap..ExternalSyntheticLambda0(this, paramString, paramax, paramSize));
      AppMethodBeat.o(198378);
      return localb;
      bool = false;
      break;
      label277:
      this.IF = true;
      break label86;
      label285:
      localObject1 = (aj)paramax.b(androidx.camera.core.impl.ax.MX, null);
      if (localObject1 != null) {
        localb.b(new h()
        {
          public final void a(androidx.camera.core.impl.l paramAnonymousl)
          {
            AppMethodBeat.i(198597);
            super.a(paramAnonymousl);
            aj localaj = this.IH;
            new androidx.camera.core.a.b(paramAnonymousl);
            if (localaj.kl()) {
              ap.this.jx();
            }
            AppMethodBeat.o(198597);
          }
        });
      }
      this.IC = ((aw)localObject3).Js;
    }
  }
  
  private void b(String paramString, androidx.camera.core.impl.ax paramax, Size paramSize)
  {
    AppMethodBeat.i(198424);
    d(a(paramString, paramax, paramSize).ky());
    AppMethodBeat.o(198424);
  }
  
  private Rect e(Size paramSize)
  {
    AppMethodBeat.i(198404);
    if (this.HZ != null)
    {
      paramSize = this.HZ;
      AppMethodBeat.o(198404);
      return paramSize;
    }
    if (paramSize != null)
    {
      paramSize = new Rect(0, 0, paramSize.getWidth(), paramSize.getHeight());
      AppMethodBeat.o(198404);
      return paramSize;
    }
    AppMethodBeat.o(198404);
    return null;
  }
  
  private void ji()
  {
    AppMethodBeat.i(198393);
    t localt = jA();
    c localc = this.IA;
    Rect localRect = e(this.IG);
    aw localaw = this.IE;
    if ((localt != null) && (localc != null) && (localRect != null)) {
      localaw.a(aw.c.b(localRect, a(localt), ju()));
    }
    AppMethodBeat.o(198393);
  }
  
  private boolean jj()
  {
    AppMethodBeat.i(198418);
    aw localaw = this.IE;
    c localc = this.IA;
    if ((localc != null) && (localaw != null))
    {
      this.IB.execute(new ap..ExternalSyntheticLambda2(localc, localaw));
      AppMethodBeat.o(198418);
      return true;
    }
    AppMethodBeat.o(198418);
    return false;
  }
  
  protected final bk<?> a(s params, bk.a<?, ?, ?> parama)
  {
    AppMethodBeat.i(198500);
    if (parama.fU().b(androidx.camera.core.impl.ax.MY, null) != null) {
      parama.fU().c(ak.MH, Integer.valueOf(35));
    }
    for (;;)
    {
      params = parama.iT();
      AppMethodBeat.o(198500);
      return params;
      parama.fU().c(ak.MH, Integer.valueOf(34));
    }
  }
  
  public final bk<?> a(boolean paramBoolean, bl parambl)
  {
    AppMethodBeat.i(198492);
    ac localac = parambl.a(bl.a.NN);
    parambl = localac;
    if (paramBoolean) {
      parambl = ac.-CC.a(localac, b.jm());
    }
    if (parambl == null)
    {
      AppMethodBeat.o(198492);
      return null;
    }
    parambl = a.g(parambl).iT();
    AppMethodBeat.o(198492);
    return parambl;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(198468);
    a(Iz, paramc);
    AppMethodBeat.o(198468);
  }
  
  public final void a(Executor paramExecutor, c paramc)
  {
    AppMethodBeat.i(198464);
    androidx.camera.core.impl.a.l.checkMainThread();
    if (paramc == null)
    {
      this.IA = null;
      jw();
      AppMethodBeat.o(198464);
      return;
    }
    this.IA = paramc;
    this.IB = paramExecutor;
    jv();
    if (this.IF)
    {
      if (jj())
      {
        ji();
        this.IF = false;
        AppMethodBeat.o(198464);
      }
    }
    else if (this.JJ != null)
    {
      b(gV(), (androidx.camera.core.impl.ax)this.JI, this.JJ);
      jy();
    }
    AppMethodBeat.o(198464);
  }
  
  protected final Size d(Size paramSize)
  {
    AppMethodBeat.i(198528);
    this.IG = paramSize;
    b(gV(), (androidx.camera.core.impl.ax)this.JI, this.IG);
    AppMethodBeat.o(198528);
    return paramSize;
  }
  
  public final bk.a<?, ?, ?> d(ac paramac)
  {
    AppMethodBeat.i(369506);
    paramac = a.g(paramac);
    AppMethodBeat.o(369506);
    return paramac;
  }
  
  public final int iE()
  {
    AppMethodBeat.i(369504);
    int i = ju();
    AppMethodBeat.o(369504);
    return i;
  }
  
  public final void iQ()
  {
    AppMethodBeat.i(198517);
    if (this.IC != null) {
      this.IC.close();
    }
    this.IE = null;
    AppMethodBeat.o(198517);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198477);
    String str = "Preview:" + getName();
    AppMethodBeat.o(198477);
    return str;
  }
  
  public static final class a
    implements bk.a<ap, androidx.camera.core.impl.ax, a>
  {
    public final at He;
    
    public a()
    {
      this(at.ku());
      AppMethodBeat.i(198507);
      AppMethodBeat.o(198507);
    }
    
    private a(at paramat)
    {
      AppMethodBeat.i(198518);
      this.He = paramat;
      paramat = (Class)paramat.b(androidx.camera.core.a.f.Qo, null);
      if ((paramat != null) && (!paramat.equals(ap.class)))
      {
        paramat = new IllegalArgumentException("Invalid target class configuration for " + this + ": " + paramat);
        AppMethodBeat.o(198518);
        throw paramat;
      }
      this.He.c(androidx.camera.core.impl.ax.Qo, ap.class);
      if (this.He.b(androidx.camera.core.impl.ax.Qn, null) == null) {
        W(ap.class.getCanonicalName() + "-" + UUID.randomUUID());
      }
      AppMethodBeat.o(198518);
    }
    
    static a g(ac paramac)
    {
      AppMethodBeat.i(198527);
      paramac = new a(at.k(paramac));
      AppMethodBeat.o(198527);
      return paramac;
    }
    
    public final a W(String paramString)
    {
      AppMethodBeat.i(198557);
      this.He.c(androidx.camera.core.impl.ax.Qn, paramString);
      AppMethodBeat.o(198557);
      return this;
    }
    
    public final as fU()
    {
      return this.He;
    }
    
    public final androidx.camera.core.impl.ax jk()
    {
      AppMethodBeat.i(198538);
      androidx.camera.core.impl.ax localax = new androidx.camera.core.impl.ax(av.l(this.He));
      AppMethodBeat.o(198538);
      return localax;
    }
    
    public final ap jl()
    {
      AppMethodBeat.i(198547);
      if ((this.He.b(androidx.camera.core.impl.ax.MI, null) != null) && (this.He.b(androidx.camera.core.impl.ax.MK, null) != null))
      {
        localObject = new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        AppMethodBeat.o(198547);
        throw ((Throwable)localObject);
      }
      Object localObject = new ap(jk());
      AppMethodBeat.o(198547);
      return localObject;
    }
  }
  
  public static final class b
  {
    private static final androidx.camera.core.impl.ax IJ;
    
    static
    {
      AppMethodBeat.i(198519);
      ap.a locala = new ap.a();
      locala.He.c(androidx.camera.core.impl.ax.NJ, Integer.valueOf(2));
      locala.He.c(androidx.camera.core.impl.ax.MI, Integer.valueOf(0));
      IJ = locala.jk();
      AppMethodBeat.o(198519);
    }
    
    public static androidx.camera.core.impl.ax jm()
    {
      return IJ;
    }
  }
  
  public static abstract interface c
  {
    public abstract void onSurfaceRequested(aw paramaw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.ap
 * JD-Core Version:    0.7.0.1
 */