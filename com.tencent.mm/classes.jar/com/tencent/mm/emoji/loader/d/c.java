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
import d.y;
import java.lang.ref.WeakReference;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Landroid/widget/ImageView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/widget/ImageView;)V", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class c
  extends j<ImageView>
{
  public c(EmojiInfo paramEmojiInfo, ImageView paramImageView)
  {
    super(paramEmojiInfo, (View)paramImageView);
    AppMethodBeat.i(105462);
    AppMethodBeat.o(105462);
  }
  
  protected final com.tencent.mm.emoji.loader.e.c abd()
  {
    AppMethodBeat.i(105460);
    Object localObject = e.fLn;
    localObject = e.d(this.fLP);
    AppMethodBeat.o(105460);
    return localObject;
  }
  
  public final void dg(boolean paramBoolean)
  {
    AppMethodBeat.i(105461);
    super.dg(paramBoolean);
    Object localObject1 = this.fMm;
    if (localObject1 != null) {}
    for (localObject1 = (ImageView)((WeakReference)localObject1).get();; localObject1 = null)
    {
      Object localObject2 = b.fLw;
      localObject2 = b.pT(this.fLP.JS());
      ad.d(d.abb(), "onLoad: " + this.fLP.JS() + ", " + localObject2);
      com.tencent.mm.ad.c.g((a)new a(paramBoolean, (Bitmap)localObject2, (ImageView)localObject1));
      AppMethodBeat.o(105461);
      return;
    }
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105459);
    Object localObject = b.fLw;
    localObject = b.pT(this.fLP.JS());
    ad.d(d.abb(), "start: " + this.fLP.JS() + ", " + localObject);
    if (localObject != null)
    {
      dg(true);
      AppMethodBeat.o(105459);
      return;
    }
    localObject = this.fMm;
    if (localObject != null) {}
    for (localObject = (ImageView)((WeakReference)localObject).get();; localObject = null)
    {
      if (!(localObject instanceof CoverEmojiStatusView))
      {
        localObject = this.fMm;
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(boolean paramBoolean, Bitmap paramBitmap, ImageView paramImageView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.c
 * JD-Core Version:    0.7.0.1
 */