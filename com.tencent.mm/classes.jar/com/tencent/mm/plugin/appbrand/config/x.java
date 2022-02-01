package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.y.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.eid;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.vending.g.c.a;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class x
{
  public static boolean Or(String paramString)
  {
    AppMethodBeat.i(44926);
    if (j.aZl() == null)
    {
      ae.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr(%s), storage NULL", new Object[] { paramString });
      AppMethodBeat.o(44926);
      return false;
    }
    long l2 = bu.aRi();
    WxaAttributes localWxaAttributes = j.aZl().d(paramString, new String[] { "syncTimeSecond" });
    if (localWxaAttributes == null) {}
    for (long l1 = 0L;; l1 = localWxaAttributes.field_syncTimeSecond)
    {
      int i = beR();
      if (ae.getLogLevel() <= 0) {
        ae.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[] { paramString, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
      }
      if (l2 - l1 < i) {
        break;
      }
      AppMethodBeat.o(44926);
      return true;
    }
    AppMethodBeat.o(44926);
    return false;
  }
  
  private static boolean Os(String paramString)
  {
    AppMethodBeat.i(44927);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44927);
      return false;
    }
    if (!m.zd(paramString))
    {
      ae.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[] { paramString, au.o(new Throwable()) });
      com.tencent.mm.plugin.report.service.g.yxI.dD(648, 1);
      AppMethodBeat.o(44927);
      return true;
    }
    AppMethodBeat.o(44927);
    return false;
  }
  
  public static void Ot(String paramString)
  {
    AppMethodBeat.i(44928);
    if (Os(paramString))
    {
      AppMethodBeat.o(44928);
      return;
    }
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44910);
        x.Ou(this.fOj);
        AppMethodBeat.o(44910);
      }
    });
    AppMethodBeat.o(44928);
  }
  
  public static void Ou(String paramString)
  {
    AppMethodBeat.i(44933);
    if (Os(paramString))
    {
      AppMethodBeat.o(44933);
      return;
    }
    if (Or(paramString)) {
      b(paramString, true, null);
    }
    AppMethodBeat.o(44933);
  }
  
  public static Pair<WxaAttributes, a.a> a(String paramString, boolean paramBoolean, e parame)
  {
    AppMethodBeat.i(44929);
    paramString = a(paramString, paramBoolean, parame, new a()
    {
      public final o Ov(String paramAnonymousString)
      {
        AppMethodBeat.i(44913);
        paramAnonymousString = new o(null, paramAnonymousString);
        AppMethodBeat.o(44913);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        AppMethodBeat.i(44912);
        String str = v.Oo(this.val$appId);
        AppMethodBeat.o(44912);
        return str;
      }
    }, null);
    AppMethodBeat.o(44929);
    return paramString;
  }
  
  static <T> Pair<T, a.a> a(String paramString, boolean paramBoolean, e parame, a<T> parama, PBool paramPBool)
  {
    a.a locala = null;
    AppMethodBeat.i(222240);
    if ((bu.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.ajP().gDk))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(222240);
      return paramString;
    }
    Object localObject;
    if (!paramBoolean)
    {
      localObject = parama.Ow(paramString);
      if ((localObject != null) && (!parama.cp(localObject))) {}
    }
    for (;;)
    {
      if (parame != null) {
        parame.beS();
      }
      locala = parama.Ov(paramString).bsz();
      int i;
      int j;
      if ((locala == null) || ((locala instanceof y.a)) || (locala.errType != 0) || (locala.errCode != 0)) {
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
          parame = "null resp";
          label141:
          ae.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), parame });
          if (localObject != null) {
            break label577;
          }
          paramString = parama.Ow(paramString);
          if (paramString == null) {
            break label239;
          }
        }
      }
      for (;;)
      {
        paramString = Pair.create(paramString, locala);
        AppMethodBeat.o(222240);
        return paramString;
        i = locala.errType;
        break;
        label220:
        j = locala.errCode;
        break label133;
        label230:
        parame = locala.errMsg;
        break label141;
        label239:
        paramString = Pair.create(null, locala);
        AppMethodBeat.o(222240);
        return paramString;
        parame = ((eid)locala.hQv).FZc.iterator();
        for (;;)
        {
          if (parame.hasNext())
          {
            localObject = (eic)parame.next();
            if ("UserName".equalsIgnoreCase(((eic)localObject).uuW))
            {
              localObject = ((eic)localObject).yxn;
              parame = (e)localObject;
              if (((String)localObject).endsWith("@app")) {
                break;
              }
            }
          }
        }
        for (parame = (String)localObject + "@app";; parame = null)
        {
          localObject = parame;
          if (bu.isNullOrNil(parame))
          {
            parame = parama.getUsername();
            localObject = parame;
            if (bu.isNullOrNil(parame))
            {
              ae.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[] { Boolean.valueOf(paramBoolean), paramString });
              paramString = Pair.create(null, null);
              AppMethodBeat.o(222240);
              return paramString;
            }
          }
          ae.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync key(%s), username(%s), flushAttrs", new Object[] { paramString, localObject });
          if (j.aZl().a((String)localObject, ((eid)locala.hQv).FZb, ((eid)locala.hQv).FZc))
          {
            v.beQ().n("single", localObject);
            if (paramPBool != null) {
              paramPBool.value = true;
            }
          }
          localObject = parama.Ow(paramString);
          ae.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
          co(localObject);
          for (paramString = locala;; paramString = locala)
          {
            paramString = Pair.create(localObject, paramString);
            AppMethodBeat.o(222240);
            return paramString;
            ae.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
            co(localObject);
          }
        }
        label577:
        paramString = (String)localObject;
      }
      localObject = null;
    }
  }
  
  public static com.tencent.mm.vending.g.e<List<String>> a(List<String> paramList, final n.a parama, final c paramc)
  {
    AppMethodBeat.i(222243);
    ae.i("MicroMsg.WxaAttrSyncHelper", "batchSync before real logic, list_size:%d, scene:%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(parama.intValue) });
    if (bu.ht(paramList))
    {
      paramList = com.tencent.mm.cm.g.eu(Collections.emptyList());
      AppMethodBeat.o(222243);
      return paramList;
    }
    if (ag.Ck())
    {
      paramList = com.tencent.mm.cm.g.fWL().j(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(222243);
      return paramList;
    }
    Object localObject = paramList;
    if (!(paramList instanceof ArrayList)) {
      if (!(paramList instanceof LinkedList)) {
        break label174;
      }
    }
    label174:
    for (localObject = paramList;; localObject = new LinkedList(paramList))
    {
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((TextUtils.isEmpty(str)) || (!an.zd(str)) || (!Or(str))) {
          paramList.remove();
        }
      }
    }
    if (bu.ht((List)localObject))
    {
      if (paramc != null) {
        paramc.done();
      }
      paramList = com.tencent.mm.cm.g.eu(Collections.emptyList());
      AppMethodBeat.o(222243);
      return paramList;
    }
    ae.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(((List)localObject).size()), parama.name(), Integer.valueOf(parama.intValue) });
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
    if ((paramc instanceof d)) {
      ((d)paramc).aY((List)localObject);
    }
    paramList = com.tencent.mm.cm.g.c(new c.a() {});
    AppMethodBeat.o(222243);
    return paramList;
  }
  
  public static void a(String paramString, final boolean paramBoolean, final b<WxaAttributes> paramb)
  {
    AppMethodBeat.i(44932);
    if (Os(paramString))
    {
      AppMethodBeat.o(44932);
      return;
    }
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44922);
        Object localObject1 = new PBool();
        Object localObject2 = this.fOj;
        boolean bool;
        if ((paramBoolean) && (x.Or(this.fOj)))
        {
          bool = true;
          localObject2 = x.a((String)localObject2, bool, null, new x.a()
          {
            public final o Ov(String paramAnonymous2String)
            {
              AppMethodBeat.i(44919);
              paramAnonymous2String = new o(paramAnonymous2String, null);
              AppMethodBeat.o(44919);
              return paramAnonymous2String;
            }
            
            public final String getUsername()
            {
              return x.5.this.fOj;
            }
          }, (PBool)localObject1);
          if (paramb != null)
          {
            if (((Pair)localObject2).second != null) {
              break label96;
            }
            localObject1 = x.b.a.kcE;
          }
        }
        for (;;)
        {
          paramb.a((x.b.a)localObject1, ((Pair)localObject2).first);
          AppMethodBeat.o(44922);
          return;
          bool = false;
          break;
          label96:
          if ((((a.a)((Pair)localObject2).second).errType != 0) || (((a.a)((Pair)localObject2).second).errCode != 0)) {
            localObject1 = x.b.a.kcH;
          } else if (((PBool)localObject1).value) {
            localObject1 = x.b.a.kcF;
          } else {
            localObject1 = x.b.a.kcG;
          }
        }
      }
    });
    AppMethodBeat.o(44932);
  }
  
  public static Pair<WxaAttributes, a.a> b(String paramString, boolean paramBoolean, e parame)
  {
    AppMethodBeat.i(44931);
    if (Os(paramString))
    {
      paramString = new Pair(null, null);
      AppMethodBeat.o(44931);
      return paramString;
    }
    paramString = a(paramString, paramBoolean, parame, new a()
    {
      public final o Ov(String paramAnonymousString)
      {
        AppMethodBeat.i(44916);
        paramAnonymousString = new o(paramAnonymousString, null);
        AppMethodBeat.o(44916);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        return this.fOj;
      }
    }, null);
    AppMethodBeat.o(44931);
    return paramString;
  }
  
  public static com.tencent.mm.vending.g.e<List<String>> b(List<String> paramList, n.a parama)
  {
    AppMethodBeat.i(224362);
    paramList = a(paramList, parama, null);
    AppMethodBeat.o(224362);
    return paramList;
  }
  
  public static int beR()
  {
    AppMethodBeat.i(222239);
    int i = com.tencent.mm.n.g.acL().getInt("MMBizAttrSyncFreq", 3600);
    AppMethodBeat.o(222239);
    return i;
  }
  
  private static com.tencent.mm.vending.g.e<List<String>> c(List<String> paramList, n.a parama)
  {
    AppMethodBeat.i(222244);
    if (bu.ht(paramList))
    {
      paramList = com.tencent.mm.cm.g.eu(Collections.emptyList());
      AppMethodBeat.o(222244);
      return paramList;
    }
    paramList = new n(paramList, parama).aET().i(new com.tencent.mm.vending.c.a()
    {
      private List<String> d(a.a<kv> paramAnonymousa)
      {
        AppMethodBeat.i(222234);
        if ((paramAnonymousa.errType != 0) || (paramAnonymousa.errCode != 0))
        {
          ae.e("MicroMsg.WxaAttrSyncHelper", "BatchWxaAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
          paramAnonymousa = Collections.emptyList();
          AppMethodBeat.o(222234);
          return paramAnonymousa;
        }
        if (paramAnonymousa.hQv != null) {}
        try
        {
          w localw = j.aZl();
          if (!localw.beO())
          {
            ae.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync storage can not work");
            paramAnonymousa = Collections.emptyList();
            AppMethodBeat.o(222234);
            return paramAnonymousa;
          }
          localw.a((kv)paramAnonymousa.hQv, null);
        }
        catch (NullPointerException paramAnonymousa)
        {
          while (j.aZh() == null) {}
          AppMethodBeat.o(222234);
          throw paramAnonymousa;
        }
        catch (com.tencent.mm.model.b paramAnonymousa)
        {
          break label130;
        }
        paramAnonymousa = this.kcv;
        AppMethodBeat.o(222234);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(222244);
    return paramList;
  }
  
  private static <T> void co(T paramT)
  {
    AppMethodBeat.i(222241);
    if ((paramT instanceof WxaAttributes))
    {
      ((WxaAttributes)paramT).beY();
      AppMethodBeat.o(222241);
      return;
    }
    ae.i("MicroMsg.WxaAttrSyncHelper", "printContact %s", new Object[] { paramT });
    AppMethodBeat.o(222241);
  }
  
  static abstract interface a<T>
  {
    public abstract o Ov(String paramString);
    
    public abstract T Ow(String paramString);
    
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
        AppMethodBeat.i(222238);
        kcE = new a("RET_HIT_FREQUENCY_LIMIT", 0);
        kcF = new a("RET_UPDATED", 1);
        kcG = new a("RET_NO_UPDATE", 2);
        kcH = new a("RET_CGI_FAIL", 3);
        kcI = new a[] { kcE, kcF, kcG, kcH };
        AppMethodBeat.o(222238);
      }
      
      private a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract void done();
  }
  
  public static abstract interface d
    extends x.c
  {
    public abstract void aY(List<String> paramList);
  }
  
  public static abstract interface e
  {
    public abstract void beS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.x
 * JD-Core Version:    0.7.0.1
 */