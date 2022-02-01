package com.tencent.mm.bg;

import android.os.HandlerThread;
import android.util.Base64;
import com.tencent.map.swlocation.api.LocationUpdateListener;
import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.b.p;
import com.tencent.mm.bc.l;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final byte[] hqv;
  private static b hqw;
  int hqA;
  int hqB;
  private int hqC;
  private c hqD;
  private List<d> hqE;
  private List<d> hqF;
  private com.tencent.mm.sdk.b.c hqG;
  private av hqH;
  private LocationUpdateListener hqI;
  private int hqJ;
  private ServerMessageListener hqK;
  private boolean hqx;
  private HandlerThread hqy;
  int hqz;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(150903);
    hqv = "@wechat*weixin!!".getBytes();
    AppMethodBeat.o(150903);
  }
  
  public b()
  {
    AppMethodBeat.i(150884);
    this.hqx = false;
    this.startTime = 0L;
    this.hqz = 5000;
    this.hqA = 5000;
    this.hqB = 30000;
    this.hqC = 3600;
    this.hqE = new ArrayList();
    this.hqF = new ArrayList();
    this.hqG = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.kernel.g.afC();
    this.hqH = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150880);
        ad.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
        b.aAm();
        b.this.aAg();
        AppMethodBeat.o(150880);
        return false;
      }
    }, false);
    this.hqI = new LocationUpdateListener()
    {
      public final void onLocationUpdate(double paramAnonymousDouble1, double paramAnonymousDouble2, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        AppMethodBeat.i(150881);
        ad.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", new Object[] { Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(150881);
      }
    };
    this.hqJ = 0;
    this.hqK = new ServerMessageListener()
    {
      public final void onMessage(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(150882);
        ad.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if ((paramAnonymousInt != 0) && (b.o(b.this) > 3))
        {
          ad.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", new Object[] { Integer.valueOf(3) });
          b.aAn();
          b.this.aAg();
        }
        AppMethodBeat.o(150882);
      }
    };
    AppMethodBeat.o(150884);
  }
  
  public static b aAe()
  {
    AppMethodBeat.i(150883);
    if (hqw == null) {
      hqw = new b();
    }
    b localb = hqw;
    AppMethodBeat.o(150883);
    return localb;
  }
  
  private static String aAf()
  {
    AppMethodBeat.i(150885);
    String str = com.tencent.mm.compatible.deviceinfo.q.cG(true);
    com.tencent.mm.kernel.g.afz();
    Object localObject = new p(com.tencent.mm.kernel.a.getUin()).toString();
    str = str + "_" + (String)localObject;
    try
    {
      localObject = new ac();
      byte[] arrayOfByte1 = str.getBytes("UTF-8");
      byte[] arrayOfByte2 = hqv;
      localObject = new String(Base64.encode(((ac)localObject).a(arrayOfByte1, arrayOfByte1.length, arrayOfByte2), 0), "UTF-8");
      ad.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new Object[] { localObject, bt.aGs(str) });
      AppMethodBeat.o(150885);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      ad.e("MicroMsg.SenseWhereHelper", "create imei error: " + localException.toString());
      AppMethodBeat.o(150885);
    }
    return "";
  }
  
  private boolean aAh()
  {
    AppMethodBeat.i(150888);
    com.tencent.mm.kernel.g.afz();
    if (new p(com.tencent.mm.kernel.a.getUin()).longValue() < 1000000L)
    {
      ad.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
      AppMethodBeat.o(150888);
      return false;
    }
    Object localObject = com.tencent.mm.m.g.Zd().getValue("AndroidSenseWhereArgs");
    if (bt.isNullOrNil((String)localObject))
    {
      ad.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
      AppMethodBeat.o(150888);
      return false;
    }
    try
    {
      ad.d("MicroMsg.SenseWhereHelper", "sense where config : ".concat(String.valueOf(localObject)));
      localObject = ((String)localObject).split(";");
      int i = bt.getInt(localObject[0], 0);
      com.tencent.mm.kernel.g.afz();
      int j = i.cf(com.tencent.mm.kernel.a.getUin() + 5, 100);
      if (j > i)
      {
        ad.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(150888);
        return false;
      }
      this.hqA = bt.getInt(localObject[1], 5000);
      this.hqz = bt.getInt(localObject[2], 5000);
      this.hqB = bt.getInt(localObject[3], 30000);
      this.hqC = bt.getInt(localObject[4], 3600);
      ad.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", new Object[] { Integer.valueOf(this.hqA), Integer.valueOf(this.hqz), Integer.valueOf(this.hqB), Integer.valueOf(this.hqC) });
      long l = bt.lZ(((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FlR, Long.valueOf(0L))).longValue());
      i = this.hqC;
      if (l > i)
      {
        AppMethodBeat.o(150888);
        return true;
      }
      ad.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(this.hqC) });
      AppMethodBeat.o(150888);
      return false;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      ad.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + localException.toString());
      ad.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
      AppMethodBeat.o(150888);
    }
    return false;
  }
  
  public static void aAi()
  {
    AppMethodBeat.i(150889);
    if (bt.lZ(bt.a((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FlQ, null), 0L)) * 1000L > 21600000L)
    {
      ad.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
      l locall = new l(36);
      com.tencent.mm.kernel.g.afA().gcy.a(locall, 0);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FlQ, Long.valueOf(bt.aGK()));
    }
    AppMethodBeat.o(150889);
  }
  
  public final void a(final float paramFloat1, final float paramFloat2, final int paramInt1, final String paramString1, final String paramString2, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(150886);
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      com.tencent.mm.kernel.g.afz();
      if (!com.tencent.mm.kernel.a.aeC()) {}
    }
    else
    {
      AppMethodBeat.o(150886);
      return;
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150877);
        if (b.a(b.this))
        {
          ad.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
          AppMethodBeat.o(150877);
          return;
        }
        if (!b.b(b.this))
        {
          ad.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
          AppMethodBeat.o(150877);
          return;
        }
        b.aAi();
        if ((b.c(b.this).size() == 0) && (b.d(b.this).size() == 0)) {
          b.e(b.this);
        }
        if (!b.a(b.this, paramInt2, paramFloat1, paramFloat2))
        {
          AppMethodBeat.o(150877);
          return;
        }
        ad.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) });
        b.a(b.this, true);
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FlR, Long.valueOf(bt.aGK()));
        com.tencent.mm.sdk.b.a.ESL.c(b.f(b.this));
        if (b.g(b.this) != null) {
          b.g(b.this).finish();
        }
        b.h(b.this);
        b.a(b.this, bt.GC());
        b.a(b.this, new c(paramFloat1, paramFloat2, paramInt1, this.hqP, paramString1, paramString2, paramInt2, paramInt3));
        SwEngine.setImei(b.aAj());
        SwEngine.creatLocationEngine(aj.getContext(), b.g(b.this));
        SwEngine.startContinousLocationUpdate(b.i(b.this), b.this.hqz, b.this.hqA, b.j(b.this), b.k(b.this));
        b.aAk();
        b.a(b.this, b.this.hqB);
        AppMethodBeat.o(150877);
      }
    });
    AppMethodBeat.o(150886);
  }
  
  public final void aAg()
  {
    AppMethodBeat.i(150887);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150878);
        ad.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
        com.tencent.mm.sdk.b.a.ESL.d(b.f(b.this));
        SwEngine.stopContinousLocationUpdate();
        SwEngine.onDestroy();
        if (b.g(b.this) != null)
        {
          b.g(b.this).finish();
          b.a(b.this, null);
        }
        b.l(b.this);
        b.m(b.this);
        b.n(b.this);
        b.a(b.this, false);
        AppMethodBeat.o(150878);
      }
    });
    AppMethodBeat.o(150887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bg.b
 * JD-Core Version:    0.7.0.1
 */