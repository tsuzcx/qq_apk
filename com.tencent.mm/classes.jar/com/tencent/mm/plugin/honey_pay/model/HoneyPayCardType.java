package com.tencent.mm.plugin.honey_pay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public class HoneyPayCardType
  implements Parcelable
{
  public static final Parcelable.Creator<HoneyPayCardType> CREATOR;
  public byte[] zr;
  
  static
  {
    AppMethodBeat.i(64644);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(64644);
  }
  
  protected HoneyPayCardType(Parcel paramParcel)
  {
    AppMethodBeat.i(64642);
    this.zr = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.zr);
    AppMethodBeat.o(64642);
  }
  
  public HoneyPayCardType(bnt parambnt)
  {
    AppMethodBeat.i(64641);
    try
    {
      this.zr = parambnt.toByteArray();
      AppMethodBeat.o(64641);
      return;
    }
    catch (IOException parambnt)
    {
      ae.printErrStackTrace("MicroMsg.HoneyPayCardType", parambnt, "", new Object[0]);
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
    paramParcel.writeInt(this.zr.length);
    paramParcel.writeByteArray(this.zr);
    AppMethodBeat.o(64643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType
 * JD-Core Version:    0.7.0.1
 */