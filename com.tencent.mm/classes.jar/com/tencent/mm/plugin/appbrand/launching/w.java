package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.concurrent.Callable;

abstract class w<T>
  implements Callable<T>
{
  protected volatile long gLb = 0L;
  protected volatile long gLc = 0L;
  protected volatile long gLd = 0L;
  
  final T alN()
  {
    this.gLb = bk.UY();
    Object localObject = call();
    this.gLc = bk.UY();
    this.gLd = (this.gLc - this.gLb);
    return localObject;
  }
  
  abstract String getTag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.w
 * JD-Core Version:    0.7.0.1
 */