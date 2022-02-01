package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "", "fetch", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "Companion", "plugin-emojisdk_release"})
public abstract interface d
{
  public static final a gWg = a.gWl;
  
  public abstract void a(e parame, b<? super Boolean, x> paramb);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher$Companion;", "", "()V", "CDN_MEDIA_PREFIX", "", "getCDN_MEDIA_PREFIX", "()Ljava/lang/String;", "ENCRYPT_SUFFIX", "getENCRYPT_SUFFIX", "EXTERN_SUFFIX", "getEXTERN_SUFFIX", "FetcherTypeEncrypt", "", "FetcherTypeExternal", "FetcherTypeOpenIm", "FetcherTypeOrigin", "OPENIM_SUFFIX", "getOPENIM_SUFFIX", "plugin-emojisdk_release"})
  public static final class a
  {
    private static final String gWh = "_openim";
    private static final String gWi = "_extern";
    private static final String gWj = "_encrypt";
    private static final String gWk = "downemoji_";
    
    static
    {
      AppMethodBeat.i(105430);
      gWl = new a();
      gWh = "_openim";
      gWi = "_extern";
      gWj = "_encrypt";
      gWk = "downemoji_";
      AppMethodBeat.o(105430);
    }
    
    public static String auE()
    {
      return gWk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.d
 * JD-Core Version:    0.7.0.1
 */