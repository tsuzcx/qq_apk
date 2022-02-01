import android.graphics.Bitmap;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.open.agent.SmartHardwareActivity;
import com.tencent.open.agent.SmartHardwareActivity.ViewHolder;

public class lcj
  implements Runnable
{
  public lcj(SmartHardwareActivity paramSmartHardwareActivity, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentOpenAgentSmartHardwareActivity.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        SmartHardwareActivity.ViewHolder localViewHolder = (SmartHardwareActivity.ViewHolder)this.jdField_a_of_type_ComTencentOpenAgentSmartHardwareActivity.a.getChildAt(i).getTag();
        if ((localViewHolder != null) && (this.jdField_a_of_type_JavaLangString.equals(localViewHolder.jdField_a_of_type_JavaLangString))) {
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lcj
 * JD-Core Version:    0.7.0.1
 */