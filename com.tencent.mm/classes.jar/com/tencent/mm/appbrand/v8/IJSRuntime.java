package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public abstract interface IJSRuntime
{
  public abstract String OG();
  
  public abstract void a(int paramInt, h paramh);
  
  public abstract void a(Runnable paramRunnable, long paramLong, boolean paramBoolean);
  
  public abstract Config abT();
  
  public abstract boolean abY();
  
  public abstract void d(Runnable paramRunnable, long paramLong);
  
  public abstract boolean doInnerLoopTask();
  
  public abstract void dp(boolean paramBoolean);
  
  public abstract long getIsolatePtr();
  
  public abstract long getUVLoopPtr();
  
  public abstract void ke(int paramInt);
  
  public abstract m kf(int paramInt);
  
  public abstract void pause();
  
  public abstract void q(Runnable paramRunnable);
  
  public abstract void quit();
  
  public abstract void r(Runnable paramRunnable);
  
  public abstract void resume();
  
  public abstract void resumeLoopTasks();
  
  public abstract void s(Runnable paramRunnable);
  
  public abstract void waitForDebugger(String paramString);
  
  public static class Config
  {
    public String fhP = null;
    public byte[] fhQ = null;
    public String fhR = "0";
    public boolean fhS;
    public boolean fhT;
    public boolean fhU = false;
    public boolean fhV = false;
    public String fhW = null;
    public String fhX = "";
    public WeakReference<f> fhY = null;
    public e fhZ;
    
    public Config() {}
    
    public Config(String paramString, byte[] paramArrayOfByte)
    {
      this.fhP = paramString;
      this.fhQ = paramArrayOfByte;
    }
    
    public String toString()
    {
      boolean bool2 = true;
      AppMethodBeat.i(143995);
      StringBuilder localStringBuilder = new StringBuilder("Config{codeCache='").append(this.fhP).append('\'').append(", snapShot=");
      Object localObject;
      if (Util.isNullOrNil(this.fhQ))
      {
        localObject = "null";
        localObject = localStringBuilder.append((String)localObject).append(", nativeBuffer='").append(this.fhR).append('\'').append(", supportDirectEvaluation=").append(this.fhS).append(", enableNativeTrans=").append(this.fhT).append(", hasGlobalTimer=").append(this.fhU).append(", ignoreRemainingTaskWhenLoopEnd=").append(this.fhV).append(", globalAlias=").append(this.fhW).append(", hasComponent=");
        if ((this.fhY == null) || (this.fhY.get() == null)) {
          break label203;
        }
        bool1 = true;
        label156:
        localObject = ((StringBuilder)localObject).append(bool1).append(", hasBufferStore=");
        if (this.fhZ == null) {
          break label208;
        }
      }
      label203:
      label208:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localObject = bool1 + '}';
        AppMethodBeat.o(143995);
        return localObject;
        localObject = "not null";
        break;
        bool1 = false;
        break label156;
      }
    }
    
    public boolean useNativeBufferJNI()
    {
      AppMethodBeat.i(143994);
      boolean bool = "1".equalsIgnoreCase(this.fhR);
      AppMethodBeat.o(143994);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.IJSRuntime
 * JD-Core Version:    0.7.0.1
 */