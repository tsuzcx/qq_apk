package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandWeishiParams
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandWeishiParams> CREATOR;
  public String appId;
  public String appName;
  public int hBe;
  public String kbF;
  public String kbG;
  public String kbH;
  public String thumbUrl;
  
  static
  {
    AppMethodBeat.i(134805);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134805);
  }
  
  public AppBrandWeishiParams() {}
  
  public AppBrandWeishiParams(Parcel paramParcel)
  {
    AppMethodBeat.i(134801);
    i(paramParcel);
    AppMethodBeat.o(134801);
  }
  
  private void i(Parcel paramParcel)
  {
    AppMethodBeat.i(134802);
    this.hBe = paramParcel.readInt();
    this.thumbUrl = paramParcel.readString();
    this.kbF = paramParcel.readString();
    this.kbG = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.appName = paramParcel.readString();
    this.kbH = paramParcel.readString();
    AppMethodBeat.o(134802);
  }
  
  public final void a(AppBrandWeishiParams paramAppBrandWeishiParams)
  {
    AppMethodBeat.i(134803);
    if (paramAppBrandWeishiParams == null)
    {
      AppMethodBeat.o(134803);
      return;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramAppBrandWeishiParams.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    i(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(134803);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(134800);
    String str = "AppBrandWeishiParams{fromOpenSdk=" + this.hBe + ", thumbUrl='" + this.thumbUrl + '\'' + ", thumbFullPath='" + this.kbF + '\'' + ", msgImgPath='" + this.kbG + '\'' + ", appId='" + this.appId + '\'' + ", appName='" + this.appName + '\'' + ", sourceUserName='" + this.kbH + '\'' + '}';
    AppMethodBeat.o(134800);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134804);
    paramParcel.writeInt(this.hBe);
    paramParcel.writeString(this.thumbUrl);
    paramParcel.writeString(this.kbF);
    paramParcel.writeString(this.kbG);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.kbH);
    AppMethodBeat.o(134804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams
 * JD-Core Version:    0.7.0.1
 */