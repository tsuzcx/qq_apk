package com.tencent.mm.emoji.b.d;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;Ljava/lang/String;)V", "firstLoad", "", "onLoad", "", "success", "onSize", "width", "", "height", "start", "async", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f
{
  private final String mgR;
  private boolean mgS;
  
  public a(EmojiInfo paramEmojiInfo, ChattingEmojiView paramChattingEmojiView, String paramString)
  {
    super(paramEmojiInfo, (BaseEmojiView)paramChattingEmojiView, (h.a)paramChattingEmojiView);
    AppMethodBeat.i(105451);
    this.mgR = paramString;
    this.mgS = true;
    AppMethodBeat.o(105451);
  }
  
  public final void fc(final boolean paramBoolean)
  {
    final Drawable localDrawable = null;
    AppMethodBeat.i(105450);
    StringBuilder localStringBuilder = new StringBuilder("onLoad ").append(this).append(' ');
    Object localObject = this.mhj;
    if (localObject == null)
    {
      localObject = null;
      Log.d("MicroMsg.ChatEmojiViewRequest", localObject + ' ' + paramBoolean);
      localObject = this.mhj;
      if (localObject != null) {
        break label142;
      }
    }
    label142:
    for (localObject = null;; localObject = (BaseEmojiView)((WeakReference)localObject).get())
    {
      if (paramBoolean) {
        localDrawable = new com.tencent.mm.emoji.b.b.a().a(this.mgK, (m)new b(this));
      }
      if ((localDrawable != null) || (!this.mgS)) {
        break label153;
      }
      this.mgS = false;
      h.b((h)this);
      AppMethodBeat.o(105450);
      return;
      localObject = (BaseEmojiView)((WeakReference)localObject).get();
      break;
    }
    label153:
    d.uiThread((kotlin.g.a.a)new a(this, localDrawable, (BaseEmojiView)localObject, paramBoolean));
    AppMethodBeat.o(105450);
  }
  
  public final void start(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(105449);
    Object localObject1 = com.tencent.mm.emoji.b.a.a.mgq;
    Drawable localDrawable = com.tencent.mm.emoji.b.a.a.En(this.mgR);
    Object localObject3 = new StringBuilder("start: ").append(localDrawable).append(' ');
    localObject1 = this.mhj;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.d("MicroMsg.ChatEmojiViewRequest", localObject1 + ' ' + this.mgR);
      if (localDrawable == null) {
        break label214;
      }
      if (localDrawable.getCallback() != null)
      {
        localObject3 = localDrawable.getCallback();
        localObject1 = this.mhj;
        if (localObject1 != null) {
          break label203;
        }
      }
    }
    label203:
    for (localObject1 = localObject2;; localObject1 = (BaseEmojiView)((WeakReference)localObject1).get())
    {
      if (!s.p(localObject3, localObject1)) {
        break label214;
      }
      localObject1 = this.mhj;
      if (localObject1 != null)
      {
        localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((BaseEmojiView)localObject1).setImageDrawable(localDrawable);
        }
      }
      localObject1 = this.mhj;
      if (localObject1 != null)
      {
        localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((BaseEmojiView)localObject1).resume();
        }
      }
      localObject1 = this.mha;
      if (localObject1 == null) {
        break label251;
      }
      ((h.a)localObject1).onResult(true);
      AppMethodBeat.o(105449);
      return;
      localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
      break;
    }
    label214:
    if (this.mgK.kLZ())
    {
      d.B((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(105449);
      return;
    }
    h.b((h)this);
    label251:
    AppMethodBeat.o(105449);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(a parama, Drawable paramDrawable, BaseEmojiView paramBaseEmojiView, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "width", "", "height"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Integer, Integer, ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d.a
 * JD-Core Version:    0.7.0.1
 */