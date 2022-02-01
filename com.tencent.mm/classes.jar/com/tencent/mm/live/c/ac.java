package com.tencent.mm.live.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.f.b;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.d.f;
import com.tencent.mm.particles.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.j.c.b;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "emitLikeConfetti", "", "x", "", "y", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ac
  extends a
{
  private final String TAG;
  private final b gSM;
  private final FrameLayout gVA;
  private com.tencent.mm.particles.c gVB;
  private final ArrayList<Bitmap> gVC;
  
  public ac(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212498);
    this.gSM = paramb;
    this.TAG = "MicroMsg.LiveLikeConfettiPlugin";
    this.gVA = ((FrameLayout)paramViewGroup.findViewById(2131307648));
    this.gVC = new ArrayList();
    AppMethodBeat.o(212498);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(212496);
    p.h(paramLiveConfig, "config");
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramLiveConfig.akU() == LiveConfig.gGr)
    {
      paramLiveConfig = this.gGK.getContext();
      p.g(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), 2131234916);
      localObject1 = f.b.gMX;
      i = f.b.amW();
      localObject1 = f.b.gMX;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, f.b.amW(), true);
      localObject1 = this.gGK.getContext();
      p.g(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234918);
      localObject2 = f.b.gMX;
      i = f.b.amW();
      localObject2 = f.b.gMX;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, f.b.amW(), true);
      localObject2 = this.gGK.getContext();
      p.g(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), 2131234917);
      localObject3 = f.b.gMX;
      i = f.b.amW();
      localObject3 = f.b.gMX;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, f.b.amW(), true);
      localObject3 = this.gGK.getContext();
      p.g(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), 2131234919);
      localObject4 = f.b.gMX;
      i = f.b.amW();
      localObject4 = f.b.gMX;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, f.b.amW(), true);
      localObject4 = this.gGK.getContext();
      p.g(localObject4, "root.context");
      localObject4 = BitmapFactory.decodeResource(((Context)localObject4).getResources(), 2131234920);
      f.b localb = f.b.gMX;
      i = f.b.amW();
      localb = f.b.gMX;
      localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, f.b.amW(), true);
      this.gVC.add(paramLiveConfig);
      this.gVC.add(localObject1);
      this.gVC.add(localObject2);
      this.gVC.add(localObject3);
      this.gVC.add(localObject4);
      AppMethodBeat.o(212496);
      return;
    }
    if (paramLiveConfig.akU() == LiveConfig.gGs)
    {
      paramLiveConfig = this.gGK.getContext();
      p.g(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), 2131234916);
      localObject1 = f.b.gMX;
      i = f.b.amW();
      localObject1 = f.b.gMX;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, f.b.amW(), true);
      localObject1 = this.gGK.getContext();
      p.g(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234918);
      localObject2 = f.b.gMX;
      i = f.b.amW();
      localObject2 = f.b.gMX;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, f.b.amW(), true);
      localObject2 = this.gGK.getContext();
      p.g(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), 2131234919);
      localObject3 = f.b.gMX;
      i = f.b.amW();
      localObject3 = f.b.gMX;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, f.b.amW(), true);
      localObject3 = this.gGK.getContext();
      p.g(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), 2131234920);
      localObject4 = f.b.gMX;
      i = f.b.amW();
      localObject4 = f.b.gMX;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, f.b.amW(), true);
      this.gVC.add(paramLiveConfig);
      this.gVC.add(localObject1);
      this.gVC.add(localObject2);
      this.gVC.add(localObject3);
    }
    AppMethodBeat.o(212496);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int j = 100;
    AppMethodBeat.i(212497);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ad.cpQ[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(212497);
      return;
    }
    paramc = g.gOr;
    g.nA(g.anU() + 1);
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");; i = 100)
    {
      if (paramBundle != null) {
        j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
      }
      ad.d(this.TAG, "emitLikeConfetti containerMiddleX=" + i + " containerMiddleY=" + j);
      paramc = new d(i, j);
      paramBundle = this.gVC.get(d.j.c.MMe.nextInt(0, this.gVC.size()));
      p.g(paramBundle, "confettiBitmaps[Random.n…0, confettiBitmaps.size)]");
      paramBundle = (com.tencent.mm.particles.b)new a((Bitmap)paramBundle);
      this.gVB = new com.tencent.mm.particles.c(this.gGK.getContext(), paramBundle, paramc, (ViewGroup)this.gVA).ao(1.0F).C(0.0F, 100.0F).D(-280.0F, 50.0F).sx(3000L).aPC().aPH();
      if (this.gSM.getLiveRole() != 0) {
        break;
      }
      f.aqf();
      break;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
  static final class a
    implements com.tencent.mm.particles.b
  {
    a(Bitmap paramBitmap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ac
 * JD-Core Version:    0.7.0.1
 */