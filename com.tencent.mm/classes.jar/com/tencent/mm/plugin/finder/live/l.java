package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bf;
import com.tencent.mm.plugin.finder.live.report.s.bh;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.view.recyclerview.WxRecyclerView;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "", "rv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "plugin", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "getPlugin", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "setPlugin", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;)V", "pos", "", "getPos", "()I", "setPos", "(I)V", "recyclerView", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "activatePlugin", "", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "isFromFloat", "", "forceUpdate", "deactivatePlugin", "release", "reportWhenSlideLiveRoom", "oldPos", "newPos", "selectTheSamePos", "updatePlugins", "newPlugin", "plugin-finder_release"})
public final class l
{
  int pos;
  final bid reportObj;
  WxRecyclerView xUj;
  public FinderLiveVisitorPluginLayout xWt;
  
  public l(WxRecyclerView paramWxRecyclerView, bid parambid)
  {
    AppMethodBeat.i(279559);
    this.reportObj = parambid;
    this.xUj = paramWxRecyclerView;
    this.pos = -1;
    AppMethodBeat.o(279559);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(l paraml, int paramInt1, int paramInt2, f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(285791);
      int i = this.xWv;
      int j = this.xWw;
      f localf = this.xWx;
      m localm;
      i locali;
      Object localObject;
      if ((i != -1) && (i != j))
      {
        localm = m.yCt;
        locali = new i();
        if (localf != null)
        {
          localObject = localf.xWR;
          if (localObject != null)
          {
            localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
            if (localObject != null)
            {
              String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).kig;
              localObject = str;
              if (str != null) {
                break label99;
              }
            }
          }
        }
        localObject = "";
        label99:
        locali.g("username", localObject);
        if (localf == null) {
          break label198;
        }
        localObject = localf.xWR;
        if (localObject == null) {
          break label198;
        }
        localObject = (c)((a)localObject).business(c.class);
        if (localObject == null) {
          break label198;
        }
        localObject = ((c)localObject).liveInfo;
        if (localObject == null) {
          break label198;
        }
      }
      label198:
      for (long l = ((bac)localObject).liveId;; l = 0L)
      {
        locali.g("liveId", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(l));
        m.a(s.bf.yLi, locali.toString());
        localm.a(s.bh.yLK);
        AppMethodBeat.o(285791);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.l
 * JD-Core Version:    0.7.0.1
 */