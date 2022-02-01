package com.tencent.mm.plugin.fav.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.dpo;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class d
  implements com.tencent.mm.am.h, aa
{
  private static Map<Integer, Integer> AeK;
  private static Map<Integer, f.a> hxG;
  private Queue<g> hxE;
  private boolean hxI;
  public int hxJ;
  private long hxK;
  public MTimerHandler hxN;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(101647);
    hxG = new HashMap();
    AeK = new HashMap();
    AppMethodBeat.o(101647);
  }
  
  public d()
  {
    AppMethodBeat.i(101638);
    this.running = false;
    this.hxJ = 0;
    this.hxK = 0L;
    this.hxI = false;
    this.hxE = new LinkedList();
    this.hxN = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new d.3(this), false);
    com.tencent.mm.kernel.h.aZW().a(426, this);
    AppMethodBeat.o(101638);
  }
  
  private static void a(long paramLong, LinkedList<dpo> paramLinkedList, LinkedList<dpr> paramLinkedList1)
  {
    AppMethodBeat.i(101643);
    Object localObject1 = new dpo();
    ((dpo)localObject1).aaWn = 4;
    ((dpo)localObject1).aaWo = 0;
    paramLinkedList.add(localObject1);
    paramLinkedList = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().mG(paramLong);
    Log.i("MicroMsg.Fav.FavModService", "setModAfterClientUpload %d modcdnlistsize %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramLinkedList.size()) });
    paramLinkedList = paramLinkedList.iterator();
    label477:
    while (paramLinkedList.hasNext())
    {
      localObject1 = (c)paramLinkedList.next();
      boolean bool = b.atQ(((c)localObject1).field_dataId);
      if ((Util.isNullOrNil(((c)localObject1).field_cdnUrl)) || (bool))
      {
        Log.e("MicroMsg.Fav.FavModService", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[] { ((c)localObject1).field_cdnUrl, Boolean.valueOf(bool), Long.valueOf(paramLong) });
      }
      else
      {
        Object localObject2 = new dpr();
        ((dpr)localObject2).IKH = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_dataurl");
        ((dpr)localObject2).OzQ = ((c)localObject1).field_cdnUrl;
        paramLinkedList1.add(localObject2);
        localObject2 = new dpr();
        ((dpr)localObject2).IKH = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_datakey");
        ((dpr)localObject2).OzQ = ((c)localObject1).field_cdnKey;
        paramLinkedList1.add(localObject2);
        localObject2 = new dpr();
        ((dpr)localObject2).IKH = ("dataitem." + ((c)localObject1).field_dataId);
        ((dpr)localObject2).aaWt = "datastatus";
        ((dpr)localObject2).OzQ = "0";
        paramLinkedList1.add(localObject2);
        localObject2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(((c)localObject1).field_favLocalId);
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
            dpr localdpr = new dpr();
            localdpr.IKH = ("dataitem." + ((c)localObject1).field_dataId + ".stream_videoid");
            localdpr.OzQ = ((arf)localObject2).Zzo;
            paramLinkedList1.add(localdpr);
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
    am localam = new am();
    com.tencent.mm.kernel.h.aZW().a(localam, 0);
    AppMethodBeat.o(101642);
  }
  
  public final void aHh()
  {
    AppMethodBeat.i(101641);
    this.hxE.clear();
    hxG.clear();
    this.running = false;
    this.hxI = false;
    AeK.clear();
    AppMethodBeat.o(101641);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(101639);
    if (paramp.getType() != 426)
    {
      AppMethodBeat.o(101639);
      return;
    }
    if (!(paramp instanceof ao))
    {
      AppMethodBeat.o(101639);
      return;
    }
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101632);
        d.a(d.this);
        int i = ((ao)paramp).AdU;
        d.aCw().remove(Integer.valueOf(i));
        if ((paramInt2 != 3) || (paramInt2 != 0)) {
          d.b(d.this);
        }
        g localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mL(i);
        if ((localg == null) || (localg.field_itemStatus == 10))
        {
          AppMethodBeat.o(101632);
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (localg.field_itemStatus == 17)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.mD(localg.field_localId)) });
            Log.i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d localId:%s", new Object[] { Integer.valueOf(localg.field_id), Long.valueOf(localg.field_localId) });
            localg.field_itemStatus = 10;
            d.B(localg);
            ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
            ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().mH(localg.field_localId);
          }
        }
        while (d.c(d.this) > 0)
        {
          if (d.d(d.this)) {
            break label540;
          }
          d.startSync();
          AppMethodBeat.o(101632);
          return;
          Integer localInteger2 = Integer.valueOf(Util.nullAs((Integer)d.AeK.get(Integer.valueOf(i)), 0));
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
            int j = com.tencent.mm.plugin.fav.a.h.hi(paramInt1, paramInt2);
            com.tencent.mm.plugin.report.service.h.OAn.b(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(j), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.mD(localg.field_localId)) });
            d.AeK.remove(Integer.valueOf(i));
            Log.e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", new Object[] { Integer.valueOf(i) });
            localg.field_itemStatus = 18;
            ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
          }
        }
        Log.i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
        d.e(d.this);
        label540:
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
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.d.d
 * JD-Core Version:    0.7.0.1
 */