package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.CustomAction;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PlaybackStateCompat
  implements Parcelable
{
  public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator() {};
  final long Kg;
  final float Kh;
  final long Ki;
  final CharSequence Kj;
  final long Kk;
  List<CustomAction> Kl;
  final long Km;
  private Object Kn;
  final int mErrorCode;
  final Bundle mExtras;
  final long mPosition;
  final int mState;
  
  private PlaybackStateCompat(int paramInt, long paramLong1, long paramLong2, float paramFloat, long paramLong3, CharSequence paramCharSequence, long paramLong4, List<CustomAction> paramList, long paramLong5, Bundle paramBundle)
  {
    this.mState = paramInt;
    this.mPosition = paramLong1;
    this.Kg = paramLong2;
    this.Kh = paramFloat;
    this.Ki = paramLong3;
    this.mErrorCode = 0;
    this.Kj = paramCharSequence;
    this.Kk = paramLong4;
    this.Kl = new ArrayList(paramList);
    this.Km = paramLong5;
    this.mExtras = paramBundle;
  }
  
  PlaybackStateCompat(Parcel paramParcel)
  {
    this.mState = paramParcel.readInt();
    this.mPosition = paramParcel.readLong();
    this.Kh = paramParcel.readFloat();
    this.Kk = paramParcel.readLong();
    this.Kg = paramParcel.readLong();
    this.Ki = paramParcel.readLong();
    this.Kj = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Kl = paramParcel.createTypedArrayList(CustomAction.CREATOR);
    this.Km = paramParcel.readLong();
    this.mExtras = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
    this.mErrorCode = paramParcel.readInt();
  }
  
  public static PlaybackStateCompat y(Object paramObject)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      Object localObject3 = ((PlaybackState)paramObject).getCustomActions();
      Object localObject1 = null;
      if (localObject3 != null)
      {
        localObject2 = new ArrayList(((List)localObject3).size());
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          ((List)localObject2).add(CustomAction.z(((Iterator)localObject3).next()));
        }
      }
      if (Build.VERSION.SDK_INT >= 22) {}
      for (Object localObject2 = ((PlaybackState)paramObject).getExtras();; localObject2 = null)
      {
        localObject1 = new PlaybackStateCompat(((PlaybackState)paramObject).getState(), ((PlaybackState)paramObject).getPosition(), ((PlaybackState)paramObject).getBufferedPosition(), ((PlaybackState)paramObject).getPlaybackSpeed(), ((PlaybackState)paramObject).getActions(), ((PlaybackState)paramObject).getErrorMessage(), ((PlaybackState)paramObject).getLastPositionUpdateTime(), (List)localObject1, ((PlaybackState)paramObject).getActiveQueueItemId(), (Bundle)localObject2);
        ((PlaybackStateCompat)localObject1).Kn = paramObject;
        return localObject1;
      }
    }
    return null;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PlaybackState {");
    localStringBuilder.append("state=").append(this.mState);
    localStringBuilder.append(", position=").append(this.mPosition);
    localStringBuilder.append(", buffered position=").append(this.Kg);
    localStringBuilder.append(", speed=").append(this.Kh);
    localStringBuilder.append(", updated=").append(this.Kk);
    localStringBuilder.append(", actions=").append(this.Ki);
    localStringBuilder.append(", error code=").append(this.mErrorCode);
    localStringBuilder.append(", error message=").append(this.Kj);
    localStringBuilder.append(", custom actions=").append(this.Kl);
    localStringBuilder.append(", active item id=").append(this.Km);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mState);
    paramParcel.writeLong(this.mPosition);
    paramParcel.writeFloat(this.Kh);
    paramParcel.writeLong(this.Kk);
    paramParcel.writeLong(this.Kg);
    paramParcel.writeLong(this.Ki);
    TextUtils.writeToParcel(this.Kj, paramParcel, paramInt);
    paramParcel.writeTypedList(this.Kl);
    paramParcel.writeLong(this.Km);
    paramParcel.writeBundle(this.mExtras);
    paramParcel.writeInt(this.mErrorCode);
  }
  
  public static final class CustomAction
    implements Parcelable
  {
    public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator() {};
    private final int En;
    private final String Ko;
    private final CharSequence Kp;
    private Object Kq;
    private final Bundle mExtras;
    
    CustomAction(Parcel paramParcel)
    {
      this.Ko = paramParcel.readString();
      this.Kp = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      this.En = paramParcel.readInt();
      this.mExtras = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
    
    private CustomAction(String paramString, CharSequence paramCharSequence, int paramInt, Bundle paramBundle)
    {
      this.Ko = paramString;
      this.Kp = paramCharSequence;
      this.En = paramInt;
      this.mExtras = paramBundle;
    }
    
    public static CustomAction z(Object paramObject)
    {
      if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {
        return null;
      }
      CustomAction localCustomAction = new CustomAction(((PlaybackState.CustomAction)paramObject).getAction(), ((PlaybackState.CustomAction)paramObject).getName(), ((PlaybackState.CustomAction)paramObject).getIcon(), ((PlaybackState.CustomAction)paramObject).getExtras());
      localCustomAction.Kq = paramObject;
      return localCustomAction;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      return "Action:mName='" + this.Kp + ", mIcon=" + this.En + ", mExtras=" + this.mExtras;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.Ko);
      TextUtils.writeToParcel(this.Kp, paramParcel, paramInt);
      paramParcel.writeInt(this.En);
      paramParcel.writeBundle(this.mExtras);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat
 * JD-Core Version:    0.7.0.1
 */