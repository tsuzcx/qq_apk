package android.support.v4.media.session;

import android.media.session.PlaybackState;
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
  final long CG;
  final float CH;
  final long CI;
  final CharSequence CJ;
  final long CK;
  List<PlaybackStateCompat.CustomAction> CL;
  final long CM;
  private Object CN;
  final int mErrorCode;
  final Bundle mExtras;
  final long mPosition;
  final int mState;
  
  private PlaybackStateCompat(int paramInt, long paramLong1, long paramLong2, float paramFloat, long paramLong3, CharSequence paramCharSequence, long paramLong4, List<PlaybackStateCompat.CustomAction> paramList, long paramLong5, Bundle paramBundle)
  {
    this.mState = paramInt;
    this.mPosition = paramLong1;
    this.CG = paramLong2;
    this.CH = paramFloat;
    this.CI = paramLong3;
    this.mErrorCode = 0;
    this.CJ = paramCharSequence;
    this.CK = paramLong4;
    this.CL = new ArrayList(paramList);
    this.CM = paramLong5;
    this.mExtras = paramBundle;
  }
  
  PlaybackStateCompat(Parcel paramParcel)
  {
    this.mState = paramParcel.readInt();
    this.mPosition = paramParcel.readLong();
    this.CH = paramParcel.readFloat();
    this.CK = paramParcel.readLong();
    this.CG = paramParcel.readLong();
    this.CI = paramParcel.readLong();
    this.CJ = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.CL = paramParcel.createTypedArrayList(PlaybackStateCompat.CustomAction.CREATOR);
    this.CM = paramParcel.readLong();
    this.mExtras = paramParcel.readBundle();
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
          ((List)localObject2).add(PlaybackStateCompat.CustomAction.z(((Iterator)localObject3).next()));
        }
      }
      if (Build.VERSION.SDK_INT >= 22) {}
      for (Object localObject2 = ((PlaybackState)paramObject).getExtras();; localObject2 = null)
      {
        localObject1 = new PlaybackStateCompat(((PlaybackState)paramObject).getState(), ((PlaybackState)paramObject).getPosition(), ((PlaybackState)paramObject).getBufferedPosition(), ((PlaybackState)paramObject).getPlaybackSpeed(), ((PlaybackState)paramObject).getActions(), ((PlaybackState)paramObject).getErrorMessage(), ((PlaybackState)paramObject).getLastPositionUpdateTime(), (List)localObject1, ((PlaybackState)paramObject).getActiveQueueItemId(), (Bundle)localObject2);
        ((PlaybackStateCompat)localObject1).CN = paramObject;
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
    localStringBuilder.append(", buffered position=").append(this.CG);
    localStringBuilder.append(", speed=").append(this.CH);
    localStringBuilder.append(", updated=").append(this.CK);
    localStringBuilder.append(", actions=").append(this.CI);
    localStringBuilder.append(", error code=").append(this.mErrorCode);
    localStringBuilder.append(", error message=").append(this.CJ);
    localStringBuilder.append(", custom actions=").append(this.CL);
    localStringBuilder.append(", active item id=").append(this.CM);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mState);
    paramParcel.writeLong(this.mPosition);
    paramParcel.writeFloat(this.CH);
    paramParcel.writeLong(this.CK);
    paramParcel.writeLong(this.CG);
    paramParcel.writeLong(this.CI);
    TextUtils.writeToParcel(this.CJ, paramParcel, paramInt);
    paramParcel.writeTypedList(this.CL);
    paramParcel.writeLong(this.CM);
    paramParcel.writeBundle(this.mExtras);
    paramParcel.writeInt(this.mErrorCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat
 * JD-Core Version:    0.7.0.1
 */