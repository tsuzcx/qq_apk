import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.widget.RatioLayout;

public class jog
  implements ValueAnimation.AnimationUpdateListener
{
  public jog(ProfileTagView paramProfileTagView) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramTransformation = ProfileTagView.a(this.a).getLayoutParams();
    if (paramTransformation != null)
    {
      paramTransformation.height = paramInteger.intValue();
      ProfileTagView.a(this.a).setLayoutParams(paramTransformation);
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramInteger = (FrameLayout)this.a.a.findViewById(16908290);
        if ((paramInteger != null) && (paramInteger.getChildCount() > 0))
        {
          paramInteger = paramInteger.getChildAt(0);
          if (paramInteger != null)
          {
            paramInteger = paramInteger.getBackground();
            if ((paramInteger instanceof BitmapDrawable))
            {
              int j = (int)(255.0F * paramFloat);
              int i = j;
              if (paramValueAnimation == ProfileTagView.a(this.a)) {
                i = 255 - j;
              }
              paramInteger.setAlpha(i);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jog
 * JD-Core Version:    0.7.0.1
 */