package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.RatingCompat;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

final class b$a$a
  implements b
{
  private IBinder mRemote;
  
  b$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final void C(boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.mRemote.transact(46, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void D(boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.mRemote.transact(40, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeString(paramString);
      this.mRemote.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final void a(android.support.v4.media.MediaDescriptionCompat paramMediaDescriptionCompat)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 61	android/support/v4/media/MediaDescriptionCompat:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   33: bipush 41
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 43 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 46	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 49	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 49	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 49	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 49	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	a
    //   0	76	1	paramMediaDescriptionCompat	android.support.v4.media.MediaDescriptionCompat
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  public final void a(android.support.v4.media.MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 29
    //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +50 -> 66
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   24: aload_1
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 61	android/support/v4/media/MediaDescriptionCompat:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_3
    //   31: iload_2
    //   32: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   35: aload_0
    //   36: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 42
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 43 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 46	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 49	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aload_3
    //   67: iconst_0
    //   68: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   71: goto -41 -> 30
    //   74: astore_1
    //   75: aload 4
    //   77: invokevirtual 49	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 49	android/os/Parcel:recycle	()V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	a
    //   0	86	1	paramMediaDescriptionCompat	android.support.v4.media.MediaDescriptionCompat
    //   0	86	2	paramInt	int
    //   3	78	3	localParcel1	Parcel
    //   7	69	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	74	finally
    //   19	30	74	finally
    //   30	56	74	finally
    //   66	71	74	finally
  }
  
  /* Error */
  public final void a(RatingCompat paramRatingCompat)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 66	android/support/v4/media/RatingCompat:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   33: bipush 25
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 43 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 46	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 49	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 49	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 49	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 49	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	a
    //   0	76	1	paramRatingCompat	RatingCompat
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  public final void a(RatingCompat paramRatingCompat, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (paramRatingCompat != null)
        {
          localParcel1.writeInt(1);
          paramRatingCompat.writeToParcel(localParcel1, 0);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.mRemote.transact(51, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public final void a(a parama)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_1
    //   19: invokeinterface 77 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 80	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   34: iconst_3
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 43 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 46	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 49	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 49	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 49	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 49	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	a
    //   0	73	1	parama	a
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
  
  public final void a(String paramString, Bundle paramBundle, MediaSessionCompat.ResultReceiverWrapper paramResultReceiverWrapper)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        localParcel1.writeString(paramString);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          if (paramResultReceiverWrapper != null)
          {
            localParcel1.writeInt(1);
            paramResultReceiverWrapper.writeToParcel(localParcel1, 0);
            this.mRemote.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final boolean a(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (paramKeyEvent != null)
        {
          localParcel1.writeInt(1);
          paramKeyEvent.writeToParcel(localParcel1, 0);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            return bool;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        bool = false;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void am(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(44, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void an(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(48, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeString(paramString);
      this.mRemote.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final void b(android.support.v4.media.MediaDescriptionCompat paramMediaDescriptionCompat)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 61	android/support/v4/media/MediaDescriptionCompat:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   33: bipush 43
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 43 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 46	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 49	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 49	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 49	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 49	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	a
    //   0	76	1	paramMediaDescriptionCompat	android.support.v4.media.MediaDescriptionCompat
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  public final void b(a parama)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_1
    //   19: invokeinterface 77 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 80	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   34: iconst_4
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 43 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 46	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 49	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 49	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 49	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 49	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	a
    //   0	73	1	parama	a
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
  
  public final boolean cF()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final android.app.PendingIntent cG()
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   18: bipush 8
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface 43 5 0
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 46	android/os/Parcel:readException	()V
    //   33: aload_3
    //   34: invokevirtual 92	android/os/Parcel:readInt	()I
    //   37: ifeq +26 -> 63
    //   40: getstatic 105	android/app/PendingIntent:CREATOR	Landroid/os/Parcelable$Creator;
    //   43: aload_3
    //   44: invokeinterface 111 2 0
    //   49: checkcast 101	android/app/PendingIntent
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 49	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 49	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 49	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   52	13	1	localPendingIntent	android.app.PendingIntent
    //   68	10	1	localObject	Object
    //   3	71	2	localParcel1	Parcel
    //   7	63	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	53	68	finally
  }
  
  /* Error */
  public final ParcelableVolumeInfo cH()
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   18: bipush 10
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface 43 5 0
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 46	android/os/Parcel:readException	()V
    //   33: aload_3
    //   34: invokevirtual 92	android/os/Parcel:readInt	()I
    //   37: ifeq +26 -> 63
    //   40: getstatic 116	android/support/v4/media/session/ParcelableVolumeInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   43: aload_3
    //   44: invokeinterface 111 2 0
    //   49: checkcast 115	android/support/v4/media/session/ParcelableVolumeInfo
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 49	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 49	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 49	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   52	13	1	localParcelableVolumeInfo	ParcelableVolumeInfo
    //   68	10	1	localObject	Object
    //   3	71	2	localParcel1	Parcel
    //   7	63	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	53	68	finally
  }
  
  /* Error */
  public final android.support.v4.media.MediaMetadataCompat cI()
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   18: bipush 27
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface 43 5 0
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 46	android/os/Parcel:readException	()V
    //   33: aload_3
    //   34: invokevirtual 92	android/os/Parcel:readInt	()I
    //   37: ifeq +26 -> 63
    //   40: getstatic 121	android/support/v4/media/MediaMetadataCompat:CREATOR	Landroid/os/Parcelable$Creator;
    //   43: aload_3
    //   44: invokeinterface 111 2 0
    //   49: checkcast 120	android/support/v4/media/MediaMetadataCompat
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 49	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 49	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 49	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   52	13	1	localMediaMetadataCompat	android.support.v4.media.MediaMetadataCompat
    //   68	10	1	localObject	Object
    //   3	71	2	localParcel1	Parcel
    //   7	63	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	53	68	finally
  }
  
  /* Error */
  public final PlaybackStateCompat cJ()
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   18: bipush 28
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface 43 5 0
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 46	android/os/Parcel:readException	()V
    //   33: aload_3
    //   34: invokevirtual 92	android/os/Parcel:readInt	()I
    //   37: ifeq +26 -> 63
    //   40: getstatic 126	android/support/v4/media/session/PlaybackStateCompat:CREATOR	Landroid/os/Parcelable$Creator;
    //   43: aload_3
    //   44: invokeinterface 111 2 0
    //   49: checkcast 125	android/support/v4/media/session/PlaybackStateCompat
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 49	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 49	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 49	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   52	13	1	localPlaybackStateCompat	PlaybackStateCompat
    //   68	10	1	localObject	Object
    //   3	71	2	localParcel1	Parcel
    //   7	63	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	53	68	finally
  }
  
  public final boolean cK()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(45, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final boolean cL()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(38, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final int cM()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(47, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void cN()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(20, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void cO()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(21, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void fastForward()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(22, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final Bundle getExtras()
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   18: bipush 31
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface 43 5 0
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 46	android/os/Parcel:readException	()V
    //   33: aload_3
    //   34: invokevirtual 92	android/os/Parcel:readInt	()I
    //   37: ifeq +26 -> 63
    //   40: getstatic 135	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
    //   43: aload_3
    //   44: invokeinterface 111 2 0
    //   49: checkcast 69	android/os/Bundle
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 49	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 49	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 49	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   52	13	1	localBundle	Bundle
    //   68	10	1	localObject	Object
    //   3	71	2	localParcel1	Parcel
    //   7	63	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	53	68	finally
  }
  
  public final long getFlags()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      long l = localParcel2.readLong();
      return l;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final String getPackageName()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final List<MediaSessionCompat.QueueItem> getQueue()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(29, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ArrayList localArrayList = localParcel2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
      return localArrayList;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final java.lang.CharSequence getQueueTitle()
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   18: bipush 30
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface 43 5 0
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 46	android/os/Parcel:readException	()V
    //   33: aload_3
    //   34: invokevirtual 92	android/os/Parcel:readInt	()I
    //   37: ifeq +26 -> 63
    //   40: getstatic 163	android/text/TextUtils:CHAR_SEQUENCE_CREATOR	Landroid/os/Parcelable$Creator;
    //   43: aload_3
    //   44: invokeinterface 111 2 0
    //   49: checkcast 165	java/lang/CharSequence
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 49	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 49	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 49	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   52	13	1	localCharSequence	java.lang.CharSequence
    //   68	10	1	localObject	Object
    //   3	71	2	localParcel1	Parcel
    //   7	63	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	53	68	finally
  }
  
  public final int getRatingType()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(32, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final int getRepeatMode()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(37, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final String getTag()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void pause()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(18, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void play()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(13, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final void playFromMediaId(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 29
    //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +45 -> 66
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 70	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 14
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 43 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 46	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 49	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aload_3
    //   67: iconst_0
    //   68: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   71: goto -36 -> 35
    //   74: astore_1
    //   75: aload 4
    //   77: invokevirtual 49	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 49	android/os/Parcel:recycle	()V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	a
    //   0	86	1	paramString	String
    //   0	86	2	paramBundle	Bundle
    //   3	78	3	localParcel1	Parcel
    //   7	69	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	74	finally
    //   24	35	74	finally
    //   35	56	74	finally
    //   66	71	74	finally
  }
  
  /* Error */
  public final void playFromSearch(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 29
    //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +45 -> 66
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 70	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 15
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 43 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 46	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 49	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aload_3
    //   67: iconst_0
    //   68: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   71: goto -36 -> 35
    //   74: astore_1
    //   75: aload 4
    //   77: invokevirtual 49	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 49	android/os/Parcel:recycle	()V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	a
    //   0	86	1	paramString	String
    //   0	86	2	paramBundle	Bundle
    //   3	78	3	localParcel1	Parcel
    //   7	69	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	74	finally
    //   24	35	74	finally
    //   35	56	74	finally
    //   66	71	74	finally
  }
  
  public final void playFromUri(Uri paramUri, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (paramUri != null)
        {
          localParcel1.writeInt(1);
          paramUri.writeToParcel(localParcel1, 0);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.mRemote.transact(16, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void prepare()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(33, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final void prepareFromMediaId(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 29
    //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +45 -> 66
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 70	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 34
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 43 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 46	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 49	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aload_3
    //   67: iconst_0
    //   68: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   71: goto -36 -> 35
    //   74: astore_1
    //   75: aload 4
    //   77: invokevirtual 49	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 49	android/os/Parcel:recycle	()V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	a
    //   0	86	1	paramString	String
    //   0	86	2	paramBundle	Bundle
    //   3	78	3	localParcel1	Parcel
    //   7	69	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	74	finally
    //   24	35	74	finally
    //   35	56	74	finally
    //   66	71	74	finally
  }
  
  /* Error */
  public final void prepareFromSearch(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 29
    //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +45 -> 66
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 70	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 35
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 43 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 46	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 49	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aload_3
    //   67: iconst_0
    //   68: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   71: goto -36 -> 35
    //   74: astore_1
    //   75: aload 4
    //   77: invokevirtual 49	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 49	android/os/Parcel:recycle	()V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	a
    //   0	86	1	paramString	String
    //   0	86	2	paramBundle	Bundle
    //   3	78	3	localParcel1	Parcel
    //   7	69	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	74	finally
    //   24	35	74	finally
    //   35	56	74	finally
    //   66	71	74	finally
  }
  
  public final void prepareFromUri(Uri paramUri, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
        if (paramUri != null)
        {
          localParcel1.writeInt(1);
          paramUri.writeToParcel(localParcel1, 0);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.mRemote.transact(36, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void rewind()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(23, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void seekTo(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      localParcel1.writeLong(paramLong);
      this.mRemote.transact(24, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final void sendCustomAction(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 29
    //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +45 -> 66
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 70	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 18	android/support/v4/media/session/b$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 26
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 43 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 46	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 49	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aload_3
    //   67: iconst_0
    //   68: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   71: goto -36 -> 35
    //   74: astore_1
    //   75: aload 4
    //   77: invokevirtual 49	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 49	android/os/Parcel:recycle	()V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	a
    //   0	86	1	paramString	String
    //   0	86	2	paramBundle	Bundle
    //   3	78	3	localParcel1	Parcel
    //   7	69	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	74	finally
    //   24	35	74	finally
    //   35	56	74	finally
    //   66	71	74	finally
  }
  
  public final void setRepeatMode(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(39, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void skipToQueueItem(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      localParcel1.writeLong(paramLong);
      this.mRemote.transact(17, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void stop()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(19, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.session.b.a.a
 * JD-Core Version:    0.7.0.1
 */