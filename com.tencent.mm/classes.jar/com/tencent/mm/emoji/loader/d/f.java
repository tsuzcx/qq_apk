package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.m;
import d.g.b.q;
import d.l;
import d.z;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/view/BaseEmojiView;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "getCallback", "()Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "setCallback", "(Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "netLoad", "", "start", "", "cancel", "", "onLoad", "success", "async", "plugin-emojisdk_release"})
public class f
  extends j<BaseEmojiView>
{
  i.a gjr;
  private boolean gjs;
  private long start;
  
  public f(EmojiInfo paramEmojiInfo, BaseEmojiView paramBaseEmojiView, i.a parama)
  {
    super(paramEmojiInfo, (View)paramBaseEmojiView);
    AppMethodBeat.i(105470);
    this.gjr = parama;
    this.start = System.currentTimeMillis();
    AppMethodBeat.o(105470);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(105469);
    super.cancel();
    this.gjr = null;
    AppMethodBeat.o(105469);
  }
  
  public void dh(final boolean paramBoolean)
  {
    final Drawable localDrawable = null;
    AppMethodBeat.i(105468);
    String str = g.aeD();
    StringBuilder localStringBuilder = new StringBuilder("onLoad ").append(this).append(' ');
    Object localObject = this.gjy;
    if (localObject != null)
    {
      localObject = (BaseEmojiView)((WeakReference)localObject).get();
      ad.d(str, localObject + ' ' + paramBoolean);
      if (this.gjs)
      {
        localObject = com.tencent.mm.search.c.a.Iir;
        if (com.tencent.mm.search.c.a.Dj(this.start))
        {
          localObject = com.tencent.mm.search.c.a.Iir;
          com.tencent.mm.search.c.a.fmH();
          localObject = com.tencent.mm.search.c.a.Iir;
          com.tencent.mm.search.c.a.Di(System.currentTimeMillis() - this.start);
        }
      }
      localObject = this.gjy;
      if (localObject == null) {
        break label190;
      }
    }
    label190:
    for (localObject = (BaseEmojiView)((WeakReference)localObject).get();; localObject = null)
    {
      if (paramBoolean) {
        localDrawable = new com.tencent.mm.emoji.loader.b.a().a(this.gjb, (m)new b(this));
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
    if (this.gjb.fOu())
    {
      dh(true);
      AppMethodBeat.o(105467);
      return;
    }
    this.gjs = true;
    c.g((d.g.a.a)new c(this));
    AppMethodBeat.o(105467);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(f paramf, boolean paramBoolean, Drawable paramDrawable, BaseEmojiView paramBaseEmojiView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "width", "", "height", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, z>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.f
 * JD-Core Version:    0.7.0.1
 */