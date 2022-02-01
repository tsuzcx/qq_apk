package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC;
import com.tencent.mm.plugin.finder.upload.postui.c;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "REQUEST_CODE_PICK_LOCATION", "", "getREQUEST_CODE_PICK_LOCATION", "()I", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "locationWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "getLocationWidget", "()Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "setLocationWidget", "(Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;)V", "getRoot", "()Landroid/view/View;", "getLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "initLocation", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onGetLbsLifes", "city", "", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "plugin-finder_release"})
public final class k
  implements a.a
{
  final MMActivity activity;
  private final View gvQ;
  public final int uHa;
  public c uHb;
  
  public k(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(248127);
    this.activity = paramMMActivity;
    this.gvQ = paramView;
    this.uHa = 20000;
    paramMMActivity = this.activity;
    paramView = this.gvQ.findViewById(2131306070);
    p.g(paramView, "root.findViewById<Finder…(R.id.post_location_view)");
    this.uHb = new c(paramMMActivity, (b)paramView, null, null, this.uHa);
    paramMMActivity = this.uHb;
    paramView = this.activity.getIntent();
    p.g(paramView, "activity.intent");
    paramMMActivity.c(paramView, new Bundle());
    paramMMActivity = this.uHb.vUO;
    paramView = this.gvQ.getContext();
    p.g(paramView, "root.context");
    paramMMActivity.setIconColor(paramView.getResources().getColor(2131099844));
    paramMMActivity = this.uHb.vUO;
    paramView = this.gvQ.getContext();
    p.g(paramView, "root.context");
    paramMMActivity.setTextColor(paramView.getResources().getColor(2131099844));
    paramMMActivity = this.uHb.vUO;
    paramView = this.gvQ.getContext();
    p.g(paramView, "root.context");
    paramMMActivity.setDefaultStateIconColor(paramView.getResources().getColor(2131099844));
    paramMMActivity = this.uHb.vUO;
    paramView = this.gvQ.getContext();
    p.g(paramView, "root.context");
    paramMMActivity.setDefaultStateTextColor(paramView.getResources().getColor(2131099844));
    paramMMActivity = this.uHb.vUO;
    paramView = this.gvQ.getContext();
    p.g(paramView, "root.context");
    paramMMActivity.setDefaultLoadingPBarColor(paramView.getResources().getColor(2131099844));
    paramMMActivity = this.uHb.vUO;
    paramView = this.gvQ.getContext();
    p.g(paramView, "root.context");
    paramMMActivity.setDefaultLoadingTipColor(paramView.getResources().getColor(2131099844));
    this.uHb.vUO.diz();
    d.i((a)new a(this));
    AppMethodBeat.o(248127);
  }
  
  public final void s(String paramString, List<chj> paramList)
  {
    AppMethodBeat.i(248126);
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = FinderLivePostUIC.uDb;
      Log.i(FinderLivePostUIC.access$getTAG$cp(), "get lbsLife success");
      this.uHb.a(paramString, (chj)j.ks(paramList));
      AppMethodBeat.o(248126);
      return;
    }
    paramString = FinderLivePostUIC.uDb;
    Log.i(FinderLivePostUIC.access$getTAG$cp(), "get lbsLife fail");
    this.uHb.diy();
    AppMethodBeat.o(248126);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.k
 * JD-Core Version:    0.7.0.1
 */