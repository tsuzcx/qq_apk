package com.tencent.mm.live.b;

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
import com.tencent.mm.live.c.f;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.f.d.a;
import com.tencent.mm.live.model.l.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Random;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j.c.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveLikeConfettiPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "confettiBitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "confettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "confettiRoot", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "emitLikeConfetti", "", "x", "", "y", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends a
{
  private final String TAG;
  private final b nfT;
  private final FrameLayout niD;
  private com.tencent.mm.particles.c niE;
  private final ArrayList<Bitmap> niF;
  
  public q(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247090);
    this.nfT = paramb;
    this.TAG = "MicroMsg.LiveLikeConfettiPlugin";
    this.niD = ((FrameLayout)paramViewGroup.findViewById(b.e.live_like_confetti_ui_root));
    this.niF = new ArrayList();
    AppMethodBeat.o(247090);
  }
  
  private static final com.tencent.mm.particles.a.b a(Bitmap paramBitmap, Random paramRandom)
  {
    AppMethodBeat.i(247099);
    s.u(paramBitmap, "$bitmap");
    paramBitmap = (com.tencent.mm.particles.a.b)new com.tencent.mm.live.view.b.a(paramBitmap);
    AppMethodBeat.o(247099);
    return paramBitmap;
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(247125);
    s.u(paramLiveConfig, "config");
    paramLiveConfig = com.tencent.mm.live.core.core.a.b.mMo;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    l.b localb;
    if (b.a.bek())
    {
      paramLiveConfig = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon1);
      localObject1 = l.b.mYf;
      i = l.b.bhn();
      localObject1 = l.b.mYf;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, l.b.bhn(), true);
      localObject1 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon2);
      localObject2 = l.b.mYf;
      i = l.b.bhn();
      localObject2 = l.b.mYf;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, l.b.bhn(), true);
      localObject2 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon3);
      localObject3 = l.b.mYf;
      i = l.b.bhn();
      localObject3 = l.b.mYf;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, l.b.bhn(), true);
      localObject3 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon4);
      localObject4 = l.b.mYf;
      i = l.b.bhn();
      localObject4 = l.b.mYf;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, l.b.bhn(), true);
      localObject4 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon5);
      localObject5 = l.b.mYf;
      i = l.b.bhn();
      localObject5 = l.b.mYf;
      localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, l.b.bhn(), true);
      localObject5 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon6);
      localb = l.b.mYf;
      i = l.b.bhn();
      localb = l.b.mYf;
      localObject5 = Bitmap.createScaledBitmap((Bitmap)localObject5, i, l.b.bhn(), true);
      this.niF.add(paramLiveConfig);
      this.niF.add(localObject1);
      this.niF.add(localObject2);
      this.niF.add(localObject3);
      this.niF.add(localObject4);
      this.niF.add(localObject5);
      AppMethodBeat.o(247125);
      return;
    }
    paramLiveConfig = com.tencent.mm.live.core.core.f.d.mUj;
    if (d.a.bek())
    {
      paramLiveConfig = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon1);
      localObject1 = l.b.mYf;
      i = l.b.bhn();
      localObject1 = l.b.mYf;
      paramLiveConfig = Bitmap.createScaledBitmap(paramLiveConfig, i, l.b.bhn(), true);
      localObject1 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon2);
      localObject2 = l.b.mYf;
      i = l.b.bhn();
      localObject2 = l.b.mYf;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, l.b.bhn(), true);
      localObject2 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon3);
      localObject3 = l.b.mYf;
      i = l.b.bhn();
      localObject3 = l.b.mYf;
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, l.b.bhn(), true);
      localObject3 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon4);
      localObject4 = l.b.mYf;
      i = l.b.bhn();
      localObject4 = l.b.mYf;
      localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, l.b.bhn(), true);
      localObject4 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon5);
      localObject5 = l.b.mYf;
      i = l.b.bhn();
      localObject5 = l.b.mYf;
      localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, l.b.bhn(), true);
      localObject5 = BitmapFactory.decodeResource(this.mJe.getContext().getResources(), b.d.live_like_icon6);
      localb = l.b.mYf;
      i = l.b.bhn();
      localb = l.b.mYf;
      localObject5 = Bitmap.createScaledBitmap((Bitmap)localObject5, i, l.b.bhn(), true);
      this.niF.add(paramLiveConfig);
      this.niF.add(localObject1);
      this.niF.add(localObject2);
      this.niF.add(localObject3);
      this.niF.add(localObject4);
      this.niF.add(localObject5);
    }
    AppMethodBeat.o(247125);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int j = 100;
    AppMethodBeat.i(247142);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    int i;
    if (a.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      if (paramBundle != null) {
        break label212;
      }
      i = 100;
      if (paramBundle != null) {
        break label223;
      }
    }
    for (;;)
    {
      Log.d(this.TAG, "emitLikeConfetti containerMiddleX=" + i + " containerMiddleY=" + j);
      paramc = new com.tencent.mm.particles.d(i, j);
      paramBundle = this.niF.get(kotlin.j.c.aixl.qq(0, this.niF.size()));
      s.s(paramBundle, "confettiBitmaps[Random.n…0, confettiBitmaps.size)]");
      paramBundle = new q..ExternalSyntheticLambda0((Bitmap)paramBundle);
      paramc = new com.tencent.mm.particles.c(this.mJe.getContext(), paramBundle, paramc, (ViewGroup)this.niD).bv(1.0F).an(0.0F, 0.0F).ao(-360.0F, 50.0F);
      paramc.pwJ = 1000L;
      paramc.pwj = 1;
      this.niE = paramc.bSI();
      if (this.nfT.getLiveRole() == 0) {
        f.bkD();
      }
      AppMethodBeat.o(247142);
      return;
      label212:
      i = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_X");
      break;
      label223:
      j = paramBundle.getInt("PARAM_LIVE_LIKE_CONFETTI_Y");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.q
 * JD-Core Version:    0.7.0.1
 */