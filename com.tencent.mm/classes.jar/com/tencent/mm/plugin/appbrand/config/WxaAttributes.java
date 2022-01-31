package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.h.c.fk;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WxaAttributes
  extends fk
{
  public static final c.a fCU;
  public static final String fQV;
  private WxaAttributes.a fQW;
  private WxaAttributes.c fQX;
  private WxaAttributes.d fQY;
  private List<WxaAttributes.WxaEntryInfo> fQZ = null;
  private WxaAttributes.b fRa;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "usernameHash";
    locala.ujN.put("usernameHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "usernameHash";
    locala.columns[1] = "username";
    locala.ujN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "nickname";
    locala.ujN.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "shortNickname";
    locala.ujN.put("shortNickname", "TEXT");
    localStringBuilder.append(" shortNickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "brandIconURL";
    locala.ujN.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "roundedSquareIconURL";
    locala.ujN.put("roundedSquareIconURL", "TEXT");
    localStringBuilder.append(" roundedSquareIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bigHeadURL";
    locala.ujN.put("bigHeadURL", "TEXT");
    localStringBuilder.append(" bigHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "smallHeadURL";
    locala.ujN.put("smallHeadURL", "TEXT");
    localStringBuilder.append(" smallHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "signature";
    locala.ujN.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "appOpt";
    locala.ujN.put("appOpt", "INTEGER default '0' ");
    localStringBuilder.append(" appOpt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "registerSource";
    locala.ujN.put("registerSource", "TEXT");
    localStringBuilder.append(" registerSource TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "appInfo";
    locala.ujN.put("appInfo", "TEXT");
    localStringBuilder.append(" appInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "versionInfo";
    locala.ujN.put("versionInfo", "TEXT");
    localStringBuilder.append(" versionInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "bindWxaInfo";
    locala.ujN.put("bindWxaInfo", "TEXT");
    localStringBuilder.append(" bindWxaInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "dynamicInfo";
    locala.ujN.put("dynamicInfo", "TEXT");
    localStringBuilder.append(" dynamicInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "reserved";
    locala.ujN.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "syncTimeSecond";
    locala.ujN.put("syncTimeSecond", "LONG default '0' ");
    localStringBuilder.append(" syncTimeSecond LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "syncVersion";
    locala.ujN.put("syncVersion", "TEXT");
    localStringBuilder.append(" syncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "bizMenu";
    locala.ujN.put("bizMenu", "TEXT");
    localStringBuilder.append(" bizMenu TEXT");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    fCU = locala;
    fQV = i.a(locala, "WxaAttributesTable");
  }
  
  private List<WxaAttributes.b.a> i(JSONArray paramJSONArray)
  {
    ArrayList localArrayList;
    if (paramJSONArray != null) {
      localArrayList = new ArrayList();
    }
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
        locala.bFw = localJSONObject.optString("pagePath", "");
        locala.version = localJSONObject.optInt("version");
        locala.fRj = i(((JSONObject)localObject).optJSONArray("sub_button_list"));
        localArrayList.add(locala);
        i += 1;
      }
      Object localObject = null;
      return localObject;
    }
    catch (JSONException paramJSONArray) {}
    return null;
  }
  
  public final WxaAttributes.a aen()
  {
    if (this.fQW == null) {
      this.fQW = WxaAttributes.a.sH(this.field_appInfo);
    }
    return this.fQW;
  }
  
  public final WxaAttributes.c aeo()
  {
    boolean bool2 = true;
    int i = 0;
    if (this.fQX == null) {
      try
      {
        Object localObject1 = new JSONObject(this.field_dynamicInfo);
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new JSONObject();
        }
        this.fQX = new WxaAttributes.c();
        Object localObject4 = ((JSONObject)localObject3).optJSONObject("NewSetting");
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = new JSONObject();
        }
        this.fQX.fRk.fRm = ((JSONObject)localObject1).optInt("MaxLocalstorageSize", 5);
        this.fQX.fRk.fRn = ((JSONObject)localObject1).optInt("MaxCodeSize", 5);
        this.fQX.fRk.fPO = ((JSONObject)localObject1).optInt("ExpendedMaxWebviewDepth", 5);
        this.fQX.fRk.fPY = ((JSONObject)localObject1).optInt("MaxBackgroundLifespan", 600);
        this.fQX.fRk.fPZ = ((JSONObject)localObject1).optInt("MaxRequestConcurrent", 5);
        this.fQX.fRk.fQa = ((JSONObject)localObject1).optInt("MaxUploadConcurrent", 5);
        this.fQX.fRk.fQb = ((JSONObject)localObject1).optInt("MaxDownloadConcurrent", 5);
        this.fQX.fRk.fQc = ((JSONObject)localObject1).optInt("MaxWebsocketConnect", 2);
        this.fQX.fRk.fQd = ((JSONObject)localObject1).optInt("MaxWorkerConcurrent", 1);
        localObject4 = this.fQX.fRk;
        if (((JSONObject)localObject1).optInt("WebsocketSkipPortCheck", 0) != 0)
        {
          bool1 = true;
          ((WxaAttributes.c.a)localObject4).fQe = bool1;
          this.fQX.fRk.fRo = ((JSONObject)localObject1).optInt("MaxFileStorageSize", 10);
          this.fQX.fRk.fRp = ((JSONObject)localObject1).optInt("BackgroundNetworkInterruptedTimeout", 5);
          localObject4 = this.fQX.fRk;
          if (((JSONObject)localObject1).optInt("CanKeepAliveByAudioPlay", 0) <= 0) {
            break label604;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject4).fPP = bool1;
          this.fQX.fRk.fPQ = ((JSONObject)localObject1).optInt("LifeSpanBeforeSuspend", 5);
          this.fQX.fRk.fPR = ((JSONObject)localObject1).optInt("LifeSpanAfterSuspend", 300);
          localObject4 = this.fQX.fRk;
          if (((JSONObject)localObject1).optInt("ScanCodeEnableZZM", 0) == 0) {
            break label609;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject4).fQn = bool1;
          localObject4 = this.fQX.fRk;
          if (((JSONObject)localObject1).optInt("CanPreFetchData", 0) <= 0) {
            break label614;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject4).fKF = bool1;
          localObject4 = this.fQX.fRk;
          if (((JSONObject)localObject1).optInt("CanPeriodFetchData", 0) <= 0) {
            break label619;
          }
          bool1 = bool2;
          ((WxaAttributes.c.a)localObject4).fKG = bool1;
          this.fQX.fRk.fKH = ((JSONObject)localObject1).optInt("PeriodFetchData", 0);
          localObject1 = ((JSONObject)localObject3).optJSONArray("NewCategories");
          if (localObject1 == null) {
            break label624;
          }
          this.fQX.fRl = new LinkedList();
          while (i < ((JSONArray)localObject1).length())
          {
            localObject3 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject3 != null) {
              this.fQX.fRl.add(new Pair(((JSONObject)localObject3).optString("first"), ((JSONObject)localObject3).optString("second")));
            }
            i += 1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
          continue;
          boolean bool1 = false;
          continue;
          label604:
          bool1 = false;
          continue;
          label609:
          bool1 = false;
          continue;
          label614:
          bool1 = false;
          continue;
          label619:
          bool1 = false;
        }
      }
    }
    label624:
    return this.fQX;
  }
  
  public final WxaAttributes.d aep()
  {
    if ((this.fQY == null) && (!bk.bl(this.field_versionInfo)))
    {
      WxaAttributes.d locald = WxaAttributes.d.sI(this.field_versionInfo);
      this.fQY = locald;
      return locald;
    }
    return this.fQY;
  }
  
  public final List<WxaAttributes.WxaEntryInfo> aeq()
  {
    if ((this.fQZ == null) && (!bk.bl(this.field_bindWxaInfo))) {
      try
      {
        JSONArray localJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
        if (localJSONArray != null)
        {
          this.fQZ = new LinkedList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject != null)
            {
              String str = localJSONObject.optString("username");
              if (!bk.bl(str))
              {
                WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
                localWxaEntryInfo.username = str;
                localWxaEntryInfo.title = localJSONObject.optString("title");
                localWxaEntryInfo.iconUrl = localJSONObject.optString("icon_url");
                this.fQZ.add(localWxaEntryInfo);
              }
            }
            i += 1;
          }
        }
        return this.fQZ;
      }
      catch (Exception localException)
      {
        this.fQZ = null;
      }
    }
  }
  
  public final WxaAttributes.b aer()
  {
    if ((this.fRa == null) && (!bk.bl(this.field_bizMenu))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.field_bizMenu);
      this.fRa = new WxaAttributes.b();
      this.fRa.eft = localJSONObject.optInt("interactive_mode", 0);
      this.fRa.type = localJSONObject.optInt("type", 0);
      this.fRa.fRi = i(localJSONObject.optJSONArray("button_list"));
      return this.fRa;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.fRa = null;
      }
    }
  }
  
  public final void d(Cursor paramCursor)
  {
    super.d(paramCursor);
    this.fQW = null;
    this.fQX = null;
    this.fQY = null;
    this.fQZ = null;
    this.fRa = null;
  }
  
  protected final c.a rM()
  {
    return fCU;
  }
  
  public final String toString()
  {
    return "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_brandIconURL='" + this.field_brandIconURL + '\'' + ", field_roundedSquareIconURL='" + this.field_roundedSquareIconURL + '\'' + ", field_bigHeadURL='" + this.field_bigHeadURL + '\'' + ", field_smallHeadURL='" + this.field_smallHeadURL + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_appOpt=" + this.field_appOpt + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + ", field_bizMenu='" + this.field_bizMenu + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes
 * JD-Core Version:    0.7.0.1
 */