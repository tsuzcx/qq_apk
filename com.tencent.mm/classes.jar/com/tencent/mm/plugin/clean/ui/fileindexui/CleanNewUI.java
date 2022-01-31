package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.plugin.f.b.7;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bq;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI
  extends MMActivity
{
  private long kHl;
  private String kHm;
  private String kHn;
  private String kHo;
  private JSONObject kHp;
  private LinearLayout kIF;
  private TextView kIG;
  private TextView kIH;
  private Button kII;
  private Button kIJ;
  private TextView kIK;
  private LinearLayout kIL;
  private TextView kIM;
  private TextView kIN;
  private Button kIO;
  private View kIP;
  private boolean kIQ;
  private com.tencent.mm.plugin.clean.b.a kIR;
  private long kIS;
  private long kIT;
  private long kIU;
  private long kIV;
  private com.tencent.mm.plugin.clean.b.c kIW;
  private com.tencent.mm.sdk.b.c<jx> kIX;
  
  public CleanNewUI()
  {
    AppMethodBeat.i(18823);
    this.kIQ = false;
    this.kIS = 0L;
    this.kIT = 0L;
    this.kIU = 0L;
    this.kIV = 0L;
    this.kHm = "com.tencent.qqpimsecure";
    this.kHn = "00B1208638DE0FCD3E920886D658DAF6";
    this.kHo = "11206657";
    this.kIW = new CleanNewUI.6(this);
    this.kIX = new CleanNewUI.9(this);
    AppMethodBeat.o(18823);
  }
  
  private void G(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(18827);
    hideProgress();
    this.kII.setEnabled(true);
    this.kIG.setText(bo.hk(paramLong1));
    int i = (int)(100L * paramLong1 / paramLong2);
    if (i > 0)
    {
      this.kIH.setText(getString(2131298406, new Object[] { i + "%" }));
      AppMethodBeat.o(18827);
      return;
    }
    this.kIH.setText(2131298407);
    AppMethodBeat.o(18827);
  }
  
  private String bas()
  {
    AppMethodBeat.i(18834);
    String str = hashCode();
    AppMethodBeat.o(18834);
    return str;
  }
  
  private boolean bhd()
  {
    AppMethodBeat.i(18832);
    bhe();
    if (!p.u(getContext(), this.kHm))
    {
      AppMethodBeat.o(18832);
      return false;
    }
    Object localObject = p.bv(this, this.kHm);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = com.tencent.mm.a.g.w(localObject[0].toByteArray());
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
            h.qsU.idkeyStat(714L, 7L, 1L, false);
            AppMethodBeat.o(18832);
            return true;
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.CleanNewUI", localException, "", new Object[0]);
          AppMethodBeat.o(18832);
          return true;
        }
      }
    }
    AppMethodBeat.o(18832);
    return false;
  }
  
  private boolean bhe()
  {
    AppMethodBeat.i(18831);
    aw.aaz();
    String str = (String)com.tencent.mm.model.c.Ru().get(ac.a.yBw, "");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(18831);
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
      AppMethodBeat.o(18831);
      return true;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(18831);
    }
    return false;
  }
  
  private void bhh()
  {
    AppMethodBeat.i(18830);
    this.kIR = new com.tencent.mm.plugin.clean.b.a(this.kIW);
    this.kIU = bo.aoy();
    com.tencent.mm.sdk.g.d.post(this.kIR, "cleanUI_calc");
    showProgress();
    h.qsU.idkeyStat(714L, 52L, 1L, false);
    AppMethodBeat.o(18830);
  }
  
  private void hideProgress()
  {
    AppMethodBeat.i(18829);
    this.kIJ.setEnabled(true);
    this.kIK.setVisibility(8);
    this.kIG.setVisibility(0);
    this.kIH.setVisibility(0);
    AppMethodBeat.o(18829);
  }
  
  private void showProgress()
  {
    AppMethodBeat.i(18828);
    this.kIJ.setEnabled(false);
    this.kIG.setVisibility(8);
    this.kIH.setVisibility(8);
    this.kIK.setVisibility(0);
    AppMethodBeat.o(18828);
  }
  
  public final void dZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18833);
    al.d(new CleanNewUI.7(this, paramInt1, paramInt2));
    AppMethodBeat.o(18833);
  }
  
  public int getLayoutId()
  {
    return 2130969165;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18824);
    super.onCreate(paramBundle);
    setMMTitle(2131298387);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(18811);
        CleanNewUI.this.finish();
        AppMethodBeat.o(18811);
        return false;
      }
    });
    this.kIF = ((LinearLayout)$(2131822869));
    this.kIG = ((TextView)$(2131822870));
    this.kIH = ((TextView)$(2131822871));
    this.kII = ((Button)$(2131822872));
    this.kII.setEnabled(false);
    this.kIJ = ((Button)$(2131822873));
    this.kIJ.setVisibility(8);
    this.kIK = ((TextView)$(2131822844));
    this.kII.setOnClickListener(new CleanNewUI.2(this));
    this.kIJ.setOnClickListener(new CleanNewUI.3(this));
    this.kIL = ((LinearLayout)$(2131822874));
    this.kIM = ((TextView)$(2131822875));
    this.kIN = ((TextView)$(2131822876));
    this.kIO = ((Button)$(2131822877));
    this.kIP = ((View)$(2131822878));
    this.kIO.setOnClickListener(new CleanNewUI.4(this));
    if ((bq.duf()) || (com.tencent.mm.sdk.platformtools.g.bWu == 1))
    {
      this.kIO.setVisibility(8);
      this.kIP.setVisibility(0);
    }
    j.bhb();
    long l1 = j.bgJ();
    j.bhb();
    long l2 = j.bgK();
    this.kIM.setText(bo.hk(l1 - l2));
    this.kIN.setText(getString(2131298384, new Object[] { bo.hk(l2) }));
    com.tencent.mm.cn.d.awm("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    try
    {
      paramBundle = new b.b();
      paramBundle.ymw = "https://";
      paramBundle.host = "jtool.qq.com";
      paramBundle.uri = "/channel?productId=31&channelId=102133";
      new com.tencent.mm.sdk.c.a((HttpURLConnection)new URL(paramBundle.getUrl()).openConnection()).a(paramBundle, new CleanNewUI.5(this, ""), new ak());
      if (b.bak().bao())
      {
        ab.i("MicroMsg.CleanNewUI", "%s it scan finish", new Object[] { bas() });
        this.kIQ = false;
        bhh();
        this.kIK.setText(getString(2131296534, new Object[] { "0%" }));
        h.qsU.idkeyStat(714L, 50L, 1L, false);
        h.qsU.idkeyStat(714L, 1L, 1L, false);
        AppMethodBeat.o(18824);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.CleanNewUI", paramBundle, paramBundle.getMessage(), new Object[0]);
        continue;
        ab.w("MicroMsg.CleanNewUI", "%s it scan not finish", new Object[] { bas() });
        this.kIS = bo.aoy();
        this.kIQ = true;
        com.tencent.mm.sdk.b.a.ymk.b(this.kIX);
        b.bak().fU(true);
        showProgress();
        dZ(0, 100);
      }
    }
  }
  
  public void onDestroy()
  {
    boolean bool = false;
    AppMethodBeat.i(18826);
    super.onDestroy();
    ab.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", new Object[] { bas(), Boolean.valueOf(this.kIQ) });
    if (this.kIQ)
    {
      com.tencent.mm.sdk.b.a.ymk.d(this.kIX);
      b localb = b.bak();
      String str = localb.bas();
      if (localb.kkg != null) {
        bool = true;
      }
      ab.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      localb.post(new b.7(localb));
    }
    if (this.kIR != null) {
      this.kIR.stop();
    }
    AppMethodBeat.o(18826);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(18825);
    super.onResume();
    if ((this.kIV > 0L) && (j.bhb().kGr != 0L))
    {
      long l = j.bhb().kGr;
      j.bhb();
      G(l, j.bgJ());
    }
    AppMethodBeat.o(18825);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI
 * JD-Core Version:    0.7.0.1
 */