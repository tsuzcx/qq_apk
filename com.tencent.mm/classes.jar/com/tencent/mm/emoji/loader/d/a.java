package com.tencent.mm.emoji.loader.d;

import a.f.a.m;
import a.f.b.j;
import a.l;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;Ljava/lang/String;)V", "firstLoad", "", "onLoad", "", "success", "onSize", "width", "", "height", "start", "async", "plugin-emojisdk_release"})
public final class a
  extends e
{
  private final String cacheKey;
  private boolean evP;
  
  public a(EmojiInfo paramEmojiInfo, ChattingEmojiView paramChattingEmojiView, String paramString)
  {
    super(paramEmojiInfo, (BaseEmojiView)paramChattingEmojiView, (h.a)paramChattingEmojiView);
    AppMethodBeat.i(63201);
    this.cacheKey = paramString;
    this.evP = true;
    AppMethodBeat.o(63201);
  }
  
  public final void cf(boolean paramBoolean)
  {
    Drawable localDrawable = null;
    AppMethodBeat.i(63200);
    StringBuilder localStringBuilder = new StringBuilder("onLoad ").append(this).append(' ');
    Object localObject = this.evZ;
    if (localObject != null)
    {
      localObject = (BaseEmojiView)((WeakReference)localObject).get();
      ab.d("MicroMsg.ChatEmojiViewRequest", localObject + ' ' + paramBoolean);
      localObject = this.evZ;
      if (localObject == null) {
        break label145;
      }
    }
    label145:
    for (localObject = (BaseEmojiView)((WeakReference)localObject).get();; localObject = null)
    {
      if (paramBoolean) {
        localDrawable = new com.tencent.mm.emoji.loader.b.a().a(this.evH, (m)new a.b(this));
      }
      if ((localDrawable != null) || (!this.evP)) {
        break label150;
      }
      this.evP = false;
      h.a(this);
      AppMethodBeat.o(63200);
      return;
      localObject = null;
      break;
    }
    label150:
    b.b((a.f.a.a)new a.a(this, localDrawable, (BaseEmojiView)localObject, paramBoolean));
    AppMethodBeat.o(63200);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(151757);
    Object localObject1 = com.tencent.mm.emoji.loader.a.a.evr;
    Drawable localDrawable = com.tencent.mm.emoji.loader.a.a.lJ(this.cacheKey);
    Object localObject2 = new StringBuilder("start: ").append(localDrawable).append(' ');
    localObject1 = this.evZ;
    if (localObject1 != null)
    {
      localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
      ab.d("MicroMsg.ChatEmojiViewRequest", localObject1 + ' ' + this.cacheKey);
      if (localDrawable == null) {
        break label212;
      }
      if (localDrawable.getCallback() != null)
      {
        localObject2 = localDrawable.getCallback();
        localObject1 = this.evZ;
        if (localObject1 == null) {
          break label201;
        }
        localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
      }
    }
    for (;;)
    {
      if (j.e(localObject2, localObject1))
      {
        localObject1 = this.evZ;
        if (localObject1 != null)
        {
          localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((BaseEmojiView)localObject1).setImageDrawable(localDrawable);
          }
        }
        localObject1 = this.evZ;
        if (localObject1 != null)
        {
          localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((BaseEmojiView)localObject1).resume();
          }
        }
        localObject1 = this.evW;
        if (localObject1 != null)
        {
          ((h.a)localObject1).cd(true);
          AppMethodBeat.o(151757);
          return;
          localObject1 = null;
          break;
          label201:
          localObject1 = null;
          continue;
        }
        AppMethodBeat.o(151757);
        return;
      }
    }
    label212:
    h.a(this);
    AppMethodBeat.o(151757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.a
 * JD-Core Version:    0.7.0.1
 */