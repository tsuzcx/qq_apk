package com.eclipsesource.v8;

final class V8ContextSessionMgr
{
  private V8ContextWrapper currentContext;
  private final V8 v8;
  
  V8ContextSessionMgr(V8 paramV8)
  {
    this.v8 = paramV8;
  }
  
  public final void enterContext(V8ContextWrapper paramV8ContextWrapper)
  {
    if (paramV8ContextWrapper == null) {}
    while (paramV8ContextWrapper.equals(this.currentContext)) {
      return;
    }
    this.v8.switchV8Context(paramV8ContextWrapper.getPtr());
    this.currentContext = paramV8ContextWrapper;
  }
  
  public final void releaseContext(V8ContextWrapper paramV8ContextWrapper)
  {
    if (paramV8ContextWrapper == null) {
      return;
    }
    this.v8.releaseV8Context(paramV8ContextWrapper.getPtr());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.V8ContextSessionMgr
 * JD-Core Version:    0.7.0.1
 */