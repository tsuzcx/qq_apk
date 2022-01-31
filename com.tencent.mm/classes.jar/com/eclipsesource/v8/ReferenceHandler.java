package com.eclipsesource.v8;

public abstract interface ReferenceHandler
{
  public abstract void v8HandleCreated(V8Value paramV8Value);
  
  public abstract void v8HandleDisposed(V8Value paramV8Value);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.v8.ReferenceHandler
 * JD-Core Version:    0.7.0.1
 */