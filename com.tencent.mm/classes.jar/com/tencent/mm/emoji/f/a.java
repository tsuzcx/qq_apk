package com.tencent.mm.emoji.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/util/EmojiCustomCheck;", "Lcom/tencent/mm/emoji/util/EmojiExchangeCheck;", "context", "Landroid/content/Context;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "token", "", "callback", "Lcom/tencent/mm/emoji/util/EmojiExchangeCheck$CheckCallback;", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;Lcom/tencent/mm/emoji/util/EmojiExchangeCheck$CheckCallback;)V", "handleErrCode", "", "errCode", "", "errMsg", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  public a(Context paramContext, EmojiInfo paramEmojiInfo, String paramString, b.a parama)
  {
    super(paramContext, paramEmojiInfo, paramString, parama);
    AppMethodBeat.i(242542);
    AppMethodBeat.o(242542);
  }
  
  public final void C(int paramInt, String paramString)
  {
    AppMethodBeat.i(242547);
    kotlin.g.a.a locala = (kotlin.g.a.a)new a(this);
    switch (paramInt)
    {
    default: 
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break;
      }
    }
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      paramString = getContext().getString(a.j.emoji_add_failed);
      s.s(paramString, "context.getString(R.string.emoji_add_failed)");
      c(paramString, locala);
      AppMethodBeat.o(242547);
      return;
      paramString = getContext().getString(a.j.emoji_send_need_exchange);
      s.s(paramString, "context.getString(R.stri…emoji_send_need_exchange)");
      c(paramString, locala);
      AppMethodBeat.o(242547);
      return;
      paramString = getContext().getString(a.j.emoji_add_failed_no_area);
      s.s(paramString, "context.getString(R.stri…emoji_add_failed_no_area)");
      c(paramString, locala);
      AppMethodBeat.o(242547);
      return;
      paramString = getContext().getString(a.j.emoji_add_failed_expired);
      s.s(paramString, "context.getString(R.stri…emoji_add_failed_expired)");
      c(paramString, locala);
      AppMethodBeat.o(242547);
      return;
      paramString = getContext().getString(a.j.emoji_add_failed_activity);
      s.s(paramString, "context.getString(R.stri…moji_add_failed_activity)");
      c(paramString, locala);
      AppMethodBeat.o(242547);
      return;
    }
    c(paramString, locala);
    AppMethodBeat.o(242547);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.f.a
 * JD-Core Version:    0.7.0.1
 */