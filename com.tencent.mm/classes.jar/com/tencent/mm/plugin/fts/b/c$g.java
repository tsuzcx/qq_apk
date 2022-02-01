package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class c$g
  extends i
{
  public c$g(c paramc, j paramj)
  {
    super(paramj);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(52731);
    afX("start");
    paramk.sxM = com.tencent.mm.plugin.fts.a.a.h.a(this.syx.query, false, this.sAF.sAE);
    Object localObject1 = this.sAF.sAz;
    Object localObject2 = paramk.sxM.cKw();
    localObject2 = String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cKr(), localObject2 });
    localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject1).swc.rawQuery((String)localObject2, null);
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
        locala.sxF = ((Cursor)localObject2).getInt(1);
        locala.syN = ((Cursor)localObject2).getLong(2);
        locala.sxG = ((Cursor)localObject2).getString(3);
        locala.timestamp = ((Cursor)localObject2).getLong(4);
        ((List)localObject1).add(locala);
        ((List)localObject4).add(str);
      }
    } while (((List)localObject1).size() <= this.syx.syF);
    ((Cursor)localObject2).close();
    paramk.syK = new LinkedList();
    afX("findUsername");
    if (((List)localObject4).size() > 0)
    {
      localObject3 = this.sAF.sAz.a(paramk.sxM, (List)localObject4);
      localObject2 = new HashMap();
      if (((Cursor)localObject3).moveToNext())
      {
        localObject4 = ((Cursor)localObject3).getString(0).split(" ");
        int i = 0;
        while (i < localObject4.length)
        {
          ((HashMap)localObject2).put(localObject4[i], Integer.valueOf(bs.getInt(localObject4[(i + 1)], 0)));
          i += 2;
        }
      }
      ((Cursor)localObject3).close();
      localObject1 = ((List)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (a)((Iterator)localObject1).next();
        localObject4 = new m();
        ((m)localObject4).type = ((a)localObject3).type;
        ((m)localObject4).sxF = ((a)localObject3).sxF;
        ((m)localObject4).syN = ((a)localObject3).syN;
        ((m)localObject4).sxG = ((a)localObject3).sxG;
        ((m)localObject4).timestamp = ((a)localObject3).timestamp;
        if (((HashMap)localObject2).containsKey(((m)localObject4).sxG)) {}
        for (((m)localObject4).userData = ((HashMap)localObject2).get(((m)localObject4).sxG);; ((m)localObject4).userData = Integer.valueOf(1))
        {
          paramk.syK.add(localObject4);
          break;
        }
      }
      afX("findCount");
    }
    if ((paramk.sxM.syn.length > 1) && (paramk.syK.size() <= 3))
    {
      localObject1 = com.tencent.mm.plugin.fts.a.a.h.bi(paramk.sxM.syn[0], true);
      localObject1 = ((com.tencent.mm.plugin.fts.c.a)((n)g.ad(n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.swu, com.tencent.mm.plugin.fts.a.c.swy);
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new m();
        ((m)localObject2).sxG = "create_talker_message​";
        paramk.syK.add(localObject2);
      }
      ((Cursor)localObject1).close();
      afX("findTalkerConversation");
    }
    AppMethodBeat.o(52731);
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
    int sxF;
    String sxG;
    long syN;
    long timestamp;
    int type;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.g
 * JD-Core Version:    0.7.0.1
 */