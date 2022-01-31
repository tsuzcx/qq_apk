package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(136722);
    paramj.mRX = g.aU(this.mSJ.query, true);
    paramj.mSW = new ArrayList();
    Object localObject = new HashSet();
    Cursor localCursor = this.mUJ.mUI.a(paramj.mRX, c.mQC, this.mSJ.mSQ, true, true);
    while (localCursor.moveToNext())
    {
      m localm = new m();
      localm.i(localCursor);
      if ((!((HashSet)localObject).contains(Long.valueOf(localm.mSZ))) && (!this.mSJ.mSS.contains(localm.mRV)))
      {
        localm.bCa();
        paramj.mSW.add(localm);
        ((HashSet)localObject).add(Long.valueOf(localm.mSZ));
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    if (Thread.interrupted())
    {
      paramj = new InterruptedException();
      AppMethodBeat.o(136722);
      throw paramj;
    }
    if (this.mSJ.mST != null) {
      Collections.sort(paramj.mSW, this.mSJ.mST);
    }
    paramj = paramj.mSW.iterator();
    while (paramj.hasNext())
    {
      localObject = (l)paramj.next();
      ((l)localObject).userData = this.mUJ.mUI.wv((int)((l)localObject).mSZ);
    }
    AppMethodBeat.o(136722);
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