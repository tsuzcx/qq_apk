package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.plugin.report.service.h;
import java.util.List;

final class FavSearchUI$9
  extends c
{
  FavSearchUI$9(FavSearchUI paramFavSearchUI, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void CW(String paramString)
  {
    FavSearchActionView localFavSearchActionView = FavSearchUI.b(this.kcM);
    localFavSearchActionView.kjD.add(paramString);
    if (localFavSearchActionView.kdq == null) {}
    do
    {
      return;
      localFavSearchActionView.kdq.setEditHint("");
      localFavSearchActionView.kdq.bH(paramString, true);
    } while (localFavSearchActionView.kjF == null);
    localFavSearchActionView.Dd(localFavSearchActionView.kdq.getEditText());
    localFavSearchActionView.kjF.a(localFavSearchActionView.keI, localFavSearchActionView.kjE, localFavSearchActionView.kjD, false);
    h.nFQ.f(11126, new Object[] { Integer.valueOf(2) });
  }
  
  protected final void CX(String paramString)
  {
    FavSearchActionView localFavSearchActionView = FavSearchUI.b(this.kcM);
    localFavSearchActionView.kjD.remove(paramString);
    if (localFavSearchActionView.kdq == null) {}
    do
    {
      return;
      if (localFavSearchActionView.kjD.isEmpty()) {
        localFavSearchActionView.kdq.setEditHint(localFavSearchActionView.getResources().getString(n.i.app_search));
      }
      localFavSearchActionView.kdq.removeTag(paramString);
    } while (localFavSearchActionView.kjF == null);
    localFavSearchActionView.Dd(localFavSearchActionView.kdq.getEditText());
    localFavSearchActionView.kjF.a(localFavSearchActionView.keI, localFavSearchActionView.kjE, localFavSearchActionView.kjD, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.9
 * JD-Core Version:    0.7.0.1
 */