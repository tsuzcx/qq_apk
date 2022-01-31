package com.tencent.mm.at;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Stack;

final class b$a
  extends ak
{
  private WeakReference<b> fDx;
  
  public b$a(b paramb, Looper paramLooper)
  {
    super(paramLooper);
    AppMethodBeat.i(78157);
    this.fDx = new WeakReference(paramb);
    AppMethodBeat.o(78157);
  }
  
  public final void handleMessage(Message arg1)
  {
    AppMethodBeat.i(78158);
    b localb = (b)this.fDx.get();
    if ((localb != null) && (1 == ???.what))
    {
      boolean bool = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVo, false);
      ??? = new ux();
      ???.cLs.cut = 2;
      com.tencent.mm.sdk.b.a.ymk.l(???);
      if (((!???.cLt.cLu) && (!com.tencent.mm.r.a.Ok())) || (!bool))
      {
        if ((!localb.fDl) && (System.currentTimeMillis() - localb.fDm > 1200000L))
        {
          ab.i("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
          AppMethodBeat.o(78158);
          return;
        }
        if ((localb.fDj != 0L) || (localb.fDi.size() <= 0) || (localb.fDn != 0) || (localb.fDo))
        {
          ab.i("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + localb.fDj + " size: " + localb.fDi.size() + " cnt: " + localb.fDn + " pauseOnMonitor: " + localb.fDo);
          AppMethodBeat.o(78158);
          return;
        }
        e locale;
        synchronized (localb.fDi)
        {
          localb.fDj = ((Long)localb.fDi.pop()).longValue();
          ??? = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(localb.fDj);
          locale = o.ahC().gS(???.field_msgSvrId);
          if (locale.dGW == 1)
          {
            ab.i("MicroMsg.AutoGetBigImgLogic", localb.fDj + " already has hd thumb");
            localb.fDj = 0L;
            localb.start();
            AppMethodBeat.o(78158);
            return;
          }
        }
        ab.i("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + locala.fDj + "  image_" + ???.field_msgId);
        f.afO().fyQ.add("image_" + ???.field_msgId);
        o.ahD().a(locale.fDL, ???.field_msgId, 0, Long.valueOf(locala.fDj), locala.fDk, locala);
      }
    }
    AppMethodBeat.o(78158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.at.b.a
 * JD-Core Version:    0.7.0.1
 */