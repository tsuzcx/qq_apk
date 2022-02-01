package com.tencent.mm.plugin.clean.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(19)
public class CleanUI
  extends MMActivity
{
  private long paQ;
  private String paR = "com.tencent.qqpimsecure";
  private String paS = "00B1208638DE0FCD3E920886D658DAF6";
  private String paT = "11206657";
  private JSONObject paU;
  
  private boolean cbb()
  {
    AppMethodBeat.i(22841);
    cbc();
    if (!q.s(getContext(), this.paR))
    {
      AppMethodBeat.o(22841);
      return false;
    }
    Object localObject = q.bP(this, this.paR);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = com.tencent.mm.b.g.getMessageDigest(localObject[0].toByteArray());
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.paS))) {
        try
        {
          localObject = getPackageManager().getLaunchIntentForPackage(this.paR);
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            q.j(localBundle, this.paT);
            ((Intent)localObject).putExtras(localBundle);
            ((Intent)localObject).addFlags(268435456);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(282L, 6L, 1L, false);
            AppMethodBeat.o(22841);
            return true;
          }
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.CleanUI", localException, "", new Object[0]);
          AppMethodBeat.o(22841);
          return true;
        }
      }
    }
    AppMethodBeat.o(22841);
    return false;
  }
  
  private boolean cbc()
  {
    AppMethodBeat.i(22842);
    bc.aCg();
    String str = (String)c.ajA().get(am.a.IOw, "");
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(22842);
      return false;
    }
    try
    {
      this.paU = new JSONObject(str);
      this.paR = this.paU.getString("packageName");
      this.paU.get("md5");
      this.paT = this.paU.getString("launcherID");
      this.paS = this.paU.getString("signature");
      this.paU.get("url");
      this.paQ = this.paU.getLong("size");
      AppMethodBeat.o(22842);
      return true;
    }
    catch (JSONException localJSONException)
    {
      ae.printErrStackTrace("MicroMsg.CleanUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(22842);
    }
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131493546;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22840);
    super.onCreate(paramBundle);
    if ((getIntent().getBooleanExtra("had_detected_no_sdcard_space", false)) && (cbb()))
    {
      finish();
      AppMethodBeat.o(22840);
      return;
    }
    paramBundle = new Intent(this, CleanNewUI.class);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahE(), "com/tencent/mm/plugin/clean/ui/CleanUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramBundle.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/CleanUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(22840);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.CleanUI
 * JD-Core Version:    0.7.0.1
 */