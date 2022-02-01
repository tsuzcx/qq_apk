package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$j
  extends k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  Object L$0;
  int aai;
  int label;
  
  c$j(com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.d paramd, WxRecyclerView paramWxRecyclerView, c paramc, kotlin.d.d<? super j> paramd1)
  {
    super(2, paramd1);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(370536);
    paramObject = (kotlin.d.d)new j(this.ENM, this.EOc, this.ENL, paramd);
    AppMethodBeat.o(370536);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(370532);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    int i;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(370532);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      if (this.ENM.EML.size() <= 1)
      {
        Log.i("BigBannerListConvert", "#onBindViewHolder auto switch card. oh, you don't need it");
        paramObject = ah.aiuX;
        AppMethodBeat.o(370532);
        return paramObject;
      }
      paramObject = this.EOc.getLayoutManager();
      if ((paramObject == null) || (!(paramObject instanceof StaggeredGridLayoutManager)))
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(370532);
        return paramObject;
      }
      i = c.a((StaggeredGridLayoutManager)paramObject);
    }
    Object localObject;
    for (;;)
    {
      localObject = (kotlin.d.d)this;
      this.L$0 = paramObject;
      this.aai = i;
      this.label = 1;
      j = i;
      if (bb.e(3000L, (kotlin.d.d)localObject) == locala)
      {
        AppMethodBeat.o(370532);
        return locala;
        j = this.aai;
        localObject = (RecyclerView.LayoutManager)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      i = c.a((StaggeredGridLayoutManager)paramObject);
      if (j == i) {
        break;
      }
      Log.i("BigBannerListConvert", "#onBindViewHolder auto switch lastCheckPos=" + j + " currentPos=" + i + ". switch next time");
    }
    if (i < this.ENM.EML.size() - 1) {}
    for (int j = i + 1;; j = 0)
    {
      localObject = this.EOc;
      com.tencent.mm.hellhoundlib.b.a locala1 = com.tencent.mm.hellhoundlib.b.c.a(j, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala1.aYi(), "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$runAutoSwitchCard$1", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "Undefined", "smoothScrollToPosition", "(I)V");
      ((WxRecyclerView)localObject).smoothScrollToPosition(((Integer)locala1.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/BigBannerListConvert$runAutoSwitchCard$1", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "Undefined", "smoothScrollToPosition", "(I)V");
      Log.i("BigBannerListConvert", s.X("#onBindViewHolder auto switch now pos is ", Integer.valueOf(i)));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.c.j
 * JD-Core Version:    0.7.0.1
 */