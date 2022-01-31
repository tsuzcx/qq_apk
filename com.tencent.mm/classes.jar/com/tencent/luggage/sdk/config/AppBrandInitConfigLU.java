package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.launching.params.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandInitConfigLU
  extends AppBrandInitConfig
{
  public static final Parcelable.Creator<AppBrandInitConfigLU> CREATOR;
  protected String bCU;
  public int bCV;
  public boolean bCW;
  public boolean bCX;
  public String bCY;
  public String bCZ;
  public final AppBrandWeishiParams bDa;
  public String bDb;
  public int bDc;
  public int bDd;
  public WxaAttributes.WxaVersionInfo bDe;
  public b<?> bDf;
  public boolean bDg;
  public transient AppBrandStatObject bDh;
  public String extInfo;
  public long startTime;
  public int uin;
  public String username;
  
  static
  {
    AppMethodBeat.i(101620);
    CREATOR = new AppBrandInitConfigLU.1();
    AppMethodBeat.o(101620);
  }
  
  public AppBrandInitConfigLU()
  {
    AppMethodBeat.i(101613);
    this.bDg = false;
    this.bDa = new AppBrandWeishiParams();
    AppMethodBeat.o(101613);
  }
  
  protected AppBrandInitConfigLU(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(101614);
    this.bDg = false;
    this.bCU = paramParcel.readString();
    this.username = paramParcel.readString();
    this.bCY = paramParcel.readString();
    this.bCZ = paramParcel.readString();
    this.bDa = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    this.bCV = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.bCW = bool1;
      if (paramParcel.readByte() == 0) {
        break label198;
      }
      bool1 = true;
      label96:
      this.bCX = bool1;
      this.extInfo = paramParcel.readString();
      this.bDb = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      this.bDc = paramParcel.readInt();
      this.bDd = paramParcel.readInt();
      this.bDe = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      this.uin = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label203;
      }
    }
    label198:
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bDg = bool1;
      this.bDf = OnWXAppResultXPCWrapper.b(paramParcel);
      AppMethodBeat.o(101614);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label96;
    }
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(101610);
    this.bCU = ("SessionId@" + hashCode() + "#" + bo.aoy());
    AppMethodBeat.o(101610);
  }
  
  public String toString()
  {
    AppMethodBeat.i(101615);
    String str = "AppBrandInitConfigLU {visitingSessionId='" + this.bCU + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.cqQ + '\'' + ", debugType=" + this.gXd + ", orientation='" + this.hha + '\'' + ", enterPath='" + this.hiw + '\'' + ", shareName='" + this.bCY + '\'' + ", shareKey='" + this.bCZ + '\'' + ", weishiParams=" + this.bDa + ", startTime=" + this.startTime + ", referrer=" + this.hiz + ", extInfo=" + this.extInfo + ", appVersion=" + this.bDc + '}';
    AppMethodBeat.o(101615);
    return str;
  }
  
  public final AppBrandStatObject vX()
  {
    return this.bDh;
  }
  
  public boolean vY()
  {
    return this.bCV == 4;
  }
  
  public final String vZ()
  {
    return this.bCU;
  }
  
  public final JSONObject wa()
  {
    AppMethodBeat.i(101611);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("shareKey", this.bCZ);
      localJSONObject.put("shareName", this.bCY);
      if (localJSONObject.length() == 0)
      {
        AppMethodBeat.o(101611);
        return null;
      }
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(101611);
      return null;
    }
    AppMethodBeat.o(101611);
    return localJSONException;
  }
  
  public final JSONObject wb()
  {
    AppMethodBeat.i(101612);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("nickname", this.cqQ);
      localJSONObject.put("icon", this.iconUrl);
      if (localJSONObject.length() == 0)
      {
        AppMethodBeat.o(101612);
        return null;
      }
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(101612);
      return null;
    }
    AppMethodBeat.o(101612);
    return localJSONException;
  }
  
  public AppBrandInitConfigLU wc()
  {
    AppMethodBeat.i(101616);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.wd();
    AppMethodBeat.o(101616);
    return localAppBrandInitConfigLU;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(101618);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.bCU);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.bCY);
    paramParcel.writeString(this.bCZ);
    paramParcel.writeParcelable(this.bDa, paramInt);
    paramParcel.writeInt(this.bCV);
    byte b;
    if (this.bCW)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.bCX) {
        break label185;
      }
      b = 1;
      label87:
      paramParcel.writeByte(b);
      paramParcel.writeString(this.extInfo);
      paramParcel.writeString(this.bDb);
      paramParcel.writeLong(this.startTime);
      paramParcel.writeInt(this.bDc);
      paramParcel.writeInt(this.bDd);
      paramParcel.writeParcelable(this.bDe, paramInt);
      paramParcel.writeInt(this.uin);
      if (!this.bDg) {
        break label190;
      }
    }
    label185:
    label190:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      OnWXAppResultXPCWrapper.a(this.bDf, paramParcel);
      AppMethodBeat.o(101618);
      return;
      b = 0;
      break;
      b = 0;
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.AppBrandInitConfigLU
 * JD-Core Version:    0.7.0.1
 */