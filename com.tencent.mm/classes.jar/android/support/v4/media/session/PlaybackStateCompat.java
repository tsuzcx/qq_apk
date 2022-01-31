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
  final long Dp;
  final float Dq;
  final long Dr;
  final CharSequence Ds;
  final long Dt;
  List<CustomAction> Du;
  final long Dv;
  private Object Dw;
  final int mErrorCode;
  final Bundle mExtras;
  final long mPosition;
  final int mState;
  
  private PlaybackStateCompat(int paramInt, long paramLong1, long paramLong2, float paramFloat, long paramLong3, CharSequence paramCharSequence, long paramLong4, List<CustomAction> paramList, long paramLong5, Bundle paramBundle)
  {
    this.mState = paramInt;
    this.mPosition = paramLong1;
    this.Dp = paramLong2;
    this.Dq = paramFloat;
    this.Dr = paramLong3;
    this.mErrorCode = 0;
    this.Ds = paramCharSequence;
    this.Dt = paramLong4;
    this.Du = new ArrayList(paramList);
    this.Dv = paramLong5;
    this.mExtras = paramBundle;
  }
  
  PlaybackStateCompat(Parcel paramParcel)
  {
    this.mState = paramParcel.readInt();
    this.mPosition = paramParcel.readLong();
    this.Dq = paramParcel.readFloat();
    this.Dt = paramParcel.readLong();
    this.Dp = paramParcel.readLong();
    this.Dr = paramParcel.readLong();
    this.Ds = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Du = paramParcel.createTypedArrayList(CustomAction.CREATOR);
    this.Dv = paramParcel.readLong();
    this.mExtras = paramParcel.readBundle();
    this.mErrorCode = paramParcel.readInt();
  }
  
  public static PlaybackStateCompat z(Object paramObject)
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
          ((List)localObject2).add(CustomAction.A(((Iterator)localObject3).next()));
        }
      }
      if (Build.VERSION.SDK_INT >= 22) {}
      for (Object localObject2 = ((PlaybackState)paramObject).getExtras();; localObject2 = null)
      {
        localObject1 = new PlaybackStateCompat(((PlaybackState)paramObject).getState(), ((PlaybackState)paramObject).getPosition(), ((PlaybackState)paramObject).getBufferedPosition(), ((PlaybackState)paramObject).getPlaybackSpeed(), ((PlaybackState)paramObject).getActions(), ((PlaybackState)paramObject).getErrorMessage(), ((PlaybackState)paramObject).getLastPositionUpdateTime(), (List)localObject1, ((PlaybackState)paramObject).getActiveQueueItemId(), (Bundle)localObject2);
        ((PlaybackStateCompat)localObject1).Dw = paramObject;
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
    localStringBuilder.append(", buffered position=").append(this.Dp);
    localStringBuilder.append(", speed=").append(this.Dq);
    localStringBuilder.append(", updated=").append(this.Dt);
    localStringBuilder.append(", actions=").append(this.Dr);
    localStringBuilder.append(", error code=").append(this.mErrorCode);
    localStringBuilder.append(", error message=").append(this.Ds);
    localStringBuilder.append(", custom actions=").append(this.Du);
    localStringBuilder.append(", active item id=").append(this.Dv);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mState);
    paramParcel.writeLong(this.mPosition);
    paramParcel.writeFloat(this.Dq);
    paramParcel.writeLong(this.Dt);
    paramParcel.writeLong(this.Dp);
    paramParcel.writeLong(this.Dr);
    TextUtils.writeToParcel(this.Ds, paramParcel, paramInt);
    paramParcel.writeTypedList(this.Du);
    paramParcel.writeLong(this.Dv);
    paramParcel.writeBundle(this.mExtras);
    paramParcel.writeInt(this.mErrorCode);
  }
  
  public static final class CustomAction
    implements Parcelable
  {
    public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator() {};
    private Object DA;
    private final String Dx;
    private final CharSequence Dy;
    private final int Dz;
    private final Bundle mExtras;
    
    CustomAction(Parcel paramParcel)
    {
      this.Dx = paramParcel.readString();
      this.Dy = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      this.Dz = paramParcel.readInt();
      this.mExtras = paramParcel.readBundle();
    }
    
    private CustomAction(String paramString, CharSequence paramCharSequence, int paramInt, Bundle paramBundle)
    {
      this.Dx = paramString;
      this.Dy = paramCharSequence;
      this.Dz = paramInt;
      this.mExtras = paramBundle;
    }
    
    public static CustomAction A(Object paramObject)
    {
      if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {
        return null;
      }
      CustomAction localCustomAction = new CustomAction(((PlaybackState.CustomAction)paramObject).getAction(), ((PlaybackState.CustomAction)paramObject).getName(), ((PlaybackState.CustomAction)paramObject).getIcon(), ((PlaybackState.CustomAction)paramObject).getExtras());
      localCustomAction.DA = paramObject;
      return localCustomAction;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      return "Action:mName='" + this.Dy + ", mIcon=" + this.Dz + ", mExtras=" + this.mExtras;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.Dx);
      TextUtils.writeToParcel(this.Dy, paramParcel, paramInt);
      paramParcel.writeInt(this.Dz);
      paramParcel.writeBundle(this.mExtras);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat
 * JD-Core Version:    0.7.0.1
 */