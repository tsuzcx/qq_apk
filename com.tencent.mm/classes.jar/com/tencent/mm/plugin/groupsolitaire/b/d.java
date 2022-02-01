package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Base64;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.g.b.a.iv;
import com.tencent.mm.g.b.a.iw;
import com.tencent.mm.g.b.a.ix;
import com.tencent.mm.g.b.a.iy;
import com.tencent.mm.g.b.a.iz;
import com.tencent.mm.g.b.a.jb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.plugin.groupsolitaire.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  ConcurrentHashMap<Long, Pair<String, String>> yfq;
  ConcurrentHashMap<Long, Boolean> yfr;
  public ConcurrentHashMap<Long, a> yfs;
  ConcurrentHashMap<Long, b> yft;
  
  public d()
  {
    AppMethodBeat.i(110384);
    this.yfq = new ConcurrentHashMap();
    this.yfr = new ConcurrentHashMap();
    this.yfs = new ConcurrentHashMap();
    this.yft = new ConcurrentHashMap();
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
    iy localiy = new iy();
    localiy.wz(parama.field_key);
    localiy.wx(parama.field_username);
    localiy.wy(parama.field_creator);
    localiy.eQf = parama.field_msgSvrId;
    localiy.ekE = paramInt;
    localiy.bfK();
    AppMethodBeat.o(110389);
  }
  
  public static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110392);
    ix localix = new ix();
    localix.eQj = localix.x("Identifier", parama.field_key, true);
    localix.emL = localix.x("ChatName", parama.field_username, true);
    localix.eQf = parama.field_msgSvrId;
    localix.esI = paramInt1;
    localix.eIW = paramInt2;
    localix.bfK();
    AppMethodBeat.o(110392);
  }
  
  public static void a(a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(110390);
    iz localiz = new iz();
    localiz.wB(parama.field_key);
    localiz.wA(parama.field_username);
    localiz.eQf = parama.field_msgSvrId;
    localiz.etp = paramInt1;
    localiz.ewL = paramInt2;
    if (paramBoolean) {}
    for (localiz.eQr = 2L;; localiz.eQr = 1L)
    {
      localiz.bfK();
      AppMethodBeat.o(110390);
      return;
    }
  }
  
  static void a(a parama, boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(110386);
    if (paramLong == 0L)
    {
      Log.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==0 key:%s", new Object[] { parama.field_key });
      AppMethodBeat.o(110386);
      return;
    }
    Log.i("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==%s key:%s", new Object[] { Long.valueOf(paramLong), parama.field_key });
    iw localiw = new iw();
    localiw.ww(parama.field_key);
    localiw.wt(parama.field_username);
    localiw.wu(parama.field_creator);
    if (paramBoolean)
    {
      localiw.wv(paramString);
      localiw.eQm = paramLong;
      if (parama.yfC == 1) {
        localiw.eQn = parama.header.length();
      }
      localiw.eQo = parama.xxN.length();
      localiw.eQp = parama.yfB.length();
      if (!paramBoolean) {
        break label198;
      }
    }
    label198:
    for (localiw.eQq = 1L;; localiw.eQq = 2L)
    {
      localiw.bfK();
      AppMethodBeat.o(110386);
      return;
      localiw.wv(parama.field_creator);
      break;
    }
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
    ca localca = ((l)g.af(l.class)).eiy().Hb(parama.field_firstMsgId);
    if (parama.field_msgSvrId == 0L)
    {
      parama.field_msgSvrId = localca.field_msgSvrId;
      ((PluginGroupSolitaire)g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(parama, true);
    }
    a(parama, true, paramString, parama.field_msgSvrId);
    AppMethodBeat.o(161735);
  }
  
  public static void en(String paramString, int paramInt)
  {
    AppMethodBeat.i(110391);
    jb localjb = new jb();
    localjb.emL = localjb.x("ChatName", paramString, true);
    localjb.eQr = paramInt;
    localjb.bfK();
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
  
  public final void Y(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194434);
    Pair localPair = (Pair)this.yfq.remove(Long.valueOf(paramLong1));
    Boolean localBoolean = (Boolean)this.yfr.remove(Long.valueOf(paramLong1));
    if (localPair != null)
    {
      this.yfq.put(Long.valueOf(paramLong2), localPair);
      this.yfr.put(Long.valueOf(paramLong2), localBoolean);
    }
    AppMethodBeat.o(194434);
  }
  
  public final void a(long paramLong, a parama1, a parama2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(110385);
    if ((paramLong < 0L) || (parama1 == null))
    {
      AppMethodBeat.o(110385);
      return;
    }
    this.yfq.put(Long.valueOf(paramLong), new Pair(parama1.field_username, parama1.field_key));
    this.yfr.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
    this.yft.put(Long.valueOf(paramLong), new b(parama1, parama2, paramInt));
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
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110382);
        Object localObject1 = "";
        if (parama2 == null)
        {
          i = parama1.yfE.size();
          localObject1 = parama1.separator;
          j = 0;
          localObject2 = localObject1;
          if (Util.isNullOrNil((String)localObject1)) {
            localObject2 = parama1.separator;
          }
          localObject1 = new iv();
          ((iv)localObject1).eQj = ((iv)localObject1).x("Identifier", parama1.field_key, true);
          ((iv)localObject1).emL = ((iv)localObject1).x("ChatName", parama1.field_username, true);
          ((iv)localObject1).eQe = ((iv)localObject1).x("LaunchUserName", parama1.field_creator, true);
          ((iv)localObject1).eQf = parama1.field_msgSvrId;
          ((iv)localObject1).eQg = j;
          ((iv)localObject1).eQh = i;
          ((iv)localObject1).eQi = paramInt;
          ((iv)localObject1).eQk = ((iv)localObject1).x("Punctuation", Base64.encodeToString(((String)localObject2).getBytes(), 0), true);
          Log.d("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "separator:%s base64:%s", new Object[] { localObject2, Base64.encodeToString(((String)localObject2).getBytes(), 0) });
          ((iv)localObject1).bfK();
          AppMethodBeat.o(110382);
          return;
        }
        Object localObject2 = new HashSet();
        Object localObject3 = new HashMap();
        int i = 1;
        while (i <= parama2.yfE.size())
        {
          b localb = (b)parama2.yfE.get(Integer.valueOf(i));
          if ((localb != null) && (Util.isEqual(localb.username, z.aTY())))
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
        if (m <= parama1.yfE.size())
        {
          localObject3 = (b)parama1.yfE.get(Integer.valueOf(m));
          k = i;
          if (!Util.isEqual(((b)localObject3).username, z.aTY())) {
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
    public String gqV = "";
    public String key = "";
    public long yfx = 0L;
    public long yfy = 0L;
    
    public a() {}
  }
  
  final class b
  {
    int scene;
    a yfA;
    a yfz;
    
    public b(a parama1, a parama2, int paramInt)
    {
      this.yfz = parama1;
      this.yfA = parama2;
      this.scene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.d
 * JD-Core Version:    0.7.0.1
 */