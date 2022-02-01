package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ey;
import com.tencent.mm.autogen.a.ez;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.day;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class l
{
  private static float lsA;
  private static boolean lsB;
  private static Map<String, daw> lsC;
  private static List<daw> lsD;
  private static Boolean lsE;
  private static b.a lsF;
  private static MTimerHandler lsG;
  private static IListener lsH;
  private static com.tencent.mm.modelgeo.d lsy;
  private static float lsz;
  
  static
  {
    AppMethodBeat.i(19896);
    lsz = -85.0F;
    lsA = -1000.0F;
    lsB = false;
    lsC = new ConcurrentHashMap();
    lsD = new CopyOnWriteArrayList();
    lsE = Boolean.FALSE;
    lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(238910);
        if (paramAnonymousBoolean)
        {
          Log.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
          l.bh(paramAnonymousFloat2);
          l.bi(paramAnonymousFloat1);
          l.dA(true);
          if (l.aKI() != null)
          {
            l.aKI().a(l.aKJ());
            l.dA(false);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(238910);
          return false;
          Log.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
        }
      }
    };
    lsG = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(19893);
        try
        {
          bh.bCz();
          Boolean localBoolean = Boolean.valueOf(Util.nullAs((Boolean)com.tencent.mm.model.c.ban().get(at.a.acLB, null), false));
          Object localObject2 = com.tencent.mm.k.i.aRD().aRt();
          if (localObject2 == null) {
            break label369;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + localBoolean + ",iBeacon = %s", new Object[] { str });
            ez localez = new ez();
            localez.hFg.hFi = str;
            localez.hFg.hFf = false;
            if (!localBoolean.booleanValue()) {
              localez.publish();
            }
          }
          localObject1 = new day();
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.PostTaskStartRangeForIBeacon", localException.getMessage());
          AppMethodBeat.o(19893);
          return false;
        }
        Object localObject1;
        ((day)localObject1).latitude = l.aKK();
        ((day)localObject1).longitude = l.aKL();
        bh.bCz();
        long l = Util.nullAs((Long)com.tencent.mm.model.c.ban().get(at.a.acLs, null), 0L);
        if ((l.aKM().size() > 0) && (!l.aKN().booleanValue()) && (l.aKO().size() > 0))
        {
          l.g(Boolean.TRUE);
          localObject1 = new com.tencent.mm.modelmulti.i(l.aKO(), l, (day)localObject1);
          Log.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + l + ",beaconInfos size " + l.aKO().size() + ",info:" + l.aKO().toString());
          bh.aZW().a(1708, new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
            {
              AppMethodBeat.i(19892);
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2p = (cfg)c.c.b(this.lsI.oDw.otC);
                if (paramAnonymous2p.result == 0)
                {
                  paramAnonymous2String = paramAnonymous2p.aaoS;
                  paramAnonymous2p = paramAnonymous2p.aaoU;
                  String str = paramAnonymous2String.title + "," + paramAnonymous2String.desc + "," + paramAnonymous2String.aaGw + "," + paramAnonymous2String.aaGx + "," + paramAnonymous2p.uuid + "," + paramAnonymous2p.rid + "," + paramAnonymous2p.rie;
                  bh.bCz();
                  String[] arrayOfString = Util.nullAs((String)com.tencent.mm.model.c.ban().get(at.a.acLy, null), "").split(",");
                  paramAnonymous2String = Boolean.FALSE;
                  paramAnonymous2Int2 = arrayOfString.length;
                  paramAnonymous2Int1 = 0;
                  while (paramAnonymous2Int1 < paramAnonymous2Int2)
                  {
                    if (arrayOfString[paramAnonymous2Int1].equals(paramAnonymous2p.uuid + paramAnonymous2p.rid + paramAnonymous2p.rie)) {
                      paramAnonymous2String = Boolean.TRUE;
                    }
                    paramAnonymous2Int1 += 1;
                  }
                  if (!paramAnonymous2String.booleanValue())
                  {
                    com.tencent.mm.plugin.report.service.h.OAn.b(12653, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    com.tencent.mm.plugin.report.service.h.OAn.b(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    bh.bCz();
                    com.tencent.mm.model.c.ban().set(at.a.acLx, str);
                  }
                }
              }
              for (;;)
              {
                bh.bCz();
                com.tencent.mm.model.c.aZK();
                new ey().publish();
                l.g(Boolean.FALSE);
                bh.aZW().b(1708, this);
                AppMethodBeat.o(19892);
                return;
                bh.bCz();
                com.tencent.mm.model.c.ban().set(at.a.acLx, "");
                continue;
                bh.bCz();
                com.tencent.mm.model.c.ban().set(at.a.acLx, "");
                continue;
                bh.bCz();
                com.tencent.mm.model.c.ban().set(at.a.acLx, "");
              }
            }
          });
          bh.aZW().a((p)localObject1, 0);
        }
        for (;;)
        {
          l.aKM().clear();
          l.aKO().clear();
          l.aKP().dead();
          label369:
          AppMethodBeat.o(19893);
          return false;
          bh.bCz();
          com.tencent.mm.model.c.ban().set(at.a.acLx, "");
        }
      }
    }, true);
    lsH = new PostTaskStartRangeForIBeacon.3(f.hfK);
    AppMethodBeat.o(19896);
  }
  
  public static void run()
  {
    AppMethodBeat.i(19895);
    if ((!bh.baz()) || (bh.aZG()))
    {
      AppMethodBeat.o(19895);
      return;
    }
    bh.bCz();
    Object localObject = Boolean.valueOf(Util.nullAs((Boolean)com.tencent.mm.model.c.ban().get(at.a.acLz, null), false));
    Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is ".concat(String.valueOf(localObject)));
    if (!((Boolean)localObject).booleanValue())
    {
      AppMethodBeat.o(19895);
      return;
    }
    long l1 = Util.nowSecond();
    bh.bCz();
    long l2 = Util.nullAs((Long)com.tencent.mm.model.c.ban().get(at.a.acLA, null), 0L);
    bh.bCz();
    if (l1 - l2 > Util.nullAs((Long)com.tencent.mm.model.c.ban().get(at.a.acLu, null), 0L))
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acLz, Boolean.FALSE);
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acLy, "");
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acLx, "");
      bh.bCz();
      com.tencent.mm.model.c.aZK();
      AppMethodBeat.o(19895);
      return;
    }
    localObject = BluetoothAdapter.getDefaultAdapter();
    if ((Build.VERSION.SDK_INT >= 18) && (localObject != null) && (((BluetoothAdapter)localObject).getState() == 12))
    {
      localObject = com.tencent.mm.k.i.aRD().aRt();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[] { str });
          ez localez = new ez();
          localez.hFg.hFi = str;
          localez.hFg.hFf = true;
          localez.publish();
        }
        lsy = com.tencent.mm.modelgeo.d.bJl();
        if (lsG.stopped()) {
          lsG.startTimer(3000L);
        }
        if ((!lsB) && (lsy != null)) {
          lsy.a(lsF, true, false);
        }
        lsH.alive();
      }
      AppMethodBeat.o(19895);
      return;
    }
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acLx, "");
    AppMethodBeat.o(19895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.l
 * JD-Core Version:    0.7.0.1
 */