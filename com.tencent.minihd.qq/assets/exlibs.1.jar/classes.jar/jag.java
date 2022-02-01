import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarManager;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class jag
  extends FMObserver
{
  public jag(TroopFileDetailBrowserActivity paramTroopFileDetailBrowserActivity) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      if ((paramString != null) && (paramString.length() > 0)) {
        FileManagerUtil.a(paramString);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((TroopFileDetailBrowserActivity.a(this.a) == null) || (this.a.app == null));
        if (TroopFileDetailBrowserActivity.a(this.a).b() == paramLong) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("FileBrowserActivity", 4, "difference nSessionId");
      return;
      paramString = this.a.app.a().b(paramLong);
      if (paramString == null)
      {
        QLog.e("FileBrowserActivity", 1, "OnTroopFileCopyToC2cDisc->,but entity is null SessionId[" + paramLong + "]");
        return;
      }
    } while ((this.a.a == null) || (paramString.cloudType != 1));
    this.a.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jag
 * JD-Core Version:    0.7.0.1
 */