package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import androidx.b.g;
import androidx.customview.view.AbsSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExtendableSavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<ExtendableSavedState> CREATOR;
  public final g<String, Bundle> bEM;
  
  static
  {
    AppMethodBeat.i(239508);
    CREATOR = new Parcelable.ClassLoaderCreator() {};
    AppMethodBeat.o(239508);
  }
  
  private ExtendableSavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    AppMethodBeat.i(239497);
    int j = paramParcel.readInt();
    paramClassLoader = new String[j];
    paramParcel.readStringArray(paramClassLoader);
    Bundle[] arrayOfBundle = new Bundle[j];
    paramParcel.readTypedArray(arrayOfBundle, Bundle.CREATOR);
    this.bEM = new g(j);
    int i = 0;
    while (i < j)
    {
      this.bEM.put(paramClassLoader[i], arrayOfBundle[i]);
      i += 1;
    }
    AppMethodBeat.o(239497);
  }
  
  public ExtendableSavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
    AppMethodBeat.i(239492);
    this.bEM = new g();
    AppMethodBeat.o(239492);
  }
  
  public String toString()
  {
    AppMethodBeat.i(239503);
    String str = "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.bEM + "}";
    AppMethodBeat.o(239503);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(239501);
    super.writeToParcel(paramParcel, paramInt);
    int i = this.bEM.size();
    paramParcel.writeInt(i);
    String[] arrayOfString = new String[i];
    Bundle[] arrayOfBundle = new Bundle[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfString[paramInt] = ((String)this.bEM.aO(paramInt));
      arrayOfBundle[paramInt] = ((Bundle)this.bEM.aM(paramInt));
      paramInt += 1;
    }
    paramParcel.writeStringArray(arrayOfString);
    paramParcel.writeTypedArray(arrayOfBundle, 0);
    AppMethodBeat.o(239501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.stateful.ExtendableSavedState
 * JD-Core Version:    0.7.0.1
 */