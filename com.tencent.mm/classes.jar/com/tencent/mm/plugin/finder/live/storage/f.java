package com.tencent.mm.plugin.finder.live.storage;

import android.database.Cursor;
import com.tencent.d.a.a.a.d.a.e;
import com.tencent.d.a.a.a.d.a.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ct;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLastRewardInfoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLastRewardInfoStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "delByLiveId", "", "liveId", "", "getByLiveId", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRecentRewardOnlineMember;", "insertOrUpdate", "infoList", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.d.a.a.a.d.f
{
  private final ISQLiteDatabase db;
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, e.access$getInfo$cp(), "FinderLiveLastRewardInfo", ct.INDEX_CREATE);
    AppMethodBeat.i(351397);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(351397);
  }
  
  public final LinkedList<blq> axJ(String paramString)
  {
    AppMethodBeat.i(351416);
    s.u(paramString, "liveId");
    paramString = "select *, rowid from FinderLiveLastRewardInfo where liveId = '" + paramString + '\'';
    Object localObject = this.db.rawQuery(paramString, null);
    s.s(localObject, "db.rawQuery(sql, null)");
    paramString = new e();
    if (((Cursor)localObject).moveToFirst()) {
      paramString.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    int i;
    if (paramString.systemRowid != -1L)
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
      label96:
      if (paramString != null) {
        break label123;
      }
    }
    for (paramString = null;; paramString = ((blr)localObject).ZKC)
    {
      if (paramString != null) {
        break label148;
      }
      AppMethodBeat.o(351416);
      return null;
      i = 0;
      break;
      label118:
      paramString = null;
      break label96;
      label123:
      localObject = new blr();
      ((blr)localObject).parseFrom(paramString.field_lastRewardInfo);
    }
    label148:
    AppMethodBeat.o(351416);
    return paramString;
  }
  
  public final void axK(String paramString)
  {
    AppMethodBeat.i(351425);
    s.u(paramString, "liveId");
    paramString = "DELETE FROM FinderLiveLastRewardInfo WHERE liveId = '" + paramString + '\'';
    this.db.execSQL("FinderLiveLastRewardInfo", paramString);
    AppMethodBeat.o(351425);
  }
  
  public final void e(String paramString, LinkedList<blq> paramLinkedList)
  {
    AppMethodBeat.i(351434);
    s.u(paramString, "liveId");
    s.u(paramLinkedList, "infoList");
    e locale = new e();
    locale.field_liveId = paramString;
    paramString = new blr();
    paramString.ZKC = paramLinkedList;
    locale.field_lastRewardInfo = paramString.toByteArray();
    replace((IAutoDBItem)locale);
    AppMethodBeat.o(351434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.f
 * JD-Core Version:    0.7.0.1
 */