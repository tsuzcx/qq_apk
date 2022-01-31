package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.d.a;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.ui.base.h;

public class CardInvalidCardUI
  extends CardBaseUI
{
  public final void bax()
  {
    AppMethodBeat.i(88540);
    setMMTitle(2131297954);
    addTextOptionMenu(0, getString(2131297876), new CardInvalidCardUI.1(this));
    if (this.kkG.getCount() > 0)
    {
      enableOptionMenu(true);
      AppMethodBeat.o(88540);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(88540);
  }
  
  public final n.a bay()
  {
    return n.a.kob;
  }
  
  public int getLayoutId()
  {
    return 2130968959;
  }
  
  public void initView()
  {
    AppMethodBeat.i(138536);
    super.initView();
    AppMethodBeat.o(138536);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88538);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(88538);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(88541);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof r)))
    {
      if (!this.kkK) {
        break label62;
      }
      h.bO(this, getResources().getString(2131297878));
    }
    for (;;)
    {
      this.kkK = false;
      AppMethodBeat.o(88541);
      return;
      label62:
      h.bO(this, getResources().getString(2131297896));
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