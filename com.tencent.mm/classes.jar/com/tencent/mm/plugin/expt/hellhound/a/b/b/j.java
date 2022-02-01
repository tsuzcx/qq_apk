package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback;", "", "mRLCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;)V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "getMRLCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "mRefeshLoadMoreListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$mRefeshLoadMoreListener$1;", "startMonitor", "", "Companion", "plugin-expt_release"})
public final class j
{
  public static final a sFO;
  final HashMap<String, List<Pair<String, String>>> sEh;
  final j.b sFM;
  final m sFN;
  
  static
  {
    AppMethodBeat.i(220964);
    sFO = new a((byte)0);
    AppMethodBeat.o(220964);
  }
  
  public j(m paramm)
  {
    AppMethodBeat.i(220963);
    this.sFN = paramm;
    this.sEh = new HashMap();
    paramm = new ArrayList();
    paramm.add(Pair.create("onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V"));
    ((Map)this.sEh).put("com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", paramm);
    this.sFM = new j.b(this);
    AppMethodBeat.o(220963);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLEndCallback$Companion;", "", "()V", "DESC_onFetchDone", "", "NAME_onFetchDone", "SUPER_NAME", "TAG", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.j
 * JD-Core Version:    0.7.0.1
 */