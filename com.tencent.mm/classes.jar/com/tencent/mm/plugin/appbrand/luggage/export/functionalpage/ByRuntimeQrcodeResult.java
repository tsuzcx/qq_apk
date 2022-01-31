package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.i;
import com.tencent.mm.sdk.platformtools.ab;

public class ByRuntimeQrcodeResult
  implements Parcelable
{
  public static final Parcelable.Creator<ByRuntimeQrcodeResult> CREATOR;
  public String data;
  public String hiO;
  
  static
  {
    AppMethodBeat.i(132117);
    CREATOR = new ByRuntimeQrcodeResult.1();
    AppMethodBeat.o(132117);
  }
  
  protected ByRuntimeQrcodeResult(Parcel paramParcel)
  {
    AppMethodBeat.i(132116);
    this.data = paramParcel.readString();
    this.hiO = paramParcel.readString();
    AppMethodBeat.o(132116);
  }
  
  public ByRuntimeQrcodeResult(String paramString1, String paramString2)
  {
    this.data = paramString1;
    this.hiO = paramString2;
  }
  
  public final String aHy()
  {
    AppMethodBeat.i(132114);
    try
    {
      String str = new i().f("transitiveData", this.hiO).f("data", this.data).toString();
      AppMethodBeat.o(132114);
      return str;
    }
    catch (g localg)
    {
      ab.e("MicroMsg.AppBrand.Functional.ByRuntimeQrcodeResult", "toJsonString e = %s", new Object[] { localg });
      AppMethodBeat.o(132114);
    }
    return "{}";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(132115);
    paramParcel.writeString(this.data);
    paramParcel.writeString(this.hiO);
    AppMethodBeat.o(132115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult
 * JD-Core Version:    0.7.0.1
 */