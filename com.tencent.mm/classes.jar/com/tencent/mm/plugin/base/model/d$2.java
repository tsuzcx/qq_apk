package com.tencent.mm.plugin.base.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.ag.o;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class d$2
  implements com.tencent.mm.ag.d.a
{
  d$2(String paramString1, Context paramContext, d.a parama, String paramString2, String paramString3) {}
  
  public final void kk(String paramString)
  {
    if (!this.dol.equals(paramString)) {}
    do
    {
      do
      {
        do
        {
          return;
          y.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", new Object[] { paramString });
          d.Kd().remove(this);
          o.JQ().b(this);
          paramString = d.X(this.val$context, this.dol);
          if ((paramString != null) && (!paramString.isRecycled())) {
            break;
          }
        } while (this.hRN == null);
        this.hRN.el(false);
        return;
        paramString = d.a(this.val$context, this.dol, this.gge, this.hRO, paramString, true);
        if (paramString != null) {
          break;
        }
        y.e("MicroMsg.WebviewShrotcutManager", "intent is null");
      } while (this.hRN == null);
      this.hRN.el(false);
      return;
      b.n(this.val$context, paramString);
    } while (this.hRN == null);
    this.hRN.el(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.d.2
 * JD-Core Version:    0.7.0.1
 */