package com.tencent.mm.live.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.l.b;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.live.core.core.c.c.a;
import com.tencent.mm.live.d.f;
import com.tencent.mm.particles.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.j.c.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "emitLikeConfetti", "", "x", "", "y", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ac
  extends a
{
  private final String TAG;
  private final b kCL;
  private final FrameLayout kFC;
  private com.tencent.mm.particles.c kFD;
  private final ArrayList<Bitmap> kFE;
  
  public ac(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(200927);
    this.kCL = paramb;
    this.TAG = "MicroMsg.LiveLikeConfettiPlugin";
    this.kFC = ((FrameLayout)paramViewGroup.findViewById(b.e.live_like_confetti_ui_root));
    this.kFE = new ArrayList();
    AppMethodBeat.o(200927);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(200909);
    p.k(paramLiveConfig, "config");
    paramLiveConfig = com.tencent.mm.live.core.core.a.b.klq;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    l.b localb;
    if (b.b.aLi())
    {
      paramLiveConfig = this.kiF.getContext();
      p.j(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), b.d.live_like_icon1);
      localObject1 = l.b.kum;
      i = l.b.aNC();
      localObject1 = l.b.kum;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, l.b.aNC(), true);
      localObject1 = this.kiF.getContext();
      p.j(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), b.d.live_like_icon2);
      localObject2 = l.b.kum;
      i = l.b.aNC();
      localObject2 = l.b.kum;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, l.b.aNC(), true);
      localObject2 = this.kiF.getContext();
      p.j(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), b.d.live_like_icon3);
      localObject3 = l.b.kum;
      i = l.b.aNC();
      localObject3 = l.b.kum;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, l.b.aNC(), true);
      localObject3 = this.kiF.getContext();
      p.j(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), b.d.live_like_icon4);
      localObject4 = l.b.kum;
      i = l.b.aNC();
      localObject4 = l.b.kum;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, l.b.aNC(), true);
      localObject4 = this.kiF.getContext();
      p.j(localObject4, "root.context");
      localObject4 = BitmapFactory.decodeResource(((Context)localObject4).getResources(), b.d.live_like_icon5);
      localObject5 = l.b.kum;
      i = l.b.aNC();
      localObject5 = l.b.kum;
      localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, l.b.aNC(), true);
      localObject5 = this.kiF.getContext();
      p.j(localObject5, "root.context");
      localObject5 = BitmapFactory.decodeResource(((Context)localObject5).getResources(), b.d.live_like_icon6);
      localb = l.b.kum;
      i = l.b.aNC();
      localb = l.b.kum;
      localObject5 = Bitmap.createScaledBitmap((Bitmap)localObject5, i, l.b.aNC(), true);
      this.kFE.add(paramLiveConfig);
      this.kFE.add(localObject1);
      this.kFE.add(localObject2);
      this.kFE.add(localObject3);
      this.kFE.add(localObject4);
      this.kFE.add(localObject5);
      AppMethodBeat.o(200909);
      return;
    }
    paramLiveConfig = com.tencent.mm.live.core.core.c.c.kqq;
    if (c.a.aLi())
    {
      paramLiveConfig = this.kiF.getContext();
      p.j(paramLiveConfig, "root.context");
      paramLiveConfig = BitmapFactory.decodeResource(paramLiveConfig.getResources(), b.d.live_like_icon1);
      localObject1 = l.b.kum;
      i = l.b.aNC();
      localObject1 = l.b.kum;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, l.b.aNC(), true);
      localObject1 = this.kiF.getContext();
      p.j(localObject1, "root.context");
      localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), b.d.live_like_icon2);
      localObject2 = l.b.kum;
      i = l.b.aNC();
      localObject2 = l.b.kum;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, l.b.aNC(), true);
      localObject2 = this.kiF.getContext();
      p.j(localObject2, "root.context");
      localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), b.d.live_like_icon3);
      localObject3 = l.b.kum;
      i = l.b.aNC();
      localObject3 = l.b.kum;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, l.b.aNC(), true);
      localObject3 = this.kiF.getContext();
      p.j(localObject3, "root.context");
      localObject3 = BitmapFactory.decodeResource(((Context)localObject3).getResources(), b.d.live_like_icon4);
      localObject4 = l.b.kum;
      i = l.b.aNC();
      localObject4 = l.b.kum;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, l.b.aNC(), true);
      localObject4 = this.kiF.getContext();
      p.j(localObject4, "root.context");
      localObject4 = BitmapFactory.decodeResource(((Context)localObject4).getResources(), b.d.live_like_icon5);
      localObject5 = l.b.kum;
      i = l.b.aNC();
      localObject5 = l.b.kum;
      localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, l.b.aNC(), true);
      localObject5 = this.kiF.getContext();
      p.j(localObject5, "root.context");
      localObject5 = BitmapFactory.decodeResource(((Context)localObject5).getResources(), b.d.live_like_icon6);
      localb = l.b.kum;
      i = l.b.aNC();
      localb = l.b.kum;
      localObject5 = Bitmap.createScaledBitmap((Bitmap)localObject5, i, l.b.aNC(), true);
      this.kFE.add(paramLiveConfig);
      this.kFE.add(localObject1);
      this.kFE.add(localObject2);
      this.kFE.add(localObject3);
      this.kFE.add(localObject4);
      this.kFE.add(localObject5);
    }
    AppMethodBeat.o(200909);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int j = 100;
    AppMethodBeat.i(200923);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ad.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(200923);
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
      paramBundle = this.kFE.get(kotlin.j.c.aaBL.os(0, this.kFE.size()));
      p.j(paramBundle, "confettiBitmaps[Random.n…0, confettiBitmaps.size)]");
      paramBundle = (com.tencent.mm.particles.b)new a((Bitmap)paramBundle);
      this.kFD = new com.tencent.mm.particles.c(this.kiF.getContext(), paramBundle, paramc, (ViewGroup)this.kFC).ax(1.0F).but().I(-360.0F, 50.0F).GZ(1000L).bur().bux();
      if (this.kCL.getLiveRole() != 0) {
        break;
      }
      f.aQQ();
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "it", "Ljava/util/Random;", "kotlin.jvm.PlatformType", "generateConfetti"})
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