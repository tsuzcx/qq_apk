package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.plugin.sport.ui.SportChartView.a;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.b;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import junit.framework.Assert;

public class ExdeviceProfileUI
  extends MMActivity
  implements f, com.tencent.mm.plugin.exdevice.g.b.e, c
{
  private static int qsk = 0;
  private TextPaint ayp;
  private int gIk;
  private GestureDetector iNw;
  private String lJm;
  private String lpE;
  private String mAppName;
  private Context mContext;
  private boolean mIsDestroyed;
  private boolean qlF;
  private List<String> qlV;
  private List<String> qlW;
  private String qlt;
  private p qpG;
  private String qrL;
  private com.tencent.mm.plugin.exdevice.g.b.a.a qrM;
  private ArrayList<String> qrN;
  private ekq qrO;
  private ExdeviceProfileAffectedUserView qrP;
  private ImageView qrQ;
  private ListView qrR;
  private ExdeviceProfileListHeader qrS;
  private MMSwitchBtn qrT;
  private SportChartView qrU;
  private a qrV;
  private View qrW;
  private volatile boolean qrX;
  private String qrY;
  private String qrZ;
  private boolean qrq;
  private boolean qrr;
  private int qrs;
  private List<re> qrv;
  private List<com.tencent.mm.plugin.sport.a.d> qsa;
  private List<com.tencent.mm.plugin.sport.a.d> qsb;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> qsc;
  private List<ats> qsd;
  private int qse;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.i> qsf;
  private com.tencent.mm.plugin.sport.model.d qsg;
  private n.e qsh;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.h> qsi;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.g> qsj;
  private Runnable qsl;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.g> qsm;
  private List<String> qsn;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.k> qso;
  private com.tencent.mm.plugin.exdevice.g.a.k qsp;
  private com.tencent.mm.sdk.b.c<ol> qsq;
  private MMPullDownView.a qsr;
  
  public ExdeviceProfileUI()
  {
    AppMethodBeat.i(24132);
    this.mIsDestroyed = false;
    this.qpG = null;
    this.qsf = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.ayp = new TextPaint(1);
    this.gIk = 0;
    this.qsh = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(179628);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.plugin.sport.a.c.md(27);
          ExdeviceProfileUI.r(ExdeviceProfileUI.this);
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.plugin.sport.a.c.md(26);
          ExdeviceProfileUI.s(ExdeviceProfileUI.this);
          AppMethodBeat.o(179628);
          return;
          ExdeviceProfileUI.t(ExdeviceProfileUI.this);
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.ui.base.h.a(ExdeviceProfileUI.this.getContext(), ExdeviceProfileUI.this.getString(2131758619), null, true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(179627);
              bc.aCg();
              paramAnonymous2DialogInterface = com.tencent.mm.model.c.azF().BH(ExdeviceProfileUI.u(ExdeviceProfileUI.this));
              com.tencent.mm.plugin.sport.a.c.md(37);
              x.r(paramAnonymous2DialogInterface);
              ExdeviceProfileUI.v(ExdeviceProfileUI.this).alive();
              if (ExdeviceProfileUI.d(ExdeviceProfileUI.this) != null) {
                ExdeviceProfileUI.d(ExdeviceProfileUI.this).show();
              }
              AppMethodBeat.o(179627);
            }
          }, null);
          AppMethodBeat.o(179628);
          return;
          ExdeviceProfileUI.b(ExdeviceProfileUI.this, true);
          com.tencent.mm.plugin.sport.a.c.md(10);
          ad.cmR();
          com.tencent.mm.plugin.exdevice.g.b.c.c("", ExdeviceProfileUI.w(ExdeviceProfileUI.this), ExdeviceProfileUI.u(ExdeviceProfileUI.this), 3);
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.plugin.sport.a.c.md(41);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", ExdeviceProfileUI.o(ExdeviceProfileUI.this));
          com.tencent.mm.br.d.b(ExdeviceProfileUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
        }
      }
    };
    this.qsi = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.qsj = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.qsl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179611);
        Object localObject1 = ExdeviceProfileUI.z(ExdeviceProfileUI.this);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$22", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$22", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        if (ExdeviceProfileUI.z(ExdeviceProfileUI.this).getCount() > 0) {
          BackwardSupportUtil.c.b(ExdeviceProfileUI.z(ExdeviceProfileUI.this), ExdeviceProfileUI.z(ExdeviceProfileUI.this).getCount() - 1);
        }
        AppMethodBeat.o(179611);
      }
    };
    this.qsm = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.qso = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.qsq = new com.tencent.mm.sdk.b.c() {};
    this.qsr = new MMPullDownView.a()
    {
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179622);
        GestureDetector localGestureDetector = ExdeviceProfileUI.G(ExdeviceProfileUI.this);
        paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramAnonymousMotionEvent.ahE(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$32", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.mt(0)), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$32", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(179622);
        return bool;
      }
    };
    AppMethodBeat.o(24132);
  }
  
  private void cnA()
  {
    AppMethodBeat.i(24134);
    this.qsc = ad.cmL().cmX();
    if (this.qsc != null) {
      ae.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", new Object[] { Integer.valueOf(this.qsc.size()), this.qsc.toString() });
    }
    while (!bu.ht(this.qsc))
    {
      this.qrs = this.qsc.size();
      AppMethodBeat.o(24134);
      return;
      ae.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
    }
    this.qrs = 0;
    AppMethodBeat.o(24134);
  }
  
  private void cnB()
  {
    AppMethodBeat.i(24135);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179625);
        a locala = ExdeviceProfileUI.l(ExdeviceProfileUI.this);
        ArrayList localArrayList = ExdeviceProfileUI.p(ExdeviceProfileUI.this);
        List localList = ExdeviceProfileUI.q(ExdeviceProfileUI.this);
        locala.qrr = ad.cmL().adu(locala.lJm);
        locala.qru = localArrayList;
        if (!bu.ht(localArrayList)) {}
        for (locala.qrs = localArrayList.size();; locala.qrs = 0)
        {
          locala.qrv = localList;
          if (!bu.ht(localList)) {
            locala.qrt = localList.size();
          }
          ae.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", new Object[] { Boolean.valueOf(locala.qrr), Integer.valueOf(locala.qrs), Integer.valueOf(locala.qrt), locala.lJm });
          ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
          AppMethodBeat.o(179625);
          return;
        }
      }
    });
    AppMethodBeat.o(24135);
  }
  
  private void cnC()
  {
    AppMethodBeat.i(24138);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179603);
        ExdeviceProfileUI.g(ExdeviceProfileUI.this);
        ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
        AppMethodBeat.o(179603);
      }
    });
    AppMethodBeat.o(24138);
  }
  
  private void cnD()
  {
    AppMethodBeat.i(24140);
    String str = v.aAC();
    if (this.qrW != null) {
      this.qrW.setVisibility(8);
    }
    if ((!bu.isNullOrNil(str)) && (str.equals(this.lJm)))
    {
      if ((this.qrM != null) && (bu.isNullOrNil(this.qrM.field_championUrl)) && (this.qrW != null)) {
        this.qrW.setVisibility(0);
      }
      if (this.qrS != null)
      {
        this.qrS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24107);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            com.tencent.mm.plugin.sport.a.c.md(18);
            com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceProfileUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24107);
          }
        });
        AppMethodBeat.o(24140);
      }
    }
    else if ((this.qrM != null) && (!bu.isNullOrNil(this.qrM.field_championUrl)) && (this.qrS != null))
    {
      this.qrS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179610);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ExdeviceProfileUI.B(ExdeviceProfileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179610);
        }
      });
    }
    AppMethodBeat.o(24140);
  }
  
  private void cnE()
  {
    AppMethodBeat.i(24141);
    if (this.qrM != null)
    {
      if ((this.lpE != this.qrM.field_championUrl) && ((this.lpE == null) || (!this.lpE.equals(this.qrM.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.qrQ, this.qrM.field_championUrl);
        this.lpE = this.qrM.field_championUrl;
        AppMethodBeat.o(24141);
      }
    }
    else
    {
      this.qrQ.setImageResource(2131100204);
      this.lpE = null;
    }
    AppMethodBeat.o(24141);
  }
  
  private void cnH()
  {
    AppMethodBeat.i(161358);
    if (this.qrU == null) {
      this.qrU = ((SportChartView)findViewById(2131299585));
    }
    if (this.qrU == null)
    {
      AppMethodBeat.o(161358);
      return;
    }
    if (this.qrT == null) {
      this.qrT = ((MMSwitchBtn)findViewById(2131299587));
    }
    HashSet localHashSet = new HashSet();
    final ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    com.tencent.mm.plugin.sport.a.d locald;
    if (this.qsa != null)
    {
      localIterator = this.qsa.iterator();
      while (localIterator.hasNext())
      {
        locald = (com.tencent.mm.plugin.sport.a.d)localIterator.next();
        if (localHashSet.add(locald.field_date)) {
          localArrayList.add(locald);
        }
      }
    }
    if (this.qsb != null)
    {
      localIterator = this.qsb.iterator();
      while (localIterator.hasNext())
      {
        locald = (com.tencent.mm.plugin.sport.a.d)localIterator.next();
        if (localHashSet.add(locald.field_date)) {
          localArrayList.add(locald);
        }
      }
    }
    Collections.sort(localArrayList);
    if (localArrayList.size() > 0)
    {
      if (this.qrq)
      {
        this.qrU.setHasSwitchBtn(true);
        this.qrT.setVisibility(0);
        this.qrT.setSwitchListener(new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(179621);
            if (paramAnonymousBoolean) {
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).a(SportChartView.a.AZh);
            }
            for (;;)
            {
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).gs(localArrayList);
              AppMethodBeat.o(179621);
              return;
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).a(SportChartView.a.AZg);
            }
          }
        });
      }
      for (;;)
      {
        this.qrU.setTodayStep(((com.tencent.mm.plugin.sport.a.d)localArrayList.get(localArrayList.size() - 1)).field_step);
        this.qrU.gs(localArrayList);
        AppMethodBeat.o(161358);
        return;
        this.qrU.setHasSwitchBtn(false);
        this.qrT.setVisibility(8);
        this.qrT.setSwitchListener(null);
        this.qrU.a(SportChartView.a.AZg);
        this.qrU.gs(localArrayList);
      }
    }
    this.qrU.setHasSwitchBtn(false);
    this.qrT.setVisibility(8);
    this.qrU.gs(null);
    AppMethodBeat.o(161358);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.g.b.d paramd)
  {
    AppMethodBeat.i(24143);
    if (("HardDeviceChampionInfo".equals(paramString)) && (this.lJm.equals(paramd.username)))
    {
      ae.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
      this.qrM = ad.cmN().adw(this.lJm);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179614);
          ExdeviceProfileUI.C(ExdeviceProfileUI.this);
          ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
          ExdeviceProfileUI.D(ExdeviceProfileUI.this);
          AppMethodBeat.o(179614);
        }
      });
    }
    AppMethodBeat.o(24143);
  }
  
  public final void cnF()
  {
    AppMethodBeat.i(24144);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179617);
        if (ExdeviceProfileUI.d(ExdeviceProfileUI.this) != null) {
          ExdeviceProfileUI.d(ExdeviceProfileUI.this).show();
        }
        AppMethodBeat.o(179617);
      }
    });
    if (this.qsp != null) {
      bc.ajj().a(this.qsp);
    }
    this.qsp = new com.tencent.mm.plugin.exdevice.g.a.k(this.qso);
    bc.ajj().a(this.qsp, 0);
    AppMethodBeat.o(24144);
  }
  
  public final void cnG()
  {
    AppMethodBeat.i(24145);
    com.tencent.mm.plugin.sport.a.c.md(17);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.lJm);
    bc.ajj().a(new com.tencent.mm.plugin.exdevice.g.a.g(localArrayList, this.qsj), 0);
    AppMethodBeat.o(24145);
  }
  
  public int getLayoutId()
  {
    return 2131493878;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24142);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, paramInt1, paramInt2, paramIntent, this.mAppName))
    {
      AppMethodBeat.o(24142);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24142);
      return;
      if (paramInt2 == -1)
      {
        Toast.makeText(this, 2131763646, 1).show();
        AppMethodBeat.o(24142);
        return;
        if (paramInt2 == -1)
        {
          if (paramIntent == null) {}
          String str2;
          for (String str1 = null;; str1 = paramIntent.getStringExtra("Select_Conv_User"))
          {
            str2 = ac.eH(this);
            if ((str1 != null) && (str1.length() != 0)) {
              break;
            }
            ae.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
            AppMethodBeat.o(24142);
            return;
          }
          ac.a(this, str1, str2, paramIntent.getStringExtra("custom_send_text"), this.qrZ);
          com.tencent.mm.ui.base.h.cm(getContext(), getResources().getString(2131755894));
          AppMethodBeat.o(24142);
          return;
          if (paramInt2 == -1)
          {
            paramIntent = bu.U(paramIntent.getStringExtra("Select_Contact").split(","));
            if (paramIntent == null)
            {
              AppMethodBeat.o(24142);
              return;
            }
            if (this.qpG != null) {
              this.qpG.show();
            }
            bc.ajj().a(new com.tencent.mm.plugin.exdevice.g.a.g(paramIntent, this.qsm), 0);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24133);
    super.onCreate(paramBundle);
    this.mContext = getContext();
    paramBundle = getIntent();
    cnA();
    this.lJm = paramBundle.getStringExtra("username");
    this.qrL = paramBundle.getStringExtra("usernickname");
    paramBundle = v.aAC();
    if (paramBundle != null) {
      this.qrq = paramBundle.equals(this.lJm);
    }
    this.mAppName = getIntent().getStringExtra("app_username");
    this.qrr = ad.cmL().adu(this.lJm);
    ae.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[] { Boolean.valueOf(this.qrr) });
    boolean bool;
    int m;
    Object localObject2;
    if (!bu.isNullOrNil(this.lJm))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.qrM = ad.cmN().adw(this.lJm);
      this.qrN = getIntent().getStringArrayListExtra("key_affected_semi");
      getString(2131755906);
      this.qpG = com.tencent.mm.ui.base.h.c(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(179604);
          if (ExdeviceProfileUI.d(ExdeviceProfileUI.this) != null)
          {
            ExdeviceProfileUI.d(ExdeviceProfileUI.this).dismiss();
            ExdeviceProfileUI.y(ExdeviceProfileUI.this);
          }
          ExdeviceProfileUI.this.finish();
          AppMethodBeat.o(179604);
        }
      });
      this.qrP = ((ExdeviceProfileAffectedUserView)findViewById(2131299542));
      this.qrQ = ((ImageView)findViewById(2131299545));
      this.qrR = ((ListView)findViewById(2131299581));
      paramBundle = (MMPullDownView)findViewById(2131303543);
      this.qrP.setAffectedUserInfo(this.qrN);
      cnE();
      this.qrW = findViewById(2131304599);
      this.iNw = new GestureDetector(getContext(), new a((byte)0));
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setTopViewVisible(false);
      paramBundle.setBottomViewVisible(false);
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setIsTopShowAll(false);
      paramBundle.setCanOverScrool(true);
      paramBundle.setOnInterceptTouchEventListener(this.qsr);
      paramBundle.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean ccr()
        {
          AppMethodBeat.i(179605);
          View localView = ExdeviceProfileUI.z(ExdeviceProfileUI.this).getChildAt(ExdeviceProfileUI.z(ExdeviceProfileUI.this).getChildCount() - 1);
          int i = ExdeviceProfileUI.z(ExdeviceProfileUI.this).getAdapter().getCount();
          if ((i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceProfileUI.z(ExdeviceProfileUI.this).getHeight()) && (ExdeviceProfileUI.z(ExdeviceProfileUI.this).getLastVisiblePosition() >= i - 1))
          {
            AppMethodBeat.o(179605);
            return true;
          }
          AppMethodBeat.o(179605);
          return false;
        }
      });
      paramBundle.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean ccq()
        {
          AppMethodBeat.i(179606);
          if (ExdeviceProfileUI.z(ExdeviceProfileUI.this).getFirstVisiblePosition() == 0)
          {
            View localView = ExdeviceProfileUI.z(ExdeviceProfileUI.this).getChildAt(ExdeviceProfileUI.z(ExdeviceProfileUI.this).getFirstVisiblePosition());
            if ((localView != null) && (localView.getTop() >= 0))
            {
              AppMethodBeat.o(179606);
              return true;
            }
          }
          AppMethodBeat.o(179606);
          return false;
        }
      });
      paramBundle.setOnBottomLoadDataListener(new MMPullDownView.e()
      {
        public final boolean ccp()
        {
          return true;
        }
      });
      paramBundle.setOnScrollChangedListener(new MMPullDownView.b()
      {
        public final void cnI()
        {
          AppMethodBeat.i(179607);
          ExdeviceProfileUI.A(ExdeviceProfileUI.this);
          AppMethodBeat.o(179607);
        }
      });
      localObject1 = new ExdeviceProfileListHeader(this);
      m = com.tencent.mm.plugin.exdevice.k.b.B(this, getResources().getDimensionPixelSize(2131165316));
      localObject2 = getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject2).widthPixels <= ((DisplayMetrics)localObject2).heightPixels) {
        break label972;
      }
    }
    label972:
    for (int i = getResources().getDimensionPixelSize(2131165251);; i = getResources().getDimensionPixelSize(2131165252))
    {
      int j = getResources().getDimensionPixelSize(2131165326);
      int k = getResources().getDimensionPixelSize(2131165325);
      localObject2 = getWindowManager().getDefaultDisplay();
      k = ((Display)localObject2).getHeight() / 2 - m - i - j / 2 - k;
      if (((Display)localObject2).getHeight() > 0)
      {
        j = k;
        if (k > 0) {}
      }
      else
      {
        j = getResources().getDimensionPixelSize(2131165310);
      }
      ((ExdeviceProfileListHeader)localObject1).setMinimumHeight(j);
      ((ExdeviceProfileListHeader)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceProfileListHeader)localObject1).setTag(Integer.valueOf(((Display)localObject2).getHeight() / 2 - m - i));
      this.qrS = ((ExdeviceProfileListHeader)localObject1);
      this.qrR.addHeaderView(this.qrS, null, false);
      this.qrV = new a(getContext(), this.mAppName, this.qrq, this.lJm);
      this.qrV.qrp = this;
      this.qrR.setAdapter(this.qrV);
      this.qrR.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(179608);
          ExdeviceProfileUI.A(ExdeviceProfileUI.this);
          AppMethodBeat.o(179608);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.qrP.setUsername(this.lJm);
      this.qrW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24104);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceProfileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24104);
        }
      });
      paramBundle.setCanOverScrool(false);
      paramBundle = new RelativeLayout.LayoutParams(com.tencent.mm.cb.a.iu(this), ((Integer)this.qrS.getTag()).intValue());
      this.qrQ.setLayoutParams(paramBundle);
      cnD();
      ad.cmS().a(this);
      bc.ajj().a(new com.tencent.mm.plugin.exdevice.g.a.i(this.lJm, bu.nullAsNil(this.mAppName), this.qsf), 0);
      try
      {
        this.gIk = getResources().getDimensionPixelSize(2131165335);
        if (this.gIk <= 0) {
          this.gIk = 60;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", paramBundle, "", new Object[0]);
          if (this.gIk <= 0) {
            this.gIk = 60;
          }
        }
      }
      finally
      {
        if (this.gIk > 0) {
          break label1031;
        }
        this.gIk = 60;
        AppMethodBeat.o(24133);
      }
      ae.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[] { Integer.valueOf(this.gIk) });
      if (!this.qrq) {
        break label1039;
      }
      paramBundle = getString(2131758580);
      setMMTitle(paramBundle);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(179626);
          ExdeviceProfileUI.this.finish();
          AppMethodBeat.o(179626);
          return false;
        }
      });
      ae.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.lJm);
      if (v.aAC().equals(this.lJm))
      {
        paramBundle = new vp();
        paramBundle.dKS.action = 3;
        com.tencent.mm.sdk.b.a.IvT.a(paramBundle, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(179609);
            com.tencent.e.h.MqF.aO(paramAnonymousRunnable);
            AppMethodBeat.o(179609);
          }
        });
      }
      if (this.qrq)
      {
        if (this.qsg != null) {
          com.tencent.mm.kernel.g.ajj().a(this.qsg);
        }
        this.qsg = new com.tencent.mm.plugin.sport.model.d();
        com.tencent.mm.kernel.g.ajj().a(1734, this);
        com.tencent.mm.kernel.g.ajj().a(this.qsg, 0);
      }
      AppMethodBeat.o(24133);
      return;
      bool = false;
      break;
    }
    label1031:
    label1039:
    paramBundle = this.lJm;
    i = this.gIk;
    Object localObject1 = w.zP(paramBundle);
    if ((paramBundle.equalsIgnoreCase((String)localObject1)) && (!bu.isNullOrNil(this.qrL))) {}
    for (paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), this.qrL);; paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)localObject1))
    {
      localObject1 = TextUtils.ellipsize(paramBundle, this.ayp, i, TextUtils.TruncateAt.END);
      ae.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[] { Integer.valueOf(i), paramBundle, localObject1 });
      paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(this, getString(2131758584, new Object[] { localObject1 }));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24139);
    com.tencent.mm.kernel.g.ajj().b(1734, this);
    if (this.qsp != null) {
      bc.ajj().a(this.qsp);
    }
    this.qsq.dead();
    this.mIsDestroyed = true;
    super.onDestroy();
    ad.cmS().b(this);
    AppMethodBeat.o(24139);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24136);
    super.onPause();
    AppMethodBeat.o(24136);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24137);
    super.onResume();
    ae.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
    cnA();
    cnB();
    if (!this.qrq)
    {
      ad.cmL().adu(this.lJm);
      cnC();
    }
    AppMethodBeat.o(24137);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(161359);
    ae.i("MicroMsg.Sport.ExdeviceProfileUI", "onSceneEnd errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.equals(this.qsg))
    {
      com.tencent.mm.kernel.g.ajj().b(1734, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.qsg.AYv;
        Collections.sort(paramString.GWT, new Comparator() {});
        ae.i("MicroMsg.Sport.ExdeviceProfileUI", "response.Steps %d", new Object[] { Integer.valueOf(paramString.GWT.size()) });
        this.qsb = new ArrayList();
        paramString = paramString.GWT.iterator();
        while (paramString.hasNext())
        {
          paramn = (djl)paramString.next();
          com.tencent.mm.plugin.sport.a.d locald = new com.tencent.mm.plugin.sport.a.d();
          locald.a(paramn);
          this.qsb.add(locald);
        }
        cnH();
      }
    }
    AppMethodBeat.o(161359);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(186475);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(186475);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(186474);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(186474);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(186473);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(186473);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(24131);
      if (Math.abs(paramFloat2) < Math.abs(paramFloat1))
      {
        AppMethodBeat.o(24131);
        return true;
      }
      AppMethodBeat.o(24131);
      return false;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(186472);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(186472);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */