package androidx.compose.runtime;

import androidx.compose.runtime.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/Invalidation;", "", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "location", "", "instances", "Landroidx/compose/runtime/collection/IdentityArraySet;", "(Landroidx/compose/runtime/RecomposeScopeImpl;ILandroidx/compose/runtime/collection/IdentityArraySet;)V", "getInstances", "()Landroidx/compose/runtime/collection/IdentityArraySet;", "setInstances", "(Landroidx/compose/runtime/collection/IdentityArraySet;)V", "getLocation", "()I", "getScope", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "isInvalid", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ae
{
  final av aoe;
  c<Object> aof;
  final int location;
  
  public ae(av paramav, int paramInt, c<Object> paramc)
  {
    AppMethodBeat.i(201867);
    this.aoe = paramav;
    this.location = paramInt;
    this.aof = paramc;
    AppMethodBeat.o(201867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.ae
 * JD-Core Version:    0.7.0.1
 */