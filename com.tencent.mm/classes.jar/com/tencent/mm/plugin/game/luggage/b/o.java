package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.luggage.d.a;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;

public class o
  extends bh<f>
{
  /* Error */
  public final void a(android.content.Context paramContext, String paramString, com.tencent.mm.plugin.webview.luggage.jsapi.bh.a parama)
  {
    // Byte code:
    //   0: ldc 15
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 23	org/json/JSONObject
    //   8: dup
    //   9: aload_2
    //   10: invokespecial 26	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 28
    //   17: invokevirtual 32	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   20: istore 4
    //   22: aload_2
    //   23: ldc 34
    //   25: invokevirtual 32	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   28: istore 5
    //   30: ldc 36
    //   32: ldc 38
    //   34: iconst_2
    //   35: anewarray 40	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: iload 4
    //   42: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: iload 5
    //   50: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: aastore
    //   54: invokestatic 51	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: new 23	org/json/JSONObject
    //   60: dup
    //   61: aload_2
    //   62: ldc 53
    //   64: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokespecial 26	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   70: astore_2
    //   71: new 59	com/tencent/mm/g/a/mb
    //   74: dup
    //   75: invokespecial 60	com/tencent/mm/g/a/mb:<init>	()V
    //   78: astore 6
    //   80: aload 6
    //   82: getfield 64	com/tencent/mm/g/a/mb:cCh	Lcom/tencent/mm/g/a/mb$a;
    //   85: iload 4
    //   87: putfield 70	com/tencent/mm/g/a/mb$a:cCi	I
    //   90: aload 6
    //   92: getfield 64	com/tencent/mm/g/a/mb:cCh	Lcom/tencent/mm/g/a/mb$a;
    //   95: iload 5
    //   97: putfield 72	com/tencent/mm/g/a/mb$a:jumpType	I
    //   100: aload_2
    //   101: ifnull +15 -> 116
    //   104: aload 6
    //   106: getfield 64	com/tencent/mm/g/a/mb:cCh	Lcom/tencent/mm/g/a/mb$a;
    //   109: aload_2
    //   110: invokevirtual 76	org/json/JSONObject:toString	()Ljava/lang/String;
    //   113: putfield 80	com/tencent/mm/g/a/mb$a:extraInfo	Ljava/lang/String;
    //   116: aload 6
    //   118: getfield 64	com/tencent/mm/g/a/mb:cCh	Lcom/tencent/mm/g/a/mb$a;
    //   121: aload_1
    //   122: putfield 84	com/tencent/mm/g/a/mb$a:context	Landroid/content/Context;
    //   125: getstatic 90	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   128: aload 6
    //   130: invokevirtual 94	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   133: pop
    //   134: aload_3
    //   135: aconst_null
    //   136: aconst_null
    //   137: invokevirtual 100	com/tencent/mm/plugin/webview/luggage/jsapi/bh$a:c	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   140: ldc 15
    //   142: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: return
    //   146: astore_1
    //   147: ldc 36
    //   149: ldc 105
    //   151: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_3
    //   155: ldc 111
    //   157: aconst_null
    //   158: invokevirtual 100	com/tencent/mm/plugin/webview/luggage/jsapi/bh$a:c	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   161: ldc 15
    //   163: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: return
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_2
    //   170: goto -99 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	o
    //   0	173	1	paramContext	android.content.Context
    //   0	173	2	paramString	String
    //   0	173	3	parama	com.tencent.mm.plugin.webview.luggage.jsapi.bh.a
    //   20	66	4	i	int
    //   28	68	5	j	int
    //   78	51	6	localmb	com.tencent.mm.g.a.mb
    // Exception table:
    //   from	to	target	type
    //   5	14	146	org/json/JSONException
    //   57	71	167	org/json/JSONException
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openGameCenter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.o
 * JD-Core Version:    0.7.0.1
 */