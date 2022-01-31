package com.tencent.mm.plugin.appbrand.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
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
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(129961);
    paramj.mRX = g.aU(this.mSJ.query, true);
    paramj.mSW = new ArrayList();
    HashSet localHashSet = new HashSet();
    Cursor localCursor = this.hrJ.hrH.a(paramj.mRX, com.tencent.mm.plugin.fts.a.c.mQE, this.mSJ.mSQ, true, true);
    try
    {
      while (localCursor.moveToNext())
      {
        m localm = new m();
        localm.i(localCursor);
        if ((!localHashSet.contains(Long.valueOf(localm.mSZ))) && (!this.mSJ.mSS.contains(localm.mRV)))
        {
          localm.bCa();
          paramj.mSW.add(localm);
          localHashSet.add(Long.valueOf(localm.mSZ));
        }
      }
      if (localCursor == null) {
        break label193;
      }
    }
    catch (Throwable paramj)
    {
      AppMethodBeat.o(129961);
      throw paramj;
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(129961);
    }
    localCursor.close();
    label193:
    if (Thread.interrupted())
    {
      paramj = new InterruptedException();
      AppMethodBeat.o(129961);
      throw paramj;
    }
    if (this.mSJ.mST != null) {
      Collections.sort(paramj.mSW, this.mSJ.mST);
    }
    AppMethodBeat.o(129961);
  }
  
  public final int getId()
  {
    return 21;
  }
  
  public final String getName()
  {
    return "SearchWeAppTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.c
 * JD-Core Version:    0.7.0.1
 */