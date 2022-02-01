import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mobileqq.nearpeople.FlingBrandListener;
import com.tencent.mobileqq.nearpeople.FlingBrandListener.FlingListener;

public class jki
  extends AnimatorListenerAdapter
{
  public jki(FlingBrandListener paramFlingBrandListener, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).a(FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener));
      FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).a();
    }
    for (;;)
    {
      FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener, false);
      FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).animate().setListener(null);
      FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).setX(FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener));
      FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).setY(FlingBrandListener.b(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener));
      FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).a(false, true, 0.0F, 0.0F);
      return;
      FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).b(FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener));
      FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jki
 * JD-Core Version:    0.7.0.1
 */