package cooperation.qwallet.plugin.ipc;

import Wallet.RspH5Config;
import android.os.Bundle;

public class PersonalInfoResp
  extends BaseResp
{
  public int a;
  public RspH5Config a;
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_WalletRspH5Config != null) {
      paramBundle.putSerializable("_qwallet_ipc_PersonalInfoResp_resp", this.jdField_a_of_type_WalletRspH5Config);
    }
    paramBundle.putInt("_qwallet_ipc_PersonalInfoResp_personalInfoReqType", this.jdField_a_of_type_Int);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_WalletRspH5Config = ((RspH5Config)paramBundle.getSerializable("_qwallet_ipc_PersonalInfoResp_resp"));
    this.jdField_a_of_type_Int = paramBundle.getInt("_qwallet_ipc_PersonalInfoResp_personalInfoReqType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.PersonalInfoResp
 * JD-Core Version:    0.7.0.1
 */