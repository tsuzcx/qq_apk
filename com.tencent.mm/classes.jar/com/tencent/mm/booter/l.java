package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class l
{
  private static com.tencent.mm.modelgeo.d fjC;
  private static float fjD;
  private static float fjE;
  private static boolean fjF;
  private static Map<String, bha> fjG;
  private static List<bha> fjH;
  private static Boolean fjI;
  private static b.a fjJ;
  private static av fjK;
  private static com.tencent.mm.sdk.b.c fjL;
  
  static
  {
    AppMethodBeat.i(19896);
    fjD = -85.0F;
    fjE = -1000.0F;
    fjF = false;
    fjG = new ConcurrentHashMap();
    fjH = new CopyOnWriteArrayList();
    fjI = Boolean.FALSE;
    fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(19891);
        if (paramAnonymousBoolean)
        {
          ad.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
          l.Z(paramAnonymousFloat2);
          l.aa(paramAnonymousFloat1);
          l.access$202(true);
          if (l.TI() != null)
          {
            l.TI().c(l.TJ());
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
    fjK = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(19893);
        try
        {
          az.arV();
          Boolean localBoolean = Boolean.valueOf(bt.a((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FjB, null), false));
          Object localObject2 = com.tencent.mm.m.g.Ze().YT();
          if (localObject2 == null) {
            break label376;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            ad.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + localBoolean + ",iBeacon = %s", new Object[] { str });
            dz localdz = new dz();
            localdz.dgt.dgv = str;
            localdz.dgt.dgs = false;
            if (!localBoolean.booleanValue()) {
              a.ESL.l(localdz);
            }
          }
          localObject1 = new bhc();
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.PostTaskStartRangeForIBeacon", localException.getMessage());
          AppMethodBeat.o(19893);
          return false;
        }
        Object localObject1;
        ((bhc)localObject1).latitude = l.TK();
        ((bhc)localObject1).longitude = l.TL();
        az.arV();
        long l = bt.a((Long)com.tencent.mm.model.c.afk().get(ae.a.Fjs, null), 0L);
        if ((l.TM().size() > 0) && (!l.TN().booleanValue()) && (l.TO().size() > 0))
        {
          l.b(Boolean.TRUE);
          localObject1 = new com.tencent.mm.modelmulti.d(l.TO(), l, (bhc)localObject1);
          ad.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + l + ",beaconInfos size " + l.TO().size() + ",info:" + l.TO().toString());
          az.aeS().a(1708, new com.tencent.mm.al.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(19892);
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2n = (aqe)this.fjM.hdD.gUT.gUX;
                if (paramAnonymous2n.result == 0)
                {
                  paramAnonymous2String = paramAnonymous2n.Drm;
                  paramAnonymous2n = paramAnonymous2n.Dro;
                  String str = paramAnonymous2String.title + "," + paramAnonymous2String.desc + "," + paramAnonymous2String.DFa + "," + paramAnonymous2String.DFb + "," + paramAnonymous2n.uuid + "," + paramAnonymous2n.major + "," + paramAnonymous2n.minor;
                  az.arV();
                  String[] arrayOfString = bt.by((String)com.tencent.mm.model.c.afk().get(ae.a.Fjy, null), "").split(",");
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
                    h.vKh.f(12653, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    h.vKh.f(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    az.arV();
                    com.tencent.mm.model.c.afk().set(ae.a.Fjx, str);
                  }
                }
              }
              for (;;)
              {
                az.arV();
                com.tencent.mm.model.c.aeE();
                paramAnonymous2String = new dy();
                a.ESL.l(paramAnonymous2String);
                l.b(Boolean.FALSE);
                az.aeS().b(1708, this);
                AppMethodBeat.o(19892);
                return;
                az.arV();
                com.tencent.mm.model.c.afk().set(ae.a.Fjx, "");
                continue;
                az.arV();
                com.tencent.mm.model.c.afk().set(ae.a.Fjx, "");
                continue;
                az.arV();
                com.tencent.mm.model.c.afk().set(ae.a.Fjx, "");
              }
            }
          });
          az.aeS().a((n)localObject1, 0);
        }
        for (;;)
        {
          l.TM().clear();
          l.TO().clear();
          a.ESL.d(l.TP());
          label376:
          AppMethodBeat.o(19893);
          return false;
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.Fjx, "");
        }
      }
    }, true);
    fjL = new l.3();
    AppMethodBeat.o(19896);
  }
  
  public static void run()
  {
    AppMethodBeat.i(19895);
    if ((!az.afw()) || (az.aeC()))
    {
      AppMethodBeat.o(19895);
      return;
    }
    az.arV();
    Object localObject = Boolean.valueOf(bt.a((Boolean)com.tencent.mm.model.c.afk().get(ae.a.Fjz, null), false));
    ad.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is ".concat(String.valueOf(localObject)));
    if (!((Boolean)localObject).booleanValue())
    {
      AppMethodBeat.o(19895);
      return;
    }
    long l1 = bt.aGK();
    az.arV();
    long l2 = bt.a((Long)com.tencent.mm.model.c.afk().get(ae.a.FjA, null), 0L);
    az.arV();
    if (l1 - l2 > bt.a((Long)com.tencent.mm.model.c.afk().get(ae.a.Fju, null), 0L))
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fjz, Boolean.FALSE);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fjy, "");
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fjx, "");
      az.arV();
      com.tencent.mm.model.c.aeE();
      AppMethodBeat.o(19895);
      return;
    }
    localObject = BluetoothAdapter.getDefaultAdapter();
    if ((Build.VERSION.SDK_INT >= 18) && (localObject != null) && (((BluetoothAdapter)localObject).getState() == 12))
    {
      localObject = com.tencent.mm.m.g.Ze().YT();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ad.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[] { str });
          dz localdz = new dz();
          localdz.dgt.dgv = str;
          localdz.dgt.dgs = true;
          a.ESL.l(localdz);
        }
        fjC = com.tencent.mm.modelgeo.d.axT();
        if (fjK.eFX()) {
          fjK.av(3000L, 3000L);
        }
        if ((!fjF) && (fjC != null)) {
          fjC.a(fjJ, true);
        }
        a.ESL.c(fjL);
      }
      AppMethodBeat.o(19895);
      return;
    }
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.Fjx, "");
    AppMethodBeat.o(19895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.l
 * JD-Core Version:    0.7.0.1
 */