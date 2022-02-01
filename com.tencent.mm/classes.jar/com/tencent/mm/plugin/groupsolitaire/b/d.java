package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Base64;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fi;
import com.tencent.mm.g.b.a.fj;
import com.tencent.mm.g.b.a.fk;
import com.tencent.mm.g.b.a.fl;
import com.tencent.mm.g.b.a.fm;
import com.tencent.mm.g.b.a.fo;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.plugin.groupsolitaire.c.b;
import com.tencent.mm.plugin.groupsolitaire.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  ConcurrentHashMap<Long, Pair<String, String>> uMS;
  ConcurrentHashMap<Long, Boolean> uMT;
  public ConcurrentHashMap<Long, a> uMU;
  ConcurrentHashMap<Long, d.b> uMV;
  
  public d()
  {
    AppMethodBeat.i(110384);
    this.uMS = new ConcurrentHashMap();
    this.uMT = new ConcurrentHashMap();
    this.uMU = new ConcurrentHashMap();
    this.uMV = new ConcurrentHashMap();
    AppMethodBeat.o(110384);
  }
  
  public static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(110389);
    if (parama == null)
    {
      AppMethodBeat.o(110389);
      return;
    }
    fl localfl = new fl();
    localfl.oQ(parama.field_key);
    localfl.oO(parama.field_username);
    localfl.oP(parama.field_creator);
    localfl.emx = parama.field_msgSvrId;
    localfl.emK = paramInt;
    localfl.aLH();
    AppMethodBeat.o(110389);
  }
  
  public static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110392);
    fk localfk = new fk();
    localfk.emB = localfk.t("Identifier", parama.field_key, true);
    localfk.dSR = localfk.t("ChatName", parama.field_username, true);
    localfk.emx = parama.field_msgSvrId;
    localfk.dXf = paramInt1;
    localfk.emJ = paramInt2;
    localfk.aLH();
    AppMethodBeat.o(110392);
  }
  
  public static void a(a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(110390);
    fm localfm = new fm();
    localfm.oS(parama.field_key);
    localfm.oR(parama.field_username);
    localfm.emx = parama.field_msgSvrId;
    localfm.dXI = paramInt1;
    localfm.eee = paramInt2;
    if (paramBoolean) {}
    for (localfm.emL = 2L;; localfm.emL = 1L)
    {
      localfm.aLH();
      AppMethodBeat.o(110390);
      return;
    }
  }
  
  static void a(a parama, boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(110386);
    if (paramLong == 0L)
    {
      ae.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==0 key:%s", new Object[] { parama.field_key });
      AppMethodBeat.o(110386);
      return;
    }
    ae.i("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==%s key:%s", new Object[] { Long.valueOf(paramLong), parama.field_key });
    fj localfj = new fj();
    localfj.oN(parama.field_key);
    localfj.oK(parama.field_username);
    localfj.oL(parama.field_creator);
    if (paramBoolean)
    {
      localfj.oM(paramString);
      localfj.emE = paramLong;
      if (parama.uNe == 1) {
        localfj.emF = parama.header.length();
      }
      localfj.emG = parama.ufC.length();
      localfj.emH = parama.uNd.length();
      if (!paramBoolean) {
        break label198;
      }
    }
    label198:
    for (localfj.emI = 1L;; localfj.emI = 2L)
    {
      localfj.aLH();
      AppMethodBeat.o(110386);
      return;
      localfj.oM(parama.field_creator);
      break;
    }
  }
  
  public static void b(a parama, String paramString)
  {
    AppMethodBeat.i(161735);
    if (parama == null)
    {
      ae.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() groupSolitatire == null");
      AppMethodBeat.o(161735);
      return;
    }
    bv localbv = ((l)g.ab(l.class)).doJ().ys(parama.field_firstMsgId);
    if (parama.field_msgSvrId == 0L)
    {
      parama.field_msgSvrId = localbv.field_msgSvrId;
      ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true);
    }
    a(parama, true, paramString, parama.field_msgSvrId);
    AppMethodBeat.o(161735);
  }
  
  public static void dY(String paramString, int paramInt)
  {
    AppMethodBeat.i(110391);
    fo localfo = new fo();
    localfo.dSR = localfo.t("ChatName", paramString, true);
    localfo.emL = paramInt;
    localfo.aLH();
    AppMethodBeat.o(110391);
  }
  
  public static void t(List<a> paramList, int paramInt)
  {
    AppMethodBeat.i(110388);
    if ((paramList == null) && (paramList.size() == 0))
    {
      AppMethodBeat.o(110388);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((a)paramList.next(), paramInt);
    }
    AppMethodBeat.o(110388);
  }
  
  public final void U(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221113);
    Pair localPair = (Pair)this.uMS.remove(Long.valueOf(paramLong1));
    Boolean localBoolean = (Boolean)this.uMT.remove(Long.valueOf(paramLong1));
    if (localPair != null)
    {
      this.uMS.put(Long.valueOf(paramLong2), localPair);
      this.uMT.put(Long.valueOf(paramLong2), localBoolean);
    }
    AppMethodBeat.o(221113);
  }
  
  public final void a(long paramLong, a parama1, a parama2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(110385);
    if ((paramLong < 0L) || (parama1 == null))
    {
      AppMethodBeat.o(110385);
      return;
    }
    this.uMS.put(Long.valueOf(paramLong), new Pair(parama1.field_username, parama1.field_key));
    this.uMT.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    this.uMV.put(Long.valueOf(paramLong), new d.b(this, parama1, parama2, paramInt));
    AppMethodBeat.o(110385);
  }
  
  public final void a(final a parama1, final a parama2, final int paramInt)
  {
    AppMethodBeat.i(110387);
    if (parama1 == null)
    {
      AppMethodBeat.o(110387);
      return;
    }
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110382);
        Object localObject1 = "";
        if (parama2 == null)
        {
          i = parama1.uNg.size();
          localObject1 = parama1.separator;
          j = 0;
          localObject2 = localObject1;
          if (bu.isNullOrNil((String)localObject1)) {
            localObject2 = parama1.separator;
          }
          localObject1 = new fi();
          ((fi)localObject1).emB = ((fi)localObject1).t("Identifier", parama1.field_key, true);
          ((fi)localObject1).dSR = ((fi)localObject1).t("ChatName", parama1.field_username, true);
          ((fi)localObject1).emw = ((fi)localObject1).t("LaunchUserName", parama1.field_creator, true);
          ((fi)localObject1).emx = parama1.field_msgSvrId;
          ((fi)localObject1).emy = j;
          ((fi)localObject1).emz = i;
          ((fi)localObject1).emA = paramInt;
          ((fi)localObject1).emC = ((fi)localObject1).t("Punctuation", Base64.encodeToString(((String)localObject2).getBytes(), 0), true);
          ae.d("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "separator:%s base64:%s", new Object[] { localObject2, Base64.encodeToString(((String)localObject2).getBytes(), 0) });
          ((fi)localObject1).aLH();
          AppMethodBeat.o(110382);
          return;
        }
        Object localObject2 = new HashSet();
        Object localObject3 = new HashMap();
        int i = 1;
        while (i <= parama2.uNg.size())
        {
          b localb = (b)parama2.uNg.get(Integer.valueOf(i));
          if ((localb != null) && (bu.lX(localb.username, v.aAC())))
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
        if (m <= parama1.uNg.size())
        {
          localObject3 = (b)parama1.uNg.get(Integer.valueOf(m));
          k = i;
          if (!bu.lX(((b)localObject3).username, v.aAC())) {
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
          if (bu.isNullOrNil((String)localObject1))
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
    public String fLJ = "";
    public String key = "";
    public long uMZ = 0L;
    public long uNa = 0L;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.d
 * JD-Core Version:    0.7.0.1
 */