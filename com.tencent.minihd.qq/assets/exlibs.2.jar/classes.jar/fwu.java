import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.vipgift.VipGiftManager;

public class fwu
  implements View.OnClickListener
{
  public fwu(StructingMsgItemBuilder paramStructingMsgItemBuilder, long paramLong, AbsStructMsg paramAbsStructMsg, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.h = true;
    if (StructingMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder)) {}
    while ((((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.a.getManager(72)).b(this.jdField_a_of_type_Long)) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID == 38)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fwu
 * JD-Core Version:    0.7.0.1
 */