package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cj;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.api.m.a;
import com.tencent.mm.plugin.finder.conv.a.a;
import com.tencent.mm.plugin.finder.conv.a.b;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.io.Closeable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "", "getTableInfo", "insertContact", "", "contact", "replaceContactInDB", "", "ct", "reportSize", "", "updateContact", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends MAutoStorage<cj>
{
  public static final a FJW;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public final ISQLiteDatabase psb;
  
  static
  {
    AppMethodBeat.i(166958);
    FJW = new a((byte)0);
    Object localObject = m.Axk;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(m.access$getInfo$cp(), "FinderContact") };
    localObject = cj.INDEX_CREATE;
    s.s(localObject, "INDEX_CREATE");
    localObject = k.af((Object[])localObject);
    ((List)localObject).add(0, "DROP INDEX username_index");
    localObject = ((Collection)localObject).toArray(new String[0]);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(166958);
      throw ((Throwable)localObject);
    }
    INDEX_CREATE = (String[])localObject;
    AppMethodBeat.o(166958);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, m.access$getInfo$cp(), "FinderContact", INDEX_CREATE);
    AppMethodBeat.i(166957);
    this.psb = paramISQLiteDatabase;
    AppMethodBeat.o(166957);
  }
  
  public final m auT(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(166956);
    s.u(paramString, "username");
    localObject1 = s.X("SELECT *, rowid FROM FinderContact WHERE username = ", h.EQ(paramString));
    long l = SystemClock.uptimeMillis();
    paramString = this.psb.rawQuery((String)localObject1, null, 2);
    Object localObject2 = new a.a();
    String str = Thread.currentThread().getName();
    s.s(str, "currentThread().name");
    localObject1 = ((a.a)localObject2).avh(str).avg((String)localObject1);
    ((a.a)localObject1).duration = (SystemClock.uptimeMillis() - l);
    ((a.a)localObject1).avf("FinderContactStorage.getContact").dWL().report();
    localObject1 = (Closeable)paramString;
    for (;;)
    {
      try
      {
        localObject2 = (Cursor)localObject1;
        if ((localObject2 == null) || (((Cursor)localObject2).moveToFirst() != true)) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramString = new m();
        paramString.convertFrom((Cursor)localObject2);
      }
      finally
      {
        try
        {
          AppMethodBeat.o(166956);
          throw paramString;
        }
        finally
        {
          b.a((Closeable)localObject1, paramString);
          AppMethodBeat.o(166956);
        }
        paramString = null;
        continue;
      }
      localObject2 = ah.aiuX;
      b.a((Closeable)localObject1, null);
      AppMethodBeat.o(166956);
      return paramString;
      i = 0;
    }
  }
  
  /* Error */
  public final String eYI()
  {
    // Byte code:
    //   0: ldc 235
    //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 236
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 136	com/tencent/mm/plugin/finder/storage/f:psb	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   13: ldc 238
    //   15: aconst_null
    //   16: iconst_2
    //   17: invokeinterface 166 4 0
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +285 -> 311
    //   29: aload 4
    //   31: checkcast 209	java/io/Closeable
    //   34: astore 7
    //   36: aload 7
    //   38: checkcast 211	android/database/Cursor
    //   41: astore 8
    //   43: aload 8
    //   45: invokeinterface 242 1 0
    //   50: istore_2
    //   51: aload 5
    //   53: astore 4
    //   55: aload 8
    //   57: invokeinterface 245 1 0
    //   62: ifeq +203 -> 265
    //   65: ldc 236
    //   67: astore 5
    //   69: aload 8
    //   71: ldc 247
    //   73: invokeinterface 251 2 0
    //   78: istore_3
    //   79: iload_3
    //   80: iflt +170 -> 250
    //   83: iload_3
    //   84: iload_2
    //   85: if_icmpge +160 -> 245
    //   88: iconst_1
    //   89: istore_1
    //   90: iload_1
    //   91: ifeq +48 -> 139
    //   94: aload 8
    //   96: iload_3
    //   97: invokeinterface 255 2 0
    //   102: astore 5
    //   104: aload 5
    //   106: ldc_w 257
    //   109: invokestatic 91	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   112: new 259	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   119: ldc 236
    //   121: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 5
    //   126: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: bipush 58
    //   131: invokevirtual 267	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   134: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 5
    //   139: aload 8
    //   141: ldc_w 272
    //   144: invokeinterface 251 2 0
    //   149: istore_3
    //   150: iload_3
    //   151: iflt +109 -> 260
    //   154: iload_3
    //   155: iload_2
    //   156: if_icmpge +99 -> 255
    //   159: iconst_1
    //   160: istore_1
    //   161: aload 5
    //   163: astore 6
    //   165: iload_1
    //   166: ifeq +30 -> 196
    //   169: aload 8
    //   171: iload_3
    //   172: invokeinterface 255 2 0
    //   177: astore 6
    //   179: aload 6
    //   181: ldc_w 257
    //   184: invokestatic 91	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   187: aload 5
    //   189: aload 6
    //   191: invokestatic 154	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   194: astore 6
    //   196: new 259	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   203: aload 4
    //   205: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 6
    //   210: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: bipush 59
    //   215: invokevirtual 267	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   218: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: astore 4
    //   223: goto -168 -> 55
    //   226: astore 4
    //   228: ldc_w 274
    //   231: aload 4
    //   233: invokevirtual 275	java/lang/Exception:toString	()Ljava/lang/String;
    //   236: invokestatic 281	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aconst_null
    //   240: astore 4
    //   242: goto -218 -> 24
    //   245: iconst_0
    //   246: istore_1
    //   247: goto -157 -> 90
    //   250: iconst_0
    //   251: istore_1
    //   252: goto -162 -> 90
    //   255: iconst_0
    //   256: istore_1
    //   257: goto -96 -> 161
    //   260: iconst_0
    //   261: istore_1
    //   262: goto -101 -> 161
    //   265: getstatic 226	kotlin/ah:aiuX	Lkotlin/ah;
    //   268: astore 5
    //   270: aload 7
    //   272: aconst_null
    //   273: invokestatic 231	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   276: ldc 235
    //   278: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: aload 4
    //   283: areturn
    //   284: astore 4
    //   286: ldc 235
    //   288: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload 4
    //   293: athrow
    //   294: astore 5
    //   296: aload 7
    //   298: aload 4
    //   300: invokestatic 231	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   303: ldc 235
    //   305: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload 5
    //   310: athrow
    //   311: ldc 236
    //   313: astore 4
    //   315: goto -39 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	f
    //   89	173	1	i	int
    //   50	107	2	j	int
    //   78	94	3	k	int
    //   22	200	4	localObject1	Object
    //   226	6	4	localException	java.lang.Exception
    //   240	42	4	str1	String
    //   284	15	4	localThrowable	Throwable
    //   313	1	4	str2	String
    //   7	262	5	localObject2	Object
    //   294	15	5	localObject3	Object
    //   163	46	6	localObject4	Object
    //   34	263	7	localCloseable	Closeable
    //   41	129	8	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   9	24	226	java/lang/Exception
    //   36	51	284	finally
    //   55	65	284	finally
    //   69	79	284	finally
    //   94	139	284	finally
    //   139	150	284	finally
    //   169	196	284	finally
    //   196	223	284	finally
    //   265	270	284	finally
    //   286	294	294	finally
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "getSQL_CREATE", "SQL_PRAGMA", "TAG", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.f
 * JD-Core Version:    0.7.0.1
 */