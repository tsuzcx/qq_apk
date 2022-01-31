package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;

public abstract class IFragmentWrapper$Stub
  extends zzb
  implements IFragmentWrapper
{
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
    return new IFragmentWrapper.Stub.Proxy(paramIBinder);
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
      startActivity((Intent)zzc.zza(paramParcel1, Intent.CREATOR));
      paramParcel2.writeNoException();
      continue;
      startActivityForResult((Intent)zzc.zza(paramParcel1, Intent.CREATOR), paramParcel1.readInt());
      paramParcel2.writeNoException();
      continue;
      unregisterForContextMenu(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.dynamic.IFragmentWrapper.Stub
 * JD-Core Version:    0.7.0.1
 */