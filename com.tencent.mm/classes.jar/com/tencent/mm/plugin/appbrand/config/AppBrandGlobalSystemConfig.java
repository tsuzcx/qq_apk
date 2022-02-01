package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandGlobalSystemConfig> CREATOR;
  private static volatile AppBrandGlobalSystemConfig jZD;
  public static final AppBrandGlobalSystemConfig jZE;
  public int jZF;
  public int jZG;
  public int jZH;
  public int jZI;
  public int jZJ;
  public int jZK;
  public int jZL;
  public int jZM;
  public String jZN;
  public String jZO;
  public HttpSetting jZP;
  public int[] jZQ;
  public int jZR;
  public int jZS;
  public int jZT;
  public int jZU;
  public int jZV;
  public int jZW;
  public int jZX;
  public int jZY;
  public int jZZ;
  public int kaa;
  public int kab;
  public String[] kac;
  public double kad;
  public int kae;
  public int kaf;
  public WeAppSyncVersionSetting kag;
  public PackageManager kah;
  public long kai;
  public String[] kaj;
  public int kak;
  public int kal;
  public int kam;
  
  static
  {
    AppMethodBeat.i(146988);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
    jZE = localAppBrandGlobalSystemConfig;
    localAppBrandGlobalSystemConfig.jZG = 5;
    jZE.jZH = 1;
    jZE.jZI = 300;
    jZE.jZJ = 50;
    jZE.jZK = 1048576;
    jZE.jZL = 1048576;
    jZE.jZM = 20971520;
    jZE.jZQ = a.kan;
    jZE.jZR = 50;
    jZE.jZS = 11;
    jZE.jZT = 12;
    jZE.jZV = 1800;
    jZE.jZW = 307200;
    jZE.jZX = 25;
    jZE.jZY = 10485760;
    jZE.jZZ = 314572800;
    jZE.kaa = 1;
    jZE.kab = 50;
    jZE.kac = a.kao;
    jZE.kad = 0.0D;
    jZE.kae = 60;
    jZE.kaf = 60;
    jZE.kag = new WeAppSyncVersionSetting();
    jZE.kah = new PackageManager();
    jZE.kai = 30L;
    jZE.kaj = a.kap;
    jZE.kak = 10;
    jZE.kam = 86400;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146988);
  }
  
  private AppBrandGlobalSystemConfig()
  {
    AppMethodBeat.i(146985);
    this.jZF = 2147483647;
    this.jZP = new HttpSetting();
    AppMethodBeat.o(146985);
  }
  
  protected AppBrandGlobalSystemConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(146987);
    this.jZF = 2147483647;
    this.jZP = new HttpSetting();
    this.jZF = paramParcel.readInt();
    this.jZG = paramParcel.readInt();
    this.jZH = paramParcel.readInt();
    this.jZI = paramParcel.readInt();
    this.jZJ = paramParcel.readInt();
    this.jZK = paramParcel.readInt();
    this.jZL = paramParcel.readInt();
    this.jZM = paramParcel.readInt();
    this.jZN = paramParcel.readString();
    this.jZO = paramParcel.readString();
    this.jZP = ((HttpSetting)paramParcel.readParcelable(HttpSetting.class.getClassLoader()));
    this.jZQ = paramParcel.createIntArray();
    this.jZR = paramParcel.readInt();
    this.jZS = paramParcel.readInt();
    this.jZV = paramParcel.readInt();
    this.jZW = paramParcel.readInt();
    this.jZX = paramParcel.readInt();
    this.jZY = paramParcel.readInt();
    this.jZZ = paramParcel.readInt();
    this.kaa = paramParcel.readInt();
    this.kab = paramParcel.readInt();
    this.kac = paramParcel.createStringArray();
    this.kad = paramParcel.readDouble();
    this.kae = paramParcel.readInt();
    this.kag = ((WeAppSyncVersionSetting)paramParcel.readParcelable(WeAppSyncVersionSetting.class.getClassLoader()));
    this.kah = ((PackageManager)paramParcel.readParcelable(PackageManager.class.getClassLoader()));
    this.kai = paramParcel.readLong();
    this.kaj = paramParcel.createStringArray();
    this.kak = paramParcel.readInt();
    this.kam = paramParcel.readInt();
    this.kal = paramParcel.readInt();
    this.kaf = paramParcel.readInt();
    AppMethodBeat.o(146987);
  }
  
  private static AppBrandGlobalSystemConfig NR(String paramString)
  {
    AppMethodBeat.i(146984);
    ae.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[] { paramString });
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig;
    Object localObject2;
    int i;
    try
    {
      paramString = new JSONObject(paramString);
      localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
      localObject1 = paramString.optJSONObject("HTTPSetting");
      if (localObject1 == null) {
        break label326;
      }
      localObject2 = ((JSONObject)localObject1).optString("HTTPHeaderMode", "");
      if (((String)localObject2).equals("BlackList")) {
        localAppBrandGlobalSystemConfig.jZP.mode = 1;
      }
      for (;;)
      {
        localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderBlackList");
        if (localObject2 == null) {
          break;
        }
        localAppBrandGlobalSystemConfig.jZP.kaq = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localAppBrandGlobalSystemConfig.jZP.kaq.add(((JSONArray)localObject2).getString(i));
          i += 1;
        }
        if (((String)localObject2).equals("WhiteList")) {
          localAppBrandGlobalSystemConfig.jZP.mode = 2;
        }
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderWhiteList");
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(146984);
      return null;
    }
    if (localObject2 != null)
    {
      localAppBrandGlobalSystemConfig.jZP.kar = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        localAppBrandGlobalSystemConfig.jZP.kar.add(((JSONArray)localObject2).getString(i));
        i += 1;
      }
    }
    localAppBrandGlobalSystemConfig.jZP.kas = ((JSONObject)localObject1).optInt("WebsocketMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jZP.kat = ((JSONObject)localObject1).optInt("UploadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jZP.kau = ((JSONObject)localObject1).optInt("DownloadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jZP.kav = ((JSONObject)localObject1).optInt("RequestMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jZP.kaw = ((JSONObject)localObject1).optString("HTTPHeaderReferer");
    label326:
    localAppBrandGlobalSystemConfig.kag = new WeAppSyncVersionSetting();
    Object localObject1 = paramString.optJSONObject("SyncVersionSetting");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.kag.kaB = ((JSONObject)localObject1).optLong("PullVersionInterval", localAppBrandGlobalSystemConfig.kag.kaB);
      localAppBrandGlobalSystemConfig.kag.kaC = ((JSONObject)localObject1).optLong("PullVersionWxaUsageLastInterval", localAppBrandGlobalSystemConfig.kag.kaC);
      localAppBrandGlobalSystemConfig.kag.kaD = ((JSONObject)localObject1).optInt("PullVersionMaxCount", localAppBrandGlobalSystemConfig.kag.kaD);
      localAppBrandGlobalSystemConfig.kag.kaE = ((JSONObject)localObject1).optInt("PullVersionMaxCountPerRequest", localAppBrandGlobalSystemConfig.kag.kaE);
    }
    localAppBrandGlobalSystemConfig.kah = new PackageManager();
    localObject1 = paramString.optJSONObject("PackageManager");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.kah.kax = ((JSONObject)localObject1).optLong("CheckInterval", localAppBrandGlobalSystemConfig.kah.kax);
      localAppBrandGlobalSystemConfig.kah.kay = ((JSONObject)localObject1).optLong("WithoutContactClearSeconds", localAppBrandGlobalSystemConfig.kah.kay);
      localAppBrandGlobalSystemConfig.kah.kaz = ((JSONObject)localObject1).optLong("ClientStorageMinMB", localAppBrandGlobalSystemConfig.kah.kaz);
      localAppBrandGlobalSystemConfig.kah.kaA = ((JSONObject)localObject1).optInt("WholeClientStoragePercent", localAppBrandGlobalSystemConfig.kah.kaA);
    }
    localAppBrandGlobalSystemConfig.jZN = paramString.optString("CDNBaseURL");
    localAppBrandGlobalSystemConfig.jZO = paramString.optString("CDNPreConnectURL", "https://res.servicewechat.com");
    localAppBrandGlobalSystemConfig.jZG = paramString.optInt("AppMaxRunningCount", 5);
    localAppBrandGlobalSystemConfig.jZH = paramString.optInt("AppSharedResourceBackgroundRunningCount", 1);
    localAppBrandGlobalSystemConfig.jZI = paramString.optInt("TempFileSizeLimitTotal", 300);
    localAppBrandGlobalSystemConfig.jZJ = paramString.optInt("DownloadFileSizeLimit", 50);
    localAppBrandGlobalSystemConfig.jZK = paramString.optInt("MaxLocalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.jZL = paramString.optInt("MaxGlobalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.jZM = paramString.optInt("MaxGlobalStorageSize", 20971520);
    localAppBrandGlobalSystemConfig.jZY = paramString.optInt("NativeBufferSizeLimitByte", 10485760);
    localAppBrandGlobalSystemConfig.jZZ = paramString.optInt("NativeBufferQueueLimitByte", 314572800);
    localAppBrandGlobalSystemConfig.kam = paramString.optInt("WeUseRecallInterval", 86400);
    localObject1 = paramString.optJSONArray("SyncLaunchSceneList");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.jZQ = new int[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.jZQ[i] = ((JSONArray)localObject1).optInt(i, 0);
        i += 1;
      }
    }
    if (localAppBrandGlobalSystemConfig.jZQ == null) {
      localAppBrandGlobalSystemConfig.jZQ = a.kan;
    }
    localAppBrandGlobalSystemConfig.jZR = paramString.optInt("StarNumberLimitation", 50);
    localAppBrandGlobalSystemConfig.jZS = paramString.optInt("TaskBarItemCountLimitation", 11);
    localAppBrandGlobalSystemConfig.jZT = paramString.optInt("NewTaskBarRecentsItemCountLimitation", 12);
    localAppBrandGlobalSystemConfig.jZU = paramString.optInt("TaskBarSyncUsageRecordIntervalMinute", 20);
    localAppBrandGlobalSystemConfig.jZV = paramString.optInt("WidgetImageFlowLimitDuration", 1800);
    localAppBrandGlobalSystemConfig.jZW = paramString.optInt("WidgetImageFlowLimitMaxSize", 307200);
    localAppBrandGlobalSystemConfig.jZX = paramString.optInt("WidgetDrawMinInterval", 25);
    localAppBrandGlobalSystemConfig.kaa = paramString.optInt("GameMaxRunningCount", 1);
    localAppBrandGlobalSystemConfig.kab = paramString.optInt("GameDownloadFileSizeLimit", 50);
    localObject1 = paramString.optJSONArray("SubContextImgDomain");
    if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
    {
      localAppBrandGlobalSystemConfig.kac = a.kao;
      localAppBrandGlobalSystemConfig.kad = paramString.optDouble("GamePerfCollectSamplePercentage", 0.0D);
      localAppBrandGlobalSystemConfig.kae = paramString.optInt("GamePerfCollectInterval", 60);
      localAppBrandGlobalSystemConfig.kaf = paramString.optInt("PerformIndexReportGapInSeconds", 60);
      localAppBrandGlobalSystemConfig.kai = paramString.optLong("OpendataMaxFileStorageSize", 30L);
      localObject1 = paramString.optJSONArray("PreDownloadUserNameBlackList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        break label1053;
      }
      localAppBrandGlobalSystemConfig.kaj = a.kap;
    }
    for (;;)
    {
      localAppBrandGlobalSystemConfig.kak = paramString.optInt("WXDataMaxRequestConcurrent", 10);
      localAppBrandGlobalSystemConfig.kal = paramString.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
      AppMethodBeat.o(146984);
      return localAppBrandGlobalSystemConfig;
      localAppBrandGlobalSystemConfig.kac = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.kac[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
      break;
      label1053:
      localAppBrandGlobalSystemConfig.kaj = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.kaj[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
    }
  }
  
  static void bew()
  {
    try
    {
      jZD = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String bex()
  {
    AppMethodBeat.i(146981);
    Object localObject = new k(b.asc().replace("/data/user/0", "/data/data"), "wxaapp/res/");
    if (!((k)localObject).exists()) {
      ((k)localObject).mkdirs();
    }
    localObject = w.B(new k((k)localObject, "AppService.conf").fTh());
    AppMethodBeat.o(146981);
    return localObject;
  }
  
  /* Error */
  private static AppBrandGlobalSystemConfig bey()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 517
    //   6: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 466	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jZD	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +79 -> 93
    //   17: invokestatic 519	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bex	()Ljava/lang/String;
    //   20: invokestatic 524	com/tencent/mm/vfs/o:aZT	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic 528	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   28: ifeq +58 -> 86
    //   31: ldc_w 517
    //   34: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: ldc_w 530
    //   48: invokestatic 536	com/tencent/luggage/a/e:K	(Ljava/lang/Class;)Lcom/tencent/luggage/a/b;
    //   51: checkcast 530	com/tencent/luggage/sdk/customize/a
    //   54: invokeinterface 539 1 0
    //   59: aconst_null
    //   60: astore_0
    //   61: goto -37 -> 24
    //   64: astore_0
    //   65: ldc 230
    //   67: ldc_w 541
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: invokestatic 305	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -59 -> 24
    //   86: aload_0
    //   87: invokestatic 543	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:NR	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   90: putstatic 466	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jZD	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   93: getstatic 466	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jZD	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   96: astore_0
    //   97: ldc_w 517
    //   100: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: goto -64 -> 39
    //   106: astore_0
    //   107: ldc 2
    //   109: monitorexit
    //   110: aload_0
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	31	0	localObject1	Object
    //   44	1	0	localFileNotFoundException	java.io.FileNotFoundException
    //   60	1	0	localObject2	Object
    //   64	13	0	localIOException	java.io.IOException
    //   82	15	0	localObject3	Object
    //   106	5	0	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	44	java/io/FileNotFoundException
    //   17	24	64	java/io/IOException
    //   3	13	106	finally
    //   17	24	106	finally
    //   24	37	106	finally
    //   45	59	106	finally
    //   65	81	106	finally
    //   86	93	106	finally
    //   93	103	106	finally
  }
  
  public static AppBrandGlobalSystemConfig bez()
  {
    AppMethodBeat.i(146983);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = bey();
    if (localAppBrandGlobalSystemConfig == null)
    {
      localAppBrandGlobalSystemConfig = jZE;
      AppMethodBeat.o(146983);
      return localAppBrandGlobalSystemConfig;
    }
    AppMethodBeat.o(146983);
    return localAppBrandGlobalSystemConfig;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146986);
    paramParcel.writeInt(this.jZF);
    paramParcel.writeInt(this.jZG);
    paramParcel.writeInt(this.jZH);
    paramParcel.writeInt(this.jZI);
    paramParcel.writeInt(this.jZJ);
    paramParcel.writeInt(this.jZK);
    paramParcel.writeInt(this.jZL);
    paramParcel.writeInt(this.jZM);
    paramParcel.writeString(this.jZN);
    paramParcel.writeString(this.jZO);
    paramParcel.writeParcelable(this.jZP, paramInt);
    paramParcel.writeIntArray(this.jZQ);
    paramParcel.writeInt(this.jZR);
    paramParcel.writeInt(this.jZS);
    paramParcel.writeInt(this.jZV);
    paramParcel.writeInt(this.jZW);
    paramParcel.writeInt(this.jZX);
    paramParcel.writeInt(this.jZY);
    paramParcel.writeInt(this.jZZ);
    paramParcel.writeInt(this.kaa);
    paramParcel.writeInt(this.kab);
    paramParcel.writeStringArray(this.kac);
    paramParcel.writeDouble(this.kad);
    paramParcel.writeInt(this.kae);
    paramParcel.writeParcelable(this.kag, paramInt);
    paramParcel.writeParcelable(this.kah, paramInt);
    paramParcel.writeLong(this.kai);
    paramParcel.writeStringArray(this.kaj);
    paramParcel.writeInt(this.kak);
    paramParcel.writeInt(this.kam);
    paramParcel.writeInt(this.kal);
    paramParcel.writeInt(this.kaf);
    AppMethodBeat.o(146986);
  }
  
  public static final class HttpSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<HttpSetting> CREATOR;
    public ArrayList<String> kaq;
    public ArrayList<String> kar;
    public int kas;
    public int kat;
    public int kau;
    public int kav;
    public String kaw;
    public int mode;
    
    static
    {
      AppMethodBeat.i(146972);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146972);
    }
    
    public HttpSetting()
    {
      this.mode = 0;
    }
    
    HttpSetting(Parcel paramParcel)
    {
      AppMethodBeat.i(146971);
      this.mode = 0;
      this.mode = paramParcel.readInt();
      this.kaq = paramParcel.createStringArrayList();
      this.kar = paramParcel.createStringArrayList();
      this.kas = paramParcel.readInt();
      this.kat = paramParcel.readInt();
      this.kau = paramParcel.readInt();
      this.kav = paramParcel.readInt();
      this.kaw = paramParcel.readString();
      AppMethodBeat.o(146971);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146970);
      paramParcel.writeInt(this.mode);
      paramParcel.writeStringList(this.kaq);
      paramParcel.writeStringList(this.kar);
      paramParcel.writeInt(this.kas);
      paramParcel.writeInt(this.kat);
      paramParcel.writeInt(this.kau);
      paramParcel.writeInt(this.kav);
      paramParcel.writeString(this.kaw);
      AppMethodBeat.o(146970);
    }
  }
  
  public static final class PackageManager
    implements Parcelable
  {
    public static final Parcelable.Creator<PackageManager> CREATOR;
    public int kaA;
    public long kax;
    public long kay;
    public long kaz;
    
    static
    {
      AppMethodBeat.i(146976);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146976);
    }
    
    public PackageManager()
    {
      this.kax = 86400L;
      this.kay = 864000L;
      this.kaz = 256L;
      this.kaA = 5;
    }
    
    protected PackageManager(Parcel paramParcel)
    {
      AppMethodBeat.i(146975);
      this.kax = 86400L;
      this.kay = 864000L;
      this.kaz = 256L;
      this.kaA = 5;
      this.kax = paramParcel.readLong();
      this.kay = paramParcel.readLong();
      this.kaz = paramParcel.readLong();
      this.kaA = paramParcel.readInt();
      AppMethodBeat.o(146975);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146974);
      paramParcel.writeLong(this.kax);
      paramParcel.writeLong(this.kay);
      paramParcel.writeLong(this.kaz);
      paramParcel.writeInt(this.kaA);
      AppMethodBeat.o(146974);
    }
  }
  
  public static final class WeAppSyncVersionSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<WeAppSyncVersionSetting> CREATOR;
    public long kaB;
    public long kaC;
    public int kaD;
    public int kaE;
    
    static
    {
      AppMethodBeat.i(146980);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146980);
    }
    
    WeAppSyncVersionSetting()
    {
      this.kaB = 21600L;
      this.kaC = 604800L;
      this.kaD = 1000;
      this.kaE = 100;
    }
    
    WeAppSyncVersionSetting(Parcel paramParcel)
    {
      AppMethodBeat.i(146979);
      this.kaB = 21600L;
      this.kaC = 604800L;
      this.kaD = 1000;
      this.kaE = 100;
      this.kaB = paramParcel.readLong();
      this.kaC = paramParcel.readLong();
      this.kaD = paramParcel.readInt();
      this.kaE = paramParcel.readInt();
      AppMethodBeat.o(146979);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146978);
      paramParcel.writeLong(this.kaB);
      paramParcel.writeLong(this.kaC);
      paramParcel.writeInt(this.kaD);
      paramParcel.writeInt(this.kaE);
      AppMethodBeat.o(146978);
    }
  }
  
  public static abstract interface a
  {
    public static final int[] kan = new int[0];
    public static final String[] kao = { "https://wx.qlogo.cn/" };
    public static final String[] kap = new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig
 * JD-Core Version:    0.7.0.1
 */