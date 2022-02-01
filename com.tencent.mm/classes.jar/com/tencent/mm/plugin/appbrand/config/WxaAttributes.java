package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hc;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  extends hc
{
  public static final c.a jmW;
  private a jFn;
  private c jFo;
  private WxaVersionInfo jFp;
  private List<WxaEntryInfo> jFq = null;
  private b jFr;
  
  static
  {
    AppMethodBeat.i(123525);
    c.a locala = new c.a();
    locala.GvF = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "usernameHash";
    locala.GvH.put("usernameHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "usernameHash";
    locala.columns[1] = "username";
    locala.GvH.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.GvH.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "nickname";
    locala.GvH.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "shortNickname";
    locala.GvH.put("shortNickname", "TEXT");
    localStringBuilder.append(" shortNickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "brandIconURL";
    locala.GvH.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "roundedSquareIconURL";
    locala.GvH.put("roundedSquareIconURL", "TEXT");
    localStringBuilder.append(" roundedSquareIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bigHeadURL";
    locala.GvH.put("bigHeadURL", "TEXT");
    localStringBuilder.append(" bigHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "smallHeadURL";
    locala.GvH.put("smallHeadURL", "TEXT");
    localStringBuilder.append(" smallHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "signature";
    locala.GvH.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "appOpt";
    locala.GvH.put("appOpt", "INTEGER default '0' ");
    localStringBuilder.append(" appOpt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "registerSource";
    locala.GvH.put("registerSource", "TEXT");
    localStringBuilder.append(" registerSource TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "appInfo";
    locala.GvH.put("appInfo", "TEXT");
    localStringBuilder.append(" appInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "versionInfo";
    locala.GvH.put("versionInfo", "TEXT");
    localStringBuilder.append(" versionInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "passThroughInfo";
    locala.GvH.put("passThroughInfo", "TEXT");
    localStringBuilder.append(" passThroughInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "bindWxaInfo";
    locala.GvH.put("bindWxaInfo", "TEXT");
    localStringBuilder.append(" bindWxaInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "dynamicInfo";
    locala.GvH.put("dynamicInfo", "TEXT");
    localStringBuilder.append(" dynamicInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "reserved";
    locala.GvH.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "syncTimeSecond";
    locala.GvH.put("syncTimeSecond", "LONG default '0' ");
    localStringBuilder.append(" syncTimeSecond LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "syncVersion";
    locala.GvH.put("syncVersion", "TEXT");
    localStringBuilder.append(" syncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "bizMenu";
    locala.GvH.put("bizMenu", "TEXT");
    localStringBuilder.append(" bizMenu TEXT");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    jmW = locala;
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
          locala.cYQ = localJSONObject.optString("pagePath", "");
          locala.version = localJSONObject.optInt("version");
          locala.jFB = k(((JSONObject)localObject).optJSONArray("sub_button_list"));
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
  
  public final a baL()
  {
    AppMethodBeat.i(123518);
    if (this.jFn == null) {
      this.jFn = a.Kw(this.field_appInfo);
    }
    a locala = this.jFn;
    AppMethodBeat.o(123518);
    return locala;
  }
  
  public final c baM()
  {
    boolean bool2 = true;
    int i = 0;
    AppMethodBeat.i(123519);
    if (this.jFo == null) {
      try
      {
        Object localObject1 = new JSONObject(this.field_dynamicInfo);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new JSONObject();
        }
        this.jFo = new c();
        Object localObject3 = ((JSONObject)localObject2).optJSONObject("NewSetting");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new JSONObject();
        }
        this.jFo.jFC.ccL = ((JSONObject)localObject1).optInt("MaxLocalstorageSize", 5);
        this.jFo.jFC.jFE = ((JSONObject)localObject1).optInt("OpendataMaxLocalstorageSize", 5);
        this.jFo.jFC.jFF = ((JSONObject)localObject1).optInt("MaxCodeSize", 5);
        this.jFo.jFC.jDZ = ((JSONObject)localObject1).optInt("ExpendedMaxWebviewDepth", 5);
        this.jFo.jFC.ccu = ((JSONObject)localObject1).optInt("MaxBackgroundLifespan", 600);
        this.jFo.jFC.ccv = ((JSONObject)localObject1).optInt("MaxRequestConcurrent", 5);
        this.jFo.jFC.ccw = ((JSONObject)localObject1).optInt("MaxUploadConcurrent", 5);
        this.jFo.jFC.ccx = ((JSONObject)localObject1).optInt("MaxDownloadConcurrent", 5);
        this.jFo.jFC.ccy = ((JSONObject)localObject1).optInt("MaxWebsocketConnect", 2);
        this.jFo.jFC.ccz = ((JSONObject)localObject1).optInt("MaxWorkerConcurrent", 1);
        localObject3 = this.jFo.jFC;
        if (((JSONObject)localObject1).optInt("WebsocketSkipPortCheck", 0) != 0)
        {
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).ccA = bool1;
          localObject3 = this.jFo.jFC;
          if (((JSONObject)localObject1).optInt("TLSSkipHostnameCheck", 0) == 0) {
            break label726;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).ccB = bool1;
          this.jFo.jFC.jFG = ((JSONObject)localObject1).optInt("MaxFileStorageSize", 10);
          this.jFo.jFC.jFH = ((JSONObject)localObject1).optInt("BackgroundNetworkInterruptedTimeout", 5);
          localObject3 = this.jFo.jFC;
          if (((JSONObject)localObject1).optInt("CanKeepAliveByAudioPlay", 0) <= 0) {
            break label731;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).jEa = bool1;
          this.jFo.jFC.jEe = ((JSONObject)localObject1).optInt("LifeSpanBeforeSuspend", 5);
          this.jFo.jFC.jEf = ((JSONObject)localObject1).optInt("LifeSpanAfterSuspend", 300);
          localObject3 = this.jFo.jFC;
          if (((JSONObject)localObject1).optInt("ScanCodeEnableZZM", 0) == 0) {
            break label736;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).ccJ = bool1;
          localObject3 = this.jFo.jFC;
          if (((JSONObject)localObject1).optInt("CanPreFetchData", 0) <= 0) {
            break label741;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).jxy = bool1;
          localObject3 = this.jFo.jFC;
          if (((JSONObject)localObject1).optInt("CanPeriodFetchData", 0) <= 0) {
            break label746;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).jxz = bool1;
          this.jFo.jFC.jxA = ((JSONObject)localObject1).optInt("PeriodFetchData", 0);
          this.jFo.jFC.jxB = ((JSONObject)localObject1).optInt("PeriodFetchDataDay", 7);
          this.jFo.jFC.ccR = ((JSONObject)localObject1).optInt("GuaranteeFlag", 0);
          localObject3 = this.jFo.jFC;
          if (((JSONObject)localObject1).optInt("CanShowLoadingAdvert", 0) <= 0) {
            break label751;
          }
          bool1 = bool2;
          ((WxaAttributes.c.a)localObject3).jFI = bool1;
          localObject1 = ((JSONObject)localObject2).optJSONArray("NewCategories");
          if (localObject1 == null) {
            break label756;
          }
          this.jFo.jFD = new LinkedList();
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 != null) {
              this.jFo.jFD.add(new Pair(((JSONObject)localObject2).optString("first"), ((JSONObject)localObject2).optString("second")));
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
          label726:
          bool1 = false;
          continue;
          label731:
          bool1 = false;
          continue;
          label736:
          bool1 = false;
          continue;
          label741:
          bool1 = false;
          continue;
          label746:
          bool1 = false;
          continue;
          label751:
          bool1 = false;
        }
      }
    }
    label756:
    c localc = this.jFo;
    AppMethodBeat.o(123519);
    return localc;
  }
  
  public final WxaVersionInfo baN()
  {
    AppMethodBeat.i(123520);
    if ((this.jFp == null) && (!bs.isNullOrNil(this.field_versionInfo)))
    {
      localWxaVersionInfo = WxaVersionInfo.Ky(this.field_versionInfo);
      this.jFp = localWxaVersionInfo;
      AppMethodBeat.o(123520);
      return localWxaVersionInfo;
    }
    WxaVersionInfo localWxaVersionInfo = this.jFp;
    AppMethodBeat.o(123520);
    return localWxaVersionInfo;
  }
  
  public final List<WxaEntryInfo> baO()
  {
    AppMethodBeat.i(123521);
    if ((this.jFq == null) && (!bs.isNullOrNil(this.field_bindWxaInfo))) {
      try
      {
        JSONArray localJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
        if (localJSONArray != null)
        {
          this.jFq = new LinkedList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject != null)
            {
              String str = localJSONObject.optString("username");
              if (!bs.isNullOrNil(str))
              {
                WxaEntryInfo localWxaEntryInfo = new WxaEntryInfo();
                localWxaEntryInfo.username = str;
                localWxaEntryInfo.title = localJSONObject.optString("title");
                localWxaEntryInfo.iconUrl = localJSONObject.optString("icon_url");
                this.jFq.add(localWxaEntryInfo);
              }
            }
            i += 1;
          }
        }
        localList = this.jFq;
      }
      catch (Exception localException)
      {
        this.jFq = null;
      }
    }
    List localList;
    AppMethodBeat.o(123521);
    return localList;
  }
  
  public final b baP()
  {
    AppMethodBeat.i(123522);
    if ((this.jFr == null) && (!bs.isNullOrNil(this.field_bizMenu))) {}
    try
    {
      Object localObject = new JSONObject(this.field_bizMenu);
      this.jFr = new b();
      this.jFr.cFL = ((JSONObject)localObject).optInt("interactive_mode", 0);
      this.jFr.type = ((JSONObject)localObject).optInt("type", 0);
      this.jFr.jFA = k(((JSONObject)localObject).optJSONArray("button_list"));
      localObject = this.jFr;
      AppMethodBeat.o(123522);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jFr = null;
      }
    }
  }
  
  public final void baQ()
  {
    int i = 0;
    AppMethodBeat.i(194852);
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
    AppMethodBeat.o(194852);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(123517);
    super.convertFrom(paramCursor);
    this.jFn = null;
    this.jFo = null;
    this.jFp = null;
    this.jFq = null;
    this.jFr = null;
    AppMethodBeat.o(123517);
  }
  
  public final c.a getDBInfo()
  {
    return jmW;
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
    public String jFJ;
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
      this.jFJ = paramParcel.readString();
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
      paramParcel.writeString(this.jFJ);
      paramParcel.writeString(this.iconUrl);
      AppMethodBeat.o(123493);
    }
  }
  
  public static class WxaPluginCodeInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaPluginCodeInfo> CREATOR;
    public List<Integer> contexts;
    public boolean jFK;
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
        this.jFK = bool;
        if (this.contexts == null) {
          this.contexts = new LinkedList();
        }
        paramParcel.readList(this.contexts, Integer.class.getClassLoader());
        AppMethodBeat.o(123499);
        return;
        bool = false;
      }
    }
    
    public static List<WxaPluginCodeInfo> Kx(String paramString)
    {
      AppMethodBeat.i(123497);
      if (bs.isNullOrNil(paramString))
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
              localWxaPluginCodeInfo.jFK = bool;
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
          ac.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramString });
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
        for (paramList = (List<WxaAttributes.WxaWidgetInfo>)localObject; localIterator.hasNext(); paramList = ((WxaAttributes.WxaWidgetInfo)localObject).jGf)
        {
          localObject = (WxaAttributes.WxaWidgetInfo)localIterator.next();
          if (((WxaAttributes.WxaWidgetInfo)localObject).dcj != paramInt) {
            break label76;
          }
        }
      }
      for (;;)
      {
        localObject = paramList;
        if (paramList == null) {
          localObject = Kx(paramString);
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
      if (this.jFK) {}
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
    public String jFL;
    public String jFM;
    
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
      this.jFL = paramParcel.readString();
      this.jFM = paramParcel.readString();
      AppMethodBeat.o(123503);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123502);
      paramParcel.writeString(this.jFL);
      paramParcel.writeString(this.jFM);
      AppMethodBeat.o(123502);
    }
  }
  
  public static final class WxaVersionInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaVersionInfo> CREATOR;
    public int aBM;
    public int ccg;
    public List<WxaAttributes.WxaWidgetInfo> hVm;
    public boolean jBH;
    public String jFN;
    public String jFO;
    public WxaAttributes.WxaVersionCoverImageInfo jFP;
    public List<WxaAttributes.WxaPluginCodeInfo> jFQ;
    public int jFR;
    public boolean jFS;
    public String jFT;
    public String jFU;
    public String jFV;
    public long jFW;
    public String jFX;
    public String jFY;
    public String jFZ;
    public String jGa;
    public List<WxaAttributes.WxaVersionModuleInfo> moduleList;
    
    static
    {
      AppMethodBeat.i(123509);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123509);
    }
    
    public WxaVersionInfo()
    {
      this.jFX = "";
      this.jFY = "";
      this.jFZ = "";
      this.jGa = "";
      this.jBH = false;
    }
    
    protected WxaVersionInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123508);
      this.jFX = "";
      this.jFY = "";
      this.jFZ = "";
      this.jGa = "";
      this.jBH = false;
      this.aBM = paramParcel.readInt();
      this.ccg = paramParcel.readInt();
      this.jFN = paramParcel.readString();
      this.jFO = paramParcel.readString();
      this.jFP = ((WxaAttributes.WxaVersionCoverImageInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionCoverImageInfo.class.getClassLoader()));
      this.jFQ = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      this.jFR = paramParcel.readInt();
      this.moduleList = paramParcel.createTypedArrayList(WxaAttributes.WxaVersionModuleInfo.CREATOR);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jFS = bool;
        this.jFT = paramParcel.readString();
        this.jFU = paramParcel.readString();
        this.jFV = paramParcel.readString();
        this.hVm = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        this.jFX = paramParcel.readString();
        this.jFY = paramParcel.readString();
        this.jFZ = paramParcel.readString();
        this.jGa = paramParcel.readString();
        boolean[] arrayOfBoolean = new boolean[1];
        paramParcel.readBooleanArray(arrayOfBoolean);
        this.jBH = arrayOfBoolean[0];
        AppMethodBeat.o(123508);
        return;
      }
    }
    
    public static WxaVersionInfo Ky(String paramString)
    {
      AppMethodBeat.i(123506);
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(123506);
        return null;
      }
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        paramString = new WxaVersionInfo();
        paramString.aBM = localJSONObject1.optInt("AppVersion", 0);
        paramString.ccg = localJSONObject1.optInt("VersionState", -1);
        paramString.jFN = localJSONObject1.optString("VersionMD5");
        paramString.jFO = localJSONObject1.optString("device_orientation");
        paramString.jFU = localJSONObject1.optString("client_js_ext_info");
        paramString.jFR = localJSONObject1.optInt("code_size");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("loading_image_info");
        if (localJSONObject2 != null)
        {
          paramString.jFP = new WxaAttributes.WxaVersionCoverImageInfo();
          paramString.jFP.jFL = localJSONObject2.optString("url");
          paramString.jFP.jFM = localJSONObject2.optString("progressbar_color");
        }
        JSONObject localJSONObject3 = localJSONObject1.optJSONObject("fake_native_loading_style_info");
        if (localJSONObject3 != null)
        {
          localJSONObject2 = localJSONObject3.optJSONObject("white_style");
          localJSONObject3 = localJSONObject3.optJSONObject("black_style");
          if (localJSONObject2 != null)
          {
            if (localJSONObject2.has("navigation_bar_text_color")) {
              paramString.jFX = localJSONObject2.optString("navigation_bar_text_color");
            }
            if (localJSONObject2.has("background_color")) {
              paramString.jFY = localJSONObject2.optString("background_color");
            }
          }
          if (localJSONObject3 != null)
          {
            if (localJSONObject3.has("navigation_bar_text_color")) {
              paramString.jFZ = localJSONObject3.optString("navigation_bar_text_color");
            }
            if (localJSONObject3.has("background_color")) {
              paramString.jGa = localJSONObject3.optString("background_color");
            }
          }
        }
        paramString.moduleList = WxaAttributes.WxaVersionModuleInfo.Kz(localJSONObject1.optString("module_list"));
        paramString.jFS = localJSONObject1.optBoolean("UseModule", false);
        paramString.jFT = localJSONObject1.optString("EntranceModule");
        paramString.jFV = localJSONObject1.optString("without_lib_md5");
        paramString.hVm = WxaAttributes.WxaWidgetInfo.KA(localJSONObject1.optString("widget_list"));
        paramString.jFQ = WxaAttributes.WxaPluginCodeInfo.a(paramString.hVm, localJSONObject1.optString("separated_plugin_list"), 22);
        paramString.jFW = localJSONObject1.optLong("ForceSyncUpdateWhenLaunchLastInterval", -1L);
        paramString.jBH = localJSONObject1.optBoolean("resizable", false);
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
      paramParcel.writeInt(this.aBM);
      paramParcel.writeInt(this.ccg);
      paramParcel.writeString(this.jFN);
      paramParcel.writeString(this.jFO);
      paramParcel.writeParcelable(this.jFP, paramInt);
      paramParcel.writeTypedList(this.jFQ);
      paramParcel.writeInt(this.jFR);
      paramParcel.writeTypedList(this.moduleList);
      if (this.jFS) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.jFT);
        paramParcel.writeString(this.jFU);
        paramParcel.writeString(this.jFV);
        paramParcel.writeTypedList(this.hVm);
        paramParcel.writeString(this.jFX);
        paramParcel.writeString(this.jFY);
        paramParcel.writeString(this.jFZ);
        paramParcel.writeString(this.jGa);
        paramParcel.writeBooleanArray(new boolean[] { this.jBH });
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
    public String jFV;
    public List<WxaAttributes.WxaPluginCodeInfo> jGb;
    public List<WxaAttributes.WxaWidgetInfo> jGc;
    private JSONObject jGd;
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
        this.jGb = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
        this.jFV = paramParcel.readString();
        this.jGc = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        AppMethodBeat.o(123515);
        return;
      }
    }
    
    public static List<WxaVersionModuleInfo> Kz(String paramString)
    {
      AppMethodBeat.i(123512);
      if (bs.isNullOrNil(paramString))
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
        ac.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, json = %s, e = %s", new Object[] { paramString, localJSONException });
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
            localWxaVersionModuleInfo.jGd = localJSONObject;
            localWxaVersionModuleInfo.name = localJSONObject.getString("name");
            localWxaVersionModuleInfo.md5 = localJSONObject.getString("md5");
            localWxaVersionModuleInfo.size = localJSONObject.optInt("size", 0);
            localWxaVersionModuleInfo.independent = localJSONObject.optBoolean("independent", false);
            localWxaVersionModuleInfo.aliases = y(localJSONObject);
            localWxaVersionModuleInfo.jFV = localJSONObject.optString("without_lib_md5");
            localWxaVersionModuleInfo.jGc = WxaAttributes.WxaWidgetInfo.KA(localJSONObject.optString("widget_list"));
            localWxaVersionModuleInfo.jGb = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionModuleInfo.jGc, localJSONObject.optString("separated_plugin_list"), 23);
            localLinkedList.add(localWxaVersionModuleInfo);
          }
          i += 1;
        }
        AppMethodBeat.o(123511);
        return localLinkedList;
      }
      catch (JSONException paramJSONArray)
      {
        ac.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
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
        paramParcel.writeTypedList(this.jGb);
        paramParcel.writeString(this.jFV);
        paramParcel.writeTypedList(this.jGc);
        AppMethodBeat.o(123514);
        return;
      }
    }
  }
  
  public static class WxaWidgetInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaWidgetInfo> CREATOR;
    public int dcj;
    public String jGe;
    public List<WxaAttributes.WxaPluginCodeInfo> jGf;
    
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
      this.dcj = paramParcel.readInt();
      this.jGe = paramParcel.readString();
      this.jGf = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      AppMethodBeat.o(175238);
    }
    
    public static List<WxaWidgetInfo> KA(String paramString)
    {
      AppMethodBeat.i(175236);
      if (bs.isNullOrNil(paramString))
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
            localWxaWidgetInfo.dcj = localJSONObject.optInt("package_type");
            localWxaWidgetInfo.jGe = localJSONObject.optString("wxapkg_md5");
            if (org.apache.commons.b.a.contains(com.tencent.mm.co.a.JHU, localWxaWidgetInfo.dcj))
            {
              localWxaWidgetInfo.jGf = WxaAttributes.WxaPluginCodeInfo.Kx(localJSONObject.optString("separated_plugin_list"));
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
        ac.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramString });
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
      paramParcel.writeInt(this.dcj);
      paramParcel.writeString(this.jGe);
      paramParcel.writeTypedList(this.jGf);
      AppMethodBeat.o(175237);
    }
  }
  
  public static final class a
  {
    public int cFI;
    public long ccQ = 0L;
    public String jDu;
    public String jFs;
    private int jFt;
    public List<String> jFu;
    public List<String> jFv;
    public List<String> jFw;
    public List<String> jFx;
    public List<String> jFy;
    public String jFz;
    public long jwh = 0L;
    public int originalFlag;
    
    public static a Kw(String paramString)
    {
      AppMethodBeat.i(123490);
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
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
          locala.ccQ = localJSONObject2.optLong("RunningFlag");
          locala.jFs = localJSONObject2.optString("AppOpenForbiddenUrl");
          locala.jwh = localJSONObject2.optLong("CanNotStarWxaBeforeTime", 0L);
        }
        localJSONObject2 = localJSONObject1.optJSONObject("Network");
        if (localJSONObject2 != null)
        {
          locala.jFu = z.m(localJSONObject2.optJSONArray("RequestDomain"));
          locala.jFv = z.m(localJSONObject2.optJSONArray("WsRequestDomain"));
          locala.jFw = z.m(localJSONObject2.optJSONArray("UploadDomain"));
          locala.jFx = z.m(localJSONObject2.optJSONArray("DownloadDomain"));
          locala.jFy = z.m(localJSONObject2.optJSONArray("UDPDomain"));
        }
        locala.jFt = localJSONObject1.optInt("WechatPluginApp", 0);
        locala.cFI = localJSONObject1.optInt("AppServiceType", 0);
        locala.jFz = localJSONObject1.optString("fromBusinessUsername");
        locala.originalFlag = localJSONObject1.optInt("OriginalFlag", 0);
        locala.jDu = localJSONObject1.optString("OriginalRedirectUrl");
        paramString = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", new Object[] { paramString, localException });
          paramString = null;
        }
      }
      AppMethodBeat.o(123490);
      return paramString;
    }
    
    public final boolean CC()
    {
      return this.cFI == 4;
    }
    
    public final boolean baR()
    {
      return (this.jFt > 0) || (this.cFI == 7);
    }
  }
  
  public static final class b
  {
    public int cFL;
    public List<a> jFA;
    public int type;
    
    public static final class a
    {
      public String cYQ;
      public List<a> jFB;
      public String name;
      public int type;
      public String userName;
      public int version;
    }
  }
  
  public static final class c
  {
    public a jFC;
    public List<Pair<String, String>> jFD;
    
    public c()
    {
      AppMethodBeat.i(123491);
      this.jFC = new a();
      AppMethodBeat.o(123491);
    }
    
    public static final class a
    {
      public boolean ccA;
      public boolean ccB;
      public boolean ccJ;
      public int ccL;
      public int ccR;
      public int ccu;
      public int ccv;
      public int ccw;
      public int ccx;
      public int ccy;
      public int ccz;
      public int jDZ;
      public boolean jEa;
      public int jEe;
      public int jEf;
      public int jFE;
      public int jFF;
      public int jFG;
      public int jFH;
      public boolean jFI;
      public int jxA;
      public int jxB;
      public boolean jxy;
      public boolean jxz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes
 * JD-Core Version:    0.7.0.1
 */