package android.support.v4.media.session;

import android.media.session.PlaybackState.CustomAction;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class PlaybackStateCompat$CustomAction
  implements Parcelable
{
  public static final Parcelable.Creator<CustomAction> CREATOR = new PlaybackStateCompat.CustomAction.1();
  private final String CO;
  private final CharSequence CQ;
  private final int CR;
  private Object CS;
  private final Bundle mExtras;
  
  PlaybackStateCompat$CustomAction(Parcel paramParcel)
  {
    this.CO = paramParcel.readString();
    this.CQ = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.CR = paramParcel.readInt();
    this.mExtras = paramParcel.readBundle();
  }
  
  private PlaybackStateCompat$CustomAction(String paramString, CharSequence paramCharSequence, int paramInt, Bundle paramBundle)
  {
    this.CO = paramString;
    this.CQ = paramCharSequence;
    this.CR = paramInt;
    this.mExtras = paramBundle;
  }
  
  public static CustomAction z(Object paramObject)
  {
    if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {
      return null;
    }
    CustomAction localCustomAction = new CustomAction(((PlaybackState.CustomAction)paramObject).getAction(), ((PlaybackState.CustomAction)paramObject).getName(), ((PlaybackState.CustomAction)paramObject).getIcon(), ((PlaybackState.CustomAction)paramObject).getExtras());
    localCustomAction.CS = paramObject;
    return localCustomAction;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return "Action:mName='" + this.CQ + ", mIcon=" + this.CR + ", mExtras=" + this.mExtras;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.CO);
    TextUtils.writeToParcel(this.CQ, paramParcel, paramInt);
    paramParcel.writeInt(this.CR);
    paramParcel.writeBundle(this.mExtras);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat.CustomAction
 * JD-Core Version:    0.7.0.1
 */