package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;Ljava/lang/String;)V", "firstLoad", "", "onLoad", "", "success", "onSize", "width", "", "height", "start", "async", "plugin-emojisdk_release"})
public final class a
  extends f
{
  private final String cacheKey;
  private boolean gWt;
  
  public a(EmojiInfo paramEmojiInfo, ChattingEmojiView paramChattingEmojiView, String paramString)
  {
    super(paramEmojiInfo, (BaseEmojiView)paramChattingEmojiView, (i.a)paramChattingEmojiView);
    AppMethodBeat.i(105451);
    this.cacheKey = paramString;
    this.gWt = true;
    AppMethodBeat.o(105451);
  }
  
  public final void dR(final boolean paramBoolean)
  {
    final Drawable localDrawable = null;
    AppMethodBeat.i(105450);
    StringBuilder localStringBuilder = new StringBuilder("onLoad ").append(this).append(' ');
    Object localObject = this.gWH;
    if (localObject != null)
    {
      localObject = (BaseEmojiView)((WeakReference)localObject).get();
      Log.d("MicroMsg.ChatEmojiViewRequest", localObject + ' ' + paramBoolean);
      localObject = this.gWH;
      if (localObject == null) {
        break label145;
      }
    }
    label145:
    for (localObject = (BaseEmojiView)((WeakReference)localObject).get();; localObject = null)
    {
      if (paramBoolean) {
        localDrawable = new com.tencent.mm.emoji.loader.b.a().a(this.gWm, (m)new b(this));
      }
      if ((localDrawable != null) || (!this.gWt)) {
        break label150;
      }
      this.gWt = false;
      i.b(this);
      AppMethodBeat.o(105450);
      return;
      localObject = null;
      break;
    }
    label150:
    d.h((kotlin.g.a.a)new a(this, localDrawable, (BaseEmojiView)localObject, paramBoolean));
    AppMethodBeat.o(105450);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105449);
    Object localObject1 = com.tencent.mm.emoji.loader.a.a.gVS;
    Drawable localDrawable = com.tencent.mm.emoji.loader.a.a.EO(this.cacheKey);
    Object localObject2 = new StringBuilder("start: ").append(localDrawable).append(' ');
    localObject1 = this.gWH;
    if (localObject1 != null)
    {
      localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
      Log.d("MicroMsg.ChatEmojiViewRequest", localObject1 + ' ' + this.cacheKey);
      if (localDrawable == null) {
        break label212;
      }
      if (localDrawable.getCallback() != null)
      {
        localObject2 = localDrawable.getCallback();
        localObject1 = this.gWH;
        if (localObject1 == null) {
          break label201;
        }
        localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
      }
    }
    for (;;)
    {
      if (p.j(localObject2, localObject1))
      {
        localObject1 = this.gWH;
        if (localObject1 != null)
        {
          localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((BaseEmojiView)localObject1).setImageDrawable(localDrawable);
          }
        }
        localObject1 = this.gWH;
        if (localObject1 != null)
        {
          localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((BaseEmojiView)localObject1).resume();
          }
        }
        localObject1 = this.gWA;
        if (localObject1 != null)
        {
          ((i.a)localObject1).dQ(true);
          AppMethodBeat.o(105449);
          return;
          localObject1 = null;
          break;
          label201:
          localObject1 = null;
          continue;
        }
        AppMethodBeat.o(105449);
        return;
      }
    }
    label212:
    if (this.gWm.hRx())
    {
      d.i((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(105449);
      return;
    }
    i.b(this);
    AppMethodBeat.o(105449);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(a parama, Drawable paramDrawable, BaseEmojiView paramBaseEmojiView, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "width", "", "height", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.a
 * JD-Core Version:    0.7.0.1
 */