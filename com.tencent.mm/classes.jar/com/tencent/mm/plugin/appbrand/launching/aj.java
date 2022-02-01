package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class aj
  extends MAutoStorage<ak>
{
  public static final String tbu;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(47281);
    tbu = MAutoStorage.getCreateSQLs(ak.DB_INFO, "LaunchWxaAppRespTable");
    AppMethodBeat.o(47281);
  }
  
  public aj(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ak.DB_INFO, "LaunchWxaAppRespTable", ak.INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  private boolean a(ak paramak, boolean paramBoolean)
  {
    AppMethodBeat.i(47275);
    paramak.field_appIdHash = paramak.field_appId.hashCode();
    super.insertNotify(paramak, paramBoolean);
    paramBoolean = a(paramak, new String[] { "appId" });
    Log.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", new Object[] { paramak.field_appId, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(47275);
    return paramBoolean;
  }
  
  private boolean a(ak paramak, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(47273);
    int i;
    if (!Util.isNullOrNil(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramak.field_appIdHash = paramak.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.delete(paramak, paramBoolean, paramVarArgs);
        AppMethodBeat.o(47273);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  private boolean b(ak paramak, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(47276);
    int i;
    if (!Util.isNullOrNil(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramak.field_appIdHash = paramak.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.updateNotify(paramak, paramBoolean, paramVarArgs);
        Log.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", new Object[] { paramak.field_appId, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(47276);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  /* Error */
  public final ak a(String paramString, com.tencent.mm.protocal.protobuf.dgu paramdgu)
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 119	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +7 -> 16
    //   12: aload_2
    //   13: ifnonnull +10 -> 23
    //   16: ldc 116
    //   18: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: invokestatic 123	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   26: lstore_3
    //   27: iconst_0
    //   28: istore 5
    //   30: iconst_0
    //   31: istore 6
    //   33: iload 6
    //   35: istore 7
    //   37: iload 5
    //   39: istore 8
    //   41: new 20	com/tencent/mm/plugin/appbrand/launching/ak
    //   44: dup
    //   45: invokespecial 125	com/tencent/mm/plugin/appbrand/launching/ak:<init>	()V
    //   48: astore 10
    //   50: iload 6
    //   52: istore 7
    //   54: iload 5
    //   56: istore 8
    //   58: aload 10
    //   60: aload_2
    //   61: invokevirtual 128	com/tencent/mm/plugin/appbrand/launching/ak:b	(Lcom/tencent/mm/protocal/protobuf/dgu;)V
    //   64: iload 6
    //   66: istore 7
    //   68: iload 5
    //   70: istore 8
    //   72: aload 10
    //   74: aload_1
    //   75: putfield 53	com/tencent/mm/plugin/appbrand/launching/ak:field_appId	Ljava/lang/String;
    //   78: iload 6
    //   80: istore 7
    //   82: iload 5
    //   84: istore 8
    //   86: new 20	com/tencent/mm/plugin/appbrand/launching/ak
    //   89: dup
    //   90: invokespecial 125	com/tencent/mm/plugin/appbrand/launching/ak:<init>	()V
    //   93: astore_2
    //   94: iload 6
    //   96: istore 7
    //   98: iload 5
    //   100: istore 8
    //   102: aload_2
    //   103: aload_1
    //   104: putfield 53	com/tencent/mm/plugin/appbrand/launching/ak:field_appId	Ljava/lang/String;
    //   107: iload 6
    //   109: istore 7
    //   111: iload 5
    //   113: istore 8
    //   115: aload_0
    //   116: aload_2
    //   117: iconst_1
    //   118: anewarray 55	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: ldc 69
    //   125: aastore
    //   126: invokevirtual 72	com/tencent/mm/plugin/appbrand/launching/aj:a	(Lcom/tencent/mm/plugin/appbrand/launching/ak;[Ljava/lang/String;)Z
    //   129: ifne +138 -> 267
    //   132: iconst_1
    //   133: istore 5
    //   135: iload 5
    //   137: ifne +270 -> 407
    //   140: iload 6
    //   142: istore 7
    //   144: iload 5
    //   146: istore 8
    //   148: aload_2
    //   149: aload 10
    //   151: invokevirtual 129	com/tencent/mm/plugin/appbrand/launching/ak:equals	(Ljava/lang/Object;)Z
    //   154: ifne +119 -> 273
    //   157: goto +250 -> 407
    //   160: iload 6
    //   162: ifeq +24 -> 186
    //   165: iload 5
    //   167: ifeq +112 -> 279
    //   170: iload 6
    //   172: istore 7
    //   174: iload 5
    //   176: istore 8
    //   178: aload_0
    //   179: aload 10
    //   181: iconst_0
    //   182: invokespecial 131	com/tencent/mm/plugin/appbrand/launching/aj:a	(Lcom/tencent/mm/plugin/appbrand/launching/ak;Z)Z
    //   185: pop
    //   186: iload 6
    //   188: ifeq +169 -> 357
    //   191: iload 6
    //   193: istore 7
    //   195: iload 5
    //   197: istore 8
    //   199: aload_0
    //   200: aload_2
    //   201: iconst_1
    //   202: anewarray 55	java/lang/String
    //   205: dup
    //   206: iconst_0
    //   207: ldc 69
    //   209: aastore
    //   210: invokevirtual 72	com/tencent/mm/plugin/appbrand/launching/aj:a	(Lcom/tencent/mm/plugin/appbrand/launching/ak;[Ljava/lang/String;)Z
    //   213: istore 9
    //   215: iload 9
    //   217: ifeq +140 -> 357
    //   220: ldc 74
    //   222: ldc 133
    //   224: iconst_4
    //   225: anewarray 78	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload_1
    //   231: aastore
    //   232: dup
    //   233: iconst_1
    //   234: getstatic 137	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: iload 5
    //   242: invokestatic 84	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: invokestatic 123	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   251: lload_3
    //   252: lsub
    //   253: invokestatic 142	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   256: aastore
    //   257: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: ldc 116
    //   262: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: aload_2
    //   266: areturn
    //   267: iconst_0
    //   268: istore 5
    //   270: goto -135 -> 135
    //   273: iconst_0
    //   274: istore 6
    //   276: goto -116 -> 160
    //   279: iload 6
    //   281: istore 7
    //   283: iload 5
    //   285: istore 8
    //   287: aload_0
    //   288: aload 10
    //   290: iconst_0
    //   291: iconst_1
    //   292: anewarray 55	java/lang/String
    //   295: dup
    //   296: iconst_0
    //   297: ldc 69
    //   299: aastore
    //   300: invokespecial 144	com/tencent/mm/plugin/appbrand/launching/aj:b	(Lcom/tencent/mm/plugin/appbrand/launching/ak;Z[Ljava/lang/String;)Z
    //   303: pop
    //   304: goto -118 -> 186
    //   307: astore_2
    //   308: ldc 74
    //   310: ldc 133
    //   312: iconst_4
    //   313: anewarray 78	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: aload_1
    //   319: aastore
    //   320: dup
    //   321: iconst_1
    //   322: iload 7
    //   324: invokestatic 84	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   327: aastore
    //   328: dup
    //   329: iconst_2
    //   330: iload 8
    //   332: invokestatic 84	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   335: aastore
    //   336: dup
    //   337: iconst_3
    //   338: invokestatic 123	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   341: lload_3
    //   342: lsub
    //   343: invokestatic 142	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   346: aastore
    //   347: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   350: ldc 116
    //   352: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   355: aload_2
    //   356: athrow
    //   357: ldc 74
    //   359: ldc 133
    //   361: iconst_4
    //   362: anewarray 78	java/lang/Object
    //   365: dup
    //   366: iconst_0
    //   367: aload_1
    //   368: aastore
    //   369: dup
    //   370: iconst_1
    //   371: iload 6
    //   373: invokestatic 84	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   376: aastore
    //   377: dup
    //   378: iconst_2
    //   379: iload 5
    //   381: invokestatic 84	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   384: aastore
    //   385: dup
    //   386: iconst_3
    //   387: invokestatic 123	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   390: lload_3
    //   391: lsub
    //   392: invokestatic 142	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   395: aastore
    //   396: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   399: ldc 116
    //   401: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   404: aload 10
    //   406: areturn
    //   407: iconst_1
    //   408: istore 6
    //   410: goto -250 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	aj
    //   0	413	1	paramString	String
    //   0	413	2	paramdgu	com.tencent.mm.protocal.protobuf.dgu
    //   26	365	3	l	long
    //   28	352	5	bool1	boolean
    //   31	378	6	bool2	boolean
    //   35	288	7	bool3	boolean
    //   39	292	8	bool4	boolean
    //   213	3	9	bool5	boolean
    //   48	357	10	localak	ak
    // Exception table:
    //   from	to	target	type
    //   41	50	307	finally
    //   58	64	307	finally
    //   72	78	307	finally
    //   86	94	307	finally
    //   102	107	307	finally
    //   115	132	307	finally
    //   148	157	307	finally
    //   178	186	307	finally
    //   199	215	307	finally
    //   287	304	307	finally
  }
  
  public final boolean a(ak paramak, String... paramVarArgs)
  {
    AppMethodBeat.i(47274);
    int i;
    if (!Util.isNullOrNil(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramak.field_appIdHash = paramak.field_appId.hashCode();
        }
      }
      else
      {
        boolean bool = super.get(paramak, paramVarArgs);
        AppMethodBeat.o(47274);
        return bool;
      }
      i += 1;
    }
  }
  
  public final boolean iP(String paramString)
  {
    AppMethodBeat.i(47272);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47272);
      return false;
    }
    ak localak = new ak();
    localak.field_appId = paramString;
    boolean bool = a(localak, false, new String[] { "appId" });
    AppMethodBeat.o(47272);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aj
 * JD-Core Version:    0.7.0.1
 */