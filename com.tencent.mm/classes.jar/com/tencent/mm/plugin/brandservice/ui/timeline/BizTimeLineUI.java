package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ar;
import com.tencent.mm.autogen.a.ax;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.o;
import com.tencent.mm.model.p.a;
import com.tencent.mm.model.p.f;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine.Companion;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.eni;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ac.4;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ac.c;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.y;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.s;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;

@com.tencent.mm.kernel.k
public class BizTimeLineUI
  extends MMActivity
  implements h, com.tencent.mm.plugin.webcanvas.e, ScreenShotUtil.ScreenShotCallback
{
  private static String vIa = null;
  private static int vIb = 0;
  private static int vIc = 0;
  private TextView emptyTipTv;
  private int hBm;
  private boolean hJi;
  private int lyw;
  private int mScrollState;
  private View pUv;
  private int source;
  private View uiE;
  private long uoT;
  public f vFK;
  private BizTimeLineHotView vFM;
  private long vGY;
  public StoryListView vHR;
  private View vHS;
  private ImageView vHT;
  private LinearLayout vHU;
  private TextView vHV;
  private TextView vHW;
  private View vHX;
  public b vHY;
  private d vHZ;
  private com.tencent.mm.pluginsdk.ui.span.m vIA;
  private com.tencent.mm.plugin.brandservice.ui.timeline.a.b vId;
  private long vIe;
  private boolean vIf;
  private boolean vIg;
  private boolean vIh;
  private int vIi;
  private int vIj;
  private int vIk;
  private boolean vIl;
  private HashSet<String> vIm;
  private final Set<com.tencent.mm.plugin.webcanvas.f> vIn;
  private final Set<com.tencent.mm.plugin.webcanvas.d> vIo;
  private ac.c vIp;
  private IListener vIq;
  private IListener vIr;
  private IListener vIs;
  private int vIt;
  private final int vIu;
  private long vIv;
  private final long vIw;
  private boolean vIx;
  private boolean vIy;
  private IListener vIz;
  
  public BizTimeLineUI()
  {
    AppMethodBeat.i(5965);
    this.vGY = 0L;
    this.vIe = 0L;
    this.uoT = 0L;
    this.source = 1;
    this.vIf = false;
    this.vIg = false;
    this.vIh = false;
    this.hJi = false;
    this.vIi = 0;
    this.vIj = -1;
    this.vIk = -1;
    this.mScrollState = 0;
    this.vIl = false;
    this.vIm = new HashSet();
    this.vIn = Collections.newSetFromMap(new ConcurrentHashMap());
    this.vIo = Collections.newSetFromMap(new ConcurrentHashMap());
    this.vIp = new ac.c()
    {
      public final void onNotifyChange(Object paramAnonymousObject, ac.a paramAnonymousa)
      {
        AppMethodBeat.i(5955);
        BizTimeLineUI.this.dde();
        AppMethodBeat.o(5955);
      }
    };
    this.vIq = new BizTimeLineUI.3(this, com.tencent.mm.app.f.hfK);
    this.vIr = new IListener(com.tencent.mm.app.f.hfK) {};
    this.vIs = new IListener(com.tencent.mm.app.f.hfK) {};
    this.vIt = 0;
    this.vIu = 20;
    this.vIv = 0L;
    this.vIw = 100L;
    this.vIx = false;
    this.vIy = false;
    this.vIz = new BizTimeLineUI.21(this, com.tencent.mm.app.f.hfK);
    this.vIA = new BizTimeLineUI.17(this);
    AppMethodBeat.o(5965);
  }
  
  private void ddf()
  {
    AppMethodBeat.i(301833);
    LinearLayout.LayoutParams localLayoutParams;
    if (this.vFM != null)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.vHU.getLayoutParams();
      if (!this.vFM.dem()) {
        break label60;
      }
    }
    label60:
    for (int i = 4;; i = 20)
    {
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(this, i);
      this.vHU.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(301833);
      return;
    }
  }
  
  private void ddg()
  {
    AppMethodBeat.i(301838);
    if ((this.vHY == null) || (this.vHR == null) || (Util.isNullOrNil(vIa)))
    {
      AppMethodBeat.o(301838);
      return;
    }
    int i = 0;
    while (i < this.vHY.getCount())
    {
      com.tencent.mm.storage.ab localab = this.vHY.Hk(i);
      if ((localab != null) && (Util.isEqual(vIa, localab.getId())))
      {
        Log.i("MicroMsg.BizTimeLineUI", "tryToScrollToPosition %d top %d", new Object[] { Integer.valueOf(i), Integer.valueOf(vIb) });
        f(localab, i + 1);
        AppMethodBeat.o(301838);
        return;
      }
      i += 1;
    }
    i(null);
    AppMethodBeat.o(301838);
  }
  
  private void ddh()
  {
    int j = 0;
    AppMethodBeat.i(301859);
    if ((this.vHR == null) || (this.vHY == null))
    {
      AppMethodBeat.o(301859);
      return;
    }
    int i = this.vHR.getFirstVisiblePosition();
    int m = this.vHR.getLastVisiblePosition();
    gu(i, m);
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
        com.tencent.mm.storage.ab localab = this.vHY.Hk(k);
        if (localab != null)
        {
          this.vHY.aiW(localab.field_talker);
          this.vFK.g(localab);
        }
        k += 1;
      }
      i = 0;
    }
    AppMethodBeat.o(301859);
  }
  
  private void ddj()
  {
    AppMethodBeat.i(5976);
    if ((this.vHY == null) || (this.hJi))
    {
      AppMethodBeat.o(5976);
      return;
    }
    long l;
    if (this.vHY.eXW.size() > 0)
    {
      l = ((com.tencent.mm.storage.ab)this.vHY.eXW.get(0)).field_orderFlag;
      if ((!this.vIg) && (this.vHR != null) && (this.vHR.getFirstVisiblePosition() == 0))
      {
        this.vHS.setVisibility(8);
        setMMTitleVisibility(0);
        AppMethodBeat.o(5976);
      }
    }
    else
    {
      AppMethodBeat.o(5976);
      return;
    }
    int i = com.tencent.mm.an.af.bHl().yM(l);
    Log.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      setMMTitleVisibility(8);
      this.vHS.setVisibility(0);
      this.vHW.setText(getString(d.i.biz_time_line_new_update_count, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(5976);
      return;
    }
    ddk();
    AppMethodBeat.o(5976);
  }
  
  private static int ddm()
  {
    if (vIc > 0) {
      return vIc - 1;
    }
    return 0;
  }
  
  private void e(final com.tencent.mm.storage.ab paramab, final int paramInt)
  {
    AppMethodBeat.i(301845);
    this.vHR.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5947);
        if ((BizTimeLineUI.k(BizTimeLineUI.this) > 20) || (BizTimeLineUI.l(BizTimeLineUI.this)) || (BizTimeLineUI.m(BizTimeLineUI.this) != 0))
        {
          BizTimeLineUI.a(BizTimeLineUI.this, paramab);
          Log.i("MicroMsg.BizTimeLineUI", "tryToScrollToPosition fail userTouched: %b state: %d tryScrollTimes: %d", new Object[] { Boolean.valueOf(BizTimeLineUI.l(BizTimeLineUI.this)), Integer.valueOf(BizTimeLineUI.m(BizTimeLineUI.this)), Integer.valueOf(BizTimeLineUI.n(BizTimeLineUI.this)) });
          AppMethodBeat.o(5947);
          return;
        }
        BizTimeLineUI.a(BizTimeLineUI.this, paramab, paramInt);
        AppMethodBeat.o(5947);
      }
    }, 10L);
    AppMethodBeat.o(301845);
  }
  
  private void eC(View paramView)
  {
    AppMethodBeat.i(5982);
    paramView = paramView.getTag(d.e.biz_image_view_url);
    if ((paramView instanceof String)) {
      this.vIm.add((String)paramView);
    }
    AppMethodBeat.o(5982);
  }
  
  private void f(com.tencent.mm.storage.ab paramab, int paramInt)
  {
    AppMethodBeat.i(301851);
    if ((this.vHR == null) || (isFinishing()))
    {
      AppMethodBeat.o(301851);
      return;
    }
    com.tencent.mm.pluginsdk.ui.tools.q.a(this.vHR, paramInt, vIb, false, false);
    if (this.vHR.getFirstVisiblePosition() == paramInt)
    {
      i(paramab);
      Log.i("MicroMsg.BizTimeLineUI", "tryToScrollToPosition success tryScrollTimes: %d", new Object[] { Integer.valueOf(this.vIt) });
      AppMethodBeat.o(301851);
      return;
    }
    e(paramab, paramInt);
    AppMethodBeat.o(301851);
  }
  
  private void gu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5983);
    if ((paramInt1 == 0) && (!this.vIg) && (vIc != paramInt1)) {
      this.vFM.del();
    }
    this.vId.a(paramInt1, paramInt2, this.vHR, this.vFK);
    AppMethodBeat.o(5983);
  }
  
  private void i(com.tencent.mm.storage.ab paramab)
  {
    AppMethodBeat.i(5971);
    this.vHY.vFQ = false;
    this.vIg = false;
    int i = Math.max(0, this.vHR.getFirstVisiblePosition() - this.vHR.getHeaderViewsCount());
    this.vHY.f(paramab);
    this.vHY.f(this.vHY.Hk(i));
    ddh();
    Log.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(5971);
  }
  
  public final void a(com.tencent.mm.plugin.webcanvas.d paramd)
  {
    AppMethodBeat.i(302183);
    if (!this.vIo.contains(this.vIo)) {
      this.vIo.add(paramd);
    }
    AppMethodBeat.o(302183);
  }
  
  public final void a(com.tencent.mm.plugin.webcanvas.f paramf)
  {
    AppMethodBeat.i(302171);
    if (!this.vIn.contains(paramf)) {
      this.vIn.add(paramf);
    }
    AppMethodBeat.o(302171);
  }
  
  public final void b(com.tencent.mm.plugin.webcanvas.f paramf)
  {
    AppMethodBeat.i(302177);
    this.vIn.remove(paramf);
    AppMethodBeat.o(302177);
  }
  
  public final void dcR()
  {
    AppMethodBeat.i(5974);
    if ((!isFinishing()) && (this.uiE != null))
    {
      Object localObject = (View)$(d.e.biz_time_line_loading_layout);
      if (localObject == null)
      {
        Log.w("MicroMsg.BizTimeLineUI", "noMoreData loadingLayout is null");
        AppMethodBeat.o(5974);
        return;
      }
      ((View)localObject).setVisibility(8);
      ((View)$(d.e.biz_time_line_no_more_layout)).setVisibility(0);
      localObject = (TextView)$(d.e.biz_time_line_no_more_data_tv);
      b.a locala = b.vFE;
      if (b.a.dcY())
      {
        ((TextView)localObject).setText(getString(d.i.biz_time_line_loading_no_more_rec_tips));
        localObject = o.ojb;
        o.ir(15L);
        AppMethodBeat.o(5974);
        return;
      }
      ((TextView)localObject).setText(getString(d.i.biz_time_line_loading_no_more_tips));
    }
    AppMethodBeat.o(5974);
  }
  
  public final void dcS()
  {
    AppMethodBeat.i(302087);
    if ((!isFinishing()) && (this.uiE != null))
    {
      ((View)$(d.e.biz_time_line_loading_layout)).setVisibility(0);
      ((View)$(d.e.biz_time_line_no_more_layout)).setVisibility(8);
    }
    AppMethodBeat.o(302087);
  }
  
  public final void dcZ()
  {
    AppMethodBeat.i(5978);
    if (this.vHY != null) {
      this.vHY.notifyDataSetChanged();
    }
    AppMethodBeat.o(5978);
  }
  
  public final void dde()
  {
    AppMethodBeat.i(5968);
    if (isFinishing())
    {
      AppMethodBeat.o(5968);
      return;
    }
    int i = com.tencent.mm.an.af.bHo().dkF();
    if (i > 0)
    {
      this.vHU.setVisibility(0);
      ddf();
      this.vHV.setText(getString(d.i.biz_time_line_new_msg_count, new Object[] { Integer.valueOf(i) }));
      com.tencent.mm.storage.ab localab = com.tencent.mm.an.af.bHo().iZb();
      Object localObject;
      if (localab != null)
      {
        this.vHT.setVisibility(0);
        if (localab.iYh())
        {
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(localab.field_talker);
          if ((localObject != null) && (com.tencent.mm.contact.d.rs(((az)localObject).field_type))) {
            break label382;
          }
          if (localab.iYn() != null)
          {
            localObject = new c.a();
            ((c.a)localObject).oKB = d.d.default_avatar;
            ((c.a)localObject).oKo = true;
            com.tencent.mm.modelimage.r.bKe().a(localab.iYn().nVs, this.vHT, ((c.a)localObject).bKx());
          }
          ad.yW(localab.field_msgId);
        }
      }
      for (;;)
      {
        if ((this.vHY != null) && (this.vHY.getCount() == 0)) {
          this.vHY.notifyDataSetChanged();
        }
        AppMethodBeat.o(5968);
        return;
        if (localab.iYi())
        {
          localObject = ai.M(localab);
          String str = ai.N(localab);
          if (!TextUtils.isEmpty(str))
          {
            c.a locala = new c.a();
            locala.oKB = d.d.default_avatar;
            locala.oKo = true;
            locala.nrc = true;
            com.tencent.mm.modelimage.r.bKe().a(str, this.vHT, locala.bKx());
          }
          for (;;)
          {
            i = ai.h(localab);
            this.vFK.n(i, (String)localObject, 0);
            break;
            if (Util.isNullOrNil((String)localObject)) {
              a.b.g(this.vHT, localab.field_talker);
            } else if (com.tencent.mm.model.ab.IS((String)localObject)) {
              a.b.h(this.vHT, (String)localObject);
            } else {
              a.b.g(this.vHT, (String)localObject);
            }
          }
        }
        if (com.tencent.mm.model.ab.IS(localab.field_talker))
        {
          a.b.h(this.vHT, localab.field_talker);
          break;
        }
        label382:
        a.b.g(this.vHT, localab.field_talker);
        break;
        this.vHT.setVisibility(8);
      }
    }
    this.vHU.setVisibility(8);
    AppMethodBeat.o(5968);
  }
  
  public final void ddi()
  {
    AppMethodBeat.i(5975);
    long l = System.currentTimeMillis() - this.vIv;
    if ((this.vIx) && (l < 200L))
    {
      Log.d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
      AppMethodBeat.o(5975);
      return;
    }
    Log.d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.vIx), Long.valueOf(l) });
    this.vIx = true;
    if (l < 100L)
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(301799);
          BizTimeLineUI.q(BizTimeLineUI.this);
          if (!BizTimeLineUI.this.isFinishing())
          {
            BizTimeLineUI.this.ddi();
            AppMethodBeat.o(301799);
            return;
          }
          Log.w("MicroMsg.BizTimeLineUI", "Activity is finished!!!");
          AppMethodBeat.o(301799);
        }
      }, 100L);
      AppMethodBeat.o(5975);
      return;
    }
    ddj();
    this.vIv = System.currentTimeMillis();
    this.vIx = false;
    AppMethodBeat.o(5975);
  }
  
  public final void ddk()
  {
    AppMethodBeat.i(5977);
    Log.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
    this.vHS.setVisibility(8);
    setMMTitleVisibility(0);
    AppMethodBeat.o(5977);
  }
  
  public final boolean ddl()
  {
    AppMethodBeat.i(302167);
    if ((this.vFM.getVisibility() == 0) || (this.vHU.getVisibility() == 0))
    {
      AppMethodBeat.o(302167);
      return true;
    }
    AppMethodBeat.o(302167);
    return false;
  }
  
  public int getLayoutId()
  {
    return d.f.biz_time_line_activity;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(302027);
    HashSet localHashSet = new HashSet(super.importUIComponents());
    localHashSet.add(com.tencent.mm.plugin.brandservice.ui.d.class);
    AppMethodBeat.o(302027);
    return localHashSet;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(302198);
    super.onConfigurationChanged(paramConfiguration);
    Iterator localIterator = this.vIn.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.webcanvas.f)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
    if (this.vFM != null) {
      this.vFM.onConfigurationChanged(paramConfiguration);
    }
    this.vId.a(this.vHR, paramConfiguration);
    AppMethodBeat.o(302198);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5966);
    ad.KC(true);
    com.tencent.mm.plugin.brandservice.model.c.init();
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(d.e.empty_msg_tip_tv));
    this.emptyTipTv.setText(d.i.biz_time_line_empty_biz_msg_tip);
    this.vHZ = new d(this);
    this.vHZ.rDF.alive();
    this.hBm = ((int)(System.currentTimeMillis() / 1000L));
    this.source = getIntent().getIntExtra("biz_enter_source", 1);
    this.vGY = System.currentTimeMillis();
    ad.iYT();
    this.vFK = new f(this.hBm, this.vGY, getIntent());
    this.vId = new com.tencent.mm.plugin.brandservice.ui.timeline.a.b(this, this.vFK);
    ad.HV(this.hBm);
    paramBundle = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.vYt;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.HV(this.hBm);
    setTitleBarDoubleClickListener(new BizTimeLineUI.11(this));
    paramBundle = com.tencent.mm.plugin.bizui.a.a.vtB;
    boolean bool2 = com.tencent.mm.plugin.bizui.a.a.daI();
    final boolean bool1;
    if (!aj.aBu())
    {
      bool1 = true;
      Log.i("MicroMsg.BizTimeLineUI", "open search entrance:%b, isNotTeenMode: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (bool1)) {
        addIconOptionMenu(0, d.i.top_item_desc_search, d.h.actionbar_icon_dark_search, new BizTimeLineUI.8(this));
      }
      addIconOptionMenu(1, d.i.biz_time_line_old_list, d.h.actionbar_menu_list_icon, new MenuItem.OnMenuItemClickListener()new BizTimeLineUI.10
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(301827);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.addFlags(67108864);
          paramAnonymousMenuItem.putExtra("biz_from_scene", 2);
          paramAnonymousMenuItem.putExtra("biz_time_line_line_session_id", BizTimeLineUI.a(BizTimeLineUI.this));
          paramAnonymousMenuItem.putExtra("biz_enter_source", BizTimeLineUI.h(BizTimeLineUI.this));
          com.tencent.mm.br.c.g(BizTimeLineUI.this, ".ui.conversation.NewBizConversationUI", paramAnonymousMenuItem);
          BizTimeLineUI.this.vFK.Hm(7);
          BizTimeLineUI.o(BizTimeLineUI.this);
          AppMethodBeat.o(301827);
          return true;
        }
      }, new BizTimeLineUI.10(this));
      setMMTitle(d.i.biz_time_line_title);
      setMMTitleColor(getContext().getResources().getColor(d.b.FG_0));
      setBackBtn(new BizTimeLineUI.12(this), d.h.actionbar_icon_dark_back);
      this.vHS = getLayoutInflater().inflate(d.f.biz_time_line_action_bar_update_view, null);
      this.vHW = ((TextView)this.vHS.findViewById(d.e.biz_time_line_update_count_tv));
      this.vHW.setTextSize(1, 14.0F);
      this.vHX = this.vHS.findViewById(d.e.biz_time_line_update_count_layout);
      paramBundle = getController().mActionBar.getCustomView();
      if (!(paramBundle instanceof LinearLayout)) {
        break label1244;
      }
      ((LinearLayout)paramBundle).addView(this.vHS);
      paramBundle = (LinearLayout.LayoutParams)this.vHS.getLayoutParams();
      paramBundle.width = -1;
      paramBundle.weight = 1.0F;
      paramBundle.gravity = 16;
      this.vHS.setLayoutParams(paramBundle);
    }
    Object localObject1;
    int k;
    Object localObject2;
    for (;;)
    {
      this.vHX.setOnClickListener(new BizTimeLineUI.13(this));
      this.vHS.setVisibility(8);
      this.vHR = ((StoryListView)$(d.e.biz_time_line_lv));
      paramBundle = this.vHR;
      this.uiE = getLayoutInflater().inflate(d.f.biz_time_line_footer_layout, null);
      paramBundle.addFooterView(this.uiE);
      paramBundle = this.vHR;
      if (this.pUv == null)
      {
        this.pUv = getLayoutInflater().inflate(d.f.biz_time_line_header_layout, null);
        this.vFM = ((BizTimeLineHotView)this.pUv.findViewById(d.e.biz_time_line_hot_view));
      }
      paramBundle.addHeaderView(this.pUv);
      final int i = vIc;
      final int j = getIntent().getIntExtra("Main_UnreadCount", 0);
      this.vIg = ad.iYQ();
      bool1 = this.vIg;
      this.vIh = ad.cz(j, this.vIg);
      if (!this.vIh) {
        break label1295;
      }
      paramBundle = com.tencent.mm.an.af.bHl().yH(ad.acGi);
      com.tencent.mm.plugin.brandservice.ui.b.d.eE(paramBundle);
      Log.i("MicroMsg.BizTimeLineUI", "initListView keepPos %b, keepData %b, unReadCount %d, size=%d, sessionId=%d", new Object[] { Boolean.valueOf(this.vIg), Boolean.valueOf(this.vIh), Integer.valueOf(j), Integer.valueOf(paramBundle.size()), Integer.valueOf(this.hBm) });
      this.vHY = new b(this, paramBundle, this.vIg, this.vIh, this.vFK, this.vFM);
      localObject1 = com.tencent.mm.plugin.brandservice.model.a.vBp;
      com.tencent.mm.plugin.brandservice.model.a.a(this.vHY, this.vHR);
      localObject1 = this.vFK;
      k = ddm();
      localObject2 = this.vHY.eXW;
      ((f)localObject1).vGW = k;
      ((f)localObject1).dataList = ((List)localObject2);
      if (((f)localObject1).dataList.size() > 0)
      {
        localObject2 = g.vHx;
        g.a((com.tencent.mm.storage.ab)((f)localObject1).dataList.get(0), ((f)localObject1).dataList, ((f)localObject1).vHh);
      }
      this.vHU = ((LinearLayout)$(d.e.new_msg_tips_layout));
      this.vHV = ((TextView)$(d.e.new_msg_tips_tv));
      this.vHT = ((ImageView)$(d.e.new_msg_tips_icon_iv));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      com.tencent.mm.plugin.brandservice.ui.b.e.l(this.vHV);
      dde();
      this.vHU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(5944);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = "";
          localObject = com.tencent.mm.an.af.bHo().iZb();
          if (localObject != null) {
            paramAnonymousView = ai.M((com.tencent.mm.storage.ab)localObject);
          }
          for (int i = ai.h((com.tencent.mm.storage.ab)localObject);; i = 0)
          {
            localObject = BizTimeLineUI.this.vFK;
            com.tencent.mm.plugin.report.service.h.OAn.b(15721, new Object[] { paramAnonymousView, "", Integer.valueOf(12), Integer.valueOf(-1), Integer.valueOf(((f)localObject).hBm), "", "", "", Integer.valueOf(0), "", "", "", "", "", "", "", "", "", Integer.valueOf(i) });
            BizTimeLineUI.this.vFK.n(i, paramAnonymousView, 1);
            localObject = new Intent(BizTimeLineUI.this.getContext(), BizTimeLineNewMsgUI.class);
            ((Intent)localObject).putExtra("biz_time_line_line_session_id", BizTimeLineUI.a(BizTimeLineUI.this));
            ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 1);
            paramAnonymousView = BizTimeLineUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(5944);
            return;
          }
        }
      });
      this.vHR.setAdapter(this.vHY);
      this.vHR.setFooterDividersEnabled(false);
      this.vHR.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(301770);
          paramAnonymousAbsListView = BizTimeLineUI.f(BizTimeLineUI.this).iterator();
          while (paramAnonymousAbsListView.hasNext()) {
            ((com.tencent.mm.plugin.webcanvas.f)paramAnonymousAbsListView.next()).ddD();
          }
          BizTimeLineUI.a(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt2 - 1);
          paramAnonymousAbsListView = com.tencent.mm.pluginsdk.ui.applet.g.Ybp;
          if (com.tencent.mm.pluginsdk.ui.applet.g.awm(1)) {
            BizTimeLineUI.b(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt2 - 1);
          }
          if (BizTimeLineUI.ddn() != paramAnonymousInt1)
          {
            paramAnonymousAbsListView = com.tencent.mm.storage.af.acGt;
            com.tencent.mm.storage.af.Hp(paramAnonymousInt1);
            paramAnonymousAbsListView = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a.Hp(paramAnonymousInt1);
            paramAnonymousAbsListView = com.tencent.mm.plugin.brandservice.model.a.vBp;
            com.tencent.mm.plugin.brandservice.model.a.GZ(paramAnonymousInt1);
          }
          BizTimeLineUI.Hn(paramAnonymousInt1);
          paramAnonymousAbsListView = BizTimeLineUI.this.vFK;
          paramAnonymousInt1 = BizTimeLineUI.ddn();
          if (paramAnonymousAbsListView.vHj != null)
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousAbsListView.vHj.vHv != paramAnonymousInt1))
            {
              f.a locala = paramAnonymousAbsListView.vHj;
              locala.vHs += 1;
            }
            paramAnonymousAbsListView.vHj.vHv = paramAnonymousInt1;
          }
          AppMethodBeat.o(301770);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(301766);
          BizTimeLineUI.a(BizTimeLineUI.this, paramAnonymousInt);
          Log.d("MicroMsg.BizTimeLineUI", "onScrollStateChanged scrollState=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              break label165;
            }
          }
          label165:
          for (int i = Process.myTid();; i = 0)
          {
            BizTimeLineUI.b(paramAnonymousAbsListView, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcBizTimeout, 903, WXHardCoderJNI.hcBizAction, "MicroMsg.BizTimeLineUI"));
            Log.d("MicroMsg.BizTimeLineUI", "summer hardcoder biz startPerformance [%s] [%s]", new Object[] { Integer.valueOf(903), Integer.valueOf(BizTimeLineUI.e(BizTimeLineUI.this)) });
            paramAnonymousAbsListView = BizTimeLineUI.f(BizTimeLineUI.this).iterator();
            while (paramAnonymousAbsListView.hasNext()) {
              paramAnonymousAbsListView.next();
            }
          }
          if (com.tencent.mm.plugin.brandservice.ui.b.b.dhR())
          {
            com.tencent.mm.modelimage.r.bKe().onScrollStateChanged(paramAnonymousInt);
            if ((paramAnonymousInt != 0) && (paramAnonymousInt != 1)) {
              break label293;
            }
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.e.XQp;
            com.tencent.mm.pluginsdk.model.e.iHG();
          }
          for (;;)
          {
            if (paramAnonymousInt == 0)
            {
              BizTimeLineUI.b(BizTimeLineUI.this).gt(BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.d(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.d(BizTimeLineUI.this).getLastVisiblePosition());
              MPVideoPreviewMgr.vXs.a("idle", BizTimeLineUI.d(BizTimeLineUI.this), BizTimeLineUI.b(BizTimeLineUI.this));
              paramAnonymousAbsListView = com.tencent.mm.plugin.brandservice.model.a.vBp;
              com.tencent.mm.plugin.brandservice.model.a.a(BizTimeLineUI.d(BizTimeLineUI.this), BizTimeLineUI.b(BizTimeLineUI.this));
            }
            AppMethodBeat.o(301766);
            return;
            label293:
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.e.XQp;
            com.tencent.mm.pluginsdk.model.e.iHH();
          }
        }
      });
      this.vHR.setOnTouchListener(new BizTimeLineUI.22(this));
      this.vHR.setEmptyView(this.emptyTipTv);
      if ((this.vIg) && (i != 0)) {
        ddg();
      }
      this.vHR.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5964);
          if (bool1) {
            if (i != 0) {
              BizTimeLineUI.this.ddi();
            }
          }
          for (;;)
          {
            if (!Util.isNullOrNil(paramBundle))
            {
              long l = ((com.tencent.mm.storage.ab)paramBundle.get(0)).field_orderFlag;
              f localf = BizTimeLineUI.this.vFK;
              int i = BizTimeLineUI.h(BizTimeLineUI.this);
              int j = BizTimeLineUI.this.getIntent().getIntExtra("Main_IndexInSessionList", 0);
              com.tencent.mm.plugin.brandservice.b.au(new f.3(localf, l, BizTimeLineUI.i(BizTimeLineUI.this).vPA, i, j));
            }
            BizTimeLineUI.j(BizTimeLineUI.this).eI(BizTimeLineUI.d(BizTimeLineUI.this));
            com.tencent.threadpool.h.ahAA.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(301819);
                BizTimeLineUI.j(BizTimeLineUI.this).eI(BizTimeLineUI.d(BizTimeLineUI.this));
                MPVideoPreviewMgr.vXs.a("init", BizTimeLineUI.d(BizTimeLineUI.this), BizTimeLineUI.b(BizTimeLineUI.this));
                com.tencent.mm.plugin.brandservice.model.a locala = com.tencent.mm.plugin.brandservice.model.a.vBp;
                com.tencent.mm.plugin.brandservice.model.a.a(BizTimeLineUI.d(BizTimeLineUI.this), BizTimeLineUI.b(BizTimeLineUI.this));
                AppMethodBeat.o(301819);
              }
            }, 100L);
            AppMethodBeat.o(5964);
            return;
            BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.b(BizTimeLineUI.this).Hk(0));
            continue;
            BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition(), BizTimeLineUI.d(BizTimeLineUI.this).getLastVisiblePosition());
          }
        }
      }, 10L);
      this.vHR.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(301923);
          BizTimeLineUI.b(BizTimeLineUI.this).gt(BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.d(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.d(BizTimeLineUI.this).getLastVisiblePosition());
          BizTimeLineUI.d(BizTimeLineUI.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(301923);
        }
      });
      com.tencent.mm.an.af.bHo().a(this.vIp, Looper.getMainLooper());
      new c();
      Log.d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
      i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWJ, Integer.valueOf(0))).intValue();
      if ((i & 0x4) == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxP("officialaccounts");
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acWJ, Integer.valueOf(i | 0x4));
      }
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(301823);
          Looper.myQueue().removeIdleHandler(this);
          Object localObject;
          if (BizTimeLineUI.b(BizTimeLineUI.this) != null)
          {
            localObject = BizTimeLineUI.b(BizTimeLineUI.this).dcO();
            if (localObject == null) {
              break label78;
            }
            com.tencent.mm.an.af.bHl().yO(((com.tencent.mm.storage.ab)localObject).field_orderFlag);
          }
          for (;;)
          {
            localObject = com.tencent.mm.storage.r.acDM;
            if (com.tencent.mm.storage.r.iXw()) {
              BizTLRecCardJsEngine.vKS.ddS().ioA();
            }
            AppMethodBeat.o(301823);
            return false;
            localObject = null;
            break;
            label78:
            com.tencent.mm.an.af.bHl().iYA();
          }
        }
      });
      com.tencent.mm.pluginsdk.h.x(this);
      this.vIz.alive();
      this.vIq.alive();
      this.vIr.alive();
      this.vIs.alive();
      if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(1)) {
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GW(90);
      }
      paramBundle = com.tencent.mm.an.af.bHl();
      if (paramBundle.acFO)
      {
        paramBundle.acFO = false;
        com.tencent.threadpool.h.ahAA.a(new ac.4(paramBundle), 1000L, "BizTimeLineInfoStorageThread");
      }
      com.tencent.mm.plugin.brandservice.ui.b.b.dhP();
      com.tencent.mm.pluginsdk.ui.applet.g.iKY();
      com.tencent.mm.api.b.aAG();
      com.tencent.mm.plugin.brandservice.model.c.dbS();
      com.tencent.mm.plugin.webcanvas.k.WkZ.ioP();
      paramBundle = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(65L);
      AppMethodBeat.o(5966);
      return;
      bool1 = false;
      break;
      label1244:
      if ((paramBundle instanceof RelativeLayout))
      {
        ((RelativeLayout)paramBundle).addView(this.vHS);
        paramBundle = (RelativeLayout.LayoutParams)this.vHS.getLayoutParams();
        paramBundle.width = -1;
        paramBundle.addRule(15);
        this.vHS.setLayoutParams(paramBundle);
      }
    }
    label1295:
    if (ad.iYS())
    {
      localObject2 = com.tencent.mm.an.af.bHl();
      k = Math.min(com.tencent.mm.model.p.bAr(), 10);
      long l = ((ac)localObject2).iYD();
      paramBundle = ((ac)localObject2).omV;
      localObject1 = "orderFlag DESC limit ".concat(String.valueOf(k));
      localObject1 = ac.s(paramBundle.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(l << 32) }, null, null, (String)localObject1));
      paramBundle = (Bundle)localObject1;
      if (Util.isNullOrNil((List)localObject1))
      {
        Log.i("MicroMsg.BizTimeLineInfoStorage", "firstGroupMsgList is null");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1378L, 3L, 1L, false);
      }
    }
    for (paramBundle = ((ac)localObject2).ayA(10);; paramBundle = com.tencent.mm.an.af.bHl().ayA(10))
    {
      localObject1 = new LinkedList();
      ((List)localObject1).addAll(paramBundle);
      com.tencent.mm.plugin.brandservice.ui.b.d.eH((List)localObject1);
      com.tencent.mm.plugin.brandservice.ui.b.d.a((List)localObject1, null);
      break;
    }
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: sipush 5979
    //   3: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 1517	com/tencent/mm/ui/MMActivity:onDestroy	()V
    //   10: ldc 255
    //   12: ldc_w 1519
    //   15: iconst_1
    //   16: anewarray 275	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_0
    //   22: invokevirtual 1522	java/lang/Object:hashCode	()I
    //   25: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: invokestatic 488	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aload_0
    //   33: getfield 437	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vFM	Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;
    //   36: ifnull +340 -> 376
    //   39: aload_0
    //   40: getfield 437	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vFM	Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;
    //   43: astore_3
    //   44: ldc_w 768
    //   47: invokestatic 321	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   50: checkcast 768	com/tencent/mm/plugin/messenger/foundation/a/n
    //   53: invokeinterface 1331 1 0
    //   58: aload_3
    //   59: checkcast 1524	com/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange
    //   62: invokeinterface 1527 2 0
    //   67: aload_3
    //   68: getfield 1530	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView:vPE	Lcom/tencent/mm/sdk/event/IListener;
    //   71: invokevirtual 1533	com/tencent/mm/sdk/event/IListener:dead	()V
    //   74: aload_3
    //   75: getfield 1537	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView:vOC	Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/h;
    //   78: astore 4
    //   80: new 1539	com/tencent/mm/am/c$a
    //   83: dup
    //   84: invokespecial 1540	com/tencent/mm/am/c$a:<init>	()V
    //   87: astore 6
    //   89: new 1542	com/tencent/mm/protocal/protobuf/dvw
    //   92: dup
    //   93: invokespecial 1543	com/tencent/mm/protocal/protobuf/dvw:<init>	()V
    //   96: astore 5
    //   98: aload 6
    //   100: aload 5
    //   102: putfield 1547	com/tencent/mm/am/c$a:otE	Lcom/tencent/mm/bx/a;
    //   105: aload 6
    //   107: new 1549	com/tencent/mm/protocal/protobuf/dvx
    //   110: dup
    //   111: invokespecial 1550	com/tencent/mm/protocal/protobuf/dvx:<init>	()V
    //   114: putfield 1553	com/tencent/mm/am/c$a:otF	Lcom/tencent/mm/bx/a;
    //   117: aload 6
    //   119: ldc_w 1555
    //   122: putfield 1558	com/tencent/mm/am/c$a:uri	Ljava/lang/String;
    //   125: aload 6
    //   127: sipush 2550
    //   130: putfield 1561	com/tencent/mm/am/c$a:funcId	I
    //   133: aload 6
    //   135: invokevirtual 1565	com/tencent/mm/am/c$a:bEF	()Lcom/tencent/mm/am/c;
    //   138: astore 6
    //   140: aload 5
    //   142: invokestatic 1568	com/tencent/mm/storage/ad:getSessionId	()I
    //   145: putfield 1571	com/tencent/mm/protocal/protobuf/dvw:YPI	I
    //   148: aload 5
    //   150: aload 4
    //   152: getfield 1576	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/h:vQb	Ljava/util/LinkedList;
    //   155: putfield 1579	com/tencent/mm/protocal/protobuf/dvw:abbI	Ljava/util/LinkedList;
    //   158: new 1503	java/util/LinkedList
    //   161: dup
    //   162: invokespecial 1504	java/util/LinkedList:<init>	()V
    //   165: astore 7
    //   167: aload 4
    //   169: getfield 1583	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/h:vQa	Ljava/util/HashMap;
    //   172: invokevirtual 1586	java/util/HashMap:size	()I
    //   175: ifle +55 -> 230
    //   178: aload 4
    //   180: getfield 1583	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/h:vQa	Ljava/util/HashMap;
    //   183: invokevirtual 1589	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   186: invokeinterface 921 1 0
    //   191: astore 8
    //   193: aload 8
    //   195: invokeinterface 926 1 0
    //   200: ifeq +30 -> 230
    //   203: aload 7
    //   205: aload 8
    //   207: invokeinterface 930 1 0
    //   212: checkcast 1591	java/util/Map$Entry
    //   215: invokeinterface 1594 1 0
    //   220: checkcast 1596	com/tencent/mm/protocal/protobuf/dvy
    //   223: invokevirtual 1597	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: goto -34 -> 193
    //   230: aload 5
    //   232: aload 7
    //   234: putfield 1600	com/tencent/mm/protocal/protobuf/dvw:abbH	Ljava/util/LinkedList;
    //   237: aload 5
    //   239: iconst_0
    //   240: putfield 1601	com/tencent/mm/protocal/protobuf/dvw:source	I
    //   243: aload 6
    //   245: new 1603	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/h$1
    //   248: dup
    //   249: aload 4
    //   251: invokespecial 1606	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/h$1:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/h;)V
    //   254: invokestatic 1611	com/tencent/mm/am/z:a	(Lcom/tencent/mm/am/c;Lcom/tencent/mm/am/z$a;)Lcom/tencent/mm/am/c;
    //   257: pop
    //   258: invokestatic 1615	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   261: sipush 2768
    //   264: aload_3
    //   265: checkcast 1617	com/tencent/mm/am/h
    //   268: invokevirtual 1622	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   271: aload_3
    //   272: getfield 1626	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView:vPv	Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;
    //   275: astore 4
    //   277: aload 4
    //   279: ifnull +9 -> 288
    //   282: aload 4
    //   284: aconst_null
    //   285: invokevirtual 1631	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView:setAdapter	(Landroidx/recyclerview/widget/RecyclerView$a;)V
    //   288: aload_3
    //   289: getfield 1626	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView:vPv	Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;
    //   292: astore 4
    //   294: aload 4
    //   296: ifnull +8 -> 304
    //   299: aload 4
    //   301: invokevirtual 1632	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView:onDestroy	()V
    //   304: aload_3
    //   305: getfield 1636	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView:vPD	Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/a;
    //   308: astore_3
    //   309: aload_3
    //   310: ifnull +33 -> 343
    //   313: aload_3
    //   314: invokevirtual 1642	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/a:deg	()Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;
    //   317: astore 4
    //   319: aload 4
    //   321: ifnull +9 -> 330
    //   324: aload 4
    //   326: aconst_null
    //   327: invokevirtual 1631	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView:setAdapter	(Landroidx/recyclerview/widget/RecyclerView$a;)V
    //   330: aload_3
    //   331: invokevirtual 1642	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/a:deg	()Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;
    //   334: astore_3
    //   335: aload_3
    //   336: ifnull +7 -> 343
    //   339: aload_3
    //   340: invokevirtual 1632	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView:onDestroy	()V
    //   343: getstatic 1648	com/tencent/mm/pluginsdk/model/c:XPt	Lcom/tencent/mm/pluginsdk/model/c;
    //   346: astore_3
    //   347: invokestatic 1651	com/tencent/mm/pluginsdk/model/c:iGW	()Z
    //   350: ifeq +26 -> 376
    //   353: getstatic 1209	com/tencent/mm/plugin/brandservice/model/a:vBp	Lcom/tencent/mm/plugin/brandservice/model/a;
    //   356: astore_3
    //   357: invokestatic 1654	com/tencent/mm/plugin/brandservice/model/a:dbP	()V
    //   360: invokestatic 1658	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView:deC	()Lcom/tencent/mm/sdk/event/IListener;
    //   363: astore_3
    //   364: aload_3
    //   365: ifnull +7 -> 372
    //   368: aload_3
    //   369: invokevirtual 1533	com/tencent/mm/sdk/event/IListener:dead	()V
    //   372: aconst_null
    //   373: invokestatic 1661	com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView:b	(Lcom/tencent/mm/sdk/event/IListener;)V
    //   376: aload_0
    //   377: getfield 967	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vHZ	Lcom/tencent/mm/plugin/brandservice/ui/timeline/d;
    //   380: getfield 970	com/tencent/mm/plugin/brandservice/ui/timeline/d:rDF	Lcom/tencent/mm/sdk/event/IListener;
    //   383: invokevirtual 1533	com/tencent/mm/sdk/event/IListener:dead	()V
    //   386: iconst_0
    //   387: invokestatic 943	com/tencent/mm/storage/ad:KC	(Z)V
    //   390: invokestatic 876	java/lang/System:currentTimeMillis	()J
    //   393: putstatic 1664	com/tencent/mm/storage/ad:acGh	J
    //   396: aload_0
    //   397: getfield 252	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vHY	Lcom/tencent/mm/plugin/brandservice/ui/timeline/b;
    //   400: ifnull +106 -> 506
    //   403: aload_0
    //   404: getfield 265	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vHR	Lcom/tencent/mm/plugin/bizui/widget/StoryListView;
    //   407: ifnull +99 -> 506
    //   410: aload_0
    //   411: getfield 252	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vHY	Lcom/tencent/mm/plugin/brandservice/ui/timeline/b;
    //   414: invokevirtual 1667	com/tencent/mm/plugin/brandservice/ui/timeline/b:dcN	()Lcom/tencent/mm/storage/ab;
    //   417: astore_3
    //   418: aload_3
    //   419: ifnull +432 -> 851
    //   422: aload_3
    //   423: getfield 518	com/tencent/mm/storage/ab:field_orderFlag	J
    //   426: putstatic 1188	com/tencent/mm/storage/ad:acGi	J
    //   429: aload_0
    //   430: getfield 252	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vHY	Lcom/tencent/mm/plugin/brandservice/ui/timeline/b;
    //   433: invokestatic 1214	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:ddm	()I
    //   436: invokevirtual 298	com/tencent/mm/plugin/brandservice/ui/timeline/b:Hk	(I)Lcom/tencent/mm/storage/ab;
    //   439: astore_3
    //   440: aload_3
    //   441: ifnull +425 -> 866
    //   444: aload_3
    //   445: invokevirtual 480	com/tencent/mm/storage/ab:getId	()Ljava/lang/String;
    //   448: putstatic 115	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vIa	Ljava/lang/String;
    //   451: aload_0
    //   452: getfield 252	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vHY	Lcom/tencent/mm/plugin/brandservice/ui/timeline/b;
    //   455: astore_3
    //   456: invokestatic 532	com/tencent/mm/an/af:bHl	()Lcom/tencent/mm/storage/ac;
    //   459: aload_3
    //   460: getfield 1670	com/tencent/mm/plugin/brandservice/ui/timeline/b:vAF	Lcom/tencent/mm/storage/ac$c;
    //   463: invokevirtual 1673	com/tencent/mm/storage/ac:a	(Lcom/tencent/mm/storage/ac$c;)V
    //   466: aload_3
    //   467: getfield 1677	com/tencent/mm/plugin/brandservice/ui/timeline/b:vFN	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/d;
    //   470: getfield 1682	com/tencent/mm/plugin/brandservice/ui/timeline/preload/d:vQx	Ljava/util/List;
    //   473: invokeinterface 1683 1 0
    //   478: getstatic 1687	com/tencent/mm/model/p:ojc	Lcom/tencent/mm/model/p$a;
    //   481: astore 4
    //   483: aload_3
    //   484: getfield 1690	com/tencent/mm/plugin/brandservice/ui/timeline/b:vFH	Ljava/util/List;
    //   487: astore_3
    //   488: aload_3
    //   489: ldc_w 1692
    //   492: invokestatic 1698	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   495: aload_3
    //   496: ldc_w 1700
    //   499: invokestatic 1698	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   502: aload_3
    //   503: invokestatic 1703	com/tencent/mm/model/p:bQ	(Ljava/util/List;)V
    //   506: invokestatic 742	com/tencent/mm/an/af:bHo	()Lcom/tencent/mm/storage/ag;
    //   509: aload_0
    //   510: getfield 178	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vIp	Lcom/tencent/mm/storage/ac$c;
    //   513: invokevirtual 1704	com/tencent/mm/storage/ag:a	(Lcom/tencent/mm/storage/ac$c;)V
    //   516: aload_0
    //   517: getfield 131	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vGY	J
    //   520: lconst_0
    //   521: lcmp
    //   522: ifeq +94 -> 616
    //   525: invokestatic 876	java/lang/System:currentTimeMillis	()J
    //   528: lstore_1
    //   529: aload_0
    //   530: aload_0
    //   531: getfield 135	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:uoT	J
    //   534: lload_1
    //   535: aload_0
    //   536: getfield 133	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vIe	J
    //   539: lsub
    //   540: ladd
    //   541: putfield 135	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:uoT	J
    //   544: getstatic 1489	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   547: sipush 13932
    //   550: iconst_5
    //   551: anewarray 275	java/lang/Object
    //   554: dup
    //   555: iconst_0
    //   556: lload_1
    //   557: aload_0
    //   558: getfield 131	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vGY	J
    //   561: lsub
    //   562: l2i
    //   563: sipush 1000
    //   566: idiv
    //   567: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   570: aastore
    //   571: dup
    //   572: iconst_1
    //   573: iconst_1
    //   574: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   577: aastore
    //   578: dup
    //   579: iconst_2
    //   580: aload_0
    //   581: getfield 230	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:hBm	I
    //   584: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   587: aastore
    //   588: dup
    //   589: iconst_3
    //   590: aload_0
    //   591: getfield 135	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:uoT	J
    //   594: ldc2_w 976
    //   597: ldiv
    //   598: l2i
    //   599: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   602: aastore
    //   603: dup
    //   604: iconst_4
    //   605: aload_0
    //   606: getfield 137	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:source	I
    //   609: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   612: aastore
    //   613: invokevirtual 1707	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   616: aload_0
    //   617: getfield 216	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vIz	Lcom/tencent/mm/sdk/event/IListener;
    //   620: invokevirtual 1533	com/tencent/mm/sdk/event/IListener:dead	()V
    //   623: aload_0
    //   624: getfield 191	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vIq	Lcom/tencent/mm/sdk/event/IListener;
    //   627: invokevirtual 1533	com/tencent/mm/sdk/event/IListener:dead	()V
    //   630: aload_0
    //   631: getfield 194	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vIr	Lcom/tencent/mm/sdk/event/IListener;
    //   634: invokevirtual 1533	com/tencent/mm/sdk/event/IListener:dead	()V
    //   637: aload_0
    //   638: getfield 197	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vIs	Lcom/tencent/mm/sdk/event/IListener;
    //   641: invokevirtual 1533	com/tencent/mm/sdk/event/IListener:dead	()V
    //   644: aload_0
    //   645: getfield 505	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vFK	Lcom/tencent/mm/plugin/brandservice/ui/timeline/f;
    //   648: invokestatic 1214	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:ddm	()I
    //   651: putfield 1710	com/tencent/mm/plugin/brandservice/ui/timeline/f:vGX	I
    //   654: aload_0
    //   655: getfield 505	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vFK	Lcom/tencent/mm/plugin/brandservice/ui/timeline/f;
    //   658: astore_3
    //   659: getstatic 1376	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   662: new 1712	com/tencent/mm/plugin/brandservice/ui/timeline/f$2
    //   665: dup
    //   666: aload_3
    //   667: invokespecial 1715	com/tencent/mm/plugin/brandservice/ui/timeline/f$2:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/f;)V
    //   670: ldc_w 1717
    //   673: invokeinterface 1720 3 0
    //   678: pop
    //   679: aload_3
    //   680: getfield 1724	com/tencent/mm/plugin/brandservice/ui/timeline/f:vHj	Lcom/tencent/mm/plugin/brandservice/ui/timeline/f$a;
    //   683: ifnull +92 -> 775
    //   686: getstatic 1489	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   689: sipush 21136
    //   692: bipush 6
    //   694: anewarray 275	java/lang/Object
    //   697: dup
    //   698: iconst_0
    //   699: aload_3
    //   700: getfield 1724	com/tencent/mm/plugin/brandservice/ui/timeline/f:vHj	Lcom/tencent/mm/plugin/brandservice/ui/timeline/f$a;
    //   703: getfield 1729	com/tencent/mm/plugin/brandservice/ui/timeline/f$a:vHs	I
    //   706: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   709: aastore
    //   710: dup
    //   711: iconst_1
    //   712: aload_3
    //   713: getfield 1724	com/tencent/mm/plugin/brandservice/ui/timeline/f:vHj	Lcom/tencent/mm/plugin/brandservice/ui/timeline/f$a;
    //   716: getfield 1732	com/tencent/mm/plugin/brandservice/ui/timeline/f$a:vHt	I
    //   719: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   722: aastore
    //   723: dup
    //   724: iconst_2
    //   725: aload_3
    //   726: getfield 1724	com/tencent/mm/plugin/brandservice/ui/timeline/f:vHj	Lcom/tencent/mm/plugin/brandservice/ui/timeline/f$a;
    //   729: getfield 1735	com/tencent/mm/plugin/brandservice/ui/timeline/f$a:msgType	I
    //   732: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   735: aastore
    //   736: dup
    //   737: iconst_3
    //   738: aload_3
    //   739: getfield 1724	com/tencent/mm/plugin/brandservice/ui/timeline/f:vHj	Lcom/tencent/mm/plugin/brandservice/ui/timeline/f$a;
    //   742: getfield 1736	com/tencent/mm/plugin/brandservice/ui/timeline/f$a:hBm	I
    //   745: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   748: aastore
    //   749: dup
    //   750: iconst_4
    //   751: aload_3
    //   752: getfield 1724	com/tencent/mm/plugin/brandservice/ui/timeline/f:vHj	Lcom/tencent/mm/plugin/brandservice/ui/timeline/f$a;
    //   755: getfield 1739	com/tencent/mm/plugin/brandservice/ui/timeline/f$a:hUQ	Ljava/lang/String;
    //   758: aastore
    //   759: dup
    //   760: iconst_5
    //   761: aload_3
    //   762: getfield 1724	com/tencent/mm/plugin/brandservice/ui/timeline/f:vHj	Lcom/tencent/mm/plugin/brandservice/ui/timeline/f$a;
    //   765: getfield 1742	com/tencent/mm/plugin/brandservice/ui/timeline/f$a:vHu	I
    //   768: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   771: aastore
    //   772: invokevirtual 1707	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   775: invokestatic 1747	com/tencent/mm/plugin/brandservice/ui/b/c:clean	()V
    //   778: invokestatic 1750	com/tencent/mm/ui/chatting/as:clear	()V
    //   781: iconst_0
    //   782: invokestatic 1001	com/tencent/mm/storage/ad:HV	(I)V
    //   785: aload_0
    //   786: invokevirtual 1753	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:getContentView	()Landroid/view/View;
    //   789: instanceof 313
    //   792: ifeq +13 -> 805
    //   795: aload_0
    //   796: invokevirtual 1753	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:getContentView	()Landroid/view/View;
    //   799: checkcast 313	android/view/ViewGroup
    //   802: invokevirtual 1756	android/view/ViewGroup:removeAllViews	()V
    //   805: getstatic 423	com/tencent/mm/pluginsdk/model/e:XQp	Lcom/tencent/mm/pluginsdk/model/e;
    //   808: astore_3
    //   809: invokestatic 1759	com/tencent/mm/pluginsdk/model/e:iHF	()V
    //   812: invokestatic 1762	com/tencent/mm/plugin/brandservice/model/c:release	()V
    //   815: aload_0
    //   816: getfield 173	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vIo	Ljava/util/Set;
    //   819: invokeinterface 921 1 0
    //   824: astore_3
    //   825: aload_3
    //   826: invokeinterface 926 1 0
    //   831: ifeq +79 -> 910
    //   834: aload_3
    //   835: invokeinterface 930 1 0
    //   840: checkcast 1764	com/tencent/mm/plugin/webcanvas/d
    //   843: invokeinterface 1765 1 0
    //   848: goto -23 -> 825
    //   851: invokestatic 532	com/tencent/mm/an/af:bHl	()Lcom/tencent/mm/storage/ac;
    //   854: invokevirtual 1768	com/tencent/mm/storage/ac:iYa	()J
    //   857: bipush 32
    //   859: lshl
    //   860: putstatic 1188	com/tencent/mm/storage/ad:acGi	J
    //   863: goto -434 -> 429
    //   866: ldc 255
    //   868: ldc_w 1770
    //   871: iconst_1
    //   872: anewarray 275	java/lang/Object
    //   875: dup
    //   876: iconst_0
    //   877: invokestatic 1214	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:ddm	()I
    //   880: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   883: aastore
    //   884: invokestatic 1772	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   887: goto -436 -> 451
    //   890: astore_3
    //   891: ldc 255
    //   893: ldc_w 1774
    //   896: iconst_1
    //   897: anewarray 275	java/lang/Object
    //   900: dup
    //   901: iconst_0
    //   902: aload_3
    //   903: aastore
    //   904: invokestatic 1772	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   907: goto -102 -> 805
    //   910: getstatic 1780	com/tencent/mm/storage/r:acDM	Lcom/tencent/mm/storage/r;
    //   913: astore_3
    //   914: invokestatic 1783	com/tencent/mm/storage/r:kLW	()Z
    //   917: pop
    //   918: aload_0
    //   919: getfield 171	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vIn	Ljava/util/Set;
    //   922: invokeinterface 1784 1 0
    //   927: aload_0
    //   928: getfield 173	com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI:vIo	Ljava/util/Set;
    //   931: invokeinterface 1784 1 0
    //   936: getstatic 1790	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXs	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr;
    //   939: astore_3
    //   940: getstatic 1793	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXt	Z
    //   943: ifeq +174 -> 1117
    //   946: getstatic 1797	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXA	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a;
    //   949: astore_3
    //   950: getstatic 1801	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXw	Ljava/lang/ref/WeakReference;
    //   953: astore 4
    //   955: aload 4
    //   957: ifnonnull +200 -> 1157
    //   960: lconst_0
    //   961: lstore_1
    //   962: aload_3
    //   963: lload_1
    //   964: putfield 1806	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:vXQ	J
    //   967: getstatic 1797	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXA	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a;
    //   970: iconst_4
    //   971: invokevirtual 1809	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:rG	(I)V
    //   974: getstatic 1797	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXA	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a;
    //   977: astore_3
    //   978: aload_3
    //   979: aconst_null
    //   980: putfield 1813	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:vXJ	Lcom/tencent/mm/storage/ab;
    //   983: aload_3
    //   984: aconst_null
    //   985: invokevirtual 1816	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:d	(Lcom/tencent/mm/message/v;)V
    //   988: aload_3
    //   989: ldc_w 1818
    //   992: invokevirtual 1821	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:ajZ	(Ljava/lang/String;)V
    //   995: aload_3
    //   996: iconst_0
    //   997: putfield 1824	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:bUo	I
    //   1000: aload_3
    //   1001: getfield 1827	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:vXN	Ljava/util/HashMap;
    //   1004: invokevirtual 1828	java/util/HashMap:clear	()V
    //   1007: aload_3
    //   1008: iconst_0
    //   1009: invokevirtual 1831	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:setVideoDuration	(I)V
    //   1012: aload_3
    //   1013: lconst_0
    //   1014: putfield 1806	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:vXQ	J
    //   1017: aload_3
    //   1018: lconst_0
    //   1019: putfield 1834	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:vXR	J
    //   1022: aload_3
    //   1023: lconst_0
    //   1024: putfield 1837	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:vXS	J
    //   1027: aload_3
    //   1028: lconst_0
    //   1029: putfield 1840	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:vXT	J
    //   1032: aload_3
    //   1033: lconst_0
    //   1034: putfield 1843	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:vXU	J
    //   1037: aload_3
    //   1038: ldc_w 1845
    //   1041: putfield 1848	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$a:vXM	Ljava/lang/String;
    //   1044: getstatic 1801	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXw	Ljava/lang/ref/WeakReference;
    //   1047: astore_3
    //   1048: aload_3
    //   1049: ifnull +19 -> 1068
    //   1052: aload_3
    //   1053: invokevirtual 1852	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1056: checkcast 1854	com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView
    //   1059: astore_3
    //   1060: aload_3
    //   1061: ifnull +7 -> 1068
    //   1064: aload_3
    //   1065: invokevirtual 1857	com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView:onUIDestroy	()V
    //   1068: ldc_w 1845
    //   1071: putstatic 1860	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXC	Ljava/lang/String;
    //   1074: aconst_null
    //   1075: putstatic 1864	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXE	[I
    //   1078: aconst_null
    //   1079: putstatic 1867	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXu	Ljava/lang/ref/WeakReference;
    //   1082: aconst_null
    //   1083: putstatic 1870	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXv	Ljava/lang/ref/WeakReference;
    //   1086: aconst_null
    //   1087: putstatic 1801	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXw	Ljava/lang/ref/WeakReference;
    //   1090: aconst_null
    //   1091: putstatic 1873	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXx	Ljava/lang/ref/WeakReference;
    //   1094: aconst_null
    //   1095: putstatic 1876	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXy	Ljava/lang/ref/WeakReference;
    //   1098: getstatic 1879	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXG	Ljava/util/HashSet;
    //   1101: invokevirtual 288	java/util/HashSet:clear	()V
    //   1104: invokestatic 1882	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:stopTimer	()V
    //   1107: aconst_null
    //   1108: putstatic 1886	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXz	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   1111: getstatic 1889	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr:vXH	Ljava/util/HashMap;
    //   1114: invokevirtual 1828	java/util/HashMap:clear	()V
    //   1117: getstatic 1209	com/tencent/mm/plugin/brandservice/model/a:vBp	Lcom/tencent/mm/plugin/brandservice/model/a;
    //   1120: astore_3
    //   1121: invokestatic 1890	com/tencent/mm/plugin/brandservice/model/a:onDestroy	()V
    //   1124: getstatic 1896	com/tencent/mm/plugin/brandservice/ui/timeline/item/j:vJo	Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/j;
    //   1127: astore_3
    //   1128: invokestatic 1899	com/tencent/mm/plugin/brandservice/ui/timeline/item/j:ddq	()V
    //   1131: getstatic 1780	com/tencent/mm/storage/r:acDM	Lcom/tencent/mm/storage/r;
    //   1134: astore_3
    //   1135: invokestatic 1902	com/tencent/mm/storage/r:iXw	()Z
    //   1138: ifeq +12 -> 1150
    //   1141: getstatic 1908	com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine:vKS	Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$Companion;
    //   1144: invokevirtual 1914	com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$Companion:ddS	()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;
    //   1147: invokevirtual 1917	com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine:ioB	()V
    //   1150: sipush 5979
    //   1153: invokestatic 224	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1156: return
    //   1157: aload 4
    //   1159: invokevirtual 1852	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1162: checkcast 1854	com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView
    //   1165: astore 4
    //   1167: aload 4
    //   1169: ifnonnull +8 -> 1177
    //   1172: lconst_0
    //   1173: lstore_1
    //   1174: goto -212 -> 962
    //   1177: aload 4
    //   1179: invokevirtual 1920	com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView:getCurrPosMs	()I
    //   1182: i2l
    //   1183: lstore_1
    //   1184: goto -222 -> 962
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1187	0	this	BizTimeLineUI
    //   528	656	1	l	long
    //   43	792	3	localObject1	Object
    //   890	13	3	localObject2	Object
    //   913	222	3	localObject3	Object
    //   78	1100	4	localObject4	Object
    //   96	142	5	localdvw	com.tencent.mm.protocal.protobuf.dvw
    //   87	157	6	localObject5	Object
    //   165	68	7	localLinkedList	LinkedList
    //   191	15	8	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   785	805	890	finally
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5981);
    super.onPause();
    if (this.vHY != null)
    {
      localObject = this.vHY;
      ((b)localObject).hJi = true;
      ((b)localObject).vFN.vQB = true;
    }
    for (Object localObject = this.vHY.dcO();; localObject = null)
    {
      int i;
      if (localObject != null)
      {
        com.tencent.mm.an.af.bHl().yO(((com.tencent.mm.storage.ab)localObject).field_orderFlag);
        if (this.vHR == null) {
          break label227;
        }
        localObject = this.vHR.getChildAt(0);
        if (localObject == null) {
          break label222;
        }
        i = ((View)localObject).getTop();
      }
      label91:
      label222:
      label227:
      for (vIb = i;; vIb = 0)
      {
        this.hJi = true;
        long l = System.currentTimeMillis();
        this.uoT += l - this.vIe;
        this.vIe = l;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBizEnable, this.lyw);
        this.lyw = 0;
        com.tencent.mm.pluginsdk.ui.span.p.b(this.vIA);
        localObject = com.tencent.mm.pluginsdk.ui.applet.g.Ybp;
        if (com.tencent.mm.pluginsdk.ui.applet.g.awm(1))
        {
          localObject = com.tencent.mm.pluginsdk.model.e.XQp;
          com.tencent.mm.pluginsdk.model.e.iHI();
        }
        ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), null);
        localObject = this.vIo.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.webcanvas.d)((Iterator)localObject).next()).onPause();
        }
        com.tencent.mm.an.af.bHl().iYA();
        break;
        i = 0;
        break label91;
      }
      localObject = MPVideoPreviewMgr.vXs;
      MPVideoPreviewMgr.ajT("ONPAUSE");
      localObject = com.tencent.mm.pluginsdk.model.c.XPt;
      if (com.tencent.mm.pluginsdk.model.c.iGW())
      {
        localObject = com.tencent.mm.plugin.brandservice.model.a.vBp;
        com.tencent.mm.plugin.brandservice.model.a.dbP();
      }
      AppMethodBeat.o(5981);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5980);
    super.onResume();
    Log.d("MicroMsg.BizTimeLineUI", "BizTimeLineUI onResume");
    if (this.vIf)
    {
      this.vIf = false;
      this.vFK.Hm(8);
    }
    Object localObject1;
    Object localObject3;
    int i;
    if (this.vHY != null)
    {
      localObject1 = this.vHY;
      ((b)localObject1).hJi = false;
      localObject3 = ((b)localObject1).vFN;
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject3).vQB)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject3).vQB = false;
        if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject3).vQu <= 0) {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject3).deM();
        }
      }
      localObject3 = b.vFE;
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.deb() != null)
      {
        localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        localObject3 = (CharSequence)com.tencent.mm.plugin.brandservice.ui.timeline.a.a.dec();
        if ((localObject3 != null) && (!kotlin.n.n.bp((CharSequence)localObject3))) {
          break label225;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        label126:
        if (this.hJi)
        {
          this.hJi = false;
          ddi();
          localObject1 = com.tencent.mm.plugin.brandservice.model.a.vBp;
          com.tencent.mm.plugin.brandservice.model.a.a(this.vHR, this.vHY);
        }
        this.vIe = System.currentTimeMillis();
        com.tencent.mm.plugin.brandservice.b.av(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(301814);
            if ((BizTimeLineUI.this.isFinishing()) || (BizTimeLineUI.d(BizTimeLineUI.this) == null) || (BizTimeLineUI.d(BizTimeLineUI.this).getFirstVisiblePosition() != 0) || (BizTimeLineUI.i(BizTimeLineUI.this) == null))
            {
              AppMethodBeat.o(301814);
              return;
            }
            BizTimeLineUI.i(BizTimeLineUI.this).del();
            AppMethodBeat.o(301814);
          }
        });
        com.tencent.mm.pluginsdk.ui.span.p.a(this.vIA);
      }
      try
      {
        ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), this);
        localObject1 = this.vIo.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            ((com.tencent.mm.plugin.webcanvas.d)((Iterator)localObject1).next()).onResume();
            continue;
            label225:
            i = 0;
            break;
            localObject3 = com.tencent.mm.model.p.ojc;
            if (!((Boolean)com.tencent.mm.model.p.bAt().getValue()).booleanValue())
            {
              Log.i("MicroMsg.BizTimeLineAdapter", "getRecFeedsOnClickBack not open");
              break label126;
            }
            localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
            if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.ded() != a.a.vNU)
            {
              Log.i("MicroMsg.BizTimeLineAdapter", s.X("checkRefreshFirstScreenData recFeedExposed=", Boolean.valueOf(b.vFY)));
              if (b.vFY) {
                break label126;
              }
              localObject3 = com.tencent.mm.model.p.ojc;
              if (!((Boolean)com.tencent.mm.model.p.bAu().getValue()).booleanValue())
              {
                Log.i("MicroMsg.BizTimeLineAdapter", "checkRefreshFirstScreenData not open");
                break label126;
              }
              localObject3 = com.tencent.mm.model.p.ojc;
              i = p.a.atj().decodeInt("BizTLRecommendFeedsRefreshFreq", 0);
              Log.i("Micromsg.BizTLRecFeedsDataUtil", s.X("getRefreshFreq = ", Integer.valueOf(i)));
              if (i <= ((b)localObject1).vFT)
              {
                Log.i("MicroMsg.BizTimeLineAdapter", s.X("checkRefreshFirstScreenData over refresh times refreshRecFeedTimesOnBizBack=", Integer.valueOf(((b)localObject1).vFT)));
                break label126;
              }
              localObject3 = com.tencent.mm.model.p.ojc;
              i = p.a.a(p.f.ojy);
              if (Math.abs(System.currentTimeMillis() - b.vFZ) < i)
              {
                Log.i("MicroMsg.BizTimeLineAdapter", s.X("checkRefreshFirstScreenData should not do refresh in ", Integer.valueOf(i)));
                break label126;
              }
              b.vFZ = System.currentTimeMillis();
              ((b)localObject1).vFT += 1;
              localObject3 = b.vFE;
              localObject3 = p.f.ojy;
              b.a locala = b.vFE;
              b.a.a((b)localObject1, (p.f)localObject3, false, b.a.a(new eni()), 4);
              break label126;
            }
            localObject3 = new WeakReference(localObject1);
            localObject1 = new WeakReference(((b)localObject1).vFF);
            kotlinx.coroutines.j.a((kotlinx.coroutines.aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (kotlin.g.a.m)new b.a.d((WeakReference)localObject3, (WeakReference)localObject1, null), 2);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("MicroMsg.BizTimeLineUI", "setScreenShotCallback fail e:%s", new Object[] { localException.getMessage() });
        }
        Object localObject2 = MPVideoPreviewMgr.vXs;
        MPVideoPreviewMgr.ajT("ONRESUME");
        localObject2 = this.vFM;
        localObject3 = com.tencent.mm.pluginsdk.model.c.XPt;
        if (com.tencent.mm.pluginsdk.model.c.iGW())
        {
          localObject3 = com.tencent.mm.plugin.brandservice.model.a.vBp;
          com.tencent.mm.plugin.brandservice.model.a.a((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.k)localObject2, ((BizTimeLineHotView)localObject2).vPA);
        }
        localObject2 = com.tencent.mm.pluginsdk.model.c.XPt;
        com.tencent.mm.pluginsdk.model.c.onResume();
        AppMethodBeat.o(5980);
      }
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(302189);
    paramString = this.vIn.iterator();
    while (paramString.hasNext()) {
      ((com.tencent.mm.plugin.webcanvas.f)paramString.next()).ddE();
    }
    AppMethodBeat.o(302189);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI
 * JD-Core Version:    0.7.0.1
 */