package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.ui.b.c.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "mixInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "(Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;)V", "TAG", "", "mixCost", "", "getMixCost", "()J", "setMixCost", "(J)V", "getMixInfo", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "timeEnter", "getTimeEnter", "call", "", "handleResult", "success", "", "uniqueId", "plugin-emojicapture_release"})
public final class h
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final long hdz;
  long rpV;
  final d rpW;
  
  public h(d paramd)
  {
    AppMethodBeat.i(280);
    this.rpW = paramd;
    this.TAG = "MicroMsg.EmojiMixTask";
    this.hdz = this.rpW.hdz;
    AppMethodBeat.o(280);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(279);
    long l = this.hdz;
    AppMethodBeat.o(279);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    Object localObject2 = null;
    boolean bool3 = true;
    AppMethodBeat.i(278);
    k localk = new k(this.rpW.videoPath, this.rpW.rpJ, this.rpW.rpE, this.rpW.rpK, this.rpW.rpL, this.rpW.rpM, this.rpW.rpN, this.rpW.hdz);
    final long l = Util.nowMilliSecond();
    Object localObject1 = this.rpW.rpJ.rpx.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)((Iterator)localObject1).next()).init();
    }
    EmojiCaptureReporter.Gi(37);
    Object localObject3 = (kotlin.g.a.b)new a(this, l);
    localk.gXF = System.currentTimeMillis();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.aNx(localk.videoPath);
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
      localk.rqm = ((kotlin.g.a.b)localObject3);
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
      Log.i("MicroMsg.EmojiMixer", localObject1 + ", videoFrameDuration: " + d + ", removeBackground:" + localk.rqp + ", path: " + localk.videoPath);
      localk.frameCount = 0;
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.roB;
      boolean bool4 = localk.rqp;
      if (localk.rpM == null) {
        break label722;
      }
      bool1 = true;
      if (localk.rpK <= 1) {
        break label728;
      }
      bool2 = true;
      if (locala == null) {
        break label734;
      }
      i = locala.videoDuration;
      com.tencent.mm.plugin.emojicapture.model.e.b(bool4, bool1, bool2, i);
      if (!localk.rpN) {
        break label739;
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.roB;
      com.tencent.mm.plugin.emojicapture.model.e.cJc();
      localk.rqk = ((g)new b(localk.videoPath, (com.tencent.mm.plugin.recordvideo.ui.editor.b.b)localk.rqo, localk.rpK));
      if (!Util.isNullOrNil(localk.lCj))
      {
        localObject1 = localk.lCj;
        localObject2 = com.tencent.mm.plugin.emojicapture.model.d.roA;
        i = com.tencent.mm.plugin.emojicapture.model.d.cII();
        localObject2 = com.tencent.mm.plugin.emojicapture.model.d.roA;
        j = com.tencent.mm.plugin.emojicapture.model.d.cII();
        localObject2 = localk.rqk;
        if (localObject2 == null) {
          p.btv("syncMgr");
        }
        localk.rql = new c((String)localObject1, i, j, ((g)localObject2).CdY, localk.rpN);
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.roA;
      i = com.tencent.mm.plugin.emojicapture.model.d.cII();
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.roA;
      j = com.tencent.mm.plugin.emojicapture.model.d.cII();
      if (localk.rpN) {
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
      localk.rqj = new com.tencent.mm.plugin.emojicapture.ui.b.c(i, j, bool1, localk.rpM);
      localObject1 = localk.rqj;
      if (localObject1 == null) {
        p.btv("mixPixelBuffer");
      }
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).rwd = ((kotlin.g.a.a)new k.d(localk));
      localObject1 = localk.rqj;
      if (localObject1 == null) {
        p.btv("mixPixelBuffer");
      }
      bool1 = localk.rqp;
      localObject2 = (kotlin.g.a.a)new k.e(localk, locala);
      ((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1).rwb.post((Runnable)new c.b((com.tencent.mm.plugin.emojicapture.ui.b.c)localObject1, bool1, (kotlin.g.a.a)localObject2));
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
      localObject1 = com.tencent.mm.plugin.emojicapture.model.e.roB;
      com.tencent.mm.plugin.emojicapture.model.e.cJb();
      break label428;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.h
 * JD-Core Version:    0.7.0.1
 */