package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class b$a
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int add;
  private int kyV;
  
  private b$a(b paramb) {}
  
  public final String afJ()
  {
    return String.format("{remove: %d add: %d}", new Object[] { Integer.valueOf(this.kyV), Integer.valueOf(this.add) });
  }
  
  public final boolean execute()
  {
    y.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
    Object localObject1 = this.kyU.kyT;
    Object localObject2 = new ArrayList();
    Object localObject3 = String.format("SELECT * FROM Feature", new Object[0]);
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).kuE.rawQuery((String)localObject3, null);
    while (((Cursor)localObject1).moveToNext())
    {
      localObject3 = new com.tencent.mm.plugin.fts.a.a.c();
      ((com.tencent.mm.plugin.fts.a.a.c)localObject3).d((Cursor)localObject1);
      ((List)localObject2).add(localObject3);
    }
    ((Cursor)localObject1).close();
    localObject1 = localObject2;
    if (((List)localObject2).size() == 0) {
      localObject1 = localObject2;
    }
    try
    {
      localObject2 = b.Eb(j.n(b.aVJ().cLr()));
      localObject1 = localObject2;
      this.kyU.kyT.bB((List)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label126:
      Object localObject4;
      Object localObject5;
      break label126;
    }
    localObject3 = this.kyU.kyT.aVS();
    localObject2 = new HashMap();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject1).next();
      ((HashMap)localObject2).put(Integer.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject4).field_featureId), localObject4);
    }
    if (this.kyU.kyT.kuE.inTransaction()) {
      this.kyU.kyT.commit();
    }
    this.kyU.kyT.beginTransaction();
    localObject1 = new HashSet();
    localObject4 = new HashSet();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (com.tencent.mm.plugin.fts.c.b.a)((Iterator)localObject3).next();
      com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)((HashMap)localObject2).remove(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).kzP));
      if (localc != null)
      {
        if (((com.tencent.mm.plugin.fts.c.b.a)localObject5).timestamp != localc.field_timestamp)
        {
          ((HashSet)localObject4).add(localc);
          this.kyU.kyT.c(com.tencent.mm.plugin.fts.a.c.kuP, Long.valueOf(localc.field_featureId).longValue());
          ((PluginFTS)g.t(PluginFTS.class)).getTopHitsLogic().d(com.tencent.mm.plugin.fts.a.c.kuP, String.valueOf(localc.field_featureId));
        }
      }
      else {
        ((HashSet)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).kzP));
      }
    }
    ((HashSet)localObject4).addAll(((HashMap)localObject2).values());
    this.kyU.kyT.commit();
    this.kyU.kyT.beginTransaction();
    this.kyV = ((HashSet)localObject1).size();
    this.add = ((HashSet)localObject4).size();
    localObject2 = ((HashSet)localObject4).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
      localObject4 = this.kyU;
      ((b)localObject4).kyT.a(262144, 1, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_title);
      localObject5 = d.aD(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_title, false);
      if (!bk.bl((String)localObject5)) {
        ((b)localObject4).kyT.a(262144, 2, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_timestamp, (String)localObject5);
      }
      localObject5 = d.aD(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_title, true);
      if (!bk.bl((String)localObject5)) {
        ((b)localObject4).kyT.a(262144, 3, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_timestamp, (String)localObject5);
      }
      ((b)localObject4).kyT.a(262144, 4, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_tag);
      ((PluginFTS)g.t(PluginFTS.class)).getTopHitsLogic().Ed(String.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId));
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      this.kyU.kyT.c(com.tencent.mm.plugin.fts.a.c.kuP, Long.valueOf(((Integer)localObject2).intValue()).longValue());
    }
    this.kyU.kyT.commit();
    return true;
  }
  
  public final int getId()
  {
    return 5;
  }
  
  public final String getName()
  {
    return "BuildFeatureIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b.a
 * JD-Core Version:    0.7.0.1
 */