package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  implements b<ae>
{
  boolean lTK = false;
  
  /* Error */
  static boolean eb(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 31
    //   4: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 43	com/tencent/mm/compatible/util/e:abf	()Z
    //   10: ifne +17 -> 27
    //   13: ldc 45
    //   15: ldc 47
    //   17: invokestatic 53	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: ldc 31
    //   22: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_0
    //   26: ireturn
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 5
    //   33: aload 6
    //   35: astore 4
    //   37: new 58	com/tencent/mm/vfs/e
    //   40: dup
    //   41: new 60	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   48: invokestatic 67	com/tencent/mm/loader/j/b:arU	()Ljava/lang/String;
    //   51: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 73
    //   56: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 79	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   65: astore 7
    //   67: aload 6
    //   69: astore 4
    //   71: aload 7
    //   73: invokevirtual 82	com/tencent/mm/vfs/e:exists	()Z
    //   76: ifne +13 -> 89
    //   79: aload 6
    //   81: astore 4
    //   83: aload 7
    //   85: invokevirtual 85	com/tencent/mm/vfs/e:mkdirs	()Z
    //   88: pop
    //   89: aload 6
    //   91: astore 4
    //   93: new 87	com/tencent/mm/vfs/l
    //   96: dup
    //   97: new 58	com/tencent/mm/vfs/e
    //   100: dup
    //   101: aload 7
    //   103: aload_0
    //   104: invokespecial 90	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   107: iconst_0
    //   108: invokespecial 93	com/tencent/mm/vfs/l:<init>	(Lcom/tencent/mm/vfs/e;Z)V
    //   111: astore_0
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 96	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   117: iconst_1
    //   118: istore_2
    //   119: aload_0
    //   120: invokevirtual 99	com/tencent/mm/vfs/l:close	()V
    //   123: ldc 31
    //   125: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iload_2
    //   129: ireturn
    //   130: astore_0
    //   131: ldc 45
    //   133: ldc 101
    //   135: aload_0
    //   136: invokestatic 107	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   139: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   142: invokestatic 53	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: goto -22 -> 123
    //   148: astore_1
    //   149: aload 5
    //   151: astore_0
    //   152: aload_0
    //   153: astore 4
    //   155: ldc 45
    //   157: ldc 113
    //   159: aload_1
    //   160: invokestatic 107	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokestatic 53	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: iload_3
    //   170: istore_2
    //   171: aload_0
    //   172: ifnull -49 -> 123
    //   175: aload_0
    //   176: invokevirtual 99	com/tencent/mm/vfs/l:close	()V
    //   179: iload_3
    //   180: istore_2
    //   181: goto -58 -> 123
    //   184: astore_0
    //   185: ldc 45
    //   187: ldc 101
    //   189: aload_0
    //   190: invokestatic 107	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   193: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   196: invokestatic 53	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: iload_3
    //   200: istore_2
    //   201: goto -78 -> 123
    //   204: astore_0
    //   205: aload 4
    //   207: ifnull +8 -> 215
    //   210: aload 4
    //   212: invokevirtual 99	com/tencent/mm/vfs/l:close	()V
    //   215: ldc 31
    //   217: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload_0
    //   221: athrow
    //   222: astore_1
    //   223: ldc 45
    //   225: ldc 101
    //   227: aload_1
    //   228: invokestatic 107	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   234: invokestatic 53	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: goto -22 -> 215
    //   240: astore_1
    //   241: aload_0
    //   242: astore 4
    //   244: aload_1
    //   245: astore_0
    //   246: goto -41 -> 205
    //   249: astore_1
    //   250: goto -98 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramString1	String
    //   0	253	1	paramString2	String
    //   118	83	2	bool1	boolean
    //   1	199	3	bool2	boolean
    //   35	208	4	localObject1	Object
    //   31	119	5	localObject2	Object
    //   28	62	6	localObject3	Object
    //   65	37	7	locale	com.tencent.mm.vfs.e
    // Exception table:
    //   from	to	target	type
    //   119	123	130	java/lang/Exception
    //   37	67	148	java/lang/Exception
    //   71	79	148	java/lang/Exception
    //   83	89	148	java/lang/Exception
    //   93	112	148	java/lang/Exception
    //   175	179	184	java/lang/Exception
    //   37	67	204	finally
    //   71	79	204	finally
    //   83	89	204	finally
    //   93	112	204	finally
    //   155	169	204	finally
    //   210	215	222	java/lang/Exception
    //   112	117	240	finally
    //   112	117	249	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.g
 * JD-Core Version:    0.7.0.1
 */