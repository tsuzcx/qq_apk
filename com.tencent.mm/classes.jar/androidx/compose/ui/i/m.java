package androidx.compose.ui.i;

import androidx.compose.ui.e.b.a.a;
import androidx.compose.ui.e.b.c;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.x;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/ModifiedDrawNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/node/OwnerScope;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "drawModifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/draw/DrawModifier;)V", "buildCacheParams", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "cacheDrawModifier", "Landroidx/compose/ui/draw/DrawCacheModifier;", "invalidateCache", "", "isValid", "()Z", "value", "modifier", "getModifier", "()Landroidx/compose/ui/draw/DrawModifier;", "setModifier", "(Landroidx/compose/ui/draw/DrawModifier;)V", "updateCache", "Lkotlin/Function0;", "", "onMeasureResultChanged", "width", "", "height", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "updateCacheDrawModifier", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends b<androidx.compose.ui.b.h>
{
  public static final m.a aPK;
  private static final kotlin.g.a.b<m, ah> aPP;
  private androidx.compose.ui.b.f aPL;
  private final androidx.compose.ui.b.b aPM;
  private boolean aPN;
  private final kotlin.g.a.a<ah> aPO;
  
  static
  {
    AppMethodBeat.i(204506);
    aPK = new m.a((byte)0);
    aPP = (kotlin.g.a.b)b.aPQ;
    AppMethodBeat.o(204506);
  }
  
  public m(j paramj, androidx.compose.ui.b.h paramh)
  {
    super(paramj, (f.c)paramh);
    AppMethodBeat.i(204470);
    this.aPL = ye();
    this.aPM = ((androidx.compose.ui.b.b)new c(this));
    this.aPN = true;
    this.aPO = ((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(204470);
  }
  
  private final androidx.compose.ui.b.f ye()
  {
    AppMethodBeat.i(204477);
    Object localObject = (androidx.compose.ui.b.h)super.wb();
    if ((localObject instanceof androidx.compose.ui.b.f))
    {
      localObject = (androidx.compose.ui.b.f)localObject;
      AppMethodBeat.o(204477);
      return localObject;
    }
    AppMethodBeat.o(204477);
    return null;
  }
  
  protected final void ae(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204513);
    super.ae(paramInt1, paramInt2);
    this.aPN = true;
    AppMethodBeat.o(204513);
  }
  
  protected final void c(androidx.compose.ui.e.u paramu)
  {
    AppMethodBeat.i(204520);
    s.u(paramu, "canvas");
    long l1 = androidx.compose.ui.n.m.bl(this.aMV);
    if ((this.aPL != null) && (this.aPN)) {
      i.q(this.aOb).getSnapshotObserver().a((z)this, aPP, this.aPO);
    }
    h localh = this.aOb.aOv;
    Object localObject = this.aNN;
    j localj = h.a(localh);
    h.a(localh, (j)localObject);
    androidx.compose.ui.e.b.a locala = h.b(localh);
    d locald = (d)((j)localObject).xh();
    n localn2 = ((j)localObject).xh().getLayoutDirection();
    a.a locala1 = locala.aAj;
    localObject = locala1.TD;
    n localn1 = locala1.agm;
    androidx.compose.ui.e.u localu = locala1.XT;
    long l2 = locala1.size;
    locala1 = locala.aAj;
    locala1.setDensity(locald);
    locala1.setLayoutDirection(localn2);
    locala1.b(paramu);
    locala1.size = l1;
    paramu.sz();
    ((androidx.compose.ui.b.h)super.wb()).a((c)localh);
    paramu.restore();
    paramu = locala.aAj;
    paramu.setDensity((d)localObject);
    paramu.setLayoutDirection(localn1);
    paramu.b(localu);
    paramu.size = l2;
    h.a(localh, localj);
    AppMethodBeat.o(204520);
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(204524);
    boolean bool = isAttached();
    AppMethodBeat.o(204524);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "modifiedDrawNode", "Landroidx/compose/ui/node/ModifiedDrawNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<m, ah>
  {
    public static final b aPQ;
    
    static
    {
      AppMethodBeat.i(204687);
      aPQ = new b();
      AppMethodBeat.o(204687);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/node/ModifiedDrawNode$buildCacheParams$1", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements androidx.compose.ui.b.b
  {
    private final d TD;
    
    c(m paramm)
    {
      AppMethodBeat.i(204685);
      this.TD = this.aPR.aOb.TD;
      AppMethodBeat.o(204685);
    }
    
    public final d getDensity()
    {
      return this.TD;
    }
    
    public final n getLayoutDirection()
    {
      return this.aPR.aOb.agm;
    }
    
    public final long sf()
    {
      AppMethodBeat.i(204695);
      long l = androidx.compose.ui.n.m.bl(m.a(this.aPR));
      AppMethodBeat.o(204695);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.m
 * JD-Core Version:    0.7.0.1
 */