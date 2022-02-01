import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class gbk
  implements DialogInterface.OnClickListener
{
  public gbk(PublicAccountChatPie paramPublicAccountChatPie, PublicAccountDataManager paramPublicAccountDataManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie).mIsAgreeSyncLbs = true;
    PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie).mIsSyncLbsSelected = true;
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a(PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie));
    PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie, 1, null);
    paramDialogInterface = new gbl(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a.a(paramDialogInterface);
    PublicAccountChatPie.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbk
 * JD-Core Version:    0.7.0.1
 */