import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView;
import com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.IFace2faceContext;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.qphone.base.util.QLog;

public class ijb
  implements Animation.AnimationListener
{
  public ijb(Face2FaceDetailBaseView paramFace2FaceDetailBaseView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(4);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.b();
    this.a.c.setBackgroundDrawable(null);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.d();
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceDetailBaseView", 2, "animHide, onAnimationEnd " + hashCode());
    }
    Face2FaceDetailBaseView.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceDetailBaseView", 2, "animHide, onAnimationStart " + hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ijb
 * JD-Core Version:    0.7.0.1
 */