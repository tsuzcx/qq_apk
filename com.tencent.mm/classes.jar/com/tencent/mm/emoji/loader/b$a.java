package com.tencent.mm.emoji.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/EmojiGroupDiskCache$Companion;", "", "()V", "TAG", "", "getIconPath", "rootPath", "productId", "url", "getMD5", "plugin-emojisdk_release"})
public final class b$a
{
  private static String ao(String paramString1, String paramString2)
  {
    AppMethodBeat.i(183952);
    p.h(paramString1, "productId");
    p.h(paramString2, "url");
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      Log.e(b.access$getTAG$cp(), "[cpan] product id and url are null.");
      AppMethodBeat.o(183952);
      return null;
    }
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = paramString1.getBytes(d.UTF_8);
      p.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    }
    for (paramString1 = g.getMessageDigest(paramString1);; paramString1 = g.getMessageDigest(paramString1))
    {
      AppMethodBeat.o(183952);
      return paramString1;
      paramString1 = paramString2.getBytes(d.UTF_8);
      p.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    }
  }
  
  public static String j(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = null;
    AppMethodBeat.i(183951);
    p.h(paramString1, "rootPath");
    p.h(paramString2, "productId");
    p.h(paramString3, "url");
    if ((Util.isNullOrNil(paramString2)) && (Util.isNullOrNil(paramString3)))
    {
      Log.w(b.access$getTAG$cp(), "[cpan] get icon path failed. productid and url are null.");
      AppMethodBeat.o(183951);
      return null;
    }
    String str = ao(paramString2, paramString3);
    paramString3 = localObject;
    if (!Util.isNullOrNil(str))
    {
      if (!Util.isNullOrNil(paramString2)) {
        break label115;
      }
      paramString1 = new StringBuilder().append(paramString1);
      if (str == null) {
        p.hyc();
      }
    }
    label115:
    for (paramString3 = str;; paramString3 = paramString1 + paramString2 + "/" + str)
    {
      AppMethodBeat.o(183951);
      return paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.b.a
 * JD-Core Version:    0.7.0.1
 */