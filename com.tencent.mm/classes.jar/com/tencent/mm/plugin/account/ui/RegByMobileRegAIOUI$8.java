package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al.a;

final class RegByMobileRegAIOUI$8
  implements al.a
{
  RegByMobileRegAIOUI$8(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  /* Error */
  public final boolean acS()
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 33	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$8:gIh	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
    //   13: invokestatic 37	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:u	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Ljava/lang/String;
    //   16: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: checkcast 46	java/net/HttpURLConnection
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 50	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$8:gIh	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
    //   36: aload 4
    //   38: invokestatic 56	com/tencent/mm/sdk/platformtools/d:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   41: invokestatic 60	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:a	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   44: pop
    //   45: aload_0
    //   46: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$8:gIh	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
    //   49: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
    //   52: ifnull +53 -> 105
    //   55: aload_0
    //   56: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$8:gIh	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
    //   59: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
    //   62: invokevirtual 69	android/graphics/Bitmap:isRecycled	()Z
    //   65: ifne +40 -> 105
    //   68: aload_0
    //   69: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$8:gIh	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
    //   72: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
    //   75: bipush 100
    //   77: getstatic 75	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   80: new 77	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   87: getstatic 84	com/tencent/mm/compatible/util/e:esy	Ljava/lang/String;
    //   90: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 90
    //   95: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: iconst_0
    //   102: invokestatic 97	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   105: aload 4
    //   107: ifnull +8 -> 115
    //   110: aload 4
    //   112: invokevirtual 102	java/io/InputStream:close	()V
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
    //   123: ldc 25
    //   125: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iconst_1
    //   129: ireturn
    //   130: astore_3
    //   131: aconst_null
    //   132: astore 4
    //   134: aconst_null
    //   135: astore_1
    //   136: aload 4
    //   138: ifnull +10 -> 148
    //   141: aload_1
    //   142: astore_2
    //   143: aload 4
    //   145: invokevirtual 102	java/io/InputStream:close	()V
    //   148: aload_1
    //   149: astore_2
    //   150: ldc 25
    //   152: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload_1
    //   156: astore_2
    //   157: aload_3
    //   158: athrow
    //   159: astore_3
    //   160: aload_1
    //   161: astore_2
    //   162: ldc 110
    //   164: aload_3
    //   165: ldc 112
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 118	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload_1
    //   175: ifnull -52 -> 123
    //   178: aload_1
    //   179: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
    //   182: goto -59 -> 123
    //   185: astore_3
    //   186: aload_1
    //   187: astore_2
    //   188: aload_3
    //   189: astore_1
    //   190: aload_2
    //   191: ifnull +7 -> 198
    //   194: aload_2
    //   195: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
    //   198: ldc 25
    //   200: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: goto -16 -> 190
    //   209: astore_3
    //   210: goto -50 -> 160
    //   213: astore_3
    //   214: aconst_null
    //   215: astore 4
    //   217: goto -81 -> 136
    //   220: astore_3
    //   221: goto -85 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	8
    //   25	179	1	localObject1	Object
    //   205	1	1	localObject2	Object
    //   142	53	2	localObject3	Object
    //   130	28	3	localObject4	Object
    //   159	6	3	localException1	java.lang.Exception
    //   185	4	3	localObject5	Object
    //   209	1	3	localException2	java.lang.Exception
    //   213	1	3	localObject6	Object
    //   220	1	3	localObject7	Object
    //   30	186	4	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   5	26	130	finally
    //   143	148	159	java/lang/Exception
    //   150	155	159	java/lang/Exception
    //   157	159	159	java/lang/Exception
    //   110	115	185	finally
    //   143	148	205	finally
    //   150	155	205	finally
    //   157	159	205	finally
    //   162	174	205	finally
    //   110	115	209	java/lang/Exception
    //   26	32	213	finally
    //   32	105	220	finally
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(152592);
    if ((!RegByMobileRegAIOUI.q(this.gIh)) && (RegByMobileRegAIOUI.p(this.gIh) != null) && (!RegByMobileRegAIOUI.p(this.gIh).isRecycled()))
    {
      RegByMobileRegAIOUI.r(this.gIh).setImageBitmap(RegByMobileRegAIOUI.p(this.gIh));
      RegByMobileRegAIOUI.s(this.gIh).setVisibility(8);
      RegByMobileRegAIOUI.t(this.gIh);
    }
    AppMethodBeat.o(152592);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.8
 * JD-Core Version:    0.7.0.1
 */