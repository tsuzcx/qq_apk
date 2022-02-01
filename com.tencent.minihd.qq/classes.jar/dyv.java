import android.net.Uri;
import com.tencent.mobileqq.activity.ForwardOperations;
import java.io.InputStream;

public class dyv
  implements Runnable
{
  public dyv(ForwardOperations paramForwardOperations, String paramString, InputStream paramInputStream, long paramLong, Uri paramUri) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 35	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: getfield 18	dyv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 10
    //   16: aload 10
    //   18: invokevirtual 42	java/io/File:exists	()Z
    //   21: ifne +59 -> 80
    //   24: aload 10
    //   26: invokevirtual 45	java/io/File:createNewFile	()Z
    //   29: ifne +51 -> 80
    //   32: aload_0
    //   33: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   36: getfield 50	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   39: iconst_1
    //   40: invokevirtual 56	android/os/Handler:sendEmptyMessage	(I)Z
    //   43: pop
    //   44: aload_0
    //   45: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   48: iconst_0
    //   49: invokestatic 59	com/tencent/mobileqq/activity/ForwardOperations:a	(Lcom/tencent/mobileqq/activity/ForwardOperations;Z)Z
    //   52: pop
    //   53: aload_0
    //   54: getfield 20	dyv:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   57: ifnull +10 -> 67
    //   60: aload_0
    //   61: getfield 20	dyv:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   64: invokevirtual 64	java/io/InputStream:close	()V
    //   67: iconst_0
    //   68: ifeq +11 -> 79
    //   71: new 66	java/lang/NullPointerException
    //   74: dup
    //   75: invokespecial 67	java/lang/NullPointerException:<init>	()V
    //   78: athrow
    //   79: return
    //   80: new 69	java/io/FileOutputStream
    //   83: dup
    //   84: aload_0
    //   85: getfield 18	dyv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   88: invokespecial 70	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   91: astore 9
    //   93: sipush 8192
    //   96: newarray byte
    //   98: astore 8
    //   100: lconst_0
    //   101: lstore 6
    //   103: lconst_0
    //   104: lstore 4
    //   106: aload_0
    //   107: getfield 20	dyv:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   110: aload 8
    //   112: invokevirtual 74	java/io/InputStream:read	([B)I
    //   115: istore_1
    //   116: iload_1
    //   117: iconst_m1
    //   118: if_icmpeq +94 -> 212
    //   121: aload_0
    //   122: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   125: invokestatic 77	com/tencent/mobileqq/activity/ForwardOperations:a	(Lcom/tencent/mobileqq/activity/ForwardOperations;)Z
    //   128: ifeq +84 -> 212
    //   131: lload 4
    //   133: iload_1
    //   134: i2l
    //   135: ladd
    //   136: lstore_2
    //   137: aload 9
    //   139: aload 8
    //   141: iconst_0
    //   142: iload_1
    //   143: invokevirtual 81	java/io/FileOutputStream:write	([BII)V
    //   146: lload_2
    //   147: lstore 4
    //   149: lload_2
    //   150: lload 6
    //   152: lsub
    //   153: l2d
    //   154: aload_0
    //   155: getfield 22	dyv:jdField_a_of_type_Long	J
    //   158: l2d
    //   159: ddiv
    //   160: ldc2_w 82
    //   163: dcmpl
    //   164: ifle -58 -> 106
    //   167: aload_0
    //   168: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   171: getfield 50	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   174: aload_0
    //   175: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   178: getfield 50	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   181: iconst_3
    //   182: lload_2
    //   183: l2d
    //   184: aload_0
    //   185: getfield 22	dyv:jdField_a_of_type_Long	J
    //   188: l2d
    //   189: ddiv
    //   190: ldc2_w 84
    //   193: dmul
    //   194: d2i
    //   195: iconst_0
    //   196: invokevirtual 89	android/os/Handler:obtainMessage	(III)Landroid/os/Message;
    //   199: invokevirtual 93	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   202: pop
    //   203: lload_2
    //   204: lstore 6
    //   206: lload_2
    //   207: lstore 4
    //   209: goto -103 -> 106
    //   212: lload 4
    //   214: lconst_0
    //   215: lcmp
    //   216: ifne +45 -> 261
    //   219: aload_0
    //   220: getfield 24	dyv:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   223: invokevirtual 99	android/net/Uri:toString	()Ljava/lang/String;
    //   226: ldc 101
    //   228: invokevirtual 107	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   231: ifeq +117 -> 348
    //   234: aload_0
    //   235: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   238: getfield 110	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   241: ldc 111
    //   243: invokevirtual 117	android/app/Activity:getString	(I)Ljava/lang/String;
    //   246: putstatic 120	com/tencent/mobileqq/activity/ForwardOperations:M	Ljava/lang/String;
    //   249: aload_0
    //   250: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   253: getfield 50	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   256: iconst_1
    //   257: invokevirtual 56	android/os/Handler:sendEmptyMessage	(I)Z
    //   260: pop
    //   261: aload_0
    //   262: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   265: invokestatic 77	com/tencent/mobileqq/activity/ForwardOperations:a	(Lcom/tencent/mobileqq/activity/ForwardOperations;)Z
    //   268: ifeq +173 -> 441
    //   271: aload_0
    //   272: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   275: getfield 50	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   278: aload_0
    //   279: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   282: getfield 50	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   285: iconst_3
    //   286: bipush 100
    //   288: iconst_0
    //   289: invokevirtual 89	android/os/Handler:obtainMessage	(III)Landroid/os/Message;
    //   292: invokevirtual 93	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   295: pop
    //   296: aload_0
    //   297: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   300: getfield 50	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   303: iconst_2
    //   304: ldc2_w 121
    //   307: invokevirtual 126	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   310: pop
    //   311: aload_0
    //   312: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   315: iconst_0
    //   316: invokestatic 59	com/tencent/mobileqq/activity/ForwardOperations:a	(Lcom/tencent/mobileqq/activity/ForwardOperations;Z)Z
    //   319: pop
    //   320: aload_0
    //   321: getfield 20	dyv:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   324: ifnull +10 -> 334
    //   327: aload_0
    //   328: getfield 20	dyv:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   331: invokevirtual 64	java/io/InputStream:close	()V
    //   334: aload 9
    //   336: ifnull -257 -> 79
    //   339: aload 9
    //   341: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   344: return
    //   345: astore 8
    //   347: return
    //   348: aload_0
    //   349: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   352: getfield 110	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   355: ldc 128
    //   357: invokevirtual 117	android/app/Activity:getString	(I)Ljava/lang/String;
    //   360: putstatic 120	com/tencent/mobileqq/activity/ForwardOperations:M	Ljava/lang/String;
    //   363: goto -114 -> 249
    //   366: astore 10
    //   368: aload 9
    //   370: astore 8
    //   372: aload 10
    //   374: astore 9
    //   376: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +13 -> 392
    //   382: ldc 135
    //   384: iconst_2
    //   385: ldc 137
    //   387: aload 9
    //   389: invokestatic 141	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   392: aload_0
    //   393: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   396: getfield 50	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   399: iconst_1
    //   400: invokevirtual 56	android/os/Handler:sendEmptyMessage	(I)Z
    //   403: pop
    //   404: aload_0
    //   405: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   408: iconst_0
    //   409: invokestatic 59	com/tencent/mobileqq/activity/ForwardOperations:a	(Lcom/tencent/mobileqq/activity/ForwardOperations;Z)Z
    //   412: pop
    //   413: aload_0
    //   414: getfield 20	dyv:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   417: ifnull +10 -> 427
    //   420: aload_0
    //   421: getfield 20	dyv:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   424: invokevirtual 64	java/io/InputStream:close	()V
    //   427: aload 8
    //   429: ifnull -350 -> 79
    //   432: aload 8
    //   434: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   437: return
    //   438: astore 8
    //   440: return
    //   441: aload 9
    //   443: ifnull +8 -> 451
    //   446: aload 9
    //   448: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   451: aload 10
    //   453: invokevirtual 144	java/io/File:delete	()Z
    //   456: pop
    //   457: goto -146 -> 311
    //   460: astore 8
    //   462: aload_0
    //   463: getfield 16	dyv:jdField_a_of_type_ComTencentMobileqqActivityForwardOperations	Lcom/tencent/mobileqq/activity/ForwardOperations;
    //   466: iconst_0
    //   467: invokestatic 59	com/tencent/mobileqq/activity/ForwardOperations:a	(Lcom/tencent/mobileqq/activity/ForwardOperations;Z)Z
    //   470: pop
    //   471: aload_0
    //   472: getfield 20	dyv:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   475: ifnull +10 -> 485
    //   478: aload_0
    //   479: getfield 20	dyv:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   482: invokevirtual 64	java/io/InputStream:close	()V
    //   485: aload 9
    //   487: ifnull +8 -> 495
    //   490: aload 9
    //   492: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   495: aload 8
    //   497: athrow
    //   498: astore 8
    //   500: goto -49 -> 451
    //   503: astore 9
    //   505: goto -10 -> 495
    //   508: astore 8
    //   510: aconst_null
    //   511: astore 9
    //   513: goto -51 -> 462
    //   516: astore 10
    //   518: aload 8
    //   520: astore 9
    //   522: aload 10
    //   524: astore 8
    //   526: goto -64 -> 462
    //   529: astore 9
    //   531: goto -155 -> 376
    //   534: astore 8
    //   536: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	dyv
    //   115	28	1	i	int
    //   136	71	2	l1	long
    //   104	109	4	l2	long
    //   101	104	6	l3	long
    //   1	139	8	arrayOfByte	byte[]
    //   345	1	8	localIOException1	java.io.IOException
    //   370	63	8	localObject1	Object
    //   438	1	8	localIOException2	java.io.IOException
    //   460	36	8	localObject2	Object
    //   498	1	8	localIOException3	java.io.IOException
    //   508	11	8	localObject3	Object
    //   524	1	8	localObject4	Object
    //   534	1	8	localIOException4	java.io.IOException
    //   91	400	9	localObject5	Object
    //   503	1	9	localIOException5	java.io.IOException
    //   511	10	9	localObject6	Object
    //   529	1	9	localException1	java.lang.Exception
    //   14	11	10	localFile	java.io.File
    //   366	86	10	localException2	java.lang.Exception
    //   516	7	10	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   320	334	345	java/io/IOException
    //   339	344	345	java/io/IOException
    //   93	100	366	java/lang/Exception
    //   106	116	366	java/lang/Exception
    //   121	131	366	java/lang/Exception
    //   137	146	366	java/lang/Exception
    //   149	203	366	java/lang/Exception
    //   219	249	366	java/lang/Exception
    //   249	261	366	java/lang/Exception
    //   261	311	366	java/lang/Exception
    //   348	363	366	java/lang/Exception
    //   446	451	366	java/lang/Exception
    //   451	457	366	java/lang/Exception
    //   413	427	438	java/io/IOException
    //   432	437	438	java/io/IOException
    //   93	100	460	finally
    //   106	116	460	finally
    //   121	131	460	finally
    //   137	146	460	finally
    //   149	203	460	finally
    //   219	249	460	finally
    //   249	261	460	finally
    //   261	311	460	finally
    //   348	363	460	finally
    //   446	451	460	finally
    //   451	457	460	finally
    //   446	451	498	java/io/IOException
    //   471	485	503	java/io/IOException
    //   490	495	503	java/io/IOException
    //   3	44	508	finally
    //   80	93	508	finally
    //   376	392	516	finally
    //   392	404	516	finally
    //   3	44	529	java/lang/Exception
    //   80	93	529	java/lang/Exception
    //   53	67	534	java/io/IOException
    //   71	79	534	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dyv
 * JD-Core Version:    0.7.0.1
 */