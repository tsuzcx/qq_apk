package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/ShortLinkConstants;", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ShortLinkConstants
{
  public static final Companion Companion = Companion.tUV;
  public static final String SHORT_LINK_SCHEME = "mp://";
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/ShortLinkConstants$Companion;", "", "()V", "SHORT_LINK_SCHEME", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion
  {
    public static final String SHORT_LINK_SCHEME = "mp://";
    
    static
    {
      AppMethodBeat.i(321818);
      tUV = new Companion();
      AppMethodBeat.o(321818);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.ShortLinkConstants
 * JD-Core Version:    0.7.0.1
 */