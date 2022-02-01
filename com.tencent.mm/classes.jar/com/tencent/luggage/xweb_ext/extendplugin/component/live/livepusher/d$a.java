package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfoV2$EyeShadowType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "MATTE", "FINE_FLASH", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum d$a
{
  private final int jsonVal;
  
  static
  {
    AppMethodBeat.i(220742);
    eAz = new a("MATTE", 0, 0);
    eAA = new a("FINE_FLASH", 1, 1);
    eAB = new a[] { eAz, eAA };
    AppMethodBeat.o(220742);
  }
  
  private d$a(int paramInt)
  {
    this.jsonVal = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d.a
 * JD-Core Version:    0.7.0.1
 */