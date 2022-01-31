package com.tencent.mm.plugin.clean.c;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public final class c$a
  extends com.tencent.mm.plugin.clean.c.a.a
{
  private String username;
  
  public c$a(c paramc, String paramString)
  {
    super(paramc);
    this.username = paramString;
  }
  
  private int a(Cursor paramCursor, b paramb)
  {
    int i = 0;
    if (!paramCursor.moveToFirst())
    {
      y.d("MicroMsg.CleanController", "Message count of user:%s is empty", new Object[] { this.username });
      paramCursor.close();
      return 0;
    }
    Object localObject1 = null;
    int k = i;
    int j;
    Object localObject2;
    if (!paramCursor.isAfterLast())
    {
      j = i + 1;
      localObject2 = new bi();
      ((bi)localObject2).d(paramCursor);
      switch (l.DK(((bi)localObject2).getType()))
      {
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        paramb.iBu.add(localObject1);
        paramb.hFz += ((a)localObject1).size;
        localObject2 = null;
      }
      k = j;
      if (paramCursor.moveToNext())
      {
        localObject1 = localObject2;
        i = j;
        if (!c.i(this.iBI)) {
          break;
        }
        k = j;
      }
      paramCursor.close();
      return k;
      localObject1 = c.a((bi)localObject2, this.username);
      continue;
      localObject1 = c.b((bi)localObject2, this.username);
      continue;
      localObject1 = c.c((bi)localObject2, this.username);
    }
  }
  
  public final String Sj()
  {
    return "username[" + this.username + "]" + super.Sj();
  }
  
  public final void execute()
  {
    au.Hx();
    int m = com.tencent.mm.model.c.Fy().HS(this.username);
    if (m <= 0)
    {
      y.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d]", new Object[] { this.username, Integer.valueOf(m) });
      return;
    }
    b localb = new b();
    localb.username = this.username;
    localb.iBu = new ArrayList();
    localb.hFz = 0L;
    Object localObject1 = null;
    i = 0;
    for (;;)
    {
      int j = i;
      Object localObject3 = localObject1;
      Object localObject4;
      if (i < m)
      {
        j = i;
        localObject4 = localObject1;
        localObject3 = localObject1;
      }
      try
      {
        au.Hx();
        j = i;
        localObject4 = localObject1;
        localObject3 = localObject1;
        Cursor localCursor = com.tencent.mm.model.c.Fy().X(this.username, i, 50);
        j = i;
        localObject3 = localCursor;
        if (localCursor != null)
        {
          j = i;
          localObject4 = localCursor;
          localObject3 = localCursor;
          int k = a(localCursor, localb);
          if (localCursor != null)
          {
            j = i;
            localObject4 = localCursor;
            localObject3 = localCursor;
            if (!localCursor.isClosed())
            {
              j = i;
              localObject4 = localCursor;
              localObject3 = localCursor;
              localCursor.close();
            }
          }
          j = i;
          localObject3 = localCursor;
          if (k > 0)
          {
            k = i + k;
            j = k;
            localObject4 = localCursor;
            localObject3 = localCursor;
            boolean bool = c.i(this.iBI);
            i = k;
            localObject1 = localCursor;
            if (!bool) {
              continue;
            }
            localObject3 = localCursor;
            j = k;
          }
        }
        i = j;
        if (localObject3 != null)
        {
          localObject3.close();
          i = j;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject3 = localObject4;
          y.printErrStackTrace("MicroMsg.CleanController", localException, "execute analyse Task error.", new Object[0]);
          i = j;
          if (localObject4 != null)
          {
            localObject4.close();
            i = j;
          }
        }
      }
      finally
      {
        if (localObject3 == null) {
          break label409;
        }
        localObject3.close();
      }
    }
    if (localb.iBu.size() > 0) {
      c.j(this.iBI).put(this.username, localb);
    }
    y.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d] alreadyHandleCount[%d] isStop[%b] ", new Object[] { this.username, Integer.valueOf(m), Integer.valueOf(i), Boolean.valueOf(c.i(this.iBI)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.c.a
 * JD-Core Version:    0.7.0.1
 */