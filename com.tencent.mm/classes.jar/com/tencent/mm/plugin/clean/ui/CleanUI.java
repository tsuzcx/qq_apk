package com.tencent.mm.plugin.clean.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.R.i;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;
import org.json.JSONException;
import org.json.JSONObject;

@a(19)
public class CleanUI
  extends MMActivity
{
  private long iCe;
  private String iCf = "com.tencent.qqpimsecure";
  private String iCg = "00B1208638DE0FCD3E920886D658DAF6";
  private String iCh = "11206657";
  private JSONObject iCi;
  
  private boolean aEc()
  {
    aEd();
    if (!p.o(this.mController.uMN, this.iCf)) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = p.bj(this, this.iCf);
      } while ((localObject == null) || (localObject[0] == null));
      localObject = g.o(localObject[0].toByteArray());
    } while ((localObject == null) || (!((String)localObject).equalsIgnoreCase(this.iCg)));
    try
    {
      localObject = getPackageManager().getLaunchIntentForPackage(this.iCf);
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        p.i(localBundle, this.iCh);
        ((Intent)localObject).putExtras(localBundle);
        ((Intent)localObject).addFlags(268435456);
        startActivity((Intent)localObject);
        h.nFQ.a(282L, 6L, 1L, false);
        return true;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.CleanUI", localException, "", new Object[0]);
    }
    return true;
  }
  
  private boolean aEd()
  {
    au.Hx();
    String str = (String)c.Dz().get(ac.a.urx, "");
    if (bk.bl(str)) {
      return false;
    }
    try
    {
      this.iCi = new JSONObject(str);
      this.iCf = this.iCi.getString("packageName");
      this.iCi.get("md5");
      this.iCh = this.iCi.getString("launcherID");
      this.iCg = this.iCi.getString("signature");
      this.iCi.get("url");
      this.iCe = this.iCi.getLong("size");
      return true;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.CleanUI", localJSONException, "", new Object[0]);
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return R.i.clean_empty;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((getIntent().getBooleanExtra("had_detected_no_sdcard_space", false)) && (aEc()))
    {
      finish();
      return;
    }
    startActivity(new Intent(this, CleanNewUI.class));
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.CleanUI
 * JD-Core Version:    0.7.0.1
 */