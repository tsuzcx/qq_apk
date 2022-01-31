package com.tencent.mm.emoji.a;

import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/model/BaseXmlContent$Companion;", "", "()V", "TAG", "", "safeParse", "", "filePath", "xmlContent", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "plugin-emojisdk_release"})
public final class a$a
{
  /* Error */
  public static void a(java.lang.String paramString, a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: ldc 33
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 40
    //   12: invokestatic 46	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: ldc 47
    //   18: invokestatic 46	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: new 49	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   29: checkcast 54	java/io/InputStream
    //   32: astore_0
    //   33: invokestatic 60	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   36: astore_2
    //   37: aload_2
    //   38: ldc 62
    //   40: invokestatic 65	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   43: aload_2
    //   44: ldc 67
    //   46: iconst_0
    //   47: invokeinterface 73 3 0
    //   52: aload_2
    //   53: aload_0
    //   54: aconst_null
    //   55: invokeinterface 77 3 0
    //   60: aload_2
    //   61: invokeinterface 81 1 0
    //   66: pop
    //   67: aload_1
    //   68: aload_2
    //   69: invokevirtual 85	com/tencent/mm/emoji/a/a:f	(Lorg/xmlpull/v1/XmlPullParser;)V
    //   72: aload_0
    //   73: invokevirtual 88	java/io/InputStream:close	()V
    //   76: ldc 33
    //   78: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: return
    //   82: astore_1
    //   83: aload_3
    //   84: astore_0
    //   85: aload_0
    //   86: astore_2
    //   87: invokestatic 95	com/tencent/mm/emoji/a/a:access$getTAG$cp	()Ljava/lang/String;
    //   90: aload_1
    //   91: checkcast 97	java/lang/Throwable
    //   94: ldc 99
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: ifnull +13 -> 117
    //   107: aload_0
    //   108: invokevirtual 88	java/io/InputStream:close	()V
    //   111: ldc 33
    //   113: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: ldc 33
    //   119: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: astore_0
    //   124: aload_2
    //   125: ifnull +7 -> 132
    //   128: aload_2
    //   129: invokevirtual 88	java/io/InputStream:close	()V
    //   132: ldc 33
    //   134: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_0
    //   138: athrow
    //   139: astore_1
    //   140: aload_0
    //   141: astore_2
    //   142: aload_1
    //   143: astore_0
    //   144: goto -20 -> 124
    //   147: astore_1
    //   148: goto -63 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramString	java.lang.String
    //   0	151	1	parama	a
    //   1	141	2	localObject1	Object
    //   3	81	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	33	82	java/lang/Exception
    //   21	33	123	finally
    //   87	103	123	finally
    //   33	72	139	finally
    //   33	72	147	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */