package c.t.m.g;

import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class bw
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 2147483647;
  public int h = 2147483647;
  public final long i = System.currentTimeMillis();
  private List<NeighboringCellInfo> j;
  
  public static bw a(bf parambf, CellLocation paramCellLocation, SignalStrength paramSignalStrength)
  {
    TelephonyManager localTelephonyManager = parambf.a();
    Object localObject;
    if (b.a.a(paramCellLocation, localTelephonyManager)) {
      localObject = null;
    }
    bw localbw;
    do
    {
      return localObject;
      localbw = new bw();
      if ((paramCellLocation instanceof GsmCellLocation))
      {
        paramCellLocation = (GsmCellLocation)paramCellLocation;
        localbw.a = 1;
        localbw.a(parambf, localTelephonyManager);
        localbw.d = paramCellLocation.getLac();
        localbw.e = paramCellLocation.getCid();
        if (paramSignalStrength == null)
        {
          localbw.f = -1;
          return localbw;
        }
        localbw.f = (paramSignalStrength.getGsmSignalStrength() * 2 - 113);
        return localbw;
      }
      localObject = localbw;
    } while (!(paramCellLocation instanceof CdmaCellLocation));
    paramCellLocation = (CdmaCellLocation)paramCellLocation;
    localbw.a = 2;
    localbw.a(parambf, localTelephonyManager);
    localbw.c = paramCellLocation.getSystemId();
    localbw.d = paramCellLocation.getNetworkId();
    localbw.e = paramCellLocation.getBaseStationId();
    localbw.g = paramCellLocation.getBaseStationLatitude();
    localbw.h = paramCellLocation.getBaseStationLongitude();
    if (paramSignalStrength == null)
    {
      localbw.f = -1;
      return localbw;
    }
    localbw.f = paramSignalStrength.getCdmaDbm();
    return localbw;
  }
  
  private void a(bf parambf, TelephonyManager paramTelephonyManager)
  {
    parambf = parambf.d();
    int k = parambf.h;
    int m = parambf.i;
    if ((k > 0) && (m >= 0))
    {
      this.b = k;
      this.c = m;
      return;
    }
    int[] arrayOfInt = new int[2];
    b.a.a(paramTelephonyManager, arrayOfInt);
    parambf.h = arrayOfInt[0];
    parambf.i = arrayOfInt[1];
  }
  
  @NonNull
  public final List<NeighboringCellInfo> a()
  {
    try
    {
      if (this.j == null) {
        this.j = Collections.emptyList();
      }
      List localList = this.j;
      return localList;
    }
    finally {}
  }
  
  public final void a(@Nullable List<NeighboringCellInfo> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        this.j = Collections.unmodifiableList(paramList);
        return;
      }
      finally {}
      this.j = Collections.emptyList();
    }
  }
  
  public final String toString()
  {
    return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.bw
 * JD-Core Version:    0.7.0.1
 */