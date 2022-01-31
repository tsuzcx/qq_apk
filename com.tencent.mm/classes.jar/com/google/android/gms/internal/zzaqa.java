package com.google.android.gms.internal;

public abstract class zzaqa<T>
{
  private final int zzAW;
  private final String zzAX;
  private final T zzAY;
  
  private zzaqa(int paramInt, String paramString, T paramT)
  {
    this.zzAW = paramInt;
    this.zzAX = paramString;
    this.zzAY = paramT;
    zzaqe.zzDD().zza(this);
  }
  
  public static zzaqa.zza zzb(int paramInt, String paramString, Boolean paramBoolean)
  {
    return new zzaqa.zza(paramInt, paramString, paramBoolean);
  }
  
  public static zzaqa.zzb zzb(int paramInt1, String paramString, int paramInt2)
  {
    return new zzaqa.zzb(paramInt1, paramString, Integer.valueOf(paramInt2));
  }
  
  public static zzaqa.zzc zzb(int paramInt, String paramString, long paramLong)
  {
    return new zzaqa.zzc(paramInt, paramString, Long.valueOf(paramLong));
  }
  
  public static zzaqa.zzd zzc(int paramInt, String paramString1, String paramString2)
  {
    return new zzaqa.zzd(paramInt, paramString1, paramString2);
  }
  
  public T get()
  {
    return zzaqe.zzDE().zzb(this);
  }
  
  public String getKey()
  {
    return this.zzAX;
  }
  
  public int getSource()
  {
    return this.zzAW;
  }
  
  protected abstract T zza(zzaqd paramzzaqd);
  
  public T zzfr()
  {
    return this.zzAY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqa
 * JD-Core Version:    0.7.0.1
 */