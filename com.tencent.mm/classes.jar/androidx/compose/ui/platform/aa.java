package androidx.compose.ui.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f.b;
import kotlin.d.f.c;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onInfiniteOperation", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Key", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface aa
  extends f.b
{
  public static final a aUk = a.aUl;
  
  public abstract <R> Object zg();
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/InfiniteAnimationPolicy$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", "()V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements f.c<aa>
  {
    static
    {
      AppMethodBeat.i(206560);
      aUl = new a();
      AppMethodBeat.o(206560);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.platform.aa
 * JD-Core Version:    0.7.0.1
 */