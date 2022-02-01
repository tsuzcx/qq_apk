package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class l
{
  private static com.tencent.mm.modelgeo.d fFe;
  private static float fFf;
  private static float fFg;
  private static boolean fFh;
  private static Map<String, bpc> fFi;
  private static List<bpc> fFj;
  private static Boolean fFk;
  private static b.a fFl;
  private static av fFm;
  private static com.tencent.mm.sdk.b.c fFn;
  
  static
  {
    AppMethodBeat.i(19896);
    fFf = -85.0F;
    fFg = -1000.0F;
    fFh = false;
    fFi = new ConcurrentHashMap();
    fFj = new CopyOnWriteArrayList();
    fFk = Boolean.FALSE;
    fFl = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(19891);
        if (paramAnonymousBoolean)
        {
          ad.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
          l.af(paramAnonymousFloat2);
          l.ag(paramAnonymousFloat1);
          l.access$202(true);
          if (l.WT() != null)
          {
            l.WT().c(l.WU());
            l.access$202(false);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(19891);
          return false;
          ad.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
        }
      }
    };
    fFm = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(19893);
        try
        {
          ba.aBQ();
          Boolean localBoolean = Boolean.valueOf(bt.a((Boolean)com.tencent.mm.model.c.ajl().get(al.a.ItI, null), false));
          Object localObject2 = com.tencent.mm.n.g.acB().acr();
          if (localObject2 == null) {
            break label376;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            ad.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + localBoolean + ",iBeacon = %s", new Object[] { str });
            ed localed = new ed();
            localed.dpk.dpm = str;
            localed.dpk.dpj = false;
            if (!localBoolean.booleanValue()) {
              a.IbL.l(localed);
            }
          }
          localObject1 = new bpe();
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.PostTaskStartRangeForIBeacon", localException.getMessage());
          AppMethodBeat.o(19893);
          return false;
        }
        Object localObject1;
        ((bpe)localObject1).latitude = l.WV();
        ((bpe)localObject1).longitude = l.WW();
        ba.aBQ();
        long l = bt.a((Long)com.tencent.mm.model.c.ajl().get(al.a.Itz, null), 0L);
        if ((l.WX().size() > 0) && (!l.WY().booleanValue()) && (l.WZ().size() > 0))
        {
          l.c(Boolean.TRUE);
          localObject1 = new com.tencent.mm.modelmulti.d(l.WZ(), l, (bpe)localObject1);
          ad.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + l + ",beaconInfos size " + l.WZ().size() + ",info:" + l.WZ().toString());
          ba.aiU().a(1708, new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(19892);
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2n = (axg)this.fFo.hWL.hNL.hNQ;
                if (paramAnonymous2n.result == 0)
                {
                  paramAnonymous2String = paramAnonymous2n.Gvs;
                  paramAnonymous2n = paramAnonymous2n.Gvu;
                  String str = paramAnonymous2String.title + "," + paramAnonymous2String.desc + "," + paramAnonymous2String.GJT + "," + paramAnonymous2String.GJU + "," + paramAnonymous2n.uuid + "," + paramAnonymous2n.major + "," + paramAnonymous2n.minor;
                  ba.aBQ();
                  String[] arrayOfString = bt.bI((String)com.tencent.mm.model.c.ajl().get(al.a.ItF, null), "").split(",");
                  paramAnonymous2String = Boolean.FALSE;
                  paramAnonymous2Int2 = arrayOfString.length;
                  paramAnonymous2Int1 = 0;
                  while (paramAnonymous2Int1 < paramAnonymous2Int2)
                  {
                    if (arrayOfString[paramAnonymous2Int1].equals(paramAnonymous2n.uuid + paramAnonymous2n.major + paramAnonymous2n.minor)) {
                      paramAnonymous2String = Boolean.TRUE;
                    }
                    paramAnonymous2Int1 += 1;
                  }
                  if (!paramAnonymous2String.booleanValue())
                  {
                    com.tencent.mm.plugin.report.service.g.yhR.f(12653, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    com.tencent.mm.plugin.report.service.g.yhR.f(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    ba.aBQ();
                    com.tencent.mm.model.c.ajl().set(al.a.ItE, str);
                  }
                }
              }
              for (;;)
              {
                ba.aBQ();
                com.tencent.mm.model.c.aiG();
                paramAnonymous2String = new ec();
                a.IbL.l(paramAnonymous2String);
                l.c(Boolean.FALSE);
                ba.aiU().b(1708, this);
                AppMethodBeat.o(19892);
                return;
                ba.aBQ();
                com.tencent.mm.model.c.ajl().set(al.a.ItE, "");
                continue;
                ba.aBQ();
                com.tencent.mm.model.c.ajl().set(al.a.ItE, "");
                continue;
                ba.aBQ();
                com.tencent.mm.model.c.ajl().set(al.a.ItE, "");
              }
            }
          });
          ba.aiU().a((n)localObject1, 0);
        }
        for (;;)
        {
          l.WX().clear();
          l.WZ().clear();
          a.IbL.d(l.Xa());
          label376:
          AppMethodBeat.o(19893);
          return false;
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.ItE, "");
        }
      }
    }, true);
    fFn = new l.3();
    AppMethodBeat.o(19896);
  }
  
  public static void run()
  {
    AppMethodBeat.i(19895);
    if ((!ba.ajx()) || (ba.aiE()))
    {
      AppMethodBeat.o(19895);
      return;
    }
    ba.aBQ();
    Object localObject = Boolean.valueOf(bt.a((Boolean)com.tencent.mm.model.c.ajl().get(al.a.ItG, null), false));
    ad.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is ".concat(String.valueOf(localObject)));
    if (!((Boolean)localObject).booleanValue())
    {
      AppMethodBeat.o(19895);
      return;
    }
    long l1 = bt.aQJ();
    ba.aBQ();
    long l2 = bt.a((Long)com.tencent.mm.model.c.ajl().get(al.a.ItH, null), 0L);
    ba.aBQ();
    if (l1 - l2 > bt.a((Long)com.tencent.mm.model.c.ajl().get(al.a.ItB, null), 0L))
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.ItG, Boolean.FALSE);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.ItF, "");
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.ItE, "");
      ba.aBQ();
      com.tencent.mm.model.c.aiG();
      AppMethodBeat.o(19895);
      return;
    }
    localObject = BluetoothAdapter.getDefaultAdapter();
    if ((Build.VERSION.SDK_INT >= 18) && (localObject != null) && (((BluetoothAdapter)localObject).getState() == 12))
    {
      localObject = com.tencent.mm.n.g.acB().acr();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ad.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[] { str });
          ed localed = new ed();
          localed.dpk.dpm = str;
          localed.dpk.dpj = true;
          a.IbL.l(localed);
        }
        fFe = com.tencent.mm.modelgeo.d.aHQ();
        if (fFm.fkZ()) {
          fFm.az(3000L, 3000L);
        }
        if ((!fFh) && (fFe != null)) {
          fFe.a(fFl, true);
        }
        a.IbL.c(fFn);
      }
      AppMethodBeat.o(19895);
      return;
    }
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.ItE, "");
    AppMethodBeat.o(19895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.l
 * JD-Core Version:    0.7.0.1
 */