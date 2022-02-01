package com.tencent.mm.performance.jni;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HookManager
{
  public static final HookManager INSTANCE;
  private volatile boolean hasHooked;
  private Set<AbsHook> mHooks;
  
  static
  {
    AppMethodBeat.i(195645);
    LibWxPerfManager.INSTANCE.init();
    INSTANCE = new HookManager();
    AppMethodBeat.o(195645);
  }
  
  private HookManager()
  {
    AppMethodBeat.i(195638);
    this.mHooks = new HashSet();
    AppMethodBeat.o(195638);
  }
  
  private void exclusiveHook()
  {
    AppMethodBeat.i(195639);
    xhookEnableDebugNative(false);
    xhookEnableSigSegvProtectionNative(true);
    xhookRefreshNative(false);
    this.hasHooked = true;
    AppMethodBeat.o(195639);
  }
  
  @Keep
  public static String getStack()
  {
    AppMethodBeat.i(195643);
    String str = stackTraceToString(new Throwable().getStackTrace());
    AppMethodBeat.o(195643);
    return str;
  }
  
  private static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    AppMethodBeat.i(195644);
    if (paramArrayOfStackTraceElement == null)
    {
      AppMethodBeat.o(195644);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      if (!localStackTraceElement.getClassName().contains("java.lang.Thread")) {
        localStringBuilder.append("\t").append(localStackTraceElement).append('\n');
      }
      i += 1;
    }
    paramArrayOfStackTraceElement = localStringBuilder.toString();
    AppMethodBeat.o(195644);
    return paramArrayOfStackTraceElement;
  }
  
  private native void xhookClearNative();
  
  private native void xhookEnableDebugNative(boolean paramBoolean);
  
  private native void xhookEnableSigSegvProtectionNative(boolean paramBoolean);
  
  private native int xhookRefreshNative(boolean paramBoolean);
  
  public HookManager addHook(AbsHook paramAbsHook)
  {
    AppMethodBeat.i(195641);
    if (paramAbsHook != null) {
      this.mHooks.add(paramAbsHook);
    }
    AppMethodBeat.o(195641);
    return this;
  }
  
  public HookManager clearHooks()
  {
    AppMethodBeat.i(195642);
    this.mHooks.clear();
    AppMethodBeat.o(195642);
    return this;
  }
  
  public void commitHooks()
  {
    AppMethodBeat.i(195640);
    if (this.hasHooked)
    {
      localObject = new HookFailedException("this process has already been hooked!");
      AppMethodBeat.o(195640);
      throw ((Throwable)localObject);
    }
    if (this.mHooks.isEmpty())
    {
      AppMethodBeat.o(195640);
      return;
    }
    Object localObject = this.mHooks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsHook)((Iterator)localObject).next()).onConfigure();
    }
    localObject = this.mHooks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsHook)((Iterator)localObject).next()).onHook();
    }
    exclusiveHook();
    AppMethodBeat.o(195640);
  }
  
  public static class HookFailedException
    extends Exception
  {
    public HookFailedException(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.jni.HookManager
 * JD-Core Version:    0.7.0.1
 */