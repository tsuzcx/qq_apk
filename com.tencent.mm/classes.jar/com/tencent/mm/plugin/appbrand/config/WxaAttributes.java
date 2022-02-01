package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;>;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WxaAttributes
  extends hz
{
  public static final IAutoDBItem.MAutoDBInfo kLR;
  private a lgo;
  private c lgp;
  private WxaVersionInfo lgq;
  private List<WxaEntryInfo> lgr = null;
  private b lgs;
  
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
    kLR = localMAutoDBInfo;
    AppMethodBeat.o(123525);
  }
  
  private static JSONObject XH(String paramString)
  {
    AppMethodBeat.i(225286);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(225286);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      AppMethodBeat.o(225286);
      return paramString;
    }
    catch (JSONException paramString)
    {
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.WxaAttributes", paramString, "createJsonObjectOrNull", new Object[0]);
      AppMethodBeat.o(225286);
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
          locala.dCx = localJSONObject.optString("pagePath", "");
          locala.version = localJSONObject.optInt("version");
          locala.lgC = k(((JSONObject)localObject).optJSONArray("sub_button_list"));
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
  
  public final a bAn()
  {
    AppMethodBeat.i(123518);
    if (this.lgo == null) {
      this.lgo = a.XI(this.field_appInfo);
    }
    a locala = this.lgo;
    AppMethodBeat.o(123518);
    return locala;
  }
  
  public final c bAo()
  {
    boolean bool2 = true;
    int i = 0;
    AppMethodBeat.i(123519);
    if (this.lgp == null) {
      try
      {
        Object localObject1 = new JSONObject(this.field_dynamicInfo);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new JSONObject();
        }
        this.lgp = new c();
        Object localObject3 = ((JSONObject)localObject2).optJSONObject("NewSetting");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new JSONObject();
        }
        this.lgp.lgD.cza = ((JSONObject)localObject1).optInt("MaxLocalstorageSize", 5);
        this.lgp.lgD.lgF = ((JSONObject)localObject1).optInt("OpendataMaxLocalstorageSize", 5);
        this.lgp.lgD.lgG = ((JSONObject)localObject1).optInt("MaxCodeSize", 5);
        this.lgp.lgD.lex = ((JSONObject)localObject1).optInt("ExpendedMaxWebviewDepth", 5);
        this.lgp.lgD.cyJ = ((JSONObject)localObject1).optInt("MaxBackgroundLifespan", 600);
        this.lgp.lgD.cyK = ((JSONObject)localObject1).optInt("MaxRequestConcurrent", 5);
        this.lgp.lgD.cyL = ((JSONObject)localObject1).optInt("MaxUploadConcurrent", 5);
        this.lgp.lgD.cyM = ((JSONObject)localObject1).optInt("MaxDownloadConcurrent", 5);
        this.lgp.lgD.cyN = ((JSONObject)localObject1).optInt("MaxWebsocketConnect", 2);
        this.lgp.lgD.cyO = ((JSONObject)localObject1).optInt("MaxWorkerConcurrent", 1);
        localObject3 = this.lgp.lgD;
        if (((JSONObject)localObject1).optInt("WebsocketSkipPortCheck", 0) != 0)
        {
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cyP = bool1;
          localObject3 = this.lgp.lgD;
          if (((JSONObject)localObject1).optInt("TLSSkipHostnameCheck", 0) == 0) {
            break label827;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cyQ = bool1;
          this.lgp.lgD.lgH = ((JSONObject)localObject1).optInt("MaxFileStorageSize", 10);
          this.lgp.lgD.lgI = ((JSONObject)localObject1).optInt("BackgroundNetworkInterruptedTimeout", 5);
          localObject3 = this.lgp.lgD;
          if (((JSONObject)localObject1).optInt("CanKeepAliveByAudioPlay", 0) <= 0) {
            break label832;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).ley = bool1;
          this.lgp.lgD.leC = ((JSONObject)localObject1).optInt("LifeSpanBeforeSuspend", 5);
          this.lgp.lgD.leD = ((JSONObject)localObject1).optInt("LifeSpanAfterSuspend", 300);
          localObject3 = this.lgp.lgD;
          if (((JSONObject)localObject1).optInt("ScanCodeEnableZZM", 0) == 0) {
            break label837;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cyY = bool1;
          localObject3 = this.lgp.lgD;
          if (((JSONObject)localObject1).optInt("CanPreFetchData", 0) <= 0) {
            break label842;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).kXI = bool1;
          localObject3 = this.lgp.lgD;
          if (((JSONObject)localObject1).optInt("CanPeriodFetchData", 0) <= 0) {
            break label847;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).kXJ = bool1;
          this.lgp.lgD.kXK = ((JSONObject)localObject1).optInt("PeriodFetchData", 0);
          this.lgp.lgD.kXL = ((JSONObject)localObject1).optInt("PeriodFetchDataDay", 7);
          this.lgp.lgD.leb = ((JSONObject)localObject1).optInt("GuaranteeFlag", 0);
          localObject3 = this.lgp.lgD;
          if (((JSONObject)localObject1).optInt("CanShowLoadingAdvert", 0) <= 0) {
            break label852;
          }
          bool1 = bool2;
          ((WxaAttributes.c.a)localObject3).lgJ = bool1;
          this.lgp.lgD.lec = ((JSONObject)localObject1).optInt("BrandOfficialLabel", 0);
          this.lgp.lgD.lgK = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMaxMicSec", 13000L);
          this.lgp.lgD.lgL = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMaxMicSecForWeakNet", 10000L);
          this.lgp.lgD.lgM = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMinMicSec", 0L);
          this.lgp.lgD.lgN = ((JSONObject)localObject1).optLong("NextTryOpenWxaDisMicSec", 10000L);
          localObject1 = ((JSONObject)localObject2).optJSONArray("NewCategories");
          if (localObject1 == null) {
            break label857;
          }
          this.lgp.lgE = new LinkedList();
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 != null) {
              this.lgp.lgE.add(new Pair(((JSONObject)localObject2).optString("first"), ((JSONObject)localObject2).optString("second")));
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
          label827:
          bool1 = false;
          continue;
          label832:
          bool1 = false;
          continue;
          label837:
          bool1 = false;
          continue;
          label842:
          bool1 = false;
          continue;
          label847:
          bool1 = false;
          continue;
          label852:
          bool1 = false;
        }
      }
    }
    label857:
    c localc = this.lgp;
    AppMethodBeat.o(123519);
    return localc;
  }
  
  public final WxaVersionInfo bAp()
  {
    AppMethodBeat.i(123520);
    if ((this.lgq == null) && (!Util.isNullOrNil(this.field_versionInfo)))
    {
      localWxaVersionInfo = WxaVersionInfo.XJ(this.field_versionInfo);
      this.lgq = localWxaVersionInfo;
      AppMethodBeat.o(123520);
      return localWxaVersionInfo;
    }
    WxaVersionInfo localWxaVersionInfo = this.lgq;
    AppMethodBeat.o(123520);
    return localWxaVersionInfo;
  }
  
  public final List<WxaEntryInfo> bAq()
  {
    AppMethodBeat.i(123521);
    if ((this.lgr == null) && (!Util.isNullOrNil(this.field_bindWxaInfo))) {
      try
      {
        JSONArray localJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
        if (localJSONArray != null)
        {
          this.lgr = new LinkedList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject != null)
            {
              String str = localJSONObject.optString("username");
              if (!Util.isNullOrNil(str))
              {
                WxaEntryInfo localWxaEntryInfo = new WxaEntryInfo();
                localWxaEntryInfo.username = str;
                localWxaEntryInfo.title = localJSONObject.optString("title");
                localWxaEntryInfo.iconUrl = localJSONObject.optString("icon_url");
                this.lgr.add(localWxaEntryInfo);
              }
            }
            i += 1;
          }
        }
        localList = this.lgr;
      }
      catch (Exception localException)
      {
        this.lgr = null;
      }
    }
    List localList;
    AppMethodBeat.o(123521);
    return localList;
  }
  
  public final b bAr()
  {
    AppMethodBeat.i(123522);
    if ((this.lgs == null) && (!Util.isNullOrNil(this.field_bizMenu))) {}
    try
    {
      Object localObject = new JSONObject(this.field_bizMenu);
      this.lgs = new b();
      this.lgs.dhT = ((JSONObject)localObject).optInt("interactive_mode", 0);
      this.lgs.type = ((JSONObject)localObject).optInt("type", 0);
      this.lgs.lgB = k(((JSONObject)localObject).optJSONArray("button_list"));
      localObject = this.lgs;
      AppMethodBeat.o(123522);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.lgs = null;
      }
    }
  }
  
  public final void bAs()
  {
    int i = 0;
    AppMethodBeat.i(225284);
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
    AppMethodBeat.o(225284);
  }
  
  public final String bua()
  {
    AppMethodBeat.i(225285);
    Object localObject = new HashMap();
    ((Map)localObject).put("NickName", this.field_nickname);
    ((Map)localObject).put("BrandIconURL", this.field_brandIconURL);
    ((Map)localObject).put("BigHeadImgUrl", this.field_bigHeadURL);
    ((Map)localObject).put("SmallHeadImgUrl", this.field_smallHeadURL);
    ((Map)localObject).put("Signature", this.field_signature);
    ((Map)localObject).put("WxAppOpt", Integer.valueOf(this.field_appOpt));
    ((Map)localObject).put("RegisterSource", XH(this.field_registerSource));
    ((Map)localObject).put("WxaAppInfo", XH(this.field_appInfo));
    ((Map)localObject).put("WxaAppVersionInfo", XH(this.field_versionInfo));
    ((Map)localObject).put("BindWxaInfo", XH(this.field_bindWxaInfo));
    ((Map)localObject).put("WxaAppDynamic", XH(this.field_dynamicInfo));
    ((Map)localObject).put("MMBizMenu", XH(this.field_bizMenu));
    localObject = new JSONObject((Map)localObject).toString();
    AppMethodBeat.o(225285);
    return localObject;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(123517);
    super.convertFrom(paramCursor);
    this.lgo = null;
    this.lgp = null;
    this.lgq = null;
    this.lgr = null;
    this.lgs = null;
    AppMethodBeat.o(123517);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return kLR;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123524);
    String str = "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + ", field_bizMenu='" + this.field_bizMenu + '\'' + '}';
    AppMethodBeat.o(123524);
    return str;
  }
  
  public static final class WxaEntryInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaEntryInfo> CREATOR;
    public String iconUrl;
    public String lgO;
    public String title;
    public String username;
    
    static
    {
      AppMethodBeat.i(123495);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123495);
    }
    
    public WxaEntryInfo() {}
    
    protected WxaEntryInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123494);
      this.username = paramParcel.readString();
      this.title = paramParcel.readString();
      this.lgO = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      AppMethodBeat.o(123494);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123493);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.lgO);
      paramParcel.writeString(this.iconUrl);
      AppMethodBeat.o(123493);
    }
  }
  
  public static class WxaPluginCodeInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaPluginCodeInfo> CREATOR;
    public List<Integer> contexts;
    public boolean lgP;
    public String md5;
    public String prefixPath;
    public String provider;
    public int version;
    
    static
    {
      AppMethodBeat.i(123500);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123500);
    }
    
    public WxaPluginCodeInfo()
    {
      AppMethodBeat.i(175234);
      this.contexts = new LinkedList();
      AppMethodBeat.o(175234);
    }
    
    protected WxaPluginCodeInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123499);
      this.contexts = new LinkedList();
      this.provider = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.md5 = paramParcel.readString();
      this.prefixPath = paramParcel.readString();
      if (paramParcel.readByte() == 1) {}
      for (;;)
      {
        this.lgP = bool;
        if (this.contexts == null) {
          this.contexts = new LinkedList();
        }
        paramParcel.readList(this.contexts, Integer.class.getClassLoader());
        AppMethodBeat.o(123499);
        return;
        bool = false;
      }
    }
    
    public static List<WxaPluginCodeInfo> a(List<WxaAttributes.WxaWidgetInfo> paramList, Object paramObject, int paramInt)
    {
      AppMethodBeat.i(225281);
      Object localObject = null;
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        for (paramList = (List<WxaAttributes.WxaWidgetInfo>)localObject; localIterator.hasNext(); paramList = ((WxaAttributes.WxaWidgetInfo)localObject).lhk)
        {
          localObject = (WxaAttributes.WxaWidgetInfo)localIterator.next();
          if (((WxaAttributes.WxaWidgetInfo)localObject).packageType != paramInt) {
            break label76;
          }
        }
      }
      for (;;)
      {
        localObject = paramList;
        if (paramList == null) {
          localObject = cz(paramObject);
        }
        AppMethodBeat.o(225281);
        return localObject;
        label76:
        break;
        paramList = null;
      }
    }
    
    public static List<WxaPluginCodeInfo> cz(Object paramObject)
    {
      AppMethodBeat.i(225282);
      if (paramObject == null)
      {
        AppMethodBeat.o(225282);
        return null;
      }
      for (;;)
      {
        int i;
        try
        {
          if ((paramObject instanceof String))
          {
            paramObject = new JSONArray((String)paramObject);
            if (paramObject != null)
            {
              i = paramObject.length();
              if (i != 0) {}
            }
            else
            {
              AppMethodBeat.o(225282);
              return null;
            }
          }
          else
          {
            if ((paramObject instanceof JSONArray))
            {
              paramObject = (JSONArray)paramObject;
              continue;
            }
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "WxaPluginCodeInfo.optPluginCodeInfoList() invalid pluginCodeObj:%s", new Object[] { paramObject.getClass().getName() });
            paramObject = null;
            continue;
          }
          LinkedList localLinkedList = new LinkedList();
          i = 0;
          if (i < paramObject.length())
          {
            Object localObject = paramObject.getJSONObject(i);
            if (localObject == null) {
              break label336;
            }
            WxaPluginCodeInfo localWxaPluginCodeInfo = new WxaPluginCodeInfo();
            localWxaPluginCodeInfo.provider = ((JSONObject)localObject).optString("plugin_id");
            localWxaPluginCodeInfo.version = ((JSONObject)localObject).optInt("inner_version");
            localWxaPluginCodeInfo.md5 = ((JSONObject)localObject).optString("md5");
            localWxaPluginCodeInfo.prefixPath = ((JSONObject)localObject).optString("prefix_path");
            if (!((JSONObject)localObject).optBoolean("auto_update"))
            {
              if (((JSONObject)localObject).optInt("auto_update", 0) <= 0) {
                break label343;
              }
              break label331;
              localWxaPluginCodeInfo.lgP = bool;
              localObject = ((JSONObject)localObject).optJSONArray("contexts");
              if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
                break label348;
              }
              localWxaPluginCodeInfo.contexts.add(Integer.valueOf(0));
              localLinkedList.add(localWxaPluginCodeInfo);
              break label336;
              if (j < ((JSONArray)localObject).length())
              {
                localWxaPluginCodeInfo.contexts.add(Integer.valueOf(((JSONArray)localObject).optInt(j)));
                j += 1;
                continue;
              }
              continue;
            }
          }
          else
          {
            AppMethodBeat.o(225282);
            return localLinkedList;
          }
        }
        catch (JSONException paramObject)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramObject });
          AppMethodBeat.o(225282);
          return null;
        }
        label331:
        boolean bool = true;
        continue;
        label336:
        i += 1;
        continue;
        label343:
        bool = false;
        continue;
        label348:
        int j = 0;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123498);
      paramParcel.writeString(this.provider);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.prefixPath);
      if (this.lgP) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeList(this.contexts);
        AppMethodBeat.o(123498);
        return;
      }
    }
  }
  
  public static final class WxaVersionCoverImageInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaVersionCoverImageInfo> CREATOR;
    public String lgQ;
    public String lgR;
    
    static
    {
      AppMethodBeat.i(123504);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123504);
    }
    
    public WxaVersionCoverImageInfo() {}
    
    protected WxaVersionCoverImageInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123503);
      this.lgQ = paramParcel.readString();
      this.lgR = paramParcel.readString();
      AppMethodBeat.o(123503);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123502);
      paramParcel.writeString(this.lgQ);
      paramParcel.writeString(this.lgR);
      AppMethodBeat.o(123502);
    }
  }
  
  public static final class WxaVersionInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaVersionInfo> CREATOR;
    public int appVersion;
    public boolean cBF;
    public int cyu;
    public List<WxaAttributes.WxaWidgetInfo> jmL;
    public String lgS;
    public String lgT;
    public WxaAttributes.WxaVersionCoverImageInfo lgU;
    public List<WxaAttributes.WxaPluginCodeInfo> lgV;
    public int lgW;
    public boolean lgX;
    public String lgY;
    public String lgZ;
    public String lha;
    public long lhb;
    public String lhc;
    public String lhd;
    public String lhe;
    public String lhf;
    public List<WxaAttributes.WxaVersionModuleInfo> moduleList;
    
    static
    {
      AppMethodBeat.i(123509);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123509);
    }
    
    public WxaVersionInfo()
    {
      this.lhc = "";
      this.lhd = "";
      this.lhe = "";
      this.lhf = "";
      this.cBF = false;
    }
    
    protected WxaVersionInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123508);
      this.lhc = "";
      this.lhd = "";
      this.lhe = "";
      this.lhf = "";
      this.cBF = false;
      this.appVersion = paramParcel.readInt();
      this.cyu = paramParcel.readInt();
      this.lgS = paramParcel.readString();
      this.lgT = paramParcel.readString();
      this.lgU = ((WxaAttributes.WxaVersionCoverImageInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionCoverImageInfo.class.getClassLoader()));
      this.lgV = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      this.lgW = paramParcel.readInt();
      this.moduleList = paramParcel.createTypedArrayList(WxaAttributes.WxaVersionModuleInfo.CREATOR);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.lgX = bool;
        this.lgY = paramParcel.readString();
        this.lgZ = paramParcel.readString();
        this.lha = paramParcel.readString();
        this.jmL = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        this.lhc = paramParcel.readString();
        this.lhd = paramParcel.readString();
        this.lhe = paramParcel.readString();
        this.lhf = paramParcel.readString();
        boolean[] arrayOfBoolean = new boolean[1];
        paramParcel.readBooleanArray(arrayOfBoolean);
        this.cBF = arrayOfBoolean[0];
        AppMethodBeat.o(123508);
        return;
      }
    }
    
    public static WxaVersionInfo XJ(String paramString)
    {
      AppMethodBeat.i(123506);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(123506);
        return null;
      }
      l = Util.currentTicks();
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        WxaVersionInfo localWxaVersionInfo = new WxaVersionInfo();
        localWxaVersionInfo.appVersion = localJSONObject1.optInt("AppVersion", 0);
        localWxaVersionInfo.cyu = localJSONObject1.optInt("VersionState", -1);
        localWxaVersionInfo.lgS = localJSONObject1.optString("VersionMD5");
        localWxaVersionInfo.lgT = localJSONObject1.optString("device_orientation");
        localWxaVersionInfo.lgZ = localJSONObject1.optString("client_js_ext_info");
        localWxaVersionInfo.lgW = localJSONObject1.optInt("code_size");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("loading_image_info");
        if (localJSONObject2 != null)
        {
          localWxaVersionInfo.lgU = new WxaAttributes.WxaVersionCoverImageInfo();
          localWxaVersionInfo.lgU.lgQ = localJSONObject2.optString("url");
          localWxaVersionInfo.lgU.lgR = localJSONObject2.optString("progressbar_color");
        }
        JSONObject localJSONObject3 = localJSONObject1.optJSONObject("fake_native_loading_style_info");
        if (localJSONObject3 != null)
        {
          localJSONObject2 = localJSONObject3.optJSONObject("white_style");
          localJSONObject3 = localJSONObject3.optJSONObject("black_style");
          if (localJSONObject2 != null)
          {
            if (localJSONObject2.has("navigation_bar_text_color")) {
              localWxaVersionInfo.lhc = localJSONObject2.optString("navigation_bar_text_color");
            }
            if (localJSONObject2.has("background_color")) {
              localWxaVersionInfo.lhd = localJSONObject2.optString("background_color");
            }
          }
          if (localJSONObject3 != null)
          {
            if (localJSONObject3.has("navigation_bar_text_color")) {
              localWxaVersionInfo.lhe = localJSONObject3.optString("navigation_bar_text_color");
            }
            if (localJSONObject3.has("background_color")) {
              localWxaVersionInfo.lhf = localJSONObject3.optString("background_color");
            }
          }
        }
        localWxaVersionInfo.moduleList = WxaAttributes.WxaVersionModuleInfo.l(localJSONObject1.optJSONArray("module_list"));
        localWxaVersionInfo.lgX = localJSONObject1.optBoolean("UseModule", false);
        localWxaVersionInfo.lgY = localJSONObject1.optString("EntranceModule");
        localWxaVersionInfo.lha = localJSONObject1.optString("without_lib_md5");
        localWxaVersionInfo.jmL = WxaAttributes.WxaWidgetInfo.m(localJSONObject1.optJSONArray("widget_list"));
        localWxaVersionInfo.lgV = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionInfo.jmL, localJSONObject1.opt("separated_plugin_list"), 22);
        localWxaVersionInfo.lhb = localJSONObject1.optLong("ForceSyncUpdateWhenLaunchLastInterval", -1L);
        localWxaVersionInfo.cBF = localJSONObject1.optBoolean("resizable", false);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
        paramString = localWxaVersionInfo;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
          paramString = null;
        }
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
        AppMethodBeat.o(123506);
      }
      AppMethodBeat.o(123506);
      return paramString;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123507);
      paramParcel.writeInt(this.appVersion);
      paramParcel.writeInt(this.cyu);
      paramParcel.writeString(this.lgS);
      paramParcel.writeString(this.lgT);
      paramParcel.writeParcelable(this.lgU, paramInt);
      paramParcel.writeTypedList(this.lgV);
      paramParcel.writeInt(this.lgW);
      paramParcel.writeTypedList(this.moduleList);
      if (this.lgX) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.lgY);
        paramParcel.writeString(this.lgZ);
        paramParcel.writeString(this.lha);
        paramParcel.writeTypedList(this.jmL);
        paramParcel.writeString(this.lhc);
        paramParcel.writeString(this.lhd);
        paramParcel.writeString(this.lhe);
        paramParcel.writeString(this.lhf);
        paramParcel.writeBooleanArray(new boolean[] { this.cBF });
        AppMethodBeat.o(123507);
        return;
      }
    }
  }
  
  public static class WxaVersionModuleInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaVersionModuleInfo> CREATOR;
    public String[] aliases;
    public boolean independent;
    public String lha;
    public List<WxaAttributes.WxaPluginCodeInfo> lhg;
    public List<WxaAttributes.WxaWidgetInfo> lhh;
    private JSONObject lhi;
    public String md5;
    public String name;
    public int size;
    
    static
    {
      AppMethodBeat.i(123516);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123516);
    }
    
    public WxaVersionModuleInfo() {}
    
    protected WxaVersionModuleInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123515);
      this.name = paramParcel.readString();
      this.md5 = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.independent = bool;
        this.size = paramParcel.readInt();
        this.aliases = paramParcel.createStringArray();
        this.lhg = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
        this.lha = paramParcel.readString();
        this.lhh = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        AppMethodBeat.o(123515);
        return;
      }
    }
    
    private static String[] F(JSONObject paramJSONObject)
    {
      int i = 0;
      AppMethodBeat.i(123513);
      paramJSONObject = paramJSONObject.optJSONArray("alias");
      if ((paramJSONObject == null) || (paramJSONObject.length() <= 0))
      {
        AppMethodBeat.o(123513);
        return new String[0];
      }
      String[] arrayOfString = new String[paramJSONObject.length()];
      while (i < paramJSONObject.length())
      {
        arrayOfString[i] = paramJSONObject.optString(i);
        i += 1;
      }
      AppMethodBeat.o(123513);
      return arrayOfString;
    }
    
    public static List<WxaVersionModuleInfo> XK(String paramString)
    {
      AppMethodBeat.i(123512);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(123512);
        return null;
      }
      try
      {
        Object localObject = new JSONArray(paramString);
        int i = ((JSONArray)localObject).length();
        if (i <= 0)
        {
          AppMethodBeat.o(123512);
          return null;
        }
        localObject = l((JSONArray)localObject);
        AppMethodBeat.o(123512);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, json = %s, e = %s", new Object[] { paramString, localJSONException });
        AppMethodBeat.o(123512);
      }
      return null;
    }
    
    public static List<WxaVersionModuleInfo> l(JSONArray paramJSONArray)
    {
      AppMethodBeat.i(123511);
      if (paramJSONArray == null)
      {
        AppMethodBeat.o(123511);
        return null;
      }
      try
      {
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            WxaVersionModuleInfo localWxaVersionModuleInfo = new WxaVersionModuleInfo();
            localWxaVersionModuleInfo.lhi = localJSONObject;
            localWxaVersionModuleInfo.name = localJSONObject.getString("name");
            localWxaVersionModuleInfo.md5 = localJSONObject.getString("md5");
            localWxaVersionModuleInfo.size = localJSONObject.optInt("size", 0);
            localWxaVersionModuleInfo.independent = localJSONObject.optBoolean("independent", false);
            localWxaVersionModuleInfo.aliases = F(localJSONObject);
            localWxaVersionModuleInfo.lha = localJSONObject.optString("without_lib_md5");
            localWxaVersionModuleInfo.lhh = WxaAttributes.WxaWidgetInfo.m(localJSONObject.optJSONArray("widget_list"));
            localWxaVersionModuleInfo.lhg = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionModuleInfo.lhh, localJSONObject.opt("separated_plugin_list"), 23);
            localLinkedList.add(localWxaVersionModuleInfo);
          }
          i += 1;
        }
        AppMethodBeat.o(123511);
        return localLinkedList;
      }
      catch (JSONException paramJSONArray)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
        AppMethodBeat.o(123511);
      }
      return null;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123514);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.md5);
      if (this.independent) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.size);
        paramParcel.writeStringArray(this.aliases);
        paramParcel.writeTypedList(this.lhg);
        paramParcel.writeString(this.lha);
        paramParcel.writeTypedList(this.lhh);
        AppMethodBeat.o(123514);
        return;
      }
    }
  }
  
  public static class WxaWidgetInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaWidgetInfo> CREATOR;
    public String lhj;
    public List<WxaAttributes.WxaPluginCodeInfo> lhk;
    public int packageType;
    
    static
    {
      AppMethodBeat.i(175239);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(175239);
    }
    
    public WxaWidgetInfo() {}
    
    protected WxaWidgetInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(175238);
      this.packageType = paramParcel.readInt();
      this.lhj = paramParcel.readString();
      this.lhk = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      AppMethodBeat.o(175238);
    }
    
    public static List<WxaWidgetInfo> XL(String paramString)
    {
      AppMethodBeat.i(175236);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(175236);
        return null;
      }
      try
      {
        paramString = m(new JSONArray(paramString));
        AppMethodBeat.o(175236);
        return paramString;
      }
      catch (JSONException paramString)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramString });
        AppMethodBeat.o(175236);
      }
      return null;
    }
    
    public static List<WxaWidgetInfo> m(JSONArray paramJSONArray)
    {
      AppMethodBeat.i(225283);
      if (paramJSONArray != null) {}
      try
      {
        int i = paramJSONArray.length();
        if (i <= 0)
        {
          AppMethodBeat.o(225283);
          return null;
        }
        LinkedList localLinkedList = new LinkedList();
        i = 0;
        while (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            WxaWidgetInfo localWxaWidgetInfo = new WxaWidgetInfo();
            localWxaWidgetInfo.packageType = localJSONObject.optInt("package_type");
            localWxaWidgetInfo.lhj = localJSONObject.optString("wxapkg_md5");
            if (org.apache.commons.b.a.contains(com.tencent.mm.cp.a.RwY, localWxaWidgetInfo.packageType))
            {
              localWxaWidgetInfo.lhk = WxaAttributes.WxaPluginCodeInfo.cz(localJSONObject.opt("separated_plugin_list"));
              localLinkedList.add(localWxaWidgetInfo);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(225283);
        return localLinkedList;
      }
      catch (JSONException paramJSONArray)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
        AppMethodBeat.o(225283);
      }
      return null;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175237);
      paramParcel.writeInt(this.packageType);
      paramParcel.writeString(this.lhj);
      paramParcel.writeTypedList(this.lhk);
      AppMethodBeat.o(175237);
    }
  }
  
  public static final class a
  {
    public long czf = 0L;
    public long kWb = 0L;
    public String ldJ;
    public String lgA;
    public String lgt;
    private int lgu;
    public List<String> lgv;
    public List<String> lgw;
    public List<String> lgx;
    public List<String> lgy;
    public List<String> lgz;
    public int originalFlag;
    public int serviceType;
    
    public static a XI(String paramString)
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
          locala.czf = localJSONObject2.optLong("RunningFlag");
          locala.lgt = localJSONObject2.optString("AppOpenForbiddenUrl");
          locala.kWb = localJSONObject2.optLong("CanNotStarWxaBeforeTime", 0L);
        }
        localJSONObject2 = localJSONObject1.optJSONObject("Network");
        if (localJSONObject2 != null)
        {
          locala.lgv = ad.n(localJSONObject2.optJSONArray("RequestDomain"));
          locala.lgw = ad.n(localJSONObject2.optJSONArray("WsRequestDomain"));
          locala.lgx = ad.n(localJSONObject2.optJSONArray("UploadDomain"));
          locala.lgy = ad.n(localJSONObject2.optJSONArray("DownloadDomain"));
          locala.lgz = ad.n(localJSONObject2.optJSONArray("UDPDomain"));
        }
        locala.lgu = localJSONObject1.optInt("WechatPluginApp", 0);
        locala.serviceType = localJSONObject1.optInt("AppServiceType", 0);
        locala.lgA = localJSONObject1.optString("fromBusinessUsername");
        locala.originalFlag = localJSONObject1.optInt("OriginalFlag", 0);
        locala.ldJ = localJSONObject1.optString("OriginalRedirectUrl");
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
    
    public final boolean NA()
    {
      return this.serviceType == 4;
    }
    
    public final boolean bAt()
    {
      return (this.lgu > 0) || (this.serviceType == 7);
    }
  }
  
  public static final class b
  {
    public int dhT;
    public List<a> lgB;
    public int type;
    
    public static final class a
    {
      public String dCx;
      public List<a> lgC;
      public String name;
      public int type;
      public String userName;
      public int version;
    }
  }
  
  public static final class c
  {
    public a lgD;
    public List<Pair<String, String>> lgE;
    
    public c()
    {
      AppMethodBeat.i(123491);
      this.lgD = new a();
      AppMethodBeat.o(123491);
    }
    
    public static final class a
    {
      public int cyJ;
      public int cyK;
      public int cyL;
      public int cyM;
      public int cyN;
      public int cyO;
      public boolean cyP;
      public boolean cyQ;
      public boolean cyY;
      public int cza;
      public boolean kXI;
      public boolean kXJ;
      public int kXK;
      public int kXL;
      public int leC;
      public int leD;
      public int leb;
      public int lec;
      public int lex;
      public boolean ley;
      public int lgF;
      public int lgG;
      public int lgH;
      public int lgI;
      public boolean lgJ;
      public long lgK;
      public long lgL;
      public long lgM;
      public long lgN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes
 * JD-Core Version:    0.7.0.1
 */