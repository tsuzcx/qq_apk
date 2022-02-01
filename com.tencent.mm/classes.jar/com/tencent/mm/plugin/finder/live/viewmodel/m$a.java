package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorGameRankSwitchUIC$GameRankSwitchConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorGameRankSwitchUIC$GameRankSwitchFeed;", "switchChangedCallback", "Lkotlin/Function2;", "", "", "(Lkotlin/jvm/functions/Function2;)V", "getSwitchChangedCallback", "()Lkotlin/jvm/functions/Function2;", "appendAppid", "appid", "", "checkShowPermissionTips", "check", "switchInfo", "Lcom/tencent/mm/protocal/protobuf/GameRankSwitch;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m$a
  extends com.tencent.mm.view.recyclerview.f<m.b>
{
  private final m<m.b, Boolean, ah> DZE;
  
  public m$a(m<? super m.b, ? super Boolean, ah> paramm)
  {
    AppMethodBeat.i(356393);
    this.DZE = paramm;
    AppMethodBeat.o(356393);
  }
  
  private static final void a(a parama, m.b paramb, j paramj, MMSwitchBtn paramMMSwitchBtn, boolean paramBoolean)
  {
    AppMethodBeat.i(356437);
    s.u(parama, "this$0");
    s.u(paramb, "$item");
    s.u(paramj, "$holder");
    Object localObject1 = paramb.DZF;
    Object localObject2;
    Object localObject3;
    if (paramBoolean)
    {
      localObject2 = h.baE().ban().b(at.a.adbq, "");
      Log.i("SimpleUIComponent", "permissionAppids:" + localObject2 + ", switchInfo.game_app_id:" + ((cbv)localObject1).ZGM);
      s.s(localObject2, "permissionAppids");
      localObject3 = (CharSequence)localObject2;
      localObject2 = ((cbv)localObject1).ZGM;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (n.i((CharSequence)localObject3, (CharSequence)localObject1)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      localObject2 = new d(paramj.context);
      ((d)localObject2).UD(p.f.CcK);
      TextView localTextView = (TextView)((d)localObject2).rootView.findViewById(p.e.BZk);
      View localView = ((d)localObject2).rootView.findViewById(p.e.BYB);
      localObject3 = ((d)localObject2).rootView.findViewById(p.e.BBB);
      Resources localResources = paramj.context.getResources();
      i = p.h.CkA;
      localObject1 = paramb.DZF.aale;
      paramj = (j)localObject1;
      if (localObject1 == null) {
        paramj = "";
      }
      localTextView.setText((CharSequence)localResources.getString(i, new Object[] { paramj }));
      localView.setOnClickListener(new m.a..ExternalSyntheticLambda0((d)localObject2));
      paramj = new ah.a();
      ((View)localObject3).setOnClickListener(new m.a..ExternalSyntheticLambda1(paramj, (d)localObject2, parama, paramb, paramBoolean));
      ((d)localObject2).GwT = new m.a..ExternalSyntheticLambda2(paramj, paramMMSwitchBtn);
      ((d)localObject2).dDn();
      AppMethodBeat.o(356437);
      return;
    }
    parama.DZE.invoke(paramb, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(356437);
  }
  
  private static final void a(ah.a parama, d paramd, a parama1, m.b paramb, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(356414);
    s.u(parama, "$clickApply");
    s.u(paramd, "$this_apply");
    s.u(parama1, "this$0");
    s.u(paramb, "$item");
    parama.aiwY = true;
    paramd.cyW();
    paramd = paramb.DZF.ZGM;
    parama = paramd;
    if (paramd == null) {
      parama = "";
    }
    paramd = h.baE().ban().b(at.a.adbq, "");
    parama = paramd + ',' + parama;
    h.baE().ban().set(at.a.adbq, parama);
    Log.i("SimpleUIComponent", s.X("appendAppid result ", parama));
    parama1.DZE.invoke(paramb, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(356414);
  }
  
  private static final void a(ah.a parama, MMSwitchBtn paramMMSwitchBtn)
  {
    AppMethodBeat.i(356422);
    s.u(parama, "$clickApply");
    if (!parama.aiwY) {
      paramMMSwitchBtn.setCheck(false);
    }
    AppMethodBeat.o(356422);
  }
  
  private static final void e(d paramd, View paramView)
  {
    AppMethodBeat.i(356402);
    s.u(paramd, "$this_apply");
    paramd.cyW();
    AppMethodBeat.o(356402);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(356482);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(356482);
  }
  
  public final int getLayoutId()
  {
    return p.f.CdP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.m.a
 * JD-Core Version:    0.7.0.1
 */