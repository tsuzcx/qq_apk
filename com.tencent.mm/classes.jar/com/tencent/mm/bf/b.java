package com.tencent.mm.bf;

import android.os.HandlerThread;
import android.util.Base64;
import com.tencent.map.swlocation.api.LocationUpdateListener;
import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.i;
import com.tencent.mm.b.p;
import com.tencent.mm.bb.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final byte[] jim;
  private static b jin;
  private int jiA;
  private ServerMessageListener jiB;
  private boolean jio;
  private HandlerThread jip;
  int jiq;
  int jir;
  int jis;
  private int jit;
  private c jiu;
  private List<d> jiv;
  private List<d> jiw;
  private IListener jix;
  private MTimerHandler jiy;
  private LocationUpdateListener jiz;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(150903);
    jim = "@wechat*weixin!!".getBytes();
    AppMethodBeat.o(150903);
  }
  
  public b()
  {
    AppMethodBeat.i(150884);
    this.jio = false;
    this.startTime = 0L;
    this.jiq = 5000;
    this.jir = 5000;
    this.jis = 30000;
    this.jit = 3600;
    this.jiv = new ArrayList();
    this.jiw = new ArrayList();
    this.jix = new IListener() {};
    g.aAi();
    this.jiy = new MTimerHandler(g.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150880);
        Log.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
        b.beJ();
        b.this.beD();
        AppMethodBeat.o(150880);
        return false;
      }
    }, false);
    this.jiz = new LocationUpdateListener()
    {
      public final void onLocationUpdate(double paramAnonymousDouble1, double paramAnonymousDouble2, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        AppMethodBeat.i(150881);
        Log.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", new Object[] { Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(150881);
      }
    };
    this.jiA = 0;
    this.jiB = new ServerMessageListener()
    {
      public final void onMessage(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(150882);
        Log.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if ((paramAnonymousInt != 0) && (b.o(b.this) > 3))
        {
          Log.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", new Object[] { Integer.valueOf(3) });
          b.beK();
          b.this.beD();
        }
        AppMethodBeat.o(150882);
      }
    };
    AppMethodBeat.o(150884);
  }
  
  public static b beB()
  {
    AppMethodBeat.i(150883);
    if (jin == null) {
      jin = new b();
    }
    b localb = jin;
    AppMethodBeat.o(150883);
    return localb;
  }
  
  private static String beC()
  {
    AppMethodBeat.i(150885);
    String str = q.dr(true);
    g.aAf();
    Object localObject = new p(a.getUin()).toString();
    str = str + "_" + (String)localObject;
    try
    {
      localObject = new ad();
      byte[] arrayOfByte1 = str.getBytes("UTF-8");
      byte[] arrayOfByte2 = jim;
      localObject = new String(Base64.encode(((ad)localObject).a(arrayOfByte1, arrayOfByte1.length, arrayOfByte2), 0), "UTF-8");
      Log.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new Object[] { localObject, Util.secPrint(str) });
      AppMethodBeat.o(150885);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      Log.e("MicroMsg.SenseWhereHelper", "create imei error: " + localException.toString());
      AppMethodBeat.o(150885);
    }
    return "";
  }
  
  private boolean beE()
  {
    AppMethodBeat.i(150888);
    g.aAf();
    if (new p(a.getUin()).longValue() < 1000000L)
    {
      Log.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
      AppMethodBeat.o(150888);
      return false;
    }
    Object localObject = h.aqJ().getValue("AndroidSenseWhereArgs");
    if (Util.isNullOrNil((String)localObject))
    {
      Log.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
      AppMethodBeat.o(150888);
      return false;
    }
    try
    {
      Log.d("MicroMsg.SenseWhereHelper", "sense where config : ".concat(String.valueOf(localObject)));
      localObject = ((String)localObject).split(";");
      int i = Util.getInt(localObject[0], 0);
      g.aAf();
      int j = i.ch(a.getUin() + 5, 100);
      if (j > i)
      {
        Log.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(150888);
        return false;
      }
      this.jir = Util.getInt(localObject[1], 5000);
      this.jiq = Util.getInt(localObject[2], 5000);
      this.jis = Util.getInt(localObject[3], 30000);
      this.jit = Util.getInt(localObject[4], 3600);
      Log.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", new Object[] { Integer.valueOf(this.jir), Integer.valueOf(this.jiq), Integer.valueOf(this.jis), Integer.valueOf(this.jit) });
      long l = Util.secondsToNow(((Long)g.aAh().azQ().get(ar.a.NYx, Long.valueOf(0L))).longValue());
      i = this.jit;
      if (l > i)
      {
        AppMethodBeat.o(150888);
        return true;
      }
      Log.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(this.jit) });
      AppMethodBeat.o(150888);
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SenseWhereHelper", localException, "", new Object[0]);
      Log.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + localException.toString());
      Log.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
      AppMethodBeat.o(150888);
    }
    return false;
  }
  
  public static void beF()
  {
    AppMethodBeat.i(150889);
    if (Util.secondsToNow(Util.nullAs((Long)g.aAh().azQ().get(ar.a.NYw, null), 0L)) * 1000L > 21600000L)
    {
      Log.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
      n localn = new n(36);
      g.aAg().hqi.a(localn, 0);
      g.aAh().azQ().set(ar.a.NYw, Long.valueOf(Util.nowSecond()));
    }
    AppMethodBeat.o(150889);
  }
  
  public final void a(final float paramFloat1, final float paramFloat2, final int paramInt1, final String paramString1, final String paramString2, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(150886);
    if (g.aAf().azp())
    {
      g.aAf();
      if (!a.azj()) {}
    }
    else
    {
      AppMethodBeat.o(150886);
      return;
    }
    g.aAi();
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150877);
        if (b.a(b.this))
        {
          Log.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
          AppMethodBeat.o(150877);
          return;
        }
        if (!b.b(b.this))
        {
          Log.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
          AppMethodBeat.o(150877);
          return;
        }
        b.beF();
        if ((b.c(b.this).size() == 0) && (b.d(b.this).size() == 0)) {
          b.e(b.this);
        }
        if (!b.a(b.this, paramInt2, paramFloat1, paramFloat2))
        {
          AppMethodBeat.o(150877);
          return;
        }
        Log.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) });
        b.a(b.this, true);
        g.aAh().azQ().set(ar.a.NYx, Long.valueOf(Util.nowSecond()));
        EventCenter.instance.addListener(b.f(b.this));
        if (b.g(b.this) != null) {
          b.g(b.this).finish();
        }
        b.h(b.this);
        b.a(b.this, Util.currentTicks());
        b.a(b.this, new c(paramFloat1, paramFloat2, paramInt1, this.jiG, paramString1, paramString2, paramInt2, paramInt3));
        SwEngine.setImei(b.beG());
        SwEngine.creatLocationEngine(MMApplicationContext.getContext(), b.g(b.this));
        SwEngine.startContinousLocationUpdate(b.i(b.this), b.this.jiq, b.this.jir, b.j(b.this), b.k(b.this));
        b.beH();
        b.a(b.this, b.this.jis);
        AppMethodBeat.o(150877);
      }
    });
    AppMethodBeat.o(150886);
  }
  
  public final void beD()
  {
    AppMethodBeat.i(150887);
    g.aAi();
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150878);
        Log.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
        EventCenter.instance.removeListener(b.f(b.this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bf.b
 * JD-Core Version:    0.7.0.1
 */