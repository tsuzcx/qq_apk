package com.tencent.mm.plugin.game.f;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import java.lang.ref.WeakReference;

final class e$5
  implements k.a
{
  e$5(e parame, String paramString, float paramFloat, WeakReference paramWeakReference) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(112333);
    if (this.val$appId.equals(paramString))
    {
      paramString = g.b(this.val$appId, 1, this.bBF);
      if (paramString != null)
      {
        if ((this.nEt != null) && (this.nEt.get() != null)) {
          ((ImageView)this.nEt.get()).setImageBitmap(paramString);
        }
        e.a(this.nEk).put(this.val$appId, paramString);
        a.cac().remove(this);
      }
    }
    AppMethodBeat.o(112333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e.5
 * JD-Core Version:    0.7.0.1
 */