package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/EmojiGroupDiskCache$Companion;", "", "()V", "TAG", "", "getIconPath", "rootPath", "productId", "url", "getMD5", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
{
  private static String ax(String paramString1, String paramString2)
  {
    AppMethodBeat.i(183952);
    s.u(paramString1, "productId");
    s.u(paramString2, "url");
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      Log.e(b.access$getTAG$cp(), "[cpan] product id and url are null.");
      AppMethodBeat.o(183952);
      return null;
    }
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = paramString1.getBytes(d.UTF_8);
      s.s(paramString1, "(this as java.lang.String).getBytes(charset)");
    }
    for (paramString1 = g.getMessageDigest(paramString1);; paramString1 = g.getMessageDigest(paramString1))
    {
      AppMethodBeat.o(183952);
      return paramString1;
      paramString1 = paramString2.getBytes(d.UTF_8);
      s.s(paramString1, "(this as java.lang.String).getBytes(charset)");
    }
  }
  
  public static String o(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = null;
    AppMethodBeat.i(183951);
    s.u(paramString1, "rootPath");
    s.u(paramString2, "productId");
    s.u(paramString3, "url");
    if ((Util.isNullOrNil(paramString2)) && (Util.isNullOrNil(paramString3)))
    {
      Log.w(b.access$getTAG$cp(), "[cpan] get icon path failed. productid and url are null.");
      AppMethodBeat.o(183951);
      return null;
    }
    String str = ax(paramString2, paramString3);
    paramString3 = localObject;
    if (!Util.isNullOrNil(str))
    {
      if (!Util.isNullOrNil(paramString2)) {
        break label97;
      }
      s.checkNotNull(str);
    }
    label97:
    for (paramString3 = s.X(paramString1, str);; paramString3 = paramString1 + paramString2 + '/' + str)
    {
      AppMethodBeat.o(183951);
      return paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.a
 * JD-Core Version:    0.7.0.1
 */