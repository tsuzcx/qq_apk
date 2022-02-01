package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.f;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.ui.b.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.y;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "mixInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "(Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;)V", "TAG", "", "mixCost", "", "getMixCost", "()J", "setMixCost", "(J)V", "getMixInfo", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "timeEnter", "getTimeEnter", "call", "", "handleResult", "success", "", "uniqueId", "plugin-emojicapture_release"})
public final class h
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final long fWr;
  long poS;
  final d poT;
  
  public h(d paramd)
  {
    AppMethodBeat.i(280);
    this.poT = paramd;
    this.TAG = "MicroMsg.EmojiMixTask";
    this.fWr = this.poT.fWr;
    AppMethodBeat.o(280);
  }
  
  public final String acg()
  {
    AppMethodBeat.i(279);
    long l = this.fWr;
    AppMethodBeat.o(279);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    Object localObject2 = null;
    boolean bool3 = true;
    AppMethodBeat.i(278);
    k localk = new k(this.poT.videoPath, this.poT.poG, this.poT.poB, this.poT.poH, this.poT.poI, this.poT.poJ, this.poT.poK, this.poT.fWr);
    final long l = bs.eWj();
    Object localObject1 = this.poT.poG.gSw.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.media.editor.a.b)((Iterator)localObject1).next()).init();
    }
    EmojiCaptureReporter.BD(37);
    Object localObject3 = (d.g.a.b)new a(this, l);
    localk.fQT = System.currentTimeMillis();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.asx(localk.videoPath);
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
      localk.ppj = ((d.g.a.b)localObject3);
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
      ac.i("MicroMsg.EmojiMixer", localObject1 + ", videoFrameDuration: " + d + ", removeBackground:" + localk.ppm + ", path: " + localk.videoPath);
      localk.frameCount = 0;
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.pny;
      boolean bool4 = localk.ppm;
      if (localk.poJ == null) {
        break label722;
      }
      bool1 = true;
      if (localk.poH <= 1) {
        break label728;
      }
      bool2 = true;
      if (locala == null) {
        break label734;
      }
      i = locala.videoDuration;
      com.tencent.mm.plugin.emojicapture.model.e.b(bool4, bool1, bool2, i);
      if (!localk.poK) {
        break label739;
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.pny;
      com.tencent.mm.plugin.emojicapture.model.e.cfh();
      localk.pph = ((f)new b(localk.videoPath, (com.tencent.mm.media.g.d)localk.ppl, localk.poH));
      if (!bs.isNullOrNil(localk.kal))
      {
        localObject1 = localk.kal;
        localObject2 = com.tencent.mm.plugin.emojicapture.model.d.pnw;
        i = com.tencent.mm.plugin.emojicapture.model.d.ceN();
        localObject2 = com.tencent.mm.plugin.emojicapture.model.d.pnw;
        j = com.tencent.mm.plugin.emojicapture.model.d.ceN();
        localObject2 = localk.pph;
        if (localObject2 == null) {
          d.g.b.k.aVY("syncMgr");
        }
        localk.ppi = new c((String)localObject1, i, j, ((f)localObject2).gSJ, localk.poK);
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.pnw;
      i = com.tencent.mm.plugin.emojicapture.model.d.ceN();
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.pnw;
      j = com.tencent.mm.plugin.emojicapture.model.d.ceN();
      if (localk.poK) {
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
      localk.ppg = new com.tencent.mm.plugin.emojicapture.ui.b.c(i, j, bool1, localk.poJ);
      localObject1 = localk.ppg;
      if (localObject1 == null) {
        d.g.b.k.aVY("mixPixelBuffer");
      }
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).puV = ((d.g.a.a)new k.d(localk));
      localObject1 = localk.ppg;
      if (localObject1 == null) {
        d.g.b.k.aVY("mixPixelBuffer");
      }
      bool1 = localk.ppm;
      localObject2 = (d.g.a.a)new k.e(localk, locala);
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).puT.post((Runnable)new c.b((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1, bool1, (d.g.a.a)localObject2));
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
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.pny;
      com.tencent.mm.plugin.emojicapture.model.e.cfg();
      break label428;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.h
 * JD-Core Version:    0.7.0.1
 */