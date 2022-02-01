import com.tencent.mobileqq.subaccount.SubAccountProtocManager;

public class jyc
  implements Runnable
{
  public jyc(SubAccountProtocManager paramSubAccountProtocManager) {}
  
  public void run()
  {
    new jyd(this.a, "report_subaccount").start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jyc
 * JD-Core Version:    0.7.0.1
 */