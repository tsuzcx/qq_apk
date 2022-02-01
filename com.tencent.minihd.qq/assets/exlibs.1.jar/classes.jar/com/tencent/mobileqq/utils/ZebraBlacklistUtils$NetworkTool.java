package com.tencent.mobileqq.utils;

import CommonClientInterface.stReqComm;
import CommonClientInterface.stReqHeader;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.net.SocketTimeoutException;

public class ZebraBlacklistUtils$NetworkTool
  implements Runnable
{
  private ZebraBlacklistUtils.JceRequestCallback jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback;
  private String jdField_a_of_type_JavaLangString = "";
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private String b = "";
  
  public ZebraBlacklistUtils$NetworkTool(String paramString1, String paramString2, byte[] paramArrayOfByte, ZebraBlacklistUtils.JceRequestCallback paramJceRequestCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback = paramJceRequestCallback;
  }
  
  public static stReqHeader a(String paramString1, String paramString2)
  {
    stReqHeader localstReqHeader = new stReqHeader();
    label181:
    for (;;)
    {
      try
      {
        stReqComm localstReqComm = new stReqComm();
        localstReqComm.iAppId = 1004;
        localstReqComm.iPlat = 1;
        localstReqComm.sAppVersion = "1.1.0";
        if (TextUtils.isEmpty(Build.MODEL))
        {
          localObject1 = "Unknown";
          localstReqComm.sDeviceName = ((String)localObject1);
          if (TextUtils.isEmpty(Build.VERSION.RELEASE))
          {
            localObject1 = "Unknown";
            localstReqComm.sOSVersion = ((String)localObject1);
            if (!TextUtils.isEmpty(ZebraBlacklistUtils.d)) {
              continue;
            }
            localObject1 = "";
            localstReqComm.sDeviceID = ((String)localObject1);
            localObject1 = (QQAppInterface)BaseApplicationImpl.a().a();
            if (localObject1 == null) {
              break label181;
            }
            localObject1 = ((QQAppInterface)localObject1).a();
            Object localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = "";
            }
            localstReqComm.sUid = ((String)localObject2);
            localstReqHeader.reqComm = localstReqComm;
            localstReqHeader.sApply = paramString1;
            localstReqHeader.sCmd = paramString2;
            return localstReqHeader;
          }
        }
        else
        {
          localObject1 = Build.MODEL;
          continue;
        }
        Object localObject1 = Build.VERSION.RELEASE;
        continue;
        localObject1 = ZebraBlacklistUtils.d;
        continue;
        localObject1 = "";
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return localstReqHeader;
      }
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = a(paramString, paramArrayOfByte);
        if (paramString == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback.a();
        }
      }
      catch (SocketTimeoutException paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback.a();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback.a(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback.a();
      }
    }
  }
  
  /* Error */
  private static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: aload 8
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: new 127	org/apache/http/impl/client/DefaultHttpClient
    //   18: dup
    //   19: invokespecial 128	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   22: astore 9
    //   24: aload 9
    //   26: invokeinterface 134 1 0
    //   31: astore_3
    //   32: aload_3
    //   33: sipush 30000
    //   36: invokestatic 140	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   39: aload_3
    //   40: sipush 30000
    //   43: invokestatic 143	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   46: aload_3
    //   47: sipush 1024
    //   50: invokestatic 146	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   53: new 148	org/apache/http/client/methods/HttpPost
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 151	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   61: astore_0
    //   62: aload_0
    //   63: new 153	org/apache/http/entity/ByteArrayEntity
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 155	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   71: invokevirtual 159	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   74: aload 9
    //   76: aload_0
    //   77: invokeinterface 163 2 0
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +14 -> 98
    //   87: aload_1
    //   88: invokeinterface 169 1 0
    //   93: astore_0
    //   94: aload_0
    //   95: ifnonnull +54 -> 149
    //   98: aload 9
    //   100: ifnull +15 -> 115
    //   103: aload 9
    //   105: invokeinterface 173 1 0
    //   110: invokeinterface 178 1 0
    //   115: iconst_0
    //   116: ifeq +11 -> 127
    //   119: new 180	java/lang/NullPointerException
    //   122: dup
    //   123: invokespecial 181	java/lang/NullPointerException:<init>	()V
    //   126: athrow
    //   127: aload 8
    //   129: astore_1
    //   130: iconst_0
    //   131: ifeq -118 -> 13
    //   134: new 180	java/lang/NullPointerException
    //   137: dup
    //   138: invokespecial 181	java/lang/NullPointerException:<init>	()V
    //   141: athrow
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   147: aconst_null
    //   148: areturn
    //   149: aload_1
    //   150: invokeinterface 169 1 0
    //   155: invokeinterface 187 1 0
    //   160: astore_1
    //   161: new 189	java/io/ByteArrayOutputStream
    //   164: dup
    //   165: invokespecial 190	java/io/ByteArrayOutputStream:<init>	()V
    //   168: astore 5
    //   170: aload 5
    //   172: astore_3
    //   173: aload_1
    //   174: astore 6
    //   176: aload 5
    //   178: astore 4
    //   180: aload_1
    //   181: invokevirtual 196	java/io/InputStream:read	()I
    //   184: istore_2
    //   185: aload 5
    //   187: astore_0
    //   188: iload_2
    //   189: iconst_m1
    //   190: if_icmpeq +43 -> 233
    //   193: aload 5
    //   195: astore_3
    //   196: aload_1
    //   197: astore 6
    //   199: aload 5
    //   201: astore 4
    //   203: aload 5
    //   205: iload_2
    //   206: invokevirtual 200	java/io/ByteArrayOutputStream:write	(I)V
    //   209: goto -39 -> 170
    //   212: astore 7
    //   214: aload 5
    //   216: astore_0
    //   217: aload_0
    //   218: astore_3
    //   219: aload_1
    //   220: astore 6
    //   222: aload_0
    //   223: astore 4
    //   225: aload_0
    //   226: astore 5
    //   228: aload 7
    //   230: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   233: aload_0
    //   234: ifnonnull +48 -> 282
    //   237: aload 9
    //   239: ifnull +15 -> 254
    //   242: aload 9
    //   244: invokeinterface 173 1 0
    //   249: invokeinterface 178 1 0
    //   254: aload_1
    //   255: ifnull +7 -> 262
    //   258: aload_1
    //   259: invokevirtual 203	java/io/InputStream:close	()V
    //   262: aload 8
    //   264: astore_1
    //   265: aload_0
    //   266: ifnull -253 -> 13
    //   269: aload_0
    //   270: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   273: aconst_null
    //   274: areturn
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   280: aconst_null
    //   281: areturn
    //   282: aload_0
    //   283: astore_3
    //   284: aload_1
    //   285: astore 6
    //   287: aload_0
    //   288: astore 4
    //   290: aload_0
    //   291: astore 5
    //   293: aload_0
    //   294: invokevirtual 208	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   297: astore 7
    //   299: aload 7
    //   301: astore_3
    //   302: aload 9
    //   304: ifnull +15 -> 319
    //   307: aload 9
    //   309: invokeinterface 173 1 0
    //   314: invokeinterface 178 1 0
    //   319: aload_1
    //   320: ifnull +7 -> 327
    //   323: aload_1
    //   324: invokevirtual 203	java/io/InputStream:close	()V
    //   327: aload_3
    //   328: astore_1
    //   329: aload_0
    //   330: ifnull -317 -> 13
    //   333: aload_0
    //   334: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   337: aload_3
    //   338: areturn
    //   339: astore_0
    //   340: aload_0
    //   341: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   344: aload_3
    //   345: areturn
    //   346: astore_1
    //   347: aconst_null
    //   348: astore_3
    //   349: aconst_null
    //   350: astore_0
    //   351: aload_1
    //   352: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   355: aload_1
    //   356: athrow
    //   357: astore 4
    //   359: aload_0
    //   360: astore_1
    //   361: aload 4
    //   363: astore_0
    //   364: aload 9
    //   366: ifnull +15 -> 381
    //   369: aload 9
    //   371: invokeinterface 173 1 0
    //   376: invokeinterface 178 1 0
    //   381: aload_1
    //   382: ifnull +7 -> 389
    //   385: aload_1
    //   386: invokevirtual 203	java/io/InputStream:close	()V
    //   389: aload_3
    //   390: ifnull +7 -> 397
    //   393: aload_3
    //   394: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   397: aload_0
    //   398: athrow
    //   399: astore_0
    //   400: aconst_null
    //   401: astore 4
    //   403: aconst_null
    //   404: astore_1
    //   405: aload 4
    //   407: astore_3
    //   408: aload_1
    //   409: astore 6
    //   411: aload_0
    //   412: invokevirtual 209	java/lang/Error:printStackTrace	()V
    //   415: aload 9
    //   417: ifnull +15 -> 432
    //   420: aload 9
    //   422: invokeinterface 173 1 0
    //   427: invokeinterface 178 1 0
    //   432: aload_1
    //   433: ifnull +7 -> 440
    //   436: aload_1
    //   437: invokevirtual 203	java/io/InputStream:close	()V
    //   440: aload 8
    //   442: astore_1
    //   443: aload 4
    //   445: ifnull -432 -> 13
    //   448: aload 4
    //   450: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   453: aconst_null
    //   454: areturn
    //   455: astore_0
    //   456: aload_0
    //   457: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   460: aconst_null
    //   461: areturn
    //   462: astore_1
    //   463: aload_1
    //   464: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   467: goto -70 -> 397
    //   470: astore_0
    //   471: aconst_null
    //   472: astore_3
    //   473: aconst_null
    //   474: astore_1
    //   475: goto -111 -> 364
    //   478: astore_0
    //   479: aconst_null
    //   480: astore_3
    //   481: goto -117 -> 364
    //   484: astore_0
    //   485: aload 6
    //   487: astore_1
    //   488: goto -124 -> 364
    //   491: astore_0
    //   492: aconst_null
    //   493: astore 4
    //   495: goto -90 -> 405
    //   498: astore_0
    //   499: goto -94 -> 405
    //   502: astore_3
    //   503: aload_1
    //   504: astore_0
    //   505: aload_3
    //   506: astore_1
    //   507: aload 5
    //   509: astore_3
    //   510: goto -159 -> 351
    //   513: astore 7
    //   515: aconst_null
    //   516: astore_0
    //   517: goto -300 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	520	0	paramString	String
    //   0	520	1	paramArrayOfByte	byte[]
    //   184	22	2	i	int
    //   31	450	3	localObject1	Object
    //   502	4	3	localException1	Exception
    //   509	1	3	localObject2	Object
    //   178	111	4	localObject3	Object
    //   357	5	4	localObject4	Object
    //   401	93	4	localObject5	Object
    //   168	340	5	localObject6	Object
    //   174	312	6	arrayOfByte1	byte[]
    //   212	17	7	localException2	Exception
    //   297	3	7	arrayOfByte2	byte[]
    //   513	1	7	localException3	Exception
    //   1	440	8	localObject7	Object
    //   22	399	9	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    // Exception table:
    //   from	to	target	type
    //   119	127	142	java/lang/Exception
    //   134	142	142	java/lang/Exception
    //   180	185	212	java/lang/Exception
    //   203	209	212	java/lang/Exception
    //   258	262	275	java/lang/Exception
    //   269	273	275	java/lang/Exception
    //   323	327	339	java/lang/Exception
    //   333	337	339	java/lang/Exception
    //   24	83	346	java/lang/Exception
    //   87	94	346	java/lang/Exception
    //   149	161	346	java/lang/Exception
    //   351	357	357	finally
    //   24	83	399	java/lang/Error
    //   87	94	399	java/lang/Error
    //   149	161	399	java/lang/Error
    //   436	440	455	java/lang/Exception
    //   448	453	455	java/lang/Exception
    //   385	389	462	java/lang/Exception
    //   393	397	462	java/lang/Exception
    //   24	83	470	finally
    //   87	94	470	finally
    //   149	161	470	finally
    //   161	170	478	finally
    //   180	185	484	finally
    //   203	209	484	finally
    //   228	233	484	finally
    //   293	299	484	finally
    //   411	415	484	finally
    //   161	170	491	java/lang/Error
    //   180	185	498	java/lang/Error
    //   203	209	498	java/lang/Error
    //   228	233	498	java/lang/Error
    //   293	299	498	java/lang/Error
    //   228	233	502	java/lang/Exception
    //   293	299	502	java/lang/Exception
    //   161	170	513	java/lang/Exception
  }
  
  public void run()
  {
    a(MsfSdkUtils.insertMtype("Zebra", this.jdField_a_of_type_JavaLangString + this.b), this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ZebraBlacklistUtils.NetworkTool
 * JD-Core Version:    0.7.0.1
 */