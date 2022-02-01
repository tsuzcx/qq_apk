package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "mixInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "(Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;)V", "TAG", "", "mixCost", "", "getMixCost", "()J", "setMixCost", "(J)V", "getMixInfo", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "timeEnter", "getTimeEnter", "call", "", "handleResult", "success", "", "uniqueId", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.loader.f.c
{
  final String TAG;
  final long mnX;
  final d yid;
  long yie;
  
  public g(d paramd)
  {
    AppMethodBeat.i(280);
    this.yid = paramd;
    this.TAG = "MicroMsg.EmojiMixTask";
    this.mnX = this.yid.mnX;
    AppMethodBeat.o(280);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(279);
    long l = this.mnX;
    AppMethodBeat.o(279);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    boolean bool3 = true;
    Object localObject2 = null;
    AppMethodBeat.i(278);
    j localj = new j(this.yid.videoPath, this.yid.yhR, this.yid.outputPath, this.yid.yhS, this.yid.yhT, this.yid.yhU, this.yid.yhV, this.yid.mnX);
    final long l = Util.nowMilliSecond();
    Object localObject1 = this.yid.yhR.yhJ.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)((Iterator)localObject1).next()).init();
    }
    EmojiCaptureReporter.KN(37);
    Object localObject3 = (kotlin.g.a.b)new a(this, l);
    localj.moe = System.currentTimeMillis();
    com.tencent.mm.plugin.sight.base.b localb = com.tencent.mm.plugin.sight.base.f.aVX(localj.videoPath);
    double d;
    label187:
    label229:
    label252:
    boolean bool1;
    label335:
    boolean bool2;
    label347:
    int i;
    if (localb == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label660;
      }
      d = 1000.0D / localb.frameRate;
      localj.yix = ((kotlin.g.a.b)localObject3);
      localObject3 = new StringBuilder("start decode ").append(Thread.currentThread().getId()).append(", fps: ");
      if (localb != null) {
        break label665;
      }
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", duration: ");
      if (localb != null) {
        break label678;
      }
      localObject1 = null;
      Log.i("MicroMsg.EmojiMixer", localObject1 + ", videoFrameDuration: " + d + ", removeBackground:" + localj.yis + ", path: " + localj.videoPath);
      localj.frameCount = 0;
      localObject1 = e.ygT;
      boolean bool4 = localj.yis;
      if (localj.yhU == null) {
        break label691;
      }
      bool1 = true;
      if (localj.yhS <= 1) {
        break label697;
      }
      bool2 = true;
      if (localb != null) {
        break label703;
      }
      i = 0;
      label354:
      e.b(bool4, bool1, bool2, i);
      if (!localj.yhV) {
        break label712;
      }
      localObject1 = e.ygT;
      e.dEb();
      label380:
      localj.yiv = ((com.tencent.mm.plugin.recordvideo.ui.editor.f)new b(localj.videoPath, (com.tencent.mm.plugin.recordvideo.ui.editor.b.b)localj.yir, localj.yhS));
      if (!Util.isNullOrNil(localj.rBi))
      {
        String str = localj.rBi;
        localObject1 = com.tencent.mm.plugin.emojicapture.model.d.ygM;
        i = com.tencent.mm.plugin.emojicapture.model.d.dDH();
        localObject1 = com.tencent.mm.plugin.emojicapture.model.d.ygM;
        j = com.tencent.mm.plugin.emojicapture.model.d.dDH();
        localObject3 = localj.yiv;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("syncMgr");
          localObject1 = null;
        }
        localj.yiw = new c(str, i, j, ((com.tencent.mm.plugin.recordvideo.ui.editor.f)localObject1).NWR, localj.yhV);
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.ygM;
      i = com.tencent.mm.plugin.emojicapture.model.d.dDH();
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.ygM;
      int j = com.tencent.mm.plugin.emojicapture.model.d.dDH();
      if (localj.yhV) {
        break label723;
      }
      bool1 = bool3;
      label534:
      localj.yiu = new com.tencent.mm.plugin.emojicapture.ui.b.c(i, j, bool1, localj.yhU);
      localObject1 = localj.yiu;
      if (localObject1 != null) {
        break label729;
      }
      s.bIx("mixPixelBuffer");
      localObject1 = null;
      label577:
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).ynD = ((kotlin.g.a.a)new j.d(localj));
      localObject1 = localj.yiu;
      if (localObject1 != null) {
        break label732;
      }
      s.bIx("mixPixelBuffer");
      localObject1 = localObject2;
    }
    label660:
    label665:
    label678:
    label691:
    label697:
    label703:
    label712:
    label723:
    label729:
    label732:
    for (;;)
    {
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).b(localj.yis, (kotlin.g.a.a)new j.e(localj, localb));
      AppMethodBeat.o(278);
      return;
      localObject1 = Integer.valueOf(localb.frameRate);
      break;
      d = 0.0D;
      break label187;
      localObject1 = Integer.valueOf(localb.frameRate);
      break label229;
      localObject1 = Integer.valueOf(localb.videoDuration);
      break label252;
      bool1 = false;
      break label335;
      bool2 = false;
      break label347;
      i = localb.videoDuration;
      break label354;
      localObject1 = e.ygT;
      e.dEa();
      break label380;
      bool1 = false;
      break label534;
      break label577;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    a(g paramg, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.g
 * JD-Core Version:    0.7.0.1
 */