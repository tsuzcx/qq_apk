package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

public final class j
  extends BitmapDrawable
  implements u.a
{
  private static Bitmap dku;
  private static MMHandler iuH;
  private Runnable iuJ;
  private String mUrl;
  private Bitmap xRS;
  
  static
  {
    AppMethodBeat.i(42083);
    iuH = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(42083);
  }
  
  private j(String paramString) {}
  
  private j(String paramString, Bitmap paramBitmap)
  {
    super(paramBitmap);
    AppMethodBeat.i(42079);
    this.iuJ = new Runnable()
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
    if ((this.xRS != null) && (!this.xRS.isRecycled()))
    {
      Rect localRect1 = getBounds();
      Rect localRect2 = new Rect(0, 0, this.xRS.getWidth(), this.xRS.getHeight());
      paramCanvas.drawBitmap(this.xRS, localRect2, localRect1, getPaint());
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
      Log.i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
      this.xRS = paramBitmap;
      iuH.post(this.iuJ);
    }
    AppMethodBeat.o(42080);
  }
  
  public final void setUrl(String paramString)
  {
    AppMethodBeat.i(42082);
    if ((paramString != null) && (!paramString.equals(this.mUrl)))
    {
      Log.i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", new Object[] { paramString });
      this.mUrl = paramString;
      paramString = u.a(new ai(this.mUrl));
      if ((paramString != null) && (!paramString.isRecycled())) {
        this.xRS = paramString;
      }
      iuH.post(this.iuJ);
    }
    AppMethodBeat.o(42082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.j
 * JD-Core Version:    0.7.0.1
 */