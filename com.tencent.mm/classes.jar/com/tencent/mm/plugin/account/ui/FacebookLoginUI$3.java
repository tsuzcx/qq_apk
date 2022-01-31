package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.s;

final class FacebookLoginUI$3
  implements Runnable
{
  FacebookLoginUI$3(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void run()
  {
    int i;
    Object localObject;
    if (bk.a((Integer)g.DP().Dz().get(65833, null), 0) > 0)
    {
      i = 1;
      if (i == 0) {
        break label98;
      }
      localObject = com.tencent.mm.plugin.account.a.a.eUR.aN(this.flX);
      ((Intent)localObject).addFlags(67108864);
      Intent localIntent = new Intent(this.flX.mController.uMN, BindMContactIntroUI.class);
      localIntent.putExtra("key_upload_scene", 1);
      MMWizardActivity.b(this.flX, localIntent, (Intent)localObject);
    }
    for (;;)
    {
      this.flX.finish();
      return;
      i = 0;
      break;
      label98:
      localObject = com.tencent.mm.plugin.account.a.a.eUR.aN(this.flX);
      ((Intent)localObject).addFlags(67108864);
      this.flX.startActivity((Intent)localObject);
      localObject = new StringBuilder();
      g.DN();
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.Df()).append(",").append(this.flX.getClass().getName()).append(",L14,");
      g.DN();
      com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("L14") + ",4");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.3
 * JD-Core Version:    0.7.0.1
 */