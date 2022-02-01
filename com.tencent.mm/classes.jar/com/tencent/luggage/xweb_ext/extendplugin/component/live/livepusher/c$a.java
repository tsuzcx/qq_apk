package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo$EyeShadowType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "MATTE", "FINE_FLASH", "luggage-xweb-ext_release"})
public enum c$a
{
  private final int jsonVal;
  
  static
  {
    AppMethodBeat.i(215922);
    a locala1 = new a("MATTE", 0, 0);
    cGq = locala1;
    a locala2 = new a("FINE_FLASH", 1, 1);
    cGr = locala2;
    cGs = new a[] { locala1, locala2 };
    AppMethodBeat.o(215922);
  }
  
  private c$a(int paramInt)
  {
    this.jsonVal = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c.a
 * JD-Core Version:    0.7.0.1
 */