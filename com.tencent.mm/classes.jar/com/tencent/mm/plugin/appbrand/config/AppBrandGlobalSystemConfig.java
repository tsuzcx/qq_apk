package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandGlobalSystemConfig> CREATOR;
  private static volatile AppBrandGlobalSystemConfig lcG;
  public static final AppBrandGlobalSystemConfig lcH;
  public int lcI;
  public int lcJ;
  public int lcK;
  public int lcL;
  public int lcM;
  public int lcN;
  public int lcO;
  public int lcP;
  public String lcQ;
  public String lcR;
  public HttpSetting lcS;
  public int[] lcT;
  public int lcU;
  public int lcV;
  public int lcW;
  public int lcX;
  public int lcY;
  public int lcZ;
  public int lda;
  public int ldb;
  public int ldc;
  public int ldd;
  public int lde;
  public String[] ldf;
  public double ldg;
  public int ldh;
  public int ldi;
  public WeAppSyncVersionSetting ldj;
  public PackageManager ldk;
  public long ldl;
  public String[] ldm;
  public int ldn;
  public int ldo;
  public int ldp;
  
  static
  {
    AppMethodBeat.i(146988);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
    lcH = localAppBrandGlobalSystemConfig;
    localAppBrandGlobalSystemConfig.lcJ = 5;
    lcH.lcK = 1;
    lcH.lcL = 300;
    lcH.lcM = 50;
    lcH.lcN = 1048576;
    lcH.lcO = 1048576;
    lcH.lcP = 20971520;
    lcH.lcT = a.ldr;
    lcH.lcU = 50;
    lcH.lcV = 11;
    lcH.lcW = 12;
    lcH.lcY = 1800;
    lcH.lcZ = 307200;
    lcH.lda = 25;
    lcH.ldb = 10485760;
    lcH.ldc = 314572800;
    lcH.ldd = 1;
    lcH.lde = 50;
    lcH.ldf = a.lds;
    lcH.ldg = 0.0D;
    lcH.ldh = 60;
    lcH.ldi = 60;
    lcH.ldj = new WeAppSyncVersionSetting();
    lcH.ldk = new PackageManager();
    lcH.ldl = 30L;
    lcH.ldm = a.ldt;
    lcH.ldn = 10;
    lcH.ldp = 86400;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146988);
  }
  
  private AppBrandGlobalSystemConfig()
  {
    AppMethodBeat.i(146985);
    this.lcI = 2147483647;
    this.lcS = new HttpSetting();
    AppMethodBeat.o(146985);
  }
  
  protected AppBrandGlobalSystemConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(146987);
    this.lcI = 2147483647;
    this.lcS = new HttpSetting();
    this.lcI = paramParcel.readInt();
    this.lcJ = paramParcel.readInt();
    this.lcK = paramParcel.readInt();
    this.lcL = paramParcel.readInt();
    this.lcM = paramParcel.readInt();
    this.lcN = paramParcel.readInt();
    this.lcO = paramParcel.readInt();
    this.lcP = paramParcel.readInt();
    this.lcQ = paramParcel.readString();
    this.lcR = paramParcel.readString();
    this.lcS = ((HttpSetting)paramParcel.readParcelable(HttpSetting.class.getClassLoader()));
    this.lcT = paramParcel.createIntArray();
    this.lcU = paramParcel.readInt();
    this.lcV = paramParcel.readInt();
    this.lcY = paramParcel.readInt();
    this.lcZ = paramParcel.readInt();
    this.lda = paramParcel.readInt();
    this.ldb = paramParcel.readInt();
    this.ldc = paramParcel.readInt();
    this.ldd = paramParcel.readInt();
    this.lde = paramParcel.readInt();
    this.ldf = paramParcel.createStringArray();
    this.ldg = paramParcel.readDouble();
    this.ldh = paramParcel.readInt();
    this.ldj = ((WeAppSyncVersionSetting)paramParcel.readParcelable(WeAppSyncVersionSetting.class.getClassLoader()));
    this.ldk = ((PackageManager)paramParcel.readParcelable(PackageManager.class.getClassLoader()));
    this.ldl = paramParcel.readLong();
    this.ldm = paramParcel.createStringArray();
    this.ldn = paramParcel.readInt();
    this.ldp = paramParcel.readInt();
    this.ldo = paramParcel.readInt();
    this.ldi = paramParcel.readInt();
    AppMethodBeat.o(146987);
  }
  
  private static AppBrandGlobalSystemConfig WZ(String paramString)
  {
    AppMethodBeat.i(146984);
    Log.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[] { paramString });
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
        localAppBrandGlobalSystemConfig.lcS.mode = 1;
      }
      for (;;)
      {
        localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderBlackList");
        if (localObject2 == null) {
          break;
        }
        localAppBrandGlobalSystemConfig.lcS.ldu = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localAppBrandGlobalSystemConfig.lcS.ldu.add(((JSONArray)localObject2).getString(i));
          i += 1;
        }
        if (((String)localObject2).equals("WhiteList")) {
          localAppBrandGlobalSystemConfig.lcS.mode = 2;
        }
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderWhiteList");
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(146984);
      return null;
    }
    if (localObject2 != null)
    {
      localAppBrandGlobalSystemConfig.lcS.ldv = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        localAppBrandGlobalSystemConfig.lcS.ldv.add(((JSONArray)localObject2).getString(i));
        i += 1;
      }
    }
    localAppBrandGlobalSystemConfig.lcS.ldw = ((JSONObject)localObject1).optInt("WebsocketMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.lcS.ldx = ((JSONObject)localObject1).optInt("UploadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.lcS.ldy = ((JSONObject)localObject1).optInt("DownloadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.lcS.ldz = ((JSONObject)localObject1).optInt("RequestMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.lcS.ldA = ((JSONObject)localObject1).optString("HTTPHeaderReferer");
    label326:
    localAppBrandGlobalSystemConfig.ldj = new WeAppSyncVersionSetting();
    Object localObject1 = paramString.optJSONObject("SyncVersionSetting");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.ldj.ldF = ((JSONObject)localObject1).optLong("PullVersionInterval", localAppBrandGlobalSystemConfig.ldj.ldF);
      localAppBrandGlobalSystemConfig.ldj.ldG = ((JSONObject)localObject1).optLong("PullVersionWxaUsageLastInterval", localAppBrandGlobalSystemConfig.ldj.ldG);
      localAppBrandGlobalSystemConfig.ldj.ldH = ((JSONObject)localObject1).optInt("PullVersionMaxCount", localAppBrandGlobalSystemConfig.ldj.ldH);
      localAppBrandGlobalSystemConfig.ldj.ldI = ((JSONObject)localObject1).optInt("PullVersionMaxCountPerRequest", localAppBrandGlobalSystemConfig.ldj.ldI);
    }
    localAppBrandGlobalSystemConfig.ldk = new PackageManager();
    localObject1 = paramString.optJSONObject("PackageManager");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.ldk.ldB = ((JSONObject)localObject1).optLong("CheckInterval", localAppBrandGlobalSystemConfig.ldk.ldB);
      localAppBrandGlobalSystemConfig.ldk.ldC = ((JSONObject)localObject1).optLong("WithoutContactClearSeconds", localAppBrandGlobalSystemConfig.ldk.ldC);
      localAppBrandGlobalSystemConfig.ldk.ldD = ((JSONObject)localObject1).optLong("ClientStorageMinMB", localAppBrandGlobalSystemConfig.ldk.ldD);
      localAppBrandGlobalSystemConfig.ldk.ldE = ((JSONObject)localObject1).optInt("WholeClientStoragePercent", localAppBrandGlobalSystemConfig.ldk.ldE);
    }
    localAppBrandGlobalSystemConfig.lcQ = paramString.optString("CDNBaseURL");
    localAppBrandGlobalSystemConfig.lcR = paramString.optString("CDNPreConnectURL", a.ldq);
    localAppBrandGlobalSystemConfig.lcJ = paramString.optInt("AppMaxRunningCount", 5);
    localAppBrandGlobalSystemConfig.lcK = paramString.optInt("AppSharedResourceBackgroundRunningCount", 1);
    localAppBrandGlobalSystemConfig.lcL = paramString.optInt("TempFileSizeLimitTotal", 300);
    localAppBrandGlobalSystemConfig.lcM = paramString.optInt("DownloadFileSizeLimit", 50);
    localAppBrandGlobalSystemConfig.lcN = paramString.optInt("MaxLocalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.lcO = paramString.optInt("MaxGlobalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.lcP = paramString.optInt("MaxGlobalStorageSize", 20971520);
    localAppBrandGlobalSystemConfig.ldb = paramString.optInt("NativeBufferSizeLimitByte", 10485760);
    localAppBrandGlobalSystemConfig.ldc = paramString.optInt("NativeBufferQueueLimitByte", 314572800);
    localAppBrandGlobalSystemConfig.ldp = paramString.optInt("WeUseRecallInterval", 86400);
    localObject1 = paramString.optJSONArray("SyncLaunchSceneList");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.lcT = new int[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.lcT[i] = ((JSONArray)localObject1).optInt(i, 0);
        i += 1;
      }
    }
    if (localAppBrandGlobalSystemConfig.lcT == null) {
      localAppBrandGlobalSystemConfig.lcT = a.ldr;
    }
    localAppBrandGlobalSystemConfig.lcU = paramString.optInt("StarNumberLimitation", 50);
    localAppBrandGlobalSystemConfig.lcV = paramString.optInt("TaskBarItemCountLimitation", 11);
    localAppBrandGlobalSystemConfig.lcW = paramString.optInt("NewTaskBarRecentsItemCountLimitation", 12);
    localAppBrandGlobalSystemConfig.lcX = paramString.optInt("TaskBarSyncUsageRecordIntervalMinute", 20);
    localAppBrandGlobalSystemConfig.lcY = paramString.optInt("WidgetImageFlowLimitDuration", 1800);
    localAppBrandGlobalSystemConfig.lcZ = paramString.optInt("WidgetImageFlowLimitMaxSize", 307200);
    localAppBrandGlobalSystemConfig.lda = paramString.optInt("WidgetDrawMinInterval", 25);
    localAppBrandGlobalSystemConfig.ldd = paramString.optInt("GameMaxRunningCount", 1);
    localAppBrandGlobalSystemConfig.lde = paramString.optInt("GameDownloadFileSizeLimit", 50);
    localObject1 = paramString.optJSONArray("SubContextImgDomain");
    if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
    {
      localAppBrandGlobalSystemConfig.ldf = a.lds;
      localAppBrandGlobalSystemConfig.ldg = paramString.optDouble("GamePerfCollectSamplePercentage", 0.0D);
      localAppBrandGlobalSystemConfig.ldh = paramString.optInt("GamePerfCollectInterval", 60);
      localAppBrandGlobalSystemConfig.ldi = paramString.optInt("PerformIndexReportGapInSeconds", 60);
      localAppBrandGlobalSystemConfig.ldl = paramString.optLong("OpendataMaxFileStorageSize", 30L);
      localObject1 = paramString.optJSONArray("PreDownloadUserNameBlackList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        break label1053;
      }
      localAppBrandGlobalSystemConfig.ldm = a.ldt;
    }
    for (;;)
    {
      localAppBrandGlobalSystemConfig.ldn = paramString.optInt("WXDataMaxRequestConcurrent", 10);
      localAppBrandGlobalSystemConfig.ldo = paramString.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
      AppMethodBeat.o(146984);
      return localAppBrandGlobalSystemConfig;
      localAppBrandGlobalSystemConfig.ldf = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.ldf[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
      break;
      label1053:
      localAppBrandGlobalSystemConfig.ldm = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.ldm[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
    }
  }
  
  static void bzM()
  {
    try
    {
      lcG = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String bzN()
  {
    AppMethodBeat.i(146981);
    Object localObject = new o(b.aKC().replace("/data/user/0", "/data/data"), "wxaapp/res/");
    if (!((o)localObject).exists()) {
      ((o)localObject).mkdirs();
    }
    localObject = aa.z(new o((o)localObject, "AppService.conf").her());
    AppMethodBeat.o(146981);
    return localObject;
  }
  
  /* Error */
  private static AppBrandGlobalSystemConfig bzO()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 519
    //   6: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 468	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:lcG	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +79 -> 93
    //   17: invokestatic 521	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bzN	()Ljava/lang/String;
    //   20: invokestatic 526	com/tencent/mm/vfs/s:boY	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic 530	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   28: ifeq +58 -> 86
    //   31: ldc_w 519
    //   34: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: ldc_w 532
    //   48: invokestatic 538	com/tencent/luggage/a/e:M	(Ljava/lang/Class;)Lcom/tencent/luggage/a/b;
    //   51: checkcast 532	com/tencent/luggage/sdk/customize/a
    //   54: invokeinterface 541 1 0
    //   59: aconst_null
    //   60: astore_0
    //   61: goto -37 -> 24
    //   64: astore_0
    //   65: ldc 230
    //   67: ldc_w 543
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: invokestatic 306	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -59 -> 24
    //   86: aload_0
    //   87: invokestatic 545	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:WZ	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   90: putstatic 468	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:lcG	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   93: getstatic 468	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:lcG	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   96: astore_0
    //   97: ldc_w 519
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
  
  public static AppBrandGlobalSystemConfig bzP()
  {
    AppMethodBeat.i(146983);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = bzO();
    if (localAppBrandGlobalSystemConfig == null)
    {
      localAppBrandGlobalSystemConfig = lcH;
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
    paramParcel.writeInt(this.lcI);
    paramParcel.writeInt(this.lcJ);
    paramParcel.writeInt(this.lcK);
    paramParcel.writeInt(this.lcL);
    paramParcel.writeInt(this.lcM);
    paramParcel.writeInt(this.lcN);
    paramParcel.writeInt(this.lcO);
    paramParcel.writeInt(this.lcP);
    paramParcel.writeString(this.lcQ);
    paramParcel.writeString(this.lcR);
    paramParcel.writeParcelable(this.lcS, paramInt);
    paramParcel.writeIntArray(this.lcT);
    paramParcel.writeInt(this.lcU);
    paramParcel.writeInt(this.lcV);
    paramParcel.writeInt(this.lcY);
    paramParcel.writeInt(this.lcZ);
    paramParcel.writeInt(this.lda);
    paramParcel.writeInt(this.ldb);
    paramParcel.writeInt(this.ldc);
    paramParcel.writeInt(this.ldd);
    paramParcel.writeInt(this.lde);
    paramParcel.writeStringArray(this.ldf);
    paramParcel.writeDouble(this.ldg);
    paramParcel.writeInt(this.ldh);
    paramParcel.writeParcelable(this.ldj, paramInt);
    paramParcel.writeParcelable(this.ldk, paramInt);
    paramParcel.writeLong(this.ldl);
    paramParcel.writeStringArray(this.ldm);
    paramParcel.writeInt(this.ldn);
    paramParcel.writeInt(this.ldp);
    paramParcel.writeInt(this.ldo);
    paramParcel.writeInt(this.ldi);
    AppMethodBeat.o(146986);
  }
  
  public static final class HttpSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<HttpSetting> CREATOR;
    public String ldA;
    public ArrayList<String> ldu;
    public ArrayList<String> ldv;
    public int ldw;
    public int ldx;
    public int ldy;
    public int ldz;
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
      this.ldu = paramParcel.createStringArrayList();
      this.ldv = paramParcel.createStringArrayList();
      this.ldw = paramParcel.readInt();
      this.ldx = paramParcel.readInt();
      this.ldy = paramParcel.readInt();
      this.ldz = paramParcel.readInt();
      this.ldA = paramParcel.readString();
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
      paramParcel.writeStringList(this.ldu);
      paramParcel.writeStringList(this.ldv);
      paramParcel.writeInt(this.ldw);
      paramParcel.writeInt(this.ldx);
      paramParcel.writeInt(this.ldy);
      paramParcel.writeInt(this.ldz);
      paramParcel.writeString(this.ldA);
      AppMethodBeat.o(146970);
    }
  }
  
  public static final class PackageManager
    implements Parcelable
  {
    public static final Parcelable.Creator<PackageManager> CREATOR;
    public long ldB;
    public long ldC;
    public long ldD;
    public int ldE;
    
    static
    {
      AppMethodBeat.i(146976);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146976);
    }
    
    public PackageManager()
    {
      this.ldB = 86400L;
      this.ldC = 864000L;
      this.ldD = 256L;
      this.ldE = 5;
    }
    
    protected PackageManager(Parcel paramParcel)
    {
      AppMethodBeat.i(146975);
      this.ldB = 86400L;
      this.ldC = 864000L;
      this.ldD = 256L;
      this.ldE = 5;
      this.ldB = paramParcel.readLong();
      this.ldC = paramParcel.readLong();
      this.ldD = paramParcel.readLong();
      this.ldE = paramParcel.readInt();
      AppMethodBeat.o(146975);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146974);
      paramParcel.writeLong(this.ldB);
      paramParcel.writeLong(this.ldC);
      paramParcel.writeLong(this.ldD);
      paramParcel.writeInt(this.ldE);
      AppMethodBeat.o(146974);
    }
  }
  
  public static final class WeAppSyncVersionSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<WeAppSyncVersionSetting> CREATOR;
    public long ldF;
    public long ldG;
    public int ldH;
    public int ldI;
    
    static
    {
      AppMethodBeat.i(146980);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146980);
    }
    
    WeAppSyncVersionSetting()
    {
      this.ldF = 21600L;
      this.ldG = 604800L;
      this.ldH = 1000;
      this.ldI = 100;
    }
    
    WeAppSyncVersionSetting(Parcel paramParcel)
    {
      AppMethodBeat.i(146979);
      this.ldF = 21600L;
      this.ldG = 604800L;
      this.ldH = 1000;
      this.ldI = 100;
      this.ldF = paramParcel.readLong();
      this.ldG = paramParcel.readLong();
      this.ldH = paramParcel.readInt();
      this.ldI = paramParcel.readInt();
      AppMethodBeat.o(146979);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146978);
      paramParcel.writeLong(this.ldF);
      paramParcel.writeLong(this.ldG);
      paramParcel.writeInt(this.ldH);
      paramParcel.writeInt(this.ldI);
      AppMethodBeat.o(146978);
    }
  }
  
  public static abstract interface a
  {
    public static final String ldq = "https://" + WeChatHosts.domainString(2131761735);
    public static final int[] ldr = new int[0];
    public static final String[] lds = { "https://wx.qlogo.cn/" };
    public static final String[] ldt = new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig
 * JD-Core Version:    0.7.0.1
 */