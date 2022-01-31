package com.tencent.mm.plugin.fav.ui;

import android.util.SparseArray;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.c.yt;
import com.tencent.mm.protocal.c.yu;
import com.tencent.mm.protocal.c.yv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTagPanel.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class FavTagEditUI$5
  implements MMTagPanel.a
{
  FavTagEditUI$5(FavTagEditUI paramFavTagEditUI) {}
  
  public final void Bc(String paramString)
  {
    FavTagEditUI.d(this.kdx).removeTag(paramString);
    FavTagEditUI.f(this.kdx).Db(paramString);
    if (FavTagEditUI.g(this.kdx) != null) {
      FavTagEditUI.g(this.kdx).bI(paramString, false);
    }
    FavTagEditUI.c(this.kdx);
  }
  
  public final void Bd(String paramString) {}
  
  public final void Be(String paramString)
  {
    FavTagEditUI.d(this.kdx).removeTag(paramString);
    FavTagEditUI.f(this.kdx).Db(paramString);
    if (FavTagEditUI.g(this.kdx) != null) {
      FavTagEditUI.g(this.kdx).bI(paramString, false);
    }
    FavTagEditUI.c(this.kdx);
  }
  
  public final void Bf(String paramString)
  {
    if (!bk.bl(paramString))
    {
      d locald = FavTagEditUI.h(this.kdx);
      locald.keX.clear();
      locald.keW.clear();
      locald.iSX = bk.aM(paramString, "");
      Object localObject = ((ae)g.t(ae.class)).getFavTagSetMgr();
      boolean bool = bk.bl(paramString);
      ArrayList localArrayList = new ArrayList(16);
      localObject = ((l)localObject).jZb.sXo.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Iterator localIterator = ((yu)((Iterator)localObject).next()).sXn.iterator();
        while (localIterator.hasNext())
        {
          yt localyt = (yt)localIterator.next();
          if ((bool) || (localyt.rtH.contains(paramString))) {
            localArrayList.add(localyt.rtH);
          }
        }
      }
      locald.keW.addAll(localArrayList);
      locald.notifyDataSetChanged();
      FavTagEditUI.i(this.kdx).setVisibility(0);
      FavTagEditUI.j(this.kdx).setVisibility(8);
    }
    for (;;)
    {
      FavTagEditUI.c(this.kdx);
      return;
      FavTagEditUI.i(this.kdx).setVisibility(8);
      FavTagEditUI.j(this.kdx).setVisibility(0);
    }
  }
  
  public final void Bg(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
      return;
    }
    FavTagEditUI.d(this.kdx).bH(paramString, true);
    FavTagEditUI.c(this.kdx);
  }
  
  public final void aJI() {}
  
  public final void i(boolean paramBoolean, int paramInt)
  {
    FavTagEditUI.a(this.kdx, paramBoolean);
    TextView localTextView = FavTagEditUI.k(this.kdx);
    if ((FavTagEditUI.b(this.kdx)) && (paramInt > 0)) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      FavTagEditUI.k(this.kdx).setText(this.kdx.getString(n.i.favorite_tag_edit_max_length_tips, new Object[] { Integer.valueOf(paramInt) }));
      FavTagEditUI.c(this.kdx);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTagEditUI.5
 * JD-Core Version:    0.7.0.1
 */