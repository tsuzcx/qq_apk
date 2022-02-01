package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MessengerCompat
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<MessengerCompat> CREATOR;
  private Messenger zzab;
  private zzl zzby;
  
  static
  {
    AppMethodBeat.i(2481);
    CREATOR = new zzq();
    AppMethodBeat.o(2481);
  }
  
  public MessengerCompat(IBinder paramIBinder)
  {
    AppMethodBeat.i(2475);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.zzab = new Messenger(paramIBinder);
      AppMethodBeat.o(2475);
      return;
    }
    if (paramIBinder == null) {
      paramIBinder = null;
    }
    for (;;)
    {
      this.zzby = paramIBinder;
      AppMethodBeat.o(2475);
      return;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
      if ((localIInterface instanceof zzl)) {
        paramIBinder = (zzl)localIInterface;
      } else {
        paramIBinder = new zzm(paramIBinder);
      }
    }
  }
  
  private final IBinder getBinder()
  {
    AppMethodBeat.i(2477);
    if (this.zzab != null)
    {
      localIBinder = this.zzab.getBinder();
      AppMethodBeat.o(2477);
      return localIBinder;
    }
    IBinder localIBinder = this.zzby.asBinder();
    AppMethodBeat.o(2477);
    return localIBinder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2478);
    if (paramObject == null)
    {
      AppMethodBeat.o(2478);
      return false;
    }
    try
    {
      boolean bool = getBinder().equals(((MessengerCompat)paramObject).getBinder());
      AppMethodBeat.o(2478);
      return bool;
    }
    catch (ClassCastException paramObject)
    {
      AppMethodBeat.o(2478);
    }
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(2479);
    int i = getBinder().hashCode();
    AppMethodBeat.o(2479);
    return i;
  }
  
  public final void send(Message paramMessage)
  {
    AppMethodBeat.i(2476);
    if (this.zzab != null)
    {
      this.zzab.send(paramMessage);
      AppMethodBeat.o(2476);
      return;
    }
    this.zzby.send(paramMessage);
    AppMethodBeat.o(2476);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(2480);
    if (this.zzab != null)
    {
      paramParcel.writeStrongBinder(this.zzab.getBinder());
      AppMethodBeat.o(2480);
      return;
    }
    paramParcel.writeStrongBinder(this.zzby.asBinder());
    AppMethodBeat.o(2480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.iid.MessengerCompat
 * JD-Core Version:    0.7.0.1
 */