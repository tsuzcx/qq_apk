package com.tencent.mm.plugin.gamelife.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cv;
import com.tencent.mm.plugin.gamelife.b;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clearUnreadCount", "", "sessionId", "", "get", "getHistoryConversation", "getLatestUnreadConversation", "getTotalUnreadCount", "", "getUnreadCount", "markUnread", "query", "", "offset", "nextCount", "queryLimit", "limitCount", "replace", "item", "Companion", "plugin-gamelife_release"})
public final class d
  extends j<a>
{
  private static final String[] SQL_CREATE;
  public static final a uJK;
  private final e db;
  
  static
  {
    AppMethodBeat.i(212130);
    uJK = new a((byte)0);
    a.a locala = a.uJF;
    SQL_CREATE = new String[] { j.getCreateSQLs(a.access$getInfo$cp(), "GameLifeConversation") };
    AppMethodBeat.o(212130);
  }
  
  public d(e parame)
  {
    super(parame, a.access$getInfo$cp(), "GameLifeConversation", cv.INDEX_CREATE);
    AppMethodBeat.i(212129);
    this.db = parame;
    AppMethodBeat.o(212129);
  }
  
  /* Error */
  private final List<a> gn(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 111
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 113	java/util/LinkedList
    //   11: dup
    //   12: invokespecial 115	java/util/LinkedList:<init>	()V
    //   15: astore_3
    //   16: new 117	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 119
    //   22: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: iload_2
    //   26: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc 128
    //   31: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_1
    //   35: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore 5
    //   43: aload_0
    //   44: getfield 104	com/tencent/mm/plugin/gamelife/e/d:db	Lcom/tencent/mm/sdk/e/e;
    //   47: aload 5
    //   49: aconst_null
    //   50: invokeinterface 141 3 0
    //   55: checkcast 143	java/io/Closeable
    //   58: astore 5
    //   60: aload 5
    //   62: checkcast 145	android/database/Cursor
    //   65: astore 6
    //   67: aload 6
    //   69: invokeinterface 149 1 0
    //   74: ifeq +79 -> 153
    //   77: aload 6
    //   79: ldc 151
    //   81: invokestatic 154	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   84: aload 6
    //   86: invokeinterface 157 1 0
    //   91: ifne +62 -> 153
    //   94: new 63	com/tencent/mm/plugin/gamelife/e/a
    //   97: dup
    //   98: invokespecial 158	com/tencent/mm/plugin/gamelife/e/a:<init>	()V
    //   101: astore 7
    //   103: aload 7
    //   105: aload 6
    //   107: invokevirtual 162	com/tencent/mm/plugin/gamelife/e/a:convertFrom	(Landroid/database/Cursor;)V
    //   110: aload_3
    //   111: aload 7
    //   113: invokevirtual 166	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   116: pop
    //   117: aload 6
    //   119: invokeinterface 169 1 0
    //   124: pop
    //   125: goto -48 -> 77
    //   128: astore 4
    //   130: ldc 111
    //   132: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload 4
    //   137: athrow
    //   138: astore_3
    //   139: aload 5
    //   141: aload 4
    //   143: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   146: ldc 111
    //   148: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_3
    //   152: athrow
    //   153: getstatic 180	d/z:Nhr	Ld/z;
    //   156: astore 6
    //   158: aload 5
    //   160: aconst_null
    //   161: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   164: aload_3
    //   165: checkcast 182	java/util/List
    //   168: astore_3
    //   169: ldc 111
    //   171: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_3
    //   175: areturn
    //   176: astore_3
    //   177: goto -38 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	d
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
  
  /* Error */
  public final int ajc(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 187
    //   4: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 188
    //   10: invokestatic 93	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 194	com/tencent/mm/plugin/gamelife/b:uHN	Lcom/tencent/mm/plugin/gamelife/b$a;
    //   16: astore 4
    //   18: aload_1
    //   19: invokestatic 200	com/tencent/mm/plugin/gamelife/b$a:anx	(Ljava/lang/String;)Z
    //   22: ifne +10 -> 32
    //   25: ldc 187
    //   27: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_0
    //   31: ireturn
    //   32: new 117	java/lang/StringBuilder
    //   35: dup
    //   36: ldc 202
    //   38: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: bipush 39
    //   47: invokevirtual 205	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   50: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore 4
    //   55: aload_0
    //   56: getfield 104	com/tencent/mm/plugin/gamelife/e/d:db	Lcom/tencent/mm/sdk/e/e;
    //   59: aload 4
    //   61: aconst_null
    //   62: invokeinterface 141 3 0
    //   67: checkcast 143	java/io/Closeable
    //   70: astore 4
    //   72: aload 4
    //   74: checkcast 145	android/database/Cursor
    //   77: astore 5
    //   79: aload 5
    //   81: invokeinterface 149 1 0
    //   86: ifeq +103 -> 189
    //   89: aload 5
    //   91: ldc 151
    //   93: invokestatic 154	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   96: aload 5
    //   98: invokeinterface 157 1 0
    //   103: ifne +86 -> 189
    //   106: aload 5
    //   108: iconst_0
    //   109: invokeinterface 209 2 0
    //   114: istore_2
    //   115: getstatic 180	d/z:Nhr	Ld/z;
    //   118: astore 5
    //   120: aload 4
    //   122: aconst_null
    //   123: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   126: ldc 211
    //   128: new 117	java/lang/StringBuilder
    //   131: dup
    //   132: ldc 213
    //   134: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload_1
    //   138: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: bipush 32
    //   143: invokevirtual 205	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   146: iload_2
    //   147: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 218	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: ldc 187
    //   158: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: iload_2
    //   162: ireturn
    //   163: astore_3
    //   164: ldc 187
    //   166: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_3
    //   170: athrow
    //   171: astore_1
    //   172: aload 4
    //   174: aload_3
    //   175: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   178: ldc 187
    //   180: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_1
    //   184: athrow
    //   185: astore_1
    //   186: goto -14 -> 172
    //   189: iconst_0
    //   190: istore_2
    //   191: goto -76 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	d
    //   0	194	1	paramString	String
    //   114	77	2	i	int
    //   1	1	3	localObject1	Object
    //   163	12	3	localThrowable	java.lang.Throwable
    //   16	157	4	localObject2	Object
    //   77	42	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   72	115	163	java/lang/Throwable
    //   115	120	163	java/lang/Throwable
    //   164	171	171	finally
    //   72	115	185	finally
    //   115	120	185	finally
  }
  
  public final boolean ajp(String paramString)
  {
    AppMethodBeat.i(212122);
    p.h(paramString, "sessionId");
    Object localObject = b.uHN;
    if (!b.a.anx(paramString))
    {
      AppMethodBeat.o(212122);
      return false;
    }
    localObject = anH(paramString);
    int i = ((a)localObject).field_unReadCount;
    ((a)localObject).field_unReadCount = 0;
    ((a)localObject).field_digestFlag = 0L;
    ((a)localObject).field_digestPrefix = null;
    boolean bool = update(((a)localObject).systemRowid, (c)localObject, false);
    doNotify("single", 4, localObject);
    ae.i("GameLife.ConversationStorage", "[clearUnreadCount] ret=" + bool + ' ' + i + " => " + ((a)localObject).field_unReadCount + " sessionId=" + paramString);
    AppMethodBeat.o(212122);
    return bool;
  }
  
  public final a anH(String paramString)
  {
    AppMethodBeat.i(212120);
    p.h(paramString, "sessionId");
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
    AppMethodBeat.o(212120);
    return locala;
  }
  
  public final List<a> dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212121);
    List localList = gn(paramInt1, paramInt2);
    ae.i("GameLife.ConversationStorage", "[query] offset=" + paramInt1 + " pageCount=" + paramInt2 + " list size=" + localList.size());
    AppMethodBeat.o(212121);
    return localList;
  }
  
  /* Error */
  public final a ddA()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 288
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 63	com/tencent/mm/plugin/gamelife/e/a
    //   11: dup
    //   12: invokespecial 158	com/tencent/mm/plugin/gamelife/e/a:<init>	()V
    //   15: astore_1
    //   16: aload_0
    //   17: getfield 104	com/tencent/mm/plugin/gamelife/e/d:db	Lcom/tencent/mm/sdk/e/e;
    //   20: ldc_w 290
    //   23: aconst_null
    //   24: invokeinterface 141 3 0
    //   29: checkcast 143	java/io/Closeable
    //   32: astore_3
    //   33: aload_3
    //   34: checkcast 145	android/database/Cursor
    //   37: astore 4
    //   39: aload 4
    //   41: invokeinterface 149 1 0
    //   46: ifeq +22 -> 68
    //   49: aload_1
    //   50: aload 4
    //   52: invokevirtual 162	com/tencent/mm/plugin/gamelife/e/a:convertFrom	(Landroid/database/Cursor;)V
    //   55: aload_3
    //   56: aconst_null
    //   57: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   60: ldc_w 288
    //   63: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: areturn
    //   68: getstatic 180	d/z:Nhr	Ld/z;
    //   71: astore 4
    //   73: aload_3
    //   74: aconst_null
    //   75: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   78: ldc_w 288
    //   81: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_1
    //   85: areturn
    //   86: astore_2
    //   87: ldc_w 288
    //   90: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_1
    //   96: aload_3
    //   97: aload_2
    //   98: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   101: ldc_w 288
    //   104: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: goto -14 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	d
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
  
  /* Error */
  public final int ddp()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 292
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 104	com/tencent/mm/plugin/gamelife/e/d:db	Lcom/tencent/mm/sdk/e/e;
    //   12: ldc_w 294
    //   15: aconst_null
    //   16: invokeinterface 141 3 0
    //   21: checkcast 143	java/io/Closeable
    //   24: astore 4
    //   26: aload 4
    //   28: checkcast 145	android/database/Cursor
    //   31: astore_2
    //   32: aload_2
    //   33: invokeinterface 149 1 0
    //   38: ifeq +88 -> 126
    //   41: aload_2
    //   42: ldc_w 296
    //   45: invokestatic 154	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   48: aload_2
    //   49: invokeinterface 157 1 0
    //   54: ifne +72 -> 126
    //   57: aload_2
    //   58: iconst_0
    //   59: invokeinterface 209 2 0
    //   64: istore_1
    //   65: getstatic 180	d/z:Nhr	Ld/z;
    //   68: astore_2
    //   69: aload 4
    //   71: aconst_null
    //   72: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   75: ldc 211
    //   77: ldc_w 298
    //   80: iload_1
    //   81: invokestatic 302	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   87: invokestatic 218	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: ldc_w 292
    //   93: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: iload_1
    //   97: ireturn
    //   98: astore_3
    //   99: ldc_w 292
    //   102: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_3
    //   106: athrow
    //   107: astore_2
    //   108: aload 4
    //   110: aload_3
    //   111: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   114: ldc_w 292
    //   117: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_2
    //   121: athrow
    //   122: astore_2
    //   123: goto -15 -> 108
    //   126: iconst_0
    //   127: istore_1
    //   128: goto -63 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	d
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
  public final a ddz()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 308
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 104	com/tencent/mm/plugin/gamelife/e/d:db	Lcom/tencent/mm/sdk/e/e;
    //   12: ldc_w 310
    //   15: aconst_null
    //   16: invokeinterface 141 3 0
    //   21: checkcast 143	java/io/Closeable
    //   24: astore_3
    //   25: aload_3
    //   26: checkcast 145	android/database/Cursor
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 149 1 0
    //   36: ifeq +48 -> 84
    //   39: aload_1
    //   40: ldc_w 296
    //   43: invokestatic 154	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   46: aload_1
    //   47: invokeinterface 157 1 0
    //   52: ifne +32 -> 84
    //   55: new 63	com/tencent/mm/plugin/gamelife/e/a
    //   58: dup
    //   59: invokespecial 158	com/tencent/mm/plugin/gamelife/e/a:<init>	()V
    //   62: astore 4
    //   64: aload 4
    //   66: aload_1
    //   67: invokevirtual 162	com/tencent/mm/plugin/gamelife/e/a:convertFrom	(Landroid/database/Cursor;)V
    //   70: aload_3
    //   71: aconst_null
    //   72: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   75: ldc_w 308
    //   78: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload 4
    //   83: areturn
    //   84: getstatic 180	d/z:Nhr	Ld/z;
    //   87: astore_1
    //   88: aload_3
    //   89: aconst_null
    //   90: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   93: ldc_w 308
    //   96: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_2
    //   102: ldc_w 308
    //   105: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_2
    //   109: athrow
    //   110: astore_1
    //   111: aload_3
    //   112: aload_2
    //   113: invokestatic 174	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   116: ldc_w 308
    //   119: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: goto -14 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	d
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.d
 * JD-Core Version:    0.7.0.1
 */