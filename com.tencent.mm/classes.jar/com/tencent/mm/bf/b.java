package com.tencent.mm.bf;

import android.os.HandlerThread;
import android.util.Base64;
import com.tencent.map.swlocation.api.LocationUpdateListener;
import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.b.p;
import com.tencent.mm.bb.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final byte[] hQX;
  private static b hQY;
  private boolean hQZ;
  private HandlerThread hRa;
  int hRb;
  int hRc;
  int hRd;
  private int hRe;
  private c hRf;
  private List<d> hRg;
  private List<d> hRh;
  private com.tencent.mm.sdk.b.c hRi;
  private au hRj;
  private LocationUpdateListener hRk;
  private int hRl;
  private ServerMessageListener hRm;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(150903);
    hQX = "@wechat*weixin!!".getBytes();
    AppMethodBeat.o(150903);
  }
  
  public b()
  {
    AppMethodBeat.i(150884);
    this.hQZ = false;
    this.startTime = 0L;
    this.hRb = 5000;
    this.hRc = 5000;
    this.hRd = 30000;
    this.hRe = 3600;
    this.hRg = new ArrayList();
    this.hRh = new ArrayList();
    this.hRi = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.kernel.g.agS();
    this.hRj = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150880);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
        b.aHc();
        b.this.aGW();
        AppMethodBeat.o(150880);
        return false;
      }
    }, false);
    this.hRk = new LocationUpdateListener()
    {
      public final void onLocationUpdate(double paramAnonymousDouble1, double paramAnonymousDouble2, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        AppMethodBeat.i(150881);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", new Object[] { Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(150881);
      }
    };
    this.hRl = 0;
    this.hRm = new ServerMessageListener()
    {
      public final void onMessage(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(150882);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if ((paramAnonymousInt != 0) && (b.o(b.this) > 3))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", new Object[] { Integer.valueOf(3) });
          b.aHd();
          b.this.aGW();
        }
        AppMethodBeat.o(150882);
      }
    };
    AppMethodBeat.o(150884);
  }
  
  public static b aGU()
  {
    AppMethodBeat.i(150883);
    if (hQY == null) {
      hQY = new b();
    }
    b localb = hQY;
    AppMethodBeat.o(150883);
    return localb;
  }
  
  private static String aGV()
  {
    AppMethodBeat.i(150885);
    String str = com.tencent.mm.compatible.deviceinfo.q.cF(true);
    com.tencent.mm.kernel.g.agP();
    Object localObject = new p(com.tencent.mm.kernel.a.getUin()).toString();
    str = str + "_" + (String)localObject;
    try
    {
      localObject = new com.tencent.mm.platformtools.ac();
      byte[] arrayOfByte1 = str.getBytes("UTF-8");
      byte[] arrayOfByte2 = hQX;
      localObject = new String(Base64.encode(((com.tencent.mm.platformtools.ac)localObject).a(arrayOfByte1, arrayOfByte1.length, arrayOfByte2), 0), "UTF-8");
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new Object[] { localObject, bs.aLJ(str) });
      AppMethodBeat.o(150885);
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SenseWhereHelper", "create imei error: " + localException.toString());
      AppMethodBeat.o(150885);
    }
    return "";
  }
  
  private boolean aGX()
  {
    AppMethodBeat.i(150888);
    com.tencent.mm.kernel.g.agP();
    if (new p(com.tencent.mm.kernel.a.getUin()).longValue() < 1000000L)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
      AppMethodBeat.o(150888);
      return false;
    }
    Object localObject = com.tencent.mm.m.g.ZY().getValue("AndroidSenseWhereArgs");
    if (bs.isNullOrNil((String)localObject))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
      AppMethodBeat.o(150888);
      return false;
    }
    try
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SenseWhereHelper", "sense where config : ".concat(String.valueOf(localObject)));
      localObject = ((String)localObject).split(";");
      int i = bs.getInt(localObject[0], 0);
      com.tencent.mm.kernel.g.agP();
      int j = i.cc(com.tencent.mm.kernel.a.getUin() + 5, 100);
      if (j > i)
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(150888);
        return false;
      }
      this.hRc = bs.getInt(localObject[1], 5000);
      this.hRb = bs.getInt(localObject[2], 5000);
      this.hRd = bs.getInt(localObject[3], 30000);
      this.hRe = bs.getInt(localObject[4], 3600);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", new Object[] { Integer.valueOf(this.hRc), Integer.valueOf(this.hRb), Integer.valueOf(this.hRd), Integer.valueOf(this.hRe) });
      long l = bs.pN(((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GJG, Long.valueOf(0L))).longValue());
      i = this.hRe;
      if (l > i)
      {
        AppMethodBeat.o(150888);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(this.hRe) });
      AppMethodBeat.o(150888);
      return false;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + localException.toString());
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
      AppMethodBeat.o(150888);
    }
    return false;
  }
  
  public static void aGY()
  {
    AppMethodBeat.i(150889);
    if (bs.pN(bs.a((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GJF, null), 0L)) * 1000L > 21600000L)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
      l locall = new l(36);
      com.tencent.mm.kernel.g.agQ().ghe.a(locall, 0);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJF, Long.valueOf(bs.aNx()));
    }
    AppMethodBeat.o(150889);
  }
  
  public final void a(final float paramFloat1, final float paramFloat2, final int paramInt1, final String paramString1, final String paramString2, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(150886);
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      com.tencent.mm.kernel.g.agP();
      if (!com.tencent.mm.kernel.a.afS()) {}
    }
    else
    {
      AppMethodBeat.o(150886);
      return;
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150877);
        if (b.a(b.this))
        {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
          AppMethodBeat.o(150877);
          return;
        }
        if (!b.b(b.this))
        {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
          AppMethodBeat.o(150877);
          return;
        }
        b.aGY();
        if ((b.c(b.this).size() == 0) && (b.d(b.this).size() == 0)) {
          b.e(b.this);
        }
        if (!b.a(b.this, paramInt2, paramFloat1, paramFloat2))
        {
          AppMethodBeat.o(150877);
          return;
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) });
        b.a(b.this, true);
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJG, Long.valueOf(bs.aNx()));
        com.tencent.mm.sdk.b.a.GpY.c(b.f(b.this));
        if (b.g(b.this) != null) {
          b.g(b.this).finish();
        }
        b.h(b.this);
        b.a(b.this, bs.Gn());
        b.a(b.this, new c(paramFloat1, paramFloat2, paramInt1, this.hRr, paramString1, paramString2, paramInt2, paramInt3));
        SwEngine.setImei(b.aGZ());
        SwEngine.creatLocationEngine(ai.getContext(), b.g(b.this));
        SwEngine.startContinousLocationUpdate(b.i(b.this), b.this.hRb, b.this.hRc, b.j(b.this), b.k(b.this));
        b.aHa();
        b.a(b.this, b.this.hRd);
        AppMethodBeat.o(150877);
      }
    });
    AppMethodBeat.o(150886);
  }
  
  public final void aGW()
  {
    AppMethodBeat.i(150887);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150878);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
        com.tencent.mm.sdk.b.a.GpY.d(b.f(b.this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bf.b
 * JD-Core Version:    0.7.0.1
 */