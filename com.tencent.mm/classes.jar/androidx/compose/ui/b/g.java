package androidx.compose.ui.b;

import androidx.compose.ui.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/draw/DrawContentCacheModifier;", "Landroidx/compose/ui/draw/DrawCacheModifier;", "cacheDrawScope", "Landroidx/compose/ui/draw/CacheDrawScope;", "onBuildDrawCache", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/draw/CacheDrawScope;Lkotlin/jvm/functions/Function1;)V", "getCacheDrawScope", "()Landroidx/compose/ui/draw/CacheDrawScope;", "getOnBuildDrawCache", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "onBuildCache", "", "params", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g
  implements f
{
  private final c aup;
  private final kotlin.g.a.b<c, j> auq;
  
  public g(c paramc, kotlin.g.a.b<? super c, j> paramb)
  {
    AppMethodBeat.i(204836);
    this.aup = paramc;
    this.auq = paramb;
    AppMethodBeat.o(204836);
  }
  
  public final androidx.compose.ui.f a(androidx.compose.ui.f paramf)
  {
    AppMethodBeat.i(204887);
    f localf = (f)this;
    s.u(localf, "this");
    s.u(paramf, "other");
    paramf = h.a.a((h)localf, paramf);
    AppMethodBeat.o(204887);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(204867);
    f localf = (f)this;
    s.u(localf, "this");
    s.u(paramm, "operation");
    paramR = h.a.a((h)localf, paramR, paramm);
    AppMethodBeat.o(204867);
    return paramR;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(204841);
    s.u(paramb, "params");
    c localc = this.aup;
    s.u(paramb, "<set-?>");
    localc.aum = paramb;
    localc.aun = null;
    this.auq.invoke(localc);
    if (localc.aun == null)
    {
      paramb = (Throwable)new IllegalStateException("DrawResult not defined, did you forget to call onDraw?".toString());
      AppMethodBeat.o(204841);
      throw paramb;
    }
    AppMethodBeat.o(204841);
  }
  
  public final void a(androidx.compose.ui.e.b.c paramc)
  {
    AppMethodBeat.i(204845);
    s.u(paramc, "<this>");
    j localj = this.aup.aun;
    s.checkNotNull(localj);
    localj.auu.invoke(paramc);
    AppMethodBeat.o(204845);
  }
  
  public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(204883);
    f localf = (f)this;
    s.u(localf, "this");
    s.u(paramb, "predicate");
    boolean bool = h.a.a((h)localf, paramb);
    AppMethodBeat.o(204883);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(204875);
    f localf = (f)this;
    s.u(localf, "this");
    s.u(paramm, "operation");
    paramR = h.a.b((h)localf, paramR, paramm);
    AppMethodBeat.o(204875);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204853);
    if (this == paramObject)
    {
      AppMethodBeat.o(204853);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(204853);
      return false;
    }
    if (!s.p(this.aup, ((g)paramObject).aup))
    {
      AppMethodBeat.o(204853);
      return false;
    }
    if (!s.p(this.auq, ((g)paramObject).auq))
    {
      AppMethodBeat.o(204853);
      return false;
    }
    AppMethodBeat.o(204853);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204858);
    int i = this.aup.hashCode();
    int j = this.auq.hashCode();
    AppMethodBeat.o(204858);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204893);
    String str = "DrawContentCacheModifier(cacheDrawScope=" + this.aup + ", onBuildDrawCache=" + this.auq + ')';
    AppMethodBeat.o(204893);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.b.g
 * JD-Core Version:    0.7.0.1
 */