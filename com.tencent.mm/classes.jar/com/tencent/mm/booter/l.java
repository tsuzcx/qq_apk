package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.du;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class l
{
  private static b.a dZA;
  private static ap dZB;
  private static com.tencent.mm.sdk.b.c dZC;
  private static d dZt;
  private static float dZu;
  private static float dZv;
  private static boolean dZw;
  private static Map<String, avv> dZx;
  private static List<avv> dZy;
  private static Boolean dZz;
  
  static
  {
    AppMethodBeat.i(15860);
    dZu = -85.0F;
    dZv = -1000.0F;
    dZw = false;
    dZx = new ConcurrentHashMap();
    dZy = new CopyOnWriteArrayList();
    dZz = Boolean.FALSE;
    dZA = new l.1();
    dZB = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(15856);
        try
        {
          aw.aaz();
          Boolean localBoolean = Boolean.valueOf(bo.a((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yBf, null), false));
          Object localObject2 = g.Nr().Ng();
          if (localObject2 == null) {
            break label376;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            ab.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + localBoolean + ",iBeacon = %s", new Object[] { str });
            dt localdt = new dt();
            localdt.crx.crz = str;
            localdt.crx.crw = false;
            if (!localBoolean.booleanValue()) {
              a.ymk.l(localdt);
            }
          }
          localObject1 = new avx();
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.PostTaskStartRangeForIBeacon", localException.getMessage());
          AppMethodBeat.o(15856);
          return false;
        }
        Object localObject1;
        ((avx)localObject1).latitude = l.Ix();
        ((avx)localObject1).longitude = l.Iy();
        aw.aaz();
        long l = bo.a((Long)com.tencent.mm.model.c.Ru().get(ac.a.yAW, null), 0L);
        if ((l.Iz().size() > 0) && (!l.IA().booleanValue()) && (l.IB().size() > 0))
        {
          l.b(Boolean.TRUE);
          localObject1 = new com.tencent.mm.modelmulti.c(l.IB(), l, (avx)localObject1);
          ab.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + l + ",beaconInfos size " + l.IB().size() + ",info:" + l.IB().toString());
          aw.Rc().a(1708, new l.2.1(this, (com.tencent.mm.modelmulti.c)localObject1));
          aw.Rc().a((m)localObject1, 0);
        }
        for (;;)
        {
          l.Iz().clear();
          l.IB().clear();
          a.ymk.d(l.IC());
          label376:
          AppMethodBeat.o(15856);
          return false;
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yBb, "");
        }
      }
    }, true);
    dZC = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(15860);
  }
  
  public static void run()
  {
    AppMethodBeat.i(15859);
    if ((!aw.RG()) || (aw.QP()))
    {
      AppMethodBeat.o(15859);
      return;
    }
    aw.aaz();
    Object localObject = Boolean.valueOf(bo.a((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yBd, null), false));
    ab.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is ".concat(String.valueOf(localObject)));
    if (!((Boolean)localObject).booleanValue())
    {
      AppMethodBeat.o(15859);
      return;
    }
    long l1 = bo.aox();
    aw.aaz();
    long l2 = bo.a((Long)com.tencent.mm.model.c.Ru().get(ac.a.yBe, null), 0L);
    aw.aaz();
    if (l1 - l2 > bo.a((Long)com.tencent.mm.model.c.Ru().get(ac.a.yAY, null), 0L))
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yBd, Boolean.FALSE);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yBc, "");
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yBb, "");
      aw.aaz();
      com.tencent.mm.model.c.QR();
      AppMethodBeat.o(15859);
      return;
    }
    localObject = BluetoothAdapter.getDefaultAdapter();
    if ((Build.VERSION.SDK_INT >= 18) && (localObject != null) && (((BluetoothAdapter)localObject).getState() == 12))
    {
      localObject = g.Nr().Ng();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ab.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[] { str });
          dt localdt = new dt();
          localdt.crx.crz = str;
          localdt.crx.crw = true;
          a.ymk.l(localdt);
        }
        dZt = d.agQ();
        if (dZB.dtj()) {
          dZB.ag(3000L, 3000L);
        }
        if ((!dZw) && (dZt != null)) {
          dZt.a(dZA, true);
        }
        a.ymk.c(dZC);
      }
      AppMethodBeat.o(15859);
      return;
    }
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yBb, "");
    AppMethodBeat.o(15859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.l
 * JD-Core Version:    0.7.0.1
 */