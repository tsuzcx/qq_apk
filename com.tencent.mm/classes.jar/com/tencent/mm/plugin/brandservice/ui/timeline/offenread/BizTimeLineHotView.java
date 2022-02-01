package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.al.a;
import com.tencent.mm.g.c.az;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.z;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BizTimeLineHotView
  extends LinearLayout
  implements com.tencent.mm.ak.g, i, n.b
{
  private int mvQ;
  private TextView myG;
  public f nDU;
  WeakReference<Activity> nEf;
  public BizTimeLineHotListView nEg;
  private TextView nEh;
  private boolean nEi;
  private List<b> nEj;
  private c nEk;
  private int nEl;
  public com.tencent.mm.sdk.b.c nEm;
  private float nEn;
  private boolean nEo;
  private MessageQueue.IdleHandler nEp;
  private float paddingLeft;
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6105);
    this.mvQ = 0;
    this.nEi = false;
    this.nEj = new ArrayList();
    this.nDU = new f();
    this.nEl = 0;
    this.nEm = new com.tencent.mm.sdk.b.c() {};
    this.paddingLeft = -1.0F;
    this.nEn = -1.0F;
    this.nEo = true;
    this.nEp = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(6103);
        Looper.myQueue().removeIdleHandler(BizTimeLineHotView.i(BizTimeLineHotView.this));
        if ((BizTimeLineHotView.this.nEf.get() == null) || (((Activity)BizTimeLineHotView.this.nEf.get()).isFinishing()))
        {
          AppMethodBeat.o(6103);
          return false;
        }
        BizTimeLineHotView.h(BizTimeLineHotView.this).cd(BizTimeLineHotView.a(BizTimeLineHotView.this));
        AppMethodBeat.o(6103);
        return false;
      }
    };
    init(paramContext);
    AppMethodBeat.o(6105);
  }
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6106);
    this.mvQ = 0;
    this.nEi = false;
    this.nEj = new ArrayList();
    this.nDU = new f();
    this.nEl = 0;
    this.nEm = new com.tencent.mm.sdk.b.c() {};
    this.paddingLeft = -1.0F;
    this.nEn = -1.0F;
    this.nEo = true;
    this.nEp = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(6103);
        Looper.myQueue().removeIdleHandler(BizTimeLineHotView.i(BizTimeLineHotView.this));
        if ((BizTimeLineHotView.this.nEf.get() == null) || (((Activity)BizTimeLineHotView.this.nEf.get()).isFinishing()))
        {
          AppMethodBeat.o(6103);
          return false;
        }
        BizTimeLineHotView.h(BizTimeLineHotView.this).cd(BizTimeLineHotView.a(BizTimeLineHotView.this));
        AppMethodBeat.o(6103);
        return false;
      }
    };
    init(paramContext);
    AppMethodBeat.o(6106);
  }
  
  private void Tz(final String paramString)
  {
    AppMethodBeat.i(6108);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6097);
        if (BizTimeLineHotView.a(BizTimeLineHotView.this) == null)
        {
          AppMethodBeat.o(6097);
          return;
        }
        if ((paramString == null) || (com.tencent.mm.model.w.xg(paramString)))
        {
          AppMethodBeat.o(6097);
          return;
        }
        Iterator localIterator = BizTimeLineHotView.a(BizTimeLineHotView.this).iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (paramString.equals(localb.DSy)) {
            if (BizTimeLineHotView.b(localb))
            {
              BizTimeLineHotView.a(BizTimeLineHotView.this, localb);
              AppMethodBeat.o(6097);
              return;
            }
          }
        }
        AppMethodBeat.o(6097);
      }
    }, 0L);
    AppMethodBeat.o(6108);
  }
  
  private void a(final dhi paramdhi)
  {
    AppMethodBeat.i(6116);
    if (paramdhi != null)
    {
      com.tencent.mm.plugin.brandservice.ui.b.a.rw(paramdhi.FQE * 1000);
      com.tencent.mm.plugin.brandservice.ui.b.a.rx(paramdhi.FQC);
      if (paramdhi.FQB != null) {}
      for (int i = paramdhi.FQB.size();; i = 0)
      {
        ac.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramdhi.FQD), Integer.valueOf(paramdhi.FQC) });
        if (!com.tencent.mm.plugin.brandservice.ui.b.a.zv(4)) {
          break;
        }
        setVisibility(8);
        AppMethodBeat.o(6116);
        return;
      }
    }
    AppMethodBeat.o(6116);
    return;
    if (com.tencent.mm.plugin.biz.b.a.bIn())
    {
      paramdhi.FQB.clear();
      this.nEj.clear();
    }
    if ((bs.gY(paramdhi.FQB)) && (bs.gY(this.nEj)) && (!bKo()))
    {
      setVisibility(8);
      ac.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
      AppMethodBeat.o(6116);
      return;
    }
    h.JZN.f(new Runnable()
    {
      public final void run()
      {
        boolean bool = false;
        AppMethodBeat.i(6101);
        if (!bs.gY(paramdhi.FQB))
        {
          BizTimeLineHotView.a(BizTimeLineHotView.this, new ArrayList());
          Object localObject = paramdhi.FQB.iterator();
          int i = 0;
          while (((Iterator)localObject).hasNext())
          {
            dhk localdhk = (dhk)((Iterator)localObject).next();
            int j = i + 1;
            if (j > 12) {
              break;
            }
            b localb = new b();
            i = j;
            if (com.tencent.mm.model.w.wG(localdhk.DSy))
            {
              localb.DSy = localdhk.DSy;
              BizTimeLineHotView.a(BizTimeLineHotView.this).add(localb);
              i = j;
            }
          }
          BizTimeLineHotView.this.bKp();
          localObject = BizTimeLineHotView.this;
          if (paramdhi.FQD == 1) {
            bool = true;
          }
          BizTimeLineHotView.a((BizTimeLineHotView)localObject, bool);
        }
        BizTimeLineHotView.b(BizTimeLineHotView.this);
        AppMethodBeat.o(6101);
      }
    }, "MicroMsg.BizTimeLineHotList");
    AppMethodBeat.o(6116);
  }
  
  public static boolean b(b paramb)
  {
    AppMethodBeat.i(6118);
    long l = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNv(paramb.DSy);
    Object localObject = af.aDc().AA(l);
    if (localObject == null)
    {
      AppMethodBeat.o(6118);
      return false;
    }
    paramb.mSB = ((t)localObject).field_createTime;
    localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNI(paramb.DSy);
    boolean bool = paramb.nEw;
    paramb.nEw = false;
    if ((localObject != null) && (((az)localObject).field_unReadCount > 0) && (System.currentTimeMillis() - paramb.mSB < com.tencent.mm.plugin.brandservice.ui.b.a.bNF()))
    {
      int i = af.aDd().AL(l);
      if (((az)localObject).field_unReadCount > i) {
        paramb.nEw = true;
      }
    }
    if (bool != paramb.nEw)
    {
      AppMethodBeat.o(6118);
      return true;
    }
    AppMethodBeat.o(6118);
    return false;
  }
  
  private static boolean bKo()
  {
    AppMethodBeat.i(198737);
    if ((com.tencent.mm.plugin.brandservice.b.c.bJd()) && (com.tencent.mm.plugin.brandservice.b.c.bJf() != null))
    {
      AppMethodBeat.o(198737);
      return true;
    }
    AppMethodBeat.o(198737);
    return false;
  }
  
  private void getLocalOftenReadData()
  {
    AppMethodBeat.i(6114);
    if (!bs.gY(this.nEj))
    {
      AppMethodBeat.o(6114);
      return;
    }
    a(e.bKr());
    AppMethodBeat.o(6114);
  }
  
  private void getOftenRead()
  {
    AppMethodBeat.i(6115);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6100);
        BizTimeLineHotView.c(BizTimeLineHotView.this);
        AppMethodBeat.o(6100);
      }
    }, 0L);
    AppMethodBeat.o(6115);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(6111);
    com.tencent.mm.kernel.g.agi().a(2768, this);
    this.nEf = new WeakReference((Activity)paramContext);
    a.init(paramContext);
    this.mvQ = getItemPadding();
    View localView = z.jD(paramContext).inflate(2131493207, this);
    this.nEg = ((BizTimeLineHotListView)localView.findViewById(2131297333));
    this.myG = ((TextView)localView.findViewById(2131297341));
    this.nEh = ((TextView)localView.findViewById(2131307282));
    this.nEk = new c(this.mvQ, paramContext);
    this.nEg.a(this.nEk);
    this.nEg.a(paramContext, this.nEj, this.nDU, this);
    getLocalOftenReadData();
    getOftenRead();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().a(this);
    com.tencent.mm.sdk.b.a.GpY.c(this.nEm);
    AppMethodBeat.o(6111);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(6109);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.e("MicroMsg.BizTimeLineHotList", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(6109);
      return;
    }
    if ((this.nEf.get() == null) || (((Activity)this.nEf.get()).isFinishing()))
    {
      AppMethodBeat.o(6109);
      return;
    }
    Tz((String)paramObject);
    AppMethodBeat.o(6109);
  }
  
  public final void bKm()
  {
    AppMethodBeat.i(6119);
    if ((getVisibility() != 0) || (bs.gY(this.nEj)))
    {
      AppMethodBeat.o(6119);
      return;
    }
    this.nEg.bKm();
    AppMethodBeat.o(6119);
  }
  
  public final void bKn()
  {
    AppMethodBeat.i(198736);
    if ((this.nEh != null) && (this.nEh.getVisibility() == 0)) {
      this.nEh.setVisibility(8);
    }
    AppMethodBeat.o(198736);
  }
  
  public final void bKp()
  {
    AppMethodBeat.i(6117);
    if (bs.gY(this.nEj))
    {
      AppMethodBeat.o(6117);
      return;
    }
    Iterator localIterator = this.nEj.iterator();
    while (localIterator.hasNext()) {
      b((b)localIterator.next());
    }
    AppMethodBeat.o(6117);
  }
  
  public final void e(t paramt)
  {
    AppMethodBeat.i(6107);
    if (paramt != null)
    {
      t localt = af.aDc().AA(paramt.field_talkerId);
      if ((localt != null) && (localt.field_msgId == paramt.field_msgId))
      {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNK(paramt.field_talker);
        Tz(paramt.field_talker);
      }
    }
    AppMethodBeat.o(6107);
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(6110);
    int i = a.dY(getContext());
    AppMethodBeat.o(6110);
    return i;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(6112);
    super.onConfigurationChanged(paramConfiguration);
    int i = getItemPadding();
    if ((this.nEl != paramConfiguration.orientation) || (this.mvQ != i))
    {
      if (this.nEk != null)
      {
        this.mvQ = i;
        this.nEk.padding = this.mvQ;
      }
      this.nEl = paramConfiguration.orientation;
      paramConfiguration = this.nEg;
      if (paramConfiguration.nDR != null)
      {
        paramConfiguration = paramConfiguration.nDR;
        RecyclerView.i locali = paramConfiguration.nEE.getLayoutManager();
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(locali, locala.aeD(), "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
        locali.ca(((Integer)locala.lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
        paramConfiguration.mOffsetX = 0;
        paramConfiguration.mOe = 0;
        paramConfiguration.mOf = 0;
        paramConfiguration.mHJ = 0;
      }
      Looper.myQueue().addIdleHandler(this.nEp);
    }
    AppMethodBeat.o(6112);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(6120);
    ac.i("MicroMsg.BizTimeLineHotList", "onSceneEnd, type %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(6120);
      return;
    }
    if ((paramn instanceof j))
    {
      paramString = (dhi)((j)paramn).rr.hvs.hvw;
      if ((this.nEf.get() != null) && (((Activity)this.nEf.get()).isFinishing()))
      {
        AppMethodBeat.o(6120);
        return;
      }
      if (com.tencent.mm.plugin.brandservice.ui.b.c.b(paramString, e.bKr()))
      {
        ac.d("MicroMsg.BizTimeLineHotList", "onSceneEnd nothing change");
        AppMethodBeat.o(6120);
        return;
      }
      e.nEA = paramString;
    }
    try
    {
      paramn = Base64.encodeToString(paramString.toByteArray(), 0);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRk, paramn);
      a(paramString);
      AppMethodBeat.o(6120);
      return;
    }
    catch (IOException paramn)
    {
      for (;;)
      {
        ac.e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", new Object[] { paramn.getMessage() });
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRk, "");
      }
    }
  }
  
  public void setOftenReadTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(198734);
    if (this.myG != null)
    {
      if (this.paddingLeft == paramFloat)
      {
        AppMethodBeat.o(198734);
        return;
      }
      this.paddingLeft = paramFloat;
      this.myG.setPadding((int)paramFloat, this.myG.getPaddingTop(), this.myG.getPaddingRight(), this.myG.getPaddingBottom());
    }
    AppMethodBeat.o(198734);
  }
  
  public void setVideoTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(198735);
    if (this.nEh != null)
    {
      if (this.nEn == paramFloat)
      {
        AppMethodBeat.o(198735);
        return;
      }
      this.nEn = paramFloat;
      if (this.nEh.getVisibility() != 0) {
        this.nEh.setVisibility(0);
      }
      this.nEh.setPadding((int)paramFloat, this.nEh.getPaddingTop(), this.nEh.getPaddingRight(), this.nEh.getPaddingBottom());
    }
    AppMethodBeat.o(198735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView
 * JD-Core Version:    0.7.0.1
 */