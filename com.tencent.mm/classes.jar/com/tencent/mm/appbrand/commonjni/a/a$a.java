package com.tencent.mm.appbrand.commonjni.a;

import java.nio.ByteBuffer;

public abstract interface a$a
{
  public abstract boolean doInnerLoopTask();
  
  public abstract String[] getAsyncableJsApis();
  
  public abstract String nativeInvokeHandler(String paramString1, String paramString2, int paramInt, boolean paramBoolean);
  
  public abstract ByteBuffer readWeAppFile(String paramString);
  
  public abstract void resumeLoopTasks();
  
  public abstract boolean syncInitModule(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.a.a.a
 * JD-Core Version:    0.7.0.1
 */