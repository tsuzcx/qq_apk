import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.richstatus.EditActivity;

public class jrh
  implements Runnable
{
  public jrh(EditActivity paramEditActivity) {}
  
  public void run()
  {
    if (this.a.app != null) {
      ((SignatureManager)this.a.app.getManager(56)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jrh
 * JD-Core Version:    0.7.0.1
 */