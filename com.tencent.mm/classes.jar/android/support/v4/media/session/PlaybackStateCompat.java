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
  final long Lb;
  final float Lc;
  final long Ld;
  final CharSequence Le;
  final long Lf;
  List<CustomAction> Lg;
  final long Lh;
  private Object Li;
  final int mErrorCode;
  final Bundle mExtras;
  final long mPosition;
  final int mState;
  
  private PlaybackStateCompat(int paramInt, long paramLong1, long paramLong2, float paramFloat, long paramLong3, CharSequence paramCharSequence, long paramLong4, List<CustomAction> paramList, long paramLong5, Bundle paramBundle)
  {
    this.mState = paramInt;
    this.mPosition = paramLong1;
    this.Lb = paramLong2;
    this.Lc = paramFloat;
    this.Ld = paramLong3;
    this.mErrorCode = 0;
    this.Le = paramCharSequence;
    this.Lf = paramLong4;
    this.Lg = new ArrayList(paramList);
    this.Lh = paramLong5;
    this.mExtras = paramBundle;
  }
  
  PlaybackStateCompat(Parcel paramParcel)
  {
    this.mState = paramParcel.readInt();
    this.mPosition = paramParcel.readLong();
    this.Lc = paramParcel.readFloat();
    this.Lf = paramParcel.readLong();
    this.Lb = paramParcel.readLong();
    this.Ld = paramParcel.readLong();
    this.Le = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Lg = paramParcel.createTypedArrayList(CustomAction.CREATOR);
    this.Lh = paramParcel.readLong();
    this.mExtras = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
    this.mErrorCode = paramParcel.readInt();
  }
  
  public static PlaybackStateCompat A(Object paramObject)
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
          ((List)localObject2).add(CustomAction.B(((Iterator)localObject3).next()));
        }
      }
      if (Build.VERSION.SDK_INT >= 22) {}
      for (Object localObject2 = ((PlaybackState)paramObject).getExtras();; localObject2 = null)
      {
        localObject1 = new PlaybackStateCompat(((PlaybackState)paramObject).getState(), ((PlaybackState)paramObject).getPosition(), ((PlaybackState)paramObject).getBufferedPosition(), ((PlaybackState)paramObject).getPlaybackSpeed(), ((PlaybackState)paramObject).getActions(), ((PlaybackState)paramObject).getErrorMessage(), ((PlaybackState)paramObject).getLastPositionUpdateTime(), (List)localObject1, ((PlaybackState)paramObject).getActiveQueueItemId(), (Bundle)localObject2);
        ((PlaybackStateCompat)localObject1).Li = paramObject;
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
    localStringBuilder.append(", buffered position=").append(this.Lb);
    localStringBuilder.append(", speed=").append(this.Lc);
    localStringBuilder.append(", updated=").append(this.Lf);
    localStringBuilder.append(", actions=").append(this.Ld);
    localStringBuilder.append(", error code=").append(this.mErrorCode);
    localStringBuilder.append(", error message=").append(this.Le);
    localStringBuilder.append(", custom actions=").append(this.Lg);
    localStringBuilder.append(", active item id=").append(this.Lh);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mState);
    paramParcel.writeLong(this.mPosition);
    paramParcel.writeFloat(this.Lc);
    paramParcel.writeLong(this.Lf);
    paramParcel.writeLong(this.Lb);
    paramParcel.writeLong(this.Ld);
    TextUtils.writeToParcel(this.Le, paramParcel, paramInt);
    paramParcel.writeTypedList(this.Lg);
    paramParcel.writeLong(this.Lh);
    paramParcel.writeBundle(this.mExtras);
    paramParcel.writeInt(this.mErrorCode);
  }
  
  public static final class CustomAction
    implements Parcelable
  {
    public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator() {};
    private final int Fl;
    private final String Lj;
    private final CharSequence Lk;
    private Object Ll;
    private final Bundle mExtras;
    
    CustomAction(Parcel paramParcel)
    {
      this.Lj = paramParcel.readString();
      this.Lk = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      this.Fl = paramParcel.readInt();
      this.mExtras = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
    
    private CustomAction(String paramString, CharSequence paramCharSequence, int paramInt, Bundle paramBundle)
    {
      this.Lj = paramString;
      this.Lk = paramCharSequence;
      this.Fl = paramInt;
      this.mExtras = paramBundle;
    }
    
    public static CustomAction B(Object paramObject)
    {
      if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {
        return null;
      }
      CustomAction localCustomAction = new CustomAction(((PlaybackState.CustomAction)paramObject).getAction(), ((PlaybackState.CustomAction)paramObject).getName(), ((PlaybackState.CustomAction)paramObject).getIcon(), ((PlaybackState.CustomAction)paramObject).getExtras());
      localCustomAction.Ll = paramObject;
      return localCustomAction;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      return "Action:mName='" + this.Lk + ", mIcon=" + this.Fl + ", mExtras=" + this.mExtras;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.Lj);
      TextUtils.writeToParcel(this.Lk, paramParcel, paramInt);
      paramParcel.writeInt(this.Fl);
      paramParcel.writeBundle(this.mExtras);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat
 * JD-Core Version:    0.7.0.1
 */