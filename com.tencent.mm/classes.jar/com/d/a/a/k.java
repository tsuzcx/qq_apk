package com.d.a.a;

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
  private static k bYz;
  private Context IR;
  private LocationManager ZU;
  private boolean bYA;
  private GpsStatus bYB;
  private a bYC;
  private final l bYD;
  private Looper mLooper;
  
  private k()
  {
    AppMethodBeat.i(87938);
    this.bYD = new l();
    AppMethodBeat.o(87938);
  }
  
  static k Aj()
  {
    AppMethodBeat.i(87939);
    if (bYz == null) {
      bYz = new k();
    }
    k localk = bYz;
    AppMethodBeat.o(87939);
    return localk;
  }
  
  private void a(long paramLong, float paramFloat)
  {
    AppMethodBeat.i(87946);
    this.ZU.requestLocationUpdates("gps", paramLong, paramFloat, this, this.mLooper);
    AppMethodBeat.o(87946);
  }
  
  final void Ac() {}
  
  final void Ad()
  {
    AppMethodBeat.i(87947);
    if ((!this.bYA) || (!this.isRunning) || (this.bYC.bWP >= 300000L))
    {
      AppMethodBeat.o(87947);
      return;
    }
    a(300000L, this.bYC.bYE);
    AppMethodBeat.o(87947);
  }
  
  final void Ae()
  {
    AppMethodBeat.i(87948);
    if ((!this.bYA) || (!this.isRunning) || (this.bYC.bWP >= 300000L))
    {
      AppMethodBeat.o(87948);
      return;
    }
    a(this.bYC.bWP, this.bYC.bYE);
    AppMethodBeat.o(87948);
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(87942);
    if (!this.bYA)
    {
      AppMethodBeat.o(87942);
      return;
    }
    this.bYC = ((a)parama);
    if (paramHandler != null) {}
    for (paramContext = paramHandler.getLooper();; paramContext = null)
    {
      this.mLooper = paramContext;
      a(this.bYC.bWP, this.bYC.bYE);
      this.ZU.addGpsStatusListener(this);
      this.bYD.bYL = Math.max(5000L, Math.min(this.bYC.bWP + 5000L, 65000L));
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
    //   2: ldc 126
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnonnull +28 -> 36
    //   11: new 10	com/d/a/a/k$a
    //   14: dup
    //   15: ldc2_w 127
    //   18: invokespecial 131	com/d/a/a/k$a:<init>	(J)V
    //   21: astore_2
    //   22: aload_0
    //   23: aload_1
    //   24: aload_2
    //   25: invokespecial 133	com/d/a/a/c:a	(Landroid/os/Handler;Lcom/d/a/a/d$a;)V
    //   28: ldc 126
    //   30: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_2
    //   37: instanceof 10
    //   40: ifeq +11 -> 51
    //   43: aload_2
    //   44: checkcast 10	com/d/a/a/k$a
    //   47: astore_2
    //   48: goto -26 -> 22
    //   51: new 10	com/d/a/a/k$a
    //   54: dup
    //   55: aload_2
    //   56: getfield 136	com/d/a/a/d$a:bWP	J
    //   59: invokespecial 131	com/d/a/a/k$a:<init>	(J)V
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
  
  final void at(Context paramContext)
  {
    AppMethodBeat.i(87941);
    this.IR = paramContext;
    this.ZU = ((LocationManager)paramContext.getSystemService("location"));
    if ((this.ZU != null) && (this.ZU.getProvider("gps") != null)) {}
    for (boolean bool = true;; bool = false)
    {
      this.bYA = bool;
      AppMethodBeat.o(87941);
      return;
    }
  }
  
  final void au(Context paramContext)
  {
    AppMethodBeat.i(87943);
    if (!this.bYA)
    {
      AppMethodBeat.o(87943);
      return;
    }
    this.ZU.removeUpdates(this);
    this.ZU.removeGpsStatusListener(this);
    AppMethodBeat.o(87943);
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    AppMethodBeat.i(87945);
    if (paramInt == 4)
    {
      if (this.bYB == null)
      {
        this.bYB = this.ZU.getGpsStatus(null);
        AppMethodBeat.o(87945);
        return;
      }
      this.ZU.getGpsStatus(this.bYB);
    }
    AppMethodBeat.o(87945);
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    AppMethodBeat.i(87944);
    if (!y.ccH)
    {
      if (Settings.Secure.getString(this.IR.getContentResolver(), "mock_location").equals("0")) {}
      for (i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(87944);
        return;
      }
    }
    int i = 0;
    Iterator localIterator;
    int j;
    if (this.bYB != null)
    {
      localIterator = this.bYB.getSatellites().iterator();
      j = 0;
      if (localIterator.hasNext()) {}
    }
    for (;;)
    {
      this.bYD.a(paramLocation.getAccuracy(), j, paramLocation.getTime());
      c(new b(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAltitude(), paramLocation.getAccuracy(), paramLocation.getSpeed(), i, j, this.bYD.bYH, this.bYD.bYP / 1000L, (byte)0));
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
  
  static final class a
    extends d.a
  {
    final int bYE = 0;
    
    a(long paramLong)
    {
      super();
    }
  }
  
  static final class b
    extends p
  {
    final double bYF;
    final float bYG;
    final float bYH;
    final int bYI;
    final int bYJ;
    final long bYK;
    final float bdQ;
    final double lat;
    final double lng;
    
    private b(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3, long paramLong)
    {
      super();
      this.lat = paramDouble1;
      this.lng = paramDouble2;
      this.bYF = paramDouble3;
      this.bYG = paramFloat1;
      this.bdQ = paramFloat2;
      this.bYI = paramInt1;
      this.bYJ = paramInt2;
      this.bYH = paramFloat3;
      this.bYK = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.k
 * JD-Core Version:    0.7.0.1
 */