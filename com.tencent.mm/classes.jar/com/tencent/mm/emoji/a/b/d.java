package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.a;
import d.y;
import java.util.Comparator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "()V", "LAST_USE_EMOJI_COMPARE", "Ljava/util/Comparator;", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "TAG", "", "getEmojiList", "", "md5List", "searchSuggest", "", "content", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "plugin-emojisdk_release"})
public final class d
  implements f
{
  private final String TAG;
  private final Comparator<EmojiInfo> fOV;
  
  public d()
  {
    AppMethodBeat.i(193406);
    this.TAG = "MicroMsg.EmojiSuggestLocal";
    this.fOV = ((Comparator)a.fOW);
    AppMethodBeat.o(193406);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "lhs", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "rhs", "compare"})
  static final class a<T>
    implements Comparator<EmojiInfo>
  {
    public static final a fOW;
    
    static
    {
      AppMethodBeat.i(193404);
      fOW = new a();
      AppMethodBeat.o(193404);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.l
    implements a<y>
  {
    public b(d paramd, String paramString, f.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.d
 * JD-Core Version:    0.7.0.1
 */