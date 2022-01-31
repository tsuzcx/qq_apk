package com.google.android.gms.internal;

public abstract class zzsa
  extends zzrz
{
  private boolean zzadP;
  
  public zzsa(zzsc paramzzsc)
  {
    super(paramzzsc);
  }
  
  public void initialize()
  {
    zzmS();
    this.zzadP = true;
  }
  
  public boolean isInitialized()
  {
    return this.zzadP;
  }
  
  public abstract void zzmS();
  
  public void zzob()
  {
    if (!isInitialized()) {
      throw new IllegalStateException("Not initialized");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzsa
 * JD-Core Version:    0.7.0.1
 */