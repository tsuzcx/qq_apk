package com.tencent.luggage.xweb_ext.extendplugin.component.video.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;

public final class VideoCacheServiceIPC
  implements b
{
  public static VideoCacheServiceIPC bId;
  
  static
  {
    AppMethodBeat.i(139903);
    bId = new VideoCacheServiceIPC();
    AppMethodBeat.o(139903);
  }
  
  public final void j(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139901);
    XIPCInvoker.a("com.tencent.mm", new VideoCacheServiceIPC.CacheCallParcel(paramString, paramLong1, paramLong2), VideoCacheServiceIPC.a.class);
    AppMethodBeat.o(139901);
  }
  
  public final boolean k(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139902);
    paramString = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new VideoCacheServiceIPC.CheckCachedCallParcel(paramString, paramLong1, paramLong2), b.class);
    if (paramString != null)
    {
      boolean bool = paramString.value;
      AppMethodBeat.o(139902);
      return bool;
    }
    AppMethodBeat.o(139902);
    return false;
  }
  
  static class b
    implements i<VideoCacheServiceIPC.CheckCachedCallParcel, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.VideoCacheServiceIPC
 * JD-Core Version:    0.7.0.1
 */