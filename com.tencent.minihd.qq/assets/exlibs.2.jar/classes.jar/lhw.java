import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.YybHandleUtil;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import java.io.File;

public final class lhw
  implements Runnable
{
  public void run()
  {
    Object localObject = DownloadDBHelper.a().a("com.tencent.android.qqdownloader");
    String str = "";
    if (localObject != null) {
      str = ((DownloadInfo)localObject).k;
    }
    if (!TextUtils.isEmpty(str))
    {
      localObject = new File(str);
      LogUtility.c(YybHandleUtil.a, "---localFilePath = " + str);
      if ((localObject != null) && (((File)localObject).exists()))
      {
        LogUtility.c(YybHandleUtil.a, "---delete apk ");
        ((File)localObject).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lhw
 * JD-Core Version:    0.7.0.1
 */