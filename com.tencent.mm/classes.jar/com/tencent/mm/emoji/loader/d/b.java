package com.tencent.mm.emoji.loader.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.a;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;)V", "TAG", "", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class b
  extends i<Bitmap>
{
  private final String TAG;
  private final i.c<Bitmap> glG;
  
  public b(EmojiInfo paramEmojiInfo, i.c<Bitmap> paramc)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105457);
    this.glG = paramc;
    this.TAG = "MicroMsg.EmojiCoverBitmapRequest";
    AppMethodBeat.o(105457);
  }
  
  protected final com.tencent.mm.emoji.loader.e.c aeR()
  {
    AppMethodBeat.i(105455);
    Object localObject = e.gkR;
    localObject = e.d(this.glt);
    AppMethodBeat.o(105455);
    return localObject;
  }
  
  public final void dh(final boolean paramBoolean)
  {
    AppMethodBeat.i(105456);
    com.tencent.mm.emoji.loader.a.b localb = com.tencent.mm.emoji.loader.a.b.gla;
    com.tencent.mm.ac.c.h((a)new a(this, paramBoolean, com.tencent.mm.emoji.loader.a.b.wA(this.glt.Lj())));
    AppMethodBeat.o(105456);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105454);
    Object localObject = com.tencent.mm.emoji.loader.a.b.gla;
    localObject = com.tencent.mm.emoji.loader.a.b.wA(this.glt.Lj());
    ae.d(this.TAG, "start: " + this.glt.Lj() + ", " + localObject);
    if (localObject != null)
    {
      dh(true);
      AppMethodBeat.o(105454);
      return;
    }
    localObject = this.glG;
    if (localObject != null) {
      ((i.c)localObject).aR(null);
    }
    i.b(this);
    AppMethodBeat.o(105454);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(b paramb, boolean paramBoolean, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.b
 * JD-Core Version:    0.7.0.1
 */