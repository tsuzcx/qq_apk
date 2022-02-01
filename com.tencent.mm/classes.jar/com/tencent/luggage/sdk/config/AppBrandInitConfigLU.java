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
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandInitConfigLU
  extends AppBrandInitConfig
{
  public static final Parcelable.Creator<AppBrandInitConfigLU> CREATOR;
  public int aDD;
  public a<?> cmA;
  public boolean cmB;
  public transient AppBrandStatObject cmC;
  protected String cmp;
  public String cmq;
  public int cmr;
  public boolean cms;
  public String cmt;
  public String cmu;
  public final AppBrandLaunchReferrer cmv;
  public final AppBrandWeishiParams cmw;
  public int cmx;
  public WxaAttributes.WxaVersionInfo cmy;
  public String cmz;
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
    this.cmB = false;
    this.cmv = new AppBrandLaunchReferrer();
    this.cmw = new AppBrandWeishiParams();
    AppMethodBeat.o(169428);
  }
  
  protected AppBrandInitConfigLU(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(146697);
    this.cmB = false;
    this.cmp = paramParcel.readString();
    this.cmq = paramParcel.readString();
    this.username = paramParcel.readString();
    this.cmt = paramParcel.readString();
    this.cmu = paramParcel.readString();
    this.cmv = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.cmw = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    this.cmr = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cms = bool1;
      this.extInfo = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      this.aDD = paramParcel.readInt();
      this.cmx = paramParcel.readInt();
      this.cmy = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      this.cmz = paramParcel.readString();
      this.uin = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label208;
      }
    }
    label208:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cmB = bool1;
      this.cmA = OnWXAppResultXPCWrapper.a(paramParcel);
      AppMethodBeat.o(146697);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean DY()
  {
    AppMethodBeat.i(192184);
    if (bt.isNullOrNil(this.cmy.kad))
    {
      AppMethodBeat.o(192184);
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.cmy.kad).optJSONArray("call_plugin_info");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        AppMethodBeat.o(192184);
        return true;
      }
      AppMethodBeat.o(192184);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(192184);
    }
    return false;
  }
  
  public final boolean DZ()
  {
    return this.cmB;
  }
  
  public final AppBrandStatObject Ea()
  {
    return this.cmC;
  }
  
  public boolean Eb()
  {
    return this.cmr == 4;
  }
  
  public final String Ec()
  {
    return this.cmp;
  }
  
  public final JSONObject Ed()
  {
    AppMethodBeat.i(146694);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("shareKey", this.cmu);
      localJSONObject.put("shareName", this.cmt);
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
  
  public final JSONObject Ee()
  {
    AppMethodBeat.i(146695);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("nickname", this.doD);
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
  
  public final JSONObject Ef()
  {
    AppMethodBeat.i(146696);
    if ((this.cmv != null) && (2 == this.cmv.jXR) && (TextUtils.isEmpty(this.cmv.appId)))
    {
      AppMethodBeat.o(146696);
      return null;
    }
    JSONObject localJSONObject = this.cmv.bdY();
    AppMethodBeat.o(146696);
    return localJSONObject;
  }
  
  public AppBrandInitConfigLU Eg()
  {
    AppMethodBeat.i(146699);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.Eh();
    AppMethodBeat.o(146699);
    return localAppBrandInitConfigLU;
  }
  
  public final void a(AppBrandStatObject paramAppBrandStatObject)
  {
    this.cmC = paramAppBrandStatObject;
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(146693);
    this.cmp = ("SessionId@" + hashCode() + "#" + bt.flT());
    AppMethodBeat.o(146693);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146698);
    String str = "AppBrandInitConfigLU {visitingSessionId='" + this.cmp + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.doD + '\'' + ", debugType=" + this.dPf + ", orientation='" + this.jVL + '\'' + ", enterPath='" + this.jCN + '\'' + ", shareName='" + this.cmt + '\'' + ", shareKey='" + this.cmu + '\'' + ", startTime=" + this.startTime + ", referrer=" + this.cmv + ", extInfo=" + this.extInfo + ", appVersion=" + this.aDD + '}';
    AppMethodBeat.o(146698);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(146700);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.cmp);
    paramParcel.writeString(this.cmq);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.cmt);
    paramParcel.writeString(this.cmu);
    paramParcel.writeParcelable(this.cmv, paramInt);
    paramParcel.writeParcelable(this.cmw, paramInt);
    paramParcel.writeInt(this.cmr);
    byte b;
    if (this.cms)
    {
      b = 1;
      paramParcel.writeByte(b);
      paramParcel.writeString(this.extInfo);
      paramParcel.writeLong(this.startTime);
      paramParcel.writeInt(this.aDD);
      paramParcel.writeInt(this.cmx);
      paramParcel.writeParcelable(this.cmy, paramInt);
      paramParcel.writeString(this.cmz);
      paramParcel.writeInt(this.uin);
      if (!this.cmB) {
        break label188;
      }
    }
    label188:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      OnWXAppResultXPCWrapper.a(this.cmA, paramParcel);
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