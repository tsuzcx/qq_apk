package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class AppBrandLaunchReferrer
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandLaunchReferrer> CREATOR;
  public String appId;
  public String businessType;
  public String fMh;
  public String fXg;
  public int nYB;
  public String nYC;
  public String nYD;
  public String nYE;
  public String nYF;
  public int sourceType;
  public String url;
  
  static
  {
    AppMethodBeat.i(134798);
    CREATOR = new AppBrandLaunchReferrer.1();
    AppMethodBeat.o(134798);
  }
  
  public AppBrandLaunchReferrer() {}
  
  private AppBrandLaunchReferrer(Parcel paramParcel)
  {
    AppMethodBeat.i(134797);
    j(paramParcel);
    AppMethodBeat.o(134797);
  }
  
  private void j(Parcel paramParcel)
  {
    AppMethodBeat.i(134793);
    this.nYB = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.fMh = paramParcel.readString();
    this.nYC = paramParcel.readString();
    this.url = paramParcel.readString();
    this.nYD = paramParcel.readString();
    this.sourceType = paramParcel.readInt();
    this.businessType = paramParcel.readString();
    this.fXg = paramParcel.readString();
    this.nYE = paramParcel.readString();
    this.nYF = paramParcel.readString();
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
    j(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(134795);
  }
  
  public final JSONObject bLk()
  {
    AppMethodBeat.i(134796);
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.fMh);
      localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("appId", this.appId);
        localJSONObject2.put("extraData", localJSONObject1);
        if (((this.nYB == 1) || (this.nYB == 3) || (this.nYB == 2)) && (!Util.isNullOrNil(this.nYC))) {
          localJSONObject2.put("privateExtraData", new JSONObject(this.nYC));
        }
        if ((this.nYB == 6) && (!Util.isNullOrNil(this.fXg))) {
          localJSONObject2.put("messageExtraData", new JSONObject(this.fXg));
        }
        if ((this.nYB == 7) && (!Util.isNullOrNil(this.nYE))) {
          localJSONObject2.put("openapiInvokeData", new JSONObject(this.nYE));
        }
        if ((this.nYB == 7) && (!Util.isNullOrNil(this.nYF))) {
          localJSONObject2.put("transitiveData", new JSONObject(this.nYF));
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          String str;
          Log.e("MicroMsg.AppBrandLaunchReferrer", "toJsonObj exception: %s", new Object[] { localException2 });
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
        str = this.fMh;
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
    String str = "AppBrandLaunchReferrer{launchScene=" + this.nYB + ", appId='" + this.appId + '\'' + ", extraData='" + this.fMh + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.nYD + '\'' + ", sourceType='" + this.sourceType + '\'' + ", businessType='" + this.businessType + '\'' + '}';
    AppMethodBeat.o(134792);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134794);
    paramParcel.writeInt(this.nYB);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.fMh);
    paramParcel.writeString(this.nYC);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.nYD);
    paramParcel.writeInt(this.sourceType);
    paramParcel.writeString(this.businessType);
    paramParcel.writeString(this.fXg);
    paramParcel.writeString(this.nYE);
    paramParcel.writeString(this.nYF);
    AppMethodBeat.o(134794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer
 * JD-Core Version:    0.7.0.1
 */