import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.MessageForShortVideo;

public final class hyz
  implements Parcelable.Creator
{
  public MessageForShortVideo a(Parcel paramParcel)
  {
    MessageForShortVideo localMessageForShortVideo = new MessageForShortVideo();
    localMessageForShortVideo.uuid = paramParcel.readString();
    localMessageForShortVideo.md5 = paramParcel.readString();
    localMessageForShortVideo.videoFileName = paramParcel.readString();
    localMessageForShortVideo.videoFileSize = paramParcel.readInt();
    localMessageForShortVideo.videoFileFormat = paramParcel.readInt();
    localMessageForShortVideo.videoFileTime = paramParcel.readInt();
    localMessageForShortVideo.thumbWidth = paramParcel.readInt();
    localMessageForShortVideo.thumbHeight = paramParcel.readInt();
    localMessageForShortVideo.videoFileStatus = paramParcel.readInt();
    localMessageForShortVideo.videoFileProgress = paramParcel.readInt();
    localMessageForShortVideo.fileType = paramParcel.readInt();
    localMessageForShortVideo.thumbMD5 = paramParcel.readString();
    localMessageForShortVideo.fileSource = paramParcel.readString();
    localMessageForShortVideo.lastModified = paramParcel.readLong();
    return localMessageForShortVideo;
  }
  
  public MessageForShortVideo[] a(int paramInt)
  {
    return new MessageForShortVideo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hyz
 * JD-Core Version:    0.7.0.1
 */