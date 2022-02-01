package com.tencent.mm.emoji.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/util/EmojiSendCheck;", "Lcom/tencent/mm/emoji/util/EmojiExchangeCheck;", "context", "Landroid/content/Context;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "token", "", "callback", "Lcom/tencent/mm/emoji/util/EmojiExchangeCheck$CheckCallback;", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;Lcom/tencent/mm/emoji/util/EmojiExchangeCheck$CheckCallback;)V", "handleErrCode", "", "errCode", "", "errMsg", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b
{
  public e(Context paramContext, EmojiInfo paramEmojiInfo, String paramString, b.a parama)
  {
    super(paramContext, paramEmojiInfo, paramString, parama);
    AppMethodBeat.i(242539);
    AppMethodBeat.o(242539);
  }
  
  public final void C(int paramInt, String paramString)
  {
    AppMethodBeat.i(242545);
    paramString = (a)new a(this);
    switch (paramInt)
    {
    default: 
      str = getContext().getString(a.j.emoji_send_exchange_fail);
      s.s(str, "context.getString(R.stri…emoji_send_exchange_fail)");
      c(str, paramString);
      AppMethodBeat.o(242545);
      return;
    case 4: 
      str = getContext().getString(a.j.emoji_send_need_exchange);
      s.s(str, "context.getString(R.stri…emoji_send_need_exchange)");
      c(str, paramString);
      AppMethodBeat.o(242545);
      return;
    case 9: 
      str = getContext().getString(a.j.emoji_send_product_expired);
      s.s(str, "context.getString(R.stri…oji_send_product_expired)");
      c(str, paramString);
      AppMethodBeat.o(242545);
      return;
    }
    String str = getContext().getString(a.j.emoji_add_failed_activity);
    s.s(str, "context.getString(R.stri…moji_add_failed_activity)");
    c(str, paramString);
    AppMethodBeat.o(242545);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.f.e
 * JD-Core Version:    0.7.0.1
 */