package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bp;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "", "insertContact", "", "contact", "removeCacheFromWx", "", "replaceContact", "", "ct", "isUpdateTime", "updateContact", "Companion", "plugin-finder_release"})
public final class v
  extends j<cd>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final a szd;
  private final e sxB;
  
  static
  {
    AppMethodBeat.i(203729);
    szd = new a((byte)0);
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderMsgContactStorage_username_index ON FinderMsgContactStorage(username)" };
    g.a locala = com.tencent.mm.plugin.finder.api.g.rHB;
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.finder.api.g.access$getInfo$cp(), "FinderMsgContactStorage") };
    AppMethodBeat.o(203729);
  }
  
  public v(e parame)
  {
    super(parame, com.tencent.mm.plugin.finder.api.g.access$getInfo$cp(), "FinderMsgContactStorage", INDEX_CREATE);
    AppMethodBeat.i(203728);
    this.sxB = parame;
    AppMethodBeat.o(203728);
  }
  
  private static void h(com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(203727);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp();
    String str = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage().aix(paramg.getUsername());
    ((bp)localObject).akd(paramg.getUsername());
    ((bp)localObject).akd(str);
    AppMethodBeat.o(203727);
  }
  
  /* Error */
  public final com.tencent.mm.plugin.finder.api.g agW(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 158
    //   4: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 159
    //   10: invokestatic 94	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 161	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 163
    //   19: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokestatic 170	com/tencent/mm/storagebase/h:wo	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 100	com/tencent/mm/plugin/finder/storage/v:sxB	Lcom/tencent/mm/sdk/e/e;
    //   37: aload_1
    //   38: aconst_null
    //   39: iconst_2
    //   40: invokeinterface 182 4 0
    //   45: checkcast 184	java/io/Closeable
    //   48: astore_3
    //   49: aload_3
    //   50: checkcast 186	android/database/Cursor
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +45 -> 102
    //   60: aload 4
    //   62: invokeinterface 190 1 0
    //   67: iconst_1
    //   68: if_icmpne +64 -> 132
    //   71: new 66	com/tencent/mm/plugin/finder/api/g
    //   74: dup
    //   75: invokespecial 192	com/tencent/mm/plugin/finder/api/g:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: aload 4
    //   82: invokevirtual 196	com/tencent/mm/plugin/finder/api/g:convertFrom	(Landroid/database/Cursor;)V
    //   85: getstatic 202	d/z:MKo	Ld/z;
    //   88: astore 4
    //   90: aload_3
    //   91: aconst_null
    //   92: invokestatic 207	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   95: ldc 158
    //   97: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: areturn
    //   102: aconst_null
    //   103: astore_1
    //   104: goto -19 -> 85
    //   107: astore_2
    //   108: ldc 158
    //   110: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_2
    //   114: athrow
    //   115: astore_1
    //   116: aload_3
    //   117: aload_2
    //   118: invokestatic 207	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   121: ldc 158
    //   123: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: goto -13 -> 116
    //   132: aconst_null
    //   133: astore_1
    //   134: goto -49 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	v
    //   0	137	1	paramString	String
    //   1	1	2	localObject1	Object
    //   107	11	2	localThrowable	java.lang.Throwable
    //   48	69	3	localCloseable	java.io.Closeable
    //   53	36	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	55	107	java/lang/Throwable
    //   60	85	107	java/lang/Throwable
    //   85	90	107	java/lang/Throwable
    //   108	115	115	finally
    //   49	55	128	finally
    //   60	85	128	finally
    //   85	90	128	finally
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.api.g paramg, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(203725);
    p.h(paramg, "ct");
    if (paramBoolean) {
      paramg.field_updateTime = cf.aCM();
    }
    ContentValues localContentValues;
    if (agW(paramg.getUsername()) == null)
    {
      p.h(paramg, "contact");
      localContentValues = paramg.convertTo();
      long l = this.sxB.insert("FinderContact", "", localContentValues);
      ad.i("Finder.MsgContactStorage", "insert contact " + paramg + ' ' + l);
      paramg.systemRowid = l;
      if (l > 0L) {
        paramBoolean = bool;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        h(paramg);
        doNotify("FinderContact", 4, paramg.getUsername());
      }
      AppMethodBeat.o(203725);
      return paramBoolean;
      paramBoolean = false;
      continue;
      p.h(paramg, "contact");
      localContentValues = paramg.convertTo();
      localContentValues.remove("rowid");
      int i = this.sxB.update("FinderContact", localContentValues, "username=?", new String[] { paramg.field_username });
      ad.i("Finder.MsgContactStorage", "updateContact " + paramg.cxP() + ' ' + i);
      if (i > 0) {
        h(paramg);
      }
      paramBoolean = bool;
      if (i <= 0) {
        paramBoolean = false;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "TABLE_NAME", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.v
 * JD-Core Version:    0.7.0.1
 */