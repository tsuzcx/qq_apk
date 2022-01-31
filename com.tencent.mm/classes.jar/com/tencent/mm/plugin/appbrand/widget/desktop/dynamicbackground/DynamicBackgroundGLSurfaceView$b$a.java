package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer$Companion;", "", "()V", "ALPHA_ANIMATION_DURATION", "", "checkBlackScreen", "", "buf", "Ljava/nio/ByteBuffer;", "width", "", "height", "getAlphaAnimation", "loadShader", "type", "shaderCode", "", "saveRgb2Bitmap", "Landroid/graphics/Bitmap;", "Ljava/nio/Buffer;", "filename", "updateAlphaAnimation", "", "duration", "plugin-appbrand-integration_release"})
public final class DynamicBackgroundGLSurfaceView$b$a
{
  /* Error */
  public static android.graphics.Bitmap a(java.nio.Buffer paramBuffer, java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 51
    //   8: invokestatic 57	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 58
    //   14: invokestatic 57	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: ldc 60
    //   19: ldc 62
    //   21: aload_1
    //   22: invokestatic 68	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   25: invokevirtual 72	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   28: invokestatic 78	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: new 80	java/io/BufferedOutputStream
    //   34: dup
    //   35: new 82	java/io/FileOutputStream
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   43: checkcast 87	java/io/OutputStream
    //   46: invokespecial 90	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: astore_1
    //   50: sipush 1024
    //   53: sipush 2000
    //   56: getstatic 96	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   59: invokestatic 102	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   62: astore_2
    //   63: aload_2
    //   64: aload_0
    //   65: invokevirtual 106	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   68: aload_2
    //   69: getstatic 112	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   72: bipush 90
    //   74: aload_1
    //   75: checkcast 87	java/io/OutputStream
    //   78: invokevirtual 116	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   81: pop
    //   82: aload_1
    //   83: invokevirtual 119	java/io/BufferedOutputStream:close	()V
    //   86: ldc 44
    //   88: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_2
    //   92: areturn
    //   93: astore_0
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 119	java/io/BufferedOutputStream:close	()V
    //   104: ldc 44
    //   106: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 119	java/io/BufferedOutputStream:close	()V
    //   122: ldc 44
    //   124: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_0
    //   128: athrow
    //   129: astore_0
    //   130: goto -44 -> 86
    //   133: astore_0
    //   134: goto -30 -> 104
    //   137: astore_1
    //   138: goto -16 -> 122
    //   141: astore_0
    //   142: goto -28 -> 114
    //   145: astore_0
    //   146: goto -50 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramBuffer	java.nio.Buffer
    //   0	149	1	paramString	java.lang.String
    //   62	30	2	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   31	50	93	java/io/IOException
    //   31	50	111	finally
    //   82	86	129	java/io/IOException
    //   100	104	133	java/io/IOException
    //   118	122	137	java/io/IOException
    //   50	82	141	finally
    //   50	82	145	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.b.a
 * JD-Core Version:    0.7.0.1
 */