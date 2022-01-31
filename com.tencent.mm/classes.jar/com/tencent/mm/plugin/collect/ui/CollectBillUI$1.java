package com.tencent.mm.plugin.collect.ui;

import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.b.j;
import com.tencent.mm.protocal.c.cx;
import com.tencent.mm.protocal.c.mq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class CollectBillUI$1
  implements f
{
  CollectBillUI$1(CollectBillUI paramCollectBillUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof j))
    {
      paramString = (j)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label170;
      }
      paramString = paramString.iHn.sKm;
      if ((paramString == null) || (paramString.isEmpty())) {
        CollectBillUI.a(this.iKD).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      paramm = (cx)paramString.next();
      if ((paramm.type == 1) && (!bk.bl(paramm.bQZ)))
      {
        y.i("MicroMsg.CollectBillUI", "show notice");
        CollectBillUI.a(this.iKD).setText(paramm.bQZ);
        CollectBillUI.a(this.iKD).setOnClickListener(new CollectBillUI.1.1(this, paramm));
        CollectBillUI.a(this.iKD).setVisibility(0);
        return;
      }
    }
    CollectBillUI.a(this.iKD).setVisibility(8);
    return;
    label170:
    y.e("MicroMsg.CollectBillUI", "net error: %s", new Object[] { paramString });
    CollectBillUI.a(this.iKD).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.1
 * JD-Core Version:    0.7.0.1
 */