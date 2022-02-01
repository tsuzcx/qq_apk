package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16})
public final class LuggageInitTask$a
  implements Parcelable.Creator
{
  public final Object createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(237679);
    p.k(paramParcel, "in");
    paramParcel = new LuggageInitTask(paramParcel.readString());
    AppMethodBeat.o(237679);
    return paramParcel;
  }
  
  public final Object[] newArray(int paramInt)
  {
    return new LuggageInitTask[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageInitTask.a
 * JD-Core Version:    0.7.0.1
 */