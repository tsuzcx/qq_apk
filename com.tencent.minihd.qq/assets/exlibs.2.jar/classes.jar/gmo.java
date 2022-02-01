import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.flaotaio.FloatImagePreview;
import java.net.URL;

public class gmo
  extends AbstractImageAdapter.URLImageView2
{
  int jdField_a_of_type_Int = 0;
  
  public gmo(FloatImagePreview paramFloatImagePreview, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramURLDrawable = paramURLDrawable.getURL().getRef();
    if ((paramURLDrawable == null) || (!paramURLDrawable.equals("DISPLAY"))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(this.jdField_a_of_type_Int, false);
    }
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    String str = paramURLDrawable.getURL().getRef();
    if ((str != null) && (str.equals("NOSAMPLE")))
    {
      this.jdField_a_of_type_Boolean = true;
      super.onLoadSuccessed(paramURLDrawable);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(this.jdField_a_of_type_Int, true);
    }
    do
    {
      return;
      super.onLoadSuccessed(paramURLDrawable);
    } while ((str != null) && (str.equals("DISPLAY")));
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(this.jdField_a_of_type_Int, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gmo
 * JD-Core Version:    0.7.0.1
 */