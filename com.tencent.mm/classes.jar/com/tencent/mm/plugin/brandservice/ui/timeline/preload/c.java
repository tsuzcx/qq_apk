package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dqz;
import com.tencent.mm.protocal.protobuf.dra;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"domainHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getDomainHashMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setDomainHashMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "fullUrlHashCache", "getFullUrlHashCache", "setFullUrlHashCache", "urlHashCache", "getUrlHashCache", "setUrlHashCache", "host", "getHost", "(Ljava/lang/String;)Ljava/lang/String;", "path", "getPath", "clearDomain", "", "domain", "clearDomainCache", "getContentId", "url", "getDomainId", "fetch", "", "getFullInfoId", "getFullWebId", "prefetch", "getInfoId", "getInvalidId", "getShortUrlId", "getStrip", "", "openScene", "getUrlId", "getWebId", "getWebResId", "resUrl", "hashFullUrl", "hashUrl", "mpDataMmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setShortUrlId", "shortUrl", "longUrl", "contains", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "contentId", "create", "Lcom/tencent/mm/vfs/VFSFile;", "findContentFile", "getContentFile", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "getContentPath", "plugin-brandservice_release"})
public final class c
{
  private static ConcurrentHashMap<String, String> pAn;
  private static ConcurrentHashMap<String, String> pAo;
  private static ConcurrentHashMap<String, ConcurrentLinkedDeque<String>> pAp;
  
  static
  {
    AppMethodBeat.i(6575);
    pAn = new ConcurrentHashMap();
    pAo = new ConcurrentHashMap();
    pAp = new ConcurrentHashMap();
    AppMethodBeat.o(6575);
  }
  
