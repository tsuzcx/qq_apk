package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.preference.AppBrandAuthPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AppBrandAuthorizeDetailUI
  extends MMPreference
{
  private int mAT;
  private boolean nRl = false;
  private f nRm;
  private Preference nRn;
  private AppBrandAuthPreference nRo;
  private AppBrandAuthPreference nRp;
  private AppBrandAuthPreference nRq;
  
  private void bWK()
  {
    AppMethodBeat.i(48524);
    if (this.nRl)
    {
      Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", new Object[] { Integer.valueOf(this.mAT) });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_result_state", this.mAT);
      setResult(-1, localIntent);
      AppMethodBeat.o(48524);
      return;
    }
    setResult(0, null);
    AppMethodBeat.o(48524);
  }
  
  public int getResourceId()
  {
    return 2132017159;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48523);
    bWK();
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
    if ((getIntent() != null) && (!Util.isNullOrNil(getIntent().getStringExtra("key_title"))))
    {
      setMMTitle(getIntent().getStringExtra("key_title"));
      this.nRm = getPreferenceScreen();
      this.nRm.removeAll();
      if ((getIntent() == null) || (Util.isNullOrNil(getIntent().getStringExtra("key_desc")))) {
        break label420;
      }
      paramBundle = getIntent().getStringExtra("key_desc");
      paramBundle = String.format(getString(2131755376), new Object[] { paramBundle });
      if (!Util.isNullOrNil(paramBundle))
      {
        this.nRn = new Preference(this);
        this.nRn.setTitle(paramBundle);
        this.nRn.setLayoutResource(2131493065);
        this.nRm.c(this.nRn);
      }
      this.nRo = new AppBrandAuthPreference(this);
      this.nRo.setKey("none");
      this.nRo.wd(2131755370);
      this.nRm.c(this.nRo);
      this.nRp = new AppBrandAuthPreference(this);
      this.nRp.setKey("foreground");
      this.nRp.wd(2131755369);
      this.nRm.c(this.nRp);
      if (getIntent() == null) {
        break label425;
      }
      bool = getIntent().getBooleanExtra("key_three_state", false);
      label282:
      if (bool)
      {
        this.nRq = new AppBrandAuthPreference(this);
        this.nRq.setKey("both");
        this.nRq.wd(2131755368);
        this.nRm.c(this.nRq);
      }
      if ((getIntent() != null) && (getIntent().hasExtra("key_state"))) {
        this.mAT = getIntent().getIntExtra("key_state", 0);
      }
      switch (this.mAT)
      {
      default: 
        this.nRo.setChecked(true);
      }
    }
    for (;;)
    {
      this.nRm.notifyDataSetChanged();
      AppMethodBeat.o(48522);
      return;
      setMMTitle(2131755372);
      break;
      label420:
      paramBundle = null;
      break label129;
      label425:
      bool = false;
      break label282;
      if (this.nRq != null)
      {
        this.nRq.setChecked(true);
        continue;
        this.nRp.setChecked(true);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(48525);
    Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", new Object[] { paramPreference.mKey });
    if ((paramPreference instanceof AppBrandAuthPreference))
    {
      this.nRl = true;
      if (!paramPreference.mKey.equalsIgnoreCase("both")) {
        break label99;
      }
      this.mAT = 2;
      this.nRo.setChecked(false);
      this.nRp.setChecked(false);
      if (this.nRq != null) {
        this.nRq.setChecked(true);
      }
    }
    for (;;)
    {
      this.nRm.notifyDataSetChanged();
      AppMethodBeat.o(48525);
      return false;
      label99:
      if (paramPreference.mKey.equalsIgnoreCase("foreground"))
      {
        this.mAT = 1;
        this.nRp.setChecked(true);
        this.nRo.setChecked(false);
        if (this.nRq != null) {
          this.nRq.setChecked(false);
        }
      }
      else
      {
        this.mAT = 0;
        this.nRo.setChecked(true);
        this.nRp.setChecked(false);
        if (this.nRq != null) {
          this.nRq.setChecked(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeDetailUI
 * JD-Core Version:    0.7.0.1
 */