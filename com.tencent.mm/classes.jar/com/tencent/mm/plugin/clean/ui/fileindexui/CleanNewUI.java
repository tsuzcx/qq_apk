package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.a.g;
import com.tencent.mm.h.a.jo;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.h.b.5;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bm;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI
  extends MMActivity
{
  private long iCe;
  private String iCf = "com.tencent.qqpimsecure";
  private String iCg = "00B1208638DE0FCD3E920886D658DAF6";
  private String iCh = "11206657";
  private JSONObject iCi;
  private TextView iDA;
  private Button iDB;
  private Button iDC;
  private TextView iDD;
  private LinearLayout iDE;
  private TextView iDF;
  private TextView iDG;
  private Button iDH;
  private View iDI;
  private boolean iDJ = false;
  private com.tencent.mm.plugin.clean.b.a iDK;
  private long iDL = 0L;
  private long iDM = 0L;
  private long iDN = 0L;
  private long iDO = 0L;
  private com.tencent.mm.plugin.clean.b.c iDP = new CleanNewUI.6(this);
  private com.tencent.mm.sdk.b.c<jo> iDQ = new CleanNewUI.9(this);
  private LinearLayout iDy;
  private TextView iDz;
  
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
        h.nFQ.a(714L, 7L, 1L, false);
        return true;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.CleanNewUI", localException, "", new Object[0]);
    }
    return true;
  }
  
  private boolean aEd()
  {
    au.Hx();
    String str = (String)com.tencent.mm.model.c.Dz().get(ac.a.urx, "");
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
      y.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
    }
    return false;
  }
  
  private void aEg()
  {
    this.iDC.setEnabled(false);
    this.iDz.setVisibility(8);
    this.iDA.setVisibility(8);
    this.iDD.setVisibility(0);
  }
  
  private void aEh()
  {
    this.iDK = new com.tencent.mm.plugin.clean.b.a(this.iDP);
    this.iDN = bk.UY();
    com.tencent.mm.sdk.f.e.post(this.iDK, "cleanUI_calc");
    aEg();
    h.nFQ.a(714L, 52L, 1L, false);
  }
  
  private String ayL()
  {
    return hashCode();
  }
  
  private void u(long paramLong1, long paramLong2)
  {
    this.iDC.setEnabled(true);
    this.iDD.setVisibility(8);
    this.iDz.setVisibility(0);
    this.iDA.setVisibility(0);
    this.iDB.setEnabled(true);
    this.iDz.setText(bk.cm(paramLong1));
    int i = (int)(100L * paramLong1 / paramLong2);
    if (i > 0)
    {
      this.iDA.setText(getString(R.l.clean_wechat_size_tips, new Object[] { i + "%" }));
      return;
    }
    this.iDA.setText(R.l.clean_wechat_size_tips_less_1_percent);
  }
  
  public final void cB(int paramInt1, int paramInt2)
  {
    ai.d(new CleanNewUI.7(this, paramInt1, paramInt2));
  }
  
  protected final int getLayoutId()
  {
    return R.i.clean_new_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.clean_msg_ui_title);
    setBackBtn(new CleanNewUI.1(this));
    this.iDy = ((LinearLayout)findViewById(R.h.wechat_root));
    this.iDz = ((TextView)findViewById(R.h.wechat_size));
    this.iDA = ((TextView)findViewById(R.h.wechat_size_tip));
    this.iDB = ((Button)findViewById(R.h.wechat_clean_msg_btn));
    this.iDB.setEnabled(false);
    this.iDC = ((Button)findViewById(R.h.wechat_clean_cache_btn));
    this.iDC.setVisibility(8);
    this.iDD = ((TextView)findViewById(R.h.process_info_tv));
    this.iDB.setOnClickListener(new CleanNewUI.2(this));
    this.iDC.setOnClickListener(new CleanNewUI.3(this));
    this.iDE = ((LinearLayout)findViewById(R.h.mobile_root));
    this.iDF = ((TextView)findViewById(R.h.mobile_size));
    this.iDG = ((TextView)findViewById(R.h.mobile_size_tip));
    this.iDH = ((Button)findViewById(R.h.qq_manager_clean_btn));
    this.iDI = ((View)findViewById(R.h.qq_manager_padding));
    this.iDH.setOnClickListener(new CleanNewUI.4(this));
    if ((bm.csh()) || (com.tencent.mm.sdk.platformtools.e.bvj == 1))
    {
      this.iDH.setVisibility(8);
      this.iDI.setVisibility(0);
    }
    j.aEb();
    long l1 = j.aDI();
    j.aEb();
    long l2 = j.aDJ();
    this.iDF.setText(bk.cm(l1 - l2));
    this.iDG.setText(getString(R.l.clean_mobile_size_tips, new Object[] { bk.cm(l2) }));
    com.tencent.mm.cl.b.afs("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    try
    {
      paramBundle = new b.b();
      paramBundle.ued = "https://";
      paramBundle.host = "jtool.qq.com";
      paramBundle.uri = "/channel?productId=31&channelId=102133";
      new com.tencent.mm.sdk.c.a((HttpURLConnection)new URL(paramBundle.getUrl()).openConnection()).a(paramBundle, new CleanNewUI.5(this, ""), new ah());
      if (com.tencent.mm.plugin.h.b.ayE().ayH())
      {
        y.i("MicroMsg.CleanNewUI", "%s it scan finish", new Object[] { ayL() });
        this.iDJ = false;
        aEh();
        this.iDD.setText(getString(R.l.analyse_file_profress, new Object[] { "0%" }));
        h.nFQ.a(714L, 50L, 1L, false);
        h.nFQ.a(714L, 1L, 1L, false);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.CleanNewUI", paramBundle, paramBundle.getMessage(), new Object[0]);
        continue;
        y.w("MicroMsg.CleanNewUI", "%s it scan not finish", new Object[] { ayL() });
        this.iDL = bk.UY();
        this.iDJ = true;
        com.tencent.mm.sdk.b.a.udP.b(this.iDQ);
        com.tencent.mm.plugin.h.b.ayE().ev(true);
        aEg();
        cB(0, 100);
      }
    }
  }
  
  protected void onDestroy()
  {
    boolean bool = false;
    super.onDestroy();
    y.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", new Object[] { ayL(), Boolean.valueOf(this.iDJ) });
    if (this.iDJ)
    {
      com.tencent.mm.sdk.b.a.udP.d(this.iDQ);
      com.tencent.mm.plugin.h.b localb = com.tencent.mm.plugin.h.b.ayE();
      String str = localb.ayL();
      if (localb.ijg != null) {
        bool = true;
      }
      y.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      localb.f(new b.5(localb));
    }
    if (this.iDK != null) {
      this.iDK.stop();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.iDO > 0L) && (j.aEb().iBk != 0L))
    {
      long l = j.aEb().iBk;
      j.aEb();
      u(l, j.aDI());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI
 * JD-Core Version:    0.7.0.1
 */