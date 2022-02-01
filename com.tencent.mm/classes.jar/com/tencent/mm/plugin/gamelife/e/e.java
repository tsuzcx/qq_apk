package com.tencent.mm.plugin.gamelife.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.de;
import com.tencent.mm.plugin.gamelife.b;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clearUnreadCount", "", "sessionId", "", "get", "getHistoryConversation", "getLatestUnreadConversation", "getTotalUnreadCount", "", "getUnreadCount", "markUnread", "query", "", "offset", "nextCount", "queryLimit", "limitCount", "replace", "item", "Companion", "plugin-gamelife_release"})
public final class e
  extends MAutoStorage<a>
{
  public static final e.a DhH;
  private static final String[] SQL_CREATE;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(204167);
    DhH = new e.a((byte)0);
    a.a locala = a.DhB;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), "GameLifeConversation") };
    AppMethodBeat.o(204167);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), "GameLifeConversation", de.INDEX_CREATE);
    AppMethodBeat.i(204166);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(204166);
  }
  
  /* Error */
  private final List<a> hF(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 108
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 110	java/util/LinkedList
    //   11: dup
    //   12: invokespecial 112	java/util/LinkedList:<init>	()V
    //   15: astore_3
    //   16: new 114	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 116
    //   22: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: iload_2
    //   26: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc 125
    //   31: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_1
    //   35: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore 5
    //   43: aload_0
    //   44: getfield 101	com/tencent/mm/plugin/gamelife/e/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   47: aload 5
    //   49: aconst_null
    //   50: invokeinterface 138 3 0
    //   55: checkcast 140	java/io/Closeable
    //   58: astore 5
    //   60: aload 5
    //   62: checkcast 142	android/database/Cursor
    //   65: astore 6
    //   67: aload 6
    //   69: invokeinterface 146 1 0
    //   74: ifeq +79 -> 153
    //   77: aload 6
    //   79: ldc 148
    //   81: invokestatic 151	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   84: aload 6
    //   86: invokeinterface 154 1 0
    //   91: ifne +62 -> 153
    //   94: new 61	com/tencent/mm/plugin/gamelife/e/a
    //   97: dup
    //   98: invokespecial 155	com/tencent/mm/plugin/gamelife/e/a:<init>	()V
    //   101: astore 7
    //   103: aload 7
    //   105: aload 6
    //   107: invokevirtual 159	com/tencent/mm/plugin/gamelife/e/a:convertFrom	(Landroid/database/Cursor;)V
    //   110: aload_3
    //   111: aload 7
    //   113: invokevirtual 163	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   116: pop
    //   117: aload 6
    //   119: invokeinterface 166 1 0
    //   124: pop
    //   125: goto -48 -> 77
    //   128: astore 4
    //   130: ldc 108
    //   132: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload 4
    //   137: athrow
    //   138: astore_3
    //   139: aload 5
    //   141: aload 4
    //   143: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   146: ldc 108
    //   148: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_3
    //   152: athrow
    //   153: getstatic 178	kotlin/x:aazN	Lkotlin/x;
    //   156: astore 6
    //   158: aload 5
    //   160: aconst_null
    //   161: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   164: aload_3
    //   165: checkcast 180	java/util/List
    //   168: astore_3
    //   169: ldc 108
    //   171: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_3
    //   175: areturn
    //   176: astore_3
    //   177: goto -38 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	e
    //   0	180	1	paramInt1	int
    //   0	180	2	paramInt2	int
    //   15	96	3	localLinkedList	java.util.LinkedList
    //   138	27	3	localObject1	Object
    //   168	7	3	localList	List
    //   176	1	3	localObject2	Object
    //   1	1	4	localObject3	Object
    //   128	14	4	localThrowable	java.lang.Throwable
    //   41	118	5	localObject4	Object
    //   65	92	6	localObject5	Object
    //   101	11	7	locala	a
    // Exception table:
    //   from	to	target	type
    //   60	77	128	java/lang/Throwable
    //   77	125	128	java/lang/Throwable
    //   153	158	128	java/lang/Throwable
    //   130	138	138	finally
    //   60	77	176	finally
    //   77	125	176	finally
    //   153	158	176	finally
  }
  
  public final boolean aEI(String paramString)
  {
    AppMethodBeat.i(204158);
    p.k(paramString, "sessionId");
    Object localObject = b.DeG;
    if (!b.a.aKC(paramString))
    {
      AppMethodBeat.o(204158);
      return false;
    }
    localObject = aKN(paramString);
    int i = ((a)localObject).field_unReadCount;
    ((a)localObject).field_unReadCount = 0;
    ((a)localObject).field_digestFlag = 0L;
    ((a)localObject).field_digestPrefix = null;
    boolean bool = update(((a)localObject).systemRowid, (IAutoDBItem)localObject, false);
    doNotify("single", 4, localObject);
    Log.i("GameLife.ConversationStorage", "[clearUnreadCount] ret=" + bool + ' ' + i + " => " + ((a)localObject).field_unReadCount + " sessionId=" + paramString);
    AppMethodBeat.o(204158);
    return bool;
  }
  
  /* Error */
  public final int aEz(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 250
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 186
    //   10: invokestatic 90	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 192	com/tencent/mm/plugin/gamelife/b:DeG	Lcom/tencent/mm/plugin/gamelife/b$a;
    //   16: astore 4
    //   18: aload_1
    //   19: invokestatic 197	com/tencent/mm/plugin/gamelife/b$a:aKC	(Ljava/lang/String;)Z
    //   22: ifne +10 -> 32
    //   25: ldc 250
    //   27: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_0
    //   31: ireturn
    //   32: new 114	java/lang/StringBuilder
    //   35: dup
    //   36: ldc 252
    //   38: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: bipush 39
    //   47: invokevirtual 238	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   50: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore 4
    //   55: aload_0
    //   56: getfield 101	com/tencent/mm/plugin/gamelife/e/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   59: aload 4
    //   61: aconst_null
    //   62: invokeinterface 138 3 0
    //   67: checkcast 140	java/io/Closeable
    //   70: astore 4
    //   72: aload 4
    //   74: checkcast 142	android/database/Cursor
    //   77: astore 5
    //   79: aload 5
    //   81: invokeinterface 146 1 0
    //   86: ifeq +104 -> 190
    //   89: aload 5
    //   91: ldc 148
    //   93: invokestatic 151	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   96: aload 5
    //   98: invokeinterface 154 1 0
    //   103: ifne +87 -> 190
    //   106: aload 5
    //   108: iconst_0
    //   109: invokeinterface 256 2 0
    //   114: istore_2
    //   115: getstatic 178	kotlin/x:aazN	Lkotlin/x;
    //   118: astore 5
    //   120: aload 4
    //   122: aconst_null
    //   123: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   126: ldc 230
    //   128: new 114	java/lang/StringBuilder
    //   131: dup
    //   132: ldc_w 258
    //   135: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: aload_1
    //   139: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: bipush 32
    //   144: invokevirtual 238	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   147: iload_2
    //   148: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 247	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: ldc 250
    //   159: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: iload_2
    //   163: ireturn
    //   164: astore_3
    //   165: ldc 250
    //   167: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_3
    //   171: athrow
    //   172: astore_1
    //   173: aload 4
    //   175: aload_3
    //   176: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   179: ldc 250
    //   181: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_1
    //   185: athrow
    //   186: astore_1
    //   187: goto -14 -> 173
    //   190: iconst_0
    //   191: istore_2
    //   192: goto -77 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	e
    //   0	195	1	paramString	String
    //   114	78	2	i	int
    //   1	1	3	localObject1	Object
    //   164	12	3	localThrowable	java.lang.Throwable
    //   16	158	4	localObject2	Object
    //   77	42	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   72	115	164	java/lang/Throwable
    //   115	120	164	java/lang/Throwable
    //   165	172	172	finally
    //   72	115	186	finally
    //   115	120	186	finally
  }
  
  public final a aKN(String paramString)
  {
    AppMethodBeat.i(204156);
    p.k(paramString, "sessionId");
    Object localObject = "select *, rowid from GameLifeConversation where sessionId = '" + paramString + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    a locala = new a();
    locala.field_sessionId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        locala.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(204156);
    return locala;
  }
  
  /* Error */
  public final int eAi()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 272
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 101	com/tencent/mm/plugin/gamelife/e/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   12: ldc_w 274
    //   15: aconst_null
    //   16: invokeinterface 138 3 0
    //   21: checkcast 140	java/io/Closeable
    //   24: astore 4
    //   26: aload 4
    //   28: checkcast 142	android/database/Cursor
    //   31: astore_2
    //   32: aload_2
    //   33: invokeinterface 146 1 0
    //   38: ifeq +88 -> 126
    //   41: aload_2
    //   42: ldc_w 276
    //   45: invokestatic 151	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   48: aload_2
    //   49: invokeinterface 154 1 0
    //   54: ifne +72 -> 126
    //   57: aload_2
    //   58: iconst_0
    //   59: invokeinterface 256 2 0
    //   64: istore_1
    //   65: getstatic 178	kotlin/x:aazN	Lkotlin/x;
    //   68: astore_2
    //   69: aload 4
    //   71: aconst_null
    //   72: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   75: ldc 230
    //   77: ldc_w 278
    //   80: iload_1
    //   81: invokestatic 282	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: invokevirtual 286	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   87: invokestatic 247	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: ldc_w 272
    //   93: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: iload_1
    //   97: ireturn
    //   98: astore_3
    //   99: ldc_w 272
    //   102: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_3
    //   106: athrow
    //   107: astore_2
    //   108: aload 4
    //   110: aload_3
    //   111: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   114: ldc_w 272
    //   117: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_2
    //   121: athrow
    //   122: astore_2
    //   123: goto -15 -> 108
    //   126: iconst_0
    //   127: istore_1
    //   128: goto -63 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	e
    //   64	64	1	i	int
    //   31	38	2	localObject1	Object
    //   107	14	2	localObject2	Object
    //   122	1	2	localObject3	Object
    //   1	1	3	localObject4	Object
    //   98	13	3	localThrowable	java.lang.Throwable
    //   24	85	4	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   26	65	98	java/lang/Throwable
    //   65	69	98	java/lang/Throwable
    //   99	107	107	finally
    //   26	65	122	finally
    //   65	69	122	finally
  }
  
  /* Error */
  public final a eAt()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 289
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 101	com/tencent/mm/plugin/gamelife/e/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   12: ldc_w 291
    //   15: aconst_null
    //   16: invokeinterface 138 3 0
    //   21: checkcast 140	java/io/Closeable
    //   24: astore_3
    //   25: aload_3
    //   26: checkcast 142	android/database/Cursor
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 146 1 0
    //   36: ifeq +48 -> 84
    //   39: aload_1
    //   40: ldc_w 276
    //   43: invokestatic 151	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   46: aload_1
    //   47: invokeinterface 154 1 0
    //   52: ifne +32 -> 84
    //   55: new 61	com/tencent/mm/plugin/gamelife/e/a
    //   58: dup
    //   59: invokespecial 155	com/tencent/mm/plugin/gamelife/e/a:<init>	()V
    //   62: astore 4
    //   64: aload 4
    //   66: aload_1
    //   67: invokevirtual 159	com/tencent/mm/plugin/gamelife/e/a:convertFrom	(Landroid/database/Cursor;)V
    //   70: aload_3
    //   71: aconst_null
    //   72: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   75: ldc_w 289
    //   78: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload 4
    //   83: areturn
    //   84: getstatic 178	kotlin/x:aazN	Lkotlin/x;
    //   87: astore_1
    //   88: aload_3
    //   89: aconst_null
    //   90: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   93: ldc_w 289
    //   96: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_2
    //   102: ldc_w 289
    //   105: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_2
    //   109: athrow
    //   110: astore_1
    //   111: aload_3
    //   112: aload_2
    //   113: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   116: ldc_w 289
    //   119: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: goto -14 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	e
    //   29	59	1	localObject1	Object
    //   110	13	1	localObject2	Object
    //   124	1	1	localObject3	Object
    //   1	1	2	localObject4	Object
    //   101	12	2	localThrowable	java.lang.Throwable
    //   24	88	3	localCloseable	java.io.Closeable
    //   62	20	4	locala	a
    // Exception table:
    //   from	to	target	type
    //   25	70	101	java/lang/Throwable
    //   84	88	101	java/lang/Throwable
    //   102	110	110	finally
    //   25	70	124	finally
    //   84	88	124	finally
  }
  
  /* Error */
  public final a eAu()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 293
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 61	com/tencent/mm/plugin/gamelife/e/a
    //   11: dup
    //   12: invokespecial 155	com/tencent/mm/plugin/gamelife/e/a:<init>	()V
    //   15: astore_1
    //   16: aload_0
    //   17: getfield 101	com/tencent/mm/plugin/gamelife/e/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   20: ldc_w 295
    //   23: aconst_null
    //   24: invokeinterface 138 3 0
    //   29: checkcast 140	java/io/Closeable
    //   32: astore_3
    //   33: aload_3
    //   34: checkcast 142	android/database/Cursor
    //   37: astore 4
    //   39: aload 4
    //   41: invokeinterface 146 1 0
    //   46: ifeq +22 -> 68
    //   49: aload_1
    //   50: aload 4
    //   52: invokevirtual 159	com/tencent/mm/plugin/gamelife/e/a:convertFrom	(Landroid/database/Cursor;)V
    //   55: aload_3
    //   56: aconst_null
    //   57: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   60: ldc_w 293
    //   63: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: areturn
    //   68: getstatic 178	kotlin/x:aazN	Lkotlin/x;
    //   71: astore 4
    //   73: aload_3
    //   74: aconst_null
    //   75: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   78: ldc_w 293
    //   81: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_1
    //   85: areturn
    //   86: astore_2
    //   87: ldc_w 293
    //   90: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_1
    //   96: aload_3
    //   97: aload_2
    //   98: invokestatic 172	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   101: ldc_w 293
    //   104: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: goto -14 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	e
    //   15	70	1	locala	a
    //   95	13	1	localObject1	Object
    //   109	1	1	localObject2	Object
    //   1	1	2	localObject3	Object
    //   86	12	2	localThrowable	java.lang.Throwable
    //   32	65	3	localCloseable	java.io.Closeable
    //   37	35	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   33	55	86	java/lang/Throwable
    //   68	73	86	java/lang/Throwable
    //   87	95	95	finally
    //   33	55	109	finally
    //   68	73	109	finally
  }
  
  public final List<a> en(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204157);
    List localList = hF(paramInt1, paramInt2);
    Log.i("GameLife.ConversationStorage", "[query] offset=" + paramInt1 + " pageCount=" + paramInt2 + " list size=" + localList.size());
    AppMethodBeat.o(204157);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.e
 * JD-Core Version:    0.7.0.1
 */