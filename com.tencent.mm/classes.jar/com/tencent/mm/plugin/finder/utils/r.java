package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.ddl;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderSdkShareUtil;", "", "()V", "FROM_STR", "", "getFROM_STR", "()Ljava/lang/String;", "REQ_FROM", "getREQ_FROM", "REQ_FROMAPP", "getREQ_FROMAPP", "REQ_PARAMSJSON", "getREQ_PARAMSJSON", "REQ_PATH", "getREQ_PATH", "REQ_URL", "getREQ_URL", "RET_ERRCODE", "getRET_ERRCODE", "RET_ERRMSG", "getRET_ERRMSG", "TAG", "dealShare", "", "businessType", "appid", "extInfo", "fallback", "errcode", "", "errMsg", "genTestConfig", "genTestPostActionSheet", "", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "getShareAppSwitch", "", "packageName", "getTestJson", "getTestJson2", "onClickPostAction", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "context", "Landroid/content/Context;", "actionSheet", "readPostAction", "startId", "actionMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "savePostAction", "actionList", "Lcom/tencent/mm/protocal/protobuf/PostActionSheetList;", "showToast", "wording", "startPostAction", "uri", "plugin-finder_release"})
public final class r
{
  public static final String TAG = "Finder.FinderSdkShareUtil";
  private static final String vWf = "errCode";
  private static final String vWg = "errmsg";
  private static final String vWh = "localIdentifier";
  private static final String vWi = "remoteUrl";
  private static final String vWj = "fromAppType";
  private static final String vWk = "paramsJson";
  private static final String vWl = "from";
  private static final String vWm = "channels";
  public static final r vWn;
  
  static
  {
    AppMethodBeat.i(253491);
    vWn = new r();
    TAG = "Finder.FinderSdkShareUtil";
    vWf = "errCode";
    vWg = "errmsg";
    vWh = "localIdentifier";
    vWi = "remoteUrl";
    vWj = "fromAppType";
    vWk = "paramsJson";
    vWl = "from";
    vWm = "channels";
    AppMethodBeat.o(253491);
  }
  
