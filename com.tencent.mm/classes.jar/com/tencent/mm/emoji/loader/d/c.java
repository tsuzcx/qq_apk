package com.tencent.mm.emoji.loader.d;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.a.b;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.a;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Landroid/widget/ImageView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/widget/ImageView;)V", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class c
  extends j<ImageView>
{
  public c(EmojiInfo paramEmojiInfo, ImageView paramImageView)
  {
    super(paramEmojiInfo, (View)paramImageView);
    AppMethodBeat.i(105462);
    AppMethodBeat.o(105462);
  }
  
  protected final com.tencent.mm.emoji.loader.e.c aeF()
  {
    AppMethodBeat.i(105460);
    Object localObject = e.giz;
    localObject = e.d(this.gjb);
    AppMethodBeat.o(105460);
    return localObject;
  }
  
  public final void dh(boolean paramBoolean)
  {
    AppMethodBeat.i(105461);
    super.dh(paramBoolean);
    Object localObject1 = this.gjy;
    if (localObject1 != null) {}
    for (localObject1 = (ImageView)((WeakReference)localObject1).get();; localObject1 = null)
    {
      Object localObject2 = b.giI;
      localObject2 = b.vT(this.gjb.Lb());
      ad.d(d.aeD(), "onLoad: " + this.gjb.Lb() + ", " + localObject2);
      com.tencent.mm.ad.c.g((a)new c.a(paramBoolean, (Bitmap)localObject2, (ImageView)localObject1));
      AppMethodBeat.o(105461);
      return;
    }
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105459);
    Object localObject = b.giI;
    localObject = b.vT(this.gjb.Lb());
    ad.d(d.aeD(), "start: " + this.gjb.Lb() + ", " + localObject);
    if (localObject != null)
    {
      dh(true);
      AppMethodBeat.o(105459);
      return;
    }
    localObject = this.gjy;
    if (localObject != null) {}
    for (localObject = (ImageView)((WeakReference)localObject).get();; localObject = null)
    {
      if (!(localObject instanceof CoverEmojiStatusView))
      {
        localObject = this.gjy;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.c
 * JD-Core Version:    0.7.0.1
 */