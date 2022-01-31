package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class l$6
  extends ak
{
  l$6(l paraml, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(76599);
    if (this.oJt.fdj == -1)
    {
      this.oJt.fdj = Process.myTid();
      ab.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(this.oJt.fdj) });
    }
    l locall;
    byte[] arrayOfByte;
    int k;
    int j;
    int i;
    if (paramMessage.what == 1)
    {
      this.oJt.fdd.bRk();
      locall = this.oJt;
      arrayOfByte = (byte[])paramMessage.obj;
      if (!locall.fdl) {
        break label149;
      }
      paramMessage = locall.fde;
      k = arrayOfByte.length;
      j = locall.fck;
      i = locall.fcl;
    }
    for (;;)
    {
      paramMessage.e(arrayOfByte, k, j, i);
      j.oJp.O(arrayOfByte);
      locall.fcw = true;
      AppMethodBeat.o(76599);
      return;
      label149:
      paramMessage = locall.fde;
      k = arrayOfByte.length;
      if ((locall.fcn == 0) || (locall.fcn == 180)) {}
      for (i = locall.fck;; i = locall.fcl)
      {
        if ((locall.fcn != 0) && (locall.fcn != 180)) {
          break label228;
        }
        m = locall.fcl;
        j = i;
        i = m;
        break;
      }
      label228:
      int m = locall.fck;
      j = i;
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l.6
 * JD-Core Version:    0.7.0.1
 */