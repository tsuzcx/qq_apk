package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Base64;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.na;
import com.tencent.mm.g.b.a.fg;
import com.tencent.mm.g.b.a.fh;
import com.tencent.mm.g.b.a.fi;
import com.tencent.mm.g.b.a.fj;
import com.tencent.mm.g.b.a.fk;
import com.tencent.mm.g.b.a.fm;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  ConcurrentHashMap<Long, Pair<String, String>> uBn;
  ConcurrentHashMap<Long, Boolean> uBo;
  public ConcurrentHashMap<Long, a> uBp;
  ConcurrentHashMap<Long, b> uBq;
  
  public d()
  {
    AppMethodBeat.i(110384);
    this.uBn = new ConcurrentHashMap();
    this.uBo = new ConcurrentHashMap();
    this.uBp = new ConcurrentHashMap();
    this.uBq = new ConcurrentHashMap();
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
    fj localfj = new fj();
    localfj.ov(parama.field_key);
    localfj.ot(parama.field_username);
    localfj.ou(parama.field_creator);
    localfj.ekQ = parama.field_msgSvrId;
    localfj.eld = paramInt;
    localfj.aLk();
    AppMethodBeat.o(110389);
  }
  
  public static void a(com.tencent.mm.plugin.groupsolitaire.c.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110392);
    fi localfi = new fi();
    localfi.ekU = localfi.t("Identifier", parama.field_key, true);
    localfi.dRB = localfi.t("ChatName", parama.field_username, true);
    localfi.ekQ = parama.field_msgSvrId;
    localfi.dVP = paramInt1;
    localfi.elc = paramInt2;
    localfi.aLk();
    AppMethodBeat.o(110392);
  }
  
  public static void a(com.tencent.mm.plugin.groupsolitaire.c.a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(110390);
    fk localfk = new fk();
    localfk.ox(parama.field_key);
    localfk.ow(parama.field_username);
    localfk.ekQ = parama.field_msgSvrId;
    localfk.dWq = paramInt1;
    localfk.ecJ = paramInt2;
    if (paramBoolean) {}
    for (localfk.ele = 2L;; localfk.ele = 1L)
    {
      localfk.aLk();
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
    fh localfh = new fh();
    localfh.os(parama.field_key);
    localfh.op(parama.field_username);
    localfh.oq(parama.field_creator);
    if (paramBoolean)
    {
      localfh.or(paramString);
      localfh.ekX = paramLong;
      if (parama.uBz == 1) {
        localfh.ekY = parama.header.length();
      }
      localfh.ekZ = parama.tUK.length();
      localfh.ela = parama.uBy.length();
      if (!paramBoolean) {
        break label198;
      }
    }
    label198:
    for (localfh.elb = 1L;; localfh.elb = 2L)
    {
      localfh.aLk();
      AppMethodBeat.o(110386);
      return;
      localfh.or(parama.field_creator);
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
    bu localbu = ((l)g.ab(l.class)).dlK().xY(parama.field_firstMsgId);
    if (parama.field_msgSvrId == 0L)
    {
      parama.field_msgSvrId = localbu.field_msgSvrId;
      ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true);
    }
    a(parama, true, paramString, parama.field_msgSvrId);
    AppMethodBeat.o(161735);
  }
  
  public static void dS(String paramString, int paramInt)
  {
    AppMethodBeat.i(110391);
    fm localfm = new fm();
    localfm.dRB = localfm.t("ChatName", paramString, true);
    localfm.ele = paramInt;
    localfm.aLk();
    AppMethodBeat.o(110391);
  }
  
  public static void s(List<com.tencent.mm.plugin.groupsolitaire.c.a> paramList, int paramInt)
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
  
  public final void V(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(215780);
    Pair localPair = (Pair)this.uBn.remove(Long.valueOf(paramLong1));
    Boolean localBoolean = (Boolean)this.uBo.remove(Long.valueOf(paramLong1));
    if (localPair != null)
    {
      this.uBn.put(Long.valueOf(paramLong2), localPair);
      this.uBo.put(Long.valueOf(paramLong2), localBoolean);
    }
    AppMethodBeat.o(215780);
  }
  
  public final void a(long paramLong, com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(110385);
    if ((paramLong < 0L) || (parama1 == null))
    {
      AppMethodBeat.o(110385);
      return;
    }
    this.uBn.put(Long.valueOf(paramLong), new Pair(parama1.field_username, parama1.field_key));
    this.uBo.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    this.uBq.put(Long.valueOf(paramLong), new b(parama1, parama2, paramInt));
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
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110382);
        Object localObject1 = "";
        if (parama2 == null)
        {
          i = parama1.uBB.size();
          localObject1 = parama1.separator;
          j = 0;
          localObject2 = localObject1;
          if (bt.isNullOrNil((String)localObject1)) {
            localObject2 = parama1.separator;
          }
          localObject1 = new fg();
          ((fg)localObject1).ekU = ((fg)localObject1).t("Identifier", parama1.field_key, true);
          ((fg)localObject1).dRB = ((fg)localObject1).t("ChatName", parama1.field_username, true);
          ((fg)localObject1).ekP = ((fg)localObject1).t("LaunchUserName", parama1.field_creator, true);
          ((fg)localObject1).ekQ = parama1.field_msgSvrId;
          ((fg)localObject1).ekR = j;
          ((fg)localObject1).ekS = i;
          ((fg)localObject1).ekT = paramInt;
          ((fg)localObject1).ekV = ((fg)localObject1).t("Punctuation", Base64.encodeToString(((String)localObject2).getBytes(), 0), true);
          ad.d("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "separator:%s base64:%s", new Object[] { localObject2, Base64.encodeToString(((String)localObject2).getBytes(), 0) });
          ((fg)localObject1).aLk();
          AppMethodBeat.o(110382);
          return;
        }
        Object localObject2 = new HashSet();
        Object localObject3 = new HashMap();
        int i = 1;
        while (i <= parama2.uBB.size())
        {
          b localb = (b)parama2.uBB.get(Integer.valueOf(i));
          if ((localb != null) && (bt.lQ(localb.username, u.aAm())))
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
        if (m <= parama1.uBB.size())
        {
          localObject3 = (b)parama1.uBB.get(Integer.valueOf(m));
          k = i;
          if (!bt.lQ(((b)localObject3).username, u.aAm())) {
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
    public String fJG = "";
    public String key = "";
    public long uBu = 0L;
    public long uBv = 0L;
    
    public a() {}
  }
  
  final class b
  {
    int scene;
    com.tencent.mm.plugin.groupsolitaire.c.a uBw;
    com.tencent.mm.plugin.groupsolitaire.c.a uBx;
    
    public b(com.tencent.mm.plugin.groupsolitaire.c.a parama1, com.tencent.mm.plugin.groupsolitaire.c.a parama2, int paramInt)
    {
      this.uBw = parama1;
      this.uBx = parama2;
      this.scene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.d
 * JD-Core Version:    0.7.0.1
 */