  public static final int Dm(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(6571);
    Object localObject1 = u.coo().decodeBytes("_msg_scene_strip");
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {}
      Object localObject2;
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          j = 1;
        }
        if (j != 1) {
          break label204;
        }
        localObject2 = new dra();
        ((dra)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((dra)localObject2).KOB;
        p.g(localObject1, "SceneControlSets().apply…(buff) }.SceneControlList");
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label204;
          }
          localObject2 = (dqz)((Iterator)localObject1).next();
          if (((dqz)localObject2).Scene == paramInt)
          {
            if (((dqz)localObject2).MTH > 0) {
              break;
            }
            Log.e("MicroMsg.AppMsgContextEx", "strip error " + paramInt + ':' + ((dqz)localObject2).MTH);
          }
        }
      }
      Log.i("MicroMsg.AppMsgContextEx", "strip " + paramInt + ':' + ((dqz)localObject2).MTH);
      paramInt = ((dqz)localObject2).MTH;
      AppMethodBeat.o(6571);
      return paramInt;
    }
    label204:
    AppMethodBeat.o(6571);
    return 10;
  }
  
  public static final o H(o paramo)
  {
    AppMethodBeat.i(175480);
    p.h(paramo, "$this$create");
    if (!paramo.exists())
    {
      String str = paramo.getParent();
      if (str == null) {
        p.hyc();
      }
      new o(str).mkdirs();
      paramo.createNewFile();
    }
    AppMethodBeat.o(175480);
    return paramo;
  }
  
  public static final o a(MMFileSlotManager paramMMFileSlotManager, String paramString)
  {
    AppMethodBeat.i(175483);
    p.h(paramMMFileSlotManager, "$this$getContentFile");
    p.h(paramString, "contentId");
    paramMMFileSlotManager = e((o)paramMMFileSlotManager.getSlot(), paramString);
    AppMethodBeat.o(175483);
    return paramMMFileSlotManager;
  }
  
  public static final String a(fn paramfn)
  {
    AppMethodBeat.i(6570);
    p.h(paramfn, "$this$getContentId");
    paramfn = paramfn.Url;
    p.g(paramfn, "this.Url");
    paramfn = aib(paramfn);
    AppMethodBeat.o(6570);
    return paramfn;
  }
  
  private static final String aI(final String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(195553);
    String str1 = paramString + '-' + paramBoolean;
    Object localObject3;
    for (;;)
    {
      String str2;
      String str3;
      try
      {
        if (pAo.containsKey(str1))
        {
          paramString = (String)ae.e((Map)pAo, str1);
          return paramString;
        }
        localObject1 = x.SXb;
        localObject1 = ahZ(getHost(paramString));
        localObject2 = new c(paramBoolean, paramString);
        localObject3 = new StringBuilder("matched_");
        if (i >= 3) {
          break;
        }
        str2 = new String[] { "__biz", "mid", "idx" }[i];
        str3 = UrlExKt.getUrlParam(paramString, str2);
        if (str3 != null) {
          break label370;
        }
        localObject3 = UrlExKt.clearShortUrl(paramString, true);
        str2 = aid((String)localObject3);
        if (!Util.isNullOrNil(str2))
        {
          ((Map)pAo).put(paramString, str2);
          AppMethodBeat.o(195553);
          return str2;
        }
      }
      finally
      {
        AppMethodBeat.o(195553);
      }
      Object localObject2 = Integer.toString("not_matched_".concat(String.valueOf(((c)localObject2).aif((String)localObject3))).hashCode(), kotlin.n.a.avR(16));
      p.g(localObject2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
      if (paramBoolean)
      {
        if (!pAp.containsKey(localObject1)) {
          ((Map)pAp).put(localObject1, new ConcurrentLinkedDeque());
        }
        localObject1 = pAp.get(localObject1);
        if (localObject1 == null) {
          p.hyc();
        }
        ((ConcurrentLinkedDeque)localObject1).add(str1);
        ((Map)pAo).put(str1, localObject2);
        Log.d("AppMsgContextEx", "#" + (String)localObject2 + " hash from:" + paramString);
      }
      AppMethodBeat.o(195553);
      return localObject2;
      label370:
      ((StringBuilder)localObject3).append(str2 + ':' + str3 + '-');
      i += 1;
    }
    paramString = ((StringBuilder)localObject3).toString();
    if (!pAp.containsKey(localObject1)) {
      ((Map)pAp).put(localObject1, new ConcurrentLinkedDeque());
    }
    Object localObject1 = pAp.get(localObject1);
    if (localObject1 == null) {
      p.hyc();
    }
    ((ConcurrentLinkedDeque)localObject1).add(str1);
    localObject1 = (Map)pAo;
    p.g(paramString, "this");
    ((Map)localObject1).put(str1, paramString);
    p.g(paramString, "key.toString()\n        .…acheKey] = this\n        }");
    AppMethodBeat.o(195553);
    return paramString;
  }
  
  public static final String aJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195558);
    p.h(paramString, "url");
    paramString = "_web_" + aI(paramString, paramBoolean);
    AppMethodBeat.o(195558);
    return paramString;
  }
  
  public static final void ahS(String paramString)
  {
    AppMethodBeat.i(195552);
    p.h(paramString, "domain");
    String str1 = ahZ(paramString);
    LinkedList localLinkedList = new LinkedList();
    try
    {
      Object localObject = (ConcurrentLinkedDeque)pAp.get(str1);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          String str3 = (String)pAn.remove(str2);
          if (str3 != null) {
            localLinkedList.add(str3);
          }
          str2 = (String)pAo.remove(str2);
          if (str2 != null) {
            localLinkedList.add(str2);
          }
        }
        localObject = x.SXb;
      }
    }
    finally
    {
      AppMethodBeat.o(195552);
    }
    Log.i("AppMsgContextEx", "clearDomain:" + paramString + '#' + str1 + ", [" + j.a((Iterable)localLinkedList, (CharSequence)",", null, null, 0, null, null, 62) + ']');
    AppMethodBeat.o(195552);
  }
  
  public static final void ahT(String paramString)
  {
    try
    {
      AppMethodBeat.i(6557);
      p.h(paramString, "domain");
      String str = MainProcessIPCService.dkO;
      p.g(str, "MainProcessIPCService.PROCESS_NAME");
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)a.pAq, null);
      str = ToolsProcessIPCService.dkO;
      p.g(str, "ToolsProcessIPCService.PROCESS_NAME");
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)b.pAr, null);
      AppMethodBeat.o(6557);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static final String ahW(String paramString)
  {
    AppMethodBeat.i(195556);
    p.h(paramString, "url");
    paramString = "_info_" + aI(paramString, false);
    AppMethodBeat.o(195556);
    return paramString;
  }
  
  public static final String ahX(String paramString)
  {
    AppMethodBeat.i(6560);
    p.h(paramString, "url");
    paramString = "_info_" + ahV(paramString);
    AppMethodBeat.o(6560);
    return paramString;
  }
  
  private static String ahZ(String paramString)
  {
    AppMethodBeat.i(195560);
    p.h(paramString, "domain");
    paramString = "_domain_" + paramString.hashCode();
    AppMethodBeat.o(195560);
    return paramString;
  }
  
  public static final String aib(String paramString)
  {
    AppMethodBeat.i(6568);
    p.h(paramString, "url");
    paramString = "_content_" + ahV(paramString);
    AppMethodBeat.o(6568);
    return paramString;
  }
  
  public static final String aic(String paramString)
  {
    AppMethodBeat.i(6569);
    p.h(paramString, "url");
    paramString = "_invalid_" + ahV(paramString);
    AppMethodBeat.o(6569);
    return paramString;
  }
  
  private static String aid(String paramString)
  {
    AppMethodBeat.i(195561);
    p.h(paramString, "url");
    paramString = cny().decodeString("short_url_".concat(String.valueOf(paramString)), "");
    p.g(paramString, "mpDataMmkv().decodeString(\"short_url_$url\", \"\")");
    AppMethodBeat.o(195561);
    return paramString;
  }
  
  public static final String aie(String paramString)
  {
    AppMethodBeat.i(6573);
    p.h(paramString, "url");
    paramString = ahV(paramString);
    AppMethodBeat.o(6573);
    return paramString;
  }
  
  public static final o b(MMFileSlotManager paramMMFileSlotManager, String paramString)
  {
    AppMethodBeat.i(175484);
    p.h(paramMMFileSlotManager, "$this$findContentFile");
    p.h(paramString, "contentId");
    paramMMFileSlotManager = (o)paramMMFileSlotManager.findSlot(paramString);
    if (paramMMFileSlotManager != null)
    {
      paramMMFileSlotManager = e(paramMMFileSlotManager, paramString);
      AppMethodBeat.o(175484);
      return paramMMFileSlotManager;
    }
    AppMethodBeat.o(175484);
    return null;
  }
  
  public static final boolean c(MMFileSlotManager paramMMFileSlotManager, String paramString)
  {
    AppMethodBeat.i(6556);
    p.h(paramMMFileSlotManager, "$this$contains");
    p.h(paramString, "contentId");
    if (paramMMFileSlotManager.findSlot(paramString) != null)
    {
      AppMethodBeat.o(6556);
      return true;
    }
    AppMethodBeat.o(6556);
    return false;
  }
  
  public static final ConcurrentHashMap<String, String> cnw()
  {
    return pAn;
  }
  
  public static final ConcurrentHashMap<String, ConcurrentLinkedDeque<String>> cnx()
  {
    return pAp;
  }
  
  private static MultiProcessMMKV cny()
  {
    AppMethodBeat.i(6572);
    if (MMApplicationContext.isMainProcess()) {
      p.g(g.aAf(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.azs())
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mpRelateData_".concat(String.valueOf(i)), 2);
      p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…sMMKV.MULTI_PROCESS_MODE)");
      AppMethodBeat.o(6572);
      return localMultiProcessMMKV;
    }
  }
  
  private static final o e(o paramo, String paramString)
  {
    AppMethodBeat.i(175482);
    paramo = new o(paramo.getPath() + '/' + paramString);
    AppMethodBeat.o(175482);
    return paramo;
  }
  
  public static final String ff(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6564);
    p.h(paramString1, "host");
    p.h(paramString2, "resUrl");
    paramString1 = paramString1 + "/_web_res_" + ahV(paramString2);
    AppMethodBeat.o(6564);
    return paramString1;
  }
  
  public static final void fg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6574);
    p.h(paramString1, "shortUrl");
    p.h(paramString2, "longUrl");
    paramString1 = UrlExKt.clearShortUrl$default(paramString1, false, 2, null);
    paramString2 = aie(paramString2);
    String str = "short_url_".concat(String.valueOf(paramString1));
    cny().encode(str, paramString2);
    pAn.put(paramString1, paramString2);
    AppMethodBeat.o(6574);
  }
  
  public static final String getHost(String paramString)
  {
    AppMethodBeat.i(6561);
    p.h(paramString, "$this$host");
    try
    {
      paramString = Uri.parse(UrlExKt.getWithProtocol(paramString));
      p.g(paramString, "Uri.parse(this.withProtocol)");
      String str = paramString.getHost();
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
    AppMethodBeat.i(195557);
    p.h(paramString, "$this$path");
    try
    {
      paramString = Uri.parse(UrlExKt.getWithProtocol(paramString));
      p.g(paramString, "Uri.parse(this.withProtocol)");
      String str = paramString.getPath();
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
    AppMethodBeat.o(195557);
    return paramString;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ipcDomain", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final a pAq;
    
    static
    {
      AppMethodBeat.i(195545);
      pAq = new a();
      AppMethodBeat.o(195545);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ipcDomain", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final b pAr;
    
    static
    {
      AppMethodBeat.i(195547);
      pAr = new b();
      AppMethodBeat.o(195547);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"toHash", "", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<String, Integer>
  {
    c(boolean paramBoolean, String paramString)
    {
      super();
    }
    
    public final int aif(String paramString)
    {
      AppMethodBeat.i(258333);
      p.h(paramString, "$this$toHash");
      for (;;)
      {
        try
        {
          localObject = Uri.parse(paramString);
          if (!this.pAs) {
            continue;
          }
          String str = ((Uri)localObject).getScheme();
          if ((str == null) || (com.tencent.luggage.h.c.a(str, "http", true) != true)) {
            continue;
          }
          localObject = y.pFf;
          localObject = y.aiu(paramString);
          if (localObject != null)
          {
            str = y.pFf.a(paramString, (com.tencent.mm.plugin.ad.a)localObject);
            localObject = str;
            if (str != null) {}
          }
          else
          {
            localObject = paramString;
          }
          i = ((String)localObject).hashCode();
        }
        catch (Exception localException)
        {
          Object localObject;
          Log.printErrStackTrace("hashUrl", (Throwable)localException, "hash url".concat(String.valueOf(paramString)), new Object[0]);
          int i = 0;
          continue;
        }
        AppMethodBeat.o(258333);
        return i;
        localObject = ((Uri)localObject).toString();
        p.g(localObject, "toString()");
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"toHash", "", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<String, Integer>
  {
    d(String paramString)
    {
      super();
    }
    
    public final int aif(String paramString)
    {
      AppMethodBeat.i(195551);
      p.h(paramString, "$this$toHash");
      for (;;)
      {
        try
        {
          localObject = Uri.parse(paramString);
          if (!this.pAs) {
            continue;
          }
          String str = ((Uri)localObject).getScheme();
          if ((str == null) || (com.tencent.luggage.h.c.a(str, "http", true) != true)) {
            continue;
          }
          localObject = y.pFf;
          localObject = y.aiu(this.mkH);
          if (localObject != null)
          {
            str = y.pFf.a(this.mkH, (com.tencent.mm.plugin.ad.a)localObject);
            localObject = str;
            if (str != null) {}
          }
          else
          {
            localObject = this.mkH;
          }
          i = ((String)localObject).hashCode();
        }
        catch (Exception localException)
        {
          Object localObject;
          Log.printErrStackTrace("hashUrl", (Throwable)localException, "hash url".concat(String.valueOf(paramString)), new Object[0]);
          int i = 0;
          continue;
        }
        AppMethodBeat.o(195551);
        return i;
        localObject = ((Uri)localObject).toString();
        p.g(localObject, "toString()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c
 * JD-Core Version:    0.7.0.1
 */