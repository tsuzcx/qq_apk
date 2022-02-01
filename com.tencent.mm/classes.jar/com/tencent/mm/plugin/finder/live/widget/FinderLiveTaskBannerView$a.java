package com.tencent.mm.plugin.finder.live.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.blk;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$FinderLiveQuestActivityTaskData;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$ITaskData;", "data", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivity;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivity;)V", "getData", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivity;", "getActivityId", "", "getH5Url", "getIconUrl", "getRemainClickTimes", "", "getSwitchInterval", "", "getWording", "setRemainClickTimes", "", "value", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveTaskBannerView$a
  implements FinderLiveTaskBannerView.c
{
  final blk EuI;
  
  public FinderLiveTaskBannerView$a(blk paramblk)
  {
    AppMethodBeat.i(362078);
    this.EuI = paramblk;
    AppMethodBeat.o(362078);
  }
  
  public final void Ql(int paramInt)
  {
    this.EuI.ZUB = paramInt;
  }
  
  public final int eBD()
  {
    return this.EuI.ZUB;
  }
  
  public final String eBE()
  {
    return this.EuI.Vyi;
  }
  
  public final long eBF()
  {
    return this.EuI.ZUC * 1000L;
  }
  
  public final String getH5Url()
  {
    return this.EuI.Kru;
  }
  
  public final String getIconUrl()
  {
    return this.EuI.icon_url;
  }
  
  public final String getWording()
  {
    return this.EuI.wording;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveTaskBannerView.a
 * JD-Core Version:    0.7.0.1
 */