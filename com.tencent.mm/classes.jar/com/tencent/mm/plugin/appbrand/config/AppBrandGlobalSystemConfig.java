package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandGlobalSystemConfig> CREATOR = new AppBrandGlobalSystemConfig.1();
  private static volatile AppBrandGlobalSystemConfig fOy;
  private static final AppBrandGlobalSystemConfig fOz;
  public int fOA = 2147483647;
  public int fOB;
  public int fOC;
  public int fOD;
  public int fOE;
  public int fOF;
  public int fOG;
  public String fOH;
  public HttpSetting fOI = new HttpSetting();
  public int[] fOJ;
  public int fOK;
  public int fOL;
  public int fOM;
  public int fON;
  public int fOO;
  public int fOP;
  public int fOQ;
  public int fOR;
  public int fOS;
  public int fOT;
  public String[] fOU;
  public double fOV;
  public int fOW;
  public AppBrandGlobalSystemConfig.WeAppSyncVersionSetting fOX;
  public AppBrandGlobalSystemConfig.PackageManager fOY;
  
  static
  {
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
    fOz = localAppBrandGlobalSystemConfig;
    localAppBrandGlobalSystemConfig.fOB = 5;
    fOz.fOC = 300;
    fOz.fOD = 10;
    fOz.fOE = 1048576;
    fOz.fOF = 1048576;
    fOz.fOG = 20971520;
    fOz.fOJ = AppBrandGlobalSystemConfig.a.fOZ;
    fOz.fOK = 50;
    fOz.fOL = 11;
    fOz.fOM = 12;
    fOz.fON = 1800;
    fOz.fOO = 307200;
    fOz.fOP = 25;
    fOz.fOQ = 10485760;
    fOz.fOR = 314572800;
    fOz.fOS = 1;
    fOz.fOT = 50;
    fOz.fOU = AppBrandGlobalSystemConfig.a.fPa;
    fOz.fOV = 0.0D;
    fOz.fOW = 60;
    fOz.fOX = new AppBrandGlobalSystemConfig.WeAppSyncVersionSetting();
    fOz.fOY = new AppBrandGlobalSystemConfig.PackageManager();
  }
  
  private AppBrandGlobalSystemConfig() {}
  
  protected AppBrandGlobalSystemConfig(Parcel paramParcel)
  {
    this.fOA = paramParcel.readInt();
    this.fOB = paramParcel.readInt();
    this.fOC = paramParcel.readInt();
    this.fOD = paramParcel.readInt();
    this.fOE = paramParcel.readInt();
    this.fOF = paramParcel.readInt();
    this.fOG = paramParcel.readInt();
    this.fOH = paramParcel.readString();
    this.fOI = ((HttpSetting)paramParcel.readParcelable(HttpSetting.class.getClassLoader()));
    this.fOJ = paramParcel.createIntArray();
    this.fOK = paramParcel.readInt();
    this.fOL = paramParcel.readInt();
    this.fON = paramParcel.readInt();
    this.fOO = paramParcel.readInt();
    this.fOP = paramParcel.readInt();
    this.fOQ = paramParcel.readInt();
    this.fOR = paramParcel.readInt();
    this.fOS = paramParcel.readInt();
    this.fOT = paramParcel.readInt();
    this.fOU = paramParcel.createStringArray();
    this.fOV = paramParcel.readDouble();
    this.fOW = paramParcel.readInt();
    this.fOX = ((AppBrandGlobalSystemConfig.WeAppSyncVersionSetting)paramParcel.readParcelable(AppBrandGlobalSystemConfig.WeAppSyncVersionSetting.class.getClassLoader()));
    this.fOY = ((AppBrandGlobalSystemConfig.PackageManager)paramParcel.readParcelable(AppBrandGlobalSystemConfig.PackageManager.class.getClassLoader()));
  }
  
  static void adZ()
  {
    try
    {
      fOy = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String aea()
  {
    File localFile = new File(e.dOQ.replace("/data/user/0", "/data/data"), "wxaapp/res/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile, "AppService.conf").getAbsolutePath();
  }
  
  /* Error */
  private static AppBrandGlobalSystemConfig aeb()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: istore_0
    //   4: ldc 2
    //   6: monitorenter
    //   7: getstatic 169	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:fOy	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +111 -> 123
    //   15: invokestatic 215	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:aea	()Ljava/lang/String;
    //   18: invokestatic 221	com/tencent/mm/a/e:bP	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore_2
    //   22: aload_2
    //   23: invokestatic 227	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   26: istore_1
    //   27: iload_1
    //   28: ifeq +88 -> 116
    //   31: aload_3
    //   32: astore_2
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_2
    //   37: areturn
    //   38: astore_2
    //   39: invokestatic 233	com/tencent/mm/pluginsdk/g/a/a/b$c:clv	()Lcom/tencent/mm/pluginsdk/g/a/a/b;
    //   42: astore_2
    //   43: invokestatic 233	com/tencent/mm/pluginsdk/g/a/a/b$c:clv	()Lcom/tencent/mm/pluginsdk/g/a/a/b;
    //   46: pop
    //   47: invokestatic 239	com/tencent/mm/pluginsdk/g/a/c/q$a:clL	()Lcom/tencent/mm/pluginsdk/g/a/c/q;
    //   50: bipush 38
    //   52: iconst_1
    //   53: invokestatic 245	com/tencent/mm/pluginsdk/g/a/a/i:eW	(II)Ljava/lang/String;
    //   56: invokevirtual 251	com/tencent/mm/pluginsdk/g/a/c/q:Wl	(Ljava/lang/String;)Lcom/tencent/mm/pluginsdk/g/a/c/s;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnonnull +17 -> 80
    //   66: aload_2
    //   67: bipush 38
    //   69: iconst_1
    //   70: iload_0
    //   71: iconst_0
    //   72: invokevirtual 257	com/tencent/mm/pluginsdk/g/a/a/b:d	(IIIZ)V
    //   75: aconst_null
    //   76: astore_2
    //   77: goto -55 -> 22
    //   80: aload 4
    //   82: getfield 262	com/tencent/mm/pluginsdk/g/a/c/s:field_fileVersion	Ljava/lang/String;
    //   85: iconst_0
    //   86: invokestatic 266	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   89: istore_0
    //   90: goto -24 -> 66
    //   93: astore_2
    //   94: ldc_w 268
    //   97: ldc_w 270
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_2
    //   107: aastore
    //   108: invokestatic 276	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aconst_null
    //   112: astore_2
    //   113: goto -91 -> 22
    //   116: aload_2
    //   117: invokestatic 280	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:si	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   120: putstatic 169	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:fOy	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   123: getstatic 169	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:fOy	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   126: astore_2
    //   127: goto -94 -> 33
    //   130: astore_2
    //   131: ldc 2
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	87	0	i	int
    //   26	2	1	bool	boolean
    //   10	27	2	localObject1	Object
    //   38	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   42	35	2	localb	com.tencent.mm.pluginsdk.g.a.a.b
    //   93	14	2	localIOException	java.io.IOException
    //   112	15	2	localObject2	Object
    //   130	5	2	localObject3	Object
    //   1	31	3	localObject4	Object
    //   59	22	4	locals	com.tencent.mm.pluginsdk.g.a.c.s
    // Exception table:
    //   from	to	target	type
    //   15	22	38	java/io/FileNotFoundException
    //   15	22	93	java/io/IOException
    //   7	11	130	finally
    //   15	22	130	finally
    //   22	27	130	finally
    //   39	61	130	finally
    //   66	75	130	finally
    //   80	90	130	finally
    //   94	111	130	finally
    //   116	123	130	finally
    //   123	127	130	finally
  }
  
  public static AppBrandGlobalSystemConfig aec()
  {
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig2 = aeb();
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig1 = localAppBrandGlobalSystemConfig2;
    if (localAppBrandGlobalSystemConfig2 == null) {
      localAppBrandGlobalSystemConfig1 = fOz;
    }
    return localAppBrandGlobalSystemConfig1;
  }
  
  private static AppBrandGlobalSystemConfig si(String paramString)
  {
    y.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[] { paramString });
    AppBrandGlobalSystemConfig localAppBrandGlobalSystemConfig;
    Object localObject2;
    int i;
    try
    {
      paramString = new JSONObject(paramString);
      localAppBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
      localObject1 = paramString.optJSONObject("HTTPSetting");
      if (localObject1 == null) {
        break label322;
      }
      localObject2 = ((JSONObject)localObject1).optString("HTTPHeaderMode", "");
      if (((String)localObject2).equals("BlackList")) {
        localAppBrandGlobalSystemConfig.fOI.mode = 1;
      }
      for (;;)
      {
        localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderBlackList");
        if (localObject2 == null) {
          break;
        }
        localAppBrandGlobalSystemConfig.fOI.fPb = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localAppBrandGlobalSystemConfig.fOI.fPb.add(((JSONArray)localObject2).getString(i));
          i += 1;
        }
        if (((String)localObject2).equals("WhiteList")) {
          localAppBrandGlobalSystemConfig.fOI.mode = 2;
        }
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderWhiteList");
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[] { bk.j(paramString) });
      return null;
    }
    if (localObject2 != null)
    {
      localAppBrandGlobalSystemConfig.fOI.fPc = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        localAppBrandGlobalSystemConfig.fOI.fPc.add(((JSONArray)localObject2).getString(i));
        i += 1;
      }
    }
    localAppBrandGlobalSystemConfig.fOI.fPd = ((JSONObject)localObject1).optInt("WebsocketMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.fOI.fPe = ((JSONObject)localObject1).optInt("UploadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.fOI.fPf = ((JSONObject)localObject1).optInt("DownloadMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.fOI.fPg = ((JSONObject)localObject1).optInt("RequestMaxTimeoutMS", -1);
    localAppBrandGlobalSystemConfig.fOI.fPh = ((JSONObject)localObject1).optString("HTTPHeaderReferer");
    label322:
    localAppBrandGlobalSystemConfig.fOX = new AppBrandGlobalSystemConfig.WeAppSyncVersionSetting();
    Object localObject1 = paramString.optJSONObject("SyncVersionSetting");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.fOX.fPm = ((JSONObject)localObject1).optLong("PullVersionInterval", localAppBrandGlobalSystemConfig.fOX.fPm);
      localAppBrandGlobalSystemConfig.fOX.fPn = ((JSONObject)localObject1).optLong("PullVersionWxaUsageLastInterval", localAppBrandGlobalSystemConfig.fOX.fPn);
      localAppBrandGlobalSystemConfig.fOX.fPo = ((JSONObject)localObject1).optInt("PullVersionMaxCount", localAppBrandGlobalSystemConfig.fOX.fPo);
      localAppBrandGlobalSystemConfig.fOX.fPp = ((JSONObject)localObject1).optInt("PullVersionMaxCountPerRequest", localAppBrandGlobalSystemConfig.fOX.fPp);
    }
    localAppBrandGlobalSystemConfig.fOY = new AppBrandGlobalSystemConfig.PackageManager();
    localObject1 = paramString.optJSONObject("PackageManager");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.fOY.fPi = ((JSONObject)localObject1).optLong("CheckInterval", localAppBrandGlobalSystemConfig.fOY.fPi);
      localAppBrandGlobalSystemConfig.fOY.fPj = ((JSONObject)localObject1).optLong("WithoutContactClearSeconds", localAppBrandGlobalSystemConfig.fOY.fPj);
      localAppBrandGlobalSystemConfig.fOY.fPk = ((JSONObject)localObject1).optLong("ClientStorageMinMB", localAppBrandGlobalSystemConfig.fOY.fPk);
      localAppBrandGlobalSystemConfig.fOY.fPl = ((JSONObject)localObject1).optInt("WholeClientStoragePercent", localAppBrandGlobalSystemConfig.fOY.fPl);
    }
    localAppBrandGlobalSystemConfig.fOH = paramString.optString("CDNBaseURL");
    localAppBrandGlobalSystemConfig.fOB = paramString.optInt("AppMaxRunningCount", 5);
    localAppBrandGlobalSystemConfig.fOC = paramString.optInt("TempFileSizeLimitTotal", 300);
    localAppBrandGlobalSystemConfig.fOD = paramString.optInt("DownloadFileSizeLimit", 10);
    localAppBrandGlobalSystemConfig.fOE = paramString.optInt("MaxLocalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.fOF = paramString.optInt("MaxGlobalStorageItemSize", 1048576);
    localAppBrandGlobalSystemConfig.fOG = paramString.optInt("MaxGlobalStorageSize", 20971520);
    localAppBrandGlobalSystemConfig.fOQ = paramString.optInt("NativeBufferSizeLimitByte", 10485760);
    localAppBrandGlobalSystemConfig.fOR = paramString.optInt("NativeBufferQueueLimitByte", 314572800);
    localObject1 = paramString.optJSONArray("SyncLaunchSceneList");
    if (localObject1 != null)
    {
      localAppBrandGlobalSystemConfig.fOJ = new int[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.fOJ[i] = ((JSONArray)localObject1).optInt(i, 0);
        i += 1;
      }
    }
    if (localAppBrandGlobalSystemConfig.fOJ == null) {
      localAppBrandGlobalSystemConfig.fOJ = AppBrandGlobalSystemConfig.a.fOZ;
    }
    localAppBrandGlobalSystemConfig.fOK = paramString.optInt("StarNumberLimitation", 50);
    localAppBrandGlobalSystemConfig.fOL = paramString.optInt("TaskBarItemCountLimitation", 11);
    localAppBrandGlobalSystemConfig.fOM = paramString.optInt("NewTaskBarRecentsItemCountLimitation", 12);
    localAppBrandGlobalSystemConfig.fON = paramString.optInt("WidgetImageFlowLimitDuration", 1800);
    localAppBrandGlobalSystemConfig.fOO = paramString.optInt("WidgetImageFlowLimitMaxSize", 307200);
    localAppBrandGlobalSystemConfig.fOP = paramString.optInt("WidgetDrawMinInterval", 25);
    localAppBrandGlobalSystemConfig.fOS = paramString.optInt("GameMaxRunningCount", 1);
    localAppBrandGlobalSystemConfig.fOT = paramString.optInt("GameDownloadFileSizeLimit", 50);
    localObject1 = paramString.optJSONArray("SubContextImgDomain");
    if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0)) {
      localAppBrandGlobalSystemConfig.fOU = AppBrandGlobalSystemConfig.a.fPa;
    }
    for (;;)
    {
      localAppBrandGlobalSystemConfig.fOV = paramString.optDouble("GamePerfCollectSamplePercentage", 0.0D);
      localAppBrandGlobalSystemConfig.fOW = paramString.optInt("GamePerfCollectInterval", 60);
      return localAppBrandGlobalSystemConfig;
      localAppBrandGlobalSystemConfig.fOU = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localAppBrandGlobalSystemConfig.fOU[i] = ((JSONArray)localObject1).optString(i, null);
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
    paramParcel.writeInt(this.fOA);
    paramParcel.writeInt(this.fOB);
    paramParcel.writeInt(this.fOC);
    paramParcel.writeInt(this.fOD);
    paramParcel.writeInt(this.fOE);
    paramParcel.writeInt(this.fOF);
    paramParcel.writeInt(this.fOG);
    paramParcel.writeString(this.fOH);
    paramParcel.writeParcelable(this.fOI, paramInt);
    paramParcel.writeIntArray(this.fOJ);
    paramParcel.writeInt(this.fOK);
    paramParcel.writeInt(this.fOL);
    paramParcel.writeInt(this.fON);
    paramParcel.writeInt(this.fOO);
    paramParcel.writeInt(this.fOP);
    paramParcel.writeInt(this.fOQ);
    paramParcel.writeInt(this.fOR);
    paramParcel.writeInt(this.fOS);
    paramParcel.writeInt(this.fOT);
    paramParcel.writeStringArray(this.fOU);
    paramParcel.writeDouble(this.fOV);
    paramParcel.writeInt(this.fOW);
    paramParcel.writeParcelable(this.fOX, paramInt);
    paramParcel.writeParcelable(this.fOY, paramInt);
  }
  
  public static final class HttpSetting
    implements Parcelable
  {
    public static final Parcelable.Creator<HttpSetting> CREATOR = new AppBrandGlobalSystemConfig.HttpSetting.1();
    public ArrayList<String> fPb;
    public ArrayList<String> fPc;
    public int fPd;
    public int fPe;
    public int fPf;
    public int fPg;
    public String fPh;
    public int mode = 0;
    
    public HttpSetting() {}
    
    HttpSetting(Parcel paramParcel)
    {
      this.mode = paramParcel.readInt();
      this.fPb = paramParcel.createStringArrayList();
      this.fPc = paramParcel.createStringArrayList();
      this.fPd = paramParcel.readInt();
      this.fPe = paramParcel.readInt();
      this.fPf = paramParcel.readInt();
      this.fPg = paramParcel.readInt();
      this.fPh = paramParcel.readString();
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mode);
      paramParcel.writeStringList(this.fPb);
      paramParcel.writeStringList(this.fPc);
      paramParcel.writeInt(this.fPd);
      paramParcel.writeInt(this.fPe);
      paramParcel.writeInt(this.fPf);
      paramParcel.writeInt(this.fPg);
      paramParcel.writeString(this.fPh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig
 * JD-Core Version:    0.7.0.1
 */