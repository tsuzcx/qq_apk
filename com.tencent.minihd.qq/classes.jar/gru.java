import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.LogTag;

public class gru
  implements Runnable
{
  public gru(AlbumListAdapter paramAlbumListAdapter) {}
  
  public void run()
  {
    LogTag.a();
    QQAlbumInfo localQQAlbumInfo = AlbumListAdapter.a(this.a, AlbumListAdapter.a(this.a), 200, 100, AlbumListAdapter.a(this.a));
    AlbumListAdapter.b(this.a, localQQAlbumInfo);
    LogTag.a("PEAK", "queryRecentBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gru
 * JD-Core Version:    0.7.0.1
 */