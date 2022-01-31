package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.ae.i;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.x;
import com.tencent.mm.ah.x.a;
import com.tencent.mm.bv.b;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.protocal.c.cmj;
import com.tencent.mm.protocal.c.cmk;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
{
  public static Pair<WxaAttributes, a.a> W(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, new s.a()
    {
      public final String getUsername()
      {
        return r.sx(this.val$appId);
      }
      
      public final m sF(String paramAnonymousString)
      {
        return new m(null, paramAnonymousString);
      }
    });
  }
  
  public static Pair<WxaAttributes, a.a> X(String paramString, boolean paramBoolean)
  {
    if (sB(paramString)) {
      return new Pair(null, null);
    }
    a(paramString, paramBoolean, new s.a()
    {
      public final String getUsername()
      {
        return this.dol;
      }
      
      public final m sF(String paramAnonymousString)
      {
        return new m(paramAnonymousString, null);
      }
    });
  }
  
  static <T> Pair<T, a.a> a(String paramString, boolean paramBoolean, s.a<T> parama)
  {
    int j = -1;
    a.a locala = null;
    if (bk.bl(paramString)) {
      return Pair.create(null, null);
    }
    Object localObject2;
    if (!paramBoolean)
    {
      localObject2 = parama.sG(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {
        if (!parama.aM(localObject2)) {
          break label466;
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      locala = x.c(parama.sF(paramString).dmK);
      if ((locala == null) || ((locala instanceof x.a)) || (locala.errType != 0) || (locala.errCode != 0))
      {
        int i;
        if (locala == null)
        {
          i = -1;
          if (locala != null) {
            break label199;
          }
          label112:
          if (locala != null) {
            break label209;
          }
        }
        label199:
        label209:
        for (localObject2 = "null resp";; localObject2 = locala.aox)
        {
          y.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), localObject2 });
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = parama.sG(paramString);
            if (localObject2 == null) {
              break label219;
            }
          }
          return Pair.create(localObject2, locala);
          i = locala.errType;
          break;
          j = locala.errCode;
          break label112;
        }
        label219:
        return Pair.create(null, locala);
      }
      localObject1 = ((cmk)locala.ecw).sCG.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (cmj)((Iterator)localObject1).next();
          if ("UserName".equalsIgnoreCase(((cmj)localObject2).sCH))
          {
            localObject2 = ((cmj)localObject2).nFs;
            localObject1 = localObject2;
            if (((String)localObject2).endsWith("@app")) {
              break;
            }
          }
        }
      }
      for (localObject1 = (String)localObject2 + "@app";; localObject1 = null)
      {
        localObject2 = localObject1;
        if (bk.bl((String)localObject1))
        {
          localObject1 = parama.getUsername();
          localObject2 = localObject1;
          if (bk.bl((String)localObject1))
          {
            y.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[] { Boolean.valueOf(paramBoolean), paramString });
            return Pair.create(null, null);
          }
        }
        if (com.tencent.mm.plugin.appbrand.app.e.aaT().a((String)localObject2, ((cmk)locala.ecw).sCF, ((cmk)locala.ecw).sCG)) {
          r.aem().b("single", 3, localObject2);
        }
        localObject2 = parama.sG(paramString);
        y.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", new Object[] { Boolean.valueOf(paramBoolean), localObject2 });
        for (paramString = locala;; paramString = locala)
        {
          return Pair.create(localObject2, paramString);
          label466:
          y.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, query record %s", new Object[] { Boolean.valueOf(paramBoolean), localObject2 });
        }
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, b<WxaAttributes> paramb)
  {
    if (sB(paramString)) {
      return;
    }
    Looper localLooper;
    if ((ai.isMainThread()) || (Looper.myLooper() == null)) {
      localLooper = new ai().mnU.getLooper();
    }
    for (boolean bool = true;; bool = false)
    {
      new ah(localLooper).post(new s.5(paramString, paramBoolean, paramb, bool));
      return;
      localLooper = Looper.myLooper();
    }
  }
  
  public static void a(List<String> paramList, final l.a parama)
  {
    if (bk.dk(paramList)) {}
    Object localObject;
    label92:
    int j;
    do
    {
      do
      {
        return;
        if (ai.isMainThread())
        {
          n.DS().O(new Runnable()
          {
            public final void run()
            {
              s.a(this.fQT, parama);
            }
          });
          return;
        }
        localObject = paramList;
        if (!(paramList instanceof ArrayList))
        {
          if (!(paramList instanceof LinkedList)) {
            break label92;
          }
          localObject = paramList;
        }
        for (;;)
        {
          paramList = ((List)localObject).iterator();
          while (paramList.hasNext()) {
            if (!sA((String)paramList.next())) {
              paramList.remove();
            }
          }
          localObject = new LinkedList();
          ((List)localObject).addAll(paramList);
        }
      } while (bk.dk((List)localObject));
      y.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(((List)localObject).size()), parama.name(), Integer.valueOf(parama.fJL) });
      int i = 0;
      j = 0;
      while (i < ((List)localObject).size() / 20)
      {
        int k = i * 20;
        j = k + 20;
        b(((List)localObject).subList(k, j), parama);
        i += 1;
      }
    } while (j >= ((List)localObject).size());
    b(((List)localObject).subList(j, ((List)localObject).size()), parama);
  }
  
  private static void b(List<String> paramList, l.a parama)
  {
    if (bk.dk(paramList)) {
      return;
    }
    new l(paramList, parama).Km().i(new s.7());
  }
  
  static boolean sA(String paramString)
  {
    if (com.tencent.mm.plugin.appbrand.app.e.aaT() == null)
    {
      y.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, storage NULL");
      return false;
    }
    long l2 = bk.UX();
    WxaAttributes localWxaAttributes = com.tencent.mm.plugin.appbrand.app.e.aaT().d(paramString, new String[] { "syncTimeSecond" });
    if (localWxaAttributes == null) {}
    for (long l1 = 0L;; l1 = localWxaAttributes.field_syncTimeSecond)
    {
      int i = g.AA().getInt("MMBizAttrSyncFreq", 3600);
      y.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[] { paramString, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
      if (l2 - l1 < i) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private static boolean sB(String paramString)
  {
    if (bk.bl(paramString)) {}
    while (i.gr(paramString)) {
      return false;
    }
    y.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[] { paramString, ak.j(new Throwable()) });
    com.tencent.mm.plugin.report.f.nEG.a(648L, 1L, 1L, false);
    return true;
  }
  
  static b sC(String paramString)
  {
    paramString = com.tencent.mm.plugin.appbrand.app.e.aaT().d(paramString, new String[] { "syncVersion" });
    if (paramString == null) {}
    for (paramString = new byte[0];; paramString = bk.ZM(bk.pm(paramString.field_syncVersion))) {
      return new b(paramString);
    }
  }
  
  public static void sD(String paramString)
  {
    if (sB(paramString)) {
      return;
    }
    com.tencent.mm.sdk.f.e.post(new s.1(paramString), "WxaAttrSync");
  }
  
  public static void sE(String paramString)
  {
    if (sB(paramString)) {}
    while (!sA(paramString)) {
      return;
    }
    X(paramString, true);
  }
  
  public static abstract interface b<T>
  {
    public abstract void e(int paramInt, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.s
 * JD-Core Version:    0.7.0.1
 */