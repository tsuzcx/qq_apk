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
  final long Nd;
  final float Ne;
  final long Nf;
  final CharSequence Ng;
  final long Nh;
  List<CustomAction> Ni;
  final long Nj;
  private Object Nk;
  final int mErrorCode;
  final Bundle mExtras;
  final long mPosition;
  final int mState;
  
  private PlaybackStateCompat(int paramInt, long paramLong1, long paramLong2, float paramFloat, long paramLong3, CharSequence paramCharSequence, long paramLong4, List<CustomAction> paramList, long paramLong5, Bundle paramBundle)
  {
    this.mState = paramInt;
    this.mPosition = paramLong1;
    this.Nd = paramLong2;
    this.Ne = paramFloat;
    this.Nf = paramLong3;
    this.mErrorCode = 0;
    this.Ng = paramCharSequence;
    this.Nh = paramLong4;
    this.Ni = new ArrayList(paramList);
    this.Nj = paramLong5;
    this.mExtras = paramBundle;
  }
  
  PlaybackStateCompat(Parcel paramParcel)
  {
    this.mState = paramParcel.readInt();
    this.mPosition = paramParcel.readLong();
    this.Ne = paramParcel.readFloat();
    this.Nh = paramParcel.readLong();
    this.Nd = paramParcel.readLong();
    this.Nf = paramParcel.readLong();
    this.Ng = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Ni = paramParcel.createTypedArrayList(CustomAction.CREATOR);
    this.Nj = paramParcel.readLong();
    this.mExtras = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
    this.mErrorCode = paramParcel.readInt();
  }
  
  public static PlaybackStateCompat B(Object paramObject)
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
          ((List)localObject2).add(CustomAction.C(((Iterator)localObject3).next()));
        }
      }
      if (Build.VERSION.SDK_INT >= 22) {}
      for (Object localObject2 = ((PlaybackState)paramObject).getExtras();; localObject2 = null)
      {
        localObject1 = new PlaybackStateCompat(((PlaybackState)paramObject).getState(), ((PlaybackState)paramObject).getPosition(), ((PlaybackState)paramObject).getBufferedPosition(), ((PlaybackState)paramObject).getPlaybackSpeed(), ((PlaybackState)paramObject).getActions(), ((PlaybackState)paramObject).getErrorMessage(), ((PlaybackState)paramObject).getLastPositionUpdateTime(), (List)localObject1, ((PlaybackState)paramObject).getActiveQueueItemId(), (Bundle)localObject2);
        ((PlaybackStateCompat)localObject1).Nk = paramObject;
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
    localStringBuilder.append(", buffered position=").append(this.Nd);
    localStringBuilder.append(", speed=").append(this.Ne);
    localStringBuilder.append(", updated=").append(this.Nh);
    localStringBuilder.append(", actions=").append(this.Nf);
    localStringBuilder.append(", error code=").append(this.mErrorCode);
    localStringBuilder.append(", error message=").append(this.Ng);
    localStringBuilder.append(", custom actions=").append(this.Ni);
    localStringBuilder.append(", active item id=").append(this.Nj);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mState);
    paramParcel.writeLong(this.mPosition);
    paramParcel.writeFloat(this.Ne);
    paramParcel.writeLong(this.Nh);
    paramParcel.writeLong(this.Nd);
    paramParcel.writeLong(this.Nf);
    TextUtils.writeToParcel(this.Ng, paramParcel, paramInt);
    paramParcel.writeTypedList(this.Ni);
    paramParcel.writeLong(this.Nj);
    paramParcel.writeBundle(this.mExtras);
    paramParcel.writeInt(this.mErrorCode);
  }
  
  public static final class CustomAction
    implements Parcelable
  {
    public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator() {};
    private final int Hm;
    private final String Nl;
    private final CharSequence Nm;
    private Object Nn;
    private final Bundle mExtras;
    
    CustomAction(Parcel paramParcel)
    {
      this.Nl = paramParcel.readString();
      this.Nm = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      this.Hm = paramParcel.readInt();
      this.mExtras = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
    
    private CustomAction(String paramString, CharSequence paramCharSequence, int paramInt, Bundle paramBundle)
    {
      this.Nl = paramString;
      this.Nm = paramCharSequence;
      this.Hm = paramInt;
      this.mExtras = paramBundle;
    }
    
    public static CustomAction C(Object paramObject)
    {
      if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {
        return null;
      }
      CustomAction localCustomAction = new CustomAction(((PlaybackState.CustomAction)paramObject).getAction(), ((PlaybackState.CustomAction)paramObject).getName(), ((PlaybackState.CustomAction)paramObject).getIcon(), ((PlaybackState.CustomAction)paramObject).getExtras());
      localCustomAction.Nn = paramObject;
      return localCustomAction;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      return "Action:mName='" + this.Nm + ", mIcon=" + this.Hm + ", mExtras=" + this.mExtras;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.Nl);
      TextUtils.writeToParcel(this.Nm, paramParcel, paramInt);
      paramParcel.writeInt(this.Hm);
      paramParcel.writeBundle(this.mExtras);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat
 * JD-Core Version:    0.7.0.1
 */