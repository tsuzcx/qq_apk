package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e.1;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.azy;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.protocal.c.baa;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.aq;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@com.tencent.mm.kernel.j
public class BizTimeLineUI
  extends DrawStatusBarActivity
  implements i
{
  private static long igV = 0L;
  private static long igW = 0L;
  private static long igX = 0L;
  private static int igY = 0;
  private static int igZ = 0;
  private boolean bNW = false;
  private TextView emptyTipTv;
  private View fhl;
  private int hDQ = -1;
  BizTimeLineHotView ieQ;
  private boolean ieZ = false;
  private g ifb;
  private int igH;
  public StoryListView igM;
  private View igN;
  private ImageView igO;
  LinearLayout igP;
  private TextView igQ;
  private TextView igR;
  private View igS;
  private a igT;
  private e igU;
  private View igy;
  private long iha = 0L;
  private long ihb = 0L;
  private long ihc = 0L;
  private boolean ihd = false;
  private r.c ihe = new BizTimeLineUI.9(this);
  private long ihf = 0L;
  private final long ihg = 100L;
  private boolean ihh = false;
  private List<q> ihi = new LinkedList();
  private boolean ihj = false;
  private com.tencent.mm.sdk.b.c ihk = new BizTimeLineUI.8(this);
  
  private static void aI(List<q> paramList)
  {
    if (!bk.dk(paramList))
    {
      LinkedList localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        q localq = (q)paramList.next();
        localq.field_isRead = 1;
        localq = com.tencent.mm.ai.z.ME().D(localq.field_msgId, "msgId");
        if (localq != null)
        {
          localq.field_isRead = 1;
          localLinkedList.add(localq);
        }
      }
      com.tencent.mm.ai.z.ME().h(localLinkedList, false);
    }
  }
  
  private void axY()
  {
    this.igM = ((StoryListView)findViewById(b.d.biz_time_line_lv));
    Object localObject = this.igM;
    this.igy = getLayoutInflater().inflate(b.e.biz_time_line_footer_layout, null);
    ((StoryListView)localObject).addFooterView(this.igy);
    localObject = this.igM;
    this.fhl = getLayoutInflater().inflate(b.e.biz_time_line_header_layout, null);
    this.ieQ = ((BizTimeLineHotView)this.fhl.findViewById(b.d.biz_time_line_hot_view));
    ((StoryListView)localObject).addHeaderView(this.fhl);
    int i = igZ;
    long l = System.currentTimeMillis();
    int j = com.tencent.mm.m.g.AA().getInt("BizTimeLineStayTime", 180) * 1000;
    if ((igV != 0L) && (igW != 0L) && (l - igV < j))
    {
      localObject = com.tencent.mm.ai.z.ME().hx(igW);
      this.ieZ = true;
    }
    for (;;)
    {
      y.i("MicroMsg.BizTimeLineUI", "initListView stayTime %d %d/%d  orderFlag %d, keep %b", new Object[] { Integer.valueOf(j), Long.valueOf(igV), Long.valueOf(l), Long.valueOf(igW), Boolean.valueOf(this.ieZ) });
      this.igT = new a(this, (List)localObject, this.ieZ, this.ifb, this.ieQ);
      this.ifb.igF = ayc();
      this.igP = ((LinearLayout)findViewById(b.d.new_msg_tips_layout));
      this.igQ = ((TextView)findViewById(b.d.new_msg_tips_tv));
      this.igO = ((ImageView)findViewById(b.d.new_msg_tips_icon_iv));
      axX();
      this.igP.setOnClickListener(new BizTimeLineUI.1(this));
      this.igM.setAdapter(this.igT);
      this.igM.setFooterDividersEnabled(false);
      this.igM.setOnScrollListener(new BizTimeLineUI.11(this));
      this.igM.setEmptyView(this.emptyTipTv);
      this.igM.postDelayed(new BizTimeLineUI.12(this, i, (List)localObject), 100L);
      if (((List)localObject).size() < 10) {
        axZ();
      }
      com.tencent.mm.ai.z.MF().a(this.ihe, Looper.getMainLooper());
      return;
      this.ieZ = false;
      localObject = r.m(com.tencent.mm.ai.z.ME().dXo.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit 10"));
      Looper.myQueue().addIdleHandler(new BizTimeLineUI.13(this, (List)localObject));
    }
  }
  
  private static int ayc()
  {
    if (igZ > 0) {
      return igZ - 1;
    }
    return 0;
  }
  
  private void c(q paramq)
  {
    this.igM.postDelayed(new BizTimeLineUI.14(this, paramq), 50L);
  }
  
  private void ct(int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 == 0) && (!this.ieZ) && (igZ != paramInt1)) {
      this.ieQ.aye();
    }
    if ((this.ieZ) || (this.ihj) || ((igZ == paramInt1) && (this.hDQ == paramInt2))) {
      return;
    }
    this.hDQ = paramInt2;
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
        q localq = this.igT.oy(paramInt1);
        if ((localq != null) && (localq.field_isRead != 1)) {
          localLinkedList.add(localq);
        }
        paramInt1 += 1;
      }
      paramInt1 = 0;
    }
    this.ihi.removeAll(localLinkedList);
    aI(this.ihi);
    this.ihi.clear();
    this.ihi.addAll(localLinkedList);
  }
  
  public final void axW()
  {
    if (this.igT != null) {
      this.igT.notifyDataSetChanged();
    }
  }
  
  public final void axX()
  {
    q localq = null;
    if (isFinishing()) {}
    for (;;)
    {
      return;
      int i = com.tencent.mm.ai.z.MF().aAo();
      if (i <= 0) {
        break;
      }
      this.igP.setVisibility(0);
      this.igQ.setText(getString(b.h.biz_time_line_new_msg_count, new Object[] { Integer.valueOf(i) }));
      Cursor localCursor = com.tencent.mm.ai.z.MF().dXo.a("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null, 0);
      if (localCursor.moveToFirst())
      {
        localq = new q();
        localq.d(localCursor);
      }
      localCursor.close();
      if (localq != null)
      {
        this.igO.setVisibility(0);
        a.b.a(this.igO, localq.field_talker);
        com.tencent.mm.storage.s.hC(localq.field_msgId);
      }
      while ((this.igT != null) && (this.igT.getCount() == 0))
      {
        this.igT.notifyDataSetChanged();
        return;
        this.igO.setVisibility(8);
      }
    }
    this.igP.setVisibility(8);
  }
  
  public final void axZ()
  {
    if ((!isFinishing()) && (this.igy != null))
    {
      ProgressBar localProgressBar = (ProgressBar)findViewById(b.d.biz_time_line_loading_more_pb);
      TextView localTextView = (TextView)findViewById(b.d.biz_time_line_loading_more_tv);
      localProgressBar.setVisibility(8);
      localTextView.setText(getString(b.h.biz_time_line_loading_no_more_tips));
    }
  }
  
  public final void aya()
  {
    long l = System.currentTimeMillis() - this.ihf;
    if ((this.ihh) && (l < 200L))
    {
      y.d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
      return;
    }
    y.d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.ihh), Long.valueOf(l) });
    this.ihh = true;
    if (l < 100L)
    {
      ai.l(new BizTimeLineUI.5(this), 100L);
      return;
    }
    if ((this.igT == null) || (this.bNW)) {}
    for (;;)
    {
      this.ihf = System.currentTimeMillis();
      this.ihh = false;
      return;
      if (this.igT.hfb.size() > 0)
      {
        l = ((q)this.igT.hfb.get(0)).field_orderFlag;
        int i = com.tencent.mm.ai.z.ME().hy(l);
        y.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", new Object[] { Integer.valueOf(i) });
        if (i > 0)
        {
          FP(8);
          if (this.igN.getVisibility() == 8) {
            this.igN.setVisibility(4);
          }
          this.igR.setText(getString(b.h.biz_time_line_new_update_count, new Object[] { Integer.valueOf(i) }));
          this.igN.post(new BizTimeLineUI.6(this, l));
        }
        else
        {
          this.igN.setVisibility(8);
          FP(0);
        }
      }
    }
  }
  
  public final void ayb()
  {
    y.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
    aya();
  }
  
  protected final int getLayoutId()
  {
    return b.e.biz_time_line_activity;
  }
  
  protected final int getStatusBarColor()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return -1052684;
    }
    return super.getStatusBarColor();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ta(-1052684);
    setTitleBarDoubleClickListener(new BizTimeLineUI.2(this));
    paramBundle = com.tencent.mm.model.c.c.IX().fJ("100045");
    boolean bool;
    if ((paramBundle.isValid()) && ("1".equals(paramBundle.ctr().get("isOpenSearch"))))
    {
      bool = true;
      y.d("MicroMsg.BizTimeLineUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        addIconOptionMenu(0, b.h.top_item_desc_search, b.g.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            if (aa.Br(0))
            {
              paramAnonymousMenuItem = aa.bZt();
              paramAnonymousMenuItem.putExtra("title", BizTimeLineUI.this.getString(b.h.fts_search_biz_article));
              paramAnonymousMenuItem.putExtra("searchbar_tips", BizTimeLineUI.this.getString(b.h.fts_search_biz_article));
              paramAnonymousMenuItem.putExtra("KRightBtn", true);
              paramAnonymousMenuItem.putExtra("ftsneedkeyboard", true);
              paramAnonymousMenuItem.putExtra("publishIdPrefix", "bs");
              paramAnonymousMenuItem.putExtra("ftsType", 2);
              paramAnonymousMenuItem.putExtra("ftsbizscene", 11);
              Object localObject = aa.b(11, true, 2);
              String str = aa.Bm(bk.ZR((String)((Map)localObject).get("scene")));
              ((Map)localObject).put("sessionId", str);
              paramAnonymousMenuItem.putExtra("sessionId", str);
              paramAnonymousMenuItem.putExtra("rawUrl", aa.v((Map)localObject));
              paramAnonymousMenuItem.putExtra("key_load_js_without_delay", true);
              paramAnonymousMenuItem.addFlags(67108864);
              localObject = ac.Rw("bizAccountTopSearch");
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                paramAnonymousMenuItem.putExtra("key_search_input_hint", (String)localObject);
              }
              com.tencent.mm.br.d.b(ae.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramAnonymousMenuItem);
              return true;
            }
            y.e("MicroMsg.BizTimeLineUI", "fts h5 template not avail");
            return true;
          }
        });
      }
      addIconOptionMenu(1, b.h.biz_time_line_old_list, b.g.actionbar_menu_list_icon, new BizTimeLineUI.16(this));
      setMMTitle(b.h.biz_time_line_title);
      oX(-16777216);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          BizTimeLineUI.this.finish();
          return true;
        }
      }, b.g.actionbar_icon_dark_back);
      this.igN = getLayoutInflater().inflate(b.e.biz_time_line_action_bar_update_view, null);
      this.igR = ((TextView)this.igN.findViewById(b.d.biz_time_line_update_count_tv));
      this.igR.setTextSize(1, 14.0F);
      this.igS = this.igN.findViewById(b.d.biz_time_line_update_count_layout);
      ((LinearLayout)this.mController.mActionBar.getCustomView()).addView(this.igN);
      paramBundle = (LinearLayout.LayoutParams)this.igN.getLayoutParams();
      paramBundle.width = -1;
      paramBundle.weight = 1.0F;
      this.igN.setLayoutParams(paramBundle);
      this.igS.setOnClickListener(new BizTimeLineUI.4(this));
      this.igN.setVisibility(8);
      this.emptyTipTv = ((TextView)findViewById(b.d.empty_msg_tip_tv));
      this.emptyTipTv.setText(b.h.biz_time_line_empty_biz_msg_tip);
      this.igU = new e(this);
      paramBundle = this.igU;
      com.tencent.mm.sdk.b.a.udP.c(paramBundle.giK);
      this.igH = ((int)(System.currentTimeMillis() / 1000L));
      this.ifb = new g(this.igH);
      com.tencent.mm.storage.s.Fj(this.igH);
      paramBundle = new d();
      if (!d.axV()) {
        break label499;
      }
      axY();
    }
    for (;;)
    {
      y.d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
      int i = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzq, Integer.valueOf(0))).intValue();
      if ((i & 0x4) == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().aby("officialaccounts");
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzq, Integer.valueOf(i | 0x4));
      }
      com.tencent.mm.pluginsdk.e.l(this);
      this.iha = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.udP.c(this.ihk);
      com.tencent.mm.plugin.brandservice.ui.timeline.a.d.run();
      return;
      bool = false;
      break;
      label499:
      getString(b.h.app_tip);
      com.tencent.mm.sdk.f.e.post(new d.1(paramBundle, new BizTimeLineUI.10(this, com.tencent.mm.ui.base.h.b(this, getString(b.h.app_waiting), false, null))), "BizTimeLineMigrateThread");
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject1 = this.igU;
    com.tencent.mm.sdk.b.a.udP.d(((e)localObject1).giK);
    igV = System.currentTimeMillis();
    if ((this.igT != null) && (this.igM != null))
    {
      localObject1 = this.igT.axL();
      if (localObject1 != null) {
        igW = ((q)localObject1).field_orderFlag;
      }
      localObject1 = this.igT.oy(ayc());
      if (localObject1 == null) {
        break label443;
      }
      igX = ((q)localObject1).field_orderFlag;
    }
    Object localObject2;
    azy localazy;
    LinkedList localLinkedList;
    for (;;)
    {
      localObject1 = this.igT;
      com.tencent.mm.ai.z.ME().a(((a)localObject1).ibN);
      ((a)localObject1).ieR.ihT.clear();
      com.tencent.mm.ai.z.MF().a(this.ihe);
      if (this.iha != 0L)
      {
        long l = System.currentTimeMillis();
        this.ihc += l - this.ihb;
        com.tencent.mm.plugin.report.service.h.nFQ.f(13932, new Object[] { Integer.valueOf((int)(l - this.iha) / 1000), Integer.valueOf(1), Integer.valueOf(this.igH), Integer.valueOf((int)(this.ihc / 1000L)) });
      }
      com.tencent.mm.sdk.b.a.udP.d(this.ihk);
      this.ifb.igG = ayc();
      localObject1 = this.ifb;
      com.tencent.mm.kernel.g.DS().O(new g.2((g)localObject1));
      com.tencent.mm.plugin.brandservice.ui.b.b.clean();
      aq.clear();
      localObject1 = this.ieQ;
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().b((m.b)localObject1);
      com.tencent.mm.sdk.b.a.udP.d(((BizTimeLineHotView)localObject1).ihz);
      localObject1 = ((BizTimeLineHotView)localObject1).ihs;
      localObject2 = new b.a();
      localazy = new azy();
      ((b.a)localObject2).ecH = localazy;
      ((b.a)localObject2).ecI = new azz();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/often_read_bar_report";
      ((b.a)localObject2).ecG = 2550;
      localObject2 = ((b.a)localObject2).Kt();
      localazy.sOo = com.tencent.mm.storage.s.getSessionId();
      localazy.tvX = ((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e)localObject1).ihJ;
      localLinkedList = new LinkedList();
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e)localObject1).ihI.size() <= 0) {
        break;
      }
      Iterator localIterator = ((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e)localObject1).ihI.entrySet().iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add((baa)((Map.Entry)localIterator.next()).getValue());
      }
      label443:
      y.w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", new Object[] { Integer.valueOf(ayc()) });
    }
    localazy.tvW = localLinkedList;
    w.a((com.tencent.mm.ah.b)localObject2, new e.1((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e)localObject1));
    com.tencent.mm.storage.s.Fj(0);
  }
  
  protected void onPause()
  {
    int i = 0;
    super.onPause();
    Object localObject;
    if (this.igT != null)
    {
      localObject = this.igT;
      ((a)localObject).ieY.stopPlay();
      ((a)localObject).bNW = true;
    }
    aI(this.ihi);
    com.tencent.mm.ai.z.ME().ctE();
    if (this.igM != null)
    {
      localObject = this.igM.getChildAt(0);
      if (localObject != null) {
        i = ((View)localObject).getTop();
      }
    }
    for (igY = i;; igY = 0)
    {
      this.bNW = true;
      long l = System.currentTimeMillis();
      this.ihc += l - this.ihb;
      this.ihb = l;
      return;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.ihd)
    {
      this.ihd = false;
      this.ifb.a("", 0L, 8);
    }
    if (this.igT != null) {
      this.igT.bNW = false;
    }
    if (this.bNW)
    {
      this.bNW = false;
      aya();
    }
    this.ihb = System.currentTimeMillis();
    com.tencent.mm.kernel.g.DS().k(new BizTimeLineUI.17(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI
 * JD-Core Version:    0.7.0.1
 */