package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Base64;
import android.util.Pair;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.g.b.a.cu;
import com.tencent.mm.g.b.a.cv;
import com.tencent.mm.g.b.a.cw;
import com.tencent.mm.g.b.a.cx;
import com.tencent.mm.g.b.a.cz;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  ConcurrentHashMap<Long, Pair<String, String>> sqL;
  ConcurrentHashMap<Long, Boolean> sqM;
  public ConcurrentHashMap<Long, a> sqN;
  ConcurrentHashMap<Long, b> sqO;
  
  public d()
  {
    AppMethodBeat.i(110384);
    this.sqL = new ConcurrentHashMap();
    this.sqM = new ConcurrentHashMap();
    this.sqN = new ConcurrentHashMap();
    this.sqO = new ConcurrentHashMap();
    AppMethodBeat.o(110384);
  }
  
  public static void a(com.tencent.mm.plugin.groupsolitaire.c.a parama, int paramInt)
  {
    AppMethodBeat.i(110389);
    if (parama == null)
    {
      AppMethodBeat.o(110389);
      return;
    }
    cw localcw = new cw();
    localcw.js(parama.field_key);
    localcw.jq(parama.field_username);
    localcw.jr(parama.field_creator);
    localcw.dSK = parama.field_msgSvrId;
    localcw.dSX = paramInt;
    localcw.aBj();
    AppMethodBeat.o(110389);
  }
  
  public static void a(com.tencent.mm.plugin.groupsolitaire.c.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110392);
    cv localcv = new cv();
    localcv.dSO = localcv.t("Identifier", parama.field_key, true);
    localcv.dGR = localcv.t("ChatName", parama.field_username, true);
    localcv.dSK = parama.field_msgSvrId;
    localcv.dJN = paramInt1;
    localcv.dSW = paramInt2;
    localcv.aBj();
    AppMethodBeat.o(110392);
  }
  
  public static void a(com.tencent.mm.plugin.groupsolitaire.c.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(110390);
    cx localcx = new cx();
    localcx.ju(parama.field_key);
    localcx.jt(parama.field_username);
    localcx.dSK = parama.field_msgSvrId;
    localcx.dSY = paramInt1;
    localcx.dMT = paramInt2;
    if (paramBoolean) {}
    for (localcx.dSZ = 2L;; localcx.dSZ = 1L)
    {
      localcx.aBj();
      AppMethodBeat.o(110390);
      return;
    }
  }
  
  static void a(com.tencent.mm.plugin.groupsolitaire.c.a parama, boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(110386);
    if (paramLong == 0L)
    {
      ad.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==0 key:%s", new Object[] { parama.field_key });
      AppMethodBeat.o(110386);
      return;
    }
    ad.i("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==%s key:%s", new Object[] { Long.valueOf(paramLong), parama.field_key });
    cu localcu = new cu();
    localcu.jp(parama.field_key);
    localcu.jm(parama.field_username);
    localcu.jn(parama.field_creator);
    if (paramBoolean)
    {
      localcu.jo(paramString);
      localcu.dSR = paramLong;
      if (parama.sqY == 1) {
        localcu.dSS = parama.header.length();
      }
      localcu.dST = parama.sqX.length();
      localcu.dSU = parama.sqW.length();
      if (!paramBoolean) {
        break label198;
      }
    }
    label198:
    for (localcu.dSV = 1L;; localcu.dSV = 2L)
    {
      localcu.aBj();
      AppMethodBeat.o(110386);
      return;
      localcu.jo(parama.field_creator);
      break;
    }
  }
  
  public static void b(com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(161735);
    if (parama == null)
    {
      ad.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() groupSolitatire == null");
      AppMethodBeat.o(161735);
      return;
    }
    bl localbl = ((k)g.ab(k.class)).cOI().rm(parama.field_firstMsgId);
    if (parama.field_msgSvrId == 0L)
    {
      parama.field_msgSvrId = localbl.field_msgSvrId;
      ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true);
    }
    a(parama, true, paramString, parama.field_msgSvrId);
    AppMethodBeat.o(161735);
  }
  
  public static void dv(String paramString, int paramInt)
  {
    AppMethodBeat.i(110391);
    cz localcz = new cz();
    localcz.dGR = localcz.t("ChatName", paramString, true);
    localcz.dSZ = paramInt;
    localcz.aBj();
    AppMethodBeat.o(110391);
  }
  
  public static void q(List<com.tencent.mm.plugin.groupsolitaire.c.a> paramList, int paramInt)
  {
    AppMethodBeat.i(110388);
    if ((paramList == null) && (paramList.size() == 0))
    {
      AppMethodBeat.o(110388);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((com.tencent.mm.plugin.groupsolitaire.c.a)paramList.next(), paramInt);
    }
    AppMethodBeat.o(110388);
  }
  
  public final void X(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192538);
    Pair localPair = (Pair)this.sqL.remove(Long.valueOf(paramLong1));
    Boolean localBoolean = (Boolean)this.sqM.remove(Long.valueOf(paramLong1));
    if (localPair != null)
    {
      this.sqL.put(Long.valueOf(paramLong2), localPair);
      this.sqM.put(Long.valueOf(paramLong2), localBoolean);
    }
    AppMethodBeat.o(192538);
  }
  
  public final void a(long paramLong, com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(110385);
    if ((paramLong < 0L) || (parama1 == null))
    {
      AppMethodBeat.o(110385);
      return;
    }
    this.sqL.put(Long.valueOf(paramLong), new Pair(parama1.field_username, parama1.field_key));
    this.sqM.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    this.sqO.put(Long.valueOf(paramLong), new b(parama1, parama2, paramInt));
    AppMethodBeat.o(110385);
  }
  
  public final void a(final com.tencent.mm.plugin.groupsolitaire.c.a parama1, final com.tencent.mm.plugin.groupsolitaire.c.a parama2, final int paramInt)
  {
    AppMethodBeat.i(110387);
    if (parama1 == null)
    {
      AppMethodBeat.o(110387);
      return;
    }
    com.tencent.e.h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110382);
        Object localObject1 = "";
        if (parama2 == null)
        {
          i = parama1.sra.size();
          localObject1 = parama1.separator;
          j = 0;
          localObject2 = localObject1;
          if (bt.isNullOrNil((String)localObject1)) {
            localObject2 = parama1.separator;
          }
          localObject1 = new ct();
          ((ct)localObject1).dSO = ((ct)localObject1).t("Identifier", parama1.field_key, true);
          ((ct)localObject1).dGR = ((ct)localObject1).t("ChatName", parama1.field_username, true);
          ((ct)localObject1).dSJ = ((ct)localObject1).t("LaunchUserName", parama1.field_creator, true);
          ((ct)localObject1).dSK = parama1.field_msgSvrId;
          ((ct)localObject1).dSL = j;
          ((ct)localObject1).dSM = i;
          ((ct)localObject1).dSN = paramInt;
          ((ct)localObject1).dSP = ((ct)localObject1).t("Punctuation", Base64.encodeToString(((String)localObject2).getBytes(), 0), true);
          ad.d("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "separator:%s base64:%s", new Object[] { localObject2, Base64.encodeToString(((String)localObject2).getBytes(), 0) });
          ((ct)localObject1).aBj();
          AppMethodBeat.o(110382);
          return;
        }
        Object localObject2 = new HashSet();
        Object localObject3 = new HashMap();
        int i = 1;
        while (i <= parama2.sra.size())
        {
          b localb = (b)parama2.sra.get(Integer.valueOf(i));
          if ((localb != null) && (bt.kU(localb.username, u.aqG())))
          {
            ((Set)localObject2).add(localb);
            ((HashMap)localObject3).put(localb.content, localb);
          }
          i += 1;
        }
        int m = 1;
        int j = 0;
        i = 0;
        label335:
        int k;
        if (m <= parama1.sra.size())
        {
          localObject3 = (b)parama1.sra.get(Integer.valueOf(m));
          k = i;
          if (!bt.kU(((b)localObject3).username, u.aqG())) {
            break label463;
          }
          if (((Set)localObject2).contains(localObject3))
          {
            j += 1;
            k = i;
            i = j;
          }
        }
        for (;;)
        {
          m += 1;
          j = i;
          i = k;
          break label335;
          int n = i + 1;
          k = n;
          if (bt.isNullOrNil((String)localObject1))
          {
            localObject1 = ((b)localObject3).separator;
            i = j;
            k = n;
            continue;
            j = ((Set)localObject2).size() - j;
            break;
          }
          label463:
          i = j;
        }
      }
    });
    AppMethodBeat.o(110387);
  }
  
  public final class a
  {
    public String fod = "";
    public String key = "";
    public long sqS = 0L;
    public long sqT = 0L;
    
    public a() {}
  }
  
  final class b
  {
    int scene;
    com.tencent.mm.plugin.groupsolitaire.c.a sqU;
    com.tencent.mm.plugin.groupsolitaire.c.a sqV;
    
    public b(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, int paramInt)
    {
      this.sqU = parama1;
      this.sqV = parama2;
      this.scene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.d
 * JD-Core Version:    0.7.0.1
 */