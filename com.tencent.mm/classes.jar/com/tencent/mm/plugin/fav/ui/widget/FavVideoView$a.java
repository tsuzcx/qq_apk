package com.tencent.mm.plugin.fav.ui.widget;

import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class FavVideoView$a
  implements p, com.tencent.mm.plugin.record.a.c
{
  private FavVideoView$a(FavVideoView paramFavVideoView) {}
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    y.d("MicroMsg.FavVideoView", "onCdnStatusChanged status:%s, offset:%s, totalLength:%s, path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (((paramInt1 == 3) || (paramInt1 == 2)) && (e.bK(paramString)))
    {
      FavVideoView.a(this.kjX).stop();
      FavVideoView.g(this.kjX);
      FavVideoView.a(this.kjX, paramString);
      ai.d(new FavVideoView.a.1(this));
      return;
    }
    FavVideoView.a(this.kjX, paramInt2, paramInt3);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.f paramf)
  {
    if (paramf == null) {}
    while (!paramf.field_dataId.equals(FavVideoView.f(this.kjX))) {
      return;
    }
    a(paramf.field_status, paramf.field_path, paramf.field_offset, paramf.field_totalLen);
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    if (paramc == null) {}
    while ((bk.bl(paramc.field_dataId)) || (!paramc.field_dataId.equals(FavVideoView.f(this.kjX)))) {
      return;
    }
    a(paramc.field_status, paramc.field_path, paramc.field_offset, paramc.field_totalLen);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavVideoView.a
 * JD-Core Version:    0.7.0.1
 */