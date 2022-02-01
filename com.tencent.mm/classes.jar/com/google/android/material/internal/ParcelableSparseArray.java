package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParcelableSparseArray
  extends SparseArray<Parcelable>
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSparseArray> CREATOR;
  
  static
  {
    AppMethodBeat.i(209282);
    CREATOR = new Parcelable.ClassLoaderCreator() {};
    AppMethodBeat.o(209282);
  }
  
  public ParcelableSparseArray() {}
  
  public ParcelableSparseArray(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(209271);
    int j = paramParcel.readInt();
    int[] arrayOfInt = new int[j];
    paramParcel.readIntArray(arrayOfInt);
    paramParcel = paramParcel.readParcelableArray(paramClassLoader);
    int i = 0;
    while (i < j)
    {
      put(arrayOfInt[i], paramParcel[i]);
      i += 1;
    }
    AppMethodBeat.o(209271);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(209304);
    int j = size();
    int[] arrayOfInt = new int[j];
    Parcelable[] arrayOfParcelable = new Parcelable[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = keyAt(i);
      arrayOfParcelable[i] = ((Parcelable)valueAt(i));
      i += 1;
    }
    paramParcel.writeInt(j);
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
    AppMethodBeat.o(209304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.material.internal.ParcelableSparseArray
 * JD-Core Version:    0.7.0.1
 */