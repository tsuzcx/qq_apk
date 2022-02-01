package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.collect.model.j;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Iterator;
import java.util.List;

final class CollectBillUI$1
  implements i
{
  CollectBillUI$1(CollectBillUI paramCollectBillUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(64072);
    if ((paramq instanceof j))
    {
      paramString = (j)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.qwi.LgB;
        if ((paramString == null) || (paramString.isEmpty()))
        {
          CollectBillUI.a(this.qAe).setVisibility(8);
          AppMethodBeat.o(64072);
          return;
        }
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          paramq = (eh)paramString.next();
          if ((paramq.type == 1) && (!Util.isNullOrNil(paramq.dQx)))
          {
            Log.i("MicroMsg.CollectBillUI", "show notice");
            CollectBillUI.a(this.qAe).setText(paramq.dQx);
            CollectBillUI.a(this.qAe).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64071);
                b localb = new b();
                localb.bm(paramAnonymousView);
                a.b("com/tencent/mm/plugin/collect/ui/CollectBillUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                if (!Util.isNullOrNil(paramq.url)) {
                  f.p(CollectBillUI.1.this.qAe.getContext(), paramq.url, true);
                }
                a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64071);
              }
            });
            CollectBillUI.a(this.qAe).setVisibility(0);
            AppMethodBeat.o(64072);
            return;
          }
        }
        CollectBillUI.a(this.qAe).setVisibility(8);
        AppMethodBeat.o(64072);
        return;
      }
      Log.e("MicroMsg.CollectBillUI", "net error: %s", new Object[] { paramString });
      CollectBillUI.a(this.qAe).setVisibility(8);
    }
    AppMethodBeat.o(64072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.1
 * JD-Core Version:    0.7.0.1
 */