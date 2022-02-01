package com.tencent.mm.aj.c;

import androidx.compose.a.a.g;
import androidx.compose.foundation.a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/widget/ScrollableTabData;", "", "scrollState", "Landroidx/compose/foundation/ScrollState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/foundation/ScrollState;Lkotlinx/coroutines/CoroutineScope;)V", "selectedTab", "", "Ljava/lang/Integer;", "onLaidOut", "", "density", "Landroidx/compose/ui/unit/Density;", "edgeOffset", "tabPositions", "", "Lcom/tencent/mm/mm_compose/widget/TabPosition;", "calculateTabOffset", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b
{
  final aq coroutineScope;
  final androidx.compose.foundation.s ogV;
  Integer ogW;
  
  public b(androidx.compose.foundation.s params, aq paramaq)
  {
    AppMethodBeat.i(238758);
    this.ogV = params;
    this.coroutineScope = paramaq;
    AppMethodBeat.o(238758);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(b paramb, int paramInt, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(238753);
      paramObject = (kotlin.d.d)new a(this.ogX, this.ogY, paramd);
      AppMethodBeat.o(238753);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(238748);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(238748);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.ogX.ogV;
        int i = this.ogY;
        Object localObject = d.byX();
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        localObject = o.a((androidx.compose.foundation.a.s)paramObject, i - paramObject.getValue(), (g)localObject, locald);
        paramObject = localObject;
        if (localObject != a.aiwj) {
          paramObject = ah.aiuX;
        }
        if (paramObject == locala)
        {
          AppMethodBeat.o(238748);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(238748);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c.b
 * JD-Core Version:    0.7.0.1
 */