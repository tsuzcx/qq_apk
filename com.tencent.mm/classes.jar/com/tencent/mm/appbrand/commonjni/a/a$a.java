package com.tencent.mm.appbrand.commonjni.a;

import java.nio.ByteBuffer;

public abstract interface a$a
{
  public abstract void W(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean doInnerLoopTask();
  
  public abstract void fr(String paramString);
  
  public abstract String[] getAsyncableJsApis();
  
  public abstract String nativeInvokeHandler(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean);
  
  public abstract ByteBuffer readWeAppFile(String paramString);
  
  public abstract void reportKV(int paramInt, String paramString);
  
  public abstract void resumeLoopTasks();
  
  public abstract boolean syncInitModule(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.a.a.a
 * JD-Core Version:    0.7.0.1
 */