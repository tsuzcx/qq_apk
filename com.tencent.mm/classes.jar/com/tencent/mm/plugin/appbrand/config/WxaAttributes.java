package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ii;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WxaAttributes
  extends ii
{
  public static final IAutoDBItem.MAutoDBInfo nFK;
  private a oaO;
  private c oaP;
  private WxaAttributes.WxaVersionInfo oaQ;
  private List<WxaAttributes.WxaEntryInfo> oaR = null;
  private b oaS;
  
  static
  {
    AppMethodBeat.i(123525);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[21];
    localMAutoDBInfo.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "usernameHash";
    localMAutoDBInfo.colsMap.put("usernameHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "usernameHash";
    localMAutoDBInfo.columns[1] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "shortNickname";
    localMAutoDBInfo.colsMap.put("shortNickname", "TEXT");
    localStringBuilder.append(" shortNickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "brandIconURL";
    localMAutoDBInfo.colsMap.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "roundedSquareIconURL";
    localMAutoDBInfo.colsMap.put("roundedSquareIconURL", "TEXT");
    localStringBuilder.append(" roundedSquareIconURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "bigHeadURL";
    localMAutoDBInfo.colsMap.put("bigHeadURL", "TEXT");
    localStringBuilder.append(" bigHeadURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "smallHeadURL";
    localMAutoDBInfo.colsMap.put("smallHeadURL", "TEXT");
    localStringBuilder.append(" smallHeadURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "signature";
    localMAutoDBInfo.colsMap.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "appOpt";
    localMAutoDBInfo.colsMap.put("appOpt", "INTEGER default '0' ");
    localStringBuilder.append(" appOpt INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "registerSource";
    localMAutoDBInfo.colsMap.put("registerSource", "TEXT");
    localStringBuilder.append(" registerSource TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "appInfo";
    localMAutoDBInfo.colsMap.put("appInfo", "TEXT");
    localStringBuilder.append(" appInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "versionInfo";
    localMAutoDBInfo.colsMap.put("versionInfo", "TEXT");
    localStringBuilder.append(" versionInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "passThroughInfo";
    localMAutoDBInfo.colsMap.put("passThroughInfo", "TEXT");
    localStringBuilder.append(" passThroughInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "bindWxaInfo";
    localMAutoDBInfo.colsMap.put("bindWxaInfo", "TEXT");
    localStringBuilder.append(" bindWxaInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "dynamicInfo";
    localMAutoDBInfo.colsMap.put("dynamicInfo", "TEXT");
    localStringBuilder.append(" dynamicInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "reserved";
    localMAutoDBInfo.colsMap.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "syncTimeSecond";
    localMAutoDBInfo.colsMap.put("syncTimeSecond", "LONG default '0' ");
    localStringBuilder.append(" syncTimeSecond LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "syncVersion";
    localMAutoDBInfo.colsMap.put("syncVersion", "TEXT");
    localStringBuilder.append(" syncVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "bizMenu";
    localMAutoDBInfo.colsMap.put("bizMenu", "TEXT");
    localStringBuilder.append(" bizMenu TEXT");
    localMAutoDBInfo.columns[21] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    nFK = localMAutoDBInfo;
    AppMethodBeat.o(123525);
  }
  
  private static JSONObject aft(String paramString)
  {
    AppMethodBeat.i(187108);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(187108);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      AppMethodBeat.o(187108);
      return paramString;
    }
    catch (JSONException paramString)
    {
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.WxaAttributes", paramString, "createJsonObjectOrNull", new Object[0]);
      AppMethodBeat.o(187108);
    }
    return null;
  }
  
  private List<WxaAttributes.b.a> k(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(123523);
    Object localObject;
    if (paramJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        int j = paramJSONArray.length();
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= j) {
            break;
          }
          localObject = paramJSONArray.getJSONObject(i);
          WxaAttributes.b.a locala = new WxaAttributes.b.a();
          locala.name = ((JSONObject)localObject).optString("name", "");
          locala.type = ((JSONObject)localObject).optInt("type");
          JSONObject localJSONObject = new JSONObject(((JSONObject)localObject).optString("value", ""));
          locala.userName = localJSONObject.optString("userName", "");
          locala.fve = localJSONObject.optString("pagePath", "");
          locala.version = localJSONObject.optInt("version");
          locala.obe = k(((JSONObject)localObject).optJSONArray("sub_button_list"));
          localArrayList.add(locala);
          i += 1;
        }
        localObject = null;
      }
      catch (JSONException paramJSONArray)
      {
        AppMethodBeat.o(123523);
        return null;
      }
    }
    AppMethodBeat.o(123523);
    return localObject;
  }
  
  public final String bFa()
  {
    AppMethodBeat.i(187106);
    Object localObject = new HashMap();
    ((Map)localObject).put("NickName", this.field_nickname);
    ((Map)localObject).put("BrandIconURL", this.field_brandIconURL);
    ((Map)localObject).put("BigHeadImgUrl", this.field_bigHeadURL);
    ((Map)localObject).put("SmallHeadImgUrl", this.field_smallHeadURL);
    ((Map)localObject).put("Signature", this.field_signature);
    ((Map)localObject).put("WxAppOpt", Integer.valueOf(this.field_appOpt));
    ((Map)localObject).put("RegisterSource", aft(this.field_registerSource));
    ((Map)localObject).put("WxaAppInfo", aft(this.field_appInfo));
    ((Map)localObject).put("WxaAppVersionInfo", aft(this.field_versionInfo));
    ((Map)localObject).put("BindWxaInfo", aft(this.field_bindWxaInfo));
    ((Map)localObject).put("WxaAppDynamic", aft(this.field_dynamicInfo));
    ((Map)localObject).put("MMBizMenu", aft(this.field_bizMenu));
    localObject = new JSONObject((Map)localObject).toString();
    AppMethodBeat.o(187106);
    return localObject;
  }
  
  public final a bLF()
  {
    AppMethodBeat.i(123518);
    if (this.oaO == null) {
      this.oaO = a.afu(this.field_appInfo);
    }
    a locala = this.oaO;
    AppMethodBeat.o(123518);
    return locala;
  }
  
  public final c bLG()
  {
    boolean bool2 = true;
    int i = 0;
    AppMethodBeat.i(123519);
    if (this.oaP == null) {
      try
      {
        Object localObject1 = new JSONObject(this.field_dynamicInfo);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new JSONObject();
        }
        this.oaP = new c();
        Object localObject3 = ((JSONObject)localObject2).optJSONObject("NewSetting");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new JSONObject();
        }
        this.oaP.obf.cxI = ((JSONObject)localObject1).optInt("Uint32MaxLocalstorageSizeInMB", 5);
        this.oaP.obf.obh = ((JSONObject)localObject1).optInt("Uint32OpendataMaxLocalstorageSizeInMB", 5);
        this.oaP.obf.obi = ((JSONObject)localObject1).optInt("MaxCodeSize", 5);
        this.oaP.obf.nYK = ((JSONObject)localObject1).optInt("ExpendedMaxWebviewDepth", 5);
        this.oaP.obf.cxo = ((JSONObject)localObject1).optInt("MaxBackgroundLifespan", 600);
        this.oaP.obf.cxp = ((JSONObject)localObject1).optInt("MaxRequestConcurrent", 10);
        this.oaP.obf.cxq = ((JSONObject)localObject1).optInt("MaxUploadConcurrent", 10);
        this.oaP.obf.cxr = ((JSONObject)localObject1).optInt("MaxDownloadConcurrent", 10);
        this.oaP.obf.cxs = ((JSONObject)localObject1).optInt("MaxWebsocketConnect", 5);
        this.oaP.obf.cxt = ((JSONObject)localObject1).optInt("MaxWorkerConcurrent", 1);
        localObject3 = this.oaP.obf;
        if (((JSONObject)localObject1).optInt("WebsocketSkipPortCheck", 0) != 0)
        {
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cxu = bool1;
          localObject3 = this.oaP.obf;
          if (((JSONObject)localObject1).optInt("TLSSkipHostnameCheck", 0) == 0) {
            break label871;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cxv = bool1;
          this.oaP.obf.obk = ((JSONObject)localObject1).optInt("Uint32MaxFileStorageSizeInMB", 10);
          this.oaP.obf.obl = ((JSONObject)localObject1).optInt("Uint32MaxTempFileStorageSizeInMB", 300);
          this.oaP.obf.obm = ((JSONObject)localObject1).optInt("Uint32MinTempFileStorageSizeInMB", 100);
          this.oaP.obf.obn = ((JSONObject)localObject1).optInt("BackgroundNetworkInterruptedTimeout", 5);
          localObject3 = this.oaP.obf;
          if (((JSONObject)localObject1).optInt("CanKeepAliveByAudioPlay", 0) <= 0) {
            break label876;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).nYL = bool1;
          this.oaP.obf.nYP = ((JSONObject)localObject1).optInt("LifeSpanBeforeSuspend", 5);
          this.oaP.obf.nYQ = ((JSONObject)localObject1).optInt("LifeSpanAfterSuspend", 300);
          localObject3 = this.oaP.obf;
          if (((JSONObject)localObject1).optInt("ScanCodeEnableZZM", 0) == 0) {
            break label881;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cxG = bool1;
          localObject3 = this.oaP.obf;
          if (((JSONObject)localObject1).optInt("CanPreFetchData", 0) <= 0) {
            break label886;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).nRU = bool1;
          localObject3 = this.oaP.obf;
          if (((JSONObject)localObject1).optInt("CanPeriodFetchData", 0) <= 0) {
            break label891;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).nRV = bool1;
          this.oaP.obf.nRW = ((JSONObject)localObject1).optInt("PeriodFetchData", 0);
          this.oaP.obf.nRX = ((JSONObject)localObject1).optInt("PeriodFetchDataDay", 7);
          this.oaP.obf.nYp = ((JSONObject)localObject1).optInt("GuaranteeFlag", 0);
          localObject3 = this.oaP.obf;
          if (((JSONObject)localObject1).optInt("CanShowLoadingAdvert", 0) <= 0) {
            break label896;
          }
          bool1 = bool2;
          ((WxaAttributes.c.a)localObject3).obo = bool1;
          this.oaP.obf.nYq = ((JSONObject)localObject1).optInt("BrandOfficialLabel", 0);
          this.oaP.obf.obp = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMaxMicSec", 13000L);
          this.oaP.obf.obq = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMaxMicSecForWeakNet", 10000L);
          this.oaP.obf.obr = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMinMicSec", 0L);
          this.oaP.obf.obs = ((JSONObject)localObject1).optLong("NextTryOpenWxaDisMicSec", 10000L);
          localObject1 = ((JSONObject)localObject2).optJSONArray("NewCategories");
          if (localObject1 == null) {
            break label901;
          }
          this.oaP.obg = new LinkedList();
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 != null) {
              this.oaP.obg.add(new Pair(((JSONObject)localObject2).optString("first"), ((JSONObject)localObject2).optString("second")));
            }
            i += 1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localc = null;
          continue;
          boolean bool1 = false;
          continue;
          label871:
          bool1 = false;
          continue;
          label876:
          bool1 = false;
          continue;
          label881:
          bool1 = false;
          continue;
          label886:
          bool1 = false;
          continue;
          label891:
          bool1 = false;
          continue;
          label896:
          bool1 = false;
        }
      }
    }
    label901:
    c localc = this.oaP;
    AppMethodBeat.o(123519);
    return localc;
  }
  
  public final WxaAttributes.WxaVersionInfo bLH()
  {
    AppMethodBeat.i(123520);
    if ((this.oaQ == null) && (!Util.isNullOrNil(this.field_versionInfo)))
    {
      localWxaVersionInfo = WxaAttributes.WxaVersionInfo.afv(this.field_versionInfo);
      this.oaQ = localWxaVersionInfo;
      AppMethodBeat.o(123520);
      return localWxaVersionInfo;
    }
    WxaAttributes.WxaVersionInfo localWxaVersionInfo = this.oaQ;
    AppMethodBeat.o(123520);
    return localWxaVersionInfo;
  }
  
  public final List<WxaAttributes.WxaEntryInfo> bLI()
  {
    AppMethodBeat.i(123521);
    if ((this.oaR == null) && (!Util.isNullOrNil(this.field_bindWxaInfo))) {
      try
      {
        JSONArray localJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
        if (localJSONArray != null)
        {
          this.oaR = new LinkedList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject != null)
            {
              String str = localJSONObject.optString("username");
              if (!Util.isNullOrNil(str))
              {
                WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
                localWxaEntryInfo.username = str;
                localWxaEntryInfo.title = localJSONObject.optString("title");
                localWxaEntryInfo.iconUrl = localJSONObject.optString("icon_url");
                this.oaR.add(localWxaEntryInfo);
              }
            }
            i += 1;
          }
        }
        localList = this.oaR;
      }
      catch (Exception localException)
      {
        this.oaR = null;
      }
    }
    List localList;
    AppMethodBeat.o(123521);
    return localList;
  }
  
  public final b bLJ()
  {
    AppMethodBeat.i(123522);
    if ((this.oaS == null) && (!Util.isNullOrNil(this.field_bizMenu))) {}
    try
    {
      Object localObject = new JSONObject(this.field_bizMenu);
      this.oaS = new b();
      this.oaS.eZA = ((JSONObject)localObject).optInt("interactive_mode", 0);
      this.oaS.type = ((JSONObject)localObject).optInt("type", 0);
      this.oaS.obd = k(((JSONObject)localObject).optJSONArray("button_list"));
      localObject = this.oaS;
      AppMethodBeat.o(123522);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.oaS = null;
      }
    }
  }
  
  public final void bLK()
  {
    int i = 0;
    AppMethodBeat.i(187102);
    String str1 = String.format(Locale.ENGLISH, ">>>>>> WxaAttributes(%s|%s|%s)START >>>>>>", new Object[] { this.field_username, this.field_appId, this.field_nickname });
    String str2 = ">>> field_appInfo=" + this.field_appInfo;
    String str3 = ">>> field_versionInfo=" + this.field_versionInfo;
    String str4 = ">>> field_dynamicInfo=" + this.field_dynamicInfo;
    String str5 = String.format(Locale.ENGLISH, ">>>>>> WxaAttributes(%s|%s|%s) END >>>>>>", new Object[] { this.field_username, this.field_appId, this.field_nickname });
    while (i < 5)
    {
      com.tencent.stubs.logger.Log.println(4, "MicroMsg.AppBrand.WxaAttributes", new String[] { str1, str2, str3, str4, str5 }[i]);
      i += 1;
    }
    AppMethodBeat.o(187102);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(123517);
    super.convertFrom(paramCursor);
    this.oaO = null;
    this.oaP = null;
    this.oaQ = null;
    this.oaR = null;
    this.oaS = null;
    AppMethodBeat.o(123517);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nFK;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123524);
    String str = "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + ", field_bizMenu='" + this.field_bizMenu + '\'' + '}';
    AppMethodBeat.o(123524);
    return str;
  }
  
  public static final class a
  {
    public long cxN = 0L;
    public long nQo = 0L;
    public String nXX;
    public String oaU;
    private int oaV;
    public List<String> oaW;
    public List<String> oaX;
    public List<String> oaY;
    public List<String> oaZ;
    public List<String> oba;
    public List<String> obb;
    public String obc;
    public int originalFlag;
    public int serviceType;
    
    public static a afu(String paramString)
    {
      AppMethodBeat.i(123490);
      if (Util.isNullOrNil(paramString))
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
        AppMethodBeat.o(123490);
        return null;
      }
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        a locala = new a();
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("RunningFlagInfo");
        if (localJSONObject2 != null)
        {
          locala.cxN = localJSONObject2.optLong("RunningFlag");
          locala.oaU = localJSONObject2.optString("AppOpenForbiddenUrl");
          locala.nQo = localJSONObject2.optLong("CanNotStarWxaBeforeTime", 0L);
        }
        localJSONObject2 = localJSONObject1.optJSONObject("Network");
        if (localJSONObject2 != null)
        {
          locala.oaW = ad.n(localJSONObject2.optJSONArray("RequestDomain"));
          locala.oaX = ad.n(localJSONObject2.optJSONArray("WsRequestDomain"));
          locala.oaY = ad.n(localJSONObject2.optJSONArray("UploadDomain"));
          locala.oaZ = ad.n(localJSONObject2.optJSONArray("DownloadDomain"));
          locala.oba = ad.n(localJSONObject2.optJSONArray("UDPDomain"));
          locala.obb = ad.n(localJSONObject2.optJSONArray("TCPDomain"));
        }
        locala.oaV = localJSONObject1.optInt("WechatPluginApp", 0);
        locala.serviceType = localJSONObject1.optInt("AppServiceType", 0);
        locala.obc = localJSONObject1.optString("fromBusinessUsername");
        locala.originalFlag = localJSONObject1.optInt("OriginalFlag", 0);
        locala.nXX = localJSONObject1.optString("OriginalRedirectUrl");
        paramString = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", new Object[] { paramString, localException });
          paramString = null;
        }
      }
      AppMethodBeat.o(123490);
      return paramString;
    }
    
    public final boolean Qv()
    {
      return this.serviceType == 4;
    }
    
    public final boolean bLL()
    {
      return (this.oaV > 0) || (this.serviceType == 7);
    }
  }
  
  public static final class b
  {
    public int eZA;
    public List<WxaAttributes.b.a> obd;
    public int type;
  }
  
  public static final class c
  {
    public a obf;
    public List<Pair<String, String>> obg;
    
    public c()
    {
      AppMethodBeat.i(123491);
      this.obf = new a();
      AppMethodBeat.o(123491);
    }
    
    public static final class a
    {
      public boolean cxG;
      public int cxI;
      public int cxo;
      public int cxp;
      public int cxq;
      public int cxr;
      public int cxs;
      public int cxt;
      public boolean cxu;
      public boolean cxv;
      public boolean nRU;
      public boolean nRV;
      public int nRW;
      public int nRX;
      public int nYK;
      public boolean nYL;
      public int nYP;
      public int nYQ;
      public int nYp;
      public int nYq;
      public int obh;
      public int obi;
      public int obk;
      public int obl;
      public int obm;
      public int obn;
      public boolean obo;
      public long obp;
      public long obq;
      public long obr;
      public long obs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes
 * JD-Core Version:    0.7.0.1
 */