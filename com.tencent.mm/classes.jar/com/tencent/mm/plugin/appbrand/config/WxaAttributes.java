package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fy;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WxaAttributes
  extends fy
{
  public static final c.a gUb;
  private WxaAttributes.a hjH;
  private WxaAttributes.c hjI;
  private WxaAttributes.WxaVersionInfo hjJ;
  private List<WxaAttributes.WxaEntryInfo> hjK = null;
  private WxaAttributes.b hjL;
  
  static
  {
    AppMethodBeat.i(96177);
    c.a locala = new c.a();
    locala.yrK = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "usernameHash";
    locala.yrM.put("usernameHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "usernameHash";
    locala.columns[1] = "username";
    locala.yrM.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.yrM.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "nickname";
    locala.yrM.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "shortNickname";
    locala.yrM.put("shortNickname", "TEXT");
    localStringBuilder.append(" shortNickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "brandIconURL";
    locala.yrM.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "roundedSquareIconURL";
    locala.yrM.put("roundedSquareIconURL", "TEXT");
    localStringBuilder.append(" roundedSquareIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bigHeadURL";
    locala.yrM.put("bigHeadURL", "TEXT");
    localStringBuilder.append(" bigHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "smallHeadURL";
    locala.yrM.put("smallHeadURL", "TEXT");
    localStringBuilder.append(" smallHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "signature";
    locala.yrM.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "appOpt";
    locala.yrM.put("appOpt", "INTEGER default '0' ");
    localStringBuilder.append(" appOpt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "registerSource";
    locala.yrM.put("registerSource", "TEXT");
    localStringBuilder.append(" registerSource TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "appInfo";
    locala.yrM.put("appInfo", "TEXT");
    localStringBuilder.append(" appInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "versionInfo";
    locala.yrM.put("versionInfo", "TEXT");
    localStringBuilder.append(" versionInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "bindWxaInfo";
    locala.yrM.put("bindWxaInfo", "TEXT");
    localStringBuilder.append(" bindWxaInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "dynamicInfo";
    locala.yrM.put("dynamicInfo", "TEXT");
    localStringBuilder.append(" dynamicInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "reserved";
    locala.yrM.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "syncTimeSecond";
    locala.yrM.put("syncTimeSecond", "LONG default '0' ");
    localStringBuilder.append(" syncTimeSecond LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "syncVersion";
    locala.yrM.put("syncVersion", "TEXT");
    localStringBuilder.append(" syncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "bizMenu";
    locala.yrM.put("bizMenu", "TEXT");
    localStringBuilder.append(" bizMenu TEXT");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    gUb = locala;
    AppMethodBeat.o(96177);
  }
  
  private List<WxaAttributes.b.a> k(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(96175);
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
          locala.cmG = localJSONObject.optString("pagePath", "");
          locala.version = localJSONObject.optInt("version");
          locala.hjV = k(((JSONObject)localObject).optJSONArray("sub_button_list"));
          localArrayList.add(locala);
          i += 1;
        }
        localObject = null;
      }
      catch (JSONException paramJSONArray)
      {
        AppMethodBeat.o(96175);
        return null;
      }
    }
    AppMethodBeat.o(96175);
    return localObject;
  }
  
  public final WxaAttributes.a ayC()
  {
    AppMethodBeat.i(96170);
    if (this.hjH == null) {
      this.hjH = WxaAttributes.a.AB(this.field_appInfo);
    }
    WxaAttributes.a locala = this.hjH;
    AppMethodBeat.o(96170);
    return locala;
  }
  
  public final WxaAttributes.c ayD()
  {
    boolean bool2 = true;
    int i = 0;
    AppMethodBeat.i(96171);
    if (this.hjI == null) {
      try
      {
        Object localObject1 = new JSONObject(this.field_dynamicInfo);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new JSONObject();
        }
        this.hjI = new WxaAttributes.c();
        Object localObject3 = ((JSONObject)localObject2).optJSONObject("NewSetting");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new JSONObject();
        }
        this.hjI.hjW.bDG = ((JSONObject)localObject1).optInt("MaxLocalstorageSize", 5);
        this.hjI.hjW.hjY = ((JSONObject)localObject1).optInt("OpendataMaxLocalstorageSize", 5);
        this.hjI.hjW.hjZ = ((JSONObject)localObject1).optInt("MaxCodeSize", 5);
        this.hjI.hjW.hiR = ((JSONObject)localObject1).optInt("ExpendedMaxWebviewDepth", 5);
        this.hjI.hjW.bDp = ((JSONObject)localObject1).optInt("MaxBackgroundLifespan", 600);
        this.hjI.hjW.bDq = ((JSONObject)localObject1).optInt("MaxRequestConcurrent", 5);
        this.hjI.hjW.bDr = ((JSONObject)localObject1).optInt("MaxUploadConcurrent", 5);
        this.hjI.hjW.bDs = ((JSONObject)localObject1).optInt("MaxDownloadConcurrent", 5);
        this.hjI.hjW.bDt = ((JSONObject)localObject1).optInt("MaxWebsocketConnect", 2);
        this.hjI.hjW.bDu = ((JSONObject)localObject1).optInt("MaxWorkerConcurrent", 1);
        localObject3 = this.hjI.hjW;
        if (((JSONObject)localObject1).optInt("WebsocketSkipPortCheck", 0) != 0)
        {
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).bDv = bool1;
          localObject3 = this.hjI.hjW;
          if (((JSONObject)localObject1).optInt("TLSSkipHostnameCheck", 0) == 0) {
            break label658;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).bDw = bool1;
          this.hjI.hjW.hka = ((JSONObject)localObject1).optInt("MaxFileStorageSize", 10);
          this.hjI.hjW.hkb = ((JSONObject)localObject1).optInt("BackgroundNetworkInterruptedTimeout", 5);
          localObject3 = this.hjI.hjW;
          if (((JSONObject)localObject1).optInt("CanKeepAliveByAudioPlay", 0) <= 0) {
            break label663;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).hiS = bool1;
          this.hjI.hjW.hiV = ((JSONObject)localObject1).optInt("LifeSpanBeforeSuspend", 5);
          this.hjI.hjW.hiW = ((JSONObject)localObject1).optInt("LifeSpanAfterSuspend", 300);
          localObject3 = this.hjI.hjW;
          if (((JSONObject)localObject1).optInt("ScanCodeEnableZZM", 0) == 0) {
            break label668;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).bDE = bool1;
          localObject3 = this.hjI.hjW;
          if (((JSONObject)localObject1).optInt("CanPreFetchData", 0) <= 0) {
            break label673;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).hdS = bool1;
          localObject3 = this.hjI.hjW;
          if (((JSONObject)localObject1).optInt("CanPeriodFetchData", 0) <= 0) {
            break label678;
          }
          bool1 = bool2;
          ((WxaAttributes.c.a)localObject3).hdT = bool1;
          this.hjI.hjW.hdU = ((JSONObject)localObject1).optInt("PeriodFetchData", 0);
          localObject1 = ((JSONObject)localObject2).optJSONArray("NewCategories");
          if (localObject1 == null) {
            break label683;
          }
          this.hjI.hjX = new LinkedList();
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 != null) {
              this.hjI.hjX.add(new Pair(((JSONObject)localObject2).optString("first"), ((JSONObject)localObject2).optString("second")));
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
          label658:
          bool1 = false;
          continue;
          label663:
          bool1 = false;
          continue;
          label668:
          bool1 = false;
          continue;
          label673:
          bool1 = false;
          continue;
          label678:
          bool1 = false;
        }
      }
    }
    label683:
    WxaAttributes.c localc = this.hjI;
    AppMethodBeat.o(96171);
    return localc;
  }
  
  public final WxaAttributes.WxaVersionInfo ayE()
  {
    AppMethodBeat.i(96172);
    if ((this.hjJ == null) && (!bo.isNullOrNil(this.field_versionInfo)))
    {
      localWxaVersionInfo = WxaAttributes.WxaVersionInfo.AD(this.field_versionInfo);
      this.hjJ = localWxaVersionInfo;
      AppMethodBeat.o(96172);
      return localWxaVersionInfo;
    }
    WxaAttributes.WxaVersionInfo localWxaVersionInfo = this.hjJ;
    AppMethodBeat.o(96172);
    return localWxaVersionInfo;
  }
  
  public final List<WxaAttributes.WxaEntryInfo> ayF()
  {
    AppMethodBeat.i(96173);
    if ((this.hjK == null) && (!bo.isNullOrNil(this.field_bindWxaInfo))) {
      try
      {
        JSONArray localJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
        if (localJSONArray != null)
        {
          this.hjK = new LinkedList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject != null)
            {
              String str = localJSONObject.optString("username");
              if (!bo.isNullOrNil(str))
              {
                WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
                localWxaEntryInfo.username = str;
                localWxaEntryInfo.title = localJSONObject.optString("title");
                localWxaEntryInfo.iconUrl = localJSONObject.optString("icon_url");
                this.hjK.add(localWxaEntryInfo);
              }
            }
            i += 1;
          }
        }
        localList = this.hjK;
      }
      catch (Exception localException)
      {
        this.hjK = null;
      }
    }
    List localList;
    AppMethodBeat.o(96173);
    return localList;
  }
  
  public final WxaAttributes.b ayG()
  {
    AppMethodBeat.i(96174);
    if ((this.hjL == null) && (!bo.isNullOrNil(this.field_bizMenu))) {}
    try
    {
      Object localObject = new JSONObject(this.field_bizMenu);
      this.hjL = new WxaAttributes.b();
      this.hjL.fvv = ((JSONObject)localObject).optInt("interactive_mode", 0);
      this.hjL.type = ((JSONObject)localObject).optInt("type", 0);
      this.hjL.hjU = k(((JSONObject)localObject).optJSONArray("button_list"));
      localObject = this.hjL;
      AppMethodBeat.o(96174);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.hjL = null;
      }
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(96169);
    super.convertFrom(paramCursor);
    this.hjH = null;
    this.hjI = null;
    this.hjJ = null;
    this.hjK = null;
    this.hjL = null;
    AppMethodBeat.o(96169);
  }
  
  public final c.a getDBInfo()
  {
    return gUb;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(96176);
    String str = "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_brandIconURL='" + this.field_brandIconURL + '\'' + ", field_roundedSquareIconURL='" + this.field_roundedSquareIconURL + '\'' + ", field_bigHeadURL='" + this.field_bigHeadURL + '\'' + ", field_smallHeadURL='" + this.field_smallHeadURL + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_appOpt=" + this.field_appOpt + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + ", field_bizMenu='" + this.field_bizMenu + '\'' + '}';
    AppMethodBeat.o(96176);
    return str;
  }
  
  public static class WxaVersionModuleInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaVersionModuleInfo> CREATOR;
    public boolean cnm;
    public String cqq;
    public String[] gUz;
    public List<WxaAttributes.WxaCodeLibInfo> hkl;
    public String hkm;
    public String name;
    public int size;
    
    static
    {
      AppMethodBeat.i(140095);
      CREATOR = new WxaAttributes.WxaVersionModuleInfo.1();
      AppMethodBeat.o(140095);
    }
    
    public WxaVersionModuleInfo() {}
    
    protected WxaVersionModuleInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(140094);
      this.name = paramParcel.readString();
      this.cqq = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.cnm = bool;
        this.size = paramParcel.readInt();
        this.gUz = paramParcel.createStringArray();
        this.hkl = paramParcel.createTypedArrayList(WxaAttributes.WxaCodeLibInfo.CREATOR);
        this.hkm = paramParcel.readString();
        AppMethodBeat.o(140094);
        return;
      }
    }
    
    public static List<WxaVersionModuleInfo> AE(String paramString)
    {
      AppMethodBeat.i(96167);
      if (bo.isNullOrNil(paramString))
      {
        AppMethodBeat.o(96167);
        return null;
      }
      try
      {
        Object localObject = new JSONArray(paramString);
        int i = ((JSONArray)localObject).length();
        if (i <= 0)
        {
          AppMethodBeat.o(96167);
          return null;
        }
        localObject = l((JSONArray)localObject);
        AppMethodBeat.o(96167);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        ab.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, json = %s, e = %s", new Object[] { paramString, localJSONException });
        AppMethodBeat.o(96167);
      }
      return null;
    }
    
    private static List<WxaVersionModuleInfo> l(JSONArray paramJSONArray)
    {
      AppMethodBeat.i(140092);
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
            localWxaVersionModuleInfo.name = localJSONObject.getString("name");
            localWxaVersionModuleInfo.cqq = localJSONObject.getString("md5");
            localWxaVersionModuleInfo.size = localJSONObject.optInt("size", 0);
            localWxaVersionModuleInfo.cnm = localJSONObject.optBoolean("independent", false);
            localWxaVersionModuleInfo.gUz = t(localJSONObject);
            localWxaVersionModuleInfo.hkl = WxaAttributes.WxaCodeLibInfo.AC(localJSONObject.optString("wxacode_lib_info_list"));
            localWxaVersionModuleInfo.hkm = localJSONObject.optString("without_lib_md5");
            localLinkedList.add(localWxaVersionModuleInfo);
          }
          i += 1;
        }
        AppMethodBeat.o(140092);
        return localLinkedList;
      }
      catch (JSONException paramJSONArray)
      {
        ab.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
        AppMethodBeat.o(140092);
      }
      return null;
    }
    
    private static String[] t(JSONObject paramJSONObject)
    {
      int i = 0;
      AppMethodBeat.i(96168);
      paramJSONObject = paramJSONObject.optJSONArray("alias");
      if ((paramJSONObject == null) || (paramJSONObject.length() <= 0))
      {
        AppMethodBeat.o(96168);
        return new String[0];
      }
      String[] arrayOfString = new String[paramJSONObject.length()];
      while (i < paramJSONObject.length())
      {
        arrayOfString[i] = paramJSONObject.optString(i);
        i += 1;
      }
      AppMethodBeat.o(96168);
      return arrayOfString;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(140093);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.cqq);
      if (this.cnm) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.size);
        paramParcel.writeStringArray(this.gUz);
        paramParcel.writeTypedList(this.hkl);
        paramParcel.writeString(this.hkm);
        AppMethodBeat.o(140093);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes
 * JD-Core Version:    0.7.0.1
 */