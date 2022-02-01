package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import android.os.Parcelable;
import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.protocal.protobuf.cyf;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"domainHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getDomainHashMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setDomainHashMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "fullUrlHashCache", "getFullUrlHashCache", "setFullUrlHashCache", "urlHashCache", "getUrlHashCache", "setUrlHashCache", "host", "getHost", "(Ljava/lang/String;)Ljava/lang/String;", "clearDomain", "", "domain", "clearDomainCache", "getContentId", "url", "getDomainId", "fetch", "", "getFullWebId", "prefetch", "getInfoId", "getInvalidId", "getManifestId", "getShortUrlId", "getStrip", "", "openScene", "getUrlId", "getWebId", "getWebResId", "resUrl", "hashFullUrl", "hashUrl", "mpDataMmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setShortUrlId", "shortUrl", "longUrl", "contains", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "contentId", "create", "Lcom/tencent/mm/vfs/VFSFile;", "findContentFile", "getContentFile", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "getContentPath", "plugin-brandservice_release"})
public final class b
{
  private static ConcurrentHashMap<String, String> onn;
  private static ConcurrentHashMap<String, String> ono;
  private static ConcurrentHashMap<String, ConcurrentLinkedDeque<String>> onp;
  
  static
  {
    AppMethodBeat.i(6575);
    onn = new ConcurrentHashMap();
    ono = new ConcurrentHashMap();
    onp = new ConcurrentHashMap();
    AppMethodBeat.o(6575);
  }
  
  public static final k D(k paramk)
  {
    AppMethodBeat.i(175480);
    p.h(paramk, "$this$create");
    if (!paramk.exists())
    {
      new k(paramk.getParent()).mkdirs();
      paramk.createNewFile();
    }
    AppMethodBeat.o(175480);
    return paramk;
  }
  
