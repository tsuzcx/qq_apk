package com.tencent.open.base.http;

import android.graphics.Bitmap;
import android.os.Bundle;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class HttpImageDownloadAsyncTask
  extends HttpAsyncTask
{
  protected Bundle a;
  protected HttpImageDownloadAsyncTask.TaskCompleteCallback a;
  protected String a;
  
  public HttpImageDownloadAsyncTask(String paramString1, String paramString2, Bundle paramBundle, String paramString3, HttpImageDownloadAsyncTask.TaskCompleteCallback paramTaskCompleteCallback)
  {
    super(paramString2, paramString3);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentOpenBaseHttpHttpImageDownloadAsyncTask$TaskCompleteCallback = null;
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentOpenBaseHttpHttpImageDownloadAsyncTask$TaskCompleteCallback = paramTaskCompleteCallback;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  /* Error */
  protected Bitmap a(java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 29	org/apache/http/impl/client/DefaultHttpClient
    //   5: dup
    //   6: invokespecial 32	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   9: astore_1
    //   10: new 34	org/apache/http/client/methods/HttpGet
    //   13: dup
    //   14: aload_0
    //   15: getfield 37	com/tencent/open/base/http/HttpImageDownloadAsyncTask:i	Ljava/lang/String;
    //   18: invokespecial 40	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 19	com/tencent/open/base/http/HttpImageDownloadAsyncTask:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   26: ifnull +93 -> 119
    //   29: aload_0
    //   30: getfield 19	com/tencent/open/base/http/HttpImageDownloadAsyncTask:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   33: invokevirtual 46	android/os/Bundle:keySet	()Ljava/util/Set;
    //   36: invokeinterface 52 1 0
    //   41: astore 4
    //   43: aload 4
    //   45: invokeinterface 58 1 0
    //   50: ifeq +69 -> 119
    //   53: aload 4
    //   55: invokeinterface 62 1 0
    //   60: checkcast 64	java/lang/String
    //   63: astore 5
    //   65: aload_0
    //   66: getfield 19	com/tencent/open/base/http/HttpImageDownloadAsyncTask:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   69: aload 5
    //   71: invokevirtual 68	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   74: astore 6
    //   76: aload 6
    //   78: instanceof 64
    //   81: ifeq -38 -> 43
    //   84: aload_3
    //   85: aload 5
    //   87: aload 6
    //   89: checkcast 64	java/lang/String
    //   92: invokevirtual 71	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: goto -52 -> 43
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   107: aload_1
    //   108: ifnull +124 -> 232
    //   111: aload_1
    //   112: invokevirtual 79	java/io/InputStream:close	()V
    //   115: aconst_null
    //   116: astore_3
    //   117: aload_3
    //   118: areturn
    //   119: aload_1
    //   120: aload_3
    //   121: invokeinterface 85 2 0
    //   126: invokeinterface 91 1 0
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +101 -> 234
    //   136: aload_1
    //   137: invokeinterface 97 1 0
    //   142: astore_1
    //   143: aload_1
    //   144: astore_2
    //   145: aload_0
    //   146: aload_1
    //   147: invokevirtual 100	com/tencent/open/base/http/HttpImageDownloadAsyncTask:a	(Ljava/io/InputStream;)[B
    //   150: astore_3
    //   151: aload_1
    //   152: astore_2
    //   153: aload_3
    //   154: iconst_0
    //   155: aload_3
    //   156: arraylength
    //   157: invokestatic 106	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   160: astore_3
    //   161: aload_1
    //   162: astore_2
    //   163: aload_3
    //   164: astore_1
    //   165: aload_1
    //   166: astore_3
    //   167: aload_2
    //   168: ifnull -51 -> 117
    //   171: aload_2
    //   172: invokevirtual 79	java/io/InputStream:close	()V
    //   175: aload_1
    //   176: areturn
    //   177: astore_2
    //   178: aload_1
    //   179: areturn
    //   180: astore_1
    //   181: aconst_null
    //   182: areturn
    //   183: astore_3
    //   184: aconst_null
    //   185: astore_1
    //   186: aload_1
    //   187: astore_2
    //   188: aload_3
    //   189: invokevirtual 107	java/lang/OutOfMemoryError:printStackTrace	()V
    //   192: aload_1
    //   193: ifnull +39 -> 232
    //   196: aload_1
    //   197: invokevirtual 79	java/io/InputStream:close	()V
    //   200: aconst_null
    //   201: areturn
    //   202: astore_1
    //   203: aconst_null
    //   204: areturn
    //   205: astore_1
    //   206: aload_2
    //   207: ifnull +7 -> 214
    //   210: aload_2
    //   211: invokevirtual 79	java/io/InputStream:close	()V
    //   214: aload_1
    //   215: athrow
    //   216: astore_2
    //   217: goto -3 -> 214
    //   220: astore_1
    //   221: goto -15 -> 206
    //   224: astore_3
    //   225: goto -39 -> 186
    //   228: astore_3
    //   229: goto -128 -> 101
    //   232: aconst_null
    //   233: areturn
    //   234: aconst_null
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_1
    //   238: goto -73 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	HttpImageDownloadAsyncTask
    //   0	241	1	paramVarArgs	java.lang.Void[]
    //   1	171	2	arrayOfVoid1	java.lang.Void[]
    //   177	1	2	localIOException1	java.io.IOException
    //   187	24	2	arrayOfVoid2	java.lang.Void[]
    //   216	1	2	localIOException2	java.io.IOException
    //   235	1	2	localObject1	java.lang.Object
    //   21	64	3	localHttpGet	org.apache.http.client.methods.HttpGet
    //   98	6	3	localException1	java.lang.Exception
    //   116	51	3	localObject2	java.lang.Object
    //   183	6	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   224	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   228	1	3	localException2	java.lang.Exception
    //   41	13	4	localIterator	java.util.Iterator
    //   63	23	5	str	String
    //   74	14	6	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   10	43	98	java/lang/Exception
    //   43	95	98	java/lang/Exception
    //   119	132	98	java/lang/Exception
    //   136	143	98	java/lang/Exception
    //   171	175	177	java/io/IOException
    //   111	115	180	java/io/IOException
    //   10	43	183	java/lang/OutOfMemoryError
    //   43	95	183	java/lang/OutOfMemoryError
    //   119	132	183	java/lang/OutOfMemoryError
    //   136	143	183	java/lang/OutOfMemoryError
    //   196	200	202	java/io/IOException
    //   10	43	205	finally
    //   43	95	205	finally
    //   119	132	205	finally
    //   136	143	205	finally
    //   210	214	216	java/io/IOException
    //   103	107	220	finally
    //   145	151	220	finally
    //   153	161	220	finally
    //   188	192	220	finally
    //   145	151	224	java/lang/OutOfMemoryError
    //   153	161	224	java/lang/OutOfMemoryError
    //   145	151	228	java/lang/Exception
    //   153	161	228	java/lang/Exception
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentOpenBaseHttpHttpImageDownloadAsyncTask$TaskCompleteCallback != null) {
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpImageDownloadAsyncTask$TaskCompleteCallback.a(this.jdField_a_of_type_JavaLangString, paramBitmap);
    }
  }
  
  protected byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
      localByteArrayOutputStream.flush();
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.base.http.HttpImageDownloadAsyncTask
 * JD-Core Version:    0.7.0.1
 */