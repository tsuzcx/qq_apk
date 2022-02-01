package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class d
  implements f, z
{
  private static Map<Integer, f.a> dio;
  private static Map<Integer, Integer> ruA;
  private Queue<com.tencent.mm.plugin.fav.a.g> dim;
  private boolean diq;
  public int dis;
  private long dit;
  public av dix;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101647);
    dio = new HashMap();
    ruA = new HashMap();
    AppMethodBeat.o(101647);
  }
  
  public d()
  {
    AppMethodBeat.i(101638);
    this.running = false;
    this.dis = 0;
    this.dit = 0L;
    this.diq = false;
    this.dim = new LinkedList();
    this.dix = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(101636);
        try
        {
          d.d(d.this);
          AppMethodBeat.o(101636);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Fav.FavModService", localException, "", new Object[0]);
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101637);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(101637);
        return str;
      }
    }, false);
    com.tencent.mm.kernel.g.aiU().a(426, this);
    AppMethodBeat.o(101638);
  }
  
  private static void a(long paramLong, LinkedList<bzw> paramLinkedList, LinkedList<bzz> paramLinkedList1)
  {
    AppMethodBeat.i(101643);
    Object localObject1 = new bzw();
    ((bzw)localObject1).GUM = 4;
    ((bzw)localObject1).GUN = 0;
    paramLinkedList.add(localObject1);
    paramLinkedList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vA(paramLong);
    ad.i("MicroMsg.Fav.FavModService", "setModAfterClientUpload %d modcdnlistsize %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramLinkedList.size()) });
    paramLinkedList = paramLinkedList.iterator();
    label477:
    while (paramLinkedList.hasNext())
    {
      localObject1 = (c)paramLinkedList.next();
      boolean bool = b.age(((c)localObject1).field_dataId);
      if ((bt.isNullOrNil(((c)localObject1).field_cdnUrl)) || (bool))
      {
        ad.e("MicroMsg.Fav.FavModService", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[] { ((c)localObject1).field_cdnUrl, Boolean.valueOf(bool), Long.valueOf(paramLong) });
      }
      else
      {
        Object localObject2 = new bzz();
        ((bzz)localObject2).uiP = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_dataurl");
        ((bzz)localObject2).yhw = ((c)localObject1).field_cdnUrl;
        paramLinkedList1.add(localObject2);
        localObject2 = new bzz();
        ((bzz)localObject2).uiP = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_datakey");
        ((bzz)localObject2).yhw = ((c)localObject1).field_cdnKey;
        paramLinkedList1.add(localObject2);
        localObject2 = new bzz();
        ((bzz)localObject2).uiP = ("dataitem." + ((c)localObject1).field_dataId);
        ((bzz)localObject2).GUS = "datastatus";
        ((bzz)localObject2).yhw = "0";
        paramLinkedList1.add(localObject2);
        localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(((c)localObject1).field_favLocalId);
        if (localObject2 != null)
        {
          if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_type == 4) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label477;
            }
            localObject2 = b.a((com.tencent.mm.plugin.fav.a.g)localObject2, ((c)localObject1).field_dataId);
            if (localObject2 == null) {
              break;
            }
            bzz localbzz = new bzz();
            localbzz.uiP = ("dataitem." + ((c)localObject1).field_dataId + ".stream_videoid");
            localbzz.yhw = ((ajn)localObject2).GhB;
            paramLinkedList1.add(localbzz);
            break;
          }
        }
      }
    }
    AppMethodBeat.o(101643);
  }
  
  public static void startSync()
  {
    AppMethodBeat.i(101642);
    ak localak = new ak();
    com.tencent.mm.kernel.g.aiU().a(localak, 0);
    AppMethodBeat.o(101642);
  }
  
  public final void Qe()
  {
    AppMethodBeat.i(101641);
    this.dim.clear();
    dio.clear();
    this.running = false;
    this.diq = false;
    ruA.clear();
    AppMethodBeat.o(101641);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(101639);
    if (paramn.getType() != 426)
    {
      AppMethodBeat.o(101639);
      return;
    }
    if (!(paramn instanceof am))
    {
      AppMethodBeat.o(101639);
      return;
    }
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101632);
        d.a(d.this);
        int i = ((am)paramn).rtK;
        d.aaT().remove(Integer.valueOf(i));
        if ((paramInt2 != 3) || (paramInt2 != 0)) {
          d.b(d.this);
        }
        com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vF(i);
        if ((localg == null) || (localg.field_itemStatus == 10))
        {
          AppMethodBeat.o(101632);
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (localg.field_itemStatus == 17)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b.b(localg)), Long.valueOf(h.vx(localg.field_localId)) });
            ad.i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
            localg.field_itemStatus = 10;
            d.B(localg);
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().vB(localg.field_localId);
          }
        }
        while (d.c(d.this) > 0)
        {
          if (d.d(d.this)) {
            break label529;
          }
          d.startSync();
          AppMethodBeat.o(101632);
          return;
          Integer localInteger2 = Integer.valueOf(bt.a((Integer)d.ruA.get(Integer.valueOf(i)), 0));
          Integer localInteger1 = localInteger2;
          if (paramInt1 != 1)
          {
            localInteger1 = localInteger2;
            if (paramInt1 != 0) {
              localInteger1 = Integer.valueOf(localInteger2.intValue() - 1);
            }
          }
          if (localInteger1.intValue() <= 0)
          {
            int j = h.fE(paramInt1, paramInt2);
            com.tencent.mm.plugin.report.service.g.yhR.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(j), Long.valueOf(b.b(localg)), Long.valueOf(h.vx(localg.field_localId)) });
            d.ruA.remove(Integer.valueOf(i));
            ad.e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", new Object[] { Integer.valueOf(i) });
            localg.field_itemStatus = 18;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
          }
        }
        ad.i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
        d.e(d.this);
        label529:
        AppMethodBeat.o(101632);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101633);
        String str = super.toString() + "|onSceneEnd";
        AppMethodBeat.o(101633);
        return str;
      }
    });
    AppMethodBeat.o(101639);
  }
  
  public final void run()
  {
    AppMethodBeat.i(101640);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101634);
        long l = System.currentTimeMillis() - d.f(d.this);
        if (d.g(d.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(101634);
            return;
          }
          ad.e("MicroMsg.Fav.FavModService", "klem ERR: Try Run service runningFlag:" + d.g(d.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + d.g(d.this));
        }
        d.a(d.this);
        d.h(d.this);
        d.i(d.this);
        d.j(d.this).az(10L, 10L);
        AppMethodBeat.o(101634);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101635);
        String str = super.toString() + "|run";
        AppMethodBeat.o(101635);
        return str;
      }
    });
    AppMethodBeat.o(101640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.d
 * JD-Core Version:    0.7.0.1
 */