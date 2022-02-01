package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.report.s.be;
import com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter;
import com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWhiteListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "cancelTv", "Landroid/widget/TextView;", "getCancelTv", "()Landroid/widget/TextView;", "setCancelTv", "(Landroid/widget/TextView;)V", "chooseMode", "", "getChooseMode", "()I", "setChooseMode", "(I)V", "chooseWhiteList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getChooseWhiteList", "()Ljava/util/LinkedList;", "setChooseWhiteList", "(Ljava/util/LinkedList;)V", "chooseWhiteListRoom", "Ljava/util/ArrayList;", "getChooseWhiteListRoom", "()Ljava/util/ArrayList;", "setChooseWhiteListRoom", "(Ljava/util/ArrayList;)V", "chooseWhiteUser", "getChooseWhiteUser", "setChooseWhiteUser", "finishTv", "getFinishTv", "setFinishTv", "foldIconOpen", "", "getFoldIconOpen", "()Z", "setFoldIconOpen", "(Z)V", "maxUserCount", "getMaxUserCount", "setMaxUserCount", "publicChooseIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getPublicChooseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setPublicChooseIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "publicGroup", "Landroid/view/View;", "getPublicGroup", "()Landroid/view/View;", "setPublicGroup", "(Landroid/view/View;)V", "shareChooseIcon", "getShareChooseIcon", "setShareChooseIcon", "shareGroup", "getShareGroup", "setShareGroup", "titleGroup", "getTitleGroup", "setTitleGroup", "visitorWhiteList", "getVisitorWhiteList", "setVisitorWhiteList", "whiteListChooseIcon", "getWhiteListChooseIcon", "setWhiteListChooseIcon", "whiteListContent", "getWhiteListContent", "setWhiteListContent", "whiteListFoldIv", "Landroid/widget/ImageView;", "getWhiteListFoldIv", "()Landroid/widget/ImageView;", "setWhiteListFoldIv", "(Landroid/widget/ImageView;)V", "whiteListGroup", "getWhiteListGroup", "setWhiteListGroup", "whiteListRv", "Landroidx/recyclerview/widget/RecyclerView;", "getWhiteListRv", "()Landroidx/recyclerview/widget/RecyclerView;", "setWhiteListRv", "(Landroidx/recyclerview/widget/RecyclerView;)V", "whiteListTipsTv", "getWhiteListTipsTv", "setWhiteListTipsTv", "whiteListTitleTv", "getWhiteListTitleTv", "setWhiteListTitleTv", "whitelistAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;", "getWhitelistAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;", "setWhitelistAdapter", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;)V", "checkWhiteListState", "", "mode", "choosePublicMode", "choose", "chooseShareMode", "chooseWhiteListMode", "expandWhiteListGroupPanel", "finish", "formatSelectedList", "selectedList", "formatSelectedListRoom", "formatSelectedUser", "getLayoutId", "getReportTag", "goBack", "isCancel", "goToSelectRoom", "goToSelectUser", "goToSelectWhiteList", "hideWhiteList", "initLayout", "initLogic", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "parseInten", "setFinishBtnEnable", "enable", "setWhiteListFoldState", "open", "setWindowStyle", "showWhiteList", "updateAdapter", "plugin-finder-live_release"})
public final class FinderLiveVisitorWhiteListUI
  extends MMFinderUI
  implements View.OnClickListener
{
  private final String TAG;
  private HashMap _$_findViewCache;
  View kGo;
  private TextView xPY;
  private TextView xPZ;
  private View xQa;
  private WeImageView xQb;
  private View xQc;
  private WeImageView xQd;
  private View xQe;
  private WeImageView xQf;
  private TextView xQg;
  private TextView xQh;
  private ImageView xQi;
  private View xQj;
  private RecyclerView xQk;
  private FinderLiveWhiteListGroupAdapter xQl;
  private int xQm;
  private LinkedList<ayj> xQn;
  private LinkedList<ayj> xQo;
  private ArrayList<String> xQp;
  private ArrayList<String> xQq;
  private int xQr;
  private boolean xQs;
  
  public FinderLiveVisitorWhiteListUI()
  {
    AppMethodBeat.i(233880);
    this.TAG = "FinderLiveVisitorWhiteListUI";
    this.xQn = new LinkedList();
    this.xQo = new LinkedList();
    this.xQp = new ArrayList();
    this.xQq = new ArrayList();
    AppMethodBeat.o(233880);
  }
  
  private final void MO(int paramInt)
  {
    AppMethodBeat.i(233843);
    Log.i(this.TAG, "chooseMode:".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      oz(true);
      dvE();
      oA(false);
      oy(true);
      k localk = k.yBj;
      k.dDm().a(s.be.yKU);
      AppMethodBeat.o(233843);
      return;
    }
    if ((d.dr(paramInt, 2)) || (d.dr(paramInt, 4)) || (d.dr(paramInt, 1))) {
      dvC();
    }
    AppMethodBeat.o(233843);
  }
  
  private static String ac(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(233830);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      localObject1 = (String)localObject1;
      Object localObject2 = h.ae(n.class);
      p.j(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((n)localObject2).bbL().bwg((String)localObject1);
      localObject2 = (com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class);
      p.j(localObject1, "contact");
      localStringBuilder.append(((com.tencent.mm.plugin.messenger.a.b)localObject2).b((as)localObject1, ((as)localObject1).getUsername()));
      if (i < paramArrayList.size() - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    paramArrayList = localStringBuilder.toString();
    p.j(paramArrayList, "result.toString()");
    AppMethodBeat.o(233830);
    return paramArrayList;
  }
  
  private static String ad(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(233832);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      localObject1 = (String)localObject1;
      Object localObject2 = h.ae(n.class);
      p.j(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((n)localObject2).bbL().bwg((String)localObject1);
      localObject2 = (com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class);
      p.j(localObject1, "contact");
      localStringBuilder.append(((com.tencent.mm.plugin.messenger.a.b)localObject2).b((as)localObject1, ((as)localObject1).getUsername()));
      if (i < paramArrayList.size() - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    paramArrayList = localStringBuilder.toString();
    p.j(paramArrayList, "result.toString()");
    AppMethodBeat.o(233832);
    return paramArrayList;
  }
  
  private static String ah(LinkedList<ayj> paramLinkedList)
  {
    AppMethodBeat.i(233835);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = (Iterable)paramLinkedList;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.iBO();
      }
      localStringBuilder.append(((ayj)localObject2).title);
      if (i < paramLinkedList.size() - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    paramLinkedList = localStringBuilder.toString();
    p.j(paramLinkedList, "result.toString()");
    AppMethodBeat.o(233835);
    return paramLinkedList;
  }
  
  private final void dvB()
  {
    AppMethodBeat.i(233840);
    FinderLiveWhiteListGroupAdapter localFinderLiveWhiteListGroupAdapter = this.xQl;
    if (localFinderLiveWhiteListGroupAdapter != null)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(new FinderLiveWhiteListGroupAdapter.b(0, ac(this.xQp)));
      if (this.xQr > 0)
      {
        com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
        if (com.tencent.c.a.a.a.a.a.ina()) {
          localLinkedList.add(new FinderLiveWhiteListGroupAdapter.b(2, ad(this.xQq)));
        }
      }
      for (;;)
      {
        localLinkedList.add(new FinderLiveWhiteListGroupAdapter.b(1, ah(this.xQo)));
        localFinderLiveWhiteListGroupAdapter.av(localLinkedList);
        AppMethodBeat.o(233840);
        return;
        Log.i(this.TAG, "maxUserCount invalid");
      }
    }
    AppMethodBeat.o(233840);
  }
  
  private final void dvC()
  {
    AppMethodBeat.i(233841);
    oz(false);
    dvE();
    if (this.xQs) {
      oA(false);
    }
    for (;;)
    {
      dvD();
      AppMethodBeat.o(233841);
      return;
      oA(true);
    }
  }
  
  private final void dvD()
  {
    AppMethodBeat.i(233844);
    if ((this.xQo.size() > 0) || (this.xQp.size() > 0) || (this.xQq.size() > 0))
    {
      oy(true);
      AppMethodBeat.o(233844);
      return;
    }
    oy(false);
    AppMethodBeat.o(233844);
  }
  
  private final void dvE()
  {
    AppMethodBeat.i(233850);
    WeImageView localWeImageView = this.xQd;
    if (localWeImageView != null)
    {
      localWeImageView.setVisibility(8);
      AppMethodBeat.o(233850);
      return;
    }
    AppMethodBeat.o(233850);
  }
  
  private final void dvF()
  {
    AppMethodBeat.i(233854);
    Object localObject = this.xQl;
    if (localObject != null) {
      ((FinderLiveWhiteListGroupAdapter)localObject).notifyDataSetChanged();
    }
    localObject = this.xQk;
    if (localObject != null)
    {
      ((RecyclerView)localObject).setVisibility(0);
      AppMethodBeat.o(233854);
      return;
    }
    AppMethodBeat.o(233854);
  }
  
  private final void dvG()
  {
    AppMethodBeat.i(233856);
    RecyclerView localRecyclerView = this.xQk;
    if (localRecyclerView != null)
    {
      localRecyclerView.setVisibility(8);
      AppMethodBeat.o(233856);
      return;
    }
    AppMethodBeat.o(233856);
  }
  
  private final void nQ(boolean paramBoolean)
  {
    AppMethodBeat.i(233874);
    Log.i(this.TAG, "goBack isCancel:" + paramBoolean + " chooseMode:" + this.xQm + " chooseWhiteList.size:" + this.xQo.size() + " chooseWhiteListRoom:" + this.xQp);
    if (paramBoolean)
    {
      setResult(0);
      finish();
      AppMethodBeat.o(233874);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject1 = a.d.BuY;
    localIntent.putExtra(a.d.emX(), this.xQm);
    localObject1 = a.d.BuY;
    String str = a.d.emZ();
    localObject1 = this.xQo;
    if (localObject1 != null)
    {
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((ayj)((Iterator)localObject2).next()).toByteArray());
      }
      localObject1 = (List)localObject1;
      label205:
      if ((localObject1 instanceof Serializable)) {
        break label271;
      }
      localObject1 = null;
    }
    label271:
    for (;;)
    {
      localIntent.putExtra(str, (Serializable)localObject1);
      localObject1 = a.d.BuY;
      localIntent.putStringArrayListExtra(a.d.ena(), this.xQp);
      localObject1 = a.d.BuY;
      localIntent.putStringArrayListExtra(a.d.enb(), this.xQq);
      setResult(-1, localIntent);
      break;
      localObject1 = null;
      break label205;
    }
  }
  
  private final void oA(boolean paramBoolean)
  {
    AppMethodBeat.i(233853);
    if (paramBoolean)
    {
      localObject = this.xQj;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      oB(true);
      dvF();
      localObject = this.xQf;
      if (localObject != null)
      {
        ((WeImageView)localObject).setVisibility(0);
        AppMethodBeat.o(233853);
        return;
      }
      AppMethodBeat.o(233853);
      return;
    }
    Object localObject = this.xQf;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.xQj;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    oB(false);
    dvG();
    localObject = this.xQf;
    if (localObject != null)
    {
      ((WeImageView)localObject).setVisibility(8);
      AppMethodBeat.o(233853);
      return;
    }
    AppMethodBeat.o(233853);
  }
  
  private final void oB(boolean paramBoolean)
  {
    AppMethodBeat.i(233857);
    if (this.xQs == paramBoolean)
    {
      Log.i(this.TAG, "setWhiteListFoldState open:" + paramBoolean + " same with foldIconOpen!");
      AppMethodBeat.o(233857);
      return;
    }
    this.xQs = paramBoolean;
    if (this.xQs)
    {
      localImageView = this.xQi;
      if (localImageView != null)
      {
        localImageView.setRotationX(180.0F);
        AppMethodBeat.o(233857);
        return;
      }
      AppMethodBeat.o(233857);
      return;
    }
    ImageView localImageView = this.xQi;
    if (localImageView != null)
    {
      localImageView.setRotationX(0.0F);
      AppMethodBeat.o(233857);
      return;
    }
    AppMethodBeat.o(233857);
  }
  
  private final void oy(boolean paramBoolean)
  {
    AppMethodBeat.i(233847);
    TextView localTextView = this.xPZ;
    if (localTextView != null) {
      localTextView.setEnabled(paramBoolean);
    }
    Context localContext;
    if (paramBoolean)
    {
      localTextView = this.xPZ;
      if (localTextView != null)
      {
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        localTextView.setTextColor(localContext.getResources().getColor(b.c.White));
        AppMethodBeat.o(233847);
        return;
      }
      AppMethodBeat.o(233847);
      return;
    }
    localTextView = this.xPZ;
    if (localTextView != null)
    {
      localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      localTextView.setTextColor(localContext.getResources().getColor(b.c.BW_100_Alpha_0_2));
      AppMethodBeat.o(233847);
      return;
    }
    AppMethodBeat.o(233847);
  }
  
  private final void oz(boolean paramBoolean)
  {
    AppMethodBeat.i(233849);
    if (paramBoolean)
    {
      localWeImageView = this.xQb;
      if (localWeImageView != null)
      {
        localWeImageView.setVisibility(0);
        AppMethodBeat.o(233849);
        return;
      }
      AppMethodBeat.o(233849);
      return;
    }
    WeImageView localWeImageView = this.xQb;
    if (localWeImageView != null)
    {
      localWeImageView.setVisibility(8);
      AppMethodBeat.o(233849);
      return;
    }
    AppMethodBeat.o(233849);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233889);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233889);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233888);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(233888);
    return localView1;
  }
  
  public final String dvl()
  {
    return this.TAG;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(233872);
    super.finish();
    AppMethodBeat.o(233872);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_visibility_list_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    int i = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    a.d locald = null;
    AppMethodBeat.i(233879);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i(this.TAG, "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    switch (paramInt1)
    {
    default: 
    case 0: 
      do
      {
        AppMethodBeat.o(233879);
        return;
        localObject1 = locald;
        if (paramIntent != null)
        {
          localObject1 = a.d.BuY;
          localObject1 = paramIntent.getStringArrayListExtra(a.d.ena());
        }
        Log.i(this.TAG, "onActivityResult REQUEST_CODE_SELECT_ROOM selectedResult:".concat(String.valueOf(localObject1)));
      } while (localObject1 == null);
      this.xQp.clear();
      this.xQp.addAll((Collection)localObject1);
      paramIntent = (Collection)this.xQp;
      if (paramIntent != null)
      {
        paramInt1 = i;
        if (!paramIntent.isEmpty()) {}
      }
      else
      {
        paramInt1 = 1;
      }
      if (paramInt1 == 0)
      {
        this.xQm |= 0x2;
        dvD();
      }
      dvB();
      paramIntent = this.xQl;
      if (paramIntent != null)
      {
        paramIntent.notifyDataSetChanged();
        AppMethodBeat.o(233879);
        return;
      }
      AppMethodBeat.o(233879);
      return;
    case 1: 
      if (paramIntent != null)
      {
        locald = a.d.BuY;
        paramIntent = paramIntent.getSerializableExtra(a.d.emZ());
        label252:
        if ((paramIntent instanceof List)) {
          break label507;
        }
        paramIntent = (Intent)localObject1;
      }
      break;
    }
    label507:
    for (;;)
    {
      paramIntent = (List)paramIntent;
      if (paramIntent != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        com.tencent.mm.plugin.finder.live.utils.a.a(paramIntent, this.xQo);
        paramIntent = (Collection)this.xQo;
        if (paramIntent != null)
        {
          paramInt1 = j;
          if (!paramIntent.isEmpty()) {}
        }
        else
        {
          paramInt1 = 1;
        }
        if (paramInt1 == 0)
        {
          this.xQm |= 0x1;
          dvD();
        }
        dvB();
        paramIntent = this.xQl;
        if (paramIntent != null) {
          paramIntent.notifyDataSetChanged();
        }
      }
      Log.i(this.TAG, "onActivityResult REQUEST_CODE_SELECT_WHITE_LIST chooseWhiteList.size:" + this.xQo.size());
      AppMethodBeat.o(233879);
      return;
      paramIntent = null;
      break label252;
      localObject1 = localObject2;
      if (paramIntent != null) {
        localObject1 = paramIntent.getStringExtra("Select_Contact");
      }
      paramIntent = Util.stringToList((String)localObject1, ",");
      if (paramIntent == null) {
        break;
      }
      this.xQq.clear();
      this.xQq.addAll((Collection)paramIntent);
      paramIntent = (Collection)this.xQq;
      if ((paramIntent == null) || (paramIntent.isEmpty())) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0)
        {
          this.xQm |= 0x4;
          dvD();
        }
        dvB();
        paramIntent = this.xQl;
        if (paramIntent == null) {
          break;
        }
        paramIntent.notifyDataSetChanged();
        AppMethodBeat.o(233879);
        return;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(233877);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWhiteListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.cancel_tv;
      if (paramView != null) {
        break label119;
      }
      label59:
      i = b.f.finish_tv;
      if (paramView != null) {
        break label135;
      }
      label67:
      i = b.f.public_group;
      if (paramView != null) {
        break label151;
      }
      label75:
      i = b.f.share_group;
      if (paramView != null) {
        break label175;
      }
      label83:
      i = b.f.white_list_group;
      if (paramView != null) {
        break label186;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWhiteListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(233877);
      return;
      paramView = null;
      break;
      label119:
      if (paramView.intValue() != i) {
        break label59;
      }
      nQ(true);
      continue;
      label135:
      if (paramView.intValue() != i) {
        break label67;
      }
      nQ(false);
      continue;
      label151:
      if (paramView.intValue() != i) {
        break label75;
      }
      this.xQm = 0;
      MO(this.xQm);
      continue;
      label175:
      if (paramView.intValue() != i)
      {
        break label83;
        label186:
        if (paramView.intValue() == i) {
          dvC();
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233826);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle.getWindow().addFlags(2097280);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle.getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle.getWindow().clearFlags(67108864);
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle = paramBundle.getWindow();
      p.j(paramBundle, "context.window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "context.window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle.getWindow().addFlags(-2147483648);
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle = paramBundle.getWindow();
      p.j(paramBundle, "context.window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle = paramBundle.getWindow();
      p.j(paramBundle, "context.window");
      paramBundle.setNavigationBarColor(0);
    }
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle.getWindow().setFormat(-3);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle.getWindow().setSoftInputMode(51);
    Log.i(this.TAG, "[onCreate]");
    this.kGo = findViewById(b.f.title_group);
    paramBundle = this.kGo;
    if (paramBundle != null) {
      paramBundle.post((Runnable)new b(this));
    }
    this.xPY = ((TextView)findViewById(b.f.cancel_tv));
    paramBundle = this.xPY;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.xPZ = ((TextView)findViewById(b.f.finish_tv));
    paramBundle = this.xPZ;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.xQa = findViewById(b.f.public_group);
    paramBundle = this.xQa;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.xQb = ((WeImageView)findViewById(b.f.public_choose_icon));
    this.xQc = findViewById(b.f.share_group);
    paramBundle = this.xQc;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.xQd = ((WeImageView)findViewById(b.f.share_choose_icon));
    this.xQe = findViewById(b.f.white_list_group);
    paramBundle = this.xQe;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.xQf = ((WeImageView)findViewById(b.f.white_list_choose_icon));
    this.xQg = ((TextView)findViewById(b.f.white_list_title));
    this.xQh = ((TextView)findViewById(b.f.white_list_tips));
    this.xQi = ((ImageView)findViewById(b.f.white_list_fold_icon));
    this.xQj = findViewById(b.f.white_list_content_group);
    this.xQk = ((RecyclerView)findViewById(b.f.white_list_content_rv));
    this.xQl = new FinderLiveWhiteListGroupAdapter();
    paramBundle = this.xQl;
    if (paramBundle != null) {
      paramBundle.yZZ = ((kotlin.g.a.b)new a(this));
    }
    RecyclerView localRecyclerView = this.xQk;
    if (localRecyclerView != null)
    {
      localRecyclerView.getContext();
      localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      localRecyclerView.setAdapter((RecyclerView.a)this.xQl);
      localObject = localRecyclerView.getLayoutParams();
      paramBundle = (Bundle)localObject;
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        paramBundle = null;
      }
      paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
      if (paramBundle != null) {
        paramBundle.bottomMargin = ax.aB(localRecyclerView.getContext());
      }
    }
    paramBundle = getIntent();
    Object localObject = a.d.BuY;
    localObject = paramBundle.getSerializableExtra(a.d.emY());
    paramBundle = (Bundle)localObject;
    if (!(localObject instanceof List)) {
      paramBundle = null;
    }
    paramBundle = (List)paramBundle;
    if (paramBundle != null)
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a(paramBundle, this.xQn);
    }
    paramBundle = getIntent();
    localObject = a.d.BuY;
    localObject = paramBundle.getSerializableExtra(a.d.emZ());
    paramBundle = (Bundle)localObject;
    if (!(localObject instanceof List)) {
      paramBundle = null;
    }
    paramBundle = (List)paramBundle;
    if (paramBundle != null)
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a(paramBundle, this.xQo);
    }
    paramBundle = getIntent();
    localObject = a.d.BuY;
    paramBundle = paramBundle.getStringArrayListExtra(a.d.ena());
    if (paramBundle != null)
    {
      this.xQp.clear();
      this.xQp.addAll((Collection)paramBundle);
    }
    paramBundle = getIntent();
    localObject = a.d.BuY;
    paramBundle = paramBundle.getStringArrayListExtra(a.d.enb());
    if (paramBundle != null)
    {
      this.xQq.clear();
      this.xQq.addAll((Collection)paramBundle);
    }
    paramBundle = getIntent();
    localObject = a.d.BuY;
    this.xQr = paramBundle.getIntExtra(a.d.enc(), 0);
    paramBundle = getIntent();
    localObject = a.d.BuY;
    this.xQm = paramBundle.getIntExtra(a.d.emX(), 0);
    paramBundle = this.xQl;
    if (paramBundle != null)
    {
      localObject = this.xQn;
      p.k(localObject, "list");
      paramBundle.zax.clear();
      paramBundle.zax.addAll((Collection)localObject);
    }
    dvB();
    Log.i(this.TAG, "initLogic chooseMode:" + this.xQm + ", visitorWhiteList size:" + this.xQn.size() + ",chooseWhiteList size:" + this.xQo.size());
    paramBundle = (Collection)this.xQo;
    if ((paramBundle == null) || (paramBundle.isEmpty()))
    {
      i = 1;
      if (i == 0) {
        this.xQm |= 0x1;
      }
      paramBundle = (Collection)this.xQp;
      if ((paramBundle != null) && (!paramBundle.isEmpty())) {
        break label1132;
      }
      i = 1;
      label1061:
      if (i == 0) {
        this.xQm |= 0x2;
      }
      paramBundle = (Collection)this.xQq;
      if ((paramBundle != null) && (!paramBundle.isEmpty())) {
        break label1137;
      }
    }
    label1132:
    label1137:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.xQm |= 0x4;
      }
      MO(this.xQm);
      AppMethodBeat.o(233826);
      return;
      i = 0;
      break;
      i = 0;
      break label1061;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(233865);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(233865);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(233862);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(233862);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(233860);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(233860);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(233859);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(233859);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(233863);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(233863);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(233869);
    super.onSwipeBack();
    nQ(true);
    AppMethodBeat.o(233869);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setPublicGroup(View paramView)
  {
    this.xQa = paramView;
  }
  
  public final void setShareGroup(View paramView)
  {
    this.xQc = paramView;
  }
  
  public final void setTitleGroup(View paramView)
  {
    this.kGo = paramView;
  }
  
  public final void setWhiteListContent(View paramView)
  {
    this.xQj = paramView;
  }
  
  public final void setWhiteListGroup(View paramView)
  {
    this.xQe = paramView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "type", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWhiteListUI$initLayout$2$1"})
  static final class a
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    a(FinderLiveVisitorWhiteListUI paramFinderLiveVisitorWhiteListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderLiveVisitorWhiteListUI paramFinderLiveVisitorWhiteListUI) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(232444);
      int i = ax.getStatusBarHeight((Context)this.xQt.getContext());
      Object localObject1 = this.xQt.kGo;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).getLayoutParams();
        localObject2 = localObject1;
        if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          localObject2 = null;
        }
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        if (localObject2 != null) {
          ((ViewGroup.MarginLayoutParams)localObject2).topMargin = i;
        }
        localObject1 = this.xQt.kGo;
        if (localObject1 == null) {
          break label126;
        }
        localObject1 = ((View)localObject1).getParent();
        label81:
        if ((localObject1 instanceof ViewGroup)) {
          break label137;
        }
        localObject1 = localObject3;
      }
      label137:
      for (;;)
      {
        localObject1 = (ViewGroup)localObject1;
        if (localObject1 != null)
        {
          ((ViewGroup)localObject1).updateViewLayout(this.xQt.kGo, (ViewGroup.LayoutParams)localObject2);
          AppMethodBeat.o(232444);
          return;
          localObject1 = null;
          break;
          label126:
          localObject1 = null;
          break label81;
        }
        AppMethodBeat.o(232444);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWhiteListUI
 * JD-Core Version:    0.7.0.1
 */