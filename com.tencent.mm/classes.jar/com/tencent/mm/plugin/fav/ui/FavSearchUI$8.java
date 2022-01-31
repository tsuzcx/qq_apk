package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class FavSearchUI$8
  implements FavSearchActionView.a
{
  FavSearchUI$8(FavSearchUI paramFavSearchUI) {}
  
  public final void a(String paramString, List<Integer> paramList, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(74075);
    FavSearchUI.b(this.mxx).post(new FavSearchUI.8.1(this, paramList1, paramList2, paramList));
    if (paramString != null) {
      FavSearchUI.a(this.mxx, paramString);
    }
    while (FavSearchUI.g(this.mxx) != null)
    {
      paramString = FavSearchUI.g(this.mxx);
      paramList = FavSearchUI.h(this.mxx);
      if (paramList != null)
      {
        paramString.query = paramList;
        AppMethodBeat.o(74075);
        return;
        FavSearchUI.a(this.mxx, "");
      }
      else
      {
        paramString.query = "";
      }
    }
    AppMethodBeat.o(74075);
  }
  
  public final void a(List<Integer> paramList, List<String> paramList1, List<String> paramList2, boolean paramBoolean)
  {
    AppMethodBeat.i(74074);
    if ((paramList1.isEmpty()) && (paramList2.isEmpty()) && (FavSearchUI.e(this.mxx)))
    {
      FavSearchUI.a(this.mxx, true);
      FavSearchUI.a(this.mxx, paramList1, paramList2);
      AppMethodBeat.o(74074);
      return;
    }
    ab.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", new Object[] { paramList, paramList1, paramList2 });
    FavSearchUI.b(this.mxx, paramList1);
    FavSearchUI.c(this.mxx, paramList2);
    FavSearchUI.d(this.mxx, paramList);
    FavSearchUI.f(this.mxx).bN(paramList2);
    if (paramBoolean)
    {
      FavSearchUI.d(this.mxx);
      FavSearchUI.a(this.mxx, paramList1, paramList2);
      AppMethodBeat.o(74074);
      return;
    }
    FavSearchUI.g(this.mxx).c(paramList, paramList1, paramList2);
    FavSearchUI.b(this.mxx, true);
    FavSearchUI.a(this.mxx, paramList1, paramList2);
    AppMethodBeat.o(74074);
  }
  
  public final void apO()
  {
    AppMethodBeat.i(74073);
    ab.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
    FavSearchUI.d(this.mxx);
    AppMethodBeat.o(74073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.8
 * JD-Core Version:    0.7.0.1
 */