package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.au;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.w;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BizTimeLineHotView
  extends LinearLayout
  implements f, n.b
{
  public e jZa;
  WeakReference<Activity> jZe;
  private BizTimeLineHotListView jZf;
  private boolean jZg;
  private List<b> jZh;
  private c jZi;
  private int jZj;
  public com.tencent.mm.sdk.b.c jZk;
  private boolean jZl;
  private MessageQueue.IdleHandler jZm;
  private int jdO;
  private TextView jhF;
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(14314);
    this.jdO = 0;
    this.jZg = false;
    this.jZh = new ArrayList();
    this.jZa = new e();
    this.jZj = 0;
    this.jZk = new BizTimeLineHotView.2(this);
    this.jZl = true;
    this.jZm = new BizTimeLineHotView.7(this);
    init(paramContext);
    AppMethodBeat.o(14314);
  }
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(14315);
    this.jdO = 0;
    this.jZg = false;
    this.jZh = new ArrayList();
    this.jZa = new e();
    this.jZj = 0;
    this.jZk = new BizTimeLineHotView.2(this);
    this.jZl = true;
    this.jZm = new BizTimeLineHotView.7(this);
    init(paramContext);
    AppMethodBeat.o(14315);
  }
  
  private void GN(String paramString)
  {
    AppMethodBeat.i(14317);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new BizTimeLineHotView.1(this, paramString), 0L);
    AppMethodBeat.o(14317);
  }
  
  private void a(ckd paramckd)
  {
    AppMethodBeat.i(14325);
    if (paramckd != null)
    {
      com.tencent.mm.plugin.brandservice.ui.b.a.ic(paramckd.xUj * 1000);
      com.tencent.mm.plugin.brandservice.ui.b.a.id(paramckd.xUh);
    }
    if ((paramckd == null) || (bo.es(paramckd.xUg)))
    {
      if (bo.es(this.jZh)) {
        setVisibility(8);
      }
      ab.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
      AppMethodBeat.o(14325);
      return;
    }
    ab.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", new Object[] { Integer.valueOf(paramckd.xUg.size()), Integer.valueOf(paramckd.xUi), Integer.valueOf(paramckd.xUh) });
    if (com.tencent.mm.plugin.brandservice.ui.b.a.sM(4))
    {
      setVisibility(8);
      AppMethodBeat.o(14325);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new BizTimeLineHotView.4(this, paramckd), 0L);
    AppMethodBeat.o(14325);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(14327);
    long l = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arx(paramb.wqR);
    Object localObject = com.tencent.mm.aj.z.afo().ob(l);
    if (localObject == null)
    {
      AppMethodBeat.o(14327);
      return false;
    }
    paramb.jzc = ((q)localObject).field_createTime;
    localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arH(paramb.wqR);
    boolean bool = paramb.jZt;
    paramb.jZt = false;
    if ((localObject != null) && (((au)localObject).field_unReadCount > 0) && (System.currentTimeMillis() - paramb.jzc < com.tencent.mm.plugin.brandservice.ui.b.a.aZU()))
    {
      int i = com.tencent.mm.aj.z.afp().ok(l);
      if (((au)localObject).field_unReadCount > i) {
        paramb.jZt = true;
      }
    }
    if (bool != paramb.jZt)
    {
      AppMethodBeat.o(14327);
      return true;
    }
    AppMethodBeat.o(14327);
    return false;
  }
  
  private void getLocalOftenReadData()
  {
    AppMethodBeat.i(14323);
    if (!bo.es(this.jZh))
    {
      AppMethodBeat.o(14323);
      return;
    }
    a(d.aXb());
    AppMethodBeat.o(14323);
  }
  
  private void getOftenRead()
  {
    AppMethodBeat.i(14324);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new BizTimeLineHotView.3(this), 0L);
    AppMethodBeat.o(14324);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(14320);
    com.tencent.mm.kernel.g.Rc().a(2768, this);
    this.jZe = new WeakReference((Activity)paramContext);
    a.init(paramContext);
    this.jdO = getItemPadding();
    View localView = w.hM(paramContext).inflate(2130968871, this);
    this.jZf = ((BizTimeLineHotListView)localView.findViewById(2131821867));
    this.jhF = ((TextView)localView.findViewById(2131821865));
    this.jZi = new c(this.jdO);
    this.jZf.b(this.jZi);
    this.jZf.a(paramContext, this.jZh, this.jZa);
    getLocalOftenReadData();
    getOftenRead();
    ((j)com.tencent.mm.kernel.g.E(j.class)).YF().a(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.jZk);
    AppMethodBeat.o(14320);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(14318);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.e("MicroMsg.BizTimeLineHotList", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(14318);
      return;
    }
    GN((String)paramObject);
    AppMethodBeat.o(14318);
  }
  
  public final void aWZ()
  {
    AppMethodBeat.i(14328);
    if ((getVisibility() != 0) || (bo.es(this.jZh)))
    {
      AppMethodBeat.o(14328);
      return;
    }
    this.jZf.aWZ();
    AppMethodBeat.o(14328);
  }
  
  public final void aXa()
  {
    AppMethodBeat.i(14326);
    if (bo.es(this.jZh))
    {
      AppMethodBeat.o(14326);
      return;
    }
    Iterator localIterator = this.jZh.iterator();
    while (localIterator.hasNext()) {
      a((b)localIterator.next());
    }
    AppMethodBeat.o(14326);
  }
  
  public final void e(q paramq)
  {
    AppMethodBeat.i(14316);
    if (paramq != null)
    {
      q localq = com.tencent.mm.aj.z.afo().ob(paramq.field_talkerId);
      if ((localq != null) && (localq.field_msgId == paramq.field_msgId))
      {
        ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arJ(paramq.field_talker);
        GN(paramq.field_talker);
      }
    }
    AppMethodBeat.o(14316);
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(14319);
    int i = a.jdMethod_do(getContext());
    AppMethodBeat.o(14319);
    return i;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(14321);
    super.onConfigurationChanged(paramConfiguration);
    if (this.jZj != paramConfiguration.orientation)
    {
      if (this.jZi != null)
      {
        this.jdO = getItemPadding();
        this.jZi.padding = this.jdO;
      }
      this.jZj = paramConfiguration.orientation;
      Looper.myQueue().addIdleHandler(this.jZm);
    }
    AppMethodBeat.o(14321);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(14329);
    ab.i("MicroMsg.BizTimeLineHotList", "onSceneEnd, type %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(14329);
      return;
    }
    if ((paramm instanceof g))
    {
      paramString = (ckd)((g)paramm).rr.fsW.fta;
      if ((this.jZe.get() != null) && (((Activity)this.jZe.get()).isFinishing()))
      {
        AppMethodBeat.o(14329);
        return;
      }
      if (com.tencent.mm.plugin.brandservice.ui.b.c.b(paramString, d.aXb()))
      {
        ab.d("MicroMsg.BizTimeLineHotList", "onSceneEnd nothing change");
        AppMethodBeat.o(14329);
        return;
      }
      d.jZu = paramString;
    }
    try
    {
      paramm = Base64.encodeToString(paramString.toByteArray(), 0);
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKf, paramm);
      a(paramString);
      AppMethodBeat.o(14329);
      return;
    }
    catch (IOException paramm)
    {
      for (;;)
      {
        ab.e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", new Object[] { paramm.getMessage() });
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKf, "");
      }
    }
  }
  
  public void setTitlePaddingLeft(int paramInt)
  {
    AppMethodBeat.i(14322);
    if (this.jhF != null)
    {
      TextView localTextView = this.jhF;
      localTextView.setPadding(paramInt, localTextView.getPaddingTop(), this.jhF.getPaddingRight(), this.jhF.getPaddingBottom());
    }
    AppMethodBeat.o(14322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView
 * JD-Core Version:    0.7.0.1
 */