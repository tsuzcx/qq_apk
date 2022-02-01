package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.aa.a;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.g;
import com.tencent.mm.message.m;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.j;
import com.tencent.mm.plugin.appbrand.utils.ao;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.gku;
import com.tencent.mm.protocal.protobuf.gkv;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.vending.g.c.a;
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

public final class ag
  extends ah
{
  private static boolean XO(String paramString)
  {
    AppMethodBeat.i(44927);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44927);
      return false;
    }
    if (!m.Hh(paramString))
    {
      Log.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[] { paramString, MMStack.stackTraceToString(new Throwable()) });
      com.tencent.mm.plugin.report.service.h.OAn.kJ(648, 1);
      AppMethodBeat.o(44927);
      return true;
    }
    AppMethodBeat.o(44927);
    return false;
  }
  
  public static void XP(String paramString)
  {
    AppMethodBeat.i(44928);
    if (XO(paramString))
    {
      AppMethodBeat.o(44928);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44910);
        ag.XQ(ag.this);
        AppMethodBeat.o(44910);
      }
    });
    AppMethodBeat.o(44928);
  }
  
  public static void XQ(String paramString)
  {
    AppMethodBeat.i(44933);
    if (XO(paramString))
    {
      AppMethodBeat.o(44933);
      return;
    }
    if (ax(paramString, false)) {
      b(paramString, true, null, null);
    }
    AppMethodBeat.o(44933);
  }
  
  static <T> Pair<T, b.a<gkv>> a(String paramString, boolean paramBoolean, f paramf, a<T> parama, PBool paramPBool)
  {
    b.a locala = null;
    AppMethodBeat.i(323337);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.h.baC().mBZ))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(323337);
      return paramString;
    }
    Object localObject;
    if (!paramBoolean)
    {
      localObject = parama.XS(paramString);
      if ((localObject != null) && (!parama.dT(localObject))) {}
    }
    for (;;)
    {
      if (paramf != null) {
        paramf.clc();
      }
      locala = parama.XR(paramString).cAG();
      int i;
      int j;
      if ((locala == null) || ((locala instanceof aa.a)) || (locala.errType != 0) || (locala.errCode != 0)) {
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
            break label575;
          }
          paramString = parama.XS(paramString);
          if (paramString == null) {
            break label239;
          }
        }
      }
      for (;;)
      {
        paramString = Pair.create(paramString, locala);
        AppMethodBeat.o(323337);
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
        AppMethodBeat.o(323337);
        return paramString;
        paramf = ((gkv)locala.ott).YRu.iterator();
        for (;;)
        {
          if (paramf.hasNext())
          {
            localObject = (gku)paramf.next();
            if ("UserName".equalsIgnoreCase(((gku)localObject).ILw))
            {
              localObject = ((gku)localObject).OzQ;
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
              AppMethodBeat.o(323337);
              return paramString;
            }
          }
          Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync key(%s), username(%s), flushAttrs", new Object[] { paramString, localObject });
          if (n.cfc().a((String)localObject, ((gkv)locala.ott).YRt, ((gkv)locala.ott).YRu))
          {
            ad.ckY().doNotify("single", 3, localObject);
            if (paramPBool != null) {
              paramPBool.value = true;
            }
          }
          localObject = parama.XS(paramString);
          Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
          dS(localObject);
          for (paramString = locala;; paramString = locala)
          {
            paramString = Pair.create(localObject, paramString);
            AppMethodBeat.o(323337);
            return paramString;
            Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
            dS(localObject);
          }
        }
        label575:
        paramString = (String)localObject;
      }
      localObject = null;
    }
  }
  
  public static Pair<WxaAttributes, b.a<gkv>> a(String paramString, boolean paramBoolean, f paramf, final c paramc)
  {
    AppMethodBeat.i(323328);
    paramString = a(paramString, paramBoolean, paramf, new a()
    {
      public final r XR(String paramAnonymousString)
      {
        AppMethodBeat.i(323447);
        if (paramc != null)
        {
          paramAnonymousString = new r(null, paramAnonymousString, paramc.ckZ(), paramc.cla(), paramc.clb());
          AppMethodBeat.o(323447);
          return paramAnonymousString;
        }
        paramAnonymousString = new r(null, paramAnonymousString);
        AppMethodBeat.o(323447);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        AppMethodBeat.i(323443);
        String str = ad.XL(ag.this);
        AppMethodBeat.o(323443);
        return str;
      }
    }, null);
    AppMethodBeat.o(323328);
    return paramString;
  }
  
  public static e<List<String>> a(List<String> paramList, final q.a parama, final d paramd)
  {
    AppMethodBeat.i(323358);
    Log.i("MicroMsg.WxaAttrSyncHelper", "batchSync before real logic, list_size:%d, scene:%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(parama.qDL) });
    if (Util.isNullOrNil(paramList))
    {
      paramList = g.ha(Collections.emptyList());
      AppMethodBeat.o(323358);
      return paramList;
    }
    if (ao.aoz())
    {
      paramList = g.jPX().j(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(323358);
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
        break label229;
      }
      String str = (String)paramList.next();
      if ((TextUtils.isEmpty(str)) || (!au.Hh(str)))
      {
        paramList.remove();
        continue;
        localObject = new LinkedList(paramList);
        break;
      }
      if (org.apache.commons.c.a.contains(com.tencent.mm.plugin.appbrand.appcache.predownload.h.qIY, parama))
      {
        if (!a(str, parama)) {
          paramList.remove();
        }
      }
      else if (!ax(str, XT(str))) {
        paramList.remove();
      }
    }
    label229:
    if (Util.isNullOrNil((List)localObject))
    {
      if (paramd != null) {
        paramd.done();
      }
      paramList = g.ha(Collections.emptyList());
      AppMethodBeat.o(323358);
      return paramList;
    }
    Log.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(((List)localObject).size()), parama.name(), Integer.valueOf(parama.qDL) });
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
      ((e)paramd).cQ((List)localObject);
    }
    paramList = g.c(new c.a() {});
    AppMethodBeat.o(323358);
    return paramList;
  }
  
  public static void a(String paramString, final boolean paramBoolean, final b<WxaAttributes> paramb, final c paramc)
  {
    AppMethodBeat.i(323349);
    if (XO(paramString))
    {
      AppMethodBeat.o(323349);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        boolean bool2 = false;
        AppMethodBeat.i(323461);
        Object localObject1 = new PBool();
        Object localObject2 = ag.this;
        boolean bool1 = bool2;
        if (paramBoolean)
        {
          bool1 = bool2;
          if (ag.ax(ag.this, false)) {
            bool1 = true;
          }
        }
        localObject2 = ag.a((String)localObject2, bool1, null, new ag.a()
        {
          public final r XR(String paramAnonymous2String)
          {
            AppMethodBeat.i(323327);
            if (ag.4.this.rbh != null)
            {
              paramAnonymous2String = new r(paramAnonymous2String, null, ag.4.this.rbh.ckZ(), ag.4.this.rbh.cla(), ag.4.this.rbh.clb());
              AppMethodBeat.o(323327);
              return paramAnonymous2String;
            }
            paramAnonymous2String = new r(paramAnonymous2String, null);
            AppMethodBeat.o(323327);
            return paramAnonymous2String;
          }
          
          public final String getUsername()
          {
            return ag.this;
          }
        }, (PBool)localObject1);
        if (paramb != null)
        {
          if (((Pair)localObject2).second != null) {
            break label106;
          }
          localObject1 = ag.b.a.rbv;
        }
        for (;;)
        {
          paramb.a((ag.b.a)localObject1, (WxaAttributes)((Pair)localObject2).first);
          AppMethodBeat.o(323461);
          return;
          label106:
          if ((((b.a)((Pair)localObject2).second).errType != 0) || (((b.a)((Pair)localObject2).second).errCode != 0)) {
            localObject1 = ag.b.a.rby;
          } else if (((PBool)localObject1).value) {
            localObject1 = ag.b.a.rbw;
          } else {
            localObject1 = ag.b.a.rbx;
          }
        }
      }
    });
    AppMethodBeat.o(323349);
  }
  
  private static boolean a(String paramString, q.a parama)
  {
    AppMethodBeat.i(323311);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(323311);
      return false;
    }
    if (!ax(paramString, false))
    {
      AppMethodBeat.o(323311);
      return false;
    }
    com.tencent.mm.plugin.appbrand.appcache.predownload.storage.i locali = ((j)n.ag(j.class)).VM(paramString);
    if (locali != null)
    {
      WxaAttributes localWxaAttributes = n.cfc().d(paramString, new String[] { "versionInfo" });
      if ((localWxaAttributes != null) && (localWxaAttributes.clf() != null) && (localWxaAttributes.clf().eoZ == 0) && (locali.field_appVersion <= localWxaAttributes.clf().appVersion))
      {
        Log.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttrWithUsernameForBatchPreload, username(%s) scene(%s) notifyVersion(%d) appVersion(%d) return false", new Object[] { paramString, parama.name(), Integer.valueOf(locali.field_appVersion), Integer.valueOf(localWxaAttributes.clf().appVersion) });
        AppMethodBeat.o(323311);
        return false;
      }
    }
    AppMethodBeat.o(323311);
    return true;
  }
  
  public static boolean ax(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(323316);
    if (n.cfc() == null)
    {
      Log.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr(%s), storage NULL", new Object[] { paramString });
      AppMethodBeat.o(323316);
      return false;
    }
    long l1 = Util.nowSecond();
    long l2 = n.cfc().XC(paramString);
    long l3 = iI(paramBoolean);
    if (Log.getLogLevel() <= 0) {
      Log.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
    }
    if ((l1 - l2 >= l3) || (l2 > l1 + l3))
    {
      AppMethodBeat.o(323316);
      return true;
    }
    AppMethodBeat.o(323316);
    return false;
  }
  
  public static Pair<WxaAttributes, b.a<gkv>> b(String paramString, boolean paramBoolean, f paramf, final c paramc)
  {
    AppMethodBeat.i(323347);
    if (XO(paramString))
    {
      paramString = new Pair(null, null);
      AppMethodBeat.o(323347);
      return paramString;
    }
    paramString = a(paramString, paramBoolean, paramf, new a()
    {
      public final r XR(String paramAnonymousString)
      {
        AppMethodBeat.i(44913);
        if (paramc != null)
        {
          paramAnonymousString = new r(paramAnonymousString, null, paramc.ckZ(), paramc.cla(), paramc.clb());
          AppMethodBeat.o(44913);
          return paramAnonymousString;
        }
        paramAnonymousString = new r(paramAnonymousString, null);
        AppMethodBeat.o(44913);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        AppMethodBeat.i(44912);
        String str = ag.this;
        AppMethodBeat.o(44912);
        return str;
      }
    }, null);
    AppMethodBeat.o(323347);
    return paramString;
  }
  
  public static e<List<String>> b(List<String> paramList, q.a parama)
  {
    AppMethodBeat.i(370021);
    paramList = a(paramList, parama, null);
    AppMethodBeat.o(370021);
    return paramList;
  }
  
  private static e<List<String>> c(final List<String> paramList, q.a parama)
  {
    AppMethodBeat.i(323360);
    if (Util.isNullOrNil(paramList))
    {
      paramList = g.ha(Collections.emptyList());
      AppMethodBeat.o(323360);
      return paramList;
    }
    paramList = new q(paramList, parama).bFJ().i(new com.tencent.mm.vending.c.a()
    {
      private List<String> c(b.a<md> paramAnonymousa)
      {
        AppMethodBeat.i(323465);
        if ((paramAnonymousa.errType != 0) || (paramAnonymousa.errCode != 0))
        {
          Log.e("MicroMsg.WxaAttrSyncHelper", "BatchWxaAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
          paramAnonymousa = Collections.emptyList();
          AppMethodBeat.o(323465);
          return paramAnonymousa;
        }
        if (paramAnonymousa.ott != null) {}
        try
        {
          af localaf = n.cfc();
          if (!localaf.ckW())
          {
            Log.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync storage can not work");
            paramAnonymousa = Collections.emptyList();
            AppMethodBeat.o(323465);
            return paramAnonymousa;
          }
          localaf.a(ag.this.qDL, (md)paramAnonymousa.ott);
        }
        catch (NullPointerException paramAnonymousa)
        {
          while (n.ceY() == null) {}
          AppMethodBeat.o(323465);
          throw paramAnonymousa;
        }
        catch (com.tencent.mm.model.b paramAnonymousa)
        {
          break label136;
        }
        paramAnonymousa = paramList;
        AppMethodBeat.o(323465);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(323360);
    return paramList;
  }
  
  private static <T> void dS(T paramT)
  {
    AppMethodBeat.i(323342);
    if ((paramT instanceof WxaAttributes))
    {
      ((WxaAttributes)paramT).cli();
      AppMethodBeat.o(323342);
      return;
    }
    Log.i("MicroMsg.WxaAttrSyncHelper", "printContact %s", new Object[] { paramT });
    AppMethodBeat.o(323342);
  }
  
  public static long iI(boolean paramBoolean)
  {
    AppMethodBeat.i(323304);
    if (paramBoolean)
    {
      long l2 = AppBrandGlobalSystemConfig.ckD().qXi.qXX;
      l1 = l2;
      if (l2 <= 0L) {
        l1 = 30L;
      }
      Log.i("MicroMsg.WxaAttrSyncHelper", "getSyncFreq forInvalidContact, return %d", new Object[] { Long.valueOf(l1) });
      AppMethodBeat.o(323304);
      return l1;
    }
    long l1 = com.tencent.mm.k.i.aRC().getInt("MMBizAttrSyncFreq", 3600);
    AppMethodBeat.o(323304);
    return l1;
  }
  
  static abstract interface a<T>
  {
    public static final String[] rbu = { "username", "appId", "versionInfo", "appInfo", "syncTimeSecond", "syncVersion", "smallHeadURL", "nickname", "dynamicInfo", "passThroughInfo" };
    
    public abstract r XR(String paramString);
    
    public abstract T XS(String paramString);
    
    public abstract boolean dT(T paramT);
    
    public abstract String getUsername();
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(a parama, T paramT);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(323499);
        rbv = new a("RET_HIT_FREQUENCY_LIMIT", 0);
        rbw = new a("RET_UPDATED", 1);
        rbx = new a("RET_NO_UPDATE", 2);
        rby = new a("RET_CGI_FAIL", 3);
        rbz = new a[] { rbv, rbw, rbx, rby };
        AppMethodBeat.o(323499);
      }
      
      private a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract String ckZ();
    
    public abstract int cla();
    
    public abstract aeo clb();
  }
  
  public static abstract interface d
  {
    public abstract void done();
  }
  
  public static abstract interface e
    extends ag.d
  {
    public abstract void cQ(List<String> paramList);
  }
  
  public static abstract interface f
  {
    public abstract void clc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.ag
 * JD-Core Version:    0.7.0.1
 */