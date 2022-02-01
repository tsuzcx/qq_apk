package androidx.compose.foundation.a;

import androidx.compose.ui.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.q;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k=3, mv={1, 5, 1}, xi=48)
final class g$e
  extends k
  implements q<aq, e, d<? super ah>, Object>
{
  int label;
  
  g$e(d<? super e> paramd)
  {
    super(3, paramd);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(204143);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(204143);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = ah.aiuX;
    AppMethodBeat.o(204143);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.foundation.a.g.e
 * JD-Core Version:    0.7.0.1
 */