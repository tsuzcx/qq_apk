package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class MediaSessionCompat$Token
  implements Parcelable
{
  public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator() {};
  final Object JY;
  b JZ;
  Bundle Ka;
  
  MediaSessionCompat$Token(Object paramObject)
  {
    this(paramObject, null, (byte)0);
  }
  
  private MediaSessionCompat$Token(Object paramObject, b paramb)
  {
    this(paramObject, paramb, (byte)0);
  }
  
  private MediaSessionCompat$Token(Object paramObject, b paramb, byte paramByte)
  {
    this.JY = paramObject;
    this.JZ = paramb;
    this.Ka = null;
  }
  
  public static Token a(Object paramObject, b paramb)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21)) {
      return new Token(d.x(paramObject), paramb);
    }
    return null;
  }
  
  public static Token w(Object paramObject)
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
      if (this.JY != null) {
        break;
      }
    } while (paramObject.JY == null);
    return false;
    if (paramObject.JY == null) {
      return false;
    }
    return this.JY.equals(paramObject.JY);
  }
  
  public final int hashCode()
  {
    if (this.JY == null) {
      return 0;
    }
    return this.JY.hashCode();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramParcel.writeParcelable((Parcelable)this.JY, paramInt);
      return;
    }
    paramParcel.writeStrongBinder((IBinder)this.JY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.Token
 * JD-Core Version:    0.7.0.1
 */