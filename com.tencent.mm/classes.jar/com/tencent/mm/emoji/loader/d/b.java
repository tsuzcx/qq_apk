package com.tencent.mm.emoji.loader.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.a;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;)V", "TAG", "", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class b
  extends i<Bitmap>
{
  private final String TAG;
  private final i.c<Bitmap> fMc;
  
  public b(EmojiInfo paramEmojiInfo, i.c<Bitmap> paramc)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105457);
    this.fMc = paramc;
    this.TAG = "MicroMsg.EmojiCoverBitmapRequest";
    AppMethodBeat.o(105457);
  }
  
  protected final com.tencent.mm.emoji.loader.e.c abd()
  {
    AppMethodBeat.i(105455);
    Object localObject = e.fLn;
    localObject = e.d(this.fLP);
    AppMethodBeat.o(105455);
    return localObject;
  }
  
  public final void dg(final boolean paramBoolean)
  {
    AppMethodBeat.i(105456);
    com.tencent.mm.emoji.loader.a.b localb = com.tencent.mm.emoji.loader.a.b.fLw;
    com.tencent.mm.ad.c.g((a)new a(this, paramBoolean, com.tencent.mm.emoji.loader.a.b.pT(this.fLP.JS())));
    AppMethodBeat.o(105456);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105454);
    Object localObject = com.tencent.mm.emoji.loader.a.b.fLw;
    localObject = com.tencent.mm.emoji.loader.a.b.pT(this.fLP.JS());
    ad.d(this.TAG, "start: " + this.fLP.JS() + ", " + localObject);
    if (localObject != null)
    {
      dg(true);
      AppMethodBeat.o(105454);
      return;
    }
    localObject = this.fMc;
    if (localObject != null) {
      ((i.c)localObject).aS(null);
    }
    i.b(this);
    AppMethodBeat.o(105454);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(b paramb, boolean paramBoolean, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.b
 * JD-Core Version:    0.7.0.1
 */