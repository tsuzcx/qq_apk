import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderSongManager.LoadFolderSongListener;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.MyFavSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderSongListInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.data.SongInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import java.util.ArrayList;

public class hcx
  implements OnResultListener
{
  public hcx(MyFavSongManager paramMyFavSongManager) {}
  
  public void a(int paramInt, String paramString)
  {
    MyFavSongManager.c(this.a, 2);
  }
  
  public void a(CommonResponse arg1)
  {
    MLog.b("liwei", "onSuccess");
    FolderSongListInfo localFolderSongListInfo = (FolderSongListInfo)???.a();
    if ((localFolderSongListInfo == null) || (localFolderSongListInfo.a() == null) || (localFolderSongListInfo.a().size() == 0))
    {
      MLog.d("liwei", "songListInfo == null");
      MyFavSongManager.a(this.a, 2);
    }
    for (;;)
    {
      return;
      MyFavSongManager.b(this.a, 1);
      synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
      {
        this.a.jdField_a_of_type_JavaUtilArrayList = localFolderSongListInfo.a();
        this.a.b.clear();
        int i = 0;
        while (i < this.a.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.a.b.add(Long.valueOf(((SongInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(i)).b()));
          i += 1;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderSongManager$LoadFolderSongListener == null) {
          continue;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderSongManager$LoadFolderSongListener.a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcx
 * JD-Core Version:    0.7.0.1
 */