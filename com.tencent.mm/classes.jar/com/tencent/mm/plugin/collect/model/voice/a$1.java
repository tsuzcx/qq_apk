package com.tencent.mm.plugin.collect.model.voice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.bg.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

final class a$1
  extends c<bg>
{
  a$1(a parama)
  {
    AppMethodBeat.i(41003);
    this.__eventId = bg.class.getName().hashCode();
    AppMethodBeat.o(41003);
  }
  
  private boolean a(bg parambg)
  {
    AppMethodBeat.i(41004);
    if (parambg.coI.coJ == 60) {}
    synchronized (a.a(this.kOp))
    {
      if (a.kOb)
      {
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent OFF_LINE == true");
        AppMethodBeat.o(41004);
        return false;
      }
      ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s md5:%s", new Object[] { Integer.valueOf(parambg.coI.coJ), Integer.valueOf(parambg.coI.subType), parambg.coI.coM });
      if (parambg.coI.subType == 1)
      {
        AppMethodBeat.o(41004);
        return false;
      }
      if (parambg.coI.subType == 2)
      {
        e.C(parambg.coI.filePath, a.kOf);
        a.dB("0", parambg.coI.coM);
      }
      a.b(this.kOp);
      AppMethodBeat.o(41004);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a.1
 * JD-Core Version:    0.7.0.1
 */