package com.tencent.mm.plugin.clean.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(19)
public class CleanUI
  extends MMActivity
{
  private long oUn;
  private String oUo = "com.tencent.qqpimsecure";
  private String oUp = "00B1208638DE0FCD3E920886D658DAF6";
  private String oUq = "11206657";
  private JSONObject oUr;
  
  private boolean bZM()
  {
    AppMethodBeat.i(22841);
    bZN();
    if (!q.s(getContext(), this.oUo))
    {
      AppMethodBeat.o(22841);
      return false;
    }
    Object localObject = q.bO(this, this.oUo);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = com.tencent.mm.b.g.getMessageDigest(localObject[0].toByteArray());
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.oUp))) {
        try
        {
          localObject = getPackageManager().getLaunchIntentForPackage(this.oUo);
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            q.j(localBundle, this.oUq);
            ((Intent)localObject).putExtras(localBundle);
            ((Intent)localObject).addFlags(268435456);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/CleanUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(282L, 6L, 1L, false);
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
  
  private boolean bZN()
  {
    AppMethodBeat.i(22842);
    ba.aBQ();
    String str = (String)c.ajl().get(al.a.ItZ, "");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(22842);
      return false;
    }
    try
    {
      this.oUr = new JSONObject(str);
      this.oUo = this.oUr.getString("packageName");
      this.oUr.get("md5");
      this.oUq = this.oUr.getString("launcherID");
      this.oUp = this.oUr.getString("signature");
      this.oUr.get("url");
      this.oUn = this.oUr.getLong("size");
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
    if ((getIntent().getBooleanExtra("had_detected_no_sdcard_space", false)) && (bZM()))
    {
      finish();
      AppMethodBeat.o(22840);
      return;
    }
    paramBundle = new Intent(this, CleanNewUI.class);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahp(), "com/tencent/mm/plugin/clean/ui/CleanUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramBundle.mq(0));
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