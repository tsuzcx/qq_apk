package com.tencent.mm.plugin.card.ui;

import android.widget.ImageView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.bk;

final class CardGiftVideoUI$4
  implements Runnable
{
  CardGiftVideoUI$4(CardGiftVideoUI paramCardGiftVideoUI, String paramString) {}
  
  public final void run()
  {
    if (bk.bl(CardGiftVideoUI.a(this.iuJ)))
    {
      CardGiftVideoUI.f(this.iuJ).setVisibility(0);
      Object localObject = new c.a();
      ((c.a)localObject).eri = e.bkH;
      o.OO();
      ((c.a)localObject).erB = null;
      ((c.a)localObject).erh = m.yn(this.val$filePath);
      ((c.a)localObject).erk = 1;
      ((c.a)localObject).erf = true;
      ((c.a)localObject).erd = true;
      localObject = ((c.a)localObject).OV();
      o.ON().a(this.val$filePath, CardGiftVideoUI.f(this.iuJ), (c)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.4
 * JD-Core Version:    0.7.0.1
 */