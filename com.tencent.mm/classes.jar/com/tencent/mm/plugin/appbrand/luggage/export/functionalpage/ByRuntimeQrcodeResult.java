package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.sdk.platformtools.ae;

public class ByRuntimeQrcodeResult
  implements Parcelable
{
  public static final Parcelable.Creator<ByRuntimeQrcodeResult> CREATOR;
  public String data;
  public String kbk;
  
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
    this.kbk = paramParcel.readString();
    AppMethodBeat.o(47499);
  }
  
  public ByRuntimeQrcodeResult(String paramString1, String paramString2)
  {
    this.data = paramString1;
    this.kbk = paramString2;
  }
  
  public final String aYO()
  {
    AppMethodBeat.i(47497);
    try
    {
      String str = new i().h("transitiveData", this.kbk).h("data", this.data).toString();
      AppMethodBeat.o(47497);
      return str;
    }
    catch (g localg)
    {
      ae.e("MicroMsg.AppBrand.Functional.ByRuntimeQrcodeResult", "toJsonString e = %s", new Object[] { localg });
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
    paramParcel.writeString(this.kbk);
    AppMethodBeat.o(47498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult
 * JD-Core Version:    0.7.0.1
 */