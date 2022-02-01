package com.tencent.matrix.a.b;

import java.io.IOException;

public final class e
{
  private final String eTF;
  private final int eTG;
  
  public e(int paramInt1, int paramInt2)
  {
    this.eTF = ("/sys/devices/system/cpu/cpu" + paramInt1 + "/cpufreq/stats/time_in_state");
    this.eTG = paramInt2;
  }
  
  public final void axt()
  {
    long[] arrayOfLong = axu();
    if (arrayOfLong.length != this.eTG) {
      throw new IOException("CpuCore Step unmatched, expect = " + this.eTG + ", actual = " + arrayOfLong.length + ", path = " + this.eTF);
    }
  }
  
  /* Error */
  public final long[] axu()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/tencent/matrix/a/b/e:eTG	I
    //   4: newarray long
    //   6: astore_3
    //   7: new 54	java/io/BufferedReader
    //   10: dup
    //   11: new 56	java/io/FileReader
    //   14: dup
    //   15: aload_0
    //   16: getfield 35	com/tencent/matrix/a/b/e:eTF	Ljava/lang/String;
    //   19: invokespecial 57	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 60	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_2
    //   26: new 62	android/text/TextUtils$SimpleStringSplitter
    //   29: dup
    //   30: bipush 32
    //   32: invokespecial 65	android/text/TextUtils$SimpleStringSplitter:<init>	(C)V
    //   35: astore 4
    //   37: iconst_0
    //   38: istore_1
    //   39: iload_1
    //   40: aload_0
    //   41: getfield 37	com/tencent/matrix/a/b/e:eTG	I
    //   44: if_icmpge +45 -> 89
    //   47: aload_2
    //   48: invokevirtual 68	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 5
    //   53: aload 5
    //   55: ifnull +34 -> 89
    //   58: aload 4
    //   60: aload 5
    //   62: invokevirtual 71	android/text/TextUtils$SimpleStringSplitter:setString	(Ljava/lang/String;)V
    //   65: aload 4
    //   67: invokevirtual 74	android/text/TextUtils$SimpleStringSplitter:next	()Ljava/lang/String;
    //   70: pop
    //   71: aload_3
    //   72: iload_1
    //   73: aload 4
    //   75: invokevirtual 74	android/text/TextUtils$SimpleStringSplitter:next	()Ljava/lang/String;
    //   78: invokestatic 80	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: lastore
    //   82: iload_1
    //   83: iconst_1
    //   84: iadd
    //   85: istore_1
    //   86: goto -47 -> 39
    //   89: aload_2
    //   90: invokevirtual 83	java/io/BufferedReader:close	()V
    //   93: aload_3
    //   94: areturn
    //   95: astore_3
    //   96: aload_3
    //   97: athrow
    //   98: astore 4
    //   100: aload_3
    //   101: ifnull +48 -> 149
    //   104: aload_2
    //   105: invokevirtual 83	java/io/BufferedReader:close	()V
    //   108: aload 4
    //   110: athrow
    //   111: astore_2
    //   112: new 45	java/io/IOException
    //   115: dup
    //   116: new 15	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 85
    //   122: invokespecial 20	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_2
    //   126: invokevirtual 90	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: aload_2
    //   136: invokespecial 93	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   139: athrow
    //   140: astore_2
    //   141: aload_3
    //   142: aload_2
    //   143: invokevirtual 97	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   146: goto -38 -> 108
    //   149: aload_2
    //   150: invokevirtual 83	java/io/BufferedReader:close	()V
    //   153: goto -45 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	e
    //   38	48	1	i	int
    //   25	80	2	localBufferedReader	java.io.BufferedReader
    //   111	25	2	localThrowable1	java.lang.Throwable
    //   140	10	2	localThrowable2	java.lang.Throwable
    //   6	88	3	arrayOfLong	long[]
    //   95	47	3	localObject1	Object
    //   35	39	4	localSimpleStringSplitter	android.text.TextUtils.SimpleStringSplitter
    //   98	11	4	localObject2	Object
    //   51	10	5	str	String
    // Exception table:
    //   from	to	target	type
    //   26	37	95	finally
    //   39	53	95	finally
    //   58	82	95	finally
    //   96	98	98	finally
    //   7	26	111	finally
    //   89	93	111	finally
    //   108	111	111	finally
    //   141	146	111	finally
    //   149	153	111	finally
    //   104	108	140	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.e
 * JD-Core Version:    0.7.0.1
 */