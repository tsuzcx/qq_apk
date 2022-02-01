package com.tencent.mm.emoji.b.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.emoji.b.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;)V", "TAG", "", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends h<Bitmap>
{
  private final String TAG;
  private final h.c<Bitmap> mgX;
  
  public b(EmojiInfo paramEmojiInfo, h.c<Bitmap> paramc)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105457);
    this.mgX = paramc;
    this.TAG = "MicroMsg.EmojiCoverBitmapRequest";
    AppMethodBeat.o(105457);
  }
  
  protected final c aUy()
  {
    AppMethodBeat.i(105455);
    Object localObject = e.mgl;
    localObject = e.d(this.mgK);
    AppMethodBeat.o(105455);
    return localObject;
  }
  
  public final void fc(boolean paramBoolean)
  {
    AppMethodBeat.i(105456);
    com.tencent.mm.emoji.b.a.b localb = com.tencent.mm.emoji.b.a.b.mgs;
    d.uiThread((a)new a(paramBoolean, com.tencent.mm.emoji.b.a.b.Eo(this.mgK.getMd5()), this));
    AppMethodBeat.o(105456);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105454);
    Object localObject = com.tencent.mm.emoji.b.a.b.mgs;
    localObject = com.tencent.mm.emoji.b.a.b.Eo(this.mgK.getMd5());
    Log.d(this.TAG, "start: " + this.mgK.getMd5() + ", " + localObject);
    if (localObject != null)
    {
      fc(true);
      AppMethodBeat.o(105454);
      return;
    }
    localObject = this.mgX;
    if (localObject != null) {
      ((h.c)localObject).a(h.aUz(), this.mgK, null);
    }
    h.b((h)this);
    AppMethodBeat.o(105454);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(boolean paramBoolean, Bitmap paramBitmap, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d.b
 * JD-Core Version:    0.7.0.1
 */