import android.widget.ImageView;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public class cev
  implements URLDrawable.URLDrawableListener
{
  public cev(EnterpriseDetailActivity paramEnterpriseDetailActivity, ImageView paramImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cev
 * JD-Core Version:    0.7.0.1
 */