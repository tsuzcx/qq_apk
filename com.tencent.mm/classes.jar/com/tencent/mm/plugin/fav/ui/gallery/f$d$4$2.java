package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.r;

final class f$d$4$2
  implements View.OnCreateContextMenuListener
{
  f$d$4$2(f.d.4 param4, f.c paramc) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(74573);
    paramView = b.b(this.mCH.mCt.cuZ);
    boolean bool1 = e.cN(paramView);
    boolean bool2 = r.aoY(paramView);
    if ((!this.mCH.mCu) && (bool1) && (!bool2))
    {
      paramContextMenu.add(0, 0, 0, this.mCG.mCF.mCs.mContext.getString(2131299826));
      paramContextMenu.add(0, 1, 0, this.mCG.mCF.mCs.mContext.getString(2131299779));
      paramContextMenu.add(0, 2, 0, this.mCG.mCF.mCs.mContext.getString(2131299819));
    }
    for (;;)
    {
      paramContextMenu.add(0, 4, 0, this.mCG.mCF.mCs.mContext.getString(2131299738));
      AppMethodBeat.o(74573);
      return;
      if ((this.mCH.mCu) && (bool1) && (!bool2))
      {
        paramContextMenu.add(0, 0, 0, this.mCG.mCF.mCs.mContext.getString(2131299826));
        paramContextMenu.add(0, 2, 0, this.mCG.mCF.mCs.mContext.getString(2131302872));
      }
      else
      {
        ab.d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", new Object[] { Boolean.valueOf(this.mCH.mCu), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d.4.2
 * JD-Core Version:    0.7.0.1
 */