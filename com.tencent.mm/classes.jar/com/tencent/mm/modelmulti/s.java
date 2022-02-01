package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.cts;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dqi;
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
  private static ArrayList<de> jeC;
  private static ArrayList<as> jeD;
  
  static
  {
    AppMethodBeat.i(20563);
    jeC = new ArrayList();
    jeD = new ArrayList();
    AppMethodBeat.o(20563);
  }
  
  public static void ds(int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(20560);
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20559);
        s.access$000();
        s.Pn(b.aKJ() + "/testaddmsg.txt");
        if ((s.bdW().size() <= 0) || (s.bdX().size() <= 0))
        {
          Log.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", new Object[] { Integer.valueOf(s.bdX().size()), Integer.valueOf(s.bdW().size()) });
          AppMethodBeat.o(20559);
          return;
        }
        new MTimerHandler(bg.aAk().getLooper(), new MTimerHandler.CallBack()
        {
          int jeG;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(20558);
            if (this.jeG <= 0)
            {
              AppMethodBeat.o(20558);
              return false;
            }
            this.jeG -= 1;
            v.b localb = new v.b();
            localb.KAh.Ley = new abo();
            int j = Util.getIntRandom(s.1.this.jeF, 1);
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label349;
              }
              de localde = (de)s.bdX().get(Util.getIntRandom(s.bdX().size() - 1, 0));
              localde.KHl = new dqi().bhy(((as)s.bdW().get(Util.getIntRandom(s.bdW().size() - 1, 0))).field_username);
              localde.CreateTime = ((int)Util.nowSecond());
              localde.Brn = Math.abs((int)Util.nowMilliSecond() % 10000000);
              try
              {
                Object localObject = new abn();
                ((abn)localObject).Lmt = new SKBuiltinBuffer_t();
                ((abn)localObject).Lmt.setBuffer(localde.toByteArray());
                ((abn)localObject).Lms = 5;
                localb.KAh.Ley.oTA.add(localObject);
                localObject = localb.KAh.Ley;
                ((abo)localObject).oTz += 1;
                Log.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", new Object[] { Integer.valueOf(this.jeG), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localb.KAh.Ley.oTA.size()), Long.valueOf(localde.Brn), localde.KHl.MTo });
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
            localb.KAh.KZh = 0;
            cts localcts = localb.KAh;
            bg.aVF();
            localcts.Lev = z.aC(Util.decodeHexString(Util.nullAsNil((String)c.azQ().get(8195, new byte[0]))));
            localb.KAh.Ret = 0;
            localb.KAh.oTW = 0;
            p.bdS().a(localb, 0, Util.nowSecond());
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
 * Qualified Name:     com.tencent.mm.modelmulti.s
 * JD-Core Version:    0.7.0.1
 */