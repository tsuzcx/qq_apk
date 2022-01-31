package com.tencent.mm.plugin.collect.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.model.j;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

final class CollectBillUI$1
  implements f
{
  CollectBillUI$1(CollectBillUI paramCollectBillUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41211);
    if ((paramm instanceof j))
    {
      paramString = (j)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.kNs.wHW;
        if ((paramString == null) || (paramString.isEmpty()))
        {
          CollectBillUI.a(this.kRi).setVisibility(8);
          AppMethodBeat.o(41211);
          return;
        }
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          paramm = (dg)paramString.next();
          if ((paramm.type == 1) && (!bo.isNullOrNil(paramm.cyA)))
          {
            ab.i("MicroMsg.CollectBillUI", "show notice");
            CollectBillUI.a(this.kRi).setText(paramm.cyA);
            CollectBillUI.a(this.kRi).setOnClickListener(new CollectBillUI.1.1(this, paramm));
            CollectBillUI.a(this.kRi).setVisibility(0);
            AppMethodBeat.o(41211);
            return;
          }
        }
        CollectBillUI.a(this.kRi).setVisibility(8);
        AppMethodBeat.o(41211);
        return;
      }
      ab.e("MicroMsg.CollectBillUI", "net error: %s", new Object[] { paramString });
      CollectBillUI.a(this.kRi).setVisibility(8);
    }
    AppMethodBeat.o(41211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.1
 * JD-Core Version:    0.7.0.1
 */