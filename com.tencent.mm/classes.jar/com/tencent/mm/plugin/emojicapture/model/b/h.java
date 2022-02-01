package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.emojicapture.ui.b.c.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "mixInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "(Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;)V", "TAG", "", "mixCost", "", "getMixCost", "()J", "setMixCost", "(J)V", "getMixInfo", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "timeEnter", "getTimeEnter", "call", "", "handleResult", "success", "", "uniqueId", "plugin-emojicapture_release"})
public final class h
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final long jPf;
  long uVB;
  final d uVC;
  
  public h(d paramd)
  {
    AppMethodBeat.i(280);
    this.uVC = paramd;
    this.TAG = "MicroMsg.EmojiMixTask";
    this.jPf = this.uVC.jPf;
    AppMethodBeat.o(280);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(279);
    long l = this.jPf;
    AppMethodBeat.o(279);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    Object localObject2 = null;
    boolean bool3 = true;
    AppMethodBeat.i(278);
    k localk = new k(this.uVC.videoPath, this.uVC.uVp, this.uVC.uVk, this.uVC.uVq, this.uVC.uVr, this.uVC.uVs, this.uVC.uVt, this.uVC.jPf);
    final long l = Util.nowMilliSecond();
    Object localObject1 = this.uVC.uVp.uVd.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)((Iterator)localObject1).next()).init();
    }
    EmojiCaptureReporter.JP(37);
    Object localObject3 = (kotlin.g.a.b)new a(this, l);
    localk.jID = System.currentTimeMillis();
    com.tencent.mm.plugin.sight.base.b localb = f.aYg(localk.videoPath);
    double d;
    label197:
    label379:
    boolean bool2;
    label262:
    label391:
    int i;
    label402:
    label428:
    int j;
    if (localb != null)
    {
      localObject1 = Integer.valueOf(localb.frameRate);
      if (!(localObject1 instanceof Integer)) {
        break label711;
      }
      d = 1000.0D / localb.frameRate;
      localk.uVS = ((kotlin.g.a.b)localObject3);
      localObject1 = new StringBuilder("start decode ");
      localObject3 = Thread.currentThread();
      p.j(localObject3, "Thread.currentThread()");
      localObject3 = ((StringBuilder)localObject1).append(((Thread)localObject3).getId()).append(", fps: ");
      if (localb == null) {
        break label716;
      }
      localObject1 = Integer.valueOf(localb.frameRate);
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", duration: ");
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = Integer.valueOf(localb.videoDuration);
      }
      Log.i("MicroMsg.EmojiMixer", localObject1 + ", videoFrameDuration: " + d + ", removeBackground:" + localk.uVV + ", path: " + localk.videoPath);
      localk.frameCount = 0;
      localObject1 = e.uUh;
      boolean bool4 = localk.uVV;
      if (localk.uVs == null) {
        break label722;
      }
      bool1 = true;
      if (localk.uVq <= 1) {
        break label728;
      }
      bool2 = true;
      if (localb == null) {
        break label734;
      }
      i = localb.videoDuration;
      e.b(bool4, bool1, bool2, i);
      if (!localk.uVt) {
        break label739;
      }
      localObject1 = e.uUh;
      e.cXL();
      localk.uVQ = ((g)new b(localk.videoPath, (com.tencent.mm.plugin.recordvideo.ui.editor.b.b)localk.uVU, localk.uVq));
      if (!Util.isNullOrNil(localk.oxJ))
      {
        localObject1 = localk.oxJ;
        localObject2 = com.tencent.mm.plugin.emojicapture.model.d.uUg;
        i = com.tencent.mm.plugin.emojicapture.model.d.cXr();
        localObject2 = com.tencent.mm.plugin.emojicapture.model.d.uUg;
        j = com.tencent.mm.plugin.emojicapture.model.d.cXr();
        localObject2 = localk.uVQ;
        if (localObject2 == null) {
          p.bGy("syncMgr");
        }
        localk.uVR = new c((String)localObject1, i, j, ((g)localObject2).Iao, localk.uVt);
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.uUg;
      i = com.tencent.mm.plugin.emojicapture.model.d.cXr();
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.uUg;
      j = com.tencent.mm.plugin.emojicapture.model.d.cXr();
      if (localk.uVt) {
        break label750;
      }
    }
    label711:
    label716:
    label722:
    label728:
    label734:
    label739:
    label750:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      localk.uVP = new com.tencent.mm.plugin.emojicapture.ui.b.c(i, j, bool1, localk.uVs);
      localObject1 = localk.uVP;
      if (localObject1 == null) {
        p.bGy("mixPixelBuffer");
      }
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).vbH = ((kotlin.g.a.a)new k.d(localk));
      localObject1 = localk.uVP;
      if (localObject1 == null) {
        p.bGy("mixPixelBuffer");
      }
      bool1 = localk.uVV;
      localObject2 = (kotlin.g.a.a)new k.e(localk, localb);
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).vbF.post((Runnable)new c.b((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1, bool1, (kotlin.g.a.a)localObject2));
      AppMethodBeat.o(278);
      return;
      localObject1 = null;
      break;
      d = 0.0D;
      break label197;
      localObject1 = null;
      break label262;
      bool1 = false;
      break label379;
      bool2 = false;
      break label391;
      i = 0;
      break label402;
      localObject1 = e.uUh;
      e.cXK();
      break label428;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    a(h paramh, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.h
 * JD-Core Version:    0.7.0.1
 */