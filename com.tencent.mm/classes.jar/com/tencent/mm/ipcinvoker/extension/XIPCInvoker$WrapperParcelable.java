package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class XIPCInvoker$WrapperParcelable
  implements Parcelable
{
  public static final Parcelable.Creator<WrapperParcelable> CREATOR;
  Object eEI;
  String eEL;
  
  static
  {
    AppMethodBeat.i(114098);
    CREATOR = new XIPCInvoker.WrapperParcelable.1();
    AppMethodBeat.o(114098);
  }
  
  private XIPCInvoker$WrapperParcelable() {}
  
  public XIPCInvoker$WrapperParcelable(String paramString, Object paramObject)
  {
    this.eEL = paramString;
    this.eEI = paramObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114097);
    paramParcel.writeString(this.eEL);
    if (this.eEI != null)
    {
      a locala = c.ag(this.eEI);
      if (locala != null)
      {
        paramParcel.writeInt(1);
        paramParcel.writeString(locala.getClass().getName());
        locala.a(this.eEI, paramParcel);
        AppMethodBeat.o(114097);
        return;
      }
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(114097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable
 * JD-Core Version:    0.7.0.1
 */