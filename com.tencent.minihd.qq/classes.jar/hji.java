import android.os.Process;
import com.tencent.mobileqq.app.EmoticonManagerImp;

public class hji
  implements Runnable
{
  public hji(EmoticonManagerImp paramEmoticonManagerImp) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    EmoticonManagerImp.a(this.a);
    this.a.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hji
 * JD-Core Version:    0.7.0.1
 */