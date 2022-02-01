package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.conv.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clearUnreadCount", "", "sessionId", "", "genSceneTypeIndex", "", "get", "getGreetConvCount", "", "scene", "getTopPlaceCount", "type", "getUnreadCount", "isExit", "query", "", "offset", "nextCount", "", "queryLimit", "limitCount", "types", "replace", "item", "isNotify", "setEditing", "editing", "setTopPlace", "isTopPlace", "Companion", "plugin-finder_release"})
public final class e
  extends MAutoStorage<c>
{
  private static final String[] SQL_CREATE;
  public static final a vDk;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(251710);
    vDk = new a((byte)0);
    c.a locala = c.tys;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.access$getInfo$cp(), "FinderConversation") };
    AppMethodBeat.o(251710);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.access$getInfo$cp(), "FinderConversation", cf.INDEX_CREATE);
    AppMethodBeat.i(251709);
    this.db = paramISQLiteDatabase;
    this.db.execSQL("FinderConversation", "CREATE INDEX IF NOT EXISTS FinderConversation_type_scene_index ON FinderConversation(scene,type)");
    AppMethodBeat.o(251709);
  }
  
  /* Error */
  private boolean avr(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 123
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 124
    //   11: invokestatic 99	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: new 126	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 128
    //   20: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 137
    //   29: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore_1
    //   36: aload_0
    //   37: getfield 110	com/tencent/mm/plugin/finder/storage/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   40: aload_1
    //   41: aconst_null
    //   42: invokeinterface 145 3 0
    //   47: checkcast 147	java/io/Closeable
    //   50: astore 5
    //   52: aload 5
    //   54: checkcast 149	android/database/Cursor
    //   57: astore_1
    //   58: aload_1
    //   59: ldc 151
    //   61: invokestatic 154	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   64: aload_1
    //   65: invokeinterface 158 1 0
    //   70: istore_2
    //   71: iload_2
    //   72: ifle +18 -> 90
    //   75: iconst_1
    //   76: istore_3
    //   77: aload 5
    //   79: aconst_null
    //   80: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   83: ldc 123
    //   85: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iload_3
    //   89: ireturn
    //   90: iconst_0
    //   91: istore_3
    //   92: goto -15 -> 77
    //   95: astore 4
    //   97: ldc 123
    //   99: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload 4
    //   104: athrow
    //   105: astore_1
    //   106: aload 5
    //   108: aload 4
    //   110: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   113: ldc 123
    //   115: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: goto -15 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	e
    //   0	124	1	paramString	String
    //   70	2	2	i	int
    //   76	16	3	bool	boolean
    //   1	1	4	localObject	Object
    //   95	14	4	localThrowable	java.lang.Throwable
    //   50	57	5	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   52	71	95	java/lang/Throwable
    //   97	105	105	finally
    //   52	71	120	finally
  }
  
  /* Error */
  private final List<c> b(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: ldc 166
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 168	java/util/LinkedList
    //   11: dup
    //   12: invokespecial 170	java/util/LinkedList:<init>	()V
    //   15: astore 13
    //   17: aload_0
    //   18: iload 4
    //   20: invokevirtual 174	com/tencent/mm/plugin/finder/storage/e:KX	(I)I
    //   23: istore 7
    //   25: aload_3
    //   26: ifnull +304 -> 330
    //   29: ldc 176
    //   31: astore 10
    //   33: aload_3
    //   34: arraylength
    //   35: istore 8
    //   37: iconst_0
    //   38: istore 6
    //   40: iconst_0
    //   41: istore 5
    //   43: iload 6
    //   45: iload 8
    //   47: if_icmpge +98 -> 145
    //   50: aload_3
    //   51: iload 6
    //   53: iaload
    //   54: istore 9
    //   56: iload 7
    //   58: ifgt +10 -> 68
    //   61: iload 9
    //   63: bipush 100
    //   65: if_icmpeq +335 -> 400
    //   68: new 126	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   75: aload 10
    //   77: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 179
    //   82: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: iload 9
    //   87: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore 12
    //   95: aload 12
    //   97: astore 10
    //   99: iload 5
    //   101: iconst_1
    //   102: iadd
    //   103: aload_3
    //   104: arraylength
    //   105: if_icmpge +25 -> 130
    //   108: new 126	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   115: aload 12
    //   117: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 184
    //   122: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore 10
    //   130: iload 6
    //   132: iconst_1
    //   133: iadd
    //   134: istore 6
    //   136: iload 5
    //   138: iconst_1
    //   139: iadd
    //   140: istore 5
    //   142: goto -99 -> 43
    //   145: aload 10
    //   147: ldc 184
    //   149: checkcast 186	java/lang/CharSequence
    //   152: invokestatic 192	kotlin/n/n:c	(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   155: astore_3
    //   156: new 126	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   163: aload_3
    //   164: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 194
    //   169: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: astore_3
    //   176: new 126	java/lang/StringBuilder
    //   179: dup
    //   180: ldc 196
    //   182: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: iload 4
    //   187: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: ldc 198
    //   192: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_3
    //   196: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 200
    //   201: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload_2
    //   205: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: ldc 202
    //   210: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload_1
    //   214: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: astore_3
    //   221: aload_0
    //   222: getfield 110	com/tencent/mm/plugin/finder/storage/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   225: aload_3
    //   226: aconst_null
    //   227: invokeinterface 145 3 0
    //   232: checkcast 147	java/io/Closeable
    //   235: astore 12
    //   237: aload 12
    //   239: checkcast 149	android/database/Cursor
    //   242: astore_3
    //   243: aload_3
    //   244: invokeinterface 206 1 0
    //   249: ifeq +120 -> 369
    //   252: aload_3
    //   253: ldc 208
    //   255: invokestatic 154	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   258: aload_3
    //   259: invokeinterface 211 1 0
    //   264: ifne +105 -> 369
    //   267: new 70	com/tencent/mm/plugin/finder/conv/c
    //   270: dup
    //   271: invokespecial 212	com/tencent/mm/plugin/finder/conv/c:<init>	()V
    //   274: astore 10
    //   276: aload 10
    //   278: aload_3
    //   279: invokevirtual 216	com/tencent/mm/plugin/finder/conv/c:convertFrom	(Landroid/database/Cursor;)V
    //   282: aload 10
    //   284: invokevirtual 219	com/tencent/mm/plugin/finder/conv/c:prepare	()V
    //   287: aload 13
    //   289: aload 10
    //   291: invokevirtual 223	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   294: pop
    //   295: aload_3
    //   296: invokeinterface 226 1 0
    //   301: pop
    //   302: goto -50 -> 252
    //   305: astore 10
    //   307: ldc 166
    //   309: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: aload 10
    //   314: athrow
    //   315: astore_3
    //   316: aload 12
    //   318: aload 10
    //   320: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   323: ldc 166
    //   325: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: aload_3
    //   329: athrow
    //   330: new 126	java/lang/StringBuilder
    //   333: dup
    //   334: ldc 196
    //   336: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   339: iload 4
    //   341: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc 200
    //   346: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: iload_2
    //   350: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: ldc 202
    //   355: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload_1
    //   359: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: astore_3
    //   366: goto -145 -> 221
    //   369: getstatic 232	kotlin/x:SXb	Lkotlin/x;
    //   372: astore_3
    //   373: aload 12
    //   375: aconst_null
    //   376: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   379: aload 13
    //   381: checkcast 234	java/util/List
    //   384: astore_3
    //   385: ldc 166
    //   387: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: aload_3
    //   391: areturn
    //   392: astore_3
    //   393: aload 11
    //   395: astore 10
    //   397: goto -81 -> 316
    //   400: goto -270 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	e
    //   0	403	1	paramInt1	int
    //   0	403	2	paramInt2	int
    //   0	403	3	paramArrayOfInt	int[]
    //   0	403	4	paramInt3	int
    //   41	100	5	i	int
    //   38	97	6	j	int
    //   23	34	7	k	int
    //   35	13	8	m	int
    //   54	32	9	n	int
    //   31	259	10	localObject1	Object
    //   305	14	10	localThrowable	java.lang.Throwable
    //   395	1	10	localObject2	Object
    //   1	393	11	localObject3	Object
    //   93	281	12	localObject4	Object
    //   15	365	13	localLinkedList	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   237	252	305	java/lang/Throwable
    //   252	302	305	java/lang/Throwable
    //   369	373	305	java/lang/Throwable
    //   307	315	315	finally
    //   237	252	392	finally
    //   252	302	392	finally
    //   369	373	392	finally
  }
  
  /* Error */
  public final int KX(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 239
    //   4: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 110	com/tencent/mm/plugin/finder/storage/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   11: new 126	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 241
    //   17: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: iload_1
    //   21: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc 243
    //   26: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: aconst_null
    //   33: invokeinterface 145 3 0
    //   38: checkcast 147	java/io/Closeable
    //   41: astore 4
    //   43: aload 4
    //   45: checkcast 149	android/database/Cursor
    //   48: astore_2
    //   49: aload_2
    //   50: invokeinterface 206 1 0
    //   55: ifeq +54 -> 109
    //   58: aload_2
    //   59: iconst_0
    //   60: invokeinterface 246 2 0
    //   65: istore_1
    //   66: getstatic 232	kotlin/x:SXb	Lkotlin/x;
    //   69: astore_2
    //   70: aload 4
    //   72: aconst_null
    //   73: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   76: ldc 239
    //   78: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iload_1
    //   82: ireturn
    //   83: astore_3
    //   84: ldc 239
    //   86: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_3
    //   90: athrow
    //   91: astore_2
    //   92: aload 4
    //   94: aload_3
    //   95: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   98: ldc 239
    //   100: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_2
    //   104: athrow
    //   105: astore_2
    //   106: goto -14 -> 92
    //   109: iconst_0
    //   110: istore_1
    //   111: goto -45 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	e
    //   0	114	1	paramInt	int
    //   48	22	2	localObject1	Object
    //   91	13	2	localObject2	Object
    //   105	1	2	localObject3	Object
    //   1	1	3	localObject4	Object
    //   83	12	3	localThrowable	java.lang.Throwable
    //   41	52	4	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   43	66	83	java/lang/Throwable
    //   66	70	83	java/lang/Throwable
    //   84	91	91	finally
    //   43	66	105	finally
    //   66	70	105	finally
  }
  
  public final List<c> a(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(251698);
    List localList = b(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    Log.i("Finder.ConversationStorage", "[query] offset=" + paramInt1 + " pageCount=" + paramInt2 + " type=" + paramArrayOfInt + " list size=" + localList.size() + ", scene=" + paramInt3);
    AppMethodBeat.o(251698);
    return localList;
  }
  
  public final boolean a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(251702);
    Object localObject2 = new StringBuilder("[replace] ");
    if (paramc != null) {}
    for (Object localObject1 = f.b(paramc);; localObject1 = null)
    {
      Log.i("Finder.ConversationStorage", (String)localObject1);
      if (paramc != null) {
        break;
      }
      AppMethodBeat.o(251702);
      return false;
    }
    localObject1 = paramc.convertTo();
    localObject2 = paramc.field_sessionId;
    p.g(localObject2, "item.field_sessionId");
    boolean bool;
    if (avr((String)localObject2)) {
      if (this.db.update(getTableName(), (ContentValues)localObject1, "sessionId = ?", new String[] { paramc.field_sessionId }) > 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if ((bool) && (paramBoolean)) {
        doNotify(paramc.field_sessionId);
      }
      AppMethodBeat.o(251702);
      return bool;
      bool = false;
      continue;
      bool = super.insertNotify((IAutoDBItem)paramc, false);
    }
  }
  
  /* Error */
  public final int avf(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 314
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 124
    //   11: invokestatic 99	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: ldc_w 316
    //   17: aload_1
    //   18: invokestatic 320	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokevirtual 324	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 110	com/tencent/mm/plugin/finder/storage/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   30: aload 4
    //   32: aconst_null
    //   33: invokeinterface 145 3 0
    //   38: checkcast 147	java/io/Closeable
    //   41: astore 4
    //   43: aload 4
    //   45: checkcast 149	android/database/Cursor
    //   48: astore 5
    //   50: aload 5
    //   52: invokeinterface 206 1 0
    //   57: ifeq +107 -> 164
    //   60: aload 5
    //   62: ldc 208
    //   64: invokestatic 154	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   67: aload 5
    //   69: invokeinterface 211 1 0
    //   74: ifne +90 -> 164
    //   77: aload 5
    //   79: iconst_1
    //   80: invokeinterface 246 2 0
    //   85: istore_2
    //   86: getstatic 232	kotlin/x:SXb	Lkotlin/x;
    //   89: astore 5
    //   91: aload 4
    //   93: aconst_null
    //   94: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   97: ldc 251
    //   99: new 126	java/lang/StringBuilder
    //   102: dup
    //   103: ldc_w 326
    //   106: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: bipush 32
    //   115: invokevirtual 329	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   118: iload_2
    //   119: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 272	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: ldc_w 314
    //   131: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: iload_2
    //   135: ireturn
    //   136: astore_3
    //   137: ldc_w 314
    //   140: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_3
    //   144: athrow
    //   145: astore_1
    //   146: aload 4
    //   148: aload_3
    //   149: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   152: ldc_w 314
    //   155: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: goto -15 -> 146
    //   164: iconst_0
    //   165: istore_2
    //   166: goto -80 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	e
    //   0	169	1	paramString	String
    //   85	81	2	i	int
    //   1	1	3	localObject1	Object
    //   136	13	3	localThrowable	java.lang.Throwable
    //   24	123	4	localObject2	Object
    //   48	42	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   43	86	136	java/lang/Throwable
    //   86	91	136	java/lang/Throwable
    //   137	145	145	finally
    //   43	86	160	finally
    //   86	91	160	finally
  }
  
  public final c avq(String paramString)
  {
    AppMethodBeat.i(251699);
    p.h(paramString, "sessionId");
    Object localObject = "select *, rowid from FinderConversation where sessionId = '" + paramString + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    c localc = new c();
    localc.field_sessionId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        localc.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(251699);
    return localc;
  }
  
  public final boolean avs(String paramString)
  {
    AppMethodBeat.i(251707);
    p.h(paramString, "sessionId");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(251707);
      return false;
    }
    c localc = avq(paramString);
    i = localc.field_unReadCount;
    localc.field_unReadCount = 0;
    localc.field_readStatus = 1;
    boolean bool = update(localc.systemRowid, (IAutoDBItem)localc);
    doNotify(localc.field_sessionId, 5, localc);
    Log.i("Finder.ConversationStorage", "[clearUnreadCount] ret=" + bool + ' ' + i + " => " + localc.field_unReadCount + " sessionId=" + paramString);
    AppMethodBeat.o(251707);
    return bool;
  }
  
  public final boolean bt(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(251708);
    p.h(paramString, "sessionId");
    c localc = avq(paramString);
    boolean bool1 = localc.cZv();
    long l;
    boolean bool2;
    if (paramBoolean)
    {
      l = 1L;
      localc.field_placedFlag = l;
      bool2 = update(localc.systemRowid, (IAutoDBItem)localc, false);
      if (!paramBoolean) {
        break label144;
      }
      doNotify(localc.field_sessionId, 3, localc);
    }
    for (;;)
    {
      Log.i("Finder.ConversationStorage", "[setTopPlace] ret=" + bool2 + " isTopPlace=" + bool1 + " => " + localc.cZv() + " sessionId=" + paramString);
      AppMethodBeat.o(251708);
      return bool2;
      l = 0L;
      break;
      label144:
      doNotify(localc.field_sessionId, 4, localc);
    }
  }
  
  /* Error */
  public final int gk(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: ldc_w 387
    //   12: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   15: iload_2
    //   16: iflt +248 -> 264
    //   19: new 126	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 389
    //   26: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: iload_2
    //   30: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc_w 391
    //   36: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_1
    //   40: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore 5
    //   48: aload_0
    //   49: getfield 110	com/tencent/mm/plugin/finder/storage/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   52: aload 5
    //   54: aconst_null
    //   55: invokeinterface 145 3 0
    //   60: checkcast 147	java/io/Closeable
    //   63: astore 8
    //   65: aload 8
    //   67: checkcast 149	android/database/Cursor
    //   70: astore 5
    //   72: iload 4
    //   74: istore_3
    //   75: aload 5
    //   77: invokeinterface 206 1 0
    //   82: ifeq +32 -> 114
    //   85: aload 5
    //   87: ldc 208
    //   89: invokestatic 154	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   92: iload 4
    //   94: istore_3
    //   95: aload 5
    //   97: invokeinterface 211 1 0
    //   102: ifne +12 -> 114
    //   105: aload 5
    //   107: iconst_0
    //   108: invokeinterface 246 2 0
    //   113: istore_3
    //   114: getstatic 232	kotlin/x:SXb	Lkotlin/x;
    //   117: astore 5
    //   119: aload 8
    //   121: aconst_null
    //   122: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   125: aload_0
    //   126: getfield 110	com/tencent/mm/plugin/finder/storage/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   129: new 126	java/lang/StringBuilder
    //   132: dup
    //   133: ldc_w 393
    //   136: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: iload_2
    //   140: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: ldc_w 391
    //   146: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload_1
    //   150: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: aconst_null
    //   157: invokeinterface 145 3 0
    //   162: checkcast 147	java/io/Closeable
    //   165: astore 7
    //   167: aload 7
    //   169: checkcast 149	android/database/Cursor
    //   172: astore 5
    //   174: aload 5
    //   176: invokeinterface 206 1 0
    //   181: ifeq +32 -> 213
    //   184: aload 5
    //   186: ldc 208
    //   188: invokestatic 154	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   191: aload 5
    //   193: invokeinterface 211 1 0
    //   198: ifne +15 -> 213
    //   201: new 70	com/tencent/mm/plugin/finder/conv/c
    //   204: dup
    //   205: invokespecial 212	com/tencent/mm/plugin/finder/conv/c:<init>	()V
    //   208: aload 5
    //   210: invokevirtual 216	com/tencent/mm/plugin/finder/conv/c:convertFrom	(Landroid/database/Cursor;)V
    //   213: getstatic 232	kotlin/x:SXb	Lkotlin/x;
    //   216: astore 5
    //   218: aload 7
    //   220: aconst_null
    //   221: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   224: ldc 251
    //   226: new 126	java/lang/StringBuilder
    //   229: dup
    //   230: ldc_w 395
    //   233: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: iload_2
    //   237: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: ldc_w 397
    //   243: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: iload_3
    //   247: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 272	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: ldc_w 387
    //   259: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: iload_3
    //   263: ireturn
    //   264: ldc_w 399
    //   267: iload_1
    //   268: invokestatic 402	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   271: invokevirtual 324	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   274: astore 5
    //   276: goto -228 -> 48
    //   279: astore 6
    //   281: ldc_w 387
    //   284: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: aload 6
    //   289: athrow
    //   290: astore 5
    //   292: aload 8
    //   294: aload 6
    //   296: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   299: ldc_w 387
    //   302: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload 5
    //   307: athrow
    //   308: astore 6
    //   310: ldc_w 387
    //   313: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aload 6
    //   318: athrow
    //   319: astore 5
    //   321: aload 7
    //   323: aload 6
    //   325: invokestatic 163	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   328: ldc_w 387
    //   331: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   334: aload 5
    //   336: athrow
    //   337: astore 5
    //   339: goto -18 -> 321
    //   342: astore 5
    //   344: aload 7
    //   346: astore 6
    //   348: goto -56 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	e
    //   0	351	1	paramInt1	int
    //   0	351	2	paramInt2	int
    //   74	189	3	i	int
    //   1	92	4	j	int
    //   46	229	5	localObject1	Object
    //   290	16	5	localObject2	Object
    //   319	16	5	localObject3	Object
    //   337	1	5	localObject4	Object
    //   342	1	5	localObject5	Object
    //   4	1	6	localObject6	Object
    //   279	16	6	localThrowable1	java.lang.Throwable
    //   308	16	6	localThrowable2	java.lang.Throwable
    //   346	1	6	localObject7	Object
    //   7	338	7	localCloseable1	java.io.Closeable
    //   63	230	8	localCloseable2	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   65	72	279	java/lang/Throwable
    //   75	92	279	java/lang/Throwable
    //   95	114	279	java/lang/Throwable
    //   114	119	279	java/lang/Throwable
    //   281	290	290	finally
    //   167	213	308	java/lang/Throwable
    //   213	218	308	java/lang/Throwable
    //   310	319	319	finally
    //   167	213	337	finally
    //   213	218	337	finally
    //   65	72	342	finally
    //   75	92	342	finally
    //   95	114	342	finally
    //   114	119	342	finally
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage$Companion;", "", "()V", "HOLDER_PLACE", "", "SET_TOP_PLACE", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "UNSET_TOP_PLACE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.e
 * JD-Core Version:    0.7.0.1
 */