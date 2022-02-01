package com.tencent.mm.media.widget.c;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

final class c$8
  implements h
{
  c$8(c paramc) {}
  
  public final String getKey()
  {
    return "MMSightMediaCodecMP4MuxRecorder_stop";
  }
  
  public final void run()
  {
    AppMethodBeat.i(93364);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stopImpl status:%s", new Object[] { this.gCX.gCs.tFa });
    if (this.gCX.gCs.tFa == d.c.tDR)
    {
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stopImp, already stop");
      if (this.gCX.gCl != null) {
        this.gCX.gCl.clear();
      }
      AppMethodBeat.o(93364);
      return;
    }
    boolean bool = c.f(this.gCX);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stopImpl result: %s", new Object[] { Boolean.valueOf(bool) });
    Object localObject;
    if (bool)
    {
      localObject = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.akZ();
      c.a(this.gCX, com.tencent.mm.plugin.mmsight.d.zg(this.gCX.gCg));
      if (this.gCX.gCB.hck == 2)
      {
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] steve:[hardcoder] hwenc qp add metadata flag, switch:%s", new Object[] { Integer.valueOf(this.gCX.gCB.hck) });
        localObject = this.gCX.gCg;
        int i = this.gCX.gCB.hck;
        SightVideoJNI.addReportMetadata((String)localObject, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 0, i);
      }
      try
      {
        localObject = e.ano(this.gCX.gCg);
        if (localObject != null)
        {
          com.tencent.mm.media.j.d locald2 = com.tencent.mm.media.j.d.gwr;
          com.tencent.mm.media.j.d.cW(((a)localObject).videoBitrate, ((a)localObject).frameRate);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] SightUtil.getMedia error !");
        }
      }
      if (this.gCX.gCG != null)
      {
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] call stopCallback");
        aq.f(this.gCX.gCG);
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.akX();
      AppMethodBeat.o(93364);
      return;
      com.tencent.mm.media.j.d locald1 = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.akY();
      SightVideoJNI.releaseBigSightDataBufferLock(this.gCX.gmW);
      if (this.gCX.gCF != null) {
        aq.f(new c.8.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c.8
 * JD-Core Version:    0.7.0.1
 */