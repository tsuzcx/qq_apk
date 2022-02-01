package com.tencent.mm.plugin.finder.live.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveActionRecordStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveActionRecordStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "hadEverAction", "", "anchorUserName", "", "action", "Lcom/tencent/plugin/finder/live/api/constants/ConstantsFinderLive$FinderLiveAction;", "makeTag", "recordAction", "", "Companion", "plugin-finder-live_release"})
public final class a
  extends com.tencent.c.a.a.a.d.a
{
  @Deprecated
  public static final a yOd;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(233980);
    yOd = new a((byte)0);
    AppMethodBeat.o(233980);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.c.a.a.a.d.a.a.access$getInfo$cp(), "FinderLiveActionRecord", cj.INDEX_CREATE);
    AppMethodBeat.i(233978);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(233978);
  }
  
  private static String c(String paramString, com.tencent.c.a.a.a.b.a.a parama)
  {
    AppMethodBeat.i(233976);
    paramString = MD5Util.getMD5String(paramString) + '_' + parama.ordinal();
    AppMethodBeat.o(233976);
    return paramString;
  }
  
  public final void a(String paramString, com.tencent.c.a.a.a.b.a.a parama)
  {
    AppMethodBeat.i(233973);
    p.k(paramString, "anchorUserName");
    p.k(parama, "action");
    paramString = c(paramString, parama);
    try
    {
      parama = new com.tencent.c.a.a.a.d.a.a();
      parama.field_actionTag = paramString;
      parama.field_actionTime = Util.nowMilliSecond();
      boolean bool = replace((IAutoDBItem)parama);
      Log.d("Finder.FinderLiveActionRecordStorage", "recordAction tag:" + paramString + " suc:" + bool);
      paramString = x.aazN;
      return;
    }
    finally
    {
      AppMethodBeat.o(233973);
    }
  }
  
  public final boolean b(String paramString, com.tencent.c.a.a.a.b.a.a parama)
  {
    AppMethodBeat.i(233974);
    p.k(paramString, "anchorUserName");
    p.k(parama, "action");
    paramString = c(paramString, parama);
    try
    {
      parama = new com.tencent.c.a.a.a.d.a.a();
      parama.field_actionTag = paramString;
      boolean bool = get((IAutoDBItem)parama, new String[0]);
      Log.d("Finder.FinderLiveActionRecordStorage", "hadEverAction tag:" + paramString + " suc:" + bool);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(233974);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveActionRecordStorage$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.a
 * JD-Core Version:    0.7.0.1
 */