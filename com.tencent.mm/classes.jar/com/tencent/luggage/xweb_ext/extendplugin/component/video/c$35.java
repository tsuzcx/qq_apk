package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.f.i.h;

final class c$35
  implements h
{
  c$35(c paramc, String paramString) {}
  
  public final String getKey()
  {
    return "VideoPluginHandler_checkVideoUrl";
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 33
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 19	com/tencent/luggage/xweb_ext/extendplugin/component/video/c$35:cJF	Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/c;
    //   9: astore 6
    //   11: aload_0
    //   12: getfield 21	com/tencent/luggage/xweb_ext/extendplugin/component/video/c$35:cJK	Ljava/lang/String;
    //   15: astore_3
    //   16: aload_3
    //   17: invokestatic 45	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   20: ifne +154 -> 174
    //   23: aload_3
    //   24: ldc 47
    //   26: invokevirtual 52	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   29: ifeq +145 -> 174
    //   32: aconst_null
    //   33: astore_2
    //   34: aconst_null
    //   35: astore 5
    //   37: new 54	java/net/URL
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 56	java/net/URL:<init>	(Ljava/lang/String;)V
    //   45: invokevirtual 60	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   48: checkcast 62	java/net/HttpURLConnection
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 65	java/net/HttpURLConnection:connect	()V
    //   56: aload_3
    //   57: invokevirtual 69	java/net/HttpURLConnection:getResponseCode	()I
    //   60: istore_1
    //   61: aload 6
    //   63: invokevirtual 72	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:getLogTag	()Ljava/lang/String;
    //   66: ldc 74
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: iload_1
    //   75: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: aastore
    //   79: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: iload_1
    //   83: sipush 400
    //   86: if_icmplt +13 -> 99
    //   89: aload 6
    //   91: sipush -4006
    //   94: iload_1
    //   95: invokevirtual 89	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:ca	(II)Z
    //   98: pop
    //   99: aload_3
    //   100: ifnull +74 -> 174
    //   103: aload_3
    //   104: invokevirtual 92	java/net/HttpURLConnection:disconnect	()V
    //   107: ldc 33
    //   109: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: return
    //   113: astore 4
    //   115: aload 5
    //   117: astore_3
    //   118: aload_3
    //   119: astore_2
    //   120: aload 6
    //   122: invokevirtual 72	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:getLogTag	()Ljava/lang/String;
    //   125: aload 4
    //   127: ldc 97
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload 4
    //   137: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: aastore
    //   141: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aload_3
    //   145: ifnull +29 -> 174
    //   148: aload_3
    //   149: invokevirtual 92	java/net/HttpURLConnection:disconnect	()V
    //   152: ldc 33
    //   154: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: return
    //   158: astore_3
    //   159: aload_2
    //   160: ifnull +7 -> 167
    //   163: aload_2
    //   164: invokevirtual 92	java/net/HttpURLConnection:disconnect	()V
    //   167: ldc 33
    //   169: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_3
    //   173: athrow
    //   174: ldc 33
    //   176: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: return
    //   180: astore 4
    //   182: aload_3
    //   183: astore_2
    //   184: aload 4
    //   186: astore_3
    //   187: goto -28 -> 159
    //   190: astore 4
    //   192: goto -74 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	35
    //   60	35	1	i	int
    //   33	151	2	localObject1	Object
    //   15	134	3	localObject2	Object
    //   158	25	3	localObject3	Object
    //   186	1	3	localObject4	Object
    //   113	23	4	localException1	java.lang.Exception
    //   180	5	4	localObject5	Object
    //   190	1	4	localException2	java.lang.Exception
    //   35	81	5	localObject6	Object
    //   9	112	6	localc	c
    // Exception table:
    //   from	to	target	type
    //   37	52	113	java/lang/Exception
    //   37	52	158	finally
    //   120	144	158	finally
    //   52	82	180	finally
    //   89	99	180	finally
    //   52	82	190	java/lang/Exception
    //   89	99	190	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.35
 * JD-Core Version:    0.7.0.1
 */