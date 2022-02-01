import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderSongListInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import java.util.ArrayList;

public class hcs
  implements OnResultListener
{
  public hcs(FolderSongManager paramFolderSongManager) {}
  
  public void a(int paramInt, String paramString)
  {
    FolderSongManager.c(this.a, 2);
  }
  
  public void a(CommonResponse arg1)
  {
    MLog.b("liwei", "onSuccess");
    FolderSongListInfo localFolderSongListInfo = (FolderSongListInfo)???.a();
    if ((localFolderSongListInfo == null) || (localFolderSongListInfo.a() == null) || (localFolderSongListInfo.a().size() == 0))
    {
      MLog.d("liwei", "songListInfo == null");
      FolderSongManager.a(this.a, 2);
      return;
    }
    FolderSongManager.b(this.a, 1);
    synchronized (this.a.a)
    {
      this.a.a = localFolderSongListInfo.a();
      new Thread(new hct(this)).start();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcs
 * JD-Core Version:    0.7.0.1
 */