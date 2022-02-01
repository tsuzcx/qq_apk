package com.tencent.mm.modelmulti;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import java.util.ArrayList;
import java.util.LinkedList;

public final class s
{
  private static ArrayList<cv> igN;
  private static ArrayList<am> igO;
  
  static
  {
    AppMethodBeat.i(20563);
    igN = new ArrayList();
    igO = new ArrayList();
    AppMethodBeat.o(20563);
  }
  
  public static void di(int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(20560);
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20559);
        s.access$000();
        s.FZ(b.arU() + "/testaddmsg.txt");
        if ((s.aJB().size() <= 0) || (s.igN.size() <= 0))
        {
          ad.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", new Object[] { Integer.valueOf(s.igN.size()), Integer.valueOf(s.aJB().size()) });
          AppMethodBeat.o(20559);
          return;
        }
        new av(ba.ajF().IdO.getLooper(), new av.a()
        {
          int igR;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(20558);
            if (this.igR <= 0)
            {
              AppMethodBeat.o(20558);
              return false;
            }
            this.igR -= 1;
            v.b localb = new v.b();
            localb.Foy.FRu = new zv();
            int j = bt.jw(s.1.this.igQ, 1);
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label349;
              }
              cv localcv = (cv)s.igN.get(bt.jw(s.igN.size() - 1, 0));
              localcv.Fvi = new cwt().aPy(((am)s.aJB().get(bt.jw(s.aJB().size() - 1, 0))).field_username);
              localcv.CreateTime = ((int)bt.aQJ());
              localcv.xbt = Math.abs((int)bt.flT() % 10000000);
              try
              {
                Object localObject = new zu();
                ((zu)localObject).FYV = new SKBuiltinBuffer_t();
                ((zu)localObject).FYV.setBuffer(localcv.toByteArray());
                ((zu)localObject).FYU = 5;
                localb.Foy.FRu.nDj.add(localObject);
                localObject = localb.Foy.FRu;
                ((zv)localObject).nDi += 1;
                ad.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", new Object[] { Integer.valueOf(this.igR), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localb.Foy.FRu.nDj.size()), Long.valueOf(localcv.xbt), localcv.Fvi.HoB });
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ad.d("MicroMsg.TestSyncAddMsg", localException.getMessage());
                  ad.printErrStackTrace("MicroMsg.TestSyncAddMsg", localException, "", new Object[0]);
                }
              }
              i += 1;
            }
            label349:
            localb.Foy.FMr = 0;
            ccs localccs = localb.Foy;
            ba.aBQ();
            localccs.FRr = z.al(bt.aRa(bt.nullAsNil((String)c.ajl().get(8195, new byte[0]))));
            localb.Foy.Ret = 0;
            localb.Foy.nDG = 0;
            p.aJx().a(localb, 0, bt.aQJ());
            AppMethodBeat.o(20558);
            return true;
          }
        }, true).az(3000L, 3000L);
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