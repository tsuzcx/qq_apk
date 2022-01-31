package com.tencent.mm.modelmulti;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.LinkedList;

final class q$1
  implements Runnable
{
  q$1(int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(16513);
    q.access$000();
    q.tQ(e.eQz + "/testaddmsg.txt");
    if ((q.ais().size() <= 0) || (q.ait().size() <= 0))
    {
      ab.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", new Object[] { Integer.valueOf(q.ait().size()), Integer.valueOf(q.ais().size()) });
      AppMethodBeat.o(16513);
      return;
    }
    new ap(aw.RO().oNc.getLooper(), new ap.a()
    {
      int fJX;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(16512);
        if (this.fJX <= 0)
        {
          AppMethodBeat.o(16512);
          return false;
        }
        this.fJX -= 1;
        t.b localb = new t.b();
        localb.wiN.wFU = new ue();
        int j = bo.hk(q.1.this.fJW, 1);
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label349;
          }
          cm localcm = (cm)q.ait().get(bo.hk(q.ait().size() - 1, 0));
          localcm.woP = new bwc().aoF(((ad)q.ais().get(bo.hk(q.ais().size() - 1, 0))).field_username);
          localcm.CreateTime = ((int)bo.aox());
          localcm.pIG = Math.abs((int)bo.aoy() % 10000000);
          try
          {
            Object localObject = new ud();
            ((ud)localObject).wMD = new SKBuiltinBuffer_t();
            ((ud)localObject).wMD.setBuffer(localcm.toByteArray());
            ((ud)localObject).wMC = 5;
            localb.wiN.wFU.jJv.add(localObject);
            localObject = localb.wiN.wFU;
            ((ue)localObject).jJu += 1;
            ab.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", new Object[] { Integer.valueOf(this.fJX), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localb.wiN.wFU.jJv.size()), Long.valueOf(localcm.pIG), localcm.woP.xJE });
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ab.d("MicroMsg.TestSyncAddMsg", localException.getMessage());
              ab.printErrStackTrace("MicroMsg.TestSyncAddMsg", localException, "", new Object[0]);
            }
          }
          i += 1;
        }
        label349:
        localb.wiN.wBX = 0;
        bgj localbgj = localb.wiN;
        aw.aaz();
        localbgj.wFR = aa.ac(bo.apQ(bo.nullAsNil((String)c.Ru().get(8195, new byte[0]))));
        localb.wiN.Ret = 0;
        localb.wiN.jJS = 0;
        n.aio().a(localb, 0, bo.aox());
        AppMethodBeat.o(16512);
        return true;
      }
    }, true).ag(3000L, 3000L);
    AppMethodBeat.o(16513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelmulti.q.1
 * JD-Core Version:    0.7.0.1
 */