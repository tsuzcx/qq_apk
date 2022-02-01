package com.tencent.mm.plugin.f.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;

public final class d
  extends com.tencent.e.i.b
{
  public boolean isStop;
  private int limit;
  private String oCE;
  private long oCF;
  private a oCG;
  
  public d(String paramString, long paramLong, int paramInt, a parama)
  {
    AppMethodBeat.i(22754);
    this.oCE = paramString;
    this.oCF = paramLong;
    this.limit = paramInt;
    this.oCG = parama;
    ae.d("MicroMsg.ScanMsgTask", "%d scan msg[%d %d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.oCF), Integer.valueOf(this.limit) });
    AppMethodBeat.o(22754);
  }
  
  public final String getKey()
  {
    return "ScanMsgTask";
  }
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(22755);
    if (this.isStop)
    {
      AppMethodBeat.o(22755);
      return;
    }
    long l = bu.HQ();
    Object localObject3 = null;
    Cursor localCursor2 = null;
    localCursor1 = localCursor2;
    localObject1 = localObject3;
    try
    {
      bc.aCg();
      localCursor1 = localCursor2;
      localObject1 = localObject3;
      localCursor2 = c.azI().k(this.oCE, this.oCF, this.limit);
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      l = bu.aO(l);
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      com.tencent.mm.plugin.f.b.bUj();
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      com.tencent.mm.plugin.f.b.J(this.limit, l);
      boolean bool;
      do
      {
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        if (!localCursor2.moveToNext()) {
          break;
        }
        i += 1;
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        localObject3 = new bv();
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        ((bv)localObject3).convertFrom(localCursor2);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        com.tencent.mm.plugin.f.b.bUj().ac((bv)localObject3);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        com.tencent.mm.plugin.f.b.bUj().tP(((ei)localObject3).field_msgId);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        bool = this.isStop;
      } while (!bool);
      if (localCursor2 != null) {
        localCursor2.close();
      }
      AppMethodBeat.o(22755);
      return;
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      ae.d("MicroMsg.ScanMsgTask", "%d scan msg count[%d] limit[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.limit) });
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      if (i < this.limit)
      {
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        localObject3 = com.tencent.mm.plugin.f.b.bUj();
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        com.tencent.mm.plugin.f.b.bUj();
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        ((com.tencent.mm.plugin.f.b)localObject3).tP(com.tencent.mm.plugin.f.b.bUm());
      }
      if (localCursor2 != null) {
        localCursor2.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localCursor1;
        ae.printErrStackTrace("MicroMsg.ScanMsgTask", localException, "", new Object[0]);
        if (localCursor1 != null) {
          localCursor1.close();
        }
      }
    }
    finally
    {
      if (localObject1 == null) {
        break label428;
      }
      ((Cursor)localObject1).close();
      AppMethodBeat.o(22755);
    }
    if (this.oCG != null) {
      this.oCG.finish();
    }
    AppMethodBeat.o(22755);
  }
  
  public static abstract interface a
  {
    public abstract void finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.d
 * JD-Core Version:    0.7.0.1
 */