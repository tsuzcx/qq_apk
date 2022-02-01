package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.ak.ab.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.fcu;
import com.tencent.mm.protocal.protobuf.fcv;
import com.tencent.mm.protocal.protobuf.lm;
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
  public static boolean XB(String paramString)
  {
    AppMethodBeat.i(44926);
    if (n.buC() == null)
    {
      Log.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr(%s), storage NULL", new Object[] { paramString });
      AppMethodBeat.o(44926);
      return false;
    }
    long l1 = Util.nowSecond();
    long l2 = n.buC().Xo(paramString);
    int i = bAk();
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
  
  private static boolean XC(String paramString)
  {
    AppMethodBeat.i(44927);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44927);
      return false;
    }
    if (!m.HF(paramString))
    {
      Log.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[] { paramString, MMStack.stackTraceToString(new Throwable()) });
      com.tencent.mm.plugin.report.service.h.CyF.dN(648, 1);
      AppMethodBeat.o(44927);
      return true;
    }
    AppMethodBeat.o(44927);
    return false;
  }
  
  public static void XD(String paramString)
  {
    AppMethodBeat.i(44928);
    if (XC(paramString))
    {
      AppMethodBeat.o(44928);
      return;
    }
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44910);
        aa.XE(this.gtu);
        AppMethodBeat.o(44910);
      }
    });
    AppMethodBeat.o(44928);
  }
  
  public static void XE(String paramString)
  {
    AppMethodBeat.i(44933);
    if (XC(paramString))
    {
      AppMethodBeat.o(44933);
      return;
    }
    if (XB(paramString)) {
      b(paramString, true, null, null);
    }
    AppMethodBeat.o(44933);
  }
  
  static <T> Pair<T, com.tencent.mm.ak.c.a<fcv>> a(String paramString, boolean paramBoolean, f paramf, a<T> parama, PBool paramPBool)
  {
    com.tencent.mm.ak.c.a locala = null;
    AppMethodBeat.i(226496);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.aAf().hpY))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(226496);
      return paramString;
    }
    Object localObject;
    if (!paramBoolean)
    {
      localObject = parama.XG(paramString);
      if ((localObject != null) && (!parama.cy(localObject))) {}
    }
    for (;;)
    {
      if (paramf != null) {
        paramf.bAm();
      }
      locala = parama.XF(paramString).bNV();
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
            break label578;
          }
          paramString = parama.XG(paramString);
          if (paramString == null) {
            break label239;
          }
        }
      }
      for (;;)
      {
        paramString = Pair.create(paramString, locala);
        AppMethodBeat.o(226496);
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
        AppMethodBeat.o(226496);
        return paramString;
        paramf = ((fcv)locala.iLC).KSX.iterator();
        for (;;)
        {
          if (paramf.hasNext())
          {
            localObject = (fcu)paramf.next();
            if ("UserName".equalsIgnoreCase(((fcu)localObject).xMX))
            {
              localObject = ((fcu)localObject).Cyk;
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
              AppMethodBeat.o(226496);
              return paramString;
            }
          }
          Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync key(%s), username(%s), flushAttrs", new Object[] { paramString, localObject });
          if (n.buC().a((String)localObject, ((fcv)locala.iLC).KSW, ((fcv)locala.iLC).KSX))
          {
            y.bAj().doNotify("single", 3, localObject);
            if (paramPBool != null) {
              paramPBool.value = true;
            }
          }
          localObject = parama.XG(paramString);
          Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
          cx(localObject);
          for (paramString = locala;; paramString = locala)
          {
            paramString = Pair.create(localObject, paramString);
            AppMethodBeat.o(226496);
            return paramString;
            Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
            cx(localObject);
          }
        }
        label578:
        paramString = (String)localObject;
      }
      localObject = null;
    }
  }
  
  public static Pair<WxaAttributes, com.tencent.mm.ak.c.a<fcv>> a(String paramString, boolean paramBoolean, f paramf, final c paramc)
  {
    AppMethodBeat.i(226495);
    paramString = a(paramString, paramBoolean, paramf, new a()
    {
      public final p XF(String paramAnonymousString)
      {
        AppMethodBeat.i(226477);
        if (paramc != null)
        {
          paramAnonymousString = new p(null, paramAnonymousString, paramc.aiv(), paramc.bAl());
          AppMethodBeat.o(226477);
          return paramAnonymousString;
        }
        paramAnonymousString = new p(null, paramAnonymousString);
        AppMethodBeat.o(226477);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        AppMethodBeat.i(226476);
        String str = y.Xy(this.val$appId);
        AppMethodBeat.o(226476);
        return str;
      }
    }, null);
    AppMethodBeat.o(226495);
    return paramString;
  }
  
  public static e<List<String>> a(List<String> paramList, final o.a parama, final d paramd)
  {
    AppMethodBeat.i(226502);
    Log.i("MicroMsg.WxaAttrSyncHelper", "batchSync before real logic, list_size:%d, scene:%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(parama.intValue) });
    if (Util.isNullOrNil(paramList))
    {
      paramList = com.tencent.mm.co.g.ey(Collections.emptyList());
      AppMethodBeat.o(226502);
      return paramList;
    }
    if (ag.LB())
    {
      paramList = com.tencent.mm.co.g.hio().j(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(226502);
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
      if ((TextUtils.isEmpty(str)) || (!as.HF(str)))
      {
        paramList.remove();
        continue;
        localObject = new LinkedList(paramList);
        break;
      }
      if (org.apache.commons.b.a.contains(com.tencent.mm.plugin.appbrand.appcache.predownload.h.kPj, parama))
      {
        if (!a(str, parama)) {
          paramList.remove();
        }
      }
      else if (!XB(str)) {
        paramList.remove();
      }
    }
    label224:
    if (Util.isNullOrNil((List)localObject))
    {
      if (paramd != null) {
        paramd.done();
      }
      paramList = com.tencent.mm.co.g.ey(Collections.emptyList());
      AppMethodBeat.o(226502);
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
      ((e)paramd).bj((List)localObject);
    }
    paramList = com.tencent.mm.co.g.c(new com.tencent.mm.vending.g.c.a() {});
    AppMethodBeat.o(226502);
    return paramList;
  }
  
  public static void a(String paramString, b<WxaAttributes> paramb)
  {
    AppMethodBeat.i(226499);
    a(paramString, true, paramb);
    AppMethodBeat.o(226499);
  }
  
  public static void a(String paramString, final boolean paramBoolean, final b<WxaAttributes> paramb)
  {
    AppMethodBeat.i(226500);
    if (XC(paramString))
    {
      AppMethodBeat.o(226500);
      return;
    }
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226483);
        Object localObject1 = new PBool();
        Object localObject2 = this.gtu;
        boolean bool;
        if ((paramBoolean) && (aa.XB(this.gtu)))
        {
          bool = true;
          localObject2 = aa.a((String)localObject2, bool, null, new aa.a()
          {
            public final p XF(String paramAnonymous2String)
            {
              AppMethodBeat.i(226480);
              paramAnonymous2String = new p(paramAnonymous2String, null);
              AppMethodBeat.o(226480);
              return paramAnonymous2String;
            }
            
            public final String getUsername()
            {
              return aa.4.this.gtu;
            }
          }, (PBool)localObject1);
          if (paramb != null)
          {
            if (((Pair)localObject2).second != null) {
              break label96;
            }
            localObject1 = aa.b.a.lgj;
          }
        }
        for (;;)
        {
          paramb.a((aa.b.a)localObject1, ((Pair)localObject2).first);
          AppMethodBeat.o(226483);
          return;
          bool = false;
          break;
          label96:
          if ((((com.tencent.mm.ak.c.a)((Pair)localObject2).second).errType != 0) || (((com.tencent.mm.ak.c.a)((Pair)localObject2).second).errCode != 0)) {
            localObject1 = aa.b.a.lgm;
          } else if (((PBool)localObject1).value) {
            localObject1 = aa.b.a.lgk;
          } else {
            localObject1 = aa.b.a.lgl;
          }
        }
      }
    });
    AppMethodBeat.o(226500);
  }
  
  private static boolean a(String paramString, o.a parama)
  {
    AppMethodBeat.i(226494);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(226494);
      return false;
    }
    if (!XB(paramString))
    {
      AppMethodBeat.o(226494);
      return false;
    }
    com.tencent.mm.plugin.appbrand.appcache.predownload.e.g localg = ((com.tencent.mm.plugin.appbrand.appcache.predownload.e.h)n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.e.h.class)).VG(paramString);
    if (localg != null)
    {
      WxaAttributes localWxaAttributes = n.buC().d(paramString, new String[] { "versionInfo" });
      if ((localWxaAttributes != null) && (localWxaAttributes.bAp() != null) && (localWxaAttributes.bAp().cyu == 0) && (localg.field_appVersion <= localWxaAttributes.bAp().appVersion))
      {
        Log.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttrWithUsernameForBatchPreload, username(%s) scene(%s) notifyVersion(%d) appVersion(%d) return false", new Object[] { paramString, parama.name(), Integer.valueOf(localg.field_appVersion), Integer.valueOf(localWxaAttributes.bAp().appVersion) });
        AppMethodBeat.o(226494);
        return false;
      }
    }
    AppMethodBeat.o(226494);
    return true;
  }
  
  public static Pair<WxaAttributes, com.tencent.mm.ak.c.a<fcv>> b(String paramString, boolean paramBoolean, f paramf, final c paramc)
  {
    AppMethodBeat.i(226498);
    if (XC(paramString))
    {
      paramString = new Pair(null, null);
      AppMethodBeat.o(226498);
      return paramString;
    }
    paramString = a(paramString, paramBoolean, paramf, new a()
    {
      public final p XF(String paramAnonymousString)
      {
        AppMethodBeat.i(44913);
        if (paramc != null)
        {
          paramAnonymousString = new p(paramAnonymousString, null, paramc.aiv(), paramc.bAl());
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
        String str = this.gtu;
        AppMethodBeat.o(44912);
        return str;
      }
    }, null);
    AppMethodBeat.o(226498);
    return paramString;
  }
  
  public static e<List<String>> b(List<String> paramList, o.a parama)
  {
    AppMethodBeat.i(258361);
    paramList = a(paramList, parama, null);
    AppMethodBeat.o(258361);
    return paramList;
  }
  
  public static int bAk()
  {
    AppMethodBeat.i(226493);
    int i = com.tencent.mm.n.h.aqJ().getInt("MMBizAttrSyncFreq", 3600);
    AppMethodBeat.o(226493);
    return i;
  }
  
  private static e<List<String>> c(List<String> paramList, o.a parama)
  {
    AppMethodBeat.i(226503);
    if (Util.isNullOrNil(paramList))
    {
      paramList = com.tencent.mm.co.g.ey(Collections.emptyList());
      AppMethodBeat.o(226503);
      return paramList;
    }
    paramList = new o(paramList, parama).aYI().i(new com.tencent.mm.vending.c.a()
    {
      private List<String> c(com.tencent.mm.ak.c.a<lm> paramAnonymousa)
      {
        AppMethodBeat.i(226489);
        if ((paramAnonymousa.errType != 0) || (paramAnonymousa.errCode != 0))
        {
          Log.e("MicroMsg.WxaAttrSyncHelper", "BatchWxaAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
          paramAnonymousa = Collections.emptyList();
          AppMethodBeat.o(226489);
          return paramAnonymousa;
        }
        if (paramAnonymousa.iLC != null) {}
        try
        {
          z localz = n.buC();
          if (!localz.bAh())
          {
            Log.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync storage can not work");
            paramAnonymousa = Collections.emptyList();
            AppMethodBeat.o(226489);
            return paramAnonymousa;
          }
          localz.a((lm)paramAnonymousa.iLC, null);
        }
        catch (NullPointerException paramAnonymousa)
        {
          while (n.buy() == null) {}
          AppMethodBeat.o(226489);
          throw paramAnonymousa;
        }
        catch (com.tencent.mm.model.b paramAnonymousa)
        {
          break label130;
        }
        paramAnonymousa = this.lga;
        AppMethodBeat.o(226489);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(226503);
    return paramList;
  }
  
  private static <T> void cx(T paramT)
  {
    AppMethodBeat.i(226497);
    if ((paramT instanceof WxaAttributes))
    {
      ((WxaAttributes)paramT).bAs();
      AppMethodBeat.o(226497);
      return;
    }
    Log.i("MicroMsg.WxaAttrSyncHelper", "printContact %s", new Object[] { paramT });
    AppMethodBeat.o(226497);
  }
  
  static abstract interface a<T>
  {
    public abstract p XF(String paramString);
    
    public abstract T XG(String paramString);
    
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
        AppMethodBeat.i(226492);
        lgj = new a("RET_HIT_FREQUENCY_LIMIT", 0);
        lgk = new a("RET_UPDATED", 1);
        lgl = new a("RET_NO_UPDATE", 2);
        lgm = new a("RET_CGI_FAIL", 3);
        lgn = new a[] { lgj, lgk, lgl, lgm };
        AppMethodBeat.o(226492);
      }
      
      private a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract String aiv();
    
    public abstract acc bAl();
  }
  
  public static abstract interface d
  {
    public abstract void done();
  }
  
  public static abstract interface e
    extends aa.d
  {
    public abstract void bj(List<String> paramList);
  }
  
  public static abstract interface f
  {
    public abstract void bAm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.aa
 * JD-Core Version:    0.7.0.1
 */