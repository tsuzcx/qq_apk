package com.tencent.mm.plugin.appbrand.game.a;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

final class b$c
  extends h
{
  b$c(b paramb, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    paramj.kwi = g.aF(this.kwT.bVk, true);
    paramj.kxh = new ArrayList();
    HashSet localHashSet = new HashSet();
    Cursor localCursor = this.gaB.gaz.a(paramj.kwi, c.kuS, this.kwT.kxb, true, true);
    try
    {
      while (localCursor.moveToNext())
      {
        m localm = new m();
        localm.j(localCursor);
        if ((!localHashSet.contains(Long.valueOf(localm.kxk))) && (!this.kwT.kxd.contains(localm.kwg)))
        {
          localm.aVA();
          paramj.kxh.add(localm);
          localHashSet.add(Long.valueOf(localm.kxk));
        }
      }
      if (localCursor == null) {
        break label178;
      }
    }
    catch (Throwable paramj)
    {
      throw paramj;
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
    }
    localCursor.close();
    label178:
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    if (this.kwT.kxe != null) {
      Collections.sort(paramj.kxh, this.kwT.kxe);
    }
  }
  
  public final int getId()
  {
    return 30;
  }
  
  public final String getName()
  {
    return "SearchMiniGameTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.b.c
 * JD-Core Version:    0.7.0.1
 */