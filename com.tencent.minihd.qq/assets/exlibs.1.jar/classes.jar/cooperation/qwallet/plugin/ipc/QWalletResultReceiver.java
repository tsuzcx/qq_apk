package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class QWalletResultReceiver
  extends ResultReceiver
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static QWalletResultReceiver jdField_a_of_type_CooperationQwalletPluginIpcQWalletResultReceiver;
  
  public QWalletResultReceiver(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public static QWalletResultReceiver a()
  {
    if (jdField_a_of_type_CooperationQwalletPluginIpcQWalletResultReceiver == null)
    {
      jdField_a_of_type_AndroidOsHandler = new Handler();
      jdField_a_of_type_CooperationQwalletPluginIpcQWalletResultReceiver = new QWalletResultReceiver(jdField_a_of_type_AndroidOsHandler);
    }
    return jdField_a_of_type_CooperationQwalletPluginIpcQWalletResultReceiver;
  }
  
  public static void a()
  {
    jdField_a_of_type_CooperationQwalletPluginIpcQWalletResultReceiver = null;
    jdField_a_of_type_AndroidOsHandler = null;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramBundle = BaseReq.a(paramBundle);
    if (paramBundle != null) {
      paramBundle.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.QWalletResultReceiver
 * JD-Core Version:    0.7.0.1
 */