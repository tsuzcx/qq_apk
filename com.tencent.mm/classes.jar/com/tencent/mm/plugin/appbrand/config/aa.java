package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ab.a;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.fnv;
import com.tencent.mm.protocal.protobuf.fnw;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class aa
{
  static <T> Pair<T, com.tencent.mm.an.c.a<fnw>> a(String paramString, boolean paramBoolean, f paramf, a<T> parama, PBool paramPBool)
  {
    com.tencent.mm.an.c.a locala = null;
    AppMethodBeat.i(281099);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.h.aHE().kbT))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(281099);
      return paramString;
    }
    Object localObject;
    if (!paramBoolean)
    {
      localObject = parama.afs(paramString);
      if ((localObject != null) && (!parama.cy(localObject))) {}
    }
    for (;;)
    {
      if (paramf != null) {
        paramf.bLE();
      }
      locala = parama.afr(paramString).cap();
      int i;
      int j;
      if ((locala == null) || ((locala instanceof ab.a)) || (locala.errType != 0) || (locala.errCode != 0)) {
        if (locala == null)
        {
          i = -1;
          if (locala != null) {
            break label220;
          }
          j = -1;
          label133:
          if (locala != null) {
            break label230;
          }
          paramf = "null resp";
          label141:
          Log.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), paramf });
          if (localObject != null) {
            break label570;
          }
          paramString = parama.afs(paramString);
          if (paramString == null) {
            break label239;
          }
        }
      }
      for (;;)
      {
        paramString = Pair.create(paramString, locala);
        AppMethodBeat.o(281099);
        return paramString;
        i = locala.errType;
        break;
        label220:
        j = locala.errCode;
        break label133;
        label230:
        paramf = locala.errMsg;
        break label141;
        label239:
        paramString = Pair.create(null, locala);
        AppMethodBeat.o(281099);
        return paramString;
        paramf = ((fnw)locala.lBJ).RTU.iterator();
        for (;;)
        {
          if (paramf.hasNext())
          {
            localObject = (fnv)paramf.next();
            if ("UserName".equalsIgnoreCase(((fnv)localObject).CRg))
            {
              localObject = ((fnv)localObject).Izj;
              paramf = (f)localObject;
              if (((String)localObject).endsWith("@app")) {
                break;
              }
            }
          }
        }
        for (paramf = (String)localObject + "@app";; paramf = null)
        {
          localObject = paramf;
          if (Util.isNullOrNil(paramf))
          {
            paramf = parama.getUsername();
            localObject = paramf;
            if (Util.isNullOrNil(paramf))
            {
              Log.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[] { Boolean.valueOf(paramBoolean), paramString });
              paramString = Pair.create(null, null);
              AppMethodBeat.o(281099);
              return paramString;
            }
          }
          Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync key(%s), username(%s), flushAttrs", new Object[] { paramString, localObject });
          if (com.tencent.mm.plugin.appbrand.app.m.bFF().a((String)localObject, ((fnw)locala.lBJ).RTT, ((fnw)locala.lBJ).RTU))
          {
            y.bLB().doNotify("single", 3, localObject);
            if (paramPBool != null) {
              paramPBool.value = true;
            }
          }
          localObject = parama.afs(paramString);
          Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
          cx(localObject);
          for (paramString = locala;; paramString = locala)
          {
            paramString = Pair.create(localObject, paramString);
            AppMethodBeat.o(281099);
            return paramString;
            Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
            cx(localObject);
          }
        }
        label570:
        paramString = (String)localObject;
      }
      localObject = null;
    }
  }
  
  public static Pair<WxaAttributes, com.tencent.mm.an.c.a<fnw>> a(String paramString, boolean paramBoolean, f paramf, final c paramc)
  {
    AppMethodBeat.i(281097);
    paramString = a(paramString, paramBoolean, paramf, new a()
    {
      public final p afr(String paramAnonymousString)
      {
        AppMethodBeat.i(279272);
        if (paramc != null)
        {
          paramAnonymousString = new p(null, paramAnonymousString, paramc.anX(), paramc.bLD());
          AppMethodBeat.o(279272);
          return paramAnonymousString;
        }
        paramAnonymousString = new p(null, paramAnonymousString);
        AppMethodBeat.o(279272);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        AppMethodBeat.i(279271);
        String str = y.afk(this.val$appId);
        AppMethodBeat.o(279271);
        return str;
      }
    }, null);
    AppMethodBeat.o(281097);
    return paramString;
  }
  
  public static e<List<String>> a(List<String> paramList, final o.a parama, final d paramd)
  {
    AppMethodBeat.i(281106);
    Log.i("MicroMsg.WxaAttrSyncHelper", "batchSync before real logic, list_size:%d, scene:%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(parama.intValue) });
    if (Util.isNullOrNil(paramList))
    {
      paramList = com.tencent.mm.cw.g.eE(Collections.emptyList());
      AppMethodBeat.o(281106);
      return paramList;
    }
    if (ai.Or())
    {
      paramList = com.tencent.mm.cw.g.ijP().j(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(281106);
      return paramList;
    }
    Object localObject = paramList;
    if (!(paramList instanceof ArrayList))
    {
      if ((paramList instanceof LinkedList)) {
        localObject = paramList;
      }
    }
    else {
      paramList = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label224;
      }
      String str = (String)paramList.next();
      if ((TextUtils.isEmpty(str)) || (!as.OS(str)))
      {
        paramList.remove();
        continue;
        localObject = new LinkedList(paramList);
        break;
      }
      if (org.apache.commons.b.a.contains(com.tencent.mm.plugin.appbrand.appcache.predownload.h.nJp, parama))
      {
        if (!a(str, parama)) {
          paramList.remove();
        }
      }
      else if (!afn(str)) {
        paramList.remove();
      }
    }
    label224:
    if (Util.isNullOrNil((List)localObject))
    {
      if (paramd != null) {
        paramd.done();
      }
      paramList = com.tencent.mm.cw.g.eE(Collections.emptyList());
      AppMethodBeat.o(281106);
      return paramList;
    }
    Log.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(((List)localObject).size()), parama.name(), Integer.valueOf(parama.intValue) });
    paramList = new LinkedList();
    int i = 0;
    int j = 0;
    while (i < ((List)localObject).size() / 20)
    {
      int k = i * 20;
      j = k + 20;
      paramList.add(c(((List)localObject).subList(k, j), parama));
      i += 1;
    }
    if (j < ((List)localObject).size()) {
      paramList.add(c(((List)localObject).subList(j, ((List)localObject).size()), parama));
    }
    if ((paramd instanceof e)) {
      ((e)paramd).bh((List)localObject);
    }
    paramList = com.tencent.mm.cw.g.c(new com.tencent.mm.vending.g.c.a() {});
    AppMethodBeat.o(281106);
    return paramList;
  }
  
  public static void a(String paramString, b<WxaAttributes> paramb)
  {
    AppMethodBeat.i(281102);
    a(paramString, true, paramb);
    AppMethodBeat.o(281102);
  }
  
  public static void a(String paramString, final boolean paramBoolean, final b<WxaAttributes> paramb)
  {
    AppMethodBeat.i(281103);
    if (afo(paramString))
    {
      AppMethodBeat.o(281103);
      return;
    }
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(279114);
        Object localObject1 = new PBool();
        Object localObject2 = this.iXG;
        boolean bool;
        if ((paramBoolean) && (aa.afn(this.iXG)))
        {
          bool = true;
          localObject2 = aa.a((String)localObject2, bool, null, new aa.a()
          {
            public final p afr(String paramAnonymous2String)
            {
              AppMethodBeat.i(266108);
              paramAnonymous2String = new p(paramAnonymous2String, null);
              AppMethodBeat.o(266108);
              return paramAnonymous2String;
            }
            
            public final String getUsername()
            {
              return aa.4.this.iXG;
            }
          }, (PBool)localObject1);
          if (paramb != null)
          {
            if (((Pair)localObject2).second != null) {
              break label96;
            }
            localObject1 = aa.b.a.oaJ;
          }
        }
        for (;;)
        {
          paramb.a((aa.b.a)localObject1, ((Pair)localObject2).first);
          AppMethodBeat.o(279114);
          return;
          bool = false;
          break;
          label96:
          if ((((com.tencent.mm.an.c.a)((Pair)localObject2).second).errType != 0) || (((com.tencent.mm.an.c.a)((Pair)localObject2).second).errCode != 0)) {
            localObject1 = aa.b.a.oaM;
          } else if (((PBool)localObject1).value) {
            localObject1 = aa.b.a.oaK;
          } else {
            localObject1 = aa.b.a.oaL;
          }
        }
      }
    });
    AppMethodBeat.o(281103);
  }
  
  private static boolean a(String paramString, o.a parama)
  {
    AppMethodBeat.i(281096);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(281096);
      return false;
    }
    if (!afn(paramString))
    {
      AppMethodBeat.o(281096);
      return false;
    }
    com.tencent.mm.plugin.appbrand.appcache.predownload.e.g localg = ((com.tencent.mm.plugin.appbrand.appcache.predownload.e.h)com.tencent.mm.plugin.appbrand.app.m.W(com.tencent.mm.plugin.appbrand.appcache.predownload.e.h.class)).adr(paramString);
    if (localg != null)
    {
      WxaAttributes localWxaAttributes = com.tencent.mm.plugin.appbrand.app.m.bFF().c(paramString, new String[] { "versionInfo" });
      if ((localWxaAttributes != null) && (localWxaAttributes.bLH() != null) && (localWxaAttributes.bLH().cwX == 0) && (localg.field_appVersion <= localWxaAttributes.bLH().appVersion))
      {
        Log.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttrWithUsernameForBatchPreload, username(%s) scene(%s) notifyVersion(%d) appVersion(%d) return false", new Object[] { paramString, parama.name(), Integer.valueOf(localg.field_appVersion), Integer.valueOf(localWxaAttributes.bLH().appVersion) });
        AppMethodBeat.o(281096);
        return false;
      }
    }
    AppMethodBeat.o(281096);
    return true;
  }
  
  public static boolean afn(String paramString)
  {
    AppMethodBeat.i(44926);
    if (com.tencent.mm.plugin.appbrand.app.m.bFF() == null)
    {
      Log.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr(%s), storage NULL", new Object[] { paramString });
      AppMethodBeat.o(44926);
      return false;
    }
    long l1 = Util.nowSecond();
    long l2 = com.tencent.mm.plugin.appbrand.app.m.bFF().afa(paramString);
    int i = bLC();
    if (Log.getLogLevel() <= 0) {
      Log.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
    }
    if ((l1 - l2 >= i) || (l2 > l1 + i))
    {
      AppMethodBeat.o(44926);
      return true;
    }
    AppMethodBeat.o(44926);
    return false;
  }
  
  private static boolean afo(String paramString)
  {
    AppMethodBeat.i(44927);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44927);
      return false;
    }
    if (!com.tencent.mm.aj.m.OS(paramString))
    {
      Log.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[] { paramString, MMStack.stackTraceToString(new Throwable()) });
      com.tencent.mm.plugin.report.service.h.IzE.el(648, 1);
      AppMethodBeat.o(44927);
      return true;
    }
    AppMethodBeat.o(44927);
    return false;
  }
  
  public static void afp(String paramString)
  {
    AppMethodBeat.i(44928);
    if (afo(paramString))
    {
      AppMethodBeat.o(44928);
      return;
    }
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44910);
        aa.afq(this.iXG);
        AppMethodBeat.o(44910);
      }
    });
    AppMethodBeat.o(44928);
  }
  
  public static void afq(String paramString)
  {
    AppMethodBeat.i(44933);
    if (afo(paramString))
    {
      AppMethodBeat.o(44933);
      return;
    }
    if (afn(paramString)) {
      b(paramString, true, null, null);
    }
    AppMethodBeat.o(44933);
  }
  
  public static Pair<WxaAttributes, com.tencent.mm.an.c.a<fnw>> b(String paramString, boolean paramBoolean, f paramf, final c paramc)
  {
    AppMethodBeat.i(281101);
    if (afo(paramString))
    {
      paramString = new Pair(null, null);
      AppMethodBeat.o(281101);
      return paramString;
    }
    paramString = a(paramString, paramBoolean, paramf, new a()
    {
      public final p afr(String paramAnonymousString)
      {
        AppMethodBeat.i(44913);
        if (paramc != null)
        {
          paramAnonymousString = new p(paramAnonymousString, null, paramc.anX(), paramc.bLD());
          AppMethodBeat.o(44913);
          return paramAnonymousString;
        }
        paramAnonymousString = new p(paramAnonymousString, null);
        AppMethodBeat.o(44913);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        AppMethodBeat.i(44912);
        String str = this.iXG;
        AppMethodBeat.o(44912);
        return str;
      }
    }, null);
    AppMethodBeat.o(281101);
    return paramString;
  }
  
  public static e<List<String>> b(List<String> paramList, o.a parama)
  {
    AppMethodBeat.i(293308);
    paramList = a(paramList, parama, null);
    AppMethodBeat.o(293308);
    return paramList;
  }
  
  public static int bLC()
  {
    AppMethodBeat.i(281095);
    int i = com.tencent.mm.n.h.axc().getInt("MMBizAttrSyncFreq", 3600);
    AppMethodBeat.o(281095);
    return i;
  }
  
  private static e<List<String>> c(final List<String> paramList, o.a parama)
  {
    AppMethodBeat.i(281107);
    if (Util.isNullOrNil(paramList))
    {
      paramList = com.tencent.mm.cw.g.eE(Collections.emptyList());
      AppMethodBeat.o(281107);
      return paramList;
    }
    paramList = new o(paramList, parama).bhW().i(new com.tencent.mm.vending.c.a()
    {
      private List<String> c(com.tencent.mm.an.c.a<lc> paramAnonymousa)
      {
        AppMethodBeat.i(279692);
        if ((paramAnonymousa.errType != 0) || (paramAnonymousa.errCode != 0))
        {
          Log.e("MicroMsg.WxaAttrSyncHelper", "BatchWxaAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
          paramAnonymousa = Collections.emptyList();
          AppMethodBeat.o(279692);
          return paramAnonymousa;
        }
        if (paramAnonymousa.lBJ != null) {}
        try
        {
          z localz = com.tencent.mm.plugin.appbrand.app.m.bFF();
          if (!localz.bLz())
          {
            Log.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync storage can not work");
            paramAnonymousa = Collections.emptyList();
            AppMethodBeat.o(279692);
            return paramAnonymousa;
          }
          localz.a(this.oaB.intValue, (lc)paramAnonymousa.lBJ, null);
        }
        catch (NullPointerException paramAnonymousa)
        {
          while (com.tencent.mm.plugin.appbrand.app.m.bFB() == null) {}
          AppMethodBeat.o(279692);
          throw paramAnonymousa;
        }
        catch (com.tencent.mm.model.b paramAnonymousa)
        {
          break label137;
        }
        paramAnonymousa = paramList;
        AppMethodBeat.o(279692);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(281107);
    return paramList;
  }
  
  private static <T> void cx(T paramT)
  {
    AppMethodBeat.i(281100);
    if ((paramT instanceof WxaAttributes))
    {
      ((WxaAttributes)paramT).bLK();
      AppMethodBeat.o(281100);
      return;
    }
    Log.i("MicroMsg.WxaAttrSyncHelper", "printContact %s", new Object[] { paramT });
    AppMethodBeat.o(281100);
  }
  
  static abstract interface a<T>
  {
    public abstract p afr(String paramString);
    
    public abstract T afs(String paramString);
    
    public abstract boolean cy(T paramT);
    
    public abstract String getUsername();
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(a parama, T paramT);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(245191);
        oaJ = new a("RET_HIT_FREQUENCY_LIMIT", 0);
        oaK = new a("RET_UPDATED", 1);
        oaL = new a("RET_NO_UPDATE", 2);
        oaM = new a("RET_CGI_FAIL", 3);
        oaN = new a[] { oaJ, oaK, oaL, oaM };
        AppMethodBeat.o(245191);
      }
      
      private a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract String anX();
    
    public abstract ack bLD();
  }
  
  public static abstract interface d
  {
    public abstract void done();
  }
  
  public static abstract interface e
    extends aa.d
  {
    public abstract void bh(List<String> paramList);
  }
  
  public static abstract interface f
  {
    public abstract void bLE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.aa
 * JD-Core Version:    0.7.0.1
 */