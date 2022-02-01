package com.tencent.mm.modelmulti;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.LinkedList;

public final class r
{
  private static ArrayList<ai> hNA;
  private static ArrayList<cu> hNz;
  
  static
  {
    AppMethodBeat.i(20563);
    hNz = new ArrayList();
    hNA = new ArrayList();
    AppMethodBeat.o(20563);
  }
  
  public static void df(int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(20560);
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20559);
        r.access$000();
        r.CU(b.aph() + "/testaddmsg.txt");
        if ((r.aGq().size() <= 0) || (r.hNz.size() <= 0))
        {
          ac.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", new Object[] { Integer.valueOf(r.hNz.size()), Integer.valueOf(r.aGq().size()) });
          AppMethodBeat.o(20559);
          return;
        }
        new au(az.agU().GrZ.getLooper(), new au.a()
        {
          int hND;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(20558);
            if (this.hND <= 0)
            {
              AppMethodBeat.o(20558);
              return false;
            }
            this.hND -= 1;
            v.b localb = new v.b();
            localb.DJr.Ekl = new xw();
            int j = bs.jk(r.1.this.hNC, 1);
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label349;
              }
              cu localcu = (cu)r.hNz.get(bs.jk(r.hNz.size() - 1, 0));
              localcu.DPT = new crm().aJV(((ai)r.aGq().get(bs.jk(r.aGq().size() - 1, 0))).field_username);
              localcu.CreateTime = ((int)bs.aNx());
              localcu.vTQ = Math.abs((int)bs.eWj() % 10000000);
              try
              {
                Object localObject = new xv();
                ((xv)localObject).ErM = new SKBuiltinBuffer_t();
                ((xv)localObject).ErM.setBuffer(localcu.toByteArray());
                ((xv)localObject).ErL = 5;
                localb.DJr.Ekl.ncM.add(localObject);
                localObject = localb.DJr.Ekl;
                ((xw)localObject).ncL += 1;
                ac.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", new Object[] { Integer.valueOf(this.hND), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localb.DJr.Ekl.ncM.size()), Long.valueOf(localcu.vTQ), localcu.DPT.FEm });
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ac.d("MicroMsg.TestSyncAddMsg", localException.getMessage());
                  ac.printErrStackTrace("MicroMsg.TestSyncAddMsg", localException, "", new Object[0]);
                }
              }
              i += 1;
            }
            label349:
            localb.DJr.EfS = 0;
            byb localbyb = localb.DJr;
            az.ayM();
            localbyb.Eki = z.al(bs.aLu(bs.nullAsNil((String)c.agA().get(8195, new byte[0]))));
            localb.DJr.Ret = 0;
            localb.DJr.ndj = 0;
            o.aGm().a(localb, 0, bs.aNx());
            AppMethodBeat.o(20558);
            return true;
          }
        }, true).au(3000L, 3000L);
        AppMethodBeat.o(20559);
      }
    });
    AppMethodBeat.o(20560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.r
 * JD-Core Version:    0.7.0.1
 */