package androidx.compose.foundation.b;

import androidx.compose.runtime.an;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
public final class h$a
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  public h$a(c paramc, an<Boolean> paraman, d<? super a> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(203580);
    paramObject = (d)new a(this.abJ, this.abK, paramd);
    AppMethodBeat.o(203580);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(203575);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(203575);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      Object localObject = (List)new ArrayList();
      paramObject = this.abJ.mr();
      localObject = (h)new a((List)localObject, this.abK);
      d locald = (d)this;
      this.label = 1;
      if (paramObject.a((h)localObject, locald) == locala)
      {
        AppMethodBeat.o(203575);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(203575);
    return paramObject;
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements h<b>
  {
    public a(List paramList, an paraman) {}
    
    public final Object a(b paramb, d<? super ah> paramd)
    {
      AppMethodBeat.i(203569);
      paramb = (b)paramb;
      if ((paramb instanceof g.b))
      {
        this.abL.add(paramb);
        paramb = this.abM;
        if (((Collection)this.abL).isEmpty()) {
          break label125;
        }
      }
      label125:
      for (boolean bool = true;; bool = false)
      {
        paramb.setValue(Boolean.valueOf(bool));
        paramb = ah.aiuX;
        AppMethodBeat.o(203569);
        return paramb;
        if ((paramb instanceof g.c))
        {
          this.abL.remove(((g.c)paramb).abH);
          break;
        }
        if (!(paramb instanceof g.a)) {
          break;
        }
        this.abL.remove(((g.a)paramb).abH);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.b.h.a
 * JD-Core Version:    0.7.0.1
 */