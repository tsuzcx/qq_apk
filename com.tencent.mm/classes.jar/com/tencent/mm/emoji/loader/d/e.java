package com.tencent.mm.emoji.loader.d;

import a.l;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/view/BaseEmojiView;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "getCallback", "()Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "setCallback", "(Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "cancel", "", "onLoad", "success", "", "start", "async", "plugin-emojisdk_release"})
public class e
  extends i<BaseEmojiView>
{
  h.a evW;
  
  public e(EmojiInfo paramEmojiInfo, BaseEmojiView paramBaseEmojiView, h.a parama)
  {
    super(paramEmojiInfo, (View)paramBaseEmojiView);
    AppMethodBeat.i(63214);
    this.evW = parama;
    AppMethodBeat.o(63214);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(63213);
    super.cancel();
    this.evW = null;
    AppMethodBeat.o(63213);
  }
  
  public void cf(boolean paramBoolean)
  {
    Drawable localDrawable = null;
    AppMethodBeat.i(63212);
    String str = f.Ot();
    StringBuilder localStringBuilder = new StringBuilder("onLoad ").append(this).append(' ');
    Object localObject = this.evZ;
    if (localObject != null)
    {
      localObject = (BaseEmojiView)((WeakReference)localObject).get();
      ab.d(str, localObject + ' ' + paramBoolean);
      localObject = this.evZ;
      if (localObject == null) {
        break label137;
      }
    }
    label137:
    for (localObject = (BaseEmojiView)((WeakReference)localObject).get();; localObject = null)
    {
      if (paramBoolean) {
        localDrawable = new com.tencent.mm.emoji.loader.b.a().a(this.evH, null);
      }
      b.b((a.f.a.a)new e.a(this, paramBoolean, localDrawable, (BaseEmojiView)localObject));
      AppMethodBeat.o(63212);
      return;
      localObject = null;
      break;
    }
  }
  
  public void start(boolean paramBoolean)
  {
    AppMethodBeat.i(151759);
    if (this.evH.dzn())
    {
      cf(true);
      AppMethodBeat.o(151759);
      return;
    }
    Object localObject = this.evZ;
    if (localObject != null)
    {
      localObject = (BaseEmojiView)((WeakReference)localObject).get();
      if (localObject != null) {
        ((BaseEmojiView)localObject).init();
      }
    }
    h.a(this);
    AppMethodBeat.o(151759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.e
 * JD-Core Version:    0.7.0.1
 */