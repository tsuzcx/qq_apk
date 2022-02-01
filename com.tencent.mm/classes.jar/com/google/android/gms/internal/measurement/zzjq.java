package com.google.android.gms.internal.measurement;

abstract class zzjq
  extends zzjp
{
  private boolean zzvo;
  
  zzjq(zzjr paramzzjr)
  {
    super(paramzzjr);
    this.zzajp.zzb(this);
  }
  
  final boolean isInitialized()
  {
    return this.zzvo;
  }
  
  protected final void zzch()
  {
    if (!isInitialized()) {
      throw new IllegalStateException("Not initialized");
    }
  }
  
  protected abstract boolean zzhf();
  
  public final void zzm()
  {
    if (this.zzvo) {
      throw new IllegalStateException("Can't initialize twice");
    }
    zzhf();
    this.zzajp.zzkz();
    this.zzvo = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzjq
 * JD-Core Version:    0.7.0.1
 */