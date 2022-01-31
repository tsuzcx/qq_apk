package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IFragmentWrapper$Stub$Proxy
  extends zza
  implements IFragmentWrapper
{
  IFragmentWrapper$Stub$Proxy(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
  }
  
  public IObjectWrapper getActivity()
  {
    AppMethodBeat.i(90369);
    Parcel localParcel = transactAndReadException(2, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    AppMethodBeat.o(90369);
    return localIObjectWrapper;
  }
  
  public Bundle getArguments()
  {
    AppMethodBeat.i(90370);
    Parcel localParcel = transactAndReadException(3, obtainAndWriteInterfaceToken());
    Bundle localBundle = (Bundle)zzc.zza(localParcel, Bundle.CREATOR);
    localParcel.recycle();
    AppMethodBeat.o(90370);
    return localBundle;
  }
  
  public int getId()
  {
    AppMethodBeat.i(90371);
    Parcel localParcel = transactAndReadException(4, obtainAndWriteInterfaceToken());
    int i = localParcel.readInt();
    localParcel.recycle();
    AppMethodBeat.o(90371);
    return i;
  }
  
  public IFragmentWrapper getParentFragment()
  {
    AppMethodBeat.i(90372);
    Parcel localParcel = transactAndReadException(5, obtainAndWriteInterfaceToken());
    IFragmentWrapper localIFragmentWrapper = IFragmentWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    AppMethodBeat.o(90372);
    return localIFragmentWrapper;
  }
  
  public IObjectWrapper getResources()
  {
    AppMethodBeat.i(90373);
    Parcel localParcel = transactAndReadException(6, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    AppMethodBeat.o(90373);
    return localIObjectWrapper;
  }
  
  public boolean getRetainInstance()
  {
    AppMethodBeat.i(90374);
    Parcel localParcel = transactAndReadException(7, obtainAndWriteInterfaceToken());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(90374);
    return bool;
  }
  
  public String getTag()
  {
    AppMethodBeat.i(90375);
    Parcel localParcel = transactAndReadException(8, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    AppMethodBeat.o(90375);
    return str;
  }
  
  public IFragmentWrapper getTargetFragment()
  {
    AppMethodBeat.i(90376);
    Parcel localParcel = transactAndReadException(9, obtainAndWriteInterfaceToken());
    IFragmentWrapper localIFragmentWrapper = IFragmentWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    AppMethodBeat.o(90376);
    return localIFragmentWrapper;
  }
  
  public int getTargetRequestCode()
  {
    AppMethodBeat.i(90377);
    Parcel localParcel = transactAndReadException(10, obtainAndWriteInterfaceToken());
    int i = localParcel.readInt();
    localParcel.recycle();
    AppMethodBeat.o(90377);
    return i;
  }
  
  public boolean getUserVisibleHint()
  {
    AppMethodBeat.i(90378);
    Parcel localParcel = transactAndReadException(11, obtainAndWriteInterfaceToken());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(90378);
    return bool;
  }
  
  public IObjectWrapper getView()
  {
    AppMethodBeat.i(90379);
    Parcel localParcel = transactAndReadException(12, obtainAndWriteInterfaceToken());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    AppMethodBeat.o(90379);
    return localIObjectWrapper;
  }
  
  public boolean isAdded()
  {
    AppMethodBeat.i(90380);
    Parcel localParcel = transactAndReadException(13, obtainAndWriteInterfaceToken());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(90380);
    return bool;
  }
  
  public boolean isDetached()
  {
    AppMethodBeat.i(90381);
    Parcel localParcel = transactAndReadException(14, obtainAndWriteInterfaceToken());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(90381);
    return bool;
  }
  
  public boolean isHidden()
  {
    AppMethodBeat.i(90382);
    Parcel localParcel = transactAndReadException(15, obtainAndWriteInterfaceToken());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(90382);
    return bool;
  }
  
  public boolean isInLayout()
  {
    AppMethodBeat.i(90383);
    Parcel localParcel = transactAndReadException(16, obtainAndWriteInterfaceToken());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(90383);
    return bool;
  }
  
  public boolean isRemoving()
  {
    AppMethodBeat.i(90384);
    Parcel localParcel = transactAndReadException(17, obtainAndWriteInterfaceToken());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(90384);
    return bool;
  }
  
  public boolean isResumed()
  {
    AppMethodBeat.i(90385);
    Parcel localParcel = transactAndReadException(18, obtainAndWriteInterfaceToken());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(90385);
    return bool;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(90386);
    Parcel localParcel = transactAndReadException(19, obtainAndWriteInterfaceToken());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(90386);
    return bool;
  }
  
  public void registerForContextMenu(IObjectWrapper paramIObjectWrapper)
  {
    AppMethodBeat.i(90387);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramIObjectWrapper);
    transactAndReadExceptionReturnVoid(20, localParcel);
    AppMethodBeat.o(90387);
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(90388);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramBoolean);
    transactAndReadExceptionReturnVoid(21, localParcel);
    AppMethodBeat.o(90388);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(90389);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramBoolean);
    transactAndReadExceptionReturnVoid(22, localParcel);
    AppMethodBeat.o(90389);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    AppMethodBeat.i(90390);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramBoolean);
    transactAndReadExceptionReturnVoid(23, localParcel);
    AppMethodBeat.o(90390);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(90391);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramBoolean);
    transactAndReadExceptionReturnVoid(24, localParcel);
    AppMethodBeat.o(90391);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(90392);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramIntent);
    transactAndReadExceptionReturnVoid(25, localParcel);
    AppMethodBeat.o(90392);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(90393);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramIntent);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(26, localParcel);
    AppMethodBeat.o(90393);
  }
  
  public void unregisterForContextMenu(IObjectWrapper paramIObjectWrapper)
  {
    AppMethodBeat.i(90394);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramIObjectWrapper);
    transactAndReadExceptionReturnVoid(27, localParcel);
    AppMethodBeat.o(90394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.dynamic.IFragmentWrapper.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */