package com.tencent.mm.plugin.collect.model.voice;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.cd.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

class F2fRcvVoiceOffLineLogic$1
  extends IListener<cd>
{
  F2fRcvVoiceOffLineLogic$1(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(293547);
    this.__eventId = cd.class.getName().hashCode();
    AppMethodBeat.o(293547);
  }
  
  private boolean a(cd paramcd)
  {
    AppMethodBeat.i(63858);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent callback");
    if (paramcd.hCg.hCh == 60) {}
    synchronized (a.a(this.wZB))
    {
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s md5:%s fileVersion:%s", new Object[] { Integer.valueOf(paramcd.hCg.hCh), Integer.valueOf(paramcd.hCg.subType), paramcd.hCg.hCk, Integer.valueOf(paramcd.hCg.hCi) });
      if (paramcd.hCg.subType == 1)
      {
        AppMethodBeat.o(63858);
        return false;
      }
      if (paramcd.hCg.subType == 3)
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent subType == RES_SUB_TYPE_RES");
        if (y.ZC(a.wZr))
        {
          Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " file exists，first delete exist file");
          y.deleteFile(a.wZr);
        }
        y.O(paramcd.hCg.filePath, a.wZr, false);
        a.gq("0", paramcd.hCg.hCk);
      }
      if (a.wZn)
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent OFF_LINE == true, do not reInit Synthesizer");
        AppMethodBeat.o(63858);
        return false;
      }
      a.b(this.wZB);
      AppMethodBeat.o(63858);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.F2fRcvVoiceOffLineLogic.1
 * JD-Core Version:    0.7.0.1
 */