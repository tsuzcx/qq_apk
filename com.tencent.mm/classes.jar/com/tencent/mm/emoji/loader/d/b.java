package com.tencent.mm.emoji.loader.d;

import a.l;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Landroid/widget/ImageView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/widget/ImageView;)V", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class b
  extends i<ImageView>
{
  public b(EmojiInfo paramEmojiInfo, ImageView paramImageView)
  {
    super(paramEmojiInfo, (View)paramImageView);
    AppMethodBeat.i(63207);
    AppMethodBeat.o(63207);
  }
  
  protected final com.tencent.mm.emoji.loader.e.c Ov()
  {
    AppMethodBeat.i(63205);
    Object localObject = com.tencent.mm.emoji.loader.a.evk;
    localObject = com.tencent.mm.emoji.loader.a.b(this.evH);
    AppMethodBeat.o(63205);
    return localObject;
  }
  
  public final void cf(boolean paramBoolean)
  {
    AppMethodBeat.i(63206);
    super.cf(paramBoolean);
    Object localObject1 = this.evZ;
    if (localObject1 != null) {}
    for (localObject1 = (ImageView)((WeakReference)localObject1).get();; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.emoji.loader.a.b.evt;
      localObject2 = com.tencent.mm.emoji.loader.a.b.lK(this.evH.Al());
      ab.d(c.Ot(), "onLoad: " + this.evH.Al() + ", " + localObject2);
      com.tencent.mm.ab.b.b((a.f.a.a)new b.a(paramBoolean, (Bitmap)localObject2, (ImageView)localObject1));
      AppMethodBeat.o(63206);
      return;
    }
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(151758);
    Object localObject = com.tencent.mm.emoji.loader.a.b.evt;
    localObject = com.tencent.mm.emoji.loader.a.b.lK(this.evH.Al());
    ab.d(c.Ot(), "start: " + this.evH.Al() + ", " + localObject);
    if (localObject != null)
    {
      cf(true);
      AppMethodBeat.o(151758);
      return;
    }
    localObject = this.evZ;
    if (localObject != null)
    {
      localObject = (ImageView)((WeakReference)localObject).get();
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(null);
      }
    }
    h.a(this);
    AppMethodBeat.o(151758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.b
 * JD-Core Version:    0.7.0.1
 */