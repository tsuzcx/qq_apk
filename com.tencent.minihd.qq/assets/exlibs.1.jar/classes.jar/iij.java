import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendConstants;

class iij
  implements Animation.AnimationListener
{
  iij(iii paramiii) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a.removeView(this.a.jdField_a_of_type_AndroidViewView);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getWindow().setBackgroundDrawable(null);
    Face2FaceAddFriendActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.n = true;
    if (Face2FaceAddFriendConstants.a >= Face2FaceAddFriendConstants.b)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a(Face2FaceAddFriendConstants.a, Face2FaceAddFriendConstants.b);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a(Face2FaceAddFriendConstants.a, 0L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iij
 * JD-Core Version:    0.7.0.1
 */