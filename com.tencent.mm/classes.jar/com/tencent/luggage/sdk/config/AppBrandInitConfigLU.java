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
  public transient AppBrandStatObject cyA;
  public String cym;
  public String cyn;
  public int cyo;
  public boolean cyp;
  public String cyq;
  public String cyr;
  public final AppBrandLaunchReferrer cys;
  public final AppBrandWeishiParams cyt;
  public int cyu;
  public WxaAttributes.WxaVersionInfo cyv;
  public String cyw;
  public a<?> cyx;
  public boolean cyy;
  public b cyz;
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
    this.cyy = false;
    this.cyz = b.cBB;
    this.cys = new AppBrandLaunchReferrer();
    this.cyt = new AppBrandWeishiParams();
    AppMethodBeat.o(169428);
  }
  
  protected AppBrandInitConfigLU(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(146697);
    this.cyy = false;
    this.cyz = b.cBB;
    this.cym = paramParcel.readString();
    this.cyn = paramParcel.readString();
    this.username = paramParcel.readString();
    this.cyq = paramParcel.readString();
    this.cyr = paramParcel.readString();
    this.cys = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.cyt = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    this.cyo = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cyp = bool1;
      this.extInfo = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      this.appVersion = paramParcel.readInt();
      this.cyu = paramParcel.readInt();
      this.cyv = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      this.cyw = paramParcel.readString();
      this.uin = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label223;
      }
    }
    label223:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cyy = bool1;
      this.cyx = OnWXAppResultXPCWrapper.a(paramParcel);
      this.cyz = b.b(paramParcel);
      AppMethodBeat.o(146697);
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean NA()
  {
    return this.cyo == 4;
  }
  
  public final String NB()
  {
    return this.cym;
  }
  
  public final String NC()
  {
    return this.cyn;
  }
  
  public final JSONObject ND()
  {
    AppMethodBeat.i(146694);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("shareKey", this.cyr);
      localJSONObject.put("shareName", this.cyq);
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
  
  public final JSONObject NE()
  {
    AppMethodBeat.i(146695);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("nickname", this.brandName);
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
  
  public final JSONObject NF()
  {
    AppMethodBeat.i(146696);
    if ((this.cys != null) && (2 == this.cys.leo) && (TextUtils.isEmpty(this.cys.appId)))
    {
      AppMethodBeat.o(146696);
      return null;
    }
    JSONObject localJSONObject = this.cys.bzV();
    AppMethodBeat.o(146696);
    return localJSONObject;
  }
  
  public AppBrandInitConfigLU NG()
  {
    AppMethodBeat.i(146699);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.NH();
    AppMethodBeat.o(146699);
    return localAppBrandInitConfigLU;
  }
  
  public final boolean Nx()
  {
    AppMethodBeat.i(229825);
    if (Util.isNullOrNil(this.cyv.lgZ))
    {
      AppMethodBeat.o(229825);
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.cyv.lgZ).optJSONArray("call_plugin_info");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        AppMethodBeat.o(229825);
        return true;
      }
      AppMethodBeat.o(229825);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(229825);
    }
    return false;
  }
  
  public final boolean Ny()
  {
    return this.cyy;
  }
  
  public final AppBrandStatObject Nz()
  {
    return this.cyA;
  }
  
  public final void a(AppBrandStatObject paramAppBrandStatObject)
  {
    this.cyA = paramAppBrandStatObject;
  }
  
  public final void dB(String paramString)
  {
    AppMethodBeat.i(229826);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.AppBrandInitConfigLU", "resetSession(%s) %s", new Object[] { paramString, android.util.Log.getStackTraceString(new Throwable()) });
    this.cym = paramString;
    AppMethodBeat.o(229826);
  }
  
  public final void dC(String paramString)
  {
    AppMethodBeat.i(229827);
    Assert.assertFalse(TextUtils.isEmpty(paramString));
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.AppBrandInitConfigLU", "resetInstanceId(%s) %s", new Object[] { paramString, android.util.Log.getStackTraceString(new Throwable()) });
    this.cyn = paramString;
    AppMethodBeat.o(229827);
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(146693);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.AppBrandInitConfigLU", "resetSession() %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    d locald2 = d.a.czj;
    d locald1 = locald2;
    if (locald2 == null) {
      locald1 = d.czi;
    }
    this.cym = locald1.NJ();
    AppMethodBeat.o(146693);
  }
  
  public String toString()
  {
    AppMethodBeat.i(146698);
    String str = "AppBrandInitConfigLU {visitingSessionId='" + this.cym + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.brandName + '\'' + ", debugType=" + this.eix + ", orientation='" + this.cBG + '\'' + ", enterPath='" + this.kHw + '\'' + ", shareName='" + this.cyq + '\'' + ", shareKey='" + this.cyr + '\'' + ", startTime=" + this.startTime + ", referrer=" + this.cys + ", extInfo=" + this.extInfo + ", appVersion=" + this.appVersion + '}';
    AppMethodBeat.o(146698);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(146700);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.cym);
    paramParcel.writeString(this.cyn);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.cyq);
    paramParcel.writeString(this.cyr);
    paramParcel.writeParcelable(this.cys, paramInt);
    paramParcel.writeParcelable(this.cyt, paramInt);
    paramParcel.writeInt(this.cyo);
    byte b;
    if (this.cyp)
    {
      b = 1;
      paramParcel.writeByte(b);
      paramParcel.writeString(this.extInfo);
      paramParcel.writeLong(this.startTime);
      paramParcel.writeInt(this.appVersion);
      paramParcel.writeInt(this.cyu);
      paramParcel.writeParcelable(this.cyv, paramInt);
      paramParcel.writeString(this.cyw);
      paramParcel.writeInt(this.uin);
      if (!this.cyy) {
        break label196;
      }
    }
    label196:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      OnWXAppResultXPCWrapper.a(this.cyx, paramParcel);
      b.a(this.cyz, paramParcel);
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