package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class AppBrandLaunchReferrer
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandLaunchReferrer> CREATOR = new AppBrandLaunchReferrer.1();
  public String appId;
  public int bIl;
  public String caG;
  public int fPF;
  public String fPG;
  public String fPH;
  public String fPI;
  public String fPJ;
  public String fPK;
  public String url;
  
  public AppBrandLaunchReferrer() {}
  
  private AppBrandLaunchReferrer(Parcel paramParcel)
  {
    g(paramParcel);
  }
  
  private void g(Parcel paramParcel)
  {
    this.fPF = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.fPG = paramParcel.readString();
    this.fPH = paramParcel.readString();
    this.url = paramParcel.readString();
    this.fPI = paramParcel.readString();
    this.bIl = paramParcel.readInt();
    this.caG = paramParcel.readString();
    this.fPJ = paramParcel.readString();
    this.fPK = paramParcel.readString();
  }
  
  public final void a(AppBrandLaunchReferrer paramAppBrandLaunchReferrer)
  {
    if (paramAppBrandLaunchReferrer == null) {
      return;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramAppBrandLaunchReferrer.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    g(localParcel);
    localParcel.recycle();
  }
  
  public final JSONObject aei()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.fPG);
      localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("appId", this.appId);
        localJSONObject2.put("extraData", localJSONObject1);
        if (((this.fPF == 1) || (this.fPF == 3) || (this.fPF == 2)) && (!bk.bl(this.fPH))) {
          localJSONObject2.put("privateExtraData", new JSONObject(this.fPH));
        }
        if ((this.fPF == 6) && (!bk.bl(this.caG))) {
          localJSONObject2.put("messageExtraData", new JSONObject(this.caG));
        }
        if ((this.fPF == 7) && (!bk.bl(this.fPJ))) {
          localJSONObject2.put("openapiInvokeData", new JSONObject(this.fPJ));
        }
        if ((this.fPF == 7) && (!bk.bl(this.fPK))) {
          localJSONObject2.put("transitiveData", new JSONObject(this.fPK));
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          String str;
          y.e("MicroMsg.AppBrandLaunchReferrer", "toJsonObj exception: %s", new Object[] { localException2 });
        }
      }
      if (localJSONObject2.length() == 0) {
        return null;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        str = this.fPG;
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
    return "AppBrandLaunchReferrer{launchScene=" + this.fPF + ", appId='" + this.appId + '\'' + ", extraData='" + this.fPG + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.fPI + '\'' + ", sourceType='" + this.bIl + '\'' + '}';
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.fPF);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.fPG);
    paramParcel.writeString(this.fPH);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.fPI);
    paramParcel.writeInt(this.bIl);
    paramParcel.writeString(this.caG);
    paramParcel.writeString(this.fPJ);
    paramParcel.writeString(this.fPK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer
 * JD-Core Version:    0.7.0.1
 */