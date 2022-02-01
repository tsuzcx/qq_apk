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
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final byte[] ine;
  private static b inf;
  private boolean ing;
  private HandlerThread inh;
  int ini;
  int inj;
  int ink;
  private int inl;
  private c inm;
  private List<d> inn;
  private List<d> ino;
  private com.tencent.mm.sdk.b.c inp;
  private aw inq;
  private LocationUpdateListener inr;
  private int ins;
  private ServerMessageListener jdField_int;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(150903);
    ine = "@wechat*weixin!!".getBytes();
    AppMethodBeat.o(150903);
  }
  
  public b()
  {
    AppMethodBeat.i(150884);
    this.ing = false;
    this.startTime = 0L;
    this.ini = 5000;
    this.inj = 5000;
    this.ink = 30000;
    this.inl = 3600;
    this.inn = new ArrayList();
    this.ino = new ArrayList();
    this.inp = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.kernel.g.ajS();
    this.inq = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150880);
        ae.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
        b.aKG();
        b.this.aKA();
        AppMethodBeat.o(150880);
        return false;
      }
    }, false);
    this.inr = new LocationUpdateListener()
    {
      public final void onLocationUpdate(double paramAnonymousDouble1, double paramAnonymousDouble2, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        AppMethodBeat.i(150881);
        ae.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", new Object[] { Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(150881);
      }
    };
    this.ins = 0;
    this.jdField_int = new ServerMessageListener()
    {
      public final void onMessage(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(150882);
        ae.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if ((paramAnonymousInt != 0) && (b.o(b.this) > 3))
        {
          ae.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", new Object[] { Integer.valueOf(3) });
          b.aKH();
          b.this.aKA();
        }
        AppMethodBeat.o(150882);
      }
    };
    AppMethodBeat.o(150884);
  }
  
  private boolean aKB()
  {
    AppMethodBeat.i(150888);
    com.tencent.mm.kernel.g.ajP();
    if (new p(com.tencent.mm.kernel.a.getUin()).longValue() < 1000000L)
    {
      ae.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
      AppMethodBeat.o(150888);
      return false;
    }
    Object localObject = com.tencent.mm.n.g.acL().getValue("AndroidSenseWhereArgs");
    if (bu.isNullOrNil((String)localObject))
    {
      ae.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
      AppMethodBeat.o(150888);
      return false;
    }
    try
    {
      ae.d("MicroMsg.SenseWhereHelper", "sense where config : ".concat(String.valueOf(localObject)));
      localObject = ((String)localObject).split(";");
      int i = bu.getInt(localObject[0], 0);
      com.tencent.mm.kernel.g.ajP();
      int j = i.cf(com.tencent.mm.kernel.a.getUin() + 5, 100);
      if (j > i)
      {
        ae.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(150888);
        return false;
      }
      this.inj = bu.getInt(localObject[1], 5000);
      this.ini = bu.getInt(localObject[2], 5000);
      this.ink = bu.getInt(localObject[3], 30000);
      this.inl = bu.getInt(localObject[4], 3600);
      ae.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", new Object[] { Integer.valueOf(this.inj), Integer.valueOf(this.ini), Integer.valueOf(this.ink), Integer.valueOf(this.inl) });
      long l = bu.rZ(((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQw, Long.valueOf(0L))).longValue());
      i = this.inl;
      if (l > i)
      {
        AppMethodBeat.o(150888);
        return true;
      }
      ae.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(this.inl) });
      AppMethodBeat.o(150888);
      return false;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      ae.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + localException.toString());
      ae.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
      AppMethodBeat.o(150888);
    }
    return false;
  }
  
  public static void aKC()
  {
    AppMethodBeat.i(150889);
    if (bu.rZ(bu.a((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQv, null), 0L)) * 1000L > 21600000L)
    {
      ae.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
      l locall = new l(36);
      com.tencent.mm.kernel.g.ajQ().gDv.a(locall, 0);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQv, Long.valueOf(bu.aRi()));
    }
    AppMethodBeat.o(150889);
  }
  
  public static b aKy()
  {
    AppMethodBeat.i(150883);
    if (inf == null) {
      inf = new b();
    }
    b localb = inf;
    AppMethodBeat.o(150883);
    return localb;
  }
  
  private static String aKz()
  {
    AppMethodBeat.i(150885);
    String str = com.tencent.mm.compatible.deviceinfo.q.cH(true);
    com.tencent.mm.kernel.g.ajP();
    Object localObject = new p(com.tencent.mm.kernel.a.getUin()).toString();
    str = str + "_" + (String)localObject;
    try
    {
      localObject = new ad();
      byte[] arrayOfByte1 = str.getBytes("UTF-8");
      byte[] arrayOfByte2 = ine;
      localObject = new String(Base64.encode(((ad)localObject).a(arrayOfByte1, arrayOfByte1.length, arrayOfByte2), 0), "UTF-8");
      ae.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new Object[] { localObject, bu.aSM(str) });
      AppMethodBeat.o(150885);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      ae.e("MicroMsg.SenseWhereHelper", "create imei error: " + localException.toString());
      AppMethodBeat.o(150885);
    }
    return "";
  }
  
  public final void a(final float paramFloat1, final float paramFloat2, final int paramInt1, final String paramString1, final String paramString2, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(150886);
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      com.tencent.mm.kernel.g.ajP();
      if (!com.tencent.mm.kernel.a.aiT()) {}
    }
    else
    {
      AppMethodBeat.o(150886);
      return;
    }
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150877);
        if (b.a(b.this))
        {
          ae.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
          AppMethodBeat.o(150877);
          return;
        }
        if (!b.b(b.this))
        {
          ae.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
          AppMethodBeat.o(150877);
          return;
        }
        b.aKC();
        if ((b.c(b.this).size() == 0) && (b.d(b.this).size() == 0)) {
          b.e(b.this);
        }
        if (!b.a(b.this, paramInt2, paramFloat1, paramFloat2))
        {
          AppMethodBeat.o(150877);
          return;
        }
        ae.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) });
        b.a(b.this, true);
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQw, Long.valueOf(bu.aRi()));
        com.tencent.mm.sdk.b.a.IvT.c(b.f(b.this));
        if (b.g(b.this) != null) {
          b.g(b.this).finish();
        }
        b.h(b.this);
        b.a(b.this, bu.HQ());
        b.a(b.this, new c(paramFloat1, paramFloat2, paramInt1, this.iny, paramString1, paramString2, paramInt2, paramInt3));
        SwEngine.setImei(b.aKD());
        SwEngine.creatLocationEngine(ak.getContext(), b.g(b.this));
        SwEngine.startContinousLocationUpdate(b.i(b.this), b.this.ini, b.this.inj, b.j(b.this), b.k(b.this));
        b.aKE();
        b.a(b.this, b.this.ink);
        AppMethodBeat.o(150877);
      }
    });
    AppMethodBeat.o(150886);
  }
  
  public final void aKA()
  {
    AppMethodBeat.i(150887);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150878);
        ae.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
        com.tencent.mm.sdk.b.a.IvT.d(b.f(b.this));
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