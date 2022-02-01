package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandGlobalSystemConfig> CREATOR;
  private static volatile AppBrandGlobalSystemConfig jCs;
  public static final AppBrandGlobalSystemConfig jCt;
  public int jCA;
  public int jCB;
  public String jCC;
  public String jCD;
  public HttpSetting jCE;
  public int[] jCF;
  public int jCG;
  public int jCH;
  public int jCI;
  public int jCJ;
  public int jCK;
  public int jCL;
  public int jCM;
  public int jCN;
  public int jCO;
  public int jCP;
  public int jCQ;
  public String[] jCR;
  public double jCS;
  public int jCT;
  public int jCU;
  public WeAppSyncVersionSetting jCV;
  public PackageManager jCW;
  public long jCX;
  public String[] jCY;
  public int jCZ;
  public int jCu;
  public int jCv;
  public int jCw;
  public int jCx;
  public int jCy;
  public int jCz;
  public int jDa;
  public int jDb;
  
  static
  {
    AppMethodBeat.i(146988);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
    jCt = localAppBrandGlobalSystemConfig;
    localAppBrandGlobalSystemConfig.jCv = 5;
    jCt.jCw = 1;
    jCt.jCx = 300;
    jCt.jCy = 50;
    jCt.jCz = 1048576;
    jCt.jCA = 1048576;
    jCt.jCB = 20971520;
    jCt.jCF = a.jDc;
    jCt.jCG = 50;
    jCt.jCH = 11;
    jCt.jCI = 12;
    jCt.jCK = 1800;
    jCt.jCL = 307200;
    jCt.jCM = 25;
    jCt.jCN = 10485760;
    jCt.jCO = 314572800;
    jCt.jCP = 1;
    jCt.jCQ = 50;
    jCt.jCR = a.jDd;
    jCt.jCS = 0.0D;
    jCt.jCT = 60;
    jCt.jCU = 60;
    jCt.jCV = new WeAppSyncVersionSetting();
    jCt.jCW = new PackageManager();
    jCt.jCX = 30L;
    jCt.jCY = a.jDe;
    jCt.jCZ = 10;
    jCt.jDb = 86400;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146988);
  }
  
  private AppBrandGlobalSystemConfig()
  {
    AppMethodBeat.i(146985);
    this.jCu = 2147483647;
    this.jCE = new HttpSetting();
    AppMethodBeat.o(146985);
  }
  
  protected AppBrandGlobalSystemConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(146987);
    this.jCu = 2147483647;
    this.jCE = new HttpSetting();
    this.jCu = paramParcel.readInt();
    this.jCv = paramParcel.readInt();
    this.jCw = paramParcel.readInt();
    this.jCx = paramParcel.readInt();
    this.jCy = paramParcel.readInt();
    this.jCz = paramParcel.readInt();
    this.jCA = paramParcel.readInt();
    this.jCB = paramParcel.readInt();
    this.jCC = paramParcel.readString();
    this.jCD = paramParcel.readString();
    this.jCE = ((HttpSetting)paramParcel.readParcelable(HttpSetting.class.getClassLoader()));
    this.jCF = paramParcel.createIntArray();
    this.jCG = paramParcel.readInt();
    this.jCH = paramParcel.readInt();
    this.jCK = paramParcel.readInt();
    this.jCL = paramParcel.readInt();
    this.jCM = paramParcel.readInt();
    this.jCN = paramParcel.readInt();
    this.jCO = paramParcel.readInt();
    this.jCP = paramParcel.readInt();
    this.jCQ = paramParcel.readInt();
    this.jCR = paramParcel.createStringArray();
    this.jCS = paramParcel.readDouble();
    this.jCT = paramParcel.readInt();
    this.jCV = ((WeAppSyncVersionSetting)paramParcel.readParcelable(WeAppSyncVersionSetting.class.getClassLoader()));
    this.jCW = ((PackageManager)paramParcel.readParcelable(PackageManager.class.getClassLoader()));
    this.jCX = paramParcel.readLong();
    this.jCY = paramParcel.createStringArray();
    this.jCZ = paramParcel.readInt();
    this.jDb = paramParcel.readInt();
    this.jDa = paramParcel.readInt();
    this.jCU = paramParcel.readInt();
    AppMethodBeat.o(146987);
  }
  
  private static AppBrandGlobalSystemConfig JR(String paramString)
  {
    AppMethodBeat.i(146984);
    ac.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[] { paramString });
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
        localAppBrandGlobalSystemConfig.jCE.mode = 1;
      }
      for (;;)
      {
        localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderBlackList");
        if (localObject2 == null) {
          break;
        }
        localAppBrandGlobalSystemConfig.jCE.jDf = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localAppBrandGlobalSystemConfig.jCE.jDf.add(((JSONArray)localObject2).getString(i));
          i += 1;
        }
        if (((String)localObject2).equals("WhiteList")) {
          localAppBrandGlobalSystemConfig.jCE.mode = 2;
        }
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderWhiteList");
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(146984);
      return null;
    }
    if (localObject2 != null)
    {
      localAppBrandGlobalSystemConfig.jCE.jDg = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        localAppBrandGlobalSystemConfig.jCE.jDg.add(((JSONArray)localObject2).getString(i));
        i += 1;
      }
    }
    localAppBrandGlobalSystemConfig.jCE.jDh = ((JSONObject)localObject1).optInt("WebsocketMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jCE.jDi = ((JSONObject)localObject1).optInt("UploadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jCE.jDj = ((JSONObject)localObject1).optInt("DownloadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jCE.jDk = ((JSONObject)localObject1).optInt("RequestMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jCE.jDl = ((JSONObject)localObject1).optString("HTTPHeaderReferer");
    label326:
    localAppBrandGlobalSystemConfig.jCV = new WeAppSyncVersionSetting();
    Object localObject1 = paramString.optJSONObject("SyncVersionSetting");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.jCV.jDq = ((JSONObject)localObject1).optLong("PullVersionInterval", localAppBrandGlobalSystemConfig.jCV.jDq);
      localAppBrandGlobalSystemConfig.jCV.jDr = ((JSONObject)localObject1).optLong("PullVersionWxaUsageLastInterval", localAppBrandGlobalSystemConfig.jCV.jDr);
      localAppBrandGlobalSystemConfig.jCV.jDs = ((JSONObject)localObject1).optInt("PullVersionMaxCount", localAppBrandGlobalSystemConfig.jCV.jDs);
      localAppBrandGlobalSystemConfig.jCV.jDt = ((JSONObject)localObject1).optInt("PullVersionMaxCountPerRequest", localAppBrandGlobalSystemConfig.jCV.jDt);
    }
    localAppBrandGlobalSystemConfig.jCW = new PackageManager();
    localObject1 = paramString.optJSONObject("PackageManager");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.jCW.jDm = ((JSONObject)localObject1).optLong("CheckInterval", localAppBrandGlobalSystemConfig.jCW.jDm);
      localAppBrandGlobalSystemConfig.jCW.jDn = ((JSONObject)localObject1).optLong("WithoutContactClearSeconds", localAppBrandGlobalSystemConfig.jCW.jDn);
      localAppBrandGlobalSystemConfig.jCW.jDo = ((JSONObject)localObject1).optLong("ClientStorageMinMB", localAppBrandGlobalSystemConfig.jCW.jDo);
      localAppBrandGlobalSystemConfig.jCW.jDp = ((JSONObject)localObject1).optInt("WholeClientStoragePercent", localAppBrandGlobalSystemConfig.jCW.jDp);
    }
    localAppBrandGlobalSystemConfig.jCC = paramString.optString("CDNBaseURL");
    localAppBrandGlobalSystemConfig.jCD = paramString.optString("CDNPreConnectURL", "https://res.servicewechat.com");
    localAppBrandGlobalSystemConfig.jCv = paramString.optInt("AppMaxRunningCount", 5);
    localAppBrandGlobalSystemConfig.jCw = paramString.optInt("AppSharedResourceBackgroundRunningCount", 1);
    localAppBrandGlobalSystemConfig.jCx = paramString.optInt("TempFileSizeLimitTotal", 300);
    localAppBrandGlobalSystemConfig.jCy = paramString.optInt("DownloadFileSizeLimit", 50);
    localAppBrandGlobalSystemConfig.jCz = paramString.optInt("MaxLocalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.jCA = paramString.optInt("MaxGlobalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.jCB = paramString.optInt("MaxGlobalStorageSize", 20971520);
    localAppBrandGlobalSystemConfig.jCN = paramString.optInt("NativeBufferSizeLimitByte", 10485760);
    localAppBrandGlobalSystemConfig.jCO = paramString.optInt("NativeBufferQueueLimitByte", 314572800);
    localAppBrandGlobalSystemConfig.jDb = paramString.optInt("WeUseRecallInterval", 86400);
    localObject1 = paramString.optJSONArray("SyncLaunchSceneList");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.jCF = new int[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.jCF[i] = ((JSONArray)localObject1).optInt(i, 0);
        i += 1;
      }
    }
    if (localAppBrandGlobalSystemConfig.jCF == null) {
      localAppBrandGlobalSystemConfig.jCF = a.jDc;
    }
    localAppBrandGlobalSystemConfig.jCG = paramString.optInt("StarNumberLimitation", 50);
    localAppBrandGlobalSystemConfig.jCH = paramString.optInt("TaskBarItemCountLimitation", 11);
    localAppBrandGlobalSystemConfig.jCI = paramString.optInt("NewTaskBarRecentsItemCountLimitation", 12);
    localAppBrandGlobalSystemConfig.jCJ = paramString.optInt("TaskBarSyncUsageRecordIntervalMinute", 20);
    localAppBrandGlobalSystemConfig.jCK = paramString.optInt("WidgetImageFlowLimitDuration", 1800);
    localAppBrandGlobalSystemConfig.jCL = paramString.optInt("WidgetImageFlowLimitMaxSize", 307200);
    localAppBrandGlobalSystemConfig.jCM = paramString.optInt("WidgetDrawMinInterval", 25);
    localAppBrandGlobalSystemConfig.jCP = paramString.optInt("GameMaxRunningCount", 1);
    localAppBrandGlobalSystemConfig.jCQ = paramString.optInt("GameDownloadFileSizeLimit", 50);
    localObject1 = paramString.optJSONArray("SubContextImgDomain");
    if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
    {
      localAppBrandGlobalSystemConfig.jCR = a.jDd;
      localAppBrandGlobalSystemConfig.jCS = paramString.optDouble("GamePerfCollectSamplePercentage", 0.0D);
      localAppBrandGlobalSystemConfig.jCT = paramString.optInt("GamePerfCollectInterval", 60);
      localAppBrandGlobalSystemConfig.jCU = paramString.optInt("PerformIndexReportGapInSeconds", 60);
      localAppBrandGlobalSystemConfig.jCX = paramString.optLong("OpendataMaxFileStorageSize", 30L);
      localObject1 = paramString.optJSONArray("PreDownloadUserNameBlackList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        break label1053;
      }
      localAppBrandGlobalSystemConfig.jCY = a.jDe;
    }
    for (;;)
    {
      localAppBrandGlobalSystemConfig.jCZ = paramString.optInt("WXDataMaxRequestConcurrent", 10);
      localAppBrandGlobalSystemConfig.jDa = paramString.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
      AppMethodBeat.o(146984);
      return localAppBrandGlobalSystemConfig;
      localAppBrandGlobalSystemConfig.jCR = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.jCR[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
      break;
      label1053:
      localAppBrandGlobalSystemConfig.jCY = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.jCY[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
    }
  }
  
  static void baq()
  {
    try
    {
      jCs = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String bar()
  {
    AppMethodBeat.i(146981);
    Object localObject = new e(b.apa().replace("/data/user/0", "/data/data"), "wxaapp/res/");
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    localObject = q.B(new e((e)localObject, "AppService.conf").fxV());
    AppMethodBeat.o(146981);
    return localObject;
  }
  
  /* Error */
  private static AppBrandGlobalSystemConfig bas()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 518
    //   6: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 467	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jCs	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +79 -> 93
    //   17: invokestatic 520	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bar	()Ljava/lang/String;
    //   20: invokestatic 525	com/tencent/mm/vfs/i:aSr	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic 529	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
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
    //   78: invokestatic 306	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -59 -> 24
    //   86: aload_0
    //   87: invokestatic 544	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:JR	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   90: putstatic 467	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jCs	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   93: getstatic 467	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jCs	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
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
  
  public static AppBrandGlobalSystemConfig bat()
  {
    AppMethodBeat.i(146983);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = bas();
    if (localAppBrandGlobalSystemConfig == null)
    {
      localAppBrandGlobalSystemConfig = jCt;
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
    paramParcel.writeInt(this.jCu);
    paramParcel.writeInt(this.jCv);
    paramParcel.writeInt(this.jCw);
    paramParcel.writeInt(this.jCx);
    paramParcel.writeInt(this.jCy);
    paramParcel.writeInt(this.jCz);
    paramParcel.writeInt(this.jCA);
    paramParcel.writeInt(this.jCB);
    paramParcel.writeString(this.jCC);
    paramParcel.writeString(this.jCD);
    paramParcel.writeParcelable(this.jCE, paramInt);
    paramParcel.writeIntArray(this.jCF);
    paramParcel.writeInt(this.jCG);
    paramParcel.writeInt(this.jCH);
    paramParcel.writeInt(this.jCK);
    paramParcel.writeInt(this.jCL);
    paramParcel.writeInt(this.jCM);
    paramParcel.writeInt(this.jCN);
    paramParcel.writeInt(this.jCO);
    paramParcel.writeInt(this.jCP);
    paramParcel.writeInt(this.jCQ);
    paramParcel.writeStringArray(this.jCR);
    paramParcel.writeDouble(this.jCS);
    paramParcel.writeInt(this.jCT);
    paramParcel.writeParcelable(this.jCV, paramInt);
    paramParcel.writeParcelable(this.jCW, paramInt);
    paramParcel.writeLong(this.jCX);
    paramParcel.writeStringArray(this.jCY);
    paramParcel.writeInt(this.jCZ);
    paramParcel.writeInt(this.jDb);
    paramParcel.writeInt(this.jDa);
    paramParcel.writeInt(this.jCU);
    AppMethodBeat.o(146986);
  }
  
  public static final class HttpSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<HttpSetting> CREATOR;
    public ArrayList<String> jDf;
    public ArrayList<String> jDg;
    public int jDh;
    public int jDi;
    public int jDj;
    public int jDk;
    public String jDl;
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
      this.jDf = paramParcel.createStringArrayList();
      this.jDg = paramParcel.createStringArrayList();
      this.jDh = paramParcel.readInt();
      this.jDi = paramParcel.readInt();
      this.jDj = paramParcel.readInt();
      this.jDk = paramParcel.readInt();
      this.jDl = paramParcel.readString();
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
      paramParcel.writeStringList(this.jDf);
      paramParcel.writeStringList(this.jDg);
      paramParcel.writeInt(this.jDh);
      paramParcel.writeInt(this.jDi);
      paramParcel.writeInt(this.jDj);
      paramParcel.writeInt(this.jDk);
      paramParcel.writeString(this.jDl);
      AppMethodBeat.o(146970);
    }
  }
  
  public static final class PackageManager
    implements Parcelable
  {
    public static final Parcelable.Creator<PackageManager> CREATOR;
    public long jDm;
    public long jDn;
    public long jDo;
    public int jDp;
    
    static
    {
      AppMethodBeat.i(146976);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146976);
    }
    
    public PackageManager()
    {
      this.jDm = 86400L;
      this.jDn = 864000L;
      this.jDo = 256L;
      this.jDp = 5;
    }
    
    protected PackageManager(Parcel paramParcel)
    {
      AppMethodBeat.i(146975);
      this.jDm = 86400L;
      this.jDn = 864000L;
      this.jDo = 256L;
      this.jDp = 5;
      this.jDm = paramParcel.readLong();
      this.jDn = paramParcel.readLong();
      this.jDo = paramParcel.readLong();
      this.jDp = paramParcel.readInt();
      AppMethodBeat.o(146975);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146974);
      paramParcel.writeLong(this.jDm);
      paramParcel.writeLong(this.jDn);
      paramParcel.writeLong(this.jDo);
      paramParcel.writeInt(this.jDp);
      AppMethodBeat.o(146974);
    }
  }
  
  public static final class WeAppSyncVersionSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<WeAppSyncVersionSetting> CREATOR;
    public long jDq;
    public long jDr;
    public int jDs;
    public int jDt;
    
    static
    {
      AppMethodBeat.i(146980);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146980);
    }
    
    WeAppSyncVersionSetting()
    {
      this.jDq = 21600L;
      this.jDr = 604800L;
      this.jDs = 1000;
      this.jDt = 100;
    }
    
    WeAppSyncVersionSetting(Parcel paramParcel)
    {
      AppMethodBeat.i(146979);
      this.jDq = 21600L;
      this.jDr = 604800L;
      this.jDs = 1000;
      this.jDt = 100;
      this.jDq = paramParcel.readLong();
      this.jDr = paramParcel.readLong();
      this.jDs = paramParcel.readInt();
      this.jDt = paramParcel.readInt();
      AppMethodBeat.o(146979);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146978);
      paramParcel.writeLong(this.jDq);
      paramParcel.writeLong(this.jDr);
      paramParcel.writeInt(this.jDs);
      paramParcel.writeInt(this.jDt);
      AppMethodBeat.o(146978);
    }
  }
  
  public static abstract interface a
  {
    public static final int[] jDc = new int[0];
    public static final String[] jDd = { "https://wx.qlogo.cn/" };
    public static final String[] jDe = new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig
 * JD-Core Version:    0.7.0.1
 */