package com.tencent.kinda.gen;

public abstract interface EventLoopManager
{
  public abstract KEventLoop getBackGroundEventLoop();
  
  public abstract KEventLoop getMakeSureUIEventLoop();
  
  public abstract KEventLoop getUIEventLoop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.EventLoopManager
 * JD-Core Version:    0.7.0.1
 */