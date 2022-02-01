package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWhiteListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWhiteListUI.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter;
import com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter.b;
import com.tencent.mm.plugin.finder.view.ae;
import com.tencent.mm.plugin.finder.view.ae.c;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveChargeWhiteListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Landroid/view/View$OnClickListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "liveChargeAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;", "getLiveChargeAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;", "setLiveChargeAdapter", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;)V", "liveChargeBottomSheet", "Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet;", "getLiveChargeBottomSheet", "()Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet;", "setLiveChargeBottomSheet", "(Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet;)V", "liveChargeChooseIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLiveChargeChooseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLiveChargeChooseIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "liveChargeContent", "Landroid/view/View;", "getLiveChargeContent", "()Landroid/view/View;", "setLiveChargeContent", "(Landroid/view/View;)V", "liveChargeGroup", "getLiveChargeGroup", "setLiveChargeGroup", "liveChargeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveChargePost;", "getLiveChargeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveChargePost;", "setLiveChargeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveChargePost;)V", "liveChargeRv", "Landroidx/recyclerview/widget/RecyclerView;", "getLiveChargeRv", "()Landroidx/recyclerview/widget/RecyclerView;", "setLiveChargeRv", "(Landroidx/recyclerview/widget/RecyclerView;)V", "liveChargeTipsTv", "Landroid/widget/TextView;", "getLiveChargeTipsTv", "()Landroid/widget/TextView;", "setLiveChargeTipsTv", "(Landroid/widget/TextView;)V", "liveChargeTitleTv", "getLiveChargeTitleTv", "setLiveChargeTitleTv", "liveChargeWecoinGroup", "getLiveChargeWecoinGroup", "setLiveChargeWecoinGroup", "liveChargeWecoinText", "getLiveChargeWecoinText", "setLiveChargeWecoinText", "liveFlag", "", "getLiveFlag", "()I", "setLiveFlag", "(I)V", "livePurchaseEnable", "", "getLivePurchaseEnable", "()Z", "setLivePurchaseEnable", "(Z)V", "chooseChargeMode", "", "choose", "goToSelectRoom", "haveChoosed", "initLayout", "initLogic", "onActivityResult", "tmpChargeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveWhiteList;", "onClick", "v", "openLiveChargePage", "showChargeBottomSheet", "updateAdapter", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends UIComponent
  implements View.OnClickListener
{
  public View DYo;
  public WeImageView DYp;
  public View DYq;
  public TextView DYr;
  public View DYs;
  public RecyclerView DYt;
  public FinderLiveWhiteListGroupAdapter DYu;
  private ae DYv;
  public bfy DYw;
  private int DYx;
  public boolean DYy;
  public final String TAG;
  
  public i(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356224);
    this.TAG = "FinderLiveChargeWhiteListUIC";
    this.DYw = new bfy();
    this.DYx = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adav, 0);
    this.DYy = d.ee(this.DYx, 8);
    Log.i(this.TAG, "init liveFlag:" + this.DYx + ",livePurchaseEnable:" + this.DYy);
    AppMethodBeat.o(356224);
  }
  
  private final void exd()
  {
    AppMethodBeat.i(356244);
    this.DYv = new ae((Context)getActivity(), (kotlin.g.a.b)new c(this));
    ae localae = this.DYv;
    if (localae != null)
    {
      Object localObject2 = p.listOf(new Integer[] { Integer.valueOf(10), Integer.valueOf(500), Integer.valueOf(1000), Integer.valueOf(2000) });
      s.u(localObject2, "dataList");
      com.tencent.mm.ui.widget.a.h localh = new com.tencent.mm.ui.widget.a.h(localae.context);
      localh.mh(localae.flF());
      localh.jHO();
      localh.dDn();
      s.u(localObject2, "data");
      localae.pUj.clear();
      Object localObject1 = localae.pUj;
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(new ae.c(((Number)((Iterator)localObject3).next()).intValue()));
      }
      ((ArrayList)localObject1).addAll((Collection)localObject2);
      localae.pUj.add(new ae.c(0));
      localObject1 = localae.ALE;
      if (localObject1 != null) {
        ((RecyclerView.a)localObject1).bZE.notifyChanged();
      }
      localObject1 = ah.aiuX;
      localae.GFa = localh;
    }
    AppMethodBeat.o(356244);
  }
  
  public final void exc()
  {
    AppMethodBeat.i(356279);
    FinderLiveWhiteListGroupAdapter localFinderLiveWhiteListGroupAdapter = this.DYu;
    LinkedList localLinkedList;
    if (localFinderLiveWhiteListGroupAdapter != null)
    {
      localLinkedList = new LinkedList();
      localObject = FinderLiveVisitorWhiteListUI.BpL;
      localObject = this.DYw.ZPJ;
      if (localObject != null) {
        break label145;
      }
      localObject = null;
      if (localObject != null) {
        break label153;
      }
    }
    label145:
    label153:
    for (Object localObject = (List)new LinkedList();; localObject = (List)localObject)
    {
      localLinkedList.add(new FinderLiveWhiteListGroupAdapter.b(3, FinderLiveVisitorWhiteListUI.a.gi((List)localObject)));
      localObject = ah.aiuX;
      localFinderLiveWhiteListGroupAdapter.az(localLinkedList);
      localObject = this.DYu;
      if (localObject != null) {
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
      localObject = this.DYr;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)String.valueOf(this.DYw.ZGO));
      }
      localObject = this.DYq;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      AppMethodBeat.o(356279);
      return;
      localObject = ((boe)localObject).ZWz;
      break;
    }
  }
  
  public final boolean exe()
  {
    return this.DYw.ZGO > 0;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(356296);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveChargeWhiteListUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BWr;
      if (paramView != null) {
        break label87;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveChargeWhiteListUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(356296);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label87:
      if (paramView.intValue() == i)
      {
        paramView = getActivity();
        if ((paramView instanceof FinderLiveVisitorWhiteListUI)) {}
        for (paramView = (FinderLiveVisitorWhiteListUI)paramView;; paramView = null)
        {
          if (paramView != null) {
            paramView.Oo(524288);
          }
          paramView = com.tencent.mm.kernel.h.baE().ban().get(at.a.adba, Boolean.FALSE);
          if (paramView != null) {
            break;
          }
          paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(356296);
          throw paramView;
        }
        if (((Boolean)paramView).booleanValue())
        {
          exd();
        }
        else
        {
          paramView = new com.tencent.mm.plugin.finder.replay.widget.a((Context)getContext(), true);
          localObject = paramView.getContext().getResources().getString(p.h.Cje);
          s.s(localObject, "context.resources.getStr…ive_charge_license_desc2)");
          String str = paramView.getContext().getResources().getString(p.h.Cjc);
          s.s(str, "context.resources.getStr…_charge_license_content2)");
          paramView.b((String)localObject, str, (kotlin.g.a.a)new i.b(this));
        }
      }
    }
  }
  
  public final void sf(boolean paramBoolean)
  {
    AppMethodBeat.i(356285);
    if (paramBoolean)
    {
      localObject = this.DYp;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      localObject = this.DYs;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      exc();
      AppMethodBeat.o(356285);
      return;
    }
    Object localObject = this.DYp;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.DYs;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    AppMethodBeat.o(356285);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    c(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.i
 * JD-Core Version:    0.7.0.1
 */