package com.tencent.mm.plugin.ext.provider;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.fm.b;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.a.fs.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class ExtControlProviderMsg$1
  implements Runnable
{
  ExtControlProviderMsg$1(ExtControlProviderMsg paramExtControlProviderMsg, int paramInt, long paramLong, com.tencent.mm.pluginsdk.d.a.b paramb, String[] paramArrayOfString) {}
  
  public final void run()
  {
    AppMethodBeat.i(20348);
    Object localObject1;
    Object localObject2;
    if (this.jWH == 1)
    {
      com.tencent.mm.plugin.ext.b.btq();
      localObject1 = com.tencent.mm.plugin.ext.b.jD(this.mey);
      if ((localObject1 == null) || ((int)((com.tencent.mm.n.a)localObject1).euF <= 0))
      {
        this.mez.vA(3);
        this.jMg.countDown();
        AppMethodBeat.o(20348);
        return;
      }
      localObject2 = new fm();
      ((fm)localObject2).ctC.op = 1;
      ((fm)localObject2).ctC.username = ((aq)localObject1).field_username;
      if (!com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2))
      {
        this.mez.vA(4);
        this.jMg.countDown();
        AppMethodBeat.o(20348);
        return;
      }
      ExtControlProviderMsg.a(this.mez, new MatrixCursor(ExtControlProviderMsg.btG()));
      if ((localObject1 != null) && ((int)((com.tencent.mm.n.a)localObject1).euF > 0) && (((fm)localObject2).ctD.cpz))
      {
        ExtControlProviderMsg.a(this.mez).addRow(new Object[] { this.eut[1], Integer.valueOf(1), "0" });
        this.mez.vA(0);
        ab.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[] { Boolean.valueOf(((fm)localObject2).ctD.cpz), ((fm)localObject2).ctD.fileName });
      }
    }
    for (;;)
    {
      this.jMg.countDown();
      AppMethodBeat.o(20348);
      return;
      ExtControlProviderMsg.a(this.mez).addRow(new Object[] { this.eut[1], Integer.valueOf(2), "0" });
      this.mez.vA(3);
      break;
      if (this.jWH == 2)
      {
        localObject1 = new fm();
        ((fm)localObject1).ctC.op = 2;
        if (!com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1))
        {
          this.mez.vA(4);
          this.jMg.countDown();
          AppMethodBeat.o(20348);
          return;
        }
        localObject2 = ((fm)localObject1).ctD.fileName;
        ExtControlProviderMsg.a(this.mez, new MatrixCursor(ExtControlProviderMsg.btG()));
        fs localfs = new fs();
        localfs.ctY.fileName = ((String)localObject2);
        if (!com.tencent.mm.sdk.b.a.ymk.l(localfs))
        {
          this.mez.vA(4);
          ExtControlProviderMsg.a(this.mez).close();
          this.jMg.countDown();
          AppMethodBeat.o(20348);
          return;
        }
        ab.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[] { Long.valueOf(localfs.ctZ.cpO) });
        long l = localfs.ctZ.cpO;
        if (l > 0L)
        {
          try
          {
            if (!((fm)localObject1).ctD.cpz) {
              break label643;
            }
            if ((ah.getContext() == null) || (!at.isConnected(ah.getContext()))) {
              break label594;
            }
            ExtControlProviderMsg.a(this.mez).addRow(new Object[] { this.eut[1], Integer.valueOf(1), com.tencent.mm.plugin.ext.a.a.jF(l) });
            this.mez.vA(0);
          }
          catch (Exception localException)
          {
            ab.w("MicroMsg.ExtControlProviderMsg", localException.getMessage());
            ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
            this.mez.vA(4);
          }
          continue;
          label594:
          ExtControlProviderMsg.a(this.mez).addRow(new Object[] { this.eut[1], Integer.valueOf(6), com.tencent.mm.plugin.ext.a.a.jF(l) });
          this.mez.vA(4);
          continue;
          label643:
          ExtControlProviderMsg.a(this.mez).addRow(new Object[] { this.eut[1], Integer.valueOf(4), com.tencent.mm.plugin.ext.a.a.jF(l) });
          this.mez.vA(4);
        }
        else
        {
          this.mez.vA(3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.1
 * JD-Core Version:    0.7.0.1
 */