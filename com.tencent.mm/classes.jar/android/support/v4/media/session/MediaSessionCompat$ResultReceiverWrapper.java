package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;

final class MediaSessionCompat$ResultReceiverWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new MediaSessionCompat.ResultReceiverWrapper.1();
  private ResultReceiver Di;
  
  MediaSessionCompat$ResultReceiverWrapper(Parcel paramParcel)
  {
    this.Di = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    this.Di.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper
 * JD-Core Version:    0.7.0.1
 */