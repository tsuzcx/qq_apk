package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.ui.e.d;
import com.tencent.mm.plugin.card.ui.n;
import java.util.ArrayList;

final class x$1
  implements View.OnClickListener
{
  x$1(x paramx) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88784);
    if (!(paramView.getTag() instanceof r))
    {
      AppMethodBeat.o(88784);
      return;
    }
    Object localObject = this.kBP.kBh.bdv();
    this.kBP.kBh.bdx();
    paramView = (r)paramView.getTag();
    if (paramView == null)
    {
      AppMethodBeat.o(88784);
      return;
    }
    if ((paramView.kqk == null) || (paramView.kqk.isEmpty()))
    {
      AppMethodBeat.o(88784);
      return;
    }
    if ((paramView.kqi != null) && (paramView.kqi.equals(((com.tencent.mm.plugin.card.base.b)localObject).bbj())))
    {
      this.kBP.kBM.setVisibility(8);
      this.kBP.kBh.bcI();
      AppMethodBeat.o(88784);
      return;
    }
    if ((TextUtils.isEmpty(paramView.kqi)) && (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bbj())))
    {
      this.kBP.kBM.setVisibility(8);
      this.kBP.kBh.bcI();
      AppMethodBeat.o(88784);
      return;
    }
    localObject = com.tencent.mm.plugin.card.sharecard.a.b.HS(paramView.kml);
    int k;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int j = 0;
      int i = 0;
      k = i;
      if (j < ((ArrayList)localObject).size())
      {
        r localr = (r)((ArrayList)localObject).get(j);
        if (((localr.kqi != null) && (localr.kqi.equals(paramView.kqi))) || ((TextUtils.isEmpty(localr.kqi)) && (TextUtils.isEmpty(paramView.kqi))))
        {
          localr.kql = true;
          if (!localr.kqm)
          {
            localr.kqm = true;
            i = 1;
          }
          ((ArrayList)localObject).set(j, localr);
        }
        for (;;)
        {
          j += 1;
          break;
          localr.kql = false;
          ((ArrayList)localObject).set(j, localr);
        }
      }
    }
    else
    {
      k = 0;
    }
    paramView = (String)paramView.kqk.get(0);
    paramView = am.bcl().HZ(paramView);
    if (paramView != null) {
      this.kBP.kBh.b(paramView);
    }
    if ((k != 0) && (this.kBP.kBh.bdB() != null)) {
      this.kBP.kBh.bdB().bdo();
    }
    this.kBP.kBM.setVisibility(8);
    AppMethodBeat.o(88784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.x.1
 * JD-Core Version:    0.7.0.1
 */