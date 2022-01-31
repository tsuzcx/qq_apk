package android.support.v4.media.session;

import android.media.session.MediaSession.Token;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class MediaSessionCompat$Token
  implements Parcelable
{
  public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator() {};
  final Object CA;
  final b Cn;
  
  MediaSessionCompat$Token(Object paramObject)
  {
    this(paramObject, null);
  }
  
  private MediaSessionCompat$Token(Object paramObject, b paramb)
  {
    this.CA = paramObject;
    this.Cn = paramb;
  }
  
  public static Token a(Object paramObject, b paramb)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      if ((paramObject instanceof MediaSession.Token)) {
        return new Token(paramObject, paramb);
      }
      throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
    return null;
  }
  
  public static Token x(Object paramObject)
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
      if (this.CA != null) {
        break;
      }
    } while (paramObject.CA == null);
    return false;
    if (paramObject.CA == null) {
      return false;
    }
    return this.CA.equals(paramObject.CA);
  }
  
  public final int hashCode()
  {
    if (this.CA == null) {
      return 0;
    }
    return this.CA.hashCode();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramParcel.writeParcelable((Parcelable)this.CA, paramInt);
      return;
    }
    paramParcel.writeStrongBinder((IBinder)this.CA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.Token
 * JD-Core Version:    0.7.0.1
 */