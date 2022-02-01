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
  public boolean leH;
  public boolean leI;
  public boolean leJ;
  public int leK;
  public byte[] leL;
  public ICommLibReader leM;
  public int leb;
  public int lec;
  
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
      this.leH = bool1;
      if (paramParcel.readInt() != 1) {
        break label107;
      }
      bool1 = true;
      label36:
      this.leI = bool1;
      this.leK = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label112;
      }
    }
    label107:
    label112:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.leJ = bool1;
      this.leL = paramParcel.createByteArray();
      this.leM = ICommLibReader.b.h(paramParcel);
      this.leb = paramParcel.readInt();
      this.lec = paramParcel.readInt();
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
    if (this.leH)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.leI) {
        break label113;
      }
      i = 1;
      label38:
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.leK);
      if (!this.leJ) {
        break label119;
      }
    }
    label113:
    label119:
    for (int i = j;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeByteArray(this.leL);
      ICommLibReader.b.a(this.leM, paramParcel, paramInt);
      paramParcel.writeInt(this.leb);
      paramParcel.writeInt(this.lec);
      AppMethodBeat.o(44847);
      return;
      b = 0;
      break;
      i = 0;
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC
 * JD-Core Version:    0.7.0.1
 */