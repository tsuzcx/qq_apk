package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.k;
import java.util.Iterator;
import java.util.List;

final class CollectBillUI$1
  implements h
{
  CollectBillUI$1(CollectBillUI paramCollectBillUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(64072);
    if ((paramp instanceof com.tencent.mm.plugin.collect.model.i))
    {
      paramString = (com.tencent.mm.plugin.collect.model.i)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.wYD.ZfV;
        if ((paramString == null) || (paramString.isEmpty()))
        {
          CollectBillUI.a(this.xcw).setVisibility(8);
          AppMethodBeat.o(64072);
          return;
        }
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          paramp = (fa)paramString.next();
          if ((paramp.type == 1) && (!Util.isNullOrNil(paramp.wording)))
          {
            Log.i("MicroMsg.CollectBillUI", "show notice");
            CollectBillUI.a(this.xcw).setText(paramp.wording);
            CollectBillUI.a(this.xcw).setOnClickListener(new k()
            {
              public final void dr(View paramAnonymousView)
              {
                AppMethodBeat.i(293579);
                if (!Util.isNullOrNil(paramp.url)) {
                  com.tencent.mm.wallet_core.ui.i.p(CollectBillUI.1.this.xcw.getContext(), paramp.url, true);
                }
                AppMethodBeat.o(293579);
              }
            });
            CollectBillUI.a(this.xcw).setVisibility(0);
            AppMethodBeat.o(64072);
            return;
          }
        }
        CollectBillUI.a(this.xcw).setVisibility(8);
        AppMethodBeat.o(64072);
        return;
      }
      Log.e("MicroMsg.CollectBillUI", "net error: %s", new Object[] { paramString });
      CollectBillUI.a(this.xcw).setVisibility(8);
    }
    AppMethodBeat.o(64072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.1
 * JD-Core Version:    0.7.0.1
 */