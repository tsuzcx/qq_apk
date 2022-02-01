package com.tencent.luggage.k.a.d;

public final class a$a
{
  public String cob;
  public String coc;
  public String cod;
  public Integer coe;
  public boolean cof;
  public boolean cog;
  
  /* Error */
  public a$a(a parama, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 28	com/tencent/luggage/k/a/d/a$a:cnZ	Lcom/tencent/luggage/k/a/d/a;
    //   5: aload_0
    //   6: invokespecial 31	java/lang/Object:<init>	()V
    //   9: ldc 32
    //   11: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_0
    //   15: ldc 40
    //   17: putfield 42	com/tencent/luggage/k/a/d/a$a:cob	Ljava/lang/String;
    //   20: aload_0
    //   21: ldc 40
    //   23: putfield 44	com/tencent/luggage/k/a/d/a$a:coc	Ljava/lang/String;
    //   26: aload_0
    //   27: ldc 40
    //   29: putfield 46	com/tencent/luggage/k/a/d/a$a:cod	Ljava/lang/String;
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 48	com/tencent/luggage/k/a/d/a$a:coe	Ljava/lang/Integer;
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 50	com/tencent/luggage/k/a/d/a$a:cof	Z
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 52	com/tencent/luggage/k/a/d/a$a:cog	Z
    //   47: ldc 54
    //   49: ldc 56
    //   51: aload_2
    //   52: invokestatic 62	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   55: invokevirtual 66	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: aload_2
    //   63: putfield 42	com/tencent/luggage/k/a/d/a$a:cob	Ljava/lang/String;
    //   66: new 73	org/json/JSONObject
    //   69: dup
    //   70: aload_2
    //   71: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   74: astore_1
    //   75: aload_1
    //   76: ldc 78
    //   78: invokevirtual 82	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   81: ifeq +13 -> 94
    //   84: aload_0
    //   85: aload_1
    //   86: ldc 78
    //   88: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: putfield 44	com/tencent/luggage/k/a/d/a$a:coc	Ljava/lang/String;
    //   94: aload_1
    //   95: ldc 87
    //   97: invokevirtual 82	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   100: ifeq +13 -> 113
    //   103: aload_0
    //   104: aload_1
    //   105: ldc 87
    //   107: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: putfield 46	com/tencent/luggage/k/a/d/a$a:cod	Ljava/lang/String;
    //   113: aload_1
    //   114: ldc 89
    //   116: invokevirtual 82	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   119: ifeq +20 -> 139
    //   122: aload_0
    //   123: aload_1
    //   124: ldc 89
    //   126: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: iconst_0
    //   130: invokestatic 95	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   133: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: putfield 48	com/tencent/luggage/k/a/d/a$a:coe	Ljava/lang/Integer;
    //   139: aload_1
    //   140: ldc 102
    //   142: invokevirtual 82	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   145: ifeq +17 -> 162
    //   148: aload_0
    //   149: aload_1
    //   150: ldc 102
    //   152: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: iconst_0
    //   156: invokestatic 106	com/tencent/mm/sdk/platformtools/bt:getBoolean	(Ljava/lang/String;Z)Z
    //   159: putfield 50	com/tencent/luggage/k/a/d/a$a:cof	Z
    //   162: aload_1
    //   163: ldc 108
    //   165: invokevirtual 82	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   168: ifeq +17 -> 185
    //   171: aload_0
    //   172: aload_1
    //   173: ldc 108
    //   175: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   178: iconst_0
    //   179: invokestatic 106	com/tencent/mm/sdk/platformtools/bt:getBoolean	(Ljava/lang/String;Z)Z
    //   182: putfield 52	com/tencent/luggage/k/a/d/a$a:cog	Z
    //   185: ldc 32
    //   187: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: return
    //   191: astore_1
    //   192: ldc 54
    //   194: ldc 113
    //   196: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: new 73	org/json/JSONObject
    //   202: dup
    //   203: invokespecial 117	org/json/JSONObject:<init>	()V
    //   206: astore_1
    //   207: goto -132 -> 75
    //   210: astore_2
    //   211: ldc 54
    //   213: ldc 119
    //   215: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: goto -124 -> 94
    //   221: astore_2
    //   222: ldc 54
    //   224: ldc 121
    //   226: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: goto -116 -> 113
    //   232: astore_2
    //   233: ldc 54
    //   235: ldc 123
    //   237: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: goto -101 -> 139
    //   243: astore_2
    //   244: ldc 54
    //   246: ldc 125
    //   248: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: goto -112 -> 139
    //   254: astore_2
    //   255: ldc 54
    //   257: ldc 125
    //   259: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: goto -123 -> 139
    //   265: astore_2
    //   266: ldc 54
    //   268: ldc 127
    //   270: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: goto -111 -> 162
    //   276: astore_2
    //   277: ldc 54
    //   279: ldc 127
    //   281: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: goto -122 -> 162
    //   287: astore_1
    //   288: ldc 54
    //   290: ldc 129
    //   292: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: ldc 32
    //   297: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: return
    //   301: astore_1
    //   302: ldc 54
    //   304: ldc 129
    //   306: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: ldc 32
    //   311: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	a
    //   0	315	1	parama	a
    //   0	315	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   66	75	191	java/lang/Exception
    //   75	94	210	org/json/JSONException
    //   94	113	221	org/json/JSONException
    //   113	139	232	org/json/JSONException
    //   113	139	243	java/lang/NumberFormatException
    //   113	139	254	java/lang/Exception
    //   139	162	265	org/json/JSONException
    //   139	162	276	java/lang/Exception
    //   162	185	287	org/json/JSONException
    //   162	185	301	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.k.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */