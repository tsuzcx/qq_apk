package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class b$c
  extends h
{
  private b$c(b paramb, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    paramj.kwi = g.aF(this.kwT.bVk, true);
    paramj.kxh = new ArrayList();
    Object localObject = new HashSet();
    Cursor localCursor = this.kyU.kyT.a(paramj.kwi, c.kuP, this.kwT.kxb, true, true);
    while (localCursor.moveToNext())
    {
      m localm = new m();
      localm.j(localCursor);
      if ((!((HashSet)localObject).contains(Long.valueOf(localm.kxk))) && (!this.kwT.kxd.contains(localm.kwg)))
      {
        localm.aVA();
        paramj.kxh.add(localm);
        ((HashSet)localObject).add(Long.valueOf(localm.kxk));
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    if (this.kwT.kxe != null) {
      Collections.sort(paramj.kxh, this.kwT.kxe);
    }
    paramj = paramj.kxh.iterator();
    while (paramj.hasNext())
    {
      localObject = (l)paramj.next();
      ((l)localObject).userData = this.kyU.kyT.rz((int)((l)localObject).kxk);
    }
  }
  
  public final int getId()
  {
    return 12;
  }
  
  public final String getName()
  {
    return "SearchFeatureTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b.c
 * JD-Core Version:    0.7.0.1
 */