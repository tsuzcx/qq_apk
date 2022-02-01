package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class d
  implements i, aa
{
  private static Map<Integer, f.a> ftr;
  private static Map<Integer, Integer> wIw;
  private Queue<g> ftp;
  private boolean ftt;
  public int ftu;
  private long ftv;
  public MTimerHandler fty;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101647);
    ftr = new HashMap();
    wIw = new HashMap();
    AppMethodBeat.o(101647);
  }
  
  public d()
  {
    AppMethodBeat.i(101638);
    this.running = false;
    this.ftu = 0;
    this.ftv = 0L;
    this.ftt = false;
    this.ftp = new LinkedList();
    this.fty = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
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
            Log.printErrStackTrace("MicroMsg.Fav.FavModService", localException, "", new Object[0]);
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
    com.tencent.mm.kernel.h.aGY().a(426, this);
    AppMethodBeat.o(101638);
  }
  
  private static void a(long paramLong, LinkedList<cyi> paramLinkedList, LinkedList<cyl> paramLinkedList1)
  {
    AppMethodBeat.i(101643);
    Object localObject1 = new cyi();
    ((cyi)localObject1).TGG = 4;
    ((cyi)localObject1).TGH = 0;
    paramLinkedList.add(localObject1);
    paramLinkedList = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().Ki(paramLong);
    Log.i("MicroMsg.Fav.FavModService", "setModAfterClientUpload %d modcdnlistsize %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramLinkedList.size()) });
    paramLinkedList = paramLinkedList.iterator();
    label477:
    while (paramLinkedList.hasNext())
    {
      localObject1 = (c)paramLinkedList.next();
      boolean bool = b.azK(((c)localObject1).field_dataId);
      if ((Util.isNullOrNil(((c)localObject1).field_cdnUrl)) || (bool))
      {
        Log.e("MicroMsg.Fav.FavModService", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[] { ((c)localObject1).field_cdnUrl, Boolean.valueOf(bool), Long.valueOf(paramLong) });
      }
      else
      {
        Object localObject2 = new cyl();
        ((cyl)localObject2).CQx = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_dataurl");
        ((cyl)localObject2).Izj = ((c)localObject1).field_cdnUrl;
        paramLinkedList1.add(localObject2);
        localObject2 = new cyl();
        ((cyl)localObject2).CQx = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_datakey");
        ((cyl)localObject2).Izj = ((c)localObject1).field_cdnKey;
        paramLinkedList1.add(localObject2);
        localObject2 = new cyl();
        ((cyl)localObject2).CQx = ("dataitem." + ((c)localObject1).field_dataId);
        ((cyl)localObject2).TGM = "datastatus";
        ((cyl)localObject2).Izj = "0";
        paramLinkedList1.add(localObject2);
        localObject2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(((c)localObject1).field_favLocalId);
        if (localObject2 != null)
        {
          if (((g)localObject2).field_type == 4) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label477;
            }
            localObject2 = b.a((g)localObject2, ((c)localObject1).field_dataId);
            if (localObject2 == null) {
              break;
            }
            cyl localcyl = new cyl();
            localcyl.CQx = ("dataitem." + ((c)localObject1).field_dataId + ".stream_videoid");
            localcyl.Izj = ((anm)localObject2).Syw;
            paramLinkedList1.add(localcyl);
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
    al localal = new al();
    com.tencent.mm.kernel.h.aGY().a(localal, 0);
    AppMethodBeat.o(101642);
  }
  
  public final void afk()
  {
    AppMethodBeat.i(101641);
    this.ftp.clear();
    ftr.clear();
    this.running = false;
    this.ftt = false;
    wIw.clear();
    AppMethodBeat.o(101641);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(101639);
    if (paramq.getType() != 426)
    {
      AppMethodBeat.o(101639);
      return;
    }
    if (!(paramq instanceof an))
    {
      AppMethodBeat.o(101639);
      return;
    }
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101632);
        d.a(d.this);
        int i = ((an)paramq).wHG;
        d.avo().remove(Integer.valueOf(i));
        if ((paramInt2 != 3) || (paramInt2 != 0)) {
          d.b(d.this);
        }
        g localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Kn(i);
        if ((localg == null) || (localg.field_itemStatus == 10))
        {
          AppMethodBeat.o(101632);
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (localg.field_itemStatus == 17)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.Kf(localg.field_localId)) });
            Log.i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
            localg.field_itemStatus = 10;
            d.B(localg);
            ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
            ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().Kj(localg.field_localId);
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
          Integer localInteger2 = Integer.valueOf(Util.nullAs((Integer)d.wIw.get(Integer.valueOf(i)), 0));
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
            int j = com.tencent.mm.plugin.fav.a.h.gp(paramInt1, paramInt2);
            com.tencent.mm.plugin.report.service.h.IzE.a(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(j), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.Kf(localg.field_localId)) });
            d.wIw.remove(Integer.valueOf(i));
            Log.e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", new Object[] { Integer.valueOf(i) });
            localg.field_itemStatus = 18;
            ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
          }
        }
        Log.i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
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
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
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
          Log.e("MicroMsg.Fav.FavModService", "klem ERR: Try Run service runningFlag:" + d.g(d.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + d.g(d.this));
        }
        d.a(d.this);
        d.h(d.this);
        d.i(d.this);
        d.j(d.this).startTimer(10L);
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