package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class d
  implements com.tencent.mm.ak.g, z
{
  private static Map<Integer, f.a> cWY;
  private static Map<Integer, Integer> qKy;
  private Queue<com.tencent.mm.plugin.fav.a.g> cWW;
  private boolean cXa;
  public int cXb;
  private long cXc;
  public au cXg;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101647);
    cWY = new HashMap();
    qKy = new HashMap();
    AppMethodBeat.o(101647);
  }
  
  public d()
  {
    AppMethodBeat.i(101638);
    this.running = false;
    this.cXb = 0;
    this.cXc = 0L;
    this.cXa = false;
    this.cWW = new LinkedList();
    this.cXg = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
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
            ac.printErrStackTrace("MicroMsg.Fav.FavModService", localException, "", new Object[0]);
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
    com.tencent.mm.kernel.g.agi().a(426, this);
    AppMethodBeat.o(101638);
  }
  
  private static void a(long paramLong, LinkedList<bvh> paramLinkedList, LinkedList<bvk> paramLinkedList1)
  {
    AppMethodBeat.i(101643);
    Object localObject1 = new bvh();
    ((bvh)localObject1).Fle = 4;
    ((bvh)localObject1).Flf = 0;
    paramLinkedList.add(localObject1);
    paramLinkedList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().tD(paramLong);
    ac.i("MicroMsg.Fav.FavModService", "setModAfterClientUpload %d modcdnlistsize %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramLinkedList.size()) });
    paramLinkedList = paramLinkedList.iterator();
    label477:
    while (paramLinkedList.hasNext())
    {
      localObject1 = (c)paramLinkedList.next();
      boolean bool = b.acp(((c)localObject1).field_dataId);
      if ((bs.isNullOrNil(((c)localObject1).field_cdnUrl)) || (bool))
      {
        ac.e("MicroMsg.Fav.FavModService", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[] { ((c)localObject1).field_cdnUrl, Boolean.valueOf(bool), Long.valueOf(paramLong) });
      }
      else
      {
        Object localObject2 = new bvk();
        ((bvk)localObject2).tkJ = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_dataurl");
        ((bvk)localObject2).wTM = ((c)localObject1).field_cdnUrl;
        paramLinkedList1.add(localObject2);
        localObject2 = new bvk();
        ((bvk)localObject2).tkJ = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_datakey");
        ((bvk)localObject2).wTM = ((c)localObject1).field_cdnKey;
        paramLinkedList1.add(localObject2);
        localObject2 = new bvk();
        ((bvk)localObject2).tkJ = ("dataitem." + ((c)localObject1).field_dataId);
        ((bvk)localObject2).Flk = "datastatus";
        ((bvk)localObject2).wTM = "0";
        paramLinkedList1.add(localObject2);
        localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(((c)localObject1).field_favLocalId);
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
            bvk localbvk = new bvk();
            localbvk.tkJ = ("dataitem." + ((c)localObject1).field_dataId + ".stream_videoid");
            localbvk.wTM = ((agx)localObject2).EzP;
            paramLinkedList1.add(localbvk);
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
    com.tencent.mm.kernel.g.agi().a(localak, 0);
    AppMethodBeat.o(101642);
  }
  
  public final void Ou()
  {
    AppMethodBeat.i(101641);
    this.cWW.clear();
    cWY.clear();
    this.running = false;
    this.cXa = false;
    qKy.clear();
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
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101632);
        d.a(d.this);
        int i = ((am)paramn).qJI;
        d.Yr().remove(Integer.valueOf(i));
        if ((paramInt2 != 3) || (paramInt2 != 0)) {
          d.b(d.this);
        }
        com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(i);
        if ((localg == null) || (localg.field_itemStatus == 10))
        {
          AppMethodBeat.o(101632);
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (localg.field_itemStatus == 17)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.tA(localg.field_localId)) });
            ac.i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
            localg.field_itemStatus = 10;
            d.B(localg);
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().tE(localg.field_localId);
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
          Integer localInteger2 = Integer.valueOf(bs.a((Integer)d.qKy.get(Integer.valueOf(i)), 0));
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
            int j = com.tencent.mm.plugin.fav.a.h.fw(paramInt1, paramInt2);
            com.tencent.mm.plugin.report.service.h.wUl.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(j), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.tA(localg.field_localId)) });
            d.qKy.remove(Integer.valueOf(i));
            ac.e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", new Object[] { Integer.valueOf(i) });
            localg.field_itemStatus = 18;
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
          }
        }
        ac.i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
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
    com.tencent.mm.kernel.g.agU().az(new Runnable()
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
          ac.e("MicroMsg.Fav.FavModService", "klem ERR: Try Run service runningFlag:" + d.g(d.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + d.g(d.this));
        }
        d.a(d.this);
        d.h(d.this);
        d.i(d.this);
        d.j(d.this).au(10L, 10L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.d
 * JD-Core Version:    0.7.0.1
 */