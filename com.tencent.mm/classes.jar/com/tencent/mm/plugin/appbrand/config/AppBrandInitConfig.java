package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.a.a;

public class AppBrandInitConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandInitConfig> CREATOR;
  public String appId;
  public String cqQ;
  public int gXd;
  public String hha;
  public boolean hiA;
  public String hiw;
  public int hix;
  public String hiy;
  public final AppBrandLaunchReferrer hiz;
  public String iconUrl;
  
  static
  {
    AppMethodBeat.i(86895);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(86895);
  }
  
  public AppBrandInitConfig()
  {
    AppMethodBeat.i(86892);
    this.hiz = new AppBrandLaunchReferrer();
    AppMethodBeat.o(86892);
  }
  
  protected AppBrandInitConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(86893);
    this.appId = paramParcel.readString();
    this.cqQ = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.gXd = paramParcel.readInt();
    this.hiw = paramParcel.readString();
    this.hiz = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.hha = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hiA = bool;
      this.hix = paramParcel.readInt();
      this.hiy = paramParcel.readString();
      AppMethodBeat.o(86893);
      return;
    }
  }
  
  public Parcel ayu()
  {
    AppMethodBeat.i(141650);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(141650);
    return localParcel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public AppBrandInitConfig wd()
  {
    AppMethodBeat.i(141649);
    Parcel localParcel = ayu();
    AppBrandInitConfig localAppBrandInitConfig = (AppBrandInitConfig)a.ba(getClass()).ac(new Object[] { localParcel }).object;
    localParcel.recycle();
    AppMethodBeat.o(141649);
    return localAppBrandInitConfig;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(86894);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.cqQ);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.gXd);
    paramParcel.writeString(this.hiw);
    paramParcel.writeParcelable(this.hiz, paramInt);
    paramParcel.writeString(this.hha);
    if (this.hiA) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.hix);
      paramParcel.writeString(this.hiy);
      AppMethodBeat.o(86894);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig
 * JD-Core Version:    0.7.0.1
 */