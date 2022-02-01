package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.am.ag;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.1;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.a.h;
import com.tencent.mm.pluginsdk.model.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.protocal.protobuf.cdq;
import com.tencent.mm.protocal.protobuf.cdr;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x.3;
import com.tencent.mm.storage.x.a;
import com.tencent.mm.storage.x.c;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@com.tencent.mm.kernel.i
public class BizTimeLineUI
  extends MMActivity
  implements i, com.tencent.mm.plugin.webcanvas.d, bh.a
{
  private static long obE = 0L;
  private static long obF = 0L;
  private static long obG = 0L;
  private static int obH = 0;
  private static int obI = 0;
  private int dlK;
  private int dnh;
  private boolean dtm;
  private TextView emptyTipTv;
  private int fKU;
  private View jfs;
  private long mNf;
  private int npa;
  private g oaB;
  private View oaY;
  BizTimeLineHotView oar;
  private boolean oaz;
  private TextView obA;
  private View obB;
  private b obC;
  private e obD;
  private long obJ;
  private long obK;
  private boolean obL;
  private int obM;
  private int obN;
  private int obO;
  private HashSet<String> obP;
  private final Set<com.tencent.mm.plugin.webcanvas.e> obQ;
  private final Set<com.tencent.mm.plugin.webcanvas.c> obR;
  private x.c obS;
  private com.tencent.mm.sdk.b.c obT;
  private long obU;
  private final long obV;
  private boolean obW;
  private List<w> obX;
  private boolean obY;
  private com.tencent.mm.sdk.b.c obZ;
  public StoryListView obv;
  private View obw;
  private ImageView obx;
  LinearLayout oby;
  private TextView obz;
  private com.tencent.mm.pluginsdk.ui.span.h oca;
  
  public BizTimeLineUI()
  {
    AppMethodBeat.i(5965);
    this.obJ = 0L;
    this.obK = 0L;
    this.mNf = 0L;
    this.dnh = 1;
    this.obL = false;
    this.oaz = false;
    this.dtm = false;
    this.obM = 0;
    this.obN = -1;
    this.obO = -1;
    this.obP = new HashSet();
    this.obQ = Collections.newSetFromMap(new ConcurrentHashMap());
    this.obR = Collections.newSetFromMap(new ConcurrentHashMap());
    this.obS = new x.c()
    {
      public final void a(Object paramAnonymousObject, x.a paramAnonymousa)
      {
        AppMethodBeat.i(5955);
        BizTimeLineUI.this.bOp();
        AppMethodBeat.o(5955);
      }
    };
    this.obT = new BizTimeLineUI.13(this);
    this.obU = 0L;
    this.obV = 100L;
    this.obW = false;
    this.obX = new LinkedList();
    this.obY = false;
    this.npa = -1;
    this.obZ = new BizTimeLineUI.9(this);
    this.oca = new BizTimeLineUI.10(this);
    AppMethodBeat.o(5965);
  }
  
  private void bOs()
  {
    AppMethodBeat.i(5976);
    if ((this.obC == null) || (this.dtm))
    {
      AppMethodBeat.o(5976);
      return;
    }
    final long l1;
    int j;
    if (this.obC.mHf.size() > 0)
    {
      l1 = ((w)this.obC.mHf.get(0)).field_orderFlag;
      if ((this.obv == null) || (this.obv.getFirstVisiblePosition() <= 0)) {
        break label247;
      }
      j = ag.aGf().Ds(l1);
      i = j;
      if (j > 0)
      {
        long l2 = ag.aGf().fpt();
        i = j;
        if (ag.aGf().Dx(l2 << 32) == null) {}
      }
    }
    label247:
    for (int i = j - 1;; i = 0)
    {
      ad.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        setMMTitleVisibility(8);
        if (this.obw.getVisibility() == 8) {
          this.obw.setVisibility(4);
        }
        this.obA.setText(getString(2131756635, new Object[] { Integer.valueOf(i) }));
        this.obw.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5950);
            if (ag.aGf().Ds(l1) <= 0)
            {
              BizTimeLineUI.this.setMMTitleVisibility(0);
              AppMethodBeat.o(5950);
              return;
            }
            float f1 = BizTimeLineUI.o(BizTimeLineUI.this).getX();
            int i = (int)((BizTimeLineUI.o(BizTimeLineUI.this).getWidth() + (f1 + f1)) / 2.0F);
            int j = com.tencent.mm.cc.a.ip(BizTimeLineUI.this.getContext()) / 2;
            if (i != j)
            {
              float f2 = j - i + f1;
              BizTimeLineUI.o(BizTimeLineUI.this).setX(f2);
              ad.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView x = %f, new x=%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
            }
            if (BizTimeLineUI.o(BizTimeLineUI.this).getVisibility() != 0) {
              BizTimeLineUI.o(BizTimeLineUI.this).setVisibility(0);
            }
            AppMethodBeat.o(5950);
          }
        });
        AppMethodBeat.o(5976);
        return;
        AppMethodBeat.o(5976);
        return;
      }
      this.obw.setVisibility(8);
      setMMTitleVisibility(0);
      AppMethodBeat.o(5976);
      return;
    }
  }
  
  private static int bOu()
  {
    if (obI > 0) {
      return obI - 1;
    }
    return 0;
  }
  
  private static void cn(List<w> paramList)
  {
    AppMethodBeat.i(5984);
    if (!bt.hj(paramList))
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((w)localIterator.next()).field_isRead = 1;
      }
      localLinkedList.addAll(paramList);
      ag.aGf().hp(localLinkedList);
    }
    AppMethodBeat.o(5984);
  }
  
  private void dB(View paramView)
  {
    AppMethodBeat.i(5982);
    paramView = paramView.getTag(2131297288);
    if ((paramView instanceof String)) {
      this.obP.add((String)paramView);
    }
    AppMethodBeat.o(5982);
  }
  
  private void e(final w paramw)
  {
    AppMethodBeat.i(5971);
    this.obv.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209518);
        BizTimeLineUI.c(BizTimeLineUI.this).oaz = false;
        BizTimeLineUI.j(BizTimeLineUI.this);
        int i = Math.max(0, BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.f(BizTimeLineUI.this).getHeaderViewsCount());
        BizTimeLineUI.c(BizTimeLineUI.this).b(paramw);
        BizTimeLineUI.c(BizTimeLineUI.this).b(BizTimeLineUI.c(BizTimeLineUI.this).zq(i));
        BizTimeLineUI.k(BizTimeLineUI.this);
        ad.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(209518);
      }
    }, 50L);
    AppMethodBeat.o(5971);
  }
  
  private void eP(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(5983);
    if ((paramInt1 == 0) && (!this.oaz) && (obI != paramInt1)) {
      this.oar.bON();
    }
    if ((this.oaz) || (this.obY) || ((obI == paramInt1) && (this.npa == paramInt2)))
    {
      AppMethodBeat.o(5983);
      return;
    }
    this.npa = paramInt2;
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
        w localw = this.obC.zq(paramInt1);
        if ((localw != null) && (localw.field_isRead != 1)) {
          localLinkedList.add(localw);
        }
        paramInt1 += 1;
      }
      paramInt1 = 0;
    }
    this.obX.removeAll(localLinkedList);
    cn(this.obX);
    this.obX.clear();
    this.obX.addAll(localLinkedList);
    AppMethodBeat.o(5983);
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(209525);
    paramString = this.obQ.iterator();
    while (paramString.hasNext()) {
      ((com.tencent.mm.plugin.webcanvas.e)paramString.next()).bYv();
    }
    AppMethodBeat.o(209525);
  }
  
  public final void a(com.tencent.mm.plugin.webcanvas.c paramc)
  {
    AppMethodBeat.i(209523);
    if (!this.obR.contains(this.obR)) {
      this.obR.add(paramc);
    }
    AppMethodBeat.o(209523);
  }
  
  public final void a(com.tencent.mm.plugin.webcanvas.e parame)
  {
    AppMethodBeat.i(209521);
    if (!this.obQ.contains(parame)) {
      this.obQ.add(parame);
    }
    AppMethodBeat.o(209521);
  }
  
  public final void b(com.tencent.mm.plugin.webcanvas.e parame)
  {
    AppMethodBeat.i(209522);
    this.obQ.remove(parame);
    AppMethodBeat.o(209522);
  }
  
  public final void bOo()
  {
    AppMethodBeat.i(5978);
    if (this.obC != null) {
      this.obC.notifyDataSetChanged();
    }
    AppMethodBeat.o(5978);
  }
  
  public final void bOp()
  {
    AppMethodBeat.i(5968);
    if (isFinishing())
    {
      AppMethodBeat.o(5968);
      return;
    }
    int i = ag.aGg().bUJ();
    if (i > 0)
    {
      this.oby.setVisibility(0);
      this.obz.setText(getString(2131756629, new Object[] { Integer.valueOf(i) }));
      w localw = ag.aGg().fpJ();
      if (localw != null)
      {
        this.obx.setVisibility(0);
        if (localw.fpg())
        {
          Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(localw.field_talker);
          if ((localObject == null) || (!com.tencent.mm.o.b.lM(((aw)localObject).field_type)))
          {
            if (localw.fpk() != null)
            {
              localObject = new c.a();
              ((c.a)localObject).idD = 2131231875;
              ((c.a)localObject).idq = true;
              com.tencent.mm.aw.q.aIJ().a(localw.fpk().hDQ, this.obx, ((c.a)localObject).aJc());
            }
            y.DA(localw.field_msgId);
          }
        }
      }
      for (;;)
      {
        if ((this.obC != null) && (this.obC.getCount() == 0)) {
          this.obC.notifyDataSetChanged();
        }
        AppMethodBeat.o(5968);
        return;
        a.b.c(this.obx, localw.field_talker);
        break;
        this.obx.setVisibility(8);
      }
    }
    this.oby.setVisibility(8);
    AppMethodBeat.o(5968);
  }
  
  public final void bOq()
  {
    AppMethodBeat.i(5974);
    if ((!isFinishing()) && (this.oaY != null))
    {
      ((View)$(2131297351)).setVisibility(8);
      ((View)$(2131297359)).setVisibility(0);
      ((TextView)$(2131297358)).setText(getString(2131756626));
    }
    AppMethodBeat.o(5974);
  }
  
  public final void bOr()
  {
    AppMethodBeat.i(5975);
    long l = System.currentTimeMillis() - this.obU;
    if ((this.obW) && (l < 200L))
    {
      ad.d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
      AppMethodBeat.o(5975);
      return;
    }
    ad.d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.obW), Long.valueOf(l) });
    this.obW = true;
    if (l < 100L)
    {
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209509);
          BizTimeLineUI.n(BizTimeLineUI.this);
          if (!BizTimeLineUI.this.isFinishing())
          {
            BizTimeLineUI.this.bOr();
            AppMethodBeat.o(209509);
            return;
          }
          ad.w("MicroMsg.BizTimeLineUI", "Activity is finished!!!");
          AppMethodBeat.o(209509);
        }
      }, 100L);
      AppMethodBeat.o(5975);
      return;
    }
    bOs();
    this.obU = System.currentTimeMillis();
    this.obW = false;
    AppMethodBeat.o(5975);
  }
  
  public final void bOt()
  {
    AppMethodBeat.i(5977);
    ad.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
    bOr();
    AppMethodBeat.o(5977);
  }
  
  public int getLayoutId()
  {
    return 2131493203;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5966);
    y.wN(true);
    com.tencent.mm.plugin.brandservice.b.b.init();
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(2131299468));
    this.emptyTipTv.setText(2131756606);
    this.obD = new e(this);
    paramBundle = this.obD;
    com.tencent.mm.sdk.b.a.IbL.c(paramBundle.kwD);
    this.dlK = ((int)(System.currentTimeMillis() / 1000L));
    this.dnh = getIntent().getIntExtra("biz_enter_source", 1);
    this.oaB = new g(this.dlK);
    y.WP(this.dlK);
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209506);
        if ((BizTimeLineUI.this.activityHasDestroyed()) || (BizTimeLineUI.this.isFinishing()))
        {
          AppMethodBeat.o(209506);
          return;
        }
        BizTimeLineUI.m(BizTimeLineUI.this);
        AppMethodBeat.o(209506);
      }
    });
    paramBundle = com.tencent.mm.model.c.d.aDs().wz("100045");
    boolean bool;
    final int i;
    long l;
    int j;
    if ((paramBundle.isValid()) && ("1".equals(paramBundle.foF().get("isOpenSearch"))))
    {
      bool = true;
      ad.d("MicroMsg.BizTimeLineUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        addIconOptionMenu(0, 2131764452, 2131689494, new BizTimeLineUI.18(this));
      }
      addIconOptionMenu(1, 2131756636, 2131689505, new MenuItem.OnMenuItemClickListener()new BizTimeLineUI.2
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(209520);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.addFlags(67108864);
          paramAnonymousMenuItem.putExtra("biz_from_scene", 2);
          paramAnonymousMenuItem.putExtra("biz_time_line_line_session_id", BizTimeLineUI.b(BizTimeLineUI.this));
          paramAnonymousMenuItem.putExtra("biz_enter_source", BizTimeLineUI.i(BizTimeLineUI.this));
          com.tencent.mm.bs.d.f(BizTimeLineUI.this, ".ui.conversation.NewBizConversationUI", paramAnonymousMenuItem);
          BizTimeLineUI.a(BizTimeLineUI.this).zs(7);
          BizTimeLineUI.l(BizTimeLineUI.this);
          AppMethodBeat.o(209520);
          return true;
        }
      }, new BizTimeLineUI.2(this));
      setMMTitle(2131756642);
      setMMTitleColor(getContext().getResources().getColor(2131099732));
      setBackBtn(new BizTimeLineUI.4(this), 2131689490);
      this.obw = getLayoutInflater().inflate(2131493202, null);
      this.obA = ((TextView)this.obw.findViewById(2131297369));
      this.obA.setTextSize(1, 14.0F);
      this.obB = this.obw.findViewById(2131297368);
      ((LinearLayout)getController().mActionBar.getCustomView()).addView(this.obw);
      paramBundle = (LinearLayout.LayoutParams)this.obw.getLayoutParams();
      paramBundle.width = -1;
      paramBundle.weight = 1.0F;
      this.obw.setLayoutParams(paramBundle);
      this.obB.setOnClickListener(new BizTimeLineUI.5(this));
      this.obw.setVisibility(8);
      this.obv = ((StoryListView)$(2131297354));
      paramBundle = this.obv;
      this.oaY = getLayoutInflater().inflate(2131493205, null);
      paramBundle.addFooterView(this.oaY);
      paramBundle = this.obv;
      this.jfs = getLayoutInflater().inflate(2131493206, null);
      this.oar = ((BizTimeLineHotView)this.jfs.findViewById(2131297334));
      paramBundle.addHeaderView(this.jfs);
      i = obI;
      l = System.currentTimeMillis();
      j = com.tencent.mm.n.g.acA().getInt("BizTimeLineStayTime", 180) * 1000;
      if ((obE == 0L) || (obF == 0L) || (l - obE >= j)) {
        break label1064;
      }
      paramBundle = ag.aGf().Dp(obF);
      this.oaz = true;
      com.tencent.mm.plugin.brandservice.ui.b.c.cw(paramBundle);
    }
    for (;;)
    {
      ad.i("MicroMsg.BizTimeLineUI", "initListView stayTime %d %d/%d  orderFlag %d, keep %b", new Object[] { Integer.valueOf(j), Long.valueOf(obE), Long.valueOf(l), Long.valueOf(obF), Boolean.valueOf(this.oaz) });
      this.obC = new b(this, paramBundle, this.oaz, this.oaB, this.oar);
      this.oaB.obk = bOu();
      this.oby = ((LinearLayout)$(2131302793));
      this.obz = ((TextView)$(2131302794));
      this.obx = ((ImageView)$(2131302792));
      bOp();
      this.oby.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(5944);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          BizTimeLineUI.a(BizTimeLineUI.this).zs(12);
          localObject = new Intent(BizTimeLineUI.this.getContext(), BizTimeLineNewMsgUI.class);
          ((Intent)localObject).putExtra("biz_time_line_line_session_id", BizTimeLineUI.b(BizTimeLineUI.this));
          ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 1);
          paramAnonymousView = BizTimeLineUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(5944);
        }
      });
      this.obv.setAdapter(this.obC);
      this.obv.setFooterDividersEnabled(false);
      this.obv.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(209515);
          paramAnonymousAbsListView = BizTimeLineUI.e(BizTimeLineUI.this).iterator();
          while (paramAnonymousAbsListView.hasNext()) {
            ((com.tencent.mm.plugin.webcanvas.e)paramAnonymousAbsListView.next()).eLn();
          }
          BizTimeLineUI.a(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousAbsListView = com.tencent.mm.pluginsdk.ui.applet.g.EVk;
          if (com.tencent.mm.pluginsdk.ui.applet.g.YP(1)) {
            BizTimeLineUI.b(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt2 - 1);
          }
          BizTimeLineUI.zt(paramAnonymousInt1);
          AppMethodBeat.o(209515);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(209514);
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
              break label145;
            }
          }
          label145:
          for (int i = Process.myTid();; i = 0)
          {
            BizTimeLineUI.a(paramAnonymousAbsListView, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcBizTimeout, 903, WXHardCoderJNI.hcBizAction, "MicroMsg.BizTimeLineUI"));
            ad.i("MicroMsg.BizTimeLineUI", "summer hardcoder biz startPerformance [%s] [%s]", new Object[] { Integer.valueOf(903), Integer.valueOf(BizTimeLineUI.d(BizTimeLineUI.this)) });
            paramAnonymousAbsListView = BizTimeLineUI.e(BizTimeLineUI.this).iterator();
            while (paramAnonymousAbsListView.hasNext()) {
              ((com.tencent.mm.plugin.webcanvas.e)paramAnonymousAbsListView.next()).eLm();
            }
          }
          com.tencent.mm.plugin.brandservice.ui.b.a.bSi();
          com.tencent.mm.aw.q.aIJ().cp(paramAnonymousInt);
          if ((paramAnonymousInt == 0) || (paramAnonymousInt == 1))
          {
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.a.EKY;
            if (com.tencent.mm.pluginsdk.model.a.EKW) {
              com.tencent.mm.pluginsdk.model.a.v((Runnable)new a.h(System.currentTimeMillis()));
            }
          }
          for (;;)
          {
            if (paramAnonymousInt == 0) {
              BizTimeLineUI.c(BizTimeLineUI.this).eO(BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.f(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.f(BizTimeLineUI.this).getLastVisiblePosition());
            }
            AppMethodBeat.o(209514);
            return;
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.a.EKY;
            if (!com.tencent.mm.pluginsdk.model.a.EKW) {
              com.tencent.mm.pluginsdk.model.a.v((Runnable)new a.l(System.currentTimeMillis()));
            }
          }
        }
      });
      this.obv.setEmptyView(this.emptyTipTv);
      this.obv.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209516);
          if ((BizTimeLineUI.g(BizTimeLineUI.this)) && (i != 0))
          {
            BizTimeLineUI.h(BizTimeLineUI.this);
            BizTimeLineUI.this.bOr();
          }
          if ((BizTimeLineUI.g(BizTimeLineUI.this)) && (i == 0)) {
            BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.c(BizTimeLineUI.this).zq(0));
          }
          if (!bt.hj(paramBundle))
          {
            long l = ((w)paramBundle.get(0)).field_orderFlag;
            g localg = BizTimeLineUI.a(BizTimeLineUI.this);
            int i = BizTimeLineUI.i(BizTimeLineUI.this);
            int j = BizTimeLineUI.this.getIntent().getIntExtra("Main_IndexInSessionList", 0);
            com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new g.3(localg, l, BizTimeLineUI.this.getIntent().getIntExtra("Main_UnreadCount", 0), i, j), 0L);
          }
          AppMethodBeat.o(209516);
        }
      }, 120L);
      this.obv.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(209517);
          BizTimeLineUI.c(BizTimeLineUI.this).eO(BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.f(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.f(BizTimeLineUI.this).getLastVisiblePosition());
          BizTimeLineUI.f(BizTimeLineUI.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(209517);
        }
      });
      if (paramBundle.size() < 10) {
        bOq();
      }
      ag.aGg().a(this.obS, Looper.getMainLooper());
      new d();
      ad.d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
      i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IDN, Integer.valueOf(0))).intValue();
      if ((i & 0x4) == 0)
      {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTC("officialaccounts");
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDN, Integer.valueOf(i | 0x4));
      }
      com.tencent.mm.pluginsdk.h.r(this);
      this.obJ = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.IbL.c(this.obZ);
      this.obT.alive();
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zd(90);
      }
      paramBundle = ag.aGf();
      if (paramBundle.Iow)
      {
        paramBundle.Iow = false;
        com.tencent.e.h.LTJ.a(new x.3(paramBundle), 1000L, "BizTimeLineInfoStorageThread");
      }
      com.tencent.mm.plugin.brandservice.ui.b.a.bSg();
      com.tencent.mm.pluginsdk.ui.applet.g.fcl();
      com.tencent.mm.api.b.Kd();
      com.tencent.mm.plugin.brandservice.b.b.bNt();
      paramBundle = com.tencent.mm.plugin.webcanvas.g.Dzc;
      com.tencent.mm.plugin.webcanvas.g.eLs();
      paramBundle = com.tencent.mm.plugin.webcanvas.f.DyX;
      com.tencent.mm.plugin.webcanvas.f.Cj(65L);
      AppMethodBeat.o(5966);
      return;
      bool = false;
      break;
      label1064:
      this.oaz = false;
      paramBundle = ag.aGf().aaG(10);
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll(paramBundle);
      com.tencent.mm.plugin.brandservice.ui.b.c.a(localLinkedList, null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5979);
    super.onDestroy();
    if (this.oar != null)
    {
      localObject1 = this.oar;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().b((n.b)localObject1);
      com.tencent.mm.sdk.b.a.IbL.d(((BizTimeLineHotView)localObject1).ogM);
      com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f localf = ((BizTimeLineHotView)localObject1).ogq;
      Object localObject2 = new b.a();
      cdp localcdp = new cdp();
      ((b.a)localObject2).hNM = localcdp;
      ((b.a)localObject2).hNN = new cdq();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/often_read_bar_report";
      ((b.a)localObject2).funcId = 2550;
      localObject2 = ((b.a)localObject2).aDC();
      localcdp.FEY = y.getSessionId();
      localcdp.GXJ = localf.ohe;
      LinkedList localLinkedList = new LinkedList();
      if (localf.ohd.size() > 0)
      {
        Iterator localIterator = localf.ohd.entrySet().iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add((cdr)((Map.Entry)localIterator.next()).getValue());
        }
      }
      localcdp.GXI = localLinkedList;
      com.tencent.mm.al.x.a((com.tencent.mm.al.b)localObject2, new f.1(localf));
      com.tencent.mm.kernel.g.aiU().b(2768, (com.tencent.mm.al.f)localObject1);
      ((BizTimeLineHotView)localObject1).ogG.setAdapter(null);
      ((BizTimeLineHotView)localObject1).ogG.ogw.dead();
    }
    Object localObject1 = this.obD;
    com.tencent.mm.sdk.b.a.IbL.d(((e)localObject1).kwD);
    y.wN(false);
    obE = System.currentTimeMillis();
    if ((this.obC != null) && (this.obv != null))
    {
      localObject1 = this.obC.bOk();
      if (localObject1 != null) {
        obF = ((w)localObject1).field_orderFlag;
      }
      localObject1 = this.obC.zq(bOu());
      if (localObject1 == null) {
        break label599;
      }
      obG = ((w)localObject1).field_orderFlag;
    }
    for (;;)
    {
      localObject1 = this.obC;
      ag.aGf().a(((b)localObject1).nVS);
      ((b)localObject1).oas.ohy.clear();
      ag.aGg().a(this.obS);
      if (this.obJ != 0L)
      {
        long l = System.currentTimeMillis();
        this.mNf += l - this.obK;
        com.tencent.mm.plugin.report.service.g.yhR.f(13932, new Object[] { Integer.valueOf((int)(l - this.obJ) / 1000), Integer.valueOf(1), Integer.valueOf(this.dlK), Integer.valueOf((int)(this.mNf / 1000L)), Integer.valueOf(this.dnh) });
      }
      com.tencent.mm.sdk.b.a.IbL.d(this.obZ);
      this.obT.dead();
      this.oaB.obl = bOu();
      com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new g.2(this.oaB), 0L);
      com.tencent.mm.plugin.brandservice.ui.b.b.clean();
      ao.clear();
      y.WP(0);
      try
      {
        if ((getContentView() instanceof ViewGroup)) {
          ((ViewGroup)getContentView()).removeAllViews();
        }
        localObject1 = com.tencent.mm.pluginsdk.model.a.EKY;
        com.tencent.mm.pluginsdk.model.a.eZl();
        com.tencent.mm.plugin.brandservice.b.b.release();
        localObject1 = this.obR.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((com.tencent.mm.plugin.webcanvas.c)((Iterator)localObject1).next()).onDestroy();
          continue;
          label599:
          ad.w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", new Object[] { Integer.valueOf(bOu()) });
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.w("MicroMsg.BizTimeLineUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
        }
        this.obQ.clear();
        this.obR.clear();
        AppMethodBeat.o(5979);
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5981);
    super.onPause();
    if (this.obC != null)
    {
      localObject = this.obC;
      ((b)localObject).oay.stopPlay();
      ((b)localObject).dtm = true;
      ((b)localObject).oas.ohB = true;
    }
    for (Object localObject = this.obC.bOl();; localObject = null)
    {
      cn(this.obX);
      int i;
      if (localObject != null)
      {
        ag.aGf().Dt(((w)localObject).field_orderFlag);
        if (this.obv == null) {
          break label240;
        }
        localObject = this.obv.getChildAt(0);
        if (localObject == null) {
          break label235;
        }
        i = ((View)localObject).getTop();
      }
      label106:
      label235:
      label240:
      for (obH = i;; obH = 0)
      {
        this.dtm = true;
        long l = System.currentTimeMillis();
        this.mNf += l - this.obK;
        this.obK = l;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBizEnable, this.fKU);
        this.fKU = 0;
        k.b(this.oca);
        localObject = com.tencent.mm.pluginsdk.ui.applet.g.EVk;
        if (com.tencent.mm.pluginsdk.ui.applet.g.YP(1))
        {
          localObject = com.tencent.mm.pluginsdk.model.a.EKY;
          com.tencent.mm.pluginsdk.model.a.eZm();
        }
        bh.a(this, null);
        localObject = this.obR.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.webcanvas.c)((Iterator)localObject).next()).onPause();
        }
        ag.aGf().fpr();
        break;
        i = 0;
        break label106;
      }
      AppMethodBeat.o(5981);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5980);
    super.onResume();
    if (this.obL)
    {
      this.obL = false;
      this.oaB.zs(8);
    }
    Object localObject;
    if (this.obC != null)
    {
      localObject = this.obC;
      ((b)localObject).dtm = false;
      localObject = ((b)localObject).oas;
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).ohB)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).ohB = false;
        if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).ohv <= 0) {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).bOX();
        }
      }
    }
    if (this.dtm)
    {
      this.dtm = false;
      bOr();
    }
    this.obK = System.currentTimeMillis();
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209513);
        if ((BizTimeLineUI.this.isFinishing()) || (BizTimeLineUI.f(BizTimeLineUI.this) == null) || (BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition() != 0) || (BizTimeLineUI.r(BizTimeLineUI.this) == null))
        {
          AppMethodBeat.o(209513);
          return;
        }
        BizTimeLineUI.r(BizTimeLineUI.this).bON();
        AppMethodBeat.o(209513);
      }
    }, 500L);
    k.a(this.oca);
    try
    {
      bh.a(this, this);
      localObject = this.obR.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.webcanvas.c)((Iterator)localObject).next()).onResume();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w("MicroMsg.BizTimeLineUI", "setScreenShotCallback fail e:%s", new Object[] { localException.getMessage() });
      }
      AppMethodBeat.o(5980);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void tn(long paramLong)
  {
    AppMethodBeat.i(209524);
    g.a locala = (g.a)this.oaB.obm.get(paramLong + "_0");
    if (locala != null)
    {
      locala.FIF = 1;
      ad.d("MicroMsg.BizTimeLineReport", "onClick msgId=%d, pos=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(0) });
    }
    AppMethodBeat.o(209524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI
 * JD-Core Version:    0.7.0.1
 */