package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public abstract interface IJSRuntime
{
  public abstract String Br();
  
  public abstract Config LE();
  
  public abstract boolean LJ();
  
  public abstract void a(int paramInt, h paramh);
  
  public abstract void a(Runnable paramRunnable, long paramLong, boolean paramBoolean);
  
  public abstract void cg(boolean paramBoolean);
  
  public abstract void e(Runnable paramRunnable, long paramLong);
  
  public abstract long getIsolatePtr();
  
  public abstract long getUVLoopPtr();
  
  public abstract m hE(int paramInt);
  
  public abstract void pause();
  
  public abstract void q(Runnable paramRunnable);
  
  public abstract void quit();
  
  public abstract void r(Runnable paramRunnable);
  
  public abstract void resume();
  
  public abstract void s(Runnable paramRunnable);
  
  public abstract void setThreadPriority(int paramInt);
  
  public abstract void waitForDebugger(String paramString);
  
  public static class Config
  {
    public String cOX = null;
    public byte[] cOY = null;
    public String cOZ = "0";
    public boolean cPa;
    public boolean cPb;
    public boolean cPc = false;
    public boolean cPd = false;
    public WeakReference<d> cPe = null;
    
    public Config() {}
    
    public Config(String paramString, byte[] paramArrayOfByte)
    {
      this.cOX = paramString;
      this.cOY = paramArrayOfByte;
    }
    
    public String toString()
    {
      AppMethodBeat.i(143995);
      StringBuilder localStringBuilder = new StringBuilder("Config{codeCache='").append(this.cOX).append('\'').append(", snapShot=");
      Object localObject;
      if (bt.cw(this.cOY))
      {
        localObject = "null";
        localObject = localStringBuilder.append((String)localObject).append(", nativeBuffer='").append(this.cOZ).append('\'').append(", supportDirectEvaluation=").append(this.cPa).append(", enableNativeTrans=").append(this.cPb).append(", hasGlobalTimer=").append(this.cPc).append(", ignoreRemainingTaskWhenLoopEnd=").append(this.cPd).append(", hasComponent=");
        if ((this.cPe == null) || (this.cPe.get() == null)) {
          break label167;
        }
      }
      label167:
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
      boolean bool = "1".equalsIgnoreCase(this.cOZ);
      AppMethodBeat.o(143994);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.IJSRuntime
 * JD-Core Version:    0.7.0.1
 */