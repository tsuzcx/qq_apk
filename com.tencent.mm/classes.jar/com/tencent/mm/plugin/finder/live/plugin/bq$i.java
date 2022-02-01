package com.tencent.mm.plugin.finder.live.plugin;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.b;
import com.tencent.mm.plugin.finder.live.sidebar.c;
import com.tencent.mm.ui.component.k.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class bq$i
  extends kotlin.d.b.a.k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  bq$i(bq parambq, b paramb, kotlin.d.d<? super i> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(371365);
    paramObject = (kotlin.d.d)new i(this.DhT, this.akfi, paramd);
    AppMethodBeat.o(371365);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(371364);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(371364);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (f)bg.kCi();
      m localm = (m)new kotlin.d.b.a.k(this.akfi, this.DhT)
      {
        int label;
        
        public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
        {
          AppMethodBeat.i(371358);
          paramAnonymousObject = (kotlin.d.d)new 1(this.akfi, this.DhT, paramAnonymousd);
          AppMethodBeat.o(371358);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(371356);
          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(371356);
            throw paramAnonymousObject;
          }
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = p.al(new b[] { this.akfi });
          bq.a(this.DhT, paramAnonymousObject);
          bq.a(this.DhT, (List)paramAnonymousObject);
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(371356);
          return paramAnonymousObject;
        }
      };
      kotlin.d.d locald = (kotlin.d.d)this;
      this.label = 1;
      if (l.a(paramObject, localm, locald) == locala)
      {
        AppMethodBeat.o(371364);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    bq.c(this.DhT);
    paramObject = com.tencent.mm.ui.component.k.aeZF;
    paramObject = bq.d(this.DhT).getContext();
    s.s(paramObject, "entranceRoot.context");
    paramObject = ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE;
    if (paramObject != null) {
      paramObject.e(true, (kotlin.g.a.a)new u(this.DhT) {});
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(371364);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bq.i
 * JD-Core Version:    0.7.0.1
 */