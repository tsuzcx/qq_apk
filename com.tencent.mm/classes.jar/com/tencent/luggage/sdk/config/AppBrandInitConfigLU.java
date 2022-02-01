package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.luggage.sdk.launching.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandInitConfigLU
  extends AppBrandInitConfig
{
  public static final Parcelable.Creator<AppBrandInitConfigLU> CREATOR;
  public int appServiceType;
  public int appVersion;
  public String eoP;
  public String eoQ;
  public String eoR;
  private Boolean eoS;
  public String eoT;
  public String eoU;
  public final AppBrandLaunchReferrer eoV;
  public final AppBrandWeishiParams eoW;
  public boolean eoX;
  public String eoY;
  public int eoZ;
  public WxaAttributes.WxaVersionInfo epa;
  public String epb;
  public int epc;
  public boolean epd;
  public boolean epe;
  public boolean epf;
  public b<?> epg;
  public b<?> eph;
  public boolean epi;
  public AppBrandInitWindowConfig epj;
  public boolean epk;
  public boolean epl;
  public com.tencent.luggage.sdk.launching.e epm;
  public transient AppBrandStatObject epn;
  public String extInfo;
  public long startTime;
  public int uin;
  public String username;
  
  static
  {
    AppMethodBeat.i(146703);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146703);
  }
  
  public AppBrandInitConfigLU()
  {
    AppMethodBeat.i(169428);
    this.eoS = null;
    this.epj = null;
    this.epl = false;
    this.epm = com.tencent.luggage.sdk.launching.e.etI;
    this.eoV = new AppBrandLaunchReferrer();
    this.eoW = new AppBrandWeishiParams();
    AppMethodBeat.o(169428);
  }
  
  protected AppBrandInitConfigLU(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(146697);
    this.eoS = null;
    this.epj = null;
    this.epl = false;
    this.epm = com.tencent.luggage.sdk.launching.e.etI;
    this.eoP = paramParcel.readString();
    this.eoQ = paramParcel.readString();
    this.username = paramParcel.readString();
    this.eoR = paramParcel.readString();
    this.eoT = paramParcel.readString();
    this.eoU = paramParcel.readString();
    this.eoV = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.eoW = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    this.appServiceType = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.eoX = bool1;
      this.extInfo = paramParcel.readString();
      this.eoY = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      this.appVersion = paramParcel.readInt();
      this.eoZ = paramParcel.readInt();
      this.epa = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      this.epb = paramParcel.readString();
      this.uin = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label353;
      }
      bool1 = true;
      label217:
      this.epl = bool1;
      this.epg = d.c(paramParcel);
      this.eph = d.c(paramParcel);
      this.epm = com.tencent.luggage.sdk.launching.e.d(paramParcel);
      this.epc = paramParcel.readInt();
      if (paramParcel.readInt() <= 0) {
        break label358;
      }
      bool1 = true;
      label263:
      this.epd = bool1;
      if (paramParcel.readByte() <= 0) {
        break label363;
      }
      bool1 = true;
      label277:
      this.epe = bool1;
      if (paramParcel.readByte() <= 0) {
        break label368;
      }
      bool1 = true;
      label291:
      this.epf = bool1;
      this.epj = ((AppBrandInitWindowConfig)paramParcel.readParcelable(AppBrandInitWindowConfig.class.getClassLoader()));
      if (paramParcel.readInt() != 1) {
        break label373;
      }
      bool1 = true;
      label322:
      this.epk = bool1;
      if (paramParcel.readInt() != 1) {
        break label378;
      }
    }
    label353:
    label358:
    label363:
    label368:
    label373:
    label378:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.epi = bool1;
      AppMethodBeat.o(146697);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label217;
      bool1 = false;
      break label263;
      bool1 = false;
      break label277;
      bool1 = false;
      break label291;
      bool1 = false;
      break label322;
    }
  }
  
  public final boolean aqC()
  {
    AppMethodBeat.i(220240);
    boolean bool;
    if (this.eoS != null)
    {
      bool = this.eoS.booleanValue();
      AppMethodBeat.o(220240);
      return bool;
    }
    Object localObject;
    if (Util.isNullOrNil(this.epa.rcs))
    {
      localObject = Boolean.FALSE;
      this.eoS = ((Boolean)localObject);
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(220240);
      return bool;
    }
    try
    {
      localObject = new JSONObject(this.epa.rcs).optJSONArray("call_plugin_info");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {}
      for (bool = true;; bool = false)
      {
        localObject = Boolean.valueOf(bool);
        this.eoS = ((Boolean)localObject);
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(220240);
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220240);
    }
  }
  
  public final boolean aqD()
  {
    AppMethodBeat.i(220243);
    boolean bool = Util.nullAsNil(this.epa.rcB).contains("skyline");
    AppMethodBeat.o(220243);
    return bool;
  }
  
  public final z aqE()
  {
    if (this.epj == null) {
      return z.raV;
    }
    return this.epj.epq;
  }
  
  public final String aqF()
  {
    if (this.epj == null) {
      return null;
    }
    return this.epj.epr;
  }
  
  public final y aqG()
  {
    if (this.epj == null) {
      return y.raQ;
    }
    return this.epj.ept;
  }
  
  public final y aqH()
  {
    if (this.epj == null) {
      return y.raQ;
    }
    return this.epj.epu;
  }
  
  public final void aqI()
  {
    AppMethodBeat.i(146693);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.AppBrandInitConfigLU", "resetSession() %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    e locale2 = e.a.eqq;
    e locale1 = locale2;
    if (locale2 == null) {
      locale1 = e.eqp;
    }
    this.eoP = locale1.aqQ();
    AppMethodBeat.o(146693);
  }
  
  public boolean aqJ()
  {
    return this.appServiceType == 4;
  }
  
  public final JSONObject aqK()
  {
    AppMethodBeat.i(146694);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("shareKey", this.eoU);
      localJSONObject.put("shareName", this.eoT);
      if (localJSONObject.length() == 0)
      {
        AppMethodBeat.o(146694);
        return null;
      }
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(146694);
      return null;
    }
    AppMethodBeat.o(146694);
    return localJSONException;
  }
  
  public final JSONObject aqL()
  {
    AppMethodBeat.i(146695);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("nickname", this.hEy);
      localJSONObject.put("icon", this.iconUrl);
      if (localJSONObject.length() == 0)
      {
        AppMethodBeat.o(146695);
        return null;
      }
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(146695);
      return null;
    }
    AppMethodBeat.o(146695);
    return localJSONException;
  }
  
  public final JSONObject aqM()
  {
    AppMethodBeat.i(146696);
    JSONObject localJSONObject = this.eoV.ckI();
    AppMethodBeat.o(146696);
    return localJSONObject;
  }
  
  public AppBrandInitConfigLU aqN()
  {
    AppMethodBeat.i(146699);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.aqO();
    AppMethodBeat.o(146699);
    return localAppBrandInitConfigLU;
  }
  
  public final void ff(String paramString)
  {
    AppMethodBeat.i(220257);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.AppBrandInitConfigLU", "resetSession(%s) %s", new Object[] { paramString, android.util.Log.getStackTraceString(new Throwable()) });
    this.eoP = paramString;
    AppMethodBeat.o(220257);
  }
  
  public final void fk(String paramString)
  {
    AppMethodBeat.i(220258);
    Assert.assertFalse(TextUtils.isEmpty(paramString));
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.AppBrandInitConfigLU", "resetInstanceId(%s) %s", new Object[] { paramString, android.util.Log.getStackTraceString(new Throwable()) });
    this.eoQ = paramString;
    AppMethodBeat.o(220258);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146698);
    String str = "AppBrandInitConfigLU {visitingSessionId='" + this.eoP + '\'' + ", wxaLaunchInstanceId=" + this.eoQ + ", clickTimestamp=" + this.startTime + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.hEy + '\'' + ", debugType=" + this.eul + ", orientation='" + this.euP + '\'' + ", enterPath='" + this.qAF + '\'' + ", shareName='" + this.eoT + '\'' + ", shareKey='" + this.eoU + '\'' + ", startTime=" + this.startTime + ", referrer=" + this.eoV + ", extInfo=" + this.extInfo + ", appVersion=" + this.appVersion + ", wsEndpoint=" + this.eoY + '}';
    AppMethodBeat.o(146698);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(146700);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.eoP);
    paramParcel.writeString(this.eoQ);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.eoR);
    paramParcel.writeString(this.eoT);
    paramParcel.writeString(this.eoU);
    paramParcel.writeParcelable(this.eoV, paramInt);
    paramParcel.writeParcelable(this.eoW, paramInt);
    paramParcel.writeInt(this.appServiceType);
    byte b;
    int i;
    if (this.eoX)
    {
      b = 1;
      paramParcel.writeByte(b);
      paramParcel.writeString(this.extInfo);
      paramParcel.writeString(this.eoY);
      paramParcel.writeLong(this.startTime);
      paramParcel.writeInt(this.appVersion);
      paramParcel.writeInt(this.eoZ);
      paramParcel.writeParcelable(this.epa, paramInt);
      paramParcel.writeString(this.epb);
      paramParcel.writeInt(this.uin);
      if (!this.epl) {
        break label317;
      }
      i = 1;
      label178:
      paramParcel.writeByte((byte)i);
      d.b(this.epg, paramParcel);
      d.b(this.eph, paramParcel);
      com.tencent.luggage.sdk.launching.e.a(this.epm, paramParcel);
      paramParcel.writeInt(this.epc);
      if (!this.epd) {
        break label323;
      }
      i = 1;
      label227:
      paramParcel.writeInt(i);
      if (!this.epe) {
        break label329;
      }
      i = 1;
      label243:
      paramParcel.writeByte((byte)i);
      if (!this.epf) {
        break label335;
      }
      i = 1;
      label260:
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.epj, paramInt);
      if (!this.epk) {
        break label341;
      }
      paramInt = 1;
      label285:
      paramParcel.writeInt(paramInt);
      if (!this.epi) {
        break label346;
      }
    }
    label317:
    label323:
    label329:
    label335:
    label341:
    label346:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(146700);
      return;
      b = 0;
      break;
      i = 0;
      break label178;
      i = 0;
      break label227;
      i = 0;
      break label243;
      i = 0;
      break label260;
      paramInt = 0;
      break label285;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.AppBrandInitConfigLU
 * JD-Core Version:    0.7.0.1
 */