package com.pay.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class ParcelableCompatCreatorHoneycombMR2<T>
  implements Parcelable.ClassLoaderCreator<T>
{
  private final APParcelableCompatCreatorCallbacks<T> mCallbacks;
  
  public ParcelableCompatCreatorHoneycombMR2(APParcelableCompatCreatorCallbacks<T> paramAPParcelableCompatCreatorCallbacks)
  {
    this.mCallbacks = paramAPParcelableCompatCreatorCallbacks;
  }
  
  public T createFromParcel(Parcel paramParcel)
  {
    return this.mCallbacks.createFromParcel(paramParcel, null);
  }
  
  public T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return this.mCallbacks.createFromParcel(paramParcel, paramClassLoader);
  }
  
  public T[] newArray(int paramInt)
  {
    return this.mCallbacks.newArray(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.v4.os.ParcelableCompatCreatorHoneycombMR2
 * JD-Core Version:    0.7.0.1
 */