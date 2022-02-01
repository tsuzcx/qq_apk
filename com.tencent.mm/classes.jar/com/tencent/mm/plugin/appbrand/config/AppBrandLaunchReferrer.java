package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class AppBrandLaunchReferrer
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandLaunchReferrer> CREATOR;
  public String appId;
  public String businessType;
  public String dAU;
  public String dLl;
  public int kbg;
  public String kbh;
  public String kbi;
  public String kbj;
  public String kbk;
  public int sourceType;
  public String url;
  
  static
  {
    AppMethodBeat.i(134798);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134798);
  }
  
  public AppBrandLaunchReferrer() {}
  
  private AppBrandLaunchReferrer(Parcel paramParcel)
  {
    AppMethodBeat.i(134797);
    i(paramParcel);
    AppMethodBeat.o(134797);
  }
  
  private void i(Parcel paramParcel)
  {
    AppMethodBeat.i(134793);
    this.kbg = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.dAU = paramParcel.readString();
    this.kbh = paramParcel.readString();
    this.url = paramParcel.readString();
    this.kbi = paramParcel.readString();
    this.sourceType = paramParcel.readInt();
    this.businessType = paramParcel.readString();
    this.dLl = paramParcel.readString();
    this.kbj = paramParcel.readString();
    this.kbk = paramParcel.readString();
    AppMethodBeat.o(134793);
  }
  
  public final void a(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    AppMethodBeat.i(134795);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(134795);
      return;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramAppBrandLaunchReferrer.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    i(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(134795);
  }
  
  public final JSONObject beE()
  {
    AppMethodBeat.i(134796);
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.dAU);
      localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("appId", this.appId);
        localJSONObject2.put("extraData", localJSONObject1);
        if (((this.kbg == 1) || (this.kbg == 3) || (this.kbg == 2)) && (!bu.isNullOrNil(this.kbh))) {
          localJSONObject2.put("privateExtraData", new JSONObject(this.kbh));
        }
        if ((this.kbg == 6) && (!bu.isNullOrNil(this.dLl))) {
          localJSONObject2.put("messageExtraData", new JSONObject(this.dLl));
        }
        if ((this.kbg == 7) && (!bu.isNullOrNil(this.kbj))) {
          localJSONObject2.put("openapiInvokeData", new JSONObject(this.kbj));
        }
        if ((this.kbg == 7) && (!bu.isNullOrNil(this.kbk))) {
          localJSONObject2.put("transitiveData", new JSONObject(this.kbk));
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          String str;
          ae.e("MicroMsg.AppBrandLaunchReferrer", "toJsonObj exception: %s", new Object[] { localException2 });
        }
        AppMethodBeat.o(134796);
      }
      if (localJSONObject2.length() == 0)
      {
        AppMethodBeat.o(134796);
        return null;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        str = this.dAU;
      }
    }
    return localJSONObject2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(134792);
    String str = "AppBrandLaunchReferrer{launchScene=" + this.kbg + ", appId='" + this.appId + '\'' + ", extraData='" + this.dAU + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.kbi + '\'' + ", sourceType='" + this.sourceType + '\'' + ", businessType='" + this.businessType + '\'' + '}';
    AppMethodBeat.o(134792);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134794);
    paramParcel.writeInt(this.kbg);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dAU);
    paramParcel.writeString(this.kbh);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.kbi);
    paramParcel.writeInt(this.sourceType);
    paramParcel.writeString(this.businessType);
    paramParcel.writeString(this.dLl);
    paramParcel.writeString(this.kbj);
    paramParcel.writeString(this.kbk);
    AppMethodBeat.o(134794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer
 * JD-Core Version:    0.7.0.1
 */