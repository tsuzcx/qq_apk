package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskScan
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskScan(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 0);
    paramTroopFileTransferManager.a(paramItem, 0);
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 37	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   19: getfield 43	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   22: ifnonnull +35 -> 57
    //   25: aload_0
    //   26: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   29: lconst_0
    //   30: putfield 47	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   33: aload_0
    //   34: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   37: ldc 49
    //   39: invokestatic 55	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   42: putfield 43	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   45: aload_0
    //   46: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   49: ldc 57
    //   51: invokestatic 55	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   54: putfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   57: new 62	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   65: getfield 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   68: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   76: aload_3
    //   77: invokevirtual 73	java/io/File:length	()J
    //   80: putfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   83: aload_0
    //   84: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   87: aload_0
    //   88: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   91: invokevirtual 79	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   94: aload_0
    //   95: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   98: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   101: ldc2_w 80
    //   104: lcmp
    //   105: ifle +39 -> 144
    //   108: aload_0
    //   109: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   112: aload_0
    //   113: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   116: iconst_3
    //   117: sipush 205
    //   120: invokevirtual 84	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   123: return
    //   124: astore_3
    //   125: aload_3
    //   126: invokevirtual 87	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   129: aload_0
    //   130: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   133: aload_0
    //   134: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   137: iconst_3
    //   138: bipush 102
    //   140: invokevirtual 84	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   143: return
    //   144: new 89	java/io/FileInputStream
    //   147: dup
    //   148: aload_3
    //   149: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   152: astore_3
    //   153: aload_3
    //   154: aload_0
    //   155: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   158: getfield 47	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   161: invokevirtual 96	java/io/FileInputStream:skip	(J)J
    //   164: pop2
    //   165: ldc 97
    //   167: newarray byte
    //   169: astore 4
    //   171: aload_3
    //   172: aload 4
    //   174: invokevirtual 101	java/io/FileInputStream:read	([B)I
    //   177: istore_1
    //   178: iload_1
    //   179: ifge +111 -> 290
    //   182: aload_3
    //   183: invokevirtual 104	java/io/FileInputStream:close	()V
    //   186: aload_0
    //   187: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   190: aload_0
    //   191: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   194: getfield 43	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   197: invokevirtual 108	java/security/MessageDigest:digest	()[B
    //   200: putfield 112	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   203: aload_0
    //   204: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   207: aload_0
    //   208: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   211: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   214: invokevirtual 108	java/security/MessageDigest:digest	()[B
    //   217: putfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   220: aload_0
    //   221: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   224: aconst_null
    //   225: putfield 43	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   228: aload_0
    //   229: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   232: aconst_null
    //   233: putfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   236: aload_0
    //   237: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   240: aload_0
    //   241: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   244: invokevirtual 37	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   247: ifne -233 -> 14
    //   250: aload_0
    //   251: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   254: aload_0
    //   255: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   258: invokevirtual 79	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   261: aload_0
    //   262: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   265: aload_0
    //   266: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   269: invokevirtual 117	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   272: return
    //   273: astore_3
    //   274: aload_0
    //   275: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   278: aload_0
    //   279: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   282: iconst_3
    //   283: sipush 201
    //   286: invokevirtual 84	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   289: return
    //   290: aload_0
    //   291: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   294: getfield 43	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   297: aload 4
    //   299: iconst_0
    //   300: iload_1
    //   301: invokevirtual 121	java/security/MessageDigest:update	([BII)V
    //   304: aload_0
    //   305: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   308: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   311: aload 4
    //   313: iconst_0
    //   314: iload_1
    //   315: invokevirtual 121	java/security/MessageDigest:update	([BII)V
    //   318: aload_0
    //   319: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   322: astore 5
    //   324: aload 5
    //   326: aload 5
    //   328: getfield 47	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   331: iload_1
    //   332: i2l
    //   333: ladd
    //   334: putfield 47	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   337: aload_0
    //   338: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   341: aload_0
    //   342: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   345: invokevirtual 37	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   348: istore_2
    //   349: iload_2
    //   350: ifeq -179 -> 171
    //   353: aload_3
    //   354: invokevirtual 104	java/io/FileInputStream:close	()V
    //   357: return
    //   358: astore_3
    //   359: aload_3
    //   360: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   363: return
    //   364: astore_3
    //   365: aload_3
    //   366: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   369: goto -183 -> 186
    //   372: astore 4
    //   374: aload 4
    //   376: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   379: aload_0
    //   380: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   383: aload_0
    //   384: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   387: iconst_3
    //   388: sipush 203
    //   391: invokevirtual 84	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   394: aload_3
    //   395: invokevirtual 104	java/io/FileInputStream:close	()V
    //   398: return
    //   399: astore_3
    //   400: aload_3
    //   401: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   404: return
    //   405: astore 4
    //   407: aload_3
    //   408: invokevirtual 104	java/io/FileInputStream:close	()V
    //   411: aload 4
    //   413: athrow
    //   414: astore_3
    //   415: aload_3
    //   416: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   419: goto -8 -> 411
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	TaskScan
    //   177	155	1	i	int
    //   348	2	2	bool	boolean
    //   71	6	3	localFile	java.io.File
    //   124	25	3	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   152	31	3	localFileInputStream	java.io.FileInputStream
    //   273	81	3	localFileNotFoundException	java.io.FileNotFoundException
    //   358	2	3	localIOException1	java.io.IOException
    //   364	31	3	localIOException2	java.io.IOException
    //   399	9	3	localIOException3	java.io.IOException
    //   414	2	3	localIOException4	java.io.IOException
    //   169	143	4	arrayOfByte	byte[]
    //   372	3	4	localIOException5	java.io.IOException
    //   405	7	4	localObject	java.lang.Object
    //   322	5	5	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   33	57	124	java/security/NoSuchAlgorithmException
    //   144	153	273	java/io/FileNotFoundException
    //   353	357	358	java/io/IOException
    //   182	186	364	java/io/IOException
    //   153	171	372	java/io/IOException
    //   171	178	372	java/io/IOException
    //   290	349	372	java/io/IOException
    //   394	398	399	java/io/IOException
    //   153	171	405	finally
    //   171	178	405	finally
    //   290	349	405	finally
    //   374	394	405	finally
    //   407	411	414	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskScan
 * JD-Core Version:    0.7.0.1
 */