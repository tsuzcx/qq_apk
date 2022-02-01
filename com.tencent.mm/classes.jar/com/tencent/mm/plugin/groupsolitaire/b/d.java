package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.le;
import com.tencent.mm.f.b.a.lf;
import com.tencent.mm.f.b.a.lg;
import com.tencent.mm.f.b.a.lh;
import com.tencent.mm.f.b.a.li;
import com.tencent.mm.f.b.a.lj;
import com.tencent.mm.f.b.a.lk;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.plugin.groupsolitaire.c.b;
import com.tencent.mm.plugin.groupsolitaire.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private ConcurrentHashMap<Long, Pair<String, String>> Dps;
  private ConcurrentHashMap<Long, Boolean> Dpt;
  public ConcurrentHashMap<Long, a> Dpu;
  private ConcurrentHashMap<Long, d.b> Dpv;
  
  public d()
  {
    AppMethodBeat.i(110384);
    this.Dps = new ConcurrentHashMap();
    this.Dpt = new ConcurrentHashMap();
    this.Dpu = new ConcurrentHashMap();
    this.Dpv = new ConcurrentHashMap();
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
    lh locallh = new lh();
    locallh.Ca(parama.field_key);
    locallh.BY(parama.field_username);
    locallh.BZ(parama.field_creator);
    locallh.gQB = parama.field_msgSvrId;
    locallh.gfj = paramInt;
    locallh.bpa();
    AppMethodBeat.o(110389);
  }
  
  public static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110392);
    lg locallg = new lg();
    locallg.gQF = locallg.z("Identifier", parama.field_key, true);
    locallg.ggg = locallg.z("ChatName", parama.field_username, true);
    locallg.gQB = parama.field_msgSvrId;
    locallg.goP = paramInt1;
    locallg.gHx = paramInt2;
    locallg.bpa();
    AppMethodBeat.o(110392);
  }
  
  public static void a(a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(110390);
    li localli = new li();
    localli.Cc(parama.field_key);
    localli.Cb(parama.field_username);
    localli.gQB = parama.field_msgSvrId;
    localli.gpu = paramInt1;
    localli.gsS = paramInt2;
    if (paramBoolean) {}
    for (localli.gQN = 2L;; localli.gQN = 1L)
    {
      localli.bpa();
      AppMethodBeat.o(110390);
      return;
    }
  }
  
  private static void a(a parama, boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(110386);
    if (paramLong == 0L)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==0 key:%s", new Object[] { parama.field_key });
      AppMethodBeat.o(110386);
      return;
    }
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==%s key:%s", new Object[] { Long.valueOf(paramLong), parama.field_key });
    lf locallf = new lf();
    locallf.BX(parama.field_key);
    locallf.BU(parama.field_username);
    locallf.BV(parama.field_creator);
    if (paramBoolean)
    {
      locallf.BW(paramString);
      locallf.gQI = paramLong;
      if (parama.DpE == 1) {
        locallf.gQJ = parama.header.length();
      }
      locallf.gQK = parama.CBX.length();
      locallf.gQL = parama.DpD.length();
      if (!paramBoolean) {
        break label198;
      }
    }
    label198:
    for (locallf.gQM = 1L;; locallf.gQM = 2L)
    {
      locallf.bpa();
      AppMethodBeat.o(110386);
      return;
      locallf.BW(parama.field_creator);
      break;
    }
  }
  
  public static void a(String paramString, csq paramcsq)
  {
    AppMethodBeat.i(246325);
    lj locallj = new lj();
    locallj.ggg = locallj.z("ChatName", paramString, true);
    locallj.gQB = paramcsq.fNu;
    locallj.gQF = locallj.z("Identifier", paramcsq.key, true);
    locallj.gQO = paramcsq.TAr.size();
    locallj.gQP = paramcsq.TAt;
    locallj.bpa();
    AppMethodBeat.o(246325);
  }
  
  public static void b(a parama, String paramString)
  {
    AppMethodBeat.i(161735);
    if (parama == null)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() groupSolitatire == null");
      AppMethodBeat.o(161735);
      return;
    }
    ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(parama.field_firstMsgId);
    if (parama.field_msgSvrId == 0L)
    {
      parama.field_msgSvrId = localca.field_msgSvrId;
      ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true);
    }
    a(parama, true, paramString, parama.field_msgSvrId);
    AppMethodBeat.o(161735);
  }
  
  public static void eM(String paramString, int paramInt)
  {
    AppMethodBeat.i(110391);
    lk locallk = new lk();
    locallk.ggg = locallk.z("ChatName", paramString, true);
    locallk.gQN = paramInt;
    locallk.bpa();
    AppMethodBeat.o(110391);
  }
  
  public static void x(List<a> paramList, int paramInt)
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
  
  public final void a(long paramLong, a parama1, a parama2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(110385);
    if ((paramLong < 0L) || (parama1 == null))
    {
      AppMethodBeat.o(110385);
      return;
    }
    this.Dps.put(Long.valueOf(paramLong), new Pair(parama1.field_username, parama1.field_key));
    this.Dpt.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    this.Dpv.put(Long.valueOf(paramLong), new d.b(this, parama1, parama2, paramInt));
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
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110382);
        Object localObject1 = "";
        if (parama2 == null)
        {
          i = parama1.DpG.size();
          localObject1 = parama1.bOX;
          j = 0;
          localObject2 = localObject1;
          if (Util.isNullOrNil((String)localObject1)) {
            localObject2 = parama1.bOX;
          }
          localObject1 = new le();
          ((le)localObject1).gQF = ((le)localObject1).z("Identifier", parama1.field_key, true);
          ((le)localObject1).ggg = ((le)localObject1).z("ChatName", parama1.field_username, true);
          ((le)localObject1).gQA = ((le)localObject1).z("LaunchUserName", parama1.field_creator, true);
          ((le)localObject1).gQB = parama1.field_msgSvrId;
          ((le)localObject1).gQC = j;
          ((le)localObject1).gQD = i;
          ((le)localObject1).gQE = paramInt;
          ((le)localObject1).gQG = ((le)localObject1).z("Punctuation", Base64.encodeToString(((String)localObject2).getBytes(), 0), true);
          Log.d("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "separator:%s base64:%s", new Object[] { localObject2, Base64.encodeToString(((String)localObject2).getBytes(), 0) });
          ((le)localObject1).bpa();
          AppMethodBeat.o(110382);
          return;
        }
        Object localObject2 = new HashSet();
        Object localObject3 = new HashMap();
        int i = 1;
        while (i <= parama2.DpG.size())
        {
          b localb = (b)parama2.DpG.get(Integer.valueOf(i));
          if ((localb != null) && (Util.isEqual(localb.username, z.bcZ())))
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
        if (m <= parama1.DpG.size())
        {
          localObject3 = (b)parama1.DpG.get(Integer.valueOf(m));
          k = i;
          if (!Util.isEqual(((b)localObject3).username, z.bcZ())) {
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
          if (Util.isNullOrNil((String)localObject1))
          {
            localObject1 = ((b)localObject3).bOX;
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
  
  public final void af(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(246318);
    Pair localPair = (Pair)this.Dps.remove(Long.valueOf(paramLong1));
    Boolean localBoolean = (Boolean)this.Dpt.remove(Long.valueOf(paramLong1));
    if (localPair != null)
    {
      this.Dps.put(Long.valueOf(paramLong2), localPair);
      this.Dpt.put(Long.valueOf(paramLong2), localBoolean);
    }
    AppMethodBeat.o(246318);
  }
  
  public final class a
  {
    public long DpA = 0L;
    public long Dpz = 0L;
    public String iVe = "";
    public String key = "";
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.d
 * JD-Core Version:    0.7.0.1
 */