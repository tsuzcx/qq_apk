import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.MyFavSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.SonginfoUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;

public class hcw
  implements Runnable
{
  public hcw(MyFavSongManager paramMyFavSongManager) {}
  
  public void run()
  {
    synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
    {
      SongInfo[] arrayOfSongInfo = SonginfoUtil.a(this.a.jdField_a_of_type_JavaUtilArrayList);
      QQPlayerService.a(this.a.jdField_a_of_type_AndroidContentContext, QQPlayerService.a(6, ""), arrayOfSongInfo, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcw
 * JD-Core Version:    0.7.0.1
 */