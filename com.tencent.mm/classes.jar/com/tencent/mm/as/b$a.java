package com.tencent.mm.as;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.ak.f;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Stack;

final class b$a
  extends ah
{
  private WeakReference<b> ena;
  
  public b$a(b paramb, Looper paramLooper)
  {
    super(paramLooper);
    this.ena = new WeakReference(paramb);
  }
  
  public final void handleMessage(Message arg1)
  {
    b localb = (b)this.ena.get();
    if ((localb != null) && (1 == ???.what))
    {
      if ((!localb.emO) && (System.currentTimeMillis() - localb.emP > 1200000L)) {
        y.d("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
      }
    }
    else {
      return;
    }
    if ((localb.emM != 0L) || (localb.emL.size() <= 0) || (localb.emQ != 0) || (localb.emR))
    {
      y.d("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + localb.emM + " size: " + localb.emL.size() + " cnt: " + localb.emQ + " pauseOnMonitor: " + localb.emR);
      return;
    }
    e locale;
    synchronized (localb.emL)
    {
      localb.emM = ((Long)localb.emL.pop()).longValue();
      ??? = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(localb.emM);
      locale = o.OJ().bX(???.field_msgSvrId);
      if (locale.cQK == 1)
      {
        y.d("MicroMsg.AutoGetBigImgLogic", localb.emM + " already has hd thumb");
        localb.emM = 0L;
        localb.start();
        return;
      }
    }
    y.d("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + locala.emM + "  image_" + ???.field_msgId);
    f.Nd().eiM.add("image_" + ???.field_msgId);
    o.OK().a(locale.enp, ???.field_msgId, 0, Long.valueOf(locala.emM), locala.emN, locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.as.b.a
 * JD-Core Version:    0.7.0.1
 */