package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

public final class Metadata
  implements Parcelable
{
  public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator() {};
  public final Metadata.Entry[] aGI;
  
  Metadata(Parcel paramParcel)
  {
    this.aGI = new Metadata.Entry[paramParcel.readInt()];
    int i = 0;
    while (i < this.aGI.length)
    {
      this.aGI[i] = ((Metadata.Entry)paramParcel.readParcelable(Metadata.Entry.class.getClassLoader()));
      i += 1;
    }
  }
  
  public Metadata(List<? extends Metadata.Entry> paramList)
  {
    this.aGI = new Metadata.Entry[paramList.size()];
    paramList.toArray(this.aGI);
  }
  
  public Metadata(Metadata.Entry... paramVarArgs)
  {
    this.aGI = paramVarArgs;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (Metadata)paramObject;
    return Arrays.equals(this.aGI, paramObject.aGI);
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.aGI);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aGI.length);
    Metadata.Entry[] arrayOfEntry = this.aGI;
    int i = arrayOfEntry.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeParcelable(arrayOfEntry[paramInt], 0);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.Metadata
 * JD-Core Version:    0.7.0.1
 */