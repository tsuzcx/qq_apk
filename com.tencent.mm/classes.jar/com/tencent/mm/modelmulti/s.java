package com.tencent.mm.modelmulti;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import java.util.ArrayList;
import java.util.LinkedList;

public final class s
{
  private static ArrayList<cv> ijG;
  private static ArrayList<an> ijH;
  
  static
  {
    AppMethodBeat.i(20563);
    ijG = new ArrayList();
    ijH = new ArrayList();
    AppMethodBeat.o(20563);
  }
  
  public static void di(int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(20560);
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20559);
        s.access$000();
        s.GB(b.asj() + "/testaddmsg.txt");
        if ((s.aJU().size() <= 0) || (s.ijG.size() <= 0))
        {
          ae.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", new Object[] { Integer.valueOf(s.ijG.size()), Integer.valueOf(s.aJU().size()) });
          AppMethodBeat.o(20559);
          return;
        }
        new com.tencent.mm.sdk.platformtools.aw(bc.ajU().IxZ.getLooper(), new aw.a()
        {
          int ijK;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(20558);
            if (this.ijK <= 0)
            {
              AppMethodBeat.o(20558);
              return false;
            }
            this.ijK -= 1;
            v.b localb = new v.b();
            localb.FGW.GjT = new zy();
            int j = bu.jA(s.1.this.ijJ, 1);
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label349;
              }
              cv localcv = (cv)s.ijG.get(bu.jA(s.ijG.size() - 1, 0));
              localcv.FNG = new cxn().aQV(((an)s.aJU().get(bu.jA(s.aJU().size() - 1, 0))).field_username);
              localcv.CreateTime = ((int)bu.aRi());
              localcv.xrk = Math.abs((int)bu.fpO() % 10000000);
              try
              {
                Object localObject = new zx();
                ((zx)localObject).Grv = new SKBuiltinBuffer_t();
                ((zx)localObject).Grv.setBuffer(localcv.toByteArray());
                ((zx)localObject).Gru = 5;
                localb.FGW.GjT.nIE.add(localObject);
                localObject = localb.FGW.GjT;
                ((zy)localObject).nID += 1;
                ae.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", new Object[] { Integer.valueOf(this.ijK), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localb.FGW.GjT.nIE.size()), Long.valueOf(localcv.xrk), localcv.FNG.HId });
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ae.d("MicroMsg.TestSyncAddMsg", localException.getMessage());
                  ae.printErrStackTrace("MicroMsg.TestSyncAddMsg", localException, "", new Object[0]);
                }
              }
              i += 1;
            }
            label349:
            localb.FGW.GeQ = 0;
            cdm localcdm = localb.FGW;
            bc.aCg();
            localcdm.GjQ = z.al(bu.aSx(bu.nullAsNil((String)c.ajA().get(8195, new byte[0]))));
            localb.FGW.Ret = 0;
            localb.FGW.nJb = 0;
            p.aJQ().a(localb, 0, bu.aRi());
            AppMethodBeat.o(20558);
            return true;
          }
        }, true).ay(3000L, 3000L);
        AppMethodBeat.o(20559);
      }
    });
    AppMethodBeat.o(20560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.s
 * JD-Core Version:    0.7.0.1
 */