package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import android.os.Parcelable;
import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import d.a.ae;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"domainHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/LinkedList;", "getDomainHashMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setDomainHashMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "urlHashCache", "getUrlHashCache", "setUrlHashCache", "host", "getHost", "(Ljava/lang/String;)Ljava/lang/String;", "clearDomain", "", "domain", "clearDomainCache", "getContentId", "url", "getDomainId", "fetch", "", "getInfoId", "getInvalidId", "getManifestId", "getShortUrlId", "getStrip", "", "openScene", "getUrlId", "getWebId", "prefetch", "getWebResId", "resUrl", "hashUrl", "mpDataMmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setShortUrlId", "shortUrl", "longUrl", "contains", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "contentId", "create", "Lcom/tencent/mm/vfs/VFSFile;", "findContentFile", "getContentFile", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "getContentPath", "plugin-brandservice_release"})
public final class b
{
  private static ConcurrentHashMap<String, String> oho;
  private static ConcurrentHashMap<String, LinkedList<String>> ohp;
  
  static
  {
    AppMethodBeat.i(6575);
    oho = new ConcurrentHashMap();
    ohp = new ConcurrentHashMap();
    AppMethodBeat.o(6575);
  }
  
  public static final e D(e parame)
  {
    AppMethodBeat.i(175480);
    p.h(parame, "$this$create");
    if (!parame.exists())
    {
      new e(parame.getParent()).mkdirs();
      parame.createNewFile();
    }
    AppMethodBeat.o(175480);
    return parame;
  }
  
