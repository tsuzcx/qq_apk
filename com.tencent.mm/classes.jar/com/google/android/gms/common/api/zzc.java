package com.google.android.gms.common.api;

import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

public abstract class zzc
{
  private static final Object sLock = new Object();
  @GuardedBy("sLock")
  private static final Map<Object, zzc> zzdo = new WeakHashMap();
  
  public abstract void remove(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.zzc
 * JD-Core Version:    0.7.0.1
 */