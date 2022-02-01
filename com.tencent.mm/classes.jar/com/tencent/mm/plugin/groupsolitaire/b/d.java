package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.oe;
import com.tencent.mm.autogen.mmdata.rpt.of;
import com.tencent.mm.autogen.mmdata.rpt.og;
import com.tencent.mm.autogen.mmdata.rpt.oh;
import com.tencent.mm.autogen.mmdata.rpt.oi;
import com.tencent.mm.autogen.mmdata.rpt.oj;
import com.tencent.mm.autogen.mmdata.rpt.ok;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.plugin.groupsolitaire.c.b;
import com.tencent.mm.plugin.groupsolitaire.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private ConcurrentHashMap<Long, Pair<String, String>> Jja;
  private ConcurrentHashMap<Long, Boolean> Jjb;
  public ConcurrentHashMap<Long, a> Jjc;
  private ConcurrentHashMap<Long, d.b> Jjd;
  
  public d()
  {
    AppMethodBeat.i(110384);
    this.Jja = new ConcurrentHashMap();
    this.Jjb = new ConcurrentHashMap();
    this.Jjc = new ConcurrentHashMap();
    this.Jjd = new ConcurrentHashMap();
    AppMethodBeat.o(110384);
  }
  
  public static void Q(List<a> paramList, int paramInt)
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
  
  public static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(110389);
    if (parama == null)
    {
      AppMethodBeat.o(110389);
      return;
    }
    oh localoh = new oh();
    localoh.wk(parama.field_key);
    localoh.wi(parama.field_username);
    localoh.wj(parama.field_creator);
    localoh.jiX = parama.field_msgSvrId;
    localoh.ilI = paramInt;
    localoh.bMH();
    AppMethodBeat.o(110389);
  }
  
  public static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110392);
    og localog = new og();
    localog.jjb = localog.F("Identifier", parama.field_key, true);
    localog.imN = localog.F("ChatName", parama.field_username, true);
    localog.jiX = parama.field_msgSvrId;
    localog.iyq = paramInt1;
    localog.iVP = paramInt2;
    localog.bMH();
    AppMethodBeat.o(110392);
  }
  
  public static void a(a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(110390);
    oi localoi = new oi();
    localoi.wm(parama.field_key);
    localoi.wl(parama.field_username);
    localoi.jiX = parama.field_msgSvrId;
    localoi.izg = paramInt1;
    localoi.iDn = paramInt2;
    if (paramBoolean) {}
    for (localoi.jjj = 2L;; localoi.jjj = 1L)
    {
      localoi.bMH();
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
    of localof = new of();
    localof.wh(parama.field_key);
    localof.we(parama.field_username);
    localof.wf(parama.field_creator);
    if (paramBoolean)
    {
      localof.wg(paramString);
      localof.jje = paramLong;
      if (parama.Jjm == 1) {
        localof.jjf = parama.header.length();
      }
      localof.jjg = parama.IvM.length();
      localof.jjh = parama.Jjl.length();
      if (!paramBoolean) {
        break label198;
      }
    }
    label198:
    for (localof.jji = 1L;; localof.jji = 2L)
    {
      localof.bMH();
      AppMethodBeat.o(110386);
      return;
      localof.wg(parama.field_creator);
      break;
    }
  }
  
  public static void a(String paramString, djs paramdjs)
  {
    AppMethodBeat.i(262651);
    oj localoj = new oj();
    localoj.imN = localoj.F("ChatName", paramString, true);
    localoj.jiX = paramdjs.hTh;
    localoj.jjb = localoj.F("Identifier", paramdjs.key, true);
    localoj.jjk = paramdjs.aaPF.size();
    localoj.jjl = paramdjs.aaPH;
    localoj.bMH();
    AppMethodBeat.o(262651);
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
    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(parama.field_firstMsgId);
    if (localcc == null)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() msg==null key:%s", new Object[] { parama.field_key });
      AppMethodBeat.o(161735);
      return;
    }
    if (parama.field_msgSvrId == 0L)
    {
      parama.field_msgSvrId = localcc.field_msgSvrId;
      ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true);
    }
    a(parama, true, paramString, parama.field_msgSvrId);
    AppMethodBeat.o(161735);
  }
  
  public static void fE(String paramString, int paramInt)
  {
    AppMethodBeat.i(110391);
    ok localok = new ok();
    localok.imN = localok.F("ChatName", paramString, true);
    localok.jjj = paramInt;
    localok.bMH();
    AppMethodBeat.o(110391);
  }
  
  public final void a(long paramLong, a parama1, a parama2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(110385);
    if ((paramLong < 0L) || (parama1 == null))
    {
      AppMethodBeat.o(110385);
      return;
    }
    this.Jja.put(Long.valueOf(paramLong), new Pair(parama1.field_username, parama1.field_key));
    this.Jjb.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    this.Jjd.put(Long.valueOf(paramLong), new d.b(this, parama1, parama2, paramInt));
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
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110382);
        Object localObject1 = "";
        if (parama2 == null)
        {
          i = parama1.Jjo.size();
          localObject1 = parama1.dIC;
          j = 0;
          localObject2 = localObject1;
          if (Util.isNullOrNil((String)localObject1)) {
            localObject2 = parama1.dIC;
          }
          localObject1 = new oe();
          ((oe)localObject1).jjb = ((oe)localObject1).F("Identifier", parama1.field_key, true);
          ((oe)localObject1).imN = ((oe)localObject1).F("ChatName", parama1.field_username, true);
          ((oe)localObject1).jiW = ((oe)localObject1).F("LaunchUserName", parama1.field_creator, true);
          ((oe)localObject1).jiX = parama1.field_msgSvrId;
          ((oe)localObject1).jiY = j;
          ((oe)localObject1).jiZ = i;
          ((oe)localObject1).jja = paramInt;
          ((oe)localObject1).jjc = ((oe)localObject1).F("Punctuation", Base64.encodeToString(((String)localObject2).getBytes(), 0), true);
          Log.d("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "separator:%s base64:%s", new Object[] { localObject2, Base64.encodeToString(((String)localObject2).getBytes(), 0) });
          ((oe)localObject1).bMH();
          AppMethodBeat.o(110382);
          return;
        }
        Object localObject2 = new HashSet();
        Object localObject3 = new HashMap();
        int i = 1;
        while (i <= parama2.Jjo.size())
        {
          b localb = (b)parama2.Jjo.get(Integer.valueOf(i));
          if ((localb != null) && (Util.isEqual(localb.username, z.bAM())))
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
        if (m <= parama1.Jjo.size())
        {
          localObject3 = (b)parama1.Jjo.get(Integer.valueOf(m));
          k = i;
          if (!Util.isEqual(((b)localObject3).username, z.bAM())) {
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
            localObject1 = ((b)localObject3).dIC;
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
  
  public final void aJ(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(262660);
    Pair localPair = (Pair)this.Jja.remove(Long.valueOf(paramLong1));
    Boolean localBoolean = (Boolean)this.Jjb.remove(Long.valueOf(paramLong1));
    if (localPair != null)
    {
      this.Jja.put(Long.valueOf(paramLong2), localPair);
      this.Jjb.put(Long.valueOf(paramLong2), localBoolean);
    }
    AppMethodBeat.o(262660);
  }
  
  public final class a
  {
    public long Jjh = 0L;
    public long Jji = 0L;
    public String key = "";
    public String lxj = "";
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.d
 * JD-Core Version:    0.7.0.1
 */