package androidx.compose.runtime.c;

import androidx.compose.runtime.au;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.a.t;
import kotlin.g.b.an;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/internal/ComposableLambdaImpl;", "Landroidx/compose/runtime/internal/ComposableLambda;", "key", "", "tracked", "", "(IZ)V", "_block", "", "getKey", "()I", "scope", "Landroidx/compose/runtime/RecomposeScope;", "scopes", "", "invoke", "c", "Landroidx/compose/runtime/Composer;", "changed", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "changed1", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "trackRead", "", "composer", "trackWrite", "update", "block", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  private final boolean arq;
  private Object ars;
  private au art;
  private List<au> aru;
  private final int key;
  
  public b(int paramInt, boolean paramBoolean)
  {
    this.key = paramInt;
    this.arq = paramBoolean;
  }
  
  private final void q(h paramh)
  {
    AppMethodBeat.i(202304);
    au localau;
    int k;
    if (this.arq)
    {
      localau = paramh.ob();
      if (localau != null)
      {
        paramh.a(localau);
        if (c.a(this.art, localau))
        {
          this.art = localau;
          AppMethodBeat.o(202304);
          return;
        }
        paramh = this.aru;
        if (paramh == null)
        {
          paramh = (List)new ArrayList();
          this.aru = paramh;
          paramh.add(localau);
          AppMethodBeat.o(202304);
          return;
        }
        k = paramh.size();
        if (k <= 0) {}
      }
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (c.a((au)paramh.get(i), localau))
      {
        paramh.set(i, localau);
        AppMethodBeat.o(202304);
        return;
      }
      if (j >= k)
      {
        paramh.add(localau);
        AppMethodBeat.o(202304);
        return;
      }
    }
  }
  
  public final Object a(final Object paramObject1, final Object paramObject2, h paramh, final int paramInt)
  {
    AppMethodBeat.i(202330);
    kotlin.g.b.s.u(paramh, "c");
    paramh = paramh.by(this.key);
    q(paramh);
    if (paramh.G(this)) {}
    for (int i = c.W(2, 2);; i = c.W(1, 2))
    {
      localObject = this.ars;
      if (localObject != null) {
        break;
      }
      paramObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Function4<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
      AppMethodBeat.o(202330);
      throw paramObject1;
    }
    Object localObject = ((r)an.y(localObject, 4)).a(paramObject1, paramObject2, paramh, Integer.valueOf(paramInt | i));
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((m)new b(this, paramObject1, paramObject2, paramInt));
    }
    AppMethodBeat.o(202330);
    return localObject;
  }
  
  public final Object a(final Object paramObject1, final Object paramObject2, final Object paramObject3, h paramh, final int paramInt)
  {
    AppMethodBeat.i(202339);
    kotlin.g.b.s.u(paramh, "c");
    paramh = paramh.by(this.key);
    q(paramh);
    if (paramh.G(this)) {}
    for (int i = c.W(2, 3);; i = c.W(1, 3))
    {
      localObject = this.ars;
      if (localObject != null) {
        break;
      }
      paramObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Function5<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
      AppMethodBeat.o(202339);
      throw paramObject1;
    }
    Object localObject = ((kotlin.g.a.s)an.y(localObject, 5)).a(paramObject1, paramObject2, paramObject3, paramh, Integer.valueOf(paramInt | i));
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((m)new c(this, paramObject1, paramObject2, paramObject3, paramInt));
    }
    AppMethodBeat.o(202339);
    return localObject;
  }
  
  public final Object a(final Object paramObject1, final Object paramObject2, final Object paramObject3, final Object paramObject4, h paramh, final int paramInt)
  {
    AppMethodBeat.i(202347);
    kotlin.g.b.s.u(paramh, "c");
    paramh = paramh.by(this.key);
    q(paramh);
    if (paramh.G(this)) {}
    for (int i = c.W(2, 4);; i = c.W(1, 4))
    {
      localObject = this.ars;
      if (localObject != null) {
        break;
      }
      paramObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Function6<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
      AppMethodBeat.o(202347);
      throw paramObject1;
    }
    Object localObject = ((t)an.y(localObject, 6)).a(paramObject1, paramObject2, paramObject3, paramObject4, paramh, Integer.valueOf(paramInt | i));
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((m)new d(this, paramObject1, paramObject2, paramObject3, paramObject4, paramInt));
    }
    AppMethodBeat.o(202347);
    return localObject;
  }
  
  public final Object a(final Object paramObject1, final Object paramObject2, final Object paramObject3, final Object paramObject4, final Object paramObject5, h paramh, final int paramInt)
  {
    AppMethodBeat.i(202352);
    kotlin.g.b.s.u(paramh, "c");
    paramh = paramh.by(this.key);
    q(paramh);
    if (paramh.G(this)) {}
    for (int i = c.W(2, 5);; i = c.W(1, 5))
    {
      localObject = this.ars;
      if (localObject != null) {
        break;
      }
      paramObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Function7<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
      AppMethodBeat.o(202352);
      throw paramObject1;
    }
    Object localObject = ((kotlin.g.a.u)an.y(localObject, 7)).invoke(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramh, Integer.valueOf(paramInt | i));
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((m)new e(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramInt));
    }
    AppMethodBeat.o(202352);
    return localObject;
  }
  
  public final void ag(Object paramObject)
  {
    int j = 0;
    AppMethodBeat.i(202309);
    kotlin.g.b.s.u(paramObject, "block");
    int k;
    if (!kotlin.g.b.s.p(this.ars, paramObject))
    {
      if (this.ars != null) {
        break label131;
      }
      i = 1;
      this.ars = paramObject;
      if ((i == 0) && (this.arq))
      {
        paramObject = this.art;
        if (paramObject != null)
        {
          paramObject.invalidate();
          this.art = null;
        }
        paramObject = this.aru;
        if (paramObject != null)
        {
          k = paramObject.size();
          if (k <= 0) {}
        }
      }
    }
    for (int i = j;; i = j)
    {
      j = i + 1;
      ((au)paramObject.get(i)).invalidate();
      if (j >= k)
      {
        paramObject.clear();
        AppMethodBeat.o(202309);
        return;
        label131:
        i = 0;
        break;
      }
    }
  }
  
  public final Object d(final Object paramObject, h paramh, final int paramInt)
  {
    AppMethodBeat.i(202321);
    kotlin.g.b.s.u(paramh, "c");
    paramh = paramh.by(this.key);
    q(paramh);
    if (paramh.G(this)) {}
    for (int i = c.W(2, 1);; i = c.W(1, 1))
    {
      localObject = this.ars;
      if (localObject != null) {
        break;
      }
      paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
      AppMethodBeat.o(202321);
      throw paramObject;
    }
    Object localObject = ((q)an.y(localObject, 3)).invoke(paramObject, paramh, Integer.valueOf(paramInt | i));
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((m)new a(this, paramObject, paramInt));
    }
    AppMethodBeat.o(202321);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements m<h, Integer, ah>
  {
    a(b paramb, Object paramObject, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements m<h, Integer, ah>
  {
    b(b paramb, Object paramObject1, Object paramObject2, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements m<h, Integer, ah>
  {
    c(b paramb, Object paramObject1, Object paramObject2, Object paramObject3, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements m<h, Integer, ah>
  {
    d(b paramb, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements m<h, Integer, ah>
  {
    e(b paramb, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.c.b
 * JD-Core Version:    0.7.0.1
 */