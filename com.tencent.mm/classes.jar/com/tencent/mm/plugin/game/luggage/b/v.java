package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.luggage.d.b;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;

public class v
  extends br<i>
{
  /* Error */
  public final void a(android.content.Context paramContext, String paramString, com.tencent.mm.plugin.webview.luggage.jsapi.br.a parama)
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
    //   57: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload 6
    //   62: ldc 53
    //   64: invokevirtual 57	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   67: ifeq +142 -> 209
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
    //   99: aload_2
    //   100: ldc 69
    //   102: aload 6
    //   104: ldc 69
    //   106: invokevirtual 32	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   109: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   112: pop
    //   113: new 74	com/tencent/mm/g/a/ox
    //   116: dup
    //   117: invokespecial 75	com/tencent/mm/g/a/ox:<init>	()V
    //   120: astore 6
    //   122: aload 6
    //   124: getfield 79	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   127: iload 4
    //   129: putfield 85	com/tencent/mm/g/a/ox$a:dUY	I
    //   132: aload 6
    //   134: getfield 79	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   137: iload 5
    //   139: putfield 87	com/tencent/mm/g/a/ox$a:jumpType	I
    //   142: aload_2
    //   143: ifnull +15 -> 158
    //   146: aload 6
    //   148: getfield 79	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   151: aload_2
    //   152: invokevirtual 91	org/json/JSONObject:toString	()Ljava/lang/String;
    //   155: putfield 95	com/tencent/mm/g/a/ox$a:extraInfo	Ljava/lang/String;
    //   158: aload 6
    //   160: getfield 79	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   163: aload_1
    //   164: putfield 99	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   167: getstatic 105	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   170: aload 6
    //   172: invokevirtual 109	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   175: pop
    //   176: aload_3
    //   177: aconst_null
    //   178: aconst_null
    //   179: invokevirtual 114	com/tencent/mm/plugin/webview/luggage/jsapi/br$a:i	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   182: ldc 15
    //   184: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: return
    //   188: astore_1
    //   189: ldc 36
    //   191: ldc 119
    //   193: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload_3
    //   197: ldc 125
    //   199: aconst_null
    //   200: invokevirtual 114	com/tencent/mm/plugin/webview/luggage/jsapi/br$a:i	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   203: ldc 15
    //   205: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: return
    //   209: new 23	org/json/JSONObject
    //   212: dup
    //   213: invokespecial 126	org/json/JSONObject:<init>	()V
    //   216: astore_2
    //   217: goto -132 -> 85
    //   220: astore_2
    //   221: aconst_null
    //   222: astore_2
    //   223: goto -110 -> 113
    //   226: astore 6
    //   228: goto -115 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	v
    //   0	231	1	paramContext	android.content.Context
    //   0	231	2	paramString	String
    //   0	231	3	parama	com.tencent.mm.plugin.webview.luggage.jsapi.br.a
    //   22	106	4	i	int
    //   31	107	5	j	int
    //   13	158	6	localObject	java.lang.Object
    //   226	1	6	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   5	15	188	org/json/JSONException
    //   60	85	220	org/json/JSONException
    //   209	217	220	org/json/JSONException
    //   85	113	226	org/json/JSONException
  }
  
  public final void b(b<i>.a paramb) {}
  
  public final int dTs()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openGameCenter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.v
 * JD-Core Version:    0.7.0.1
 */