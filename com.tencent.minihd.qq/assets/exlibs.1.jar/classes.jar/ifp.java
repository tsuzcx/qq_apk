import android.graphics.Bitmap;
import com.tencent.mobileqq.emoticonview.ClassicEmoticonPanelView;

public class ifp
  implements Runnable
{
  public ifp(ClassicEmoticonPanelView paramClassicEmoticonPanelView, Bitmap paramBitmap, int paramInt1, int paramInt2, StringBuilder paramStringBuilder) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	ifp:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   4: ifnull +391 -> 395
    //   7: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   10: lstore_1
    //   11: new 39	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_0
    //   21: getfield 16	ifp:jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView	Lcom/tencent/mobileqq/emoticonview/ClassicEmoticonPanelView;
    //   24: getfield 46	com/tencent/mobileqq/emoticonview/ClassicEmoticonPanelView:c	Ljava/lang/String;
    //   27: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 52
    //   32: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 54
    //   37: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 20	ifp:jdField_a_of_type_Int	I
    //   44: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 59
    //   49: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: new 61	java/io/File
    //   56: dup
    //   57: aload_3
    //   58: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore_3
    //   65: aload_3
    //   66: ifnull +15 -> 81
    //   69: aload_3
    //   70: invokevirtual 72	java/io/File:exists	()Z
    //   73: ifeq +8 -> 81
    //   76: aload_3
    //   77: invokevirtual 75	java/io/File:delete	()Z
    //   80: pop
    //   81: new 39	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   88: astore_3
    //   89: aload_3
    //   90: aload_0
    //   91: getfield 16	ifp:jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView	Lcom/tencent/mobileqq/emoticonview/ClassicEmoticonPanelView;
    //   94: getfield 46	com/tencent/mobileqq/emoticonview/ClassicEmoticonPanelView:c	Ljava/lang/String;
    //   97: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 52
    //   102: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 54
    //   107: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: getfield 20	ifp:jdField_a_of_type_Int	I
    //   114: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc 77
    //   119: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_0
    //   123: getfield 22	ifp:b	I
    //   126: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc 59
    //   131: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: new 61	java/io/File
    //   138: dup
    //   139: aload_3
    //   140: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: astore_3
    //   147: aload_3
    //   148: ifnull +15 -> 163
    //   151: aload_3
    //   152: invokevirtual 72	java/io/File:exists	()Z
    //   155: ifeq +8 -> 163
    //   158: aload_3
    //   159: invokevirtual 75	java/io/File:delete	()Z
    //   162: pop
    //   163: new 61	java/io/File
    //   166: dup
    //   167: aload_0
    //   168: getfield 24	ifp:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   171: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   177: astore 6
    //   179: new 61	java/io/File
    //   182: dup
    //   183: new 39	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   190: aload 6
    //   192: invokevirtual 80	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   195: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 82
    //   200: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: astore 7
    //   211: aconst_null
    //   212: astore 4
    //   214: aconst_null
    //   215: astore 5
    //   217: aload 4
    //   219: astore_3
    //   220: new 61	java/io/File
    //   223: dup
    //   224: aload 7
    //   226: invokevirtual 85	java/io/File:getParent	()Ljava/lang/String;
    //   229: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   232: astore 8
    //   234: aload 4
    //   236: astore_3
    //   237: aload 8
    //   239: invokevirtual 72	java/io/File:exists	()Z
    //   242: ifeq +14 -> 256
    //   245: aload 4
    //   247: astore_3
    //   248: aload 8
    //   250: invokevirtual 88	java/io/File:isDirectory	()Z
    //   253: ifne +12 -> 265
    //   256: aload 4
    //   258: astore_3
    //   259: aload 8
    //   261: invokevirtual 91	java/io/File:mkdirs	()Z
    //   264: pop
    //   265: aload 4
    //   267: astore_3
    //   268: aload 7
    //   270: invokevirtual 72	java/io/File:exists	()Z
    //   273: ifeq +14 -> 287
    //   276: aload 4
    //   278: astore_3
    //   279: aload 7
    //   281: invokevirtual 94	java/io/File:isFile	()Z
    //   284: ifne +12 -> 296
    //   287: aload 4
    //   289: astore_3
    //   290: aload 7
    //   292: invokevirtual 97	java/io/File:createNewFile	()Z
    //   295: pop
    //   296: aload 4
    //   298: astore_3
    //   299: new 99	java/io/FileOutputStream
    //   302: dup
    //   303: aload 7
    //   305: invokespecial 102	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   308: astore 4
    //   310: aload_0
    //   311: getfield 18	ifp:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   314: getstatic 108	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   317: bipush 100
    //   319: aload 4
    //   321: invokevirtual 114	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   324: pop
    //   325: aload 4
    //   327: invokevirtual 117	java/io/FileOutputStream:flush	()V
    //   330: aload 7
    //   332: aload 6
    //   334: invokevirtual 121	java/io/File:renameTo	(Ljava/io/File;)Z
    //   337: pop
    //   338: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +44 -> 385
    //   344: ldc 128
    //   346: iconst_2
    //   347: new 39	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   354: ldc 130
    //   356: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   362: lload_1
    //   363: lsub
    //   364: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   367: ldc 135
    //   369: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: getfield 20	ifp:jdField_a_of_type_Int	I
    //   376: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aload 4
    //   387: ifnull +8 -> 395
    //   390: aload 4
    //   392: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   395: return
    //   396: astore_3
    //   397: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +28 -> 428
    //   403: ldc 128
    //   405: iconst_2
    //   406: new 39	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   413: ldc 144
    //   415: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload_3
    //   419: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload 6
    //   430: ifnull +17 -> 447
    //   433: aload 6
    //   435: invokevirtual 72	java/io/File:exists	()Z
    //   438: ifeq +9 -> 447
    //   441: aload 6
    //   443: invokevirtual 75	java/io/File:delete	()Z
    //   446: pop
    //   447: aload 7
    //   449: ifnull -54 -> 395
    //   452: aload 7
    //   454: invokevirtual 72	java/io/File:exists	()Z
    //   457: ifeq -62 -> 395
    //   460: aload 7
    //   462: invokevirtual 75	java/io/File:delete	()Z
    //   465: pop
    //   466: return
    //   467: astore_3
    //   468: aload 5
    //   470: astore 4
    //   472: aload_3
    //   473: astore 5
    //   475: aload 4
    //   477: astore_3
    //   478: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq +32 -> 513
    //   484: aload 4
    //   486: astore_3
    //   487: ldc 128
    //   489: iconst_2
    //   490: new 39	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   497: ldc 152
    //   499: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 5
    //   504: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   507: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   513: aload 6
    //   515: ifnull +23 -> 538
    //   518: aload 4
    //   520: astore_3
    //   521: aload 6
    //   523: invokevirtual 72	java/io/File:exists	()Z
    //   526: ifeq +12 -> 538
    //   529: aload 4
    //   531: astore_3
    //   532: aload 6
    //   534: invokevirtual 75	java/io/File:delete	()Z
    //   537: pop
    //   538: aload 7
    //   540: ifnull +23 -> 563
    //   543: aload 4
    //   545: astore_3
    //   546: aload 7
    //   548: invokevirtual 72	java/io/File:exists	()Z
    //   551: ifeq +12 -> 563
    //   554: aload 4
    //   556: astore_3
    //   557: aload 7
    //   559: invokevirtual 75	java/io/File:delete	()Z
    //   562: pop
    //   563: aload 4
    //   565: ifnull -170 -> 395
    //   568: aload 4
    //   570: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   573: return
    //   574: astore_3
    //   575: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   578: ifeq +28 -> 606
    //   581: ldc 128
    //   583: iconst_2
    //   584: new 39	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   591: ldc 144
    //   593: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_3
    //   597: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: aload 6
    //   608: ifnull +17 -> 625
    //   611: aload 6
    //   613: invokevirtual 72	java/io/File:exists	()Z
    //   616: ifeq +9 -> 625
    //   619: aload 6
    //   621: invokevirtual 75	java/io/File:delete	()Z
    //   624: pop
    //   625: aload 7
    //   627: ifnull -232 -> 395
    //   630: aload 7
    //   632: invokevirtual 72	java/io/File:exists	()Z
    //   635: ifeq -240 -> 395
    //   638: aload 7
    //   640: invokevirtual 75	java/io/File:delete	()Z
    //   643: pop
    //   644: return
    //   645: astore 5
    //   647: aload_3
    //   648: astore 4
    //   650: aload 5
    //   652: astore_3
    //   653: aload 4
    //   655: ifnull +8 -> 663
    //   658: aload 4
    //   660: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   663: aload_3
    //   664: athrow
    //   665: astore 4
    //   667: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   670: ifeq +29 -> 699
    //   673: ldc 128
    //   675: iconst_2
    //   676: new 39	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   683: ldc 144
    //   685: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: aload 4
    //   690: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   693: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   699: aload 6
    //   701: ifnull +17 -> 718
    //   704: aload 6
    //   706: invokevirtual 72	java/io/File:exists	()Z
    //   709: ifeq +9 -> 718
    //   712: aload 6
    //   714: invokevirtual 75	java/io/File:delete	()Z
    //   717: pop
    //   718: aload 7
    //   720: ifnull -57 -> 663
    //   723: aload 7
    //   725: invokevirtual 72	java/io/File:exists	()Z
    //   728: ifeq -65 -> 663
    //   731: aload 7
    //   733: invokevirtual 75	java/io/File:delete	()Z
    //   736: pop
    //   737: goto -74 -> 663
    //   740: astore_3
    //   741: goto -88 -> 653
    //   744: astore 5
    //   746: goto -271 -> 475
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	749	0	this	ifp
    //   10	353	1	l	long
    //   18	281	3	localObject1	Object
    //   396	23	3	localIOException1	java.io.IOException
    //   467	6	3	localIOException2	java.io.IOException
    //   477	80	3	localObject2	Object
    //   574	74	3	localIOException3	java.io.IOException
    //   652	12	3	localObject3	Object
    //   740	1	3	localObject4	Object
    //   212	447	4	localObject5	Object
    //   665	24	4	localIOException4	java.io.IOException
    //   215	288	5	localIOException5	java.io.IOException
    //   645	6	5	localObject6	Object
    //   744	1	5	localIOException6	java.io.IOException
    //   177	536	6	localFile1	java.io.File
    //   209	523	7	localFile2	java.io.File
    //   232	28	8	localFile3	java.io.File
    // Exception table:
    //   from	to	target	type
    //   390	395	396	java/io/IOException
    //   220	234	467	java/io/IOException
    //   237	245	467	java/io/IOException
    //   248	256	467	java/io/IOException
    //   259	265	467	java/io/IOException
    //   268	276	467	java/io/IOException
    //   279	287	467	java/io/IOException
    //   290	296	467	java/io/IOException
    //   299	310	467	java/io/IOException
    //   568	573	574	java/io/IOException
    //   220	234	645	finally
    //   237	245	645	finally
    //   248	256	645	finally
    //   259	265	645	finally
    //   268	276	645	finally
    //   279	287	645	finally
    //   290	296	645	finally
    //   299	310	645	finally
    //   478	484	645	finally
    //   487	513	645	finally
    //   521	529	645	finally
    //   532	538	645	finally
    //   546	554	645	finally
    //   557	563	645	finally
    //   658	663	665	java/io/IOException
    //   310	385	740	finally
    //   310	385	744	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ifp
 * JD-Core Version:    0.7.0.1
 */