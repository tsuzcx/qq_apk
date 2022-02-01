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
  public final Entry[] bdA;
  
  static
  {
    AppMethodBeat.i(92468);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92468);
  }
  
  Metadata(Parcel paramParcel)
  {
    AppMethodBeat.i(92464);
    this.bdA = new Entry[paramParcel.readInt()];
    int i = 0;
    while (i < this.bdA.length)
    {
      this.bdA[i] = ((Entry)paramParcel.readParcelable(Entry.class.getClassLoader()));
      i += 1;
    }
    AppMethodBeat.o(92464);
  }
  
  public Metadata(List<? extends Entry> paramList)
  {
    AppMethodBeat.i(92463);
    this.bdA = new Entry[paramList.size()];
    paramList.toArray(this.bdA);
    AppMethodBeat.o(92463);
  }
  
  public Metadata(Entry... paramVarArgs)
  {
    this.bdA = paramVarArgs;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92465);
    if (this == paramObject)
    {
      AppMethodBeat.o(92465);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92465);
      return false;
    }
    paramObject = (Metadata)paramObject;
    boolean bool = Arrays.equals(this.bdA, paramObject.bdA);
    AppMethodBeat.o(92465);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(92466);
    int i = Arrays.hashCode(this.bdA);
    AppMethodBeat.o(92466);
    return i;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92467);
    paramParcel.writeInt(this.bdA.length);
    Entry[] arrayOfEntry = this.bdA;
    int i = arrayOfEntry.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeParcelable(arrayOfEntry[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(92467);
  }
  
  public static abstract interface Entry
    extends Parcelable
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.Metadata
 * JD-Core Version:    0.7.0.1
 */