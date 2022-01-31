package com.tencent.mm.at.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.h;
import com.tencent.mm.sdk.g.d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class a
{
  public static h cw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116064);
    Object localObject = new com.tencent.mm.at.a.e.a();
    if (d.ysi)
    {
      localObject = new a.c(paramInt1, paramInt1, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, z(paramInt2, "image_loader_"));
      AppMethodBeat.o(116064);
      return localObject;
    }
    localObject = new a.a(paramInt1, paramInt1, (BlockingQueue)localObject);
    AppMethodBeat.o(116064);
    return localObject;
  }
  
  private static ThreadFactory z(int paramInt, String paramString)
  {
    AppMethodBeat.i(116065);
    paramString = new a.b(paramInt, paramString);
    AppMethodBeat.o(116065);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.a.a.a
 * JD-Core Version:    0.7.0.1
 */