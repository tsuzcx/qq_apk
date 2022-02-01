import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class hqa
  implements Runnable
{
  public hqa(ThemeHandler paramThemeHandler) {}
  
  public void run()
  {
    QQToast.a(this.a.a.getApplication().getApplicationContext(), "主题资源异常，为你恢复默认主题", 4000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hqa
 * JD-Core Version:    0.7.0.1
 */