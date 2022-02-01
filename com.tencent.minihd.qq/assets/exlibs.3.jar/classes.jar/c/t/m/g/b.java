package c.t.m.g;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.net.wifi.ScanResult;>;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements TencentLocation
{
  public static final b a = new b();
  private cd b;
  private int c;
  private String d;
  private cc e;
  private final Bundle f = new Bundle();
  private String g = "network";
  private Location h;
  private final long i;
  private long j;
  
  private b()
  {
    this.c = -1;
    this.i = SystemClock.elapsedRealtime();
    this.j = System.currentTimeMillis();
  }
  
  private b(String paramString)
    throws JSONException
  {
    this.i = SystemClock.elapsedRealtime();
    this.j = System.currentTimeMillis();
    paramString = new JSONObject(paramString);
    for (;;)
    {
      try
      {
        this.b = new cd(paramString.getJSONObject("location"));
        this.d = paramString.optString("bearing");
        int k = paramString.optInt("icontrol", -1);
        if (k >= 0) {
          this.f.putInt("icontrol", k);
        }
        JSONObject localJSONObject = paramString.optJSONObject("details");
        if (localJSONObject != null) {}
        paramString = paramString.optJSONObject("addrdesp");
      }
      catch (JSONException paramString)
      {
        try
        {
          this.e = new cc(localJSONObject);
          if ((this.e != null) && (this.e.c != null)) {
            this.f.putAll(this.e.c.k);
          }
          return;
        }
        catch (JSONException paramString)
        {
          cj.a("TxLocation", "details object not found", paramString);
          throw paramString;
        }
        paramString = paramString;
        cj.a("TxLocation", "location object not found", paramString);
        throw paramString;
      }
      if ((paramString != null) && (paramString.has("detail"))) {
        this.e = new cc(paramString.optJSONObject("detail"));
      }
    }
  }
  
  public static b a(b paramb, bw parambw)
  {
    int n;
    int k;
    if ((paramb != null) && (parambw != null) && (paramb.d != null))
    {
      String str = paramb.d;
      int m = 0;
      n = parambw.f;
      k = m;
      if (str != null)
      {
        k = m;
        if (str.split(",").length > 1) {
          k = Integer.parseInt(str.split(",")[1]);
        }
      }
      parambw = paramb.b;
      if (parambw == null) {}
    }
    try
    {
      parambw.d = ((float)a.a(parambw.d, k, n));
      return paramb;
    }
    catch (Exception localException)
    {
      parambw.d = ((float)a.b(parambw.d, k, n));
    }
    return paramb;
  }
  
  public static void a(b paramb)
    throws JSONException
  {
    if (paramb == a) {
      throw new JSONException("location failed");
    }
  }
  
  public final long a()
  {
    return this.i;
  }
  
  public final void a(Location paramLocation)
  {
    if ((paramLocation != null) && (this.b != null))
    {
      double d2 = paramLocation.getLatitude();
      double d1 = paramLocation.getLongitude();
      d2 = Math.round(d2 * 1000000.0D) / 1000000.0D;
      d1 = Math.round(d1 * 1000000.0D) / 1000000.0D;
      this.b.a = d2;
      this.b.b = d1;
      this.b.c = paramLocation.getAltitude();
      this.b.d = paramLocation.getAccuracy();
    }
  }
  
  public final int b()
  {
    String str = this.d;
    if ((str != null) && (str.length() > 0) && (str.split(",").length > 1)) {
      try
      {
        int k = Integer.parseInt(str.split(",")[1]);
        return k;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        cj.a("TxLocation", localNumberFormatException.getMessage(), localNumberFormatException);
      }
    }
    return 0;
  }
  
  public final float getAccuracy()
  {
    if (this.b != null) {
      return this.b.d;
    }
    return 0.0F;
  }
  
  public final String getAddress()
  {
    if (this.c == 5) {
      return this.f.getString("addrdesp.name");
    }
    if (this.b != null) {
      return this.b.f;
    }
    return "";
  }
  
  public final double getAltitude()
  {
    if (this.b != null) {
      return this.b.c;
    }
    return 0.0D;
  }
  
  public final Integer getAreaStat()
  {
    if (this.e != null) {
      return Integer.valueOf(this.e.a);
    }
    return null;
  }
  
  public final float getBearing()
  {
    if (this.h == null) {
      return 0.0F;
    }
    return this.h.getBearing();
  }
  
  public final String getCity()
  {
    if (this.e != null) {
      return this.e.c.e;
    }
    return "";
  }
  
  public final String getCityCode()
  {
    if (this.e != null) {
      return this.e.c.c;
    }
    return "";
  }
  
  public final String getDistrict()
  {
    if (this.e != null) {
      return this.e.c.f;
    }
    return "";
  }
  
  public final Bundle getExtra()
  {
    return this.f;
  }
  
  public final double getLatitude()
  {
    if (this.b != null) {
      return this.b.a;
    }
    return 0.0D;
  }
  
  public final double getLongitude()
  {
    if (this.b != null) {
      return this.b.b;
    }
    return 0.0D;
  }
  
  public final String getName()
  {
    if (this.c == 5) {
      return this.f.getString("addrdesp.name");
    }
    if (this.b != null) {
      return this.b.e;
    }
    return "";
  }
  
  public final String getNation()
  {
    if (this.e != null) {
      return this.e.c.b;
    }
    return "";
  }
  
  public final List<TencentPoi> getPoiList()
  {
    if (this.e != null) {
      return new ArrayList(this.e.b);
    }
    return Collections.emptyList();
  }
  
  public final String getProvider()
  {
    return this.g;
  }
  
  public final String getProvince()
  {
    if (this.e != null) {
      return this.e.c.d;
    }
    return "";
  }
  
  public final float getSpeed()
  {
    if (this.h == null) {
      return 0.0F;
    }
    return this.h.getSpeed();
  }
  
  public final String getStreet()
  {
    if (this.e != null) {
      return this.e.c.i;
    }
    return "";
  }
  
  public final String getStreetNo()
  {
    if (this.e != null) {
      return this.e.c.j;
    }
    return "";
  }
  
  public final long getTime()
  {
    return this.j;
  }
  
  public final String getTown()
  {
    if (this.e != null) {
      return this.e.c.g;
    }
    return "";
  }
  
  public final String getVillage()
  {
    if (this.e != null) {
      return this.e.c.h;
    }
    return "";
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxLocation{");
    localStringBuilder.append("level=").append(this.c).append(",");
    localStringBuilder.append("name=").append(getName()).append(",");
    localStringBuilder.append("address=").append(getAddress()).append(",");
    localStringBuilder.append("provider=").append(getProvider()).append(",");
    localStringBuilder.append("latitude=").append(getLatitude()).append(",");
    localStringBuilder.append("longitude=").append(getLongitude()).append(",");
    localStringBuilder.append("altitude=").append(getAltitude()).append(",");
    localStringBuilder.append("accuracy=").append(getAccuracy()).append(",");
    localStringBuilder.append("cityCode=").append(getCityCode()).append(",");
    localStringBuilder.append("areaStat=").append(getAreaStat()).append(",");
    localStringBuilder.append("nation=").append(getNation()).append(",");
    localStringBuilder.append("province=").append(getProvince()).append(",");
    localStringBuilder.append("city=").append(getCity()).append(",");
    localStringBuilder.append("district=").append(getDistrict()).append(",");
    localStringBuilder.append("street=").append(getStreet()).append(",");
    localStringBuilder.append("streetNo=").append(getStreetNo()).append(",");
    localStringBuilder.append("town=").append(getTown()).append(",");
    localStringBuilder.append("village=").append(getVillage()).append(",");
    localStringBuilder.append("bearing=").append(getBearing()).append(",");
    localStringBuilder.append("time=").append(getTime()).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = getPoiList().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final class a
  {
    private static a c;
    public c a;
    public d b = new d();
    
    public a()
    {
      this.b.a();
      this.a = new c();
      this.a.a();
    }
    
    private static double a(double paramDouble)
    {
      return 3.141592653589793D * paramDouble / 180.0D;
    }
    
    public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      paramDouble1 = a(paramDouble1);
      paramDouble3 = a(paramDouble3);
      paramDouble2 = a(paramDouble2);
      paramDouble4 = a(paramDouble4);
      double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
      return Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6178.1369999999997D * 10000.0D) / 10000.0D * 1000.0D;
    }
    
    private static double a(double paramDouble, int paramInt)
    {
      try
      {
        if (Double.isNaN(paramDouble)) {
          return 0.0D;
        }
        paramDouble = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.HALF_DOWN).doubleValue();
        return paramDouble;
      }
      catch (Exception localException) {}
      return 0.0D;
    }
    
    public static double a(double paramDouble, int paramInt1, int paramInt2)
    {
      return cl.a(paramDouble, paramInt1, paramInt2);
    }
    
    public static int a(String paramString1, String paramString2)
    {
      return cl.a(paramString1, paramString2);
    }
    
    public static int a(byte[] paramArrayOfByte)
    {
      return cl.a(paramArrayOfByte);
    }
    
    public static CellLocation a(TelephonyManager paramTelephonyManager)
    {
      if (paramTelephonyManager != null) {
        try
        {
          paramTelephonyManager = paramTelephonyManager.getCellLocation();
          return paramTelephonyManager;
        }
        catch (Exception paramTelephonyManager)
        {
          Log.e("Cells", "cannot get cell location", paramTelephonyManager);
        }
      }
      return CellLocation.getEmpty();
    }
    
    public static w a()
    {
      return x.a();
    }
    
    public static String a(int paramInt1, int paramInt2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (cj.a) {
        localStringBuilder.append("http://lstest.map.soso.com/loc");
      }
      for (;;)
      {
        localStringBuilder.append("?");
        localStringBuilder.append("c=1");
        localStringBuilder.append("&mars=").append(paramInt1);
        localStringBuilder.append("&obs=").append(paramInt2);
        return localStringBuilder.toString();
        localStringBuilder.append("http://lbs.map.qq.com/loc");
      }
    }
    
    private static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("\"mcc\":");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",\"mnc\":");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",\"lac\":");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",\"cellid\":");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(",\"rss\":");
      localStringBuilder.append(paramInt5);
      if ((paramInt6 != 2147483647) && (paramInt7 != 2147483647))
      {
        localStringBuilder.append(",\"stationLat\":");
        localStringBuilder.append(String.format("%.6f", new Object[] { Float.valueOf(paramInt6 / 14400.0F) }));
        localStringBuilder.append(",\"stationLng\":");
        localStringBuilder.append(String.format("%.6f", new Object[] { Float.valueOf(paramInt7 / 14400.0F) }));
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public static String a(bx parambx)
    {
      if ((parambx == null) || (!parambx.a())) {
        return "{}";
      }
      parambx = parambx.a;
      StringBuilder localStringBuilder = new StringBuilder();
      double d1 = a(parambx.getLatitude(), 6);
      double d2 = a(parambx.getLongitude(), 6);
      double d3 = a(parambx.getAltitude(), 1);
      double d4 = a(parambx.getAccuracy(), 1);
      double d5 = a(parambx.getBearing(), 1);
      double d6 = a(parambx.getSpeed(), 1);
      localStringBuilder.append("{");
      localStringBuilder.append("\"latitude\":");
      localStringBuilder.append(d1);
      localStringBuilder.append(",\"longitude\":");
      localStringBuilder.append(d2);
      localStringBuilder.append(",\"additional\":");
      localStringBuilder.append("\"" + d3 + "," + d4 + "," + d5 + "," + d6 + "," + parambx.getTime() + "\"");
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public static String a(bz parambz)
    {
      if ((parambz == null) || (Collections.unmodifiableList(parambz.a) == null)) {
        return "[]";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      if ((Collections.unmodifiableList(parambz.a) == null) || (Collections.unmodifiableList(parambz.a).size() <= 0))
      {
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
      parambz = Collections.unmodifiableList(parambz.a);
      Iterator localIterator = parambz.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        ScanResult localScanResult = (ScanResult)localIterator.next();
        parambz.size();
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append("{\"mac\":\"").append(localScanResult.BSSID).append("\",");
        localStringBuilder.append("\"rssi\":").append(localScanResult.level).append("}");
        i += 1;
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    
    public static String a(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    public static String a(String paramString1, String paramString2, String paramString3)
    {
      return d(paramString1 + "_" + paramString2 + "_" + paramString3 + "_QQGeoLocation");
    }
    
    public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, List paramList)
      throws l
    {
      paramContext = h.a(paramContext, paramString1, paramString2, paramString3);
      if (paramContext != null) {
        paramContext.a(paramList);
      }
    }
    
    public static void a(TelephonyManager paramTelephonyManager, int[] paramArrayOfInt)
    {
      paramTelephonyManager = paramTelephonyManager.getNetworkOperator();
      if ((paramTelephonyManager != null) && (paramTelephonyManager.length() >= 5)) {}
      try
      {
        paramArrayOfInt[0] = Integer.parseInt(paramTelephonyManager.substring(0, 3));
        paramArrayOfInt[1] = Integer.parseInt(paramTelephonyManager.substring(3, 5));
        return;
      }
      catch (IndexOutOfBoundsException paramTelephonyManager)
      {
        cj.b("Cells", "getMccMnc: Invalid operator numeric data: " + paramTelephonyManager);
        Arrays.fill(paramArrayOfInt, 0);
        return;
      }
      catch (NumberFormatException paramTelephonyManager)
      {
        for (;;)
        {
          cj.b("Cells", "getMccMnc: Operator numeric format error: " + paramTelephonyManager);
        }
      }
    }
    
    public static void a(Closeable paramCloseable)
    {
      if (paramCloseable != null) {}
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable) {}
    }
    
    private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      boolean bool = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCellInfoWithJsonFormat: ");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.append("isGsm=");
      if (paramInt3 == 1) {}
      for (;;)
      {
        paramString.append(bool);
        localStringBuilder.append(", mcc,mnc=").append(paramInt1).append(",").append(paramInt2);
        localStringBuilder.append(", lac,cid=").append(paramInt4).append(",").append(paramInt5);
        cj.a("TencentLocUtils", localStringBuilder.toString());
        return;
        bool = false;
      }
    }
    
    public static void a(boolean paramBoolean)
    {
      ax.a(paramBoolean);
    }
    
    public static boolean a(int paramInt)
    {
      return paramInt == 1;
    }
    
    private static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      boolean bool2 = true;
      boolean bool1;
      if (d(paramInt1)) {
        if ((paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 >= 0) && (paramInt4 <= 65535) && (paramInt5 >= 0) && (paramInt5 <= 65535))
        {
          bool1 = bool2;
          if (paramInt3 == 0)
          {
            bool1 = bool2;
            if (paramInt4 == 0)
            {
              bool1 = bool2;
              if (paramInt5 != 0) {}
            }
          }
        }
        else
        {
          bool1 = false;
        }
      }
      do
      {
        return bool1;
        if ((paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 <= 0) || (paramInt4 >= 65535)) {
          return false;
        }
        if ((paramInt5 == 268435455) || (paramInt5 == 2147483647) || (paramInt5 == 50594049) || (paramInt5 == 65535) || (paramInt5 <= 0)) {
          return false;
        }
        if (paramInt5 == 65535) {
          break;
        }
        bool1 = bool2;
      } while (paramInt5 > 0);
      return false;
    }
    
    public static boolean a(int paramInt, SignalStrength paramSignalStrength1, SignalStrength paramSignalStrength2)
    {
      boolean bool2 = false;
      boolean bool1;
      if ((paramSignalStrength1 == null) || (paramSignalStrength2 == null)) {
        bool1 = true;
      }
      int i;
      label77:
      do
      {
        do
        {
          return bool1;
          if (c(paramInt)) {
            i = paramSignalStrength1.getGsmSignalStrength() - paramSignalStrength2.getGsmSignalStrength();
          }
          for (;;)
          {
            if (!c(paramInt)) {
              break label77;
            }
            bool1 = bool2;
            if (i <= 3) {
              break;
            }
            return true;
            if (d(paramInt)) {
              i = paramSignalStrength1.getCdmaDbm() - paramSignalStrength2.getCdmaDbm();
            } else {
              i = 0;
            }
          }
          bool1 = bool2;
        } while (!d(paramInt));
        bool1 = bool2;
      } while (i <= 6);
      return true;
    }
    
    public static boolean a(Context paramContext)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext != null)
        {
          int i = paramContext.getType();
          if (i == 1) {
            return true;
          }
        }
      }
      catch (Exception paramContext) {}
      return false;
    }
    
    public static boolean a(WifiManager paramWifiManager)
    {
      if (paramWifiManager != null) {
        try
        {
          boolean bool = paramWifiManager.startScan();
          return bool;
        }
        catch (Exception paramWifiManager)
        {
          Log.e("Wifis", "cannot start wifi scan");
        }
      }
      return false;
    }
    
    public static boolean a(CellLocation paramCellLocation1, CellLocation paramCellLocation2)
    {
      if (a(paramCellLocation1, paramCellLocation2)) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while (paramCellLocation1.getClass() != paramCellLocation2.getClass());
            if (!(paramCellLocation1 instanceof GsmCellLocation)) {
              break;
            }
            paramCellLocation1 = (GsmCellLocation)paramCellLocation1;
            paramCellLocation2 = (GsmCellLocation)paramCellLocation2;
          } while (paramCellLocation1.getCid() != paramCellLocation2.getCid());
          return true;
        } while (!(paramCellLocation1 instanceof CdmaCellLocation));
        paramCellLocation1 = (CdmaCellLocation)paramCellLocation1;
        paramCellLocation2 = (CdmaCellLocation)paramCellLocation2;
      } while (paramCellLocation1.getBaseStationId() != paramCellLocation2.getBaseStationId());
      return true;
    }
    
    public static boolean a(bw parambw)
    {
      if (parambw == null) {}
      for (int i = 1; i != 0; i = 0) {
        return false;
      }
      return a(parambw.a, parambw.b, parambw.c, parambw.d, parambw.e);
    }
    
    public static boolean a(Object paramObject)
    {
      return paramObject == null;
    }
    
    public static boolean a(Object paramObject1, Object paramObject2)
    {
      return (paramObject1 == null) || (paramObject2 == null);
    }
    
    public static boolean a(Object paramObject, Object... paramVarArgs)
    {
      if ((paramVarArgs == null) && (paramObject == null)) {}
      for (int i = 1; i == 0; i = 0) {
        return false;
      }
      int j = paramVarArgs.length;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label44;
        }
        if (paramVarArgs[i] != null) {
          break;
        }
        i += 1;
      }
      label44:
      return true;
    }
    
    public static boolean a(List<ScanResult> paramList1, List<ScanResult> paramList2)
    {
      if (cj.a)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("differsSignificantly: current is ").append(paramList1.size()).append("|");
        Iterator localIterator = paramList1.iterator();
        ScanResult localScanResult;
        while (localIterator.hasNext())
        {
          localScanResult = (ScanResult)localIterator.next();
          localStringBuilder.append(localScanResult.BSSID).append(",").append(localScanResult.level).append(";");
        }
        cj.a("TxWifiChange", localStringBuilder.toString());
        localStringBuilder.setLength(0);
        localStringBuilder.append("differsSignificantly: last is ").append(paramList2.size()).append("|");
        localIterator = paramList2.iterator();
        while (localIterator.hasNext())
        {
          localScanResult = (ScanResult)localIterator.next();
          localStringBuilder.append(localScanResult.BSSID).append(",").append(localScanResult.level).append(";");
        }
        cj.a("TxWifiChange", localStringBuilder.toString());
      }
      return !b(paramList1, paramList2);
    }
    
    /* Error */
    public static byte[] a(java.io.File paramFile)
      throws IOException
    {
      // Byte code:
      //   0: new 508	java/io/ByteArrayOutputStream
      //   3: dup
      //   4: invokespecial 509	java/io/ByteArrayOutputStream:<init>	()V
      //   7: astore_3
      //   8: sipush 8192
      //   11: newarray byte
      //   13: astore 4
      //   15: new 511	java/io/BufferedInputStream
      //   18: dup
      //   19: new 513	java/io/FileInputStream
      //   22: dup
      //   23: aload_0
      //   24: invokespecial 516	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   27: invokespecial 519	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   30: astore_2
      //   31: aload_2
      //   32: astore_0
      //   33: aload_2
      //   34: aload 4
      //   36: invokevirtual 522	java/io/BufferedInputStream:read	([B)I
      //   39: istore_1
      //   40: iload_1
      //   41: iconst_m1
      //   42: if_icmpeq +34 -> 76
      //   45: aload_2
      //   46: astore_0
      //   47: aload_3
      //   48: aload 4
      //   50: iconst_0
      //   51: iload_1
      //   52: invokevirtual 526	java/io/ByteArrayOutputStream:write	([BII)V
      //   55: goto -24 -> 31
      //   58: astore_3
      //   59: aload_2
      //   60: astore_0
      //   61: aload_3
      //   62: astore_2
      //   63: aload_2
      //   64: athrow
      //   65: astore_3
      //   66: aload_0
      //   67: astore_2
      //   68: aload_3
      //   69: astore_0
      //   70: aload_2
      //   71: invokestatic 528	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
      //   74: aload_0
      //   75: athrow
      //   76: aload_2
      //   77: astore_0
      //   78: aload_3
      //   79: invokevirtual 532	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   82: astore_3
      //   83: aload_2
      //   84: invokestatic 528	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
      //   87: aload_3
      //   88: areturn
      //   89: astore_0
      //   90: aconst_null
      //   91: astore_2
      //   92: goto -22 -> 70
      //   95: astore_2
      //   96: aconst_null
      //   97: astore_0
      //   98: goto -35 -> 63
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	paramFile	java.io.File
      //   39	13	1	i	int
      //   30	62	2	localObject1	Object
      //   95	1	2	localIOException1	IOException
      //   7	41	3	localByteArrayOutputStream	ByteArrayOutputStream
      //   58	4	3	localIOException2	IOException
      //   65	14	3	localObject2	Object
      //   82	6	3	arrayOfByte1	byte[]
      //   13	36	4	arrayOfByte2	byte[]
      // Exception table:
      //   from	to	target	type
      //   33	40	58	java/io/IOException
      //   47	55	58	java/io/IOException
      //   78	83	58	java/io/IOException
      //   33	40	65	finally
      //   47	55	65	finally
      //   63	65	65	finally
      //   78	83	65	finally
      //   15	31	89	finally
      //   15	31	95	java/io/IOException
    }
    
    public static double b(double paramDouble, int paramInt1, int paramInt2)
    {
      if (paramInt1 >= 6) {
        return 40.0D;
      }
      if (paramInt1 == 5) {
        return 60.0D;
      }
      if (paramInt1 == 4) {
        return 70.0D;
      }
      if (paramInt1 == 3) {
        return 90.0D;
      }
      if (paramInt1 == 2) {
        return 110.0D;
      }
      if ((paramInt2 >= -72) && (paramInt1 == 0)) {
        return (int)(0.45D * paramDouble / 10.0D) * 10;
      }
      if (paramDouble <= 100.0D) {
        paramInt1 = (int)((paramDouble - 1.0D) / 10.0D + 1.0D) * 10;
      }
      for (;;)
      {
        return paramInt1;
        if ((paramDouble > 100.0D) && (paramDouble <= 800.0D)) {
          paramInt1 = (int)(0.85D * paramDouble / 10.0D) * 10;
        } else {
          paramInt1 = (int)(0.8D * paramDouble / 10.0D) * 10;
        }
      }
    }
    
    public static int b(String paramString)
    {
      return cl.a(paramString);
    }
    
    public static a b()
    {
      try
      {
        if (c == null) {
          c = new a();
        }
        a locala = c;
        return locala;
      }
      finally {}
    }
    
    public static String b(bw parambw)
    {
      if (parambw == null) {
        return "[]";
      }
      int i = parambw.b;
      int j = parambw.c;
      int k = parambw.a;
      Object localObject1 = new ArrayList();
      Object localObject2 = parambw.a();
      if (a(k, i, j, parambw.d, parambw.e)) {
        ((ArrayList)localObject1).add(a(i, j, parambw.d, parambw.e, parambw.f, parambw.g, parambw.h));
      }
      for (;;)
      {
        int m;
        int n;
        try
        {
          parambw = ((List)localObject2).iterator();
          if (parambw.hasNext())
          {
            localObject2 = (NeighboringCellInfo)parambw.next();
            m = ((NeighboringCellInfo)localObject2).getLac();
            n = ((NeighboringCellInfo)localObject2).getCid();
            if (!a(k, i, j, m, n)) {
              break label260;
            }
            ((ArrayList)localObject1).add(a(i, j, m, n, (((NeighboringCellInfo)localObject2).getRssi() << 1) - 113, 2147483647, 2147483647));
            continue;
          }
          a("illeagal main cell! ", i, j, k, parambw.d, parambw.e);
        }
        catch (Exception parambw)
        {
          parambw = new StringBuilder("[");
          localObject2 = new ci(",");
          localObject1 = ((Iterable)localObject1).iterator();
          parambw.append(((ci)localObject2).a(new StringBuilder(), (Iterator)localObject1).toString());
          parambw.append("]");
          return parambw.toString();
        }
        continue;
        label260:
        a("illeagal neighboringCell! ", i, j, k, m, n);
      }
    }
    
    public static List<ScanResult> b(WifiManager paramWifiManager)
    {
      if (paramWifiManager != null) {
        try
        {
          paramWifiManager = paramWifiManager.getScanResults();
          return paramWifiManager;
        }
        catch (Exception paramWifiManager)
        {
          Log.e("Wifis", "cannot getScanResults");
        }
      }
      return Collections.emptyList();
    }
    
    public static List<NeighboringCellInfo> b(TelephonyManager paramTelephonyManager)
    {
      if (paramTelephonyManager != null) {
        try
        {
          paramTelephonyManager = paramTelephonyManager.getNeighboringCellInfo();
          return paramTelephonyManager;
        }
        catch (Exception paramTelephonyManager)
        {
          Log.e("Cells", "cannot get NeighboringCellInfo", paramTelephonyManager);
        }
      }
      return Collections.emptyList();
    }
    
    public static boolean b(int paramInt)
    {
      return paramInt == 0;
    }
    
    public static boolean b(Context paramContext)
    {
      int i = 1;
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {}
      while (i != 0)
      {
        return false;
        i = 0;
      }
      for (;;)
      {
        try
        {
          paramContext = ((ConnectivityManager)localObject).getNetworkInfo(0);
          localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
          if (localObject != null)
          {
            boolean bool2 = ((NetworkInfo)localObject).isConnected();
            bool1 = bool2;
            if (!bool2)
            {
              bool1 = bool2;
              if (paramContext != null) {
                bool1 = paramContext.isConnected();
              }
            }
            return bool1;
          }
        }
        catch (Exception paramContext)
        {
          return false;
        }
        boolean bool1 = false;
      }
    }
    
    public static boolean b(Object paramObject)
    {
      return paramObject != null;
    }
    
    private static boolean b(List<ScanResult> paramList1, List<ScanResult> paramList2)
    {
      if ((paramList1 == null) || (paramList2 == null)) {}
      int j;
      do
      {
        return false;
        i = paramList1.size();
        j = paramList2.size();
        if ((i == 0) && (j == 0)) {
          return true;
        }
      } while ((i == 0) || (j == 0));
      int k = i + j;
      if (a(paramList1, paramList2)) {}
      for (int i = 0;; i = 0)
      {
        cj.a("TxWifiChange", "isSimilar: k=" + i + ",f=" + k);
        if (i << 1 < k * 0.5D) {
          break;
        }
        return true;
        if ((paramList1.size() != 0) && (paramList2.size() != 0)) {
          break label131;
        }
      }
      label131:
      if (paramList1.size() > paramList2.size()) {}
      for (;;)
      {
        paramList2 = paramList2.iterator();
        label154:
        j = 0;
        for (;;)
        {
          i = j;
          if (!paramList2.hasNext()) {
            break;
          }
          localObject = (ScanResult)paramList2.next();
          Iterator localIterator = paramList1.iterator();
          if (localIterator.hasNext())
          {
            if (!((ScanResult)localIterator.next()).BSSID.equals(((ScanResult)localObject).BSSID)) {
              break label154;
            }
            j += 1;
          }
        }
        Object localObject = paramList1;
        paramList1 = paramList2;
        paramList2 = (List<ScanResult>)localObject;
      }
    }
    
    public static byte[] b(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        return null;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
      try
      {
        localDeflaterOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        localDeflaterOutputStream.finish();
        localDeflaterOutputStream.flush();
        localDeflaterOutputStream.close();
        return localByteArrayOutputStream.toByteArray();
      }
      catch (Exception paramArrayOfByte) {}
      return null;
    }
    
    private static boolean c(int paramInt)
    {
      return paramInt == 1;
    }
    
    public static boolean c(String paramString)
    {
      do
      {
        JSONObject localJSONObject;
        do
        {
          try
          {
            localJSONObject = new JSONObject(paramString);
            if (paramString.contains("latitude")) {
              return true;
            }
          }
          catch (JSONException paramString)
          {
            return false;
          }
          paramString = localJSONObject.optJSONArray("cells");
        } while ((paramString != null) && (paramString.length() > 0));
        paramString = localJSONObject.optJSONArray("wifis");
      } while ((paramString != null) && (paramString.length() > 0));
      return false;
    }
    
    @Nullable
    public static byte[] c(byte[] paramArrayOfByte)
    {
      int i = 0;
      if (paramArrayOfByte == null) {
        return null;
      }
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      InflaterInputStream localInflaterInputStream = new InflaterInputStream(localByteArrayInputStream);
      paramArrayOfByte = new byte[0];
      byte[] arrayOfByte2 = new byte[1024];
      for (;;)
      {
        try
        {
          int j = localInflaterInputStream.read(arrayOfByte2);
          if (j > 0)
          {
            i += j;
            byte[] arrayOfByte1 = new byte[i];
            System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramArrayOfByte.length, j);
            paramArrayOfByte = arrayOfByte1;
            if (j <= 0) {
              try
              {
                localByteArrayInputStream.close();
                localInflaterInputStream.close();
                return paramArrayOfByte;
              }
              catch (IOException paramArrayOfByte)
              {
                return null;
              }
            }
          }
        }
        catch (Exception paramArrayOfByte)
        {
          return null;
        }
      }
    }
    
    public static String d(String paramString)
    {
      try
      {
        Object localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        localObject = ((MessageDigest)localObject).digest();
        StringBuilder localStringBuilder = new StringBuilder();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder.append(Integer.toHexString(localObject[i] & 0xFF)).append("");
          i += 1;
        }
        localObject = localStringBuilder.toString();
        return localObject;
      }
      catch (Exception localException) {}
      return paramString;
    }
    
    private static boolean d(int paramInt)
    {
      return paramInt == 2;
    }
  }
  
  public static final class b
  {
    public String a;
    public b b;
    public int c;
    public String d = "network";
    public Location e;
    
    public final b a()
    {
      if (this.a != null) {}
      for (;;)
      {
        try
        {
          b localb1 = new b(this.a, (byte)0);
          b.a(b.a(b.a(localb1, this.c), this.d), this.e);
          return localb1;
        }
        catch (JSONException localJSONException)
        {
          cj.b("TxLocation", Log.getStackTraceString(localJSONException));
          return b.a;
        }
        b localb2 = b.b(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.b
 * JD-Core Version:    0.7.0.1
 */