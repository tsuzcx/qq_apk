package oicq.wlogin_sdk.report;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import oicq.wlogin_sdk.tools.util;

public class report_t
  implements Serializable
{
  public static String FILE_NAME = "report_data";
  private static final long serialVersionUID = 1L;
  
  public static void delete_file(Context paramContext)
  {
    try
    {
      paramContext.deleteFile(FILE_NAME);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public static Reporter read_fromfile(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 36	java/io/File
    //   6: dup
    //   7: getstatic 18	oicq/wlogin_sdk/report/report_t:FILE_NAME	Ljava/lang/String;
    //   10: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 41	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 44	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore_1
    //   23: new 46	java/io/BufferedInputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 49	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore_2
    //   32: new 51	java/io/ObjectInputStream
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 52	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: invokevirtual 56	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   43: checkcast 58	oicq/wlogin_sdk/report/Reporter
    //   46: checkcast 58	oicq/wlogin_sdk/report/Reporter
    //   49: astore_0
    //   50: aload_2
    //   51: invokevirtual 61	java/io/BufferedInputStream:close	()V
    //   54: aload_1
    //   55: invokevirtual 62	java/io/FileInputStream:close	()V
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: areturn
    //   63: astore_0
    //   64: new 64	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   71: ldc 67
    //   73: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: getstatic 18	oicq/wlogin_sdk/report/report_t:FILE_NAME	Ljava/lang/String;
    //   79: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 73
    //   84: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 82	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   93: aconst_null
    //   94: astore_0
    //   95: goto -37 -> 58
    //   98: astore_0
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramContext	Context
    //   22	33	1	localFileInputStream	java.io.FileInputStream
    //   31	20	2	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   14	58	63	java/lang/Exception
    //   3	14	98	finally
    //   14	58	98	finally
    //   64	93	98	finally
  }
  
  public static int write_tofile(Reporter paramReporter, Context paramContext)
  {
    int i = 0;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(8192);
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramReporter);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      paramReporter = paramContext.openFileOutput(FILE_NAME, 0);
      localByteArrayOutputStream.writeTo(paramReporter);
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
      paramReporter.close();
      return i;
    }
    catch (Exception paramReporter)
    {
      for (;;)
      {
        util.LOGI(paramReporter.getStackTrace().toString());
        i = -1;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.report_t
 * JD-Core Version:    0.7.0.1
 */