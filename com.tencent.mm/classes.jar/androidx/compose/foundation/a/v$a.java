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

@Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k=3, mv={1, 5, 1}, xi=48)
final class v$a
  extends k
  implements q<l, e, d<? super ah>, Object>
{
  int label;
  
  v$a(d<? super a> paramd)
  {
    super(3, paramd);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(204118);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(204118);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = ah.aiuX;
    AppMethodBeat.o(204118);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.foundation.a.v.a
 * JD-Core Version:    0.7.0.1
 */