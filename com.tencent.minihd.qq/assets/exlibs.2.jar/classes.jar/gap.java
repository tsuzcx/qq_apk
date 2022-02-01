import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;

class gap
  implements Runnable
{
  gap(gao paramgao, MultiForwardChatPie paramMultiForwardChatPie, CharSequence paramCharSequence) {}
  
  public void run()
  {
    MultiForwardChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMultiForwardChatPie).setVisibility(8);
    MultiForwardChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMultiForwardChatPie).setVisibility(0);
    MultiForwardChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMultiForwardChatPie).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMultiForwardChatPie.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMultiForwardChatPie.M);
    MultiForwardChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMultiForwardChatPie).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMultiForwardChatPie.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildMultiForwardChatPie.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gap
 * JD-Core Version:    0.7.0.1
 */