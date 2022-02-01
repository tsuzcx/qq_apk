package com.tencent.mm.live.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e.b;
import com.tencent.mm.particles.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.j.c.b;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "emitLikeConfetti", "", "x", "", "y", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ac
  extends a
{
  private final b IIs;
  private final FrameLayout KvK;
  private final ArrayList<Bitmap> KvL;
  private final String TAG;
  private com.tencent.mm.particles.c hON;
  
  public ac(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202980);
    this.IIs = paramb;
    this.TAG = "MicroMsg.LiveLikeConfettiPlugin";
    this.KvK = ((FrameLayout)paramViewGroup.findViewById(2131307566));
    this.KvL = new ArrayList();
    AppMethodBeat.o(202980);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(202978);
    k.h(paramLiveConfig, "config");
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramLiveConfig.ckz() == LiveConfig.qsH)
    {
      paramLiveConfig = this.pTc.getContext();
      k.g(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), 2131234907);
      localObject1 = e.b.qYo;
      i = e.b.elZ();
      localObject1 = e.b.qYo;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, e.b.elZ(), true);
      localObject1 = this.pTc.getContext();
      k.g(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234909);
      localObject2 = e.b.qYo;
      i = e.b.elZ();
      localObject2 = e.b.qYo;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, e.b.elZ(), true);
      localObject2 = this.pTc.getContext();
      k.g(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), 2131234908);
      localObject3 = e.b.qYo;
      i = e.b.elZ();
      localObject3 = e.b.qYo;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, e.b.elZ(), true);
      localObject3 = this.pTc.getContext();
      k.g(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), 2131234910);
      localObject4 = e.b.qYo;
      i = e.b.elZ();
      localObject4 = e.b.qYo;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, e.b.elZ(), true);
      localObject4 = this.pTc.getContext();
      k.g(localObject4, "root.context");
      localObject4 = BitmapFactory.decodeResource(((Context)localObject4).getResources(), 2131234911);
      e.b localb = e.b.qYo;
      i = e.b.elZ();
      localb = e.b.qYo;
      localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, e.b.elZ(), true);
      this.KvL.add(paramLiveConfig);
      this.KvL.add(localObject1);
      this.KvL.add(localObject2);
      this.KvL.add(localObject3);
      this.KvL.add(localObject4);
      AppMethodBeat.o(202978);
      return;
    }
    if (paramLiveConfig.ckz() == LiveConfig.qsJ)
    {
      paramLiveConfig = this.pTc.getContext();
      k.g(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), 2131234907);
      localObject1 = e.b.qYo;
      i = e.b.elZ();
      localObject1 = e.b.qYo;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, e.b.elZ(), true);
      localObject1 = this.pTc.getContext();
      k.g(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234909);
      localObject2 = e.b.qYo;
      i = e.b.elZ();
      localObject2 = e.b.qYo;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, e.b.elZ(), true);
      localObject2 = this.pTc.getContext();
      k.g(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), 2131234910);
      localObject3 = e.b.qYo;
      i = e.b.elZ();
      localObject3 = e.b.qYo;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, e.b.elZ(), true);
      localObject3 = this.pTc.getContext();
      k.g(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), 2131234911);
      localObject4 = e.b.qYo;
      i = e.b.elZ();
      localObject4 = e.b.qYo;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, e.b.elZ(), true);
      this.KvL.add(paramLiveConfig);
      this.KvL.add(localObject1);
      this.KvL.add(localObject2);
      this.KvL.add(localObject3);
    }
    AppMethodBeat.o(202978);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int j = 100;
    AppMethodBeat.i(202979);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ad.ciE[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(202979);
      return;
    }
    paramc = com.tencent.mm.live.b.f.rGw;
    com.tencent.mm.live.b.f.agD(com.tencent.mm.live.b.f.fOr() + 1);
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");; i = 100)
    {
      if (paramBundle != null) {
        j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
      }
      ad.d(this.TAG, "emitLikeConfetti containerMiddleX=" + i + " containerMiddleY=" + j);
      paramc = new d(i, j);
      paramBundle = this.KvL.get(d.j.c.JhE.nextInt(0, this.KvL.size()));
      k.g(paramBundle, "confettiBitmaps[Random.n…0, confettiBitmaps.size)]");
      paramBundle = (com.tencent.mm.particles.b)new a((Bitmap)paramBundle);
      this.hON = new com.tencent.mm.particles.c(this.pTc.getContext(), paramBundle, paramc, (ViewGroup)this.KvK).ah(1.0F).y(0.0F, 100.0F).z(-280.0F, 50.0F).Bm(3000L).fQO().aFD();
      if (this.IIs.getLiveRole() != 0) {
        break;
      }
      com.tencent.mm.live.d.f.fQg();
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
  static final class a
    implements com.tencent.mm.particles.b
  {
    a(Bitmap paramBitmap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.ac
 * JD-Core Version:    0.7.0.1
 */