package cooperation.qwallet.plugin.ipc;

import Wallet.RspPayApplication;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletHomeObserver;
import com.tencent.mobileqq.app.soso.SosoInterface;
import cooperation.qwallet.plugin.QWalletHelper;
import mak;
import mal;

public class RecommendReq
  extends BaseReq
{
  public static final int a = 1;
  public static final int b = 2;
  public QWalletHomeObserver a = new mal(this);
  public int c;
  
  public void a()
  {
    QQAppInterface localQQAppInterface = QWalletHelper.a();
    if (localQQAppInterface == null)
    {
      a(null);
      return;
    }
    switch (this.c)
    {
    default: 
      a(null);
      return;
    }
    a(localQQAppInterface);
  }
  
  public void a(RspPayApplication paramRspPayApplication)
  {
    Object localObject = QWalletHelper.a();
    if (localObject != null) {
      ((QQAppInterface)localObject).c(this.a);
    }
    localObject = new RecommendResp();
    ((RecommendResp)localObject).jdField_a_of_type_WalletRspPayApplication = paramRspPayApplication;
    ((RecommendResp)localObject).jdField_a_of_type_Int = this.c;
    paramRspPayApplication = new Bundle();
    ((RecommendResp)localObject).a(paramRspPayApplication);
    super.a(paramRspPayApplication);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putInt("_qwallet_ipc_RecommendReq_recommendType", this.c);
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    SosoInterface.a(new mak(this, 3, true, 0L, false, false, "RecommendReq", paramQQAppInterface));
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.c = paramBundle.getInt("_qwallet_ipc_RecommendReq_recommendType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.RecommendReq
 * JD-Core Version:    0.7.0.1
 */