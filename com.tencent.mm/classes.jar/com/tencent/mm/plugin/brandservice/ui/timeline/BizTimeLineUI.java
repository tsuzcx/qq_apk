package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.a.k;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e.1;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bhb;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r.7;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.an;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@i
public class BizTimeLineUI
  extends MMActivity
  implements h
{
  private static long jWS = 0L;
  private static long jWT = 0L;
  private static long jWU = 0L;
  private static int jWV = 0;
  private static int jWW = 0;
  private int cnU;
  private int cpt;
  private boolean cvo;
  private int eez;
  private TextView emptyTipTv;
  private View gyT;
  private long iWu;
  BizTimeLineHotView jVI;
  private boolean jVQ;
  private f jVS;
  public StoryListView jWJ;
  private View jWK;
  private ImageView jWL;
  LinearLayout jWM;
  private TextView jWN;
  private TextView jWO;
  private View jWP;
  private a jWQ;
  private d jWR;
  private long jWX;
  private long jWY;
  private boolean jWZ;
  private View jWo;
  private r.c jXa;
  private long jXb;
  private final long jXc;
  private boolean jXd;
  private List<com.tencent.mm.storage.q> jXe;
  private boolean jXf;
  private com.tencent.mm.sdk.b.c jXg;
  private int jwq;
  
  public BizTimeLineUI()
  {
    AppMethodBeat.i(14203);
    this.jWX = 0L;
    this.jWY = 0L;
    this.iWu = 0L;
    this.cpt = 1;
    this.jWZ = false;
    this.jVQ = false;
    this.cvo = false;
    this.jXa = new BizTimeLineUI.11(this);
    this.jXb = 0L;
    this.jXc = 100L;
    this.jXd = false;
    this.jXe = new LinkedList();
    this.jXf = false;
    this.jwq = -1;
    this.jXg = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(14203);
  }
  
  private void aU(List<com.tencent.mm.storage.q> paramList)
  {
    AppMethodBeat.i(14208);
    Looper.myQueue().addIdleHandler(new BizTimeLineUI.16(this, paramList));
    AppMethodBeat.o(14208);
  }
  
  private static void aV(List<com.tencent.mm.storage.q> paramList)
  {
    AppMethodBeat.i(14221);
    if (!bo.es(paramList))
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.storage.q)localIterator.next()).field_isRead = 1;
      }
      localLinkedList.addAll(paramList);
      com.tencent.mm.aj.z.afo().ew(localLinkedList);
    }
    AppMethodBeat.o(14221);
  }
  
  private void aWO()
  {
    AppMethodBeat.i(14205);
    this.jWM = ((LinearLayout)$(2131821862));
    this.jWN = ((TextView)$(2131821864));
    this.jWL = ((ImageView)$(2131821863));
    aWP();
    this.jWM.setOnClickListener(new BizTimeLineUI.1(this));
    AppMethodBeat.o(14205);
  }
  
  private void aWQ()
  {
    AppMethodBeat.i(14207);
    this.jWJ = ((StoryListView)$(2131821851));
    this.jWJ.addFooterView(getFooterView());
    this.jWJ.addHeaderView(getHeaderView());
    int i = jWW;
    long l = System.currentTimeMillis();
    int j = com.tencent.mm.m.g.Nq().getInt("BizTimeLineStayTime", 180) * 1000;
    List localList;
    if ((jWS != 0L) && (jWT != 0L) && (l - jWS < j))
    {
      localList = com.tencent.mm.aj.z.afo().oa(jWT);
      this.jVQ = true;
    }
    for (;;)
    {
      ab.i("MicroMsg.BizTimeLineUI", "initListView stayTime %d %d/%d  orderFlag %d, keep %b", new Object[] { Integer.valueOf(j), Long.valueOf(jWS), Long.valueOf(l), Long.valueOf(jWT), Boolean.valueOf(this.jVQ) });
      this.jWQ = new a(this, localList, this.jVQ, this.jVS, this.jVI);
      this.jVS.jWy = aWV();
      aWO();
      this.jWJ.setAdapter(this.jWQ);
      this.jWJ.setFooterDividersEnabled(false);
      this.jWJ.setOnScrollListener(new BizTimeLineUI.13(this));
      this.jWJ.setEmptyView(this.emptyTipTv);
      this.jWJ.postDelayed(new BizTimeLineUI.14(this, i, localList), 100L);
      this.jWJ.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(14199);
          BizTimeLineUI.c(BizTimeLineUI.this).dI(BizTimeLineUI.b(BizTimeLineUI.this).getFirstVisiblePosition(), BizTimeLineUI.b(BizTimeLineUI.this).getLastVisiblePosition());
          BizTimeLineUI.b(BizTimeLineUI.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(14199);
        }
      });
      if (localList.size() < 10) {
        aWR();
      }
      com.tencent.mm.aj.z.afp().a(this.jXa, Looper.getMainLooper());
      AppMethodBeat.o(14207);
      return;
      this.jVQ = false;
      localList = com.tencent.mm.aj.z.afo().dwb();
      aU(localList);
    }
  }
  
  private void aWT()
  {
    AppMethodBeat.i(14214);
    if ((this.jWQ == null) || (this.cvo))
    {
      AppMethodBeat.o(14214);
      return;
    }
    if (this.jWQ.iQp.size() > 0)
    {
      long l = ((com.tencent.mm.storage.q)this.jWQ.iQp.get(0)).field_orderFlag;
      int i = com.tencent.mm.aj.z.afo().od(l);
      ab.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        setMMTitleVisibility(8);
        if (this.jWK.getVisibility() == 8) {
          this.jWK.setVisibility(4);
        }
        this.jWO.setText(getString(2131297719, new Object[] { Integer.valueOf(i) }));
        this.jWK.post(new BizTimeLineUI.7(this, l));
        AppMethodBeat.o(14214);
      }
    }
    else
    {
      AppMethodBeat.o(14214);
      return;
    }
    this.jWK.setVisibility(8);
    setMMTitleVisibility(0);
    AppMethodBeat.o(14214);
  }
  
  private static int aWV()
  {
    if (jWW > 0) {
      return jWW - 1;
    }
    return 0;
  }
  
  private void d(com.tencent.mm.storage.q paramq)
  {
    AppMethodBeat.i(14209);
    this.jWJ.postDelayed(new BizTimeLineUI.17(this, paramq), 50L);
    AppMethodBeat.o(14209);
  }
  
  private void dJ(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(14220);
    if ((paramInt1 == 0) && (!this.jVQ) && (jWW != paramInt1)) {
      this.jVI.aWZ();
    }
    if ((this.jVQ) || (this.jXf) || ((jWW == paramInt1) && (this.jwq == paramInt2)))
    {
      AppMethodBeat.o(14220);
      return;
    }
    this.jwq = paramInt2;
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
        com.tencent.mm.storage.q localq = this.jWQ.se(paramInt1);
        if ((localq != null) && (localq.field_isRead != 1)) {
          localLinkedList.add(localq);
        }
        paramInt1 += 1;
      }
      paramInt1 = 0;
    }
    this.jXe.removeAll(localLinkedList);
    aV(this.jXe);
    this.jXe.clear();
    this.jXe.addAll(localLinkedList);
    AppMethodBeat.o(14220);
  }
  
  private View getFooterView()
  {
    AppMethodBeat.i(14210);
    this.jWo = getLayoutInflater().inflate(2130968869, null);
    View localView = this.jWo;
    AppMethodBeat.o(14210);
    return localView;
  }
  
  private View getHeaderView()
  {
    AppMethodBeat.i(14211);
    this.gyT = getLayoutInflater().inflate(2130968870, null);
    this.jVI = ((BizTimeLineHotView)this.gyT.findViewById(2131821861));
    View localView = this.gyT;
    AppMethodBeat.o(14211);
    return localView;
  }
  
  public final void aWN()
  {
    AppMethodBeat.i(14216);
    if (this.jWQ != null) {
      this.jWQ.notifyDataSetChanged();
    }
    AppMethodBeat.o(14216);
  }
  
  public final void aWP()
  {
    AppMethodBeat.i(14206);
    if (isFinishing())
    {
      AppMethodBeat.o(14206);
      return;
    }
    int i = com.tencent.mm.aj.z.afp().bbZ();
    if (i > 0)
    {
      this.jWM.setVisibility(0);
      this.jWN.setText(getString(2131297713, new Object[] { Integer.valueOf(i) }));
      com.tencent.mm.storage.q localq = com.tencent.mm.aj.z.afp().dwl();
      if (localq != null)
      {
        this.jWL.setVisibility(0);
        a.b.c(this.jWL, localq.field_talker);
        s.oj(localq.field_msgId);
      }
      for (;;)
      {
        if ((this.jWQ != null) && (this.jWQ.getCount() == 0)) {
          this.jWQ.notifyDataSetChanged();
        }
        AppMethodBeat.o(14206);
        return;
        this.jWL.setVisibility(8);
      }
    }
    this.jWM.setVisibility(8);
    AppMethodBeat.o(14206);
  }
  
  public final void aWR()
  {
    AppMethodBeat.i(14212);
    if ((!isFinishing()) && (this.jWo != null))
    {
      ((View)$(2131821856)).setVisibility(8);
      ((View)$(2131821859)).setVisibility(0);
      ((TextView)$(2131821860)).setText(getString(2131297710));
    }
    AppMethodBeat.o(14212);
  }
  
  public final void aWS()
  {
    AppMethodBeat.i(14213);
    long l = System.currentTimeMillis() - this.jXb;
    if ((this.jXd) && (l < 200L))
    {
      ab.d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
      AppMethodBeat.o(14213);
      return;
    }
    ab.d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.jXd), Long.valueOf(l) });
    this.jXd = true;
    if (l < 100L)
    {
      al.p(new BizTimeLineUI.6(this), 100L);
      AppMethodBeat.o(14213);
      return;
    }
    aWT();
    this.jXb = System.currentTimeMillis();
    this.jXd = false;
    AppMethodBeat.o(14213);
  }
  
  public final void aWU()
  {
    AppMethodBeat.i(14215);
    ab.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
    aWS();
    AppMethodBeat.o(14215);
  }
  
  public int getLayoutId()
  {
    return 2130968867;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(14204);
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(2131821852));
    this.emptyTipTv.setText(2131297690);
    this.jWR = new d(this);
    paramBundle = this.jWR;
    com.tencent.mm.sdk.b.a.ymk.c(paramBundle.hCe);
    this.cnU = ((int)(System.currentTimeMillis() / 1000L));
    this.cpt = getIntent().getIntExtra("biz_enter_source", 1);
    this.jVS = new f(this.cnU);
    s.Np(this.cnU);
    setActionbarColor(-1052684);
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14185);
        if ((BizTimeLineUI.this.activityHasDestroyed()) || (BizTimeLineUI.this.isFinishing()))
        {
          AppMethodBeat.o(14185);
          return;
        }
        BizTimeLineUI.m(BizTimeLineUI.this);
        AppMethodBeat.o(14185);
      }
    });
    paramBundle = com.tencent.mm.model.c.c.abU().me("100045");
    boolean bool;
    if ((paramBundle.isValid()) && ("1".equals(paramBundle.dvN().get("isOpenSearch"))))
    {
      bool = true;
      ab.d("MicroMsg.BizTimeLineUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        addIconOptionMenu(0, 2131304318, 2131230741, new BizTimeLineUI.18(this));
      }
      addIconOptionMenu(1, 2131297720, 2131230752, new BizTimeLineUI.2(this));
      setMMTitle(2131297724);
      setMMTitleColor(-16777216);
      setBackBtn(new BizTimeLineUI.4(this), 2131230737);
      this.jWK = getLayoutInflater().inflate(2130968866, null);
      this.jWO = ((TextView)this.jWK.findViewById(2131821850));
      this.jWO.setTextSize(1, 14.0F);
      this.jWP = this.jWK.findViewById(2131821849);
      ((LinearLayout)getController().mActionBar.getCustomView()).addView(this.jWK);
      paramBundle = (LinearLayout.LayoutParams)this.jWK.getLayoutParams();
      paramBundle.width = -1;
      paramBundle.weight = 1.0F;
      this.jWK.setLayoutParams(paramBundle);
      this.jWP.setOnClickListener(new BizTimeLineUI.5(this));
      this.jWK.setVisibility(8);
      paramBundle = new c();
      if (!c.aWM()) {
        break label598;
      }
      aWQ();
    }
    for (;;)
    {
      ab.d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
      int i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKe, Integer.valueOf(0))).intValue();
      if ((i & 0x4) == 0)
      {
        ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arK("officialaccounts");
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKe, Integer.valueOf(i | 0x4));
      }
      com.tencent.mm.pluginsdk.f.n(this);
      this.jWX = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.ymk.c(this.jXg);
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rU(1)) {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rV(90);
      }
      paramBundle = com.tencent.mm.aj.z.afo();
      if (paramBundle.ywF)
      {
        paramBundle.ywF = false;
        com.tencent.mm.sdk.g.d.ysm.b(new r.7(paramBundle), "BizTimeLineInfoStorageThread", 1000L);
      }
      com.tencent.mm.plugin.brandservice.ui.b.a.aZV();
      AppMethodBeat.o(14204);
      return;
      bool = false;
      break;
      label598:
      getString(2131297087);
      com.tencent.mm.sdk.g.d.post(new c.1(paramBundle, new BizTimeLineUI.12(this, com.tencent.mm.ui.base.h.b(this, getString(2131297112), false, null))), "BizTimeLineMigrateThread");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(14217);
    super.onDestroy();
    Object localObject1 = this.jWR;
    com.tencent.mm.sdk.b.a.ymk.d(((d)localObject1).hCe);
    jWS = System.currentTimeMillis();
    if ((this.jWQ != null) && (this.jWJ != null))
    {
      localObject1 = this.jWQ.aWH();
      if (localObject1 != null) {
        jWT = ((com.tencent.mm.storage.q)localObject1).field_orderFlag;
      }
      localObject1 = this.jWQ.se(aWV());
      if (localObject1 == null) {
        break label468;
      }
      jWU = ((com.tencent.mm.storage.q)localObject1).field_orderFlag;
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e locale;
    Object localObject2;
    bhb localbhb;
    LinkedList localLinkedList;
    for (;;)
    {
      localObject1 = this.jWQ;
      com.tencent.mm.aj.z.afo().a(((a)localObject1).jSD);
      ((a)localObject1).jVJ.jZL.clear();
      com.tencent.mm.aj.z.afp().a(this.jXa);
      if (this.jWX != 0L)
      {
        long l = System.currentTimeMillis();
        this.iWu += l - this.jWY;
        com.tencent.mm.plugin.report.service.h.qsU.e(13932, new Object[] { Integer.valueOf((int)(l - this.jWX) / 1000), Integer.valueOf(1), Integer.valueOf(this.cnU), Integer.valueOf((int)(this.iWu / 1000L)), Integer.valueOf(this.cpt) });
      }
      com.tencent.mm.sdk.b.a.ymk.d(this.jXg);
      this.jVS.jWz = aWV();
      com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new f.2(this.jVS), 0L);
      com.tencent.mm.plugin.brandservice.ui.b.b.clean();
      an.clear();
      if (this.jVI == null) {
        break label525;
      }
      localObject1 = this.jVI;
      ((j)com.tencent.mm.kernel.g.E(j.class)).YF().b((n.b)localObject1);
      com.tencent.mm.sdk.b.a.ymk.d(((BizTimeLineHotView)localObject1).jZk);
      locale = ((BizTimeLineHotView)localObject1).jZa;
      localObject2 = new b.a();
      localbhb = new bhb();
      ((b.a)localObject2).fsX = localbhb;
      ((b.a)localObject2).fsY = new bhc();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/often_read_bar_report";
      ((b.a)localObject2).funcId = 2550;
      localObject2 = ((b.a)localObject2).ado();
      localbhb.wMi = s.getSessionId();
      localbhb.xwi = locale.jZw;
      localLinkedList = new LinkedList();
      if (locale.jZv.size() <= 0) {
        break;
      }
      Iterator localIterator = locale.jZv.entrySet().iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add((bhd)((Map.Entry)localIterator.next()).getValue());
      }
      label468:
      ab.w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", new Object[] { Integer.valueOf(aWV()) });
    }
    localbhb.xwh = localLinkedList;
    w.a((com.tencent.mm.ai.b)localObject2, new e.1(locale));
    com.tencent.mm.kernel.g.Rc().b(2768, (com.tencent.mm.ai.f)localObject1);
    label525:
    s.Np(0);
    AppMethodBeat.o(14217);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(14219);
    super.onPause();
    Object localObject = null;
    if (this.jWQ != null)
    {
      localObject = this.jWQ;
      ((a)localObject).jVP.stopPlay();
      ((a)localObject).cvo = true;
      ((a)localObject).jVJ.jZO = true;
      localObject = this.jWQ.aWI();
    }
    aV(this.jXe);
    int i;
    if (localObject != null)
    {
      com.tencent.mm.aj.z.afo().oe(((com.tencent.mm.storage.q)localObject).field_orderFlag);
      if (this.jWJ == null) {
        break label179;
      }
      localObject = this.jWJ.getChildAt(0);
      if (localObject == null) {
        break label174;
      }
      i = ((View)localObject).getTop();
    }
    label109:
    for (jWV = i;; jWV = 0)
    {
      this.cvo = true;
      long l = System.currentTimeMillis();
      this.iWu += l - this.jWY;
      this.jWY = l;
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBizEnable, this.eez);
      this.eez = 0;
      AppMethodBeat.o(14219);
      return;
      com.tencent.mm.aj.z.afo().dwe();
      break;
      i = 0;
      break label109;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(14218);
    super.onResume();
    if (this.jWZ)
    {
      this.jWZ = false;
      this.jVS.sg(8);
    }
    if (this.jWQ != null)
    {
      Object localObject = this.jWQ;
      ((a)localObject).cvo = false;
      localObject = ((a)localObject).jVJ;
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).jZO)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).jZO = false;
        if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).jZI <= 0) {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject).aXg();
        }
      }
    }
    if (this.cvo)
    {
      this.cvo = false;
      aWS();
    }
    this.jWY = System.currentTimeMillis();
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new BizTimeLineUI.10(this), 500L);
    AppMethodBeat.o(14218);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI
 * JD-Core Version:    0.7.0.1
 */