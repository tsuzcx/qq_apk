package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class AppBrandLaunchReferrer
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandLaunchReferrer> CREATOR;
  public String appId;
  public String businessType;
  public String dob;
  public String dxK;
  public int jDQ;
  public String jDR;
  public String jDS;
  public String jDT;
  public String jDU;
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
    this.jDQ = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.dob = paramParcel.readString();
    this.jDR = paramParcel.readString();
    this.url = paramParcel.readString();
    this.jDS = paramParcel.readString();
    this.sourceType = paramParcel.readInt();
    this.businessType = paramParcel.readString();
    this.dxK = paramParcel.readString();
    this.jDT = paramParcel.readString();
    this.jDU = paramParcel.readString();
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
  
  public final JSONObject bay()
  {
    AppMethodBeat.i(134796);
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.dob);
      localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("appId", this.appId);
        localJSONObject2.put("extraData", localJSONObject1);
        if (((this.jDQ == 1) || (this.jDQ == 3) || (this.jDQ == 2)) && (!bs.isNullOrNil(this.jDR))) {
          localJSONObject2.put("privateExtraData", new JSONObject(this.jDR));
        }
        if ((this.jDQ == 6) && (!bs.isNullOrNil(this.dxK))) {
          localJSONObject2.put("messageExtraData", new JSONObject(this.dxK));
        }
        if ((this.jDQ == 7) && (!bs.isNullOrNil(this.jDT))) {
          localJSONObject2.put("openapiInvokeData", new JSONObject(this.jDT));
        }
        if ((this.jDQ == 7) && (!bs.isNullOrNil(this.jDU))) {
          localJSONObject2.put("transitiveData", new JSONObject(this.jDU));
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          String str;
          ac.e("MicroMsg.AppBrandLaunchReferrer", "toJsonObj exception: %s", new Object[] { localException2 });
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
        str = this.dob;
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
    String str = "AppBrandLaunchReferrer{launchScene=" + this.jDQ + ", appId='" + this.appId + '\'' + ", extraData='" + this.dob + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.jDS + '\'' + ", sourceType='" + this.sourceType + '\'' + ", businessType='" + this.businessType + '\'' + '}';
    AppMethodBeat.o(134792);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134794);
    paramParcel.writeInt(this.jDQ);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dob);
    paramParcel.writeString(this.jDR);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.jDS);
    paramParcel.writeInt(this.sourceType);
    paramParcel.writeString(this.businessType);
    paramParcel.writeString(this.dxK);
    paramParcel.writeString(this.jDT);
    paramParcel.writeString(this.jDU);
    AppMethodBeat.o(134794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer
 * JD-Core Version:    0.7.0.1
 */