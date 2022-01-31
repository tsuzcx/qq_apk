package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.util.concurrent.Callable;

public abstract interface i
  extends Callable<WxaPkgWrappingInfo>
{
  public abstract void onDownloadProgress(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.i
 * JD-Core Version:    0.7.0.1
 */