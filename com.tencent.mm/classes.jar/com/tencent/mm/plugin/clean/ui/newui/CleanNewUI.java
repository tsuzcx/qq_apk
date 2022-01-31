package com.tencent.mm.plugin.clean.ui.newui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bq;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
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
  private long kHl;
  private String kHm = "com.tencent.qqpimsecure";
  private String kHn = "00B1208638DE0FCD3E920886D658DAF6";
  private String kHo = "11206657";
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
  private com.tencent.mm.plugin.clean.c.c kJn;
  
  private void G(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(18919);
    hideProgress();
    this.kIG.setText(bo.hk(paramLong1));
    int i = (int)(100L * paramLong1 / paramLong2);
    this.kIH.setText(getString(2131298406, new Object[] { i + "%" }));
    AppMethodBeat.o(18919);
  }
  
  private boolean bhd()
  {
    AppMethodBeat.i(18924);
    bhe();
    if (!p.u(getContext(), this.kHm))
    {
      AppMethodBeat.o(18924);
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
            h.qsU.idkeyStat(282L, 6L, 1L, false);
            AppMethodBeat.o(18924);
            return true;
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.CleanNewUI", localException, "", new Object[0]);
          AppMethodBeat.o(18924);
          return true;
        }
      }
    }
    AppMethodBeat.o(18924);
    return false;
  }
  
  private boolean bhe()
  {
    AppMethodBeat.i(18923);
    aw.aaz();
    String str = (String)com.tencent.mm.model.c.Ru().get(ac.a.yBw, "");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(18923);
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
      AppMethodBeat.o(18923);
      return true;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(18923);
    }
    return false;
  }
  
  private void hideProgress()
  {
    AppMethodBeat.i(18920);
    this.kIJ.setEnabled(true);
    this.kIK.setVisibility(8);
    this.kIG.setVisibility(0);
    this.kIH.setVisibility(0);
    AppMethodBeat.o(18920);
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, ArrayList<com.tencent.mm.plugin.clean.c.b> paramArrayList, long paramLong4, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(18922);
    ab.i("MicroMsg.CleanNewUI", "wechatSize[%d] accSize[%d] otherAccSize[%d]", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
    com.tencent.mm.plugin.clean.c.d.it(paramLong1);
    com.tencent.mm.plugin.clean.c.d.iq(paramLong2);
    com.tencent.mm.plugin.clean.c.d.is(paramLong4);
    com.tencent.mm.plugin.clean.c.d.b(paramHashSet);
    com.tencent.mm.plugin.clean.c.d.ir(paramLong3);
    com.tencent.mm.plugin.clean.c.d.u(paramArrayList);
    G(com.tencent.mm.plugin.clean.c.d.bgR(), com.tencent.mm.plugin.clean.c.c.bgJ());
    AppMethodBeat.o(18922);
  }
  
  public final void dX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18921);
    this.kIK.setText(getString(2131296534, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
    AppMethodBeat.o(18921);
  }
  
  public int getLayoutId()
  {
    return 2130969165;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18917);
    super.onCreate(paramBundle);
    setMMTitle(2131298402);
    setBackBtn(new CleanNewUI.1(this));
    this.kIF = ((LinearLayout)$(2131822869));
    this.kIG = ((TextView)$(2131822870));
    this.kIH = ((TextView)$(2131822871));
    this.kII = ((Button)$(2131822872));
    this.kIJ = ((Button)$(2131822873));
    this.kIJ.setVisibility(8);
    this.kIK = ((TextView)$(2131822844));
    this.kII.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(18912);
        ab.i("MicroMsg.CleanNewUI", "goto clean msg ui");
        CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanMsgUI.class), 0);
        AppMethodBeat.o(18912);
      }
    });
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
    long l1 = com.tencent.mm.plugin.clean.c.c.bgJ();
    long l2 = com.tencent.mm.plugin.clean.c.c.bgK();
    this.kIM.setText(bo.hk(l1 - l2));
    this.kIN.setText(getString(2131298384, new Object[] { bo.hk(l2) }));
    com.tencent.mm.cn.d.awm("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    try
    {
      paramBundle = new b.b();
      paramBundle.ymw = "https://";
      paramBundle.host = "jtool.qq.com";
      paramBundle.uri = "/channel?productId=31&channelId=102133";
      new a((HttpURLConnection)new URL(paramBundle.getUrl()).openConnection()).a(paramBundle, new CleanNewUI.5(this, ""), new ak());
      com.tencent.mm.plugin.clean.c.d.a(new com.tencent.mm.plugin.clean.c.a.b());
      if (com.tencent.mm.plugin.clean.c.d.bgQ() == null)
      {
        paramBundle = com.tencent.mm.plugin.clean.c.d.bgO();
        if (paramBundle != null)
        {
          this.kJn = new com.tencent.mm.plugin.clean.c.c(paramBundle, this);
          com.tencent.mm.sdk.g.d.post(this.kJn, "CleanUI_clean");
          this.kIJ.setEnabled(false);
          this.kIG.setVisibility(8);
          this.kIH.setVisibility(8);
          this.kIK.setVisibility(0);
          this.kIK.setText(getString(2131296534, new Object[] { "0%" }));
        }
      }
      AppMethodBeat.o(18917);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.CleanNewUI", paramBundle, paramBundle.getMessage(), new Object[0]);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(18918);
    super.onResume();
    if (com.tencent.mm.plugin.clean.c.d.bgQ() != null) {
      G(com.tencent.mm.plugin.clean.c.d.bgR(), com.tencent.mm.plugin.clean.c.c.bgJ());
    }
    AppMethodBeat.o(18918);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanNewUI
 * JD-Core Version:    0.7.0.1
 */