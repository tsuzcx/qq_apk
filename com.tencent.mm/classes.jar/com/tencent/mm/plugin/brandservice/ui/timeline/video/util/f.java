package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "", "()V", "SPLITOR", "", "TAG", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "endPlayTime", "", "getEndPlayTime", "()I", "setEndPlayTime", "(I)V", "firstBuffering", "", "getFirstBuffering", "()Z", "setFirstBuffering", "(Z)V", "height", "getHeight", "setHeight", "isFans", "setFans", "playErrType", "getPlayErrType", "()Ljava/lang/String;", "setPlayErrType", "(Ljava/lang/String;)V", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "width", "getWidth", "setWidth", "doReport", "", "eventType", "bufferingTime", "getPlayType", "playStatus", "init", "reportBuffering", "timeCost", "plugin-brandservice_release"})
public final class f
{
  private final String TAG = "MicroMsg.MPDataReportHelper";
  public int height;
  private b jXn;
  private final String kig = ",";
  public int kih;
  public int kii;
  public int kij;
  public String kik = "";
  public boolean kil;
  public boolean kim = true;
  public int width;
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(152962);
    j.q(paramb, "controller");
    this.jXn = paramb;
    this.kim = true;
    this.kik = "";
    AppMethodBeat.o(152962);
  }
  
  public final void dN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155387);
    int j = com.tencent.mm.af.l.LZ();
    int i = j;
    if (j == 100) {
      i = -1;
    }
    if ((this.kih < 0) || (this.kih > 86400000L)) {
      this.kih = 0;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(this.kig);
    b localb = this.jXn;
    if (localb == null) {
      j.ays("controller");
    }
    ((StringBuilder)localObject).append(localb.HD());
    ((StringBuilder)localObject).append(this.kig);
    localb = this.jXn;
    if (localb == null) {
      j.ays("controller");
    }
    ((StringBuilder)localObject).append(localb.kfs);
    ((StringBuilder)localObject).append(this.kig);
    localb = this.jXn;
    if (localb == null) {
      j.ays("controller");
    }
    ((StringBuilder)localObject).append(localb.kft);
    ((StringBuilder)localObject).append(this.kig);
    localb = this.jXn;
    if (localb == null) {
      j.ays("controller");
    }
    ((StringBuilder)localObject).append(localb.kfx);
    ((StringBuilder)localObject).append(this.kig);
    localb = this.jXn;
    if (localb == null) {
      j.ays("controller");
    }
    ((StringBuilder)localObject).append(localb.kfv);
    ((StringBuilder)localObject).append(this.kig);
    localb = this.jXn;
    if (localb == null) {
      j.ays("controller");
    }
    ((StringBuilder)localObject).append(localb.fgl);
    ((StringBuilder)localObject).append(this.kig);
    localb = this.jXn;
    if (localb == null) {
      j.ays("controller");
    }
    ((StringBuilder)localObject).append(localb.aZd().fjN);
    ((StringBuilder)localObject).append(this.kig);
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(this.kig);
    ((StringBuilder)localObject).append((int)(System.currentTimeMillis() / 1000L));
    ((StringBuilder)localObject).append(this.kig);
    ((StringBuilder)localObject).append(this.kih);
    ((StringBuilder)localObject).append(this.kig);
    ((StringBuilder)localObject).append(this.kii);
    ((StringBuilder)localObject).append(this.kig);
    ((StringBuilder)localObject).append(this.kij);
    ((StringBuilder)localObject).append(this.kig);
    localb = this.jXn;
    if (localb == null) {
      j.ays("controller");
    }
    ((StringBuilder)localObject).append(localb.scene);
    ((StringBuilder)localObject).append(this.kig);
    localb = this.jXn;
    if (localb == null) {
      j.ays("controller");
    }
    ((StringBuilder)localObject).append(localb.kbN);
    ((StringBuilder)localObject).append(this.kig);
    ((StringBuilder)localObject).append(this.kik);
    ((StringBuilder)localObject).append(this.kig);
    if (this.kil) {}
    for (i = 1;; i = 0)
    {
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(this.kig);
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(this.kig);
      ((StringBuilder)localObject).append(this.height);
      ((StringBuilder)localObject).append(this.kig);
      ((StringBuilder)localObject).append(this.width);
      localObject = ((StringBuilder)localObject).toString();
      j.p(localObject, "sb.toString()");
      ab.d(this.TAG, "eventType: " + paramInt1 + " reportData: " + (String)localObject);
      h.qsU.kvStat(17149, (String)localObject);
      if (paramInt1 != 3) {
        break;
      }
      localObject = this.jXn;
      if (localObject == null) {
        j.ays("controller");
      }
      ((b)localObject).kfr.sL(0);
      AppMethodBeat.o(155387);
      return;
    }
    if (paramInt1 == 4)
    {
      localObject = this.jXn;
      if (localObject == null) {
        j.ays("controller");
      }
      ((b)localObject).kfr.sL(1);
      AppMethodBeat.o(155387);
      return;
    }
    if (paramInt1 == 10)
    {
      localObject = this.jXn;
      if (localObject == null) {
        j.ays("controller");
      }
      ((b)localObject).kfr.sL(2);
    }
    AppMethodBeat.o(155387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.f
 * JD-Core Version:    0.7.0.1
 */