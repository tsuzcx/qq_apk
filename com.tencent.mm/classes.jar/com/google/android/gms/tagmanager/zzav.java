package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzav
  extends Thread
  implements zzau
{
  private static zzav zzbGu;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private volatile boolean zzNA = false;
  private final LinkedBlockingQueue<Runnable> zzbGt = new LinkedBlockingQueue();
  private volatile zzaw zzbGv;
  
  private zzav(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      start();
      return;
    }
  }
  
  static zzav zzca(Context paramContext)
  {
    if (zzbGu == null) {
      zzbGu = new zzav(paramContext);
    }
    return zzbGu;
  }
  
  private String zzg(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public void run()
  {
    for (;;)
    {
      boolean bool = this.mClosed;
      try
      {
        Runnable localRunnable = (Runnable)this.zzbGt.take();
        if (!this.zzNA) {
          localRunnable.run();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        zzbo.zzbg(localInterruptedException.toString());
      }
      catch (Throwable localThrowable)
      {
        str = String.valueOf(zzg(localThrowable));
        if (str.length() == 0) {}
      }
    }
    for (String str = "Error on Google TagManager Thread: ".concat(str);; str = new String("Error on Google TagManager Thread: "))
    {
      zzbo.e(str);
      zzbo.e("Google TagManager is shutting down.");
      this.zzNA = true;
      break;
    }
  }
  
  public void zzhj(String paramString)
  {
    zzp(paramString, System.currentTimeMillis());
  }
  
  public void zzp(Runnable paramRunnable)
  {
    this.zzbGt.add(paramRunnable);
  }
  
  void zzp(String paramString, long paramLong)
  {
    zzp(new zzav.1(this, this, paramLong, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzav
 * JD-Core Version:    0.7.0.1
 */