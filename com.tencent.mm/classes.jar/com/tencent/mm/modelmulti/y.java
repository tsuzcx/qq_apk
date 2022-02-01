package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.LinkedList;

public final class y
{
  private static ArrayList<dl> oOd;
  private static ArrayList<au> oOe;
  
  static
  {
    AppMethodBeat.i(20563);
    oOd = new ArrayList();
    oOe = new ArrayList();
    AppMethodBeat.o(20563);
  }
  
  public static void eH(int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(20560);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20559);
        y.access$000();
        y.OJ(b.bmz() + "/testaddmsg.txt");
        if ((y.bLe().size() <= 0) || (y.bLf().size() <= 0))
        {
          Log.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", new Object[] { Integer.valueOf(y.bLf().size()), Integer.valueOf(y.bLe().size()) });
          AppMethodBeat.o(20559);
          return;
        }
        new MTimerHandler(bh.baH().getLooper(), new MTimerHandler.CallBack()
        {
          int oOh;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(20558);
            if (this.oOh <= 0)
            {
              AppMethodBeat.o(20558);
              return false;
            }
            this.oOh -= 1;
            v.b localb = new v.b();
            localb.YyA.ZdG = new adx();
            int j = Util.getIntRandom(y.1.this.oOg, 1);
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label349;
              }
              dl localdl = (dl)y.bLf().get(Util.getIntRandom(y.bLf().size() - 1, 0));
              localdl.YFE = new etl().btH(((au)y.bLe().get(Util.getIntRandom(y.bLe().size() - 1, 0))).field_username);
              localdl.CreateTime = ((int)Util.nowSecond());
              localdl.Njv = Math.abs((int)Util.nowMilliSecond() % 10000000);
              try
              {
                Object localObject = new adw();
                ((adw)localObject).Zmd = new gol();
                ((adw)localObject).Zmd.df(localdl.toByteArray());
                ((adw)localObject).Zmc = 5;
                localb.YyA.ZdG.vgO.add(localObject);
                localObject = localb.YyA.ZdG;
                ((adx)localObject).vgN += 1;
                Log.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", new Object[] { Integer.valueOf(this.oOh), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localb.YyA.ZdG.vgO.size()), Long.valueOf(localdl.Njv), localdl.YFE.abwM });
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
            localb.YyA.YYp = 0;
            duk localduk = localb.YyA;
            bh.bCz();
            localduk.ZdD = w.aN(Util.decodeHexString(Util.nullAsNil((String)c.ban().d(8195, new byte[0]))));
            localb.YyA.Idd = 0;
            localb.YyA.vhk = 0;
            u.bKY().a(localb, 0, Util.nowSecond());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.y
 * JD-Core Version:    0.7.0.1
 */