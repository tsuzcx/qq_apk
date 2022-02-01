package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.LongSparseArray;
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.sdk.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandGlobalSystemConfig> CREATOR;
  private static volatile AppBrandGlobalSystemConfig qWF;
  public static final AppBrandGlobalSystemConfig qWG;
  public int qWH;
  public int qWI;
  public int qWJ;
  public int qWK;
  public int qWL;
  public int qWM;
  public int qWN;
  public int qWO;
  public String qWP;
  public String qWQ;
  public HttpSetting qWR;
  public int[] qWS;
  public int qWT;
  public int qWU;
  public int qWV;
  public int qWW;
  public int qWX;
  public int qWY;
  public int qWZ;
  public int qXa;
  public int qXb;
  public int qXc;
  public int qXd;
  public String[] qXe;
  public double qXf;
  public int qXg;
  public int qXh;
  public WeAppSyncVersionSetting qXi;
  public PackageManager qXj;
  public long qXk;
  public String[] qXl;
  public int qXm;
  public int qXn;
  public int qXo;
  public String[] qXp;
  public long qXq;
  public int qXr;
  public String qXs;
  public RelievedBuySetting qXt;
  
  static
  {
    AppMethodBeat.i(146988);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
    qWG = localAppBrandGlobalSystemConfig;
    localAppBrandGlobalSystemConfig.qWI = 5;
    qWG.qWJ = 1;
    qWG.qWK = 300;
    qWG.qWL = 50;
    qWG.qWM = 1048576;
    qWG.qWN = 1048576;
    qWG.qWO = 20971520;
    qWG.qWS = a.qXx;
    qWG.qWT = 50;
    qWG.qWU = 11;
    qWG.qWV = 12;
    qWG.qWX = 1800;
    qWG.qWY = 307200;
    qWG.qWZ = 25;
    qWG.qXa = 104857600;
    qWG.qXb = 314572800;
    qWG.qXc = 1;
    qWG.qXd = 50;
    qWG.qXe = a.qXy;
    qWG.qXf = 0.0D;
    qWG.qXg = 60;
    qWG.qXh = 60;
    qWG.qXi = new WeAppSyncVersionSetting();
    qWG.qXj = new PackageManager();
    qWG.qXk = 30L;
    qWG.qXl = a.qXz;
    qWG.qXm = 10;
    qWG.qXo = 86400;
    qWG.qXp = a.qXA;
    qWG.qXq = 60L;
    qWG.qXr = 1;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146988);
  }
  
  private AppBrandGlobalSystemConfig()
  {
    AppMethodBeat.i(146985);
    this.qWH = 2147483647;
    this.qWR = new HttpSetting();
    this.qXt = new RelievedBuySetting();
    AppMethodBeat.o(146985);
  }
  
  protected AppBrandGlobalSystemConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(146987);
    this.qWH = 2147483647;
    this.qWR = new HttpSetting();
    this.qXt = new RelievedBuySetting();
    this.qWH = paramParcel.readInt();
    this.qWI = paramParcel.readInt();
    this.qWJ = paramParcel.readInt();
    this.qWK = paramParcel.readInt();
    this.qWL = paramParcel.readInt();
    this.qWM = paramParcel.readInt();
    this.qWN = paramParcel.readInt();
    this.qWO = paramParcel.readInt();
    this.qWP = paramParcel.readString();
    this.qWQ = paramParcel.readString();
    this.qWR = ((HttpSetting)paramParcel.readParcelable(HttpSetting.class.getClassLoader()));
    this.qWS = paramParcel.createIntArray();
    this.qWT = paramParcel.readInt();
    this.qWU = paramParcel.readInt();
    this.qWX = paramParcel.readInt();
    this.qWY = paramParcel.readInt();
    this.qWZ = paramParcel.readInt();
    this.qXa = paramParcel.readInt();
    this.qXb = paramParcel.readInt();
    this.qXc = paramParcel.readInt();
    this.qXd = paramParcel.readInt();
    this.qXe = paramParcel.createStringArray();
    this.qXf = paramParcel.readDouble();
    this.qXg = paramParcel.readInt();
    this.qXi = ((WeAppSyncVersionSetting)paramParcel.readParcelable(WeAppSyncVersionSetting.class.getClassLoader()));
    this.qXj = ((PackageManager)paramParcel.readParcelable(PackageManager.class.getClassLoader()));
    this.qXk = paramParcel.readLong();
    this.qXl = paramParcel.createStringArray();
    this.qXm = paramParcel.readInt();
    this.qXo = paramParcel.readInt();
    this.qXn = paramParcel.readInt();
    this.qXh = paramParcel.readInt();
    this.qXp = paramParcel.createStringArray();
    this.qXq = paramParcel.readLong();
    this.qXr = paramParcel.readInt();
    this.qXs = paramParcel.readString();
    this.qXt = ((RelievedBuySetting)paramParcel.readParcelable(RelievedBuySetting.class.getClassLoader()));
    AppMethodBeat.o(146987);
  }
  
  private static AppBrandGlobalSystemConfig Xn(String paramString)
  {
    AppMethodBeat.i(146984);
    Log.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[] { paramString });
    JSONObject localJSONObject;
    Object localObject2;
    int i;
    try
    {
      localJSONObject = new JSONObject(paramString);
      paramString = new AppBrandGlobalSystemConfig();
      localObject1 = localJSONObject.optJSONObject("HTTPSetting");
      if (localObject1 == null) {
        break label334;
      }
      localObject2 = ((JSONObject)localObject1).optString("HTTPHeaderMode", "");
      if (((String)localObject2).equals("BlackList")) {
        paramString.qWR.mode = 1;
      }
      for (;;)
      {
        localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderBlackList");
        if (localObject2 == null) {
          break;
        }
        paramString.qWR.qXB = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          paramString.qWR.qXB.add(((JSONArray)localObject2).getString(i));
          i += 1;
        }
        if (((String)localObject2).equals("WhiteList")) {
          paramString.qWR.mode = 2;
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
      paramString.qWR.qXC = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        paramString.qWR.qXC.add(((JSONArray)localObject2).getString(i));
        i += 1;
      }
    }
    paramString.qWR.qXD = ((JSONObject)localObject1).optInt("WebsocketMaxTimeoutMS", -1);
    paramString.qWR.qXE = ((JSONObject)localObject1).optInt("UploadMaxTimeoutMS", -1);
    paramString.qWR.qXF = ((JSONObject)localObject1).optInt("DownloadMaxTimeoutMS", -1);
    paramString.qWR.qXG = ((JSONObject)localObject1).optInt("RequestMaxTimeoutMS", -1);
    paramString.qWR.qXH = ((JSONObject)localObject1).optString("HTTPHeaderReferer");
    label334:
    paramString.qXi = new WeAppSyncVersionSetting();
    Object localObject1 = localJSONObject.optJSONObject("SyncVersionSetting");
    if (localObject1 != null)
    {
      paramString.qXi.qXS = ((JSONObject)localObject1).optLong("PullVersionInterval", paramString.qXi.qXS);
      paramString.qXi.qXT = ((JSONObject)localObject1).optLong("PullVersionWxaUsageLastInterval", paramString.qXi.qXT);
      paramString.qXi.qXU = ((JSONObject)localObject1).optInt("PullVersionMaxCount", paramString.qXi.qXU);
      paramString.qXi.qXV = ((JSONObject)localObject1).optInt("PullVersionMaxCountPerRequest", paramString.qXi.qXV);
      if (((JSONObject)localObject1).has("PreDownloadList"))
      {
        paramString.qXi.qXW = new LongSparseArray();
        c.a(((JSONObject)localObject1).getJSONArray("PreDownloadList"), new kotlin.g.a.b()
        {
          private kotlin.ah Q(JSONObject paramAnonymousJSONObject)
          {
            AppMethodBeat.i(323479);
            try
            {
              final LinkedList localLinkedList = new LinkedList();
              c.a(paramAnonymousJSONObject.getJSONArray("list"), new kotlin.g.a.b() {});
              AppBrandGlobalSystemConfig.this.qXi.qXW.put(paramAnonymousJSONObject.getLong("UsedTime"), localLinkedList);
              label51:
              paramAnonymousJSONObject = kotlin.ah.aiuX;
              AppMethodBeat.o(323479);
              return paramAnonymousJSONObject;
            }
            catch (JSONException paramAnonymousJSONObject)
            {
              break label51;
            }
          }
        });
      }
      paramString.qXi.qXX = ((JSONObject)localObject1).optLong("InvalidContactFreqBlockSeconds", 30L);
    }
    paramString.qXj = new PackageManager();
    localObject1 = localJSONObject.optJSONObject("PackageManager");
    if (localObject1 != null)
    {
      paramString.qXj.qXI = ((JSONObject)localObject1).optLong("CheckInterval", paramString.qXj.qXI);
      paramString.qXj.qXJ = ((JSONObject)localObject1).optLong("WithoutContactClearSeconds", paramString.qXj.qXJ);
      paramString.qXj.qXK = ((JSONObject)localObject1).optLong("ClientStorageMinMB", paramString.qXj.qXK);
      paramString.qXj.qXL = ((JSONObject)localObject1).optInt("WholeClientStoragePercent", paramString.qXj.qXL);
    }
    paramString.qWP = localJSONObject.optString("CDNBaseURL");
    paramString.qWQ = localJSONObject.optString("CDNPreConnectURL", a.qXw);
    paramString.qWI = localJSONObject.optInt("AppMaxRunningCount", 5);
    paramString.qWJ = localJSONObject.optInt("AppSharedResourceBackgroundRunningCount", 1);
    paramString.qWK = localJSONObject.optInt("TempFileSizeLimitTotal", 300);
    paramString.qWL = localJSONObject.optInt("DownloadFileSizeLimit", 50);
    paramString.qWM = localJSONObject.optInt("MaxLocalStorageItemSize", 1048576);
    paramString.qWN = localJSONObject.optInt("MaxGlobalStorageItemSize", 1048576);
    paramString.qWO = localJSONObject.optInt("MaxGlobalStorageSize", 20971520);
    paramString.qXa = localJSONObject.optInt("NativeBufferSizeLimitByte", 104857600);
    paramString.qXb = localJSONObject.optInt("NativeBufferQueueLimitByte", 314572800);
    paramString.qXo = localJSONObject.optInt("WeUseRecallInterval", 86400);
    localObject1 = localJSONObject.optJSONArray("SyncLaunchSceneList");
    if (localObject1 != null)
    {
      paramString.qWS = new int[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        paramString.qWS[i] = ((JSONArray)localObject1).optInt(i, 0);
        i += 1;
      }
    }
    if (paramString.qWS == null) {
      paramString.qWS = a.qXx;
    }
    paramString.qWT = localJSONObject.optInt("StarNumberLimitation", 50);
    paramString.qWU = localJSONObject.optInt("TaskBarItemCountLimitation", 11);
    paramString.qWV = localJSONObject.optInt("NewTaskBarRecentsItemCountLimitation", 12);
    paramString.qWW = localJSONObject.optInt("TaskBarSyncUsageRecordIntervalMinute", 20);
    paramString.qWX = localJSONObject.optInt("WidgetImageFlowLimitDuration", 1800);
    paramString.qWY = localJSONObject.optInt("WidgetImageFlowLimitMaxSize", 307200);
    paramString.qWZ = localJSONObject.optInt("WidgetDrawMinInterval", 25);
    paramString.qXc = localJSONObject.optInt("GameMaxRunningCount", 1);
    paramString.qXd = localJSONObject.optInt("GameDownloadFileSizeLimit", 50);
    localObject1 = localJSONObject.optJSONArray("SubContextImgDomain");
    if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
    {
      paramString.qXe = a.qXy;
      paramString.qXf = localJSONObject.optDouble("GamePerfCollectSamplePercentage", 0.0D);
      paramString.qXg = localJSONObject.optInt("GamePerfCollectInterval", 60);
      paramString.qXh = localJSONObject.optInt("PerformIndexReportGapInSeconds", 60);
      paramString.qXk = localJSONObject.optLong("OpendataMaxFileStorageSize", 30L);
      localObject1 = localJSONObject.optJSONArray("PreDownloadUserNameBlackList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        break label1332;
      }
      paramString.qXl = a.qXz;
      label1047:
      paramString.qXm = localJSONObject.optInt("WXDataMaxRequestConcurrent", 10);
      paramString.qXn = localJSONObject.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
      localObject1 = localJSONObject.optJSONArray("UsePackageConfirmSubDescScopeList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        break label1372;
      }
      paramString.qXp = a.qXA;
    }
    for (;;)
    {
      paramString.qXq = localJSONObject.optLong("BluetoothBackgroundTimeoutWithoutConnectionInSeconds", 60L);
      paramString.qXr = localJSONObject.optInt("AppMaxBackgroundBluetoothCount", 1);
      if (localJSONObject.optJSONObject("AgeAppropriateIcon") != null) {
        paramString.qXs = localJSONObject.optJSONObject("AgeAppropriateIcon").toString();
      }
      localJSONObject = localJSONObject.optJSONObject("RelievedBuySetting");
      paramString.qXt = new RelievedBuySetting();
      if (localJSONObject != null)
      {
        localObject1 = localJSONObject.optJSONObject("icon_green");
        if (localObject1 != null)
        {
          paramString.qXt.qXM = ((JSONObject)localObject1).optString("url");
          paramString.qXt.qXN = ((JSONObject)localObject1).optInt("width", 0);
          paramString.qXt.qXO = ((JSONObject)localObject1).optInt("height", 0);
        }
        localJSONObject = localJSONObject.optJSONObject("icon_gray");
        if (localJSONObject != null)
        {
          paramString.qXt.qXP = localJSONObject.optString("url");
          paramString.qXt.qXQ = localJSONObject.optInt("width", 0);
          paramString.qXt.qXR = localJSONObject.optInt("height", 0);
        }
      }
      AppMethodBeat.o(146984);
      return paramString;
      paramString.qXe = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        paramString.qXe[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
      break;
      label1332:
      paramString.qXl = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        paramString.qXl[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
      break label1047;
      label1372:
      paramString.qXp = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        paramString.qXp[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
    }
  }
  
  static void ckA()
  {
    try
    {
      qWF = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String ckB()
  {
    AppMethodBeat.i(146981);
    Object localObject = new u(com.tencent.mm.loader.i.b.bms(), "wxaapp/res/");
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    localObject = com.tencent.mm.vfs.ah.v(new u((u)localObject, "AppService.conf").jKT());
    AppMethodBeat.o(146981);
    return localObject;
  }
  
  /* Error */
  private static AppBrandGlobalSystemConfig ckC()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 611
    //   6: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 568	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:qWF	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +80 -> 94
    //   17: invokestatic 613	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ckB	()Ljava/lang/String;
    //   20: invokestatic 618	com/tencent/mm/vfs/y:bEn	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic 621	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   28: ifeq +59 -> 87
    //   31: ldc_w 611
    //   34: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: ldc_w 623
    //   48: invokestatic 629	com/tencent/luggage/a/e:T	(Ljava/lang/Class;)Lcom/tencent/luggage/a/b;
    //   51: checkcast 623	com/tencent/luggage/sdk/customize/a
    //   54: invokeinterface 632 1 0
    //   59: aconst_null
    //   60: astore_0
    //   61: goto -37 -> 24
    //   64: astore_0
    //   65: ldc_w 261
    //   68: ldc_w 634
    //   71: iconst_1
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_0
    //   78: aastore
    //   79: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aconst_null
    //   83: astore_0
    //   84: goto -60 -> 24
    //   87: aload_0
    //   88: invokestatic 636	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:Xn	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   91: putstatic 568	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:qWF	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   94: getstatic 568	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:qWF	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   97: astore_0
    //   98: ldc_w 611
    //   101: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: goto -65 -> 39
    //   107: astore_0
    //   108: ldc 2
    //   110: monitorexit
    //   111: aload_0
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	31	0	localObject1	Object
    //   44	1	0	localFileNotFoundException	java.io.FileNotFoundException
    //   60	1	0	localObject2	Object
    //   64	14	0	localIOException	java.io.IOException
    //   83	15	0	localObject3	Object
    //   107	5	0	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	44	java/io/FileNotFoundException
    //   17	24	64	java/io/IOException
    //   3	13	107	finally
    //   17	24	107	finally
    //   24	37	107	finally
    //   45	59	107	finally
    //   65	82	107	finally
    //   87	94	107	finally
    //   94	104	107	finally
  }
  
  public static AppBrandGlobalSystemConfig ckD()
  {
    AppMethodBeat.i(146983);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = ckC();
    if (localAppBrandGlobalSystemConfig == null)
    {
      localAppBrandGlobalSystemConfig = qWG;
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
    paramParcel.writeInt(this.qWH);
    paramParcel.writeInt(this.qWI);
    paramParcel.writeInt(this.qWJ);
    paramParcel.writeInt(this.qWK);
    paramParcel.writeInt(this.qWL);
    paramParcel.writeInt(this.qWM);
    paramParcel.writeInt(this.qWN);
    paramParcel.writeInt(this.qWO);
    paramParcel.writeString(this.qWP);
    paramParcel.writeString(this.qWQ);
    paramParcel.writeParcelable(this.qWR, paramInt);
    paramParcel.writeIntArray(this.qWS);
    paramParcel.writeInt(this.qWT);
    paramParcel.writeInt(this.qWU);
    paramParcel.writeInt(this.qWX);
    paramParcel.writeInt(this.qWY);
    paramParcel.writeInt(this.qWZ);
    paramParcel.writeInt(this.qXa);
    paramParcel.writeInt(this.qXb);
    paramParcel.writeInt(this.qXc);
    paramParcel.writeInt(this.qXd);
    paramParcel.writeStringArray(this.qXe);
    paramParcel.writeDouble(this.qXf);
    paramParcel.writeInt(this.qXg);
    paramParcel.writeParcelable(this.qXi, paramInt);
    paramParcel.writeParcelable(this.qXj, paramInt);
    paramParcel.writeLong(this.qXk);
    paramParcel.writeStringArray(this.qXl);
    paramParcel.writeInt(this.qXm);
    paramParcel.writeInt(this.qXo);
    paramParcel.writeInt(this.qXn);
    paramParcel.writeInt(this.qXh);
    paramParcel.writeStringArray(this.qXp);
    paramParcel.writeLong(this.qXq);
    paramParcel.writeInt(this.qXr);
    paramParcel.writeString(this.qXs);
    paramParcel.writeParcelable(this.qXt, paramInt);
    AppMethodBeat.o(146986);
  }
  
  public static final class HttpSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<HttpSetting> CREATOR;
    public int mode;
    public ArrayList<String> qXB;
    public ArrayList<String> qXC;
    public int qXD;
    public int qXE;
    public int qXF;
    public int qXG;
    public String qXH;
    
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
      this.qXB = paramParcel.createStringArrayList();
      this.qXC = paramParcel.createStringArrayList();
      this.qXD = paramParcel.readInt();
      this.qXE = paramParcel.readInt();
      this.qXF = paramParcel.readInt();
      this.qXG = paramParcel.readInt();
      this.qXH = paramParcel.readString();
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
      paramParcel.writeStringList(this.qXB);
      paramParcel.writeStringList(this.qXC);
      paramParcel.writeInt(this.qXD);
      paramParcel.writeInt(this.qXE);
      paramParcel.writeInt(this.qXF);
      paramParcel.writeInt(this.qXG);
      paramParcel.writeString(this.qXH);
      AppMethodBeat.o(146970);
    }
  }
  
  public static final class PackageManager
    implements Parcelable
  {
    public static final Parcelable.Creator<PackageManager> CREATOR;
    public long qXI;
    public long qXJ;
    public long qXK;
    public int qXL;
    
    static
    {
      AppMethodBeat.i(146976);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146976);
    }
    
    public PackageManager()
    {
      this.qXI = 86400L;
      this.qXJ = 864000L;
      this.qXK = 256L;
      this.qXL = 5;
    }
    
    protected PackageManager(Parcel paramParcel)
    {
      AppMethodBeat.i(146975);
      this.qXI = 86400L;
      this.qXJ = 864000L;
      this.qXK = 256L;
      this.qXL = 5;
      this.qXI = paramParcel.readLong();
      this.qXJ = paramParcel.readLong();
      this.qXK = paramParcel.readLong();
      this.qXL = paramParcel.readInt();
      AppMethodBeat.o(146975);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146974);
      paramParcel.writeLong(this.qXI);
      paramParcel.writeLong(this.qXJ);
      paramParcel.writeLong(this.qXK);
      paramParcel.writeInt(this.qXL);
      AppMethodBeat.o(146974);
    }
  }
  
  public static final class RelievedBuySetting
    implements Parcelable
  {
    public static final Parcelable.Creator<RelievedBuySetting> CREATOR;
    public String qXM;
    public int qXN;
    public int qXO;
    public String qXP;
    public int qXQ;
    public int qXR;
    
    static
    {
      AppMethodBeat.i(323446);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(323446);
    }
    
    public RelievedBuySetting()
    {
      this.qXM = "";
      this.qXN = 0;
      this.qXO = 0;
      this.qXP = "";
      this.qXQ = 0;
      this.qXR = 0;
    }
    
    protected RelievedBuySetting(Parcel paramParcel)
    {
      AppMethodBeat.i(323444);
      this.qXM = "";
      this.qXN = 0;
      this.qXO = 0;
      this.qXP = "";
      this.qXQ = 0;
      this.qXR = 0;
      this.qXM = paramParcel.readString();
      this.qXN = paramParcel.readInt();
      this.qXO = paramParcel.readInt();
      this.qXP = paramParcel.readString();
      this.qXQ = paramParcel.readInt();
      this.qXR = paramParcel.readInt();
      AppMethodBeat.o(323444);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(323452);
      if (this.qXM == null)
      {
        str = "";
        paramParcel.writeString(str);
        paramParcel.writeInt(this.qXN);
        paramParcel.writeInt(this.qXO);
        if (this.qXP != null) {
          break label81;
        }
      }
      label81:
      for (String str = "";; str = this.qXP)
      {
        paramParcel.writeString(str);
        paramParcel.writeInt(this.qXQ);
        paramParcel.writeInt(this.qXR);
        AppMethodBeat.o(323452);
        return;
        str = this.qXM;
        break;
      }
    }
  }
  
  public static final class WeAppSyncVersionSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<WeAppSyncVersionSetting> CREATOR;
    public long qXS;
    public long qXT;
    public int qXU;
    public int qXV;
    public LongSparseArray<List<String>> qXW;
    public long qXX;
    
    static
    {
      AppMethodBeat.i(146980);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146980);
    }
    
    WeAppSyncVersionSetting()
    {
      this.qXS = 21600L;
      this.qXT = 604800L;
      this.qXU = 1000;
      this.qXV = 100;
      this.qXX = 30L;
    }
    
    WeAppSyncVersionSetting(Parcel paramParcel)
    {
      AppMethodBeat.i(146979);
      this.qXS = 21600L;
      this.qXT = 604800L;
      this.qXU = 1000;
      this.qXV = 100;
      this.qXX = 30L;
      this.qXS = paramParcel.readLong();
      this.qXT = paramParcel.readLong();
      this.qXU = paramParcel.readInt();
      this.qXV = paramParcel.readInt();
      int j = paramParcel.readInt();
      if (j > 0)
      {
        this.qXW = new LongSparseArray(j);
        int i = 0;
        while (i < j)
        {
          long l = paramParcel.readLong();
          LinkedList localLinkedList = new LinkedList();
          paramParcel.readStringList(localLinkedList);
          this.qXW.put(l, localLinkedList);
          i += 1;
        }
      }
      this.qXX = paramParcel.readLong();
      AppMethodBeat.o(146979);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146978);
      paramParcel.writeLong(this.qXS);
      paramParcel.writeLong(this.qXT);
      paramParcel.writeInt(this.qXU);
      paramParcel.writeInt(this.qXV);
      if ((this.qXW == null) || (this.qXW.size() == 0)) {
        paramParcel.writeInt(-1);
      }
      for (;;)
      {
        paramParcel.writeLong(this.qXX);
        AppMethodBeat.o(146978);
        return;
        paramParcel.writeInt(this.qXW.size());
        paramInt = 0;
        while (paramInt < this.qXW.size())
        {
          paramParcel.writeLong(this.qXW.keyAt(paramInt));
          paramParcel.writeStringList((List)this.qXW.valueAt(paramInt));
          paramInt += 1;
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public static final String[] qXA = new String[0];
    public static final String qXw = "https://" + WeChatHosts.domainString(a.g.host_res_servicewechat_com);
    public static final int[] qXx = new int[0];
    public static final String[] qXy = { "https://wx.qlogo.cn/" };
    public static final String[] qXz = new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig
 * JD-Core Version:    0.7.0.1
 */