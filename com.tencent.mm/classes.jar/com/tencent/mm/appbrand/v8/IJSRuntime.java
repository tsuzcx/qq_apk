package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public abstract interface IJSRuntime
{
  public abstract String Cu();
  
  public abstract Config Nk();
  
  public abstract boolean Np();
  
  public abstract void a(int paramInt, h paramh);
  
  public abstract void a(Runnable paramRunnable, long paramLong, boolean paramBoolean);
  
  public abstract void cj(boolean paramBoolean);
  
  public abstract void e(Runnable paramRunnable, long paramLong);
  
  public abstract long getIsolatePtr();
  
  public abstract long getUVLoopPtr();
  
  public abstract m hv(int paramInt);
  
  public abstract void pause();
  
  public abstract void quit();
  
  public abstract void r(Runnable paramRunnable);
  
  public abstract void resume();
  
  public abstract void s(Runnable paramRunnable);
  
  public abstract void setThreadPriority(int paramInt);
  
  public abstract void t(Runnable paramRunnable);
  
  public abstract void waitForDebugger(String paramString);
  
  public static class Config
  {
    public String cXH = null;
    public byte[] cXI = null;
    public String cXJ = "0";
    public boolean cXK;
    public boolean cXL;
    public boolean cXM = false;
    public boolean cXN = false;
    public String cXO = null;
    public WeakReference<d> cXP = null;
    
    public Config() {}
    
    public Config(String paramString, byte[] paramArrayOfByte)
    {
      this.cXH = paramString;
      this.cXI = paramArrayOfByte;
    }
    
    public String toString()
    {
      AppMethodBeat.i(143995);
      StringBuilder localStringBuilder = new StringBuilder("Config{codeCache='").append(this.cXH).append('\'').append(", snapShot=");
      Object localObject;
      if (bt.cC(this.cXI))
      {
        localObject = "null";
        localObject = localStringBuilder.append((String)localObject).append(", nativeBuffer='").append(this.cXJ).append('\'').append(", supportDirectEvaluation=").append(this.cXK).append(", enableNativeTrans=").append(this.cXL).append(", hasGlobalTimer=").append(this.cXM).append(", ignoreRemainingTaskWhenLoopEnd=").append(this.cXN).append(", globalAlias=").append(this.cXO).append(", hasComponent=");
        if ((this.cXP == null) || (this.cXP.get() == null)) {
          break label179;
        }
      }
      label179:
      for (boolean bool = true;; bool = false)
      {
        localObject = bool + '}';
        AppMethodBeat.o(143995);
        return localObject;
        localObject = "not null";
        break;
      }
    }
    
    public boolean useNativeBufferJNI()
    {
      AppMethodBeat.i(143994);
      boolean bool = "1".equalsIgnoreCase(this.cXJ);
      AppMethodBeat.o(143994);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.IJSRuntime
 * JD-Core Version:    0.7.0.1
 */