import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.SigTlpAnimation;
import com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable;

public class frk
  extends View
{
  public frk(SigTlpAnimation paramSigTlpAnimation, Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.d) {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new frl(this));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     frk
 * JD-Core Version:    0.7.0.1
 */