package com.tencent.mm.emoji.loader.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.a;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;)V", "TAG", "", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class b
  extends i<Bitmap>
{
  private final String TAG;
  private final i.c<Bitmap> fPO;
  
  public b(EmojiInfo paramEmojiInfo, i.c<Bitmap> paramc)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105457);
    this.fPO = paramc;
    this.TAG = "MicroMsg.EmojiCoverBitmapRequest";
    AppMethodBeat.o(105457);
  }
  
  protected final com.tencent.mm.emoji.loader.e.c acb()
  {
    AppMethodBeat.i(105455);
    Object localObject = e.fOZ;
    localObject = e.d(this.fPB);
    AppMethodBeat.o(105455);
    return localObject;
  }
  
  public final void df(final boolean paramBoolean)
  {
    AppMethodBeat.i(105456);
    com.tencent.mm.emoji.loader.a.b localb = com.tencent.mm.emoji.loader.a.b.fPi;
    com.tencent.mm.ac.c.g((a)new a(this, paramBoolean, com.tencent.mm.emoji.loader.a.b.te(this.fPB.JC())));
    AppMethodBeat.o(105456);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105454);
    Object localObject = com.tencent.mm.emoji.loader.a.b.fPi;
    localObject = com.tencent.mm.emoji.loader.a.b.te(this.fPB.JC());
    ac.d(this.TAG, "start: " + this.fPB.JC() + ", " + localObject);
    if (localObject != null)
    {
      df(true);
      AppMethodBeat.o(105454);
      return;
    }
    localObject = this.fPO;
    if (localObject != null) {
      ((i.c)localObject).aP(null);
    }
    i.b(this);
    AppMethodBeat.o(105454);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.b
 * JD-Core Version:    0.7.0.1
 */