package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandGlobalSystemConfig> CREATOR;
  private static volatile AppBrandGlobalSystemConfig hhy;
  public static final AppBrandGlobalSystemConfig hhz;
  public int hhA;
  public int hhB;
  public int hhC;
  public int hhD;
  public int hhE;
  public int hhF;
  public int hhG;
  public String hhH;
  public HttpSetting hhI;
  public int[] hhJ;
  public int hhK;
  public int hhL;
  public int hhM;
  public int hhN;
  public int hhO;
  public int hhP;
  public int hhQ;
  public int hhR;
  public int hhS;
  public int hhT;
  public String[] hhU;
  public double hhV;
  public int hhW;
  public AppBrandGlobalSystemConfig.WeAppSyncVersionSetting hhX;
  public AppBrandGlobalSystemConfig.PackageManager hhY;
  public long hhZ;
  public String[] hia;
  public int hib;
  public int hic;
  
  static
  {
    AppMethodBeat.i(101812);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
    hhz = localAppBrandGlobalSystemConfig;
    localAppBrandGlobalSystemConfig.hhB = 5;
    hhz.hhC = 300;
    hhz.hhD = 10;
    hhz.hhE = 1048576;
    hhz.hhF = 1048576;
    hhz.hhG = 20971520;
    hhz.hhJ = AppBrandGlobalSystemConfig.a.hid;
    hhz.hhK = 50;
    hhz.hhL = 11;
    hhz.hhM = 12;
    hhz.hhN = 1800;
    hhz.hhO = 307200;
    hhz.hhP = 25;
    hhz.hhQ = 10485760;
    hhz.hhR = 314572800;
    hhz.hhS = 1;
    hhz.hhT = 50;
    hhz.hhU = AppBrandGlobalSystemConfig.a.hie;
    hhz.hhV = 0.0D;
    hhz.hhW = 60;
    hhz.hhX = new AppBrandGlobalSystemConfig.WeAppSyncVersionSetting();
    hhz.hhY = new AppBrandGlobalSystemConfig.PackageManager();
    hhz.hhZ = 30L;
    hhz.hia = AppBrandGlobalSystemConfig.a.hif;
    hhz.hib = 10;
    hhz.hic = 86400;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(101812);
  }
  
  private AppBrandGlobalSystemConfig()
  {
    AppMethodBeat.i(101809);
    this.hhA = 2147483647;
    this.hhI = new HttpSetting();
    AppMethodBeat.o(101809);
  }
  
  protected AppBrandGlobalSystemConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(101811);
    this.hhA = 2147483647;
    this.hhI = new HttpSetting();
    this.hhA = paramParcel.readInt();
    this.hhB = paramParcel.readInt();
    this.hhC = paramParcel.readInt();
    this.hhD = paramParcel.readInt();
    this.hhE = paramParcel.readInt();
    this.hhF = paramParcel.readInt();
    this.hhG = paramParcel.readInt();
    this.hhH = paramParcel.readString();
    this.hhI = ((HttpSetting)paramParcel.readParcelable(HttpSetting.class.getClassLoader()));
    this.hhJ = paramParcel.createIntArray();
    this.hhK = paramParcel.readInt();
    this.hhL = paramParcel.readInt();
    this.hhN = paramParcel.readInt();
    this.hhO = paramParcel.readInt();
    this.hhP = paramParcel.readInt();
    this.hhQ = paramParcel.readInt();
    this.hhR = paramParcel.readInt();
    this.hhS = paramParcel.readInt();
    this.hhT = paramParcel.readInt();
    this.hhU = paramParcel.createStringArray();
    this.hhV = paramParcel.readDouble();
    this.hhW = paramParcel.readInt();
    this.hhX = ((AppBrandGlobalSystemConfig.WeAppSyncVersionSetting)paramParcel.readParcelable(AppBrandGlobalSystemConfig.WeAppSyncVersionSetting.class.getClassLoader()));
    this.hhY = ((AppBrandGlobalSystemConfig.PackageManager)paramParcel.readParcelable(AppBrandGlobalSystemConfig.PackageManager.class.getClassLoader()));
    this.hhZ = paramParcel.readLong();
    this.hia = paramParcel.createStringArray();
    this.hib = paramParcel.readInt();
    this.hic = paramParcel.readInt();
    AppMethodBeat.o(101811);
  }
  
  static void ayq()
  {
    try
    {
      hhy = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String ayr()
  {
    AppMethodBeat.i(101805);
    Object localObject = new File(e.eQw.replace("/data/user/0", "/data/data"), "wxaapp/res/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new File((File)localObject, "AppService.conf").getAbsolutePath();
    AppMethodBeat.o(101805);
    return localObject;
  }
  
  /* Error */
  private static AppBrandGlobalSystemConfig ays()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 252
    //   5: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 206	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:hhy	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   11: astore_0
    //   12: aload_0
    //   13: ifnonnull +79 -> 92
    //   16: invokestatic 254	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ayr	()Ljava/lang/String;
    //   19: invokestatic 260	com/tencent/mm/a/e:cS	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_0
    //   23: aload_0
    //   24: invokestatic 266	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   27: ifeq +58 -> 85
    //   30: ldc 252
    //   32: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aconst_null
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_0
    //   43: ldc_w 268
    //   46: invokestatic 274	com/tencent/luggage/a/e:q	(Ljava/lang/Class;)Lcom/tencent/luggage/a/b;
    //   49: checkcast 268	com/tencent/luggage/sdk/customize/b
    //   52: invokeinterface 277 1 0
    //   57: aconst_null
    //   58: astore_0
    //   59: goto -36 -> 23
    //   62: astore_0
    //   63: ldc_w 279
    //   66: ldc_w 281
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_0
    //   76: aastore
    //   77: invokestatic 287	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aconst_null
    //   81: astore_0
    //   82: goto -59 -> 23
    //   85: aload_0
    //   86: invokestatic 291	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:zZ	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   89: putstatic 206	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:hhy	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   92: getstatic 206	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:hhy	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   95: astore_0
    //   96: ldc 252
    //   98: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: goto -64 -> 37
    //   104: astore_0
    //   105: ldc 2
    //   107: monitorexit
    //   108: aload_0
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	30	0	localObject1	Object
    //   42	1	0	localFileNotFoundException	java.io.FileNotFoundException
    //   58	1	0	localObject2	Object
    //   62	14	0	localIOException	java.io.IOException
    //   81	15	0	localObject3	Object
    //   104	5	0	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   16	23	42	java/io/FileNotFoundException
    //   16	23	62	java/io/IOException
    //   3	12	104	finally
    //   16	23	104	finally
    //   23	35	104	finally
    //   43	57	104	finally
    //   63	80	104	finally
    //   85	92	104	finally
    //   92	101	104	finally
  }
  
  public static AppBrandGlobalSystemConfig ayt()
  {
    AppMethodBeat.i(101807);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = ays();
    if (localAppBrandGlobalSystemConfig == null)
    {
      localAppBrandGlobalSystemConfig = hhz;
      AppMethodBeat.o(101807);
      return localAppBrandGlobalSystemConfig;
    }
    AppMethodBeat.o(101807);
    return localAppBrandGlobalSystemConfig;
  }
  
  private static AppBrandGlobalSystemConfig zZ(String paramString)
  {
    AppMethodBeat.i(101808);
    ab.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[] { paramString });
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig;
    Object localObject2;
    int i;
    try
    {
      paramString = new JSONObject(paramString);
      localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
      localObject1 = paramString.optJSONObject("HTTPSetting");
      if (localObject1 == null) {
        break label334;
      }
      localObject2 = ((JSONObject)localObject1).optString("HTTPHeaderMode", "");
      if (((String)localObject2).equals("BlackList")) {
        localAppBrandGlobalSystemConfig.hhI.mode = 1;
      }
      for (;;)
      {
        localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderBlackList");
        if (localObject2 == null) {
          break;
        }
        localAppBrandGlobalSystemConfig.hhI.hig = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localAppBrandGlobalSystemConfig.hhI.hig.add(((JSONArray)localObject2).getString(i));
          i += 1;
        }
        if (((String)localObject2).equals("WhiteList")) {
          localAppBrandGlobalSystemConfig.hhI.mode = 2;
        }
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderWhiteList");
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(101808);
      return null;
    }
    if (localObject2 != null)
    {
      localAppBrandGlobalSystemConfig.hhI.hih = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        localAppBrandGlobalSystemConfig.hhI.hih.add(((JSONArray)localObject2).getString(i));
        i += 1;
      }
    }
    localAppBrandGlobalSystemConfig.hhI.hii = ((JSONObject)localObject1).optInt("WebsocketMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.hhI.hij = ((JSONObject)localObject1).optInt("UploadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.hhI.hik = ((JSONObject)localObject1).optInt("DownloadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.hhI.hil = ((JSONObject)localObject1).optInt("RequestMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.hhI.him = ((JSONObject)localObject1).optString("HTTPHeaderReferer");
    label334:
    localAppBrandGlobalSystemConfig.hhX = new AppBrandGlobalSystemConfig.WeAppSyncVersionSetting();
    Object localObject1 = paramString.optJSONObject("SyncVersionSetting");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.hhX.hir = ((JSONObject)localObject1).optLong("PullVersionInterval", localAppBrandGlobalSystemConfig.hhX.hir);
      localAppBrandGlobalSystemConfig.hhX.hit = ((JSONObject)localObject1).optLong("PullVersionWxaUsageLastInterval", localAppBrandGlobalSystemConfig.hhX.hit);
      localAppBrandGlobalSystemConfig.hhX.hiu = ((JSONObject)localObject1).optInt("PullVersionMaxCount", localAppBrandGlobalSystemConfig.hhX.hiu);
      localAppBrandGlobalSystemConfig.hhX.hiv = ((JSONObject)localObject1).optInt("PullVersionMaxCountPerRequest", localAppBrandGlobalSystemConfig.hhX.hiv);
    }
    localAppBrandGlobalSystemConfig.hhY = new AppBrandGlobalSystemConfig.PackageManager();
    localObject1 = paramString.optJSONObject("PackageManager");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.hhY.hin = ((JSONObject)localObject1).optLong("CheckInterval", localAppBrandGlobalSystemConfig.hhY.hin);
      localAppBrandGlobalSystemConfig.hhY.hio = ((JSONObject)localObject1).optLong("WithoutContactClearSeconds", localAppBrandGlobalSystemConfig.hhY.hio);
      localAppBrandGlobalSystemConfig.hhY.hip = ((JSONObject)localObject1).optLong("ClientStorageMinMB", localAppBrandGlobalSystemConfig.hhY.hip);
      localAppBrandGlobalSystemConfig.hhY.hiq = ((JSONObject)localObject1).optInt("WholeClientStoragePercent", localAppBrandGlobalSystemConfig.hhY.hiq);
    }
    localAppBrandGlobalSystemConfig.hhH = paramString.optString("CDNBaseURL");
    localAppBrandGlobalSystemConfig.hhB = paramString.optInt("AppMaxRunningCount", 5);
    localAppBrandGlobalSystemConfig.hhC = paramString.optInt("TempFileSizeLimitTotal", 300);
    localAppBrandGlobalSystemConfig.hhD = paramString.optInt("DownloadFileSizeLimit", 10);
    localAppBrandGlobalSystemConfig.hhE = paramString.optInt("MaxLocalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.hhF = paramString.optInt("MaxGlobalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.hhG = paramString.optInt("MaxGlobalStorageSize", 20971520);
    localAppBrandGlobalSystemConfig.hhQ = paramString.optInt("NativeBufferSizeLimitByte", 10485760);
    localAppBrandGlobalSystemConfig.hhR = paramString.optInt("NativeBufferQueueLimitByte", 314572800);
    localAppBrandGlobalSystemConfig.hic = paramString.optInt("WeUseRecallInterval", 86400);
    localObject1 = paramString.optJSONArray("SyncLaunchSceneList");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.hhJ = new int[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.hhJ[i] = ((JSONArray)localObject1).optInt(i, 0);
        i += 1;
      }
    }
    if (localAppBrandGlobalSystemConfig.hhJ == null) {
      localAppBrandGlobalSystemConfig.hhJ = AppBrandGlobalSystemConfig.a.hid;
    }
    localAppBrandGlobalSystemConfig.hhK = paramString.optInt("StarNumberLimitation", 50);
    localAppBrandGlobalSystemConfig.hhL = paramString.optInt("TaskBarItemCountLimitation", 11);
    localAppBrandGlobalSystemConfig.hhM = paramString.optInt("NewTaskBarRecentsItemCountLimitation", 12);
    localAppBrandGlobalSystemConfig.hhN = paramString.optInt("WidgetImageFlowLimitDuration", 1800);
    localAppBrandGlobalSystemConfig.hhO = paramString.optInt("WidgetImageFlowLimitMaxSize", 307200);
    localAppBrandGlobalSystemConfig.hhP = paramString.optInt("WidgetDrawMinInterval", 25);
    localAppBrandGlobalSystemConfig.hhS = paramString.optInt("GameMaxRunningCount", 1);
    localAppBrandGlobalSystemConfig.hhT = paramString.optInt("GameDownloadFileSizeLimit", 50);
    localObject1 = paramString.optJSONArray("SubContextImgDomain");
    if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
    {
      localAppBrandGlobalSystemConfig.hhU = AppBrandGlobalSystemConfig.a.hie;
      localAppBrandGlobalSystemConfig.hhV = paramString.optDouble("GamePerfCollectSamplePercentage", 0.0D);
      localAppBrandGlobalSystemConfig.hhW = paramString.optInt("GamePerfCollectInterval", 60);
      localAppBrandGlobalSystemConfig.hhZ = paramString.optLong("OpendataMaxFileStorageSize", 30L);
      localObject1 = paramString.optJSONArray("PreDownloadUserNameBlackList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        break label997;
      }
      localAppBrandGlobalSystemConfig.hia = AppBrandGlobalSystemConfig.a.hif;
    }
    for (;;)
    {
      localAppBrandGlobalSystemConfig.hib = paramString.optInt("WXDataMaxRequestConcurrent", 10);
      AppMethodBeat.o(101808);
      return localAppBrandGlobalSystemConfig;
      localAppBrandGlobalSystemConfig.hhU = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.hhU[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
      break;
      label997:
      localAppBrandGlobalSystemConfig.hia = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.hia[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101810);
    paramParcel.writeInt(this.hhA);
    paramParcel.writeInt(this.hhB);
    paramParcel.writeInt(this.hhC);
    paramParcel.writeInt(this.hhD);
    paramParcel.writeInt(this.hhE);
    paramParcel.writeInt(this.hhF);
    paramParcel.writeInt(this.hhG);
    paramParcel.writeString(this.hhH);
    paramParcel.writeParcelable(this.hhI, paramInt);
    paramParcel.writeIntArray(this.hhJ);
    paramParcel.writeInt(this.hhK);
    paramParcel.writeInt(this.hhL);
    paramParcel.writeInt(this.hhN);
    paramParcel.writeInt(this.hhO);
    paramParcel.writeInt(this.hhP);
    paramParcel.writeInt(this.hhQ);
    paramParcel.writeInt(this.hhR);
    paramParcel.writeInt(this.hhS);
    paramParcel.writeInt(this.hhT);
    paramParcel.writeStringArray(this.hhU);
    paramParcel.writeDouble(this.hhV);
    paramParcel.writeInt(this.hhW);
    paramParcel.writeParcelable(this.hhX, paramInt);
    paramParcel.writeParcelable(this.hhY, paramInt);
    paramParcel.writeLong(this.hhZ);
    paramParcel.writeStringArray(this.hia);
    paramParcel.writeInt(this.hib);
    paramParcel.writeInt(this.hic);
    AppMethodBeat.o(101810);
  }
  
  public static final class HttpSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<HttpSetting> CREATOR;
    public ArrayList<String> hig;
    public ArrayList<String> hih;
    public int hii;
    public int hij;
    public int hik;
    public int hil;
    public String him;
    public int mode;
    
    static
    {
      AppMethodBeat.i(101796);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(101796);
    }
    
    public HttpSetting()
    {
      this.mode = 0;
    }
    
    HttpSetting(Parcel paramParcel)
    {
      AppMethodBeat.i(101795);
      this.mode = 0;
      this.mode = paramParcel.readInt();
      this.hig = paramParcel.createStringArrayList();
      this.hih = paramParcel.createStringArrayList();
      this.hii = paramParcel.readInt();
      this.hij = paramParcel.readInt();
      this.hik = paramParcel.readInt();
      this.hil = paramParcel.readInt();
      this.him = paramParcel.readString();
      AppMethodBeat.o(101795);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(101794);
      paramParcel.writeInt(this.mode);
      paramParcel.writeStringList(this.hig);
      paramParcel.writeStringList(this.hih);
      paramParcel.writeInt(this.hii);
      paramParcel.writeInt(this.hij);
      paramParcel.writeInt(this.hik);
      paramParcel.writeInt(this.hil);
      paramParcel.writeString(this.him);
      AppMethodBeat.o(101794);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig
 * JD-Core Version:    0.7.0.1
 */