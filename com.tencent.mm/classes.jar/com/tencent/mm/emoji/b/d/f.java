package com.tencent.mm.emoji.b.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/view/BaseEmojiView;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "getCallback", "()Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "setCallback", "(Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "netLoad", "", "start", "", "cancel", "", "onLoad", "success", "async", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class f
  extends i<BaseEmojiView>
{
  h.a mha;
  private boolean mhb;
  private long start;
  
  public f(EmojiInfo paramEmojiInfo, BaseEmojiView paramBaseEmojiView, h.a parama)
  {
    super(paramEmojiInfo, (View)paramBaseEmojiView);
    AppMethodBeat.i(105470);
    this.mha = parama;
    this.start = System.currentTimeMillis();
    AppMethodBeat.o(105470);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(105469);
    super.cancel();
    this.mha = null;
    AppMethodBeat.o(105469);
  }
  
  public void fc(boolean paramBoolean)
  {
    final Drawable localDrawable = null;
    AppMethodBeat.i(105468);
    String str = g.aUw();
    StringBuilder localStringBuilder = new StringBuilder("onLoad ").append(this).append(' ');
    Object localObject = this.mhj;
    if (localObject == null)
    {
      localObject = null;
      Log.d(str, localObject + ' ' + paramBoolean);
      if (this.mhb)
      {
        localObject = com.tencent.mm.search.c.a.acsi;
        if (com.tencent.mm.search.c.a.yB(this.start))
        {
          localObject = com.tencent.mm.search.c.a.acsi;
          com.tencent.mm.search.c.a.iTC();
          localObject = com.tencent.mm.search.c.a.acsi;
          com.tencent.mm.search.c.a.yA(System.currentTimeMillis() - this.start);
        }
      }
      localObject = this.mhj;
      if (localObject != null) {
        break label184;
      }
    }
    label184:
    for (localObject = null;; localObject = (BaseEmojiView)((WeakReference)localObject).get())
    {
      if (paramBoolean) {
        localDrawable = new com.tencent.mm.emoji.b.b.a().a(this.mgK, (m)new b(this));
      }
      d.uiThread((kotlin.g.a.a)new a(paramBoolean, localDrawable, (BaseEmojiView)localObject, this));
      AppMethodBeat.o(105468);
      return;
      localObject = (BaseEmojiView)((WeakReference)localObject).get();
      break;
    }
  }
  
  public void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105467);
    if (this.mgK.kLZ())
    {
      d.B((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(105467);
      return;
    }
    this.mhb = true;
    d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(105467);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(boolean paramBoolean, Drawable paramDrawable, BaseEmojiView paramBaseEmojiView, f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "width", "", "height"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Integer, Integer, ah>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d.f
 * JD-Core Version:    0.7.0.1
 */