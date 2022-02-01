package com.tencent.matrix.backtrace;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.util.HashSet;

public final class g
{
  private static boolean sLibraryLoaded = false;
  private volatile a cQV;
  private b cRS = new b();
  private boolean cSb = false;
  private volatile boolean mConfigured;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private volatile boolean mInitialized;
  
  public static String VD()
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      if (!is64BitRuntime()) {
        return "/apex/com.android.runtime/lib/";
      }
      return "/apex/com.android.runtime/lib64/";
    }
    if (!is64BitRuntime()) {
      return "/system/lib/";
    }
    return "/system/lib64/";
  }
  
  public static g VE()
  {
    return e.cSy;
  }
  
  private void VF()
  {
    if (this.cSb) {
      return;
    }
    this.cSb = false;
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        g.a(g.this);
        g.b(g.this);
        g.c(g.this);
      }
    }, 21600000L);
  }
  
  public static void a(d paramd)
  {
    b.cQX = paramd;
  }
  
  public static String bf(Context paramContext)
  {
    if (!is64BitRuntime()) {}
    for (String str = "arm";; str = "arm64") {
      return new File(new File(paramContext.getApplicationInfo().nativeLibraryDir).getParentFile().getParentFile(), "/oat/" + str + "/base.odex").getAbsolutePath();
    }
  }
  
  static void enableLogger(boolean paramBoolean)
  {
    WeChatBacktraceNative.enableLogger(paramBoolean);
  }
  
  private static boolean is64BitRuntime()
  {
    String str = Build.CPU_ABI;
    return ("arm64-v8a".equalsIgnoreCase(str)) || ("x86_64".equalsIgnoreCase(str)) || ("mips64".equalsIgnoreCase(str));
  }
  
  static void loadLibrary()
  {
    System.loadLibrary("wechatbacktrace");
  }
  
  /* Error */
  public final a bg(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 409	com/tencent/matrix/backtrace/g:cQV	Lcom/tencent/matrix/backtrace/g$a;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 409	com/tencent/matrix/backtrace/g:cQV	Lcom/tencent/matrix/backtrace/g$a;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: new 10	com/tencent/matrix/backtrace/g$a
    //   22: dup
    //   23: aload_1
    //   24: aload_0
    //   25: invokespecial 412	com/tencent/matrix/backtrace/g$a:<init>	(Landroid/content/Context;Lcom/tencent/matrix/backtrace/g;)V
    //   28: putfield 409	com/tencent/matrix/backtrace/g:cQV	Lcom/tencent/matrix/backtrace/g$a;
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 108	com/tencent/matrix/backtrace/g:mInitialized	Z
    //   36: aload_0
    //   37: getfield 409	com/tencent/matrix/backtrace/g:cQV	Lcom/tencent/matrix/backtrace/g$a;
    //   40: astore_1
    //   41: goto -27 -> 14
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	g
    //   0	49	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   18	41	44	finally
  }
  
  public static final class a
  {
    public boolean UY = false;
    String cQR;
    long cRz = 3000L;
    HashSet<String> cSe = new HashSet();
    g.d cSf = g.d.cSt;
    g.c cSg = null;
    boolean cSh = false;
    public boolean cSi = false;
    boolean cSj = true;
    boolean cSk = false;
    boolean cSl = false;
    boolean cSm = true;
    g.f cSn = g.f.cSz;
    boolean cSo = false;
    boolean cSp = false;
    String cSq = null;
    public g cSr;
    Context mContext;
    
    a(Context paramContext, g paramg)
    {
      this.mContext = paramContext;
      this.cSr = paramg;
      this.cSe.add(paramContext.getApplicationInfo().nativeLibraryDir);
      this.cSe.add(g.VD());
      this.cSe.add(g.bf(paramContext));
      this.cSk = a.aU(this.mContext);
    }
    
    public final a VG()
    {
      if (this.UY) {
        return this;
      }
      this.cSe.clear();
      return this;
    }
    
    public final a VH()
    {
      if (this.UY) {
        return this;
      }
      this.cSo = false;
      return this;
    }
    
    public final a VI()
    {
      if (this.UY) {
        return this;
      }
      this.cSp = true;
      return this;
    }
    
    public final a b(g.d paramd)
    {
      if (this.UY) {}
      while (paramd == null) {
        return this;
      }
      this.cSf = paramd;
      return this;
    }
    
    public final a cP(boolean paramBoolean)
    {
      if (this.UY) {
        return this;
      }
      this.cSh = paramBoolean;
      return this;
    }
    
    public final a eK(String paramString)
    {
      if (this.UY) {
        return this;
      }
      this.cSe.add(paramString);
      return this;
    }
    
    public final a eL(String paramString)
    {
      if (this.UY) {
        return this;
      }
      this.cSq = paramString;
      return this;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("\nWeChat backtrace configurations: \n>>> Backtrace Mode: ").append(this.cSf).append("\n>>> Quicken always on: ").append(this.cSi).append("\n>>> Saving Path: ");
      Object localObject;
      if (this.cQR != null)
      {
        localObject = this.cQR;
        localObject = localStringBuilder.append((String)localObject).append("\n>>> Custom Library Loader: ");
        if (this.cSg == null) {
          break label223;
        }
      }
      label223:
      for (boolean bool = true;; bool = false)
      {
        return bool + "\n>>> Directories to Warm-up: " + this.cSe.toString() + "\n>>> Is Warm-up Process: " + this.cSk + "\n>>> Warm-up Timing: " + this.cSn + "\n>>> Warm-up Delay: " + this.cRz + "ms\n>>> Warm-up in isolate process: " + this.cSm + "\n>>> Invoke quicken generation immediately: " + this.cSl + "\n>>> Enable logger: " + this.cSo + "\n>>> Enable Isolate Process logger: " + this.cSp + "\n>>> Path of XLog: " + this.cSq + "\n>>> Cool-down: " + this.cSh + "\n>>> Cool-down if Apk Updated: " + this.cSj + "\n";
        localObject = f.a(this);
        break;
      }
    }
  }
  
  public static final class b
    extends RuntimeException
  {
    public b(String paramString)
    {
      super();
    }
  }
  
  public static abstract interface c {}
  
  public static enum d
  {
    int value;
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
    
    public final String toString()
    {
      switch (g.2.cSd[ordinal()])
      {
      default: 
        return "Unreachable.";
      case 1: 
        return "FramePointer-based.";
      case 2: 
        return "WeChat QuickenUnwindTable-based.";
      case 3: 
        return "Dwarf-based.";
      case 4: 
        return "Use fp-based backtrace before quicken has warmed up.";
      }
      return "Use dwarf-based backtrace before quicken has warmed up.";
    }
  }
  
  static final class e
  {
    public static final g cSy = new g();
  }
  
  public static enum f
  {
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.backtrace.g
 * JD-Core Version:    0.7.0.1
 */