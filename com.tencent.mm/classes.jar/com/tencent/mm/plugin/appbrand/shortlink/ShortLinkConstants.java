package com.tencent.mm.plugin.appbrand.shortlink;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/ShortLinkConstants;", "", "Companion", "luggage-wechat-full-sdk_release"})
@Keep
public abstract interface ShortLinkConstants
{
  public static final Companion Companion = Companion.nNL;
  public static final String SHORT_LINK_SCHEME = "mp://";
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/ShortLinkConstants$Companion;", "", "()V", "SHORT_LINK_SCHEME", "", "luggage-wechat-full-sdk_release"})
  public static final class Companion
  {
    @Keep
    public static final String SHORT_LINK_SCHEME = "mp://";
    
    static
    {
      AppMethodBeat.i(230173);
      nNL = new Companion();
      AppMethodBeat.o(230173);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.ShortLinkConstants
 * JD-Core Version:    0.7.0.1
 */