import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.downloader.DownloadResult.Status;

public final class cub
  implements Parcelable.Creator
{
  public DownloadResult.Status a(Parcel paramParcel)
  {
    return new DownloadResult.Status(paramParcel);
  }
  
  public DownloadResult.Status[] a(int paramInt)
  {
    return new DownloadResult.Status[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cub
 * JD-Core Version:    0.7.0.1
 */