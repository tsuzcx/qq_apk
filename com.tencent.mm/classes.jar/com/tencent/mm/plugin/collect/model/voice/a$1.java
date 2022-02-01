package com.tencent.mm.plugin.collect.model.voice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bk.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;

final class a$1
  extends c<bk>
{
  a$1(a parama)
  {
    AppMethodBeat.i(160791);
    this.__eventId = bk.class.getName().hashCode();
    AppMethodBeat.o(160791);
  }
  
  private boolean a(bk parambk)
  {
    AppMethodBeat.i(63858);
    ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent callback");
    if (parambk.dbc.dbd == 60) {}
    synchronized (a.a(this.oxY))
    {
      ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s md5:%s fileVersion:%s", new Object[] { Integer.valueOf(parambk.dbc.dbd), Integer.valueOf(parambk.dbc.subType), parambk.dbc.dbg, Integer.valueOf(parambk.dbc.dbe) });
      if (parambk.dbc.subType == 1)
      {
        AppMethodBeat.o(63858);
        return false;
      }
      if (parambk.dbc.subType == 3)
      {
        if (i.eA(a.oxO)) {
          i.deleteFile(a.oxO);
        }
        i.lZ(parambk.dbc.filePath, a.oxO);
        a.eY("0", parambk.dbc.dbg);
      }
      if (a.oxK)
      {
        ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent OFF_LINE == true");
        AppMethodBeat.o(63858);
        return false;
      }
      a.b(this.oxY);
      AppMethodBeat.o(63858);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a.1
 * JD-Core Version:    0.7.0.1
 */