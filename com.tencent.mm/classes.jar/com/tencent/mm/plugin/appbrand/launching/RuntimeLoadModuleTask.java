package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;

public abstract class RuntimeLoadModuleTask
{
  public final RuntimeLoadModuleTask.LoadParams gLE;
  
  public RuntimeLoadModuleTask(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.gLE = new RuntimeLoadModuleTask.LoadParams(paramString1, paramInt1, paramInt2, paramString2, (byte)0);
  }
  
  public void a(WxaPkgLoadProgress paramWxaPkgLoadProgress) {}
  
  public abstract void ud(String paramString);
  
  private static final class a
    implements a<RuntimeLoadModuleTask.LoadParams, RuntimeLoadModuleTask.WxaPkgResultProgressPair>
  {
    private c<RuntimeLoadModuleTask.WxaPkgResultProgressPair> dGK = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask
 * JD-Core Version:    0.7.0.1
 */