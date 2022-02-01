package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "value", "", "enableByteRangeFix", "getEnableByteRangeFix", "()Z", "setEnableByteRangeFix", "(Z)V", "luggage-commons-jsapi-video-ext_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  private static boolean sFJ = true;
  
  public static final boolean cwF()
  {
    return sFJ;
  }
  
  public static final void jN(boolean paramBoolean)
  {
    AppMethodBeat.i(328724);
    Log.i("MicroMsg.AppBrand.ByteRangeFixHttpDataSource", s.X("enableByteRangeFix#set, value: ", Boolean.valueOf(paramBoolean)));
    sFJ = paramBoolean;
    AppMethodBeat.o(328724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.c
 * JD-Core Version:    0.7.0.1
 */