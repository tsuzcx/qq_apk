package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.a.a;
import org.json.JSONObject;

public class AppBrandInitConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandInitConfig> CREATOR;
  public String appId;
  public String euP;
  public int eul;
  public String hEy;
  public String iconUrl;
  public int originalFlag;
  public String qAF;
  public String qXZ;
  public int qYa;
  
  static
  {
    AppMethodBeat.i(134790);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134790);
  }
  
  public AppBrandInitConfig()
  {
    AppMethodBeat.i(134786);
    AppMethodBeat.o(134786);
  }
  
  protected AppBrandInitConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(134787);
    this.appId = paramParcel.readString();
    this.hEy = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.eul = paramParcel.readInt();
    this.qAF = paramParcel.readString();
    this.euP = paramParcel.readString();
    this.originalFlag = paramParcel.readInt();
    this.qXZ = paramParcel.readString();
    this.qYa = paramParcel.readInt();
    AppMethodBeat.o(134787);
  }
  
  public JSONObject aqM()
  {
    AppMethodBeat.i(134785);
    AppMethodBeat.o(134785);
    return null;
  }
  
  public AppBrandInitConfig aqO()
  {
    AppMethodBeat.i(134783);
    Parcel localParcel = ckF();
    AppBrandInitConfig localAppBrandInitConfig = (AppBrandInitConfig)a.cQ(getClass()).av(new Object[] { localParcel }).object;
    localParcel.recycle();
    AppMethodBeat.o(134783);
    return localAppBrandInitConfig;
  }
  
  public Parcel ckF()
  {
    AppMethodBeat.i(134784);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(134784);
    return localParcel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134788);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hEy);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.eul);
    paramParcel.writeString(this.qAF);
    paramParcel.writeString(this.euP);
    paramParcel.writeInt(this.originalFlag);
    paramParcel.writeString(this.qXZ);
    paramParcel.writeInt(this.qYa);
    AppMethodBeat.o(134788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig
 * JD-Core Version:    0.7.0.1
 */