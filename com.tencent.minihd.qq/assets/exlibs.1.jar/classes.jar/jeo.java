import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.qphone.base.util.QLog;

public class jeo
  implements Runnable
{
  public jeo(MagicfaceViewController paramMagicfaceViewController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(MagicfaceViewController.a, 2, "func run, magicValue:" + MagicfaceViewController.a(this.a).magicValue);
    }
    this.a.a(MagicfaceViewController.a(this.a), 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jeo
 * JD-Core Version:    0.7.0.1
 */