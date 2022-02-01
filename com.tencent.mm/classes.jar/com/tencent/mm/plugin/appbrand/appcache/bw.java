package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.jl;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionTemplateIdMappingStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionTemplateIdMappingStorage$MappingRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getValidPkgRecordsForTemplateIdAndMd5", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "templateId", "", "md5", "", "newMd5", "removeRecordsForAppIdAndVersionLessThan", "", "appId", "appVersion", "setTemplateId", "", "Companion", "MappingRecord", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bw
  extends MAutoStorage<b>
{
  public static final String[] nVW;
  public static final bw.a qIs;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(320205);
    qIs = new bw.a((byte)0);
    bw.b.a locala = b.qIt;
    nVW = b.chh();
    AppMethodBeat.o(320205);
  }
  
  public bw(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.chg(), "WxaVersionTemplateIdMapping", jl.INDEX_CREATE);
    AppMethodBeat.i(320199);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(320199);
  }
  
  /* Error */
  public final boolean b(String paramString, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: ldc 100
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: checkcast 102	java/lang/CharSequence
    //   12: astore 8
    //   14: aload 8
    //   16: ifnull +13 -> 29
    //   19: aload 8
    //   21: invokeinterface 106 1 0
    //   26: ifne +18 -> 44
    //   29: iconst_1
    //   30: istore 5
    //   32: iload 5
    //   34: ifeq +16 -> 50
    //   37: ldc 100
    //   39: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: ireturn
    //   44: iconst_0
    //   45: istore 5
    //   47: goto -15 -> 32
    //   50: ldc 108
    //   52: new 110	java/lang/StringBuilder
    //   55: dup
    //   56: ldc 112
    //   58: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: ldc 121
    //   67: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload_2
    //   71: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: ldc 129
    //   76: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: lload_3
    //   80: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: bipush 41
    //   85: invokevirtual 135	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   88: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 98	com/tencent/mm/plugin/appbrand/appcache/bw:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   98: astore 8
    //   100: aload 8
    //   102: monitorenter
    //   103: aload_0
    //   104: getfield 98	com/tencent/mm/plugin/appbrand/appcache/bw:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   107: new 110	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 146
    //   113: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: invokevirtual 149	com/tencent/mm/plugin/appbrand/appcache/bw:getTableName	()Ljava/lang/String;
    //   120: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   123: ldc 151
    //   125: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: iconst_3
    //   132: anewarray 153	java/lang/String
    //   135: dup
    //   136: iconst_0
    //   137: aload_1
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: iload_2
    //   142: invokestatic 157	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: lload_3
    //   149: invokestatic 160	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   152: aastore
    //   153: invokeinterface 166 3 0
    //   158: astore 9
    //   160: aload 9
    //   162: ifnonnull +22 -> 184
    //   165: iload 6
    //   167: istore 5
    //   169: iload 5
    //   171: ifle +97 -> 268
    //   174: aload 8
    //   176: monitorexit
    //   177: ldc 100
    //   179: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: iconst_1
    //   183: ireturn
    //   184: aload 9
    //   186: checkcast 168	java/io/Closeable
    //   189: astore 9
    //   191: aload 9
    //   193: checkcast 170	android/database/Cursor
    //   196: astore 10
    //   198: aload 10
    //   200: invokeinterface 174 1 0
    //   205: ifeq +22 -> 227
    //   208: aload 10
    //   210: iconst_0
    //   211: invokeinterface 178 2 0
    //   216: istore 5
    //   218: aload 9
    //   220: aconst_null
    //   221: invokestatic 184	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   224: goto -55 -> 169
    //   227: iconst_0
    //   228: istore 5
    //   230: goto -12 -> 218
    //   233: astore_1
    //   234: ldc 100
    //   236: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_1
    //   240: athrow
    //   241: astore 10
    //   243: aload 9
    //   245: aload_1
    //   246: invokestatic 184	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   249: ldc 100
    //   251: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: aload 10
    //   256: athrow
    //   257: astore_1
    //   258: aload 8
    //   260: monitorexit
    //   261: ldc 100
    //   263: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_1
    //   267: athrow
    //   268: new 9	com/tencent/mm/plugin/appbrand/appcache/bw$b
    //   271: dup
    //   272: invokespecial 186	com/tencent/mm/plugin/appbrand/appcache/bw$b:<init>	()V
    //   275: astore 9
    //   277: aload 9
    //   279: aload_1
    //   280: putfield 190	com/tencent/mm/plugin/appbrand/appcache/bw$b:field_appId	Ljava/lang/String;
    //   283: aload 9
    //   285: iload_2
    //   286: putfield 194	com/tencent/mm/plugin/appbrand/appcache/bw$b:field_appVersion	I
    //   289: aload 9
    //   291: lload_3
    //   292: putfield 198	com/tencent/mm/plugin/appbrand/appcache/bw$b:field_templateId	J
    //   295: getstatic 204	kotlin/ah:aiuX	Lkotlin/ah;
    //   298: astore_1
    //   299: aload_0
    //   300: aload 9
    //   302: checkcast 206	com/tencent/mm/sdk/storage/IAutoDBItem
    //   305: iconst_1
    //   306: invokespecial 210	com/tencent/mm/sdk/storage/MAutoStorage:insertNotify	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;Z)Z
    //   309: istore 7
    //   311: aload 8
    //   313: monitorexit
    //   314: ldc 100
    //   316: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: iload 7
    //   321: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	bw
    //   0	322	1	paramString	String
    //   0	322	2	paramInt	int
    //   0	322	3	paramLong	long
    //   30	199	5	i	int
    //   1	165	6	j	int
    //   309	11	7	bool	boolean
    //   12	300	8	localObject1	Object
    //   158	143	9	localObject2	Object
    //   196	13	10	localCursor	Cursor
    //   241	14	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   191	218	233	finally
    //   234	241	241	finally
    //   103	160	257	finally
    //   184	191	257	finally
    //   218	224	257	finally
    //   243	257	257	finally
    //   268	311	257	finally
  }
  
  public final int bK(String paramString, int paramInt)
  {
    AppMethodBeat.i(320217);
    ??? = (CharSequence)paramString;
    if ((??? == null) || (((CharSequence)???).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320217);
      return 0;
    }
    synchronized (this.db)
    {
      paramInt = this.db.delete(getTableName(), "appId=? and appVersion<?", new String[] { paramString, String.valueOf(paramInt) });
      AppMethodBeat.o(320217);
      return paramInt;
    }
  }
  
  public final List<bh> c(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(320223);
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label90;
      }
      localObject1 = (CharSequence)paramString2;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label84;
      }
    }
    label84:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label90;
      }
      paramString1 = (List)ab.aivy;
      AppMethodBeat.o(320223);
      return paramString1;
      i = 0;
      break;
    }
    label90:
    Object localObject2;
    for (;;)
    {
      synchronized (this.db)
      {
        localObject1 = this.db.rawQuery("select appId from " + getTableName() + " where templateId=?", new String[] { String.valueOf(paramLong) });
        if (localObject1 == null)
        {
          localObject1 = null;
          localObject1 = (List)localObject1;
          localObject2 = (Collection)localObject1;
          if (localObject2 == null) {
            break label557;
          }
          if (((Collection)localObject2).isEmpty())
          {
            break label557;
            if (i == 0) {
              break;
            }
            paramString1 = (List)ab.aivy;
            AppMethodBeat.o(320223);
            return paramString1;
          }
        }
        else
        {
          localObject2 = (Closeable)localObject1;
          try
          {
            localObject3 = (Cursor)localObject2;
            if (((Cursor)localObject3).moveToFirst())
            {
              localObject1 = new LinkedList();
              ((LinkedList)localObject1).add(((Cursor)localObject3).getString(0));
              boolean bool = ((Cursor)localObject3).moveToNext();
              if (bool) {
                continue;
              }
              b.a((Closeable)localObject2, null);
              continue;
            }
            localObject1 = null;
            continue;
            paramString1 = finally;
          }
          finally
          {
            try
            {
              AppMethodBeat.o(320223);
              throw paramString1;
            }
            finally
            {
              b.a((Closeable)localObject2, paramString1);
              AppMethodBeat.o(320223);
            }
          }
        }
      }
      i = 0;
    }
    Object localObject3 = new LinkedList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    Object localObject4;
    String str;
    if (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      localObject4 = this.db;
      str = s.X((String)localObject1, "%");
      if (paramString1 != null) {
        break label551;
      }
      localObject1 = "";
      break label563;
    }
    for (;;)
    {
      for (;;)
      {
        label395:
        localObject1 = ((ISQLiteDatabase)localObject4).rawQuery("select * from AppBrandWxaPkgManifestRecord where appId like ? and (versionMd5=? or NewMd5=?) and pkgPath!=?", new String[] { str, localObject1, localObject2, "" });
        if (localObject1 == null) {
          break;
        }
        localObject1 = (Closeable)localObject1;
        try
        {
          localObject4 = (Cursor)localObject1;
          if (((Cursor)localObject4).moveToFirst())
          {
            localObject2 = new bh();
            ((bh)localObject2).convertFrom((Cursor)localObject4);
            localObject4 = ah.aiuX;
            ((LinkedList)localObject3).add(localObject2);
          }
          localObject2 = ah.aiuX;
          b.a((Closeable)localObject1, null);
          break;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(320223);
            throw paramString1;
          }
          finally
          {
            b.a((Closeable)localObject1, paramString1);
            AppMethodBeat.o(320223);
          }
        }
      }
      paramString1 = (List)localObject3;
      AppMethodBeat.o(320223);
      return paramString1;
      label551:
      label557:
      label563:
      do
      {
        localObject2 = paramString2;
        break label395;
        localObject1 = paramString1;
        continue;
        i = 1;
        break;
      } while (paramString2 != null);
      localObject2 = "";
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionTemplateIdMappingStorage$MappingRecord;", "Lcom/tencent/mm/autogen/table/BaseWxaVersionTemplateIdMapping;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends jl
  {
    private static final IAutoDBItem.MAutoDBInfo nVV;
    private static final String[] nVW;
    public static final bw.b.a qIt;
    
    static
    {
      AppMethodBeat.i(320277);
      qIt = new bw.b.a((byte)0);
      Object localObject = jl.aJm();
      s.s(localObject, "initAutoDBInfo(MappingRecord::class.java)");
      nVV = (IAutoDBItem.MAutoDBInfo)localObject;
      localObject = MAutoStorage.getCreateSQLs(nVV, "WxaVersionTemplateIdMapping");
      s.s(localObject, "getCreateSQLs(INFO, TABLE_NAME)");
      nVW = new String[] { localObject };
      AppMethodBeat.o(320277);
    }
    
    public final IAutoDBItem.MAutoDBInfo getDBInfo()
    {
      return nVV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bw
 * JD-Core Version:    0.7.0.1
 */