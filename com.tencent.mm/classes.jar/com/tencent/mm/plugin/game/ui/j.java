package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class j
  extends BitmapDrawable
  implements x.a
{
  private static Bitmap bXF;
  private static ak feT;
  private Runnable feV;
  private String mUrl;
  private Bitmap nyG;
  
  static
  {
    AppMethodBeat.i(111912);
    feT = new ak(Looper.getMainLooper());
    AppMethodBeat.o(111912);
  }
  
  private j(String paramString) {}
  
  private j(String paramString, Bitmap paramBitmap)
  {
    super(paramBitmap);
    AppMethodBeat.i(111908);
    this.feV = new j.1(this);
    paramBitmap = getPaint();
    paramBitmap.setAntiAlias(true);
    paramBitmap.setFilterBitmap(true);
    x.a(this);
    setUrl(paramString);
    AppMethodBeat.o(111908);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(111910);
    if ((this.nyG != null) && (!this.nyG.isRecycled()))
    {
      Rect localRect1 = getBounds();
      Rect localRect2 = new Rect(0, 0, this.nyG.getWidth(), this.nyG.getHeight());
      paramCanvas.drawBitmap(this.nyG, localRect2, localRect1, getPaint());
      AppMethodBeat.o(111910);
      return;
    }
    super.draw(paramCanvas);
    AppMethodBeat.o(111910);
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111909);
    if ((this.mUrl != null) && (this.mUrl.hashCode().equals(paramString)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ab.i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
      this.nyG = paramBitmap;
      feT.post(this.feV);
    }
    AppMethodBeat.o(111909);
  }
  
  public final void setUrl(String paramString)
  {
    AppMethodBeat.i(111911);
    if ((paramString != null) && (!paramString.equals(this.mUrl)))
    {
      ab.i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", new Object[] { paramString });
      this.mUrl = paramString;
      paramString = x.a(new ai(this.mUrl));
      if ((paramString != null) && (!paramString.isRecycled())) {
        this.nyG = paramString;
      }
      feT.post(this.feV);
    }
    AppMethodBeat.o(111911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.j
 * JD-Core Version:    0.7.0.1
 */