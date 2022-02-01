package com.tencent.mm.modelmulti;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import java.util.ArrayList;
import java.util.LinkedList;

public final class r
{
  private static ArrayList<cs> hmW;
  private static ArrayList<af> hmX;
  
  static
  {
    AppMethodBeat.i(20563);
    hmW = new ArrayList();
    hmX = new ArrayList();
    AppMethodBeat.o(20563);
  }
  
  public static void df(int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(20560);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20559);
        r.access$000();
        r.yP(b.aih() + "/testaddmsg.txt");
        if ((r.azz().size() <= 0) || (r.hmW.size() <= 0))
        {
          ad.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", new Object[] { Integer.valueOf(r.hmW.size()), Integer.valueOf(r.azz().size()) });
          AppMethodBeat.o(20559);
          return;
        }
        new av(az.afE().EUN.getLooper(), new av.a()
        {
          int hna;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(20558);
            if (this.hna <= 0)
            {
              AppMethodBeat.o(20558);
              return false;
            }
            this.hna -= 1;
            v.b localb = new v.b();
            localb.CqZ.CRA = new xe();
            int j = bt.iX(r.1.this.hmZ, 1);
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label349;
              }
              cs localcs = (cs)r.hmW.get(bt.iX(r.hmW.size() - 1, 0));
              localcs.Cxx = new cmf().aEE(((af)r.azz().get(bt.iX(r.azz().size() - 1, 0))).field_username);
              localcs.CreateTime = ((int)bt.aGK());
              localcs.uKZ = Math.abs((int)bt.eGO() % 10000000);
              try
              {
                Object localObject = new xd();
                ((xd)localObject).CYZ = new SKBuiltinBuffer_t();
                ((xd)localObject).CYZ.setBuffer(localcs.toByteArray());
                ((xd)localObject).CYY = 5;
                localb.CqZ.CRA.mAL.add(localObject);
                localObject = localb.CqZ.CRA;
                ((xe)localObject).mAK += 1;
                ad.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", new Object[] { Integer.valueOf(this.hna), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localb.CqZ.CRA.mAL.size()), Long.valueOf(localcs.uKZ), localcs.Cxx.Ehn });
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
            localb.CqZ.CNq = 0;
            btk localbtk = localb.CqZ;
            az.arV();
            localbtk.CRx = z.am(bt.aGd(bt.nullAsNil((String)c.afk().get(8195, new byte[0]))));
            localb.CqZ.Ret = 0;
            localb.CqZ.mBi = 0;
            o.azv().a(localb, 0, bt.aGK());
            AppMethodBeat.o(20558);
            return true;
          }
        }, true).av(3000L, 3000L);
        AppMethodBeat.o(20559);
      }
    });
    AppMethodBeat.o(20560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.r
 * JD-Core Version:    0.7.0.1
 */