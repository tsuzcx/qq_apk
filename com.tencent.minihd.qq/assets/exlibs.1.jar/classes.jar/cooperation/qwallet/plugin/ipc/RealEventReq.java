package cooperation.qwallet.plugin.ipc;

import Wallet.RspRealApplication;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletHomeObserver;
import com.tencent.mobileqq.app.soso.SosoInterface;
import cooperation.qwallet.plugin.QWalletHelper;
import mai;
import maj;

public class RealEventReq
  extends BaseReq
{
  public QWalletHomeObserver a = new maj(this);
  
  public void a()
  {
    QQAppInterface localQQAppInterface = QWalletHelper.a();
    if (localQQAppInterface == null)
    {
      a(null);
      return;
    }
    a(localQQAppInterface);
  }
  
  public void a(RspRealApplication paramRspRealApplication)
  {
    Object localObject = QWalletHelper.a();
    if (localObject != null) {
      ((QQAppInterface)localObject).c(this.a);
    }
    localObject = new RealEventResp();
    ((RealEventResp)localObject).a = paramRspRealApplication;
    paramRspRealApplication = new Bundle();
    ((RealEventResp)localObject).a(paramRspRealApplication);
    super.a(paramRspRealApplication);
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    SosoInterface.a(new mai(this, 3, true, 0L, false, false, "RealEventReq", paramQQAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.RealEventReq
 * JD-Core Version:    0.7.0.1
 */