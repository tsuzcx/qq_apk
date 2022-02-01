package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.model.l.b;
import com.tencent.mm.particles.a.b;
import com.tencent.mm.plugin.findersdk.a.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.j.c.a;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveConfettiView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveConfettView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CONFETTI_INTERVAL", "", "TAG", "", "beginTimeStamp", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "customConfettiBitmaps", "customConfettiRate", "customTotalRate", "iconAlpha", "", "initX", "initY", "scale", "timeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timeHandler$delegate", "Lkotlin/Lazy;", "addCustomBitmapsAndRate", "", "bitmaps", "rates", "addDefaultBitmap", "emitLikeConfetti", "getView", "nextInt", "next", "onDetachedFromWindow", "rollNextBitmap", "setIconAlpha", "alpha", "setInterval", "ms", "setScale", "setXy", "x", "y", "start", "stopAndDestroy", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveConfettiView
  extends FrameLayout
  implements an
{
  private final j Bwl;
  private long DdE;
  private ArrayList<Bitmap> Ddv;
  private ArrayList<Integer> Ddw;
  private int Ddx;
  private int Eop;
  private int Eoq;
  private float Eor;
  private long Eos;
  private final String TAG;
  private com.tencent.mm.particles.c niE;
  private final ArrayList<Bitmap> niF;
  private float scale;
  
  public FinderLiveConfettiView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(361806);
    this.TAG = "FinderLiveConfettiView";
    this.niF = new ArrayList();
    this.Ddv = new ArrayList();
    this.Ddw = new ArrayList();
    paramContext = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    this.DdE = com.tencent.mm.plugin.finder.live.utils.a.euN();
    this.scale = 1.0F;
    this.Eor = 1.0F;
    this.Bwl = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(361806);
  }
  
  public FinderLiveConfettiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(361814);
    this.TAG = "FinderLiveConfettiView";
    this.niF = new ArrayList();
    this.Ddv = new ArrayList();
    this.Ddw = new ArrayList();
    paramContext = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    this.DdE = com.tencent.mm.plugin.finder.live.utils.a.euN();
    this.scale = 1.0F;
    this.Eor = 1.0F;
    this.Bwl = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(361814);
  }
  
  public FinderLiveConfettiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(361820);
    this.TAG = "FinderLiveConfettiView";
    this.niF = new ArrayList();
    this.Ddv = new ArrayList();
    this.Ddw = new ArrayList();
    paramContext = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    this.DdE = com.tencent.mm.plugin.finder.live.utils.a.euN();
    this.scale = 1.0F;
    this.Eor = 1.0F;
    this.Bwl = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(361820);
  }
  
  private static int Pa(int paramInt)
  {
    AppMethodBeat.i(361834);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(361834);
      return 0;
    }
    paramInt = kotlin.j.c.aixl.qq(0, paramInt);
    AppMethodBeat.o(361834);
    return paramInt;
  }
  
  private static final b a(Bitmap paramBitmap, FinderLiveConfettiView paramFinderLiveConfettiView, Random paramRandom)
  {
    AppMethodBeat.i(361857);
    s.u(paramBitmap, "$bitmap");
    s.u(paramFinderLiveConfettiView, "this$0");
    paramBitmap = (b)new com.tencent.mm.live.view.b.a(paramBitmap, paramFinderLiveConfettiView.Eor);
    AppMethodBeat.o(361857);
    return paramBitmap;
  }
  
  private final Bitmap eqL()
  {
    AppMethodBeat.i(361847);
    Object localObject1 = this.niF.get(Pa(this.niF.size()));
    s.s(localObject1, "confettiBitmaps[nextInt(confettiBitmaps.size)]");
    Bitmap localBitmap = (Bitmap)localObject1;
    if ((this.Ddv.size() > 0) && (this.Ddx > 0))
    {
      synchronized (this.Ddv)
      {
        localObject4 = ((Iterable)this.Ddw).iterator();
        if (!((Iterator)localObject4).hasNext())
        {
          localObject1 = (Throwable)new UnsupportedOperationException("Empty collection can't be reduced.");
          AppMethodBeat.o(361847);
          throw ((Throwable)localObject1);
        }
      }
      for (Object localObject3 = ((Iterator)localObject4).next(); ((Iterator)localObject4).hasNext(); localObject3 = Integer.valueOf(((Number)localObject3).intValue() + i)) {
        i = ((Number)((Iterator)localObject4).next()).intValue();
      }
      int j = ((Number)localObject3).intValue();
      if (j < 100) {}
      for (int i = 100;; i = j)
      {
        localObject3 = new ah.d();
        ((ah.d)localObject3).aixb = Pa(i);
        i = ((ah.d)localObject3).aixb;
        if (i <= j) {
          break;
        }
        AppMethodBeat.o(361847);
        return localBitmap;
      }
      Object localObject4 = (Iterable)this.Ddw;
      i = 0;
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = ((Iterator)localObject4).next();
        if (i < 0) {
          p.kkW();
        }
        j = ((Number)localObject5).intValue();
        if (((ah.d)localObject3).aixb <= j)
        {
          localObject3 = (Bitmap)p.ae((List)this.Ddv, i);
          if (localObject3 == null) {
            localObject3 = localBitmap;
          }
          for (;;)
          {
            AppMethodBeat.o(361847);
            return localObject3;
          }
        }
        ((ah.d)localObject3).aixb -= j;
        i += 1;
      }
      localObject3 = ah.aiuX;
    }
    AppMethodBeat.o(361847);
    return localBitmap;
  }
  
  private final MTimerHandler getTimeHandler()
  {
    AppMethodBeat.i(361827);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.Bwl.getValue();
    AppMethodBeat.o(361827);
    return localMTimerHandler;
  }
  
  public final void ao(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(361920);
    s.u(paramArrayList, "bitmaps");
    this.niF.clear();
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      int i = ((Number)paramArrayList.next()).intValue();
      l.b localb = l.b.mYf;
      int j = (int)(l.b.bhn() * this.scale);
      this.niF.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), i), j, j, true));
    }
    AppMethodBeat.o(361920);
  }
  
  public final void eAu()
  {
    AppMethodBeat.i(361899);
    getTimeHandler().stopTimer();
    this.niF.clear();
    this.Ddv.clear();
    this.Ddw.clear();
    this.Ddx = 0;
    Log.i(this.TAG, s.X("[stopAndDestroy]  startTime = ", Long.valueOf(this.Eos)));
    AppMethodBeat.o(361899);
  }
  
  public final FrameLayout getView()
  {
    return (FrameLayout)this;
  }
  
  public final void h(ArrayList<Bitmap> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    AppMethodBeat.i(361927);
    s.u(paramArrayList, "bitmaps");
    s.u(paramArrayList1, "rates");
    this.Ddv.addAll((Collection)paramArrayList);
    this.Ddw.addAll((Collection)paramArrayList1);
    paramArrayList = ((Iterable)paramArrayList1).iterator();
    while (paramArrayList.hasNext()) {
      this.Ddx = (((Number)paramArrayList.next()).intValue() + this.Ddx);
    }
    AppMethodBeat.o(361927);
  }
  
  public final void hQ(int paramInt1, int paramInt2)
  {
    this.Eop = paramInt1;
    this.Eoq = paramInt2;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(361904);
    super.onDetachedFromWindow();
    eAu();
    AppMethodBeat.o(361904);
  }
  
  public final void setIconAlpha(float paramFloat)
  {
    this.Eor = paramFloat;
  }
  
  public final void setInterval(long paramLong)
  {
    this.DdE = paramLong;
  }
  
  public final void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public final void start()
  {
    AppMethodBeat.i(361889);
    getTimeHandler().stopTimer();
    getTimeHandler().startTimer(this.DdE);
    this.Eos = System.currentTimeMillis();
    Log.i(this.TAG, s.X("[start]  time = ", Long.valueOf(this.Eos)));
    AppMethodBeat.o(361889);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<MTimerHandler>
  {
    a(FinderLiveConfettiView paramFinderLiveConfettiView)
    {
      super();
    }
    
    private static final boolean b(FinderLiveConfettiView paramFinderLiveConfettiView)
    {
      AppMethodBeat.i(361224);
      s.u(paramFinderLiveConfettiView, "this$0");
      FinderLiveConfettiView.a(paramFinderLiveConfettiView);
      AppMethodBeat.o(361224);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveConfettiView
 * JD-Core Version:    0.7.0.1
 */