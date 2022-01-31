package com.tencent.mm.plugin.clean.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(18671);
    if (!paramCursor.moveToFirst())
    {
      ab.d("MicroMsg.CleanController", "Message count of user:%s is empty", new Object[] { this.username });
      paramCursor.close();
      AppMethodBeat.o(18671);
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
      ((bi)localObject2).convertFrom(paramCursor);
      switch (l.LD(((bi)localObject2).getType()))
      {
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        paramb.kGB.add(localObject1);
        paramb.jyU += ((a)localObject1).size;
        localObject2 = null;
      }
      k = j;
      if (paramCursor.moveToNext())
      {
        localObject1 = localObject2;
        i = j;
        if (!c.i(this.kGP)) {
          break;
        }
        k = j;
      }
      paramCursor.close();
      AppMethodBeat.o(18671);
      return k;
      localObject1 = c.a((bi)localObject2, this.username);
      continue;
      localObject1 = c.b((bi)localObject2, this.username);
      continue;
      localObject1 = c.c((bi)localObject2, this.username);
    }
  }
  
  public final String alu()
  {
    AppMethodBeat.i(18669);
    String str = "username[" + this.username + "]" + super.alu();
    AppMethodBeat.o(18669);
    return str;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(18670);
    aw.aaz();
    int m = com.tencent.mm.model.c.YC().TB(this.username);
    if (m <= 0)
    {
      ab.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d]", new Object[] { this.username, Integer.valueOf(m) });
      AppMethodBeat.o(18670);
      return;
    }
    b localb = new b();
    localb.username = this.username;
    localb.kGB = new ArrayList();
    localb.jyU = 0L;
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
        aw.aaz();
        j = i;
        localObject4 = localObject1;
        localObject3 = localObject1;
        Cursor localCursor = com.tencent.mm.model.c.YC().an(this.username, i, 50);
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
            boolean bool = c.i(this.kGP);
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
          ab.printErrStackTrace("MicroMsg.CleanController", localException, "execute analyse Task error.", new Object[0]);
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
          break label427;
        }
        localObject3.close();
        AppMethodBeat.o(18670);
      }
    }
    if (localb.kGB.size() > 0) {
      c.j(this.kGP).put(this.username, localb);
    }
    ab.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d] alreadyHandleCount[%d] isStop[%b] ", new Object[] { this.username, Integer.valueOf(m), Integer.valueOf(i), Boolean.valueOf(c.i(this.kGP)) });
    AppMethodBeat.o(18670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.c.a
 * JD-Core Version:    0.7.0.1
 */