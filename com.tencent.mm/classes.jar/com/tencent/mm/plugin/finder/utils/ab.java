package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderSdkShareUtil;", "", "()V", "FROM_STR", "", "getFROM_STR", "()Ljava/lang/String;", "REQ_DESC", "getREQ_DESC", "REQ_EXTEND_URL", "getREQ_EXTEND_URL", "REQ_FROM", "getREQ_FROM", "REQ_FROMAPP", "getREQ_FROMAPP", "REQ_MIAOJIAN_EXTINFO", "getREQ_MIAOJIAN_EXTINFO", "REQ_PARAMSJSON", "getREQ_PARAMSJSON", "REQ_PATH", "getREQ_PATH", "REQ_URL", "getREQ_URL", "RET_ERRCODE", "getRET_ERRCODE", "RET_ERRMSG", "getRET_ERRMSG", "SAME_STYLE_FROM_STR", "getSAME_STYLE_FROM_STR", "TAG", "addSameStyleToBottomSheet", "", "context", "Landroid/app/Activity;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "itemId", "", "dealShare", "businessType", "appid", "extInfo", "fallback", "errcode", "errMsg", "genTestConfig", "genTestPostActionSheet", "", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "getShareAppSwitch", "", "packageName", "getTestJson", "getTestJson2", "onClickPostAction", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "Landroid/content/Context;", "actionSheet", "onClickPostSameStyle", "readPostAction", "startId", "actionMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "savePostAction", "actionList", "Lcom/tencent/mm/protocal/protobuf/PostActionSheetList;", "shouldShowSameStyle", "showToast", "wording", "startPostAction", "uri", "plugin-finder_release"})
public final class ab
{
  public static final ab AEA;
  private static final String AEo = "errCode";
  private static final String AEp = "errmsg";
  private static final String AEq = "localIdentifier";
  private static final String AEr = "remoteUrl";
  private static final String AEs = "fromAppType";
  private static final String AEt = "paramsJson";
  private static final String AEu = "from";
  private static final String AEv = "miaojianExtInfo";
  private static final String AEw = "desc";
  private static final String AEx = "extendUrl";
  private static final String AEy = "channels";
  private static final String AEz = "channels-samestyle";
  public static final String TAG = "Finder.FinderSdkShareUtil";
  
  static
  {
    AppMethodBeat.i(289876);
    AEA = new ab();
    TAG = "Finder.FinderSdkShareUtil";
    AEo = "errCode";
    AEp = "errmsg";
    AEq = "localIdentifier";
    AEr = "remoteUrl";
    AEs = "fromAppType";
    AEt = "paramsJson";
    AEu = "from";
    AEv = "miaojianExtInfo";
    AEw = "desc";
    AEx = "extendUrl";
    AEy = "channels";
    AEz = "channels-samestyle";
    AppMethodBeat.o(289876);
  }
  
