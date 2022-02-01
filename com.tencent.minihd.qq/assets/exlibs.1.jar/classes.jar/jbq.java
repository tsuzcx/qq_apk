import android.view.View;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;

public class jbq
  implements Runnable
{
  public jbq(FileWebView paramFileWebView) {}
  
  public void run()
  {
    if ((this.a.getContentHeight() * this.a.getScale() - (this.a.getView().getHeight() + this.a.getWebScrollY()) < this.a.getView().getHeight() / 5) && (!FileManagerUtil.a()) && (this.a.a != null)) {
      this.a.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jbq
 * JD-Core Version:    0.7.0.1
 */