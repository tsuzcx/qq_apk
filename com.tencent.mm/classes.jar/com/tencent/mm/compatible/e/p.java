package com.tencent.mm.compatible.e;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class p
{
  private RandomAccessFile dxS;
  private RandomAccessFile dxT;
  private a dxU;
  private ArrayList<a> dxV;
  private long pid = 0L;
  
  public p() {}
  
  public p(long paramLong)
  {
    this.pid = paramLong;
  }
  
  private void update()
  {
    for (;;)
    {
      try
      {
        this.dxS = new RandomAccessFile("/proc/stat", "r");
        if (this.pid > 0L) {
          this.dxT = new RandomAccessFile("/proc/" + this.pid + "/stat", "r");
        }
        zb();
        if (this.dxS != null) {
          this.dxS.close();
        }
        if (this.dxT != null) {
          this.dxT.close();
        }
        return;
      }
      catch (Exception localException1)
      {
        y.printErrStackTrace(" MicroMsg.CpuUsage", localException1, "update e:", new Object[0]);
        if (this.dxS == null) {}
      }
      try
      {
        this.dxS.close();
        label121:
        this.dxS = null;
        if (this.dxT == null) {
          continue;
        }
        try
        {
          this.dxT.close();
          label140:
          this.dxT = null;
          return;
        }
        catch (Exception localException2)
        {
          break label140;
        }
      }
      catch (Exception localException3)
      {
        break label121;
      }
    }
  }
  
  /* Error */
  private void zb()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	com/tencent/mm/compatible/e/p:dxT	Ljava/io/RandomAccessFile;
    //   4: ifnull +141 -> 145
    //   7: aload_0
    //   8: getfield 61	com/tencent/mm/compatible/e/p:dxT	Ljava/io/RandomAccessFile;
    //   11: lconst_0
    //   12: invokevirtual 82	java/io/RandomAccessFile:seek	(J)V
    //   15: aload_0
    //   16: getfield 61	com/tencent/mm/compatible/e/p:dxT	Ljava/io/RandomAccessFile;
    //   19: invokevirtual 85	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   22: astore_2
    //   23: aload_0
    //   24: getfield 39	com/tencent/mm/compatible/e/p:dxS	Ljava/io/RandomAccessFile;
    //   27: ifnull +95 -> 122
    //   30: aload_0
    //   31: getfield 39	com/tencent/mm/compatible/e/p:dxS	Ljava/io/RandomAccessFile;
    //   34: lconst_0
    //   35: invokevirtual 82	java/io/RandomAccessFile:seek	(J)V
    //   38: iconst_m1
    //   39: istore_1
    //   40: aload_0
    //   41: getfield 39	com/tencent/mm/compatible/e/p:dxS	Ljava/io/RandomAccessFile;
    //   44: invokevirtual 85	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +202 -> 251
    //   52: aload_3
    //   53: invokevirtual 91	java/lang/String:length	()I
    //   56: ifle +195 -> 251
    //   59: aload_3
    //   60: ldc 93
    //   62: invokevirtual 97	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   65: astore 4
    //   67: aload 4
    //   69: iconst_0
    //   70: aaload
    //   71: ldc 99
    //   73: invokevirtual 103	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   76: iconst_m1
    //   77: if_icmpeq +41 -> 118
    //   80: iload_1
    //   81: iconst_m1
    //   82: if_icmpne +68 -> 150
    //   85: aload_0
    //   86: getfield 105	com/tencent/mm/compatible/e/p:dxU	Lcom/tencent/mm/compatible/e/p$a;
    //   89: ifnonnull +19 -> 108
    //   92: aload_0
    //   93: new 6	com/tencent/mm/compatible/e/p$a
    //   96: dup
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 23	com/tencent/mm/compatible/e/p:pid	J
    //   102: invokespecial 108	com/tencent/mm/compatible/e/p$a:<init>	(Lcom/tencent/mm/compatible/e/p;J)V
    //   105: putfield 105	com/tencent/mm/compatible/e/p:dxU	Lcom/tencent/mm/compatible/e/p$a;
    //   108: aload_0
    //   109: getfield 105	com/tencent/mm/compatible/e/p:dxU	Lcom/tencent/mm/compatible/e/p$a;
    //   112: aload 4
    //   114: aload_2
    //   115: invokevirtual 111	com/tencent/mm/compatible/e/p$a:a	([Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_3
    //   119: ifnonnull +153 -> 272
    //   122: return
    //   123: astore_2
    //   124: ldc 69
    //   126: new 41	java/lang/StringBuilder
    //   129: dup
    //   130: ldc 113
    //   132: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_2
    //   136: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 119	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aconst_null
    //   146: astore_2
    //   147: goto -124 -> 23
    //   150: aload_0
    //   151: getfield 121	com/tencent/mm/compatible/e/p:dxV	Ljava/util/ArrayList;
    //   154: ifnonnull +14 -> 168
    //   157: aload_0
    //   158: new 123	java/util/ArrayList
    //   161: dup
    //   162: invokespecial 124	java/util/ArrayList:<init>	()V
    //   165: putfield 121	com/tencent/mm/compatible/e/p:dxV	Ljava/util/ArrayList;
    //   168: iload_1
    //   169: aload_0
    //   170: getfield 121	com/tencent/mm/compatible/e/p:dxV	Ljava/util/ArrayList;
    //   173: invokevirtual 127	java/util/ArrayList:size	()I
    //   176: if_icmpge +45 -> 221
    //   179: aload_0
    //   180: getfield 121	com/tencent/mm/compatible/e/p:dxV	Ljava/util/ArrayList;
    //   183: iload_1
    //   184: invokevirtual 131	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   187: checkcast 6	com/tencent/mm/compatible/e/p$a
    //   190: aload 4
    //   192: invokevirtual 135	com/tencent/mm/compatible/e/p$a:g	([Ljava/lang/String;)V
    //   195: goto -77 -> 118
    //   198: astore_2
    //   199: ldc 69
    //   201: new 41	java/lang/StringBuilder
    //   204: dup
    //   205: ldc 137
    //   207: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   210: aload_2
    //   211: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 119	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: return
    //   221: new 6	com/tencent/mm/compatible/e/p$a
    //   224: dup
    //   225: aload_0
    //   226: invokespecial 140	com/tencent/mm/compatible/e/p$a:<init>	(Lcom/tencent/mm/compatible/e/p;)V
    //   229: astore 5
    //   231: aload 5
    //   233: aload 4
    //   235: invokevirtual 135	com/tencent/mm/compatible/e/p$a:g	([Ljava/lang/String;)V
    //   238: aload_0
    //   239: getfield 121	com/tencent/mm/compatible/e/p:dxV	Ljava/util/ArrayList;
    //   242: aload 5
    //   244: invokevirtual 144	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   247: pop
    //   248: goto -130 -> 118
    //   251: ldc 69
    //   253: ldc 146
    //   255: iconst_1
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: iload_1
    //   262: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: invokestatic 155	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: goto -151 -> 118
    //   272: iload_1
    //   273: iconst_1
    //   274: iadd
    //   275: istore_1
    //   276: goto -236 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	p
    //   39	237	1	i	int
    //   22	93	2	str1	String
    //   123	13	2	localIOException1	java.io.IOException
    //   146	1	2	localObject	Object
    //   198	13	2	localIOException2	java.io.IOException
    //   47	72	3	str2	String
    //   65	169	4	arrayOfString	String[]
    //   229	14	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   7	23	123	java/io/IOException
    //   30	38	198	java/io/IOException
    //   40	48	198	java/io/IOException
    //   52	80	198	java/io/IOException
    //   85	108	198	java/io/IOException
    //   108	118	198	java/io/IOException
    //   150	168	198	java/io/IOException
    //   168	195	198	java/io/IOException
    //   221	248	198	java/io/IOException
    //   251	269	198	java/io/IOException
  }
  
  public final String toString()
  {
    update();
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.dxU != null)
    {
      localStringBuffer.append("Cpu Total : ");
      localStringBuffer.append(this.dxU.dxW);
      localStringBuffer.append("%");
      if (this.pid > 0L)
      {
        localStringBuffer.append("pid(");
        localStringBuffer.append(this.pid + ") :");
        localStringBuffer.append(this.dxU.dya);
        localStringBuffer.append("%");
      }
    }
    if (this.dxV != null)
    {
      int i = 0;
      while (i < this.dxV.size())
      {
        a locala = (a)this.dxV.get(i);
        localStringBuffer.append(" Cpu Core(" + i + ") : ");
        localStringBuffer.append(locala.dxW);
        localStringBuffer.append("%");
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public final int zc()
  {
    if (bk.dk(this.dxV)) {
      return 1;
    }
    return this.dxV.size();
  }
  
  public final int zd()
  {
    update();
    int i = 0;
    if (this.dxU != null) {
      i = this.dxU.dxW;
    }
    return i;
  }
  
  public final int ze()
  {
    int i = 0;
    if (this.dxU != null) {
      i = this.dxU.dya;
    }
    int j = i;
    if (this.dxV != null)
    {
      j = i;
      if (this.dxV.size() > 1) {
        j = i * this.dxV.size();
      }
    }
    return j;
  }
  
  public final class a
  {
    int dxW;
    long dxX;
    long dxY;
    long dxZ;
    int dya;
    long mLastIdle;
    
    public a()
    {
      this.dxW = 0;
      this.dxX = 0L;
      this.mLastIdle = 0L;
      this.dxY = 0L;
      this.dxZ = 0L;
      this.dya = 0;
    }
    
    public a(long paramLong)
    {
      this.dxY = paramLong;
    }
    
    public final void a(String[] paramArrayOfString, String paramString)
    {
      if (this.dxY <= 0L)
      {
        g(paramArrayOfString);
        return;
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        String[] arrayOfString = paramString.split("[ ]+");
        if ((arrayOfString != null) && (arrayOfString.length > 0) && (arrayOfString[0] != null) && (Long.parseLong(arrayOfString[0], 10) == this.dxY))
        {
          long l2 = Long.parseLong(arrayOfString[13], 10);
          long l3 = Long.parseLong(arrayOfString[14], 10);
          long l4 = Long.parseLong(arrayOfString[15], 10);
          long l5 = Long.parseLong(arrayOfString[16], 10);
          long l6 = l2 + l3 + l4 + l5;
          long l7 = Long.parseLong(paramArrayOfString[4], 10);
          long l1 = 0L;
          int j = 1;
          int k = paramArrayOfString.length;
          int i = 0;
          if (i < k)
          {
            paramString = paramArrayOfString[i];
            if (j != 0) {
              j = 0;
            }
            for (;;)
            {
              i += 1;
              break;
              l1 += Long.parseLong(paramString, 10);
            }
          }
          long l8 = l7 - this.mLastIdle;
          long l9 = l1 - this.dxX;
          long l10 = l6 - this.dxZ;
          this.dxW = ((int)((float)(l9 - l8) / (float)l9 * 100.0F));
          this.dya = ((int)((float)l10 / (float)l9 * 100.0F));
          this.dxX = l1;
          this.mLastIdle = l7;
          this.dxZ = l6;
          y.i(" MicroMsg.CpuUsage", "CpuUsageInfo(%d) CPU total=%d idle=%d usage=%d pid=%d pidTotal=%d mPidUsage=%d [%d, %d, %d, %d], [%d, %d, %d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l1), Long.valueOf(l7), Integer.valueOf(this.dxW), Long.valueOf(this.dxY), Long.valueOf(l6), Integer.valueOf(this.dya), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l9), Long.valueOf(l8), Long.valueOf(l10) });
          return;
        }
      }
      y.e(" MicroMsg.CpuUsage", "update but pid not match[%d, %s] update nothing", new Object[] { Long.valueOf(this.dxY), paramString });
    }
    
    public final void g(String[] paramArrayOfString)
    {
      long l2 = Long.parseLong(paramArrayOfString[4], 10);
      long l1 = 0L;
      int j = 1;
      int k = paramArrayOfString.length;
      int i = 0;
      if (i < k)
      {
        String str = paramArrayOfString[i];
        if (j != 0) {
          j = 0;
        }
        for (;;)
        {
          i += 1;
          break;
          l1 += Long.parseLong(str, 10);
        }
      }
      long l3 = this.mLastIdle;
      long l4 = l1 - this.dxX;
      this.dxW = ((int)((float)(l4 - (l2 - l3)) / (float)l4 * 100.0F));
      this.dxX = l1;
      this.mLastIdle = l2;
      y.i(" MicroMsg.CpuUsage", "CpuUsageInfo(" + hashCode() + ") CPU total=" + l1 + "; idle=" + l2 + "; usage=" + this.dxW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.p
 * JD-Core Version:    0.7.0.1
 */