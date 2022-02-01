package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.ak.y.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.utils.ab;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.eai;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class w
{
  public static boolean Kq(String paramString)
  {
    AppMethodBeat.i(44926);
    if (j.aVu() == null)
    {
      ac.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, storage NULL");
      AppMethodBeat.o(44926);
      return false;
    }
    long l2 = bs.aNx();
    WxaAttributes localWxaAttributes = j.aVu().d(paramString, new String[] { "syncTimeSecond" });
    if (localWxaAttributes == null) {}
    for (long l1 = 0L;; l1 = localWxaAttributes.field_syncTimeSecond)
    {
      int i = com.tencent.mm.m.g.ZY().getInt("MMBizAttrSyncFreq", 3600);
      ac.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[] { paramString, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
      if (l2 - l1 < i) {
        break;
      }
      AppMethodBeat.o(44926);
      return true;
    }
    AppMethodBeat.o(44926);
    return false;
  }
  
  private static boolean Kr(String paramString)
  {
    AppMethodBeat.i(44927);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44927);
      return false;
    }
    if (!m.vC(paramString))
    {
      ac.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[] { paramString, as.m(new Throwable()) });
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(648L, 1L, 1L, false);
      AppMethodBeat.o(44927);
      return true;
    }
    AppMethodBeat.o(44927);
    return false;
  }
  
  public static void Ks(String paramString)
  {
    AppMethodBeat.i(44928);
    if (Kr(paramString))
    {
      AppMethodBeat.o(44928);
      return;
    }
    h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44910);
        w.Kt(this.fur);
        AppMethodBeat.o(44910);
      }
    });
    AppMethodBeat.o(44928);
  }
  
  public static void Kt(String paramString)
  {
    AppMethodBeat.i(44933);
    if (Kr(paramString))
    {
      AppMethodBeat.o(44933);
      return;
    }
    if (Kq(paramString)) {
      b(paramString, true, null);
    }
    AppMethodBeat.o(44933);
  }
  
  public static Pair<WxaAttributes, com.tencent.mm.ak.c.a> a(String paramString, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(44929);
    paramString = a(paramString, paramBoolean, paramd, new a()
    {
      public final o Ku(String paramAnonymousString)
      {
        AppMethodBeat.i(44913);
        paramAnonymousString = new o(null, paramAnonymousString);
        AppMethodBeat.o(44913);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        AppMethodBeat.i(44912);
        String str = u.Kn(this.val$appId);
        AppMethodBeat.o(44912);
        return str;
      }
    }, null);
    AppMethodBeat.o(44929);
    return paramString;
  }
  
  static <T> Pair<T, com.tencent.mm.ak.c.a> a(String paramString, boolean paramBoolean, d paramd, a<T> parama, PBool paramPBool)
  {
    com.tencent.mm.ak.c.a locala = null;
    AppMethodBeat.i(186421);
    if ((bs.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.agP().ggT))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(186421);
      return paramString;
    }
    Object localObject;
    if (!paramBoolean)
    {
      localObject = parama.Kv(paramString);
      if ((localObject != null) && (!parama.cn(localObject))) {}
    }
    for (;;)
    {
      if (paramd != null) {
        paramd.baK();
      }
      locala = y.e(parama.Ku(paramString).rr);
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
          paramd = "null resp";
          label144:
          ac.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), paramd });
          if (localObject != null) {
            break label580;
          }
          paramString = parama.Kv(paramString);
          if (paramString == null) {
            break label242;
          }
        }
      }
      for (;;)
      {
        paramString = Pair.create(paramString, locala);
        AppMethodBeat.o(186421);
        return paramString;
        i = locala.errType;
        break;
        label223:
        j = locala.errCode;
        break label136;
        label233:
        paramd = locala.errMsg;
        break label144;
        label242:
        paramString = Pair.create(null, locala);
        AppMethodBeat.o(186421);
        return paramString;
        paramd = ((eai)locala.hvj).EaX.iterator();
        for (;;)
        {
          if (paramd.hasNext())
          {
            localObject = (eah)paramd.next();
            if ("UserName".equalsIgnoreCase(((eah)localObject).tlp))
            {
              localObject = ((eah)localObject).wTM;
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
          if (bs.isNullOrNil(paramd))
          {
            paramd = parama.getUsername();
            localObject = paramd;
            if (bs.isNullOrNil(paramd))
            {
              ac.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[] { Boolean.valueOf(paramBoolean), paramString });
              paramString = Pair.create(null, null);
              AppMethodBeat.o(186421);
              return paramString;
            }
          }
          ac.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync key(%s), username(%s), flushAttrs", new Object[] { paramString, localObject });
          if (j.aVu().a((String)localObject, ((eai)locala.hvj).EaW, ((eai)locala.hvj).EaX))
          {
            u.baJ().o("single", localObject);
            if (paramPBool != null) {
              paramPBool.value = true;
            }
          }
          localObject = parama.Kv(paramString);
          ac.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
          cm(localObject);
          for (paramString = locala;; paramString = locala)
          {
            paramString = Pair.create(localObject, paramString);
            AppMethodBeat.o(186421);
            return paramString;
            ac.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, key:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
            cm(localObject);
          }
        }
        label580:
        paramString = (String)localObject;
      }
      localObject = null;
    }
  }
  
  public static com.tencent.mm.vending.g.e<List<String>> a(List<String> paramList, final n.a parama, final c paramc)
  {
    AppMethodBeat.i(186424);
    ac.i("MicroMsg.WxaAttrSyncHelper", "batchSync before real logic, list_size:%d, scene:%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(parama.intValue) });
    if (bs.gY(paramList))
    {
      paramList = com.tencent.mm.cn.g.eo(Collections.emptyList());
      AppMethodBeat.o(186424);
      return paramList;
    }
    if (ab.AI())
    {
      paramList = com.tencent.mm.cn.g.fBc().j(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(186424);
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
        if ((TextUtils.isEmpty(str)) || (!ai.vC(str)) || (!Kq(str))) {
          paramList.remove();
        }
      }
    }
    if (bs.gY((List)localObject))
    {
      paramList = com.tencent.mm.cn.g.eo(Collections.emptyList());
      AppMethodBeat.o(186424);
      return paramList;
    }
    ac.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(((List)localObject).size()), parama.name(), Integer.valueOf(parama.intValue) });
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
    paramList = com.tencent.mm.cn.g.c(new com.tencent.mm.vending.g.c.a() {});
    AppMethodBeat.o(186424);
    return paramList;
  }
  
  public static void a(String paramString, final boolean paramBoolean, final b<WxaAttributes> paramb)
  {
    AppMethodBeat.i(44932);
    if (Kr(paramString))
    {
      AppMethodBeat.o(44932);
      return;
    }
    h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44922);
        Object localObject1 = new PBool();
        Object localObject2 = this.fur;
        boolean bool;
        if ((paramBoolean) && (w.Kq(this.fur)))
        {
          bool = true;
          localObject2 = w.a((String)localObject2, bool, null, new w.a()
          {
            public final o Ku(String paramAnonymous2String)
            {
              AppMethodBeat.i(44919);
              paramAnonymous2String = new o(paramAnonymous2String, null);
              AppMethodBeat.o(44919);
              return paramAnonymous2String;
            }
            
            public final String getUsername()
            {
              return w.5.this.fur;
            }
          }, (PBool)localObject1);
          if (paramb != null)
          {
            if (((Pair)localObject2).second != null) {
              break label96;
            }
            localObject1 = w.b.a.jFi;
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
          if ((((com.tencent.mm.ak.c.a)((Pair)localObject2).second).errType != 0) || (((com.tencent.mm.ak.c.a)((Pair)localObject2).second).errCode != 0)) {
            localObject1 = w.b.a.jFl;
          } else if (((PBool)localObject1).value) {
            localObject1 = w.b.a.jFj;
          } else {
            localObject1 = w.b.a.jFk;
          }
        }
      }
    });
    AppMethodBeat.o(44932);
  }
  
  public static Pair<WxaAttributes, com.tencent.mm.ak.c.a> b(String paramString, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(44931);
    if (Kr(paramString))
    {
      paramString = new Pair(null, null);
      AppMethodBeat.o(44931);
      return paramString;
    }
    paramString = a(paramString, paramBoolean, paramd, new a()
    {
      public final o Ku(String paramAnonymousString)
      {
        AppMethodBeat.i(44916);
        paramAnonymousString = new o(paramAnonymousString, null);
        AppMethodBeat.o(44916);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        return this.fur;
      }
    }, null);
    AppMethodBeat.o(44931);
    return paramString;
  }
  
  public static com.tencent.mm.vending.g.e<List<String>> c(List<String> paramList, n.a parama)
  {
    AppMethodBeat.i(210155);
    paramList = a(paramList, parama, null);
    AppMethodBeat.o(210155);
    return paramList;
  }
  
  private static <T> void cm(T paramT)
  {
    AppMethodBeat.i(186422);
    if ((paramT instanceof WxaAttributes))
    {
      ((WxaAttributes)paramT).baQ();
      AppMethodBeat.o(186422);
      return;
    }
    ac.i("MicroMsg.WxaAttrSyncHelper", "printContact %s", new Object[] { paramT });
    AppMethodBeat.o(186422);
  }
  
  private static com.tencent.mm.vending.g.e<List<String>> d(List<String> paramList, n.a parama)
  {
    AppMethodBeat.i(186425);
    if (bs.gY(paramList))
    {
      paramList = com.tencent.mm.cn.g.eo(Collections.emptyList());
      AppMethodBeat.o(186425);
      return paramList;
    }
    paramList = new n(paramList, parama).aBB().i(new com.tencent.mm.vending.c.a()
    {
      private List<String> a(a.a<km> paramAnonymousa)
      {
        AppMethodBeat.i(186416);
        if ((paramAnonymousa.errType != 0) || (paramAnonymousa.errCode != 0))
        {
          ac.e("MicroMsg.WxaAttrSyncHelper", "BatchWxaAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
          paramAnonymousa = Collections.emptyList();
          AppMethodBeat.o(186416);
          return paramAnonymousa;
        }
        if (paramAnonymousa.hvj != null) {}
        try
        {
          v localv = j.aVu();
          if (!localv.baH())
          {
            ac.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync storage can not work");
            paramAnonymousa = Collections.emptyList();
            AppMethodBeat.o(186416);
            return paramAnonymousa;
          }
          localv.a((km)paramAnonymousa.hvj);
        }
        catch (NullPointerException paramAnonymousa)
        {
          while (j.aVq() == null) {}
          AppMethodBeat.o(186416);
          throw paramAnonymousa;
        }
        catch (com.tencent.mm.model.b paramAnonymousa)
        {
          break label129;
        }
        paramAnonymousa = this.jEZ;
        AppMethodBeat.o(186416);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(186425);
    return paramList;
  }
  
  static abstract interface a<T>
  {
    public abstract o Ku(String paramString);
    
    public abstract T Kv(String paramString);
    
    public abstract boolean cn(T paramT);
    
    public abstract String getUsername();
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(a parama, T paramT);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(186420);
        jFi = new a("RET_HIT_FREQUENCY_LIMIT", 0);
        jFj = new a("RET_UPDATED", 1);
        jFk = new a("RET_NO_UPDATE", 2);
        jFl = new a("RET_CGI_FAIL", 3);
        jFm = new a[] { jFi, jFj, jFk, jFl };
        AppMethodBeat.o(186420);
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
    public abstract void baK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.w
 * JD-Core Version:    0.7.0.1
 */