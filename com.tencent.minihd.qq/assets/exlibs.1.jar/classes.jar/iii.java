import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

public class iii
  implements View.OnClickListener
{
  public iii(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.app.getPreferences().edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
    paramView = new AlphaAnimation(1.0F, 0.0F);
    paramView.setDuration(500L);
    paramView.setAnimationListener(new iij(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iii
 * JD-Core Version:    0.7.0.1
 */