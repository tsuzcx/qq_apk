package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import c.t.m.g.j;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.io.File;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class TencentExtraKeys
{
  public static final boolean ALLOW_NLP_LOCATION = true;
  public static final TencentLog DEFAULT_TENCENT_LOG = new TencentLog()
  {
    public final String getDirString()
    {
      return null;
    }
    
    public final void println(String paramAnonymousString1, int paramAnonymousInt, @NonNull String paramAnonymousString2)
    {
      if (paramAnonymousInt == 4) {}
    }
  };
  public static final boolean DIDI_INTERNAL = false;
  public static final String LOCATION_KEY_ADMIN_LEVEL1 = "admin_level_1";
  public static final String LOCATION_KEY_ADMIN_LEVEL2 = "admin_level_2";
  public static final String LOCATION_KEY_ADMIN_LEVEL3 = "admin_level_3";
  public static final String LOCATION_KEY_LOCALITY = "locality";
  public static final String LOCATION_KEY_NATION = "nation";
  public static final String LOCATION_KEY_ROUTE = "route";
  public static final String LOCATION_KEY_SUBLOCALITY = "sublocality";
  public static final String LOCATION_SOURCE_CELL = "cell";
  public static final String LOCATION_SOURCE_GPS = "gps";
  public static final String LOCATION_SOURCE_WIFI = "wifi";
  public static boolean MOCK_LOCATION_FILTER = true;
  public static final String RAW_DATA = "raw_data";
  public static final String REQUEST_RAW_DATA = "request_raw_data";
  public static final boolean STRICT_CELL_FILTER = true;
  public static final boolean TENCENT_INTERNAL = true;
  private static File sLogDir;
  private static TencentLog sTencentLog;
  
  public static void enableMockLocationFilter(boolean paramBoolean)
  {
    MOCK_LOCATION_FILTER = paramBoolean;
  }
  
  public static String getLocationSource(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return "";
    }
    boolean bool1 = TencentLocationUtils.isFromGps(paramTencentLocation);
    boolean bool2 = TencentLocationUtils.isFromNetwork(paramTencentLocation);
    int i = paramTencentLocation.getExtra().getInt("wifi_ap_num");
    if (bool1) {
      return "gps";
    }
    if ((bool2) && (i >= 3)) {
      return "wifi";
    }
    return "cell";
  }
  
  public static File getLogDir()
  {
    try
    {
      File localFile = sLogDir;
      return localFile;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static byte[] getRawData(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return null;
    }
    return paramTencentLocation.getExtra().getByteArray("raw_data");
  }
  
  public static Location getRawGps(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return null;
    }
    return (Location)paramTencentLocation.getExtra().getParcelable("raw_gps");
  }
  
  public static String getRawQuery(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return null;
    }
    return paramTencentLocation.getExtra().getString("raw_query");
  }
  
  @Nullable
  public static TencentLog getTencentLog()
  {
    try
    {
      TencentLog localTencentLog = sTencentLog;
      return localTencentLog;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isAllowedLevel(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      if (paramInt != 7) {
        break;
      }
    case 0: 
    case 1: 
    case 3: 
    case 4: 
      return true;
    }
    return false;
  }
  
  /* Error */
  @java.lang.Deprecated
  public static boolean isDebugEnabled()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 130	com/tencent/map/geolocation/internal/TencentExtraKeys:sTencentLog	Lcom/tencent/map/geolocation/internal/TencentLog;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localTencentLog	TencentLog
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public static int isInsIllegalApp(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return j.f(paramContext);
  }
  
  public static boolean isRequestRawData(TencentLocationRequest paramTencentLocationRequest)
  {
    if (paramTencentLocationRequest == null) {
      return false;
    }
    return paramTencentLocationRequest.getExtras().getBoolean("request_raw_data");
  }
  
  public static void loadLibrary(String paramString)
  {
    System.load(paramString);
  }
  
  public static void setLogDir(File paramFile)
  {
    try
    {
      sLogDir = paramFile;
      return;
    }
    finally
    {
      paramFile = finally;
      throw paramFile;
    }
  }
  
  public static TencentLocation setRawData(TencentLocation paramTencentLocation, byte[] paramArrayOfByte)
  {
    paramTencentLocation.getExtra().putByteArray("raw_data", paramArrayOfByte);
    return paramTencentLocation;
  }
  
  public static void setRawGps(TencentLocation paramTencentLocation, Location paramLocation)
  {
    if (paramTencentLocation == null) {
      return;
    }
    try
    {
      paramTencentLocation.getExtra().putParcelable("raw_gps", paramLocation);
      return;
    }
    catch (Exception paramTencentLocation) {}
  }
  
  public static void setRawQuery(TencentLocation paramTencentLocation, String paramString)
  {
    if (paramTencentLocation == null) {
      return;
    }
    paramTencentLocation.getExtra().putString("raw_query", paramString);
  }
  
  public static TencentLocationRequest setRequestRawData(TencentLocationRequest paramTencentLocationRequest, boolean paramBoolean)
  {
    if (paramTencentLocationRequest != null) {
      paramTencentLocationRequest.getExtras().putBoolean("request_raw_data", paramBoolean);
    }
    return paramTencentLocationRequest;
  }
  
  /* Error */
  public static void setTencentLog(TencentLog paramTencentLog)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: putstatic 130	com/tencent/map/geolocation/internal/TencentExtraKeys:sTencentLog	Lcom/tencent/map/geolocation/internal/TencentLog;
    //   9: aload_0
    //   10: ifnonnull +17 -> 27
    //   13: aload_1
    //   14: astore_0
    //   15: aload_0
    //   16: invokestatic 198	c/t/m/g/da:a	(Lc/t/m/g/cr;)V
    //   19: aload_0
    //   20: invokestatic 201	c/t/m/g/cq:a	(Lc/t/m/g/cr;)V
    //   23: ldc 2
    //   25: monitorexit
    //   26: return
    //   27: new 8	com/tencent/map/geolocation/internal/TencentExtraKeys$LogCallback
    //   30: dup
    //   31: aconst_null
    //   32: invokespecial 204	com/tencent/map/geolocation/internal/TencentExtraKeys$LogCallback:<init>	(Lcom/tencent/map/geolocation/internal/TencentExtraKeys$1;)V
    //   35: astore_0
    //   36: goto -21 -> 15
    //   39: astore_0
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	paramTencentLog	TencentLog
    //   1	13	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	9	39	finally
    //   15	23	39	finally
    //   27	36	39	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentExtraKeys
 * JD-Core Version:    0.7.0.1
 */