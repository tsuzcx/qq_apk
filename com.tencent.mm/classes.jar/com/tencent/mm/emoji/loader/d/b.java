package com.tencent.mm.emoji.loader.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.a;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;)V", "TAG", "", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class b
  extends i<Bitmap>
{
  private final String TAG;
  private final i.c<Bitmap> gjo;
  
  public b(EmojiInfo paramEmojiInfo, i.c<Bitmap> paramc)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105457);
    this.gjo = paramc;
    this.TAG = "MicroMsg.EmojiCoverBitmapRequest";
    AppMethodBeat.o(105457);
  }
  
  protected final com.tencent.mm.emoji.loader.e.c aeF()
  {
    AppMethodBeat.i(105455);
    Object localObject = e.giz;
    localObject = e.d(this.gjb);
    AppMethodBeat.o(105455);
    return localObject;
  }
  
  public final void dh(final boolean paramBoolean)
  {
    AppMethodBeat.i(105456);
    com.tencent.mm.emoji.loader.a.b localb = com.tencent.mm.emoji.loader.a.b.giI;
    com.tencent.mm.ad.c.g((a)new a(this, paramBoolean, com.tencent.mm.emoji.loader.a.b.vT(this.gjb.Lb())));
    AppMethodBeat.o(105456);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105454);
    Object localObject = com.tencent.mm.emoji.loader.a.b.giI;
    localObject = com.tencent.mm.emoji.loader.a.b.vT(this.gjb.Lb());
    ad.d(this.TAG, "start: " + this.gjb.Lb() + ", " + localObject);
    if (localObject != null)
    {
      dh(true);
      AppMethodBeat.o(105454);
      return;
    }
    localObject = this.gjo;
    if (localObject != null) {
      ((i.c)localObject).aR(null);
    }
    i.b(this);
    AppMethodBeat.o(105454);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.b
 * JD-Core Version:    0.7.0.1
 */