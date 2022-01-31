package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
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
    if (!(paramView.getTag() instanceof r)) {}
    do
    {
      return;
      localObject = this.iyI.iya.aBE();
      this.iyI.iya.aBG();
      paramView = (r)paramView.getTag();
    } while ((paramView == null) || (paramView.ipc == null) || (paramView.ipc.isEmpty()));
    if ((paramView.ipb != null) && (paramView.ipb.equals(((com.tencent.mm.plugin.card.base.b)localObject).azD())))
    {
      this.iyI.iyF.setVisibility(8);
      this.iyI.iya.aAW();
      return;
    }
    if ((TextUtils.isEmpty(paramView.ipb)) && (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).azD())))
    {
      this.iyI.iyF.setVisibility(8);
      this.iyI.iya.aAW();
      return;
    }
    Object localObject = com.tencent.mm.plugin.card.sharecard.a.b.yr(paramView.iln);
    int k;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int j = 0;
      int i = 0;
      k = i;
      if (j < ((ArrayList)localObject).size())
      {
        r localr = (r)((ArrayList)localObject).get(j);
        if (((localr.ipb != null) && (localr.ipb.equals(paramView.ipb))) || ((TextUtils.isEmpty(localr.ipb)) && (TextUtils.isEmpty(paramView.ipb))))
        {
          localr.ipd = true;
          if (!localr.ipe)
          {
            localr.ipe = true;
            i = 1;
          }
          ((ArrayList)localObject).set(j, localr);
        }
        for (;;)
        {
          j += 1;
          break;
          localr.ipd = false;
          ((ArrayList)localObject).set(j, localr);
        }
      }
    }
    else
    {
      k = 0;
    }
    paramView = (String)paramView.ipc.get(0);
    paramView = am.aAA().yy(paramView);
    if (paramView != null) {
      this.iyI.iya.b(paramView);
    }
    if ((k != 0) && (this.iyI.iya.aBK() != null)) {
      this.iyI.iya.aBK().aBx();
    }
    this.iyI.iyF.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.x.1
 * JD-Core Version:    0.7.0.1
 */