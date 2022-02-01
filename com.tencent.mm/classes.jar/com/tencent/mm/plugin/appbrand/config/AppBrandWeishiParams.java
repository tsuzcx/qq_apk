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
  public int nPf;
  public String qZi;
  public String qZj;
  public String sourceUserName;
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
    l(paramParcel);
    AppMethodBeat.o(134801);
  }
  
  private void l(Parcel paramParcel)
  {
    AppMethodBeat.i(134802);
    this.nPf = paramParcel.readInt();
    this.thumbUrl = paramParcel.readString();
    this.qZi = paramParcel.readString();
    this.qZj = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.appName = paramParcel.readString();
    this.sourceUserName = paramParcel.readString();
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
    l(localParcel);
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
    String str = "AppBrandWeishiParams{fromOpenSdk=" + this.nPf + ", thumbUrl='" + this.thumbUrl + '\'' + ", thumbFullPath='" + this.qZi + '\'' + ", msgImgPath='" + this.qZj + '\'' + ", appId='" + this.appId + '\'' + ", appName='" + this.appName + '\'' + ", sourceUserName='" + this.sourceUserName + '\'' + '}';
    AppMethodBeat.o(134800);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134804);
    paramParcel.writeInt(this.nPf);
    paramParcel.writeString(this.thumbUrl);
    paramParcel.writeString(this.qZi);
    paramParcel.writeString(this.qZj);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.sourceUserName);
    AppMethodBeat.o(134804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams
 * JD-Core Version:    0.7.0.1
 */