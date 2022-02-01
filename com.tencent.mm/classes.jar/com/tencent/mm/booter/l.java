package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.en;
import com.tencent.mm.f.a.eo;
import com.tencent.mm.f.a.ep;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.protobuf.bqp;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.protocal.protobuf.cku;
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
  private static com.tencent.mm.modelgeo.d iQC;
  private static float iQD;
  private static float iQE;
  private static boolean iQF;
  private static Map<String, ckp> iQG;
  private static List<ckp> iQH;
  private static Boolean iQI;
  private static b.a iQJ;
  private static MTimerHandler iQK;
  private static IListener iQL;
  
  static
  {
    AppMethodBeat.i(19896);
    iQD = -85.0F;
    iQE = -1000.0F;
    iQF = false;
    iQG = new ConcurrentHashMap();
    iQH = new CopyOnWriteArrayList();
    iQI = Boolean.FALSE;
    iQJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(19891);
        if (paramAnonymousBoolean)
        {
          Log.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
          l.af(paramAnonymousFloat2);
          l.ag(paramAnonymousFloat1);
          l.access$202(true);
          if (l.aqK() != null)
          {
            l.aqK().b(l.aqL());
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
    iQK = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(19893);
        try
        {
          bh.beI();
          Boolean localBoolean = Boolean.valueOf(Util.nullAs((Boolean)c.aHp().get(ar.a.Vkh, null), false));
          Object localObject2 = com.tencent.mm.n.h.axd().awT();
          if (localObject2 == null) {
            break label376;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + localBoolean + ",iBeacon = %s", new Object[] { str });
            eo localeo = new eo();
            localeo.fAt.fAv = str;
            localeo.fAt.fAs = false;
            if (!localBoolean.booleanValue()) {
              EventCenter.instance.publish(localeo);
            }
          }
          localObject1 = new ckr();
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.PostTaskStartRangeForIBeacon", localException.getMessage());
          AppMethodBeat.o(19893);
          return false;
        }
        Object localObject1;
        ((ckr)localObject1).latitude = l.aqM();
        ((ckr)localObject1).longitude = l.aqN();
        bh.beI();
        long l = Util.nullAs((Long)c.aHp().get(ar.a.VjY, null), 0L);
        if ((l.aqO().size() > 0) && (!l.aqP().booleanValue()) && (l.aqQ().size() > 0))
        {
          l.d(Boolean.TRUE);
          localObject1 = new com.tencent.mm.modelmulti.d(l.aqQ(), l, (ckr)localObject1);
          Log.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + l + ",beaconInfos size " + l.aqQ().size() + ",info:" + l.aqQ().toString());
          bh.aGY().a(1708, new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(19892);
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2q = (bqp)d.c.b(this.iQM.lKU.lBS);
                if (paramAnonymous2q.result == 0)
                {
                  paramAnonymous2String = paramAnonymous2q.TbG;
                  paramAnonymous2q = paramAnonymous2q.TbI;
                  String str = paramAnonymous2String.title + "," + paramAnonymous2String.desc + "," + paramAnonymous2String.Tsl + "," + paramAnonymous2String.Tsm + "," + paramAnonymous2q.uuid + "," + paramAnonymous2q.oey + "," + paramAnonymous2q.oez;
                  bh.beI();
                  String[] arrayOfString = Util.nullAs((String)c.aHp().get(ar.a.Vke, null), "").split(",");
                  paramAnonymous2String = Boolean.FALSE;
                  paramAnonymous2Int2 = arrayOfString.length;
                  paramAnonymous2Int1 = 0;
                  while (paramAnonymous2Int1 < paramAnonymous2Int2)
                  {
                    if (arrayOfString[paramAnonymous2Int1].equals(paramAnonymous2q.uuid + paramAnonymous2q.oey + paramAnonymous2q.oez)) {
                      paramAnonymous2String = Boolean.TRUE;
                    }
                    paramAnonymous2Int1 += 1;
                  }
                  if (!paramAnonymous2String.booleanValue())
                  {
                    com.tencent.mm.plugin.report.service.h.IzE.a(12653, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    com.tencent.mm.plugin.report.service.h.IzE.a(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    bh.beI();
                    c.aHp().set(ar.a.Vkd, str);
                  }
                }
              }
              for (;;)
              {
                bh.beI();
                c.aGI();
                paramAnonymous2String = new en();
                EventCenter.instance.publish(paramAnonymous2String);
                l.d(Boolean.FALSE);
                bh.aGY().b(1708, this);
                AppMethodBeat.o(19892);
                return;
                bh.beI();
                c.aHp().set(ar.a.Vkd, "");
                continue;
                bh.beI();
                c.aHp().set(ar.a.Vkd, "");
                continue;
                bh.beI();
                c.aHp().set(ar.a.Vkd, "");
              }
            }
          });
          bh.aGY().a((q)localObject1, 0);
        }
        for (;;)
        {
          l.aqO().clear();
          l.aqQ().clear();
          EventCenter.instance.removeListener(l.aqR());
          label376:
          AppMethodBeat.o(19893);
          return false;
          bh.beI();
          c.aHp().set(ar.a.Vkd, "");
        }
      }
    }, true);
    iQL = new IListener() {};
    AppMethodBeat.o(19896);
  }
  
  public static void run()
  {
    AppMethodBeat.i(19895);
    if ((!bh.aHB()) || (bh.aGE()))
    {
      AppMethodBeat.o(19895);
      return;
    }
    bh.beI();
    Object localObject = Boolean.valueOf(Util.nullAs((Boolean)c.aHp().get(ar.a.Vkf, null), false));
    Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is ".concat(String.valueOf(localObject)));
    if (!((Boolean)localObject).booleanValue())
    {
      AppMethodBeat.o(19895);
      return;
    }
    long l1 = Util.nowSecond();
    bh.beI();
    long l2 = Util.nullAs((Long)c.aHp().get(ar.a.Vkg, null), 0L);
    bh.beI();
    if (l1 - l2 > Util.nullAs((Long)c.aHp().get(ar.a.Vka, null), 0L))
    {
      bh.beI();
      c.aHp().set(ar.a.Vkf, Boolean.FALSE);
      bh.beI();
      c.aHp().set(ar.a.Vke, "");
      bh.beI();
      c.aHp().set(ar.a.Vkd, "");
      bh.beI();
      c.aGI();
      AppMethodBeat.o(19895);
      return;
    }
    localObject = BluetoothAdapter.getDefaultAdapter();
    if ((Build.VERSION.SDK_INT >= 18) && (localObject != null) && (((BluetoothAdapter)localObject).getState() == 12))
    {
      localObject = com.tencent.mm.n.h.axd().awT();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[] { str });
          eo localeo = new eo();
          localeo.fAt.fAv = str;
          localeo.fAt.fAs = true;
          EventCenter.instance.publish(localeo);
        }
        iQC = com.tencent.mm.modelgeo.d.blq();
        if (iQK.stopped()) {
          iQK.startTimer(3000L);
        }
        if ((!iQF) && (iQC != null)) {
          iQC.a(iQJ, true);
        }
        EventCenter.instance.addListener(iQL);
      }
      AppMethodBeat.o(19895);
      return;
    }
    bh.beI();
    c.aHp().set(ar.a.Vkd, "");
    AppMethodBeat.o(19895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.l
 * JD-Core Version:    0.7.0.1
 */