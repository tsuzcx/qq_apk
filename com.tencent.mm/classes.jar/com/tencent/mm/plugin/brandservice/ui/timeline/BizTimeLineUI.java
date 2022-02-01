package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.support.v7.app.ActionBar;
import android.util.Base64;
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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x;
import com.tencent.mm.al.af;
import com.tencent.mm.av.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.1;
import com.tencent.mm.pluginsdk.model.a.h;
import com.tencent.mm.pluginsdk.model.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u.3;
import com.tencent.mm.storage.u.a;
import com.tencent.mm.storage.u.c;
import com.tencent.mm.storage.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
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
  private static int nAA = 0;
  private static int nAB = 0;
  private static long nAx = 0L;
  private static long nAy = 0L;
  private static long nAz = 0L;
  private int daq;
  private int dbL;
  private boolean dhO;
  private TextView emptyTipTv;
  private int fsu;
  private View iMi;
  private int mOD;
  private long mmD;
  private long nAC;
  private long nAD;
  private boolean nAE;
  private int nAF;
  private int nAG;
  private int nAH;
  private HashSet<String> nAI;
  private u.c nAJ;
  private com.tencent.mm.sdk.b.c nAK;
  private long nAL;
  private final long nAM;
  private boolean nAN;
  private List<t> nAO;
  private boolean nAP;
  private com.tencent.mm.sdk.b.c nAQ;
  private com.tencent.mm.pluginsdk.ui.span.h nAR;
  public StoryListView nAo;
  private View nAp;
  private ImageView nAq;
  LinearLayout nAr;
  private TextView nAs;
  private TextView nAt;
  private View nAu;
  private c nAv;
  private f nAw;
  private View nzT;
  BizTimeLineHotView nzm;
  private boolean nzu;
  private h nzw;
  
  public BizTimeLineUI()
  {
    AppMethodBeat.i(5965);
    this.nAC = 0L;
    this.nAD = 0L;
    this.mmD = 0L;
    this.dbL = 1;
    this.nAE = false;
    this.nzu = false;
    this.dhO = false;
    this.nAF = 0;
    this.nAG = -1;
    this.nAH = -1;
    this.nAI = new HashSet();
    this.nAJ = new u.c()
    {
      public final void a(Object paramAnonymousObject, u.a paramAnonymousa)
      {
        AppMethodBeat.i(5955);
        BizTimeLineUI.this.bJV();
        AppMethodBeat.o(5955);
      }
    };
    this.nAK = new com.tencent.mm.sdk.b.c() {};
    this.nAL = 0L;
    this.nAM = 100L;
    this.nAN = false;
    this.nAO = new LinkedList();
    this.nAP = false;
    this.mOD = -1;
    this.nAQ = new BizTimeLineUI.9(this);
    this.nAR = new com.tencent.mm.pluginsdk.ui.span.h()
    {
      public final Object a(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
      {
        return null;
      }
      
      public final Object b(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
      {
        AppMethodBeat.i(198698);
        if (paramAnonymousu.type == 45)
        {
          String str1 = new String(Base64.decode(paramAnonymousu.url, 0));
          String str2 = new String(Base64.decode(bs.bG((String)paramAnonymousu.aW(String.class), ""), 0));
          ac.d("MicroMsg.BizTimeLineUI", "appId:%s,path:%s", new Object[] { str1, str2 });
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1082;
          paramAnonymousu = paramAnonymousu.mSessionId;
          if (!bs.isNullOrNil(paramAnonymousu))
          {
            paramAnonymousu = y.ayq().xH(paramAnonymousu);
            if (paramAnonymousu != null)
            {
              paramAnonymousu = paramAnonymousu.getString("preUsername", null);
              localAppBrandStatObject.cYP = (paramAnonymousu + "|3");
            }
          }
          ((n)com.tencent.mm.kernel.g.ab(n.class)).a(BizTimeLineUI.this.getContext(), null, str1, 0, 0, str2, localAppBrandStatObject);
        }
        AppMethodBeat.o(198698);
        return null;
      }
    };
    AppMethodBeat.o(5965);
  }
  
  private void bJY()
  {
    AppMethodBeat.i(5976);
    if ((this.nAv == null) || (this.dhO))
    {
      AppMethodBeat.o(5976);
      return;
    }
    if (this.nAv.mgF.size() > 0)
    {
      final long l1 = ((t)this.nAv.mgF.get(0)).field_orderFlag;
      int j = af.aDc().AC(l1);
      int i = j;
      if (j > 0)
      {
        long l2 = af.aDc().eZu();
        i = j;
        if (af.aDc().AH(l2 << 32) != null) {
          i = j - 1;
        }
      }
      ac.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        setMMTitleVisibility(8);
        if (this.nAp.getVisibility() == 8) {
          this.nAp.setVisibility(4);
        }
        this.nAt.setText(getString(2131756635, new Object[] { Integer.valueOf(i) }));
        this.nAp.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5950);
            if (af.aDc().AC(l1) <= 0)
            {
              BizTimeLineUI.this.setMMTitleVisibility(0);
              AppMethodBeat.o(5950);
              return;
            }
            float f1 = BizTimeLineUI.n(BizTimeLineUI.this).getX();
            int i = (int)((BizTimeLineUI.n(BizTimeLineUI.this).getWidth() + (f1 + f1)) / 2.0F);
            int j = com.tencent.mm.cc.a.ig(BizTimeLineUI.this.getContext()) / 2;
            if (i != j)
            {
              float f2 = j - i + f1;
              BizTimeLineUI.n(BizTimeLineUI.this).setX(f2);
              ac.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView x = %f, new x=%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
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
    this.nAp.setVisibility(8);
    setMMTitleVisibility(0);
    AppMethodBeat.o(5976);
  }
  
  private static int bKa()
  {
    if (nAB > 0) {
      return nAB - 1;
    }
    return 0;
  }
  
  private static void cn(List<t> paramList)
  {
    AppMethodBeat.i(5984);
    if (!bs.gY(paramList))
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((t)localIterator.next()).field_isRead = 1;
      }
      localLinkedList.addAll(paramList);
      af.aDc().hd(localLinkedList);
    }
    AppMethodBeat.o(5984);
  }
  
  private void d(final t paramt)
  {
    AppMethodBeat.i(5971);
    this.nAo.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198705);
        BizTimeLineUI.c(BizTimeLineUI.this).nzu = false;
        BizTimeLineUI.i(BizTimeLineUI.this);
        int i = Math.max(0, BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.d(BizTimeLineUI.this).getHeaderViewsCount());
        BizTimeLineUI.c(BizTimeLineUI.this).b(paramt);
        BizTimeLineUI.c(BizTimeLineUI.this).b(BizTimeLineUI.c(BizTimeLineUI.this).yG(i));
        BizTimeLineUI.j(BizTimeLineUI.this);
        ac.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(198705);
      }
    }, 50L);
    AppMethodBeat.o(5971);
  }
  
  private void dz(View paramView)
  {
    AppMethodBeat.i(5982);
    paramView = paramView.getTag(2131297288);
    if ((paramView instanceof String)) {
      this.nAI.add((String)paramView);
    }
    AppMethodBeat.o(5982);
  }
  
  private void eL(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(5983);
    if ((paramInt1 == 0) && (!this.nzu) && (nAB != paramInt1)) {
      this.nzm.bKm();
    }
    if ((this.nzu) || (this.nAP) || ((nAB == paramInt1) && (this.mOD == paramInt2)))
    {
      AppMethodBeat.o(5983);
      return;
    }
    this.mOD = paramInt2;
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
        t localt = this.nAv.yG(paramInt1);
        if ((localt != null) && (localt.field_isRead != 1)) {
          localLinkedList.add(localt);
        }
        paramInt1 += 1;
      }
      paramInt1 = 0;
    }
    this.nAO.removeAll(localLinkedList);
    cn(this.nAO);
    this.nAO.clear();
    this.nAO.addAll(localLinkedList);
    AppMethodBeat.o(5983);
  }
  
  public final void bJU()
  {
    AppMethodBeat.i(5978);
    if (this.nAv != null) {
      this.nAv.notifyDataSetChanged();
    }
    AppMethodBeat.o(5978);
  }
  
  public final void bJV()
  {
    AppMethodBeat.i(5968);
    if (isFinishing())
    {
      AppMethodBeat.o(5968);
      return;
    }
    int i = af.aDd().bQe();
    if (i > 0)
    {
      this.nAr.setVisibility(0);
      this.nAs.setText(getString(2131756629, new Object[] { Integer.valueOf(i) }));
      t localt = af.aDd().eZI();
      if (localt != null)
      {
        this.nAq.setVisibility(0);
        if (localt.eZn())
        {
          this.nAq.setImageResource(2131231274);
          v.AK(localt.field_msgId);
        }
      }
      for (;;)
      {
        if ((this.nAv != null) && (this.nAv.getCount() == 0)) {
          this.nAv.notifyDataSetChanged();
        }
        AppMethodBeat.o(5968);
        return;
        a.b.c(this.nAq, localt.field_talker);
        break;
        this.nAq.setVisibility(8);
      }
    }
    this.nAr.setVisibility(8);
    AppMethodBeat.o(5968);
  }
  
  public final void bJW()
  {
    AppMethodBeat.i(5974);
    if ((!isFinishing()) && (this.nzT != null))
    {
      ((View)$(2131297351)).setVisibility(8);
      ((View)$(2131297359)).setVisibility(0);
      ((TextView)$(2131297358)).setText(getString(2131756626));
    }
    AppMethodBeat.o(5974);
  }
  
  public final void bJX()
  {
    AppMethodBeat.i(5975);
    long l = System.currentTimeMillis() - this.nAL;
    if ((this.nAN) && (l < 200L))
    {
      ac.d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
      AppMethodBeat.o(5975);
      return;
    }
    ac.d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.nAN), Long.valueOf(l) });
    this.nAN = true;
    if (l < 100L)
    {
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198695);
          BizTimeLineUI.m(BizTimeLineUI.this);
          if (!BizTimeLineUI.this.isFinishing())
          {
            BizTimeLineUI.this.bJX();
            AppMethodBeat.o(198695);
            return;
          }
          ac.w("MicroMsg.BizTimeLineUI", "Activity is finished!!!");
          AppMethodBeat.o(198695);
        }
      }, 100L);
      AppMethodBeat.o(5975);
      return;
    }
    bJY();
    this.nAL = System.currentTimeMillis();
    this.nAN = false;
    AppMethodBeat.o(5975);
  }
  
  public final void bJZ()
  {
    AppMethodBeat.i(5977);
    ac.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
    bJX();
    AppMethodBeat.o(5977);
  }
  
  public int getLayoutId()
  {
    return 2131493203;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5966);
    v.wb(true);
    com.tencent.mm.plugin.brandservice.b.b.init();
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(2131299468));
    this.emptyTipTv.setText(2131756606);
    this.nAw = new f(this);
    paramBundle = this.nAw;
    com.tencent.mm.sdk.b.a.GpY.c(paramBundle.kce);
    this.daq = ((int)(System.currentTimeMillis() / 1000L));
    this.dbL = getIntent().getIntExtra("biz_enter_source", 1);
    this.nzw = new h(this.daq);
    v.UZ(this.daq);
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198692);
        if ((BizTimeLineUI.this.activityHasDestroyed()) || (BizTimeLineUI.this.isFinishing()))
        {
          AppMethodBeat.o(198692);
          return;
        }
        BizTimeLineUI.l(BizTimeLineUI.this);
        AppMethodBeat.o(198692);
      }
    });
    paramBundle = com.tencent.mm.model.c.d.aAp().tJ("100045");
    boolean bool;
    final int i;
    long l;
    int j;
    if ((paramBundle.isValid()) && ("1".equals(paramBundle.eYV().get("isOpenSearch"))))
    {
      bool = true;
      ac.d("MicroMsg.BizTimeLineUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
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
          com.tencent.mm.br.d.e(BizTimeLineUI.this, ".ui.conversation.NewBizConversationUI", paramAnonymousMenuItem);
          BizTimeLineUI.a(BizTimeLineUI.this).yI(7);
          BizTimeLineUI.k(BizTimeLineUI.this);
          AppMethodBeat.o(5945);
          return true;
        }
      });
      setMMTitle(2131756642);
      setMMTitleColor(com.tencent.mm.ui.ao.aJ(getContext(), 2130968584));
      setBackBtn(new BizTimeLineUI.4(this), 2131689490);
      this.nAp = getLayoutInflater().inflate(2131493202, null);
      this.nAt = ((TextView)this.nAp.findViewById(2131297369));
      this.nAt.setTextSize(1, 14.0F);
      this.nAu = this.nAp.findViewById(2131297368);
      ((LinearLayout)getController().mActionBar.getCustomView()).addView(this.nAp);
      paramBundle = (LinearLayout.LayoutParams)this.nAp.getLayoutParams();
      paramBundle.width = -1;
      paramBundle.weight = 1.0F;
      this.nAp.setLayoutParams(paramBundle);
      this.nAu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198694);
          BizTimeLineUI.l(BizTimeLineUI.this);
          AppMethodBeat.o(198694);
        }
      });
      this.nAp.setVisibility(8);
      this.nAo = ((StoryListView)$(2131297354));
      paramBundle = this.nAo;
      this.nzT = getLayoutInflater().inflate(2131493205, null);
      paramBundle.addFooterView(this.nzT);
      paramBundle = this.nAo;
      this.iMi = getLayoutInflater().inflate(2131493206, null);
      this.nzm = ((BizTimeLineHotView)this.iMi.findViewById(2131297334));
      paramBundle.addHeaderView(this.iMi);
      i = nAB;
      l = System.currentTimeMillis();
      j = com.tencent.mm.m.g.ZY().getInt("BizTimeLineStayTime", 180) * 1000;
      if ((nAx == 0L) || (nAy == 0L) || (l - nAx >= j)) {
        break label1036;
      }
      paramBundle = af.aDc().Az(nAy);
      this.nzu = true;
      com.tencent.mm.plugin.brandservice.ui.b.c.cw(paramBundle);
    }
    for (;;)
    {
      ac.i("MicroMsg.BizTimeLineUI", "initListView stayTime %d %d/%d  orderFlag %d, keep %b", new Object[] { Integer.valueOf(j), Long.valueOf(nAx), Long.valueOf(l), Long.valueOf(nAy), Boolean.valueOf(this.nzu) });
      this.nAv = new c(this, paramBundle, this.nzu, this.nzw, this.nzm);
      this.nzw.nAe = bKa();
      this.nAr = ((LinearLayout)$(2131302793));
      this.nAs = ((TextView)$(2131302794));
      this.nAq = ((ImageView)$(2131302792));
      bJV();
      this.nAr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(5944);
          BizTimeLineUI.a(BizTimeLineUI.this).yI(12);
          Object localObject = new Intent(BizTimeLineUI.this.getContext(), BizTimeLineNewMsgUI.class);
          ((Intent)localObject).putExtra("biz_time_line_line_session_id", BizTimeLineUI.b(BizTimeLineUI.this));
          ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 1);
          paramAnonymousView = BizTimeLineUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(5944);
        }
      });
      this.nAo.setAdapter(this.nAv);
      this.nAo.setFooterDividersEnabled(false);
      this.nAo.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(198701);
          BizTimeLineUI.a(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousAbsListView = com.tencent.mm.pluginsdk.ui.applet.g.Dqh;
          if (com.tencent.mm.pluginsdk.ui.applet.g.WT(1)) {
            BizTimeLineUI.b(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt2 - 1);
          }
          BizTimeLineUI.yJ(paramAnonymousInt1);
          AppMethodBeat.o(198701);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(198700);
          com.tencent.mm.plugin.brandservice.ui.b.a.bNI();
          o.aFB().cp(paramAnonymousInt);
          boolean bool;
          int i;
          int j;
          int k;
          if ((paramAnonymousInt == 0) || (paramAnonymousInt == 1))
          {
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.a.Dgo;
            if (com.tencent.mm.pluginsdk.model.a.Dgm) {
              com.tencent.mm.pluginsdk.model.a.v((Runnable)new a.h(System.currentTimeMillis()));
            }
            if (paramAnonymousInt == 0) {
              BizTimeLineUI.c(BizTimeLineUI.this).eK(BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.d(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.d(BizTimeLineUI.this).getLastVisiblePosition());
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
            ac.i("MicroMsg.BizTimeLineUI", "summer hardcoder biz startPerformance [%s] [%s]", new Object[] { Integer.valueOf(903), Integer.valueOf(BizTimeLineUI.e(BizTimeLineUI.this)) });
            AppMethodBeat.o(198700);
            return;
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.a.Dgo;
            if (com.tencent.mm.pluginsdk.model.a.Dgm) {
              break;
            }
            com.tencent.mm.pluginsdk.model.a.v((Runnable)new a.l(System.currentTimeMillis()));
            break;
          }
        }
      });
      this.nAo.setEmptyView(this.emptyTipTv);
      this.nAo.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198702);
          if ((BizTimeLineUI.f(BizTimeLineUI.this)) && (i != 0))
          {
            BizTimeLineUI.g(BizTimeLineUI.this);
            BizTimeLineUI.this.bJX();
          }
          if ((BizTimeLineUI.f(BizTimeLineUI.this)) && (i == 0)) {
            BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.c(BizTimeLineUI.this).yG(0));
          }
          if (!bs.gY(paramBundle))
          {
            long l = ((t)paramBundle.get(0)).field_orderFlag;
            h localh = BizTimeLineUI.a(BizTimeLineUI.this);
            int i = BizTimeLineUI.h(BizTimeLineUI.this);
            int j = BizTimeLineUI.this.getIntent().getIntExtra("Main_IndexInSessionList", 0);
            com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new h.3(localh, l, BizTimeLineUI.this.getIntent().getIntExtra("Main_UnreadCount", 0), i, j), 0L);
          }
          AppMethodBeat.o(198702);
        }
      }, 120L);
      this.nAo.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(198703);
          BizTimeLineUI.c(BizTimeLineUI.this).eK(BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.d(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.d(BizTimeLineUI.this).getLastVisiblePosition());
          BizTimeLineUI.d(BizTimeLineUI.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(198703);
        }
      });
      if (paramBundle.size() < 10) {
        bJW();
      }
      af.aDd().a(this.nAJ, Looper.getMainLooper());
      new e();
      ac.d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
      i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRj, Integer.valueOf(0))).intValue();
      if ((i & 0x4) == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNL("officialaccounts");
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRj, Integer.valueOf(i | 0x4));
      }
      com.tencent.mm.pluginsdk.g.p(this);
      this.nAC = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.GpY.c(this.nAQ);
      this.nAK.alive();
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(1)) {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).yt(90);
      }
      paramBundle = af.aDc();
      if (paramBundle.GCg)
      {
        paramBundle.GCg = false;
        com.tencent.e.h.JZN.a(new u.3(paramBundle), 1000L, "BizTimeLineInfoStorageThread");
      }
      com.tencent.mm.plugin.brandservice.ui.b.a.bNG();
      com.tencent.mm.pluginsdk.ui.applet.g.eNm();
      com.tencent.mm.api.b.ID();
      com.tencent.mm.plugin.brandservice.b.b.bJb();
      AppMethodBeat.o(5966);
      return;
      bool = false;
      break;
      label1036:
      this.nzu = false;
      paramBundle = af.aDc().Yz(10);
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(198704);
          Looper.myQueue().removeIdleHandler(this);
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.addAll(paramBundle);
          com.tencent.mm.plugin.brandservice.ui.b.c.a(localLinkedList, null);
          AppMethodBeat.o(198704);
          return false;
        }
      });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5979);
    super.onDestroy();
    if (this.nzm != null)
    {
      localObject1 = this.nzm;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().b((n.b)localObject1);
      com.tencent.mm.sdk.b.a.GpY.d(((BizTimeLineHotView)localObject1).nEm);
      com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f localf = ((BizTimeLineHotView)localObject1).nDU;
      Object localObject2 = new b.a();
      byy localbyy = new byy();
      ((b.a)localObject2).hvt = localbyy;
      ((b.a)localObject2).hvu = new byz();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/often_read_bar_report";
      ((b.a)localObject2).funcId = 2550;
      localObject2 = ((b.a)localObject2).aAz();
      localbyy.DZA = v.getSessionId();
      localbyy.FnY = localf.nEC;
      LinkedList localLinkedList = new LinkedList();
      if (localf.nEB.size() > 0)
      {
        Iterator localIterator = localf.nEB.entrySet().iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add((bza)((Map.Entry)localIterator.next()).getValue());
        }
      }
      localbyy.FnX = localLinkedList;
      x.a((com.tencent.mm.ak.b)localObject2, new f.1(localf));
      com.tencent.mm.kernel.g.agi().b(2768, (com.tencent.mm.ak.g)localObject1);
      ((BizTimeLineHotView)localObject1).nEg.setAdapter(null);
      ((BizTimeLineHotView)localObject1).nEg.nDZ.dead();
    }
    Object localObject1 = this.nAw;
    com.tencent.mm.sdk.b.a.GpY.d(((f)localObject1).kce);
    v.wb(false);
    nAx = System.currentTimeMillis();
    if ((this.nAv != null) && (this.nAo != null))
    {
      localObject1 = this.nAv.bJQ();
      if (localObject1 != null) {
        nAy = ((t)localObject1).field_orderFlag;
      }
      localObject1 = this.nAv.yG(bKa());
      if (localObject1 == null) {
        break label570;
      }
      nAz = ((t)localObject1).field_orderFlag;
    }
    for (;;)
    {
      localObject1 = this.nAv;
      af.aDc().a(((c)localObject1).nuw);
      ((c)localObject1).nzn.nEV.clear();
      af.aDd().a(this.nAJ);
      if (this.nAC != 0L)
      {
        long l = System.currentTimeMillis();
        this.mmD += l - this.nAD;
        com.tencent.mm.plugin.report.service.h.wUl.f(13932, new Object[] { Integer.valueOf((int)(l - this.nAC) / 1000), Integer.valueOf(1), Integer.valueOf(this.daq), Integer.valueOf((int)(this.mmD / 1000L)), Integer.valueOf(this.dbL) });
      }
      com.tencent.mm.sdk.b.a.GpY.d(this.nAQ);
      this.nAK.dead();
      this.nzw.nAf = bKa();
      com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new h.2(this.nzw), 0L);
      com.tencent.mm.plugin.brandservice.ui.b.b.clean();
      com.tencent.mm.ui.chatting.ao.clear();
      v.UZ(0);
      try
      {
        if ((getContentView() instanceof ViewGroup)) {
          ((ViewGroup)getContentView()).removeAllViews();
        }
        localObject1 = com.tencent.mm.pluginsdk.model.a.Dgo;
        com.tencent.mm.pluginsdk.model.a.eKr();
        com.tencent.mm.plugin.brandservice.b.b.release();
        AppMethodBeat.o(5979);
        return;
        label570:
        ac.w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", new Object[] { Integer.valueOf(bKa()) });
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ac.w("MicroMsg.BizTimeLineUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
        }
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5981);
    super.onPause();
    Object localObject = null;
    if (this.nAv != null)
    {
      localObject = this.nAv;
      ((c)localObject).nzt.stopPlay();
      ((c)localObject).dhO = true;
      ((c)localObject).nzn.nEY = true;
      localObject = this.nAv.bJR();
    }
    cn(this.nAO);
    int i;
    if (localObject != null)
    {
      af.aDc().AD(((t)localObject).field_orderFlag);
      if (this.nAo == null) {
        break label206;
      }
      localObject = this.nAo.getChildAt(0);
      if (localObject == null) {
        break label201;
      }
      i = ((View)localObject).getTop();
    }
    label109:
    for (nAA = i;; nAA = 0)
    {
      this.dhO = true;
      long l = System.currentTimeMillis();
      this.mmD += l - this.nAD;
      this.nAD = l;
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBizEnable, this.fsu);
      this.fsu = 0;
      com.tencent.mm.pluginsdk.ui.span.k.b(this.nAR);
      localObject = com.tencent.mm.pluginsdk.ui.applet.g.Dqh;
      if (com.tencent.mm.pluginsdk.ui.applet.g.WT(1))
      {
        localObject = com.tencent.mm.pluginsdk.model.a.Dgo;
        com.tencent.mm.pluginsdk.model.a.eKs();
      }
      AppMethodBeat.o(5981);
      return;
      af.aDc().eZs();
      break;
      i = 0;
      break label109;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5980);
    super.onResume();
    if (this.nAE)
    {
      this.nAE = false;
      this.nzw.yI(8);
    }
    if (this.nAv != null)
    {
      Object localObject = this.nAv;
      ((c)localObject).dhO = false;
      localObject = ((c)localObject).nzn;
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).nEY)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).nEY = false;
        if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).nES <= 0) {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).bKw();
        }
      }
    }
    if (this.dhO)
    {
      this.dhO = false;
      bJX();
    }
    this.nAD = System.currentTimeMillis();
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198699);
        if ((BizTimeLineUI.this.isFinishing()) || (BizTimeLineUI.d(BizTimeLineUI.this) == null) || (BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition() != 0) || (BizTimeLineUI.q(BizTimeLineUI.this) == null))
        {
          AppMethodBeat.o(198699);
          return;
        }
        BizTimeLineUI.q(BizTimeLineUI.this).bKm();
        AppMethodBeat.o(198699);
      }
    }, 500L);
    com.tencent.mm.pluginsdk.ui.span.k.a(this.nAR);
    AppMethodBeat.o(5980);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI
 * JD-Core Version:    0.7.0.1
 */