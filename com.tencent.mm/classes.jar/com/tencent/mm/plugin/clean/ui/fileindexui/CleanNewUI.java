package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.na;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.h.a.7;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.event.EventCenter;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI
  extends MMActivity
{
  private static final String tOw;
  private TextView pDM;
  private String tOA;
  private JSONObject tOB;
  private long tOx;
  private String tOy;
  private String tOz;
  private View tPA;
  private View tPB;
  private TextView tPC;
  private TextView tPD;
  private TextView tPE;
  private TextView tPF;
  private TextView tPG;
  private Button tPH;
  private Button tPI;
  private Button tPJ;
  private LinearLayout tPK;
  private boolean tPL;
  private com.tencent.mm.plugin.clean.b.a tPM;
  private com.tencent.mm.plugin.h.c.a tPN;
  private s tPO;
  private long tPP;
  private long tPQ;
  private long tPR;
  private long tPS;
  private long tPT;
  private com.tencent.mm.plugin.h.c.a.a tPU;
  private com.tencent.mm.plugin.clean.b.a.a tPV;
  private IListener<na> tPW;
  private LinearLayout tPv;
  private LinearLayout tPw;
  private LinearLayout tPx;
  private TextView tPy;
  private LinearLayout tPz;
  
  static
  {
    AppMethodBeat.i(196290);
    tOw = "https://" + WeChatHosts.domainString(R.l.host_weixin_qq_com) + "/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen";
    AppMethodBeat.o(196290);
  }
  
  public CleanNewUI()
  {
    AppMethodBeat.i(22932);
    this.tPL = false;
    this.tPP = 0L;
    this.tPQ = 0L;
    this.tPR = 0L;
    this.tPS = 0L;
    this.tPT = 0L;
    this.tPU = new com.tencent.mm.plugin.h.c.a.a()
    {
      public final void cFt()
      {
        AppMethodBeat.i(291550);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(274188);
            long l3 = Util.nowMilliSecond();
            long l4 = CleanNewUI.i(CleanNewUI.this);
            CleanNewUI.j(CleanNewUI.this).dismiss();
            w.cR(CleanNewUI.this, CleanNewUI.this.getString(R.l.exo));
            CleanNewUI.k(CleanNewUI.this).setText("0 B");
            CleanNewUI.l(CleanNewUI.this).setEnabled(false);
            long l2 = com.tencent.mm.plugin.clean.c.d.cNh().tOt - com.tencent.mm.plugin.clean.c.d.cNh().sXm;
            long l1 = l2;
            if (l2 < 0L)
            {
              Log.e("MicroMsg.CleanNewUI", "cleanCacheFinish error, newWechatSize < 0. newWechatSize:%d, wechatSize:%d, cacheSize:%d", new Object[] { Long.valueOf(l2), Long.valueOf(com.tencent.mm.plugin.clean.c.d.cNh().tOt), Long.valueOf(com.tencent.mm.plugin.clean.c.d.cNh().sXm) });
              l1 = 0L;
            }
            com.tencent.mm.plugin.clean.c.d.cNh().tOt = l1;
            com.tencent.mm.plugin.clean.c.d.cNh().sXm = 0L;
            CleanNewUI.b(CleanNewUI.this, l1);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(714L, 15L, 1L, false);
            Log.d("MicroMsg.CleanNewUI", "clean cache cost time[%d] cacheSize[%d]", new Object[] { Long.valueOf(l3 - l4), Long.valueOf(com.tencent.mm.plugin.clean.c.d.cNh().sXm) });
            AppMethodBeat.o(274188);
          }
        });
        AppMethodBeat.o(291550);
      }
    };
    this.tPV = new com.tencent.mm.plugin.clean.b.a.a()
    {
      public final void fK(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(284585);
        if (!CleanNewUI.m(CleanNewUI.this)) {
          CleanNewUI.this.fM(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(284585);
      }
      
      public final void k(final long paramAnonymousLong1, long paramAnonymousLong2, final long paramAnonymousLong3)
      {
        AppMethodBeat.i(284586);
        CleanNewUI.c(CleanNewUI.this, Util.nowMilliSecond());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(277903);
            CleanNewUI.a(CleanNewUI.this, paramAnonymousLong1, paramAnonymousLong3, this.tQd);
            AppMethodBeat.o(277903);
          }
        });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(714L, 53L, 1L, false);
        paramAnonymousLong1 = CleanNewUI.n(CleanNewUI.this) - CleanNewUI.o(CleanNewUI.this);
        paramAnonymousLong2 = CleanNewUI.p(CleanNewUI.this) - CleanNewUI.q(CleanNewUI.this);
        Log.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", new Object[] { Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.h.IzE.a(14556, new Object[] { Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1) });
        com.tencent.mm.plugin.report.service.h.IzE.a(14556, new Object[] { Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.h.IzE.a(14556, new Object[] { Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        AppMethodBeat.o(284586);
      }
    };
    this.tPW = new IListener() {};
    this.tOy = "com.tencent.qqpimsecure";
    this.tOz = "00B1208638DE0FCD3E920886D658DAF6";
    this.tOA = "11206657";
    AppMethodBeat.o(22932);
  }
  
  private void Io(long paramLong)
  {
    int j = 5;
    AppMethodBeat.i(196241);
    com.tencent.mm.plugin.clean.c.d.cNh();
    long l1 = com.tencent.mm.plugin.clean.c.d.cNi();
    com.tencent.mm.plugin.clean.c.d.cNh();
    long l2 = com.tencent.mm.plugin.clean.c.d.cNj();
    long l3 = com.tencent.mm.plugin.clean.c.d.cNh().bcy;
    this.tPC.setText(Util.getSizeKB(l3 + paramLong));
    int i = (int)(100L * paramLong / l1);
    int k;
    ViewGroup.LayoutParams localLayoutParams;
    if (i > 0)
    {
      this.tPF.setText(getString(R.l.exu, new Object[] { i + "%" }));
      k = getWindowManager().getDefaultDisplay().getWidth() - 48;
      localLayoutParams = this.tPA.getLayoutParams();
      if (i != 0) {
        break label223;
      }
      i = 5;
      label134:
      localLayoutParams.width = i;
      this.tPA.setLayoutParams(localLayoutParams);
      localLayoutParams = this.tPB.getLayoutParams();
      localLayoutParams.width = ((int)((l1 - l2 - paramLong) * k / l1));
      if (localLayoutParams.width != 0) {
        break label234;
      }
    }
    label223:
    label234:
    for (i = j;; i = localLayoutParams.width)
    {
      localLayoutParams.width = i;
      this.tPB.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(196241);
      return;
      this.tPF.setText(R.l.exv);
      break;
      i = i * k / 100;
      break label134;
    }
  }
  
  private void Ip(long paramLong)
  {
    AppMethodBeat.i(196243);
    this.tPD.setText(Util.getSizeKB(paramLong));
    this.tPH.setEnabled(true);
    AppMethodBeat.o(196243);
  }
  
  private void Iq(long paramLong)
  {
    AppMethodBeat.i(196248);
    this.tPE.setText(Util.getSizeKB(paramLong));
    if (paramLong > 0L)
    {
      this.tPI.setEnabled(true);
      AppMethodBeat.o(196248);
      return;
    }
    this.tPI.setEnabled(false);
    AppMethodBeat.o(196248);
  }
  
  private String bqf()
  {
    AppMethodBeat.i(22943);
    String str = hashCode();
    AppMethodBeat.o(22943);
    return str;
  }
  
  private boolean cNl()
  {
    AppMethodBeat.i(22941);
    cNm();
    if (!q.u(getContext(), this.tOy))
    {
      AppMethodBeat.o(22941);
      return false;
    }
    Object localObject = q.cv(this, this.tOy);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = g.getMessageDigest(localObject[0].toByteArray());
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.tOz))) {
        try
        {
          localObject = getPackageManager().getLaunchIntentForPackage(this.tOy);
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            q.l(localBundle, this.tOA);
            ((Intent)localObject).putExtras(localBundle);
            ((Intent)localObject).addFlags(268435456);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(714L, 7L, 1L, false);
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
  
  private boolean cNm()
  {
    AppMethodBeat.i(22940);
    bh.beI();
    String str = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vky, "");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(22940);
      return false;
    }
    try
    {
      this.tOB = new JSONObject(str);
      this.tOy = this.tOB.getString("packageName");
      this.tOB.get("md5");
      this.tOA = this.tOB.getString("launcherID");
      this.tOz = this.tOB.getString("signature");
      this.tOB.get("url");
      this.tOx = this.tOB.getLong("size");
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
  
  private void cNp()
  {
    AppMethodBeat.i(196249);
    TextView localTextView = this.tPG;
    com.tencent.mm.plugin.clean.c.d.cNh();
    localTextView.setText(Util.getSizeKB(com.tencent.mm.plugin.clean.c.d.cNj()));
    AppMethodBeat.o(196249);
  }
  
  private void cNq()
  {
    AppMethodBeat.i(196250);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
    {
      this.tPK.setVisibility(0);
      this.pDM.setVisibility(0);
      this.pDM.setText(com.tencent.mm.plugin.clean.a.cY(com.tencent.mm.plugin.clean.c.d.cNh().pWR));
    }
    AppMethodBeat.o(196250);
  }
  
  private void cNr()
  {
    AppMethodBeat.i(196255);
    ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).bFj();
    ((ak)com.tencent.mm.kernel.h.ag(ak.class)).dumpAndMarkFinderFolder();
    com.tencent.mm.xwebutil.c.bCD("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    this.tPM = new com.tencent.mm.plugin.clean.b.a(this.tPV);
    this.tPR = Util.nowMilliSecond();
    ThreadPool.post(this.tPM, "cleanUI_calc");
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(714L, 52L, 1L, false);
    AppMethodBeat.o(196255);
  }
  
  private void l(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(196251);
    this.tPv.setVisibility(8);
    this.tPw.setVisibility(0);
    Io(paramLong1);
    Ip(paramLong2);
    Iq(paramLong3);
    cNp();
    cNq();
    AppMethodBeat.o(196251);
  }
  
  public final void fM(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(196253);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(279782);
        CleanNewUI.h(CleanNewUI.this).setText(CleanNewUI.this.getString(R.l.exr, new Object[] { Integer.valueOf(paramInt1 * 100 / paramInt2) }));
        AppMethodBeat.o(279782);
      }
    });
    AppMethodBeat.o(196253);
  }
  
  public int getLayoutId()
  {
    return R.i.eeJ;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22933);
    super.onCreate(paramBundle);
    setMMTitle(R.l.exs);
    setBackBtn(new CleanNewUI.1(this));
    this.tPv = ((LinearLayout)$(R.h.loading));
    this.tPy = ((TextView)$(R.h.dLx));
    this.tPw = ((LinearLayout)$(R.h.dVB));
    this.tPv.setVisibility(0);
    this.tPy.setText(getString(R.l.exr, new Object[] { Integer.valueOf(0) }));
    this.tPw.setVisibility(8);
    this.tPz = ((LinearLayout)$(R.h.eaP));
    this.tPA = ((View)$(R.h.eaO));
    this.tPB = ((View)$(R.h.dQI));
    this.tPC = ((TextView)$(R.h.eaN));
    this.tPF = ((TextView)$(R.h.eaQ));
    this.tPF.setVisibility(8);
    this.tPD = ((TextView)$(R.h.dMY));
    this.tPH = ((Button)$(R.h.eaM));
    this.tPH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22922);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (((n)com.tencent.mm.kernel.h.ae(n.class)).bco().eSi()) {
          bq.beT();
        }
        Log.i("MicroMsg.CleanNewUI", "%s goto clean chatting ui", new Object[] { CleanNewUI.a(CleanNewUI.this) });
        CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanChattingUI.class), 0);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(714L, 12L, 1L, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22922);
      }
    });
    this.tPE = ((TextView)$(R.h.duR));
    this.tPI = ((Button)$(R.h.eaL));
    this.tPI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22923);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.CleanNewUI", "clean wechat cache");
        paramAnonymousView = new f.a(CleanNewUI.this);
        paramAnonymousView.ayq(MMApplicationContext.getContext().getResources().getColor(R.e.alert_btn_color_warn));
        paramAnonymousView.bBl(CleanNewUI.this.getString(R.l.exq)).HL(true);
        paramAnonymousView.c(new f.c()
        {
          public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(233202);
            if (paramAnonymous2Boolean)
            {
              Log.i("MicroMsg.CleanNewUI", "click cleanCacheBtn.");
              paramAnonymous2String = CleanNewUI.this;
              CleanNewUI localCleanNewUI = CleanNewUI.this;
              CleanNewUI.this.getString(R.l.exp);
              CleanNewUI.a(paramAnonymous2String, com.tencent.mm.ui.base.h.b(localCleanNewUI, "", false, null));
              CleanNewUI.a(CleanNewUI.this, Util.nowMilliSecond());
              CleanNewUI.a(CleanNewUI.this, new com.tencent.mm.plugin.h.c.a(com.tencent.mm.plugin.clean.c.d.cNh().sXl, com.tencent.mm.plugin.clean.c.d.cNh().sXm, com.tencent.mm.plugin.clean.c.d.cNh().sXn, CleanNewUI.b(CleanNewUI.this)));
              ThreadPool.post(CleanNewUI.c(CleanNewUI.this), "cleanCacheTask");
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(714L, 14L, 1L, false);
            }
            AppMethodBeat.o(233202);
          }
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22923);
      }
    });
    this.tPx = ((LinearLayout)$(R.h.dRM));
    this.tPG = ((TextView)$(R.h.dRL));
    this.tPJ = ((Button)$(R.h.dRK));
    this.tPJ.setOnClickListener(new CleanNewUI.4(this));
    if ((WeChatLocaleUtil.isOverseasUserByWechatLanguage()) || (ChannelUtil.channelId == 1))
    {
      this.tPx.setVisibility(8);
      this.tPJ.setVisibility(8);
    }
    this.pDM = ((TextView)$(R.h.dDD));
    this.tPK = ((LinearLayout)$(R.h.dDE));
    try
    {
      paramBundle = new HttpWrapperBase.Request(0, null, null, null);
      paramBundle.protocal = "https://";
      paramBundle.host = "jtool.qq.com";
      paramBundle.uri = "/channel?productId=31&channelId=102133";
      new HttpURLConnectionWrapper((HttpURLConnection)new URL(paramBundle.getUrl()).openConnection()).asyncSend(paramBundle, new CleanNewUI.9(this, ""), new MMHandler());
      paramBundle = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
      int i = Util.getInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_reset_calc_index_time", "0", false, true), 0);
      if (i > paramBundle.getInt("CleanCalcResetIndexTime", 0))
      {
        paramBundle.encode("CleanCalcAlreadyResetIndex", false);
        paramBundle.encode("CleanCalcResetIndexTime", i);
      }
      boolean bool = paramBundle.getBoolean("CleanCalcAlreadyResetIndex", false);
      if (!bool)
      {
        Log.i("MicroMsg.CleanNewUI", "reset index.");
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrK, Long.valueOf(0L));
        paramBundle.encode("CleanCalcAlreadyResetIndex", true);
        paramBundle.encode("CleanCalcMidImg", 0L);
        paramBundle.encode("CleanCalcHevcImg", 0L);
      }
      if ((!bool) || (!com.tencent.mm.plugin.h.a.cFg().cFl()))
      {
        Log.w("MicroMsg.CleanNewUI", "%s it scan not finish, alreadyResetIndex:%b", new Object[] { bqf(), Boolean.valueOf(bool) });
        this.tPP = Util.nowMilliSecond();
        this.tPL = true;
        EventCenter.instance.add(this.tPW);
        com.tencent.mm.plugin.h.a.cFg().lF(true);
        fM(0, 100);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(714L, 1L, 1L, false);
        AppMethodBeat.o(22933);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CleanNewUI", paramBundle, paramBundle.getMessage(), new Object[0]);
        continue;
        Log.i("MicroMsg.CleanNewUI", "%s it scan finish", new Object[] { bqf() });
        this.tPL = false;
        cNr();
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(714L, 50L, 1L, false);
      }
    }
  }
  
  public void onDestroy()
  {
    boolean bool = false;
    AppMethodBeat.i(22935);
    super.onDestroy();
    Log.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", new Object[] { bqf(), Boolean.valueOf(this.tPL) });
    if (this.tPL)
    {
      EventCenter.instance.removeListener(this.tPW);
      com.tencent.mm.plugin.h.a locala = com.tencent.mm.plugin.h.a.cFg();
      String str = locala.bqf();
      if (locala.sWR != null) {
        bool = true;
      }
      Log.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      locala.post(new a.7(locala));
    }
    if (this.tPM != null) {
      this.tPM.stop();
    }
    AppMethodBeat.o(22935);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22934);
    super.onResume();
    if ((this.tPS > 0L) && (com.tencent.mm.plugin.clean.c.d.cNh().tOt != 0L)) {
      l(com.tencent.mm.plugin.clean.c.d.cNh().tOt, com.tencent.mm.plugin.clean.c.d.cNh().tOd, com.tencent.mm.plugin.clean.c.d.cNh().sXm);
    }
    AppMethodBeat.o(22934);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI
 * JD-Core Version:    0.7.0.1
 */