import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class jcc
  implements Runnable
{
  public jcc(SendBottomBar paramSendBottomBar) {}
  
  public void run()
  {
    new jcd(this).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jcc
 * JD-Core Version:    0.7.0.1
 */