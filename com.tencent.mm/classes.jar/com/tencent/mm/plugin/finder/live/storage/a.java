package com.tencent.mm.plugin.finder.live.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.co;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveActionRecordStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveActionRecordStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "hadEverAction", "", "anchorUserName", "", "action", "Lcom/tencent/plugin/finder/live/api/constants/ConstantsFinderLive$FinderLiveAction;", "makeTag", "recordAction", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.d.a.a.a.d.a
{
  private static final a DHn;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(351372);
    DHn = new a((byte)0);
    AppMethodBeat.o(351372);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.d.a.a.a.d.a.a.access$getInfo$cp(), "FinderLiveActionRecord", co.INDEX_CREATE);
    AppMethodBeat.i(351353);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(351353);
  }
  
  private static String c(String paramString, com.tencent.d.a.a.a.b.a.a parama)
  {
    AppMethodBeat.i(351362);
    paramString = MD5Util.getMD5String(paramString) + '_' + parama.ordinal();
    AppMethodBeat.o(351362);
    return paramString;
  }
  
  public final void a(String paramString, com.tencent.d.a.a.a.b.a.a parama)
  {
    AppMethodBeat.i(351385);
    s.u(paramString, "anchorUserName");
    s.u(parama, "action");
    paramString = c(paramString, parama);
    try
    {
      parama = new com.tencent.d.a.a.a.d.a.a();
      parama.field_actionTag = paramString;
      parama.field_actionTime = Util.nowMilliSecond();
      ah localah = ah.aiuX;
      boolean bool = replace((IAutoDBItem)parama);
      Log.d("Finder.FinderLiveActionRecordStorage", "recordAction tag:" + paramString + " suc:" + bool);
      paramString = ah.aiuX;
      return;
    }
    finally
    {
      AppMethodBeat.o(351385);
    }
  }
  
  public final boolean b(String paramString, com.tencent.d.a.a.a.b.a.a parama)
  {
    AppMethodBeat.i(351396);
    s.u(paramString, "anchorUserName");
    s.u(parama, "action");
    paramString = c(paramString, parama);
    try
    {
      parama = new com.tencent.d.a.a.a.d.a.a();
      parama.field_actionTag = paramString;
      ah localah = ah.aiuX;
      boolean bool = get((IAutoDBItem)parama, new String[0]);
      Log.d("Finder.FinderLiveActionRecordStorage", "hadEverAction tag:" + paramString + " suc:" + bool);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(351396);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveActionRecordStorage$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.a
 * JD-Core Version:    0.7.0.1
 */