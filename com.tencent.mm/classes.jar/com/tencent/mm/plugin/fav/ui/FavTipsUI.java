package com.tencent.mm.plugin.fav.ui;

import android.os.Bundle;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public class FavTipsUI
  extends MMBaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new c.a(this);
    paramBundle.aez(getString(n.i.favorite_intro_title));
    paramBundle.aeA(getString(n.i.favorite_intro_p_1) + "\n\n" + getString(n.i.favorite_intro_p_2));
    paramBundle.Is(n.i.favorite_intro_btn).a(new FavTipsUI.1(this));
    paramBundle.e(new FavTipsUI.2(this));
    paramBundle.aoP().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTipsUI
 * JD-Core Version:    0.7.0.1
 */