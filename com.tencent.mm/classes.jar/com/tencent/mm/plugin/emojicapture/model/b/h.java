package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.ui.b.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.y;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "mixInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "(Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;)V", "TAG", "", "mixCost", "", "getMixCost", "()J", "setMixCost", "(J)V", "getMixInfo", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "timeEnter", "getTimeEnter", "call", "", "handleResult", "success", "", "uniqueId", "plugin-emojicapture_release"})
public final class h
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final long fSw;
  long oLy;
  final d oLz;
  
  public h(d paramd)
  {
    AppMethodBeat.i(280);
    this.oLz = paramd;
    this.TAG = "MicroMsg.EmojiMixTask";
    this.fSw = this.oLz.fSw;
    AppMethodBeat.o(280);
  }
  
  public final String abi()
  {
    AppMethodBeat.i(279);
    long l = this.fSw;
    AppMethodBeat.o(279);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    Object localObject2 = null;
    boolean bool3 = true;
    AppMethodBeat.i(278);
    k localk = new k(this.oLz.videoPath, this.oLz.oLm, this.oLz.oLh, this.oLz.oLn, this.oLz.oLo, this.oLz.oLp, this.oLz.oLq, this.oLz.fSw);
    final long l = bt.eGO();
    Object localObject1 = this.oLz.oLm.grO.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.media.editor.a.b)((Iterator)localObject1).next()).init();
    }
    EmojiCaptureReporter.AL(37);
    Object localObject3 = (d.g.a.b)new a(this, l);
    localk.fNi = System.currentTimeMillis();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.ano(localk.videoPath);
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
    if (locala != null)
    {
      localObject1 = Integer.valueOf(locala.frameRate);
      if (!(localObject1 instanceof Integer)) {
        break label711;
      }
      d = 1000.0D / locala.frameRate;
      localk.oLP = ((d.g.a.b)localObject3);
      localObject1 = new StringBuilder("start decode ");
      localObject3 = Thread.currentThread();
      d.g.b.k.g(localObject3, "Thread.currentThread()");
      localObject3 = ((StringBuilder)localObject1).append(((Thread)localObject3).getId()).append(", fps: ");
      if (locala == null) {
        break label716;
      }
      localObject1 = Integer.valueOf(locala.frameRate);
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", duration: ");
      localObject1 = localObject2;
      if (locala != null) {
        localObject1 = Integer.valueOf(locala.videoDuration);
      }
      ad.i("MicroMsg.EmojiMixer", localObject1 + ", videoFrameDuration: " + d + ", removeBackground:" + localk.oLS + ", path: " + localk.videoPath);
      localk.frameCount = 0;
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.oKa;
      boolean bool4 = localk.oLS;
      if (localk.oLp == null) {
        break label722;
      }
      bool1 = true;
      if (localk.oLn <= 1) {
        break label728;
      }
      bool2 = true;
      if (locala == null) {
        break label734;
      }
      i = locala.videoDuration;
      com.tencent.mm.plugin.emojicapture.model.e.b(bool4, bool1, bool2, i);
      if (!localk.oLq) {
        break label739;
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.oKa;
      com.tencent.mm.plugin.emojicapture.model.e.bXU();
      localk.oLN = ((com.tencent.mm.media.g.e)new b(localk.videoPath, (com.tencent.mm.media.g.d)localk.oLR, localk.oLn));
      if (!bt.isNullOrNil(localk.jzP))
      {
        localObject1 = localk.jzP;
        localObject2 = com.tencent.mm.plugin.emojicapture.model.d.oJY;
        i = com.tencent.mm.plugin.emojicapture.model.d.bXA();
        localObject2 = com.tencent.mm.plugin.emojicapture.model.d.oJY;
        j = com.tencent.mm.plugin.emojicapture.model.d.bXA();
        localObject2 = localk.oLN;
        if (localObject2 == null) {
          d.g.b.k.aPZ("syncMgr");
        }
        localk.oLO = new c((String)localObject1, i, j, ((com.tencent.mm.media.g.e)localObject2).gsb, localk.oLq);
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.oJY;
      i = com.tencent.mm.plugin.emojicapture.model.d.bXA();
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.oJY;
      j = com.tencent.mm.plugin.emojicapture.model.d.bXA();
      if (localk.oLq) {
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
      localk.oLM = new com.tencent.mm.plugin.emojicapture.ui.b.c(i, j, bool1, localk.oLp);
      localObject1 = localk.oLM;
      if (localObject1 == null) {
        d.g.b.k.aPZ("mixPixelBuffer");
      }
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).oRJ = ((d.g.a.a)new k.d(localk));
      localObject1 = localk.oLM;
      if (localObject1 == null) {
        d.g.b.k.aPZ("mixPixelBuffer");
      }
      bool1 = localk.oLS;
      localObject2 = (d.g.a.a)new k.e(localk, locala);
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).oRH.post((Runnable)new c.b((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1, bool1, (d.g.a.a)localObject2));
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
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.oKa;
      com.tencent.mm.plugin.emojicapture.model.e.bXT();
      break label428;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
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