package midas.x;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mv
{
  private ExecutorService a = Executors.newSingleThreadExecutor(mz.a("Database"));
  private a b;
  
  public mv(Context paramContext)
  {
    this.b = new a(paramContext, "TencentUnipayIPList.db", null, 2);
  }
  
  public void a()
  {
    if ((this.a != null) && (!this.a.isShutdown())) {
      this.a.shutdown();
    }
    this.a = null;
    this.b.close();
    this.b = null;
  }
  
  public void a(final mj parammj)
  {
    na.a(this.a, new mx()
    {
      /* Error */
      public Object a(Object[] paramAnonymousArrayOfObject)
      {
        // Byte code:
        //   0: aload_1
        //   1: iconst_0
        //   2: aaload
        //   3: checkcast 29	midas/x/mv$a
        //   6: invokevirtual 33	midas/x/mv$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   9: astore_1
        //   10: aload_1
        //   11: astore_2
        //   12: new 35	java/lang/StringBuilder
        //   15: dup
        //   16: invokespecial 36	java/lang/StringBuilder:<init>	()V
        //   19: astore_3
        //   20: aload_1
        //   21: astore_2
        //   22: aload_3
        //   23: ldc 38
        //   25: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   28: pop
        //   29: aload_1
        //   30: astore_2
        //   31: aload_3
        //   32: aload_0
        //   33: getfield 20	midas/x/mv$2:a	Lmidas/x/mj;
        //   36: getfield 47	midas/x/mj:a	Ljava/lang/String;
        //   39: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   42: pop
        //   43: aload_1
        //   44: astore_2
        //   45: aload_3
        //   46: ldc 49
        //   48: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   51: pop
        //   52: aload_1
        //   53: astore_2
        //   54: aload_3
        //   55: aload_0
        //   56: getfield 20	midas/x/mv$2:a	Lmidas/x/mj;
        //   59: getfield 53	midas/x/mj:e	Ljava/util/concurrent/CopyOnWriteArrayList;
        //   62: invokevirtual 59	java/util/concurrent/CopyOnWriteArrayList:size	()I
        //   65: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   68: pop
        //   69: aload_1
        //   70: astore_2
        //   71: aload_3
        //   72: ldc 64
        //   74: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   77: pop
        //   78: aload_1
        //   79: astore_2
        //   80: aload_3
        //   81: aload_0
        //   82: getfield 20	midas/x/mv$2:a	Lmidas/x/mj;
        //   85: getfield 53	midas/x/mj:e	Ljava/util/concurrent/CopyOnWriteArrayList;
        //   88: invokevirtual 68	java/util/concurrent/CopyOnWriteArrayList:toString	()Ljava/lang/String;
        //   91: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   94: pop
        //   95: aload_1
        //   96: astore_2
        //   97: ldc 70
        //   99: aload_3
        //   100: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   103: invokestatic 76	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   106: aload_1
        //   107: astore_2
        //   108: aload_1
        //   109: invokevirtual 81	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
        //   112: aload_1
        //   113: astore_2
        //   114: aload_1
        //   115: ldc 83
        //   117: ldc 85
        //   119: iconst_1
        //   120: anewarray 87	java/lang/String
        //   123: dup
        //   124: iconst_0
        //   125: aload_0
        //   126: getfield 20	midas/x/mv$2:a	Lmidas/x/mj;
        //   129: getfield 47	midas/x/mj:a	Ljava/lang/String;
        //   132: aastore
        //   133: invokevirtual 91	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
        //   136: pop
        //   137: aload_1
        //   138: astore_2
        //   139: aload_0
        //   140: getfield 20	midas/x/mv$2:a	Lmidas/x/mj;
        //   143: getfield 53	midas/x/mj:e	Ljava/util/concurrent/CopyOnWriteArrayList;
        //   146: invokevirtual 95	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
        //   149: astore_3
        //   150: aload_1
        //   151: astore_2
        //   152: aload_3
        //   153: invokeinterface 101 1 0
        //   158: ifeq +128 -> 286
        //   161: aload_1
        //   162: astore_2
        //   163: aload_3
        //   164: invokeinterface 105 1 0
        //   169: checkcast 107	midas/x/mi
        //   172: astore 4
        //   174: aload_1
        //   175: astore_2
        //   176: new 109	android/content/ContentValues
        //   179: dup
        //   180: invokespecial 110	android/content/ContentValues:<init>	()V
        //   183: astore 5
        //   185: aload_1
        //   186: astore_2
        //   187: aload 5
        //   189: ldc 112
        //   191: aload 4
        //   193: getfield 113	midas/x/mi:a	Ljava/lang/String;
        //   196: invokevirtual 116	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   199: aload_1
        //   200: astore_2
        //   201: aload 5
        //   203: ldc 118
        //   205: aload 4
        //   207: invokevirtual 120	midas/x/mi:b	()Ljava/lang/String;
        //   210: invokevirtual 116	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   213: aload_1
        //   214: astore_2
        //   215: aload 5
        //   217: ldc 122
        //   219: aload 4
        //   221: invokevirtual 124	midas/x/mi:a	()Ljava/lang/String;
        //   224: invokevirtual 116	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   227: aload_1
        //   228: astore_2
        //   229: aload 5
        //   231: ldc 126
        //   233: aload 4
        //   235: getfield 130	midas/x/mi:d	Ljava/lang/Integer;
        //   238: invokevirtual 133	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
        //   241: aload_1
        //   242: astore_2
        //   243: aload 5
        //   245: ldc 135
        //   247: aload 4
        //   249: getfield 137	midas/x/mi:e	Ljava/lang/Integer;
        //   252: invokevirtual 133	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
        //   255: aload_1
        //   256: astore_2
        //   257: aload 5
        //   259: ldc 139
        //   261: aload_0
        //   262: getfield 20	midas/x/mv$2:a	Lmidas/x/mj;
        //   265: getfield 47	midas/x/mj:a	Ljava/lang/String;
        //   268: invokevirtual 116	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   271: aload_1
        //   272: astore_2
        //   273: aload_1
        //   274: ldc 83
        //   276: aconst_null
        //   277: aload 5
        //   279: invokevirtual 143	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
        //   282: pop2
        //   283: goto -133 -> 150
        //   286: aload_1
        //   287: astore_2
        //   288: new 109	android/content/ContentValues
        //   291: dup
        //   292: invokespecial 110	android/content/ContentValues:<init>	()V
        //   295: astore_3
        //   296: aload_1
        //   297: astore_2
        //   298: aload_3
        //   299: ldc 145
        //   301: aload_0
        //   302: getfield 20	midas/x/mv$2:a	Lmidas/x/mj;
        //   305: getfield 148	midas/x/mj:b	Ljava/lang/Long;
        //   308: invokevirtual 151	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
        //   311: aload_1
        //   312: astore_2
        //   313: aload_3
        //   314: ldc 153
        //   316: aload_0
        //   317: getfield 20	midas/x/mv$2:a	Lmidas/x/mj;
        //   320: getfield 155	midas/x/mj:d	Ljava/lang/Long;
        //   323: invokevirtual 151	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
        //   326: aload_1
        //   327: astore_2
        //   328: aload_1
        //   329: ldc 157
        //   331: aload_3
        //   332: ldc 159
        //   334: iconst_1
        //   335: anewarray 87	java/lang/String
        //   338: dup
        //   339: iconst_0
        //   340: aload_0
        //   341: getfield 20	midas/x/mv$2:a	Lmidas/x/mj;
        //   344: getfield 47	midas/x/mj:a	Ljava/lang/String;
        //   347: aastore
        //   348: invokevirtual 163	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
        //   351: pop
        //   352: aload_1
        //   353: astore_2
        //   354: aload_1
        //   355: invokevirtual 166	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
        //   358: aload_1
        //   359: ifnull +92 -> 451
        //   362: aload_1
        //   363: invokevirtual 169	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
        //   366: ifeq +85 -> 451
        //   369: goto +78 -> 447
        //   372: astore_3
        //   373: goto +12 -> 385
        //   376: astore_1
        //   377: aconst_null
        //   378: astore_2
        //   379: goto +81 -> 460
        //   382: astore_3
        //   383: aconst_null
        //   384: astore_1
        //   385: aload_1
        //   386: astore_2
        //   387: new 35	java/lang/StringBuilder
        //   390: dup
        //   391: invokespecial 36	java/lang/StringBuilder:<init>	()V
        //   394: astore 4
        //   396: aload_1
        //   397: astore_2
        //   398: aload 4
        //   400: ldc 171
        //   402: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   405: pop
        //   406: aload_1
        //   407: astore_2
        //   408: aload 4
        //   410: aload_3
        //   411: invokevirtual 172	java/lang/Exception:toString	()Ljava/lang/String;
        //   414: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   417: pop
        //   418: aload_1
        //   419: astore_2
        //   420: ldc 174
        //   422: aload 4
        //   424: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   427: invokestatic 178	midas/x/mp:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   430: aload_1
        //   431: astore_2
        //   432: aload_3
        //   433: invokevirtual 181	java/lang/Exception:printStackTrace	()V
        //   436: aload_1
        //   437: ifnull +14 -> 451
        //   440: aload_1
        //   441: invokevirtual 169	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
        //   444: ifeq +7 -> 451
        //   447: aload_1
        //   448: invokevirtual 184	android/database/sqlite/SQLiteDatabase:endTransaction	()V
        //   451: new 4	java/lang/Object
        //   454: dup
        //   455: invokespecial 23	java/lang/Object:<init>	()V
        //   458: areturn
        //   459: astore_1
        //   460: aload_2
        //   461: ifnull +14 -> 475
        //   464: aload_2
        //   465: invokevirtual 169	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
        //   468: ifeq +7 -> 475
        //   471: aload_2
        //   472: invokevirtual 184	android/database/sqlite/SQLiteDatabase:endTransaction	()V
        //   475: aload_1
        //   476: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	477	0	this	2
        //   0	477	1	paramAnonymousArrayOfObject	Object[]
        //   11	461	2	arrayOfObject	Object[]
        //   19	313	3	localObject1	Object
        //   372	1	3	localException1	Exception
        //   382	51	3	localException2	Exception
        //   172	251	4	localObject2	Object
        //   183	95	5	localContentValues	ContentValues
        // Exception table:
        //   from	to	target	type
        //   12	20	372	java/lang/Exception
        //   22	29	372	java/lang/Exception
        //   31	43	372	java/lang/Exception
        //   45	52	372	java/lang/Exception
        //   54	69	372	java/lang/Exception
        //   71	78	372	java/lang/Exception
        //   80	95	372	java/lang/Exception
        //   97	106	372	java/lang/Exception
        //   108	112	372	java/lang/Exception
        //   114	137	372	java/lang/Exception
        //   139	150	372	java/lang/Exception
        //   152	161	372	java/lang/Exception
        //   163	174	372	java/lang/Exception
        //   176	185	372	java/lang/Exception
        //   187	199	372	java/lang/Exception
        //   201	213	372	java/lang/Exception
        //   215	227	372	java/lang/Exception
        //   229	241	372	java/lang/Exception
        //   243	255	372	java/lang/Exception
        //   257	271	372	java/lang/Exception
        //   273	283	372	java/lang/Exception
        //   288	296	372	java/lang/Exception
        //   298	311	372	java/lang/Exception
        //   313	326	372	java/lang/Exception
        //   328	352	372	java/lang/Exception
        //   354	358	372	java/lang/Exception
        //   0	10	376	finally
        //   0	10	382	java/lang/Exception
        //   12	20	459	finally
        //   22	29	459	finally
        //   31	43	459	finally
        //   45	52	459	finally
        //   54	69	459	finally
        //   71	78	459	finally
        //   80	95	459	finally
        //   97	106	459	finally
        //   108	112	459	finally
        //   114	137	459	finally
        //   139	150	459	finally
        //   152	161	459	finally
        //   163	174	459	finally
        //   176	185	459	finally
        //   187	199	459	finally
        //   201	213	459	finally
        //   215	227	459	finally
        //   229	241	459	finally
        //   243	255	459	finally
        //   257	271	459	finally
        //   273	283	459	finally
        //   288	296	459	finally
        //   298	311	459	finally
        //   313	326	459	finally
        //   328	352	459	finally
        //   354	358	459	finally
        //   387	396	459	finally
        //   398	406	459	finally
        //   408	418	459	finally
        //   420	430	459	finally
        //   432	436	459	finally
      }
    }, new Object[] { this.b }, null);
  }
  
  public void a(final mj parammj, final mi parammi)
  {
    na.a(this.a, new mx()
    {
      public Object a(Object[] paramAnonymousArrayOfObject)
      {
        try
        {
          paramAnonymousArrayOfObject = ((mv.a)paramAnonymousArrayOfObject[0]).getWritableDatabase();
          localObject = new ContentValues();
          ((ContentValues)localObject).put("ip", parammi.a);
          ((ContentValues)localObject).put("measure", parammi.b());
          ((ContentValues)localObject).put("history", parammi.a());
          ((ContentValues)localObject).put("historyIndex", parammi.d);
          ((ContentValues)localObject).put("category", parammi.e);
          ((ContentValues)localObject).put("netIdentifier", parammj.a);
          paramAnonymousArrayOfObject.update("MidasIPTableVer2", (ContentValues)localObject, "ip=? and netIdentifier=?", new String[] { parammi.a, parammj.a });
        }
        catch (Exception paramAnonymousArrayOfObject)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("method=updateIP&exception=");
          ((StringBuilder)localObject).append(paramAnonymousArrayOfObject.toString());
          mp.a("database.exception", ((StringBuilder)localObject).toString());
          paramAnonymousArrayOfObject.printStackTrace();
        }
        return new Object();
      }
    }, new Object[] { this.b }, null);
  }
  
  public void a(my parammy)
  {
    na.a(this.a, new mx()
    {
      /* Error */
      public Object a(Object[] paramAnonymousArrayOfObject)
      {
        // Byte code:
        //   0: new 25	java/util/ArrayList
        //   3: dup
        //   4: invokespecial 26	java/util/ArrayList:<init>	()V
        //   7: astore 7
        //   9: aload_1
        //   10: iconst_0
        //   11: aaload
        //   12: checkcast 28	midas/x/mv$a
        //   15: invokevirtual 32	midas/x/mv$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   18: astore 6
        //   20: aload 6
        //   22: ldc 34
        //   24: aconst_null
        //   25: aconst_null
        //   26: aconst_null
        //   27: aconst_null
        //   28: aconst_null
        //   29: aconst_null
        //   30: invokevirtual 40	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   33: astore 4
        //   35: aload 4
        //   37: astore 5
        //   39: new 42	java/lang/StringBuilder
        //   42: dup
        //   43: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   46: astore 8
        //   48: aload 4
        //   50: astore 5
        //   52: aload 8
        //   54: ldc 45
        //   56: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   59: pop
        //   60: aload 4
        //   62: astore 5
        //   64: aload 8
        //   66: aload 6
        //   68: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   71: pop
        //   72: aload 4
        //   74: astore 5
        //   76: aload 8
        //   78: ldc 54
        //   80: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   83: pop
        //   84: aload 4
        //   86: astore 5
        //   88: aload 8
        //   90: aload 4
        //   92: invokeinterface 60 1 0
        //   97: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   100: pop
        //   101: aload 4
        //   103: astore 5
        //   105: ldc 65
        //   107: aload 8
        //   109: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   112: invokestatic 75	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   115: aload 4
        //   117: ifnull +190 -> 307
        //   120: aload 4
        //   122: astore 5
        //   124: aload 4
        //   126: invokeinterface 60 1 0
        //   131: ifle +176 -> 307
        //   134: aload 4
        //   136: astore 5
        //   138: aload 4
        //   140: invokeinterface 79 1 0
        //   145: pop
        //   146: iconst_0
        //   147: istore_2
        //   148: aload 4
        //   150: astore 5
        //   152: iload_2
        //   153: aload 4
        //   155: invokeinterface 60 1 0
        //   160: if_icmpge +147 -> 307
        //   163: aload 4
        //   165: astore 5
        //   167: new 81	midas/x/mj
        //   170: dup
        //   171: aload 4
        //   173: aload 4
        //   175: ldc 83
        //   177: invokeinterface 87 2 0
        //   182: invokeinterface 91 2 0
        //   187: invokespecial 94	midas/x/mj:<init>	(Ljava/lang/String;)V
        //   190: astore 6
        //   192: aload 4
        //   194: astore 5
        //   196: aload 6
        //   198: aload 4
        //   200: aload 4
        //   202: ldc 96
        //   204: invokeinterface 87 2 0
        //   209: invokeinterface 100 2 0
        //   214: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   217: putfield 109	midas/x/mj:b	Ljava/lang/Long;
        //   220: aload 4
        //   222: astore 5
        //   224: aload 6
        //   226: aload 4
        //   228: aload 4
        //   230: ldc 111
        //   232: invokeinterface 87 2 0
        //   237: invokeinterface 100 2 0
        //   242: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   245: putfield 114	midas/x/mj:d	Ljava/lang/Long;
        //   248: aload 4
        //   250: astore 5
        //   252: aload 6
        //   254: aload 4
        //   256: aload 4
        //   258: ldc 116
        //   260: invokeinterface 87 2 0
        //   265: invokeinterface 100 2 0
        //   270: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   273: putfield 119	midas/x/mj:c	Ljava/lang/Long;
        //   276: aload 4
        //   278: astore 5
        //   280: aload 7
        //   282: aload 6
        //   284: invokevirtual 123	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   287: pop
        //   288: aload 4
        //   290: astore 5
        //   292: aload 4
        //   294: invokeinterface 126 1 0
        //   299: pop
        //   300: iload_2
        //   301: iconst_1
        //   302: iadd
        //   303: istore_2
        //   304: goto -156 -> 148
        //   307: aload 4
        //   309: ifnull +98 -> 407
        //   312: goto +88 -> 400
        //   315: astore 6
        //   317: goto +15 -> 332
        //   320: astore_1
        //   321: aconst_null
        //   322: astore 5
        //   324: goto +617 -> 941
        //   327: astore 6
        //   329: aconst_null
        //   330: astore 4
        //   332: aload 4
        //   334: astore 5
        //   336: new 42	java/lang/StringBuilder
        //   339: dup
        //   340: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   343: astore 8
        //   345: aload 4
        //   347: astore 5
        //   349: aload 8
        //   351: ldc 128
        //   353: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   356: pop
        //   357: aload 4
        //   359: astore 5
        //   361: aload 8
        //   363: aload 6
        //   365: invokevirtual 129	java/lang/Exception:toString	()Ljava/lang/String;
        //   368: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   371: pop
        //   372: aload 4
        //   374: astore 5
        //   376: ldc 131
        //   378: aload 8
        //   380: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   383: invokestatic 135	midas/x/mp:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   386: aload 4
        //   388: astore 5
        //   390: aload 6
        //   392: invokevirtual 138	java/lang/Exception:printStackTrace	()V
        //   395: aload 4
        //   397: ifnull +10 -> 407
        //   400: aload 4
        //   402: invokeinterface 141 1 0
        //   407: new 42	java/lang/StringBuilder
        //   410: dup
        //   411: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   414: astore 4
        //   416: aload 4
        //   418: ldc 143
        //   420: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   423: pop
        //   424: aload 4
        //   426: aload 7
        //   428: invokevirtual 146	java/util/ArrayList:size	()I
        //   431: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   434: pop
        //   435: ldc 65
        //   437: aload 4
        //   439: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   442: invokestatic 75	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   445: aload 7
        //   447: invokevirtual 150	java/util/ArrayList:iterator	()Ljava/util/Iterator;
        //   450: astore 8
        //   452: aload 8
        //   454: invokeinterface 155 1 0
        //   459: ifeq +478 -> 937
        //   462: aload 8
        //   464: invokeinterface 159 1 0
        //   469: checkcast 81	midas/x/mj
        //   472: astore 9
        //   474: new 25	java/util/ArrayList
        //   477: dup
        //   478: invokespecial 26	java/util/ArrayList:<init>	()V
        //   481: astore 10
        //   483: aload_1
        //   484: iconst_0
        //   485: aaload
        //   486: checkcast 28	midas/x/mv$a
        //   489: invokevirtual 32	midas/x/mv$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   492: ldc 161
        //   494: aconst_null
        //   495: ldc 163
        //   497: iconst_1
        //   498: anewarray 165	java/lang/String
        //   501: dup
        //   502: iconst_0
        //   503: aload 9
        //   505: getfield 168	midas/x/mj:a	Ljava/lang/String;
        //   508: aastore
        //   509: aconst_null
        //   510: aconst_null
        //   511: aconst_null
        //   512: invokevirtual 40	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   515: astore 4
        //   517: aload 4
        //   519: astore 5
        //   521: new 42	java/lang/StringBuilder
        //   524: dup
        //   525: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   528: astore 6
        //   530: aload 4
        //   532: astore 5
        //   534: aload 6
        //   536: ldc 170
        //   538: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   541: pop
        //   542: aload 4
        //   544: astore 5
        //   546: aload 6
        //   548: aload 9
        //   550: getfield 168	midas/x/mj:a	Ljava/lang/String;
        //   553: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   556: pop
        //   557: aload 4
        //   559: astore 5
        //   561: aload 6
        //   563: ldc 172
        //   565: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   568: pop
        //   569: aload 4
        //   571: astore 5
        //   573: aload 6
        //   575: aload 4
        //   577: invokeinterface 60 1 0
        //   582: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   585: pop
        //   586: aload 4
        //   588: astore 5
        //   590: ldc 65
        //   592: aload 6
        //   594: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   597: invokestatic 75	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   600: aload 4
        //   602: ifnull +206 -> 808
        //   605: aload 4
        //   607: astore 5
        //   609: aload 4
        //   611: invokeinterface 60 1 0
        //   616: ifle +192 -> 808
        //   619: aload 4
        //   621: astore 5
        //   623: aload 4
        //   625: invokeinterface 79 1 0
        //   630: pop
        //   631: iconst_0
        //   632: istore_2
        //   633: aload 4
        //   635: astore 5
        //   637: iload_2
        //   638: aload 4
        //   640: invokeinterface 60 1 0
        //   645: if_icmpge +163 -> 808
        //   648: aload 4
        //   650: astore 5
        //   652: new 174	midas/x/mi
        //   655: dup
        //   656: aload 4
        //   658: aload 4
        //   660: ldc 176
        //   662: invokeinterface 87 2 0
        //   667: invokeinterface 91 2 0
        //   672: invokespecial 177	midas/x/mi:<init>	(Ljava/lang/String;)V
        //   675: astore 6
        //   677: aload 4
        //   679: astore 5
        //   681: aload 6
        //   683: aload 4
        //   685: aload 4
        //   687: ldc 179
        //   689: invokeinterface 87 2 0
        //   694: invokeinterface 91 2 0
        //   699: invokevirtual 181	midas/x/mi:a	(Ljava/lang/String;)V
        //   702: aload 4
        //   704: astore 5
        //   706: aload 4
        //   708: aload 4
        //   710: ldc 183
        //   712: invokeinterface 87 2 0
        //   717: invokeinterface 187 2 0
        //   722: istore_3
        //   723: aload 4
        //   725: astore 5
        //   727: aload 6
        //   729: aload 4
        //   731: aload 4
        //   733: ldc 189
        //   735: invokeinterface 87 2 0
        //   740: invokeinterface 91 2 0
        //   745: iload_3
        //   746: invokevirtual 192	midas/x/mi:a	(Ljava/lang/String;I)V
        //   749: aload 4
        //   751: astore 5
        //   753: aload 6
        //   755: aload 4
        //   757: aload 4
        //   759: ldc 194
        //   761: invokeinterface 87 2 0
        //   766: invokeinterface 187 2 0
        //   771: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   774: putfield 203	midas/x/mi:e	Ljava/lang/Integer;
        //   777: aload 4
        //   779: astore 5
        //   781: aload 10
        //   783: aload 6
        //   785: invokevirtual 123	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   788: pop
        //   789: aload 4
        //   791: astore 5
        //   793: aload 4
        //   795: invokeinterface 126 1 0
        //   800: pop
        //   801: iload_2
        //   802: iconst_1
        //   803: iadd
        //   804: istore_2
        //   805: goto -172 -> 633
        //   808: aload 4
        //   810: ifnull +98 -> 908
        //   813: goto +88 -> 901
        //   816: astore 6
        //   818: goto +15 -> 833
        //   821: astore_1
        //   822: aconst_null
        //   823: astore 5
        //   825: goto +98 -> 923
        //   828: astore 6
        //   830: aconst_null
        //   831: astore 4
        //   833: aload 4
        //   835: astore 5
        //   837: new 42	java/lang/StringBuilder
        //   840: dup
        //   841: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   844: astore 11
        //   846: aload 4
        //   848: astore 5
        //   850: aload 11
        //   852: ldc 205
        //   854: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   857: pop
        //   858: aload 4
        //   860: astore 5
        //   862: aload 11
        //   864: aload 6
        //   866: invokevirtual 129	java/lang/Exception:toString	()Ljava/lang/String;
        //   869: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   872: pop
        //   873: aload 4
        //   875: astore 5
        //   877: ldc 131
        //   879: aload 11
        //   881: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   884: invokestatic 135	midas/x/mp:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   887: aload 4
        //   889: astore 5
        //   891: aload 6
        //   893: invokevirtual 138	java/lang/Exception:printStackTrace	()V
        //   896: aload 4
        //   898: ifnull +10 -> 908
        //   901: aload 4
        //   903: invokeinterface 141 1 0
        //   908: aload 9
        //   910: getfield 208	midas/x/mj:e	Ljava/util/concurrent/CopyOnWriteArrayList;
        //   913: aload 10
        //   915: invokevirtual 214	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
        //   918: pop
        //   919: goto -467 -> 452
        //   922: astore_1
        //   923: aload 5
        //   925: ifnull +10 -> 935
        //   928: aload 5
        //   930: invokeinterface 141 1 0
        //   935: aload_1
        //   936: athrow
        //   937: aload 7
        //   939: areturn
        //   940: astore_1
        //   941: aload 5
        //   943: ifnull +10 -> 953
        //   946: aload 5
        //   948: invokeinterface 141 1 0
        //   953: aload_1
        //   954: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	955	0	this	6
        //   0	955	1	paramAnonymousArrayOfObject	Object[]
        //   147	658	2	i	int
        //   722	24	3	j	int
        //   33	869	4	localObject1	Object
        //   37	910	5	localObject2	Object
        //   18	265	6	localObject3	Object
        //   315	1	6	localException1	Exception
        //   327	64	6	localException2	Exception
        //   528	256	6	localObject4	Object
        //   816	1	6	localException3	Exception
        //   828	64	6	localException4	Exception
        //   7	931	7	localArrayList1	java.util.ArrayList
        //   46	417	8	localObject5	Object
        //   472	437	9	localmj	mj
        //   481	433	10	localArrayList2	java.util.ArrayList
        //   844	36	11	localStringBuilder	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   39	48	315	java/lang/Exception
        //   52	60	315	java/lang/Exception
        //   64	72	315	java/lang/Exception
        //   76	84	315	java/lang/Exception
        //   88	101	315	java/lang/Exception
        //   105	115	315	java/lang/Exception
        //   124	134	315	java/lang/Exception
        //   138	146	315	java/lang/Exception
        //   152	163	315	java/lang/Exception
        //   167	192	315	java/lang/Exception
        //   196	220	315	java/lang/Exception
        //   224	248	315	java/lang/Exception
        //   252	276	315	java/lang/Exception
        //   280	288	315	java/lang/Exception
        //   292	300	315	java/lang/Exception
        //   9	35	320	finally
        //   9	35	327	java/lang/Exception
        //   521	530	816	java/lang/Exception
        //   534	542	816	java/lang/Exception
        //   546	557	816	java/lang/Exception
        //   561	569	816	java/lang/Exception
        //   573	586	816	java/lang/Exception
        //   590	600	816	java/lang/Exception
        //   609	619	816	java/lang/Exception
        //   623	631	816	java/lang/Exception
        //   637	648	816	java/lang/Exception
        //   652	677	816	java/lang/Exception
        //   681	702	816	java/lang/Exception
        //   706	723	816	java/lang/Exception
        //   727	749	816	java/lang/Exception
        //   753	777	816	java/lang/Exception
        //   781	789	816	java/lang/Exception
        //   793	801	816	java/lang/Exception
        //   483	517	821	finally
        //   483	517	828	java/lang/Exception
        //   521	530	922	finally
        //   534	542	922	finally
        //   546	557	922	finally
        //   561	569	922	finally
        //   573	586	922	finally
        //   590	600	922	finally
        //   609	619	922	finally
        //   623	631	922	finally
        //   637	648	922	finally
        //   652	677	922	finally
        //   681	702	922	finally
        //   706	723	922	finally
        //   727	749	922	finally
        //   753	777	922	finally
        //   781	789	922	finally
        //   793	801	922	finally
        //   837	846	922	finally
        //   850	858	922	finally
        //   862	873	922	finally
        //   877	887	922	finally
        //   891	896	922	finally
        //   39	48	940	finally
        //   52	60	940	finally
        //   64	72	940	finally
        //   76	84	940	finally
        //   88	101	940	finally
        //   105	115	940	finally
        //   124	134	940	finally
        //   138	146	940	finally
        //   152	163	940	finally
        //   167	192	940	finally
        //   196	220	940	finally
        //   224	248	940	finally
        //   252	276	940	finally
        //   280	288	940	finally
        //   292	300	940	finally
        //   336	345	940	finally
        //   349	357	940	finally
        //   361	372	940	finally
        //   376	386	940	finally
        //   390	395	940	finally
      }
    }, new Object[] { this.b }, parammy);
  }
  
  /* Error */
  public java.util.ArrayList<mj> b()
  {
    // Byte code:
    //   0: new 84	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 85	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 49	midas/x/mv:b	Lmidas/x/mv$a;
    //   13: invokevirtual 89	midas/x/mv$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 5
    //   18: aload 5
    //   20: ldc 91
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 97	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_3
    //   32: aload_3
    //   33: astore 4
    //   35: new 99	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   42: astore 7
    //   44: aload_3
    //   45: astore 4
    //   47: aload 7
    //   49: ldc 102
    //   51: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: astore 4
    //   58: aload 7
    //   60: aload 5
    //   62: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_3
    //   67: astore 4
    //   69: aload 7
    //   71: ldc 111
    //   73: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_3
    //   78: astore 4
    //   80: aload 7
    //   82: aload_3
    //   83: invokeinterface 117 1 0
    //   88: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: astore 4
    //   95: ldc 122
    //   97: aload 7
    //   99: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 131	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_3
    //   106: ifnull +169 -> 275
    //   109: aload_3
    //   110: astore 4
    //   112: aload_3
    //   113: invokeinterface 117 1 0
    //   118: ifle +157 -> 275
    //   121: aload_3
    //   122: astore 4
    //   124: aload_3
    //   125: invokeinterface 134 1 0
    //   130: pop
    //   131: iconst_0
    //   132: istore_1
    //   133: aload_3
    //   134: astore 4
    //   136: iload_1
    //   137: aload_3
    //   138: invokeinterface 117 1 0
    //   143: if_icmpge +132 -> 275
    //   146: aload_3
    //   147: astore 4
    //   149: new 136	midas/x/mj
    //   152: dup
    //   153: aload_3
    //   154: aload_3
    //   155: ldc 138
    //   157: invokeinterface 142 2 0
    //   162: invokeinterface 146 2 0
    //   167: invokespecial 149	midas/x/mj:<init>	(Ljava/lang/String;)V
    //   170: astore 5
    //   172: aload_3
    //   173: astore 4
    //   175: aload 5
    //   177: aload_3
    //   178: aload_3
    //   179: ldc 151
    //   181: invokeinterface 142 2 0
    //   186: invokeinterface 155 2 0
    //   191: invokestatic 161	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: putfield 164	midas/x/mj:b	Ljava/lang/Long;
    //   197: aload_3
    //   198: astore 4
    //   200: aload 5
    //   202: aload_3
    //   203: aload_3
    //   204: ldc 166
    //   206: invokeinterface 142 2 0
    //   211: invokeinterface 155 2 0
    //   216: invokestatic 161	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   219: putfield 169	midas/x/mj:c	Ljava/lang/Long;
    //   222: aload_3
    //   223: astore 4
    //   225: aload 5
    //   227: aload_3
    //   228: aload_3
    //   229: ldc 171
    //   231: invokeinterface 142 2 0
    //   236: invokeinterface 155 2 0
    //   241: invokestatic 161	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   244: putfield 174	midas/x/mj:d	Ljava/lang/Long;
    //   247: aload_3
    //   248: astore 4
    //   250: aload 6
    //   252: aload 5
    //   254: invokevirtual 178	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   257: pop
    //   258: aload_3
    //   259: astore 4
    //   261: aload_3
    //   262: invokeinterface 181 1 0
    //   267: pop
    //   268: iload_1
    //   269: iconst_1
    //   270: iadd
    //   271: istore_1
    //   272: goto -139 -> 133
    //   275: aload_3
    //   276: ifnull +90 -> 366
    //   279: goto +81 -> 360
    //   282: astore 5
    //   284: goto +14 -> 298
    //   287: astore_3
    //   288: aconst_null
    //   289: astore 4
    //   291: goto +562 -> 853
    //   294: astore 5
    //   296: aconst_null
    //   297: astore_3
    //   298: aload_3
    //   299: astore 4
    //   301: new 99	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   308: astore 7
    //   310: aload_3
    //   311: astore 4
    //   313: aload 7
    //   315: ldc 183
    //   317: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_3
    //   322: astore 4
    //   324: aload 7
    //   326: aload 5
    //   328: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   331: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_3
    //   336: astore 4
    //   338: ldc 186
    //   340: aload 7
    //   342: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 190	midas/x/mp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload_3
    //   349: astore 4
    //   351: aload 5
    //   353: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   356: aload_3
    //   357: ifnull +9 -> 366
    //   360: aload_3
    //   361: invokeinterface 194 1 0
    //   366: new 99	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   373: astore_3
    //   374: aload_3
    //   375: ldc 196
    //   377: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_3
    //   382: aload 6
    //   384: invokevirtual 199	java/util/ArrayList:size	()I
    //   387: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: ldc 122
    //   393: aload_3
    //   394: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 131	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload 6
    //   402: invokevirtual 203	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   405: astore 7
    //   407: aload 7
    //   409: invokeinterface 208 1 0
    //   414: ifeq +435 -> 849
    //   417: aload 7
    //   419: invokeinterface 212 1 0
    //   424: checkcast 136	midas/x/mj
    //   427: astore 8
    //   429: new 84	java/util/ArrayList
    //   432: dup
    //   433: invokespecial 85	java/util/ArrayList:<init>	()V
    //   436: astore 9
    //   438: aload_0
    //   439: getfield 49	midas/x/mv:b	Lmidas/x/mv$a;
    //   442: invokevirtual 89	midas/x/mv$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   445: ldc 214
    //   447: aconst_null
    //   448: ldc 216
    //   450: iconst_1
    //   451: anewarray 218	java/lang/String
    //   454: dup
    //   455: iconst_0
    //   456: aload 8
    //   458: getfield 221	midas/x/mj:a	Ljava/lang/String;
    //   461: aastore
    //   462: aconst_null
    //   463: aconst_null
    //   464: aconst_null
    //   465: invokevirtual 97	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   468: astore_3
    //   469: aload_3
    //   470: astore 4
    //   472: new 99	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   479: astore 5
    //   481: aload_3
    //   482: astore 4
    //   484: aload 5
    //   486: ldc 223
    //   488: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload_3
    //   493: astore 4
    //   495: aload 5
    //   497: aload 8
    //   499: getfield 221	midas/x/mj:a	Ljava/lang/String;
    //   502: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_3
    //   507: astore 4
    //   509: aload 5
    //   511: ldc 225
    //   513: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload_3
    //   518: astore 4
    //   520: aload 5
    //   522: aload_3
    //   523: invokeinterface 117 1 0
    //   528: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload_3
    //   533: astore 4
    //   535: ldc 122
    //   537: aload 5
    //   539: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 131	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: aload_3
    //   546: ifnull +182 -> 728
    //   549: aload_3
    //   550: astore 4
    //   552: aload_3
    //   553: invokeinterface 117 1 0
    //   558: ifle +170 -> 728
    //   561: aload_3
    //   562: astore 4
    //   564: aload_3
    //   565: invokeinterface 134 1 0
    //   570: pop
    //   571: iconst_0
    //   572: istore_1
    //   573: aload_3
    //   574: astore 4
    //   576: iload_1
    //   577: aload_3
    //   578: invokeinterface 117 1 0
    //   583: if_icmpge +145 -> 728
    //   586: aload_3
    //   587: astore 4
    //   589: new 227	midas/x/mi
    //   592: dup
    //   593: aload_3
    //   594: aload_3
    //   595: ldc 229
    //   597: invokeinterface 142 2 0
    //   602: invokeinterface 146 2 0
    //   607: invokespecial 230	midas/x/mi:<init>	(Ljava/lang/String;)V
    //   610: astore 5
    //   612: aload_3
    //   613: astore 4
    //   615: aload 5
    //   617: aload_3
    //   618: aload_3
    //   619: ldc 232
    //   621: invokeinterface 142 2 0
    //   626: invokeinterface 146 2 0
    //   631: invokevirtual 234	midas/x/mi:a	(Ljava/lang/String;)V
    //   634: aload_3
    //   635: astore 4
    //   637: aload_3
    //   638: aload_3
    //   639: ldc 236
    //   641: invokeinterface 142 2 0
    //   646: invokeinterface 240 2 0
    //   651: istore_2
    //   652: aload_3
    //   653: astore 4
    //   655: aload 5
    //   657: aload_3
    //   658: aload_3
    //   659: ldc 242
    //   661: invokeinterface 142 2 0
    //   666: invokeinterface 146 2 0
    //   671: iload_2
    //   672: invokevirtual 245	midas/x/mi:a	(Ljava/lang/String;I)V
    //   675: aload_3
    //   676: astore 4
    //   678: aload 5
    //   680: aload_3
    //   681: aload_3
    //   682: ldc 247
    //   684: invokeinterface 142 2 0
    //   689: invokeinterface 240 2 0
    //   694: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   697: putfield 256	midas/x/mi:e	Ljava/lang/Integer;
    //   700: aload_3
    //   701: astore 4
    //   703: aload 9
    //   705: aload 5
    //   707: invokevirtual 178	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   710: pop
    //   711: aload_3
    //   712: astore 4
    //   714: aload_3
    //   715: invokeinterface 181 1 0
    //   720: pop
    //   721: iload_1
    //   722: iconst_1
    //   723: iadd
    //   724: istore_1
    //   725: goto -152 -> 573
    //   728: aload_3
    //   729: ifnull +91 -> 820
    //   732: goto +82 -> 814
    //   735: astore 5
    //   737: goto +14 -> 751
    //   740: astore_3
    //   741: aconst_null
    //   742: astore 4
    //   744: goto +91 -> 835
    //   747: astore 5
    //   749: aconst_null
    //   750: astore_3
    //   751: aload_3
    //   752: astore 4
    //   754: new 99	java/lang/StringBuilder
    //   757: dup
    //   758: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   761: astore 10
    //   763: aload_3
    //   764: astore 4
    //   766: aload 10
    //   768: ldc_w 258
    //   771: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload_3
    //   776: astore 4
    //   778: aload 10
    //   780: aload 5
    //   782: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   785: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: aload_3
    //   790: astore 4
    //   792: ldc 186
    //   794: aload 10
    //   796: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 190	midas/x/mp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: aload_3
    //   803: astore 4
    //   805: aload 5
    //   807: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   810: aload_3
    //   811: ifnull +9 -> 820
    //   814: aload_3
    //   815: invokeinterface 194 1 0
    //   820: aload 8
    //   822: getfield 261	midas/x/mj:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   825: aload 9
    //   827: invokevirtual 267	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   830: pop
    //   831: goto -424 -> 407
    //   834: astore_3
    //   835: aload 4
    //   837: ifnull +10 -> 847
    //   840: aload 4
    //   842: invokeinterface 194 1 0
    //   847: aload_3
    //   848: athrow
    //   849: aload 6
    //   851: areturn
    //   852: astore_3
    //   853: aload 4
    //   855: ifnull +10 -> 865
    //   858: aload 4
    //   860: invokeinterface 194 1 0
    //   865: aload_3
    //   866: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	867	0	this	mv
    //   132	593	1	i	int
    //   651	21	2	j	int
    //   31	245	3	localCursor	android.database.Cursor
    //   287	1	3	localObject1	Object
    //   297	432	3	localObject2	Object
    //   740	1	3	localObject3	Object
    //   750	65	3	localObject4	Object
    //   834	14	3	localObject5	Object
    //   852	14	3	localObject6	Object
    //   33	826	4	localObject7	Object
    //   16	237	5	localObject8	Object
    //   282	1	5	localException1	Exception
    //   294	58	5	localException2	Exception
    //   479	227	5	localObject9	Object
    //   735	1	5	localException3	Exception
    //   747	59	5	localException4	Exception
    //   7	843	6	localArrayList1	java.util.ArrayList
    //   42	376	7	localObject10	Object
    //   427	394	8	localmj	mj
    //   436	390	9	localArrayList2	java.util.ArrayList
    //   761	34	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   35	44	282	java/lang/Exception
    //   47	55	282	java/lang/Exception
    //   58	66	282	java/lang/Exception
    //   69	77	282	java/lang/Exception
    //   80	92	282	java/lang/Exception
    //   95	105	282	java/lang/Exception
    //   112	121	282	java/lang/Exception
    //   124	131	282	java/lang/Exception
    //   136	146	282	java/lang/Exception
    //   149	172	282	java/lang/Exception
    //   175	197	282	java/lang/Exception
    //   200	222	282	java/lang/Exception
    //   225	247	282	java/lang/Exception
    //   250	258	282	java/lang/Exception
    //   261	268	282	java/lang/Exception
    //   9	32	287	finally
    //   9	32	294	java/lang/Exception
    //   472	481	735	java/lang/Exception
    //   484	492	735	java/lang/Exception
    //   495	506	735	java/lang/Exception
    //   509	517	735	java/lang/Exception
    //   520	532	735	java/lang/Exception
    //   535	545	735	java/lang/Exception
    //   552	561	735	java/lang/Exception
    //   564	571	735	java/lang/Exception
    //   576	586	735	java/lang/Exception
    //   589	612	735	java/lang/Exception
    //   615	634	735	java/lang/Exception
    //   637	652	735	java/lang/Exception
    //   655	675	735	java/lang/Exception
    //   678	700	735	java/lang/Exception
    //   703	711	735	java/lang/Exception
    //   714	721	735	java/lang/Exception
    //   438	469	740	finally
    //   438	469	747	java/lang/Exception
    //   472	481	834	finally
    //   484	492	834	finally
    //   495	506	834	finally
    //   509	517	834	finally
    //   520	532	834	finally
    //   535	545	834	finally
    //   552	561	834	finally
    //   564	571	834	finally
    //   576	586	834	finally
    //   589	612	834	finally
    //   615	634	834	finally
    //   637	652	834	finally
    //   655	675	834	finally
    //   678	700	834	finally
    //   703	711	834	finally
    //   714	721	834	finally
    //   754	763	834	finally
    //   766	775	834	finally
    //   778	789	834	finally
    //   792	802	834	finally
    //   805	810	834	finally
    //   35	44	852	finally
    //   47	55	852	finally
    //   58	66	852	finally
    //   69	77	852	finally
    //   80	92	852	finally
    //   95	105	852	finally
    //   112	121	852	finally
    //   124	131	852	finally
    //   136	146	852	finally
    //   149	172	852	finally
    //   175	197	852	finally
    //   200	222	852	finally
    //   225	247	852	finally
    //   250	258	852	finally
    //   261	268	852	finally
    //   301	310	852	finally
    //   313	321	852	finally
    //   324	335	852	finally
    //   338	348	852	finally
    //   351	356	852	finally
  }
  
  public void b(final mj parammj)
  {
    na.a(this.a, new mx()
    {
      /* Error */
      public Object a(Object[] paramAnonymousArrayOfObject)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore_3
        //   5: aload_3
        //   6: astore_2
        //   7: aload_1
        //   8: iconst_0
        //   9: aaload
        //   10: checkcast 29	midas/x/mv$a
        //   13: invokevirtual 33	midas/x/mv$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   16: astore 5
        //   18: aload_3
        //   19: astore_2
        //   20: aload 5
        //   22: ldc 35
        //   24: aconst_null
        //   25: ldc 37
        //   27: iconst_1
        //   28: anewarray 39	java/lang/String
        //   31: dup
        //   32: iconst_0
        //   33: aload_0
        //   34: getfield 20	midas/x/mv$3:a	Lmidas/x/mj;
        //   37: getfield 44	midas/x/mj:a	Ljava/lang/String;
        //   40: aastore
        //   41: aconst_null
        //   42: aconst_null
        //   43: aconst_null
        //   44: invokevirtual 50	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   47: astore_1
        //   48: aload_1
        //   49: ifnonnull +15 -> 64
        //   52: aload_1
        //   53: invokeinterface 56 1 0
        //   58: ifle +91 -> 149
        //   61: goto +3 -> 64
        //   64: new 58	android/content/ContentValues
        //   67: dup
        //   68: invokespecial 59	android/content/ContentValues:<init>	()V
        //   71: astore_2
        //   72: aload_2
        //   73: ldc 61
        //   75: aload_0
        //   76: getfield 20	midas/x/mv$3:a	Lmidas/x/mj;
        //   79: getfield 44	midas/x/mj:a	Ljava/lang/String;
        //   82: invokevirtual 65	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   85: aload_2
        //   86: ldc 67
        //   88: aload_0
        //   89: getfield 20	midas/x/mv$3:a	Lmidas/x/mj;
        //   92: getfield 70	midas/x/mj:b	Ljava/lang/Long;
        //   95: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
        //   98: aload_2
        //   99: ldc 75
        //   101: aload_0
        //   102: getfield 20	midas/x/mv$3:a	Lmidas/x/mj;
        //   105: getfield 78	midas/x/mj:d	Ljava/lang/Long;
        //   108: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
        //   111: aload_2
        //   112: ldc 80
        //   114: aload_0
        //   115: getfield 20	midas/x/mv$3:a	Lmidas/x/mj;
        //   118: getfield 83	midas/x/mj:c	Ljava/lang/Long;
        //   121: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
        //   124: aload 5
        //   126: ldc 35
        //   128: aload_2
        //   129: ldc 37
        //   131: iconst_1
        //   132: anewarray 39	java/lang/String
        //   135: dup
        //   136: iconst_0
        //   137: aload_0
        //   138: getfield 20	midas/x/mv$3:a	Lmidas/x/mj;
        //   141: getfield 44	midas/x/mj:a	Ljava/lang/String;
        //   144: aastore
        //   145: invokevirtual 87	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
        //   148: pop
        //   149: aload_1
        //   150: ifnull +85 -> 235
        //   153: aload_1
        //   154: invokeinterface 90 1 0
        //   159: goto +76 -> 235
        //   162: astore_3
        //   163: aload_2
        //   164: astore_1
        //   165: aload_3
        //   166: astore_2
        //   167: goto +76 -> 243
        //   170: astore_3
        //   171: aload 4
        //   173: astore_1
        //   174: aload_1
        //   175: astore_2
        //   176: new 92	java/lang/StringBuilder
        //   179: dup
        //   180: invokespecial 93	java/lang/StringBuilder:<init>	()V
        //   183: astore 4
        //   185: aload_1
        //   186: astore_2
        //   187: aload 4
        //   189: ldc 95
        //   191: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   194: pop
        //   195: aload_1
        //   196: astore_2
        //   197: aload 4
        //   199: aload_3
        //   200: invokevirtual 103	java/lang/Exception:toString	()Ljava/lang/String;
        //   203: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   206: pop
        //   207: aload_1
        //   208: astore_2
        //   209: ldc 105
        //   211: aload 4
        //   213: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   216: invokestatic 110	midas/x/mp:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   219: aload_1
        //   220: astore_2
        //   221: aload_3
        //   222: invokevirtual 113	java/lang/Exception:printStackTrace	()V
        //   225: aload_1
        //   226: ifnull +9 -> 235
        //   229: aload_1
        //   230: invokeinterface 90 1 0
        //   235: new 4	java/lang/Object
        //   238: dup
        //   239: invokespecial 23	java/lang/Object:<init>	()V
        //   242: areturn
        //   243: aload_1
        //   244: ifnull +9 -> 253
        //   247: aload_1
        //   248: invokeinterface 90 1 0
        //   253: aload_2
        //   254: athrow
        //   255: astore_2
        //   256: goto -13 -> 243
        //   259: astore_3
        //   260: goto -86 -> 174
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	263	0	this	3
        //   0	263	1	paramAnonymousArrayOfObject	Object[]
        //   6	248	2	localObject1	Object
        //   255	1	2	localObject2	Object
        //   4	15	3	localObject3	Object
        //   162	4	3	localObject4	Object
        //   170	52	3	localException1	Exception
        //   259	1	3	localException2	Exception
        //   1	211	4	localStringBuilder	StringBuilder
        //   16	109	5	localSQLiteDatabase	SQLiteDatabase
        // Exception table:
        //   from	to	target	type
        //   7	18	162	finally
        //   20	48	162	finally
        //   176	185	162	finally
        //   187	195	162	finally
        //   197	207	162	finally
        //   209	219	162	finally
        //   221	225	162	finally
        //   7	18	170	java/lang/Exception
        //   20	48	170	java/lang/Exception
        //   52	61	255	finally
        //   64	149	255	finally
        //   52	61	259	java/lang/Exception
        //   64	149	259	java/lang/Exception
      }
    }, new Object[] { this.b }, null);
  }
  
  public void c(final mj parammj)
  {
    na.a(this.a, new mx()
    {
      /* Error */
      public Object a(Object[] paramAnonymousArrayOfObject)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore_3
        //   5: aload_3
        //   6: astore_2
        //   7: aload_1
        //   8: iconst_0
        //   9: aaload
        //   10: checkcast 30	midas/x/mv$a
        //   13: invokevirtual 34	midas/x/mv$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   16: astore 5
        //   18: aload_3
        //   19: astore_2
        //   20: aload 5
        //   22: ldc 36
        //   24: aconst_null
        //   25: ldc 38
        //   27: iconst_1
        //   28: anewarray 40	java/lang/String
        //   31: dup
        //   32: iconst_0
        //   33: aload_0
        //   34: getfield 21	midas/x/mv$4:a	Lmidas/x/mj;
        //   37: getfield 45	midas/x/mj:a	Ljava/lang/String;
        //   40: aastore
        //   41: aconst_null
        //   42: aconst_null
        //   43: aconst_null
        //   44: invokevirtual 51	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   47: astore_1
        //   48: aload_1
        //   49: ifnull +15 -> 64
        //   52: aload_1
        //   53: invokeinterface 57 1 0
        //   58: ifgt +76 -> 134
        //   61: goto +3 -> 64
        //   64: new 59	android/content/ContentValues
        //   67: dup
        //   68: invokespecial 60	android/content/ContentValues:<init>	()V
        //   71: astore_2
        //   72: aload_2
        //   73: ldc 62
        //   75: aload_0
        //   76: getfield 21	midas/x/mv$4:a	Lmidas/x/mj;
        //   79: getfield 45	midas/x/mj:a	Ljava/lang/String;
        //   82: invokevirtual 66	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   85: aload_2
        //   86: ldc 68
        //   88: aload_0
        //   89: getfield 21	midas/x/mv$4:a	Lmidas/x/mj;
        //   92: getfield 71	midas/x/mj:b	Ljava/lang/Long;
        //   95: invokevirtual 74	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
        //   98: aload_2
        //   99: ldc 76
        //   101: aload_0
        //   102: getfield 21	midas/x/mv$4:a	Lmidas/x/mj;
        //   105: getfield 79	midas/x/mj:d	Ljava/lang/Long;
        //   108: invokevirtual 74	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
        //   111: aload_2
        //   112: ldc 81
        //   114: aload_0
        //   115: getfield 21	midas/x/mv$4:a	Lmidas/x/mj;
        //   118: getfield 83	midas/x/mj:c	Ljava/lang/Long;
        //   121: invokevirtual 74	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
        //   124: aload 5
        //   126: ldc 36
        //   128: aconst_null
        //   129: aload_2
        //   130: invokevirtual 87	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
        //   133: pop2
        //   134: aload_1
        //   135: ifnull +85 -> 220
        //   138: aload_1
        //   139: invokeinterface 90 1 0
        //   144: goto +76 -> 220
        //   147: astore_3
        //   148: aload_2
        //   149: astore_1
        //   150: aload_3
        //   151: astore_2
        //   152: goto +76 -> 228
        //   155: astore_3
        //   156: aload 4
        //   158: astore_1
        //   159: aload_1
        //   160: astore_2
        //   161: new 92	java/lang/StringBuilder
        //   164: dup
        //   165: invokespecial 93	java/lang/StringBuilder:<init>	()V
        //   168: astore 4
        //   170: aload_1
        //   171: astore_2
        //   172: aload 4
        //   174: ldc 95
        //   176: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   179: pop
        //   180: aload_1
        //   181: astore_2
        //   182: aload 4
        //   184: aload_3
        //   185: invokevirtual 103	java/lang/Exception:toString	()Ljava/lang/String;
        //   188: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   191: pop
        //   192: aload_1
        //   193: astore_2
        //   194: ldc 105
        //   196: aload 4
        //   198: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   201: invokestatic 110	midas/x/mp:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   204: aload_1
        //   205: astore_2
        //   206: aload_3
        //   207: invokevirtual 113	java/lang/Exception:printStackTrace	()V
        //   210: aload_1
        //   211: ifnull +9 -> 220
        //   214: aload_1
        //   215: invokeinterface 90 1 0
        //   220: new 4	java/lang/Object
        //   223: dup
        //   224: invokespecial 24	java/lang/Object:<init>	()V
        //   227: areturn
        //   228: aload_1
        //   229: ifnull +9 -> 238
        //   232: aload_1
        //   233: invokeinterface 90 1 0
        //   238: aload_2
        //   239: athrow
        //   240: astore_2
        //   241: goto -13 -> 228
        //   244: astore_3
        //   245: goto -86 -> 159
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	248	0	this	4
        //   0	248	1	paramAnonymousArrayOfObject	Object[]
        //   6	233	2	localObject1	Object
        //   240	1	2	localObject2	Object
        //   4	15	3	localObject3	Object
        //   147	4	3	localObject4	Object
        //   155	52	3	localException1	Exception
        //   244	1	3	localException2	Exception
        //   1	196	4	localStringBuilder	StringBuilder
        //   16	109	5	localSQLiteDatabase	SQLiteDatabase
        // Exception table:
        //   from	to	target	type
        //   7	18	147	finally
        //   20	48	147	finally
        //   161	170	147	finally
        //   172	180	147	finally
        //   182	192	147	finally
        //   194	204	147	finally
        //   206	210	147	finally
        //   7	18	155	java/lang/Exception
        //   20	48	155	java/lang/Exception
        //   52	61	240	finally
        //   64	134	240	finally
        //   52	61	244	java/lang/Exception
        //   64	134	244	java/lang/Exception
      }
    }, new Object[] { this.b }, null);
  }
  
  public void d(final mj parammj)
  {
    na.a(this.a, new mx()
    {
      /* Error */
      public Object a(Object[] paramAnonymousArrayOfObject)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: aconst_null
        //   3: astore_2
        //   4: aload_1
        //   5: iconst_0
        //   6: aaload
        //   7: checkcast 30	midas/x/mv$a
        //   10: invokevirtual 34	midas/x/mv$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
        //   13: astore_1
        //   14: aload_1
        //   15: invokevirtual 39	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
        //   18: aload_1
        //   19: ldc 41
        //   21: ldc 43
        //   23: iconst_1
        //   24: anewarray 45	java/lang/String
        //   27: dup
        //   28: iconst_0
        //   29: aload_0
        //   30: getfield 21	midas/x/mv$5:a	Lmidas/x/mj;
        //   33: getfield 50	midas/x/mj:a	Ljava/lang/String;
        //   36: aastore
        //   37: invokevirtual 54	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
        //   40: pop
        //   41: aload_1
        //   42: ldc 56
        //   44: ldc 58
        //   46: iconst_1
        //   47: anewarray 45	java/lang/String
        //   50: dup
        //   51: iconst_0
        //   52: aload_0
        //   53: getfield 21	midas/x/mv$5:a	Lmidas/x/mj;
        //   56: getfield 50	midas/x/mj:a	Ljava/lang/String;
        //   59: aastore
        //   60: invokevirtual 54	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
        //   63: pop
        //   64: aload_1
        //   65: invokevirtual 61	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
        //   68: aload_1
        //   69: ifnull +104 -> 173
        //   72: aload_1
        //   73: invokevirtual 65	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
        //   76: ifeq +97 -> 173
        //   79: aload_1
        //   80: invokevirtual 68	android/database/sqlite/SQLiteDatabase:endTransaction	()V
        //   83: goto +90 -> 173
        //   86: astore_2
        //   87: goto +94 -> 181
        //   90: astore_3
        //   91: goto +16 -> 107
        //   94: astore_3
        //   95: aload_2
        //   96: astore_1
        //   97: aload_3
        //   98: astore_2
        //   99: goto +82 -> 181
        //   102: astore_2
        //   103: aload_3
        //   104: astore_1
        //   105: aload_2
        //   106: astore_3
        //   107: aload_1
        //   108: astore_2
        //   109: new 70	java/lang/StringBuilder
        //   112: dup
        //   113: invokespecial 71	java/lang/StringBuilder:<init>	()V
        //   116: astore 4
        //   118: aload_1
        //   119: astore_2
        //   120: aload 4
        //   122: ldc 73
        //   124: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   127: pop
        //   128: aload_1
        //   129: astore_2
        //   130: aload 4
        //   132: aload_3
        //   133: invokevirtual 81	java/lang/Exception:toString	()Ljava/lang/String;
        //   136: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: pop
        //   140: aload_1
        //   141: astore_2
        //   142: ldc 83
        //   144: aload 4
        //   146: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   149: invokestatic 89	midas/x/mp:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   152: aload_1
        //   153: astore_2
        //   154: aload_3
        //   155: invokevirtual 92	java/lang/Exception:printStackTrace	()V
        //   158: aload_1
        //   159: ifnull +14 -> 173
        //   162: aload_1
        //   163: invokevirtual 65	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
        //   166: ifeq +7 -> 173
        //   169: aload_1
        //   170: invokevirtual 68	android/database/sqlite/SQLiteDatabase:endTransaction	()V
        //   173: new 4	java/lang/Object
        //   176: dup
        //   177: invokespecial 24	java/lang/Object:<init>	()V
        //   180: areturn
        //   181: aload_1
        //   182: ifnull +14 -> 196
        //   185: aload_1
        //   186: invokevirtual 65	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
        //   189: ifeq +7 -> 196
        //   192: aload_1
        //   193: invokevirtual 68	android/database/sqlite/SQLiteDatabase:endTransaction	()V
        //   196: aload_2
        //   197: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	198	0	this	5
        //   0	198	1	paramAnonymousArrayOfObject	Object[]
        //   3	1	2	localObject1	Object
        //   86	10	2	localObject2	Object
        //   98	1	2	localObject3	Object
        //   102	4	2	localException1	Exception
        //   108	89	2	arrayOfObject	Object[]
        //   1	1	3	localObject4	Object
        //   90	1	3	localException2	Exception
        //   94	10	3	localObject5	Object
        //   106	49	3	localObject6	Object
        //   116	29	4	localStringBuilder	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   14	68	86	finally
        //   14	68	90	java/lang/Exception
        //   4	14	94	finally
        //   109	118	94	finally
        //   120	128	94	finally
        //   130	140	94	finally
        //   142	152	94	finally
        //   154	158	94	finally
        //   4	14	102	java/lang/Exception
      }
    }, new Object[] { this.b }, null);
  }
  
  class a
    extends SQLiteOpenHelper
  {
    public a(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
    {
      super(paramString, paramCursorFactory, paramInt);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      mn.a("IPDatabaseImpl", "onCreate");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MidasNetTableVer2 ( identifier VARCHAR(128), updatetime INTEGER, accesstime INTEGER, measuretime INTEGER )");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MidasIPTableVer2 ( ip VARCHAR(64), measure VARCHAR(128), history VARCHAR(1024), historyIndex INTEGER, category INTEGER, netIdentifier VARCHAR(128))");
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      mn.a("IPDatabaseImpl", "onUpgrade");
      if (paramInt1 < 2)
      {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MidasNetTableVer2 ( identifier VARCHAR(128), updatetime INTEGER, accesstime INTEGER, measuretime INTEGER )");
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MidasIPTableVer2 ( ip VARCHAR(64), measure VARCHAR(128), history VARCHAR(1024), historyIndex INTEGER, category INTEGER, netIdentifier VARCHAR(128))");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.mv
 * JD-Core Version:    0.7.0.1
 */