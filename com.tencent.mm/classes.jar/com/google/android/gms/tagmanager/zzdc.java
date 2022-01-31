package com.google.android.gms.tagmanager;

import android.content.Context;

class zzdc
  extends zzdb
{
  private static final Object zzbIe = new Object();
  private static zzdc zzbIq;
  private boolean connected = true;
  private Context zzbIf;
  private zzaw zzbIg;
  private volatile zzau zzbIh;
  private int zzbIi = 1800000;
  private boolean zzbIj = true;
  private boolean zzbIk = false;
  private boolean zzbIl = true;
  private zzax zzbIm = new zzax()
  {
    public void zzaS(boolean paramAnonymousBoolean)
    {
      zzdc.this.zze(paramAnonymousBoolean, zzdc.zzd(zzdc.this));
    }
  };
  private zzdc.zza zzbIn;
  private zzbt zzbIo;
  private boolean zzbIp = false;
  
  private boolean isPowerSaveMode()
  {
    return (this.zzbIp) || (!this.connected) || (this.zzbIi <= 0);
  }
  
  public static zzdc zzRx()
  {
    if (zzbIq == null) {
      zzbIq = new zzdc();
    }
    return zzbIq;
  }
  
  private void zzRy()
  {
    this.zzbIo = new zzbt(this);
    this.zzbIo.zzcb(this.zzbIf);
  }
  
  private void zzRz()
  {
    this.zzbIn = new zzdc.zzb(this, null);
    if (this.zzbIi > 0) {
      this.zzbIn.zzy(this.zzbIi);
    }
  }
  
  private void zzoH()
  {
    if (isPowerSaveMode())
    {
      this.zzbIn.cancel();
      zzbo.v("PowerSaveMode initiated.");
      return;
    }
    this.zzbIn.zzy(this.zzbIi);
    zzbo.v("PowerSaveMode terminated.");
  }
  
  /* Error */
  public void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/google/android/gms/tagmanager/zzdc:zzbIk	Z
    //   6: ifne +16 -> 22
    //   9: ldc 126
    //   11: invokestatic 121	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 50	com/google/android/gms/tagmanager/zzdc:zzbIj	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 128	com/google/android/gms/tagmanager/zzdc:zzbIh	Lcom/google/android/gms/tagmanager/zzau;
    //   26: new 130	com/google/android/gms/tagmanager/zzdc$2
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 131	com/google/android/gms/tagmanager/zzdc$2:<init>	(Lcom/google/android/gms/tagmanager/zzdc;)V
    //   34: invokeinterface 137 2 0
    //   39: goto -20 -> 19
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	zzdc
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	42	finally
    //   22	39	42	finally
  }
  
  zzaw zzRA()
  {
    try
    {
      if (this.zzbIg != null) {
        break label50;
      }
      if (this.zzbIf == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.zzbIg = new zzcg(this.zzbIm, this.zzbIf);
    label50:
    if (this.zzbIn == null) {
      zzRz();
    }
    this.zzbIk = true;
    if (this.zzbIj)
    {
      dispatch();
      this.zzbIj = false;
    }
    if ((this.zzbIo == null) && (this.zzbIl)) {
      zzRy();
    }
    zzaw localzzaw = this.zzbIg;
    return localzzaw;
  }
  
  /* Error */
  void zza(Context paramContext, zzau paramzzau)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 82	com/google/android/gms/tagmanager/zzdc:zzbIf	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 163	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 82	com/google/android/gms/tagmanager/zzdc:zzbIf	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 128	com/google/android/gms/tagmanager/zzdc:zzbIh	Lcom/google/android/gms/tagmanager/zzau;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 128	com/google/android/gms/tagmanager/zzdc:zzbIh	Lcom/google/android/gms/tagmanager/zzau;
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	zzdc
    //   0	42	1	paramContext	Context
    //   0	42	2	paramzzau	zzau
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   14	34	37	finally
  }
  
  public void zzaT(boolean paramBoolean)
  {
    try
    {
      zze(this.zzbIp, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void zze(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 102	com/google/android/gms/tagmanager/zzdc:isPowerSaveMode	()Z
    //   6: istore_3
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 63	com/google/android/gms/tagmanager/zzdc:zzbIp	Z
    //   12: aload_0
    //   13: iload_2
    //   14: putfield 54	com/google/android/gms/tagmanager/zzdc:connected	Z
    //   17: aload_0
    //   18: invokespecial 102	com/google/android/gms/tagmanager/zzdc:isPowerSaveMode	()Z
    //   21: istore_1
    //   22: iload_1
    //   23: iload_3
    //   24: if_icmpne +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: invokespecial 170	com/google/android/gms/tagmanager/zzdc:zzoH	()V
    //   34: goto -7 -> 27
    //   37: astore 4
    //   39: aload_0
    //   40: monitorexit
    //   41: aload 4
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	zzdc
    //   0	44	1	paramBoolean1	boolean
    //   0	44	2	paramBoolean2	boolean
    //   6	19	3	bool	boolean
    //   37	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	37	finally
    //   30	34	37	finally
  }
  
  public void zznO()
  {
    try
    {
      if (!isPowerSaveMode()) {
        this.zzbIn.zzRC();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzdc
 * JD-Core Version:    0.7.0.1
 */