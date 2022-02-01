package com.tencent.mm.plugin.finder.nearby.person;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.a.mj;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.nearby.f.b;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.f.f;
import com.tencent.mm.plugin.finder.nearby.f.g;
import com.tencent.mm.plugin.finder.nearby.f.h;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.component.g.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC;", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "adapter", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter;", "bindMobileHeader", "Lcom/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView;", "exitModeBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "exposePerson", "", "", "findItems", "", "[Ljava/lang/String;", "friendLV", "Landroid/widget/ListView;", "friendList", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "hasHeaderView", "", "hasLoadData", "hasLoadedData", "hasLocated", "hasShowGpsAlert", "hasShowLBSOpenDialog", "iGetLocation", "Lcom/tencent/mm/modelgeo/LocationGeo;", "isCancel", "isRequested", "lbsFindType", "", "location", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$Location;", "onLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "sayHiLayout", "Landroid/view/View;", "sayHiListener", "Lcom/tencent/mm/sdk/event/IListener;", "showBannerType", "showBindMobileHeaderFlag", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "vgHeaderContainer", "Landroid/view/ViewGroup;", "viewBtnSayHi", "viewLbsRoomEntry", "checkIfShowLbsRoom", "", "code", "scene", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "dismissLoadingDialog", "dismissTipDialog", "getLayoutId", "getLvHeaderContainer", "getSayHiLayout", "gotoContactInfoUI", "info", "gotoLbsRoom", "lbsRoom", "roomNickname", "handleItemClick", "position", "handleJoinRoomRequest", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "handleLbsClearLocation", "handleLbsError", "handleLbsFind", "handleLbsFindFriends", "hideLbsRoomEntryView", "hideLiveBottomSheet", "initADData", "initConfig", "initContentView", "isShowFinderFlag", "contactInfo", "isShowSnsFlag", "mergeADItemList", "onActionbarClick", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMenuClick", "onPause", "onResume", "onSceneEnd", "onUserVisibleFocused", "onUserVisibleUnFocused", "showClearLocationDialog", "showLBSOpenDialog", "okCallback", "Lkotlin/Function0;", "cancelCallback", "showLbsRoomEntry", "groupName", "memberCount", "showLbsTips", "showLiveBottomSheet", "showLoadingDialog", "sortFriendList", "startJoinLbsRoomRequest", "startLoadData", "updateSayHiLayout", "NearbyFriendAdapter", "PoiItemConverter", "ViewHolder", "plugin-finder-nearby_release"})
public final class b
  extends a
{
  private com.tencent.mm.modelgeo.d iQC;
  private boolean kUn;
  ListView mYU;
  private final com.tencent.mm.modelgeo.b.a tCp;
  private s tipDialog;
  private List<cqe> wtq;
  private boolean zHA;
  private int zHB;
  private boolean zHC;
  private int zHD;
  private boolean zHE;
  private boolean zHF;
  private int zHG;
  private a.c zHH;
  private boolean zHI;
  private boolean zHJ;
  private boolean zHK;
  com.tencent.mm.ui.widget.a.e zHL;
  private final IListener<?> zHM;
  private View zHN;
  private ViewGroup zHv;
  private List<String> zHw;
  private View zHx;
  private final View zHy;
  private a zHz;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(200257);
    this.zHw = ((List)new LinkedList());
    this.wtq = ((List)new LinkedList());
    this.zHD = 1;
    this.tCp = ((com.tencent.mm.modelgeo.b.a)new j(this));
    this.zHM = ((IListener)new n(this));
    AppMethodBeat.o(200257);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(200261);
    this.zHw = ((List)new LinkedList());
    this.wtq = ((List)new LinkedList());
    this.zHD = 1;
    this.tCp = ((com.tencent.mm.modelgeo.b.a)new j(this));
    this.zHM = ((IListener)new n(this));
    AppMethodBeat.o(200261);
  }
  
  private static boolean b(cqe paramcqe)
  {
    return (paramcqe.TxL != null) && ((paramcqe.TxL.mVJ & 0x1) > 0);
  }
  
  private final void cVG()
  {
    AppMethodBeat.i(200232);
    s locals = this.tipDialog;
    if (locals != null) {
      locals.dismiss();
    }
    this.tipDialog = null;
    AppMethodBeat.o(200232);
  }
  
  private final void dMf()
  {
    AppMethodBeat.i(200230);
    Log.i("NearbyPersonUIC", "showLbsTips");
    com.tencent.mm.plugin.nearby.a.mIG.bW((Context)getActivity());
    AppMethodBeat.o(200230);
  }
  
  private final void dMg()
  {
    AppMethodBeat.i(200231);
    Log.i("NearbyPersonUIC", "dismissTipDialog");
    cVG();
    AppMethodBeat.o(200231);
  }
  
  private final void dMh()
  {
    AppMethodBeat.i(200243);
    if ((com.tencent.mm.bw.a.hft()) || (com.tencent.mm.bw.a.hfs()))
    {
      ListView localListView;
      if (this.zHx != null)
      {
        localListView = this.mYU;
        if (localListView == null) {
          p.iCn();
        }
        localListView.removeHeaderView(this.zHx);
        this.zHx = null;
      }
      this.zHx = dMi();
      if (this.zHx != null)
      {
        localListView = this.mYU;
        if (localListView == null) {
          p.iCn();
        }
        localListView.addHeaderView(this.zHx);
      }
    }
    AppMethodBeat.o(200243);
  }
  
  private final View dMi()
  {
    AppMethodBeat.i(200244);
    Object localObject1 = View.inflate((Context)getActivity(), f.e.nearby_goto_sayhi_btn, null);
    Object localObject2 = ((View)localObject1).findViewById(f.d.say_hi_count);
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(200244);
      throw ((Throwable)localObject1);
    }
    localObject2 = (TextView)localObject2;
    com.tencent.mm.kernel.h.aHE().aGH();
    Object localObject3 = com.tencent.mm.kernel.h.ae(n.class);
    p.j(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
    localObject3 = ((n)localObject3).eSb();
    p.j(localObject3, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject3).cHo();
    if (i == 0)
    {
      p.j(localObject1, "viewToList");
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(200244);
      return null;
    }
    p.j(localObject1, "viewToList");
    ((View)localObject1).setVisibility(0);
    ((TextView)localObject2).setText((CharSequence)getActivity().getResources().getQuantityString(f.f.say_hi_count_text_quantity, i, new Object[] { Integer.valueOf(i) }));
    localObject2 = ((View)localObject1).findViewById(f.d.match_dlg_img);
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(200244);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ImageView)localObject2;
    localObject3 = com.tencent.mm.kernel.h.ae(n.class);
    p.j(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
    localObject3 = ((n)localObject3).eSb();
    p.j(localObject3, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
    localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject3).eSm();
    if (localObject3 != null) {
      a.b.c((ImageView)localObject2, ((bx)localObject3).field_sayhiuser);
    }
    ((View)localObject1).setOnClickListener((View.OnClickListener)new d(this));
    AppMethodBeat.o(200244);
    return localObject1;
  }
  
  private final void dMj()
  {
    AppMethodBeat.i(200249);
    Object localObject1 = (List)new LinkedList();
    int j = ((Collection)this.wtq).size();
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = b.zHT;
      if (!b.Ox(((cqe)this.wtq.get(i)).mVy)) {
        ((List)localObject1).add(this.wtq.get(i));
      }
      i += 1;
    }
    this.wtq.clear();
    this.wtq = ((List)localObject1);
    Log.i("NearbyPersonUIC", "mergeADItemList friendList size:" + this.wtq.size());
    label171:
    int k;
    if (!((Collection)this.wtq).isEmpty())
    {
      j = 1;
      localObject1 = this.zHm.keySet().iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label368;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      if (j == 0) {
        break label375;
      }
      localObject2 = (a.a)this.zHm.get(localObject2);
      if (localObject2 == null) {
        p.iCn();
      }
      if ((((a.a)localObject2).rED) || ((((a.a)localObject2).zHo > 0) && (((a.a)localObject2).zHr >= ((a.a)localObject2).zHo)) || (((a.a)localObject2).tzm >= ((a.a)localObject2).zHp)) {
        break label375;
      }
      List localList = this.wtq;
      if ((((a.a)localObject2).pos >= 0) && (((a.a)localObject2).pos <= this.wtq.size())) {
        break label357;
      }
      k = this.wtq.size();
      label304:
      b localb = b.zHT;
      localList.add(k, b.h(((a.a)localObject2).id, ((a.a)localObject2).icon, ((a.a)localObject2).name, ((a.a)localObject2).desc, ((a.a)localObject2).zHq));
      i += 1;
    }
    label357:
    label368:
    label375:
    for (;;)
    {
      break label171;
      j = 0;
      break;
      k = ((a.a)localObject2).pos + i;
      break label304;
      AppMethodBeat.o(200249);
      return;
    }
  }
  
  private final void dMk()
  {
    AppMethodBeat.i(200253);
    List localList = (List)new LinkedList();
    Iterator localIterator = this.wtq.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      cqe localcqe = (cqe)localIterator.next();
      com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(n.class);
      p.j(locala, "MMKernel.service(IMessengerStorage::class.java)");
      if (((n)locala).bbL().bwd(localcqe.UserName))
      {
        localList.add(i, localcqe);
        i += 1;
      }
      else if ((!Util.isNullOrNil(localcqe.UserName)) && (!Util.isNullOrNil(localcqe.TxE)))
      {
        localList.add(localcqe);
      }
    }
    this.wtq.clear();
    this.wtq = localList;
    AppMethodBeat.o(200253);
  }
  
  public final int getLayoutId()
  {
    return f.e.zDn;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200217);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.g.ada(11);
    paramBundle = com.tencent.mm.n.h.axc().getValue("LBSShowBindPhone");
    int i;
    if (paramBundle != null)
    {
      if (((CharSequence)paramBundle).length() <= 0) {
        break label329;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        paramBundle = Integer.valueOf(paramBundle);
        p.j(paramBundle, "Integer.valueOf(flag)");
        i = paramBundle.intValue();
        this.zHB = i;
        paramBundle = com.tencent.mm.kernel.h.aHG();
        p.j(paramBundle, "MMKernel.storage()");
        paramBundle = (String)paramBundle.aHp().get(6);
        if (paramBundle != null)
        {
          if (((CharSequence)paramBundle).length() <= 0) {
            break label340;
          }
          i = 1;
          if (i != 0) {
            this.zHB = 0;
          }
        }
        this.zHG = 0;
        if (com.tencent.mm.model.a.g.bga().Sk("3") != null)
        {
          paramBundle = com.tencent.mm.model.a.g.bga().Sk("3").getValue();
          localObject = com.tencent.mm.plugin.account.friend.a.l.byi();
          if (p.h(paramBundle, "0")) {
            this.zHG = 0;
          }
        }
        else
        {
          paramBundle = com.tencent.mm.kernel.h.aHG();
          p.j(paramBundle, "MMKernel.storage()");
          this.zHD = Util.nullAs((Integer)paramBundle.aHp().get(16386), 1);
          this.zHz = new a((Context)getActivity());
          this.mYU = ((ListView)getRootView().findViewById(f.d.nearby_friend_lv));
          paramBundle = this.mYU;
          if (paramBundle == null) {
            break label420;
          }
          if (this.zHv != null) {
            break label404;
          }
          this.zHv = ((ViewGroup)new LinearLayout((Context)getActivity()));
          localObject = this.zHv;
          if (localObject != null) {
            ((ViewGroup)localObject).setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, -2));
          }
          localObject = this.zHv;
          if (localObject != null) {
            break label395;
          }
          paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout");
          AppMethodBeat.o(200217);
          throw paramBundle;
          label329:
          i = 0;
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        for (;;)
        {
          i = 0;
          continue;
          label340:
          i = 0;
          continue;
          if (p.h(paramBundle, "2"))
          {
            if (localObject == l.a.mWl) {
              this.zHG = 2;
            }
          }
          else if ((p.h(paramBundle, "1")) && (localObject == l.a.mWi)) {
            this.zHG = 2;
          }
        }
        label395:
        ((LinearLayout)localObject).setGravity(17);
        label404:
        this.zHA = true;
        paramBundle.addHeaderView((View)this.zHv);
        label420:
        paramBundle = this.mYU;
        if (paramBundle != null) {
          paramBundle.setAdapter((ListAdapter)this.zHz);
        }
        paramBundle = this.mYU;
        if (paramBundle != null) {
          paramBundle.setOnItemClickListener((AdapterView.OnItemClickListener)new b.h(this));
        }
        paramBundle = this.mYU;
        if (paramBundle != null) {
          paramBundle.setOnTouchListener((View.OnTouchListener)new i(this));
        }
        Log.i("NearbyPersonUIC", "onCreate");
        AppMethodBeat.o(200217);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200228);
    super.onDestroy();
    if (this.zHG > 0) {
      com.tencent.mm.model.a.f.Sp("3");
    }
    com.tencent.mm.plugin.report.service.g.adc(11);
    com.tencent.mm.kernel.h.aGY().b(148, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().b(376, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().b(1087, (com.tencent.mm.an.i)this);
    dMg();
    Object localObject1 = this.iQC;
    if (localObject1 != null) {
      ((com.tencent.mm.modelgeo.d)localObject1).b(this.tCp);
    }
    com.tencent.mm.am.q.bhR().cancel();
    localObject1 = this.zHz;
    Object localObject2;
    if ((localObject1 != null) && (((a)localObject1).mVX != null))
    {
      localObject2 = ((a)localObject1).mVX;
      if (localObject2 == null) {
        p.iCn();
      }
      ((com.tencent.mm.ui.applet.b)localObject2).detach();
      ((a)localObject1).mVX = null;
    }
    if (this.wtq.size() > 0)
    {
      localObject2 = this.zHm.values().iterator();
      a.a locala;
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = locala.tzm)
      {
        locala = (a.a)((Iterator)localObject2).next();
        localObject1 = new StringBuilder().append((String)localObject1).append("|").append(locala.id).append(":").append(locala.zHr).append(":");
        locala.tzm += 1;
      }
      localObject2 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.Vxu, localObject1);
    }
    AppMethodBeat.o(200228);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(200226);
    Log.i("NearbyPersonUIC", "onPause");
    com.tencent.mm.modelgeo.d locald = this.iQC;
    if (locald != null) {
      locald.b(this.tCp);
    }
    EventCenter.instance.removeListener(this.zHM);
    this.kUn = true;
    AppMethodBeat.o(200226);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200224);
    Log.i("NearbyPersonUIC", "onResume");
    dMh();
    Object localObject = this.zHz;
    if (localObject == null) {
      p.iCn();
    }
    ((a)localObject).notifyDataSetChanged();
    com.tencent.mm.kernel.h.aHE().aGH();
    localObject = com.tencent.mm.kernel.h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((n)localObject).eSb();
    p.j(localObject, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
    if (((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject).cHo() == 0)
    {
      localObject = this.mYU;
      if (localObject == null) {
        p.iCn();
      }
      ((ListView)localObject).removeHeaderView(this.zHy);
    }
    EventCenter.instance.addListener(this.zHM);
    this.kUn = false;
    AppMethodBeat.o(200224);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(200241);
    p.k(paramq, "scene");
    Log.i("NearbyPersonUIC", "onSceneEnd scene.type:" + paramq.getType());
    cVG();
    if (paramq.getType() == 148)
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.nearby.model.NetSceneLbsFind");
        AppMethodBeat.o(200241);
        throw paramString;
      }
      int i = ((com.tencent.mm.plugin.nearby.a.c)paramq).ZB();
      if ((this.zHj == null) && ((i == 1) || (i == 3) || (i == 4))) {
        Log.e("NearbyPersonUIC", "handleFindLbsFriends sceneLbsFind:" + this.zHj + " code:" + i);
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.k(this));
        AppMethodBeat.o(200241);
        return;
        if ((this.zHC) && ((i == 1) || (i == 3) || (i == 4)))
        {
          Log.e("NearbyPersonUIC", "handleFindLbsFriends isDataReqed:" + this.zHC + " code:" + i);
        }
        else if ((this.zHk == null) && (i == 2))
        {
          Log.e("NearbyPersonUIC", "handleFindLbsFriends sceneClearLocation:" + this.zHk + " code:" + i);
        }
        else if (paramq.getType() != 148)
        {
          Log.e("NearbyPersonUIC", "handleFindLbsFriends type:" + paramq.getType());
        }
        else
        {
          Log.i("NearbyPersonUIC", "handleFindLbsFriends errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramString = (com.tencent.mm.plugin.nearby.a.c)paramq;
            if ((i == 1) || (i == 3) || (i == 4))
            {
              paramString = paramString.fiw();
              p.j(paramString, "scene.lbsList");
              this.wtq = paramString;
              if ((this.wtq == null) || (this.wtq.size() == 0))
              {
                paramString = getRootView().findViewById(f.d.nearby_friend_not_found);
                p.j(paramString, "rootView.findViewById<Vi….nearby_friend_not_found)");
                paramString.setVisibility(0);
                paramString = this.mYU;
                if (paramString == null) {
                  p.iCn();
                }
                paramString.setVisibility(8);
                dMf();
                com.tencent.mm.plugin.report.service.g.adc(11);
                switch (this.zHD)
                {
                default: 
                  this.zHD = 1;
                }
                this.zHC = true;
                this.zHj = null;
              }
            }
            else
            {
              if (((com.tencent.mm.plugin.nearby.a.c)paramq).ZB() == 2)
              {
                paramString = com.tencent.mm.plugin.finder.nearby.report.c.zJb;
                com.tencent.mm.plugin.finder.nearby.report.c.a("", 0L, "", "", "", 0L, 4L, 3L);
                com.tencent.mm.ui.base.h.d((Context)getActivity(), getString(f.h.nearby_friend_clear_location_ok), "", (DialogInterface.OnClickListener)new b.f(this));
                this.zHk = null;
                this.zHJ = false;
                paramString = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
                paramString = com.tencent.mm.ui.component.g.Xox;
                i.a.c(2, ((aj)com.tencent.mm.ui.component.g.b(getActivity()).i(aj.class)).ekY());
                paramString = com.tencent.mm.kernel.h.ag(ak.class);
                p.j(paramString, "MMKernel.plugin(IPluginFinder::class.java)");
                ((ak)paramString).getRedDotManager().aBd("NearbyPeopleFooterprintClear");
              }
              paramString = (com.tencent.mm.plugin.nearby.a.c)paramq;
              if (!paramString.fiu()) {
                break label1159;
              }
              paramq = getActivity().getString(f.h.nearby_lbsroom_name);
              p.j(paramq, "activity.getString(R.string.nearby_lbsroom_name)");
              paramInt1 = paramString.fiv();
              if (this.zHv == null) {
                break label1151;
              }
              if (this.zHN != null) {
                break label996;
              }
              this.zHN = View.inflate((Context)getActivity(), f.e.nearby_group_header_item, null);
              paramString = this.zHv;
              if (paramString == null) {
                p.iCn();
              }
              paramString.addView(this.zHN);
              paramString = this.zHN;
              if (paramString != null) {
                paramString.setOnClickListener((View.OnClickListener)new b.r(this));
              }
              label780:
              paramString = this.zHN;
              if (paramString == null) {
                break label1013;
              }
            }
            label996:
            label1013:
            for (paramString = (TextView)paramString.findViewById(f.d.nearby_group_title);; paramString = null)
            {
              if (paramString != null) {
                break label1018;
              }
              paramString = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
              AppMethodBeat.o(200241);
              throw paramString;
              dMk();
              if ((this.wtq == null) || (this.wtq.size() == 0))
              {
                paramString = getRootView().findViewById(f.d.nearby_friend_not_found);
                p.j(paramString, "rootView.findViewById<Vi….nearby_friend_not_found)");
                paramString.setVisibility(0);
                paramString = this.mYU;
                if (paramString == null) {
                  p.iCn();
                }
                paramString.setVisibility(8);
                break;
              }
              paramString = getRootView().findViewById(f.d.nearby_friend_not_found);
              p.j(paramString, "rootView.findViewById<Vi….nearby_friend_not_found)");
              paramString.setVisibility(8);
              dMj();
              paramString = this.zHz;
              if (paramString == null) {
                p.iCn();
              }
              paramString.notifyDataSetChanged();
              paramString = this.zHz;
              if (paramString == null) {
                p.iCn();
              }
              if (paramString.getCount() > 0)
              {
                paramString = this.mYU;
                if (paramString == null) {
                  p.iCn();
                }
                paramString.setSelection(0);
              }
              paramString = this.mYU;
              if (paramString == null) {
                p.iCn();
              }
              paramString.post((Runnable)b.g.zIe);
              break;
              paramString = this.zHN;
              if (paramString == null) {
                break label780;
              }
              paramString.setVisibility(0);
              break label780;
            }
            label1018:
            paramString.setText((CharSequence)paramq);
            if (paramInt1 != 0)
            {
              paramString = this.zHN;
              if (paramString != null) {}
              for (paramString = (TextView)paramString.findViewById(f.d.nearby_group_member_count); paramString == null; paramString = null)
              {
                paramString = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(200241);
                throw paramString;
              }
              paramq = af.aaBG;
              paramq = getActivity().getResources().getQuantityString(f.f.nearby_lbsroom_member_count, paramInt1, new Object[] { Integer.valueOf(paramInt1) });
              p.j(paramq, "activity.resources.getQu…memberCount, memberCount)");
              paramq = String.format(paramq, Arrays.copyOf(new Object[0], 0));
              p.j(paramq, "java.lang.String.format(format, *args)");
              paramString.setText((CharSequence)paramq);
            }
            for (;;)
            {
              label1151:
              this.zHE = true;
              break;
              label1159:
              if ((this.zHN != null) && (this.zHv != null))
              {
                paramString = this.zHN;
                if (paramString == null) {
                  p.iCn();
                }
                paramString.setVisibility(8);
              }
            }
          }
          paramInt1 = ((com.tencent.mm.plugin.nearby.a.c)paramq).ZB();
          if ((paramInt1 == 1) || (paramInt1 == 3) || (paramInt1 == 4))
          {
            paramq = getRootView().findViewById(f.d.nearby_friend_not_found);
            if (paramq == null)
            {
              paramString = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
              AppMethodBeat.o(200241);
              throw paramString;
            }
            TextView localTextView = (TextView)paramq;
            localTextView.setVisibility(0);
            dMf();
            Object localObject = null;
            paramq = localObject;
            if (paramString != null)
            {
              if (((CharSequence)paramString).length() <= 0) {
                break label1395;
              }
              paramInt1 = 1;
              label1296:
              paramq = localObject;
              if (paramInt1 != 0) {
                paramq = com.tencent.mm.h.a.Kb(paramString);
              }
            }
            if (paramq != null)
            {
              paramString = paramq.desc;
              label1321:
              if (paramString == null) {
                break label1410;
              }
              paramString = paramq.desc;
              p.j(paramString, "br.desc");
              if (((CharSequence)paramString).length() <= 0) {
                break label1405;
              }
              paramInt1 = 1;
              label1352:
              if (paramInt1 == 0) {
                break label1410;
              }
              localTextView.setText((CharSequence)paramq.desc);
            }
            for (;;)
            {
              paramString = this.mYU;
              if (paramString == null) {
                p.iCn();
              }
              paramString.setVisibility(8);
              this.zHj = null;
              break;
              label1395:
              paramInt1 = 0;
              break label1296;
              paramString = null;
              break label1321;
              label1405:
              paramInt1 = 0;
              break label1352;
              label1410:
              if (paramInt2 == -2001) {
                localTextView.setText((CharSequence)getString(f.h.nearby_friend_expose));
              } else {
                localTextView.setText((CharSequence)getString(f.h.nearby_friend_get_friend_fail));
              }
            }
          }
          if (paramInt1 == 2)
          {
            Toast.makeText((Context)getActivity(), f.h.nearby_friend_clear_location_failed, 1).show();
            this.zHk = null;
          }
        }
      }
    }
    if (paramq.getType() == 376)
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.nearby.model.NetSceneLbsRoom");
        AppMethodBeat.o(200241);
        throw paramString;
      }
      if (((com.tencent.mm.plugin.nearby.a.d)paramq).ZB() == 1)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.nearby.a.d)paramq).mye != null))
        {
          paramString = ((com.tencent.mm.plugin.nearby.a.d)paramq).mye;
          paramq = ((com.tencent.mm.plugin.nearby.a.d)paramq).GsA;
          p.j(paramString, "roomName");
          p.j(paramq, "roomNickname");
          com.tencent.mm.plugin.nearby.a.b.jo(paramString, paramq);
          paramq = new Intent();
          paramq.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.nearby.a.mIG.e(paramq, (Context)getActivity());
          AppMethodBeat.o(200241);
          return;
        }
        com.tencent.mm.ui.base.h.a((Context)getActivity(), f.h.nearby_lbsroom_join_failed, f.h.app_tip, (DialogInterface.OnClickListener)b.e.zId);
      }
    }
    AppMethodBeat.o(200241);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(200219);
    super.onUserVisibleFocused();
    kotlin.g.a.a locala1 = (kotlin.g.a.a)new m(this);
    kotlin.g.a.a locala2 = (kotlin.g.a.a)new b.l(this);
    if (!this.zHK)
    {
      View localView = View.inflate((Context)getActivity(), f.e.lbs_open_dialog_view, null);
      if (localView != null) {}
      for (localObject = localView.findViewById(f.d.lbs_open_dialog_cb); localObject == null; localObject = null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(200219);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setVisibility(4);
      com.tencent.mm.ui.base.h.a((Context)getActivity(), f.h.app_tip, f.h.app_ok, f.h.app_back, localView, (DialogInterface.OnClickListener)new b.p(locala1), (DialogInterface.OnClickListener)new b.q(locala2)).show();
      this.zHK = true;
    }
    Object localObject = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
    localObject = com.tencent.mm.ui.component.g.Xox;
    i.a.c(3, ((aj)com.tencent.mm.ui.component.g.b(getActivity()).i(aj.class)).ekY());
    Log.i("NearbyPersonUIC", "onUserVisibleFocused");
    AppMethodBeat.o(200219);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(200220);
    super.onUserVisibleUnFocused();
    Log.i("NearbyPersonUIC", "onUserVisibleUnFocused");
    AppMethodBeat.o(200220);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC;Landroid/content/Context;)V", "earlyGetHeadImg", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg;", "getter", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg$IGetUsername;", "detach", "", "getCount", "", "getItem", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setImgBmp", "img", "Landroid/widget/ImageView;", "url", "", "plugin-finder-nearby_release"})
  public final class a
    extends BaseAdapter
  {
    private final Context context;
    com.tencent.mm.ui.applet.b mVX;
    private com.tencent.mm.ui.applet.b.b mVY;
    
    public a()
    {
      AppMethodBeat.i(200690);
      this.context = localObject;
      this.mVX = new com.tencent.mm.ui.applet.b((com.tencent.mm.ui.applet.b.a)b.a.a.zHP);
      AppMethodBeat.o(200690);
    }
    
    private static void h(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(200689);
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        Log.e("NearbyPersonUIC", "setImgBmp url is empty");
        AppMethodBeat.o(200689);
        return;
      }
      if (paramImageView != null) {
        paramImageView.setImageBitmap(null);
      }
      Object localObject = new c.a();
      ((c.a)localObject).Wr(com.tencent.mm.plugin.image.d.bbW());
      ((c.a)localObject).bmF();
      ((c.a)localObject).bmI();
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(paramString, paramImageView, (com.tencent.mm.ay.a.a.c)localObject);
      AppMethodBeat.o(200689);
    }
    
    public final cqe Ow(int paramInt)
    {
      AppMethodBeat.i(200686);
      cqe localcqe = (cqe)b.a(b.this).get(paramInt);
      AppMethodBeat.o(200686);
      return localcqe;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(200665);
      int i = b.a(b.this).size();
      AppMethodBeat.o(200665);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    @SuppressLint({"ResourceType"})
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(200684);
      if (this.mVY == null) {
        this.mVY = ((com.tencent.mm.ui.applet.b.b)new b(this));
      }
      if (this.mVX != null)
      {
        paramViewGroup = this.mVX;
        if (paramViewGroup == null) {
          p.iCn();
        }
        paramViewGroup.a(paramInt, this.mVY);
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      TextView localTextView;
      label854:
      label1120:
      int i;
      label939:
      label1094:
      int j;
      if (paramView == null)
      {
        paramViewGroup = new b.c();
        paramView = View.inflate(this.context, f.e.zDm, null);
        localObject1 = paramView.findViewById(f.d.nearby_friend_name);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.mUr = ((TextView)localObject1);
        localObject1 = paramView.findViewById(f.d.nearby_friend_sign);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.zHV = ((TextView)localObject1);
        localObject1 = paramView.findViewById(f.d.nearby_friend_distance);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.zHU = ((TextView)localObject1);
        localObject1 = paramView.findViewById(f.d.nearby_friend_avatar_iv);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.mWb = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.nearby_friend_is_friend);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.mWc = ((TextView)localObject1);
        localObject1 = paramView.findViewById(f.d.nearby_friend_vuserinfo);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.zHW = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.nearby_friend_sns);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.zHX = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.finder_icon);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.zHY = ((View)localObject1);
        localObject1 = paramView.findViewById(f.d.nearby_friend_ad_icon_1);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.zIa = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.nearby_friend_ad_icon_2);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.zIb = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.nearby_friend_ad_icon_3);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.zIc = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.close_btn);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.kHA = ((ImageView)localObject1);
        localObject1 = paramViewGroup.zHX;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((ImageView)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.ci.a.aY(this.context, f.b.Edge_2A);
        ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.ci.a.aY(this.context, f.b.Edge_2A);
        localObject2 = paramViewGroup.zHX;
        if (localObject2 == null) {
          p.iCn();
        }
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject2 = paramViewGroup.zHY;
        if (localObject2 == null) {
          p.iCn();
        }
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = paramView.findViewById(f.d.nearby_friend_sex);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(200684);
          throw paramView;
        }
        paramViewGroup.zHZ = ((ImageView)localObject1);
        p.j(paramView, "convertView");
        paramView.setTag(paramViewGroup);
        localObject2 = (cqe)b.a(b.this).get(paramInt);
        localObject1 = paramViewGroup.mUr;
        if (localObject1 != null)
        {
          localObject3 = this.context;
          localObject4 = (CharSequence)((cqe)localObject2).rWI;
          localTextView = paramViewGroup.mUr;
          if (localTextView == null) {
            p.iCn();
          }
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject4, localTextView.getTextSize()));
        }
        if (b.b(b.this) != 1) {
          break label1519;
        }
        switch (((cqe)localObject2).mVy)
        {
        default: 
          localObject1 = paramViewGroup.zHZ;
          if (localObject1 != null) {
            ((ImageView)localObject1).setVisibility(8);
          }
          if (((cqe)localObject2).TxF != 0)
          {
            localObject1 = paramViewGroup.zHW;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(0);
            }
            localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.bes().uS(((cqe)localObject2).TxF), 2.0F);
            localObject3 = paramViewGroup.zHW;
            if (localObject3 != null)
            {
              ((ImageView)localObject3).setImageBitmap((Bitmap)localObject1);
              localObject1 = x.aazN;
            }
            localObject1 = paramViewGroup.zHZ;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.zHU;
            if (localObject1 != null) {
              ((TextView)localObject1).setText((CharSequence)((cqe)localObject2).TxE);
            }
            localObject1 = paramViewGroup.zIa;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.zIb;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.zIc;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.kHA;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            if ((localObject2 instanceof com.tencent.mm.plugin.nearby.a.a))
            {
              localObject3 = ((com.tencent.mm.plugin.nearby.a.a)localObject2).Gsx;
              if ((localObject3 == null) || (((LinkedList)localObject3).size() != 1)) {
                break label1567;
              }
              localObject1 = paramViewGroup.zIa;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              if (paramViewGroup == null) {
                break label1561;
              }
              localObject1 = paramViewGroup.zIa;
              localObject3 = ((LinkedList)localObject3).get(0);
              p.j(localObject3, "adIconUrl[0]");
              h((ImageView)localObject1, (String)localObject3);
              localObject1 = (a.a)b.this.zHm.get(((cqe)localObject2).UserName);
              if (localObject1 != null)
              {
                if (((a.a)localObject1).zHs != -1) {
                  break label1846;
                }
                paramInt = 0;
                label1158:
                ((a.a)localObject1).zHs = paramInt;
                if (((a.a)localObject1).zHo > 0)
                {
                  localObject1 = paramViewGroup.kHA;
                  if (localObject1 != null) {
                    ((ImageView)localObject1).setVisibility(0);
                  }
                }
              }
              localObject1 = paramViewGroup.kHA;
              if (localObject1 != null)
              {
                ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new c(this, (cqe)localObject2));
                localObject1 = x.aazN;
              }
            }
            if (((cqe)localObject2).mVB == null) {
              break label1912;
            }
            localObject1 = ((cqe)localObject2).mVB;
            p.j(localObject1, "contactInfo.Signature");
            localObject1 = (CharSequence)localObject1;
            i = 0;
            paramInt = ((CharSequence)localObject1).length() - 1;
            j = 0;
          }
          break;
        }
      }
      for (;;)
      {
        label1269:
        if (i > paramInt) {
          break label1888;
        }
        int k;
        if (j == 0)
        {
          k = i;
          label1284:
          if (((CharSequence)localObject1).charAt(k) > ' ') {
            break label1861;
          }
          k = 1;
        }
        for (;;)
        {
          if (j == 0)
          {
            if (k == 0)
            {
              j = 1;
              break label1269;
              paramViewGroup = paramView.getTag();
              if (paramViewGroup == null)
              {
                paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.ViewHolder");
                AppMethodBeat.o(200684);
                throw paramView;
              }
              paramViewGroup = (b.c)paramViewGroup;
              break;
              localObject1 = paramViewGroup.zHZ;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.zHZ;
              if (localObject1 != null)
              {
                ((ImageView)localObject1).setImageResource(f.g.ic_sex_male);
                localObject1 = x.aazN;
              }
              localObject1 = paramViewGroup.zHZ;
              if (localObject1 == null) {
                break label854;
              }
              ((ImageView)localObject1).setContentDescription((CharSequence)this.context.getString(f.h.male_Imgbtn));
              break label854;
              localObject1 = paramViewGroup.zHZ;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.zHZ;
              if (localObject1 != null)
              {
                ((ImageView)localObject1).setImageResource(f.g.ic_sex_female);
                localObject1 = x.aazN;
              }
              localObject1 = paramViewGroup.zHZ;
              if (localObject1 == null) {
                break label854;
              }
              ((ImageView)localObject1).setContentDescription((CharSequence)this.context.getString(f.h.female_Imgbtn));
              break label854;
              localObject1 = paramViewGroup.zHZ;
              if (localObject1 == null) {
                break label854;
              }
              ((ImageView)localObject1).setVisibility(8);
              break label854;
              label1519:
              localObject1 = paramViewGroup.zHZ;
              if (localObject1 == null) {
                break label854;
              }
              ((ImageView)localObject1).setVisibility(8);
              break label854;
              localObject1 = paramViewGroup.zHW;
              if (localObject1 == null) {
                break label939;
              }
              ((ImageView)localObject1).setVisibility(8);
              break label939;
              label1561:
              localObject1 = null;
              break label1094;
              label1567:
              if ((localObject3 != null) && (((LinkedList)localObject3).size() == 2))
              {
                localObject1 = paramViewGroup.zIa;
                if (localObject1 != null) {
                  ((ImageView)localObject1).setVisibility(0);
                }
                localObject1 = paramViewGroup.zIb;
                if (localObject1 != null) {
                  ((ImageView)localObject1).setVisibility(0);
                }
                localObject1 = paramViewGroup.zIa;
                localObject4 = ((LinkedList)localObject3).get(0);
                p.j(localObject4, "adIconUrl[0]");
                h((ImageView)localObject1, (String)localObject4);
                localObject1 = paramViewGroup.zIb;
                localObject3 = ((LinkedList)localObject3).get(1);
                p.j(localObject3, "adIconUrl[1]");
                h((ImageView)localObject1, (String)localObject3);
                break label1120;
              }
              if ((localObject3 == null) || (((LinkedList)localObject3).size() < 3)) {
                break label1120;
              }
              localObject1 = paramViewGroup.zIa;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.zIb;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.zIc;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.zIa;
              localObject4 = ((LinkedList)localObject3).get(0);
              p.j(localObject4, "adIconUrl[0]");
              h((ImageView)localObject1, (String)localObject4);
              localObject1 = paramViewGroup.zIb;
              localObject4 = ((LinkedList)localObject3).get(1);
              p.j(localObject4, "adIconUrl[1]");
              h((ImageView)localObject1, (String)localObject4);
              localObject1 = paramViewGroup.zIc;
              localObject3 = ((LinkedList)localObject3).get(2);
              p.j(localObject3, "adIconUrl[2]");
              h((ImageView)localObject1, (String)localObject3);
              break label1120;
              label1846:
              paramInt = ((a.a)localObject1).zHs;
              break label1158;
              k = paramInt;
              break label1284;
              label1861:
              k = 0;
              continue;
            }
            i += 1;
            break label1269;
          }
        }
        if (k == 0) {
          break label1888;
        }
        paramInt -= 1;
      }
      label1888:
      if (p.h(((CharSequence)localObject1).subSequence(i, paramInt + 1).toString(), ""))
      {
        label1912:
        localObject1 = paramViewGroup.zHV;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        if (!b.c((cqe)localObject2)) {
          break label2204;
        }
        localObject1 = paramViewGroup.zHX;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        if (!b.d((cqe)localObject2)) {
          break label2225;
        }
        localObject1 = paramViewGroup.zHY;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = b.b.zHT;
        if (!b.b.Ox(((cqe)localObject2).mVy)) {
          break label2287;
        }
        localObject1 = paramViewGroup.mWb;
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setImageBitmap(null);
          localObject1 = x.aazN;
        }
        localObject1 = new c.a();
        ((c.a)localObject1).Wr(com.tencent.mm.plugin.image.d.bbW());
        ((c.a)localObject1).bmF();
        ((c.a)localObject1).bmI();
        localObject1 = ((c.a)localObject1).bmL();
        com.tencent.mm.ay.q.bml().a(((cqe)localObject2).SjJ, paramViewGroup.mWb, (com.tencent.mm.ay.a.a.c)localObject1);
        if (!Util.isNullOrNil(((cqe)localObject2).mVD)) {
          break label2246;
        }
        paramViewGroup = paramViewGroup.mWc;
        if (paramViewGroup != null) {
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        label1955:
        label1980:
        paramView.post((Runnable)new d(this, (cqe)localObject2));
        AppMethodBeat.o(200684);
        return paramView;
        localObject1 = paramViewGroup.zHV;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
        localObject1 = paramViewGroup.zHV;
        if (localObject1 == null) {
          break;
        }
        localObject3 = this.context;
        localObject4 = (CharSequence)((cqe)localObject2).mVB;
        localTextView = paramViewGroup.zHV;
        if (localTextView == null) {
          p.iCn();
        }
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject4, localTextView.getTextSize()));
        break;
        label2204:
        localObject1 = paramViewGroup.zHX;
        if (localObject1 == null) {
          break label1955;
        }
        ((ImageView)localObject1).setVisibility(8);
        break label1955;
        label2225:
        localObject1 = paramViewGroup.zHY;
        if (localObject1 == null) {
          break label1980;
        }
        ((View)localObject1).setVisibility(8);
        break label1980;
        label2246:
        localObject1 = paramViewGroup.mWc;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)((cqe)localObject2).mVD);
        }
        paramViewGroup = paramViewGroup.mWc;
        if (paramViewGroup != null)
        {
          paramViewGroup.setVisibility(0);
          continue;
          label2287:
          a.b.c(paramViewGroup.mWb, ((cqe)localObject2).UserName);
          localObject1 = com.tencent.mm.kernel.h.ae(n.class);
          p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
          if (((n)localObject1).bbL().bwd(((cqe)localObject2).UserName))
          {
            localObject1 = paramViewGroup.mWc;
            if (localObject1 != null) {
              ((TextView)localObject1).setVisibility(0);
            }
            if (as.asD(((cqe)localObject2).TxF))
            {
              paramViewGroup = paramViewGroup.mWc;
              if (paramViewGroup != null) {
                paramViewGroup.setText((CharSequence)this.context.getString(f.h.nearby_friend_followed));
              }
            }
            else
            {
              localObject1 = com.tencent.mm.kernel.h.ae(n.class);
              p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
              localObject1 = ((n)localObject1).bbL().bwg(((cqe)localObject2).UserName);
              if (localObject1 != null)
              {
                localObject3 = paramViewGroup.mUr;
                if (localObject3 != null)
                {
                  localObject4 = this.context;
                  if (!Util.isNullOrNil(((as)localObject1).ays())) {
                    break label2543;
                  }
                }
              }
              label2543:
              for (localObject1 = ((cqe)localObject2).rWI;; localObject1 = ((as)localObject1).ays())
              {
                localObject1 = (CharSequence)localObject1;
                localTextView = paramViewGroup.mUr;
                if (localTextView == null) {
                  p.iCn();
                }
                ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject4, (CharSequence)localObject1, localTextView.getTextSize()));
                paramViewGroup = paramViewGroup.mWc;
                if (paramViewGroup == null) {
                  break;
                }
                paramViewGroup.setText((CharSequence)this.context.getString(f.h.nearby_friend_is_contact));
                break;
              }
            }
          }
          else
          {
            paramViewGroup = paramViewGroup.mWc;
            if (paramViewGroup != null) {
              paramViewGroup.setVisibility(8);
            }
          }
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter$getView$1", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg$IGetUsername;", "getMaxPos", "", "getUsername", "", "pos", "plugin-finder-nearby_release"})
    public static final class b
      implements com.tencent.mm.ui.applet.b.b
    {
      public final int byf()
      {
        AppMethodBeat.i(202726);
        int i = this.zHQ.getCount();
        AppMethodBeat.o(202726);
        return i;
      }
      
      public final String yk(int paramInt)
      {
        AppMethodBeat.i(202724);
        if ((paramInt < 0) || (paramInt >= this.zHQ.getCount()))
        {
          Log.e("NearbyPersonUIC", "pos is invalid");
          AppMethodBeat.o(202724);
          return null;
        }
        Object localObject = this.zHQ.Ow(paramInt);
        if (localObject != null)
        {
          localObject = ((cqe)localObject).UserName;
          AppMethodBeat.o(202724);
          return localObject;
        }
        AppMethodBeat.o(202724);
        return null;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(b.a parama, cqe paramcqe) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201078);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = (a.a)this.zHQ.zHO.zHm.get(this.zHR.UserName);
        if (paramView != null)
        {
          paramView.zHr += 1;
          paramView.rED = true;
          paramView.zHs |= 0x2;
        }
        b.c(this.zHQ.zHO);
        this.zHQ.notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201078);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(b.a parama, cqe paramcqe) {}
      
      public final void run()
      {
        AppMethodBeat.i(199680);
        Object localObject1 = com.tencent.mm.plugin.finder.nearby.report.c.zJb;
        Object localObject2 = this.zHR.UserName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        Object localObject3 = this.zHR.TxE;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        Object localObject4 = this.zHR.mVH;
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = "";
        }
        String str = this.zHR.mVA;
        localObject4 = str;
        if (str == null) {
          localObject4 = "";
        }
        boolean bool = b.c(this.zHR);
        p.k(localObject1, "userName");
        p.k(localObject2, "district");
        p.k(localObject3, "country");
        p.k(localObject4, "city");
        com.tencent.mm.plugin.finder.nearby.report.c.a((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, bool, 1L);
        AppMethodBeat.o(199680);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$PoiItemConverter;", "", "()V", "SEX_FOR_POI_ITEM", "", "convertToLbsContactInfo", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "id", "", "icon", "name", "desc", "value", "getPoiLink", "info", "isSexForPoiItem", "", "sexVal", "plugin-finder-nearby_release"})
  public static final class b
  {
    private static int zHS;
    public static final b zHT;
    
    static
    {
      AppMethodBeat.i(203612);
      zHT = new b();
      zHS = 10000;
      AppMethodBeat.o(203612);
    }
    
    public static boolean Ox(int paramInt)
    {
      return paramInt == zHS;
    }
    
    public static cqe h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(203610);
      com.tencent.mm.plugin.nearby.a.a locala = new com.tencent.mm.plugin.nearby.a.a();
      locala.mVy = zHS;
      locala.UserName = paramString1;
      locala.SjJ = paramString2;
      locala.TxE = paramString4;
      locala.rWI = paramString3;
      locala.mVz = paramString5;
      paramString1 = (cqe)locala;
      AppMethodBeat.o(203610);
      return paramString1;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$ViewHolder;", "", "()V", "adIconImg1", "Landroid/widget/ImageView;", "getAdIconImg1", "()Landroid/widget/ImageView;", "setAdIconImg1", "(Landroid/widget/ImageView;)V", "adIconImg2", "getAdIconImg2", "setAdIconImg2", "adIconImg3", "getAdIconImg3", "setAdIconImg3", "addState", "Landroid/widget/TextView;", "getAddState", "()Landroid/widget/TextView;", "setAddState", "(Landroid/widget/TextView;)V", "avatar", "getAvatar", "setAvatar", "closeBtn", "getCloseBtn", "setCloseBtn", "displayName", "getDisplayName", "setDisplayName", "distance", "getDistance", "setDistance", "finderFlagIv", "Landroid/view/View;", "getFinderFlagIv", "()Landroid/view/View;", "setFinderFlagIv", "(Landroid/view/View;)V", "sex", "getSex", "setSex", "sign", "getSign", "setSign", "snsFlagIv", "getSnsFlagIv", "setSnsFlagIv", "vuserinfoIv", "getVuserinfoIv", "setVuserinfoIv", "plugin-finder-nearby_release"})
  public static final class c
  {
    ImageView kHA;
    TextView mUr;
    ImageView mWb;
    TextView mWc;
    TextView zHU;
    TextView zHV;
    ImageView zHW;
    ImageView zHX;
    View zHY;
    ImageView zHZ;
    ImageView zIa;
    ImageView zIb;
    ImageView zIc;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200400);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$getSayHiLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = b.p(this.zHO);
      if (paramView == null) {
        p.iCn();
      }
      paramView.removeHeaderView(b.q(this.zHO));
      b.r(this.zHO);
      paramView = new Intent((Context)this.zHO.getActivity(), NearbySayHiListUI.class);
      paramView.putExtra("k_say_hi_type", 2);
      paramView.putExtra("show_clear_header", true);
      this.zHO.getActivity().startActivityForResult(paramView, 2009);
      paramView = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
      paramView = com.tencent.mm.ui.component.g.Xox;
      i.a.c(2, ((aj)com.tencent.mm.ui.component.g.b(this.zHO.getActivity()).i(aj.class)).ekY());
      paramView = com.tencent.mm.kernel.h.ag(ak.class);
      p.j(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
      ((ak)paramView).getRedDotManager().aBd("NearbyPeopleBubble");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$getSayHiLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200400);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class i
    implements View.OnTouchListener
  {
    i(b paramb) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(202050);
      if (b.i(this.zHO) != null)
      {
        paramView = b.i(this.zHO);
        if ((paramView != null) && (paramView.mVX != null))
        {
          paramView = paramView.mVX;
          if (paramView == null) {
            p.iCn();
          }
          paramView.B(paramMotionEvent);
        }
      }
      AppMethodBeat.o(202050);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "maccuracy", "altitude", "onGetLocation"})
  static final class j
    implements com.tencent.mm.modelgeo.b.a
  {
    j(b paramb) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(200756);
      if (b.t(this.zHO))
      {
        AppMethodBeat.o(200756);
        return false;
      }
      b.u(this.zHO);
      if (b.l(this.zHO))
      {
        b.v(this.zHO);
        com.tencent.mm.plugin.report.service.g.adc(11);
        AppMethodBeat.o(200756);
        return false;
      }
      Object localObject;
      if (paramBoolean)
      {
        if (b.w(this.zHO) != null)
        {
          localObject = b.w(this.zHO);
          if (localObject == null) {
            p.iCn();
          }
          ((s)localObject).setMessage((CharSequence)this.zHO.getString(com.tencent.mm.plugin.nearby.b.g.nearby_friend_finding));
        }
        b.a(this.zHO, new a.c(paramFloat2, paramFloat1, (int)paramDouble2));
        localObject = this.zHO;
        int i = b.b(this.zHO);
        a.c localc = b.x(this.zHO);
        if (localc == null) {
          p.iCn();
        }
        paramFloat1 = localc.lLs;
        localc = b.x(this.zHO);
        if (localc == null) {
          p.iCn();
        }
        paramFloat2 = localc.lLr;
        localc = b.x(this.zHO);
        if (localc == null) {
          p.iCn();
        }
        ((a)localObject).zHj = new com.tencent.mm.plugin.nearby.a.c(i, paramFloat1, paramFloat2, localc.zHu, paramInt, "", "");
        com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)this.zHO.zHj);
        Log.i("NearbyPersonUIC", "onGetLocation doScene");
      }
      for (;;)
      {
        AppMethodBeat.o(200756);
        return false;
        com.tencent.mm.plugin.report.service.g.adc(11);
        b.v(this.zHO);
        this.zHO.getRootView().findViewById(f.d.nearby_friend_locate_failed).setVisibility(0);
        localObject = b.p(this.zHO);
        if (localObject == null) {
          p.iCn();
        }
        ((ListView)localObject).setVisibility(8);
        b.o(this.zHO);
        if ((!b.y(this.zHO)) && (!com.tencent.mm.modelgeo.d.blr()))
        {
          b.z(this.zHO);
          com.tencent.mm.ui.base.h.a((Context)this.zHO.getActivity(), this.zHO.getString(f.h.gps_disable_tip), this.zHO.getString(f.h.app_tip), this.zHO.getString(f.h.jump_to_settings), this.zHO.getString(f.h.app_cancel), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(203908);
              com.tencent.mm.modelgeo.d.cW((Context)this.zIf.zHO.getActivity());
              AppMethodBeat.o(203908);
            }
          }, null);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$sayHiListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LbsSayHiEvent;", "callback", "", "event", "plugin-finder-nearby_release"})
  public static final class n
    extends IListener<mj>
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.n paramn) {}
      
      public final void run()
      {
        AppMethodBeat.i(202925);
        b.A(this.zIg.zHO);
        AppMethodBeat.o(202925);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class w
    implements DialogInterface.OnCancelListener
  {
    w(b paramb) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(202788);
      b.m(this.zHO);
      com.tencent.mm.plugin.report.service.g.adc(11);
      if (this.zHO.zHj != null) {
        com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)this.zHO.zHj);
      }
      Log.i("NearbyPersonUIC", "showLoadingDialog  [loading cancel] cancel in loading");
      if (!b.n(this.zHO)) {
        Log.i("NearbyPersonUIC", "showLoadingDialog [loading cancel] cancel in first loading");
      }
      AppMethodBeat.o(202788);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class x
    implements DialogInterface.OnCancelListener
  {
    x(b paramb) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(199551);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)this.zHO.zHl);
      AppMethodBeat.o(199551);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.b
 * JD-Core Version:    0.7.0.1
 */