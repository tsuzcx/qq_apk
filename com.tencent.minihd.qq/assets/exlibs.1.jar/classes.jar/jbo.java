import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;
import com.tencent.mobileqq.utils.NetworkUtil;

public class jbo
  extends Handler
{
  public jbo(FileWebView paramFileWebView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!NetworkUtil.e(BaseApplicationImpl.getContext())) {
      return;
    }
    if ((this.a.getContentHeight() * this.a.getScale() - (this.a.getView().getHeight() + this.a.getWebScrollY()) < 2.5D) && (this.a.a != null) && (this.a.b == true))
    {
      this.a.b = false;
      this.a.a.b();
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jbo
 * JD-Core Version:    0.7.0.1
 */