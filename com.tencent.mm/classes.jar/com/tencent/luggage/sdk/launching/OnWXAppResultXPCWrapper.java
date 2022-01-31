package com.tencent.luggage.sdk.launching;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class OnWXAppResultXPCWrapper<R extends Parcelable>
  implements Parcelable
{
  public static final Parcelable.Creator<OnWXAppResultXPCWrapper> CREATOR;
  private final ResultReceiver Di;
  private final b<R> bEV;
  
  static
  {
    AppMethodBeat.i(101681);
    CREATOR = new OnWXAppResultXPCWrapper.3();
    AppMethodBeat.o(101681);
  }
  
  private OnWXAppResultXPCWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(101680);
    this.Di = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    this.bEV = new OnWXAppResultXPCWrapper.2(this);
    AppMethodBeat.o(101680);
  }
  
  private OnWXAppResultXPCWrapper(b<R> paramb)
  {
    AppMethodBeat.i(101678);
    this.bEV = paramb;
    this.Di = new OnWXAppResultXPCWrapper.1(this, new Handler(Looper.getMainLooper()), paramb);
    AppMethodBeat.o(101678);
  }
  
  public static <R extends Parcelable> void a(b<R> paramb, Parcel paramParcel)
  {
    AppMethodBeat.i(101676);
    if (paramb == null)
    {
      paramParcel.writeString(null);
      AppMethodBeat.o(101676);
      return;
    }
    paramParcel.writeParcelable(new OnWXAppResultXPCWrapper(paramb), 0);
    AppMethodBeat.o(101676);
  }
  
  public static b<?> b(Parcel paramParcel)
  {
    AppMethodBeat.i(101677);
    paramParcel = (OnWXAppResultXPCWrapper)paramParcel.readParcelable(OnWXAppResultXPCWrapper.class.getClassLoader());
    if (paramParcel != null) {}
    for (paramParcel = paramParcel.bEV;; paramParcel = null)
    {
      AppMethodBeat.o(101677);
      return paramParcel;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101679);
    this.Di.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(101679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper
 * JD-Core Version:    0.7.0.1
 */