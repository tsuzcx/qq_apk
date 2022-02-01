package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.LongSparseArray;
import com.tencent.luggage.l.a.g;
import com.tencent.luggage.sdk.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandGlobalSystemConfig> CREATOR;
  private static volatile AppBrandGlobalSystemConfig nWP;
  public static final AppBrandGlobalSystemConfig nWQ;
  public int nWR;
  public int nWS;
  public int nWT;
  public int nWU;
  public int nWV;
  public int nWW;
  public int nWX;
  public int nWY;
  public String nWZ;
  public String nXa;
  public HttpSetting nXb;
  public int[] nXc;
  public int nXd;
  public int nXe;
  public int nXf;
  public int nXg;
  public int nXh;
  public int nXi;
  public int nXj;
  public int nXk;
  public int nXl;
  public int nXm;
  public int nXn;
  public String[] nXo;
  public double nXp;
  public int nXq;
  public int nXr;
  public AppBrandGlobalSystemConfig.WeAppSyncVersionSetting nXs;
  public AppBrandGlobalSystemConfig.PackageManager nXt;
  public long nXu;
  public String[] nXv;
  public int nXw;
  public int nXx;
  public int nXy;
  public String[] nXz;
  
  static
  {
    AppMethodBeat.i(146988);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
    nWQ = localAppBrandGlobalSystemConfig;
    localAppBrandGlobalSystemConfig.nWS = 5;
    nWQ.nWT = 1;
    nWQ.nWU = 300;
    nWQ.nWV = 50;
    nWQ.nWW = 1048576;
    nWQ.nWX = 1048576;
    nWQ.nWY = 20971520;
    nWQ.nXc = a.nXD;
    nWQ.nXd = 50;
    nWQ.nXe = 11;
    nWQ.nXf = 12;
    nWQ.nXh = 1800;
    nWQ.nXi = 307200;
    nWQ.nXj = 25;
    nWQ.nXk = 10485760;
    nWQ.nXl = 314572800;
    nWQ.nXm = 1;
    nWQ.nXn = 50;
    nWQ.nXo = a.nXE;
    nWQ.nXp = 0.0D;
    nWQ.nXq = 60;
    nWQ.nXr = 60;
    nWQ.nXs = new AppBrandGlobalSystemConfig.WeAppSyncVersionSetting();
    nWQ.nXt = new AppBrandGlobalSystemConfig.PackageManager();
    nWQ.nXu = 30L;
    nWQ.nXv = a.nXF;
    nWQ.nXw = 10;
    nWQ.nXy = 86400;
    nWQ.nXz = a.nXG;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146988);
  }
  
  private AppBrandGlobalSystemConfig()
  {
    AppMethodBeat.i(146985);
    this.nWR = 2147483647;
    this.nXb = new HttpSetting();
    AppMethodBeat.o(146985);
  }
  
  protected AppBrandGlobalSystemConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(146987);
    this.nWR = 2147483647;
    this.nXb = new HttpSetting();
    this.nWR = paramParcel.readInt();
    this.nWS = paramParcel.readInt();
    this.nWT = paramParcel.readInt();
    this.nWU = paramParcel.readInt();
    this.nWV = paramParcel.readInt();
    this.nWW = paramParcel.readInt();
    this.nWX = paramParcel.readInt();
    this.nWY = paramParcel.readInt();
    this.nWZ = paramParcel.readString();
    this.nXa = paramParcel.readString();
    this.nXb = ((HttpSetting)paramParcel.readParcelable(HttpSetting.class.getClassLoader()));
    this.nXc = paramParcel.createIntArray();
    this.nXd = paramParcel.readInt();
    this.nXe = paramParcel.readInt();
    this.nXh = paramParcel.readInt();
    this.nXi = paramParcel.readInt();
    this.nXj = paramParcel.readInt();
    this.nXk = paramParcel.readInt();
    this.nXl = paramParcel.readInt();
    this.nXm = paramParcel.readInt();
    this.nXn = paramParcel.readInt();
    this.nXo = paramParcel.createStringArray();
    this.nXp = paramParcel.readDouble();
    this.nXq = paramParcel.readInt();
    this.nXs = ((AppBrandGlobalSystemConfig.WeAppSyncVersionSetting)paramParcel.readParcelable(AppBrandGlobalSystemConfig.WeAppSyncVersionSetting.class.getClassLoader()));
    this.nXt = ((AppBrandGlobalSystemConfig.PackageManager)paramParcel.readParcelable(AppBrandGlobalSystemConfig.PackageManager.class.getClassLoader()));
    this.nXu = paramParcel.readLong();
    this.nXv = paramParcel.createStringArray();
    this.nXw = paramParcel.readInt();
    this.nXy = paramParcel.readInt();
    this.nXx = paramParcel.readInt();
    this.nXr = paramParcel.readInt();
    this.nXz = paramParcel.createStringArray();
    AppMethodBeat.o(146987);
  }
  
  private static AppBrandGlobalSystemConfig aeL(String paramString)
  {
    AppMethodBeat.i(146984);
    Log.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[] { paramString });
    Object localObject1;
    Object localObject3;
    int i;
    try
    {
      localObject1 = new JSONObject(paramString);
      paramString = new AppBrandGlobalSystemConfig();
      localObject2 = ((JSONObject)localObject1).optJSONObject("HTTPSetting");
      if (localObject2 == null) {
        break label327;
      }
      localObject3 = ((JSONObject)localObject2).optString("HTTPHeaderMode", "");
      if (((String)localObject3).equals("BlackList")) {
        paramString.nXb.mode = 1;
      }
      for (;;)
      {
        localObject3 = ((JSONObject)localObject2).optJSONArray("HeaderBlackList");
        if (localObject3 == null) {
          break;
        }
        paramString.nXb.nXH = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject3).length())
        {
          paramString.nXb.nXH.add(((JSONArray)localObject3).getString(i));
          i += 1;
        }
        if (((String)localObject3).equals("WhiteList")) {
          paramString.nXb.mode = 2;
        }
      }
      localObject3 = ((JSONObject)localObject2).optJSONArray("HeaderWhiteList");
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(146984);
      return null;
    }
    if (localObject3 != null)
    {
      paramString.nXb.nXI = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject3).length())
      {
        paramString.nXb.nXI.add(((JSONArray)localObject3).getString(i));
        i += 1;
      }
    }
    paramString.nXb.nXJ = ((JSONObject)localObject2).optInt("WebsocketMaxTimeoutMS", -1);
    paramString.nXb.nXK = ((JSONObject)localObject2).optInt("UploadMaxTimeoutMS", -1);
    paramString.nXb.nXL = ((JSONObject)localObject2).optInt("DownloadMaxTimeoutMS", -1);
    paramString.nXb.nXM = ((JSONObject)localObject2).optInt("RequestMaxTimeoutMS", -1);
    paramString.nXb.nXN = ((JSONObject)localObject2).optString("HTTPHeaderReferer");
    label327:
    paramString.nXs = new AppBrandGlobalSystemConfig.WeAppSyncVersionSetting();
    Object localObject2 = ((JSONObject)localObject1).optJSONObject("SyncVersionSetting");
    if (localObject2 != null)
    {
      paramString.nXs.nXS = ((JSONObject)localObject2).optLong("PullVersionInterval", paramString.nXs.nXS);
      paramString.nXs.nXT = ((JSONObject)localObject2).optLong("PullVersionWxaUsageLastInterval", paramString.nXs.nXT);
      paramString.nXs.nXU = ((JSONObject)localObject2).optInt("PullVersionMaxCount", paramString.nXs.nXU);
      paramString.nXs.nXV = ((JSONObject)localObject2).optInt("PullVersionMaxCountPerRequest", paramString.nXs.nXV);
      if (((JSONObject)localObject2).has("PreDownloadList"))
      {
        paramString.nXs.nXW = new LongSparseArray();
        c.a(((JSONObject)localObject2).getJSONArray("PreDownloadList"), new kotlin.g.a.b()
        {
          private x G(JSONObject paramAnonymousJSONObject)
          {
            AppMethodBeat.i(242233);
            try
            {
              final LinkedList localLinkedList = new LinkedList();
              c.a(paramAnonymousJSONObject.getJSONArray("list"), new kotlin.g.a.b() {});
              this.nXA.nXs.nXW.put(paramAnonymousJSONObject.getLong("UsedTime"), localLinkedList);
              label51:
              paramAnonymousJSONObject = x.aazN;
              AppMethodBeat.o(242233);
              return paramAnonymousJSONObject;
            }
            catch (JSONException paramAnonymousJSONObject)
            {
              break label51;
            }
          }
        });
      }
    }
    paramString.nXt = new AppBrandGlobalSystemConfig.PackageManager();
    localObject2 = ((JSONObject)localObject1).optJSONObject("PackageManager");
    if (localObject2 != null)
    {
      paramString.nXt.nXO = ((JSONObject)localObject2).optLong("CheckInterval", paramString.nXt.nXO);
      paramString.nXt.nXP = ((JSONObject)localObject2).optLong("WithoutContactClearSeconds", paramString.nXt.nXP);
      paramString.nXt.nXQ = ((JSONObject)localObject2).optLong("ClientStorageMinMB", paramString.nXt.nXQ);
      paramString.nXt.nXR = ((JSONObject)localObject2).optInt("WholeClientStoragePercent", paramString.nXt.nXR);
    }
    paramString.nWZ = ((JSONObject)localObject1).optString("CDNBaseURL");
    paramString.nXa = ((JSONObject)localObject1).optString("CDNPreConnectURL", a.nXC);
    paramString.nWS = ((JSONObject)localObject1).optInt("AppMaxRunningCount", 5);
    paramString.nWT = ((JSONObject)localObject1).optInt("AppSharedResourceBackgroundRunningCount", 1);
    paramString.nWU = ((JSONObject)localObject1).optInt("TempFileSizeLimitTotal", 300);
    paramString.nWV = ((JSONObject)localObject1).optInt("DownloadFileSizeLimit", 50);
    paramString.nWW = ((JSONObject)localObject1).optInt("MaxLocalStorageItemSize", 1048576);
    paramString.nWX = ((JSONObject)localObject1).optInt("MaxGlobalStorageItemSize", 1048576);
    paramString.nWY = ((JSONObject)localObject1).optInt("MaxGlobalStorageSize", 20971520);
    paramString.nXk = ((JSONObject)localObject1).optInt("NativeBufferSizeLimitByte", 10485760);
    paramString.nXl = ((JSONObject)localObject1).optInt("NativeBufferQueueLimitByte", 314572800);
    paramString.nXy = ((JSONObject)localObject1).optInt("WeUseRecallInterval", 86400);
    localObject2 = ((JSONObject)localObject1).optJSONArray("SyncLaunchSceneList");
    if (localObject2 != null)
    {
      paramString.nXc = new int[((JSONArray)localObject2).length()];
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        paramString.nXc[i] = ((JSONArray)localObject2).optInt(i, 0);
        i += 1;
      }
    }
    if (paramString.nXc == null) {
      paramString.nXc = a.nXD;
    }
    paramString.nXd = ((JSONObject)localObject1).optInt("StarNumberLimitation", 50);
    paramString.nXe = ((JSONObject)localObject1).optInt("TaskBarItemCountLimitation", 11);
    paramString.nXf = ((JSONObject)localObject1).optInt("NewTaskBarRecentsItemCountLimitation", 12);
    paramString.nXg = ((JSONObject)localObject1).optInt("TaskBarSyncUsageRecordIntervalMinute", 20);
    paramString.nXh = ((JSONObject)localObject1).optInt("WidgetImageFlowLimitDuration", 1800);
    paramString.nXi = ((JSONObject)localObject1).optInt("WidgetImageFlowLimitMaxSize", 307200);
    paramString.nXj = ((JSONObject)localObject1).optInt("WidgetDrawMinInterval", 25);
    paramString.nXm = ((JSONObject)localObject1).optInt("GameMaxRunningCount", 1);
    paramString.nXn = ((JSONObject)localObject1).optInt("GameDownloadFileSizeLimit", 50);
    localObject2 = ((JSONObject)localObject1).optJSONArray("SubContextImgDomain");
    if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
    {
      paramString.nXo = a.nXE;
      paramString.nXp = ((JSONObject)localObject1).optDouble("GamePerfCollectSamplePercentage", 0.0D);
      paramString.nXq = ((JSONObject)localObject1).optInt("GamePerfCollectInterval", 60);
      paramString.nXr = ((JSONObject)localObject1).optInt("PerformIndexReportGapInSeconds", 60);
      paramString.nXu = ((JSONObject)localObject1).optLong("OpendataMaxFileStorageSize", 30L);
      localObject2 = ((JSONObject)localObject1).optJSONArray("PreDownloadUserNameBlackList");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
        break label1122;
      }
      paramString.nXv = a.nXF;
      label1023:
      paramString.nXw = ((JSONObject)localObject1).optInt("WXDataMaxRequestConcurrent", 10);
      paramString.nXx = ((JSONObject)localObject1).optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
      localObject1 = ((JSONObject)localObject1).optJSONArray("UsePackageConfirmSubDescScopeList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        break label1162;
      }
      paramString.nXz = a.nXG;
    }
    for (;;)
    {
      AppMethodBeat.o(146984);
      return paramString;
      paramString.nXo = new String[((JSONArray)localObject2).length()];
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        paramString.nXo[i] = ((JSONArray)localObject2).optString(i, null);
        i += 1;
      }
      break;
      label1122:
      paramString.nXv = new String[((JSONArray)localObject2).length()];
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        paramString.nXv[i] = ((JSONArray)localObject2).optString(i, null);
        i += 1;
      }
      break label1023;
      label1162:
      paramString.nXz = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        paramString.nXz[i] = ((JSONArray)localObject1).optString(i, null);
        i += 1;
      }
    }
  }
  
  static void bLb()
  {
    try
    {
      nWP = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String bLc()
  {
    AppMethodBeat.i(146981);
    Object localObject = new q(com.tencent.mm.loader.j.b.aSE(), "wxaapp/res/");
    if (!((q)localObject).ifE()) {
      ((q)localObject).ifL();
    }
    localObject = new q((q)localObject, "AppService.conf").bOF();
    AppMethodBeat.o(146981);
    return localObject;
  }
  
  /* Error */
  private static AppBrandGlobalSystemConfig bLd()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 535
    //   6: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 499	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:nWP	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +79 -> 93
    //   17: invokestatic 537	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bLc	()Ljava/lang/String;
    //   20: invokestatic 542	com/tencent/mm/vfs/u:bBS	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic 545	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   28: ifeq +58 -> 86
    //   31: ldc_w 535
    //   34: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: ldc_w 547
    //   48: invokestatic 553	com/tencent/luggage/a/e:K	(Ljava/lang/Class;)Lcom/tencent/luggage/a/b;
    //   51: checkcast 547	com/tencent/luggage/sdk/customize/a
    //   54: invokeinterface 556 1 0
    //   59: aconst_null
    //   60: astore_0
    //   61: goto -37 -> 24
    //   64: astore_0
    //   65: ldc 234
    //   67: ldc_w 558
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -59 -> 24
    //   86: aload_0
    //   87: invokestatic 560	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:aeL	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   90: putstatic 499	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:nWP	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   93: getstatic 499	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:nWP	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   96: astore_0
    //   97: ldc_w 535
    //   100: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static AppBrandGlobalSystemConfig bLe()
  {
    AppMethodBeat.i(146983);
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = bLd();
    if (localAppBrandGlobalSystemConfig == null)
    {
      localAppBrandGlobalSystemConfig = nWQ;
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
    paramParcel.writeInt(this.nWR);
    paramParcel.writeInt(this.nWS);
    paramParcel.writeInt(this.nWT);
    paramParcel.writeInt(this.nWU);
    paramParcel.writeInt(this.nWV);
    paramParcel.writeInt(this.nWW);
    paramParcel.writeInt(this.nWX);
    paramParcel.writeInt(this.nWY);
    paramParcel.writeString(this.nWZ);
    paramParcel.writeString(this.nXa);
    paramParcel.writeParcelable(this.nXb, paramInt);
    paramParcel.writeIntArray(this.nXc);
    paramParcel.writeInt(this.nXd);
    paramParcel.writeInt(this.nXe);
    paramParcel.writeInt(this.nXh);
    paramParcel.writeInt(this.nXi);
    paramParcel.writeInt(this.nXj);
    paramParcel.writeInt(this.nXk);
    paramParcel.writeInt(this.nXl);
    paramParcel.writeInt(this.nXm);
    paramParcel.writeInt(this.nXn);
    paramParcel.writeStringArray(this.nXo);
    paramParcel.writeDouble(this.nXp);
    paramParcel.writeInt(this.nXq);
    paramParcel.writeParcelable(this.nXs, paramInt);
    paramParcel.writeParcelable(this.nXt, paramInt);
    paramParcel.writeLong(this.nXu);
    paramParcel.writeStringArray(this.nXv);
    paramParcel.writeInt(this.nXw);
    paramParcel.writeInt(this.nXy);
    paramParcel.writeInt(this.nXx);
    paramParcel.writeInt(this.nXr);
    paramParcel.writeStringArray(this.nXz);
    AppMethodBeat.o(146986);
  }
  
  public static final class HttpSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<HttpSetting> CREATOR;
    public int mode;
    public ArrayList<String> nXH;
    public ArrayList<String> nXI;
    public int nXJ;
    public int nXK;
    public int nXL;
    public int nXM;
    public String nXN;
    
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
      this.nXH = paramParcel.createStringArrayList();
      this.nXI = paramParcel.createStringArrayList();
      this.nXJ = paramParcel.readInt();
      this.nXK = paramParcel.readInt();
      this.nXL = paramParcel.readInt();
      this.nXM = paramParcel.readInt();
      this.nXN = paramParcel.readString();
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
      paramParcel.writeStringList(this.nXH);
      paramParcel.writeStringList(this.nXI);
      paramParcel.writeInt(this.nXJ);
      paramParcel.writeInt(this.nXK);
      paramParcel.writeInt(this.nXL);
      paramParcel.writeInt(this.nXM);
      paramParcel.writeString(this.nXN);
      AppMethodBeat.o(146970);
    }
  }
  
  public static abstract interface a
  {
    public static final String nXC = "https://" + WeChatHosts.domainString(a.g.host_res_servicewechat_com);
    public static final int[] nXD = new int[0];
    public static final String[] nXE = { "https://wx.qlogo.cn/" };
    public static final String[] nXF = new String[0];
    public static final String[] nXG = new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig
 * JD-Core Version:    0.7.0.1
 */