import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.qphone.base.util.QLog;

public class joc
  extends GestureDetector.SimpleOnGestureListener
{
  public joc(ProfileTagView paramProfileTagView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll invoked");
    }
    ProfileTagView.a(this.a, true);
    paramFloat1 = paramFloat2;
    if (paramMotionEvent1 != null)
    {
      paramFloat1 = paramFloat2;
      if (paramMotionEvent2 != null) {
        paramFloat1 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
      }
    }
    if (Math.abs(paramFloat1) > ProfileTagView.a(this.a))
    {
      if ((paramFloat1 > 0.0F) && (ProfileTagView.a(this.a))) {
        if (ProfileTagView.b(this.a))
        {
          this.a.e();
          ProfileTagView.a(this.a).b(null);
        }
      }
      while ((paramFloat1 >= 0.0F) || (ProfileTagView.a(this.a))) {
        return true;
      }
      ProfileTagView.b(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     joc
 * JD-Core Version:    0.7.0.1
 */