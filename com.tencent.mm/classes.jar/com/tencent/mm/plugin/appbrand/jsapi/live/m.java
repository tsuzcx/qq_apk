package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "value", "", "useV2", "getUseV2", "()Z", "setUseV2", "(Z)V", "luggage-qcloud-live-ext_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class m
{
  public static boolean sbn;
  
  public static final boolean csD()
  {
    AppMethodBeat.i(326134);
    Log.i("MicroMsg.AppBrand.TXLiveJSAdapter", s.X("get#useV2, value: ", Boolean.valueOf(sbn)));
    boolean bool = sbn;
    AppMethodBeat.o(326134);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.m
 * JD-Core Version:    0.7.0.1
 */