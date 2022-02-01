package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hm;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  extends hm
{
  public static final c.a jGU;
  private a jZs;
  private c jZt;
  private WxaVersionInfo jZu;
  private List<WxaEntryInfo> jZv = null;
  private b jZw;
  
  static
  {
    AppMethodBeat.i(123525);
    c.a locala = new c.a();
    locala.IhA = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "usernameHash";
    locala.IhC.put("usernameHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "usernameHash";
    locala.columns[1] = "username";
    locala.IhC.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "nickname";
    locala.IhC.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "shortNickname";
    locala.IhC.put("shortNickname", "TEXT");
    localStringBuilder.append(" shortNickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "brandIconURL";
    locala.IhC.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "roundedSquareIconURL";
    locala.IhC.put("roundedSquareIconURL", "TEXT");
    localStringBuilder.append(" roundedSquareIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bigHeadURL";
    locala.IhC.put("bigHeadURL", "TEXT");
    localStringBuilder.append(" bigHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "smallHeadURL";
    locala.IhC.put("smallHeadURL", "TEXT");
    localStringBuilder.append(" smallHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "signature";
    locala.IhC.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "appOpt";
    locala.IhC.put("appOpt", "INTEGER default '0' ");
    localStringBuilder.append(" appOpt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "registerSource";
    locala.IhC.put("registerSource", "TEXT");
    localStringBuilder.append(" registerSource TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "appInfo";
    locala.IhC.put("appInfo", "TEXT");
    localStringBuilder.append(" appInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "versionInfo";
    locala.IhC.put("versionInfo", "TEXT");
    localStringBuilder.append(" versionInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "passThroughInfo";
    locala.IhC.put("passThroughInfo", "TEXT");
    localStringBuilder.append(" passThroughInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "bindWxaInfo";
    locala.IhC.put("bindWxaInfo", "TEXT");
    localStringBuilder.append(" bindWxaInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "dynamicInfo";
    locala.IhC.put("dynamicInfo", "TEXT");
    localStringBuilder.append(" dynamicInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "reserved";
    locala.IhC.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "syncTimeSecond";
    locala.IhC.put("syncTimeSecond", "LONG default '0' ");
    localStringBuilder.append(" syncTimeSecond LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "syncVersion";
    locala.IhC.put("syncVersion", "TEXT");
    localStringBuilder.append(" syncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "bizMenu";
    locala.IhC.put("bizMenu", "TEXT");
    localStringBuilder.append(" bizMenu TEXT");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    jGU = locala;
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
          locala.dki = localJSONObject.optString("pagePath", "");
          locala.version = localJSONObject.optInt("version");
          locala.jZG = k(((JSONObject)localObject).optJSONArray("sub_button_list"));
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
  
  public final a bel()
  {
    AppMethodBeat.i(123518);
    if (this.jZs == null) {
      this.jZs = a.NP(this.field_appInfo);
    }
    a locala = this.jZs;
    AppMethodBeat.o(123518);
    return locala;
  }
  
  public final c bem()
  {
    boolean bool2 = true;
    int i = 0;
    AppMethodBeat.i(123519);
    if (this.jZt == null) {
      try
      {
        Object localObject1 = new JSONObject(this.field_dynamicInfo);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new JSONObject();
        }
        this.jZt = new c();
        Object localObject3 = ((JSONObject)localObject2).optJSONObject("NewSetting");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new JSONObject();
        }
        this.jZt.jZH.cnc = ((JSONObject)localObject1).optInt("MaxLocalstorageSize", 5);
        this.jZt.jZH.jZJ = ((JSONObject)localObject1).optInt("OpendataMaxLocalstorageSize", 5);
        this.jZt.jZH.jZK = ((JSONObject)localObject1).optInt("MaxCodeSize", 5);
        this.jZt.jZH.jYa = ((JSONObject)localObject1).optInt("ExpendedMaxWebviewDepth", 5);
        this.jZt.jZH.cmL = ((JSONObject)localObject1).optInt("MaxBackgroundLifespan", 600);
        this.jZt.jZH.cmM = ((JSONObject)localObject1).optInt("MaxRequestConcurrent", 5);
        this.jZt.jZH.cmN = ((JSONObject)localObject1).optInt("MaxUploadConcurrent", 5);
        this.jZt.jZH.cmO = ((JSONObject)localObject1).optInt("MaxDownloadConcurrent", 5);
        this.jZt.jZH.cmP = ((JSONObject)localObject1).optInt("MaxWebsocketConnect", 2);
        this.jZt.jZH.cmQ = ((JSONObject)localObject1).optInt("MaxWorkerConcurrent", 1);
        localObject3 = this.jZt.jZH;
        if (((JSONObject)localObject1).optInt("WebsocketSkipPortCheck", 0) != 0)
        {
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cmR = bool1;
          localObject3 = this.jZt.jZH;
          if (((JSONObject)localObject1).optInt("TLSSkipHostnameCheck", 0) == 0) {
            break label827;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cmS = bool1;
          this.jZt.jZH.jZL = ((JSONObject)localObject1).optInt("MaxFileStorageSize", 10);
          this.jZt.jZH.jZM = ((JSONObject)localObject1).optInt("BackgroundNetworkInterruptedTimeout", 5);
          localObject3 = this.jZt.jZH;
          if (((JSONObject)localObject1).optInt("CanKeepAliveByAudioPlay", 0) <= 0) {
            break label832;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).jYb = bool1;
          this.jZt.jZH.jYf = ((JSONObject)localObject1).optInt("LifeSpanBeforeSuspend", 5);
          this.jZt.jZH.jYg = ((JSONObject)localObject1).optInt("LifeSpanAfterSuspend", 300);
          localObject3 = this.jZt.jZH;
          if (((JSONObject)localObject1).optInt("ScanCodeEnableZZM", 0) == 0) {
            break label837;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cna = bool1;
          localObject3 = this.jZt.jZH;
          if (((JSONObject)localObject1).optInt("CanPreFetchData", 0) <= 0) {
            break label842;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).jRu = bool1;
          localObject3 = this.jZt.jZH;
          if (((JSONObject)localObject1).optInt("CanPeriodFetchData", 0) <= 0) {
            break label847;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).jRv = bool1;
          this.jZt.jZH.jRw = ((JSONObject)localObject1).optInt("PeriodFetchData", 0);
          this.jZt.jZH.jRx = ((JSONObject)localObject1).optInt("PeriodFetchDataDay", 7);
          this.jZt.jZH.jXI = ((JSONObject)localObject1).optInt("GuaranteeFlag", 0);
          localObject3 = this.jZt.jZH;
          if (((JSONObject)localObject1).optInt("CanShowLoadingAdvert", 0) <= 0) {
            break label852;
          }
          bool1 = bool2;
          ((WxaAttributes.c.a)localObject3).jZN = bool1;
          this.jZt.jZH.jXJ = ((JSONObject)localObject1).optInt("BrandOfficialLabel", 0);
          this.jZt.jZH.jZO = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMaxMicSec", 13000L);
          this.jZt.jZH.jZP = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMaxMicSecForWeakNet", 10000L);
          this.jZt.jZH.jZQ = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMinMicSec", 0L);
          this.jZt.jZH.jZR = ((JSONObject)localObject1).optLong("NextTryOpenWxaDisMicSec", 10000L);
          localObject1 = ((JSONObject)localObject2).optJSONArray("NewCategories");
          if (localObject1 == null) {
            break label857;
          }
          this.jZt.jZI = new LinkedList();
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 != null) {
              this.jZt.jZI.add(new Pair(((JSONObject)localObject2).optString("first"), ((JSONObject)localObject2).optString("second")));
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
    c localc = this.jZt;
    AppMethodBeat.o(123519);
    return localc;
  }
  
  public final WxaVersionInfo ben()
  {
    AppMethodBeat.i(123520);
    if ((this.jZu == null) && (!bt.isNullOrNil(this.field_versionInfo)))
    {
      localWxaVersionInfo = WxaVersionInfo.NR(this.field_versionInfo);
      this.jZu = localWxaVersionInfo;
      AppMethodBeat.o(123520);
      return localWxaVersionInfo;
    }
    WxaVersionInfo localWxaVersionInfo = this.jZu;
    AppMethodBeat.o(123520);
    return localWxaVersionInfo;
  }
  
  public final List<WxaEntryInfo> beo()
  {
    AppMethodBeat.i(123521);
    if ((this.jZv == null) && (!bt.isNullOrNil(this.field_bindWxaInfo))) {
      try
      {
        JSONArray localJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
        if (localJSONArray != null)
        {
          this.jZv = new LinkedList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject != null)
            {
              String str = localJSONObject.optString("username");
              if (!bt.isNullOrNil(str))
              {
                WxaEntryInfo localWxaEntryInfo = new WxaEntryInfo();
                localWxaEntryInfo.username = str;
                localWxaEntryInfo.title = localJSONObject.optString("title");
                localWxaEntryInfo.iconUrl = localJSONObject.optString("icon_url");
                this.jZv.add(localWxaEntryInfo);
              }
            }
            i += 1;
          }
        }
        localList = this.jZv;
      }
      catch (Exception localException)
      {
        this.jZv = null;
      }
    }
    List localList;
    AppMethodBeat.o(123521);
    return localList;
  }
  
  public final b bep()
  {
    AppMethodBeat.i(123522);
    if ((this.jZw == null) && (!bt.isNullOrNil(this.field_bizMenu))) {}
    try
    {
      Object localObject = new JSONObject(this.field_bizMenu);
      this.jZw = new b();
      this.jZw.cQQ = ((JSONObject)localObject).optInt("interactive_mode", 0);
      this.jZw.type = ((JSONObject)localObject).optInt("type", 0);
      this.jZw.jZF = k(((JSONObject)localObject).optJSONArray("button_list"));
      localObject = this.jZw;
      AppMethodBeat.o(123522);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jZw = null;
      }
    }
  }
  
  public final void beq()
  {
    int i = 0;
    AppMethodBeat.i(190974);
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
    AppMethodBeat.o(190974);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(123517);
    super.convertFrom(paramCursor);
    this.jZs = null;
    this.jZt = null;
    this.jZu = null;
    this.jZv = null;
    this.jZw = null;
    AppMethodBeat.o(123517);
  }
  
  public final c.a getDBInfo()
  {
    return jGU;
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
    public String jZS;
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
      this.jZS = paramParcel.readString();
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
      paramParcel.writeString(this.jZS);
      paramParcel.writeString(this.iconUrl);
      AppMethodBeat.o(123493);
    }
  }
  
  public static class WxaPluginCodeInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaPluginCodeInfo> CREATOR;
    public List<Integer> contexts;
    public boolean jZT;
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
        this.jZT = bool;
        if (this.contexts == null) {
          this.contexts = new LinkedList();
        }
        paramParcel.readList(this.contexts, Integer.class.getClassLoader());
        AppMethodBeat.o(123499);
        return;
        bool = false;
      }
    }
    
    public static List<WxaPluginCodeInfo> NQ(String paramString)
    {
      AppMethodBeat.i(123497);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(123497);
        return null;
      }
      for (;;)
      {
        int i;
        try
        {
          paramString = new JSONArray(paramString);
          i = paramString.length();
          if (i <= 0)
          {
            AppMethodBeat.o(123497);
            return null;
          }
          LinkedList localLinkedList = new LinkedList();
          i = 0;
          if (i < paramString.length())
          {
            Object localObject = paramString.getJSONObject(i);
            if (localObject == null) {
              break label284;
            }
            WxaPluginCodeInfo localWxaPluginCodeInfo = new WxaPluginCodeInfo();
            localWxaPluginCodeInfo.provider = ((JSONObject)localObject).optString("plugin_id");
            localWxaPluginCodeInfo.version = ((JSONObject)localObject).optInt("inner_version");
            localWxaPluginCodeInfo.md5 = ((JSONObject)localObject).optString("md5");
            localWxaPluginCodeInfo.prefixPath = ((JSONObject)localObject).optString("prefix_path");
            if (!((JSONObject)localObject).optBoolean("auto_update"))
            {
              if (((JSONObject)localObject).optInt("auto_update", 0) <= 0) {
                break label291;
              }
              break label279;
              localWxaPluginCodeInfo.jZT = bool;
              localObject = ((JSONObject)localObject).optJSONArray("contexts");
              if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
                break label296;
              }
              localWxaPluginCodeInfo.contexts.add(Integer.valueOf(0));
              localLinkedList.add(localWxaPluginCodeInfo);
              break label284;
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
            AppMethodBeat.o(123497);
            return localLinkedList;
          }
        }
        catch (JSONException paramString)
        {
          ad.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramString });
          AppMethodBeat.o(123497);
          return null;
        }
        label279:
        boolean bool = true;
        continue;
        label284:
        i += 1;
        continue;
        label291:
        bool = false;
        continue;
        label296:
        int j = 0;
      }
    }
    
    public static List<WxaPluginCodeInfo> a(List<WxaAttributes.WxaWidgetInfo> paramList, String paramString, int paramInt)
    {
      AppMethodBeat.i(175233);
      Object localObject = null;
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        for (paramList = (List<WxaAttributes.WxaWidgetInfo>)localObject; localIterator.hasNext(); paramList = ((WxaAttributes.WxaWidgetInfo)localObject).kao)
        {
          localObject = (WxaAttributes.WxaWidgetInfo)localIterator.next();
          if (((WxaAttributes.WxaWidgetInfo)localObject).dnF != paramInt) {
            break label76;
          }
        }
      }
      for (;;)
      {
        localObject = paramList;
        if (paramList == null) {
          localObject = NQ(paramString);
        }
        AppMethodBeat.o(175233);
        return localObject;
        label76:
        break;
        paramList = null;
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
      if (this.jZT) {}
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
    public String jZU;
    public String jZV;
    
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
      this.jZU = paramParcel.readString();
      this.jZV = paramParcel.readString();
      AppMethodBeat.o(123503);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123502);
      paramParcel.writeString(this.jZU);
      paramParcel.writeString(this.jZV);
      AppMethodBeat.o(123502);
    }
  }
  
  public static final class WxaVersionInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaVersionInfo> CREATOR;
    public int aDD;
    public int cmx;
    public List<WxaAttributes.WxaWidgetInfo> ioH;
    public boolean jVD;
    public String jZW;
    public String jZX;
    public WxaAttributes.WxaVersionCoverImageInfo jZY;
    public List<WxaAttributes.WxaPluginCodeInfo> jZZ;
    public int kaa;
    public boolean kab;
    public String kac;
    public String kad;
    public String kae;
    public long kaf;
    public String kag;
    public String kah;
    public String kai;
    public String kaj;
    public List<WxaAttributes.WxaVersionModuleInfo> moduleList;
    
    static
    {
      AppMethodBeat.i(123509);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123509);
    }
    
    public WxaVersionInfo()
    {
      this.kag = "";
      this.kah = "";
      this.kai = "";
      this.kaj = "";
      this.jVD = false;
    }
    
    protected WxaVersionInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123508);
      this.kag = "";
      this.kah = "";
      this.kai = "";
      this.kaj = "";
      this.jVD = false;
      this.aDD = paramParcel.readInt();
      this.cmx = paramParcel.readInt();
      this.jZW = paramParcel.readString();
      this.jZX = paramParcel.readString();
      this.jZY = ((WxaAttributes.WxaVersionCoverImageInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionCoverImageInfo.class.getClassLoader()));
      this.jZZ = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      this.kaa = paramParcel.readInt();
      this.moduleList = paramParcel.createTypedArrayList(WxaAttributes.WxaVersionModuleInfo.CREATOR);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.kab = bool;
        this.kac = paramParcel.readString();
        this.kad = paramParcel.readString();
        this.kae = paramParcel.readString();
        this.ioH = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        this.kag = paramParcel.readString();
        this.kah = paramParcel.readString();
        this.kai = paramParcel.readString();
        this.kaj = paramParcel.readString();
        boolean[] arrayOfBoolean = new boolean[1];
        paramParcel.readBooleanArray(arrayOfBoolean);
        this.jVD = arrayOfBoolean[0];
        AppMethodBeat.o(123508);
        return;
      }
    }
    
    public static WxaVersionInfo NR(String paramString)
    {
      AppMethodBeat.i(123506);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(123506);
        return null;
      }
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        paramString = new WxaVersionInfo();
        paramString.aDD = localJSONObject1.optInt("AppVersion", 0);
        paramString.cmx = localJSONObject1.optInt("VersionState", -1);
        paramString.jZW = localJSONObject1.optString("VersionMD5");
        paramString.jZX = localJSONObject1.optString("device_orientation");
        paramString.kad = localJSONObject1.optString("client_js_ext_info");
        paramString.kaa = localJSONObject1.optInt("code_size");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("loading_image_info");
        if (localJSONObject2 != null)
        {
          paramString.jZY = new WxaAttributes.WxaVersionCoverImageInfo();
          paramString.jZY.jZU = localJSONObject2.optString("url");
          paramString.jZY.jZV = localJSONObject2.optString("progressbar_color");
        }
        JSONObject localJSONObject3 = localJSONObject1.optJSONObject("fake_native_loading_style_info");
        if (localJSONObject3 != null)
        {
          localJSONObject2 = localJSONObject3.optJSONObject("white_style");
          localJSONObject3 = localJSONObject3.optJSONObject("black_style");
          if (localJSONObject2 != null)
          {
            if (localJSONObject2.has("navigation_bar_text_color")) {
              paramString.kag = localJSONObject2.optString("navigation_bar_text_color");
            }
            if (localJSONObject2.has("background_color")) {
              paramString.kah = localJSONObject2.optString("background_color");
            }
          }
          if (localJSONObject3 != null)
          {
            if (localJSONObject3.has("navigation_bar_text_color")) {
              paramString.kai = localJSONObject3.optString("navigation_bar_text_color");
            }
            if (localJSONObject3.has("background_color")) {
              paramString.kaj = localJSONObject3.optString("background_color");
            }
          }
        }
        paramString.moduleList = WxaAttributes.WxaVersionModuleInfo.NS(localJSONObject1.optString("module_list"));
        paramString.kab = localJSONObject1.optBoolean("UseModule", false);
        paramString.kac = localJSONObject1.optString("EntranceModule");
        paramString.kae = localJSONObject1.optString("without_lib_md5");
        paramString.ioH = WxaAttributes.WxaWidgetInfo.NT(localJSONObject1.optString("widget_list"));
        paramString.jZZ = WxaAttributes.WxaPluginCodeInfo.a(paramString.ioH, localJSONObject1.optString("separated_plugin_list"), 22);
        paramString.kaf = localJSONObject1.optLong("ForceSyncUpdateWhenLaunchLastInterval", -1L);
        paramString.jVD = localJSONObject1.optBoolean("resizable", false);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
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
      paramParcel.writeInt(this.cmx);
      paramParcel.writeString(this.jZW);
      paramParcel.writeString(this.jZX);
      paramParcel.writeParcelable(this.jZY, paramInt);
      paramParcel.writeTypedList(this.jZZ);
      paramParcel.writeInt(this.kaa);
      paramParcel.writeTypedList(this.moduleList);
      if (this.kab) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.kac);
        paramParcel.writeString(this.kad);
        paramParcel.writeString(this.kae);
        paramParcel.writeTypedList(this.ioH);
        paramParcel.writeString(this.kag);
        paramParcel.writeString(this.kah);
        paramParcel.writeString(this.kai);
        paramParcel.writeString(this.kaj);
        paramParcel.writeBooleanArray(new boolean[] { this.jVD });
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
    public String kae;
    public List<WxaAttributes.WxaPluginCodeInfo> kak;
    public List<WxaAttributes.WxaWidgetInfo> kal;
    private JSONObject kam;
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
        this.kak = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
        this.kae = paramParcel.readString();
        this.kal = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        AppMethodBeat.o(123515);
        return;
      }
    }
    
    public static List<WxaVersionModuleInfo> NS(String paramString)
    {
      AppMethodBeat.i(123512);
      if (bt.isNullOrNil(paramString))
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
        ad.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, json = %s, e = %s", new Object[] { paramString, localJSONException });
        AppMethodBeat.o(123512);
      }
      return null;
    }
    
    private static List<WxaVersionModuleInfo> l(JSONArray paramJSONArray)
    {
      AppMethodBeat.i(123511);
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
            localWxaVersionModuleInfo.kam = localJSONObject;
            localWxaVersionModuleInfo.name = localJSONObject.getString("name");
            localWxaVersionModuleInfo.md5 = localJSONObject.getString("md5");
            localWxaVersionModuleInfo.size = localJSONObject.optInt("size", 0);
            localWxaVersionModuleInfo.independent = localJSONObject.optBoolean("independent", false);
            localWxaVersionModuleInfo.aliases = y(localJSONObject);
            localWxaVersionModuleInfo.kae = localJSONObject.optString("without_lib_md5");
            localWxaVersionModuleInfo.kal = WxaAttributes.WxaWidgetInfo.NT(localJSONObject.optString("widget_list"));
            localWxaVersionModuleInfo.kak = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionModuleInfo.kal, localJSONObject.optString("separated_plugin_list"), 23);
            localLinkedList.add(localWxaVersionModuleInfo);
          }
          i += 1;
        }
        AppMethodBeat.o(123511);
        return localLinkedList;
      }
      catch (JSONException paramJSONArray)
      {
        ad.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
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
        paramParcel.writeTypedList(this.kak);
        paramParcel.writeString(this.kae);
        paramParcel.writeTypedList(this.kal);
        AppMethodBeat.o(123514);
        return;
      }
    }
  }
  
  public static class WxaWidgetInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaWidgetInfo> CREATOR;
    public int dnF;
    public String kan;
    public List<WxaAttributes.WxaPluginCodeInfo> kao;
    
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
      this.dnF = paramParcel.readInt();
      this.kan = paramParcel.readString();
      this.kao = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      AppMethodBeat.o(175238);
    }
    
    public static List<WxaWidgetInfo> NT(String paramString)
    {
      AppMethodBeat.i(175236);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(175236);
        return null;
      }
      try
      {
        paramString = new JSONArray(paramString);
        int i = paramString.length();
        if (i <= 0)
        {
          AppMethodBeat.o(175236);
          return null;
        }
        LinkedList localLinkedList = new LinkedList();
        i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          if (localJSONObject != null)
          {
            WxaWidgetInfo localWxaWidgetInfo = new WxaWidgetInfo();
            localWxaWidgetInfo.dnF = localJSONObject.optInt("package_type");
            localWxaWidgetInfo.kan = localJSONObject.optString("wxapkg_md5");
            if (org.apache.commons.b.a.contains(com.tencent.mm.co.a.LAY, localWxaWidgetInfo.dnF))
            {
              localWxaWidgetInfo.kao = WxaAttributes.WxaPluginCodeInfo.NQ(localJSONObject.optString("separated_plugin_list"));
              localLinkedList.add(localWxaWidgetInfo);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(175236);
        return localLinkedList;
      }
      catch (JSONException paramString)
      {
        ad.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramString });
        AppMethodBeat.o(175236);
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
      paramParcel.writeInt(this.dnF);
      paramParcel.writeString(this.kan);
      paramParcel.writeTypedList(this.kao);
      AppMethodBeat.o(175237);
    }
  }
  
  public static final class a
  {
    public int cQN;
    public long cnh = 0L;
    public long jQb = 0L;
    public String jXq;
    public List<String> jZA;
    public List<String> jZB;
    public List<String> jZC;
    public List<String> jZD;
    public String jZE;
    public String jZx;
    private int jZy;
    public List<String> jZz;
    public int originalFlag;
    
    public static a NP(String paramString)
    {
      AppMethodBeat.i(123490);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
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
          locala.cnh = localJSONObject2.optLong("RunningFlag");
          locala.jZx = localJSONObject2.optString("AppOpenForbiddenUrl");
          locala.jQb = localJSONObject2.optLong("CanNotStarWxaBeforeTime", 0L);
        }
        localJSONObject2 = localJSONObject1.optJSONObject("Network");
        if (localJSONObject2 != null)
        {
          locala.jZz = aa.m(localJSONObject2.optJSONArray("RequestDomain"));
          locala.jZA = aa.m(localJSONObject2.optJSONArray("WsRequestDomain"));
          locala.jZB = aa.m(localJSONObject2.optJSONArray("UploadDomain"));
          locala.jZC = aa.m(localJSONObject2.optJSONArray("DownloadDomain"));
          locala.jZD = aa.m(localJSONObject2.optJSONArray("UDPDomain"));
        }
        locala.jZy = localJSONObject1.optInt("WechatPluginApp", 0);
        locala.cQN = localJSONObject1.optInt("AppServiceType", 0);
        locala.jZE = localJSONObject1.optString("fromBusinessUsername");
        locala.originalFlag = localJSONObject1.optInt("OriginalFlag", 0);
        locala.jXq = localJSONObject1.optString("OriginalRedirectUrl");
        paramString = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", new Object[] { paramString, localException });
          paramString = null;
        }
      }
      AppMethodBeat.o(123490);
      return paramString;
    }
    
    public final boolean Eb()
    {
      return this.cQN == 4;
    }
    
    public final boolean ber()
    {
      return (this.jZy > 0) || (this.cQN == 7);
    }
  }
  
  public static final class b
  {
    public int cQQ;
    public List<a> jZF;
    public int type;
    
    public static final class a
    {
      public String dki;
      public List<a> jZG;
      public String name;
      public int type;
      public String userName;
      public int version;
    }
  }
  
  public static final class c
  {
    public a jZH;
    public List<Pair<String, String>> jZI;
    
    public c()
    {
      AppMethodBeat.i(123491);
      this.jZH = new a();
      AppMethodBeat.o(123491);
    }
    
    public static final class a
    {
      public int cmL;
      public int cmM;
      public int cmN;
      public int cmO;
      public int cmP;
      public int cmQ;
      public boolean cmR;
      public boolean cmS;
      public boolean cna;
      public int cnc;
      public boolean jRu;
      public boolean jRv;
      public int jRw;
      public int jRx;
      public int jXI;
      public int jXJ;
      public int jYa;
      public boolean jYb;
      public int jYf;
      public int jYg;
      public int jZJ;
      public int jZK;
      public int jZL;
      public int jZM;
      public boolean jZN;
      public long jZO;
      public long jZP;
      public long jZQ;
      public long jZR;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes
 * JD-Core Version:    0.7.0.1
 */