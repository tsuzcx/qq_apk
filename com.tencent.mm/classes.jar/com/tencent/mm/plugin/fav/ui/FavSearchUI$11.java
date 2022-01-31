package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Iterator;
import java.util.List;

final class FavSearchUI$11
  implements AdapterView.OnItemClickListener
{
  FavSearchUI$11(FavSearchUI paramFavSearchUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, final int paramInt, long paramLong)
  {
    AppMethodBeat.i(74083);
    final a.b localb = (a.b)paramView.getTag();
    if ((localb != null) && (localb.muk != null))
    {
      this.mxx.mxv.mxI = true;
      FavSearchUI.a(this.mxx, paramInt, localb.muk.field_id);
    }
    if (1 == FavSearchUI.i(this.mxx))
    {
      if (localb == null)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavSearchUI", "on item click, holder is null");
        AppMethodBeat.o(74083);
        return;
      }
      if (localb.muk == null)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavSearchUI", "on item click, info is null");
        AppMethodBeat.o(74083);
        return;
      }
      ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.fav.a.ab.class)).a(this.mxx.getContext(), FavSearchUI.j(this.mxx), localb.muk, false, new FavSearchUI.11.1(this, localb));
      AppMethodBeat.o(74083);
      return;
    }
    if (2 == FavSearchUI.i(this.mxx))
    {
      if (localb == null)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavSearchUI", "on item click, holder is null");
        AppMethodBeat.o(74083);
        return;
      }
      if (localb.muk == null)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavSearchUI", "on item click, info is null");
        AppMethodBeat.o(74083);
        return;
      }
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("key_fav_result_local_id", localb.muk.field_localId);
      this.mxx.setResult(-1, paramAdapterView);
      this.mxx.finish();
      AppMethodBeat.o(74083);
      return;
    }
    FavSearchUI.g(this.mxx).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    if (localb.muk != null) {
      com.tencent.mm.kernel.g.RO().ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74082);
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.FavSearchUI", "type %s", new Object[] { Integer.valueOf(localb.muk.field_type) });
          long l = localb.muk.field_localId;
          if (FavSearchUI.k(FavSearchUI.11.this.mxx).size() == 0) {
            FavSearchUI.a(FavSearchUI.11.this.mxx, ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().bwS());
          }
          if (FavSearchUI.k(FavSearchUI.11.this.mxx).size() != 0)
          {
            localObject = FavSearchUI.k(FavSearchUI.11.this.mxx).iterator();
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
          Object localObject = h.qsU;
          int j = localb.muk.field_type;
          int k = FavSearchUI.l(FavSearchUI.11.this.mxx);
          if (FavSearchUI.k(FavSearchUI.11.this.mxx).size() == 0) {
            i = paramInt;
          }
          ((h)localObject).e(12746, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
          AppMethodBeat.o(74082);
        }
      });
    }
    AppMethodBeat.o(74083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.11
 * JD-Core Version:    0.7.0.1
 */