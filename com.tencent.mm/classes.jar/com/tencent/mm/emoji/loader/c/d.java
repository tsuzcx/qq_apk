package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "", "fetch", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "Companion", "plugin-emojisdk_release"})
public abstract interface d
{
  public static final a fPv = a.fPA;
  
  public abstract void a(e parame, b<? super Boolean, y> paramb);
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher$Companion;", "", "()V", "CDN_MEDIA_PREFIX", "", "getCDN_MEDIA_PREFIX", "()Ljava/lang/String;", "ENCRYPT_SUFFIX", "getENCRYPT_SUFFIX", "EXTERN_SUFFIX", "getEXTERN_SUFFIX", "FetcherTypeEncrypt", "", "FetcherTypeExternal", "FetcherTypeOpenIm", "FetcherTypeOrigin", "OPENIM_SUFFIX", "getOPENIM_SUFFIX", "plugin-emojisdk_release"})
  public static final class a
  {
    private static final String fPw = "_openim";
    private static final String fPx = "_extern";
    private static final String fPy = "_encrypt";
    private static final String fPz = "downemoji_";
    
    static
    {
      AppMethodBeat.i(105430);
      fPA = new a();
      fPw = "_openim";
      fPx = "_extern";
      fPy = "_encrypt";
      fPz = "downemoji_";
      AppMethodBeat.o(105430);
    }
    
    public static String aca()
    {
      return fPz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.d
 * JD-Core Version:    0.7.0.1
 */