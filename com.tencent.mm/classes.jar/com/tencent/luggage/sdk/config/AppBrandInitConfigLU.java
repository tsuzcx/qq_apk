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
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandInitConfigLU
  extends AppBrandInitConfig
{
  public static final Parcelable.Creator<AppBrandInitConfigLU> CREATOR;
  public int aBM;
  protected String cbY;
  public String cbZ;
  public int cca;
  public boolean ccb;
  public String ccc;
  public String ccd;
  public final AppBrandLaunchReferrer cce;
  public final AppBrandWeishiParams ccf;
  public int ccg;
  public WxaAttributes.WxaVersionInfo cch;
  public String cci;
  public a<?> ccj;
  public boolean cck;
  public transient AppBrandStatObject ccl;
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
    this.cck = false;
    this.cce = new AppBrandLaunchReferrer();
    this.ccf = new AppBrandWeishiParams();
    AppMethodBeat.o(169428);
  }
  
  protected AppBrandInitConfigLU(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(146697);
    this.cck = false;
    this.cbY = paramParcel.readString();
    this.cbZ = paramParcel.readString();
    this.username = paramParcel.readString();
    this.ccc = paramParcel.readString();
    this.ccd = paramParcel.readString();
    this.cce = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.ccf = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    this.cca = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.ccb = bool1;
      this.extInfo = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      this.aBM = paramParcel.readInt();
      this.ccg = paramParcel.readInt();
      this.cch = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      this.cci = paramParcel.readString();
      this.uin = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label208;
      }
    }
    label208:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cck = bool1;
      this.ccj = OnWXAppResultXPCWrapper.a(paramParcel);
      AppMethodBeat.o(146697);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean CA()
  {
    return this.cck;
  }
  
  public final AppBrandStatObject CB()
  {
    return this.ccl;
  }
  
  public boolean CC()
  {
    return this.cca == 4;
  }
  
  public final String CD()
  {
    return this.cbY;
  }
  
  public final JSONObject CE()
  {
    AppMethodBeat.i(146694);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("shareKey", this.ccd);
      localJSONObject.put("shareName", this.ccc);
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
  
  public final JSONObject CF()
  {
    AppMethodBeat.i(146695);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("nickname", this.ddh);
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
  
  public final JSONObject CG()
  {
    AppMethodBeat.i(146696);
    if ((this.cce != null) && (2 == this.cce.jDQ) && (TextUtils.isEmpty(this.cce.appId)))
    {
      AppMethodBeat.o(146696);
      return null;
    }
    JSONObject localJSONObject = this.cce.bay();
    AppMethodBeat.o(146696);
    return localJSONObject;
  }
  
  public AppBrandInitConfigLU CH()
  {
    AppMethodBeat.i(146699);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.CI();
    AppMethodBeat.o(146699);
    return localAppBrandInitConfigLU;
  }
  
  public final boolean Cz()
  {
    AppMethodBeat.i(206116);
    if (bs.isNullOrNil(this.cch.jFU))
    {
      AppMethodBeat.o(206116);
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.cch.jFU).optJSONArray("call_plugin_info");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        AppMethodBeat.o(206116);
        return true;
      }
      AppMethodBeat.o(206116);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(206116);
    }
    return false;
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(146693);
    this.cbY = ("SessionId@" + hashCode() + "#" + bs.eWj());
    AppMethodBeat.o(146693);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146698);
    String str = "AppBrandInitConfigLU {visitingSessionId='" + this.cbY + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.ddh + '\'' + ", debugType=" + this.joY + ", orientation='" + this.jBP + '\'' + ", enterPath='" + this.jjf + '\'' + ", shareName='" + this.ccc + '\'' + ", shareKey='" + this.ccd + '\'' + ", startTime=" + this.startTime + ", referrer=" + this.cce + ", extInfo=" + this.extInfo + ", appVersion=" + this.aBM + '}';
    AppMethodBeat.o(146698);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(146700);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.cbY);
    paramParcel.writeString(this.cbZ);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.ccc);
    paramParcel.writeString(this.ccd);
    paramParcel.writeParcelable(this.cce, paramInt);
    paramParcel.writeParcelable(this.ccf, paramInt);
    paramParcel.writeInt(this.cca);
    byte b;
    if (this.ccb)
    {
      b = 1;
      paramParcel.writeByte(b);
      paramParcel.writeString(this.extInfo);
      paramParcel.writeLong(this.startTime);
      paramParcel.writeInt(this.aBM);
      paramParcel.writeInt(this.ccg);
      paramParcel.writeParcelable(this.cch, paramInt);
      paramParcel.writeString(this.cci);
      paramParcel.writeInt(this.uin);
      if (!this.cck) {
        break label188;
      }
    }
    label188:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      OnWXAppResultXPCWrapper.a(this.ccj, paramParcel);
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