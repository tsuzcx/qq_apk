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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.a.h;
import com.tencent.mm.pluginsdk.model.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x.3;
import com.tencent.mm.storage.x.a;
import com.tencent.mm.storage.x.c;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.ap;
import com.tencent.mm.ui.s;
import java.lang.ref.WeakReference;
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
  implements i, com.tencent.mm.plugin.webcanvas.e, bi.a
{
  private static long ohu = 0L;
  private static int ohv = 0;
  private static int ohw = 0;
  private int dmM;
  private int doj;
  private boolean dus;
  private TextView emptyTipTv;
  private int fMX;
  private View jil;
  private long mSi;
  private int nuk;
  private View ogP;
  BizTimeLineHotView ogh;
  private boolean ogp;
  private g ogr;
  private int ohA;
  private int ohB;
  private int ohC;
  private HashSet<String> ohD;
  private final Set<com.tencent.mm.plugin.webcanvas.f> ohE;
  private final Set<com.tencent.mm.plugin.webcanvas.d> ohF;
  private x.c ohG;
  private com.tencent.mm.sdk.b.c ohH;
  private long ohI;
  private final long ohJ;
  private boolean ohK;
  private List<w> ohL;
  private boolean ohM;
  private com.tencent.mm.sdk.b.c ohN;
  private com.tencent.mm.pluginsdk.ui.span.h ohO;
  public StoryListView ohl;
  private View ohm;
  private ImageView ohn;
  LinearLayout oho;
  private TextView ohp;
  private TextView ohq;
  private View ohr;
  private b ohs;
  private e oht;
  private long ohx;
  private long ohy;
  private boolean ohz;
  
  public BizTimeLineUI()
  {
    AppMethodBeat.i(5965);
    this.ohx = 0L;
    this.ohy = 0L;
    this.mSi = 0L;
    this.doj = 1;
    this.ohz = false;
    this.ogp = false;
    this.dus = false;
    this.ohA = 0;
    this.ohB = -1;
    this.ohC = -1;
    this.ohD = new HashSet();
    this.ohE = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ohF = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ohG = new x.c()
    {
      public final void a(Object paramAnonymousObject, x.a paramAnonymousa)
      {
        AppMethodBeat.i(5955);
        BizTimeLineUI.this.bPm();
        AppMethodBeat.o(5955);
      }
    };
    this.ohH = new BizTimeLineUI.13(this);
    this.ohI = 0L;
    this.ohJ = 100L;
    this.ohK = false;
    this.ohL = new LinkedList();
    this.ohM = false;
    this.nuk = -1;
    this.ohN = new BizTimeLineUI.9(this);
    this.ohO = new BizTimeLineUI.10(this);
    AppMethodBeat.o(5965);
  }
  
  private void bPp()
  {
    AppMethodBeat.i(5976);
    if ((this.ohs == null) || (this.dus))
    {
      AppMethodBeat.o(5976);
      return;
    }
    if (this.ohs.mMj.size() > 0)
    {
      final long l1 = ((w)this.ohs.mMj.get(0)).field_orderFlag;
      int j = ag.aGv().DR(l1);
      int i = j;
      if (j > 0)
      {
        long l2 = ag.aGv().fts();
        i = j;
        if (ag.aGv().DW(l2 << 32) != null) {
          i = j - 1;
        }
      }
      ae.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        setMMTitleVisibility(8);
        if (this.ohm.getVisibility() == 8) {
          this.ohm.setVisibility(4);
        }
        this.ohq.setText(getString(2131756635, new Object[] { Integer.valueOf(i) }));
        this.ohm.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5950);
            if (ag.aGv().DR(l1) <= 0)
            {
              BizTimeLineUI.this.setMMTitleVisibility(0);
              AppMethodBeat.o(5950);
              return;
            }
            float f1 = BizTimeLineUI.o(BizTimeLineUI.this).getX();
            int i = (int)((BizTimeLineUI.o(BizTimeLineUI.this).getWidth() + (f1 + f1)) / 2.0F);
            int j = com.tencent.mm.cb.a.iu(BizTimeLineUI.this.getContext()) / 2;
            if (i != j)
            {
              float f2 = j - i + f1;
              BizTimeLineUI.o(BizTimeLineUI.this).setX(f2);
              ae.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView x = %f, new x=%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
            }
            if (BizTimeLineUI.o(BizTimeLineUI.this).getVisibility() != 0) {
              BizTimeLineUI.o(BizTimeLineUI.this).setVisibility(0);
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
    this.ohm.setVisibility(8);
    setMMTitleVisibility(0);
    AppMethodBeat.o(5976);
  }
  
  private static int bPr()
  {
    if (ohw > 0) {
      return ohw - 1;
    }
    return 0;
  }
  
  private static void cp(List<w> paramList)
  {
    AppMethodBeat.i(5984);
    if (!bu.ht(paramList))
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((w)localIterator.next()).field_isRead = 1;
      }
      localLinkedList.addAll(paramList);
      ag.aGv().hz(localLinkedList);
    }
    AppMethodBeat.o(5984);
  }
  
  private void dB(View paramView)
  {
    AppMethodBeat.i(5982);
    paramView = paramView.getTag(2131297288);
    if ((paramView instanceof String)) {
      this.ohD.add((String)paramView);
    }
    AppMethodBeat.o(5982);
  }
  
  private void e(final w paramw)
  {
    AppMethodBeat.i(5971);
    this.ohl.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208474);
        BizTimeLineUI.c(BizTimeLineUI.this).ogp = false;
        BizTimeLineUI.j(BizTimeLineUI.this);
        int i = Math.max(0, BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.f(BizTimeLineUI.this).getHeaderViewsCount());
        BizTimeLineUI.c(BizTimeLineUI.this).b(paramw);
        BizTimeLineUI.c(BizTimeLineUI.this).b(BizTimeLineUI.c(BizTimeLineUI.this).zz(i));
        BizTimeLineUI.k(BizTimeLineUI.this);
        ae.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(208474);
      }
    }, 50L);
    AppMethodBeat.o(5971);
  }
  
  private void eQ(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(5983);
    if ((paramInt1 == 0) && (!this.ogp) && (ohw != paramInt1)) {
      this.ogh.bPL();
    }
    if ((this.ogp) || (this.ohM) || ((ohw == paramInt1) && (this.nuk == paramInt2)))
    {
      AppMethodBeat.o(5983);
      return;
    }
    this.nuk = paramInt2;
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
        w localw = this.ohs.zz(paramInt1);
        if ((localw != null) && (localw.field_isRead != 1)) {
          localLinkedList.add(localw);
        }
        paramInt1 += 1;
      }
      paramInt1 = 0;
    }
    this.ohL.removeAll(localLinkedList);
    cp(this.ohL);
    this.ohL.clear();
    this.ohL.addAll(localLinkedList);
    AppMethodBeat.o(5983);
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(208481);
    paramString = this.ohE.iterator();
    while (paramString.hasNext()) {
      ((com.tencent.mm.plugin.webcanvas.f)paramString.next()).bZK();
    }
    AppMethodBeat.o(208481);
  }
  
  public final void a(com.tencent.mm.plugin.webcanvas.d paramd)
  {
    AppMethodBeat.i(208479);
    if (!this.ohF.contains(this.ohF)) {
      this.ohF.add(paramd);
    }
    AppMethodBeat.o(208479);
  }
  
  public final void a(com.tencent.mm.plugin.webcanvas.f paramf)
  {
    AppMethodBeat.i(208477);
    if (!this.ohE.contains(paramf)) {
      this.ohE.add(paramf);
    }
    AppMethodBeat.o(208477);
  }
  
  public final void b(com.tencent.mm.plugin.webcanvas.f paramf)
  {
    AppMethodBeat.i(208478);
    this.ohE.remove(paramf);
    AppMethodBeat.o(208478);
  }
  
  public final void bPl()
  {
    AppMethodBeat.i(5978);
    if (this.ohs != null) {
      this.ohs.notifyDataSetChanged();
    }
    AppMethodBeat.o(5978);
  }
  
  public final void bPm()
  {
    AppMethodBeat.i(5968);
    if (isFinishing())
    {
      AppMethodBeat.o(5968);
      return;
    }
    int i = ag.aGw().bVY();
    if (i > 0)
    {
      this.oho.setVisibility(0);
      this.ohp.setText(getString(2131756629, new Object[] { Integer.valueOf(i) }));
      w localw = ag.aGw().ftJ();
      Object localObject;
      if (localw != null)
      {
        this.ohn.setVisibility(0);
        if (localw.ftd())
        {
          localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(localw.field_talker);
          if ((localObject != null) && (com.tencent.mm.contact.c.lO(((aw)localObject).field_type))) {
            break label244;
          }
          if (localw.fti() != null)
          {
            localObject = new c.a();
            ((c.a)localObject).igv = 2131231875;
            ((c.a)localObject).igj = true;
            com.tencent.mm.av.q.aJb().a(localw.fti().hGI, this.ohn, ((c.a)localObject).aJu());
          }
          y.DZ(localw.field_msgId);
        }
      }
      for (;;)
      {
        if ((this.ohs != null) && (this.ohs.getCount() == 0)) {
          this.ohs.notifyDataSetChanged();
        }
        AppMethodBeat.o(5968);
        return;
        if (localw.fte())
        {
          localObject = ab.v(localw);
          if (!bu.isNullOrNil((String)localObject))
          {
            a.b.c(this.ohn, (String)localObject);
            break;
          }
        }
        label244:
        a.b.c(this.ohn, localw.field_talker);
        break;
        this.ohn.setVisibility(8);
      }
    }
    this.oho.setVisibility(8);
    AppMethodBeat.o(5968);
  }
  
  public final void bPn()
  {
    AppMethodBeat.i(5974);
    if ((!isFinishing()) && (this.ogP != null))
    {
      ((View)$(2131297351)).setVisibility(8);
      ((View)$(2131297359)).setVisibility(0);
      ((TextView)$(2131297358)).setText(getString(2131756626));
    }
    AppMethodBeat.o(5974);
  }
  
  public final void bPo()
  {
    AppMethodBeat.i(5975);
    long l = System.currentTimeMillis() - this.ohI;
    if ((this.ohK) && (l < 200L))
    {
      ae.d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
      AppMethodBeat.o(5975);
      return;
    }
    ae.d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.ohK), Long.valueOf(l) });
    this.ohK = true;
    if (l < 100L)
    {
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208464);
          BizTimeLineUI.n(BizTimeLineUI.this);
          if (!BizTimeLineUI.this.isFinishing())
          {
            BizTimeLineUI.this.bPo();
            AppMethodBeat.o(208464);
            return;
          }
          ae.w("MicroMsg.BizTimeLineUI", "Activity is finished!!!");
          AppMethodBeat.o(208464);
        }
      }, 100L);
      AppMethodBeat.o(5975);
      return;
    }
    bPp();
    this.ohI = System.currentTimeMillis();
    this.ohK = false;
    AppMethodBeat.o(5975);
  }
  
  public final void bPq()
  {
    AppMethodBeat.i(5977);
    ae.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
    bPo();
    AppMethodBeat.o(5977);
  }
  
  public int getLayoutId()
  {
    return 2131493203;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5966);
    y.wW(true);
    com.tencent.mm.plugin.brandservice.b.b.init();
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(2131299468));
    this.emptyTipTv.setText(2131756606);
    this.oht = new e(this);
    paramBundle = this.oht;
    com.tencent.mm.sdk.b.a.IvT.c(paramBundle.kzS);
    this.dmM = ((int)(System.currentTimeMillis() / 1000L));
    this.doj = getIntent().getIntExtra("biz_enter_source", 1);
    this.ogr = new g(this.dmM);
    y.Ap(this.dmM);
    paramBundle = o.oyo;
    o.Ap(this.dmM);
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208461);
        if ((BizTimeLineUI.this.activityHasDestroyed()) || (BizTimeLineUI.this.isFinishing()))
        {
          AppMethodBeat.o(208461);
          return;
        }
        BizTimeLineUI.m(BizTimeLineUI.this);
        AppMethodBeat.o(208461);
      }
    });
    paramBundle = com.tencent.mm.model.c.d.aDI().xi("100045");
    boolean bool;
    final int i;
    if ((paramBundle.isValid()) && ("1".equals(paramBundle.fsy().get("isOpenSearch"))))
    {
      bool = true;
      ae.d("MicroMsg.BizTimeLineUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        addIconOptionMenu(0, 2131764452, 2131689494, new BizTimeLineUI.18(this));
      }
      addIconOptionMenu(1, 2131756636, 2131689505, new MenuItem.OnMenuItemClickListener()new BizTimeLineUI.2
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(208476);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.addFlags(67108864);
          paramAnonymousMenuItem.putExtra("biz_from_scene", 2);
          paramAnonymousMenuItem.putExtra("biz_time_line_line_session_id", BizTimeLineUI.b(BizTimeLineUI.this));
          paramAnonymousMenuItem.putExtra("biz_enter_source", BizTimeLineUI.i(BizTimeLineUI.this));
          com.tencent.mm.br.d.f(BizTimeLineUI.this, ".ui.conversation.NewBizConversationUI", paramAnonymousMenuItem);
          BizTimeLineUI.a(BizTimeLineUI.this).zB(7);
          BizTimeLineUI.l(BizTimeLineUI.this);
          AppMethodBeat.o(208476);
          return true;
        }
      }, new BizTimeLineUI.2(this));
      setMMTitle(2131756642);
      setMMTitleColor(getContext().getResources().getColor(2131099732));
      setBackBtn(new BizTimeLineUI.4(this), 2131689490);
      this.ohm = getLayoutInflater().inflate(2131493202, null);
      this.ohq = ((TextView)this.ohm.findViewById(2131297369));
      this.ohq.setTextSize(1, 14.0F);
      this.ohr = this.ohm.findViewById(2131297368);
      ((LinearLayout)getController().mActionBar.getCustomView()).addView(this.ohm);
      paramBundle = (LinearLayout.LayoutParams)this.ohm.getLayoutParams();
      paramBundle.width = -1;
      paramBundle.weight = 1.0F;
      this.ohm.setLayoutParams(paramBundle);
      this.ohr.setOnClickListener(new BizTimeLineUI.5(this));
      this.ohm.setVisibility(8);
      this.ohl = ((StoryListView)$(2131297354));
      paramBundle = this.ohl;
      this.ogP = getLayoutInflater().inflate(2131493205, null);
      paramBundle.addFooterView(this.ogP);
      paramBundle = this.ohl;
      this.jil = getLayoutInflater().inflate(2131493206, null);
      this.ogh = ((BizTimeLineHotView)this.jil.findViewById(2131297334));
      paramBundle.addHeaderView(this.jil);
      i = ohw;
      if (!y.ftD()) {
        break label994;
      }
      paramBundle = ag.aGv().DO(y.IJn);
      this.ogp = true;
      com.tencent.mm.plugin.brandservice.ui.b.c.cy(paramBundle);
    }
    for (;;)
    {
      ae.i("MicroMsg.BizTimeLineUI", "initListView keep %b", new Object[] { Boolean.valueOf(this.ogp) });
      this.ohs = new b(this, paramBundle, this.ogp, this.ogr, this.ogh);
      this.ogr.oha = bPr();
      this.oho = ((LinearLayout)$(2131302793));
      this.ohp = ((TextView)$(2131302794));
      this.ohn = ((ImageView)$(2131302792));
      bPm();
      this.oho.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(5944);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = "";
          localObject = ag.aGw().ftJ();
          if (localObject != null) {
            paramAnonymousView = ab.v((w)localObject);
          }
          for (int i = ab.d((w)localObject);; i = 0)
          {
            localObject = BizTimeLineUI.a(BizTimeLineUI.this);
            com.tencent.mm.plugin.report.service.g.yxI.f(15721, new Object[] { paramAnonymousView, "", Integer.valueOf(12), Integer.valueOf(-1), Integer.valueOf(((g)localObject).dmM), "", "", "", Integer.valueOf(0), "", "", "", "", "", "", "", "", "", Integer.valueOf(i) });
            localObject = new Intent(BizTimeLineUI.this.getContext(), BizTimeLineNewMsgUI.class);
            ((Intent)localObject).putExtra("biz_time_line_line_session_id", BizTimeLineUI.b(BizTimeLineUI.this));
            ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 1);
            paramAnonymousView = BizTimeLineUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(5944);
            return;
          }
        }
      });
      this.ohl.setAdapter(this.ohs);
      this.ohl.setFooterDividersEnabled(false);
      this.ohl.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(208470);
          paramAnonymousAbsListView = BizTimeLineUI.e(BizTimeLineUI.this).iterator();
          while (paramAnonymousAbsListView.hasNext()) {
            ((com.tencent.mm.plugin.webcanvas.f)paramAnonymousAbsListView.next()).eOV();
          }
          BizTimeLineUI.a(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousAbsListView = com.tencent.mm.pluginsdk.ui.applet.g.FnF;
          if (com.tencent.mm.pluginsdk.ui.applet.g.Zv(1)) {
            BizTimeLineUI.b(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt2 - 1);
          }
          BizTimeLineUI.zC(paramAnonymousInt1);
          AppMethodBeat.o(208470);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(208469);
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
            ae.i("MicroMsg.BizTimeLineUI", "summer hardcoder biz startPerformance [%s] [%s]", new Object[] { Integer.valueOf(903), Integer.valueOf(BizTimeLineUI.d(BizTimeLineUI.this)) });
            paramAnonymousAbsListView = BizTimeLineUI.e(BizTimeLineUI.this).iterator();
            while (paramAnonymousAbsListView.hasNext()) {
              ((com.tencent.mm.plugin.webcanvas.f)paramAnonymousAbsListView.next()).eOU();
            }
          }
          com.tencent.mm.plugin.brandservice.ui.b.a.bTv();
          com.tencent.mm.av.q.aJb().cp(paramAnonymousInt);
          if ((paramAnonymousInt == 0) || (paramAnonymousInt == 1))
          {
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.a.Fdw;
            if (com.tencent.mm.pluginsdk.model.a.Fdu) {
              com.tencent.mm.pluginsdk.model.a.t((Runnable)new a.h(System.currentTimeMillis()));
            }
          }
          for (;;)
          {
            if (paramAnonymousInt == 0)
            {
              BizTimeLineUI.c(BizTimeLineUI.this).eP(BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.f(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.f(BizTimeLineUI.this).getLastVisiblePosition());
              paramAnonymousAbsListView = MPVideoPreviewMgr.ovZ;
              MPVideoPreviewMgr.a("idle", BizTimeLineUI.f(BizTimeLineUI.this), BizTimeLineUI.c(BizTimeLineUI.this));
            }
            AppMethodBeat.o(208469);
            return;
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.a.Fdw;
            if (!com.tencent.mm.pluginsdk.model.a.Fdu) {
              com.tencent.mm.pluginsdk.model.a.t((Runnable)new a.l(System.currentTimeMillis()));
            }
          }
        }
      });
      this.ohl.setEmptyView(this.emptyTipTv);
      this.ohl.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208472);
          if ((BizTimeLineUI.g(BizTimeLineUI.this)) && (i != 0))
          {
            BizTimeLineUI.h(BizTimeLineUI.this);
            BizTimeLineUI.this.bPo();
          }
          if ((BizTimeLineUI.g(BizTimeLineUI.this)) && (i == 0)) {
            BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.c(BizTimeLineUI.this).zz(0));
          }
          if (!bu.ht(paramBundle))
          {
            long l = ((w)paramBundle.get(0)).field_orderFlag;
            g localg = BizTimeLineUI.a(BizTimeLineUI.this);
            int i = BizTimeLineUI.i(BizTimeLineUI.this);
            int j = BizTimeLineUI.this.getIntent().getIntExtra("Main_IndexInSessionList", 0);
            BizTimeLineUI.this.getIntent().getIntExtra("Main_UnreadCount", 0);
            com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new g.3(localg, l, i, j), 0L);
          }
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(208471);
              MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.ovZ;
              MPVideoPreviewMgr.a("init", BizTimeLineUI.f(BizTimeLineUI.this), BizTimeLineUI.c(BizTimeLineUI.this));
              AppMethodBeat.o(208471);
            }
          }, 100L);
          AppMethodBeat.o(208472);
        }
      }, 120L);
      this.ohl.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(208473);
          BizTimeLineUI.c(BizTimeLineUI.this).eP(BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.f(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.f(BizTimeLineUI.this).getLastVisiblePosition());
          BizTimeLineUI.f(BizTimeLineUI.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(208473);
        }
      });
      if (paramBundle.size() < 10) {
        bPn();
      }
      ag.aGw().a(this.ohG, Looper.getMainLooper());
      new d();
      ae.d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
      i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYn, Integer.valueOf(0))).intValue();
      if ((i & 0x4) == 0)
      {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVd("officialaccounts");
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYn, Integer.valueOf(i | 0x4));
      }
      com.tencent.mm.pluginsdk.h.r(this);
      this.ohx = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.IvT.c(this.ohN);
      this.ohH.alive();
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zm(90);
      }
      paramBundle = ag.aGv();
      if (paramBundle.IIM)
      {
        paramBundle.IIM = false;
        com.tencent.e.h.MqF.a(new x.3(paramBundle), 1000L, "BizTimeLineInfoStorageThread");
      }
      com.tencent.mm.plugin.brandservice.ui.b.a.bTt();
      com.tencent.mm.pluginsdk.ui.applet.g.ffZ();
      com.tencent.mm.api.b.Kl();
      com.tencent.mm.plugin.brandservice.b.b.bOr();
      paramBundle = com.tencent.mm.plugin.webcanvas.h.DQL;
      com.tencent.mm.plugin.webcanvas.h.ePb();
      paramBundle = com.tencent.mm.plugin.webcanvas.g.DQG;
      com.tencent.mm.plugin.webcanvas.g.CH(65L);
      AppMethodBeat.o(5966);
      return;
      bool = false;
      break;
      label994:
      this.ogp = false;
      paramBundle = ag.aGv().abn(10);
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll(paramBundle);
      com.tencent.mm.plugin.brandservice.ui.b.c.cB(localLinkedList);
      com.tencent.mm.plugin.brandservice.ui.b.c.a(localLinkedList, null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5979);
    super.onDestroy();
    ae.i("MicroMsg.BizTimeLineUI", "onDestroy %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ogh != null)
    {
      localObject1 = this.ogh;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().b((n.b)localObject1);
      com.tencent.mm.sdk.b.a.IvT.d(((BizTimeLineHotView)localObject1).omL);
      localObject3 = ((BizTimeLineHotView)localObject1).omp;
      Object localObject4 = new b.a();
      cej localcej = new cej();
      ((b.a)localObject4).hQF = localcej;
      ((b.a)localObject4).hQG = new cek();
      ((b.a)localObject4).uri = "/cgi-bin/micromsg-bin/often_read_bar_report";
      ((b.a)localObject4).funcId = 2550;
      localObject4 = ((b.a)localObject4).aDS();
      localcej.FXt = y.getSessionId();
      localcej.Hrj = ((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f)localObject3).ond;
      LinkedList localLinkedList = new LinkedList();
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f)localObject3).onc.size() > 0)
      {
        Iterator localIterator = ((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f)localObject3).onc.entrySet().iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add((cel)((Map.Entry)localIterator.next()).getValue());
        }
      }
      localcej.Hri = localLinkedList;
      com.tencent.mm.ak.x.a((com.tencent.mm.ak.b)localObject4, new f.1((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f)localObject3));
      com.tencent.mm.kernel.g.ajj().b(2768, (com.tencent.mm.ak.f)localObject1);
      ((BizTimeLineHotView)localObject1).omF.setAdapter(null);
      ((BizTimeLineHotView)localObject1).omF.omv.dead();
    }
    Object localObject1 = this.oht;
    com.tencent.mm.sdk.b.a.IvT.d(((e)localObject1).kzS);
    y.wW(false);
    y.IJm = System.currentTimeMillis();
    if ((this.ohs != null) && (this.ohl != null))
    {
      localObject1 = this.ohs.bPh();
      if (localObject1 != null) {
        y.IJn = ((w)localObject1).field_orderFlag;
      }
      localObject1 = this.ohs.zz(bPr());
      if (localObject1 == null) {
        break label621;
      }
      ohu = ((w)localObject1).field_orderFlag;
    }
    for (;;)
    {
      localObject1 = this.ohs;
      ag.aGv().a(((b)localObject1).obB);
      ((b)localObject1).ogi.ony.clear();
      ag.aGw().a(this.ohG);
      if (this.ohx != 0L)
      {
        l = System.currentTimeMillis();
        this.mSi += l - this.ohy;
        com.tencent.mm.plugin.report.service.g.yxI.f(13932, new Object[] { Integer.valueOf((int)(l - this.ohx) / 1000), Integer.valueOf(1), Integer.valueOf(this.dmM), Integer.valueOf((int)(this.mSi / 1000L)), Integer.valueOf(this.doj) });
      }
      com.tencent.mm.sdk.b.a.IvT.d(this.ohN);
      this.ohH.dead();
      this.ogr.ohb = bPr();
      com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new g.2(this.ogr), 0L);
      com.tencent.mm.plugin.brandservice.ui.b.b.clean();
      ap.clear();
      y.Ap(0);
      try
      {
        if ((getContentView() instanceof ViewGroup)) {
          ((ViewGroup)getContentView()).removeAllViews();
        }
        localObject1 = com.tencent.mm.pluginsdk.model.a.Fdw;
        com.tencent.mm.pluginsdk.model.a.fcZ();
        com.tencent.mm.plugin.brandservice.b.b.release();
        localObject1 = this.ohF.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((com.tencent.mm.plugin.webcanvas.d)((Iterator)localObject1).next()).onDestroy();
          continue;
          label621:
          ae.w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", new Object[] { Integer.valueOf(bPr()) });
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ae.w("MicroMsg.BizTimeLineUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
        }
        this.ohE.clear();
        this.ohF.clear();
        localObject2 = MPVideoPreviewMgr.ovZ;
        if (!MPVideoPreviewMgr.bSZ()) {
          break label873;
        }
      }
    }
    Object localObject2 = MPVideoPreviewMgr.ovS;
    Object localObject3 = MPVideoPreviewMgr.ovQ;
    if (localObject3 != null)
    {
      localObject3 = (AppBrandVideoView)((WeakReference)localObject3).get();
      if (localObject3 == null) {}
    }
    for (long l = ((AppBrandVideoView)localObject3).getCurrPosMs();; l = 0L)
    {
      ((MPVideoPreviewMgr.a)localObject2).owe = l;
      MPVideoPreviewMgr.ovS.md(4);
      MPVideoPreviewMgr.ovS.g(null);
      localObject2 = MPVideoPreviewMgr.ovS;
      ((MPVideoPreviewMgr.a)localObject2).g(null);
      ((MPVideoPreviewMgr.a)localObject2).aJg("IDLE");
      ((MPVideoPreviewMgr.a)localObject2).ajO = 0;
      ((MPVideoPreviewMgr.a)localObject2).owb.clear();
      ((MPVideoPreviewMgr.a)localObject2).Ae(0);
      ((MPVideoPreviewMgr.a)localObject2).owe = 0L;
      ((MPVideoPreviewMgr.a)localObject2).owf = 0L;
      ((MPVideoPreviewMgr.a)localObject2).owg = 0L;
      ((MPVideoPreviewMgr.a)localObject2).owh = 0L;
      ((MPVideoPreviewMgr.a)localObject2).owi = 0L;
      localObject2 = MPVideoPreviewMgr.ovQ;
      if (localObject2 != null)
      {
        localObject2 = (AppBrandVideoView)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          ((AppBrandVideoView)localObject2).onUIDestroy();
        }
      }
      MPVideoPreviewMgr.ovU = "";
      MPVideoPreviewMgr.ovW = null;
      MPVideoPreviewMgr.ovO = null;
      MPVideoPreviewMgr.ovP = null;
      MPVideoPreviewMgr.ovQ = null;
      MPVideoPreviewMgr.ovR = null;
      MPVideoPreviewMgr.tRG = null;
      MPVideoPreviewMgr.vVI.clear();
      MPVideoPreviewMgr.stopTimer();
      MPVideoPreviewMgr.vVH = null;
      label873:
      AppMethodBeat.o(5979);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5981);
    super.onPause();
    if (this.ohs != null)
    {
      localObject = this.ohs;
      ((b)localObject).ogo.stopPlay();
      ((b)localObject).dus = true;
      ((b)localObject).ogi.onB = true;
    }
    for (Object localObject = this.ohs.bPi();; localObject = null)
    {
      cp(this.ohL);
      int i;
      if (localObject != null)
      {
        ag.aGv().DS(((w)localObject).field_orderFlag);
        if (this.ohl == null) {
          break label240;
        }
        localObject = this.ohl.getChildAt(0);
        if (localObject == null) {
          break label235;
        }
        i = ((View)localObject).getTop();
      }
      label106:
      label235:
      label240:
      for (ohv = i;; ohv = 0)
      {
        this.dus = true;
        long l = System.currentTimeMillis();
        this.mSi += l - this.ohy;
        this.ohy = l;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBizEnable, this.fMX);
        this.fMX = 0;
        k.b(this.ohO);
        localObject = com.tencent.mm.pluginsdk.ui.applet.g.FnF;
        if (com.tencent.mm.pluginsdk.ui.applet.g.Zv(1))
        {
          localObject = com.tencent.mm.pluginsdk.model.a.Fdw;
          com.tencent.mm.pluginsdk.model.a.fda();
        }
        bi.a(this, null);
        localObject = this.ohF.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.webcanvas.d)((Iterator)localObject).next()).onPause();
        }
        ag.aGv().ftq();
        break;
        i = 0;
        break label106;
      }
      localObject = MPVideoPreviewMgr.ovZ;
      MPVideoPreviewMgr.aII("ONPAUSE");
      AppMethodBeat.o(5981);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5980);
    super.onResume();
    if (this.ohz)
    {
      this.ohz = false;
      this.ogr.zB(8);
    }
    Object localObject;
    if (this.ohs != null)
    {
      localObject = this.ohs;
      ((b)localObject).dus = false;
      localObject = ((b)localObject).ogi;
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).onB)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).onB = false;
        if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).onv <= 0) {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).bPV();
        }
      }
    }
    if (this.dus)
    {
      this.dus = false;
      bPo();
    }
    this.ohy = System.currentTimeMillis();
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208468);
        if ((BizTimeLineUI.this.isFinishing()) || (BizTimeLineUI.f(BizTimeLineUI.this) == null) || (BizTimeLineUI.f(BizTimeLineUI.this).getFirstVisiblePosition() != 0) || (BizTimeLineUI.r(BizTimeLineUI.this) == null))
        {
          AppMethodBeat.o(208468);
          return;
        }
        BizTimeLineUI.r(BizTimeLineUI.this).bPL();
        AppMethodBeat.o(208468);
      }
    }, 500L);
    k.a(this.ohO);
    try
    {
      bi.a(this, this);
      localObject = this.ohF.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.webcanvas.d)((Iterator)localObject).next()).onResume();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.w("MicroMsg.BizTimeLineUI", "setScreenShotCallback fail e:%s", new Object[] { localException.getMessage() });
      }
      MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.ovZ;
      MPVideoPreviewMgr.aII("ONRESUME");
      AppMethodBeat.o(5980);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void tB(long paramLong)
  {
    AppMethodBeat.i(208480);
    g.a locala = (g.a)this.ogr.ohc.get(paramLong + "_0");
    if (locala != null)
    {
      locala.Gbc = 1;
      ae.d("MicroMsg.BizTimeLineReport", "onClick msgId=%d, pos=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(0) });
    }
    AppMethodBeat.o(208480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI
 * JD-Core Version:    0.7.0.1
 */