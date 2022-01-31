package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class FavSearchUI$8
  implements FavSearchActionView.a
{
  FavSearchUI$8(FavSearchUI paramFavSearchUI) {}
  
  public final void Wm()
  {
    y.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
    FavSearchUI.d(this.kcM);
  }
  
  public final void a(String paramString, List<Integer> paramList, List<String> paramList1, List<String> paramList2)
  {
    FavSearchUI.b(this.kcM).post(new FavSearchUI.8.1(this, paramList1, paramList2, paramList));
    if (paramString != null) {
      FavSearchUI.a(this.kcM, paramString);
    }
    for (;;)
    {
      if (FavSearchUI.g(this.kcM) != null)
      {
        paramString = FavSearchUI.g(this.kcM);
        paramList = FavSearchUI.h(this.kcM);
        if (paramList == null) {
          break;
        }
        paramString.bVk = paramList;
      }
      return;
      FavSearchUI.a(this.kcM, "");
    }
    paramString.bVk = "";
  }
  
  public final void a(List<Integer> paramList, List<String> paramList1, List<String> paramList2, boolean paramBoolean)
  {
    if ((paramList1.isEmpty()) && (paramList2.isEmpty()) && (FavSearchUI.e(this.kcM)))
    {
      FavSearchUI.a(this.kcM, true);
      FavSearchUI.a(this.kcM, paramList1, paramList2);
      return;
    }
    y.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", new Object[] { paramList, paramList1, paramList2 });
    FavSearchUI.b(this.kcM, paramList1);
    FavSearchUI.c(this.kcM, paramList2);
    FavSearchUI.d(this.kcM, paramList);
    FavSearchUI.f(this.kcM).bt(paramList2);
    if (paramBoolean)
    {
      FavSearchUI.d(this.kcM);
      FavSearchUI.a(this.kcM, paramList1, paramList2);
      return;
    }
    FavSearchUI.g(this.kcM).b(paramList, paramList1, paramList2);
    FavSearchUI.b(this.kcM, true);
    FavSearchUI.a(this.kcM, paramList1, paramList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.8
 * JD-Core Version:    0.7.0.1
 */