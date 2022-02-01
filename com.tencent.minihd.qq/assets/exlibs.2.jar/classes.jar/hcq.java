import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderListManager;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderListManager.LoadFolderListener;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderListInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import java.util.ArrayList;

public class hcq
  implements OnResultListener
{
  public hcq(FolderListManager paramFolderListManager) {}
  
  public void a(int paramInt, String paramString)
  {
    FolderListManager.c(this.a, 2);
    if (FolderListManager.a(this.a) != null) {
      FolderListManager.a(this.a).a(paramInt);
    }
  }
  
  public void a(CommonResponse paramCommonResponse)
  {
    MLog.b("liwei", "onSuccess");
    paramCommonResponse = (FolderListInfo)paramCommonResponse.a();
    if ((paramCommonResponse == null) || (paramCommonResponse.a().size() == 0))
    {
      MLog.d("liwei", "folderListInfo == null");
      FolderListManager.a(this.a, 2);
    }
    do
    {
      return;
      FolderListManager.b(this.a, 1);
      FolderListManager.a(this.a).clear();
      FolderListManager.b(this.a).clear();
      paramCommonResponse = paramCommonResponse.a();
      int i = 0;
      if (i < paramCommonResponse.size())
      {
        FolderInfo localFolderInfo = (FolderInfo)paramCommonResponse.get(i);
        MLog.b("liwei", "folder : " + localFolderInfo.toString());
        if (localFolderInfo.a() == 201L) {}
        for (;;)
        {
          i += 1;
          break;
          if (localFolderInfo.a() == 1) {
            FolderListManager.a(this.a).add(localFolderInfo);
          } else if (localFolderInfo.a() == 2) {
            FolderListManager.b(this.a).add(localFolderInfo);
          }
        }
      }
    } while (FolderListManager.a(this.a) == null);
    FolderListManager.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcq
 * JD-Core Version:    0.7.0.1
 */