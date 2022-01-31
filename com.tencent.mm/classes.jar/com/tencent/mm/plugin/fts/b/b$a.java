package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class b$a
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int mUK;
  private int mUL;
  
  private b$a(b paramb) {}
  
  public final String aAn()
  {
    AppMethodBeat.i(136720);
    String str = String.format("{remove: %d add: %d}", new Object[] { Integer.valueOf(this.mUK), Integer.valueOf(this.mUL) });
    AppMethodBeat.o(136720);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136719);
    ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
    Object localObject1 = this.mUJ.mUI;
    Object localObject2 = new ArrayList();
    Object localObject3 = String.format("SELECT * FROM Feature", new Object[0]);
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).mQr.rawQuery((String)localObject3, null);
    while (((Cursor)localObject1).moveToNext())
    {
      localObject3 = new com.tencent.mm.plugin.fts.a.a.c();
      ((com.tencent.mm.plugin.fts.a.a.c)localObject3).convertFrom((Cursor)localObject1);
      ((List)localObject2).add(localObject3);
    }
    ((Cursor)localObject1).close();
    localObject1 = localObject2;
    if (((List)localObject2).size() == 0) {
      localObject1 = localObject2;
    }
    try
    {
      localObject2 = b.Pl(j.p(b.bCl().dQJ()));
      localObject1 = localObject2;
      this.mUJ.mUI.bW((List)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label131:
      Object localObject4;
      Object localObject5;
      break label131;
    }
    localObject3 = this.mUJ.mUI.bCv();
    localObject2 = new HashMap();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject1).next();
      ((HashMap)localObject2).put(Integer.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject4).field_featureId), localObject4);
    }
    if (this.mUJ.mUI.mQr.inTransaction()) {
      this.mUJ.mUI.commit();
    }
    this.mUJ.mUI.beginTransaction();
    localObject1 = new HashSet();
    localObject4 = new HashSet();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (com.tencent.mm.plugin.fts.c.b.a)((Iterator)localObject3).next();
      com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)((HashMap)localObject2).remove(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).mVF));
      if (localc != null)
      {
        if (((com.tencent.mm.plugin.fts.c.b.a)localObject5).timestamp != localc.field_timestamp)
        {
          ((HashSet)localObject4).add(localc);
          this.mUJ.mUI.c(com.tencent.mm.plugin.fts.a.c.mQC, localc.field_featureId);
          ((PluginFTS)g.G(PluginFTS.class)).getTopHitsLogic().d(com.tencent.mm.plugin.fts.a.c.mQC, String.valueOf(localc.field_featureId));
        }
      }
      else {
        ((HashSet)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).mVF));
      }
    }
    ((HashSet)localObject4).addAll(((HashMap)localObject2).values());
    this.mUJ.mUI.commit();
    this.mUJ.mUI.beginTransaction();
    this.mUK = ((HashSet)localObject1).size();
    this.mUL = ((HashSet)localObject4).size();
    localObject2 = ((HashSet)localObject4).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject2).next();
      localObject4 = this.mUJ;
      ((b)localObject4).mUI.a(262144, 1, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_title);
      localObject5 = d.aR(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_title, false);
      if (!bo.isNullOrNil((String)localObject5)) {
        ((b)localObject4).mUI.a(262144, 2, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_timestamp, (String)localObject5);
      }
      localObject5 = d.aR(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_title, true);
      if (!bo.isNullOrNil((String)localObject5)) {
        ((b)localObject4).mUI.a(262144, 3, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_timestamp, (String)localObject5);
      }
      ((b)localObject4).mUI.a(262144, 4, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_tag);
      ((PluginFTS)g.G(PluginFTS.class)).getTopHitsLogic().Pn(String.valueOf(((com.tencent.mm.plugin.fts.a.a.c)localObject3).field_featureId));
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      this.mUJ.mUI.c(com.tencent.mm.plugin.fts.a.c.mQC, ((Integer)localObject2).intValue());
    }
    this.mUJ.mUI.commit();
    AppMethodBeat.o(136719);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b.a
 * JD-Core Version:    0.7.0.1
 */