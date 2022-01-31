package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.plugin.appbrand.media.record.a.d.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class g$7
  implements d.a
{
  g$7(g paramg) {}
  
  public final void d(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(141596);
    Object localObject = this.ipI;
    ab.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    mg localmg = new mg();
    localmg.cCp.state = "frameRecorded";
    if (((g)localObject).ipw != null) {
      localmg.cCp.appId = ((g)localObject).ipw.appId;
    }
    localmg.cCp.action = 5;
    localObject = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramInt);
    localmg.cCp.frameBuffer = ((byte[])localObject);
    localmg.cCp.cCq = paramBoolean;
    a.ymk.a(localmg, Looper.getMainLooper());
    AppMethodBeat.o(141596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g.7
 * JD-Core Version:    0.7.0.1
 */