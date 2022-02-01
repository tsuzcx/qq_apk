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
  public String dqq;
  public String dzY;
  public int jdC;
  public String jdD;
  public String jdE;
  public String jdF;
  public String jdG;
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
    this.jdC = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.dqq = paramParcel.readString();
    this.jdD = paramParcel.readString();
    this.url = paramParcel.readString();
    this.jdE = paramParcel.readString();
    this.sourceType = paramParcel.readInt();
    this.businessType = paramParcel.readString();
    this.dzY = paramParcel.readString();
    this.jdF = paramParcel.readString();
    this.jdG = paramParcel.readString();
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
  
  public final JSONObject aTA()
  {
    AppMethodBeat.i(134796);
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.dqq);
      localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("appId", this.appId);
        localJSONObject2.put("extraData", localJSONObject1);
        if (((this.jdC == 1) || (this.jdC == 3) || (this.jdC == 2)) && (!bt.isNullOrNil(this.jdD))) {
          localJSONObject2.put("privateExtraData", new JSONObject(this.jdD));
        }
        if ((this.jdC == 6) && (!bt.isNullOrNil(this.dzY))) {
          localJSONObject2.put("messageExtraData", new JSONObject(this.dzY));
        }
        if ((this.jdC == 7) && (!bt.isNullOrNil(this.jdF))) {
          localJSONObject2.put("openapiInvokeData", new JSONObject(this.jdF));
        }
        if ((this.jdC == 7) && (!bt.isNullOrNil(this.jdG))) {
          localJSONObject2.put("transitiveData", new JSONObject(this.jdG));
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
        str = this.dqq;
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
    String str = "AppBrandLaunchReferrer{launchScene=" + this.jdC + ", appId='" + this.appId + '\'' + ", extraData='" + this.dqq + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.jdE + '\'' + ", sourceType='" + this.sourceType + '\'' + ", businessType='" + this.businessType + '\'' + '}';
    AppMethodBeat.o(134792);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134794);
    paramParcel.writeInt(this.jdC);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dqq);
    paramParcel.writeString(this.jdD);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.jdE);
    paramParcel.writeInt(this.sourceType);
    paramParcel.writeString(this.businessType);
    paramParcel.writeString(this.dzY);
    paramParcel.writeString(this.jdF);
    paramParcel.writeString(this.jdG);
    AppMethodBeat.o(134794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer
 * JD-Core Version:    0.7.0.1
 */