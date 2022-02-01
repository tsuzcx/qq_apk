package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.n.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public abstract interface IJSRuntime
{
  public abstract void a(int paramInt, h paramh);
  
  public abstract void a(Runnable paramRunnable, long paramLong, boolean paramBoolean);
  
  public abstract Config aDS();
  
  public abstract boolean aDX();
  
  public abstract String aoO();
  
  public abstract boolean doInnerLoopTask();
  
  public abstract void e(Runnable paramRunnable, long paramLong);
  
  public abstract void eb(boolean paramBoolean);
  
  public abstract long getIsolatePtr();
  
  public abstract long getUVLoopPtr();
  
  public abstract void nM(int paramInt);
  
  public abstract m nN(int paramInt);
  
  public abstract void pause();
  
  public abstract void quit();
  
  public abstract void resume();
  
  public abstract void resumeLoopTasks();
  
  public abstract void u(Runnable paramRunnable);
  
  public abstract void v(Runnable paramRunnable);
  
  public abstract void w(Runnable paramRunnable);
  
  public abstract void waitForDebugger(String paramString);
  
  public static class Config
  {
    public String hmb = null;
    public byte[] hmc = null;
    public String hmd = "0";
    public boolean hme;
    public boolean hmf;
    public boolean hmg = false;
    public boolean hmh = false;
    public String hmi = null;
    public String hmj = "";
    public boolean hmk = false;
    public WeakReference<g> hml = null;
    public e hmm;
    
    public Config() {}
    
    public Config(String paramString, byte[] paramArrayOfByte)
    {
      this.hmb = paramString;
      this.hmc = paramArrayOfByte;
    }
    
    public String toString()
    {
      boolean bool2 = true;
      AppMethodBeat.i(143995);
      StringBuilder localStringBuilder = new StringBuilder("Config{codeCache='").append(this.hmb).append('\'').append(", delaySaveCodeCache=").append(this.hmk).append(", snapShot=");
      Object localObject;
      if (Util.isNullOrNil(this.hmc))
      {
        localObject = "null";
        localObject = localStringBuilder.append((String)localObject).append(", nativeBuffer='").append(this.hmd).append('\'').append(", supportDirectEvaluation=").append(this.hme).append(", enableNativeTrans=").append(this.hmf).append(", hasGlobalTimer=").append(this.hmg).append(", ignoreRemainingTaskWhenLoopEnd=").append(this.hmh).append(", globalAlias=").append(this.hmi).append(", hasComponent=");
        if ((this.hml == null) || (this.hml.get() == null)) {
          break label215;
        }
        bool1 = true;
        label168:
        localObject = ((StringBuilder)localObject).append(bool1).append(", hasBufferStore=");
        if (this.hmm == null) {
          break label220;
        }
      }
      label215:
      label220:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localObject = bool1 + '}';
        AppMethodBeat.o(143995);
        return localObject;
        localObject = "not null";
        break;
        bool1 = false;
        break label168;
      }
    }
    
    public boolean useNativeBufferJNI()
    {
      AppMethodBeat.i(143994);
      boolean bool = "1".equalsIgnoreCase(this.hmd);
      AppMethodBeat.o(143994);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.IJSRuntime
 * JD-Core Version:    0.7.0.1
 */