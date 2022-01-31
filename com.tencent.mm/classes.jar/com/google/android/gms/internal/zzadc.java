package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zzadc
  implements ThreadFactory
{
  private final int mPriority;
  private final String zzaIv;
  private final AtomicInteger zzaIw = new AtomicInteger();
  private final ThreadFactory zzaIx = Executors.defaultThreadFactory();
  
  public zzadc(String paramString)
  {
    this(paramString, 0);
  }
  
  public zzadc(String paramString, int paramInt)
  {
    this.zzaIv = ((String)zzac.zzb(paramString, "Name must not be null"));
    this.mPriority = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = this.zzaIx.newThread(new zzadd(paramRunnable, this.mPriority));
    String str = this.zzaIv;
    int i = this.zzaIw.getAndIncrement();
    paramRunnable.setName(String.valueOf(str).length() + 13 + str + "[" + i + "]");
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzadc
 * JD-Core Version:    0.7.0.1
 */