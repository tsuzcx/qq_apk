package com.tencent.mm.emoji.loader.d;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.a.b;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.a;
import d.l;
import java.lang.ref.WeakReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Landroid/widget/ImageView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/widget/ImageView;)V", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class c
  extends j<ImageView>
{
  public c(EmojiInfo paramEmojiInfo, ImageView paramImageView)
  {
    super(paramEmojiInfo, (View)paramImageView);
    AppMethodBeat.i(105462);
    AppMethodBeat.o(105462);
  }
  
  protected final com.tencent.mm.emoji.loader.e.c acb()
  {
    AppMethodBeat.i(105460);
    Object localObject = e.fOZ;
    localObject = e.d(this.fPB);
    AppMethodBeat.o(105460);
    return localObject;
  }
  
  public final void df(boolean paramBoolean)
  {
    AppMethodBeat.i(105461);
    super.df(paramBoolean);
    Object localObject1 = this.fPY;
    if (localObject1 != null) {}
    for (localObject1 = (ImageView)((WeakReference)localObject1).get();; localObject1 = null)
    {
      Object localObject2 = b.fPi;
      localObject2 = b.te(this.fPB.JC());
      ac.d(d.abZ(), "onLoad: " + this.fPB.JC() + ", " + localObject2);
      com.tencent.mm.ac.c.g((a)new c.a(paramBoolean, (Bitmap)localObject2, (ImageView)localObject1));
      AppMethodBeat.o(105461);
      return;
    }
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105459);
    Object localObject = b.fPi;
    localObject = b.te(this.fPB.JC());
    ac.d(d.abZ(), "start: " + this.fPB.JC() + ", " + localObject);
    if (localObject != null)
    {
      df(true);
      AppMethodBeat.o(105459);
      return;
    }
    localObject = this.fPY;
    if (localObject != null) {}
    for (localObject = (ImageView)((WeakReference)localObject).get();; localObject = null)
    {
      if (!(localObject instanceof CoverEmojiStatusView))
      {
        localObject = this.fPY;
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