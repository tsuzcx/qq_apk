package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"currentComposer", "Landroidx/compose/runtime/Composer;", "getCurrentComposer", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/Composer;", "currentCompositeKeyHash", "", "getCurrentCompositeKeyHash", "(Landroidx/compose/runtime/Composer;I)I", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getCurrentRecomposeScope", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/RecomposeScope;", "ComposeNode", "", "T", "", "E", "Landroidx/compose/runtime/Applier;", "factory", "Lkotlin/Function0;", "update", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Landroidx/compose/runtime/DisallowComposableCalls;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "skippableUpdate", "Landroidx/compose/runtime/SkippableUpdater;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ReusableComposeNode", "ReusableContent", "key", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "invalidApplier", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "remember", "calculation", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key1", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "rememberCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionContext;", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final l m(h paramh)
  {
    AppMethodBeat.i(202351);
    paramh.bx(-1359198498);
    l locall = paramh.ov();
    paramh.od();
    AppMethodBeat.o(202351);
    return locall;
  }
  
  public static final void nW()
  {
    AppMethodBeat.i(202346);
    Throwable localThrowable = (Throwable)new IllegalStateException("Invalid applier".toString());
    AppMethodBeat.o(202346);
    throw localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.g
 * JD-Core Version:    0.7.0.1
 */