package com.tencent.luggage.sdk.processes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageClientProcessMessage2;", "Landroid/os/Parcelable;", "()V", "describeContents", "", "runOnClientProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
class LuggageClientProcessMessage2
  implements Parcelable
{
  public static final Parcelable.Creator<LuggageClientProcessMessage2> CREATOR;
  
  static
  {
    AppMethodBeat.i(220417);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220417);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220433);
    s.u(paramParcel, "out");
    paramParcel.writeInt(1);
    AppMethodBeat.o(220433);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<LuggageClientProcessMessage2>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.LuggageClientProcessMessage2
 * JD-Core Version:    0.7.0.1
 */