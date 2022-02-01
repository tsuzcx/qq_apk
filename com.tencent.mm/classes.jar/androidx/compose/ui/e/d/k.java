package androidx.compose.ui.e.d;

import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.af;
import androidx.compose.ui.e.b.a.a;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.e.b.e.b;
import androidx.compose.ui.e.p;
import androidx.compose.ui.e.z;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.l;
import androidx.compose.ui.n.m;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/VectorComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "cacheDrawScope", "Landroidx/compose/ui/graphics/vector/DrawCache;", "drawVectorBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "intrinsicColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "invalidateCallback", "Lkotlin/Function0;", "getInvalidateCallback$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateCallback$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "isDirty", "", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "previousDrawSize", "Landroidx/compose/ui/geometry/Size;", "J", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "getRoot", "()Landroidx/compose/ui/graphics/vector/GroupComponent;", "", "viewportHeight", "getViewportHeight", "()F", "setViewportHeight", "(F)V", "viewportWidth", "getViewportWidth", "setViewportWidth", "doInvalidate", "toString", "draw", "alpha", "colorFilter", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends i
{
  float aBa;
  float aBb;
  final c aCe;
  private boolean aCf;
  private final b aCg;
  kotlin.g.a.a<kotlin.ah> aCh;
  aa aCi;
  private long aCj;
  private final kotlin.g.a.b<e, kotlin.ah> aCk;
  
  public k()
  {
    super((byte)0);
    AppMethodBeat.i(206410);
    Object localObject = new c();
    ((c)localObject).setPivotX(0.0F);
    ((c)localObject).setPivotY(0.0F);
    ((c)localObject).i((kotlin.g.a.a)new k.c(this));
    kotlin.ah localah = kotlin.ah.aiuX;
    this.aCe = ((c)localObject);
    this.aCf = true;
    this.aCg = new b();
    this.aCh = ((kotlin.g.a.a)k.b.aCm);
    localObject = androidx.compose.ui.d.k.avA;
    this.aCj = androidx.compose.ui.d.k.sw();
    this.aCk = ((kotlin.g.a.b)new a(this));
    AppMethodBeat.o(206410);
  }
  
  public final void a(e parame, float paramFloat, aa paramaa)
  {
    AppMethodBeat.i(206429);
    s.u(parame, "<this>");
    Object localObject2;
    Object localObject1;
    if (paramaa != null)
    {
      if ((this.aCf) || (!androidx.compose.ui.d.k.e(this.aCj, parame.sf())))
      {
        this.aCe.setScaleX(androidx.compose.ui.d.k.Q(parame.sf()) / this.aBa);
        this.aCe.setScaleY(androidx.compose.ui.d.k.R(parame.sf()) / this.aBb);
        Object localObject6 = this.aCg;
        long l1 = m.an((int)(float)Math.ceil(androidx.compose.ui.d.k.Q(parame.sf())), (int)(float)Math.ceil(androidx.compose.ui.d.k.R(parame.sf())));
        Object localObject4 = (d)parame;
        Object localObject5 = parame.getLayoutDirection();
        kotlin.g.a.b localb = this.aCk;
        s.u(localObject4, "density");
        s.u(localObject5, "layoutDirection");
        s.u(localb, "block");
        ((b)localObject6).aAL = ((d)localObject4);
        ((b)localObject6).agm = ((n)localObject5);
        Object localObject3 = ((b)localObject6).aAJ;
        localObject2 = ((b)localObject6).aAK;
        if ((localObject3 != null) && (localObject2 != null) && (l.bi(l1) <= ((af)localObject3).getWidth()))
        {
          localObject1 = localObject3;
          if (l.bj(l1) <= ((af)localObject3).getHeight()) {}
        }
        else
        {
          localObject1 = androidx.compose.ui.e.ah.Z(l.bi(l1), l.bj(l1));
          s.u(localObject1, "image");
          localObject2 = androidx.compose.ui.e.c.a((af)localObject1);
          ((b)localObject6).aAJ = ((af)localObject1);
          ((b)localObject6).aAK = ((androidx.compose.ui.e.u)localObject2);
        }
        ((b)localObject6).size = l1;
        androidx.compose.ui.e.b.a locala = ((b)localObject6).aAM;
        long l2 = m.bl(l1);
        a.a locala1 = locala.aAj;
        localObject3 = locala1.TD;
        localObject6 = locala1.agm;
        androidx.compose.ui.e.u localu = locala1.XT;
        l1 = locala1.size;
        locala1 = locala.aAj;
        locala1.setDensity((d)localObject4);
        locala1.setLayoutDirection((n)localObject5);
        locala1.b((androidx.compose.ui.e.u)localObject2);
        locala1.size = l2;
        ((androidx.compose.ui.e.u)localObject2).sz();
        localObject4 = (e)locala;
        localObject5 = z.awK;
        l2 = z.tv();
        localObject5 = p.avT;
        e.b.a((e)localObject4, l2, 0L, 0L, 0.0F, null, null, p.sR(), 62);
        localb.invoke(localObject4);
        ((androidx.compose.ui.e.u)localObject2).restore();
        localObject2 = locala.aAj;
        ((a.a)localObject2).setDensity((d)localObject3);
        ((a.a)localObject2).setLayoutDirection((n)localObject6);
        ((a.a)localObject2).b(localu);
        ((a.a)localObject2).size = l1;
        ((af)localObject1).sD();
        this.aCf = false;
        this.aCj = parame.sf();
      }
      localObject1 = this.aCg;
      s.u(parame, "target");
      localObject2 = ((b)localObject1).aAJ;
      if (localObject2 == null) {
        break label554;
      }
    }
    label554:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label560;
      }
      parame = (Throwable)new IllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination".toString());
      AppMethodBeat.o(206429);
      throw parame;
      paramaa = this.aCi;
      break;
    }
    label560:
    e.b.a(parame, (af)localObject2, 0L, ((b)localObject1).size, 0L, 0L, paramFloat, null, paramaa, 0, 346);
    AppMethodBeat.o(206429);
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(206434);
    s.u(parame, "<this>");
    a(parame, 1.0F, null);
    AppMethodBeat.o(206434);
  }
  
  final void doInvalidate()
  {
    AppMethodBeat.i(206420);
    this.aCf = true;
    this.aCh.invoke();
    AppMethodBeat.o(206420);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206436);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Params: ");
    ((StringBuilder)localObject).append("\tname: ").append(this.aCe.name).append("\n");
    ((StringBuilder)localObject).append("\tviewportWidth: ").append(this.aBa).append("\n");
    ((StringBuilder)localObject).append("\tviewportHeight: ").append(this.aBb).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(206436);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<e, kotlin.ah>
  {
    a(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.k
 * JD-Core Version:    0.7.0.1
 */