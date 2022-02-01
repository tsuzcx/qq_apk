package com.tencent.mm.plugin.clean.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(19)
public class CleanUI
  extends MMActivity
{
  private static final String qpO;
  private long qpP;
  private String qpQ = "com.tencent.qqpimsecure";
  private String qpR = "00B1208638DE0FCD3E920886D658DAF6";
  private String qpS = "11206657";
  private JSONObject qpT;
  
  static
  {
    AppMethodBeat.i(231659);
    qpO = "https://" + WeChatHosts.domainString(2131761749) + "/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen";
    AppMethodBeat.o(231659);
  }
  
  private boolean cyQ()
  {
    AppMethodBeat.i(22841);
    cyR();
    if (!q.s(getContext(), this.qpQ))
    {
      AppMethodBeat.o(22841);
      return false;
    }
    Object localObject = q.cj(this, this.qpQ);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = g.getMessageDigest(localObject[0].toByteArray());
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.qpR))) {
        try
        {
          localObject = getPackageManager().getLaunchIntentForPackage(this.qpQ);
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            q.k(localBundle, this.qpS);
            ((Intent)localObject).putExtras(localBundle);
            ((Intent)localObject).addFlags(268435456);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            h.CyF.idkeyStat(282L, 6L, 1L, false);
            AppMethodBeat.o(22841);
            return true;
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.CleanUI", localException, "", new Object[0]);
          AppMethodBeat.o(22841);
          return true;
        }
      }
    }
    AppMethodBeat.o(22841);
    return false;
  }
  
  private boolean cyR()
  {
    AppMethodBeat.i(22842);
    bg.aVF();
    String str = (String)c.azQ().get(ar.a.NWy, "");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(22842);
      return false;
    }
    try
    {
      this.qpT = new JSONObject(str);
      this.qpQ = this.qpT.getString("packageName");
      this.qpT.get("md5");
      this.qpS = this.qpT.getString("launcherID");
      this.qpR = this.qpT.getString("signature");
      this.qpT.get("url");
      this.qpP = this.qpT.getLong("size");
      AppMethodBeat.o(22842);
      return true;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.CleanUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(22842);
    }
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131493658;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22840);
    super.onCreate(paramBundle);
    if ((getIntent().getBooleanExtra("had_detected_no_sdcard_space", false)) && (cyQ()))
    {
      finish();
      AppMethodBeat.o(22840);
      return;
    }
    paramBundle = new Intent(this, CleanNewUI.class);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.axQ(), "com/tencent/mm/plugin/clean/ui/CleanUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramBundle.pG(0));
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