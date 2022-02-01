import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.flaotaio.BaseFloatChatPie;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.utils.ContactUtils;

public class gks
  extends FriendListObserver
{
  public gks(BaseFloatChatPie paramBaseFloatChatPie) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject + ""))) {
      this.a.s();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {}
    switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        this.a.b.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ContactUtils.j(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null) {}
      for (paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;; paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
      {
        paramString2.d = paramString1;
        break;
      }
    case 1: 
      this.a.a(false);
      return;
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gks
 * JD-Core Version:    0.7.0.1
 */