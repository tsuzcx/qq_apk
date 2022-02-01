package com.tencent.matrix.hook.pthread;

import com.tencent.matrix.e.c;
import com.tencent.matrix.hook.a;
import java.util.HashSet;
import java.util.Set;

public class PthreadHook
  extends a
{
  public static final PthreadHook eVl = new PthreadHook();
  private boolean eNE = false;
  private boolean eVj = false;
  public Set<String> eVm = new HashSet();
  public boolean eVn = false;
  public boolean eVo = false;
  public a eVp = null;
  private boolean eVq = false;
  public boolean mConfigured = false;
  
  private native void addHookThreadNameNative(String[] paramArrayOfString);
  
  private native void enableLoggerNative(boolean paramBoolean);
  
  private native void enableTracePthreadReleaseNative(boolean paramBoolean);
  
  private native void installHooksNative(boolean paramBoolean);
  
  private native void setThreadStackShrinkEnabledNative(boolean paramBoolean);
  
  private native boolean setThreadStackShrinkIgnoredCreatorSoPatternsNative(String[] paramArrayOfString);
  
  private native void setThreadTraceEnabledNative(boolean paramBoolean);
  
  public final String axH()
  {
    return "matrix-pthreadhook";
  }
  
  public final boolean axI()
  {
    addHookThreadNameNative((String[])this.eVm.toArray(new String[0]));
    enableQuickenNative(this.eVn);
    enableLoggerNative(this.eNE);
    enableTracePthreadReleaseNative(this.eVq);
    if (this.eVp != null)
    {
      String[] arrayOfString = new String[this.eVp.eVr.size()];
      if (setThreadStackShrinkIgnoredCreatorSoPatternsNative((String[])this.eVp.eVr.toArray(arrayOfString))) {
        setThreadStackShrinkEnabledNative(this.eVp.enabled);
      }
    }
    for (;;)
    {
      setThreadTraceEnabledNative(this.eVo);
      this.mConfigured = true;
      return true;
      c.e("Matrix.Pthread", "setThreadStackShrinkIgnoredCreatorSoPatternsNative return false, do not enable ThreadStackShrinker.", new Object[0]);
      setThreadStackShrinkEnabledNative(false);
      continue;
      setThreadStackShrinkIgnoredCreatorSoPatternsNative(null);
      setThreadStackShrinkEnabledNative(false);
    }
  }
  
  public native void dumpNative(String paramString);
  
  public final boolean dy(boolean paramBoolean)
  {
    if (((this.eVo) || ((this.eVp != null) && (this.eVp.enabled))) && (!this.eVj))
    {
      installHooksNative(paramBoolean);
      this.eVj = true;
    }
    return true;
  }
  
  public native void enableQuickenNative(boolean paramBoolean);
  
  public static class a
  {
    public final Set<String> eVr = new HashSet(5);
    public boolean enabled = false;
    
    public final a gD(String paramString)
    {
      this.eVr.add(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.hook.pthread.PthreadHook
 * JD-Core Version:    0.7.0.1
 */