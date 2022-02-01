package com.tencent.mm.emoji.loader.d;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.a.b;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Landroid/widget/ImageView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/widget/ImageView;)V", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class c
  extends j<ImageView>
{
  public c(EmojiInfo paramEmojiInfo, ImageView paramImageView)
  {
    super(paramEmojiInfo, (View)paramImageView);
    AppMethodBeat.i(105462);
    AppMethodBeat.o(105462);
  }
  
  protected final com.tencent.mm.emoji.loader.e.c auF()
  {
    AppMethodBeat.i(105460);
    Object localObject = e.gVM;
    localObject = e.d(this.gWm);
    AppMethodBeat.o(105460);
    return localObject;
  }
  
  public final void dR(boolean paramBoolean)
  {
    AppMethodBeat.i(105461);
    super.dR(paramBoolean);
    Object localObject1 = this.gWH;
    if (localObject1 != null) {}
    for (localObject1 = (ImageView)((WeakReference)localObject1).get();; localObject1 = null)
    {
      Object localObject2 = b.gVU;
      localObject2 = b.EP(this.gWm.getMd5());
      Log.d(d.auD(), "onLoad: " + this.gWm.getMd5() + ", " + localObject2);
      com.tencent.mm.ac.d.h((a)new c.a(paramBoolean, (Bitmap)localObject2, (ImageView)localObject1));
      AppMethodBeat.o(105461);
      return;
    }
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105459);
    Object localObject = b.gVU;
    localObject = b.EP(this.gWm.getMd5());
    Log.d(d.auD(), "start: " + this.gWm.getMd5() + ", " + localObject);
    if (localObject != null)
    {
      dR(true);
      AppMethodBeat.o(105459);
      return;
    }
    localObject = this.gWH;
    if (localObject != null) {}
    for (localObject = (ImageView)((WeakReference)localObject).get();; localObject = null)
    {
      if (!(localObject instanceof CoverEmojiStatusView))
      {
        localObject = this.gWH;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.c
 * JD-Core Version:    0.7.0.1
 */