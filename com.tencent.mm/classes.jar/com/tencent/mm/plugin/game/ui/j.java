package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public final class j
  extends BitmapDrawable
  implements u.a
{
  private static Bitmap cTq;
  private static ap hxM;
  private Runnable hxO;
  private String mUrl;
  private Bitmap uox;
  
  static
  {
    AppMethodBeat.i(42083);
    hxM = new ap(Looper.getMainLooper());
    AppMethodBeat.o(42083);
  }
  
  private j(String paramString) {}
  
  private j(String paramString, Bitmap paramBitmap)
  {
    super(paramBitmap);
    AppMethodBeat.i(42079);
    this.hxO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42076);
        j.this.invalidateSelf();
        AppMethodBeat.o(42076);
      }
    };
    paramBitmap = getPaint();
    paramBitmap.setAntiAlias(true);
    paramBitmap.setFilterBitmap(true);
    u.a(this);
    setUrl(paramString);
    AppMethodBeat.o(42079);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(42081);
    if ((this.uox != null) && (!this.uox.isRecycled()))
    {
      Rect localRect1 = getBounds();
      Rect localRect2 = new Rect(0, 0, this.uox.getWidth(), this.uox.getHeight());
      paramCanvas.drawBitmap(this.uox, localRect2, localRect1, getPaint());
      AppMethodBeat.o(42081);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(42081);
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(42080);
    if ((this.mUrl != null) && (this.mUrl.hashCode().equals(paramString)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ad.i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
      this.uox = paramBitmap;
      hxM.post(this.hxO);
    }
    AppMethodBeat.o(42080);
  }
  
  public final void setUrl(String paramString)
  {
    AppMethodBeat.i(42082);
    if ((paramString != null) && (!paramString.equals(this.mUrl)))
    {
      ad.i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", new Object[] { paramString });
      this.mUrl = paramString;
      paramString = u.a(new ai(this.mUrl));
      if ((paramString != null) && (!paramString.isRecycled())) {
        this.uox = paramString;
      }
      hxM.post(this.hxO);
    }
    AppMethodBeat.o(42082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.j
 * JD-Core Version:    0.7.0.1
 */