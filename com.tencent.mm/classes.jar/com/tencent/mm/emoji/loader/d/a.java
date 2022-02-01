package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;Ljava/lang/String;)V", "firstLoad", "", "onLoad", "", "success", "onSize", "width", "", "height", "start", "async", "plugin-emojisdk_release"})
public final class a
  extends f
{
  private final String cacheKey;
  private boolean gjj;
  
  public a(EmojiInfo paramEmojiInfo, ChattingEmojiView paramChattingEmojiView, String paramString)
  {
    super(paramEmojiInfo, (BaseEmojiView)paramChattingEmojiView, (i.a)paramChattingEmojiView);
    AppMethodBeat.i(105451);
    this.cacheKey = paramString;
    this.gjj = true;
    AppMethodBeat.o(105451);
  }
  
  public final void dh(final boolean paramBoolean)
  {
    final Drawable localDrawable = null;
    AppMethodBeat.i(105450);
    StringBuilder localStringBuilder = new StringBuilder("onLoad ").append(this).append(' ');
    Object localObject = this.gjy;
    if (localObject != null)
    {
      localObject = (BaseEmojiView)((WeakReference)localObject).get();
      ad.d("MicroMsg.ChatEmojiViewRequest", localObject + ' ' + paramBoolean);
      localObject = this.gjy;
      if (localObject == null) {
        break label145;
      }
    }
    label145:
    for (localObject = (BaseEmojiView)((WeakReference)localObject).get();; localObject = null)
    {
      if (paramBoolean) {
        localDrawable = new com.tencent.mm.emoji.loader.b.a().a(this.gjb, (m)new b(this));
      }
      if ((localDrawable != null) || (!this.gjj)) {
        break label150;
      }
      this.gjj = false;
      i.b(this);
      AppMethodBeat.o(105450);
      return;
      localObject = null;
      break;
    }
    label150:
    c.g((d.g.a.a)new a(this, localDrawable, (BaseEmojiView)localObject, paramBoolean));
    AppMethodBeat.o(105450);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105449);
    Object localObject1 = com.tencent.mm.emoji.loader.a.a.giG;
    Drawable localDrawable = com.tencent.mm.emoji.loader.a.a.vS(this.cacheKey);
    Object localObject2 = new StringBuilder("start: ").append(localDrawable).append(' ');
    localObject1 = this.gjy;
    if (localObject1 != null)
    {
      localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
      ad.d("MicroMsg.ChatEmojiViewRequest", localObject1 + ' ' + this.cacheKey);
      if (localDrawable == null) {
        break label212;
      }
      if (localDrawable.getCallback() != null)
      {
        localObject2 = localDrawable.getCallback();
        localObject1 = this.gjy;
        if (localObject1 == null) {
          break label201;
        }
        localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
      }
    }
    for (;;)
    {
      if (p.i(localObject2, localObject1))
      {
        localObject1 = this.gjy;
        if (localObject1 != null)
        {
          localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((BaseEmojiView)localObject1).setImageDrawable(localDrawable);
          }
        }
        localObject1 = this.gjy;
        if (localObject1 != null)
        {
          localObject1 = (BaseEmojiView)((WeakReference)localObject1).get();
          if (localObject1 != null) {
            ((BaseEmojiView)localObject1).resume();
          }
        }
        localObject1 = this.gjr;
        if (localObject1 != null)
        {
          ((i.a)localObject1).dg(true);
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
    if (this.gjb.fOu())
    {
      c.b(null, (d.g.a.a)new c(this));
      AppMethodBeat.o(105449);
      return;
    }
    i.b(this);
    AppMethodBeat.o(105449);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(a parama, Drawable paramDrawable, BaseEmojiView paramBaseEmojiView, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "width", "", "height", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, z>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.a
 * JD-Core Version:    0.7.0.1
 */