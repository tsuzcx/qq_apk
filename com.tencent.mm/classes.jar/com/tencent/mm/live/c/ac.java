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
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.j.c.b;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "emitLikeConfetti", "", "x", "", "y", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ac
  extends a
{
  private final String TAG;
  private final b gVv;
  private final FrameLayout gYj;
  private com.tencent.mm.particles.c gYk;
  private final ArrayList<Bitmap> gYl;
  
  public ac(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216118);
    this.gVv = paramb;
    this.TAG = "MicroMsg.LiveLikeConfettiPlugin";
    this.gYj = ((FrameLayout)paramViewGroup.findViewById(2131307648));
    this.gYl = new ArrayList();
    AppMethodBeat.o(216118);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(216116);
    p.h(paramLiveConfig, "config");
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramLiveConfig.alj() == LiveConfig.gJa)
    {
      paramLiveConfig = this.gJt.getContext();
      p.g(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), 2131234916);
      localObject1 = f.b.gPG;
      i = f.b.anl();
      localObject1 = f.b.gPG;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, f.b.anl(), true);
      localObject1 = this.gJt.getContext();
      p.g(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234918);
      localObject2 = f.b.gPG;
      i = f.b.anl();
      localObject2 = f.b.gPG;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, f.b.anl(), true);
      localObject2 = this.gJt.getContext();
      p.g(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), 2131234917);
      localObject3 = f.b.gPG;
      i = f.b.anl();
      localObject3 = f.b.gPG;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, f.b.anl(), true);
      localObject3 = this.gJt.getContext();
      p.g(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), 2131234919);
      localObject4 = f.b.gPG;
      i = f.b.anl();
      localObject4 = f.b.gPG;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, f.b.anl(), true);
      localObject4 = this.gJt.getContext();
      p.g(localObject4, "root.context");
      localObject4 = BitmapFactory.decodeResource(((Context)localObject4).getResources(), 2131234920);
      f.b localb = f.b.gPG;
      i = f.b.anl();
      localb = f.b.gPG;
      localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, f.b.anl(), true);
      this.gYl.add(paramLiveConfig);
      this.gYl.add(localObject1);
      this.gYl.add(localObject2);
      this.gYl.add(localObject3);
      this.gYl.add(localObject4);
      AppMethodBeat.o(216116);
      return;
    }
    if (paramLiveConfig.alj() == LiveConfig.gJb)
    {
      paramLiveConfig = this.gJt.getContext();
      p.g(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), 2131234916);
      localObject1 = f.b.gPG;
      i = f.b.anl();
      localObject1 = f.b.gPG;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, f.b.anl(), true);
      localObject1 = this.gJt.getContext();
      p.g(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2131234918);
      localObject2 = f.b.gPG;
      i = f.b.anl();
      localObject2 = f.b.gPG;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, f.b.anl(), true);
      localObject2 = this.gJt.getContext();
      p.g(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), 2131234919);
      localObject3 = f.b.gPG;
      i = f.b.anl();
      localObject3 = f.b.gPG;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, f.b.anl(), true);
      localObject3 = this.gJt.getContext();
      p.g(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), 2131234920);
      localObject4 = f.b.gPG;
      i = f.b.anl();
      localObject4 = f.b.gPG;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, f.b.anl(), true);
      this.gYl.add(paramLiveConfig);
      this.gYl.add(localObject1);
      this.gYl.add(localObject2);
      this.gYl.add(localObject3);
    }
    AppMethodBeat.o(216116);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    int j = 100;
    AppMethodBeat.i(216117);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ad.cqt[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(216117);
      return;
    }
    paramc = g.gQZ;
    g.nD(g.aoj() + 1);
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");; i = 100)
    {
      if (paramBundle != null) {
        j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
      }
      ae.d(this.TAG, "emitLikeConfetti containerMiddleX=" + i + " containerMiddleY=" + j);
      paramc = new d(i, j);
      paramBundle = this.gYl.get(d.j.c.Njh.nextInt(0, this.gYl.size()));
      p.g(paramBundle, "confettiBitmaps[Random.n…0, confettiBitmaps.size)]");
      paramBundle = (com.tencent.mm.particles.b)new ac.a((Bitmap)paramBundle);
      this.gYk = new com.tencent.mm.particles.c(this.gJt.getContext(), paramBundle, paramc, (ViewGroup)this.gYj).ao(1.0F).C(0.0F, 100.0F).D(-280.0F, 50.0F).sK(3000L).aQb().aQg();
      if (this.gVv.getLiveRole() != 0) {
        break;
      }
      f.aqu();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.ac
 * JD-Core Version:    0.7.0.1
 */