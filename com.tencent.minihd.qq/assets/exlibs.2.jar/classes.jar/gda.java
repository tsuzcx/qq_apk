import android.os.Handler;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

class gda
  implements Runnable
{
  gda(gcy paramgcy) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog != null) {
      this.a.a.jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.dismiss();
    }
    this.a.a.f(true);
    this.a.a.ag();
    if (!AnonymousChatHelper.a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      TroopChatPie.b(this.a.a).postDelayed(new gdb(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gda
 * JD-Core Version:    0.7.0.1
 */