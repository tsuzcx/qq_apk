package com.tencent.mm.emoji.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.n.d;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/EmojiGroupDiskCache$Companion;", "", "()V", "TAG", "", "getIconPath", "rootPath", "productId", "url", "getMD5", "plugin-emojisdk_release"})
public final class b$a
{
  private static String am(String paramString1, String paramString2)
  {
    AppMethodBeat.i(183952);
    p.h(paramString1, "productId");
    p.h(paramString2, "url");
    if ((bu.isNullOrNil(paramString1)) && (bu.isNullOrNil(paramString2)))
    {
      ae.e(b.access$getTAG$cp(), "[cpan] product id and url are null.");
      AppMethodBeat.o(183952);
      return null;
    }
    if (bu.isNullOrNil(paramString2))
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
    if ((bu.isNullOrNil(paramString2)) && (bu.isNullOrNil(paramString3)))
    {
      ae.w(b.access$getTAG$cp(), "[cpan] get icon path failed. productid and url are null.");
      AppMethodBeat.o(183951);
      return null;
    }
    String str = am(paramString2, paramString3);
    paramString3 = localObject;
    if (!bu.isNullOrNil(str))
    {
      if (!bu.isNullOrNil(paramString2)) {
        break label115;
      }
      paramString1 = new StringBuilder().append(paramString1);
      if (str == null) {
        p.gkB();
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