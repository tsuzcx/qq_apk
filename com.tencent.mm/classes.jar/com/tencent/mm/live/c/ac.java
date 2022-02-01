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
import d.g.b.k;
import d.j.c.b;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "emitLikeConfetti", "", "x", "", "y", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ac
  extends a
{
  private final String TAG;
  private final FrameLayout gBQ;
  private com.tencent.mm.particles.c gBR;
  private final ArrayList<Bitmap> gBS;
  private final b gzb;
  
  public ac(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190208);
    this.gzb = paramb;
    this.TAG = "MicroMsg.LiveLikeConfettiPlugin";
    this.gBQ = ((FrameLayout)paramViewGroup.findViewById(2131307648));
    this.gBS = new ArrayList();
    AppMethodBeat.o(190208);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(190206);
    k.h(paramLiveConfig, "config");
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramLiveConfig.aii() == LiveConfig.gmI)
    {
      paramLiveConfig = this.gnb.getContext();
      k.g(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), 2131234916);
      localObject1 = f.b.gtm;
      i = f.b.akk();
      localObject1 = f.b.gtm;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, f.b.akk(), true);
      localObject1 = this.gnb.getContext();
      k.g(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234918);
      localObject2 = f.b.gtm;
      i = f.b.akk();
      localObject2 = f.b.gtm;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, f.b.akk(), true);
      localObject2 = this.gnb.getContext();
      k.g(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), 2131234917);
      localObject3 = f.b.gtm;
      i = f.b.akk();
      localObject3 = f.b.gtm;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, f.b.akk(), true);
      localObject3 = this.gnb.getContext();
      k.g(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), 2131234919);
      localObject4 = f.b.gtm;
      i = f.b.akk();
      localObject4 = f.b.gtm;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, f.b.akk(), true);
      localObject4 = this.gnb.getContext();
      k.g(localObject4, "root.context");
      localObject4 = BitmapFactory.decodeResource(((Context)localObject4).getResources(), 2131234920);
      f.b localb = f.b.gtm;
      i = f.b.akk();
      localb = f.b.gtm;
      localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, f.b.akk(), true);
      this.gBS.add(paramLiveConfig);
      this.gBS.add(localObject1);
      this.gBS.add(localObject2);
      this.gBS.add(localObject3);
      this.gBS.add(localObject4);
      AppMethodBeat.o(190206);
      return;
    }
    if (paramLiveConfig.aii() == LiveConfig.gmJ)
    {
      paramLiveConfig = this.gnb.getContext();
      k.g(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), 2131234916);
      localObject1 = f.b.gtm;
      i = f.b.akk();
      localObject1 = f.b.gtm;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, f.b.akk(), true);
      localObject1 = this.gnb.getContext();
      k.g(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234918);
      localObject2 = f.b.gtm;
      i = f.b.akk();
      localObject2 = f.b.gtm;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, f.b.akk(), true);
      localObject2 = this.gnb.getContext();
      k.g(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), 2131234919);
      localObject3 = f.b.gtm;
      i = f.b.akk();
      localObject3 = f.b.gtm;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, f.b.akk(), true);
      localObject3 = this.gnb.getContext();
      k.g(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), 2131234920);
      localObject4 = f.b.gtm;
      i = f.b.akk();
      localObject4 = f.b.gtm;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, f.b.akk(), true);
      this.gBS.add(paramLiveConfig);
      this.gBS.add(localObject1);
      this.gBS.add(localObject2);
      this.gBS.add(localObject3);
    }
    AppMethodBeat.o(190206);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int j = 100;
    AppMethodBeat.i(190207);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ad.cfA[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(190207);
      return;
    }
    paramc = g.guG;
    g.nb(g.alh() + 1);
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");; i = 100)
    {
      if (paramBundle != null) {
        j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
      }
      com.tencent.mm.sdk.platformtools.ac.d(this.TAG, "emitLikeConfetti containerMiddleX=" + i + " containerMiddleY=" + j);
      paramc = new d(i, j);
      paramBundle = this.gBS.get(d.j.c.KUY.nextInt(0, this.gBS.size()));
      k.g(paramBundle, "confettiBitmaps[Random.n…0, confettiBitmaps.size)]");
      paramBundle = (com.tencent.mm.particles.b)new a((Bitmap)paramBundle);
      this.gBR = new com.tencent.mm.particles.c(this.gnb.getContext(), paramBundle, paramc, (ViewGroup)this.gBQ).al(1.0F).B(0.0F, 100.0F).C(-280.0F, 50.0F).qy(3000L).aMp().aMu();
      if (this.gzb.getLiveRole() != 0) {
        break;
      }
      f.ant();
      break;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
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