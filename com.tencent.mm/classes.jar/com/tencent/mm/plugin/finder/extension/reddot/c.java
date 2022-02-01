package com.tencent.mm.plugin.finder.extension.reddot;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.g.c.co;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "delete", "", "item", "isNotify", "keys", "", "", "(Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;Z[Ljava/lang/String;)Z", "deleteAll", "insertDataForTest", "", "count", "", "isExist", "id", "optMsgInfo", "timeStamp", "", "tipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "optPostRedDot", "queryAll", "Ljava/util/LinkedList;", "replace", "update", "Companion", "plugin-finder_release"})
public final class c
  extends MAutoStorage<k>
{
  private static final String[] SQL_CREATE;
  public static final a tJp;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(178147);
    tJp = new a((byte)0);
    k.a locala = k.tLn;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(k.access$getInfo$cp(), "FinderRedDotInfo") };
    AppMethodBeat.o(178147);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, k.access$getInfo$cp(), "FinderRedDotInfo", co.INDEX_CREATE);
    AppMethodBeat.i(178146);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(178146);
  }
  
  private boolean a(k paramk, boolean paramBoolean)
  {
    bool1 = true;
    AppMethodBeat.i(243508);
    if (paramk == null)
    {
      Log.i("Finder.RedDotCtrInfoStorage", "[replace] failure!");
      AppMethodBeat.o(243508);
      return false;
    }
    Object localObject = paramk.field_tipsId;
    p.g(localObject, "item.field_tipsId");
    p.h(localObject, "id");
    localObject = "select * from FinderRedDotInfo  where tipsId = '" + (String)localObject + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    p.g(localObject, "cursor");
    boolean bool2;
    if (((Cursor)localObject).getCount() > 0)
    {
      bool2 = true;
      ((Cursor)localObject).close();
      if (!bool2) {
        break label280;
      }
    }
    for (;;)
    {
      try
      {
        p.h(paramk, "item");
        if (this.db.update(getTableName(), paramk.convertTo(), "tipsId = ?", new String[] { paramk.field_tipsId }) <= 0) {
          continue;
        }
        if ((bool1) && (paramBoolean)) {
          doNotify("update");
        }
        Log.i("Finder.RedDotCtrInfoStorage", "[update] ret=" + bool1 + " item=" + paramk.field_tipsId + " isNotify=" + paramBoolean);
      }
      catch (Exception localException)
      {
        label280:
        Log.printErrStackTrace("Finder.RedDotCtrInfoStorage", (Throwable)localException, "tipsId=" + paramk.field_tipsId + " type=" + paramk.field_ctrType, new Object[0]);
        br localbr = new br();
        localbr.jX("1");
        localbr.ew(10003L);
        localbr.bfK();
        bool1 = false;
        continue;
      }
      Log.i("Finder.RedDotCtrInfoStorage", "[replace] ret=" + bool1 + " isExist=" + bool2 + " item=" + paramk.field_tipsId + " isNotify=" + paramBoolean);
      AppMethodBeat.o(243508);
      return bool1;
      bool2 = false;
      break;
      bool1 = false;
      continue;
      bool1 = insertNotify((IAutoDBItem)paramk, paramBoolean);
    }
  }
  
  /* Error */
  public final java.util.LinkedList<k> daw()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 243
    //   5: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 249	java/lang/System:currentTimeMillis	()J
    //   11: lstore_1
    //   12: new 251	java/util/LinkedList
    //   15: dup
    //   16: invokespecial 252	java/util/LinkedList:<init>	()V
    //   19: astore 4
    //   21: aload_0
    //   22: invokevirtual 256	com/tencent/mm/plugin/finder/extension/reddot/c:getAll	()Landroid/database/Cursor;
    //   25: astore 6
    //   27: aload 6
    //   29: ifnull +74 -> 103
    //   32: aload 6
    //   34: checkcast 258	java/io/Closeable
    //   37: astore 6
    //   39: aload 6
    //   41: checkcast 156	android/database/Cursor
    //   44: astore 7
    //   46: aload 7
    //   48: invokeinterface 261 1 0
    //   53: istore_3
    //   54: iload_3
    //   55: ifeq +37 -> 92
    //   58: new 66	com/tencent/mm/plugin/finder/extension/reddot/k
    //   61: dup
    //   62: invokespecial 262	com/tencent/mm/plugin/finder/extension/reddot/k:<init>	()V
    //   65: astore 8
    //   67: aload 8
    //   69: aload 7
    //   71: invokevirtual 266	com/tencent/mm/plugin/finder/extension/reddot/k:convertFrom	(Landroid/database/Cursor;)V
    //   74: aload 4
    //   76: aload 8
    //   78: invokevirtual 270	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: aload 7
    //   84: invokeinterface 273 1 0
    //   89: ifne -31 -> 58
    //   92: getstatic 279	kotlin/x:SXb	Lkotlin/x;
    //   95: astore 7
    //   97: aload 6
    //   99: aconst_null
    //   100: invokestatic 284	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   103: ldc 112
    //   105: new 131	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 286
    //   112: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: invokestatic 249	java/lang/System:currentTimeMillis	()J
    //   118: lload_1
    //   119: lsub
    //   120: invokevirtual 289	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: ldc_w 291
    //   126: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: ldc 243
    //   137: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload 4
    //   142: areturn
    //   143: astore 8
    //   145: ldc 112
    //   147: aload 8
    //   149: checkcast 201	java/lang/Throwable
    //   152: ldc_w 292
    //   155: iconst_0
    //   156: anewarray 214	java/lang/Object
    //   159: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: goto -80 -> 82
    //   165: astore 5
    //   167: ldc 243
    //   169: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload 5
    //   174: athrow
    //   175: astore 4
    //   177: aload 6
    //   179: aload 5
    //   181: invokestatic 284	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   184: ldc 243
    //   186: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload 4
    //   191: athrow
    //   192: astore 4
    //   194: goto -17 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	c
    //   11	108	1	l	long
    //   53	2	3	bool	boolean
    //   19	122	4	localLinkedList	java.util.LinkedList
    //   175	15	4	localObject1	Object
    //   192	1	4	localObject2	Object
    //   1	1	5	localObject3	Object
    //   165	15	5	localThrowable	Throwable
    //   25	153	6	localObject4	Object
    //   44	52	7	localObject5	Object
    //   65	12	8	localk	k
    //   143	5	8	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   58	82	143	java/lang/Exception
    //   39	54	165	java/lang/Throwable
    //   58	82	165	java/lang/Throwable
    //   82	92	165	java/lang/Throwable
    //   92	97	165	java/lang/Throwable
    //   145	162	165	java/lang/Throwable
    //   167	175	175	finally
    //   39	54	192	finally
    //   58	82	192	finally
    //   82	92	192	finally
    //   92	97	192	finally
    //   145	162	192	finally
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.c
 * JD-Core Version:    0.7.0.1
 */