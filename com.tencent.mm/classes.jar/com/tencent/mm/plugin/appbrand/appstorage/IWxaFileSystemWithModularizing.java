package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;

@Keep
public abstract interface IWxaFileSystemWithModularizing
  extends q
{
  public abstract WxaPkg.Info openReadPartialInfo(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
 * JD-Core Version:    0.7.0.1
 */