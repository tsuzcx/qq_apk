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
import android.text.TextUtils;
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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.o;
import com.tencent.mm.model.p.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e;
import com.tencent.mm.pluginsdk.model.c.h;
import com.tencent.mm.pluginsdk.model.c.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.dea;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aa.4;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.aa.c;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ag;
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
import com.tencent.mm.ui.w;
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
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;

@com.tencent.mm.kernel.k
public class BizTimeLineUI
  extends MMActivity
  implements h, com.tencent.mm.plugin.webcanvas.g, ScreenShotUtil.ScreenShotCallback
{
  private static String sCi = null;
  private static int sCj = 0;
  private static int sCk = 0;
  private TextView emptyTipTv;
  private boolean fEs;
  private int fwM;
  private int iWt;
  private int mScrollState;
  private View mXN;
  private long rgX;
  private BizTimeLineHotView sAb;
  public StoryListView sBZ;
  private View sBm;
  private long sBz;
  private final int sCA;
  private long sCB;
  private final long sCC;
  private boolean sCD;
  private boolean sCE;
  private IListener sCF;
  private com.tencent.mm.pluginsdk.ui.span.i sCG;
  private View sCa;
  private ImageView sCb;
  private LinearLayout sCc;
  private TextView sCd;
  private TextView sCe;
  private View sCf;
  private b sCg;
  private d sCh;
  private com.tencent.mm.plugin.brandservice.ui.timeline.a.b sCl;
  private long sCm;
  private boolean sCn;
  private boolean sCo;
  private boolean sCp;
  private int sCq;
  private int sCr;
  private int sCs;
  private boolean sCt;
  private HashSet<String> sCu;
  private final Set<com.tencent.mm.plugin.webcanvas.h> sCv;
  private final Set<com.tencent.mm.plugin.webcanvas.f> sCw;
  private aa.c sCx;
  private IListener sCy;
  private int sCz;
  private int source;
  public f szZ;
  
  public BizTimeLineUI()
  {
    AppMethodBeat.i(5965);
    this.sBz = 0L;
    this.sCm = 0L;
    this.rgX = 0L;
    this.source = 1;
    this.sCn = false;
    this.sCo = false;
    this.sCp = false;
    this.fEs = false;
    this.sCq = 0;
    this.sCr = -1;
    this.sCs = -1;
    this.mScrollState = 0;
    this.sCt = false;
    this.sCu = new HashSet();
    this.sCv = Collections.newSetFromMap(new ConcurrentHashMap());
    this.sCw = Collections.newSetFromMap(new ConcurrentHashMap());
    this.sCx = new aa.c()
    {
      public final void a(Object paramAnonymousObject, aa.a paramAnonymousa)
      {
        AppMethodBeat.i(5955);
        BizTimeLineUI.this.cAg();
        AppMethodBeat.o(5955);
      }
    };
    this.sCy = new BizTimeLineUI.14(this);
    this.sCz = 0;
    this.sCA = 20;
    this.sCB = 0L;
    this.sCC = 100L;
    this.sCD = false;
    this.sCE = false;
    this.sCF = new BizTimeLineUI.10(this);
    this.sCG = new BizTimeLineUI.11(this);
    AppMethodBeat.o(5965);
  }
  
  private void cAh()
  {
    AppMethodBeat.i(257856);
    if ((this.sCg == null) || (this.sBZ == null) || (Util.isNullOrNil(sCi)))
    {
      AppMethodBeat.o(257856);
      return;
    }
    int i = 0;
    while (i < this.sCg.getCount())
    {
      z localz = this.sCg.GK(i);
      if ((localz != null) && (Util.isEqual(sCi, localz.getId())))
      {
        Log.i("MicroMsg.BizTimeLineUI", "tryToScrollToPosition %d top %d", new Object[] { Integer.valueOf(i), Integer.valueOf(sCj) });
        i(localz, i + 1);
        AppMethodBeat.o(257856);
        return;
      }
      i += 1;
    }
    i(null);
    AppMethodBeat.o(257856);
  }
  
  private void cAi()
  {
    int j = 0;
    AppMethodBeat.i(257862);
    if ((this.sBZ == null) || (this.sCg == null))
    {
      AppMethodBeat.o(257862);
      return;
    }
    int i = this.sBZ.getFirstVisiblePosition();
    int m = this.sBZ.getLastVisiblePosition();
    fC(i, m);
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
        z localz = this.sCg.GK(k);
        if (localz != null)
        {
          this.sCg.apA(localz.field_talker);
          this.szZ.e(localz);
        }
        k += 1;
      }
      i = 0;
    }
    AppMethodBeat.o(257862);
  }
  
  private static int cAn()
  {
    if (sCk > 0) {
      return sCk - 1;
    }
    return 0;
  }
  
  private void dP(View paramView)
  {
    AppMethodBeat.i(5982);
    paramView = paramView.getTag(d.e.biz_image_view_url);
    if ((paramView instanceof String)) {
      this.sCu.add((String)paramView);
    }
    AppMethodBeat.o(5982);
  }
  
  private void fC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5983);
    if ((paramInt1 == 0) && (!this.sCo) && (sCk != paramInt1)) {
      this.sAb.cBd();
    }
    this.sCl.a(paramInt1, paramInt2, this.sBZ, this.szZ);
    AppMethodBeat.o(5983);
  }
  
  private void h(final z paramz, final int paramInt)
  {
    AppMethodBeat.i(257858);
    this.sBZ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5964);
        if ((BizTimeLineUI.j(BizTimeLineUI.this) > 20) || (BizTimeLineUI.k(BizTimeLineUI.this)) || (BizTimeLineUI.l(BizTimeLineUI.this) != 0))
        {
          BizTimeLineUI.a(BizTimeLineUI.this, paramz);
          Log.i("MicroMsg.BizTimeLineUI", "tryToScrollToPosition fail userTouched: %b state: %d tryScrollTimes: %d", new Object[] { Boolean.valueOf(BizTimeLineUI.k(BizTimeLineUI.this)), Integer.valueOf(BizTimeLineUI.l(BizTimeLineUI.this)), Integer.valueOf(BizTimeLineUI.m(BizTimeLineUI.this)) });
          AppMethodBeat.o(5964);
          return;
        }
        BizTimeLineUI.a(BizTimeLineUI.this, paramz, paramInt);
        AppMethodBeat.o(5964);
      }
    }, 10L);
    AppMethodBeat.o(257858);
  }
  
  private void i(z paramz)
  {
    AppMethodBeat.i(5971);
    this.sCg.sAf = false;
    this.sCo = false;
    int i = Math.max(0, this.sBZ.getFirstVisiblePosition() - this.sBZ.getHeaderViewsCount());
    this.sCg.d(paramz);
    this.sCg.d(this.sCg.GK(i));
    cAi();
    Log.i("MicroMsg.BizTimeLineUI", "resetKeep pos %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(5971);
  }
  
  private void i(z paramz, int paramInt)
  {
    AppMethodBeat.i(257860);
    if ((this.sBZ == null) || (isFinishing()))
    {
      AppMethodBeat.o(257860);
      return;
    }
    r.a(this.sBZ, paramInt, sCj, false);
    if (this.sBZ.getFirstVisiblePosition() == paramInt)
    {
      i(paramz);
      Log.i("MicroMsg.BizTimeLineUI", "tryToScrollToPosition success tryScrollTimes: %d", new Object[] { Integer.valueOf(this.sCz) });
      AppMethodBeat.o(257860);
      return;
    }
    h(paramz, paramInt);
    AppMethodBeat.o(257860);
  }
  
  public final void a(com.tencent.mm.plugin.webcanvas.f paramf)
  {
    AppMethodBeat.i(257876);
    if (!this.sCw.contains(this.sCw)) {
      this.sCw.add(paramf);
    }
    AppMethodBeat.o(257876);
  }
  
  public final void a(com.tencent.mm.plugin.webcanvas.h paramh)
  {
    AppMethodBeat.i(257874);
    if (!this.sCv.contains(paramh)) {
      this.sCv.add(paramh);
    }
    AppMethodBeat.o(257874);
  }
  
  public final void b(com.tencent.mm.plugin.webcanvas.h paramh)
  {
    AppMethodBeat.i(257875);
    this.sCv.remove(paramh);
    AppMethodBeat.o(257875);
  }
  
  public final void cAe()
  {
    AppMethodBeat.i(5978);
    if (this.sCg != null) {
      this.sCg.notifyDataSetChanged();
    }
    AppMethodBeat.o(5978);
  }
  
  public final void cAg()
  {
    AppMethodBeat.i(5968);
    if (isFinishing())
    {
      AppMethodBeat.o(5968);
      return;
    }
    int i = af.bjD().cHo();
    if (i > 0)
    {
      this.sCc.setVisibility(0);
      this.sCd.setText(getString(d.i.suQ, new Object[] { Integer.valueOf(i) }));
      z localz = af.bjD().hxy();
      Object localObject;
      if (localz != null)
      {
        this.sCb.setVisibility(0);
        if (localz.hwD())
        {
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(localz.field_talker);
          if ((localObject != null) && (com.tencent.mm.contact.d.rk(((ax)localObject).field_type))) {
            break label378;
          }
          if (localz.hwJ() != null)
          {
            localObject = new c.a();
            ((c.a)localObject).lRP = d.d.default_avatar;
            ((c.a)localObject).lRC = true;
            com.tencent.mm.ay.q.bml().a(localz.hwJ().lqp, this.sCb, ((c.a)localObject).bmL());
          }
          com.tencent.mm.storage.ab.UN(localz.field_msgId);
        }
      }
      for (;;)
      {
        if ((this.sCg != null) && (this.sCg.getCount() == 0)) {
          this.sCg.notifyDataSetChanged();
        }
        AppMethodBeat.o(5968);
        return;
        if (localz.hwE())
        {
          localObject = ag.N(localz);
          String str = ag.O(localz);
          if (!TextUtils.isEmpty(str))
          {
            c.a locala = new c.a();
            locala.lRP = d.d.default_avatar;
            locala.lRC = true;
            locala.kPz = true;
            com.tencent.mm.ay.q.bml().a(str, this.sCb, locala.bmL());
          }
          for (;;)
          {
            i = ag.f(localz);
            this.szZ.l(i, (String)localObject, 0);
            break;
            if (Util.isNullOrNil((String)localObject)) {
              a.b.c(this.sCb, localz.field_talker);
            } else if (com.tencent.mm.model.ab.Qm((String)localObject)) {
              a.b.d(this.sCb, (String)localObject);
            } else {
              a.b.c(this.sCb, (String)localObject);
            }
          }
        }
        if (com.tencent.mm.model.ab.Qm(localz.field_talker))
        {
          a.b.d(this.sCb, localz.field_talker);
          break;
        }
        label378:
        a.b.c(this.sCb, localz.field_talker);
        break;
        this.sCb.setVisibility(8);
      }
    }
    this.sCc.setVisibility(8);
    AppMethodBeat.o(5968);
  }
  
  public final void cAj()
  {
    AppMethodBeat.i(5975);
    long l = System.currentTimeMillis() - this.sCB;
    if ((this.sCD) && (l < 200L))
    {
      Log.d("MicroMsg.BizTimeLineUI", "DoingUpdateView return");
      AppMethodBeat.o(5975);
      return;
    }
    Log.d("MicroMsg.BizTimeLineUI", "try2UpdateActionBarCustomView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.sCD), Long.valueOf(l) });
    this.sCD = true;
    if (l < 100L)
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5951);
          BizTimeLineUI.p(BizTimeLineUI.this);
          if (!BizTimeLineUI.this.isFinishing())
          {
            BizTimeLineUI.this.cAj();
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
    if ((this.sCg == null) || (this.fEs)) {}
    for (;;)
    {
      this.sCB = System.currentTimeMillis();
      this.sCD = false;
      AppMethodBeat.o(5975);
      return;
      if (this.sCg.rbc.size() > 0)
      {
        l = ((z)this.sCg.rbc.get(0)).field_orderFlag;
        if ((this.sCo) || (this.sBZ == null) || (this.sBZ.getFirstVisiblePosition() != 0))
        {
          int j = af.bjB().UC(l);
          int i = j;
          if (j > 0)
          {
            l = af.bjB().hxb();
            i = j;
            if (af.bjB().UK(l << 32) != null) {
              i = j - 1;
            }
          }
          Log.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            setMMTitleVisibility(8);
            this.sCa.setVisibility(0);
            this.sCe.setText(getString(d.i.suU, new Object[] { Integer.valueOf(i) }));
            continue;
          }
        }
        this.sCa.setVisibility(8);
        setMMTitleVisibility(0);
      }
    }
  }
  
  public final void cAk()
  {
    AppMethodBeat.i(5977);
    Log.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
    cAj();
    AppMethodBeat.o(5977);
  }
  
  public final StoryListView cAl()
  {
    return this.sBZ;
  }
  
  public final boolean cAm()
  {
    AppMethodBeat.i(257871);
    if ((this.sAb.getVisibility() == 0) || (this.sCc.getVisibility() == 0))
    {
      AppMethodBeat.o(257871);
      return true;
    }
    AppMethodBeat.o(257871);
    return false;
  }
  
  public final void czX()
  {
    AppMethodBeat.i(5974);
    if ((!isFinishing()) && (this.sBm != null))
    {
      ((View)$(d.e.sqT)).setVisibility(8);
      ((View)$(d.e.sra)).setVisibility(0);
      Object localObject = (TextView)$(d.e.sqZ);
      b.a locala = b.sAG;
      if (b.a.cAd())
      {
        ((TextView)localObject).setText(getString(d.i.suP));
        localObject = o.lrA;
        o.Gh(15L);
        AppMethodBeat.o(5974);
        return;
      }
      ((TextView)localObject).setText(getString(d.i.esR));
    }
    AppMethodBeat.o(5974);
  }
  
  public final void czY()
  {
    AppMethodBeat.i(257864);
    if ((!isFinishing()) && (this.sBm != null))
    {
      ((View)$(d.e.sqT)).setVisibility(0);
      ((View)$(d.e.sra)).setVisibility(8);
    }
    AppMethodBeat.o(257864);
  }
  
  public final void dd(String paramString, int paramInt)
  {
    AppMethodBeat.i(257878);
    Object localObject;
    if (this.sCg != null)
    {
      localObject = this.sCg;
      kotlin.g.b.p.k(paramString, "id");
      Iterator localIterator = ((Iterable)((b)localObject).szW).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (z)localIterator.next();
          if (kotlin.g.b.p.h(((z)localObject).getId(), paramString))
          {
            paramString = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a.n((z)localObject);
            if ((paramInt >= 0) && (((z)localObject).Ven.UaA.size() > paramInt))
            {
              paramString = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
              paramString = (dur)((z)localObject).Ven.UaA.get(paramInt);
              if (paramString != null)
              {
                paramString = paramString.UaX;
                if (paramString != null)
                {
                  paramString = paramString.RTk;
                  com.tencent.mm.plugin.brandservice.ui.timeline.a.a.apC(paramString);
                  paramString = (String)localObject;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramString != null) {
        this.szZ.f(paramString, Math.max(0, paramInt));
      }
      AppMethodBeat.o(257878);
      return;
      paramString = null;
      break;
      paramString = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.apC(((z)localObject).Ven.SwH);
      paramString = (String)localObject;
      continue;
      paramString = null;
    }
  }
  
  public final void deleteCanvasCard(String paramString)
  {
    AppMethodBeat.i(257879);
    if (this.sCg != null)
    {
      b localb = this.sCg;
      kotlin.g.b.p.k(paramString, "id");
      Iterator localIterator = ((Iterable)localb.szW).iterator();
      while (localIterator.hasNext())
      {
        z localz = (z)localIterator.next();
        if (kotlin.g.b.p.h(localz.getId(), paramString))
        {
          localb.c(localz);
          AppMethodBeat.o(257879);
          return;
        }
      }
    }
    AppMethodBeat.o(257879);
  }
  
  public int getLayoutId()
  {
    return d.f.stI;
  }
  
  public final void j(z paramz)
  {
    AppMethodBeat.i(257877);
    this.szZ.f(paramz, 0);
    AppMethodBeat.o(257877);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(257881);
    super.onConfigurationChanged(paramConfiguration);
    Iterator localIterator = this.sCv.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.webcanvas.h)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
    if (this.sAb != null) {
      this.sAb.onConfigurationChanged(paramConfiguration);
    }
    paramConfiguration = this.sCl;
    paramConfiguration.pEk = com.tencent.mm.ci.a.ks(paramConfiguration.context);
    AppMethodBeat.o(257881);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5966);
    com.tencent.mm.storage.ab.ES(true);
    com.tencent.mm.plugin.brandservice.b.c.init();
    super.onCreate(paramBundle);
    this.emptyTipTv = ((TextView)$(d.e.empty_msg_tip_tv));
    this.emptyTipTv.setText(d.i.suD);
    this.sCh = new d(this);
    paramBundle = this.sCh;
    EventCenter.instance.addListener(paramBundle.ozM);
    this.fwM = ((int)(System.currentTimeMillis() / 1000L));
    this.source = getIntent().getIntExtra("biz_enter_source", 1);
    this.sBz = System.currentTimeMillis();
    this.szZ = new f(this.fwM, this.sBz);
    this.sCl = new com.tencent.mm.plugin.brandservice.ui.timeline.a.b(this, this.szZ);
    com.tencent.mm.storage.ab.Ht(this.fwM);
    paramBundle = e.sTi;
    e.Ht(this.fwM);
    setTitleBarDoubleClickListener(new BizTimeLineUI.5(this));
    paramBundle = com.tencent.mm.plugin.bizui.a.a.shG;
    boolean bool1 = com.tencent.mm.plugin.bizui.a.a.cxR();
    boolean bool2 = ((com.tencent.mm.api.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.q.class)).ZN();
    Log.i("MicroMsg.BizTimeLineUI", "open search entrance:%b, isBizTeenModeAllowAll: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2)) {
      addIconOptionMenu(0, d.i.top_item_desc_search, d.h.actionbar_icon_dark_search, new BizTimeLineUI.2(this));
    }
    addIconOptionMenu(1, d.i.suV, d.h.actionbar_menu_list_icon, new MenuItem.OnMenuItemClickListener()new BizTimeLineUI.4
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(5946);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.addFlags(67108864);
        paramAnonymousMenuItem.putExtra("biz_from_scene", 2);
        paramAnonymousMenuItem.putExtra("biz_time_line_line_session_id", BizTimeLineUI.a(BizTimeLineUI.this));
        paramAnonymousMenuItem.putExtra("biz_enter_source", BizTimeLineUI.h(BizTimeLineUI.this));
        com.tencent.mm.by.c.f(BizTimeLineUI.this, ".ui.conversation.NewBizConversationUI", paramAnonymousMenuItem);
        BizTimeLineUI.this.szZ.GM(7);
        BizTimeLineUI.n(BizTimeLineUI.this);
        AppMethodBeat.o(5946);
        return true;
      }
    }, new BizTimeLineUI.4(this));
    setMMTitle(d.i.suY);
    setMMTitleColor(getContext().getResources().getColor(d.b.FG_0));
    setBackBtn(new BizTimeLineUI.6(this), d.h.actionbar_icon_dark_back);
    this.sCa = getLayoutInflater().inflate(d.f.stH, null);
    this.sCe = ((TextView)this.sCa.findViewById(d.e.srs));
    this.sCe.setTextSize(1, 14.0F);
    this.sCf = this.sCa.findViewById(d.e.srr);
    paramBundle = getController().mActionBar.getCustomView();
    final int j;
    final int k;
    Object localObject1;
    Object localObject2;
    List localList;
    if ((paramBundle instanceof LinearLayout))
    {
      ((LinearLayout)paramBundle).addView(this.sCa);
      paramBundle = (LinearLayout.LayoutParams)this.sCa.getLayoutParams();
      paramBundle.width = -1;
      paramBundle.weight = 1.0F;
      paramBundle.gravity = 16;
      this.sCa.setLayoutParams(paramBundle);
      this.sCf.setOnClickListener(new BizTimeLineUI.7(this));
      this.sCa.setVisibility(8);
      this.sBZ = ((StoryListView)$(d.e.sqW));
      paramBundle = this.sBZ;
      this.sBm = getLayoutInflater().inflate(d.f.stJ, null);
      paramBundle.addFooterView(this.sBm);
      paramBundle = this.sBZ;
      if (this.mXN == null)
      {
        this.mXN = getLayoutInflater().inflate(d.f.stK, null);
        this.sAb = ((BizTimeLineHotView)this.mXN.findViewById(d.e.sqv));
      }
      paramBundle.addHeaderView(this.mXN);
      j = sCk;
      k = getIntent().getIntExtra("Main_UnreadCount", 0);
      this.sCo = com.tencent.mm.storage.ab.hxl();
      this.sCp = com.tencent.mm.storage.ab.bQ(k, this.sCo);
      if (!this.sCp) {
        break label1340;
      }
      paramBundle = af.bjB().Uy(com.tencent.mm.storage.ab.VeM);
      com.tencent.mm.plugin.brandservice.ui.b.c.cJ(paramBundle);
      Log.i("MicroMsg.BizTimeLineUI", "initListView keepPos %b, keepData %b, unReadCount %d", new Object[] { Boolean.valueOf(this.sCo), Boolean.valueOf(this.sCp), Integer.valueOf(k) });
      this.sCg = new b(this, paramBundle, this.sCo, this.sCp, this.szZ, this.sAb);
      localObject1 = com.tencent.mm.plugin.brandservice.b.a.svF;
      com.tencent.mm.plugin.brandservice.b.a.a(this.sCg, this.sBZ);
      localObject1 = this.szZ;
      i = cAn();
      localObject2 = this.sCg.rbc;
      ((f)localObject1).sBx = i;
      ((f)localObject1).dataList = ((List)localObject2);
      if (((f)localObject1).dataList.size() > 0)
      {
        localObject2 = g.sBS;
        localObject2 = (z)((f)localObject1).dataList.get(0);
        localList = ((f)localObject1).dataList;
        localObject1 = ((f)localObject1).sBC;
        kotlin.g.b.p.k(localObject2, "info");
        kotlin.g.b.p.k(localObject1, "sessionItemCache");
        ad localad = ad.Vfe;
        if ((!ad.hxt()) || ((g.bcJ().decodeInt("ReSortBizMsgFlag", 0) & 0x1) == 0)) {
          break label1460;
        }
      }
    }
    label1460:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (localList != null)) {
        com.tencent.e.h.ZvG.n((Runnable)new g.c((z)localObject2, localList, (f.c)localObject1), 1000L);
      }
      this.sCc = ((LinearLayout)$(d.e.ssh));
      this.sCd = ((TextView)$(d.e.ssi));
      this.sCb = ((ImageView)$(d.e.ssg));
      cAg();
      this.sCc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(5944);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = "";
          localObject = af.bjD().hxy();
          if (localObject != null) {
            paramAnonymousView = ag.N((z)localObject);
          }
          for (int i = ag.f((z)localObject);; i = 0)
          {
            localObject = BizTimeLineUI.this.szZ;
            com.tencent.mm.plugin.report.service.h.IzE.a(15721, new Object[] { paramAnonymousView, "", Integer.valueOf(12), Integer.valueOf(-1), Integer.valueOf(((f)localObject).fwM), "", "", "", Integer.valueOf(0), "", "", "", "", "", "", "", "", "", Integer.valueOf(i) });
            BizTimeLineUI.this.szZ.l(i, paramAnonymousView, 1);
            localObject = new Intent(BizTimeLineUI.this.getContext(), BizTimeLineNewMsgUI.class);
            ((Intent)localObject).putExtra("biz_time_line_line_session_id", BizTimeLineUI.a(BizTimeLineUI.this));
            ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 1);
            paramAnonymousView = BizTimeLineUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(5944);
            return;
          }
        }
      });
      this.sBZ.setAdapter(this.sCg);
      this.sBZ.setFooterDividersEnabled(false);
      this.sBZ.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(263202);
          paramAnonymousAbsListView = BizTimeLineUI.d(BizTimeLineUI.this).iterator();
          while (paramAnonymousAbsListView.hasNext()) {
            ((com.tencent.mm.plugin.webcanvas.h)paramAnonymousAbsListView.next()).cAD();
          }
          BizTimeLineUI.a(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt2 - 1);
          paramAnonymousAbsListView = com.tencent.mm.pluginsdk.ui.applet.g.Rfj;
          if (com.tencent.mm.pluginsdk.ui.applet.g.aqi(1)) {
            BizTimeLineUI.b(BizTimeLineUI.this, paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt2 - 1);
          }
          if (BizTimeLineUI.bru() != paramAnonymousInt1)
          {
            paramAnonymousAbsListView = ad.Vfe;
            ad.GP(paramAnonymousInt1);
            paramAnonymousAbsListView = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a.GP(paramAnonymousInt1);
            paramAnonymousAbsListView = com.tencent.mm.plugin.brandservice.b.a.svF;
            com.tencent.mm.plugin.brandservice.b.a.GA(paramAnonymousInt1);
          }
          BizTimeLineUI.GN(paramAnonymousInt1);
          paramAnonymousAbsListView = BizTimeLineUI.this.szZ;
          paramAnonymousInt1 = BizTimeLineUI.bru();
          if (paramAnonymousAbsListView.sBE != null)
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousAbsListView.sBE.sBQ != paramAnonymousInt1))
            {
              f.a locala = paramAnonymousAbsListView.sBE;
              locala.sBN += 1;
            }
            paramAnonymousAbsListView.sBE.sBQ = paramAnonymousInt1;
          }
          AppMethodBeat.o(263202);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(263201);
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
            Log.d("MicroMsg.BizTimeLineUI", "summer hardcoder biz startPerformance [%s] [%s]", new Object[] { Integer.valueOf(903), Integer.valueOf(BizTimeLineUI.c(BizTimeLineUI.this)) });
            paramAnonymousAbsListView = BizTimeLineUI.d(BizTimeLineUI.this).iterator();
            while (paramAnonymousAbsListView.hasNext()) {
              paramAnonymousAbsListView.next();
            }
          }
          com.tencent.mm.plugin.brandservice.ui.b.a.cEp();
          com.tencent.mm.ay.q.bml().onScrollStateChanged(paramAnonymousInt);
          if ((paramAnonymousInt == 0) || (paramAnonymousInt == 1))
          {
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.c.QUt;
            if (com.tencent.mm.pluginsdk.model.c.QUr) {
              com.tencent.mm.pluginsdk.model.c.u((Runnable)new c.h(System.currentTimeMillis()));
            }
          }
          for (;;)
          {
            if (paramAnonymousInt == 0)
            {
              BizTimeLineUI.b(BizTimeLineUI.this).fB(BizTimeLineUI.e(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.e(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.e(BizTimeLineUI.this).getLastVisiblePosition());
              MPVideoPreviewMgr.sSn.a("idle", BizTimeLineUI.e(BizTimeLineUI.this), BizTimeLineUI.b(BizTimeLineUI.this));
              paramAnonymousAbsListView = com.tencent.mm.plugin.brandservice.b.a.svF;
              com.tencent.mm.plugin.brandservice.b.a.a(BizTimeLineUI.e(BizTimeLineUI.this), BizTimeLineUI.b(BizTimeLineUI.this));
            }
            AppMethodBeat.o(263201);
            return;
            paramAnonymousAbsListView = com.tencent.mm.pluginsdk.model.c.QUt;
            if (!com.tencent.mm.pluginsdk.model.c.QUr) {
              com.tencent.mm.pluginsdk.model.c.u((Runnable)new c.l(System.currentTimeMillis()));
            }
          }
        }
      });
      this.sBZ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(257144);
          BizTimeLineUI.f(BizTimeLineUI.this);
          AppMethodBeat.o(257144);
          return false;
        }
      });
      this.sBZ.setEmptyView(this.emptyTipTv);
      if ((this.sCo) && (j != 0)) {
        cAh();
      }
      this.sBZ.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5961);
          if (BizTimeLineUI.g(BizTimeLineUI.this)) {
            if (j != 0) {
              BizTimeLineUI.this.cAj();
            }
          }
          for (;;)
          {
            if (!Util.isNullOrNil(paramBundle))
            {
              long l = ((z)paramBundle.get(0)).field_orderFlag;
              f localf = BizTimeLineUI.this.szZ;
              int i = BizTimeLineUI.h(BizTimeLineUI.this);
              int j = BizTimeLineUI.this.getIntent().getIntExtra("Main_IndexInSessionList", 0);
              com.tencent.mm.plugin.brandservice.b.am(new f.3(localf, l, BizTimeLineUI.i(BizTimeLineUI.this).sJw, i, j));
            }
            com.tencent.e.h.ZvG.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(264314);
                MPVideoPreviewMgr.sSn.a("init", BizTimeLineUI.e(BizTimeLineUI.this), BizTimeLineUI.b(BizTimeLineUI.this));
                com.tencent.mm.plugin.brandservice.b.a locala = com.tencent.mm.plugin.brandservice.b.a.svF;
                com.tencent.mm.plugin.brandservice.b.a.a(BizTimeLineUI.e(BizTimeLineUI.this), BizTimeLineUI.b(BizTimeLineUI.this));
                AppMethodBeat.o(264314);
              }
            }, 100L);
            AppMethodBeat.o(5961);
            return;
            BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.b(BizTimeLineUI.this).GK(0));
            continue;
            BizTimeLineUI.a(BizTimeLineUI.this, BizTimeLineUI.e(BizTimeLineUI.this).getFirstVisiblePosition(), BizTimeLineUI.e(BizTimeLineUI.this).getLastVisiblePosition());
          }
        }
      }, 10L);
      this.sBZ.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(5962);
          BizTimeLineUI.b(BizTimeLineUI.this).fB(BizTimeLineUI.e(BizTimeLineUI.this).getFirstVisiblePosition() - BizTimeLineUI.e(BizTimeLineUI.this).getHeaderViewsCount(), BizTimeLineUI.e(BizTimeLineUI.this).getLastVisiblePosition());
          BizTimeLineUI.e(BizTimeLineUI.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(5962);
        }
      });
      af.bjD().a(this.sCx, Looper.getMainLooper());
      new c();
      Log.d("MicroMsg.BizTimeLineMigrateImp", "migrateOldList");
      i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vva, Integer.valueOf(0))).intValue();
      if ((i & 0x4) == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwA("officialaccounts");
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vva, Integer.valueOf(i | 0x4));
      }
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(5963);
          Looper.myQueue().removeIdleHandler(this);
          z localz;
          if (BizTimeLineUI.b(BizTimeLineUI.this) != null)
          {
            localz = BizTimeLineUI.b(BizTimeLineUI.this).czU();
            if (localz == null) {
              break label61;
            }
            af.bjB().UG(localz.field_orderFlag);
          }
          for (;;)
          {
            AppMethodBeat.o(5963);
            return false;
            localz = null;
            break;
            label61:
            af.bjB().hwY();
          }
        }
      });
      com.tencent.mm.pluginsdk.h.s(this);
      EventCenter.instance.addListener(this.sCF);
      this.sCy.alive();
      if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) {
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gx(90);
      }
      paramBundle = af.bjB();
      if (paramBundle.Ves)
      {
        paramBundle.Ves = false;
        com.tencent.e.h.ZvG.a(new aa.4(paramBundle), 1000L, "BizTimeLineInfoStorageThread");
      }
      com.tencent.mm.plugin.brandservice.ui.b.a.cEn();
      com.tencent.mm.pluginsdk.ui.applet.g.hkg();
      paramBundle = y.VdH;
      y.a(y.b.VdM);
      com.tencent.mm.api.b.YM();
      com.tencent.mm.plugin.brandservice.b.c.cyV();
      com.tencent.mm.plugin.webcanvas.m.PuL.gPw();
      paramBundle = com.tencent.mm.plugin.webcanvas.l.PuB;
      com.tencent.mm.plugin.webcanvas.l.Tt(65L);
      AppMethodBeat.o(5966);
      return;
      if (!(paramBundle instanceof RelativeLayout)) {
        break;
      }
      ((RelativeLayout)paramBundle).addView(this.sCa);
      paramBundle = (RelativeLayout.LayoutParams)this.sCa.getLayoutParams();
      paramBundle.width = -1;
      paramBundle.addRule(15);
      this.sCa.setLayoutParams(paramBundle);
      break;
      label1340:
      long l;
      if (com.tencent.mm.storage.ab.hxn())
      {
        paramBundle = af.bjB();
        i = Math.min(com.tencent.mm.model.p.bcI(), 10);
        l = paramBundle.hxb();
        paramBundle = paramBundle.lvy;
        localObject1 = "orderFlag DESC limit ".concat(String.valueOf(i));
      }
      for (paramBundle = com.tencent.mm.storage.aa.r(paramBundle.query("BizTimeLineInfo", null, "orderFlag>=?", new String[] { String.valueOf(l << 32) }, null, null, (String)localObject1));; paramBundle = af.bjB().aso(10))
      {
        localObject1 = new LinkedList();
        ((List)localObject1).addAll(paramBundle);
        com.tencent.mm.plugin.brandservice.ui.b.c.cM((List)localObject1);
        com.tencent.mm.plugin.brandservice.ui.b.c.a((List)localObject1, null);
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5979);
    super.onDestroy();
    Log.i("MicroMsg.BizTimeLineUI", "BizTimeLineUI onDestroy %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.sAb != null)
    {
      localObject1 = this.sAb;
      localObject3 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      kotlin.g.b.p.j(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject3).bbR().remove((MStorageEx.IOnStorageChange)localObject1);
      EventCenter.instance.removeListener(((BizTimeLineHotView)localObject1).sJB);
      localObject3 = ((BizTimeLineHotView)localObject1).sIV;
      Object localObject4 = new d.a();
      ddy localddy = new ddy();
      ((d.a)localObject4).lBU = localddy;
      ((d.a)localObject4).lBV = new ddz();
      ((d.a)localObject4).uri = "/cgi-bin/micromsg-bin/often_read_bar_report";
      ((d.a)localObject4).funcId = 2550;
      localObject4 = ((d.a)localObject4).bgN();
      localddy.RSi = com.tencent.mm.storage.ab.getSessionId();
      localddy.TLH = ((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h)localObject3).sKc;
      LinkedList localLinkedList = new LinkedList();
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h)localObject3).sKb.size() > 0)
      {
        Iterator localIterator = ((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h)localObject3).sKb.entrySet().iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add((dea)((Map.Entry)localIterator.next()).getValue());
        }
      }
      localddy.TLG = localLinkedList;
      localddy.source = 0;
      com.tencent.mm.an.aa.a((com.tencent.mm.an.d)localObject4, new h.1((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h)localObject3));
      com.tencent.mm.kernel.h.aGY().b(2768, (com.tencent.mm.an.i)localObject1);
      localObject3 = ((BizTimeLineHotView)localObject1).sJs;
      if (localObject3 != null) {
        ((BizTimeLineHotListView)localObject3).setAdapter(null);
      }
      localObject3 = ((BizTimeLineHotView)localObject1).sJs;
      if (localObject3 != null) {
        ((BizTimeLineHotListView)localObject3).onDestroy();
      }
      localObject1 = ((BizTimeLineHotView)localObject1).sJA;
      if (localObject1 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a)localObject1).cBb();
        if (localObject3 != null) {
          ((BizTimeLineHotListView)localObject3).setAdapter(null);
        }
        localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a)localObject1).cBb();
        if (localObject1 != null) {
          ((BizTimeLineHotListView)localObject1).onDestroy();
        }
      }
      localObject1 = com.tencent.mm.pluginsdk.model.b.QTJ;
      if (com.tencent.mm.pluginsdk.model.b.hgd())
      {
        localObject1 = com.tencent.mm.plugin.brandservice.b.a.svF;
        com.tencent.mm.plugin.brandservice.b.a.cyS();
        localObject1 = BizTimeLineHotView.cBo();
        if (localObject1 != null) {
          ((IListener)localObject1).dead();
        }
        BizTimeLineHotView.cBp();
      }
    }
    Object localObject1 = this.sCh;
    EventCenter.instance.removeListener(((d)localObject1).ozM);
    com.tencent.mm.storage.ab.ES(false);
    com.tencent.mm.storage.ab.VeL = System.currentTimeMillis();
    if ((this.sCg != null) && (this.sBZ != null))
    {
      localObject1 = this.sCg.czT();
      if (localObject1 == null) {
        break label862;
      }
      com.tencent.mm.storage.ab.VeM = ((z)localObject1).field_orderFlag;
    }
    for (;;)
    {
      localObject1 = this.sCg.GK(cAn());
      if (localObject1 != null)
      {
        sCi = ((z)localObject1).getId();
        localObject1 = this.sCg;
        af.bjB().a(((b)localObject1).soO);
        ((b)localObject1).sAc.sKE.clear();
        localObject3 = com.tencent.mm.model.p.lrH;
        localObject1 = ((b)localObject1).szW;
        kotlin.g.b.p.k(localObject1, "list");
        kotlin.g.b.p.k(localObject1, "<set-?>");
        com.tencent.mm.model.p.aj((List)localObject1);
        af.bjD().a(this.sCx);
        if (this.sBz != 0L)
        {
          l = System.currentTimeMillis();
          this.rgX += l - this.sCm;
          com.tencent.mm.plugin.report.service.h.IzE.a(13932, new Object[] { Integer.valueOf((int)(l - this.sBz) / 1000), Integer.valueOf(1), Integer.valueOf(this.fwM), Integer.valueOf((int)(this.rgX / 1000L)), Integer.valueOf(this.source) });
        }
        EventCenter.instance.removeListener(this.sCF);
        this.sCy.dead();
        this.szZ.sBy = cAn();
        localObject1 = this.szZ;
        com.tencent.e.h.ZvG.d(new f.2((f)localObject1), "BizTimeLineExpose");
        if (((f)localObject1).sBE != null) {
          com.tencent.mm.plugin.report.service.h.IzE.a(21136, new Object[] { Integer.valueOf(((f)localObject1).sBE.sBN), Integer.valueOf(((f)localObject1).sBE.sBO), Integer.valueOf(((f)localObject1).sBE.msgType), Integer.valueOf(((f)localObject1).sBE.fwM), ((f)localObject1).sBE.fOX, Integer.valueOf(((f)localObject1).sBE.sBP) });
        }
        com.tencent.mm.plugin.brandservice.ui.b.b.clean();
        aq.clear();
        com.tencent.mm.storage.ab.Ht(0);
      }
      try
      {
        if ((getContentView() instanceof ViewGroup)) {
          ((ViewGroup)getContentView()).removeAllViews();
        }
        localObject1 = com.tencent.mm.pluginsdk.model.c.QUt;
        com.tencent.mm.pluginsdk.model.c.hgH();
        com.tencent.mm.plugin.brandservice.b.c.release();
        localObject1 = this.sCw.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            ((com.tencent.mm.plugin.webcanvas.f)((Iterator)localObject1).next()).onDestroy();
            continue;
            label862:
            com.tencent.mm.storage.ab.VeM = af.bjB().hwv() << 32;
            break;
            Log.w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", new Object[] { Integer.valueOf(cAn()) });
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.w("MicroMsg.BizTimeLineUI", "onDestroy contentView removeAllViews %s", new Object[] { localThrowable });
        }
        this.sCv.clear();
        this.sCw.clear();
        localObject2 = MPVideoPreviewMgr.sSn;
        if (!MPVideoPreviewMgr.sRX) {
          break label1140;
        }
      }
    }
    Object localObject2 = MPVideoPreviewMgr.sSe;
    Object localObject3 = MPVideoPreviewMgr.sSa;
    if (localObject3 != null)
    {
      localObject3 = (AppBrandVideoView)((WeakReference)localObject3).get();
      if (localObject3 == null) {}
    }
    for (long l = ((AppBrandVideoView)localObject3).getCurrPosMs();; l = 0L)
    {
      ((MPVideoPreviewMgr.a)localObject2).sSv = l;
      MPVideoPreviewMgr.sSe.rE(4);
      localObject2 = MPVideoPreviewMgr.sSe;
      ((MPVideoPreviewMgr.a)localObject2).sSo = null;
      ((MPVideoPreviewMgr.a)localObject2).d(null);
      ((MPVideoPreviewMgr.a)localObject2).aqA("IDLE");
      ((MPVideoPreviewMgr.a)localObject2).afI = 0;
      ((MPVideoPreviewMgr.a)localObject2).sSs.clear();
      ((MPVideoPreviewMgr.a)localObject2).setVideoDuration(0);
      ((MPVideoPreviewMgr.a)localObject2).sSv = 0L;
      ((MPVideoPreviewMgr.a)localObject2).sSw = 0L;
      ((MPVideoPreviewMgr.a)localObject2).sSx = 0L;
      ((MPVideoPreviewMgr.a)localObject2).sSy = 0L;
      ((MPVideoPreviewMgr.a)localObject2).sSz = 0L;
      ((MPVideoPreviewMgr.a)localObject2).sSr = "";
      localObject2 = MPVideoPreviewMgr.sSa;
      if (localObject2 != null)
      {
        localObject2 = (AppBrandVideoView)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          ((AppBrandVideoView)localObject2).onUIDestroy();
        }
      }
      MPVideoPreviewMgr.sSg = "";
      MPVideoPreviewMgr.sSi = null;
      MPVideoPreviewMgr.sRY = null;
      MPVideoPreviewMgr.sRZ = null;
      MPVideoPreviewMgr.sSa = null;
      MPVideoPreviewMgr.sSb = null;
      MPVideoPreviewMgr.sSc = null;
      MPVideoPreviewMgr.sSk.clear();
      MPVideoPreviewMgr.stopTimer();
      MPVideoPreviewMgr.sSd = null;
      MPVideoPreviewMgr.sSl.clear();
      label1140:
      localObject2 = com.tencent.mm.plugin.brandservice.b.a.svF;
      com.tencent.mm.plugin.brandservice.b.a.onDestroy();
      AppMethodBeat.o(5979);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5981);
    super.onPause();
    if (this.sCg != null)
    {
      localObject1 = this.sCg;
      ((b)localObject1).fEs = true;
      ((b)localObject1).sAc.sKI = true;
    }
    for (Object localObject1 = this.sCg.czU();; localObject1 = null)
    {
      int i;
      if (localObject1 != null)
      {
        af.bjB().UG(((z)localObject1).field_orderFlag);
        if (this.sBZ == null) {
          break label227;
        }
        localObject1 = this.sBZ.getChildAt(0);
        if (localObject1 == null) {
          break label222;
        }
        i = ((View)localObject1).getTop();
      }
      label91:
      label222:
      label227:
      for (sCj = i;; sCj = 0)
      {
        this.fEs = true;
        long l = System.currentTimeMillis();
        this.rgX += l - this.sCm;
        this.sCm = l;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBizEnable, this.iWt);
        this.iWt = 0;
        com.tencent.mm.pluginsdk.ui.span.l.b(this.sCG);
        localObject1 = com.tencent.mm.pluginsdk.ui.applet.g.Rfj;
        if (com.tencent.mm.pluginsdk.ui.applet.g.aqi(1))
        {
          localObject1 = com.tencent.mm.pluginsdk.model.c.QUt;
          com.tencent.mm.pluginsdk.model.c.hgI();
        }
        ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), null);
        localObject1 = this.sCw.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((com.tencent.mm.plugin.webcanvas.f)((Iterator)localObject1).next()).onPause();
        }
        af.bjB().hwY();
        break;
        i = 0;
        break label91;
      }
      localObject1 = MPVideoPreviewMgr.sSn;
      MPVideoPreviewMgr.aqu("ONPAUSE");
      localObject1 = this.sAb;
      Object localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
      if (com.tencent.mm.pluginsdk.model.b.hgd())
      {
        localObject2 = com.tencent.mm.plugin.brandservice.b.a.svF;
        com.tencent.mm.plugin.brandservice.b.a.cyS();
      }
      if (((BizTimeLineHotView)localObject1).sJA != null) {
        com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a.onPause();
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
    if (this.sCn)
    {
      this.sCn = false;
      this.szZ.GM(8);
    }
    Object localObject1;
    Object localObject3;
    int i;
    if (this.sCg != null)
    {
      localObject1 = this.sCg;
      ((b)localObject1).fEs = false;
      localObject3 = ((b)localObject1).sAc;
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject3).sKI)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject3).sKI = false;
        if (((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject3).sKB <= 0) {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject3).cBB();
        }
      }
      localObject3 = b.sAG;
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
      if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.cAX() != null)
      {
        localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
        localObject3 = (CharSequence)com.tencent.mm.plugin.brandservice.ui.timeline.a.a.cAY();
        if ((localObject3 != null) && (!kotlin.n.n.ba((CharSequence)localObject3))) {
          break label243;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        label140:
        if (this.fEs)
        {
          this.fEs = false;
          cAj();
          localObject1 = com.tencent.mm.plugin.brandservice.b.a.svF;
          com.tencent.mm.plugin.brandservice.b.a.a(this.sBZ, this.sCg);
        }
        this.sCm = System.currentTimeMillis();
        com.tencent.mm.plugin.brandservice.b.an(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5956);
            if ((BizTimeLineUI.this.isFinishing()) || (BizTimeLineUI.e(BizTimeLineUI.this) == null) || (BizTimeLineUI.e(BizTimeLineUI.this).getFirstVisiblePosition() != 0) || (BizTimeLineUI.i(BizTimeLineUI.this) == null))
            {
              AppMethodBeat.o(5956);
              return;
            }
            BizTimeLineUI.i(BizTimeLineUI.this).cBd();
            AppMethodBeat.o(5956);
          }
        });
        com.tencent.mm.pluginsdk.ui.span.l.a(this.sCG);
      }
      try
      {
        ScreenShotUtil.setScreenShotCallback(MMApplicationContext.getContext(), this);
        localObject1 = this.sCw.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            ((com.tencent.mm.plugin.webcanvas.f)((Iterator)localObject1).next()).onResume();
            continue;
            label243:
            i = 0;
            break;
            localObject3 = com.tencent.mm.model.p.lrH;
            localObject3 = com.tencent.mm.model.p.bcC();
            p.a locala = com.tencent.mm.model.p.lrH;
            if (!((Boolean)((kotlin.f)localObject3).getValue()).booleanValue())
            {
              Log.i("MicroMsg.BizTimeLineAdapter", "getRecFeedsOnClickBack not open");
              break label140;
            }
            localObject3 = new WeakReference(localObject1);
            localObject1 = new WeakReference(((b)localObject1).sAm);
            kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (kotlin.g.a.m)new b.a.d((WeakReference)localObject3, (WeakReference)localObject1, null), 2);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("MicroMsg.BizTimeLineUI", "setScreenShotCallback fail e:%s", new Object[] { localException.getMessage() });
        }
        Object localObject2 = MPVideoPreviewMgr.sSn;
        MPVideoPreviewMgr.aqu("ONRESUME");
        localObject2 = this.sAb;
        localObject3 = com.tencent.mm.pluginsdk.model.b.QTJ;
        if (com.tencent.mm.pluginsdk.model.b.hgd())
        {
          localObject3 = com.tencent.mm.plugin.brandservice.b.a.svF;
          com.tencent.mm.plugin.brandservice.b.a.b((com.tencent.mm.plugin.brandservice.ui.timeline.offenread.k)localObject2, ((BizTimeLineHotView)localObject2).sJw);
        }
        localObject2 = ((BizTimeLineHotView)localObject2).sJA;
        if (localObject2 != null)
        {
          kotlin.g.b.p.k(localObject2, "liveBar");
          localObject3 = com.tencent.mm.pluginsdk.model.b.QTJ;
          long l = kotlin.k.i.ov(com.tencent.mm.pluginsdk.model.b.bcJ().decodeInt("bar_list_refresh_interval", 0), 10) * 1000 / 2L;
          Log.d("MicroMsg.BizFinderLiveBar", "startCheckLiveBar interval=".concat(String.valueOf(l)));
          com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a.a(new MTimerHandler("CheckLiveBar", (MTimerHandler.CallBack)new a.a.b(new WeakReference(localObject2)), true));
          localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a.cBh();
          if (localObject2 != null) {
            ((MTimerHandler)localObject2).startTimer(l, l);
          }
        }
        localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
        com.tencent.mm.pluginsdk.model.b.onResume();
        AppMethodBeat.o(5980);
      }
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(257880);
    paramString = this.sCv.iterator();
    while (paramString.hasNext()) {
      ((com.tencent.mm.plugin.webcanvas.h)paramString.next()).cAE();
    }
    AppMethodBeat.o(257880);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI
 * JD-Core Version:    0.7.0.1
 */