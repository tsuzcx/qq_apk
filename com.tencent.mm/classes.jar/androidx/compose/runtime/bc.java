package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/SkippableUpdater;", "T", "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/Composer;)I", "toString", "", "toString-impl", "(Landroidx/compose/runtime/Composer;)Ljava/lang/String;", "update", "", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Lkotlin/ExtensionFunctionType;", "update-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bc<T>
{
  public final h apA;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201950);
    h localh = this.apA;
    if (!(paramObject instanceof bc))
    {
      AppMethodBeat.o(201950);
      return false;
    }
    if (!s.p(localh, ((bc)paramObject).apA))
    {
      AppMethodBeat.o(201950);
      return false;
    }
    AppMethodBeat.o(201950);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(201946);
    int i = this.apA.hashCode();
    AppMethodBeat.o(201946);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201942);
    Object localObject = this.apA;
    localObject = "SkippableUpdater(composer=" + localObject + ')';
    AppMethodBeat.o(201942);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.bc
 * JD-Core Version:    0.7.0.1
 */