import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.SonginfoUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import java.util.ArrayList;

class hct
  implements Runnable
{
  hct(hcs paramhcs) {}
  
  public void run()
  {
    synchronized (this.a.a.jdField_a_of_type_JavaUtilArrayList)
    {
      this.a.a.b.clear();
      int i = 0;
      while (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.a.a.b.add(Long.valueOf(((com.tencent.mobileqq.activity.widget.qqmusic.data.SongInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).b()));
        i += 1;
      }
      com.tencent.mobileqq.music.SongInfo[] arrayOfSongInfo = SonginfoUtil.a(this.a.a.jdField_a_of_type_JavaUtilArrayList);
      QQPlayerService.a(this.a.a.jdField_a_of_type_AndroidContentContext, QQPlayerService.a(6, ""), arrayOfSongInfo, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hct
 * JD-Core Version:    0.7.0.1
 */