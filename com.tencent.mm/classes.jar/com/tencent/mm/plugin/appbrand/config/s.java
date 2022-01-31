package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.x;
import com.tencent.mm.ai.x.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
{
  static boolean Av(String paramString)
  {
    AppMethodBeat.i(129921);
    if (com.tencent.mm.plugin.appbrand.app.g.auF() == null)
    {
      ab.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, storage NULL");
      AppMethodBeat.o(129921);
      return false;
    }
    long l1 = bo.aox();
    long l2 = com.tencent.mm.plugin.appbrand.app.g.auF().Ah(paramString);
    int i = ayB();
    ab.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
    if (l1 - l2 >= i)
    {
      AppMethodBeat.o(129921);
      return true;
    }
    AppMethodBeat.o(129921);
    return false;
  }
  
  private static boolean Aw(String paramString)
  {
    AppMethodBeat.i(129922);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129922);
      return false;
    }
    if (!com.tencent.mm.af.l.na(paramString))
    {
      ab.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[] { paramString, an.l(new Throwable()) });
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(648L, 1L, 1L, false);
      AppMethodBeat.o(129922);
      return true;
    }
    AppMethodBeat.o(129922);
    return false;
  }
  
  public static void Ax(String paramString)
  {
    AppMethodBeat.i(129923);
    if (Aw(paramString))
    {
      AppMethodBeat.o(129923);
      return;
    }
    d.post(new s.1(paramString), "WxaAttrSync");
    AppMethodBeat.o(129923);
  }
  
  public static void Ay(String paramString)
  {
    AppMethodBeat.i(129928);
    if (Aw(paramString))
    {
      AppMethodBeat.o(129928);
      return;
    }
    if (Av(paramString)) {
      ae(paramString, true);
    }
    AppMethodBeat.o(129928);
  }
  
  static <T> Pair<T, a.a> a(String paramString, boolean paramBoolean, s.a<T> parama)
  {
    a.a locala = null;
    AppMethodBeat.i(129925);
    if ((bo.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.RJ().eHg))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(129925);
      return paramString;
    }
    Object localObject2;
    if (!paramBoolean)
    {
      localObject2 = parama.AA(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {
        if (!parama.bg(localObject2)) {
          break label539;
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      locala = x.c(parama.Az(paramString).rr);
      if ((locala == null) || ((locala instanceof x.a)) || (locala.errType != 0) || (locala.errCode != 0))
      {
        int i;
        int j;
        if (locala == null)
        {
          i = -1;
          if (locala != null) {
            break label227;
          }
          j = -1;
          label133:
          if (locala != null) {
            break label237;
          }
        }
        label227:
        label237:
        for (localObject2 = "null resp";; localObject2 = locala.errMsg)
        {
          ab.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), localObject2 });
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = parama.AA(paramString);
            if (localObject2 == null) {
              break label247;
            }
          }
          paramString = Pair.create(localObject2, locala);
          AppMethodBeat.o(129925);
          return paramString;
          i = locala.errType;
          break;
          j = locala.errCode;
          break label133;
        }
        label247:
        paramString = Pair.create(null, locala);
        AppMethodBeat.o(129925);
        return paramString;
      }
      localObject1 = ((dab)locala.fsN).wxO.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (daa)((Iterator)localObject1).next();
          if ("UserName".equalsIgnoreCase(((daa)localObject2).wxP))
          {
            localObject2 = ((daa)localObject2).qsu;
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
        if (bo.isNullOrNil((String)localObject1))
        {
          localObject1 = parama.getUsername();
          localObject2 = localObject1;
          if (bo.isNullOrNil((String)localObject1))
          {
            ab.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[] { Boolean.valueOf(paramBoolean), paramString });
            paramString = Pair.create(null, null);
            AppMethodBeat.o(129925);
            return paramString;
          }
        }
        ab.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync key(%s), username(%s), flushAttrs", new Object[] { paramString, localObject2 });
        if (com.tencent.mm.plugin.appbrand.app.g.auF().a((String)localObject2, ((dab)locala.fsN).wxN, ((dab)locala.fsN).wxO)) {
          q.ayA().doNotify("single", 3, localObject2);
        }
        localObject2 = parama.AA(paramString);
        ab.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", new Object[] { Boolean.valueOf(paramBoolean), localObject2 });
        for (paramString = locala;; paramString = locala)
        {
          paramString = Pair.create(localObject2, paramString);
          AppMethodBeat.o(129925);
          return paramString;
          label539:
          ab.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, query record %s", new Object[] { Boolean.valueOf(paramBoolean), localObject2 });
        }
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, b<WxaAttributes> paramb)
  {
    AppMethodBeat.i(129927);
    if (Aw(paramString))
    {
      AppMethodBeat.o(129927);
      return;
    }
    Looper localLooper;
    if ((al.isMainThread()) || (Looper.myLooper() == null)) {
      localLooper = new al().oNc.getLooper();
    }
    for (boolean bool = true;; bool = false)
    {
      new ak(localLooper).post(new s.5(paramString, paramBoolean, paramb, bool));
      AppMethodBeat.o(129927);
      return;
      localLooper = Looper.myLooper();
    }
  }
  
  public static void a(List<String> paramList, k.a parama)
  {
    AppMethodBeat.i(129929);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(129929);
      return;
    }
    if (al.isMainThread())
    {
      m.aNS().ac(new s.6(paramList, parama));
      AppMethodBeat.o(129929);
      return;
    }
    Object localObject = paramList;
    if (!(paramList instanceof ArrayList))
    {
      if (!(paramList instanceof LinkedList)) {
        break label110;
      }
      localObject = paramList;
    }
    for (;;)
    {
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext()) {
        if (!Av((String)paramList.next())) {
          paramList.remove();
        }
      }
      label110:
      localObject = new LinkedList();
      ((List)localObject).addAll(paramList);
    }
    if (bo.es((List)localObject))
    {
      AppMethodBeat.o(129929);
      return;
    }
    ab.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(((List)localObject).size()), parama.name(), Integer.valueOf(parama.intValue) });
    int i = 0;
    int j = 0;
    while (i < ((List)localObject).size() / 20)
    {
      int k = i * 20;
      j = k + 20;
      b(((List)localObject).subList(k, j), parama);
      i += 1;
    }
    if (j < ((List)localObject).size()) {
      b(((List)localObject).subList(j, ((List)localObject).size()), parama);
    }
    AppMethodBeat.o(129929);
  }
  
  public static Pair<WxaAttributes, a.a> ac(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(129924);
    paramString = a(paramString, paramBoolean, new s.a()
    {
      public final l Az(String paramAnonymousString)
      {
        AppMethodBeat.i(129908);
        paramAnonymousString = new l(null, paramAnonymousString);
        AppMethodBeat.o(129908);
        return paramAnonymousString;
      }
      
      public final String getUsername()
      {
        AppMethodBeat.i(129907);
        String str = q.As(this.val$appId);
        AppMethodBeat.o(129907);
        return str;
      }
    });
    AppMethodBeat.o(129924);
    return paramString;
  }
  
  public static Pair<WxaAttributes, a.a> ae(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(129926);
    if (Aw(paramString))
    {
      paramString = new Pair(null, null);
      AppMethodBeat.o(129926);
      return paramString;
    }
    paramString = a(paramString, paramBoolean, new s.4(paramString));
    AppMethodBeat.o(129926);
    return paramString;
  }
  
  private static int ayB()
  {
    AppMethodBeat.i(129920);
    int i = com.tencent.mm.m.g.Nq().getInt("MMBizAttrSyncFreq", 3600);
    AppMethodBeat.o(129920);
    return i;
  }
  
  private static void b(List<String> paramList, k.a parama)
  {
    AppMethodBeat.i(129930);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(129930);
      return;
    }
    new k(paramList, parama).adl().i(new s.7());
    AppMethodBeat.o(129930);
  }
  
  public static abstract interface b<T>
  {
    public abstract void g(int paramInt, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.s
 * JD-Core Version:    0.7.0.1
 */