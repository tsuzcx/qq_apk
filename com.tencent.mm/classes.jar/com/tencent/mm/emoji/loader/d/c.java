package com.tencent.mm.emoji.loader.d;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.a.b;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.a;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Landroid/widget/ImageView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/widget/ImageView;)V", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class c
  extends j<ImageView>
{
  public c(EmojiInfo paramEmojiInfo, ImageView paramImageView)
  {
    super(paramEmojiInfo, (View)paramImageView);
    AppMethodBeat.i(105462);
    AppMethodBeat.o(105462);
  }
  
  protected final com.tencent.mm.emoji.loader.e.c aeR()
  {
    AppMethodBeat.i(105460);
    Object localObject = e.gkR;
    localObject = e.d(this.glt);
    AppMethodBeat.o(105460);
    return localObject;
  }
  
  public final void dh(boolean paramBoolean)
  {
    AppMethodBeat.i(105461);
    super.dh(paramBoolean);
    Object localObject1 = this.glQ;
    if (localObject1 != null) {}
    for (localObject1 = (ImageView)((WeakReference)localObject1).get();; localObject1 = null)
    {
      Object localObject2 = b.gla;
      localObject2 = b.wA(this.glt.Lj());
      ae.d(d.aeP(), "onLoad: " + this.glt.Lj() + ", " + localObject2);
      com.tencent.mm.ac.c.h((a)new c.a(paramBoolean, (Bitmap)localObject2, (ImageView)localObject1));
      AppMethodBeat.o(105461);
      return;
    }
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105459);
    Object localObject = b.gla;
    localObject = b.wA(this.glt.Lj());
    ae.d(d.aeP(), "start: " + this.glt.Lj() + ", " + localObject);
    if (localObject != null)
    {
      dh(true);
      AppMethodBeat.o(105459);
      return;
    }
    localObject = this.glQ;
    if (localObject != null) {}
    for (localObject = (ImageView)((WeakReference)localObject).get();; localObject = null)
    {
      if (!(localObject instanceof CoverEmojiStatusView))
      {
        localObject = this.glQ;
        if (localObject != null)
        {
          localObject = (ImageView)((WeakReference)localObject).get();
          if (localObject != null) {
            ((ImageView)localObject).setImageDrawable(null);
          }
        }
      }
      i.b(this);
      AppMethodBeat.o(105459);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.c
 * JD-Core Version:    0.7.0.1
 */