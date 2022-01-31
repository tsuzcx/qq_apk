package com.tencent.mm.plugin.expt.roomexpt;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends j<e>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(73587);
    SQL_CREATE = new String[] { j.getCreateSQLs(e.info, "RoomMuteExpt"), "CREATE UNIQUE INDEX IF NOT EXISTS namedayIndex ON RoomMuteExpt( chatroom,daySec )" };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(73587);
  }
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, e.info, "RoomMuteExpt", INDEX_CREATE);
    this.db = parame;
  }
  
  public final boolean b(e parame)
  {
    AppMethodBeat.i(73583);
    boolean bool = super.insertNotify(parame, false);
    AppMethodBeat.o(73583);
    return bool;
  }
  
  public final Cursor bta()
  {
    Object localObject = null;
    AppMethodBeat.i(73585);
    try
    {
      Cursor localCursor = this.db.rawQuery("SELECT chatroom, nickname, isMute, count(daySec), sum(score) FROM RoomMuteExpt group by chatroom", null);
      localObject = localCursor;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ChatRoomExptStorage", localException, "get calc cursor", new Object[0]);
      }
    }
    AppMethodBeat.o(73585);
    return localObject;
  }
  
  /* Error */
  public final java.util.List<e> btb()
  {
    // Byte code:
    //   0: ldc 85
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 87	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 89	java/util/ArrayList:<init>	()V
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 50	com/tencent/mm/plugin/expt/roomexpt/b:db	Lcom/tencent/mm/sdk/e/e;
    //   18: ldc 29
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: ldc 91
    //   27: invokeinterface 95 8 0
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +78 -> 112
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokeinterface 101 1 0
    //   45: ifeq +67 -> 112
    //   48: aload_2
    //   49: astore_1
    //   50: new 23	com/tencent/mm/plugin/expt/roomexpt/e
    //   53: dup
    //   54: invokespecial 102	com/tencent/mm/plugin/expt/roomexpt/e:<init>	()V
    //   57: astore_3
    //   58: aload_2
    //   59: astore_1
    //   60: aload_3
    //   61: aload_2
    //   62: invokevirtual 106	com/tencent/mm/plugin/expt/roomexpt/e:convertFrom	(Landroid/database/Cursor;)V
    //   65: aload_2
    //   66: astore_1
    //   67: aload 4
    //   69: aload_3
    //   70: invokeinterface 112 2 0
    //   75: pop
    //   76: goto -39 -> 37
    //   79: astore_3
    //   80: aload_2
    //   81: astore_1
    //   82: ldc 72
    //   84: aload_3
    //   85: ldc 114
    //   87: iconst_0
    //   88: anewarray 76	java/lang/Object
    //   91: invokestatic 82	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_2
    //   95: ifnull +9 -> 104
    //   98: aload_2
    //   99: invokeinterface 117 1 0
    //   104: ldc 85
    //   106: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload 4
    //   111: areturn
    //   112: aload_2
    //   113: ifnull -9 -> 104
    //   116: aload_2
    //   117: invokeinterface 117 1 0
    //   122: goto -18 -> 104
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull +9 -> 138
    //   132: aload_1
    //   133: invokeinterface 117 1 0
    //   138: ldc 85
    //   140: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_2
    //   144: athrow
    //   145: astore_2
    //   146: goto -18 -> 128
    //   149: astore_3
    //   150: aconst_null
    //   151: astore_2
    //   152: goto -72 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	b
    //   38	95	1	localCursor1	Cursor
    //   32	85	2	localCursor2	Cursor
    //   125	19	2	localObject1	Object
    //   145	1	2	localObject2	Object
    //   151	1	2	localObject3	Object
    //   57	13	3	locale	e
    //   79	6	3	localException1	Exception
    //   149	1	3	localException2	Exception
    //   12	98	4	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   39	48	79	java/lang/Exception
    //   50	58	79	java/lang/Exception
    //   60	65	79	java/lang/Exception
    //   67	76	79	java/lang/Exception
    //   14	33	125	finally
    //   39	48	145	finally
    //   50	58	145	finally
    //   60	65	145	finally
    //   67	76	145	finally
    //   82	94	145	finally
    //   14	33	149	java/lang/Exception
  }
  
  public final boolean c(e parame)
  {
    AppMethodBeat.i(73584);
    if (parame == null)
    {
      AppMethodBeat.o(73584);
      return false;
    }
    boolean bool = super.updateNotify(parame, false, new String[] { "chatroom", "daySec" });
    AppMethodBeat.o(73584);
    return bool;
  }
  
  /* Error */
  public final e el(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 50	com/tencent/mm/plugin/expt/roomexpt/b:db	Lcom/tencent/mm/sdk/e/e;
    //   9: ldc 29
    //   11: aconst_null
    //   12: ldc 134
    //   14: iconst_2
    //   15: anewarray 21	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_1
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload_2
    //   25: aastore
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokeinterface 95 8 0
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull +132 -> 168
    //   39: aload_2
    //   40: astore_3
    //   41: aload_2
    //   42: invokeinterface 137 1 0
    //   47: ifeq +121 -> 168
    //   50: aload_2
    //   51: astore_3
    //   52: new 23	com/tencent/mm/plugin/expt/roomexpt/e
    //   55: dup
    //   56: invokespecial 102	com/tencent/mm/plugin/expt/roomexpt/e:<init>	()V
    //   59: astore_1
    //   60: aload_2
    //   61: astore_3
    //   62: aload_1
    //   63: aload_2
    //   64: invokevirtual 106	com/tencent/mm/plugin/expt/roomexpt/e:convertFrom	(Landroid/database/Cursor;)V
    //   67: aload_1
    //   68: astore_3
    //   69: aload_2
    //   70: ifnull +11 -> 81
    //   73: aload_2
    //   74: invokeinterface 117 1 0
    //   79: aload_1
    //   80: astore_3
    //   81: ldc 132
    //   83: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload_3
    //   87: areturn
    //   88: astore 4
    //   90: aconst_null
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_2
    //   95: astore_3
    //   96: ldc 72
    //   98: ldc 139
    //   100: iconst_1
    //   101: anewarray 76	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload 4
    //   108: invokevirtual 143	java/lang/Exception:toString	()Ljava/lang/String;
    //   111: aastore
    //   112: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: aload_1
    //   116: astore_3
    //   117: aload_2
    //   118: ifnull -37 -> 81
    //   121: aload_2
    //   122: invokeinterface 117 1 0
    //   127: aload_1
    //   128: astore_3
    //   129: goto -48 -> 81
    //   132: astore_1
    //   133: aconst_null
    //   134: astore_3
    //   135: aload_3
    //   136: ifnull +9 -> 145
    //   139: aload_3
    //   140: invokeinterface 117 1 0
    //   145: ldc 132
    //   147: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: goto -18 -> 135
    //   156: astore 4
    //   158: aconst_null
    //   159: astore_1
    //   160: goto -66 -> 94
    //   163: astore 4
    //   165: goto -71 -> 94
    //   168: aconst_null
    //   169: astore_1
    //   170: goto -103 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	b
    //   0	173	1	paramString1	String
    //   0	173	2	paramString2	String
    //   40	100	3	str	String
    //   88	19	4	localException1	Exception
    //   156	1	4	localException2	Exception
    //   163	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   5	35	88	java/lang/Exception
    //   5	35	132	finally
    //   41	50	152	finally
    //   52	60	152	finally
    //   62	67	152	finally
    //   96	115	152	finally
    //   41	50	156	java/lang/Exception
    //   52	60	156	java/lang/Exception
    //   62	67	163	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.b
 * JD-Core Version:    0.7.0.1
 */