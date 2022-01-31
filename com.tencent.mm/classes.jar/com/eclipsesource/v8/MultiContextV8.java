package com.eclipsesource.v8;

import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class MultiContextV8
{
  private final V8ContextSessionMgr contextSessionMgr;
  private final V8 v8;
  
  private MultiContextV8()
  {
    this(null);
  }
  
  private MultiContextV8(String paramString)
  {
    this(paramString, null, null);
  }
  
  private MultiContextV8(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(74976);
    this.v8 = V8.createV8Runtime(paramString1, null, false, paramString2, paramArrayOfByte);
    this.contextSessionMgr = new V8ContextSessionMgr(getV8());
    AppMethodBeat.o(74976);
  }
  
  public static MultiContextV8 createMultiContextV8()
  {
    AppMethodBeat.i(74977);
    MultiContextV8 localMultiContextV8 = new MultiContextV8();
    AppMethodBeat.o(74977);
    return localMultiContextV8;
  }
  
  public static MultiContextV8 createMultiContextV8(String paramString)
  {
    AppMethodBeat.i(74978);
    paramString = new MultiContextV8(paramString);
    AppMethodBeat.o(74978);
    return paramString;
  }
  
  public static MultiContextV8 createMultiContextV8(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(74980);
    paramString1 = new MultiContextV8(paramString1, paramString2, paramArrayOfByte);
    AppMethodBeat.o(74980);
    return paramString1;
  }
  
  public static MultiContextV8 createMultiContextV8(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(74979);
    paramString = new MultiContextV8(null, paramString, paramArrayOfByte);
    AppMethodBeat.o(74979);
    return paramString;
  }
  
  public final V8Context createContext(int paramInt)
  {
    AppMethodBeat.i(74981);
    V8Context localV8Context = new V8ContextWrapper(this, this.v8.createV8Context(paramInt)).context();
    AppMethodBeat.o(74981);
    return localV8Context;
  }
  
  public final MemoryManager createMemoryManager()
  {
    AppMethodBeat.i(74988);
    MemoryManager localMemoryManager = new MemoryManager(this.v8);
    AppMethodBeat.o(74988);
    return localMemoryManager;
  }
  
  public final void debuggerMessageLoop()
  {
    AppMethodBeat.i(74986);
    this.v8.debuggerMessageLoop();
    AppMethodBeat.o(74986);
  }
  
  protected final void enterContext(V8ContextWrapper paramV8ContextWrapper)
  {
    AppMethodBeat.i(74989);
    this.contextSessionMgr.enterContext(paramV8ContextWrapper);
    AppMethodBeat.o(74989);
  }
  
  public final long getIsolatePtr()
  {
    AppMethodBeat.i(74983);
    long l = this.v8.getIsolatePtr();
    AppMethodBeat.o(74983);
    return l;
  }
  
  protected final V8 getV8()
  {
    return this.v8;
  }
  
  public final V8Locker getV8Locker()
  {
    AppMethodBeat.i(74984);
    V8Locker localV8Locker = this.v8.getLocker();
    AppMethodBeat.o(74984);
    return localV8Locker;
  }
  
  public final void memoryPressureNotification(int paramInt)
  {
    AppMethodBeat.i(74987);
    this.v8.memoryPressureNotification(paramInt);
    AppMethodBeat.o(74987);
  }
  
  public final void release()
  {
    AppMethodBeat.i(74982);
    this.v8.release();
    AppMethodBeat.o(74982);
  }
  
  protected final void releaseContext(V8ContextWrapper paramV8ContextWrapper)
  {
    AppMethodBeat.i(74990);
    this.contextSessionMgr.releaseContext(paramV8ContextWrapper);
    AppMethodBeat.o(74990);
  }
  
  public final void waitForDebugger(String paramString)
  {
    AppMethodBeat.i(74985);
    this.v8.waitForDebugger(paramString);
    AppMethodBeat.o(74985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.v8.MultiContextV8
 * JD-Core Version:    0.7.0.1
 */