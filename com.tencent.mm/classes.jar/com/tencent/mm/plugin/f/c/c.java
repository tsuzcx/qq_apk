package com.tencent.mm.plugin.f.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class c
  implements Runnable
{
  public boolean isStop;
  private String kkC;
  private long kkD;
  private c.a kkE;
  private int limit;
  
  public c(String paramString, long paramLong, int paramInt, c.a parama)
  {
    AppMethodBeat.i(18645);
    this.kkC = paramString;
    this.kkD = paramLong;
    this.limit = paramInt;
    this.kkE = parama;
    ab.d("MicroMsg.ScanMsgTask", "%d scan msg[%d %d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.kkD), Integer.valueOf(this.limit) });
    AppMethodBeat.o(18645);
  }
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(18646);
    if (this.isStop)
    {
      AppMethodBeat.o(18646);
      return;
    }
    long l = bo.yB();
    Object localObject3 = null;
    Cursor localCursor2 = null;
    localCursor1 = localCursor2;
    localObject1 = localObject3;
    try
    {
      aw.aaz();
      localCursor1 = localCursor2;
      localObject1 = localObject3;
      localCursor2 = com.tencent.mm.model.c.YC().i(this.kkC, this.kkD, this.limit);
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      l = bo.av(l);
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      b.bak();
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      b.F(this.limit, l);
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
        localObject3 = new bi();
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        ((bi)localObject3).convertFrom(localCursor2);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        b.bak().O((bi)localObject3);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        b.bak().jdMethod_if(((dd)localObject3).field_msgId);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        bool = this.isStop;
      } while (!bool);
      if (localCursor2 != null) {
        localCursor2.close();
      }
      AppMethodBeat.o(18646);
      return;
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      ab.d("MicroMsg.ScanMsgTask", "%d scan msg count[%d] limit[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.limit) });
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      if (i < this.limit)
      {
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        localObject3 = b.bak();
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        b.bak();
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        ((b)localObject3).jdMethod_if(b.ban());
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
        ab.printErrStackTrace("MicroMsg.ScanMsgTask", localException, "", new Object[0]);
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
      AppMethodBeat.o(18646);
    }
    if (this.kkE != null) {
      this.kkE.finish();
    }
    AppMethodBeat.o(18646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.c
 * JD-Core Version:    0.7.0.1
 */