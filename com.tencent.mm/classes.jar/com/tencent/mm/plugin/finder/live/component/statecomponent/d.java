package com.tencent.mm.plugin.finder.live.component.statecomponent;

import android.view.View;
import android.view.ViewStub;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.plugin.finder.live.view.router.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveVisitorStateComponent;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/StateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;", "getBaseRouter", "()Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;", "setBaseRouter", "(Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;)V", "getContext", "()Landroidx/appcompat/app/AppCompatActivity;", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "setData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;)V", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setReportObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "genRootViewByStub", "Landroid/view/View;", "stubId", "", "root", "onBindData", "", "onSelected", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
  extends e
{
  public final AppCompatActivity CCa;
  public c CCg;
  public f data;
  public bui reportObj;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    this.CCa = paramAppCompatActivity;
  }
  
  public static View genRootViewByStub(int paramInt, View paramView)
  {
    s.u(paramView, "root");
    paramView = ((ViewStub)paramView.findViewById(paramInt)).inflate();
    s.s(paramView, "stub.inflate()");
    return paramView;
  }
  
  public void a(c paramc, bui parambui)
  {
    s.u(paramc, "baseRouter");
    this.data = paramc.getData();
    setBuContext(paramc.getBuContext());
    this.CCg = paramc;
    this.reportObj = parambui;
  }
  
  public void aEB() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.statecomponent.d
 * JD-Core Version:    0.7.0.1
 */