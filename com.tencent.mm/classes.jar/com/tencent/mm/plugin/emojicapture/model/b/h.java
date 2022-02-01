package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.ui.b.c.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "mixInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "(Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;)V", "TAG", "", "mixCost", "", "getMixCost", "()J", "setMixCost", "(J)V", "getMixInfo", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "timeEnter", "getTimeEnter", "call", "", "handleResult", "success", "", "uniqueId", "plugin-emojicapture_release"})
public final class h
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final long gsp;
  long pYY;
  final d pYZ;
  
  public h(d paramd)
  {
    AppMethodBeat.i(280);
    this.pYZ = paramd;
    this.TAG = "MicroMsg.EmojiMixTask";
    this.gsp = this.pYZ.gsp;
    AppMethodBeat.o(280);
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(279);
    long l = this.gsp;
    AppMethodBeat.o(279);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    Object localObject2 = null;
    boolean bool3 = true;
    AppMethodBeat.i(278);
    k localk = new k(this.pYZ.videoPath, this.pYZ.pYM, this.pYZ.pYH, this.pYZ.pYN, this.pYZ.pYO, this.pYZ.pYP, this.pYZ.pYQ, this.pYZ.gsp);
    final long l = bu.fpO();
    Object localObject1 = this.pYZ.pYM.pYz.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)((Iterator)localObject1).next()).init();
    }
    EmojiCaptureReporter.Cx(37);
    Object localObject3 = (d.g.a.b)new a(this, l);
    localk.gmN = System.currentTimeMillis();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.ayN(localk.videoPath);
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
      localk.pZp = ((d.g.a.b)localObject3);
      localObject1 = new StringBuilder("start decode ");
      localObject3 = Thread.currentThread();
      p.g(localObject3, "Thread.currentThread()");
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
      ae.i("MicroMsg.EmojiMixer", localObject1 + ", videoFrameDuration: " + d + ", removeBackground:" + localk.pZs + ", path: " + localk.videoPath);
      localk.frameCount = 0;
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.pXD;
      boolean bool4 = localk.pZs;
      if (localk.pYP == null) {
        break label722;
      }
      bool1 = true;
      if (localk.pYN <= 1) {
        break label728;
      }
      bool2 = true;
      if (locala == null) {
        break label734;
      }
      i = locala.videoDuration;
      com.tencent.mm.plugin.emojicapture.model.e.b(bool4, bool1, bool2, i);
      if (!localk.pYQ) {
        break label739;
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.pXD;
      com.tencent.mm.plugin.emojicapture.model.e.cla();
      localk.pZn = ((g)new b(localk.videoPath, (com.tencent.mm.plugin.recordvideo.ui.editor.b.b)localk.pZr, localk.pYN));
      if (!bu.isNullOrNil(localk.kxX))
      {
        localObject1 = localk.kxX;
        localObject2 = com.tencent.mm.plugin.emojicapture.model.d.pXB;
        i = com.tencent.mm.plugin.emojicapture.model.d.ckG();
        localObject2 = com.tencent.mm.plugin.emojicapture.model.d.pXB;
        j = com.tencent.mm.plugin.emojicapture.model.d.ckG();
        localObject2 = localk.pZn;
        if (localObject2 == null) {
          p.bdF("syncMgr");
        }
        localk.pZo = new c((String)localObject1, i, j, ((g)localObject2).ycW, localk.pYQ);
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.pXB;
      i = com.tencent.mm.plugin.emojicapture.model.d.ckG();
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.pXB;
      j = com.tencent.mm.plugin.emojicapture.model.d.ckG();
      if (localk.pYQ) {
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
      localk.pZm = new com.tencent.mm.plugin.emojicapture.ui.b.c(i, j, bool1, localk.pYP);
      localObject1 = localk.pZm;
      if (localObject1 == null) {
        p.bdF("mixPixelBuffer");
      }
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).qff = ((d.g.a.a)new k.d(localk));
      localObject1 = localk.pZm;
      if (localObject1 == null) {
        p.bdF("mixPixelBuffer");
      }
      bool1 = localk.pZs;
      localObject2 = (d.g.a.a)new k.e(localk, locala);
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).qfd.post((Runnable)new c.b((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1, bool1, (d.g.a.a)localObject2));
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
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.pXD;
      com.tencent.mm.plugin.emojicapture.model.e.ckZ();
      break label428;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Boolean, z>
  {
    a(h paramh, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.h
 * JD-Core Version:    0.7.0.1
 */