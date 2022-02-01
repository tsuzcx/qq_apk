package com.tencent.mm.plugin.hld.f;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/WxImeUtil;", "", "()V", "TAG", "", "lastNoInitFinishTimestamp", "", "getLastNoInitFinishTimestamp", "()J", "setLastNoInitFinishTimestamp", "(J)V", "checkDictValid", "", "dict", "Lcom/tencent/mm/protocal/protobuf/ImeLocalCloudDict;", "checkFetchFirstCloudResDownload", "", "checkInInputMethodList", "checkPermission", "permissions", "", "([Ljava/lang/String;)Z", "clearUserData", "closeIme", "context", "Landroid/content/Context;", "defaultIme", "disabledIme", "enableIme", "filterEnableIme", "finishActiveFifthProcess", "finishActiveFirstProcess", "finishActiveSecondProcess", "finishFirstCloudResDownload", "getAssetsCacheFile", "assetDirName", "fileName", "getBitmapCachePath", "isLandscape", "getBitmapCachePathByKeyboard", "ordinal", "", "getCPUInfo", "getCloudResPathByName", "name", "getCurIme", "getDefaultModeConfig", "getDialogType", "getEmojiImagPath", "getEngineProcessStr", "processType", "Lcom/tencent/mm/plugin/hld/model/ImeProcessInputType;", "keyParam", "Lcom/tencent/mm/plugin/hld/api/ImeKeyParam;", "getFinishFirstCloudResStatus", "getImeState", "getInvalidUserKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKV", "getRecoveryConfig", "getStatusBarHeight", "getTotalMemory", "getTotalRAMMemory", "getTotalROMMemory", "getUserDictPath", "getUserKV", "getUserPath", "getWxImeCachePath", "getWxImeCommonUserPath", "getWxImeEnginePath", "safetyMode", "getWxImeNetworkPath", "getWxImePath", "getWxImeUserPath", "goToContactInfoUI", "ifShowOldUserGuideView", "inInputMethodListBySystem", "isActionKey", "view", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "isCurrentIme", "isDefaultIme", "isDeleteKey", "isEmptyEditText", "isEnoughSpace", "size", "isExptImeVisible", "isFinishActiveFifthProcess", "isFinishActiveFirstProcess", "isFinishActiveSecondProcess", "isFirstFetchRes", "isImeActive", "isImeCurActive", "isImeEnable", "isImeInstall", "isInImeList", "isLocalFinishActiveFifthProcess", "isLocalFinishActiveFirstProcess", "isLocalFinishActiveSecondProcess", "isLogin", "isSafetyKeyboard", "killImeProcess", "killProcess", "pid", "printDict", "printList", "T", "rets", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "arg", "printUserClickData", "tag", "content", "resetActiveProcess", "setDefaultIme", "default", "showNoInitFinishToast", "showNoSupportToast", "switchToDefaultIme", "close", "triggerNewTips", "unFinishFirstCloudResDownload", "plugin-hld_release"})
public final class l
{
  private static long DHJ;
  public static final l DHK;
  
  static
  {
    AppMethodBeat.i(211778);
    DHK = new l();
    AppMethodBeat.o(211778);
  }
  
  public static boolean L(String[] paramArrayOfString)
  {
    AppMethodBeat.i(211746);
    kotlin.g.b.p.k(paramArrayOfString, "permissions");
    int j = paramArrayOfString.length;
    int i = 0;
    boolean bool = true;
    if (i < j)
    {
      String str = paramArrayOfString[i];
      if ((bool) && (com.tencent.mm.pluginsdk.permission.b.k(MMApplicationContext.getContext(), str, false))) {}
      for (bool = true;; bool = false)
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(211746);
    return bool;
  }
  
  public static String b(com.tencent.mm.plugin.hld.model.h paramh, com.tencent.mm.plugin.hld.a.g paramg)
  {
    AppMethodBeat.i(211765);
    kotlin.g.b.p.k(paramh, "processType");
    String str = "";
    if (paramg != null) {}
    for (paramh = paramh.value + " " + paramg.text;; paramh = str)
    {
      AppMethodBeat.o(211765);
      return paramh;
      Log.e("WxIme.ImeKeyboardActionListener", "getEngineProcessStr keyParam is null");
    }
  }
  
  public static <T> String b(List<? extends T> paramList, kotlin.g.a.b<? super T, String> paramb)
  {
    AppMethodBeat.i(211767);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("[");
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (localObject != null)
        {
          if (paramb != null)
          {
            StringBuilder localStringBuilder1 = localStringBuilder2.append((String)paramb.invoke(localObject));
            paramList = localStringBuilder1;
            if (localStringBuilder1 != null) {}
          }
          else
          {
            paramList = localStringBuilder2.append(localObject.toString());
          }
          if (paramList != null) {}
        }
        else
        {
          localStringBuilder2.append("null");
        }
        localStringBuilder2.append(" ");
      }
    }
    localStringBuilder2.append("]");
    paramList = localStringBuilder2.toString();
    kotlin.g.b.p.j(paramList, "result.toString()");
    AppMethodBeat.o(211767);
    return paramList;
  }
  
  public static boolean biq()
  {
    AppMethodBeat.i(211753);
    if (com.tencent.mm.kernel.b.aGQ() != 0)
    {
      AppMethodBeat.o(211753);
      return true;
    }
    AppMethodBeat.o(211753);
    return false;
  }
  
  public static boolean e(ImeKeyRelativeLayout paramImeKeyRelativeLayout)
  {
    AppMethodBeat.i(211692);
    kotlin.g.b.p.k(paramImeKeyRelativeLayout, "view");
    if (((paramImeKeyRelativeLayout.getType() & 0x2) == 2) && (paramImeKeyRelativeLayout.getFunctionCode() == 1))
    {
      AppMethodBeat.o(211692);
      return true;
    }
    AppMethodBeat.o(211692);
    return false;
  }
  
  public static boolean eCE()
  {
    AppMethodBeat.i(211752);
    com.tencent.mm.plugin.hld.a.d locald = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
    if ((locald != null) && (locald.eCE() == true))
    {
      AppMethodBeat.o(211752);
      return true;
    }
    AppMethodBeat.o(211752);
    return false;
  }
  
  public static boolean eCG()
  {
    AppMethodBeat.i(211756);
    Object localObject = new Intent("android.settings.INPUT_METHOD_SETTINGS");
    Context localContext = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localContext, "MMApplicationContext.getContext()");
    localObject = localContext.getPackageManager().queryIntentActivities((Intent)localObject, 32);
    Log.i("WxIme.WxImeUtil", "filterEnableIme resolveInfos.size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() <= 0)
    {
      localObject = com.tencent.mm.plugin.hld.model.k.DDb;
      com.tencent.mm.plugin.hld.model.k.d(1, 0, null, 12);
      AppMethodBeat.o(211756);
      return true;
    }
    AppMethodBeat.o(211756);
    return false;
  }
  
  public static boolean eCH()
  {
    AppMethodBeat.i(211761);
    Object localObject1 = MMApplicationContext.getContext().getSystemService("input_method");
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(211761);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((InputMethodManager)localObject1).getInputMethodList();
    Object localObject2 = new StringBuilder("inInputMethodList inputMethodList.size");
    if (localObject1 != null) {}
    for (int i = ((List)localObject1).size();; i = 0)
    {
      Log.i("WxIme.WxImeUtil", i);
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label196;
        }
        localObject2 = (InputMethodInfo)((Iterator)localObject1).next();
        Object localObject3 = new StringBuilder("inInputMethodList ");
        kotlin.g.b.p.j(localObject2, "imi");
        Log.i("WxIme.WxImeUtil", ((InputMethodInfo)localObject2).getId());
        localObject3 = ((InputMethodInfo)localObject2).getId();
        com.tencent.mm.plugin.hld.model.p localp = com.tencent.mm.plugin.hld.model.p.DEH;
        if (kotlin.g.b.p.h(localObject3, com.tencent.mm.plugin.hld.model.p.eFo())) {
          break;
        }
        localObject2 = ((InputMethodInfo)localObject2).getId();
        localObject3 = com.tencent.mm.plugin.hld.model.p.DEH;
      } while (!kotlin.g.b.p.h(localObject2, com.tencent.mm.plugin.hld.model.p.eFp()));
      AppMethodBeat.o(211761);
      return true;
    }
    label196:
    Log.e("WxIme.WxImeUtil", "inInputMethodList false!!!");
    localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
    com.tencent.mm.plugin.hld.model.k.d(2, 0, null, 12);
    AppMethodBeat.o(211761);
    return false;
  }
  
  public static void eCI()
  {
    AppMethodBeat.i(211758);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime");
    if (localMultiProcessMMKV != null)
    {
      if (localMultiProcessMMKV.getBoolean("ime_if_check_input_method_list", false)) {
        AppMethodBeat.o(211758);
      }
    }
    else
    {
      AppMethodBeat.o(211758);
      return;
    }
    localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime");
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("ime_if_check_input_method_list", true);
    }
    new Thread((Runnable)a.DHL).start();
    AppMethodBeat.o(211758);
  }
  
  public static String eGU()
  {
    AppMethodBeat.i(211679);
    String str = com.tencent.mm.loader.j.b.aSD() + "wxime";
    if (!u.agG(str)) {
      u.bBD(str);
    }
    AppMethodBeat.o(211679);
    return str;
  }
  
  public static String eGV()
  {
    AppMethodBeat.i(211680);
    int i = com.tencent.mm.kernel.b.aGQ();
    if (i == 0)
    {
      AppMethodBeat.o(211680);
      return null;
    }
    Object localObject1 = new StringBuilder().append(eGU()).append("/");
    Object localObject2 = "ime_".concat(String.valueOf(i));
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(211680);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    kotlin.g.b.p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject2);
    if (!u.agG((String)localObject1)) {
      u.bBD((String)localObject1);
    }
    AppMethodBeat.o(211680);
    return localObject1;
  }
  
  public static String eGW()
  {
    AppMethodBeat.i(211681);
    String str = com.tencent.mm.loader.j.b.aSD() + "wxime/cache";
    if (!u.agG(str)) {
      u.bBD(str);
    }
    AppMethodBeat.o(211681);
    return str;
  }
  
  public static String eGX()
  {
    AppMethodBeat.i(211683);
    String str = eGU() + "/emoji_res";
    if (!u.agG(str)) {
      u.bBD(str);
    }
    AppMethodBeat.o(211683);
    return str;
  }
  
  public static boolean eGY()
  {
    AppMethodBeat.i(211690);
    Object localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).Uo(1);
        if (localObject != null) {
          break label51;
        }
      }
    }
    AppMethodBeat.o(211690);
    return false;
    label51:
    if ((Util.isNullOrNil(((com.tencent.mm.plugin.hld.a.e)localObject).Dud)) && (Util.isNullOrNil(((com.tencent.mm.plugin.hld.a.e)localObject).Duf)) && (Util.isNullOrNil(((com.tencent.mm.plugin.hld.a.e)localObject).Due)))
    {
      AppMethodBeat.o(211690);
      return true;
    }
    AppMethodBeat.o(211690);
    return false;
  }
  
  public static String eGZ()
  {
    return "/emojiuser1/";
  }
  
  public static boolean eHA()
  {
    boolean bool = true;
    AppMethodBeat.i(211755);
    Object localObject = eHB();
    if (localObject != null)
    {
      if (((MultiProcessMMKV)localObject).getInt("ime_old_user_guide_show", 0) != 1) {
        break label81;
      }
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
      if (he((Context)localObject)) {
        break label59;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(211755);
      return bool;
      bool = false;
      continue;
      label59:
      localObject = eHB();
      if (localObject != null)
      {
        ((MultiProcessMMKV)localObject).putInt("ime_old_user_guide_show", 2);
        bool = false;
      }
      else
      {
        label81:
        bool = false;
      }
    }
  }
  
  public static MultiProcessMMKV eHB()
  {
    AppMethodBeat.i(211776);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_" + com.tencent.mm.kernel.b.aGQ());
    AppMethodBeat.o(211776);
    return localMultiProcessMMKV;
  }
  
  public static MultiProcessMMKV eHC()
  {
    AppMethodBeat.i(292899);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    AppMethodBeat.o(292899);
    return localMultiProcessMMKV;
  }
  
  public static boolean eHa()
  {
    AppMethodBeat.i(211703);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEZ, -1) == 1)
    {
      AppMethodBeat.o(211703);
      return true;
    }
    AppMethodBeat.o(211703);
    return false;
  }
  
  public static String eHb()
  {
    AppMethodBeat.i(211704);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFa, "60000_4");
    kotlin.g.b.p.j(str, "MMKernel.service(IExptSe…covery_config, \"60000_4\")");
    AppMethodBeat.o(211704);
    return str;
  }
  
  public static int eHc()
  {
    AppMethodBeat.i(211705);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFb, 1);
    AppMethodBeat.o(211705);
    return i;
  }
  
  public static int eHd()
  {
    AppMethodBeat.i(211706);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime");
    if (localMultiProcessMMKV != null)
    {
      int i = localMultiProcessMMKV.getInt("ime_first_cloud_resource_download_STATUS", 0);
      AppMethodBeat.o(211706);
      return i;
    }
    AppMethodBeat.o(211706);
    return 0;
  }
  
  public static void eHe()
  {
    AppMethodBeat.i(211707);
    Log.i("WxIme.WxImeUtil", "triggerNewTips");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, c.DHO.getClass(), null);
    AppMethodBeat.o(211707);
  }
  
  public static boolean eHf()
  {
    AppMethodBeat.i(211708);
    if (eHd() != 2)
    {
      AppMethodBeat.o(211708);
      return true;
    }
    AppMethodBeat.o(211708);
    return false;
  }
  
  public static void eHg()
  {
    long l2 = 60000L;
    long l1 = 0L;
    AppMethodBeat.i(211709);
    int i = eHd();
    Log.i("WxIme.WxImeUtil", "finishFirstCloudResDownload ".concat(String.valueOf(i)));
    if (i != 2)
    {
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
      boolean bool1 = gK((Context)localObject);
      if (!bool1) {
        break label220;
      }
      eHe();
      localObject = MultiProcessMMKV.getMMKV("wx_ime");
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).putInt("ime_first_cloud_resource_download_STATUS", 2);
      }
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
      boolean bool2 = gJ((Context)localObject);
      boolean bool3 = eCG();
      Log.i("WxIme.WxImeUtil", "finishFirstCloudResDownload visible:" + eHa() + " enable:" + bool2 + " filterEnable:" + bool3 + " isInImeList:" + bool1);
      if ((eHa()) && (!bool2) && (!bool3))
      {
        localObject = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
        gH((Context)localObject);
      }
    }
    Object localObject = n.DEn;
    n.eEH();
    AppMethodBeat.o(211709);
    return;
    label220:
    localObject = MultiProcessMMKV.getMMKV("wx_ime");
    if (localObject != null) {
      l1 = ((MultiProcessMMKV)localObject).getLong("ime_enable_time", 0L);
    }
    long l3 = cm.bfG();
    if (l3 - l1 > 60000L) {}
    for (l1 = l2;; l1 = l3 - l1)
    {
      Log.i("WxIme.WxImeUtil", "finishFirstCloudResDownload interTime:".concat(String.valueOf(l1)));
      com.tencent.e.h.ZvG.o((Runnable)b.DHN, l1);
      break;
    }
  }
  
  public static void eHh()
  {
    AppMethodBeat.i(211710);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime");
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.putInt("ime_first_cloud_resource_download_STATUS", 0);
      AppMethodBeat.o(211710);
      return;
    }
    AppMethodBeat.o(211710);
  }
  
  public static void eHi()
  {
    AppMethodBeat.i(211712);
    int i = eHd();
    Log.i("WxIme.WxImeUtil", "checkFetchFirstCloudResDownload ".concat(String.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(211712);
      return;
      com.tencent.mm.plugin.hld.c.a locala = com.tencent.mm.plugin.hld.c.a.DvH;
      if (!com.tencent.mm.plugin.hld.c.a.eCT())
      {
        locala = com.tencent.mm.plugin.hld.c.a.DvH;
        com.tencent.mm.plugin.hld.c.a.eCV();
        AppMethodBeat.o(211712);
        return;
        locala = com.tencent.mm.plugin.hld.c.a.DvH;
        if (!com.tencent.mm.plugin.hld.c.a.eCT())
        {
          locala = com.tencent.mm.plugin.hld.c.a.DvH;
          com.tencent.mm.plugin.hld.c.a.eCV();
        }
      }
    }
  }
  
  public static boolean eHj()
  {
    AppMethodBeat.i(211718);
    boolean bool;
    if (biq())
    {
      localMultiProcessMMKV = eHB();
      if (localMultiProcessMMKV != null)
      {
        bool = localMultiProcessMMKV.getBoolean("ime_active_first_process_privacy_info", false);
        AppMethodBeat.o(211718);
        return bool;
      }
      AppMethodBeat.o(211718);
      return false;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV != null)
    {
      bool = localMultiProcessMMKV.getBoolean("ime_active_first_process_privacy_info", false);
      AppMethodBeat.o(211718);
      return bool;
    }
    AppMethodBeat.o(211718);
    return false;
  }
  
  public static boolean eHk()
  {
    AppMethodBeat.i(211720);
    boolean bool;
    if (biq())
    {
      localObject = eHB();
      if (localObject != null) {
        bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_first_process_privacy_info", false);
      }
      while (!bool)
      {
        localObject = i.DHq;
        if ((i.eGG() & 0x10000) == 65536)
        {
          AppMethodBeat.o(211720);
          return true;
          bool = false;
        }
        else
        {
          AppMethodBeat.o(211720);
          return false;
        }
      }
      AppMethodBeat.o(211720);
      return bool;
    }
    Object localObject = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localObject != null)
    {
      bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_first_process_privacy_info", false);
      AppMethodBeat.o(211720);
      return bool;
    }
    AppMethodBeat.o(211720);
    return false;
  }
  
  public static void eHl()
  {
    AppMethodBeat.i(211723);
    MultiProcessMMKV localMultiProcessMMKV = eHB();
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("ime_active_first_process_privacy_info", true);
    }
    localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.putBoolean("ime_active_first_process_privacy_info", true);
      AppMethodBeat.o(211723);
      return;
    }
    AppMethodBeat.o(211723);
  }
  
  public static boolean eHm()
  {
    AppMethodBeat.i(211724);
    boolean bool;
    if (biq())
    {
      localMultiProcessMMKV = eHB();
      if (localMultiProcessMMKV != null)
      {
        bool = localMultiProcessMMKV.getBoolean("ime_active_second_process_collect_data", false);
        AppMethodBeat.o(211724);
        return bool;
      }
      AppMethodBeat.o(211724);
      return false;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV != null)
    {
      bool = localMultiProcessMMKV.getBoolean("ime_active_second_process_collect_data", false);
      AppMethodBeat.o(211724);
      return bool;
    }
    AppMethodBeat.o(211724);
    return false;
  }
  
  public static boolean eHn()
  {
    AppMethodBeat.i(211725);
    boolean bool;
    if (biq())
    {
      localObject = eHB();
      if (localObject != null) {
        bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_second_process_collect_data", false);
      }
      while (!bool)
      {
        localObject = i.DHq;
        if ((i.eGG() & 0x8) == 8)
        {
          AppMethodBeat.o(211725);
          return true;
          bool = false;
        }
        else
        {
          AppMethodBeat.o(211725);
          return false;
        }
      }
      AppMethodBeat.o(211725);
      return bool;
    }
    Object localObject = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localObject != null)
    {
      bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_second_process_collect_data", false);
      AppMethodBeat.o(211725);
      return bool;
    }
    AppMethodBeat.o(211725);
    return false;
  }
  
  public static void eHo()
  {
    AppMethodBeat.i(211727);
    MultiProcessMMKV localMultiProcessMMKV = eHB();
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("ime_active_second_process_collect_data", true);
    }
    localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.putBoolean("ime_active_second_process_collect_data", true);
      AppMethodBeat.o(211727);
      return;
    }
    AppMethodBeat.o(211727);
  }
  
  public static boolean eHp()
  {
    AppMethodBeat.i(211728);
    boolean bool;
    if (biq())
    {
      localMultiProcessMMKV = eHB();
      if (localMultiProcessMMKV != null)
      {
        bool = localMultiProcessMMKV.getBoolean("ime_active_fifth_process_choose_keyboard", false);
        AppMethodBeat.o(211728);
        return bool;
      }
      AppMethodBeat.o(211728);
      return false;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV != null)
    {
      bool = localMultiProcessMMKV.getBoolean("ime_active_fifth_process_choose_keyboard", false);
      AppMethodBeat.o(211728);
      return bool;
    }
    AppMethodBeat.o(211728);
    return false;
  }
  
  public static boolean eHq()
  {
    AppMethodBeat.i(211730);
    boolean bool;
    if (biq())
    {
      localObject = eHB();
      if (localObject != null) {
        bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_fifth_process_choose_keyboard", false);
      }
      while (!bool)
      {
        localObject = i.DHq;
        if ((i.eGG() & 0x10) == 16)
        {
          AppMethodBeat.o(211730);
          return true;
          bool = false;
        }
        else
        {
          AppMethodBeat.o(211730);
          return false;
        }
      }
      AppMethodBeat.o(211730);
      return bool;
    }
    Object localObject = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localObject != null)
    {
      bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_fifth_process_choose_keyboard", false);
      AppMethodBeat.o(211730);
      return bool;
    }
    AppMethodBeat.o(211730);
    return false;
  }
  
  public static void eHr()
  {
    AppMethodBeat.i(211731);
    MultiProcessMMKV localMultiProcessMMKV = eHB();
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("ime_active_fifth_process_choose_keyboard", true);
    }
    localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.putBoolean("ime_active_fifth_process_choose_keyboard", true);
      AppMethodBeat.o(211731);
      return;
    }
    AppMethodBeat.o(211731);
  }
  
  public static boolean eHs()
  {
    AppMethodBeat.i(211732);
    Object localObject = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
    boolean bool = he((Context)localObject);
    localObject = MultiProcessMMKV.getMMKV("wx_ime");
    if (localObject != null)
    {
      bool = ((MultiProcessMMKV)localObject).getBoolean("ime_is_default", bool);
      AppMethodBeat.o(211732);
      return bool;
    }
    AppMethodBeat.o(211732);
    return bool;
  }
  
  public static String eHt()
  {
    AppMethodBeat.i(211740);
    Object localObject = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
    localObject = Settings.Secure.getString(((Context)localObject).getContentResolver(), "default_input_method");
    AppMethodBeat.o(211740);
    return localObject;
  }
  
  public static long eHu()
  {
    int i = 0;
    AppMethodBeat.i(211742);
    Object localObject2;
    Object localObject3;
    long l;
    try
    {
      Object localObject1 = new BufferedReader((Reader)new FileReader("/proc/meminfo"), 8192);
      localObject2 = ((BufferedReader)localObject1).readLine();
      kotlin.g.b.p.j(localObject2, "localBufferedReader.readLine()");
      localObject3 = (CharSequence)localObject2;
      localObject3 = ((Collection)new kotlin.n.k("\\s+").u((CharSequence)localObject3, 0)).toArray(new String[0]);
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(211742);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException1)
    {
      l = 0L;
    }
    for (;;)
    {
      Log.e("WxIme.WxImeUtil", "getTotalMemory " + localException1.getMessage());
      for (;;)
      {
        AppMethodBeat.o(211742);
        return l;
        localObject3 = (String[])localObject3;
        int j = localObject3.length;
        while (i < j)
        {
          String str = localObject3[i];
          Log.i((String)localObject2, str + "\t");
          i += 1;
        }
        localObject2 = Integer.valueOf(localObject3[1]);
        kotlin.g.b.p.j(localObject2, "Integer.valueOf(arrayOfString[1])");
        i = ((Integer)localObject2).intValue();
        l = i * 1024L;
        try
        {
          localException1.close();
        }
        catch (Exception localException2) {}
      }
    }
  }
  
  public static void eHv()
  {
    AppMethodBeat.i(211743);
    int i = com.tencent.mm.app.g.gL(MMApplicationContext.getApplicationId() + f.Duh);
    Log.e("WxIme.WxImeUtil", "killImeProcess() pid = %s, stack[%s]", new Object[] { Integer.valueOf(i), Util.getStack() });
    Log.w("WxIme.WxImeUtil", "killProcess pid:".concat(String.valueOf(i)));
    try
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/hld/utils/WxImeUtil", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/hld/utils/WxImeUtil", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(211743);
      return;
    }
    catch (Exception localException)
    {
      Log.e("WxIme.WxImeUtil", "killProcess %s, %s %s", new Object[] { Integer.valueOf(i), localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(211743);
    }
  }
  
  public static boolean eHw()
  {
    AppMethodBeat.i(211745);
    if ((float)Util.getDataAvailableSize() < 62914560.0F)
    {
      AppMethodBeat.o(211745);
      return false;
    }
    AppMethodBeat.o(211745);
    return true;
  }
  
  public static long eHx()
  {
    AppMethodBeat.i(211747);
    Object localObject1 = new ActivityManager.MemoryInfo();
    Object localObject2 = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(211747);
      throw ((Throwable)localObject1);
    }
    ((ActivityManager)localObject2).getMemoryInfo((ActivityManager.MemoryInfo)localObject1);
    long l = ((ActivityManager.MemoryInfo)localObject1).totalMem;
    AppMethodBeat.o(211747);
    return l;
  }
  
  public static long eHy()
  {
    AppMethodBeat.i(211748);
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockCountLong();
    long l2 = localStatFs.getBlockSizeLong();
    AppMethodBeat.o(211748);
    return l2 * l1;
  }
  
  /* Error */
  public static String eHz()
  {
    // Byte code:
    //   0: ldc_w 944
    //   3: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 187	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: getstatic 949	android/os/Build:SUPPORTED_ABIS	[Ljava/lang/String;
    //   18: astore 5
    //   20: aload 5
    //   22: arraylength
    //   23: istore_2
    //   24: iconst_0
    //   25: istore_0
    //   26: aload 4
    //   28: astore_3
    //   29: iload_0
    //   30: iload_2
    //   31: if_icmpge +64 -> 95
    //   34: aload 5
    //   36: iload_0
    //   37: aaload
    //   38: astore_3
    //   39: aload 4
    //   41: checkcast 784	java/lang/CharSequence
    //   44: invokeinterface 952 1 0
    //   49: ifne +32 -> 81
    //   52: iconst_1
    //   53: istore_1
    //   54: iload_1
    //   55: ifne +12 -> 67
    //   58: aload 4
    //   60: ldc_w 954
    //   63: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 4
    //   69: aload_3
    //   70: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: iload_0
    //   75: iconst_1
    //   76: iadd
    //   77: istore_0
    //   78: goto -52 -> 26
    //   81: iconst_0
    //   82: istore_1
    //   83: goto -29 -> 54
    //   86: astore_3
    //   87: new 187	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   94: astore_3
    //   95: aload_3
    //   96: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore_3
    //   100: aload_3
    //   101: ldc_w 956
    //   104: invokestatic 257	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   107: ldc_w 944
    //   110: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_3
    //   114: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   25	53	0	i	int
    //   53	30	1	j	int
    //   23	9	2	k	int
    //   28	42	3	localObject1	Object
    //   86	1	3	localException	Exception
    //   94	20	3	localObject2	Object
    //   13	55	4	localStringBuilder	StringBuilder
    //   18	17	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   15	24	86	java/lang/Exception
    //   39	52	86	java/lang/Exception
    //   58	67	86	java/lang/Exception
    //   67	74	86	java/lang/Exception
  }
  
  public static boolean f(ImeKeyRelativeLayout paramImeKeyRelativeLayout)
  {
    AppMethodBeat.i(211694);
    kotlin.g.b.p.k(paramImeKeyRelativeLayout, "view");
    if (((paramImeKeyRelativeLayout.getType() & 0x2) == 2) && (paramImeKeyRelativeLayout.getFunctionCode() == 2))
    {
      AppMethodBeat.o(211694);
      return true;
    }
    AppMethodBeat.o(211694);
    return false;
  }
  
  public static void gH(Context paramContext)
  {
    AppMethodBeat.i(211697);
    kotlin.g.b.p.k(paramContext, "context");
    Object localObject = MultiProcessMMKV.getMMKV("wx_ime");
    if (localObject != null) {}
    for (long l = ((MultiProcessMMKV)localObject).getLong("ime_enable_time", 0L);; l = 0L)
    {
      Log.i("WxIme.WxImeUtil", "enableIme " + Util.getStack() + " enableTime:" + l);
      localObject = com.tencent.mm.plugin.hld.model.k.DDb;
      com.tencent.mm.plugin.hld.model.k.UB(6);
      paramContext.getPackageManager().setComponentEnabledSetting(new ComponentName(paramContext, "com.tencent.mm.plugin.hld.WxHldService"), 1, 1);
      if (l == 0L)
      {
        l = cm.bfG();
        paramContext = MultiProcessMMKV.getMMKV("wx_ime");
        if (paramContext != null) {
          paramContext.putLong("ime_enable_time", l);
        }
        Log.i("WxIme.WxImeUtil", "enableIme ".concat(String.valueOf(l)));
      }
      AppMethodBeat.o(211697);
      return;
    }
  }
  
  public static boolean gJ(Context paramContext)
  {
    AppMethodBeat.i(211700);
    kotlin.g.b.p.k(paramContext, "context");
    if (paramContext.getPackageManager().getComponentEnabledSetting(new ComponentName(paramContext, Class.forName("com.tencent.mm.plugin.hld.WxHldService"))) == 1)
    {
      AppMethodBeat.o(211700);
      return true;
    }
    AppMethodBeat.o(211700);
    return false;
  }
  
  public static boolean gK(Context paramContext)
  {
    AppMethodBeat.i(211699);
    kotlin.g.b.p.k(paramContext, "context");
    if (!gJ(paramContext))
    {
      AppMethodBeat.o(211699);
      return false;
    }
    paramContext = MultiProcessMMKV.getMMKV("wx_ime");
    if (paramContext != null) {}
    for (long l1 = paramContext.getLong("ime_enable_time", 0L);; l1 = 0L)
    {
      long l2 = cm.bfG();
      if (l1 == 0L)
      {
        paramContext = MultiProcessMMKV.getMMKV("wx_ime");
        if (paramContext != null) {
          paramContext.putLong("ime_enable_time", l2);
        }
        Log.i("WxIme.WxImeUtil", "isInImeList ".concat(String.valueOf(l2)));
      }
      if ((l1 == 0L) || (l2 - l1 <= 60000L)) {
        break;
      }
      AppMethodBeat.o(211699);
      return true;
    }
    boolean bool = eCH();
    AppMethodBeat.o(211699);
    return bool;
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(292898);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime");
    AppMethodBeat.o(292898);
    return localMultiProcessMMKV;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    AppMethodBeat.i(211686);
    kotlin.g.b.p.k(paramContext, "context");
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    AppMethodBeat.o(211686);
    return i;
  }
  
  public static void ha(Context paramContext)
  {
    AppMethodBeat.i(211687);
    kotlin.g.b.p.k(paramContext, "context");
    w.makeText(paramContext, a.j.wxime_no_support_function, 0).show();
    AppMethodBeat.o(211687);
  }
  
  public static void hb(Context paramContext)
  {
    AppMethodBeat.i(211688);
    kotlin.g.b.p.k(paramContext, "context");
    if (System.currentTimeMillis() - DHJ > 2000L)
    {
      Object localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject == null) {
        break label86;
      }
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
      if (localObject == null) {
        break label86;
      }
      if (((com.tencent.mm.plugin.hld.a.b)localObject).eCq() == true)
      {
        DHJ = System.currentTimeMillis();
        w.makeText(paramContext, a.j.wxime_engine_no_init_finish, 0).show();
      }
    }
    AppMethodBeat.o(211688);
    return;
    label86:
    AppMethodBeat.o(211688);
  }
  
  public static void hc(Context paramContext)
  {
    AppMethodBeat.i(211696);
    kotlin.g.b.p.k(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.hld.model.p.DEH;
    if (com.tencent.mm.plugin.hld.model.p.eFn())
    {
      localObject = new Intent(paramContext, Class.forName("com.tencent.mm.hld.ContactInfoUI"));
      ((Intent)localObject).setFlags(335544320);
      ((Intent)localObject).putExtra("ime_auto_open_choose_list", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/hld/utils/WxImeUtil", "goToContactInfoUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/hld/utils/WxImeUtil", "goToContactInfoUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(211696);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.plugin.hld.ui.WelabHldInfoUI");
    ((Intent)localObject).setFlags(335544320);
    ((Intent)localObject).putExtra("ime_auto_open_choose_list", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/hld/utils/WxImeUtil", "goToContactInfoUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/hld/utils/WxImeUtil", "goToContactInfoUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(211696);
  }
  
  public static void hd(Context paramContext)
  {
    AppMethodBeat.i(211698);
    kotlin.g.b.p.k(paramContext, "context");
    Log.i("WxIme.WxImeUtil", "disabledIme " + Util.getStack());
    paramContext.getPackageManager().setComponentEnabledSetting(new ComponentName(paramContext, "com.tencent.mm.plugin.hld.WxHldService"), 2, 1);
    AppMethodBeat.o(211698);
  }
  
  public static boolean he(Context paramContext)
  {
    AppMethodBeat.i(211701);
    kotlin.g.b.p.k(paramContext, "context");
    boolean bool1 = hh(paramContext);
    boolean bool2 = hi(paramContext);
    AppMethodBeat.o(211701);
    return bool1 & bool2;
  }
  
  public static boolean hf(Context paramContext)
  {
    AppMethodBeat.i(211702);
    kotlin.g.b.p.k(paramContext, "context");
    if ((eHk()) && (eHn()) && ((hh(paramContext) & hi(paramContext))) && (eHq()))
    {
      AppMethodBeat.o(211702);
      return true;
    }
    AppMethodBeat.o(211702);
    return false;
  }
  
  public static void hg(Context paramContext)
  {
    AppMethodBeat.i(211734);
    kotlin.g.b.p.k(paramContext, "context");
    Log.i("WxIme.WxImeUtil", "switchToDefaultIme close:true");
    paramContext = new Intent(paramContext, WxImeInterService.class);
    paramContext.putExtra("ime_switch_ime_to_default", true);
    paramContext.putExtra("ime_close_wxime", true);
    com.tencent.mm.by.c.l(paramContext, "hld");
    AppMethodBeat.o(211734);
  }
  
  @SuppressLint({"NewApi"})
  public static boolean hh(Context paramContext)
  {
    AppMethodBeat.i(211736);
    kotlin.g.b.p.k(paramContext, "context");
    paramContext = paramContext.getSystemService("input_method");
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(211736);
      throw paramContext;
    }
    paramContext = ((InputMethodManager)paramContext).getEnabledInputMethodList().iterator();
    while (paramContext.hasNext())
    {
      Object localObject1 = (InputMethodInfo)paramContext.next();
      Object localObject2 = new StringBuilder("checking ");
      kotlin.g.b.p.j(localObject1, "imi");
      Log.d("WxIme.WxImeUtil", ((InputMethodInfo)localObject1).getId());
      localObject2 = ((InputMethodInfo)localObject1).getId();
      com.tencent.mm.plugin.hld.model.p localp = com.tencent.mm.plugin.hld.model.p.DEH;
      if (!kotlin.g.b.p.h(localObject2, com.tencent.mm.plugin.hld.model.p.eFo()))
      {
        localObject1 = ((InputMethodInfo)localObject1).getId();
        localObject2 = com.tencent.mm.plugin.hld.model.p.DEH;
        if (!kotlin.g.b.p.h(localObject1, com.tencent.mm.plugin.hld.model.p.eFp())) {
          break;
        }
      }
      else
      {
        AppMethodBeat.o(211736);
        return true;
      }
    }
    AppMethodBeat.o(211736);
    return false;
  }
  
  public static boolean hi(Context paramContext)
  {
    AppMethodBeat.i(211739);
    kotlin.g.b.p.k(paramContext, "context");
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "default_input_method");
    Log.d("WxIme.WxImeUtil", "isImeCurActive ime = ".concat(String.valueOf(paramContext)));
    com.tencent.mm.plugin.hld.model.p localp = com.tencent.mm.plugin.hld.model.p.DEH;
    if (!kotlin.g.b.p.h(com.tencent.mm.plugin.hld.model.p.eFo(), paramContext))
    {
      localp = com.tencent.mm.plugin.hld.model.p.DEH;
      if (!kotlin.g.b.p.h(com.tencent.mm.plugin.hld.model.p.eFp(), paramContext)) {}
    }
    else
    {
      AppMethodBeat.o(211739);
      return true;
    }
    AppMethodBeat.o(211739);
    return false;
  }
  
  public static void it(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211763);
    kotlin.g.b.p.k(paramString1, "tag");
    kotlin.g.b.p.k(paramString2, "content");
    e locale = e.DGW;
    if (e.eGl()) {
      try
      {
        Log.i(paramString1, String.valueOf(paramString2));
        AppMethodBeat.o(211763);
        return;
      }
      catch (Exception paramString1)
      {
        Log.e("WxIme.WxImeUtil", "printUserClickData " + paramString1.getMessage());
      }
    }
    AppMethodBeat.o(211763);
  }
  
  public static boolean j(clh paramclh)
  {
    AppMethodBeat.i(211715);
    kotlin.g.b.p.k(paramclh, "dict");
    if (u.agG(paramclh.path))
    {
      if (Util.isEqual(u.buc(paramclh.path), paramclh.md5))
      {
        AppMethodBeat.o(211715);
        return true;
      }
      u.deleteFile(paramclh.path);
      Log.e("WxIme.WxImeUtil", "checkDictValid " + paramclh.path + " md5(" + paramclh.md5 + ") no equeal");
    }
    for (;;)
    {
      AppMethodBeat.o(211715);
      return false;
      Log.e("WxIme.WxImeUtil", "checkDictValid " + paramclh.path + " no exist");
    }
  }
  
  public static String k(clh paramclh)
  {
    AppMethodBeat.i(211772);
    kotlin.g.b.p.k(paramclh, "dict");
    paramclh = paramclh.path + ' ' + paramclh.TsM + ' ' + paramclh.lZN + ' ' + paramclh.dataType + ' ' + paramclh.md5;
    AppMethodBeat.o(211772);
    return paramclh;
  }
  
  private static String tf(boolean paramBoolean)
  {
    AppMethodBeat.i(211682);
    String str2 = eGV();
    if (paramBoolean) {}
    for (String str1 = "/imgcachelandscape";; str1 = "/imgcache")
    {
      str1 = kotlin.g.b.p.I(str2, str1);
      if (!u.agG(str1)) {
        u.bBD(str1);
      }
      AppMethodBeat.o(211682);
      return str1;
    }
  }
  
  public static void tg(boolean paramBoolean)
  {
    AppMethodBeat.i(211733);
    Object localObject = MultiProcessMMKV.getMMKV("wx_ime");
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("ime_is_default", paramBoolean);
    }
    localObject = com.tencent.mm.plugin.hld.b.e.Dvq;
    if (paramBoolean) {}
    for (localObject = com.tencent.mm.plugin.hld.model.b.DBk;; localObject = com.tencent.mm.plugin.hld.model.b.DBl)
    {
      e.a.a((com.tencent.mm.plugin.hld.model.b)localObject, 0L, null, 6);
      AppMethodBeat.o(211733);
      return;
    }
  }
  
  public final String aG(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(211685);
    String str = tf(paramBoolean) + '/' + paramInt + ".png";
    AppMethodBeat.o(211685);
    return str;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a DHL;
    
    static
    {
      AppMethodBeat.i(209784);
      DHL = new a();
      AppMethodBeat.o(209784);
    }
    
    public final void run()
    {
      AppMethodBeat.i(209783);
      Log.i("WxIme.WxImeUtil", "checkInInputMethodList start");
      int i = 0;
      long l3 = System.currentTimeMillis();
      long l1 = 0L;
      long l2 = l1;
      if (i == 0)
      {
        l2 = l1;
        try
        {
          Object localObject1 = MMApplicationContext.getContext().getSystemService("input_method");
          if (localObject1 != null) {
            break label135;
          }
          l2 = l1;
          localObject1 = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
          l2 = l1;
          AppMethodBeat.o(209783);
          l2 = l1;
          throw ((Throwable)localObject1);
        }
        catch (Exception localException)
        {
          Log.e("WxIme.WxImeUtil", "checkInInputMethodList " + localException.getMessage());
        }
      }
      else
      {
        localObject2 = MMApplicationContext.getContext().getSystemService("input_method");
        if (localObject2 != null) {
          break label371;
        }
        localObject2 = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(209783);
        throw ((Throwable)localObject2);
      }
      label135:
      l2 = l1;
      Object localObject2 = ((InputMethodManager)localObject2).getInputMethodList().iterator();
      for (;;)
      {
        l2 = l1;
        InputMethodInfo localInputMethodInfo;
        Object localObject3;
        if (((Iterator)localObject2).hasNext())
        {
          l2 = l1;
          localInputMethodInfo = (InputMethodInfo)((Iterator)localObject2).next();
          l2 = l1;
          localObject3 = new StringBuilder("startCheckInInputMethodList ");
          l2 = l1;
          kotlin.g.b.p.j(localInputMethodInfo, "imi");
          l2 = l1;
          Log.d("WxIme.WxImeUtil", localInputMethodInfo.getId());
          l2 = l1;
          localObject3 = localInputMethodInfo.getId();
          l2 = l1;
          com.tencent.mm.plugin.hld.model.p localp = com.tencent.mm.plugin.hld.model.p.DEH;
          l2 = l1;
          if (!kotlin.g.b.p.h(localObject3, com.tencent.mm.plugin.hld.model.p.eFo()))
          {
            l2 = l1;
            localObject3 = localInputMethodInfo.getId();
            l2 = l1;
            localp = com.tencent.mm.plugin.hld.model.p.DEH;
            l2 = l1;
            if (!kotlin.g.b.p.h(localObject3, com.tencent.mm.plugin.hld.model.p.eFp())) {}
          }
          else
          {
            l2 = l1;
            Log.i("WxIme.WxImeUtil", "startCheckInInputMethodList exist:" + localInputMethodInfo.getId());
            l2 = l1;
            l1 = System.currentTimeMillis() - l3;
            i = 1;
          }
        }
        else
        {
          l2 = l1;
          Thread.sleep(50L);
          l2 = l1;
          long l4 = System.currentTimeMillis();
          if (l4 - l3 <= 60000L) {
            break;
          }
          l1 = 60000L;
          i = 1;
          break;
          label371:
          localObject2 = ((InputMethodManager)localObject2).getInputMethodList().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localInputMethodInfo = (InputMethodInfo)((Iterator)localObject2).next();
            localObject3 = new StringBuilder("startCheckInInputMethodList: ");
            kotlin.g.b.p.j(localInputMethodInfo, "imi");
            Log.i("WxIme.WxImeUtil", localInputMethodInfo.getId());
          }
          Log.i("WxIme.WxImeUtil", "startCheckInInputMethodList time:".concat(String.valueOf(l2)));
          localObject2 = com.tencent.mm.plugin.hld.model.k.DDb;
          com.tencent.mm.plugin.hld.model.k.d(3, (int)l2, null, 8);
          com.tencent.e.h.ZvG.be((Runnable)1.DHM);
          AppMethodBeat.o(209783);
          return;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b DHN;
    
    static
    {
      AppMethodBeat.i(211482);
      DHN = new b();
      AppMethodBeat.o(211482);
    }
    
    public final void run()
    {
      AppMethodBeat.i(211481);
      l locall = l.DHK;
      l.eHe();
      AppMethodBeat.o(211481);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
  static final class c<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d<IPCVoid, IPCVoid>
  {
    public static final c DHO;
    
    static
    {
      AppMethodBeat.i(216623);
      DHO = new c();
      AppMethodBeat.o(216623);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.l
 * JD-Core Version:    0.7.0.1
 */