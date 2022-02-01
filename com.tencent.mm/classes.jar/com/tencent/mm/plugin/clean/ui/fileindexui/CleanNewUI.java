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
import com.tencent.mm.g.a.lt;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.f.b.7;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.c.b.1;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI
  extends MMActivity
{
  private long paQ;
  private String paR;
  private String paS;
  private String paT;
  private JSONObject paU;
  private LinearLayout pbP;
  private LinearLayout pbQ;
  private LinearLayout pbR;
  private TextView pbS;
  private LinearLayout pbT;
  private View pbU;
  private View pbV;
  private TextView pbW;
  private TextView pbX;
  private TextView pbY;
  private TextView pbZ;
  private TextView pca;
  private Button pcb;
  private Button pcc;
  private Button pcd;
  private boolean pce;
  private com.tencent.mm.plugin.clean.b.a pcf;
  private com.tencent.mm.plugin.f.c.a pcg;
  private p pch;
  private long pci;
  private long pcj;
  private long pck;
  private long pcl;
  private long pcm;
  private com.tencent.mm.plugin.f.c.a.a pcn;
  private com.tencent.mm.plugin.clean.b.a.a pco;
  private com.tencent.mm.sdk.b.c<lt> pcp;
  
  public CleanNewUI()
  {
    AppMethodBeat.i(22932);
    this.pce = false;
    this.pci = 0L;
    this.pcj = 0L;
    this.pck = 0L;
    this.pcl = 0L;
    this.pcm = 0L;
    this.pcn = new com.tencent.mm.plugin.f.c.a.a()
    {
      public final void bUu()
      {
        AppMethodBeat.i(186441);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186440);
            long l3 = bu.fpO();
            long l4 = CleanNewUI.i(CleanNewUI.this);
            CleanNewUI.j(CleanNewUI.this).dismiss();
            com.tencent.mm.ui.base.t.cn(CleanNewUI.this, CleanNewUI.this.getString(2131757366));
            CleanNewUI.k(CleanNewUI.this).setText("0 B");
            CleanNewUI.l(CleanNewUI.this).setEnabled(false);
            long l2 = com.tencent.mm.plugin.clean.c.d.caX().paM - com.tencent.mm.plugin.clean.c.d.caX().cacheSize;
            long l1 = l2;
            if (l2 < 0L)
            {
              ae.e("MicroMsg.CleanNewUI", "cleanCacheFinish error, newWechatSize < 0. newWechatSize:%d, wechatSize:%d, cacheSize:%d", new Object[] { Long.valueOf(l2), Long.valueOf(com.tencent.mm.plugin.clean.c.d.caX().paM), Long.valueOf(com.tencent.mm.plugin.clean.c.d.caX().cacheSize) });
              l1 = 0L;
            }
            com.tencent.mm.plugin.clean.c.d.caX().paM = l1;
            com.tencent.mm.plugin.clean.c.d.caX().cacheSize = 0L;
            CleanNewUI.b(CleanNewUI.this, l1);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(714L, 15L, 1L, false);
            ae.d("MicroMsg.CleanNewUI", "clean cache cost time[%d] cacheSize[%d]", new Object[] { Long.valueOf(l3 - l4), Long.valueOf(com.tencent.mm.plugin.clean.c.d.caX().cacheSize) });
            AppMethodBeat.o(186440);
          }
        });
        AppMethodBeat.o(186441);
      }
    };
    this.pco = new com.tencent.mm.plugin.clean.b.a.a()
    {
      public final void fa(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(186443);
        if (!CleanNewUI.m(CleanNewUI.this)) {
          CleanNewUI.this.fc(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(186443);
      }
      
      public final void j(final long paramAnonymousLong1, long paramAnonymousLong2, final long paramAnonymousLong3)
      {
        AppMethodBeat.i(186444);
        CleanNewUI.c(CleanNewUI.this, bu.fpO());
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186442);
            CleanNewUI.a(CleanNewUI.this, paramAnonymousLong1, paramAnonymousLong3, this.pcw);
            AppMethodBeat.o(186442);
          }
        });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(714L, 53L, 1L, false);
        paramAnonymousLong1 = CleanNewUI.n(CleanNewUI.this) - CleanNewUI.o(CleanNewUI.this);
        paramAnonymousLong2 = CleanNewUI.p(CleanNewUI.this) - CleanNewUI.q(CleanNewUI.this);
        ae.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", new Object[] { Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.g.yxI.f(14556, new Object[] { Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1) });
        com.tencent.mm.plugin.report.service.g.yxI.f(14556, new Object[] { Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.g.yxI.f(14556, new Object[] { Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        AppMethodBeat.o(186444);
      }
    };
    this.pcp = new com.tencent.mm.sdk.b.c() {};
    this.paR = "com.tencent.qqpimsecure";
    this.paS = "00B1208638DE0FCD3E920886D658DAF6";
    this.paT = "11206657";
    AppMethodBeat.o(22932);
  }
  
  private String bpA()
  {
    AppMethodBeat.i(22943);
    String str = hashCode();
    AppMethodBeat.o(22943);
    return str;
  }
  
  private boolean cbb()
  {
    AppMethodBeat.i(22941);
    cbc();
    if (!q.s(getContext(), this.paR))
    {
      AppMethodBeat.o(22941);
      return false;
    }
    Object localObject = q.bP(this, this.paR);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = com.tencent.mm.b.g.getMessageDigest(localObject[0].toByteArray());
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.paS))) {
        try
        {
          localObject = getPackageManager().getLaunchIntentForPackage(this.paR);
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            q.j(localBundle, this.paT);
            ((Intent)localObject).putExtras(localBundle);
            ((Intent)localObject).addFlags(268435456);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(714L, 7L, 1L, false);
            AppMethodBeat.o(22941);
            return true;
          }
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.CleanNewUI", localException, "", new Object[0]);
          AppMethodBeat.o(22941);
          return true;
        }
      }
    }
    AppMethodBeat.o(22941);
    return false;
  }
  
  private boolean cbc()
  {
    AppMethodBeat.i(22940);
    bc.aCg();
    String str = (String)com.tencent.mm.model.c.ajA().get(am.a.IOw, "");
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(22940);
      return false;
    }
    try
    {
      this.paU = new JSONObject(str);
      this.paR = this.paU.getString("packageName");
      this.paU.get("md5");
      this.paT = this.paU.getString("launcherID");
      this.paS = this.paU.getString("signature");
      this.paU.get("url");
      this.paQ = this.paU.getLong("size");
      AppMethodBeat.o(22940);
      return true;
    }
    catch (JSONException localJSONException)
    {
      ae.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(22940);
    }
    return false;
  }
  
  private void cbf()
  {
    AppMethodBeat.i(186451);
    TextView localTextView = this.pca;
    com.tencent.mm.plugin.clean.c.d.caX();
    localTextView.setText(bu.sL(com.tencent.mm.plugin.clean.c.d.caZ()));
    AppMethodBeat.o(186451);
  }
  
  private void cbg()
  {
    AppMethodBeat.i(186454);
    ((f)com.tencent.mm.kernel.g.ab(f.class)).aYU();
    ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).dumpAndMarkFinderFolder();
    com.tencent.mm.cp.d.bax("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    this.pcf = new com.tencent.mm.plugin.clean.b.a(this.pco);
    this.pck = bu.fpO();
    com.tencent.mm.sdk.g.b.c(this.pcf, "cleanUI_calc");
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(714L, 52L, 1L, false);
    AppMethodBeat.o(186454);
  }
  
  private void k(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(186452);
    this.pbP.setVisibility(8);
    this.pbQ.setVisibility(0);
    ua(paramLong1);
    ub(paramLong2);
    uc(paramLong3);
    cbf();
    AppMethodBeat.o(186452);
  }
  
  private void ua(long paramLong)
  {
    int j = 5;
    AppMethodBeat.i(186448);
    com.tencent.mm.plugin.clean.c.d.caX();
    long l1 = com.tencent.mm.plugin.clean.c.d.caY();
    com.tencent.mm.plugin.clean.c.d.caX();
    long l2 = com.tencent.mm.plugin.clean.c.d.caZ();
    long l3 = com.tencent.mm.plugin.clean.c.d.caX().dataSize;
    this.pbW.setText(bu.sL(l3 + paramLong));
    int i = (int)(100L * paramLong / l1);
    int k;
    ViewGroup.LayoutParams localLayoutParams;
    if (i > 0)
    {
      this.pbZ.setText(getString(2131757378, new Object[] { i + "%" }));
      k = getWindowManager().getDefaultDisplay().getWidth() - 48;
      localLayoutParams = this.pbU.getLayoutParams();
      if (i != 0) {
        break label226;
      }
      i = 5;
      label136:
      localLayoutParams.width = i;
      this.pbU.setLayoutParams(localLayoutParams);
      localLayoutParams = this.pbV.getLayoutParams();
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
      this.pbV.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(186448);
      return;
      this.pbZ.setText(2131757379);
      break;
      i = i * k / 100;
      break label136;
    }
  }
  
  private void ub(long paramLong)
  {
    AppMethodBeat.i(186449);
    this.pbX.setText(bu.sL(paramLong));
    this.pcb.setEnabled(true);
    AppMethodBeat.o(186449);
  }
  
  private void uc(long paramLong)
  {
    AppMethodBeat.i(186450);
    this.pbY.setText(bu.sL(paramLong));
    if (paramLong > 0L)
    {
      this.pcc.setEnabled(true);
      AppMethodBeat.o(186450);
      return;
    }
    this.pcc.setEnabled(false);
    AppMethodBeat.o(186450);
  }
  
  public final void fc(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(186453);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186439);
        CleanNewUI.h(CleanNewUI.this).setText(CleanNewUI.this.getString(2131757370, new Object[] { Integer.valueOf(paramInt1 * 100 / paramInt2) }));
        AppMethodBeat.o(186439);
      }
    });
    AppMethodBeat.o(186453);
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
    this.pbP = ((LinearLayout)$(2131301491));
    this.pbS = ((TextView)$(2131301507));
    this.pbQ = ((LinearLayout)$(2131305138));
    this.pbP.setVisibility(0);
    this.pbS.setText(getString(2131757370, new Object[] { Integer.valueOf(0) }));
    this.pbQ.setVisibility(8);
    this.pbT = ((LinearLayout)$(2131306954));
    this.pbU = ((View)$(2131306952));
    this.pbV = ((View)$(2131303108));
    this.pbW = ((TextView)$(2131306951));
    this.pbZ = ((TextView)$(2131306956));
    this.pbZ.setVisibility(8);
    this.pbX = ((TextView)$(2131302547));
    this.pcb = ((Button)$(2131306946));
    this.pcb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22922);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (((l)com.tencent.mm.kernel.g.ab(l.class)).aAi().doN()) {
          bl.aCs();
        }
        ae.i("MicroMsg.CleanNewUI", "%s goto clean chatting ui", new Object[] { CleanNewUI.a(CleanNewUI.this) });
        CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanChattingUI.class), 0);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(714L, 12L, 1L, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22922);
      }
    });
    this.pbY = ((TextView)$(2131297674));
    this.pcc = ((Button)$(2131306945));
    this.pcc.setOnClickListener(new CleanNewUI.3(this));
    this.pbR = ((LinearLayout)$(2131307920));
    this.pca = ((TextView)$(2131307919));
    this.pcd = ((Button)$(2131303571));
    this.pcd.setOnClickListener(new CleanNewUI.4(this));
    if ((bw.fpV()) || (k.cSM == 1))
    {
      this.pbR.setVisibility(8);
      this.pcd.setVisibility(8);
    }
    try
    {
      paramBundle = new b.b();
      paramBundle.Iwf = "https://";
      paramBundle.host = "jtool.qq.com";
      paramBundle.uri = "/channel?productId=31&channelId=102133";
      com.tencent.mm.sdk.c.a locala = new com.tencent.mm.sdk.c.a((HttpURLConnection)new URL(paramBundle.getUrl()).openConnection());
      com.tencent.mm.sdk.g.b.c(new b.1(locala, paramBundle, new CleanNewUI.9(this, ""), new aq()), locala.getClass().getName());
      if (com.tencent.mm.plugin.f.b.bUj().bUn())
      {
        ae.i("MicroMsg.CleanNewUI", "%s it scan finish", new Object[] { bpA() });
        this.pce = false;
        cbg();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(714L, 50L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(714L, 1L, 1L, false);
        AppMethodBeat.o(22933);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.CleanNewUI", paramBundle, paramBundle.getMessage(), new Object[0]);
        continue;
        ae.w("MicroMsg.CleanNewUI", "%s it scan not finish", new Object[] { bpA() });
        this.pci = bu.fpO();
        this.pce = true;
        com.tencent.mm.sdk.b.a.IvT.b(this.pcp);
        com.tencent.mm.plugin.f.b.bUj().jr(true);
        fc(0, 100);
      }
    }
  }
  
  public void onDestroy()
  {
    boolean bool = false;
    AppMethodBeat.i(22935);
    super.onDestroy();
    ae.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", new Object[] { bpA(), Boolean.valueOf(this.pce) });
    if (this.pce)
    {
      com.tencent.mm.sdk.b.a.IvT.d(this.pcp);
      com.tencent.mm.plugin.f.b localb = com.tencent.mm.plugin.f.b.bUj();
      String str = localb.bpA();
      if (localb.oCf != null) {
        bool = true;
      }
      ae.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      localb.post(new b.7(localb));
    }
    if (this.pcf != null) {
      this.pcf.stop();
    }
    AppMethodBeat.o(22935);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22934);
    super.onResume();
    if ((this.pcl > 0L) && (com.tencent.mm.plugin.clean.c.d.caX().paM != 0L)) {
      k(com.tencent.mm.plugin.clean.c.d.caX().paM, com.tencent.mm.plugin.clean.c.d.caX().paw, com.tencent.mm.plugin.clean.c.d.caX().cacheSize);
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