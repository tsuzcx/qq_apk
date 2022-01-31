package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.mm.h.a.lq;
import com.tencent.mm.plugin.appbrand.media.record.a.c.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class g$5
  implements c.a
{
  g$5(g paramg) {}
  
  public final void c(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    Object localObject = this.gNX;
    y.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    lq locallq = new lq();
    locallq.bUI.state = "frameRecorded";
    if (((g)localObject).gNJ != null) {
      locallq.bUI.appId = ((g)localObject).gNJ.appId;
    }
    locallq.bUI.action = 5;
    localObject = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramInt);
    locallq.bUI.frameBuffer = ((byte[])localObject);
    locallq.bUI.bUJ = paramBoolean;
    a.udP.a(locallq, Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g.5
 * JD-Core Version:    0.7.0.1
 */