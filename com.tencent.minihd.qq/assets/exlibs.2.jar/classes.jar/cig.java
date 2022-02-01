import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.qphone.base.util.QLog;

public class cig
  extends Handler
{
  public cig(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (this.a.jdField_a_of_type_Boolean)
      {
        AccountDetailActivity.e(this.a);
        AccountDetailActivity.a(this.a);
      }
      while (QLog.isColorLevel())
      {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "update exit");
        return;
        AccountDetailActivity.e(this.a);
      }
    }
    paramMessage = new Intent();
    paramMessage.putExtra("isNeedFinish", true);
    this.a.setResult(-1, paramMessage);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cig
 * JD-Core Version:    0.7.0.1
 */