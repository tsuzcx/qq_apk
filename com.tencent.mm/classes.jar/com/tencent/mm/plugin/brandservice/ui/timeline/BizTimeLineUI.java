package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.q;
import com.tencent.mm.al.x;
import com.tencent.mm.am.af;
import com.tencent.mm.aw.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.1;
import com.tencent.mm.pluginsdk.model.a.h;
import com.tencent.mm.pluginsdk.model.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.t.3;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.storage.t.c;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@com.tencent.mm.kernel.i
public class BizTimeLineUI
  extends MMActivity
  implements j
{
  private static long mXY = 0L;
  private static long mXZ = 0L;
  private static long mYa = 0L;
  private static int mYb = 0;
  private static int mYc = 0;
  private int dcS;
  private int dep;
  private boolean dkt;
  private TextView emptyTipTv;
  private int foV;
  private View imc;
  private long lKG;
  BizTimeLineHotView mWN;
  private boolean mWV;
  private h mWX;
  public StoryListView mXP;
  private View mXQ;
  private ImageView mXR;
  LinearLayout mXS;
  private TextView mXT;
  private TextView mXU;
  private View mXV;
  private c mXW;
  private f mXX;
  private View mXu;
  private long mYd;
  private long mYe;
  private boolean mYf;
  private int mYg;
  private int mYh;
  private int mYi;
  private HashSet<String> mYj;
  private t.c mYk;
  private com.tencent.mm.sdk.b.c mYl;
  private long mYm;
  private final long mYn;
  private boolean mYo;
  private List<s> mYp;
  private boolean mYq;
  private com.tencent.mm.sdk.b.c mYr;
  private com.tencent.mm.pluginsdk.ui.span.h mYs;
  private int mmC;
  
  public BizTimeLineUI()
  {
    AppMethodBeat.i(5965);
    this.mYd = 0L;
    this.mYe = 0L;
    this.lKG = 0L;
    this.dep = 1;
    this.mYf = false;
    this.mWV = false;
    this.dkt = false;
    this.mYg = 0;
    this.mYh = -1;
    this.mYi = -1;
    this.mYj = new HashSet();
    this.mYk = new t.c()
    {
      public final void a(Object paramAnonymousObject, t.a paramAnonymousa)
      {
        AppMethodBeat.i(5955);
        BizTimeLineUI.this.bCN();
        AppMethodBeat.o(5955);
      }
    };
    this.mYl = new BizTimeLineUI.13(this);
    this.mYm = 0L;
    this.mYn = 100L;
    this.mYo = false;
    this.mYp = new LinkedList();
    this.mYq = false;
    this.mmC = -1;
    this.mYr = new BizTimeLineUI.9(this);
    this.mYs = new BizTimeLineUI.10(this);
    AppMethodBeat.o(5965);
  }
  
  private void bCQ()
  {
    AppMethodBeat.i(5976);
    if ((this.mXW == null) || (this.dkt))
    {
      AppMethodBeat.o(5976);
      return;
    }
    if (this.mXW.lEL.size() > 0)
    {
      final long l1 = ((s)this.mXW.lEL.get(0)).field_orderFlag;
      int j = af.awk().vZ(l1);
      int i = j;
      if (j > 0)
      {
        long l2 = af.awk().eJX();
        i = j;
        if (af.awk().we(l2 << 32) != null) {
          i = j - 1;
        }
      }
      ad.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        setMMTitleVisibility(8);
        if (this.mXQ.getVisibility() == 8) {
          this.mXQ.setVisibility(4);
        }
        this.mXU.setText(getString(2131756635, new Object[] { Integer.valueOf(i) }));
        this.mXQ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5950);
            if (af.awk().vZ(l1) <= 0)
            {
              BizTimeLineUI.this.setMMTitleVisibility(0);
              AppMethodBeat.o(5950);
              return;
            }
            float f1 = BizTimeLineUI.n(BizTimeLineUI.this).getX();
            int i = (int)((BizTimeLineUI.n(BizTimeLineUI.this).getWidth() + (f1 + f1)) / 2.0F);
            int j = com.tencent.mm.cd.a.hV(BizTimeLineUI.this.getContext()) / 2;
            if (i != j)
            {
              float f2 = j - i + f1;
              BizTimeLineUI.n(BizTimeLineUI.this).setX(f2);
              ad.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView x = %f, new x=%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
            }
            if (BizTimeLineUI.n(BizTimeLineUI.this).getVisibility() != 0) {
              BizTimeLineUI.n(BizTimeLineUI.this).setVisibility(0);
            }
            AppMethodBeat.o(5950);
          }
        });
        AppMethodBeat.o(5976);
      }
    }
    else
    {
      AppMethodBeat.o(5976);
      return;
    }
    this.mXQ.setVisibility(8);
    setMMTitleVisibility(0);
    AppMethodBeat.o(5976);
  }
  
  private static int bCS()
  {
    if (mYc > 0) {
      return mYc - 1;
    }
    return 0;
  }
  
  private static void cl(List<s> paramList)
  {
    AppMethodBeat.i(5984);
    if (!bt.gL(paramList))
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((s)localIterator.next()).field_isRead = 1;
      }
      localLinkedList.addAll(paramList);
      af.awk().gQ(localLinkedList);
    }
    AppMethodBeat.o(5984);
  }
  
  private void d(final s params)
  {
    AppMethodBeat.i(5971);
    this.mXP.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192983);
        BizTimeLineUI.c(BizTimeLineUI.this).mWV = false;
        BizTimeLineUI.i(BizTimeLineUI.this);
        int i = Math.max(0, BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.d(BizTimeLineUI.this).getHeaderViewsCount());
        BizTimeLineUI.c(BizTimeLineUI.this).b(params);
        BizTimeLineUI.c(BizTimeLineUI.this).b(BizTimeLineUI.c(BizTimeLineUI.this).xP(i));
        BizTimeLineUI.j(BizTimeLineUI.this);
        ad.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(192983);
      }
    }, 50L);
    AppMethodBeat.o(5971);
  }
  
  private void dx(View paramView)
  {
    AppMethodBeat.i(5982);
    paramView = paramView.getTag(2131297288);
    if ((paramView instanceof String)) {
      this.mYj.add((String)paramView);
    }
    AppMethodBeat.o(5982);
  }
  
  private void eI(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(5983);
    if ((paramInt1 == 0) && (!this.mWV) && (mYc != paramInt1)) {
      this.mWN.bDc();
    }
    if ((this.mWV) || (this.mYq) || ((mYc == paramInt1) && (this.mmC == paramInt2)))
    {
      AppMethodBeat.o(5983);
      return;
    }
    this.mmC = paramInt2;
    if (paramInt1 > 0) {
      paramInt1 -= 1;
    }
    LinkedList localLinkedList;
    for (;;)
    {
      if (paramInt2 > 0) {
        i = paramInt2 - 1;
      }
      localLinkedList = new LinkedList();
      while (paramInt1 <= i)
      {
        s locals = this.mXW.xP(paramInt1);
        if ((locals != null) && (locals.field_isRead != 1)) {
          localLinkedList.add(locals);
        }
        paramInt1 += 1;
      }
      paramInt1 = 0;
    }
    this.mYp.removeAll(localLinkedList);
    cl(this.mYp);
    this.mYp.clear();
    this.mYp.addAll(localLinkedList);
    AppMethodBeat.o(5983);
  }
  
  public final void bCM()
  {
    AppMethodBeat.i(5978);
    if (this.mXW != null) {
      this.mXW.notifyDataSetChanged();
    }
    AppMethodBeat.o(5978);
  }
  
  public final void bCN()
  {
    AppMethodBeat.i(5968);
    if (isFinishing())
    {
      AppMethodBeat.o(5968);
      return;
    }
    int i = af.awl().bIR();
    if (i > 0)
    {
      this.mXS.setVisibility(0);
      this.mXT.setText(getString(2131756629, new Object[] { Integer.valueOf(i) }));
      s locals = af.awl().eKl();
      if (locals != null)
      {
        this.mXR.setVisibility(0);
        if (locals.eJP())
        {
          this.mXR.setImageResource(2131231274);
          u.wh(locals.field_msgId);
        }
      }
      for (;;)
      {
        if ((this.mXW != null) && (this.mXW.getCount() == 0)) {
          this.mXW.notifyDataSetChanged();
        }
        AppMethodBeat.o(5968);
        return;
        a.b.c(this.mXR, locals.field_talker);
        break;
        this.mXR.setVisibility(8);
      }
    }
    this.mXS.setVisibility(8);
    AppMethodBeat.o(5968);
  }
  
  public final void bCO()
  {
    AppMethodBeat.i(5974);
    if ((!isFinishing()) && (this.mXu != null))
    {
      ((View)$(2131297351)).setVisibility(8);
      ((View)$(2131297359)).setVisibility(0);
      ((TextView)$(2131297358)).setText(getString(2131756626));
    }
    AppMethodBeat.o(5974);
  }
  
  public final void bCP()
  {
    AppMethodBeat.i(5975);
    long l = System.currentTimeMillis() - this.mYm;
    if ((this.mYo) && (l < 200L))
    {
      ad.d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
      AppMethodBeat.o(5975);
      return;
    }
    ad.d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.mYo), Long.valueOf(l) });
    this.mYo = true;
    if (l < 100L)
    {
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(192973);
          BizTimeLineUI.m(BizTimeLineUI.this);
          if (!BizTimeLineUI.this.isFinishing())
          {
            BizTimeLineUI.this.bCP();
            AppMethodBeat.o(192973);
            return;
          }
          ad.w("MicroMsg.BizTimeLineUI", "Activity is finished!!!");
          AppMethodBeat.o(192973);
        }
      }, 100L);
      AppMethodBeat.o(5975);
      return;
    }
    bCQ();
    this.mYm = System.currentTimeMillis();
    this.mYo = false;
    AppMethodBeat.o(5975);
  }
  
  public final void bCR()
  {
    AppMethodBeat.i(5977);
    ad.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
    bCP();
    AppMethodBeat.o(5977);
  }
  
  public int getLayoutId()
  {
    return 2131493203;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5966);
    u.uZ(true);
    com.tencent.mm.plugin.brandservice.b.c.init();
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(2131299468));
    this.emptyTipTv.setText(2131756606);
    this.mXX = new f(this);
    paramBundle = this.mXX;
    com.tencent.mm.sdk.b.a.ESL.c(paramBundle.jBI);
    this.dcS = ((int)(System.currentTimeMillis() / 1000L));
    this.dep = getIntent().getIntExtra("biz_enter_source", 1);
    this.mWX = new h(this.dcS);
    u.SR(this.dcS);
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192970);
        if ((BizTimeLineUI.this.activityHasDestroyed()) || (BizTimeLineUI.this.isFinishing()))
        {
          AppMethodBeat.o(192970);
          return;
        }
        BizTimeLineUI.l(BizTimeLineUI.this);
        AppMethodBeat.o(192970);
      }
    });
    paramBundle = com.tencent.mm.model.c.d.aty().qu("100045");
    boolean bool;
    final int i;
    long l;
    int j;
    if ((paramBundle.isValid()) && ("1".equals(paramBundle.eJy().get("isOpenSearch"))))
    {
      bool = true;
      ad.d("MicroMsg.BizTimeLineUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        addIconOptionMenu(0, 2131764452, 2131689494, new BizTimeLineUI.19(this));
      }
      addIconOptionMenu(1, 2131756636, 2131689505, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(5945);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.addFlags(67108864);
          paramAnonymousMenuItem.putExtra("biz_from_scene", 2);
          paramAnonymousMenuItem.putExtra("biz_time_line_line_session_id", BizTimeLineUI.b(BizTimeLineUI.this));
          paramAnonymousMenuItem.putExtra("biz_enter_source", BizTimeLineUI.h(BizTimeLineUI.this));
          com.tencent.mm.bs.d.e(BizTimeLineUI.this, ".ui.conversation.NewBizConversationUI", paramAnonymousMenuItem);
          BizTimeLineUI.a(BizTimeLineUI.this).xR(7);
          BizTimeLineUI.k(BizTimeLineUI.this);
          AppMethodBeat.o(5945);
          return true;
        }
      });
      setMMTitle(2131756642);
      setMMTitleColor(com.tencent.mm.ui.ao.aD(getContext(), 2130968584));
      setBackBtn(new BizTimeLineUI.4(this), 2131689490);
      this.mXQ = getLayoutInflater().inflate(2131493202, null);
      this.mXU = ((TextView)this.mXQ.findViewById(2131297369));
      this.mXU.setTextSize(1, 14.0F);
      this.mXV = this.mXQ.findViewById(2131297368);
      ((LinearLayout)getController().mActionBar.getCustomView()).addView(this.mXQ);
      paramBundle = (LinearLayout.LayoutParams)this.mXQ.getLayoutParams();
      paramBundle.width = -1;
      paramBundle.weight = 1.0F;
      this.mXQ.setLayoutParams(paramBundle);
      this.mXV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(192972);
          BizTimeLineUI.l(BizTimeLineUI.this);
          AppMethodBeat.o(192972);
        }
      });
      this.mXQ.setVisibility(8);
      this.mXP = ((StoryListView)$(2131297354));
      paramBundle = this.mXP;
      this.mXu = getLayoutInflater().inflate(2131493205, null);
      paramBundle.addFooterView(this.mXu);
      paramBundle = this.mXP;
      this.imc = getLayoutInflater().inflate(2131493206, null);
      this.mWN = ((BizTimeLineHotView)this.imc.findViewById(2131297334));
      paramBundle.addHeaderView(this.imc);
      i = mYc;
      l = System.currentTimeMillis();
      j = com.tencent.mm.m.g.Zd().getInt("BizTimeLineStayTime", 180) * 1000;
      if ((mXY == 0L) || (mXZ == 0L) || (l - mXY >= j)) {
        break label1036;
      }
      paramBundle = af.awk().vW(mXZ);
      this.mWV = true;
      com.tencent.mm.plugin.brandservice.ui.b.c.cu(paramBundle);
    }
    for (;;)
    {
      ad.i("MicroMsg.BizTimeLineUI", "initListView stayTime %d %d/%d  orderFlag %d, keep %b", new Object[] { Integer.valueOf(j), Long.valueOf(mXY), Long.valueOf(l), Long.valueOf(mXZ), Boolean.valueOf(this.mWV) });
      this.mXW = new c(this, paramBundle, this.mWV, this.mWX, this.mWN);
      this.mWX.mXF = bCS();
      this.mXS = ((LinearLayout)$(2131302793));
      this.mXT = ((TextView)$(2131302794));
      this.mXR = ((ImageView)$(2131302792));
      bCN();
      this.mXS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(5944);
          BizTimeLineUI.a(BizTimeLineUI.this).xR(12);
          Object localObject = new Intent(BizTimeLineUI.this.getContext(), BizTimeLineNewMsgUI.class);
          ((Intent)localObject).putExtra("biz_time_line_line_session_id", BizTimeLineUI.b(BizTimeLineUI.this));
          ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 1);
          paramAnonymousView = BizTimeLineUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(5944);
        }
      });
      this.mXP.setAdapter(this.mXW);
      this.mXP.setFooterDividersEnabled(false);
      this.mXP.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(192979);
          BizTimeLineUI.a(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousAbsListView = com.tencent.mm.pluginsdk.ui.applet.g.BXQ;
          if (com.tencent.mm.pluginsdk.ui.applet.g.UJ(1)) {
            BizTimeLineUI.b(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt2 - 1);
          }
          BizTimeLineUI.xS(paramAnonymousInt1);
          AppMethodBeat.o(192979);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(192978);
          com.tencent.mm.plugin.brandservice.ui.b.a.bGv();
          o.ayJ().cq(paramAnonymousInt);
          boolean bool;
          int i;
          int j;
          int k;
          if ((paramAnonymousInt == 0) || (paramAnonymousInt == 1))
          {
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.a.BOa;
            if (com.tencent.mm.pluginsdk.model.a.BNY) {
              com.tencent.mm.pluginsdk.model.a.u((Runnable)new a.h(System.currentTimeMillis()));
            }
            if (paramAnonymousInt == 0) {
              BizTimeLineUI.c(BizTimeLineUI.this).eH(BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.d(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.d(BizTimeLineUI.this).getLastVisiblePosition());
            }
            if (paramAnonymousInt == 2)
            {
              paramAnonymousAbsListView = BizTimeLineUI.this;
              bool = WXHardCoderJNI.hcBizEnable;
              i = WXHardCoderJNI.hcBizDelay;
              j = WXHardCoderJNI.hcBizCPU;
              k = WXHardCoderJNI.hcBizIO;
              if (!WXHardCoderJNI.hcBizThr) {
                break label230;
              }
            }
          }
          label230:
          for (paramAnonymousInt = Process.myTid();; paramAnonymousInt = 0)
          {
            BizTimeLineUI.a(paramAnonymousAbsListView, WXHardCoderJNI.startPerformance(bool, i, j, k, paramAnonymousInt, WXHardCoderJNI.hcBizTimeout, 903, WXHardCoderJNI.hcBizAction, "MicroMsg.BizTimeLineUI"));
            ad.i("MicroMsg.BizTimeLineUI", "summer hardcoder biz startPerformance [%s] [%s]", new Object[] { Integer.valueOf(903), Integer.valueOf(BizTimeLineUI.e(BizTimeLineUI.this)) });
            AppMethodBeat.o(192978);
            return;
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.a.BOa;
            if (com.tencent.mm.pluginsdk.model.a.BNY) {
              break;
            }
            com.tencent.mm.pluginsdk.model.a.u((Runnable)new a.l(System.currentTimeMillis()));
            break;
          }
        }
      });
      this.mXP.setEmptyView(this.emptyTipTv);
      this.mXP.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(192980);
          if ((BizTimeLineUI.f(BizTimeLineUI.this)) && (i != 0))
          {
            BizTimeLineUI.g(BizTimeLineUI.this);
            BizTimeLineUI.this.bCP();
          }
          if ((BizTimeLineUI.f(BizTimeLineUI.this)) && (i == 0)) {
            BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.c(BizTimeLineUI.this).xP(0));
          }
          if (!bt.gL(paramBundle))
          {
            long l = ((s)paramBundle.get(0)).field_orderFlag;
            h localh = BizTimeLineUI.a(BizTimeLineUI.this);
            int i = BizTimeLineUI.h(BizTimeLineUI.this);
            int j = BizTimeLineUI.this.getIntent().getIntExtra("Main_IndexInSessionList", 0);
            com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new h.3(localh, l, BizTimeLineUI.this.getIntent().getIntExtra("Main_UnreadCount", 0), i, j), 0L);
          }
          AppMethodBeat.o(192980);
        }
      }, 120L);
      this.mXP.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(192981);
          BizTimeLineUI.c(BizTimeLineUI.this).eH(BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.d(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.d(BizTimeLineUI.this).getLastVisiblePosition());
          BizTimeLineUI.d(BizTimeLineUI.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(192981);
        }
      });
      if (paramBundle.size() < 10) {
        bCO();
      }
      af.awl().a(this.mYk, Looper.getMainLooper());
      new e();
      ad.d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
      i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Ftp, Integer.valueOf(0))).intValue();
      if ((i & 0x4) == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIq("officialaccounts");
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftp, Integer.valueOf(i | 0x4));
      }
      com.tencent.mm.pluginsdk.g.p(this);
      this.mYd = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.ESL.c(this.mYr);
      this.mYl.alive();
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(1)) {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xB(90);
      }
      paramBundle = af.awk();
      if (paramBundle.Few)
      {
        paramBundle.Few = false;
        com.tencent.e.h.Iye.a(new t.3(paramBundle), 1000L, "BizTimeLineInfoStorageThread");
      }
      com.tencent.mm.plugin.brandservice.ui.b.a.bGt();
      com.tencent.mm.pluginsdk.ui.applet.g.exS();
      com.tencent.mm.api.b.IU();
      com.tencent.mm.plugin.brandservice.b.c.bCd();
      AppMethodBeat.o(5966);
      return;
      bool = false;
      break;
      label1036:
      this.mWV = false;
      paramBundle = af.awk().Wp(10);
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(192982);
          Looper.myQueue().removeIdleHandler(this);
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.addAll(paramBundle);
          com.tencent.mm.plugin.brandservice.ui.b.c.a(localLinkedList, null);
          AppMethodBeat.o(192982);
          return false;
        }
      });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5979);
    super.onDestroy();
    if (this.mWN != null)
    {
      localObject1 = this.mWN;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().b((n.b)localObject1);
      com.tencent.mm.sdk.b.a.ESL.d(((BizTimeLineHotView)localObject1).nbG);
      com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f localf = ((BizTimeLineHotView)localObject1).nbw;
      Object localObject2 = new b.a();
      buh localbuh = new buh();
      ((b.a)localObject2).gUU = localbuh;
      ((b.a)localObject2).gUV = new bui();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/often_read_bar_report";
      ((b.a)localObject2).funcId = 2550;
      localObject2 = ((b.a)localObject2).atI();
      localbuh.CGZ = u.getSessionId();
      localbuh.DRE = localf.nbS;
      LinkedList localLinkedList = new LinkedList();
      if (localf.nbR.size() > 0)
      {
        Iterator localIterator = localf.nbR.entrySet().iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add((buj)((Map.Entry)localIterator.next()).getValue());
        }
      }
      localbuh.DRD = localLinkedList;
      x.a((com.tencent.mm.al.b)localObject2, new f.1(localf));
      com.tencent.mm.kernel.g.aeS().b(2768, (com.tencent.mm.al.g)localObject1);
      ((BizTimeLineHotView)localObject1).nbB.setAdapter(null);
      ((BizTimeLineHotView)localObject1).nbB.nbx.dead();
    }
    Object localObject1 = this.mXX;
    com.tencent.mm.sdk.b.a.ESL.d(((f)localObject1).jBI);
    u.uZ(false);
    mXY = System.currentTimeMillis();
    if ((this.mXW != null) && (this.mXP != null))
    {
      localObject1 = this.mXW.bCI();
      if (localObject1 != null) {
        mXZ = ((s)localObject1).field_orderFlag;
      }
      localObject1 = this.mXW.xP(bCS());
      if (localObject1 == null) {
        break label570;
      }
      mYa = ((s)localObject1).field_orderFlag;
    }
    for (;;)
    {
      localObject1 = this.mXW;
      af.awk().a(((c)localObject1).mSg);
      ((c)localObject1).mWO.ncj.clear();
      af.awl().a(this.mYk);
      if (this.mYd != 0L)
      {
        long l = System.currentTimeMillis();
        this.lKG += l - this.mYe;
        com.tencent.mm.plugin.report.service.h.vKh.f(13932, new Object[] { Integer.valueOf((int)(l - this.mYd) / 1000), Integer.valueOf(1), Integer.valueOf(this.dcS), Integer.valueOf((int)(this.lKG / 1000L)), Integer.valueOf(this.dep) });
      }
      com.tencent.mm.sdk.b.a.ESL.d(this.mYr);
      this.mYl.dead();
      this.mWX.mXG = bCS();
      com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new h.2(this.mWX), 0L);
      com.tencent.mm.plugin.brandservice.ui.b.b.clean();
      com.tencent.mm.ui.chatting.ao.clear();
      u.SR(0);
      try
      {
        if ((getContentView() instanceof ViewGroup)) {
          ((ViewGroup)getContentView()).removeAllViews();
        }
        localObject1 = com.tencent.mm.pluginsdk.model.a.BOa;
        com.tencent.mm.pluginsdk.model.a.euX();
        com.tencent.mm.plugin.brandservice.b.c.release();
        AppMethodBeat.o(5979);
        return;
        label570:
        ad.w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", new Object[] { Integer.valueOf(bCS()) });
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.w("MicroMsg.BizTimeLineUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
        }
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5981);
    super.onPause();
    Object localObject = null;
    if (this.mXW != null)
    {
      localObject = this.mXW;
      ((c)localObject).mWU.stopPlay();
      ((c)localObject).dkt = true;
      ((c)localObject).mWO.ncm = true;
      localObject = this.mXW.bCJ();
    }
    cl(this.mYp);
    int i;
    if (localObject != null)
    {
      af.awk().wa(((s)localObject).field_orderFlag);
      if (this.mXP == null) {
        break label206;
      }
      localObject = this.mXP.getChildAt(0);
      if (localObject == null) {
        break label201;
      }
      i = ((View)localObject).getTop();
    }
    label109:
    for (mYb = i;; mYb = 0)
    {
      this.dkt = true;
      long l = System.currentTimeMillis();
      this.lKG += l - this.mYe;
      this.mYe = l;
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBizEnable, this.foV);
      this.foV = 0;
      com.tencent.mm.pluginsdk.ui.span.k.b(this.mYs);
      localObject = com.tencent.mm.pluginsdk.ui.applet.g.BXQ;
      if (com.tencent.mm.pluginsdk.ui.applet.g.UJ(1))
      {
        localObject = com.tencent.mm.pluginsdk.model.a.BOa;
        com.tencent.mm.pluginsdk.model.a.euY();
      }
      AppMethodBeat.o(5981);
      return;
      af.awk().eJV();
      break;
      i = 0;
      break label109;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5980);
    super.onResume();
    if (this.mYf)
    {
      this.mYf = false;
      this.mWX.xR(8);
    }
    if (this.mXW != null)
    {
      Object localObject = this.mXW;
      ((c)localObject).dkt = false;
      localObject = ((c)localObject).mWO;
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).ncm)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).ncm = false;
        if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).ncg <= 0) {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).bDj();
        }
      }
    }
    if (this.dkt)
    {
      this.dkt = false;
      bCP();
    }
    this.mYe = System.currentTimeMillis();
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192977);
        if ((BizTimeLineUI.this.isFinishing()) || (BizTimeLineUI.d(BizTimeLineUI.this) == null) || (BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition() != 0) || (BizTimeLineUI.q(BizTimeLineUI.this) == null))
        {
          AppMethodBeat.o(192977);
          return;
        }
        BizTimeLineUI.q(BizTimeLineUI.this).bDc();
        AppMethodBeat.o(192977);
      }
    }, 500L);
    com.tencent.mm.pluginsdk.ui.span.k.a(this.mYs);
    AppMethodBeat.o(5980);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI
 * JD-Core Version:    0.7.0.1
 */