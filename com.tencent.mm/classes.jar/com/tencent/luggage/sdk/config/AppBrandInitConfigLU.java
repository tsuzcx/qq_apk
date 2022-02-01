package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
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
  public int appVersion;
  public String cwP;
  public String cwQ;
  public int cwR;
  public boolean cwS;
  public String cwT;
  public String cwU;
  public final AppBrandLaunchReferrer cwV;
  public final AppBrandWeishiParams cwW;
  public int cwX;
  public WxaAttributes.WxaVersionInfo cwY;
  public String cwZ;
  public int cxa;
  public boolean cxb;
  public a<?> cxc;
  public boolean cxd;
  public b cxe;
  public transient AppBrandStatObject cxf;
  public String extInfo;
  public long startTime;
  public int uin;
  public String username;
  
  static
  {
    AppMethodBeat.i(146703);
    CREATOR = new AppBrandInitConfigLU.1();
    AppMethodBeat.o(146703);
  }
  
  public AppBrandInitConfigLU()
  {
    AppMethodBeat.i(169428);
    this.cxd = false;
    this.cxe = b.cBe;
    this.cwV = new AppBrandLaunchReferrer();
    this.cwW = new AppBrandWeishiParams();
    AppMethodBeat.o(169428);
  }
  
  protected AppBrandInitConfigLU(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(146697);
    this.cxd = false;
    this.cxe = b.cBe;
    this.cwP = paramParcel.readString();
    this.cwQ = paramParcel.readString();
    this.username = paramParcel.readString();
    this.cwT = paramParcel.readString();
    this.cwU = paramParcel.readString();
    this.cwV = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.cwW = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    this.cwR = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cwS = bool1;
      this.extInfo = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      this.appVersion = paramParcel.readInt();
      this.cwX = paramParcel.readInt();
      this.cwY = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      this.cwZ = paramParcel.readString();
      this.uin = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label245;
      }
      bool1 = true;
      label191:
      this.cxd = bool1;
      this.cxc = OnWXAppResultXPCWrapper.a(paramParcel);
      this.cxe = b.b(paramParcel);
      this.cxa = paramParcel.readInt();
      if (paramParcel.readInt() <= 0) {
        break label250;
      }
    }
    label245:
    label250:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cxb = bool1;
      AppMethodBeat.o(146697);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label191;
    }
  }
  
  public final JSONObject QA()
  {
    AppMethodBeat.i(146696);
    if ((this.cwV != null) && (2 == this.cwV.nYB) && (TextUtils.isEmpty(this.cwV.appId)))
    {
      AppMethodBeat.o(146696);
      return null;
    }
    JSONObject localJSONObject = this.cwV.bLk();
    AppMethodBeat.o(146696);
    return localJSONObject;
  }
  
  public AppBrandInitConfigLU QB()
  {
    AppMethodBeat.i(146699);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.QC();
    AppMethodBeat.o(146699);
    return localAppBrandInitConfigLU;
  }
  
  public final boolean Qs()
  {
    AppMethodBeat.i(247886);
    if (Util.isNullOrNil(this.cwY.obF))
    {
      AppMethodBeat.o(247886);
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.cwY.obF).optJSONArray("call_plugin_info");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        AppMethodBeat.o(247886);
        return true;
      }
      AppMethodBeat.o(247886);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(247886);
    }
    return false;
  }
  
  public final boolean Qt()
  {
    return this.cxd;
  }
  
  public final AppBrandStatObject Qu()
  {
    return this.cxf;
  }
  
  public boolean Qv()
  {
    return this.cwR == 4;
  }
  
  public final String Qw()
  {
    return this.cwP;
  }
  
  public final String Qx()
  {
    return this.cwQ;
  }
  
  public final JSONObject Qy()
  {
    AppMethodBeat.i(146694);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("shareKey", this.cwU);
      localJSONObject.put("shareName", this.cwT);
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
  
  public final JSONObject Qz()
  {
    AppMethodBeat.i(146695);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("nickname", this.fzM);
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
  
  public final void a(AppBrandStatObject paramAppBrandStatObject)
  {
    this.cxf = paramAppBrandStatObject;
  }
  
  public final void dV(String paramString)
  {
    AppMethodBeat.i(247887);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.AppBrandInitConfigLU", "resetSession(%s) %s", new Object[] { paramString, android.util.Log.getStackTraceString(new Throwable()) });
    this.cwP = paramString;
    AppMethodBeat.o(247887);
  }
  
  public final void dW(String paramString)
  {
    AppMethodBeat.i(247888);
    Assert.assertFalse(TextUtils.isEmpty(paramString));
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.AppBrandInitConfigLU", "resetInstanceId(%s) %s", new Object[] { paramString, android.util.Log.getStackTraceString(new Throwable()) });
    this.cwQ = paramString;
    AppMethodBeat.o(247888);
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(146693);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.AppBrandInitConfigLU", "resetSession() %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    d locald2 = d.a.cxV;
    d locald1 = locald2;
    if (locald2 == null) {
      locald1 = d.cxU;
    }
    this.cwP = locald1.QE();
    AppMethodBeat.o(146693);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146698);
    String str = "AppBrandInitConfigLU {visitingSessionId='" + this.cwP + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.fzM + '\'' + ", debugType=" + this.cBI + ", orientation='" + this.cCi + '\'' + ", enterPath='" + this.nBq + '\'' + ", shareName='" + this.cwT + '\'' + ", shareKey='" + this.cwU + '\'' + ", startTime=" + this.startTime + ", referrer=" + this.cwV + ", extInfo=" + this.extInfo + ", appVersion=" + this.appVersion + '}';
    AppMethodBeat.o(146698);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(146700);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.cwP);
    paramParcel.writeString(this.cwQ);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.cwT);
    paramParcel.writeString(this.cwU);
    paramParcel.writeParcelable(this.cwV, paramInt);
    paramParcel.writeParcelable(this.cwW, paramInt);
    paramParcel.writeInt(this.cwR);
    byte b;
    if (this.cwS)
    {
      b = 1;
      paramParcel.writeByte(b);
      paramParcel.writeString(this.extInfo);
      paramParcel.writeLong(this.startTime);
      paramParcel.writeInt(this.appVersion);
      paramParcel.writeInt(this.cwX);
      paramParcel.writeParcelable(this.cwY, paramInt);
      paramParcel.writeString(this.cwZ);
      paramParcel.writeInt(this.uin);
      if (!this.cxd) {
        break label218;
      }
      paramInt = 1;
      label161:
      paramParcel.writeByte((byte)paramInt);
      OnWXAppResultXPCWrapper.a(this.cxc, paramParcel);
      b.a(this.cxe, paramParcel);
      paramParcel.writeInt(this.cxa);
      if (!this.cxb) {
        break label223;
      }
    }
    label218:
    label223:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(146700);
      return;
      b = 0;
      break;
      paramInt = 0;
      break label161;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.AppBrandInitConfigLU
 * JD-Core Version:    0.7.0.1
 */