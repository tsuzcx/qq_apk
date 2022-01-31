package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import org.json.JSONObject;

final class MallWalletSectionCellView$2
  implements View.OnClickListener
{
  MallWalletSectionCellView$2(MallWalletSectionCellView paramMallWalletSectionCellView, cje paramcje, JSONObject paramJSONObject) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43250);
    com.tencent.mm.plugin.wallet_core.utils.e.a(this.oAI.getContext(), this.oAJ.wna);
    MallWalletSectionCellView.a(this.oAI);
    if ((this.oAK != null) && (this.oAJ.xTt != null))
    {
      this.oAK.remove(this.oAJ.xTt.xcz);
      this.oAK.remove(String.format("%s_expiretime", new Object[] { this.oAJ.xTt.xcz }));
      g.RL().Ru().set(ac.a.yJd, this.oAK.toString());
    }
    paramView = "";
    int i;
    if (this.oAJ.wna.type == 1)
    {
      paramView = this.oAJ.wna.url;
      i = 1;
    }
    for (;;)
    {
      h.qsU.e(16502, new Object[] { Integer.valueOf(2), paramView, Integer.valueOf(i) });
      AppMethodBeat.o(43250);
      return;
      if (this.oAJ.wna.type == 2)
      {
        if (this.oAJ.wna.xJx != null) {
          paramView = this.oAJ.wna.xJx.username;
        }
        i = 2;
      }
      else if (this.oAJ.wna.type == 4)
      {
        paramView = this.oAJ.wna.url;
        i = 3;
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView.2
 * JD-Core Version:    0.7.0.1
 */