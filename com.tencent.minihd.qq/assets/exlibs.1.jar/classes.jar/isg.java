import com.tencent.mobileqq.filemanager.core.OfflineSendWorker;

public class isg
  implements Runnable
{
  public isg(OfflineSendWorker paramOfflineSendWorker, String paramString, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 43	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara
    //   8: dup
    //   9: invokespecial 44	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: aload_0
    //   17: getfield 20	isg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: putfield 45	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: aload 5
    //   25: aload_0
    //   26: getfield 22	isg:jdField_a_of_type_Long	J
    //   29: putfield 46	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:jdField_a_of_type_Long	J
    //   32: aload 5
    //   34: aload_0
    //   35: getfield 24	isg:jdField_a_of_type_ArrayOfByte	[B
    //   38: putfield 47	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:c	[B
    //   41: aload 5
    //   43: aload_0
    //   44: getfield 26	isg:b	[B
    //   47: putfield 50	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:e	[B
    //   50: aload 5
    //   52: aload_0
    //   53: getfield 28	isg:c	[B
    //   56: putfield 51	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:b	[B
    //   59: aload 5
    //   61: aload_0
    //   62: getfield 30	isg:d	[B
    //   65: putfield 52	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:jdField_a_of_type_ArrayOfByte	[B
    //   68: new 54	java/io/BufferedInputStream
    //   71: dup
    //   72: new 56	java/io/FileInputStream
    //   75: dup
    //   76: new 58	java/lang/String
    //   79: dup
    //   80: aload_0
    //   81: getfield 30	isg:d	[B
    //   84: invokespecial 61	java/lang/String:<init>	([B)V
    //   87: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   90: invokespecial 67	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: astore_2
    //   94: sipush 10240
    //   97: newarray byte
    //   99: astore 6
    //   101: ldc 69
    //   103: invokestatic 75	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   106: astore 4
    //   108: aload 4
    //   110: astore_3
    //   111: aload_0
    //   112: getfield 18	isg:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   115: invokestatic 80	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Z
    //   118: ifne +57 -> 175
    //   121: aload_2
    //   122: aload 6
    //   124: invokevirtual 86	java/io/InputStream:read	([B)I
    //   127: istore_1
    //   128: iload_1
    //   129: ifle +46 -> 175
    //   132: aload_3
    //   133: aload 6
    //   135: iconst_0
    //   136: iload_1
    //   137: invokevirtual 90	java/security/MessageDigest:update	([BII)V
    //   140: goto -29 -> 111
    //   143: astore_3
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 93	java/io/InputStream:close	()V
    //   152: return
    //   153: astore 4
    //   155: aload 4
    //   157: invokevirtual 96	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   160: goto -49 -> 111
    //   163: astore_3
    //   164: aload_2
    //   165: ifnull -13 -> 152
    //   168: aload_2
    //   169: invokevirtual 93	java/io/InputStream:close	()V
    //   172: return
    //   173: astore_2
    //   174: return
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 93	java/io/InputStream:close	()V
    //   183: aload_0
    //   184: getfield 18	isg:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   187: invokestatic 80	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Z
    //   190: ifne +16 -> 206
    //   193: aload_3
    //   194: ifnull +12 -> 206
    //   197: aload 5
    //   199: aload_3
    //   200: invokevirtual 100	java/security/MessageDigest:digest	()[B
    //   203: putfield 101	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara:d	[B
    //   206: aload_0
    //   207: getfield 18	isg:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   210: invokestatic 80	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Z
    //   213: ifne +32 -> 245
    //   216: aload_0
    //   217: getfield 18	isg:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   220: invokestatic 104	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   223: invokevirtual 109	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   226: aload 5
    //   228: aload_0
    //   229: getfield 18	isg:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   232: invokestatic 112	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;
    //   235: aload_0
    //   236: getfield 18	isg:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker	Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;
    //   239: invokestatic 115	com/tencent/mobileqq/filemanager/core/OfflineSendWorker:a	(Lcom/tencent/mobileqq/filemanager/core/OfflineSendWorker;)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   242: invokevirtual 120	com/tencent/mobileqq/filemanager/app/FileTransferHandler:b	(Lcom/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploadPara;Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   245: aload_2
    //   246: ifnull -94 -> 152
    //   249: aload_2
    //   250: invokevirtual 93	java/io/InputStream:close	()V
    //   253: return
    //   254: astore_2
    //   255: return
    //   256: astore_3
    //   257: aconst_null
    //   258: astore_2
    //   259: aload_2
    //   260: ifnull +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 93	java/io/InputStream:close	()V
    //   267: aload_3
    //   268: athrow
    //   269: astore 4
    //   271: goto -88 -> 183
    //   274: astore_2
    //   275: return
    //   276: astore_2
    //   277: goto -10 -> 267
    //   280: astore_3
    //   281: goto -22 -> 259
    //   284: astore_2
    //   285: aconst_null
    //   286: astore_2
    //   287: goto -123 -> 164
    //   290: astore_2
    //   291: aload 4
    //   293: astore_2
    //   294: goto -150 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	isg
    //   127	10	1	i	int
    //   93	76	2	localBufferedInputStream	java.io.BufferedInputStream
    //   173	77	2	localIOException1	java.io.IOException
    //   254	1	2	localIOException2	java.io.IOException
    //   258	6	2	localObject1	Object
    //   274	1	2	localIOException3	java.io.IOException
    //   276	1	2	localIOException4	java.io.IOException
    //   284	1	2	localIOException5	java.io.IOException
    //   286	1	2	localObject2	Object
    //   290	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   293	1	2	localIOException6	java.io.IOException
    //   4	129	3	localMessageDigest1	java.security.MessageDigest
    //   143	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   163	37	3	localIOException7	java.io.IOException
    //   256	12	3	localObject3	Object
    //   280	1	3	localObject4	Object
    //   1	108	4	localMessageDigest2	java.security.MessageDigest
    //   153	3	4	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   269	23	4	localIOException8	java.io.IOException
    //   12	215	5	localOfflineFileUploadPara	com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara
    //   99	35	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   94	101	143	java/io/FileNotFoundException
    //   101	108	143	java/io/FileNotFoundException
    //   111	128	143	java/io/FileNotFoundException
    //   132	140	143	java/io/FileNotFoundException
    //   155	160	143	java/io/FileNotFoundException
    //   179	183	143	java/io/FileNotFoundException
    //   183	193	143	java/io/FileNotFoundException
    //   197	206	143	java/io/FileNotFoundException
    //   206	245	143	java/io/FileNotFoundException
    //   101	108	153	java/security/NoSuchAlgorithmException
    //   94	101	163	java/io/IOException
    //   101	108	163	java/io/IOException
    //   111	128	163	java/io/IOException
    //   132	140	163	java/io/IOException
    //   155	160	163	java/io/IOException
    //   183	193	163	java/io/IOException
    //   197	206	163	java/io/IOException
    //   206	245	163	java/io/IOException
    //   168	172	173	java/io/IOException
    //   249	253	254	java/io/IOException
    //   68	94	256	finally
    //   179	183	269	java/io/IOException
    //   148	152	274	java/io/IOException
    //   263	267	276	java/io/IOException
    //   94	101	280	finally
    //   101	108	280	finally
    //   111	128	280	finally
    //   132	140	280	finally
    //   155	160	280	finally
    //   179	183	280	finally
    //   183	193	280	finally
    //   197	206	280	finally
    //   206	245	280	finally
    //   68	94	284	java/io/IOException
    //   68	94	290	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     isg
 * JD-Core Version:    0.7.0.1
 */