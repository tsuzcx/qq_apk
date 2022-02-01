import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;
import java.io.File;

class etp
  implements Runnable
{
  etp(etn parametn) {}
  
  public void run()
  {
    this.a.a.q = null;
    this.a.a.s = true;
    this.a.a.a.a(this.a.a.getString(2131364035));
    if (new File(QQMapConstants.i).exists()) {
      UniformDownloadUtil.a(QQMapConstants.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     etp
 * JD-Core Version:    0.7.0.1
 */