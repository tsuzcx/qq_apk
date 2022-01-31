package com.tencent.mm.plugin.game.f;

import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import java.lang.ref.WeakReference;

final class e$5
  implements j.a
{
  e$5(e parame, String paramString, float paramFloat, WeakReference paramWeakReference) {}
  
  public final void a(String paramString, l paraml)
  {
    if (this.val$appId.equals(paramString))
    {
      paramString = g.b(this.val$appId, 1, this.gco);
      if (paramString != null)
      {
        if ((this.lgy != null) && (this.lgy.get() != null)) {
          ((ImageView)this.lgy.get()).setImageBitmap(paramString);
        }
        e.a(this.lgp).put(this.val$appId, paramString);
        a.brn().d(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e.5
 * JD-Core Version:    0.7.0.1
 */