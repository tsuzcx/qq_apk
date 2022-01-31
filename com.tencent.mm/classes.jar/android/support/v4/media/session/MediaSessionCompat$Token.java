package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class MediaSessionCompat$Token
  implements Parcelable
{
  public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator() {};
  final b CW;
  final Object Dj;
  
  MediaSessionCompat$Token(Object paramObject)
  {
    this(paramObject, null);
  }
  
  private MediaSessionCompat$Token(Object paramObject, b paramb)
  {
    this.Dj = paramObject;
    this.CW = paramb;
  }
  
  public static Token a(Object paramObject, b paramb)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21)) {
      return new Token(d.y(paramObject), paramb);
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
      if (this.Dj != null) {
        break;
      }
    } while (paramObject.Dj == null);
    return false;
    if (paramObject.Dj == null) {
      return false;
    }
    return this.Dj.equals(paramObject.Dj);
  }
  
  public final int hashCode()
  {
    if (this.Dj == null) {
      return 0;
    }
    return this.Dj.hashCode();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramParcel.writeParcelable((Parcelable)this.Dj, paramInt);
      return;
    }
    paramParcel.writeStrongBinder((IBinder)this.Dj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.Token
 * JD-Core Version:    0.7.0.1
 */