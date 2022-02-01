package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "", "fetch", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public static final a mgE = a.mgF;
  
  public abstract void a(e parame, b<? super Boolean, ah> paramb);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher$Companion;", "", "()V", "CDN_MEDIA_PREFIX", "", "getCDN_MEDIA_PREFIX", "()Ljava/lang/String;", "ENCRYPT_SUFFIX", "getENCRYPT_SUFFIX", "EXTERN_SUFFIX", "getEXTERN_SUFFIX", "FetcherTypeEncrypt", "", "FetcherTypeExternal", "FetcherTypeOpenIm", "FetcherTypeOrigin", "OPENIM_SUFFIX", "getOPENIM_SUFFIX", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final String mgG;
    private static final String mgH;
    private static final String mgI;
    private static final String mgJ;
    
    static
    {
      AppMethodBeat.i(105430);
      mgF = new a();
      mgG = "_openim";
      mgH = "_extern";
      mgI = "_encrypt";
      mgJ = "downemoji_";
      AppMethodBeat.o(105430);
    }
    
    public static String aUx()
    {
      return mgJ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.d
 * JD-Core Version:    0.7.0.1
 */