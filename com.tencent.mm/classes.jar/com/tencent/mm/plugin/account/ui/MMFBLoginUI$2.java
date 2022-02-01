package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.mmfb.sdk.f;
import org.json.JSONObject;

final class MMFBLoginUI$2
  implements MMHandlerThread.IWaitWorkThread
{
  JSONObject qcc = null;
  
  MMFBLoginUI$2(MMFBLoginUI paramMMFBLoginUI) {}
  
  public final boolean doInBackground()
  {
    AppMethodBeat.i(305257);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("fields", "name,picture.type(large)");
    try
    {
      localObject = MMFBLoginUI.a(this.qcb).y("me", (Bundle)localObject);
      Log.i("MicroMsg.FacebookLoginUI", "result json %s", new Object[] { localObject });
      this.qcc = new JSONObject((String)localObject);
      AppMethodBeat.o(305257);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FacebookLoginUI", localException, "get name and picture error!", new Object[0]);
        k.c(this.qcb, "Retrieve Failed, Error Format!", "", true);
      }
    }
  }
  
  public final boolean onPostExecute()
  {
    AppMethodBeat.i(305259);
    if (this.qcc != null) {}
    try
    {
      Object localObject = new Intent(this.qcb, RegByMobileRegAIOUI.class);
      ((Intent)localObject).putExtra("third_app_token", MMFBLoginUI.a(this.qcb).pNX.toString());
      ((Intent)localObject).putExtra("register_title", this.qcb.getString(r.j.continue_register_title));
      ((Intent)localObject).putExtra("register_nick_name", this.qcc.getString("name"));
      ((Intent)localObject).putExtra("register_avatar", ((JSONObject)this.qcc.get("picture")).getJSONObject("data").getString("url"));
      MMFBLoginUI localMMFBLoginUI = this.qcb;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localMMFBLoginUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/MMFBLoginUI$2", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localMMFBLoginUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localMMFBLoginUI, "com/tencent/mm/plugin/account/ui/MMFBLoginUI$2", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      MMFBLoginUI.b(this.qcb).joN = 1L;
      MMFBLoginUI.b(this.qcb).ikE = 4L;
      MMFBLoginUI.b(this.qcb).bMH();
      this.qcb.finish();
      AppMethodBeat.o(305259);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FacebookLoginUI", localException, "parse json error!", new Object[0]);
        k.c(this.qcb, "Retrieve Failed, Error Format!", "", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MMFBLoginUI.2
 * JD-Core Version:    0.7.0.1
 */