package androidx.compose.b;

import androidx.compose.ui.g.c.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
final class q$b
  extends k
  implements m<u, d<? super ah>, Object>
{
  int label;
  
  q$b(d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(201694);
    paramObject = (d)new b(paramd);
    AppMethodBeat.o(201694);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(201689);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(201689);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = ah.aiuX;
    AppMethodBeat.o(201689);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.b.q.b
 * JD-Core Version:    0.7.0.1
 */