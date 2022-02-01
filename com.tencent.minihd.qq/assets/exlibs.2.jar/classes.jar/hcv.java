import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.SonginfoUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import java.util.ArrayList;

class hcv
  implements Runnable
{
  hcv(hcu paramhcu) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (this.a.a.jdField_a_of_type_JavaUtilArrayList)
      {
        this.a.a.b.clear();
        i = 0;
        if (i < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.a.a.b.add(Long.valueOf(((com.tencent.mobileqq.activity.widget.qqmusic.data.SongInfo)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(i)).b()));
          i += 1;
          continue;
        }
        if (MusicPreferences.a().b() < this.a.a.jdField_a_of_type_JavaUtilArrayList.size())
        {
          i = MusicPreferences.a().b();
          QQPlayerService.a(MusicPreferences.a().c());
          QQMusicHelper.a(MusicPreferences.a().c());
          com.tencent.mobileqq.music.SongInfo[] arrayOfSongInfo = SonginfoUtil.a(this.a.a.jdField_a_of_type_JavaUtilArrayList);
          QQPlayerService.a(this.a.a.jdField_a_of_type_AndroidContentContext, QQPlayerService.a(6, ""), arrayOfSongInfo, i);
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcv
 * JD-Core Version:    0.7.0.1
 */