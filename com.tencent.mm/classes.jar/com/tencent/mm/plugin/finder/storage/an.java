package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.df;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderSnsKeyWordsStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/storage/FinderSnsKeyWordsJumpConfig;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "getByLocalId", "localId", "", "insertOrUpdate", "", "info", "isExit", "", "removeAllInfo", "", "isNotify", "removeInfo", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
  extends MAutoStorage<am>
{
  public static final a FMw;
  private static final String[] SQL_CREATE;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(339422);
    FMw = new a((byte)0);
    am.a locala = am.FMv;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(am.access$getInfo$cp(), "FinderSnsKeyWordsJumpConfig") };
    AppMethodBeat.o(339422);
  }
  
  public an(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, am.access$getInfo$cp(), "FinderSnsKeyWordsJumpConfig", df.INDEX_CREATE);
    AppMethodBeat.i(339409);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(339409);
  }
  
  /* Error */
  private boolean qe(long paramLong)
  {
    // Byte code:
    //   0: ldc 104
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 106	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 108
    //   11: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: lload_1
    //   15: invokevirtual 115	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   18: ldc 117
    //   20: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore 5
    //   28: aload_0
    //   29: getfield 99	com/tencent/mm/plugin/finder/storage/an:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   32: aload 5
    //   34: aconst_null
    //   35: invokeinterface 130 3 0
    //   40: checkcast 132	java/io/Closeable
    //   43: astore 5
    //   45: aload 5
    //   47: checkcast 134	android/database/Cursor
    //   50: invokeinterface 138 1 0
    //   55: istore_3
    //   56: iload_3
    //   57: ifle +20 -> 77
    //   60: iconst_1
    //   61: istore 4
    //   63: aload 5
    //   65: aconst_null
    //   66: invokestatic 143	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   69: ldc 104
    //   71: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: iload 4
    //   76: ireturn
    //   77: iconst_0
    //   78: istore 4
    //   80: goto -17 -> 63
    //   83: astore 6
    //   85: ldc 104
    //   87: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload 6
    //   92: athrow
    //   93: astore 7
    //   95: aload 5
    //   97: aload 6
    //   99: invokestatic 143	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   102: ldc 104
    //   104: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload 7
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	an
    //   0	110	1	paramLong	long
    //   55	2	3	i	int
    //   61	18	4	bool	boolean
    //   26	70	5	localObject1	Object
    //   83	15	6	localThrowable	java.lang.Throwable
    //   93	15	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   45	56	83	finally
    //   85	93	93	finally
  }
  
  public final void a(am paramam)
  {
    AppMethodBeat.i(339430);
    s.u(paramam, "info");
    Log.i("Finder.FinderSnsKeyWordsStorage", s.X("insert, localId:", Long.valueOf(paramam.field_localId)));
    if (qe(paramam.field_localId))
    {
      ContentValues localContentValues = paramam.convertTo();
      localContentValues.remove("rowid");
      Log.i("Finder.FinderSnsKeyWordsStorage", s.X("update, result:", Integer.valueOf(this.db.update("FinderSnsKeyWordsJumpConfig", localContentValues, "localId=?", new String[] { s.X("", Long.valueOf(paramam.field_localId)) }))));
      AppMethodBeat.o(339430);
      return;
    }
    Log.i("Finder.FinderSnsKeyWordsStorage", s.X("insert, result:", Boolean.valueOf(super.insertNotify((IAutoDBItem)paramam, false))));
    AppMethodBeat.o(339430);
  }
  
  public final List<am> eZt()
  {
    AppMethodBeat.i(339448);
    Object localObject = new ArrayList();
    Cursor localCursor = this.db.rawQuery("select * from FinderSnsKeyWordsJumpConfig", null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        am localam = new am();
        localam.convertFrom(localCursor);
        ((ArrayList)localObject).add(localam);
      }
      localCursor.close();
    }
    Log.i("Finder.FinderSnsKeyWordsStorage", s.X("getAllData size:", Integer.valueOf(((ArrayList)localObject).size())));
    localObject = (List)localObject;
    AppMethodBeat.o(339448);
    return localObject;
  }
  
  public final int ud(boolean paramBoolean)
  {
    AppMethodBeat.i(339437);
    int i = this.db.delete("FinderSnsKeyWordsJumpConfig", null, null);
    if (paramBoolean) {
      doNotify("SnsHotWord remove data");
    }
    Log.i("Finder.FinderSnsKeyWordsStorage", s.X("removeAllInfo , result:", Integer.valueOf(i)));
    AppMethodBeat.o(339437);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderSnsKeyWordsStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.an
 * JD-Core Version:    0.7.0.1
 */