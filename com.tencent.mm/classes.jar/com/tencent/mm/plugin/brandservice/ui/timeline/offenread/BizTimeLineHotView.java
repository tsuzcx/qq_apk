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
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.w;
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
  implements com.tencent.mm.ak.f, i, n.b
{
  private int nbB;
  private TextView jdField_new;
  WeakReference<Activity> omE;
  public BizTimeLineHotListView omF;
  private TextView omG;
  private boolean omH;
  private List<b> omI;
  private c omJ;
  private int omK;
  public com.tencent.mm.sdk.b.c omL;
  private float omM;
  private boolean omN;
  private MessageQueue.IdleHandler omO;
  public f omp;
  private float paddingLeft;
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6105);
    this.nbB = 0;
    this.omH = false;
    this.omI = new CopyOnWriteArrayList();
    this.omp = new f();
    this.omK = 0;
    this.omL = new com.tencent.mm.sdk.b.c() {};
    this.paddingLeft = -1.0F;
    this.omM = -1.0F;
    this.omN = true;
    this.omO = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(224134);
        Looper.myQueue().removeIdleHandler(BizTimeLineHotView.i(BizTimeLineHotView.this));
        if ((BizTimeLineHotView.this.omE.get() == null) || (((Activity)BizTimeLineHotView.this.omE.get()).isFinishing()))
        {
          AppMethodBeat.o(224134);
          return false;
        }
        BizTimeLineHotView.h(BizTimeLineHotView.this).cg(BizTimeLineHotView.a(BizTimeLineHotView.this));
        AppMethodBeat.o(224134);
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
    this.nbB = 0;
    this.omH = false;
    this.omI = new CopyOnWriteArrayList();
    this.omp = new f();
    this.omK = 0;
    this.omL = new com.tencent.mm.sdk.b.c() {};
    this.paddingLeft = -1.0F;
    this.omM = -1.0F;
    this.omN = true;
    this.omO = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(224134);
        Looper.myQueue().removeIdleHandler(BizTimeLineHotView.i(BizTimeLineHotView.this));
        if ((BizTimeLineHotView.this.omE.get() == null) || (((Activity)BizTimeLineHotView.this.omE.get()).isFinishing()))
        {
          AppMethodBeat.o(224134);
          return false;
        }
        BizTimeLineHotView.h(BizTimeLineHotView.this).cg(BizTimeLineHotView.a(BizTimeLineHotView.this));
        AppMethodBeat.o(224134);
        return false;
      }
    };
    init(paramContext);
    AppMethodBeat.o(6106);
  }
  
  private void a(final dnu paramdnu)
  {
    AppMethodBeat.i(6116);
    if (paramdnu != null)
    {
      com.tencent.mm.plugin.brandservice.ui.b.a.tM(paramdnu.HUW * 1000);
      com.tencent.mm.plugin.brandservice.ui.b.a.tN(paramdnu.HUU);
      if (paramdnu.HUT != null) {}
      for (int i = paramdnu.HUT.size();; i = 0)
      {
        ae.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramdnu.HUV), Integer.valueOf(paramdnu.HUU) });
        if (!com.tencent.mm.plugin.brandservice.ui.b.a.Aq(4)) {
          break;
        }
        setVisibility(8);
        AppMethodBeat.o(6116);
        return;
      }
    }
    AppMethodBeat.o(6116);
    return;
    if (com.tencent.mm.plugin.biz.b.b.bNx())
    {
      paramdnu.HUT.clear();
      this.omI.clear();
    }
    if ((bu.ht(paramdnu.HUT)) && (bu.ht(this.omI)) && (!bPN()))
    {
      setVisibility(8);
      ae.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
      AppMethodBeat.o(6116);
      return;
    }
    h.MqF.f(new Runnable()
    {
      public final void run()
      {
        boolean bool = false;
        AppMethodBeat.i(224132);
        if (!bu.ht(paramdnu.HUT))
        {
          BizTimeLineHotView.a(BizTimeLineHotView.this, new ArrayList());
          Object localObject = paramdnu.HUT.iterator();
          int i = 0;
          while (((Iterator)localObject).hasNext())
          {
            dnw localdnw = (dnw)((Iterator)localObject).next();
            int j = i + 1;
            if (j > 12) {
              break;
            }
            b localb = new b();
            i = j;
            if (com.tencent.mm.model.x.An(localdnw.FQp))
            {
              localb.FQp = localdnw.FQp;
              BizTimeLineHotView.a(BizTimeLineHotView.this).add(localb);
              i = j;
            }
          }
          BizTimeLineHotView.this.bPO();
          localObject = BizTimeLineHotView.this;
          if (paramdnu.HUV == 1) {
            bool = true;
          }
          BizTimeLineHotView.a((BizTimeLineHotView)localObject, bool);
        }
        BizTimeLineHotView.b(BizTimeLineHotView.this);
        AppMethodBeat.o(224132);
      }
    }, "MicroMsg.BizTimeLineHotList");
    AppMethodBeat.o(6116);
  }
  
  public static boolean b(b paramb)
  {
    AppMethodBeat.i(6118);
    long l = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUN(paramb.FQp);
    Object localObject = ag.aGv().DP(l);
    if (localObject == null)
    {
      AppMethodBeat.o(6118);
      return false;
    }
    paramb.nyu = ((w)localObject).field_createTime;
    localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVa(paramb.FQp);
    boolean bool = paramb.omV;
    paramb.omV = false;
    if ((localObject != null) && (((ba)localObject).field_unReadCount > 0) && (System.currentTimeMillis() - paramb.nyu < com.tencent.mm.plugin.brandservice.ui.b.a.bTs()))
    {
      int i = ag.aGw().Ea(l);
      if (((ba)localObject).field_unReadCount > i) {
        paramb.omV = true;
      }
    }
    if (bool != paramb.omV)
    {
      AppMethodBeat.o(6118);
      return true;
    }
    AppMethodBeat.o(6118);
    return false;
  }
  
  private static boolean bPN()
  {
    AppMethodBeat.i(208507);
    if ((com.tencent.mm.plugin.brandservice.b.c.bOt()) && (com.tencent.mm.plugin.brandservice.b.c.bOv() != null))
    {
      AppMethodBeat.o(208507);
      return true;
    }
    AppMethodBeat.o(208507);
    return false;
  }
  
  private void getLocalOftenReadData()
  {
    AppMethodBeat.i(6114);
    if (!bu.ht(this.omI))
    {
      AppMethodBeat.o(6114);
      return;
    }
    a(e.bPQ());
    AppMethodBeat.o(6114);
  }
  
  private void getOftenRead()
  {
    AppMethodBeat.i(6115);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6101);
        BizTimeLineHotView.c(BizTimeLineHotView.this);
        AppMethodBeat.o(6101);
      }
    }, 0L);
    AppMethodBeat.o(6115);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(6111);
    com.tencent.mm.kernel.g.ajj().a(2768, this);
    this.omE = new WeakReference((Activity)paramContext);
    a.init(paramContext);
    this.nbB = getItemPadding();
    View localView = com.tencent.mm.ui.z.jV(paramContext).inflate(2131493207, this);
    this.omF = ((BizTimeLineHotListView)localView.findViewById(2131297333));
    this.jdField_new = ((TextView)localView.findViewById(2131297341));
    this.omG = ((TextView)localView.findViewById(2131307282));
    this.omJ = new c(this.nbB, paramContext);
    this.omF.a(this.omJ);
    this.omF.a(paramContext, this.omI, this.omp, this);
    getLocalOftenReadData();
    getOftenRead();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a(this);
    com.tencent.mm.sdk.b.a.IvT.c(this.omL);
    AppMethodBeat.o(6111);
  }
  
  public final void XS(final String paramString)
  {
    AppMethodBeat.i(6108);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224128);
        if (BizTimeLineHotView.a(BizTimeLineHotView.this) == null)
        {
          AppMethodBeat.o(224128);
          return;
        }
        if ((paramString == null) || (com.tencent.mm.model.x.AN(paramString)))
        {
          AppMethodBeat.o(224128);
          return;
        }
        Iterator localIterator = BizTimeLineHotView.a(BizTimeLineHotView.this).iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (paramString.equals(localb.FQp)) {
            if (BizTimeLineHotView.b(localb))
            {
              BizTimeLineHotView.a(BizTimeLineHotView.this, localb);
              AppMethodBeat.o(224128);
              return;
            }
          }
        }
        AppMethodBeat.o(224128);
      }
    }, 0L);
    AppMethodBeat.o(6108);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(6109);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ae.e("MicroMsg.BizTimeLineHotList", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(6109);
      return;
    }
    if ((this.omE.get() == null) || (((Activity)this.omE.get()).isFinishing()))
    {
      AppMethodBeat.o(6109);
      return;
    }
    XS((String)paramObject);
    AppMethodBeat.o(6109);
  }
  
  public final void bPL()
  {
    AppMethodBeat.i(6119);
    if ((getVisibility() != 0) || (bu.ht(this.omI)))
    {
      AppMethodBeat.o(6119);
      return;
    }
    this.omF.bPL();
    AppMethodBeat.o(6119);
  }
  
  public final void bPM()
  {
    AppMethodBeat.i(208506);
    if ((this.omG != null) && (this.omG.getVisibility() == 0)) {
      this.omG.setVisibility(8);
    }
    AppMethodBeat.o(208506);
  }
  
  public final void bPO()
  {
    AppMethodBeat.i(6117);
    if (bu.ht(this.omI))
    {
      AppMethodBeat.o(6117);
      return;
    }
    Iterator localIterator = this.omI.iterator();
    while (localIterator.hasNext()) {
      b((b)localIterator.next());
    }
    AppMethodBeat.o(6117);
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(6110);
    int i = a.ec(getContext());
    AppMethodBeat.o(6110);
    return i;
  }
  
  public final void j(final w paramw)
  {
    AppMethodBeat.i(6107);
    if (paramw != null) {
      h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6097);
          w localw = ag.aGv().DP(paramw.field_talkerId);
          if ((localw != null) && (localw.field_msgId == paramw.field_msgId))
          {
            ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVc(paramw.field_talker);
            BizTimeLineHotView.this.XS(paramw.field_talker);
          }
          AppMethodBeat.o(6097);
        }
      }, "MicroMsg.BizTimeLineHotList");
    }
    AppMethodBeat.o(6107);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(6112);
    super.onConfigurationChanged(paramConfiguration);
    int i = getItemPadding();
    if ((this.omK != paramConfiguration.orientation) || (this.nbB != i))
    {
      if (this.omJ != null)
      {
        this.nbB = i;
        this.omJ.padding = this.nbB;
      }
      this.omK = paramConfiguration.orientation;
      paramConfiguration = this.omF;
      if (paramConfiguration.omm != null)
      {
        paramConfiguration = paramConfiguration.omm;
        RecyclerView.i locali = paramConfiguration.ong.getLayoutManager();
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(locali, locala.ahE(), "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
        locali.ca(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
        paramConfiguration.mOffsetX = 0;
        paramConfiguration.ntL = 0;
        paramConfiguration.ntM = 0;
        paramConfiguration.nnp = 0;
      }
      Looper.myQueue().addIdleHandler(this.omO);
    }
    AppMethodBeat.o(6112);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(6120);
    ae.i("MicroMsg.BizTimeLineHotList", "onSceneEnd, type %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(6120);
      return;
    }
    if ((paramn instanceof j))
    {
      paramString = (dnu)((j)paramn).rr.hQE.hQJ;
      if ((this.omE.get() != null) && (((Activity)this.omE.get()).isFinishing()))
      {
        AppMethodBeat.o(6120);
        return;
      }
      if (com.tencent.mm.plugin.brandservice.ui.b.c.b(paramString, e.bPQ()))
      {
        ae.d("MicroMsg.BizTimeLineHotList", "onSceneEnd nothing change");
        AppMethodBeat.o(6120);
        return;
      }
      e.onb = paramString;
    }
    try
    {
      paramn = Base64.encodeToString(paramString.toByteArray(), 0);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYo, paramn);
      a(paramString);
      AppMethodBeat.o(6120);
      return;
    }
    catch (IOException paramn)
    {
      for (;;)
      {
        ae.e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", new Object[] { paramn.getMessage() });
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYo, "");
      }
    }
  }
  
  public void setOftenReadTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(208504);
    if (this.jdField_new != null)
    {
      if (this.paddingLeft == paramFloat)
      {
        AppMethodBeat.o(208504);
        return;
      }
      this.paddingLeft = paramFloat;
      this.jdField_new.setPadding((int)paramFloat, this.jdField_new.getPaddingTop(), this.jdField_new.getPaddingRight(), this.jdField_new.getPaddingBottom());
    }
    AppMethodBeat.o(208504);
  }
  
  public void setVideoTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(208505);
    if (this.omG != null)
    {
      if (this.omM == paramFloat)
      {
        AppMethodBeat.o(208505);
        return;
      }
      this.omM = paramFloat;
      if (this.omG.getVisibility() != 0) {
        this.omG.setVisibility(0);
      }
      this.omG.setPadding((int)paramFloat, this.omG.getPaddingTop(), this.omG.getPaddingRight(), this.omG.getPaddingBottom());
    }
    AppMethodBeat.o(208505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView
 * JD-Core Version:    0.7.0.1
 */