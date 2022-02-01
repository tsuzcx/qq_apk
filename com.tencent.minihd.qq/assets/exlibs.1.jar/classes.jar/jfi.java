import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class jfi
  implements ValueAnimation.AnimationUpdateListener
{
  public jfi(VipMapRoamActivity paramVipMapRoamActivity) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramValueAnimation = this.a.a.getLayoutParams();
    if (paramValueAnimation != null)
    {
      paramValueAnimation.height = paramInteger.intValue();
      this.a.a.setLayoutParams(paramValueAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jfi
 * JD-Core Version:    0.7.0.1
 */