  public static void A(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(253490);
    p.h(paramContext, "context");
    p.h(paramString1, "uri");
    p.h(paramString2, "packageName");
    Log.i(TAG, "startPostAction " + paramString2 + ", " + paramString1);
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString1));
    localIntent.setPackage(paramString2);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    try
    {
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.axQ(), "com/tencent/mm/plugin/finder/utils/FinderSdkShareUtil", "startPostAction", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/FinderSdkShareUtil", "startPostAction", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253490);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e(TAG, "startPostAction: error " + paramContext.getMessage());
      AppMethodBeat.o(253490);
    }
  }
  
  public static com.tencent.mm.ui.widget.a.d a(final Context paramContext, final ddk paramddk)
  {
    AppMethodBeat.i(253489);
    p.h(paramContext, "context");
    if ((paramddk == null) || (Util.isNullOrNil(paramddk.MIA)))
    {
      AppMethodBeat.o(253489);
      return null;
    }
    boolean bool;
    Object localObject2;
    if (Util.isNullOrNil(paramddk.MIA))
    {
      bool = false;
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.r(paramContext, paramddk.value);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (!bool) {
        break label188;
      }
    }
    label188:
    for (Object localObject1 = paramContext.getString(2131760527, new Object[] { localObject1 });; localObject1 = paramContext.getString(2131760526, new Object[] { localObject1 }))
    {
      paramContext = com.tencent.mm.ui.base.h.c(paramContext, (String)localObject1, "", paramContext.getString(2131755921), paramContext.getString(2131755761), (DialogInterface.OnClickListener)new a(bool, paramContext, paramddk), (DialogInterface.OnClickListener)b.vWq);
      AppMethodBeat.o(253489);
      return paramContext;
      localObject1 = com.tencent.mm.plugin.recordvideo.e.a.ChV;
      localObject2 = paramddk.MIA;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str = paramddk.MIB;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      bool = com.tencent.mm.plugin.recordvideo.e.a.G(paramContext, (String)localObject1, (String)localObject2);
      break;
    }
  }
  
  public static void a(ddl paramddl)
  {
    AppMethodBeat.i(253487);
    ddl localddl;
    Object localObject1;
    if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_PURPLE))
    {
      localddl = paramddl;
      if (!BuildInfo.IS_FLAVOR_RED) {}
    }
    else
    {
      localddl = paramddl;
      if (paramddl == null) {
        localddl = new ddl();
      }
      paramddl = localddl.MIC;
      localObject1 = new ArrayList();
      Object localObject2 = c.vCb;
      if (((Number)c.dsG().value()).intValue() == 1)
      {
        localObject2 = new ddk();
        ((ddk)localObject2).title = "用秒剪制作视频（仅测试）";
        ((ddk)localObject2).icon = "";
        ((ddk)localObject2).desc = "";
        ((ddk)localObject2).type = 1;
        ((ddk)localObject2).value = "wxa5e0de08d96cc09d";
        ((ddk)localObject2).MIy = "miaojian://createvideo?scene=channels&page=1&from=channels";
        ((ddk)localObject2).MIz = "https://miaojian.weixin.qq.com/download/apps/?channel=debug";
        ((ddk)localObject2).MIA = "com.tencent.phoenix";
        ((ddk)localObject2).MIB = "A24DC0755072F64C480DC06DCD3412BF";
        ((ArrayList)localObject1).add(localObject2);
      }
      paramddl.addAll((Collection)localObject1);
    }
    if (localddl != null)
    {
      paramddl = localddl.MIC;
      p.g(paramddl, "actionSheetList.sheets");
      com.tencent.mm.ac.d.a(paramddl, (kotlin.g.a.b)c.vWr);
      paramddl = localddl.MIC;
      p.g(paramddl, "actionSheetList.sheets");
      paramddl = ((Iterable)paramddl).iterator();
      while (paramddl.hasNext())
      {
        localObject1 = (ddk)paramddl.next();
        com.tencent.mm.pluginsdk.model.app.h.a(((ddk)localObject1).value, ((ddk)localObject1).MIA, null);
      }
      paramddl = g.aAh();
      p.g(paramddl, "MMKernel.storage()");
      paramddl.azQ().set(ar.a.Oke, Util.encodeHexString(localddl.toByteArray()));
      AppMethodBeat.o(253487);
      return;
    }
    paramddl = g.aAh();
    p.g(paramddl, "MMKernel.storage()");
    paramddl.azQ().set(ar.a.Oke, "");
    AppMethodBeat.o(253487);
  }
  
  public static void a(HashMap<Integer, ddk> paramHashMap, m paramm)
  {
    int i = 0;
    AppMethodBeat.i(253488);
    p.h(paramHashMap, "actionMap");
    Object localObject1 = g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    localObject1 = ((e)localObject1).azQ().get(ar.a.Oke, "");
    if (localObject1 == null)
    {
      paramHashMap = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(253488);
      throw paramHashMap;
    }
    localObject1 = (String)localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(253488);
      return;
    }
    Object localObject3 = Util.decodeHexString((String)localObject1);
    if (Util.isNullOrNil((byte[])localObject3))
    {
      AppMethodBeat.o(253488);
      return;
    }
    localObject1 = (com.tencent.mm.bw.a)new ddl();
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (ddl)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((ddl)localObject1).MIC;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label278;
            }
            localObject3 = ((Iterator)localObject1).next();
            j = i + 1;
            if (i < 0) {
              j.hxH();
            }
            localObject3 = (ddk)localObject3;
            paramHashMap.put(Integer.valueOf(i + 1010), localObject3);
            if (paramm == null) {
              break;
            }
            paramm.d(i + 1010, (CharSequence)((ddk)localObject3).title);
            i = j;
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
        i = j;
      }
      label278:
      AppMethodBeat.o(253488);
      return;
    }
    AppMethodBeat.o(253488);
  }
  
  public static boolean awj(String paramString)
  {
    AppMethodBeat.i(253486);
    p.h(paramString, "packageName");
    try
    {
      String str = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sdr, "{\"com.tencent.phoenix\":{\"minApi\":26}}");
      if ((!Util.isNullOrNil(str)) && (str != null))
      {
        paramString = new JSONObject(str).optJSONObject(paramString);
        if (paramString != null)
        {
          int i = paramString.optInt("minApi", 0);
          if ((i > 0) && (Build.VERSION.SDK_INT < i))
          {
            AppMethodBeat.o(253486);
            return false;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      Log.printErrStackTrace("FinderConfig", paramString, "SHARE_SDK_SWITCH", new Object[0]);
      AppMethodBeat.o(253486);
    }
    return true;
  }
  
  public static String dCc()
  {
    return vWh;
  }
  
  public static String dCd()
  {
    return vWi;
  }
  
  public static String dCe()
  {
    return vWj;
  }
  
  public static String dCf()
  {
    return vWk;
  }
  
  public static String dCg()
  {
    return vWl;
  }
  
  public static String dCh()
  {
    return vWm;
  }
  
  public static String dCi()
  {
    AppMethodBeat.i(253482);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put(vWh, "content://media/external/video/media/3426");
    ((JSONObject)localObject).put(vWi, "https://1500000419.vod2.myqcloud.com/6c9781f6vodcq1500000419/fcc5b21b5285890810062810511/NZQdSMAkg1AA.mp4");
    ((JSONObject)localObject).put(vWj, 2);
    ((JSONObject)localObject).put(vWk, "{\"file_id\":\"5285890810062810511\",\"media_source\":2,\"media_type\":\"video\",\"act_style\":11010,\"service_type\":2,\"media_scene\":1,\"service\":\"build\"}");
    localObject = ((JSONObject)localObject).toString();
    p.g(localObject, "extInfo.toString()");
    AppMethodBeat.o(253482);
    return localObject;
  }
  
  public static String dCj()
  {
    AppMethodBeat.i(253483);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put(vWh, "content://media/external/video/media/3426");
    ((JSONObject)localObject).put(vWi, "");
    ((JSONObject)localObject).put(vWj, 1);
    ((JSONObject)localObject).put(vWk, "");
    localObject = ((JSONObject)localObject).toString();
    p.g(localObject, "extInfo.toString()");
    AppMethodBeat.o(253483);
    return localObject;
  }
  
  public static void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(253485);
    p.h(paramString1, "errMsg");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put(vWf, paramInt);
    ((JSONObject)localObject).put(vWg, paramString1);
    paramString1 = ((JSONObject)localObject).toString();
    p.g(paramString1, "retJson.toString()");
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
    AppMethodBeat.o(253485);
  }
  
  public static void showToast(String paramString)
  {
    AppMethodBeat.i(253484);
    p.h(paramString, "wording");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new r.d(paramString));
    }
    AppMethodBeat.o(253484);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(boolean paramBoolean, Context paramContext, ddk paramddk) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(253476);
      paramDialogInterface.dismiss();
      paramDialogInterface = r.vWn;
      Log.i(r.dCk(), "dialog ok isInstall:" + this.vWo);
      if (this.vWo)
      {
        paramDialogInterface = r.vWn;
        Context localContext = paramContext;
        localObject1 = paramddk.MIy;
        paramDialogInterface = (DialogInterface)localObject1;
        if (localObject1 == null) {
          paramDialogInterface = "";
        }
        localObject2 = paramddk.MIA;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        r.A(localContext, paramDialogInterface, (String)localObject1);
        AppMethodBeat.o(253476);
        return;
      }
      paramDialogInterface = com.tencent.mm.plugin.recordvideo.e.a.ChV;
      Object localObject2 = paramContext;
      Object localObject1 = paramddk.MIz;
      paramDialogInterface = (DialogInterface)localObject1;
      if (localObject1 == null) {
        paramDialogInterface = "";
      }
      com.tencent.mm.plugin.recordvideo.e.a.bt((Context)localObject2, paramDialogInterface);
      AppMethodBeat.o(253476);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    public static final b vWq;
    
    static
    {
      AppMethodBeat.i(253478);
      vWq = new b();
      AppMethodBeat.o(253478);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(253477);
      r localr = r.vWn;
      Log.i(r.dCk(), "dialog cancel");
      paramDialogInterface.dismiss();
      AppMethodBeat.o(253477);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<ddk, Boolean>
  {
    public static final c vWr;
    
    static
    {
      AppMethodBeat.i(253480);
      vWr = new c();
      AppMethodBeat.o(253480);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.r
 * JD-Core Version:    0.7.0.1
 */