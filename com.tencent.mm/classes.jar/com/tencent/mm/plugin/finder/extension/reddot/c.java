package com.tencent.mm.plugin.finder.extension.reddot;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ch;
import com.tencent.mm.f.c.cu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "delete", "", "item", "isNotify", "keys", "", "", "(Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;Z[Ljava/lang/String;)Z", "deleteAll", "insertDataForTest", "", "count", "", "isExist", "id", "optMsgInfo", "timeStamp", "", "tipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "optPostRedDot", "queryAll", "Ljava/util/LinkedList;", "replace", "update", "Companion", "plugin-finder_release"})
public final class c
  extends MAutoStorage<l>
{
  private static final String[] SQL_CREATE;
  public static final a xsA;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(178147);
    xsA = new a((byte)0);
    l.a locala = l.xuN;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(l.access$getInfo$cp(), "FinderRedDotInfo") };
    AppMethodBeat.o(178147);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, l.access$getInfo$cp(), "FinderRedDotInfo", cu.INDEX_CREATE);
    AppMethodBeat.i(178146);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(178146);
  }
  
  private boolean a(l paraml, boolean paramBoolean)
  {
    bool1 = true;
    AppMethodBeat.i(274437);
    if (paraml == null)
    {
      Log.i("Finder.RedDotCtrInfoStorage", "[replace] failure!");
      AppMethodBeat.o(274437);
      return false;
    }
    Object localObject = paraml.field_tipsId;
    p.j(localObject, "item.field_tipsId");
    p.k(localObject, "id");
    localObject = "select * from FinderRedDotInfo  where tipsId = '" + (String)localObject + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    p.j(localObject, "cursor");
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
        p.k(paraml, "item");
        if (this.db.update(getTableName(), paraml.convertTo(), "tipsId = ?", new String[] { paraml.field_tipsId }) <= 0) {
          continue;
        }
        if ((bool1) && (paramBoolean)) {
          doNotify("update");
        }
        Log.i("Finder.RedDotCtrInfoStorage", "[update] ret=" + bool1 + " item=" + paraml.field_tipsId + " isNotify=" + paramBoolean);
      }
      catch (Exception localException)
      {
        label280:
        Log.printErrStackTrace("Finder.RedDotCtrInfoStorage", (Throwable)localException, "tipsId=" + paraml.field_tipsId + " type=" + paraml.field_ctrType, new Object[0]);
        ch localch = new ch();
        localch.mh("1");
        localch.fk(10003L);
        localch.bpa();
        bool1 = false;
        continue;
      }
      Log.i("Finder.RedDotCtrInfoStorage", "[replace] ret=" + bool1 + " isExist=" + bool2 + " item=" + paraml.field_tipsId + " isNotify=" + paramBoolean);
      AppMethodBeat.o(274437);
      return bool1;
      bool2 = false;
      break;
      bool1 = false;
      continue;
      bool1 = insertNotify((IAutoDBItem)paraml, paramBoolean);
    }
  }
  
  /* Error */
  public final java.util.LinkedList<l> dqx()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 257
    //   6: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   12: lstore_1
    //   13: new 265	java/util/LinkedList
    //   16: dup
    //   17: invokespecial 266	java/util/LinkedList:<init>	()V
    //   20: astore 4
    //   22: aload_0
    //   23: invokevirtual 270	com/tencent/mm/plugin/finder/extension/reddot/c:getAll	()Landroid/database/Cursor;
    //   26: astore 6
    //   28: aload 6
    //   30: ifnull +74 -> 104
    //   33: aload 6
    //   35: checkcast 272	java/io/Closeable
    //   38: astore 6
    //   40: aload 6
    //   42: checkcast 156	android/database/Cursor
    //   45: astore 7
    //   47: aload 7
    //   49: invokeinterface 275 1 0
    //   54: istore_3
    //   55: iload_3
    //   56: ifeq +37 -> 93
    //   59: new 66	com/tencent/mm/plugin/finder/extension/reddot/l
    //   62: dup
    //   63: invokespecial 276	com/tencent/mm/plugin/finder/extension/reddot/l:<init>	()V
    //   66: astore 8
    //   68: aload 8
    //   70: aload 7
    //   72: invokevirtual 280	com/tencent/mm/plugin/finder/extension/reddot/l:convertFrom	(Landroid/database/Cursor;)V
    //   75: aload 4
    //   77: aload 8
    //   79: invokevirtual 284	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload 7
    //   85: invokeinterface 287 1 0
    //   90: ifne -31 -> 59
    //   93: getstatic 293	kotlin/x:aazN	Lkotlin/x;
    //   96: astore 7
    //   98: aload 6
    //   100: aconst_null
    //   101: invokestatic 298	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   104: ldc 112
    //   106: new 131	java/lang/StringBuilder
    //   109: dup
    //   110: ldc_w 300
    //   113: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   119: lload_1
    //   120: lsub
    //   121: invokevirtual 303	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   124: ldc_w 305
    //   127: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: ldc_w 257
    //   139: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload 4
    //   144: areturn
    //   145: astore 8
    //   147: ldc 112
    //   149: aload 8
    //   151: checkcast 201	java/lang/Throwable
    //   154: ldc_w 306
    //   157: iconst_0
    //   158: anewarray 214	java/lang/Object
    //   161: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: goto -81 -> 83
    //   167: astore 5
    //   169: ldc_w 257
    //   172: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload 5
    //   177: athrow
    //   178: astore 4
    //   180: aload 6
    //   182: aload 5
    //   184: invokestatic 298	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   187: ldc_w 257
    //   190: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload 4
    //   195: athrow
    //   196: astore 4
    //   198: goto -18 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	c
    //   12	108	1	l	long
    //   54	2	3	bool	boolean
    //   20	123	4	localLinkedList	java.util.LinkedList
    //   178	16	4	localObject1	Object
    //   196	1	4	localObject2	Object
    //   1	1	5	localObject3	Object
    //   167	16	5	localThrowable	Throwable
    //   26	155	6	localObject4	Object
    //   45	52	7	localObject5	Object
    //   66	12	8	locall	l
    //   145	5	8	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   59	83	145	java/lang/Exception
    //   40	55	167	java/lang/Throwable
    //   59	83	167	java/lang/Throwable
    //   83	93	167	java/lang/Throwable
    //   93	98	167	java/lang/Throwable
    //   147	164	167	java/lang/Throwable
    //   169	178	178	finally
    //   40	55	196	finally
    //   59	83	196	finally
    //   83	93	196	finally
    //   93	98	196	finally
    //   147	164	196	finally
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.c
 * JD-Core Version:    0.7.0.1
 */