package com.tencent.mm.emoji.loader.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.loader.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;)V", "TAG", "", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class b
  extends i<Bitmap>
{
  private final String TAG;
  private final i.c<Bitmap> gWx;
  
  public b(EmojiInfo paramEmojiInfo, i.c<Bitmap> paramc)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105457);
    this.gWx = paramc;
    this.TAG = "MicroMsg.EmojiCoverBitmapRequest";
    AppMethodBeat.o(105457);
  }
  
  protected final c auF()
  {
    AppMethodBeat.i(105455);
    Object localObject = e.gVM;
    localObject = e.d(this.gWm);
    AppMethodBeat.o(105455);
    return localObject;
  }
  
  public final void dR(final boolean paramBoolean)
  {
    AppMethodBeat.i(105456);
    com.tencent.mm.emoji.loader.a.b localb = com.tencent.mm.emoji.loader.a.b.gVU;
    d.h((a)new a(this, paramBoolean, com.tencent.mm.emoji.loader.a.b.EP(this.gWm.getMd5())));
    AppMethodBeat.o(105456);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105454);
    Object localObject = com.tencent.mm.emoji.loader.a.b.gVU;
    localObject = com.tencent.mm.emoji.loader.a.b.EP(this.gWm.getMd5());
    Log.d(this.TAG, "start: " + this.gWm.getMd5() + ", " + localObject);
    if (localObject != null)
    {
      dR(true);
      AppMethodBeat.o(105454);
      return;
    }
    localObject = this.gWx;
    if (localObject != null) {
      ((i.c)localObject).aY(null);
    }
    i.b(this);
    AppMethodBeat.o(105454);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(b paramb, boolean paramBoolean, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.b
 * JD-Core Version:    0.7.0.1
 */