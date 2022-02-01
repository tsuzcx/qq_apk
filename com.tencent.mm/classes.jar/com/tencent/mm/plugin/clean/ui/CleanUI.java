package com.tencent.mm.plugin.clean.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(19)
public class CleanUI
  extends MMActivity
{
  private long nNP;
  private String nNQ = "com.tencent.qqpimsecure";
  private String nNR = "00B1208638DE0FCD3E920886D658DAF6";
  private String nNS = "11206657";
  private JSONObject nNT;
  
  private boolean bNW()
  {
    AppMethodBeat.i(22841);
    bNX();
    if (!q.t(getContext(), this.nNQ))
    {
      AppMethodBeat.o(22841);
      return false;
    }
    Object localObject = q.bJ(this, this.nNQ);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = g.getMessageDigest(localObject[0].toByteArray());
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.nNR))) {
        try
        {
          localObject = getPackageManager().getLaunchIntentForPackage(this.nNQ);
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            q.j(localBundle, this.nNS);
            ((Intent)localObject).putExtras(localBundle);
            ((Intent)localObject).addFlags(268435456);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            h.vKh.idkeyStat(282L, 6L, 1L, false);
            AppMethodBeat.o(22841);
            return true;
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.CleanUI", localException, "", new Object[0]);
          AppMethodBeat.o(22841);
          return true;
        }
      }
    }
    AppMethodBeat.o(22841);
    return false;
  }
  
  private boolean bNX()
  {
    AppMethodBeat.i(22842);
    az.arV();
    String str = (String)c.afk().get(ae.a.FjS, "");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(22842);
      return false;
    }
    try
    {
      this.nNT = new JSONObject(str);
      this.nNQ = this.nNT.getString("packageName");
      this.nNT.get("md5");
      this.nNS = this.nNT.getString("launcherID");
      this.nNR = this.nNT.getString("signature");
      this.nNT.get("url");
      this.nNP = this.nNT.getLong("size");
      AppMethodBeat.o(22842);
      return true;
    }
    catch (JSONException localJSONException)
    {
      ad.printErrStackTrace("MicroMsg.CleanUI", localJSONException, "", new Object[0]);
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
    if ((getIntent().getBooleanExtra("had_detected_no_sdcard_space", false)) && (bNW()))
    {
      finish();
      AppMethodBeat.o(22840);
      return;
    }
    paramBundle = new Intent(this, CleanNewUI.class);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bd(paramBundle);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.adn(), "com/tencent/mm/plugin/clean/ui/CleanUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramBundle.lS(0));
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