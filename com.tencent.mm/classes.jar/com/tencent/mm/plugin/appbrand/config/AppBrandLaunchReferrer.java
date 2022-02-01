package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class AppBrandLaunchReferrer
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandLaunchReferrer> CREATOR;
  public String appId;
  public String businessType;
  public String dJW;
  public String dzP;
  public int jXR;
  public String jXS;
  public String jXT;
  public String jXU;
  public String jXV;
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
    this.jXR = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.dzP = paramParcel.readString();
    this.jXS = paramParcel.readString();
    this.url = paramParcel.readString();
    this.jXT = paramParcel.readString();
    this.sourceType = paramParcel.readInt();
    this.businessType = paramParcel.readString();
    this.dJW = paramParcel.readString();
    this.jXU = paramParcel.readString();
    this.jXV = paramParcel.readString();
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
  
  public final JSONObject bdY()
  {
    AppMethodBeat.i(134796);
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.dzP);
      localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("appId", this.appId);
        localJSONObject2.put("extraData", localJSONObject1);
        if (((this.jXR == 1) || (this.jXR == 3) || (this.jXR == 2)) && (!bt.isNullOrNil(this.jXS))) {
          localJSONObject2.put("privateExtraData", new JSONObject(this.jXS));
        }
        if ((this.jXR == 6) && (!bt.isNullOrNil(this.dJW))) {
          localJSONObject2.put("messageExtraData", new JSONObject(this.dJW));
        }
        if ((this.jXR == 7) && (!bt.isNullOrNil(this.jXU))) {
          localJSONObject2.put("openapiInvokeData", new JSONObject(this.jXU));
        }
        if ((this.jXR == 7) && (!bt.isNullOrNil(this.jXV))) {
          localJSONObject2.put("transitiveData", new JSONObject(this.jXV));
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          String str;
          ad.e("MicroMsg.AppBrandLaunchReferrer", "toJsonObj exception: %s", new Object[] { localException2 });
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
        str = this.dzP;
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
    String str = "AppBrandLaunchReferrer{launchScene=" + this.jXR + ", appId='" + this.appId + '\'' + ", extraData='" + this.dzP + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.jXT + '\'' + ", sourceType='" + this.sourceType + '\'' + ", businessType='" + this.businessType + '\'' + '}';
    AppMethodBeat.o(134792);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134794);
    paramParcel.writeInt(this.jXR);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dzP);
    paramParcel.writeString(this.jXS);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.jXT);
    paramParcel.writeInt(this.sourceType);
    paramParcel.writeString(this.businessType);
    paramParcel.writeString(this.dJW);
    paramParcel.writeString(this.jXU);
    paramParcel.writeString(this.jXV);
    AppMethodBeat.o(134794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer
 * JD-Core Version:    0.7.0.1
 */