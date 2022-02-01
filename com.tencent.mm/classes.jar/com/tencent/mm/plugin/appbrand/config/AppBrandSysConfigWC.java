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
  public boolean jEj;
  public boolean jEk;
  public boolean jEl;
  public int jEm;
  public ICommLibReader jEn;
  
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
      this.jEj = bool1;
      if (paramParcel.readInt() != 1) {
        break label83;
      }
      bool1 = true;
      label36:
      this.jEk = bool1;
      this.jEm = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label88;
      }
    }
    label83:
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jEl = bool1;
      this.jEn = ICommLibReader.b.g(paramParcel);
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
    if (this.jEj)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.jEk) {
        break label89;
      }
      i = 1;
      label38:
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.jEm);
      if (!this.jEl) {
        break label95;
      }
    }
    label89:
    label95:
    for (int i = j;; i = 0)
    {
      paramParcel.writeInt(i);
      ICommLibReader.b.a(this.jEn, paramParcel, paramInt);
      AppMethodBeat.o(44847);
      return;
      b = 0;
      break;
      i = 0;
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC
 * JD-Core Version:    0.7.0.1
 */