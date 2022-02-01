package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.y.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.protocal.protobuf.egm;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
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
  public static boolean NJ(String paramString)
  {
    AppMethodBeat.i(44926);
    if (j.aYP() == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, storage NULL");
      AppMethodBeat.o(44926);
      return false;
    }
    long l2 = bt.aQJ();
    WxaAttributes localWxaAttributes = j.aYP().d(paramString, new String[] { "syncTimeSecond" });
    if (localWxaAttributes == null) {}
    for (long l1 = 0L;; l1 = localWxaAttributes.field_syncTimeSecond)
    {
      int i = com.tencent.mm.n.g.acA().getInt("MMBizAttrSyncFreq", 3600);
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[] { paramString, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
      if (l2 - l1 < i) {
        break;
      }
      AppMethodBeat.o(44926);
      return true;
    }
    AppMethodBeat.o(44926);
    return false;
  }
  
  private static boolean NK(String paramString)
  {
    AppMethodBeat.i(44927);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44927);
      return false;
    }
    if (!m.yt(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[] { paramString, at.n(new Throwable()) });
      com.tencent.mm.plugin.report.service.g.yhR.dD(648, 1);
      AppMethodBeat.o(44927);
      return true;
    }
    AppMethodBeat.o(44927);
    return false;
  }
  
  public static void NL(String paramString)
  {
    AppMethodBeat.i(44928);
    if (NK(paramString))
    {
      AppMethodBeat.o(44928);
      return;
    }
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44910);
        x.NM(this.fNr);
        AppMethodBeat.o(44910);
      }
    });
    AppMethodBeat.o(44928);
  }
  
  public static void NM(String paramString)
  {
    AppMethodBeat.i(44933);
    if (NK(paramString))
    {
      AppMethodBeat.o(44933);
      return;
    }
    if (NJ(paramString)) {
      b(paramString, true, null);
    }
    AppMethodBeat.o(44933);
  }
  
  public static Pair<WxaAttributes, a.a> a(String paramString, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(44929);
    paramString = a(paramString, paramBoolean, paramd, new a()
    {
      public final o NN(String paramAnonymousString)
      {
        AppMethodBeat.i(44913);
        paramAnonymousString = new o(null, paramAnonymousString);
        AppMethodBeat.o(44913);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        AppMethodBeat.i(44912);
        String str = v.NG(this.val$appId);
        AppMethodBeat.o(44912);
        return str;
      }
    }, null);
    AppMethodBeat.o(44929);
    return paramString;
  }
  
  static <T> Pair<T, a.a> a(String paramString, boolean paramBoolean, d paramd, a<T> parama, PBool paramPBool)
  {
    a.a locala = null;
    AppMethodBeat.i(188115);
    if ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.ajA().gAD))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(188115);
      return paramString;
    }
    Object localObject;
    if (!paramBoolean)
    {
      localObject = parama.NO(paramString);
      if ((localObject != null) && (!parama.cp(localObject))) {}
    }
    for (;;)
    {
      if (paramd != null) {
        paramd.bek();
      }
      locala = parama.NN(paramString).brO();
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
          paramd = "null resp";
          label141:
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), paramd });
          if (localObject != null) {
            break label577;
          }
          paramString = parama.NO(paramString);
          if (paramString == null) {
            break label239;
          }
        }
      }
      for (;;)
      {
        paramString = Pair.create(paramString, locala);
        AppMethodBeat.o(188115);
        return paramString;
        i = locala.errType;
        break;
        label220:
        j = locala.errCode;
        break label133;
        label230:
        paramd = locala.errMsg;
        break label141;
        label239:
        paramString = Pair.create(null, locala);
        AppMethodBeat.o(188115);
        return paramString;
        paramd = ((egm)locala.hNC).FGG.iterator();
        for (;;)
        {
          if (paramd.hasNext())
          {
            localObject = (egl)paramd.next();
            if ("UserName".equalsIgnoreCase(((egl)localObject).ujy))
            {
              localObject = ((egl)localObject).yhw;
              paramd = (d)localObject;
              if (((String)localObject).endsWith("@app")) {
                break;
              }
            }
          }
        }
        for (paramd = (String)localObject + "@app";; paramd = null)
        {
          localObject = paramd;
          if (bt.isNullOrNil(paramd))
          {
            paramd = parama.getUsername();
            localObject = paramd;
            if (bt.isNullOrNil(paramd))
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[] { Boolean.valueOf(paramBoolean), paramString });
              paramString = Pair.create(null, null);
              AppMethodBeat.o(188115);
              return paramString;
            }
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync key(%s), username(%s), flushAttrs", new Object[] { paramString, localObject });
          if (j.aYP().a((String)localObject, ((egm)locala.hNC).FGF, ((egm)locala.hNC).FGG))
          {
            v.bej().n("single", localObject);
            if (paramPBool != null) {
              paramPBool.value = true;
            }
          }
          localObject = parama.NO(paramString);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
          co(localObject);
          for (paramString = locala;; paramString = locala)
          {
            paramString = Pair.create(localObject, paramString);
            AppMethodBeat.o(188115);
            return paramString;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
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
    AppMethodBeat.i(188118);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WxaAttrSyncHelper", "batchSync before real logic, list_size:%d, scene:%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(parama.intValue) });
    if (bt.hj(paramList))
    {
      paramList = com.tencent.mm.cn.g.er(Collections.emptyList());
      AppMethodBeat.o(188118);
      return paramList;
    }
    if (com.tencent.mm.plugin.appbrand.utils.ad.Ch())
    {
      paramList = com.tencent.mm.cn.g.fSm().j(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(188118);
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
        if ((TextUtils.isEmpty(str)) || (!am.yt(str)) || (!NJ(str))) {
          paramList.remove();
        }
      }
    }
    if (bt.hj((List)localObject))
    {
      if (paramc != null) {
        paramc.done();
      }
      paramList = com.tencent.mm.cn.g.er(Collections.emptyList());
      AppMethodBeat.o(188118);
      return paramList;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(((List)localObject).size()), parama.name(), Integer.valueOf(parama.intValue) });
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
    paramList = com.tencent.mm.cn.g.c(new c.a() {});
    AppMethodBeat.o(188118);
    return paramList;
  }
  
  public static void a(String paramString, final boolean paramBoolean, final b<WxaAttributes> paramb)
  {
    AppMethodBeat.i(44932);
    if (NK(paramString))
    {
      AppMethodBeat.o(44932);
      return;
    }
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44922);
        Object localObject1 = new PBool();
        Object localObject2 = this.fNr;
        boolean bool;
        if ((paramBoolean) && (x.NJ(this.fNr)))
        {
          bool = true;
          localObject2 = x.a((String)localObject2, bool, null, new x.a()
          {
            public final o NN(String paramAnonymous2String)
            {
              AppMethodBeat.i(44919);
              paramAnonymous2String = new o(paramAnonymous2String, null);
              AppMethodBeat.o(44919);
              return paramAnonymous2String;
            }
            
            public final String getUsername()
            {
              return x.5.this.fNr;
            }
          }, (PBool)localObject1);
          if (paramb != null)
          {
            if (((Pair)localObject2).second != null) {
              break label96;
            }
            localObject1 = x.b.a.jZn;
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
            localObject1 = x.b.a.jZq;
          } else if (((PBool)localObject1).value) {
            localObject1 = x.b.a.jZo;
          } else {
            localObject1 = x.b.a.jZp;
          }
        }
      }
    });
    AppMethodBeat.o(44932);
  }
  
  public static Pair<WxaAttributes, a.a> b(String paramString, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(44931);
    if (NK(paramString))
    {
      paramString = new Pair(null, null);
      AppMethodBeat.o(44931);
      return paramString;
    }
    paramString = a(paramString, paramBoolean, paramd, new a()
    {
      public final o NN(String paramAnonymousString)
      {
        AppMethodBeat.i(44916);
        paramAnonymousString = new o(paramAnonymousString, null);
        AppMethodBeat.o(44916);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        return this.fNr;
      }
    }, null);
    AppMethodBeat.o(44931);
    return paramString;
  }
  
  public static com.tencent.mm.vending.g.e<List<String>> c(List<String> paramList, n.a parama)
  {
    AppMethodBeat.i(221276);
    paramList = a(paramList, parama, null);
    AppMethodBeat.o(221276);
    return paramList;
  }
  
  private static <T> void co(T paramT)
  {
    AppMethodBeat.i(188116);
    if ((paramT instanceof WxaAttributes))
    {
      ((WxaAttributes)paramT).beq();
      AppMethodBeat.o(188116);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WxaAttrSyncHelper", "printContact %s", new Object[] { paramT });
    AppMethodBeat.o(188116);
  }
  
  private static com.tencent.mm.vending.g.e<List<String>> d(List<String> paramList, n.a parama)
  {
    AppMethodBeat.i(188119);
    if (bt.hj(paramList))
    {
      paramList = com.tencent.mm.cn.g.er(Collections.emptyList());
      AppMethodBeat.o(188119);
      return paramList;
    }
    paramList = new n(paramList, parama).aED().i(new com.tencent.mm.vending.c.a()
    {
      private List<String> d(a.a<kv> paramAnonymousa)
      {
        AppMethodBeat.i(188110);
        if ((paramAnonymousa.errType != 0) || (paramAnonymousa.errCode != 0))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WxaAttrSyncHelper", "BatchWxaAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
          paramAnonymousa = Collections.emptyList();
          AppMethodBeat.o(188110);
          return paramAnonymousa;
        }
        if (paramAnonymousa.hNC != null) {}
        try
        {
          w localw = j.aYP();
          if (!localw.beh())
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync storage can not work");
            paramAnonymousa = Collections.emptyList();
            AppMethodBeat.o(188110);
            return paramAnonymousa;
          }
          localw.a((kv)paramAnonymousa.hNC);
        }
        catch (NullPointerException paramAnonymousa)
        {
          while (j.aYL() == null) {}
          AppMethodBeat.o(188110);
          throw paramAnonymousa;
        }
        catch (com.tencent.mm.model.b paramAnonymousa)
        {
          break label129;
        }
        paramAnonymousa = this.jZe;
        AppMethodBeat.o(188110);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(188119);
    return paramList;
  }
  
  static abstract interface a<T>
  {
    public abstract o NN(String paramString);
    
    public abstract T NO(String paramString);
    
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
        AppMethodBeat.i(188114);
        jZn = new a("RET_HIT_FREQUENCY_LIMIT", 0);
        jZo = new a("RET_UPDATED", 1);
        jZp = new a("RET_NO_UPDATE", 2);
        jZq = new a("RET_CGI_FAIL", 3);
        jZr = new a[] { jZn, jZo, jZp, jZq };
        AppMethodBeat.o(188114);
      }
      
      private a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract void done();
  }
  
  public static abstract interface d
  {
    public abstract void bek();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.x
 * JD-Core Version:    0.7.0.1
 */