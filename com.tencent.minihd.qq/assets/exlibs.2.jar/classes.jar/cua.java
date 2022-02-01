import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.downloader.DownloadResult.Process;

public final class cua
  implements Parcelable.Creator
{
  public DownloadResult.Process a(Parcel paramParcel)
  {
    return new DownloadResult.Process(paramParcel);
  }
  
  public DownloadResult.Process[] a(int paramInt)
  {
    return new DownloadResult.Process[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cua
 * JD-Core Version:    0.7.0.1
 */