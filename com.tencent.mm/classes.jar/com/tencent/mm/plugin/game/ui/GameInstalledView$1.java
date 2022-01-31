package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.d.b;
import com.tencent.mm.sdk.platformtools.ai;

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
    if (paramb.status == 0) {
      ai.d(new GameInstalledView.1.1(this));
    }
  }
  
  public final void mv(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView.1
 * JD-Core Version:    0.7.0.1
 */