package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;

final class RegByMobileRegAIOUI$7
  implements MMHandlerThread.IWaitWorkThread
{
  RegByMobileRegAIOUI$7(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  /* Error */
  public final boolean doInBackground()
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 33	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:nic	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
    //   13: invokestatic 37	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:v	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Ljava/lang/String;
    //   16: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: checkcast 46	java/net/HttpURLConnection
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 50	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:nic	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
    //   36: aload 4
    //   38: invokestatic 56	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   41: invokestatic 60	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:a	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   44: pop
    //   45: aload_0
    //   46: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:nic	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
    //   49: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:q	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
    //   52: ifnull +54 -> 106
    //   55: aload_0
    //   56: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:nic	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
    //   59: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:q	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
    //   62: invokevirtual 69	android/graphics/Bitmap:isRecycled	()Z
    //   65: ifne +41 -> 106
    //   68: aload_0
    //   69: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:nic	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
    //   72: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:q	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
    //   75: bipush 100
    //   77: getstatic 75	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   80: new 77	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   87: invokestatic 84	com/tencent/mm/loader/j/b:aST	()Ljava/lang/String;
    //   90: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 90
    //   95: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: iconst_0
    //   102: invokestatic 97	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   105: pop
    //   106: aload 4
    //   108: ifnull +8 -> 116
    //   111: aload 4
    //   113: invokevirtual 102	java/io/InputStream:close	()V
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
    //   124: ldc 25
    //   126: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_3
    //   132: aconst_null
    //   133: astore 4
    //   135: aconst_null
    //   136: astore_1
    //   137: aload 4
    //   139: ifnull +10 -> 149
    //   142: aload_1
    //   143: astore_2
    //   144: aload 4
    //   146: invokevirtual 102	java/io/InputStream:close	()V
    //   149: aload_1
    //   150: astore_2
    //   151: ldc 25
    //   153: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: astore_2
    //   158: aload_3
    //   159: athrow
    //   160: astore_3
    //   161: aload_1
    //   162: astore_2
    //   163: ldc 110
    //   165: aload_3
    //   166: ldc 112
    //   168: iconst_0
    //   169: anewarray 4	java/lang/Object
    //   172: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: aload_1
    //   176: ifnull -52 -> 124
    //   179: aload_1
    //   180: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
    //   183: goto -59 -> 124
    //   186: astore_3
    //   187: aload_1
    //   188: astore_2
    //   189: aload_3
    //   190: astore_1
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
    //   199: ldc 25
    //   201: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_1
    //   205: athrow
    //   206: astore_1
    //   207: goto -16 -> 191
    //   210: astore_3
    //   211: goto -50 -> 161
    //   214: astore_3
    //   215: aconst_null
    //   216: astore 4
    //   218: goto -81 -> 137
    //   221: astore_3
    //   222: goto -85 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	7
    //   25	180	1	localObject1	Object
    //   206	1	1	localObject2	Object
    //   143	53	2	localObject3	Object
    //   131	28	3	localObject4	Object
    //   160	6	3	localException1	java.lang.Exception
    //   186	4	3	localObject5	Object
    //   210	1	3	localException2	java.lang.Exception
    //   214	1	3	localObject6	Object
    //   221	1	3	localObject7	Object
    //   30	187	4	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   5	26	131	finally
    //   144	149	160	java/lang/Exception
    //   151	156	160	java/lang/Exception
    //   158	160	160	java/lang/Exception
    //   111	116	186	finally
    //   144	149	206	finally
    //   151	156	206	finally
    //   158	160	206	finally
    //   163	175	206	finally
    //   111	116	210	java/lang/Exception
    //   26	32	214	finally
    //   32	106	221	finally
  }
  
  public final boolean onPostExecute()
  {
    AppMethodBeat.i(128517);
    if ((!RegByMobileRegAIOUI.r(this.nic)) && (RegByMobileRegAIOUI.q(this.nic) != null) && (!RegByMobileRegAIOUI.q(this.nic).isRecycled()))
    {
      RegByMobileRegAIOUI.s(this.nic).setImageBitmap(RegByMobileRegAIOUI.q(this.nic));
      RegByMobileRegAIOUI.t(this.nic).setVisibility(8);
      RegByMobileRegAIOUI.u(this.nic);
    }
    AppMethodBeat.o(128517);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.7
 * JD-Core Version:    0.7.0.1
 */