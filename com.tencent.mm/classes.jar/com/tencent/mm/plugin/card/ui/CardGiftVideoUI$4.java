package com.tencent.mm.plugin.card.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.bo;

final class CardGiftVideoUI$4
  implements Runnable
{
  CardGiftVideoUI$4(CardGiftVideoUI paramCardGiftVideoUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(88451);
    if (bo.isNullOrNil(CardGiftVideoUI.a(this.kvN)))
    {
      CardGiftVideoUI.f(this.kvN).setVisibility(0);
      Object localObject = new c.a();
      ((c.a)localObject).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject).eOd = null;
      ((c.a)localObject).eNO = m.HO(this.val$filePath);
      ((c.a)localObject).fHt = 1;
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eNK = true;
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(this.val$filePath, CardGiftVideoUI.f(this.kvN), (c)localObject);
    }
    AppMethodBeat.o(88451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.4
 * JD-Core Version:    0.7.0.1
 */