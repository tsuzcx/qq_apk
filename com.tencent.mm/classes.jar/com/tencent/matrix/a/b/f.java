package com.tencent.matrix.a.b;

import java.io.IOException;
import java.util.List;

public final class f
{
  private final String eTF;
  private final int[] eTH;
  
  public f(int paramInt, int[] paramArrayOfInt)
  {
    this.eTF = ("/proc/" + paramInt + "/time_in_state");
    this.eTH = paramArrayOfInt;
  }
  
  public final void axt()
  {
    List localList = axv();
    if (this.eTH.length != localList.size()) {
      throw new IOException("Cpu clusterNum unmatched, expect = " + this.eTH.length + ", actual = " + localList.size());
    }
    int i = 0;
    while (i < localList.size())
    {
      long[] arrayOfLong = (long[])localList.get(i);
      if (this.eTH[i] != arrayOfLong.length) {
        throw new IOException("Cpu clusterStepNum unmatched, expect = " + this.eTH[i] + ", actual = " + arrayOfLong.length + ", cluster = " + i);
      }
      i += 1;
    }
  }
  
  /* Error */
  public final List<long[]> axv()
  {
    // Byte code:
    //   0: new 68	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 69	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_3
    //   11: new 71	java/io/BufferedReader
    //   14: dup
    //   15: new 73	java/io/FileReader
    //   18: dup
    //   19: aload_0
    //   20: getfield 35	com/tencent/matrix/a/b/f:eTF	Ljava/lang/String;
    //   23: invokespecial 74	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 77	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore 4
    //   31: new 79	android/text/TextUtils$SimpleStringSplitter
    //   34: dup
    //   35: bipush 32
    //   37: invokespecial 82	android/text/TextUtils$SimpleStringSplitter:<init>	(C)V
    //   40: astore 6
    //   42: iconst_m1
    //   43: istore_2
    //   44: iconst_0
    //   45: istore_1
    //   46: aload 4
    //   48: invokevirtual 85	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 7
    //   53: aload 7
    //   55: ifnull +85 -> 140
    //   58: aload 7
    //   60: ldc 87
    //   62: invokevirtual 93	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   65: ifeq +34 -> 99
    //   68: iload_2
    //   69: iflt +12 -> 81
    //   72: aload 5
    //   74: aload_3
    //   75: invokeinterface 97 2 0
    //   80: pop
    //   81: iload_2
    //   82: iconst_1
    //   83: iadd
    //   84: istore_2
    //   85: aload_0
    //   86: getfield 37	com/tencent/matrix/a/b/f:eTH	[I
    //   89: iload_2
    //   90: iaload
    //   91: newarray long
    //   93: astore_3
    //   94: iconst_0
    //   95: istore_1
    //   96: goto -50 -> 46
    //   99: iload_1
    //   100: aload_0
    //   101: getfield 37	com/tencent/matrix/a/b/f:eTH	[I
    //   104: iload_2
    //   105: iaload
    //   106: if_icmpge -60 -> 46
    //   109: aload 6
    //   111: aload 7
    //   113: invokevirtual 100	android/text/TextUtils$SimpleStringSplitter:setString	(Ljava/lang/String;)V
    //   116: aload 6
    //   118: invokevirtual 103	android/text/TextUtils$SimpleStringSplitter:next	()Ljava/lang/String;
    //   121: pop
    //   122: aload_3
    //   123: iload_1
    //   124: aload 6
    //   126: invokevirtual 103	android/text/TextUtils$SimpleStringSplitter:next	()Ljava/lang/String;
    //   129: invokestatic 109	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   132: lastore
    //   133: iload_1
    //   134: iconst_1
    //   135: iadd
    //   136: istore_1
    //   137: goto -91 -> 46
    //   140: aload 5
    //   142: aload_3
    //   143: invokeinterface 97 2 0
    //   148: pop
    //   149: aload 4
    //   151: invokevirtual 112	java/io/BufferedReader:close	()V
    //   154: aload 5
    //   156: areturn
    //   157: astore_3
    //   158: aload_3
    //   159: athrow
    //   160: astore 5
    //   162: aload_3
    //   163: ifnull +51 -> 214
    //   166: aload 4
    //   168: invokevirtual 112	java/io/BufferedReader:close	()V
    //   171: aload 5
    //   173: athrow
    //   174: astore_3
    //   175: new 51	java/io/IOException
    //   178: dup
    //   179: new 15	java/lang/StringBuilder
    //   182: dup
    //   183: ldc 114
    //   185: invokespecial 20	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload_3
    //   189: invokevirtual 119	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: aload_3
    //   199: invokespecial 122	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   202: athrow
    //   203: astore 4
    //   205: aload_3
    //   206: aload 4
    //   208: invokevirtual 126	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   211: goto -40 -> 171
    //   214: aload 4
    //   216: invokevirtual 112	java/io/BufferedReader:close	()V
    //   219: goto -48 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	f
    //   45	92	1	i	int
    //   43	62	2	j	int
    //   10	133	3	localObject1	Object
    //   157	6	3	localObject2	Object
    //   174	32	3	localThrowable1	java.lang.Throwable
    //   29	138	4	localBufferedReader	java.io.BufferedReader
    //   203	12	4	localThrowable2	java.lang.Throwable
    //   7	148	5	localArrayList	java.util.ArrayList
    //   160	12	5	localObject3	Object
    //   40	85	6	localSimpleStringSplitter	android.text.TextUtils.SimpleStringSplitter
    //   51	61	7	str	String
    // Exception table:
    //   from	to	target	type
    //   31	42	157	finally
    //   46	53	157	finally
    //   58	68	157	finally
    //   72	81	157	finally
    //   85	94	157	finally
    //   99	133	157	finally
    //   140	149	157	finally
    //   158	160	160	finally
    //   11	31	174	finally
    //   149	154	174	finally
    //   171	174	174	finally
    //   205	211	174	finally
    //   214	219	174	finally
    //   166	171	203	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.f
 * JD-Core Version:    0.7.0.1
 */