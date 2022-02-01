package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.eg;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class l
{
  private static b.a gmA;
  private static MTimerHandler gmB;
  private static IListener gmC;
  private static com.tencent.mm.modelgeo.d gmt;
  private static float gmu;
  private static float gmv;
  private static boolean gmw;
  private static Map<String, ccm> gmx;
  private static List<ccm> gmy;
  private static Boolean gmz;
  
  static
  {
    AppMethodBeat.i(19896);
    gmu = -85.0F;
    gmv = -1000.0F;
    gmw = false;
    gmx = new ConcurrentHashMap();
    gmy = new CopyOnWriteArrayList();
    gmz = Boolean.FALSE;
    gmA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(19891);
        if (paramAnonymousBoolean)
        {
          Log.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
          l.ag(paramAnonymousFloat2);
          l.ah(paramAnonymousFloat1);
          l.access$202(true);
          if (l.akO() != null)
          {
            l.akO().c(l.akP());
            l.access$202(false);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(19891);
          return false;
          Log.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
        }
      }
    };
    gmB = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(19893);
        try
        {
          bg.aVF();
          Boolean localBoolean = Boolean.valueOf(Util.nullAs((Boolean)c.azQ().get(ar.a.NWh, null), false));
          Object localObject2 = com.tencent.mm.n.h.aqK().aqA();
          if (localObject2 == null) {
            break label376;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + localBoolean + ",iBeacon = %s", new Object[] { str });
            eh localeh = new eh();
            localeh.dHC.dHE = str;
            localeh.dHC.dHB = false;
            if (!localBoolean.booleanValue()) {
              EventCenter.instance.publish(localeh);
            }
          }
          localObject1 = new cco();
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.PostTaskStartRangeForIBeacon", localException.getMessage());
          AppMethodBeat.o(19893);
          return false;
        }
        Object localObject1;
        ((cco)localObject1).latitude = l.akQ();
        ((cco)localObject1).longitude = l.akR();
        bg.aVF();
        long l = Util.nullAs((Long)c.azQ().get(ar.a.NVY, null), 0L);
        if ((l.akS().size() > 0) && (!l.akT().booleanValue()) && (l.akU().size() > 0))
        {
          l.b(Boolean.TRUE);
          localObject1 = new com.tencent.mm.modelmulti.d(l.akU(), l, (cco)localObject1);
          Log.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + l + ",beaconInfos size " + l.akU().size() + ",info:" + l.akU().toString());
          bg.azz().a(1708, new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(19892);
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2q = (bjg)this.gmD.iUB.iLL.iLR;
                if (paramAnonymous2q.result == 0)
                {
                  paramAnonymous2String = paramAnonymous2q.LSV;
                  paramAnonymous2q = paramAnonymous2q.LSX;
                  String str = paramAnonymous2String.title + "," + paramAnonymous2String.desc + "," + paramAnonymous2String.Mix + "," + paramAnonymous2String.Miy + "," + paramAnonymous2q.uuid + "," + paramAnonymous2q.major + "," + paramAnonymous2q.minor;
                  bg.aVF();
                  String[] arrayOfString = Util.nullAs((String)c.azQ().get(ar.a.NWe, null), "").split(",");
                  paramAnonymous2String = Boolean.FALSE;
                  paramAnonymous2Int2 = arrayOfString.length;
                  paramAnonymous2Int1 = 0;
                  while (paramAnonymous2Int1 < paramAnonymous2Int2)
                  {
                    if (arrayOfString[paramAnonymous2Int1].equals(paramAnonymous2q.uuid + paramAnonymous2q.major + paramAnonymous2q.minor)) {
                      paramAnonymous2String = Boolean.TRUE;
                    }
                    paramAnonymous2Int1 += 1;
                  }
                  if (!paramAnonymous2String.booleanValue())
                  {
                    com.tencent.mm.plugin.report.service.h.CyF.a(12653, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    com.tencent.mm.plugin.report.service.h.CyF.a(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    bg.aVF();
                    c.azQ().set(ar.a.NWd, str);
                  }
                }
              }
              for (;;)
              {
                bg.aVF();
                c.azl();
                paramAnonymous2String = new eg();
                EventCenter.instance.publish(paramAnonymous2String);
                l.b(Boolean.FALSE);
                bg.azz().b(1708, this);
                AppMethodBeat.o(19892);
                return;
                bg.aVF();
                c.azQ().set(ar.a.NWd, "");
                continue;
                bg.aVF();
                c.azQ().set(ar.a.NWd, "");
                continue;
                bg.aVF();
                c.azQ().set(ar.a.NWd, "");
              }
            }
          });
          bg.azz().a((q)localObject1, 0);
        }
        for (;;)
        {
          l.akS().clear();
          l.akU().clear();
          EventCenter.instance.removeListener(l.akV());
          label376:
          AppMethodBeat.o(19893);
          return false;
          bg.aVF();
          c.azQ().set(ar.a.NWd, "");
        }
      }
    }, true);
    gmC = new l.3();
    AppMethodBeat.o(19896);
  }
  
  public static void run()
  {
    AppMethodBeat.i(19895);
    if ((!bg.aAc()) || (bg.azj()))
    {
      AppMethodBeat.o(19895);
      return;
    }
    bg.aVF();
    Object localObject = Boolean.valueOf(Util.nullAs((Boolean)c.azQ().get(ar.a.NWf, null), false));
    Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is ".concat(String.valueOf(localObject)));
    if (!((Boolean)localObject).booleanValue())
    {
      AppMethodBeat.o(19895);
      return;
    }
    long l1 = Util.nowSecond();
    bg.aVF();
    long l2 = Util.nullAs((Long)c.azQ().get(ar.a.NWg, null), 0L);
    bg.aVF();
    if (l1 - l2 > Util.nullAs((Long)c.azQ().get(ar.a.NWa, null), 0L))
    {
      bg.aVF();
      c.azQ().set(ar.a.NWf, Boolean.FALSE);
      bg.aVF();
      c.azQ().set(ar.a.NWe, "");
      bg.aVF();
      c.azQ().set(ar.a.NWd, "");
      bg.aVF();
      c.azl();
      AppMethodBeat.o(19895);
      return;
    }
    localObject = BluetoothAdapter.getDefaultAdapter();
    if ((Build.VERSION.SDK_INT >= 18) && (localObject != null) && (((BluetoothAdapter)localObject).getState() == 12))
    {
      localObject = com.tencent.mm.n.h.aqK().aqA();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[] { str });
          eh localeh = new eh();
          localeh.dHC.dHE = str;
          localeh.dHC.dHB = true;
          EventCenter.instance.publish(localeh);
        }
        gmt = com.tencent.mm.modelgeo.d.bca();
        if (gmB.stopped()) {
          gmB.startTimer(3000L);
        }
        if ((!gmw) && (gmt != null)) {
          gmt.a(gmA, true);
        }
        EventCenter.instance.addListener(gmC);
      }
      AppMethodBeat.o(19895);
      return;
    }
    bg.aVF();
    c.azQ().set(ar.a.NWd, "");
    AppMethodBeat.o(19895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.l
 * JD-Core Version:    0.7.0.1
 */