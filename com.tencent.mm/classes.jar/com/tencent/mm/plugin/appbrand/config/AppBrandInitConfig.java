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
  public String dfM;
  public String iJb;
  public int iOP;
  public String iconUrl;
  public String jbC;
  public String jdh;
  public boolean jdi;
  public int originalFlag;
  
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
    this.dfM = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.iOP = paramParcel.readInt();
    this.iJb = paramParcel.readString();
    this.jbC = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdi = bool;
      this.originalFlag = paramParcel.readInt();
      this.jdh = paramParcel.readString();
      AppMethodBeat.o(134787);
      return;
    }
  }
  
  public JSONObject Dd()
  {
    AppMethodBeat.i(134785);
    AppMethodBeat.o(134785);
    return null;
  }
  
  public AppBrandInitConfig Df()
  {
    AppMethodBeat.i(134783);
    Parcel localParcel = aTw();
    AppBrandInitConfig localAppBrandInitConfig = (AppBrandInitConfig)a.bA(getClass()).ag(new Object[] { localParcel }).object;
    localParcel.recycle();
    AppMethodBeat.o(134783);
    return localAppBrandInitConfig;
  }
  
  public Parcel aTw()
  {
    AppMethodBeat.i(134784);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(134784);
    return localParcel;
  }
  
  public final int aTx()
  {
    return this.iOP;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134788);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dfM);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.iOP);
    paramParcel.writeString(this.iJb);
    paramParcel.writeString(this.jbC);
    if (this.jdi) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.originalFlag);
      paramParcel.writeString(this.jdh);
      AppMethodBeat.o(134788);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig
 * JD-Core Version:    0.7.0.1
 */