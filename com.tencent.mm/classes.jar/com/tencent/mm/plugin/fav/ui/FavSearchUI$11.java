package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.List;

final class FavSearchUI$11
  implements AdapterView.OnItemClickListener
{
  FavSearchUI$11(FavSearchUI paramFavSearchUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, final int paramInt, long paramLong)
  {
    final a.b localb = (a.b)paramView.getTag();
    if ((localb != null) && (localb.jZN != null))
    {
      this.kcM.kcK.kcX = true;
      FavSearchUI.a(this.kcM, paramInt, localb.jZN.field_id);
    }
    if (1 == FavSearchUI.i(this.kcM)) {
      if (localb == null) {
        y.w("MicroMsg.FavSearchUI", "on item click, holder is null");
      }
    }
    do
    {
      return;
      if (localb.jZN == null)
      {
        y.w("MicroMsg.FavSearchUI", "on item click, info is null");
        return;
      }
      ((ab)com.tencent.mm.kernel.g.r(ab.class)).a(this.kcM.mController.uMN, FavSearchUI.j(this.kcM), localb.jZN, n.i.app_send, false, new FavSearchUI.11.1(this, localb));
      return;
      if (2 == FavSearchUI.i(this.kcM))
      {
        if (localb == null)
        {
          y.w("MicroMsg.FavSearchUI", "on item click, holder is null");
          return;
        }
        if (localb.jZN == null)
        {
          y.w("MicroMsg.FavSearchUI", "on item click, info is null");
          return;
        }
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("key_fav_result_local_id", localb.jZN.field_localId);
        this.kcM.setResult(-1, paramAdapterView);
        this.kcM.finish();
        return;
      }
      FavSearchUI.g(this.kcM).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    } while (localb.jZN == null);
    com.tencent.mm.kernel.g.DS().O(new Runnable()
    {
      public final void run()
      {
        y.d("MicroMsg.FavSearchUI", "type %s", new Object[] { Integer.valueOf(localb.jZN.field_type) });
        long l = localb.jZN.field_localId;
        if (FavSearchUI.k(FavSearchUI.11.this.kcM).size() == 0) {
          FavSearchUI.a(FavSearchUI.11.this.kcM, ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().aQD());
        }
        if (FavSearchUI.k(FavSearchUI.11.this.kcM).size() != 0)
        {
          localObject = FavSearchUI.k(FavSearchUI.11.this.kcM).iterator();
          j = 1;
          for (;;)
          {
            i = j;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            i = j;
            if (((Long)((Iterator)localObject).next()).longValue() == l) {
              break;
            }
            j += 1;
          }
        }
        int i = 1;
        Object localObject = h.nFQ;
        int j = localb.jZN.field_type;
        int k = FavSearchUI.l(FavSearchUI.11.this.kcM);
        if (FavSearchUI.k(FavSearchUI.11.this.kcM).size() == 0) {
          i = paramInt;
        }
        ((h)localObject).f(12746, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.11
 * JD-Core Version:    0.7.0.1
 */