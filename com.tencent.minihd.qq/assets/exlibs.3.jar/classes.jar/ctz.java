import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.downloader.DownloadResult.Content;

public final class ctz
  implements Parcelable.Creator
{
  public DownloadResult.Content a(Parcel paramParcel)
  {
    return new DownloadResult.Content(paramParcel);
  }
  
  public DownloadResult.Content[] a(int paramInt)
  {
    return new DownloadResult.Content[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     ctz
 * JD-Core Version:    0.7.0.1
 */