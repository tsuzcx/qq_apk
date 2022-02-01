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
  public String hRR;
  public String idf;
  public int qYE;
  public String qYF;
  public String qYG;
  public String qYH;
  public String qYI;
  public String qYJ;
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
    l(paramParcel);
    AppMethodBeat.o(134797);
  }
  
  private void l(Parcel paramParcel)
  {
    AppMethodBeat.i(134793);
    this.qYE = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.hRR = paramParcel.readString();
    this.qYF = paramParcel.readString();
    this.url = paramParcel.readString();
    this.qYG = paramParcel.readString();
    this.sourceType = paramParcel.readInt();
    this.businessType = paramParcel.readString();
    this.idf = paramParcel.readString();
    this.qYH = paramParcel.readString();
    this.qYI = paramParcel.readString();
    this.qYJ = paramParcel.readString();
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
    l(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(134795);
  }
  
  public final JSONObject ckI()
  {
    AppMethodBeat.i(134796);
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.hRR);
      localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("appId", this.appId);
        localJSONObject2.put("extraData", localJSONObject1);
        if (((this.qYE == 1) || (this.qYE == 3) || (this.qYE == 2) || (this.qYE == 10)) && (!Util.isNullOrNil(this.qYF))) {
          localJSONObject2.put("privateExtraData", new JSONObject(this.qYF));
        }
        if ((this.qYE == 6) && (!Util.isNullOrNil(this.idf))) {
          localJSONObject2.put("messageExtraData", new JSONObject(this.idf));
        }
        if ((this.qYE == 7) && (!Util.isNullOrNil(this.qYH))) {
          localJSONObject2.put("openapiInvokeData", new JSONObject(this.qYH));
        }
        if ((this.qYE == 7) && (!Util.isNullOrNil(this.qYI))) {
          localJSONObject2.put("transitiveData", new JSONObject(this.qYI));
        }
        if ((this.qYE == 9) && (!Util.isNullOrNil(this.qYJ))) {
          localJSONObject2.put("gameLiveInfo", new JSONObject(this.qYJ));
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
        str = this.hRR;
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
    String str = "AppBrandLaunchReferrer{launchScene=" + this.qYE + ", appId='" + this.appId + '\'' + ", extraData='" + this.hRR + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.qYG + '\'' + ", sourceType='" + this.sourceType + '\'' + ", businessType='" + this.businessType + '\'' + '}';
    AppMethodBeat.o(134792);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134794);
    paramParcel.writeInt(this.qYE);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hRR);
    paramParcel.writeString(this.qYF);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.qYG);
    paramParcel.writeInt(this.sourceType);
    paramParcel.writeString(this.businessType);
    paramParcel.writeString(this.idf);
    paramParcel.writeString(this.qYH);
    paramParcel.writeString(this.qYI);
    paramParcel.writeString(this.qYJ);
    AppMethodBeat.o(134794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer
 * JD-Core Version:    0.7.0.1
 */