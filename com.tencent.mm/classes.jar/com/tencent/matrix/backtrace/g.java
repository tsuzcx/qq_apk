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
  private volatile a eMm;
  private final b eNj = new b();
  private boolean eNs = false;
  private volatile boolean mConfigured;
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private volatile boolean mInitialized;
  
  public static void a(d paramd)
  {
    b.eMo = paramd;
  }
  
  private static boolean awm()
  {
    String str = Build.CPU_ABI;
    return ("arm64-v8a".equalsIgnoreCase(str)) || ("x86_64".equalsIgnoreCase(str)) || ("mips64".equalsIgnoreCase(str));
  }
  
  public static String awn()
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      if (!awm()) {
        return "/apex/com.android.runtime/lib/";
      }
      return "/apex/com.android.runtime/lib64/";
    }
    if (!awm()) {
      return "/system/lib/";
    }
    return "/system/lib64/";
  }
  
  public static g awo()
  {
    return e.eNO;
  }
  
  private void awp()
  {
    if (this.eNs) {
      return;
    }
    this.eNs = false;
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
  
  public static String bP(Context paramContext)
  {
    if (!awm()) {}
    for (String str = "arm";; str = "arm64") {
      return new File(new File(paramContext.getApplicationInfo().nativeLibraryDir).getParentFile().getParentFile(), "/oat/" + str + "/base.odex").getAbsolutePath();
    }
  }
  
  static void enableLogger(boolean paramBoolean)
  {
    WeChatBacktraceNative.enableLogger(paramBoolean);
  }
  
  static void loadLibrary()
  {
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("wechatbacktrace");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/matrix/backtrace/WeChatBacktrace", "loadLibrary", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/backtrace/WeChatBacktrace", "loadLibrary", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
  }
  
  /* Error */
  public final a bQ(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 435	com/tencent/matrix/backtrace/g:eMm	Lcom/tencent/matrix/backtrace/g$a;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 435	com/tencent/matrix/backtrace/g:eMm	Lcom/tencent/matrix/backtrace/g$a;
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
    //   25: invokespecial 438	com/tencent/matrix/backtrace/g$a:<init>	(Landroid/content/Context;Lcom/tencent/matrix/backtrace/g;)V
    //   28: putfield 435	com/tencent/matrix/backtrace/g:eMm	Lcom/tencent/matrix/backtrace/g$a;
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 73	com/tencent/matrix/backtrace/g:mInitialized	Z
    //   36: aload_0
    //   37: getfield 435	com/tencent/matrix/backtrace/g:eMm	Lcom/tencent/matrix/backtrace/g$a;
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
    public boolean bBe = false;
    long eMQ = 3000L;
    String eMi;
    boolean eNA = true;
    boolean eNB = false;
    boolean eNC = true;
    g.f eND = g.f.eNP;
    boolean eNE = false;
    boolean eNF = false;
    String eNG = null;
    public final g eNH;
    HashSet<String> eNv = new HashSet();
    g.d eNw = g.d.eNJ;
    g.c eNx = null;
    boolean eNy = false;
    public boolean eNz = false;
    Context mContext;
    
    a(Context paramContext, g paramg)
    {
      this.mContext = paramContext;
      this.eNH = paramg;
      this.eNv.add(paramContext.getApplicationInfo().nativeLibraryDir);
      this.eNv.add(g.awn());
      this.eNv.add(g.bP(paramContext));
      this.eNB = a.bE(this.mContext);
    }
    
    public final a awq()
    {
      if (this.bBe) {
        return this;
      }
      this.eNv.clear();
      return this;
    }
    
    public final a awr()
    {
      if (this.bBe) {
        return this;
      }
      this.eNE = false;
      return this;
    }
    
    public final a aws()
    {
      if (this.bBe) {
        return this;
      }
      this.eNF = true;
      return this;
    }
    
    public final a b(g.d paramd)
    {
      if (this.bBe) {}
      while (paramd == null) {
        return this;
      }
      this.eNw = paramd;
      return this;
    }
    
    public final a dw(boolean paramBoolean)
    {
      if (this.bBe) {
        return this;
      }
      this.eNy = paramBoolean;
      return this;
    }
    
    public final a gj(String paramString)
    {
      if (this.bBe) {
        return this;
      }
      this.eNv.add(paramString);
      return this;
    }
    
    public final a gk(String paramString)
    {
      if (this.bBe) {
        return this;
      }
      this.eNG = paramString;
      return this;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("\nWeChat backtrace configurations: \n>>> Backtrace Mode: ").append(this.eNw).append("\n>>> Quicken always on: ").append(this.eNz).append("\n>>> Saving Path: ");
      Object localObject;
      if (this.eMi != null)
      {
        localObject = this.eMi;
        localObject = localStringBuilder.append((String)localObject).append("\n>>> Custom Library Loader: ");
        if (this.eNx == null) {
          break label211;
        }
      }
      label211:
      for (boolean bool = true;; bool = false)
      {
        return bool + "\n>>> Directories to Warm-up: " + this.eNv.toString() + "\n>>> Is Warm-up Process: " + this.eNB + "\n>>> Warm-up Timing: " + this.eND + "\n>>> Warm-up Delay: " + this.eMQ + "ms\n>>> Warm-up in isolate process: " + this.eNC + "\n>>> Enable logger: " + this.eNE + "\n>>> Enable Isolate Process logger: " + this.eNF + "\n>>> Path of XLog: " + this.eNG + "\n>>> Cool-down: " + this.eNy + "\n>>> Cool-down if Apk Updated: " + this.eNA + "\n";
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
      switch (g.2.eNu[ordinal()])
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
    public static final g eNO = new g();
  }
  
  public static enum f
  {
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.backtrace.g
 * JD-Core Version:    0.7.0.1
 */