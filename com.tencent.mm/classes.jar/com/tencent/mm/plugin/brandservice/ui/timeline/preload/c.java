package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.eav;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"domainHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getDomainHashMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setDomainHashMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "fullUrlHashCache", "getFullUrlHashCache", "setFullUrlHashCache", "urlHashCache", "getUrlHashCache", "setUrlHashCache", "host", "getHost", "(Ljava/lang/String;)Ljava/lang/String;", "path", "getPath", "clearDomain", "", "domain", "clearDomainCache", "getContentId", "url", "getDomainId", "fetch", "", "getFullInfoId", "getFullWebId", "prefetch", "getInfoId", "getInvalidId", "getShortUrlId", "getStrip", "", "openScene", "getUrlId", "getWebId", "getWebResId", "resUrl", "hashFullUrl", "hashUrl", "mpDataMmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setShortUrlId", "shortUrl", "longUrl", "contains", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "contentId", "create", "Lcom/tencent/mm/vfs/VFSFile;", "findContentFile", "getContentFile", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "getContentPath", "plugin-brandservice_release"})
public final class c
{
  private static ConcurrentHashMap<String, String> sKv;
  private static ConcurrentHashMap<String, String> sKw;
  private static ConcurrentHashMap<String, ConcurrentLinkedDeque<String>> sKx;
  
  static
  {
    AppMethodBeat.i(6575);
    sKv = new ConcurrentHashMap();
    sKw = new ConcurrentHashMap();
    sKx = new ConcurrentHashMap();
    AppMethodBeat.o(6575);
  }
  
  public static final com.tencent.mm.vfs.q G(com.tencent.mm.vfs.q paramq)
  {
    AppMethodBeat.i(175480);
    p.k(paramq, "$this$create");
    if (!paramq.ifE())
    {
      String str = paramq.ifA();
      if (str == null) {
        p.iCn();
      }
      new com.tencent.mm.vfs.q(str).ifL();
      paramq.ifM();
    }
    AppMethodBeat.o(175480);
    return paramq;
  }
  
