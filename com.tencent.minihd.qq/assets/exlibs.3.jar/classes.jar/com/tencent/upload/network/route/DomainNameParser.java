package com.tencent.upload.network.route;

import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadLog;

public class DomainNameParser
{
  private static final String TAG = "DomainParser";
  
  public static void parse(String paramString, final ParseResult paramParseResult)
  {
    UploadLog.i("DomainParser", "parse: start, domainName:" + paramString);
    if (paramString == null)
    {
      UploadLog.i("DomainParser", "parse: return, domainName == null");
      return;
    }
    synchronized (new byte[0])
    {
      new Thread(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: aconst_null
          //   3: astore 4
          //   5: aconst_null
          //   6: astore_2
          //   7: aload_0
          //   8: getfield 21	com/tencent/upload/network/route/DomainNameParser$1:val$domainName	Ljava/lang/String;
          //   11: invokestatic 42	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
          //   14: invokevirtual 46	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
          //   17: astore_1
          //   18: aload_1
          //   19: astore_2
          //   20: aload_1
          //   21: astore_3
          //   22: aload_1
          //   23: astore 4
          //   25: ldc 48
          //   27: new 50	java/lang/StringBuilder
          //   30: dup
          //   31: ldc 52
          //   33: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   36: aload_1
          //   37: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   40: ldc 61
          //   42: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   45: aload_0
          //   46: getfield 21	com/tencent/upload/network/route/DomainNameParser$1:val$domainName	Ljava/lang/String;
          //   49: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   52: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   55: invokestatic 70	com/tencent/upload/common/UploadLog:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   58: aload_0
          //   59: getfield 23	com/tencent/upload/network/route/DomainNameParser$1:val$lock	[B
          //   62: astore_2
          //   63: aload_2
          //   64: monitorenter
          //   65: aload_0
          //   66: getfield 25	com/tencent/upload/network/route/DomainNameParser$1:val$parseDomainResult	Lcom/tencent/upload/network/route/DomainNameParser$ParseResult;
          //   69: aload_1
          //   70: putfield 75	com/tencent/upload/network/route/DomainNameParser$ParseResult:paseredIp	Ljava/lang/String;
          //   73: aload_0
          //   74: getfield 23	com/tencent/upload/network/route/DomainNameParser$1:val$lock	[B
          //   77: invokevirtual 78	java/lang/Object:notify	()V
          //   80: aload_2
          //   81: monitorexit
          //   82: return
          //   83: astore_1
          //   84: ldc 48
          //   86: new 50	java/lang/StringBuilder
          //   89: dup
          //   90: ldc 80
          //   92: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   95: aload_1
          //   96: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   99: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   102: invokestatic 86	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   105: aload_2
          //   106: astore_1
          //   107: goto -49 -> 58
          //   110: astore_1
          //   111: ldc 48
          //   113: new 50	java/lang/StringBuilder
          //   116: dup
          //   117: ldc 88
          //   119: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   122: aload_1
          //   123: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   126: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   129: invokestatic 86	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   132: aload_3
          //   133: astore_1
          //   134: goto -76 -> 58
          //   137: astore_1
          //   138: ldc 48
          //   140: new 50	java/lang/StringBuilder
          //   143: dup
          //   144: ldc 90
          //   146: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   149: aload_1
          //   150: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   153: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   156: invokestatic 86	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   159: aload 4
          //   161: astore_1
          //   162: goto -104 -> 58
          //   165: astore_1
          //   166: aload_2
          //   167: monitorexit
          //   168: aload_1
          //   169: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	170	0	this	1
          //   17	53	1	str	String
          //   83	13	1	localUnknownHostException	java.net.UnknownHostException
          //   106	1	1	localObject1	Object
          //   110	13	1	localException	java.lang.Exception
          //   133	1	1	localObject2	Object
          //   137	13	1	localError	java.lang.Error
          //   161	1	1	localObject3	Object
          //   165	4	1	localObject4	Object
          //   1	132	3	localObject6	Object
          //   3	157	4	localObject7	Object
          // Exception table:
          //   from	to	target	type
          //   7	18	83	java/net/UnknownHostException
          //   25	58	83	java/net/UnknownHostException
          //   7	18	110	java/lang/Exception
          //   25	58	110	java/lang/Exception
          //   7	18	137	java/lang/Error
          //   25	58	137	java/lang/Error
          //   65	82	165	finally
          //   166	168	165	finally
        }
      }, "domainParser").start();
    }
    try
    {
      ???.wait(UploadConfiguration.getDomainNameParseTimeout());
      UploadLog.i("DomainParser", "parse return, get domainName:" + paramString + " to ip:" + paramParseResult.paseredIp);
      return;
      paramString = finally;
      throw paramString;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        UploadLog.w("DomainParser", "parse: wait:" + localInterruptedException);
      }
    }
  }
  
  public static final class ParseResult
  {
    public String paseredIp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.route.DomainNameParser
 * JD-Core Version:    0.7.0.1
 */