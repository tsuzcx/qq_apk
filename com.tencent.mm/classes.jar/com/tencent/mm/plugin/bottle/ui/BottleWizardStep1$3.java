package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class BottleWizardStep1$3
  implements MenuItem.OnMenuItemClickListener
{
  BottleWizardStep1$3(BottleWizardStep1 paramBottleWizardStep1) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent().setClass(this.hZK, BottleWizardStep2.class);
    this.hZK.startActivity(paramMenuItem);
    this.hZK.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleWizardStep1.3
 * JD-Core Version:    0.7.0.1
 */