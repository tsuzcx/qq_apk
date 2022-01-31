package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  extends a
{
  c$1(c paramc) {}
  
  public final void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    super.a(paramLong1, paramLong2, paramString, paramInt);
    y.d("MicroMsg.MediaHistoryGalleryUI", "summerhardcoder sync fps scene:%s vs %s, droppedFrames:%s, lastFrameNanos:%d, frameNanos:%d", new Object[] { paramString, this.khw.getClass().getSimpleName(), Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((paramInt > 0) && (!bk.bl(paramString)) && (paramString.endsWith(this.khw.getClass().getSimpleName()))) {
      this.khw.dFe += paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c.1
 * JD-Core Version:    0.7.0.1
 */