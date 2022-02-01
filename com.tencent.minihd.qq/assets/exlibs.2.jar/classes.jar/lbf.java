import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.open.agent.CardContainer;
import com.tencent.qav.log.QLog;

public class lbf
  extends URLDrawableDownListener.Adapter
{
  public lbf(CardContainer paramCardContainer) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "-->drawabel onLoadSuccessed, view: " + paramView);
    }
    ((AnyScaleTypeImageView)paramView).setImageDrawable(paramURLDrawable);
    this.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbf
 * JD-Core Version:    0.7.0.1
 */