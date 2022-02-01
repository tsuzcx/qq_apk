import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.open.agent.RecommendListManager;
import java.util.HashMap;

public class lcd
  implements Runnable
{
  public lcd(RecommendListManager paramRecommendListManager, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    ((ImageView)((View)this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.a.get(this.jdField_a_of_type_JavaLangString)).findViewById(2131296551)).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lcd
 * JD-Core Version:    0.7.0.1
 */