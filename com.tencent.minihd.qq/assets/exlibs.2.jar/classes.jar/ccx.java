import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class ccx
  implements ViewTreeObserver.OnPreDrawListener
{
  public ccx(BmqqProfileCardActivity paramBmqqProfileCardActivity) {}
  
  public boolean onPreDraw()
  {
    ImageView localImageView1 = (ImageView)this.a.findViewById(2131296813);
    ImageView localImageView2 = (ImageView)this.a.findViewById(2131296821);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.a.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels - localImageView1.getWidth() - AIOUtils.a(50.0F, this.a.getResources()) - localImageView2.getWidth();
    if (i > 0) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i);
    }
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().removeOnPreDrawListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ccx
 * JD-Core Version:    0.7.0.1
 */