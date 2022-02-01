package com.tencent.mm.plugin.emoji.magicemoji;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
  extends IInterface
{
  public abstract void Kk(int paramInt);
  
  public abstract String bd(int paramInt, String paramString);
  
  public abstract void dyt();
  
  public abstract void dyu();
  
  public abstract void dyv();
  
  public abstract void dyw();
  
  public abstract void dyx();
  
  public static abstract class a
    extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
    }
    
    public static b D(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
      if ((localIInterface != null) && ((localIInterface instanceof b))) {
        return (b)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static b dyy()
    {
      return a.xHV;
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
        paramParcel1 = bd(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
        dyt();
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
        dyu();
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
        dyv();
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
        dyw();
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
        dyx();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
      Kk(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements b
    {
      public static b xHV;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void Kk(int paramInt)
      {
        AppMethodBeat.i(269989);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (b.a.dyy() != null))
          {
            b.a.dyy().Kk(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269989);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final String bd(int paramInt, String paramString)
      {
        AppMethodBeat.i(269944);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (b.a.dyy() != null))
          {
            paramString = b.a.dyy().bd(paramInt, paramString);
            return paramString;
          }
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269944);
        }
      }
      
      public final void dyt()
      {
        AppMethodBeat.i(269948);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (b.a.dyy() != null))
          {
            b.a.dyy().dyt();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269948);
        }
      }
      
      public final void dyu()
      {
        AppMethodBeat.i(269951);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (b.a.dyy() != null))
          {
            b.a.dyy().dyu();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269951);
        }
      }
      
      public final void dyv()
      {
        AppMethodBeat.i(269965);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (b.a.dyy() != null))
          {
            b.a.dyy().dyv();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269965);
        }
      }
      
      public final void dyw()
      {
        AppMethodBeat.i(269972);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (b.a.dyy() != null))
          {
            b.a.dyy().dyw();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269972);
        }
      }
      
      public final void dyx()
      {
        AppMethodBeat.i(269978);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.emoji.magicemoji.IMagicEmojiServiceCallback");
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (b.a.dyy() != null))
          {
            b.a.dyy().dyx();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(269978);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.b
 * JD-Core Version:    0.7.0.1
 */