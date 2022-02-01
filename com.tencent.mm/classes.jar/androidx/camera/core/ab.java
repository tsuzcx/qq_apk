package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.a.a.a.c;
import androidx.camera.core.impl.a.a.d;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.a.l;
import androidx.camera.core.impl.ac.-CC;
import androidx.camera.core.impl.ad;
import androidx.camera.core.impl.al;
import androidx.camera.core.impl.ao;
import androidx.camera.core.impl.at;
import androidx.camera.core.impl.av;
import androidx.camera.core.impl.az;
import androidx.camera.core.impl.bb.b;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.bk.a;
import androidx.camera.core.impl.bl;
import androidx.camera.core.impl.bl.a;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class ab
  extends ax
{
  public static final c Hr;
  private static final Boolean Hs;
  private ad Dm;
  final ac Ht;
  
  static
  {
    AppMethodBeat.i(198247);
    Hr = new c();
    Hs = null;
    AppMethodBeat.o(198247);
  }
  
  private bb.b a(String paramString, androidx.camera.core.impl.ah paramah, Size paramSize)
  {
    int i1 = 1;
    AppMethodBeat.i(198229);
    l.checkMainThread();
    Object localObject3 = (Executor)androidx.core.f.f.checkNotNull(paramah.d(d.kP()));
    int i;
    Object localObject1;
    label123:
    int j;
    label185:
    label196:
    label207:
    int k;
    label218:
    int m;
    label238:
    int n;
    if (((Integer)((androidx.camera.core.impl.ah)this.JI).b(androidx.camera.core.impl.ah.Mr, Integer.valueOf(0))).intValue() == 1)
    {
      i = ((Integer)((androidx.camera.core.impl.ah)this.JI).b(androidx.camera.core.impl.ah.Ms, Integer.valueOf(6))).intValue();
      if (paramah.kh() == null) {
        break label337;
      }
      localObject1 = paramah.kh();
      paramSize.getWidth();
      paramSize.getHeight();
      iw();
      localObject1 = new as(((ah)localObject1).jf());
      if (jA() == null) {
        break label378;
      }
      localObject2 = jA();
      localObject4 = (androidx.camera.core.impl.ah)this.JI;
      Boolean localBoolean = Boolean.FALSE;
      if (!((Boolean)((androidx.camera.core.impl.ah)localObject4).b(androidx.camera.core.impl.ah.Mw, localBoolean)).booleanValue()) {
        break label372;
      }
      if (a((t)localObject2) % 180 == 0) {
        break label366;
      }
      i = 1;
      if (i == 0) {
        break label384;
      }
      j = paramSize.getHeight();
      if (i == 0) {
        break label393;
      }
      i = paramSize.getWidth();
      if (iO() != 2) {
        break label402;
      }
      k = 1;
      if ((iw() != 35) || (iO() != 2)) {
        break label409;
      }
      m = 1;
      if (iw() != 35) {
        break label415;
      }
      if (jA() != null)
      {
        n = i1;
        if (a(jA()) != 0) {}
      }
      else
      {
        if (!Boolean.TRUE.equals(iP())) {
          break label415;
        }
        n = i1;
      }
      label286:
      if ((m == 0) && (n == 0)) {
        break label421;
      }
    }
    label384:
    label393:
    label402:
    label409:
    label415:
    label421:
    for (Object localObject2 = new as(ai.d(j, i, k, ((as)localObject1).ix()));; localObject2 = null)
    {
      if (localObject2 == null) {
        break label427;
      }
      AppMethodBeat.o(198229);
      throw null;
      i = 4;
      break;
      label337:
      localObject1 = new as(ai.d(paramSize.getWidth(), paramSize.getHeight(), iw(), i));
      break label123;
      label366:
      i = 0;
      break label185;
      label372:
      i = 0;
      break label185;
      label378:
      i = 0;
      break label185;
      j = paramSize.getWidth();
      break label196;
      i = paramSize.getHeight();
      break label207;
      k = 35;
      break label218;
      m = 0;
      break label238;
      n = 0;
      break label286;
    }
    label427:
    Object localObject4 = jA();
    if (localObject4 != null)
    {
      a((t)localObject4);
      AppMethodBeat.o(198229);
      throw null;
    }
    ((as)localObject1).a(this.Ht, (Executor)localObject3);
    localObject3 = bb.b.b(paramah);
    if (this.Dm != null) {
      this.Dm.close();
    }
    this.Dm = new ao(((as)localObject1).getSurface(), paramSize, iw());
    e.d(this.Dm.Mj).a(new ab..ExternalSyntheticLambda1((as)localObject1, (as)localObject2), androidx.camera.core.impl.a.a.f.kR());
    ((bb.b)localObject3).b(this.Dm);
    ((bb.b)localObject3).a(new ab..ExternalSyntheticLambda0(this, paramString, paramah, paramSize));
    AppMethodBeat.o(198229);
    return localObject3;
  }
  
  private void iN()
  {
    AppMethodBeat.i(198233);
    l.checkMainThread();
    if (this.Dm != null)
    {
      this.Dm.close();
      this.Dm = null;
    }
    AppMethodBeat.o(198233);
  }
  
  private int iO()
  {
    AppMethodBeat.i(198236);
    int i = ((androidx.camera.core.impl.ah)this.JI).kg();
    AppMethodBeat.o(198236);
    return i;
  }
  
  private Boolean iP()
  {
    AppMethodBeat.i(198240);
    Boolean localBoolean = ((androidx.camera.core.impl.ah)this.JI).c(Hs);
    AppMethodBeat.o(198240);
    return localBoolean;
  }
  
  protected final bk<?> a(s params, bk.a<?, ?, ?> parama)
  {
    AppMethodBeat.i(198261);
    parama = iP();
    params.hb().g(c.class);
    if (parama != null) {
      parama.booleanValue();
    }
    AppMethodBeat.o(198261);
    throw null;
  }
  
  public final bk<?> a(boolean paramBoolean, bl parambl)
  {
    AppMethodBeat.i(198345);
    androidx.camera.core.impl.ac localac = parambl.a(bl.a.NO);
    parambl = localac;
    if (paramBoolean) {
      parambl = ac.-CC.a(localac, c.iU());
    }
    if (parambl == null)
    {
      AppMethodBeat.o(198345);
      return null;
    }
    parambl = b.e(parambl).iT();
    AppMethodBeat.o(198345);
    return parambl;
  }
  
  protected final Size d(Size paramSize)
  {
    AppMethodBeat.i(198368);
    androidx.camera.core.impl.ah localah = (androidx.camera.core.impl.ah)this.JI;
    d(a(gV(), localah, paramSize).ky());
    AppMethodBeat.o(198368);
    return paramSize;
  }
  
  public final bk.a<?, ?, ?> d(androidx.camera.core.impl.ac paramac)
  {
    AppMethodBeat.i(369503);
    paramac = b.e(paramac);
    AppMethodBeat.o(369503);
    return paramac;
  }
  
  public final void iQ()
  {
    AppMethodBeat.i(198270);
    iN();
    AppMethodBeat.o(198270);
    throw null;
  }
  
  public final void iR()
  {
    throw null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198265);
    String str = "ImageAnalysis:" + getName();
    AppMethodBeat.o(198265);
    return str;
  }
  
  public static final class b
    implements bk.a<ab, androidx.camera.core.impl.ah, b>
  {
    final at He;
    
    public b()
    {
      this(at.ku());
      AppMethodBeat.i(198339);
      AppMethodBeat.o(198339);
    }
    
    private b(at paramat)
    {
      AppMethodBeat.i(198350);
      this.He = paramat;
      paramat = (Class)paramat.b(androidx.camera.core.a.f.Qo, null);
      if ((paramat != null) && (!paramat.equals(ab.class)))
      {
        paramat = new IllegalArgumentException("Invalid target class configuration for " + this + ": " + paramat);
        AppMethodBeat.o(198350);
        throw paramat;
      }
      this.He.c(bk.Qo, ab.class);
      if (this.He.b(bk.Qn, null) == null)
      {
        paramat = ab.class.getCanonicalName() + "-" + UUID.randomUUID();
        this.He.c(bk.Qn, paramat);
      }
      AppMethodBeat.o(198350);
    }
    
    static b e(androidx.camera.core.impl.ac paramac)
    {
      AppMethodBeat.i(198356);
      paramac = new b(at.k(paramac));
      AppMethodBeat.o(198356);
      return paramac;
    }
    
    public final androidx.camera.core.impl.as fU()
    {
      return this.He;
    }
    
    public final androidx.camera.core.impl.ah iS()
    {
      AppMethodBeat.i(198371);
      androidx.camera.core.impl.ah localah = new androidx.camera.core.impl.ah(av.l(this.He));
      AppMethodBeat.o(198371);
      return localah;
    }
  }
  
  public static final class c
  {
    private static final Size Hu;
    private static final androidx.camera.core.impl.ah Hv;
    
    static
    {
      AppMethodBeat.i(198331);
      Hu = new Size(640, 480);
      ab.b localb = new ab.b();
      Size localSize = Hu;
      localb.He.c(al.ML, localSize);
      localb.He.c(bk.NJ, Integer.valueOf(1));
      localb.He.c(al.MI, Integer.valueOf(0));
      Hv = localb.iS();
      AppMethodBeat.o(198331);
    }
    
    public static androidx.camera.core.impl.ah iU()
    {
      return Hv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.ab
 * JD-Core Version:    0.7.0.1
 */