package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Base64;
import android.util.Pair;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eh;
import com.tencent.mm.g.b.a.ei;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.g.b.a.ek;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.g.b.a.en;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.plugin.groupsolitaire.c.b;
import com.tencent.mm.plugin.groupsolitaire.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  ConcurrentHashMap<Long, Pair<String, String>> tyD;
  ConcurrentHashMap<Long, Boolean> tyE;
  public ConcurrentHashMap<Long, a> tyF;
  ConcurrentHashMap<Long, d.b> tyG;
  
  public d()
  {
    AppMethodBeat.i(110384);
    this.tyD = new ConcurrentHashMap();
    this.tyE = new ConcurrentHashMap();
    this.tyF = new ConcurrentHashMap();
    this.tyG = new ConcurrentHashMap();
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
    ek localek = new ek();
    localek.mi(parama.field_key);
    localek.mg(parama.field_username);
    localek.mh(parama.field_creator);
    localek.dUy = parama.field_msgSvrId;
    localek.dUL = paramInt;
    localek.aHZ();
    AppMethodBeat.o(110389);
  }
  
  public static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110392);
    ej localej = new ej();
    localej.dUC = localej.t("Identifier", parama.field_key, true);
    localej.dEE = localej.t("ChatName", parama.field_username, true);
    localej.dUy = parama.field_msgSvrId;
    localej.dIi = paramInt1;
    localej.dUK = paramInt2;
    localej.aHZ();
    AppMethodBeat.o(110392);
  }
  
  public static void a(a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(110390);
    el localel = new el();
    localel.mk(parama.field_key);
    localel.mj(parama.field_username);
    localel.dUy = parama.field_msgSvrId;
    localel.dII = paramInt1;
    localel.dNu = paramInt2;
    if (paramBoolean) {}
    for (localel.dUM = 2L;; localel.dUM = 1L)
    {
      localel.aHZ();
      AppMethodBeat.o(110390);
      return;
    }
  }
  
  static void a(a parama, boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(110386);
    if (paramLong == 0L)
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==0 key:%s", new Object[] { parama.field_key });
      AppMethodBeat.o(110386);
      return;
    }
    ac.i("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==%s key:%s", new Object[] { Long.valueOf(paramLong), parama.field_key });
    ei localei = new ei();
    localei.mf(parama.field_key);
    localei.mc(parama.field_username);
    localei.md(parama.field_creator);
    if (paramBoolean)
    {
      localei.me(paramString);
      localei.dUF = paramLong;
      if (parama.tyQ == 1) {
        localei.dUG = parama.header.length();
      }
      localei.dUH = parama.tyP.length();
      localei.dUI = parama.tyO.length();
      if (!paramBoolean) {
        break label198;
      }
    }
    label198:
    for (localei.dUJ = 1L;; localei.dUJ = 2L)
    {
      localei.aHZ();
      AppMethodBeat.o(110386);
      return;
      localei.me(parama.field_creator);
      break;
    }
  }
  
  public static void b(a parama, String paramString)
  {
    AppMethodBeat.i(161735);
    if (parama == null)
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() groupSolitatire == null");
      AppMethodBeat.o(161735);
      return;
    }
    bo localbo = ((k)g.ab(k.class)).dcr().vP(parama.field_firstMsgId);
    if (parama.field_msgSvrId == 0L)
    {
      parama.field_msgSvrId = localbo.field_msgSvrId;
      ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true);
    }
    a(parama, true, paramString, parama.field_msgSvrId);
    AppMethodBeat.o(161735);
  }
  
  public static void dB(String paramString, int paramInt)
  {
    AppMethodBeat.i(110391);
    en localen = new en();
    localen.dEE = localen.t("ChatName", paramString, true);
    localen.dUM = paramInt;
    localen.aHZ();
    AppMethodBeat.o(110391);
  }
  
  public static void q(List<a> paramList, int paramInt)
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
    AppMethodBeat.i(192999);
    Pair localPair = (Pair)this.tyD.remove(Long.valueOf(paramLong1));
    Boolean localBoolean = (Boolean)this.tyE.remove(Long.valueOf(paramLong1));
    if (localPair != null)
    {
      this.tyD.put(Long.valueOf(paramLong2), localPair);
      this.tyE.put(Long.valueOf(paramLong2), localBoolean);
    }
    AppMethodBeat.o(192999);
  }
  
  public final void a(long paramLong, a parama1, a parama2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(110385);
    if ((paramLong < 0L) || (parama1 == null))
    {
      AppMethodBeat.o(110385);
      return;
    }
    this.tyD.put(Long.valueOf(paramLong), new Pair(parama1.field_username, parama1.field_key));
    this.tyE.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    this.tyG.put(Long.valueOf(paramLong), new d.b(this, parama1, parama2, paramInt));
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
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110382);
        Object localObject1 = "";
        if (parama2 == null)
        {
          i = parama1.tyS.size();
          localObject1 = parama1.separator;
          j = 0;
          localObject2 = localObject1;
          if (bs.isNullOrNil((String)localObject1)) {
            localObject2 = parama1.separator;
          }
          localObject1 = new eh();
          ((eh)localObject1).dUC = ((eh)localObject1).t("Identifier", parama1.field_key, true);
          ((eh)localObject1).dEE = ((eh)localObject1).t("ChatName", parama1.field_username, true);
          ((eh)localObject1).dUx = ((eh)localObject1).t("LaunchUserName", parama1.field_creator, true);
          ((eh)localObject1).dUy = parama1.field_msgSvrId;
          ((eh)localObject1).dUz = j;
          ((eh)localObject1).dUA = i;
          ((eh)localObject1).dUB = paramInt;
          ((eh)localObject1).dUD = ((eh)localObject1).t("Punctuation", Base64.encodeToString(((String)localObject2).getBytes(), 0), true);
          ac.d("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "separator:%s base64:%s", new Object[] { localObject2, Base64.encodeToString(((String)localObject2).getBytes(), 0) });
          ((eh)localObject1).aHZ();
          AppMethodBeat.o(110382);
          return;
        }
        Object localObject2 = new HashSet();
        Object localObject3 = new HashMap();
        int i = 1;
        while (i <= parama2.tyS.size())
        {
          b localb = (b)parama2.tyS.get(Integer.valueOf(i));
          if ((localb != null) && (bs.lr(localb.username, u.axw())))
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
        if (m <= parama1.tyS.size())
        {
          localObject3 = (b)parama1.tyS.get(Integer.valueOf(m));
          k = i;
          if (!bs.lr(((b)localObject3).username, u.axw())) {
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
          if (bs.isNullOrNil((String)localObject1))
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
    public String frx = "";
    public String key = "";
    public long tyK = 0L;
    public long tyL = 0L;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.d
 * JD-Core Version:    0.7.0.1
 */