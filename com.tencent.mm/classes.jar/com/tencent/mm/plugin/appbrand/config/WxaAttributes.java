package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gy;
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
  extends gy
{
  public static final c.a iMP;
  private a jeY;
  private c jeZ;
  private WxaVersionInfo jfa;
  private List<WxaAttributes.WxaEntryInfo> jfb = null;
  private b jfc;
  
  static
  {
    AppMethodBeat.i(123525);
    c.a locala = new c.a();
    locala.EYt = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "usernameHash";
    locala.EYv.put("usernameHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "usernameHash";
    locala.columns[1] = "username";
    locala.EYv.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.EYv.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "nickname";
    locala.EYv.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "shortNickname";
    locala.EYv.put("shortNickname", "TEXT");
    localStringBuilder.append(" shortNickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "brandIconURL";
    locala.EYv.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "roundedSquareIconURL";
    locala.EYv.put("roundedSquareIconURL", "TEXT");
    localStringBuilder.append(" roundedSquareIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bigHeadURL";
    locala.EYv.put("bigHeadURL", "TEXT");
    localStringBuilder.append(" bigHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "smallHeadURL";
    locala.EYv.put("smallHeadURL", "TEXT");
    localStringBuilder.append(" smallHeadURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "signature";
    locala.EYv.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "appOpt";
    locala.EYv.put("appOpt", "INTEGER default '0' ");
    localStringBuilder.append(" appOpt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "registerSource";
    locala.EYv.put("registerSource", "TEXT");
    localStringBuilder.append(" registerSource TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "appInfo";
    locala.EYv.put("appInfo", "TEXT");
    localStringBuilder.append(" appInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "versionInfo";
    locala.EYv.put("versionInfo", "TEXT");
    localStringBuilder.append(" versionInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "bindWxaInfo";
    locala.EYv.put("bindWxaInfo", "TEXT");
    localStringBuilder.append(" bindWxaInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "dynamicInfo";
    locala.EYv.put("dynamicInfo", "TEXT");
    localStringBuilder.append(" dynamicInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "reserved";
    locala.EYv.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "syncTimeSecond";
    locala.EYv.put("syncTimeSecond", "LONG default '0' ");
    localStringBuilder.append(" syncTimeSecond LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "syncVersion";
    locala.EYv.put("syncVersion", "TEXT");
    localStringBuilder.append(" syncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "bizMenu";
    locala.EYv.put("bizMenu", "TEXT");
    localStringBuilder.append(" bizMenu TEXT");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    iMP = locala;
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
          locala.dbu = localJSONObject.optString("pagePath", "");
          locala.version = localJSONObject.optInt("version");
          locala.jfm = k(((JSONObject)localObject).optJSONArray("sub_button_list"));
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
  
  public final a aTN()
  {
    AppMethodBeat.i(123518);
    if (this.jeY == null) {
      this.jeY = a.Gs(this.field_appInfo);
    }
    a locala = this.jeY;
    AppMethodBeat.o(123518);
    return locala;
  }
  
  public final c aTO()
  {
    boolean bool2 = true;
    int i = 0;
    AppMethodBeat.i(123519);
    if (this.jeZ == null) {
      try
      {
        Object localObject1 = new JSONObject(this.field_dynamicInfo);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new JSONObject();
        }
        this.jeZ = new c();
        Object localObject3 = ((JSONObject)localObject2).optJSONObject("NewSetting");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new JSONObject();
        }
        this.jeZ.jfn.cfO = ((JSONObject)localObject1).optInt("MaxLocalstorageSize", 5);
        this.jeZ.jfn.jfp = ((JSONObject)localObject1).optInt("OpendataMaxLocalstorageSize", 5);
        this.jeZ.jfn.jfq = ((JSONObject)localObject1).optInt("MaxCodeSize", 5);
        this.jeZ.jfn.jdL = ((JSONObject)localObject1).optInt("ExpendedMaxWebviewDepth", 5);
        this.jeZ.jfn.cfx = ((JSONObject)localObject1).optInt("MaxBackgroundLifespan", 600);
        this.jeZ.jfn.cfy = ((JSONObject)localObject1).optInt("MaxRequestConcurrent", 5);
        this.jeZ.jfn.cfz = ((JSONObject)localObject1).optInt("MaxUploadConcurrent", 5);
        this.jeZ.jfn.cfA = ((JSONObject)localObject1).optInt("MaxDownloadConcurrent", 5);
        this.jeZ.jfn.cfB = ((JSONObject)localObject1).optInt("MaxWebsocketConnect", 2);
        this.jeZ.jfn.cfC = ((JSONObject)localObject1).optInt("MaxWorkerConcurrent", 1);
        localObject3 = this.jeZ.jfn;
        if (((JSONObject)localObject1).optInt("WebsocketSkipPortCheck", 0) != 0)
        {
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cfD = bool1;
          localObject3 = this.jeZ.jfn;
          if (((JSONObject)localObject1).optInt("TLSSkipHostnameCheck", 0) == 0) {
            break label726;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cfE = bool1;
          this.jeZ.jfn.jfr = ((JSONObject)localObject1).optInt("MaxFileStorageSize", 10);
          this.jeZ.jfn.jfs = ((JSONObject)localObject1).optInt("BackgroundNetworkInterruptedTimeout", 5);
          localObject3 = this.jeZ.jfn;
          if (((JSONObject)localObject1).optInt("CanKeepAliveByAudioPlay", 0) <= 0) {
            break label731;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).jdM = bool1;
          this.jeZ.jfn.jdQ = ((JSONObject)localObject1).optInt("LifeSpanBeforeSuspend", 5);
          this.jeZ.jfn.jdR = ((JSONObject)localObject1).optInt("LifeSpanAfterSuspend", 300);
          localObject3 = this.jeZ.jfn;
          if (((JSONObject)localObject1).optInt("ScanCodeEnableZZM", 0) == 0) {
            break label736;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).cfM = bool1;
          localObject3 = this.jeZ.jfn;
          if (((JSONObject)localObject1).optInt("CanPreFetchData", 0) <= 0) {
            break label741;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).iXi = bool1;
          localObject3 = this.jeZ.jfn;
          if (((JSONObject)localObject1).optInt("CanPeriodFetchData", 0) <= 0) {
            break label746;
          }
          bool1 = true;
          ((WxaAttributes.c.a)localObject3).iXj = bool1;
          this.jeZ.jfn.iXk = ((JSONObject)localObject1).optInt("PeriodFetchData", 0);
          this.jeZ.jfn.iXl = ((JSONObject)localObject1).optInt("PeriodFetchDataDay", 7);
          this.jeZ.jfn.cfU = ((JSONObject)localObject1).optInt("GuaranteeFlag", 0);
          localObject3 = this.jeZ.jfn;
          if (((JSONObject)localObject1).optInt("CanShowLoadingAdvert", 0) <= 0) {
            break label751;
          }
          bool1 = bool2;
          ((WxaAttributes.c.a)localObject3).jft = bool1;
          localObject1 = ((JSONObject)localObject2).optJSONArray("NewCategories");
          if (localObject1 == null) {
            break label756;
          }
          this.jeZ.jfo = new LinkedList();
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 != null) {
              this.jeZ.jfo.add(new Pair(((JSONObject)localObject2).optString("first"), ((JSONObject)localObject2).optString("second")));
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
    c localc = this.jeZ;
    AppMethodBeat.o(123519);
    return localc;
  }
  
  public final WxaVersionInfo aTP()
  {
    AppMethodBeat.i(123520);
    if ((this.jfa == null) && (!bt.isNullOrNil(this.field_versionInfo)))
    {
      localWxaVersionInfo = WxaVersionInfo.Gu(this.field_versionInfo);
      this.jfa = localWxaVersionInfo;
      AppMethodBeat.o(123520);
      return localWxaVersionInfo;
    }
    WxaVersionInfo localWxaVersionInfo = this.jfa;
    AppMethodBeat.o(123520);
    return localWxaVersionInfo;
  }
  
  public final List<WxaAttributes.WxaEntryInfo> aTQ()
  {
    AppMethodBeat.i(123521);
    if ((this.jfb == null) && (!bt.isNullOrNil(this.field_bindWxaInfo))) {
      try
      {
        JSONArray localJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
        if (localJSONArray != null)
        {
          this.jfb = new LinkedList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject != null)
            {
              String str = localJSONObject.optString("username");
              if (!bt.isNullOrNil(str))
              {
                WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
                localWxaEntryInfo.username = str;
                localWxaEntryInfo.title = localJSONObject.optString("title");
                localWxaEntryInfo.iconUrl = localJSONObject.optString("icon_url");
                this.jfb.add(localWxaEntryInfo);
              }
            }
            i += 1;
          }
        }
        localList = this.jfb;
      }
      catch (Exception localException)
      {
        this.jfb = null;
      }
    }
    List localList;
    AppMethodBeat.o(123521);
    return localList;
  }
  
  public final b aTR()
  {
    AppMethodBeat.i(123522);
    if ((this.jfc == null) && (!bt.isNullOrNil(this.field_bizMenu))) {}
    try
    {
      Object localObject = new JSONObject(this.field_bizMenu);
      this.jfc = new b();
      this.jfc.cIE = ((JSONObject)localObject).optInt("interactive_mode", 0);
      this.jfc.type = ((JSONObject)localObject).optInt("type", 0);
      this.jfc.jfl = k(((JSONObject)localObject).optJSONArray("button_list"));
      localObject = this.jfc;
      AppMethodBeat.o(123522);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jfc = null;
      }
    }
  }
  
  public final void aTS()
  {
    int i = 0;
    AppMethodBeat.i(187825);
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
    AppMethodBeat.o(187825);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(123517);
    super.convertFrom(paramCursor);
    this.jeY = null;
    this.jeZ = null;
    this.jfa = null;
    this.jfb = null;
    this.jfc = null;
    AppMethodBeat.o(123517);
  }
  
  public final c.a getDBInfo()
  {
    return iMP;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123524);
    String str = "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + ", field_bizMenu='" + this.field_bizMenu + '\'' + '}';
    AppMethodBeat.o(123524);
    return str;
  }
  
  public static class WxaPluginCodeInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaPluginCodeInfo> CREATOR;
    public List<Integer> contexts;
    public boolean jfv;
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
        this.jfv = bool;
        if (this.contexts == null) {
          this.contexts = new LinkedList();
        }
        paramParcel.readList(this.contexts, Integer.class.getClassLoader());
        AppMethodBeat.o(123499);
        return;
        bool = false;
      }
    }
    
    public static List<WxaPluginCodeInfo> Gt(String paramString)
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
              localWxaPluginCodeInfo.jfv = bool;
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
        for (paramList = (List<WxaAttributes.WxaWidgetInfo>)localObject; localIterator.hasNext(); paramList = ((WxaAttributes.WxaWidgetInfo)localObject).jfQ)
        {
          localObject = (WxaAttributes.WxaWidgetInfo)localIterator.next();
          if (((WxaAttributes.WxaWidgetInfo)localObject).deP != paramInt) {
            break label76;
          }
        }
      }
      for (;;)
      {
        localObject = paramList;
        if (paramList == null) {
          localObject = Gt(paramString);
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
      if (this.jfv) {}
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
    public String jfw;
    public String jfx;
    
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
      this.jfw = paramParcel.readString();
      this.jfx = paramParcel.readString();
      AppMethodBeat.o(123503);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123502);
      paramParcel.writeString(this.jfw);
      paramParcel.writeString(this.jfx);
      AppMethodBeat.o(123502);
    }
  }
  
  public static final class WxaVersionInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaVersionInfo> CREATOR;
    public int aAS;
    public int cfk;
    public List<WxaAttributes.WxaWidgetInfo> huK;
    public boolean jbu;
    public WxaAttributes.WxaVersionCoverImageInfo jfA;
    public List<WxaAttributes.WxaPluginCodeInfo> jfB;
    public int jfC;
    public boolean jfD;
    public String jfE;
    public String jfF;
    public String jfG;
    public long jfH;
    public String jfI;
    public String jfJ;
    public String jfK;
    public String jfL;
    public String jfy;
    public String jfz;
    public List<WxaAttributes.WxaVersionModuleInfo> moduleList;
    
    static
    {
      AppMethodBeat.i(123509);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123509);
    }
    
    public WxaVersionInfo()
    {
      this.jfI = "";
      this.jfJ = "";
      this.jfK = "";
      this.jfL = "";
      this.jbu = false;
    }
    
    protected WxaVersionInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123508);
      this.jfI = "";
      this.jfJ = "";
      this.jfK = "";
      this.jfL = "";
      this.jbu = false;
      this.aAS = paramParcel.readInt();
      this.cfk = paramParcel.readInt();
      this.jfy = paramParcel.readString();
      this.jfz = paramParcel.readString();
      this.jfA = ((WxaAttributes.WxaVersionCoverImageInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionCoverImageInfo.class.getClassLoader()));
      this.jfB = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      this.jfC = paramParcel.readInt();
      this.moduleList = paramParcel.createTypedArrayList(WxaAttributes.WxaVersionModuleInfo.CREATOR);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jfD = bool;
        this.jfE = paramParcel.readString();
        this.jfF = paramParcel.readString();
        this.jfG = paramParcel.readString();
        this.huK = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        this.jfI = paramParcel.readString();
        this.jfJ = paramParcel.readString();
        this.jfK = paramParcel.readString();
        this.jfL = paramParcel.readString();
        boolean[] arrayOfBoolean = new boolean[1];
        paramParcel.readBooleanArray(arrayOfBoolean);
        this.jbu = arrayOfBoolean[0];
        AppMethodBeat.o(123508);
        return;
      }
    }
    
    public static WxaVersionInfo Gu(String paramString)
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
        paramString.aAS = localJSONObject1.optInt("AppVersion", 0);
        paramString.cfk = localJSONObject1.optInt("VersionState", -1);
        paramString.jfy = localJSONObject1.optString("VersionMD5");
        paramString.jfz = localJSONObject1.optString("device_orientation");
        paramString.jfF = localJSONObject1.optString("client_js_ext_info");
        paramString.jfC = localJSONObject1.optInt("code_size");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("loading_image_info");
        if (localJSONObject2 != null)
        {
          paramString.jfA = new WxaAttributes.WxaVersionCoverImageInfo();
          paramString.jfA.jfw = localJSONObject2.optString("url");
          paramString.jfA.jfx = localJSONObject2.optString("progressbar_color");
        }
        JSONObject localJSONObject3 = localJSONObject1.optJSONObject("fake_native_loading_style_info");
        if (localJSONObject3 != null)
        {
          localJSONObject2 = localJSONObject3.optJSONObject("white_style");
          localJSONObject3 = localJSONObject3.optJSONObject("black_style");
          if (localJSONObject2 != null)
          {
            if (localJSONObject2.has("navigation_bar_text_color")) {
              paramString.jfI = localJSONObject2.optString("navigation_bar_text_color");
            }
            if (localJSONObject2.has("background_color")) {
              paramString.jfJ = localJSONObject2.optString("background_color");
            }
          }
          if (localJSONObject3 != null)
          {
            if (localJSONObject3.has("navigation_bar_text_color")) {
              paramString.jfK = localJSONObject3.optString("navigation_bar_text_color");
            }
            if (localJSONObject3.has("background_color")) {
              paramString.jfL = localJSONObject3.optString("background_color");
            }
          }
        }
        paramString.moduleList = WxaAttributes.WxaVersionModuleInfo.Gv(localJSONObject1.optString("module_list"));
        paramString.jfD = localJSONObject1.optBoolean("UseModule", false);
        paramString.jfE = localJSONObject1.optString("EntranceModule");
        paramString.jfG = localJSONObject1.optString("without_lib_md5");
        paramString.huK = WxaAttributes.WxaWidgetInfo.Gw(localJSONObject1.optString("widget_list"));
        paramString.jfB = WxaAttributes.WxaPluginCodeInfo.a(paramString.huK, localJSONObject1.optString("separated_plugin_list"), 22);
        paramString.jfH = localJSONObject1.optLong("ForceSyncUpdateWhenLaunchLastInterval", -1L);
        paramString.jbu = localJSONObject1.optBoolean("resizable", false);
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
      paramParcel.writeInt(this.aAS);
      paramParcel.writeInt(this.cfk);
      paramParcel.writeString(this.jfy);
      paramParcel.writeString(this.jfz);
      paramParcel.writeParcelable(this.jfA, paramInt);
      paramParcel.writeTypedList(this.jfB);
      paramParcel.writeInt(this.jfC);
      paramParcel.writeTypedList(this.moduleList);
      if (this.jfD) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.jfE);
        paramParcel.writeString(this.jfF);
        paramParcel.writeString(this.jfG);
        paramParcel.writeTypedList(this.huK);
        paramParcel.writeString(this.jfI);
        paramParcel.writeString(this.jfJ);
        paramParcel.writeString(this.jfK);
        paramParcel.writeString(this.jfL);
        paramParcel.writeBooleanArray(new boolean[] { this.jbu });
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
    public String jfG;
    public List<WxaAttributes.WxaPluginCodeInfo> jfM;
    public List<WxaAttributes.WxaWidgetInfo> jfN;
    private JSONObject jfO;
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
        this.jfM = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
        this.jfG = paramParcel.readString();
        this.jfN = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        AppMethodBeat.o(123515);
        return;
      }
    }
    
    public static List<WxaVersionModuleInfo> Gv(String paramString)
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
            localWxaVersionModuleInfo.jfO = localJSONObject;
            localWxaVersionModuleInfo.name = localJSONObject.getString("name");
            localWxaVersionModuleInfo.md5 = localJSONObject.getString("md5");
            localWxaVersionModuleInfo.size = localJSONObject.optInt("size", 0);
            localWxaVersionModuleInfo.independent = localJSONObject.optBoolean("independent", false);
            localWxaVersionModuleInfo.aliases = y(localJSONObject);
            localWxaVersionModuleInfo.jfG = localJSONObject.optString("without_lib_md5");
            localWxaVersionModuleInfo.jfN = WxaAttributes.WxaWidgetInfo.Gw(localJSONObject.optString("widget_list"));
            localWxaVersionModuleInfo.jfM = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionModuleInfo.jfN, localJSONObject.optString("separated_plugin_list"), 23);
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
        paramParcel.writeTypedList(this.jfM);
        paramParcel.writeString(this.jfG);
        paramParcel.writeTypedList(this.jfN);
        AppMethodBeat.o(123514);
        return;
      }
    }
  }
  
  public static class WxaWidgetInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaWidgetInfo> CREATOR;
    public int deP;
    public String jfP;
    public List<WxaAttributes.WxaPluginCodeInfo> jfQ;
    
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
      this.deP = paramParcel.readInt();
      this.jfP = paramParcel.readString();
      this.jfQ = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      AppMethodBeat.o(175238);
    }
    
    public static List<WxaWidgetInfo> Gw(String paramString)
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
            localWxaWidgetInfo.deP = localJSONObject.optInt("package_type");
            localWxaWidgetInfo.jfP = localJSONObject.optString("wxapkg_md5");
            if (org.apache.commons.b.a.contains(com.tencent.mm.cp.a.Igs, localWxaWidgetInfo.deP))
            {
              localWxaWidgetInfo.jfQ = WxaAttributes.WxaPluginCodeInfo.Gt(localJSONObject.optString("separated_plugin_list"));
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
      paramParcel.writeInt(this.deP);
      paramParcel.writeString(this.jfP);
      paramParcel.writeTypedList(this.jfQ);
      AppMethodBeat.o(175237);
    }
  }
  
  public static final class a
  {
    public int cIB;
    public long cfT = 0L;
    public long iVR = 0L;
    public String jdh;
    public String jfd;
    private int jfe;
    public List<String> jff;
    public List<String> jfg;
    public List<String> jfh;
    public List<String> jfi;
    public List<String> jfj;
    public String jfk;
    public int originalFlag;
    
    public static a Gs(String paramString)
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
          locala.cfT = localJSONObject2.optLong("RunningFlag");
          locala.jfd = localJSONObject2.optString("AppOpenForbiddenUrl");
          locala.iVR = localJSONObject2.optLong("CanNotStarWxaBeforeTime", 0L);
        }
        localJSONObject2 = localJSONObject1.optJSONObject("Network");
        if (localJSONObject2 != null)
        {
          locala.jff = z.m(localJSONObject2.optJSONArray("RequestDomain"));
          locala.jfg = z.m(localJSONObject2.optJSONArray("WsRequestDomain"));
          locala.jfh = z.m(localJSONObject2.optJSONArray("UploadDomain"));
          locala.jfi = z.m(localJSONObject2.optJSONArray("DownloadDomain"));
          locala.jfj = z.m(localJSONObject2.optJSONArray("UDPDomain"));
        }
        locala.jfe = localJSONObject1.optInt("WechatPluginApp", 0);
        locala.cIB = localJSONObject1.optInt("AppServiceType", 0);
        locala.jfk = localJSONObject1.optString("fromBusinessUsername");
        locala.originalFlag = localJSONObject1.optInt("OriginalFlag", 0);
        locala.jdh = localJSONObject1.optString("OriginalRedirectUrl");
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
    
    public final boolean CZ()
    {
      return this.cIB == 4;
    }
    
    public final boolean aTT()
    {
      return (this.jfe > 0) || (this.cIB == 7);
    }
  }
  
  public static final class b
  {
    public int cIE;
    public List<WxaAttributes.b.a> jfl;
    public int type;
  }
  
  public static final class c
  {
    public a jfn;
    public List<Pair<String, String>> jfo;
    
    public c()
    {
      AppMethodBeat.i(123491);
      this.jfn = new a();
      AppMethodBeat.o(123491);
    }
    
    public static final class a
    {
      public int cfA;
      public int cfB;
      public int cfC;
      public boolean cfD;
      public boolean cfE;
      public boolean cfM;
      public int cfO;
      public int cfU;
      public int cfx;
      public int cfy;
      public int cfz;
      public boolean iXi;
      public boolean iXj;
      public int iXk;
      public int iXl;
      public int jdL;
      public boolean jdM;
      public int jdQ;
      public int jdR;
      public int jfp;
      public int jfq;
      public int jfr;
      public int jfs;
      public boolean jft;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes
 * JD-Core Version:    0.7.0.1
 */