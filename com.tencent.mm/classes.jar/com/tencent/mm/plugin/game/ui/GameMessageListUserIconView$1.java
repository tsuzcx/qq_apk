package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.f.e.b;

final class GameMessageListUserIconView$1
  extends e.b
{
  GameMessageListUserIconView$1(GameMessageListUserIconView paramGameMessageListUserIconView, String paramString) {}
  
  public final void a(View paramView, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      GameMessageListUserIconView.a(this.ldU).put(this.val$url, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageListUserIconView.1
 * JD-Core Version:    0.7.0.1
 */