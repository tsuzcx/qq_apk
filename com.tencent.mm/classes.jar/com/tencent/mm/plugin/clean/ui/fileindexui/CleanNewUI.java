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
import com.tencent.mm.g.a.mj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.f.b.7;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpURLConnectionWrapper;
import com.tencent.mm.sdk.http.HttpWrapperBase.Request;
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
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI
  extends MMActivity
{
  private static final String qpO;
  private long qpP;
  private String qpQ;
  private String qpR;
  private String qpS;
  private JSONObject qpT;
  private LinearLayout qqO;
  private LinearLayout qqP;
  private LinearLayout qqQ;
  private TextView qqR;
  private LinearLayout qqS;
  private View qqT;
  private View qqU;
  private TextView qqV;
  private TextView qqW;
  private TextView qqX;
  private TextView qqY;
  private TextView qqZ;
  private Button qra;
  private Button qrb;
  private Button qrc;
  private boolean qrd;
  private com.tencent.mm.plugin.clean.b.a qre;
  private com.tencent.mm.plugin.f.c.a qrf;
  private com.tencent.mm.ui.base.q qrg;
  private long qrh;
  private long qri;
  private long qrj;
  private long qrk;
  private long qrl;
  private com.tencent.mm.plugin.f.c.a.a qrm;
  private com.tencent.mm.plugin.clean.b.a.a qrn;
  private IListener<mj> qro;
  
  static
  {
    AppMethodBeat.i(231682);
    qpO = "https://" + WeChatHosts.domainString(2131761749) + "/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen";
    AppMethodBeat.o(231682);
  }
  
  public CleanNewUI()
  {
    AppMethodBeat.i(22932);
    this.qrd = false;
    this.qrh = 0L;
    this.qri = 0L;
    this.qrj = 0L;
    this.qrk = 0L;
    this.qrl = 0L;
    this.qrm = new com.tencent.mm.plugin.f.c.a.a()
    {
      public final void csi()
      {
        AppMethodBeat.i(231663);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231662);
            long l3 = Util.nowMilliSecond();
            long l4 = CleanNewUI.i(CleanNewUI.this);
            CleanNewUI.j(CleanNewUI.this).dismiss();
            u.cG(CleanNewUI.this, CleanNewUI.this.getString(2131757583));
            CleanNewUI.k(CleanNewUI.this).setText("0 B");
            CleanNewUI.l(CleanNewUI.this).setEnabled(false);
            long l2 = com.tencent.mm.plugin.clean.c.d.cyM().qpK - com.tencent.mm.plugin.clean.c.d.cyM().cacheSize;
            long l1 = l2;
            if (l2 < 0L)
            {
              Log.e("MicroMsg.CleanNewUI", "cleanCacheFinish error, newWechatSize < 0. newWechatSize:%d, wechatSize:%d, cacheSize:%d", new Object[] { Long.valueOf(l2), Long.valueOf(com.tencent.mm.plugin.clean.c.d.cyM().qpK), Long.valueOf(com.tencent.mm.plugin.clean.c.d.cyM().cacheSize) });
              l1 = 0L;
            }
            com.tencent.mm.plugin.clean.c.d.cyM().qpK = l1;
            com.tencent.mm.plugin.clean.c.d.cyM().cacheSize = 0L;
            CleanNewUI.b(CleanNewUI.this, l1);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 15L, 1L, false);
            Log.d("MicroMsg.CleanNewUI", "clean cache cost time[%d] cacheSize[%d]", new Object[] { Long.valueOf(l3 - l4), Long.valueOf(com.tencent.mm.plugin.clean.c.d.cyM().cacheSize) });
            AppMethodBeat.o(231662);
          }
        });
        AppMethodBeat.o(231663);
      }
    };
    this.qrn = new com.tencent.mm.plugin.clean.b.a.a()
    {
      public final void fn(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(231665);
        if (!CleanNewUI.m(CleanNewUI.this)) {
          CleanNewUI.this.fp(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(231665);
      }
      
      public final void j(final long paramAnonymousLong1, long paramAnonymousLong2, final long paramAnonymousLong3)
      {
        AppMethodBeat.i(231666);
        CleanNewUI.c(CleanNewUI.this, Util.nowMilliSecond());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231664);
            CleanNewUI.a(CleanNewUI.this, paramAnonymousLong1, paramAnonymousLong3, this.qrv);
            AppMethodBeat.o(231664);
          }
        });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 53L, 1L, false);
        paramAnonymousLong1 = CleanNewUI.n(CleanNewUI.this) - CleanNewUI.o(CleanNewUI.this);
        paramAnonymousLong2 = CleanNewUI.p(CleanNewUI.this) - CleanNewUI.q(CleanNewUI.this);
        Log.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", new Object[] { Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.h.CyF.a(14556, new Object[] { Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.o(CleanNewUI.this)), Long.valueOf(CleanNewUI.n(CleanNewUI.this)), Long.valueOf(paramAnonymousLong1) });
        com.tencent.mm.plugin.report.service.h.CyF.a(14556, new Object[] { Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.q(CleanNewUI.this)), Long.valueOf(CleanNewUI.p(CleanNewUI.this)), Long.valueOf(paramAnonymousLong2) });
        com.tencent.mm.plugin.report.service.h.CyF.a(14556, new Object[] { Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(paramAnonymousLong1 + paramAnonymousLong2) });
        AppMethodBeat.o(231666);
      }
    };
    this.qro = new IListener() {};
    this.qpQ = "com.tencent.qqpimsecure";
    this.qpR = "00B1208638DE0FCD3E920886D658DAF6";
    this.qpS = "11206657";
    AppMethodBeat.o(22932);
  }
  
  private void Cf(long paramLong)
  {
    int j = 5;
    AppMethodBeat.i(231670);
    com.tencent.mm.plugin.clean.c.d.cyM();
    long l1 = com.tencent.mm.plugin.clean.c.d.cyN();
    com.tencent.mm.plugin.clean.c.d.cyM();
    long l2 = com.tencent.mm.plugin.clean.c.d.cyO();
    long l3 = com.tencent.mm.plugin.clean.c.d.cyM().dataSize;
    this.qqV.setText(Util.getSizeKB(l3 + paramLong));
    int i = (int)(100L * paramLong / l1);
    int k;
    ViewGroup.LayoutParams localLayoutParams;
    if (i > 0)
    {
      this.qqY.setText(getString(2131757595, new Object[] { i + "%" }));
      k = getWindowManager().getDefaultDisplay().getWidth() - 48;
      localLayoutParams = this.qqT.getLayoutParams();
      if (i != 0) {
        break label221;
      }
      i = 5;
      label133:
      localLayoutParams.width = i;
      this.qqT.setLayoutParams(localLayoutParams);
      localLayoutParams = this.qqU.getLayoutParams();
      localLayoutParams.width = ((int)((l1 - l2 - paramLong) * k / l1));
      if (localLayoutParams.width != 0) {
        break label232;
      }
    }
    label221:
    label232:
    for (i = j;; i = localLayoutParams.width)
    {
      localLayoutParams.width = i;
      this.qqU.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(231670);
      return;
      this.qqY.setText(2131757596);
      break;
      i = i * k / 100;
      break label133;
    }
  }
  
  private void Cg(long paramLong)
  {
    AppMethodBeat.i(231671);
    this.qqW.setText(Util.getSizeKB(paramLong));
    this.qra.setEnabled(true);
    AppMethodBeat.o(231671);
  }
  
  private void Ch(long paramLong)
  {
    AppMethodBeat.i(231672);
    this.qqX.setText(Util.getSizeKB(paramLong));
    if (paramLong > 0L)
    {
      this.qrb.setEnabled(true);
      AppMethodBeat.o(231672);
      return;
    }
    this.qrb.setEnabled(false);
    AppMethodBeat.o(231672);
  }
  
  private String bgQ()
  {
    AppMethodBeat.i(22943);
    String str = hashCode();
    AppMethodBeat.o(22943);
    return str;
  }
  
  private boolean cyQ()
  {
    AppMethodBeat.i(22941);
    cyR();
    if (!com.tencent.mm.pluginsdk.model.app.q.s(getContext(), this.qpQ))
    {
      AppMethodBeat.o(22941);
      return false;
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.q.cj(this, this.qpQ);
    if ((localObject != null) && (localObject[0] != null))
    {
      localObject = com.tencent.mm.b.g.getMessageDigest(localObject[0].toByteArray());
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.qpR))) {
        try
        {
          localObject = getPackageManager().getLaunchIntentForPackage(this.qpQ);
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            com.tencent.mm.pluginsdk.model.app.q.k(localBundle, this.qpS);
            ((Intent)localObject).putExtras(localBundle);
            ((Intent)localObject).addFlags(268435456);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI", "jumpToQQMgrApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 7L, 1L, false);
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
  
  private boolean cyR()
  {
    AppMethodBeat.i(22940);
    bg.aVF();
    String str = (String)com.tencent.mm.model.c.azQ().get(ar.a.NWy, "");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(22940);
      return false;
    }
    try
    {
      this.qpT = new JSONObject(str);
      this.qpQ = this.qpT.getString("packageName");
      this.qpT.get("md5");
      this.qpS = this.qpT.getString("launcherID");
      this.qpR = this.qpT.getString("signature");
      this.qpT.get("url");
      this.qpP = this.qpT.getLong("size");
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
  
  private void cyU()
  {
    AppMethodBeat.i(231673);
    TextView localTextView = this.qqZ;
    com.tencent.mm.plugin.clean.c.d.cyM();
    localTextView.setText(Util.getSizeKB(com.tencent.mm.plugin.clean.c.d.cyO()));
    AppMethodBeat.o(231673);
  }
  
  private void cyV()
  {
    AppMethodBeat.i(231676);
    ((f)com.tencent.mm.kernel.g.af(f.class)).buj();
    ((aj)com.tencent.mm.kernel.g.ah(aj.class)).dumpAndMarkFinderFolder();
    com.tencent.mm.cr.d.bpG("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    this.qre = new com.tencent.mm.plugin.clean.b.a(this.qrn);
    this.qrj = Util.nowMilliSecond();
    ThreadPool.post(this.qre, "cleanUI_calc");
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 52L, 1L, false);
    AppMethodBeat.o(231676);
  }
  
  private void k(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(231674);
    this.qqO.setVisibility(8);
    this.qqP.setVisibility(0);
    Cf(paramLong1);
    Cg(paramLong2);
    Ch(paramLong3);
    cyU();
    AppMethodBeat.o(231674);
  }
  
  public final void fp(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(231675);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231661);
        CleanNewUI.h(CleanNewUI.this).setText(CleanNewUI.this.getString(2131757587, new Object[] { Integer.valueOf(paramInt1 * 100 / paramInt2) }));
        AppMethodBeat.o(231661);
      }
    });
    AppMethodBeat.o(231675);
  }
  
  public int getLayoutId()
  {
    return 2131493652;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22933);
    super.onCreate(paramBundle);
    setMMTitle(2131757593);
    setBackBtn(new CleanNewUI.1(this));
    this.qqO = ((LinearLayout)$(2131303690));
    this.qqR = ((TextView)$(2131303710));
    this.qqP = ((LinearLayout)$(2131308317));
    this.qqO.setVisibility(0);
    this.qqR.setText(getString(2131757587, new Object[] { Integer.valueOf(0) }));
    this.qqP.setVisibility(8);
    this.qqS = ((LinearLayout)$(2131310429));
    this.qqT = ((View)$(2131310427));
    this.qqU = ((View)$(2131305739));
    this.qqV = ((TextView)$(2131310426));
    this.qqY = ((TextView)$(2131310431));
    this.qqY.setVisibility(8);
    this.qqW = ((TextView)$(2131304978));
    this.qra = ((Button)$(2131310421));
    this.qra.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22922);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (((l)com.tencent.mm.kernel.g.af(l.class)).aTq().eiC()) {
          bp.aVQ();
        }
        Log.i("MicroMsg.CleanNewUI", "%s goto clean chatting ui", new Object[] { CleanNewUI.a(CleanNewUI.this) });
        CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanChattingUI.class), 0);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 12L, 1L, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22922);
      }
    });
    this.qqX = ((TextView)$(2131297945));
    this.qrb = ((Button)$(2131310420));
    this.qrb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22923);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.CleanNewUI", "clean wechat cache");
        paramAnonymousView = new f.a(CleanNewUI.this);
        paramAnonymousView.apb(MMApplicationContext.getContext().getResources().getColor(2131099922));
        paramAnonymousView.bow(CleanNewUI.this.getString(2131757585)).Dq(true);
        paramAnonymousView.c(new f.c()
        {
          public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(231660);
            if (paramAnonymous2Boolean)
            {
              Log.i("MicroMsg.CleanNewUI", "click cleanCacheBtn.");
              paramAnonymous2String = CleanNewUI.this;
              CleanNewUI localCleanNewUI = CleanNewUI.this;
              CleanNewUI.this.getString(2131757584);
              CleanNewUI.a(paramAnonymous2String, com.tencent.mm.ui.base.h.b(localCleanNewUI, "", false, null));
              CleanNewUI.a(CleanNewUI.this, Util.nowMilliSecond());
              CleanNewUI.a(CleanNewUI.this, new com.tencent.mm.plugin.f.c.a(com.tencent.mm.plugin.clean.c.d.cyM().pQk, com.tencent.mm.plugin.clean.c.d.cyM().cacheSize, com.tencent.mm.plugin.clean.c.d.cyM().pQl, CleanNewUI.b(CleanNewUI.this)));
              ThreadPool.post(CleanNewUI.c(CleanNewUI.this), "cleanCacheTask");
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 14L, 1L, false);
            }
            AppMethodBeat.o(231660);
          }
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22923);
      }
    });
    this.qqQ = ((LinearLayout)$(2131306348));
    this.qqZ = ((TextView)$(2131306347));
    this.qrc = ((Button)$(2131306346));
    this.qrc.setOnClickListener(new CleanNewUI.4(this));
    if ((WeChatLocaleUtil.isOverseasUserByWechatLanguage()) || (ChannelUtil.channelId == 1))
    {
      this.qqQ.setVisibility(8);
      this.qrc.setVisibility(8);
    }
    try
    {
      paramBundle = new HttpWrapperBase.Request(0, null, null, null);
      paramBundle.protocal = "https://";
      paramBundle.host = "jtool.qq.com";
      paramBundle.uri = "/channel?productId=31&channelId=102133";
      new HttpURLConnectionWrapper((HttpURLConnection)new URL(paramBundle.getUrl()).openConnection()).asyncSend(paramBundle, new CleanNewUI.9(this, ""), new MMHandler());
      paramBundle = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
      int i = Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_reset_calc_index_time", "0", false, true), 0);
      if (i > paramBundle.getInt("CleanCalcResetIndexTime", 0))
      {
        paramBundle.encode("CleanCalcAlreadyResetIndex", false);
        paramBundle.encode("CleanCalcResetIndexTime", i);
      }
      boolean bool = paramBundle.getBoolean("CleanCalcAlreadyResetIndex", false);
      if (!bool)
      {
        Log.i("MicroMsg.CleanNewUI", "reset index.");
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Odz, Long.valueOf(0L));
        paramBundle.encode("CleanCalcAlreadyResetIndex", true);
        paramBundle.encode("CleanCalcMidImg", 0L);
        paramBundle.encode("CleanCalcHevcImg", 0L);
      }
      if ((!bool) || (!com.tencent.mm.plugin.f.b.crW().csb()))
      {
        Log.w("MicroMsg.CleanNewUI", "%s it scan not finish, alreadyResetIndex:%b", new Object[] { bgQ(), Boolean.valueOf(bool) });
        this.qrh = Util.nowMilliSecond();
        this.qrd = true;
        EventCenter.instance.add(this.qro);
        com.tencent.mm.plugin.f.b.crW().kt(true);
        fp(0, 100);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 1L, 1L, false);
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
        Log.i("MicroMsg.CleanNewUI", "%s it scan finish", new Object[] { bgQ() });
        this.qrd = false;
        cyV();
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 50L, 1L, false);
      }
    }
  }
  
  public void onDestroy()
  {
    boolean bool = false;
    AppMethodBeat.i(22935);
    super.onDestroy();
    Log.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", new Object[] { bgQ(), Boolean.valueOf(this.qrd) });
    if (this.qrd)
    {
      EventCenter.instance.removeListener(this.qro);
      com.tencent.mm.plugin.f.b localb = com.tencent.mm.plugin.f.b.crW();
      String str = localb.bgQ();
      if (localb.pPQ != null) {
        bool = true;
      }
      Log.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      localb.post(new b.7(localb));
    }
    if (this.qre != null) {
      this.qre.stop();
    }
    AppMethodBeat.o(22935);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22934);
    super.onResume();
    if ((this.qrk > 0L) && (com.tencent.mm.plugin.clean.c.d.cyM().qpK != 0L)) {
      k(com.tencent.mm.plugin.clean.c.d.cyM().qpK, com.tencent.mm.plugin.clean.c.d.cyM().qpu, com.tencent.mm.plugin.clean.c.d.cyM().cacheSize);
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