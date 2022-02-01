package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.util.Arrays;

public class TbsCoreLoadStat
{
  private static TbsCoreLoadStat d = null;
  public static volatile int mLoadErrorCode = -1;
  private TbsSequenceQueue a = null;
  private boolean b = false;
  private final int c = 3;
  
  public static TbsCoreLoadStat getInstance()
  {
    if (d == null) {
      d = new TbsCoreLoadStat();
    }
    return d;
  }
  
  void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, null);
    TbsLog.e("loaderror", "" + paramInt);
  }
  
  /* Error */
  void a(Context paramContext, int paramInt, java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 65
    //   4: new 43	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   11: ldc 67
    //   13: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: iload_2
    //   17: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc 69
    //   22: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_3
    //   26: invokestatic 75	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_3
    //   39: ifnull +49 -> 88
    //   42: getstatic 20	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   45: iconst_m1
    //   46: if_icmpne +45 -> 91
    //   49: iload_2
    //   50: putstatic 20	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   53: aload_1
    //   54: invokestatic 80	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   57: iload_2
    //   58: aload_3
    //   59: invokevirtual 84	com/tencent/smtt/sdk/TbsLogReport:setLoadErrorCode	(ILjava/lang/Throwable;)V
    //   62: ldc 65
    //   64: new 43	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   71: getstatic 20	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   74: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: ldc 86
    //   79: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 89	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: ldc 65
    //   93: new 43	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   100: getstatic 20	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   103: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: ldc 91
    //   108: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 94	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: goto -29 -> 88
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	TbsCoreLoadStat
    //   0	125	1	paramContext	Context
    //   0	125	2	paramInt	int
    //   0	125	3	paramThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	38	120	finally
    //   42	88	120	finally
    //   91	117	120	finally
  }
  
  public class TbsSequenceQueue
  {
    private int b = 10;
    private int c;
    private int[] d;
    private int e = 0;
    private int f = 0;
    
    public TbsSequenceQueue()
    {
      this.c = this.b;
      this.d = new int[this.c];
    }
    
    public TbsSequenceQueue(int paramInt1, int paramInt2)
    {
      this.c = paramInt2;
      this.d = new int[this.c];
      this.d[0] = paramInt1;
      this.f += 1;
    }
    
    public void add(int paramInt)
    {
      if (this.f > this.c - 1) {
        throw new IndexOutOfBoundsException("sequeue is full");
      }
      int[] arrayOfInt = this.d;
      int i = this.f;
      this.f = (i + 1);
      arrayOfInt[i] = paramInt;
    }
    
    public void clear()
    {
      Arrays.fill(this.d, 0);
      this.e = 0;
      this.f = 0;
    }
    
    public int element()
    {
      if (empty()) {
        throw new IndexOutOfBoundsException("sequeue is null");
      }
      return this.d[this.e];
    }
    
    public boolean empty()
    {
      return this.f == this.e;
    }
    
    public int length()
    {
      return this.f - this.e;
    }
    
    public int remove()
    {
      if (empty()) {
        throw new IndexOutOfBoundsException("sequeue is null");
      }
      int i = this.d[this.e];
      int[] arrayOfInt = this.d;
      int j = this.e;
      this.e = (j + 1);
      arrayOfInt[j] = 0;
      return i;
    }
    
    public String toString()
    {
      if (empty()) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder("[");
      int i = this.e;
      while (i < this.f)
      {
        localStringBuilder.append(String.valueOf(this.d[i]) + ",");
        i += 1;
      }
      i = localStringBuilder.length();
      return "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreLoadStat
 * JD-Core Version:    0.7.0.1
 */