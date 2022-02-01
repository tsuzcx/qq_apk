package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.preference.AppBrandAuthPreference;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AppBrandAuthorizeDetailUI
  extends MMPreference
{
  private int lur;
  private AppBrandAuthPreference mEA;
  private AppBrandAuthPreference mEB;
  private boolean mEw = false;
  private f mEx;
  private Preference mEy;
  private AppBrandAuthPreference mEz;
  
  private void bzP()
  {
    AppMethodBeat.i(48524);
    if (this.mEw)
    {
      ae.i("MicroMsg.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", new Object[] { Integer.valueOf(this.lur) });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_result_state", this.lur);
      setResult(-1, localIntent);
      AppMethodBeat.o(48524);
      return;
    }
    setResult(0, null);
    AppMethodBeat.o(48524);
  }
  
  public int getResourceId()
  {
    return 2131951623;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48523);
    bzP();
    super.onBackPressed();
    AppMethodBeat.o(48523);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48522);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48521);
        AppBrandAuthorizeDetailUI.a(AppBrandAuthorizeDetailUI.this);
        AppBrandAuthorizeDetailUI.this.finish();
        AppMethodBeat.o(48521);
        return false;
      }
    });
    label129:
    boolean bool;
    if ((getIntent() != null) && (!bu.isNullOrNil(getIntent().getStringExtra("key_title"))))
    {
      setMMTitle(getIntent().getStringExtra("key_title"));
      this.mEx = getPreferenceScreen();
      this.mEx.removeAll();
      if ((getIntent() == null) || (bu.isNullOrNil(getIntent().getStringExtra("key_desc")))) {
        break label420;
      }
      paramBundle = getIntent().getStringExtra("key_desc");
      paramBundle = String.format(getString(2131755339), new Object[] { paramBundle });
      if (!bu.isNullOrNil(paramBundle))
      {
        this.mEy = new Preference(this);
        this.mEy.setTitle(paramBundle);
        this.mEy.setLayoutResource(2131493026);
        this.mEx.b(this.mEy);
      }
      this.mEz = new AppBrandAuthPreference(this);
      this.mEz.setKey("none");
      this.mEz.sh(2131755333);
      this.mEx.b(this.mEz);
      this.mEA = new AppBrandAuthPreference(this);
      this.mEA.setKey("foreground");
      this.mEA.sh(2131755332);
      this.mEx.b(this.mEA);
      if (getIntent() == null) {
        break label425;
      }
      bool = getIntent().getBooleanExtra("key_three_state", false);
      label282:
      if (bool)
      {
        this.mEB = new AppBrandAuthPreference(this);
        this.mEB.setKey("both");
        this.mEB.sh(2131755331);
        this.mEx.b(this.mEB);
      }
      if ((getIntent() != null) && (getIntent().hasExtra("key_state"))) {
        this.lur = getIntent().getIntExtra("key_state", 0);
      }
      switch (this.lur)
      {
      default: 
        this.mEz.setChecked(true);
      }
    }
    for (;;)
    {
      this.mEx.notifyDataSetChanged();
      AppMethodBeat.o(48522);
      return;
      setMMTitle(2131755335);
      break;
      label420:
      paramBundle = null;
      break label129;
      label425:
      bool = false;
      break label282;
      if (this.mEB != null)
      {
        this.mEB.setChecked(true);
        continue;
        this.mEA.setChecked(true);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(48525);
    ae.i("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", new Object[] { paramPreference.mKey });
    if ((paramPreference instanceof AppBrandAuthPreference))
    {
      this.mEw = true;
      if (!paramPreference.mKey.equalsIgnoreCase("both")) {
        break label99;
      }
      this.lur = 2;
      this.mEz.setChecked(false);
      this.mEA.setChecked(false);
      if (this.mEB != null) {
        this.mEB.setChecked(true);
      }
    }
    for (;;)
    {
      this.mEx.notifyDataSetChanged();
      AppMethodBeat.o(48525);
      return false;
      label99:
      if (paramPreference.mKey.equalsIgnoreCase("foreground"))
      {
        this.lur = 1;
        this.mEA.setChecked(true);
        this.mEz.setChecked(false);
        if (this.mEB != null) {
          this.mEB.setChecked(false);
        }
      }
      else
      {
        this.lur = 0;
        this.mEz.setChecked(true);
        this.mEA.setChecked(false);
        if (this.mEB != null) {
          this.mEB.setChecked(false);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeDetailUI
 * JD-Core Version:    0.7.0.1
 */