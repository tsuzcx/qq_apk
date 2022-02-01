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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(19)
public class CleanUI
  extends MMActivity
{
  private long oqR;
  private String oqS = "com.tencent.qqpimsecure";
  private String oqT = "00B1208638DE0FCD3E920886D658DAF6";
  private String oqU = "11206657";
  private JSONObject oqV;
  
  private boolean bVh()
  {
    AppMethodBeat.i(22841);
    bVi();
    if (!q.t(getContext(), this.oqS))
    {
      AppMethodBeat.o(22841);
      return false;
    }
    Object localObject = q.bK(this, this.oqS);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = g.getMessageDigest(localObject[0].toByteArray());
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.oqT))) {
        try
        {
          localObject = getPackageManager().getLaunchIntentForPackage(this.oqS);
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            q.k(localBundle, this.oqU);
            ((Intent)localObject).putExtras(localBundle);
            ((Intent)localObject).addFlags(268435456);
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            h.wUl.idkeyStat(282L, 6L, 1L, false);
            AppMethodBeat.o(22841);
            return true;
          }
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.CleanUI", localException, "", new Object[0]);
          AppMethodBeat.o(22841);
          return true;
        }
      }
    }
    AppMethodBeat.o(22841);
    return false;
  }
  
  private boolean bVi()
  {
    AppMethodBeat.i(22842);
    az.ayM();
    String str = (String)c.agA().get(ah.a.GHH, "");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(22842);
      return false;
    }
    try
    {
      this.oqV = new JSONObject(str);
      this.oqS = this.oqV.getString("packageName");
      this.oqV.get("md5");
      this.oqU = this.oqV.getString("launcherID");
      this.oqT = this.oqV.getString("signature");
      this.oqV.get("url");
      this.oqR = this.oqV.getLong("size");
      AppMethodBeat.o(22842);
      return true;
    }
    catch (JSONException localJSONException)
    {
      ac.printErrStackTrace("MicroMsg.CleanUI", localJSONException, "", new Object[0]);
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
    if ((getIntent().getBooleanExtra("had_detected_no_sdcard_space", false)) && (bVh()))
    {
      finish();
      AppMethodBeat.o(22840);
      return;
    }
    paramBundle = new Intent(this, CleanNewUI.class);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.aeD(), "com/tencent/mm/plugin/clean/ui/CleanUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramBundle.lR(0));
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