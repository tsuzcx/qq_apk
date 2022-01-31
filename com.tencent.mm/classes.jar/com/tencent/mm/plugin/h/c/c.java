package com.tencent.mm.plugin.h.c;

import android.database.Cursor;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class c
  implements Runnable
{
  private String ijC;
  private long ijD;
  private a ijE;
  public boolean isStop;
  private int limit;
  
  public c(String paramString, long paramLong, int paramInt, a parama)
  {
    this.ijC = paramString;
    this.ijD = paramLong;
    this.limit = paramInt;
    this.ijE = parama;
    y.d("MicroMsg.ScanMsgTask", "%d scan msg[%d %d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.ijD), Integer.valueOf(this.limit) });
  }
  
  public final void run()
  {
    int i = 0;
    if (this.isStop) {}
    do
    {
      for (;;)
      {
        return;
        long l = bk.UZ();
        Object localObject3 = null;
        Cursor localCursor2 = null;
        Cursor localCursor1 = localCursor2;
        Object localObject1 = localObject3;
        try
        {
          au.Hx();
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          localCursor2 = com.tencent.mm.model.c.Fy().g(this.ijC, this.ijD, this.limit);
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          l = bk.cp(l);
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          b.ayE();
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          b.r(this.limit, l);
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
            ((bi)localObject3).d(localCursor2);
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            b.ayE().K((bi)localObject3);
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            b.ayE().cR(((cs)localObject3).field_msgId);
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            bool = this.isStop;
          } while (!bool);
          if (localCursor2 != null)
          {
            localCursor2.close();
            return;
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            y.d("MicroMsg.ScanMsgTask", "%d scan msg count[%d] limit[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.limit) });
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            if (i < this.limit)
            {
              localCursor1 = localCursor2;
              localObject1 = localCursor2;
              localObject3 = b.ayE();
              localCursor1 = localCursor2;
              localObject1 = localCursor2;
              b.ayE();
              localCursor1 = localCursor2;
              localObject1 = localCursor2;
              ((b)localObject3).cR(b.ayG());
            }
            if (localCursor2 != null) {
              localCursor2.close();
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localObject1 = localCursor1;
            y.printErrStackTrace("MicroMsg.ScanMsgTask", localException, "", new Object[0]);
            if (localCursor1 != null) {
              localCursor1.close();
            }
          }
        }
        finally
        {
          if (localObject1 == null) {
            break label404;
          }
          ((Cursor)localObject1).close();
        }
      }
    } while (this.ijE == null);
    this.ijE.finish();
  }
  
  public static abstract interface a
  {
    public abstract void finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.h.c.c
 * JD-Core Version:    0.7.0.1
 */