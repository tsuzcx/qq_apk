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
import com.tencent.mm.g.a.ls;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.f.b.7;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.c.b.1;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI
  extends MMActivity
{
  private long oUn;
  private String oUo;
  private String oUp;
  private String oUq;
  private JSONObject oUr;
  private Button oVA;
  private boolean oVB;
  private com.tencent.mm.plugin.clean.b.a oVC;
  private com.tencent.mm.plugin.f.c.a oVD;
  private p oVE;
  private long oVF;
  private long oVG;
  private long oVH;
  private long oVI;
  private long oVJ;
  private com.tencent.mm.plugin.f.c.a.a oVK;
  private com.tencent.mm.plugin.clean.b.a.a oVL;
  private com.tencent.mm.sdk.b.c<ls> oVM;
  private LinearLayout oVm;
  private LinearLayout oVn;
  private LinearLayout oVo;
  private TextView oVp;
  private LinearLayout oVq;
  private View oVr;
  private View oVs;
  private TextView oVt;
  private TextView oVu;
  private TextView oVv;
  private TextView oVw;
  private TextView oVx;
  private Button oVy;
  private Button oVz;
  
  public CleanNewUI()
  {
    AppMethodBeat.i(22932);
    this.oVB = false;
    this.oVF = 0L;
    this.oVG = 0L;
    this.oVH = 0L;
    this.oVI = 0L;
    this.oVJ = 0L;
    this.oVK = new com.tencent.mm.plugin.f.c.a.a()
    {
      public final void bTf()
      {
        AppMethodBeat.i(193181);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193180);
            long l3 = bt.flT();
            long l4 = CleanNewUI.i(CleanNewUI.this);
            CleanNewUI.j(CleanNewUI.this).dismiss();
            com.tencent.mm.ui.base.t.cm(CleanNewUI.this, CleanNewUI.this.getString(2131757366));
            CleanNewUI.k(CleanNewUI.this).setText("0 B");
            CleanNewUI.l(CleanNewUI.this).setEnabled(false);
            long l2 = com.tencent.mm.plugin.clean.c.d.bZI().oUj - com.tencent.mm.plugin.clean.c.d.bZI().cacheSize;
            long l1 = l2;
            if (l2 < 0L)
            {
              ad.e("MicroMsg.CleanNewUI", "cleanCacheFinish error, newWechatSize < 0. newWechatSize:%d, wechatSize:%d, cacheSize:%d", new Object[] { Long.valueOf(l2), Long.valueOf(com.tencent.mm.plugin.clean.c.d.bZI().oUj), Long.valueOf(com.tencent.mm.plugin.clean.c.d.bZI().cacheSize) });
              l1 = 0L;
            }
            com.tencent.mm.plugin.clean.c.d.bZI().oUj = l1;
            com.tencent.mm.plugin.clean.c.d.bZI().cacheSize = 0L;
            CleanNewUI.b(CleanNewUI.this, l1);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(714L, 15L, 1L, false);
            ad.d("MicroMsg.CleanNewUI", "clean cache cost time[%d] cacheSize[%d]", new Object[] { Long.valueOf(l3 - l4), Long.valueOf(com.tencent.mm.plugin.clean.c.d.bZI().cacheSize) });
            AppMethodBeat.o(193180);
          }
        });
        AppMethodBeat.o(193181);
      }
    };
    this.oVL = new com.tencent.mm.plugin.clean.b.a.a()
    {
      public final void eZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(193183);
        if (!CleanNewUI.m(CleanNewUI.this)) {
          CleanNewUI.this.fb(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(193183);
      }
      
      public final void j(final long paramAnonymousLong1, long paramAnonymousLong2, final long paramAnonymousLong3)
      {
        AppMethodBeat.i(193184);
        CleanNewUI.c(CleanNewUI.this, bt.flT());
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193182);
            CleanNewUI.a(CleanNewUI.this, paramAnonymousLong1, paramAnonymousLong3, this.oVT);
            AppMethodBeat.o(193182);
          }
        });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(714L, 53L, 1L, false);
        paramAnonymousLong1 = CleanNewUI.n(CleanNewUI.this) - CleanNewUI.o(CleanNewUI.this);
        paramAnonymousLong2 = CleanNewUI.p(CleanNewUI.this) - CleanNewUI.q(CleanNewUI.this);
        ad.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", new Object[] { Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.g.yhR.f(14556, new Object[] { Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1) });
        com.tencent.mm.plugin.report.service.g.yhR.f(14556, new Object[] { Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.g.yhR.f(14556, new Object[] { Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        AppMethodBeat.o(193184);
      }
    };
    this.oVM = new com.tencent.mm.sdk.b.c() {};
    this.oUo = "com.tencent.qqpimsecure";
    this.oUp = "00B1208638DE0FCD3E920886D658DAF6";
    this.oUq = "11206657";
    AppMethodBeat.o(22932);
  }
  
  private boolean bZM()
  {
    AppMethodBeat.i(22941);
    bZN();
    if (!q.s(getContext(), this.oUo))
    {
      AppMethodBeat.o(22941);
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
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(714L, 7L, 1L, false);
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
  
  private boolean bZN()
  {
    AppMethodBeat.i(22940);
    ba.aBQ();
    String str = (String)com.tencent.mm.model.c.ajl().get(al.a.ItZ, "");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(22940);
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
  
  private void bZQ()
  {
    AppMethodBeat.i(193191);
    TextView localTextView = this.oVx;
    com.tencent.mm.plugin.clean.c.d.bZI();
    localTextView.setText(bt.sy(com.tencent.mm.plugin.clean.c.d.bZK()));
    AppMethodBeat.o(193191);
  }
  
  private void bZR()
  {
    AppMethodBeat.i(193194);
    ((f)com.tencent.mm.kernel.g.ab(f.class)).aYz();
    ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).dumpAndMarkFinderFolder();
    com.tencent.mm.cq.d.aYU("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    this.oVC = new com.tencent.mm.plugin.clean.b.a(this.oVL);
    this.oVH = bt.flT();
    com.tencent.mm.sdk.g.b.c(this.oVC, "cleanUI_calc");
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(714L, 52L, 1L, false);
    AppMethodBeat.o(193194);
  }
  
  private String boQ()
  {
    AppMethodBeat.i(22943);
    String str = hashCode();
    AppMethodBeat.o(22943);
    return str;
  }
  
  private void k(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(193192);
    this.oVm.setVisibility(8);
    this.oVn.setVisibility(0);
    tJ(paramLong1);
    tK(paramLong2);
    tL(paramLong3);
    bZQ();
    AppMethodBeat.o(193192);
  }
  
  private void tJ(long paramLong)
  {
    int j = 5;
    AppMethodBeat.i(193188);
    com.tencent.mm.plugin.clean.c.d.bZI();
    long l1 = com.tencent.mm.plugin.clean.c.d.bZJ();
    com.tencent.mm.plugin.clean.c.d.bZI();
    long l2 = com.tencent.mm.plugin.clean.c.d.bZK();
    long l3 = com.tencent.mm.plugin.clean.c.d.bZI().dataSize;
    this.oVt.setText(bt.sy(l3 + paramLong));
    int i = (int)(100L * paramLong / l1);
    int k;
    ViewGroup.LayoutParams localLayoutParams;
    if (i > 0)
    {
      this.oVw.setText(getString(2131757378, new Object[] { i + "%" }));
      k = getWindowManager().getDefaultDisplay().getWidth() - 48;
      localLayoutParams = this.oVr.getLayoutParams();
      if (i != 0) {
        break label226;
      }
      i = 5;
      label136:
      localLayoutParams.width = i;
      this.oVr.setLayoutParams(localLayoutParams);
      localLayoutParams = this.oVs.getLayoutParams();
      localLayoutParams.width = ((int)((l1 - l2 - paramLong) * k / l1));
      if (localLayoutParams.width != 0) {
        break label237;
      }
    }
    label226:
    label237:
    for (i = j;; i = localLayoutParams.width)
    {
      localLayoutParams.width = i;
      this.oVs.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(193188);
      return;
      this.oVw.setText(2131757379);
      break;
      i = i * k / 100;
      break label136;
    }
  }
  
  private void tK(long paramLong)
  {
    AppMethodBeat.i(193189);
    this.oVu.setText(bt.sy(paramLong));
    this.oVy.setEnabled(true);
    AppMethodBeat.o(193189);
  }
  
  private void tL(long paramLong)
  {
    AppMethodBeat.i(193190);
    this.oVv.setText(bt.sy(paramLong));
    if (paramLong > 0L)
    {
      this.oVz.setEnabled(true);
      AppMethodBeat.o(193190);
      return;
    }
    this.oVz.setEnabled(false);
    AppMethodBeat.o(193190);
  }
  
  public final void fb(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(193193);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193179);
        CleanNewUI.h(CleanNewUI.this).setText(CleanNewUI.this.getString(2131757370, new Object[] { Integer.valueOf(paramInt1 * 100 / paramInt2) }));
        AppMethodBeat.o(193179);
      }
    });
    AppMethodBeat.o(193193);
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
    this.oVm = ((LinearLayout)$(2131301491));
    this.oVp = ((TextView)$(2131301507));
    this.oVn = ((LinearLayout)$(2131305138));
    this.oVm.setVisibility(0);
    this.oVp.setText(getString(2131757370, new Object[] { Integer.valueOf(0) }));
    this.oVn.setVisibility(8);
    this.oVq = ((LinearLayout)$(2131306954));
    this.oVr = ((View)$(2131306952));
    this.oVs = ((View)$(2131303108));
    this.oVt = ((TextView)$(2131306951));
    this.oVw = ((TextView)$(2131306956));
    this.oVw.setVisibility(8);
    this.oVu = ((TextView)$(2131302547));
    this.oVy = ((Button)$(2131306946));
    this.oVy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22922);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (((l)com.tencent.mm.kernel.g.ab(l.class)).azS().dlO()) {
          bj.aCc();
        }
        ad.i("MicroMsg.CleanNewUI", "%s goto clean chatting ui", new Object[] { CleanNewUI.a(CleanNewUI.this) });
        CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanChattingUI.class), 0);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(714L, 12L, 1L, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22922);
      }
    });
    this.oVv = ((TextView)$(2131297674));
    this.oVz = ((Button)$(2131306945));
    this.oVz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22923);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.CleanNewUI", "clean wechat cache");
        paramAnonymousView = new f.a(CleanNewUI.this);
        paramAnonymousView.aXO(CleanNewUI.this.getString(2131757368)).yU(true);
        paramAnonymousView.c(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(193178);
            if (paramAnonymous2Boolean)
            {
              ad.i("MicroMsg.CleanNewUI", "click cleanCacheBtn.");
              paramAnonymous2String = CleanNewUI.this;
              CleanNewUI localCleanNewUI = CleanNewUI.this;
              CleanNewUI.this.getString(2131757367);
              CleanNewUI.a(paramAnonymous2String, h.c(localCleanNewUI, "", false, null));
              CleanNewUI.a(CleanNewUI.this, bt.flT());
              CleanNewUI.a(CleanNewUI.this, new com.tencent.mm.plugin.f.c.a(com.tencent.mm.plugin.clean.c.d.bZI().owa, com.tencent.mm.plugin.clean.c.d.bZI().cacheSize, CleanNewUI.b(CleanNewUI.this)));
              com.tencent.mm.sdk.g.b.c(CleanNewUI.c(CleanNewUI.this), "cleanCacheTask");
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(714L, 14L, 1L, false);
            }
            AppMethodBeat.o(193178);
          }
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22923);
      }
    });
    this.oVo = ((LinearLayout)$(2131307920));
    this.oVx = ((TextView)$(2131307919));
    this.oVA = ((Button)$(2131303571));
    this.oVA.setOnClickListener(new CleanNewUI.4(this));
    if ((bv.fma()) || (j.cSc == 1))
    {
      this.oVo.setVisibility(8);
      this.oVA.setVisibility(8);
    }
    try
    {
      paramBundle = new b.b();
      paramBundle.IbX = "https://";
      paramBundle.host = "jtool.qq.com";
      paramBundle.uri = "/channel?productId=31&channelId=102133";
      com.tencent.mm.sdk.c.a locala = new com.tencent.mm.sdk.c.a((HttpURLConnection)new URL(paramBundle.getUrl()).openConnection());
      com.tencent.mm.sdk.g.b.c(new b.1(locala, paramBundle, new CleanNewUI.9(this, ""), new ap()), locala.getClass().getName());
      if (com.tencent.mm.plugin.f.b.bSU().bSY())
      {
        ad.i("MicroMsg.CleanNewUI", "%s it scan finish", new Object[] { boQ() });
        this.oVB = false;
        bZR();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(714L, 50L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(714L, 1L, 1L, false);
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
        ad.w("MicroMsg.CleanNewUI", "%s it scan not finish", new Object[] { boQ() });
        this.oVF = bt.flT();
        this.oVB = true;
        com.tencent.mm.sdk.b.a.IbL.b(this.oVM);
        com.tencent.mm.plugin.f.b.bSU().js(true);
        fb(0, 100);
      }
    }
  }
  
  public void onDestroy()
  {
    boolean bool = false;
    AppMethodBeat.i(22935);
    super.onDestroy();
    ad.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", new Object[] { boQ(), Boolean.valueOf(this.oVB) });
    if (this.oVB)
    {
      com.tencent.mm.sdk.b.a.IbL.d(this.oVM);
      com.tencent.mm.plugin.f.b localb = com.tencent.mm.plugin.f.b.bSU();
      String str = localb.boQ();
      if (localb.ovE != null) {
        bool = true;
      }
      ad.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      localb.post(new b.7(localb));
    }
    if (this.oVC != null) {
      this.oVC.stop();
    }
    AppMethodBeat.o(22935);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22934);
    super.onResume();
    if ((this.oVI > 0L) && (com.tencent.mm.plugin.clean.c.d.bZI().oUj != 0L)) {
      k(com.tencent.mm.plugin.clean.c.d.bZI().oUj, com.tencent.mm.plugin.clean.c.d.bZI().oTU, com.tencent.mm.plugin.clean.c.d.bZI().cacheSize);
    }
    AppMethodBeat.o(22934);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI
 * JD-Core Version:    0.7.0.1
 */