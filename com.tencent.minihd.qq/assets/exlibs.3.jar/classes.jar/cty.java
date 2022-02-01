import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.downloader.DownloadResult;

public final class cty
  implements Parcelable.Creator
{
  public DownloadResult a(Parcel paramParcel)
  {
    return new DownloadResult(paramParcel);
  }
  
  public DownloadResult[] a(int paramInt)
  {
    return new DownloadResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cty
 * JD-Core Version:    0.7.0.1
 */