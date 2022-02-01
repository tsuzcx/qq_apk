import android.graphics.drawable.Drawable;
import android.os.Message;
import com.tencent.mobileqq.transfile.LastModifySupportDownloader;
import com.tencent.open.agent.CardContainer;

public class lbg
  implements Runnable
{
  public lbg(CardContainer paramCardContainer) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = Drawable.createFromPath(LastModifySupportDownloader.a(this.a.a()));
    if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10001).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbg
 * JD-Core Version:    0.7.0.1
 */