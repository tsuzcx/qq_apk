package com.tencent.mm.plugin.fav.ui;

import android.util.SparseArray;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.adb;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTagPanel.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class FavTagEditUI$5
  implements MMTagPanel.a
{
  FavTagEditUI$5(FavTagEditUI paramFavTagEditUI) {}
  
  public final void Le(String paramString)
  {
    AppMethodBeat.i(74141);
    FavTagEditUI.d(this.myh).removeTag(paramString);
    FavTagEditUI.f(this.myh).Od(paramString);
    if (FavTagEditUI.g(this.myh) != null) {
      FavTagEditUI.g(this.myh).ck(paramString, false);
    }
    FavTagEditUI.c(this.myh);
    AppMethodBeat.o(74141);
  }
  
  public final void Lf(String paramString) {}
  
  public final void Lg(String paramString)
  {
    AppMethodBeat.i(74142);
    FavTagEditUI.d(this.myh).removeTag(paramString);
    FavTagEditUI.f(this.myh).Od(paramString);
    if (FavTagEditUI.g(this.myh) != null) {
      FavTagEditUI.g(this.myh).ck(paramString, false);
    }
    FavTagEditUI.c(this.myh);
    AppMethodBeat.o(74142);
  }
  
  public final void Lh(String paramString)
  {
    AppMethodBeat.i(74143);
    if (!bo.isNullOrNil(paramString))
    {
      d locald = FavTagEditUI.h(this.myh);
      locald.mzG.clear();
      locald.mzF.clear();
      locald.lbI = bo.bf(paramString, "");
      Object localObject = ((ae)g.G(ae.class)).getFavTagSetMgr();
      boolean bool = bo.isNullOrNil(paramString);
      ArrayList localArrayList = new ArrayList(16);
      localObject = ((l)localObject).mtt.wVo.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Iterator localIterator = ((adb)((Iterator)localObject).next()).wVn.iterator();
        while (localIterator.hasNext())
        {
          ada localada = (ada)localIterator.next();
          if ((bool) || (localada.smP.contains(paramString))) {
            localArrayList.add(localada.smP);
          }
        }
      }
      locald.mzF.addAll(localArrayList);
      locald.notifyDataSetChanged();
      FavTagEditUI.i(this.myh).setVisibility(0);
      FavTagEditUI.j(this.myh).setVisibility(8);
    }
    for (;;)
    {
      FavTagEditUI.c(this.myh);
      AppMethodBeat.o(74143);
      return;
      FavTagEditUI.i(this.myh).setVisibility(8);
      FavTagEditUI.j(this.myh).setVisibility(0);
    }
  }
  
  public final void Li(String paramString)
  {
    AppMethodBeat.i(74144);
    if (bo.isNullOrNil(paramString))
    {
      ab.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
      AppMethodBeat.o(74144);
      return;
    }
    FavTagEditUI.d(this.myh).cj(paramString, true);
    FavTagEditUI.c(this.myh);
    AppMethodBeat.o(74144);
  }
  
  public final void bnq() {}
  
  public final void t(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(74145);
    FavTagEditUI.a(this.myh, paramBoolean);
    TextView localTextView = FavTagEditUI.k(this.myh);
    if ((FavTagEditUI.b(this.myh)) && (paramInt > 0)) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      FavTagEditUI.k(this.myh).setText(this.myh.getString(2131299845, new Object[] { Integer.valueOf(paramInt) }));
      FavTagEditUI.c(this.myh);
      AppMethodBeat.o(74145);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI.5
 * JD-Core Version:    0.7.0.1
 */