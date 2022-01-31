package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.Callable;

abstract class ag<T>
  implements Callable<T>
{
  protected volatile long ims = 0L;
  protected volatile long imt = 0L;
  protected volatile long imu = 0L;
  
  final T aHg()
  {
    this.ims = bo.aoy();
    Object localObject = call();
    this.imt = bo.aoy();
    this.imu = (this.imt - this.ims);
    return localObject;
  }
  
  abstract String getTag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ag
 * JD-Core Version:    0.7.0.1
 */