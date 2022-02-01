package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import java.util.ArrayList;

public class RedTouchResp
  extends BaseResp
{
  public int a;
  public ArrayList a;
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.a != null) {
      paramBundle.putSerializable("_qwallet_ipc_RedTouch_resp", this.a);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.a = ((ArrayList)paramBundle.getSerializable("_qwallet_ipc_RedTouch_resp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.RedTouchResp
 * JD-Core Version:    0.7.0.1
 */