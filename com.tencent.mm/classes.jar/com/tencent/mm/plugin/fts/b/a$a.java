package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

final class a$a
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int muO = 0;
  private int muP = 0;
  
  private a$a(a parama) {}
  
  public final String aAn()
  {
    AppMethodBeat.i(136664);
    String str = String.format("{new: %d removed: %d}", new Object[] { Integer.valueOf(this.muO), Integer.valueOf(this.muP) });
    AppMethodBeat.o(136664);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136663);
    ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
    Object localObject1 = new HashSet();
    Object localObject2 = a.a(this.mUg).mQr.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
    while (((Cursor)localObject2).moveToNext()) {
      ((HashSet)localObject1).add(((Cursor)localObject2).getString(0));
    }
    ((Cursor)localObject2).close();
    localObject2 = a.d(this.mUg).i("SELECT chatroomname, memberlist FROM chatroom;", null);
    int i = 5;
    int j;
    while (((Cursor)localObject2).moveToNext())
    {
      if (Thread.interrupted())
      {
        ((Cursor)localObject2).close();
        a.a(this.mUg).commit();
        localObject1 = new InterruptedException();
        AppMethodBeat.o(136663);
        throw ((Throwable)localObject1);
      }
      String str = ((Cursor)localObject2).getString(0);
      String[] arrayOfString = c.a.mQW.split(((Cursor)localObject2).getString(1));
      a.f(this.mUg).put(str, arrayOfString);
      if (!((HashSet)localObject1).remove(str))
      {
        j = i;
        if (i >= 5)
        {
          a.a(this.mUg).commit();
          a.a(this.mUg).beginTransaction();
          j = 0;
        }
        a.a(this.mUg).k(str, arrayOfString);
        i = j + 1;
        this.muO += 1;
      }
    }
    ((Cursor)localObject2).close();
    a.a(this.mUg).commit();
    localObject1 = ((HashSet)localObject1).iterator();
    for (i = 5; ((Iterator)localObject1).hasNext(); i = j + 1)
    {
      localObject2 = (String)((Iterator)localObject1).next();
      j = i;
      if (i >= 5)
      {
        a.a(this.mUg).commit();
        a.a(this.mUg).beginTransaction();
        j = 0;
      }
      a.a(this.mUg).Pq((String)localObject2);
      this.muP += 1;
    }
    a.a(this.mUg).commit();
    AppMethodBeat.o(136663);
    return true;
  }
  
  public final int getId()
  {
    return 3;
  }
  
  public final String getName()
  {
    return "BuildChatroomIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.a
 * JD-Core Version:    0.7.0.1
 */