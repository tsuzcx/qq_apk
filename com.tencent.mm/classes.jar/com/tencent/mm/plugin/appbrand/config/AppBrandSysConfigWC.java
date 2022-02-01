package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader.b;

public class AppBrandSysConfigWC
  extends AppBrandSysConfigLU
{
  public static final Parcelable.Creator<AppBrandSysConfigWC> CREATOR;
  public boolean nYU;
  public boolean nYV;
  public boolean nYW;
  public int nYX;
  public byte[] nYY;
  public ICommLibReader nYZ;
  public int nYp;
  public int nYq;
  
  static
  {
    AppMethodBeat.i(44848);
    CREATOR = new Parcelable.Creator() {};
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
      this.nYU = bool1;
      if (paramParcel.readInt() != 1) {
        break label107;
      }
      bool1 = true;
      label36:
      this.nYV = bool1;
      this.nYX = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label112;
      }
    }
    label107:
    label112:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.nYW = bool1;
      this.nYY = paramParcel.createByteArray();
      this.nYZ = ICommLibReader.b.h(paramParcel);
      this.nYp = paramParcel.readInt();
      this.nYq = paramParcel.readInt();
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
    int j = 1;
    AppMethodBeat.i(44847);
    super.writeToParcel(paramParcel, paramInt);
    byte b;
    if (this.nYU)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.nYV) {
        break label113;
      }
      i = 1;
      label38:
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.nYX);
      if (!this.nYW) {
        break label119;
      }
    }
    label113:
    label119:
    for (int i = j;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeByteArray(this.nYY);
      ICommLibReader.b.a(this.nYZ, paramParcel, paramInt);
      paramParcel.writeInt(this.nYp);
      paramParcel.writeInt(this.nYq);
      AppMethodBeat.o(44847);
      return;
      b = 0;
      break;
      i = 0;
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC
 * JD-Core Version:    0.7.0.1
 */