  public static final void Xi(String paramString)
  {
    AppMethodBeat.i(209817);
    p.h(paramString, "domain");
    String str1 = Xo(paramString);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = (LinkedList)ohp.get(str1);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        str2 = (String)oho.remove(str2);
        if (str2 != null) {
          localLinkedList.add(str2);
        }
      }
    }
    ad.i("AppMsgContextEx", "clearDomain:" + paramString + '#' + str1 + ", [" + d.a.j.a((Iterable)localLinkedList, (CharSequence)",", null, null, 0, null, null, 62) + ']');
    AppMethodBeat.o(209817);
  }
  
  public static final void Xj(String paramString)
  {
    try
    {
      AppMethodBeat.i(6557);
      p.h(paramString, "domain");
      com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)a.ohq, null);
      com.tencent.mm.ipcinvoker.a.a("com.tencent.mm:tools", (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)b.ohr, null);
      AppMethodBeat.o(6557);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static final String Xl(String paramString)
  {
    AppMethodBeat.i(6560);
    p.h(paramString, "url");
    paramString = "_info_" + Xk(paramString);
    AppMethodBeat.o(6560);
    return paramString;
  }
  
  public static final String Xm(String paramString)
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
  
  private static String Xo(String paramString)
  {
    AppMethodBeat.i(209822);
    p.h(paramString, "domain");
    paramString = "_domain_" + paramString.hashCode();
    AppMethodBeat.o(209822);
    return paramString;
  }
  
  public static final String Xq(String paramString)
  {
    AppMethodBeat.i(209823);
    p.h(paramString, "host");
    paramString = "_manifest_" + paramString.hashCode();
    AppMethodBeat.o(209823);
    return paramString;
  }
  
  public static final String Xr(String paramString)
  {
    AppMethodBeat.i(6568);
    p.h(paramString, "url");
    paramString = "_content_" + Xk(paramString);
    AppMethodBeat.o(6568);
    return paramString;
  }
  
  public static final String Xs(String paramString)
  {
    AppMethodBeat.i(6569);
    p.h(paramString, "url");
    paramString = "_invalid_" + Xk(paramString);
    AppMethodBeat.o(6569);
    return paramString;
  }
  
  public static final String Xt(String paramString)
  {
    AppMethodBeat.i(6573);
    p.h(paramString, "url");
    paramString = aE(paramString, false);
    AppMethodBeat.o(6573);
    return paramString;
  }
  
  public static final e a(ao paramao, String paramString)
  {
    AppMethodBeat.i(175483);
    p.h(paramao, "$this$getContentFile");
    p.h(paramString, "contentId");
    paramao = d((e)paramao.fjV(), paramString);
    AppMethodBeat.o(175483);
    return paramao;
  }
  
  public static final String a(fa paramfa)
  {
    AppMethodBeat.i(6570);
    p.h(paramfa, "$this$getContentId");
    paramfa = paramfa.Url;
    p.g(paramfa, "this.Url");
    paramfa = Xr(paramfa);
    AppMethodBeat.o(6570);
    return paramfa;
  }
  
  private static final String aE(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(209818);
    final String str1 = UrlExKt.clearUrlParams(n.nB(paramString, "#"), new String[] { "from", "isappinstalled", "pass_ticket", "exportKey" });
    paramString = str1 + '-' + paramBoolean;
    if (oho.containsKey(paramString))
    {
      paramString = (String)ae.e((Map)oho, paramString);
      AppMethodBeat.o(209818);
      return paramString;
    }
    Object localObject1 = Xo(Xm(str1));
    Object localObject2 = new c(paramBoolean, str1);
    Object localObject3 = new StringBuilder("matched_");
    while (i < 3)
    {
      String str2 = new String[] { "__biz", "mid", "idx" }[i];
      String str3 = UrlExKt.getUrlParam(str1, str2);
      if (str3 == null)
      {
        localObject3 = UrlExKt.clearShortUrl(str1);
        p.h(localObject3, "url");
        str2 = bOW().decodeString("short_url_".concat(String.valueOf(localObject3)), "");
        p.g(str2, "mpDataMmkv().decodeString(\"short_url_$url\", \"\")");
        if (!bt.isNullOrNil(str2))
        {
          ((Map)oho).put(str1, str2);
          AppMethodBeat.o(209818);
          return str2;
        }
        localObject2 = Integer.toString("not_matched_".concat(String.valueOf(((c)localObject2).Xu((String)localObject3))).hashCode(), d.n.a.aly(16));
        p.g(localObject2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        if (paramBoolean)
        {
          if (!ohp.containsKey(localObject1)) {
            ((Map)ohp).put(localObject1, new LinkedList());
          }
          localObject1 = ohp.get(localObject1);
          if (localObject1 == null) {
            p.gfZ();
          }
          ((LinkedList)localObject1).add(paramString);
          ((Map)oho).put(paramString, localObject2);
          ad.d("AppMsgContextEx", "#" + (String)localObject2 + " hash from:" + str1);
        }
        AppMethodBeat.o(209818);
        return localObject2;
      }
      ((StringBuilder)localObject3).append(str2 + ':' + str3 + '-');
      i += 1;
    }
    str1 = ((StringBuilder)localObject3).toString();
    if (!ohp.containsKey(localObject1)) {
      ((Map)ohp).put(localObject1, new LinkedList());
    }
    localObject1 = ohp.get(localObject1);
    if (localObject1 == null) {
      p.gfZ();
    }
    ((LinkedList)localObject1).add(paramString);
    localObject1 = (Map)oho;
    p.g(str1, "this");
    ((Map)localObject1).put(paramString, str1);
    p.g(str1, "key.toString()\n        .…acheKey] = this\n        }");
    AppMethodBeat.o(209818);
    return str1;
  }
  
  public static final String aF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(209820);
    p.h(paramString, "url");
    paramString = "_web_" + aE(n.nB(paramString, "#"), paramBoolean);
    AppMethodBeat.o(209820);
    return paramString;
  }
  
  public static final e b(ao paramao, String paramString)
  {
    AppMethodBeat.i(175484);
    p.h(paramao, "$this$findContentFile");
    p.h(paramString, "contentId");
    paramao = (e)paramao.aQb(paramString);
    if (paramao != null)
    {
      paramao = d(paramao, paramString);
      AppMethodBeat.o(175484);
      return paramao;
    }
    AppMethodBeat.o(175484);
    return null;
  }
  
  public static final ConcurrentHashMap<String, String> bOU()
  {
    return oho;
  }
  
  public static final ConcurrentHashMap<String, LinkedList<String>> bOV()
  {
    return ohp;
  }
  
  private static ax bOW()
  {
    AppMethodBeat.i(6572);
    if (aj.cmR()) {
      p.g(g.ajA(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.aiN())
    {
      ax localax = ax.gh("mpRelateData_".concat(String.valueOf(i)), 2);
      p.g(localax, "MultiProcessMMKV.getMMKV…sMMKV.MULTI_PROCESS_MODE)");
      AppMethodBeat.o(6572);
      return localax;
    }
  }
  
  public static final boolean c(ao paramao, String paramString)
  {
    AppMethodBeat.i(6556);
    p.h(paramao, "$this$contains");
    p.h(paramString, "contentId");
    if (paramao.aQb(paramString) != null)
    {
      AppMethodBeat.o(6556);
      return true;
    }
    AppMethodBeat.o(6556);
    return false;
  }
  
  private static final e d(e parame, String paramString)
  {
    AppMethodBeat.i(175482);
    parame = new e(parame.getPath() + '/' + paramString);
    AppMethodBeat.o(175482);
    return parame;
  }
  
  public static final String eL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6564);
    p.h(paramString1, "host");
    p.h(paramString2, "resUrl");
    paramString1 = paramString1 + "/_web_res_" + Xk(paramString2);
    AppMethodBeat.o(6564);
    return paramString1;
  }
  
  public static final void eM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6574);
    p.h(paramString1, "shortUrl");
    p.h(paramString2, "longUrl");
    paramString1 = UrlExKt.clearShortUrl(paramString1);
    paramString2 = Xt(paramString2);
    String str = "short_url_".concat(String.valueOf(paramString1));
    bOW().encode(str, paramString2);
    oho.put(paramString1, paramString2);
    AppMethodBeat.o(6574);
  }
  
  public static final int zx(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(6571);
    Object localObject1 = s.bPI().decodeBytes("_msg_scene_strip");
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
          break label210;
        }
        localObject2 = new cxl();
        ((cxl)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((cxl)localObject2).FCy;
        p.g(localObject1, "SceneControlSets().apply…(buff) }.SceneControlList");
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label210;
          }
          localObject2 = (cxk)((Iterator)localObject1).next();
          if (((cxk)localObject2).Scene == paramInt)
          {
            if (((cxk)localObject2).HoU > 0) {
              break;
            }
            ad.e("MicroMsg.AppMsgContextEx", "strip error " + paramInt + ':' + ((cxk)localObject2).HoU);
          }
        }
      }
      ad.i("MicroMsg.AppMsgContextEx", "strip " + paramInt + ':' + ((cxk)localObject2).HoU);
      paramInt = ((cxk)localObject2).HoU;
      AppMethodBeat.o(6571);
      return paramInt;
    }
    label210:
    AppMethodBeat.o(6571);
    return 10;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "ipcDomain", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final a ohq;
    
    static
    {
      AppMethodBeat.i(209812);
      ohq = new a();
      AppMethodBeat.o(209812);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "ipcDomain", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final b ohr;
    
    static
    {
      AppMethodBeat.i(209814);
      ohr = new b();
      AppMethodBeat.o(209814);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"toHash", "", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<String, Integer>
  {
    c(boolean paramBoolean, String paramString)
    {
      super();
    }
    
    public final int Xu(String paramString)
    {
      AppMethodBeat.i(209816);
      p.h(paramString, "$this$toHash");
      for (;;)
      {
        try
        {
          localObject = Uri.parse(paramString);
          if (!this.ohs) {
            continue;
          }
          String str = ((Uri)localObject).getScheme();
          if ((str == null) || (c.a(str, "http", true) != true)) {
            continue;
          }
          localObject = w.olE;
          localObject = w.XI(str1);
          if (localObject != null)
          {
            str = w.olE.a(str1, (j)localObject);
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
          ad.printErrStackTrace("hashUrl", (Throwable)localException, "hash url".concat(String.valueOf(paramString)), new Object[0]);
          int i = 0;
          continue;
        }
        AppMethodBeat.o(209816);
        return i;
        localObject = ((Uri)localObject).toString();
        p.g(localObject, "toString()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b
 * JD-Core Version:    0.7.0.1
 */