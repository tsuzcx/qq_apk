package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class ql
{
  private static final String c = "https://confinfo.map.qq.com/confinfo?";
  Context a;
  WeakReference<a> b;
  
  public ql(Context paramContext, a parama)
  {
    AppMethodBeat.i(225929);
    this.a = paramContext;
    this.b = new WeakReference(parama);
    AppMethodBeat.o(225929);
  }
  
  private static int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(225946);
    paramString = new JSONObject(paramString);
    int i = paramInt;
    if (paramString.optInt("error", -1) == 0)
    {
      paramString = paramString.optJSONObject("info");
      i = paramInt;
      if (paramString != null) {
        i = paramString.optInt("scenic", paramInt);
      }
    }
    AppMethodBeat.o(225946);
    return i;
  }
  
  static String a(Context paramContext)
  {
    AppMethodBeat.i(225958);
    if (paramContext == null)
    {
      AppMethodBeat.o(225958);
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null)
      {
        AppMethodBeat.o(225958);
        return "";
      }
      if (paramContext.metaData == null)
      {
        AppMethodBeat.o(225958);
        return "";
      }
      paramContext = paramContext.metaData.getString("TencentMapSDK");
      AppMethodBeat.o(225958);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  private void a()
  {
    AppMethodBeat.i(225938);
    new b((byte)0).execute(new Context[] { this.a });
    AppMethodBeat.o(225938);
  }
  
  public static abstract interface a
  {
    public abstract void c();
  }
  
  final class b
    extends AsyncTask<Context, Void, Void>
  {
    private b() {}
    
    /* Error */
    private Void a(Context... paramVarArgs)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: iconst_1
      //   4: istore_2
      //   5: ldc 23
      //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   10: invokestatic 34	com/tencent/mapsdk/internal/qi:a	()I
      //   13: istore_3
      //   14: new 36	java/lang/StringBuilder
      //   17: dup
      //   18: invokespecial 37	java/lang/StringBuilder:<init>	()V
      //   21: astore 6
      //   23: aload 6
      //   25: ldc 39
      //   27: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: pop
      //   31: aload 6
      //   33: ldc 45
      //   35: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   38: pop
      //   39: aload_1
      //   40: ifnull +23 -> 63
      //   43: aload_1
      //   44: arraylength
      //   45: ifle +18 -> 63
      //   48: aload 6
      //   50: aload_1
      //   51: iconst_0
      //   52: aaload
      //   53: invokevirtual 51	android/content/Context:getApplicationContext	()Landroid/content/Context;
      //   56: invokestatic 54	com/tencent/mapsdk/internal/ql:a	(Landroid/content/Context;)Ljava/lang/String;
      //   59: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   62: pop
      //   63: invokestatic 60	com/tencent/map/tools/net/NetManager:getInstance	()Lcom/tencent/map/tools/net/NetManager;
      //   66: invokevirtual 64	com/tencent/map/tools/net/NetManager:builder	()Lcom/tencent/map/tools/net/NetRequest$NetRequestBuilder;
      //   69: aload 6
      //   71: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   74: invokevirtual 74	com/tencent/map/tools/net/NetRequest$NetRequestBuilder:url	(Ljava/lang/String;)Lcom/tencent/map/tools/net/NetRequest$NetRequestBuilder;
      //   77: sipush 3000
      //   80: invokevirtual 78	com/tencent/map/tools/net/NetRequest$NetRequestBuilder:timeOut	(I)Lcom/tencent/map/tools/net/NetRequest$NetRequestBuilder;
      //   83: invokevirtual 82	com/tencent/map/tools/net/NetRequest$NetRequestBuilder:doStream	()Lcom/tencent/map/tools/net/NetResponse;
      //   86: astore 6
      //   88: aload 6
      //   90: getfield 88	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
      //   93: astore_1
      //   94: aload_1
      //   95: invokestatic 93	com/tencent/mapsdk/internal/kb:b	(Ljava/io/InputStream;)[B
      //   98: astore 7
      //   100: aload 7
      //   102: ifnull +13 -> 115
      //   105: aload 7
      //   107: arraylength
      //   108: istore 5
      //   110: iload 5
      //   112: ifne +86 -> 198
      //   115: aload_1
      //   116: ifnull +7 -> 123
      //   119: aload_1
      //   120: invokestatic 96	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
      //   123: aload 6
      //   125: ifnull +11 -> 136
      //   128: aload 6
      //   130: getfield 88	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
      //   133: invokestatic 96	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
      //   136: iload_3
      //   137: invokestatic 34	com/tencent/mapsdk/internal/qi:a	()I
      //   140: if_icmpeq +53 -> 193
      //   143: iload_2
      //   144: ifeq +42 -> 186
      //   147: aload_0
      //   148: getfield 14	com/tencent/mapsdk/internal/ql$b:a	Lcom/tencent/mapsdk/internal/ql;
      //   151: getfield 99	com/tencent/mapsdk/internal/ql:a	Landroid/content/Context;
      //   154: ifnull +32 -> 186
      //   157: aload_0
      //   158: getfield 14	com/tencent/mapsdk/internal/ql$b:a	Lcom/tencent/mapsdk/internal/ql;
      //   161: getfield 99	com/tencent/mapsdk/internal/ql:a	Landroid/content/Context;
      //   164: iload_3
      //   165: invokestatic 102	com/tencent/mapsdk/internal/qi:a	(Landroid/content/Context;I)V
      //   168: aload_0
      //   169: getfield 14	com/tencent/mapsdk/internal/ql$b:a	Lcom/tencent/mapsdk/internal/ql;
      //   172: getfield 105	com/tencent/mapsdk/internal/ql:b	Ljava/lang/ref/WeakReference;
      //   175: invokevirtual 111	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   178: checkcast 113	com/tencent/mapsdk/internal/ql$a
      //   181: invokeinterface 116 1 0
      //   186: ldc 23
      //   188: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   191: aconst_null
      //   192: areturn
      //   193: iconst_0
      //   194: istore_2
      //   195: goto -52 -> 143
      //   198: new 121	org/json/JSONObject
      //   201: dup
      //   202: new 123	java/lang/String
      //   205: dup
      //   206: aload 7
      //   208: invokespecial 126	java/lang/String:<init>	([B)V
      //   211: invokespecial 129	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   214: astore 7
      //   216: iload_3
      //   217: istore_2
      //   218: aload 7
      //   220: ldc 131
      //   222: iconst_m1
      //   223: invokevirtual 135	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   226: ifne +28 -> 254
      //   229: aload 7
      //   231: ldc 137
      //   233: invokevirtual 141	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   236: astore 7
      //   238: iload_3
      //   239: istore_2
      //   240: aload 7
      //   242: ifnull +12 -> 254
      //   245: aload 7
      //   247: ldc 143
      //   249: iload_3
      //   250: invokevirtual 135	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   253: istore_2
      //   254: aload_1
      //   255: ifnull +7 -> 262
      //   258: aload_1
      //   259: invokestatic 96	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
      //   262: aload 6
      //   264: ifnull +11 -> 275
      //   267: aload 6
      //   269: getfield 88	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
      //   272: invokestatic 96	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
      //   275: iload_2
      //   276: invokestatic 34	com/tencent/mapsdk/internal/qi:a	()I
      //   279: if_icmpeq +56 -> 335
      //   282: iload 4
      //   284: istore_3
      //   285: iload_3
      //   286: ifeq +42 -> 328
      //   289: aload_0
      //   290: getfield 14	com/tencent/mapsdk/internal/ql$b:a	Lcom/tencent/mapsdk/internal/ql;
      //   293: getfield 99	com/tencent/mapsdk/internal/ql:a	Landroid/content/Context;
      //   296: ifnull +32 -> 328
      //   299: aload_0
      //   300: getfield 14	com/tencent/mapsdk/internal/ql$b:a	Lcom/tencent/mapsdk/internal/ql;
      //   303: getfield 99	com/tencent/mapsdk/internal/ql:a	Landroid/content/Context;
      //   306: iload_2
      //   307: invokestatic 102	com/tencent/mapsdk/internal/qi:a	(Landroid/content/Context;I)V
      //   310: aload_0
      //   311: getfield 14	com/tencent/mapsdk/internal/ql$b:a	Lcom/tencent/mapsdk/internal/ql;
      //   314: getfield 105	com/tencent/mapsdk/internal/ql:b	Ljava/lang/ref/WeakReference;
      //   317: invokevirtual 111	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   320: checkcast 113	com/tencent/mapsdk/internal/ql$a
      //   323: invokeinterface 116 1 0
      //   328: ldc 23
      //   330: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   333: aconst_null
      //   334: areturn
      //   335: iconst_0
      //   336: istore_3
      //   337: goto -52 -> 285
      //   340: astore_1
      //   341: aconst_null
      //   342: astore_1
      //   343: aload_1
      //   344: ifnull +7 -> 351
      //   347: aload_1
      //   348: invokestatic 96	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
      //   351: aload 6
      //   353: ifnull +11 -> 364
      //   356: aload 6
      //   358: getfield 88	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
      //   361: invokestatic 96	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
      //   364: iload_3
      //   365: invokestatic 34	com/tencent/mapsdk/internal/qi:a	()I
      //   368: if_icmpeq +51 -> 419
      //   371: iconst_1
      //   372: istore_2
      //   373: iload_2
      //   374: ifeq -46 -> 328
      //   377: aload_0
      //   378: getfield 14	com/tencent/mapsdk/internal/ql$b:a	Lcom/tencent/mapsdk/internal/ql;
      //   381: getfield 99	com/tencent/mapsdk/internal/ql:a	Landroid/content/Context;
      //   384: ifnull -56 -> 328
      //   387: aload_0
      //   388: getfield 14	com/tencent/mapsdk/internal/ql$b:a	Lcom/tencent/mapsdk/internal/ql;
      //   391: getfield 99	com/tencent/mapsdk/internal/ql:a	Landroid/content/Context;
      //   394: iload_3
      //   395: invokestatic 102	com/tencent/mapsdk/internal/qi:a	(Landroid/content/Context;I)V
      //   398: aload_0
      //   399: getfield 14	com/tencent/mapsdk/internal/ql$b:a	Lcom/tencent/mapsdk/internal/ql;
      //   402: getfield 105	com/tencent/mapsdk/internal/ql:b	Ljava/lang/ref/WeakReference;
      //   405: invokevirtual 111	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   408: checkcast 113	com/tencent/mapsdk/internal/ql$a
      //   411: invokeinterface 116 1 0
      //   416: goto -88 -> 328
      //   419: iconst_0
      //   420: istore_2
      //   421: goto -48 -> 373
      //   424: astore 7
      //   426: goto -83 -> 343
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	429	0	this	b
      //   0	429	1	paramVarArgs	Context[]
      //   4	417	2	i	int
      //   13	382	3	j	int
      //   1	282	4	k	int
      //   108	3	5	m	int
      //   21	336	6	localObject1	Object
      //   98	148	7	localObject2	Object
      //   424	1	7	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   88	94	340	finally
      //   94	100	424	finally
      //   105	110	424	finally
      //   198	216	424	finally
      //   218	238	424	finally
      //   245	254	424	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ql
 * JD-Core Version:    0.7.0.1
 */