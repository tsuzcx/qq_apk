package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.y;
import com.tencent.mm.al.y.a;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.duq;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class w
{
  public static boolean Gm(String paramString)
  {
    AppMethodBeat.i(44926);
    if (j.aOC() == null)
    {
      ad.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, storage NULL");
      AppMethodBeat.o(44926);
      return false;
    }
    long l2 = bt.aGK();
    WxaAttributes localWxaAttributes = j.aOC().d(paramString, new String[] { "syncTimeSecond" });
    if (localWxaAttributes == null) {}
    for (long l1 = 0L;; l1 = localWxaAttributes.field_syncTimeSecond)
    {
      int i = com.tencent.mm.m.g.Zd().getInt("MMBizAttrSyncFreq", 3600);
      ad.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[] { paramString, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
      if (l2 - l1 < i) {
        break;
      }
      AppMethodBeat.o(44926);
      return true;
    }
    AppMethodBeat.o(44926);
    return false;
  }
  
  private static boolean Gn(String paramString)
  {
    AppMethodBeat.i(44927);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44927);
      return false;
    }
    if (!m.rz(paramString))
    {
      ad.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[] { paramString, at.m(new Throwable()) });
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(648L, 1L, 1L, false);
      AppMethodBeat.o(44927);
      return true;
    }
    AppMethodBeat.o(44927);
    return false;
  }
  
  public static void Go(String paramString)
  {
    AppMethodBeat.i(44928);
    if (Gn(paramString))
    {
      AppMethodBeat.o(44928);
      return;
    }
    h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44910);
        w.Gp(this.fqK);
        AppMethodBeat.o(44910);
      }
    });
    AppMethodBeat.o(44928);
  }
  
  public static void Gp(String paramString)
  {
    AppMethodBeat.i(44933);
    if (Gn(paramString))
    {
      AppMethodBeat.o(44933);
      return;
    }
    if (Gm(paramString)) {
      b(paramString, true, null);
    }
    AppMethodBeat.o(44933);
  }
  
  public static Pair<WxaAttributes, com.tencent.mm.al.c.a> a(String paramString, boolean paramBoolean, c paramc)
  {
    AppMethodBeat.i(44929);
    paramString = a(paramString, paramBoolean, paramc, new a()
    {
      public final o Gq(String paramAnonymousString)
      {
        AppMethodBeat.i(44913);
        paramAnonymousString = new o(null, paramAnonymousString);
        AppMethodBeat.o(44913);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        AppMethodBeat.i(44912);
        String str = u.Gj(this.val$appId);
        AppMethodBeat.o(44912);
        return str;
      }
    }, null);
    AppMethodBeat.o(44929);
    return paramString;
  }
  
  static <T> Pair<T, com.tencent.mm.al.c.a> a(String paramString, boolean paramBoolean, c paramc, a<T> parama, PBool paramPBool)
  {
    com.tencent.mm.al.c.a locala = null;
    AppMethodBeat.i(195701);
    if ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.afz().gcn))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(195701);
      return paramString;
    }
    Object localObject;
    if (!paramBoolean)
    {
      localObject = parama.Gr(paramString);
      if ((localObject != null) && (!parama.cp(localObject))) {}
    }
    for (;;)
    {
      if (paramc != null) {
        paramc.aTM();
      }
      locala = y.e(parama.Gq(paramString).rr);
      int i;
      int j;
      if ((locala == null) || ((locala instanceof y.a)) || (locala.errType != 0) || (locala.errCode != 0)) {
        if (locala == null)
        {
          i = -1;
          if (locala != null) {
            break label223;
          }
          j = -1;
          label136:
          if (locala != null) {
            break label233;
          }
          paramc = "null resp";
          label144:
          ad.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), paramc });
          if (localObject != null) {
            break label580;
          }
          paramString = parama.Gr(paramString);
          if (paramString == null) {
            break label242;
          }
        }
      }
      for (;;)
      {
        paramString = Pair.create(paramString, locala);
        AppMethodBeat.o(195701);
        return paramString;
        i = locala.errType;
        break;
        label223:
        j = locala.errCode;
        break label136;
        label233:
        paramc = locala.errMsg;
        break label144;
        label242:
        paramString = Pair.create(null, locala);
        AppMethodBeat.o(195701);
        return paramString;
        paramc = ((dur)locala.gUK).CIv.iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            localObject = (duq)paramc.next();
            if ("UserName".equalsIgnoreCase(((duq)localObject).sdv))
            {
              localObject = ((duq)localObject).vJI;
              paramc = (c)localObject;
              if (((String)localObject).endsWith("@app")) {
                break;
              }
            }
          }
        }
        for (paramc = (String)localObject + "@app";; paramc = null)
        {
          localObject = paramc;
          if (bt.isNullOrNil(paramc))
          {
            paramc = parama.getUsername();
            localObject = paramc;
            if (bt.isNullOrNil(paramc))
            {
              ad.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[] { Boolean.valueOf(paramBoolean), paramString });
              paramString = Pair.create(null, null);
              AppMethodBeat.o(195701);
              return paramString;
            }
          }
          ad.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync key(%s), username(%s), flushAttrs", new Object[] { paramString, localObject });
          if (j.aOC().a((String)localObject, ((dur)locala.gUK).CIu, ((dur)locala.gUK).CIv))
          {
            u.aTL().p("single", localObject);
            if (paramPBool != null) {
              paramPBool.value = true;
            }
          }
          localObject = parama.Gr(paramString);
          ad.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
          co(localObject);
          for (paramString = locala;; paramString = locala)
          {
            paramString = Pair.create(localObject, paramString);
            AppMethodBeat.o(195701);
            return paramString;
            ad.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
            co(localObject);
          }
        }
        label580:
        paramString = (String)localObject;
      }
      localObject = null;
    }
  }
  
  public static void a(String paramString, final boolean paramBoolean, final b<WxaAttributes> paramb)
  {
    AppMethodBeat.i(44932);
    if (Gn(paramString))
    {
      AppMethodBeat.o(44932);
      return;
    }
    h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44922);
        Object localObject1 = new PBool();
        Object localObject2 = this.fqK;
        boolean bool;
        if ((paramBoolean) && (w.Gm(this.fqK)))
        {
          bool = true;
          localObject2 = w.a((String)localObject2, bool, null, new w.a()
          {
            public final o Gq(String paramAnonymous2String)
            {
              AppMethodBeat.i(44919);
              paramAnonymous2String = new o(paramAnonymous2String, null);
              AppMethodBeat.o(44919);
              return paramAnonymous2String;
            }
            
            public final String getUsername()
            {
              return w.5.this.fqK;
            }
          }, (PBool)localObject1);
          if (paramb != null)
          {
            if (((Pair)localObject2).second != null) {
              break label96;
            }
            localObject1 = w.b.a.jeT;
          }
        }
        for (;;)
        {
          paramb.a((w.b.a)localObject1, ((Pair)localObject2).first);
          AppMethodBeat.o(44922);
          return;
          bool = false;
          break;
          label96:
          if ((((com.tencent.mm.al.c.a)((Pair)localObject2).second).errType != 0) || (((com.tencent.mm.al.c.a)((Pair)localObject2).second).errCode != 0)) {
            localObject1 = w.b.a.jeW;
          } else if (((PBool)localObject1).value) {
            localObject1 = w.b.a.jeU;
          } else {
            localObject1 = w.b.a.jeV;
          }
        }
      }
    });
    AppMethodBeat.o(44932);
  }
  
  public static Pair<WxaAttributes, com.tencent.mm.al.c.a> b(String paramString, boolean paramBoolean, c paramc)
  {
    AppMethodBeat.i(44931);
    if (Gn(paramString))
    {
      paramString = new Pair(null, null);
      AppMethodBeat.o(44931);
      return paramString;
    }
    paramString = a(paramString, paramBoolean, paramc, new a()
    {
      public final o Gq(String paramAnonymousString)
      {
        AppMethodBeat.i(44916);
        paramAnonymousString = new o(paramAnonymousString, null);
        AppMethodBeat.o(44916);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        return this.fqK;
      }
    }, null);
    AppMethodBeat.o(44931);
    return paramString;
  }
  
  public static com.tencent.mm.vending.g.e<List<String>> c(List<String> paramList, final n.a parama)
  {
    AppMethodBeat.i(195703);
    ad.i("MicroMsg.WxaAttrSyncHelper", "batchSync before real logic, list_size:%d, scene:%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(parama.intValue) });
    if (bt.gL(paramList))
    {
      paramList = com.tencent.mm.co.g.en(Collections.emptyList());
      AppMethodBeat.o(195703);
      return paramList;
    }
    if (aa.Be())
    {
      paramList = com.tencent.mm.co.g.fkM().j(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(195703);
      return paramList;
    }
    Object localObject = paramList;
    if (!(paramList instanceof ArrayList)) {
      if (!(paramList instanceof LinkedList)) {
        break label173;
      }
    }
    label173:
    for (localObject = paramList;; localObject = new LinkedList(paramList))
    {
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((TextUtils.isEmpty(str)) || (!af.rz(str)) || (!Gm(str))) {
          paramList.remove();
        }
      }
    }
    if (bt.gL((List)localObject))
    {
      paramList = com.tencent.mm.co.g.en(Collections.emptyList());
      AppMethodBeat.o(195703);
      return paramList;
    }
    ad.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(((List)localObject).size()), parama.name(), Integer.valueOf(parama.intValue) });
    paramList = new LinkedList();
    int i = 0;
    int j = 0;
    while (i < ((List)localObject).size() / 20)
    {
      int k = i * 20;
      j = k + 20;
      paramList.add(d(((List)localObject).subList(k, j), parama));
      i += 1;
    }
    if (j < ((List)localObject).size()) {
      paramList.add(d(((List)localObject).subList(j, ((List)localObject).size()), parama));
    }
    paramList = com.tencent.mm.co.g.c(new com.tencent.mm.vending.g.c.a() {});
    AppMethodBeat.o(195703);
    return paramList;
  }
  
  private static <T> void co(T paramT)
  {
    AppMethodBeat.i(195702);
    if ((paramT instanceof WxaAttributes))
    {
      ((WxaAttributes)paramT).aTS();
      AppMethodBeat.o(195702);
      return;
    }
    ad.i("MicroMsg.WxaAttrSyncHelper", "printContact %s", new Object[] { paramT });
    AppMethodBeat.o(195702);
  }
  
  private static com.tencent.mm.vending.g.e<List<String>> d(List<String> paramList, n.a parama)
  {
    AppMethodBeat.i(195704);
    if (bt.gL(paramList))
    {
      paramList = com.tencent.mm.co.g.en(Collections.emptyList());
      AppMethodBeat.o(195704);
      return paramList;
    }
    paramList = new n(paramList, parama).auK().i(new com.tencent.mm.vending.c.a()
    {
      private List<String> a(a.a<kg> paramAnonymousa)
      {
        AppMethodBeat.i(195696);
        if ((paramAnonymousa.errType != 0) || (paramAnonymousa.errCode != 0))
        {
          ad.e("MicroMsg.WxaAttrSyncHelper", "BatchWxaAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
          paramAnonymousa = Collections.emptyList();
          AppMethodBeat.o(195696);
          return paramAnonymousa;
        }
        if (paramAnonymousa.gUK != null) {}
        try
        {
          v localv = j.aOC();
          if (!localv.aTJ())
          {
            ad.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync storage can not work");
            paramAnonymousa = Collections.emptyList();
            AppMethodBeat.o(195696);
            return paramAnonymousa;
          }
          localv.a((kg)paramAnonymousa.gUK);
        }
        catch (NullPointerException paramAnonymousa)
        {
          while (j.aOy() == null) {}
          AppMethodBeat.o(195696);
          throw paramAnonymousa;
        }
        catch (com.tencent.mm.model.b paramAnonymousa)
        {
          break label129;
        }
        paramAnonymousa = this.jeL;
        AppMethodBeat.o(195696);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(195704);
    return paramList;
  }
  
  static abstract interface a<T>
  {
    public abstract o Gq(String paramString);
    
    public abstract T Gr(String paramString);
    
    public abstract boolean cp(T paramT);
    
    public abstract String getUsername();
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(a parama, T paramT);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(195700);
        jeT = new a("RET_HIT_FREQUENCY_LIMIT", 0);
        jeU = new a("RET_UPDATED", 1);
        jeV = new a("RET_NO_UPDATE", 2);
        jeW = new a("RET_CGI_FAIL", 3);
        jeX = new a[] { jeT, jeU, jeV, jeW };
        AppMethodBeat.o(195700);
      }
      
      private a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract void aTM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.w
 * JD-Core Version:    0.7.0.1
 */