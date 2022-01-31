package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.d;

final class e$2
  implements g
{
  e$2(e parame, e.b paramb, e.a parama, ImageView paramImageView) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(112329);
    ab.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: ".concat(String.valueOf(paramString)));
    if ((paramb != null) && (paramb.bitmap != null))
    {
      Object localObject = paramb.bitmap;
      paramb = (b)localObject;
      if (this.nEm.nEu) {
        paramb = e.L((Bitmap)localObject);
      }
      localObject = paramb;
      if (this.nEm.iWq != 0) {
        localObject = d.a(paramb, true, this.nEm.iWq);
      }
      if (this.nEm.eNK) {
        e.b(this.nEk).f(paramString, localObject);
      }
      al.d(new e.2.1(this, (Bitmap)localObject));
      if (this.nEl != null) {
        this.nEl.a(paramView, (Bitmap)localObject);
      }
    }
    AppMethodBeat.o(112329);
  }
  
  public final void tF(String paramString)
  {
    AppMethodBeat.i(112328);
    ab.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(112328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e.2
 * JD-Core Version:    0.7.0.1
 */