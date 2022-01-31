package com.tencent.mm.plugin.appbrand.launching.params;

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
  public int fft;
  public String inD;
  public String inE;
  public String inF;
  public String thumbUrl;
  
  static
  {
    AppMethodBeat.i(102118);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(102118);
  }
  
  public AppBrandWeishiParams() {}
  
  public AppBrandWeishiParams(Parcel paramParcel)
  {
    AppMethodBeat.i(102114);
    i(paramParcel);
    AppMethodBeat.o(102114);
  }
  
  private void i(Parcel paramParcel)
  {
    AppMethodBeat.i(102115);
    this.fft = paramParcel.readInt();
    this.thumbUrl = paramParcel.readString();
    this.inD = paramParcel.readString();
    this.inE = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.appName = paramParcel.readString();
    this.inF = paramParcel.readString();
    AppMethodBeat.o(102115);
  }
  
  public final void a(AppBrandWeishiParams paramAppBrandWeishiParams)
  {
    AppMethodBeat.i(102116);
    if (paramAppBrandWeishiParams == null)
    {
      AppMethodBeat.o(102116);
      return;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramAppBrandWeishiParams.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    i(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(102116);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(102113);
    String str = "AppBrandWeishiParams{fromOpenSdk=" + this.fft + ", thumbUrl='" + this.thumbUrl + '\'' + ", thumbFullPath='" + this.inD + '\'' + ", msgImgPath='" + this.inE + '\'' + ", appId='" + this.appId + '\'' + ", appName='" + this.appName + '\'' + ", sourceUserName='" + this.inF + '\'' + '}';
    AppMethodBeat.o(102113);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(102117);
    paramParcel.writeInt(this.fft);
    paramParcel.writeString(this.thumbUrl);
    paramParcel.writeString(this.inD);
    paramParcel.writeString(this.inE);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.inF);
    AppMethodBeat.o(102117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.params.AppBrandWeishiParams
 * JD-Core Version:    0.7.0.1
 */