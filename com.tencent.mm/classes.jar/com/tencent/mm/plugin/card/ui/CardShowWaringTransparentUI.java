package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CardShowWaringTransparentUI
  extends MMActivity
{
  protected final int getLayoutId()
  {
    return a.e.card_show_warning_transparent_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("KEY_BRAND_NAME");
    h.a(this, getString(a.g.card_third_party_disclaimer_content, new Object[] { paramBundle }), getString(a.g.card_third_party_disclaimer_title), getString(a.g.card_iknow), new CardShowWaringTransparentUI.1(this));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      finish();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShowWaringTransparentUI
 * JD-Core Version:    0.7.0.1
 */