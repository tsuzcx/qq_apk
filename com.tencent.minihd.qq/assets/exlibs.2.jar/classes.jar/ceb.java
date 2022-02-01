import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.OfflineSecurity.VerifyListener;

public final class ceb
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (OfflineSecurity.jdField_a_of_type_ComTencentBizCommonUtilOfflineSecurity$VerifyListener != null)
    {
      OfflineSecurity.jdField_a_of_type_ComTencentBizCommonUtilOfflineSecurity$VerifyListener.a(((Boolean)paramMessage.obj).booleanValue());
      OfflineSecurity.jdField_a_of_type_ComTencentBizCommonUtilOfflineSecurity$VerifyListener = null;
      OfflineSecurity.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ceb
 * JD-Core Version:    0.7.0.1
 */