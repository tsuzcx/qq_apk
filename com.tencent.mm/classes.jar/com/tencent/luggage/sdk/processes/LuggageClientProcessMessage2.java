package com.tencent.luggage.sdk.processes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/LuggageClientProcessMessage2;", "Landroid/os/Parcelable;", "()V", "describeContents", "", "runOnClientProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"})
class LuggageClientProcessMessage2
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  
  static
  {
    AppMethodBeat.i(242448);
    CREATOR = new a();
    AppMethodBeat.o(242448);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(242446);
    p.k(paramParcel, "parcel");
    paramParcel.writeInt(1);
    AppMethodBeat.o(242446);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(246526);
      p.k(paramParcel, "in");
      if (paramParcel.readInt() != 0)
      {
        paramParcel = new LuggageClientProcessMessage2();
        AppMethodBeat.o(246526);
        return paramParcel;
      }
      AppMethodBeat.o(246526);
      return null;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new LuggageClientProcessMessage2[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.LuggageClientProcessMessage2
 * JD-Core Version:    0.7.0.1
 */