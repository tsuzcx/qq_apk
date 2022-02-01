package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class IFragmentWrapper$Stub
  extends zzb
  implements IFragmentWrapper
{
  private byte _hellAccFlag_;
  
  public IFragmentWrapper$Stub()
  {
    super("com.google.android.gms.dynamic.IFragmentWrapper");
  }
  
  public static IFragmentWrapper asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
    if ((localIInterface instanceof IFragmentWrapper)) {
      return (IFragmentWrapper)localIInterface;
    }
    return new Proxy(paramIBinder);
  }
  
  public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 2: 
      paramParcel1 = getActivity();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, paramParcel1);
    }
    for (;;)
    {
      return true;
      paramParcel1 = getArguments();
      paramParcel2.writeNoException();
      zzc.zzb(paramParcel2, paramParcel1);
      continue;
      paramInt1 = getId();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      continue;
      paramParcel1 = getParentFragment();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, paramParcel1);
      continue;
      paramParcel1 = getResources();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, paramParcel1);
      continue;
      boolean bool = getRetainInstance();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, bool);
      continue;
      paramParcel1 = getTag();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      continue;
      paramParcel1 = getTargetFragment();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, paramParcel1);
      continue;
      paramInt1 = getTargetRequestCode();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      continue;
      bool = getUserVisibleHint();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, bool);
      continue;
      paramParcel1 = getView();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, paramParcel1);
      continue;
      bool = isAdded();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, bool);
      continue;
      bool = isDetached();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, bool);
      continue;
      bool = isHidden();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, bool);
      continue;
      bool = isInLayout();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, bool);
      continue;
      bool = isRemoving();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, bool);
      continue;
      bool = isResumed();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, bool);
      continue;
      bool = isVisible();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, bool);
      continue;
      registerForContextMenu(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      setHasOptionsMenu(zzc.zza(paramParcel1));
      paramParcel2.writeNoException();
      continue;
      setMenuVisibility(zzc.zza(paramParcel1));
      paramParcel2.writeNoException();
      continue;
      setRetainInstance(zzc.zza(paramParcel1));
      paramParcel2.writeNoException();
      continue;
      setUserVisibleHint(zzc.zza(paramParcel1));
      paramParcel2.writeNoException();
      continue;
      paramParcel1 = (Intent)zzc.zza(paramParcel1, Intent.CREATOR);
      paramParcel1 = new com.tencent.mm.hellhoundlib.b.a().bm(paramParcel1);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramParcel1.aFh(), "com/google/android/gms/dynamic/IFragmentWrapper$Stub", "dispatchTransaction", "(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramParcel1.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/google/android/gms/dynamic/IFragmentWrapper$Stub", "dispatchTransaction", "(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramParcel2.writeNoException();
      continue;
      startActivityForResult((Intent)zzc.zza(paramParcel1, Intent.CREATOR), paramParcel1.readInt());
      paramParcel2.writeNoException();
      continue;
      unregisterForContextMenu(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
  }
  
  public static class Proxy
    extends zza
    implements IFragmentWrapper
  {
    Proxy(IBinder paramIBinder)
    {
      super("com.google.android.gms.dynamic.IFragmentWrapper");
    }
    
    public IObjectWrapper getActivity()
    {
      AppMethodBeat.i(5390);
      Parcel localParcel = transactAndReadException(2, obtainAndWriteInterfaceToken());
      IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
      localParcel.recycle();
      AppMethodBeat.o(5390);
      return localIObjectWrapper;
    }
    
    public Bundle getArguments()
    {
      AppMethodBeat.i(5391);
      Parcel localParcel = transactAndReadException(3, obtainAndWriteInterfaceToken());
      Bundle localBundle = (Bundle)zzc.zza(localParcel, Bundle.CREATOR);
      localParcel.recycle();
      AppMethodBeat.o(5391);
      return localBundle;
    }
    
    public int getId()
    {
      AppMethodBeat.i(5392);
      Parcel localParcel = transactAndReadException(4, obtainAndWriteInterfaceToken());
      int i = localParcel.readInt();
      localParcel.recycle();
      AppMethodBeat.o(5392);
      return i;
    }
    
    public IFragmentWrapper getParentFragment()
    {
      AppMethodBeat.i(5393);
      Parcel localParcel = transactAndReadException(5, obtainAndWriteInterfaceToken());
      IFragmentWrapper localIFragmentWrapper = IFragmentWrapper.Stub.asInterface(localParcel.readStrongBinder());
      localParcel.recycle();
      AppMethodBeat.o(5393);
      return localIFragmentWrapper;
    }
    
    public IObjectWrapper getResources()
    {
      AppMethodBeat.i(5394);
      Parcel localParcel = transactAndReadException(6, obtainAndWriteInterfaceToken());
      IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
      localParcel.recycle();
      AppMethodBeat.o(5394);
      return localIObjectWrapper;
    }
    
    public boolean getRetainInstance()
    {
      AppMethodBeat.i(5395);
      Parcel localParcel = transactAndReadException(7, obtainAndWriteInterfaceToken());
      boolean bool = zzc.zza(localParcel);
      localParcel.recycle();
      AppMethodBeat.o(5395);
      return bool;
    }
    
    public String getTag()
    {
      AppMethodBeat.i(5396);
      Parcel localParcel = transactAndReadException(8, obtainAndWriteInterfaceToken());
      String str = localParcel.readString();
      localParcel.recycle();
      AppMethodBeat.o(5396);
      return str;
    }
    
    public IFragmentWrapper getTargetFragment()
    {
      AppMethodBeat.i(5397);
      Parcel localParcel = transactAndReadException(9, obtainAndWriteInterfaceToken());
      IFragmentWrapper localIFragmentWrapper = IFragmentWrapper.Stub.asInterface(localParcel.readStrongBinder());
      localParcel.recycle();
      AppMethodBeat.o(5397);
      return localIFragmentWrapper;
    }
    
    public int getTargetRequestCode()
    {
      AppMethodBeat.i(5398);
      Parcel localParcel = transactAndReadException(10, obtainAndWriteInterfaceToken());
      int i = localParcel.readInt();
      localParcel.recycle();
      AppMethodBeat.o(5398);
      return i;
    }
    
    public boolean getUserVisibleHint()
    {
      AppMethodBeat.i(5399);
      Parcel localParcel = transactAndReadException(11, obtainAndWriteInterfaceToken());
      boolean bool = zzc.zza(localParcel);
      localParcel.recycle();
      AppMethodBeat.o(5399);
      return bool;
    }
    
    public IObjectWrapper getView()
    {
      AppMethodBeat.i(5400);
      Parcel localParcel = transactAndReadException(12, obtainAndWriteInterfaceToken());
      IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
      localParcel.recycle();
      AppMethodBeat.o(5400);
      return localIObjectWrapper;
    }
    
    public boolean isAdded()
    {
      AppMethodBeat.i(5401);
      Parcel localParcel = transactAndReadException(13, obtainAndWriteInterfaceToken());
      boolean bool = zzc.zza(localParcel);
      localParcel.recycle();
      AppMethodBeat.o(5401);
      return bool;
    }
    
    public boolean isDetached()
    {
      AppMethodBeat.i(5402);
      Parcel localParcel = transactAndReadException(14, obtainAndWriteInterfaceToken());
      boolean bool = zzc.zza(localParcel);
      localParcel.recycle();
      AppMethodBeat.o(5402);
      return bool;
    }
    
    public boolean isHidden()
    {
      AppMethodBeat.i(5403);
      Parcel localParcel = transactAndReadException(15, obtainAndWriteInterfaceToken());
      boolean bool = zzc.zza(localParcel);
      localParcel.recycle();
      AppMethodBeat.o(5403);
      return bool;
    }
    
    public boolean isInLayout()
    {
      AppMethodBeat.i(5404);
      Parcel localParcel = transactAndReadException(16, obtainAndWriteInterfaceToken());
      boolean bool = zzc.zza(localParcel);
      localParcel.recycle();
      AppMethodBeat.o(5404);
      return bool;
    }
    
    public boolean isRemoving()
    {
      AppMethodBeat.i(5405);
      Parcel localParcel = transactAndReadException(17, obtainAndWriteInterfaceToken());
      boolean bool = zzc.zza(localParcel);
      localParcel.recycle();
      AppMethodBeat.o(5405);
      return bool;
    }
    
    public boolean isResumed()
    {
      AppMethodBeat.i(5406);
      Parcel localParcel = transactAndReadException(18, obtainAndWriteInterfaceToken());
      boolean bool = zzc.zza(localParcel);
      localParcel.recycle();
      AppMethodBeat.o(5406);
      return bool;
    }
    
    public boolean isVisible()
    {
      AppMethodBeat.i(5407);
      Parcel localParcel = transactAndReadException(19, obtainAndWriteInterfaceToken());
      boolean bool = zzc.zza(localParcel);
      localParcel.recycle();
      AppMethodBeat.o(5407);
      return bool;
    }
    
    public void registerForContextMenu(IObjectWrapper paramIObjectWrapper)
    {
      AppMethodBeat.i(5408);
      Parcel localParcel = obtainAndWriteInterfaceToken();
      zzc.zza(localParcel, paramIObjectWrapper);
      transactAndReadExceptionReturnVoid(20, localParcel);
      AppMethodBeat.o(5408);
    }
    
    public void setHasOptionsMenu(boolean paramBoolean)
    {
      AppMethodBeat.i(5409);
      Parcel localParcel = obtainAndWriteInterfaceToken();
      zzc.zza(localParcel, paramBoolean);
      transactAndReadExceptionReturnVoid(21, localParcel);
      AppMethodBeat.o(5409);
    }
    
    public void setMenuVisibility(boolean paramBoolean)
    {
      AppMethodBeat.i(5410);
      Parcel localParcel = obtainAndWriteInterfaceToken();
      zzc.zza(localParcel, paramBoolean);
      transactAndReadExceptionReturnVoid(22, localParcel);
      AppMethodBeat.o(5410);
    }
    
    public void setRetainInstance(boolean paramBoolean)
    {
      AppMethodBeat.i(5411);
      Parcel localParcel = obtainAndWriteInterfaceToken();
      zzc.zza(localParcel, paramBoolean);
      transactAndReadExceptionReturnVoid(23, localParcel);
      AppMethodBeat.o(5411);
    }
    
    public void setUserVisibleHint(boolean paramBoolean)
    {
      AppMethodBeat.i(5412);
      Parcel localParcel = obtainAndWriteInterfaceToken();
      zzc.zza(localParcel, paramBoolean);
      transactAndReadExceptionReturnVoid(24, localParcel);
      AppMethodBeat.o(5412);
    }
    
    public void startActivity(Intent paramIntent)
    {
      AppMethodBeat.i(5413);
      Parcel localParcel = obtainAndWriteInterfaceToken();
      zzc.zza(localParcel, paramIntent);
      transactAndReadExceptionReturnVoid(25, localParcel);
      AppMethodBeat.o(5413);
    }
    
    public void startActivityForResult(Intent paramIntent, int paramInt)
    {
      AppMethodBeat.i(5414);
      Parcel localParcel = obtainAndWriteInterfaceToken();
      zzc.zza(localParcel, paramIntent);
      localParcel.writeInt(paramInt);
      transactAndReadExceptionReturnVoid(26, localParcel);
      AppMethodBeat.o(5414);
    }
    
    public void unregisterForContextMenu(IObjectWrapper paramIObjectWrapper)
    {
      AppMethodBeat.i(5415);
      Parcel localParcel = obtainAndWriteInterfaceToken();
      zzc.zza(localParcel, paramIObjectWrapper);
      transactAndReadExceptionReturnVoid(27, localParcel);
      AppMethodBeat.o(5415);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.dynamic.IFragmentWrapper.Stub
 * JD-Core Version:    0.7.0.1
 */