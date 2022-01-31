package c.t.m.g;

import android.annotation.SuppressLint;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class ea
  extends ed
{
  public a a = a.a;
  public int b = 460;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 2147483647;
  public int h = 2147483647;
  private final long i = System.currentTimeMillis();
  private List<NeighboringCellInfo> j;
  
  @SuppressLint({"NewApi"})
  @Nullable
  public static ea a(dg paramdg, CellInfo paramCellInfo)
  {
    int k = -88;
    if (paramCellInfo == null) {
      paramdg = null;
    }
    ea localea;
    do
    {
      return paramdg;
      paramdg = paramdg.e;
      localea = new ea();
      int n;
      int m;
      try
      {
        if ((paramCellInfo instanceof CellInfoCdma))
        {
          paramCellInfo = (CellInfoCdma)paramCellInfo;
          CellIdentityCdma localCellIdentityCdma = paramCellInfo.getCellIdentity();
          localea.a = a.c;
          localea.a(paramdg, a.c);
          localea.c = localCellIdentityCdma.getSystemId();
          localea.d = localCellIdentityCdma.getNetworkId();
          localea.e = localCellIdentityCdma.getBasestationId();
          localea.g = localCellIdentityCdma.getLatitude();
          localea.h = localCellIdentityCdma.getLongitude();
          n = paramCellInfo.getCellSignalStrength().getDbm();
          m = k;
          if (n > -110)
          {
            m = k;
            if (n < -40) {
              m = n;
            }
          }
          localea.f = m;
          return localea;
        }
      }
      catch (Throwable paramdg)
      {
        paramdg.toString();
        return localea;
      }
      if ((paramCellInfo instanceof CellInfoGsm))
      {
        paramdg = (CellInfoGsm)paramCellInfo;
        localea.a = a.b;
        paramCellInfo = paramdg.getCellIdentity();
        localea.d = paramCellInfo.getLac();
        localea.e = paramCellInfo.getCid();
        localea.b = paramCellInfo.getMcc();
        localea.c = paramCellInfo.getMnc();
        n = paramdg.getCellSignalStrength().getDbm();
        m = k;
        if (n > -110)
        {
          m = k;
          if (n < -40) {
            m = n;
          }
        }
        localea.f = m;
        return localea;
      }
      if ((paramCellInfo instanceof CellInfoWcdma))
      {
        paramdg = (CellInfoWcdma)paramCellInfo;
        localea.a = a.d;
        paramCellInfo = paramdg.getCellIdentity();
        localea.d = paramCellInfo.getLac();
        localea.e = paramCellInfo.getCid();
        localea.b = paramCellInfo.getMcc();
        localea.c = paramCellInfo.getMnc();
        n = paramdg.getCellSignalStrength().getDbm();
        m = k;
        if (n > -110)
        {
          m = k;
          if (n < -40) {
            m = n;
          }
        }
        localea.f = m;
        return localea;
      }
      paramdg = localea;
    } while (!(paramCellInfo instanceof CellInfoLte));
    paramdg = (CellInfoLte)paramCellInfo;
    localea.a = a.e;
    paramCellInfo = paramdg.getCellIdentity();
    localea.d = paramCellInfo.getTac();
    localea.e = paramCellInfo.getCi();
    localea.b = paramCellInfo.getMcc();
    localea.c = paramCellInfo.getMnc();
    k = paramdg.getCellSignalStrength().getDbm();
    if ((k > -110) && (k < -40)) {}
    for (;;)
    {
      localea.f = k;
      return localea;
      k = -88;
    }
  }
  
  @Nullable
  public static ea a(dg paramdg, CellLocation paramCellLocation, SignalStrength paramSignalStrength)
  {
    if ((!paramdg.b()) || (paramCellLocation == null)) {
      return null;
    }
    TelephonyManager localTelephonyManager = paramdg.e;
    paramdg = new ea();
    try
    {
      if (!(paramCellLocation instanceof CdmaCellLocation)) {
        break label128;
      }
      paramCellLocation = (CdmaCellLocation)paramCellLocation;
      paramdg.a = a.c;
      paramdg.a(localTelephonyManager, a.c);
      paramdg.c = paramCellLocation.getSystemId();
      paramdg.d = paramCellLocation.getNetworkId();
      paramdg.e = paramCellLocation.getBaseStationId();
      paramdg.g = paramCellLocation.getBaseStationLatitude();
      paramdg.h = paramCellLocation.getBaseStationLongitude();
      if (paramSignalStrength == null)
      {
        paramdg.f = -1;
        return paramdg;
      }
    }
    catch (Throwable paramCellLocation)
    {
      j.a("TxCellInfo", 6, paramCellLocation.toString());
      return paramdg;
    }
    paramdg.f = paramSignalStrength.getCdmaDbm();
    return paramdg;
    label128:
    paramCellLocation = (GsmCellLocation)paramCellLocation;
    paramdg.a = a.b;
    paramdg.a(localTelephonyManager, a.b);
    paramdg.d = paramCellLocation.getLac();
    paramdg.e = paramCellLocation.getCid();
    if (paramSignalStrength == null)
    {
      paramdg.f = -1;
      return paramdg;
    }
    paramdg.f = (paramSignalStrength.getGsmSignalStrength() * 2 - 113);
    return paramdg;
  }
  
  private void a(TelephonyManager paramTelephonyManager, a parama)
  {
    int i1 = 0;
    int i2 = 0;
    String str = paramTelephonyManager.getNetworkOperator();
    j.a("Cells", 6, "MCCMNC:" + str);
    n = 460;
    k = i2;
    m = n;
    if (str != null)
    {
      k = i2;
      m = n;
      if (str.length() >= 5) {
        m = n;
      }
    }
    for (;;)
    {
      try
      {
        k = Integer.parseInt(str.substring(0, 3));
        m = k;
        n = Integer.parseInt(str.substring(3, 5));
        m = n;
        n = m;
        if (k == 460)
        {
          n = m;
          if (m == 3) {
            n = m;
          }
        }
        j.a("Cells", 6, str + paramTelephonyManager.toString());
      }
      catch (Throwable paramTelephonyManager)
      {
        try
        {
          if (parama != a.c)
          {
            n = m;
            if (str.length() == 11) {
              n = Integer.parseInt(str.substring(9, 11));
            }
          }
          m = k;
          k = n;
          if ((m > 0) && (k >= 0))
          {
            this.b = m;
            this.c = k;
          }
          return;
        }
        catch (Throwable paramTelephonyManager)
        {
          for (;;)
          {
            n = m;
            m = k;
          }
        }
        paramTelephonyManager = paramTelephonyManager;
        n = i1;
      }
      k = n;
    }
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
  
  public final boolean a(long paramLong)
  {
    return System.currentTimeMillis() - this.i < paramLong;
  }
  
  public final String b()
  {
    return this.b + this.c + this.d + this.e;
  }
  
  public final String toString()
  {
    return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
  }
  
  public static enum a
  {
    static
    {
      a locala = a;
      locala = b;
      locala = c;
      locala = d;
      locala = e;
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.ea
 * JD-Core Version:    0.7.0.1
 */