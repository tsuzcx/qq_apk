package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dcr;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.LinkedList;

public final class s
{
  private static ArrayList<db> lVb;
  private static ArrayList<as> lVc;
  
  static
  {
    AppMethodBeat.i(20563);
    lVb = new ArrayList();
    lVc = new ArrayList();
    AppMethodBeat.o(20563);
  }
  
  public static void dP(int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(20560);
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20559);
        s.access$000();
        s.WK(b.aSL() + "/testaddmsg.txt");
        if ((s.bnr().size() <= 0) || (s.bns().size() <= 0))
        {
          Log.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", new Object[] { Integer.valueOf(s.bns().size()), Integer.valueOf(s.bnr().size()) });
          AppMethodBeat.o(20559);
          return;
        }
        new MTimerHandler(bh.aHJ().getLooper(), new MTimerHandler.CallBack()
        {
          int lVf;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(20558);
            if (this.lVf <= 0)
            {
              AppMethodBeat.o(20558);
              return false;
            }
            this.lVf -= 1;
            v.b localb = new v.b();
            localb.RBX.SfL = new abv();
            int j = Util.getIntRandom(s.1.this.lVe, 1);
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label349;
              }
              db localdb = (db)s.bns().get(Util.getIntRandom(s.bns().size() - 1, 0));
              localdb.RID = new eaf().btQ(((as)s.bnr().get(Util.getIntRandom(s.bnr().size() - 1, 0))).field_username);
              localdb.CreateTime = ((int)Util.nowSecond());
              localdb.HlH = Math.abs((int)Util.nowMilliSecond() % 10000000);
              try
              {
                Object localObject = new abu();
                ((abu)localObject).SnH = new eae();
                ((abu)localObject).SnH.dc(localdb.toByteArray());
                ((abu)localObject).SnG = 5;
                localb.RBX.SfL.rVy.add(localObject);
                localObject = localb.RBX.SfL;
                ((abv)localObject).rVx += 1;
                Log.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", new Object[] { Integer.valueOf(this.lVf), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localb.RBX.SfL.rVy.size()), Long.valueOf(localdb.HlH), localdb.RID.Ufy });
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.d("MicroMsg.TestSyncAddMsg", localException.getMessage());
                  Log.printErrStackTrace("MicroMsg.TestSyncAddMsg", localException, "", new Object[0]);
                }
              }
              i += 1;
            }
            label349:
            localb.RBX.Saq = 0;
            dcr localdcr = localb.RBX;
            bh.beI();
            localdcr.SfI = z.aN(Util.decodeHexString(Util.nullAsNil((String)c.aHp().b(8195, new byte[0]))));
            localb.RBX.CqV = 0;
            localb.RBX.rVU = 0;
            p.bnn().a(localb, 0, Util.nowSecond());
            AppMethodBeat.o(20558);
            return true;
          }
        }, true).startTimer(3000L);
        AppMethodBeat.o(20559);
      }
    });
    AppMethodBeat.o(20560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.s
 * JD-Core Version:    0.7.0.1
 */