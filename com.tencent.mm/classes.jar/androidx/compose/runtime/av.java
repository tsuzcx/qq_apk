package androidx.compose.runtime;

import androidx.compose.runtime.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "block", "Lkotlin/Function2;", "Landroidx/compose/runtime/Composer;", "", "", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "setComposition", "currentToken", "value", "", "defaultsInScope", "getDefaultsInScope", "()Z", "setDefaultsInScope", "(Z)V", "defaultsInvalid", "getDefaultsInvalid", "setDefaultsInvalid", "flags", "requiresRecompose", "getRequiresRecompose", "setRequiresRecompose", "rereading", "getRereading", "setRereading", "skipped", "getSkipped$runtime_release", "setSkipped", "trackedDependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/DerivedState;", "", "trackedInstances", "Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "used", "getUsed", "setUsed", "valid", "getValid", "compose", "composer", "end", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "token", "invalidate", "invalidateForResult", "Landroidx/compose/runtime/InvalidationResult;", "isInvalidFor", "instances", "Landroidx/compose/runtime/collection/IdentityArraySet;", "recordRead", "instance", "rereadTrackedInstances", "scopeSkipped", "start", "updateScope", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  implements au, ba
{
  n aoI;
  public c aoJ;
  m<? super h, ? super Integer, ah> aoK;
  int aoL;
  a aoM;
  androidx.compose.runtime.a.b<v<?>, Object> aoN;
  int flags;
  
  public av(n paramn)
  {
    this.aoI = paramn;
  }
  
  private final void ar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags |= 0x20;
      return;
    }
    this.flags &= 0xFFFFFFDF;
  }
  
  public final af O(Object paramObject)
  {
    AppMethodBeat.i(201947);
    n localn = this.aoI;
    if (localn == null) {}
    for (paramObject = null; paramObject == null; paramObject = localn.a(this, paramObject))
    {
      paramObject = af.aog;
      AppMethodBeat.o(201947);
      return paramObject;
    }
    AppMethodBeat.o(201947);
    return paramObject;
  }
  
  public final void ap(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags |= 0x4;
      return;
    }
    this.flags &= 0xFFFFFFFB;
  }
  
  public final void aq(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags |= 0x8;
      return;
    }
    this.flags &= 0xFFFFFFF7;
  }
  
  final void as(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags |= 0x10;
      return;
    }
    this.flags &= 0xFFFFFFEF;
  }
  
  public final void b(m<? super h, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(201956);
    s.u(paramm, "block");
    this.aoK = paramm;
    AppMethodBeat.o(201956);
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(201952);
    n localn = this.aoI;
    if (localn != null) {
      localn.a(this, null);
    }
    AppMethodBeat.o(201952);
  }
  
  public final boolean nS()
  {
    AppMethodBeat.i(201931);
    if (this.aoI != null)
    {
      c localc = this.aoJ;
      if (localc == null) {}
      for (boolean bool = false; bool; bool = localc.nS())
      {
        AppMethodBeat.o(201931);
        return true;
      }
    }
    AppMethodBeat.o(201931);
    return false;
  }
  
  public final boolean pA()
  {
    return (this.flags & 0x1) != 0;
  }
  
  public final void pB()
  {
    this.flags |= 0x1;
  }
  
  public final boolean pC()
  {
    return (this.flags & 0x10) != 0;
  }
  
  public final void pD()
  {
    AppMethodBeat.i(201970);
    Object localObject1 = this.aoI;
    a locala;
    if (localObject1 != null)
    {
      locala = this.aoM;
      if (locala != null) {
        ar(true);
      }
    }
    for (;;)
    {
      int k;
      int j;
      Object localObject3;
      try
      {
        k = locala.size;
        if (k <= 0) {
          break label108;
        }
        i = 0;
        j = i + 1;
        localObject3 = locala.aqk[i];
        if (localObject3 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Any");
          AppMethodBeat.o(201970);
          throw ((Throwable)localObject1);
        }
      }
      finally
      {
        ar(false);
        AppMethodBeat.o(201970);
      }
      localObject2.J(localObject3);
      if (j >= k)
      {
        label108:
        ar(false);
        AppMethodBeat.o(201970);
        return;
        AppMethodBeat.o(201970);
        return;
      }
      int i = j;
    }
  }
  
  public final void start(int paramInt)
  {
    AppMethodBeat.i(201967);
    this.aoL = paramInt;
    as(false);
    AppMethodBeat.o(201967);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "composition", "Landroidx/compose/runtime/Composition;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<k, ah>
  {
    a(av paramav, int paramInt, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.av
 * JD-Core Version:    0.7.0.1
 */