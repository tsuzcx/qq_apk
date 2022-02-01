import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PresendPicMgr;

public class jme
  implements Runnable
{
  private jmd jdField_a_of_type_Jmd;
  
  public jme(PresendPicMgr paramPresendPicMgr, jmd paramjmd)
  {
    this.jdField_a_of_type_Jmd = paramjmd;
  }
  
  public void run()
  {
    Logger.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.jdField_a_of_type_Jmd);
    this.jdField_a_of_type_Jmd.b();
    this.jdField_a_of_type_Jmd.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jme
 * JD-Core Version:    0.7.0.1
 */