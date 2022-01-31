package com.tencent.mm.plugin.ext.provider;

import android.database.MatrixCursor;
import com.tencent.mm.h.a.fj;
import com.tencent.mm.h.a.fj.b;
import com.tencent.mm.h.a.fp;
import com.tencent.mm.h.a.fp.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class ExtControlProviderMsg$1
  implements Runnable
{
  ExtControlProviderMsg$1(ExtControlProviderMsg paramExtControlProviderMsg, int paramInt, long paramLong, com.tencent.mm.pluginsdk.d.a.b paramb, String[] paramArrayOfString) {}
  
  public final void run()
  {
    Object localObject1;
    Object localObject2;
    if (this.jKt == 1)
    {
      com.tencent.mm.plugin.ext.b.aNn();
      localObject1 = com.tencent.mm.plugin.ext.b.eg(this.jKu);
      if ((localObject1 == null) || ((int)((com.tencent.mm.n.a)localObject1).dBe <= 0))
      {
        this.jKv.qF(3);
        this.hSx.countDown();
        return;
      }
      localObject2 = new fj();
      ((fj)localObject2).bMh.op = 1;
      ((fj)localObject2).bMh.username = ((ao)localObject1).field_username;
      if (!com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2))
      {
        this.jKv.qF(4);
        this.hSx.countDown();
        return;
      }
      ExtControlProviderMsg.a(this.jKv, new MatrixCursor(ExtControlProviderMsg.aND()));
      if ((localObject1 != null) && ((int)((com.tencent.mm.n.a)localObject1).dBe > 0) && (((fj)localObject2).bMi.bIe))
      {
        ExtControlProviderMsg.a(this.jKv).addRow(new Object[] { this.dAS[1], Integer.valueOf(1), "0" });
        this.jKv.qF(0);
        y.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[] { Boolean.valueOf(((fj)localObject2).bMi.bIe), ((fj)localObject2).bMi.fileName });
      }
    }
    for (;;)
    {
      this.hSx.countDown();
      return;
      ExtControlProviderMsg.a(this.jKv).addRow(new Object[] { this.dAS[1], Integer.valueOf(2), "0" });
      this.jKv.qF(3);
      break;
      if (this.jKt == 2)
      {
        localObject1 = new fj();
        ((fj)localObject1).bMh.op = 2;
        if (!com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1))
        {
          this.jKv.qF(4);
          this.hSx.countDown();
          return;
        }
        localObject2 = ((fj)localObject1).bMi.fileName;
        ExtControlProviderMsg.a(this.jKv, new MatrixCursor(ExtControlProviderMsg.aND()));
        fp localfp = new fp();
        localfp.bME.fileName = ((String)localObject2);
        if (!com.tencent.mm.sdk.b.a.udP.m(localfp))
        {
          this.jKv.qF(4);
          ExtControlProviderMsg.a(this.jKv).close();
          this.hSx.countDown();
          return;
        }
        y.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[] { Long.valueOf(localfp.bMF.bIt) });
        long l = localfp.bMF.bIt;
        if (l > 0L)
        {
          try
          {
            if (!((fj)localObject1).bMi.bIe) {
              break label607;
            }
            if ((ae.getContext() == null) || (!aq.isConnected(ae.getContext()))) {
              break label558;
            }
            ExtControlProviderMsg.a(this.jKv).addRow(new Object[] { this.dAS[1], Integer.valueOf(1), com.tencent.mm.plugin.ext.a.a.ei(l) });
            this.jKv.qF(0);
          }
          catch (Exception localException)
          {
            y.w("MicroMsg.ExtControlProviderMsg", localException.getMessage());
            y.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
            this.jKv.qF(4);
          }
          continue;
          label558:
          ExtControlProviderMsg.a(this.jKv).addRow(new Object[] { this.dAS[1], Integer.valueOf(6), com.tencent.mm.plugin.ext.a.a.ei(l) });
          this.jKv.qF(4);
          continue;
          label607:
          ExtControlProviderMsg.a(this.jKv).addRow(new Object[] { this.dAS[1], Integer.valueOf(4), com.tencent.mm.plugin.ext.a.a.ei(l) });
          this.jKv.qF(4);
        }
        else
        {
          this.jKv.qF(3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.1
 * JD-Core Version:    0.7.0.1
 */