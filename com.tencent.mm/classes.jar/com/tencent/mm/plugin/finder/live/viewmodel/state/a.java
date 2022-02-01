package com.tencent.mm.plugin.finder.live.viewmodel.state;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWhiteListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWhiteListUI.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter;
import com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter.b;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/FinderLiveWhiteListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Landroid/view/View$OnClickListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "chooseWhiteList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getChooseWhiteList", "()Ljava/util/LinkedList;", "setChooseWhiteList", "(Ljava/util/LinkedList;)V", "chooseWhiteListRoom", "getChooseWhiteListRoom", "setChooseWhiteListRoom", "chooseWhiteUser", "getChooseWhiteUser", "setChooseWhiteUser", "foldIconOpen", "", "getFoldIconOpen", "()Z", "setFoldIconOpen", "(Z)V", "maxUserCount", "", "getMaxUserCount", "()I", "setMaxUserCount", "(I)V", "visitorWhiteList", "getVisitorWhiteList", "setVisitorWhiteList", "whiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveWhiteList;", "getWhiteList", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveWhiteList;", "setWhiteList", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveWhiteList;)V", "whiteListChooseIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getWhiteListChooseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setWhiteListChooseIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "whiteListContent", "Landroid/view/View;", "getWhiteListContent", "()Landroid/view/View;", "setWhiteListContent", "(Landroid/view/View;)V", "whiteListFoldIv", "Landroid/widget/ImageView;", "getWhiteListFoldIv", "()Landroid/widget/ImageView;", "setWhiteListFoldIv", "(Landroid/widget/ImageView;)V", "whiteListGroup", "getWhiteListGroup", "setWhiteListGroup", "whiteListRv", "Landroidx/recyclerview/widget/RecyclerView;", "getWhiteListRv", "()Landroidx/recyclerview/widget/RecyclerView;", "setWhiteListRv", "(Landroidx/recyclerview/widget/RecyclerView;)V", "whiteListTipsTv", "Landroid/widget/TextView;", "getWhiteListTipsTv", "()Landroid/widget/TextView;", "setWhiteListTipsTv", "(Landroid/widget/TextView;)V", "whiteListTitleTv", "getWhiteListTitleTv", "setWhiteListTitleTv", "whitelistAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;", "getWhitelistAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;", "setWhitelistAdapter", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;)V", "chooseWhiteListMode", "", "choose", "goToSelectRoom", "goToSelectWhiteList", "haveChoosedList", "hideWhiteList", "initLayout", "initLogic", "onClick", "v", "onSelectContactActivityResult", "tmpChargeInfo", "onSelectWebListActivityResult", "data", "Landroid/content/Intent;", "setWhiteListFoldState", "open", "showWhiteList", "updateAdapter", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
  implements View.OnClickListener
{
  public LinkedList<bfh> BpY;
  public LinkedList<bfh> BpZ;
  public int BsR;
  public TextView EiA;
  public ImageView EiB;
  public View EiC;
  public RecyclerView EiD;
  public FinderLiveWhiteListGroupAdapter EiE;
  public LinkedList<String> EiF;
  public LinkedList<String> EiG;
  public boe EiH;
  private boolean EiI;
  public View Eix;
  public WeImageView Eiy;
  public TextView Eiz;
  public final String TAG;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(357151);
    this.TAG = "FinderLiveWhiteListUIC";
    this.BpY = new LinkedList();
    this.BpZ = new LinkedList();
    this.EiF = new LinkedList();
    this.EiG = new LinkedList();
    paramAppCompatActivity = new boe();
    paramAppCompatActivity.ZWy = this.EiF;
    paramAppCompatActivity.username_list = this.EiG;
    ah localah = ah.aiuX;
    this.EiH = paramAppCompatActivity;
    AppMethodBeat.o(357151);
  }
  
  public static final void a(a parama, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(357187);
    int i;
    if (paramLinkedList != null)
    {
      parama.EiF.clear();
      parama.EiF.addAll((Collection)paramLinkedList);
      paramLinkedList = (Collection)parama.EiF;
      if ((paramLinkedList != null) && (!paramLinkedList.isEmpty())) {
        break label87;
      }
      i = 1;
      if (i == 0)
      {
        parama = parama.getActivity();
        if (!(parama instanceof FinderLiveVisitorWhiteListUI)) {
          break label92;
        }
      }
    }
    label87:
    label92:
    for (parama = (FinderLiveVisitorWhiteListUI)parama;; parama = null)
    {
      if (parama != null) {
        parama.On(2);
      }
      AppMethodBeat.o(357187);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void b(a parama, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(357192);
    int i;
    if (paramLinkedList != null)
    {
      parama.EiG.clear();
      parama.EiG.addAll((Collection)paramLinkedList);
      paramLinkedList = (Collection)parama.EiG;
      if ((paramLinkedList != null) && (!paramLinkedList.isEmpty())) {
        break label89;
      }
      i = 1;
      if (i == 0)
      {
        parama = parama.getActivity();
        if (!(parama instanceof FinderLiveVisitorWhiteListUI)) {
          break label94;
        }
      }
    }
    label89:
    label94:
    for (parama = (FinderLiveVisitorWhiteListUI)parama;; parama = null)
    {
      if (parama != null) {
        parama.On(4);
      }
      AppMethodBeat.o(357192);
      return;
      i = 0;
      break;
    }
  }
  
  private final void ezm()
  {
    AppMethodBeat.i(357163);
    Object localObject = this.EiE;
    if (localObject != null) {
      ((RecyclerView.a)localObject).bZE.notifyChanged();
    }
    localObject = this.EiD;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(357163);
  }
  
  private final void ezn()
  {
    AppMethodBeat.i(357170);
    RecyclerView localRecyclerView = this.EiD;
    if (localRecyclerView != null) {
      localRecyclerView.setVisibility(8);
    }
    AppMethodBeat.o(357170);
  }
  
  private final void ss(boolean paramBoolean)
  {
    AppMethodBeat.i(357179);
    if (this.EiI == paramBoolean)
    {
      Log.i(this.TAG, "setWhiteListFoldState open:" + paramBoolean + " same with foldIconOpen!");
      AppMethodBeat.o(357179);
      return;
    }
    this.EiI = paramBoolean;
    ImageView localImageView;
    if (this.EiI)
    {
      localImageView = this.EiB;
      if (localImageView != null)
      {
        localImageView.setRotationX(180.0F);
        AppMethodBeat.o(357179);
      }
    }
    else
    {
      localImageView = this.EiB;
      if (localImageView != null) {
        localImageView.setRotationX(0.0F);
      }
    }
    AppMethodBeat.o(357179);
  }
  
  public final void exc()
  {
    AppMethodBeat.i(357218);
    FinderLiveWhiteListGroupAdapter localFinderLiveWhiteListGroupAdapter = this.EiE;
    if (localFinderLiveWhiteListGroupAdapter != null)
    {
      LinkedList localLinkedList = new LinkedList();
      Object localObject = FinderLiveVisitorWhiteListUI.BpL;
      localObject = this.EiH.ZWz;
      s.s(localObject, "whiteList.contact_list");
      localLinkedList.add(new FinderLiveWhiteListGroupAdapter.b(4, FinderLiveVisitorWhiteListUI.a.gi((List)localObject)));
      localObject = FinderLiveVisitorWhiteListUI.BpL;
      localLinkedList.add(new FinderLiveWhiteListGroupAdapter.b(1, FinderLiveVisitorWhiteListUI.a.am(this.BpZ)));
      localObject = ah.aiuX;
      localFinderLiveWhiteListGroupAdapter.az(localLinkedList);
    }
    AppMethodBeat.o(357218);
  }
  
  public final boolean ezo()
  {
    AppMethodBeat.i(357237);
    if ((this.BpZ.size() > 0) || (this.EiF.size() > 0) || (this.EiG.size() > 0))
    {
      AppMethodBeat.o(357237);
      return true;
    }
    AppMethodBeat.o(357237);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(357227);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/state/FinderLiveWhiteListUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if ((paramView != null) && (paramView.getId() == p.e.Ccl))
    {
      i = 1;
      if (i != 0)
      {
        paramView = getActivity();
        if (!(paramView instanceof FinderLiveVisitorWhiteListUI)) {
          break label112;
        }
      }
    }
    label112:
    for (paramView = (FinderLiveVisitorWhiteListUI)paramView;; paramView = null)
    {
      if (paramView != null) {
        paramView.efv();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/state/FinderLiveWhiteListUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(357227);
      return;
      i = 0;
      break;
    }
  }
  
  public final void sr(boolean paramBoolean)
  {
    AppMethodBeat.i(357235);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.EiC;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      ss(true);
      ezm();
      localObject = this.Eiy;
      if (localObject != null)
      {
        ((WeImageView)localObject).setVisibility(0);
        AppMethodBeat.o(357235);
      }
    }
    else
    {
      localObject = this.Eiy;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
      localObject = this.EiC;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      ss(false);
      ezn();
      localObject = this.Eiy;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
    }
    AppMethodBeat.o(357235);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "type", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    public a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.a
 * JD-Core Version:    0.7.0.1
 */