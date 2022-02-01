package androidx.compose.ui.e.d;

import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.d;
import androidx.compose.runtime.g;
import androidx.compose.runtime.h;
import androidx.compose.runtime.l;
import androidx.compose.runtime.o;
import androidx.compose.runtime.x;
import androidx.compose.runtime.y;
import androidx.compose.ui.e.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "()V", "composition", "Landroidx/compose/runtime/Composition;", "currentAlpha", "", "currentColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "value", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "<set-?>", "", "isDirty", "()Z", "setDirty", "(Z)V", "isDirty$delegate", "Landroidx/compose/runtime/MutableState;", "size", "getSize-NH-jbRc$ui_release", "setSize-uvyYCjk$ui_release", "(J)V", "size$delegate", "vector", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "RenderVector", "", "name", "", "viewportWidth", "viewportHeight", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "RenderVector$ui_release", "(Ljava/lang/String;FFLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "applyAlpha", "alpha", "applyColorFilter", "colorFilter", "composeVector", "parent", "Landroidx/compose/runtime/CompositionContext;", "composable", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function4;)Landroidx/compose/runtime/Composition;", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends androidx.compose.ui.e.c.c
{
  public static final int Ue = 8;
  public final an aDq;
  final k aDr;
  private androidx.compose.runtime.k aDs;
  private final an aDt;
  private float aDu;
  private androidx.compose.ui.e.aa aDv;
  
  public q()
  {
    AppMethodBeat.i(206386);
    Object localObject1 = androidx.compose.ui.d.k.avA;
    this.aDq = bj.T(androidx.compose.ui.d.k.U(androidx.compose.ui.d.k.su()));
    localObject1 = new k();
    Object localObject2 = (a)new d(this);
    s.u(localObject2, "<set-?>");
    ((k)localObject1).aCh = ((a)localObject2);
    localObject2 = ah.aiuX;
    this.aDr = ((k)localObject1);
    this.aDt = bj.T(Boolean.TRUE);
    this.aDu = 1.0F;
    AppMethodBeat.o(206386);
  }
  
  private final void au(boolean paramBoolean)
  {
    AppMethodBeat.i(206389);
    this.aDt.setValue(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(206389);
  }
  
  public final boolean S(float paramFloat)
  {
    this.aDu = paramFloat;
    return true;
  }
  
  public final void a(final String paramString, final float paramFloat1, final float paramFloat2, final r<? super Float, ? super Float, ? super h, ? super Integer, ah> paramr, h paramh, final int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(206408);
    s.u(paramString, "name");
    s.u(paramr, "content");
    h localh = paramh.by(625569543);
    paramh = this.aDr;
    s.u(paramString, "value");
    paramh.aCe.setName(paramString);
    int i;
    if (paramh.aBa == paramFloat1)
    {
      i = 1;
      if (i == 0)
      {
        paramh.aBa = paramFloat1;
        paramh.doInvalidate();
      }
      i = j;
      if (paramh.aBb == paramFloat2) {
        i = 1;
      }
      if (i == 0)
      {
        paramh.aBb = paramFloat2;
        paramh.doInvalidate();
      }
      l locall = g.m(localh);
      paramh = this.aDs;
      if ((paramh != null) && (!paramh.pb())) {
        break label272;
      }
      paramh = o.a((d)new j((i)this.aDr.aCe), locall);
    }
    label272:
    for (;;)
    {
      this.aDs = paramh;
      paramh.setContent((m)androidx.compose.runtime.c.c.a(-985537011, true, new c(paramr, this)));
      androidx.compose.runtime.aa.a(paramh, (b)new a(paramh), localh);
      paramh = localh.oh();
      if (paramh != null) {
        paramh.b((m)new b(this, paramString, paramFloat1, paramFloat2, paramr, paramInt));
      }
      AppMethodBeat.o(206408);
      return;
      i = 0;
      break;
    }
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(206418);
    s.u(parame, "<this>");
    k localk = this.aDr;
    float f = this.aDu;
    androidx.compose.ui.e.aa localaa2 = this.aDv;
    androidx.compose.ui.e.aa localaa1 = localaa2;
    if (localaa2 == null) {
      localaa1 = localk.aCi;
    }
    localk.a(parame, f, localaa1);
    if (((Boolean)((bm)this.aDt).getValue()).booleanValue()) {
      au(false);
    }
    AppMethodBeat.o(206418);
  }
  
  public final boolean c(androidx.compose.ui.e.aa paramaa)
  {
    this.aDv = paramaa;
    return true;
  }
  
  public final long uM()
  {
    AppMethodBeat.i(206412);
    long l = ((androidx.compose.ui.d.k)((bm)this.aDq).getValue()).avp;
    AppMethodBeat.o(206412);
    return l;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<y, x>
  {
    a(androidx.compose.runtime.k paramk)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(androidx.compose.runtime.k paramk) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(206363);
        this.aDx.dispose();
        AppMethodBeat.o(206363);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<h, Integer, ah>
  {
    b(q paramq, String paramString, float paramFloat1, float paramFloat2, r<? super Float, ? super Float, ? super h, ? super Integer, ah> paramr, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<h, Integer, ah>
  {
    c(r<? super Float, ? super Float, ? super h, ? super Integer, ah> paramr, q paramq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.q
 * JD-Core Version:    0.7.0.1
 */