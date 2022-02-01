package com.tencent.luggage.sdk.processes;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16})
public final class LuggageServiceType$b
  implements Parcelable.Creator
{
  public final Object createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(239241);
    p.k(paramParcel, "in");
    paramParcel = (LuggageServiceType)Enum.valueOf(LuggageServiceType.class, paramParcel.readString());
    AppMethodBeat.o(239241);
    return paramParcel;
  }
  
  public final Object[] newArray(int paramInt)
  {
    return new LuggageServiceType[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.LuggageServiceType.b
 * JD-Core Version:    0.7.0.1
 */