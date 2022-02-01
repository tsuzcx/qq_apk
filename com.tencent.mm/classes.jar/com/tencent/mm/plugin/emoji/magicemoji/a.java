package com.tencent.mm.plugin.emoji.magicemoji;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.magicemoji.bean.WxaPkgRecordForME;

public abstract interface a
  extends IInterface
{
  public abstract void a(b paramb);
  
  public abstract void a(WxaPkgRecordForME paramWxaPkgRecordForME);
  
  public abstract void b(b paramb);
  
  public abstract void bc(int paramInt, String paramString);
  
  public abstract void d(Surface paramSurface, int paramInt1, int paramInt2);
  
  public abstract void dyp();
  
  public abstract void dyq();
  
  public abstract void dyr();
  
  public abstract void gP(int paramInt1, int paramInt2);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
    }
    
    public static a C(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static a dys()
    {
      return a.xHU;
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
        bc(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Surface)Surface.CREATOR.createFromParcel(paramParcel1);
        }
        d((Surface)localObject1, paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
        gP(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
        dyp();
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (WxaPkgRecordForME)WxaPkgRecordForME.CREATOR.createFromParcel(paramParcel1);
        }
        a((WxaPkgRecordForME)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
        dyq();
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
        dyr();
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
        a(b.a.D(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
      b(b.a.D(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements a
    {
      public static a xHU;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(b paramb)
      {
        AppMethodBeat.i(270013);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
          if (paramb != null) {}
          for (IBinder localIBinder = paramb.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(8, localParcel1, localParcel2, 0)) || (a.a.dys() == null)) {
              break;
            }
            a.a.dys().a(paramb);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(270013);
        }
      }
      
      public final void a(WxaPkgRecordForME paramWxaPkgRecordForME)
      {
        AppMethodBeat.i(269988);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
          if (paramWxaPkgRecordForME != null)
          {
            localParcel1.writeInt(1);
            paramWxaPkgRecordForME.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (a.a.dys() != null))
          {
            a.a.dys().a(paramWxaPkgRecordForME);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269988);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(269988);
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void b(b paramb)
      {
        AppMethodBeat.i(270020);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
          if (paramb != null) {}
          for (IBinder localIBinder = paramb.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(9, localParcel1, localParcel2, 0)) || (a.a.dys() == null)) {
              break;
            }
            a.a.dys().b(paramb);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(270020);
        }
      }
      
      public final void bc(int paramInt, String paramString)
      {
        AppMethodBeat.i(269959);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (a.a.dys() != null))
          {
            a.a.dys().bc(paramInt, paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269959);
        }
      }
      
      public final void d(Surface paramSurface, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(269964);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
          if (paramSurface != null)
          {
            localParcel1.writeInt(1);
            paramSurface.writeToParcel(localParcel1, 0);
          }
          for (;;)
          {
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            if ((this.mRemote.transact(2, localParcel1, localParcel2, 0)) || (a.a.dys() == null)) {
              break;
            }
            a.a.dys().d(paramSurface, paramInt1, paramInt2);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269964);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(269964);
      }
      
      public final void dyp()
      {
        AppMethodBeat.i(269977);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (a.a.dys() != null))
          {
            a.a.dys().dyp();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269977);
        }
      }
      
      public final void dyq()
      {
        AppMethodBeat.i(269997);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (a.a.dys() != null))
          {
            a.a.dys().dyq();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269997);
        }
      }
      
      public final void dyr()
      {
        AppMethodBeat.i(270004);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (a.a.dys() != null))
          {
            a.a.dys().dyr();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(270004);
        }
      }
      
      public final void gP(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(269971);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiService");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (a.a.dys() != null))
          {
            a.a.dys().gP(paramInt1, paramInt2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269971);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.a
 * JD-Core Version:    0.7.0.1
 */