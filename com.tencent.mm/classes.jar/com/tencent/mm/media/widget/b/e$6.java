package com.tencent.mm.media.widget.b;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class e$6
  extends ak
{
  e$6(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(152049);
    if (this.fdq.fdj == -1)
    {
      this.fdq.fdj = Process.myTid();
      ab.i("MicroMsg.X264YUVMP4MuxRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(this.fdq.fdj) });
    }
    e locale;
    byte[] arrayOfByte;
    int k;
    int j;
    int i;
    if (paramMessage.what == 1)
    {
      this.fdq.fdd.bRk();
      locale = this.fdq;
      arrayOfByte = (byte[])paramMessage.obj;
      if (!locale.fdl) {
        break label149;
      }
      paramMessage = locale.fde;
      k = arrayOfByte.length;
      j = locale.fck;
      i = locale.fcl;
    }
    for (;;)
    {
      paramMessage.e(arrayOfByte, k, j, i);
      j.oJp.O(arrayOfByte);
      locale.fcw = true;
      AppMethodBeat.o(152049);
      return;
      label149:
      paramMessage = locale.fde;
      k = arrayOfByte.length;
      if ((locale.fcn == 90) || (locale.fcn == 270)) {}
      for (i = locale.fck;; i = locale.fcl)
      {
        if ((locale.fcn != 90) && (locale.fcn != 270)) {
          break label232;
        }
        m = locale.fcl;
        j = i;
        i = m;
        break;
      }
      label232:
      int m = locale.fck;
      j = i;
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e.6
 * JD-Core Version:    0.7.0.1
 */