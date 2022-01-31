package com.tencent.mm.plugin.game.ui;

import android.widget.ImageView;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

final class j$a$1
  implements j.a
{
  j$a$1(String paramString, float paramFloat, ImageView paramImageView) {}
  
  public final void a(String paramString, l paraml)
  {
    if (this.val$appId.equals(paramString))
    {
      paramString = g.b(this.val$appId, 1, this.gco);
      if (paramString != null)
      {
        this.jxK.setImageBitmap(paramString);
        a.brn().d(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.j.a.1
 * JD-Core Version:    0.7.0.1
 */