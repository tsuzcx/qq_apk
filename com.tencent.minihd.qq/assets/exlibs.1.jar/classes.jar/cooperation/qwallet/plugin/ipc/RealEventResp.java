package cooperation.qwallet.plugin.ipc;

import Wallet.RspRealApplication;
import android.os.Bundle;

public class RealEventResp
  extends BaseResp
{
  public RspRealApplication a;
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.a != null) {
      paramBundle.putSerializable("_qwallet_ipc_RealEvent_resp", this.a);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.a = ((RspRealApplication)paramBundle.getSerializable("_qwallet_ipc_RealEvent_resp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.RealEventResp
 * JD-Core Version:    0.7.0.1
 */