  public static final void XU(String paramString)
  {
    AppMethodBeat.i(208811);
    p.h(paramString, "domain");
    String str1 = Ya(paramString);
    LinkedList localLinkedList = new LinkedList();
    try
    {
      Object localObject = (ConcurrentLinkedDeque)onp.get(str1);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          String str3 = (String)onn.remove(str2);
          if (str3 != null) {
            localLinkedList.add(str3);
          }
          str2 = (String)ono.remove(str2);
          if (str2 != null) {
            localLinkedList.add(str2);
          }
        }
        localObject = z.Nhr;
      }
    }
    finally
    {
      AppMethodBeat.o(208811);
    }
    com.tencent.mm.sdk.platformtools.ae.i("AppMsgContextEx", "clearDomain:" + paramString + '#' + str1 + ", [" + d.a.j.a((Iterable)localLinkedList, (CharSequence)",", null, null, 0, null, null, 62) + ']');
    AppMethodBeat.o(208811);
  }
  
  public static final void XV(String paramString)
  {
    try
    {
      AppMethodBeat.i(6557);
      p.h(paramString, "domain");
      com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)a.onq, null);
      com.tencent.mm.ipcinvoker.a.a("com.tencent.mm:tools", (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)b.onr, null);
      AppMethodBeat.o(6557);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static final String XX(String paramString)
  {
    AppMethodBeat.i(6560);
    p.h(paramString, "url");
    paramString = "_info_" + XW(paramString);
    AppMethodBeat.o(6560);
    return paramString;
  }
  
  public static final String XY(String paramString)
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
  
  private static String Ya(String paramString)
  {
    AppMethodBeat.i(208816);
    p.h(paramString, "domain");
    paramString = "_domain_" + paramString.hashCode();
    AppMethodBeat.o(208816);
    return paramString;
  }
  
  public static final String Yc(String paramString)
  {
    AppMethodBeat.i(208817);
    p.h(paramString, "host");
    paramString = "_manifest_" + paramString.hashCode();
    AppMethodBeat.o(208817);
    return paramString;
  }
  
  public static final String Yd(String paramString)
  {
    AppMethodBeat.i(6568);
    p.h(paramString, "url");
    paramString = "_content_" + XW(paramString);
    AppMethodBeat.o(6568);
    return paramString;
  }
  
  public static final String Ye(String paramString)
  {
    AppMethodBeat.i(6569);
    p.h(paramString, "url");
    paramString = "_invalid_" + XW(paramString);
    AppMethodBeat.o(6569);
    return paramString;
  }
  
  private static String Yf(String paramString)
  {
    AppMethodBeat.i(208818);
    p.h(paramString, "url");
    paramString = bPU().decodeString("short_url_".concat(String.valueOf(paramString)), "");
    p.g(paramString, "mpDataMmkv().decodeString(\"short_url_$url\", \"\")");
    AppMethodBeat.o(208818);
    return paramString;
  }
  
  public static final String Yg(String paramString)
  {
    AppMethodBeat.i(6573);
    p.h(paramString, "url");
    paramString = XW(paramString);
    AppMethodBeat.o(6573);
    return paramString;
  }
  
  public static final k a(ap paramap, String paramString)
  {
    AppMethodBeat.i(175483);
    p.h(paramap, "$this$getContentFile");
    p.h(paramString, "contentId");
    paramap = d((k)paramap.fnP(), paramString);
    AppMethodBeat.o(175483);
    return paramap;
  }
  
  public static final String a(fa paramfa)
  {
    AppMethodBeat.i(6570);
    p.h(paramfa, "$this$getContentId");
    paramfa = paramfa.Url;
    p.g(paramfa, "this.Url");
    paramfa = Yd(paramfa);
    AppMethodBeat.o(6570);
    return paramfa;
  }
  
  private static final String aG(final String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(208812);
    String str1 = paramString + '-' + paramBoolean;
    if (ono.containsKey(str1))
    {
      paramString = (String)d.a.ae.e((Map)ono, str1);
      AppMethodBeat.o(208812);
      return paramString;
    }
    Object localObject1 = Ya(XY(paramString));
    Object localObject2 = new c(paramBoolean, paramString);
    Object localObject3 = new StringBuilder("matched_");
    while (i < 3)
    {
      String str2 = new String[] { "__biz", "mid", "idx" }[i];
      String str3 = UrlExKt.getUrlParam(paramString, str2);
      if (str3 == null)
      {
        localObject3 = UrlExKt.clearShortUrl(paramString);
        str2 = Yf((String)localObject3);
        if (!bu.isNullOrNil(str2))
        {
          ((Map)ono).put(paramString, str2);
          AppMethodBeat.o(208812);
          return str2;
        }
        localObject2 = Integer.toString("not_matched_".concat(String.valueOf(((c)localObject2).Yh((String)localObject3))).hashCode(), d.n.a.ami(16));
        p.g(localObject2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        if (paramBoolean)
        {
          if (!onp.containsKey(localObject1)) {
            ((Map)onp).put(localObject1, new ConcurrentLinkedDeque());
          }
          localObject1 = onp.get(localObject1);
          if (localObject1 == null) {
            p.gkB();
          }
          ((ConcurrentLinkedDeque)localObject1).add(str1);
          ((Map)ono).put(str1, localObject2);
          com.tencent.mm.sdk.platformtools.ae.d("AppMsgContextEx", "#" + (String)localObject2 + " hash from:" + paramString);
        }
        AppMethodBeat.o(208812);
        return localObject2;
      }
      ((StringBuilder)localObject3).append(str2 + ':' + str3 + '-');
      i += 1;
    }
    paramString = ((StringBuilder)localObject3).toString();
    if (!onp.containsKey(localObject1)) {
      ((Map)onp).put(localObject1, new ConcurrentLinkedDeque());
    }
    localObject1 = onp.get(localObject1);
    if (localObject1 == null) {
      p.gkB();
    }
    ((ConcurrentLinkedDeque)localObject1).add(str1);
    localObject1 = (Map)ono;
    p.g(paramString, "this");
    ((Map)localObject1).put(str1, paramString);
    p.g(paramString, "key.toString()\n        .…acheKey] = this\n        }");
    AppMethodBeat.o(208812);
    return paramString;
  }
  
  public static final String aH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(208814);
    p.h(paramString, "url");
    paramString = "_web_" + aG(paramString, paramBoolean);
    AppMethodBeat.o(208814);
    return paramString;
  }
  
  public static final k b(ap paramap, String paramString)
  {
    AppMethodBeat.i(175484);
    p.h(paramap, "$this$findContentFile");
    p.h(paramString, "contentId");
    paramap = (k)paramap.aRy(paramString);
    if (paramap != null)
    {
      paramap = d(paramap, paramString);
      AppMethodBeat.o(175484);
      return paramap;
    }
    AppMethodBeat.o(175484);
    return null;
  }
  
  public static final ConcurrentHashMap<String, String> bPS()
  {
    return onn;
  }
  
  public static final ConcurrentHashMap<String, ConcurrentLinkedDeque<String>> bPT()
  {
    return onp;
  }
  
  private static ay bPU()
  {
    AppMethodBeat.i(6572);
    if (ak.coh()) {
      p.g(g.ajP(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.ajc())
    {
      ay localay = ay.gq("mpRelateData_".concat(String.valueOf(i)), 2);
      p.g(localay, "MultiProcessMMKV.getMMKV…sMMKV.MULTI_PROCESS_MODE)");
      AppMethodBeat.o(6572);
      return localay;
    }
  }
  
  public static final boolean c(ap paramap, String paramString)
  {
    AppMethodBeat.i(6556);
    p.h(paramap, "$this$contains");
    p.h(paramString, "contentId");
    if (paramap.aRy(paramString) != null)
    {
      AppMethodBeat.o(6556);
      return true;
    }
    AppMethodBeat.o(6556);
    return false;
  }
  
  private static final k d(k paramk, String paramString)
  {
    AppMethodBeat.i(175482);
    paramk = new k(paramk.getPath() + '/' + paramString);
    AppMethodBeat.o(175482);
    return paramk;
  }
  
  public static final String eO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6564);
    p.h(paramString1, "host");
    p.h(paramString2, "resUrl");
    paramString1 = paramString1 + "/_web_res_" + XW(paramString2);
    AppMethodBeat.o(6564);
    return paramString1;
  }
  
  public static final void eP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6574);
    p.h(paramString1, "shortUrl");
    p.h(paramString2, "longUrl");
    paramString1 = UrlExKt.clearShortUrl(paramString1);
    paramString2 = Yg(paramString2);
    String str = "short_url_".concat(String.valueOf(paramString1));
    bPU().encode(str, paramString2);
    onn.put(paramString1, paramString2);
    AppMethodBeat.o(6574);
  }
  
  public static final int zG(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(6571);
    Object localObject1 = s.bQG().decodeBytes("_msg_scene_strip");
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
        localObject2 = new cyf();
        ((cyf)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((cyf)localObject2).FUT;
        p.g(localObject1, "SceneControlSets().apply…(buff) }.SceneControlList");
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label210;
          }
          localObject2 = (cye)((Iterator)localObject1).next();
          if (((cye)localObject2).Scene == paramInt)
          {
            if (((cye)localObject2).HIw > 0) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppMsgContextEx", "strip error " + paramInt + ':' + ((cye)localObject2).HIw);
          }
        }
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppMsgContextEx", "strip " + paramInt + ':' + ((cye)localObject2).HIw);
      paramInt = ((cye)localObject2).HIw;
      AppMethodBeat.o(6571);
      return paramInt;
    }
    label210:
    AppMethodBeat.o(6571);
    return 10;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ipcDomain", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final a onq;
    
    static
    {
      AppMethodBeat.i(208804);
      onq = new a();
      AppMethodBeat.o(208804);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ipcDomain", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final b onr;
    
    static
    {
      AppMethodBeat.i(208806);
      onr = new b();
      AppMethodBeat.o(208806);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"toHash", "", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<String, Integer>
  {
    c(boolean paramBoolean, String paramString)
    {
      super();
    }
    
    public final int Yh(String paramString)
    {
      AppMethodBeat.i(208808);
      p.h(paramString, "$this$toHash");
      for (;;)
      {
        try
        {
          localObject = Uri.parse(paramString);
          if (!this.ons) {
            continue;
          }
          String str = ((Uri)localObject).getScheme();
          if ((str == null) || (c.a(str, "http", true) != true)) {
            continue;
          }
          localObject = x.orv;
          localObject = x.Yv(paramString);
          if (localObject != null)
          {
            str = x.orv.a(paramString, (j)localObject);
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
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("hashUrl", (Throwable)localException, "hash url".concat(String.valueOf(paramString)), new Object[0]);
          int i = 0;
          continue;
        }
        AppMethodBeat.o(208808);
        return i;
        localObject = ((Uri)localObject).toString();
        p.g(localObject, "toString()");
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"toHash", "", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<String, Integer>
  {
    d(String paramString)
    {
      super();
    }
    
    public final int Yh(String paramString)
    {
      AppMethodBeat.i(208810);
      p.h(paramString, "$this$toHash");
      for (;;)
      {
        try
        {
          localObject = Uri.parse(paramString);
          if (!this.ons) {
            continue;
          }
          String str = ((Uri)localObject).getScheme();
          if ((str == null) || (c.a(str, "http", true) != true)) {
            continue;
          }
          localObject = x.orv;
          localObject = x.Yv(this.lfj);
          if (localObject != null)
          {
            str = x.orv.a(this.lfj, (j)localObject);
            localObject = str;
            if (str != null) {}
          }
          else
          {
            localObject = this.lfj;
          }
          i = ((String)localObject).hashCode();
        }
        catch (Exception localException)
        {
          Object localObject;
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("hashUrl", (Throwable)localException, "hash url".concat(String.valueOf(paramString)), new Object[0]);
          int i = 0;
          continue;
        }
        AppMethodBeat.o(208810);
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