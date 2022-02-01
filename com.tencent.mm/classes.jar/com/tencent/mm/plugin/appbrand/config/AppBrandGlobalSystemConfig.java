package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandGlobalSystemConfig> CREATOR;
  private static volatile AppBrandGlobalSystemConfig jWo;
  public static final AppBrandGlobalSystemConfig jWp;
  public HttpSetting jWA;
  public int[] jWB;
  public int jWC;
  public int jWD;
  public int jWE;
  public int jWF;
  public int jWG;
  public int jWH;
  public int jWI;
  public int jWJ;
  public int jWK;
  public int jWL;
  public int jWM;
  public String[] jWN;
  public double jWO;
  public int jWP;
  public int jWQ;
  public WeAppSyncVersionSetting jWR;
  public PackageManager jWS;
  public long jWT;
  public String[] jWU;
  public int jWV;
  public int jWW;
  public int jWX;
  public int jWq;
  public int jWr;
  public int jWs;
  public int jWt;
  public int jWu;
  public int jWv;
  public int jWw;
  public int jWx;
  public String jWy;
  public String jWz;
  
  static
  {
    AppMethodBeat.i(146988);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
    jWp = localAppBrandGlobalSystemConfig;
    localAppBrandGlobalSystemConfig.jWr = 5;
    jWp.jWs = 1;
    jWp.jWt = 300;
    jWp.jWu = 50;
    jWp.jWv = 1048576;
    jWp.jWw = 1048576;
    jWp.jWx = 20971520;
    jWp.jWB = a.jWY;
    jWp.jWC = 50;
    jWp.jWD = 11;
    jWp.jWE = 12;
    jWp.jWG = 1800;
    jWp.jWH = 307200;
    jWp.jWI = 25;
    jWp.jWJ = 10485760;
    jWp.jWK = 314572800;
    jWp.jWL = 1;
    jWp.jWM = 50;
    jWp.jWN = a.jWZ;
    jWp.jWO = 0.0D;
    jWp.jWP = 60;
    jWp.jWQ = 60;
    jWp.jWR = new WeAppSyncVersionSetting();
    jWp.jWS = new PackageManager();
    jWp.jWT = 30L;
    jWp.jWU = a.jXa;
    jWp.jWV = 10;
    jWp.jWX = 86400;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146988);
  }
  
  private AppBrandGlobalSystemConfig()
  {
    AppMethodBeat.i(146985);
    this.jWq = 2147483647;
    this.jWA = new HttpSetting();
    AppMethodBeat.o(146985);
  }
  
  protected AppBrandGlobalSystemConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(146987);
    this.jWq = 2147483647;
    this.jWA = new HttpSetting();
    this.jWq = paramParcel.readInt();
    this.jWr = paramParcel.readInt();
    this.jWs = paramParcel.readInt();
    this.jWt = paramParcel.readInt();
    this.jWu = paramParcel.readInt();
    this.jWv = paramParcel.readInt();
    this.jWw = paramParcel.readInt();
    this.jWx = paramParcel.readInt();
    this.jWy = paramParcel.readString();
    this.jWz = paramParcel.readString();
    this.jWA = ((HttpSetting)paramParcel.readParcelable(HttpSetting.class.getClassLoader()));
    this.jWB = paramParcel.createIntArray();
    this.jWC = paramParcel.readInt();
    this.jWD = paramParcel.readInt();
    this.jWG = paramParcel.readInt();
    this.jWH = paramParcel.readInt();
    this.jWI = paramParcel.readInt();
    this.jWJ = paramParcel.readInt();
    this.jWK = paramParcel.readInt();
    this.jWL = paramParcel.readInt();
    this.jWM = paramParcel.readInt();
    this.jWN = paramParcel.createStringArray();
    this.jWO = paramParcel.readDouble();
    this.jWP = paramParcel.readInt();
    this.jWR = ((WeAppSyncVersionSetting)paramParcel.readParcelable(WeAppSyncVersionSetting.class.getClassLoader()));
    this.jWS = ((PackageManager)paramParcel.readParcelable(PackageManager.class.getClassLoader()));
    this.jWT = paramParcel.readLong();
    this.jWU = paramParcel.createStringArray();
    this.jWV = paramParcel.readInt();
    this.jWX = paramParcel.readInt();
    this.jWW = paramParcel.readInt();
    this.jWQ = paramParcel.readInt();
    AppMethodBeat.o(146987);
  }
  
  private static AppBrandGlobalSystemConfig Nk(String paramString)
  {
    AppMethodBeat.i(146984);
    ad.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[] { paramString });
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
        localAppBrandGlobalSystemConfig.jWA.mode = 1;
      }
      for (;;)
      {
        localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderBlackList");
        if (localObject2 == null) {
          break;
        }
        localAppBrandGlobalSystemConfig.jWA.jXb = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localAppBrandGlobalSystemConfig.jWA.jXb.add(((JSONArray)localObject2).getString(i));
          i += 1;
        }
        if (((String)localObject2).equals("WhiteList")) {
          localAppBrandGlobalSystemConfig.jWA.mode = 2;
        }
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderWhiteList");
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(146984);
      return null;
    }
    if (localObject2 != null)
    {
      localAppBrandGlobalSystemConfig.jWA.jXc = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        localAppBrandGlobalSystemConfig.jWA.jXc.add(((JSONArray)localObject2).getString(i));
        i += 1;
      }
    }
    localAppBrandGlobalSystemConfig.jWA.jXd = ((JSONObject)localObject1).optInt("WebsocketMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jWA.jXe = ((JSONObject)localObject1).optInt("UploadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jWA.jXf = ((JSONObject)localObject1).optInt("DownloadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jWA.jXg = ((JSONObject)localObject1).optInt("RequestMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jWA.jXh = ((JSONObject)localObject1).optString("HTTPHeaderReferer");
    label326:
    localAppBrandGlobalSystemConfig.jWR = new WeAppSyncVersionSetting();
    Object localObject1 = paramString.optJSONObject("SyncVersionSetting");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.jWR.jXm = ((JSONObject)localObject1).optLong("PullVersionInterval", localAppBrandGlobalSystemConfig.jWR.jXm);
      localAppBrandGlobalSystemConfig.jWR.jXn = ((JSONObject)localObject1).optLong("PullVersionWxaUsageLastInterval", localAppBrandGlobalSystemConfig.jWR.jXn);
      localAppBrandGlobalSystemConfig.jWR.jXo = ((JSONObject)localObject1).optInt("PullVersionMaxCount", localAppBrandGlobalSystemConfig.jWR.jXo);
      localAppBrandGlobalSystemConfig.jWR.jXp = ((JSONObject)localObject1).optInt("PullVersionMaxCountPerRequest", localAppBrandGlobalSystemConfig.jWR.jXp);
    }
    localAppBrandGlobalSystemConfig.jWS = new PackageManager();
    localObject1 = paramString.optJSONObject("PackageManager");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.jWS.jXi = ((JSONObject)localObject1).optLong("CheckInterval", localAppBrandGlobalSystemConfig.jWS.jXi);
      localAppBrandGlobalSystemConfig.jWS.jXj = ((JSONObject)localObject1).optLong("WithoutContactClearSeconds", localAppBrandGlobalSystemConfig.jWS.jXj);
      localAppBrandGlobalSystemConfig.jWS.jXk = ((JSONObject)localObject1).optLong("ClientStorageMinMB", localAppBrandGlobalSystemConfig.jWS.jXk);
      localAppBrandGlobalSystemConfig.jWS.jXl = ((JSONObject)localObject1).optInt("WholeClientStoragePercent", localAppBrandGlobalSystemConfig.jWS.jXl);
    }
    localAppBrandGlobalSystemConfig.jWy = paramString.optString("CDNBaseURL");
    localAppBrandGlobalSystemConfig.jWz = paramString.optString("CDNPreConnectURL", "https://res.servicewechat.com");
    localAppBrandGlobalSystemConfig.jWr = paramString.optInt("AppMaxRunningCount", 5);
    localAppBrandGlobalSystemConfig.jWs = paramString.optInt("AppSharedResourceBackgroundRunningCount", 1);
    localAppBrandGlobalSystemConfig.jWt = paramString.optInt("TempFileSizeLimitTotal", 300);
    localAppBrandGlobalSystemConfig.jWu = paramString.optInt("DownloadFileSizeLimit", 50);
    localAppBrandGlobalSystemConfig.jWv = paramString.optInt("MaxLocalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.jWw = paramString.optInt("MaxGlobalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.jWx = paramString.optInt("MaxGlobalStorageSize", 20971520);
    localAppBrandGlobalSystemConfig.jWJ = paramString.optInt("NativeBufferSizeLimitByte", 10485760);
    localAppBrandGlobalSystemConfig.jWK = paramString.optInt("NativeBufferQueueLimitByte", 314572800);
    localAppBrandGlobalSystemConfig.jWX = paramString.optInt("WeUseRecallInterval", 86400);
    localObject1 = paramString.optJSONArray("SyncLaunchSceneList");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.jWB = new int[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.jWB[i] = ((JSONArray)localObject1).optInt(i, 0);
        i += 1;
      }
    }
    if (localAppBrandGlobalSystemConfig.jWB == null) {
      localAppBrandGlobalSystemConfig.jWB = a.jWY;
    }
    localAppBrandGlobalSystemConfig.jWC = paramString.optInt("StarNumberLimitation", 50);
    localAppBrandGlobalSystemConfig.jWD = paramString.optInt("TaskBarItemCountLimitation", 11);
    localAppBrandGlobalSystemConfig.jWE = paramString.optInt("NewTaskBarRecentsItemCountLimitation", 12);
    localAppBrandGlobalSystemConfig.jWF = paramString.optInt("TaskBarSyncUsageRecordIntervalMinute", 20);
    localAppBrandGlobalSystemConfig.jWG = paramString.optInt("WidgetImageFlowLimitDuration", 1800);
    localAppBrandGlobalSystemConfig.jWH = paramString.optInt("WidgetImageFlowLimitMaxSize", 307200);
    localAppBrandGlobalSystemConfig.jWI = paramString.optInt("WidgetDrawMinInterval", 25);
    localAppBrandGlobalSystemConfig.jWL = paramString.optInt("GameMaxRunningCount", 1);
    localAppBrandGlobalSystemConfig.jWM = paramString.optInt("GameDownloadFileSizeLimit", 50);
    localObject1 = paramString.optJSONArray("SubContextImgDomain");
    if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
    {
      localAppBrandGlobalSystemConfig.jWN = a.jWZ;
      localAppBrandGlobalSystemConfig.jWO = paramString.optDouble("GamePerfCollectSamplePercentage", 0.0D);
      localAppBrandGlobalSystemConfig.jWP = paramString.optInt("GamePerfCollectInterval", 60);
      localAppBrandGlobalSystemConfig.jWQ = paramString.optInt("PerformIndexReportGapInSeconds", 60);
      localAppBrandGlobalSystemConfig.jWT = paramString.optLong("OpendataMaxFileStorageSize", 30L);
      localObject1 = paramString.optJSONArray("PreDownloadUserNameBlackList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        break label1053;
      }
      localAppBrandGlobalSystemConfig.jWU = a.jXa;
    }
    for (;;)
    {
      localAppBrandGlobalSystemConfig.jWV = paramString.optInt("WXDataMaxRequestConcurrent", 10);
      localAppBrandGlobalSystemConfig.jWW = paramString.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
      AppMethodBeat.o(146984);
      return localAppBrandGlobalSystemConfig;
      localAppBrandGlobalSystemConfig.jWN = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.jWN[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
      break;
      label1053:
      localAppBrandGlobalSystemConfig.jWU = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.jWU[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
    }
  }
  
  static void bdQ()
  {
    try
    {
      jWo = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String bdR()
  {
    AppMethodBeat.i(146981);
    Object localObject = new e(b.arN().replace("/data/user/0", "/data/data"), "wxaapp/res/");
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    localObject = q.B(new e((e)localObject, "AppService.conf").fOK());
    AppMethodBeat.o(146981);
    return localObject;
  }
  
  /* Error */
  private static AppBrandGlobalSystemConfig bdS()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 518
    //   6: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 467	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jWo	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +79 -> 93
    //   17: invokestatic 520	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bdR	()Ljava/lang/String;
    //   20: invokestatic 525	com/tencent/mm/vfs/i:aYq	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic 529	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   28: ifeq +58 -> 86
    //   31: ldc_w 518
    //   34: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: ldc_w 531
    //   48: invokestatic 537	com/tencent/luggage/a/e:K	(Ljava/lang/Class;)Lcom/tencent/luggage/a/b;
    //   51: checkcast 531	com/tencent/luggage/sdk/customize/a
    //   54: invokeinterface 540 1 0
    //   59: aconst_null
    //   60: astore_0
    //   61: goto -37 -> 24
    //   64: astore_0
    //   65: ldc 230
    //   67: ldc_w 542
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: invokestatic 306	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -59 -> 24
    //   86: aload_0
    //   87: invokestatic 544	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:Nk	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   90: putstatic 467	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jWo	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   93: getstatic 467	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jWo	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   96: astore_0
    //   97: ldc_w 518
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
  
  public static AppBrandGlobalSystemConfig bdT()
  {
    AppMethodBeat.i(146983);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = bdS();
    if (localAppBrandGlobalSystemConfig == null)
    {
      localAppBrandGlobalSystemConfig = jWp;
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
    paramParcel.writeInt(this.jWq);
    paramParcel.writeInt(this.jWr);
    paramParcel.writeInt(this.jWs);
    paramParcel.writeInt(this.jWt);
    paramParcel.writeInt(this.jWu);
    paramParcel.writeInt(this.jWv);
    paramParcel.writeInt(this.jWw);
    paramParcel.writeInt(this.jWx);
    paramParcel.writeString(this.jWy);
    paramParcel.writeString(this.jWz);
    paramParcel.writeParcelable(this.jWA, paramInt);
    paramParcel.writeIntArray(this.jWB);
    paramParcel.writeInt(this.jWC);
    paramParcel.writeInt(this.jWD);
    paramParcel.writeInt(this.jWG);
    paramParcel.writeInt(this.jWH);
    paramParcel.writeInt(this.jWI);
    paramParcel.writeInt(this.jWJ);
    paramParcel.writeInt(this.jWK);
    paramParcel.writeInt(this.jWL);
    paramParcel.writeInt(this.jWM);
    paramParcel.writeStringArray(this.jWN);
    paramParcel.writeDouble(this.jWO);
    paramParcel.writeInt(this.jWP);
    paramParcel.writeParcelable(this.jWR, paramInt);
    paramParcel.writeParcelable(this.jWS, paramInt);
    paramParcel.writeLong(this.jWT);
    paramParcel.writeStringArray(this.jWU);
    paramParcel.writeInt(this.jWV);
    paramParcel.writeInt(this.jWX);
    paramParcel.writeInt(this.jWW);
    paramParcel.writeInt(this.jWQ);
    AppMethodBeat.o(146986);
  }
  
  public static final class HttpSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<HttpSetting> CREATOR;
    public ArrayList<String> jXb;
    public ArrayList<String> jXc;
    public int jXd;
    public int jXe;
    public int jXf;
    public int jXg;
    public String jXh;
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
      this.jXb = paramParcel.createStringArrayList();
      this.jXc = paramParcel.createStringArrayList();
      this.jXd = paramParcel.readInt();
      this.jXe = paramParcel.readInt();
      this.jXf = paramParcel.readInt();
      this.jXg = paramParcel.readInt();
      this.jXh = paramParcel.readString();
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
      paramParcel.writeStringList(this.jXb);
      paramParcel.writeStringList(this.jXc);
      paramParcel.writeInt(this.jXd);
      paramParcel.writeInt(this.jXe);
      paramParcel.writeInt(this.jXf);
      paramParcel.writeInt(this.jXg);
      paramParcel.writeString(this.jXh);
      AppMethodBeat.o(146970);
    }
  }
  
  public static final class PackageManager
    implements Parcelable
  {
    public static final Parcelable.Creator<PackageManager> CREATOR;
    public long jXi;
    public long jXj;
    public long jXk;
    public int jXl;
    
    static
    {
      AppMethodBeat.i(146976);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146976);
    }
    
    public PackageManager()
    {
      this.jXi = 86400L;
      this.jXj = 864000L;
      this.jXk = 256L;
      this.jXl = 5;
    }
    
    protected PackageManager(Parcel paramParcel)
    {
      AppMethodBeat.i(146975);
      this.jXi = 86400L;
      this.jXj = 864000L;
      this.jXk = 256L;
      this.jXl = 5;
      this.jXi = paramParcel.readLong();
      this.jXj = paramParcel.readLong();
      this.jXk = paramParcel.readLong();
      this.jXl = paramParcel.readInt();
      AppMethodBeat.o(146975);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146974);
      paramParcel.writeLong(this.jXi);
      paramParcel.writeLong(this.jXj);
      paramParcel.writeLong(this.jXk);
      paramParcel.writeInt(this.jXl);
      AppMethodBeat.o(146974);
    }
  }
  
  public static final class WeAppSyncVersionSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<WeAppSyncVersionSetting> CREATOR;
    public long jXm;
    public long jXn;
    public int jXo;
    public int jXp;
    
    static
    {
      AppMethodBeat.i(146980);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146980);
    }
    
    WeAppSyncVersionSetting()
    {
      this.jXm = 21600L;
      this.jXn = 604800L;
      this.jXo = 1000;
      this.jXp = 100;
    }
    
    WeAppSyncVersionSetting(Parcel paramParcel)
    {
      AppMethodBeat.i(146979);
      this.jXm = 21600L;
      this.jXn = 604800L;
      this.jXo = 1000;
      this.jXp = 100;
      this.jXm = paramParcel.readLong();
      this.jXn = paramParcel.readLong();
      this.jXo = paramParcel.readInt();
      this.jXp = paramParcel.readInt();
      AppMethodBeat.o(146979);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146978);
      paramParcel.writeLong(this.jXm);
      paramParcel.writeLong(this.jXn);
      paramParcel.writeInt(this.jXo);
      paramParcel.writeInt(this.jXp);
      AppMethodBeat.o(146978);
    }
  }
  
  public static abstract interface a
  {
    public static final int[] jWY = new int[0];
    public static final String[] jWZ = { "https://wx.qlogo.cn/" };
    public static final String[] jXa = new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig
 * JD-Core Version:    0.7.0.1
 */