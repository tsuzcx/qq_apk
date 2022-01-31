package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;

public abstract class a$a
  extends Binder
  implements a
{
  public a$a()
  {
    attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
  }
  
  public static a b(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new a.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = false;
    String str = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      str = paramParcel1.readString();
      paramParcel2 = localObject1;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      b(str, paramParcel2);
      return true;
    case 2: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      onSessionDestroyed();
      return true;
    case 3: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      paramParcel2 = str;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 4: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      paramParcel2 = localObject2;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 5: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      onQueueChanged(paramParcel1.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
      return true;
    case 6: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      paramParcel2 = localObject3;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel1);
      }
      onQueueTitleChanged(paramParcel2);
      return true;
    case 7: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      paramParcel2 = localObject4;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      onExtrasChanged(paramParcel2);
      return true;
    case 8: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      paramParcel2 = localObject5;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 9: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      ak(paramParcel1.readInt());
      return true;
    case 10: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      if (paramParcel1.readInt() != 0) {}
      for (bool = true;; bool = false)
      {
        A(bool);
        return true;
      }
    case 11: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      B(bool);
      return true;
    case 12: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      al(paramParcel1.readInt());
      return true;
    }
    paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
    cE();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.media.session.a.a
 * JD-Core Version:    0.7.0.1
 */