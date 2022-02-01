package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.la;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.f.b.7;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.c.b.1;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI
  extends MMActivity
{
  private long nNP;
  private String nNQ;
  private String nNR;
  private String nNS;
  private JSONObject nNT;
  private LinearLayout nOO;
  private LinearLayout nOP;
  private TextView nOQ;
  private LinearLayout nOR;
  private View nOS;
  private View nOT;
  private TextView nOU;
  private TextView nOV;
  private TextView nOW;
  private TextView nOX;
  private Button nOY;
  private Button nOZ;
  private Button nPa;
  private boolean nPb;
  private com.tencent.mm.plugin.clean.b.a nPc;
  private com.tencent.mm.plugin.f.c.a nPd;
  private p nPe;
  private long nPf;
  private long nPg;
  private long nPh;
  private long nPi;
  private long nPj;
  private com.tencent.mm.plugin.f.c.a.a nPk;
  private com.tencent.mm.plugin.clean.b.a.a nPl;
  private com.tencent.mm.sdk.b.c<la> nPm;
  
  public CleanNewUI()
  {
    AppMethodBeat.i(22932);
    this.nPb = false;
    this.nPf = 0L;
    this.nPg = 0L;
    this.nPh = 0L;
    this.nPi = 0L;
    this.nPj = 0L;
    this.nPk = new com.tencent.mm.plugin.f.c.a.a()
    {
      public final void bHn()
      {
        AppMethodBeat.i(191163);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(191162);
            long l1 = bt.eGO();
            long l2 = CleanNewUI.i(CleanNewUI.this);
            CleanNewUI.j(CleanNewUI.this).dismiss();
            t.cg(CleanNewUI.this, CleanNewUI.this.getString(2131757366));
            CleanNewUI.k(CleanNewUI.this).setText("0 B");
            CleanNewUI.l(CleanNewUI.this).setEnabled(false);
            long l3 = com.tencent.mm.plugin.clean.c.d.bNS().nNw - com.tencent.mm.plugin.clean.c.d.bNS().cacheSize;
            com.tencent.mm.plugin.clean.c.d.bNS().nNw = l3;
            CleanNewUI.b(CleanNewUI.this, l3);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 15L, 1L, false);
            ad.d("MicroMsg.CleanNewUI", "clean cache cost time[%d] cacheSize[%d]", new Object[] { Long.valueOf(l1 - l2), Long.valueOf(com.tencent.mm.plugin.clean.c.d.bNS().cacheSize) });
            AppMethodBeat.o(191162);
          }
        });
        AppMethodBeat.o(191163);
      }
    };
    this.nPl = new com.tencent.mm.plugin.clean.b.a.a()
    {
      public final void eS(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(191165);
        if (!CleanNewUI.m(CleanNewUI.this)) {
          CleanNewUI.this.eU(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(191165);
      }
      
      public final void i(final long paramAnonymousLong1, long paramAnonymousLong2, final long paramAnonymousLong3)
      {
        AppMethodBeat.i(191166);
        CleanNewUI.c(CleanNewUI.this, bt.eGO());
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(191164);
            CleanNewUI.a(CleanNewUI.this, paramAnonymousLong1, paramAnonymousLong3, this.nPt);
            AppMethodBeat.o(191164);
          }
        });
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 53L, 1L, false);
        paramAnonymousLong1 = CleanNewUI.n(CleanNewUI.this) - CleanNewUI.o(CleanNewUI.this);
        paramAnonymousLong2 = CleanNewUI.p(CleanNewUI.this) - CleanNewUI.q(CleanNewUI.this);
        ad.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", new Object[] { Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.h.vKh.f(14556, new Object[] { Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1) });
        com.tencent.mm.plugin.report.service.h.vKh.f(14556, new Object[] { Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.h.vKh.f(14556, new Object[] { Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        AppMethodBeat.o(191166);
      }
    };
    this.nPm = new com.tencent.mm.sdk.b.c() {};
    this.nNQ = "com.tencent.qqpimsecure";
    this.nNR = "00B1208638DE0FCD3E920886D658DAF6";
    this.nNS = "11206657";
    AppMethodBeat.o(22932);
  }
  
  private boolean bNW()
  {
    AppMethodBeat.i(22941);
    bNX();
    if (!q.t(getContext(), this.nNQ))
    {
      AppMethodBeat.o(22941);
      return false;
    }
    Object localObject = q.bJ(this, this.nNQ);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = com.tencent.mm.b.g.getMessageDigest(localObject[0].toByteArray());
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
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 7L, 1L, false);
            AppMethodBeat.o(22941);
            return true;
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.CleanNewUI", localException, "", new Object[0]);
          AppMethodBeat.o(22941);
          return true;
        }
      }
    }
    AppMethodBeat.o(22941);
    return false;
  }
  
  private boolean bNX()
  {
    AppMethodBeat.i(22940);
    az.arV();
    String str = (String)com.tencent.mm.model.c.afk().get(ae.a.FjS, "");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(22940);
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
      AppMethodBeat.o(22940);
      return true;
    }
    catch (JSONException localJSONException)
    {
      ad.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(22940);
    }
    return false;
  }
  
  private void bOa()
  {
    AppMethodBeat.i(191175);
    ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class)).aOp();
    ((j)com.tencent.mm.kernel.g.ad(j.class)).dumpAndMarkFinderFolder();
    com.tencent.mm.cr.d.aNr("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    this.nPc = new com.tencent.mm.plugin.clean.b.a(this.nPl);
    this.nPh = bt.eGO();
    com.tencent.mm.sdk.g.b.c(this.nPc, "cleanUI_calc");
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 52L, 1L, false);
    AppMethodBeat.o(191175);
  }
  
  private String bel()
  {
    AppMethodBeat.i(22943);
    String str = hashCode();
    AppMethodBeat.o(22943);
    return str;
  }
  
  private void j(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(191173);
    this.nOO.setVisibility(8);
    this.nOP.setVisibility(0);
    nY(paramLong1);
    nZ(paramLong2);
    oa(paramLong3);
    AppMethodBeat.o(191173);
  }
  
  private void nY(long paramLong)
  {
    int j = 5;
    AppMethodBeat.i(191170);
    com.tencent.mm.plugin.clean.c.d.bNS();
    long l1 = com.tencent.mm.plugin.clean.c.d.bNT();
    com.tencent.mm.plugin.clean.c.d.bNS();
    long l2 = com.tencent.mm.plugin.clean.c.d.bNU();
    this.nOU.setText(bt.mK(paramLong));
    int i = (int)(100L * paramLong / l1);
    int k;
    ViewGroup.LayoutParams localLayoutParams;
    if (i > 0)
    {
      this.nOX.setText(getString(2131757378, new Object[] { i + "%" }));
      k = getWindowManager().getDefaultDisplay().getWidth() - 48;
      localLayoutParams = this.nOS.getLayoutParams();
      if (i != 0) {
        break label215;
      }
      i = 5;
      label125:
      localLayoutParams.width = i;
      this.nOS.setLayoutParams(localLayoutParams);
      localLayoutParams = this.nOT.getLayoutParams();
      localLayoutParams.width = ((int)((l1 - l2 - paramLong) * k / l1));
      if (localLayoutParams.width != 0) {
        break label226;
      }
    }
    label215:
    label226:
    for (i = j;; i = localLayoutParams.width)
    {
      localLayoutParams.width = i;
      this.nOT.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(191170);
      return;
      this.nOX.setText(2131757379);
      break;
      i = i * k / 100;
      break label125;
    }
  }
  
  private void nZ(long paramLong)
  {
    AppMethodBeat.i(191171);
    this.nOV.setText(bt.mK(paramLong));
    this.nOY.setEnabled(true);
    AppMethodBeat.o(191171);
  }
  
  private void oa(long paramLong)
  {
    AppMethodBeat.i(191172);
    this.nOW.setText(bt.mK(paramLong));
    if (paramLong > 0L)
    {
      this.nOZ.setEnabled(true);
      AppMethodBeat.o(191172);
      return;
    }
    this.nOZ.setEnabled(false);
    AppMethodBeat.o(191172);
  }
  
  public final void eU(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(191174);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(191161);
        CleanNewUI.h(CleanNewUI.this).setText(CleanNewUI.this.getString(2131757370, new Object[] { Integer.valueOf(paramInt1 * 100 / paramInt2) }));
        AppMethodBeat.o(191161);
      }
    });
    AppMethodBeat.o(191174);
  }
  
  public int getLayoutId()
  {
    return 2131493540;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22933);
    super.onCreate(paramBundle);
    setMMTitle(2131757376);
    setBackBtn(new CleanNewUI.1(this));
    this.nOO = ((LinearLayout)$(2131301491));
    this.nOQ = ((TextView)$(2131301507));
    this.nOP = ((LinearLayout)$(2131305138));
    this.nOO.setVisibility(0);
    this.nOQ.setText(getString(2131757370, new Object[] { Integer.valueOf(0) }));
    this.nOP.setVisibility(8);
    this.nOR = ((LinearLayout)$(2131306954));
    this.nOS = ((View)$(2131306952));
    this.nOT = ((View)$(2131303108));
    this.nOU = ((TextView)$(2131306951));
    this.nOX = ((TextView)$(2131306956));
    this.nOV = ((TextView)$(2131302547));
    this.nOY = ((Button)$(2131306946));
    this.nOY.setOnClickListener(new CleanNewUI.2(this));
    this.nOW = ((TextView)$(2131297674));
    this.nOZ = ((Button)$(2131306945));
    this.nOZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22923);
        ad.i("MicroMsg.CleanNewUI", "clean wechat cache");
        paramAnonymousView = new f.a(CleanNewUI.this);
        paramAnonymousView.aMo(CleanNewUI.this.getString(2131757368)).wZ(true);
        paramAnonymousView.c(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(191160);
            if (paramAnonymous2Boolean)
            {
              ad.i("MicroMsg.CleanNewUI", "click cleanCacheBtn.");
              paramAnonymous2String = CleanNewUI.this;
              CleanNewUI localCleanNewUI = CleanNewUI.this;
              CleanNewUI.this.getString(2131757367);
              CleanNewUI.a(paramAnonymous2String, com.tencent.mm.ui.base.h.c(localCleanNewUI, "", false, null));
              CleanNewUI.a(CleanNewUI.this, bt.eGO());
              CleanNewUI.a(CleanNewUI.this, new com.tencent.mm.plugin.f.c.a(com.tencent.mm.plugin.clean.c.d.bNS().npF, com.tencent.mm.plugin.clean.c.d.bNS().cacheSize, CleanNewUI.b(CleanNewUI.this)));
              com.tencent.mm.sdk.g.b.c(CleanNewUI.c(CleanNewUI.this), "cleanCacheTask");
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 14L, 1L, false);
            }
            AppMethodBeat.o(191160);
          }
        }).show();
        AppMethodBeat.o(22923);
      }
    });
    this.nPa = ((Button)$(2131303571));
    this.nPa.setOnClickListener(new CleanNewUI.4(this));
    if ((bv.eGV()) || (i.cJR == 1)) {
      this.nPa.setVisibility(8);
    }
    try
    {
      paramBundle = new b.b();
      paramBundle.ESX = "https://";
      paramBundle.host = "jtool.qq.com";
      paramBundle.uri = "/channel?productId=31&channelId=102133";
      com.tencent.mm.sdk.c.a locala = new com.tencent.mm.sdk.c.a((HttpURLConnection)new URL(paramBundle.getUrl()).openConnection());
      com.tencent.mm.sdk.g.b.c(new b.1(locala, paramBundle, new CleanNewUI.9(this, ""), new ap()), locala.getClass().getName());
      if (com.tencent.mm.plugin.f.b.bHc().bHg())
      {
        ad.i("MicroMsg.CleanNewUI", "%s it scan finish", new Object[] { bel() });
        this.nPb = false;
        bOa();
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 50L, 1L, false);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 1L, 1L, false);
        AppMethodBeat.o(22933);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.CleanNewUI", paramBundle, paramBundle.getMessage(), new Object[0]);
        continue;
        ad.w("MicroMsg.CleanNewUI", "%s it scan not finish", new Object[] { bel() });
        this.nPf = bt.eGO();
        this.nPb = true;
        com.tencent.mm.sdk.b.a.ESL.b(this.nPm);
        com.tencent.mm.plugin.f.b.bHc().iE(true);
        eU(0, 100);
      }
    }
  }
  
  public void onDestroy()
  {
    boolean bool = false;
    AppMethodBeat.i(22935);
    super.onDestroy();
    ad.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", new Object[] { bel(), Boolean.valueOf(this.nPb) });
    if (this.nPb)
    {
      com.tencent.mm.sdk.b.a.ESL.d(this.nPm);
      com.tencent.mm.plugin.f.b localb = com.tencent.mm.plugin.f.b.bHc();
      String str = localb.bel();
      if (localb.npj != null) {
        bool = true;
      }
      ad.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      localb.post(new b.7(localb));
    }
    if (this.nPc != null) {
      this.nPc.stop();
    }
    AppMethodBeat.o(22935);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22934);
    super.onResume();
    if ((this.nPi > 0L) && (com.tencent.mm.plugin.clean.c.d.bNS().nNw != 0L)) {
      j(com.tencent.mm.plugin.clean.c.d.bNS().nNw, com.tencent.mm.plugin.clean.c.d.bNS().nNx, com.tencent.mm.plugin.clean.c.d.bNS().cacheSize);
    }
    AppMethodBeat.o(22934);
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