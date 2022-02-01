package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaSessionCompat
{
  public static void d(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
    }
  }
  
  public static final class Token
    implements Parcelable
  {
    public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator() {};
    final Object MV;
    b MW;
    Bundle MX;
    
    Token(Object paramObject)
    {
      this(paramObject, null, (byte)0);
    }
    
    private Token(Object paramObject, b paramb)
    {
      this(paramObject, paramb, (byte)0);
    }
    
    private Token(Object paramObject, b paramb, byte paramByte)
    {
      this.MV = paramObject;
      this.MW = paramb;
      this.MX = null;
    }
    
    public static Token a(Object paramObject, b paramb)
    {
      if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21)) {
        return new Token(d.A(paramObject), paramb);
      }
      return null;
    }
    
    public static Token z(Object paramObject)
    {
      return a(paramObject, null);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof Token)) {
          return false;
        }
        paramObject = (Token)paramObject;
        if (this.MV != null) {
          break;
        }
      } while (paramObject.MV == null);
      return false;
      if (paramObject.MV == null) {
        return false;
      }
      return this.MV.equals(paramObject.MV);
    }
    
    public final int hashCode()
    {
      if (this.MV == null) {
        return 0;
      }
      return this.MV.hashCode();
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramParcel.writeParcelable((Parcelable)this.MV, paramInt);
        return;
      }
      paramParcel.writeStrongBinder((IBinder)this.MV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat
 * JD-Core Version:    0.7.0.1
 */