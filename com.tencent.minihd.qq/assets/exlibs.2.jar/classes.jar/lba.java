import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.open.agent.BindGroupConfirmActivity;

public class lba
  implements Runnable
{
  public lba(BindGroupConfirmActivity paramBindGroupConfirmActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lba
 * JD-Core Version:    0.7.0.1
 */