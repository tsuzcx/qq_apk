package com.tencent.mm.live.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o.b;
import com.tencent.mm.live.d.f;
import com.tencent.mm.particles.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.j.c.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "emitLikeConfetti", "", "x", "", "y", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ac
  extends a
{
  private final String TAG;
  private final b hOp;
  private final FrameLayout hRf;
  private com.tencent.mm.particles.c hRg;
  private final ArrayList<Bitmap> hRh;
  
  public ac(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208080);
    this.hOp = paramb;
    this.TAG = "MicroMsg.LiveLikeConfettiPlugin";
    this.hRf = ((FrameLayout)paramViewGroup.findViewById(2131303420));
    this.hRh = new ArrayList();
    AppMethodBeat.o(208080);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(208078);
    p.h(paramLiveConfig, "config");
    paramLiveConfig = com.tencent.mm.live.core.core.a.b.hyv;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    o.b localb;
    if (com.tencent.mm.live.core.core.a.b.a.aDp())
    {
      paramLiveConfig = this.hwr.getContext();
      p.g(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), 2131233355);
      localObject1 = o.b.hGo;
      i = o.b.aFl();
      localObject1 = o.b.hGo;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, o.b.aFl(), true);
      localObject1 = this.hwr.getContext();
      p.g(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131233356);
      localObject2 = o.b.hGo;
      i = o.b.aFl();
      localObject2 = o.b.hGo;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, o.b.aFl(), true);
      localObject2 = this.hwr.getContext();
      p.g(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), 2131233357);
      localObject3 = o.b.hGo;
      i = o.b.aFl();
      localObject3 = o.b.hGo;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, o.b.aFl(), true);
      localObject3 = this.hwr.getContext();
      p.g(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), 2131233358);
      localObject4 = o.b.hGo;
      i = o.b.aFl();
      localObject4 = o.b.hGo;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, o.b.aFl(), true);
      localObject4 = this.hwr.getContext();
      p.g(localObject4, "root.context");
      localObject4 = BitmapFactory.decodeResource(((Context)localObject4).getResources(), 2131233359);
      localObject5 = o.b.hGo;
      i = o.b.aFl();
      localObject5 = o.b.hGo;
      localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, o.b.aFl(), true);
      localObject5 = this.hwr.getContext();
      p.g(localObject5, "root.context");
      localObject5 = BitmapFactory.decodeResource(((Context)localObject5).getResources(), 2131233360);
      localb = o.b.hGo;
      i = o.b.aFl();
      localb = o.b.hGo;
      localObject5 = Bitmap.createScaledBitmap((Bitmap)localObject5, i, o.b.aFl(), true);
      this.hRh.add(paramLiveConfig);
      this.hRh.add(localObject1);
      this.hRh.add(localObject2);
      this.hRh.add(localObject3);
      this.hRh.add(localObject4);
      this.hRh.add(localObject5);
      AppMethodBeat.o(208078);
      return;
    }
    paramLiveConfig = com.tencent.mm.live.core.core.d.b.hCo;
    if (com.tencent.mm.live.core.core.d.b.a.aDp())
    {
      paramLiveConfig = this.hwr.getContext();
      p.g(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), 2131233355);
      localObject1 = o.b.hGo;
      i = o.b.aFl();
      localObject1 = o.b.hGo;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, o.b.aFl(), true);
      localObject1 = this.hwr.getContext();
      p.g(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131233356);
      localObject2 = o.b.hGo;
      i = o.b.aFl();
      localObject2 = o.b.hGo;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, o.b.aFl(), true);
      localObject2 = this.hwr.getContext();
      p.g(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), 2131233357);
      localObject3 = o.b.hGo;
      i = o.b.aFl();
      localObject3 = o.b.hGo;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, o.b.aFl(), true);
      localObject3 = this.hwr.getContext();
      p.g(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), 2131233358);
      localObject4 = o.b.hGo;
      i = o.b.aFl();
      localObject4 = o.b.hGo;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, o.b.aFl(), true);
      localObject4 = this.hwr.getContext();
      p.g(localObject4, "root.context");
      localObject4 = BitmapFactory.decodeResource(((Context)localObject4).getResources(), 2131233359);
      localObject5 = o.b.hGo;
      i = o.b.aFl();
      localObject5 = o.b.hGo;
      localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, o.b.aFl(), true);
      localObject5 = this.hwr.getContext();
      p.g(localObject5, "root.context");
      localObject5 = BitmapFactory.decodeResource(((Context)localObject5).getResources(), 2131233360);
      localb = o.b.hGo;
      i = o.b.aFl();
      localb = o.b.hGo;
      localObject5 = Bitmap.createScaledBitmap((Bitmap)localObject5, i, o.b.aFl(), true);
      this.hRh.add(paramLiveConfig);
      this.hRh.add(localObject1);
      this.hRh.add(localObject2);
      this.hRh.add(localObject3);
      this.hRh.add(localObject4);
      this.hRh.add(localObject5);
    }
    AppMethodBeat.o(208078);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int j = 100;
    AppMethodBeat.i(208079);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ad.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(208079);
      return;
    }
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");; i = 100)
    {
      if (paramBundle != null) {
        j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
      }
      Log.d(this.TAG, "emitLikeConfetti containerMiddleX=" + i + " containerMiddleY=" + j);
      paramc = new d(i, j);
      paramBundle = this.hRh.get(kotlin.j.c.SYP.nextInt(0, this.hRh.size()));
      p.g(paramBundle, "confettiBitmaps[Random.n…0, confettiBitmaps.size)]");
      paramBundle = (com.tencent.mm.particles.b)new a((Bitmap)paramBundle);
      this.hRg = new com.tencent.mm.particles.c(this.hwr.getContext(), paramBundle, paramc, (ViewGroup)this.hRf).ax(1.0F).bkF().H(-360.0F, 50.0F).AQ(1000L).bkD().bkJ();
      if (this.hOp.getLiveRole() != 0) {
        break;
      }
      f.aIS();
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
  static final class a
    implements com.tencent.mm.particles.b
  {
    a(Bitmap paramBitmap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.ac
 * JD-Core Version:    0.7.0.1
 */