package com.eclipsesource.mmv8;

import com.eclipsesource.mmv8.utils.MemoryManager;
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
    AppMethodBeat.i(61599);
    this.v8 = V8.createV8Runtime(paramString1, null, false, paramString2, paramArrayOfByte);
    this.contextSessionMgr = new V8ContextSessionMgr(getV8());
    AppMethodBeat.o(61599);
  }
  
  public static MultiContextV8 createMultiContextV8()
  {
    AppMethodBeat.i(61600);
    MultiContextV8 localMultiContextV8 = new MultiContextV8();
    AppMethodBeat.o(61600);
    return localMultiContextV8;
  }
  
  public static MultiContextV8 createMultiContextV8(String paramString)
  {
    AppMethodBeat.i(61601);
    paramString = new MultiContextV8(paramString);
    AppMethodBeat.o(61601);
    return paramString;
  }
  
  public static MultiContextV8 createMultiContextV8(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(61603);
    paramString1 = new MultiContextV8(paramString1, paramString2, paramArrayOfByte);
    AppMethodBeat.o(61603);
    return paramString1;
  }
  
  public static MultiContextV8 createMultiContextV8(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(61602);
    paramString = new MultiContextV8(null, paramString, paramArrayOfByte);
    AppMethodBeat.o(61602);
    return paramString;
  }
  
  public final V8Context createContext(int paramInt)
  {
    AppMethodBeat.i(61604);
    V8Context localV8Context = new V8ContextWrapper(this, this.v8.createV8Context(paramInt)).context();
    AppMethodBeat.o(61604);
    return localV8Context;
  }
  
  public final MemoryManager createMemoryManager()
  {
    AppMethodBeat.i(61612);
    MemoryManager localMemoryManager = new MemoryManager(this.v8);
    AppMethodBeat.o(61612);
    return localMemoryManager;
  }
  
  public final void debuggerMessageLoop()
  {
    AppMethodBeat.i(61610);
    this.v8.debuggerMessageLoop();
    AppMethodBeat.o(61610);
  }
  
  protected final void enterContext(V8ContextWrapper paramV8ContextWrapper)
  {
    AppMethodBeat.i(61613);
    this.contextSessionMgr.enterContext(paramV8ContextWrapper);
    AppMethodBeat.o(61613);
  }
  
  public final long getIsolatePtr()
  {
    AppMethodBeat.i(61606);
    long l = this.v8.getIsolatePtr();
    AppMethodBeat.o(61606);
    return l;
  }
  
  public final long getUVLoopPtr()
  {
    AppMethodBeat.i(61607);
    long l = this.v8.getUVLoopPtr();
    AppMethodBeat.o(61607);
    return l;
  }
  
  public final V8 getV8()
  {
    return this.v8;
  }
  
  public final V8Locker getV8Locker()
  {
    AppMethodBeat.i(61608);
    V8Locker localV8Locker = this.v8.getLocker();
    AppMethodBeat.o(61608);
    return localV8Locker;
  }
  
  public final void memoryPressureNotification(int paramInt)
  {
    AppMethodBeat.i(61611);
    this.v8.memoryPressureNotification(paramInt);
    AppMethodBeat.o(61611);
  }
  
  public final void release()
  {
    AppMethodBeat.i(61605);
    this.v8.release();
    AppMethodBeat.o(61605);
  }
  
  protected final void releaseContext(V8ContextWrapper paramV8ContextWrapper)
  {
    AppMethodBeat.i(61614);
    this.contextSessionMgr.releaseContext(paramV8ContextWrapper);
    AppMethodBeat.o(61614);
  }
  
  public final void waitForDebugger(String paramString)
  {
    AppMethodBeat.i(61609);
    this.v8.waitForDebugger(paramString);
    AppMethodBeat.o(61609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.mmv8.MultiContextV8
 * JD-Core Version:    0.7.0.1
 */