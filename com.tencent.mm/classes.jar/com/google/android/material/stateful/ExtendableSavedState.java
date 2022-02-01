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
  public final g<String, Bundle> dxM;
  
  static
  {
    AppMethodBeat.i(208927);
    CREATOR = new Parcelable.ClassLoaderCreator() {};
    AppMethodBeat.o(208927);
  }
  
  private ExtendableSavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    AppMethodBeat.i(208921);
    int j = paramParcel.readInt();
    paramClassLoader = new String[j];
    paramParcel.readStringArray(paramClassLoader);
    Bundle[] arrayOfBundle = new Bundle[j];
    paramParcel.readTypedArray(arrayOfBundle, Bundle.CREATOR);
    this.dxM = new g(j);
    int i = 0;
    while (i < j)
    {
      this.dxM.put(paramClassLoader[i], arrayOfBundle[i]);
      i += 1;
    }
    AppMethodBeat.o(208921);
  }
  
  public ExtendableSavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
    AppMethodBeat.i(208915);
    this.dxM = new g();
    AppMethodBeat.o(208915);
  }
  
  public String toString()
  {
    AppMethodBeat.i(208936);
    String str = "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.dxM + "}";
    AppMethodBeat.o(208936);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208933);
    super.writeToParcel(paramParcel, paramInt);
    int i = this.dxM.size();
    paramParcel.writeInt(i);
    String[] arrayOfString = new String[i];
    Bundle[] arrayOfBundle = new Bundle[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfString[paramInt] = ((String)this.dxM.bn(paramInt));
      arrayOfBundle[paramInt] = ((Bundle)this.dxM.bl(paramInt));
      paramInt += 1;
    }
    paramParcel.writeStringArray(arrayOfString);
    paramParcel.writeTypedArray(arrayOfBundle, 0);
    AppMethodBeat.o(208933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.stateful.ExtendableSavedState
 * JD-Core Version:    0.7.0.1
 */