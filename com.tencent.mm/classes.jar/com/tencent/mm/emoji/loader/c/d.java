package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "", "fetch", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "Companion", "plugin-emojisdk_release"})
public abstract interface d
{
  public static final a giV = a.gja;
  
  public abstract void a(e parame, b<? super Boolean, z> paramb);
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher$Companion;", "", "()V", "CDN_MEDIA_PREFIX", "", "getCDN_MEDIA_PREFIX", "()Ljava/lang/String;", "ENCRYPT_SUFFIX", "getENCRYPT_SUFFIX", "EXTERN_SUFFIX", "getEXTERN_SUFFIX", "FetcherTypeEncrypt", "", "FetcherTypeExternal", "FetcherTypeOpenIm", "FetcherTypeOrigin", "OPENIM_SUFFIX", "getOPENIM_SUFFIX", "plugin-emojisdk_release"})
  public static final class a
  {
    private static final String giW = "_openim";
    private static final String giX = "_extern";
    private static final String giY = "_encrypt";
    private static final String giZ = "downemoji_";
    
    static
    {
      AppMethodBeat.i(105430);
      gja = new a();
      giW = "_openim";
      giX = "_extern";
      giY = "_encrypt";
      giZ = "downemoji_";
      AppMethodBeat.o(105430);
    }
    
    public static String aeE()
    {
      return giZ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.d
 * JD-Core Version:    0.7.0.1
 */