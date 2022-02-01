import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.utils.LogTag;

public class grp
  implements Runnable
{
  public grp(AlbumListAdapter paramAlbumListAdapter) {}
  
  public void run()
  {
    LogTag.a();
    AlbumListAdapter.a(this.a, 100);
    LogTag.a("PEAK", "queryAlbumList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     grp
 * JD-Core Version:    0.7.0.1
 */