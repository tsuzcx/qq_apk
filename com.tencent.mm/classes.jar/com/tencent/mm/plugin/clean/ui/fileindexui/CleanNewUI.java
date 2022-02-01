package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.oh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.calcwx.a.5;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpURLConnectionWrapper;
import com.tencent.mm.sdk.http.HttpWrapperBase.Request;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.WeChatLocaleUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI
  extends MMActivity
{
  private static final String wRM;
  private TextView sIY;
  private long wRN;
  private String wRO;
  private String wRP;
  private String wRQ;
  private JSONObject wRR;
  private LinearLayout wSL;
  private LinearLayout wSM;
  private LinearLayout wSN;
  private TextView wSO;
  private LinearLayout wSP;
  private View wSQ;
  private View wSR;
  private TextView wSS;
  private TextView wST;
  private TextView wSU;
  private TextView wSV;
  private TextView wSW;
  private Button wSX;
  private Button wSY;
  private Button wSZ;
  private LinearLayout wTa;
  private boolean wTb;
  private com.tencent.mm.plugin.clean.b.a wTc;
  private com.tencent.mm.plugin.calcwx.c.a wTd;
  private w wTe;
  private long wTf;
  private long wTg;
  private long wTh;
  private long wTi;
  private long wTj;
  private com.tencent.mm.plugin.calcwx.c.a.a wTk;
  private com.tencent.mm.plugin.clean.b.a.a wTl;
  private IListener<oh> wTm;
  private boolean wbF;
  
  static
  {
    AppMethodBeat.i(271880);
    wRM = "https://" + WeChatHosts.domainString(R.l.host_weixin_qq_com) + "/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen";
    AppMethodBeat.o(271880);
  }
  
  public CleanNewUI()
  {
    AppMethodBeat.i(22932);
    this.wTb = false;
    this.wTf = 0L;
    this.wTg = 0L;
    this.wTh = 0L;
    this.wTi = 0L;
    this.wTj = 0L;
    this.wTk = new com.tencent.mm.plugin.calcwx.c.a.a()
    {
      public final void diM()
      {
        AppMethodBeat.i(271865);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(271851);
            long l3 = Util.nowMilliSecond();
            long l4 = CleanNewUI.i(CleanNewUI.this);
            CleanNewUI.j(CleanNewUI.this).dismiss();
            aa.db(CleanNewUI.this, CleanNewUI.this.getString(R.l.gzZ));
            CleanNewUI.k(CleanNewUI.this).setText("0 B");
            CleanNewUI.l(CleanNewUI.this).setEnabled(false);
            long l2 = com.tencent.mm.plugin.clean.c.d.dqN().wRJ - com.tencent.mm.plugin.clean.c.d.dqN().wbD;
            long l1 = l2;
            if (l2 < 0L)
            {
              Log.e("MicroMsg.CleanNewUI", "cleanCacheFinish error, newWechatSize < 0. newWechatSize:%d, wechatSize:%d, cacheSize:%d", new Object[] { Long.valueOf(l2), Long.valueOf(com.tencent.mm.plugin.clean.c.d.dqN().wRJ), Long.valueOf(com.tencent.mm.plugin.clean.c.d.dqN().wbD) });
              l1 = 0L;
            }
            com.tencent.mm.plugin.clean.c.d.dqN().wRJ = l1;
            com.tencent.mm.plugin.clean.c.d.dqN().wbD = 0L;
            CleanNewUI.b(CleanNewUI.this, l1);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 15L, 1L, false);
            Log.d("MicroMsg.CleanNewUI", "clean cache cost time[%d] cacheSize[%d]", new Object[] { Long.valueOf(l3 - l4), Long.valueOf(com.tencent.mm.plugin.clean.c.d.dqN().wbD) });
            if (CleanNewUI.b(CleanNewUI.this))
            {
              Object localObject1 = new Intent();
              ((Intent)localObject1).putExtra("Intro_Need_Clear_Top ", true);
              com.tencent.mm.plugin.setting.c.pFn.n((Intent)localObject1, CleanNewUI.this.getContext());
              com.tencent.mm.bv.a.lJ(MMApplicationContext.getContext());
              localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
              Object localObject2 = new Object();
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$6$1", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
              System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$6$1", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
            }
            AppMethodBeat.o(271851);
          }
        });
        AppMethodBeat.o(271865);
      }
    };
    this.wTl = new com.tencent.mm.plugin.clean.b.a.a()
    {
      public final void l(final long paramAnonymousLong1, long paramAnonymousLong2, final long paramAnonymousLong3)
      {
        AppMethodBeat.i(271866);
        CleanNewUI.c(CleanNewUI.this, Util.nowMilliSecond());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(271855);
            CleanNewUI.a(CleanNewUI.this, paramAnonymousLong1, paramAnonymousLong3, this.wTt);
            AppMethodBeat.o(271855);
          }
        });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 53L, 1L, false);
        paramAnonymousLong1 = CleanNewUI.n(CleanNewUI.this) - CleanNewUI.o(CleanNewUI.this);
        paramAnonymousLong2 = CleanNewUI.p(CleanNewUI.this) - CleanNewUI.q(CleanNewUI.this);
        Log.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", new Object[] { Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1) });
        com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        AppMethodBeat.o(271866);
      }
      
      public final void onProgress(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(271862);
        if (!CleanNewUI.m(CleanNewUI.this)) {
          CleanNewUI.this.gD(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(271862);
      }
    };
    this.wTm = new IListener(com.tencent.mm.app.f.hfK) {};
    this.wRO = "com.tencent.qqpimsecure";
    this.wRP = "00B1208638DE0FCD3E920886D658DAF6";
    this.wRQ = "11206657";
    AppMethodBeat.o(22932);
  }
  
  private String bNL()
  {
    AppMethodBeat.i(22943);
    String str = hashCode();
    AppMethodBeat.o(22943);
    return str;
  }
  
  private boolean dqR()
  {
    AppMethodBeat.i(22941);
    dqS();
    if (!u.y(getContext(), this.wRO))
    {
      AppMethodBeat.o(22941);
      return false;
    }
    Object localObject = u.cG(this, this.wRO);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = com.tencent.mm.b.g.getMessageDigest(localObject[0].toByteArray());
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.wRP))) {
        try
        {
          localObject = getPackageManager().getLaunchIntentForPackage(this.wRO);
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            u.l(localBundle, this.wRQ);
            ((Intent)localObject).putExtras(localBundle);
            ((Intent)localObject).addFlags(268435456);
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 7L, 1L, false);
            AppMethodBeat.o(22941);
            return true;
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.CleanNewUI", localException, "", new Object[0]);
          AppMethodBeat.o(22941);
          return true;
        }
      }
    }
    AppMethodBeat.o(22941);
    return false;
  }
  
  private boolean dqS()
  {
    AppMethodBeat.i(22940);
    bh.bCz();
    String str = (String)com.tencent.mm.model.c.ban().get(at.a.acLS, "");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(22940);
      return false;
    }
    try
    {
      this.wRR = new JSONObject(str);
      this.wRO = this.wRR.getString("packageName");
      this.wRR.get("md5");
      this.wRQ = this.wRR.getString("launcherID");
      this.wRP = this.wRR.getString("signature");
      this.wRR.get("url");
      this.wRN = this.wRR.getLong("size");
      AppMethodBeat.o(22940);
      return true;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      AppMethodBeat.o(22940);
    }
    return false;
  }
  
  private void dqV()
  {
    AppMethodBeat.i(271856);
    TextView localTextView = this.wSW;
    com.tencent.mm.plugin.clean.c.d.dqN();
    localTextView.setText(Util.getSizeKB(com.tencent.mm.plugin.clean.c.d.dqP()));
    AppMethodBeat.o(271856);
  }
  
  private void dqW()
  {
    AppMethodBeat.i(271857);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
    {
      this.wTa.setVisibility(0);
      this.sIY.setVisibility(0);
      this.sIY.setText(com.tencent.mm.plugin.clean.a.eT(com.tencent.mm.plugin.clean.c.d.dqN().tbH));
    }
    AppMethodBeat.o(271857);
  }
  
  private void dqX()
  {
    AppMethodBeat.i(271860);
    ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).cex();
    ((cn)com.tencent.mm.kernel.h.az(cn.class)).dumpAndMarkFinderFolder();
    com.tencent.mm.xwebutil.c.bFh("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    this.wTc = new com.tencent.mm.plugin.clean.b.a(this.wTl, this.wbF);
    this.wTh = Util.nowMilliSecond();
    ThreadPool.post(this.wTc, "cleanUI_calc");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 52L, 1L, false);
    AppMethodBeat.o(271860);
  }
  
  private void kG(long paramLong)
  {
    int j = 5;
    AppMethodBeat.i(271852);
    com.tencent.mm.plugin.clean.c.d.dqN();
    long l1 = com.tencent.mm.plugin.clean.c.d.dqO();
    com.tencent.mm.plugin.clean.c.d.dqN();
    long l2 = com.tencent.mm.plugin.clean.c.d.dqP();
    long l3 = com.tencent.mm.plugin.clean.c.d.dqN().cWt;
    this.wSS.setText(Util.getSizeKB(l3 + paramLong));
    int i = (int)(100L * paramLong / l1);
    int k;
    ViewGroup.LayoutParams localLayoutParams;
    if (i > 0)
    {
      this.wSV.setText(getString(R.l.gAe, new Object[] { i + "%" }));
      k = getWindowManager().getDefaultDisplay().getWidth() - 48;
      localLayoutParams = this.wSQ.getLayoutParams();
      if (i != 0) {
        break label226;
      }
      i = 5;
      label136:
      localLayoutParams.width = i;
      this.wSQ.setLayoutParams(localLayoutParams);
      localLayoutParams = this.wSR.getLayoutParams();
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
      this.wSR.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(271852);
      return;
      this.wSV.setText(R.l.gAf);
      break;
      i = i * k / 100;
      break label136;
    }
  }
  
  private void kH(long paramLong)
  {
    AppMethodBeat.i(271853);
    this.wST.setText(Util.getSizeKB(paramLong));
    this.wSX.setEnabled(true);
    AppMethodBeat.o(271853);
  }
  
  private void kI(long paramLong)
  {
    AppMethodBeat.i(271854);
    this.wSU.setText(Util.getSizeKB(paramLong));
    if (paramLong > 0L)
    {
      this.wSY.setEnabled(true);
      AppMethodBeat.o(271854);
      return;
    }
    this.wSY.setEnabled(false);
    AppMethodBeat.o(271854);
  }
  
  private void m(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(271859);
    this.wSL.setVisibility(8);
    this.wSM.setVisibility(0);
    kG(paramLong1);
    kH(paramLong2);
    kI(paramLong3);
    dqV();
    dqW();
    AppMethodBeat.o(271859);
  }
  
  public final void gD(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(271884);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(271863);
        CleanNewUI.h(CleanNewUI.this).setText(CleanNewUI.this.getString(R.l.gAc, new Object[] { Integer.valueOf(paramInt1 * 100 / paramInt2) }));
        AppMethodBeat.o(271863);
      }
    });
    AppMethodBeat.o(271884);
  }
  
  public int getLayoutId()
  {
    return R.i.ghB;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22933);
    super.onCreate(paramBundle);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwT, 0);
    boolean bool;
    if (i != -1) {
      if (i == 2) {
        bool = true;
      }
    }
    for (;;)
    {
      this.wbF = bool;
      setMMTitle(R.l.gAd);
      setBackBtn(new CleanNewUI.1(this));
      this.wSL = ((LinearLayout)$(R.h.loading));
      this.wSO = ((TextView)$(R.h.fNf));
      this.wSM = ((LinearLayout)$(R.h.fXX));
      this.wSL.setVisibility(0);
      this.wSO.setText(getString(R.l.gAc, new Object[] { Integer.valueOf(0) }));
      this.wSM.setVisibility(8);
      this.wSP = ((LinearLayout)$(R.h.gdt));
      this.wSQ = ((View)$(R.h.gds));
      this.wSR = ((View)$(R.h.fSO));
      this.wSS = ((TextView)$(R.h.gdr));
      this.wSV = ((TextView)$(R.h.gdu));
      this.wSV.setVisibility(8);
      this.wST = ((TextView)$(R.h.fON));
      this.wSX = ((Button)$(R.h.gdq));
      this.wSX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22922);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (((n)com.tencent.mm.kernel.h.ax(n.class)).bAd().gbd()) {
            br.bCK();
          }
          Log.i("MicroMsg.CleanNewUI", "%s goto clean chatting ui", new Object[] { CleanNewUI.a(CleanNewUI.this) });
          CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanChattingUI.class), 0);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 12L, 1L, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(22922);
        }
      });
      this.wSU = ((TextView)$(R.h.fvj));
      this.wSY = ((Button)$(R.h.gdp));
      this.wSY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22923);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (CleanNewUI.b(CleanNewUI.this)) {}
          for (int i = R.l.gzY;; i = R.l.gAb)
          {
            Log.i("MicroMsg.CleanNewUI", "clean wechat cache");
            paramAnonymousView = new g.a(CleanNewUI.this);
            paramAnonymousView.aEY(MMApplicationContext.getContext().getResources().getColor(R.e.alert_btn_color_warn));
            paramAnonymousView.bDE(CleanNewUI.this.getString(i)).NF(true);
            paramAnonymousView.c(new g.c()
            {
              public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(271858);
                if (paramAnonymous2Boolean)
                {
                  Log.i("MicroMsg.CleanNewUI", "click cleanCacheBtn.");
                  paramAnonymous2String = CleanNewUI.this;
                  CleanNewUI localCleanNewUI = CleanNewUI.this;
                  CleanNewUI.this.getString(R.l.gAa);
                  CleanNewUI.a(paramAnonymous2String, k.b(localCleanNewUI, "", false, null));
                  CleanNewUI.a(CleanNewUI.this, Util.nowMilliSecond());
                  CleanNewUI.a(CleanNewUI.this, new com.tencent.mm.plugin.calcwx.c.a(com.tencent.mm.plugin.clean.c.d.dqN().wbC, com.tencent.mm.plugin.clean.c.d.dqN().wbD, com.tencent.mm.plugin.clean.c.d.dqN().wbE, CleanNewUI.c(CleanNewUI.this), CleanNewUI.b(CleanNewUI.this)));
                  ThreadPool.post(CleanNewUI.d(CleanNewUI.this), "cleanCacheTask");
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 14L, 1L, false);
                  if (CleanNewUI.b(CleanNewUI.this)) {
                    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 16L, 1L, false);
                  }
                }
                AppMethodBeat.o(271858);
              }
            }).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(22923);
            return;
          }
        }
      });
      this.wSN = ((LinearLayout)$(R.h.fTM));
      this.wSW = ((TextView)$(R.h.fTL));
      this.wSZ = ((Button)$(R.h.fTK));
      this.wSZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22925);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.CleanNewUI", "qq mgr btn click");
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 3L, 1L, false);
          if (!CleanNewUI.e(CleanNewUI.this))
          {
            if (!CleanNewUI.f(CleanNewUI.this)) {
              break label144;
            }
            k.b(CleanNewUI.this, CleanNewUI.this.getString(R.l.gAj), "", CleanNewUI.this.getString(R.l.app_download), CleanNewUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(22924);
                try
                {
                  Log.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new Object[] { new URL(CleanNewUI.g(CleanNewUI.this).getString("url")), CleanNewUI.g(CleanNewUI.this).getString("md5") });
                  paramAnonymous2DialogInterface = new Intent();
                  paramAnonymous2DialogInterface.putExtra("rawUrl", "https://sdi.3g.qq.com/v/2021111918295911309");
                  com.tencent.mm.br.c.b(CleanNewUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymous2DialogInterface);
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 4L, 1L, false);
                  AppMethodBeat.o(22924);
                  return;
                }
                catch (Exception paramAnonymous2DialogInterface)
                {
                  for (;;)
                  {
                    Log.printErrStackTrace("MicroMsg.CleanNewUI", paramAnonymous2DialogInterface, "", new Object[0]);
                  }
                }
              }
            }, null);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(22925);
            return;
            label144:
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", CleanNewUI.cIl());
            paramAnonymousView.putExtra("show_bottom", false);
            paramAnonymousView.putExtra("showShare", false);
            com.tencent.mm.br.c.b(CleanNewUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 5L, 1L, false);
          }
        }
      });
      if ((WeChatLocaleUtil.isOverseasUserByWechatLanguage()) || (ChannelUtil.channelId == 1))
      {
        this.wSN.setVisibility(8);
        this.wSZ.setVisibility(8);
      }
      this.sIY = ((TextView)$(R.h.fEu));
      this.wTa = ((LinearLayout)$(R.h.fEv));
      try
      {
        paramBundle = new HttpWrapperBase.Request(0, null, null, null);
        paramBundle.protocal = "https://";
        paramBundle.host = "jtool.qq.com";
        paramBundle.uri = "/channel?productId=31&channelId=102133";
        new HttpURLConnectionWrapper((HttpURLConnection)new URL(paramBundle.getUrl()).openConnection()).asyncSend(paramBundle, new CleanNewUI.9(this, ""), new MMHandler());
        paramBundle = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
        i = Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_reset_calc_index_time", "0", false, true), 0);
        if (i > paramBundle.getInt("CleanCalcResetIndexTime", 0))
        {
          paramBundle.encode("CleanCalcAlreadyResetIndex", false);
          paramBundle.encode("CleanCalcResetIndexTime", i);
        }
        bool = paramBundle.getBoolean("CleanCalcAlreadyResetIndex", false);
        if (!bool)
        {
          Log.i("MicroMsg.CleanNewUI", "reset index.");
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acTo, Long.valueOf(0L));
          paramBundle.encode("CleanCalcAlreadyResetIndex", true);
          paramBundle.encode("CleanCalcMidImg", 0L);
          paramBundle.encode("CleanCalcHevcImg", 0L);
        }
        if ((!bool) || (!com.tencent.mm.plugin.calcwx.a.diz().diE()))
        {
          Log.w("MicroMsg.CleanNewUI", "%s it scan not finish, alreadyResetIndex:%b", new Object[] { bNL(), Boolean.valueOf(bool) });
          this.wTf = Util.nowMilliSecond();
          this.wTb = true;
          this.wTm.alive();
          com.tencent.mm.plugin.calcwx.a.diz().mZ(true);
          gD(0, 100);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 1L, 1L, false);
          AppMethodBeat.o(22933);
          return;
          int j = getSharedPreferences("CleanUI", 0).getInt("aggressive_clean", 0);
          if (j == 1)
          {
            bool = true;
            continue;
          }
          if ((j != -1) && (i != 0))
          {
            bool = true;
            continue;
          }
          bool = false;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.CleanNewUI", paramBundle, paramBundle.getMessage(), new Object[0]);
          continue;
          Log.i("MicroMsg.CleanNewUI", "%s it scan finish", new Object[] { bNL() });
          this.wTb = false;
          dqX();
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 50L, 1L, false);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    boolean bool = false;
    AppMethodBeat.i(22935);
    super.onDestroy();
    Log.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", new Object[] { bNL(), Boolean.valueOf(this.wTb) });
    if (this.wTb)
    {
      this.wTm.dead();
      com.tencent.mm.plugin.calcwx.a locala = com.tencent.mm.plugin.calcwx.a.diz();
      String str = locala.bNL();
      if (locala.wbi != null) {
        bool = true;
      }
      Log.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      locala.post(new a.5(locala));
    }
    if (this.wTc != null) {
      this.wTc.stop();
    }
    AppMethodBeat.o(22935);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22934);
    super.onResume();
    if ((this.wTi > 0L) && (com.tencent.mm.plugin.clean.c.d.dqN().wRJ != 0L)) {
      m(com.tencent.mm.plugin.clean.c.d.dqN().wRJ, com.tencent.mm.plugin.clean.c.d.dqN().wRt, com.tencent.mm.plugin.clean.c.d.dqN().wbD);
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