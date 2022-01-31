package com.tencent.mm.plugin.expt.roomexpt;

import android.database.Cursor;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends i<e>
{
  public static final String[] cqY = new String[0];
  public static final String[] dXp = { i.a(e.buS, "RoomMuteExpt"), "CREATE UNIQUE INDEX IF NOT EXISTS namedayIndex ON RoomMuteExpt( chatroom,daySec )" };
  com.tencent.mm.sdk.e.e dXw;
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, e.buS, "RoomMuteExpt", cqY);
    this.dXw = parame;
  }
  
  public final Cursor aNh()
  {
    try
    {
      Cursor localCursor = this.dXw.rawQuery("SELECT chatroom, nickname, isMute, count(daySec), sum(score) FROM RoomMuteExpt group by chatroom", null);
      return localCursor;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.ChatRoomExptStorage", localException, "get calc cursor", new Object[0]);
    }
    return null;
  }
  
  /* Error */
  public final java.util.List<e> aNi()
  {
    // Byte code:
    //   0: new 68	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 70	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 40	com/tencent/mm/plugin/expt/roomexpt/b:dXw	Lcom/tencent/mm/sdk/e/e;
    //   13: ldc 22
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: ldc 72
    //   22: invokeinterface 76 8 0
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull +73 -> 102
    //   32: aload_2
    //   33: astore_1
    //   34: aload_2
    //   35: invokeinterface 82 1 0
    //   40: ifeq +62 -> 102
    //   43: aload_2
    //   44: astore_1
    //   45: new 16	com/tencent/mm/plugin/expt/roomexpt/e
    //   48: dup
    //   49: invokespecial 83	com/tencent/mm/plugin/expt/roomexpt/e:<init>	()V
    //   52: astore_3
    //   53: aload_2
    //   54: astore_1
    //   55: aload_3
    //   56: aload_2
    //   57: invokevirtual 87	com/tencent/mm/plugin/expt/roomexpt/e:d	(Landroid/database/Cursor;)V
    //   60: aload_2
    //   61: astore_1
    //   62: aload 4
    //   64: aload_3
    //   65: invokeinterface 93 2 0
    //   70: pop
    //   71: goto -39 -> 32
    //   74: astore_3
    //   75: aload_2
    //   76: astore_1
    //   77: ldc 54
    //   79: aload_3
    //   80: ldc 95
    //   82: iconst_0
    //   83: anewarray 58	java/lang/Object
    //   86: invokestatic 64	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload_2
    //   90: ifnull +9 -> 99
    //   93: aload_2
    //   94: invokeinterface 98 1 0
    //   99: aload 4
    //   101: areturn
    //   102: aload_2
    //   103: ifnull -4 -> 99
    //   106: aload_2
    //   107: invokeinterface 98 1 0
    //   112: aload 4
    //   114: areturn
    //   115: astore_2
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull +9 -> 128
    //   122: aload_1
    //   123: invokeinterface 98 1 0
    //   128: aload_2
    //   129: athrow
    //   130: astore_2
    //   131: goto -13 -> 118
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_2
    //   137: goto -62 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	b
    //   33	90	1	localCursor1	Cursor
    //   27	80	2	localCursor2	Cursor
    //   115	14	2	localObject1	Object
    //   130	1	2	localObject2	Object
    //   136	1	2	localObject3	Object
    //   52	13	3	locale	e
    //   74	6	3	localException1	Exception
    //   134	1	3	localException2	Exception
    //   7	106	4	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   34	43	74	java/lang/Exception
    //   45	53	74	java/lang/Exception
    //   55	60	74	java/lang/Exception
    //   62	71	74	java/lang/Exception
    //   9	28	115	finally
    //   34	43	130	finally
    //   45	53	130	finally
    //   55	60	130	finally
    //   62	71	130	finally
    //   77	89	130	finally
    //   9	28	134	java/lang/Exception
  }
  
  public final boolean b(e parame)
  {
    return super.a(parame, false);
  }
  
  public final boolean c(e parame)
  {
    if (parame == null) {
      return false;
    }
    return super.b(parame, false, new String[] { "chatroom", "daySec" });
  }
  
  /* Error */
  public final e cX(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/mm/plugin/expt/roomexpt/b:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc 22
    //   6: aconst_null
    //   7: ldc 117
    //   9: iconst_2
    //   10: anewarray 14	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: aload_2
    //   20: aastore
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokeinterface 76 8 0
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +119 -> 150
    //   34: aload_2
    //   35: astore_3
    //   36: aload_2
    //   37: invokeinterface 120 1 0
    //   42: ifeq +108 -> 150
    //   45: aload_2
    //   46: astore_3
    //   47: new 16	com/tencent/mm/plugin/expt/roomexpt/e
    //   50: dup
    //   51: invokespecial 83	com/tencent/mm/plugin/expt/roomexpt/e:<init>	()V
    //   54: astore_1
    //   55: aload_2
    //   56: astore_3
    //   57: aload_1
    //   58: aload_2
    //   59: invokevirtual 87	com/tencent/mm/plugin/expt/roomexpt/e:d	(Landroid/database/Cursor;)V
    //   62: aload_1
    //   63: astore_3
    //   64: aload_2
    //   65: ifnull +11 -> 76
    //   68: aload_2
    //   69: invokeinterface 98 1 0
    //   74: aload_1
    //   75: astore_3
    //   76: aload_3
    //   77: areturn
    //   78: astore 4
    //   80: aconst_null
    //   81: astore_2
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_2
    //   85: astore_3
    //   86: ldc 54
    //   88: ldc 122
    //   90: iconst_1
    //   91: anewarray 58	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload 4
    //   98: invokevirtual 126	java/lang/Exception:toString	()Ljava/lang/String;
    //   101: aastore
    //   102: invokestatic 130	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: aload_1
    //   106: astore_3
    //   107: aload_2
    //   108: ifnull -32 -> 76
    //   111: aload_2
    //   112: invokeinterface 98 1 0
    //   117: aload_1
    //   118: areturn
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_3
    //   122: aload_3
    //   123: ifnull +9 -> 132
    //   126: aload_3
    //   127: invokeinterface 98 1 0
    //   132: aload_1
    //   133: athrow
    //   134: astore_1
    //   135: goto -13 -> 122
    //   138: astore 4
    //   140: aconst_null
    //   141: astore_1
    //   142: goto -58 -> 84
    //   145: astore 4
    //   147: goto -63 -> 84
    //   150: aconst_null
    //   151: astore_1
    //   152: goto -90 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	b
    //   0	155	1	paramString1	String
    //   0	155	2	paramString2	String
    //   35	92	3	str	String
    //   78	19	4	localException1	Exception
    //   138	1	4	localException2	Exception
    //   145	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	30	78	java/lang/Exception
    //   0	30	119	finally
    //   36	45	134	finally
    //   47	55	134	finally
    //   57	62	134	finally
    //   86	105	134	finally
    //   36	45	138	java/lang/Exception
    //   47	55	138	java/lang/Exception
    //   57	62	145	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.b
 * JD-Core Version:    0.7.0.1
 */