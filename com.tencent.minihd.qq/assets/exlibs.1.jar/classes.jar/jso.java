import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.SameStatusActivity;

public class jso
  implements Runnable
{
  public jso(SameStatusActivity paramSameStatusActivity) {}
  
  public void run()
  {
    this.a.app.c(false, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jso
 * JD-Core Version:    0.7.0.1
 */