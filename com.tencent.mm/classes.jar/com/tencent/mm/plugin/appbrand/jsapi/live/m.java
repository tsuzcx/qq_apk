package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "value", "", "useV2", "getUseV2", "()Z", "setUseV2", "(Z)V", "luggage-qcloud-live-ext_release"})
public final class m
{
  public static boolean oVP;
  
  public static final boolean bSw()
  {
    AppMethodBeat.i(212735);
    Log.i("MicroMsg.AppBrand.TXLiveJSAdapter", "get#useV2, value: " + oVP);
    boolean bool = oVP;
    AppMethodBeat.o(212735);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.m
 * JD-Core Version:    0.7.0.1
 */