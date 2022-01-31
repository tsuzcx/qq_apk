package a.j.b.a.c.b.c;

import a.f.a.a;
import a.f.b.j;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.aq;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.d;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.t.a;
import a.j.b.a.c.f.f;
import a.j.b.a.c.k.i;
import a.j.b.a.c.l.au;
import a.j.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag
  extends p
  implements af
{
  public static final ag.a Cbe;
  final i BRT;
  private final a.j.b.a.c.k.g Cbb;
  private d Cbc;
  final aq Cbd;
  
  static
  {
    AppMethodBeat.i(119592);
    eOJ = new k[] { (k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(ag.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;")) };
    Cbe = new ag.a((byte)0);
    AppMethodBeat.o(119592);
  }
  
  private ag(i parami, aq paramaq, d paramd, af paramaf, a.j.b.a.c.b.a.g paramg, b.a parama, am paramam)
  {
    super((l)paramaq, (a.j.b.a.c.b.t)paramaf, paramg, f.ayV("<init>"), parama, paramam);
    AppMethodBeat.i(119608);
    this.BRT = parami;
    this.Cbd = paramaq;
    this.BZK = this.Cbd.ecK();
    this.Cbb = this.BRT.m((a)new ag.b(this, paramd));
    this.Cbc = paramd;
    AppMethodBeat.o(119608);
  }
  
  private af d(l paraml, a.j.b.a.c.b.w paramw, az paramaz, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(119604);
    j.q(paraml, "newOwner");
    j.q(paramw, "modality");
    j.q(paramaz, "visibility");
    j.q(parama, "kind");
    paraml = edV().g(paraml).a(paramw).a(paramaz).a(parama).sn(paramBoolean).eeb();
    if (paraml == null)
    {
      paraml = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
      AppMethodBeat.o(119604);
      throw paraml;
    }
    paraml = (af)paraml;
    AppMethodBeat.o(119604);
    return paraml;
  }
  
  private af efl()
  {
    AppMethodBeat.i(119594);
    Object localObject = super.edO();
    if (localObject == null)
    {
      localObject = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
      AppMethodBeat.o(119594);
      throw ((Throwable)localObject);
    }
    localObject = (af)localObject;
    AppMethodBeat.o(119594);
    return localObject;
  }
  
  private af i(au paramau)
  {
    AppMethodBeat.i(119600);
    j.q(paramau, "substitutor");
    paramau = super.c(paramau);
    if (paramau == null)
    {
      paramau = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
      AppMethodBeat.o(119600);
      throw paramau;
    }
    paramau = (ag)paramau;
    Object localObject = au.aw(paramau.eds());
    j.p(localObject, "TypeSubstitutor.create(s…asConstructor.returnType)");
    localObject = this.Cbc.edI().a((au)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(119600);
      return null;
    }
    paramau.Cbc = ((d)localObject);
    paramau = (af)paramau;
    AppMethodBeat.o(119600);
    return paramau;
  }
  
  public final a.j.b.a.c.l.w eds()
  {
    AppMethodBeat.i(119593);
    a.j.b.a.c.l.w localw = super.eds();
    if (localw == null) {
      j.ebi();
    }
    AppMethodBeat.o(119593);
    return localw;
  }
  
  public final d efk()
  {
    return this.Cbc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.b.c.ag
 * JD-Core Version:    0.7.0.1
 */