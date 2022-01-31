package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.ui.base.h;

public class CardInvalidCardUI
  extends CardBaseUI
{
  protected final void ayQ()
  {
    setMMTitle(a.g.card_invalid_card);
    addTextOptionMenu(0, getString(a.g.card_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        CardInvalidCardUI.a(CardInvalidCardUI.this);
        return true;
      }
    });
    if (this.ijG.getCount() > 0)
    {
      enableOptionMenu(true);
      return;
    }
    enableOptionMenu(false);
  }
  
  protected final n.a ayR()
  {
    return n.a.ing;
  }
  
  protected final int getLayoutId()
  {
    return a.e.card_invalid_card_ui;
  }
  
  protected final void initView()
  {
    super.initView();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.initView();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof r)))
    {
      if (!this.ijK) {
        break label53;
      }
      h.bC(this, getResources().getString(a.g.card_clear_success_tips));
    }
    for (;;)
    {
      this.ijK = false;
      return;
      label53:
      h.bC(this, getResources().getString(a.g.card_delete_success_tips));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardInvalidCardUI
 * JD-Core Version:    0.7.0.1
 */