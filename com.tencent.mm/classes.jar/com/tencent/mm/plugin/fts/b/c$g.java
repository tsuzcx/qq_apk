package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class c$g
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public c$g(c paramc, i parami)
  {
    super(parami);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(136757);
    Pg("start");
    paramj.mRX = com.tencent.mm.plugin.fts.a.a.g.a(this.mSJ.query, false, this.mUU.mUT);
    Object localObject1 = this.mUU.mUM;
    Object localObject2 = paramj.mRX.bBX();
    localObject2 = String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.c)localObject1).bBS(), ((com.tencent.mm.plugin.fts.c.c)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.c)localObject1).bBS(), ((com.tencent.mm.plugin.fts.c.c)localObject1).bBS(), localObject2 });
    localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject1).mQr.rawQuery((String)localObject2, null);
    localObject1 = new ArrayList();
    Object localObject3 = new HashSet();
    Object localObject4 = new ArrayList();
    do
    {
      if (!((Cursor)localObject2).moveToNext()) {
        break;
      }
      String str = ((Cursor)localObject2).getString(3);
      if (((HashSet)localObject3).add(str))
      {
        a locala = new a((byte)0);
        locala.type = ((Cursor)localObject2).getInt(0);
        locala.mRU = ((Cursor)localObject2).getInt(1);
        locala.mSZ = ((Cursor)localObject2).getLong(2);
        locala.mRV = ((Cursor)localObject2).getString(3);
        locala.timestamp = ((Cursor)localObject2).getLong(4);
        ((List)localObject1).add(locala);
        ((List)localObject4).add(str);
      }
    } while (((List)localObject1).size() <= this.mSJ.mSR);
    ((Cursor)localObject2).close();
    paramj.mSW = new LinkedList();
    Pg("findUsername");
    if (((List)localObject4).size() > 0)
    {
      localObject3 = this.mUU.mUM.a(paramj.mRX, (List)localObject4);
      localObject2 = new HashMap();
      if (((Cursor)localObject3).moveToNext())
      {
        localObject4 = ((Cursor)localObject3).getString(0).split(" ");
        int i = 0;
        while (i < localObject4.length)
        {
          ((HashMap)localObject2).put(localObject4[i], Integer.valueOf(localObject4[(i + 1)]));
          i += 2;
        }
      }
      ((Cursor)localObject3).close();
      localObject1 = ((List)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (a)((Iterator)localObject1).next();
        localObject4 = new l();
        ((l)localObject4).type = ((a)localObject3).type;
        ((l)localObject4).mRU = ((a)localObject3).mRU;
        ((l)localObject4).mSZ = ((a)localObject3).mSZ;
        ((l)localObject4).mRV = ((a)localObject3).mRV;
        ((l)localObject4).timestamp = ((a)localObject3).timestamp;
        if (((HashMap)localObject2).containsKey(((l)localObject4).mRV)) {}
        for (((l)localObject4).userData = ((HashMap)localObject2).get(((l)localObject4).mRV);; ((l)localObject4).userData = Integer.valueOf(1))
        {
          paramj.mSW.add(localObject4);
          break;
        }
      }
      Pg("findCount");
    }
    if ((paramj.mRX.mSz.length > 1) && (paramj.mSW.size() <= 3))
    {
      localObject1 = com.tencent.mm.plugin.fts.a.a.g.aU(paramj.mRX.mSz[0], true);
      localObject1 = ((com.tencent.mm.plugin.fts.c.a)((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.g)localObject1, null, com.tencent.mm.plugin.fts.a.c.mQJ, com.tencent.mm.plugin.fts.a.c.mQN);
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new l();
        ((l)localObject2).mRV = "create_talker_message​";
        paramj.mSW.add(localObject2);
      }
      ((Cursor)localObject1).close();
      Pg("findTalkerConversation");
    }
    AppMethodBeat.o(136757);
  }
  
  public final int getId()
  {
    return 24;
  }
  
  public final String getName()
  {
    return "SearchLimitGroupMessage";
  }
  
  final class a
  {
    int mRU;
    String mRV;
    long mSZ;
    long timestamp;
    int type;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.g
 * JD-Core Version:    0.7.0.1
 */