package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;
import java.util.List;

final class f$d$4$3
  implements n.d
{
  f$d$4$3(f.d.4 param4, f.c paramc, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(74574);
    String str = b.b(this.mCH.mCt.cuZ);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74574);
      return;
      paramMenuItem = new ArrayList();
      paramMenuItem.add(this.mCH.mCt);
      this.mCG.mCF.mCs.mCp.bP(paramMenuItem);
      AppMethodBeat.o(74574);
      return;
      h.i(this.mCH.mCt.mCk.field_localId, 0, 0);
      b.d(str, this.mCG.mCF.mCs.mContext);
      AppMethodBeat.o(74574);
      return;
      if (bo.isNullOrNil(str))
      {
        ab.w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
        AppMethodBeat.o(74574);
        return;
      }
      if (!this.mCH.mCu)
      {
        if (!q.a(str, this.mCG.mCF.mCs.mContext, 2131298889))
        {
          Toast.makeText(this.mCG.mCF.mCs.mContext, this.mCG.mCF.mCs.mContext.getString(2131299818), 1).show();
          AppMethodBeat.o(74574);
        }
      }
      else
      {
        paramMenuItem = u.vs(str);
        ab.i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", new Object[] { str, paramMenuItem });
        if (bo.isNullOrNil(paramMenuItem))
        {
          Toast.makeText(this.mCG.mCF.mCs.mContext, this.mCG.mCF.mCs.mContext.getString(2131304521), 1).show();
          AppMethodBeat.o(74574);
          return;
        }
        Toast.makeText(this.mCG.mCF.mCs.mContext, this.mCG.mCF.mCs.mContext.getString(2131304522, new Object[] { paramMenuItem }), 1).show();
        n.a(paramMenuItem, this.mCG.mCF.mCs.mContext);
        AppMethodBeat.o(74574);
        return;
        this.mCG.mCF.mCs.mBU.index = (this.mCG.mCF.mCs.getItemCount() - this.gxr);
        ((y)com.tencent.mm.kernel.g.E(y.class)).a(this.mCG.mCF.mCs.mContext, this.mCH.mCt.mCk, this.mCG.mCF.mCs.mBU);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d.4.3
 * JD-Core Version:    0.7.0.1
 */