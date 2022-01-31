package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wxmm.v2conference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimerTask;

final class r$1
  extends TimerTask
{
  r$1(r paramr) {}
  
  public final void run()
  {
    AppMethodBeat.i(156311);
    int k = 8;
    if (k > 0) {}
    for (;;)
    {
      int i;
      try
      {
        if (this.kMz.isStarted())
        {
          j = 0;
          int m = 0;
          i = (byte)(j + 1);
          if (j < 2)
          {
            this.kMz.frameData[0] = i;
            ??? = o.kKN;
            j = o.aA(this.kMz.frameData);
            int n = l.bhq().field_remoteImgLength;
            int i1 = l.bhq().field_remoteImgHeight;
            int i2 = l.bhq().field_remoteImgWidth;
            int i3 = l.bhq().field_remoteImgMember;
            ??? = this.kMz;
            int i4 = ((r)???).kMw + 1;
            ((r)???).kMw = i4;
            if (i4 % 100 == 0) {
              ab.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "GetVideo, mark:" + (i - 1) + " ret:" + j + ", len:" + this.kMz.frameData.length + ", rLen:" + n + ", rHeight:" + i1 + ", rWidth:" + i2 + ", rMid:" + i3 + ", drawCnt:" + this.kMz.kMx);
            }
            if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
              break label518;
            }
            a locala = new a();
            locala.kJv = this.kMz.frameData;
            locala.bWt = n;
            locala.width = i2;
            locala.height = i1;
            locala.kJw = i3;
            synchronized (this.kMz.kMy)
            {
              Object localObject3 = this.kMz.kMy.entrySet().iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break label513;
              }
              c localc = (c)((Map.Entry)((Iterator)localObject3).next()).getValue();
              if ((localc == null) || (localc.bhl()) || (localc.getMemberId() != locala.kJw)) {
                continue;
              }
              localc.a(locala);
              localObject3 = this.kMz;
              ((r)localObject3).kMx += 1;
              j = 1;
              if (j == 0) {
                ab.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "thread handler, mid:" + locala.kJw + " not found");
              }
              j = i;
              m = 1;
            }
          }
          if (m != 0) {
            break label506;
          }
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoMgr", localException, "timer task crash", new Object[0]);
        AppMethodBeat.o(156311);
        return;
      }
      AppMethodBeat.o(156311);
      return;
      label506:
      k -= 1;
      break;
      label513:
      int j = 0;
      continue;
      label518:
      j = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.r.1
 * JD-Core Version:    0.7.0.1
 */