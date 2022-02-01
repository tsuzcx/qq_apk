package com.tencent.mm.plugin.honey_pay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public class HoneyPayCardType
  implements Parcelable
{
  public static final Parcelable.Creator<HoneyPayCardType> CREATOR;
  public byte[] wA;
  
  static
  {
    AppMethodBeat.i(64644);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(64644);
  }
  
  protected HoneyPayCardType(Parcel paramParcel)
  {
    AppMethodBeat.i(64642);
    this.wA = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.wA);
    AppMethodBeat.o(64642);
  }
  
  public HoneyPayCardType(bfb parambfb)
  {
    AppMethodBeat.i(64641);
    try
    {
      this.wA = parambfb.toByteArray();
      AppMethodBeat.o(64641);
      return;
    }
    catch (IOException parambfb)
    {
      ad.printErrStackTrace("MicroMsg.HoneyPayCardType", parambfb, "", new Object[0]);
      AppMethodBeat.o(64641);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(64643);
    paramParcel.writeInt(this.wA.length);
    paramParcel.writeByteArray(this.wA);
    AppMethodBeat.o(64643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType
 * JD-Core Version:    0.7.0.1
 */