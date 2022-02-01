package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandSysConfigWC
  extends AppBrandSysConfigLU
{
  public static final Parcelable.Creator<AppBrandSysConfigWC> CREATOR;
  public int nOX;
  public int qYr;
  public boolean qZb;
  public boolean qZc;
  public boolean qZd;
  public int qZe;
  public byte[] qZf;
  public int qZg;
  public int qZh;
  
  static
  {
    AppMethodBeat.i(44848);
    CREATOR = new AppBrandSysConfigWC.1();
    AppMethodBeat.o(44848);
  }
  
  public AppBrandSysConfigWC() {}
  
  public AppBrandSysConfigWC(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(44846);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.qZb = bool1;
      if (paramParcel.readInt() != 1) {
        break label115;
      }
      bool1 = true;
      label36:
      this.qZc = bool1;
      this.qZe = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label120;
      }
    }
    label115:
    label120:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.qZd = bool1;
      this.qZf = paramParcel.createByteArray();
      this.nOX = paramParcel.readInt();
      this.qYr = paramParcel.readInt();
      this.qZg = paramParcel.readInt();
      this.qZh = paramParcel.readInt();
      AppMethodBeat.o(44846);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label36;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(44847);
    super.writeToParcel(paramParcel, paramInt);
    byte b;
    if (this.qZb)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.qZc) {
        break label116;
      }
      paramInt = 1;
      label37:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.qZe);
      if (!this.qZd) {
        break label121;
      }
    }
    label116:
    label121:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeByteArray(this.qZf);
      paramParcel.writeInt(this.nOX);
      paramParcel.writeInt(this.qYr);
      paramParcel.writeInt(this.qZg);
      paramParcel.writeInt(this.qZh);
      AppMethodBeat.o(44847);
      return;
      b = 0;
      break;
      paramInt = 0;
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC
 * JD-Core Version:    0.7.0.1
 */