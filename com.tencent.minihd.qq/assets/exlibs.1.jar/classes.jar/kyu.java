import com.tencent.mobileqq.widget.QZoneCoverView;

public class kyu
  extends Thread
{
  public kyu(QZoneCoverView paramQZoneCoverView) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   7: getfield 27	com/tencent/mobileqq/widget/QZoneCoverView:d	Ljava/lang/String;
    //   10: astore 7
    //   12: aload 7
    //   14: ldc 29
    //   16: invokevirtual 35	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   19: istore_1
    //   20: iload_1
    //   21: ifle +475 -> 496
    //   24: aload 7
    //   26: iconst_0
    //   27: iload_1
    //   28: invokevirtual 39	java/lang/String:substring	(II)Ljava/lang/String;
    //   31: astore 5
    //   33: invokestatic 45	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   36: aload 5
    //   38: invokestatic 50	cooperation/qzone/util/ImageFilePathUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 4
    //   43: aload 4
    //   45: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +36 -> 84
    //   51: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +29 -> 83
    //   57: ldc 64
    //   59: iconst_2
    //   60: new 66	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   67: ldc 69
    //   69: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 5
    //   74: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: return
    //   84: new 83	java/io/File
    //   87: dup
    //   88: aload 4
    //   90: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore 4
    //   95: aload 4
    //   97: invokevirtual 89	java/io/File:exists	()Z
    //   100: ifeq +13 -> 113
    //   103: aload 4
    //   105: invokevirtual 93	java/io/File:length	()J
    //   108: lconst_0
    //   109: lcmp
    //   110: ifgt +288 -> 398
    //   113: ldc 95
    //   115: aload 5
    //   117: invokestatic 101	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 6
    //   122: aload_0
    //   123: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   126: getfield 104	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: aload 6
    //   131: aload 4
    //   133: invokestatic 109	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   136: istore_3
    //   137: iload_3
    //   138: istore_2
    //   139: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +40 -> 182
    //   145: ldc 64
    //   147: iconst_2
    //   148: new 66	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   155: ldc 111
    //   157: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload_3
    //   161: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: ldc 116
    //   166: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 5
    //   171: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: iload_3
    //   181: istore_2
    //   182: aload_0
    //   183: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   186: invokevirtual 120	com/tencent/mobileqq/widget/QZoneCoverView:getResources	()Landroid/content/res/Resources;
    //   189: ldc 121
    //   191: invokevirtual 127	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   194: astore 4
    //   196: iload_2
    //   197: ifeq +296 -> 493
    //   200: new 129	java/net/URL
    //   203: dup
    //   204: ldc 131
    //   206: ldc 133
    //   208: aload 5
    //   210: invokespecial 136	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   213: astore 6
    //   215: aload 6
    //   217: ifnull +276 -> 493
    //   220: aload_0
    //   221: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   224: getfield 139	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   227: ifnonnull +22 -> 249
    //   230: aload_0
    //   231: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   234: aload_0
    //   235: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   238: invokevirtual 120	com/tencent/mobileqq/widget/QZoneCoverView:getResources	()Landroid/content/res/Resources;
    //   241: ldc 140
    //   243: invokevirtual 127	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   246: putfield 139	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   249: aload_0
    //   250: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   253: getfield 139	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   256: ifnull +237 -> 493
    //   259: aload 6
    //   261: aload_0
    //   262: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   265: getfield 139	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   268: aload 4
    //   270: invokestatic 145	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/image/URLDrawable;
    //   273: astore 4
    //   275: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +39 -> 317
    //   281: ldc 64
    //   283: iconst_2
    //   284: new 66	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   291: ldc 147
    //   293: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload 4
    //   298: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: ldc 152
    //   303: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 5
    //   308: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload 4
    //   319: ifnull -236 -> 83
    //   322: aload_0
    //   323: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   326: getfield 156	com/tencent/mobileqq/widget/QZoneCoverView:B	I
    //   329: iconst_2
    //   330: if_icmpeq +14 -> 344
    //   333: aload_0
    //   334: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   337: getfield 156	com/tencent/mobileqq/widget/QZoneCoverView:B	I
    //   340: iconst_5
    //   341: if_icmpne -258 -> 83
    //   344: aload 7
    //   346: aload_0
    //   347: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   350: getfield 27	com/tencent/mobileqq/widget/QZoneCoverView:d	Ljava/lang/String;
    //   353: invokestatic 161	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   356: ifeq -273 -> 83
    //   359: invokestatic 167	android/os/Message:obtain	()Landroid/os/Message;
    //   362: astore 5
    //   364: aload 5
    //   366: bipush 7
    //   368: putfield 170	android/os/Message:what	I
    //   371: aload 5
    //   373: aload 4
    //   375: putfield 174	android/os/Message:obj	Ljava/lang/Object;
    //   378: aload 5
    //   380: iconst_0
    //   381: putfield 177	android/os/Message:arg1	I
    //   384: aload_0
    //   385: getfield 10	kyu:a	Lcom/tencent/mobileqq/widget/QZoneCoverView;
    //   388: getfield 180	com/tencent/mobileqq/widget/QZoneCoverView:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   391: aload 5
    //   393: invokevirtual 186	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   396: pop
    //   397: return
    //   398: iconst_1
    //   399: istore_2
    //   400: goto -218 -> 182
    //   403: astore 4
    //   405: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +14 -> 422
    //   411: ldc 64
    //   413: iconst_2
    //   414: aload 4
    //   416: invokevirtual 187	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   419: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: aconst_null
    //   423: astore 4
    //   425: goto -229 -> 196
    //   428: astore 4
    //   430: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq +14 -> 447
    //   436: ldc 64
    //   438: iconst_2
    //   439: aload 4
    //   441: invokevirtual 188	java/lang/Exception:toString	()Ljava/lang/String;
    //   444: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aconst_null
    //   448: astore 4
    //   450: goto -254 -> 196
    //   453: astore 9
    //   455: aload 8
    //   457: astore 6
    //   459: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq -247 -> 215
    //   465: ldc 64
    //   467: iconst_2
    //   468: aload 9
    //   470: invokevirtual 189	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   473: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: aload 8
    //   478: astore 6
    //   480: goto -265 -> 215
    //   483: astore 8
    //   485: aload 8
    //   487: invokevirtual 192	java/lang/Exception:printStackTrace	()V
    //   490: goto -241 -> 249
    //   493: goto -218 -> 275
    //   496: aload 7
    //   498: astore 5
    //   500: goto -467 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	kyu
    //   19	9	1	i	int
    //   138	262	2	bool1	boolean
    //   136	45	3	bool2	boolean
    //   41	333	4	localObject1	java.lang.Object
    //   403	12	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   423	1	4	localObject2	java.lang.Object
    //   428	12	4	localException1	java.lang.Exception
    //   448	1	4	localObject3	java.lang.Object
    //   31	468	5	localObject4	java.lang.Object
    //   120	359	6	localObject5	java.lang.Object
    //   10	487	7	str	java.lang.String
    //   1	476	8	localObject6	java.lang.Object
    //   483	3	8	localException2	java.lang.Exception
    //   453	16	9	localMalformedURLException	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   182	196	403	java/lang/OutOfMemoryError
    //   182	196	428	java/lang/Exception
    //   200	215	453	java/net/MalformedURLException
    //   230	249	483	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kyu
 * JD-Core Version:    0.7.0.1
 */