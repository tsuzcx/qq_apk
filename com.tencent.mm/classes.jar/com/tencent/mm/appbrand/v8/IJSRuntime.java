package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public abstract interface IJSRuntime
{
  public abstract String AV();
  
  public abstract Config LC();
  
  public abstract boolean LH();
  
  public abstract void a(int paramInt, h paramh);
  
  public abstract void a(Runnable paramRunnable, long paramLong, boolean paramBoolean);
  
  public abstract void ci(boolean paramBoolean);
  
  public abstract void e(Runnable paramRunnable, long paramLong);
  
  public abstract long getIsolatePtr();
  
  public abstract long getUVLoopPtr();
  
  public abstract m ho(int paramInt);
  
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
    public String cMs = null;
    public byte[] cMt = null;
    public String cMu = "0";
    public boolean cMv;
    public boolean cMw;
    public boolean cMx = false;
    public boolean cMy = false;
    public WeakReference<d> cMz = null;
    
    public Config() {}
    
    public Config(String paramString, byte[] paramArrayOfByte)
    {
      this.cMs = paramString;
      this.cMt = paramArrayOfByte;
    }
    
    public String toString()
    {
      AppMethodBeat.i(143995);
      StringBuilder localStringBuilder = new StringBuilder("Config{codeCache='").append(this.cMs).append('\'').append(", snapShot=");
      Object localObject;
      if (bs.cv(this.cMt))
      {
        localObject = "null";
        localObject = localStringBuilder.append((String)localObject).append(", nativeBuffer='").append(this.cMu).append('\'').append(", supportDirectEvaluation=").append(this.cMv).append(", enableNativeTrans=").append(this.cMw).append(", hasGlobalTimer=").append(this.cMx).append(", ignoreRemainingTaskWhenLoopEnd=").append(this.cMy).append(", hasComponent=");
        if ((this.cMz == null) || (this.cMz.get() == null)) {
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
      boolean bool = "1".equalsIgnoreCase(this.cMu);
      AppMethodBeat.o(143994);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.IJSRuntime
 * JD-Core Version:    0.7.0.1
 */