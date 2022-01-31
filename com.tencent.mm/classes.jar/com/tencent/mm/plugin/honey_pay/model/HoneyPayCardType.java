package com.tencent.mm.plugin.honey_pay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public class HoneyPayCardType
  implements Parcelable
{
  public static final Parcelable.Creator<HoneyPayCardType> CREATOR;
  public byte[] pW;
  
  static
  {
    AppMethodBeat.i(41749);
    CREATOR = new HoneyPayCardType.1();
    AppMethodBeat.o(41749);
  }
  
  protected HoneyPayCardType(Parcel paramParcel)
  {
    AppMethodBeat.i(41747);
    this.pW = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.pW);
    AppMethodBeat.o(41747);
  }
  
  public HoneyPayCardType(aua paramaua)
  {
    AppMethodBeat.i(41746);
    try
    {
      this.pW = paramaua.toByteArray();
      AppMethodBeat.o(41746);
      return;
    }
    catch (IOException paramaua)
    {
      ab.printErrStackTrace("MicroMsg.HoneyPayCardType", paramaua, "", new Object[0]);
      AppMethodBeat.o(41746);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(41748);
    paramParcel.writeInt(this.pW.length);
    paramParcel.writeByteArray(this.pW);
    AppMethodBeat.o(41748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType
 * JD-Core Version:    0.7.0.1
 */