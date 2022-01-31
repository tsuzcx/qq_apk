package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends BitmapDrawable
  implements x.a
{
  private static Bitmap bwa;
  private static ah dPu = new ah(Looper.getMainLooper());
  private Runnable dPw = new j.1(this);
  private Bitmap laK;
  private String mUrl;
  
  private j(String paramString) {}
  
  private j(String paramString, Bitmap paramBitmap)
  {
    super(paramBitmap);
    paramBitmap = getPaint();
    paramBitmap.setAntiAlias(true);
    paramBitmap.setFilterBitmap(true);
    x.a(this);
    setUrl(paramString);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((this.laK != null) && (!this.laK.isRecycled()))
    {
      Rect localRect1 = getBounds();
      Rect localRect2 = new Rect(0, 0, this.laK.getWidth(), this.laK.getHeight());
      paramCanvas.drawBitmap(this.laK, localRect2, localRect1, getPaint());
      return;
    }
    super.draw(paramCanvas);
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((this.mUrl != null) && (this.mUrl.hashCode().equals(paramString)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      y.i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
      this.laK = paramBitmap;
      dPu.post(this.dPw);
    }
  }
  
  public final void setUrl(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(this.mUrl)))
    {
      y.i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", new Object[] { paramString });
      this.mUrl = paramString;
      paramString = x.a(new aj(this.mUrl));
      if ((paramString != null) && (!paramString.isRecycled())) {
        this.laK = paramString;
      }
      dPu.post(this.dPw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.j
 * JD-Core Version:    0.7.0.1
 */