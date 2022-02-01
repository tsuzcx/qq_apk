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
  private Messenger bMc;
  private zze bMd;
  
  static
  {
    AppMethodBeat.i(4227);
    CREATOR = new z();
    AppMethodBeat.o(4227);
  }
  
  public zzi(IBinder paramIBinder)
  {
    AppMethodBeat.i(4221);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.bMc = new Messenger(paramIBinder);
      AppMethodBeat.o(4221);
      return;
    }
    this.bMd = zzf.zza(paramIBinder);
    AppMethodBeat.o(4221);
  }
  
  private final IBinder getBinder()
  {
    AppMethodBeat.i(4223);
    if (this.bMc != null)
    {
      localIBinder = this.bMc.getBinder();
      AppMethodBeat.o(4223);
      return localIBinder;
    }
    IBinder localIBinder = this.bMd.asBinder();
    AppMethodBeat.o(4223);
    return localIBinder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(4224);
    if (paramObject == null)
    {
      AppMethodBeat.o(4224);
      return false;
    }
    try
    {
      boolean bool = getBinder().equals(((zzi)paramObject).getBinder());
      AppMethodBeat.o(4224);
      return bool;
    }
    catch (ClassCastException paramObject)
    {
      AppMethodBeat.o(4224);
    }
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(4225);
    int i = getBinder().hashCode();
    AppMethodBeat.o(4225);
    return i;
  }
  
  public final void send(Message paramMessage)
  {
    AppMethodBeat.i(4222);
    if (this.bMc != null)
    {
      this.bMc.send(paramMessage);
      AppMethodBeat.o(4222);
      return;
    }
    this.bMd.send(paramMessage);
    AppMethodBeat.o(4222);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4226);
    if (this.bMc != null)
    {
      paramParcel.writeStrongBinder(this.bMc.getBinder());
      AppMethodBeat.o(4226);
      return;
    }
    paramParcel.writeStrongBinder(this.bMd.asBinder());
    AppMethodBeat.o(4226);
  }
  
  public static final class a
    extends ClassLoader
  {
    protected final Class<?> loadClass(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(4220);
      if ("com.google.android.gms.iid.MessengerCompat".equals(paramString))
      {
        FirebaseInstanceId.xY();
        AppMethodBeat.o(4220);
        return zzi.class;
      }
      paramString = super.loadClass(paramString, paramBoolean);
      AppMethodBeat.o(4220);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.zzi
 * JD-Core Version:    0.7.0.1
 */