  public static void E(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(289873);
    p.k(paramContext, "context");
    p.k(paramString1, "uri");
    p.k(paramString2, "packageName");
    Log.i(TAG, "startPostAction " + paramString2 + ", " + paramString1);
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString1));
    localIntent.setPackage(paramString2);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    try
    {
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/plugin/finder/utils/FinderSdkShareUtil", "startPostAction", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/FinderSdkShareUtil", "startPostAction", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(289873);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e(TAG, "startPostAction: error " + paramContext.getMessage());
      AppMethodBeat.o(289873);
    }
  }
  
  public static com.tencent.mm.ui.widget.a.d a(final Context paramContext, final dna paramdna)
  {
    com.tencent.mm.plugin.finder.viewmodel.component.aj localaj = null;
    Object localObject3 = null;
    AppMethodBeat.i(289872);
    p.k(paramContext, "context");
    if ((paramdna == null) || (Util.isNullOrNil(paramdna.TUo)))
    {
      paramdna = n.zWF;
      paramdna = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramContext = aj.a.fZ(paramContext);
      if (paramContext != null) {}
      for (paramContext = paramContext.ekY();; paramContext = null)
      {
        n.b(1, "post_actionsheet_miaojian", "", paramContext);
        AppMethodBeat.o(289872);
        return null;
      }
    }
    boolean bool;
    Object localObject2;
    if (Util.isNullOrNil(paramdna.TUo))
    {
      bool = false;
      if (!bool) {
        break label298;
      }
      localObject1 = n.zWF;
      localObject2 = paramdna.TUm;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localaj = aj.a.fZ(paramContext);
      localObject2 = localObject3;
      if (localaj != null) {
        localObject2 = localaj.ekY();
      }
      n.b(1, "post_actionsheet_miaojian", (String)localObject1, (bid)localObject2);
      label153:
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.t(paramContext, paramdna.value);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (!bool) {
        break label340;
      }
    }
    label298:
    label340:
    for (Object localObject1 = paramContext.getString(b.j.finder_secondcut_jump_tip, new Object[] { localObject1 });; localObject1 = paramContext.getString(b.j.finder_secondcut_install_tip, new Object[] { localObject1 }))
    {
      paramContext = com.tencent.mm.ui.base.h.c(paramContext, (String)localObject1, "", paramContext.getString(b.j.app_ok), paramContext.getString(b.j.app_cancel), (DialogInterface.OnClickListener)new b(bool, paramContext, paramdna), (DialogInterface.OnClickListener)c.AEF);
      AppMethodBeat.o(289872);
      return paramContext;
      localObject1 = com.tencent.mm.plugin.recordvideo.e.a.IeL;
      localObject2 = paramdna.TUo;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str = paramdna.TUp;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      bool = com.tencent.mm.plugin.recordvideo.e.a.M(paramContext, (String)localObject1, (String)localObject2);
      break;
      localObject1 = n.zWF;
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject2 = aj.a.fZ(paramContext);
      localObject1 = localaj;
      if (localObject2 != null) {
        localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).ekY();
      }
      n.b(1, "post_actionsheet_miaojian", "", (bid)localObject1);
      break label153;
    }
  }
  
  public static com.tencent.mm.ui.widget.a.d a(BaseFinderFeed paramBaseFinderFeed, final Activity paramActivity, final dna paramdna)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(289875);
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramActivity, "context");
    Log.i(TAG, "onClickPostSameStyle");
    if (Util.isNullOrNil(z.bdh()))
    {
      paramBaseFinderFeed = new Intent();
      paramBaseFinderFeed.putExtra("key_create_scene", 5);
      paramBaseFinderFeed.putExtra("key_router_to_profile", false);
      paramdna = a.ACH;
      a.w((Context)paramActivity, paramBaseFinderFeed);
      com.tencent.mm.plugin.report.service.h.IzE.a(20694, new Object[] { Integer.valueOf(1) });
      paramBaseFinderFeed = n.zWF;
      paramBaseFinderFeed = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramBaseFinderFeed = aj.a.fZ((Context)paramActivity);
      if (paramBaseFinderFeed != null) {}
      for (paramBaseFinderFeed = paramBaseFinderFeed.ekY();; paramBaseFinderFeed = null)
      {
        n.b(1, "miaojian_createsame", "", paramBaseFinderFeed);
        AppMethodBeat.o(289875);
        return null;
      }
    }
    if ((paramdna == null) || (Util.isNullOrNil(paramdna.TUo)))
    {
      AppMethodBeat.o(289875);
      return null;
    }
    boolean bool;
    Object localObject1;
    Object localObject2;
    if (Util.isNullOrNil(paramdna.TUo))
    {
      bool = false;
      if (!bool) {
        break label478;
      }
      localObject1 = n.zWF;
      localObject2 = paramBaseFinderFeed.feedObject.getFromAppExtInfo();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject4 = aj.a.fZ((Context)paramActivity);
      localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject4).ekY();
      }
      n.b(1, "miaojian_createsame", (String)localObject2, (bid)localObject1);
      label243:
      localObject1 = com.tencent.mm.pluginsdk.model.app.h.t((Context)paramActivity, paramdna.value);
      if (localObject1 != null) {
        break label548;
      }
      localObject1 = "";
    }
    label548:
    for (;;)
    {
      localObject4 = new StringBuilder();
      localObject3 = paramdna.TUm;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localObject2 = (String)localObject2 + paramBaseFinderFeed.feedObject.getFromAppExtInfo();
      Log.i(TAG, "universalLink ".concat(String.valueOf(localObject2)));
      localObject3 = (Context)paramActivity;
      if (bool) {}
      for (paramBaseFinderFeed = paramActivity.getString(b.j.finder_secondcut_jump_tip, new Object[] { localObject1 });; paramBaseFinderFeed = paramActivity.getString(b.j.finder_secondcut_install_tip, new Object[] { localObject1 }))
      {
        paramBaseFinderFeed = com.tencent.mm.ui.base.h.c((Context)localObject3, paramBaseFinderFeed, "", paramActivity.getString(b.j.app_ok), paramActivity.getString(b.j.app_cancel), (DialogInterface.OnClickListener)new d(bool, paramActivity, (String)localObject2, paramdna), (DialogInterface.OnClickListener)e.AEH);
        AppMethodBeat.o(289875);
        return paramBaseFinderFeed;
        localObject1 = com.tencent.mm.plugin.recordvideo.e.a.IeL;
        Context localContext = (Context)paramActivity;
        localObject2 = paramdna.TUo;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        String str = paramdna.TUp;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        bool = com.tencent.mm.plugin.recordvideo.e.a.M(localContext, (String)localObject1, (String)localObject2);
        break;
        label478:
        localObject1 = n.zWF;
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject2 = aj.a.fZ((Context)paramActivity);
        localObject1 = localObject4;
        if (localObject2 != null) {
          localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).ekY();
        }
        n.b(1, "miaojian_createsame", "", (bid)localObject1);
        break label243;
      }
    }
  }
  
  public static void a(final Activity paramActivity, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.o paramo, final com.tencent.mm.ui.widget.a.e parame, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(289874);
    p.k(paramActivity, "context");
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramo, "menu");
    p.k(parame, "sheet");
    p.k(paramBaseFinderFeed, "feed");
    Object localObject1 = aj.AGc;
    int i = aj.eei();
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    Object localObject3;
    Object localObject4;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.dTN().aSr()).intValue() != 0) && ((i == 2) || (i == 3)))
    {
      localObject1 = com.tencent.mm.kernel.h.ae(ae.class);
      p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ae)localObject1).dYT()) {}
    }
    else
    {
      localObject1 = TAG;
      localObject3 = new StringBuilder("SAME_STYLE_SWITCH ");
      localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
      Log.i((String)localObject1, ((Number)com.tencent.mm.plugin.finder.storage.d.dTN().aSr()).intValue() + ", " + i);
      i = 0;
      if (i != 0)
      {
        localObject1 = g.AnT;
        localObject1 = g.aEY(paramBaseFinderFeed.feedObject.getFromAppId());
        if (((CharSequence)localObject1).length() != 0) {
          break label631;
        }
        i = 1;
        label212:
        if (i == 0) {
          break label643;
        }
        localObject1 = paramActivity.getString(b.j.finder_miaojian_samekind_tip);
        p.j(localObject1, "context.getString(R.stri…er_miaojian_samekind_tip)");
      }
    }
    label514:
    label643:
    for (;;)
    {
      paramo = paramo.a(paramInt, (CharSequence)localObject1, b.i.finder_icon_miaojian, false);
      localObject1 = g.AnT;
      localObject1 = g.aEX(paramBaseFinderFeed.feedObject.getFromAppId());
      if (((CharSequence)localObject1).length() == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0)
        {
          paramBaseFinderFeed = com.tencent.mm.plugin.finder.loader.t.ztT;
          paramBaseFinderFeed = com.tencent.mm.plugin.finder.loader.t.dJe();
          localObject1 = new com.tencent.mm.plugin.finder.loader.x((String)localObject1, u.Aly);
          localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
          paramBaseFinderFeed.a(localObject1, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU)).a((com.tencent.mm.loader.f.e)new a(paramo, paramActivity, parame)).aRr();
        }
        paramBaseFinderFeed = n.zWF;
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramBaseFinderFeed = aj.a.fZ((Context)paramActivity);
        paramActivity = localObject2;
        if (paramBaseFinderFeed != null) {
          paramActivity = paramBaseFinderFeed.ekY();
        }
        n.b(0, "miaojian_createsame", "", paramActivity);
        AppMethodBeat.o(289874);
        return;
        if (((CharSequence)paramBaseFinderFeed.feedObject.getFromAppId()).length() > 0)
        {
          i = 1;
          label415:
          if (i == 0) {
            break label526;
          }
          if (((CharSequence)paramBaseFinderFeed.feedObject.getFromAppExtInfo()).length() <= 0) {
            break label514;
          }
          i = 1;
          label441:
          if (i == 0) {
            break label526;
          }
          localObject1 = g.AnT;
          localObject1 = g.aEW(paramBaseFinderFeed.feedObject.getFromAppId());
          if (localObject1 == null) {
            break label526;
          }
          localObject1 = ((dna)localObject1).TUm;
          if (localObject1 == null) {
            break label526;
          }
          if (((CharSequence)localObject1).length() <= 0) {
            break label520;
          }
        }
        label520:
        for (i = 1;; i = 0)
        {
          if (i != 1) {
            break label526;
          }
          i = 1;
          break;
          i = 0;
          break label415;
          i = 0;
          break label441;
        }
        label526:
        localObject3 = TAG;
        localObject4 = new StringBuilder("appid:").append(paramBaseFinderFeed.feedObject.getFromAppId()).append(", extInfo:").append(paramBaseFinderFeed.feedObject.getFromAppExtInfo()).append(", sync link:");
        localObject1 = g.AnT;
        localObject1 = g.aEW(paramBaseFinderFeed.feedObject.getFromAppId());
        if (localObject1 != null) {}
        for (localObject1 = ((dna)localObject1).TUm;; localObject1 = null)
        {
          Log.i((String)localObject3, (String)localObject1);
          i = 0;
          break;
        }
        label631:
        i = 0;
        break label212;
      }
    }
  }
  
  public static void a(dnb paramdnb)
  {
    AppMethodBeat.i(289870);
    dnb localdnb;
    Object localObject1;
    if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_PURPLE))
    {
      localdnb = paramdnb;
      if (!BuildInfo.IS_FLAVOR_RED) {}
    }
    else
    {
      localdnb = paramdnb;
      if (paramdnb == null) {
        localdnb = new dnb();
      }
      paramdnb = localdnb.TUr;
      localObject1 = new ArrayList();
      Object localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTY().aSr()).intValue() == 1)
      {
        localObject2 = new dna();
        ((dna)localObject2).title = "用秒剪制作视频（仅测试）";
        ((dna)localObject2).icon = "";
        ((dna)localObject2).desc = "";
        ((dna)localObject2).type = 1;
        ((dna)localObject2).value = "wxa5e0de08d96cc09d";
        ((dna)localObject2).TUm = "miaojian://createvideo?scene=channels&page=1&from=channels";
        ((dna)localObject2).TUn = "https://miaojian.weixin.qq.com/download/apps/?channel=debug";
        ((dna)localObject2).TUo = "com.tencent.phoenix";
        ((dna)localObject2).TUp = "A24DC0755072F64C480DC06DCD3412BF";
        ((ArrayList)localObject1).add(localObject2);
      }
      paramdnb.addAll((Collection)localObject1);
    }
    if (localdnb != null)
    {
      paramdnb = localdnb.TUr;
      p.j(paramdnb, "actionSheetList.sheets");
      com.tencent.mm.ae.d.a(paramdnb, (kotlin.g.a.b)f.AEI);
      paramdnb = localdnb.TUr;
      p.j(paramdnb, "actionSheetList.sheets");
      paramdnb = ((Iterable)paramdnb).iterator();
      while (paramdnb.hasNext())
      {
        localObject1 = (dna)paramdnb.next();
        com.tencent.mm.pluginsdk.model.app.h.a(((dna)localObject1).value, ((dna)localObject1).TUo, null);
      }
      paramdnb = com.tencent.mm.kernel.h.aHG();
      p.j(paramdnb, "MMKernel.storage()");
      paramdnb.aHp().set(ar.a.VyA, Util.encodeHexString(localdnb.toByteArray()));
      AppMethodBeat.o(289870);
      return;
    }
    paramdnb = com.tencent.mm.kernel.h.aHG();
    p.j(paramdnb, "MMKernel.storage()");
    paramdnb.aHp().set(ar.a.VyA, "");
    AppMethodBeat.o(289870);
  }
  
  public static void a(HashMap<Integer, dna> paramHashMap, com.tencent.mm.ui.base.o paramo, Activity paramActivity)
  {
    Object localObject3 = null;
    AppMethodBeat.i(289871);
    p.k(paramHashMap, "actionMap");
    p.k(paramActivity, "context");
    Object localObject1 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    localObject1 = ((f)localObject1).aHp().get(ar.a.VyA, "");
    if (localObject1 == null)
    {
      paramHashMap = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(289871);
      throw paramHashMap;
    }
    localObject1 = (String)localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(289871);
      return;
    }
    Object localObject4 = Util.decodeHexString((String)localObject1);
    if (Util.isNullOrNil((byte[])localObject4))
    {
      AppMethodBeat.o(289871);
      return;
    }
    localObject1 = (com.tencent.mm.cd.a)new dnb();
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject4);
      localObject1 = (dnb)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((dnb)localObject1).TUr;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          for (i = 0;; i = j)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label290;
            }
            localObject4 = ((Iterator)localObject1).next();
            j = i + 1;
            if (i < 0) {
              j.iBO();
            }
            localObject4 = (dna)localObject4;
            paramHashMap.put(Integer.valueOf(i + 1010), localObject4);
            if (paramo == null) {
              break;
            }
            paramo.d(i + 1010, (CharSequence)((dna)localObject4).title);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j;
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        int i = j;
      }
      label290:
      paramHashMap = n.zWF;
      paramHashMap = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramo = aj.a.fZ((Context)paramActivity);
      paramHashMap = localObject3;
      if (paramo != null) {
        paramHashMap = paramo.ekY();
      }
      n.b(0, "post_actionsheet_miaojian", "", paramHashMap);
      AppMethodBeat.o(289871);
    }
  }
  
  public static boolean aFE(String paramString)
  {
    AppMethodBeat.i(289869);
    p.k(paramString, "packageName");
    try
    {
      String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vMA, "{\"com.tencent.phoenix\":{\"minApi\":26}}");
      if ((!Util.isNullOrNil(str)) && (str != null))
      {
        paramString = new JSONObject(str).optJSONObject(paramString);
        if (paramString != null)
        {
          int i = paramString.optInt("minApi", 0);
          if ((i > 0) && (Build.VERSION.SDK_INT < i))
          {
            AppMethodBeat.o(289869);
            return false;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      Log.printErrStackTrace("FinderConfig", paramString, "SHARE_SDK_SWITCH", new Object[0]);
      AppMethodBeat.o(289869);
    }
    return true;
  }
  
  public static void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(289867);
    p.k(paramString1, "errMsg");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put(AEo, paramInt);
    ((JSONObject)localObject).put(AEp, paramString1);
    paramString1 = ((JSONObject)localObject).toString();
    p.j(paramString1, "retJson.toString()");
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
    com.tencent.mm.pluginsdk.ui.tools.o.d(paramString1, (String)localObject, paramString2, -1, "");
    AppMethodBeat.o(289867);
  }
  
  public static String edA()
  {
    return AEw;
  }
  
  public static String edB()
  {
    return AEx;
  }
  
  public static String edC()
  {
    return AEy;
  }
  
  public static String edD()
  {
    return AEz;
  }
  
  public static String edE()
  {
    AppMethodBeat.i(289864);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put(AEq, "content://media/external/video/media/3426");
    ((JSONObject)localObject).put(AEr, "https://1500000419.vod2.myqcloud.com/6c9781f6vodcq1500000419/fcc5b21b5285890810062810511/NZQdSMAkg1AA.mp4");
    ((JSONObject)localObject).put(AEs, 2);
    ((JSONObject)localObject).put(AEt, "{\"file_id\":\"5285890810062810511\",\"media_source\":2,\"media_type\":\"video\",\"act_style\":11010,\"service_type\":2,\"media_scene\":1,\"service\":\"build\"}");
    localObject = ((JSONObject)localObject).toString();
    p.j(localObject, "extInfo.toString()");
    AppMethodBeat.o(289864);
    return localObject;
  }
  
  public static String edF()
  {
    AppMethodBeat.i(289865);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put(AEq, "content://media/external/video/media/3426");
    ((JSONObject)localObject).put(AEr, "");
    ((JSONObject)localObject).put(AEs, 1);
    ((JSONObject)localObject).put(AEt, "");
    ((JSONObject)localObject).put(AEv, "DQp7InRlbXBsYXRlSWQiOiJ5dWFuc2hlbmdfaF8yXzlfMTYiLCJtdXNpY0tleSI6IjE6MTM2NDg4Nzk2ODIwOTEyOTQ3MjoxIn0=");
    localObject = ((JSONObject)localObject).toString();
    p.j(localObject, "extInfo.toString()");
    AppMethodBeat.o(289865);
    return localObject;
  }
  
  public static String eds()
  {
    return AEo;
  }
  
  public static String edt()
  {
    return AEp;
  }
  
  public static String edu()
  {
    return AEq;
  }
  
  public static String edv()
  {
    return AEr;
  }
  
  public static String edw()
  {
    return AEs;
  }
  
  public static String edx()
  {
    return AEt;
  }
  
  public static String edy()
  {
    return AEu;
  }
  
  public static String edz()
  {
    return AEv;
  }
  
  public static void showToast(String paramString)
  {
    AppMethodBeat.i(289866);
    p.k(paramString, "wording");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ab.g(paramString));
    }
    AppMethodBeat.o(289866);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class a<T, R>
    implements com.tencent.mm.loader.f.e<w, Bitmap>
  {
    a(MenuItem paramMenuItem, Activity paramActivity, com.tencent.mm.ui.widget.a.e parame) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderSdkShareUtil$addSameStyleToBottomSheet$1$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(Bitmap paramBitmap, ab.a parama)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(boolean paramBoolean, Context paramContext, dna paramdna) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(286508);
      paramDialogInterface.dismiss();
      paramDialogInterface = ab.AEA;
      Log.i(ab.edG(), "dialog ok isInstall:" + this.AED);
      if (this.AED)
      {
        paramDialogInterface = ab.AEA;
        Context localContext = paramContext;
        localObject1 = paramdna.TUm;
        paramDialogInterface = (DialogInterface)localObject1;
        if (localObject1 == null) {
          paramDialogInterface = "";
        }
        localObject2 = paramdna.TUo;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ab.E(localContext, paramDialogInterface, (String)localObject1);
        AppMethodBeat.o(286508);
        return;
      }
      paramDialogInterface = com.tencent.mm.plugin.recordvideo.e.a.IeL;
      Object localObject2 = paramContext;
      Object localObject1 = paramdna.TUn;
      paramDialogInterface = (DialogInterface)localObject1;
      if (localObject1 == null) {
        paramDialogInterface = "";
      }
      com.tencent.mm.plugin.recordvideo.e.a.aK((Context)localObject2, paramDialogInterface);
      AppMethodBeat.o(286508);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    public static final c AEF;
    
    static
    {
      AppMethodBeat.i(292324);
      AEF = new c();
      AppMethodBeat.o(292324);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(292323);
      ab localab = ab.AEA;
      Log.i(ab.edG(), "dialog cancel");
      paramDialogInterface.dismiss();
      AppMethodBeat.o(292323);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(boolean paramBoolean, Activity paramActivity, String paramString, dna paramdna) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(286167);
      paramDialogInterface.dismiss();
      paramDialogInterface = ab.AEA;
      Log.i(ab.edG(), "dialog ok isInstall:" + this.AED);
      if (this.AED)
      {
        paramDialogInterface = ab.AEA;
        localContext = (Context)paramActivity;
        String str2 = this.AEG;
        str1 = paramdna.TUo;
        paramDialogInterface = str1;
        if (str1 == null) {
          paramDialogInterface = "";
        }
        ab.E(localContext, str2, paramDialogInterface);
        AppMethodBeat.o(286167);
        return;
      }
      paramDialogInterface = com.tencent.mm.plugin.recordvideo.e.a.IeL;
      Context localContext = (Context)paramActivity;
      String str1 = paramdna.TUn;
      paramDialogInterface = str1;
      if (str1 == null) {
        paramDialogInterface = "";
      }
      com.tencent.mm.plugin.recordvideo.e.a.aK(localContext, paramDialogInterface);
      AppMethodBeat.o(286167);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    public static final e AEH;
    
    static
    {
      AppMethodBeat.i(289617);
      AEH = new e();
      AppMethodBeat.o(289617);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(289615);
      ab localab = ab.AEA;
      Log.i(ab.edG(), "dialog cancel");
      paramDialogInterface.dismiss();
      AppMethodBeat.o(289615);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<dna, Boolean>
  {
    public static final f AEI;
    
    static
    {
      AppMethodBeat.i(279813);
      AEI = new f();
      AppMethodBeat.o(279813);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ab
 * JD-Core Version:    0.7.0.1
 */