package com.tencent.mm.plugin.finder.live.component;

import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.ccg;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleContract$Presenter;", "onBubbleClick", "Lkotlin/Function0;", "", "getOnBubbleClick", "()Lkotlin/jvm/functions/Function0;", "setOnBubbleClick", "(Lkotlin/jvm/functions/Function0;)V", "showingStatus", "", "getShowingStatus", "()I", "getShowingTask", "Lcom/tencent/mm/protocal/protobuf/GameWelfareTaskInfo;", "hideGainView", "hideTaskView", "showGainView", "info", "Lcom/tencent/mm/protocal/protobuf/GameWelfareMediaInfo;", "forceLoadPag", "", "showTaskView", "taskInfo", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface w$b
  extends c<w.a>
{
  public static final w.b.a Cyl = w.b.a.Cym;
  
  public abstract void a(ccf paramccf, boolean paramBoolean);
  
  public abstract void aU(a<ah> parama);
  
  public abstract int eid();
  
  public abstract void eie();
  
  public abstract void eif();
  
  public abstract ccg getShowingTask();
  
  public abstract void gn(List<? extends ccg> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.w.b
 * JD-Core Version:    0.7.0.1
 */