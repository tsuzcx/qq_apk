package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.luggage.d.a;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;

public class q
  extends bn<f>
{
  /* Error */
  public final void a(android.content.Context paramContext, String paramString, com.tencent.mm.plugin.webview.luggage.jsapi.bn.a parama)
  {
    // Byte code:
    //   0: ldc 15
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 23	org/json/JSONObject
    //   8: dup
    //   9: aload_2
    //   10: invokespecial 26	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc 28
    //   19: invokevirtual 32	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   22: istore 4
    //   24: aload 6
    //   26: ldc 34
    //   28: invokevirtual 32	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   31: istore 5
    //   33: ldc 36
    //   35: ldc 38
    //   37: iconst_2
    //   38: anewarray 40	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: iload 4
    //   45: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: iload 5
    //   53: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: aastore
    //   57: invokestatic 51	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload 6
    //   62: ldc 53
    //   64: invokevirtual 57	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   67: ifeq +128 -> 195
    //   70: new 23	org/json/JSONObject
    //   73: dup
    //   74: aload 6
    //   76: ldc 53
    //   78: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   81: invokespecial 26	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   84: astore_2
    //   85: aload_2
    //   86: ldc 63
    //   88: aload 6
    //   90: ldc 63
    //   92: invokevirtual 61	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: pop
    //   99: new 69	com/tencent/mm/g/a/nw
    //   102: dup
    //   103: invokespecial 70	com/tencent/mm/g/a/nw:<init>	()V
    //   106: astore 6
    //   108: aload 6
    //   110: getfield 74	com/tencent/mm/g/a/nw:dqq	Lcom/tencent/mm/g/a/nw$a;
    //   113: iload 4
    //   115: putfield 80	com/tencent/mm/g/a/nw$a:dqr	I
    //   118: aload 6
    //   120: getfield 74	com/tencent/mm/g/a/nw:dqq	Lcom/tencent/mm/g/a/nw$a;
    //   123: iload 5
    //   125: putfield 82	com/tencent/mm/g/a/nw$a:jumpType	I
    //   128: aload_2
    //   129: ifnull +15 -> 144
    //   132: aload 6
    //   134: getfield 74	com/tencent/mm/g/a/nw:dqq	Lcom/tencent/mm/g/a/nw$a;
    //   137: aload_2
    //   138: invokevirtual 86	org/json/JSONObject:toString	()Ljava/lang/String;
    //   141: putfield 90	com/tencent/mm/g/a/nw$a:extraInfo	Ljava/lang/String;
    //   144: aload 6
    //   146: getfield 74	com/tencent/mm/g/a/nw:dqq	Lcom/tencent/mm/g/a/nw$a;
    //   149: aload_1
    //   150: putfield 94	com/tencent/mm/g/a/nw$a:context	Landroid/content/Context;
    //   153: getstatic 100	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   156: aload 6
    //   158: invokevirtual 104	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   161: pop
    //   162: aload_3
    //   163: aconst_null
    //   164: aconst_null
    //   165: invokevirtual 110	com/tencent/mm/plugin/webview/luggage/jsapi/bn$a:f	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   168: ldc 15
    //   170: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: return
    //   174: astore_1
    //   175: ldc 36
    //   177: ldc 115
    //   179: invokestatic 119	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_3
    //   183: ldc 121
    //   185: aconst_null
    //   186: invokevirtual 110	com/tencent/mm/plugin/webview/luggage/jsapi/bn$a:f	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   189: ldc 15
    //   191: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: return
    //   195: new 23	org/json/JSONObject
    //   198: dup
    //   199: invokespecial 122	org/json/JSONObject:<init>	()V
    //   202: astore_2
    //   203: goto -118 -> 85
    //   206: astore_2
    //   207: aconst_null
    //   208: astore_2
    //   209: goto -110 -> 99
    //   212: astore 6
    //   214: goto -115 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	q
    //   0	217	1	paramContext	android.content.Context
    //   0	217	2	paramString	String
    //   0	217	3	parama	com.tencent.mm.plugin.webview.luggage.jsapi.bn.a
    //   22	92	4	i	int
    //   31	93	5	j	int
    //   13	144	6	localObject	java.lang.Object
    //   212	1	6	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   5	15	174	org/json/JSONException
    //   60	85	206	org/json/JSONException
    //   195	203	206	org/json/JSONException
    //   85	99	212	org/json/JSONException
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bYk()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openGameCenter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.q
 * JD-Core Version:    0.7.0.1
 */