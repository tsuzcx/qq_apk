package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

public class TroopFileTransferManager$TaskHttpUpload
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskHttpUpload(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 2);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private HttpResponse a(HttpClient paramHttpClient, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramHttpClient == null) || (paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    paramString = new HttpPost(paramString);
    paramString.setHeader("User-Agent", "TroopFile");
    paramString.setHeader("Content-Type", "text/octet");
    paramString.setHeader("Connection", "keep-alive");
    if (NetworkUtil.g(BaseApplication.getContext())) {
      paramString.setHeader("Net-type", "Wifi");
    }
    for (;;)
    {
      paramString.setEntity(new ByteArrayEntity(paramArrayOfByte));
      try
      {
        paramHttpClient = paramHttpClient.execute(paramString);
        return paramHttpClient;
      }
      catch (ClientProtocolException paramHttpClient)
      {
        paramHttpClient.printStackTrace();
        return null;
      }
      catch (IOException paramHttpClient)
      {
        paramHttpClient.printStackTrace();
      }
      paramString.setHeader("Net-type", "gprs");
    }
    return null;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: new 101	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   23: getfield 107	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   26: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 12
    //   31: aload_0
    //   32: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   35: iconst_0
    //   36: putfield 112	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   39: aload_0
    //   40: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   43: invokevirtual 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   46: ifnull +1627 -> 1673
    //   49: aload_0
    //   50: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   53: invokevirtual 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   56: iconst_5
    //   57: invokeinterface 121 2 0
    //   62: astore 10
    //   64: iconst_0
    //   65: istore_1
    //   66: sipush 1024
    //   69: istore_2
    //   70: iload_1
    //   71: istore_3
    //   72: iload_1
    //   73: iconst_3
    //   74: if_icmpgt +227 -> 301
    //   77: iload_1
    //   78: ifle +117 -> 195
    //   81: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   84: invokestatic 124	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   87: ifne +54 -> 141
    //   90: aload_0
    //   91: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   94: aload_0
    //   95: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   98: iconst_3
    //   99: bipush 106
    //   101: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   104: return
    //   105: astore 9
    //   107: invokestatic 133	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   110: ifeq +11 -> 121
    //   113: ldc 135
    //   115: iconst_4
    //   116: ldc 137
    //   118: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload 9
    //   123: invokevirtual 142	java/lang/InterruptedException:printStackTrace	()V
    //   126: aload_0
    //   127: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   130: aload_0
    //   131: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   134: iconst_3
    //   135: bipush 102
    //   137: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   140: return
    //   141: iconst_0
    //   142: istore_3
    //   143: iload_3
    //   144: iload_1
    //   145: bipush 100
    //   147: imul
    //   148: if_icmpge +47 -> 195
    //   151: ldc2_w 143
    //   154: invokestatic 150	java/lang/Thread:sleep	(J)V
    //   157: aload_0
    //   158: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   161: aload_0
    //   162: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   165: invokevirtual 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   168: ifne -154 -> 14
    //   171: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   174: invokestatic 124	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   177: ifne +1502 -> 1679
    //   180: aload_0
    //   181: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   184: aload_0
    //   185: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   188: iconst_3
    //   189: bipush 106
    //   191: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   194: return
    //   195: aload_0
    //   196: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   199: aload_0
    //   200: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   203: invokevirtual 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   206: ifne -192 -> 14
    //   209: aload 12
    //   211: invokevirtual 154	java/io/File:length	()J
    //   214: aload_0
    //   215: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   218: getfield 158	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   221: lcmp
    //   222: ifeq +19 -> 241
    //   225: aload_0
    //   226: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   229: aload_0
    //   230: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   233: iconst_3
    //   234: sipush 206
    //   237: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   240: return
    //   241: iload_1
    //   242: iconst_1
    //   243: iadd
    //   244: istore_1
    //   245: aload_0
    //   246: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   249: iload_1
    //   250: putfield 112	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   253: iload_2
    //   254: newarray byte
    //   256: astore 13
    //   258: new 160	java/io/FileInputStream
    //   261: dup
    //   262: aload 12
    //   264: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   267: astore 9
    //   269: aload 9
    //   271: aload_0
    //   272: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   275: getfield 166	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   278: invokevirtual 170	java/io/FileInputStream:skip	(J)J
    //   281: pop2
    //   282: aload 9
    //   284: aload 13
    //   286: invokevirtual 174	java/io/FileInputStream:read	([B)I
    //   289: istore_2
    //   290: aload 9
    //   292: invokevirtual 177	java/io/FileInputStream:close	()V
    //   295: iload_2
    //   296: ifge +162 -> 458
    //   299: iload_1
    //   300: istore_3
    //   301: iload_3
    //   302: iconst_3
    //   303: if_icmple +1271 -> 1574
    //   306: aload_0
    //   307: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   310: aload_0
    //   311: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   314: iconst_3
    //   315: bipush 105
    //   317: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   320: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +34 -> 357
    //   326: ldc 135
    //   328: iconst_2
    //   329: new 182	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   336: ldc 186
    //   338: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_0
    //   342: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   345: getfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   348: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload_0
    //   358: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   361: aconst_null
    //   362: putfield 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   365: aload_0
    //   366: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   369: aconst_null
    //   370: putfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   373: return
    //   374: astore 9
    //   376: aload_0
    //   377: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   380: aload_0
    //   381: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   384: iconst_3
    //   385: sipush 201
    //   388: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   391: return
    //   392: astore 9
    //   394: aload 9
    //   396: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   399: goto -104 -> 295
    //   402: astore 10
    //   404: aload 10
    //   406: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   409: aload_0
    //   410: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   413: aload_0
    //   414: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   417: iconst_3
    //   418: sipush 203
    //   421: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   424: aload 9
    //   426: invokevirtual 177	java/io/FileInputStream:close	()V
    //   429: return
    //   430: astore 9
    //   432: aload 9
    //   434: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   437: return
    //   438: astore 10
    //   440: aload 9
    //   442: invokevirtual 177	java/io/FileInputStream:close	()V
    //   445: aload 10
    //   447: athrow
    //   448: astore 9
    //   450: aload 9
    //   452: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   455: goto -10 -> 445
    //   458: aload_0
    //   459: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   462: getfield 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   465: arraylength
    //   466: iconst_2
    //   467: iadd
    //   468: iconst_2
    //   469: iadd
    //   470: aload_0
    //   471: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   474: getfield 204	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   477: arraylength
    //   478: iadd
    //   479: bipush 20
    //   481: iadd
    //   482: iload_2
    //   483: iadd
    //   484: istore_3
    //   485: new 206	java/io/ByteArrayOutputStream
    //   488: dup
    //   489: iload_3
    //   490: bipush 16
    //   492: iadd
    //   493: invokespecial 209	java/io/ByteArrayOutputStream:<init>	(I)V
    //   496: astore 9
    //   498: new 211	java/io/DataOutputStream
    //   501: dup
    //   502: aload 9
    //   504: invokespecial 214	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   507: astore 11
    //   509: aload 11
    //   511: ldc 215
    //   513: invokevirtual 218	java/io/DataOutputStream:writeInt	(I)V
    //   516: aload 11
    //   518: sipush 1007
    //   521: invokevirtual 218	java/io/DataOutputStream:writeInt	(I)V
    //   524: aload 11
    //   526: iconst_0
    //   527: invokevirtual 218	java/io/DataOutputStream:writeInt	(I)V
    //   530: aload 11
    //   532: iload_3
    //   533: invokevirtual 218	java/io/DataOutputStream:writeInt	(I)V
    //   536: aload 11
    //   538: aload_0
    //   539: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   542: getfield 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   545: arraylength
    //   546: invokevirtual 221	java/io/DataOutputStream:writeShort	(I)V
    //   549: aload 11
    //   551: aload_0
    //   552: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   555: getfield 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   558: invokevirtual 224	java/io/DataOutputStream:write	([B)V
    //   561: aload 11
    //   563: aload_0
    //   564: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   567: getfield 204	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   570: arraylength
    //   571: invokevirtual 221	java/io/DataOutputStream:writeShort	(I)V
    //   574: aload 11
    //   576: aload_0
    //   577: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   580: getfield 204	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   583: invokevirtual 224	java/io/DataOutputStream:write	([B)V
    //   586: aload 11
    //   588: aload_0
    //   589: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   592: getfield 158	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   595: ldc2_w 225
    //   598: land
    //   599: l2i
    //   600: invokevirtual 218	java/io/DataOutputStream:writeInt	(I)V
    //   603: aload 11
    //   605: aload_0
    //   606: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   609: getfield 166	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   612: ldc2_w 225
    //   615: land
    //   616: l2i
    //   617: invokevirtual 218	java/io/DataOutputStream:writeInt	(I)V
    //   620: aload 11
    //   622: iload_2
    //   623: invokevirtual 218	java/io/DataOutputStream:writeInt	(I)V
    //   626: aload 11
    //   628: aload_0
    //   629: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   632: getfield 158	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   635: bipush 32
    //   637: lshr
    //   638: l2i
    //   639: invokevirtual 218	java/io/DataOutputStream:writeInt	(I)V
    //   642: aload 11
    //   644: aload_0
    //   645: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   648: getfield 166	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   651: bipush 32
    //   653: lshr
    //   654: l2i
    //   655: invokevirtual 218	java/io/DataOutputStream:writeInt	(I)V
    //   658: aload 11
    //   660: aload 13
    //   662: iconst_0
    //   663: iload_2
    //   664: invokevirtual 229	java/io/DataOutputStream:write	([BII)V
    //   667: aload 9
    //   669: invokevirtual 233	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   672: astore 13
    //   674: aload 9
    //   676: invokevirtual 234	java/io/ByteArrayOutputStream:close	()V
    //   679: aload 11
    //   681: invokevirtual 235	java/io/DataOutputStream:close	()V
    //   684: aconst_null
    //   685: astore 9
    //   687: aconst_null
    //   688: astore 11
    //   690: aload 10
    //   692: ifnull +212 -> 904
    //   695: aload 11
    //   697: astore 9
    //   699: aload 10
    //   701: invokeinterface 241 1 0
    //   706: ifle +198 -> 904
    //   709: aload 10
    //   711: iconst_0
    //   712: invokeinterface 245 2 0
    //   717: checkcast 247	mqq/manager/ProxyIpManager$ProxyIp
    //   720: astore 11
    //   722: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq +37 -> 762
    //   728: ldc 135
    //   730: iconst_2
    //   731: ldc 249
    //   733: iconst_2
    //   734: anewarray 251	java/lang/Object
    //   737: dup
    //   738: iconst_0
    //   739: aload 11
    //   741: getfield 254	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   744: aastore
    //   745: dup
    //   746: iconst_1
    //   747: aload 11
    //   749: getfield 257	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   752: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   755: aastore
    //   756: invokestatic 269	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   759: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: ldc_w 271
    //   765: iconst_5
    //   766: anewarray 251	java/lang/Object
    //   769: dup
    //   770: iconst_0
    //   771: aload 11
    //   773: getfield 254	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   776: aastore
    //   777: dup
    //   778: iconst_1
    //   779: aload_0
    //   780: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   783: getfield 166	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   786: invokestatic 276	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   789: aastore
    //   790: dup
    //   791: iconst_2
    //   792: aload_0
    //   793: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   796: getfield 166	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   799: iload_2
    //   800: i2l
    //   801: ladd
    //   802: invokestatic 276	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   805: aastore
    //   806: dup
    //   807: iconst_3
    //   808: aload_0
    //   809: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   812: getfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   815: aastore
    //   816: dup
    //   817: iconst_4
    //   818: bipush 80
    //   820: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   823: aastore
    //   824: invokestatic 269	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   827: astore 9
    //   829: iconst_0
    //   830: aload 11
    //   832: getfield 257	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   835: sipush 10000
    //   838: sipush 20000
    //   841: invokestatic 281	com/dataline/util/HttpUtil:a	(ZIII)Lorg/apache/http/client/HttpClient;
    //   844: astore 14
    //   846: aload_0
    //   847: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   850: invokestatic 286	java/lang/System:currentTimeMillis	()J
    //   853: putfield 289	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   856: aload_0
    //   857: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   860: aload 9
    //   862: putfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:uploadUrl	Ljava/lang/String;
    //   865: aload_0
    //   866: aload 14
    //   868: aload 9
    //   870: aload 13
    //   872: invokespecial 294	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:a	(Lorg/apache/http/client/HttpClient;Ljava/lang/String;[B)Lorg/apache/http/HttpResponse;
    //   875: astore 9
    //   877: aload 9
    //   879: ifnull +201 -> 1080
    //   882: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   885: ifeq +785 -> 1670
    //   888: ldc 135
    //   890: iconst_2
    //   891: ldc_w 296
    //   894: iconst_0
    //   895: anewarray 251	java/lang/Object
    //   898: invokestatic 269	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   901: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: aload 9
    //   906: astore 11
    //   908: aload 9
    //   910: ifnonnull +253 -> 1163
    //   913: invokestatic 299	com/dataline/util/HttpUtil:a	()Lcom/dataline/util/HttpUtil$NetworkProxy;
    //   916: ifnull +770 -> 1686
    //   919: iconst_1
    //   920: istore 4
    //   922: iconst_0
    //   923: iload 4
    //   925: sipush 10000
    //   928: sipush 20000
    //   931: invokestatic 302	com/dataline/util/HttpUtil:a	(ZZII)Lorg/apache/http/client/HttpClient;
    //   934: astore 9
    //   936: ldc_w 304
    //   939: iconst_3
    //   940: anewarray 251	java/lang/Object
    //   943: dup
    //   944: iconst_0
    //   945: aload_0
    //   946: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   949: getfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   952: aastore
    //   953: dup
    //   954: iconst_1
    //   955: aload_0
    //   956: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   959: getfield 166	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   962: invokestatic 276	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   965: aastore
    //   966: dup
    //   967: iconst_2
    //   968: aload_0
    //   969: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   972: getfield 166	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   975: iload_2
    //   976: i2l
    //   977: ladd
    //   978: invokestatic 276	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   981: aastore
    //   982: invokestatic 269	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   985: astore 11
    //   987: aload_0
    //   988: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   991: invokestatic 286	java/lang/System:currentTimeMillis	()J
    //   994: putfield 289	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   997: aload_0
    //   998: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1001: aload 11
    //   1003: putfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:uploadUrl	Ljava/lang/String;
    //   1006: aload_0
    //   1007: aload 9
    //   1009: aload 11
    //   1011: aload 13
    //   1013: invokespecial 294	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:a	(Lorg/apache/http/client/HttpClient;Ljava/lang/String;[B)Lorg/apache/http/HttpResponse;
    //   1016: astore 9
    //   1018: aload 9
    //   1020: ifnonnull +113 -> 1133
    //   1023: sipush 16384
    //   1026: istore_2
    //   1027: goto -957 -> 70
    //   1030: astore 10
    //   1032: aload 10
    //   1034: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   1037: aload_0
    //   1038: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1041: aload_0
    //   1042: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1045: iconst_3
    //   1046: bipush 102
    //   1048: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1051: aload 9
    //   1053: invokevirtual 234	java/io/ByteArrayOutputStream:close	()V
    //   1056: aload 11
    //   1058: invokevirtual 235	java/io/DataOutputStream:close	()V
    //   1061: return
    //   1062: astore 9
    //   1064: return
    //   1065: astore 10
    //   1067: aload 9
    //   1069: invokevirtual 234	java/io/ByteArrayOutputStream:close	()V
    //   1072: aload 11
    //   1074: invokevirtual 235	java/io/DataOutputStream:close	()V
    //   1077: aload 10
    //   1079: athrow
    //   1080: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1083: ifeq +38 -> 1121
    //   1086: ldc 135
    //   1088: iconst_2
    //   1089: ldc_w 306
    //   1092: iconst_2
    //   1093: anewarray 251	java/lang/Object
    //   1096: dup
    //   1097: iconst_0
    //   1098: aload 11
    //   1100: getfield 254	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   1103: aastore
    //   1104: dup
    //   1105: iconst_1
    //   1106: aload 11
    //   1108: getfield 257	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   1111: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1114: aastore
    //   1115: invokestatic 269	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1118: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1121: aload 10
    //   1123: iconst_0
    //   1124: invokeinterface 309 2 0
    //   1129: pop
    //   1130: goto -431 -> 699
    //   1133: aload 9
    //   1135: astore 11
    //   1137: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1140: ifeq +23 -> 1163
    //   1143: ldc 135
    //   1145: iconst_2
    //   1146: ldc_w 311
    //   1149: iconst_0
    //   1150: anewarray 251	java/lang/Object
    //   1153: invokestatic 269	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1156: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1159: aload 9
    //   1161: astore 11
    //   1163: aload 11
    //   1165: invokeinterface 317 1 0
    //   1170: astore 9
    //   1172: aload 9
    //   1174: invokeinterface 322 1 0
    //   1179: sipush 200
    //   1182: if_icmpeq +228 -> 1410
    //   1185: aload 9
    //   1187: invokeinterface 322 1 0
    //   1192: sipush 206
    //   1195: if_icmpeq +215 -> 1410
    //   1198: aload 11
    //   1200: invokeinterface 326 1 0
    //   1205: astore 9
    //   1207: aload 9
    //   1209: ifnull +89 -> 1298
    //   1212: new 182	java/lang/StringBuilder
    //   1215: dup
    //   1216: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   1219: astore 13
    //   1221: aload 9
    //   1223: arraylength
    //   1224: istore_3
    //   1225: iconst_0
    //   1226: istore_2
    //   1227: iload_2
    //   1228: iload_3
    //   1229: if_icmpge +57 -> 1286
    //   1232: aload 9
    //   1234: iload_2
    //   1235: aaload
    //   1236: astore 14
    //   1238: aload 13
    //   1240: ldc_w 328
    //   1243: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: aload 14
    //   1248: invokeinterface 333 1 0
    //   1253: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: ldc_w 335
    //   1259: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: aload 14
    //   1264: invokeinterface 338 1 0
    //   1269: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: ldc_w 340
    //   1275: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: pop
    //   1279: iload_2
    //   1280: iconst_1
    //   1281: iadd
    //   1282: istore_2
    //   1283: goto -56 -> 1227
    //   1286: aload_0
    //   1287: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1290: aload 13
    //   1292: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1295: putfield 343	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:rspHeadStr	Ljava/lang/String;
    //   1298: aload 11
    //   1300: ldc_w 345
    //   1303: invokeinterface 349 2 0
    //   1308: astore 9
    //   1310: aload 9
    //   1312: ifnull +351 -> 1663
    //   1315: aload 9
    //   1317: invokeinterface 338 1 0
    //   1322: ifnull +341 -> 1663
    //   1325: aload 9
    //   1327: invokeinterface 338 1 0
    //   1332: ldc_w 351
    //   1335: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1338: ifeq +8 -> 1346
    //   1341: iconst_4
    //   1342: istore_3
    //   1343: goto -1042 -> 301
    //   1346: aload 9
    //   1348: invokeinterface 338 1 0
    //   1353: ldc_w 357
    //   1356: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1359: ifne +35 -> 1394
    //   1362: aload 9
    //   1364: invokeinterface 338 1 0
    //   1369: ldc_w 359
    //   1372: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1375: ifne +19 -> 1394
    //   1378: aload 9
    //   1380: invokeinterface 338 1 0
    //   1385: ldc_w 361
    //   1388: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1391: ifeq +272 -> 1663
    //   1394: aload_0
    //   1395: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1398: aload_0
    //   1399: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1402: iconst_3
    //   1403: sipush 206
    //   1406: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1409: return
    //   1410: aload_0
    //   1411: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1414: iconst_0
    //   1415: aload 13
    //   1417: arraylength
    //   1418: i2l
    //   1419: invokevirtual 364	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   1422: new 366	java/io/DataInputStream
    //   1425: dup
    //   1426: aload 11
    //   1428: invokeinterface 370 1 0
    //   1433: invokeinterface 376 1 0
    //   1438: invokespecial 379	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   1441: astore 9
    //   1443: aload 9
    //   1445: ldc2_w 380
    //   1448: invokevirtual 382	java/io/DataInputStream:skip	(J)J
    //   1451: pop2
    //   1452: aload 9
    //   1454: invokevirtual 386	java/io/DataInputStream:readByte	()B
    //   1457: ifeq +8 -> 1465
    //   1460: iconst_0
    //   1461: istore_3
    //   1462: goto -1161 -> 301
    //   1465: aload 9
    //   1467: invokevirtual 389	java/io/DataInputStream:readInt	()I
    //   1470: i2l
    //   1471: lstore 5
    //   1473: aload 9
    //   1475: invokevirtual 389	java/io/DataInputStream:readInt	()I
    //   1478: i2l
    //   1479: lstore 7
    //   1481: aload 11
    //   1483: invokeinterface 370 1 0
    //   1488: invokeinterface 392 1 0
    //   1493: aload_0
    //   1494: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1497: lload 5
    //   1499: ldc2_w 393
    //   1502: land
    //   1503: lload 7
    //   1505: bipush 32
    //   1507: lshl
    //   1508: lor
    //   1509: putfield 166	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1512: aload_0
    //   1513: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1516: aload_0
    //   1517: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1520: getfield 166	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1523: putfield 397	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1526: aload_0
    //   1527: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1530: aload_0
    //   1531: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1534: invokevirtual 400	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1537: sipush 16384
    //   1540: istore_2
    //   1541: iconst_0
    //   1542: istore_1
    //   1543: goto -1473 -> 70
    //   1546: astore 9
    //   1548: aload 9
    //   1550: invokevirtual 401	java/lang/IllegalStateException:printStackTrace	()V
    //   1553: sipush 16384
    //   1556: istore_2
    //   1557: goto -1487 -> 70
    //   1560: astore 9
    //   1562: aload 9
    //   1564: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   1567: sipush 16384
    //   1570: istore_2
    //   1571: goto -1501 -> 70
    //   1574: aload_0
    //   1575: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1578: aload_0
    //   1579: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1582: getfield 158	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1585: putfield 166	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1588: aload_0
    //   1589: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1592: aload_0
    //   1593: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1596: bipush 6
    //   1598: invokevirtual 404	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   1601: aload_0
    //   1602: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1605: aload_0
    //   1606: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1609: invokevirtual 406	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1612: aload_0
    //   1613: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1616: aconst_null
    //   1617: putfield 409	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   1620: aload_0
    //   1621: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1624: aconst_null
    //   1625: putfield 204	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1628: aload_0
    //   1629: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1632: aload_0
    //   1633: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1636: aload_0
    //   1637: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1640: getfield 411	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   1643: invokevirtual 415	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   1646: iconst_1
    //   1647: invokevirtual 418	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Z)V
    //   1650: goto -1293 -> 357
    //   1653: astore 9
    //   1655: goto -578 -> 1077
    //   1658: astore 9
    //   1660: goto -976 -> 684
    //   1663: sipush 16384
    //   1666: istore_2
    //   1667: goto -1597 -> 70
    //   1670: goto -766 -> 904
    //   1673: aconst_null
    //   1674: astore 10
    //   1676: goto -1612 -> 64
    //   1679: iload_3
    //   1680: iconst_1
    //   1681: iadd
    //   1682: istore_3
    //   1683: goto -1540 -> 143
    //   1686: iconst_0
    //   1687: istore 4
    //   1689: goto -767 -> 922
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1692	0	this	TaskHttpUpload
    //   65	1478	1	i	int
    //   69	1598	2	j	int
    //   71	1612	3	k	int
    //   920	768	4	bool	boolean
    //   1471	27	5	l1	long
    //   1479	25	7	l2	long
    //   105	17	9	localInterruptedException	java.lang.InterruptedException
    //   267	24	9	localFileInputStream	java.io.FileInputStream
    //   374	1	9	localFileNotFoundException	java.io.FileNotFoundException
    //   392	33	9	localIOException1	IOException
    //   430	11	9	localIOException2	IOException
    //   448	3	9	localIOException3	IOException
    //   496	556	9	localObject1	java.lang.Object
    //   1062	98	9	localException1	java.lang.Exception
    //   1170	304	9	localObject2	java.lang.Object
    //   1546	3	9	localIllegalStateException	java.lang.IllegalStateException
    //   1560	3	9	localIOException4	IOException
    //   1653	1	9	localException2	java.lang.Exception
    //   1658	1	9	localException3	java.lang.Exception
    //   62	1	10	localList	java.util.List
    //   402	3	10	localIOException5	IOException
    //   438	272	10	localObject3	java.lang.Object
    //   1030	3	10	localIOException6	IOException
    //   1065	57	10	localObject4	java.lang.Object
    //   1674	1	10	localObject5	java.lang.Object
    //   507	975	11	localObject6	java.lang.Object
    //   29	234	12	localFile	java.io.File
    //   256	1160	13	localObject7	java.lang.Object
    //   844	419	14	localHttpClient	HttpClient
    // Exception table:
    //   from	to	target	type
    //   81	104	105	java/lang/InterruptedException
    //   151	194	105	java/lang/InterruptedException
    //   195	240	105	java/lang/InterruptedException
    //   245	258	105	java/lang/InterruptedException
    //   258	269	105	java/lang/InterruptedException
    //   290	295	105	java/lang/InterruptedException
    //   376	391	105	java/lang/InterruptedException
    //   394	399	105	java/lang/InterruptedException
    //   424	429	105	java/lang/InterruptedException
    //   432	437	105	java/lang/InterruptedException
    //   440	445	105	java/lang/InterruptedException
    //   445	448	105	java/lang/InterruptedException
    //   450	455	105	java/lang/InterruptedException
    //   458	509	105	java/lang/InterruptedException
    //   674	684	105	java/lang/InterruptedException
    //   699	762	105	java/lang/InterruptedException
    //   762	877	105	java/lang/InterruptedException
    //   882	904	105	java/lang/InterruptedException
    //   913	919	105	java/lang/InterruptedException
    //   922	1018	105	java/lang/InterruptedException
    //   1051	1061	105	java/lang/InterruptedException
    //   1067	1077	105	java/lang/InterruptedException
    //   1077	1080	105	java/lang/InterruptedException
    //   1080	1121	105	java/lang/InterruptedException
    //   1121	1130	105	java/lang/InterruptedException
    //   1137	1159	105	java/lang/InterruptedException
    //   1163	1207	105	java/lang/InterruptedException
    //   1212	1225	105	java/lang/InterruptedException
    //   1238	1279	105	java/lang/InterruptedException
    //   1286	1298	105	java/lang/InterruptedException
    //   1298	1310	105	java/lang/InterruptedException
    //   1315	1341	105	java/lang/InterruptedException
    //   1346	1394	105	java/lang/InterruptedException
    //   1394	1409	105	java/lang/InterruptedException
    //   1410	1422	105	java/lang/InterruptedException
    //   1422	1460	105	java/lang/InterruptedException
    //   1465	1537	105	java/lang/InterruptedException
    //   1548	1553	105	java/lang/InterruptedException
    //   1562	1567	105	java/lang/InterruptedException
    //   258	269	374	java/io/FileNotFoundException
    //   290	295	392	java/io/IOException
    //   269	290	402	java/io/IOException
    //   424	429	430	java/io/IOException
    //   269	290	438	finally
    //   404	424	438	finally
    //   440	445	448	java/io/IOException
    //   509	674	1030	java/io/IOException
    //   1051	1061	1062	java/lang/Exception
    //   509	674	1065	finally
    //   1032	1051	1065	finally
    //   1422	1460	1546	java/lang/IllegalStateException
    //   1465	1537	1546	java/lang/IllegalStateException
    //   1422	1460	1560	java/io/IOException
    //   1465	1537	1560	java/io/IOException
    //   1067	1077	1653	java/lang/Exception
    //   674	684	1658	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpUpload
 * JD-Core Version:    0.7.0.1
 */