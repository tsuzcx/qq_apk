package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.e;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.ui.b.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "mixInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "(Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;)V", "TAG", "", "mixCost", "", "getMixCost", "()J", "setMixCost", "(J)V", "getMixInfo", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "timeEnter", "getTimeEnter", "call", "", "handleResult", "success", "", "uniqueId", "plugin-emojicapture_release"})
public final class h
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final long eyh;
  long luG;
  final d luH;
  
  public h(d paramd)
  {
    AppMethodBeat.i(2680);
    this.luH = paramd;
    this.TAG = "MicroMsg.EmojiMixTask";
    this.eyh = this.luH.eyh;
    AppMethodBeat.o(2680);
  }
  
  public final String Oy()
  {
    AppMethodBeat.i(2679);
    long l = this.eyh;
    AppMethodBeat.o(2679);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    Object localObject2 = null;
    AppMethodBeat.i(2678);
    k localk = new k(this.luH.videoPath, this.luH.luv, this.luH.lup, this.luH.luw, this.luH.lux, this.luH.luy, this.luH.luz, this.luH.eyh);
    long l = bo.aoy();
    Object localObject1 = this.luH.luv.eVw.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.media.editor.a.b)((Iterator)localObject1).next()).init();
    }
    EmojiCaptureReporter.uB(37);
    Object localObject3 = (a.f.a.b)new h.a(this, l);
    localk.ewN = System.currentTimeMillis();
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.d.Zo(localk.videoPath);
    double d;
    label194:
    boolean bool1;
    label259:
    int i;
    if (locala != null)
    {
      localObject1 = Integer.valueOf(locala.eRw);
      if (!(localObject1 instanceof Integer)) {
        break label672;
      }
      d = 1000.0D / locala.eRw;
      localk.luX = ((a.f.a.b)localObject3);
      localObject1 = new StringBuilder("start decode ");
      localObject3 = Thread.currentThread();
      j.p(localObject3, "Thread.currentThread()");
      localObject3 = ((StringBuilder)localObject1).append(((Thread)localObject3).getId()).append(", fps: ");
      if (locala == null) {
        break label677;
      }
      localObject1 = Integer.valueOf(locala.eRw);
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", duration: ");
      localObject1 = localObject2;
      if (locala != null) {
        localObject1 = Integer.valueOf(locala.eVA);
      }
      ab.i("MicroMsg.EmojiMixer", localObject1 + ", videoFrameDuration: " + d + ", removeBackground:" + localk.lva + ", path: " + localk.videoPath);
      localk.frameCount = 0;
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.ltx;
      boolean bool2 = localk.lva;
      boolean bool3 = localk.luy;
      if (localk.luw <= 1) {
        break label683;
      }
      bool1 = true;
      label384:
      if (locala == null) {
        break label689;
      }
      i = locala.eVA;
      label395:
      com.tencent.mm.plugin.emojicapture.model.d.a(bool2, bool3, bool1, i);
      if (!localk.luz) {
        break label694;
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.ltx;
      com.tencent.mm.plugin.emojicapture.model.d.boh();
    }
    for (;;)
    {
      localk.luV = ((e)new b(localk.videoPath, (com.tencent.mm.media.f.d)localk.luZ, localk.luw));
      if (!bo.isNullOrNil(localk.hAr))
      {
        localObject1 = localk.hAr;
        localObject2 = com.tencent.mm.plugin.emojicapture.model.c.ltu;
        i = com.tencent.mm.plugin.emojicapture.model.c.bnQ();
        localObject2 = com.tencent.mm.plugin.emojicapture.model.c.ltu;
        int j = com.tencent.mm.plugin.emojicapture.model.c.bnQ();
        localObject2 = localk.luV;
        if (localObject2 == null) {
          j.ays("syncMgr");
        }
        localk.luW = new c((String)localObject1, i, j, ((e)localObject2).eVK, localk.luz);
      }
      localObject1 = com.tencent.mm.plugin.emojicapture.model.c.ltu;
      i = com.tencent.mm.plugin.emojicapture.model.c.bnQ();
      localObject1 = com.tencent.mm.plugin.emojicapture.model.c.ltu;
      localk.luU = new com.tencent.mm.plugin.emojicapture.ui.b.d(i, com.tencent.mm.plugin.emojicapture.model.c.bnQ());
      localObject1 = localk.luU;
      if (localObject1 == null) {
        j.ays("mixPixelBuffer");
      }
      ((com.tencent.mm.plugin.emojicapture.ui.b.d)localObject1).lAS = ((a.f.a.a)new k.d(localk));
      localObject1 = localk.luU;
      if (localObject1 == null) {
        j.ays("mixPixelBuffer");
      }
      localObject2 = (a.f.a.a)new k.e(localk, locala);
      ((com.tencent.mm.plugin.emojicapture.ui.b.d)localObject1).lAQ.post((Runnable)new d.b((com.tencent.mm.plugin.emojicapture.ui.b.d)localObject1, (a.f.a.a)localObject2));
      AppMethodBeat.o(2678);
      return;
      localObject1 = null;
      break;
      label672:
      d = 0.0D;
      break label194;
      label677:
      localObject1 = null;
      break label259;
      label683:
      bool1 = false;
      break label384;
      label689:
      i = 0;
      break label395;
      label694:
      localObject1 = com.tencent.mm.plugin.emojicapture.model.d.ltx;
      com.tencent.mm.plugin.emojicapture.model.d.bog();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.h
 * JD-Core Version:    0.7.0.1
 */