package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.sdk.platformtools.al;

final class GameInstalledView$1
  implements g
{
  GameInstalledView$1(GameInstalledView paramGameInstalledView, View paramView) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(111997);
    if (paramb.status == 0) {
      al.d(new GameInstalledView.1.1(this));
    }
    AppMethodBeat.o(111997);
  }
  
  public final void tF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView.1
 * JD-Core Version:    0.7.0.1
 */