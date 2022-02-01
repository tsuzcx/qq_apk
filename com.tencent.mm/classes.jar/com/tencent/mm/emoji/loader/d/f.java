package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.y;
import java.lang.ref.WeakReference;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/view/BaseEmojiView;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "getCallback", "()Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "setCallback", "(Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "netLoad", "", "start", "", "cancel", "", "onLoad", "success", "async", "plugin-emojisdk_release"})
public class f
  extends j<BaseEmojiView>
{
  i.a fMf;
  private boolean fMg;
  private long start;
  
  public f(EmojiInfo paramEmojiInfo, BaseEmojiView paramBaseEmojiView, i.a parama)
  {
    super(paramEmojiInfo, (View)paramBaseEmojiView);
    AppMethodBeat.i(105470);
    this.fMf = parama;
    this.start = System.currentTimeMillis();
    AppMethodBeat.o(105470);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(105469);
    super.cancel();
    this.fMf = null;
    AppMethodBeat.o(105469);
  }
  
  public void dg(final boolean paramBoolean)
  {
    final Drawable localDrawable = null;
    AppMethodBeat.i(105468);
    String str = g.abb();
    StringBuilder localStringBuilder = new StringBuilder("onLoad ").append(this).append(' ');
    Object localObject = this.fMm;
    if (localObject != null)
    {
      localObject = (BaseEmojiView)((WeakReference)localObject).get();
      ad.d(str, localObject + ' ' + paramBoolean);
      if (this.fMg)
      {
        localObject = com.tencent.mm.search.b.a.EZj;
        if (com.tencent.mm.search.b.a.vQ(this.start))
        {
          localObject = com.tencent.mm.search.b.a.EZj;
          com.tencent.mm.search.b.a.eHC();
          localObject = com.tencent.mm.search.b.a.EZj;
          com.tencent.mm.search.b.a.vP(System.currentTimeMillis() - this.start);
        }
      }
      localObject = this.fMm;
      if (localObject == null) {
        break label180;
      }
    }
    label180:
    for (localObject = (BaseEmojiView)((WeakReference)localObject).get();; localObject = null)
    {
      if (paramBoolean) {
        localDrawable = new com.tencent.mm.emoji.loader.b.a().a(this.fLP, null);
      }
      c.g((d.g.a.a)new a(this, paramBoolean, localDrawable, (BaseEmojiView)localObject));
      AppMethodBeat.o(105468);
      return;
      localObject = null;
      break;
    }
  }
  
  public void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105467);
    if (this.fLP.fZM())
    {
      dg(true);
      AppMethodBeat.o(105467);
      return;
    }
    this.fMg = true;
    c.g((d.g.a.a)new b(this));
    AppMethodBeat.o(105467);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(f paramf, boolean paramBoolean, Drawable paramDrawable, BaseEmojiView paramBaseEmojiView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.f
 * JD-Core Version:    0.7.0.1
 */