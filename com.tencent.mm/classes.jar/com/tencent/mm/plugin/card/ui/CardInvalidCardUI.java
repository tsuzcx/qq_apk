package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.d.a;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.ui.base.h;

public class CardInvalidCardUI
  extends CardBaseUI
{
  public final void bUv()
  {
    AppMethodBeat.i(113467);
    setMMTitle(2131756896);
    addTextOptionMenu(0, getString(2131756808), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113463);
        CardInvalidCardUI.a(CardInvalidCardUI.this);
        AppMethodBeat.o(113463);
        return true;
      }
    });
    if (this.oCI.getCount() > 0)
    {
      enableOptionMenu(true);
      AppMethodBeat.o(113467);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(113467);
  }
  
  public final n.a bUw()
  {
    return n.a.oGl;
  }
  
  public int getLayoutId()
  {
    return 2131493310;
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(113468);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof r)))
    {
      if (!this.oCM) {
        break label62;
      }
      h.cm(this, getResources().getString(2131756810));
    }
    for (;;)
    {
      this.oCM = false;
      AppMethodBeat.o(113468);
      return;
      label62:
      h.cm(this, getResources().getString(2131756828));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardInvalidCardUI
 * JD-Core Version:    0.7.0.1
 */