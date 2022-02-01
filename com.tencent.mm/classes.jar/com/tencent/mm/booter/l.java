package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class l
{
  private static com.tencent.mm.modelgeo.d fHi;
  private static float fHj;
  private static float fHk;
  private static boolean fHl;
  private static Map<String, bpu> fHm;
  private static List<bpu> fHn;
  private static Boolean fHo;
  private static b.a fHp;
  private static aw fHq;
  private static com.tencent.mm.sdk.b.c fHr;
  
  static
  {
    AppMethodBeat.i(19896);
    fHj = -85.0F;
    fHk = -1000.0F;
    fHl = false;
    fHm = new ConcurrentHashMap();
    fHn = new CopyOnWriteArrayList();
    fHo = Boolean.FALSE;
    fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(19891);
        if (paramAnonymousBoolean)
        {
          ae.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
          l.af(paramAnonymousFloat2);
          l.ag(paramAnonymousFloat1);
          l.access$202(true);
          if (l.Xb() != null)
          {
            l.Xb().c(l.Xc());
            l.access$202(false);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(19891);
          return false;
          ae.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
        }
      }
    };
    fHq = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(19893);
        try
        {
          bc.aCg();
          Boolean localBoolean = Boolean.valueOf(bu.a((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IOf, null), false));
          Object localObject2 = com.tencent.mm.n.g.acM().acC();
          if (localObject2 == null) {
            break label376;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            ae.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + localBoolean + ",iBeacon = %s", new Object[] { str });
            ee localee = new ee();
            localee.dqp.dqr = str;
            localee.dqp.dqo = false;
            if (!localBoolean.booleanValue()) {
              a.IvT.l(localee);
            }
          }
          localObject1 = new bpw();
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.PostTaskStartRangeForIBeacon", localException.getMessage());
          AppMethodBeat.o(19893);
          return false;
        }
        Object localObject1;
        ((bpw)localObject1).latitude = l.Xd();
        ((bpw)localObject1).longitude = l.Xe();
        bc.aCg();
        long l = bu.a((Long)com.tencent.mm.model.c.ajA().get(am.a.INW, null), 0L);
        if ((l.Xf().size() > 0) && (!l.Xg().booleanValue()) && (l.Xh().size() > 0))
        {
          l.c(Boolean.TRUE);
          localObject1 = new com.tencent.mm.modelmulti.d(l.Xh(), l, (bpw)localObject1);
          ae.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + l + ",beaconInfos size " + l.Xh().size() + ",info:" + l.Xh().toString());
          bc.ajj().a(1708, new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(19892);
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2n = (axw)this.fHs.hZD.hQE.hQJ;
                if (paramAnonymous2n.result == 0)
                {
                  paramAnonymous2String = paramAnonymous2n.GOR;
                  paramAnonymous2n = paramAnonymous2n.GOT;
                  String str = paramAnonymous2String.title + "," + paramAnonymous2String.desc + "," + paramAnonymous2String.Hdu + "," + paramAnonymous2String.Hdv + "," + paramAnonymous2n.uuid + "," + paramAnonymous2n.major + "," + paramAnonymous2n.minor;
                  bc.aCg();
                  String[] arrayOfString = bu.bI((String)com.tencent.mm.model.c.ajA().get(am.a.IOc, null), "").split(",");
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
                    com.tencent.mm.plugin.report.service.g.yxI.f(12653, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
                    com.tencent.mm.plugin.report.service.g.yxI.f(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
                    bc.aCg();
                    com.tencent.mm.model.c.ajA().set(am.a.IOb, str);
                  }
                }
              }
              for (;;)
              {
                bc.aCg();
                com.tencent.mm.model.c.aiV();
                paramAnonymous2String = new ed();
                a.IvT.l(paramAnonymous2String);
                l.c(Boolean.FALSE);
                bc.ajj().b(1708, this);
                AppMethodBeat.o(19892);
                return;
                bc.aCg();
                com.tencent.mm.model.c.ajA().set(am.a.IOb, "");
                continue;
                bc.aCg();
                com.tencent.mm.model.c.ajA().set(am.a.IOb, "");
                continue;
                bc.aCg();
                com.tencent.mm.model.c.ajA().set(am.a.IOb, "");
              }
            }
          });
          bc.ajj().a((n)localObject1, 0);
        }
        for (;;)
        {
          l.Xf().clear();
          l.Xh().clear();
          a.IvT.d(l.Xi());
          label376:
          AppMethodBeat.o(19893);
          return false;
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.IOb, "");
        }
      }
    }, true);
    fHr = new l.3();
    AppMethodBeat.o(19896);
  }
  
  public static void run()
  {
    AppMethodBeat.i(19895);
    if ((!bc.ajM()) || (bc.aiT()))
    {
      AppMethodBeat.o(19895);
      return;
    }
    bc.aCg();
    Object localObject = Boolean.valueOf(bu.a((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IOd, null), false));
    ae.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is ".concat(String.valueOf(localObject)));
    if (!((Boolean)localObject).booleanValue())
    {
      AppMethodBeat.o(19895);
      return;
    }
    long l1 = bu.aRi();
    bc.aCg();
    long l2 = bu.a((Long)com.tencent.mm.model.c.ajA().get(am.a.IOe, null), 0L);
    bc.aCg();
    if (l1 - l2 > bu.a((Long)com.tencent.mm.model.c.ajA().get(am.a.INY, null), 0L))
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IOd, Boolean.FALSE);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IOc, "");
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IOb, "");
      bc.aCg();
      com.tencent.mm.model.c.aiV();
      AppMethodBeat.o(19895);
      return;
    }
    localObject = BluetoothAdapter.getDefaultAdapter();
    if ((Build.VERSION.SDK_INT >= 18) && (localObject != null) && (((BluetoothAdapter)localObject).getState() == 12))
    {
      localObject = com.tencent.mm.n.g.acM().acC();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          ae.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[] { str });
          ee localee = new ee();
          localee.dqp.dqr = str;
          localee.dqp.dqo = true;
          a.IvT.l(localee);
        }
        fHi = com.tencent.mm.modelgeo.d.aIh();
        if (fHq.foU()) {
          fHq.ay(3000L, 3000L);
        }
        if ((!fHl) && (fHi != null)) {
          fHi.a(fHp, true);
        }
        a.IvT.c(fHr);
      }
      AppMethodBeat.o(19895);
      return;
    }
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IOb, "");
    AppMethodBeat.o(19895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.l
 * JD-Core Version:    0.7.0.1
 */