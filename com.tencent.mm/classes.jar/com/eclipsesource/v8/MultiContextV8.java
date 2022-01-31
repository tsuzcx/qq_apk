package com.eclipsesource.v8;

import com.eclipsesource.v8.utils.MemoryManager;

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
    this.v8 = V8.createV8Runtime(paramString, null, false);
    this.contextSessionMgr = new V8ContextSessionMgr(getV8());
  }
  
  public static MultiContextV8 createMultiContextV8()
  {
    return new MultiContextV8();
  }
  
  public static MultiContextV8 createMultiContextV8(String paramString)
  {
    return new MultiContextV8(paramString);
  }
  
  public final V8Context createContext(int paramInt)
  {
    return new V8ContextWrapper(this, this.v8.createV8Context(paramInt)).context();
  }
  
  public final MemoryManager createMemoryManager()
  {
    return new MemoryManager(this.v8);
  }
  
  protected final void enterContext(V8ContextWrapper paramV8ContextWrapper)
  {
    this.contextSessionMgr.enterContext(paramV8ContextWrapper);
  }
  
  public final long getIsolatePtr()
  {
    return this.v8.getIsolatePtr();
  }
  
  protected final V8 getV8()
  {
    return this.v8;
  }
  
  public final V8Locker getV8Locker()
  {
    return this.v8.getLocker();
  }
  
  public final void release()
  {
    this.v8.release();
  }
  
  protected final void releaseContext(V8ContextWrapper paramV8ContextWrapper)
  {
    this.contextSessionMgr.releaseContext(paramV8ContextWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.v8.MultiContextV8
 * JD-Core Version:    0.7.0.1
 */