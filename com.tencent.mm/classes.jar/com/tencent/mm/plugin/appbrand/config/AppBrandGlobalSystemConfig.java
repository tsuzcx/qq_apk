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
  private static volatile AppBrandGlobalSystemConfig jcf;
  public static final AppBrandGlobalSystemConfig jcg;
  public int jcA;
  public int jcB;
  public int jcC;
  public int jcD;
  public String[] jcE;
  public double jcF;
  public int jcG;
  public int jcH;
  public WeAppSyncVersionSetting jcI;
  public PackageManager jcJ;
  public long jcK;
  public String[] jcL;
  public int jcM;
  public int jcN;
  public int jcO;
  public int jch;
  public int jci;
  public int jcj;
  public int jck;
  public int jcl;
  public int jcm;
  public int jcn;
  public int jco;
  public String jcp;
  public String jcq;
  public HttpSetting jcr;
  public int[] jcs;
  public int jct;
  public int jcu;
  public int jcv;
  public int jcw;
  public int jcx;
  public int jcy;
  public int jcz;
  
  static
  {
    AppMethodBeat.i(146988);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
    jcg = localAppBrandGlobalSystemConfig;
    localAppBrandGlobalSystemConfig.jci = 5;
    jcg.jcj = 1;
    jcg.jck = 300;
    jcg.jcl = 50;
    jcg.jcm = 1048576;
    jcg.jcn = 1048576;
    jcg.jco = 20971520;
    jcg.jcs = a.jcP;
    jcg.jct = 50;
    jcg.jcu = 11;
    jcg.jcv = 12;
    jcg.jcx = 1800;
    jcg.jcy = 307200;
    jcg.jcz = 25;
    jcg.jcA = 10485760;
    jcg.jcB = 314572800;
    jcg.jcC = 1;
    jcg.jcD = 50;
    jcg.jcE = a.jcQ;
    jcg.jcF = 0.0D;
    jcg.jcG = 60;
    jcg.jcH = 60;
    jcg.jcI = new WeAppSyncVersionSetting();
    jcg.jcJ = new PackageManager();
    jcg.jcK = 30L;
    jcg.jcL = a.jcR;
    jcg.jcM = 10;
    jcg.jcO = 86400;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146988);
  }
  
  private AppBrandGlobalSystemConfig()
  {
    AppMethodBeat.i(146985);
    this.jch = 2147483647;
    this.jcr = new HttpSetting();
    AppMethodBeat.o(146985);
  }
  
  protected AppBrandGlobalSystemConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(146987);
    this.jch = 2147483647;
    this.jcr = new HttpSetting();
    this.jch = paramParcel.readInt();
    this.jci = paramParcel.readInt();
    this.jcj = paramParcel.readInt();
    this.jck = paramParcel.readInt();
    this.jcl = paramParcel.readInt();
    this.jcm = paramParcel.readInt();
    this.jcn = paramParcel.readInt();
    this.jco = paramParcel.readInt();
    this.jcp = paramParcel.readString();
    this.jcq = paramParcel.readString();
    this.jcr = ((HttpSetting)paramParcel.readParcelable(HttpSetting.class.getClassLoader()));
    this.jcs = paramParcel.createIntArray();
    this.jct = paramParcel.readInt();
    this.jcu = paramParcel.readInt();
    this.jcx = paramParcel.readInt();
    this.jcy = paramParcel.readInt();
    this.jcz = paramParcel.readInt();
    this.jcA = paramParcel.readInt();
    this.jcB = paramParcel.readInt();
    this.jcC = paramParcel.readInt();
    this.jcD = paramParcel.readInt();
    this.jcE = paramParcel.createStringArray();
    this.jcF = paramParcel.readDouble();
    this.jcG = paramParcel.readInt();
    this.jcI = ((WeAppSyncVersionSetting)paramParcel.readParcelable(WeAppSyncVersionSetting.class.getClassLoader()));
    this.jcJ = ((PackageManager)paramParcel.readParcelable(PackageManager.class.getClassLoader()));
    this.jcK = paramParcel.readLong();
    this.jcL = paramParcel.createStringArray();
    this.jcM = paramParcel.readInt();
    this.jcO = paramParcel.readInt();
    this.jcN = paramParcel.readInt();
    this.jcH = paramParcel.readInt();
    AppMethodBeat.o(146987);
  }
  
  private static AppBrandGlobalSystemConfig FN(String paramString)
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
        localAppBrandGlobalSystemConfig.jcr.mode = 1;
      }
      for (;;)
      {
        localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderBlackList");
        if (localObject2 == null) {
          break;
        }
        localAppBrandGlobalSystemConfig.jcr.jcS = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localAppBrandGlobalSystemConfig.jcr.jcS.add(((JSONArray)localObject2).getString(i));
          i += 1;
        }
        if (((String)localObject2).equals("WhiteList")) {
          localAppBrandGlobalSystemConfig.jcr.mode = 2;
        }
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderWhiteList");
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(146984);
      return null;
    }
    if (localObject2 != null)
    {
      localAppBrandGlobalSystemConfig.jcr.jcT = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        localAppBrandGlobalSystemConfig.jcr.jcT.add(((JSONArray)localObject2).getString(i));
        i += 1;
      }
    }
    localAppBrandGlobalSystemConfig.jcr.jcU = ((JSONObject)localObject1).optInt("WebsocketMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jcr.jcV = ((JSONObject)localObject1).optInt("UploadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jcr.jcW = ((JSONObject)localObject1).optInt("DownloadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jcr.jcX = ((JSONObject)localObject1).optInt("RequestMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.jcr.jcY = ((JSONObject)localObject1).optString("HTTPHeaderReferer");
    label326:
    localAppBrandGlobalSystemConfig.jcI = new WeAppSyncVersionSetting();
    Object localObject1 = paramString.optJSONObject("SyncVersionSetting");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.jcI.jdd = ((JSONObject)localObject1).optLong("PullVersionInterval", localAppBrandGlobalSystemConfig.jcI.jdd);
      localAppBrandGlobalSystemConfig.jcI.jde = ((JSONObject)localObject1).optLong("PullVersionWxaUsageLastInterval", localAppBrandGlobalSystemConfig.jcI.jde);
      localAppBrandGlobalSystemConfig.jcI.jdf = ((JSONObject)localObject1).optInt("PullVersionMaxCount", localAppBrandGlobalSystemConfig.jcI.jdf);
      localAppBrandGlobalSystemConfig.jcI.jdg = ((JSONObject)localObject1).optInt("PullVersionMaxCountPerRequest", localAppBrandGlobalSystemConfig.jcI.jdg);
    }
    localAppBrandGlobalSystemConfig.jcJ = new PackageManager();
    localObject1 = paramString.optJSONObject("PackageManager");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.jcJ.jcZ = ((JSONObject)localObject1).optLong("CheckInterval", localAppBrandGlobalSystemConfig.jcJ.jcZ);
      localAppBrandGlobalSystemConfig.jcJ.jda = ((JSONObject)localObject1).optLong("WithoutContactClearSeconds", localAppBrandGlobalSystemConfig.jcJ.jda);
      localAppBrandGlobalSystemConfig.jcJ.jdb = ((JSONObject)localObject1).optLong("ClientStorageMinMB", localAppBrandGlobalSystemConfig.jcJ.jdb);
      localAppBrandGlobalSystemConfig.jcJ.jdc = ((JSONObject)localObject1).optInt("WholeClientStoragePercent", localAppBrandGlobalSystemConfig.jcJ.jdc);
    }
    localAppBrandGlobalSystemConfig.jcp = paramString.optString("CDNBaseURL");
    localAppBrandGlobalSystemConfig.jcq = paramString.optString("CDNPreConnectURL", "https://res.servicewechat.com");
    localAppBrandGlobalSystemConfig.jci = paramString.optInt("AppMaxRunningCount", 5);
    localAppBrandGlobalSystemConfig.jcj = paramString.optInt("AppSharedResourceBackgroundRunningCount", 1);
    localAppBrandGlobalSystemConfig.jck = paramString.optInt("TempFileSizeLimitTotal", 300);
    localAppBrandGlobalSystemConfig.jcl = paramString.optInt("DownloadFileSizeLimit", 50);
    localAppBrandGlobalSystemConfig.jcm = paramString.optInt("MaxLocalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.jcn = paramString.optInt("MaxGlobalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.jco = paramString.optInt("MaxGlobalStorageSize", 20971520);
    localAppBrandGlobalSystemConfig.jcA = paramString.optInt("NativeBufferSizeLimitByte", 10485760);
    localAppBrandGlobalSystemConfig.jcB = paramString.optInt("NativeBufferQueueLimitByte", 314572800);
    localAppBrandGlobalSystemConfig.jcO = paramString.optInt("WeUseRecallInterval", 86400);
    localObject1 = paramString.optJSONArray("SyncLaunchSceneList");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.jcs = new int[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.jcs[i] = ((JSONArray)localObject1).optInt(i, 0);
        i += 1;
      }
    }
    if (localAppBrandGlobalSystemConfig.jcs == null) {
      localAppBrandGlobalSystemConfig.jcs = a.jcP;
    }
    localAppBrandGlobalSystemConfig.jct = paramString.optInt("StarNumberLimitation", 50);
    localAppBrandGlobalSystemConfig.jcu = paramString.optInt("TaskBarItemCountLimitation", 11);
    localAppBrandGlobalSystemConfig.jcv = paramString.optInt("NewTaskBarRecentsItemCountLimitation", 12);
    localAppBrandGlobalSystemConfig.jcw = paramString.optInt("TaskBarSyncUsageRecordIntervalMinute", 20);
    localAppBrandGlobalSystemConfig.jcx = paramString.optInt("WidgetImageFlowLimitDuration", 1800);
    localAppBrandGlobalSystemConfig.jcy = paramString.optInt("WidgetImageFlowLimitMaxSize", 307200);
    localAppBrandGlobalSystemConfig.jcz = paramString.optInt("WidgetDrawMinInterval", 25);
    localAppBrandGlobalSystemConfig.jcC = paramString.optInt("GameMaxRunningCount", 1);
    localAppBrandGlobalSystemConfig.jcD = paramString.optInt("GameDownloadFileSizeLimit", 50);
    localObject1 = paramString.optJSONArray("SubContextImgDomain");
    if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
    {
      localAppBrandGlobalSystemConfig.jcE = a.jcQ;
      localAppBrandGlobalSystemConfig.jcF = paramString.optDouble("GamePerfCollectSamplePercentage", 0.0D);
      localAppBrandGlobalSystemConfig.jcG = paramString.optInt("GamePerfCollectInterval", 60);
      localAppBrandGlobalSystemConfig.jcH = paramString.optInt("PerformIndexReportGapInSeconds", 60);
      localAppBrandGlobalSystemConfig.jcK = paramString.optLong("OpendataMaxFileStorageSize", 30L);
      localObject1 = paramString.optJSONArray("PreDownloadUserNameBlackList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        break label1053;
      }
      localAppBrandGlobalSystemConfig.jcL = a.jcR;
    }
    for (;;)
    {
      localAppBrandGlobalSystemConfig.jcM = paramString.optInt("WXDataMaxRequestConcurrent", 10);
      localAppBrandGlobalSystemConfig.jcN = paramString.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
      AppMethodBeat.o(146984);
      return localAppBrandGlobalSystemConfig;
      localAppBrandGlobalSystemConfig.jcE = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.jcE[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
      break;
      label1053:
      localAppBrandGlobalSystemConfig.jcL = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.jcL[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
    }
  }
  
  static void aTs()
  {
    try
    {
      jcf = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String aTt()
  {
    AppMethodBeat.i(146981);
    Object localObject = new e(b.aia().replace("/data/user/0", "/data/data"), "wxaapp/res/");
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    localObject = q.B(new e((e)localObject, "AppService.conf").fhU());
    AppMethodBeat.o(146981);
    return localObject;
  }
  
  /* Error */
  private static AppBrandGlobalSystemConfig aTu()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 518
    //   6: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 467	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jcf	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +79 -> 93
    //   17: invokestatic 520	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:aTt	()Ljava/lang/String;
    //   20: invokestatic 525	com/tencent/mm/vfs/i:aMP	(Ljava/lang/String;)Ljava/lang/String;
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
    //   87: invokestatic 544	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:FN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   90: putstatic 467	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jcf	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   93: getstatic 467	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jcf	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
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
  
  public static AppBrandGlobalSystemConfig aTv()
  {
    AppMethodBeat.i(146983);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = aTu();
    if (localAppBrandGlobalSystemConfig == null)
    {
      localAppBrandGlobalSystemConfig = jcg;
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
    paramParcel.writeInt(this.jch);
    paramParcel.writeInt(this.jci);
    paramParcel.writeInt(this.jcj);
    paramParcel.writeInt(this.jck);
    paramParcel.writeInt(this.jcl);
    paramParcel.writeInt(this.jcm);
    paramParcel.writeInt(this.jcn);
    paramParcel.writeInt(this.jco);
    paramParcel.writeString(this.jcp);
    paramParcel.writeString(this.jcq);
    paramParcel.writeParcelable(this.jcr, paramInt);
    paramParcel.writeIntArray(this.jcs);
    paramParcel.writeInt(this.jct);
    paramParcel.writeInt(this.jcu);
    paramParcel.writeInt(this.jcx);
    paramParcel.writeInt(this.jcy);
    paramParcel.writeInt(this.jcz);
    paramParcel.writeInt(this.jcA);
    paramParcel.writeInt(this.jcB);
    paramParcel.writeInt(this.jcC);
    paramParcel.writeInt(this.jcD);
    paramParcel.writeStringArray(this.jcE);
    paramParcel.writeDouble(this.jcF);
    paramParcel.writeInt(this.jcG);
    paramParcel.writeParcelable(this.jcI, paramInt);
    paramParcel.writeParcelable(this.jcJ, paramInt);
    paramParcel.writeLong(this.jcK);
    paramParcel.writeStringArray(this.jcL);
    paramParcel.writeInt(this.jcM);
    paramParcel.writeInt(this.jcO);
    paramParcel.writeInt(this.jcN);
    paramParcel.writeInt(this.jcH);
    AppMethodBeat.o(146986);
  }
  
  public static final class HttpSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<HttpSetting> CREATOR;
    public ArrayList<String> jcS;
    public ArrayList<String> jcT;
    public int jcU;
    public int jcV;
    public int jcW;
    public int jcX;
    public String jcY;
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
      this.jcS = paramParcel.createStringArrayList();
      this.jcT = paramParcel.createStringArrayList();
      this.jcU = paramParcel.readInt();
      this.jcV = paramParcel.readInt();
      this.jcW = paramParcel.readInt();
      this.jcX = paramParcel.readInt();
      this.jcY = paramParcel.readString();
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
      paramParcel.writeStringList(this.jcS);
      paramParcel.writeStringList(this.jcT);
      paramParcel.writeInt(this.jcU);
      paramParcel.writeInt(this.jcV);
      paramParcel.writeInt(this.jcW);
      paramParcel.writeInt(this.jcX);
      paramParcel.writeString(this.jcY);
      AppMethodBeat.o(146970);
    }
  }
  
  public static final class PackageManager
    implements Parcelable
  {
    public static final Parcelable.Creator<PackageManager> CREATOR;
    public long jcZ;
    public long jda;
    public long jdb;
    public int jdc;
    
    static
    {
      AppMethodBeat.i(146976);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146976);
    }
    
    public PackageManager()
    {
      this.jcZ = 86400L;
      this.jda = 864000L;
      this.jdb = 256L;
      this.jdc = 5;
    }
    
    protected PackageManager(Parcel paramParcel)
    {
      AppMethodBeat.i(146975);
      this.jcZ = 86400L;
      this.jda = 864000L;
      this.jdb = 256L;
      this.jdc = 5;
      this.jcZ = paramParcel.readLong();
      this.jda = paramParcel.readLong();
      this.jdb = paramParcel.readLong();
      this.jdc = paramParcel.readInt();
      AppMethodBeat.o(146975);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146974);
      paramParcel.writeLong(this.jcZ);
      paramParcel.writeLong(this.jda);
      paramParcel.writeLong(this.jdb);
      paramParcel.writeInt(this.jdc);
      AppMethodBeat.o(146974);
    }
  }
  
  public static final class WeAppSyncVersionSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<WeAppSyncVersionSetting> CREATOR;
    public long jdd;
    public long jde;
    public int jdf;
    public int jdg;
    
    static
    {
      AppMethodBeat.i(146980);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146980);
    }
    
    WeAppSyncVersionSetting()
    {
      this.jdd = 21600L;
      this.jde = 604800L;
      this.jdf = 1000;
      this.jdg = 100;
    }
    
    WeAppSyncVersionSetting(Parcel paramParcel)
    {
      AppMethodBeat.i(146979);
      this.jdd = 21600L;
      this.jde = 604800L;
      this.jdf = 1000;
      this.jdg = 100;
      this.jdd = paramParcel.readLong();
      this.jde = paramParcel.readLong();
      this.jdf = paramParcel.readInt();
      this.jdg = paramParcel.readInt();
      AppMethodBeat.o(146979);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146978);
      paramParcel.writeLong(this.jdd);
      paramParcel.writeLong(this.jde);
      paramParcel.writeInt(this.jdf);
      paramParcel.writeInt(this.jdg);
      AppMethodBeat.o(146978);
    }
  }
  
  public static abstract interface a
  {
    public static final int[] jcP = new int[0];
    public static final String[] jcQ = { "https://wx.qlogo.cn/" };
    public static final String[] jcR = new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig
 * JD-Core Version:    0.7.0.1
 */