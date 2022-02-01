package com.tencent.mm.plugin.finder.live.storage;

import android.database.Cursor;
import com.tencent.c.a.a.a.d.a.f;
import com.tencent.c.a.a.a.d.a.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.f.c.ck;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveConfigStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveConfigStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "SELECT_BEGIN", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getBeautyConfig", "Lcom/tencent/mm/protocal/protobuf/LiveBeautyConfig;", "getFilterConfig", "Lcom/tencent/mm/protocal/protobuf/LiveFilterConfig;", "remove", "", "key", "replace", "", "item", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveSetting;", "Companion", "plugin-finder-live_release"})
public final class b
  extends com.tencent.c.a.a.a.d.b
{
  private static final String TAG = "Finder.FinderLiveConfigStorage";
  public static final a yOf;
  private final ISQLiteDatabase db;
  private final String yOe;
  
  static
  {
    AppMethodBeat.i(232998);
    yOf = new a((byte)0);
    TAG = "Finder.FinderLiveConfigStorage";
    AppMethodBeat.o(232998);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.access$getInfo$cp(), "FinderLiveConfig", ck.INDEX_CREATE);
    AppMethodBeat.i(232997);
    this.db = paramISQLiteDatabase;
    this.yOe = "select * from FinderLiveConfig ";
    AppMethodBeat.o(232997);
  }
  
  public final crp dDM()
  {
    AppMethodBeat.i(232996);
    Object localObject2 = new f();
    crp localcrp = new crp();
    Object localObject1 = this.yOe + " where FinderLiveConfig.key=\"KEY_FILTER_CONFIG\"";
    localObject1 = this.db.rawQuery((String)localObject1, null, 2);
    if (((Cursor)localObject1).moveToFirst())
    {
      ((f)localObject2).convertFrom((Cursor)localObject1);
      a locala = (a)localcrp;
      localObject2 = ((f)localObject2).field_value;
      try
      {
        locala.parseFrom((byte[])localObject2);
        ((Cursor)localObject1).close();
        AppMethodBeat.o(232996);
        return localcrp;
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
    AppMethodBeat.o(232996);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveConfigStorage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder-live_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.b
 * JD-Core Version:    0.7.0.1
 */