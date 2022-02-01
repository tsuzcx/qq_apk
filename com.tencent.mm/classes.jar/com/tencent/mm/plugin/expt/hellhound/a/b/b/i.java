package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback;", "", "()V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "mRLBeginListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1;", "startMonitor", "", "Companion", "plugin-expt_release"})
public final class i
{
  public static final a sFL;
  final HashMap<String, List<Pair<String, String>>> sEh;
  final i.b sFK;
  
  static
  {
    AppMethodBeat.i(220961);
    sFL = new a((byte)0);
    AppMethodBeat.o(220961);
  }
  
  public i()
  {
    AppMethodBeat.i(220960);
    this.sEh = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onRefreshBegin", "(I)V"));
    localArrayList.add(Pair.create("onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V"));
    localArrayList.add(Pair.create("onLoadMoreBegin", "()V"));
    localArrayList.add(Pair.create("onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V"));
    ((Map)this.sEh).put("com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", localArrayList);
    this.sFK = new i.b();
    AppMethodBeat.o(220960);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$Companion;", "", "()V", "DESC_onLoadMoreBegin", "", "DESC_onLoadMoreEnd", "DESC_onRefreshBegin", "DESC_onRefreshEnd", "NAME_onLoadMoreBegin", "NAME_onLoadMoreEnd", "NAME_onRefreshBegin", "NAME_onRefreshEnd", "SUPER_NAME", "TAG", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.i
 * JD-Core Version:    0.7.0.1
 */