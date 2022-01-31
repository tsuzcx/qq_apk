package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.firebase_messaging.zze;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzi
  implements Parcelable
{
  public static final Parcelable.Creator<zzi> CREATOR;
  private Messenger bgh;
  private zze bgi;
  
  static
  {
    AppMethodBeat.i(108791);
    CREATOR = new z();
    AppMethodBeat.o(108791);
  }
  
  public zzi(IBinder paramIBinder)
  {
    AppMethodBeat.i(108785);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.bgh = new Messenger(paramIBinder);
      AppMethodBeat.o(108785);
      return;
    }
    this.bgi = zzf.zza(paramIBinder);
    AppMethodBeat.o(108785);
  }
  
  private final IBinder getBinder()
  {
    AppMethodBeat.i(108787);
    if (this.bgh != null)
    {
      localIBinder = this.bgh.getBinder();
      AppMethodBeat.o(108787);
      return localIBinder;
    }
    IBinder localIBinder = this.bgi.asBinder();
    AppMethodBeat.o(108787);
    return localIBinder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108788);
    if (paramObject == null)
    {
      AppMethodBeat.o(108788);
      return false;
    }
    try
    {
      boolean bool = getBinder().equals(((zzi)paramObject).getBinder());
      AppMethodBeat.o(108788);
      return bool;
    }
    catch (ClassCastException paramObject)
    {
      AppMethodBeat.o(108788);
    }
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(108789);
    int i = getBinder().hashCode();
    AppMethodBeat.o(108789);
    return i;
  }
  
  public final void send(Message paramMessage)
  {
    AppMethodBeat.i(108786);
    if (this.bgh != null)
    {
      this.bgh.send(paramMessage);
      AppMethodBeat.o(108786);
      return;
    }
    this.bgi.send(paramMessage);
    AppMethodBeat.o(108786);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(108790);
    if (this.bgh != null)
    {
      paramParcel.writeStrongBinder(this.bgh.getBinder());
      AppMethodBeat.o(108790);
      return;
    }
    paramParcel.writeStrongBinder(this.bgi.asBinder());
    AppMethodBeat.o(108790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.iid.zzi
 * JD-Core Version:    0.7.0.1
 */