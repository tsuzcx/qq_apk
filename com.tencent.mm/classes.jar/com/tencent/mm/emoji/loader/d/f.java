package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.y;
import java.lang.ref.WeakReference;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/view/BaseEmojiView;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "getCallback", "()Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "setCallback", "(Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "netLoad", "", "start", "", "cancel", "", "onLoad", "success", "async", "plugin-emojisdk_release"})
public class f
  extends j<BaseEmojiView>
{
  i.a fPR;
  private boolean fPS;
  private long start;
  
  public f(EmojiInfo paramEmojiInfo, BaseEmojiView paramBaseEmojiView, i.a parama)
  {
    super(paramEmojiInfo, (View)paramBaseEmojiView);
    AppMethodBeat.i(105470);
    this.fPR = parama;
    this.start = System.currentTimeMillis();
    AppMethodBeat.o(105470);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(105469);
    super.cancel();
    this.fPR = null;
    AppMethodBeat.o(105469);
  }
  
  public void df(final boolean paramBoolean)
  {
    final Drawable localDrawable = null;
    AppMethodBeat.i(105468);
    String str = g.abZ();
    StringBuilder localStringBuilder = new StringBuilder("onLoad ").append(this).append(' ');
    Object localObject = this.fPY;
    if (localObject != null)
    {
      localObject = (BaseEmojiView)((WeakReference)localObject).get();
      ac.d(str, localObject + ' ' + paramBoolean);
      if (this.fPS)
      {
        localObject = com.tencent.mm.search.c.a.Gwx;
        if (com.tencent.mm.search.c.a.At(this.start))
        {
          localObject = com.tencent.mm.search.c.a.Gwx;
          com.tencent.mm.search.c.a.eWX();
          localObject = com.tencent.mm.search.c.a.Gwx;
          com.tencent.mm.search.c.a.As(System.currentTimeMillis() - this.start);
        }
      }
      localObject = this.fPY;
      if (localObject == null) {
        break label180;
      }
    }
    label180:
    for (localObject = (BaseEmojiView)((WeakReference)localObject).get();; localObject = null)
    {
      if (paramBoolean) {
        localDrawable = new com.tencent.mm.emoji.loader.b.a().a(this.fPB, null);
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
    if (this.fPB.fdp())
    {
      df(true);
      AppMethodBeat.o(105467);
      return;
    }
    this.fPS = true;
    c.g((d.g.a.a)new b(this));
    AppMethodBeat.o(105467);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(f paramf, boolean paramBoolean, Drawable paramDrawable, BaseEmojiView paramBaseEmojiView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.f
 * JD-Core Version:    0.7.0.1
 */