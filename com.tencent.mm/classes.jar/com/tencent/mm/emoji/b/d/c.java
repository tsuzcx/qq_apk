package com.tencent.mm.emoji.b.d;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.a.b;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Landroid/widget/ImageView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "emptyDrawable", "Landroid/graphics/drawable/Drawable;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;)V", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends i<ImageView>
{
  private final Drawable dvA;
  
  public c(EmojiInfo paramEmojiInfo, ImageView paramImageView, Drawable paramDrawable)
  {
    super(paramEmojiInfo, (View)paramImageView);
    AppMethodBeat.i(242741);
    this.dvA = paramDrawable;
    AppMethodBeat.o(242741);
  }
  
  protected final com.tencent.mm.emoji.b.e.c aUy()
  {
    AppMethodBeat.i(105460);
    Object localObject = e.mgl;
    localObject = e.d(this.mgK);
    AppMethodBeat.o(105460);
    return localObject;
  }
  
  public final void fc(final boolean paramBoolean)
  {
    AppMethodBeat.i(105461);
    super.fc(paramBoolean);
    Object localObject = b.mgs;
    localObject = b.Eo(this.mgK.getMd5());
    Log.d(d.aUw(), "onLoad: " + this.mgK.getMd5() + ", " + localObject);
    com.tencent.mm.ae.d.uiThread((a)new a(this, paramBoolean, (Bitmap)localObject));
    AppMethodBeat.o(105461);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105459);
    Object localObject = b.mgs;
    localObject = b.Eo(this.mgK.getMd5());
    Log.d(d.aUw(), "start: " + this.mgK.getMd5() + ", " + localObject);
    if (localObject != null)
    {
      fc(true);
      AppMethodBeat.o(105459);
      return;
    }
    localObject = this.mhj;
    if (localObject != null)
    {
      localObject = (ImageView)((WeakReference)localObject).get();
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(this.dvA);
      }
    }
    h.b((h)this);
    AppMethodBeat.o(105459);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(c paramc, boolean paramBoolean, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d.c
 * JD-Core Version:    0.7.0.1
 */