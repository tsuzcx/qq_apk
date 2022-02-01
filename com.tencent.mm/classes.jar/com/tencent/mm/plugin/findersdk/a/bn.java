package com.tencent.mm.plugin.findersdk.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.bui;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderReporterUIC;", "Lcom/tencent/mm/ui/component/ApiUIC;", "appendChnlExtra", "", "key", "", "value", "assignChnlExtra", "chnlExtra", "assignClickSubTabContextId", "clickSubTabContextId", "assignClickTabContextId", "clickTabContextId", "assignContextId", "contextId", "getCurrentReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedEventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "tabType", "", "getFeedEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "getLastVisibleExtStats", "", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "getReportChnlExtra", "getReportClickSubTabContextId", "getReportCommentScene", "getReportContextId", "initIntentParams", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "feedId", "", "clickFeedContextId", "fromProfileShareScene", "enterProfileType", "enterLbsUI", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bn
  extends com.tencent.mm.ui.component.c
{
  public abstract com.tencent.mm.plugin.finder.event.base.c Vm(int paramInt);
  
  public abstract void aA(Context paramContext, Intent paramIntent);
  
  public abstract void aCN(String paramString);
  
  public abstract void aCO(String paramString);
  
  public abstract void aCP(String paramString);
  
  public abstract void aCQ(String paramString);
  
  public abstract String foA();
  
  public abstract List<aps> foB();
  
  public abstract bui fou();
  
  public abstract String fov();
  
  public abstract int fow();
  
  public abstract a foy();
  
  public abstract String foz();
  
  public abstract void iw(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.bn
 * JD-Core Version:    0.7.0.1
 */