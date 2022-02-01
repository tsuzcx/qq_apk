package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.l.b;
import com.tencent.mm.particles.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.j.c.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveConfettiView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveConfettView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CONFETTI_INTERVAL", "", "TAG", "", "beginTimeStamp", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "customConfettiBitmaps", "customConfettiRate", "customTotalRate", "iconAlpha", "", "initX", "initY", "scale", "timeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timeHandler$delegate", "Lkotlin/Lazy;", "addCustomBitmapsAndRate", "", "bitmaps", "rates", "addDefaultBitmap", "emitLikeConfetti", "getView", "nextInt", "next", "onDetachedFromWindow", "rollNextBitmap", "setIconAlpha", "alpha", "setInterval", "ms", "setScale", "setXy", "x", "y", "start", "stopAndDestroy", "plugin-finder_release"})
public final class FinderLiveConfettiView
  extends FrameLayout
  implements com.tencent.mm.plugin.findersdk.a.q
{
  private final String TAG;
  private com.tencent.mm.particles.c kFD;
  private final ArrayList<Bitmap> kFE;
  private float scale;
  private final f xVz;
  private ArrayList<Bitmap> ysY;
  private ArrayList<Integer> ysZ;
  private int yta;
  private long ytg;
  private int znr;
  private int zns;
  private float znt;
  private long znu;
  
  public FinderLiveConfettiView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(279766);
    this.TAG = "FinderLiveConfettiView";
    this.kFE = new ArrayList();
    this.ysY = new ArrayList();
    this.ysZ = new ArrayList();
    paramContext = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    this.ytg = 500L;
    this.scale = 1.0F;
    this.znt = 1.0F;
    this.xVz = g.ar((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(279766);
  }
  
  public FinderLiveConfettiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(279767);
    this.TAG = "FinderLiveConfettiView";
    this.kFE = new ArrayList();
    this.ysY = new ArrayList();
    this.ysZ = new ArrayList();
    paramContext = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    this.ytg = 500L;
    this.scale = 1.0F;
    this.znt = 1.0F;
    this.xVz = g.ar((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(279767);
  }
  
  public FinderLiveConfettiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(279769);
    this.TAG = "FinderLiveConfettiView";
    this.kFE = new ArrayList();
    this.ysY = new ArrayList();
    this.ysZ = new ArrayList();
    paramContext = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    this.ytg = 500L;
    this.scale = 1.0F;
    this.znt = 1.0F;
    this.xVz = g.ar((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(279769);
  }
  
  private static int Nz(int paramInt)
  {
    AppMethodBeat.i(279764);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(279764);
      return 0;
    }
    paramInt = kotlin.j.c.aaBL.os(0, paramInt);
    AppMethodBeat.o(279764);
    return paramInt;
  }
  
  private final Bitmap dBP()
  {
    AppMethodBeat.i(279765);
    Object localObject1 = this.kFE.get(Nz(this.kFE.size()));
    p.j(localObject1, "confettiBitmaps[nextInt(confettiBitmaps.size)]");
    Bitmap localBitmap = (Bitmap)localObject1;
    Object localObject3;
    int i;
    int j;
    if ((this.ysY.size() > 0) && (this.yta > 0))
    {
      synchronized (this.ysY)
      {
        localObject4 = ((Iterable)this.ysZ).iterator();
        if (!((Iterator)localObject4).hasNext())
        {
          localObject1 = (Throwable)new UnsupportedOperationException("Empty collection can't be reduced.");
          AppMethodBeat.o(279765);
          throw ((Throwable)localObject1);
        }
      }
      for (localObject3 = ((Iterator)localObject4).next(); ((Iterator)localObject4).hasNext(); localObject3 = Integer.valueOf(((Number)localObject3).intValue() + i)) {
        i = ((Number)((Iterator)localObject4).next()).intValue();
      }
      j = ((Number)localObject3).intValue();
      if (j < 100) {}
      for (i = 100;; i = j)
      {
        localObject3 = new aa.d();
        ((aa.d)localObject3).aaBA = Nz(i);
        i = ((aa.d)localObject3).aaBA;
        if (i <= j) {
          break;
        }
        AppMethodBeat.o(279765);
        return localBitmap;
      }
      Object localObject4 = (Iterable)this.ysZ;
      i = 0;
      localObject4 = ((Iterable)localObject4).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = ((Iterator)localObject4).next();
        if (i < 0) {
          j.iBO();
        }
        j = ((Number)localObject5).intValue();
        if (((aa.d)localObject3).aaBA <= j)
        {
          localObject3 = (Bitmap)j.M((List)this.ysY, i);
          if (localObject3 != null) {
            break label351;
          }
          localObject3 = localBitmap;
        }
      }
    }
    label351:
    for (;;)
    {
      AppMethodBeat.o(279765);
      return localObject3;
      ((aa.d)localObject3).aaBA -= j;
      i += 1;
      break;
      localObject3 = x.aazN;
      AppMethodBeat.o(279765);
      return localBitmap;
    }
  }
  
  private final MTimerHandler getTimeHandler()
  {
    AppMethodBeat.i(279758);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.xVz.getValue();
    AppMethodBeat.o(279758);
    return localMTimerHandler;
  }
  
  public final void ak(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(279762);
    p.k(paramArrayList, "bitmaps");
    this.kFE.clear();
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      int i = ((Number)paramArrayList.next()).intValue();
      Object localObject = l.b.kum;
      int j = (int)(l.b.aNC() * this.scale);
      localObject = this.kFE;
      Context localContext = getContext();
      p.j(localContext, "context");
      ((ArrayList)localObject).add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(localContext.getResources(), i), j, j, true));
    }
    AppMethodBeat.o(279762);
  }
  
  public final void dIa()
  {
    AppMethodBeat.i(279760);
    getTimeHandler().stopTimer();
    this.kFE.clear();
    this.ysY.clear();
    this.ysZ.clear();
    this.yta = 0;
    Log.i(this.TAG, "[stopAndDestroy]  startTime = " + this.znu);
    AppMethodBeat.o(279760);
  }
  
  public final void g(ArrayList<Bitmap> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    AppMethodBeat.i(279763);
    p.k(paramArrayList, "bitmaps");
    p.k(paramArrayList1, "rates");
    this.ysY.addAll((Collection)paramArrayList);
    this.ysZ.addAll((Collection)paramArrayList1);
    paramArrayList = ((Iterable)paramArrayList1).iterator();
    while (paramArrayList.hasNext()) {
      this.yta = (((Number)paramArrayList.next()).intValue() + this.yta);
    }
    AppMethodBeat.o(279763);
  }
  
  public final void gL(int paramInt1, int paramInt2)
  {
    this.znr = paramInt1;
    this.zns = paramInt2;
  }
  
  public final FrameLayout getView()
  {
    return (FrameLayout)this;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(279761);
    super.onDetachedFromWindow();
    dIa();
    AppMethodBeat.o(279761);
  }
  
  public final void setIconAlpha(float paramFloat)
  {
    this.znt = paramFloat;
  }
  
  public final void setInterval(long paramLong)
  {
    this.ytg = paramLong;
  }
  
  public final void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public final void start()
  {
    AppMethodBeat.i(279759);
    getTimeHandler().stopTimer();
    getTimeHandler().startTimer(this.ytg);
    this.znu = System.currentTimeMillis();
    Log.i(this.TAG, "[start]  time = " + this.znu);
    AppMethodBeat.o(279759);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
  static final class a
    implements b
  {
    a(FinderLiveConfettiView paramFinderLiveConfettiView, Bitmap paramBitmap) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MTimerHandler>
  {
    b(FinderLiveConfettiView paramFinderLiveConfettiView)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
    static final class a
      implements MTimerHandler.CallBack
    {
      a(FinderLiveConfettiView.b paramb) {}
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(278418);
        FinderLiveConfettiView.b(this.znw.znv);
        AppMethodBeat.o(278418);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveConfettiView
 * JD-Core Version:    0.7.0.1
 */