package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;

final class i
{
  private static i iD;
  private final LocationManager iE;
  private final a iF;
  private final Context mContext;
  
  private i(Context paramContext, LocationManager paramLocationManager)
  {
    AppMethodBeat.i(200515);
    this.iF = new a();
    this.mContext = paramContext;
    this.iE = paramLocationManager;
    AppMethodBeat.o(200515);
  }
  
  static i H(Context paramContext)
  {
    AppMethodBeat.i(200503);
    if (iD == null)
    {
      paramContext = paramContext.getApplicationContext();
      iD = new i(paramContext, (LocationManager)paramContext.getSystemService("location"));
    }
    paramContext = iD;
    AppMethodBeat.o(200503);
    return paramContext;
  }
  
  private Location bX()
  {
    Location localLocation2 = null;
    AppMethodBeat.i(200528);
    if (c.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {}
    for (Location localLocation1 = q("network");; localLocation1 = null)
    {
      if (c.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localLocation2 = q("gps");
      }
      if ((localLocation2 != null) && (localLocation1 != null))
      {
        if (localLocation2.getTime() > localLocation1.getTime())
        {
          AppMethodBeat.o(200528);
          return localLocation2;
        }
        AppMethodBeat.o(200528);
        return localLocation1;
      }
      if (localLocation2 != null)
      {
        AppMethodBeat.o(200528);
        return localLocation2;
      }
      AppMethodBeat.o(200528);
      return localLocation1;
    }
  }
  
  private boolean bY()
  {
    AppMethodBeat.i(200542);
    if (this.iF.iL > System.currentTimeMillis())
    {
      AppMethodBeat.o(200542);
      return true;
    }
    AppMethodBeat.o(200542);
    return false;
  }
  
  private void c(Location paramLocation)
  {
    AppMethodBeat.i(200562);
    a locala = this.iF;
    long l1 = System.currentTimeMillis();
    h localh = h.bV();
    localh.b(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localh.iB;
    localh.b(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (localh.state == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = localh.iC;
      l4 = localh.iB;
      localh.b(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = localh.iC;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 = 43200000L + l1;
      locala.iG = bool;
      locala.iH = l2;
      locala.iI = l3;
      locala.iJ = l4;
      locala.iK = l5;
      locala.iL = l1;
      AppMethodBeat.o(200562);
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
  
  private Location q(String paramString)
  {
    AppMethodBeat.i(200532);
    try
    {
      if (this.iE.isProviderEnabled(paramString))
      {
        paramString = this.iE.getLastKnownLocation(paramString);
        AppMethodBeat.o(200532);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(200532);
    }
    return null;
  }
  
  final boolean bW()
  {
    AppMethodBeat.i(200575);
    a locala = this.iF;
    boolean bool;
    if (bY())
    {
      bool = locala.iG;
      AppMethodBeat.o(200575);
      return bool;
    }
    Location localLocation = bX();
    if (localLocation != null)
    {
      c(localLocation);
      bool = locala.iG;
      AppMethodBeat.o(200575);
      return bool;
    }
    int i = Calendar.getInstance().get(11);
    if ((i < 6) || (i >= 22))
    {
      AppMethodBeat.o(200575);
      return true;
    }
    AppMethodBeat.o(200575);
    return false;
  }
  
  static final class a
  {
    boolean iG;
    long iH;
    long iI;
    long iJ;
    long iK;
    long iL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.appcompat.app.i
 * JD-Core Version:    0.7.0.1
 */