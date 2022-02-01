package com.tencent.mm.plugin.finder.live.storage;

import android.database.Cursor;
import com.tencent.c.a.a.a.d.a.c;
import com.tencent.c.a.a.a.d.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cm;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bbw;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLastRewardInfoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLastRewardInfoStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "delByLiveId", "", "liveId", "", "getByLiveId", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRecentRewardOnlineMember;", "insertOrUpdate", "infoList", "plugin-finder-live_release"})
public final class d
  extends com.tencent.c.a.a.a.d.d
{
  private final ISQLiteDatabase db;
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.access$getInfo$cp(), "FinderLiveLastRewardInfo", cm.INDEX_CREATE);
    AppMethodBeat.i(233428);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(233428);
  }
  
  public final LinkedList<bbv> aCI(String paramString)
  {
    AppMethodBeat.i(233420);
    p.k(paramString, "liveId");
    paramString = "select *, rowid from FinderLiveLastRewardInfo where liveId = '" + paramString + "'";
    Object localObject = this.db.rawQuery(paramString, null);
    p.j(localObject, "db.rawQuery(sql, null)");
    paramString = new c();
    if (((Cursor)localObject).moveToFirst()) {
      paramString.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    int i;
    if (paramString.systemRowid != -1L)
    {
      i = 1;
      if (i == 0) {
        break label142;
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        localObject = new bbw();
        ((bbw)localObject).parseFrom(paramString.field_lastRewardInfo);
        localObject = ((bbw)localObject).SHn;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = null;
      }
      AppMethodBeat.o(233420);
      return paramString;
      i = 0;
      break;
      label142:
      paramString = null;
    }
  }
  
  public final void aCJ(String paramString)
  {
    AppMethodBeat.i(233422);
    p.k(paramString, "liveId");
    paramString = "DELETE FROM FinderLiveLastRewardInfo WHERE liveId = '" + paramString + '\'';
    this.db.execSQL("FinderLiveLastRewardInfo", paramString);
    AppMethodBeat.o(233422);
  }
  
  public final void e(String paramString, LinkedList<bbv> paramLinkedList)
  {
    AppMethodBeat.i(233424);
    p.k(paramString, "liveId");
    p.k(paramLinkedList, "infoList");
    c localc = new c();
    localc.field_liveId = paramString;
    paramString = new bbw();
    paramString.SHn = paramLinkedList;
    localc.field_lastRewardInfo = paramString.toByteArray();
    replace((IAutoDBItem)localc);
    AppMethodBeat.o(233424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.d
 * JD-Core Version:    0.7.0.1
 */