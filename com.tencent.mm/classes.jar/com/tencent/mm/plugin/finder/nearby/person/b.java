package com.tencent.mm.plugin.finder.nearby.person;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
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
import com.tencent.mm.autogen.a.xc;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.m.a;
import com.tencent.mm.plugin.finder.nearby.f.b;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.f.f;
import com.tencent.mm.plugin.finder.nearby.f.g;
import com.tencent.mm.plugin.finder.nearby.f.h;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSystemPermissionUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bz;
import com.tencent.mm.ui.base.k.11;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC;", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "adapter", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter;", "bindMobileHeader", "Lcom/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView;", "exitModeBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "exposePerson", "", "", "findItems", "", "[Ljava/lang/String;", "friendLV", "Landroid/widget/ListView;", "friendList", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "hasHeaderView", "", "hasLoadData", "hasLoadedData", "hasLocated", "hasShowGpsAlert", "hasShowLBSOpenDialog", "iGetLocation", "Lcom/tencent/mm/modelgeo/LocationGeo;", "isCancel", "isFirstOnResume", "isFirstOnUserVisibleFocused", "isOnResume", "isOnUserVisibleFocused", "isRequested", "lastOnPauseHasPermission", "lbsFindType", "", "location", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$Location;", "onLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "sayHiLayout", "Landroid/view/View;", "sayHiListener", "Lcom/tencent/mm/sdk/event/IListener;", "showBannerType", "showBindMobileHeaderFlag", "stayTimeBegin", "", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "vgHeaderContainer", "Landroid/view/ViewGroup;", "viewBtnSayHi", "viewLbsRoomEntry", "checkIfShowLbsRoom", "", "code", "scene", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "checkPermission", "checkTryRequestFirstPageAgain", "dismissLoadingDialog", "dismissPermissionView", "dismissTipDialog", "fetchDataInternal", "getLayoutId", "getLvHeaderContainer", "getSayHiLayout", "gotoContactInfoUI", "info", "gotoLbsRoom", "lbsRoom", "roomNickname", "handleItemClick", "position", "handleJoinRoomRequest", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "handleLbsClearLocation", "handleLbsError", "handleLbsFind", "handleLbsFindFriends", "handleOnStartLoadData", "hideLbsRoomEntryView", "hideLiveBottomSheet", "initADData", "initConfig", "initContentView", "isShowFinderFlag", "contactInfo", "isShowSnsFlag", "mergeADItemList", "onActionbarClick", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMenuClick", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSceneEnd", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "requestLocationPermission", "showClearLocationDialog", "showLBSOpenDialog", "okCallback", "Lkotlin/Function0;", "cancelCallback", "showLbsRoomEntry", "groupName", "memberCount", "showLbsTips", "showLiveBottomSheet", "showLoadingDialog", "showPermissionView", "sortFriendList", "startJoinLbsRoomRequest", "startLoadData", "updateSayHiLayout", "NearbyFriendAdapter", "PoiItemConverter", "ViewHolder", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  private ViewGroup EOX;
  private List<String> EOY;
  private View EOZ;
  private final View EPa;
  private a EPb;
  private boolean EPc;
  private int EPd;
  private boolean EPe;
  private int EPf;
  private boolean EPg;
  private boolean EPh;
  private int EPi;
  private a.c EPj;
  private boolean EPk;
  private long EPl;
  private boolean EPm;
  private boolean EPn;
  private com.tencent.mm.ui.widget.a.f EPo;
  private final IListener<?> EPp;
  private View EPq;
  private boolean isFirstOnResume;
  private boolean isFirstOnUserVisibleFocused;
  private boolean isOnResume;
  private boolean isOnUserVisibleFocused;
  private boolean lastOnPauseHasPermission;
  private com.tencent.mm.modelgeo.d lsy;
  private boolean nzW;
  ListView pVC;
  private w tipDialog;
  private final com.tencent.mm.modelgeo.b.a wGt;
  private List<dgy> zPw;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(339913);
    this.EOY = ((List)new LinkedList());
    this.zPw = ((List)new LinkedList());
    this.EPf = 1;
    this.wGt = new b..ExternalSyntheticLambda13(this);
    this.isFirstOnUserVisibleFocused = true;
    this.isFirstOnResume = true;
    this.EPp = ((IListener)new NearbyPersonV1UIC.sayHiListener.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(339913);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(339922);
    this.EOY = ((List)new LinkedList());
    this.zPw = ((List)new LinkedList());
    this.EPf = 1;
    this.wGt = new b..ExternalSyntheticLambda13(this);
    this.isFirstOnUserVisibleFocused = true;
    this.isFirstOnResume = true;
    this.EPp = ((IListener)new NearbyPersonV1UIC.sayHiListener.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(339922);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(340307);
    kotlin.g.b.s.u(paramb, "this$0");
    paramb.nzW = true;
    com.tencent.mm.plugin.report.service.g.ahy(11);
    if (paramb.eFZ() != null) {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramb.eFZ());
    }
    Log.i("NearbyPersonUIC", "showLoadingDialog  [loading cancel] cancel in loading");
    if (!paramb.EPg) {
      Log.i("NearbyPersonUIC", "showLoadingDialog [loading cancel] cancel in first loading");
    }
    AppMethodBeat.o(340307);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(340161);
    kotlin.g.b.s.u(paramb, "this$0");
    com.tencent.mm.modelgeo.d.dP((Context)paramb.getActivity());
    AppMethodBeat.o(340161);
  }
  
  private static final void a(b paramb, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(340280);
    kotlin.g.b.s.u(paramb, "this$0");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      paramb = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
      com.tencent.mm.plugin.finder.nearby.report.d.Rf(paramMenuItem.getItemId());
      AppMethodBeat.o(340280);
      return;
      paramb.EPf = 4;
      paramb.EPe = false;
      com.tencent.mm.kernel.h.baE().ban().B(16386, Integer.valueOf(paramb.EPf));
      paramb.eGd();
      continue;
      paramb.EPf = 3;
      paramb.EPe = false;
      com.tencent.mm.kernel.h.baE().ban().B(16386, Integer.valueOf(paramb.EPf));
      paramb.eGd();
      continue;
      paramb.EPf = 1;
      paramb.EPe = false;
      com.tencent.mm.kernel.h.baE().ban().B(16386, Integer.valueOf(paramb.EPf));
      paramb.eGd();
      continue;
      Object localObject = new Intent((Context)paramb.getActivity(), NearbySayHiListUI.class);
      ((Intent)localObject).putExtra("k_say_hi_type", 2);
      paramb.getActivity().startActivityForResult((Intent)localObject, 2009);
      localObject = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
      localObject = com.tencent.mm.ui.component.k.aeZF;
      m.a.c(2, ((as)com.tencent.mm.ui.component.k.d(paramb.getActivity()).q(as.class)).fou());
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("NearbyPeopleBubble");
      continue;
      paramb.b(new com.tencent.mm.plugin.nearby.model.c(2, 0.0F, 0.0F, 0, 0, "", ""));
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramb.eGa(), 0);
      localObject = (Context)paramb.getActivity();
      paramb.getString(b.g.app_tip);
      paramb.tipDialog = com.tencent.mm.ui.base.k.a((Context)localObject, paramb.getString(b.g.Mon), true, new b..ExternalSyntheticLambda1(paramb));
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(340359);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    paramView = paramb.pVC;
    kotlin.g.b.s.checkNotNull(paramView);
    paramView.removeHeaderView(paramb.EOZ);
    paramb.EOZ = null;
    paramView = new Intent((Context)paramb.getActivity(), NearbySayHiListUI.class);
    paramView.putExtra("k_say_hi_type", 2);
    paramView.putExtra("show_clear_header", true);
    paramb.getActivity().startActivityForResult(paramView, 2009);
    paramView = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
    paramView = com.tencent.mm.ui.component.k.aeZF;
    m.a.c(2, ((as)com.tencent.mm.ui.component.k.d(paramb.getActivity()).q(as.class)).fou());
    ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("NearbyPeopleBubble");
    paramb = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
    com.tencent.mm.plugin.finder.nearby.report.d.report(12L);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(340359);
  }
  
  private static final void a(b paramb, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(340237);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    if (((com.tencent.mm.bp.a.iGn()) || (com.tencent.mm.bp.a.iGm())) && (paramb.EOZ != null)) {}
    for (int i = paramInt - 1;; i = paramInt)
    {
      int j = i;
      if (paramb.EPc) {
        j = i - 1;
      }
      if ((j < 0) || (j >= paramb.zPw.size())) {}
      dgy localdgy;
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(340237);
        return;
        localdgy = (dgy)paramb.zPw.get(j);
        paramAdapterView = b.EPt;
        if (!b.QS(localdgy.pSf)) {
          break;
        }
        paramAdapterView = (a.a)paramb.EOP.get(localdgy.UserName);
        if (paramAdapterView == null)
        {
          paramb = (Throwable)new IllegalStateException("invalid type".toString());
          AppMethodBeat.o(340237);
          throw paramb;
        }
        paramAdapterView.EOV |= 0x1;
        if (paramAdapterView.jump_type == 1)
        {
          paramView = new AppBrandStatObject();
          paramView.scene = 1134;
          ((t)com.tencent.mm.kernel.h.ax(t.class)).a((Context)paramb.getActivity(), paramAdapterView.EOT, "", 0, 0, "", paramView);
        }
        else if (paramAdapterView.jump_type == 2)
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", paramAdapterView.EOT);
          paramView.putExtra("geta8key_scene", 25);
          paramView.putExtra("stastic_scene", 12);
          com.tencent.mm.br.c.b((Context)paramb.getActivity(), "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
      paramAdapterView = localdgy.UserName;
      label502:
      long l4;
      label576:
      long l1;
      label688:
      label703:
      label740:
      long l2;
      if (com.tencent.mm.contact.d.rs(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramAdapterView).field_type))
      {
        paramView = new Intent();
        paramView.putExtra("Contact_User", paramAdapterView);
        paramView.putExtra("Contact_Scene", 18);
        paramView.putExtra("Sns_from_Scene", 18);
        paramView.putExtra("lbs_ticket", localdgy.aant);
        paramView.putExtra("Contact_IsLbsGotoChatting", true);
        if (paramAdapterView != null)
        {
          if (((CharSequence)paramAdapterView).length() <= 0) {
            break label814;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = new xc();
            ((xc)localObject1).iaC.intent = paramView;
            ((xc)localObject1).iaC.username = paramAdapterView;
            ((xc)localObject1).publish();
            paramView.putExtra("CONTACT_INFO_UI_SOURCE", 5);
            paramView.putExtra("CONTACT_INFO_UI_SUB_SOURCE", 501);
            com.tencent.mm.plugin.nearby.a.pFn.c(paramView, (Context)paramb.getActivity());
          }
        }
        paramAdapterView = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
        boolean bool1 = b(localdgy);
        i = paramb.EPf;
        boolean bool2 = c(localdgy);
        kotlin.g.b.s.u(localdgy, "contactInfo");
        paramAdapterView = localdgy.UserName;
        paramb = paramAdapterView;
        if (paramAdapterView == null) {
          paramb = "";
        }
        paramView = localdgy.aaMl;
        paramAdapterView = paramView;
        if (paramView == null) {
          paramAdapterView = "";
        }
        localObject1 = localdgy.pSo;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        localObject2 = localdgy.pSh;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!bool1) {
          break label1230;
        }
        paramLong = 1L;
        l4 = com.tencent.mm.plugin.finder.nearby.report.d.Re(i);
        if (!bool2) {
          break label1236;
        }
        l1 = 1L;
        if (localdgy.pSi == null) {
          break label1248;
        }
        localObject2 = localdgy.pSi;
        kotlin.g.b.s.s(localObject2, "contactInfo.Signature");
        if (kotlin.n.n.bp((CharSequence)localObject2)) {
          break label1242;
        }
        i = 1;
        if (i == 0) {
          break label1248;
        }
        l2 = 1L;
        label748:
        if (!((com.tencent.mm.plugin.emoji.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.a.class)).aa((CharSequence)localdgy.vhX)) {
          break label1254;
        }
      }
      label814:
      label1230:
      label1236:
      label1242:
      label1248:
      label1254:
      for (long l3 = 1L;; l3 = 0L)
      {
        com.tencent.mm.plugin.finder.nearby.report.d.a(paramb, paramView, (String)localObject1, paramAdapterView, paramLong, 2L, l4, l1, l2, l3, paramInt + 1L, localdgy.pSf, 0L, 4096);
        break;
        i = 0;
        break label502;
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("Contact_User", localdgy.UserName);
        paramAdapterView.putExtra("Contact_Alias", localdgy.pSk);
        paramAdapterView.putExtra("Contact_Nick", localdgy.vhX);
        paramAdapterView.putExtra("Contact_Distance", localdgy.aaMl);
        paramAdapterView.putExtra("Contact_Signature", localdgy.pSi);
        paramAdapterView.putExtra("Contact_RegionCode", RegionCodeDecoder.bI(localdgy.pSo, localdgy.pSg, localdgy.pSh));
        paramAdapterView.putExtra("Contact_Sex", localdgy.pSf);
        paramAdapterView.putExtra("Contact_IsLBSFriend", true);
        paramAdapterView.putExtra("Contact_Scene", 18);
        paramAdapterView.putExtra("Contact_VUser_Info", localdgy.aaMn);
        paramAdapterView.putExtra("Contact_VUser_Info_Flag", localdgy.aaMm);
        paramAdapterView.putExtra("Contact_KWeibo_flag", localdgy.aaMq);
        paramAdapterView.putExtra("Contact_KWeibo", localdgy.aaMo);
        paramAdapterView.putExtra("Contact_KWeiboNick", localdgy.aaMp);
        paramAdapterView.putExtra("Contact_KSnsIFlag", localdgy.aaMs.pSq);
        paramAdapterView.putExtra("Contact_KSnsBgId", localdgy.aaMs.pSs);
        paramAdapterView.putExtra("Contact_KSnsBgUrl", localdgy.aaMs.pSr);
        paramAdapterView.putExtra("lbs_ticket", localdgy.aant);
        paramAdapterView.putExtra("Contact_IsLbsGotoChatting", true);
        if (localdgy.pSp != null)
        {
          paramView = new com.tencent.mm.api.c();
          paramView.field_brandList = localdgy.pSp;
          paramView.field_brandFlag = localdgy.aaMt.pSt;
          paramView.field_brandIconURL = localdgy.aaMt.pSw;
          paramView.field_extInfo = localdgy.aaMt.pSu;
          paramView.field_brandInfo = localdgy.aaMt.pSv;
          paramAdapterView.putExtra("KBrandInfo_item", (Parcelable)new MCacheItem((IAutoDBItem)paramView));
        }
        paramAdapterView.putExtra("Sns_from_Scene", 18);
        paramAdapterView.putExtra("CONTACT_INFO_UI_SOURCE", 5);
        paramAdapterView.putExtra("CONTACT_INFO_UI_SUB_SOURCE", 501);
        com.tencent.mm.plugin.nearby.a.pFn.c(paramAdapterView, (Context)paramb.getActivity());
        break label576;
        paramLong = 0L;
        break label688;
        l1 = 0L;
        break label703;
        i = 0;
        break label740;
        l2 = 0L;
        break label748;
      }
    }
  }
  
  private static final void a(b paramb, Boolean paramBoolean)
  {
    AppMethodBeat.i(340202);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.s(paramBoolean, "it");
    if (paramBoolean.booleanValue())
    {
      paramb.eGc();
      AppMethodBeat.o(340202);
      return;
    }
    paramb.eGl();
    AppMethodBeat.o(340202);
  }
  
  private static final boolean a(b paramb, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(340247);
    kotlin.g.b.s.u(paramb, "this$0");
    if (paramb.EPb != null)
    {
      paramb = paramb.EPb;
      if ((paramb != null) && (paramb.pSE != null))
      {
        paramb = paramb.pSE;
        kotlin.g.b.s.checkNotNull(paramb);
        paramb.B(paramMotionEvent);
      }
    }
    AppMethodBeat.o(340247);
    return false;
  }
  
  private static final boolean a(b paramb, boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(340184);
    kotlin.g.b.s.u(paramb, "this$0");
    if (paramb.EPh)
    {
      AppMethodBeat.o(340184);
      return false;
    }
    paramb.EPh = true;
    if (paramb.nzW)
    {
      paramb.eGg();
      com.tencent.mm.plugin.report.service.g.ahy(11);
      AppMethodBeat.o(340184);
      return false;
    }
    Object localObject;
    if (paramBoolean)
    {
      if (paramb.tipDialog != null)
      {
        localObject = paramb.tipDialog;
        kotlin.g.b.s.checkNotNull(localObject);
        ((w)localObject).setMessage((CharSequence)paramb.getString(b.g.Moo));
      }
      paramb.EPj = new a.c(paramFloat2, paramFloat1, (int)paramDouble2);
      int i = paramb.EPf;
      localObject = paramb.EPj;
      kotlin.g.b.s.checkNotNull(localObject);
      paramFloat1 = ((a.c)localObject).oDU;
      localObject = paramb.EPj;
      kotlin.g.b.s.checkNotNull(localObject);
      paramFloat2 = ((a.c)localObject).oDT;
      localObject = paramb.EPj;
      kotlin.g.b.s.checkNotNull(localObject);
      paramb.a(new com.tencent.mm.plugin.nearby.model.c(i, paramFloat1, paramFloat2, ((a.c)localObject).EOW, paramInt, "", ""));
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramb.eFZ(), 0);
      Log.i("NearbyPersonUIC", "onGetLocation doScene");
    }
    for (;;)
    {
      AppMethodBeat.o(340184);
      return false;
      com.tencent.mm.plugin.report.service.g.ahy(11);
      paramb.eGg();
      paramb.getRootView().findViewById(f.d.EGi).setVisibility(0);
      localObject = paramb.pVC;
      kotlin.g.b.s.checkNotNull(localObject);
      ((ListView)localObject).setVisibility(8);
      paramb.EPg = true;
      if ((!paramb.EPk) && (!com.tencent.mm.modelgeo.d.bJm()))
      {
        paramb.EPk = true;
        com.tencent.mm.ui.base.k.a((Context)paramb.getActivity(), paramb.getString(f.h.gps_disable_tip), paramb.getString(f.h.app_tip), paramb.getString(f.h.jump_to_settings), paramb.getString(f.h.app_cancel), false, new b..ExternalSyntheticLambda3(paramb), null);
      }
    }
  }
  
  private static final void b(b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(340321);
    kotlin.g.b.s.u(paramb, "this$0");
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramb.eGa());
    AppMethodBeat.o(340321);
  }
  
  private static final void b(b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(340340);
    kotlin.g.b.s.u(paramb, "this$0");
    paramDialogInterface = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
    com.tencent.mm.plugin.finder.nearby.report.d.report(4L);
    paramDialogInterface = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.finder.nearby.e)com.tencent.mm.ui.component.k.d(paramb.getActivity()).q(com.tencent.mm.plugin.finder.nearby.e.class)).eEf();
    AppMethodBeat.o(340340);
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(340375);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    if (paramb.EPj != null)
    {
      paramView = paramb.EPj;
      kotlin.g.b.s.checkNotNull(paramView);
      float f1 = paramView.oDU;
      paramView = paramb.EPj;
      kotlin.g.b.s.checkNotNull(paramView);
      float f2 = paramView.oDT;
      paramView = paramb.EPj;
      kotlin.g.b.s.checkNotNull(paramView);
      paramb.a(new com.tencent.mm.plugin.nearby.model.d(f1, f2, paramView.EOW, "", ""));
      paramView = (Context)paramb.getActivity();
      paramb.getString(b.g.app_tip);
      paramb.tipDialog = com.tencent.mm.ui.base.k.a(paramView, paramb.getString(b.g.Mos), true, new b..ExternalSyntheticLambda2(paramb));
      com.tencent.mm.plugin.nearby.model.b.aex(3);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramb.eGb(), 0);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(340375);
  }
  
  private static boolean b(dgy paramdgy)
  {
    return (paramdgy.aaMs != null) && ((paramdgy.aaMs.pSq & 0x1) > 0);
  }
  
  private static final void c(b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(340385);
    kotlin.g.b.s.u(paramb, "this$0");
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramb.eGb());
    AppMethodBeat.o(340385);
  }
  
  private static final void c(b paramb, View paramView)
  {
    AppMethodBeat.i(340421);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    if (!paramb.eBW()) {
      paramb.requestLocationPermission();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(340421);
      return;
      if (!((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.actu, d.a.acsT))
      {
        paramView = paramb.getActivity();
        paramb = new Intent((Context)paramb.getActivity(), SettingsSystemPermissionUI.class);
        paramb = new com.tencent.mm.hellhoundlib.b.a().cG(paramb);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, paramb.aYi(), "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "showPermissionView$lambda-21", "(Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)paramb.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "showPermissionView$lambda-21", "(Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  private static boolean c(dgy paramdgy)
  {
    return (paramdgy.aaMu & 0x1) > 0;
  }
  
  private final void checkTryRequestFirstPageAgain()
  {
    AppMethodBeat.i(340119);
    if (!this.isOnResume)
    {
      Log.i("NearbyPersonUIC", kotlin.g.b.s.X("shouldTryRequestFirstPageAgain return for isOnResume:", Boolean.valueOf(this.isOnResume)));
      AppMethodBeat.o(340119);
      return;
    }
    if (!this.isOnUserVisibleFocused)
    {
      Log.i("NearbyPersonUIC", kotlin.g.b.s.X("shouldTryRequestFirstPageAgain return for isOnUserVisibleFocused:", Boolean.valueOf(this.isOnUserVisibleFocused)));
      AppMethodBeat.o(340119);
      return;
    }
    if (this.lastOnPauseHasPermission)
    {
      Log.i("NearbyPersonUIC", kotlin.g.b.s.X("shouldTryRequestFirstPageAgain return for lastOnPauseHasPermission:", Boolean.valueOf(this.lastOnPauseHasPermission)));
      AppMethodBeat.o(340119);
      return;
    }
    v localv = v.GgU;
    if (!v.eot())
    {
      Log.i("NearbyPersonUIC", kotlin.g.b.s.X("shouldTryRequestFirstPageAgain return for permission:", Boolean.valueOf(this.lastOnPauseHasPermission)));
      AppMethodBeat.o(340119);
      return;
    }
    Log.i("NearbyPersonUIC", "shouldTryRequestFirstPageAgain requestInit");
    eGm();
    eGc();
    AppMethodBeat.o(340119);
  }
  
  private final void dismissLoadingDialog()
  {
    AppMethodBeat.i(340004);
    w localw = this.tipDialog;
    if (localw != null) {
      localw.dismiss();
    }
    this.tipDialog = null;
    AppMethodBeat.o(340004);
  }
  
  private static final void e(kotlin.g.a.a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(340400);
    kotlin.g.b.s.u(parama, "$okCallback");
    parama.invoke();
    parama = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
    com.tencent.mm.plugin.finder.nearby.report.d.report(16L);
    AppMethodBeat.o(340400);
  }
  
  private final boolean eBW()
  {
    AppMethodBeat.i(340107);
    v localv = v.GgU;
    this.lastOnPauseHasPermission = v.eot();
    boolean bool = this.lastOnPauseHasPermission;
    AppMethodBeat.o(340107);
    return bool;
  }
  
  private final void eGc()
  {
    AppMethodBeat.i(339952);
    Log.i("NearbyPersonUIC", kotlin.g.b.s.X("fetchDataInternal hasLoadData:", Boolean.valueOf(this.EPm)));
    Object localObject2;
    int k;
    if (!this.EPm)
    {
      eGd();
      if (LocaleUtil.isSimplifiedChineseAppLang())
      {
        localObject2 = XmlParser.parseXml(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yWO, ""), "lbsads", null);
        if (localObject2 != null)
        {
          k = Util.getInt((String)((Map)localObject2).get(".lbsads.$count"), 0);
          if (k > 0) {
            if (k <= 0) {}
          }
        }
      }
    }
    int j;
    label653:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (i == 0) {}
      Object localObject3;
      for (Object localObject1 = "";; localObject1 = Integer.valueOf(i))
      {
        localObject3 = kotlin.g.b.s.X(".lbsads.lbsad", localObject1);
        localObject1 = new a.a();
        ((a.a)localObject1).id = ((String)((Map)localObject2).get(kotlin.g.b.s.X((String)localObject3, ".$id")));
        ((a.a)localObject1).pos = Util.getInt((String)((Map)localObject2).get(kotlin.g.b.s.X((String)localObject3, ".$pos")), 0);
        ((a.a)localObject1).EOR = Util.getInt((String)((Map)localObject2).get(kotlin.g.b.s.X((String)localObject3, ".$close_times")), 0);
        ((a.a)localObject1).EOS = Util.getInt((String)((Map)localObject2).get(kotlin.g.b.s.X((String)localObject3, ".$show_times")), 2147483647);
        ((a.a)localObject1).name = ((String)((Map)localObject2).get(kotlin.g.b.s.X((String)localObject3, ".name")));
        ((a.a)localObject1).desc = ((String)((Map)localObject2).get(kotlin.g.b.s.X((String)localObject3, ".desc")));
        ((a.a)localObject1).icon = ((String)((Map)localObject2).get(kotlin.g.b.s.X((String)localObject3, ".icon")));
        ((a.a)localObject1).jump_type = Util.getInt((String)((Map)localObject2).get(kotlin.g.b.s.X((String)localObject3, ".jump.$type")), 0);
        ((a.a)localObject1).EOT = ((String)((Map)localObject2).get(kotlin.g.b.s.X((String)localObject3, ".jump")));
        localObject3 = this.EOP;
        String str = ((a.a)localObject1).id;
        kotlin.g.b.s.checkNotNull(str);
        ((Map)localObject3).put(str, localObject1);
        if (j < k) {
          break label653;
        }
        localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acZg, null);
        if (localObject1 == null) {
          break label638;
        }
        localObject1 = ((Collection)kotlin.n.n.a((CharSequence)localObject1, new String[] { "\\|" })).toArray(new String[0]);
        if (localObject1 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(339952);
        throw ((Throwable)localObject1);
      }
      localObject1 = (String[])localObject1;
      j = localObject1.length;
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          localObject2 = localObject1[i];
          i += 1;
          localObject2 = ((Collection)kotlin.n.n.b((CharSequence)localObject2, new String[] { ":" })).toArray(new String[0]);
          if (localObject2 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(339952);
            throw ((Throwable)localObject1);
          }
          localObject2 = (String[])localObject2;
          if (localObject2.length == 3)
          {
            localObject3 = (a.a)this.EOP.get(localObject2[0]);
            if (localObject3 != null)
            {
              ((a.a)localObject3).EOU = Util.getInt(localObject2[1], 0);
              ((a.a)localObject3).wDI = Util.getInt(localObject2[2], 0);
            }
          }
        }
        else
        {
          label638:
          this.EPm = true;
          AppMethodBeat.o(339952);
          return;
        }
      }
    }
  }
  
  private final void eGd()
  {
    AppMethodBeat.i(339965);
    com.tencent.mm.kernel.h.aZW().a(148, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(376, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(1087, (com.tencent.mm.am.h)this);
    showLoadingDialog();
    this.EPh = false;
    this.nzW = false;
    this.lsy = com.tencent.mm.modelgeo.d.bJl();
    com.tencent.mm.modelgeo.d locald = this.lsy;
    if (locald != null) {
      locald.a(this.wGt, true, false);
    }
    l.kK(22, 10);
    AppMethodBeat.o(339965);
  }
  
  private final void eGf()
  {
    AppMethodBeat.i(339976);
    Log.i("NearbyPersonUIC", "showLbsTips");
    com.tencent.mm.plugin.nearby.a.pFn.cI((Context)getActivity());
    AppMethodBeat.o(339976);
  }
  
  private final void eGg()
  {
    AppMethodBeat.i(339982);
    Log.i("NearbyPersonUIC", "dismissTipDialog");
    dismissLoadingDialog();
    AppMethodBeat.o(339982);
  }
  
  private final void eGh()
  {
    AppMethodBeat.i(340036);
    if ((com.tencent.mm.bp.a.iGn()) || (com.tencent.mm.bp.a.iGm()))
    {
      ListView localListView;
      if (this.EOZ != null)
      {
        localListView = this.pVC;
        kotlin.g.b.s.checkNotNull(localListView);
        localListView.removeHeaderView(this.EOZ);
        this.EOZ = null;
      }
      this.EOZ = eGi();
      if (this.EOZ != null)
      {
        localListView = this.pVC;
        kotlin.g.b.s.checkNotNull(localListView);
        localListView.addHeaderView(this.EOZ);
      }
    }
    AppMethodBeat.o(340036);
  }
  
  private final View eGi()
  {
    AppMethodBeat.i(340054);
    Object localObject1 = View.inflate((Context)getActivity(), f.e.EGK, null);
    Object localObject2 = ((View)localObject1).findViewById(f.d.say_hi_count);
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(340054);
      throw ((Throwable)localObject1);
    }
    localObject2 = (TextView)localObject2;
    com.tencent.mm.kernel.h.baC().aZJ();
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaW().dkF();
    if (i == 0)
    {
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(340054);
      return null;
    }
    ((View)localObject1).setVisibility(0);
    ((TextView)localObject2).setText((CharSequence)getActivity().getResources().getQuantityString(f.f.say_hi_count_text_quantity, i, new Object[] { Integer.valueOf(i) }));
    localObject2 = ((View)localObject1).findViewById(f.d.match_dlg_img);
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(340054);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ImageView)localObject2;
    bz localbz = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaW().gbh();
    if (localbz != null) {
      a.b.g((ImageView)localObject2, localbz.field_sayhiuser);
    }
    ((View)localObject1).setOnClickListener(new b..ExternalSyntheticLambda8(this));
    localObject2 = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
    com.tencent.mm.plugin.finder.nearby.report.d.report(11L);
    AppMethodBeat.o(340054);
    return localObject1;
  }
  
  private final void eGj()
  {
    int j = 0;
    AppMethodBeat.i(340066);
    Object localObject1 = (List)new LinkedList();
    int m = this.zPw.size() - 1;
    if (m >= 0) {}
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      Object localObject2 = b.EPt;
      if (!b.QS(((dgy)this.zPw.get(i)).pSf)) {
        ((List)localObject1).add(this.zPw.get(i));
      }
      if (k > m)
      {
        this.zPw.clear();
        this.zPw = ((List)localObject1);
        Log.i("NearbyPersonUIC", kotlin.g.b.s.X("mergeADItemList friendList size:", Integer.valueOf(this.zPw.size())));
        label167:
        List localList;
        if (!((Collection)this.zPw).isEmpty())
        {
          i = 1;
          localObject1 = this.EOP.keySet().iterator();
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (String)((Iterator)localObject1).next();
            } while (i == 0);
            localObject2 = (a.a)this.EOP.get(localObject2);
            kotlin.g.b.s.checkNotNull(localObject2);
          } while ((((a.a)localObject2).uPP) || ((((a.a)localObject2).EOR > 0) && (((a.a)localObject2).EOU >= ((a.a)localObject2).EOR)) || (((a.a)localObject2).wDI >= ((a.a)localObject2).EOS));
          localList = this.zPw;
          if ((((a.a)localObject2).pos >= 0) && (((a.a)localObject2).pos <= this.zPw.size())) {
            break label350;
          }
        }
        label350:
        for (k = this.zPw.size();; k = ((a.a)localObject2).pos + j)
        {
          b localb = b.EPt;
          localList.add(k, b.h(((a.a)localObject2).id, ((a.a)localObject2).icon, ((a.a)localObject2).name, ((a.a)localObject2).desc, ((a.a)localObject2).EOT));
          j += 1;
          break label167;
          i = 0;
          break;
        }
        AppMethodBeat.o(340066);
        return;
      }
    }
  }
  
  private final void eGk()
  {
    AppMethodBeat.i(340075);
    List localList = (List)new LinkedList();
    Iterator localIterator = this.zPw.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      dgy localdgy = (dgy)localIterator.next();
      if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxr(localdgy.UserName))
      {
        localList.add(i, localdgy);
        i += 1;
      }
      else if ((!Util.isNullOrNil(localdgy.UserName)) && (!Util.isNullOrNil(localdgy.aaMl)))
      {
        localList.add(localdgy);
      }
    }
    this.zPw.clear();
    this.zPw = localList;
    AppMethodBeat.o(340075);
  }
  
  private final void eGl()
  {
    AppMethodBeat.i(340134);
    Log.w("NearbyPersonUIC", "showNoPermissionView");
    getRootView().findViewById(f.d.lbs_tips_layout).setVisibility(0);
    getRootView().findViewById(f.d.lbs_tips_request).setOnClickListener(new b..ExternalSyntheticLambda9(this));
    AppMethodBeat.o(340134);
  }
  
  private final void eGm()
  {
    AppMethodBeat.i(340151);
    Log.w("NearbyPersonUIC", "dismissPermissionView");
    getRootView().findViewById(f.d.lbs_tips_layout).setVisibility(8);
    AppMethodBeat.o(340151);
  }
  
  private static final void eGn()
  {
    AppMethodBeat.i(340290);
    com.tencent.mm.plugin.finder.nearby.report.d locald = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
    com.tencent.mm.plugin.finder.nearby.report.d.Rf(6);
    AppMethodBeat.o(340290);
  }
  
  private static final void eGo()
  {
    AppMethodBeat.i(340298);
    Log.i("NearbyPersonUIC", "showLiveBottomSheet dismiss");
    AppMethodBeat.o(340298);
  }
  
  private static final void eGp()
  {
    AppMethodBeat.i(340330);
    com.tencent.mm.plugin.report.service.g.ahx(11);
    AppMethodBeat.o(340330);
  }
  
  private static final void f(kotlin.g.a.a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(340411);
    kotlin.g.b.s.u(parama, "$cancelCallback");
    parama.invoke();
    parama = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
    com.tencent.mm.plugin.finder.nearby.report.d.report(17L);
    AppMethodBeat.o(340411);
  }
  
  private static final void k(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(340259);
    if (params.jmw())
    {
      params.oh(1, f.h.nearby_person_female);
      params.oh(2, f.h.nearby_person_male);
      params.oh(3, f.h.nearby_person_all);
      params.oh(4, f.h.nearby_person_say_hi);
      params.oh(5, f.h.nearby_person_clear_location_exit);
    }
    Log.i("NearbyPersonUIC", "showLiveBottomSheet create menu.");
    AppMethodBeat.o(340259);
  }
  
  private final void requestLocationPermission()
  {
    AppMethodBeat.i(340096);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().d(274436, null);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(340096);
      throw ((Throwable)localObject);
    }
    boolean bool;
    if (com.tencent.mm.au.b.OE((String)localObject))
    {
      bool = com.tencent.mm.pluginsdk.permission.b.s((Context)getActivity(), "android.permission.ACCESS_FINE_LOCATION");
      if (bool) {
        break label197;
      }
      if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acXn, false)) {
        com.tencent.mm.plugin.account.sdk.c.a.b((Context)getActivity(), getActivity().getString(e.h.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
      }
    }
    label197:
    for (;;)
    {
      Log.i("NearbyPersonUIC", kotlin.g.b.s.X("requestLocationPermission checkLocation:", Boolean.valueOf(bool)));
      AppMethodBeat.o(340096);
      return;
      com.tencent.mm.pluginsdk.permission.b.b((Activity)getActivity(), "android.permission.ACCESS_FINE_LOCATION", 153);
      continue;
      bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)getActivity(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 153, null);
    }
  }
  
  private final void showLoadingDialog()
  {
    AppMethodBeat.i(339994);
    Context localContext = (Context)getActivity();
    getString(f.h.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.k.a(localContext, getString(f.h.nearby_friend_locating), true, new b..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(339994);
  }
  
  private static final void u(DialogInterface paramDialogInterface, int paramInt) {}
  
  public final void eGe()
  {
    AppMethodBeat.i(340796);
    this.EPo = new com.tencent.mm.ui.widget.a.f((Context)getActivity(), 1, false);
    com.tencent.mm.ui.widget.a.f localf = this.EPo;
    if (localf != null) {
      localf.Vtg = b..ExternalSyntheticLambda15.INSTANCE;
    }
    localf = this.EPo;
    if (localf != null) {
      localf.GAC = new b..ExternalSyntheticLambda16(this);
    }
    localf = this.EPo;
    if (localf != null) {
      localf.ages = b..ExternalSyntheticLambda17.INSTANCE;
    }
    localf = this.EPo;
    if (localf != null) {
      localf.aeLi = b..ExternalSyntheticLambda18.INSTANCE;
    }
    localf = this.EPo;
    if (localf != null) {
      localf.dDn();
    }
    AppMethodBeat.o(340796);
  }
  
  public final int getLayoutId()
  {
    return f.e.EHg;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(340710);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.g.ahw(11);
    paramBundle = com.tencent.mm.k.i.aRC().getValue("LBSShowBindPhone");
    int i;
    if (paramBundle != null)
    {
      if (((CharSequence)paramBundle).length() <= 0) {
        break label335;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        paramBundle = Integer.valueOf(paramBundle);
        kotlin.g.b.s.s(paramBundle, "{\n                Intege…lueOf(flag)\n            }");
        i = ((Number)paramBundle).intValue();
        this.EPd = i;
        paramBundle = (String)com.tencent.mm.kernel.h.baE().ban().d(6, null);
        if (paramBundle != null)
        {
          if (((CharSequence)paramBundle).length() <= 0) {
            break label346;
          }
          i = 1;
          if (i != 0) {
            this.EPd = 0;
          }
        }
        this.EPi = 0;
        if (com.tencent.mm.model.a.g.bDR().Km("3") != null)
        {
          paramBundle = com.tencent.mm.model.a.g.bDR().Km("3").value;
          localObject = com.tencent.mm.plugin.account.friend.model.i.bWW();
          if (paramBundle == null) {}
        }
        switch (paramBundle.hashCode())
        {
        default: 
          this.EPf = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(16386, null), 1);
          this.EPb = new a((Context)getActivity());
          this.pVC = ((ListView)getRootView().findViewById(f.d.fPh));
          paramBundle = this.pVC;
          if (paramBundle != null) {
            if (this.EOX == null)
            {
              this.EOX = ((ViewGroup)new LinearLayout((Context)getActivity()));
              localObject = this.EOX;
              if (localObject != null) {
                ((ViewGroup)localObject).setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, -2));
              }
              localObject = this.EOX;
              if (localObject == null)
              {
                paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
                AppMethodBeat.o(340710);
                throw paramBundle;
                label335:
                i = 0;
              }
            }
          }
          break;
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        for (;;)
        {
          i = 0;
          continue;
          label346:
          i = 0;
          continue;
          if (paramBundle.equals("0"))
          {
            this.EPi = 0;
            continue;
            if ((paramBundle.equals("1")) && (localObject == i.a.pSO))
            {
              this.EPi = 2;
              continue;
              if ((paramBundle.equals("2")) && (localObject == i.a.pSR)) {
                this.EPi = 2;
              }
            }
          }
        }
        ((LinearLayout)localObject).setGravity(17);
        this.EPc = true;
        paramBundle.addHeaderView((View)this.EOX);
        paramBundle = this.pVC;
        if (paramBundle != null) {
          paramBundle.setAdapter((ListAdapter)this.EPb);
        }
        paramBundle = this.pVC;
        if (paramBundle != null) {
          paramBundle.setOnItemClickListener(new b..ExternalSyntheticLambda12(this));
        }
        paramBundle = this.pVC;
        if (paramBundle != null) {
          paramBundle.setOnTouchListener(new b..ExternalSyntheticLambda11(this));
        }
        this.EPl = System.currentTimeMillis();
        eBW();
        Log.i("NearbyPersonUIC", "onCreate");
        AppMethodBeat.o(340710);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(340782);
    super.onDestroy();
    if (this.EPi > 0) {
      com.tencent.mm.model.a.f.Kr("3");
    }
    com.tencent.mm.plugin.report.service.g.ahy(11);
    com.tencent.mm.kernel.h.aZW().b(148, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(376, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(1087, (com.tencent.mm.am.h)this);
    eGg();
    Object localObject1 = this.lsy;
    if (localObject1 != null) {
      ((com.tencent.mm.modelgeo.d)localObject1).a(this.wGt);
    }
    q.bFG().cancel();
    localObject1 = this.EPb;
    Object localObject2;
    if ((localObject1 != null) && (((a)localObject1).pSE != null))
    {
      localObject2 = ((a)localObject1).pSE;
      kotlin.g.b.s.checkNotNull(localObject2);
      ((com.tencent.mm.ui.applet.b)localObject2).detach();
      ((a)localObject1).pSE = null;
    }
    if (this.zPw.size() > 0)
    {
      localObject2 = this.EOP.values().iterator();
      a.a locala;
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = locala.wDI)
      {
        locala = (a.a)((Iterator)localObject2).next();
        localObject1 = new StringBuilder().append((String)localObject1).append('|').append(locala.id).append(':').append(locala.EOU).append(':');
        locala.wDI += 1;
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZg, localObject1);
    }
    localObject1 = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
    com.tencent.mm.plugin.finder.nearby.report.d.a(null, null, null, null, 0L, 100L, 0L, 0L, 0L, 0L, 0L, 0L, System.currentTimeMillis() - this.EPl, 4063);
    AppMethodBeat.o(340782);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(340755);
    Log.i("NearbyPersonUIC", "onPause");
    com.tencent.mm.modelgeo.d locald = this.lsy;
    if (locald != null) {
      locald.a(this.wGt);
    }
    this.EPp.dead();
    this.nzW = true;
    this.isOnResume = false;
    AppMethodBeat.o(340755);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(340847);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    Log.i("NearbyPersonUIC", "onRequestPermissionsResult requestCode:" + paramInt + " grantResults[0]:" + paramArrayOfInt[0]);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(340847);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        checkTryRequestFirstPageAgain();
        AppMethodBeat.o(340847);
        return;
      }
      Log.i("Finder.NearbyVideoPresenter", "onRequestPermissionsResult return for grant.");
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(340744);
    Log.i("NearbyPersonUIC", "onResume");
    this.isOnResume = true;
    if (!this.isFirstOnResume) {
      checkTryRequestFirstPageAgain();
    }
    eGh();
    Object localObject = this.EPb;
    kotlin.g.b.s.checkNotNull(localObject);
    ((a)localObject).notifyDataSetChanged();
    com.tencent.mm.kernel.h.baC().aZJ();
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaW().dkF() == 0)
    {
      localObject = this.pVC;
      kotlin.g.b.s.checkNotNull(localObject);
      ((ListView)localObject).removeHeaderView(this.EPa);
    }
    this.EPp.alive();
    this.nzW = false;
    this.isFirstOnResume = false;
    AppMethodBeat.o(340744);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    TextView localTextView = null;
    AppMethodBeat.i(340834);
    kotlin.g.b.s.u(paramp, "scene");
    Log.i("NearbyPersonUIC", kotlin.g.b.s.X("onSceneEnd scene.type:", Integer.valueOf(paramp.getType())));
    dismissLoadingDialog();
    if (paramp.getType() == 148)
    {
      int i = ((com.tencent.mm.plugin.nearby.model.c)paramp).bIO();
      if ((eFZ() == null) && ((i == 1) || (i == 3) || (i == 4))) {
        Log.e("NearbyPersonUIC", "handleFindLbsFriends sceneLbsFind:" + eFZ() + " code:" + i);
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.d(this));
        AppMethodBeat.o(340834);
        return;
        if ((this.EPe) && ((i == 1) || (i == 3) || (i == 4)))
        {
          Log.e("NearbyPersonUIC", "handleFindLbsFriends isDataReqed:" + this.EPe + " code:" + i);
        }
        else if ((eGa() == null) && (i == 2))
        {
          Log.e("NearbyPersonUIC", "handleFindLbsFriends sceneClearLocation:" + eGa() + " code:" + i);
        }
        else if (paramp.getType() != 148)
        {
          Log.e("NearbyPersonUIC", kotlin.g.b.s.X("handleFindLbsFriends type:", Integer.valueOf(paramp.getType())));
        }
        else
        {
          Log.i("NearbyPersonUIC", "handleFindLbsFriends errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramString = (com.tencent.mm.plugin.nearby.model.c)paramp;
            switch (i)
            {
            case 2: 
            default: 
              if (((com.tencent.mm.plugin.nearby.model.c)paramp).bIO() == 2)
              {
                com.tencent.mm.ui.base.k.d((Context)getActivity(), getString(f.h.EHm), "", new b..ExternalSyntheticLambda4(this));
                b(null);
                this.EPm = false;
                paramString = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
                paramString = com.tencent.mm.ui.component.k.aeZF;
                m.a.c(2, ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).fou());
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("NearbyPeopleFooterprintClear");
              }
              paramString = (com.tencent.mm.plugin.nearby.model.c)paramp;
              if (!paramString.gsL()) {
                break label1052;
              }
              paramp = getActivity().getString(f.h.EHq);
              kotlin.g.b.s.s(paramp, "activity.getString(R.string.nearby_lbsroom_name)");
              paramInt1 = paramString.gsM();
              if (this.EOX == null) {
                break label1044;
              }
              if (this.EPq == null)
              {
                this.EPq = View.inflate((Context)getActivity(), f.e.EGL, null);
                paramString = this.EOX;
                kotlin.g.b.s.checkNotNull(paramString);
                paramString.addView(this.EPq);
                paramString = this.EPq;
                if (paramString != null) {
                  paramString.setOnClickListener(new b..ExternalSyntheticLambda10(this));
                }
                label588:
                paramString = this.EPq;
                if (paramString != null) {
                  break label896;
                }
              }
              break;
            }
            label896:
            for (paramString = null;; paramString = (TextView)paramString.findViewById(f.d.EGl))
            {
              if (paramString != null) {
                break label910;
              }
              paramString = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
              AppMethodBeat.o(340834);
              throw paramString;
              paramString = paramString.gsN();
              kotlin.g.b.s.s(paramString, "scene.lbsList");
              this.zPw = paramString;
              if ((this.zPw == null) || (this.zPw.size() == 0))
              {
                getRootView().findViewById(f.d.fPi).setVisibility(0);
                paramString = this.pVC;
                kotlin.g.b.s.checkNotNull(paramString);
                paramString.setVisibility(8);
                eGf();
                com.tencent.mm.plugin.report.service.g.ahy(11);
              }
              for (;;)
              {
                switch (this.EPf)
                {
                default: 
                  this.EPf = 1;
                }
                this.EPe = true;
                a(null);
                break;
                eGk();
                if ((this.zPw == null) || (this.zPw.size() == 0))
                {
                  getRootView().findViewById(f.d.fPi).setVisibility(0);
                  paramString = this.pVC;
                  kotlin.g.b.s.checkNotNull(paramString);
                  paramString.setVisibility(8);
                }
                else
                {
                  getRootView().findViewById(f.d.fPi).setVisibility(8);
                  eGj();
                  paramString = this.EPb;
                  kotlin.g.b.s.checkNotNull(paramString);
                  paramString.notifyDataSetChanged();
                  paramString = this.EPb;
                  kotlin.g.b.s.checkNotNull(paramString);
                  if (paramString.getCount() > 0)
                  {
                    paramString = this.pVC;
                    kotlin.g.b.s.checkNotNull(paramString);
                    paramString.setSelection(0);
                  }
                  paramString = this.pVC;
                  kotlin.g.b.s.checkNotNull(paramString);
                  paramString.post(b..ExternalSyntheticLambda19.INSTANCE);
                }
              }
              paramString = this.EPq;
              if (paramString == null) {
                break label588;
              }
              paramString.setVisibility(0);
              break label588;
            }
            label910:
            paramString.setText((CharSequence)paramp);
            if (paramInt1 != 0)
            {
              paramString = this.EPq;
              if (paramString == null) {}
              for (paramString = localTextView; paramString == null; paramString = (TextView)paramString.findViewById(f.d.EGk))
              {
                paramString = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(340834);
                throw paramString;
              }
              paramp = am.aixg;
              paramp = getActivity().getResources().getQuantityString(f.f.EHj, paramInt1, new Object[] { Integer.valueOf(paramInt1) });
              kotlin.g.b.s.s(paramp, "activity.resources.getQu…memberCount, memberCount)");
              paramp = String.format(paramp, Arrays.copyOf(new Object[0], 0));
              kotlin.g.b.s.s(paramp, "java.lang.String.format(format, *args)");
              paramString.setText((CharSequence)paramp);
            }
            for (;;)
            {
              label1044:
              this.EPg = true;
              break;
              label1052:
              if ((this.EPq != null) && (this.EOX != null))
              {
                paramString = this.EPq;
                kotlin.g.b.s.checkNotNull(paramString);
                paramString.setVisibility(8);
              }
            }
          }
          switch (((com.tencent.mm.plugin.nearby.model.c)paramp).bIO())
          {
          }
        }
      }
      paramp = getRootView().findViewById(f.d.fPi);
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(340834);
        throw paramString;
      }
      localTextView = (TextView)paramp;
      localTextView.setVisibility(0);
      eGf();
      if (paramString == null) {
        break label1527;
      }
      if (((CharSequence)paramString).length() > 0)
      {
        paramInt1 = 1;
        label1198:
        if (paramInt1 == 0) {
          break label1527;
        }
      }
    }
    label1214:
    label1248:
    label1527:
    for (paramString = com.tencent.mm.broadcast.a.CH(paramString);; paramString = null)
    {
      if (paramString == null)
      {
        paramp = null;
        if (paramp == null) {
          break label1306;
        }
        paramp = paramString.desc;
        kotlin.g.b.s.s(paramp, "br.desc");
        if (((CharSequence)paramp).length() <= 0) {
          break label1301;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1306;
        }
        localTextView.setText((CharSequence)paramString.desc);
      }
      for (;;)
      {
        paramString = this.pVC;
        kotlin.g.b.s.checkNotNull(paramString);
        paramString.setVisibility(8);
        a(null);
        break;
        paramInt1 = 0;
        break label1198;
        paramp = paramString.desc;
        break label1214;
        paramInt1 = 0;
        break label1248;
        if (paramInt2 == -2001) {
          localTextView.setText((CharSequence)getString(f.h.EHn));
        } else {
          localTextView.setText((CharSequence)getString(f.h.EHo));
        }
      }
      Toast.makeText((Context)getActivity(), f.h.EHl, 1).show();
      b(null);
      break;
      if ((paramp.getType() == 376) && (((com.tencent.mm.plugin.nearby.model.d)paramp).bIO() == 1))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.nearby.model.d)paramp).pss != null))
        {
          paramString = ((com.tencent.mm.plugin.nearby.model.d)paramp).pss;
          paramp = ((com.tencent.mm.plugin.nearby.model.d)paramp).MoA;
          kotlin.g.b.s.s(paramString, "roomName");
          kotlin.g.b.s.s(paramp, "roomNickname");
          com.tencent.mm.plugin.nearby.model.b.kF(paramString, paramp);
          paramp = new Intent();
          paramp.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.nearby.a.pFn.e(paramp, (Context)getActivity());
          AppMethodBeat.o(340834);
          return;
        }
        com.tencent.mm.ui.base.k.a((Context)getActivity(), f.h.EHp, f.h.app_tip, b..ExternalSyntheticLambda7.INSTANCE);
      }
      AppMethodBeat.o(340834);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(340765);
    super.onStop();
    eBW();
    AppMethodBeat.o(340765);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(340725);
    super.onUserVisibleFocused();
    this.isOnUserVisibleFocused = true;
    Object localObject3 = (kotlin.g.a.a)new b.f(this);
    Object localObject2 = (kotlin.g.a.a)new b.e(this);
    View localView;
    Object localObject1;
    Context localContext;
    int i;
    int j;
    int k;
    if (!this.EPn)
    {
      localView = View.inflate((Context)getActivity(), f.e.gli, null);
      if (localView == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = localView.findViewById(f.d.fMB))
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(340725);
        throw ((Throwable)localObject1);
      }
      ((View)localObject1).setVisibility(4);
      localContext = (Context)getActivity();
      i = f.h.app_tip;
      j = f.h.app_ok;
      k = f.h.app_back;
      localObject1 = new b..ExternalSyntheticLambda5((kotlin.g.a.a)localObject3);
      localObject2 = new b..ExternalSyntheticLambda6((kotlin.g.a.a)localObject2);
      if ((!(localContext instanceof Activity)) || (!((Activity)localContext).isFinishing())) {
        break label268;
      }
      localObject1 = null;
    }
    for (;;)
    {
      ((com.tencent.mm.ui.widget.a.e)localObject1).show();
      localObject1 = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
      com.tencent.mm.plugin.finder.nearby.report.d.report(15L);
      this.EPn = true;
      if (!this.isFirstOnUserVisibleFocused) {
        checkTryRequestFirstPageAgain();
      }
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      m.a.c(3, ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).fou());
      this.isFirstOnUserVisibleFocused = false;
      Log.i("NearbyPersonUIC", "onUserVisibleFocused");
      AppMethodBeat.o(340725);
      return;
      label268:
      localObject3 = new e.a(localContext);
      ((e.a)localObject3).aEK(i);
      ((e.a)localObject3).aEO(-1);
      ((e.a)localObject3).md(localView);
      ((e.a)localObject3).aER(j).c((DialogInterface.OnClickListener)localObject1);
      ((e.a)localObject3).aES(k).d((DialogInterface.OnClickListener)localObject2);
      ((e.a)localObject3).e(new k.11((DialogInterface.OnClickListener)localObject2));
      localObject1 = ((e.a)localObject3).jHH();
      ((com.tencent.mm.ui.widget.a.e)localObject1).show();
      com.tencent.mm.ui.base.k.a(localContext, (Dialog)localObject1);
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(340734);
    super.onUserVisibleUnFocused();
    this.isOnUserVisibleFocused = false;
    Log.i("NearbyPersonUIC", "onUserVisibleUnFocused");
    AppMethodBeat.o(340734);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC;Landroid/content/Context;)V", "earlyGetHeadImg", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg;", "getter", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg$IGetUsername;", "detach", "", "getCount", "", "getItem", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setImgBmp", "img", "Landroid/widget/ImageView;", "url", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends BaseAdapter
  {
    private final Context context;
    com.tencent.mm.ui.applet.b pSE;
    private com.tencent.mm.ui.applet.b.b pSF;
    
    public a()
    {
      AppMethodBeat.i(339818);
      this.context = localObject;
      this.pSE = new com.tencent.mm.ui.applet.b(b.a..ExternalSyntheticLambda1.INSTANCE);
      AppMethodBeat.o(339818);
    }
    
    private static final void a(b paramb, dgy paramdgy, a parama, View paramView)
    {
      AppMethodBeat.i(339841);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(paramdgy);
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramb, "this$0");
      kotlin.g.b.s.u(paramdgy, "$contactInfo");
      kotlin.g.b.s.u(parama, "this$1");
      paramdgy = (a.a)paramb.EOP.get(paramdgy.UserName);
      if (paramdgy != null)
      {
        paramdgy.EOU += 1;
        paramdgy.uPP = true;
        paramdgy.EOV |= 0x2;
      }
      b.e(paramb);
      parama.notifyDataSetChanged();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(339841);
    }
    
    private static final void a(dgy paramdgy, b paramb, int paramInt)
    {
      AppMethodBeat.i(339852);
      kotlin.g.b.s.u(paramdgy, "$contactInfo");
      kotlin.g.b.s.u(paramb, "this$0");
      Object localObject1 = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
      boolean bool1 = b.d(paramdgy);
      int i = b.d(paramb);
      boolean bool2 = b.e(paramdgy);
      kotlin.g.b.s.u(paramdgy, "contactInfo");
      localObject1 = paramdgy.UserName;
      paramb = (b)localObject1;
      if (localObject1 == null) {
        paramb = "";
      }
      Object localObject2 = paramdgy.aaMl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Object localObject3 = paramdgy.pSo;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      String str = paramdgy.pSh;
      localObject3 = str;
      if (str == null) {
        localObject3 = "";
      }
      long l1;
      long l5;
      long l2;
      label141:
      label174:
      long l3;
      if (bool1)
      {
        l1 = 1L;
        l5 = com.tencent.mm.plugin.finder.nearby.report.d.Re(i);
        if (!bool2) {
          break label253;
        }
        l2 = 1L;
        if (paramdgy.pSi == null) {
          break label264;
        }
        str = paramdgy.pSi;
        kotlin.g.b.s.s(str, "contactInfo.Signature");
        if (kotlin.n.n.bp((CharSequence)str)) {
          break label259;
        }
        i = 1;
        if (i == 0) {
          break label264;
        }
        l3 = 1L;
        label181:
        if (!((com.tencent.mm.plugin.emoji.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.a.class)).aa((CharSequence)paramdgy.vhX)) {
          break label270;
        }
      }
      label259:
      label264:
      label270:
      for (long l4 = 1L;; l4 = 0L)
      {
        com.tencent.mm.plugin.finder.nearby.report.d.a(paramb, (String)localObject2, (String)localObject3, (String)localObject1, l1, 1L, l5, l2, l3, l4, 1L + paramInt, paramdgy.pSf, 0L, 4096);
        AppMethodBeat.o(339852);
        return;
        l1 = 0L;
        break;
        label253:
        l2 = 0L;
        break label141;
        i = 0;
        break label174;
        l3 = 0L;
        break label181;
      }
    }
    
    private static final Bitmap azb(String paramString)
    {
      AppMethodBeat.i(339833);
      paramString = com.tencent.mm.modelavatar.d.a(paramString, false, -1, null);
      AppMethodBeat.o(339833);
      return paramString;
    }
    
    private static void j(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(339826);
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        Log.e("NearbyPersonUIC", "setImgBmp url is empty");
        AppMethodBeat.o(339826);
        return;
      }
      if (paramImageView != null) {
        paramImageView.setImageBitmap(null);
      }
      Object localObject = new com.tencent.mm.modelimage.loader.a.c.a();
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).prefixPath = com.tencent.mm.plugin.image.d.bzL();
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKp = true;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).nqa = true;
      localObject = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).bKx();
      r.bKe().a(paramString, paramImageView, (com.tencent.mm.modelimage.loader.a.c)localObject);
      AppMethodBeat.o(339826);
    }
    
    public final dgy QR(int paramInt)
    {
      AppMethodBeat.i(339920);
      dgy localdgy = (dgy)b.c(b.this).get(paramInt);
      AppMethodBeat.o(339920);
      return localdgy;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(339874);
      int i = b.c(b.this).size();
      AppMethodBeat.o(339874);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(339911);
      if (this.pSF == null) {
        this.pSF = ((com.tencent.mm.ui.applet.b.b)new a(this));
      }
      if (this.pSE != null)
      {
        paramViewGroup = this.pSE;
        kotlin.g.b.s.checkNotNull(paramViewGroup);
        paramViewGroup.a(paramInt, this.pSF);
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      TextView localTextView;
      label855:
      label1117:
      int i;
      label940:
      int k;
      label1156:
      int j;
      if (paramView == null)
      {
        paramViewGroup = new b.c();
        paramView = View.inflate(this.context, f.e.EHf, null);
        localObject1 = paramView.findViewById(f.d.nearby_friend_name);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.pQZ = ((TextView)localObject1);
        localObject1 = paramView.findViewById(f.d.fPk);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.EPw = ((TextView)localObject1);
        localObject1 = paramView.findViewById(f.d.fPf);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.EPv = ((TextView)localObject1);
        localObject1 = paramView.findViewById(f.d.nearby_friend_avatar_iv);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.avatar = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.fPg);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.pSI = ((TextView)localObject1);
        localObject1 = paramView.findViewById(f.d.fPl);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.EPx = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.EGj);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.EPy = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.finder_icon);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.EPz = ((View)localObject1);
        localObject1 = paramView.findViewById(f.d.EGf);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.EPA = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.EGg);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.EPB = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.EGh);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.EPC = ((ImageView)localObject1);
        localObject1 = paramView.findViewById(f.d.close_btn);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.nkq = ((ImageView)localObject1);
        localObject1 = paramViewGroup.EPy;
        kotlin.g.b.s.checkNotNull(localObject1);
        localObject1 = ((ImageView)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.br(this.context, f.b.Edge_2A);
        ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cd.a.br(this.context, f.b.Edge_2A);
        localObject2 = paramViewGroup.EPy;
        kotlin.g.b.s.checkNotNull(localObject2);
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject2 = paramViewGroup.EPz;
        kotlin.g.b.s.checkNotNull(localObject2);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = paramView.findViewById(f.d.fPj);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(339911);
          throw paramView;
        }
        paramViewGroup.DSo = ((ImageView)localObject1);
        paramView.setTag(paramViewGroup);
        localObject2 = (dgy)b.c(b.this).get(paramInt);
        localObject1 = paramViewGroup.pQZ;
        if (localObject1 != null)
        {
          localObject3 = this.context;
          localObject4 = (CharSequence)((dgy)localObject2).vhX;
          localTextView = paramViewGroup.pQZ;
          kotlin.g.b.s.checkNotNull(localTextView);
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject3, (CharSequence)localObject4, localTextView.getTextSize()));
        }
        if (b.d(b.this) != 1) {
          break label1539;
        }
        switch (((dgy)localObject2).pSf)
        {
        default: 
          localObject1 = paramViewGroup.DSo;
          if (localObject1 != null) {
            ((ImageView)localObject1).setVisibility(8);
          }
          localObject1 = ah.aiuX;
          if (((dgy)localObject2).aaMm != 0)
          {
            localObject1 = paramViewGroup.EPx;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(0);
            }
            localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.okR.vd(((dgy)localObject2).aaMm), 2.0F);
            localObject3 = paramViewGroup.EPx;
            if (localObject3 != null)
            {
              ((ImageView)localObject3).setImageBitmap((Bitmap)localObject1);
              localObject1 = ah.aiuX;
            }
            localObject1 = paramViewGroup.DSo;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.EPv;
            if (localObject1 != null) {
              ((TextView)localObject1).setText((CharSequence)((dgy)localObject2).aaMl);
            }
            localObject1 = paramViewGroup.EPA;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.EPB;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.EPC;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            localObject1 = paramViewGroup.nkq;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(8);
            }
            if ((localObject2 instanceof com.tencent.mm.plugin.nearby.model.a))
            {
              localObject1 = ((com.tencent.mm.plugin.nearby.model.a)localObject2).Mox;
              if ((localObject1 == null) || (((LinkedList)localObject1).size() != 1)) {
                break label1581;
              }
              localObject3 = paramViewGroup.EPA;
              if (localObject3 != null) {
                ((ImageView)localObject3).setVisibility(0);
              }
              localObject3 = paramViewGroup.EPA;
              localObject1 = ((LinkedList)localObject1).get(0);
              kotlin.g.b.s.s(localObject1, "adIconUrl[0]");
              j((ImageView)localObject3, (String)localObject1);
              localObject1 = (a.a)b.this.EOP.get(((dgy)localObject2).UserName);
              if (localObject1 != null)
              {
                if (((a.a)localObject1).EOV != -1) {
                  break label1860;
                }
                i = 0;
                ((a.a)localObject1).EOV = i;
                if (((a.a)localObject1).EOR > 0)
                {
                  localObject1 = paramViewGroup.nkq;
                  if (localObject1 != null) {
                    ((ImageView)localObject1).setVisibility(0);
                  }
                }
              }
              localObject1 = paramViewGroup.nkq;
              if (localObject1 != null)
              {
                ((ImageView)localObject1).setOnClickListener(new b.a..ExternalSyntheticLambda0(b.this, (dgy)localObject2, this));
                localObject1 = ah.aiuX;
              }
            }
            if (((dgy)localObject2).pSi == null) {
              break label1930;
            }
            localObject1 = ((dgy)localObject2).pSi;
            kotlin.g.b.s.s(localObject1, "contactInfo.Signature");
            localObject1 = (CharSequence)localObject1;
            i = ((CharSequence)localObject1).length() - 1;
            k = 0;
            j = 0;
          }
          break;
        }
      }
      for (;;)
      {
        label1269:
        if (j > i) {
          break label1906;
        }
        int m;
        if (k == 0)
        {
          m = j;
          label1285:
          if (kotlin.g.b.s.compare(((CharSequence)localObject1).charAt(m), 32) > 0) {
            break label1877;
          }
          m = 1;
        }
        for (;;)
        {
          if (k == 0)
          {
            if (m == 0)
            {
              k = 1;
              break label1269;
              paramViewGroup = paramView.getTag();
              if (paramViewGroup == null)
              {
                paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.ViewHolder");
                AppMethodBeat.o(339911);
                throw paramView;
              }
              paramViewGroup = (b.c)paramViewGroup;
              break;
              localObject1 = paramViewGroup.DSo;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.DSo;
              if (localObject1 != null)
              {
                ((ImageView)localObject1).setImageResource(f.g.ic_sex_male);
                localObject1 = ah.aiuX;
              }
              localObject1 = paramViewGroup.DSo;
              if (localObject1 != null) {
                ((ImageView)localObject1).setContentDescription((CharSequence)this.context.getString(f.h.male_Imgbtn));
              }
              localObject1 = ah.aiuX;
              break label855;
              localObject1 = paramViewGroup.DSo;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = paramViewGroup.DSo;
              if (localObject1 != null)
              {
                ((ImageView)localObject1).setImageResource(f.g.ic_sex_female);
                localObject1 = ah.aiuX;
              }
              localObject1 = paramViewGroup.DSo;
              if (localObject1 != null) {
                ((ImageView)localObject1).setContentDescription((CharSequence)this.context.getString(f.h.female_Imgbtn));
              }
              localObject1 = ah.aiuX;
              break label855;
              localObject1 = paramViewGroup.DSo;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(8);
              }
              localObject1 = ah.aiuX;
              break label855;
              label1539:
              localObject1 = paramViewGroup.DSo;
              if (localObject1 == null) {
                break label855;
              }
              ((ImageView)localObject1).setVisibility(8);
              break label855;
              localObject1 = paramViewGroup.EPx;
              if (localObject1 == null) {
                break label940;
              }
              ((ImageView)localObject1).setVisibility(8);
              break label940;
              label1581:
              if ((localObject1 != null) && (((LinkedList)localObject1).size() == 2))
              {
                localObject3 = paramViewGroup.EPA;
                if (localObject3 != null) {
                  ((ImageView)localObject3).setVisibility(0);
                }
                localObject3 = paramViewGroup.EPB;
                if (localObject3 != null) {
                  ((ImageView)localObject3).setVisibility(0);
                }
                localObject3 = paramViewGroup.EPA;
                localObject4 = ((LinkedList)localObject1).get(0);
                kotlin.g.b.s.s(localObject4, "adIconUrl[0]");
                j((ImageView)localObject3, (String)localObject4);
                localObject3 = paramViewGroup.EPB;
                localObject1 = ((LinkedList)localObject1).get(1);
                kotlin.g.b.s.s(localObject1, "adIconUrl[1]");
                j((ImageView)localObject3, (String)localObject1);
                break label1117;
              }
              if ((localObject1 == null) || (((LinkedList)localObject1).size() < 3)) {
                break label1117;
              }
              localObject3 = paramViewGroup.EPA;
              if (localObject3 != null) {
                ((ImageView)localObject3).setVisibility(0);
              }
              localObject3 = paramViewGroup.EPB;
              if (localObject3 != null) {
                ((ImageView)localObject3).setVisibility(0);
              }
              localObject3 = paramViewGroup.EPC;
              if (localObject3 != null) {
                ((ImageView)localObject3).setVisibility(0);
              }
              localObject3 = paramViewGroup.EPA;
              localObject4 = ((LinkedList)localObject1).get(0);
              kotlin.g.b.s.s(localObject4, "adIconUrl[0]");
              j((ImageView)localObject3, (String)localObject4);
              localObject3 = paramViewGroup.EPB;
              localObject4 = ((LinkedList)localObject1).get(1);
              kotlin.g.b.s.s(localObject4, "adIconUrl[1]");
              j((ImageView)localObject3, (String)localObject4);
              localObject3 = paramViewGroup.EPC;
              localObject1 = ((LinkedList)localObject1).get(2);
              kotlin.g.b.s.s(localObject1, "adIconUrl[2]");
              j((ImageView)localObject3, (String)localObject1);
              break label1117;
              label1860:
              i = ((a.a)localObject1).EOV;
              break label1156;
              m = i;
              break label1285;
              label1877:
              m = 0;
              continue;
            }
            j += 1;
            break label1269;
          }
        }
        if (m == 0) {
          break label1906;
        }
        i -= 1;
      }
      label1906:
      if (kotlin.g.b.s.p(((CharSequence)localObject1).subSequence(j, i + 1).toString(), ""))
      {
        localObject1 = paramViewGroup.EPw;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        if (!b.d((dgy)localObject2)) {
          break label2224;
        }
        localObject1 = paramViewGroup.EPy;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        if (!b.e((dgy)localObject2)) {
          break label2245;
        }
        localObject1 = paramViewGroup.EPz;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = b.b.EPt;
        if (!b.b.QS(((dgy)localObject2).pSf)) {
          break label2307;
        }
        localObject1 = paramViewGroup.avatar;
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setImageBitmap(null);
          localObject1 = ah.aiuX;
        }
        localObject1 = new com.tencent.mm.modelimage.loader.a.c.a();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).prefixPath = com.tencent.mm.plugin.image.d.bzL();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKp = true;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).nqa = true;
        localObject1 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).bKx();
        r.bKe().a(((dgy)localObject2).ZhP, paramViewGroup.avatar, (com.tencent.mm.modelimage.loader.a.c)localObject1);
        if (!Util.isNullOrNil(((dgy)localObject2).pSk)) {
          break label2266;
        }
        paramViewGroup = paramViewGroup.pSI;
        if (paramViewGroup != null) {
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        label1930:
        label1973:
        label1998:
        if (paramView != null) {
          paramView.post(new b.a..ExternalSyntheticLambda2((dgy)localObject2, b.this, paramInt));
        }
        AppMethodBeat.o(339911);
        return paramView;
        localObject1 = paramViewGroup.EPw;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
        localObject1 = paramViewGroup.EPw;
        if (localObject1 == null) {
          break;
        }
        localObject3 = this.context;
        localObject4 = (CharSequence)((dgy)localObject2).pSi;
        localTextView = paramViewGroup.EPw;
        kotlin.g.b.s.checkNotNull(localTextView);
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject3, (CharSequence)localObject4, localTextView.getTextSize()));
        break;
        label2224:
        localObject1 = paramViewGroup.EPy;
        if (localObject1 == null) {
          break label1973;
        }
        ((ImageView)localObject1).setVisibility(8);
        break label1973;
        label2245:
        localObject1 = paramViewGroup.EPz;
        if (localObject1 == null) {
          break label1998;
        }
        ((View)localObject1).setVisibility(8);
        break label1998;
        label2266:
        localObject1 = paramViewGroup.pSI;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)((dgy)localObject2).pSk);
        }
        paramViewGroup = paramViewGroup.pSI;
        if (paramViewGroup != null)
        {
          paramViewGroup.setVisibility(0);
          continue;
          label2307:
          a.b.g(paramViewGroup.avatar, ((dgy)localObject2).UserName);
          if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxr(((dgy)localObject2).UserName))
          {
            localObject1 = paramViewGroup.pSI;
            if (localObject1 != null) {
              ((TextView)localObject1).setVisibility(0);
            }
            if (au.ayS(((dgy)localObject2).aaMm))
            {
              paramViewGroup = paramViewGroup.pSI;
              if (paramViewGroup != null) {
                paramViewGroup.setText((CharSequence)this.context.getString(f.h.gOo));
              }
            }
            else
            {
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(((dgy)localObject2).UserName);
              if (localObject1 != null)
              {
                localObject3 = paramViewGroup.pQZ;
                if (localObject3 != null)
                {
                  localObject4 = this.context;
                  if (!Util.isNullOrNil(((au)localObject1).aSV())) {
                    break label2536;
                  }
                }
              }
              label2536:
              for (localObject1 = ((dgy)localObject2).vhX;; localObject1 = ((au)localObject1).aSV())
              {
                localObject1 = (CharSequence)localObject1;
                localTextView = paramViewGroup.pQZ;
                kotlin.g.b.s.checkNotNull(localTextView);
                ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject4, (CharSequence)localObject1, localTextView.getTextSize()));
                paramViewGroup = paramViewGroup.pSI;
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
            paramViewGroup = paramViewGroup.pSI;
            if (paramViewGroup != null) {
              paramViewGroup.setVisibility(8);
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$NearbyFriendAdapter$getView$1", "Lcom/tencent/mm/ui/applet/EarlyGetHeadImg$IGetUsername;", "getMaxPos", "", "getUsername", "", "pos", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.ui.applet.b.b
    {
      a(b.a parama) {}
      
      public final int bWT()
      {
        AppMethodBeat.i(339912);
        int i = this.EPs.getCount();
        AppMethodBeat.o(339912);
        return i;
      }
      
      public final String yq(int paramInt)
      {
        AppMethodBeat.i(339907);
        if ((paramInt < 0) || (paramInt >= this.EPs.getCount()))
        {
          Log.e("NearbyPersonUIC", "pos is invalid");
          AppMethodBeat.o(339907);
          return null;
        }
        Object localObject = this.EPs.QR(paramInt);
        if (localObject == null)
        {
          AppMethodBeat.o(339907);
          return null;
        }
        localObject = ((dgy)localObject).UserName;
        AppMethodBeat.o(339907);
        return localObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$PoiItemConverter;", "", "()V", "SEX_FOR_POI_ITEM", "", "convertToLbsContactInfo", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "id", "", "icon", "name", "desc", "value", "getPoiLink", "info", "isSexForPoiItem", "", "sexVal", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final b EPt;
    private static int EPu;
    
    static
    {
      AppMethodBeat.i(339827);
      EPt = new b();
      EPu = 10000;
      AppMethodBeat.o(339827);
    }
    
    public static boolean QS(int paramInt)
    {
      return paramInt == EPu;
    }
    
    public static dgy h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(339814);
      com.tencent.mm.plugin.nearby.model.a locala = new com.tencent.mm.plugin.nearby.model.a();
      locala.pSf = EPu;
      locala.UserName = paramString1;
      locala.ZhP = paramString2;
      locala.aaMl = paramString4;
      locala.vhX = paramString3;
      locala.pSg = paramString5;
      paramString1 = (dgy)locala;
      AppMethodBeat.o(339814);
      return paramString1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$ViewHolder;", "", "()V", "adIconImg1", "Landroid/widget/ImageView;", "getAdIconImg1", "()Landroid/widget/ImageView;", "setAdIconImg1", "(Landroid/widget/ImageView;)V", "adIconImg2", "getAdIconImg2", "setAdIconImg2", "adIconImg3", "getAdIconImg3", "setAdIconImg3", "addState", "Landroid/widget/TextView;", "getAddState", "()Landroid/widget/TextView;", "setAddState", "(Landroid/widget/TextView;)V", "avatar", "getAvatar", "setAvatar", "closeBtn", "getCloseBtn", "setCloseBtn", "displayName", "getDisplayName", "setDisplayName", "distance", "getDistance", "setDistance", "finderFlagIv", "Landroid/view/View;", "getFinderFlagIv", "()Landroid/view/View;", "setFinderFlagIv", "(Landroid/view/View;)V", "sex", "getSex", "setSex", "sign", "getSign", "setSign", "snsFlagIv", "getSnsFlagIv", "setSnsFlagIv", "vuserinfoIv", "getVuserinfoIv", "setVuserinfoIv", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    ImageView DSo;
    ImageView EPA;
    ImageView EPB;
    ImageView EPC;
    TextView EPv;
    TextView EPw;
    ImageView EPx;
    ImageView EPy;
    View EPz;
    ImageView avatar;
    ImageView nkq;
    TextView pQZ;
    TextView pSI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.b
 * JD-Core Version:    0.7.0.1
 */