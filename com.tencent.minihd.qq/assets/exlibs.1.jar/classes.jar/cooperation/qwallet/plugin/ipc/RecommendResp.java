package cooperation.qwallet.plugin.ipc;

import Wallet.RspPayApplication;
import android.os.Bundle;

public class RecommendResp
  extends BaseResp
{
  public int a;
  public RspPayApplication a;
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_WalletRspPayApplication != null) {
      paramBundle.putSerializable("_qwallet_ipc_RecommentResp_resp", this.jdField_a_of_type_WalletRspPayApplication);
    }
    paramBundle.putInt("_qwallet_ipc_RecommendResp_recommendType", this.jdField_a_of_type_Int);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_WalletRspPayApplication = ((RspPayApplication)paramBundle.getSerializable("_qwallet_ipc_RecommentResp_resp"));
    this.jdField_a_of_type_Int = paramBundle.getInt("_qwallet_ipc_RecommendResp_recommendType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.RecommendResp
 * JD-Core Version:    0.7.0.1
 */