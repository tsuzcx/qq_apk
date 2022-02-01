package com.tencent.mm.plugin.finder.feed.component;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class f$d$b$1
  extends kotlin.d.b.a.k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  f$d$b$1(f.b paramb, f.d paramd, View paramView, com.tencent.mm.plugin.finder.feed.jumper.k paramk, d<? super 1> paramd1)
  {
    super(2, paramd1);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(364005);
    paramObject = (d)new 1(this.Bcr, this.Bcs, this.$view, this.Bcp, paramd);
    AppMethodBeat.o(364005);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(363998);
    Object localObject = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(363998);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = this.Bcr;
    localObject = this.Bcs.AUZ;
    j localj = this.Bcs.AIz;
    View localView = this.$view;
    kotlin.g.b.s.s(localView, "view");
    paramObject.a((BaseFinderFeed)localObject, localj, localView, this.Bcp, this.Bcs.source);
    paramObject = this.Bcr.Bcm;
    if (paramObject != null) {
      paramObject.a(this.Bcp);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(363998);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.f.d.b.1
 * JD-Core Version:    0.7.0.1
 */