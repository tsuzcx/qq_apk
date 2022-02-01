package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "", "fetch", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "Companion", "plugin-emojisdk_release"})
public abstract interface d
{
  public static final a gln = a.gls;
  
  public abstract void a(e parame, b<? super Boolean, z> paramb);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher$Companion;", "", "()V", "CDN_MEDIA_PREFIX", "", "getCDN_MEDIA_PREFIX", "()Ljava/lang/String;", "ENCRYPT_SUFFIX", "getENCRYPT_SUFFIX", "EXTERN_SUFFIX", "getEXTERN_SUFFIX", "FetcherTypeEncrypt", "", "FetcherTypeExternal", "FetcherTypeOpenIm", "FetcherTypeOrigin", "OPENIM_SUFFIX", "getOPENIM_SUFFIX", "plugin-emojisdk_release"})
  public static final class a
  {
    private static final String glo = "_openim";
    private static final String glp = "_extern";
    private static final String glq = "_encrypt";
    private static final String glr = "downemoji_";
    
    static
    {
      AppMethodBeat.i(105430);
      gls = new a();
      glo = "_openim";
      glp = "_extern";
      glq = "_encrypt";
      glr = "downemoji_";
      AppMethodBeat.o(105430);
    }
    
    public static String aeQ()
    {
      return glr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.d
 * JD-Core Version:    0.7.0.1
 */