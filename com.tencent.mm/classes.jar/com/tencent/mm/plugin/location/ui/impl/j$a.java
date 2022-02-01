package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.lang.ref.WeakReference;

final class j$a
  extends AsyncTask<String, Integer, String>
{
  private static final String KkF;
  private final WeakReference<Context> KkD;
  private final WeakReference<View> KkE;
  
  static
  {
    AppMethodBeat.i(264985);
    KkF = "https://" + WeChatHosts.domainString(a.i.host_3gimg_qq_com) + "/tencentMapTouch/app/download/wx_android_download_ico.png";
    AppMethodBeat.o(264985);
  }
  
  j$a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(56163);
    this.KkD = new WeakReference(paramContext);
    this.KkE = new WeakReference(paramView);
    AppMethodBeat.o(56163);
  }
  
  /* Error */
  private static String aKq(String paramString)
  {
    // Byte code:
    //   0: ldc 82
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_3
    //   9: new 84	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 85	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 89	java/net/URL:openStream	()Ljava/io/InputStream;
    //   20: astore_0
    //   21: aload_0
    //   22: astore_3
    //   23: aload_0
    //   24: astore_2
    //   25: sipush 1024
    //   28: newarray byte
    //   30: astore 4
    //   32: aload_0
    //   33: astore_3
    //   34: aload_0
    //   35: astore_2
    //   36: aload_0
    //   37: aload 4
    //   39: invokevirtual 95	java/io/InputStream:read	([B)I
    //   42: istore_1
    //   43: aload_0
    //   44: astore_3
    //   45: aload_0
    //   46: astore_2
    //   47: new 97	java/lang/String
    //   50: dup
    //   51: aload 4
    //   53: invokespecial 100	java/lang/String:<init>	([B)V
    //   56: astore 4
    //   58: aload_0
    //   59: astore_2
    //   60: ldc 102
    //   62: ldc 104
    //   64: iload_1
    //   65: invokestatic 107	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   68: invokevirtual 110	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 4
    //   76: astore_2
    //   77: aload_0
    //   78: ifnull +10 -> 88
    //   81: aload_0
    //   82: invokevirtual 119	java/io/InputStream:close	()V
    //   85: aload 4
    //   87: astore_2
    //   88: ldc 82
    //   90: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_2
    //   94: areturn
    //   95: astore_0
    //   96: ldc 102
    //   98: ldc 121
    //   100: iconst_1
    //   101: anewarray 123	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   110: aastore
    //   111: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload 4
    //   116: astore_2
    //   117: goto -29 -> 88
    //   120: astore 4
    //   122: ldc 132
    //   124: astore_2
    //   125: aload_3
    //   126: astore_0
    //   127: aload_2
    //   128: astore_3
    //   129: aload_0
    //   130: astore_2
    //   131: ldc 102
    //   133: ldc 134
    //   135: iconst_1
    //   136: anewarray 123	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload 4
    //   143: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   146: aastore
    //   147: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload_3
    //   151: astore_2
    //   152: aload_0
    //   153: ifnull -65 -> 88
    //   156: aload_0
    //   157: invokevirtual 119	java/io/InputStream:close	()V
    //   160: aload_3
    //   161: astore_2
    //   162: goto -74 -> 88
    //   165: astore_0
    //   166: ldc 102
    //   168: ldc 121
    //   170: iconst_1
    //   171: anewarray 123	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload_0
    //   177: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   180: aastore
    //   181: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_3
    //   185: astore_2
    //   186: goto -98 -> 88
    //   189: astore_0
    //   190: aload_2
    //   191: ifnull +7 -> 198
    //   194: aload_2
    //   195: invokevirtual 119	java/io/InputStream:close	()V
    //   198: ldc 82
    //   200: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_0
    //   204: athrow
    //   205: astore_2
    //   206: ldc 102
    //   208: ldc 121
    //   210: iconst_1
    //   211: anewarray 123	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: aload_2
    //   217: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   220: aastore
    //   221: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: goto -26 -> 198
    //   227: astore_2
    //   228: aload 4
    //   230: astore_3
    //   231: aload_2
    //   232: astore 4
    //   234: goto -105 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramString	String
    //   42	23	1	i	int
    //   6	189	2	localObject1	Object
    //   205	12	2	localException1	java.lang.Exception
    //   227	5	2	localException2	java.lang.Exception
    //   8	223	3	localObject2	Object
    //   30	85	4	localObject3	Object
    //   120	109	4	localException3	java.lang.Exception
    //   232	1	4	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   81	85	95	java/lang/Exception
    //   9	21	120	java/lang/Exception
    //   25	32	120	java/lang/Exception
    //   36	43	120	java/lang/Exception
    //   47	58	120	java/lang/Exception
    //   156	160	165	java/lang/Exception
    //   9	21	189	finally
    //   25	32	189	finally
    //   36	43	189	finally
    //   47	58	189	finally
    //   60	74	189	finally
    //   131	150	189	finally
    //   194	198	205	java/lang/Exception
    //   60	74	227	java/lang/Exception
  }
  
  protected final void onPreExecute()
  {
    AppMethodBeat.i(56164);
    View localView = (View)this.KkE.get();
    if (localView != null) {
      localView.setVisibility(0);
    }
    AppMethodBeat.o(56164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.a
 * JD-Core Version:    0.7.0.1
 */