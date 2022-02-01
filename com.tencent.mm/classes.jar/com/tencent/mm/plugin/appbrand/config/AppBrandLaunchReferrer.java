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
  public String dSJ;
  public String eda;
  public int leo;
  public String lep;
  public String leq;
  public String ler;
  public String les;
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
    j(paramParcel);
    AppMethodBeat.o(134797);
  }
  
  private void j(Parcel paramParcel)
  {
    AppMethodBeat.i(134793);
    this.leo = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.dSJ = paramParcel.readString();
    this.lep = paramParcel.readString();
    this.url = paramParcel.readString();
    this.leq = paramParcel.readString();
    this.sourceType = paramParcel.readInt();
    this.businessType = paramParcel.readString();
    this.eda = paramParcel.readString();
    this.ler = paramParcel.readString();
    this.les = paramParcel.readString();
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
  
  public final JSONObject bzV()
  {
    AppMethodBeat.i(134796);
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.dSJ);
      localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("appId", this.appId);
        localJSONObject2.put("extraData", localJSONObject1);
        if (((this.leo == 1) || (this.leo == 3) || (this.leo == 2)) && (!Util.isNullOrNil(this.lep))) {
          localJSONObject2.put("privateExtraData", new JSONObject(this.lep));
        }
        if ((this.leo == 6) && (!Util.isNullOrNil(this.eda))) {
          localJSONObject2.put("messageExtraData", new JSONObject(this.eda));
        }
        if ((this.leo == 7) && (!Util.isNullOrNil(this.ler))) {
          localJSONObject2.put("openapiInvokeData", new JSONObject(this.ler));
        }
        if ((this.leo == 7) && (!Util.isNullOrNil(this.les))) {
          localJSONObject2.put("transitiveData", new JSONObject(this.les));
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
        str = this.dSJ;
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
    String str = "AppBrandLaunchReferrer{launchScene=" + this.leo + ", appId='" + this.appId + '\'' + ", extraData='" + this.dSJ + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.leq + '\'' + ", sourceType='" + this.sourceType + '\'' + ", businessType='" + this.businessType + '\'' + '}';
    AppMethodBeat.o(134792);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134794);
    paramParcel.writeInt(this.leo);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dSJ);
    paramParcel.writeString(this.lep);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.leq);
    paramParcel.writeInt(this.sourceType);
    paramParcel.writeString(this.businessType);
    paramParcel.writeString(this.eda);
    paramParcel.writeString(this.ler);
    paramParcel.writeString(this.les);
    AppMethodBeat.o(134794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer
 * JD-Core Version:    0.7.0.1
 */