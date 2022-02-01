package com.tencent.mm.plugin.finder.live.storage;

import android.database.Cursor;
import com.tencent.d.a.a.a.d.a.h;
import com.tencent.d.a.a.a.d.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cq;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveConfigStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveConfigStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "SELECT_BEGIN", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getBeautyConfig", "Lcom/tencent/mm/protocal/protobuf/LiveBeautyConfig;", "getFilterConfig", "Lcom/tencent/mm/protocal/protobuf/LiveFilterConfig;", "remove", "", "key", "replace", "", "item", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveSetting;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.d.a.a.a.d.c
{
  public static final a DHt;
  private static final String TAG;
  private final String DHu;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(351387);
    DHt = new a((byte)0);
    TAG = "Finder.FinderLiveConfigStorage";
    AppMethodBeat.o(351387);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, h.access$getInfo$cp(), "FinderLiveConfig", cq.INDEX_CREATE);
    AppMethodBeat.i(351374);
    this.db = paramISQLiteDatabase;
    this.DHu = "select * from FinderLiveConfig ";
    AppMethodBeat.o(351374);
  }
  
  public final din etW()
  {
    AppMethodBeat.i(351401);
    Object localObject2 = new h();
    din localdin = new din();
    Object localObject1 = s.X(this.DHu, " where FinderLiveConfig.key=\"KEY_FILTER_CONFIG\"");
    localObject1 = this.db.rawQuery((String)localObject1, null, 2);
    if (((Cursor)localObject1).moveToFirst())
    {
      ((h)localObject2).convertFrom((Cursor)localObject1);
      a locala = (a)localdin;
      localObject2 = ((h)localObject2).field_value;
      try
      {
        locala.parseFrom((byte[])localObject2);
        ((Cursor)localObject1).close();
        AppMethodBeat.o(351401);
        return localdin;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
        }
      }
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(351401);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveConfigStorage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.c
 * JD-Core Version:    0.7.0.1
 */