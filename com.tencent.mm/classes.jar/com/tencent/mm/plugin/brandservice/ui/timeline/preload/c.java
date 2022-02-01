package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.euj;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"domainHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getDomainHashMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setDomainHashMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "fullUrlHashCache", "getFullUrlHashCache", "setFullUrlHashCache", "urlHashCache", "getUrlHashCache", "setUrlHashCache", "host", "getHost", "(Ljava/lang/String;)Ljava/lang/String;", "path", "getPath", "clearDomain", "", "domain", "clearDomainCache", "getContentId", "url", "getDomainId", "fetch", "", "getFullInfoId", "getFullWebId", "prefetch", "getInfoId", "getInvalidId", "getShortUrlId", "getStrip", "", "openScene", "getUrlId", "getWebId", "getWebResId", "resUrl", "hashFullUrl", "hashUrl", "mpDataMmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setShortUrlId", "shortUrl", "longUrl", "contains", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "contentId", "create", "Lcom/tencent/mm/vfs/VFSFile;", "findContentFile", "getContentFile", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "getContentPath", "plugin-brandservice_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  private static ConcurrentHashMap<String, String> vQr;
  private static ConcurrentHashMap<String, String> vQs;
  private static ConcurrentHashMap<String, ConcurrentLinkedDeque<String>> vQt;
  
  static
  {
    AppMethodBeat.i(6575);
    vQr = new ConcurrentHashMap();
    vQs = new ConcurrentHashMap();
    vQt = new ConcurrentHashMap();
    AppMethodBeat.o(6575);
  }
  
  public static final int Ht(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(6571);
    Object localObject1 = q.dfF().decodeBytes("_msg_scene_strip");
    int i;
    if (localObject1 != null) {
      if (localObject1.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label162;
        }
        i = 1;
        label34:
        if (i != 1) {
          break label167;
        }
        i = j;
      }
    }
    label162:
    label167:
    for (;;)
    {
      label41:
      if (i != 0)
      {
        Object localObject2 = new euk();
        ((euk)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((euk)localObject2).YMN;
        s.s(localObject1, "SceneControlSets().apply…(buff) }.SceneControlList");
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (euj)((Iterator)localObject1).next();
            if (((euj)localObject2).IJG == paramInt)
            {
              if (((euj)localObject2).abxl <= 0)
              {
                Log.e("MicroMsg.AppMsgContextEx", "strip error " + paramInt + ':' + ((euj)localObject2).abxl);
                continue;
                i = 0;
                break;
                i = 0;
                break label34;
                i = 0;
                break label41;
              }
              Log.i("MicroMsg.AppMsgContextEx", "strip " + paramInt + ':' + ((euj)localObject2).abxl);
              paramInt = ((euj)localObject2).abxl;
              AppMethodBeat.o(6571);
              return paramInt;
            }
          }
        }
      }
    }
    AppMethodBeat.o(6571);
    return 10;
  }
  
  public static final u I(u paramu)
  {
    AppMethodBeat.i(175480);
    s.u(paramu, "<this>");
    if (!paramu.jKS())
    {
      String str = paramu.jKO();
      s.checkNotNull(str);
      new u(str).jKY();
      paramu.jKZ();
    }
    AppMethodBeat.o(175480);
    return paramu;
  }
  
  public static final u a(MMFileSlotManager paramMMFileSlotManager, String paramString)
  {
    AppMethodBeat.i(175483);
    s.u(paramMMFileSlotManager, "<this>");
    s.u(paramString, "contentId");
    paramMMFileSlotManager = f((u)paramMMFileSlotManager.getSlotForWrite(), paramString);
    AppMethodBeat.o(175483);
    return paramMMFileSlotManager;
  }
  
  public static final String a(gb paramgb)
  {
    AppMethodBeat.i(6570);
    s.u(paramgb, "<this>");
    paramgb = paramgb.Url;
    s.s(paramgb, "this.Url");
    paramgb = ajo(paramgb);
    AppMethodBeat.o(6570);
    return paramgb;
  }
  
  private static final String aW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(303243);
    String str1 = paramString + '-' + paramBoolean;
    Object localObject2;
    for (;;)
    {
      int i;
      String str2;
      String str3;
      try
      {
        if (vQs.containsKey(str1))
        {
          paramString = ak.e((Map)vQs, str1);
          localObject1 = (String)paramString;
          if (BuildInfo.DEBUG) {
            Log.v("AppMsgContextEx", "hashFullUrl cacheKey: %s, value: %s", new Object[] { str1, localObject1 });
          }
          paramString = (String)paramString;
          return paramString;
        }
        localObject1 = kotlin.ah.aiuX;
        localObject1 = ajm(getHost(paramString));
        localObject2 = new StringBuilder("matched_");
        i = 0;
        if (i >= 3) {
          break;
        }
        str2 = new String[] { "__biz", "mid", "idx" }[i];
        str3 = UrlExKt.getUrlParam(paramString, str2);
        if (str3 != null) {
          break label396;
        }
        localObject2 = UrlExKt.clearShortUrl(paramString, true);
        str2 = ajq((String)localObject2);
        if (!Util.isNullOrNil(str2))
        {
          ((Map)vQs).put(paramString, str2);
          AppMethodBeat.o(303243);
          return str2;
        }
      }
      finally
      {
        AppMethodBeat.o(303243);
      }
      localObject2 = Integer.toString(s.X("not_matched_", Integer.valueOf(b((String)localObject2, paramBoolean, paramString))).hashCode(), kotlin.n.a.aMy(16));
      s.s(localObject2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
      if (paramBoolean)
      {
        if (!vQt.containsKey(localObject1)) {
          ((Map)vQt).put(localObject1, new ConcurrentLinkedDeque());
        }
        localObject1 = vQt.get(localObject1);
        s.checkNotNull(localObject1);
        ((ConcurrentLinkedDeque)localObject1).add(str1);
        ((Map)vQs).put(str1, localObject2);
        Log.d("AppMsgContextEx", "#" + (String)localObject2 + " hash from:%s", new Object[] { paramString });
      }
      AppMethodBeat.o(303243);
      return localObject2;
      label396:
      ((StringBuilder)localObject2).append(str2 + ':' + str3 + '-');
      i += 1;
    }
    paramString = ((StringBuilder)localObject2).toString();
    s.s(paramString, "key.toString()");
    if (!vQt.containsKey(localObject1)) {
      ((Map)vQt).put(localObject1, new ConcurrentLinkedDeque());
    }
    Object localObject1 = vQt.get(localObject1);
    s.checkNotNull(localObject1);
    ((ConcurrentLinkedDeque)localObject1).add(str1);
    ((Map)vQs).put(str1, paramString);
    AppMethodBeat.o(303243);
    return paramString;
  }
  
  public static final String aX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(303276);
    s.u(paramString, "url");
    paramString = s.X("_web_", aW(paramString, paramBoolean));
    AppMethodBeat.o(303276);
    return paramString;
  }
  
  public static final void ajg(String paramString)
  {
    AppMethodBeat.i(303223);
    s.u(paramString, "domain");
    String str1 = ajm(paramString);
    LinkedList localLinkedList = new LinkedList();
    try
    {
      Object localObject = (ConcurrentLinkedDeque)vQt.get(str1);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          String str3 = (String)vQr.remove(str2);
          if (str3 != null) {
            localLinkedList.add(str3);
          }
          str2 = (String)vQs.remove(str2);
          if (str2 != null) {
            localLinkedList.add(str2);
          }
        }
        localObject = kotlin.ah.aiuX;
      }
    }
    finally
    {
      AppMethodBeat.o(303223);
    }
    Log.i("AppMsgContextEx", "clearDomain:" + paramString + '#' + str1 + ", [" + p.a((Iterable)localLinkedList, (CharSequence)",", null, null, 0, null, null, 62) + ']');
    AppMethodBeat.o(303223);
  }
  
  public static final void ajh(String paramString)
  {
    try
    {
      AppMethodBeat.i(6557);
      s.u(paramString, "domain");
      String str = MainProcessIPCService.PROCESS_NAME;
      s.s(str, "PROCESS_NAME");
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)new IPCString(paramString), c..ExternalSyntheticLambda0.INSTANCE);
      str = ToolsProcessIPCService.PROCESS_NAME;
      s.s(str, "PROCESS_NAME");
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)new IPCString(paramString), c..ExternalSyntheticLambda1.INSTANCE);
      AppMethodBeat.o(6557);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static final String aji(String paramString)
  {
    AppMethodBeat.i(303250);
    paramString = UrlExKt.clearUrlParams(n.rt(paramString, "#"), new String[] { "from", "isappinstalled", "pass_ticket", "exportKey" });
    String str1 = paramString + '-' + false;
    StringBuilder localStringBuilder;
    for (;;)
    {
      int i;
      String str2;
      String str3;
      try
      {
        if (vQr.containsKey(str1))
        {
          paramString = (String)ak.e((Map)vQr, str1);
          return paramString;
        }
        localObject = kotlin.ah.aiuX;
        localObject = ajm(getHost(paramString));
        localStringBuilder = new StringBuilder("matched_");
        i = 0;
        if (i >= 3) {
          break;
        }
        str2 = new String[] { "__biz", "mid", "idx" }[i];
        str3 = UrlExKt.getUrlParam(paramString, str2);
        if (str3 != null) {
          break label280;
        }
        str1 = UrlExKt.clearShortUrl$default(paramString, false, 2, null);
        localObject = ajq(str1);
        if (!Util.isNullOrNil((String)localObject))
        {
          ((Map)vQr).put(paramString, localObject);
          AppMethodBeat.o(303250);
          return localObject;
        }
      }
      finally
      {
        AppMethodBeat.o(303250);
      }
      paramString = Integer.toString(s.X("not_matched_", Integer.valueOf(c(str1, false, paramString))).hashCode(), kotlin.n.a.aMy(16));
      s.s(paramString, "java.lang.Integer.toStri…(this, checkRadix(radix))");
      AppMethodBeat.o(303250);
      return paramString;
      label280:
      localStringBuilder.append(str2 + ':' + str3 + '-');
      i += 1;
    }
    paramString = localStringBuilder.toString();
    s.s(paramString, "key.toString()");
    if (!vQt.containsKey(localObject)) {
      ((Map)vQt).put(localObject, new ConcurrentLinkedDeque());
    }
    Object localObject = vQt.get(localObject);
    s.checkNotNull(localObject);
    ((ConcurrentLinkedDeque)localObject).add(str1);
    ((Map)vQr).put(str1, paramString);
    AppMethodBeat.o(303250);
    return paramString;
  }
  
  public static final String ajj(String paramString)
  {
    AppMethodBeat.i(303256);
    s.u(paramString, "url");
    paramString = s.X("_info_", aW(paramString, false));
    AppMethodBeat.o(303256);
    return paramString;
  }
  
  public static final String ajk(String paramString)
  {
    AppMethodBeat.i(6560);
    s.u(paramString, "url");
    paramString = s.X("_info_", aji(paramString));
    AppMethodBeat.o(6560);
    return paramString;
  }
  
  private static String ajm(String paramString)
  {
    AppMethodBeat.i(303300);
    s.u(paramString, "domain");
    paramString = "_domain_" + paramString.hashCode();
    AppMethodBeat.o(303300);
    return paramString;
  }
  
  public static final String ajo(String paramString)
  {
    AppMethodBeat.i(6568);
    s.u(paramString, "url");
    paramString = s.X("_content_", aji(paramString));
    AppMethodBeat.o(6568);
    return paramString;
  }
  
  public static final String ajp(String paramString)
  {
    AppMethodBeat.i(6569);
    s.u(paramString, "url");
    paramString = s.X("_invalid_", aji(paramString));
    AppMethodBeat.o(6569);
    return paramString;
  }
  
  private static String ajq(String paramString)
  {
    AppMethodBeat.i(303330);
    s.u(paramString, "url");
    paramString = deK().decodeString(s.X("short_url_", paramString), "");
    s.s(paramString, "mpDataMmkv().decodeString(\"short_url_$url\", \"\")");
    AppMethodBeat.o(303330);
    return paramString;
  }
  
  public static final String ajr(String paramString)
  {
    AppMethodBeat.i(6573);
    s.u(paramString, "url");
    paramString = aji(paramString);
    AppMethodBeat.o(6573);
    return paramString;
  }
  
  private static final int b(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(303357);
    for (;;)
    {
      try
      {
        localObject = Uri.parse(paramString1);
        if (!paramBoolean) {
          continue;
        }
        String str = ((Uri)localObject).getScheme();
        if ((str == null) || (com.tencent.luggage.l.c.a(str, "http", true) != true)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        localObject = WebPrefetcherManifest.vUW;
        localObject = WebPrefetcherManifest.ajG(paramString2);
        if (localObject != null) {
          continue;
        }
        i = paramString2.hashCode();
      }
      catch (Exception paramString2)
      {
        Object localObject;
        Log.printErrStackTrace("hashUrl", (Throwable)paramString2, "hash url %s", new Object[] { paramString1 });
        int i = 0;
        continue;
      }
      AppMethodBeat.o(303357);
      return i;
      i = 0;
      continue;
      localObject = WebPrefetcherManifest.vUW.a(paramString2, (com.tencent.mm.plugin.az.a)localObject);
      if (localObject != null)
      {
        paramString2 = (String)localObject;
        continue;
        paramString2 = ((Uri)localObject).toString();
        s.s(paramString2, "{\n                //data… toString()\n            }");
      }
    }
  }
  
  public static final u b(MMFileSlotManager paramMMFileSlotManager, String paramString)
  {
    AppMethodBeat.i(175484);
    s.u(paramMMFileSlotManager, "<this>");
    s.u(paramString, "contentId");
    paramMMFileSlotManager = (u)paramMMFileSlotManager.findSlot(paramString);
    if (paramMMFileSlotManager == null)
    {
      AppMethodBeat.o(175484);
      return null;
    }
    paramMMFileSlotManager = f(paramMMFileSlotManager, paramString);
    AppMethodBeat.o(175484);
    return paramMMFileSlotManager;
  }
  
  private static final int c(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(303366);
    try
    {
      paramString2 = Uri.parse(paramString1).toString();
      s.s(paramString2, "{\n                //data… toString()\n            }");
      i = paramString2.hashCode();
      AppMethodBeat.o(303366);
      return i;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        Log.printErrStackTrace("hashUrl", (Throwable)paramString2, "hash url %s", new Object[] { paramString1 });
        int i = 0;
      }
    }
  }
  
  public static final boolean c(MMFileSlotManager paramMMFileSlotManager, String paramString)
  {
    AppMethodBeat.i(6556);
    s.u(paramMMFileSlotManager, "<this>");
    s.u(paramString, "contentId");
    if (paramMMFileSlotManager.findSlot(paramString) != null)
    {
      AppMethodBeat.o(6556);
      return true;
    }
    AppMethodBeat.o(6556);
    return false;
  }
  
  public static final ConcurrentHashMap<String, String> deI()
  {
    return vQr;
  }
  
  public static final ConcurrentHashMap<String, ConcurrentLinkedDeque<String>> deJ()
  {
    return vQt;
  }
  
  private static MultiProcessMMKV deK()
  {
    AppMethodBeat.i(6572);
    if (MMApplicationContext.isMainProcess()) {
      h.baC();
    }
    for (int i = b.getUin();; i = b.aZP())
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(s.X("mpRelateData_", Integer.valueOf(i)), 2);
      s.s(localMultiProcessMMKV, "getMMKV(\"${BizConstants.…sMMKV.MULTI_PROCESS_MODE)");
      AppMethodBeat.o(6572);
      return localMultiProcessMMKV;
    }
  }
  
  private static final u f(u paramu, String paramString)
  {
    AppMethodBeat.i(175482);
    paramu = new u(com.tencent.mm.vfs.ah.v(paramu.mUri) + '/' + paramString);
    AppMethodBeat.o(175482);
    return paramu;
  }
  
  public static final String fO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6564);
    s.u(paramString1, "host");
    s.u(paramString2, "resUrl");
    paramString1 = paramString1 + "/_web_res_" + aji(paramString2);
    AppMethodBeat.o(6564);
    return paramString1;
  }
  
  public static final void fP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6574);
    s.u(paramString1, "shortUrl");
    s.u(paramString2, "longUrl");
    paramString1 = UrlExKt.clearShortUrl$default(paramString1, false, 2, null);
    paramString2 = ajr(paramString2);
    String str = s.X("short_url_", paramString1);
    deK().encode(str, paramString2);
    vQr.put(paramString1, paramString2);
    AppMethodBeat.o(6574);
  }
  
  public static final String getHost(String paramString)
  {
    AppMethodBeat.i(6561);
    s.u(paramString, "<this>");
    try
    {
      String str = Uri.parse(UrlExKt.getWithProtocol(paramString)).getHost();
      paramString = str;
      if (str == null) {
        paramString = "unknow";
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "unknow";
      }
    }
    AppMethodBeat.o(6561);
    return paramString;
  }
  
  public static final String getPath(String paramString)
  {
    AppMethodBeat.i(303269);
    s.u(paramString, "<this>");
    try
    {
      String str = Uri.parse(UrlExKt.getWithProtocol(paramString)).getPath();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "";
      }
    }
    AppMethodBeat.o(303269);
    return paramString;
  }
  
  private static final void l(IPCString paramIPCString, f paramf)
  {
    AppMethodBeat.i(303344);
    paramIPCString = paramIPCString.value;
    s.s(paramIPCString, "ipcDomain.value");
    ajg(paramIPCString);
    AppMethodBeat.o(303344);
  }
  
  private static final void m(IPCString paramIPCString, f paramf)
  {
    AppMethodBeat.i(303349);
    paramIPCString = paramIPCString.value;
    s.s(paramIPCString, "ipcDomain.value");
    ajg(paramIPCString);
    AppMethodBeat.o(303349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c
 * JD-Core Version:    0.7.0.1
 */