package com.tencent.mm.plugin.location.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class m
  implements com.tencent.mm.bx.a.a
{
  private Bitmap iez = null;
  ab<String, Bitmap> lDR = new ab(20);
  
  public m()
  {
    try
    {
      this.iez = BackwardSupportUtil.b.a(ae.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      this.iez = c.a(this.iez, false, this.iez.getWidth() >> 1);
      return;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.TrackAvatarCacheService", localIOException, "", new Object[0]);
    }
  }
  
  public final Bitmap Gv(String paramString)
  {
    if (bk.bl(paramString)) {
      paramString = null;
    }
    Bitmap localBitmap;
    do
    {
      return paramString;
      y.d("MicroMsg.TrackAvatarCacheService", "getAvatar, tag = %s, cacheSize = %d", new Object[] { paramString, Integer.valueOf(this.lDR.size()) });
      localBitmap = (Bitmap)this.lDR.get(paramString);
      if (localBitmap == null) {
        break;
      }
      paramString = localBitmap;
    } while (!localBitmap.isRecycled());
    return null;
  }
  
  public final void n(String paramString, Bitmap paramBitmap)
  {
    if (this.lDR.get(paramString) != null)
    {
      Bitmap localBitmap = (Bitmap)this.lDR.get(paramString);
      if (!localBitmap.isRecycled()) {
        localBitmap.recycle();
      }
      this.lDR.remove(paramString);
    }
    this.lDR.put(paramString, paramBitmap);
    y.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", new Object[] { paramString, Integer.valueOf(this.lDR.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.m
 * JD-Core Version:    0.7.0.1
 */