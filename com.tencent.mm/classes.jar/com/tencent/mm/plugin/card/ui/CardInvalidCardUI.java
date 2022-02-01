package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.c.d.a;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.ui.base.k;

public class CardInvalidCardUI
  extends CardBaseUI
{
  public final void djb()
  {
    AppMethodBeat.i(113467);
    setMMTitle(a.g.wpb);
    addTextOptionMenu(0, getString(a.g.card_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113463);
        CardInvalidCardUI.a(CardInvalidCardUI.this);
        AppMethodBeat.o(113463);
        return true;
      }
    });
    if (this.wqR.getCount() > 0)
    {
      enableOptionMenu(true);
      AppMethodBeat.o(113467);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(113467);
  }
  
  public final n.a djc()
  {
    return n.a.wur;
  }
  
  public int getLayoutId()
  {
    return a.e.wnf;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113466);
    super.initView();
    AppMethodBeat.o(113466);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113465);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(113465);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(113468);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof r)))
    {
      if (!this.wqV) {
        break label63;
      }
      k.cZ(this, getResources().getString(a.g.wol));
    }
    for (;;)
    {
      this.wqV = false;
      AppMethodBeat.o(113468);
      return;
      label63:
      k.cZ(this, getResources().getString(a.g.wox));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardInvalidCardUI
 * JD-Core Version:    0.7.0.1
 */