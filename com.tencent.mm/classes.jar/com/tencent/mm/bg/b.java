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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final byte[] ikl;
  private static b ikm;
  private ServerMessageListener ikA;
  private boolean ikn;
  private HandlerThread iko;
  int ikp;
  int ikq;
  int ikr;
  private int iks;
  private c ikt;
  private List<d> iku;
  private List<d> ikv;
  private com.tencent.mm.sdk.b.c ikw;
  private av ikx;
  private LocationUpdateListener iky;
  private int ikz;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(150903);
    ikl = "@wechat*weixin!!".getBytes();
    AppMethodBeat.o(150903);
  }
  
  public b()
  {
    AppMethodBeat.i(150884);
    this.ikn = false;
    this.startTime = 0L;
    this.ikp = 5000;
    this.ikq = 5000;
    this.ikr = 30000;
    this.iks = 3600;
    this.iku = new ArrayList();
    this.ikv = new ArrayList();
    this.ikw = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.kernel.g.ajD();
    this.ikx = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150880);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
        b.aKn();
        b.this.aKh();
        AppMethodBeat.o(150880);
        return false;
      }
    }, false);
    this.iky = new LocationUpdateListener()
    {
      public final void onLocationUpdate(double paramAnonymousDouble1, double paramAnonymousDouble2, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        AppMethodBeat.i(150881);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", new Object[] { Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(150881);
      }
    };
    this.ikz = 0;
    this.ikA = new ServerMessageListener()
    {
      public final void onMessage(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(150882);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if ((paramAnonymousInt != 0) && (b.o(b.this) > 3))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", new Object[] { Integer.valueOf(3) });
          b.aKo();
          b.this.aKh();
        }
        AppMethodBeat.o(150882);
      }
    };
    AppMethodBeat.o(150884);
  }
  
  public static b aKf()
  {
    AppMethodBeat.i(150883);
    if (ikm == null) {
      ikm = new b();
    }
    b localb = ikm;
    AppMethodBeat.o(150883);
    return localb;
  }
  
  private static String aKg()
  {
    AppMethodBeat.i(150885);
    String str = com.tencent.mm.compatible.deviceinfo.q.cH(true);
    com.tencent.mm.kernel.g.ajA();
    Object localObject = new p(com.tencent.mm.kernel.a.getUin()).toString();
    str = str + "_" + (String)localObject;
    try
    {
      localObject = new com.tencent.mm.platformtools.ad();
      byte[] arrayOfByte1 = str.getBytes("UTF-8");
      byte[] arrayOfByte2 = ikl;
      localObject = new String(Base64.encode(((com.tencent.mm.platformtools.ad)localObject).a(arrayOfByte1, arrayOfByte1.length, arrayOfByte2), 0), "UTF-8");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new Object[] { localObject, bt.aRp(str) });
      AppMethodBeat.o(150885);
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SenseWhereHelper", "create imei error: " + localException.toString());
      AppMethodBeat.o(150885);
    }
    return "";
  }
  
  private boolean aKi()
  {
    AppMethodBeat.i(150888);
    com.tencent.mm.kernel.g.ajA();
    if (new p(com.tencent.mm.kernel.a.getUin()).longValue() < 1000000L)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
      AppMethodBeat.o(150888);
      return false;
    }
    Object localObject = com.tencent.mm.n.g.acA().getValue("AndroidSenseWhereArgs");
    if (bt.isNullOrNil((String)localObject))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
      AppMethodBeat.o(150888);
      return false;
    }
    try
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SenseWhereHelper", "sense where config : ".concat(String.valueOf(localObject)));
      localObject = ((String)localObject).split(";");
      int i = bt.getInt(localObject[0], 0);
      com.tencent.mm.kernel.g.ajA();
      int j = i.ce(com.tencent.mm.kernel.a.getUin() + 5, 100);
      if (j > i)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(150888);
        return false;
      }
      this.ikq = bt.getInt(localObject[1], 5000);
      this.ikp = bt.getInt(localObject[2], 5000);
      this.ikr = bt.getInt(localObject[3], 30000);
      this.iks = bt.getInt(localObject[4], 3600);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", new Object[] { Integer.valueOf(this.ikq), Integer.valueOf(this.ikp), Integer.valueOf(this.ikr), Integer.valueOf(this.iks) });
      long l = bt.rM(((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IvY, Long.valueOf(0L))).longValue());
      i = this.iks;
      if (l > i)
      {
        AppMethodBeat.o(150888);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(this.iks) });
      AppMethodBeat.o(150888);
      return false;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + localException.toString());
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
      AppMethodBeat.o(150888);
    }
    return false;
  }
  
  public static void aKj()
  {
    AppMethodBeat.i(150889);
    if (bt.rM(bt.a((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IvX, null), 0L)) * 1000L > 21600000L)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
      l locall = new l(36);
      com.tencent.mm.kernel.g.ajB().gAO.a(locall, 0);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IvX, Long.valueOf(bt.aQJ()));
    }
    AppMethodBeat.o(150889);
  }
  
  public final void a(final float paramFloat1, final float paramFloat2, final int paramInt1, final String paramString1, final String paramString2, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(150886);
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      com.tencent.mm.kernel.g.ajA();
      if (!com.tencent.mm.kernel.a.aiE()) {}
    }
    else
    {
      AppMethodBeat.o(150886);
      return;
    }
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150877);
        if (b.a(b.this))
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
          AppMethodBeat.o(150877);
          return;
        }
        if (!b.b(b.this))
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
          AppMethodBeat.o(150877);
          return;
        }
        b.aKj();
        if ((b.c(b.this).size() == 0) && (b.d(b.this).size() == 0)) {
          b.e(b.this);
        }
        if (!b.a(b.this, paramInt2, paramFloat1, paramFloat2))
        {
          AppMethodBeat.o(150877);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) });
        b.a(b.this, true);
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IvY, Long.valueOf(bt.aQJ()));
        com.tencent.mm.sdk.b.a.IbL.c(b.f(b.this));
        if (b.g(b.this) != null) {
          b.g(b.this).finish();
        }
        b.h(b.this);
        b.a(b.this, bt.HI());
        b.a(b.this, new c(paramFloat1, paramFloat2, paramInt1, this.ikF, paramString1, paramString2, paramInt2, paramInt3));
        SwEngine.setImei(b.aKk());
        SwEngine.creatLocationEngine(aj.getContext(), b.g(b.this));
        SwEngine.startContinousLocationUpdate(b.i(b.this), b.this.ikp, b.this.ikq, b.j(b.this), b.k(b.this));
        b.aKl();
        b.a(b.this, b.this.ikr);
        AppMethodBeat.o(150877);
      }
    });
    AppMethodBeat.o(150886);
  }
  
  public final void aKh()
  {
    AppMethodBeat.i(150887);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150878);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
        com.tencent.mm.sdk.b.a.IbL.d(b.f(b.this));
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
 * Qualified Name:     com.tencent.mm.bg.b
 * JD-Core Version:    0.7.0.1
 */