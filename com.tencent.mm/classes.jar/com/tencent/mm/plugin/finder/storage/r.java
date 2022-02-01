package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLiveConfigStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveConfig;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "SELECT_BEGIN", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getBeautyConfig", "Lcom/tencent/mm/protocal/protobuf/LiveBeautyConfig;", "getFilterConfig", "Lcom/tencent/mm/protocal/protobuf/LiveFilterConfig;", "remove", "", "key", "replace", "", "item", "Companion", "plugin-finder_release"})
public final class r
  extends MAutoStorage<q>
{
  private static final String[] SQL_CREATE;
  private static final String TABLE_NAME = "FinderLiveConfig";
  private static final String TAG = "Finder.FinderLiveConfigStorage";
  public static final a vEh;
  private final ISQLiteDatabase db;
  private final String vEg;
  
  static
  {
    AppMethodBeat.i(251795);
    vEh = new a((byte)0);
    TAG = "Finder.FinderLiveConfigStorage";
    TABLE_NAME = "FinderLiveConfig";
    q.a locala = q.vEf;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(q.access$getInfo$cp(), "FinderLiveConfig") };
    AppMethodBeat.o(251795);
  }
  
  public r(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, q.access$getInfo$cp(), "FinderLiveConfig", ci.INDEX_CREATE);
    AppMethodBeat.i(251794);
    this.db = paramISQLiteDatabase;
    this.vEg = ("select * from " + TABLE_NAME + ' ');
    AppMethodBeat.o(251794);
  }
  
  public final boolean a(q paramq)
  {
    AppMethodBeat.i(251790);
    p.h(paramq, "item");
    boolean bool = super.replace((IAutoDBItem)paramq);
    Log.i(TAG, "insert " + paramq.field_key + ", ret:" + bool);
    AppMethodBeat.o(251790);
    return bool;
  }
  
  public final cir dxK()
  {
    AppMethodBeat.i(251792);
    Object localObject2 = new q();
    cir localcir = new cir();
    Object localObject1 = this.vEg + " where " + TABLE_NAME + ".key=\"KEY_BEAUTY_CONFIG\"";
    localObject1 = this.db.rawQuery((String)localObject1, null, 2);
    if (((Cursor)localObject1).moveToFirst())
    {
      ((q)localObject2).convertFrom((Cursor)localObject1);
      a locala = (a)localcir;
      localObject2 = ((q)localObject2).field_value;
      try
      {
        locala.parseFrom((byte[])localObject2);
        ((Cursor)localObject1).close();
        AppMethodBeat.o(251792);
        return localcir;
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
    AppMethodBeat.o(251792);
    return null;
  }
  
  public final ciu dxL()
  {
    AppMethodBeat.i(251793);
    Object localObject2 = new q();
    ciu localciu = new ciu();
    Object localObject1 = this.vEg + " where " + TABLE_NAME + ".key=\"KEY_FILTER_CONFIG\"";
    localObject1 = this.db.rawQuery((String)localObject1, null, 2);
    if (((Cursor)localObject1).moveToFirst())
    {
      ((q)localObject2).convertFrom((Cursor)localObject1);
      a locala = (a)localciu;
      localObject2 = ((q)localObject2).field_value;
      try
      {
        locala.parseFrom((byte[])localObject2);
        ((Cursor)localObject1).close();
        AppMethodBeat.o(251793);
        return localciu;
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
    AppMethodBeat.o(251793);
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLiveConfigStorage$Companion;", "", "()V", "KEY_BEAUTY_CONFIG", "", "KEY_FILTER_CONFIG", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "getTABLE_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.r
 * JD-Core Version:    0.7.0.1
 */