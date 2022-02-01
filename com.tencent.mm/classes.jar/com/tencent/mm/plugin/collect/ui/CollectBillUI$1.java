package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.collect.model.j;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;

final class CollectBillUI$1
  implements com.tencent.mm.ak.f
{
  CollectBillUI$1(CollectBillUI paramCollectBillUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(64072);
    if ((paramn instanceof j))
    {
      paramString = (j)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.pgZ.GlX;
        if ((paramString == null) || (paramString.isEmpty()))
        {
          CollectBillUI.a(this.pkT).setVisibility(8);
          AppMethodBeat.o(64072);
          return;
        }
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          paramn = (dv)paramString.next();
          if ((paramn.type == 1) && (!bu.isNullOrNil(paramn.dyI)))
          {
            ae.i("MicroMsg.CollectBillUI", "show notice");
            CollectBillUI.a(this.pkT).setText(paramn.dyI);
            CollectBillUI.a(this.pkT).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64071);
                b localb = new b();
                localb.bd(paramAnonymousView);
                a.b("com/tencent/mm/plugin/collect/ui/CollectBillUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (!bu.isNullOrNil(paramn.url)) {
                  com.tencent.mm.wallet_core.ui.f.p(CollectBillUI.1.this.pkT.getContext(), paramn.url, true);
                }
                a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64071);
              }
            });
            CollectBillUI.a(this.pkT).setVisibility(0);
            AppMethodBeat.o(64072);
            return;
          }
        }
        CollectBillUI.a(this.pkT).setVisibility(8);
        AppMethodBeat.o(64072);
        return;
      }
      ae.e("MicroMsg.CollectBillUI", "net error: %s", new Object[] { paramString });
      CollectBillUI.a(this.pkT).setVisibility(8);
    }
    AppMethodBeat.o(64072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.1
 * JD-Core Version:    0.7.0.1
 */