package cooperation.qzone;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class QZoneClickReport
{
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.c(paramString2);
    localReportInfo.a(Long.parseLong(paramString1));
    localReportInfo.d(paramString3);
    localArrayList.add(localReportInfo);
    ThreadManager.a(new QZoneClickReport.ReportRunnable(localArrayList, Long.parseLong(paramString1)));
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokevirtual 60	java/lang/String:getBytes	()[B
    //   10: astore_1
    //   11: iconst_0
    //   12: newarray byte
    //   14: astore_0
    //   15: new 62	java/util/zip/Deflater
    //   18: dup
    //   19: invokespecial 63	java/util/zip/Deflater:<init>	()V
    //   22: astore_3
    //   23: aload_3
    //   24: invokevirtual 66	java/util/zip/Deflater:reset	()V
    //   27: aload_3
    //   28: aload_1
    //   29: invokevirtual 70	java/util/zip/Deflater:setInput	([B)V
    //   32: aload_3
    //   33: invokevirtual 73	java/util/zip/Deflater:finish	()V
    //   36: new 75	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: aload_1
    //   41: arraylength
    //   42: invokespecial 78	java/io/ByteArrayOutputStream:<init>	(I)V
    //   45: astore 4
    //   47: sipush 1024
    //   50: newarray byte
    //   52: astore_2
    //   53: aload_3
    //   54: invokevirtual 82	java/util/zip/Deflater:finished	()Z
    //   57: ifne +32 -> 89
    //   60: aload 4
    //   62: aload_2
    //   63: iconst_0
    //   64: aload_3
    //   65: aload_2
    //   66: invokevirtual 86	java/util/zip/Deflater:deflate	([B)I
    //   69: invokevirtual 90	java/io/ByteArrayOutputStream:write	([BII)V
    //   72: goto -19 -> 53
    //   75: astore_0
    //   76: aload 4
    //   78: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   81: aload_1
    //   82: astore_0
    //   83: aload_3
    //   84: invokevirtual 96	java/util/zip/Deflater:end	()V
    //   87: aload_0
    //   88: areturn
    //   89: aload 4
    //   91: invokevirtual 99	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: astore_2
    //   95: aload_2
    //   96: astore_0
    //   97: aload 4
    //   99: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   102: goto -19 -> 83
    //   105: astore_1
    //   106: goto -23 -> 83
    //   109: astore_1
    //   110: aload 4
    //   112: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   115: goto -32 -> 83
    //   118: astore_1
    //   119: goto -36 -> 83
    //   122: astore_0
    //   123: aload 4
    //   125: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   128: aload_0
    //   129: athrow
    //   130: astore_0
    //   131: aload_1
    //   132: astore_0
    //   133: goto -50 -> 83
    //   136: astore_1
    //   137: goto -9 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString	String
    //   10	72	1	arrayOfByte1	byte[]
    //   105	1	1	localIOException1	java.io.IOException
    //   109	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   118	14	1	localIOException2	java.io.IOException
    //   136	1	1	localIOException3	java.io.IOException
    //   52	44	2	arrayOfByte2	byte[]
    //   22	62	3	localDeflater	java.util.zip.Deflater
    //   45	79	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	53	75	java/lang/Exception
    //   53	72	75	java/lang/Exception
    //   89	95	75	java/lang/Exception
    //   97	102	105	java/io/IOException
    //   47	53	109	java/lang/OutOfMemoryError
    //   53	72	109	java/lang/OutOfMemoryError
    //   89	95	109	java/lang/OutOfMemoryError
    //   110	115	118	java/io/IOException
    //   47	53	122	finally
    //   53	72	122	finally
    //   89	95	122	finally
    //   76	81	130	java/io/IOException
    //   123	128	136	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneClickReport
 * JD-Core Version:    0.7.0.1
 */