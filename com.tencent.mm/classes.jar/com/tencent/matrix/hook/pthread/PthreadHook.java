package com.tencent.matrix.hook.pthread;

import androidx.annotation.Keep;
import com.tencent.matrix.e.c;
import com.tencent.matrix.hook.a;
import java.util.HashSet;
import java.util.Set;

public class PthreadHook
  extends a
{
  public static final PthreadHook cYv = new PthreadHook();
  private boolean cSo = false;
  private boolean cYt = false;
  public Set<String> cYw = new HashSet();
  public boolean cYx = false;
  public boolean cYy = false;
  public a cYz = null;
  public boolean mConfigured = false;
  
  @Keep
  private native void addHookThreadNameNative(String[] paramArrayOfString);
  
  @Keep
  private native void enableLoggerNative(boolean paramBoolean);
  
  @Keep
  private native void installHooksNative(boolean paramBoolean);
  
  @Keep
  private native void setThreadStackShrinkEnabledNative(boolean paramBoolean);
  
  @Keep
  private native boolean setThreadStackShrinkIgnoredCreatorSoPatternsNative(String[] paramArrayOfString);
  
  @Keep
  private native void setThreadTraceEnabledNative(boolean paramBoolean);
  
  public final String WJ()
  {
    return "matrix-pthreadhook";
  }
  
  public final boolean WK()
  {
    addHookThreadNameNative((String[])this.cYw.toArray(new String[0]));
    enableQuickenNative(this.cYx);
    enableLoggerNative(this.cSo);
    if (this.cYz != null)
    {
      String[] arrayOfString = new String[this.cYz.cYA.size()];
      if (setThreadStackShrinkIgnoredCreatorSoPatternsNative((String[])this.cYz.cYA.toArray(arrayOfString))) {
        setThreadStackShrinkEnabledNative(this.cYz.enabled);
      }
    }
    for (;;)
    {
      setThreadTraceEnabledNative(this.cYy);
      this.mConfigured = true;
      return true;
      c.e("Matrix.Pthread", "setThreadStackShrinkIgnoredCreatorSoPatternsNative return false, do not enable ThreadStackShrinker.", new Object[0]);
      setThreadStackShrinkEnabledNative(false);
      continue;
      setThreadStackShrinkIgnoredCreatorSoPatternsNative(null);
      setThreadStackShrinkEnabledNative(false);
    }
  }
  
  public final boolean cR(boolean paramBoolean)
  {
    if (((this.cYy) || ((this.cYz != null) && (this.cYz.enabled))) && (!this.cYt))
    {
      installHooksNative(paramBoolean);
      this.cYt = true;
    }
    return true;
  }
  
  @Keep
  public native void dumpNative(String paramString);
  
  @Keep
  public native void enableQuickenNative(boolean paramBoolean);
  
  public static class a
  {
    public final Set<String> cYA = new HashSet(5);
    public boolean enabled = false;
    
    public final a ff(String paramString)
    {
      this.cYA.add(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.hook.pthread.PthreadHook
 * JD-Core Version:    0.7.0.1
 */