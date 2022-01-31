package com.b.a.a;

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
  private static k boh;
  private LocationManager Ql;
  private boolean boi;
  private GpsStatus boj;
  private k.a bok;
  private final l bol;
  private Looper mLooper;
  private Context zF;
  
  private k()
  {
    AppMethodBeat.i(55593);
    this.bol = new l();
    AppMethodBeat.o(55593);
  }
  
  private void a(long paramLong, float paramFloat)
  {
    AppMethodBeat.i(55601);
    this.Ql.requestLocationUpdates("gps", paramLong, paramFloat, this, this.mLooper);
    AppMethodBeat.o(55601);
  }
  
  static k tk()
  {
    AppMethodBeat.i(55594);
    if (boh == null) {
      boh = new k();
    }
    k localk = boh;
    AppMethodBeat.o(55594);
    return localk;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(55597);
    if (!this.boi)
    {
      AppMethodBeat.o(55597);
      return;
    }
    this.bok = ((k.a)parama);
    if (paramHandler != null) {}
    for (paramContext = paramHandler.getLooper();; paramContext = null)
    {
      this.mLooper = paramContext;
      a(this.bok.bmu, this.bok.bom);
      this.Ql.addGpsStatusListener(this);
      this.bol.bot = Math.max(5000L, Math.min(this.bok.bmu + 5000L, 65000L));
      AppMethodBeat.o(55597);
      return;
    }
  }
  
  /* Error */
  final void a(Handler paramHandler, d.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 113
    //   4: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnonnull +28 -> 36
    //   11: new 10	com/b/a/a/k$a
    //   14: dup
    //   15: ldc2_w 114
    //   18: invokespecial 118	com/b/a/a/k$a:<init>	(J)V
    //   21: astore_2
    //   22: aload_0
    //   23: aload_1
    //   24: aload_2
    //   25: invokespecial 120	com/b/a/a/c:a	(Landroid/os/Handler;Lcom/b/a/a/d$a;)V
    //   28: ldc 113
    //   30: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_2
    //   37: instanceof 10
    //   40: ifeq +11 -> 51
    //   43: aload_2
    //   44: checkcast 10	com/b/a/a/k$a
    //   47: astore_2
    //   48: goto -26 -> 22
    //   51: new 10	com/b/a/a/k$a
    //   54: dup
    //   55: aload_2
    //   56: getfield 123	com/b/a/a/d$a:bmu	J
    //   59: invokespecial 118	com/b/a/a/k$a:<init>	(J)V
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
  
  final void al(Context paramContext)
  {
    AppMethodBeat.i(55596);
    this.zF = paramContext;
    this.Ql = ((LocationManager)paramContext.getSystemService("location"));
    if ((this.Ql != null) && (this.Ql.getProvider("gps") != null)) {}
    for (boolean bool = true;; bool = false)
    {
      this.boi = bool;
      AppMethodBeat.o(55596);
      return;
    }
  }
  
  final void am(Context paramContext)
  {
    AppMethodBeat.i(55598);
    if (!this.boi)
    {
      AppMethodBeat.o(55598);
      return;
    }
    this.Ql.removeUpdates(this);
    this.Ql.removeGpsStatusListener(this);
    AppMethodBeat.o(55598);
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    AppMethodBeat.i(55600);
    if (paramInt == 4)
    {
      if (this.boj == null)
      {
        this.boj = this.Ql.getGpsStatus(null);
        AppMethodBeat.o(55600);
        return;
      }
      this.Ql.getGpsStatus(this.boj);
    }
    AppMethodBeat.o(55600);
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    AppMethodBeat.i(55599);
    if (!y.bsr)
    {
      if (Settings.Secure.getString(this.zF.getContentResolver(), "mock_location").equals("0")) {}
      for (i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(55599);
        return;
      }
    }
    int i = 0;
    Iterator localIterator;
    int j;
    if (this.boj != null)
    {
      localIterator = this.boj.getSatellites().iterator();
      j = 0;
      if (localIterator.hasNext()) {}
    }
    for (;;)
    {
      this.bol.a(paramLocation.getAccuracy(), j, paramLocation.getTime());
      c(new k.b(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAltitude(), paramLocation.getAccuracy(), paramLocation.getSpeed(), i, j, this.bol.bop, this.bol.box / 1000L, (byte)0));
      AppMethodBeat.o(55599);
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
  
  final void td() {}
  
  final void te()
  {
    AppMethodBeat.i(55602);
    if ((!this.boi) || (!this.isRunning) || (this.bok.bmu >= 300000L))
    {
      AppMethodBeat.o(55602);
      return;
    }
    a(300000L, this.bok.bom);
    AppMethodBeat.o(55602);
  }
  
  final void tf()
  {
    AppMethodBeat.i(55603);
    if ((!this.boi) || (!this.isRunning) || (this.bok.bmu >= 300000L))
    {
      AppMethodBeat.o(55603);
      return;
    }
    a(this.bok.bmu, this.bok.bom);
    AppMethodBeat.o(55603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.b.a.a.k
 * JD-Core Version:    0.7.0.1
 */