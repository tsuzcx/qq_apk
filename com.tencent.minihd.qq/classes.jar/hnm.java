import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class hnm
  implements Runnable
{
  public hnm(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QQToast.a(QQAppInterface.c(this.a).getApplicationContext(), 2131368838, 3000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hnm
 * JD-Core Version:    0.7.0.1
 */