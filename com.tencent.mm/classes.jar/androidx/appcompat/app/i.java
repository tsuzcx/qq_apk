package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;

final class i
{
  private static i hF;
  private final LocationManager hG;
  private final a hH;
  private final Context mContext;
  
  private i(Context paramContext, LocationManager paramLocationManager)
  {
    AppMethodBeat.i(238492);
    this.hH = new a();
    this.mContext = paramContext;
    this.hG = paramLocationManager;
    AppMethodBeat.o(238492);
  }
  
  static i H(Context paramContext)
  {
    AppMethodBeat.i(238491);
    if (hF == null)
    {
      paramContext = paramContext.getApplicationContext();
      hF = new i(paramContext, (LocationManager)paramContext.getSystemService("location"));
    }
    paramContext = hF;
    AppMethodBeat.o(238491);
    return paramContext;
  }
  
  private void a(Location paramLocation)
  {
    AppMethodBeat.i(238499);
    a locala = this.hH;
    long l1 = System.currentTimeMillis();
    h localh = h.bc();
    localh.b(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localh.hD;
    localh.b(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (localh.state == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = localh.hE;
      l4 = localh.hD;
      localh.b(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = localh.hE;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 = 43200000L + l1;
      locala.hI = bool;
      locala.hJ = l2;
      locala.hK = l3;
      locala.hL = l4;
      locala.hM = l5;
      locala.hN = l1;
      AppMethodBeat.o(238499);
      return;
    }
    if (l1 > l4) {
      l1 = 0L + l5;
    }
    for (;;)
    {
      l1 += 60000L;
      break;
      if (l1 > l3) {
        l1 = 0L + l4;
      } else {
        l1 = 0L + l3;
      }
    }
  }
  
  @SuppressLint({"MissingPermission"})
  private Location be()
  {
    Location localLocation2 = null;
    AppMethodBeat.i(238496);
    if (b.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {}
    for (Location localLocation1 = p("network");; localLocation1 = null)
    {
      if (b.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localLocation2 = p("gps");
      }
      if ((localLocation2 != null) && (localLocation1 != null))
      {
        if (localLocation2.getTime() > localLocation1.getTime())
        {
          AppMethodBeat.o(238496);
          return localLocation2;
        }
        AppMethodBeat.o(238496);
        return localLocation1;
      }
      if (localLocation2 != null)
      {
        AppMethodBeat.o(238496);
        return localLocation2;
      }
      AppMethodBeat.o(238496);
      return localLocation1;
    }
  }
  
  private boolean bf()
  {
    AppMethodBeat.i(238498);
    if (this.hH.hN > System.currentTimeMillis())
    {
      AppMethodBeat.o(238498);
      return true;
    }
    AppMethodBeat.o(238498);
    return false;
  }
  
  private Location p(String paramString)
  {
    AppMethodBeat.i(238497);
    try
    {
      if (this.hG.isProviderEnabled(paramString))
      {
        paramString = this.hG.getLastKnownLocation(paramString);
        AppMethodBeat.o(238497);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(238497);
    }
    return null;
  }
  
  final boolean bd()
  {
    AppMethodBeat.i(238494);
    a locala = this.hH;
    boolean bool;
    if (bf())
    {
      bool = locala.hI;
      AppMethodBeat.o(238494);
      return bool;
    }
    Location localLocation = be();
    if (localLocation != null)
    {
      a(localLocation);
      bool = locala.hI;
      AppMethodBeat.o(238494);
      return bool;
    }
    int i = Calendar.getInstance().get(11);
    if ((i < 6) || (i >= 22))
    {
      AppMethodBeat.o(238494);
      return true;
    }
    AppMethodBeat.o(238494);
    return false;
  }
  
  static final class a
  {
    boolean hI;
    long hJ;
    long hK;
    long hL;
    long hM;
    long hN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.app.i
 * JD-Core Version:    0.7.0.1
 */