import com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.VkeyNet;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;

public class hdg
  implements OnResultListener
{
  public hdg(VkeyNet paramVkeyNet) {}
  
  public void a(int paramInt, String paramString) {}
  
  /* Error */
  public void a(com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse paramCommonResponse)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore_2
    //   14: aload_0
    //   15: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   18: invokestatic 29	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:a	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;)Ljava/lang/Object;
    //   21: astore 9
    //   23: aload 9
    //   25: monitorenter
    //   26: aload_1
    //   27: ifnonnull +14 -> 41
    //   30: ldc 31
    //   32: ldc 33
    //   34: invokestatic 39	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload 9
    //   39: monitorexit
    //   40: return
    //   41: aload_1
    //   42: invokevirtual 44	com/tencent/mobileqq/activity/widget/qqmusic/network/response/CommonResponse:a	()Lcom/tencent/mobileqq/activity/widget/qqmusic/data/BaseInfo;
    //   45: checkcast 46	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyResponse
    //   48: invokevirtual 49	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyResponse:a	()[B
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +468 -> 521
    //   56: aload_3
    //   57: arraylength
    //   58: ifle +463 -> 521
    //   61: ldc 51
    //   63: new 53	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   70: ldc 56
    //   72: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: new 62	java/lang/String
    //   78: dup
    //   79: aload_3
    //   80: invokespecial 65	java/lang/String:<init>	([B)V
    //   83: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 72	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: new 74	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom
    //   95: dup
    //   96: aload_0
    //   97: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   100: invokestatic 77	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:a	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;)Ljava/lang/String;
    //   103: invokespecial 80	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:<init>	(Ljava/lang/String;)V
    //   106: astore_1
    //   107: new 82	java/io/ByteArrayInputStream
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 83	java/io/ByteArrayInputStream:<init>	([B)V
    //   115: astore 5
    //   117: aload 5
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   124: aload_1
    //   125: aload 5
    //   127: invokeinterface 88 2 0
    //   132: invokestatic 91	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:a	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/ExpressInfo;)Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/ExpressInfo;
    //   135: pop
    //   136: aload 5
    //   138: astore_3
    //   139: aload_0
    //   140: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   143: invokestatic 94	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:a	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;)Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/ExpressInfo;
    //   146: ifnull +366 -> 512
    //   149: aload 5
    //   151: astore_3
    //   152: aload_0
    //   153: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   156: invokestatic 94	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:a	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;)Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/ExpressInfo;
    //   159: getfield 99	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/ExpressInfo:d	Ljava/lang/String;
    //   162: astore_2
    //   163: aload 5
    //   165: astore_3
    //   166: aload 7
    //   168: astore 6
    //   170: aload_2
    //   171: astore 4
    //   173: aload_2
    //   174: astore 7
    //   176: aload_0
    //   177: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   180: invokestatic 94	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:a	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;)Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/ExpressInfo;
    //   183: getfield 101	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/ExpressInfo:a	Ljava/lang/String;
    //   186: astore_1
    //   187: aload 5
    //   189: astore_3
    //   190: aload_1
    //   191: astore 6
    //   193: aload_2
    //   194: astore 4
    //   196: aload_1
    //   197: astore 8
    //   199: aload_2
    //   200: astore 7
    //   202: aload_0
    //   203: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   206: iconst_m1
    //   207: invokestatic 104	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:a	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;I)I
    //   210: pop
    //   211: aload_1
    //   212: astore 4
    //   214: aload_2
    //   215: astore_3
    //   216: aload 5
    //   218: ifnull +286 -> 504
    //   221: aload 5
    //   223: invokevirtual 109	java/io/InputStream:close	()V
    //   226: aload_2
    //   227: invokestatic 114	com/tencent/mobileqq/activity/widget/qqmusic/utils/MusicUtil:a	(Ljava/lang/String;)Z
    //   230: ifne +210 -> 440
    //   233: aload_0
    //   234: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   237: aload_2
    //   238: invokestatic 117	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:a	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;Ljava/lang/String;)Ljava/lang/String;
    //   241: pop
    //   242: aload_0
    //   243: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   246: invokestatic 120	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:a	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;)Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyPair;
    //   249: aload_2
    //   250: invokevirtual 124	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyPair:a	(Ljava/lang/String;)V
    //   253: ldc 126
    //   255: new 53	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   262: ldc 128
    //   264: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   271: invokestatic 131	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:b	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;)Ljava/lang/String;
    //   274: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 72	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_1
    //   284: astore_2
    //   285: aload_1
    //   286: ifnonnull +6 -> 292
    //   289: ldc 133
    //   291: astore_2
    //   292: aload_0
    //   293: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   296: aload_2
    //   297: invokestatic 135	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:b	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;Ljava/lang/String;)Ljava/lang/String;
    //   300: pop
    //   301: aload 9
    //   303: monitorexit
    //   304: return
    //   305: astore_1
    //   306: aload 9
    //   308: monitorexit
    //   309: aload_1
    //   310: athrow
    //   311: astore_3
    //   312: ldc 31
    //   314: aload_3
    //   315: invokestatic 138	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   318: goto -92 -> 226
    //   321: astore 4
    //   323: aconst_null
    //   324: astore 5
    //   326: aconst_null
    //   327: astore_2
    //   328: aload 6
    //   330: astore_1
    //   331: aload 5
    //   333: astore_3
    //   334: ldc 31
    //   336: aload 4
    //   338: invokestatic 138	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   341: aload_1
    //   342: astore 4
    //   344: aload_2
    //   345: astore_3
    //   346: aload 5
    //   348: ifnull +156 -> 504
    //   351: aload 5
    //   353: invokevirtual 109	java/io/InputStream:close	()V
    //   356: goto -130 -> 226
    //   359: astore_3
    //   360: ldc 31
    //   362: aload_3
    //   363: invokestatic 138	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   366: goto -140 -> 226
    //   369: astore 7
    //   371: aconst_null
    //   372: astore 5
    //   374: aconst_null
    //   375: astore_2
    //   376: aload 4
    //   378: astore_1
    //   379: aload 5
    //   381: astore_3
    //   382: ldc 31
    //   384: aload 7
    //   386: invokestatic 141	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/Error;)V
    //   389: aload_1
    //   390: astore 4
    //   392: aload_2
    //   393: astore_3
    //   394: aload 5
    //   396: ifnull +108 -> 504
    //   399: aload 5
    //   401: invokevirtual 109	java/io/InputStream:close	()V
    //   404: goto -178 -> 226
    //   407: astore_3
    //   408: ldc 31
    //   410: aload_3
    //   411: invokestatic 138	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   414: goto -188 -> 226
    //   417: astore_1
    //   418: aconst_null
    //   419: astore_3
    //   420: aload_3
    //   421: ifnull +7 -> 428
    //   424: aload_3
    //   425: invokevirtual 109	java/io/InputStream:close	()V
    //   428: aload_1
    //   429: athrow
    //   430: astore_2
    //   431: ldc 31
    //   433: aload_2
    //   434: invokestatic 138	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   437: goto -9 -> 428
    //   440: aload_0
    //   441: getfield 12	hdg:a	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;
    //   444: invokestatic 144	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet:a	(Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/VkeyNet;)Landroid/os/Handler;
    //   447: iconst_0
    //   448: ldc2_w 145
    //   451: invokevirtual 152	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   454: pop
    //   455: goto -154 -> 301
    //   458: astore_1
    //   459: goto -39 -> 420
    //   462: astore 7
    //   464: aconst_null
    //   465: astore_2
    //   466: aload 4
    //   468: astore_1
    //   469: goto -90 -> 379
    //   472: astore 7
    //   474: aload 6
    //   476: astore_1
    //   477: aload 4
    //   479: astore_2
    //   480: goto -101 -> 379
    //   483: astore 4
    //   485: aconst_null
    //   486: astore_2
    //   487: aload 6
    //   489: astore_1
    //   490: goto -159 -> 331
    //   493: astore 4
    //   495: aload 8
    //   497: astore_1
    //   498: aload 7
    //   500: astore_2
    //   501: goto -170 -> 331
    //   504: aload 4
    //   506: astore_1
    //   507: aload_3
    //   508: astore_2
    //   509: goto -283 -> 226
    //   512: aconst_null
    //   513: astore_3
    //   514: aload_2
    //   515: astore_1
    //   516: aload_3
    //   517: astore_2
    //   518: goto -331 -> 187
    //   521: aconst_null
    //   522: astore_1
    //   523: aconst_null
    //   524: astore_2
    //   525: goto -299 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	hdg
    //   0	528	1	paramCommonResponse	com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse
    //   13	380	2	localObject1	Object
    //   430	4	2	localIOException1	java.io.IOException
    //   465	60	2	localObject2	Object
    //   51	165	3	localObject3	Object
    //   311	4	3	localIOException2	java.io.IOException
    //   333	13	3	localObject4	Object
    //   359	4	3	localIOException3	java.io.IOException
    //   381	13	3	localObject5	Object
    //   407	4	3	localIOException4	java.io.IOException
    //   419	98	3	localObject6	Object
    //   4	209	4	localObject7	Object
    //   321	16	4	localException1	java.lang.Exception
    //   342	136	4	localCommonResponse1	com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse
    //   483	1	4	localException2	java.lang.Exception
    //   493	12	4	localException3	java.lang.Exception
    //   115	285	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   1	487	6	localObject8	Object
    //   7	194	7	localObject9	Object
    //   369	16	7	localError1	java.lang.Error
    //   462	1	7	localError2	java.lang.Error
    //   472	27	7	localError3	java.lang.Error
    //   10	486	8	localCommonResponse2	com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse
    //   21	286	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   30	40	305	finally
    //   41	52	305	finally
    //   56	92	305	finally
    //   221	226	305	finally
    //   226	283	305	finally
    //   292	301	305	finally
    //   301	304	305	finally
    //   306	309	305	finally
    //   312	318	305	finally
    //   351	356	305	finally
    //   360	366	305	finally
    //   399	404	305	finally
    //   408	414	305	finally
    //   424	428	305	finally
    //   428	430	305	finally
    //   431	437	305	finally
    //   440	455	305	finally
    //   221	226	311	java/io/IOException
    //   92	117	321	java/lang/Exception
    //   351	356	359	java/io/IOException
    //   92	117	369	java/lang/Error
    //   399	404	407	java/io/IOException
    //   92	117	417	finally
    //   424	428	430	java/io/IOException
    //   120	136	458	finally
    //   139	149	458	finally
    //   152	163	458	finally
    //   176	187	458	finally
    //   202	211	458	finally
    //   334	341	458	finally
    //   382	389	458	finally
    //   120	136	462	java/lang/Error
    //   139	149	462	java/lang/Error
    //   152	163	462	java/lang/Error
    //   176	187	472	java/lang/Error
    //   202	211	472	java/lang/Error
    //   120	136	483	java/lang/Exception
    //   139	149	483	java/lang/Exception
    //   152	163	483	java/lang/Exception
    //   176	187	493	java/lang/Exception
    //   202	211	493	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdg
 * JD-Core Version:    0.7.0.1
 */