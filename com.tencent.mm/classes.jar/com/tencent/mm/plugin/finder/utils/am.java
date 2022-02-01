package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.protocal.protobuf.efp;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderSdkShareUtil;", "", "()V", "FROM_STR", "", "getFROM_STR", "()Ljava/lang/String;", "REQ_DESC", "getREQ_DESC", "REQ_EXTEND_URL", "getREQ_EXTEND_URL", "REQ_FROM", "getREQ_FROM", "REQ_FROMAPP", "getREQ_FROMAPP", "REQ_MIAOJIAN_EXTINFO", "getREQ_MIAOJIAN_EXTINFO", "REQ_PARAMSJSON", "getREQ_PARAMSJSON", "REQ_PATH", "getREQ_PATH", "REQ_URL", "getREQ_URL", "RET_ERRCODE", "getRET_ERRCODE", "RET_ERRMSG", "getRET_ERRMSG", "SAME_STYLE_FROM_STR", "getSAME_STYLE_FROM_STR", "TAG", "addSameStyleToBottomSheet", "", "context", "Landroid/app/Activity;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "itemId", "", "dealShare", "businessType", "appid", "extInfo", "fallback", "errcode", "errMsg", "genTestConfig", "genTestPostActionSheet", "", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "getShareAppSwitch", "", "packageName", "getTestJson", "getTestJson2", "onClickPostAction", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "Landroid/content/Context;", "actionSheet", "onClickPostSameStyle", "readPostAction", "startId", "actionMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "savePostAction", "actionList", "Lcom/tencent/mm/protocal/protobuf/PostActionSheetList;", "shouldShowSameStyle", "showToast", "wording", "startPostAction", "uri", "finderScene", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
{
  public static final am GhD;
  private static final String GhE;
  private static final String GhF;
  private static final String GhG;
  private static final String GhH;
  private static final String GhI;
  private static final String GhJ;
  private static final String GhK;
  private static final String GhL;
  private static final String GhM;
  private static final String GhN;
  private static final String GhO;
  private static final String GhP;
  public static final String TAG;
  
  static
  {
    AppMethodBeat.i(333730);
    GhD = new am();
    TAG = "Finder.FinderSdkShareUtil";
    com.tencent.mm.plugin.findersdk.a.p localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhE = com.tencent.mm.plugin.findersdk.a.p.frR();
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhF = com.tencent.mm.plugin.findersdk.a.p.frS();
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhG = com.tencent.mm.plugin.findersdk.a.p.ffm();
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhH = com.tencent.mm.plugin.findersdk.a.p.ffn();
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhI = com.tencent.mm.plugin.findersdk.a.p.ffo();
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhJ = com.tencent.mm.plugin.findersdk.a.p.ffp();
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhK = com.tencent.mm.plugin.findersdk.a.p.ffq();
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhL = com.tencent.mm.plugin.findersdk.a.p.ffr();
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhM = com.tencent.mm.plugin.findersdk.a.p.ffs();
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhN = com.tencent.mm.plugin.findersdk.a.p.fft();
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhO = com.tencent.mm.plugin.findersdk.a.p.ffu();
    localp = com.tencent.mm.plugin.findersdk.a.p.Hcl;
    GhP = com.tencent.mm.plugin.findersdk.a.p.ffv();
    AppMethodBeat.o(333730);
  }
  
  private static final void A(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(333694);
    Log.i(TAG, "dialog cancel");
    paramDialogInterface.dismiss();
    AppMethodBeat.o(333694);
  }
  
  private static final void B(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(333724);
    Log.i(TAG, "dialog cancel");
    paramDialogInterface.dismiss();
    AppMethodBeat.o(333724);
  }
  
  public static com.tencent.mm.ui.widget.a.e a(Context paramContext, efo paramefo)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(333645);
    kotlin.g.b.s.u(paramContext, "context");
    if ((paramefo == null) || (Util.isNullOrNil(paramefo.abkY)))
    {
      paramefo = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramefo = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext == null) {}
      for (paramContext = null;; paramContext = paramContext.fou())
      {
        com.tencent.mm.plugin.finder.report.z.b(1, "post_actionsheet_miaojian", "", paramContext);
        AppMethodBeat.o(333645);
        return null;
      }
    }
    boolean bool;
    Object localObject2;
    if (Util.isNullOrNil(paramefo.abkY))
    {
      bool = false;
      if (!bool) {
        break label330;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject2 = paramefo.abkW;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = as.GSQ;
      localObject2 = as.a.hu(paramContext);
      if (localObject2 != null) {
        break label312;
      }
      localObject2 = null;
      label133:
      com.tencent.mm.plugin.finder.report.z.b(1, "post_actionsheet_miaojian", (String)localObject1, (bui)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject1 = as.GSQ;
      localObject1 = as.a.hu(paramContext);
      if (localObject1 != null) {
        break label322;
      }
      localObject1 = localObject3;
      label163:
      com.tencent.mm.plugin.finder.report.z.b(0, "miaojian_post_tips", "{\"if_has_set\": 1}", (bui)localObject1);
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.x(paramContext, paramefo.value);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (!bool) {
        break label410;
      }
    }
    label402:
    label410:
    for (Object localObject1 = paramContext.getString(e.h.finder_secondcut_jump_tip, new Object[] { localObject1 });; localObject1 = paramContext.getString(e.h.finder_secondcut_install_tip, new Object[] { localObject1 }))
    {
      paramContext = k.b(paramContext, (String)localObject1, "", paramContext.getString(e.h.app_ok), paramContext.getString(e.h.app_cancel), new am..ExternalSyntheticLambda1(bool, paramContext, paramefo), am..ExternalSyntheticLambda3.INSTANCE);
      AppMethodBeat.o(333645);
      return paramContext;
      localObject1 = e.GfX;
      localObject2 = paramefo.abkY;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str = paramefo.abkZ;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      bool = e.D(paramContext, (String)localObject1, (String)localObject2);
      break;
      label312:
      localObject2 = ((as)localObject2).fou();
      break label133;
      label322:
      localObject1 = ((as)localObject1).fou();
      break label163;
      label330:
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject1 = as.GSQ;
      localObject1 = as.a.hu(paramContext);
      if (localObject1 == null)
      {
        localObject1 = null;
        label349:
        com.tencent.mm.plugin.finder.report.z.b(1, "post_actionsheet_miaojian", "", (bui)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
        localObject1 = as.GSQ;
        localObject1 = as.a.hu(paramContext);
        if (localObject1 != null) {
          break label402;
        }
      }
      for (localObject1 = localObject4;; localObject1 = ((as)localObject1).fou())
      {
        com.tencent.mm.plugin.finder.report.z.b(0, "miaojian_post_tips", "{\"if_has_set\": 0}", (bui)localObject1);
        break;
        localObject1 = ((as)localObject1).fou();
        break label349;
      }
    }
  }
  
  public static com.tencent.mm.ui.widget.a.e a(BaseFinderFeed paramBaseFinderFeed, Activity paramActivity, efo paramefo)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(333680);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramActivity, "context");
    Log.i(TAG, "onClickPostSameStyle");
    if (Util.isNullOrNil(com.tencent.mm.model.z.bAW()))
    {
      paramBaseFinderFeed = new Intent();
      paramBaseFinderFeed.putExtra("key_create_scene", 5);
      paramBaseFinderFeed.putExtra("key_router_to_profile", false);
      a.GfO.x((Context)paramActivity, paramBaseFinderFeed);
      com.tencent.mm.plugin.report.service.h.OAn.b(20694, new Object[] { Integer.valueOf(1) });
      paramBaseFinderFeed = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramBaseFinderFeed = as.GSQ;
      paramBaseFinderFeed = as.a.hu((Context)paramActivity);
      if (paramBaseFinderFeed == null) {}
      for (paramBaseFinderFeed = null;; paramBaseFinderFeed = paramBaseFinderFeed.fou())
      {
        com.tencent.mm.plugin.finder.report.z.b(1, "miaojian_createsame", "", paramBaseFinderFeed);
        AppMethodBeat.o(333680);
        return null;
      }
    }
    if ((paramefo == null) || (Util.isNullOrNil(paramefo.abkY)))
    {
      AppMethodBeat.o(333680);
      return null;
    }
    boolean bool;
    Object localObject1;
    Object localObject2;
    if (Util.isNullOrNil(paramefo.abkY))
    {
      bool = false;
      if (!bool) {
        break label503;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject2 = paramBaseFinderFeed.feedObject.getFromAppExtInfo();
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)paramActivity);
      if (localObject1 != null) {
        break label483;
      }
      localObject1 = null;
      label223:
      com.tencent.mm.plugin.finder.report.z.b(1, "miaojian_createsame", (String)localObject2, (bui)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)paramActivity);
      if (localObject1 != null) {
        break label493;
      }
      localObject1 = localObject3;
      label262:
      com.tencent.mm.plugin.finder.report.z.b(0, "miaojian_createsame_tips", "{\"if_has_set\": 1}", (bui)localObject1);
      localObject1 = com.tencent.mm.pluginsdk.model.app.h.x((Context)paramActivity, paramefo.value);
      if (localObject1 != null) {
        break label605;
      }
      localObject1 = "";
      label297:
      localObject3 = paramefo.abkW;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localObject2 = kotlin.g.b.s.X((String)localObject2, paramBaseFinderFeed.feedObject.getFromAppExtInfo());
      Log.i(TAG, kotlin.g.b.s.X("universalLink ", localObject2));
      localObject3 = (Context)paramActivity;
      if (!bool) {
        break label608;
      }
    }
    label530:
    label595:
    label605:
    label608:
    for (paramBaseFinderFeed = paramActivity.getString(e.h.finder_secondcut_jump_tip, new Object[] { localObject1 });; paramBaseFinderFeed = paramActivity.getString(e.h.finder_secondcut_install_tip, new Object[] { localObject1 }))
    {
      paramBaseFinderFeed = k.b((Context)localObject3, paramBaseFinderFeed, "", paramActivity.getString(e.h.app_ok), paramActivity.getString(e.h.app_cancel), new am..ExternalSyntheticLambda0(bool, paramActivity, (String)localObject2, paramefo), am..ExternalSyntheticLambda2.INSTANCE);
      AppMethodBeat.o(333680);
      return paramBaseFinderFeed;
      localObject1 = e.GfX;
      Context localContext = (Context)paramActivity;
      localObject2 = paramefo.abkY;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str = paramefo.abkZ;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      bool = e.D(localContext, (String)localObject1, (String)localObject2);
      break;
      label483:
      localObject1 = ((as)localObject1).fou();
      break label223;
      label493:
      localObject1 = ((as)localObject1).fou();
      break label262;
      label503:
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)paramActivity);
      if (localObject1 == null)
      {
        localObject1 = null;
        com.tencent.mm.plugin.finder.report.z.b(1, "miaojian_createsame", "", (bui)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
        localObject1 = as.GSQ;
        localObject1 = as.a.hu((Context)paramActivity);
        if (localObject1 != null) {
          break label595;
        }
      }
      for (localObject1 = localObject4;; localObject1 = ((as)localObject1).fou())
      {
        com.tencent.mm.plugin.finder.report.z.b(0, "miaojian_createsame_tips", "{\"if_has_set\": 0}", (bui)localObject1);
        break;
        localObject1 = ((as)localObject1).fou();
        break label530;
      }
      break label297;
    }
  }
  
  public static void a(Activity paramActivity, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params, com.tencent.mm.ui.widget.a.f paramf, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(333664);
    kotlin.g.b.s.u(paramActivity, "context");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(params, "menu");
    kotlin.g.b.s.u(paramf, "sheet");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    Object localObject1 = av.GiL;
    int i = av.fgg();
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    Object localObject3;
    Object localObject4;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.eSe().bmg()).intValue() == 0) || ((i != 2) && (i != 3)) || (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()))
    {
      localObject1 = TAG;
      localObject3 = new StringBuilder("SAME_STYLE_SWITCH ");
      localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
      Log.i((String)localObject1, ((Number)com.tencent.mm.plugin.finder.storage.d.eSe().bmg()).intValue() + ", " + i);
      i = 0;
      if (i != 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.aAR(paramBaseFinderFeed.feedObject.getFromAppId());
        if (((CharSequence)localObject1).length() != 0) {
          break label626;
        }
        i = 1;
        label201:
        if (i == 0) {
          break label646;
        }
        localObject1 = paramActivity.getString(e.h.finder_miaojian_samekind_tip);
        kotlin.g.b.s.s(localObject1, "context.getString(R.stri…er_miaojian_samekind_tip)");
      }
    }
    label272:
    label422:
    label477:
    label626:
    for (;;)
    {
      params = params.a(paramInt, (CharSequence)localObject1, e.g.finder_icon_miaojian, false);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.aAQ(paramBaseFinderFeed.feedObject.getFromAppId());
      if (((CharSequence)localObject1).length() == 0)
      {
        paramInt = 1;
        if (paramInt == 0)
        {
          paramBaseFinderFeed = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramBaseFinderFeed = com.tencent.mm.plugin.finder.loader.p.eCl();
          localObject1 = new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKY);
          localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramBaseFinderFeed.a(localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ)).a(new am..ExternalSyntheticLambda4(params, paramActivity, paramf)).blg();
        }
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramBaseFinderFeed = as.GSQ;
        paramActivity = as.a.hu((Context)paramActivity);
        if (paramActivity != null) {
          break label638;
        }
      }
      label503:
      label509:
      label638:
      for (paramActivity = localObject2;; paramActivity = paramActivity.fou())
      {
        com.tencent.mm.plugin.finder.report.z.b(0, "miaojian_createsame", "", paramActivity);
        AppMethodBeat.o(333664);
        return;
        if (((CharSequence)paramBaseFinderFeed.feedObject.getFromAppId()).length() > 0)
        {
          i = 1;
          if (i == 0) {
            break label521;
          }
          if (((CharSequence)paramBaseFinderFeed.feedObject.getFromAppExtInfo()).length() <= 0) {
            break label503;
          }
          i = 1;
          if (i == 0) {
            break label521;
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.aAP(paramBaseFinderFeed.feedObject.getFromAppId());
          if (localObject1 == null) {
            break label515;
          }
          localObject1 = ((efo)localObject1).abkW;
          if (localObject1 == null) {
            break label515;
          }
          if (((CharSequence)localObject1).length() <= 0) {
            break label509;
          }
          i = 1;
          if (i != 1) {
            break label515;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label521;
          }
          i = 1;
          break;
          i = 0;
          break label396;
          i = 0;
          break label422;
          i = 0;
          break label477;
        }
        localObject3 = TAG;
        localObject4 = new StringBuilder("appid:").append(paramBaseFinderFeed.feedObject.getFromAppId()).append(", extInfo:").append(paramBaseFinderFeed.feedObject.getFromAppExtInfo()).append(", sync link:");
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.aAP(paramBaseFinderFeed.feedObject.getFromAppId());
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((efo)localObject1).abkW)
        {
          Log.i((String)localObject3, localObject1);
          i = 0;
          break;
        }
        i = 0;
        break label201;
        paramInt = 0;
        break label272;
      }
    }
  }
  
  private static final void a(MenuItem paramMenuItem, Activity paramActivity, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(333705);
    kotlin.g.b.s.u(paramActivity, "$context");
    kotlin.g.b.s.u(paramf, "$sheet");
    if (paramBitmap != null) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new am.a(paramMenuItem, paramActivity, paramBitmap, paramf));
    }
    AppMethodBeat.o(333705);
  }
  
  public static void a(efp paramefp)
  {
    AppMethodBeat.i(333622);
    efp localefp;
    Object localObject1;
    if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_PURPLE))
    {
      localefp = paramefp;
      if (!BuildInfo.IS_FLAVOR_RED) {}
    }
    else
    {
      localefp = paramefp;
      if (paramefp == null) {
        localefp = new efp();
      }
      paramefp = localefp.ablb;
      localObject1 = new ArrayList();
      Object localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSr().bmg()).intValue() == 1)
      {
        localObject2 = new efo();
        ((efo)localObject2).title = "用秒剪制作视频（仅测试）";
        ((efo)localObject2).icon = "";
        ((efo)localObject2).desc = "";
        ((efo)localObject2).type = 1;
        ((efo)localObject2).value = "wxa5e0de08d96cc09d";
        ((efo)localObject2).abkW = "miaojian://createvideo?scene=channels&page=1&from=channels";
        ((efo)localObject2).abkX = "https://miaojian.weixin.qq.com/download/apps/?channel=debug";
        ((efo)localObject2).abkY = "com.tencent.phoenix";
        ((efo)localObject2).abkZ = "A24DC0755072F64C480DC06DCD3412BF";
        ah localah = ah.aiuX;
        ((ArrayList)localObject1).add(localObject2);
      }
      paramefp.addAll((Collection)localObject1);
    }
    if (localefp != null)
    {
      paramefp = localefp.ablb;
      kotlin.g.b.s.s(paramefp, "actionSheetList.sheets");
      com.tencent.mm.ae.d.a(paramefp, (kotlin.g.a.b)am.b.GhQ);
      paramefp = localefp.ablb;
      kotlin.g.b.s.s(paramefp, "actionSheetList.sheets");
      paramefp = ((Iterable)paramefp).iterator();
      while (paramefp.hasNext())
      {
        localObject1 = (efo)paramefp.next();
        com.tencent.mm.pluginsdk.model.app.h.a(((efo)localObject1).value, ((efo)localObject1).abkY, null);
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adaw, Util.encodeHexString(localefp.toByteArray()));
      AppMethodBeat.o(333622);
      return;
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adaw, "");
    AppMethodBeat.o(333622);
  }
  
  public static void a(HashMap<Integer, efo> paramHashMap, com.tencent.mm.ui.base.s params, Activity paramActivity)
  {
    Object localObject3 = null;
    AppMethodBeat.i(333635);
    kotlin.g.b.s.u(paramHashMap, "actionMap");
    kotlin.g.b.s.u(paramActivity, "context");
    Object localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaw, "");
    if (localObject1 == null)
    {
      paramHashMap = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(333635);
      throw paramHashMap;
    }
    localObject1 = (String)localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(333635);
      return;
    }
    Object localObject4 = Util.decodeHexString((String)localObject1);
    if (Util.isNullOrNil((byte[])localObject4))
    {
      AppMethodBeat.o(333635);
      return;
    }
    localObject1 = (com.tencent.mm.bx.a)new efp();
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
      localObject1 = (efp)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((efp)localObject1).ablb;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          int i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = ((Iterator)localObject1).next();
            if (i < 0) {
              kotlin.a.p.kkW();
            }
            localObject4 = (efo)localObject4;
            paramHashMap.put(Integer.valueOf(i + 1010), localObject4);
            if (params != null) {
              params.c(i + 1010, (CharSequence)((efo)localObject4).title);
            }
            i += 1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
      paramHashMap = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramHashMap = as.GSQ;
      paramHashMap = as.a.hu((Context)paramActivity);
      if (paramHashMap != null) {}
    }
    for (paramHashMap = localObject3;; paramHashMap = paramHashMap.fou())
    {
      com.tencent.mm.plugin.finder.report.z.b(0, "post_actionsheet_miaojian", "", paramHashMap);
      AppMethodBeat.o(333635);
      return;
    }
  }
  
  private static final void a(boolean paramBoolean, Activity paramActivity, String paramString, efo paramefo, DialogInterface paramDialogInterface, int paramInt)
  {
    Context localContext = null;
    AppMethodBeat.i(333717);
    kotlin.g.b.s.u(paramActivity, "$context");
    kotlin.g.b.s.u(paramString, "$universalLink");
    paramDialogInterface.dismiss();
    Log.i(TAG, kotlin.g.b.s.X("dialog ok isInstall:", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      localContext = (Context)paramActivity;
      paramDialogInterface = paramefo.abkY;
      paramefo = paramDialogInterface;
      if (paramDialogInterface == null) {
        paramefo = "";
      }
      d(localContext, paramString, paramefo, 3);
      paramString = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramString = as.GSQ;
      paramActivity = as.a.hu((Context)paramActivity);
      if (paramActivity == null) {}
      for (paramActivity = null;; paramActivity = paramActivity.fou())
      {
        com.tencent.mm.plugin.finder.report.z.b(1, "miaojian_createsame_tips", "{\"if_has_set\": 1}", paramActivity);
        AppMethodBeat.o(333717);
        return;
      }
    }
    paramString = e.GfX;
    paramDialogInterface = (Context)paramActivity;
    paramefo = paramefo.abkX;
    paramString = paramefo;
    if (paramefo == null) {
      paramString = "";
    }
    e.aL(paramDialogInterface, paramString);
    paramString = com.tencent.mm.plugin.finder.report.z.FrZ;
    paramString = as.GSQ;
    paramActivity = as.a.hu((Context)paramActivity);
    if (paramActivity == null) {}
    for (paramActivity = localContext;; paramActivity = paramActivity.fou())
    {
      com.tencent.mm.plugin.finder.report.z.b(1, "miaojian_createsame_tips", "{\"if_has_set\": 0}", paramActivity);
      AppMethodBeat.o(333717);
      return;
    }
  }
  
  private static final void a(boolean paramBoolean, Context paramContext, efo paramefo, DialogInterface paramDialogInterface, int paramInt)
  {
    String str = null;
    AppMethodBeat.i(333688);
    kotlin.g.b.s.u(paramContext, "$context");
    paramDialogInterface.dismiss();
    Log.i(TAG, kotlin.g.b.s.X("dialog ok isInstall:", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      str = paramefo.abkW;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      str = paramefo.abkY;
      paramefo = str;
      if (str == null) {
        paramefo = "";
      }
      d(paramContext, paramDialogInterface, paramefo, 1);
      paramefo = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramefo = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext == null) {}
      for (paramContext = null;; paramContext = paramContext.fou())
      {
        com.tencent.mm.plugin.finder.report.z.b(1, "miaojian_post_tips", "{\"if_has_set\": 1}", paramContext);
        AppMethodBeat.o(333688);
        return;
      }
    }
    paramDialogInterface = e.GfX;
    paramDialogInterface = paramefo.abkX;
    paramefo = paramDialogInterface;
    if (paramDialogInterface == null) {
      paramefo = "";
    }
    e.aL(paramContext, paramefo);
    paramefo = com.tencent.mm.plugin.finder.report.z.FrZ;
    paramefo = as.GSQ;
    paramContext = as.a.hu(paramContext);
    if (paramContext == null) {}
    for (paramContext = str;; paramContext = paramContext.fou())
    {
      com.tencent.mm.plugin.finder.report.z.b(1, "miaojian_post_tips", "{\"if_has_set\": 0}", paramContext);
      AppMethodBeat.o(333688);
      return;
    }
  }
  
  public static boolean aBE(String paramString)
  {
    AppMethodBeat.i(333610);
    kotlin.g.b.s.u(paramString, "packageName");
    try
    {
      String str = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zdg, "{\"com.tencent.phoenix\":{\"minApi\":26}}");
      if ((!Util.isNullOrNil(str)) && (str != null))
      {
        paramString = new JSONObject(str).optJSONObject(paramString);
        if (paramString != null)
        {
          int i = paramString.optInt("minApi", 0);
          if ((i > 0) && (Build.VERSION.SDK_INT < i))
          {
            AppMethodBeat.o(333610);
            return false;
          }
        }
      }
    }
    finally
    {
      Log.printErrStackTrace("FinderConfig", paramString, "SHARE_SDK_SWITCH", new Object[0]);
      AppMethodBeat.o(333610);
    }
    return true;
  }
  
  private static void d(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(333654);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "uri");
    kotlin.g.b.s.u(paramString2, "packageName");
    Log.i(TAG, "startPostAction " + paramString2 + ", " + paramString1);
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString1 + "&finderScene=" + paramInt));
    localIntent.setPackage(paramString2);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    try
    {
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/finder/utils/FinderSdkShareUtil", "startPostAction", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/FinderSdkShareUtil", "startPostAction", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(333654);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e(TAG, kotlin.g.b.s.X("startPostAction: error ", paramContext.getMessage()));
      AppMethodBeat.o(333654);
    }
  }
  
  public static void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(333601);
    kotlin.g.b.s.u(paramString1, "errMsg");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put(GhE, paramInt);
    ((JSONObject)localObject).put(GhF, paramString1);
    paramString1 = ((JSONObject)localObject).toString();
    kotlin.g.b.s.s(paramString1, "retJson.toString()");
    showToast(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localObject = ((JSONObject)localObject).toString();
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    n.d(paramString1, (String)localObject, paramString2, -1, "");
    AppMethodBeat.o(333601);
  }
  
  public static String ffm()
  {
    return GhG;
  }
  
  public static String ffn()
  {
    return GhH;
  }
  
  public static String ffo()
  {
    return GhI;
  }
  
  public static String ffp()
  {
    return GhJ;
  }
  
  public static String ffq()
  {
    return GhK;
  }
  
  public static String ffr()
  {
    return GhL;
  }
  
  public static String ffs()
  {
    return GhM;
  }
  
  public static String fft()
  {
    return GhN;
  }
  
  public static String ffu()
  {
    return GhO;
  }
  
  public static String ffv()
  {
    return GhP;
  }
  
  public static String ffw()
  {
    AppMethodBeat.i(333582);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put(GhG, "content://media/external/video/media/3426");
    ((JSONObject)localObject).put(GhH, "https://1500000419.vod2.myqcloud.com/6c9781f6vodcq1500000419/fcc5b21b5285890810062810511/NZQdSMAkg1AA.mp4");
    ((JSONObject)localObject).put(GhI, 2);
    ((JSONObject)localObject).put(GhJ, "{\"file_id\":\"5285890810062810511\",\"media_source\":2,\"media_type\":\"video\",\"act_style\":11010,\"service_type\":2,\"media_scene\":1,\"service\":\"build\"}");
    localObject = ((JSONObject)localObject).toString();
    kotlin.g.b.s.s(localObject, "extInfo.toString()");
    AppMethodBeat.o(333582);
    return localObject;
  }
  
  public static String ffx()
  {
    AppMethodBeat.i(333586);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put(GhG, "content://media/external/video/media/3426");
    ((JSONObject)localObject).put(GhH, "");
    ((JSONObject)localObject).put(GhI, 1);
    ((JSONObject)localObject).put(GhJ, "");
    ((JSONObject)localObject).put(GhL, "DQp7InRlbXBsYXRlSWQiOiJ5dWFuc2hlbmdfaF8yXzlfMTYiLCJtdXNpY0tleSI6IjE6MTM2NDg4Nzk2ODIwOTEyOTQ3MjoxIn0=");
    localObject = ((JSONObject)localObject).toString();
    kotlin.g.b.s.s(localObject, "extInfo.toString()");
    AppMethodBeat.o(333586);
    return localObject;
  }
  
  public static void showToast(String paramString)
  {
    AppMethodBeat.i(333593);
    kotlin.g.b.s.u(paramString, "wording");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new am.c(paramString));
    }
    AppMethodBeat.o(333593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.am
 * JD-Core Version:    0.7.0.1
 */