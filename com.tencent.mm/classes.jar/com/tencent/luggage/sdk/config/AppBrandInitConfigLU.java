package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandInitConfigLU
  extends AppBrandInitConfig
{
  public static final Parcelable.Creator<AppBrandInitConfigLU> CREATOR;
  public int aDD;
  public WxaAttributes.WxaVersionInfo cmA;
  public String cmB;
  public a<?> cmC;
  public boolean cmD;
  public transient AppBrandStatObject cmE;
  protected String cmr;
  public String cms;
  public int cmt;
  public boolean cmu;
  public String cmv;
  public String cmw;
  public final AppBrandLaunchReferrer cmx;
  public final AppBrandWeishiParams cmy;
  public int cmz;
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
    this.cmD = false;
    this.cmx = new AppBrandLaunchReferrer();
    this.cmy = new AppBrandWeishiParams();
    AppMethodBeat.o(169428);
  }
  
  protected AppBrandInitConfigLU(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(146697);
    this.cmD = false;
    this.cmr = paramParcel.readString();
    this.cms = paramParcel.readString();
    this.username = paramParcel.readString();
    this.cmv = paramParcel.readString();
    this.cmw = paramParcel.readString();
    this.cmx = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.cmy = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    this.cmt = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cmu = bool1;
      this.extInfo = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      this.aDD = paramParcel.readInt();
      this.cmz = paramParcel.readInt();
      this.cmA = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      this.cmB = paramParcel.readString();
      this.uin = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label208;
      }
    }
    label208:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cmD = bool1;
      this.cmC = OnWXAppResultXPCWrapper.a(paramParcel);
      AppMethodBeat.o(146697);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean Eb()
  {
    AppMethodBeat.i(220757);
    if (bu.isNullOrNil(this.cmA.kdu))
    {
      AppMethodBeat.o(220757);
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.cmA.kdu).optJSONArray("call_plugin_info");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        AppMethodBeat.o(220757);
        return true;
      }
      AppMethodBeat.o(220757);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220757);
    }
    return false;
  }
  
  public final boolean Ec()
  {
    return this.cmD;
  }
  
  public final AppBrandStatObject Ed()
  {
    return this.cmE;
  }
  
  public boolean Ee()
  {
    return this.cmt == 4;
  }
  
  public final String Ef()
  {
    return this.cmr;
  }
  
  public final JSONObject Eg()
  {
    AppMethodBeat.i(146694);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("shareKey", this.cmw);
      localJSONObject.put("shareName", this.cmv);
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
  
  public final JSONObject Eh()
  {
    AppMethodBeat.i(146695);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("nickname", this.dpI);
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
  
  public final JSONObject Ei()
  {
    AppMethodBeat.i(146696);
    if ((this.cmx != null) && (2 == this.cmx.kbg) && (TextUtils.isEmpty(this.cmx.appId)))
    {
      AppMethodBeat.o(146696);
      return null;
    }
    JSONObject localJSONObject = this.cmx.beE();
    AppMethodBeat.o(146696);
    return localJSONObject;
  }
  
  public AppBrandInitConfigLU Ej()
  {
    AppMethodBeat.i(146699);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.Ek();
    AppMethodBeat.o(146699);
    return localAppBrandInitConfigLU;
  }
  
  public final void a(AppBrandStatObject paramAppBrandStatObject)
  {
    this.cmE = paramAppBrandStatObject;
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(146693);
    this.cmr = ("SessionId@" + hashCode() + "#" + bu.fpO());
    AppMethodBeat.o(146693);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146698);
    String str = "AppBrandInitConfigLU {visitingSessionId='" + this.cmr + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.dpI + '\'' + ", debugType=" + this.dQv + ", orientation='" + this.cpm + '\'' + ", enterPath='" + this.jFL + '\'' + ", shareName='" + this.cmv + '\'' + ", shareKey='" + this.cmw + '\'' + ", startTime=" + this.startTime + ", referrer=" + this.cmx + ", extInfo=" + this.extInfo + ", appVersion=" + this.aDD + '}';
    AppMethodBeat.o(146698);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(146700);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.cmr);
    paramParcel.writeString(this.cms);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.cmv);
    paramParcel.writeString(this.cmw);
    paramParcel.writeParcelable(this.cmx, paramInt);
    paramParcel.writeParcelable(this.cmy, paramInt);
    paramParcel.writeInt(this.cmt);
    byte b;
    if (this.cmu)
    {
      b = 1;
      paramParcel.writeByte(b);
      paramParcel.writeString(this.extInfo);
      paramParcel.writeLong(this.startTime);
      paramParcel.writeInt(this.aDD);
      paramParcel.writeInt(this.cmz);
      paramParcel.writeParcelable(this.cmA, paramInt);
      paramParcel.writeString(this.cmB);
      paramParcel.writeInt(this.uin);
      if (!this.cmD) {
        break label188;
      }
    }
    label188:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      OnWXAppResultXPCWrapper.a(this.cmC, paramParcel);
      AppMethodBeat.o(146700);
      return;
      b = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.AppBrandInitConfigLU
 * JD-Core Version:    0.7.0.1
 */