package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.an.a;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ehp;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.z;
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
  implements com.tencent.mm.ak.i, j, MStorageEx.IOnStorageChange
{
  private TextView jUu;
  private int omS;
  private float paddingLeft;
  public g pyZ;
  private MessageQueue.IdleHandler pzA;
  WeakReference<Activity> pzq;
  public BizTimeLineHotListView pzr;
  private TextView pzs;
  private boolean pzt;
  private List<c> pzu;
  private d pzv;
  private int pzw;
  public IListener pzx;
  private float pzy;
  private boolean pzz;
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6105);
    this.omS = 0;
    this.pzt = false;
    this.pzu = new CopyOnWriteArrayList();
    this.pyZ = new g();
    this.pzw = 0;
    this.pzx = new IListener() {};
    this.paddingLeft = -1.0F;
    this.pzy = -1.0F;
    this.pzz = true;
    this.pzA = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(195003);
        Looper.myQueue().removeIdleHandler(BizTimeLineHotView.l(BizTimeLineHotView.this));
        if ((BizTimeLineHotView.this.pzq.get() == null) || (((Activity)BizTimeLineHotView.this.pzq.get()).isFinishing()))
        {
          AppMethodBeat.o(195003);
          return false;
        }
        BizTimeLineHotView.f(BizTimeLineHotView.this).c(BizTimeLineHotView.a(BizTimeLineHotView.this), true);
        AppMethodBeat.o(195003);
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
    this.omS = 0;
    this.pzt = false;
    this.pzu = new CopyOnWriteArrayList();
    this.pyZ = new g();
    this.pzw = 0;
    this.pzx = new IListener() {};
    this.paddingLeft = -1.0F;
    this.pzy = -1.0F;
    this.pzz = true;
    this.pzA = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(195003);
        Looper.myQueue().removeIdleHandler(BizTimeLineHotView.l(BizTimeLineHotView.this));
        if ((BizTimeLineHotView.this.pzq.get() == null) || (((Activity)BizTimeLineHotView.this.pzq.get()).isFinishing()))
        {
          AppMethodBeat.o(195003);
          return false;
        }
        BizTimeLineHotView.f(BizTimeLineHotView.this).c(BizTimeLineHotView.a(BizTimeLineHotView.this), true);
        AppMethodBeat.o(195003);
        return false;
      }
    };
    init(paramContext);
    AppMethodBeat.o(6106);
  }
  
  private void a(final ehp paramehp)
  {
    AppMethodBeat.i(6116);
    if (paramehp != null)
    {
      com.tencent.mm.plugin.brandservice.ui.b.a.BR(paramehp.Nhg * 1000);
      com.tencent.mm.plugin.brandservice.ui.b.a.BS(paramehp.Nhe);
      if (paramehp.Nhd != null) {}
      for (int i = paramehp.Nhd.size();; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramehp.Nhf), Integer.valueOf(paramehp.Nhe) });
        if (!com.tencent.mm.plugin.brandservice.ui.b.a.DV(4)) {
          break;
        }
        setVisibility(8);
        AppMethodBeat.o(6116);
        return;
      }
    }
    AppMethodBeat.o(6116);
    return;
    if (com.tencent.mm.plugin.biz.b.c.ckt())
    {
      paramehp.Nhd.clear();
      this.pzu.clear();
    }
    if ((Util.isNullOrNil(paramehp.Nhd)) && (Util.isNullOrNil(this.pzu)) && (!cno()))
    {
      setVisibility(8);
      Log.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
      AppMethodBeat.o(6116);
      return;
    }
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        boolean bool = false;
        AppMethodBeat.i(6102);
        if (!Util.isNullOrNil(paramehp.Nhd))
        {
          BizTimeLineHotView.a(BizTimeLineHotView.this, new ArrayList());
          Object localObject = paramehp.Nhd.iterator();
          int i = 0;
          while (((Iterator)localObject).hasNext())
          {
            ehs localehs = (ehs)((Iterator)localObject).next();
            int j = i + 1;
            if (j > 12) {
              break;
            }
            c localc = new c();
            i = j;
            if (ab.IS(localehs.KJV))
            {
              localc.KJV = localehs.KJV;
              BizTimeLineHotView.a(BizTimeLineHotView.this).add(localc);
              i = j;
            }
          }
          BizTimeLineHotView.this.cnp();
          localObject = BizTimeLineHotView.this;
          if (paramehp.Nhf == 1) {
            bool = true;
          }
          BizTimeLineHotView.a((BizTimeLineHotView)localObject, bool);
        }
        BizTimeLineHotView.b(BizTimeLineHotView.this);
        AppMethodBeat.o(6102);
      }
    }, "MicroMsg.BizTimeLineHotList");
    AppMethodBeat.o(6116);
  }
  
  public static boolean b(c paramc)
  {
    AppMethodBeat.i(6118);
    long l = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjM(paramc.KJV);
    Object localObject = ag.ban().MP(l);
    if (localObject == null)
    {
      AppMethodBeat.o(6118);
      return false;
    }
    paramc.oJs = ((z)localObject).field_createTime;
    localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjY(paramc.KJV);
    boolean bool = paramc.pzL;
    paramc.pzL = false;
    if ((localObject != null) && (((bb)localObject).field_unReadCount > 0) && (System.currentTimeMillis() - paramc.oJs < com.tencent.mm.plugin.brandservice.ui.b.a.crd()))
    {
      int i = ag.bap().Ne(l);
      if (((bb)localObject).field_unReadCount > i) {
        paramc.pzL = true;
      }
    }
    if (bool != paramc.pzL)
    {
      AppMethodBeat.o(6118);
      return true;
    }
    AppMethodBeat.o(6118);
    return false;
  }
  
  private static boolean cno()
  {
    AppMethodBeat.i(195008);
    if ((com.tencent.mm.plugin.brandservice.b.c.clu()) && (com.tencent.mm.plugin.brandservice.b.c.clw() != null))
    {
      AppMethodBeat.o(195008);
      return true;
    }
    AppMethodBeat.o(195008);
    return false;
  }
  
  private void getLocalOftenReadData()
  {
    AppMethodBeat.i(6114);
    if (!Util.isNullOrNil(this.pzu))
    {
      AppMethodBeat.o(6114);
      return;
    }
    a(f.cnr());
    AppMethodBeat.o(6114);
  }
  
  private void getOftenRead()
  {
    AppMethodBeat.i(6115);
    b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195002);
        BizTimeLineHotView.g(BizTimeLineHotView.this);
        AppMethodBeat.o(195002);
      }
    }, 0L);
    AppMethodBeat.o(6115);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(6111);
    com.tencent.mm.kernel.g.azz().a(2768, this);
    this.pzq = new WeakReference((Activity)paramContext);
    a.init(paramContext);
    this.omS = getItemPadding();
    View localView = com.tencent.mm.ui.aa.jQ(paramContext).inflate(2131493255, this);
    this.pzr = ((BizTimeLineHotListView)localView.findViewById(2131297538));
    this.jUu = ((TextView)localView.findViewById(2131297551));
    this.pzs = ((TextView)localView.findViewById(2131297552));
    this.pzv = new d(this.omS, paramContext);
    this.pzr.a(this.pzv);
    this.pzr.a(paramContext, this.pzu, this.pyZ, this);
    getLocalOftenReadData();
    getOftenRead();
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().add(this);
    EventCenter.instance.addListener(this.pzx);
    AppMethodBeat.o(6111);
  }
  
  public final void ahQ(final String paramString)
  {
    AppMethodBeat.i(6108);
    b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194997);
        if (BizTimeLineHotView.a(BizTimeLineHotView.this) == null)
        {
          AppMethodBeat.o(194997);
          return;
        }
        if ((paramString == null) || (ab.Js(paramString)))
        {
          AppMethodBeat.o(194997);
          return;
        }
        try
        {
          Iterator localIterator = BizTimeLineHotView.a(BizTimeLineHotView.this).iterator();
          while (localIterator.hasNext())
          {
            c localc = (c)localIterator.next();
            if (paramString.equals(localc.KJV)) {
              if (BizTimeLineHotView.b(localc))
              {
                BizTimeLineHotView.a(BizTimeLineHotView.this, localc);
                AppMethodBeat.o(194997);
                return;
              }
            }
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.BizTimeLineHotList", "updateGreenDot ex:%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(194997);
          return;
        }
        AppMethodBeat.o(194997);
      }
    }, 0L);
    AppMethodBeat.o(6108);
  }
  
  public final void cnm()
  {
    AppMethodBeat.i(6119);
    if ((getVisibility() != 0) || ((Util.isNullOrNil(this.pzu)) && (!this.pzr.pyY)))
    {
      AppMethodBeat.o(6119);
      return;
    }
    this.pzr.cnm();
    AppMethodBeat.o(6119);
  }
  
  public final void cnn()
  {
    AppMethodBeat.i(195007);
    if ((this.pzs != null) && (this.pzs.getVisibility() == 0)) {
      this.pzs.setVisibility(8);
    }
    AppMethodBeat.o(195007);
  }
  
  public final void cnp()
  {
    AppMethodBeat.i(6117);
    if (Util.isNullOrNil(this.pzu))
    {
      AppMethodBeat.o(6117);
      return;
    }
    Iterator localIterator = this.pzu.iterator();
    while (localIterator.hasNext()) {
      b((c)localIterator.next());
    }
    AppMethodBeat.o(6117);
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(6110);
    int i = a.ew(getContext());
    AppMethodBeat.o(6110);
    return i;
  }
  
  public final void o(z paramz)
  {
    AppMethodBeat.i(195004);
    p(paramz);
    AppMethodBeat.o(195004);
  }
  
  public void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(6112);
    super.onConfigurationChanged(paramConfiguration);
    if (this.pzq.get() == null)
    {
      AppMethodBeat.o(6112);
      return;
    }
    final View localView = ((Activity)this.pzq.get()).getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(195001);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = BizTimeLineHotView.this.getItemPadding();
        if ((BizTimeLineHotView.c(BizTimeLineHotView.this) != paramConfiguration.orientation) || (BizTimeLineHotView.d(BizTimeLineHotView.this) != i))
        {
          if (BizTimeLineHotView.e(BizTimeLineHotView.this) != null)
          {
            BizTimeLineHotView.a(BizTimeLineHotView.this, i);
            BizTimeLineHotView.e(BizTimeLineHotView.this).padding = BizTimeLineHotView.d(BizTimeLineHotView.this);
          }
          BizTimeLineHotView.b(BizTimeLineHotView.this, paramConfiguration.orientation);
          Object localObject = BizTimeLineHotView.f(BizTimeLineHotView.this);
          if (((BizTimeLineHotListView)localObject).pyW != null)
          {
            localObject = ((BizTimeLineHotListView)localObject).pyW;
            RecyclerView.LayoutManager localLayoutManager = ((h)localObject).pzW.getLayoutManager();
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, locala.axQ(), "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
            localLayoutManager.scrollToPosition(((Integer)locala.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((h)localObject).mOffsetX = 0;
            ((h)localObject).oDP = 0;
            ((h)localObject).oDQ = 0;
            ((h)localObject).owW = 0;
          }
          BizTimeLineHotView.f(BizTimeLineHotView.this).c(BizTimeLineHotView.a(BizTimeLineHotView.this), true);
        }
        AppMethodBeat.o(195001);
      }
    });
    AppMethodBeat.o(6112);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(6109);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.e("MicroMsg.BizTimeLineHotList", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(6109);
      return;
    }
    if ((this.pzq.get() == null) || (((Activity)this.pzq.get()).isFinishing()))
    {
      AppMethodBeat.o(6109);
      return;
    }
    ahQ((String)paramObject);
    AppMethodBeat.o(6109);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(6120);
    Log.i("MicroMsg.BizTimeLineHotList", "onSceneEnd, type %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(6120);
      return;
    }
    if ((paramq instanceof k))
    {
      paramString = (ehp)((k)paramq).rr.iLL.iLR;
      if ((this.pzq.get() != null) && (((Activity)this.pzq.get()).isFinishing()))
      {
        AppMethodBeat.o(6120);
        return;
      }
      if (com.tencent.mm.plugin.brandservice.ui.b.c.b(paramString, f.cnr()))
      {
        Log.d("MicroMsg.BizTimeLineHotList", "onSceneEnd nothing change");
        AppMethodBeat.o(6120);
        return;
      }
      f.pzR = paramString;
    }
    try
    {
      paramq = Base64.encodeToString(paramString.toByteArray(), 0);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgL, paramq);
      a(paramString);
      AppMethodBeat.o(6120);
      return;
    }
    catch (IOException paramq)
    {
      for (;;)
      {
        Log.e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", new Object[] { paramq.getMessage() });
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgL, "");
      }
    }
  }
  
  public final void p(final z paramz)
  {
    AppMethodBeat.i(6107);
    if (paramz != null) {
      com.tencent.f.h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6097);
          z localz = ag.ban().MP(paramz.field_talkerId);
          if ((localz != null) && (localz.field_msgId == paramz.field_msgId))
          {
            ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bka(paramz.field_talker);
            BizTimeLineHotView.this.ahQ(paramz.field_talker);
          }
          AppMethodBeat.o(6097);
        }
      }, "MicroMsg.BizTimeLineHotList");
    }
    AppMethodBeat.o(6107);
  }
  
  public void setOftenReadTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(195005);
    if (this.jUu != null)
    {
      if (this.paddingLeft == paramFloat)
      {
        AppMethodBeat.o(195005);
        return;
      }
      this.paddingLeft = paramFloat;
      this.jUu.setPadding((int)paramFloat, this.jUu.getPaddingTop(), this.jUu.getPaddingRight(), this.jUu.getPaddingBottom());
    }
    AppMethodBeat.o(195005);
  }
  
  public void setVideoTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(195006);
    if (this.pzs != null)
    {
      if (this.pzy == paramFloat)
      {
        AppMethodBeat.o(195006);
        return;
      }
      this.pzy = paramFloat;
      if (this.pzs.getVisibility() != 0) {
        this.pzs.setVisibility(0);
      }
      this.pzs.setPadding((int)paramFloat, this.pzs.getPaddingTop(), this.pzs.getPaddingRight(), this.pzs.getPaddingBottom());
    }
    AppMethodBeat.o(195006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView
 * JD-Core Version:    0.7.0.1
 */