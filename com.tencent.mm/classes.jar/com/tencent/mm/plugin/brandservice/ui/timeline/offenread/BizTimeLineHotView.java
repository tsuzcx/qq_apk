package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.am.af;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.protocal.protobuf.dby;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.y;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BizTimeLineHotView
  extends LinearLayout
  implements com.tencent.mm.al.g, n.b
{
  private int lTO;
  private TextView lWE;
  WeakReference<Activity> nbA;
  public BizTimeLineHotListView nbB;
  private boolean nbC;
  private List<b> nbD;
  private c nbE;
  private int nbF;
  public com.tencent.mm.sdk.b.c nbG;
  private boolean nbH;
  private MessageQueue.IdleHandler nbI;
  public f nbw;
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6105);
    this.lTO = 0;
    this.nbC = false;
    this.nbD = new ArrayList();
    this.nbw = new f();
    this.nbF = 0;
    this.nbG = new com.tencent.mm.sdk.b.c() {};
    this.nbH = true;
    this.nbI = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(6103);
        Looper.myQueue().removeIdleHandler(BizTimeLineHotView.g(BizTimeLineHotView.this));
        if ((BizTimeLineHotView.this.nbA.get() == null) || (((Activity)BizTimeLineHotView.this.nbA.get()).isFinishing()))
        {
          AppMethodBeat.o(6103);
          return false;
        }
        BizTimeLineHotView.f(BizTimeLineHotView.this).cc(BizTimeLineHotView.a(BizTimeLineHotView.this));
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
    this.lTO = 0;
    this.nbC = false;
    this.nbD = new ArrayList();
    this.nbw = new f();
    this.nbF = 0;
    this.nbG = new com.tencent.mm.sdk.b.c() {};
    this.nbH = true;
    this.nbI = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(6103);
        Looper.myQueue().removeIdleHandler(BizTimeLineHotView.g(BizTimeLineHotView.this));
        if ((BizTimeLineHotView.this.nbA.get() == null) || (((Activity)BizTimeLineHotView.this.nbA.get()).isFinishing()))
        {
          AppMethodBeat.o(6103);
          return false;
        }
        BizTimeLineHotView.f(BizTimeLineHotView.this).cc(BizTimeLineHotView.a(BizTimeLineHotView.this));
        AppMethodBeat.o(6103);
        return false;
      }
    };
    init(paramContext);
    AppMethodBeat.o(6106);
  }
  
  private void Po(final String paramString)
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
        if ((paramString == null) || (w.td(paramString)))
        {
          AppMethodBeat.o(6097);
          return;
        }
        Iterator localIterator = BizTimeLineHotView.a(BizTimeLineHotView.this).iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (paramString.equals(localb.CAc)) {
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
  
  private void a(final dbw paramdbw)
  {
    AppMethodBeat.i(6116);
    if (paramdbw != null)
    {
      com.tencent.mm.plugin.brandservice.ui.b.a.nK(paramdbw.EtC * 1000);
      com.tencent.mm.plugin.brandservice.ui.b.a.nL(paramdbw.EtA);
    }
    if ((paramdbw == null) || (bt.gL(paramdbw.Etz)))
    {
      if (bt.gL(this.nbD)) {
        setVisibility(8);
      }
      ad.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
      AppMethodBeat.o(6116);
      return;
    }
    ad.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", new Object[] { Integer.valueOf(paramdbw.Etz.size()), Integer.valueOf(paramdbw.EtB), Integer.valueOf(paramdbw.EtA) });
    if (com.tencent.mm.plugin.brandservice.ui.b.a.yF(4))
    {
      setVisibility(8);
      AppMethodBeat.o(6116);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        boolean bool = false;
        AppMethodBeat.i(6101);
        BizTimeLineHotView.a(BizTimeLineHotView.this, new ArrayList());
        Object localObject = paramdbw.Etz.iterator();
        int i = 0;
        while (((Iterator)localObject).hasNext())
        {
          dby localdby = (dby)((Iterator)localObject).next();
          int j = i + 1;
          if (j > 12) {
            break;
          }
          b localb = new b();
          i = j;
          if (w.sD(localdby.CAc))
          {
            localb.CAc = localdby.CAc;
            BizTimeLineHotView.a(BizTimeLineHotView.this).add(localb);
            i = j;
          }
        }
        BizTimeLineHotView.this.bDd();
        localObject = BizTimeLineHotView.this;
        if (paramdbw.EtB == 1) {
          bool = true;
        }
        BizTimeLineHotView.a((BizTimeLineHotView)localObject, bool);
        BizTimeLineHotView.b(BizTimeLineHotView.this);
        AppMethodBeat.o(6101);
      }
    }, 0L);
    AppMethodBeat.o(6116);
  }
  
  public static boolean b(b paramb)
  {
    AppMethodBeat.i(6118);
    long l = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aIa(paramb.CAc);
    Object localObject = af.awk().vX(l);
    if (localObject == null)
    {
      AppMethodBeat.o(6118);
      return false;
    }
    paramb.mqz = ((s)localObject).field_createTime;
    localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIn(paramb.CAc);
    boolean bool = paramb.nbP;
    paramb.nbP = false;
    if ((localObject != null) && (((ay)localObject).field_unReadCount > 0) && (System.currentTimeMillis() - paramb.mqz < com.tencent.mm.plugin.brandservice.ui.b.a.bGs()))
    {
      int i = af.awl().wi(l);
      if (((ay)localObject).field_unReadCount > i) {
        paramb.nbP = true;
      }
    }
    if (bool != paramb.nbP)
    {
      AppMethodBeat.o(6118);
      return true;
    }
    AppMethodBeat.o(6118);
    return false;
  }
  
  private void getLocalOftenReadData()
  {
    AppMethodBeat.i(6114);
    if (!bt.gL(this.nbD))
    {
      AppMethodBeat.o(6114);
      return;
    }
    a(e.bDe());
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
    com.tencent.mm.kernel.g.aeS().a(2768, this);
    this.nbA = new WeakReference((Activity)paramContext);
    a.init(paramContext);
    this.lTO = getItemPadding();
    View localView = y.js(paramContext).inflate(2131493207, this);
    this.nbB = ((BizTimeLineHotListView)localView.findViewById(2131297333));
    this.lWE = ((TextView)localView.findViewById(2131297341));
    this.nbE = new c(this.lTO);
    this.nbB.a(this.nbE);
    this.nbB.a(paramContext, this.nbD, this.nbw);
    getLocalOftenReadData();
    getOftenRead();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().a(this);
    com.tencent.mm.sdk.b.a.ESL.c(this.nbG);
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
    if ((this.nbA.get() == null) || (((Activity)this.nbA.get()).isFinishing()))
    {
      AppMethodBeat.o(6109);
      return;
    }
    Po((String)paramObject);
    AppMethodBeat.o(6109);
  }
  
  public final void bDc()
  {
    AppMethodBeat.i(6119);
    if ((getVisibility() != 0) || (bt.gL(this.nbD)))
    {
      AppMethodBeat.o(6119);
      return;
    }
    this.nbB.bDc();
    AppMethodBeat.o(6119);
  }
  
  public final void bDd()
  {
    AppMethodBeat.i(6117);
    if (bt.gL(this.nbD))
    {
      AppMethodBeat.o(6117);
      return;
    }
    Iterator localIterator = this.nbD.iterator();
    while (localIterator.hasNext()) {
      b((b)localIterator.next());
    }
    AppMethodBeat.o(6117);
  }
  
  public final void e(s params)
  {
    AppMethodBeat.i(6107);
    if (params != null)
    {
      s locals = af.awk().vX(params.field_talkerId);
      if ((locals != null) && (locals.field_msgId == params.field_msgId))
      {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIp(params.field_talker);
        Po(params.field_talker);
      }
    }
    AppMethodBeat.o(6107);
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(6110);
    int i = a.dQ(getContext());
    AppMethodBeat.o(6110);
    return i;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(6112);
    super.onConfigurationChanged(paramConfiguration);
    int i = getItemPadding();
    if ((this.nbF != paramConfiguration.orientation) || (this.lTO != i))
    {
      if (this.nbE != null)
      {
        this.lTO = i;
        this.nbE.padding = this.lTO;
      }
      this.nbF = paramConfiguration.orientation;
      Looper.myQueue().addIdleHandler(this.nbI);
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
    if ((paramn instanceof h))
    {
      paramString = (dbw)((h)paramn).rr.gUT.gUX;
      if ((this.nbA.get() != null) && (((Activity)this.nbA.get()).isFinishing()))
      {
        AppMethodBeat.o(6120);
        return;
      }
      if (com.tencent.mm.plugin.brandservice.ui.b.c.b(paramString, e.bDe()))
      {
        ad.d("MicroMsg.BizTimeLineHotList", "onSceneEnd nothing change");
        AppMethodBeat.o(6120);
        return;
      }
      e.nbQ = paramString;
    }
    try
    {
      paramn = Base64.encodeToString(paramString.toByteArray(), 0);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftq, paramn);
      a(paramString);
      AppMethodBeat.o(6120);
      return;
    }
    catch (IOException paramn)
    {
      for (;;)
      {
        ad.e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", new Object[] { paramn.getMessage() });
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftq, "");
      }
    }
  }
  
  public void setTitlePaddingLeft(int paramInt)
  {
    AppMethodBeat.i(6113);
    if (this.lWE != null)
    {
      TextView localTextView = this.lWE;
      localTextView.setPadding(paramInt, localTextView.getPaddingTop(), this.lWE.getPaddingRight(), this.lWE.getPaddingBottom());
    }
    AppMethodBeat.o(6113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView
 * JD-Core Version:    0.7.0.1
 */