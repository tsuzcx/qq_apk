package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ac.i;
import com.tencent.mm.sdk.platformtools.ad;

public class ByRuntimeQrcodeResult
  implements Parcelable
{
  public static final Parcelable.Creator<ByRuntimeQrcodeResult> CREATOR;
  public String data;
  public String jXV;
  
  static
  {
    AppMethodBeat.i(47500);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47500);
  }
  
  protected ByRuntimeQrcodeResult(Parcel paramParcel)
  {
    AppMethodBeat.i(47499);
    this.data = paramParcel.readString();
    this.jXV = paramParcel.readString();
    AppMethodBeat.o(47499);
  }
  
  public ByRuntimeQrcodeResult(String paramString1, String paramString2)
  {
    this.data = paramString1;
    this.jXV = paramString2;
  }
  
  public final String aYt()
  {
    AppMethodBeat.i(47497);
    try
    {
      String str = new i().h("transitiveData", this.jXV).h("data", this.data).toString();
      AppMethodBeat.o(47497);
      return str;
    }
    catch (g localg)
    {
      ad.e("MicroMsg.AppBrand.Functional.ByRuntimeQrcodeResult", "toJsonString e = %s", new Object[] { localg });
      AppMethodBeat.o(47497);
    }
    return "{}";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47498);
    paramParcel.writeString(this.data);
    paramParcel.writeString(this.jXV);
    AppMethodBeat.o(47498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult
 * JD-Core Version:    0.7.0.1
 */