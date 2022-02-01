package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/view/BaseEmojiView;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "getCallback", "()Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "setCallback", "(Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "netLoad", "", "start", "", "cancel", "", "onLoad", "success", "async", "plugin-emojisdk_release"})
public class f
  extends j<BaseEmojiView>
{
  i.a gWA;
  private boolean gWB;
  private long start;
  
  public f(EmojiInfo paramEmojiInfo, BaseEmojiView paramBaseEmojiView, i.a parama)
  {
    super(paramEmojiInfo, (View)paramBaseEmojiView);
    AppMethodBeat.i(105470);
    this.gWA = parama;
    this.start = System.currentTimeMillis();
    AppMethodBeat.o(105470);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(105469);
    super.cancel();
    this.gWA = null;
    AppMethodBeat.o(105469);
  }
  
  public void dR(final boolean paramBoolean)
  {
    final Drawable localDrawable = null;
    AppMethodBeat.i(105468);
    String str = g.auD();
    StringBuilder localStringBuilder = new StringBuilder("onLoad ").append(this).append(' ');
    Object localObject = this.gWH;
    if (localObject != null)
    {
      localObject = (BaseEmojiView)((WeakReference)localObject).get();
      Log.d(str, localObject + ' ' + paramBoolean);
      if (this.gWB)
      {
        localObject = com.tencent.mm.search.c.a.NJv;
        if (com.tencent.mm.search.c.a.MH(this.start))
        {
          localObject = com.tencent.mm.search.c.a.NJv;
          com.tencent.mm.search.c.a.gxx();
          localObject = com.tencent.mm.search.c.a.NJv;
          com.tencent.mm.search.c.a.MG(System.currentTimeMillis() - this.start);
        }
      }
      localObject = this.gWH;
      if (localObject == null) {
        break label190;
      }
    }
    label190:
    for (localObject = (BaseEmojiView)((WeakReference)localObject).get();; localObject = null)
    {
      if (paramBoolean) {
        localDrawable = new com.tencent.mm.emoji.loader.b.a().a(this.gWm, (m)new b(this));
      }
      d.h((kotlin.g.a.a)new a(this, paramBoolean, localDrawable, (BaseEmojiView)localObject));
      AppMethodBeat.o(105468);
      return;
      localObject = null;
      break;
    }
  }
  
  public void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105467);
    if (this.gWm.hRx())
    {
      dR(true);
      AppMethodBeat.o(105467);
      return;
    }
    this.gWB = true;
    d.h((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(105467);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(f paramf, boolean paramBoolean, Drawable paramDrawable, BaseEmojiView paramBaseEmojiView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "width", "", "height", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, x>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.f
 * JD-Core Version:    0.7.0.1
 */