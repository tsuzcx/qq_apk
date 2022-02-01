package com.tencent.liteav.basic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class g
{
  protected static volatile g a;
  private final String b;
  private SharedPreferences c;
  private final Object d;
  private Context e;
  
  private g()
  {
    AppMethodBeat.i(240222);
    this.b = "TXCSpUtil";
    this.d = new Object();
    AppMethodBeat.o(240222);
  }
  
  public static g a()
  {
    AppMethodBeat.i(240220);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new g();
      }
      g localg = a;
      AppMethodBeat.o(240220);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(240220);
    }
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(240225);
    this.e = paramContext.getApplicationContext();
    AppMethodBeat.o(240225);
  }
  
  public void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(240237);
    Context localContext = this.e;
    try
    {
      synchronized (this.d)
      {
        if ((this.c == null) && (localContext != null)) {
          this.c = localContext.getSharedPreferences("liteav_hw_encoder_config", 0);
        }
        if (this.c != null) {
          this.c.edit().putInt(paramString, paramInt).commit();
        }
        AppMethodBeat.o(240237);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCSpUtil", "setLastEncodeType: error: " + paramString + " , " + paramInt + " ; " + localException);
      AppMethodBeat.o(240237);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(240229);
    Context localContext = this.e;
    try
    {
      synchronized (this.d)
      {
        if ((this.c == null) && (localContext != null)) {
          this.c = localContext.getSharedPreferences("liteav_hw_encoder_config", 0);
        }
        if (this.c != null) {
          this.c.edit().putBoolean(paramString, paramBoolean).commit();
        }
        AppMethodBeat.o(240229);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCSpUtil", "saveConfigInfo: error: " + paramString + ", " + paramBoolean + " ; " + localException);
      AppMethodBeat.o(240229);
    }
  }
  
  /* Error */
  public int b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 125
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 52	com/tencent/liteav/basic/util/g:e	Landroid/content/Context;
    //   9: astore 5
    //   11: aload_0
    //   12: getfield 33	com/tencent/liteav/basic/util/g:d	Ljava/lang/Object;
    //   15: astore 4
    //   17: aload 4
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 58	com/tencent/liteav/basic/util/g:c	Landroid/content/SharedPreferences;
    //   24: ifnonnull +20 -> 44
    //   27: aload 5
    //   29: ifnull +15 -> 44
    //   32: aload_0
    //   33: aload 5
    //   35: ldc 60
    //   37: iconst_0
    //   38: invokevirtual 64	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   41: putfield 58	com/tencent/liteav/basic/util/g:c	Landroid/content/SharedPreferences;
    //   44: aload_0
    //   45: getfield 58	com/tencent/liteav/basic/util/g:c	Landroid/content/SharedPreferences;
    //   48: ifnull +25 -> 73
    //   51: aload_0
    //   52: getfield 58	com/tencent/liteav/basic/util/g:c	Landroid/content/SharedPreferences;
    //   55: aload_1
    //   56: iload_2
    //   57: invokeinterface 128 3 0
    //   62: istore_3
    //   63: aload 4
    //   65: monitorexit
    //   66: ldc 125
    //   68: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iload_3
    //   72: ireturn
    //   73: aload 4
    //   75: monitorexit
    //   76: ldc 125
    //   78: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iload_2
    //   82: ireturn
    //   83: astore_1
    //   84: aload 4
    //   86: monitorexit
    //   87: ldc 125
    //   89: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: athrow
    //   94: astore_1
    //   95: ldc 29
    //   97: ldc 130
    //   99: aload_1
    //   100: invokestatic 133	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: goto -27 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	g
    //   0	106	1	paramString	String
    //   0	106	2	paramInt	int
    //   62	10	3	i	int
    //   9	25	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   20	27	83	finally
    //   32	44	83	finally
    //   44	66	83	finally
    //   11	20	94	java/lang/Exception
    //   73	76	94	java/lang/Exception
    //   84	94	94	java/lang/Exception
  }
  
  /* Error */
  public boolean b(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 135
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 52	com/tencent/liteav/basic/util/g:e	Landroid/content/Context;
    //   9: astore 5
    //   11: aload_0
    //   12: getfield 33	com/tencent/liteav/basic/util/g:d	Ljava/lang/Object;
    //   15: astore 4
    //   17: aload 4
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 58	com/tencent/liteav/basic/util/g:c	Landroid/content/SharedPreferences;
    //   24: ifnonnull +20 -> 44
    //   27: aload 5
    //   29: ifnull +15 -> 44
    //   32: aload_0
    //   33: aload 5
    //   35: ldc 60
    //   37: iconst_0
    //   38: invokevirtual 64	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   41: putfield 58	com/tencent/liteav/basic/util/g:c	Landroid/content/SharedPreferences;
    //   44: aload_0
    //   45: getfield 58	com/tencent/liteav/basic/util/g:c	Landroid/content/SharedPreferences;
    //   48: ifnull +25 -> 73
    //   51: aload_0
    //   52: getfield 58	com/tencent/liteav/basic/util/g:c	Landroid/content/SharedPreferences;
    //   55: aload_1
    //   56: iload_2
    //   57: invokeinterface 138 3 0
    //   62: istore_3
    //   63: aload 4
    //   65: monitorexit
    //   66: ldc 135
    //   68: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iload_3
    //   72: ireturn
    //   73: aload 4
    //   75: monitorexit
    //   76: ldc 135
    //   78: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iload_2
    //   82: ireturn
    //   83: astore 5
    //   85: aload 4
    //   87: monitorexit
    //   88: ldc 135
    //   90: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload 5
    //   95: athrow
    //   96: astore 4
    //   98: ldc 29
    //   100: new 82	java/lang/StringBuilder
    //   103: dup
    //   104: ldc 118
    //   106: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc 120
    //   115: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload_2
    //   119: invokevirtual 123	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   122: ldc 98
    //   124: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 4
    //   129: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 110	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: goto -62 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	g
    //   0	141	1	paramString	String
    //   0	141	2	paramBoolean	boolean
    //   62	10	3	bool	boolean
    //   96	32	4	localException	Exception
    //   9	25	5	localContext	Context
    //   83	11	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	27	83	finally
    //   32	44	83	finally
    //   44	66	83	finally
    //   11	20	96	java/lang/Exception
    //   73	76	96	java/lang/Exception
    //   85	96	96	java/lang/Exception
  }
  
  public static enum a
  {
    private final int value;
    
    static
    {
      AppMethodBeat.i(240980);
      a = new a("CODEC_TYPE_H264", 0, 0);
      b = new a("CODEC_TYPE_H265", 1, 1);
      c = new a[] { a, b };
      AppMethodBeat.o(240980);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a a(int paramInt)
    {
      AppMethodBeat.i(240979);
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        a locala = localObject[i];
        if (locala.a() == paramInt)
        {
          AppMethodBeat.o(240979);
          return locala;
        }
        i += 1;
      }
      localObject = a;
      AppMethodBeat.o(240979);
      return localObject;
    }
    
    public final int a()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.g
 * JD-Core Version:    0.7.0.1
 */