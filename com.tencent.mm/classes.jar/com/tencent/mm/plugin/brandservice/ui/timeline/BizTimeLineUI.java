package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.w;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.a;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.pluginsdk.model.a.h;
import com.tencent.mm.pluginsdk.model.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cuq;
import com.tencent.mm.protocal.protobuf.cur;
import com.tencent.mm.protocal.protobuf.cus;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aa.3;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.aa.c;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.y.b;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.aq;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@com.tencent.mm.kernel.i
public class BizTimeLineUI
  extends MMActivity
  implements g, com.tencent.mm.plugin.webcanvas.g, ScreenShotUtil.ScreenShotCallback
{
  private static String psS = null;
  private static int psT = 0;
  private static int psU = 0;
  private int dEb;
  private boolean dLD;
  private TextView emptyTipTv;
  private int gsi;
  private View kgo;
  private int mScrollState;
  private long ofm;
  private f pqZ;
  private BizTimeLineHotView prb;
  public StoryListView psJ;
  private View psK;
  private ImageView psL;
  private LinearLayout psM;
  private TextView psN;
  private TextView psO;
  private View psP;
  private b psQ;
  private d psR;
  private com.tencent.mm.plugin.brandservice.ui.timeline.a.b psV;
  private long psW;
  private boolean psX;
  private boolean psY;
  private boolean psZ;
  private View psf;
  private long pss;
  private int pta;
  private int ptb;
  private int ptc;
  private boolean ptd;
  private HashSet<String> pte;
  private final Set<com.tencent.mm.plugin.webcanvas.h> ptf;
  private final Set<com.tencent.mm.plugin.webcanvas.f> ptg;
  private aa.c pth;
  private IListener pti;
  private int ptj;
  private final int ptk;
  private long ptl;
  private final long ptm;
  private boolean ptn;
  private boolean pto;
  private IListener ptp;
  private com.tencent.mm.pluginsdk.ui.span.i ptq;
  private int source;
  
  public BizTimeLineUI()
  {
    AppMethodBeat.i(5965);
    this.pss = 0L;
    this.psW = 0L;
    this.ofm = 0L;
    this.source = 1;
    this.psX = false;
    this.psY = false;
    this.psZ = false;
    this.dLD = false;
    this.pta = 0;
    this.ptb = -1;
    this.ptc = -1;
    this.mScrollState = 0;
    this.ptd = false;
    this.pte = new HashSet();
    this.ptf = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ptg = Collections.newSetFromMap(new ConcurrentHashMap());
    this.pth = new aa.c()
    {
      public final void a(Object paramAnonymousObject, aa.a paramAnonymousa)
      {
        AppMethodBeat.i(5955);
        BizTimeLineUI.this.cmA();
        AppMethodBeat.o(5955);
      }
    };
    this.pti = new IListener() {};
    this.ptj = 0;
    this.ptk = 20;
    this.ptl = 0L;
    this.ptm = 100L;
    this.ptn = false;
    this.pto = false;
    this.ptp = new BizTimeLineUI.11(this);
    this.ptq = new BizTimeLineUI.13(this);
    AppMethodBeat.o(5965);
  }
  
  private void cmB()
  {
    int j = 0;
    AppMethodBeat.i(194950);
    if ((this.psJ == null) || (this.psQ == null))
    {
      AppMethodBeat.o(194950);
      return;
    }
    int i = this.psJ.getFirstVisiblePosition();
    int m = this.psJ.getLastVisiblePosition();
    fd(i, m);
    if (i > 0) {
      i -= 1;
    }
    for (;;)
    {
      int k = i;
      if (m > 0)
      {
        j = m - 1;
        k = i;
      }
      while (k <= j)
      {
        z localz = this.psQ.De(k);
        if (localz != null)
        {
          this.psQ.ahO(localz.field_talker);
          this.pqZ.e(localz);
        }
        k += 1;
      }
      i = 0;
    }
    AppMethodBeat.o(194950);
  }
  
  private static int cmG()
  {
    if (psU > 0) {
      return psU - 1;
    }
    return 0;
  }
  
  private void ds(View paramView)
  {
    AppMethodBeat.i(5982);
    paramView = paramView.getTag(2131297446);
    if ((paramView instanceof String)) {
      this.pte.add((String)paramView);
    }
    AppMethodBeat.o(5982);
  }
  
  private void fd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5983);
    if ((paramInt1 == 0) && (!this.psY) && (psU != paramInt1)) {
      this.prb.cnm();
    }
    this.psV.a(paramInt1, paramInt2, this.psJ, this.pqZ);
    AppMethodBeat.o(5983);
  }
  
  private void g(final z paramz, final int paramInt)
  {
    AppMethodBeat.i(194949);
    if ((this.psJ == null) || (isFinishing()))
    {
      AppMethodBeat.o(194949);
      return;
    }
    com.tencent.mm.pluginsdk.ui.tools.p.a(this.psJ, paramInt, psT, false);
    if (this.psJ.getFirstVisiblePosition() == paramInt)
    {
      i(paramz);
      Log.i("MicroMsg.BizTimeLineUI", "tryToScrollToPosition success tryScrollTimes: %d", new Object[] { Integer.valueOf(this.ptj) });
      AppMethodBeat.o(194949);
      return;
    }
    this.psJ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5964);
        if ((BizTimeLineUI.k(BizTimeLineUI.this) > 20) || (BizTimeLineUI.l(BizTimeLineUI.this)) || (BizTimeLineUI.m(BizTimeLineUI.this) != 0))
        {
          BizTimeLineUI.a(BizTimeLineUI.this, paramz);
          Log.i("MicroMsg.BizTimeLineUI", "tryToScrollToPosition fail userTouched: %b state: %d tryScrollTimes: %d", new Object[] { Boolean.valueOf(BizTimeLineUI.l(BizTimeLineUI.this)), Integer.valueOf(BizTimeLineUI.m(BizTimeLineUI.this)), Integer.valueOf(BizTimeLineUI.n(BizTimeLineUI.this)) });
          AppMethodBeat.o(5964);
          return;
        }
        BizTimeLineUI.a(BizTimeLineUI.this, paramz, paramInt);
        AppMethodBeat.o(5964);
      }
    }, 10L);
    AppMethodBeat.o(194949);
  }
  
  private void i(z paramz)
  {
    AppMethodBeat.i(5971);
    this.psQ.prf = false;
    this.psY = false;
    int i = Math.max(0, this.psJ.getFirstVisiblePosition() - this.psJ.getHeaderViewsCount());
    this.psQ.d(paramz);
    this.psQ.d(this.psQ.De(i));
    cmB();
    Log.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(5971);
  }
  
  public final void a(com.tencent.mm.plugin.webcanvas.f paramf)
  {
    AppMethodBeat.i(194955);
    if (!this.ptg.contains(this.ptg)) {
      this.ptg.add(paramf);
    }
    AppMethodBeat.o(194955);
  }
  
  public final void a(com.tencent.mm.plugin.webcanvas.h paramh)
  {
    AppMethodBeat.i(194953);
    if (!this.ptf.contains(paramh)) {
      this.ptf.add(paramh);
    }
    AppMethodBeat.o(194953);
  }
  
  public final void b(com.tencent.mm.plugin.webcanvas.h paramh)
  {
    AppMethodBeat.i(194954);
    this.ptf.remove(paramh);
    AppMethodBeat.o(194954);
  }
  
  public final void cmA()
  {
    AppMethodBeat.i(5968);
    if (isFinishing())
    {
      AppMethodBeat.o(5968);
      return;
    }
    int i = com.tencent.mm.al.ag.bap().ctM();
    if (i > 0)
    {
      this.psM.setVisibility(0);
      this.psN.setText(getString(2131756777, new Object[] { Integer.valueOf(i) }));
      z localz = com.tencent.mm.al.ag.bap().gBn();
      Object localObject;
      if (localz != null)
      {
        this.psL.setVisibility(0);
        if (localz.gAw())
        {
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localz.field_talker);
          if ((localObject != null) && (com.tencent.mm.contact.c.oR(((ax)localObject).field_type))) {
            break label315;
          }
          if (localz.gAB() != null)
          {
            localObject = new c.a();
            ((c.a)localObject).jbq = 2131231957;
            ((c.a)localObject).jbe = true;
            com.tencent.mm.av.q.bcV().a(localz.gAB().iAR, this.psL, ((c.a)localObject).bdv());
          }
          com.tencent.mm.storage.ab.Nc(localz.field_msgId);
        }
      }
      for (;;)
      {
        if ((this.psQ != null) && (this.psQ.getCount() == 0)) {
          this.psQ.notifyDataSetChanged();
        }
        AppMethodBeat.o(5968);
        return;
        if (localz.gAx())
        {
          localObject = com.tencent.mm.storage.ag.I(localz);
          if (Util.isNullOrNil((String)localObject)) {
            a.b.c(this.psL, localz.field_talker);
          }
          for (;;)
          {
            i = com.tencent.mm.storage.ag.f(localz);
            this.pqZ.l(i, (String)localObject, 0);
            break;
            if (com.tencent.mm.model.ab.IT((String)localObject)) {
              a.b.d(this.psL, (String)localObject);
            } else {
              a.b.c(this.psL, (String)localObject);
            }
          }
        }
        if (com.tencent.mm.model.ab.IT(localz.field_talker))
        {
          a.b.d(this.psL, localz.field_talker);
          break;
        }
        label315:
        a.b.c(this.psL, localz.field_talker);
        break;
        this.psL.setVisibility(8);
      }
    }
    this.psM.setVisibility(8);
    AppMethodBeat.o(5968);
  }
  
  public final void cmC()
  {
    AppMethodBeat.i(5975);
    final long l1 = System.currentTimeMillis() - this.ptl;
    if ((this.ptn) && (l1 < 200L))
    {
      Log.d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
      AppMethodBeat.o(5975);
      return;
    }
    Log.d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.ptn), Long.valueOf(l1) });
    this.ptn = true;
    if (l1 < 100L)
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5951);
          BizTimeLineUI.q(BizTimeLineUI.this);
          if (!BizTimeLineUI.this.isFinishing())
          {
            BizTimeLineUI.this.cmC();
            AppMethodBeat.o(5951);
            return;
          }
          Log.w("MicroMsg.BizTimeLineUI", "Activity is finished!!!");
          AppMethodBeat.o(5951);
        }
      }, 100L);
      AppMethodBeat.o(5975);
      return;
    }
    if ((this.psQ == null) || (this.dLD)) {}
    for (;;)
    {
      this.ptl = System.currentTimeMillis();
      this.ptn = false;
      AppMethodBeat.o(5975);
      return;
      if (this.psQ.nZr.size() > 0)
      {
        l1 = ((z)this.psQ.nZr.get(0)).field_orderFlag;
        if ((this.psY) || (this.psJ == null) || (this.psJ.getFirstVisiblePosition() != 0))
        {
          int j = com.tencent.mm.al.ag.ban().MR(l1);
          int i = j;
          if (j > 0)
          {
            long l2 = com.tencent.mm.al.ag.ban().gAS();
            i = j;
            if (com.tencent.mm.al.ag.ban().MZ(l2 << 32) != null) {
              i = j - 1;
            }
          }
          Log.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            setMMTitleVisibility(8);
            if (this.psK.getVisibility() == 8) {
              this.psK.setVisibility(4);
            }
            this.psO.setText(getString(2131756783, new Object[] { Integer.valueOf(i) }));
            this.psK.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(5952);
                if (com.tencent.mm.al.ag.ban().MR(l1) <= 0)
                {
                  BizTimeLineUI.this.setMMTitleVisibility(0);
                  AppMethodBeat.o(5952);
                  return;
                }
                float f1 = BizTimeLineUI.r(BizTimeLineUI.this).getX();
                int i = (int)((BizTimeLineUI.r(BizTimeLineUI.this).getWidth() + (f1 + f1)) / 2.0F);
                int j = com.tencent.mm.cb.a.jn(BizTimeLineUI.this.getContext()) / 2;
                if (i != j)
                {
                  float f2 = j - i + f1;
                  BizTimeLineUI.r(BizTimeLineUI.this).setX(f2);
                  Log.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView x = %f, new x=%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
                }
                if (BizTimeLineUI.r(BizTimeLineUI.this).getVisibility() != 0) {
                  BizTimeLineUI.r(BizTimeLineUI.this).setVisibility(0);
                }
                AppMethodBeat.o(5952);
              }
            });
            continue;
          }
        }
        this.psK.setVisibility(8);
        setMMTitleVisibility(0);
      }
    }
  }
  
  public final void cmD()
  {
    AppMethodBeat.i(5977);
    Log.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
    cmC();
    AppMethodBeat.o(5977);
  }
  
  public final StoryListView cmE()
  {
    return this.psJ;
  }
  
  public final boolean cmF()
  {
    AppMethodBeat.i(194952);
    if ((this.prb.getVisibility() == 0) || (this.psM.getVisibility() == 0))
    {
      AppMethodBeat.o(194952);
      return true;
    }
    AppMethodBeat.o(194952);
    return false;
  }
  
  public final void cms()
  {
    AppMethodBeat.i(5974);
    if ((!isFinishing()) && (this.psf != null))
    {
      ((View)$(2131297562)).setVisibility(8);
      ((View)$(2131297571)).setVisibility(0);
      Object localObject = (TextView)$(2131297570);
      ImageView localImageView = (ImageView)$(2131297569);
      b.a locala = b.prG;
      if (b.a.cmx())
      {
        ((TextView)localObject).setVisibility(8);
        localImageView.setVisibility(0);
        localObject = com.tencent.mm.model.o.iBV;
        com.tencent.mm.model.o.Aa(15L);
        AppMethodBeat.o(5974);
        return;
      }
      ((TextView)localObject).setVisibility(0);
      localImageView.setVisibility(8);
      ((TextView)localObject).setText(getString(2131756774));
    }
    AppMethodBeat.o(5974);
  }
  
  public final void cmt()
  {
    AppMethodBeat.i(194951);
    if ((!isFinishing()) && (this.psf != null))
    {
      ((View)$(2131297562)).setVisibility(0);
      ((View)$(2131297571)).setVisibility(8);
    }
    AppMethodBeat.o(194951);
  }
  
  public final void cmy()
  {
    AppMethodBeat.i(5978);
    if (this.psQ != null) {
      this.psQ.notifyDataSetChanged();
    }
    AppMethodBeat.o(5978);
  }
  
  public int getLayoutId()
  {
    return 2131493251;
  }
  
  public final void j(z paramz)
  {
    AppMethodBeat.i(194956);
    this.pqZ.a(paramz, 0, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(194956);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(194958);
    super.onConfigurationChanged(paramConfiguration);
    Iterator localIterator = this.ptf.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.webcanvas.h)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
    if (this.prb != null) {
      this.prb.onConfigurationChanged(paramConfiguration);
    }
    paramConfiguration = this.psV;
    paramConfiguration.mEY = com.tencent.mm.cb.a.jo(paramConfiguration.context);
    AppMethodBeat.o(194958);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5966);
    com.tencent.mm.storage.ab.AK(true);
    com.tencent.mm.plugin.brandservice.b.b.init();
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(2131300096));
    this.emptyTipTv.setText(2131756747);
    this.psR = new d(this);
    paramBundle = this.psR;
    EventCenter.instance.addListener(paramBundle.lEl);
    this.dEb = ((int)(System.currentTimeMillis() / 1000L));
    this.source = getIntent().getIntExtra("biz_enter_source", 1);
    this.pss = System.currentTimeMillis();
    this.pqZ = new f(this.dEb, this.pss);
    this.psV = new com.tencent.mm.plugin.brandservice.ui.timeline.a.b(this, this.pqZ);
    com.tencent.mm.storage.ab.DU(this.dEb);
    paramBundle = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.pLS;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.DU(this.dEb);
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194937);
        if ((BizTimeLineUI.this.activityHasDestroyed()) || (BizTimeLineUI.this.isFinishing()))
        {
          AppMethodBeat.o(194937);
          return;
        }
        BizTimeLineUI.p(BizTimeLineUI.this);
        AppMethodBeat.o(194937);
      }
    });
    paramBundle = com.tencent.mm.plugin.bizui.a.a.pfC;
    boolean bool1 = com.tencent.mm.plugin.bizui.a.a.ckz();
    boolean bool2 = ((com.tencent.mm.api.q)com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class)).Vu();
    Log.i("MicroMsg.BizTimeLineUI", "open search entrance:%b, isBizTeenModeAllowAll: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2)) {
      addIconOptionMenu(0, 2131766796, 2131689496, new BizTimeLineUI.2(this));
    }
    addIconOptionMenu(1, 2131756784, 2131689507, new MenuItem.OnMenuItemClickListener()new BizTimeLineUI.4
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(5946);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.addFlags(67108864);
        paramAnonymousMenuItem.putExtra("biz_from_scene", 2);
        paramAnonymousMenuItem.putExtra("biz_time_line_line_session_id", BizTimeLineUI.b(BizTimeLineUI.this));
        paramAnonymousMenuItem.putExtra("biz_enter_source", BizTimeLineUI.j(BizTimeLineUI.this));
        com.tencent.mm.br.c.f(BizTimeLineUI.this, ".ui.conversation.NewBizConversationUI", paramAnonymousMenuItem);
        BizTimeLineUI.a(BizTimeLineUI.this).Dg(7);
        BizTimeLineUI.o(BizTimeLineUI.this);
        AppMethodBeat.o(5946);
        return true;
      }
    }, new BizTimeLineUI.4(this));
    setMMTitle(2131756790);
    setMMTitleColor(getContext().getResources().getColor(2131099746));
    setBackBtn(new BizTimeLineUI.6(this), 2131689492);
    this.psK = getLayoutInflater().inflate(2131493250, null);
    this.psO = ((TextView)this.psK.findViewById(2131297587));
    this.psO.setTextSize(1, 14.0F);
    this.psP = this.psK.findViewById(2131297586);
    paramBundle = getController().mActionBar.getCustomView();
    if ((paramBundle instanceof LinearLayout))
    {
      ((LinearLayout)paramBundle).addView(this.psK);
      paramBundle = (LinearLayout.LayoutParams)this.psK.getLayoutParams();
      paramBundle.width = -1;
      paramBundle.weight = 1.0F;
      paramBundle.gravity = 16;
      this.psK.setLayoutParams(paramBundle);
    }
    for (;;)
    {
      this.psP.setOnClickListener(new BizTimeLineUI.7(this));
      this.psK.setVisibility(8);
      this.psJ = ((StoryListView)$(2131297565));
      paramBundle = this.psJ;
      this.psf = getLayoutInflater().inflate(2131493253, null);
      paramBundle.addFooterView(this.psf);
      paramBundle = this.psJ;
      this.kgo = getLayoutInflater().inflate(2131493254, null);
      this.prb = ((BizTimeLineHotView)this.kgo.findViewById(2131297539));
      paramBundle.addHeaderView(this.kgo);
      final int i = psU;
      final int j = getIntent().getIntExtra("Main_UnreadCount", 0);
      this.psY = com.tencent.mm.storage.ab.gBb();
      this.psZ = com.tencent.mm.storage.ab.bD(j, this.psY);
      if (!this.psZ) {
        break;
      }
      paramBundle = com.tencent.mm.al.ag.ban().MO(com.tencent.mm.storage.ab.NQU);
      com.tencent.mm.plugin.brandservice.ui.b.c.cM(paramBundle);
      Log.i("MicroMsg.BizTimeLineUI", "initListView keepPos %b, keepData %b", new Object[] { Boolean.valueOf(this.psY), Boolean.valueOf(this.psZ) });
      this.psQ = new b(this, paramBundle, this.psY, this.psZ, this.pqZ, this.prb);
      this.pqZ.psq = cmG();
      this.psM = ((LinearLayout)$(2131305362));
      this.psN = ((TextView)$(2131305363));
      this.psL = ((ImageView)$(2131305361));
      cmA();
      this.psM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(5944);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = "";
          localObject = com.tencent.mm.al.ag.bap().gBn();
          if (localObject != null) {
            paramAnonymousView = com.tencent.mm.storage.ag.I((z)localObject);
          }
          for (int i = com.tencent.mm.storage.ag.f((z)localObject);; i = 0)
          {
            localObject = BizTimeLineUI.a(BizTimeLineUI.this);
            com.tencent.mm.plugin.report.service.h.CyF.a(15721, new Object[] { paramAnonymousView, "", Integer.valueOf(12), Integer.valueOf(-1), Integer.valueOf(((f)localObject).dEb), "", "", "", Integer.valueOf(0), "", "", "", "", "", "", "", "", "", Integer.valueOf(i) });
            BizTimeLineUI.a(BizTimeLineUI.this).l(i, paramAnonymousView, 1);
            localObject = new Intent(BizTimeLineUI.this.getContext(), BizTimeLineNewMsgUI.class);
            ((Intent)localObject).putExtra("biz_time_line_line_session_id", BizTimeLineUI.b(BizTimeLineUI.this));
            ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 1);
            paramAnonymousView = BizTimeLineUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(5944);
            return;
          }
        }
      });
      this.psJ.setAdapter(this.psQ);
      this.psJ.setFooterDividersEnabled(false);
      this.psJ.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(194946);
          paramAnonymousAbsListView = BizTimeLineUI.e(BizTimeLineUI.this).iterator();
          while (paramAnonymousAbsListView.hasNext()) {
            ((com.tencent.mm.plugin.webcanvas.h)paramAnonymousAbsListView.next()).cmV();
          }
          BizTimeLineUI.a(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt2 - 1);
          paramAnonymousAbsListView = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
          if (com.tencent.mm.pluginsdk.ui.applet.g.aig(1)) {
            BizTimeLineUI.b(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt2 - 1);
          }
          BizTimeLineUI.Dh(paramAnonymousInt1);
          paramAnonymousAbsListView = BizTimeLineUI.a(BizTimeLineUI.this);
          paramAnonymousInt1 = BizTimeLineUI.bhW();
          if (paramAnonymousAbsListView.psw != null)
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousAbsListView.psw.psH != paramAnonymousInt1))
            {
              f.a locala = paramAnonymousAbsListView.psw;
              locala.psE += 1;
            }
            paramAnonymousAbsListView.psw.psH = paramAnonymousInt1;
          }
          AppMethodBeat.o(194946);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(194945);
          BizTimeLineUI.a(BizTimeLineUI.this, paramAnonymousInt);
          boolean bool;
          int j;
          int k;
          int m;
          if (paramAnonymousInt == 2)
          {
            paramAnonymousAbsListView = BizTimeLineUI.this;
            bool = WXHardCoderJNI.hcBizEnable;
            j = WXHardCoderJNI.hcBizDelay;
            k = WXHardCoderJNI.hcBizCPU;
            m = WXHardCoderJNI.hcBizIO;
            if (!WXHardCoderJNI.hcBizThr) {
              break label147;
            }
          }
          label147:
          for (int i = Process.myTid();; i = 0)
          {
            BizTimeLineUI.b(paramAnonymousAbsListView, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcBizTimeout, 903, WXHardCoderJNI.hcBizAction, "MicroMsg.BizTimeLineUI"));
            Log.i("MicroMsg.BizTimeLineUI", "summer hardcoder biz startPerformance [%s] [%s]", new Object[] { Integer.valueOf(903), Integer.valueOf(BizTimeLineUI.d(BizTimeLineUI.this)) });
            paramAnonymousAbsListView = BizTimeLineUI.e(BizTimeLineUI.this).iterator();
            while (paramAnonymousAbsListView.hasNext()) {
              paramAnonymousAbsListView.next();
            }
          }
          com.tencent.mm.plugin.brandservice.ui.b.a.crg();
          com.tencent.mm.av.q.bcV().onScrollStateChanged(paramAnonymousInt);
          if ((paramAnonymousInt == 0) || (paramAnonymousInt == 1))
          {
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.a.JUl;
            if (com.tencent.mm.pluginsdk.model.a.JUj) {
              com.tencent.mm.pluginsdk.model.a.v((Runnable)new a.h(System.currentTimeMillis()));
            }
          }
          for (;;)
          {
            if (paramAnonymousInt == 0)
            {
              BizTimeLineUI.c(BizTimeLineUI.this).fc(BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.f(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.f(BizTimeLineUI.this).getLastVisiblePosition());
              MPVideoPreviewMgr.pJz.a("idle", BizTimeLineUI.f(BizTimeLineUI.this), BizTimeLineUI.c(BizTimeLineUI.this));
            }
            AppMethodBeat.o(194945);
            return;
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.a.JUl;
            if (!com.tencent.mm.pluginsdk.model.a.JUj) {
              com.tencent.mm.pluginsdk.model.a.v((Runnable)new a.l(System.currentTimeMillis()));
            }
          }
        }
      });
      this.psJ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(194947);
          BizTimeLineUI.g(BizTimeLineUI.this);
          AppMethodBeat.o(194947);
          return false;
        }
      });
      this.psJ.setEmptyView(this.emptyTipTv);
      this.psJ.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5961);
          if (BizTimeLineUI.h(BizTimeLineUI.this)) {
            if (i != 0)
            {
              BizTimeLineUI.i(BizTimeLineUI.this);
              BizTimeLineUI.this.cmC();
            }
          }
          for (;;)
          {
            if (!Util.isNullOrNil(paramBundle))
            {
              long l = ((z)paramBundle.get(0)).field_orderFlag;
              com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new f.3(BizTimeLineUI.a(BizTimeLineUI.this), l, BizTimeLineUI.j(BizTimeLineUI.this), BizTimeLineUI.this.getIntent().getIntExtra("Main_IndexInSessionList", 0)), 0L);
            }
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(194948);
                MPVideoPreviewMgr.pJz.a("init", BizTimeLineUI.f(BizTimeLineUI.this), BizTimeLineUI.c(BizTimeLineUI.this));
                AppMethodBeat.o(194948);
              }
            }, 100L);
            AppMethodBeat.o(5961);
            return;
            BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.c(BizTimeLineUI.this).De(0));
            continue;
            BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition(), BizTimeLineUI.f(BizTimeLineUI.this).getLastVisiblePosition());
          }
        }
      }, 10L);
      this.psJ.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(5962);
          BizTimeLineUI.c(BizTimeLineUI.this).fc(BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.f(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.f(BizTimeLineUI.this).getLastVisiblePosition());
          BizTimeLineUI.f(BizTimeLineUI.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(5962);
        }
      });
      com.tencent.mm.al.ag.bap().a(this.pth, Looper.getMainLooper());
      new c();
      Log.d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
      i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OgK, Integer.valueOf(0))).intValue();
      if ((i & 0x4) == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkb("officialaccounts");
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgK, Integer.valueOf(i | 0x4));
      }
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(5963);
          Looper.myQueue().removeIdleHandler(this);
          z localz;
          if (BizTimeLineUI.c(BizTimeLineUI.this) != null)
          {
            localz = BizTimeLineUI.c(BizTimeLineUI.this).cmp();
            if (localz == null) {
              break label61;
            }
            com.tencent.mm.al.ag.ban().MV(localz.field_orderFlag);
          }
          for (;;)
          {
            AppMethodBeat.o(5963);
            return false;
            localz = null;
            break;
            label61:
            com.tencent.mm.al.ag.ban().gAQ();
          }
        }
      });
      com.tencent.mm.pluginsdk.h.r(this);
      EventCenter.instance.addListener(this.ptp);
      this.pti.alive();
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CS(90);
      }
      paramBundle = com.tencent.mm.al.ag.ban();
      if (paramBundle.NQv)
      {
        paramBundle.NQv = false;
        com.tencent.f.h.RTc.a(new aa.3(paramBundle), 1000L, "BizTimeLineInfoStorageThread");
      }
      com.tencent.mm.plugin.brandservice.ui.b.a.cre();
      com.tencent.mm.pluginsdk.ui.applet.g.gpi();
      paramBundle = y.NPP;
      y.a(y.b.NPU);
      com.tencent.mm.api.b.Uu();
      com.tencent.mm.plugin.brandservice.b.b.clr();
      m.IAG.fWO();
      paramBundle = com.tencent.mm.plugin.webcanvas.l.IAx;
      com.tencent.mm.plugin.webcanvas.l.LV(65L);
      AppMethodBeat.o(5966);
      return;
      if ((paramBundle instanceof RelativeLayout))
      {
        ((RelativeLayout)paramBundle).addView(this.psK);
        paramBundle = (RelativeLayout.LayoutParams)this.psK.getLayoutParams();
        paramBundle.width = -1;
        paramBundle.addRule(15);
        this.psK.setLayoutParams(paramBundle);
      }
    }
    long l;
    Object localObject;
    if (com.tencent.mm.storage.ab.gBd())
    {
      paramBundle = com.tencent.mm.al.ag.ban();
      int k = Math.min(com.tencent.mm.model.p.aTH(), 10);
      l = paramBundle.gAS();
      paramBundle = paramBundle.iFy;
      localObject = "orderFlag DESC limit ".concat(String.valueOf(k));
    }
    for (paramBundle = com.tencent.mm.storage.aa.o(paramBundle.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(l << 32) }, null, null, (String)localObject));; paramBundle = com.tencent.mm.al.ag.ban().ajT(10))
    {
      localObject = new LinkedList();
      ((List)localObject).addAll(paramBundle);
      com.tencent.mm.plugin.brandservice.ui.b.c.cP((List)localObject);
      com.tencent.mm.plugin.brandservice.ui.b.c.a((List)localObject, null);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5979);
    super.onDestroy();
    Log.i("MicroMsg.BizTimeLineUI", "onDestroy %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.prb != null)
    {
      localObject1 = this.prb;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().remove((MStorageEx.IOnStorageChange)localObject1);
      EventCenter.instance.removeListener(((BizTimeLineHotView)localObject1).pzx);
      localObject3 = ((BizTimeLineHotView)localObject1).pyZ;
      Object localObject4 = new d.a();
      cuq localcuq = new cuq();
      ((d.a)localObject4).iLN = localcuq;
      ((d.a)localObject4).iLO = new cur();
      ((d.a)localObject4).uri = "/cgi-bin/micromsg-bin/often_read_bar_report";
      ((d.a)localObject4).funcId = 2550;
      localObject4 = ((d.a)localObject4).aXF();
      localcuq.KRg = com.tencent.mm.storage.ab.getSessionId();
      localcuq.MzY = ((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g)localObject3).pzT;
      LinkedList localLinkedList = new LinkedList();
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g)localObject3).pzS.size() > 0)
      {
        Iterator localIterator = ((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g)localObject3).pzS.entrySet().iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add((cus)((Map.Entry)localIterator.next()).getValue());
        }
      }
      localcuq.MzX = localLinkedList;
      localcuq.source = 0;
      com.tencent.mm.ak.aa.a((com.tencent.mm.ak.d)localObject4, new g.1((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g)localObject3));
      com.tencent.mm.kernel.g.azz().b(2768, (com.tencent.mm.ak.i)localObject1);
      ((BizTimeLineHotView)localObject1).pzr.setAdapter(null);
      ((BizTimeLineHotView)localObject1).pzr.pzf.dead();
    }
    Object localObject1 = this.psR;
    EventCenter.instance.removeListener(((d)localObject1).lEl);
    com.tencent.mm.storage.ab.AK(false);
    com.tencent.mm.storage.ab.NQT = System.currentTimeMillis();
    if ((this.psQ != null) && (this.psJ != null))
    {
      localObject1 = this.psQ.cmo();
      if (localObject1 == null) {
        break label758;
      }
      com.tencent.mm.storage.ab.NQU = ((z)localObject1).field_orderFlag;
    }
    for (;;)
    {
      localObject1 = this.psQ.De(cmG());
      if (localObject1 != null)
      {
        psS = ((z)localObject1).getId();
        localObject1 = this.psQ;
        com.tencent.mm.al.ag.ban().a(((b)localObject1).pmx);
        ((b)localObject1).prc.pAy.clear();
        localObject3 = com.tencent.mm.model.p.iCa;
        localObject1 = ((b)localObject1).pqW;
        kotlin.g.b.p.h(localObject1, "list");
        kotlin.g.b.p.h(localObject1, "<set-?>");
        com.tencent.mm.model.p.al((List)localObject1);
        com.tencent.mm.al.ag.bap().a(this.pth);
        if (this.pss != 0L)
        {
          l = System.currentTimeMillis();
          this.ofm += l - this.psW;
          com.tencent.mm.plugin.report.service.h.CyF.a(13932, new Object[] { Integer.valueOf((int)(l - this.pss) / 1000), Integer.valueOf(1), Integer.valueOf(this.dEb), Integer.valueOf((int)(this.ofm / 1000L)), Integer.valueOf(this.source) });
        }
        EventCenter.instance.removeListener(this.ptp);
        this.pti.dead();
        this.pqZ.psr = cmG();
        localObject1 = this.pqZ;
        com.tencent.f.h.RTc.b(new f.2((f)localObject1), "BizTimeLineExpose");
        if (((f)localObject1).psw != null) {
          com.tencent.mm.plugin.report.service.h.CyF.a(21136, new Object[] { Integer.valueOf(((f)localObject1).psw.psE), Integer.valueOf(((f)localObject1).psw.psF), Integer.valueOf(((f)localObject1).psw.msgType), Integer.valueOf(((f)localObject1).psw.dEb), ((f)localObject1).psw.dVu, Integer.valueOf(((f)localObject1).psw.psG) });
        }
        com.tencent.mm.plugin.brandservice.ui.b.b.clean();
        aq.clear();
        com.tencent.mm.storage.ab.DU(0);
      }
      try
      {
        if ((getContentView() instanceof ViewGroup)) {
          ((ViewGroup)getContentView()).removeAllViews();
        }
        localObject1 = com.tencent.mm.pluginsdk.model.a.JUl;
        com.tencent.mm.pluginsdk.model.a.gmj();
        com.tencent.mm.plugin.brandservice.b.b.release();
        localObject1 = this.ptg.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            ((com.tencent.mm.plugin.webcanvas.f)((Iterator)localObject1).next()).onDestroy();
            continue;
            label758:
            com.tencent.mm.storage.ab.NQU = com.tencent.mm.al.ag.ban().gAo() << 32;
            break;
            Log.w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", new Object[] { Integer.valueOf(cmG()) });
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.w("MicroMsg.BizTimeLineUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
        }
        this.ptf.clear();
        this.ptg.clear();
        localObject2 = MPVideoPreviewMgr.pJz;
        if (!MPVideoPreviewMgr.pJj) {
          break label1036;
        }
      }
    }
    Object localObject2 = MPVideoPreviewMgr.pJq;
    Object localObject3 = MPVideoPreviewMgr.pJm;
    if (localObject3 != null)
    {
      localObject3 = (AppBrandVideoView)((WeakReference)localObject3).get();
      if (localObject3 == null) {}
    }
    for (long l = ((AppBrandVideoView)localObject3).getCurrPosMs();; l = 0L)
    {
      ((MPVideoPreviewMgr.a)localObject2).pJH = l;
      MPVideoPreviewMgr.pJq.pl(4);
      localObject2 = MPVideoPreviewMgr.pJq;
      ((MPVideoPreviewMgr.a)localObject2).pJA = null;
      ((MPVideoPreviewMgr.a)localObject2).d(null);
      ((MPVideoPreviewMgr.a)localObject2).aiO("IDLE");
      ((MPVideoPreviewMgr.a)localObject2).akb = 0;
      ((MPVideoPreviewMgr.a)localObject2).pJE.clear();
      ((MPVideoPreviewMgr.a)localObject2).setVideoDuration(0);
      ((MPVideoPreviewMgr.a)localObject2).pJH = 0L;
      ((MPVideoPreviewMgr.a)localObject2).pJI = 0L;
      ((MPVideoPreviewMgr.a)localObject2).pJJ = 0L;
      ((MPVideoPreviewMgr.a)localObject2).pJK = 0L;
      ((MPVideoPreviewMgr.a)localObject2).pJL = 0L;
      ((MPVideoPreviewMgr.a)localObject2).pJD = "";
      localObject2 = MPVideoPreviewMgr.pJm;
      if (localObject2 != null)
      {
        localObject2 = (AppBrandVideoView)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          ((AppBrandVideoView)localObject2).onUIDestroy();
        }
      }
      MPVideoPreviewMgr.pJs = "";
      MPVideoPreviewMgr.pJu = null;
      MPVideoPreviewMgr.pJk = null;
      MPVideoPreviewMgr.pJl = null;
      MPVideoPreviewMgr.pJm = null;
      MPVideoPreviewMgr.pJn = null;
      MPVideoPreviewMgr.pJo = null;
      MPVideoPreviewMgr.pJw.clear();
      MPVideoPreviewMgr.stopTimer();
      MPVideoPreviewMgr.pJp = null;
      MPVideoPreviewMgr.pJx.clear();
      label1036:
      AppMethodBeat.o(5979);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5981);
    super.onPause();
    if (this.psQ != null)
    {
      localObject = this.psQ;
      ((b)localObject).dLD = true;
      ((b)localObject).prc.pAB = true;
    }
    for (Object localObject = this.psQ.cmp();; localObject = null)
    {
      int i;
      if (localObject != null)
      {
        com.tencent.mm.al.ag.ban().MV(((z)localObject).field_orderFlag);
        if (this.psJ == null) {
          break label225;
        }
        localObject = this.psJ.getChildAt(0);
        if (localObject == null) {
          break label220;
        }
        i = ((View)localObject).getTop();
      }
      label91:
      label220:
      label225:
      for (psT = i;; psT = 0)
      {
        this.dLD = true;
        long l = System.currentTimeMillis();
        this.ofm += l - this.psW;
        this.psW = l;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBizEnable, this.gsi);
        this.gsi = 0;
        com.tencent.mm.pluginsdk.ui.span.l.b(this.ptq);
        localObject = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
        if (com.tencent.mm.pluginsdk.ui.applet.g.aig(1))
        {
          localObject = com.tencent.mm.pluginsdk.model.a.JUl;
          com.tencent.mm.pluginsdk.model.a.gmk();
        }
        ScreenShotUtil.setScreenShotCallback(this, null);
        localObject = this.ptg.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.webcanvas.f)((Iterator)localObject).next()).onPause();
        }
        com.tencent.mm.al.ag.ban().gAQ();
        break;
        i = 0;
        break label91;
      }
      localObject = MPVideoPreviewMgr.pJz;
      MPVideoPreviewMgr.aiI("ONPAUSE");
      AppMethodBeat.o(5981);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5980);
    super.onResume();
    if (this.psX)
    {
      this.psX = false;
      this.pqZ.Dg(8);
    }
    Object localObject;
    if (this.psQ != null)
    {
      localObject = this.psQ;
      ((b)localObject).dLD = false;
      localObject = ((b)localObject).prc;
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject).pAB)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject).pAB = false;
        if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject).pAv <= 0) {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject).cnz();
        }
      }
    }
    if (this.dLD)
    {
      this.dLD = false;
      cmC();
    }
    this.psW = System.currentTimeMillis();
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194944);
        if ((BizTimeLineUI.this.isFinishing()) || (BizTimeLineUI.f(BizTimeLineUI.this) == null) || (BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition() != 0) || (BizTimeLineUI.u(BizTimeLineUI.this) == null))
        {
          AppMethodBeat.o(194944);
          return;
        }
        BizTimeLineUI.u(BizTimeLineUI.this).cnm();
        AppMethodBeat.o(194944);
      }
    }, 500L);
    com.tencent.mm.pluginsdk.ui.span.l.a(this.ptq);
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, this);
      localObject = this.ptg.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.webcanvas.f)((Iterator)localObject).next()).onResume();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.BizTimeLineUI", "setScreenShotCallback fail e:%s", new Object[] { localException.getMessage() });
      }
      MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
      MPVideoPreviewMgr.aiI("ONRESUME");
      AppMethodBeat.o(5980);
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(194957);
    paramString = this.ptf.iterator();
    while (paramString.hasNext()) {
      ((com.tencent.mm.plugin.webcanvas.h)paramString.next()).cmW();
    }
    AppMethodBeat.o(194957);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI
 * JD-Core Version:    0.7.0.1
 */