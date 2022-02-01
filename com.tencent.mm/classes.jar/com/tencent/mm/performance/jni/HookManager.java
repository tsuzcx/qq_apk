package com.tencent.mm.performance.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HookManager
{
  public static final HookManager hQf;
  private volatile boolean hQg;
  public Set<a> hQh;
  
  static
  {
    AppMethodBeat.i(192600);
    b.hQi.init();
    hQf = new HookManager();
    AppMethodBeat.o(192600);
  }
  
  private HookManager()
  {
    AppMethodBeat.i(192598);
    this.hQh = new HashSet();
    AppMethodBeat.o(192598);
  }
  
  public static String getStack()
  {
    AppMethodBeat.i(205467);
    String str = stackTraceToString(new Throwable().getStackTrace());
    AppMethodBeat.o(205467);
    return str;
  }
  
  private static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    AppMethodBeat.i(205468);
    if (paramArrayOfStackTraceElement == null)
    {
      AppMethodBeat.o(205468);
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
    AppMethodBeat.o(205468);
    return paramArrayOfStackTraceElement;
  }
  
  private native void xhookClearNative();
  
  private native void xhookEnableDebugNative(boolean paramBoolean);
  
  private native void xhookEnableSigSegvProtectionNative(boolean paramBoolean);
  
  private native int xhookRefreshNative(boolean paramBoolean);
  
  public final void aFL()
  {
    AppMethodBeat.i(192599);
    if (this.hQg)
    {
      localObject = new a("this process has already been hooked!");
      AppMethodBeat.o(192599);
      throw ((Throwable)localObject);
    }
    if (this.hQh.isEmpty())
    {
      AppMethodBeat.o(192599);
      return;
    }
    Object localObject = this.hQh.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).aFJ();
    }
    localObject = this.hQh.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).aFK();
    }
    xhookEnableDebugNative(false);
    xhookEnableSigSegvProtectionNative(true);
    xhookRefreshNative(false);
    this.hQg = true;
    AppMethodBeat.o(192599);
  }
  
  public static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.jni.HookManager
 * JD-Core Version:    0.7.0.1
 */