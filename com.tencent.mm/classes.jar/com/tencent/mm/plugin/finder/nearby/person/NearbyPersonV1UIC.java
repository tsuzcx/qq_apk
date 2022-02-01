package com.tencent.mm.plugin.finder.nearby.person;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.z;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.ebj;
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
import com.tencent.mm.ui.applet.b.b;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.ae;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC;", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "adapter", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter;", "bindMobileHeader", "Lcom/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView;", "exitModeBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "exposePerson", "", "", "findItems", "", "[Ljava/lang/String;", "friendLV", "Landroid/widget/ListView;", "friendList", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "hasHeaderView", "", "hasLoadData", "hasLoadedData", "hasLocated", "hasShowGpsAlert", "hasShowLBSOpenDialog", "iGetLocation", "Lcom/tencent/mm/modelgeo/LocationGeo;", "isCancel", "isRequested", "lbsFindType", "", "location", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$Location;", "onLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "sayHiLayout", "Landroid/view/View;", "sayHiListener", "Lcom/tencent/mm/sdk/event/IListener;", "showBannerType", "showBindMobileHeaderFlag", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "vgHeaderContainer", "Landroid/view/ViewGroup;", "viewBtnSayHi", "viewLbsRoomEntry", "checkIfShowLbsRoom", "", "code", "scene", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "dismissLoadingDialog", "dismissTipDialog", "getLayoutId", "getLvHeaderContainer", "getSayHiLayout", "gotoContactInfoUI", "info", "gotoLbsRoom", "lbsRoom", "roomNickname", "handleItemClick", "position", "handleJoinRoomRequest", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "handleLbsClearLocation", "handleLbsError", "handleLbsFind", "handleLbsFindFriends", "hideLbsRoomEntryView", "hideLiveBottomSheet", "initADData", "initConfig", "initContentView", "isShowFinderFlag", "contactInfo", "isShowSnsFlag", "mergeADItemList", "onActionbarClick", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMenuClick", "onPause", "onResume", "onSceneEnd", "onUserVisibleFocused", "onUserVisibleUnFocused", "showClearLocationDialog", "showLBSOpenDialog", "okCallback", "Lkotlin/Function0;", "cancelCallback", "showLbsRoomEntry", "groupName", "memberCount", "showLbsTips", "showLiveBottomSheet", "showLoadingDialog", "sortFriendList", "startJoinLbsRoomRequest", "startLoadData", "updateSayHiLayout", "NearbyFriendAdapter", "PoiItemConverter", "ViewHolder", "plugin-finder_release"})
public final class NearbyPersonV1UIC
  extends NearbyPersonUIC
{
  private com.tencent.mm.modelgeo.d gmt;
  private boolean ifz;
  ListView khv;
  private final com.tencent.mm.modelgeo.b.a qgt;
  private List<chi> sNv;
  private com.tencent.mm.ui.base.q tipDialog;
  private ViewGroup uSh;
  private List<String> uSi;
  private View uSj;
  private final View uSk;
  private a uSl;
  private boolean uSm;
  private int uSn;
  private boolean uSo;
  private int uSp;
  private boolean uSq;
  private boolean uSr;
  private int uSs;
  private NearbyPersonUIC.c uSt;
  private boolean uSu;
  private boolean uSv;
  private boolean uSw;
  com.tencent.mm.ui.widget.a.e uSx;
  private final IListener<?> uSy;
  private View uSz;
  
  public NearbyPersonV1UIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(249321);
    this.uSi = ((List)new LinkedList());
    this.sNv = ((List)new LinkedList());
    this.uSp = 1;
    this.qgt = ((com.tencent.mm.modelgeo.b.a)new j(this));
    this.uSy = ((IListener)new n(this));
    AppMethodBeat.o(249321);
  }
  
  public NearbyPersonV1UIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(249320);
    this.uSi = ((List)new LinkedList());
    this.sNv = ((List)new LinkedList());
    this.uSp = 1;
    this.qgt = ((com.tencent.mm.modelgeo.b.a)new j(this));
    this.uSy = ((IListener)new n(this));
    AppMethodBeat.o(249320);
  }
  
  private static boolean b(chi paramchi)
  {
    return (paramchi.MmQ != null) && ((paramchi.MmQ.kej & 0x1) > 0);
  }
  
  private final void cGW()
  {
    AppMethodBeat.i(249314);
    com.tencent.mm.ui.base.q localq = this.tipDialog;
    if (localq != null) {
      localq.dismiss();
    }
    this.tipDialog = null;
    AppMethodBeat.o(249314);
  }
  
  private final void dlt()
  {
    AppMethodBeat.i(249312);
    Log.i("NearbyPersonUIC", "showLbsTips");
    com.tencent.mm.plugin.nearby.a.jRt.bY((Context)getActivity());
    AppMethodBeat.o(249312);
  }
  
  private final void dlu()
  {
    AppMethodBeat.i(249313);
    Log.i("NearbyPersonUIC", "dismissTipDialog");
    cGW();
    AppMethodBeat.o(249313);
  }
  
  private final void dlv()
  {
    AppMethodBeat.i(249316);
    if ((com.tencent.mm.bp.a.glC()) || (com.tencent.mm.bp.a.glB()))
    {
      ListView localListView;
      if (this.uSj != null)
      {
        localListView = this.khv;
        if (localListView == null) {
          kotlin.g.b.p.hyc();
        }
        localListView.removeHeaderView(this.uSj);
        this.uSj = null;
      }
      this.uSj = dlw();
      if (this.uSj != null)
      {
        localListView = this.khv;
        if (localListView == null) {
          kotlin.g.b.p.hyc();
        }
        localListView.addHeaderView(this.uSj);
      }
    }
    AppMethodBeat.o(249316);
  }
  
  private final View dlw()
  {
    AppMethodBeat.i(249317);
    Object localObject1 = View.inflate((Context)getActivity(), 2131495818, null);
    Object localObject2 = ((View)localObject1).findViewById(2131307220);
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(249317);
      throw ((Throwable)localObject1);
    }
    localObject2 = (TextView)localObject2;
    com.tencent.mm.kernel.g.aAf().azk();
    Object localObject3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    kotlin.g.b.p.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
    localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).eiv();
    kotlin.g.b.p.g(localObject3, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject3).ctM();
    if (i == 0)
    {
      kotlin.g.b.p.g(localObject1, "viewToList");
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(249317);
      return null;
    }
    kotlin.g.b.p.g(localObject1, "viewToList");
    ((View)localObject1).setVisibility(0);
    ((TextView)localObject2).setText((CharSequence)getActivity().getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
    localObject2 = ((View)localObject1).findViewById(2131304534);
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(249317);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ImageView)localObject2;
    localObject3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    kotlin.g.b.p.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
    localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).eiv();
    kotlin.g.b.p.g(localObject3, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
    localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject3).eiG();
    if (localObject3 != null) {
      a.b.c((ImageView)localObject2, ((bx)localObject3).field_sayhiuser);
    }
    ((View)localObject1).setOnClickListener((View.OnClickListener)new NearbyPersonV1UIC.d(this));
    AppMethodBeat.o(249317);
    return localObject1;
  }
  
  private final void dlx()
  {
    AppMethodBeat.i(249318);
    Object localObject1 = (List)new LinkedList();
    int j = ((Collection)this.sNv).size();
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = b.uSF;
      if (!b.JD(((chi)this.sNv.get(i)).kdY)) {
        ((List)localObject1).add(this.sNv.get(i));
      }
      i += 1;
    }
    this.sNv.clear();
    this.sNv = ((List)localObject1);
    Log.i("NearbyPersonUIC", "mergeADItemList friendList size:" + this.sNv.size());
    label171:
    int k;
    if (!((Collection)this.sNv).isEmpty())
    {
      j = 1;
      localObject1 = this.uRY.keySet().iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label368;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      if (j == 0) {
        break label375;
      }
      localObject2 = (NearbyPersonUIC.a)this.uRY.get(localObject2);
      if (localObject2 == null) {
        kotlin.g.b.p.hyc();
      }
      if ((((NearbyPersonUIC.a)localObject2).oBV) || ((((NearbyPersonUIC.a)localObject2).uSa > 0) && (((NearbyPersonUIC.a)localObject2).uSe >= ((NearbyPersonUIC.a)localObject2).uSa)) || (((NearbyPersonUIC.a)localObject2).qdp >= ((NearbyPersonUIC.a)localObject2).uSb)) {
        break label375;
      }
      List localList = this.sNv;
      if ((((NearbyPersonUIC.a)localObject2).pos >= 0) && (((NearbyPersonUIC.a)localObject2).pos <= this.sNv.size())) {
        break label357;
      }
      k = this.sNv.size();
      label304:
      b localb = b.uSF;
      localList.add(k, b.h(((NearbyPersonUIC.a)localObject2).id, ((NearbyPersonUIC.a)localObject2).icon, ((NearbyPersonUIC.a)localObject2).name, ((NearbyPersonUIC.a)localObject2).desc, ((NearbyPersonUIC.a)localObject2).uSd));
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
      k = ((NearbyPersonUIC.a)localObject2).pos + i;
      break label304;
      AppMethodBeat.o(249318);
      return;
    }
  }
  
  private final void dly()
  {
    AppMethodBeat.i(249319);
    List localList = (List)new LinkedList();
    Iterator localIterator = this.sNv.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      chi localchi = (chi)localIterator.next();
      com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      kotlin.g.b.p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)locala).aSN().bjG(localchi.UserName))
      {
        localList.add(i, localchi);
        i += 1;
      }
      else if ((!Util.isNullOrNil(localchi.UserName)) && (!Util.isNullOrNil(localchi.MmJ)))
      {
        localList.add(localchi);
      }
    }
    this.sNv.clear();
    this.sNv = localList;
    AppMethodBeat.o(249319);
  }
  
  public final int getLayoutId()
  {
    return 2131495833;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249306);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.g.Wl(11);
    paramBundle = com.tencent.mm.n.h.aqJ().getValue("LBSShowBindPhone");
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
        kotlin.g.b.p.g(paramBundle, "Integer.valueOf(flag)");
        i = paramBundle.intValue();
        this.uSn = i;
        paramBundle = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(paramBundle, "MMKernel.storage()");
        paramBundle = (String)paramBundle.azQ().get(6);
        if (paramBundle != null)
        {
          if (((CharSequence)paramBundle).length() <= 0) {
            break label340;
          }
          i = 1;
          if (i != 0) {
            this.uSn = 0;
          }
        }
        this.uSs = 0;
        if (com.tencent.mm.model.a.g.aWT().KR("3") != null)
        {
          paramBundle = com.tencent.mm.model.a.g.aWT().KR("3").getValue();
          localObject = com.tencent.mm.plugin.account.friend.a.l.bnZ();
          if (kotlin.g.b.p.j(paramBundle, "0")) {
            this.uSs = 0;
          }
        }
        else
        {
          paramBundle = com.tencent.mm.kernel.g.aAh();
          kotlin.g.b.p.g(paramBundle, "MMKernel.storage()");
          this.uSp = Util.nullAs((Integer)paramBundle.azQ().get(16386), 1);
          this.uSl = new a((Context)getActivity());
          this.khv = ((ListView)getRootView().findViewById(2131305246));
          paramBundle = this.khv;
          if (paramBundle == null) {
            break label420;
          }
          if (this.uSh != null) {
            break label404;
          }
          this.uSh = ((ViewGroup)new LinearLayout((Context)getActivity()));
          localObject = this.uSh;
          if (localObject != null) {
            ((ViewGroup)localObject).setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, -2));
          }
          localObject = this.uSh;
          if (localObject != null) {
            break label395;
          }
          paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout");
          AppMethodBeat.o(249306);
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
          if (kotlin.g.b.p.j(paramBundle, "2"))
          {
            if (localObject == l.a.keM) {
              this.uSs = 2;
            }
          }
          else if ((kotlin.g.b.p.j(paramBundle, "1")) && (localObject == l.a.keJ)) {
            this.uSs = 2;
          }
        }
        label395:
        ((LinearLayout)localObject).setGravity(17);
        label404:
        this.uSm = true;
        paramBundle.addHeaderView((View)this.uSh);
        label420:
        paramBundle = this.khv;
        if (paramBundle != null) {
          paramBundle.setAdapter((ListAdapter)this.uSl);
        }
        paramBundle = this.khv;
        if (paramBundle != null) {
          paramBundle.setOnItemClickListener((AdapterView.OnItemClickListener)new NearbyPersonV1UIC.h(this));
        }
        paramBundle = this.khv;
        if (paramBundle != null) {
          paramBundle.setOnTouchListener((View.OnTouchListener)new i(this));
        }
        Log.i("NearbyPersonUIC", "onCreate");
        AppMethodBeat.o(249306);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(249311);
    super.onDestroy();
    if (this.uSs > 0) {
      com.tencent.mm.model.a.f.KW("3");
    }
    com.tencent.mm.plugin.report.service.g.Wn(11);
    com.tencent.mm.kernel.g.azz().b(148, (com.tencent.mm.ak.i)this);
    com.tencent.mm.kernel.g.azz().b(376, (com.tencent.mm.ak.i)this);
    com.tencent.mm.kernel.g.azz().b(1087, (com.tencent.mm.ak.i)this);
    dlu();
    Object localObject1 = this.gmt;
    if (localObject1 != null) {
      ((com.tencent.mm.modelgeo.d)localObject1).c(this.qgt);
    }
    com.tencent.mm.aj.p.aYD().cancel();
    localObject1 = this.uSl;
    Object localObject2;
    if ((localObject1 != null) && (((a)localObject1).kex != null))
    {
      localObject2 = ((a)localObject1).kex;
      if (localObject2 == null) {
        kotlin.g.b.p.hyc();
      }
      ((com.tencent.mm.ui.applet.b)localObject2).detach();
      ((a)localObject1).kex = null;
    }
    if (this.sNv.size() > 0)
    {
      localObject2 = this.uRY.values().iterator();
      NearbyPersonUIC.a locala;
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = locala.qdp)
      {
        locala = (NearbyPersonUIC.a)((Iterator)localObject2).next();
        localObject1 = new StringBuilder().append((String)localObject1).append("|").append(locala.id).append(":").append(locala.uSe).append(":");
        locala.qdp += 1;
      }
      localObject2 = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(localObject2, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject2).azQ().set(ar.a.Oje, localObject1);
    }
    AppMethodBeat.o(249311);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(249310);
    Log.i("NearbyPersonUIC", "onPause");
    com.tencent.mm.modelgeo.d locald = this.gmt;
    if (locald != null) {
      locald.c(this.qgt);
    }
    EventCenter.instance.removeListener(this.uSy);
    this.ifz = true;
    AppMethodBeat.o(249310);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(249309);
    Log.i("NearbyPersonUIC", "onResume");
    dlv();
    Object localObject = this.uSl;
    if (localObject == null) {
      kotlin.g.b.p.hyc();
    }
    ((a)localObject).notifyDataSetChanged();
    com.tencent.mm.kernel.g.aAf().azk();
    localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    kotlin.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).eiv();
    kotlin.g.b.p.g(localObject, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
    if (((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject).ctM() == 0)
    {
      localObject = this.khv;
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      ((ListView)localObject).removeHeaderView(this.uSk);
    }
    EventCenter.instance.addListener(this.uSy);
    this.ifz = false;
    AppMethodBeat.o(249309);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(249315);
    kotlin.g.b.p.h(paramq, "scene");
    Log.i("NearbyPersonUIC", "onSceneEnd scene.type:" + paramq.getType());
    cGW();
    if (paramq.getType() == 148)
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.nearby.model.NetSceneLbsFind");
        AppMethodBeat.o(249315);
        throw paramString;
      }
      int i = ((com.tencent.mm.plugin.nearby.a.c)paramq).Vj();
      if ((this.uRV == null) && ((i == 1) || (i == 3) || (i == 4))) {
        Log.e("NearbyPersonUIC", "handleFindLbsFriends sceneLbsFind:" + this.uRV + " code:" + i);
      }
      for (;;)
      {
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new NearbyPersonV1UIC.k(this));
        AppMethodBeat.o(249315);
        return;
        if ((this.uSo) && ((i == 1) || (i == 3) || (i == 4)))
        {
          Log.e("NearbyPersonUIC", "handleFindLbsFriends isDataReqed:" + this.uSo + " code:" + i);
        }
        else if ((this.uRW == null) && (i == 2))
        {
          Log.e("NearbyPersonUIC", "handleFindLbsFriends sceneClearLocation:" + this.uRW + " code:" + i);
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
              paramString = paramString.ewT();
              kotlin.g.b.p.g(paramString, "scene.lbsList");
              this.sNv = paramString;
              if ((this.sNv == null) || (this.sNv.size() == 0))
              {
                paramString = getRootView().findViewById(2131305248);
                kotlin.g.b.p.g(paramString, "rootView.findViewById<Vi….nearby_friend_not_found)");
                paramString.setVisibility(0);
                paramString = this.khv;
                if (paramString == null) {
                  kotlin.g.b.p.hyc();
                }
                paramString.setVisibility(8);
                dlt();
                com.tencent.mm.plugin.report.service.g.Wn(11);
                switch (this.uSp)
                {
                default: 
                  this.uSp = 1;
                }
                this.uSo = true;
                this.uRV = null;
              }
            }
            else
            {
              if (((com.tencent.mm.plugin.nearby.a.c)paramq).Vj() == 2)
              {
                paramString = com.tencent.mm.plugin.finder.nearby.report.b.uSZ;
                com.tencent.mm.plugin.finder.nearby.report.b.a("", 0L, "", "", "", 0L, 4L, 3L);
                com.tencent.mm.ui.base.h.d((Context)getActivity(), getString(2131763439), "", (DialogInterface.OnClickListener)new NearbyPersonV1UIC.f(this));
                this.uRW = null;
                this.uSv = false;
                paramString = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
                paramString = com.tencent.mm.ui.component.a.PRN;
                i.a.c(2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx());
                paramString = com.tencent.mm.kernel.g.ah(aj.class);
                kotlin.g.b.p.g(paramString, "MMKernel.plugin(IPluginFinder::class.java)");
                ((aj)paramString).getRedDotManager().asV("NearbyPeopleFooterprintClear");
              }
              paramString = (com.tencent.mm.plugin.nearby.a.c)paramq;
              if (!paramString.ewR()) {
                break label1159;
              }
              paramq = getActivity().getString(2131763466);
              kotlin.g.b.p.g(paramq, "activity.getString(R.string.nearby_lbsroom_name)");
              paramInt1 = paramString.ewS();
              if (this.uSh == null) {
                break label1151;
              }
              if (this.uSz != null) {
                break label996;
              }
              this.uSz = View.inflate((Context)getActivity(), 2131495819, null);
              paramString = this.uSh;
              if (paramString == null) {
                kotlin.g.b.p.hyc();
              }
              paramString.addView(this.uSz);
              paramString = this.uSz;
              if (paramString != null) {
                paramString.setOnClickListener((View.OnClickListener)new NearbyPersonV1UIC.r(this));
              }
              label780:
              paramString = this.uSz;
              if (paramString == null) {
                break label1013;
              }
            }
            label996:
            label1013:
            for (paramString = (TextView)paramString.findViewById(2131305254);; paramString = null)
            {
              if (paramString != null) {
                break label1018;
              }
              paramString = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
              AppMethodBeat.o(249315);
              throw paramString;
              dly();
              if ((this.sNv == null) || (this.sNv.size() == 0))
              {
                paramString = getRootView().findViewById(2131305248);
                kotlin.g.b.p.g(paramString, "rootView.findViewById<Vi….nearby_friend_not_found)");
                paramString.setVisibility(0);
                paramString = this.khv;
                if (paramString == null) {
                  kotlin.g.b.p.hyc();
                }
                paramString.setVisibility(8);
                break;
              }
              paramString = getRootView().findViewById(2131305248);
              kotlin.g.b.p.g(paramString, "rootView.findViewById<Vi….nearby_friend_not_found)");
              paramString.setVisibility(8);
              dlx();
              paramString = this.uSl;
              if (paramString == null) {
                kotlin.g.b.p.hyc();
              }
              paramString.notifyDataSetChanged();
              paramString = this.uSl;
              if (paramString == null) {
                kotlin.g.b.p.hyc();
              }
              if (paramString.getCount() > 0)
              {
                paramString = this.khv;
                if (paramString == null) {
                  kotlin.g.b.p.hyc();
                }
                paramString.setSelection(0);
              }
              paramString = this.khv;
              if (paramString == null) {
                kotlin.g.b.p.hyc();
              }
              paramString.post((Runnable)NearbyPersonV1UIC.g.uSQ);
              break;
              paramString = this.uSz;
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
              paramString = this.uSz;
              if (paramString != null) {}
              for (paramString = (TextView)paramString.findViewById(2131305253); paramString == null; paramString = null)
              {
                paramString = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(249315);
                throw paramString;
              }
              paramq = ae.SYK;
              paramq = getActivity().getResources().getQuantityString(2131623958, paramInt1, new Object[] { Integer.valueOf(paramInt1) });
              kotlin.g.b.p.g(paramq, "activity.resources.getQu…memberCount, memberCount)");
              paramq = String.format(paramq, Arrays.copyOf(new Object[0], 0));
              kotlin.g.b.p.g(paramq, "java.lang.String.format(format, *args)");
              paramString.setText((CharSequence)paramq);
            }
            for (;;)
            {
              label1151:
              this.uSq = true;
              break;
              label1159:
              if ((this.uSz != null) && (this.uSh != null))
              {
                paramString = this.uSz;
                if (paramString == null) {
                  kotlin.g.b.p.hyc();
                }
                paramString.setVisibility(8);
              }
            }
          }
          paramInt1 = ((com.tencent.mm.plugin.nearby.a.c)paramq).Vj();
          if ((paramInt1 == 1) || (paramInt1 == 3) || (paramInt1 == 4))
          {
            paramq = getRootView().findViewById(2131305248);
            if (paramq == null)
            {
              paramString = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
              AppMethodBeat.o(249315);
              throw paramString;
            }
            TextView localTextView = (TextView)paramq;
            localTextView.setVisibility(0);
            dlt();
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
                paramq = com.tencent.mm.h.a.Dk(paramString);
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
              kotlin.g.b.p.g(paramString, "br.desc");
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
              paramString = this.khv;
              if (paramString == null) {
                kotlin.g.b.p.hyc();
              }
              paramString.setVisibility(8);
              this.uRV = null;
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
                localTextView.setText((CharSequence)getString(2131763441));
              } else {
                localTextView.setText((CharSequence)getString(2131763445));
              }
            }
          }
          if (paramInt1 == 2)
          {
            Toast.makeText((Context)getActivity(), 2131763438, 1).show();
            this.uRW = null;
          }
        }
      }
    }
    if (paramq.getType() == 376)
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.nearby.model.NetSceneLbsRoom");
        AppMethodBeat.o(249315);
        throw paramString;
      }
      if (((com.tencent.mm.plugin.nearby.a.d)paramq).Vj() == 1)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.nearby.a.d)paramq).jHa != null))
        {
          paramString = ((com.tencent.mm.plugin.nearby.a.d)paramq).jHa;
          paramq = ((com.tencent.mm.plugin.nearby.a.d)paramq).Azx;
          kotlin.g.b.p.g(paramString, "roomName");
          kotlin.g.b.p.g(paramq, "roomNickname");
          com.tencent.mm.plugin.nearby.a.b.jc(paramString, paramq);
          paramq = new Intent();
          paramq.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.nearby.a.jRt.e(paramq, (Context)getActivity());
          AppMethodBeat.o(249315);
          return;
        }
        com.tencent.mm.ui.base.h.a((Context)getActivity(), 2131763464, 2131755998, (DialogInterface.OnClickListener)NearbyPersonV1UIC.e.uSP);
      }
    }
    AppMethodBeat.o(249315);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(249307);
    super.onUserVisibleFocused();
    kotlin.g.a.a locala1 = (kotlin.g.a.a)new m(this);
    kotlin.g.a.a locala2 = (kotlin.g.a.a)new NearbyPersonV1UIC.l(this);
    if (!this.uSw)
    {
      View localView = View.inflate((Context)getActivity(), 2131495206, null);
      if (localView != null) {}
      for (localObject = localView.findViewById(2131303120); localObject == null; localObject = null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(249307);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setVisibility(4);
      com.tencent.mm.ui.base.h.a((Context)getActivity(), localView, (DialogInterface.OnClickListener)new NearbyPersonV1UIC.p(locala1), (DialogInterface.OnClickListener)new NearbyPersonV1UIC.q(locala2)).show();
      this.uSw = true;
    }
    Object localObject = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
    localObject = com.tencent.mm.ui.component.a.PRN;
    i.a.c(3, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx());
    Log.i("NearbyPersonUIC", "onUserVisibleFocused");
    AppMethodBeat.o(249307);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(249308);
    super.onUserVisibleUnFocused();
    Log.i("NearbyPersonUIC", "onUserVisibleUnFocused");
    AppMethodBeat.o(249308);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC;Landroid/content/Context;)V", "earlyGetHeadImg", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg;", "getter", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg$IGetUsername;", "detach", "", "getCount", "", "getItem", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setImgBmp", "img", "Landroid/widget/ImageView;", "url", "", "plugin-finder_release"})
  public final class a
    extends BaseAdapter
  {
    private final Context context;
    com.tencent.mm.ui.applet.b kex;
    private b.b kez;
    
    public a()
    {
      AppMethodBeat.i(249276);
      this.context = localObject;
      this.kex = new com.tencent.mm.ui.applet.b((com.tencent.mm.ui.applet.b.a)NearbyPersonV1UIC.a.a.uSB);
      AppMethodBeat.o(249276);
    }
    
    private static void f(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(249275);
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        Log.e("NearbyPersonUIC", "setImgBmp url is empty");
        AppMethodBeat.o(249275);
        return;
      }
      if (paramImageView != null) {
        paramImageView.setImageBitmap(null);
      }
      Object localObject = new c.a();
      ((c.a)localObject).OT(com.tencent.mm.plugin.image.d.aSY());
      ((c.a)localObject).bdp();
      ((c.a)localObject).bds();
      localObject = ((c.a)localObject).bdv();
      com.tencent.mm.av.q.bcV().a(paramString, paramImageView, (com.tencent.mm.av.a.a.c)localObject);
      AppMethodBeat.o(249275);
    }
    
    public final chi JC(int paramInt)
    {
      AppMethodBeat.i(249273);
      chi localchi = (chi)NearbyPersonV1UIC.a(NearbyPersonV1UIC.this).get(paramInt);
      AppMethodBeat.o(249273);
      return localchi;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(249271);
      int i = NearbyPersonV1UIC.a(NearbyPersonV1UIC.this).size();
      AppMethodBeat.o(249271);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    @SuppressLint({"ResourceType"})
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(249272);
      if (this.kez == null) {
        this.kez = ((b.b)new b(this));
      }
      if (this.kex != null)
      {
        paramViewGroup = this.kex;
        if (paramViewGroup == null) {
          kotlin.g.b.p.hyc();
        }
        paramViewGroup.a(paramInt, this.kez);
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      TextView localTextView;
      label838:
      label1104:
      label1142:
      int i;
      label923:
      label1078:
      int j;
      if (paramView == null)
      {
        paramViewGroup = new NearbyPersonV1UIC.c();
        paramView = View.inflate(this.context, 2131495832, null);
        localObject1 = paramView.findViewById(2131305247);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.kcS = ((TextView)localObject1);
        localObject1 = paramView.findViewById(2131305250);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.uSH = ((TextView)localObject1);
        localObject1 = paramView.findViewById(2131305242);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.uSG = ((TextView)localObject1);
        localObject1 = paramView.findViewById(2131305241);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.keC = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(2131305244);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.keD = ((TextView)localObject1);
        localObject1 = paramView.findViewById(2131305252);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.uSI = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(2131305251);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.uSJ = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(2131300851);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.uSK = ((View)localObject1);
        localObject1 = paramView.findViewById(2131305238);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.uSM = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(2131305239);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.uSN = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(2131305240);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.uSO = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(2131298770);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.hTd = ((ImageView)localObject1);
        localObject1 = paramViewGroup.uSJ;
        if (localObject1 == null) {
          kotlin.g.b.p.hyc();
        }
        localObject1 = ((ImageView)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.aG(this.context, 2131165296);
        ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.aG(this.context, 2131165296);
        localObject2 = paramViewGroup.uSJ;
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject2 = paramViewGroup.uSK;
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = paramView.findViewById(2131305249);
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(249272);
          throw paramView;
        }
        paramViewGroup.uSL = ((ImageView)localObject1);
        kotlin.g.b.p.g(paramView, "convertView");
        paramView.setTag(paramViewGroup);
        localObject2 = (chi)NearbyPersonV1UIC.a(NearbyPersonV1UIC.this).get(paramInt);
        localObject1 = paramViewGroup.kcS;
        if (localObject1 != null)
        {
          localObject3 = this.context;
          localObject4 = (CharSequence)((chi)localObject2).oUJ;
          localTextView = paramViewGroup.kcS;
          if (localTextView == null) {
            kotlin.g.b.p.hyc();
          }
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject4, localTextView.getTextSize()));
        }
        if (NearbyPersonV1UIC.b(NearbyPersonV1UIC.this) != 1) {
          break label1503;
        }
        switch (((chi)localObject2).kdY)
        {
        default: 
          localObject1 = paramViewGroup.uSL;
          if (localObject1 != null) {
            ((ImageView)localObject1).setVisibility(8);
          }
          if (((chi)localObject2).MmK != 0)
          {
            localObject1 = paramViewGroup.uSI;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(0);
            }
            localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.aVp().rV(((chi)localObject2).MmK), 2.0F);
            localObject3 = paramViewGroup.uSI;
            if (localObject3 != null)
            {
              ((ImageView)localObject3).setImageBitmap((Bitmap)localObject1);
              localObject1 = x.SXb;
            }
            localObject1 = paramViewGroup.uSL;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.uSG;
            if (localObject1 != null) {
              ((TextView)localObject1).setText((CharSequence)((chi)localObject2).MmJ);
            }
            localObject1 = paramViewGroup.uSM;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.uSN;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.uSO;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.hTd;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            if ((localObject2 instanceof com.tencent.mm.plugin.nearby.a.a))
            {
              localObject3 = ((com.tencent.mm.plugin.nearby.a.a)localObject2).Azu;
              if ((localObject3 == null) || (((LinkedList)localObject3).size() != 1)) {
                break label1551;
              }
              localObject1 = paramViewGroup.uSM;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              if (paramViewGroup == null) {
                break label1545;
              }
              localObject1 = paramViewGroup.uSM;
              localObject3 = ((LinkedList)localObject3).get(0);
              kotlin.g.b.p.g(localObject3, "adIconUrl[0]");
              f((ImageView)localObject1, (String)localObject3);
              localObject1 = (NearbyPersonUIC.a)NearbyPersonV1UIC.this.uRY.get(((chi)localObject2).UserName);
              if (localObject1 != null)
              {
                if (((NearbyPersonUIC.a)localObject1).uSf != -1) {
                  break label1830;
                }
                paramInt = 0;
                ((NearbyPersonUIC.a)localObject1).uSf = paramInt;
                if (((NearbyPersonUIC.a)localObject1).uSa > 0)
                {
                  localObject1 = paramViewGroup.hTd;
                  if (localObject1 != null) {
                    ((ImageView)localObject1).setVisibility(0);
                  }
                }
              }
              localObject1 = paramViewGroup.hTd;
              if (localObject1 != null)
              {
                ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new c(this, (chi)localObject2));
                localObject1 = x.SXb;
              }
            }
            if (((chi)localObject2).keb == null) {
              break label1896;
            }
            localObject1 = ((chi)localObject2).keb;
            kotlin.g.b.p.g(localObject1, "contactInfo.Signature");
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
        label1253:
        if (i > paramInt) {
          break label1872;
        }
        int k;
        if (j == 0)
        {
          k = i;
          label1268:
          if (((CharSequence)localObject1).charAt(k) > ' ') {
            break label1845;
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
              break label1253;
              paramViewGroup = paramView.getTag();
              if (paramViewGroup == null)
              {
                paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.ViewHolder");
                AppMethodBeat.o(249272);
                throw paramView;
              }
              paramViewGroup = (NearbyPersonV1UIC.c)paramViewGroup;
              break;
              localObject1 = paramViewGroup.uSL;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.uSL;
              if (localObject1 != null)
              {
                ((ImageView)localObject1).setImageResource(2131690428);
                localObject1 = x.SXb;
              }
              localObject1 = paramViewGroup.uSL;
              if (localObject1 == null) {
                break label838;
              }
              ((ImageView)localObject1).setContentDescription((CharSequence)this.context.getString(2131762865));
              break label838;
              localObject1 = paramViewGroup.uSL;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.uSL;
              if (localObject1 != null)
              {
                ((ImageView)localObject1).setImageResource(2131690427);
                localObject1 = x.SXb;
              }
              localObject1 = paramViewGroup.uSL;
              if (localObject1 == null) {
                break label838;
              }
              ((ImageView)localObject1).setContentDescription((CharSequence)this.context.getString(2131759372));
              break label838;
              localObject1 = paramViewGroup.uSL;
              if (localObject1 == null) {
                break label838;
              }
              ((ImageView)localObject1).setVisibility(8);
              break label838;
              label1503:
              localObject1 = paramViewGroup.uSL;
              if (localObject1 == null) {
                break label838;
              }
              ((ImageView)localObject1).setVisibility(8);
              break label838;
              localObject1 = paramViewGroup.uSI;
              if (localObject1 == null) {
                break label923;
              }
              ((ImageView)localObject1).setVisibility(8);
              break label923;
              label1545:
              localObject1 = null;
              break label1078;
              label1551:
              if ((localObject3 != null) && (((LinkedList)localObject3).size() == 2))
              {
                localObject1 = paramViewGroup.uSM;
                if (localObject1 != null) {
                  ((ImageView)localObject1).setVisibility(0);
                }
                localObject1 = paramViewGroup.uSN;
                if (localObject1 != null) {
                  ((ImageView)localObject1).setVisibility(0);
                }
                localObject1 = paramViewGroup.uSM;
                localObject4 = ((LinkedList)localObject3).get(0);
                kotlin.g.b.p.g(localObject4, "adIconUrl[0]");
                f((ImageView)localObject1, (String)localObject4);
                localObject1 = paramViewGroup.uSN;
                localObject3 = ((LinkedList)localObject3).get(1);
                kotlin.g.b.p.g(localObject3, "adIconUrl[1]");
                f((ImageView)localObject1, (String)localObject3);
                break label1104;
              }
              if ((localObject3 == null) || (((LinkedList)localObject3).size() < 3)) {
                break label1104;
              }
              localObject1 = paramViewGroup.uSM;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.uSN;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.uSO;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.uSM;
              localObject4 = ((LinkedList)localObject3).get(0);
              kotlin.g.b.p.g(localObject4, "adIconUrl[0]");
              f((ImageView)localObject1, (String)localObject4);
              localObject1 = paramViewGroup.uSN;
              localObject4 = ((LinkedList)localObject3).get(1);
              kotlin.g.b.p.g(localObject4, "adIconUrl[1]");
              f((ImageView)localObject1, (String)localObject4);
              localObject1 = paramViewGroup.uSO;
              localObject3 = ((LinkedList)localObject3).get(2);
              kotlin.g.b.p.g(localObject3, "adIconUrl[2]");
              f((ImageView)localObject1, (String)localObject3);
              break label1104;
              label1830:
              paramInt = ((NearbyPersonUIC.a)localObject1).uSf;
              break label1142;
              k = paramInt;
              break label1268;
              label1845:
              k = 0;
              continue;
            }
            i += 1;
            break label1253;
          }
        }
        if (k == 0) {
          break label1872;
        }
        paramInt -= 1;
      }
      label1872:
      if (kotlin.g.b.p.j(((CharSequence)localObject1).subSequence(i, paramInt + 1).toString(), ""))
      {
        label1896:
        localObject1 = paramViewGroup.uSH;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        if (!NearbyPersonV1UIC.c((chi)localObject2)) {
          break label2188;
        }
        localObject1 = paramViewGroup.uSJ;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        if (!NearbyPersonV1UIC.d((chi)localObject2)) {
          break label2209;
        }
        localObject1 = paramViewGroup.uSK;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = NearbyPersonV1UIC.b.uSF;
        if (!NearbyPersonV1UIC.b.JD(((chi)localObject2).kdY)) {
          break label2271;
        }
        localObject1 = paramViewGroup.keC;
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setImageBitmap(null);
          localObject1 = x.SXb;
        }
        localObject1 = new c.a();
        ((c.a)localObject1).OT(com.tencent.mm.plugin.image.d.aSY());
        ((c.a)localObject1).bdp();
        ((c.a)localObject1).bds();
        localObject1 = ((c.a)localObject1).bdv();
        com.tencent.mm.av.q.bcV().a(((chi)localObject2).Lis, paramViewGroup.keC, (com.tencent.mm.av.a.a.c)localObject1);
        if (!Util.isNullOrNil(((chi)localObject2).ked)) {
          break label2230;
        }
        paramViewGroup = paramViewGroup.keD;
        if (paramViewGroup != null) {
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        label1939:
        label1964:
        paramView.post((Runnable)new d(this, (chi)localObject2));
        AppMethodBeat.o(249272);
        return paramView;
        localObject1 = paramViewGroup.uSH;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
        localObject1 = paramViewGroup.uSH;
        if (localObject1 == null) {
          break;
        }
        localObject3 = this.context;
        localObject4 = (CharSequence)((chi)localObject2).keb;
        localTextView = paramViewGroup.uSH;
        if (localTextView == null) {
          kotlin.g.b.p.hyc();
        }
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject4, localTextView.getTextSize()));
        break;
        label2188:
        localObject1 = paramViewGroup.uSJ;
        if (localObject1 == null) {
          break label1939;
        }
        ((ImageView)localObject1).setVisibility(8);
        break label1939;
        label2209:
        localObject1 = paramViewGroup.uSK;
        if (localObject1 == null) {
          break label1964;
        }
        ((View)localObject1).setVisibility(8);
        break label1964;
        label2230:
        localObject1 = paramViewGroup.keD;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)((chi)localObject2).ked);
        }
        paramViewGroup = paramViewGroup.keD;
        if (paramViewGroup != null)
        {
          paramViewGroup.setVisibility(0);
          continue;
          label2271:
          a.b.c(paramViewGroup.keC, ((chi)localObject2).UserName);
          localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          kotlin.g.b.p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
          if (((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aSN().bjG(((chi)localObject2).UserName))
          {
            localObject1 = paramViewGroup.keD;
            if (localObject1 != null) {
              ((TextView)localObject1).setVisibility(0);
            }
            if (as.akh(((chi)localObject2).MmK))
            {
              paramViewGroup = paramViewGroup.keD;
              if (paramViewGroup != null) {
                paramViewGroup.setText((CharSequence)this.context.getString(2131763444));
              }
            }
            else
            {
              localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
              kotlin.g.b.p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aSN().bjJ(((chi)localObject2).UserName);
              if (localObject1 != null)
              {
                localObject3 = paramViewGroup.kcS;
                if (localObject3 != null)
                {
                  localObject4 = this.context;
                  if (!Util.isNullOrNil(((as)localObject1).arJ())) {
                    break label2527;
                  }
                }
              }
              label2527:
              for (localObject1 = ((chi)localObject2).oUJ;; localObject1 = ((as)localObject1).arJ())
              {
                localObject1 = (CharSequence)localObject1;
                localTextView = paramViewGroup.kcS;
                if (localTextView == null) {
                  kotlin.g.b.p.hyc();
                }
                ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject4, (CharSequence)localObject1, localTextView.getTextSize()));
                paramViewGroup = paramViewGroup.keD;
                if (paramViewGroup == null) {
                  break;
                }
                paramViewGroup.setText((CharSequence)this.context.getString(2131763449));
                break;
              }
            }
          }
          else
          {
            paramViewGroup = paramViewGroup.keD;
            if (paramViewGroup != null) {
              paramViewGroup.setVisibility(8);
            }
          }
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter$getView$1", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg$IGetUsername;", "getMaxPos", "", "getUsername", "", "pos", "plugin-finder_release"})
    public static final class b
      implements b.b
    {
      public final int bnW()
      {
        AppMethodBeat.i(249268);
        int i = this.uSC.getCount();
        AppMethodBeat.o(249268);
        return i;
      }
      
      public final String vg(int paramInt)
      {
        AppMethodBeat.i(249267);
        if ((paramInt < 0) || (paramInt >= this.uSC.getCount()))
        {
          Log.e("NearbyPersonUIC", "pos is invalid");
          AppMethodBeat.o(249267);
          return null;
        }
        Object localObject = this.uSC.JC(paramInt);
        if (localObject != null)
        {
          localObject = ((chi)localObject).UserName;
          AppMethodBeat.o(249267);
          return localObject;
        }
        AppMethodBeat.o(249267);
        return null;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(NearbyPersonV1UIC.a parama, chi paramchi) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(249269);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = (NearbyPersonUIC.a)this.uSC.uSA.uRY.get(this.uSD.UserName);
        if (paramView != null)
        {
          paramView.uSe += 1;
          paramView.oBV = true;
          paramView.uSf |= 0x2;
        }
        NearbyPersonV1UIC.c(this.uSC.uSA);
        this.uSC.notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249269);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(NearbyPersonV1UIC.a parama, chi paramchi) {}
      
      public final void run()
      {
        AppMethodBeat.i(249270);
        Object localObject1 = com.tencent.mm.plugin.finder.nearby.report.b.uSZ;
        Object localObject2 = this.uSD.UserName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        Object localObject3 = this.uSD.MmJ;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        Object localObject4 = this.uSD.keh;
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = "";
        }
        String str = this.uSD.kea;
        localObject4 = str;
        if (str == null) {
          localObject4 = "";
        }
        boolean bool = NearbyPersonV1UIC.c(this.uSD);
        kotlin.g.b.p.h(localObject1, "userName");
        kotlin.g.b.p.h(localObject2, "district");
        kotlin.g.b.p.h(localObject3, "country");
        kotlin.g.b.p.h(localObject4, "city");
        com.tencent.mm.plugin.finder.nearby.report.b.a((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, bool, 1L);
        AppMethodBeat.o(249270);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$PoiItemConverter;", "", "()V", "SEX_FOR_POI_ITEM", "", "convertToLbsContactInfo", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "id", "", "icon", "name", "desc", "value", "getPoiLink", "info", "isSexForPoiItem", "", "sexVal", "plugin-finder_release"})
  public static final class b
  {
    private static int uSE;
    public static final b uSF;
    
    static
    {
      AppMethodBeat.i(249278);
      uSF = new b();
      uSE = 10000;
      AppMethodBeat.o(249278);
    }
    
    public static boolean JD(int paramInt)
    {
      return paramInt == uSE;
    }
    
    public static chi h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(249277);
      com.tencent.mm.plugin.nearby.a.a locala = new com.tencent.mm.plugin.nearby.a.a();
      locala.kdY = uSE;
      locala.UserName = paramString1;
      locala.Lis = paramString2;
      locala.MmJ = paramString4;
      locala.oUJ = paramString3;
      locala.kdZ = paramString5;
      paramString1 = (chi)locala;
      AppMethodBeat.o(249277);
      return paramString1;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$ViewHolder;", "", "()V", "adIconImg1", "Landroid/widget/ImageView;", "getAdIconImg1", "()Landroid/widget/ImageView;", "setAdIconImg1", "(Landroid/widget/ImageView;)V", "adIconImg2", "getAdIconImg2", "setAdIconImg2", "adIconImg3", "getAdIconImg3", "setAdIconImg3", "addState", "Landroid/widget/TextView;", "getAddState", "()Landroid/widget/TextView;", "setAddState", "(Landroid/widget/TextView;)V", "avatar", "getAvatar", "setAvatar", "closeBtn", "getCloseBtn", "setCloseBtn", "displayName", "getDisplayName", "setDisplayName", "distance", "getDistance", "setDistance", "finderFlagIv", "Landroid/view/View;", "getFinderFlagIv", "()Landroid/view/View;", "setFinderFlagIv", "(Landroid/view/View;)V", "sex", "getSex", "setSex", "sign", "getSign", "setSign", "snsFlagIv", "getSnsFlagIv", "setSnsFlagIv", "vuserinfoIv", "getVuserinfoIv", "setVuserinfoIv", "plugin-finder_release"})
  public static final class c
  {
    ImageView hTd;
    TextView kcS;
    ImageView keC;
    TextView keD;
    TextView uSG;
    TextView uSH;
    ImageView uSI;
    ImageView uSJ;
    View uSK;
    ImageView uSL;
    ImageView uSM;
    ImageView uSN;
    ImageView uSO;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class i
    implements View.OnTouchListener
  {
    i(NearbyPersonV1UIC paramNearbyPersonV1UIC) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(249285);
      if (NearbyPersonV1UIC.i(this.uSA) != null)
      {
        paramView = NearbyPersonV1UIC.i(this.uSA);
        if ((paramView != null) && (paramView.kex != null))
        {
          paramView = paramView.kex;
          if (paramView == null) {
            kotlin.g.b.p.hyc();
          }
          paramView.onTouchEvent(paramMotionEvent);
        }
      }
      AppMethodBeat.o(249285);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "maccuracy", "altitude", "onGetLocation"})
  static final class j
    implements com.tencent.mm.modelgeo.b.a
  {
    j(NearbyPersonV1UIC paramNearbyPersonV1UIC) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(249287);
      if (NearbyPersonV1UIC.t(this.uSA))
      {
        AppMethodBeat.o(249287);
        return false;
      }
      NearbyPersonV1UIC.u(this.uSA);
      if (NearbyPersonV1UIC.l(this.uSA))
      {
        NearbyPersonV1UIC.v(this.uSA);
        com.tencent.mm.plugin.report.service.g.Wn(11);
        AppMethodBeat.o(249287);
        return false;
      }
      Object localObject1;
      boolean bool;
      if (paramBoolean)
      {
        if (NearbyPersonV1UIC.w(this.uSA) != null)
        {
          localObject1 = NearbyPersonV1UIC.w(this.uSA);
          if (localObject1 == null) {
            kotlin.g.b.p.hyc();
          }
          ((com.tencent.mm.ui.base.q)localObject1).setMessage((CharSequence)this.uSA.getString(2131763442));
        }
        NearbyPersonV1UIC.a(this.uSA, new NearbyPersonUIC.c(paramFloat2, paramFloat1, (int)paramDouble2));
        localObject1 = com.tencent.mm.modelstat.e.bge();
        if (paramInt != 0)
        {
          paramBoolean = true;
          Object localObject2 = NearbyPersonV1UIC.y(this.uSA);
          if (localObject2 == null) {
            break label315;
          }
          bool = ((com.tencent.mm.modelgeo.d)localObject2).bcb();
          label158:
          ((com.tencent.mm.modelstat.e)localObject1).a(2001, paramBoolean, bool, paramFloat1, paramFloat2, (int)paramDouble2);
          localObject1 = this.uSA;
          int i = NearbyPersonV1UIC.b(this.uSA);
          localObject2 = NearbyPersonV1UIC.x(this.uSA);
          if (localObject2 == null) {
            kotlin.g.b.p.hyc();
          }
          paramFloat1 = ((NearbyPersonUIC.c)localObject2).iUZ;
          localObject2 = NearbyPersonV1UIC.x(this.uSA);
          if (localObject2 == null) {
            kotlin.g.b.p.hyc();
          }
          paramFloat2 = ((NearbyPersonUIC.c)localObject2).iUY;
          localObject2 = NearbyPersonV1UIC.x(this.uSA);
          if (localObject2 == null) {
            kotlin.g.b.p.hyc();
          }
          ((NearbyPersonUIC)localObject1).uRV = new com.tencent.mm.plugin.nearby.a.c(i, paramFloat1, paramFloat2, ((NearbyPersonUIC.c)localObject2).accuracy, paramInt, "", "");
          com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)this.uSA.uRV);
          Log.i("NearbyPersonUIC", "onGetLocation doScene");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(249287);
        return false;
        paramBoolean = false;
        break;
        label315:
        bool = false;
        break label158;
        com.tencent.mm.plugin.report.service.g.Wn(11);
        NearbyPersonV1UIC.v(this.uSA);
        this.uSA.getRootView().findViewById(2131305245).setVisibility(0);
        localObject1 = NearbyPersonV1UIC.p(this.uSA);
        if (localObject1 == null) {
          kotlin.g.b.p.hyc();
        }
        ((ListView)localObject1).setVisibility(8);
        NearbyPersonV1UIC.o(this.uSA);
        if ((!NearbyPersonV1UIC.z(this.uSA)) && (!com.tencent.mm.modelgeo.d.bcc()))
        {
          NearbyPersonV1UIC.A(this.uSA);
          com.tencent.mm.ui.base.h.a((Context)this.uSA.getActivity(), this.uSA.getString(2131761461), this.uSA.getString(2131755998), this.uSA.getString(2131762043), this.uSA.getString(2131755761), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(249286);
              com.tencent.mm.modelgeo.d.cZ((Context)this.uSR.uSA.getActivity());
              AppMethodBeat.o(249286);
            }
          }, null);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(NearbyPersonV1UIC paramNearbyPersonV1UIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$sayHiListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LbsSayHiEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class n
    extends IListener<ls>
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(NearbyPersonV1UIC.n paramn) {}
      
      public final void run()
      {
        AppMethodBeat.i(249291);
        NearbyPersonV1UIC.B(this.uSS.uSA);
        AppMethodBeat.o(249291);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class w
    implements DialogInterface.OnCancelListener
  {
    w(NearbyPersonV1UIC paramNearbyPersonV1UIC) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(249304);
      NearbyPersonV1UIC.m(this.uSA);
      com.tencent.mm.plugin.report.service.g.Wn(11);
      if (this.uSA.uRV != null) {
        com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)this.uSA.uRV);
      }
      Log.i("NearbyPersonUIC", "showLoadingDialog  [loading cancel] cancel in loading");
      if (!NearbyPersonV1UIC.n(this.uSA)) {
        Log.i("NearbyPersonUIC", "showLoadingDialog [loading cancel] cancel in first loading");
      }
      AppMethodBeat.o(249304);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC
 * JD-Core Version:    0.7.0.1
 */