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
  
  public static class CompatCreator<T>
    implements Parcelable.Creator<T>
  {
    public final APParcelableCompatCreatorCallbacks<T> mCallbacks;
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.v4.os.APParcelableCompat
 * JD-Core Version:    0.7.0.1
 */