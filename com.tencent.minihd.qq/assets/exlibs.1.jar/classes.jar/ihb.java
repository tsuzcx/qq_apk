import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.emoticonview.HorizonEmoticonTabs;

public class ihb
  implements Runnable
{
  public ihb(HorizonEmoticonTabs paramHorizonEmoticonTabs, int paramInt, Drawable paramDrawable) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.a.getChildAt(this.jdField_a_of_type_Int);
    if (localObject == null) {
      return;
    }
    localObject = (ImageView)((View)localObject).findViewById(2131297589);
    ((ImageView)localObject).setAdjustViewBounds(false);
    ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    ((ImageView)localObject).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ihb
 * JD-Core Version:    0.7.0.1
 */