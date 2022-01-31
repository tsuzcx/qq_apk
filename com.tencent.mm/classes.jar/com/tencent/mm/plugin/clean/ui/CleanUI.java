package com.tencent.mm.plugin.clean.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import org.json.JSONException;
import org.json.JSONObject;

@a(19)
public class CleanUI
  extends MMActivity
{
  private long kHl;
  private String kHm = "com.tencent.qqpimsecure";
  private String kHn = "00B1208638DE0FCD3E920886D658DAF6";
  private String kHo = "11206657";
  private JSONObject kHp;
  
  private boolean bhd()
  {
    AppMethodBeat.i(18732);
    bhe();
    if (!p.u(getContext(), this.kHm))
    {
      AppMethodBeat.o(18732);
      return false;
    }
    Object localObject = p.bv(this, this.kHm);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = g.w(localObject[0].toByteArray());
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.kHn))) {
        try
        {
          localObject = getPackageManager().getLaunchIntentForPackage(this.kHm);
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            p.j(localBundle, this.kHo);
            ((Intent)localObject).putExtras(localBundle);
            ((Intent)localObject).addFlags(268435456);
            startActivity((Intent)localObject);
            h.qsU.idkeyStat(282L, 6L, 1L, false);
            AppMethodBeat.o(18732);
            return true;
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.CleanUI", localException, "", new Object[0]);
          AppMethodBeat.o(18732);
          return true;
        }
      }
    }
    AppMethodBeat.o(18732);
    return false;
  }
  
  private boolean bhe()
  {
    AppMethodBeat.i(18733);
    aw.aaz();
    String str = (String)c.Ru().get(ac.a.yBw, "");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(18733);
      return false;
    }
    try
    {
      this.kHp = new JSONObject(str);
      this.kHm = this.kHp.getString("packageName");
      this.kHp.get("md5");
      this.kHo = this.kHp.getString("launcherID");
      this.kHn = this.kHp.getString("signature");
      this.kHp.get("url");
      this.kHl = this.kHp.getLong("size");
      AppMethodBeat.o(18733);
      return true;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace("MicroMsg.CleanUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(18733);
    }
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130969163;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18731);
    super.onCreate(paramBundle);
    if ((getIntent().getBooleanExtra("had_detected_no_sdcard_space", false)) && (bhd()))
    {
      finish();
      AppMethodBeat.o(18731);
      return;
    }
    startActivity(new Intent(this, CleanNewUI.class));
    finish();
    AppMethodBeat.o(18731);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.CleanUI
 * JD-Core Version:    0.7.0.1
 */