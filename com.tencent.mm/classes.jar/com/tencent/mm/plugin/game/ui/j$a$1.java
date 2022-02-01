package com.tencent.mm.plugin.game.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

final class j$a$1
  implements k.a
{
  j$a$1(String paramString, float paramFloat, ImageView paramImageView) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(42077);
    if (this.val$appId.equals(paramString))
    {
      paramString = h.c(this.val$appId, 1, this.ckH);
      if (paramString != null)
      {
        this.qeK.setImageBitmap(paramString);
        a.dxQ().remove(this);
      }
    }
    AppMethodBeat.o(42077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.j.a.1
 * JD-Core Version:    0.7.0.1
 */