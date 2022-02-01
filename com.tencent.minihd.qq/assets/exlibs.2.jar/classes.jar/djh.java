import android.app.Dialog;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;

public class djh
  extends CardObserver
{
  public djh(BaseChatPie paramBaseChatPie) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramObject != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.uin)) && ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003)) && (paramObject.strCertificationInfo != null) && (!paramObject.strCertificationInfo.equals(""))) {
        ChatActivityFacade.d(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if ((paramBoolean) && (paramObject != null)) {}
      switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.uin)))
        {
          this.a.p();
          this.a.b.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if ((3000 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && ((this.a instanceof DiscussChatPie))) {
            ((DiscussChatPie)this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.b);
          }
        }
        return;
      }
      this.a.c(false);
      return;
    }
  }
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    if ((this.a.d != null) && (this.a.d.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.dismissDialog(231);
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(232);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     djh
 * JD-Core Version:    0.7.0.1
 */