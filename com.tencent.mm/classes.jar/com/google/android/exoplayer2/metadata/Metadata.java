package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public final class Metadata
  implements Parcelable
{
  public static final Parcelable.Creator<Metadata> CREATOR;
  public final Metadata.Entry[] aND;
  
  static
  {
    AppMethodBeat.i(95346);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(95346);
  }
  
  Metadata(Parcel paramParcel)
  {
    AppMethodBeat.i(95342);
    this.aND = new Metadata.Entry[paramParcel.readInt()];
    int i = 0;
    while (i < this.aND.length)
    {
      this.aND[i] = ((Metadata.Entry)paramParcel.readParcelable(Metadata.Entry.class.getClassLoader()));
      i += 1;
    }
    AppMethodBeat.o(95342);
  }
  
  public Metadata(List<? extends Metadata.Entry> paramList)
  {
    AppMethodBeat.i(95341);
    this.aND = new Metadata.Entry[paramList.size()];
    paramList.toArray(this.aND);
    AppMethodBeat.o(95341);
  }
  
  public Metadata(Metadata.Entry... paramVarArgs)
  {
    this.aND = paramVarArgs;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95343);
    if (this == paramObject)
    {
      AppMethodBeat.o(95343);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95343);
      return false;
    }
    paramObject = (Metadata)paramObject;
    boolean bool = Arrays.equals(this.aND, paramObject.aND);
    AppMethodBeat.o(95343);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(95344);
    int i = Arrays.hashCode(this.aND);
    AppMethodBeat.o(95344);
    return i;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95345);
    paramParcel.writeInt(this.aND.length);
    Metadata.Entry[] arrayOfEntry = this.aND;
    int i = arrayOfEntry.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeParcelable(arrayOfEntry[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(95345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.Metadata
 * JD-Core Version:    0.7.0.1
 */