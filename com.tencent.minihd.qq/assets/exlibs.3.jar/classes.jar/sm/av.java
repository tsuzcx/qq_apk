package sm;

import android.content.Context;
import android.os.Build;

public class av
{
  private static String a = "EnvUtil";
  private static long b = -1L;
  private static Integer c = null;
  
  public static String a()
  {
    String str2 = Build.MANUFACTURER;
    String str1 = str2;
    if (str2 == null) {
      str1 = "UNKNOWN";
    }
    return str1;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = new String();
    paramContext = paramContext + "MANUFACTURER " + a() + ";";
    return paramContext + "ram " + b() + ";";
  }
  
  /* Error */
  private static long b()
  {
    // Byte code:
    //   0: getstatic 20	sm/av:b	J
    //   3: ldc2_w 17
    //   6: lcmp
    //   7: ifne +74 -> 81
    //   10: new 69	java/io/File
    //   13: dup
    //   14: ldc 71
    //   16: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 78	java/io/File:exists	()Z
    //   24: ifeq +57 -> 81
    //   27: new 80	java/io/DataInputStream
    //   30: dup
    //   31: new 82	java/io/FileInputStream
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: invokespecial 88	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 91	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnonnull +42 -> 93
    //   54: aload_1
    //   55: astore_0
    //   56: new 65	java/io/IOException
    //   59: dup
    //   60: ldc 93
    //   62: invokespecial 94	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   65: athrow
    //   66: astore_2
    //   67: aload_1
    //   68: astore_0
    //   69: aload_2
    //   70: invokevirtual 97	java/io/FileNotFoundException:printStackTrace	()V
    //   73: aload_1
    //   74: ifnull +7 -> 81
    //   77: aload_1
    //   78: invokevirtual 100	java/io/DataInputStream:close	()V
    //   81: getstatic 20	sm/av:b	J
    //   84: lconst_0
    //   85: lcmp
    //   86: ifle +130 -> 216
    //   89: getstatic 20	sm/av:b	J
    //   92: lreturn
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: invokevirtual 103	java/lang/String:trim	()Ljava/lang/String;
    //   99: ldc 105
    //   101: invokevirtual 109	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   104: iconst_1
    //   105: aaload
    //   106: invokestatic 115	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   109: putstatic 20	sm/av:b	J
    //   112: aload_1
    //   113: ifnull -32 -> 81
    //   116: aload_1
    //   117: invokevirtual 100	java/io/DataInputStream:close	()V
    //   120: goto -39 -> 81
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   128: goto -47 -> 81
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   136: goto -55 -> 81
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_1
    //   143: astore_0
    //   144: aload_2
    //   145: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   148: aload_1
    //   149: ifnull -68 -> 81
    //   152: aload_1
    //   153: invokevirtual 100	java/io/DataInputStream:close	()V
    //   156: goto -75 -> 81
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   164: goto -83 -> 81
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: astore_0
    //   172: aload_2
    //   173: invokevirtual 117	java/lang/NumberFormatException:printStackTrace	()V
    //   176: aload_1
    //   177: ifnull -96 -> 81
    //   180: aload_1
    //   181: invokevirtual 100	java/io/DataInputStream:close	()V
    //   184: goto -103 -> 81
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   192: goto -111 -> 81
    //   195: astore_1
    //   196: aconst_null
    //   197: astore_0
    //   198: aload_0
    //   199: ifnull +7 -> 206
    //   202: aload_0
    //   203: invokevirtual 100	java/io/DataInputStream:close	()V
    //   206: aload_1
    //   207: athrow
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   213: goto -7 -> 206
    //   216: lconst_1
    //   217: lreturn
    //   218: astore_1
    //   219: goto -21 -> 198
    //   222: astore_2
    //   223: goto -53 -> 170
    //   226: astore_2
    //   227: goto -85 -> 142
    //   230: astore_2
    //   231: aconst_null
    //   232: astore_1
    //   233: goto -166 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	76	0	localObject1	Object
    //   123	2	0	localIOException1	java.io.IOException
    //   131	2	0	localIOException2	java.io.IOException
    //   143	1	0	localObject2	Object
    //   159	2	0	localIOException3	java.io.IOException
    //   171	1	0	localObject3	Object
    //   187	2	0	localIOException4	java.io.IOException
    //   197	6	0	localObject4	Object
    //   208	2	0	localIOException5	java.io.IOException
    //   42	139	1	localDataInputStream	java.io.DataInputStream
    //   195	12	1	localObject5	Object
    //   218	1	1	localObject6	Object
    //   232	1	1	localObject7	Object
    //   49	2	2	str	String
    //   66	30	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   139	6	2	localIOException6	java.io.IOException
    //   167	6	2	localNumberFormatException1	java.lang.NumberFormatException
    //   222	1	2	localNumberFormatException2	java.lang.NumberFormatException
    //   226	1	2	localIOException7	java.io.IOException
    //   230	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   45	50	66	java/io/FileNotFoundException
    //   56	66	66	java/io/FileNotFoundException
    //   95	112	66	java/io/FileNotFoundException
    //   116	120	123	java/io/IOException
    //   77	81	131	java/io/IOException
    //   27	43	139	java/io/IOException
    //   152	156	159	java/io/IOException
    //   27	43	167	java/lang/NumberFormatException
    //   180	184	187	java/io/IOException
    //   27	43	195	finally
    //   202	206	208	java/io/IOException
    //   45	50	218	finally
    //   56	66	218	finally
    //   69	73	218	finally
    //   95	112	218	finally
    //   144	148	218	finally
    //   172	176	218	finally
    //   45	50	222	java/lang/NumberFormatException
    //   56	66	222	java/lang/NumberFormatException
    //   95	112	222	java/lang/NumberFormatException
    //   45	50	226	java/io/IOException
    //   56	66	226	java/io/IOException
    //   95	112	226	java/io/IOException
    //   27	43	230	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     sm.av
 * JD-Core Version:    0.7.0.1
 */