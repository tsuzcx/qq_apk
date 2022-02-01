import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.ThreadPriorityManager;

public final class cgu
  implements Animation.AnimationListener
{
  public cgu(Intent paramIntent, SearchProtocol.WordItem paramWordItem, BaseActivity paramBaseActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("request_home_hot_word", this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 1688001);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
    ThreadPriorityManager.a(false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgu
 * JD-Core Version:    0.7.0.1
 */