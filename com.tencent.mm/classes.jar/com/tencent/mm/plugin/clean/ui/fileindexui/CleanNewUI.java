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
import com.tencent.mm.g.a.lj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.f.b.7;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.c.b.1;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private long oqR;
  private String oqS;
  private String oqT;
  private String oqU;
  private JSONObject oqV;
  private LinearLayout orQ;
  private LinearLayout orR;
  private LinearLayout orS;
  private TextView orT;
  private LinearLayout orU;
  private View orV;
  private View orW;
  private TextView orX;
  private TextView orY;
  private TextView orZ;
  private TextView osa;
  private TextView osb;
  private Button osc;
  private Button osd;
  private Button ose;
  private boolean osf;
  private com.tencent.mm.plugin.clean.b.a osg;
  private com.tencent.mm.plugin.f.c.a osh;
  private p osi;
  private long osj;
  private long osk;
  private long osl;
  private long osm;
  private long osn;
  private com.tencent.mm.plugin.f.c.a.a oso;
  private com.tencent.mm.plugin.clean.b.a.a osp;
  private com.tencent.mm.sdk.b.c<lj> osq;
  
  public CleanNewUI()
  {
    AppMethodBeat.i(22932);
    this.osf = false;
    this.osj = 0L;
    this.osk = 0L;
    this.osl = 0L;
    this.osm = 0L;
    this.osn = 0L;
    this.oso = new com.tencent.mm.plugin.f.c.a.a()
    {
      public final void bOA()
      {
        AppMethodBeat.i(195969);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195968);
            long l1 = bs.eWj();
            long l2 = CleanNewUI.i(CleanNewUI.this);
            CleanNewUI.j(CleanNewUI.this).dismiss();
            t.ch(CleanNewUI.this, CleanNewUI.this.getString(2131757366));
            CleanNewUI.k(CleanNewUI.this).setText("0 B");
            CleanNewUI.l(CleanNewUI.this).setEnabled(false);
            long l3 = com.tencent.mm.plugin.clean.c.d.bVd().oqy - com.tencent.mm.plugin.clean.c.d.bVd().cacheSize;
            com.tencent.mm.plugin.clean.c.d.bVd().oqy = l3;
            CleanNewUI.b(CleanNewUI.this, l3);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 15L, 1L, false);
            ac.d("MicroMsg.CleanNewUI", "clean cache cost time[%d] cacheSize[%d]", new Object[] { Long.valueOf(l1 - l2), Long.valueOf(com.tencent.mm.plugin.clean.c.d.bVd().cacheSize) });
            AppMethodBeat.o(195968);
          }
        });
        AppMethodBeat.o(195969);
      }
    };
    this.osp = new com.tencent.mm.plugin.clean.b.a.a()
    {
      public final void eV(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(195971);
        if (!CleanNewUI.m(CleanNewUI.this)) {
          CleanNewUI.this.eX(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(195971);
      }
      
      public final void j(final long paramAnonymousLong1, long paramAnonymousLong2, final long paramAnonymousLong3)
      {
        AppMethodBeat.i(195972);
        CleanNewUI.c(CleanNewUI.this, bs.eWj());
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195970);
            CleanNewUI.a(CleanNewUI.this, paramAnonymousLong1, paramAnonymousLong3, this.osx);
            AppMethodBeat.o(195970);
          }
        });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 53L, 1L, false);
        paramAnonymousLong1 = CleanNewUI.n(CleanNewUI.this) - CleanNewUI.o(CleanNewUI.this);
        paramAnonymousLong2 = CleanNewUI.p(CleanNewUI.this) - CleanNewUI.q(CleanNewUI.this);
        ac.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", new Object[] { Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.h.wUl.f(14556, new Object[] { Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1) });
        com.tencent.mm.plugin.report.service.h.wUl.f(14556, new Object[] { Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.h.wUl.f(14556, new Object[] { Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        AppMethodBeat.o(195972);
      }
    };
    this.osq = new com.tencent.mm.sdk.b.c() {};
    this.oqS = "com.tencent.qqpimsecure";
    this.oqT = "00B1208638DE0FCD3E920886D658DAF6";
    this.oqU = "11206657";
    AppMethodBeat.o(22932);
  }
  
  private boolean bVh()
  {
    AppMethodBeat.i(22941);
    bVi();
    if (!q.t(getContext(), this.oqS))
    {
      AppMethodBeat.o(22941);
      return false;
    }
    Object localObject = q.bK(this, this.oqS);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = com.tencent.mm.b.g.getMessageDigest(localObject[0].toByteArray());
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.oqT))) {
        try
        {
          localObject = getPackageManager().getLaunchIntentForPackage(this.oqS);
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            q.k(localBundle, this.oqU);
            ((Intent)localObject).putExtras(localBundle);
            ((Intent)localObject).addFlags(268435456);
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 7L, 1L, false);
            AppMethodBeat.o(22941);
            return true;
          }
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.CleanNewUI", localException, "", new Object[0]);
          AppMethodBeat.o(22941);
          return true;
        }
      }
    }
    AppMethodBeat.o(22941);
    return false;
  }
  
  private boolean bVi()
  {
    AppMethodBeat.i(22940);
    az.ayM();
    String str = (String)com.tencent.mm.model.c.agA().get(ah.a.GHH, "");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(22940);
      return false;
    }
    try
    {
      this.oqV = new JSONObject(str);
      this.oqS = this.oqV.getString("packageName");
      this.oqV.get("md5");
      this.oqU = this.oqV.getString("launcherID");
      this.oqT = this.oqV.getString("signature");
      this.oqV.get("url");
      this.oqR = this.oqV.getLong("size");
      AppMethodBeat.o(22940);
      return true;
    }
    catch (JSONException localJSONException)
    {
      ac.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(22940);
    }
    return false;
  }
  
  private void bVl()
  {
    AppMethodBeat.i(195979);
    TextView localTextView = this.osb;
    com.tencent.mm.plugin.clean.c.d.bVd();
    localTextView.setText(bs.qz(com.tencent.mm.plugin.clean.c.d.bVf()));
    AppMethodBeat.o(195979);
  }
  
  private void bVm()
  {
    AppMethodBeat.i(195982);
    ((f)com.tencent.mm.kernel.g.ab(f.class)).aVf();
    ((l)com.tencent.mm.kernel.g.ad(l.class)).dumpAndMarkFinderFolder();
    com.tencent.mm.cq.d.aSU("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    this.osg = new com.tencent.mm.plugin.clean.b.a(this.osp);
    this.osl = bs.eWj();
    com.tencent.mm.sdk.g.b.c(this.osg, "cleanUI_calc");
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 52L, 1L, false);
    AppMethodBeat.o(195982);
  }
  
  private String blf()
  {
    AppMethodBeat.i(22943);
    String str = hashCode();
    AppMethodBeat.o(22943);
    return str;
  }
  
  private void k(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(195980);
    this.orQ.setVisibility(8);
    this.orR.setVisibility(0);
    rK(paramLong1);
    rL(paramLong2);
    rM(paramLong3);
    bVl();
    AppMethodBeat.o(195980);
  }
  
  private void rK(long paramLong)
  {
    int j = 5;
    AppMethodBeat.i(195976);
    com.tencent.mm.plugin.clean.c.d.bVd();
    long l1 = com.tencent.mm.plugin.clean.c.d.bVe();
    com.tencent.mm.plugin.clean.c.d.bVd();
    long l2 = com.tencent.mm.plugin.clean.c.d.bVf();
    this.orX.setText(bs.qz(paramLong));
    int i = (int)(100L * paramLong / l1);
    int k;
    ViewGroup.LayoutParams localLayoutParams;
    if (i > 0)
    {
      this.osa.setText(getString(2131757378, new Object[] { i + "%" }));
      k = getWindowManager().getDefaultDisplay().getWidth() - 48;
      localLayoutParams = this.orV.getLayoutParams();
      if (i != 0) {
        break label215;
      }
      i = 5;
      label125:
      localLayoutParams.width = i;
      this.orV.setLayoutParams(localLayoutParams);
      localLayoutParams = this.orW.getLayoutParams();
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
      this.orW.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(195976);
      return;
      this.osa.setText(2131757379);
      break;
      i = i * k / 100;
      break label125;
    }
  }
  
  private void rL(long paramLong)
  {
    AppMethodBeat.i(195977);
    this.orY.setText(bs.qz(paramLong));
    this.osc.setEnabled(true);
    AppMethodBeat.o(195977);
  }
  
  private void rM(long paramLong)
  {
    AppMethodBeat.i(195978);
    this.orZ.setText(bs.qz(paramLong));
    if (paramLong > 0L)
    {
      this.osd.setEnabled(true);
      AppMethodBeat.o(195978);
      return;
    }
    this.osd.setEnabled(false);
    AppMethodBeat.o(195978);
  }
  
  public final void eX(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(195981);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195967);
        CleanNewUI.h(CleanNewUI.this).setText(CleanNewUI.this.getString(2131757370, new Object[] { Integer.valueOf(paramInt1 * 100 / paramInt2) }));
        AppMethodBeat.o(195967);
      }
    });
    AppMethodBeat.o(195981);
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
    this.orQ = ((LinearLayout)$(2131301491));
    this.orT = ((TextView)$(2131301507));
    this.orR = ((LinearLayout)$(2131305138));
    this.orQ.setVisibility(0);
    this.orT.setText(getString(2131757370, new Object[] { Integer.valueOf(0) }));
    this.orR.setVisibility(8);
    this.orU = ((LinearLayout)$(2131306954));
    this.orV = ((View)$(2131306952));
    this.orW = ((View)$(2131303108));
    this.orX = ((TextView)$(2131306951));
    this.osa = ((TextView)$(2131306956));
    this.orY = ((TextView)$(2131302547));
    this.osc = ((Button)$(2131306946));
    this.osc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22922);
        if (((k)com.tencent.mm.kernel.g.ab(k.class)).axd().dcw()) {
          bi.ayY();
        }
        ac.i("MicroMsg.CleanNewUI", "%s goto clean chatting ui", new Object[] { CleanNewUI.a(CleanNewUI.this) });
        CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanChattingUI.class), 0);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 12L, 1L, false);
        AppMethodBeat.o(22922);
      }
    });
    this.orZ = ((TextView)$(2131297674));
    this.osd = ((Button)$(2131306945));
    this.osd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22923);
        ac.i("MicroMsg.CleanNewUI", "clean wechat cache");
        paramAnonymousView = new f.a(CleanNewUI.this);
        paramAnonymousView.aRQ(CleanNewUI.this.getString(2131757368)).yi(true);
        paramAnonymousView.c(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(195966);
            if (paramAnonymous2Boolean)
            {
              ac.i("MicroMsg.CleanNewUI", "click cleanCacheBtn.");
              paramAnonymous2String = CleanNewUI.this;
              CleanNewUI localCleanNewUI = CleanNewUI.this;
              CleanNewUI.this.getString(2131757367);
              CleanNewUI.a(paramAnonymous2String, com.tencent.mm.ui.base.h.c(localCleanNewUI, "", false, null));
              CleanNewUI.a(CleanNewUI.this, bs.eWj());
              CleanNewUI.a(CleanNewUI.this, new com.tencent.mm.plugin.f.c.a(com.tencent.mm.plugin.clean.c.d.bVd().nSF, com.tencent.mm.plugin.clean.c.d.bVd().cacheSize, CleanNewUI.b(CleanNewUI.this)));
              com.tencent.mm.sdk.g.b.c(CleanNewUI.c(CleanNewUI.this), "cleanCacheTask");
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 14L, 1L, false);
            }
            AppMethodBeat.o(195966);
          }
        }).show();
        AppMethodBeat.o(22923);
      }
    });
    this.orS = ((LinearLayout)$(2131307920));
    this.osb = ((TextView)$(2131307919));
    this.ose = ((Button)$(2131303571));
    this.ose.setOnClickListener(new CleanNewUI.4(this));
    if ((bu.eWq()) || (i.cGY == 1))
    {
      this.orS.setVisibility(8);
      this.ose.setVisibility(8);
    }
    try
    {
      paramBundle = new b.b();
      paramBundle.Gqk = "https://";
      paramBundle.host = "jtool.qq.com";
      paramBundle.uri = "/channel?productId=31&channelId=102133";
      com.tencent.mm.sdk.c.a locala = new com.tencent.mm.sdk.c.a((HttpURLConnection)new URL(paramBundle.getUrl()).openConnection());
      com.tencent.mm.sdk.g.b.c(new b.1(locala, paramBundle, new CleanNewUI.9(this, ""), new ao()), locala.getClass().getName());
      if (com.tencent.mm.plugin.f.b.bOp().bOt())
      {
        ac.i("MicroMsg.CleanNewUI", "%s it scan finish", new Object[] { blf() });
        this.osf = false;
        bVm();
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 50L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 1L, 1L, false);
        AppMethodBeat.o(22933);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.CleanNewUI", paramBundle, paramBundle.getMessage(), new Object[0]);
        continue;
        ac.w("MicroMsg.CleanNewUI", "%s it scan not finish", new Object[] { blf() });
        this.osj = bs.eWj();
        this.osf = true;
        com.tencent.mm.sdk.b.a.GpY.b(this.osq);
        com.tencent.mm.plugin.f.b.bOp().jh(true);
        eX(0, 100);
      }
    }
  }
  
  public void onDestroy()
  {
    boolean bool = false;
    AppMethodBeat.i(22935);
    super.onDestroy();
    ac.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", new Object[] { blf(), Boolean.valueOf(this.osf) });
    if (this.osf)
    {
      com.tencent.mm.sdk.b.a.GpY.d(this.osq);
      com.tencent.mm.plugin.f.b localb = com.tencent.mm.plugin.f.b.bOp();
      String str = localb.blf();
      if (localb.nSj != null) {
        bool = true;
      }
      ac.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      localb.post(new b.7(localb));
    }
    if (this.osg != null) {
      this.osg.stop();
    }
    AppMethodBeat.o(22935);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22934);
    super.onResume();
    if ((this.osm > 0L) && (com.tencent.mm.plugin.clean.c.d.bVd().oqy != 0L)) {
      k(com.tencent.mm.plugin.clean.c.d.bVd().oqy, com.tencent.mm.plugin.clean.c.d.bVd().oqz, com.tencent.mm.plugin.clean.c.d.bVd().cacheSize);
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