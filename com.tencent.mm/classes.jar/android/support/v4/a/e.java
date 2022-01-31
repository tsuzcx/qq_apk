package android.support.v4.a;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.File;

class e
  extends h
{
  private static File a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      paramParcelFileDescriptor = Os.readlink("/proc/self/fd/" + paramParcelFileDescriptor.getFd());
      if (OsConstants.S_ISREG(Os.stat(paramParcelFileDescriptor).st_mode))
      {
        paramParcelFileDescriptor = new File(paramParcelFileDescriptor);
        return paramParcelFileDescriptor;
      }
      return null;
    }
    catch (ErrnoException paramParcelFileDescriptor) {}
    return null;
  }
  
  /* Error */
  public android.graphics.Typeface a(android.content.Context paramContext, android.support.v4.d.b.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: arraylength
    //   2: ifgt +5 -> 7
    //   5: aconst_null
    //   6: areturn
    //   7: aload_0
    //   8: aload_2
    //   9: iload_3
    //   10: invokevirtual 67	android/support/v4/a/e:a	([Landroid/support/v4/d/b$b;I)Landroid/support/v4/d/b$b;
    //   13: astore_2
    //   14: aload_1
    //   15: invokevirtual 73	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: astore 4
    //   20: aload 4
    //   22: aload_2
    //   23: getfield 79	android/support/v4/d/b$b:mUri	Landroid/net/Uri;
    //   26: ldc 81
    //   28: aconst_null
    //   29: invokevirtual 87	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   32: astore 4
    //   34: aload 4
    //   36: invokestatic 89	android/support/v4/a/e:a	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +10 -> 51
    //   44: aload_2
    //   45: invokevirtual 93	java/io/File:canRead	()Z
    //   48: ifne +98 -> 146
    //   51: new 95	java/io/FileInputStream
    //   54: dup
    //   55: aload 4
    //   57: invokevirtual 99	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   60: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   63: astore 5
    //   65: aload_1
    //   66: aload 5
    //   68: invokestatic 105	android/support/v4/a/h:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   71: astore_1
    //   72: aload 5
    //   74: invokevirtual 108	java/io/FileInputStream:close	()V
    //   77: aload 4
    //   79: ifnull +8 -> 87
    //   82: aload 4
    //   84: invokevirtual 109	android/os/ParcelFileDescriptor:close	()V
    //   87: aload_1
    //   88: areturn
    //   89: astore_2
    //   90: aload_2
    //   91: athrow
    //   92: astore_1
    //   93: aload_2
    //   94: ifnull +44 -> 138
    //   97: aload 5
    //   99: invokevirtual 108	java/io/FileInputStream:close	()V
    //   102: aload_1
    //   103: athrow
    //   104: astore_2
    //   105: aload_2
    //   106: athrow
    //   107: astore_1
    //   108: aload 4
    //   110: ifnull +12 -> 122
    //   113: aload_2
    //   114: ifnull +61 -> 175
    //   117: aload 4
    //   119: invokevirtual 109	android/os/ParcelFileDescriptor:close	()V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: aconst_null
    //   126: areturn
    //   127: astore 5
    //   129: aload_2
    //   130: aload 5
    //   132: invokevirtual 113	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   135: goto -33 -> 102
    //   138: aload 5
    //   140: invokevirtual 108	java/io/FileInputStream:close	()V
    //   143: goto -41 -> 102
    //   146: aload_2
    //   147: invokestatic 119	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   150: astore_1
    //   151: aload 4
    //   153: ifnull +42 -> 195
    //   156: aload 4
    //   158: invokevirtual 109	android/os/ParcelFileDescriptor:close	()V
    //   161: goto +34 -> 195
    //   164: astore 4
    //   166: aload_2
    //   167: aload 4
    //   169: invokevirtual 113	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   172: goto -50 -> 122
    //   175: aload 4
    //   177: invokevirtual 109	android/os/ParcelFileDescriptor:close	()V
    //   180: goto -58 -> 122
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_2
    //   186: goto -93 -> 93
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: goto -84 -> 108
    //   195: aload_1
    //   196: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	e
    //   0	197	1	paramContext	android.content.Context
    //   0	197	2	paramArrayOfb	android.support.v4.d.b.b[]
    //   0	197	3	paramInt	int
    //   18	139	4	localObject	java.lang.Object
    //   164	12	4	localThrowable1	java.lang.Throwable
    //   63	35	5	localFileInputStream	java.io.FileInputStream
    //   127	12	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   65	72	89	java/lang/Throwable
    //   90	92	92	finally
    //   34	40	104	java/lang/Throwable
    //   44	51	104	java/lang/Throwable
    //   51	65	104	java/lang/Throwable
    //   72	77	104	java/lang/Throwable
    //   102	104	104	java/lang/Throwable
    //   129	135	104	java/lang/Throwable
    //   138	143	104	java/lang/Throwable
    //   146	151	104	java/lang/Throwable
    //   105	107	107	finally
    //   20	34	124	java/io/IOException
    //   82	87	124	java/io/IOException
    //   117	122	124	java/io/IOException
    //   122	124	124	java/io/IOException
    //   156	161	124	java/io/IOException
    //   166	172	124	java/io/IOException
    //   175	180	124	java/io/IOException
    //   97	102	127	java/lang/Throwable
    //   117	122	164	java/lang/Throwable
    //   65	72	183	finally
    //   34	40	189	finally
    //   44	51	189	finally
    //   51	65	189	finally
    //   72	77	189	finally
    //   97	102	189	finally
    //   102	104	189	finally
    //   129	135	189	finally
    //   138	143	189	finally
    //   146	151	189	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.a.e
 * JD-Core Version:    0.7.0.1
 */