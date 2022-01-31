package android.support.v4.media.session;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

final class a$a$a
  implements a
{
  private IBinder mRemote;
  
  a$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  /* Error */
  public final void A(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: aload_3
    //   7: ldc 29
    //   9: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: ifeq +28 -> 41
    //   16: aload_3
    //   17: iload_2
    //   18: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   21: aload_0
    //   22: getfield 18	android/support/v4/media/session/a$a$a:mRemote	Landroid/os/IBinder;
    //   25: bipush 10
    //   27: aload_3
    //   28: aconst_null
    //   29: iconst_1
    //   30: invokeinterface 43 5 0
    //   35: pop
    //   36: aload_3
    //   37: invokevirtual 46	android/os/Parcel:recycle	()V
    //   40: return
    //   41: iconst_0
    //   42: istore_2
    //   43: goto -27 -> 16
    //   46: astore 4
    //   48: aload_3
    //   49: invokevirtual 46	android/os/Parcel:recycle	()V
    //   52: aload 4
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	a
    //   0	55	1	paramBoolean	boolean
    //   1	42	2	i	int
    //   5	44	3	localParcel	Parcel
    //   46	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	46	finally
    //   16	36	46	finally
  }
  
  /* Error */
  public final void B(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: aload_3
    //   7: ldc 29
    //   9: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: ifeq +28 -> 41
    //   16: aload_3
    //   17: iload_2
    //   18: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   21: aload_0
    //   22: getfield 18	android/support/v4/media/session/a$a$a:mRemote	Landroid/os/IBinder;
    //   25: bipush 11
    //   27: aload_3
    //   28: aconst_null
    //   29: iconst_1
    //   30: invokeinterface 43 5 0
    //   35: pop
    //   36: aload_3
    //   37: invokevirtual 46	android/os/Parcel:recycle	()V
    //   40: return
    //   41: iconst_0
    //   42: istore_2
    //   43: goto -27 -> 16
    //   46: astore 4
    //   48: aload_3
    //   49: invokevirtual 46	android/os/Parcel:recycle	()V
    //   52: aload 4
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	a
    //   0	55	1	paramBoolean	boolean
    //   1	42	2	i	int
    //   5	44	3	localParcel	Parcel
    //   46	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	46	finally
    //   16	36	46	finally
  }
  
  /* Error */
  public final void a(android.support.v4.media.MediaMetadataCompat paramMediaMetadataCompat)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 29
    //   7: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +33 -> 44
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 54	android/support/v4/media/MediaMetadataCompat:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 18	android/support/v4/media/session/a$a$a:mRemote	Landroid/os/IBinder;
    //   29: iconst_4
    //   30: aload_2
    //   31: aconst_null
    //   32: iconst_1
    //   33: invokeinterface 43 5 0
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 46	android/os/Parcel:recycle	()V
    //   43: return
    //   44: aload_2
    //   45: iconst_0
    //   46: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   49: goto -24 -> 25
    //   52: astore_1
    //   53: aload_2
    //   54: invokevirtual 46	android/os/Parcel:recycle	()V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	a
    //   0	59	1	paramMediaMetadataCompat	android.support.v4.media.MediaMetadataCompat
    //   3	51	2	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	52	finally
    //   14	25	52	finally
    //   25	39	52	finally
    //   44	49	52	finally
  }
  
  /* Error */
  public final void a(ParcelableVolumeInfo paramParcelableVolumeInfo)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 29
    //   7: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +34 -> 45
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 58	android/support/v4/media/session/ParcelableVolumeInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 18	android/support/v4/media/session/a$a$a:mRemote	Landroid/os/IBinder;
    //   29: bipush 8
    //   31: aload_2
    //   32: aconst_null
    //   33: iconst_1
    //   34: invokeinterface 43 5 0
    //   39: pop
    //   40: aload_2
    //   41: invokevirtual 46	android/os/Parcel:recycle	()V
    //   44: return
    //   45: aload_2
    //   46: iconst_0
    //   47: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   50: goto -25 -> 25
    //   53: astore_1
    //   54: aload_2
    //   55: invokevirtual 46	android/os/Parcel:recycle	()V
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	a
    //   0	60	1	paramParcelableVolumeInfo	ParcelableVolumeInfo
    //   3	52	2	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	53	finally
    //   14	25	53	finally
    //   25	40	53	finally
    //   45	50	53	finally
  }
  
  /* Error */
  public final void a(PlaybackStateCompat paramPlaybackStateCompat)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 29
    //   7: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +33 -> 44
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 62	android/support/v4/media/session/PlaybackStateCompat:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 18	android/support/v4/media/session/a$a$a:mRemote	Landroid/os/IBinder;
    //   29: iconst_3
    //   30: aload_2
    //   31: aconst_null
    //   32: iconst_1
    //   33: invokeinterface 43 5 0
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 46	android/os/Parcel:recycle	()V
    //   43: return
    //   44: aload_2
    //   45: iconst_0
    //   46: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   49: goto -24 -> 25
    //   52: astore_1
    //   53: aload_2
    //   54: invokevirtual 46	android/os/Parcel:recycle	()V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	a
    //   0	59	1	paramPlaybackStateCompat	PlaybackStateCompat
    //   3	51	2	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	52	finally
    //   14	25	52	finally
    //   25	39	52	finally
    //   44	49	52	finally
  }
  
  public final void ak(int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      localParcel.writeInt(paramInt);
      this.mRemote.transact(9, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public final void al(int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      localParcel.writeInt(paramInt);
      this.mRemote.transact(12, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  /* Error */
  public final void b(java.lang.String paramString, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 29
    //   7: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: aload_1
    //   12: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   15: aload_2
    //   16: ifnull +33 -> 49
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 74	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_0
    //   31: getfield 18	android/support/v4/media/session/a$a$a:mRemote	Landroid/os/IBinder;
    //   34: iconst_1
    //   35: aload_3
    //   36: aconst_null
    //   37: iconst_1
    //   38: invokeinterface 43 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 46	android/os/Parcel:recycle	()V
    //   48: return
    //   49: aload_3
    //   50: iconst_0
    //   51: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   54: goto -24 -> 30
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 46	android/os/Parcel:recycle	()V
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	a
    //   0	64	1	paramString	java.lang.String
    //   0	64	2	paramBundle	android.os.Bundle
    //   3	56	3	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	15	57	finally
    //   19	30	57	finally
    //   30	44	57	finally
    //   49	54	57	finally
  }
  
  public final void cE()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      this.mRemote.transact(13, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public final void onExtrasChanged(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 29
    //   7: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +34 -> 45
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 74	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 18	android/support/v4/media/session/a$a$a:mRemote	Landroid/os/IBinder;
    //   29: bipush 7
    //   31: aload_2
    //   32: aconst_null
    //   33: iconst_1
    //   34: invokeinterface 43 5 0
    //   39: pop
    //   40: aload_2
    //   41: invokevirtual 46	android/os/Parcel:recycle	()V
    //   44: return
    //   45: aload_2
    //   46: iconst_0
    //   47: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   50: goto -25 -> 25
    //   53: astore_1
    //   54: aload_2
    //   55: invokevirtual 46	android/os/Parcel:recycle	()V
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	a
    //   0	60	1	paramBundle	android.os.Bundle
    //   3	52	2	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	53	finally
    //   14	25	53	finally
    //   25	40	53	finally
    //   45	50	53	finally
  }
  
  public final void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      localParcel.writeTypedList(paramList);
      this.mRemote.transact(5, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public final void onQueueTitleChanged(java.lang.CharSequence paramCharSequence)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 29
    //   7: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +34 -> 45
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokestatic 91	android/text/TextUtils:writeToParcel	(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 18	android/support/v4/media/session/a$a$a:mRemote	Landroid/os/IBinder;
    //   29: bipush 6
    //   31: aload_2
    //   32: aconst_null
    //   33: iconst_1
    //   34: invokeinterface 43 5 0
    //   39: pop
    //   40: aload_2
    //   41: invokevirtual 46	android/os/Parcel:recycle	()V
    //   44: return
    //   45: aload_2
    //   46: iconst_0
    //   47: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   50: goto -25 -> 25
    //   53: astore_1
    //   54: aload_2
    //   55: invokevirtual 46	android/os/Parcel:recycle	()V
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	a
    //   0	60	1	paramCharSequence	java.lang.CharSequence
    //   3	52	2	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	53	finally
    //   14	25	53	finally
    //   25	40	53	finally
    //   45	50	53	finally
  }
  
  public final void onSessionDestroyed()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      this.mRemote.transact(2, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.session.a.a.a
 * JD-Core Version:    0.7.0.1
 */