package com.pay.v4.os;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class APParcelableCompat
{
  public static <T> Parcelable.Creator<T> newCreator(APParcelableCompatCreatorCallbacks<T> paramAPParcelableCompatCreatorCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 13) {
      APParcelableCompatCreatorHoneycombMR2Stub.instantiate(paramAPParcelableCompatCreatorCallbacks);
    }
    return new CompatCreator(paramAPParcelableCompatCreatorCallbacks);
  }
  
  static class CompatCreator<T>
    implements Parcelable.Creator<T>
  {
    final APParcelableCompatCreatorCallbacks<T> mCallbacks;
    
    public CompatCreator(APParcelableCompatCreatorCallbacks<T> paramAPParcelableCompatCreatorCallbacks)
    {
      this.mCallbacks = paramAPParcelableCompatCreatorCallbacks;
    }
    
    public T createFromParcel(Parcel paramParcel)
    {
      return this.mCallbacks.createFromParcel(paramParcel, null);
    }
    
    public T[] newArray(int paramInt)
    {
      return this.mCallbacks.newArray(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.v4.os.APParcelableCompat
 * JD-Core Version:    0.7.0.1
 */