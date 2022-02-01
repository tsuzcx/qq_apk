package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class l
{
  private static com.tencent.mm.modelgeo.d fmW;
  private static float fmX;
  private static float fmY;
  private static boolean fmZ;
  private static Map<String, bks> fna;
  private static List<bks> fnb;
  private static Boolean fnc;
  private static b.a fnd;
  private static au fne;
  private static com.tencent.mm.sdk.b.c fnf;
  
  static
  {
    AppMethodBeat.i(19896);
    fmX = -85.0F;
    fmY = -1000.0F;
    fmZ = false;
    fna = new ConcurrentHashMap();
    fnb = new CopyOnWriteArrayList();
    fnc = Boolean.FALSE;
    fnd = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(19891);
        if (paramAnonymousBoolean)
        {
          ac.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
          l.ad(paramAnonymousFloat2);
          l.ae(paramAnonymousFloat1);
          l.access$202(true);
          if (l.UC() != null)
          {
            l.UC().c(l.UD());
            l.access$202(false);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(19891);
          return false;
          ac.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
        }
      }
    };
    fne = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(19893);
        try
        {
          az.ayM();
          Boolean localBoolean = Boolean.valueOf(bs.a((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GHq, null), false));
          Object localObject2 = com.tencent.mm.m.g.ZZ().ZQ();
          if (localObject2 == null) {
            break label376;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            ac.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + localBoolean + ",iBeacon = %s", new Object[] { str });
            ea localea = new ea();
            localea.ddO.ddQ = str;
            localea.ddO.ddN = false;
            if (!localBoolean.booleanValue()) {
              a.GpY.l(localea);
            }
          }
          localObject1 = new bku();
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.PostTaskStartRangeForIBeacon", localException.getMessage());
          AppMethodBeat.o(19893);
          return false;
        }
        Object localObject1;
        ((bku)localObject1).latitude = l.UE();
        ((bku)localObject1).longitude = l.UF();
        az.ayM();
        long l = bs.a((Long)com.tencent.mm.model.c.agA().get(ah.a.GHh, null), 0L);
        if ((l.UG().size() > 0) && (!l.UH().booleanValue()) && (l.UI().size() > 0))
        {
          l.b(Boolean.TRUE);
          localObject1 = new com.tencent.mm.modelmulti.d(l.UI(), l, (bku)localObject1);
          ac.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + l + ",beaconInfos size " + l.UI().size() + ",info:" + l.UI().toString());
          az.agi().a(1708, new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(19892);
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2n = (ati)this.fng.hEg.hvs.hvw;
                if (paramAnonymous2n.result == 0)
                {
                  paramAnonymous2String = paramAnonymous2n.EMo;
                  paramAnonymous2n = paramAnonymous2n.EMq;
                  String str = paramAnonymous2String.title + "," + paramAnonymous2String.desc + "," + paramAnonymous2String.Fau + "," + paramAnonymous2String.Fav + "," + paramAnonymous2n.uuid + "," + paramAnonymous2n.major + "," + paramAnonymous2n.minor;
                  az.ayM();
                  String[] arrayOfString = bs.bG((String)com.tencent.mm.model.c.agA().get(ah.a.GHn, null), "").split(",");
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
                    h.wUl.f(12653, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    h.wUl.f(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    az.ayM();
                    com.tencent.mm.model.c.agA().set(ah.a.GHm, str);
                  }
                }
              }
              for (;;)
              {
                az.ayM();
                com.tencent.mm.model.c.afU();
                paramAnonymous2String = new dz();
                a.GpY.l(paramAnonymous2String);
                l.b(Boolean.FALSE);
                az.agi().b(1708, this);
                AppMethodBeat.o(19892);
                return;
                az.ayM();
                com.tencent.mm.model.c.agA().set(ah.a.GHm, "");
                continue;
                az.ayM();
                com.tencent.mm.model.c.agA().set(ah.a.GHm, "");
                continue;
                az.ayM();
                com.tencent.mm.model.c.agA().set(ah.a.GHm, "");
              }
            }
          });
          az.agi().a((n)localObject1, 0);
        }
        for (;;)
        {
          l.UG().clear();
          l.UI().clear();
          a.GpY.d(l.UJ());
          label376:
          AppMethodBeat.o(19893);
          return false;
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GHm, "");
        }
      }
    }, true);
    fnf = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(19896);
  }
  
  public static void run()
  {
    AppMethodBeat.i(19895);
    if ((!az.agM()) || (az.afS()))
    {
      AppMethodBeat.o(19895);
      return;
    }
    az.ayM();
    Object localObject = Boolean.valueOf(bs.a((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GHo, null), false));
    ac.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is ".concat(String.valueOf(localObject)));
    if (!((Boolean)localObject).booleanValue())
    {
      AppMethodBeat.o(19895);
      return;
    }
    long l1 = bs.aNx();
    az.ayM();
    long l2 = bs.a((Long)com.tencent.mm.model.c.agA().get(ah.a.GHp, null), 0L);
    az.ayM();
    if (l1 - l2 > bs.a((Long)com.tencent.mm.model.c.agA().get(ah.a.GHj, null), 0L))
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GHo, Boolean.FALSE);
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GHn, "");
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GHm, "");
      az.ayM();
      com.tencent.mm.model.c.afU();
      AppMethodBeat.o(19895);
      return;
    }
    localObject = BluetoothAdapter.getDefaultAdapter();
    if ((Build.VERSION.SDK_INT >= 18) && (localObject != null) && (((BluetoothAdapter)localObject).getState() == 12))
    {
      localObject = com.tencent.mm.m.g.ZZ().ZQ();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ac.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[] { str });
          ea localea = new ea();
          localea.ddO.ddQ = str;
          localea.ddO.ddN = true;
          a.GpY.l(localea);
        }
        fmW = com.tencent.mm.modelgeo.d.aEL();
        if (fne.eVs()) {
          fne.au(3000L, 3000L);
        }
        if ((!fmZ) && (fmW != null)) {
          fmW.a(fnd, true);
        }
        a.GpY.c(fnf);
      }
      AppMethodBeat.o(19895);
      return;
    }
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GHm, "");
    AppMethodBeat.o(19895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.l
 * JD-Core Version:    0.7.0.1
 */