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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.plugin.sport.ui.SportChartView.a;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.bit;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.eiz;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
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
  private static int qlF = 0;
  private TextPaint ayp;
  private int gFD;
  private GestureDetector iKD;
  private String lEN;
  private String llg;
  private String mAppName;
  private Context mContext;
  private boolean mIsDestroyed;
  private String qeO;
  private boolean qfa;
  private List<String> qfq;
  private List<String> qfr;
  private p qjb;
  private boolean qkL;
  private boolean qkM;
  private int qkN;
  private List<rc> qkQ;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.i> qlA;
  private com.tencent.mm.plugin.sport.model.d qlB;
  private n.e qlC;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.h> qlD;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.g> qlE;
  private Runnable qlG;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.g> qlH;
  private List<String> qlI;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.k> qlJ;
  private com.tencent.mm.plugin.exdevice.g.a.k qlK;
  private com.tencent.mm.sdk.b.c<ok> qlL;
  private MMPullDownView.a qlM;
  private String qlg;
  private com.tencent.mm.plugin.exdevice.g.b.a.a qlh;
  private ArrayList<String> qli;
  private eiz qlj;
  private ExdeviceProfileAffectedUserView qlk;
  private ImageView qll;
  private ListView qlm;
  private ExdeviceProfileListHeader qln;
  private MMSwitchBtn qlo;
  private SportChartView qlp;
  private a qlq;
  private View qlr;
  private volatile boolean qls;
  private String qlt;
  private String qlu;
  private List<com.tencent.mm.plugin.sport.a.d> qlv;
  private List<com.tencent.mm.plugin.sport.a.d> qlw;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> qlx;
  private List<atc> qly;
  private int qlz;
  
  public ExdeviceProfileUI()
  {
    AppMethodBeat.i(24132);
    this.mIsDestroyed = false;
    this.qjb = null;
    this.qlA = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.ayp = new TextPaint(1);
    this.gFD = 0;
    this.qlC = new n.e()
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
          com.tencent.mm.plugin.sport.a.c.ma(27);
          ExdeviceProfileUI.r(ExdeviceProfileUI.this);
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.plugin.sport.a.c.ma(26);
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
              ba.aBQ();
              paramAnonymous2DialogInterface = com.tencent.mm.model.c.azp().Bf(ExdeviceProfileUI.u(ExdeviceProfileUI.this));
              com.tencent.mm.plugin.sport.a.c.ma(37);
              w.k(paramAnonymous2DialogInterface);
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
          com.tencent.mm.plugin.sport.a.c.ma(10);
          com.tencent.mm.plugin.exdevice.model.ad.clB();
          com.tencent.mm.plugin.exdevice.g.b.c.c("", ExdeviceProfileUI.w(ExdeviceProfileUI.this), ExdeviceProfileUI.u(ExdeviceProfileUI.this), 3);
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.plugin.sport.a.c.ma(41);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", ExdeviceProfileUI.o(ExdeviceProfileUI.this));
          com.tencent.mm.bs.d.b(ExdeviceProfileUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
        }
      }
    };
    this.qlD = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.qlE = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.qlG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179611);
        Object localObject1 = ExdeviceProfileUI.z(ExdeviceProfileUI.this);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$22", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$22", "run", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        if (ExdeviceProfileUI.z(ExdeviceProfileUI.this).getCount() > 0) {
          BackwardSupportUtil.c.b(ExdeviceProfileUI.z(ExdeviceProfileUI.this), ExdeviceProfileUI.z(ExdeviceProfileUI.this).getCount() - 1);
        }
        AppMethodBeat.o(179611);
      }
    };
    this.qlH = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.qlJ = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.qlL = new com.tencent.mm.sdk.b.c() {};
    this.qlM = new MMPullDownView.a()
    {
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179622);
        GestureDetector localGestureDetector = ExdeviceProfileUI.G(ExdeviceProfileUI.this);
        paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramAnonymousMotionEvent.ahp(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$32", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.mq(0)), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$32", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(179622);
        return bool;
      }
    };
    AppMethodBeat.o(24132);
  }
  
  private void cmk()
  {
    AppMethodBeat.i(24134);
    this.qlx = com.tencent.mm.plugin.exdevice.model.ad.clv().clH();
    if (this.qlx != null) {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", new Object[] { Integer.valueOf(this.qlx.size()), this.qlx.toString() });
    }
    while (!bt.hj(this.qlx))
    {
      this.qkN = this.qlx.size();
      AppMethodBeat.o(24134);
      return;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
    }
    this.qkN = 0;
    AppMethodBeat.o(24134);
  }
  
  private void cml()
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
        locala.qkM = com.tencent.mm.plugin.exdevice.model.ad.clv().acD(locala.lEN);
        locala.qkP = localArrayList;
        if (!bt.hj(localArrayList)) {}
        for (locala.qkN = localArrayList.size();; locala.qkN = 0)
        {
          locala.qkQ = localList;
          if (!bt.hj(localList)) {
            locala.qkO = localList.size();
          }
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", new Object[] { Boolean.valueOf(locala.qkM), Integer.valueOf(locala.qkN), Integer.valueOf(locala.qkO), locala.lEN });
          ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
          AppMethodBeat.o(179625);
          return;
        }
      }
    });
    AppMethodBeat.o(24135);
  }
  
  private void cmm()
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
  
  private void cmn()
  {
    AppMethodBeat.i(24140);
    String str = u.aAm();
    if (this.qlr != null) {
      this.qlr.setVisibility(8);
    }
    if ((!bt.isNullOrNil(str)) && (str.equals(this.lEN)))
    {
      if ((this.qlh != null) && (bt.isNullOrNil(this.qlh.field_championUrl)) && (this.qlr != null)) {
        this.qlr.setVisibility(0);
      }
      if (this.qln != null)
      {
        this.qln.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(24107);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.plugin.sport.a.c.ma(18);
            com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceProfileUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(24107);
          }
        });
        AppMethodBeat.o(24140);
      }
    }
    else if ((this.qlh != null) && (!bt.isNullOrNil(this.qlh.field_championUrl)) && (this.qln != null))
    {
      this.qln.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179610);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ExdeviceProfileUI.B(ExdeviceProfileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179610);
        }
      });
    }
    AppMethodBeat.o(24140);
  }
  
  private void cmo()
  {
    AppMethodBeat.i(24141);
    if (this.qlh != null)
    {
      if ((this.llg != this.qlh.field_championUrl) && ((this.llg == null) || (!this.llg.equals(this.qlh.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.qll, this.qlh.field_championUrl);
        this.llg = this.qlh.field_championUrl;
        AppMethodBeat.o(24141);
      }
    }
    else
    {
      this.qll.setImageResource(2131100204);
      this.llg = null;
    }
    AppMethodBeat.o(24141);
  }
  
  private void cmr()
  {
    AppMethodBeat.i(161358);
    if (this.qlp == null) {
      this.qlp = ((SportChartView)findViewById(2131299585));
    }
    if (this.qlp == null)
    {
      AppMethodBeat.o(161358);
      return;
    }
    if (this.qlo == null) {
      this.qlo = ((MMSwitchBtn)findViewById(2131299587));
    }
    HashSet localHashSet = new HashSet();
    final ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    com.tencent.mm.plugin.sport.a.d locald;
    if (this.qlv != null)
    {
      localIterator = this.qlv.iterator();
      while (localIterator.hasNext())
      {
        locald = (com.tencent.mm.plugin.sport.a.d)localIterator.next();
        if (localHashSet.add(locald.field_date)) {
          localArrayList.add(locald);
        }
      }
    }
    if (this.qlw != null)
    {
      localIterator = this.qlw.iterator();
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
      if (this.qkL)
      {
        this.qlp.setHasSwitchBtn(true);
        this.qlo.setVisibility(0);
        this.qlo.setSwitchListener(new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(179621);
            if (paramAnonymousBoolean) {
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).a(SportChartView.a.AHE);
            }
            for (;;)
            {
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).gj(localArrayList);
              AppMethodBeat.o(179621);
              return;
              ExdeviceProfileUI.F(ExdeviceProfileUI.this).a(SportChartView.a.AHD);
            }
          }
        });
      }
      for (;;)
      {
        this.qlp.setTodayStep(((com.tencent.mm.plugin.sport.a.d)localArrayList.get(localArrayList.size() - 1)).field_step);
        this.qlp.gj(localArrayList);
        AppMethodBeat.o(161358);
        return;
        this.qlp.setHasSwitchBtn(false);
        this.qlo.setVisibility(8);
        this.qlo.setSwitchListener(null);
        this.qlp.a(SportChartView.a.AHD);
        this.qlp.gj(localArrayList);
      }
    }
    this.qlp.setHasSwitchBtn(false);
    this.qlo.setVisibility(8);
    this.qlp.gj(null);
    AppMethodBeat.o(161358);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.g.b.d paramd)
  {
    AppMethodBeat.i(24143);
    if (("HardDeviceChampionInfo".equals(paramString)) && (this.lEN.equals(paramd.username)))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
      this.qlh = com.tencent.mm.plugin.exdevice.model.ad.clx().acF(this.lEN);
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
  
  public final void cmp()
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
    if (this.qlK != null) {
      ba.aiU().a(this.qlK);
    }
    this.qlK = new com.tencent.mm.plugin.exdevice.g.a.k(this.qlJ);
    ba.aiU().a(this.qlK, 0);
    AppMethodBeat.o(24144);
  }
  
  public final void cmq()
  {
    AppMethodBeat.i(24145);
    com.tencent.mm.plugin.sport.a.c.ma(17);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.lEN);
    ba.aiU().a(new com.tencent.mm.plugin.exdevice.g.a.g(localArrayList, this.qlE), 0);
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
            str2 = ac.eD(this);
            if ((str1 != null) && (str1.length() != 0)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
            AppMethodBeat.o(24142);
            return;
          }
          ac.a(this, str1, str2, paramIntent.getStringExtra("custom_send_text"), this.qlu);
          com.tencent.mm.ui.base.h.cl(getContext(), getResources().getString(2131755894));
          AppMethodBeat.o(24142);
          return;
          if (paramInt2 == -1)
          {
            paramIntent = bt.U(paramIntent.getStringExtra("Select_Contact").split(","));
            if (paramIntent == null)
            {
              AppMethodBeat.o(24142);
              return;
            }
            if (this.qjb != null) {
              this.qjb.show();
            }
            ba.aiU().a(new com.tencent.mm.plugin.exdevice.g.a.g(paramIntent, this.qlH), 0);
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
    cmk();
    this.lEN = paramBundle.getStringExtra("username");
    this.qlg = paramBundle.getStringExtra("usernickname");
    paramBundle = u.aAm();
    if (paramBundle != null) {
      this.qkL = paramBundle.equals(this.lEN);
    }
    this.mAppName = getIntent().getStringExtra("app_username");
    this.qkM = com.tencent.mm.plugin.exdevice.model.ad.clv().acD(this.lEN);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[] { Boolean.valueOf(this.qkM) });
    boolean bool;
    int m;
    Object localObject2;
    if (!bt.isNullOrNil(this.lEN))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.qlh = com.tencent.mm.plugin.exdevice.model.ad.clx().acF(this.lEN);
      this.qli = getIntent().getStringArrayListExtra("key_affected_semi");
      getString(2131755906);
      this.qjb = com.tencent.mm.ui.base.h.c(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
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
      this.qlk = ((ExdeviceProfileAffectedUserView)findViewById(2131299542));
      this.qll = ((ImageView)findViewById(2131299545));
      this.qlm = ((ListView)findViewById(2131299581));
      paramBundle = (MMPullDownView)findViewById(2131303543);
      this.qlk.setAffectedUserInfo(this.qli);
      cmo();
      this.qlr = findViewById(2131304599);
      this.iKD = new GestureDetector(getContext(), new a((byte)0));
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setTopViewVisible(false);
      paramBundle.setBottomViewVisible(false);
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setIsTopShowAll(false);
      paramBundle.setCanOverScrool(true);
      paramBundle.setOnInterceptTouchEventListener(this.qlM);
      paramBundle.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean cbc()
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
        public final boolean cbb()
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
        public final boolean cba()
        {
          return true;
        }
      });
      paramBundle.setOnScrollChangedListener(new MMPullDownView.b()
      {
        public final void cms()
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
      this.qln = ((ExdeviceProfileListHeader)localObject1);
      this.qlm.addHeaderView(this.qln, null, false);
      this.qlq = new a(getContext(), this.mAppName, this.qkL, this.lEN);
      this.qlq.qkK = this;
      this.qlm.setAdapter(this.qlq);
      this.qlm.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(179608);
          ExdeviceProfileUI.A(ExdeviceProfileUI.this);
          AppMethodBeat.o(179608);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.qlk.setUsername(this.lEN);
      this.qlr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(24104);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceProfileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24104);
        }
      });
      paramBundle.setCanOverScrool(false);
      paramBundle = new RelativeLayout.LayoutParams(com.tencent.mm.cc.a.ip(this), ((Integer)this.qln.getTag()).intValue());
      this.qll.setLayoutParams(paramBundle);
      cmn();
      com.tencent.mm.plugin.exdevice.model.ad.clC().a(this);
      ba.aiU().a(new com.tencent.mm.plugin.exdevice.g.a.i(this.lEN, bt.nullAsNil(this.mAppName), this.qlA), 0);
      try
      {
        this.gFD = getResources().getDimensionPixelSize(2131165335);
        if (this.gFD <= 0) {
          this.gFD = 60;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", paramBundle, "", new Object[0]);
          if (this.gFD <= 0) {
            this.gFD = 60;
          }
        }
      }
      finally
      {
        if (this.gFD > 0) {
          break label1031;
        }
        this.gFD = 60;
        AppMethodBeat.o(24133);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[] { Integer.valueOf(this.gFD) });
      if (!this.qkL) {
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.lEN);
      if (u.aAm().equals(this.lEN))
      {
        paramBundle = new vl();
        paramBundle.dJE.action = 3;
        com.tencent.mm.sdk.b.a.IbL.a(paramBundle, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(179609);
            com.tencent.e.h.LTJ.aR(paramAnonymousRunnable);
            AppMethodBeat.o(179609);
          }
        });
      }
      if (this.qkL)
      {
        if (this.qlB != null) {
          com.tencent.mm.kernel.g.aiU().a(this.qlB);
        }
        this.qlB = new com.tencent.mm.plugin.sport.model.d();
        com.tencent.mm.kernel.g.aiU().a(1734, this);
        com.tencent.mm.kernel.g.aiU().a(this.qlB, 0);
      }
      AppMethodBeat.o(24133);
      return;
      bool = false;
      break;
    }
    label1031:
    label1039:
    paramBundle = this.lEN;
    i = this.gFD;
    Object localObject1 = v.zf(paramBundle);
    if ((paramBundle.equalsIgnoreCase((String)localObject1)) && (!bt.isNullOrNil(this.qlg))) {}
    for (paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), this.qlg);; paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)localObject1))
    {
      localObject1 = TextUtils.ellipsize(paramBundle, this.ayp, i, TextUtils.TruncateAt.END);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[] { Integer.valueOf(i), paramBundle, localObject1 });
      paramBundle = com.tencent.mm.pluginsdk.ui.span.k.c(this, getString(2131758584, new Object[] { localObject1 }));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24139);
    com.tencent.mm.kernel.g.aiU().b(1734, this);
    if (this.qlK != null) {
      ba.aiU().a(this.qlK);
    }
    this.qlL.dead();
    this.mIsDestroyed = true;
    super.onDestroy();
    com.tencent.mm.plugin.exdevice.model.ad.clC().b(this);
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
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
    cmk();
    cml();
    if (!this.qkL)
    {
      com.tencent.mm.plugin.exdevice.model.ad.clv().acD(this.lEN);
      cmm();
    }
    AppMethodBeat.o(24137);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(161359);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceProfileUI", "onSceneEnd errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.equals(this.qlB))
    {
      com.tencent.mm.kernel.g.aiU().b(1734, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.qlB.AGS;
        Collections.sort(paramString.GDq, new Comparator() {});
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sport.ExdeviceProfileUI", "response.Steps %d", new Object[] { Integer.valueOf(paramString.GDq.size()) });
        this.qlw = new ArrayList();
        paramString = paramString.GDq.iterator();
        while (paramString.hasNext())
        {
          paramn = (diq)paramString.next();
          com.tencent.mm.plugin.sport.a.d locald = new com.tencent.mm.plugin.sport.a.d();
          locald.a(paramn);
          this.qlw.add(locald);
        }
        cmr();
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
      AppMethodBeat.i(193215);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(193215);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(193214);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(193214);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(193213);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(193213);
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
      AppMethodBeat.i(193212);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileUI$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(193212);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */