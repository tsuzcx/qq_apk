import com.tencent.mobileqq.utils.QQRecorder;

public class ktr
  extends Thread
{
  public volatile boolean a;
  
  public ktr(QQRecorder paramQQRecorder, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    QQRecorder.a(paramQQRecorder, paramString);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 35
    //   8: iconst_2
    //   9: new 37	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   16: ldc 40
    //   18: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: lconst_0
    //   32: lstore 19
    //   34: lconst_0
    //   35: lstore 17
    //   37: iconst_0
    //   38: istore 5
    //   40: dconst_0
    //   41: dstore_1
    //   42: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   45: lstore 29
    //   47: lconst_0
    //   48: lstore 15
    //   50: lconst_0
    //   51: lstore 13
    //   53: iconst_0
    //   54: istore 6
    //   56: iconst_0
    //   57: istore 10
    //   59: lconst_0
    //   60: lstore 25
    //   62: iconst_0
    //   63: istore 7
    //   65: iconst_0
    //   66: istore 9
    //   68: iconst_0
    //   69: istore 8
    //   71: lconst_0
    //   72: lstore 23
    //   74: aload_0
    //   75: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   78: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   81: ifnull +22 -> 103
    //   84: aload_0
    //   85: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   88: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   91: aload_0
    //   92: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   95: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   98: invokeinterface 72 2 0
    //   103: aload_0
    //   104: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   107: invokestatic 75	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   110: newarray byte
    //   112: astore 32
    //   114: aload_0
    //   115: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   118: invokestatic 78	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   121: aload_0
    //   122: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   125: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   128: ifnull +15 -> 143
    //   131: aload_0
    //   132: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   135: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   138: invokeinterface 80 1 0
    //   143: aload_0
    //   144: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   147: invokestatic 83	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   150: ldc2_w 84
    //   153: invokestatic 89	java/lang/Thread:sleep	(J)V
    //   156: invokestatic 92	com/tencent/mobileqq/utils/QQRecorder:b	()I
    //   159: sipush 1000
    //   162: idiv
    //   163: sipush 250
    //   166: imul
    //   167: istore 11
    //   169: iload 11
    //   171: newarray byte
    //   173: astore 31
    //   175: aload_0
    //   176: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   179: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   182: aload 31
    //   184: iconst_0
    //   185: iload 11
    //   187: invokevirtual 101	android/media/AudioRecord:read	([BII)I
    //   190: istore 12
    //   192: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +39 -> 234
    //   198: ldc 35
    //   200: iconst_2
    //   201: new 37	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   208: ldc 103
    //   210: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload 12
    //   215: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: ldc 108
    //   220: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload 11
    //   225: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_0
    //   235: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   238: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   241: ifnull +15 -> 256
    //   244: aload_0
    //   245: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   248: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   251: invokeinterface 110 1 0
    //   256: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   259: lstore 27
    //   261: aconst_null
    //   262: astore 31
    //   264: iconst_0
    //   265: istore 5
    //   267: iconst_0
    //   268: istore 11
    //   270: iconst_0
    //   271: istore 6
    //   273: lconst_0
    //   274: lstore 19
    //   276: lconst_0
    //   277: lstore 17
    //   279: dconst_0
    //   280: dstore_1
    //   281: lconst_0
    //   282: lstore 15
    //   284: lconst_0
    //   285: lstore 13
    //   287: iconst_0
    //   288: istore 7
    //   290: aload_0
    //   291: getfield 16	ktr:jdField_a_of_type_Boolean	Z
    //   294: ifeq +768 -> 1062
    //   297: iload 6
    //   299: istore 9
    //   301: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   304: lload 27
    //   306: lsub
    //   307: ldc2_w 111
    //   310: lcmp
    //   311: ifle +119 -> 430
    //   314: iload 6
    //   316: istore 9
    //   318: iload 6
    //   320: ifne +110 -> 430
    //   323: iconst_1
    //   324: istore 10
    //   326: lload 19
    //   328: lconst_0
    //   329: lcmp
    //   330: ifeq +12 -> 342
    //   333: iload 10
    //   335: istore 9
    //   337: iload 7
    //   339: ifne +91 -> 430
    //   342: aload_0
    //   343: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   346: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   349: ifnull +31 -> 380
    //   352: aload_0
    //   353: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   356: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   359: astore 33
    //   361: lload 19
    //   363: lconst_0
    //   364: lcmp
    //   365: ifne +240 -> 605
    //   368: iconst_0
    //   369: istore 6
    //   371: aload 33
    //   373: iload 6
    //   375: invokeinterface 115 2 0
    //   380: iload 10
    //   382: istore 9
    //   384: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +43 -> 430
    //   390: ldc 35
    //   392: iconst_2
    //   393: new 37	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   400: ldc 117
    //   402: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: lload 19
    //   407: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   410: ldc 122
    //   412: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: iload 7
    //   417: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: iload 10
    //   428: istore 9
    //   430: iload 11
    //   432: istore 10
    //   434: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   437: lload 27
    //   439: lsub
    //   440: ldc2_w 111
    //   443: lcmp
    //   444: ifle +79 -> 523
    //   447: iload 11
    //   449: istore 10
    //   451: iload 11
    //   453: ifne +70 -> 523
    //   456: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +4043 -> 4502
    //   462: ldc 35
    //   464: iconst_2
    //   465: new 37	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   472: ldc 124
    //   474: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: iload 8
    //   479: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   482: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: goto +4014 -> 4502
    //   491: iload 6
    //   493: istore 10
    //   495: aload_0
    //   496: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   499: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   502: ifnull +21 -> 523
    //   505: aload_0
    //   506: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   509: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   512: iload 6
    //   514: invokeinterface 126 2 0
    //   519: iload 6
    //   521: istore 10
    //   523: lload 17
    //   525: lconst_1
    //   526: ladd
    //   527: lstore 17
    //   529: iconst_0
    //   530: istore 11
    //   532: aload 31
    //   534: ifnull +19 -> 553
    //   537: aload 31
    //   539: arraylength
    //   540: istore 11
    //   542: aload 31
    //   544: iconst_0
    //   545: aload 32
    //   547: iconst_0
    //   548: iload 11
    //   550: invokestatic 130	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   553: aload_0
    //   554: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   557: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   560: aload 32
    //   562: iload 11
    //   564: aload_0
    //   565: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   568: invokestatic 75	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   571: iload 11
    //   573: isub
    //   574: invokevirtual 101	android/media/AudioRecord:read	([BII)I
    //   577: istore 6
    //   579: iload 6
    //   581: ifgt +36 -> 617
    //   584: ldc2_w 131
    //   587: invokestatic 89	java/lang/Thread:sleep	(J)V
    //   590: iload 6
    //   592: istore 5
    //   594: iload 9
    //   596: istore 6
    //   598: iload 10
    //   600: istore 11
    //   602: goto -312 -> 290
    //   605: iconst_1
    //   606: istore 6
    //   608: goto -237 -> 371
    //   611: iconst_2
    //   612: istore 6
    //   614: goto -123 -> 491
    //   617: aconst_null
    //   618: astore 31
    //   620: lconst_1
    //   621: lload 13
    //   623: ladd
    //   624: lstore 13
    //   626: lload 19
    //   628: iload 6
    //   630: i2l
    //   631: ladd
    //   632: lstore 21
    //   634: iload 11
    //   636: iload 6
    //   638: iadd
    //   639: istore 11
    //   641: iload 11
    //   643: sipush 160
    //   646: irem
    //   647: istore 6
    //   649: iload 6
    //   651: ifeq +3848 -> 4499
    //   654: iload 6
    //   656: newarray byte
    //   658: astore 31
    //   660: aload 32
    //   662: iload 11
    //   664: iload 6
    //   666: isub
    //   667: aload 31
    //   669: iconst_0
    //   670: iload 6
    //   672: invokestatic 130	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   675: iload 11
    //   677: iload 6
    //   679: isub
    //   680: istore 11
    //   682: aload_0
    //   683: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   686: invokestatic 135	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   689: aload 32
    //   691: iload 11
    //   693: fconst_1
    //   694: invokestatic 140	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   697: l2i
    //   698: istore 12
    //   700: iload 7
    //   702: iload 12
    //   704: invokestatic 146	java/lang/Math:max	(II)I
    //   707: istore 6
    //   709: lload 25
    //   711: iload 12
    //   713: i2l
    //   714: ladd
    //   715: lstore 19
    //   717: iconst_0
    //   718: istore 7
    //   720: iload 7
    //   722: iload 11
    //   724: if_icmpge +88 -> 812
    //   727: aload_0
    //   728: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   731: invokestatic 149	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   734: ifnull +20 -> 754
    //   737: aload_0
    //   738: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   741: invokestatic 149	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   744: aload 32
    //   746: iload 7
    //   748: sipush 160
    //   751: invokevirtual 154	com/tencent/mobileqq/utils/PTTAgcWrapper:a	([BII)V
    //   754: aload_0
    //   755: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   758: invokestatic 157	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   761: ifnull +21 -> 782
    //   764: aload_0
    //   765: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   768: invokestatic 157	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   771: aload 32
    //   773: iload 7
    //   775: sipush 160
    //   778: invokevirtual 161	com/tencent/mobileqq/utils/NoiseSuppression:a	([BII)I
    //   781: pop
    //   782: aload_0
    //   783: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   786: invokestatic 149	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   789: ifnull +3732 -> 4521
    //   792: aload_0
    //   793: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   796: invokestatic 149	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   799: aload 32
    //   801: iload 7
    //   803: sipush 160
    //   806: invokevirtual 163	com/tencent/mobileqq/utils/PTTAgcWrapper:b	([BII)V
    //   809: goto +3712 -> 4521
    //   812: aload_0
    //   813: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   816: aload_0
    //   817: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   820: invokestatic 135	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   823: aload 32
    //   825: iload 11
    //   827: fconst_1
    //   828: invokestatic 140	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   831: l2i
    //   832: invokestatic 166	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;I)I
    //   835: pop
    //   836: iload 8
    //   838: aload_0
    //   839: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   842: invokestatic 168	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   845: invokestatic 146	java/lang/Math:max	(II)I
    //   848: istore 7
    //   850: aload_0
    //   851: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   854: invokestatic 168	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   857: istore 8
    //   859: lload 23
    //   861: iload 8
    //   863: i2l
    //   864: ladd
    //   865: lstore 23
    //   867: iload 11
    //   869: i2l
    //   870: lstore 25
    //   872: lload 25
    //   874: invokestatic 171	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   877: dstore_3
    //   878: dload_1
    //   879: dload_3
    //   880: dadd
    //   881: dstore_1
    //   882: aload_0
    //   883: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   886: aload 32
    //   888: iload 11
    //   890: invokestatic 174	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;[BI)[B
    //   893: astore 33
    //   895: aload_0
    //   896: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   899: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   902: ifnull +32 -> 934
    //   905: aload_0
    //   906: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   909: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   912: aload_0
    //   913: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   916: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   919: aload 33
    //   921: aload_0
    //   922: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   925: invokestatic 168	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   928: dload_1
    //   929: invokeinterface 177 6 0
    //   934: aload 33
    //   936: arraylength
    //   937: istore 8
    //   939: lload 15
    //   941: iload 8
    //   943: i2l
    //   944: ladd
    //   945: lstore 15
    //   947: iload 10
    //   949: iconst_1
    //   950: if_icmpne +3542 -> 4492
    //   953: iload 7
    //   955: sipush 500
    //   958: if_icmple +3534 -> 4492
    //   961: iconst_2
    //   962: istore 10
    //   964: aload_0
    //   965: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   968: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   971: ifnull +16 -> 987
    //   974: aload_0
    //   975: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   978: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   981: iconst_2
    //   982: invokeinterface 126 2 0
    //   987: iload 10
    //   989: istore 8
    //   991: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   994: ifeq +33 -> 1027
    //   997: ldc 35
    //   999: iconst_2
    //   1000: new 37	java/lang/StringBuilder
    //   1003: dup
    //   1004: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1007: ldc 179
    //   1009: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: iload 7
    //   1014: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1017: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1020: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1023: iload 10
    //   1025: istore 8
    //   1027: iload 8
    //   1029: istore 11
    //   1031: iload 9
    //   1033: istore 8
    //   1035: iload 6
    //   1037: istore 9
    //   1039: iload 8
    //   1041: istore 6
    //   1043: iload 7
    //   1045: istore 8
    //   1047: lload 19
    //   1049: lstore 25
    //   1051: iload 9
    //   1053: istore 7
    //   1055: lload 21
    //   1057: lstore 19
    //   1059: goto -769 -> 290
    //   1062: aload_0
    //   1063: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1066: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1069: ifnull +54 -> 1123
    //   1072: aload_0
    //   1073: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1076: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1079: aload_0
    //   1080: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1083: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   1086: invokeinterface 181 2 0
    //   1091: aload_0
    //   1092: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1095: getfield 184	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   1098: ifnull +25 -> 1123
    //   1101: aload_0
    //   1102: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1105: invokestatic 187	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1108: iconst_m1
    //   1109: if_icmpeq +14 -> 1123
    //   1112: aload_0
    //   1113: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1116: getfield 184	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   1119: iconst_0
    //   1120: invokevirtual 192	android/media/AudioManager:setMode	(I)V
    //   1123: aload_0
    //   1124: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1127: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1130: ifnull +13 -> 1143
    //   1133: aload_0
    //   1134: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1137: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1140: invokevirtual 195	android/media/AudioRecord:release	()V
    //   1143: aload_0
    //   1144: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1147: invokestatic 197	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   1150: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1153: ifeq +172 -> 1325
    //   1156: ldc 35
    //   1158: iconst_2
    //   1159: new 37	java/lang/StringBuilder
    //   1162: dup
    //   1163: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1166: ldc 199
    //   1168: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: aload_0
    //   1172: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1175: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1181: ldc 35
    //   1183: iconst_2
    //   1184: new 37	java/lang/StringBuilder
    //   1187: dup
    //   1188: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1191: ldc 201
    //   1193: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: lload 17
    //   1198: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1201: ldc 203
    //   1203: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: lload 19
    //   1208: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1211: ldc 205
    //   1213: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: lload 15
    //   1218: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1221: ldc 207
    //   1223: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: iload 5
    //   1228: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1231: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1234: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1237: ldc 35
    //   1239: new 37	java/lang/StringBuilder
    //   1242: dup
    //   1243: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1246: ldc 209
    //   1248: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: dload_1
    //   1252: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1255: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1258: invokestatic 217	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1261: pop
    //   1262: ldc 35
    //   1264: new 37	java/lang/StringBuilder
    //   1267: dup
    //   1268: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1271: ldc 219
    //   1273: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: lload 19
    //   1278: invokestatic 171	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   1281: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1284: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1287: invokestatic 217	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1290: pop
    //   1291: ldc 35
    //   1293: new 37	java/lang/StringBuilder
    //   1296: dup
    //   1297: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1300: ldc 221
    //   1302: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: aload_0
    //   1306: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1309: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   1312: invokestatic 224	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;)I
    //   1315: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1318: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: invokestatic 217	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1324: pop
    //   1325: lload 15
    //   1327: ldc2_w 225
    //   1330: lcmp
    //   1331: iflt +11 -> 1342
    //   1334: dload_1
    //   1335: ldc2_w 227
    //   1338: dcmpg
    //   1339: ifge +268 -> 1607
    //   1342: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1345: lload 29
    //   1347: lsub
    //   1348: ldc2_w 111
    //   1351: lcmp
    //   1352: ifle +255 -> 1607
    //   1355: new 230	java/util/HashMap
    //   1358: dup
    //   1359: invokespecial 231	java/util/HashMap:<init>	()V
    //   1362: astore 31
    //   1364: aload 31
    //   1366: ldc 233
    //   1368: ldc 235
    //   1370: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1373: pop
    //   1374: aload 31
    //   1376: ldc 241
    //   1378: new 37	java/lang/StringBuilder
    //   1381: dup
    //   1382: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1385: getstatic 247	android/os/Build$VERSION:SDK_INT	I
    //   1388: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1391: ldc 249
    //   1393: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1399: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1402: pop
    //   1403: aload 31
    //   1405: ldc 251
    //   1407: new 37	java/lang/StringBuilder
    //   1410: dup
    //   1411: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1414: getstatic 257	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1417: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: ldc_w 259
    //   1423: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: getstatic 262	android/os/Build:MODEL	Ljava/lang/String;
    //   1429: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1435: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1438: pop
    //   1439: aload 31
    //   1441: ldc_w 264
    //   1444: new 37	java/lang/StringBuilder
    //   1447: dup
    //   1448: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1451: lload 19
    //   1453: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1456: ldc 249
    //   1458: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1464: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1467: pop
    //   1468: aload 31
    //   1470: ldc_w 266
    //   1473: new 37	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1480: dload_1
    //   1481: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1484: ldc 249
    //   1486: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1492: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1495: pop
    //   1496: aload 31
    //   1498: ldc_w 268
    //   1501: new 37	java/lang/StringBuilder
    //   1504: dup
    //   1505: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1508: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1511: lload 29
    //   1513: lsub
    //   1514: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1517: ldc 249
    //   1519: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1522: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1525: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1528: pop
    //   1529: ldc_w 270
    //   1532: iconst_0
    //   1533: aload 31
    //   1535: invokestatic 273	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   1538: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1541: ifeq +66 -> 1607
    //   1544: ldc 35
    //   1546: iconst_2
    //   1547: new 37	java/lang/StringBuilder
    //   1550: dup
    //   1551: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1554: ldc_w 275
    //   1557: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: lload 19
    //   1562: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1565: ldc_w 277
    //   1568: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1571: lload 15
    //   1573: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1576: ldc_w 279
    //   1579: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: dload_1
    //   1583: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1586: ldc_w 281
    //   1589: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1595: lload 29
    //   1597: lsub
    //   1598: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1601: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1604: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1607: new 230	java/util/HashMap
    //   1610: dup
    //   1611: invokespecial 231	java/util/HashMap:<init>	()V
    //   1614: astore 31
    //   1616: aload 31
    //   1618: ldc 241
    //   1620: new 37	java/lang/StringBuilder
    //   1623: dup
    //   1624: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1627: getstatic 247	android/os/Build$VERSION:SDK_INT	I
    //   1630: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1633: ldc 249
    //   1635: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1641: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1644: pop
    //   1645: aload 31
    //   1647: ldc 251
    //   1649: new 37	java/lang/StringBuilder
    //   1652: dup
    //   1653: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1656: getstatic 257	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1659: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1662: ldc_w 259
    //   1665: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1668: getstatic 262	android/os/Build:MODEL	Ljava/lang/String;
    //   1671: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1677: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1680: pop
    //   1681: aload 31
    //   1683: ldc_w 264
    //   1686: new 37	java/lang/StringBuilder
    //   1689: dup
    //   1690: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1693: lload 19
    //   1695: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1698: ldc 249
    //   1700: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1706: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1709: pop
    //   1710: aload 31
    //   1712: ldc_w 283
    //   1715: new 37	java/lang/StringBuilder
    //   1718: dup
    //   1719: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1722: dload_1
    //   1723: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1726: ldc 249
    //   1728: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1734: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1737: pop
    //   1738: aload 31
    //   1740: ldc_w 268
    //   1743: new 37	java/lang/StringBuilder
    //   1746: dup
    //   1747: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1750: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1753: lload 29
    //   1755: lsub
    //   1756: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1759: ldc 249
    //   1761: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1767: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1770: pop
    //   1771: aload 31
    //   1773: ldc_w 285
    //   1776: new 37	java/lang/StringBuilder
    //   1779: dup
    //   1780: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1783: iload 7
    //   1785: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1788: ldc 249
    //   1790: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1793: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1796: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1799: pop
    //   1800: aload 31
    //   1802: ldc_w 287
    //   1805: new 37	java/lang/StringBuilder
    //   1808: dup
    //   1809: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1812: iload 8
    //   1814: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1817: ldc 249
    //   1819: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1825: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1828: pop
    //   1829: lload 13
    //   1831: lconst_0
    //   1832: lcmp
    //   1833: ifne +274 -> 2107
    //   1836: ldc2_w 288
    //   1839: lstore 17
    //   1841: goto +2691 -> 4532
    //   1844: lload 13
    //   1846: l2i
    //   1847: istore 5
    //   1849: aload 31
    //   1851: ldc_w 291
    //   1854: new 37	java/lang/StringBuilder
    //   1857: dup
    //   1858: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1861: iload 6
    //   1863: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1866: ldc 249
    //   1868: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1874: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1877: pop
    //   1878: aload 31
    //   1880: ldc_w 293
    //   1883: new 37	java/lang/StringBuilder
    //   1886: dup
    //   1887: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1890: iload 5
    //   1892: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1895: ldc 249
    //   1897: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1900: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1903: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1906: pop
    //   1907: ldc_w 295
    //   1910: iconst_1
    //   1911: aload 31
    //   1913: invokestatic 273	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   1916: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1919: ifeq +138 -> 2057
    //   1922: new 37	java/lang/StringBuilder
    //   1925: dup
    //   1926: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1929: astore 31
    //   1931: aload 31
    //   1933: ldc_w 297
    //   1936: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: iload 7
    //   1941: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1944: pop
    //   1945: aload 31
    //   1947: ldc_w 299
    //   1950: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: iload 6
    //   1955: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1958: pop
    //   1959: aload 31
    //   1961: ldc_w 301
    //   1964: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1967: iload 5
    //   1969: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1972: pop
    //   1973: aload 31
    //   1975: ldc_w 303
    //   1978: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1981: iload 5
    //   1983: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1986: pop
    //   1987: aload 31
    //   1989: ldc_w 305
    //   1992: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: lload 19
    //   1997: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2000: pop
    //   2001: aload 31
    //   2003: ldc_w 307
    //   2006: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2009: lload 15
    //   2011: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2014: pop
    //   2015: aload 31
    //   2017: ldc_w 309
    //   2020: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2023: dload_1
    //   2024: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2027: pop
    //   2028: aload 31
    //   2030: ldc_w 311
    //   2033: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2036: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   2039: lload 29
    //   2041: lsub
    //   2042: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2045: pop
    //   2046: ldc 35
    //   2048: iconst_2
    //   2049: aload 31
    //   2051: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2054: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2057: aload_0
    //   2058: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2061: aconst_null
    //   2062: putfield 314	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Ktr	Lktr;
    //   2065: aload_0
    //   2066: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2069: aconst_null
    //   2070: invokestatic 21	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   2073: pop
    //   2074: return
    //   2075: astore 31
    //   2077: aload 31
    //   2079: invokevirtual 317	java/lang/Throwable:printStackTrace	()V
    //   2082: goto -932 -> 1150
    //   2085: astore 31
    //   2087: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2090: ifeq -483 -> 1607
    //   2093: ldc 35
    //   2095: iconst_2
    //   2096: ldc_w 319
    //   2099: aload 31
    //   2101: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2104: goto -497 -> 1607
    //   2107: lload 25
    //   2109: lload 13
    //   2111: ldiv
    //   2112: lstore 17
    //   2114: goto +2418 -> 4532
    //   2117: lload 23
    //   2119: lload 13
    //   2121: ldiv
    //   2122: lstore 13
    //   2124: goto -280 -> 1844
    //   2127: astore 31
    //   2129: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2132: ifeq -75 -> 2057
    //   2135: ldc 35
    //   2137: iconst_2
    //   2138: ldc_w 324
    //   2141: aload 31
    //   2143: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2146: goto -89 -> 2057
    //   2149: astore 31
    //   2151: iload 10
    //   2153: istore 6
    //   2155: lload 25
    //   2157: lstore 21
    //   2159: iload 7
    //   2161: istore 8
    //   2163: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2166: ifeq +35 -> 2201
    //   2169: ldc 35
    //   2171: iconst_2
    //   2172: new 37	java/lang/StringBuilder
    //   2175: dup
    //   2176: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2179: ldc_w 326
    //   2182: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: aload 31
    //   2187: invokestatic 330	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2190: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2193: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2196: aload 31
    //   2198: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2201: aload_0
    //   2202: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2205: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   2208: ifnull +59 -> 2267
    //   2211: aload_0
    //   2212: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2215: getfield 184	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   2218: ifnull +25 -> 2243
    //   2221: aload_0
    //   2222: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2225: invokestatic 187	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   2228: iconst_m1
    //   2229: if_icmpeq +14 -> 2243
    //   2232: aload_0
    //   2233: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2236: getfield 184	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   2239: iconst_0
    //   2240: invokevirtual 192	android/media/AudioManager:setMode	(I)V
    //   2243: aload_0
    //   2244: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2247: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   2250: aload_0
    //   2251: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2254: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   2257: aload 31
    //   2259: invokevirtual 333	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2262: invokeinterface 336 3 0
    //   2267: aload_0
    //   2268: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2271: aload 31
    //   2273: invokevirtual 339	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/Throwable;)V
    //   2276: aload_0
    //   2277: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2280: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2283: ifnull +13 -> 2296
    //   2286: aload_0
    //   2287: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2290: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2293: invokevirtual 195	android/media/AudioRecord:release	()V
    //   2296: aload_0
    //   2297: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2300: invokestatic 197	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   2303: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2306: ifeq +172 -> 2478
    //   2309: ldc 35
    //   2311: iconst_2
    //   2312: new 37	java/lang/StringBuilder
    //   2315: dup
    //   2316: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2319: ldc 199
    //   2321: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2324: aload_0
    //   2325: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2328: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2331: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2334: ldc 35
    //   2336: iconst_2
    //   2337: new 37	java/lang/StringBuilder
    //   2340: dup
    //   2341: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2344: ldc 201
    //   2346: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2349: lload 19
    //   2351: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2354: ldc 203
    //   2356: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2359: lload 17
    //   2361: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2364: ldc 205
    //   2366: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2369: lload 15
    //   2371: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2374: ldc 207
    //   2376: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2379: iload 5
    //   2381: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2384: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2387: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2390: ldc 35
    //   2392: new 37	java/lang/StringBuilder
    //   2395: dup
    //   2396: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2399: ldc 209
    //   2401: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2404: dload_1
    //   2405: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2408: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2411: invokestatic 217	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2414: pop
    //   2415: ldc 35
    //   2417: new 37	java/lang/StringBuilder
    //   2420: dup
    //   2421: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2424: ldc 219
    //   2426: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2429: lload 17
    //   2431: invokestatic 171	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   2434: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2437: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2440: invokestatic 217	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2443: pop
    //   2444: ldc 35
    //   2446: new 37	java/lang/StringBuilder
    //   2449: dup
    //   2450: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2453: ldc 221
    //   2455: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2458: aload_0
    //   2459: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2462: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   2465: invokestatic 224	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;)I
    //   2468: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2471: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2474: invokestatic 217	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2477: pop
    //   2478: lload 15
    //   2480: ldc2_w 225
    //   2483: lcmp
    //   2484: iflt +11 -> 2495
    //   2487: dload_1
    //   2488: ldc2_w 227
    //   2491: dcmpg
    //   2492: ifge +3 -> 2495
    //   2495: new 230	java/util/HashMap
    //   2498: dup
    //   2499: invokespecial 231	java/util/HashMap:<init>	()V
    //   2502: astore 31
    //   2504: aload 31
    //   2506: ldc 241
    //   2508: new 37	java/lang/StringBuilder
    //   2511: dup
    //   2512: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2515: getstatic 247	android/os/Build$VERSION:SDK_INT	I
    //   2518: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2521: ldc 249
    //   2523: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2526: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2529: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2532: pop
    //   2533: aload 31
    //   2535: ldc 251
    //   2537: new 37	java/lang/StringBuilder
    //   2540: dup
    //   2541: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2544: getstatic 257	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2547: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2550: ldc_w 259
    //   2553: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2556: getstatic 262	android/os/Build:MODEL	Ljava/lang/String;
    //   2559: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2562: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2565: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2568: pop
    //   2569: aload 31
    //   2571: ldc_w 264
    //   2574: new 37	java/lang/StringBuilder
    //   2577: dup
    //   2578: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2581: lload 17
    //   2583: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2586: ldc 249
    //   2588: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2591: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2594: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2597: pop
    //   2598: aload 31
    //   2600: ldc_w 283
    //   2603: new 37	java/lang/StringBuilder
    //   2606: dup
    //   2607: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2610: dload_1
    //   2611: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2614: ldc 249
    //   2616: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2619: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2622: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2625: pop
    //   2626: aload 31
    //   2628: ldc_w 268
    //   2631: new 37	java/lang/StringBuilder
    //   2634: dup
    //   2635: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2638: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   2641: lload 29
    //   2643: lsub
    //   2644: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2647: ldc 249
    //   2649: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2652: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2655: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2658: pop
    //   2659: aload 31
    //   2661: ldc_w 285
    //   2664: new 37	java/lang/StringBuilder
    //   2667: dup
    //   2668: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2671: iload 6
    //   2673: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2676: ldc 249
    //   2678: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2681: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2684: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2687: pop
    //   2688: aload 31
    //   2690: ldc_w 287
    //   2693: new 37	java/lang/StringBuilder
    //   2696: dup
    //   2697: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2700: iload 8
    //   2702: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2705: ldc 249
    //   2707: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2710: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2713: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2716: pop
    //   2717: lload 13
    //   2719: lconst_0
    //   2720: lcmp
    //   2721: ifne +252 -> 2973
    //   2724: ldc2_w 288
    //   2727: lstore 19
    //   2729: goto +1823 -> 4552
    //   2732: lload 13
    //   2734: l2i
    //   2735: istore 5
    //   2737: aload 31
    //   2739: ldc_w 291
    //   2742: new 37	java/lang/StringBuilder
    //   2745: dup
    //   2746: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2749: iload 7
    //   2751: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2754: ldc 249
    //   2756: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2759: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2762: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2765: pop
    //   2766: aload 31
    //   2768: ldc_w 293
    //   2771: new 37	java/lang/StringBuilder
    //   2774: dup
    //   2775: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2778: iload 5
    //   2780: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2783: ldc 249
    //   2785: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2788: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2791: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2794: pop
    //   2795: ldc_w 295
    //   2798: iconst_1
    //   2799: aload 31
    //   2801: invokestatic 273	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2804: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2807: ifeq +138 -> 2945
    //   2810: new 37	java/lang/StringBuilder
    //   2813: dup
    //   2814: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2817: astore 31
    //   2819: aload 31
    //   2821: ldc_w 297
    //   2824: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2827: iload 6
    //   2829: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2832: pop
    //   2833: aload 31
    //   2835: ldc_w 299
    //   2838: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2841: iload 7
    //   2843: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2846: pop
    //   2847: aload 31
    //   2849: ldc_w 301
    //   2852: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2855: iload 5
    //   2857: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2860: pop
    //   2861: aload 31
    //   2863: ldc_w 303
    //   2866: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2869: iload 5
    //   2871: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2874: pop
    //   2875: aload 31
    //   2877: ldc_w 305
    //   2880: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2883: lload 17
    //   2885: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2888: pop
    //   2889: aload 31
    //   2891: ldc_w 307
    //   2894: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2897: lload 15
    //   2899: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2902: pop
    //   2903: aload 31
    //   2905: ldc_w 309
    //   2908: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2911: dload_1
    //   2912: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2915: pop
    //   2916: aload 31
    //   2918: ldc_w 311
    //   2921: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2924: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   2927: lload 29
    //   2929: lsub
    //   2930: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2933: pop
    //   2934: ldc 35
    //   2936: iconst_2
    //   2937: aload 31
    //   2939: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2942: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2945: aload_0
    //   2946: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2949: aconst_null
    //   2950: putfield 314	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Ktr	Lktr;
    //   2953: aload_0
    //   2954: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2957: aconst_null
    //   2958: invokestatic 21	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   2961: pop
    //   2962: return
    //   2963: astore 31
    //   2965: aload 31
    //   2967: invokevirtual 317	java/lang/Throwable:printStackTrace	()V
    //   2970: goto -667 -> 2303
    //   2973: lload 21
    //   2975: lload 13
    //   2977: ldiv
    //   2978: lstore 19
    //   2980: goto +1572 -> 4552
    //   2983: lload 23
    //   2985: lload 13
    //   2987: ldiv
    //   2988: lstore 13
    //   2990: goto -258 -> 2732
    //   2993: astore 31
    //   2995: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2998: ifeq -53 -> 2945
    //   3001: ldc 35
    //   3003: iconst_2
    //   3004: ldc_w 324
    //   3007: aload 31
    //   3009: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3012: goto -67 -> 2945
    //   3015: astore 31
    //   3017: iconst_0
    //   3018: istore 5
    //   3020: lconst_0
    //   3021: lstore 21
    //   3023: lconst_0
    //   3024: lstore 17
    //   3026: lconst_0
    //   3027: lstore 15
    //   3029: dconst_0
    //   3030: dstore_1
    //   3031: iconst_0
    //   3032: istore 7
    //   3034: lload 25
    //   3036: lstore 19
    //   3038: iload 9
    //   3040: istore 8
    //   3042: aload_0
    //   3043: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3046: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   3049: ifnull +13 -> 3062
    //   3052: aload_0
    //   3053: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3056: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   3059: invokevirtual 195	android/media/AudioRecord:release	()V
    //   3062: aload_0
    //   3063: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3066: invokestatic 197	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   3069: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3072: ifeq +172 -> 3244
    //   3075: ldc 35
    //   3077: iconst_2
    //   3078: new 37	java/lang/StringBuilder
    //   3081: dup
    //   3082: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3085: ldc 199
    //   3087: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3090: aload_0
    //   3091: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3094: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3097: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3100: ldc 35
    //   3102: iconst_2
    //   3103: new 37	java/lang/StringBuilder
    //   3106: dup
    //   3107: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3110: ldc 201
    //   3112: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3115: lload 17
    //   3117: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3120: ldc 203
    //   3122: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3125: lload 21
    //   3127: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3130: ldc 205
    //   3132: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3135: lload 15
    //   3137: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3140: ldc 207
    //   3142: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3145: iload 5
    //   3147: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3150: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3153: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3156: ldc 35
    //   3158: new 37	java/lang/StringBuilder
    //   3161: dup
    //   3162: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3165: ldc 209
    //   3167: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3170: dload_1
    //   3171: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3174: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3177: invokestatic 217	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   3180: pop
    //   3181: ldc 35
    //   3183: new 37	java/lang/StringBuilder
    //   3186: dup
    //   3187: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3190: ldc 219
    //   3192: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3195: lload 21
    //   3197: invokestatic 171	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   3200: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3203: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3206: invokestatic 217	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   3209: pop
    //   3210: ldc 35
    //   3212: new 37	java/lang/StringBuilder
    //   3215: dup
    //   3216: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3219: ldc 221
    //   3221: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3224: aload_0
    //   3225: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3228: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   3231: invokestatic 224	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;)I
    //   3234: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3237: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3240: invokestatic 217	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   3243: pop
    //   3244: lload 15
    //   3246: ldc2_w 225
    //   3249: lcmp
    //   3250: iflt +11 -> 3261
    //   3253: dload_1
    //   3254: ldc2_w 227
    //   3257: dcmpg
    //   3258: ifge +273 -> 3531
    //   3261: iload 7
    //   3263: ifne +268 -> 3531
    //   3266: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3269: lload 29
    //   3271: lsub
    //   3272: ldc2_w 111
    //   3275: lcmp
    //   3276: ifle +255 -> 3531
    //   3279: new 230	java/util/HashMap
    //   3282: dup
    //   3283: invokespecial 231	java/util/HashMap:<init>	()V
    //   3286: astore 32
    //   3288: aload 32
    //   3290: ldc 233
    //   3292: ldc 235
    //   3294: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3297: pop
    //   3298: aload 32
    //   3300: ldc 241
    //   3302: new 37	java/lang/StringBuilder
    //   3305: dup
    //   3306: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3309: getstatic 247	android/os/Build$VERSION:SDK_INT	I
    //   3312: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3315: ldc 249
    //   3317: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3320: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3323: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3326: pop
    //   3327: aload 32
    //   3329: ldc 251
    //   3331: new 37	java/lang/StringBuilder
    //   3334: dup
    //   3335: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3338: getstatic 257	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3341: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3344: ldc_w 259
    //   3347: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3350: getstatic 262	android/os/Build:MODEL	Ljava/lang/String;
    //   3353: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3356: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3359: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3362: pop
    //   3363: aload 32
    //   3365: ldc_w 264
    //   3368: new 37	java/lang/StringBuilder
    //   3371: dup
    //   3372: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3375: lload 21
    //   3377: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3380: ldc 249
    //   3382: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3385: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3388: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3391: pop
    //   3392: aload 32
    //   3394: ldc_w 266
    //   3397: new 37	java/lang/StringBuilder
    //   3400: dup
    //   3401: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3404: dload_1
    //   3405: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3408: ldc 249
    //   3410: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3413: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3416: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3419: pop
    //   3420: aload 32
    //   3422: ldc_w 268
    //   3425: new 37	java/lang/StringBuilder
    //   3428: dup
    //   3429: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3432: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3435: lload 29
    //   3437: lsub
    //   3438: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3441: ldc 249
    //   3443: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3446: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3449: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3452: pop
    //   3453: ldc_w 270
    //   3456: iconst_0
    //   3457: aload 32
    //   3459: invokestatic 273	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3462: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3465: ifeq +66 -> 3531
    //   3468: ldc 35
    //   3470: iconst_2
    //   3471: new 37	java/lang/StringBuilder
    //   3474: dup
    //   3475: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3478: ldc_w 275
    //   3481: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3484: lload 21
    //   3486: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3489: ldc_w 277
    //   3492: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3495: lload 15
    //   3497: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3500: ldc_w 279
    //   3503: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3506: dload_1
    //   3507: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3510: ldc_w 281
    //   3513: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3516: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3519: lload 29
    //   3521: lsub
    //   3522: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3525: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3528: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3531: new 230	java/util/HashMap
    //   3534: dup
    //   3535: invokespecial 231	java/util/HashMap:<init>	()V
    //   3538: astore 32
    //   3540: aload 32
    //   3542: ldc 241
    //   3544: new 37	java/lang/StringBuilder
    //   3547: dup
    //   3548: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3551: getstatic 247	android/os/Build$VERSION:SDK_INT	I
    //   3554: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3557: ldc 249
    //   3559: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3562: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3565: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3568: pop
    //   3569: aload 32
    //   3571: ldc 251
    //   3573: new 37	java/lang/StringBuilder
    //   3576: dup
    //   3577: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3580: getstatic 257	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3583: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3586: ldc_w 259
    //   3589: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3592: getstatic 262	android/os/Build:MODEL	Ljava/lang/String;
    //   3595: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3598: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3601: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3604: pop
    //   3605: aload 32
    //   3607: ldc_w 264
    //   3610: new 37	java/lang/StringBuilder
    //   3613: dup
    //   3614: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3617: lload 21
    //   3619: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3622: ldc 249
    //   3624: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3627: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3630: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3633: pop
    //   3634: aload 32
    //   3636: ldc_w 283
    //   3639: new 37	java/lang/StringBuilder
    //   3642: dup
    //   3643: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3646: dload_1
    //   3647: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3650: ldc 249
    //   3652: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3655: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3658: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3661: pop
    //   3662: aload 32
    //   3664: ldc_w 268
    //   3667: new 37	java/lang/StringBuilder
    //   3670: dup
    //   3671: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3674: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3677: lload 29
    //   3679: lsub
    //   3680: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3683: ldc 249
    //   3685: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3688: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3691: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3694: pop
    //   3695: aload 32
    //   3697: ldc_w 285
    //   3700: new 37	java/lang/StringBuilder
    //   3703: dup
    //   3704: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3707: iload 6
    //   3709: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3712: ldc 249
    //   3714: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3717: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3720: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3723: pop
    //   3724: aload 32
    //   3726: ldc_w 287
    //   3729: new 37	java/lang/StringBuilder
    //   3732: dup
    //   3733: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3736: iload 8
    //   3738: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3741: ldc 249
    //   3743: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3746: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3749: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3752: pop
    //   3753: lload 13
    //   3755: lconst_0
    //   3756: lcmp
    //   3757: ifne +276 -> 4033
    //   3760: ldc2_w 288
    //   3763: lstore 17
    //   3765: goto +807 -> 4572
    //   3768: lload 13
    //   3770: l2i
    //   3771: istore 5
    //   3773: aload 32
    //   3775: ldc_w 291
    //   3778: new 37	java/lang/StringBuilder
    //   3781: dup
    //   3782: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3785: iload 7
    //   3787: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3790: ldc 249
    //   3792: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3795: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3798: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3801: pop
    //   3802: aload 32
    //   3804: ldc_w 293
    //   3807: new 37	java/lang/StringBuilder
    //   3810: dup
    //   3811: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3814: iload 5
    //   3816: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3819: ldc 249
    //   3821: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3824: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3827: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3830: pop
    //   3831: ldc_w 295
    //   3834: iconst_1
    //   3835: aload 32
    //   3837: invokestatic 273	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3840: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3843: ifeq +138 -> 3981
    //   3846: new 37	java/lang/StringBuilder
    //   3849: dup
    //   3850: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3853: astore 32
    //   3855: aload 32
    //   3857: ldc_w 297
    //   3860: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3863: iload 6
    //   3865: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3868: pop
    //   3869: aload 32
    //   3871: ldc_w 299
    //   3874: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3877: iload 7
    //   3879: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3882: pop
    //   3883: aload 32
    //   3885: ldc_w 301
    //   3888: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3891: iload 5
    //   3893: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3896: pop
    //   3897: aload 32
    //   3899: ldc_w 303
    //   3902: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3905: iload 5
    //   3907: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3910: pop
    //   3911: aload 32
    //   3913: ldc_w 305
    //   3916: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3919: lload 21
    //   3921: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3924: pop
    //   3925: aload 32
    //   3927: ldc_w 307
    //   3930: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3933: lload 15
    //   3935: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3938: pop
    //   3939: aload 32
    //   3941: ldc_w 309
    //   3944: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3947: dload_1
    //   3948: invokevirtual 212	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3951: pop
    //   3952: aload 32
    //   3954: ldc_w 311
    //   3957: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3960: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3963: lload 29
    //   3965: lsub
    //   3966: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3969: pop
    //   3970: ldc 35
    //   3972: iconst_2
    //   3973: aload 32
    //   3975: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3978: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3981: aload_0
    //   3982: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3985: aconst_null
    //   3986: putfield 314	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Ktr	Lktr;
    //   3989: aload_0
    //   3990: getfield 11	ktr:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3993: aconst_null
    //   3994: invokestatic 21	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   3997: pop
    //   3998: aload 31
    //   4000: athrow
    //   4001: astore 32
    //   4003: aload 32
    //   4005: invokevirtual 317	java/lang/Throwable:printStackTrace	()V
    //   4008: goto -939 -> 3069
    //   4011: astore 32
    //   4013: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4016: ifeq -485 -> 3531
    //   4019: ldc 35
    //   4021: iconst_2
    //   4022: ldc_w 319
    //   4025: aload 32
    //   4027: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4030: goto -499 -> 3531
    //   4033: lload 19
    //   4035: lload 13
    //   4037: ldiv
    //   4038: lstore 17
    //   4040: goto +532 -> 4572
    //   4043: lload 23
    //   4045: lload 13
    //   4047: ldiv
    //   4048: lstore 13
    //   4050: goto -282 -> 3768
    //   4053: astore 32
    //   4055: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4058: ifeq -77 -> 3981
    //   4061: ldc 35
    //   4063: iconst_2
    //   4064: ldc_w 324
    //   4067: aload 32
    //   4069: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4072: goto -91 -> 3981
    //   4075: astore 31
    //   4077: iload 7
    //   4079: istore 6
    //   4081: iconst_0
    //   4082: istore 7
    //   4084: lload 25
    //   4086: lstore 19
    //   4088: goto -1046 -> 3042
    //   4091: astore 31
    //   4093: iconst_0
    //   4094: istore 7
    //   4096: goto -1054 -> 3042
    //   4099: astore 31
    //   4101: iconst_0
    //   4102: istore 9
    //   4104: iload 7
    //   4106: istore 8
    //   4108: iload 9
    //   4110: istore 7
    //   4112: goto -1070 -> 3042
    //   4115: astore 31
    //   4117: iconst_0
    //   4118: istore 9
    //   4120: iload 7
    //   4122: istore 8
    //   4124: iload 9
    //   4126: istore 7
    //   4128: goto -1086 -> 3042
    //   4131: astore 31
    //   4133: iconst_0
    //   4134: istore 9
    //   4136: iload 7
    //   4138: istore 8
    //   4140: iload 9
    //   4142: istore 7
    //   4144: goto -1102 -> 3042
    //   4147: astore 31
    //   4149: iconst_0
    //   4150: istore 9
    //   4152: iload 7
    //   4154: istore 8
    //   4156: iload 9
    //   4158: istore 7
    //   4160: goto -1118 -> 3042
    //   4163: astore 31
    //   4165: iload 7
    //   4167: istore 6
    //   4169: lload 19
    //   4171: lstore 21
    //   4173: iconst_0
    //   4174: istore 7
    //   4176: lload 25
    //   4178: lstore 19
    //   4180: goto -1138 -> 3042
    //   4183: astore 31
    //   4185: iload 7
    //   4187: istore 6
    //   4189: lload 19
    //   4191: lstore 21
    //   4193: iconst_0
    //   4194: istore 7
    //   4196: lload 25
    //   4198: lstore 19
    //   4200: goto -1158 -> 3042
    //   4203: astore 31
    //   4205: iload 6
    //   4207: istore 5
    //   4209: lload 19
    //   4211: lstore 21
    //   4213: iconst_0
    //   4214: istore 9
    //   4216: lload 25
    //   4218: lstore 19
    //   4220: iload 7
    //   4222: istore 6
    //   4224: iload 9
    //   4226: istore 7
    //   4228: goto -1186 -> 3042
    //   4231: astore 31
    //   4233: lload 19
    //   4235: lstore 25
    //   4237: iconst_1
    //   4238: istore 7
    //   4240: lload 21
    //   4242: lstore 19
    //   4244: lload 17
    //   4246: lstore 21
    //   4248: lload 25
    //   4250: lstore 17
    //   4252: goto -1210 -> 3042
    //   4255: astore 31
    //   4257: iload 7
    //   4259: istore 6
    //   4261: lload 17
    //   4263: lstore 19
    //   4265: lload 21
    //   4267: lstore 17
    //   4269: lload 25
    //   4271: lstore 21
    //   4273: goto -2110 -> 2163
    //   4276: astore 31
    //   4278: lload 21
    //   4280: lstore 25
    //   4282: lload 17
    //   4284: lstore 27
    //   4286: lload 19
    //   4288: lstore 21
    //   4290: lload 25
    //   4292: lstore 17
    //   4294: lload 27
    //   4296: lstore 19
    //   4298: goto -2135 -> 2163
    //   4301: astore 31
    //   4303: lload 21
    //   4305: lstore 25
    //   4307: lload 17
    //   4309: lstore 27
    //   4311: iload 7
    //   4313: istore 8
    //   4315: lload 19
    //   4317: lstore 21
    //   4319: lload 25
    //   4321: lstore 17
    //   4323: lload 27
    //   4325: lstore 19
    //   4327: goto -2164 -> 2163
    //   4330: astore 31
    //   4332: lload 21
    //   4334: lstore 25
    //   4336: lload 17
    //   4338: lstore 27
    //   4340: iload 7
    //   4342: istore 8
    //   4344: lload 19
    //   4346: lstore 21
    //   4348: lload 25
    //   4350: lstore 17
    //   4352: lload 27
    //   4354: lstore 19
    //   4356: goto -2193 -> 2163
    //   4359: astore 31
    //   4361: lload 21
    //   4363: lstore 25
    //   4365: lload 17
    //   4367: lstore 27
    //   4369: iload 7
    //   4371: istore 8
    //   4373: lload 19
    //   4375: lstore 21
    //   4377: lload 25
    //   4379: lstore 17
    //   4381: lload 27
    //   4383: lstore 19
    //   4385: goto -2222 -> 2163
    //   4388: astore 31
    //   4390: lload 17
    //   4392: lstore 25
    //   4394: lload 21
    //   4396: lstore 17
    //   4398: iload 7
    //   4400: istore 8
    //   4402: lload 19
    //   4404: lstore 21
    //   4406: lload 25
    //   4408: lstore 19
    //   4410: goto -2247 -> 2163
    //   4413: astore 31
    //   4415: iload 7
    //   4417: istore 6
    //   4419: lload 17
    //   4421: lstore 27
    //   4423: lload 19
    //   4425: lstore 17
    //   4427: lload 25
    //   4429: lstore 21
    //   4431: lload 27
    //   4433: lstore 19
    //   4435: goto -2272 -> 2163
    //   4438: astore 31
    //   4440: iload 7
    //   4442: istore 6
    //   4444: lload 17
    //   4446: lstore 27
    //   4448: lload 25
    //   4450: lstore 21
    //   4452: lload 19
    //   4454: lstore 17
    //   4456: lload 27
    //   4458: lstore 19
    //   4460: goto -2297 -> 2163
    //   4463: astore 31
    //   4465: iload 6
    //   4467: istore 5
    //   4469: lload 17
    //   4471: lstore 27
    //   4473: lload 25
    //   4475: lstore 21
    //   4477: iload 7
    //   4479: istore 6
    //   4481: lload 19
    //   4483: lstore 17
    //   4485: lload 27
    //   4487: lstore 19
    //   4489: goto -2326 -> 2163
    //   4492: iload 10
    //   4494: istore 8
    //   4496: goto -3469 -> 1027
    //   4499: goto -3817 -> 682
    //   4502: iload 8
    //   4504: ifle -3893 -> 611
    //   4507: iload 8
    //   4509: sipush 500
    //   4512: if_icmpge -3901 -> 611
    //   4515: iconst_1
    //   4516: istore 6
    //   4518: goto -4027 -> 491
    //   4521: iload 7
    //   4523: sipush 160
    //   4526: iadd
    //   4527: istore 7
    //   4529: goto -3809 -> 720
    //   4532: lload 17
    //   4534: l2i
    //   4535: istore 6
    //   4537: lload 13
    //   4539: lconst_0
    //   4540: lcmp
    //   4541: ifne -2424 -> 2117
    //   4544: ldc2_w 288
    //   4547: lstore 13
    //   4549: goto -2705 -> 1844
    //   4552: lload 19
    //   4554: l2i
    //   4555: istore 7
    //   4557: lload 13
    //   4559: lconst_0
    //   4560: lcmp
    //   4561: ifne -1578 -> 2983
    //   4564: ldc2_w 288
    //   4567: lstore 13
    //   4569: goto -1837 -> 2732
    //   4572: lload 17
    //   4574: l2i
    //   4575: istore 7
    //   4577: lload 13
    //   4579: lconst_0
    //   4580: lcmp
    //   4581: ifne -538 -> 4043
    //   4584: ldc2_w 288
    //   4587: lstore 13
    //   4589: goto -821 -> 3768
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4592	0	this	ktr
    //   41	3907	1	d1	double
    //   877	3	3	d2	double
    //   38	4430	5	i	int
    //   54	4482	6	j	int
    //   63	4513	7	k	int
    //   69	4444	8	m	int
    //   66	4159	9	n	int
    //   57	4436	10	i1	int
    //   167	863	11	i2	int
    //   190	522	12	i3	int
    //   51	4537	13	l1	long
    //   48	3886	15	l2	long
    //   35	4538	17	l3	long
    //   32	4521	19	l4	long
    //   632	3844	21	l5	long
    //   72	3972	23	l6	long
    //   60	4414	25	l7	long
    //   259	4227	27	l8	long
    //   45	3919	29	l9	long
    //   173	1877	31	localObject1	java.lang.Object
    //   2075	3	31	localThrowable1	java.lang.Throwable
    //   2085	15	31	localException1	java.lang.Exception
    //   2127	15	31	localException2	java.lang.Exception
    //   2149	123	31	localThrowable2	java.lang.Throwable
    //   2502	436	31	localObject2	java.lang.Object
    //   2963	3	31	localThrowable3	java.lang.Throwable
    //   2993	15	31	localException3	java.lang.Exception
    //   3015	984	31	localObject3	java.lang.Object
    //   4075	1	31	localObject4	java.lang.Object
    //   4091	1	31	localObject5	java.lang.Object
    //   4099	1	31	localObject6	java.lang.Object
    //   4115	1	31	localObject7	java.lang.Object
    //   4131	1	31	localObject8	java.lang.Object
    //   4147	1	31	localObject9	java.lang.Object
    //   4163	1	31	localObject10	java.lang.Object
    //   4183	1	31	localObject11	java.lang.Object
    //   4203	1	31	localObject12	java.lang.Object
    //   4231	1	31	localObject13	java.lang.Object
    //   4255	1	31	localThrowable4	java.lang.Throwable
    //   4276	1	31	localThrowable5	java.lang.Throwable
    //   4301	1	31	localThrowable6	java.lang.Throwable
    //   4330	1	31	localThrowable7	java.lang.Throwable
    //   4359	1	31	localThrowable8	java.lang.Throwable
    //   4388	1	31	localThrowable9	java.lang.Throwable
    //   4413	1	31	localThrowable10	java.lang.Throwable
    //   4438	1	31	localThrowable11	java.lang.Throwable
    //   4463	1	31	localThrowable12	java.lang.Throwable
    //   112	3862	32	localObject14	java.lang.Object
    //   4001	3	32	localThrowable13	java.lang.Throwable
    //   4011	15	32	localException4	java.lang.Exception
    //   4053	15	32	localException5	java.lang.Exception
    //   359	576	33	localObject15	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   1143	1150	2075	java/lang/Throwable
    //   1355	1607	2085	java/lang/Exception
    //   1607	1829	2127	java/lang/Exception
    //   1849	2057	2127	java/lang/Exception
    //   2107	2114	2127	java/lang/Exception
    //   2117	2124	2127	java/lang/Exception
    //   74	103	2149	java/lang/Throwable
    //   103	143	2149	java/lang/Throwable
    //   143	234	2149	java/lang/Throwable
    //   234	256	2149	java/lang/Throwable
    //   256	261	2149	java/lang/Throwable
    //   2296	2303	2963	java/lang/Throwable
    //   2495	2717	2993	java/lang/Exception
    //   2737	2945	2993	java/lang/Exception
    //   2973	2980	2993	java/lang/Exception
    //   2983	2990	2993	java/lang/Exception
    //   74	103	3015	finally
    //   103	143	3015	finally
    //   143	234	3015	finally
    //   234	256	3015	finally
    //   256	261	3015	finally
    //   3062	3069	4001	java/lang/Throwable
    //   3279	3531	4011	java/lang/Exception
    //   3531	3753	4053	java/lang/Exception
    //   3773	3981	4053	java/lang/Exception
    //   4033	4040	4053	java/lang/Exception
    //   4043	4050	4053	java/lang/Exception
    //   654	675	4075	finally
    //   682	709	4075	finally
    //   727	754	4091	finally
    //   754	782	4091	finally
    //   782	809	4091	finally
    //   812	850	4091	finally
    //   850	859	4099	finally
    //   872	878	4115	finally
    //   882	934	4131	finally
    //   934	939	4131	finally
    //   964	987	4147	finally
    //   991	1023	4147	finally
    //   290	297	4163	finally
    //   301	314	4163	finally
    //   342	361	4163	finally
    //   371	380	4163	finally
    //   384	426	4163	finally
    //   434	447	4163	finally
    //   456	488	4163	finally
    //   495	519	4163	finally
    //   1062	1123	4163	finally
    //   537	553	4183	finally
    //   553	579	4183	finally
    //   584	590	4203	finally
    //   2163	2201	4231	finally
    //   2201	2243	4231	finally
    //   2243	2267	4231	finally
    //   2267	2276	4231	finally
    //   654	675	4255	java/lang/Throwable
    //   682	709	4255	java/lang/Throwable
    //   727	754	4276	java/lang/Throwable
    //   754	782	4276	java/lang/Throwable
    //   782	809	4276	java/lang/Throwable
    //   812	850	4276	java/lang/Throwable
    //   850	859	4301	java/lang/Throwable
    //   872	878	4330	java/lang/Throwable
    //   882	934	4359	java/lang/Throwable
    //   934	939	4359	java/lang/Throwable
    //   964	987	4388	java/lang/Throwable
    //   991	1023	4388	java/lang/Throwable
    //   290	297	4413	java/lang/Throwable
    //   301	314	4413	java/lang/Throwable
    //   342	361	4413	java/lang/Throwable
    //   371	380	4413	java/lang/Throwable
    //   384	426	4413	java/lang/Throwable
    //   434	447	4413	java/lang/Throwable
    //   456	488	4413	java/lang/Throwable
    //   495	519	4413	java/lang/Throwable
    //   1062	1123	4413	java/lang/Throwable
    //   537	553	4438	java/lang/Throwable
    //   553	579	4438	java/lang/Throwable
    //   584	590	4463	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ktr
 * JD-Core Version:    0.7.0.1
 */