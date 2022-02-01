package com.tencent.mm.appbrand.commonjni.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a$a
  implements a.b
{
  public final boolean doInnerLoopTask()
  {
    return false;
  }
  
  public final String[] getAsyncableJsApis()
  {
    return new String[0];
  }
  
  public final String nativeInvokeHandler(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201241);
    c.c.i("MicroMsg.AppBrandRuntimeDelegate", "hy: trigger get nativeInvokeHandler jsapis", new Object[0]);
    AppMethodBeat.o(201241);
    return "";
  }
  
  public final ByteBuffer readWeAppFile(String paramString)
  {
    return null;
  }
  
  public final void resumeLoopTasks() {}
  
  public final boolean syncInitModule(String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.a.a.a
 * JD-Core Version:    0.7.0.1
 */