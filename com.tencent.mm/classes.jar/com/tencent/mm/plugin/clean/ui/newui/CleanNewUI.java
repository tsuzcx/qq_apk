package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bm;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.g
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
  private LinearLayout iDy;
  private TextView iDz;
  private com.tencent.mm.plugin.clean.c.c iEg;
  
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
      localObject = com.tencent.mm.a.g.o(localObject[0].toByteArray());
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
  
  private void u(long paramLong1, long paramLong2)
  {
    this.iDC.setEnabled(true);
    this.iDD.setVisibility(8);
    this.iDz.setVisibility(0);
    this.iDA.setVisibility(0);
    this.iDz.setText(bk.cm(paramLong1));
    int i = (int)(100L * paramLong1 / paramLong2);
    this.iDA.setText(getString(R.l.clean_wechat_size_tips, new Object[] { i + "%" }));
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, ArrayList<com.tencent.mm.plugin.clean.c.b> paramArrayList, long paramLong4, HashSet<String> paramHashSet)
  {
    y.i("MicroMsg.CleanNewUI", "wechatSize[%d] accSize[%d] otherAccSize[%d]", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
    d.cX(paramLong1);
    d.cU(paramLong2);
    d.cW(paramLong4);
    d.b(paramHashSet);
    d.cV(paramLong3);
    d.p(paramArrayList);
    u(d.aDR(), com.tencent.mm.plugin.clean.c.c.aDI());
  }
  
  public final void cz(int paramInt1, int paramInt2)
  {
    this.iDD.setText(getString(R.l.analyse_file_profress, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
  }
  
  protected final int getLayoutId()
  {
    return R.i.clean_new_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.clean_ui_title);
    setBackBtn(new CleanNewUI.1(this));
    this.iDy = ((LinearLayout)findViewById(R.h.wechat_root));
    this.iDz = ((TextView)findViewById(R.h.wechat_size));
    this.iDA = ((TextView)findViewById(R.h.wechat_size_tip));
    this.iDB = ((Button)findViewById(R.h.wechat_clean_msg_btn));
    this.iDC = ((Button)findViewById(R.h.wechat_clean_cache_btn));
    this.iDC.setVisibility(8);
    this.iDD = ((TextView)findViewById(R.h.process_info_tv));
    this.iDB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        y.i("MicroMsg.CleanNewUI", "goto clean msg ui");
        CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanMsgUI.class), 0);
      }
    });
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
    long l1 = com.tencent.mm.plugin.clean.c.c.aDI();
    long l2 = com.tencent.mm.plugin.clean.c.c.aDJ();
    this.iDF.setText(bk.cm(l1 - l2));
    this.iDG.setText(getString(R.l.clean_mobile_size_tips, new Object[] { bk.cm(l2) }));
    com.tencent.mm.cl.b.afs("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    try
    {
      paramBundle = new b.b();
      paramBundle.ued = "https://";
      paramBundle.host = "jtool.qq.com";
      paramBundle.uri = "/channel?productId=31&channelId=102133";
      new a((HttpURLConnection)new URL(paramBundle.getUrl()).openConnection()).a(paramBundle, new CleanNewUI.5(this, ""), new ah());
      d.a(new com.tencent.mm.plugin.clean.c.a.b());
      if (d.aDQ() == null)
      {
        paramBundle = d.aDO();
        if (paramBundle != null)
        {
          this.iEg = new com.tencent.mm.plugin.clean.c.c(paramBundle, this);
          com.tencent.mm.sdk.f.e.post(this.iEg, "CleanUI_clean");
          this.iDC.setEnabled(false);
          this.iDz.setVisibility(8);
          this.iDA.setVisibility(8);
          this.iDD.setVisibility(0);
          this.iDD.setText(getString(R.l.analyse_file_profress, new Object[] { "0%" }));
        }
      }
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.CleanNewUI", paramBundle, paramBundle.getMessage(), new Object[0]);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (d.aDQ() != null) {
      u(d.aDR(), com.tencent.mm.plugin.clean.c.c.aDI());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanNewUI
 * JD-Core Version:    0.7.0.1
 */