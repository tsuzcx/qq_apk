package com.tencent.mm.performance.jni.pthread;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.performance.jni.AbsHook;
import com.tencent.mm.performance.jni.HookManager;
import com.tencent.mm.performance.jni.LibWxPerfManager;
import java.util.HashSet;
import java.util.Set;

public class PthreadHook
  extends AbsHook
{
  public static final PthreadHook INSTANCE;
  private Set<String> mHookSoSet;
  private Set<String> mHookThreadName;
  private Set<String> mIgnoreSoSet;
  
  static
  {
    AppMethodBeat.i(195672);
    LibWxPerfManager.INSTANCE.init();
    INSTANCE = new PthreadHook();
    AppMethodBeat.o(195672);
  }
  
  private PthreadHook()
  {
    AppMethodBeat.i(195661);
    this.mHookSoSet = new HashSet();
    this.mIgnoreSoSet = new HashSet();
    this.mHookThreadName = new HashSet();
    AppMethodBeat.o(195661);
  }
  
  private native void addHookSoNative(String[] paramArrayOfString);
  
  private native void addHookThreadNameNative(String[] paramArrayOfString);
  
  private native void addIgnoreSoNative(String[] paramArrayOfString);
  
  private native void dumpNative(String paramString);
  
  public PthreadHook addHookSo(String paramString)
  {
    AppMethodBeat.i(195662);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("so regex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(195662);
      throw paramString;
    }
    this.mHookSoSet.add(paramString);
    AppMethodBeat.o(195662);
    return this;
  }
  
  public PthreadHook addHookSo(String... paramVarArgs)
  {
    AppMethodBeat.i(195663);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      addHookSo(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(195663);
    return this;
  }
  
  public PthreadHook addHookThread(String paramString)
  {
    AppMethodBeat.i(195666);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("thread regex should NOT be empty");
      AppMethodBeat.o(195666);
      throw paramString;
    }
    this.mHookThreadName.add(paramString);
    AppMethodBeat.o(195666);
    return this;
  }
  
  public PthreadHook addHookThread(String... paramVarArgs)
  {
    AppMethodBeat.i(195667);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      addHookThread(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(195667);
    return this;
  }
  
  public PthreadHook addIgnoreSo(String paramString)
  {
    AppMethodBeat.i(195664);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(195664);
      return this;
    }
    this.mIgnoreSoSet.add(paramString);
    AppMethodBeat.o(195664);
    return this;
  }
  
  public PthreadHook addIgnoreSo(String... paramVarArgs)
  {
    AppMethodBeat.i(195665);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      addIgnoreSo(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(195665);
    return this;
  }
  
  public void dump(String paramString)
  {
    AppMethodBeat.i(195669);
    dumpNative(paramString);
    AppMethodBeat.o(195669);
  }
  
  public void hook()
  {
    AppMethodBeat.i(195668);
    HookManager.INSTANCE.clearHooks().addHook(this).commitHooks();
    AppMethodBeat.o(195668);
  }
  
  public void onConfigure()
  {
    AppMethodBeat.i(195670);
    addHookThreadNameNative((String[])this.mHookThreadName.toArray(new String[0]));
    AppMethodBeat.o(195670);
  }
  
  public void onHook()
  {
    AppMethodBeat.i(195671);
    addHookSoNative((String[])this.mHookSoSet.toArray(new String[0]));
    addIgnoreSoNative((String[])this.mIgnoreSoSet.toArray(new String[0]));
    AppMethodBeat.o(195671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.jni.pthread.PthreadHook
 * JD-Core Version:    0.7.0.1
 */