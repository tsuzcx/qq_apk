package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandSysConfigWC
  extends AppBrandSysConfigLU
{
  public static final Parcelable.Creator<AppBrandSysConfigWC> CREATOR;
  public boolean hja;
  public boolean hjb;
  public int hjc;
  
  static
  {
    AppMethodBeat.i(129846);
    CREATOR = new AppBrandSysConfigWC.1();
    AppMethodBeat.o(129846);
  }
  
  public AppBrandSysConfigWC() {}
  
  public AppBrandSysConfigWC(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(129844);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.hja = bool1;
      if (paramParcel.readInt() != 1) {
        break label60;
      }
    }
    label60:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hjb = bool1;
      this.hjc = paramParcel.readInt();
      AppMethodBeat.o(129844);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(129845);
    super.writeToParcel(paramParcel, paramInt);
    byte b;
    if (this.hja)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.hjb) {
        break label62;
      }
    }
    label62:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hjc);
      AppMethodBeat.o(129845);
      return;
      b = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC
 * JD-Core Version:    0.7.0.1
 */