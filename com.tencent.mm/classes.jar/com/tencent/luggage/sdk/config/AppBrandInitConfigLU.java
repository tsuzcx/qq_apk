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
  public int aAS;
  protected String cfb;
  public String cfc;
  public int cfd;
  public boolean cfe;
  public String cff;
  public String cfh;
  public final AppBrandLaunchReferrer cfi;
  public final AppBrandWeishiParams cfj;
  public int cfk;
  public WxaAttributes.WxaVersionInfo cfl;
  public a<?> cfm;
  public boolean cfn;
  public transient AppBrandStatObject cfo;
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
    this.cfn = false;
    this.cfi = new AppBrandLaunchReferrer();
    this.cfj = new AppBrandWeishiParams();
    AppMethodBeat.o(169428);
  }
  
  protected AppBrandInitConfigLU(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(146697);
    this.cfn = false;
    this.cfb = paramParcel.readString();
    this.cfc = paramParcel.readString();
    this.username = paramParcel.readString();
    this.cff = paramParcel.readString();
    this.cfh = paramParcel.readString();
    this.cfi = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.cfj = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    this.cfd = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cfe = bool1;
      this.extInfo = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      this.aAS = paramParcel.readInt();
      this.cfk = paramParcel.readInt();
      this.cfl = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      this.uin = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label200;
      }
    }
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cfn = bool1;
      this.cfm = OnWXAppResultXPCWrapper.a(paramParcel);
      AppMethodBeat.o(146697);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean CW()
  {
    AppMethodBeat.i(186868);
    if (bt.isNullOrNil(this.cfl.jfF))
    {
      AppMethodBeat.o(186868);
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.cfl.jfF).optJSONArray("call_plugin_info");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        AppMethodBeat.o(186868);
        return true;
      }
      AppMethodBeat.o(186868);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(186868);
    }
    return false;
  }
  
  public final boolean CX()
  {
    return this.cfn;
  }
  
  public final AppBrandStatObject CY()
  {
    return this.cfo;
  }
  
  public boolean CZ()
  {
    return this.cfd == 4;
  }
  
  public final String Da()
  {
    return this.cfb;
  }
  
  public final JSONObject Db()
  {
    AppMethodBeat.i(146694);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("shareKey", this.cfh);
      localJSONObject.put("shareName", this.cff);
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
  
  public final JSONObject Dc()
  {
    AppMethodBeat.i(146695);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("nickname", this.dfM);
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
  
  public final JSONObject Dd()
  {
    AppMethodBeat.i(146696);
    if ((this.cfi != null) && (2 == this.cfi.jdC) && (TextUtils.isEmpty(this.cfi.appId)))
    {
      AppMethodBeat.o(146696);
      return null;
    }
    JSONObject localJSONObject = this.cfi.aTA();
    AppMethodBeat.o(146696);
    return localJSONObject;
  }
  
  public AppBrandInitConfigLU De()
  {
    AppMethodBeat.i(146699);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.Df();
    AppMethodBeat.o(146699);
    return localAppBrandInitConfigLU;
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(146693);
    this.cfb = ("SessionId@" + hashCode() + "#" + bt.eGO());
    AppMethodBeat.o(146693);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146698);
    String str = "AppBrandInitConfigLU {visitingSessionId='" + this.cfb + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.dfM + '\'' + ", debugType=" + this.iOP + ", orientation='" + this.jbC + '\'' + ", enterPath='" + this.iJb + '\'' + ", shareName='" + this.cff + '\'' + ", shareKey='" + this.cfh + '\'' + ", startTime=" + this.startTime + ", referrer=" + this.cfi + ", extInfo=" + this.extInfo + ", appVersion=" + this.aAS + '}';
    AppMethodBeat.o(146698);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(146700);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.cfb);
    paramParcel.writeString(this.cfc);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.cff);
    paramParcel.writeString(this.cfh);
    paramParcel.writeParcelable(this.cfi, paramInt);
    paramParcel.writeParcelable(this.cfj, paramInt);
    paramParcel.writeInt(this.cfd);
    byte b;
    if (this.cfe)
    {
      b = 1;
      paramParcel.writeByte(b);
      paramParcel.writeString(this.extInfo);
      paramParcel.writeLong(this.startTime);
      paramParcel.writeInt(this.aAS);
      paramParcel.writeInt(this.cfk);
      paramParcel.writeParcelable(this.cfl, paramInt);
      paramParcel.writeInt(this.uin);
      if (!this.cfn) {
        break label180;
      }
    }
    label180:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      OnWXAppResultXPCWrapper.a(this.cfm, paramParcel);
      AppMethodBeat.o(146700);
      return;
      b = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.AppBrandInitConfigLU
 * JD-Core Version:    0.7.0.1
 */