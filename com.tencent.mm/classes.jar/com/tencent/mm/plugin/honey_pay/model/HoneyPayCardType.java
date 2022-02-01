package com.tencent.mm.plugin.honey_pay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public class HoneyPayCardType
  implements Parcelable
{
  public static final Parcelable.Creator<HoneyPayCardType> CREATOR;
  public byte[] zy;
  
  static
  {
    AppMethodBeat.i(64644);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(64644);
  }
  
  protected HoneyPayCardType(Parcel paramParcel)
  {
    AppMethodBeat.i(64642);
    this.zy = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.zy);
    AppMethodBeat.o(64642);
  }
  
  public HoneyPayCardType(cak paramcak)
  {
    AppMethodBeat.i(64641);
    try
    {
      this.zy = paramcak.toByteArray();
      AppMethodBeat.o(64641);
      return;
    }
    catch (IOException paramcak)
    {
      Log.printErrStackTrace("MicroMsg.HoneyPayCardType", paramcak, "", new Object[0]);
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
    paramParcel.writeInt(this.zy.length);
    paramParcel.writeByteArray(this.zy);
    AppMethodBeat.o(64643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType
 * JD-Core Version:    0.7.0.1
 */