  public static final int GU(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(6571);
    Object localObject1 = q.cCt().decodeBytes("_msg_scene_strip");
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
        localObject2 = new eaw();
        ((eaw)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((eaw)localObject2).RPz;
        p.j(localObject1, "SceneControlSets().apply…(buff) }.SceneControlList");
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label204;
          }
          localObject2 = (eav)((Iterator)localObject1).next();
          if (((eav)localObject2).CPw == paramInt)
          {
            if (((eav)localObject2).UfQ > 0) {
              break;
            }
            Log.e("MicroMsg.AppMsgContextEx", "strip error " + paramInt + ':' + ((eav)localObject2).UfQ);
          }
        }
      }
      Log.i("MicroMsg.AppMsgContextEx", "strip " + paramInt + ':' + ((eav)localObject2).UfQ);
      paramInt = ((eav)localObject2).UfQ;
      AppMethodBeat.o(6571);
      return paramInt;
    }
    label204:
    AppMethodBeat.o(6571);
    return 10;
  }
  
  public static final com.tencent.mm.vfs.q a(MMFileSlotManager paramMMFileSlotManager, String paramString)
  {
    AppMethodBeat.i(175483);
    p.k(paramMMFileSlotManager, "$this$getContentFile");
    p.k(paramString, "contentId");
    paramMMFileSlotManager = f((com.tencent.mm.vfs.q)paramMMFileSlotManager.getSlotForWrite(), paramString);
    AppMethodBeat.o(175483);
    return paramMMFileSlotManager;
  }
  
  public static final String a(fh paramfh)
  {
    AppMethodBeat.i(6570);
    p.k(paramfh, "$this$getContentId");
    paramfh = paramfh.Url;
    p.j(paramfh, "this.Url");
    paramfh = apN(paramfh);
    AppMethodBeat.o(6570);
    return paramfh;
  }
  
  private static final String aK(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(259744);
    String str1 = paramString + '-' + paramBoolean;
    Object localObject3;
    for (;;)
    {
      int i;
      String str2;
      String str3;
      try
      {
        if (sKw.containsKey(str1))
        {
          paramString = (String)ae.e((Map)sKw, str1);
          return paramString;
        }
        localObject1 = x.aazN;
        localObject1 = apL(getHost(paramString));
        localObject2 = new c(paramBoolean, paramString);
        localObject3 = new StringBuilder("matched_");
        i = 0;
        if (i >= 3) {
          break;
        }
        str2 = new String[] { "__biz", "mid", "idx" }[i];
        str3 = UrlExKt.getUrlParam(paramString, str2);
        if (str3 != null) {
          break label374;
        }
        localObject3 = UrlExKt.clearShortUrl(paramString, true);
        str2 = apP((String)localObject3);
        if (!Util.isNullOrNil(str2))
        {
          ((Map)sKw).put(paramString, str2);
          AppMethodBeat.o(259744);
          return str2;
        }
      }
      finally
      {
        AppMethodBeat.o(259744);
      }
      Object localObject2 = Integer.toString("not_matched_".concat(String.valueOf(((c)localObject2).adq((String)localObject3))).hashCode(), kotlin.n.a.aFL(16));
      p.j(localObject2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
      if (paramBoolean)
      {
        if (!sKx.containsKey(localObject1)) {
          ((Map)sKx).put(localObject1, new ConcurrentLinkedDeque());
        }
        localObject1 = sKx.get(localObject1);
        if (localObject1 == null) {
          p.iCn();
        }
        ((ConcurrentLinkedDeque)localObject1).add(str1);
        ((Map)sKw).put(str1, localObject2);
        Log.d("AppMsgContextEx", "#" + (String)localObject2 + " hash from:%s", new Object[] { paramString });
      }
      AppMethodBeat.o(259744);
      return localObject2;
      label374:
      ((StringBuilder)localObject3).append(str2 + ':' + str3 + '-');
      i += 1;
    }
    paramString = ((StringBuilder)localObject3).toString();
    if (!sKx.containsKey(localObject1)) {
      ((Map)sKx).put(localObject1, new ConcurrentLinkedDeque());
    }
    Object localObject1 = sKx.get(localObject1);
    if (localObject1 == null) {
      p.iCn();
    }
    ((ConcurrentLinkedDeque)localObject1).add(str1);
    localObject1 = (Map)sKw;
    p.j(paramString, "this");
    ((Map)localObject1).put(str1, paramString);
    p.j(paramString, "key.toString()\n        .…acheKey] = this\n        }");
    AppMethodBeat.o(259744);
    return paramString;
  }
  
  public static final String aL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(259749);
    p.k(paramString, "url");
    paramString = "_web_" + aK(paramString, paramBoolean);
    AppMethodBeat.o(259749);
    return paramString;
  }
  
  public static final void apF(String paramString)
  {
    AppMethodBeat.i(259743);
    p.k(paramString, "domain");
    String str1 = apL(paramString);
    LinkedList localLinkedList = new LinkedList();
    try
    {
      Object localObject = (ConcurrentLinkedDeque)sKx.get(str1);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          String str3 = (String)sKv.remove(str2);
          if (str3 != null) {
            localLinkedList.add(str3);
          }
          str2 = (String)sKw.remove(str2);
          if (str2 != null) {
            localLinkedList.add(str2);
          }
        }
        localObject = x.aazN;
      }
    }
    finally
    {
      AppMethodBeat.o(259743);
    }
    Log.i("AppMsgContextEx", "clearDomain:" + paramString + '#' + str1 + ", [" + j.a((Iterable)localLinkedList, (CharSequence)",", null, null, 0, null, null, 62) + ']');
    AppMethodBeat.o(259743);
  }
  
  public static final void apG(String paramString)
  {
    try
    {
      AppMethodBeat.i(6557);
      p.k(paramString, "domain");
      String str = MainProcessIPCService.PROCESS_NAME;
      p.j(str, "MainProcessIPCService.PROCESS_NAME");
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)new IPCString(paramString), (d)a.sKy, null);
      str = ToolsProcessIPCService.PROCESS_NAME;
      p.j(str, "ToolsProcessIPCService.PROCESS_NAME");
      com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)new IPCString(paramString), (d)b.sKz, null);
      AppMethodBeat.o(6557);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static final String apH(String paramString)
  {
    AppMethodBeat.i(259745);
    final String str1 = UrlExKt.clearUrlParams(n.pv(paramString, "#"), new String[] { "from", "isappinstalled", "pass_ticket", "exportKey" });
    paramString = str1 + '-' + false;
    String str2;
    StringBuilder localStringBuilder;
    for (;;)
    {
      int i;
      String str3;
      String str4;
      try
      {
        if (sKv.containsKey(paramString))
        {
          paramString = (String)ae.e((Map)sKv, paramString);
          return paramString;
        }
        localObject = x.aazN;
        str2 = apL(getHost(str1));
        localObject = new d(false, str1);
        localStringBuilder = new StringBuilder("matched_");
        i = 0;
        if (i >= 3) {
          break;
        }
        str3 = new String[] { "__biz", "mid", "idx" }[i];
        str4 = UrlExKt.getUrlParam(str1, str3);
        if (str4 != null) {
          break label294;
        }
        paramString = UrlExKt.clearShortUrl$default(str1, false, 2, null);
        str2 = apP(paramString);
        if (!Util.isNullOrNil(str2))
        {
          ((Map)sKv).put(str1, str2);
          AppMethodBeat.o(259745);
          return str2;
        }
      }
      finally
      {
        AppMethodBeat.o(259745);
      }
      paramString = Integer.toString("not_matched_".concat(String.valueOf(((d)localObject).adq(paramString))).hashCode(), kotlin.n.a.aFL(16));
      p.j(paramString, "java.lang.Integer.toStri…(this, checkRadix(radix))");
      AppMethodBeat.o(259745);
      return paramString;
      label294:
      localStringBuilder.append(str3 + ':' + str4 + '-');
      i += 1;
    }
    str1 = localStringBuilder.toString();
    if (!sKx.containsKey(str2)) {
      ((Map)sKx).put(str2, new ConcurrentLinkedDeque());
    }
    Object localObject = sKx.get(str2);
    if (localObject == null) {
      p.iCn();
    }
    ((ConcurrentLinkedDeque)localObject).add(paramString);
    localObject = (Map)sKv;
    p.j(str1, "this");
    ((Map)localObject).put(paramString, str1);
    p.j(str1, "key.toString()\n        .…acheKey] = this\n        }");
    AppMethodBeat.o(259745);
    return str1;
  }
  
  public static final String apI(String paramString)
  {
    AppMethodBeat.i(259746);
    p.k(paramString, "url");
    paramString = "_info_" + aK(paramString, false);
    AppMethodBeat.o(259746);
    return paramString;
  }
  
  public static final String apJ(String paramString)
  {
    AppMethodBeat.i(6560);
    p.k(paramString, "url");
    paramString = "_info_" + apH(paramString);
    AppMethodBeat.o(6560);
    return paramString;
  }
  
  private static String apL(String paramString)
  {
    AppMethodBeat.i(259751);
    p.k(paramString, "domain");
    paramString = "_domain_" + paramString.hashCode();
    AppMethodBeat.o(259751);
    return paramString;
  }
  
  public static final String apN(String paramString)
  {
    AppMethodBeat.i(6568);
    p.k(paramString, "url");
    paramString = "_content_" + apH(paramString);
    AppMethodBeat.o(6568);
    return paramString;
  }
  
  public static final String apO(String paramString)
  {
    AppMethodBeat.i(6569);
    p.k(paramString, "url");
    paramString = "_invalid_" + apH(paramString);
    AppMethodBeat.o(6569);
    return paramString;
  }
  
  private static String apP(String paramString)
  {
    AppMethodBeat.i(259754);
    p.k(paramString, "url");
    paramString = cBz().decodeString("short_url_".concat(String.valueOf(paramString)), "");
    p.j(paramString, "mpDataMmkv().decodeString(\"short_url_$url\", \"\")");
    AppMethodBeat.o(259754);
    return paramString;
  }
  
  public static final String apQ(String paramString)
  {
    AppMethodBeat.i(6573);
    p.k(paramString, "url");
    paramString = apH(paramString);
    AppMethodBeat.o(6573);
    return paramString;
  }
  
  public static final com.tencent.mm.vfs.q b(MMFileSlotManager paramMMFileSlotManager, String paramString)
  {
    AppMethodBeat.i(175484);
    p.k(paramMMFileSlotManager, "$this$findContentFile");
    p.k(paramString, "contentId");
    paramMMFileSlotManager = (com.tencent.mm.vfs.q)paramMMFileSlotManager.findSlot(paramString);
    if (paramMMFileSlotManager != null)
    {
      paramMMFileSlotManager = f(paramMMFileSlotManager, paramString);
      AppMethodBeat.o(175484);
      return paramMMFileSlotManager;
    }
    AppMethodBeat.o(175484);
    return null;
  }
  
  public static final boolean c(MMFileSlotManager paramMMFileSlotManager, String paramString)
  {
    AppMethodBeat.i(6556);
    p.k(paramMMFileSlotManager, "$this$contains");
    p.k(paramString, "contentId");
    if (paramMMFileSlotManager.findSlot(paramString) != null)
    {
      AppMethodBeat.o(6556);
      return true;
    }
    AppMethodBeat.o(6556);
    return false;
  }
  
  public static final ConcurrentHashMap<String, String> cBx()
  {
    return sKv;
  }
  
  public static final ConcurrentHashMap<String, ConcurrentLinkedDeque<String>> cBy()
  {
    return sKx;
  }
  
  private static MultiProcessMMKV cBz()
  {
    AppMethodBeat.i(6572);
    if (MMApplicationContext.isMainProcess()) {
      p.j(h.aHE(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.b.getUin();; i = com.tencent.mm.kernel.b.aGP())
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mpRelateData_".concat(String.valueOf(i)), 2);
      p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…sMMKV.MULTI_PROCESS_MODE)");
      AppMethodBeat.o(6572);
      return localMultiProcessMMKV;
    }
  }
  
  private static final com.tencent.mm.vfs.q f(com.tencent.mm.vfs.q paramq, String paramString)
  {
    AppMethodBeat.i(175482);
    paramq = new com.tencent.mm.vfs.q(paramq.getPath() + '/' + paramString);
    AppMethodBeat.o(175482);
    return paramq;
  }
  
  public static final String ft(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6564);
    p.k(paramString1, "host");
    p.k(paramString2, "resUrl");
    paramString1 = paramString1 + "/_web_res_" + apH(paramString2);
    AppMethodBeat.o(6564);
    return paramString1;
  }
  
  public static final void fu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6574);
    p.k(paramString1, "shortUrl");
    p.k(paramString2, "longUrl");
    paramString1 = UrlExKt.clearShortUrl$default(paramString1, false, 2, null);
    paramString2 = apQ(paramString2);
    String str = "short_url_".concat(String.valueOf(paramString1));
    cBz().encode(str, paramString2);
    sKv.put(paramString1, paramString2);
    AppMethodBeat.o(6574);
  }
  
  public static final String getHost(String paramString)
  {
    AppMethodBeat.i(6561);
    p.k(paramString, "$this$host");
    try
    {
      paramString = Uri.parse(UrlExKt.getWithProtocol(paramString));
      p.j(paramString, "Uri.parse(this.withProtocol)");
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
    AppMethodBeat.i(259748);
    p.k(paramString, "$this$path");
    try
    {
      paramString = Uri.parse(UrlExKt.getWithProtocol(paramString));
      p.j(paramString, "Uri.parse(this.withProtocol)");
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
    AppMethodBeat.o(259748);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ipcDomain", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements d<IPCString, IPCVoid>
  {
    public static final a sKy;
    
    static
    {
      AppMethodBeat.i(261358);
      sKy = new a();
      AppMethodBeat.o(261358);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ipcDomain", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements d<IPCString, IPCVoid>
  {
    public static final b sKz;
    
    static
    {
      AppMethodBeat.i(257330);
      sKz = new b();
      AppMethodBeat.o(257330);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"toHash", "", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, Integer>
  {
    c(boolean paramBoolean, String paramString)
    {
      super();
    }
    
    public final int adq(String paramString)
    {
      AppMethodBeat.i(265474);
      p.k(paramString, "$this$toHash");
      for (;;)
      {
        try
        {
          localObject = Uri.parse(paramString);
          if (!this.sKA) {
            continue;
          }
          String str = ((Uri)localObject).getScheme();
          if ((str == null) || (com.tencent.luggage.k.c.a(str, "http", true) != true)) {
            continue;
          }
          localObject = w.sPP;
          localObject = w.aqh(paramString);
          if (localObject != null)
          {
            str = w.sPP.a(paramString, (com.tencent.mm.plugin.ax.a)localObject);
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
          Log.printErrStackTrace("hashUrl", (Throwable)localException, "hash url %s", new Object[] { paramString });
          int i = 0;
          continue;
        }
        AppMethodBeat.o(265474);
        return i;
        localObject = ((Uri)localObject).toString();
        p.j(localObject, "toString()");
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"toHash", "", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, Integer>
  {
    d(boolean paramBoolean, String paramString)
    {
      super();
    }
    
    public final int adq(String paramString)
    {
      AppMethodBeat.i(6550);
      p.k(paramString, "$this$toHash");
      for (;;)
      {
        try
        {
          localObject = Uri.parse(paramString);
          if (!this.sKA) {
            continue;
          }
          String str = ((Uri)localObject).getScheme();
          if ((str == null) || (com.tencent.luggage.k.c.a(str, "http", true) != true)) {
            continue;
          }
          localObject = w.sPP;
          localObject = w.aqh(str1);
          if (localObject != null)
          {
            str = w.sPP.a(str1, (com.tencent.mm.plugin.ax.a)localObject);
            localObject = str;
            if (str != null) {}
          }
          else
          {
            localObject = str1;
          }
          i = ((String)localObject).hashCode();
        }
        catch (Exception localException)
        {
          Object localObject;
          Log.printErrStackTrace("hashUrl", (Throwable)localException, "hash url %s", new Object[] { paramString });
          int i = 0;
          continue;
        }
        AppMethodBeat.o(6550);
        return i;
        localObject = ((Uri)localObject).toString();
        p.j(localObject, "toString()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c
 * JD-Core Version:    0.7.0.1
 */