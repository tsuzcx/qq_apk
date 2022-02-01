package com.c.a.a;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class k
  extends c
  implements GpsStatus.Listener, LocationListener
{
  private static k bOm;
  private Context GX;
  private LocationManager Yf;
  private boolean bOn;
  private GpsStatus bOo;
  private a bOp;
  private final l bOq;
  private Looper mLooper;
  
  private k()
  {
    AppMethodBeat.i(87938);
    this.bOq = new l();
    AppMethodBeat.o(87938);
  }
  
  private void a(long paramLong, float paramFloat)
  {
    AppMethodBeat.i(87946);
    this.Yf.requestLocationUpdates("gps", paramLong, paramFloat, this, this.mLooper);
    AppMethodBeat.o(87946);
  }
  
  static k yL()
  {
    AppMethodBeat.i(87939);
    if (bOm == null) {
      bOm = new k();
    }
    k localk = bOm;
    AppMethodBeat.o(87939);
    return localk;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(87942);
    if (!this.bOn)
    {
      AppMethodBeat.o(87942);
      return;
    }
    this.bOp = ((a)parama);
    if (paramHandler != null) {}
    for (paramContext = paramHandler.getLooper();; paramContext = null)
    {
      this.mLooper = paramContext;
      a(this.bOp.bMC, this.bOp.bOr);
      this.Yf.addGpsStatusListener(this);
      this.bOq.bOy = Math.max(5000L, Math.min(this.bOp.bMC + 5000L, 65000L));
      AppMethodBeat.o(87942);
      return;
    }
  }
  
  /* Error */
  final void a(Handler paramHandler, d.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 114
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnonnull +28 -> 36
    //   11: new 10	com/c/a/a/k$a
    //   14: dup
    //   15: ldc2_w 115
    //   18: invokespecial 119	com/c/a/a/k$a:<init>	(J)V
    //   21: astore_2
    //   22: aload_0
    //   23: aload_1
    //   24: aload_2
    //   25: invokespecial 121	com/c/a/a/c:a	(Landroid/os/Handler;Lcom/c/a/a/d$a;)V
    //   28: ldc 114
    //   30: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_2
    //   37: instanceof 10
    //   40: ifeq +11 -> 51
    //   43: aload_2
    //   44: checkcast 10	com/c/a/a/k$a
    //   47: astore_2
    //   48: goto -26 -> 22
    //   51: new 10	com/c/a/a/k$a
    //   54: dup
    //   55: aload_2
    //   56: getfield 124	com/c/a/a/d$a:bMC	J
    //   59: invokespecial 119	com/c/a/a/k$a:<init>	(J)V
    //   62: astore_2
    //   63: goto -41 -> 22
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	k
    //   0	71	1	paramHandler	Handler
    //   0	71	2	parama	d.a
    // Exception table:
    //   from	to	target	type
    //   2	7	66	finally
    //   11	22	66	finally
    //   22	33	66	finally
    //   36	48	66	finally
    //   51	63	66	finally
  }
  
  final void as(Context paramContext)
  {
    AppMethodBeat.i(87941);
    this.GX = paramContext;
    this.Yf = ((LocationManager)paramContext.getSystemService("location"));
    if ((this.Yf != null) && (this.Yf.getProvider("gps") != null)) {}
    for (boolean bool = true;; bool = false)
    {
      this.bOn = bool;
      AppMethodBeat.o(87941);
      return;
    }
  }
  
  final void at(Context paramContext)
  {
    AppMethodBeat.i(87943);
    if (!this.bOn)
    {
      AppMethodBeat.o(87943);
      return;
    }
    this.Yf.removeUpdates(this);
    this.Yf.removeGpsStatusListener(this);
    AppMethodBeat.o(87943);
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    AppMethodBeat.i(87945);
    if (paramInt == 4)
    {
      if (this.bOo == null)
      {
        this.bOo = this.Yf.getGpsStatus(null);
        AppMethodBeat.o(87945);
        return;
      }
      this.Yf.getGpsStatus(this.bOo);
    }
    AppMethodBeat.o(87945);
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    AppMethodBeat.i(87944);
    if (!y.bSu)
    {
      if (Settings.Secure.getString(this.GX.getContentResolver(), "mock_location").equals("0")) {}
      for (i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(87944);
        return;
      }
    }
    int i = 0;
    Iterator localIterator;
    int j;
    if (this.bOo != null)
    {
      localIterator = this.bOo.getSatellites().iterator();
      j = 0;
      if (localIterator.hasNext()) {}
    }
    for (;;)
    {
      this.bOq.a(paramLocation.getAccuracy(), j, paramLocation.getTime());
      c(new b(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAltitude(), paramLocation.getAccuracy(), paramLocation.getSpeed(), i, j, this.bOq.bOu, this.bOq.bOC / 1000L, (byte)0));
      AppMethodBeat.o(87944);
      return;
      GpsSatellite localGpsSatellite = (GpsSatellite)localIterator.next();
      int k = i + 1;
      i = k;
      if (!localGpsSatellite.usedInFix()) {
        break;
      }
      j += 1;
      i = k;
      break;
      j = 0;
      i = 0;
    }
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  final void yE() {}
  
  final void yF()
  {
    AppMethodBeat.i(87947);
    if ((!this.bOn) || (!this.isRunning) || (this.bOp.bMC >= 300000L))
    {
      AppMethodBeat.o(87947);
      return;
    }
    a(300000L, this.bOp.bOr);
    AppMethodBeat.o(87947);
  }
  
  final void yG()
  {
    AppMethodBeat.i(87948);
    if ((!this.bOn) || (!this.isRunning) || (this.bOp.bMC >= 300000L))
    {
      AppMethodBeat.o(87948);
      return;
    }
    a(this.bOp.bMC, this.bOp.bOr);
    AppMethodBeat.o(87948);
  }
  
  static final class a
    extends d.a
  {
    final int bOr = 0;
    
    a(long paramLong)
    {
      super();
    }
  }
  
  static final class b
    extends p
  {
    final float aTw;
    final double bOs;
    final float bOt;
    final float bOu;
    final int bOv;
    final int bOw;
    final long bOx;
    final double lat;
    final double lng;
    
    private b(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, long paramLong)
    {
      super();
      this.lat = paramDouble1;
      this.lng = paramDouble2;
      this.bOs = paramDouble3;
      this.bOt = paramFloat1;
      this.aTw = paramFloat2;
      this.bOv = paramInt1;
      this.bOw = paramInt2;
      this.bOu = paramFloat3;
      this.bOx = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.k
 * JD-Core Version:    0.7.0.1
 */