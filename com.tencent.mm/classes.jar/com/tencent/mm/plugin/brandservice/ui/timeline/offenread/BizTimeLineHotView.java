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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.dmx;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.x;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BizTimeLineHotView
  extends LinearLayout
  implements com.tencent.mm.al.f, i, n.b
{
  private int mWv;
  private TextView mZo;
  WeakReference<Activity> ogF;
  public BizTimeLineHotListView ogG;
  private TextView ogH;
  private boolean ogI;
  private List<b> ogJ;
  private c ogK;
  private int ogL;
  public com.tencent.mm.sdk.b.c ogM;
  private float ogN;
  private boolean ogO;
  private MessageQueue.IdleHandler ogP;
  public f ogq;
  private float paddingLeft;
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6105);
    this.mWv = 0;
    this.ogI = false;
    this.ogJ = new CopyOnWriteArrayList();
    this.ogq = new f();
    this.ogL = 0;
    this.ogM = new com.tencent.mm.sdk.b.c() {};
    this.paddingLeft = -1.0F;
    this.ogN = -1.0F;
    this.ogO = true;
    this.ogP = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(6103);
        Looper.myQueue().removeIdleHandler(BizTimeLineHotView.i(BizTimeLineHotView.this));
        if ((BizTimeLineHotView.this.ogF.get() == null) || (((Activity)BizTimeLineHotView.this.ogF.get()).isFinishing()))
        {
          AppMethodBeat.o(6103);
          return false;
        }
        BizTimeLineHotView.h(BizTimeLineHotView.this).ce(BizTimeLineHotView.a(BizTimeLineHotView.this));
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
    this.mWv = 0;
    this.ogI = false;
    this.ogJ = new CopyOnWriteArrayList();
    this.ogq = new f();
    this.ogL = 0;
    this.ogM = new com.tencent.mm.sdk.b.c() {};
    this.paddingLeft = -1.0F;
    this.ogN = -1.0F;
    this.ogO = true;
    this.ogP = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(6103);
        Looper.myQueue().removeIdleHandler(BizTimeLineHotView.i(BizTimeLineHotView.this));
        if ((BizTimeLineHotView.this.ogF.get() == null) || (((Activity)BizTimeLineHotView.this.ogF.get()).isFinishing()))
        {
          AppMethodBeat.o(6103);
          return false;
        }
        BizTimeLineHotView.h(BizTimeLineHotView.this).ce(BizTimeLineHotView.a(BizTimeLineHotView.this));
        AppMethodBeat.o(6103);
        return false;
      }
    };
    init(paramContext);
    AppMethodBeat.o(6106);
  }
  
  private void Xg(final String paramString)
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
        if ((paramString == null) || (com.tencent.mm.model.w.Ad(paramString)))
        {
          AppMethodBeat.o(6097);
          return;
        }
        Iterator localIterator = BizTimeLineHotView.a(BizTimeLineHotView.this).iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (paramString.equals(localb.FxR)) {
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
  
  private void a(final dmx paramdmx)
  {
    AppMethodBeat.i(6116);
    if (paramdmx != null)
    {
      com.tencent.mm.plugin.brandservice.ui.b.a.tv(paramdmx.HBj * 1000);
      com.tencent.mm.plugin.brandservice.ui.b.a.tw(paramdmx.HBh);
      if (paramdmx.HBg != null) {}
      for (int i = paramdmx.HBg.size();; i = 0)
      {
        ad.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramdmx.HBi), Integer.valueOf(paramdmx.HBh) });
        if (!com.tencent.mm.plugin.brandservice.ui.b.a.Ae(4)) {
          break;
        }
        setVisibility(8);
        AppMethodBeat.o(6116);
        return;
      }
    }
    AppMethodBeat.o(6116);
    return;
    if (com.tencent.mm.plugin.biz.b.b.bMz())
    {
      paramdmx.HBg.clear();
      this.ogJ.clear();
    }
    if ((bt.hj(paramdmx.HBg)) && (bt.hj(this.ogJ)) && (!bOP()))
    {
      setVisibility(8);
      ad.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
      AppMethodBeat.o(6116);
      return;
    }
    h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        boolean bool = false;
        AppMethodBeat.i(6101);
        if (!bt.hj(paramdmx.HBg))
        {
          BizTimeLineHotView.a(BizTimeLineHotView.this, new ArrayList());
          Object localObject = paramdmx.HBg.iterator();
          int i = 0;
          while (((Iterator)localObject).hasNext())
          {
            dmz localdmz = (dmz)((Iterator)localObject).next();
            int j = i + 1;
            if (j > 12) {
              break;
            }
            b localb = new b();
            i = j;
            if (com.tencent.mm.model.w.zD(localdmz.FxR))
            {
              localb.FxR = localdmz.FxR;
              BizTimeLineHotView.a(BizTimeLineHotView.this).add(localb);
              i = j;
            }
          }
          BizTimeLineHotView.this.bOQ();
          localObject = BizTimeLineHotView.this;
          if (paramdmx.HBi == 1) {
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
    long l = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTm(paramb.FxR);
    Object localObject = ag.aGf().Dq(l);
    if (localObject == null)
    {
      AppMethodBeat.o(6118);
      return false;
    }
    paramb.nsZ = ((com.tencent.mm.storage.w)localObject).field_createTime;
    localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTz(paramb.FxR);
    boolean bool = paramb.ogW;
    paramb.ogW = false;
    if ((localObject != null) && (((ba)localObject).field_unReadCount > 0) && (System.currentTimeMillis() - paramb.nsZ < com.tencent.mm.plugin.brandservice.ui.b.a.bSf()))
    {
      int i = ag.aGg().DB(l);
      if (((ba)localObject).field_unReadCount > i) {
        paramb.ogW = true;
      }
    }
    if (bool != paramb.ogW)
    {
      AppMethodBeat.o(6118);
      return true;
    }
    AppMethodBeat.o(6118);
    return false;
  }
  
  private static boolean bOP()
  {
    AppMethodBeat.i(209551);
    if ((com.tencent.mm.plugin.brandservice.b.c.bNv()) && (com.tencent.mm.plugin.brandservice.b.c.bNx() != null))
    {
      AppMethodBeat.o(209551);
      return true;
    }
    AppMethodBeat.o(209551);
    return false;
  }
  
  private void getLocalOftenReadData()
  {
    AppMethodBeat.i(6114);
    if (!bt.hj(this.ogJ))
    {
      AppMethodBeat.o(6114);
      return;
    }
    a(e.bOS());
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
    com.tencent.mm.kernel.g.aiU().a(2768, this);
    this.ogF = new WeakReference((Activity)paramContext);
    a.init(paramContext);
    this.mWv = getItemPadding();
    View localView = com.tencent.mm.ui.z.jO(paramContext).inflate(2131493207, this);
    this.ogG = ((BizTimeLineHotListView)localView.findViewById(2131297333));
    this.mZo = ((TextView)localView.findViewById(2131297341));
    this.ogH = ((TextView)localView.findViewById(2131307282));
    this.ogK = new c(this.mWv, paramContext);
    this.ogG.a(this.ogK);
    this.ogG.a(paramContext, this.ogJ, this.ogq, this);
    getLocalOftenReadData();
    getOftenRead();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().a(this);
    com.tencent.mm.sdk.b.a.IbL.c(this.ogM);
    AppMethodBeat.o(6111);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(6109);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.e("MicroMsg.BizTimeLineHotList", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(6109);
      return;
    }
    if ((this.ogF.get() == null) || (((Activity)this.ogF.get()).isFinishing()))
    {
      AppMethodBeat.o(6109);
      return;
    }
    Xg((String)paramObject);
    AppMethodBeat.o(6109);
  }
  
  public final void bON()
  {
    AppMethodBeat.i(6119);
    if ((getVisibility() != 0) || (bt.hj(this.ogJ)))
    {
      AppMethodBeat.o(6119);
      return;
    }
    this.ogG.bON();
    AppMethodBeat.o(6119);
  }
  
  public final void bOO()
  {
    AppMethodBeat.i(209550);
    if ((this.ogH != null) && (this.ogH.getVisibility() == 0)) {
      this.ogH.setVisibility(8);
    }
    AppMethodBeat.o(209550);
  }
  
  public final void bOQ()
  {
    AppMethodBeat.i(6117);
    if (bt.hj(this.ogJ))
    {
      AppMethodBeat.o(6117);
      return;
    }
    Iterator localIterator = this.ogJ.iterator();
    while (localIterator.hasNext()) {
      b((b)localIterator.next());
    }
    AppMethodBeat.o(6117);
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(6110);
    int i = a.dY(getContext());
    AppMethodBeat.o(6110);
    return i;
  }
  
  public final void i(com.tencent.mm.storage.w paramw)
  {
    AppMethodBeat.i(6107);
    if (paramw != null)
    {
      com.tencent.mm.storage.w localw = ag.aGf().Dq(paramw.field_talkerId);
      if ((localw != null) && (localw.field_msgId == paramw.field_msgId))
      {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTB(paramw.field_talker);
        Xg(paramw.field_talker);
      }
    }
    AppMethodBeat.o(6107);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(6112);
    super.onConfigurationChanged(paramConfiguration);
    int i = getItemPadding();
    if ((this.ogL != paramConfiguration.orientation) || (this.mWv != i))
    {
      if (this.ogK != null)
      {
        this.mWv = i;
        this.ogK.padding = this.mWv;
      }
      this.ogL = paramConfiguration.orientation;
      paramConfiguration = this.ogG;
      if (paramConfiguration.ogn != null)
      {
        paramConfiguration = paramConfiguration.ogn;
        RecyclerView.i locali = paramConfiguration.ohh.getLayoutManager();
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(locali, locala.ahp(), "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
        locali.ca(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
        paramConfiguration.mOffsetX = 0;
        paramConfiguration.noB = 0;
        paramConfiguration.noC = 0;
        paramConfiguration.nih = 0;
      }
      Looper.myQueue().addIdleHandler(this.ogP);
    }
    AppMethodBeat.o(6112);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(6120);
    ad.i("MicroMsg.BizTimeLineHotList", "onSceneEnd, type %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(6120);
      return;
    }
    if ((paramn instanceof j))
    {
      paramString = (dmx)((j)paramn).rr.hNL.hNQ;
      if ((this.ogF.get() != null) && (((Activity)this.ogF.get()).isFinishing()))
      {
        AppMethodBeat.o(6120);
        return;
      }
      if (com.tencent.mm.plugin.brandservice.ui.b.c.b(paramString, e.bOS()))
      {
        ad.d("MicroMsg.BizTimeLineHotList", "onSceneEnd nothing change");
        AppMethodBeat.o(6120);
        return;
      }
      e.ohc = paramString;
    }
    try
    {
      paramn = Base64.encodeToString(paramString.toByteArray(), 0);
      com.tencent.mm.kernel.g.ajC().ajl().set(com.tencent.mm.storage.al.a.IDO, paramn);
      a(paramString);
      AppMethodBeat.o(6120);
      return;
    }
    catch (IOException paramn)
    {
      for (;;)
      {
        ad.e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", new Object[] { paramn.getMessage() });
        com.tencent.mm.kernel.g.ajC().ajl().set(com.tencent.mm.storage.al.a.IDO, "");
      }
    }
  }
  
  public void setOftenReadTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(209548);
    if (this.mZo != null)
    {
      if (this.paddingLeft == paramFloat)
      {
        AppMethodBeat.o(209548);
        return;
      }
      this.paddingLeft = paramFloat;
      this.mZo.setPadding((int)paramFloat, this.mZo.getPaddingTop(), this.mZo.getPaddingRight(), this.mZo.getPaddingBottom());
    }
    AppMethodBeat.o(209548);
  }
  
  public void setVideoTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(209549);
    if (this.ogH != null)
    {
      if (this.ogN == paramFloat)
      {
        AppMethodBeat.o(209549);
        return;
      }
      this.ogN = paramFloat;
      if (this.ogH.getVisibility() != 0) {
        this.ogH.setVisibility(0);
      }
      this.ogH.setPadding((int)paramFloat, this.ogH.getPaddingTop(), this.ogH.getPaddingRight(), this.ogH.getPaddingBottom());
    }
    AppMethodBeat.o(209549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView
 * JD-Core Version:    0.7.0.1
 */