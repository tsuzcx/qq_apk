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
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class a$n
  extends h
{
  public a$n(a parama, i parami)
  {
    super(parami);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(136686);
    paramj.mRX = g.aU(this.mSJ.query, true);
    Object localObject2 = a.a(this.mUg).a(paramj.mRX, new int[] { 131075 }, null, true, true);
    Object localObject1 = new HashMap();
    Object localObject4;
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new m().i((Cursor)localObject2);
      if (!this.mSJ.mSS.contains(((m)localObject3).mRV))
      {
        localObject4 = (l)((HashMap)localObject1).get(((m)localObject3).mRV);
        if ((localObject4 == null) || (d.f(c.mQT, ((m)localObject3).mRU, ((l)localObject4).mRU) < 0)) {
          ((HashMap)localObject1).put(((m)localObject3).mRV, localObject3);
        }
        if (Thread.interrupted())
        {
          ((Cursor)localObject2).close();
          paramj = new InterruptedException();
          AppMethodBeat.o(136686);
          throw paramj;
        }
      }
    }
    ((Cursor)localObject2).close();
    localObject2 = new ArrayList(((HashMap)localObject1).size());
    Object localObject3 = ((HashMap)localObject1).values().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (m)((Iterator)localObject3).next();
      ((m)localObject4).bCa();
      ((m)localObject4).a(paramj.mRX);
      ((ArrayList)localObject2).add(localObject4);
      if (Thread.interrupted())
      {
        paramj = new InterruptedException();
        AppMethodBeat.o(136686);
        throw paramj;
      }
    }
    if (this.mSJ.mST != null) {
      Collections.sort((List)localObject2, this.mSJ.mST);
    }
    paramj.mSW = new ArrayList(((HashMap)localObject1).size());
    localObject1 = new StringBuffer();
    int i = 0;
    while (i < ((ArrayList)localObject2).size())
    {
      localObject3 = (l)((ArrayList)localObject2).get(i);
      ((StringBuffer)localObject1).append(((l)localObject3).mSu);
      ((StringBuffer)localObject1).append("|");
      ((StringBuffer)localObject1).append(((l)localObject3).timestamp);
      ((StringBuffer)localObject1).append(" ");
      paramj.mSW.add(localObject3);
      if (i >= this.mSJ.mSR) {
        break;
      }
      i += 1;
    }
    if ((paramj.mRX.mSA.size() > 1) && (a.a(this.mUg).b(paramj.mRX)))
    {
      localObject2 = new l();
      ((l)localObject2).mRV = "create_chatroom​";
      paramj.mSW.add(0, localObject2);
      ((StringBuffer)localObject1).append(" needCreateChatroom");
    }
    ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", new Object[] { ((StringBuffer)localObject1).toString() });
    AppMethodBeat.o(136686);
  }
  
  public final int getId()
  {
    return 19;
  }
  
  public final String getName()
  {
    return "SearchChatroomTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.n
 * JD-Core Version:    0.7.0.1
 */