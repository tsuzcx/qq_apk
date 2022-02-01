package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hn;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.stubs.logger.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
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
  extends hn
{
  public static final c.a jJU;
  private a kcJ;
  private c kcK;
  private WxaVersionInfo kcL;
  private List<WxaEntryInfo> kcM = null;
  private b kcN;
  
  static
  {
    AppMethodBeat.i(123525);
    c.a locala = new c.a();
    locala.IBL = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "usernameHash";
    locala.IBN.put("usernameHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "usernameHash";
    locala.columns[1] = "username";
    locala.IBN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.IBN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "nickname";
    locala.IBN.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "shortNickname";
    locala.IBN.put("shortNickname", "TEXT");
    localStringBuilder.append(" shortNickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "brandIconURL";
    locala.IBN.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "roundedSquareIconURL";
    locala.IBN.put("roundedSquareIconURL", "TEXT");
    localStringBuilder.append(" roundedSquareIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bigHeadURL";
    locala.IBN.put("bigHeadURL", "TEXT");
    localStringBuilder.append(" bigHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "smallHeadURL";
    locala.IBN.put("smallHeadURL", "TEXT");
    localStringBuilder.append(" smallHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "signature";
    locala.IBN.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "appOpt";
    locala.IBN.put("appOpt", "INTEGER default '0' ");
    localStringBuilder.append(" appOpt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "registerSource";
    locala.IBN.put("registerSource", "TEXT");
    localStringBuilder.append(" registerSource TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "appInfo";
    locala.IBN.put("appInfo", "TEXT");
    localStringBuilder.append(" appInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "versionInfo";
    locala.IBN.put("versionInfo", "TEXT");
    localStringBuilder.append(" versionInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "passThroughInfo";
    locala.IBN.put("passThroughInfo", "TEXT");
    localStringBuilder.append(" passThroughInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "bindWxaInfo";
    locala.IBN.put("bindWxaInfo", "TEXT");
    localStringBuilder.append(" bindWxaInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "dynamicInfo";
    locala.IBN.put("dynamicInfo", "TEXT");
    localStringBuilder.append(" dynamicInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "reserved";
    locala.IBN.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "syncTimeSecond";
    locala.IBN.put("syncTimeSecond", "LONG default '0' ");
    localStringBuilder.append(" syncTimeSecond LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "syncVersion";
    locala.IBN.put("syncVersion", "TEXT");
    localStringBuilder.append(" syncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "bizMenu";
    locala.IBN.put("bizMenu", "TEXT");
    localStringBuilder.append(" bizMenu TEXT");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    jJU = locala;
    AppMethodBeat.o(123525);
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
          locala.dlk = localJSONObject.optString("pagePath", "");
          locala.version = localJSONObject.optInt("version");
          locala.kcX = k(((JSONObject)localObject).optJSONArray("sub_button_list"));
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
  
  public final a beT()
  {
    AppMethodBeat.i(123518);
    if (this.kcJ == null) {
      this.kcJ = a.Ox(this.field_appInfo);
    }
    a locala = this.kcJ;
    AppMethodBeat.o(123518);
    return locala;
  }
  
  public final c beU()
  {
    boolean bool2 = true;
    int i = 0;
    AppMethodBeat.i(123519);
    if (this.kcK == null) {
      try
      {
        Object localObject1 = new JSONObject(this.field_dynamicInfo);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new JSONObject();
        }
        this.kcK = new c();
        Object localObject3 = ((JSONObject)localObject2).optJSONObject("NewSetting");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new JSONObject();
        }
        this.kcK.kcY.cne = ((JSONObject)localObject1).optInt("MaxLocalstorageSize", 5);
        this.kcK.kcY.kda = ((JSONObject)localObject1).optInt("OpendataMaxLocalstorageSize", 5);
        this.kcK.kcY.kdb = ((JSONObject)localObject1).optInt("MaxCodeSize", 5);
        this.kcK.kcY.kbp = ((JSONObject)localObject1).optInt("ExpendedMaxWebviewDepth", 5);
        this.kcK.kcY.cmN = ((JSONObject)localObject1).optInt("MaxBackgroundLifespan", 600);
        this.kcK.kcY.cmO = ((JSONObject)localObject1).optInt("MaxRequestConcurrent", 5);
        this.kcK.kcY.cmP = ((JSONObject)localObject1).optInt("MaxUploadConcurrent", 5);
        this.kcK.kcY.cmQ = ((JSONObject)localObject1).optInt("MaxDownloadConcurrent", 5);
        this.kcK.kcY.cmR = ((JSONObject)localObject1).optInt("MaxWebsocketConnect", 2);
        this.kcK.kcY.cmS = ((JSONObject)localObject1).optInt("MaxWorkerConcurrent", 1);
        localObject3 = this.kcK.kcY;
        if (((JSONObject)localObject1).optInt("WebsocketSkipPortCheck", 0) != 0)
        {
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cmT = bool1;
          localObject3 = this.kcK.kcY;
          if (((JSONObject)localObject1).optInt("TLSSkipHostnameCheck", 0) == 0) {
            break label827;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cmU = bool1;
          this.kcK.kcY.kdc = ((JSONObject)localObject1).optInt("MaxFileStorageSize", 10);
          this.kcK.kcY.kdd = ((JSONObject)localObject1).optInt("BackgroundNetworkInterruptedTimeout", 5);
          localObject3 = this.kcK.kcY;
          if (((JSONObject)localObject1).optInt("CanKeepAliveByAudioPlay", 0) <= 0) {
            break label832;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).kbq = bool1;
          this.kcK.kcY.kbu = ((JSONObject)localObject1).optInt("LifeSpanBeforeSuspend", 5);
          this.kcK.kcY.kbv = ((JSONObject)localObject1).optInt("LifeSpanAfterSuspend", 300);
          localObject3 = this.kcK.kcY;
          if (((JSONObject)localObject1).optInt("ScanCodeEnableZZM", 0) == 0) {
            break label837;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cnc = bool1;
          localObject3 = this.kcK.kcY;
          if (((JSONObject)localObject1).optInt("CanPreFetchData", 0) <= 0) {
            break label842;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).jUM = bool1;
          localObject3 = this.kcK.kcY;
          if (((JSONObject)localObject1).optInt("CanPeriodFetchData", 0) <= 0) {
            break label847;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).jUN = bool1;
          this.kcK.kcY.jUO = ((JSONObject)localObject1).optInt("PeriodFetchData", 0);
          this.kcK.kcY.jUP = ((JSONObject)localObject1).optInt("PeriodFetchDataDay", 7);
          this.kcK.kcY.kaX = ((JSONObject)localObject1).optInt("GuaranteeFlag", 0);
          localObject3 = this.kcK.kcY;
          if (((JSONObject)localObject1).optInt("CanShowLoadingAdvert", 0) <= 0) {
            break label852;
          }
          bool1 = bool2;
          ((WxaAttributes.c.a)localObject3).kde = bool1;
          this.kcK.kcY.kaY = ((JSONObject)localObject1).optInt("BrandOfficialLabel", 0);
          this.kcK.kcY.kdf = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMaxMicSec", 13000L);
          this.kcK.kcY.kdg = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMaxMicSecForWeakNet", 10000L);
          this.kcK.kcY.kdh = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMinMicSec", 0L);
          this.kcK.kcY.kdi = ((JSONObject)localObject1).optLong("NextTryOpenWxaDisMicSec", 10000L);
          localObject1 = ((JSONObject)localObject2).optJSONArray("NewCategories");
          if (localObject1 == null) {
            break label857;
          }
          this.kcK.kcZ = new LinkedList();
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 != null) {
              this.kcK.kcZ.add(new Pair(((JSONObject)localObject2).optString("first"), ((JSONObject)localObject2).optString("second")));
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
    c localc = this.kcK;
    AppMethodBeat.o(123519);
    return localc;
  }
  
  public final WxaVersionInfo beV()
  {
    AppMethodBeat.i(123520);
    if ((this.kcL == null) && (!bu.isNullOrNil(this.field_versionInfo)))
    {
      localWxaVersionInfo = WxaVersionInfo.Oy(this.field_versionInfo);
      this.kcL = localWxaVersionInfo;
      AppMethodBeat.o(123520);
      return localWxaVersionInfo;
    }
    WxaVersionInfo localWxaVersionInfo = this.kcL;
    AppMethodBeat.o(123520);
    return localWxaVersionInfo;
  }
  
  public final List<WxaEntryInfo> beW()
  {
    AppMethodBeat.i(123521);
    if ((this.kcM == null) && (!bu.isNullOrNil(this.field_bindWxaInfo))) {
      try
      {
        JSONArray localJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
        if (localJSONArray != null)
        {
          this.kcM = new LinkedList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject != null)
            {
              String str = localJSONObject.optString("username");
              if (!bu.isNullOrNil(str))
              {
                WxaEntryInfo localWxaEntryInfo = new WxaEntryInfo();
                localWxaEntryInfo.username = str;
                localWxaEntryInfo.title = localJSONObject.optString("title");
                localWxaEntryInfo.iconUrl = localJSONObject.optString("icon_url");
                this.kcM.add(localWxaEntryInfo);
              }
            }
            i += 1;
          }
        }
        localList = this.kcM;
      }
      catch (Exception localException)
      {
        this.kcM = null;
      }
    }
    List localList;
    AppMethodBeat.o(123521);
    return localList;
  }
  
  public final b beX()
  {
    AppMethodBeat.i(123522);
    if ((this.kcN == null) && (!bu.isNullOrNil(this.field_bizMenu))) {}
    try
    {
      Object localObject = new JSONObject(this.field_bizMenu);
      this.kcN = new b();
      this.kcN.cRA = ((JSONObject)localObject).optInt("interactive_mode", 0);
      this.kcN.type = ((JSONObject)localObject).optInt("type", 0);
      this.kcN.kcW = k(((JSONObject)localObject).optJSONArray("button_list"));
      localObject = this.kcN;
      AppMethodBeat.o(123522);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.kcN = null;
      }
    }
  }
  
  public final void beY()
  {
    int i = 0;
    AppMethodBeat.i(200328);
    String str1 = String.format(Locale.ENGLISH, ">>>>>> WxaAttributes(%s|%s|%s)START >>>>>>", new Object[] { this.field_username, this.field_appId, this.field_nickname });
    String str2 = ">>> field_appInfo=" + this.field_appInfo;
    String str3 = ">>> field_versionInfo=" + this.field_versionInfo;
    String str4 = ">>> field_dynamicInfo=" + this.field_dynamicInfo;
    String str5 = String.format(Locale.ENGLISH, ">>>>>> WxaAttributes(%s|%s|%s) END >>>>>>", new Object[] { this.field_username, this.field_appId, this.field_nickname });
    while (i < 5)
    {
      Log.println(4, "MicroMsg.AppBrand.WxaAttributes", new String[] { str1, str2, str3, str4, str5 }[i]);
      i += 1;
    }
    AppMethodBeat.o(200328);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(123517);
    super.convertFrom(paramCursor);
    this.kcJ = null;
    this.kcK = null;
    this.kcL = null;
    this.kcM = null;
    this.kcN = null;
    AppMethodBeat.o(123517);
  }
  
  public final c.a getDBInfo()
  {
    return jJU;
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
    public String kdj;
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
      this.kdj = paramParcel.readString();
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
      paramParcel.writeString(this.kdj);
      paramParcel.writeString(this.iconUrl);
      AppMethodBeat.o(123493);
    }
  }
  
  public static class WxaPluginCodeInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaPluginCodeInfo> CREATOR;
    public List<Integer> contexts;
    public boolean kdk;
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
        this.kdk = bool;
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
      AppMethodBeat.i(200325);
      Object localObject = null;
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        for (paramList = (List<WxaAttributes.WxaWidgetInfo>)localObject; localIterator.hasNext(); paramList = ((WxaAttributes.WxaWidgetInfo)localObject).kdF)
        {
          localObject = (WxaAttributes.WxaWidgetInfo)localIterator.next();
          if (((WxaAttributes.WxaWidgetInfo)localObject).doK != paramInt) {
            break label76;
          }
        }
      }
      for (;;)
      {
        localObject = paramList;
        if (paramList == null) {
          localObject = cq(paramObject);
        }
        AppMethodBeat.o(200325);
        return localObject;
        label76:
        break;
        paramList = null;
      }
    }
    
    public static List<WxaPluginCodeInfo> cq(Object paramObject)
    {
      AppMethodBeat.i(200326);
      if (paramObject == null)
      {
        AppMethodBeat.o(200326);
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
              AppMethodBeat.o(200326);
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
            ae.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "WxaPluginCodeInfo.optPluginCodeInfoList() invalid pluginCodeObj:%s", new Object[] { paramObject.getClass().getName() });
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
              localWxaPluginCodeInfo.kdk = bool;
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
            AppMethodBeat.o(200326);
            return localLinkedList;
          }
        }
        catch (JSONException paramObject)
        {
          ae.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramObject });
          AppMethodBeat.o(200326);
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
      if (this.kdk) {}
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
    public String kdl;
    public String kdm;
    
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
      this.kdl = paramParcel.readString();
      this.kdm = paramParcel.readString();
      AppMethodBeat.o(123503);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123502);
      paramParcel.writeString(this.kdl);
      paramParcel.writeString(this.kdm);
      AppMethodBeat.o(123502);
    }
  }
  
  public static final class WxaVersionInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaVersionInfo> CREATOR;
    public int aDD;
    public int cmz;
    public boolean cpl;
    public List<WxaAttributes.WxaWidgetInfo> irC;
    public String kdA;
    public String kdn;
    public String kdo;
    public WxaAttributes.WxaVersionCoverImageInfo kdp;
    public List<WxaAttributes.WxaPluginCodeInfo> kdq;
    public int kdr;
    public boolean kds;
    public String kdt;
    public String kdu;
    public String kdv;
    public long kdw;
    public String kdx;
    public String kdy;
    public String kdz;
    public List<WxaAttributes.WxaVersionModuleInfo> moduleList;
    
    static
    {
      AppMethodBeat.i(123509);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123509);
    }
    
    public WxaVersionInfo()
    {
      this.kdx = "";
      this.kdy = "";
      this.kdz = "";
      this.kdA = "";
      this.cpl = false;
    }
    
    protected WxaVersionInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123508);
      this.kdx = "";
      this.kdy = "";
      this.kdz = "";
      this.kdA = "";
      this.cpl = false;
      this.aDD = paramParcel.readInt();
      this.cmz = paramParcel.readInt();
      this.kdn = paramParcel.readString();
      this.kdo = paramParcel.readString();
      this.kdp = ((WxaAttributes.WxaVersionCoverImageInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionCoverImageInfo.class.getClassLoader()));
      this.kdq = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      this.kdr = paramParcel.readInt();
      this.moduleList = paramParcel.createTypedArrayList(WxaAttributes.WxaVersionModuleInfo.CREATOR);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.kds = bool;
        this.kdt = paramParcel.readString();
        this.kdu = paramParcel.readString();
        this.kdv = paramParcel.readString();
        this.irC = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        this.kdx = paramParcel.readString();
        this.kdy = paramParcel.readString();
        this.kdz = paramParcel.readString();
        this.kdA = paramParcel.readString();
        boolean[] arrayOfBoolean = new boolean[1];
        paramParcel.readBooleanArray(arrayOfBoolean);
        this.cpl = arrayOfBoolean[0];
        AppMethodBeat.o(123508);
        return;
      }
    }
    
    public static WxaVersionInfo Oy(String paramString)
    {
      AppMethodBeat.i(123506);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(123506);
        return null;
      }
      l = bu.HQ();
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        WxaVersionInfo localWxaVersionInfo = new WxaVersionInfo();
        localWxaVersionInfo.aDD = localJSONObject1.optInt("AppVersion", 0);
        localWxaVersionInfo.cmz = localJSONObject1.optInt("VersionState", -1);
        localWxaVersionInfo.kdn = localJSONObject1.optString("VersionMD5");
        localWxaVersionInfo.kdo = localJSONObject1.optString("device_orientation");
        localWxaVersionInfo.kdu = localJSONObject1.optString("client_js_ext_info");
        localWxaVersionInfo.kdr = localJSONObject1.optInt("code_size");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("loading_image_info");
        if (localJSONObject2 != null)
        {
          localWxaVersionInfo.kdp = new WxaAttributes.WxaVersionCoverImageInfo();
          localWxaVersionInfo.kdp.kdl = localJSONObject2.optString("url");
          localWxaVersionInfo.kdp.kdm = localJSONObject2.optString("progressbar_color");
        }
        JSONObject localJSONObject3 = localJSONObject1.optJSONObject("fake_native_loading_style_info");
        if (localJSONObject3 != null)
        {
          localJSONObject2 = localJSONObject3.optJSONObject("white_style");
          localJSONObject3 = localJSONObject3.optJSONObject("black_style");
          if (localJSONObject2 != null)
          {
            if (localJSONObject2.has("navigation_bar_text_color")) {
              localWxaVersionInfo.kdx = localJSONObject2.optString("navigation_bar_text_color");
            }
            if (localJSONObject2.has("background_color")) {
              localWxaVersionInfo.kdy = localJSONObject2.optString("background_color");
            }
          }
          if (localJSONObject3 != null)
          {
            if (localJSONObject3.has("navigation_bar_text_color")) {
              localWxaVersionInfo.kdz = localJSONObject3.optString("navigation_bar_text_color");
            }
            if (localJSONObject3.has("background_color")) {
              localWxaVersionInfo.kdA = localJSONObject3.optString("background_color");
            }
          }
        }
        localWxaVersionInfo.moduleList = WxaAttributes.WxaVersionModuleInfo.l(localJSONObject1.optJSONArray("module_list"));
        localWxaVersionInfo.kds = localJSONObject1.optBoolean("UseModule", false);
        localWxaVersionInfo.kdt = localJSONObject1.optString("EntranceModule");
        localWxaVersionInfo.kdv = localJSONObject1.optString("without_lib_md5");
        localWxaVersionInfo.irC = WxaAttributes.WxaWidgetInfo.m(localJSONObject1.optJSONArray("widget_list"));
        localWxaVersionInfo.kdq = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionInfo.irC, localJSONObject1.opt("separated_plugin_list"), 22);
        localWxaVersionInfo.kdw = localJSONObject1.optLong("ForceSyncUpdateWhenLaunchLastInterval", -1L);
        localWxaVersionInfo.cpl = localJSONObject1.optBoolean("resizable", false);
        ae.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(bu.HQ() - l), Integer.valueOf(paramString.length()) });
        paramString = localWxaVersionInfo;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(bu.HQ() - l), Integer.valueOf(paramString.length()) });
          paramString = null;
        }
      }
      finally
      {
        ae.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(bu.HQ() - l), Integer.valueOf(paramString.length()) });
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
      paramParcel.writeInt(this.aDD);
      paramParcel.writeInt(this.cmz);
      paramParcel.writeString(this.kdn);
      paramParcel.writeString(this.kdo);
      paramParcel.writeParcelable(this.kdp, paramInt);
      paramParcel.writeTypedList(this.kdq);
      paramParcel.writeInt(this.kdr);
      paramParcel.writeTypedList(this.moduleList);
      if (this.kds) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.kdt);
        paramParcel.writeString(this.kdu);
        paramParcel.writeString(this.kdv);
        paramParcel.writeTypedList(this.irC);
        paramParcel.writeString(this.kdx);
        paramParcel.writeString(this.kdy);
        paramParcel.writeString(this.kdz);
        paramParcel.writeString(this.kdA);
        paramParcel.writeBooleanArray(new boolean[] { this.cpl });
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
    public List<WxaAttributes.WxaPluginCodeInfo> kdB;
    public List<WxaAttributes.WxaWidgetInfo> kdC;
    private JSONObject kdD;
    public String kdv;
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
        this.kdB = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
        this.kdv = paramParcel.readString();
        this.kdC = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        AppMethodBeat.o(123515);
        return;
      }
    }
    
    public static List<WxaVersionModuleInfo> Oz(String paramString)
    {
      AppMethodBeat.i(123512);
      if (bu.isNullOrNil(paramString))
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
        ae.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, json = %s, e = %s", new Object[] { paramString, localJSONException });
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
            localWxaVersionModuleInfo.kdD = localJSONObject;
            localWxaVersionModuleInfo.name = localJSONObject.getString("name");
            localWxaVersionModuleInfo.md5 = localJSONObject.getString("md5");
            localWxaVersionModuleInfo.size = localJSONObject.optInt("size", 0);
            localWxaVersionModuleInfo.independent = localJSONObject.optBoolean("independent", false);
            localWxaVersionModuleInfo.aliases = y(localJSONObject);
            localWxaVersionModuleInfo.kdv = localJSONObject.optString("without_lib_md5");
            localWxaVersionModuleInfo.kdC = WxaAttributes.WxaWidgetInfo.m(localJSONObject.optJSONArray("widget_list"));
            localWxaVersionModuleInfo.kdB = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionModuleInfo.kdC, localJSONObject.opt("separated_plugin_list"), 23);
            localLinkedList.add(localWxaVersionModuleInfo);
          }
          i += 1;
        }
        AppMethodBeat.o(123511);
        return localLinkedList;
      }
      catch (JSONException paramJSONArray)
      {
        ae.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
        AppMethodBeat.o(123511);
      }
      return null;
    }
    
    private static String[] y(JSONObject paramJSONObject)
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
        paramParcel.writeTypedList(this.kdB);
        paramParcel.writeString(this.kdv);
        paramParcel.writeTypedList(this.kdC);
        AppMethodBeat.o(123514);
        return;
      }
    }
  }
  
  public static class WxaWidgetInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaWidgetInfo> CREATOR;
    public int doK;
    public String kdE;
    public List<WxaAttributes.WxaPluginCodeInfo> kdF;
    
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
      this.doK = paramParcel.readInt();
      this.kdE = paramParcel.readString();
      this.kdF = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      AppMethodBeat.o(175238);
    }
    
    public static List<WxaWidgetInfo> OA(String paramString)
    {
      AppMethodBeat.i(175236);
      if (bu.isNullOrNil(paramString))
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
        ae.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramString });
        AppMethodBeat.o(175236);
      }
      return null;
    }
    
    public static List<WxaWidgetInfo> m(JSONArray paramJSONArray)
    {
      AppMethodBeat.i(200327);
      if (paramJSONArray != null) {}
      try
      {
        int i = paramJSONArray.length();
        if (i <= 0)
        {
          AppMethodBeat.o(200327);
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
            localWxaWidgetInfo.doK = localJSONObject.optInt("package_type");
            localWxaWidgetInfo.kdE = localJSONObject.optString("wxapkg_md5");
            if (org.apache.commons.b.a.contains(com.tencent.mm.cn.a.LXY, localWxaWidgetInfo.doK))
            {
              localWxaWidgetInfo.kdF = WxaAttributes.WxaPluginCodeInfo.cq(localJSONObject.opt("separated_plugin_list"));
              localLinkedList.add(localWxaWidgetInfo);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(200327);
        return localLinkedList;
      }
      catch (JSONException paramJSONArray)
      {
        ae.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
        AppMethodBeat.o(200327);
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
      paramParcel.writeInt(this.doK);
      paramParcel.writeString(this.kdE);
      paramParcel.writeTypedList(this.kdF);
      AppMethodBeat.o(175237);
    }
  }
  
  public static final class a
  {
    public int cRx;
    public long cnj = 0L;
    public long jTt = 0L;
    public String kaF;
    public String kcO;
    private int kcP;
    public List<String> kcQ;
    public List<String> kcR;
    public List<String> kcS;
    public List<String> kcT;
    public List<String> kcU;
    public String kcV;
    public int originalFlag;
    
    public static a Ox(String paramString)
    {
      AppMethodBeat.i(123490);
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
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
          locala.cnj = localJSONObject2.optLong("RunningFlag");
          locala.kcO = localJSONObject2.optString("AppOpenForbiddenUrl");
          locala.jTt = localJSONObject2.optLong("CanNotStarWxaBeforeTime", 0L);
        }
        localJSONObject2 = localJSONObject1.optJSONObject("Network");
        if (localJSONObject2 != null)
        {
          locala.kcQ = aa.n(localJSONObject2.optJSONArray("RequestDomain"));
          locala.kcR = aa.n(localJSONObject2.optJSONArray("WsRequestDomain"));
          locala.kcS = aa.n(localJSONObject2.optJSONArray("UploadDomain"));
          locala.kcT = aa.n(localJSONObject2.optJSONArray("DownloadDomain"));
          locala.kcU = aa.n(localJSONObject2.optJSONArray("UDPDomain"));
        }
        locala.kcP = localJSONObject1.optInt("WechatPluginApp", 0);
        locala.cRx = localJSONObject1.optInt("AppServiceType", 0);
        locala.kcV = localJSONObject1.optString("fromBusinessUsername");
        locala.originalFlag = localJSONObject1.optInt("OriginalFlag", 0);
        locala.kaF = localJSONObject1.optString("OriginalRedirectUrl");
        paramString = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", new Object[] { paramString, localException });
          paramString = null;
        }
      }
      AppMethodBeat.o(123490);
      return paramString;
    }
    
    public final boolean Ee()
    {
      return this.cRx == 4;
    }
    
    public final boolean beZ()
    {
      return (this.kcP > 0) || (this.cRx == 7);
    }
  }
  
  public static final class b
  {
    public int cRA;
    public List<a> kcW;
    public int type;
    
    public static final class a
    {
      public String dlk;
      public List<a> kcX;
      public String name;
      public int type;
      public String userName;
      public int version;
    }
  }
  
  public static final class c
  {
    public a kcY;
    public List<Pair<String, String>> kcZ;
    
    public c()
    {
      AppMethodBeat.i(123491);
      this.kcY = new a();
      AppMethodBeat.o(123491);
    }
    
    public static final class a
    {
      public int cmN;
      public int cmO;
      public int cmP;
      public int cmQ;
      public int cmR;
      public int cmS;
      public boolean cmT;
      public boolean cmU;
      public boolean cnc;
      public int cne;
      public boolean jUM;
      public boolean jUN;
      public int jUO;
      public int jUP;
      public int kaX;
      public int kaY;
      public int kbp;
      public boolean kbq;
      public int kbu;
      public int kbv;
      public int kda;
      public int kdb;
      public int kdc;
      public int kdd;
      public boolean kde;
      public long kdf;
      public long kdg;
      public long kdh;
      public long kdi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes
 * JD-Core Version:    0.7.0.1
 */