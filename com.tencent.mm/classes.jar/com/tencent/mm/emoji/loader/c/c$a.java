package com.tencent.mm.emoji.loader.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher$Companion;", "", "()V", "CDN_MEDIA_PREFIX", "", "getCDN_MEDIA_PREFIX", "()Ljava/lang/String;", "ENCRYPT_SUFFIX", "getENCRYPT_SUFFIX", "EXTERN_SUFFIX", "getEXTERN_SUFFIX", "FetcherTypeEncrypt", "", "FetcherTypeExternal", "FetcherTypeOpenIm", "FetcherTypeOrigin", "OPENIM_SUFFIX", "getOPENIM_SUFFIX", "plugin-emojisdk_release"})
public final class c$a
{
  private static final String evC = "_openim";
  private static final String evD = "_extern";
  private static final String evE = "_encrypt";
  private static final String evF = "downemoji_";
  
  static
  {
    AppMethodBeat.i(63180);
    evG = new a();
    evC = "_openim";
    evD = "_extern";
    evE = "_encrypt";
    evF = "downemoji_";
    AppMethodBeat.o(63180);
  }
  
  public static String Ou()
  {
    return evF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.c.a
 * JD-Core Version:    0.7.0.1
 */