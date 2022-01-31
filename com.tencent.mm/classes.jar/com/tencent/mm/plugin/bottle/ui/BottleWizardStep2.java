package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.model.bn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;

public class BottleWizardStep2
  extends MMPreference
{
  private c hZL;
  
  private void goBack()
  {
    Intent localIntent = new Intent().setClass(this, BottleWizardStep1.class);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    XM();
    finish();
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_district")) {
      return this.hZL.awV();
    }
    if (paramf.equals("settings_signature")) {
      return this.hZL.awU();
    }
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.settings_personal_info);
    this.hZL = new c(this, this.vdd);
    setBackBtn(new BottleWizardStep2.1(this));
    addTextOptionMenu(0, getString(R.l.app_nextstep), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        c.awT();
        paramAnonymousMenuItem = bn.Id();
        if (bk.a(Integer.valueOf(paramAnonymousMenuItem.sex), 0) <= 0)
        {
          h.b(BottleWizardStep2.this.mController.uMN, BottleWizardStep2.this.getString(R.l.bottle_settings_change_info_err_sex), BottleWizardStep2.this.getString(R.l.app_tip), true);
          return true;
        }
        if (bk.bl(paramAnonymousMenuItem.getProvince()))
        {
          h.b(BottleWizardStep2.this.mController.uMN, BottleWizardStep2.this.getString(R.l.bottle_settings_change_info_err_district), BottleWizardStep2.this.getString(R.l.app_tip), true);
          return true;
        }
        paramAnonymousMenuItem = new Intent().setClass(BottleWizardStep2.this, BottleBeachUI.class);
        paramAnonymousMenuItem.addFlags(67108864);
        BottleWizardStep2.this.startActivity(paramAnonymousMenuItem);
        BottleWizardStep2.this.finish();
        return true;
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.hZL.update();
  }
  
  public final int xj()
  {
    return R.o.bottle_wizard_step2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleWizardStep2
 * JD-Core Version:    0.7.0.1
 */