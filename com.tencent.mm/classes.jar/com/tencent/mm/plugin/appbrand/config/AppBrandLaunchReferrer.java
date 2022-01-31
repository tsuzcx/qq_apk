package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class AppBrandLaunchReferrer
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandLaunchReferrer> CREATOR;
  public String appId;
  public String businessType;
  public String cAh;
  public String cJg;
  public int cpG;
  public int hiK;
  public String hiL;
  public String hiM;
  public String hiN;
  public String hiO;
  public String url;
  
  static
  {
    AppMethodBeat.i(86903);
    CREATOR = new AppBrandLaunchReferrer.1();
    AppMethodBeat.o(86903);
  }
  
  public AppBrandLaunchReferrer() {}
  
  private AppBrandLaunchReferrer(Parcel paramParcel)
  {
    AppMethodBeat.i(86902);
    i(paramParcel);
    AppMethodBeat.o(86902);
  }
  
  private void i(Parcel paramParcel)
  {
    AppMethodBeat.i(86898);
    this.hiK = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.cAh = paramParcel.readString();
    this.hiL = paramParcel.readString();
    this.url = paramParcel.readString();
    this.hiM = paramParcel.readString();
    this.cpG = paramParcel.readInt();
    this.businessType = paramParcel.readString();
    this.cJg = paramParcel.readString();
    this.hiN = paramParcel.readString();
    this.hiO = paramParcel.readString();
    AppMethodBeat.o(86898);
  }
  
  public final void a(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    AppMethodBeat.i(86900);
    if (paramAppBrandLaunchReferrer == null)
    {
      AppMethodBeat.o(86900);
      return;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramAppBrandLaunchReferrer.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    i(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(86900);
  }
  
  public final JSONObject ayx()
  {
    AppMethodBeat.i(86901);
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.cAh);
      localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("appId", this.appId);
        localJSONObject2.put("extraData", localJSONObject1);
        if (((this.hiK == 1) || (this.hiK == 3) || (this.hiK == 2)) && (!bo.isNullOrNil(this.hiL))) {
          localJSONObject2.put("privateExtraData", new JSONObject(this.hiL));
        }
        if ((this.hiK == 6) && (!bo.isNullOrNil(this.cJg))) {
          localJSONObject2.put("messageExtraData", new JSONObject(this.cJg));
        }
        if ((this.hiK == 7) && (!bo.isNullOrNil(this.hiN))) {
          localJSONObject2.put("openapiInvokeData", new JSONObject(this.hiN));
        }
        if ((this.hiK == 7) && (!bo.isNullOrNil(this.hiO))) {
          localJSONObject2.put("transitiveData", new JSONObject(this.hiO));
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          String str;
          ab.e("MicroMsg.AppBrandLaunchReferrer", "toJsonObj exception: %s", new Object[] { localException2 });
        }
        AppMethodBeat.o(86901);
      }
      if (localJSONObject2.length() == 0)
      {
        AppMethodBeat.o(86901);
        return null;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        str = this.cAh;
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
    AppMethodBeat.i(86897);
    String str = "AppBrandLaunchReferrer{launchScene=" + this.hiK + ", appId='" + this.appId + '\'' + ", extraData='" + this.cAh + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.hiM + '\'' + ", sourceType='" + this.cpG + '\'' + ", businessType='" + this.businessType + '\'' + '}';
    AppMethodBeat.o(86897);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(86899);
    paramParcel.writeInt(this.hiK);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.cAh);
    paramParcel.writeString(this.hiL);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.hiM);
    paramParcel.writeInt(this.cpG);
    paramParcel.writeString(this.businessType);
    paramParcel.writeString(this.cJg);
    paramParcel.writeString(this.hiN);
    paramParcel.writeString(this.hiO);
    AppMethodBeat.o(86899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer
 * JD-Core Version:    0.7.0.1
 */