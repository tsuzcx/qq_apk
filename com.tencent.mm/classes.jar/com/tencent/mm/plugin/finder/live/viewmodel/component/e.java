package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.cgi.bs;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.av;
import com.tencent.mm.plugin.finder.live.report.q.j;
import com.tencent.mm.plugin.finder.live.ui.livepost.c;
import com.tencent.mm.plugin.finder.live.ui.livepost.c.b;
import com.tencent.mm.plugin.findersdk.a.av;
import com.tencent.mm.plugin.findersdk.a.aw;
import com.tencent.mm.plugin.findersdk.a.bo;
import com.tencent.mm.plugin.findersdk.a.cl;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLivePostBtnUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePostBtnUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "MENU_ID_CHECK_NOTICE", "", "MENU_ID_CREATE_NOTICE", "MENU_ID_OPEN_LIVE", "TAG", "", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "interceptShowNoticeListClick", "Lkotlin/Function0;", "", "getInterceptShowNoticeListClick", "()Lkotlin/jvm/functions/Function0;", "setInterceptShowNoticeListClick", "(Lkotlin/jvm/functions/Function0;)V", "liveBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "livePostHelper", "Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper;", "getLivePostHelper", "()Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper;", "livePostHelper$delegate", "Lkotlin/Lazy;", "onNoticeOpSceneEndCallBack", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "errMsg", "Lcom/tencent/mm/plugin/findersdk/api/INetSceneCreateLiveNotice;", "scene", "getOnNoticeOpSceneEndCallBack", "()Lkotlin/jvm/functions/Function4;", "setOnNoticeOpSceneEndCallBack", "(Lkotlin/jvm/functions/Function4;)V", "reportReport", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getReportReport", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reportReport$delegate", "checkAccountValid", "", "finderUsername", "doDelFinderNotice", "liveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePostHelper;", "handleLiveMenuItemSelected", "menuId", "prepareInfo", "Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper$LivePrepareInfo;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onLivePostBtnClick", "onResume", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "setOnNoticeOpSceneEndCallBack1", "_callback", "showLiveBottomSheet", "showOrDimissLoading", "show", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
  implements com.tencent.mm.am.h, av
{
  private final int EaJ;
  private final int EaK;
  private final int EaL;
  private com.tencent.mm.ui.widget.a.f EaM;
  private final kotlin.j EaN;
  private r<? super Integer, ? super Integer, ? super String, ? super cl, ah> EaO;
  private kotlin.g.a.a<ah> EaP;
  private final kotlin.j EaQ;
  private final String TAG;
  w rYw;
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356897);
    this.TAG = "FinderLivePostUIC";
    this.EaJ = 10001;
    this.EaK = 10002;
    this.EaL = 10003;
    this.EaN = k.cm((kotlin.g.a.a)new e.b(this));
    this.EaQ = k.cm((kotlin.g.a.a)new e.a(this));
    AppMethodBeat.o(356897);
  }
  
  private static final void X(boolean paramBoolean, String paramString) {}
  
  private final void a(int paramInt, c.b paramb)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 1;
    int j = 1;
    AppMethodBeat.i(356928);
    label125:
    Object localObject3;
    label191:
    label196:
    Object localObject4;
    if (paramInt == this.EaJ)
    {
      com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqQ.mwI, "");
      if (paramb != null)
      {
        localObject2 = paramb.DIf;
        if (localObject2 != null)
        {
          if (paramb.errCode == 0)
          {
            paramb = aj.CGT;
            if ((aj.elr() == null) && (((awa)localObject2).ZGo != null))
            {
              paramb = ((awa)localObject2).ZGo;
              if (paramb == null)
              {
                paramb = null;
                if (paramb == null) {
                  break label222;
                }
                paramb = ((awa)localObject2).ZGo;
                if (paramb == null) {
                  break label191;
                }
                paramb = paramb.liveInfo;
                if ((paramb == null) || (paramb.liveId != 0L)) {
                  break label191;
                }
                paramInt = j;
                if (paramInt != 0) {
                  break label222;
                }
                localObject3 = this.TAG;
                paramb = ((awa)localObject2).ZGo;
                if (paramb != null) {
                  break label196;
                }
                paramb = (c.b)localObject1;
              }
              for (;;)
              {
                Log.i((String)localObject3, kotlin.g.b.s.X("continue live:", paramb));
                paramb = exN();
                if (paramb == null) {
                  break label314;
                }
                paramb.f(((awa)localObject2).ZGo);
                AppMethodBeat.o(356928);
                return;
                paramb = paramb.liveInfo;
                break;
                paramInt = 0;
                break label125;
                localObject4 = paramb.liveInfo;
                paramb = (c.b)localObject1;
                if (localObject4 != null) {
                  paramb = Long.valueOf(((bip)localObject4).liveId);
                }
              }
            }
            label222:
            paramb = exN();
            if (paramb != null)
            {
              c.a(paramb, (awa)localObject2);
              AppMethodBeat.o(356928);
            }
          }
          else
          {
            localObject1 = (CharSequence)paramb.errMsg;
            paramInt = i;
            if (localObject1 != null)
            {
              if (((CharSequence)localObject1).length() != 0) {
                break label320;
              }
              paramInt = i;
            }
            if (paramInt == 0) {
              break label325;
            }
          }
          label314:
          label320:
          label325:
          for (paramb = getContext().getResources().getString(p.h.CqA);; paramb = paramb.errMsg)
          {
            kotlin.g.b.s.s(paramb, "if (prepareInfo.errMsg.i…                        }");
            aa.makeText((Context)getContext(), (CharSequence)paramb, 0).show();
            AppMethodBeat.o(356928);
            return;
            paramInt = 0;
            break;
          }
        }
      }
      else
      {
        Log.w(this.TAG, "handleLiveMenuItemSelected resp is null, ignore");
        AppMethodBeat.o(356928);
      }
    }
    else
    {
      if (paramInt == this.EaL)
      {
        if (this.EaP != null)
        {
          localObject1 = this.EaP;
          if (localObject1 != null) {
            ((kotlin.g.a.a)localObject1).invoke();
          }
          localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          localObject3 = q.av.DzW;
          if (paramb != null) {
            break label519;
          }
          paramb = "";
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.av)localObject3, "", paramb);
          AppMethodBeat.o(356928);
          return;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("finder_username", z.bAW());
          ((Intent)localObject1).putExtra("KEY_FINDER_SELF_FLAG", true);
          ((Intent)localObject1).putExtra("KEY_FINDER_PROFILE_UI_AFTER_SHOW_NOTICE_LIST", true);
          localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
          kotlin.g.b.s.s(localObject2, "service(IFinderCommonService::class.java)");
          h.a.a((com.tencent.mm.plugin.h)localObject2, (Context)getActivity(), (Intent)localObject1, 0, 124);
          ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).enterFinderProfileUI((Context)getActivity(), (Intent)localObject1);
          break;
          label519:
          paramb = paramb.DIf;
          if (paramb == null)
          {
            paramb = "";
          }
          else
          {
            paramb = paramb.live_notice_info;
            if (paramb == null)
            {
              paramb = "";
            }
            else
            {
              localObject1 = paramb.YSR;
              paramb = (c.b)localObject1;
              if (localObject1 == null) {
                paramb = "";
              }
            }
          }
        }
      }
      if (paramInt == this.EaK)
      {
        if (paramb == null)
        {
          localObject1 = null;
          paramb = com.tencent.mm.plugin.finder.live.report.j.Dob;
          localObject3 = com.tencent.mm.plugin.finder.live.report.j.Doc;
          if (((getActivity() instanceof bo)) || (!(getActivity() instanceof com.tencent.mm.plugin.finder.interfaces.a))) {
            break label836;
          }
          paramb = q.j.DsV;
          label617:
          kotlin.g.b.s.u(paramb, "<set-?>");
          ((q)localObject3).DqA = paramb;
          localObject4 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          q.av localav = q.av.DzQ;
          if (localObject1 != null) {
            break label843;
          }
          paramb = "";
          label648:
          ((com.tencent.mm.plugin.finder.live.report.j)localObject4).a(localav, "", paramb);
          if (localObject1 == null) {
            break label1109;
          }
          if (((awa)localObject1).live_notice_info != null)
          {
            paramb = ((awa)localObject1).live_notice_info;
            if (paramb != null) {
              break label879;
            }
            paramb = (c.b)localObject2;
            label684:
            paramb = (CharSequence)paramb;
            if ((paramb != null) && (paramb.length() != 0)) {
              break label887;
            }
            paramInt = 1;
            label704:
            if (paramInt == 0) {
              break label912;
            }
          }
          paramb = exN().AwM;
          if (paramb != null)
          {
            paramb = paramb.ZEd;
            if (paramb != null)
            {
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("KEY_FINDER_LIVE_NOTICE_IS_FROM_PROFILE", getActivity() instanceof com.tencent.mm.plugin.finder.interfaces.a);
              localObject3 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
              kotlin.g.b.s.s(localObject3, "service(IActivityRouter::class.java)");
              f.a.a((com.tencent.mm.plugin.f)localObject3, (Activity)getActivity(), (Intent)localObject2, paramb);
            }
          }
          localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          localObject3 = q.av.DzR;
          paramb = ((awa)localObject1).live_notice_info;
          if (paramb != null) {
            break label892;
          }
          paramb = "";
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.av)localObject3, "", paramb);
          AppMethodBeat.o(356928);
          return;
          localObject1 = paramb.DIf;
          break;
          label836:
          paramb = q.j.DsU;
          break label617;
          label843:
          paramb = ((awa)localObject1).live_notice_info;
          if (paramb == null)
          {
            paramb = "";
            break label648;
          }
          localObject3 = paramb.YSR;
          paramb = (c.b)localObject3;
          if (localObject3 != null) {
            break label648;
          }
          paramb = "";
          break label648;
          label879:
          paramb = paramb.hAR;
          break label684;
          label887:
          paramInt = 0;
          break label704;
          label892:
          localObject1 = paramb.YSR;
          paramb = (c.b)localObject1;
          if (localObject1 == null) {
            paramb = "";
          }
        }
        label912:
        if ((getActivity() instanceof com.tencent.mm.plugin.finder.interfaces.a))
        {
          aa.makeText((Context)getActivity(), (CharSequence)getActivity().getString(p.h.Cuc), 0).show();
          AppMethodBeat.o(356928);
          return;
        }
        Log.i(this.TAG, "goto live notice");
        paramb = new Intent();
        paramb.putExtra("finder_username", z.bAW());
        paramb.putExtra("KEY_FINDER_SELF_FLAG", true);
        localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        kotlin.g.b.s.s(localObject2, "service(IFinderCommonService::class.java)");
        h.a.a((com.tencent.mm.plugin.h)localObject2, (Context)getActivity(), paramb, 0, 124);
        ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).enterFinderProfileUI((Context)getActivity(), paramb);
        localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject3 = q.av.DzW;
        paramb = ((awa)localObject1).live_notice_info;
        if (paramb == null) {
          paramb = "";
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.av)localObject3, "", paramb);
          AppMethodBeat.o(356928);
          return;
          localObject1 = paramb.YSR;
          paramb = (c.b)localObject1;
          if (localObject1 == null) {
            paramb = "";
          }
        }
        label1109:
        Log.w(this.TAG, "handleLiveMenuItemSelected resp is null, ignore");
      }
    }
    AppMethodBeat.o(356928);
  }
  
  private static final void a(e parame, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(356976);
    kotlin.g.b.s.u(parame, "this$0");
    parame = parame.exN();
    if (parame != null) {
      parame.eum();
    }
    AppMethodBeat.o(356976);
  }
  
  private static final void a(e parame, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(356985);
    kotlin.g.b.s.u(parame, "this$0");
    Object localObject = parame.exN();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c)localObject).DId)
    {
      c localc = parame.exN();
      if (localc != null) {
        localc.dqc = paramMenuItem.getItemId();
      }
      if (localObject == null) {
        break;
      }
      parame.a(paramMenuItem.getItemId(), (c.b)localObject);
      AppMethodBeat.o(356985);
      return;
    }
    parame.a(true, new e..ExternalSyntheticLambda0(parame));
    AppMethodBeat.o(356985);
  }
  
  private static final void a(e parame, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(356969);
    kotlin.g.b.s.u(parame, "this$0");
    StringBuilder localStringBuilder = new StringBuilder("live bottom sheet:");
    if (params.jmw())
    {
      params.oh(parame.EaJ, p.h.Cgz);
      localStringBuilder.append(kotlin.g.b.s.X(parame.getString(p.h.Cgz), ","));
      com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
      if ((((Number)com.tencent.d.a.a.a.a.a.jUV().bmg()).intValue() == 1) && (((g)com.tencent.mm.kernel.h.ax(g.class)).bUo()))
      {
        params.oh(parame.EaL, p.h.Cgy);
        localStringBuilder.append(kotlin.g.b.s.X(parame.getString(p.h.Cgy), ","));
      }
      params.oh(parame.EaK, p.h.CgA);
      localStringBuilder.append(kotlin.g.b.s.X(parame.getString(p.h.CgA), ","));
    }
    Log.i(parame.TAG, String.valueOf(localStringBuilder));
    AppMethodBeat.o(356969);
  }
  
  private final void a(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(356938);
    d.uiThread((kotlin.g.a.a)new e.c(paramBoolean, this, paramOnCancelListener));
    AppMethodBeat.o(356938);
  }
  
  private static final void b(e parame)
  {
    AppMethodBeat.i(356990);
    kotlin.g.b.s.u(parame, "this$0");
    parame = parame.exN();
    if (parame != null) {
      parame.eum();
    }
    AppMethodBeat.o(356990);
  }
  
  private c exN()
  {
    AppMethodBeat.i(356903);
    c localc = (c)this.EaQ.getValue();
    AppMethodBeat.o(356903);
    return localc;
  }
  
  public final void bo(kotlin.g.a.a<ah> parama)
  {
    this.EaP = parama;
  }
  
  public final void e(r<? super Integer, ? super Integer, ? super String, ? super cl, ah> paramr)
  {
    this.EaO = paramr;
  }
  
  public final aw exM()
  {
    AppMethodBeat.i(357048);
    aw localaw = (aw)exN();
    AppMethodBeat.o(357048);
    return localaw;
  }
  
  public final void exO()
  {
    AppMethodBeat.i(357084);
    Log.i(this.TAG, "FinderLive.entrance,live btn click!");
    if (NetStatusUtil.isConnected((Context)getActivity()))
    {
      if (Util.isNullOrNil(z.bAW()))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_router_to_profile", false);
        ((Intent)localObject).putExtra("key_create_scene", 3);
        ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).x((Context)getContext(), getIntent());
      }
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(357084);
        return;
      }
      this.EaM = new com.tencent.mm.ui.widget.a.f((Context)getActivity(), 1, false);
      localObject = this.EaM;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new e..ExternalSyntheticLambda1(this);
      }
      localObject = this.EaM;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new e..ExternalSyntheticLambda2(this);
      }
      localObject = this.EaM;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.f)localObject).aeLi = new e..ExternalSyntheticLambda3(this);
      }
      localObject = this.EaM;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.f)localObject).dDn();
      }
      AppMethodBeat.o(357084);
      return;
    }
    Object localObject = new g.a((Context)getActivity());
    ((g.a)localObject).Xdm = true;
    ((g.a)localObject).bDE(getActivity().getResources().getString(p.h.Cld)).bDI(getActivity().getResources().getString(p.h.app_i_know)).b(e..ExternalSyntheticLambda4.INSTANCE).show();
    AppMethodBeat.o(357084);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(357074);
    switch (paramInt1)
    {
    }
    Object localObject3;
    label183:
    do
    {
      do
      {
        for (;;)
        {
          AppMethodBeat.o(357074);
          return;
          localObject3 = this.EaM;
          if (localObject3 != null) {
            ((com.tencent.mm.ui.widget.a.f)localObject3).cyW();
          }
          localObject3 = exN();
          if (localObject3 != null)
          {
            Log.i(((c)localObject3).TAG, "onActivityResult,requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
            switch (paramInt1)
            {
            }
          }
        }
        if (paramIntent == null) {}
        for (paramIntent = null;; paramIntent = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0)))
        {
          Log.i(((c)localObject3).TAG, kotlin.g.b.s.X("face verify result:", paramIntent));
          if (paramInt2 != -1) {
            break;
          }
          if (paramIntent != null) {
            break label183;
          }
          AppMethodBeat.o(357074);
          return;
        }
      } while (paramIntent.intValue() != 1);
      paramIntent = ((c)localObject3).DId;
      if (paramIntent == null) {}
      for (paramIntent = localObject1;; paramIntent = paramIntent.DIf)
      {
        c.b((c)localObject3, paramIntent);
        AppMethodBeat.o(357074);
        return;
      }
      if (paramIntent == null) {}
      for (paramIntent = null;; paramIntent = Integer.valueOf(paramIntent.getIntExtra("PRECHECK_RESULT", 0)))
      {
        Log.i(((c)localObject3).TAG, kotlin.g.b.s.X("precheck result:", paramIntent));
        if (paramInt2 != -1) {
          break;
        }
        if (paramIntent != null) {
          break label277;
        }
        AppMethodBeat.o(357074);
        return;
      }
    } while (paramIntent.intValue() != 1);
    label277:
    paramIntent = ((c)localObject3).DId;
    if (paramIntent == null) {}
    for (paramIntent = localObject2;; paramIntent = paramIntent.DIf)
    {
      c.b((c)localObject3, paramIntent);
      break;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(357055);
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(6653, (com.tencent.mm.am.h)this);
    a(false, null);
    exN().eul();
    AppMethodBeat.o(357055);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(357091);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    a(false, null);
    r localr = this.EaO;
    if (localr != null) {
      if (!(paramp instanceof bs)) {
        break label108;
      }
    }
    label108:
    for (paramp = (bs)paramp;; paramp = null)
    {
      localr.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp);
      AppMethodBeat.o(357091);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(357061);
    super.onStop();
    com.tencent.mm.kernel.h.aZW().b(6653, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(357061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.e
 * JD-Core Version:    0.7.0.1
 */